package net.minecraft.src;

import java.lang.reflect.Constructor;
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
    	Field[] ff = var0.getDeclaredFields();
    	for (int var4 = 0; var4 < ff.length; ++var4) {
    		Field f = ff[var4];
    		int var6 = f.getModifiers();
    		if (!Modifier.isStatic(var6) && !Modifier.isFinal(var6)) {
    			f.setAccessible(true);
    			setFieldObject(f, var2, getFieldObject(f, var1));
    		}
    	}
    }

    public static void setFieldObject(Field var0, Object var1, Object var2)
    {
    	setFieldObject(var0, var1, var2, 1);
    }

    public static void setFieldObject(Field var0, Object var1, Object var2, int i)
    {
    	try {
    		if (var0 != null) var0.set(var1, var2);
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    }

    public static void setFieldObject(Class var0, String var1, Object var2)
    {
    	setFieldObject(var0, var1, var2, 1);
    }

    public static void setFieldObject(Class var0, String var1, Object var2, int i)
    {
    	Field f = null;
    	try {
    		f = getField(var0, var1, i);
    		if (f != null) f.set(null, var2);
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    }

    public static void setFieldObject(Class var0, String var1, String var2, Object var3)
    {
    	setFieldObject(var0, var1, var2, var3, 1);
    }

    public static void setFieldObject(Class var0, String var1, String var2, Object var3, int i)
    {
    	Field f = null;
    	try {
    		f = getField(var0, var1, i);
    		if (f != null) f.set(null, var3);
    	} catch (Exception e) {
    		if (debugDisplayDetail(i)) e.printStackTrace();
    		try {
    			f = getField(var0, var2, i);
    			if (f != null) f.set(null, var3);
    		} catch (Exception e1) {
    			if (debugDisplay(i)) e1.printStackTrace();
    		}
    	}
    }

    public static void setFieldObject(Class var0, String var1, Object var2, Object var4)
    {
    	setFieldObject(var0, var1, var2, var4, 1);
    }

    public static void setFieldObject(Class var0, String var1, Object var2, Object var4, int i)
    {
    	Field f = null;
    	try {
    		f = getField(var0, var1, i);
    		if (f != null) f.set(var2, var4);
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    }

    public static void setFieldObject(Class var0, String var1, String var2, Object var3, Object var4)
    {
    	setFieldObject(var0, var1, var2, var3, var4, 1);
    }

    public static void setFieldObject(Class var0, String var1, String var2, Object var3, Object var4, int i)
    {
    	Field f = null;
    	try {
    		f = getField(var0, var1, i);
    		if (f != null) f.set(var3, var4);
    	} catch (Exception e) {
    		if (debugDisplayDetail(i)) e.printStackTrace();
    		try {
    			f = getField(var0, var2, i);
    			if (f != null) f.set(var3, var4);
    		} catch (Exception e1) {
    			if (debugDisplay(i)) e1.printStackTrace();
    		}
    	}
    }

    public static Object getFieldObject(Field var0, Object var1)
    {
    	return getFieldObject(var0, var1, 1);
    }

    public static Object getFieldObject(Field var0, Object var1, int i)
    {
    	try {
    		if (var0 != null) return var0.get(var1);
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object getFieldObject(Class var0, Object var1)
    {
    	return getFieldObject(var0, var1, 1);
    }

    public static Object getFieldObject(Class var0, Object var1, int i)
    {
    	Field f = null;
    	try {
    		f = getField(var0, null, i);
    		if (f != null) return f.get(var1);
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object getFieldObject(Class var0, String var1)
    {
    	return getFieldObject(var0, var1, 1);
    }

    public static Object getFieldObject(Class var0, String var1, int i)
    {
    	Field f = null;
    	try {
    		f = getField(var0, var1, i);
    		if (f != null) return f.get(null);
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object getFieldObject(Class var0, String var1, String var2)
    {
    	return getFieldObject(var0, var1, var2, 1);
    }

    public static Object getFieldObject(Class var0, String var1, String var2, int i)
    {
    	Field f = null;
    	try {
    		f = getField(var0, var1, var2, i);
    		if (f != null) return f.get(null);
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object getFieldObject(Class var0, String var1, Object var2)
    {
    	return getFieldObject(var0, var1, var2, 1);
    }

    public static Object getFieldObject(Class var0, String var1, Object var2, int i)
    {
    	Field f = null;
    	try {
    		f = getField(var0, var1, i);
    		if (f != null) return f.get(var2);
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object getFieldObject(Class var0, String var1, String var2, Object var3)
    {
    	return getFieldObject(var0, var1, var2, var3, 1);
    }

    public static Object getFieldObject(Class var0, String var1, String var2, Object var3, int i)
    {
    	Field f = null;
    	try {
    		f = getField(var0, var1, var2, i);
    		if (f != null) return f.get(var3);
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object getFieldObject(String var0, String var1, String var2)
    {
    	return getFieldObject(var0, var1, var2, 1);
    }

    public static Object getFieldObject(String var0, String var1, String var2, int i)
    {
    	Field f = null;
    	try {
    		f = getField(var0, var1, var2, i);
    		if (f != null) return f.get(null);
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object getFieldObject(String var0, String var1, Object var2)
    {
    	return getFieldObject(var0, var1, var2, 1);
    }

    public static Object getFieldObject(String var0, String var1, Object var2, int i)
    {
    	Field f = null;
    	Class c = null;
    	try {
    		c = loadClass(var0, i);
    		if (c != null) f = getField(c, var1, i);
    		if (f != null) return f.get(var2);
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object getFieldObject(String var0, String var1)
    {
    	return getFieldObject(var0, var1, 1);
    }

    public static Object getFieldObject(String var0, String var1, int i)
    {
    	Field f = null;
    	Class c = null;
    	try {
    		c = loadClass(var0, i);
    		if (c != null) f = getField(c, var1, i);
    		if (f != null) return f.get(null);
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object getFieldObject(String var0, String var1, String var2, Object var3)
    {
    	return getFieldObject(var0, var1, var2, var3, 1);
    }

    public static Object getFieldObject(String var0, String var1, String var2, Object var3, int i)
    {
    	Field f = null;
    	Class c = null;
    	try {
    		c = loadClass(var0);
    		if (c != null) f = getField(c, var1, var2, i);
    		if (f != null) return f.get(var3);
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Field getField(Class var0, String var1, String var2) {
    	return getField(var0, var1, var2, 1);
    }

    public static Field getField(Class var0, String var1, String var2, int i) {
    	Field f = getField(var0, var1, i);
    	if (f != null) return f;
    	f = getField(var0, var2, i);
    	return f;
    }

    public static Field getField(Class var0, String var1)
    {
    	return getField(var0, var1, 1);
    }

    public static Field getField(Class var0, String var1, int i)
    {
    	Field f = null;
    	try {
    		f = getRawField(var0, var1, i);
    		if (f != null) f.setAccessible(true);
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return f;
    }

    public static Field getField(String var0, String var1, String var2) {
    	Field f = null;
    	Class c = loadClass(var0);
    	if (c != null) f = getField(c, var1, 1);
    	if (f != null) return f;
    	f = getField(var0, var2, 1);
    	return f;
    }

    public static Field getField(String var0, String var1, String var2, int i) {
    	Field f = null;
    	Class c = loadClass(var0);
    	if (c != null) f = getField(c, var1, i);
    	if (f != null) return f;
    	f = getField(var0, var2, i);
    	return f;
    }

    public static Field getField(String var0, String var1)
    {
    	return getField(var0, var1, 1);
    }

    public static Field getField(String var0, String var1, int i)
    {
    	Field f = null;
    	try {
    		f = getRawField(loadClass(var0), var1, i);
    		if (f != null) f.setAccessible(true);
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return f;
    }

    private static Field getRawField(Class var0, String var1)
    {
    	return getRawField(var0, var1, 1);
    }

    private static Field getRawField(Class var0, String var1, int i)
    {
    	Field f = null;
    	if (var1 != null
    			&& var0 != null) {
    		try {
    			f = var0.getDeclaredField(var1);
    			return f;
    		} catch (Exception e1) {
    		}
    		if (debugReflectMessageDetail) Modchu_Debug.Debug("getRawField Exception getDeclaredField Class="+var0+" String="+var1);
    		try {
    			f = var0.getField(var1);
    			return f;
    		} catch (Exception e) {
    		}
    		try {
    			var1 = getFieldName(var1);
    			f = var0.getDeclaredField(var1);
    			return f;
    		} catch (Exception e2) {
    		}
    		if (debugReflectMessageDetail) Modchu_Debug.Debug("getRawField Exception getDeclaredField Class="+var0+" String="+var1);
    		try {
    			f = var0.getField(var1);
    			return f;
    		} catch (Exception e3) {
    		}
    		if (debugReflectMessageDetail) Modchu_Debug.Debug("getRawField Exception getField Class="+var0+" String="+var1);
    		for (Class c = var0; c != Object.class; c = c.getSuperclass()) {
    			try {
    				if (c != null) f = c.getDeclaredField(var1);
    				if (f != null) {
    					f.setAccessible(true);
    					return f;
    				}
    			} catch (Exception e4) {
    				if (debugReflectMessageDetail) {
    					Modchu_Debug.Debug("getRawField Exception Class="+c+" String="+var1);
    					e4.printStackTrace();
    				}
    			}
    		}
    	}
    	return f;
    }

    public static Method getMethod(Class var0, String var1, String var2)
    {
    	return getMethod(var0, var1, var2, 1);
    }

    public static Method getMethod(Class var0, String var1, String var2, int i)
    {
    	Method method = null;
    	method = getMethod(var0, var1, (Class[]) null, i);
    	if (method != null) return method;
    	method = getMethod(var0, var2, (Class[]) null, i);
    	return method;
    }

    public static Method getMethod(Class var0, String var1, String var2, Class[] var3)
    {
    	Method method = null;
    	method = getMethod(var0, var1, var3, 1);
    	if (method != null) return method;
    	method = getMethod(var0, var2, var3, 1);
    	return method;
    }

    public static Method getMethod(Class var0, String var1, String var2, Class[] var3, int i)
    {
    	Method method = null;
    	method = getMethod(var0, var1, var3, i);
    	if (method != null) return method;
    	method = getMethod(var0, var2, var3, i);
    	return method;
    }

    public static Method getMethod(Class var0, String var1)
    {
    	return getMethod(var0, var1, 1);
    }

    public static Method getMethod(Class var0, String var1, int i)
    {
    	Method method = null;
    	try {
    		method = getRawMethod(var0, var1, null, i);
    		if (method != null) method.setAccessible(true);
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return method;
    }

    public static Method getMethod(Class var0, String var1, Class[] var2)
    {
    	return getMethod(var0, var1, var2, 1);
    }

    public static Method getMethod(Class var0, String var1, Class[] var2, int i)
    {
    	Method method = null;
    	try {
    		method = getRawMethod(var0, var1, var2, i);
    		if (method != null) method.setAccessible(true);
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return method;
    }

    private static Method getRawMethod(Class var0, String var1, Class[] var2)
    {
    	return getRawMethod(var0, var1, var2, 1);
    }

    private static Method getRawMethod(Class var0, String var1, Class[] var2, int i)
    {
    	Method method = null;
    	if (var1 != null) {
    		try {
    			if (var0 != null) method = var0.getDeclaredMethod(var1, var2);
    			return method;
    		} catch (Exception e1) {
    			if (debugDisplayDetail(i)) e1.printStackTrace();
    		}
    		try {
    			if (var0 != null) method = var0.getMethod(var1, var2);
    			return method;
    		} catch (Exception e) {
    			if (debugDisplay(i)) e.printStackTrace();
    		}
    		var1 = getFieldName(var1);
    		try {
    			if (var0 != null) method = var0.getMethod(var1, var2);
    			return method;
    		} catch (Exception e) {
    			if (debugDisplay(i)) e.printStackTrace();
    		}
    	}
    	return method;
    }

    public static Method getMethod(String var0, String var1, String var2)
    {
    	return getMethod(var0, var1, var2, 1);
    }

    public static Method getMethod(String var0, String var1, String var2, int i)
    {
    	Method method = null;
    	method = getMethod(var0, var2, (Class[]) null, i);
    	if (method != null) return method;
    	method = getMethod(var0, var1, (Class[]) null, i);
    	return method;
    }

    public static Method getMethod(String var0, String var1, String var2, Class[] var3)
    {
    	return getMethod(var0, var1, var2, var3, 1);
    }

    public static Method getMethod(String var0, String var1, String var2, Class[] var3, int i)
    {
    	Method method = null;
    	method = getMethod(var0, var2, var3, i);
    	if (method != null) return method;
    	method = getMethod(var0, var1, var3, i);
    	return method;
    }

    public static Method getMethod(String var0, String var1)
    {
    	return getMethod(var0, var1, 1);
    }

    public static Method getMethod(String var0, String var1, int i)
    {
    	Method method = null;
    	try {
    		method = getRawMethod(var0, var1, null, i);
    		if (method != null) method.setAccessible(true);
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return method;
    }

    public static Method getMethod(String var0, String var1, Class[] var2)
    {
    	return getMethod(var0, var1, var2, 1);
    }

    public static Method getMethod(String var0, String var1, Class[] var2, int i)
    {
    	Method method = null;
    	try {
    		method = getRawMethod(var0, var1, var2, i);
    		if (method != null) method.setAccessible(true);
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return method;
    }

    private static Method getRawMethod(String var0, String var1, Class[] var2)
    {
    	return getRawMethod(var0, var1, var2, 1);
    }

    private static Method getRawMethod(String var0, String var1, Class[] var2, int i)
    {
    	Class c = null;
    	Method method = null;
    	if (var1 != null) {
    		try {
    			c = loadClass(var0, i);
    			if (c != null) method = c.getDeclaredMethod(var1, var2);
    			return method;
    		} catch (Exception e1) {
    			if (debugDisplayDetail(i)) e1.printStackTrace();
    		}
    		try {
    			c = loadClass(var0, i);
    			if (c != null) method = c.getMethod(var1, var2);
    		} catch (Exception e) {
    			if (debugDisplay(i)) e.printStackTrace();
    		}
    	}
    	return method;
    }

    public static Object invoke(Method var0)
    {
    	return invoke(var0, 1);
    }

    public static Object invoke(Method var0, int i)
    {
    	try {
    		if (var0 != null) {
    			Object o = var0.invoke(null);
    			return o;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invoke(Method var0, Object var1)
    {
    	return invoke(var0, var1, 1);
    }

    public static Object invoke(Method var0, Object var1, int i)
    {
    	try {
    		if (var0 != null) {
    			Object o = var0.invoke(var1);
    			return o;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invoke(Method var0, Object var1, Object var2)
    {
    	return invoke(var0, var1, var2, 1);
    }

    public static Object invoke(Method var0, Object var1, Object var2, int i)
    {
    	try {
    		if (var0 != null) {
    			Object o = var0.invoke(var1, var2);
    			return o;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invoke(Method var0, Object var1, Object ... var2)
    {
    	return invoke(var0, var1, var2, 1);
    }

    public static Object invoke(Method var0, Object var1, Object[] var2, int i)
    {
    	try {
    		if (var0 != null) return var0.invoke(var1, (Object) var2);
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1)
    {
    	return invokeMethod(var0, var1, 1);
    }

    public static Object invokeMethod(Class var0, String var1, int i)
    {
    	Method method = null;
    	try {
    		method = getMethod(var0, var1, (Class[]) null, i);
    		if (method != null) {
    			Object o = method.invoke(null);
    			return o;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1, String var2)
    {
    	return invokeMethod(var0, var1, var2, 1);
    }

    public static Object invokeMethod(Class var0, String var1, String var2, int i)
    {
    	Method method = null;
    	try {
    		method = getMethod(var0, var1, (Class[]) null, i);
    		if (method != null) {
    			Object o = method.invoke(null);
    			return o;
    		}
    	} catch (Exception ee) {
    	}
    	try {
    		method = getMethod(var0, var2, (Class[]) null, i);
    		if (method != null) {
    			Object o = method.invoke(null);
    			return o;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1, Object var3)
    {
    	return invokeMethod(var0, var1, var3, 1);
    }

    public static Object invokeMethod(Class var0, String var1, Object var3, int i)
    {
    	Method method = null;
    	try {
    		method = getMethod(var0, var1, (Class[]) null, i);
    		if (method != null) {
    			Object o = method.invoke(var3);
    			return o;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1, String var2, Object var3)
    {
    	return invokeMethod(var0, var1, var2, var3, 1);
    }

    public static Object invokeMethod(Class var0, String var1, String var2, Object var3, int i)
    {
    	Method method = null;
    	try {
    		method = getMethod(var0, var1, (Class[]) null, i);
    		if (method != null) {
    			Object o = method.invoke(var3);
    			return o;
    		}
    	} catch (Exception ee) {
    	}
    	try {
    		method = getMethod(var0, var2, (Class[]) null, i);
    		if (method != null) {
    			Object o = method.invoke(var3);
    			return o;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1, Object var3, Object var4)
    {
    	return invokeMethod(var0, var1, var3, var4, 1);
    }

    public static Object invokeMethod(Class var0, String var1, Object var3, Object var4, int i)
    {
    	Method method = null;
    	try {
    		method = getMethod(var0, var1, (Class[]) null, i);
    		if (method != null) {
    			Object o = method.invoke(var3, var4);
    			return o;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1, Class[] var2, Object var3, Object var4)
    {
    	return invokeMethod(var0, var1, var2, var3, var4, 1);
    }

    public static Object invokeMethod(Class var0, String var1, Class[] var2, Object var3, Object var4, int i)
    {
    	Method method = null;
    	try {
    		method = getMethod(var0, var1, var2, i);
    		if (method != null) {
    			Object o = method.invoke(var3, var4);
    			return o;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1, Class[] var2, Object var3, Object ... var4)
    {
    	return invokeMethod(var0, var1, var2, var3, var4, 1);
    }

    public static Object invokeMethod(Class var0, String var1, Class[] var2, Object var3, Object[] var4, int i)
    {
    	Method method = null;
    	try {
    		method = getMethod(var0, var1, var2, i);
    		if (method != null) {
    			Object o = method.invoke(var3, var4);
    			return o;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1, String var2, Class[] var3, Object var4, Object var5)
    {
    	return invokeMethod(var0, var1, var2, var3, var4, var5, 1);
    }

    public static Object invokeMethod(Class var0, String var1, String var2, Class[] var3, Object var4, Object var5, int i)
    {
    	Method method = null;
    	try {
    		method = getMethod(var0, var1, var3, i);
    		if (method != null) {
    			Object o = method.invoke(var4, var5);
    			return o;
    		}
    	} catch (Exception ee) {
    	}
    	try {
    		method = getMethod(var0, var2, var3, i);
    		if (method != null) {
    			Object o = method.invoke(var4, var5);
    			return o;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1, String var2, Class[] var3, Object var4, Object ... var5)
    {
    	return invokeMethod(var0, var1, var2, var3, var4, var5, 1);
    }

    public static Object invokeMethod(Class var0, String var1, String var2, Class[] var3, Object var4, Object[] var5, int i)
    {
    	Method method = null;
    	try {
    		method = getMethod(var0, var1, var3, i);
    		if (method != null) {
    			Object o = method.invoke(var4, var5);
    			return o;
    		}
    	} catch (Exception ee) {
    	}
    	try {
    		method = getMethod(var0, var2, var3, i);
    		if (method != null) {
    			Object o = method.invoke(var4, var5);
    			return o;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1)
    {
    	return invokeMethod(var0, var1, 1);
    }

    public static Object invokeMethod(String var0, String var1, int i)
    {
    	Method method = null;
    	Class c = null;
    	try {
    		c = loadClass(var0);
    		if (c != null) method = getMethod(c, var1, (Class[]) null, i);
    		if (method != null) {
    			Object o = method.invoke(null);
    			return o;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1, String var2)
    {
    	return invokeMethod(var0, var1, var2, 1);
    }

    public static Object invokeMethod(String var0, String var1, String var2, int i)
    {
    	Method method = null;
    	Class c = null;
    	try {
    		c = loadClass(var0);
    		if (c != null) method = getMethod(c, var1, (Class[]) null, i);
    		if (method != null) {
    			Object o = method.invoke(null);
    			return o;
    		}
    	} catch (Exception ee) {
    	}
    	try {
    		c = loadClass(var0);
    		if (c != null) method = getMethod(c, var2, (Class[]) null, i);
    		if (method != null) {
    			Object o = method.invoke(null);
    			return o;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1, Object var3)
    {
    	return invokeMethod(var0, var1, var3, 1);
    }

    public static Object invokeMethod(String var0, String var1, Object var3, int i)
    {
    	Method method = null;
    	Class c = null;
    	try {
    		c = loadClass(var0);
    		if (c != null) method = getMethod(c, var1, (Class[]) null, i);
    		if (method != null) {
    			Object o = method.invoke(var3);
    			return o;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1, String var2, Object var3)
    {
    	return invokeMethod(var0, var1, var2, var3, 1);
    }

    public static Object invokeMethod(String var0, String var1, String var2, Object var3, int i)
    {
    	Method method = null;
    	Class c = null;
    	try {
    		c = loadClass(var0);
    		if (c != null) method = getMethod(c, var1, (Class[]) null, i);
    		if (method != null) {
    			Object o = method.invoke(var3);
    			return o;
    		}
    	} catch (Exception ee) {
    	}
    	try {
    		c = loadClass(var0);
    		if (c != null) method = getMethod(c, var2, (Class[]) null, i);
    		if (method != null) {
    			Object o = method.invoke(var3);
    			return o;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1, Object var3, Object var4)
    {
    	return invokeMethod(var0, var1, var3, var4, 1);
    }

    public static Object invokeMethod(String var0, String var1, Object var3, Object var4, int i)
    {
    	Method method = null;
    	Class c = null;
    	try {
    		c = loadClass(var0);
    		if (c != null) method = getMethod(c, var1, (Class[]) null, i);
    		if (method != null) {
    			Object o = method.invoke(var3, var4);
    			return o;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1, Class[] var2, Object var3, Object var4)
    {
    	return invokeMethod(var0, var1, var2, var3, var4, 1);
    }

    public static Object invokeMethod(String var0, String var1, Class[] var2, Object var3, Object var4, int i)
    {
    	Method method = null;
    	Class c = null;
    	try {
    		c = loadClass(var0);
    		if (c != null) method = getMethod(c, var1, var2, i);
    		if (method != null) {
    			Object o = method.invoke(var3, var4);
    			return o;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1, String var2, Class[] var3, Object var4, Object var5)
    {
    	return invokeMethod(var0, var1, var2, var3, var4, var5, 1);
    }

    public static Object invokeMethod(String var0, String var1, String var2, Class[] var3, Object var4, Object var5, int i)
    {
    	Method method = null;
    	Class c = null;
    	try {
    		c = loadClass(var0);
    		if (c != null) method = getMethod(c, var1, var3, i);
    		if (method != null) {
    			Object o = method.invoke(var4, var5);
    			return o;
    		}
    	} catch (Exception ee) {
    	}
    	try {
    		c = loadClass(var0);
    		if (c != null) method = getMethod(c, var2, var3, i);
    		if (method != null) {
    			Object o = method.invoke(var4, var5);
    			return o;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1, Class[] var2, Object var3, Object ... var4)
    {
    	return invokeMethod(var0, var1, var2, var3, var4, 1);
    }

    public static Object invokeMethod(String var0, String var1, Class[] var2, Object var3, Object[] var4, int i)
    {
    	Method method = null;
    	Class c = null;
    	try {
    		c = loadClass(var0);
    		if (c != null) method = getMethod(c, var1, var2, i);
    		if (method != null) {
    			Object o = method.invoke(var3, var4);
    			return o;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1, String var2, Class[] var3, Object var4, Object ... var5)
    {
    	return invokeMethod(var0, var1, var2, var3, var4, var5, 1);
    }

    public static Object invokeMethod(String var0, String var1, String var2, Class[] var3, Object var4, Object[] var5, int i)
    {
    	Method method = null;
    	Class c = null;
    	try {
    		c = loadClass(var0);
    		if (c != null) method = getMethod(c, var1, var3, i);
    		if (method != null) {
    			Object o = method.invoke(var4, var5);
    			return o;
    		}
    	} catch (Exception ee) {
    		if (debugDisplayDetail(i)) ee.printStackTrace();
    	}
    	try {
    		c = loadClass(var0);
    		if (c != null) method = getMethod(c, var2, var3, i);
    		if (method != null) {
    			Object o = method.invoke(var4, var5);
    			return o;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Class loadClass(String var0)
    {
    	return loadClass(var0, 1);
    }

    public static Class loadClass(String var0, int i)
    {
    	Class c = null;
    	try {
    		c = Class.forName(var0);
    		return c;
    	} catch (NoClassDefFoundError e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	} catch (ClassNotFoundException e) {
/*
    		if (	mod_Modchu_ModchuLib.isForge) {
    			try {
    				if (debugDisplay(i)) Modchu_Debug.Debug("loadClass classString="+var0);
    				Object o = getPrivateValue(Class.forName("cpw.mods.fml.relauncher.FMLRelauncher"), null, "INSTANCE");
    				if (debugDisplay(i)) Modchu_Debug.Debug("loadClass FMLRelauncher o="+(o != null));
    				if (o != null) o = getPrivateValue(o.getClass(), o, "classLoader");
    				if (debugDisplay(i)) Modchu_Debug.Debug("loadClass classLoader o="+(o != null));
    				if (o != null) {
    					try {
    						c = (Class) invokeMethod(o.getClass(), "findClass", new Class[]{ String.class }, o, new Object[]{ var0 });
    					} catch (Exception e3) {
    						try {
    							c = (Class) invokeMethod(o.getClass(), "findClass", new Class[]{ String.class }, o, new Object[]{ "net.minecraft.src."+var0 });
    						} catch (Exception e4) {
    							if (debugDisplay(i)) {
    								Modchu_Debug.Debug("loadClass Exception classString=net.minecraft.src."+var0);
    								e4.printStackTrace();
    							}
    						}
    					}
    				}
    			} catch (NoClassDefFoundError e1) {
    				if (debugDisplay(i)) e.printStackTrace();
    			} catch (ClassNotFoundException e2) {
    				if (debugDisplay(i)) e2.printStackTrace();
    			} catch (Exception e3) {
    				if (debugDisplay(i)) e3.printStackTrace();
    			}
    		} else
*/
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	try {
    		c = Class.forName("net.minecraft.src."+var0);
    	} catch (NoClassDefFoundError e1) {
    		if (debugDisplayDetail(i)) e1.printStackTrace();
    	} catch (ClassNotFoundException e1) {
    		if (debugDisplayDetail(i)) e1.printStackTrace();
    	} catch (Exception e1) {
    		if (debugDisplayDetail(i)) e1.printStackTrace();
    	}
    	return c;
    }

    public static Object newInstance(String var1, Class[] var2, Object[] var3)
    {
    	return newInstance(var1, var2, var3, 1);
    }

    public static Object newInstance(String var1, Class[] var2, Object[] var3, int i)
    {
    	Class c = null;
    	Constructor constructor = null;
    	try {
    		c = loadClass(var1);
    		if (c != null) constructor = c.getConstructor(var2);
    		if (constructor != null) return constructor.newInstance(var3);
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object newInstance(Class var1, Class[] var2, Object[] var3)
    {
    	return newInstance(var1, var2, var3, 1);
    }

    public static Object newInstance(Class var1, Class[] var2, Object[] var3, int i)
    {
    	Class c = var1;
    	Constructor constructor = null;
    	try {
    		if (c != null) constructor = c.getConstructor(var2);
    		if (constructor != null) return constructor.newInstance(var3);
    	} catch (Exception e) {
    		if (debugDisplay(i)) e.printStackTrace();
    	}
    	return null;
    }

    public static Object getPrivateValue(Class var0, Object var1, int var2) {
    	return getPrivateValue(var0, var1, var2, 1);
    }

    public static Object getPrivateValue(Class var0, Object var1, int var2, int i) {
    	Field f = null;
    	try {
    		if (var0 != null) f = var0.getDeclaredFields()[var2];
    		if (f != null) {
    			f.setAccessible(true);
    			return f.get(var1);
    		}
    	} catch (Exception var4) {
    		if (debugDisplay(i)) var4.printStackTrace();
    	}
    	return null;
    }

    public static Object getPrivateValue(Class var0, Object var1, String var2) {
    	return getPrivateValue(var0, var1, var2, 1);
    }

    public static Object getPrivateValue(Class var0, Object var1, String var2, int i) {
    	Field f = null;
    	try {
    		if (var0 != null) f = var0.getDeclaredField(var2);
    		if (f != null) {
    			f.setAccessible(true);
    			return f.get(var1);
    		}
    	} catch (Exception e) {
    		if (debugDisplayDetail(i)) e.printStackTrace();
    	}
    	for (Class c = var0; c != Object.class; c = c.getSuperclass()) {
    		try {
    			f = c.getDeclaredField(var2);
    			if (f != null) {
    				f.setAccessible(true);
    				return f.get(var1);
    			}
    		} catch (Exception e2) {
    			if (debugDisplayDetail(i)) e2.printStackTrace();
    		}
    	}
    	return null;
    }

    public static void setPrivateValue(Class var0, Object var1, int var2, Object var3) {
    	setPrivateValue(var0, var1, var2, var3, 1);
    }

    public static void setPrivateValue(Class var0, Object var1, int var2, Object var3, int i) {
    	Field f = null;
    	try {
    		if (var0 != null) f = var0.getDeclaredFields()[var2];
    		if (f != null) {
    			f.setAccessible(true);
    			f.set(var1, var3);
    		}
    	} catch (Exception e) {
    		if (debugDisplayDetail(i)) e.printStackTrace();
    	}
    	for (Class c = var0; c != Object.class; c = c.getSuperclass()) {
    		try {
    			f = c.getDeclaredFields()[var2];
    			if (f != null) {
    				f.setAccessible(true);
    				f.set(var1, var3);
    			}
    		} catch (Exception e2) {
    			if (debugDisplayDetail(i)) e2.printStackTrace();
    		}
    	}
    }

    public static void setPrivateValue(Class var0, Object var1, String var2, Object var3) {
    	setPrivateValue(var0, var1, var2, var3, 1);
    }

    public static void setPrivateValue(Class var0, Object var1, String var2, Object var3, int i) {
    	Field f = null;
    	try {
    		if (var0 != null) f = var0.getDeclaredField(var2);
    		if (f != null) {
    			f.setAccessible(true);
    			f.set(var1, var3);
    		}
    	} catch (Exception e) {
    		if (debugDisplayDetail(i)) e.printStackTrace();
    	}
    	for (Class c = var0; c != Object.class; c = c.getSuperclass()) {
    		try {
    			f = c.getDeclaredField(var2);
    			if (f != null) {
    				f.setAccessible(true);
    				f.set(var1, var3);
    			}
    		} catch (Exception e2) {
    			if (debugDisplayDetail(i)) e2.printStackTrace();
    		}
    	}
    }

    private static boolean debugDisplay(int i) {
    	switch (i) {
    	case -1:
    		return false;
    	case 0:
    		return true;
    	case 1:
    		return debugReflectMessage;
    	}
    	return false;
    }

    private static boolean debugDisplayDetail(int i) {
    	switch (i) {
    	case -1:
    		return false;
    	case 0:
    		return true;
    	case 1:
    		return debugReflectMessageDetail;
    	}
    	return false;
    }

	private static String getFieldName(String var0) {
    	if (mod_Modchu_ModchuLib.isForge
    			&& mod_PFLM_PlayerFormLittleMaid.mod_pflm_playerformlittlemaid.playerFormLittleMaidVersion >= 151) return var0;
    	String[] s1 = {
    			"field_77110_j",
    			"func_82441_a",
    			"func_71061_d_", "func_70105_a", "field_75623_d",
    			"func_70301_a", "field_70462_a", "func_70301_a", "func_71052_bv", "field_70460_b"
    	};
    	String[] s2 = {
    			"h",
//-@-151
    			"b",
//@-@151
/*//151delete
    			"a",
*///151delete
    			"aa", "a", "d",
    			"a", "a", "a", "bL", "b"
    	};
    	for(int i = 0; i < s1.length; i++) {
    		if (s1[i].equals(var0)) return s2[i];
    	}
    	return var0;
    }
}