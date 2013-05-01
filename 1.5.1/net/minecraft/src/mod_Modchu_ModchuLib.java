package net.minecraft.src;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import net.minecraft.client.Minecraft;

public class mod_Modchu_ModchuLib extends BaseMod {

	//cfg書き込み項目
	public static boolean skirtFloats = false;
	public static float skirtFloatsVolume = 1.0F;
	public static boolean modchuRemodelingModel = true;
	public static boolean useInvisibilityBody = true;
	public static boolean useInvisibilityArmor = false;
	public static boolean useInvisibilityItem = false;
	public static boolean versionCheck = true;

	public static boolean isForge = false;
	public static boolean isLMM = false;
	public static boolean isPFLM = false;
	public static boolean isFavBlock = false;
	public static boolean isDecoBlock = false;
	public static boolean isBTW = false;
	public static boolean isSSP = false;
	public static boolean newRelease = false;
	public static boolean oldRenderItems = false;
	public static mod_Modchu_ModchuLib mod_modchu_modchulib;
	public static Class MMM_TextureManager;
	public static Class MMM_FileManager;
	public static Class MMM_TextureBox;
	public static Class MMM_StabilizerManager;
	public static Class mod_PFLM_PlayerFormLittleMaid;
	public static Class mod_LMM_littleMaidMob;
	public static Class PFLM_Gui;
	public static Class PFLM_GuiModelSelect;
	public static Class PFLM_GuiOthersPlayer;
	public static Class PFLM_GuiOthersPlayerIndividualCustomize;
	public static Class PFLM_EntityPlayerDummy;
	public static Class PFLM_RenderPlayer;
	public static Class PFLM_RenderPlayer2;
	public static Class LMM_EntityLittleMaid;
	public static Class decoBlock;
	public static Class decoBlockBase;
	public static Class favBlock;
	public static Class RendererData;
	private boolean isModchu;
	public final String minecraftVersion;
	public static String newVersion = "";
	public static String packageName;
	public static int modchuLibVersion;
	private static final File cfgdir = new File(Minecraft.getMinecraftDir(), "/config/");
	private static File mainCfgfile = new File(cfgdir, ("Modchu_ModchuLib.cfg"));
	public static boolean isClient = true;
	private static boolean packageNameNull = false;
	public static Minecraft mc = Minecraft.getMinecraft();

	public mod_Modchu_ModchuLib()
	{
		// b181deleteload();
		if (getVersion().startsWith("1.5.1")) {
			minecraftVersion = "1.5.1";
			modchuLibVersion = 151;
			return;
		}
		if (getVersion().startsWith("1.4.6~7")) {
			minecraftVersion = "1.4.7";
			modchuLibVersion = 147;
			return;
		}
		if (getVersion().startsWith("1.4.6")) {
			modchuLibVersion = 146;
			minecraftVersion = "1.4.6";
			return;
		}
		if (getVersion().startsWith("1.4.4~5")) {
			modchuLibVersion = 145;
			minecraftVersion = "1.4.5";
			return;
		}
		if (getVersion().startsWith("1.4.4")) {
			modchuLibVersion = 144;
			minecraftVersion = "1.4.4";
			return;
		}
		if (getVersion().startsWith("1.4.2")) {
			modchuLibVersion = 142;
			minecraftVersion = "1.4.2";
			return;
		}
		if (getVersion().startsWith("1.4.1")) {
			modchuLibVersion = 141;
			minecraftVersion = "1.4.1";
			return;
		}
		if (getVersion().startsWith("1.4")) {
			modchuLibVersion = 140;
			minecraftVersion = "1.4";
			return;
		}
		if (getVersion().startsWith("1.3.2")) {
			modchuLibVersion = 132;
			minecraftVersion = "1.3.2";
			return;
		}
		if (getVersion().startsWith("1.3.1")) {
			modchuLibVersion = 131;
			minecraftVersion = "1.3.1";
			return;
		}
		if (getVersion().startsWith("1-2-4")) {
			modchuLibVersion = 124;
			minecraftVersion = "1.2.4";
			return;
		}
		if (getVersion().startsWith("1-2-3")) {
			modchuLibVersion = 123;
			minecraftVersion = "1.2.3";
			return;
		}
		if (getVersion().startsWith("1-1")) {
			modchuLibVersion = 110;
			minecraftVersion = "1.1.0";
			return;
		}
		if (getVersion().startsWith("1-0-0")) {
			modchuLibVersion = 100;
			minecraftVersion = "1.0.0";
			return;
		}
		if (getVersion().startsWith("1-9pre")) {
			modchuLibVersion = 90;
			minecraftVersion = "1.9pre";
			return;
		}
		if (getVersion().startsWith("1-8-1")) {
			modchuLibVersion = 81;
			minecraftVersion = "beta1.8.1";
			return;
		}
		if (getVersion().startsWith("1-7-3")) {
			modchuLibVersion = 73;
			minecraftVersion = "beta1.7.3";
			return;
		}
		if (getVersion().startsWith("1-6-6")) {
			modchuLibVersion = 66;
			minecraftVersion = "beta1.6.6";
			return;
		}
		if (getVersion().startsWith("1-5-1")) {
			modchuLibVersion = 51;
			minecraftVersion = "beta1.5.1";
			return;
		}
		modchuLibVersion = 0;
		minecraftVersion = "";
	}

