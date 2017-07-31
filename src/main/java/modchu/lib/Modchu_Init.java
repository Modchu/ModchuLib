package modchu.lib;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
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
		if (Modchu_Main.isForge) {
			Class FMLCommonHandler = loadClass("net.minecraftforge.fml.common.FMLCommonHandler");
			if (FMLCommonHandler != null); else FMLCommonHandler = loadClass("cpw.mods.fml.common.FMLCommonHandler");
			if (FMLCommonHandler != null); else FMLCommonHandler = loadClass("FMLCommonHandler");
			if (FMLCommonHandler != null); else FMLCommonHandler = loadClass("net.minecraft.src.FMLCommonHandler");
			Object o = FMLCommonHandler != null ? invokeMethod(FMLCommonHandler, "instance") : null;
			if (o != null) {
				o = invokeMethod(o.getClass(), "getSide", o);
				if (o != null) {
					if ((Boolean) invokeMethod(o.getClass(), "isServer", o)) Modchu_Main.isServer = true;
					Modchu_Debug.lDebug("(1 / 3) - (2 / 5) Modchu_Init init() Forge isServer="+Modchu_Main.isServer);
				} else {
					Modchu_Debug.lDebug("(1 / 3) - (2 / 5) Modchu_Init init() o == null !!");
				}
			}
		} else {
			Class ModLoader = loadClass("ModLoader");
			if (ModLoader != null); else ModLoader = loadClass("net.minecraft.src.ModLoader");
			if (ModLoader != null) Modchu_Main.isServer = invokeMethod(ModLoader, "getMinecraftInstance") == null;
			Modchu_Debug.lDebug("(1 / 3) - (2 / 5) Modchu_Init init() ModLoader isServer="+Modchu_Main.isServer);
		}
		Modchu_AS.instanceCheck();
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
		Modchu_Debug.lDebug("(1 / 3) - (3 / 5) Modchu_Init init()");
		Modchu_FileManager.init();
		String s = null;
		checkIsRelease();
		Modchu_Debug.lDebug("(1 / 3) - (4 / 5) Modchu_Init init() isRelease="+Modchu_Main.isRelease);
		Modchu_Reflect.initNameMap();
