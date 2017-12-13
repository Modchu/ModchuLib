package modchu.lib;

import java.util.List;
import java.util.Map;

public class Modchu_LMMManager {
	public static boolean isMMM;
	public static boolean isLMM;
	public static boolean isLMMX;
	public static boolean isLMMNX;
	public static boolean isLMR;

	static {
		boolean debug = false;
		List list = Modchu_CastHelper.List(Modchu_Main.isForge ? Modchu_Reflect.invokeMethod("Loader", "getActiveModList", Modchu_Reflect.invokeMethod("Loader", "instance")) : Modchu_Reflect.invokeMethod("ModLoader", "getLoadedMods"));
		String name = null;
		if (list != null
				&& !list.isEmpty()) {
			for (Object o1 : list) {
				name = Modchu_Main.isForge ? Modchu_CastHelper.String(Modchu_Reflect.invokeMethod("ModContainer", "getName", o1)) : o1.getClass().getSimpleName();
				Modchu_Debug.mDebug("Modchu_LMMManager getActiveModList name="+name);
				if (name.equals("mod_LMM_littleMaidMob")
						| name.equals("littleMaidMob")
						| name.equals("LittleMaidMob")) {
					isLMM = true;
					Modchu_Debug.lDebug("[Modchu_LMMManager] littleMaidMob Check ok.");
				}
				else if (name.equals("LittleMaidMobNX")) {
					isLMMNX = true;
					Modchu_Debug.lDebug("[Modchu_LMMManager] littleMaidMobNX Check ok.");
				}
				else if (name.equals("MMMLib")) {
					isMMM = true;
					Modchu_Debug.lDebug("[Modchu_LMMManager] MMMLib Check ok.");
				}
				else if (name.equals("MMMLibX")) {
					isMMM = true;
					isLMM = true;
					isLMMX = true;
					Modchu_Debug.lDebug("[Modchu_LMMManager] MMMLibX Check ok.");
				}
				else if (name.equals("LittleMaidReengaged")) {
					isMMM = true;
					isLMM = true;
					isLMR = true;
					Modchu_Debug.lDebug("[Modchu_LMMManager] LittleMaidReengaged Check ok.");
				}
			}
		}
	}

	public static Object getLmmTextureManagerTextures() {
		Object instance = getLmmTextureManagerInstance();
		return Modchu_Reflect.getFieldObject(instance.getClass(), "textures", instance);
	}

	public static void setLmmTextureManagerTextures(Object o) {
		Object instance = getLmmTextureManagerInstance();
		Modchu_Reflect.setFieldObject(instance.getClass(), "textures", instance, o);
	}

	public static Map getLmmTextureManagerModels() {
		Object instance = getLmmTextureManagerInstance();
		return Modchu_CastHelper.Map(Modchu_Main.getMinecraftVersion() > 169
				&& !isLMR
				&& !isLMMX ? Modchu_Reflect.getFieldObject(instance.getClass(), "models", instance) : Modchu_Reflect.getFieldObject(instance.getClass(), "modelMap", instance));
	}

	public static void setLmmTextureManagerModels(Map map) {
		Object instance = getLmmTextureManagerInstance();
		Modchu_Reflect.setFieldObject(instance.getClass(), Modchu_Main.getMinecraftVersion() > 169
				&& !isLMR
				&& !isLMMX ? "models" : "modelMap", instance, map);
	}

	public static Map getLmmTextureManagerModelNames() {
		if (Modchu_Main.getMinecraftVersion() < 170
				| isLMR
				| isLMMX) return null;
		Object instance = getLmmTextureManagerInstance();
		return Modchu_CastHelper.Map(Modchu_Reflect.getFieldObject(instance.getClass(), "modelNames", instance));
	}

	public static void setLmmTextureManagerModelNames(Map map) {
		if (Modchu_Main.getMinecraftVersion() < 170
				| isLMR
				| isLMMX) return;
		Object instance = getLmmTextureManagerInstance();
		Modchu_Reflect.setFieldObject(instance.getClass(), "modelNames", instance, map);
	}

