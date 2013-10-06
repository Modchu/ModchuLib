package net.minecraft.src;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

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
			Modchu_Debug.lDebug("Modchu_Config "+ file.toString() +" new file create.");
		} catch (Exception e) {
			Modchu_Debug.lDebug("Modchu_Config", "writerConfig file="+ file.toString() +" file writer fail.", 2, e);
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
			BufferedReader breader = null;
			try {
				breader = new BufferedReader(new FileReader(file));
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
				//Modchu_Debug.mDebug("Modchu_Config loadConfig o = "+o.toString());
			} catch (Exception e) {
				Modchu_Debug.lDebug("Modchu_Config", "loadConfig "+ file.toString() +" load fail.", 2, e);
				e.printStackTrace();
			 } finally {
				 try {
					 if (breader != null) breader.close();
				 } catch (Exception e) {
				 }
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
			BufferedReader breader = null;
			try {
				breader = new BufferedReader(new FileReader(file));
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
				//Modchu_Debug.mDebug("Modchu_Config loadConfig1 o = "+o.toString());
			} catch (Exception e) {
				Modchu_Debug.lDebug("Modchu_Config", "loadConfig "+ file.toString() +" load fail.", 2, e);
				e.printStackTrace();
			 } finally {
				 try {
					 if (breader != null) breader.close();
				 } catch (Exception e) {
				 }
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
			BufferedReader breader = null;
			try {
				breader = new BufferedReader(new FileReader(file));
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
				Modchu_Debug.lDebug("Modchu_Config", "saveParamater", 2, er);
				er.printStackTrace();
			} finally {
				try {
					if (breader != null) breader.close();
				} catch (Exception e) {
				}
			}
			BufferedWriter bwriter = null;
			try {
			// 保存
				if (!lines.isEmpty()
						&& (file.exists() || file.createNewFile())
						&& file.canWrite()) {
					bwriter = new BufferedWriter(new FileWriter(file));
					String t;
					for (int i = 0 ; i < lines.size() ; i++) {
						t = (String) lines.get(i);
						bwriter.write(t);
						bwriter.newLine();
					}
				}
			} catch (Exception er) {
				Modchu_Debug.lDebug("Modchu_Config", "saveParamater file="+ file.toString(), 2, er);
				er.printStackTrace();
			 } finally {
				 try {
					 if (bwriter != null) bwriter.close();
				 } catch (Exception e) {
				 }
			 }
		}
	}

	private static long getCRCValue(File file) {
		CRC32 crc = new CRC32();

		BufferedInputStream input = null;
		try {
			input = new BufferedInputStream(new FileInputStream(file));
			int b;
			while ((b = input.read()) != -1) {
				crc.update(b);
			}
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (input != null) input.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return crc.getValue();
	}

	public static ZipFile getZipFile(Class c) {
		ZipFile zipFile = null;
		try
		{
			String s = c.getSimpleName()+".class";
			Modchu_Debug.lDebug("s="+s);
			URL url = c.getResource(s);
			Modchu_Debug.lDebug("url.toString()="+url.toString());
			File file = new File (url.toString());
			s = file.toString();
			Modchu_Debug.lDebug("s="+s);
			int i = s.lastIndexOf("zip");
			if (i > 1) {
				s = s.substring(0, i + 3);
				i = s.indexOf("jar:file:");
				s = s.substring(i + 10);
				Modchu_Debug.lDebug("s="+s+" i="+i);
			}
			return new ZipFile(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void copyZipResource(Class c, ZipFile zipFile, String s, File copydir) {
		File file = null;
		boolean flag = false;
		if (zipFile != null) {
			ZipEntry ze = zipFile.getEntry(s);
			if (ze != null) ;else {
				for (Enumeration<? extends ZipEntry> e = zipFile.entries(); e.hasMoreElements();) {
					ze = e.nextElement();
					Modchu_Debug.lDebug(ze.getName());
					if (ze.getName().equals(s)) break;
				}
			}
			Modchu_Debug.lDebug("Modchu_Config ze="+ze);
			if (ze != null) {
				file = new File(s);
				Modchu_Debug.lDebug("Modchu_Config file="+file);
				if (file != null) flag = true;
			} else {
				throw new RuntimeException("Modchu_Config name="+s+" not found !");
			}
		}
		Modchu_Debug.lDebug("flag="+flag);
		ZipFile zipFile2 = null;
		if (flag) {
			try {
				zipFile2 = new ZipFile(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				URL url = c.getResource(s);
				Modchu_Debug.lDebug("url.toString()="+url.toString());
				file = new File (url.toString().replaceFirst("file:/", ""));
				zipFile = new ZipFile(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Modchu_Debug.lDebug("Modchu_Config zipFile2="+zipFile2);
		if (mod_Modchu_ModchuLib.modchu_Main.isRelease()) {
			File file1 = new File(copydir, s);
			int crcFlag = 0;
			if (file1.exists()) {
				Long crc = getCRCValue(file);
				Long crc1 = getCRCValue(file1);
				crcFlag = crc != crc1 ? 2 : 1;
			}
			if (crcFlag == 2) throw new RuntimeException("Modchu_Config name="+s+". CRC32 of files that exist are different.");
			if (crcFlag == 0) Modchu_Config.copyZipResource(zipFile, copydir, s);
			file = new File(copydir, s);
		} else {
			file = new File (copydir, s);
			Modchu_Debug.lDebug("Modchu_Config outFile="+file);
			Modchu_Config.copyResource(c, s, file);
		}
		Modchu_Debug.lDebug("Modchu_Config copy zip file="+file);
		try {
			zipFile2 = new ZipFile(file);
			Modchu_Debug.lDebug("Modchu_Config last zipFile2.getName()="+zipFile2.getName());
			Modchu_Config.copyZipResourceAll(zipFile2, copydir);
			zipFile2.close();
			zipFile.close();
			if (file.exists()
					&& file.canRead()) {
				boolean b = false;
				int count = 0;
				while(!b
						&& count < 10) {
					count++;
					try{
						b = file.delete();
					} catch(Exception e) {
						continue;
					}
				}
				if (b) {
					Modchu_Debug.lDebug("Modchu_Config file.delete="+file);
				} else {
					Modchu_Debug.lDebug("Modchu_Config Failed to Delete file="+file+" count="+count);
				}
			} else {
				if (!file.exists()) Modchu_Debug.lDebug("Modchu_Config !file.exists() file.delete="+file);
				if (!file.canRead()) Modchu_Debug.lDebug("Modchu_Config !file.canRead() file.delete="+file);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void copyZipResource(ZipFile zipFile, File baseDir, String s) {
		Modchu_Debug.lDebug("copyZipResource");
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		ZipEntry ze = null;
		File outFile = null;
		while (entries.hasMoreElements()) {
			ze = entries.nextElement();
			//Modchu_Debug.lDebug("copyZipResource ze="+ze);
			if (ze.getName().equals(s)) {
				outFile = new File(baseDir, ze.getName());
				copyResource(zipFile, ze, outFile);
				Modchu_Debug.lDebug("copyZipResource break ze="+ze);
				break;
			}
		}
		//Modchu_Debug.lDebug("copyZipResource end.");
	}

	public static void copyZipResourceAll(ZipFile zipFile, File baseDir) {
		Modchu_Debug.lDebug("copyZipResourceAll");
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		ZipEntry ze = null;
		File outFile = null;
		while (entries.hasMoreElements()) {
			ze = entries.nextElement();
			Modchu_Debug.lDebug("copyZipResourceAll ze="+ze);
			outFile = new File(baseDir, ze.getName());
			copyResource(zipFile, ze, outFile);
		}
		//Modchu_Debug.lDebug("copyZipResourceAll end.");
	}

	public static void copyResource(ZipFile zipFile, ZipEntry ze, File outFile) {
		 if (ze.isDirectory()) {
			 outFile.mkdirs();
		 } else {
			 BufferedInputStream bis = null;
			 BufferedOutputStream bos = null;
			 InputStream is = null;
			 try {
				 is = zipFile.getInputStream(ze);
				 bis = new BufferedInputStream(is);

				 if (!outFile.getParentFile().exists()) {
					 outFile.getParentFile().mkdirs();
				 }
				 bos = new BufferedOutputStream(new FileOutputStream(outFile));
				 int i;
				 while ((i = bis.available()) > 0) {
					 byte[] bs = new byte[i];
					 bis.read(bs);
					 bos.write(bs);
				 }
			 } catch (Exception e) {
				 e.printStackTrace();
			 } finally {
				 try {
					 if (bis != null) bis.close();
					 if (bos != null) bos.close();
					 if (is != null) is.close();
				 } catch (Exception e) {
				 }
			 }
		 }
	}

	public static void copyResource(Class c, String s, File file) {
		BufferedInputStream reader = null;
		BufferedOutputStream writer = null;
		try {
			reader = new BufferedInputStream(c.getResourceAsStream(s));
			writer = new BufferedOutputStream(new FileOutputStream(file));
			int size = 0;
			while((size = reader.read()) != -1) {
				writer.write(size);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.flush();
					writer.close();
				}
				if (reader != null) reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