/*
		float[] ff = new float[]{ 0.0F };
		float[][] fff = new float[][]{ new float[]{ 0.0F } };
		HashMap<String, Object> debug = Modchu_Main.getNewModchuCharacteristicMap(ff, fff);
		throw new RuntimeException("Modchu_Init debug stop");
*/
		Modchu_Debug.lDebug("(1 / 3) - (5 / 5)  init() end.");
	}

	private static void checkIsRelease() {
		Class minecraft = loadClass("net.minecraft.src.Minecraft", false);
		if (minecraft != null) {
			// 1.6.2開発環境確定
			//System.out.println("Modchu_Init checkIsRelease 1.6.2開発環境 return.");
			Modchu_Main.isRelease = false;
			return;
		}
		minecraft = loadClass("net.minecraft.client.Minecraft", false);
		if (minecraft != null); else {
			minecraft = loadClass("ats", false);
			if (minecraft != null) {
				Object o = getFieldObject(minecraft.getClass(), "lu", minecraft);
				if (o != null) {
					// 1.6.2通常環境確定
					//System.out.println("Modchu_Init checkIsRelease 1.6.2通常環境 o="+o);
					Modchu_Main.isRelease = true;
					return;
				}
				minecraft = null;
			}
		}
		//System.out.println("Modchu_Init checkIsRelease minecraft="+minecraft);
		if (minecraft == null) {
			// Server環境確定
			Class c = loadClass("net.minecraft.server.MinecraftServer", false);
			if (c != null) {
				Method method = getRawMethod(c, "getServer", null);
				boolean b = method == null;
				//System.out.println("Modchu_Init checkIsRelease "+(b ? "通常" : "開発")+"環境 Server return.");
				Modchu_Main.isRelease = b;
				return;
			}
			String s = "Modchu_Init checkIsRelease check error !! isForge="+Modchu_Main.isForge+" getMinecraftVersion()="+Modchu_Main.getMinecraftVersion();
			Modchu_Main.setRuntimeException(s);
			return;
		}
		Object o = invokeMethod(minecraft, "func_71410_x");
		//System.out.println("Modchu_Init checkIsRelease 1 o="+o);
		if (o != null
				&& minecraft.isInstance(o)) {
			// 通常環境確定
			System.out.println("Modchu_Init checkIsRelease func_71410_x return.");
			Modchu_Main.isRelease = true;
			return;
		}
		o = invokeMethod(minecraft, "x");
		//System.out.println("Modchu_Init checkIsRelease 2 o="+o);
		if (o != null
				&& minecraft.isInstance(o)) {
			// 通常環境確定
			Modchu_Main.isRelease = true;
			return;
		}
		o = invokeMethod(minecraft, "w");
		//System.out.println("Modchu_Init checkIsRelease 3 o="+o);
		if (o != null
				&& minecraft.isInstance(o)) {
			// 通常環境確定
			System.out.println("Modchu_Init checkIsRelease 4 return.");
			Modchu_Main.isRelease = true;
			return;
		}
		o = invokeMethod(minecraft, "getMinecraft");
		//System.out.println("Modchu_Init checkIsRelease 5 o="+o);
		if (o != null
				&& minecraft.isInstance(o)) {
			System.out.println("Modchu_Init checkIsRelease 6 return.");
			// 開発環境確定
			Modchu_Main.isRelease = false;
			return;
		}
		int version = Modchu_Main.getMinecraftVersion();
		String ss = "Modchu_Init checkIsRelease null error !! version="+version;
		System.out.println(ss);
		if (version > 179
				&& Modchu_Main.isForge) {
			Modchu_Main.setRuntimeException(ss);
			return;
		}
		throw new RuntimeException(ss);
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
				if (i3 < 202) return "1.3.1";
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
				if (i3 > 1660) return "1.8.9";
				if (i3 != 1577) {
					if (i3 > 1574
							| i1 == 15) {
						//return "1.8.8";
						//強制1.8.9判定
						return "1.8.9";
					}
				}
				return "1.8";
			case 12:
				return i1 == 16 ? "1.9" : i1 == 17 ? "1.9.4" : "1.10.2";
			case 13:
				return i1 == 19 ? "1.11" : "1.11.2";
			case 14:
				return "1.12";
			}
		}
		return "1.12";
	}

	public static int getVersionStringToMinecraftVersionInt(String s) {
		if (s.equals("1.12")) return 220;
		if (s.equals("1.11.2")) return 212;
		if (s.equals("1.11")) return 210;
		if (s.equals("1.10.2")) return 202;
		if (s.equals("1.9.4")) return 194;
		if (s.equals("1.9")) return 190;
		if (s.equals("1.8.9")) return 189;
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
		if (version == 220) {
			return new String[]{
					"220",
					"212_220",
					"210_220",
					"202_220",
					"194_220",
					"190_220",
					"189_220",
					"188_220",
					"180_220",
					"172_220",
					"164_220",
					"162_220",
					"152_220"
			};
		}
		if (version == 212) {
			return new String[]{
					"212",
					"212_220",
					"210_212",
					"210_220",
					"202_212",
					"202_220",
					"194_212",
					"194_220",
					"190_212",
					"190_220",
					"189_212",
					"189_220",
					"188_212",
					"188_220",
					"180_212",
					"180_220",
					"172_212",
					"172_220",
					"164_212",
					"164_220",
					"162_212",
					"162_220",
					"152_212",
					"152_220"
			};
		}
		if (version == 210) {
			return new String[]{
					"210",
					"210_212",
					"210_220",
					"202_210",
					"202_212",
					"202_220",
					"194_210",
					"194_212",
					"194_220",
					"190_210",
					"190_212",
					"190_220",
					"189_210",
					"189_212",
					"189_220",
					"188_210",
					"188_212",
					"188_220",
					"180_210",
					"180_212",
					"180_220",
					"172_210",
					"172_212",
					"172_220",
					"164_210",
					"164_212",
					"164_220",
					"162_210",
					"162_212",
					"162_220",
					"152_210",
					"152_212",
					"152_220"
			};
		}
		if (version == 202) {
			return new String[]{
					"202",
					"202_210",
					"202_212",
					"202_220",
					"202_212",
					"194_202",
					"194_210",
					"194_212",
					"194_220",
					"190_202",
					"190_210",
					"190_212",
					"190_220",
					"189_202",
					"189_210",
					"189_212",
					"189_220",
					"188_202",
					"188_210",
					"188_212",
					"188_220",
					"180_202",
					"180_210",
					"180_212",
					"180_220",
					"172_202",
					"172_210",
					"172_212",
					"172_220",
					"164_202",
					"164_210",
					"164_212",
					"164_220",
					"162_202",
					"162_210",
					"162_212",
					"162_220",
					"152_202",
					"152_210",
					"152_212",
					"152_220"
			};
		}
		if (version == 194) {
			return new String[]{
					"194",
					"194_202",
					"194_210",
					"194_212",
					"194_220",
					"190_194",
					"190_202",
					"190_210",
					"190_212",
					"190_220",
					"189_194",
					"189_202",
					"189_210",
					"189_212",
					"189_220",
					"188_194",
					"188_202",
					"188_210",
					"188_212",
					"188_220",
					"180_194",
					"180_202",
					"180_210",
					"180_212",
					"180_220",
					"172_194",
					"172_202",
					"172_210",
					"172_212",
					"172_220",
					"164_194",
					"164_202",
					"164_210",
					"164_212",
					"164_220",
					"162_194",
					"162_202",
					"162_210",
					"162_212",
					"162_220",
					"152_194",
					"152_202",
					"152_210",
					"152_212",
					"152_220"
			};
		}
		if (version == 190) {
			return new String[]{
					"190",
					"190_194",
					"190_202",
					"190_210",
					"190_212",
					"190_220",
					"189_190",
					"189_194",
					"189_202",
					"189_210",
					"189_212",
					"189_220",
					"188_190",
					"188_194",
					"188_202",
					"188_210",
					"188_212",
					"188_220",
					"180_190",
					"180_194",
					"180_202",
					"180_210",
					"180_212",
					"180_220",
					"179_190",
					"179_194",
					"179_202",
					"179_210",
					"179_212",
					"179_220",
					"172_190",
					"172_194",
					"172_202",
					"172_210",
					"172_212",
					"172_220",
					"164_190",
					"164_194",
					"164_202",
					"164_210",
					"164_212",
					"164_220",
					"162_190",
					"162_194",
					"162_202",
					"162_210",
					"162_212",
					"162_220",
					"152_190",
					"152_194",
					"152_202",
					"152_210",
					"152_212",
					"152_220"
			};
		}
		if (version == 189) {
			return new String[]{
					"189",
					"189_190",
					"189_194",
					"189_202",
					"189_210",
					"189_212",
					"189_220",
					"188_189",
					"188_190",
					"188_194",
					"188_202",
					"188_210",
					"188_212",
					"188_220",
					"180_189",
					"180_190",
					"180_194",
					"180_202",
					"180_210",
					"180_212",
					"180_220",
					"179_189",
					"179_190",
					"179_194",
					"179_202",
					"179_210",
					"179_212",
					"179_220",
					"172_189",
					"172_190",
					"172_194",
					"172_202",
					"172_210",
					"172_212",
					"172_220",
					"164_189",
					"164_190",
					"164_194",
					"164_202",
					"164_210",
					"164_212",
					"164_220",
					"162_189",
					"162_190",
					"162_194",
					"162_202",
					"162_210",
					"162_212",
					"162_220",
					"152_189",
					"152_190",
					"152_194",
					"152_202",
					"152_210",
					"152_212",
					"152_220"
			};
		}
		if (version == 180) {
			return new String[]{
					"180",
					"180_188",
					"180_189",
					"180_190",
					"180_194",
					"180_202",
					"180_210",
					"180_212",
					"180_220",
					"172_180",
					"172_188",
					"172_189",
					"172_190",
					"172_194",
					"172_202",
					"172_210",
					"172_212",
					"172_220",
					"164_180",
					"164_188",
					"164_189",
					"164_190",
					"164_194",
					"164_202",
					"164_210",
					"164_212",
					"164_220",
					"162_180",
					"162_188",
					"162_189",
					"162_190",
					"162_194",
					"162_202",
					"162_210",
					"162_212",
					"162_220",
					"152_189",
					"152_190",
					"152_194",
					"152_202",
					"152_210",
					"152_212",
					"152_220"
			};
		}
		if (version == 179) {
			return new String[]{
					"179",
					"179_180",
					"179_188",
					"179_189",
					"179_190",
					"179_194",
					"179_202",
					"179_210",
					"179_212",
					"179_220",
					"172_179",
					"172_180",
					"172_188",
					"172_189",
					"172_190",
					"172_194",
					"172_202",
					"172_210",
					"172_212",
					"172_220",
					"164_179",
					"164_180",
					"164_188",
					"164_189",
					"164_190",
					"164_194",
					"164_202",
					"164_210",
					"164_212",
					"164_220",
					"162_179",
					"162_180",
					"162_188",
					"162_189",
					"162_190",
					"162_194",
					"162_202",
					"162_210",
					"162_212",
					"162_220",
					"152_179",
					"152_189",
					"152_190",
					"152_194",
					"152_202",
					"152_210",
					"152_212",
					"152_220"
			};
		}
		if (version == 172) {
			return new String[]{
					"172",
					"172_179",
					"172_180",
					"172_188",
					"172_189",
					"172_190",
					"172_194",
					"172_202",
					"172_210",
					"172_212",
					"172_220",
					"164_179",
					"164_180",
					"164_188",
					"164_189",
					"164_190",
					"164_194",
					"164_202",
					"164_210",
					"164_212",
					"164_220",
					"162_179",
					"162_180",
					"162_188",
					"162_189",
					"162_190",
					"162_194",
					"162_202",
					"162_210",
					"162_212",
					"162_220",
					"152_179",
					"152_189",
					"152_190",
					"152_194",
					"152_202",
					"152_210",
					"152_212",
					"152_220"
			};
		}
		if (version == 164) {
			return new String[]{
					"164",
					"164_179",
					"164_180",
					"164_188",
					"164_189",
					"164_190",
					"164_194",
					"164_202",
					"164_210",
					"164_212",
					"164_220",
					"162_164",
					"162_179",
					"162_180",
					"162_188",
					"162_189",
					"162_190",
					"162_194",
					"162_202",
					"162_210",
					"162_212",
					"162_220",
					"152_164",
					"152_179",
					"152_189",
					"152_190",
					"152_194",
					"152_202",
					"152_210",
					"152_212",
					"152_220"
			};
		}
		if (version == 162) {
			return new String[]{
					"162",
					"162_164",
					"162_179",
					"162_180",
					"162_188",
					"162_189",
					"162_190",
					"162_194",
					"162_202",
					"162_210",
					"162_212",
					"162_220",
					"152_162",
					"152_164",
					"152_179",
					"152_189",
					"152_190",
					"152_194",
					"152_202",
					"152_210",
					"152_212",
					"152_220"
			};
		}
		if (version == 152) {
			return new String[]{
					"152",
					"152_162",
					"152_164",
					"152_179",
					"152_189",
					"152_190",
					"152_194",
					"152_202",
					"152_210",
					"152_212",
					"152_220"
			};
		}
		return null;
	}

	private static Object getFieldObject(String var0, String var1) {
		return getFieldObject(loadClass(var0), var1, null);
	}

	private static Object getFieldObject(Class var0, String var1) {
		return getFieldObject(var0, var1, null);
	}

	private static Object getFieldObject(String var0, String var1, Object o) {
		return getFieldObject(loadClass(var0), var1, o);
	}

	private static Object getFieldObject(Class var0, String var1, Object o) {
		Field f = null;
		try {
			if (var0 != null) {
				f = getField(var0, var1);
				if (f != null) return f.get(o);
			}
		} catch (Exception e) {
		}
		return null;
	}

	private static Object getFieldObject(String var0, String var1, String var2) {
		return getFieldObject(var0, var1, var2, null);
	}

	private static Object getFieldObject(String var0, String var1, String var2, Object o) {
		Object o1 = getFieldObject(var0, var1, o);
		if (o1 != null) return o1;
		o1 = getFieldObject(var0, var2, o);
		return o1;
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
		return loadClass(var0, true);
	}

	private static Class loadClass(String var0, boolean b) {
		Class c = null;
		try {
			c = Class.forName(var0);
			if (c != null) return c;
		} catch (Error e) {
		} catch (Exception e) {
		}
		if (!b) return null;
		try {
			c = Class.forName("net.minecraft.src."+var0);
			if (c != null) return c;
		} catch (Error e) {
		} catch (Exception e) {
		}
		return null;
	}

	private static Object invokeMethod(String var0, String var1) {
		return invokeMethod(loadClass(var0), var1, (Class[]) null, (Object[]) null);
	}

	private static Object invokeMethod(String var0, String var1, Object var3) {
		return invokeMethod(loadClass(var0), var1, (Class[]) null, var3, (Object[]) null);
	}

	private static Object invokeMethod(Class var0, String var1) {
		return invokeMethod(var0, var1, (Class[]) null, (Object[]) null);
	}

	private static Object invokeMethod(Class var0, String var1, Object o) {
		return invokeMethod(var0, var1, (Class[]) null, o, (Object[]) null);
	}

	private static Object invokeMethod(Class var0, String var1, Class[] var2, Object[] var3) {
		return invokeMethod(var0, var1, var2, null, var3);
	}

	private static Object invokeMethod(Class var0, String var1, Class[] var2, Object var3, Object[] var4) {
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