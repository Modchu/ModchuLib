package modchu.lib;import java.io.File;import java.util.HashMap;import java.util.Iterator;import java.util.Map;import java.util.Map.Entry;import net.minecraft.entity.EntityList;import net.minecraft.entity.player.EntityPlayer;import net.minecraft.src.mod_Modchu_ModchuLib;import net.minecraft.util.EnumOS;import net.minecraft.world.World;import org.lwjgl.input.Keyboard;public class Modchu_Main {	public static final String version = "7b";	//cfg書き込み項目	public static boolean versionCheck = true;	public static final String modName = "ModchuLib";	public static final String versionString = ""+ Modchu_Version.version + "-" + version;	public static Modchu_Main modchu_Main;	public static Object mod_Modchu_ModchuLib;	public static Object mc;	public static String newVersion = "";	public static String packageName;	public static String runtimeExceptionString;	private static File cfgdir;	private static File mainCfgfile;	public static final int modchuLibVersion = Modchu_Version.version;	public static int mmmLibVersion;	public static int initModsLoadedCount;	public static boolean isServer = false;	public static boolean isForge = false;	public static boolean newRelease = false;	public static boolean oldRenderItems = false;	public static boolean runtimeExceptionFlag = false;	public static boolean initModsLoadedFlag = false;	public static boolean isRelease = true;	private static boolean packageNameNull = false;	private static boolean isRemote = false;	public Modchu_Main()	{		modchu_Main = this;	}	public static String getName() {		return modName;	}	public static String getVersion() {		return versionString;	}	public static void load() {		//対応MOD導入チェック class直チェック		String className1[] = {				"FMLRenderAccessLibrary", "net.minecraft.src.FMLRenderAccessLibrary"		};		String test2 = null;		for(int n = 0 ; n < className1.length ; n++){			try {				test2 = className1[n];				test2 = ""+Class.forName(test2);				Modchu_Debug.lDebug(test2 + " Check ok.");				if(n == 0						| n == 1) isForge = true;			} catch (ClassNotFoundException e) {			}		}		getPackageInit();		Modchu_Reflect.initNameMap();		cfgdir = new File(getMinecraftDir(), "/config/");		mainCfgfile = new File(cfgdir, ("Modchu_ModchuLib.cfg"));		loadcfg();		Modchu_Debug.systemDebug("Modchu_Main load", 1);		//Modchu_Debug.lDebug("Modchu_Main load() getPackageInit");		Modchu_Debug.lDebug("Modchu_Main load() getMinecraftDir().getAbsolutePath()="+getMinecraftDir().getAbsolutePath());		String s = getMinecraftDir().getAbsolutePath();		if (s.indexOf("jars") != -1				| new File(s, "gradle").exists()) {			isRelease = false;		}		Modchu_Debug.lDebug("Modchu_Main load() isRelease = "+isRelease);		Class mod_MMM_MMMLib = Modchu_Reflect.loadClass("mod_MMM_MMMLib");		if (mod_MMM_MMMLib != null) {			s = (String) Modchu_Reflect.getFieldObject(mod_MMM_MMMLib, "Revision");			int i = getVersionStringConversionInt(s);			mmmLibVersion = i;		} else {			mmmLibVersion = -1;		}		if (Modchu_Debug.debugMessage				&& !Modchu_Main.isRelease()) Modchu_Debug.debugString = new String[10];		Class c = Modchu_Reflect.loadClass("modchu.pflm.PFLM_Main");		if (c != null) {			Object o = Modchu_Reflect.getFieldObject(c, "mod_pflm_playerformlittlemaid");			if (o != null) Modchu_Reflect.invokeMethod("mod_PFLM_PlayerFormLittleMaid", "loadInit", o);		}		if (versionCheck) startVersionCheckThread();	}	public static void modsLoaded() {		Modchu_Debug.lDebug("Modchu_Main modsLoaded()");		Modchu_Reflect.setFieldObject(mod_Modchu_ModchuLib.getClass(), "loadCheckThread", mod_Modchu_ModchuLib, null, -1);		Class c = Modchu_Reflect.loadClass("modchu.pflm.PFLM_Main", -1);		if (c != null) {			Object o = Modchu_Reflect.getFieldObject(c, "mod_pflm_playerformlittlemaid");			if (o != null) Modchu_Reflect.invokeMethod(o.getClass(), "modsLoadedInit", o);			else {				Modchu_Debug.lDebug("Modchu_Main modsLoaded() PFLM_Main mod_pflm_playerformlittlemaid null.");			}		} else {			initModsLoadedFlag = true;			Modchu_Debug.lDebug("Modchu_Main modsLoaded() PFLM_Main Class null.");		}	} 	public static void loadcfg() {		// cfg読み込み		if (cfgdir.exists()) {			if (!mainCfgfile.exists()) {				// cfgファイルが無い = 新規作成				String s[] = {						"debugMessage=true", "debugMessagetexture=true", "debugReflectMessage=true", "debugReflectMessageDetail=false", "versionCheck=true",						"debugLogMessage=false", "careerSave=false", "debugSystemMessage=false"				};				Modchu_Config.writerConfig(mainCfgfile, s);			} else {				// cfgファイルがある				Modchu_Debug.debugMessage = Boolean.valueOf((Modchu_Config.loadConfig(mainCfgfile, "debugMessage", Modchu_Debug.debugMessage)).toString());				Modchu_Debug.debugMessagetexture = Boolean.valueOf((Modchu_Config.loadConfig(mainCfgfile, "debugMessagetexture", Modchu_Debug.debugMessagetexture)).toString());				Modchu_Reflect.debugReflectMessage = Boolean.valueOf((Modchu_Config.loadConfig(mainCfgfile, "debugReflectMessage", Modchu_Reflect.debugReflectMessage)).toString());				Modchu_Reflect.debugReflectMessageDetail = Boolean.valueOf((Modchu_Config.loadConfig(mainCfgfile, "debugReflectMessageDetail", Modchu_Reflect.debugReflectMessageDetail)).toString());				versionCheck = Boolean.valueOf((Modchu_Config.loadConfig(mainCfgfile, "versionCheck", versionCheck)).toString());				Modchu_Debug.debugLogMessage = Boolean.valueOf((Modchu_Config.loadConfig(mainCfgfile, "debugLogMessage", Modchu_Debug.debugLogMessage)).toString());				Modchu_Debug.careerSave = Boolean.valueOf((Modchu_Config.loadConfig(mainCfgfile, "careerSave", Modchu_Debug.careerSave)).toString());				Modchu_Debug.debugSystemMessage = Boolean.valueOf((Modchu_Config.loadConfig(mainCfgfile, "debugSystemMessage", Modchu_Debug.debugSystemMessage)).toString());				String k[] = {						"debugMessage", "debugMessagetexture", "debugReflectMessage", "debugReflectMessageDetail", "versionCheck",						"debugLogMessage", "careerSave", "debugSystemMessage"				};				String k1[] = {						""+Modchu_Debug.debugMessage, ""+Modchu_Debug.debugMessagetexture, ""+Modchu_Reflect.debugReflectMessage, ""+Modchu_Reflect.debugReflectMessageDetail, ""+versionCheck,						""+Modchu_Debug.debugLogMessage, ""+Modchu_Debug.careerSave, ""+Modchu_Debug.debugSystemMessage				};				Modchu_Config.writerSupplementConfig(mainCfgfile, k, k1);			}		}	}	public static boolean onTickInGame(float f, Object minecraft, byte type, Object... tickData)	{		isRemote = !isRemote;		if (Modchu_Debug.debugMessage				&& type == 2) {			Modchu_Debug.dDebugDrow();		}		if (!isRemote) return true;		if (runtimeExceptionFlag) throw new RuntimeException(runtimeExceptionString);		return true;	}	public static boolean isRelease() {		return isRelease;	}	static{		String s = System.getenv("modchu");		if ((s != null				&& s.equals("on"))) {			isRelease = false;		}	}	public static String getClassName(String s) {/*		if (s == null) return null;		if (s.indexOf(".") > -1) return s;		String s1 = getPackage();		if (s1 != null) return s1.concat(".").concat(s);*/		return s;	}	public static void getPackageInit() {		//if (!isForge) {		Package pack = modchu_Main.getClass().getPackage();		if (pack != null) packageName = pack.getName();		else packageName = null;/*		} else {			packageName = !isRelease ? "net.minecraft.src" : null;		}*/	}	public static String getPackage() {		return packageName;	}	public static String getHashMapKey(HashMap hashMap, int i) {		if (hashMap.size() < i				| i < 0) return null;		boolean flag = false;		Iterator iterator = hashMap.entrySet().iterator();		int j1 = 0;		do {			if (!iterator.hasNext()) break;			Entry entry = (Entry)iterator.next();			if (j1 == i) return (String)entry.getKey();			j1++;		} while (true);		for (Iterator iterator1 = hashMap.entrySet().iterator(); iterator1.hasNext();) {			Entry entry1 = (Entry)iterator1.next();			if (entry1 != null) return (String)entry1.getKey();		}		return null;	}	private static void startVersionCheckThread() {		Modchu_ThreadVersionCheck var0 = new Modchu_ThreadVersionCheck();		var0.start();	}	public static boolean checkRelease(String s) {		if (s != null) {			if (s.length() > 1) {				String ck = s.substring(s.length() - 1, s.length());				String mck = Modchu_Main.getVersion();				String k = version;				mck = k.substring(k.length() - 1);				if (integerCheck(mck)) mck = "";				boolean check = integerCheck(k);				//Modchu_Debug.mDebug("Modchulib checkRelease k="+k+" mck="+mck+" check="+check);				while(!check						&& k.length() > 1){					//Modchu_Debug.mDebug("Modchulib checkRelease k="+k);					check = integerCheck(k.substring(0, k.length() - 1));					k = k.substring(0, k.length() - 1);				}				int m = Integer.valueOf(k);				//Modchu_Debug.mDebug("Modchulib checkRelease m="+m+" mck="+mck);				if (integerCheck(ck)) ck = "";				check = integerCheck(s);				while(!check						&& s.length() > 1){					//Modchu_Debug.mDebug("Modchulib checkRelease s="+s);					check = integerCheck(s.substring(0, s.length() - 1));					s = s.substring(0, s.length() - 1);				}				int i = Integer.valueOf(s);				Modchu_Debug.mDebug("Modchulib checkRelease m="+m+" mck="+mck+" i="+i+" ck="+ck);				if (i > m) {					return true;				}				if (i == m						&& ck.compareTo(mck) > 0) {					return true;				}				return false;			}		}		return false;	}	public static int integerCheckReturnInt(String s) {		try {			Integer.valueOf(s);			return 1;		} catch (Exception e) {			try {				Long.valueOf(s);				return 2;			} catch (Exception e1) {				return -1;			}		}	}	public static boolean integerCheck(String s) {		try {			Integer.valueOf(s);			return true;		} catch (Exception e) {			return false;		}	}	public static boolean floatCheck(String s) {		try {			Float.valueOf(s);			return true;		} catch (Exception e) {			return false;		}	}	public static boolean byteCheck(String s) {		try {			Byte.valueOf(s);			return true;		} catch (Exception e) {			return false;		}	}	public static int getVersionStringConversionInt(String s) {		int i = 0;		if (s.length() > 1) {			String s1 = s.substring(s.length() - 1);			s = s.substring(0, s.length() - 1);			i = Integer.parseInt(s) * 100 + s1.compareTo("a") + 1;		} else {			i = Integer.parseInt(s) * 100;		}		return i;	}	public static void setNewRelease(String s) {		newRelease = true;		newVersion = s;	}	public static String lastIndexProcessing(String t, String t1) {		int j = t.lastIndexOf(t1);		if(j > -1) return t.substring(j + 1);		return t;	}	public static Object getMinecraft() {		if (isServer) return null;		Object o = Modchu_Reflect.invokeMethod("Minecraft", "func_71410_x", -1);		if (o != null) return o;		o = Modchu_Reflect.invokeMethod("Minecraft", "getMinecraft");		if (o != null) return o;		o = getMinecraftVersion() > 129 ? Modchu_Reflect.getPrivateValue("Minecraft", null, 8)				: Modchu_Reflect.getPrivateValue("Minecraft", null, 1);		if (o == null) {			Modchu_Debug.Debug("getMinecraft o == null !! Modchu_Reflect.loadClass(Minecraft)="+Modchu_Reflect.loadClass("Minecraft"));			Modchu_Debug.Debug("getMinecraft Modchu_Main.isForge="+Modchu_Main.isForge);			Modchu_Debug.Debug("getMinecraft Modchu_Main.getMinecraftVersion()="+Modchu_Main.getMinecraftVersion());			throw new RuntimeException("Modchu_Main-getMinecraft o == null !!");		}		return o;	}	public static EntityPlayer getThePlayer() {		if (isServer) return null;		if (mc != null) ;else mc = getMinecraft();/*		Modchu_Debug.Debug("getThePlayer mc="+(mc != null));		Field[] f = mc.getClass().getDeclaredFields();		for(int i = 0; i < f.length; i++) {			Modchu_Debug.mlDebug("getThePlayer i="+i+" "+f[i].getName());		}*/		return (EntityPlayer) Modchu_Reflect.getFieldObject("Minecraft", "field_71439_g", "thePlayer", mc);	}	public static void setThePlayer(EntityPlayer entityPlayer) {		if (isServer) return;		if (mc != null) ;else mc = getMinecraft();		Modchu_Reflect.setFieldObject("Minecraft", "field_71439_g", "thePlayer", mc, entityPlayer);	}	public static World getTheWorld() {		if (isServer) return null;		if (mc != null) ;else mc = getMinecraft();		return (World) Modchu_Reflect.getFieldObject("Minecraft", "field_71441_e", "theWorld", mc);	}	public static File getMinecraftDir() {		if (isServer) return new File(".");		if (mc != null) ;else mc = getMinecraft();		if (mc != null) ;else {			Modchu_Debug.Debug("Modchu_Main getMinecraftDir == null !!");			return null;		}		File file = (File) (getMinecraftVersion() > 159 ? Modchu_Reflect.getFieldObject("Minecraft", "field_71412_D", mc, -1) :			Modchu_Reflect.invokeMethod("Minecraft", "func_71380_b", mc, -1));		if (file != null) return file;		file = (File) (getMinecraftVersion() > 159 ? Modchu_Reflect.getFieldObject("Minecraft", "mcDataDir", mc) :			Modchu_Reflect.invokeMethod("Minecraft", "getMinecraftDir", mc));		return file;	}	public static void printChatMessage(String s) {		Object ingameGUI = Modchu_Reflect.getFieldObject("Minecraft", "field_71456_v", "ingameGUI", Modchu_Main.getMinecraft());		if (ingameGUI != null) ;else {			Modchu_Debug.lDebug("printChatMessage ingameGUI == null !!");			return;		}		Object chatGUI = Modchu_Reflect.invokeMethod(ingameGUI.getClass(), "func_73827_b", "getChatGUI", ingameGUI);		if (chatGUI != null) ;else {			Modchu_Debug.lDebug("printChatMessage chatGUI == null !!");			return;		}		Modchu_Reflect.invokeMethod(chatGUI.getClass(), "func_73765_a", "printChatMessage", new Class[]{ String.class }, chatGUI, new Object[]{ s });	}    public static boolean isCtrlKeyDown()    {    	boolean b = getMinecraftVersion() > 159 ? (Boolean)Modchu_Reflect.getFieldObject("Minecraft", "field_142025_a", "isRunningOnMac", getMinecraft()) :    		Modchu_Reflect.invokeMethod("Minecraft", "func_71376_c", "getOs", getMinecraft()) == EnumOS.MACOS;    	return b ? Keyboard.isKeyDown(219) || Keyboard.isKeyDown(220) : Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157);    }    public static boolean isShiftKeyDown()    {        return Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54);    }	public static int getMinecraftVersion() {		return Modchu_Main.modchuLibVersion;	}	public static int getVacancyGlobalEntityID() {		if (getMinecraftVersion() < 150) {			Modchu_Debug.mDebug("getVacancyGlobalEntityID getMinecraftVersion()="+getMinecraftVersion());			return (Integer) Modchu_Reflect.invokeMethod("ModLoader", "getUniqueEntityId");		}		Map map = (Map) Modchu_Reflect.getFieldObject(EntityList.class, "field_75623_d", -1);		if (map != null) ;else map = (Map) Modchu_Reflect.getFieldObject(EntityList.class, "IDtoClassMapping");		int ID = -1;		if (map != null) {			for(int i = 64; i < 3000; i++) {				//Modchu_Debug.mDebug("i"+i+" !map.containsKey(i) = "+(!map.containsKey(i)));				if (!map.containsKey(i)) {					ID = i;					//Modchu_Debug.mDebug("!map.containsKey ID="+ID);					break;				}			}		} else {			Modchu_Debug.lDebug("IDtoClassMapping map == null !!");		}		return ID;	}}