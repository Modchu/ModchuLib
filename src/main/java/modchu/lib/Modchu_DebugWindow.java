package modchu.lib;

public class Modchu_DebugWindow {
	public static Modchu_IDebugWindow debugWindow;

	public static void systemOutPrintln(String s) {
		debugWindow.systemOutPrintln(s);
	}

	public static void systemOutPrintln(String s, byte by) {
		debugWindow.systemOutPrintln(s, by);
	}

	public static void lineDebugPrintln(String s, int i) {
		debugWindow.lineDebugPrintln(s, i);
	}

	public static void debugStringClear() {
		debugWindow.debugStringClear();
	}

}