	@Override
	public String getName() {
		return "ModchuLib";
	}

	@Override
	public String getVersion() {
		return "1.5.1-2c";
	}

	@Override
	public void load() {
		mod_modchu_modchulib = this;
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
				ModLoader.getLogger().fine((new StringBuilder("Modchu_ModchuLib-"+ test2 + " Check ok.")).toString());
				Modchu_Debug.Debug(test2 + " Check ok.");
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
		String s;
		if (Modchu_Debug.debugMessage
				&& !mod_modchu_modchulib.isRelease()) Modchu_Debug.debugString = new String[10];
		ModLoader.setInGameHook(this, true, true);
		//minecraft旧バージョン用
		isModchu = Modchu_Reflect.loadClass(getClassName("Modchu_TextureManager"), false) != null;
		if (isModchu) {
			MMM_TextureManager = Modchu_Reflect.loadClass(getClassName("Modchu_TextureManager"));
			MMM_FileManager = Modchu_Reflect.loadClass(getClassName("Modchu_FileManager"));
			Modchu_Reflect.invokeMethod(MMM_FileManager, "init");
			Modchu_Reflect.invokeMethod(MMM_TextureManager, "init");
//-@-125
			MMM_StabilizerManager = Modchu_Reflect.loadClass(getClassName("Modchu_StabilizerManager"));
			Modchu_Reflect.invokeMethod(MMM_StabilizerManager, "init");
//@-@125
		} else {
			MMM_TextureManager = Modchu_Reflect.loadClass(getClassName("MMM_TextureManager"));
			MMM_FileManager = Modchu_Reflect.loadClass(getClassName("MMM_FileManager"));
			MMM_StabilizerManager = Modchu_Reflect.loadClass(getClassName("MMM_StabilizerManager"));
		}

		mod_LMM_littleMaidMob = Modchu_Reflect.loadClass(getClassName("mod_LMM_littleMaidMob"), false);
		if (mod_LMM_littleMaidMob != null) {
			isLMM = true;
			LMM_EntityLittleMaid = Modchu_Reflect.loadClass(getClassName("LMM_EntityLittleMaid"));
		}

		mod_PFLM_PlayerFormLittleMaid = Modchu_Reflect.loadClass(getClassName("mod_PFLM_PlayerFormLittleMaid"), false);
		if (mod_PFLM_PlayerFormLittleMaid != null) {
			isPFLM = true;
		}

		RendererData = Modchu_Reflect.loadClass("net.smart.render.RendererData", false);
		loadcfg();
		if (versionCheck) startVersionCheckThread();
		Modchu_Debug.Debug("load() end");
	}

