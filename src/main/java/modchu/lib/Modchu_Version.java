package modchu.lib;public class Modchu_Version {	public static final String modchulibVersionString = "11c";	public static final String modName = "mod_Modchu_ModchuLib";	public static final String modSimpleName = "modchulib";	public static String modchulibForForgeVersionString;	public static Modchu_Version instance;	public int minecraftVersionInt;	public String minecraftVersionString;	public Modchu_Version(int i, String s) {		instance = this;		minecraftVersionInt = i;		minecraftVersionString = s;		modchulibForForgeVersionString = ""+ getMinecraftVersion() + "-" + Modchu_Version.modchulibVersionString;	}	public int getMinecraftVersionInt() {		return minecraftVersionInt;	}	public String getMinecraftVersionStringI() {		return minecraftVersionString;	}	public static int getMinecraftVersion() {		return instance.getMinecraftVersionInt();	}	public static String getMinecraftVersionString() {		return instance.getMinecraftVersionStringI();	}}