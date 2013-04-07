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
    	setFieldObject(var0, var1, var2, debugReflectMessage);
    }

    public static void setFieldObject(Field var0, Object var1, Object var2, boolean b)
    {
    	try {
    		if (var0 != null) var0.set(var1, var2);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    }

    public static void setFieldObject(Class var0, String var1, Object var2)
    {
    	setFieldObject(var0, var1, var2, debugReflectMessage);
    }

    public static void setFieldObject(Class var0, String var1, Object var2, boolean b)
    {
    	Field field = null;
    	try {
    		field = getField(var0, var1, b);
    		if (field != null) field.set(null, var2);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    }

    public static void setFieldObject(Class var0, String var1, String var2, Object var3)
    {
    	setFieldObject(var0, var1, var2, var3, debugReflectMessage);
    }

    public static void setFieldObject(Class var0, String var1, String var2, Object var3, boolean b)
    {
    	Field field = null;
    	try {
    		field = getField(var0, var1, b);
    		if (field != null) field.set(null, var3);
    	} catch (Exception e) {
    		try {
    			field = getField(var0, var2, b);
    			if (field != null) field.set(null, var3);
    		} catch (Exception e1) {
    			if (b) e1.printStackTrace();
    		}
    	}
    }

    public static void setFieldObject(Class var0, String var1, Object var2, Object var4)
    {
    	setFieldObject(var0, var1, var2, var4, debugReflectMessage);
    }

    public static void setFieldObject(Class var0, String var1, Object var2, Object var4, boolean b)
    {
    	Field field = null;
    	try {
    		field = getField(var0, var1, b);
    		if (field != null) field.set(var2, var4);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    }

    public static void setFieldObject(Class var0, String var1, String var2, Object var3, Object var4)
    {
    	setFieldObject(var0, var1, var2, var3, var4, debugReflectMessage);
    }

    public static void setFieldObject(Class var0, String var1, String var2, Object var3, Object var4, boolean b)
    {
    	Field field = null;
    	try {
    		field = getField(var0, var1, b);
    		if (field != null) field.set(var3, var4);
    	} catch (Exception e) {
    		try {
    			field = getField(var0, var2, b);
    			if (field != null) field.set(var3, var4);
    		} catch (Exception e1) {
    			if (b) e1.printStackTrace();
    		}
    	}
    }

    public static Object getFieldObject(Field var0, Object var1)
    {
    	return getFieldObject(var0, var1, debugReflectMessage);
    }

    public static Object getFieldObject(Field var0, Object var1, boolean b)
    {
    	try {
    		if (var0 != null) return var0.get(var1);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return null;
    }

    public static Object getFieldObject(Class var0, Object var1)
    {
    	return getFieldObject(var0, var1, debugReflectMessage);
    }

    public static Object getFieldObject(Class var0, Object var1, boolean b)
    {
    	Field field = null;
    	try {
    		field = getField(var0, null, b);
    		if (field != null) return field.get(var1);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return null;
    }

    public static Object getFieldObject(Class var0, String var1)
    {
    	return getFieldObject(var0, var1, debugReflectMessage);
    }

    public static Object getFieldObject(Class var0, String var1, boolean b)
    {
    	Field field = null;
    	try {
    		field = getField(var0, var1, b);
    		if (field != null) return field.get(null);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return null;
    }

    public static Object getFieldObject(Class var0, String var1, String var2)
    {
    	return getFieldObject(var0, var1, var2, debugReflectMessage);
    }

    public static Object getFieldObject(Class var0, String var1, String var2, boolean b)
    {
    	Field field = null;
    	try {
    		field = getField(var0, var1, var2, b);
    		if (field != null) return field.get(null);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return null;
    }

    public static Object getFieldObject(Class var0, String var1, Object var2)
    {
    	return getFieldObject(var0, var1, var2, debugReflectMessage);
    }

    public static Object getFieldObject(Class var0, String var1, Object var2, boolean b)
    {
    	Field field = null;
    	try {
    		field = getField(var0, var1, b);
    		if (field != null) return field.get(var2);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return null;
    }

    public static Object getFieldObject(Class var0, String var1, String var2, Object var3)
    {
    	return getFieldObject(var0, var1, var2, var3, debugReflectMessage);
    }

    public static Object getFieldObject(Class var0, String var1, String var2, Object var3, boolean b)
    {
    	Field field = null;
    	try {
    		field = getField(var0, var1, var2, b);
    		if (field != null) return field.get(var3);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return null;
    }

    public static Object getFieldObject(String var0, String var1, String var2)
    {
    	return getFieldObject(var0, var1, var2, debugReflectMessage);
    }

    public static Object getFieldObject(String var0, String var1, String var2, boolean b)
    {
    	Field field = null;
    	try {
    		field = getField(var0, var1, var2, b);
    		if (field != null) return field.get(null);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return null;
    }

    public static Object getFieldObject(String var0, String var1, Object var2)
    {
    	return getFieldObject(var0, var1, var2, debugReflectMessage);
    }

    public static Object getFieldObject(String var0, String var1, Object var2, boolean b)
    {
    	Field field = null;
    	Class c = null;
    	try {
    		c = loadClass(var0, b);
    		if (c != null) field = getField(c, var1, b);
    		if (field != null) return field.get(var2);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return null;
    }

    public static Object getFieldObject(String var0, String var1)
    {
    	return getFieldObject(var0, var1, debugReflectMessage);
    }

    public static Object getFieldObject(String var0, String var1, boolean b)
    {
    	Field field = null;
    	Class c = null;
    	try {
    		c = loadClass(var0, b);
    		if (c != null) field = getField(c, var1, b);
    		if (field != null) return field.get(null);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return null;
    }

    public static Object getFieldObject(String var0, String var1, String var2, Object var3)
    {
    	return getFieldObject(var0, var1, var2, var3, debugReflectMessage);
    }

    public static Object getFieldObject(String var0, String var1, String var2, Object var3, boolean b)
    {
    	Field field = null;
    	Class c = null;
    	try {
    		c = loadClass(var0);
    		if (c != null) field = getField(c, var1, var2, b);
    		if (field != null) return field.get(var3);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return null;
    }

    public static Field getField(Class var0, String var1, String var2) {
    	return getField(var0, var1, var2, debugReflectMessage);
    }

    public static Field getField(Class var0, String var1, String var2, boolean b) {
    	Field field = getField(var0, var1, b);
    	if (field != null) return field;
    	return getField(var0, var2, b);
    }

    public static Field getField(Class var0, String var1)
    {
    	return getField(var0, var1, debugReflectMessageDetail);
    }

    public static Field getField(Class var0, String var1, boolean b)
    {
    	Field var4 = null;
    	try {
    		var4 = getRawField(var0, var1, b);
    		if (var4 != null) var4.setAccessible(true);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return var4;
    }

    public static Field getField(String var0, String var1, String var2) {
    	Field field = null;
    	Class c = loadClass(var0);
    	if (c != null) field = getField(c, var1, debugReflectMessageDetail);
    	if (field != null) return field;
    	return getField(var0, var2, debugReflectMessageDetail);
    }

    public static Field getField(String var0, String var1, String var2, boolean b) {
    	Field field = null;
    	Class c = loadClass(var0);
    	if (c != null) field = getField(c, var1, b);
    	if (field != null) return field;
    	return getField(var0, var2, b);
    }

    public static Field getField(String var0, String var1)
    {
    	return getField(var0, var1, debugReflectMessageDetail);
    }

    public static Field getField(String var0, String var1, boolean b)
    {
    	Field field = null;
    	try {
    		field = getRawField(loadClass(var0), var1, b);
    		if (field != null) field.setAccessible(true);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return field;
    }

    private static Field getRawField(Class var0, String var1)
    {
    	return getRawField(var0, var1, debugReflectMessageDetail);
    }

    private static Field getRawField(Class var0, String var1, boolean b)
    {
    	if (var1 != null
    			&& var0 != null) {
    		try {
    			return var0.getDeclaredField(var1);
    		} catch (Exception e1) {
    			if (debugReflectMessageDetail) Modchu_Debug.Debug("getRawField Exception getDeclaredField Class="+var0+" String="+var1);
    			try {
    				return var0.getField(var1);
    			} catch (Exception e) {
    				try {
    					if (	!mod_Modchu_ModchuLib.isForge) var1 = getFieldName(var1);
    					return var0.getDeclaredField(var1);
    				} catch (Exception e2) {
    					if (debugReflectMessageDetail) Modchu_Debug.Debug("getRawField Exception getDeclaredField Class="+var0+" String="+var1);
    					try {
    						return var0.getField(var1);
    					} catch (Exception e3) {
    						if (debugReflectMessageDetail) Modchu_Debug.Debug("getRawField Exception getField Class="+var0+" String="+var1);
    						Field f = null;
    						for (Class c = var0; c != Object.class; c = c.getSuperclass()) {
    							try {
    								if (c != null) f = c.getDeclaredField(var1);
    								if (f != null) f.setAccessible(true);
    								return f;
    							} catch (Exception e4) {
    								if (debugReflectMessageDetail) {
    									Modchu_Debug.Debug("getRawField Exception Class="+c+" String="+var1);
    									e4.printStackTrace();
    								}
    							}
    						}
    					}
    				}
    			}
    		}
    	}
    	return null;
    }

    public static Method getMethod(Class var0, String var1, String var2)
    {
    	return getMethod(var0, var1, var2, debugReflectMessage);
    }

    public static Method getMethod(Class var0, String var1, String var2, boolean b)
    {
    	Method method = null;
    	method = getMethod(var0, var1, (Class[]) null, b);
    	if (method != null) return method;
    	return getMethod(var0, var2, (Class[]) null, b);
    }

    public static Method getMethod(Class var0, String var1, String var2, Class[] var3)
    {
    	Method method = null;
    	method = getMethod(var0, var1, var3, debugReflectMessage);
    	if (method != null) return method;
    	return getMethod(var0, var2, var3, debugReflectMessage);
    }

    public static Method getMethod(Class var0, String var1, String var2, Class[] var3, boolean b)
    {
    	Method method = null;
    	method = getMethod(var0, var1, var3, b);
    	if (method != null) return method;
    	return getMethod(var0, var2, var3, b);
    }

    public static Method getMethod(Class var0, String var1)
    {
    	return getMethod(var0, var1, debugReflectMessage);
    }

    public static Method getMethod(Class var0, String var1, boolean b)
    {
    	Method method = null;
    	try {
    		method = getRawMethod(var0, var1, null, b);
    		if (method != null) method.setAccessible(true);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return method;
    }

    public static Method getMethod(Class var0, String var1, Class[] var2)
    {
    	return getMethod(var0, var1, var2, debugReflectMessageDetail);
    }

    public static Method getMethod(Class var0, String var1, Class[] var2, boolean b)
    {
    	Method method = null;
    	try {
    		method = getRawMethod(var0, var1, var2, b);
    		if (method != null) method.setAccessible(true);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return method;
    }

    private static Method getRawMethod(Class var0, String var1, Class[] var2)
    {
    	return getRawMethod(var0, var1, var2, debugReflectMessageDetail);
    }

    private static Method getRawMethod(Class var0, String var1, Class[] var2, boolean b)
    {
    	if (var1 != null) {
    		try {
    			if (var0 != null) return var0.getDeclaredMethod(var1, var2);
    		} catch (Exception e1) {
    			try {
    				if (var0 != null) return var0.getMethod(var1, var2);
    			} catch (Exception e) {
    				if (b) e.printStackTrace();
    			}
    		}
    	}
    	return null;
    }

    public static Method getMethod(String var0, String var1, String var2)
    {
    	return getMethod(var0, var1, var2, debugReflectMessage);
    }

    public static Method getMethod(String var0, String var1, String var2, boolean b)
    {
    	Method method = null;
    	method = getMethod(var0, var2, (Class[]) null, b);
    	if (method != null) return method;
    	return getMethod(var0, var1, (Class[]) null, b);
    }

    public static Method getMethod(String var0, String var1, String var2, Class[] var3)
    {
    	return getMethod(var0, var1, var2, var3, debugReflectMessage);
    }

    public static Method getMethod(String var0, String var1, String var2, Class[] var3, boolean b)
    {
    	Method method = null;
    	method = getMethod(var0, var2, var3, b);
    	if (method != null) return method;
    	return getMethod(var0, var1, var3, b);
    }

    public static Method getMethod(String var0, String var1)
    {
    	return getMethod(var0, var1, debugReflectMessage);
    }

    public static Method getMethod(String var0, String var1, boolean b)
    {
    	Method method = null;
    	try {
    		method = getRawMethod(var0, var1, null, b);
    		if (method != null) method.setAccessible(true);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return method;
    }

    public static Method getMethod(String var0, String var1, Class[] var2)
    {
    	return getMethod(var0, var1, var2, debugReflectMessageDetail);
    }

    public static Method getMethod(String var0, String var1, Class[] var2, boolean b)
    {
    	Method method = null;
    	try {
    		method = getRawMethod(var0, var1, var2, b);
    		if (method != null) method.setAccessible(true);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return method;
    }

    private static Method getRawMethod(String var0, String var1, Class[] var2)
    {
    	return getRawMethod(var0, var1, var2, debugReflectMessageDetail);
    }

    private static Method getRawMethod(String var0, String var1, Class[] var2, boolean b)
    {
    	Class c = null;
    	if (var1 != null) {
    		try {
    	    	c = loadClass(var0, b);
    			if (c != null) return c.getDeclaredMethod(var1, var2);
    		} catch (Exception e1) {
    			try {
    				c = loadClass(var0, b);
        			if (c != null) return c.getMethod(var1, var2);
    			} catch (Exception e) {
    				if (b) e.printStackTrace();
    	   		}
    		}
    	}
    	return null;
    }

    public static Object invoke(Method var0)
    {
    	return invoke(var0, debugReflectMessage);
    }

    public static Object invoke(Method var0, boolean b)
    {
    	try {
    		if (var0 != null) return var0.invoke(null);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invoke(Method var0, Object var1)
    {
    	return invoke(var0, var1, debugReflectMessage);
    }

    public static Object invoke(Method var0, Object var1, boolean b)
    {
    	try {
    		if (var0 != null) return var0.invoke(var1);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invoke(Method var0, Object var1, Object var2)
    {
    	return invoke(var0, var1, var2, debugReflectMessage);
    }

    public static Object invoke(Method var0, Object var1, Object var2, boolean b)
    {
    	try {
    		if (var0 != null) return var0.invoke(var1, var2);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invoke(Method var0, Object var1, Object ... var2)
    {
    	return invoke(var0, var1, var2, debugReflectMessage);
    }

    public static Object invoke(Method var0, Object var1, Object[] var2, boolean b)
    {
    	try {
    		if (var0 != null) return var0.invoke(var1, (Object) var2);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1)
    {
    	return invokeMethod(var0, var1, debugReflectMessage);
    }

    public static Object invokeMethod(Class var0, String var1, boolean b)
    {
    	Method method = null;
    	try {
    		method = getMethod(var0, var1, (Class[]) null, b);
    		if (method != null) return method.invoke(null);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1, String var2)
    {
    	return invokeMethod(var0, var1, var2, debugReflectMessage);
    }

    public static Object invokeMethod(Class var0, String var1, String var2, boolean b)
    {
    	Method method = null;
    	try {
    		method = getMethod(var0, var1, (Class[]) null, b);
    		if (method != null) return method.invoke(null);
    	} catch (Exception ee) {
    		try {
    			method = getMethod(var0, var2, (Class[]) null, b);
    			if (method != null) return method.invoke(null);
    		} catch (Exception e) {
    			if (b) e.printStackTrace();
    		}
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1, Object var3)
    {
    	return invokeMethod(var0, var1, var3, debugReflectMessage);
    }

    public static Object invokeMethod(Class var0, String var1, Object var3, boolean b)
    {
    	Method method = null;
    	try {
    		method = getMethod(var0, var1, (Class[]) null, b);
    		if (method != null) return method.invoke(var3);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1, String var2, Object var3)
    {
    	return invokeMethod(var0, var1, var2, var3, debugReflectMessage);
    }

    public static Object invokeMethod(Class var0, String var1, String var2, Object var3, boolean b)
    {
    	Method method = null;
    	try {
    		method = getMethod(var0, var1, (Class[]) null, b);
    		if (method != null) return method.invoke(var3);
    	} catch (Exception ee) {
    		try {
    			method = getMethod(var0, var2, (Class[]) null, b);
    			if (method != null) return method.invoke(var3);
    		} catch (Exception e) {
    			if (b) e.printStackTrace();
    		}
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1, Object var3, Object var4)
    {
    	return invokeMethod(var0, var1, var3, var4, debugReflectMessage);
    }

    public static Object invokeMethod(Class var0, String var1, Object var3, Object var4, boolean b)
    {
    	Method method = null;
    	try {
    		method = getMethod(var0, var1, (Class[]) null, b);
    		if (method != null) return method.invoke(var3, var4);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1, Class[] var2, Object var3, Object var4)
    {
    	return invokeMethod(var0, var1, var2, var3, var4, debugReflectMessage);
    }

    public static Object invokeMethod(Class var0, String var1, Class[] var2, Object var3, Object var4, boolean b)
    {
    	Method method = null;
    	try {
    		method = getMethod(var0, var1, var2, b);
    		if (method != null) return method.invoke(var3, var4);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1, Class[] var2, Object var3, Object ... var4)
    {
    	return invokeMethod(var0, var1, var2, var3, var4, debugReflectMessage);
    }

    public static Object invokeMethod(Class var0, String var1, Class[] var2, Object var3, Object[] var4, boolean b)
    {
    	Method method = null;
    	try {
    		method = getMethod(var0, var1, var2, b);
    		if (method != null) return method.invoke(var3, var4);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1, String var2, Class[] var3, Object var4, Object var5)
    {
    	return invokeMethod(var0, var1, var2, var3, var4, var5, debugReflectMessage);
    }

    public static Object invokeMethod(Class var0, String var1, String var2, Class[] var3, Object var4, Object var5, boolean b)
    {
    	Method method = null;
    	try {
    		method = getMethod(var0, var1, var3, b);
    		if (method != null) return method.invoke(var4, var5);
    	} catch (Exception ee) {
    		try {
    			method = getMethod(var0, var2, var3, b);
    			if (method != null) return method.invoke(var4, var5);
    		} catch (Exception e) {
    			if (b) e.printStackTrace();
    		}
    	}
    	return null;
    }

    public static Object invokeMethod(Class var0, String var1, String var2, Class[] var3, Object var4, Object ... var5)
    {
    	return invokeMethod(var0, var1, var2, var3, var4, var5, debugReflectMessage);
    }

    public static Object invokeMethod(Class var0, String var1, String var2, Class[] var3, Object var4, Object[] var5, boolean b)
    {
    	Method method = null;
    	try {
    		method = getMethod(var0, var1, var3, b);
    		if (method != null) return method.invoke(var4, var5);
    	} catch (Exception ee) {
    		try {
    			method = getMethod(var0, var2, var3, b);
    			if (method != null) return method.invoke(var4, var5);
    		} catch (Exception e) {
    			if (b) e.printStackTrace();
    		}
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1)
    {
    	return invokeMethod(var0, var1, debugReflectMessage);
    }

    public static Object invokeMethod(String var0, String var1, boolean b)
    {
    	Method method = null;
    	Class c = null;
    	try {
    		c = loadClass(var0);
    		if (c != null) method = getMethod(c, var1, (Class[]) null, b);
    		if (method != null) return method.invoke(null);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1, String var2)
    {
    	return invokeMethod(var0, var1, var2, debugReflectMessage);
    }

    public static Object invokeMethod(String var0, String var1, String var2, boolean b)
    {
    	Method method = null;
    	Class c = null;
    	try {
    		c = loadClass(var0);
    		if (c != null) method = getMethod(c, var1, (Class[]) null, b);
    		if (method != null) return method.invoke(null);
    	} catch (Exception ee) {
    		try {
    			c = loadClass(var0);
    			if (c != null) method = getMethod(c, var2, (Class[]) null, b);
    			if (method != null) return method.invoke(null);
    		} catch (Exception e) {
    			if (b) e.printStackTrace();
    		}
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1, Object var3)
    {
    	return invokeMethod(var0, var1, var3, debugReflectMessage);
    }

    public static Object invokeMethod(String var0, String var1, Object var3, boolean b)
    {
    	Method method = null;
    	Class c = null;
    	try {
    		c = loadClass(var0);
    		if (c != null) method = getMethod(c, var1, (Class[]) null, b);
    		if (method != null) return method.invoke(var3);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1, String var2, Object var3)
    {
    	return invokeMethod(var0, var1, var2, var3, debugReflectMessage);
    }

    public static Object invokeMethod(String var0, String var1, String var2, Object var3, boolean b)
    {
    	Method method = null;
    	Class c = null;
    	try {
    		c = loadClass(var0);
    		if (c != null) method = getMethod(c, var1, (Class[]) null, b);
    		if (method != null) return method.invoke(var3);
    	} catch (Exception ee) {
    		try {
    			c = loadClass(var0);
    			if (c != null) method = getMethod(c, var2, (Class[]) null, b);
    			if (method != null) return method.invoke(var3);
    		} catch (Exception e) {
    			if (b) e.printStackTrace();
    		}
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1, Object var3, Object var4)
    {
    	return invokeMethod(var0, var1, var3, var4, debugReflectMessage);
    }

    public static Object invokeMethod(String var0, String var1, Object var3, Object var4, boolean b)
    {
    	Method method = null;
    	Class c = null;
    	try {
    		c = loadClass(var0);
    		if (c != null) method = getMethod(c, var1, (Class[]) null, b);
    		if (method != null) return method.invoke(var3, var4);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1, Class[] var2, Object var3, Object var4)
    {
    	return invokeMethod(var0, var1, var2, var3, var4, debugReflectMessage);
    }

    public static Object invokeMethod(String var0, String var1, Class[] var2, Object var3, Object var4, boolean b)
    {
    	Method method = null;
    	Class c = null;
    	try {
    		c = loadClass(var0);
    		if (c != null) method = getMethod(c, var1, var2, b);
    		if (method != null) return method.invoke(var3, var4);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1, String var2, Class[] var3, Object var4, Object var5)
    {
    	return invokeMethod(var0, var1, var2, var3, var4, var5, debugReflectMessage);
    }

    public static Object invokeMethod(String var0, String var1, String var2, Class[] var3, Object var4, Object var5, boolean b)
    {
    	Method method = null;
    	Class c = null;
    	try {
    		c = loadClass(var0);
    		if (c != null) method = getMethod(c, var1, var3, b);
    		if (method != null) return method.invoke(var4, var5);
    	} catch (Exception ee) {
    		try {
    			c = loadClass(var0);
    			if (c != null) method = getMethod(c, var2, var3, b);
    			if (method != null) return method.invoke(var4, var5);
    		} catch (Exception e) {
    			if (b) e.printStackTrace();
    		}
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1, Class[] var2, Object var3, Object ... var4)
    {
    	return invokeMethod(var0, var1, var2, var3, var4, debugReflectMessage);
    }

    public static Object invokeMethod(String var0, String var1, Class[] var2, Object var3, Object[] var4, boolean b)
    {
    	Method method = null;
    	Class c = null;
    	try {
    		c = loadClass(var0);
    		if (c != null) method = getMethod(c, var1, var2, b);
    		if (method != null) return method.invoke(var3, var4);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return null;
    }

    public static Object invokeMethod(String var0, String var1, String var2, Class[] var3, Object var4, Object ... var5)
    {
    	return invokeMethod(var0, var1, var2, var3, var4, var5, debugReflectMessage);
    }

    public static Object invokeMethod(String var0, String var1, String var2, Class[] var3, Object var4, Object[] var5, boolean b)
    {
    	Method method = null;
    	Class c = null;
    	try {
    		c = loadClass(var0);
    		if (c != null) method = getMethod(c, var1, var3, b);
    		if (method != null) return method.invoke(var4, var5);
    	} catch (Exception ee) {
    		try {
    			c = loadClass(var0);
    			if (c != null) method = getMethod(c, var2, var3, b);
    			if (method != null) return method.invoke(var4, var5);
    		} catch (Exception e) {
    			if (b) e.printStackTrace();
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
    	} catch (ClassNotFoundException e) {
    		if (	mod_Modchu_ModchuLib.isForge) {
    			try {
    				if (b) Modchu_Debug.Debug("loadClass classString="+var0);
    				Object o = getPrivateValue(Class.forName("cpw.mods.fml.relauncher.FMLRelauncher"), null, "INSTANCE");
    				if (b) Modchu_Debug.Debug("loadClass FMLRelauncher o="+(o != null));
    				o = getPrivateValue(o.getClass(), o, "classLoader");
    				if (b) Modchu_Debug.Debug("loadClass classLoader o="+(o != null));
    				try {
    					c = (Class) invokeMethod(o.getClass(), "findClass", new Class[]{ String.class }, o, new Object[]{ var0 });
    				} catch (Exception e3) {
    					try {
    						c = (Class) invokeMethod(o.getClass(), "findClass", new Class[]{ String.class }, o, new Object[]{ "net.minecraft.src."+var0 });
    					} catch (Exception e4) {
    						if (b) {
    							Modchu_Debug.Debug("loadClass Exception classString=net.minecraft.src."+var0);
    							e4.printStackTrace();
    						}
    					}
    				}
    			} catch (NoClassDefFoundError e1) {
    				if (b) e.printStackTrace();
    			} catch (ClassNotFoundException e2) {
    				if (b) e2.printStackTrace();
    			} catch (Exception e3) {
    				if (b) e3.printStackTrace();
    			}
    		} else
    		try {
    			c = Class.forName("net.minecraft.src."+var0);
    		} catch (NoClassDefFoundError e1) {
    			if (b) e1.printStackTrace();
    		} catch (ClassNotFoundException e1) {
    			if (b) e1.printStackTrace();
    		} catch (Exception e1) {
    			if (b) e1.printStackTrace();
    		}
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return c;
    }

    public static Object newInstance(String var1, Class[] var2, Object[] var3)
    {
    	return newInstance(var1, var2, var3, debugReflectMessage);
    }

    public static Object newInstance(String var1, Class[] var2, Object[] var3, boolean b)
    {
    	Class c = null;
    	Constructor constructor = null;
    	try {
    		c = loadClass(var1);
    		if (c != null) constructor = c.getConstructor(var2);
    		if (constructor != null) return constructor.newInstance(var3);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return null;
    }

    public static Object newInstance(Class var1, Class[] var2, Object[] var3)
    {
    	return newInstance(var1, var2, var3, debugReflectMessage);
    }

    public static Object newInstance(Class var1, Class[] var2, Object[] var3, boolean b)
    {
    	Class c = var1;
    	Constructor constructor = null;
    	try {
    		if (c != null) constructor = c.getConstructor(var2);
    		if (constructor != null) return constructor.newInstance(var3);
    	} catch (Exception e) {
    		if (b) e.printStackTrace();
    	}
    	return null;
    }

    public static Object getPrivateValue(Class var0, Object var1, int var2) {
    	return getPrivateValue(var0, var1, var2, debugReflectMessageDetail);
    }

    public static Object getPrivateValue(Class var0, Object var1, int var2, boolean b) {
    	Field field = null;
    	try {
    		if (var0 != null) field = var0.getDeclaredFields()[var2];
    		if (field != null) {
    			field.setAccessible(true);
    			return field.get(var1);
    		}
    	} catch (Exception var4) {
    		if (b) var4.printStackTrace();
    	}
    	return null;
    }

    public static Object getPrivateValue(Class var0, Object var1, String var2) {
    	return getPrivateValue(var0, var1, var2, debugReflectMessageDetail);
    }

    public static Object getPrivateValue(Class var0, Object var1, String var2, boolean b) {
    	Field field = null;
    	try {
    		if (var0 != null) field = var0.getDeclaredField(var2);
    		if (field != null) {
    			field.setAccessible(true);
    			return field.get(var1);
    		}
    	} catch (Exception var4) {
    		for (Class c = var0; c != Object.class; c = c.getSuperclass()) {
    			try {
    				field = c.getDeclaredField(var2);
    				if (field != null) {
    					field.setAccessible(true);
    					return field.get(var1);
    				}
    			} catch (Exception e2) {
    				if (b) e2.printStackTrace();
    			}
    		}
    	}
    	return null;
    }

    public static void setPrivateValue(Class var0, Object var1, int var2, Object var3) {
    	setPrivateValue(var0, var1, var2, var3, debugReflectMessageDetail);
    }

    public static void setPrivateValue(Class var0, Object var1, int var2, Object var3, boolean b) {
    	Field field = null;
    	try {
    		if (var0 != null) field = var0.getDeclaredFields()[var2];
    		if (field != null) {
    			field.setAccessible(true);
    			field.set(var1, var3);
    		}
    	} catch (Exception var6) {
    		for (Class c = var0; c != Object.class; c = c.getSuperclass()) {
    			try {
    				field = c.getDeclaredFields()[var2];
    				if (field != null) {
    					field.setAccessible(true);
    					field.set(var1, var3);
    				}
    			} catch (Exception e2) {
    				if (b) e2.printStackTrace();
    			}
    		}
    	}
    }

    public static void setPrivateValue(Class var0, Object var1, String var2, Object var3) {
    	setPrivateValue(var0, var1, var2, var3, debugReflectMessageDetail);
    }

    public static void setPrivateValue(Class var0, Object var1, String var2, Object var3, boolean b) {
    	Field field = null;
    	try {
    		if (var0 != null) field = var0.getDeclaredField(var2);
    		if (field != null) {
    			field.setAccessible(true);
    			field.set(var1, var3);
    		}
    	} catch (Exception var6) {
    		for (Class c = var0; c != Object.class; c = c.getSuperclass()) {
    			try {
    				field = c.getDeclaredField(var2);
    				if (field != null) {
    					field.setAccessible(true);
    					field.set(var1, var3);
    				}
    			} catch (Exception e2) {
    				if (b) e2.printStackTrace();
    			}
    		}
    	}
    }

    private static String getFieldName(String var0) {
    	String[] s1 = {
    			"field_77110_j", "func_82441_a", "func_71061_d_", "func_70105_a", "field_75623_d",
    			"func_70301_a", "field_70462_a", "func_70301_a", "func_71052_bv", "field_70460_b"
    	};
    	String[] s2 = {
    			"h", "a", "aa", "a", "d",
    			"a", "a", "a", "bL", "b"
    	};
    	for(int i = 0; i < s1.length; i++) {
    		if (s1[i].equals(var0)) return s2[i];
    	}
    	return var0;
    }
}