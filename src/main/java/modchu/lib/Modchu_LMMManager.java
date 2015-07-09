package modchu.lib;

import java.util.Map;

import modchu.model.ModchuModel_IEntityCaps;
import modchu.model.ModchuModel_Main;
import modchu.model.ModchuModel_TextureBoxBase;

public class Modchu_LMMManager {

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
				&& !ModchuModel_Main.isLMMX ? Modchu_Reflect.getFieldObject(instance.getClass(), "models", instance) : Modchu_Reflect.getFieldObject(instance.getClass(), "modelMap", instance));
	}

	public static void setLmmTextureManagerModels(Map map) {
		Object instance = getLmmTextureManagerInstance();
		Modchu_Reflect.setFieldObject(instance.getClass(), Modchu_Main.getMinecraftVersion() > 169
				&& !ModchuModel_Main.isLMMX ? "models" : "modelMap", instance, map);
	}

	public static Map getLmmTextureManagerModelNames() {
		if (Modchu_Main.getMinecraftVersion() < 170
				| ModchuModel_Main.isLMMX) return null;
		Object instance = getLmmTextureManagerInstance();
		return Modchu_CastHelper.Map(Modchu_Reflect.getFieldObject(instance.getClass(), "modelNames", instance));
	}

	public static void setLmmTextureManagerModelNames(Map map) {
		if (Modchu_Main.getMinecraftVersion() < 170
				| ModchuModel_Main.isLMMX) return;
		Object instance = getLmmTextureManagerInstance();
		Modchu_Reflect.setFieldObject(instance.getClass(), "modelNames", instance, map);
	}

	public static Object getLmmTextureManagerInstance() {
		String s = ModchuModel_Main.isLMMX ? "mmmlibx.lib.MMM_TextureManager" : Modchu_Main.getMinecraftVersion() > 169 ? "mmm.lib.multiModel.MultiModelManager" : "MMM_TextureManager";
		return Modchu_Reflect.getFieldObject(s, "instance");
	}

	public static Class getModchuLmmModelClass() {
		return Modchu_Main.getModchuCharacteristicClass(ModchuModel_Main.isLMMX ? "ModchuLmmXModel" : "ModchuLmmModel");
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

	public static Object newModchu_LmmTextureBox(ModchuModel_TextureBoxBase mtb) {
		String Modchu_LmmTextureBoxString = Modchu_Main.getModchuCharacteristicClassName(Modchu_LMMManager.getModchuLmmTextureBoxString());
		return Modchu_Reflect.newInstance(Modchu_LmmTextureBoxString, new Class[]{ ModchuModel_TextureBoxBase.class }, new Object[]{ mtb.duplicate() });
	}

	public static String getLMMTextureName(Object entity) {
		int version = Modchu_Main.getMinecraftVersion();
		if (!ModchuModel_Main.isLMMX
				&& version > 169) {
			Object multiModel = Modchu_Reflect.getFieldObject(entity.getClass(), "multiModel", entity);
			if (multiModel != null) return Modchu_CastHelper.String(Modchu_Reflect.getFieldObject(multiModel.getClass(), "modelName", multiModel));
		} else {
			Object textureData = Modchu_Reflect.getFieldObject(entity.getClass(), "textureData", entity);
			if (textureData != null) {
				Object[] textureBox = Modchu_CastHelper.ObjectArray(Modchu_Reflect.getFieldObject(textureData.getClass(), "textureBox", textureData));
				Class MMM_TextureBoxServer = Modchu_Reflect.loadClass("MMM_TextureBoxServer");
				if (MMM_TextureBoxServer != null
						&& MMM_TextureBoxServer.isInstance(textureBox[0])); else {
					if (textureBox != null) return Modchu_CastHelper.String(Modchu_Reflect.getFieldObject("MMM_TextureBoxBase", "textureName", textureBox[0], Modchu_Main.isRelease() ? -1 : 0));
				}
			}
		}
		return null;
	}

	public static String getLMMTextureArmorName(Object entity) {
		int version = Modchu_Main.getMinecraftVersion();
		if (version > 169) {
			Object multiModel = Modchu_Reflect.getFieldObject(entity.getClass(), "multiModel", entity);
			if (multiModel != null) return Modchu_CastHelper.String(Modchu_Reflect.getFieldObject(multiModel.getClass(), "armorName", multiModel));
		} else {
			Object textureData = Modchu_Reflect.getFieldObject(entity.getClass(), "textureData", entity);
			if (textureData != null) {
				Object[] textureBox = Modchu_CastHelper.ObjectArray(Modchu_Reflect.getFieldObject(textureData.getClass(), "textureBox", textureData));
				Class MMM_TextureBoxServer = Modchu_Reflect.loadClass("MMM_TextureBoxServer");
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
		return Modchu_Reflect.loadClass(ModchuModel_Main.isLMMX ? "littleMaidMobX.LMM_EntityLittleMaid" : Modchu_Main.getMinecraftVersion() < 170 ? "LMM_EntityLittleMaid" : "mmm.littleMaidMob.entity.EntityLittleMaidBase", -1);
	}

	public static Class getLMMClass() {
		return Modchu_Reflect.loadClass(ModchuModel_Main.isLMMNX ? "littleMaidMobX.LMM_LittleMaidMobNX" : ModchuModel_Main.isLMMX ? "littleMaidMobX.LMM_LittleMaidMobX" : "mod_LMM_littleMaidMob", -1);
	}

	public static Class<ModchuModel_IEntityCaps> getLMMIModelCapsClass() {
		return Modchu_Reflect.loadClass(ModchuModel_Main.isLMMX ? "mmmlibx.lib.multiModel.model.mc162.IModelCaps" : Modchu_Main.getMinecraftVersion() > 169 ? "mmm.lib.multiModel.model.mc162.IModelCaps" : "MMM_IModelCaps", -1);
	}

	public static Class getLMMGuiTextureSlotClass() {
		return Modchu_Reflect.loadClass(ModchuModel_Main.isLMMX ? "mmmlibx.lib.MMM_GuiTextureSlot" : "MMM_GuiTextureSlot");
	}

	public static Class getLMMAbstractModelBaseClass() {
		return Modchu_Reflect.loadClass(ModchuModel_Main.isLMMX ? "mmmlibx.lib.multiModel.model.AbstractModelBase" : Modchu_Main.getMinecraftVersion() > 169 ? "mmm.lib.multiModel.model.AbstractModelBase" : "MMM_ModelBase", -1);
	}

	public static Class getLMMGuiTextureSelectClass() {
		return Modchu_Reflect.loadClass(ModchuModel_Main.isLMMX ? "mmmlibx.lib.MMM_GuiTextureSelect" : "MMM_GuiTextureSelect", -1);
	}

	public static Class getLMMModelMultiBaseClass() {
		return Modchu_Reflect.loadClass(ModchuModel_Main.isLMMX ? "mmmlibx.lib.multiModel.model.mc162.ModelMultiBase" : Modchu_Main.getMinecraftVersion() > 169 ? "mmm.lib.multiModel.model.mc162.ModelMultiBase" : "ModelMultiBase", -1);
	}

	public static Class getMMMModelMultiBaseClass() {
		return Modchu_Reflect.loadClass(ModchuModel_Main.isLMMX ? "mmmlibx.lib.multiModel.model.mc162.ModelMultiBase" : "MMM_ModelMultiBase", -1);
	}

	public static Class getMMMEntitySelectClass() {
		return Modchu_Reflect.loadClass(ModchuModel_Main.isLMMX ? "mmmlibx.lib.MMM_EntitySelect" : "MMM_EntitySelect");
	}

	public static Class getMMMTextureBoxClass() {
		return Modchu_Reflect.loadClass(ModchuModel_Main.isLMMX ? "mmmlibx.lib.MMM_TextureBox" : "MMM_TextureBox", -1);
	}

	public static Class getModelLittleMaidOrignClass() {
		return Modchu_Reflect.loadClass(ModchuModel_Main.isLMMX ? "mmmlibx.lib.multiModel.model.mc162.ModelLittleMaid_Orign" : Modchu_Main.getMinecraftVersion() > 169 ? "mmmlib.lib.multiModel.model.mc162.ModelLittleMaid_Orign" : "MMM_ModelLittleMaid_Orign", -1);
	}

	public static Class getMMMLibClass() {
		return Modchu_Reflect.loadClass(ModchuModel_Main.isLMMX ? "mmmlibx.lib.MMMLib" : "mod_MMM_MMMLib", -1);
	}

	public static String getMMMTextureManagerString() {
		return ModchuModel_Main.isLMMX ? "mmmlibx.lib.MMM_TextureManager" : "MMM_TextureManager";
	}

	public static String getModchuLMMModelCapsString() {
		return ModchuModel_Main.isLMMX ? "Modchu_LMMXModelCaps" : "Modchu_LMMModelCaps";
	}

	public static String getModchuLmmTextureBoxString() {
		return ModchuModel_Main.isLMMX ? "Modchu_LmmXTextureBox" : "Modchu_LmmTextureBox";
	}

	public static Object getLMMModel(Object owner, int i, int color) {
		int version = Modchu_Main.getMinecraftVersion();
		if (version < 170
				| ModchuModel_Main.isLMMX) {
			Object textureData = Modchu_Reflect.getFieldObject(owner.getClass(), "textureData", owner);
			if (textureData != null) {
				Object[] textureModel = Modchu_CastHelper.ObjectArray(Modchu_Reflect.getFieldObject(textureData.getClass(), "textureModel", textureData));
				if (textureModel != null) {
					return textureModel != null
							&& i < textureModel.length ? textureModel[i] : null;
				} else {
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
					Object[] models = Modchu_CastHelper.ObjectArray(Modchu_Reflect.invokeMethod(model.getClass(), "getModelClass", new Class[]{ int.class }, model, new Object[]{ color }));
					return models != null
							&& i < models.length ? models[i] : null;
				}
			}
		}
		return null;
	}

}
