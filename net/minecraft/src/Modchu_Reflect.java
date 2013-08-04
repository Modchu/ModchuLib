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

    public static void setFieldObject(String var0, String var1, Object var2)
    {
    	Class c = loadClass(var0);
    	if (c != null) setFieldObject(c, var1, var2);
    }

    public static void setFieldObject(String var0, String var1, Object var2, int i)
    {
    	Class c = loadClass(var0);
    	if (c != null) setFieldObject(c, var1, var2, i);
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

    public static void setFieldObject(String var0, String var1, String var2, Object var3)
    {
    	Class c = loadClass(var0);
    	if (c != null) setFieldObject(c, var1, var2, var3, 1);
    }

    public static void setFieldObject(String var0, String var1, String var2, Object var3, int i)
    {
    	Class c = loadClass(var0);
    	if (c != null) setFieldObject(c, var1, var2, var3, i);
    }

    public static void setFieldObject(Class var0, String var1, String var2, Object var3)
    {
    	setFieldObject(var0, var1, var2, var3, 1);
    }

    public static void setFieldObject(Class var0, String var1, String var2, Object var3, int i)
    {
    	Field f = null;
    	try {
    		f = getField(var0, var1, i == 1 ? 2 : i);
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

    public static void setFieldObject(String var0, String var1, Object var2, Object var4)
    {
    	Class c = loadClass(var0);
    	if (c != null) setFieldObject(c, var1, var2, var4, 1);
    }

    public static void setFieldObject(String var0, String var1, Object var2, Object var4, int i)
    {
    	Class c = loadClass(var0);
    	if (c != null) setFieldObject(c, var1, var2, var4, i);
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

    public static void setFieldObject(String var0, String var1, String var2, Object var3, Object var4)
    {
    	Class c = loadClass(var0);
    	if (c != null) setFieldObject(c, var1, var2, var3, var4, 1);
    }

    public static void setFieldObject(String var0, String var1, String var2, Object var3, Object var4, int i)
    {
    	Class c = loadClass(var0);
    	if (c != null) setFieldObject(c, var1, var2, var3, var4, i);
    }

    public static void setFieldObject(Class var0, String var1, String var2, Object var3, Object var4)
    {
    	setFieldObject(var0, var1, var2, var3, var4, 1);
    }

    public static void setFieldObject(Class var0, String var1, String var2, Object var3, Object var4, int i)
    {
    	Field f = null;
    	try {
    		f = getField(var0, var1, i == 1 ? 2 : i);
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
    	String s = var0.getName() + var1;
    	if (var2 != null) s = s + var2.toString();
    	if (methodMap.containsKey(s)) return methodMap.get(s);
    	Method method = null;
    	if (var1 != null) {
    		String var3 = getFieldName(var1);
    		try {
    			if (var0 != null) method = var0.getMethod(var3, var2);
    			if (method != null) {
    				methodMap.put(s, method);
    				return method;
    			}
    		} catch (Exception e) {
    			if (debugDisplayDetail(i)) e.printStackTrace();
    		}
    		try {
    			if (var0 != null) method = var0.getDeclaredMethod(var3, var2);
    			if (method != null) {
    				methodMap.put(s, method);
    				return method;
    			}
    		} catch (Exception e1) {
    			if (debugDisplayDetail(i)) e1.printStackTrace();
    		}
    		try {
    			if (var0 != null) method = var0.getMethod(var1, var2);
    			if (method != null) {
    				methodMap.put(s, method);
    				return method;
    			}
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
    	method = getMethod(var0, var2, (Class[]) null, i == 1 ? 2 : i);
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
    	method = getMethod(var0, var2, var3, i == 1 ? 2 : i);
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
    		method = getMethod(var0, var1, (Class[]) null, i == 1 ? 2 : i);
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
    		method = getMethod(var0, var1, (Class[]) null, i == 1 ? 2 : i);
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
    		method = getMethod(var0, var1, var3, i == 1 ? 2 : i);
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
    		method = getMethod(var0, var1, var3, i == 1 ? 2 : i);
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
    		if (c != null) method = getMethod(c, var1, (Class[]) null, i == 1 ? 2 : i);
    		if (method != null) {
    			Object o = method.invoke(null);
    			return o;
    		}
    	} catch (Exception ee) {
    	}
    	try {
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
    		if (c != null) method = getMethod(c, var1, (Class[]) null, i == 1 ? 2 : i);
    		if (method != null) {
    			Object o = method.invoke(var3);
    			return o;
    		}
    	} catch (Exception ee) {
    	}
    	try {
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
    		if (c != null) method = getMethod(c, var1, var3, i == 1 ? 2 : i);
    		if (method != null) {
    			Object o = method.invoke(var4, var5);
    			return o;
    		}
    	} catch (Exception ee) {
    	}
    	try {
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
    		if (c != null) method = getMethod(c, var1, var3, i == 1 ? 2 : i);
    		if (method != null) {
    			Object o = method.invoke(var4, var5);
    			return o;
    		}
    	} catch (Exception ee) {
    		if (debugDisplayDetail(i)) ee.printStackTrace();
    	}
    	try {
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
    	var0 = getClassName(var0);
    	if (classMap.containsKey(var0)) return classMap.get(var0);
    	try {
    		c = Class.forName(var0);
    		if (c != null) {
    			classMap.put(var0, c);
    			return c;
    		}
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
    		if (c != null) classMap.put(var0, c);
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
    		if (debugDisplay(i2)) e.printStackTrace();
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
    		if (debugDisplay(i2)) e.printStackTrace();
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

    private static String getFieldName(String var0) {
    	if (mod_Modchu_ModchuLib.isForge
    			&& mod_Modchu_ModchuLib.mod_modchu_modchulib.modchuLibVersion >= 151) return var0;
    	String[] s1 = {
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
    			"func_110304_a", "func_110306_p", "func_110309_l", "func_110557_a", "func_76976_a"
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
    			"a", "a", "a", "bL", "b",
    			"l", "aM", "aO", "aN", "aQ",
    			"aP", "aF", "aG", "aH", "g_",
    			"a", "a", "ay", "aB", "b",
    			"p", "bA", "bB", "a", "ai",
    			"r", "a", "a", "c", "p",
    			"h", "f", "A", "u", "b",
    			"t", "n", "g", "w", "d",
    			"a", "r", "p", "a", "a"
    	};
    	for(int i = 0; i < s1.length; i++) {
    		if (s1[i].equals(var0)) return s2[i];
    	}
    	return var0;
    }

    private static String getClassName(String s) {
    	String[] s1 = {
    			"Minecraft", "AbstractClientPlayer", "EntityLivingBase", "RendererLivingEntity", "ResourceLocation"
    	};
    	String[] s2 = null;
		if (mod_Modchu_ModchuLib.isForge
    			&& mod_Modchu_ModchuLib.mod_modchu_modchulib.modchuLibVersion >= 151) {
			s2 = new String []{
					"net.minecraft.client.Minecraft", "net.minecraft.client.entity.AbstractClientPlayer", "net.minecraft.entity.EntityLivingBase", "net.minecraft.client.renderer.entity.RendererLivingEntity", "net.minecraft.util.ResourceLocation"
			};
		} else if (mod_Modchu_ModchuLib.isRelease) {
			switch(mod_Modchu_ModchuLib.getModchuLibVersion()) {
    		case 162:
    			s2 = new String []{
    					"ats", "ber", "oe", "bgy", "bjl"
    			};
    			break;
    		}
    	} else {
    		if (mod_Modchu_ModchuLib.getModchuLibVersion() < 160) {
    			s2 = new String []{
    					"net.minecraft.client.Minecraft",  "EntityPlayer", "EntityLiving", "RendererLiving", ""
    			};
    		}
    	}
    	if (s1 != null
    			&& s2 != null) {
    		for(int i = 0; i < s1.length; i++) {
    			if (s1[i].equals(s)) {
    				return s2[i];
    			}
    		}
    	}
    	return s;
    }
}