	public static Object getLmmTextureManagerInstance() {
		String s = isLMR ? "net.blacklab.lmr.util.manager.ModelManager" :
			isLMMX ? "mmmlibx.lib.MMM_TextureManager" :
			Modchu_Main.getMinecraftVersion() > 169 ? "mmm.lib.multiModel.MultiModelManager" :
				"MMM_TextureManager";
		return Modchu_Reflect.getFieldObject(s, "instance", -1);
	}

	public static Class getModchuLmmModelClass() {
		return Modchu_Main.getModchuCharacteristicClass(isLMR ? "ModchuLmrModel" :
			isLMMX ? "ModchuLmmXModel" :
			"ModchuLmmModel");
	}

	public static Object[] getLMMTextureManagerModels(String s) {
		Map models = getLmmTextureManagerModels();
		return (Object[]) models.get(s);
	}

	public static Object[] getTextureBoxModels(Object ltb) {
		return ltb != null ? Modchu_CastHelper.ObjectArray(Modchu_Reflect.getFieldObject(ltb.getClass(), "models", ltb)) : null;
	}

	public static void setTextureBoxModels(Object ltb, Object[] o) {
		if (ltb != null) Modchu_Reflect.setFieldObject(ltb.getClass(), "models", ltb, o);
	}

	public static String getTextureBoxTextureName(Object ltb) {
		return ltb != null ? Modchu_CastHelper.String(Modchu_Reflect.getFieldObject(ltb.getClass(), "textureName", ltb)) : null;
	}

	public static Object newModchu_LmmTextureBox(Object mtb) {
		String Modchu_LmmTextureBoxString = Modchu_Main.getModchuCharacteristicClassName(Modchu_LMMManager.getModchuLmmTextureBoxString());
		Class ModchuModel_TextureBoxBase = (Class)Modchu_Reflect.loadClass("modchu.model.ModchuModel_TextureBoxBase", -1);
		return ModchuModel_TextureBoxBase != null ? Modchu_Reflect.newInstance(Modchu_LmmTextureBoxString, new Class[]{ ModchuModel_TextureBoxBase }, new Object[]{ Modchu_Reflect.invokeMethod(mtb.getClass(), "duplicate", mtb) }) : null;
	}

	public static String getLMMTextureName(Object entity) {
		int version = Modchu_Main.getMinecraftVersion();
		if (!isLMR
				&& !isLMMX
				&& version > 169) {
			Object multiModel = Modchu_Reflect.getFieldObject(entity.getClass(), "multiModel", entity, -1);
			if (multiModel != null) return Modchu_CastHelper.String(Modchu_Reflect.getFieldObject(multiModel.getClass(), "modelName", multiModel));
		} else {
			Object textureData = Modchu_Reflect.getFieldObject(entity.getClass(), "textureData", entity, -1);
			if (textureData != null) {
				Object[] textureBox = Modchu_CastHelper.ObjectArray(Modchu_Reflect.getFieldObject(textureData.getClass(), "textureBox", textureData));
				Class MMM_TextureBoxServer = getMMMTextureBoxServerClass();
				if (MMM_TextureBoxServer != null
						&& MMM_TextureBoxServer.isInstance(textureBox[0])); else {
					if (textureBox != null) return Modchu_CastHelper.String(Modchu_Reflect.getFieldObject(textureBox[0].getClass(), "textureName", textureBox[0], Modchu_Main.isRelease() ? -1 : 0));
				}
			}
		}
		return null;
	}

