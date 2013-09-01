package net.minecraft.src;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Modchu_Main {

	public static final String version = "5d";
	public static final String modName = "ModchuLib";
	public static final String versionString = Modchu_Version.version + "-" + version;

	//cfg書き込み項目
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
	public static Class mod_PFLM_PlayerFormLittleMaid;
	public static Class mod_LMM_littleMaidMob;
	public static Class mod_PFLMF;
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

	public static String newVersion = "";
	public static String packageName;
	public static String modelClassName = "MultiModel";
	public static int modchuLibVersion;
	private static File cfgdir;
	private static File mainCfgfile;
	public static HashMap<String, Object[]> checkModelsBox = new HashMap();
	public static HashMap<Entity, Map> entityModelMapData = new HashMap();
	public static Map<String, Object[]> dummyModelMapData = new HashMap();
	public static List<String> ngPlayerModelList = new ArrayList<String>();
	public static boolean isClient = true;
	private static boolean packageNameNull = false;
	public static boolean isRelease = true;
	public static Object mc = getMinecraft();

	//不具合有り機能封印
	private static boolean LMMarmorSupport = false;

	public Modchu_Main()
	{
		// b181deleteload();
		if (getVersion().startsWith("1.6.2")) {
			modchuLibVersion = 162;
			return;
		}
		if (getVersion().startsWith("1.5.2")) {
			modchuLibVersion = 152;
			return;
		}
		if (getVersion().startsWith("1.5.1")) {
			modchuLibVersion = 151;
			return;
		}
		if (getVersion().startsWith("1.4.7")) {
			modchuLibVersion = 147;
			return;
		}
		if (getVersion().startsWith("1.4.6")) {
			modchuLibVersion = 146;
			return;
		}
		if (getVersion().startsWith("1.4.5")) {
			modchuLibVersion = 145;
			return;
		}
		if (getVersion().startsWith("1.4.4")) {
			modchuLibVersion = 144;
			return;
		}
		if (getVersion().startsWith("1.4.2")) {
			modchuLibVersion = 142;
			return;
		}
		if (getVersion().startsWith("1.4.1")) {
			modchuLibVersion = 141;
			return;
		}
		if (getVersion().startsWith("1.4")) {
			modchuLibVersion = 140;
			return;
		}
		if (getVersion().startsWith("1.3.2")) {
			modchuLibVersion = 132;
			return;
		}
		if (getVersion().startsWith("1.3.1")) {
			modchuLibVersion = 131;
			return;
		}
		if (getVersion().startsWith("1.2.5")) {
			modchuLibVersion = 125;
			return;
		}
		if (getVersion().startsWith("1.2.4")) {
			modchuLibVersion = 124;
			return;
		}
		if (getVersion().startsWith("1.2.3")) {
			modchuLibVersion = 123;
			return;
		}
		if (getVersion().startsWith("1.1")) {
			modchuLibVersion = 110;
			return;
		}
		if (getVersion().startsWith("1.0.0")) {
			modchuLibVersion = 100;
			return;
		}
		if (getVersion().startsWith("Beta 1.9")) {
			modchuLibVersion = 90;
			return;
		}
		if (getVersion().startsWith("Beta 1.8.1")) {
			modchuLibVersion = 81;
			return;
		}
		if (getVersion().startsWith("Beta 1.7.3")) {
			modchuLibVersion = 73;
			return;
		}
		if (getVersion().startsWith("Beta 1.6.6")) {
			modchuLibVersion = 66;
			return;
		}
		if (getVersion().startsWith("Beta 1.5_01")) {
			modchuLibVersion = 51;
			return;
		}
		modchuLibVersion = 0;
	}

	public String getName() {
		return modName;
	}

	public String getVersion() {
		return versionString;
	}

	public void load() {
		//対応MOD導入チェック class直チェック
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
							Object o = Modchu_Reflect.getFieldObject(s, "armor", false);
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
		//minecraft旧バージョン用
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
			// ロード
			Object o = Modchu_Reflect.getFieldObject(MMM_TextureManager, "instance");
			if (isClient) {
				// テクスチャパックの構築
				if (o != null) Modchu_Reflect.invokeMethod(MMM_TextureManager, "loadTextures", o);
//-@-125
				Modchu_Reflect.invokeMethod(MMM_StabilizerManager, "loadStabilizer");
//@-@125
			} else {
				if (o != null) Modchu_Reflect.invokeMethod(MMM_TextureManager, "loadTextureIndex", o);
			}
//-@-125
			// テクスチャインデックスの構築
			Modchu_Debug.lDebug("Localmode: InitTextureList.");
			if (o != null) Modchu_Reflect.invokeMethod(MMM_TextureManager, "initTextureList", new Class[]{ boolean.class}, o, new Object[]{ true });
//@-@125
		}

		//対応MOD導入チェック ModLoader対応MOD
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
			else if (name.equals("mod_PFLMF")) {
				isPFLMF = true;
				mod_PFLMF = Modchu_Reflect.loadClass(getClassName("mod_PFLMF"), -1);
				Modchu_Debug.lDebug("mod_PFLMF Check ok.");
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
		// cfg読み込み
		if (cfgdir.exists()) {
			if (!mainCfgfile.exists()) {
				// cfgファイルが無い = 新規作成
				String s[] = {
						"skirtFloats=false", "skirtFloatsVolume=1.0D", "debugMessage=true", "debugMessagetexture=true", "debugReflectMessage=true",
						"debugReflectMessageDetail=false", "modchuRemodelingModel=true", "useInvisibilityBody=true", "useInvisibilityArmor=false", "useInvisibilityItem=false",
						"versionCheck=true",  "debugCustomModelMessage=false", "debugLogMessage=false", "careerSave=false"
				};
				Modchu_Config.writerConfig(mainCfgfile, s);
			} else {
				// cfgファイルがある
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
		if (Modchu_Debug.debugMessage
				&& !mod_Modchu_ModchuLib.modchu_Main.isRelease()) {
			Modchu_Debug.dDebugDrow();
			return true;
		} else {
			return false;
		}
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
				String k = mck;
				if (k.lastIndexOf("-") > -1) k = k.substring(k.lastIndexOf("-") + 1);
				mck = k.substring(k.length() - 1);
				if (integerCheck(mck)) mck = "";
				boolean check = integerCheck(k);
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
				return models;
			}
		} else {
			Object ltb = getTextureBox(s);
			if (ltb != null) models = getTextureBoxModels(ltb);
		}
		Modchu_Debug.mDebug("modelNewInstance c == null s="+s);
		return useCustom ? newModelCustom(models, s) : models;
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
				newModels[0] = (MultiModel_Custom) Modchu_Reflect.newInstance(c, new Class[]{ float.class, MMM_ModelMultiBase.class, String.class }, new Object[]{ 0.0F, models[0], s});
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
				return newModels;
			}
		}
		Modchu_Debug.mDebug("newModelCustom return null !! s="+s);
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
		Object ltb = getTextureBox(s);
		if (ltb != null) {
			Object o = Modchu_Reflect.getFieldObject(MMM_TextureManager, "instance");
			if (o != null) {
				ltb = Modchu_Reflect.invokeMethod(MMM_TextureManager, "getNextPackege", new Class[]{MMM_TextureBox, int.class}, o, new Object[]{ltb, i});
				return getTextureBoxFileName(ltb);
			}
		}
		Modchu_Debug.mDebug("textureManagerGetNextPackege return null !! s="+s+" i="+i);
		return null;
	}

	public static String textureManagerGetPrevPackege(String s, int i) {
		Object ltb = getTextureBox(s);
		if (ltb != null) {
			Object o = Modchu_Reflect.getFieldObject(MMM_TextureManager, "instance");
			if (o != null) {
				ltb = Modchu_Reflect.invokeMethod(MMM_TextureManager, "getPrevPackege", new Class[]{MMM_TextureBox, int.class}, o, new Object[]{ltb, i});
				return getTextureBoxFileName(ltb);
			}
		}
		Modchu_Debug.mDebug("textureManagerGetPrevPackege return null !! s="+s+" i="+i);
		return null;
	}

	public static String textureManagerGetNextArmorPackege(String s) {
		Object ltb = getTextureBox(s);
		if (ltb != null) {
			Object o = Modchu_Reflect.getFieldObject(MMM_TextureManager, "instance");
			if (o != null) {
				ltb = Modchu_Reflect.invokeMethod(MMM_TextureManager, "getNextArmorPackege", new Class[]{MMM_TextureBox}, o, new Object[]{ltb});
				return (String) Modchu_Reflect.getFieldObject(ltb.getClass(), "fileName", ltb);
			}
		}
		Modchu_Debug.mDebug("textureManagerGetNextArmorPackege return null !! s="+s);
		return null;
	}

	public static String textureManagerGetPrevArmorPackege(String s) {
		Object ltb = getTextureBox(s);
		if (ltb != null) {
			Object o = Modchu_Reflect.getFieldObject(MMM_TextureManager, "instance");
			if (o != null) {
				ltb = Modchu_Reflect.invokeMethod(MMM_TextureManager, "getPrevArmorPackege", new Class[]{MMM_TextureBox}, o, new Object[]{ltb});
				return (String) Modchu_Reflect.getFieldObject(ltb.getClass(), "fileName", ltb);
			}
		}
		Modchu_Debug.mDebug("textureManagerGetPrevArmorPackege return null !! s="+s);
		return null;
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
		return getMinecraftVersion() > 129 ? Modchu_Reflect.getPrivateValue("Minecraft", null, 8)
				: Modchu_Reflect.getPrivateValue("Minecraft", null, 1);
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
