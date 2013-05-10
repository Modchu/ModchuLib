package net.minecraft.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.minecraft.client.Minecraft;

public class Modchu_CustomModel extends ModelBase {

	public MMM_ModelMultiBase mainModel;
	public MultiModelBaseBiped baseModel;
	public Modchu_ModelRenderer[] parts;
	public String mainModeltextureName;
	public String mainModeltexture;
	public String[] partsName;
	public String[] partAddChildName;
	public int[] partsTextureWidth;
	public int[] partsTextureHeight;
	public int[] partsTextureOffsetX;
	public int[] partsTextureOffsetY;
	public int[] partsBoxNumber;
	public int[][] partsBoxX;
	public int[][] partsBoxY;
	public int[][] partsBoxZ;
	public float[][] partsBoxInitPointX;
	public float[][] partsBoxInitPointY;
	public float[][] partsBoxInitPointZ;
	public float[][] partsScaleFactor;
	public float[][] partsScaleCorrection;
	public float[] partsTypeFactor;
	public float[] partsTypeCorrection;
	public float[] partsRotationPointX;
	public float[] partsRotationPointY;
	public float[] partsRotationPointZ;
	public float[] partsRotateAngleX;
	public float[] partsRotateAngleY;
	public float[] partsRotateAngleZ;
	public byte[] partsType;
	public byte[] partsTextureColor;
	public static final byte normal = 0;
	public static final byte eyeR = 1;
	public static final byte eyeL = 2;
	public static final byte ear = 3;
	public static final byte tail = 4;
	public HashMap<Integer, String> partsTextureNameMap = new HashMap();

	private MultiModelBaseBiped armorSyncBaseModel;
	private boolean changeModelInit;
	private HashMap<ModelRenderer, Boolean> showModelMemoryList = new HashMap();
	private HashMap<ModelRenderer, Boolean> customModelshowModelMemoryList = new HashMap();
	private HashMap<Integer, Field> modelRendererFieldsMap = new HashMap();
	private final File cfgdir = new File(Minecraft.getMinecraftDir(), "/config/CustomModel/");
	private int partsNumberMax;
	private int partsBoxNumberMax;
	private int partsCount;
	private int boxCount;
	private int[] boxNumberCount;
	private byte[][] boxType;
	private HashMap<String, Field> baseSyncMap = new HashMap();
	private HashMap<String, Field> baseAllSyncMap = new HashMap();
	private HashMap<String, Field> mainSyncMap = new HashMap();
	private HashMap<String, Field> mainAllSyncMap = new HashMap();
	private HashMap<Integer, String> baseSyncNameMap = new HashMap();
	private HashMap<Integer, String> baseAllSyncNameMap = new HashMap();
	private HashMap<Integer, String> mainSyncNameMap = new HashMap();
	private HashMap<Integer, String> mainAllSyncNameMap = new HashMap();
	private List<String> syncNameList = new ArrayList<String>();
    private LinkedList<String> textureList = new LinkedList<String>();
	private String cfgName;
	//private Class PFLM_ModelData;
	//private Method setArmorModelMethod;
	//private int setArmorModelMethodType;

	public Modchu_CustomModel(MultiModelBaseBiped multiModelBaseBiped, String s, float f, float f1) {
		baseModel = multiModelBaseBiped;
		if (s != null) {
			cfgName = s;
			init(s, f, f1);
			Modchu_Debug.cDebug("Modchu_CustomModel init end.");
		}
	}

	public Modchu_CustomModel(MultiModelBaseBiped multiModelBaseBiped, MMM_ModelMultiBase modelBiped, String s, float f, float f1) {
		baseModel = multiModelBaseBiped;
		mainModel = modelBiped;
		mainModeltextureName = s;
	}