	public static String getLMMTextureArmorName(Object entity) {
		int version = Modchu_Main.getMinecraftVersion();
		if (!isLMR
				&& !isLMMX
				&& version > 169) {
			Object multiModel = Modchu_Reflect.getFieldObject(entity.getClass(), "multiModel", entity);
			if (multiModel != null) return Modchu_CastHelper.String(Modchu_Reflect.getFieldObject(multiModel.getClass(), "armorName", multiModel));
		} else {
			Object textureData = Modchu_Reflect.getFieldObject(entity.getClass(), "textureData", entity);
			if (textureData != null) {
				Object[] textureBox = Modchu_CastHelper.ObjectArray(Modchu_Reflect.getFieldObject(textureData.getClass(), "textureBox", textureData));
				Class MMM_TextureBoxServer = getMMMTextureBoxServerClass();
				if (MMM_TextureBoxServer != null
						&& MMM_TextureBoxServer.isInstance(textureBox[1])); else {
					if (textureBox != null) return Modchu_CastHelper.String(Modchu_Reflect.getFieldObject(textureBox[1].getClass(), "textureName", textureBox[1], Modchu_Main.isRelease() ? -1 : 0));
				}
			}
		}
		//else {
			//return Modchu_CastHelper.String(Modchu_CastHelper.ObjectArray(Modchu_Reflect.getFieldObject("LMM_EntityLittleMaid", "textureArmor1", owner))[0]);
		//}
		return null;
	}

	public static Class getLMMEntityLittleMaidClass() {
		return Modchu_Reflect.loadClass(isLMR ? "net.blacklab.lmr.entity.EntityLittleMaid" :
					isLMMX ? "littleMaidMobX.LMM_EntityLittleMaid" :
					Modchu_Main.getMinecraftVersion() < 170 ? "LMM_EntityLittleMaid" :
						"mmm.littleMaidMob.entity.EntityLittleMaidBase", -1);
	}

	public static Class getLMMClass() {
		return Modchu_Reflect.loadClass(isLMR ? "net.blacklab.lmr.LittleMaidReengaged" :
			isLMMNX ? "littleMaidMobX.LMM_LittleMaidMobNX" :
			isLMMX ? "littleMaidMobX.LMM_LittleMaidMobX" :
				"mod_LMM_littleMaidMob", -1);
	}

	public static Class getLMMIModelCapsClass() {
		return Modchu_Reflect.loadClass(isLMR ? "net.blacklab.lmr.entity.maidmodel.IModelCaps" :
			isLMMX ? "mmmlibx.lib.multiModel.model.mc162.IModelCaps" :
			Modchu_Main.getMinecraftVersion() > 169 ? "mmm.lib.multiModel.model.mc162.IModelCaps" :
				"MMM_IModelCaps", -1);
	}

	public static Class getLMMGuiTextureSlotClass() {
		return Modchu_Reflect.loadClass(isLMR ? "net.blacklab.lmr.client.gui.GuiTextureSlot" :
			isLMMX ? "mmmlibx.lib.MMM_GuiTextureSlot" :
			"MMM_GuiTextureSlot", -1);
	}

	public static Class getLMMAbstractModelBaseClass() {
		return Modchu_Reflect.loadClass(isLMR ? "net.blacklab.lmr.entity.maidmodel.AbstractModelBase" :
			isLMMX ? "mmmlibx.lib.multiModel.model.AbstractModelBase" :
			Modchu_Main.getMinecraftVersion() > 169 ? "mmm.lib.multiModel.model.AbstractModelBase" :
				"MMM_ModelBase", -1);
	}

	public static Class getLMMGuiTextureSelectClass() {
		return Modchu_Reflect.loadClass(isLMR ? "net.blacklab.lmr.client.gui.GuiTextureSelect" :
			isLMMX ? "mmmlibx.lib.MMM_GuiTextureSelect" :
			"MMM_GuiTextureSelect", -1);
	}

	public static Class getLMMModelMultiBaseClass() {
		return Modchu_Reflect.loadClass(isLMR ? "net.blacklab.lmr.entity.maidmodel.ModelMultiBase" :
			isLMMX ? "mmmlibx.lib.multiModel.model.mc162.ModelMultiBase" :
			Modchu_Main.getMinecraftVersion() > 169 ? "mmm.lib.multiModel.model.mc162.ModelMultiBase" :
				"ModelMultiBase", -1);
	}

	public static Class getMMMModelMultiBaseClass() {
		return Modchu_Reflect.loadClass(isLMR ? "net.blacklab.lmr.entity.maidmodel.ModelMultiBase" :
			isLMMX ? "mmmlibx.lib.multiModel.model.mc162.ModelMultiBase" :
			"MMM_ModelMultiBase", -1);
	}

