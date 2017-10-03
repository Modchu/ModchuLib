package modchu.lib;public class Modchu_Version {	public static final String modchulibVersionString = "20a";	public static final String modName = "modchulib";	public static String modchulibForForgeVersionString;	public static Modchu_Version instance;	public int minecraftVersionInt;	public String minecraftVersionString;	public Modchu_Version(int i, String s) {		instance = this;		minecraftVersionInt = i;		minecraftVersionString = s;		modchulibForForgeVersionString = ""+ getMinecraftVersion() + "-" + Modchu_Version.modchulibVersionString;	}	public static String getForgeVersionBuildVersionToMcVersion(String s, String s1, String s2, String s3) {		int i = Integer.valueOf(s);		if (i > 0) {			int i1 = Integer.valueOf(s1);			int i3 = Integer.valueOf(s3);			switch(i) {			case 1:				if (i3 < 3) return "1.0";				if (i3 < 30) return "1.1";				return "1.2.3";			case 2:				return "1.2.4";			case 3:				return "1.2.5";			case 4:				if (i3 < 202) return "1.3.1";				return "1.3.2";			case 5:				return "1.4.0";			case 6:				if (i3 < 330) return "1.4.1";				if (i3 < 356) return "1.4.2";				if (i3 < 360) return "1.4.3";				if (i3 < 379) return "1.4.4";				if (i3 < 451) return "1.4.5";				if (i3 < 490) return "1.4.6";				return "1.4.7";			case 7:				if (i3 < 600) return "1.5";				if (i3 < 684) return "1.5.1";				return "1.5.2";			case 8:				if (i3 < 776) return "1.6.1";				break;			case 9:				if (i3 < 873) return "1.6.2";				if (i3 < 879) return "1.6.3";				return "1.6.4";			case 10:				if (i1 == 12) return "1.7.2";				return "1.7.10";			case 11:				if (i3 > 1660) return "1.8.9";				if (i3 != 1577) {					if (i3 > 1574							| i1 == 15) {						//return "1.8.8";						//強制1.8.9判定						return "1.8.9";					}				}				return "1.8";			case 12:				return i1 == 16 ? "1.9" : i1 == 17 ? "1.9.4" : "1.10.2";			case 13:				return i1 == 19 ? "1.11" : "1.11.2";			case 14:				return i1 == 21 ? "1.12" : i1 == 22 ? "1.12.1" : "1.12.2";			}		}		return "1.12.2";	}	public static int getVersionStringToMinecraftVersionInt(String s) {		if (s.equals("1.12.2")) return 222;		if (s.equals("1.12.1")) return 221;		if (s.equals("1.12")) return 220;		if (s.equals("1.11.2")) return 212;		if (s.equals("1.11")) return 210;		if (s.equals("1.10.2")) return 202;		if (s.equals("1.9.4")) return 194;		if (s.equals("1.9")) return 190;		if (s.equals("1.8.9")) return 189;		if (s.equals("1.8.8")) return 188;		if (s.equals("1.8")) return 180;		if (s.equals("1.7.10")) return 179;		if (s.equals("1.7.2")) return 172;		if (s.equals("1.6.4")) return 164;		if (s.equals("1.6.2")) return 162;		if (s.equals("1.5.2")) return 152;		if (s.equals("1.4.7")) return 147;		if (s.equals("1.4.6")) return 146;		if (s.equals("1.4.5")) return 145;		if (s.equals("1.4.2")) return 142;		if (s.equals("1.3.2")) return 132;		if (s.equals("1.2.5")) return 125;		return -1;	}	public static String[] getModchuCharacteristicVersionStrings() {		int version = Modchu_Version.getMinecraftVersion();		if (version == 222) {			return new String[]{					"222",					"220_222",					"212_222",					"210_222",					"202_222",					"194_222",					"190_222",					"189_222",					"188_222",					"180_222",					"172_222",					"164_222",					"162_222",					"152_222"			};		}		if (version == 221) {			return new String[]{					"221",					"220_222",					"212_222",					"210_222",					"202_222",					"194_222",					"190_222",					"189_222",					"188_222",					"180_222",					"172_222",					"164_222",					"162_222",					"152_222"			};		}		if (version == 220) {			return new String[]{					"220",					"220_222",					"212_222",					"210_222",					"202_222",					"194_222",					"190_222",					"189_222",					"188_222",					"180_222",					"172_222",					"164_222",					"162_222",					"152_222"			};		}		if (version == 212) {			return new String[]{					"212",					"212_222",					"210_212",					"210_222",					"202_212",					"202_222",					"194_212",					"194_222",					"190_212",					"190_222",					"189_212",					"189_222",					"188_212",					"188_222",					"180_212",					"180_222",					"172_212",					"172_222",					"164_212",					"164_222",					"162_212",					"162_222",					"152_212",					"152_222"			};		}		if (version == 210) {			return new String[]{					"210",					"210_212",					"210_222",					"202_210",					"202_212",					"202_222",					"194_210",					"194_212",					"194_222",					"190_210",					"190_212",					"190_222",					"189_210",					"189_212",					"189_222",					"188_210",					"188_212",					"188_222",					"180_210",					"180_212",					"180_222",					"172_210",					"172_212",					"172_222",					"164_210",					"164_212",					"164_222",					"162_210",					"162_212",					"162_222",					"152_210",					"152_212",					"152_222"			};		}		if (version == 202) {			return new String[]{					"202",					"202_210",					"202_212",					"202_222",					"202_212",					"194_202",					"194_210",					"194_212",					"194_222",					"190_202",					"190_210",					"190_212",					"190_222",					"189_202",					"189_210",					"189_212",					"189_222",					"188_202",					"188_210",					"188_212",					"188_222",					"180_202",					"180_210",					"180_212",					"180_222",					"172_202",					"172_210",					"172_212",					"172_222",					"164_202",					"164_210",					"164_212",					"164_222",					"162_202",					"162_210",					"162_212",					"162_222",					"152_202",					"152_210",					"152_212",					"152_222"			};		}		if (version == 194) {			return new String[]{					"194",					"194_202",					"194_210",					"194_212",					"194_222",					"190_194",					"190_202",					"190_210",					"190_212",					"190_222",					"189_194",					"189_202",					"189_210",					"189_212",					"189_222",					"188_194",					"188_202",					"188_210",					"188_212",					"188_222",					"180_194",					"180_202",					"180_210",					"180_212",					"180_222",					"172_194",					"172_202",					"172_210",					"172_212",					"172_222",					"164_194",					"164_202",					"164_210",					"164_212",					"164_222",					"162_194",					"162_202",					"162_210",					"162_212",					"162_222",					"152_194",					"152_202",					"152_210",					"152_212",					"152_222"			};		}		if (version == 190) {			return new String[]{					"190",					"190_194",					"190_202",					"190_210",					"190_212",					"190_222",					"189_190",					"189_194",					"189_202",					"189_210",					"189_212",					"189_222",					"188_190",					"188_194",					"188_202",					"188_210",					"188_212",					"188_222",					"180_190",					"180_194",					"180_202",					"180_210",					"180_212",					"180_222",					"179_190",					"179_194",					"179_202",					"179_210",					"179_212",					"179_222",					"172_190",					"172_194",					"172_202",					"172_210",					"172_212",					"172_222",					"164_190",					"164_194",					"164_202",					"164_210",					"164_212",					"164_222",					"162_190",					"162_194",					"162_202",					"162_210",					"162_212",					"162_222",					"152_190",					"152_194",					"152_202",					"152_210",					"152_212",					"152_222"			};		}		if (version == 189) {			return new String[]{					"189",					"189_190",					"189_194",					"189_202",					"189_210",					"189_212",					"189_222",					"188_189",					"188_190",					"188_194",					"188_202",					"188_210",					"188_212",					"188_222",					"180_189",					"180_190",					"180_194",					"180_202",					"180_210",					"180_212",					"180_222",					"179_189",					"179_190",					"179_194",					"179_202",					"179_210",					"179_212",					"179_222",					"172_189",					"172_190",					"172_194",					"172_202",					"172_210",					"172_212",					"172_222",					"164_189",					"164_190",					"164_194",					"164_202",					"164_210",					"164_212",					"164_222",					"162_189",					"162_190",					"162_194",					"162_202",					"162_210",					"162_212",					"162_222",					"152_189",					"152_190",					"152_194",					"152_202",					"152_210",					"152_212",					"152_222"			};		}		if (version == 180) {			return new String[]{					"180",					"180_188",					"180_189",					"180_190",					"180_194",					"180_202",					"180_210",					"180_212",					"180_222",					"172_180",					"172_188",					"172_189",					"172_190",					"172_194",					"172_202",					"172_210",					"172_212",					"172_222",					"164_180",					"164_188",					"164_189",					"164_190",					"164_194",					"164_202",					"164_210",					"164_212",					"164_222",					"162_180",					"162_188",					"162_189",					"162_190",					"162_194",					"162_202",					"162_210",					"162_212",					"162_222",					"152_189",					"152_190",					"152_194",					"152_202",					"152_210",					"152_212",					"152_222"			};		}		if (version == 179) {			return new String[]{					"179",					"179_180",					"179_188",					"179_189",					"179_190",					"179_194",					"179_202",					"179_210",					"179_212",					"179_222",					"172_179",					"172_180",					"172_188",					"172_189",					"172_190",					"172_194",					"172_202",					"172_210",					"172_212",					"172_222",					"164_179",					"164_180",					"164_188",					"164_189",					"164_190",					"164_194",					"164_202",					"164_210",					"164_212",					"164_222",					"162_179",					"162_180",					"162_188",					"162_189",					"162_190",					"162_194",					"162_202",					"162_210",					"162_212",					"162_222",					"152_179",					"152_189",					"152_190",					"152_194",					"152_202",					"152_210",					"152_212",					"152_222"			};		}		if (version == 172) {			return new String[]{					"172",					"172_179",					"172_180",					"172_188",					"172_189",					"172_190",					"172_194",					"172_202",					"172_210",					"172_212",					"172_222",					"164_179",					"164_180",					"164_188",					"164_189",					"164_190",					"164_194",					"164_202",					"164_210",					"164_212",					"164_222",					"162_179",					"162_180",					"162_188",					"162_189",					"162_190",					"162_194",					"162_202",					"162_210",					"162_212",					"162_222",					"152_179",					"152_189",					"152_190",					"152_194",					"152_202",					"152_210",					"152_212",					"152_222"			};		}		if (version == 164) {			return new String[]{					"164",					"164_179",					"164_180",					"164_188",					"164_189",					"164_190",					"164_194",					"164_202",					"164_210",					"164_212",					"164_222",					"162_164",					"162_179",					"162_180",					"162_188",					"162_189",					"162_190",					"162_194",					"162_202",					"162_210",					"162_212",					"162_222",					"152_164",					"152_179",					"152_189",					"152_190",					"152_194",					"152_202",					"152_210",					"152_212",					"152_222"			};		}		if (version == 162) {			return new String[]{					"162",					"162_164",					"162_179",					"162_180",					"162_188",					"162_189",					"162_190",					"162_194",					"162_202",					"162_210",					"162_212",					"162_222",					"152_162",					"152_164",					"152_179",					"152_189",					"152_190",					"152_194",					"152_202",					"152_210",					"152_212",					"152_222"			};		}		if (version == 152) {			return new String[]{					"152",					"152_162",					"152_164",					"152_179",					"152_189",					"152_190",					"152_194",					"152_202",					"152_210",					"152_212",					"152_222"			};		}		return null;	}	public int getMinecraftVersionInt() {		return minecraftVersionInt;	}	public String getMinecraftVersionStringI() {		return minecraftVersionString;	}	public static int getMinecraftVersion() {		return instance.getMinecraftVersionInt();	}	public static String getMinecraftVersionString() {		return instance.getMinecraftVersionStringI();	}}