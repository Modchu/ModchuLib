package net.minecraft.src;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;

public class Modchu_Reflect
{
    public static boolean debugReflectMessage = true;
    public static boolean debugReflectMessageDetail = false;
    private static HashMap<String, Class> classMap = new HashMap();
    private static HashMap<String, Method> methodMap = new HashMap();
    private static HashMap<String, String> classNameMap = new HashMap();
    private static HashMap<String, String> methodNameMap = new HashMap();

    public static void setDebugMessage(boolean b) {
    	debugReflectMessage = b;
    }

    public static void setDebugMessageDetail(boolean b) {
    	debugReflectMessageDetail = b;
    }

    public static boolean copyFields(Class var0, Object var1, Object var2)
    {
    	boolean b = false;
    	Field[] ff = var0.getDeclaredFields();
    	for (int var4 = 0; var4 < ff.length; ++var4) {
    		Field f = ff[var4];
    		int var6 = f.getModifiers();
    		if (!Modifier.isStatic(var6) && !Modifier.isFinal(var6)) {
    			f.setAccessible(true);
    			setFieldObject(f, var2, getFieldObject(f, var1));
    			b = true;
    		}
    	}
    	return b;
    }

    public static boolean setFieldObject(Field var0, Object var1, Object var2)
    {
    	return setFieldObject(var0, var1, var2, 1);
    }

    public static boolean setFieldObject(Field var0, Object var1, Object var2, int i)
    {
    	try {
    		if (var0 != null) {
    			var0.set(var1, var2);
    			return true;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) printStackTrace(e);
    	}
    	return false;
    }

    public static boolean setFieldObject(String var0, String var1, Object var2)
    {
    	Class c = loadClass(var0);
    	if (c != null) return setFieldObject(c, var1, var2);
    	return false;
    }

    public static boolean setFieldObject(String var0, String var1, Object var2, int i)
    {
    	Class c = loadClass(var0);
    	if (c != null) return setFieldObject(c, var1, var2, i);
    	return false;
    }

    public static boolean setFieldObject(Class var0, String var1, Object var2)
    {
    	return setFieldObject(var0, var1, var2, 1);
    }

    public static boolean setFieldObject(Class var0, String var1, Object var2, int i)
    {
    	Field f = null;
    	try {
    		f = getField(var0, var1, i);
    		if (f != null) {
    			f.set(null, var2);
    			return true;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) printStackTrace(e);
    	}
    	return false;
    }

    public static boolean setFieldObject(String var0, String var1, String var2, Object var3)
    {
    	Class c = loadClass(var0);
    	if (c != null) return setFieldObject(c, var1, var2, var3, 1);
    	return false;
    }

    public static boolean setFieldObject(String var0, String var1, String var2, Object var3, int i)
    {
    	Class c = loadClass(var0);
    	if (c != null) return setFieldObject(c, var1, var2, var3, i);
    	return false;
    }

    public static boolean setFieldObject(Class var0, String var1, String var2, Object var3)
    {
    	return setFieldObject(var0, var1, var2, var3, 1);
    }

    public static boolean setFieldObject(Class var0, String var1, String var2, Object var3, int i)
    {
    	var1 = reflectStringSetting(var1, var2);
    	Field f = null;
    	try {
    		f = getField(var0, var1, i);
    		if (f != null) {
    			f.set(null, var3);
    			return true;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) printStackTrace(e);
    	}
    	return false;
    }

    public static boolean setFieldObject(String var0, String var1, Object var2, Object var4)
    {
    	Class c = loadClass(var0);
    	if (c != null) return setFieldObject(c, var1, var2, var4, 1);
    	return false;
    }

    public static boolean setFieldObject(String var0, String var1, Object var2, Object var4, int i)
    {
    	Class c = loadClass(var0);
    	if (c != null) return setFieldObject(c, var1, var2, var4, i);
    	return false;
    }

