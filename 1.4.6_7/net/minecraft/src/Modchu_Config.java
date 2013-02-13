package net.minecraft.src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.minecraft.client.Minecraft;

public class Modchu_Config
{
    private static Map cfgData = new HashMap();
	private static Class mod_PFLM_PlayerFormLittleMaid;
	private static Class PFLM_Gui;
	private static Class PFLM_GuiOthersPlayer;

	public static void init(String s) {
		if (s != null) s = s.concat(".");
		else s = "";
		mod_PFLM_PlayerFormLittleMaid = Modchu_Reflect.loadClass(s.concat("mod_PFLM_PlayerFormLittleMaid").toString());
		PFLM_Gui = Modchu_Reflect.loadClass(s.concat("PFLM_Gui").toString());
		PFLM_GuiOthersPlayer = Modchu_Reflect.loadClass(s.concat("PFLM_GuiOthersPlayer").toString());
	}

	public static void writerConfig(File file, String[] s) {
		//設定ファイル書き込み
		try {
			BufferedWriter bwriter = new BufferedWriter(new FileWriter(
					file));
			StringBuilder sb = new StringBuilder();
			List list = new ArrayList();
			for (int i = 0; i < s.length ; i++) {
				list.add(s[i]);
				sb.append(s[i]);
				bwriter.write(sb.toString());
				bwriter.newLine();
				sb.delete(0, sb.length());
			}
			cfgData.put(file, list);
			bwriter.close();
			Modchu_Debug.mDebug("Modchu_Config "+ file.toString() +" new file create.");
		} catch (Exception e) {
			Modchu_Debug.Debug("Modchu_Config "+ file.toString() +" file writer fail.");
			e.printStackTrace();
		}
	}

	public static Object loadConfig(List configList, File file, String s, Object o) {
		// cfg設定項目読み込み showModel読み込み有り
		List list = new ArrayList();
		list = (ArrayList) cfgData.get(file);
		if (list == null) {
			list = new ArrayList();
			try {
				BufferedReader breader = new BufferedReader(new FileReader(
						file));
				String rl;
				for (int i = 0; (rl = breader.readLine()) != null ; i++) {
					int i1;
					list.add(rl);
					if (rl.startsWith("#")
							| rl.startsWith("/")) continue;
					if (rl.indexOf("showModel[]") != -1) {
						i1 = rl.indexOf('.');
						if (i1 > -1) {
							configList.add(rl);
							//Modchu_Debug.mDebug("cfg "+ file.toString() +" load " + rl);
						}
					}
					if (rl.startsWith(s)) {
						i1 = rl.indexOf('=');
						if (i1 > -1) {
							if (s.length() == i1) {
								o = rl.substring(i1 + 1);
								//Modchu_Debug.mDebug("cfg "+ file.toString() +" load ok s.length()="+s.length()+" i1="+i1+" rl="+rl);
							} else {
								//Modchu_Debug.mDebug("cfg "+ file.toString() +" load s.length()="+s.length()+" i1="+i1+" rl="+rl);
							}
						}
					}
				}
				cfgData.put(file, list);
				breader.close();
				//Modchu_Debug.mDebug("Modchu_Config loadConfig1 o = "+o.toString());
			} catch (Exception e) {
				Modchu_Debug.Debug("Modchu_Config loadConfig "+ file.toString() +" load fail.");
				e.printStackTrace();
			}
		} else {
			String s2;
			for (int i = 0; i < list.size() ; i++) {
				s2 = (String) list.get(i);
				if (s2.startsWith(s)) {
					int i1 = s2.indexOf('=');
					if (i1 > -1
							&& s.length() == i1) {
						o = s2.substring(i1 + 1);
						break;
					}
				}
			}
			//Modchu_Debug.mDebug("Modchu_Config loadConfig2 o = "+o.toString());
		}
		return o;
	}