	public static Class getMMMEntitySelectClass() {
		return Modchu_Reflect.loadClass(isLMR ? "net.blacklab.lmr.client.entity.EntityLittleMaidForTexSelect" :
				isLMMX ? "mmmlibx.lib.MMM_EntitySelect" :
			"MMM_EntitySelect", -1);
	}

	public static Class getMMMTextureBoxClass() {
		return Modchu_Reflect.loadClass(isLMR ? "net.blacklab.lmr.entity.maidmodel.TextureBox" :
			isLMMX ? "mmmlibx.lib.MMM_TextureBox" :
			"MMM_TextureBox", -1);
	}

	public static Class getMMMTextureBoxServerClass() {
		return Modchu_Reflect.loadClass(isLMR ? "net.blacklab.lmr.entity.maidmodel.TextureBoxServer" :
			isLMMX ? "mmmlibx.lib.MMM_TextureBoxServer" :
			"MMM_TextureBoxServer", -1);
	}

	public static Class getModelLittleMaidOrignClass() {
		return Modchu_Reflect.loadClass(isLMR ? "net.blacklab.lmr.entity.maidmodel.ModelLittleMaid_Orign" :
			isLMMX ? "mmmlibx.lib.multiModel.model.mc162.ModelLittleMaid_Orign" :
			Modchu_Main.getMinecraftVersion() > 169 ? "mmmlib.lib.multiModel.model.mc162.ModelLittleMaid_Orign" :
				"MMM_ModelLittleMaid_Orign", -1);
	}

	public static Class getMMMLibClass() {
		return Modchu_Reflect.loadClass(isLMR ? "net.blacklab.lib.EBLib" :
			isLMMX ? "mmmlibx.lib.MMMLib" :
			"mod_MMM_MMMLib", -1);
	}

	public static Class getTextureDataClass() {
		return Modchu_Reflect.loadClass(isLMR ? "net.blacklab.lmr.entity.maidmodel.ModelConfigCompound" :
			isLMMX ? "mmmlibx.lib.MMM_TextureData" :
			"MMM_TextureData", -1);
	}

	public static String getMMMTextureManagerString() {
		return isLMR ? "net.blacklab.lmr.util.manager.ModelManager" :
			isLMMX ? "mmmlibx.lib.MMM_TextureManager" :
			"MMM_TextureManager";
	}

	public static String getModchuLMMModelCapsString() {
		return isLMR ? "Modchu_LmrModelCaps" :
			isLMMX ? "Modchu_LMMXModelCaps" :
			"Modchu_LMMModelCaps";
	}

	public static String getModchuLmmTextureBoxString() {
		return isLMR ? "Modchu_LmrTextureBox" :
			isLMMX ? "Modchu_LmmXTextureBox" :
			"Modchu_LmmTextureBox";
	}

	public static Object[] getLMMModel(Object owner, int color) {
		Object[] models = null;
		int version = Modchu_Main.getMinecraftVersion();
		if (version < 170
				| isLMMX
				| isLMR) {
			Object textureData = Modchu_Reflect.getFieldObject(owner.getClass(), "textureData", owner);
			if (textureData != null) {
				models = Modchu_CastHelper.ObjectArray(Modchu_Reflect.getFieldObject(textureData.getClass(), "textureModel", textureData));
				if (models != null); else {
					Modchu_Debug.mDebug("ModchuModel_ModelDataBase getModel textureModel == null !!");
				}
			} else {
				Modchu_Debug.mDebug("ModchuModel_ModelDataBase getModel textureData == null !!");
			}
		} else {
			Object multiModel = Modchu_Reflect.getFieldObject(owner.getClass(), "multiModel", owner);
			if (multiModel != null) {
				Object[] model = Modchu_CastHelper.ObjectArray(Modchu_Reflect.getFieldObject(multiModel.getClass(), "model", multiModel));
				if (model != null) {
					models = Modchu_CastHelper.ObjectArray(Modchu_Reflect.invokeMethod(model.getClass(), "getModelClass", new Class[]{ int.class }, model, new Object[]{ color }));
				}
			}
		}
		return models;
	}

