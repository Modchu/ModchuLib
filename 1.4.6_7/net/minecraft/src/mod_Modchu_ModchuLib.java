package net.minecraft.src;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.client.Minecraft;

public class mod_Modchu_ModchuLib extends BaseMod {

	@MLProp()
	public static boolean isDebugView = false;
	@MLProp()
	public static boolean isDebugMessage = true;
	public static Class MMM_TextureManager;
	public static Class MMM_FileManager;
	public static Class MMM_TextureBox;
	public static Class MMM_StabilizerManager;
	private boolean isModchu;

	public static void Debug(String pText) {
		// デバッグメッセージ
		if (isDebugMessage) {
			System.out.println(String.format("ModchuLib-%s", pText));
		}
	}

	@Override
	public String getName() {
		return "ModchuLib";
	}

	@Override
	public String getVersion() {
		return "1.4.6~7-1";
	}

	@Override
	public void load() {
		Modchu_Reflect.debugMessage = false;
		isModchu = Modchu_Reflect.loadClass(getClassName("Modchu_TextureManager")) != null;
		Modchu_Reflect.debugMessage = true;
		if (isModchu) {
			MMM_TextureManager = Modchu_Reflect.loadClass(getClassName("MMM_TextureManager"));
			MMM_FileManager = Modchu_Reflect.loadClass(getClassName("MMM_FileManager"));
			MMM_StabilizerManager = Modchu_Reflect.loadClass(getClassName("MMM_StabilizerManager"));
			Modchu_Reflect.invokeMethod(MMM_FileManager, "init");
			Modchu_Reflect.invokeMethod(MMM_TextureManager, "init");
			Modchu_Reflect.invokeMethod(MMM_StabilizerManager, "init");
		}
		mod_Modchu_ModchuLib.Debug("load() end");
	}

	@Override
	public void modsLoaded() {
		if (isModchu) {
			// ロード
			if (MMM_Helper.isClient) {
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

}
