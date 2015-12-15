package modchu.lib;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Modchu_Init {
	public static boolean initFlag = false;

	public static void init() {
		//System.out.println("Modchu_Init init");
		if (initFlag) return;
		initFlag = true;
		String mcVersion = getMcVersion();
		//System.out.println("Modchu_Init init mcVersion="+mcVersion);
		if (mcVersion != null); else {
			String s = "ModchuLib Modchu_Init mcVersion null error !!";
			throw new RuntimeException(s);
		}
		int versionInt = getVersionStringToMinecraftVersionInt(mcVersion);
		new Modchu_Version(versionInt, mcVersion);
		String minecraftVersionString = Modchu_Version.getMinecraftVersionString();
		if (!mcVersion.equals(minecraftVersionString)
				&& mcVersion.indexOf(minecraftVersionString) < 0) {
/*
			if (!(minecraftVersionString.equals("1.6.4")
					| minecraftVersionString.equals("1.7.2")
					&& mcVersion.equals("1.6"))) {
*/
				String s = "ModchuLib Minecraft adaptation version error !! mcVersion="+mcVersion+" Modchu_Version.getMinecraftVersionString()="+Modchu_Version.getMinecraftVersionString();
				Modchu_Main.setRuntimeException(s);
				throw new RuntimeException(s);
			//}
		}
		Modchu_Main.init();
		Modchu_AS.instanceCheck();
		Modchu_Debug.lDebug("(1 / 3) - (1 / 5) Modchu_Init init()");
		//対応MOD導入チェック class直チェック
		HashMap<String, Boolean> map = new HashMap();
		//boolean tempIsClient = false;
		boolean tempIsRenderPlayer2 = false;
		//map.put("net.minecraft.client.Minecraft", tempIsClient);
		if (versionInt > 179) {
			map.put("net.minecraftforge.fml.common.FMLCommonHandler", Modchu_Main.isForge);
		} else {
			map.put("FMLRenderAccessLibrary", Modchu_Main.isForge);
			map.put("net.minecraft.src.FMLRenderAccessLibrary", Modchu_Main.isForge);
			if (versionInt < 164) {
				map.put("ItemRendererHD", Modchu_Main.isItemRendererHD);
				map.put("RenderPlayer2", tempIsRenderPlayer2);
				//map.put("net.minecraft.src.Minecraft", tempIsClient);
				//if (versionInt == 162) map.put("ats", tempIsClient);
			}
		}
		Class test2 = null;
		for (Entry<String, Boolean> en : map.entrySet()) {
			String s = en.getKey();
			try {
				test2 = Class.forName(s);
				if (test2 != null) {
					Modchu_Debug.lDebug(test2.getName() + " Check ok.");
					if (s.equals("net.minecraftforge.fml.common.FMLCommonHandler")
							| s.equals("FMLRenderAccessLibrary")
							| s.equals("net.minecraft.src.FMLRenderAccessLibrary")) {
						Modchu_Main.isForge = true;
					}
/*
					if (s.equals("net.minecraft.client.Minecraft")
							| s.equals("net.minecraft.src.Minecraft")
							| s.equals("ats")) {
						tempIsClient = true;
					}
*/
					if (s.equals("ItemRendererHD")) Modchu_Main.isItemRendererHD = true;
					if (s.equals("RenderPlayer2")) tempIsRenderPlayer2 = true;
				}
			} catch (Exception e) {
			}
		}
		Modchu_Debug.lDebug("Modchu_Init init() isForge="+Modchu_Main.isForge);
		//Modchu_Debug.lDebug("Modchu_Init init() tempIsClient="+tempIsClient);
		if (tempIsRenderPlayer2) {
			try {
				Object o = getFieldObject("ItemRenderer", "olddays");
				if (o != null) {
					Modchu_Main.isOlddays = true;
					Modchu_Debug.lDebug("ItemRenderer olddays Check ok.");
				} else {
					Modchu_Debug.lDebug("ItemRenderer olddays Check false.");
				}
			} catch(Exception e) {
			}
		}
		Modchu_Debug.lDebug("(1 / 3) - (2 / 5) Modchu_Init init()");
		Class FMLCommonHandler = loadClass("net.minecraftforge.fml.common.FMLCommonHandler");
		if (FMLCommonHandler != null); else FMLCommonHandler = loadClass("cpw.mods.fml.common.FMLCommonHandler");
		if (FMLCommonHandler != null); else FMLCommonHandler = loadClass("FMLCommonHandler");
		if (FMLCommonHandler != null); else FMLCommonHandler = loadClass("net.minecraft.src.FMLCommonHandler");
		Object o = Modchu_Reflect.invokeMethod(FMLCommonHandler, "instance");
		if (o != null) {
			o = invokeMethod(o.getClass(), "getSide", o);
			if (o != null) {
				if ((Boolean) invokeMethod(o.getClass(), "isServer", o)) Modchu_Main.isServer = true;
				Modchu_Debug.lDebug("(1 / 3) - (3 / 5) Modchu_Init init() Forge isServer="+Modchu_Main.isServer);
			} else {
				Modchu_Debug.lDebug("(1 / 3) - (3 / 5) Modchu_Init init() o == null !!");
			}
		} else {
			Class ModLoader = loadClass("ModLoader");
			if (ModLoader != null); else ModLoader = loadClass("net.minecraft.src.ModLoader");
			if (ModLoader != null) Modchu_Main.isServer = invokeMethod(ModLoader, "getMinecraftInstance") == null;
			Modchu_Debug.lDebug("(1 / 3) - (3 / 5) Modchu_Init init() ModLoader isServer="+Modchu_Main.isServer);
		}
		Modchu_FileManager.init();
		String s = null;
		List<File> list = Modchu_FileManager.getMinecraftJarList();
		if (list != null) {
			Modchu_Debug.lDebug("(1 / 3) - (4 / 5) 1 Modchu_Init init()");
			for (File file : list) {
				s = file.getAbsolutePath();
				Modchu_Debug.lDebug("(1 / 3) - (4 / 5) r Modchu_Init init() s="+s);
				if (!checkIsRelease(s)) {
					Modchu_Main.isRelease = false;
					Modchu_Debug.lDebug("(1 / 3) - (4 / 5) r Modchu_Init init() Modchu_Main.isRelease = false break.");
					break;
				}
			}
		} else {
			File mcDataDir = !Modchu_Main.isServer ? Modchu_AS.getFile(Modchu_AS.minecraftMcDataDir) : new File(".");
			Modchu_Debug.lDebug("(1 / 3) - (4 / 5) 2 Modchu_Init init() mcDataDir="+mcDataDir.getAbsolutePath());
			s = mcDataDir.getAbsolutePath();
			Modchu_Main.isRelease = checkIsRelease(s);
		}
		Modchu_Debug.lDebug("Modchu_Init init() isRelease="+Modchu_Main.isRelease);
		Modchu_Reflect.initNameMap();
/*
		float[] ff = new float[]{ 0.0F };
		float[][] fff = new float[][]{ new float[]{ 0.0F } };
		HashMap<String, Object> debug = Modchu_Main.getNewModchuCharacteristicMap(ff, fff);
		throw new RuntimeException("Modchu_Init debug stop");
*/
		Modchu_Debug.lDebug("(1 / 3) - (5 / 5) Modchu_Init init() end.");
	}

	private static boolean checkIsRelease(String s) {
		//Modchu_Debug.lDebug("Modchu_Init checkIsRelease new File= "+(new File(new File(s, "../"), "gradle")));
		if (s != null
				&& (s.indexOf("jars") != -1
						| s.indexOf("gradle") != -1
								| s.indexOf("mcp") != -1
								| new File(s, ".gradle").exists()
								| new File(new File(s, "../"), ".gradle").exists())) {
			return false;
		} else {
			Modchu_Debug.lDebug("Modchu_Init init() isRelease checkIsRelease s="+s+" error !!", 2);
		}
		return true;
	}

	public static String getMcVersion() {
		String s = null;
		Object o = getFieldObject("ModLoader", "VERSION");
		if (o != null); else o = getFieldObject("net.minecraft.src.ModLoader", "VERSION");
		if (o != null) s = o instanceof String ? (String) o : null;
		if (s != null) {
			if (s.indexOf(" ") > 0){
				return lastIndexProcessing(s, " ");
			}
			return s;
		}
		String s1 = null;
		o = invokeMethod("net.minecraftforge.common.ForgeVersion", "getMajorVersion");
		if (o != null) s1 = o instanceof String ? (String) o : ""+o;
		System.out.println("getMcVersion 1 s1="+s1);
		if (s1 != null) {
			o = invokeMethod("net.minecraftforge.common.ForgeVersion", "getMinorVersion");
			String s2 = o instanceof String ? (String) o : ""+o;
			System.out.println("getMcVersion 2 s2="+s2);
			o = invokeMethod("net.minecraftforge.common.ForgeVersion", "getRevisionVersion");
			String s3 = o instanceof String ? (String) o : ""+o;
			System.out.println("getMcVersion 3 s3="+s3);
			o = invokeMethod("net.minecraftforge.common.ForgeVersion", "getBuildVersion");
			String s4 = o instanceof String ? (String) o : ""+o;
			System.out.println("getMcVersion 4 s4="+s4);
			s = getForgeVersionBuildVersionToMcVersion(s1, s2, s3, s4);
			System.out.println("getMcVersion 5 s="+s);
		}
		if (s != null) {
			System.out.println("getMcVersion 6 return s="+s);
			return s;
		}
		Object mc = null;
		try {
			mc = invokeMethod("net.minecraft.client.Minecraft", "func_71410_x");
			if (o != null) {
			} else {
				mc = invokeMethod("net.minecraft.client.Minecraft", "getMinecraft");
			}
		} catch (Exception e) {
		}
		System.out.println("getMcVersion 7 mc="+mc);
		if (mc != null); else return null;
		Field f = getField("net.minecraft.client.Minecraft", "field_110447_Z");
		if (f != null); else {
			f = getField("net.minecraft.client.Minecraft", "launchedVersion");
		}
		System.out.println("getMcVersion 8 f="+f);
		if (f != null) {
			try {
				return (String)f.get(mc);
			} catch (Exception e) {
			}
		}
		try {
			o = invokeMethod("net.minecraft.client.Minecraft", "func_175600_c", mc);
			if (o != null
					&& o instanceof String) return (String) o;
			o = invokeMethod("net.minecraft.client.Minecraft", "getVersion", mc);
			System.out.println("getMcVersion 9 o="+o);
			if (o != null
					&& o instanceof String) return (String) o;
		} catch (Exception e) {
		}
		System.out.println("getMcVersion 10 return null !!");
		return null;
	}

	public static String lastIndexProcessing(String t, String t1) {
		int i = t != null
				&& !t.isEmpty() ? t.lastIndexOf(t1) : -1;
		int i1 = i > -1 ? i + t1.length() : -1;
		if (i1 > -1) return t.length() > i1 ? t.substring(i1) : null;
		return t;
	}

	public static String getForgeVersionBuildVersionToMcVersion(String s, String s1, String s2, String s3) {
		int i = Integer.valueOf(s);
		if (i > 0) {
			int i1 = Integer.valueOf(s1);
			int i3 = Integer.valueOf(s3);
			switch(i) {
			case 1:
				if (i3 < 3) return "1.0";
				if (i3 < 30) return "1.1";
				return "1.2.3";
			case 2:
				return "1.2.4";
			case 3:
				return "1.2.5";
			case 4:
				if (i3 < 200) return "1.3.1";
				return "1.3.2";
			case 5:
				return "1.4.0";
			case 6:
				if (i3 < 330) return "1.4.1";
				if (i3 < 356) return "1.4.2";
				if (i3 < 360) return "1.4.3";
				if (i3 < 379) return "1.4.4";
				if (i3 < 451) return "1.4.5";
				if (i3 < 490) return "1.4.6";
				return "1.4.7";
			case 7:
				if (i3 < 600) return "1.5";
				if (i3 < 684) return "1.5.1";
				return "1.5.2";
			case 8:
				if (i3 < 776) return "1.6.1";
				break;
			case 9:
				if (i3 < 873) return "1.6.2";
				if (i3 < 879) return "1.6.3";
				return "1.6.4";
			case 10:
				if (i1 == 12) return "1.7.2";
				return "1.7.10";
			case 11:
				if (i3 == 1590
				| i1 == 15) return "1.8.8";
				return "1.8";
			}
		}
		return null;
	}

	public static int getVersionStringToMinecraftVersionInt(String s) {
		if (s.equals("1.8.8")) return 188;
		if (s.equals("1.8")) return 180;
		if (s.equals("1.7.10")) return 179;
		if (s.equals("1.7.2")) return 172;
		if (s.equals("1.6.4")) return 164;
		if (s.equals("1.6.2")) return 162;
		if (s.equals("1.5.2")) return 152;
		if (s.equals("1.4.7")) return 147;
		if (s.equals("1.4.6")) return 146;
		if (s.equals("1.4.5")) return 145;
		if (s.equals("1.4.2")) return 142;
		if (s.equals("1.3.2")) return 132;
		if (s.equals("1.2.5")) return 125;
		return -1;
	}

	public static String[] getModchuCharacteristicVersionStrings() {
		int version = Modchu_Version.getMinecraftVersion();
		if (version == 188) {
			return new String[]{
					"188",
					"180_188",
					"172_188",
					"164_188",
					"162_188"
			};
		}
		if (version == 180) {
			return new String[]{
					"180",
					"180_188",
					"172_188",
					"164_188",
					"162_188",
					"172_180",
					"164_180",
					"162_180"
			};
		}
		if (version == 179) {
			return new String[]{
					"179",
					"172_179",
					"164_179",
					"162_179",
					"172_180",
					"164_180",
					"162_180",
					"172_188",
					"164_188",
					"162_188",
					"152_179"
			};
		}
		if (version == 172) {
			return new String[]{
					"172",
					"172_179",
					"164_179",
					"162_179",
					"172_180",
					"164_180",
					"162_180",
					"172_188",
					"164_188",
					"162_188",
					"152_179"
			};
		}
		if (version == 164) {
			return new String[]{
					"164",
					"162_164",
					"164_179",
					"162_179",
					"164_180",
					"162_180",
					"164_188",
					"162_188",
					"152_179"
			};
		}
		if (version == 162) {
			return new String[]{
					"162",
					"152_162",
					"162_164",
					"162_179",
					"162_180",
					"162_188",
					"152_179"
			};
		}
		if (version == 152) {
			return new String[]{
					"152",
					"152_162",
					"152_179"
			};
		}
		return null;
	}

	private static Object getFieldObject(String var0, String var1) {
		Field f = null;
		Class c = null;
		try {
			c = loadClass(var0);
			if (c != null) f = getField(c, var1);
			if (f != null) return f.get(null);
		} catch (Exception e) {
		}
		return null;
	}

	private static Field getField(String var0, String var1) {
		return getField(loadClass(var0), var1);
	}

	private static Field getField(Class var0, String var1) {
		Field f = null;
		try {
			f = var0.getDeclaredField(var1);
			return f;
		} catch (Exception e) {
		}
		try {
			f = var0.getField(var1);
			return f;
		} catch (Exception e1) {
		}
		return null;
	}

	private static Class loadClass(String var0) {
		Class c = null;
		try {
			c = Class.forName(var0);
			if (c != null) return c;
		} catch (Error e) {
		} catch (Exception e) {
		}
		return null;
	}

	public static Object invokeMethod(String var0, String var1) {
		return invokeMethod(loadClass(var0), var1, (Class[]) null, (Object[]) null);
	}

	public static Object invokeMethod(String var0, String var1, Object var3) {
		return invokeMethod(loadClass(var0), var1, (Class[]) null, var3, (Object[]) null);
	}

	public static Object invokeMethod(Class var0, String var1) {
		return invokeMethod(var0, var1, (Class[]) null, (Object[]) null);
	}

	public static Object invokeMethod(Class var0, String var1, Object o) {
		return invokeMethod(var0, var1, (Class[]) null, o, (Object[]) null);
	}

	public static Object invokeMethod(Class var0, String var1, Class[] var2, Object[] var3) {
		return invokeMethod(var0, var1, var2, null, var3);
	}

	public static Object invokeMethod(Class var0, String var1, Class[] var2, Object var3, Object[] var4) {
		Method method = null;
		try {
			method = getRawMethod(var0, var1, var2);
			if (method != null) {
				Object o = var4 != null ? method.invoke(var3, var4) : method.invoke(var3);
				return o;
			}
		} catch (Exception e) {
		}
		return null;
	}

	private static Method getRawMethod(Class var0, String var1, Class[] var2) {
		Method method = null;
		try {
			if (var0 != null) method = var0.getDeclaredMethod(var1, var2);
			if (method != null) {
				method.setAccessible(true);
				return method;
			}
		} catch (Exception e) {
		}
		return null;
	}

}