    public static boolean setFieldObject(Class var0, String var1, Object var2, Object var4)
    {
    	return setFieldObject(var0, var1, var2, var4, 1);
    }

    public static boolean setFieldObject(Class var0, String var1, Object var2, Object var4, int i)
    {
    	Field f = null;
    	try {
    		f = getField(var0, var1, i);
    		if (f != null) {
    			f.set(var2, var4);
    			return true;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) printStackTrace(e);
    	}
    	return false;
    }

    public static boolean setFieldObject(String var0, String var1, String var2, Object var3, Object var4)
    {
    	Class c = loadClass(var0);
    	if (c != null) return setFieldObject(c, var1, var2, var3, var4, 1);
    	return false;
    }

    public static boolean setFieldObject(String var0, String var1, String var2, Object var3, Object var4, int i)
    {
    	Class c = loadClass(var0);
    	if (c != null) return setFieldObject(c, var1, var2, var3, var4, i);
    	return false;
    }

    public static boolean setFieldObject(Class var0, String var1, String var2, Object var3, Object var4)
    {
    	return setFieldObject(var0, var1, var2, var3, var4, 1);
    }

    public static boolean setFieldObject(Class var0, String var1, String var2, Object var3, Object var4, int i)
    {
    	var1 = reflectStringSetting(var1, var2);
    	Field f = null;
    	try {
    		f = getField(var0, var1, i);
    		if (f != null) {
    			f.set(var3, var4);
    			return true;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) printStackTrace(e);
    	}
    	return false;
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
    		if (debugDisplay(i)) printStackTrace(e);
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
    		if (debugDisplay(i)) printStackTrace(e);
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
    		if (debugDisplay(i)) printStackTrace(e);
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
    		if (debugDisplay(i)) printStackTrace(e);
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
    		if (debugDisplay(i)) printStackTrace(e);
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
    		if (debugDisplay(i)) printStackTrace(e);
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
    		if (debugDisplay(i)) printStackTrace(e);
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
    		if (debugDisplay(i)) printStackTrace(e);
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
    		if (debugDisplay(i)) printStackTrace(e);
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
    		if (debugDisplay(i)) printStackTrace(e);
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
    		if (debugDisplay(i)) printStackTrace(e);
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
    	if (c != null) f = getField(c, var1, i == 1 ? 2 : i);
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
    		if (debugDisplay(i)) printStackTrace(e);
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
    		String var2 = getFieldName(var1);
    		try {
    			f = var0.getDeclaredField(var2);
    			return f;
    		} catch (Exception e2) {
    		}
    		if (debugReflectMessageDetail) Modchu_Debug.Debug("getRawField Exception getDeclaredField Class="+var0+" String="+var1);
    		try {
    			f = var0.getField(var2);
    			return f;
    		} catch (Exception e3) {
    		}
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
    					printStackTrace(e4);
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
    	method = getMethod(var0, var1, (Class[]) null, i == 1 ? 2 : i);
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
    	method = getMethod(var0, var1, var3, i == 1 ? 2 : i);
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
    		if (debugDisplay(i)) printStackTrace(e);
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
    		if (debugDisplay(i)) printStackTrace(e);
    	}
    	return method;
    }

    private static Method getRawMethod(Class var0, String var1, Class[] var2)
    {
    	return getRawMethod(var0, var1, var2, 1);
    }

    private static Method getRawMethod(Class var0, String var1, Class[] var2, int i)
    {
    	String s = var0.getName() + var1;
    	if (var2 != null) s = s + var2.toString();
    	if (methodMap.containsKey(s)) return methodMap.get(s);
    	Method method = null;
    	if (var1 != null) {
    		String var3 = getFieldName(var1);
/*
    		try {
    			if (var0 != null) method = var0.getMethod(var3, var2);
    			if (method != null) {
    				method.setAccessible(true);
    				methodMap.put(s, method);
    				return method;
    			}
    		} catch (Exception e) {
    			if (debugDisplayDetail(i)) printStackTrace(e);
    		}
*/
    		try {
    			if (var0 != null) method = var0.getDeclaredMethod(var3, var2);
    			if (method != null) {
    				method.setAccessible(true);
    				methodMap.put(s, method);
    				return method;
    			}
    		} catch (Exception e1) {
    			if (debugDisplayDetail(i)) printStackTrace(e1);
    		}
/*
    		try {
    			if (var0 != null) method = var0.getMethod(var1, var2);
    			if (method != null) {
    				method.setAccessible(true);
    				methodMap.put(s, method);
    				return method;
    			}
    		} catch (Exception e) {
    			if (debugDisplay(i)) printStackTrace(e);
    		}
*/
    		try {
    			if (var0 != null) method = var0.getDeclaredMethod(var1, var2);
    			if (method != null) {
    				method.setAccessible(true);
    				methodMap.put(s, method);
    				return method;
    			}
    		} catch (Exception e1) {
    			if (debugDisplay(i)) printStackTrace(e1);
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
    	var1 = reflectStringSetting(var1, var2);
    	Method method = getMethod(var0, var1, (Class[]) null, i);
    	return method;
    }

    public static Method getMethod(String var0, String var1, String var2, Class[] var3)
    {
    	return getMethod(var0, var1, var2, var3, 1);
    }

    public static Method getMethod(String var0, String var1, String var2, Class[] var3, int i)
    {
    	var1 = reflectStringSetting(var1, var2);
    	Method method = getMethod(var0, var1, var3, i);
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
    		if (debugDisplay(i)) printStackTrace(e);
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
    		if (debugDisplay(i)) printStackTrace(e);
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
    			if (debugDisplayDetail(i)) printStackTrace(e1);
    		}
    		try {
    			if (c != null) method = c.getMethod(var1, var2);
    		} catch (Exception e) {
    			if (debugDisplay(i)) printStackTrace(e);
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
    		if (debugDisplay(i)) printStackTrace(e);
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
    		if (debugDisplay(i)) printStackTrace(e);
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
    		if (debugDisplay(i)) printStackTrace(e);
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
    		if (debugDisplay(i)) printStackTrace(e);
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
    		if (debugDisplay(i)) printStackTrace(e);
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1, String var2)
    {
    	return invokeMethod(var0, var1, var2, 1);
    }

    public static Object invokeMethod(Class var0, String var1, String var2, int i)
    {
    	var1 = reflectStringSetting(var1, var2);
    	Method method = null;
    	try {
    		method = getMethod(var0, var1, (Class[]) null, i);
    		if (method != null) {
    			Object o = method.invoke(null);
    			return o;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) printStackTrace(e);
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
    		if (debugDisplay(i)) printStackTrace(e);
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1, String var2, Object var3)
    {
    	return invokeMethod(var0, var1, var2, var3, 1);
    }

    public static Object invokeMethod(Class var0, String var1, String var2, Object var3, int i)
    {
    	var1 = reflectStringSetting(var1, var2);
    	Method method = null;
    	try {
    		method = getMethod(var0, var1, (Class[]) null, i);
    		if (method != null) {
    			Object o = method.invoke(var3);
    			return o;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) printStackTrace(e);
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
    		if (debugDisplay(i)) printStackTrace(e);
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
    		if (debugDisplay(i)) printStackTrace(e);
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1, Class[] var2, Object ... var3)
    {
    	return invokeMethod(var0, var1, var2, null, var3, 1);
    }

    public static Object invokeMethod(Class var0, String var1, Class[] var2, Object[] var3, int i)
    {
    	return invokeMethod(var0, var1, var2, null, var3, 1);
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
    		if (debugDisplay(i)) printStackTrace(e);
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1, String var2, Class[] var3, Object var4, Object var5)
    {
    	return invokeMethod(var0, var1, var2, var3, var4, var5, 1);
    }

    public static Object invokeMethod(Class var0, String var1, String var2, Class[] var3, Object var4, Object var5, int i)
    {
    	var1 = reflectStringSetting(var1, var2);
    	Method method = null;
    	try {
    		method = getMethod(var0, var1, var3, i);
    		if (method != null) {
    			Object o = method.invoke(var4, var5);
    			return o;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) printStackTrace(e);
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1, String var2, Class[] var3, Object var4, Object ... var5)
    {
    	return invokeMethod(var0, var1, var2, var3, var4, var5, 1);
    }

    public static Object invokeMethod(Class var0, String var1, String var2, Class[] var3, Object var4, Object[] var5, int i)
    {
    	var1 = reflectStringSetting(var1, var2);
    	Method method = null;
    	try {
    		method = getMethod(var0, var1, var3, i);
    		if (method != null) {
    			Object o = method.invoke(var4, var5);
    			return o;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) printStackTrace(e);
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
    		if (debugDisplay(i)) printStackTrace(e);
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1, String var2)
    {
    	return invokeMethod(var0, var1, var2, 1);
    }

    public static Object invokeMethod(String var0, String var1, String var2, int i)
    {
    	var1 = reflectStringSetting(var1, var2);
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
    		if (debugDisplay(i)) printStackTrace(e);
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
    		if (debugDisplay(i)) printStackTrace(e);
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1, String var2, Object var3)
    {
    	return invokeMethod(var0, var1, var2, var3, 1);
    }

    public static Object invokeMethod(String var0, String var1, String var2, Object var3, int i)
    {
    	var1 = reflectStringSetting(var1, var2);
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
    		if (debugDisplay(i)) printStackTrace(e);
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
    		if (debugDisplay(i)) printStackTrace(e);
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
    		if (debugDisplay(i)) printStackTrace(e);
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1, String var2, Class[] var3, Object var4, Object var5)
    {
    	return invokeMethod(var0, var1, var2, var3, var4, var5, 1);
    }

    public static Object invokeMethod(String var0, String var1, String var2, Class[] var3, Object var4, Object var5, int i)
    {
    	var1 = reflectStringSetting(var1, var2);
    	Method method = null;
    	Class c = null;
    	try {
    		c = loadClass(var0);
    		if (c != null) method = getMethod(c, var1, var3, i);
    		if (method != null) {
    			Object o = method.invoke(var4, var5);
    			return o;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) printStackTrace(e);
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1, Class[] var2, Object ... var3)
    {
    	return invokeMethod(var0, var1, var2, null, var3, 1);
    }

    public static Object invokeMethod(String var0, String var1, Class[] var2, Object[] var3, int i)
    {
    	return invokeMethod(var0, var1, var2, null, var3, i);
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
    		if (debugDisplay(i)) printStackTrace(e);
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1, String var2, Class[] var3, Object var4, Object ... var5)
    {
    	return invokeMethod(var0, var1, var2, var3, var4, var5, 1);
    }

    public static Object invokeMethod(String var0, String var1, String var2, Class[] var3, Object var4, Object[] var5, int i)
    {
    	var1 = reflectStringSetting(var1, var2);
    	Method method = null;
    	Class c = null;
    	try {
    		c = loadClass(var0);
    		if (c != null) method = getMethod(c, var1, var3, i);
    		if (method != null) {
    			Object o = method.invoke(var4, var5);
    			return o;
    		}
    	} catch (Exception e) {
    		if (debugDisplay(i)) printStackTrace(e);
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
    	var0 = getClassName(var0);
    	if (classMap.containsKey(var0)) return classMap.get(var0);
    	try {
    		c = Class.forName(var0);
    		if (c != null) {
    			classMap.put(var0, c);
    			return c;
    		}
    	} catch (NoClassDefFoundError e) {
    		if (debugDisplay(i)) printStackTraceError(e);
    	} catch (ClassNotFoundException e) {
/*
    		if (	mod_Modchu_ModchuLib.modchu_Main.isForge) {
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
    								printStackTrace(e4);
    							}
    						}
    					}
    				}
    			} catch (NoClassDefFoundError e1) {
    				if (debugDisplay(i)) printStackTraceError(e);
    			} catch (ClassNotFoundException e2) {
    				if (debugDisplay(i)) printStackTrace(e2);
    			} catch (Exception e3) {
    				if (debugDisplay(i)) printStackTrace(e3);
    			}
    		} else
*/
    	} catch (Exception e) {
    		if (debugDisplay(i)) printStackTrace(e);
    	}
    	try {
    		c = Class.forName("net.minecraft.src."+var0);
    		if (c != null) classMap.put(var0, c);
    	} catch (NoClassDefFoundError e1) {
    		if (debugDisplayDetail(i)) printStackTraceError(e1);
    	} catch (ClassNotFoundException e1) {
    		if (debugDisplayDetail(i)) printStackTrace(e1);
    	} catch (Exception e1) {
    		if (debugDisplayDetail(i)) printStackTrace(e1);
    	}
    	return c;
    }

	public static Object newInstance(String var1)
    {
    	return newInstance(var1, null, null, 1);
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
    		if (debugDisplay(i)) printStackTrace(e);
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
    		if (debugDisplay(i)) printStackTrace(e);
    	}
    	return null;
    }

    public static Object[] newInstanceArray(String var1, int i)
    {
    	return newInstanceArray(var1, i, 1);
    }

    public static Object[] newInstanceArray(String var1, int i, int i2)
    {
    	Class c = null;
    	try {
    		c = loadClass(var1);
    		if (c != null) return (Object[]) Array.newInstance(c, i);
    	} catch (Exception e) {
    		if (debugDisplay(i2)) printStackTrace(e);
    	}
    	return null;
    }

    static Object[] newInstanceArray(Class var1, int i)
    {
    	return newInstanceArray(var1, i, 1);
    }

    public static Object[] newInstanceArray(Class var1, int i, int i2)
    {
    	Constructor constructor = null;
    	try {
    		if (var1 != null) return (Object[]) Array.newInstance(var1, i);
    	} catch (Exception e) {
    		if (debugDisplay(i2)) printStackTrace(e);
    	}
    	return null;
    }

    public static Object getPrivateValue(String var0, Object var1, int var2) {
    	Class c = loadClass(var0);
    	if (c != null) return getPrivateValue(c, var1, var2, 1);
    	return null;
    }

    public static Object getPrivateValue(String var0, Object var1, int var2, int i) {
    	Class c = loadClass(var0);
    	if (c != null) return getPrivateValue(c, var1, var2, i);
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
    		if (debugDisplayDetail(i)) printStackTrace(e);
    	}
    	for (Class c = var0; c != Object.class; c = c.getSuperclass()) {
    		try {
    			f = c.getDeclaredField(var2);
    			if (f != null) {
    				f.setAccessible(true);
    				return f.get(var1);
    			}
    		} catch (Exception e2) {
    			if (debugDisplayDetail(i)) printStackTrace(e2);
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
    		if (debugDisplayDetail(i)) printStackTrace(e);
    	}
    	for (Class c = var0; c != Object.class; c = c.getSuperclass()) {
    		try {
    			f = c.getDeclaredFields()[var2];
    			if (f != null) {
    				f.setAccessible(true);
    				f.set(var1, var3);
    			}
    		} catch (Exception e2) {
    			if (debugDisplayDetail(i)) printStackTrace(e2);
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
    		if (debugDisplayDetail(i)) printStackTrace(e);
    	}
    	for (Class c = var0; c != Object.class; c = c.getSuperclass()) {
    		try {
    			f = c.getDeclaredField(var2);
    			if (f != null) {
    				f.setAccessible(true);
    				f.set(var1, var3);
    			}
    		} catch (Exception e2) {
    			if (debugDisplayDetail(i)) printStackTrace(e2);
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
    	case 2:
    		return debugReflectMessageDetail;
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

    private static String reflectStringSetting(String var1, String var2) {
    	return mod_Modchu_ModchuLib.modchu_Main.isRelease() ? var1 : var2;
    }

    public static String getFieldName(String s) {
    	if (mod_Modchu_ModchuLib.modchu_Main.isForge
    			&& mod_Modchu_ModchuLib.modchu_Main.getMinecraftVersion() > 150) return s;
    	if (methodNameMap != null
    			&& methodNameMap.containsKey(s)) {
    		return methodNameMap.get(s);
    	}
    	if (!mod_Modchu_ModchuLib.modchu_Main.isRelease
    			&& (s.startsWith("field")
    					| (s.startsWith("func")))) Modchu_Debug.lDebug("getFieldName check out var0="+s);
    	return s;
    }

    public static String getClassName(String s) {
    	int i1 = s.indexOf("net.minecraft.src.");
    	boolean b = false;
    	if (i1 > -1) {
    		s = s.substring(i1 + 18);
    		b = true;
    	}
    	if (classNameMap != null
    			&& classNameMap.containsKey(s)) {
    		return b ? "net.minecraft.src." + classNameMap.get(s) : classNameMap.get(s);
    	}
    	return s;
    }

	private static void printStackTraceError(NoClassDefFoundError e) {
		e.printStackTrace();
		Modchu_Debug.lDebug("", null, 2, e);
	}

	private static void printStackTrace(Exception e) {
		e.printStackTrace();
		Modchu_Debug.lDebug("", null, 2, e);
	}

    public static void initNameMap() {
    	String[] s1 = {
    			"Minecraft", "AbstractClientPlayer", "EntityLivingBase", "RendererLivingEntity", "ResourceLocation",
    			"RenderEngine", "MapItemRenderer", "TextureUtil", "Resource", "ResourceManager",
    			"TextureManager",
    			"PFLM_RenderPlayer2", "PFLM_RenderPlayer", "PFLM_GuiSmallButton", "PFLM_RenderPlayerDummy", "PFLM_ItemRenderer",
    			"PFLM_ItemRendererHD", "PFLM_GuiOthersPlayerSlot", "PFLM_RenderPlayerAether"
    	};
    	String[] s2 = null;
    	if (mod_Modchu_ModchuLib.modchu_Main.isForge) {
    		switch(mod_Modchu_ModchuLib.modchu_Main.getMinecraftVersion()) {
    		case 152:
    			s2 = new String []{
    					"net.minecraft.client.Minecraft", "net.minecraft.client.entity.EntityPlayer", "net.minecraft.entity.EntityLiving", "net.minecraft.client.renderer.entity.RenderLiving", "java.lang.String",
    					"net.minecraft.client.renderer.RenderEngine","net.minecraft.client.gui.MapItemRenderer", "", "", "",
    					"net.minecraft.client.renderer.texture.TextureManager",
    					"PFLM_RenderPlayer2V1", "PFLM_RenderPlayerV1", "PFLM_GuiSmallButtonV1", "PFLM_RenderPlayerDummyV1", "PFLM_ItemRendererV1",
    					"PFLM_ItemRendererHDV1", "PFLM_GuiOthersPlayerSlotV1", ""
    			};
    			break;
    		case 162:
    			s2 = new String []{
    					"net.minecraft.client.Minecraft", "net.minecraft.client.entity.AbstractClientPlayer", "net.minecraft.entity.EntityLivingBase", "net.minecraft.client.renderer.entity.RendererLivingEntity", "net.minecraft.util.ResourceLocation",
    					"net.minecraft.client.renderer.RenderEngine","net.minecraft.client.gui.MapItemRenderer", "net.minecraft.client.renderer.texture.TextureUtil", "net.minecraft.client.resources.Resource", "net.minecraft.client.resources.ResourceManager",
    					"net.minecraft.client.renderer.texture.TextureManager",
    					"PFLM_RenderPlayer2V160", "PFLM_RenderPlayerV160", "PFLM_GuiSmallButtonV160", "PFLM_RenderPlayerDummyV160", "PFLM_ItemRendererV160",
    					"PFLM_ItemRendererHDV160", "PFLM_GuiOthersPlayerSlotV160", "PFLM_RenderPlayerAetherV160"
    			};
    			break;
    		}
    	} else if (mod_Modchu_ModchuLib.modchu_Main.isRelease) {
    		switch(mod_Modchu_ModchuLib.modchu_Main.getMinecraftVersion()) {
    		case 152:
    			s2 = new String []{
    					"net.minecraft.client.Minecraft", "sq", "ng", "bho", "java.lang.String",
    					"bge", "axi", "", "", "",
    					"biq",
    					"PFLM_RenderPlayer2V1", "PFLM_RenderPlayerV1", "PFLM_GuiSmallButtonV1", "PFLM_RenderPlayerDummyV1", "PFLM_ItemRendererV1",
    					"PFLM_ItemRendererHDV1", "PFLM_GuiOthersPlayerSlotV1", ""
    			};
    			break;
    		case 162:
    			s2 = new String []{
    					"ats", "ber", "oe", "bgy", "bjl",
    					"bge", "avs", "bim", "bjk", "bjm",
    					"bij",
    					"PFLM_RenderPlayer2V160", "PFLM_RenderPlayerV160", "PFLM_GuiSmallButtonV160", "PFLM_RenderPlayerDummyV160", "PFLM_ItemRendererV160",
    					"PFLM_ItemRendererHDV160", "PFLM_GuiOthersPlayerSlotV160", "PFLM_RenderPlayerAetherV160"
    			};
    			break;
    		}
    	} else {
    		if (mod_Modchu_ModchuLib.modchu_Main.getMinecraftVersion() > 159) {
    			s2 = new String []{
    					"Minecraft", "AbstractClientPlayer", "EntityLivingBase", "RendererLivingEntity", "ResourceLocation",
    					"RenderEngine", "MapItemRenderer", "TextureUtil", "Resource", "ResourceManager",
    					"TextureManager",
    					"PFLM_RenderPlayer2V160", "PFLM_RenderPlayerV160", "PFLM_GuiSmallButtonV160", "PFLM_RenderPlayerDummyV160", "PFLM_ItemRendererV160",
    					"PFLM_ItemRendererHDV160", "PFLM_GuiOthersPlayerSlotV160", "PFLM_RenderPlayerAetherV160"
    			};
    		}
    		else if (mod_Modchu_ModchuLib.modchu_Main.getMinecraftVersion() < 160) {
    			s2 = new String []{
    					"net.minecraft.client.Minecraft",  "EntityPlayer", "EntityLiving", "RenderLiving", "java.lang.String",
    					"RenderEngine", "MapItemRenderer", "", "", "",
    					"TextureManager",
    					"PFLM_RenderPlayer2V1", "PFLM_RenderPlayerV1", "PFLM_GuiSmallButtonV1", "PFLM_RenderPlayerDummyV1", "PFLM_ItemRendererV1",
    					"PFLM_ItemRendererHDV1", "PFLM_GuiOthersPlayerSlotV1", ""
    			};
    		}
    	}
    	if (s1 != null
    			&& s2 != null) {
    		for(int i = 0; i < s1.length; i++) {
    			classNameMap.put(s1[i], s2[i]);
    		}
    	}

    	s1 = new String []{
    			"field_77110_j",
    			"func_82441_a",
    			"func_71061_d_", "func_70105_a", "field_75623_d",
    			"func_70301_a", "field_70462_a", "func_70301_a", "func_71052_bv", "field_70460_b",
    			"field_82424_k", "func_110143_aJ", "field_70760_ar", "field_70761_aq", "field_70758_at",
    			"field_70759_as", "field_70722_aY", "field_70721_aZ", "field_70754_ba", "func_70631_g_",
    			"func_78086_a", "func_382_a", "field_70737_aN", "field_70725_aQ", "func_77033_b",
    			"func_110309_l", "field_20047_bv", "field_622_aY", "func_76984_a", "func_82150_aj",
    			"func_82241_s", "func_77105_b", "func_77102_a", "field_71442_b", "field_71460_t",
    			"field_71439_g", "field_71441_e", "field_71415_G", "field_71474_y", "field_1064_b",
    			"field_4209_q", "field_6313_p", "field_6323_f", "func_71410_x", "func_110300_d",
    			"func_110304_a", "func_110306_p", "func_110309_l", "func_110557_a", "func_76976_a",
    			"func_71391_r", "func_71356_B", "func_110138_aP", "func_110536_a", "func_110442_L",
    			"func_110776_a", "func_110623_a", "func_130087_a", "func_110577_a", "func_110432_I",
    			"func_70073_O", "field_70120_cr", "func_78350_a", "func_110434_K", "field_71412_D",
    			"func_71373_a", "field_74320_O", "func_110987_a", "field_71446_o", "func_78351_a",
    			"func_77220_a", "func_130000_a", "field_70734_aK", "func_71386_F", "func_110527_b",
    			"func_110857_a", "func_77031_a", "field_70475_c", "func_71380_b", "func_76985_a",
    			"field_71462_r", "field_71456_v", "field_73886_k", "func_71354_a", "field_71451_h",
    			"func_78745_b", "func_78064_b", "func_607_d", "field_71466_p", "field_71456_v"
    	};
    	switch(mod_Modchu_ModchuLib.modchu_Main.getMinecraftVersion()) {
    	case 152:
    		s2 = new String []{
    				"h",
    				"a",
    				"aa", "a", "d",
    				"a", "a", "a", "bL", "b",
    				"l", "aM", "az", "ay", "aB",
    				"aA", "bh", "bi", "bj", "g_",
    				"a", "a", "aW", "aZ", "b",
    				"p", "bA", "bB", "a", "ai",
    				"r", "a", "a", "b", "u",
    				"g", "e", "H", "z", "b",
    				"t", "n", "fg", "x", "d",
    				"a", "r", "p", "a", "a",
    				"r", "C", "aS", "a", "K",
    				"a", "a", "a", "a", "H",
    				"N", "cv", "a", "J", "x",
    				"a", "aa", "a", "p", "a",
    				"a", "a", "aU", "G", "b",
    				"a", "a", "h", "b", "a",
    				"s", "w", "q", "a", "h",
    				"b", "b", "d", "q", "w"
    		};
    		break;
    	case 162:
    		s2 = new String []{
    				"h",
    				"b",
    				"aa", "a", "d",
    				"a", "a", "a", "bL", "b",
    				"l", "aM", "aO", "aN", "aQ",
    				"aP", "aF", "aG", "aH", "g_",
    				"a", "a", "ay", "aB", "b",
    				"p", "bA", "bB", "a", "ai",
    				"r", "a", "a", "c", "p",
    				"h", "f", "A", "u", "b",
    				"t", "n", "g", "w", "d",
    				"a", "r", "p", "a", "a",
    				"q", "B", "aS", "a", "K",
    				"a", "a", "a", "a", "H",
    				"N", "cv", "a", "J", "x",
    				"a", "aa", "a", "p", "a",
    				"a", "a", "aU", "F", "b",
    				"a", "a", "h", "b", "a",
    				"n", "r", "l", "a", "h",
    				"b", "b", "d", "l", "r"
    		};
    		break;
    	}

    	if (s1 != null
    			&& s2 != null) {
    		for(int i = 0; i < s1.length; i++) {
    			methodNameMap.put(s1[i], s2[i]);
    		}
    	}
    }
}