	@Override
	public void modsLoaded() {
		if (isModchu) {
			// ロード
			if (isClient) {
				// テクスチャパックの構築
				Modchu_Reflect.invokeMethod(MMM_TextureManager, "loadTextures");
//-@-125
				Modchu_Reflect.invokeMethod(MMM_StabilizerManager, "loadStabilizer");
//@-@125
			} else {
				Modchu_Reflect.invokeMethod(MMM_TextureManager, "loadTextureIndex");
			}
//-@-125
			// テクスチャインデックスの構築
			Modchu_Debug.Debug("Localmode: InitTextureList.");
			Modchu_Reflect.invokeMethod(MMM_TextureManager, "initTextureList", new Class[]{ boolean.class}, null, new Object[]{ true });
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
			}
			else if (name.equals("mod_DecoBlock")) {
				isDecoBlock = true;
				ModLoader.getLogger().fine("Modchu_ModchuLib-mod_DecoBlock Check ok.");
				Modchu_Debug.Debug("DecoBlock Check ok.");
			}
			else if (name.equals("mod_FavBlock")) {
				isFavBlock = true;
				ModLoader.getLogger().fine("Modchu_ModchuLib-mod_FavBlock Check ok.");
				Modchu_Debug.Debug("FavBlock Check ok.");
			}
			else if (name.equals("mod_FCBetterThanWolves")) {
				isBTW = true;
				ModLoader.getLogger().fine("Modchu_ModchuLib-mod_FCBetterThanWolves Check ok.");
				Modchu_Debug.Debug("mod_FCBetterThanWolves Check ok.");
			}
			else if (name.equals("mod_MinecraftForge")) {
				isForge = true;
				ModLoader.getLogger().fine("Modchu_ModchuLib-mod_MinecraftForge Check ok.");
				Modchu_Debug.Debug("mod_MinecraftForge Check ok.");
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
			ModLoader.getLogger().fine("playerFormLittleMaid-isDecoBlock false.");
			Modchu_Debug.Debug("isDecoBlock false.");
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
			ModLoader.getLogger().fine("playerFormLittleMaid-isFavBlock false.");
			Modchu_Debug.Debug("isFavBlock false.");
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
						"skirtFloats=false", "skirtFloatsVolume=1.0F", "debugMessage=true", "debugMessagetexture=true", "debugReflectMessage=true",
						"debugReflectMessageDetail=false", "modchuRemodelingModel=true", "useInvisibilityBody=true", "useInvisibilityArmor=false", "useInvisibilityItem=false",
						"versionCheck=true",  "debugCustomModelMessage=false"
				};
				Modchu_Config.writerConfig(mainCfgfile, s);
			} else {
				// cfgファイルがある
				skirtFloats = Boolean.valueOf((Modchu_Config.loadConfig(mainCfgfile, "skirtFloats", skirtFloats)).toString());
				skirtFloatsVolume = Float.valueOf((Modchu_Config.loadConfig(mainCfgfile, "skirtFloatsVolume", skirtFloatsVolume)).toString());
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
				String k[] = {
						"skirtFloats", "skirtFloatsVolume", "debugMessage", "debugMessagetexture", "debugReflectMessage",
						"debugReflectMessageDetail", "modchuRemodelingModel", "useInvisibilityBody", "useInvisibilityArmor", "useInvisibilityItem",
						"versionCheck", "debugCustomModelMessage"
				};
				String k1[] = {
						""+skirtFloats, ""+skirtFloatsVolume, ""+Modchu_Debug.debugMessage, ""+Modchu_Debug.debugMessagetexture, ""+Modchu_Reflect.debugReflectMessage,
						""+Modchu_Reflect.debugReflectMessageDetail, ""+modchuRemodelingModel, ""+useInvisibilityBody, ""+useInvisibilityArmor, ""+useInvisibilityItem,
						""+versionCheck, ""+Modchu_Debug.debugCustomModelMessage
				};
				if (skirtFloatsVolume < 0.0F) skirtFloatsVolume = 0.0F;
				if (skirtFloatsVolume > 2.0F) skirtFloatsVolume = 2.0F;
				Modchu_Config.writerSupplementConfig(mainCfgfile, k, k1);
			}
		}
	}

	public boolean onTickInGame(float f, Minecraft minecraft)
	{
		if (Modchu_Debug.debugMessage
				&& !mod_modchu_modchulib.isRelease()) Modchu_Debug.dDebugDrow();
		return true;
	}

	public boolean isRelease() {
		return getPackage() == null;
	}

	public String getClassName(String s) {
		if (s == null) return null;
		if (s.indexOf(".") > -1) return s;
		String s1 = getPackage();
		if (s1 != null) return s1.concat(".").concat(s);
		return s;
	}

	public void getPackageInit() {
		packageName = null;
		if (isForge) {
			Class c = Modchu_Reflect.loadClass("net.minecraft.src.mod_PFLM_PlayerFormLittleMaid", false);
			if (c != null) {
				packageName = "net.minecraft.src";
			}
		} else {
			Package pac = getClass().getPackage();
			if (pac != null) {
				packageName = pac.getName();
			}
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
				String mck = mod_modchu_modchulib.getVersion();
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

	public static boolean integerCheck(String s) {
		try {
			Integer.valueOf(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void setNewRelease(String s) {
		newRelease = true;
		newVersion = s;
	}
}