	public static Object getLMMModel(Object owner, int i, int color) {
		Object[] models = getLMMModel(owner, color);
		return models != null
				&& models.length > i ? models[i] : null;
	}

	public static int getMaidColor(Object owner) {
		int version = Modchu_Main.getMinecraftVersion();
		if (version > 169
				&& !isLMMX
				&& !isLMR) {
			Object multiModel = Modchu_Reflect.getFieldObject(owner.getClass(), "multiModel", owner);
			if (multiModel != null) return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject(multiModel.getClass(), "color", multiModel));
		} else if (version > 159) {
			Object textureData = Modchu_Reflect.getFieldObject(owner.getClass(), "textureData", owner);
			if (textureData != null) {
				return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject(textureData.getClass(), "color", textureData));
			}
		}
		return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject("LMM_EntityLittleMaid", "maidColor", owner));
	}

	public static void setMaidColor(Object owner, int i) {
		int version = Modchu_Main.getMinecraftVersion();
		if (version < 170
				| isLMMX
				| isLMR) {
			Object textureData = Modchu_Reflect.getFieldObject(owner.getClass(), "textureData", owner, -1);
			if (textureData != null) {
				Modchu_Reflect.setFieldObject(textureData.getClass(), "color", textureData, i);
				return;
			}
		}
		Object multiModel = Modchu_Reflect.getFieldObject(owner.getClass(), "multiModel", owner, -1);
		if (multiModel != null) Modchu_Reflect.setFieldObject(multiModel.getClass(), "color", multiModel, i);
	}

	public static Object[] getItems(Object owner) {
		Object[] itemStack = Modchu_Reflect.newInstanceArray("ItemStack", 2);
		//Modchu_Debug.mDebug("ModchuModel_ModelDataBase getItems() owner="+owner);
		int version = Modchu_Main.getMinecraftVersion();
		if (version > 189) {
			boolean flag = Modchu_AS.getEnum("EntityLivingBase", "getPrimaryHand", owner) == Modchu_AS.getEnum("EnumHandSide", "RIGHT");
			String s1 = flag ? "getHeldItemMainhand" : "getHeldItemOffhand";
			String s2 = flag ? "getHeldItemOffhand" : "getHeldItemMainhand";
			itemStack[0] = Modchu_AS.get("EntityLivingBase", s1, owner);
			itemStack[1] = Modchu_AS.get("EntityLivingBase", s2, owner);
		} else {
			itemStack[0] = Modchu_AS.get(Modchu_AS.entityLivingBaseGetHeldItem, owner);
		}
		//Modchu_Debug.mDebug("ModchuModel_ModelDataBase getItems itemStack[0]="+itemStack[0]);
		return itemStack;
	}

	public static void setAimedBow(Object owner, Boolean b) {
		//Modchu_Debug.mDebug("ModchuModel_ModelDataBase setAimedBow b="+b);
		//Modchu_Debug.mDebug("ModchuModel_ModelDataBase setAimedBow getMaidColor(owner)="+getMaidColor(owner));
		Class c = getModchuLmmModelClass();
		Object[] models = getLMMModel(owner, getMaidColor(owner));
		//Modchu_Debug.mDebug1("ModchuModel_ModelDataBase setAimedBow models="+models);
		if (models != null) {
			for (Object model : models) {
				//Modchu_Debug.mDebug1("ModchuModel_ModelDataBase setAimedBow model="+model);
				if (c.isInstance(model)) {
					//Modchu_Debug.mDebug("ModchuModel_ModelDataBase setAimedBow c.isInstance b="+b);
					Modchu_Reflect.invokeMethod(c, "setCapsValue", new Class[]{ int.class, Object[].class }, model, new Object[]{ Modchu_IEntityCapsBase.caps_aimedBow, new Object[]{ b } });
				} else {
					Modchu_Reflect.setFieldObject(model.getClass(), "aimedBow", model, b);
				}
			}
		}
	}

}
