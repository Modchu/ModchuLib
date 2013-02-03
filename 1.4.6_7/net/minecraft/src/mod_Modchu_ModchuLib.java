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
	public static boolean debugMessage = true;
	public static boolean debugMessageDetail = false;
	public static float skirtFloatsVolume = 1.0F;

	public static boolean isForge = false;
	public static boolean isLMM = false;
	public static boolean isPFLM = false;
	public static boolean isFavBlock = false;
	public static boolean isDecoBlock = false;
	public static Boolean modchuRemodelingModel = false;
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
	private boolean isModchu;
	private static final File cfgdir = new File(Minecraft.getMinecraftDir(), "/config/");
	private static File mainCfgfile = new File(cfgdir, ("Modchu_ModchuLib.cfg"));

	public static void Debug(String pText) {
		// デバッグメッセージ
		if (debugMessage) {
			System.out.println(String.format("ModchuLib-%s", pText));
		}
	}

	@Override
	public String getName() {
		return "ModchuLib";
	}

	@Override
	public String getVersion() {
		return "1.4.6~7-1a";
	}

	@Override
	public void load() {
		Modchu_Reflect.debugMessage = false;
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
		loadcfg();

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
			modchuRemodelingModel = (Boolean) Modchu_Reflect.getFieldObject(mod_PFLM_PlayerFormLittleMaid, "modchuRemodelingModel");
			Modchu_Reflect.setDebugMessage(debugMessage);
			Modchu_Reflect.setDebugMessageDetail(debugMessageDetail);
		} else {
			Modchu_Reflect.debugMessage = false;
		}
		mod_Modchu_ModchuLib.Debug("load() end");
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
			Debug("Localmode: InitTextureList.");
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
						"skirtFloats=false", "skirtFloatsVolume=1.0F", "debugMessage=true", "debugMessageDetail=false"
				};
				Modchu_Config.writerConfig(mainCfgfile, s);
			} else {
				// cfgファイルがある
				skirtFloats = Boolean.valueOf((Modchu_Config.loadConfig(mainCfgfile, "skirtFloats", skirtFloats)).toString());
				skirtFloatsVolume = Float.valueOf((Modchu_Config.loadConfig(mainCfgfile, "skirtFloatsVolume", skirtFloatsVolume)).toString());
				debugMessage = Boolean.valueOf((Modchu_Config.loadConfig(mainCfgfile, "debugMessage", debugMessage)).toString());
				debugMessageDetail = Boolean.valueOf((Modchu_Config.loadConfig(mainCfgfile, "debugMessageDetail", debugMessageDetail)).toString());
				String k[] = {
						"skirtFloats", "skirtFloatsVolume", "debugMessage", "debugMessageDetail"
				};
				String k1[] = {
						""+skirtFloats, ""+skirtFloatsVolume, ""+debugMessage, ""+debugMessageDetail
				};
				if (skirtFloatsVolume < 0.0F) skirtFloatsVolume = 0.0F;
				if (skirtFloatsVolume > 2.0F) skirtFloatsVolume = 2.0F;
				Modchu_Config.writerSupplementConfig(mainCfgfile, k, k1);
			}
		}
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
    		//if (flag && ((Map)entry.getValue()).get(i) != null) return (String)entry.getKey();
    		if (j1 == i) return (String)entry.getKey();
    	} while (true);
    	for (Iterator iterator1 = hashMap.entrySet().iterator(); iterator1.hasNext();) {
    		Entry entry1 = (Entry)iterator1.next();
    		if (entry1 != null) return (String)entry1.getKey();
    	}
    	return null;
    }

}