	public void init(String s, float f, float f1) {
		boolean cfgReLoad = false;
		if (s != null) ;else {
			s = cfgName;
			cfgReLoad = true;
		}
		partsBoxNumberMax = 0;
		partsCount = 0;
		boxCount = 0;
		boxNumberCount = new int[256];

		String s1 = new StringBuilder().append("CustomModel_").append(s).append(".cfg").toString();
		Modchu_Debug.cDebug("Modchu_CustomModel cfg["+s1+"] loadInit");
		loadInit(new File(cfgdir, s1), cfgReLoad);
		if (partsNumberMax < 1) {
			Modchu_Debug.cDebug("Modchu_CustomModel init partsNumberMax="+partsNumberMax+" end");
			return;
		}
		parts = new Modchu_ModelRenderer[partsNumberMax];
		partsName = new String[partsNumberMax];
		partAddChildName = new String[partsNumberMax];
		partsTextureWidth = new int[partsNumberMax];
		partsTextureHeight = new int[partsNumberMax];
		partsTextureOffsetX = new int[partsNumberMax];
		partsTextureOffsetY = new int[partsNumberMax];
		partsBoxNumber = new int[partsNumberMax];
		partsRotationPointX = new float[partsNumberMax];
		partsRotationPointY = new float[partsNumberMax];
		partsRotationPointZ = new float[partsNumberMax];
		partsRotateAngleX = new float[partsNumberMax];
		partsRotateAngleY = new float[partsNumberMax];
		partsRotateAngleZ = new float[partsNumberMax];
		partsType = new byte[partsNumberMax];
		partsTextureColor = new byte[partsNumberMax];
		partsTypeFactor = new float[partsNumberMax];
		partsTypeCorrection = new float[partsNumberMax];

		Modchu_Debug.cDebug("Modchu_CustomModel customInitModel partsNumberMax="+partsNumberMax);
		customInitModel(f, f1);
		Modchu_Debug.cDebug("Modchu_CustomModel customInitModel end");

		int n = 0;
		for (int i = 0;i < partsNumberMax; i++) {
			partsBoxNumber[i] = boxNumberCount[i];
			if (partsBoxNumber[i] > n) n = partsBoxNumber[i];
		}
		boxNumberCount = null;
		boxType = new byte[partsNumberMax][n];
		partsBoxX = new int[partsNumberMax][n];
		partsBoxY = new int[partsNumberMax][n];
		partsBoxZ = new int[partsNumberMax][n];
		partsBoxInitPointX = new float[partsNumberMax][n];
		partsBoxInitPointY = new float[partsNumberMax][n];
		partsBoxInitPointZ = new float[partsNumberMax][n];
		partsScaleFactor = new float[partsNumberMax][n];
		partsScaleCorrection = new float[partsNumberMax][n];

		File file = null;
		try {
			file = new File(cfgdir, (new StringBuilder()).append("CustomModel_").append(s).append(".cfg").toString());
		} catch(Exception e) {
			throw new RuntimeException("Modchu_CustomModel file="+file.toString()+"\n\n"+e);
		}
		if (!file.exists()) throw new RuntimeException("Modchu_CustomModel FileNotFound!! file="+file.toString());
		for (int i = 0;i < partsNumberMax; i++) {
			parts[i] = new Modchu_ModelRenderer(mainModel);
		}
		Modchu_Debug.cDebug("Modchu_CustomModel cfg load");
		load(file, cfgReLoad);
		Modchu_Debug.cDebug("Modchu_CustomModel cfg load end");

		//Modchu_Debug.mDebug("add partsNumberMax="+partsNumberMax);
		for (int i = 0;i < partsNumberMax; i++) {
			parts[i].setTextureOffset(partsTextureOffsetX[i], partsTextureOffsetY[i]);
			parts[i].textureWidth = partsTextureWidth[i];
			parts[i].textureHeight = partsTextureHeight[i];
			for (int i1 = 0;i1 < partsBoxNumber[i]; i1++) {
				//Modchu_Debug.mDebug("add i="+i+" i1="+i1);
				Modchu_Debug.cDebug("Modchu_CustomModel partsName["+i+"]="+partsName[i]);
				switch (boxType[i][i1]) {
				case 0:
					Modchu_Debug.cDebug(new StringBuilder().append("Modchu_CustomModel i=").append(i).append(" i1=").append(i1).append(" addBox(").append(partsBoxInitPointX[i][i1]).append("F,").append(partsBoxInitPointY[i][i1]).append("F,").append(partsBoxInitPointZ[i][i1]).append("F,").append(partsBoxX[i][i1]).append(",").append(partsBoxY[i][i1]).append(",").append(partsBoxZ[i][i1]).append(",").append(f).append("F*").append(partsScaleFactor[i][i1]).append("F+").append(partsScaleCorrection[i][i1]).append("F)").toString());
					parts[i].addBox(partsBoxInitPointX[i][i1], partsBoxInitPointY[i][i1], partsBoxInitPointZ[i][i1], partsBoxX[i][i1], partsBoxY[i][i1], partsBoxZ[i][i1], f * partsScaleFactor[i][i1] + partsScaleCorrection[i][i1]);
					break;
				case 1:
					Modchu_Debug.cDebug(new StringBuilder().append("Modchu_CustomModel i=").append(i).append(" i1=").append(i1).append(" addPlate(").append(partsBoxInitPointX[i][i1]).append("F,").append(partsBoxInitPointY[i][i1]).append("F,").append(partsBoxInitPointZ[i][i1]).append("F,").append(partsBoxX[i][i1]).append(",").append(partsBoxY[i][i1]).append(",").append(partsBoxZ[i][i1]).append(",").append(f).append("F*").append(partsScaleFactor[i][i1]).append("F+").append(partsScaleCorrection[i][i1]).append("F)").toString());
					parts[i].addPlate(partsBoxInitPointX[i][i1], partsBoxInitPointY[i][i1], partsBoxInitPointZ[i][i1], partsBoxX[i][i1], partsBoxY[i][i1], partsBoxZ[i][i1], f * partsScaleFactor[i][i1] + partsScaleCorrection[i][i1]);
					break;
				case 2:
					Modchu_Debug.cDebug(new StringBuilder().append("Modchu_CustomModel i=").append(i).append(" i1=").append(i1).append(" addBall(").append(partsBoxInitPointX[i][i1]).append("F,").append(partsBoxInitPointY[i][i1]).append("F,").append(partsBoxInitPointZ[i][i1]).append("F,").append(partsBoxX[i][i1]).append(",").append(partsBoxY[i][i1]).append(",").append(partsBoxZ[i][i1]).append(")").toString());
					parts[i].addBall(partsBoxInitPointX[i][i1], partsBoxInitPointY[i][i1], partsBoxInitPointZ[i][i1], partsBoxX[i][i1], partsBoxY[i][i1], partsBoxZ[i][i1]);
					break;
				}
			}
			parts[i].setRotationPoint(partsRotationPointX[i], partsRotationPointY[i], partsRotationPointZ[i]);
			parts[i].setRotateAngle(partsRotateAngleX[i], partsRotateAngleY[i], partsRotateAngleZ[i]);
			if (partAddChildName[i] != null) {
				String addChildName = obfuscationNameCheck(partAddChildName[i]);
				Modchu_ModelRenderer modchu_ModelRenderer = (Modchu_ModelRenderer) Modchu_Reflect.getFieldObject(mainModel.getClass(), addChildName, mainModel, -1);
				if (modchu_ModelRenderer != null) {
					modchu_ModelRenderer.addChild(parts[i]);
					Modchu_Debug.cDebug("Modchu_CustomModel addChild "+addChildName+" i="+i);
				} else {
					for (int i1 = 0;i1 < partsNumberMax && parts[i1] != null; i1++) {
						if (partAddChildName[i].equalsIgnoreCase(partsName[i1])) {
							parts[i1].addChild(parts[i]);
							Modchu_Debug.cDebug("Modchu_CustomModel addChild "+partAddChildName[i]+" i="+i);
							break;
						}
					}
				}
			}
		}
		syncNameListSetting();
		//PFLM_ModelData = Modchu_Reflect.loadClass(mod_Modchu_ModchuLib.mod_modchu_modchulib.getClassName("PFLM_ModelData"));
	}

	public void renderMM(float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5) {
		if (mainModel != null) ;else return;
//-@-151
		EntityLiving entity = (EntityLiving) baseModel.getCapsValue(baseModel.entityCaps.caps_Entity);
//@-@151
		allShowModelMemory();
		customModelShowModelMemory();
		customModelShowModelSetting(null, false);
		int armorType = Modchu_ModelCapsHelper.getCapsValueInt(baseModel, baseModel.caps_armorType);
		boolean flag1 = armorType < 2;
		if (flag1) {
			if (mainModeltexture != null) {
			}
			else {
				colorSetting(null);
			}
			if (mainModeltexture != null) ;else Modchu_Debug.cDebug("Modchu_CustomModel render mainModeltexture == null !! mainModeltextureName="+mainModeltextureName);
			if (mainModel.render != null) ;else mainModel.render = baseModel.render;
			if (mainModel.render != null) mainModel.render.loadTexture(mainModeltexture);
			else Modchu_Debug.cDebug("Modchu_CustomModel render render == null !!");
			//Modchu_Debug.mDebug("Modchu_CustomModel render mainModeltexture="+mainModeltexture);
			//Modchu_Debug.mDebug("Modchu_CustomModel render mainModel.getClass()="+(mainModel.getClass()));
			mainModel.renderMM(f, f1, ticksExisted, pheadYaw, pheadPitch, f5);
		} else {
			//Modchu_Debug.mDebug("Modchu_CustomModel render armor baseModel.getCapsValueInt(baseModel.caps_armorType)="+baseModel.getCapsValueInt(baseModel.caps_armorType));
			int color = getMaidColor((EntityLiving) entity);
			String s;
			String armorName = (String) baseModel.getCapsValue(baseModel.caps_textureArmorName);
			InventoryPlayer inventory = (InventoryPlayer) baseModel.getCapsValue(baseModel.caps_Inventory);
			ItemStack is;
			if (inventory != null) {
				for(int i = 0; i < 4; i++) {
					is = inventory.armorItemInSlot(i);
					s = (String) baseModel.getCapsValue(baseModel.caps_armorTexture, armorName, armorType, is);
					armorRender(s, armorType, is, mainModel, i, entity, f, f1, ticksExisted, pheadYaw, pheadPitch, f5);
				}
			}
		}
		allShowModelSetting(false);
		String s1 = null;
		if (partsTextureNameMap.size() > 0
				&& textureList != null
				&& textureList.size() > 0) {
			String texture;
			String prevTexture = null;
			for(int i = 0; i < partsTextureNameMap.size() ;i++) {
				s1 = partsTextureNameMap.get(i);
				texture = textureList.get(i);
				boolean flag = false;
				if (prevTexture == null) flag = true;
				if (texture != null
						&& prevTexture != null
						&& !prevTexture.equalsIgnoreCase(texture)) flag = true;
				if (flag) {
					//Modchu_Debug.mDebug("MultiModelCustom s1="+s1+" loadTexture texture="+texture+" prevTexture="+prevTexture);
					//Modchu_Debug.mDebug("MultiModelCustom s1="+s1+" loadTexture texture="+texture);
					if (texture != null) {
						if (baseModel.render != null) {
							baseModel.render.loadTexture(texture);
						}
					}
					customModelShowModelSetting(s1, true);
					mainModel.renderMM(f, f1, ticksExisted, pheadYaw, pheadPitch, f5);
					//((MultiModelCustom) baseModel).superrenderMM(f, f1, ticksExisted, pheadYaw, pheadPitch, f5);
					customModelShowModelSetting(null, false);
				}
				prevTexture = texture;
			}
		}
		allShowModelMemoryRead();
		customModelShowModelMemoryRead();
		if (!changeModelInit) changeModel(null);
	}

