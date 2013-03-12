package net.minecraft.src;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Modchu_Reflect
{
    public static boolean debugReflectMessage = true;
    public static boolean debugReflectMessageDetail = false;

    public static void setDebugMessage(boolean b) {
    	debugReflectMessage = b;
    }

    public static void setDebugMessageDetail(boolean b) {
    	debugReflectMessageDetail = b;
    }

    public static void copyFields(Class var0, Object var1, Object var2)
    {
    	Field[] var3 = var0.getDeclaredFields();
    	for (int var4 = 0; var4 < var3.length; ++var4) {
    		Field var5 = var3[var4];
    		int var6 = var5.getModifiers();
    		if (!Modifier.isStatic(var6) && !Modifier.isFinal(var6)) {
    			var5.setAccessible(true);
    			setFieldObject(var5, var2, getFieldObject(var5, var1));
    		}
    	}
    }

    public static void setFieldObject(Field var0, Object var1, Object var2)
    {
    	try {
    		var0.set(var1, var2);
    	} catch (Exception e) {
    		if (debugReflectMessage) e.printStackTrace();
    	}
    }

    public static void setFieldObject(Class var0, String var1, Object var2)
    {
    	try {
    		getField(var0, var1).set(null, var2);
    	} catch (Exception e) {
    		if (debugReflectMessage) e.printStackTrace();
    	}
    }

    public static void setFieldObject(Class var0, String var1, String var2, Object var3)
    {
    	try {
    		getField(var0, var1).set(null, var3);
    	} catch (Exception e) {
    		try {
    			getField(var0, var2).set(null, var3);
    		} catch (Exception e1) {
    			if (debugReflectMessage) e1.printStackTrace();
    		}
    	}
    }

    public static void setFieldObject(Class var0, String var1, Object var2, Object var4)
    {
    	try {
    		getField(var0, var1).set(var2, var4);
    	} catch (Exception e) {
    		if (debugReflectMessage) e.printStackTrace();
    	}
    }

    public static void setFieldObject(Class var0, String var1, String var2, Object var3, Object var4)
    {
    	try {
    		getField(var0, var1).set(var3, var4);
    	} catch (Exception e) {
    		try {
    			getField(var0, var2).set(var3, var4);
    		} catch (Exception e1) {
    			if (debugReflectMessage) e1.printStackTrace();
    		}
    	}
    }

    public static Object getFieldObject(Field var0, Object var1)
    {
    	try {
    		return var0.get(var1);
    	} catch (Exception e) {
    		if (debugReflectMessage) e.printStackTrace();
    	}
    	return null;
    }

    public static Object getFieldObject(Class var0, Object var1)
    {
    	try {
    		return getField(var0, null).get(var1);
    	} catch (Exception e) {
    		if (debugReflectMessage) e.printStackTrace();
    	}
    	return null;
    }

    public static Object getFieldObject(Class var0, String var1)
    {
    	return getFieldObject(var0, var1, debugReflectMessage);
    }

    public static Object getFieldObject(Class var0, String var1, boolean var2)
    {
    	try {
    		return getField(var0, var1).get(null);
    	} catch (Exception e) {
    		if (var2) e.printStackTrace();
    	}
    	return null;
    }

    public static Object getFieldObject(Class var0, String var1, String var2)
    {
    	try {
    		return getField(var0, var1, var2).get(null);
    	} catch (Exception e) {
    		if (debugReflectMessage) e.printStackTrace();
    	}
    	return null;
    }

    public static Object getFieldObject(Class var0, String var1, Object var2)
    {
    	try {
    		return getField(var0, var1).get(var2);
    	} catch (Exception e) {
    		if (debugReflectMessage) e.printStackTrace();
    	}
    	return null;
    }

    public static Object getFieldObject(Class var0, String var1, String var2, Object var3)
    {
    	try {
    		return getField(var0, var1, var2).get(var3);
    	} catch (Exception e) {
    		if (debugReflectMessage) e.printStackTrace();
    	}
    	return null;
    }

    public static Object getFieldObject(String var0, String var1, String var2)
    {
    	try {
    		return getField(loadClass(var0), var1, var2).get(null);
    	} catch (Exception e) {
    		if (debugReflectMessage) e.printStackTrace();
    	}
    	return null;
    }

    public static Object getFieldObject(String var0, String var1, Object var2)
    {
    	try {
    		return getField(loadClass(var0), var1).get(var2);
    	} catch (Exception e) {
    		if (debugReflectMessage) e.printStackTrace();
    	}
    	return null;
    }

    public static Object getFieldObject(String var0, String var1)
    {
    	return getFieldObject(var0, var1, debugReflectMessage);
    }

    public static Object getFieldObject(String var0, String var1, boolean var2)
    {
    	try {
    		return getField(loadClass(var0), var1).get(null);
    	} catch (Exception e) {
    		if (var2) e.printStackTrace();
    	}
    	return null;
    }

    public static Object getFieldObject(String var0, String var1, String var2, Object var3)
    {
    	try {
    		return getField(loadClass(var0), var1, var2).get(var3);
    	} catch (Exception e) {
    		if (debugReflectMessage) e.printStackTrace();
    	}
    	return null;
    }

    public static Field getField(Class var0, String var1, String var2) {
    	Field field = getField(var0, var2);
    	if (field != null) return field;
    	return getField(var0, var1);
    }

    public static Field getField(Class var0, String var1)
    {
    	Field var4 = null;
    	try {
    		var4 = getRawField(var0, var1);
    		var4.setAccessible(true);
    	} catch (Exception e) {
    		if (debugReflectMessageDetail) e.printStackTrace();
    	}
    	return var4;
    }

    public static Field getField(String var0, String var1, String var2) {
    	Field field = getField(loadClass(var0), var2);
    	if (field != null) return field;
    	return getField(var0, var1);
    }

    public static Field getField(String var0, String var1)
    {
    	Field var4 = null;
    	try {
    		var4 = getRawField(loadClass(var0), var1);
    		var4.setAccessible(true);
    	} catch (Exception e) {
    		if (debugReflectMessageDetail) e.printStackTrace();
    	}
    	return var4;
    }

    private static Field getRawField(Class var0, String var1)
    {
    	if (var1 != null) {
    		try {
    			return var0.getDeclaredField(var1);
    		} catch (Exception e1) {
    			try {
    				return var0.getField(var1);
    			} catch (Exception e) {
    				if (debugReflectMessageDetail) e.printStackTrace();
    			}
    		}
    	}
    	return null;
    }

    public static Method getMethod(Class var0, String var1, String var2)
    {
    	Method method = null;
    	method = getMethod(var0, var2, (Class[]) null);
    	if (method != null) return method;
    	return getMethod(var0, var1, (Class[]) null);
    }

    public static Method getMethod(Class var0, String var1, String var2, Class[] var3)
    {
    	Method method = null;
    	method = getMethod(var0, var2, var3);
    	if (method != null) return method;
    	return getMethod(var0, var1, var3);
    }

    public static Method getMethod(Class var0, String var1)
    {
    	return getMethod(var0, var1, debugReflectMessage);
    }

    public static Method getMethod(Class var0, String var1, boolean b)
    {
    	Method var5 = null;
    	try {
    		var5 = getRawMethod(var0, var1, null);
    		var5.setAccessible(true);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return var5;
    }

    public static Method getMethod(Class var0, String var1, Class[] var2)
    {
    	Method var5 = null;
    	try {
    		var5 = getRawMethod(var0, var1, var2);
    		var5.setAccessible(true);
    	} catch (Exception e) {
    		if (debugReflectMessageDetail) e.printStackTrace();
    	}
    	return var5;
    }

    private static Method getRawMethod(Class var0, String var1, Class[] var2)
    {
    	if (var1 != null) {
    		try {
    			return var0.getDeclaredMethod(var1, var2);
    		} catch (Exception e1) {
    			try {
    				return var0.getMethod(var1, var2);
    			} catch (Exception e) {
    				if (debugReflectMessageDetail) e.printStackTrace();
    	   		}
    		}
    	}
    	return null;
    }

    public static Object invoke(Method var0)
    {
    	try {
    		return var0.invoke(null);
    	} catch (Exception e) {
    		if (debugReflectMessage) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invoke(Method var0, Object var1)
    {
    	try {
    		return var0.invoke(var1);
    	} catch (Exception e) {
    		if (debugReflectMessage) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invoke(Method var0, Object var1, Object var2)
    {
    	try {
    		return var0.invoke(var1, var2);
    	} catch (Exception e) {
    		if (debugReflectMessage) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invoke(Method var0, Object var1, Object ... var2)
    {
    	try {
    		return var0.invoke(var1, var2);
    	} catch (Exception e) {
    		if (debugReflectMessage) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1)
    {
    	try {
    		return getMethod(var0, var1, (Class[]) null).invoke(null);
    	} catch (Exception e) {
    		if (debugReflectMessage) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1, String var2)
    {
    	try {
    		return getMethod(var0, var1, (Class[]) null).invoke(null);
    	} catch (Exception ee) {
    		try {
    			return getMethod(var0, var2, (Class[]) null).invoke(null);
    		} catch (Exception e) {
    			if (debugReflectMessage) e.printStackTrace();
    		}
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1, Object var3)
    {
    	try {
    		return getMethod(var0, var1, (Class[]) null).invoke(var3);
    	} catch (Exception e) {
    		if (debugReflectMessage) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1, String var2, Object var3)
    {
    	try {
    		return getMethod(var0, var1, (Class[]) null).invoke(var3);
    	} catch (Exception ee) {
    		try {
    			return getMethod(var0, var2, (Class[]) null).invoke(var3);
    		} catch (Exception e) {
    			if (debugReflectMessage) e.printStackTrace();
    		}
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1, Object var3, Object var4)
    {
    	try {
    		return getMethod(var0, var1, (Class[]) null).invoke(var3, var4);
    	} catch (Exception e) {
    		if (debugReflectMessage) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1, Class[] var2, Object var3, Object var4)
    {
    	try {
    		return getMethod(var0, var1, var2).invoke(var3, var4);
    	} catch (Exception e) {
    		if (debugReflectMessage) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1, String var2, Class[] var3, Object var4, Object var5)
    {
    	try {
    		return getMethod(var0, var1, var3).invoke(var4, var5);
    	} catch (Exception ee) {
    		try {
    			return getMethod(var0, var2, var3).invoke(var4, var5);
    		} catch (Exception e) {
    			if (debugReflectMessage) e.printStackTrace();
    		}
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1, Class[] var2, Object var3, Object ... var4)
    {
    	try {
    		return getMethod(var0, var1, var2).invoke(var3, var4);
    	} catch (Exception e) {
    		if (debugReflectMessage) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1, String var2, Class[] var3, Object var4, Object ... var5)
    {
    	try {
    		return getMethod(var0, var1, var3).invoke(var4, var5);
    	} catch (Exception ee) {
    		try {
    			return getMethod(var0, var2, var3).invoke(var4, var5);
    		} catch (Exception e) {
    			if (debugReflectMessage) e.printStackTrace();
    		}
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1)
    {
    	try {
    		return getMethod(loadClass(var0), var1, (Class[]) null).invoke(null);
    	} catch (Exception e) {
    		if (debugReflectMessage) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1, String var2)
    {
    	try {
    		return getMethod(loadClass(var0), var1, (Class[]) null).invoke(null);
    	} catch (Exception ee) {
    		try {
    			return getMethod(loadClass(var0), var2, (Class[]) null).invoke(null);
    		} catch (Exception e) {
    			if (debugReflectMessage) e.printStackTrace();
    		}
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1, Object var3)
    {
    	try {
    		return getMethod(loadClass(var0), var1, (Class[]) null).invoke(var3);
    	} catch (Exception e) {
    		if (debugReflectMessage) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1, String var2, Object var3)
    {
    	try {
    		return getMethod(loadClass(var0), var1, (Class[]) null).invoke(var3);
    	} catch (Exception ee) {
    		try {
    			return getMethod(loadClass(var0), var2, (Class[]) null).invoke(var3);
    		} catch (Exception e) {
    			if (debugReflectMessage) e.printStackTrace();
    		}
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1, Object var3, Object var4)
    {
    	try {
    		return getMethod(loadClass(var0), var1, (Class[]) null).invoke(var3, var4);
    	} catch (Exception e) {
    		if (debugReflectMessage) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1, Class[] var2, Object var3, Object var4)
    {
    	try {
    		return getMethod(loadClass(var0), var1, var2).invoke(var3, var4);
    	} catch (Exception e) {
    		if (debugReflectMessage) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1, String var2, Class[] var3, Object var4, Object var5)
    {
    	try {
    		return getMethod(loadClass(var0), var1, var3).invoke(var4, var5);
    	} catch (Exception ee) {
    		try {
    			return getMethod(loadClass(var0), var2, var3).invoke(var4, var5);
    		} catch (Exception e) {
    			if (debugReflectMessage) e.printStackTrace();
    		}
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1, Class[] var2, Object var3, Object ... var4)
    {
    	try {
    		return getMethod(loadClass(var0), var1, var2).invoke(var3, var4);
    	} catch (Exception e) {
    		if (debugReflectMessage) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1, String var2, Class[] var3, Object var4, Object ... var5)
    {
    	try {
    		return getMethod(loadClass(var0), var1, var3).invoke(var4, var5);
    	} catch (Exception ee) {
    		try {
    			return getMethod(loadClass(var0), var2, var3).invoke(var4, var5);
    		} catch (Exception e) {
    			if (debugReflectMessage) e.printStackTrace();
    		}
    	}
    	return null;
    }

    public static Class loadClass(String var0)
    {
    	return loadClass(var0, debugReflectMessage);
    }

    public static Class loadClass(String var0, boolean b)
    {
    	Class c = null;
    	try {
    		c = Class.forName(var0);
    	} catch (NoClassDefFoundError e) {
    		if (b) e.printStackTrace();
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return c;
    }

    public static Object newInstance(String var1, Class[] var2, Object[] var3)
    {
    	try {
    		return loadClass(var1).getConstructor(var2).newInstance(var3);
    	} catch (Exception e) {
    		if (debugReflectMessage) e.printStackTrace();
    	}
    	return null;
    }

    public static Object newInstance(Class var1, Class[] var2, Object[] var3)
    {
    	try {
    		return var1.getConstructor(var2).newInstance(var3);
    	} catch (Exception e) {
    		if (debugReflectMessage) e.printStackTrace();
    		else {
    			e.printStackTrace();
    		}
    	}
    	return null;
    }
}