	public static Object loadConfig(File file, String s, Object o) {
		// cfg設定項目読み込み showModel読み込み無し
		List list = new ArrayList();
		list = (ArrayList) cfgData.get(file);
		if (list == null) {
			list = new ArrayList();
			try {
				BufferedReader breader = new BufferedReader(new FileReader(
						file));
				String rl;
				for (int i = 0; (rl = breader.readLine()) != null ; i++) {
					int i1;
					list.add(rl);
					if (rl.startsWith("#")
							| rl.startsWith("/")) continue;
					if (rl.startsWith(s)) {
						i1 = rl.indexOf('=');
						if (i1 > -1) {
							if (s.length() == i1) {
								o = rl.substring(i1 + 1);
								//Modchu_Debug.mDebug("cfg "+ file.toString() +" load ok s.length()="+s.length()+" i1="+i1+" rl="+rl);
							} else {
								//Modchu_Debug.mDebug("cfg "+ file.toString() +" load s.length()="+s.length()+" i1="+i1+" rl="+rl);
							}
						}
					}
				}
				cfgData.put(file, list);
				breader.close();
				//Modchu_Debug.mDebug("Modchu_Config loadConfig1 o = "+o.toString());
			} catch (Exception e) {
				Modchu_Debug.Debug("Modchu_Config loadConfig "+ file.toString() +" load fail.");
				e.printStackTrace();
			}
		} else {
			String s2;
			for (int i = 0; i < list.size() ; i++) {
				s2 = (String) list.get(i);
				if (s2.startsWith(s)) {
					int i1 = s2.indexOf('=');
					//if (s.equalsIgnoreCase("shortcutKeysTextureName[6]")) Modchu_Debug.mDebug("Modchu_Config loadConfig2 s2 = "+s2+" s="+s+" s.length()="+s.length()+" i1="+i1);
					if (i1 > -1
							&& s.length() == i1) {
						o = s2.substring(i1 + 1);
						break;
					}
				}
			}
			//Modchu_Debug.mDebug("Modchu_Config loadConfig2 o = "+o.toString());
		}
		return o;
	}

	public static void writerSupplementConfig(File file, String[] k, String[] k1) {
		//設定ファイルにない項目追加書き込み
		if (file.exists() && file.canRead() && file.canWrite()) {
			List lines = new LinkedList();
			try {
				BufferedReader breader = new BufferedReader(new FileReader(
						file));
				String rl;
				String s;
				String s1;
				boolean[] e = new boolean[k.length];
				boolean ee = false;
				StringBuilder sb = new StringBuilder();
				while ((rl = breader.readLine()) != null) {
					for (int i = 0; i < k.length ; i++) {
						s = k[i];
						if(!e[i]) {
							if (rl.startsWith(s)) {
								int i1 = rl.indexOf('=');
								if (i1 > -1) {
									if (s.length() == i1) {
										sb.delete(0, sb.length());
										sb.append(s).append("=")
										.append(k1[i]);
										lines.add(sb.toString());
										e[i] = true;
										//Modchu_Debug.mDebug("saveParamater true rl=" + rl);
										break;
									}
								}
							}
						}
					}
				}
				// 読み込めない項目があったかチェック、読み込めない項目があると作成しなおし
				Boolean e1 = false;
				for (int i = 0; i < k.length; i++) {
					if (e[i] == false) {
						e1 = true;
						continue;
					}
				}
				if (e1) {
					sb.delete(0, sb.length());
					//Modchu_Debug.mDebug("cfg file save. e=" + l.toString());
					for(int i = 0; i < k.length ; i++) {
						if (!e[i]) {
							s = k[i];
							sb.append(s).append("=");
							sb.append(k1[i]);
							lines.add(sb.toString());
							sb.delete(0, sb.length());
							//Modchu_Debug.mDebug("saveParamater save. k["+i+"]=" + k[i]+" k1["+i+"]=" + k1[i]);
						}
					}
				}
			} catch (Exception er) {
				Modchu_Debug.Debug("saveParamater file error.");
				er.printStackTrace();
			}
			try {
			// 保存
				if (!lines.isEmpty()
						&& (file.exists() || file.createNewFile())
						&& file.canWrite()) {
					BufferedWriter bwriter = new BufferedWriter(
							new FileWriter(file));
					String t;
					for (int i = 0 ; i < lines.size() ; i++) {
						t = (String) lines.get(i);
						bwriter.write(t);
						bwriter.newLine();
					}
					bwriter.close();
				}
			} catch (Exception er) {
				Modchu_Debug.Debug("saveParamater file save fail.");
				er.printStackTrace();
			}
		}
	}

