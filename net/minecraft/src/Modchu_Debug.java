package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class Modchu_Debug {

	public static boolean debugMessage = true;
	public static boolean debugMessagetexture = true;
	public static boolean isRelease;
	public static String[] debugString;
	//private static Class mod_PFLM_PlayerFormLittleMaid;

	public static void init(String s) {
/*
		if (s != null) s = s.concat(".")+"mod_PFLM_PlayerFormLittleMaid";
		else s = "mod_PFLM_PlayerFormLittleMaid";
		mod_PFLM_PlayerFormLittleMaid = Modchu_Reflect.loadClass(s);
*/
		isRelease = mod_Modchu_ModchuLib.mod_modchu_modchulib.isRelease();
	}

	public static void Debug(String s) {
		if (debugMessage) System.out.println((new StringBuilder()).append("Modchu_Debug-").append(s).toString());
	}

	public static void mDebug(String s, int i) {
		mDebug(s);
	}

	public static void mDebug(String s) {
		if (debugMessage
				&& !isRelease) System.out.println((new StringBuilder()).append("Modchu_mDebug_").append(s).toString());
	}

	public static void tDebug(String s) {
		if (debugMessagetexture) System.out.println((new StringBuilder()).append("Modchu_tDebug_").append(s).toString());
	}

	public static void dDebug(String s) {
		dDebug(s, 0);
	}

	public static void dDebug(String s, int i) {
		if (debugMessage
				&& !isRelease) debugString[i] = s;
	}

	public static void dDebugDrow() {
		for(int i = 0 ;i < debugString.length ;i++){
			if (debugString != null) ModLoader.getMinecraftInstance().ingameGUI.drawString(ModLoader.getMinecraftInstance().fontRenderer, debugString[i], 1, 1 + (10 * i), 0xffffff);
		}
	}

	public String getClassName(String s) {
		if (s == null) return null;
		if (s.indexOf(".") > -1) return s;
		Package pac = getClass().getPackage();
		if (pac != null) s = pac.getName().concat(".").concat(s);
		return s;
	}
}
