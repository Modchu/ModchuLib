package modchu.lib;

import java.io.File;
import java.io.InputStream;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Modchu_CastHelperBase {

	public static String String(Object o) {
		return o != null 
				&& o instanceof String ? (String) o : o != null ? o.toString() : null;
	}

	public static int Int(Object o) {
		return Int(o, 0);
	}

	public static int Int(Object o, int i) {
		if (o != null) ;else return i;
		if (o instanceof Boolean) {
			boolean b = (Boolean) o;
			return b ? 2 : 1;
		}
		if (o instanceof Integer) return (Integer) o;
		if (Modchu_Main.integerCheck(""+o)) return Integer.valueOf(""+o);
		return i;
	}

	public static short Short(Object o) {
		return Short(o, (short) 0);
	}

	public static short Short(Object o, short sh) {
		if (o != null) ;else return sh;
		if (o instanceof Boolean) {
			boolean b = (Boolean) o;
			return (short) (b ? 2 : 1);
		}
		if (o instanceof Short) return (Short) o;
		if (Modchu_Main.shortCheck(""+o)) return Short.valueOf(""+o);
		return sh;
	}

	public static long Long(Object o) {
		return Long(o, 0);
	}

	public static long Long(Object o, long l) {
		if (o != null) ;else return l;
		try {
			return Long.valueOf(""+o);
		} catch (Exception e) {
		}
		return l;
	}

	public static int[] IntArray(Object o) {
		return o != null 
				&& o instanceof int[] ? (int[]) o : null;
	}

	public static float[] FloatArray(Object o) {
		return o != null 
				&& o instanceof float[] ? (float[]) o : null;
	}

	public static double[] DoubleArray(Object o) {
		return o != null 
				&& o instanceof double[] ? (double[]) o : null;
	}

	public static byte[] ByteArray(Object o) {
		return o != null 
				&& o instanceof byte[] ? (byte[]) o : null;
	}

	public static String[] StringArray(Object o) {
		return o != null 
				&& o instanceof String[] ? (String[]) o : null;
	}

	public static Object[] ObjectArray(Object o) {
		return o != null 
				&& o instanceof Object[] ? (Object[]) o : null;
	}

	public static byte Byte(Object o) {
		return Byte(o, (byte)0);
	}

	public static byte Byte(Object o, byte by) {
		if (o != null) ;else return by;
		if (o instanceof Boolean) {
			boolean b = (Boolean) o;
			return (byte) (b ? 2 : 1);
		}
		if (o instanceof Byte) return (Byte) o;
		if (Modchu_Main.byteCheck(""+o)) return Byte.valueOf(""+o);
		return by;
	}

	public static float Float(Object o) {
		return Float(o, 0.0F);
	}

	public static float Float(Object o, float f) {
		if (o != null) ;else return f;
		if (o instanceof Boolean) {
			boolean b = (Boolean) o;
			return b ? 2 : 1;
		}
		if (o instanceof Float) return (Float) o;
		if (Modchu_Main.floatCheck(""+o)) return Float.valueOf(""+o);
		return f;
	}

	public static double Double(Object o) {
		return Double(o, 0.0D);
	}

	public static double Double(Object o, double d) {
		if (o != null) ;else return d;
		if (o instanceof Boolean) {
			boolean b = (Boolean) o;
			return b ? 2 : 1;
		}
		if (o instanceof Double) return (Double) o;
		return Double.valueOf(""+o);
	}

	public static boolean Boolean(Object o) {
		if (o != null) ;else return false;
		if (boolean.class.isInstance(o)
				| o instanceof String) {
			return Boolean.valueOf(""+o);
		}
		if (o instanceof Boolean) return (Boolean) o;
		return false;
	}

	public static Enum Enum(Object o) {
		return o != null 
				&& o instanceof Enum ? (Enum) o : null;
	}

	public static List List(Object o) {
		return o != null 
				&& o instanceof List ? (List) o : null;
	}

	public static ArrayList ArrayList(Object o) {
		return o != null 
				&& o instanceof ArrayList ? (ArrayList) o : null;
	}

	public static LinkedList LinkedList(Object o) {
		return o != null 
				&& o instanceof LinkedList ? (LinkedList) o : null;
	}

	public static File File(Object o) {
		return o != null 
				&& o instanceof File ? (File) o : null;
	}

	public static ConcurrentHashMap ConcurrentHashMap(Object o) {
		return o != null 
				&& o instanceof ConcurrentHashMap ? (ConcurrentHashMap) o : null;
	}

	public static HashMap HashMap(Object o) {
		return o != null 
				&& o instanceof HashMap ? (HashMap) o : null;
	}

	public static Map Map(Object o) {
		return o != null 
				&& o instanceof Map ? (Map) o : null;
	}

	public static IntBuffer IntBuffer(Object o) {
		return o != null 
				&& o instanceof IntBuffer ? (IntBuffer) o : null;
	}

	public static InputStream InputStream(Object o) {
		return o != null 
				&& o instanceof InputStream ? (InputStream) o : null;
	}

	public static UUID UUID(Object o) {
		return o != null 
				&& o instanceof UUID ? (UUID) o : null;
	}
}