	public static void saveParamater(File file, String[] k, String[] k1) {
		// Gui設定項目をcfgファイルに保存
		String textureName = getTextureName();
		int maidColor = getMaidColor();
		boolean partsSaveFlag = getPartsSaveFlag();
		HashMap<String, Boolean> parts = getParts();
		HashMap<Integer, String> showPartsNemeList = getShowPartsNemeList();
		if (file.exists() && file.canRead() && file.canWrite()) {
			List lines = new LinkedList();
			try {
				BufferedReader breader = new BufferedReader(new FileReader(
						file));
				String rl;
				String s;
				String s1;
				boolean[] e = new boolean[k.length];
				boolean ee = false;
				StringBuilder sb = new StringBuilder();
				while ((rl = breader.readLine()) != null) {
					for (int i = 0; i < k.length ; i++) {
						s = k[i];
						if(!e[i]) {
							if (rl.startsWith(s)) {
								int i1 = rl.indexOf('=');
								if (i1 > -1) {
									if (s.length() == i1) {
										sb.delete(0, sb.length());
										sb.append(s).append("=")
										.append(k1[i]);
										lines.add(sb.toString());
										e[i] = true;
										//Modchu_Debug.mDebug("saveParamater true rl=" + rl);
										break;
									}
								}
							}
						}
					}
				}
				breader = new BufferedReader(new FileReader(file));
				//showModel[]専用
				while ((rl = breader.readLine()) != null) {
					if (partsSaveFlag) {
						//Modchu_Debug.mDebug("cfg file save.0 rl=" + rl);
						s = "showModel[]";
						if (rl.indexOf(s) != -1) {
							s = textureName != null ? textureName : "default";
							//Modchu_Debug.mDebug("cfg file save.1 s=" + s);
							if (rl.startsWith(s)) {
								rl = rl.substring(s.length());
								int i1 = rl.indexOf('.');
								if (i1 > -1) {
									rl = rl.substring(i1 + 1);
									i1 = rl.indexOf('.');
									//Modchu_Debug.mDebug("cfg file save.2 i1=" + i1);
									if(i1 > -1) {
										i1 = Integer.parseInt(rl.substring(0, i1));
										sb.delete(0, sb.length());
										//Modchu_Debug.mDebug("cfg file save.3 i1=" + i1);
										if (i1 == maidColor) {
											StringBuilder sb1 = new StringBuilder();
											sb1.append(s).append(".").append(maidColor).append(".showModel[]=");
											String s2 = null;
											for (int i2 = 0; i2 < parts.size(); i2++) {
												s2 = showPartsNemeList.get(i2);
												//sb1.append(s2).append(":");
												sb1.append(parts.get(showPartsNemeList.get(i2)));
												if(i2 != parts.size() - 1) sb1.append(",");
											}
											sb.append(sb1);
											lines.add(sb.toString());
											Modchu_Debug.mDebug("cfg file save. " + s);
											ee = true;
											continue;
										}
									}
								}
							}
						}
					}
					s = "showModel[]";
					if (rl.indexOf(s) != -1) {
						lines.add(rl);
						continue;
					}
				}
				// 読み込めない項目があったかチェック、読み込めない項目があると作成しなおし
				Boolean e1 = false;
				for (int i = 0; i < k.length; i++) {
					if (e[i] == false) {
						e1 = true;
						continue;
					}
				}
				if (e1
						| !ee) {
					sb.delete(0, sb.length());
					//Modchu_Debug.mDebug("cfg file save. e=" + l.toString());
					for(int i = 0; i < k.length ; i++) {
						if (!e[i]) {
							s = k[i];
							sb.append(s).append("=");
							sb.append(k1[i]);
							lines.add(sb.toString());
							sb.delete(0, sb.length());
						}
					}
					if (!ee
							&& partsSaveFlag) {
						s = textureName != null ? textureName : "default";
						StringBuilder sb1 = new StringBuilder();
						sb1.append(s).append(".").append(maidColor).append(".showModel[]=");
						String s2 = null;
						for (int i = 0; i < parts.size(); i++) {
							s2 = mod_Modchu_ModchuLib.getHashMapKey(parts, i);
							sb1.append(parts.get(s2));
							if(i != parts.size() - 1) sb1.append(",");
						}
						sb.append(sb1);
						lines.add(sb.toString());
						sb.delete(0, sb.length());
						Modchu_Debug.mDebug("saveParamater file save. s=" + s);
					}
					//Modchu_Debug.mDebug("cfg file save. e[4]=" + e[4]);
				}
			} catch (Exception er) {
				Modchu_Debug.Debug("saveParamater file error.");
				er.printStackTrace();
			}
			try {
			// 保存
				if (!lines.isEmpty()
						&& (file.exists() || file.createNewFile())
						&& file.canWrite()) {
					BufferedWriter bwriter = new BufferedWriter(
							new FileWriter(file));
					String t;
					for (int i = 0 ; i < lines.size() ; i++) {
						t = (String) lines.get(i);
						bwriter.write(t);
						bwriter.newLine();
					}
					bwriter.close();
				}
			} catch (Exception er) {
				Modchu_Debug.Debug("saveParamater file save fail.");
				er.printStackTrace();
			}
		}
	}

