package net.minecraft.src;

import org.lwjgl.input.Keyboard;


public class Modchu_Debug {

	public static boolean debugMessage = true;
	public static boolean debugMessagetexture = true;
	public static boolean debugCustomModelMessage = false;
	public static boolean isRelease;
	public static String[] debugString;
	public static float debaf1 = 0.0F;
	public static float debaf2 = 0.0F;
	public static float debaf3 = 0.0F;
	private static int key;

	public static void init(String s) {
		isRelease = mod_Modchu_ModchuLib.modchu_Main.isRelease;
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

	public static void cDebug(String s) {
		if (debugCustomModelMessage) System.out.println((new StringBuilder()).append("Modchu_cDebug_").append(s).toString());
	}

	public static void mlDebug(String s) {
		if (debugMessage) {
			ModLoader.getLogger().fine("playerFormLittleMaid-"+s);
			Debug(s);
		}
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
			if (debugString != null) {
				GuiIngame ingameGUI = (GuiIngame) Modchu_Reflect.getFieldObject("Minecraft", "ingameGUI", mod_Modchu_ModchuLib.modchu_Main.getMinecraft());
				ingameGUI.drawString((FontRenderer) Modchu_Reflect.getFieldObject("Minecraft", "fontRenderer", mod_Modchu_ModchuLib.modchu_Main.getMinecraft()), debugString[i], 1, 1 + (10 * i), 0xffffff);
			}
		}
		if (!Keyboard.getEventKeyState()) {
			key = -1;
		}
		if (key != 200
				& Keyboard.isKeyDown(200)) {
			key = 200;
			debaf1 += Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54) ? 1.0F : 0.1F;
		}
		if (key != 208
				& Keyboard.isKeyDown(208)) {
			key = 208;
			debaf1 -= Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54) ? 1.0F : 0.1F;
		}
		if (key != 202
				& Keyboard.isKeyDown(202)) {
			key = 202;
			debaf2 += Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54) ? 1.0F : 0.1F;
		}
		if (key != 204
				& Keyboard.isKeyDown(204)) {
			key = 204;
			debaf2 -= Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54) ? 1.0F : 0.1F;
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
