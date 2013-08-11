package net.minecraft.src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Modchu_CustomModel extends ModelBase {

	public MMM_ModelMultiBase mainModel;
	public MultiModelBaseBiped baseModel;
	public Modchu_ModelRenderer[] parts;
	public String mainModeltextureName;
	public Object mainModeltexture;
	public String[] partsName;
	public String[] partAddChildName;
	public int[] partsTextureWidth;
	public int[] partsTextureHeight;
	public int[] partsBoxNumber;
	public int[][] partsTextureOffsetX;
	public int[][] partsTextureOffsetY;
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
	public byte[][] boxType;
	public int partsNumberMax;
	public int partsBoxNumberMax;
	public static final byte normal = 0;
	public static final byte eyeR = 1;
	public static final byte eyeL = 2;
	public static final byte ear = 3;
	public static final byte tail = 4;
	public static final int maxTypeMode = 5;
	public static final int maxboxType = 3;
	public HashMap<Integer, String> partsTextureNameMap = new HashMap();
	public LinkedList<Object> textureList = new LinkedList<Object>();
//-@-152
	public Object[] partsTextures;
//@-@152
	private MultiModelBaseBiped armorSyncBaseModel;
	private boolean changeModelInit;
	private boolean allRendering = false;
	private HashMap<MMM_ModelRenderer, Boolean> showModelMemoryList = new HashMap();
	private HashMap<MMM_ModelRenderer, Boolean> customModelshowModelMemoryList = new HashMap();
	private HashMap<Integer, Field> modelRendererFieldsMap = new HashMap();
	private File cfgdir;
	private int partsCount;
	private int boxCount;
	private int[] boxNumberCount;
	private HashMap<String, Field> baseSyncMap = new HashMap();
	private HashMap<String, Field> baseAllSyncMap = new HashMap();
	private HashMap<String, Field> mainSyncMap = new HashMap();
	private HashMap<String, Field> mainAllSyncMap = new HashMap();
	private HashMap<Integer, String> baseSyncNameMap = new HashMap();
	private HashMap<Integer, String> baseAllSyncNameMap = new HashMap();
	private HashMap<Integer, String> mainSyncNameMap = new HashMap();
	private HashMap<Integer, String> mainAllSyncNameMap = new HashMap();
	private List<String> syncNameList = new ArrayList<String>();
	private String cfgName;
	private MMM_IModelCaps debaEntityCaps;
//-@-152
	private Object[] resourceLocationsMain = new Object[3];
//@-@152
	//private Class PFLM_ModelData;
	//private Method setArmorModelMethod;
	//private int setArmorModelMethodType;

	public Modchu_CustomModel(MultiModelBaseBiped multiModelBaseBiped, String s, List list, float f, float f1) {
		baseModel = multiModelBaseBiped;
		if (s != null) {
			cfgName = s;
			init(s, list, f, f1);
			Modchu_Debug.cDebug("Modchu_CustomModel init end.");
		}
	}

	public Modchu_CustomModel(MultiModelBaseBiped multiModelBaseBiped, MMM_ModelMultiBase modelBiped, String s, float f, float f1) {
		baseModel = multiModelBaseBiped;
		mainModel = modelBiped;
		mainModeltextureName = s;
	}

	public void init(String s, List reLoadList, float f, float f1) {
		boolean cfgReLoad = false;
		if (s != null) ;else {
			s = cfgName;
			cfgReLoad = true;
		}
		partsBoxNumberMax = 0;
		partsCount = 0;
		boxCount = 0;
		boxNumberCount = new int[256];

		cfgdir = new File(mod_Modchu_ModchuLib.modchu_Main.getMinecraftDir(), "/config/CustomModel/");
		String s1 = new StringBuilder().append("CustomModel_").append(s).append(".cfg").toString();
		Modchu_Debug.cDebug("Modchu_CustomModel cfg["+s1+"] loadInit");
		loadInit(new File(cfgdir, s1), reLoadList, cfgReLoad);
		if (partsNumberMax < 1) {
			Modchu_Debug.cDebug("Modchu_CustomModel init partsNumberMax="+partsNumberMax+" end");
			return;
		}
		Modchu_Debug.cDebug("Modchu_CustomModel customInitModel partsNumberMax="+partsNumberMax);
		newInitSetting();

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
		load(file, reLoadList, cfgReLoad);
		Modchu_Debug.cDebug("Modchu_CustomModel cfg load end");

		//Modchu_Debug.mDebug("add partsNumberMax="+partsNumberMax);
		for (int i = 0;i < partsNumberMax; i++) {
			partsInitSetting(i, f);
		}
		//syncNameListSetting();
		//PFLM_ModelData = Modchu_Reflect.loadClass(mod_Modchu_ModchuLib.modchu_Main.mod_modchu_modchulib.getClassName("PFLM_ModelData"));
	}

	public void newInitSetting() {
		newPartsInit();
		newMainModelInit();
		Modchu_Debug.cDebug("Modchu_CustomModel customInitModel end");
		newPartsBoxInit();
	}

	public void deleteParts(int i) {
		if (i < 0
				| i >= parts.length) return;
		Object[][] temp = tempParts();
		Object[][][] tempBox = tempPartsBox();
		partsNumberMaxCheck();
		parts[i].clearCubeList();
		partsNumberMax--;
		newPartsInit();
		newPartsBoxInit();
		int j = 0;
		for(int i1 = 0; i1< partsNumberMax + 1; i1++) {
			if (i1 == i) continue;
			//Modchu_Debug.mDebug("deleteParts i1="+i1+" j="+j);
			parts[j] = (Modchu_ModelRenderer) temp[0][i1];
			partsName[j] = (String) temp[1][i1];
			//Modchu_Debug.mDebug("deleteParts partsName[j]="+partsName[j]+" j="+j);
			partAddChildName[j] = (String) temp[2][i1];
			partsTextureWidth[j] = (Integer) temp[3][i1];
			partsTextureHeight[j] = (Integer) temp[4][i1];
			partsBoxNumber[j] = (Integer) temp[5][i1];
			partsRotationPointX[j] = (Float) temp[6][i1];
			partsRotationPointY[j] = (Float) temp[7][i1];
			partsRotationPointZ[j] = (Float) temp[8][i1];
			partsRotateAngleX[j] = (Float) temp[9][i1];
			partsRotateAngleY[j] = (Float) temp[10][i1];
			partsRotateAngleZ[j] = (Float) temp[11][i1];
			partsType[j] = (Byte) temp[12][i1];
			partsTextureColor[j] = (Byte) temp[13][i1];
			partsTypeFactor[j] = (Float) temp[14][i1];
			partsTypeCorrection[j] = (Float) temp[15][i1];
			if (partsBoxNumberMax > 0) {
				for(int i2 = 0; i2 < partsBoxNumberMax; i2++) {
					boxType[j][i2] = (Byte) tempBox[0][i1][i2];
					partsTextureOffsetX[j][i2] = (Integer) tempBox[1][i1][i2];
					partsTextureOffsetY[j][i2] = (Integer) tempBox[2][i1][i2];
					partsBoxInitPointX[j][i2] = (Float) tempBox[3][i1][i2];
					partsBoxInitPointY[j][i2] = (Float) tempBox[4][i1][i2];
					partsBoxInitPointZ[j][i2] = (Float) tempBox[5][i1][i2];
					partsBoxX[j][i2] = (Integer) tempBox[6][i1][i2];
					partsBoxY[j][i2] = (Integer) tempBox[7][i1][i2];
					partsBoxZ[j][i2] = (Integer) tempBox[8][i1][i2];
					partsScaleFactor[j][i2] = (Float) tempBox[9][i1][i2];
					partsScaleCorrection[j][i2] = (Float) tempBox[10][i1][i2];
				}
			}
			j++;
		}
		for (int i1 = 0; i1 < partsNumberMax; i1++) {
			partsInitSetting(i1, 0.0F);
		}
		for (int i1 = i; i1 < partsTextureNameMap.size() - 1; i1++) {
			partsTextureNameMap.put(i1, partsTextureNameMap.get(i1 + 1));
		}
		partsTextureNameMap.remove(partsTextureNameMap.size());
		textureList.remove(i);
		//Modchu_Debug.mDebug("deleteParts parts.length="+parts.length+" partsTextureNameMap.size()="+partsTextureNameMap.size());
	}

	private void partsNumberMaxCheck() {
		if (boxNumberCount != null) {
			for (int i = 0;i < partsNumberMax; i++) {
				partsBoxNumber[i] = boxNumberCount[i];
				if (partsBoxNumber[i] > partsBoxNumberMax) partsBoxNumberMax = partsBoxNumber[i];
			}
		} else {
			int n = 0;
			for (int i = 0;i < partsNumberMax; i++) {
				if (partsBoxNumber[i] > n) n = partsBoxNumber[i];
			}
			if (n > 0) partsBoxNumberMax = n;
		}
	}

	public void deleteBox(int i) {
		deleteBox(i, partsBoxNumber[i] - 1);
	}

	public void deleteBox(int i, int i2) {
		Object[][] temp = tempParts();
		Object[][][] tempBox = tempPartsBox();
		partsBoxNumber[i]--;
		newPartsBoxInit();
		int j = 0;
		for(int i1 = 0; i1< partsNumberMax; i1++) {
			//Modchu_Debug.mDebug("deleteParts i1="+i1+" j="+j);
			parts[i1] = (Modchu_ModelRenderer) temp[0][i1];
			partsName[i1] = (String) temp[1][i1];
			//Modchu_Debug.mDebug("deleteParts partsName[i1]="+partsName[i1]+" j="+j);
			partAddChildName[i1] = (String) temp[2][i1];
			partsTextureWidth[i1] = (Integer) temp[3][i1];
			partsTextureHeight[i1] = (Integer) temp[4][i1];
			if (i != i1) partsBoxNumber[i1] = (Integer) temp[5][i1];
			partsRotationPointX[i1] = (Float) temp[6][i1];
			partsRotationPointY[i1] = (Float) temp[7][i1];
			partsRotationPointZ[i1] = (Float) temp[8][i1];
			partsRotateAngleX[i1] = (Float) temp[9][i1];
			partsRotateAngleY[i1] = (Float) temp[10][i1];
			partsRotateAngleZ[i1] = (Float) temp[11][i1];
			partsType[i1] = (Byte) temp[12][i1];
			partsTextureColor[i1] = (Byte) temp[13][i1];
			partsTypeFactor[i1] = (Float) temp[14][i1];
			partsTypeCorrection[i1] = (Float) temp[15][i1];
			j = 0;
			for(int i3 = 0; i3 < partsBoxNumber[i1]; i3++) {
				if (i1 == i
						&& i3 == i2) continue;
				boxType[i1][j] = (Byte) tempBox[0][i1][i3];
				partsTextureOffsetX[i1][j] = (Integer) tempBox[1][i1][i3];
				partsTextureOffsetY[i1][j] = (Integer) tempBox[2][i1][i3];
				partsBoxInitPointX[i1][j] = (Float) tempBox[3][i1][i3];
				partsBoxInitPointY[i1][j] = (Float) tempBox[4][i1][i3];
				partsBoxInitPointZ[i1][j] = (Float) tempBox[5][i1][i3];
				partsBoxX[i1][j] = (Integer) tempBox[6][i1][i3];
				partsBoxY[i1][j] = (Integer) tempBox[7][i1][i3];
				partsBoxZ[i1][j] = (Integer) tempBox[8][i1][i3];
				partsScaleFactor[i1][j] = (Float) tempBox[9][i1][i3];
				partsScaleCorrection[i1][j] = (Float) tempBox[10][i1][i3];
				j++;
			}
		}
		for (int i1 = 0; i1 < partsNumberMax; i1++) {
			partsInitSetting(i1, 0.0F);
		}
	}

	public void addBox(int i) {
		addBox(i, partsBoxNumber[i]);
	}

	public void addBox(int i, int i2) {
		//Modchu_Debug.mDebug("addBox i="+i+" i2="+i2);
		Object[][] temp = tempParts();
		Object[][][] tempBox = tempPartsBox();
		partsBoxNumber[i]++;
		newPartsBoxInit();
		//Modchu_Debug.mDebug("addBox partsBoxNumber["+i+"]="+partsBoxNumber[i]);
		int j = 0;
		for(int i1 = 0; i1< partsNumberMax; i1++) {
			//Modchu_Debug.mDebug("addBox i1="+i1);
			parts[i1] = (Modchu_ModelRenderer) temp[0][i1];
			partsName[i1] = (String) temp[1][i1];
			//Modchu_Debug.mDebug("addBox partsName["+i1+"]="+partsName[i1]);
			partAddChildName[i1] = (String) temp[2][i1];
			partsTextureWidth[i1] = (Integer) temp[3][i1];
			partsTextureHeight[i1] = (Integer) temp[4][i1];
			if (i != i1) partsBoxNumber[i1] = (Integer) temp[5][i1];
			partsRotationPointX[i1] = (Float) temp[6][i1];
			partsRotationPointY[i1] = (Float) temp[7][i1];
			partsRotationPointZ[i1] = (Float) temp[8][i1];
			partsRotateAngleX[i1] = (Float) temp[9][i1];
			partsRotateAngleY[i1] = (Float) temp[10][i1];
			partsRotateAngleZ[i1] = (Float) temp[11][i1];
			partsType[i1] = (Byte) temp[12][i1];
			partsTextureColor[i1] = (Byte) temp[13][i1];
			partsTypeFactor[i1] = (Float) temp[14][i1];
			partsTypeCorrection[i1] = (Float) temp[15][i1];
			j = 0;
			//Modchu_Debug.mDebug("addBox partsBoxNumber["+i1+"]="+partsBoxNumber[i1]);
			for(int i3 = 0; i3 < partsBoxNumber[i1]; i3++) {
				//Modchu_Debug.mDebug("addBox i3="+i3);
				if (i1 == i
						&& i3 == i2) {
					//Modchu_Debug.mDebug("addBox newadd i="+i+" i2="+i2);
					boxType[i1][i3] = 0;
					partsTextureOffsetX[i1][i3] = 0;
					partsTextureOffsetY[i1][i3] = 0;
					partsBoxInitPointX[i1][i3] = 0.0F;
					partsBoxInitPointY[i1][i3] = 0.0F;
					partsBoxInitPointZ[i1][i3] = 0.0F;
					partsBoxX[i1][i3] = 1;
					partsBoxY[i1][i3] = 1;
					partsBoxZ[i1][i3] = 1;
					partsScaleFactor[i1][i3] = 1.0F;
					partsScaleCorrection[i1][i3] = 0.0F;
					continue;
				}
				//Modchu_Debug.mDebug("addBox add else i1="+i1+" i3="+i3);
				boxType[i1][i3] = (Byte) tempBox[0][i1][j];
				partsTextureOffsetX[i1][i3] = (Integer) tempBox[1][i1][j];
				partsTextureOffsetY[i1][i3] = (Integer) tempBox[2][i1][j];
				partsBoxInitPointX[i1][i3] = (Float) tempBox[3][i1][j];
				partsBoxInitPointY[i1][i3] = (Float) tempBox[4][i1][j];
				partsBoxInitPointZ[i1][i3] = (Float) tempBox[5][i1][j];
				partsBoxX[i1][i3] = (Integer) tempBox[6][i1][j];
				partsBoxY[i1][i3] = (Integer) tempBox[7][i1][j];
				partsBoxZ[i1][i3] = (Integer) tempBox[8][i1][j];
				partsScaleFactor[i1][i3] = (Float) tempBox[9][i1][j];
				partsScaleCorrection[i1][i3] = (Float) tempBox[10][i1][j];
				j++;
			}
		}
		for (int i1 = 0; i1 < partsNumberMax; i1++) {
			partsInitSetting(i1, 0.0F);
		}
	}

	public void addParts() {
		Object[][] temp = tempParts();
		Object[][][] tempBox = tempPartsBox();
		partsNumberMax++;
		newPartsInit();
		newPartsBoxInit();
		for(int i = 0; i < partsNumberMax - 1; i++) {
			parts[i] = (Modchu_ModelRenderer) temp[0][i];
			partsName[i] = (String) temp[1][i];
			partAddChildName[i] = (String) temp[2][i];
			partsTextureWidth[i] = (Integer) temp[3][i];
			partsTextureHeight[i] = (Integer) temp[4][i];
			partsBoxNumber[i] = (Integer) temp[5][i];
			partsRotationPointX[i] = (Float) temp[6][i];
			partsRotationPointY[i] = (Float) temp[7][i];
			partsRotationPointZ[i] = (Float) temp[8][i];
			partsRotateAngleX[i] = (Float) temp[9][i];
			partsRotateAngleY[i] = (Float) temp[10][i];
			partsRotateAngleZ[i] = (Float) temp[11][i];
			partsType[i] = (Byte) temp[12][i];
			partsTextureColor[i] = (Byte) temp[13][i];
			partsTypeFactor[i] = (Float) temp[14][i];
			partsTypeCorrection[i] = (Float) temp[15][i];
			for(int i3 = 0; i3 < partsBoxNumber[i]; i3++) {
				boxType[i][i3] = (Byte) tempBox[0][i][i3];
				partsTextureOffsetX[i][i3] = (Integer) tempBox[1][i][i3];
				partsTextureOffsetY[i][i3] = (Integer) tempBox[2][i][i3];
				partsBoxInitPointX[i][i3] = (Float) tempBox[3][i][i3];
				partsBoxInitPointY[i][i3] = (Float) tempBox[4][i][i3];
				partsBoxInitPointZ[i][i3] = (Float) tempBox[5][i][i3];
				partsBoxX[i][i3] = (Integer) tempBox[6][i][i3];
				partsBoxY[i][i3] = (Integer) tempBox[7][i][i3];
				partsBoxZ[i][i3] = (Integer) tempBox[8][i][i3];
				partsScaleFactor[i][i3] = (Float) tempBox[9][i][i3];
				partsScaleCorrection[i][i3] = (Float) tempBox[10][i][i3];
			}
		}
		int i = partsNumberMax - 1;
		parts[i] = new Modchu_ModelRenderer(mainModel);
		partsName[i] = "Parts"+i;
		partsTextureWidth[i] = 64;
		partsTextureHeight[i] = 32;
		if (i > 0) {
			partAddChildName[i] = partAddChildName[i - 1];
			partsTextureNameMap.put(i, partsTextureNameMap.get(i - 1));
		} else {
			partsTextureNameMap.put(i, "default");
		}
	}

	private Object[][] tempParts() {
		Object[][] temp = new Object[16][partsNumberMax];
		for(int i = 0; i < partsNumberMax; i++) {
			temp[0][i] = parts[i] != null ? parts[i] : new Modchu_ModelRenderer(mainModel);
			temp[1][i] = partsName[i] != null ? partsName[i] : null;
			temp[2][i] = partAddChildName[i] != null ? partAddChildName[i] : null;
			temp[3][i] = partsTextureWidth[i] == 0 ? partsTextureWidth[i] : 64;
			temp[4][i] = partsTextureHeight[i] == 0 ? partsTextureHeight[i] : 32;
			temp[5][i] = partsBoxNumber[i];
			temp[6][i] = partsRotationPointX[i];
			temp[7][i] = partsRotationPointY[i];
			temp[8][i] = partsRotationPointZ[i];
			temp[9][i] = partsRotateAngleX[i];
			temp[10][i] = partsRotateAngleY[i];
			temp[11][i] = partsRotateAngleZ[i];
			temp[12][i] = partsType[i];
			temp[13][i] = partsTextureColor[i];
			temp[14][i] = partsTypeFactor[i];
			temp[15][i] = partsTypeCorrection[i];
		}
		return temp;
	}

	private Object[][][] tempPartsBox() {
		partsNumberMaxCheck();
		boxNumberCount = null;
		Object[][][] temp = new Object[11][partsNumberMax][partsBoxNumberMax];
		if (partsBoxNumberMax > 0) {
			for(int i = 0; i < partsNumberMax; i++) {
				for(int i1 = 0; i1 < partsBoxNumberMax; i1++) {
					temp[0][i][i1] = boxType[i][i1];
					temp[1][i][i1] = partsTextureOffsetX[i][i1];
					temp[2][i][i1] = partsTextureOffsetY[i][i1];
					temp[3][i][i1] = partsBoxInitPointX[i][i1];
					temp[4][i][i1] = partsBoxInitPointY[i][i1];
					temp[5][i][i1] = partsBoxInitPointZ[i][i1];
					temp[6][i][i1] = partsBoxX[i][i1];
					temp[7][i][i1] = partsBoxY[i][i1];
					temp[8][i][i1] = partsBoxZ[i][i1];
					temp[9][i][i1] = partsScaleFactor[i][i1];
					temp[10][i][i1] = partsScaleCorrection[i][i1];
				}
			}
		}
		return temp;
	}

	private void newPartsInit() {
		parts = new Modchu_ModelRenderer[partsNumberMax];
		partsName = new String[partsNumberMax];
		partAddChildName = new String[partsNumberMax];
		partsTextureWidth = new int[partsNumberMax];
		partsTextureHeight = new int[partsNumberMax];
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
		partsTextures = new Object[partsNumberMax];
	}

	private void newPartsBoxInit() {
		partsNumberMaxCheck();
		Modchu_Debug.mDebug("newPartsBoxInit() partsBoxNumberMax="+partsBoxNumberMax);

		boxNumberCount = null;
		boxType = new byte[partsNumberMax][partsBoxNumberMax];
		partsTextureOffsetX = new int[partsNumberMax][partsBoxNumberMax];
		partsTextureOffsetY = new int[partsNumberMax][partsBoxNumberMax];
		partsBoxInitPointX = new float[partsNumberMax][partsBoxNumberMax];
		partsBoxInitPointY = new float[partsNumberMax][partsBoxNumberMax];
		partsBoxInitPointZ = new float[partsNumberMax][partsBoxNumberMax];
		partsBoxX = new int[partsNumberMax][partsBoxNumberMax];
		partsBoxY = new int[partsNumberMax][partsBoxNumberMax];
		partsBoxZ = new int[partsNumberMax][partsBoxNumberMax];
		partsScaleFactor = new float[partsNumberMax][partsBoxNumberMax];
		partsScaleCorrection = new float[partsNumberMax][partsBoxNumberMax];
	}

	public void partsInitSetting(int i, float f) {
		if (parts[i] != null) ;else {
			parts[i] = new Modchu_ModelRenderer(mainModel);
			parts[i].textureWidth = 64;
			parts[i].textureHeight = 32;
			if (i > 0) partsTextureNameMap.put(i, partsTextureNameMap.get(i - 1));
			return;
		}
		parts[i].clearCubeList();
		parts[i].textureWidth = partsTextureWidth[i];
		parts[i].textureHeight = partsTextureHeight[i];
		for (int i1 = 0;i1 < partsBoxNumber[i]; i1++) {
			//Modchu_Debug.mDebug("add i="+i+" i1="+i1);
			Modchu_Debug.cDebug("Modchu_CustomModel partsName["+i+"]="+partsName[i]);
			parts[i].setTextureOffset(partsTextureOffsetX[i][i1], partsTextureOffsetY[i][i1]);
			switch (boxType[i][i1]) {
			case 0:
				Modchu_Debug.cDebug(new StringBuilder().append("Modchu_CustomModel i=").append(i).append(" i1=").append(i1)
						.append(" addBox(")
						.append(partsBoxInitPointX[i][i1]).append("F,").append(partsBoxInitPointY[i][i1]).append("F,").append(partsBoxInitPointZ[i][i1]).append("F,")
						.append(partsBoxX[i][i1]).append(",").append(partsBoxY[i][i1]).append(",").append(partsBoxZ[i][i1]).append(",")
						.append(f).append("F*").append(partsScaleFactor[i][i1]).append("F+").append(partsScaleCorrection[i][i1]).append("F)").toString());
				parts[i].addBox(partsBoxInitPointX[i][i1], partsBoxInitPointY[i][i1], partsBoxInitPointZ[i][i1], partsBoxX[i][i1], partsBoxY[i][i1], partsBoxZ[i][i1], f * partsScaleFactor[i][i1] + partsScaleCorrection[i][i1]);
				break;
			case 1:
				Modchu_Debug.cDebug(new StringBuilder().append("Modchu_CustomModel i=").append(i).append(" i1=").append(i1)
						.append(" addPlate(")
						.append(partsBoxInitPointX[i][i1]).append("F,").append(partsBoxInitPointY[i][i1]).append("F,").append(partsBoxInitPointZ[i][i1]).append("F,")
						.append(partsBoxX[i][i1]).append(",").append(partsBoxY[i][i1]).append(",").append(partsBoxZ[i][i1]).append(",")
						.append(f).append("F*").append(partsScaleFactor[i][i1]).append("F+").append(partsScaleCorrection[i][i1]).append("F)").toString());
				parts[i].addPlate(partsBoxInitPointX[i][i1], partsBoxInitPointY[i][i1], partsBoxInitPointZ[i][i1], partsBoxX[i][i1], partsBoxY[i][i1], partsBoxZ[i][i1], f * partsScaleFactor[i][i1] + partsScaleCorrection[i][i1]);
				break;
			case 2:
				Modchu_Debug.cDebug(new StringBuilder().append("Modchu_CustomModel i=").append(i).append(" i1=").append(i1)
						.append(" addBall(")
						.append(partsBoxInitPointX[i][i1]).append("F,").append(partsBoxInitPointY[i][i1]).append("F,").append(partsBoxInitPointZ[i][i1]).append("F,")
						.append(partsBoxX[i][i1]).append(",").append(partsBoxY[i][i1]).append(",").append(partsBoxZ[i][i1])
						.append(")").toString());
				parts[i].addBall(partsBoxInitPointX[i][i1], partsBoxInitPointY[i][i1], partsBoxInitPointZ[i][i1], (float) partsBoxX[i][i1], (float) partsBoxY[i][i1], (float) partsBoxZ[i][i1]);
				break;
			}
		}
		parts[i].setRotationPoint(partsRotationPointX[i], partsRotationPointY[i], partsRotationPointZ[i]);
		parts[i].setRotateAngle(partsRotateAngleX[i], partsRotateAngleY[i], partsRotateAngleZ[i]);
		if (partAddChildName[i] != null) {
			String addChildName = obfuscationNameCheck(partAddChildName[i]);
			MMM_ModelRenderer modelRenderer = (MMM_ModelRenderer) Modchu_Reflect.getFieldObject(mainModel.getClass(), addChildName, mainModel, -1);
			if (modelRenderer != null) {
				modelRenderer.addChild(parts[i]);
				Modchu_Debug.cDebug("Modchu_CustomModel addChild "+addChildName+" i="+i);
			} else {
				Modchu_Debug.cDebug("Modchu_CustomModel addChild else "+addChildName+" i="+i);
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

	public void render(MMM_IModelCaps entityCaps, float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, boolean pIsRender) {
		if (mainModel != null) ;else return;
//-@-151
		Entity entity = (Entity) baseModel.getCapsValue(entityCaps, entityCaps.caps_Entity);
//@-@151
		allShowModelMemory();
		customModelShowModelMemory();
		customModelShowModelSetting(null, false);
		int armorType = Modchu_ModelCapsHelper.getCapsValueInt(baseModel, baseModel.caps_armorType);
		boolean flag1 = armorType < 1;
		if (flag1) {
			Object currentScreen = Modchu_Reflect.getFieldObject("Minecraft", "field_6313_p", "currentScreen", mod_Modchu_ModchuLib.modchu_Main.getMinecraft());
			if (mainModeltexture != null
					&& ((mod_Modchu_ModchuLib.modchu_Main.MMM_GuiTextureSelect != null
					&& !(mod_Modchu_ModchuLib.modchu_Main.MMM_GuiTextureSelect.isInstance(currentScreen)))
					| mod_Modchu_ModchuLib.modchu_Main.MMM_GuiTextureSelect == null)) {
				if (mod_Modchu_ModchuLib.modchu_Main.mod_LMM_littleMaidMob != null
						&& mod_Modchu_ModchuLib.modchu_Main.LMM_EntityLittleMaid.isInstance(entity)) {
					colorSetting(entityCaps);
				}
			} else {
				colorSetting(entityCaps);
			}
			if (mainModeltexture != null) ;else Modchu_Debug.cDebug("Modchu_CustomModel render mainModeltexture == null !! mainModeltextureName="+mainModeltextureName);
			if (mainModel.render != null) ;else mainModel.render = baseModel.render;
			if (mainModel.render != null
					&& mainModeltexture != null) {
				loadTexture(mainModel.render, resourceLocationsMain[0]);
				//Modchu_Debug.mDebug("Modchu_CustomModel render mainModeltexture="+mainModeltexture);
				//Modchu_Debug.mDebug("Modchu_CustomModel render mainModel.getClass()="+(mainModel.getClass()));
				//Modchu_Debug.mDebug("Modchu_CustomModel render entityCaps.getClass()="+(entityCaps.getClass()));
				//entityCaps.setCapsValue(entityCaps.caps_isRendering, true);
				//Modchu_Debug.mDebug("Modchu_CustomModel render Modchu_ModelCapsHelper.getCapsValueBoolean(entityCaps, entityCaps.caps_isRendering)="+(Modchu_ModelCapsHelper.getCapsValueBoolean(entityCaps, entityCaps.caps_isRendering)));
				mainModel.render(entityCaps, f, f1, ticksExisted, pheadYaw, pheadPitch, f5, allRendering ? true : Modchu_ModelCapsHelper.getCapsValueBoolean(entityCaps, entityCaps.caps_isRendering));
			}
			else Modchu_Debug.cDebug("Modchu_CustomModel render render == null !!");
		} else {
			//Modchu_Debug.mDebug("Modchu_CustomModel render armor baseModel.getCapsValueInt(baseModel.caps_armorType)="+baseModel.getCapsValueInt(baseModel.caps_armorType));
			int color = getMaidColor(entityCaps);
			String s;
			String armorName = (String) baseModel.getCapsValue(baseModel.caps_textureArmorName);
			InventoryPlayer inventory = (InventoryPlayer) baseModel.getCapsValue(baseModel.caps_Inventory);
			ItemStack is;
			if (inventory != null) {
				for(int i = 0; i < 4; i++) {
					is = inventory.armorItemInSlot(i);
					s = (String) baseModel.getCapsValue(baseModel.caps_armorTexture, armorName, armorType, is);
					resourceLocationsMain[armorType] = Modchu_Reflect.newInstance("ResourceLocation", new Class[]{ String.class }, new Object[]{ s });
					armorRender(entityCaps, resourceLocationsMain[armorType], armorType, is, mainModel, i, entity, f, f1, ticksExisted, pheadYaw, pheadPitch, f5);
				}
			}
		}
		allShowModelSetting(false);
		String s1 = null;
		if (partsTextureNameMap.size() > 0
				&& textureList != null
				&& textureList.size() > 0) {
			Object texture;
			Object prevTexture = null;
			String s2 = null;
			String s3 = null;
			for(int i = 0; i < partsTextureNameMap.size() ;i++) {
				s1 = partsTextureNameMap.get(i);
				texture = textureList.get(i);
				boolean flag = false;
				if (prevTexture == null) flag = true;
				if (prevTexture != null) s2 = (String) (mod_Modchu_ModchuLib.modchu_Main.getMinecraftVersion() > 159 ? Modchu_Reflect.invokeMethod("ResourceLocation", "func_110623_a", prevTexture) :
					prevTexture);
				if (texture != null) s3 = (String) (mod_Modchu_ModchuLib.modchu_Main.getMinecraftVersion() > 159 ? Modchu_Reflect.invokeMethod("ResourceLocation", "func_110623_a", texture) :
					texture);
				if (texture != null
						&& prevTexture != null
						&& !s2.equalsIgnoreCase(s3)) flag = true;
				if (flag) {
					//Modchu_Debug.mDebug("MultiModelCustom s1="+s1+" func_110776_a texture="+texture+" prevTexture="+prevTexture);
					//Modchu_Debug.cDebug("MultiModelCustom s1="+s1+" func_110776_a texture="+texture);
					if (texture != null) {
						if (baseModel.render != null) {
							loadTexture(baseModel.render, partsTextures[i]);
						} else {
							Render render = RenderManager.instance.getEntityRenderObject(entity);
							baseModel.render = render;
							mainModel.render = render;
							if (baseModel.render != null) {
								loadTexture(baseModel.render, partsTextures[i]);
							} else {
								Modchu_Debug.cDebug("MultiModelCustom baseModel.render == null !!");
							}
						}
					}
					customModelShowModelSetting(s1, true);
					mainModel.render(entityCaps, f, f1, ticksExisted, pheadYaw, pheadPitch, f5, allRendering ? true : Modchu_ModelCapsHelper.getCapsValueBoolean(entityCaps, entityCaps.caps_isRendering));
					customModelShowModelSetting(null, false);
				}
				prevTexture = texture;
			}
		}
		allShowModelMemoryRead();
		customModelShowModelMemoryRead();
		if (!changeModelInit) changeModel(entityCaps);
	}

	private void loadTexture(Render r, Object o) {
		if (mod_Modchu_ModchuLib.modchu_Main.getMinecraftVersion() > 159) Modchu_Reflect.invokeMethod(Render.class, "func_110776_a", new Class[]{ Modchu_Reflect.loadClass("ResourceLocation") }, r, new Object[]{ o });
		else Modchu_Reflect.invokeMethod(Render.class, "loadTexture", new Class[]{ String.class }, r, new Object[]{ o });
	}

	private void armorRender(MMM_IModelCaps entityCaps, Object resourceLocation, int armorType, ItemStack is, MMM_ModelMultiBase model, int i, Entity entity, float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5) {
		if (resourceLocation != null) ;else return;
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
		if (setArmorModel(entityCaps, (MMM_ModelMultiBase) model, is, entity, i, f) > -1) {
			if (resourceLocation != null) {
				if (mainModel.render != null) ;else mainModel.render = baseModel.render;
				if (mainModel.render != null) loadTexture(mainModel.render, resourceLocation);
			}
			model.render(entityCaps, f, f1, ticksExisted, pheadYaw, pheadPitch, f5, Modchu_ModelCapsHelper.getCapsValueBoolean(entityCaps, entityCaps.caps_isRendering));
		}
	}

	private int setArmorModel(MMM_IModelCaps entityCaps, MMM_ModelMultiBase model, ItemStack is, Entity entity, int i, float f) {
		byte byte0 = -1;
		if (model != null) ;else return byte0;
		int armorType = Modchu_ModelCapsHelper.getCapsValueInt(baseModel, baseModel.caps_armorType);
		if (armorType > 1) ;else return byte0;
		int i2 = armorType == 2 ? 0 : 1;
		if (is != null && is.stackSize > 0) {
			if (model instanceof MultiModelBaseBiped) {
				((MultiModelBaseBiped) model).showArmorParts(entityCaps, i, i2);
			} else {
				model.showArmorParts(i, i2);
			}
//-@-b181
			byte0 = (byte) (is.isItemEnchanted() ? 15 : 1);
//@-@b181
		}
		return byte0;
	}

	public void setLivingAnimations(MMM_IModelCaps entityCaps, float f, float f1, float renderPartialTicks) {
		if (mainModel != null) mainModel.setLivingAnimations(entityCaps, f, f1, renderPartialTicks);
	}

	public void setLivingAnimationsLM(MMM_IModelCaps entityCaps, float f, float f1, float renderPartialTicks) {
		//Modchu_Debug.mDebug("Modchu_CustomModel setLivingAnimationsLM");
		Entity entityliving = (Entity) baseModel.getCapsValue(entityCaps, entityCaps.caps_Entity);
		if (entityliving != null) ;else return;
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

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
		if (mainModel != null) ;else return;
		mainModel.setRotationAngles(f, f1, f2, f3, f4, f5, entityCaps);
		///fieldSync(true, (EntityLiving) entity, f, f1, f2);
		if (mainModel instanceof MultiModelBaseBiped
				&& Modchu_ModelCapsHelper.getCapsValueBoolean(baseModel, ((MultiModelBaseBiped) mainModel).caps_shortcutKeysAction)) {
			if (Modchu_ModelCapsHelper.getCapsValueInt(baseModel, baseModel.caps_armorType) != 0) mainModel.setCapsValue(((MultiModelBaseBiped) mainModel).caps_syncModel, entityCaps, armorSyncBaseModel);
			else armorSyncBaseModel = (MultiModelBaseBiped) mainModel;
			actionSync();
		}
		//Modchu_Debug.mDebug("mainModel.isWait="+mainModel.isWait+" baseModel.isWait="+baseModel.isWait+" caps_isWait="+baseModel.entityCaps.getCapsValue(baseModel.caps_isWait));
	}

	public void setRotationAnglesLM(float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, MMM_IModelCaps entityCaps) {
		if (parts != null
				&& mainModel != null) {
			for(int i = 0; i < parts.length ;i++) {
				if (partsType[i] == eyeR) {
					if (Modchu_ModelCapsHelper.getCapsValueBoolean(mainModel, mainModel.caps_aimedBow)) {
						mainModel.setCapsValue(((MultiModelBaseBiped) mainModel).caps_visible, parts[i], false);
						//Modchu_Debug.mDebug("caps_aimedBow eyeR parts[i].showModel="+parts[i].showModel);
						customModelshowModelMemoryList.put(parts[i], parts[i].showModel);
					}
				}
				if (partsType[i] == eyeL) {
					if (Modchu_ModelCapsHelper.getCapsValueBoolean(mainModel, mainModel.caps_aimedBow)) {
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

	public void skirtFloatsInit(float f, float f1) {
		if (mainModel instanceof MultiModelSkirtFloats
				&& mainModel != null) ((MultiModelSkirtFloats) mainModel).skirtFloatsInit(f, f1);
	}

	public void setRotationAnglesfirstPerson(float f, float f1, float f2, float f3, float f4, float f5, MMM_IModelCaps entityCaps) {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) ((MultiModelBaseBiped) mainModel).setRotationAnglesfirstPerson(f, f1, f2, f3, f4, f5, entityCaps);
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

	public void renderItems(MMM_IModelCaps entityCaps) {
		if (mainModel != null) mainModel.renderItems(entityCaps);
	}

	public void defaultPartsSettingBefore(MMM_IModelCaps entityCaps) {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) ((MultiModelBaseBiped) mainModel).defaultPartsSettingBefore(entityCaps);
	}

	public void defaultPartsSettingAfter(MMM_IModelCaps entityCaps) {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) ((MultiModelBaseBiped) mainModel).defaultPartsSettingAfter(entityCaps);
	}

	public void showModelSettingReflects(MMM_IModelCaps entityCaps) {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) ((MultiModelBaseBiped) mainModel).showModelSettingReflects(entityCaps);
	}

	public void actionInit(MMM_IModelCaps entityCaps, int i) {
		if (mainModel instanceof MultiModelAction
				&& mainModel != null) ((MultiModelAction) mainModel).actionInit(entityCaps, i);
	}

	public void actionRelease(MMM_IModelCaps entityCaps, int i) {
		if (mainModel instanceof MultiModelAction
				&& mainModel != null) ((MultiModelAction) mainModel).actionRelease(entityCaps, i);
	}

	public void action(float f, float f1, float f2, float f3, float f4, float f5, int i, MMM_IModelCaps entityCaps) {
		if (mainModel instanceof MultiModelAction
				&& mainModel != null) ((MultiModelAction) mainModel).action(f, f1, f2, f3, f4, f5, i, entityCaps);
	}

	public void syncModel(MMM_IModelCaps entityCaps, MultiModelBaseBiped model) {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) ((MultiModelBaseBiped) mainModel).syncModel(entityCaps, model);
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

	public float getMountedYOffset() {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) return ((MultiModelBaseBiped) mainModel).getMountedYOffset();
		return 0.75F;
	}

	public double getSittingyOffset() {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) return ((MultiModelBaseBiped) mainModel).getSittingyOffset();
		return -0.35D;
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

	public void setArmorBipedHeadShowModel(MMM_IModelCaps entityCaps, boolean b) {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) ((MultiModelBaseBiped) mainModel).setArmorBipedHeadShowModel(entityCaps, b);
	}

	public void setArmorBipedBodyShowModel(MMM_IModelCaps entityCaps, boolean b) {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) ((MultiModelBaseBiped) mainModel).setArmorBipedBodyShowModel(entityCaps, b);
	}

	public void setArmorBipedRightArmShowModel(MMM_IModelCaps entityCaps, boolean b) {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) ((MultiModelBaseBiped) mainModel).setArmorBipedRightArmShowModel(entityCaps, b);
	}

	public void setArmorBipedLeftArmShowModel(MMM_IModelCaps entityCaps, boolean b) {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) ((MultiModelBaseBiped) mainModel).setArmorBipedLeftArmShowModel(entityCaps, b);
	}

	public void setArmorBipedRightLegShowModel(MMM_IModelCaps entityCaps, boolean b) {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) ((MultiModelBaseBiped) mainModel).setArmorBipedRightLegShowModel(entityCaps, b);
	}

	public void setArmorBipedLeftLegShowModel(MMM_IModelCaps entityCaps, boolean b) {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) ((MultiModelBaseBiped) mainModel).setArmorBipedLeftLegShowModel(entityCaps, b);
	}

	public void setArmorSkirtShowModel(MMM_IModelCaps entityCaps, boolean b) {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) ((MultiModelBaseBiped) mainModel).setArmorSkirtShowModel(entityCaps, b);
	}

	public void allShowModelMemory() {
		MMM_ModelRenderer modelRenderer;
		for (int i = 0; i < modelRendererFieldsMap.size(); i++) {
			try {
				modelRenderer = (MMM_ModelRenderer) modelRendererFieldsMap.get(i).get(mainModel);
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
		MMM_ModelRenderer modelRenderer;
		for (int i = 0; i < modelRendererFieldsMap.size(); i++) {
			try {
				modelRenderer = (MMM_ModelRenderer) modelRendererFieldsMap.get(i).get(mainModel);
				if (modelRenderer != null) {
					((MMM_ModelRenderer) modelRendererFieldsMap.get(i).get(mainModel)).showModel = showModelMemoryList.get(modelRenderer);
					//Modchu_Debug.mDebug("allShowModelMemory modelRendererFieldsMap.get("+i+").getName() = "+modelRendererFieldsMap.get(i).getName()+" ((MMM_ModelRenderer) modelRendererFieldsMap.get(i).get(mainModel)).showModel="+((MMM_ModelRenderer) modelRendererFieldsMap.get(i).get(mainModel)).showModel);
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
		Entity entity = (Entity) baseModel.getCapsValue(entityCaps, entityCaps.caps_Entity);
//@-@151
		changeModelInit = true;
		colorSetting(entityCaps);
		Field[] fields = mainModel.getClass().getFields();
		Object o;
		MMM_ModelRenderer modelRenderer;
		int k = 0;
		for (int i = 0; i < fields.length; i++) {
			//Modchu_Debug.mDebug("changeModel fields["+i+"].getType() = "+fields[i].getType());
			try {
				o = fields[i].get(mainModel);
				if (MMM_ModelRenderer.class.isInstance(o)) {
					modelRenderer = (MMM_ModelRenderer) fields[i].get(mainModel);
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
			float f5, MMM_IModelCaps entityCaps) {
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) ((MultiModelBaseBiped) mainModel).setDefaultPause(f, f1, f2, f3, f4, f5, entityCaps);
	}

	public float[] getArmorModelsSize() {
		if (mainModel != null) {
			//Modchu_Debug.mDebug("getArmorModelsSize mainModel.getClass()="+mainModel.getClass());
			return mainModel.getArmorModelsSize();
		}
		return new float[] {0.1F, 0.5F};
	}

	public void renderFirstPersonHand(MMM_IModelCaps entityCaps, float f) {
		Render render = RenderManager.instance.getEntityRenderObject(mod_Modchu_ModchuLib.modchu_Main.getThePlayer());
		if (mainModeltexture != null) loadTexture(render, resourceLocationsMain[0]);
		if (mainModel instanceof MultiModelBaseBiped
				&& mainModel != null) ((MultiModelBaseBiped) mainModel).renderFirstPersonHand(entityCaps, f);
	}

	private void loadInit(File file, List list, boolean b) {
		List list2 = list != null ? list : !b ? (ArrayList) Modchu_Config.cfgData.get(file) : null;
		partsNumberMax = 0;
		if (list2 == null) {
			list2 = new ArrayList();
			try {
				BufferedReader breader = new BufferedReader(new FileReader(
						file));
				String rl;
				partsCount = -1;
				for (int i = 0; (rl = breader.readLine()) != null ; i++) {
					int i1;
					list2.add(rl);
					if (rl.startsWith("#")
							| rl.startsWith("/")) continue;
					initCheckData(rl.toString());
				}
				partsNumberMax = partsCount + 1;
				//Modchu_Debug.mDebug("Modchu_CustomModel loadInit partsNumberMax="+partsNumberMax);
				Modchu_Config.cfgData.put(file, list2);
				breader.close();
			} catch (Exception e) {
				//Modchu_Debug.cDebug("Modchu_CustomModel loadInit load "+ file.toString() +" load fail.");
				e.printStackTrace();
			}
		} else {
			String s2;
			partsCount = -1;
			for (int i = 0; i < list2.size() ; i++) {
				s2 = (String) list2.get(i);
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

	public void save(File file) {
		if (!file.exists()) {
			try {
				BufferedWriter bwriter = new BufferedWriter(new FileWriter(
						file));
				StringBuilder sb = new StringBuilder();
				List list = new ArrayList();
				bwriter.write("");
				bwriter.newLine();
				bwriter.close();
				Modchu_Debug.mDebug("Modchu_CustomModel "+ file.toString() +" new file create.");
			} catch (Exception e) {
				Modchu_Debug.Debug("Modchu_CustomModel "+ file.toString() +" file writer fail.");
				e.printStackTrace();
			}
		}
		if (file.exists() && file.canRead() && file.canWrite()) {
			List lines = getSaveList();
			try {
			// •Û‘¶
				if (!lines.isEmpty()
						&& (file.exists() || file.createNewFile())
						&& file.canWrite()) {
					BufferedWriter bwriter = new BufferedWriter(
							new FileWriter(file));
					String t;
					for (int i = 0 ; i < lines.size() ; i++) {
						t = (String) lines.get(i);
						bwriter.write(t);
						bwriter.newLine();
					}
					bwriter.close();
				}
			} catch (Exception er) {
				Modchu_Debug.Debug("Modchu_CustomModel save file save fail.");
				er.printStackTrace();
			}
		}
	}

	public List getSaveList() {
		List lines = new LinkedList();
		String s;
		String s1;
		StringBuilder sb = new StringBuilder();
		sb = sb.append("mainModeltextureName").append("=").append(mainModeltextureName);
		lines.add(sb.toString());
		lines.add("");
		sb.delete(0, sb.length());
		for (int i = 0; i < parts.length; i++) {
			sb = sb.append("name").append("=").append(partsName[i]);
			lines.add(sb.toString());
			sb.delete(0, sb.length());
			sb = sb.append("textureName").append("=").append(partsTextureNameMap.get(i));
			if (partsTextureColor[i] != -1)  sb = sb.append(";").append(partsTextureColor[i]);
			lines.add(sb.toString());
			sb.delete(0, sb.length());
			sb = sb.append("textureWidth").append("=").append(partsTextureWidth[i]);
			lines.add(sb.toString());
			sb.delete(0, sb.length());
			sb = sb.append("textureHeight").append("=").append(partsTextureHeight[i]);
			lines.add(sb.toString());
			sb.delete(0, sb.length());
			for (int i1 = 0; i1 < partsBoxNumber[i]; i1++) {
				sb = sb.append("textureOffset").append("=").append(partsTextureOffsetX[i][i1]).append(",").append(partsTextureOffsetY[i][i1]);
				lines.add(sb.toString());
				sb.delete(0, sb.length());
				switch(boxType[i][i1]) {
				case 0:
					sb = sb.append("addBox");
					break;
				case 1:
					sb = sb.append("addPlate");
					break;
				case 2:
					sb = sb.append("addBall");
					break;
				}
				sb = sb.append("(").append(partsBoxInitPointX[i][i1]).append("F,").append(partsBoxInitPointY[i][i1]).append("F,").append(partsBoxInitPointZ[i][i1]).append("F,").append(partsBoxX[i][i1]).append(",").append(partsBoxY[i][i1]).append(",").append(partsBoxZ[i][i1]);
				if (boxType[i][i1] != 2) sb = sb.append(",").append(partsScaleFactor[i][i1]).append("F,").append(partsScaleCorrection[i][i1]).append("F");
				sb = sb.append(")");
				lines.add(sb.toString());
				sb.delete(0, sb.length());
			}
			sb = sb.append("setRotateAngle").append("(").append(partsRotateAngleX[i]).append("F,").append(partsRotateAngleY[i]).append("F,").append(partsRotateAngleZ[i]).append("F)");
			lines.add(sb.toString());
			sb.delete(0, sb.length());
			sb = sb.append(partAddChildName[i]).append(".addChild");
			lines.add(sb.toString());
			sb.delete(0, sb.length());
			sb = sb.append("type").append("=").append(getPartsTypeString(partsType[i])).append(";").append(partsTypeFactor[i]).append("F;").append(partsTypeCorrection[i]).append("F");
			lines.add(sb.toString());
			sb.delete(0, sb.length());
			lines.add("");
		}
		return lines;
	}

	private void load(File file, List list, boolean b) {
		List list2 = list != null ? list : !b ? (ArrayList) Modchu_Config.cfgData.get(file) : null;
		partsCount = -1;
		if (list2 == null) {
			list2 = new ArrayList();
			try {
				BufferedReader breader = new BufferedReader(new FileReader(
						file));
				String rl;
				for (int i = 0; (rl = breader.readLine()) != null ; i++) {
					int i1;
					list2.add(rl);
					if (rl.startsWith("#")
							| rl.startsWith("/")) continue;
					settingData(rl.toString());
				}
				Modchu_Config.cfgData.put(file, list2);
				breader.close();
			} catch (Exception e) {
				//Modchu_Debug.cDebug("Modchu_Config load "+ file.toString() +" load fail.");
				e.printStackTrace();
			}
		} else {
			String s2;
			//Modchu_Debug.mDebug("1 file="+file.toString()+" list.size()="+list.size());
			for (int i = 0; i < list2.size() ; i++) {
				s2 = (String) list2.get(i);
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
				partsTextureOffsetX[partsCount][boxCount] = partsCount > 0
						&& boxCount > 0 ? partsTextureOffsetX[partsCount][boxCount - 1] : 0;
				partsTextureOffsetY[partsCount][boxCount] = partsCount > 0
						&& boxCount > 0 ? partsTextureOffsetY[partsCount][boxCount - 1] : 0;
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
					partsTextureOffsetX[partsCount][boxCount] = Integer.valueOf(s.substring(0, i1));
					partsTextureOffsetY[partsCount][boxCount] = Integer.valueOf(s.substring(i1 + 1));
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
				s = s.substring(0, i1);
				if (!s.equals("null")) partAddChildName[partsCount] = s;
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

	public void newMainModelInit() {
		String name = mainModeltextureName;
		Modchu_Debug.cDebug("customInitModel mainModeltextureName="+mainModeltextureName);
		Object[] o = mod_Modchu_ModchuLib.modchu_Main.modelNewInstance(null, mainModeltextureName, true, false);
		if (o != null
				&& o[0] != null) mainModel = (MMM_ModelMultiBase) o[0];
		//Modchu_Debug.mDebug("customInitModel mainModel != null ?"+(mainModel != null));
	}

	private void colorSetting(MMM_IModelCaps entityCaps) {
		//Modchu_Debug.mDebug("Modchu_CustomModel colorSetting");
//-@-151
		Entity entity = (Entity) baseModel.getCapsValue(entityCaps, entityCaps.caps_Entity);
//@-@151
		MMM_ModelMultiBase model = mainModel != null ? mainModel : baseModel;
		if (model != null
			&& entityCaps != null) ;else {
				if (entityCaps != null) ;else Modchu_Debug.mDebug("Modchu_CustomModel colorSetting entityCaps == null !!");
				if (model != null) ;else Modchu_Debug.mDebug("Modchu_CustomModel colorSetting entityCaps == null !!");
				return;
		}
		int color = getMaidColor(entityCaps);
		mainModeltexture = getTexture(entityCaps, model, entity, mainModeltextureName, color);
		resourceLocationsMain[0] = mainModeltexture;
		if (entityCaps != null
				&& model instanceof MultiModelBaseBiped) {
			MultiModelBaseBiped multiModelBaseBiped = (MultiModelBaseBiped) model;
			if (textureList != null) {
				for(int i1 = 0; i1 < partsTextureNameMap.size() ;i1++) {
					String s1 = partsTextureNameMap.get(i1);
					Object s2 =  (Object) multiModelBaseBiped.getCapsValue(entityCaps, multiModelBaseBiped.caps_texture, s1, partsTextureColor[i1] == -1 ? color : (int) partsTextureColor[i1]);
					Modchu_Debug.cDebug("Modchu_CustomModel colorSetting add "+s1+" color="+(partsTextureColor[i1] == -1 ? color : (int) partsTextureColor[i1])+" texture="+s2);
					textureList.add(i1, s2);
				}
			}
		}
		Modchu_Debug.cDebug("Modchu_CustomModel colorSetting mainModeltextureName="+mainModeltextureName+" color="+color+" mainModeltexture="+mainModeltexture);
		Object texture;
		for(int i = 0; i < partsTextureNameMap.size() ;i++) {
			texture = textureList.get(i);
			partsTextures[i] = texture;
		}
/*
		setArmorModelMethod = Modchu_Reflect.getMethod(render.getClass(), "setArmorModel", new Class[]{ MultiModelBaseBiped.class, EntityPlayer.class, int.class, float.class });
		if (setArmorModelMethod != null) {
			setArmorModelMethodType = 1;
		} else {
			setArmorModelMethod = Modchu_Reflect.getMethod(render.getClass(), "setArmorModelEx", new Class[]{ mod_Modchu_ModchuLib.modchu_Main.LMM_EntityLittleMaid, int.class, float.class });
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

	private Object getTexture(MMM_IModelCaps entityCaps, MMM_ModelMultiBase model, Entity entity, String s, int i) {
		int armorType;
		Object s1 = null;
		if (entityCaps != null
				&& model instanceof MultiModelBaseBiped) {
			MultiModelBaseBiped multiModelBaseBiped = (MultiModelBaseBiped) model;
			armorType = Modchu_ModelCapsHelper.getCapsValueInt(multiModelBaseBiped, multiModelBaseBiped.caps_armorType);
			s1 = armorType < 1 ?
					(Object) multiModelBaseBiped.getCapsValue(entityCaps, multiModelBaseBiped.caps_texture, s, i) :
						(Object) multiModelBaseBiped.getCapsValue(entityCaps, multiModelBaseBiped.caps_armorTexture, s, armorType == 1 ? 64 : 80);
			//Modchu_Debug.mDebug("getTexture s="+s+" i="+i+" armorType="+armorType+" s1="+s1);
			return s1;
		}
		armorType = Modchu_ModelCapsHelper.getCapsValueInt(baseModel, baseModel.caps_armorType);
		//Modchu_Debug.mDebug("Modchu_CustomModel getTexture armorType="+armorType);
		s1 = armorType < 1 ?
				baseModel.getCapsValue(entityCaps, baseModel.caps_texture, s, i) :
					baseModel.getCapsValue(entityCaps, baseModel.caps_armorTexture, s, armorType);
		Modchu_Debug.mDebug("getTexture s="+s+" i="+i+" armorType="+armorType+" s1="+s1);
		return s1;
	}

	private int getMaidColor(MMM_IModelCaps entityCaps) {
//-@-151
		Entity entity = (Entity) baseModel.getCapsValue(entityCaps, entityCaps.caps_Entity);
//@-@151
		Object o = null;
		if (mod_Modchu_ModchuLib.modchu_Main.mod_LMM_littleMaidMob != null
				&& mod_Modchu_ModchuLib.modchu_Main.LMM_EntityLittleMaid.isInstance(entity)) {
			o = (Integer) Modchu_Reflect.getFieldObject(mod_Modchu_ModchuLib.modchu_Main.LMM_EntityLittleMaid, "maidColor", entity);
			allRendering = true;
		} else if (mod_Modchu_ModchuLib.modchu_Main.MMM_EntitySelect != null
				&& mod_Modchu_ModchuLib.modchu_Main.MMM_EntitySelect.isInstance(entity)) {
			o = (Integer) Modchu_Reflect.getFieldObject(mod_Modchu_ModchuLib.modchu_Main.MMM_EntitySelect, "color", entity);
			allRendering = true;
		} else {
			//Modchu_Debug.mDebug("getMaidColor !LMM ?"+(entity.getClass()));
			return Modchu_ModelCapsHelper.getCapsValueInt(baseModel, entityCaps, baseModel.caps_maidColor, entity);
		}
		if (o != null) return (Integer) o;
		return 0;
	}

	private void allShowModelSetting(boolean b) {
		MMM_ModelRenderer modelRenderer;
		for (int i = 0; i < modelRendererFieldsMap.size(); i++) {
			try {
				modelRenderer = (MMM_ModelRenderer) modelRendererFieldsMap.get(i).get(mainModel);
				if (modelRenderer != null) {
					if (b) b = showModelMemoryList.get(modelRenderer);
					((MMM_ModelRenderer) modelRendererFieldsMap.get(i).get(mainModel)).showModel = b;
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
					if (partsTextureNameMap != null
							&& partsTextureNameMap.containsKey(i)) {
						if (partsTextureNameMap.get(i).equalsIgnoreCase(s)) b1 = b;
					}
				}
				//Modchu_Debug.cDebug("customModelShowModelSetting "+partsTextureNameMap.get(i)+" customModelshowModelMemoryList.get(parts["+i+"])="+(customModelshowModelMemoryList.get(parts[i]))+" s="+s+" b="+b+" b1="+b1);
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
						&& !(o instanceof MMM_ModelRenderer)
						&& !(o instanceof MMM_ModelRenderer[])) {
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
/*
		if (!mod_Modchu_ModchuLib.modchu_Main.mod_modchu_modchulib.isRelease()
				| mod_Modchu_ModchuLib.modchu_Main.isForge) return s;
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
*/
		return s;
	}

	public static String getPartsTypeString(int i) {
		String s = null;
		switch (i) {
		case 0:
			s = "normal";
			break;
		case 1:
			s = "eyeR";
			break;
		case 2:
			s = "eyeL";
			break;
		case 3:
			s = "ear";
			break;
		case 4:
			s = "tail";
			break;
		}
		return s;
	}

	public int showArmorParts(MMM_IModelCaps entityCaps, int i, int i2) {
		return mainModel != null ? mainModel.showArmorParts(i, i2) : -1;
	}

	public String getUsingTexture() {
		return null;
	}
}