	public static void loadConfigShowModel(List configList, File file) {
		// cfg設定項目ShowModel[]読み込み
		try {
			BufferedReader breader = new BufferedReader(new FileReader(
					file));
			String rl;
			for (int i = 0; (rl = breader.readLine()) != null && i < file.length(); i++) {
				int i1;
				if (rl.startsWith("#")
						| rl.startsWith("/")) continue;
				if (rl.indexOf("showModel[]") > -1) {
					i1 = rl.indexOf('.');
					if (i1 > -1) {
						configList.add(rl);
						//Modchu_Debug.mDebug("cfg load " + rl);
					}
				}
			}
			breader.close();
			//Modchu_Debug.mDebug("Modchu_Config loadConfigShowModel");
		} catch (Exception e) {
			Modchu_Debug.Debug("Modchu_Config loadConfigShowModel load fail.");
			e.printStackTrace();
		}
		//Modchu_Debug.mDebug("Modchu_Config loadConfigShowModel");
	}

	public static void loadShowModelList(List<String> list) {
		String textureName = getTextureName();
		int maidColor = getMaidColor();
		HashMap<String, Boolean> map = getParts();
		HashMap<Integer, String> showPartsNemeList = getShowPartsNemeList();
		try {
			//Modchu_Debug.mDebug("loadShowModelList showModelList="+showModelList);
			if(!list.isEmpty()) {
				String s = null;
				//Modchu_Debug.mDebug("loadShowModelList 2");
				for (String rl : list.toArray(new String[0])) {
					//Modchu_Debug.mDebug("loadShowModelList rl="+rl);
					if(rl != null) {
						s = "showModel[]";
						if (rl.indexOf(s) > -1) {
							//Modchu_Debug.mDebug("loadShowModelList showModelList="+showModelList);
							//Modchu_Debug.mDebug("loadShowModelList rl="+rl);
							s = textureName != null ? textureName : "default";
							//Modchu_Debug.mDebug("loadShowModelList s="+s);
							if (rl.indexOf(s) > -1) {
								rl = rl.substring(s.length());
								int i1 = rl.indexOf('.');
								if (i1 > -1) {
									rl = rl.substring(i1 + 1);
									i1 = rl.indexOf('.');
									if (i1 > -1) {
										int i2 = Integer.parseInt(rl.substring(0, i1));
										//Modchu_Debug.mDebug("loadShowModelList i2="+rl.substring(0, i1));
										String s1 = null;
										if(maidColor == i2) {
											rl = rl.substring(rl.indexOf('=') + 1);
											for(int i3 = 0; i3 <= map.size() && rl != null; i3++) {
												i1 = rl.indexOf(',');
												s1 = showPartsNemeList.get(i3);
												map.put(s1, i1 != -1 ? Boolean.parseBoolean(rl.substring(0, i1)): Boolean.parseBoolean(rl));
												//Modchu_Debug.mDebug("loadShowModelList s1="+(i1 != -1 ? Boolean.parseBoolean(rl.substring(0, i1)): Boolean.parseBoolean(rl)));
												rl = i1 != -1 ? rl.substring(i1 + 1): null;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		} catch (Exception ee) {
			Modchu_Debug.Debug("loadShowModelList fail.");
			ee.printStackTrace();
		}
	}

	public static void writerModelList(String[] s, File file, List<String> list) {
		//Listファイル書き込み
		try {
			BufferedWriter bwriter = new BufferedWriter(new FileWriter(file));
			list.clear();
			for (int i = 0; i < s.length ; i++)
			{
				//Modchu_Debug.mDebug("s[i]="+s[i]);
				if (s[i] != null) {
					bwriter.write(s[i]);
					if (i != 0) list.add(s[i]);
					bwriter.newLine();
				}
			}
			bwriter.close();
			//Modchu_Debug.Debug("file new file create.");
		} catch (Exception e) {
			Modchu_Debug.Debug("file writer fail.");
			e.printStackTrace();
			Modchu_Debug.Debug(" ");
		}
	}

	public static boolean loadList(File file, List<String> list,String listName) {
		// ModelList読み込み
		List<String> lines = new ArrayList<String>();
		try {
			BufferedReader breader = new BufferedReader(new FileReader(
					file));
			String rl;
			int i = 0;
			while ((rl = breader.readLine()) != null) {
				//Modchu_Debug.mDebug("rl="+rl);
				if (i == 0) {
					if (rl.startsWith("autoUpdates")) {
						int k = rl.indexOf("=");
						if (k > -1) {
							if (Boolean.valueOf(rl.substring(k + 1))) return false;
						} else return false;
					} else {
						return false;
					}
				} else {
					list.add(rl);
				}
				i++;
			}
			breader.close();
			//Modchu_Debug.mDebug("modelList "+listName+" load end.");
		} catch (Exception e) {
			Modchu_Debug.Debug("modelList file "+listName+" load fail.");
			e.printStackTrace();
			Modchu_Debug.Debug(" ");
			return false;
		}
		return true;
	}

	public String getClassName(String s) {
		if (s == null) return null;
		Package pac = getClass().getPackage();
		if (pac != null) s = pac.getName().concat(".").concat(s);
		return s;
	}

	public static void clearCfgData() {
		cfgData.clear();
	}

	public static void saveOthersPlayerParamater(String playerName, HashMap map, File file, String[] k, String[] k1, boolean flag) {
		// GuiOthersPlayer設定項目をcfgファイルに保存
		if (file.exists() && file.canRead() && file.canWrite()) {
			List lines = new LinkedList();
			try {
				BufferedReader breader = new BufferedReader(new FileReader(
						file));
				String rl;
				String s;
				String s1;
				boolean[] e = new boolean[k.length];
				boolean ee = false;
				StringBuilder sb = new StringBuilder();
				while ((rl = breader.readLine()) != null) {
					for (int i = 0; i < k.length ; i++) {
						s = k[i];
						if(!e[i]) {
							if (rl.startsWith(s)) {
								int i1 = rl.indexOf('=');
								if (i1 > -1) {
									if (s.length() == i1) {
										sb.delete(0, sb.length());
										sb.append(s).append("=")
										.append(k1[i]);
										lines.add(sb.toString());
										e[i] = true;
										//Modchu_Debug.mDebug("saveOthersPlayerParamater true rl=" + rl);
										break;
									}
								}
							}
						}
					}
				}
				breader = new BufferedReader(new FileReader(file));
				//OthersPlayer[]専用
				while ((rl = breader.readLine()) != null) {
					String m = (String) rl;
					if (flag) {
						//Modchu_Debug.mDebug("cfgOthersPlayer file save.0 rl=" + rl);
						String t[] = (String[]) map.get(playerName);
						s = "OthersPlayer[]";
						if (rl.indexOf(s) != -1) {
							rl = rl.substring(s.length());
							int i1;
							boolean flag1 = false;
							if (rl.startsWith("[")
									| rl.startsWith(".")) {
								rl = rl.substring(1);
								s = playerName;
								if (rl.startsWith(s)) flag1 = true;
							}
							if (flag1) {
								//Modchu_Debug.mDebug("cfgOthersPlayer file save.1 s=" + s +" rl="+rl);
								sb.delete(0, sb.length());
								//Modchu_Debug.mDebug("cfg file save.3 i1=" + i1);
								StringBuilder sb1 = new StringBuilder();
								sb1.append("OthersPlayer[]").append("[").append(s);
								for(int i = 0; i < t.length ;i++) {
									sb1.append("][").append(t[i]);
								}
								sb1.append("]");
								lines.add(sb1.toString());
								Modchu_Debug.mDebug("cfgOthersPlayer file save. " + s);
								ee = true;
								continue;
							}
						}
					}
					s = "OthersPlayer[]";
					if (m.indexOf(s) != -1) {
						//Modchu_Debug.mDebug("cfgOthersPlayer OthersPlayer[]add");
						lines.add(m);
						continue;
					}
				}
				// 読み込めない項目があったかチェック、読み込めない項目があると作成しなおし
				Boolean e1 = false;
				for (int i = 0; i < k.length; i++) {
					if (e[i] == false) {
						e1 = true;
						continue;
					}
				}
				if (e1
						| !ee) {
					sb.delete(0, sb.length());
					//Modchu_Debug.mDebug("cfgOthersPlayer file save. e=" + l.toString());
					for(int i = 0; i < k.length ; i++) {
						if (!e[i]) {
							s = k[i];
							sb.append(s).append("=");
							sb.append(k1[i]);
							lines.add(sb.toString());
							sb.delete(0, sb.length());
						}
					}
					if (!ee
							&& flag) {
						s = playerName;
						String t[] = (String[]) map.get(playerName);
						StringBuilder sb1 = new StringBuilder();
						sb1.append("OthersPlayer[]").append("[").append(s).append("][").append(t[0]).append("][")
						.append(t[1]).append("][").append(t[2]).append("][").append(t[3]).append("][").append(t[4]).append("]");
						lines.add(sb1.toString());
						sb.delete(0, sb.length());
						Modchu_Debug.mDebug("saveOthersPlayerParamater file save. s=" + s);
					}
				}
			} catch (Exception er) {
				Modchu_Debug.Debug("saveOthersPlayerParamater file error.");
				er.printStackTrace();
			}
			try {
			// 保存
				if (!lines.isEmpty()
						&& (file.exists() || file.createNewFile())
						&& file.canWrite()) {
					BufferedWriter bwriter = new BufferedWriter(
							new FileWriter(file));
					String t;
					for (int i = 0 ; i < lines.size() ; i++) {
						t = (String) lines.get(i);
						bwriter.write(t);
						bwriter.newLine();
					}
					bwriter.close();
				}
			} catch (Exception er) {
				Modchu_Debug.Debug("saveOthersPlayerParamater file save fail.");
				er.printStackTrace();
			}
		}
	}

	public static void loadConfigPlayerLocalData(HashMap map, File file) {
		// GuiOthersPlayer設定項目PlayerLocalData読み込み
		int modeOthersSettingOffline = getModeOthersSettingOffline();
		try {
			BufferedReader breader = new BufferedReader(new FileReader(
					file));
			String rl;
			for (int i = 0; (rl = breader.readLine()) != null && i < file.length(); i++) {
				int i1;
				if (rl.startsWith("#")
						| rl.startsWith("/")) continue;
				String s = "OthersPlayer[]";
				if (rl.startsWith(s)) {
					rl = rl.substring(s.length());
					if (rl.startsWith("[")
							| rl.startsWith(".")) {
						String k1 = null;
						String t[] = new String[6];
						if (rl.startsWith("[")) {
							for(int j = 0; rl.indexOf("[") != -1 ; j++) {
								rl = rl.substring(1);
								i1 = rl.indexOf("]");
								if (j == 0) k1 = rl.substring(0, i1);
								else t[j - 1] = rl.substring(0, i1);
								rl = rl.substring(i1 + 1);
							}
						} else {
							i1 = rl.indexOf('.');
							if (i1 > -1) {
								rl = rl.substring(i1 + 1);
								if (rl.indexOf(".") > -1) {
									//Player Name
									k1 = rl.substring(0, rl.indexOf("."));
									rl = rl.substring(rl.indexOf(".") + 1);
									if (rl.indexOf(".") > -1) {
										//TextureName
										t[0] = rl.substring(0, rl.indexOf("."));
										rl = rl.substring(rl.indexOf(".") + 1);
										if (rl.indexOf(".") > -1) {
											//ArmorName
											t[1] = rl.substring(0, rl.indexOf("."));
											rl = rl.substring(rl.indexOf(".") + 1);
											if (rl.indexOf(".") > -1) {
												//MaidColor
												t[2] = rl.substring(0, rl.indexOf("."));
												if (rl.indexOf("[") > -1
														&& rl.indexOf("]") > -1) {
													//ModelScale
													t[3] = rl.substring(rl.indexOf("[") + 1 , rl.indexOf("]"));
													//changeMode
													t[4] = ""+modeOthersSettingOffline;
													rl = rl.substring(0, rl.indexOf("."));
													i1 = rl.indexOf('.');
													if (i1 > -1) {
														t[4] = rl.substring(rl.indexOf(".") + 1, rl.length());
													}
												}
											}
										}
									}
								}
							}
							t[5] = "0";
						}
						if (k1 != null) {
							map.put(k1, t);
							//Modchu_Debug.mDebug("cfgOthersPlayer load "+k1+" t[0]="+t[0]+" t[1]="+t[1]+" t[2]="+t[2]+" t[3]="+t[3]+" t[4]="+t[4]+" t[5]="+t[5]);
						}
					}
				}
			}
			breader.close();
			Modchu_Debug.mDebug("Modchu_Config loadConfigOthersPlayer");
		} catch (Exception e) {
			Modchu_Debug.Debug("Modchu_Config loadConfigShowModel load fail.");
			e.printStackTrace();
		}
		//Modchu_Debug.mDebug("Modchu_Config loadConfigOthersPlayer");
	}

	public static void removeOthersPlayerParamater(File file, String name) {
		// GuiOthersPlayer設定から指定内容削除
		if (file.exists() && file.canRead() && file.canWrite()) {
			List lines = new LinkedList();
			try {
				BufferedReader breader = new BufferedReader(new FileReader(
						file));
				String rl;
				String s;
				String s1;
				StringBuilder sb = new StringBuilder();
				while ((rl = breader.readLine()) != null) {
					String m = (String) rl;
					//Modchu_Debug.mDebug("removeOthersPlayerParamater 0 rl=" + rl);
					s = "OthersPlayer[]";
					if (rl.indexOf(s) != -1) {
						rl = rl.substring(rl.indexOf('.') + 1);
						s = name;
						if (rl.startsWith(s)) {
							sb.delete(0, sb.length());
							Modchu_Debug.mDebug("cfgOthersPlayer file remove. " + s);
							continue;
						}
					}
					lines.add(m);
					continue;
				}
			} catch (Exception er) {
				Modchu_Debug.Debug("removeOthersPlayerParamater error.");
				er.printStackTrace();
			}
			try {
			// 保存
				if (!lines.isEmpty()
						&& (file.exists() || file.createNewFile())
						&& file.canWrite()) {
					BufferedWriter bwriter = new BufferedWriter(
							new FileWriter(file));
					String t;
					for (int i = 0 ; i < lines.size() ; i++) {
						t = (String) lines.get(i);
						bwriter.write(t);
						bwriter.newLine();
					}
					bwriter.close();
				}
			} catch (Exception er) {
				Modchu_Debug.Debug("removeOthersPlayerParamater file save fail.");
				er.printStackTrace();
			}
		}
	}

	private static String getTextureName() {
		return (String) Modchu_Reflect.getFieldObject(mod_PFLM_PlayerFormLittleMaid, "textureName");
	}

	private static int getMaidColor() {
		return (Integer) Modchu_Reflect.getFieldObject(mod_PFLM_PlayerFormLittleMaid, "maidColor");
	}

	private static boolean getPartsSaveFlag() {
		return (Boolean) Modchu_Reflect.getFieldObject(PFLM_Gui, "partsSaveFlag");
	}

	private static HashMap<String, Boolean> getParts() {
		return (HashMap<String, Boolean>) Modchu_Reflect.getFieldObject(PFLM_Gui, "parts");
	}

	private static HashMap<Integer, String> getShowPartsNemeList() {
		return (HashMap<Integer, String>) Modchu_Reflect.getFieldObject(PFLM_Gui, "showPartsNemeList");
	}

	private static int getModeOthersSettingOffline() {
		return (Integer) Modchu_Reflect.getFieldObject(PFLM_GuiOthersPlayer, "modeOthersSettingOffline");
	}

}
