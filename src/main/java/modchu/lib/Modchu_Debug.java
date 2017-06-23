package modchu.lib;import java.io.BufferedWriter;import java.io.File;import java.util.ArrayList;import java.util.Collections;import java.util.IdentityHashMap;import java.util.LinkedList;import java.util.List;import java.util.Set;import java.util.Map.Entry;import java.util.concurrent.ConcurrentHashMap;import org.lwjgl.input.Keyboard;import org.lwjgl.input.Mouse;import org.lwjgl.opengl.Display;public class Modchu_Debug {	public static boolean debugMessage = true;	public static boolean debugMessagetexture = true;	public static boolean debugCustomModelMessage = false;	public static boolean debugLogMessage = true;	public static boolean debugSystemMessage = false;	public static boolean debugOtherWindowMessage = false;	public static boolean careerSave = false;	public static boolean mDebug = false;	public static boolean addIsRemote = false;	public static boolean setClipLog = false;	public static String[] debugString;	public static int[] debugTime;	private static final int maxDebugString = 15;	public static float debaf1 = 0.0F;	public static float debaf2 = 0.0F;	public static float debaf3 = 0.0F;	public static float debaf4 = 0.0F;	public static float debaf5 = 0.0F;	public static float debaf6 = 0.0F;	private static int key;	private static BufferedWriter debugLogBwriter;	private static String tempDebugLog = "";	public static String debugPlayerName;	private static int systemDebugCount = 0;	private static int careerSaveNumber = -1;	public static ArrayList<String> debugStringList;	public static ArrayList<String> debugLogList;	public static ArrayList<String> clipboardLog;	private static int renderColor = 0xffffff;	private static LinkedList<String> logList;	private static File modchuDebugFile;	private static ConcurrentHashMap<String, Object> freeVariableMap;	private static ConcurrentHashMap<String, List> debugListStringMap;	private static boolean tempIsShiftKeyDown;	private static boolean writerClipboardLogFlag;	public static void Debug(String s) {		Debug(false, s);	}	public static void Debug(boolean b, String s) {		if (debugMessage) {			if (debugFlag(b, s)) systemOutPrintln(new StringBuilder().append("Modchu_Debug-").append(s).toString());		}	}	public static void Debug1(String s, Object... pVals) {		Debug(true, s, pVals);	}	public static void Debug(String s, Object... pVals) {		Debug(false, s, pVals);	}	public static void Debug(boolean b, String s, Object... pVals) {		if (debugMessage) {			if (debugFlag(b, s)) {				if (Modchu_Main.getMinecraftVersion() == 162) lDebug(s, 0, null);				String s1 = "Modchu_Debug-"+s;				systemOutPrintln(pVals != null						&& pVals.length > 0 ? String.format(s1, pVals) : s1);			}		}	}	public static void mDebug1(String s) {		mDebug(true, s);	}	public static void mDebug1(String s, int i) {		mDebug(true, s);	}	public static void mDebug(String s) {		mDebug(false, s);	}	public static void mDebug(String s, int i) {		mDebug(false, s);	}	public static void mDebug(boolean b, String s) {		if (Modchu_Main.isRelease				&& !mDebug) return;		if (debugFlag(b, s)) {			if (Modchu_Main.getMinecraftVersion() == 162) lDebug(s);			else {				s = new StringBuilder().append("Modchu_mDebug_").append(s).toString();				systemOutPrintln(s);			}		}	}	public static void mDebugObjectArray(String s, Object[] o, String s1) {		if (o != null				&& o.length > 0); else return;		mDebug(s);		int i = 0;		for (Object o1 : o) {			mDebug(""+i+" : "+o1);			i++;		}		mDebug(s1);	}	public static void DebugObjectArray(String s, Object[] o, String s1) {		if (o != null				&& o.length > 0); else return;		Debug(s);		int i = 0;		for (Object o1 : o) {			Debug(""+i+" : "+o1);			i++;		}		Debug(s1);	}	public static boolean debugFlag(boolean b, String s) {		if (b) {			if (debugStringList != null); else debugStringList = new ArrayList();		}		if (debugMessage				&& (!b					| (b					&& !debugStringList.contains(s)))) {			if (b) debugStringList.add(s);			return true;		}		return false;	}	private static boolean debugLogFlag(boolean b, String s) {		if (b) {			if (debugLogList != null); else debugLogList = new ArrayList();		}		if (debugMessage				&& (!b					| (b					&& !debugLogList.contains(s)))) {			if (b) debugLogList.add(s);			return true;		}		return false;	}	public static void mlDebug1(String s) {		mDebug1(s);		lDebug1(s, 0, null);	}	public static void mlDebug(String s) {		mDebug(s);		lDebug(s, 0, null);	}	public static void mmlDebug(String s) {		mDebug(s);		if (Modchu_Main.isRelease				&& !mDebug) return;		lDebug(s, 0, null);	}	public static void tDebug1(String s) {		tDebug(s, true);	}	public static void tDebug(String s) {		tDebug(s, false);	}	public static void tDebug(String s, boolean b) {		if (debugMessagetexture) {			s = new StringBuilder().append("Modchu_tDebug_").append(s).toString();			if (b) {				if (debugMessage						&& debugFlag(b, s)) {					if (!debugLogFlag(b, s)						| tempDebugLog.equals(s)); else {						tempDebugLog = s;						systemOutPrintln(s);					}				}				lDebug1(s, 0, null);			} else {				lDebug(s);			}		}	}	public static void tDebug(String s, Object... o) {		if (debugMessagetexture) {			s = String.format("Modchu_tDebug_" + s, o);			systemOutPrintln(s);			lDebug(s, 0, null);		}	}	public static void cDebug(String s) {		if (debugCustomModelMessage) {			s = new StringBuilder().append("Modchu_cDebug_").append(s).toString();			systemOutPrintln(s);			lDebug(s, 0, null);		}	}	private static void systemOutPrintln(String s) {		systemOutPrintln(s, setClipLog);	}	private static void systemOutPrintln(String s, boolean setClipLog) {		if (addIsRemote) s = new StringBuilder().append("isRemote=").append(Modchu_AS.getBoolean(Modchu_AS.worldIsRemote)).append(" ").append(s).toString();		if (!debugOtherWindowMessage) System.out.println(s);		else Modchu_DebugWindow.systemOutPrintln(s);		//System.out.println("Modchu_Debug_systemOutPrintln setClipLog setClipLog="+setClipLog);		if (setClipLog) {			//System.out.println("Modchu_Debug_systemOutPrintln setClipLog addCheckList(s)="+addCheckList(s));			if (addCheckList(s)) {				addClipboardLog(s);			}		}	}	private static void addClipboardLog(String s) {		if (clipboardLog != null); else clipboardLog = new ArrayList();		if (clipboardLog.size() < 2000) clipboardLog.add(s);	}	public static void setClipboardLog() {		//System.out.println("Modchu_Debug setClipboardLog() clipboardLog="+clipboardLog);		if (clipboardLog != null				&& !clipboardLog.isEmpty()); else return;		//System.out.println("Modchu_Debug setClipboardLog() clipboardLog.size()="+clipboardLog.size());		if (clipboardLog.size() > 1999) {			if (!writerClipboardLogFlag) {				String s2 = "ModchuDebug_ClipboardLog";				File file = new File(Modchu_AS.getFile(Modchu_AS.minecraftMcDataDir), (s2+".log"));				Modchu_Config.writerConfig(file, clipboardLog);				Modchu_ClipboardManager.setClipboard(file.getAbsolutePath());				writerClipboardLogFlag = true;			}			return;		}		StringBuilder sd = new StringBuilder();		for (String s : clipboardLog) {			sd.append(s).append("\n");		}		Modchu_ClipboardManager.setClipboard(sd.toString());		//System.out.println("Modchu_Debug setClipboardLog() end.");	}	public static void dDebug(String s) {		if (s != null				&& !s.isEmpty()) dDebug(s, 0);		else debugStringClear();	}	public static void mdDebug(String s) {		mdDebug(s, 0);	}	public static void dDebug(String s, int i) {		dDebug(s, i, -1);	}	public static void dDebug(String s, int i, int i2) {		if (i < 0				| i >= maxDebugString) return;		if (debugMessage) {			if (!debugOtherWindowMessage) {				if (debugString != null); else debugString = new String[maxDebugString];				if (debugTime != null); else debugTime = new int[maxDebugString];				debugString[i] = s;				debugTime[i] = i2;				//mDebug("Modchu_Debug dDebug s="+s);			} else {				Modchu_DebugWindow.lineDebugPrintln(s, i);			}		}	}	public static void debugStringClear() {		if (debugMessage) {			if (!debugOtherWindowMessage) debugString = new String[maxDebugString];			else Modchu_DebugWindow.debugStringClear();		}	}	public static void mdDebug(String s, int i) {		if (Modchu_Main.isRelease				&& !mDebug) return;		dDebug(s, i);	}	public static void lDebug1(String s) {		lDebug1(s, 0, null);		Debug1(s);	}	public static void lDebug(String s) {		lDebug(s, 0, null);		Debug(s);	}	public static void lDebug(String s, int i) {		lDebug(s, i, null);		Debug(s);	}	public static void systemDebug(String s, int i) {		systemDebug(s, i, 0);	}	public static void systemDebug(String s, int i, int i2) {		if (!debugSystemMessage) return;		s = "systemDebug " + i +";" + s;		if (i < 999				&& systemDebugCount + 1 == i) {			systemDebugCount = i;			lDebug(s, i2, null);		} else {			Modchu_Main.setRuntimeException("Modchu_Debug systemDebug error !! error Number="+i+" systemDebugCount="+systemDebugCount);			lDebug(s, 1, null);		}		Debug(s);	}	public static void systemLogDebug(String s) {		systemLogDebug(s, null);	}	public static void systemLogDebug(String s, Throwable throwable) {		systemLogDebug(s, 0, throwable);	}	public static void systemLogDebug(String s, int i, Throwable throwable) {		if (!debugSystemMessage				&& Modchu_Main.initLoadcfg) {			//Modchu_Debug.mDebug("debugSystemMessage="+debugSystemMessage+" Modchu_Main.initLoadcfg="+Modchu_Main.initLoadcfg+" "+s);			return;		}		s = "system : " + s;		mDebug(s);		lDebug(false, s, i, throwable);	}	public static void lDebug1(String s, int i, Throwable throwable) {		lDebug(true, s, i, throwable);	}	public static void lDebug(String s, int i, Throwable throwable) {		lDebug(false, s, i, throwable);	}	public static void lDebug(boolean b, String s, int i, Throwable throwable) {		if (!debugLogMessage				&& Modchu_Main.initLoadcfg) {			//s = "debugSystemMessage="+debugSystemMessage+" Modchu_Main.initLoadcfg="+Modchu_Main.initLoadcfg+" "+s;			logList = null;			return;		}		if (logList != null); else logList = new LinkedList();		writerDebugLog(b, s, i, throwable);	}	public static void writerDebugLog(boolean b, String s, int i, Throwable throwable) {		if (!debugLogFlag(b, s)				| tempDebugLog.equals(s)) return;		tempDebugLog = s;		switch(i) {		case 0:			// fine			break;		case 1:			// warning			s = "warning : " + s;			break;		case 2:			// throwing			if (throwable != null) {				logList.add(throwable.toString());				Set<Throwable> dejaVu = Collections.newSetFromMap(new IdentityHashMap<Throwable, Boolean>());				//dejaVu.add(throwable);				StackTraceElement[] trace = (StackTraceElement[]) Modchu_Reflect.invokeMethod(throwable.getClass(), "getOurStackTrace", throwable);				for (StackTraceElement traceElement : trace) {					logList.add("\tat " + traceElement);				}				if (Modchu_Main.getMinecraftVersion() > 159) {					Object o = Modchu_Reflect.invokeMethod(Throwable.class, "getSuppressed", throwable);					Throwable[] suppressed = o != null							&& o instanceof Throwable[] ? (Throwable[]) o : null;					if (suppressed != null) {						for (Throwable se : suppressed)							printEnclosedStackTrace(se, trace, "Suppressed: ", "\t", dejaVu);					}				}				Throwable ourCause = throwable.getCause();				if (ourCause != null)					printEnclosedStackTrace(ourCause, trace, "Caused by: ", "", dejaVu);			}			s = "throwing : " + s;			break;		}		if (s != null				&& !s.isEmpty()); else return;		logList.add(s);		if (!Modchu_Main.initLoadcfg) {			//Debug("Modchu_Debug writerDebugLog !Modchu_Main.initLoadcfg return.");			return;		}		String s2 = "ModchuDebug";		if (modchuDebugFile != null); else {			if (careerSave) {				if (careerSaveNumber > -1) {					s2 = "ModchuDebug-"+careerSaveNumber;					modchuDebugFile = new File(Modchu_AS.getFile(Modchu_AS.minecraftMcDataDir), (s2+".log"));					if (modchuDebugFile != null							&& !modchuDebugFile.exists()); else {						Debug1("writerDebugLog file == null error !! s2="+s2);						return;					}				} else {					for(int i1 = 0; i1 < 100; i1++) {						s2 = "ModchuDebug-"+i1;						modchuDebugFile = new File(Modchu_AS.getFile(Modchu_AS.minecraftMcDataDir), (s2+".log"));						if ((modchuDebugFile != null								&& !modchuDebugFile.exists())								| modchuDebugFile == null) {							careerSaveNumber = i1;							break;						}					}				}			} else {				modchuDebugFile = new File(Modchu_AS.getFile(Modchu_AS.minecraftMcDataDir), (s2+".log"));			}		}		Modchu_Config.writerConfig(modchuDebugFile, logList);	}	private static void printEnclosedStackTrace(Throwable throwable, StackTraceElement[] enclosingTrace, String caption, String prefix, Set<Throwable> dejaVu) {		if (dejaVu.contains(throwable)) {			logList.add("\t[CIRCULAR REFERENCE:" + throwable + "]");		} else {			dejaVu.add(throwable);			StackTraceElement[] trace = (StackTraceElement[]) Modchu_Reflect.invokeMethod(throwable.getClass(), "getOurStackTrace", throwable);			int m = trace.length - 1;			int n = enclosingTrace.length - 1;			while (m >= 0 && n >= 0 && trace[m].equals(enclosingTrace[n])) {				m--;				n--;			}			int framesInCommon = trace.length - 1 - m;			logList.add(prefix + caption + throwable);			for (int i = 0; i <= m; i++)				logList.add(prefix + "\tat " + trace[i]);			if (framesInCommon != 0) logList.add(prefix + "\t... " + framesInCommon + " more");			if (Modchu_Main.getMinecraftVersion() > 159) {				Throwable[] suppressed = (Throwable[]) Modchu_Reflect.invokeMethod(Throwable.class, "getSuppressed", throwable);				for (Throwable se : suppressed)				printEnclosedStackTrace(se, trace, "Suppressed: ", prefix + "\t", dejaVu);			}			Throwable ourCause = throwable.getCause();			if (ourCause != null) printEnclosedStackTrace(ourCause, trace, "Caused by: ", prefix, dejaVu);		}	}	public static void dDebugDrow() {		if (!debugOtherWindowMessage) {			if (debugString != null); else debugString = new String[maxDebugString];			if (debugString != null) {				for (int i = 0 ;i < debugString.length ;i++) {					if (debugString[i] != null							&& (debugTime[i] < 0									| debugTime[i] > 0)) {						Modchu_AS.set(Modchu_AS.guiIngameDrawString, new Object[]{ debugString[i], 1, 1 + (10 * i), renderColor });						if (debugTime[i] > 0) debugTime[i]--;					}				}			}		}		if (!Keyboard.isCreated()) return;		Class PFLM_Main = Modchu_Reflect.loadClass("modchu.pflm.PFLM_Main", -1);		boolean isPFLMModelsKeyDown = PFLM_Main != null ? Modchu_CastHelper.Boolean(Modchu_Reflect.invokeMethod(PFLM_Main, "isPFLMModelsKeyDown")) : false;		boolean isCtrlKeyDown = Modchu_AS.getBoolean(Modchu_AS.isCtrlKeyDown);		boolean isAltKeyDown = Keyboard.isKeyDown(184);		boolean isShiftKeyDown = Modchu_AS.getBoolean(Modchu_AS.isShiftKeyDown);		if (isPFLMModelsKeyDown				&& isAltKeyDown) {			if (Mouse.isButtonDown(0)) {				if (isCtrlKeyDown) debaf4 = 0.0F;				else debaf1 = 0.0F;			}			if (Mouse.isButtonDown(1)) {				if (isCtrlKeyDown) debaf5 = 0.0F;				else debaf2 = 0.0F;			}			if (Mouse.isButtonDown(2)) {				if (isCtrlKeyDown) debaf6 = 0.0F;				else debaf3 = 0.0F;			}		}		if (!Keyboard.getEventKeyState()				| Keyboard.getEventKey() != key) {			key = -1;		}		float f = isCtrlKeyDown ? isPFLMModelsKeyDown ? 0.001F : 1.0F :			isPFLMModelsKeyDown ? 0.01F : 0.1F;		if (Keyboard.isKeyDown(200)) {			key = 200;			if (!tempIsShiftKeyDown) debaf1 += f;			else debaf5 += f;		}		if (Keyboard.isKeyDown(208)) {			key = 208;			if (!tempIsShiftKeyDown) debaf1 -= f;			else debaf5 -= f;		}		if (Keyboard.isKeyDown(205)) {			key = 205;			if (!tempIsShiftKeyDown) debaf2 += f;			else debaf3 += f;		}		if (Keyboard.isKeyDown(203)) {			key = 203;			if (!tempIsShiftKeyDown) debaf2 -= f;			else debaf3 -= f;		}		if (Keyboard.isKeyDown(77)) {			key = 77;			debaf3 += f;		}		if (Keyboard.isKeyDown(75)) {			key = 75;			debaf3 -= f;		}		//Modchu_Debug.mDebug(""+Keyboard.getEventKey());		if (Keyboard.isKeyDown(79)) {			key = 79;			debaf4 += f;		}		if (Keyboard.isKeyDown(71)) {			key = 71;			debaf4 -= f;		}		if (Keyboard.isKeyDown(80)) {			key = 80;			debaf5 += f;		}		if (Keyboard.isKeyDown(72)) {			key = 72;			debaf5 -= f;		}		if (Keyboard.isKeyDown(81)) {			key = 81;			debaf6 += f;		}		if (Keyboard.isKeyDown(73)) {			key = 73;			debaf6 -= f;		}		if (isShiftKeyDown) tempIsShiftKeyDown = true;		if (tempIsShiftKeyDown				&& (isAltKeyDown						| Keyboard.isKeyDown(79)						| Keyboard.isKeyDown(71)						| Keyboard.isKeyDown(80)						| Keyboard.isKeyDown(72)						| Keyboard.isKeyDown(81)						| Keyboard.isKeyDown(73))) tempIsShiftKeyDown = false;	}	public String getClassName(String s) {		if (s == null) return null;		if (s.indexOf(".") > -1) return s;		Package pac = getClass().getPackage();		if (pac != null) s = pac.getName().concat(".").concat(s);		return s;	}/*	public static String getDebugArrayString(String s, Object[] o) {		StringBuilder sd = new StringBuilder();		for(int i = 0; i < o.length; i++) {			String s1 = o[i] instanceof Object[] ?					new StringBuilder().append("[").append(getDebugArrayString("", (Object[]) o[i])).append("]").toString() :						o[i] instanceof List ? Modchu_Main.listToString((List) o[i]) :							o[i].toString();			sd.append(s).append("[").append(i).append("]=").append(s1).append(" ");		}		return sd.toString();	}*/	public static void debafNormalise(float min, float max) {		debafNormalise(min, max, false);	}	public static void debafNormalise(float min, float max, boolean b) {		debaf1 = Modchu_Main.floatNormalise(debaf1, min, max, b);		debaf2 = Modchu_Main.floatNormalise(debaf2, min, max, b);		debaf3 = Modchu_Main.floatNormalise(debaf3, min, max, b);		debaf4 = Modchu_Main.floatNormalise(debaf4, min, max, b);		debaf5 = Modchu_Main.floatNormalise(debaf5, min, max, b);		debaf6 = Modchu_Main.floatNormalise(debaf6, min, max, b);	}	public static int getRenderColor() {		return renderColor;	}	public static void resetRenderColor() {		setRenderColor(0xffffff);	}	public static void setRenderColor(int i) {		renderColor = i;	}	public static void debugKeyPush() {		debugKeyPush(Keyboard.KEY_SPACE, true);	}	public static void debugKeyPush(int keyCode) {		debugKeyPush(keyCode, true);	}	public static void debugKeyPush(boolean waitFlag) {		debugKeyPush(Keyboard.KEY_SPACE, waitFlag);	}	public static void debugKeyPush(int keyCode, boolean waitFlag) {		debugTitle("Modchu_Debug debugKeyPush "+keyCode);		boolean onFlag = false;		boolean offFlag = false;		while (!onFlag) {			//mDebug("debugKeyPush getEventKey()="+Keyboard.getEventKey());			if (!offFlag					&& !Keyboard.isKeyDown(keyCode)) {				offFlag = true;			}			if (offFlag					&& Keyboard.isKeyDown(keyCode)) {				onFlag = true;			}			Display.update();			if (waitFlag) {				try {					Thread.sleep(1L);				} catch (InterruptedException e) {				}			}		}		resetTitle();	}	public static void debugMousePush() {		debugMousePush(0, true);	}	public static void debugMousePush(int buttomCode) {		debugMousePush(buttomCode, true);	}	public static void debugMousePush(boolean waitFlag) {		debugMousePush(0, waitFlag);	}	public static void debugMousePush(int buttomCode, boolean waitFlag) {		debugTitle("Modchu_Debug debugMousePush "+buttomCode);		boolean onFlag = false;		boolean offFlag = false;		while (!onFlag) {			if (!offFlag					&& !Mouse.isButtonDown(buttomCode)) {				offFlag = true;			}			if (offFlag					&& Mouse.isButtonDown(buttomCode)) {				onFlag = true;			}			//Display.update();			if (waitFlag) {				try {					Thread.sleep(1L);				} catch (InterruptedException e) {				}			}		}		resetTitle();	}	public static void resetTitle() {		Display.setTitle(new StringBuilder().append("Minecraft").append(Modchu_Version.getMinecraftVersionString()).toString());	}	public static void debugTitle(String s) {		Display.setTitle(new StringBuilder().append("Minecraft").append(Modchu_Version.getMinecraftVersionString()).append(" ").append(s).toString());	}	public static String calledAt() {		return calledAt(2);	}	public static String calledAt(int i) {		// このメソッドを呼び出したメソッド名、ファイル名、行数の情報を取得		StackTraceElement ste = Thread.currentThread().getStackTrace() != null				&& Thread.currentThread().getStackTrace().length > i ? Thread.currentThread().getStackTrace()[i] : null;		if (ste != null); else return null;		StringBuilder sb = new StringBuilder();		sb.append(ste.getMethodName())		.append("(")		.append(ste.getFileName())		.append(":")		.append(ste.getLineNumber())		.append(")");		return sb.toString();	}	public static void mCalledFrom() {		calledFrom(0);	}	public static void calledFrom() {		calledFrom(1);	}	public static void lCalledFrom() {		calledFrom(2);	}	public static void calledFrom(int i) {		LinkedList<String> list = getCalledFromList();		if (list != null				&& !list.isEmpty()); else return;		for (String s : list) {			switch(i) {			case 0:				if (Modchu_Main.isRelease						&& !mDebug) return;				if (debugFlag(false, s)) {					systemOutPrintln(s);				}				break;			case 1:				if (debugFlag(false, s)) {					systemOutPrintln(s);				}				break;			case 2:				lDebug(s, 0, null);				if (debugFlag(false, s)) {					systemOutPrintln(s);				}				break;			}		}	}	public static LinkedList<String> getCalledFromList() {		// このメソッドを呼び出したメソッドの呼び出し元のメソッド名、ファイル名、行数の情報をすべて取得し、LinkedListで返す		LinkedList list = new LinkedList();		StackTraceElement[] steArray = Thread.currentThread().getStackTrace();		if (steArray != null				&& steArray.length > 0); else {			return null;		}		StringBuilder sb = new StringBuilder();		for (StackTraceElement ste : steArray) {			sb.append(ste.getMethodName());			list.add(sb.toString());			sb.delete(0, sb.length());			sb.append("(")			.append(ste.getFileName())			.append(":")			.append(ste.getLineNumber())			.append(")")			.append("(")			.append(ste.getClassName())			.append(")");			list.add(sb.toString());			sb.delete(0, sb.length());		}		return list;	}	public static Object getFreeVariable(String s) {		return freeVariableMap != null				&& freeVariableMap.containsKey(s) ? freeVariableMap.get(s) : null;	}	public static void setFreeVariable(String s, Object o) {		if (freeVariableMap != null); else freeVariableMap = new ConcurrentHashMap();		if (o != null) freeVariableMap.put(s, o);		else if (freeVariableMap.containsKey(s)) freeVariableMap.remove(s);	}	public static void registerListString(String s) {		if (debugListStringMap != null); else debugListStringMap = new ConcurrentHashMap();		if (!debugListStringMap.containsKey(s)) {			List list = new LinkedList();			debugListStringMap.put(s, list);		}	}	public static void unRegisterListString(String s) {		if (debugListStringMap != null); else return;		if (debugListStringMap.containsKey(s)) {			debugListStringMap.remove(s);		}	}	public static void clearList(String s) {		if (debugListStringMap != null); else return;		if (debugListStringMap.containsKey(s)) {			List list = debugListStringMap.get(s);			list.clear();		}	}	public static void allClearList() {		if (debugListStringMap != null); else return;		debugListStringMap.clear();	}	public static boolean isDebugListFlag() {		return debugListStringMap != null;	}	public static List getDebugList(String s) {		return debugListStringMap.containsKey(s) ? debugListStringMap.get(s) : null;	}	public static List checkListString(String s) {		return (List) checkListString(s, true);	}	public static Object checkListString(String s, boolean b) {		if (!isDebugListFlag()) return null;		for (Entry<String, List> en : debugListStringMap.entrySet()) {			String s1 = en.getKey();			if (s != null					&& s.indexOf(s1) > -1) {				if (b) {					List list = en.getValue();					return list;				} else {					return s1;				}			}		}		return null;	}	public static void writerList(String s) {		List list = checkListString(s);		if (list != null) {			String s1 = "ModchuDebug-"+checkListString(s, false);			File file = new File(Modchu_AS.getFile(Modchu_AS.minecraftMcDataDir), (s1+".log"));			Modchu_Config.writerConfig(file, list);		}	}	private static boolean addCheckList(String s) {		List list = checkListString(s);		if (list != null) {			list.add(s);			return true;		}		return false;	}}