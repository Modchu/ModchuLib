package net.minecraft.src;

import java.io.BufferedWriter;
import java.io.File;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.lwjgl.input.Keyboard;


public class Modchu_Debug {

	public static boolean debugMessage = true;
	public static boolean debugMessagetexture = true;
	public static boolean debugCustomModelMessage = false;
	public static boolean debugLogMessage = false;
	public static boolean careerSave = false;
	public static boolean isRelease;
	public static String[] debugString;
	public static float debaf1 = 0.0F;
	public static float debaf2 = 0.0F;
	public static float debaf3 = 0.0F;
	public static float debaf4 = 0.0F;
	public static float debaf5 = 0.0F;
	public static float debaf6 = 0.0F;
	private static int key;
	private static BufferedWriter debugLogBwriter;
    private static Logger logger;
	private static String tempDebugLog = "";

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

	public static void mlDebug(String s) {
		mDebug(s);
		lDebug(s, null, 0, null);
	}

	public static void mmlDebug(String s) {
		mDebug(s);
		if (!isRelease) lDebug(s, null, 0, null);
	}

	public static void tDebug(String s) {
		if (debugMessagetexture) System.out.println((new StringBuilder()).append("Modchu_tDebug_").append(s).toString());
	}

	public static void cDebug(String s) {
		if (debugCustomModelMessage) System.out.println((new StringBuilder()).append("Modchu_cDebug_").append(s).toString());
	}

	public static void dDebug(String s) {
		dDebug(s, 0);
	}

	public static void dDebug(String s, int i) {
		if (debugMessage
				&& !isRelease) debugString[i] = s;
	}

	public static void lDebug(String s) {
		lDebug(s, null, 0, null);
		Debug(s);
	}

	public static void lDebug(String s, int i) {
		lDebug(s, null, i, null);
		Debug(s);
	}

	public static void lDebug(String s, String s1, int i, Throwable throwable) {
		if (debugLogMessage) {
			if (logger != null) ;else {
				File file = new File(mod_Modchu_ModchuLib.modchu_Main.getMinecraftDir(), ("ModchuDebug.log"));
				String s2 = "ModchuDebug";
				if (careerSave) {
					for(int i1 = 0; i1 < 100; i1++) {
						s2 = "ModchuDebug-"+i1;
						file = new File(mod_Modchu_ModchuLib.modchu_Main.getMinecraftDir(), (s2+".log"));
						if (!file.exists()) {
							break;
						}
					}
				}
				logger = Logger.getLogger(s2);
				logger.setLevel(Level.FINE);

				try {
					if (file.exists()) {
						file.delete();
					}
					if (file.createNewFile() && file.canWrite()) {
						FileHandler logHandler = new FileHandler(file.getPath());
						logHandler.setFormatter(new SimpleFormatter());
						logger.addHandler(logHandler);
					}
				} catch (Exception e) {
				}
			}
			writerDebugLog(s, s1, i, throwable);
		}
	}

	public static void dDebugDrow() {
		if (debugString != null) ;else debugString = new String[10];
		for(int i = 0 ;i < debugString.length ;i++){
			if (debugString != null) {
				GuiIngame ingameGUI = (GuiIngame) Modchu_Reflect.getFieldObject("Minecraft", "field_71456_v", "ingameGUI", mod_Modchu_ModchuLib.modchu_Main.getMinecraft());
				ingameGUI.drawString((FontRenderer) Modchu_Reflect.getFieldObject("Minecraft", "field_71466_p", "fontRenderer", mod_Modchu_ModchuLib.modchu_Main.getMinecraft()), debugString[i], 1, 1 + (10 * i), 0xffffff);
			}
		}
		if (!Keyboard.getEventKeyState()
				| Keyboard.getEventKey() != key) {
			key = -1;
		}
		if (
				//key != 200 &&
				Keyboard.isKeyDown(200)) {
			key = 200;
			debaf1 += Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157) ? 1.0F : 0.1F;
		}
		if (
				//key != 208 &&
				Keyboard.isKeyDown(208)) {
			key = 208;
			debaf1 -= Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157) ? 1.0F : 0.1F;
		}
		if (
				//key != 205 &&
				Keyboard.isKeyDown(205)) {
			key = 205;
			debaf2 += Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157) ? 1.0F : 0.1F;
		}
		if (
				//key != 203 &&
				Keyboard.isKeyDown(203)) {
			key = 203;
			debaf2 -= Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157) ? 1.0F : 0.1F;
		}
		if (
				//key != 77 &&
				Keyboard.isKeyDown(77)) {
			key = 77;
			debaf3 += Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157) ? 1.0F : 0.1F;
		}
		if (
				//key != 75 &&
				Keyboard.isKeyDown(75)) {
			key = 75;
			debaf3 -= Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157) ? 1.0F : 0.1F;
		}
		//Modchu_Debug.mDebug(""+Keyboard.getEventKey());
		if (
				//key != 79 &&
				Keyboard.isKeyDown(79)) {
			key = 79;
			debaf4 += Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157) ? 1.0F : 0.1F;
		}
		if (
				//key != 71 &&
				Keyboard.isKeyDown(71)) {
			key = 71;
			debaf4 -= Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157) ? 1.0F : 0.1F;
		}
		if (
				//key != 80 &&
				Keyboard.isKeyDown(80)) {
			key = 80;
			debaf5 += Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157) ? 1.0F : 0.1F;
		}
		if (
				//key != 72 &&
				Keyboard.isKeyDown(72)) {
			key = 72;
			debaf5 -= Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157) ? 1.0F : 0.1F;
		}
		if (
				//key != 81 &&
				Keyboard.isKeyDown(81)) {
			key = 81;
			debaf6 += Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157) ? 1.0F : 0.1F;
		}
		if (
				//key != 73 &&
				Keyboard.isKeyDown(73)) {
			key = 73;
			debaf6 -= Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157) ? 1.0F : 0.1F;
		}
	}

	public String getClassName(String s) {
		if (s == null) return null;
		if (s.indexOf(".") > -1) return s;
		Package pac = getClass().getPackage();
		if (pac != null) s = pac.getName().concat(".").concat(s);
		return s;
	}

	public static void writerDebugLog(String s, String s1, int i, Throwable throwable) {
		if (tempDebugLog.equals(s)) return;
		tempDebugLog = s;
		switch(i) {
		case 0:
			logger.fine(s);
			break;
		case 1:
			logger.warning(s);
			break;
		case 2:
			logger.throwing(s, s1, throwable);
			break;
		}
	}
}
