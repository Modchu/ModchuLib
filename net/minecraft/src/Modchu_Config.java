package net.minecraft.src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Modchu_Config
{
	public static Map cfgData = new HashMap();
	protected static ArrayList<String> failureShowModelList = new ArrayList<String>();

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

	public static void loadConfig(List configList, File file) {
		// cfg設定項目読み込み showModel読み込み
		List list = new ArrayList();
		list = (ArrayList) cfgData.get(file);
		int i1;
		if (list == null) {
			list = new ArrayList();
			try {
				BufferedReader breader = new BufferedReader(new FileReader(
						file));
				String rl;
				for (int i = 0; (rl = breader.readLine()) != null ; i++) {
					list.add(rl);
					if (rl.startsWith("#")
							| rl.startsWith("/")) {
						if (!failureShowModelList.contains(rl)) failureShowModelList.add(rl);
						continue;
					}
					if (rl.indexOf("showModel[]") != -1) {
						configList.add(rl);
						//Modchu_Debug.mDebug("Modchu_Config loadConfig "+ file.toString() +" load " + rl);
					}
				}
				cfgData.put(file, list);
				breader.close();
				//Modchu_Debug.mDebug("Modchu_Config loadConfig o = "+o.toString());
			} catch (Exception e) {
				Modchu_Debug.Debug("Modchu_Config loadConfig "+ file.toString() +" load fail.");
				e.printStackTrace();
			}
		} else {
			String s2;
			for (int i = 0; i < list.size() ; i++) {
				s2 = (String) list.get(i);
				if (s2.startsWith("#")
						| s2.startsWith("/")) {
					if (!failureShowModelList.contains(s2)) failureShowModelList.add(s2);
					continue;
				}
				if (s2.indexOf("showModel[]") != -1) {
					configList.add(s2);
					//Modchu_Debug.mDebug("Modchu_Config loadConfig "+ file.toString() +" load " + s2);
				}
			}
		}
	}

	public static Object loadConfig(File file, String s, Object o) {
		// cfg設定項目読み込み
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
				if (s2.startsWith("#")
						| s2.startsWith("/")) continue;
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
				breader.close();
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
}
