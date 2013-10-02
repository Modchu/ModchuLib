package net.minecraft.src;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Modchu_Main {

	public static final String version = "5g";
	public static final String modName = "ModchuLib";
	public static final String versionString = ""+ Modchu_Version.version + "-" + version;

	//cfg�������ݍ���
	public static boolean skirtFloats = false;
	public static double skirtFloatsVolume = 1.0D;
	public static boolean modchuRemodelingModel = true;
	public static boolean useInvisibilityBody = true;
	public static boolean useInvisibilityArmor = false;
	public static boolean useInvisibilityItem = false;
	public static boolean versionCheck = true;

	public static boolean isForge = false;
	public static boolean isLMM = false;
	public static boolean isPFLM = false;
	public static boolean isPFLMF = false;
	public static boolean isFavBlock = false;
	public static boolean isDecoBlock = false;
	public static boolean isBTW = false;
	public static boolean isSSP = false;
	public static boolean newRelease = false;
	public static boolean oldRenderItems = false;
	public static Class MMM_TextureManager;
	public static Class MMM_FileManager;
	public static Class MMM_TextureBox;
	public static Class MMM_ModelPlate;
	public static Class MMM_StabilizerManager;
	public static Class MMM_GuiTextureSelect;
	public static Class MMM_GuiTextureSlot;
	public static Class MMM_EntitySelect;
	public static Class MMM_ITextureEntity;
	public static Class MMM_TextureData;
	public static Class MMM_ModelBaseNihil;
	public static Class mod_PFLM_PlayerFormLittleMaid;
	public static Class mod_LMM_littleMaidMob;
	public static Class PFLMF;
	public static Class PFLM_Gui;
	public static Class PFLM_GuiModelSelect;
	public static Class PFLM_GuiOthersPlayer;
	public static Class PFLM_GuiOthersPlayerIndividualCustomize;
	public static Class PFLM_EntityPlayerDummy;
	public static Class PFLM_RenderPlayer;
	public static Class PFLM_RenderPlayer2;
	public static Class PFLM_GuiSmallButton;
	public static Class LMM_EntityLittleMaid;
	public static Class decoBlock;
	public static Class decoBlockBase;
	public static Class favBlock;
	public static Class RendererData;
	private boolean isModchu;
	private boolean runtimeExceptionFlag;
	private String runtimeExceptionString;

	public static String newVersion = "";
	public static String packageName;
	public static String modelClassName = "MultiModel";
	public static final int modchuLibVersion = Modchu_Version.version;
	public static int mmmLibVersion;
	private static File cfgdir;
	private static File mainCfgfile;
	public static HashMap<String, Object[]> checkModelsBox = new HashMap();
	public static HashMap<Entity, Map> entityModelMapData = new HashMap();
	public static Map<String, Object[]> dummyModelMapData = new HashMap();
	public static List<String> ngPlayerModelList = new ArrayList<String>();
	public static boolean isClient = true;
	private static boolean packageNameNull = false;
	public static boolean isRelease = true;
	public static Object mc;

	//�s��L��@�\����
	private static boolean LMMarmorSupport = false;

	public Modchu_Main()
	{
		// b181deleteload();
		String s = mod_MMM_MMMLib.Revision;
		int i = getVersionStringConversionInt(s);
		mmmLibVersion = i;
	}

	public String getName() {
		return modName;
	}

	public String getVersion() {
		return versionString;
	}

	public void load() {
		//�Ή�MOD�����`�F�b�N class���`�F�b�N
		String className1[] = {
				"FMLRenderAccessLibrary", "net.minecraft.src.FMLRenderAccessLibrary", "net.minecraft.decoblock.DecoBlock", "net.minecraft.favstar.BlockFav", "EntityPlayerSP2",
				"net.minecraft.src.EntityPlayerSP2"
		};
		String test2 = null;
		for(int n = 0 ; n < className1.length ; n++){
			try {
				test2 = className1[n];
				test2 = ""+Class.forName(test2);
				Modchu_Debug.lDebug(test2 + " Check ok.");
				if(n == 0
						| n == 1) isForge = true;
				if(n == 2) isDecoBlock = true;
				if(n == 3) isFavBlock = true;
				if(n == 4
						| n == 5) {
					try {
						String s = className1[n];
						if (s != null) {
							Object o = Modchu_Reflect.getFieldObject(s, "armor", -1);
							if (o != null) isSSP = true;
						}
					} catch(Exception e) {
					}
				}
			} catch (ClassNotFoundException e) {
			}
		}
		getPackageInit();
		Modchu_Reflect.initNameMap();
		if (getMinecraftDir().getAbsolutePath().indexOf("jars") != -1) {
			isRelease = false;
		}
		String s;
		if (Modchu_Debug.debugMessage
				&& !mod_Modchu_ModchuLib.modchu_Main.isRelease()) Modchu_Debug.debugString = new String[10];
		//minecraft���o�[�W�����p
		isModchu = Modchu_Reflect.loadClass(getClassName("Modchu_TextureManager"), -1) != null;
		if (isModchu) {
			MMM_TextureManager = Modchu_Reflect.loadClass(getClassName("Modchu_TextureManager"));
			MMM_FileManager = Modchu_Reflect.loadClass(getClassName("Modchu_FileManager"));
			Modchu_Reflect.invokeMethod(MMM_FileManager, "init");
			Object o = Modchu_Reflect.getFieldObject(MMM_TextureManager, "instance");
			if (o != null) {
				Modchu_Reflect.invokeMethod(MMM_TextureManager, "init", o);
			} else {
				ModLoader.getLogger().warning("mod_Modchu_ModchuLib-you must check MMMLib revision.");
				throw new RuntimeException("mod_Modchu_ModchuLib-The revision of MMMLib is old.");
			}
			MMM_TextureBox = Modchu_Reflect.loadClass(getClassName("Modchu_TextureBox"));
//-@-125
			MMM_StabilizerManager = Modchu_Reflect.loadClass(getClassName("Modchu_StabilizerManager"));
			Modchu_Reflect.invokeMethod(MMM_StabilizerManager, "init");
//@-@125
		} else {
			MMM_TextureManager = Modchu_Reflect.loadClass(getClassName("MMM_TextureManager"));
			MMM_FileManager = Modchu_Reflect.loadClass(getClassName("MMM_FileManager"));
			MMM_TextureBox = Modchu_Reflect.loadClass(getClassName("MMM_TextureBox"));
			MMM_StabilizerManager = Modchu_Reflect.loadClass(getClassName("MMM_StabilizerManager"));
			MMM_ModelBaseNihil = Modchu_Reflect.loadClass(getClassName("MMM_ModelBaseNihil"));
		}
		MMM_ModelPlate = Modchu_Reflect.loadClass(getClassName("Modchu_ModelPlate"));
		if (MMM_ModelPlate != null) ;else MMM_ModelPlate = Modchu_Reflect.loadClass(getClassName("MMM_ModelPlate"));

		mod_LMM_littleMaidMob = Modchu_Reflect.loadClass(getClassName("mod_LMM_littleMaidMob"), -1);
		if (mod_LMM_littleMaidMob != null) {
			isLMM = true;
			LMM_EntityLittleMaid = Modchu_Reflect.loadClass(getClassName("LMM_EntityLittleMaid"));
			MMM_GuiTextureSelect = Modchu_Reflect.loadClass(getClassName("MMM_GuiTextureSelect"));
			MMM_GuiTextureSlot = Modchu_Reflect.loadClass(getClassName("MMM_GuiTextureSlot"));
			MMM_EntitySelect = Modchu_Reflect.loadClass(getClassName("MMM_EntitySelect"));
			MMM_ITextureEntity = Modchu_Reflect.loadClass(getClassName("MMM_ITextureEntity"));
			if (getMinecraftVersion() > 159) MMM_TextureData = Modchu_Reflect.loadClass(getClassName("MMM_TextureData"));
		}

		mod_PFLM_PlayerFormLittleMaid = Modchu_Reflect.loadClass(getClassName("mod_PFLM_PlayerFormLittleMaid"), -1);
		if (mod_PFLM_PlayerFormLittleMaid != null) {
			isPFLM = true;
		}

		RendererData = Modchu_Reflect.loadClass("net.smart.render.RendererData", -1);
		cfgdir = new File(getMinecraftDir(), "/config/");
		mainCfgfile = new File(cfgdir, ("Modchu_ModchuLib.cfg"));
		loadcfg();
		if (versionCheck) startVersionCheckThread();
	}

	public void modsLoaded() {
		if (isModchu) {
			// ���[�h
			Object o = Modchu_Reflect.getFieldObject(MMM_TextureManager, "instance");
			if (isClient) {
				// �e�N�X�`���p�b�N�̍\�z
				if (o != null) Modchu_Reflect.invokeMethod(MMM_TextureManager, "loadTextures", o);
//-@-125
				Modchu_Reflect.invokeMethod(MMM_StabilizerManager, "loadStabilizer");
//@-@125
			} else {
				if (o != null) Modchu_Reflect.invokeMethod(MMM_TextureManager, "loadTextureIndex", o);
			}
//-@-125
			// �e�N�X�`���C���f�b�N�X�̍\�z
			Modchu_Debug.lDebug("Localmode: InitTextureList.");
			if (o != null) Modchu_Reflect.invokeMethod(MMM_TextureManager, "initTextureList", new Class[]{ boolean.class}, o, new Object[]{ true });
//@-@125
		}

		//�Ή�MOD�����`�F�b�N ModLoader�Ή�MOD
		List list = ModLoader.getLoadedMods();
		int size = list.size();
		for (int i = 0; i < size; i++)
		{
			BaseMod mod = (BaseMod)list.get(i);
			String name = mod.getClass().getSimpleName();
			if (name.equals("mod_PFLM_PlayerFormLittleMaid")) {
				Modchu_Reflect.invokeMethod(mod.getClass(), "loadInit", mod);
				Modchu_Reflect.invokeMethod(mod.getClass(), "modsLoadedInit", mod);
				PFLM_Gui = Modchu_Reflect.loadClass(getClassName("PFLM_Gui"));
				PFLM_GuiModelSelect = Modchu_Reflect.loadClass(getClassName("PFLM_GuiModelSelect"));
				PFLM_GuiOthersPlayer = Modchu_Reflect.loadClass(getClassName("PFLM_GuiOthersPlayer"));
				PFLM_GuiOthersPlayerIndividualCustomize = Modchu_Reflect.loadClass(getClassName("PFLM_GuiOthersPlayerIndividualCustomize"));
				PFLM_EntityPlayerDummy = Modchu_Reflect.loadClass(getClassName("PFLM_EntityPlayerDummy"));
				PFLM_RenderPlayer = Modchu_Reflect.loadClass(getClassName("PFLM_RenderPlayer"));
				PFLM_GuiSmallButton = Modchu_Reflect.loadClass(getClassName("PFLM_GuiSmallButton"));
			}
			else if (name.equals("mod_DecoBlock")) {
				isDecoBlock = true;
				Modchu_Debug.lDebug("DecoBlock Check ok.");
			}
			else if (name.equals("mod_FavBlock")) {
				isFavBlock = true;
				Modchu_Debug.lDebug("FavBlock Check ok.");
			}
			else if (name.equals("mod_FCBetterThanWolves")) {
				isBTW = true;
				Modchu_Debug.lDebug("mod_FCBetterThanWolves Check ok.");
			}
			else if (name.equals("mod_MinecraftForge")) {
				isForge = true;
				Modchu_Debug.lDebug("mod_MinecraftForge Check ok.");
			}
			else if (name.equals("mod_LMM_littleMaidMob")) {
				boolean b = false;
				String s1 = (String) Modchu_Reflect.invokeMethod(mod_LMM_littleMaidMob, "getVersion", mod);
				if (s1.startsWith("1.4.6")) ;else {
					s1 = s1.substring(s1.length() - 1);
					if (Integer.valueOf(s1) < 5) oldRenderItems = b;
				}
			}
		}
		Object o = Modchu_Reflect.invokeMethod("cpw.mods.fml.common.Loader", "instance");
		if (o != null) {
			list = (List) Modchu_Reflect.invokeMethod("cpw.mods.fml.common.Loader", "getActiveModList", o);
			if (list != null) {
				size = list.size();
				String name = null;
				for (int i = 0; i < size; i++)
				{
					o = list.get(i);
					name = (String) Modchu_Reflect.invokeMethod("cpw.mods.fml.common.ModContainer", "getName", o);
					if (name.startsWith("PFLMF")) {
						String s = (String) Modchu_Reflect.invokeMethod("cpw.mods.fml.common.ModContainer", "getVersion", o);
						if (s != null) {
							s = lastIndexProcessing(s, "_");
							int i1 = getVersionStringConversionInt(s);
							if (i1 < 401) {
								Modchu_Debug.lDebug("PFLMF Version is old !! VersionInt="+i1);
								runtimeExceptionFlag = true;
								runtimeExceptionString = "PFLMF Version is old !!";
							} else {
								isPFLMF = true;
								PFLMF = Modchu_Reflect.loadClass(getClassName("PFLMF"), -1);
								Modchu_Debug.lDebug("PFLMF Check ok.");
							}
						}
						break;
					}
				}
			}
		}
		String s;
		if (isDecoBlock) {
			try {
				s = "net.minecraft.decoblock.DecoBlock";
				decoBlock = Class.forName(s);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				s = "net.minecraft.decoblock.base.BaseBlock";
				decoBlockBase = Class.forName(s);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			Modchu_Debug.lDebug("isDecoBlock false.");
		}
		if (isFavBlock) {
			try {
				s = "net.minecraft.favstar.BlockFav";
				favBlock = Class.forName(s);
			} catch (Exception e) {
				try {
					s = "net.minecraft.favblock.FavBlock";
					favBlock = Class.forName(s);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		} else  {
			Modchu_Debug.lDebug("isFavBlock false.");
		}
		if (isSSP) {
			PFLM_RenderPlayer2 = Modchu_Reflect.loadClass("PFLM_RenderPlayer2");
		}
	}

	public static void loadcfg() {
		// cfg�ǂݍ���
		if (cfgdir.exists()) {
			if (!mainCfgfile.exists()) {
				// cfg�t�@�C�������� = �V�K�쐬
				String s[] = {
						"skirtFloats=false", "skirtFloatsVolume=1.0D", "debugMessage=true", "debugMessagetexture=true", "debugReflectMessage=true",
						"debugReflectMessageDetail=false", "modchuRemodelingModel=true", "useInvisibilityBody=true", "useInvisibilityArmor=false", "useInvisibilityItem=false",
						"versionCheck=true",  "debugCustomModelMessage=false", "debugLogMessage=false", "careerSave=false"
				};
				Modchu_Config.writerConfig(mainCfgfile, s);
			} else {
				// cfg�t�@�C��������
				skirtFloats = Boolean.valueOf((Modchu_Config.loadConfig(mainCfgfile, "skirtFloats", skirtFloats)).toString());
				skirtFloatsVolume = Double.valueOf((Modchu_Config.loadConfig(mainCfgfile, "skirtFloatsVolume", skirtFloatsVolume)).toString());
				Modchu_Debug.debugMessage = Boolean.valueOf((Modchu_Config.loadConfig(mainCfgfile, "debugMessage", Modchu_Debug.debugMessage)).toString());
				Modchu_Debug.debugMessagetexture = Boolean.valueOf((Modchu_Config.loadConfig(mainCfgfile, "debugMessagetexture", Modchu_Debug.debugMessagetexture)).toString());
				Modchu_Reflect.debugReflectMessage = Boolean.valueOf((Modchu_Config.loadConfig(mainCfgfile, "debugReflectMessage", Modchu_Reflect.debugReflectMessage)).toString());
				Modchu_Reflect.debugReflectMessageDetail = Boolean.valueOf((Modchu_Config.loadConfig(mainCfgfile, "debugReflectMessageDetail", Modchu_Reflect.debugReflectMessageDetail)).toString());
				modchuRemodelingModel = Boolean.valueOf((Modchu_Config.loadConfig(mainCfgfile, "modchuRemodelingModel", modchuRemodelingModel)).toString());
				useInvisibilityBody = Boolean.valueOf((Modchu_Config.loadConfig(mainCfgfile, "useInvisibilityBody", useInvisibilityBody)).toString());
				useInvisibilityArmor = Boolean.valueOf((Modchu_Config.loadConfig(mainCfgfile, "useInvisibilityArmor", useInvisibilityArmor)).toString());
				useInvisibilityItem = Boolean.valueOf((Modchu_Config.loadConfig(mainCfgfile, "useInvisibilityItem", useInvisibilityItem)).toString());
				versionCheck = Boolean.valueOf((Modchu_Config.loadConfig(mainCfgfile, "versionCheck", versionCheck)).toString());
				Modchu_Debug.debugCustomModelMessage = Boolean.valueOf((Modchu_Config.loadConfig(mainCfgfile, "debugCustomModelMessage", Modchu_Debug.debugCustomModelMessage)).toString());
				Modchu_Debug.debugLogMessage = Boolean.valueOf((Modchu_Config.loadConfig(mainCfgfile, "debugLogMessage", Modchu_Debug.debugLogMessage)).toString());
				Modchu_Debug.careerSave = Boolean.valueOf((Modchu_Config.loadConfig(mainCfgfile, "careerSave", Modchu_Debug.careerSave)).toString());
				String k[] = {
						"skirtFloats", "skirtFloatsVolume", "debugMessage", "debugMessagetexture", "debugReflectMessage",
						"debugReflectMessageDetail", "modchuRemodelingModel", "useInvisibilityBody", "useInvisibilityArmor", "useInvisibilityItem",
						"versionCheck", "debugCustomModelMessage", "debugLogMessage", "careerSave"
				};
				String k1[] = {
						""+skirtFloats, ""+skirtFloatsVolume, ""+Modchu_Debug.debugMessage, ""+Modchu_Debug.debugMessagetexture, ""+Modchu_Reflect.debugReflectMessage,
						""+Modchu_Reflect.debugReflectMessageDetail, ""+modchuRemodelingModel, ""+useInvisibilityBody, ""+useInvisibilityArmor, ""+useInvisibilityItem,
						""+versionCheck, ""+Modchu_Debug.debugCustomModelMessage, ""+Modchu_Debug.debugLogMessage, ""+Modchu_Debug.careerSave
				};
				if (skirtFloatsVolume < 0.0D) skirtFloatsVolume = 0.0D;
				if (skirtFloatsVolume > 2.0D) skirtFloatsVolume = 2.0D;
				Modchu_Config.writerSupplementConfig(mainCfgfile, k, k1);
			}
		}
	}

	public boolean onTickInGame(float f, Object minecraft)
	{
		if (runtimeExceptionFlag) throw new RuntimeException(runtimeExceptionString);
		if (Modchu_Debug.debugMessage
				&& !mod_Modchu_ModchuLib.modchu_Main.isRelease()) {
			Modchu_Debug.dDebugDrow();
		}
		return true;
	}

	public boolean isRelease() {
		return isRelease;
	}

	static{
		String s = System.getenv("modchu");
		if ((s != null
				&& s.equals("on"))) {
			isRelease = false;
		}
	}

	public String getClassName(String s) {
		if (s == null) return null;
		if (s.indexOf(".") > -1) return s;
		String s1 = getPackage();
		if (s1 != null) return s1.concat(".").concat(s);
		return s;
	}

	public void getPackageInit() {
		if (!isForge) {
			Package pack = getClass().getPackage();
			if (pack != null) packageName = pack.getName();
			else packageName = null;
		} else {
			packageName = !isRelease ? "net.minecraft.src" : null;
		}
	}

	public String getPackage() {
		return packageName;
	}

    public static String getHashMapKey(HashMap hashMap, int i) {
    	if (hashMap.size() < i
    			| i < 0) return null;
    	boolean flag = false;
    	Iterator iterator = hashMap.entrySet().iterator();
    	int j1 = 0;
    	do {
    		++j1;
    		if (!iterator.hasNext()) break;
    		Entry entry = (Entry)iterator.next();
    		if (j1 == i) return (String)entry.getKey();
    	} while (true);
    	for (Iterator iterator1 = hashMap.entrySet().iterator(); iterator1.hasNext();) {
    		Entry entry1 = (Entry)iterator1.next();
    		if (entry1 != null) return (String)entry1.getKey();
    	}
    	return null;
    }

    private static void startVersionCheckThread() {
    	Modchu_ThreadVersionCheck var0 = new Modchu_ThreadVersionCheck();
    	var0.start();
    }

	public static boolean checkRelease(String s) {
		if (s != null) {
			if (s.length() > 1) {
				String ck = s.substring(s.length() - 1, s.length());
				String mck = mod_Modchu_ModchuLib.modchu_Main.getVersion();
				String k = version;
				mck = k.substring(k.length() - 1);
				if (integerCheck(mck)) mck = "";
				boolean check = integerCheck(k);
				//Modchu_Debug.mDebug("Modchulib checkRelease k="+k+" mck="+mck+" check="+check);
				while(!check
						&& k.length() > 1){
					//Modchu_Debug.mDebug("Modchulib checkRelease k="+k);
					check = integerCheck(k.substring(0, k.length() - 1));
					k = k.substring(0, k.length() - 1);
				}
				int m = Integer.valueOf(k);
				//Modchu_Debug.mDebug("Modchulib checkRelease m="+m+" mck="+mck);
				if (integerCheck(ck)) ck = "";
				check = integerCheck(s);
				while(!check
						&& s.length() > 1){
					//Modchu_Debug.mDebug("Modchulib checkRelease s="+s);
					check = integerCheck(s.substring(0, s.length() - 1));
					s = s.substring(0, s.length() - 1);
				}
				int i = Integer.valueOf(s);
				Modchu_Debug.mDebug("Modchulib checkRelease m="+m+" mck="+mck+" i="+i+" ck="+ck);
				if (i > m) {
					return true;
				}
				if (i == m
						&& ck.compareTo(mck) > 0) {
					return true;
				}
				return false;
			}
		}
		return false;
	}

	public static int integerCheckInt(String s) {
		try {
			Integer.valueOf(s);
			return 1;
		} catch (Exception e) {
			try {
				Long.valueOf(s);
				return 2;
			} catch (Exception e1) {
				return -1;
			}
		}
	}

	public static boolean integerCheck(String s) {
		try {
			Integer.valueOf(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean floatCheck(String s) {
		try {
			Float.valueOf(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean byteCheck(String s) {
		try {
			Byte.valueOf(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static int getVersionStringConversionInt(String s) {
		int i = 0;
		if (s.length() > 1) {
			String s1 = s.substring(s.length() - 1);
			s = s.substring(0, s.length() - 1);
			i = Integer.parseInt(s) * 100 + s1.compareTo("a") + 1;
		} else {
			i = Integer.parseInt(s) * 100;
		}
		return i;
	}

	public static void setNewRelease(String s) {
		newRelease = true;
		newVersion = s;
	}

	public static String getPackege(int i, int j) {
		return getTextureBoxFileName(getTextureManagerTextures(j));
	}

	public static String getModelSpecificationArmorPackege(String s) {
		s = lastIndexProcessing(s, "_");
		String s1 = null;
		Object ltb;
		for (int color = 0 ; color < 16 ; color++) {
			for (int i = 0 ; i < getTextureManagerTexturesSize() ; ++i) {
				ltb = getTextureManagerTextures(i);
				if (getTextureBoxHasArmor(ltb)) {
					if (lastIndexProcessing(getTextureBoxFileName(ltb), "_").equalsIgnoreCase(s)) {
						//Modchu_Debug.mDebug("ltb.packegeName="+getTextureBoxFileName(ltb));
						return getTextureBoxFileName(ltb);
					}
				}
			}
		}
		return null;
	}

	public static String lastIndexProcessing(String t, String t1) {
		int j = t.lastIndexOf(t1);
		if(j > -1) return t.substring(j + 1);
		return t;
	}

	public static Object getTextureBox(String s) {
		s = textureNameCheck(s);
		Object o = Modchu_Reflect.getFieldObject(MMM_TextureManager, "instance");
		if (o != null) return Modchu_Reflect.invokeMethod(MMM_TextureManager, "getTextureBox", new Class[]{ String.class }, o, new Object[]{ s });
		return null;
	}

	public static Object[] getTextureModels(Entity entity, String s) {
		return getTextureModels(entity, s, false);
	}

	public static Object[] getTextureModels(Entity entity, String s, boolean b) {
		Object o = Modchu_Reflect.getFieldObject(MMM_TextureManager, "instance");
		if (o != null) {
			Object ltb = Modchu_Reflect.invokeMethod(MMM_TextureManager, "getTextureBox", new Class[]{ String.class }, o, new Object[]{ s });
			return modelNewInstance(entity, s, b, true);
		}
		return null;
	}

	public static Object getTextureBox(int i) {
		return getTextureManagerTextures(i);
	}

	public static Object[] getTextureModels(Entity entity, int i) {
		return getTextureModels(entity, i, false);
	}

	public static Object[] getTextureModels(Entity entity, int i, boolean b) {
		Object ltb = getTextureManagerTextures(i);
		return modelNewInstance(entity, getTextureBoxFileName(ltb), b, true);
	}

	public static Object[] modelNewInstance(Entity entity, String s, boolean b, boolean useCustom) {
		Map<String, Object[]> map = null;
		if (entity != null) map = entityModelMapData.get(entity);
		else map = dummyModelMapData;
		Object[] models = null;
		s = textureNameCheck(s);
		String s1 = lastIndexProcessing(s, "_");
		if (map != null) {
			if (!b) {
				models = map.get(s);
				if (models != null
						&& models[0] != null
						&& models[1] != null
						&& models[2] != null) {
					//Modchu_Debug.mDebug("modelNewInstance return models. s="+s);
					return models;
				} else {
					//Modchu_Debug.mDebug("modelNewInstance models == null s="+s);
				}
			}
		}
		if (map != null) ;else {
			map = new HashMap<String, Object[]>();
			//Modchu_Debug.mDebug("modelNewInstance map = new HashMap");
		}
		models = modelNewInstance(s, useCustom);
		if (models != null
				&& models[0] != null
				&& models[1] != null
				&& models[2] != null) {
			map.put(s, models);
			if (entity != null) entityModelMapData.put(entity, map);
			return models;
		}
		boolean isBiped = s1.equalsIgnoreCase("Biped");
		String t = isBiped ? "Biped_Biped" : s;
		models = modelNewInstance(t, useCustom);
		if (models != null
				&& models[0] != null
				&& models[1] != null
				&& models[2] != null) {
			map.put(t, models);
			if (entity != null) entityModelMapData.put(entity, map);
		}
		return models;
	}

	public static Object[] modelNewInstance(String s, boolean useCustom) {
		Object[] models = new Object[3];
		String s1 = s != null ? lastIndexProcessing(s, "_") : s;
		String defaultModelName = (String) Modchu_Reflect.getFieldObject(MMM_TextureManager, "defaultModelName");
		String s2 = s1 != null
				&& (defaultModelName != null
				&& s1.indexOf(defaultModelName) == -1)
				&& s.indexOf("_") > -1 ?
				new StringBuilder().append(modelClassName).append("_").append(s1).toString()
				: modelClassName;
		Class c = Modchu_Reflect.loadClass(mod_Modchu_ModchuLib.modchu_Main.getClassName(s2), -1);
		Modchu_Debug.mDebug("modelNewInstance c="+c);
		if (c != null) {
			//Modchu_Debug.mDebug("modelNewInstance s="+s+" c="+c);
			Object o = Modchu_Reflect.newInstance(c, new Class[]{ float.class }, new Object[]{ 0.0F });
			if (o != null) {
				models[0] = o;
/*//125delete
				if (isSmartMoving
						&& mod_pflm_playerformlittlemaid.playerFormLittleMaidVersion <= 124) {
					boolean isBiped = mod_PFLM_PlayerFormLittleMaid.BipedClass != null ?
							mod_PFLM_PlayerFormLittleMaid.BipedClass.isInstance(models[0]) : s.equalsIgnoreCase("Biped");
					float[] f1 = new float[2];
					f1[0] = isBiped ? 0.5F : 0.1F;
					f1[1] = isBiped ? 1.0F : 0.5F;
					//Modchu_Debug.mDebug("4modelNewInstance o != null isBiped="+isBiped);
					models[1] = Modchu_Reflect.newInstance(c, new Class[]{ float.class, int.class, int.class }, new Object[]{ f1[0], MultiModelSmart.NoScaleStart, MultiModelSmart.Scale });
					models[2] = Modchu_Reflect.newInstance(c, new Class[]{ float.class, int.class, int.class }, new Object[]{ f1[1], MultiModelSmart.NoScaleStart, MultiModelSmart.NoScaleEnd });
					//Modchu_Debug.mDebug("5modelNewInstance o != null models[1] != null ? "+(models[1] != null));
				} else {
*///125delete
					float[] f1 = getArmorModelsSize(models[0]);
					models[1] = Modchu_Reflect.newInstance(c, new Class[]{ float.class }, new Object[]{ f1[0] });
					models[2] = Modchu_Reflect.newInstance(c, new Class[]{ float.class }, new Object[]{ f1[1] });
/*//125delete
				}
*///125delete
				models = entityTypeSetting(models);
				return models;
			}
		} else {
			Object ltb = getTextureBox(s);
			if (ltb != null) models = getTextureBoxModels(ltb);
		}
		Modchu_Debug.mDebug("modelNewInstance c == null s="+s);
		if (useCustom) models = newModelCustom(models, s);
		models = entityTypeSetting(models);
		return models;
	}

	private static Object[] entityTypeSetting(Object[] models) {
		if (models[0] instanceof MultiModelCustom) ((MultiModelCustom) models[0]).customModel.entityType = ((MultiModelCustom) models[0]).customModel.PFLM;
		if (models[1] instanceof MultiModelCustom) ((MultiModelCustom) models[1]).customModel.entityType = ((MultiModelCustom) models[1]).customModel.PFLM;
		if (models[2] instanceof MultiModelCustom) ((MultiModelCustom) models[2]).customModel.entityType = ((MultiModelCustom) models[2]).customModel.PFLM;
		return models;
	}

	public static Object[] newModelCustom(Object[] models, String s) {
		Class c = Modchu_Reflect.loadClass(mod_Modchu_ModchuLib.modchu_Main.getClassName("MultiModel_Custom"), -1);
		Modchu_Debug.mDebug("newModelCustom s="+s);
		if (models != null) ;else {
			models = new MultiModel[3];
			models[0] = new MultiModel(0.0F);
			float[] f = ((MultiModel) models[0]).getArmorModelsSize();
			models[1] = new MultiModel(f[0]);
			models[2] = new MultiModel(f[1]);
		}
		if (s.indexOf("_") < 0) return models;
		if (c != null
				&& models != null) {
			if (models[0] != null) ;else Modchu_Debug.mDebug("models[0] == null !!");
			if (models[0] != null) {
				Object[] newModels = new Object[3];
				newModels[0] = Modchu_Reflect.newInstance(c, new Class[]{ float.class, MMM_ModelMultiBase.class, String.class }, new Object[]{ 0.0F, models[0], s});
				if (newModels[0] != null) ;else {
					Modchu_Debug.lDebug("newModelCustom newModels[0] == null !!");
					return null;
				}
				float[] f1 = getArmorModelsSize(models[0]);
				if (models[1] != null) ;else Modchu_Debug.mDebug("models[1] == null !!");
				if (models[2] != null) ;else Modchu_Debug.mDebug("models[2] == null !!");
				if (models[1] != null) {
					if (LMMarmorSupport) newModels[1] = (MultiModelCustom) Modchu_Reflect.newInstance(c, new Class[]{ float.class, MMM_ModelMultiBase.class, String.class }, new Object[]{ f1[0], models[1], s });
					else newModels[1] = models[1];
				}
				if (models[2] != null) {
					if (LMMarmorSupport) newModels[2] = (MultiModelCustom) Modchu_Reflect.newInstance(c, new Class[]{ float.class, MMM_ModelMultiBase.class, String.class }, new Object[]{ f1[1], models[2], s });
					else newModels[2] = models[2];
				}
				newModels = entityTypeSetting(newModels);
				return newModels;
			}
		}
		Modchu_Debug.lDebug("newModelCustom return null !! s="+s);
		return null;
	}

	public static Object checkTexturePackege(String s, int i) {
		Object ltb = getTextureBox(s);
		if (ltb != null) {
			Object s1 = textureManagerGetTexture(s, i);
			if (s1 != null) {
				//Modchu_Debug.mDebug("checkTexturePackege ok s1="+s1);
				return ltb;
			}
		}
		return null;
	}

	public static Object checkTextureArmorPackege(String s) {
		Object ltb = getTextureBox(s);
		if (ltb != null
				&& getTextureBoxHasArmor(ltb)) {
			Object s1 = textureManagerGetArmorTexture(s, 64, new ItemStack(Item.helmetDiamond));
			if (s1 != null) {
				//Modchu_Debug.mDebug("checkTextureArmorPackege ok s1="+s1);
				return ltb;
			}
		}
		return null;
	}

	public static Object textureManagerGetTexture(String s, int i) {
		s = textureNameCheck(s);
		Object ltb = getTextureBox(s);
		if (ltb != null) return getTextureBoxTextureName(ltb, i);
		//Modchu_Debug.mDebug("textureManagerGetTextureName return null !! s="+s+" i="+i);
		s = textureNameCheck(null);
		ltb = getTextureBox(s);
		if (ltb != null) return getTextureBoxTextureName(ltb, i);
		return null;
	}

	public static boolean textureColorChack(String s, int i) {
		s = textureNameCheck(s);
		Object ltb = getTextureBox(s);
		if (ltb != null) return getTextureBoxHasColor(ltb, i);
		//Modchu_Debug.mDebug("textureColorChack return null !! s="+s+" i="+i);
		return false;
	}

	public static String textureNameCheck(String s) {
		String s1 = (String) Modchu_Reflect.getFieldObject(MMM_TextureManager, "defaultModelName");
		if (s == null
				| (s !=null
				&& s.isEmpty())) {
			if (s1 != null) {
				s = "default_"+s1;
				//Modchu_Debug.lDebug("Modchu_Main textureNameCheck default setting.");
			}
			else Modchu_Debug.lDebug("Modchu_Main textureNameCheck MMM_TextureManager defaultModelName == null !!");
		} else {
			if (s.indexOf("_") < 0) {
				if (s1 != null) s = s+"_"+s1;
			}
		}
		return s;
	}

	public static Object textureManagerGetArmorTexture(String s, int i, ItemStack is) {
		//Modchu_Debug.mDebug("textureManagerGetArmorTextureName s="+s+" i="+i);
		s = textureNameCheck(s);
		Object ltb = getTextureBox(s);
		if (ltb != null) {
			if (getMinecraftVersion() > 159) return Modchu_Reflect.invokeMethod(MMM_TextureBox, "getArmorTextureName", new Class[]{int.class, ItemStack.class}, ltb, new Object[]{i, is});
			else {
				boolean b = i == 1 | i == 64;
				return Modchu_Reflect.invokeMethod(MMM_TextureBox, "getArmorTextureName", new Class[]{boolean.class, ItemStack.class}, ltb, new Object[]{b, is});
			}
		}
		//Modchu_Debug.mDebug("textureManagerGetArmorTextureName return null !! s="+s+" i="+i);
		return null;
	}

	public static String textureManagerGetNextPackege(String s, int i) {
		return textureManagerGetPackege(s, i, 0);
	}

	public static String textureManagerGetPrevPackege(String s, int i) {
		return textureManagerGetPackege(s, i, 1);
	}

	public static String textureManagerGetPackege(String s, int i, int i1) {
		Object ltb = getTextureBox(s);
		if (ltb != null) {
			Object o = Modchu_Reflect.getFieldObject(MMM_TextureManager, "instance");
			if (o != null) {
				ltb = i1 == 0 ? Modchu_Reflect.invokeMethod(MMM_TextureManager, "getNextPackege", new Class[]{MMM_TextureBox, int.class}, o, new Object[]{ltb, i}) :
					Modchu_Reflect.invokeMethod(MMM_TextureManager, "getPrevPackege", new Class[]{MMM_TextureBox, int.class}, o, new Object[]{ltb, i});
				return getTextureBoxFileName(ltb);
			}
		}
		Modchu_Debug.mDebug("textureManagerGetPackege return null !! s="+s+" i="+i);
		return null;
	}

	public static String textureManagerGetNextArmorPackege(String s) {
		return textureManagerGetArmorPackege(s, 0);
	}

	public static String textureManagerGetPrevArmorPackege(String s) {
		return textureManagerGetArmorPackege(s, 1);
	}

	public static String textureManagerGetArmorPackege(String s, int i) {
		Modchu_Debug.mDebug("textureManagerGetArmorPackege s="+s+" i="+i);
		String s1 = (String) Modchu_Reflect.getFieldObject(MMM_TextureManager, "defaultModelName");
		Object textureManagerInstance = Modchu_Reflect.getFieldObject(MMM_TextureManager, "instance");
		if (textureManagerInstance != null) ;else {
			throw new RuntimeException("Modchu_Main-textureManagerGetArmorPackege MMM_TextureManager instance == null !!");
		}
		List textures = (List)Modchu_Reflect.getFieldObject(textureManagerInstance.getClass(), "textures", textureManagerInstance);
		Object ltb = getTextureBox(s);
		int index = -1;
		String s2 = s;
		int i2 = s != null && !s.isEmpty() ? s.lastIndexOf(s1) : -1;
		if (i2 > -1) {
			s2 = s.substring(0, i2);
		}
		for(int i1 = 0; i1 < textures.size(); i1++) {
			ltb = textures.get(i1);
			if(((String) Modchu_Reflect.getFieldObject(ltb.getClass(), "fileName", ltb)).equals(s)) {
				index = i1;
				break;
			}
		}
		if (index == -1) {
			Modchu_Debug.mDebug("textureManagerGetArmorPackege return index == -1 !!");
			return null;
		}
		boolean flag = false;
		for(int i1 = 0; i1 < textures.size(); i1++) {
			index = i == 0 ? index + 1 : index - 1;
			if (index >= textures.size()) index = 0;
			if (index < 0) index = textures.size() - 1;
			ltb = textures.get(index);
			//ltb = i == 0 ? Modchu_Reflect.invokeMethod(MMM_TextureManager, "getNextArmorPackege", new Class[]{MMM_TextureBox}, textureManagerInstance, new Object[]{ltb}) :
			//Modchu_Reflect.invokeMethod(MMM_TextureManager, "getPrevArmorPackege", new Class[]{MMM_TextureBox}, textureManagerInstance, new Object[]{ltb});
			Modchu_Debug.mDebug("textureManagerGetArmorPackege index for index="+index+" s="+(String) Modchu_Reflect.getFieldObject(ltb.getClass(), "fileName", ltb));
			if (getTextureBoxHasArmor(ltb)) {
				s = (String) Modchu_Reflect.getFieldObject(ltb.getClass(), "fileName", ltb);
				if (!s.isEmpty()
						&& !s.equals(s2)) {
					Modchu_Debug.mDebug("textureManagerGetArmorPackege flag ok.textures.size()="+textures.size());
					Modchu_Debug.mDebug("textureManagerGetArmorPackege flag ok.s="+s);
					flag = true;
					break;
				}
			}
		}
		if (!flag) Modchu_Debug.mDebug("textureManagerGetArmorPackege !flag !!");
		i2 = s.lastIndexOf(s1);
		if (i2 > -1) s = s.substring(0, i2);
		Modchu_Debug.mDebug("textureManagerGetArmorPackege return s="+s);
		return s;
	}

	public static Object[] getTextureBoxModels(Object ltb) {
		return ltb != null ? (Object[]) Modchu_Reflect.getFieldObject(MMM_TextureBox, "models", ltb) : null;
	}
/*
	public static void setTextureBoxModels(Object ltb, Object[] o) {
		Modchu_Reflect.setFieldObject(MMM_TextureBox, "models", ltb, o);
	}
*/
	public static boolean getTextureBoxHasArmor(Object ltb) {
		return ltb != null ? (Boolean) Modchu_Reflect.invokeMethod(MMM_TextureBox, "hasArmor", ltb) : false;
	}

	public static boolean getTextureBoxHasColor(Object ltb, int i) {
		return ltb != null ? (Boolean) Modchu_Reflect.invokeMethod(MMM_TextureBox, "hasColor", new Class[]{ int.class }, ltb, new Object[]{ i }) : false;
	}

	public static Object getTextureBoxTextureName(Object ltb, int i) {
		return ltb != null ? Modchu_Reflect.invokeMethod(MMM_TextureBox, "getTextureName", new Class[]{ int.class }, ltb, new Object[]{ i }) : null;
	}

	public static String getTextureBoxFileName(Object ltb) {
		return ltb != null ? (String) Modchu_Reflect.getFieldObject(MMM_TextureBox, "fileName", ltb) : null;
	}

	public static List getTextureManagerTextures() {
		Object o = Modchu_Reflect.getFieldObject(MMM_TextureManager, "instance");
		if (o != null) return (List) Modchu_Reflect.getFieldObject(MMM_TextureManager, "textures", o);
		return null;
	}

	public static int getTextureManagerTexturesSize() {
		Object o = Modchu_Reflect.getFieldObject(MMM_TextureManager, "instance");
		if (o != null) {
			List list = (List) Modchu_Reflect.getFieldObject(MMM_TextureManager, "textures", o);
			return list.size();
		}
		return -1;
	}

	public static Object getTextureManagerTextures(int i) {
		Object o = Modchu_Reflect.getFieldObject(MMM_TextureManager, "instance");
		List list = null;
		if (o != null) {
			list = (List) Modchu_Reflect.getFieldObject(MMM_TextureManager, "textures", o);
		}
		return list != null
				&& i > -1 ? list.get(i) : null;
	}

	public static float[] getArmorModelsSize(Object o) {
		return o != null ? (float[]) Modchu_Reflect.invokeMethod(MMM_ModelMultiBase.class, "getArmorModelsSize", o) : null;
	}

	public static Object getMinecraft() {
		Object o = Modchu_Reflect.invokeMethod("Minecraft", "func_71410_x", "getMinecraft");
		if (o != null) return o;
		o = getMinecraftVersion() > 129 ? Modchu_Reflect.getPrivateValue("Minecraft", null, 8)
				: Modchu_Reflect.getPrivateValue("Minecraft", null, 1);
		if (o == null) {
			Modchu_Debug.mDebug("getMinecraft o == null !! Modchu_Reflect.loadClass(Minecraft)="+Modchu_Reflect.loadClass("Minecraft"));
			Modchu_Debug.mDebug("getMinecraft mod_Modchu_ModchuLib.modchu_Main.isForge="+mod_Modchu_ModchuLib.modchu_Main.isForge);
			Modchu_Debug.mDebug("getMinecraft mod_Modchu_ModchuLib.modchu_Main.getMinecraftVersion()="+mod_Modchu_ModchuLib.modchu_Main.getMinecraftVersion());
			throw new RuntimeException("Modchu_Main-getMinecraft o == null !!");
		}
		return o;
	}

	public static EntityPlayer getThePlayer() {
		if (mc != null) ;else mc = getMinecraft();
/*
		Modchu_Debug.Debug("getThePlayer mc="+(mc != null));
		Field[] f = mc.getClass().getDeclaredFields();
		for(int i = 0; i < f.length; i++) {
			Modchu_Debug.mlDebug("getThePlayer i="+i+" "+f[i].getName());
		}
*/
		return (EntityPlayer) Modchu_Reflect.getFieldObject("Minecraft", "field_71439_g", "thePlayer", mc);
	}

	public static void setThePlayer(EntityPlayer entityPlayer) {
		if (mc != null) ;else mc = getMinecraft();
		Modchu_Reflect.setFieldObject("Minecraft", "field_71439_g", "thePlayer", mc, entityPlayer);
	}

	public static World getTheWorld() {
		if (mc != null) ;else mc = getMinecraft();
		return (World) Modchu_Reflect.getFieldObject("Minecraft", "field_71441_e", "theWorld", mc);
	}

	public File getMinecraftDir() {
		if (mc != null) ;else mc = getMinecraft();
		return (File) (getMinecraftVersion() > 159 ? Modchu_Reflect.getFieldObject("Minecraft", "field_71412_D", "mcDataDir", mc) :
			Modchu_Reflect.invokeMethod("Minecraft", "func_71380_b", "getMinecraftDir", mc));
	}

	public static int getMinecraftVersion() {
		return mod_Modchu_ModchuLib.modchu_Main.modchuLibVersion;
	}
}