package modchu.lib;

public class Modchu_CastHelper {

	public static int Int(Object o) {
		return Int(o, 0);
	}

	public static int Int(Object o, int i) {
		if (o instanceof Boolean) {
			boolean b = (Boolean) o;
			return b ? 2 : 1;
		}
		if (o != null) ;else return i;
		if (o instanceof Integer) {
			return (Integer) o;
		}
		if (Modchu_Main.integerCheck(""+o)) return Integer.valueOf(""+o);
		return i;
	}

	public static byte Byte(Object o) {
		return Byte(o, (byte)0);
	}

	public static byte Byte(Object o, byte by) {
		if (o instanceof Boolean) {
			boolean b = (Boolean) o;
			return (byte) (b ? 2 : 1);
		}
		if (o != null) ;else return by;
		if (o instanceof Byte) {
			return (Byte) o;
		}
		if (Modchu_Main.byteCheck(""+o)) return Byte.valueOf(""+o);
		return by;
	}

	public static float Float(Object o) {
		return Float(o, 0.0F);
	}

	public static float Float(Object o, float f) {
		if (o instanceof Boolean) {
			boolean b = (Boolean) o;
			return b ? 2 : 1;
		}
		if (o != null) ;else return f;
		if (o instanceof Float) {
			return (Float) o;
		}
		if (Modchu_Main.floatCheck(""+o)) return Float.valueOf(""+o);
		return f;
	}

	public static double Double(Object o) {
		return Double(o, 0.0D);
	}

	public static double Double(Object o, double d) {
		if (o instanceof Boolean) {
			boolean b = (Boolean) o;
			return b ? 2 : 1;
		}
		if (o != null) ;else return d;
		if (o instanceof Double) {
			return (Double) o;
		}
		return Double.valueOf(""+o);
	}

	public static boolean Boolean(Object o) {
		if (o instanceof Boolean) {
			return (Boolean) o;
		}
		return false;
	}
}
