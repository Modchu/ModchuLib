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

	public static boolean isForge = false;
	public static boolean isLMM = false;
	public static boolean isPFLM = false;
	public static boolean isFavBlock = false;
	public static boolean isDecoBlock = false;
	public static mod_Modchu_ModchuLib mod_modchu_modchulib;
	public static Class MMM_TextureManager;
	public static Class MMM_FileManager;
	public static Class MMM_TextureBox;
	public static Class MMM_StabilizerManager;
	public static Class MMM_Helper;
    public static Class mod_PFLM_PlayerFormLittleMaid;
    public static Class PFLM_Gui;
    public static Class PFLM_EntityPlayerDummy;
    public static Class mod_LMM_littleMaidMob;
    public static Class LMM_EntityLittleMaid;
	public static Class decoBlock;
	public static Class decoBlockBase;
	public static Class favBlock;
	public static Class RendererData;
	private boolean isModchu;
	private static final File cfgdir = new File(Minecraft.getMinecraftDir(), "/config/");
	private static File mainCfgfile = new File(cfgdir, ("Modchu_ModchuLib.cfg"));

	@Override
	public String getName() {
		return "ModchuLib";
	}

	@Override
	public String getVersion() {
		return "1.4.6~7-1b";
	}

	@Override
	public void load() {
		mod_modchu_modchulib = this;
		if (Modchu_Debug.debugMessage
				&& !mod_modchu_modchulib.isRelease()) Modchu_Debug.debugString = new String[10];
		ModLoader.setInGameHook(this, true, true);
		Modchu_Reflect.setDebugMessage(false);
		//minecraft旧バージョン用
		isModchu = Modchu_Reflect.loadClass(getClassName("Modchu_TextureManager")) != null;
		if (isModchu) {
			MMM_TextureManager = Modchu_Reflect.loadClass(getClassName("Modchu_TextureManager"));
			MMM_FileManager = Modchu_Reflect.loadClass(getClassName("Modchu_FileManager"));
			MMM_StabilizerManager = Modchu_Reflect.loadClass(getClassName("Modchu_StabilizerManager"));
			MMM_Helper = Modchu_Reflect.loadClass(getClassName("Modchu_Helper"));
			Modchu_Reflect.invokeMethod(MMM_FileManager, "init");
			Modchu_Reflect.invokeMethod(MMM_TextureManager, "init");
			Modchu_Reflect.invokeMethod(MMM_StabilizerManager, "init");
		}

		mod_LMM_littleMaidMob = Modchu_Reflect.loadClass(getClassName("mod_LMM_littleMaidMob"));
		if (mod_LMM_littleMaidMob != null) {
			isLMM = true;
			LMM_EntityLittleMaid = (Class) Modchu_Reflect.loadClass(getClassName("LMM_EntityLittleMaid"));
		}

		mod_PFLM_PlayerFormLittleMaid = Modchu_Reflect.loadClass(getClassName("mod_PFLM_PlayerFormLittleMaid"));
		if (mod_PFLM_PlayerFormLittleMaid != null) {
			isPFLM = true;
			PFLM_Gui = Modchu_Reflect.loadClass(getClassName("PFLM_Gui"));
			PFLM_EntityPlayerDummy = Modchu_Reflect.loadClass(getClassName("PFLM_EntityPlayerDummy"));
		}

		RendererData = Modchu_Reflect.loadClass("net.smart.render.RendererData");
		loadcfg();
		Modchu_Debug.Debug("load() end");
	}

	@Override
	public void modsLoaded() {
		if (isModchu) {
			// ロード
			if ((Boolean) Modchu_Reflect.getFieldObject(MMM_Helper, "isClient")) {
				// テクスチャパックの構築
				Modchu_Reflect.invokeMethod(MMM_TextureManager, "loadTextures");
				Modchu_Reflect.invokeMethod(MMM_StabilizerManager, "loadStabilizer");
			} else {
				Modchu_Reflect.invokeMethod(MMM_TextureManager, "loadTextureIndex");
			}

			// テクスチャインデックスの構築
			Modchu_Debug.Debug("Localmode: InitTextureList.");
			Modchu_Reflect.invokeMethod(MMM_TextureManager, "initTextureList", new Class[]{ boolean.class}, null, new Object[]{ true });
		}

		//対応MOD導入チェック ModLoader対応MOD
		List list = ModLoader.getLoadedMods();
		int size = list.size();
		for (int i = 0; i < size; i++)
		{
			BaseMod mod = (BaseMod)list.get(i);
			String name = mod.getClass().getSimpleName();
			if (name.equals("mod_DecoBlock")) {
				isDecoBlock = true;
				ModLoader.getLogger().fine("Modchu_ModchuLib-mod_DecoBlock Check ok.");
				Modchu_Debug.Debug("DecoBlock Check ok.");
			}
			else if (name.equals("mod_FavBlock")) {
				isFavBlock = true;
				ModLoader.getLogger().fine("Modchu_ModchuLib-mod_FavBlock Check ok.");
				Modchu_Debug.Debug("FavBlock Check ok.");
			}
		}

		//対応MOD導入チェック class直チェック
		String className1[] = {
				"FMLRenderAccessLibrary", "net.minecraft.decoblock.DecoBlock", "net.minecraft.favstar.BlockFav"
		};
		String test2 = null;
		for(int n = 0 ; n < className1.length ; n++){
			try {
				test2 = getClassName(className1[n]);
				test2 = ""+Class.forName(test2);
				ModLoader.getLogger().fine((new StringBuilder("Modchu_ModchuLib-"+ test2 + " Check ok.")).toString());
				Modchu_Debug.Debug(test2 + " Check ok.");
				if(n == 0) isForge = true;
				if(n == 1) isDecoBlock = true;
				if(n == 2) isFavBlock = true;
			} catch (ClassNotFoundException e) {
			}
		}

		String s = null;
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
	}

	public static void loadcfg() {
		// cfg読み込み
		if (cfgdir.exists()) {
			if (!mainCfgfile.exists()) {
				// cfgファイルが無い = 新規作成
				String s[] = {
						"skirtFloats=false", "skirtFloatsVolume=1.0F", "debugMessage=true", "debugMessagetexture=true", "debugReflectMessage=true",
						"debugReflectMessageDetail=false", "modchuRemodelingModel=true", "useInvisibilityBody=true", "useInvisibilityArmor=false", "useInvisibilityItem=false"
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
				String k[] = {
						"skirtFloats", "skirtFloatsVolume", "debugMessage", "debugMessagetexture", "debugReflectMessage",
						"debugReflectMessageDetail", "modchuRemodelingModel", "useInvisibilityBody", "useInvisibilityArmor", "useInvisibilityItem"
				};
				String k1[] = {
						""+skirtFloats, ""+skirtFloatsVolume, ""+Modchu_Debug.debugMessage, ""+Modchu_Debug.debugMessagetexture, ""+Modchu_Reflect.debugReflectMessage,
						""+Modchu_Reflect.debugReflectMessageDetail, ""+modchuRemodelingModel, ""+useInvisibilityBody, ""+useInvisibilityArmor, ""+useInvisibilityItem
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
		return getClass().getPackage() == null;
	}

	public String getClassName(String s) {
		if (s == null) return null;
		if (s.indexOf(".") > -1) return s;
		String s1 = getPackage();
		if (s1 != null) return s1.concat(".").concat(s);
		return s;
	}

	public String getPackage() {
		Package pac = getClass().getPackage();
		if (pac != null) return pac.getName();
		return null;
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

}
