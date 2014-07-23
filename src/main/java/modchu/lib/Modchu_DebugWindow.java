package modchu.lib;

import modchu.debug.modc_modchuDebug;

public class Modchu_DebugWindow {

	public static void systemOutPrintln(String s) {
		modc_modchuDebug.systemOutPrintln(s);
	}

	public static void systemOutPrintln(String s, byte by) {
		modc_modchuDebug.systemOutPrintln(s, by);
	}

	public static void lineDebugPrintln(String s, int i) {
		modc_modchuDebug.lineDebugPrintln(s, i);
	}

	public static void debugStringClear() {
		modc_modchuDebug.debugStringClear();
	}

}