	private void armorRender(String s, int armorType, ItemStack is, MMM_ModelMultiBase model, int i, Entity entity, float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5) {
		if (s != null) ;else return;
/*
		if (setArmorModelMethodType == 0) return;
		switch(setArmorModelMethodType) {
		case 1:
			Modchu_Reflect.invoke(setArmorModelMethod, render, new Object[]{ ((MultiModelBaseBiped) model), ((EntityPlayer) entity), i, f });
			break;
		case 2:
		case 3:
			Modchu_Reflect.invoke(setArmorModelMethod, render, new Object[]{ entity, i, f });
			break;
		}
*/
		if (setArmorModel((MMM_ModelMultiBase) model, is, entity, i, f) > -1) {
			if (s != null) {
				if (mainModel.render != null) ;else mainModel.render = baseModel.render;
				if (mainModel.render != null) mainModel.render.loadTexture(s);
			}
			model.renderMM(f, f1, ticksExisted, pheadYaw, pheadPitch, f5);
		}
	}

	private int setArmorModel(MMM_ModelMultiBase model, ItemStack is, Entity entity, int i, float f) {
		byte byte0 = -1;
		if (model != null) ;else return byte0;
		if (is != null && is.stackSize > 0) {
			model.showArmorParts(i);
//-@-b181
			byte0 = (byte) (is.isItemEnchanted() ? 15 : 1);
//@-@b181
		}
		return byte0;
	}

	public void setLivingAnimationsMM(float f, float f1, float renderPartialTicks) {
		//Modchu_Debug.mDebug("Modchu_CustomModel setLivingAnimationsLM");
		EntityLiving entityliving = (EntityLiving) baseModel.getCapsValue(baseModel, baseModel.entityCaps.caps_Entity);
		if (entityliving != null) ;else return;
		//fieldSync(true, entityliving, f, f1, renderPartialTicks);

		if (parts != null) {
			for(int i = 0; i < parts.length ;i++) {
				if (partsType[i] == eyeR
						| partsType[i] == eyeL) {
					// –Úƒpƒ`
					float f3 = (float)entityliving.ticksExisted + renderPartialTicks + Modchu_ModelCapsHelper.getCapsValueFloat(baseModel, baseModel.caps_entityIdFactor);
					//Modchu_Debug.mDebug("f3="+f3+" 0 > ? "+(MathHelper.sin(f3 * 0.05F) + MathHelper.sin(f3 * 0.13F) + MathHelper.sin(f3 * 0.7F) + 2.55F));
					if( 0 > MathHelper.sin(f3 * 0.05F) + MathHelper.sin(f3 * 0.13F) + MathHelper.sin(f3 * 0.7F) + 2.55F) {
						mainModel.setCapsValue(((MultiModelBaseBiped) mainModel).caps_visible, parts[i], true);
						customModelshowModelMemoryList.put(parts[i], parts[i].showModel);
						//Modchu_Debug.mDebug("Modchu_CustomModel setLivingAnimationsLM true parts[i].showModel="+parts[i].showModel);
					} else {
						mainModel.setCapsValue(((MultiModelBaseBiped) mainModel).caps_visible, parts[i], false);
						customModelshowModelMemoryList.put(parts[i], parts[i].showModel);
						//Modchu_Debug.mDebug("Modchu_CustomModel setLivingAnimationsLM false parts[i].showModel="+parts[i].showModel);
					}
				}
			}
		}
		//Modchu_Debug.mDebug("parts[6].showModel="+parts[6].showModel);
	}

	public void setRotationAnglesMM(float f, float f1, float f2, float f3, float f4, float f5) {
		if (mainModel != null) ;else return;
		mainModel.setRotationAnglesMM(f, f1, f2, f3, f4, f5);
		///fieldSync(true, (EntityLiving) entity, f, f1, f2);
		if (mainModel instanceof MultiModelBaseBiped
				&& Modchu_ModelCapsHelper.getCapsValueBoolean(baseModel, ((MultiModelBaseBiped) mainModel).caps_shortcutKeysAction)) {
			if (Modchu_ModelCapsHelper.getCapsValueInt(baseModel, baseModel.caps_armorType) != 0) mainModel.setCapsValue(((MultiModelBaseBiped) mainModel).caps_syncModel, armorSyncBaseModel);
			else armorSyncBaseModel = (MultiModelBaseBiped) mainModel;
			actionSync();
		}
		//Modchu_Debug.mDebug("mainModel.isWait="+mainModel.isWait+" baseModel.isWait="+baseModel.isWait+" caps_isWait="+baseModel.entityCaps.getCapsValue(baseModel.caps_isWait));
	}

	public void setRotationAnglesLM(float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5) {
		if (parts != null) {
			for(int i = 0; i < parts.length ;i++) {
				if (partsType[i] == eyeR) {
					if ((Boolean) mainModel.getCapsValue(mainModel.caps_aimedBow)) {
						mainModel.setCapsValue(((MultiModelBaseBiped) mainModel).caps_visible, parts[i], false);
						//Modchu_Debug.mDebug("caps_aimedBow eyeR parts[i].showModel="+parts[i].showModel);
						customModelshowModelMemoryList.put(parts[i], parts[i].showModel);
					}
				}
				if (partsType[i] == eyeL) {
					if ((Boolean) mainModel.getCapsValue(mainModel.caps_aimedBow)) {
						mainModel.setCapsValue(((MultiModelBaseBiped) mainModel).caps_visible, parts[i], true);
						//Modchu_Debug.mDebug("caps_aimedBow eyeL parts[i].showModel="+parts[i].showModel);
						customModelshowModelMemoryList.put(parts[i], parts[i].showModel);
					}
				}
				if (partsType[i] == ear) {
					parts[i].rotateAngleX = mainModel.mh_sin(ticksExisted * 0.05F) * partsTypeFactor[i] + partsTypeCorrection[i];
				}
				if (partsType[i] == tail) {
					parts[i].rotateAngleY = parts[i].rotateAngleZ = mainModel.mh_cos(ticksExisted * 0.2F) * partsTypeFactor[i] + partsTypeCorrection[i];
				}
			}
		}
	}

