package modchu.lib;import java.io.BufferedWriter;import java.io.File;import java.util.ArrayList;import java.util.logging.FileHandler;import java.util.logging.Level;import java.util.logging.Logger;import java.util.logging.SimpleFormatter;import modchu.lib.characteristic.Modchu_AS;import org.lwjgl.input.Keyboard;import org.lwjgl.input.Mouse;public class Modchu_Debug {	public static boolean debugMessage = true;	public static boolean debugMessagetexture = true;	public static boolean debugCustomModelMessage = false;	public static boolean debugLogMessage = false;	public static boolean debugSystemMessage = false;	public static boolean careerSave = false;	public static boolean mDebug = false;	public static String[] debugString;	public static int[] debugTime;	public static float debaf1 = 0.0F;	public static float debaf2 = 0.0F;	public static float debaf3 = 0.0F;	public static float debaf4 = 0.0F;	public static float debaf5 = 0.0F;	public static float debaf6 = 0.0F;	private static int key;	private static BufferedWriter debugLogBwriter;    private static Logger logger;	private static String tempDebugLog = "";	public static String debugPlayerName;	private static int systemDebugCount = 0;	public static ArrayList<String> debugStringList;	public static ArrayList<String> debugLogList;	public static void Debug(String s) {		Debug(false, s);	}	public static void Debug(boolean b, String s) {		if (debugMessage) {			if (debugFlag(b, s)) System.out.println((new StringBuilder()).append("Modchu_Debug-").append(s).toString());		}	}	public static void Debug1(String s, Object... pVals) {		Debug(true, s, pVals);	}	public static void Debug(String s, Object... pVals) {		Debug(false, s, pVals);	}	public static void Debug(boolean b, String s, Object... pVals) {		if (debugMessage) {			if (debugFlag(b, s)) System.out.println(String.format("Modchu_Debug-" + s, pVals));		}	}	public static void mDebug1(String s) {		mDebug(true, s);	}	public static void mDebug1(String s, int i) {		mDebug(true, s);	}	public static void mDebug(String s) {		mDebug(false, s);	}	public static void mDebug(String s, int i) {		mDebug(false, s);	}	public static void mDebug(boolean b, String s) {		if (Modchu_Main.isRelease				&& !mDebug) return;		if (debugFlag(b, s)) System.out.println((new StringBuilder()).append("Modchu_mDebug_").append(s).toString());	}	private static boolean debugFlag(boolean b, String s) {		if (b) {			if (debugStringList != null) ;else debugStringList = new ArrayList();		}		if (debugMessage				&& (!b					| (b					&& !debugStringList.contains(s)))) {			if (b) debugStringList.add(s);			return true;		}		return false;	}	private static boolean debugLogFlag(boolean b, String s) {		if (b) {			if (debugLogList != null) ;else debugLogList = new ArrayList();		}		if (debugMessage				&& (!b					| (b					&& !debugLogList.contains(s)))) {			if (b) debugLogList.add(s);			return true;		}		return false;	}	public static void mlDebug1(String s) {		mDebug1(s);		lDebug1(s, null, 0, null);	}	public static void mlDebug(String s) {		mDebug(s);		lDebug(s, null, 0, null);	}	public static void mmlDebug(String s) {		mDebug(s);		if (Modchu_Main.isRelease				&& !mDebug) return;		lDebug(s, null, 0, null);	}	public static void tDebug(String s) {		if (debugMessagetexture) System.out.println((new StringBuilder()).append("Modchu_tDebug_").append(s).toString());	}	public static void tDebug(String s, Object... o) {		if (debugMessagetexture) System.out.println(String.format("Modchu_tDebug_" + s, o));	}	public static void cDebug(String s) {		if (debugCustomModelMessage) System.out.println((new StringBuilder()).append("Modchu_cDebug_").append(s).toString());	}	public static void dDebug(String s) {		if (s != null				&& !s.isEmpty()) dDebug(s, 0);		else debugStringClear();	}	public static void mdDebug(String s) {		mdDebug(s, 0);	}	public static void dDebug(String s, int i) {		dDebug(s, i, -1);	}	public static void dDebug(String s, int i, int i2) {		if (debugMessage) {			if (debugString != null) ;else debugString = new String[10];			if (debugTime != null) ;else debugTime = new int[10];			debugString[i] = s;			debugTime[i] = i2;		}	}	public static void debugStringClear() {		if (debugMessage) {			debugString = new String[10];		}	}	public static void mdDebug(String s, int i) {		if (Modchu_Main.isRelease				&& !mDebug) return;		dDebug(s, i);	}	public static void lDebug1(String s) {		lDebug1(s, null, 0, null);		Debug1(s);	}	public static void lDebug(String s) {		lDebug(s, null, 0, null);		Debug(s);	}	public static void lDebug(String s, int i) {		lDebug(s, null, i, null);		Debug(s);	}	public static void systemDebug(String s, int i) {		systemDebug(s, i, 0);	}	public static void systemDebug(String s, int i, int i2) {		if (!debugSystemMessage) return;		s = "systemDebug " + i +";" + s;		if (i < 999				&& systemDebugCount + 1 == i) {			systemDebugCount = i;			lDebug(s, null, i2, null);		} else {			Modchu_Main.runtimeExceptionFlag = true;			Modchu_Main.runtimeExceptionString = "Modchu_Debug systemDebug error !! error Number="+i;			lDebug(s, null, 1, null);		}		Debug(s);	}	public static void lDebug1(String s, String s1, int i, Throwable throwable) {		lDebug(true, s, s1, i, throwable);	}	public static void lDebug(String s, String s1, int i, Throwable throwable) {		lDebug(false, s, s1, i, throwable);	}	public static void lDebug(boolean b, String s, String s1, int i, Throwable throwable) {		if (debugLogMessage) {			if (logger != null) ;else {				File file = new File(Modchu_AS.getFile(Modchu_AS.minecraftMcDataDir), ("ModchuDebug.log"));				String s2 = "ModchuDebug";				if (careerSave) {					for(int i1 = 0; i1 < 100; i1++) {						s2 = "ModchuDebug-"+i1;						file = new File(Modchu_AS.getFile(Modchu_AS.minecraftMcDataDir), (s2+".log"));						if (!file.exists()) {							break;						}					}				}				logger = Logger.getLogger(s2);				logger.setLevel(Level.FINE);				try {					if (file.exists()) {						file.delete();					}					if (file.createNewFile() && file.canWrite()) {						FileHandler logHandler = new FileHandler(file.getPath());						logHandler.setFormatter(new SimpleFormatter());						logger.addHandler(logHandler);					}				} catch (Exception e) {				}			}			writerDebugLog(b, s, s1, i, throwable);		}	}	public static void dDebugDrow() {		if (debugString != null) ;else debugString = new String[10];		boolean isPFLMModelsKeyDown = Modchu_CastHelperBase.Boolean(Modchu_Reflect.invokeMethod("modchu.pflm.PFLM_Main", "isPFLMModelsKeyDown"));		if (debugString != null) {			for(int i = 0 ;i < debugString.length ;i++){				if (debugString[i] != null						&& (debugTime[i] < 0						| debugTime[i] > 0)) {					Modchu_AS.set(Modchu_AS.guiIngameDrawString, debugString[i], 1, 1 + (10 * i), 0xffffff);					debugTime[i]--;				}			}		}		if (isPFLMModelsKeyDown) {			if (Mouse.isButtonDown(0)) debaf1 = 0.0F;			if (Mouse.isButtonDown(1)) debaf2 = 0.0F;			if (Mouse.isButtonDown(2)) debaf3 = 0.0F;		}		if (!Keyboard.getEventKeyState()				| Keyboard.getEventKey() != key) {			key = -1;		}		float f = Modchu_AS.getBoolean(Modchu_AS.isCtrlKeyDown) ? isPFLMModelsKeyDown ? 0.001F : 1.0F :			isPFLMModelsKeyDown ? 0.01F : 0.1F;		if (				//key != 200 &&				Keyboard.isKeyDown(200)) {			key = 200;			debaf1 += f;		}		if (				//key != 208 &&				Keyboard.isKeyDown(208)) {			key = 208;			debaf1 -= f;		}		if (				//key != 205 &&				Keyboard.isKeyDown(205)) {			key = 205;			debaf2 += f;		}		if (				//key != 203 &&				Keyboard.isKeyDown(203)) {			key = 203;			debaf2 -= f;		}		if (				//key != 77 &&				Keyboard.isKeyDown(77)) {			key = 77;			debaf3 += f;		}		if (				//key != 75 &&				Keyboard.isKeyDown(75)) {			key = 75;			debaf3 -= f;		}		//Modchu_Debug.mDebug(""+Keyboard.getEventKey());		if (				//key != 79 &&				Keyboard.isKeyDown(79)) {			key = 79;			debaf4 += f;		}		if (				//key != 71 &&				Keyboard.isKeyDown(71)) {			key = 71;			debaf4 -= f;		}		if (				//key != 80 &&				Keyboard.isKeyDown(80)) {			key = 80;			debaf5 += f;		}		if (				//key != 72 &&				Keyboard.isKeyDown(72)) {			key = 72;			debaf5 -= f;		}		if (				//key != 81 &&				Keyboard.isKeyDown(81)) {			key = 81;			debaf6 += f;		}		if (				//key != 73 &&				Keyboard.isKeyDown(73)) {			key = 73;			debaf6 -= f;		}	}	public String getClassName(String s) {		if (s == null) return null;		if (s.indexOf(".") > -1) return s;		Package pac = getClass().getPackage();		if (pac != null) s = pac.getName().concat(".").concat(s);		return s;	}	public static void writerDebugLog1(String s, String s1, int i, Throwable throwable) {		writerDebugLog(true, s, s1, i, throwable);	}	public static void writerDebugLog(String s, String s1, int i, Throwable throwable) {		writerDebugLog(false, s, s1, i, throwable);	}	public static void writerDebugLog(boolean b, String s, String s1, int i, Throwable throwable) {		if (!debugLogFlag(b, s)				| tempDebugLog.equals(s)) return;		tempDebugLog = s;		switch(i) {		case 0:			logger.fine(s);			break;		case 1:			logger.warning(s);			break;		case 2:			logger.throwing(s, s1, throwable);			break;		}	}	public static String getDebugArrayString(String s, int[] i0) {		String s1 = "";		for(int i = 0; i < i0.length; i++) {			s1 += s+"["+i+"]="+i0[i]+" ";		}		return s1;	}	public static String getDebugArrayString(String s, float[] f) {		String s1 = "";		for(int i = 0; i < f.length; i++) {			s1 += s+"["+i+"]="+f[i]+" ";		}		return s1;	}	public static String getDebugArrayString(String s, double[] d) {		String s1 = "";		for(int i = 0; i < d.length; i++) {			s1 += s+"["+i+"]="+d[i]+" ";		}		return s1;	}	public static String getDebugArrayString(String s, Object[] o) {		String s1 = "";		for(int i = 0; i < o.length; i++) {			s1 += s+"["+i+"]="+o[i]+" ";		}		return s1;	}	public static void debafNormalise(float min, float max) {		debafNormalise(min, max, false);	}	public static void debafNormalise(float min, float max, boolean b) {		debaf1 = Modchu_Main.floatNormalise(debaf1, min, max, b);		debaf2 = Modchu_Main.floatNormalise(debaf2, min, max, b);		debaf3 = Modchu_Main.floatNormalise(debaf3, min, max, b);		debaf4 = Modchu_Main.floatNormalise(debaf4, min, max, b);		debaf5 = Modchu_Main.floatNormalise(debaf5, min, max, b);		debaf6 = Modchu_Main.floatNormalise(debaf6, min, max, b);	}}