	public void setRotationAnglesfirstPerson(float f, float f1, float f2, float f3, float f4, float f5) {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) ((MultiModelBaseBiped) mainModel).setRotationAnglesfirstPerson(f, f1, f2, f3, f4, f5);
	}

	public Object getCapsValue(int pIndex, Object[] pArg) {
		if (baseModel != null) return ((MultiModelCustom) baseModel).superGetCapsValue(pIndex, pArg);
		return null;
	}

	public boolean setCapsValue(int pIndex, Object[] pArg) {
		if (mainModel != null) mainModel.setCapsValue(pIndex, pArg);
		if (baseModel != null) return ((MultiModelCustom) baseModel).superSetCapsValue(pIndex, pArg);
		return false;
	}

	public void renderItems() {
		if (mainModel != null) mainModel.renderItems();
	}

	public void defaultPartsSettingBefore() {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) ((MultiModelBaseBiped) mainModel).defaultPartsSettingBefore();
	}

	public void defaultPartsSettingAfter() {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) ((MultiModelBaseBiped) mainModel).defaultPartsSettingAfter();
	}

	public void showModelSettingReflects() {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) ((MultiModelBaseBiped) mainModel).showModelSettingReflects();
	}

	public void actionInit(int i) {
		if (mainModel instanceof MultiModelAction
				&& mainModel != null) ((MultiModelAction) mainModel).actionInit(i);
	}

	public void actionRelease(int i) {
		if (mainModel instanceof MultiModelAction
				&& mainModel != null) ((MultiModelAction) mainModel).actionRelease(i);
	}

	public void action(float f, float f1, float f2, float f3, float f4, float f5, int i) {
		if (mainModel instanceof MultiModelAction
				&& mainModel != null) ((MultiModelAction) mainModel).action(f, f1, f2, f3, f4, f5, i);
	}

	public void syncModel(MultiModelBaseBiped model) {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) ((MultiModelBaseBiped) mainModel).syncModel(model);
	}

	public float getHeight() {
		if (mainModel != null) return mainModel.getHeight();
		return 1.35F;
	}

	public float getWidth() {
		if (mainModel != null) return mainModel.getWidth();
    	return 0.5F;
	}

	public float getyOffset() {
		if (mainModel != null) return mainModel.getyOffset();
		return 1.62F;
	}

	public float getRidingHeight() {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) return ((MultiModelBaseBiped) mainModel).getRidingHeight();
		return 1.35F;
	}

	public float getRidingWidth() {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) return ((MultiModelBaseBiped) mainModel).getRidingWidth();
		return 0.5F;
	}

	public float getRidingyOffset() {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) return ((MultiModelBaseBiped) mainModel).getRidingyOffset();
		return 1.62F;
	}

	public double getMountedYOffset() {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) return ((MultiModelBaseBiped) mainModel).getMountedYOffset();
		return 0.75D;
	}

	public double getSittingyOffset() {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) return ((MultiModelBaseBiped) mainModel).getSittingyOffset();
		return -0.35D;
	}

	public double getSleepingyOffset() {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) return ((MultiModelBaseBiped) mainModel).getSleepingyOffset();
		return -0.9D;
	}

	public float ridingViewCorrection() {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) return ((MultiModelBaseBiped) mainModel).ridingViewCorrection();
		return 0.0F;
	}

	public float getModelScale() {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) return ((MultiModelBaseBiped) mainModel).getModelScale();
		return 0.9375F;
	}

	public void equippedItemPositionFlower() {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) ((MultiModelBaseBiped) mainModel).equippedItemPositionFlower();
	}

	public void setArmorBipedHeadShowModel(boolean b) {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) ((MultiModelBaseBiped) mainModel).setArmorBipedHeadShowModel(b);
	}

	public void setArmorBipedBodyShowModel(boolean b) {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) ((MultiModelBaseBiped) mainModel).setArmorBipedBodyShowModel(b);
	}

	public void setArmorBipedRightArmShowModel(boolean b) {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) ((MultiModelBaseBiped) mainModel).setArmorBipedRightArmShowModel(b);
	}

	public void setArmorBipedLeftArmShowModel(boolean b) {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) ((MultiModelBaseBiped) mainModel).setArmorBipedLeftArmShowModel(b);
	}

	public void setArmorBipedRightLegShowModel(boolean b) {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) ((MultiModelBaseBiped) mainModel).setArmorBipedRightLegShowModel(b);
	}

	public void setArmorBipedLeftLegShowModel(boolean b) {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) ((MultiModelBaseBiped) mainModel).setArmorBipedLeftLegShowModel(b);
	}

	public void setArmorSkirtShowModel(boolean b) {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) ((MultiModelBaseBiped) mainModel).setArmorSkirtShowModel(b);
	}

	public void allShowModelMemory() {
		ModelRenderer modelRenderer;
		for (int i = 0; i < modelRendererFieldsMap.size(); i++) {
			try {
				modelRenderer = (ModelRenderer) modelRendererFieldsMap.get(i).get(mainModel);
				if (modelRenderer != null) {
					showModelMemoryList.put(modelRenderer, modelRenderer.showModel);
					//Modchu_Debug.mDebug("allShowModelMemory modelRendererFieldsMap.get("+i+").getName() = "+modelRendererFieldsMap.get(i).getName()+" modelRenderer.showModel="+modelRenderer.showModel);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void customModelShowModelMemory() {
		if (parts != null) {
			boolean b1 = false;
			for(int i = 0; i < parts.length ;i++) {
				customModelshowModelMemoryList.put(parts[i], parts[i].showModel);
				//Modchu_Debug.mDebug("customModelShowModelMemory get("+i+") parts["+i+"].showModel="+parts[i].showModel);
			}
		}
	}

	public void allShowModelMemoryRead() {
		ModelRenderer modelRenderer;
		for (int i = 0; i < modelRendererFieldsMap.size(); i++) {
			try {
				modelRenderer = (ModelRenderer) modelRendererFieldsMap.get(i).get(mainModel);
				if (modelRenderer != null) {
					((ModelRenderer) modelRendererFieldsMap.get(i).get(mainModel)).showModel = showModelMemoryList.get(modelRenderer);
					//Modchu_Debug.mDebug("allShowModelMemory modelRendererFieldsMap.get("+i+").getName() = "+modelRendererFieldsMap.get(i).getName()+" ((ModelRenderer) modelRendererFieldsMap.get(i).get(mainModel)).showModel="+((ModelRenderer) modelRendererFieldsMap.get(i).get(mainModel)).showModel);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void customModelShowModelMemoryRead() {
		if (parts != null) {
			boolean b1 = false;
			for(int i = 0; i < parts.length ;i++) {
				parts[i].showModel = customModelshowModelMemoryList.get(parts[i]);
				//Modchu_Debug.mDebug("customModelShowModelMemoryRead parts["+i+"].showModel="+parts[i].showModel);
			}
		}
	}

	public void changeModel(MMM_IModelCaps entityCaps) {
		if (mainModel != null) ;else return;
//-@-151
		EntityLiving entity = (EntityLiving) baseModel.getCapsValue(baseModel.entityCaps.caps_Entity);
//@-@151
		changeModelInit = true;
		colorSetting(null);
		Field[] fields = mainModel.getClass().getFields();
		Object o;
		ModelRenderer modelRenderer;
		int k = 0;
		for (int i = 0; i < fields.length; i++) {
			//Modchu_Debug.mDebug("changeModel fields["+i+"].getType() = "+fields[i].getType());
			try {
				o = fields[i].get(mainModel);
				if (ModelRenderer.class.isInstance(o)) {
					modelRenderer = (ModelRenderer) fields[i].get(mainModel);
					if (modelRenderer != null) {
						modelRendererFieldsMap.put(k, fields[i]);
						k++;
					}
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public void changeColor(MMM_IModelCaps entityCaps) {
		colorSetting(entityCaps);
	}

	public void reset(float f, float f1, float f2, float f3, float f4,
			float f5) {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) ((MultiModelBaseBiped) mainModel).reset(f, f1, f2, f3, f4, f5);
	}

	public float[] getArmorModelsSize() {
		Modchu_Debug.mDebug("getArmorModelsSize mainModel.getClass()="+mainModel.getClass());
		if (mainModel != null) return mainModel.getArmorModelsSize();
		return new float[] {0.1F, 0.5F};
	}

	public void renderFirstPersonHand(float f) {
		Render render = RenderManager.instance.getEntityRenderObject(Minecraft.getMinecraft().thePlayer);
		if (mainModeltexture != null) render.loadTexture(mainModeltexture);
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) ((MultiModelBaseBiped) mainModel).renderFirstPersonHand(f);
	}

	private void loadInit(File file, boolean b) {
		List list = !b ? (ArrayList) Modchu_Config.cfgData.get(file) : null;
		partsNumberMax = 0;
		if (list == null) {
			list = new ArrayList();
			try {
				BufferedReader breader = new BufferedReader(new FileReader(
						file));
				String rl;
				partsCount = -1;
				for (int i = 0; (rl = breader.readLine()) != null ; i++) {
					int i1;
					list.add(rl);
					if (rl.startsWith("#")
							| rl.startsWith("/")) continue;
					initCheckData(rl.toString());
				}
				partsNumberMax = partsCount + 1;
				//Modchu_Debug.mDebug("Modchu_CustomModel loadInit partsNumberMax="+partsNumberMax);
				Modchu_Config.cfgData.put(file, list);
				breader.close();
			} catch (Exception e) {
				//Modchu_Debug.cDebug("Modchu_CustomModel loadInit load "+ file.toString() +" load fail.");
				e.printStackTrace();
			}
		} else {
			String s2;
			partsCount = -1;
			for (int i = 0; i < list.size() ; i++) {
				s2 = (String) list.get(i);
				if (s2.startsWith("#")
						| s2.startsWith("/")) continue;
				initCheckData(s2.toString());
			}
			partsNumberMax = partsCount + 1;
		}
	}

	private void initCheckData(String s) {
		s = s.replaceAll(" ", "");
		s = s.replaceAll("	", "");
		int i1;
		if (s.startsWith("name")) {
			i1 = s.indexOf('=');
			if (i1 > -1) {
				partsCount++;
				//Modchu_Debug.mDebug("Modchu_CustomModel initCheckData partsCount="+partsCount);
				return;
			}
		}
		if (s.startsWith("addBox")
				| s.startsWith("addPlate")
				| s.startsWith("addBall")) {
			i1 = s.indexOf('(');
			if (i1 > -1) {
				boxNumberCount[partsCount]++;
				//Modchu_Debug.mDebug("Modchu_CustomModel initCheckData boxNumberCount["+partsCount+"]="+boxNumberCount[partsCount]);
			}
		}
		if (s.startsWith("mainModeltextureName")) {
			i1 = s.indexOf('=');
			if (i1 > -1) {
				mainModeltextureName = s.substring(i1 + 1);
				//Modchu_Debug.mDebug("Modchu_CustomModel initCheckData mainModelName="+s.substring(i1 + 1));
				return;
			}
		}
	}

	private void load(File file, boolean b) {
		List list = !b ? (ArrayList) Modchu_Config.cfgData.get(file) : null;
		partsCount = -1;
		if (list == null) {
			list = new ArrayList();
			try {
				BufferedReader breader = new BufferedReader(new FileReader(
						file));
				String rl;
				for (int i = 0; (rl = breader.readLine()) != null ; i++) {
					int i1;
					list.add(rl);
					if (rl.startsWith("#")
							| rl.startsWith("/")) continue;
					settingData(rl.toString());
				}
				Modchu_Config.cfgData.put(file, list);
				breader.close();
			} catch (Exception e) {
				//Modchu_Debug.cDebug("Modchu_Config load "+ file.toString() +" load fail.");
				e.printStackTrace();
			}
		} else {
			String s2;
			//Modchu_Debug.mDebug("1 file="+file.toString()+" list.size()="+list.size());
			for (int i = 0; i < list.size() ; i++) {
				s2 = (String) list.get(i);
				//Modchu_Debug.mDebug("s2="+s2);
				if (s2.startsWith("#")
						| s2.startsWith("/")) continue;
				settingData(s2);
			}
		}
	}

	private void settingData(String s) {
		s = s.replaceAll(" ", "");
		s = s.replaceAll("	", "");
		int i1 = 0;
		if (s.startsWith("name")) {
			i1 = s.indexOf('=');
			if (i1 > -1) {
				boxCount = 0;
				partsCount++;
				partsName[partsCount] = s.substring(i1 + 1);
				//Modchu_Debug.mDebug("Modchu_CustomModel partsName["+partsCount+"]="+partsName[partsCount]);
				if (partsCount > 0) partsTextureNameMap.put(partsCount, partsTextureNameMap.get(partsCount - 1));
				partsTextureColor[partsCount] = partsCount > 0 ? partsTextureColor[partsCount - 1] : -1;
				partsType[partsCount] = partsCount > 0 ? partsType[partsCount - 1] : normal;
				partsTypeCorrection[partsCount] = partsCount > 0 ? partsTypeCorrection[partsCount - 1] : 1.0F;
				partsTypeFactor[partsCount] = partsCount > 0 ? partsTypeFactor[partsCount - 1] : 0.0F;
				partsTextureWidth[partsCount] = partsCount > 0 ? partsTextureWidth[partsCount - 1] : 64;
				partsTextureHeight[partsCount] = partsCount > 0 ? partsTextureHeight[partsCount - 1] : 32;
				return;
			}
		}
		if (s.startsWith("textureName")) {
			i1 = s.indexOf('=');
			if (i1 > -1) {
				int i2 = s.indexOf(';');
				if (i2 > -1) {
					partsTextureColor[partsCount] = Byte.valueOf(s.substring(i2 + 1));
					s = s.substring(0, i2);
				} else {
					partsTextureColor[partsCount] = -1;
				}
				partsTextureNameMap.put(partsCount, s.substring(i1 + 1));
				//Modchu_Debug.mDebug("Modchu_CustomModel partsTextureName put ="+s.substring(i1 + 1));
				return;
			}
		}
		if (s.startsWith("textureWidth")) {
			i1 = s.indexOf('=');
			if (i1 > -1) {
				partsTextureWidth[partsCount] = Integer.valueOf(s.substring(i1 + 1));
				//Modchu_Debug.mDebug("Modchu_CustomModel partsTextureWidth["+partsCount+"]="+partsTextureWidth[partsCount]);
				return;
			}
		}
		if (s.startsWith("textureHeight")) {
			i1 = s.indexOf('=');
			if (i1 > -1) {
				partsTextureHeight[partsCount] = Integer.valueOf(s.substring(i1 + 1));
				//Modchu_Debug.mDebug("Modchu_CustomModel partsTextureHeight["+partsCount+"]="+partsTextureHeight[partsCount]);
				return;
			}
		}
		if (s.startsWith("textureOffset")) {
			i1 = s.indexOf('=');
			if (i1 > -1) {
				s = s.substring(i1 + 1);
				i1 = s.indexOf(',');
				if (i1 > -1) {
					partsTextureOffsetX[partsCount] = Integer.valueOf(s.substring(0, i1));
					partsTextureOffsetY[partsCount] = Integer.valueOf(s.substring(i1 + 1));
					//Modchu_Debug.mDebug("Modchu_CustomModel partsTextureOffsetX["+partsCount+"]="+partsTextureOffsetX[partsCount]);
					//Modchu_Debug.mDebug("Modchu_CustomModel partsTextureOffsetY["+partsCount+"]="+partsTextureOffsetY[partsCount]);
					return;
				}
			}
		}
		if (s.startsWith("mirror")) {
			i1 = s.indexOf('=');
			if (i1 > -1) {
				//Modchu_Debug.mDebug("Modchu_CustomModel partsMirror s="+s);
				parts[partsCount].mirror = Boolean.valueOf(s.substring(i1 + 1));
				//Modchu_Debug.mDebug("Modchu_CustomModel partsMirror ="+s.substring(i1 + 1));
				return;
			}
		}
		if (s.startsWith("addBox")
				| s.startsWith("addPlate")
				| s.startsWith("addBall")) {
			boxType[partsCount][boxCount] = (byte) (s.startsWith("addBox") ? 0 : s.startsWith("addPlate") ? 1 : s.startsWith("addBall") ? 2 : 0);
			//Modchu_Debug.mDebug("boxType["+partsCount+"]["+boxCount+"]="+boxType[partsCount][boxCount]);
			i1 = s.indexOf('(');
			if (i1 > -1) {
				String s1 = null;
				for(int i2 = 0; i2 < 8; i2++) {
					s = s.substring(i1 + 1);
					//Modchu_Debug.mDebug("Modchu_CustomModel s="+s);
					i1 = s.indexOf(',');
					if (i1 > -1) {
						boxDataSetting(i2, s.substring(0, i1));
					} else {
						i1 = s.indexOf(')');
						if (i1 > -1) {
							boxDataSetting(i2, s.substring(0, i1));
						}
					}
				}
				boxCount++;
				return;
			}
		}
		if (s.startsWith("setRotationPoint")) {
			i1 = s.indexOf('(');
			if (i1 > -1) {
				String s1 = null;
				for(int i2 = 0; i2 < 8
						&& i1 > -1; i2++) {
					s = s.substring(i1 + 1);
					i1 = s.indexOf(',');
					if (i1 > -1) {
						switch (i2) {
						case 0:
							partsRotationPointX[partsCount] = Float.valueOf(s.substring(0, i1));
							//Modchu_Debug.mDebug("Modchu_CustomModel partsRotationPointX["+partsCount+"]="+partsRotationPointX[partsCount]);
							break;
						case 1:
							partsRotationPointY[partsCount] = Float.valueOf(s.substring(0, i1));
							//Modchu_Debug.mDebug("Modchu_CustomModel partsRotationPointY["+partsCount+"]="+partsRotationPointY[partsCount]);
							break;
						}
					} else {
						i1 = s.indexOf(')');
						if (i1 > -1) {
							partsRotationPointZ[partsCount] = Float.valueOf(s.substring(0, i1));
							//Modchu_Debug.mDebug("Modchu_CustomModel partsRotationPointZ["+partsCount+"]="+partsRotationPointZ[partsCount]);
						}
					}
				}
				return;
			}
		}
		if (s.startsWith("setRotateAngle")) {
			i1 = s.indexOf('(');
			if (i1 > -1) {
				String s1 = null;
				for(int i2 = 0; i2 < 8
						&& i1 > -1; i2++) {
					s = s.substring(i1 + 1);
					i1 = s.indexOf(',');
					if (i1 > -1) {
						switch (i2) {
						case 0:
							partsRotateAngleX[partsCount] = Float.valueOf(s.substring(0, i1));
							//Modchu_Debug.mDebug("Modchu_CustomModel partsRotateAngleX["+partsCount+"]="+partsRotateAngleX[partsCount]);
							break;
						case 1:
							partsRotateAngleY[partsCount] = Float.valueOf(s.substring(0, i1));
							//Modchu_Debug.mDebug("Modchu_CustomModel partsRotateAngleY["+partsCount+"]="+partsRotateAngleY[partsCount]);
							break;
						}
					} else {
						i1 = s.indexOf(')');
						if (i1 > -1) {
							partsRotateAngleZ[partsCount] = Float.valueOf(s.substring(0, i1));
							//Modchu_Debug.mDebug("Modchu_CustomModel partsRotateAngleZ["+partsCount+"]="+partsRotateAngleZ[partsCount]);
						}
					}
				}
				return;
			}
		}
		if (s.indexOf("addChild") > -1) {
			i1 = s.indexOf('.');
			if (i1 > -1) {
				partAddChildName[partsCount] = s.substring(0, i1);
				//Modchu_Debug.mDebug("Modchu_CustomModel partAddChildName["+partsCount+"]="+partAddChildName[partsCount]);
				return;
			}
		}
		if (s.startsWith("type")) {
			i1 = s.indexOf('=');
			if (i1 > -1) {
				s = s.substring(i1 + 1);
				i1 = s.indexOf(';');
				if (i1 > -1) {
					String s1 = s.substring(i1 + 1);
					s = s.substring(0, i1);
					i1 = s1.indexOf(';');
					String s2 = null;
					if (i1 > -1) {
						s2 = s1.substring(i1 + 1);
						s1 = s1.substring(0, i1);
					}
					if (s1 != null) partsTypeFactor[partsCount] = Float.valueOf(s1);
					if (s2 != null) partsTypeCorrection[partsCount] = Float.valueOf(s2);
					//Modchu_Debug.mDebug("Modchu_CustomModel partsTypeFactor["+partsCount+"]="+partsTypeFactor[partsCount]);
					//Modchu_Debug.mDebug("Modchu_CustomModel partsTypeCorrection["+partsCount+"]="+partsTypeCorrection[partsCount]);
				}
				if (s.equalsIgnoreCase("normal")) partsType[partsCount] = normal;
				else if (s.equalsIgnoreCase("eyeR")) partsType[partsCount] = eyeR;
				else if (s.equalsIgnoreCase("eyeL")) partsType[partsCount] = eyeL;
				else if (s.equalsIgnoreCase("ear")) partsType[partsCount] = ear;
				else if (s.equalsIgnoreCase("tail")) partsType[partsCount] = tail;
				//Modchu_Debug.mDebug("Modchu_CustomModel partsType["+partsCount+"]="+partsType[partsCount]);
				return;
			}
		}
	}

	private void boxDataSetting(int i2, String s) {
		switch (i2) {
		case 0:
			partsBoxInitPointX[partsCount][boxCount] = Float.valueOf(s);
			//Modchu_Debug.mDebug("Modchu_CustomModel partsBoxInitPointX["+partsCount+"]["+boxCount+"]="+partsBoxInitPointX[partsCount][boxCount]);
			break;
		case 1:
			partsBoxInitPointY[partsCount][boxCount] = Float.valueOf(s);
			//Modchu_Debug.mDebug("Modchu_CustomModel partsBoxInitPointY["+partsCount+"]["+boxCount+"]="+partsBoxInitPointY[partsCount][boxCount]);
			break;
		case 2:
			partsBoxInitPointZ[partsCount][boxCount] = Float.valueOf(s);
			//Modchu_Debug.mDebug("Modchu_CustomModel partsBoxInitPointZ["+partsCount+"]["+boxCount+"]="+partsBoxInitPointZ[partsCount][boxCount]);
			break;
		case 3:
			partsBoxX[partsCount][boxCount] = Integer.valueOf(s);
			//Modchu_Debug.mDebug("Modchu_CustomModel partsBoxX["+partsCount+"]["+boxCount+"]="+partsBoxX[partsCount][boxCount]);
			break;
		case 4:
			partsBoxY[partsCount][boxCount] = Integer.valueOf(s);
			//Modchu_Debug.mDebug("Modchu_CustomModel partsBoxX["+partsCount+"]["+boxCount+"]="+partsBoxY[partsCount][boxCount]);
			break;
		case 5:
			partsBoxZ[partsCount][boxCount] = Integer.valueOf(s);
			//Modchu_Debug.mDebug("Modchu_CustomModel partsBoxX["+partsCount+"]["+boxCount+"]="+partsBoxZ[partsCount][boxCount]);
			break;
		case 6:
			partsScaleFactor[partsCount][boxCount] = Float.valueOf(s);
			//Modchu_Debug.mDebug("Modchu_CustomModel partsScaleFactor["+partsCount+"]["+boxCount+"]="+partsScaleFactor[partsCount][boxCount]);
			break;
		case 7:
			partsScaleCorrection[partsCount][boxCount] = Float.valueOf(s);
			//Modchu_Debug.mDebug("Modchu_CustomModel partsScaleCorrection["+partsCount+"]["+boxCount+"]="+partsScaleCorrection[partsCount][boxCount]);
			break;
		}
	}

	private void customInitModel(float psize, float pyoffset) {
		String name = mainModeltextureName;
		Modchu_Debug.cDebug("customInitModel mainModeltextureName="+mainModeltextureName);
		int i1 = name.lastIndexOf("_");
		if (i1 > -1) name = name.substring(i1 +1);
		mainModel = (MultiModelBaseBiped) Modchu_Reflect.newInstance(mod_Modchu_ModchuLib.mod_modchu_modchulib.getClassName(
				mainModeltextureName.equalsIgnoreCase("default") | mainModeltextureName == null ? "MultiModel" : "MultiModel_"+name) , new Class[]{ float.class }, new Object[]{ 0.0F });
		//Modchu_Debug.mDebug("customInitModel");
	}

	private void colorSetting(MMM_IModelCaps entityCaps) {
		if (baseModel != null
				&& baseModel.entityCaps != null) {
			mainModel.entityCaps = baseModel.entityCaps;
		}
//-@-151
		EntityLiving entity = (EntityLiving) baseModel.getCapsValue(baseModel.entityCaps.caps_Entity);
//@-@151
		MMM_ModelMultiBase model = mainModel != null && mainModel.entityCaps != null ? mainModel : baseModel;
		if (model != null
			&& model.entityCaps != null) ;else {
			Modchu_Debug.mDebug("Modchu_CustomModel colorSetting model.entityCaps == null !!");
			return;
		}
		int color = getMaidColor(entity);
		mainModeltexture = getTexture(model, entity, mainModeltextureName, color);
		if (model.entityCaps != null
				&& model instanceof MultiModelBaseBiped) {
			MultiModelBaseBiped multiModelBaseBiped = (MultiModelBaseBiped) model;
			if (textureList != null) {
				for(int i1 = 0; i1 < partsTextureNameMap.size() ;i1++) {
					String s1 = partsTextureNameMap.get(i1);
					String s2 =  (String) multiModelBaseBiped.getCapsValue(multiModelBaseBiped.caps_texture, s1, partsTextureColor[i1] == -1 ? color : (int) partsTextureColor[i1]);
					Modchu_Debug.cDebug("Modchu_CustomModel colorSetting add "+s1+" color="+(partsTextureColor[i1] == -1 ? color : (int) partsTextureColor[i1])+" texture="+s2);
					textureList.add(i1, s2);
				}
			}
		}
		Modchu_Debug.cDebug("Modchu_CustomModel colorSetting mainModeltextureName="+mainModeltextureName+" color="+color+" mainModeltexture="+mainModeltexture);
		Render render = RenderManager.instance.getEntityRenderObject(entity);
/*
		setArmorModelMethod = Modchu_Reflect.getMethod(render.getClass(), "setArmorModel", new Class[]{ MultiModelBaseBiped.class, EntityPlayer.class, int.class, float.class });
		if (setArmorModelMethod != null) {
			setArmorModelMethodType = 1;
		} else {
			setArmorModelMethod = Modchu_Reflect.getMethod(render.getClass(), "setArmorModelEx", new Class[]{ mod_Modchu_ModchuLib.LMM_EntityLittleMaid, int.class, float.class });
			if (setArmorModelMethod != null) {
				setArmorModelMethodType = 2;
			} else {
				setArmorModelMethod = Modchu_Reflect.getMethod(render.getClass(), "setArmorModel", new Class[]{ EntityPlayer.class, int.class, float.class });
				if (setArmorModelMethod != null) {
					setArmorModelMethodType = 3;
				}
			}
		}
*/
	}

	private String getTexture(MMM_ModelMultiBase model, EntityLiving entity, String s, int i) {
		int armorType;
		if (model.entityCaps != null
				&& model instanceof MultiModelBaseBiped) {
			MultiModelBaseBiped multiModelBaseBiped = (MultiModelBaseBiped) model;
			armorType = Modchu_ModelCapsHelper.getCapsValueInt(multiModelBaseBiped, multiModelBaseBiped.caps_armorType);
			return armorType < 2 ?
					(String) multiModelBaseBiped.getCapsValue(multiModelBaseBiped.caps_texture, s, i) :
						(String) multiModelBaseBiped.getCapsValue(multiModelBaseBiped.caps_armorTexture, s, armorType);
		}
		armorType = Modchu_ModelCapsHelper.getCapsValueInt(baseModel, baseModel.caps_armorType);
		Modchu_Debug.mDebug("getTexture "+(armorType < 2 ?
				(String) baseModel.getCapsValue(baseModel.caps_texture, s, i) :
					(String) baseModel.getCapsValue(baseModel.caps_armorTexture, s, armorType)));
		return armorType < 2 ?
				(String) baseModel.getCapsValue(baseModel.caps_texture, s, i) :
					(String) baseModel.getCapsValue(baseModel.caps_armorTexture, s, armorType);
	}

	private int getMaidColor(EntityLiving entity) {
		Object o = null;
		if (mod_Modchu_ModchuLib.mod_LMM_littleMaidMob != null
				&& mod_Modchu_ModchuLib.LMM_EntityLittleMaid.isInstance(entity)) {
			o = (Integer) Modchu_Reflect.getFieldObject(mod_Modchu_ModchuLib.LMM_EntityLittleMaid, "maidColor", entity);
		} else {
			return Modchu_ModelCapsHelper.getCapsValueInt(baseModel, baseModel.caps_maidColor, entity);
		}
		if (o != null) return (Integer) o;
		return 0;
	}

	private void allShowModelSetting(boolean b) {
		ModelRenderer modelRenderer;
		for (int i = 0; i < modelRendererFieldsMap.size(); i++) {
			try {
				modelRenderer = (ModelRenderer) modelRendererFieldsMap.get(i).get(mainModel);
				if (modelRenderer != null) {
					if (b) b = showModelMemoryList.get(modelRenderer);
					((ModelRenderer) modelRendererFieldsMap.get(i).get(mainModel)).showModel = b;
					//Modchu_Debug.mDebug("allShowModelSetting modelRendererFieldsMap.get("+i+").getName() = "+modelRendererFieldsMap.get(i).getName()+" b="+b);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void customModelShowModelSetting(String s, boolean b) {
		if (parts != null) {
			boolean b1;
			for(int i = 0; i < parts.length ;i++) {
				b1 = false;
				if (b) b = customModelshowModelMemoryList.get(parts[i]);
				if (s == null) {
					b1 = b;
				} else {
					if (partsTextureNameMap.get(i).equalsIgnoreCase(s)) b1 = b;
				}
				//Modchu_Debug.mDebug("customModelShowModelSetting "+partsTextureNameMap.get(i)+" customModelshowModelMemoryList.get(parts["+i+"])="+(customModelshowModelMemoryList.get(parts[i]))+" s="+s+" b="+b+" b1="+b1);
				parts[i].showModel = b1;
			}
		}
	}

	private void syncNameListSetting() {
		String[] s = {
				"runActionNumber",
				"shortcutKeysAction", "actionFlag"
				//, "actionSpeed"
		};
		for(int i = 0; i < s.length; i++) {
			syncNameList.add(s[i]);
		}
	}

	private void fieldSyncInit(boolean reverse) {
		Field field;
		String s;
		int mapCount = 0;
		for(int i = 0; i < syncNameList.size(); i++) {
			s = syncNameList.get(i);
			field = Modchu_Reflect.getField(reverse ? mainModel.getClass() : baseModel.getClass(), s);
			if (field != null) {
				Modchu_Debug.mDebug("fieldSyncInit put s="+s);
				if (reverse) {
					mainSyncNameMap.put(mapCount, s);
					mainSyncMap.put(s, field);
				} else {
					baseSyncNameMap.put(mapCount, s);
					baseSyncMap.put(s, field);
				}
				mapCount++;
			} else {
				Modchu_Debug.mDebug("fieldSyncInit field == null!! s="+s);
			}
		}
	}

	private void fieldAllSyncInit(boolean reverse) {
		Field[] fields = reverse ? mainModel.getClass().getFields() : baseModel.getClass().getFields();
		Field[] mainFields = reverse ? baseModel.getClass().getFields() : mainModel.getClass().getFields() ;
		String fieldsName;
		String mainFieldsName;
		int mod;
		int mapCount = 0;
		Object o;
		for (int i = 0; i < fields.length; i++) {
			//Modchu_Debug.mDebug("fields["+i+"].getName()="+fields[i].getName()+" fields["+i+"].getType() = "+fields[i].getType());
			try {
				mod = fields[i].getModifiers();
				if (!Modifier.isFinal(mod)
						&& Modifier.isPrivate(mod)) {
					o = Modchu_Reflect.getPrivateValue(reverse ? mainModel.getClass() : baseModel.getClass(), reverse ? mainModel : baseModel, fields[i].getName());
				} else {
					o = fields[i].get(reverse ? mainModel : baseModel);
				}
				fieldsName = fields[i].getName();
				if (o != null
						&& !(o instanceof ModelRenderer)
						&& !(o instanceof ModelRenderer[])) {
					for (int i1 = 0; i1 < mainFields.length; i1++) {
						mainFieldsName = mainFields[i1].getName();
						//if (fieldsName.equalsIgnoreCase("isSneak")) Modchu_Debug.mDebug("fieldsName = "+fieldsName+" mainFieldsName="+mainFieldsName);
						if (mainFieldsName.equalsIgnoreCase(fieldsName)) {
							//if (fieldsName.equalsIgnoreCase("isSneak")) Modchu_Debug.mDebug("isAccessible() = "+mainFields[i1].isAccessible());
							mod = mainFields[i1].getModifiers();
							if (!Modifier.isFinal(mod)) {
								Modchu_Debug.mDebug("put fieldsName="+fieldsName);
								if (reverse) {
									mainAllSyncNameMap.put(mapCount, fieldsName);
									mainAllSyncMap.put(fieldsName, fields[i]);
								} else {
									baseAllSyncNameMap.put(mapCount, fieldsName);
									baseAllSyncMap.put(fieldsName, fields[i]);
								}
								mapCount++;
								break;
							} else {
								//Modchu_Debug.mDebug("No put fieldsName="+fieldsName);
							}
						}
					}
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	private void fieldSync(boolean reverse, EntityLiving entityliving, float f, float f1, float renderPartialTicks) {
		if (baseSyncMap.isEmpty()) fieldSyncInit(false);
		if (mainSyncMap.isEmpty()) fieldSyncInit(true);
		HashMap<String, Field> map = reverse ? mainSyncMap : baseSyncMap;
		HashMap<String, Field> map2 = reverse ? baseSyncMap : mainSyncMap;
		HashMap<Integer, String> nameMap = reverse ? mainSyncNameMap : baseSyncNameMap;
		HashMap<Integer, String> nameMap2 = reverse ? baseSyncNameMap : mainSyncNameMap;
		fieldSync(reverse, map, map2, nameMap, nameMap2);
	}

	private void fieldAllSync(boolean reverse, EntityLiving entityliving, float f, float f1, float renderPartialTicks) {
		if (baseAllSyncMap.isEmpty()) fieldAllSyncInit(false);
		if (mainAllSyncMap.isEmpty()) fieldAllSyncInit(true);
		HashMap<String, Field> map = reverse ? mainAllSyncMap : baseAllSyncMap;
		HashMap<String, Field> map2 = reverse ? baseAllSyncMap : mainAllSyncMap;
		HashMap<Integer, String> nameMap = reverse ? mainAllSyncNameMap : baseAllSyncNameMap;
		HashMap<Integer, String> nameMap2 = reverse ? baseAllSyncNameMap : mainAllSyncNameMap;
		fieldSync(reverse, map, map2, nameMap, nameMap2);
	}

	private void fieldSync(boolean reverse, HashMap<String, Field> map, HashMap<String, Field> map2, HashMap<Integer, String> nameMap, HashMap<Integer, String> nameMap2) {
		String s;
		String s2;
		Field field;
		Field field2;
		Object o;
		int mod;
		for (int i = 0; i < map.size(); i++) {
			s = nameMap.get(i);
			field = map.get(s);
			if (field != null) ;else {
				Modchu_Debug.mDebug("fieldSync 1 s="+s+" null!!");
				continue;
			}
			field2 = map2.get(s);
			if (field2 != null) ;else {
				Modchu_Debug.mDebug("fieldSync 2 s="+s+" null!!");
				continue;
			}
			mod = field.getModifiers();
			try {
				if (Modifier.isPrivate(mod)) {
					o = Modchu_Reflect.getPrivateValue(reverse ? mainModel.getClass() : baseModel.getClass(), reverse ? mainModel : baseModel, field.getName());
					Modchu_Reflect.setPrivateValue(reverse ? baseModel.getClass() : mainModel.getClass(), reverse ? baseModel : mainModel, field2.getName(), o);
				} else {
					o = field.get(reverse ? mainModel : baseModel);
					field2.set(reverse ? baseModel : mainModel, o);
				}
				//Modchu_Debug.mDebug("fieldSync s="+s);
				//if (s.equalsIgnoreCase("actionSpeed")) Modchu_Debug.mDebug("o = "+o);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	private void actionSync() {
		if (mainModel != null
				&& mainModel instanceof MultiModelBaseBiped) {
			MultiModelBaseBiped multiModelBaseBiped = ((MultiModelBaseBiped) mainModel);
			baseModel.bipedBody.rotateAngleZ = multiModelBaseBiped.bipedBody.rotateAngleZ;
			baseModel.bipedRightArm.rotateAngleX = multiModelBaseBiped.bipedRightArm.rotateAngleX;
			baseModel.bipedRightArm.rotateAngleY = multiModelBaseBiped.bipedRightArm.rotateAngleY;
			baseModel.bipedRightArm.rotateAngleZ = multiModelBaseBiped.bipedRightArm.rotateAngleZ;
			baseModel.bipedLeftArm.rotateAngleX = multiModelBaseBiped.bipedLeftArm.rotateAngleX;
			baseModel.bipedLeftArm.rotateAngleY = multiModelBaseBiped.bipedLeftArm.rotateAngleY;
			baseModel.bipedLeftArm.rotateAngleZ = multiModelBaseBiped.bipedLeftArm.rotateAngleZ;
		}
	}

	private String obfuscationNameCheck(String s) {
		if (!mod_Modchu_ModchuLib.mod_modchu_modchulib.isRelease()) return s;
		String[] s1 = {
				"bipedHead", "bipedHeadwear", "bipedBody",
				"bipedRightArm", "bipedLeftArm", "bipedRightLeg", "bipedLeftLeg", "bipedCloak",
				"bipedEars"
		};
		String[] s2 = {
				"c", "d", "e",
				"f", "g", "h", "i", "j",
				"k"
		};
		for(int i = 0; i < s1.length; i++) {
			if (s.equalsIgnoreCase(s1[i])) return s2[i];
		}
		return s;
	}

}