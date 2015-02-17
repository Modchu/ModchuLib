package modchu.lib;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Modifier;
import java.net.JarURLConnection;
import java.net.URI;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.jar.JarFile;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import modchu.lib.characteristic.Modchu_AS;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ResourceInfo;

public class Modchu_FileManager {

	public static File minecraftJar;
	public static Map<String, List<File>> fileList = new TreeMap<String, List<File>>();
	public static File minecraftDir;
	public static File assetsDir;
	protected static ArrayList<String> failureShowModelList = new ArrayList<String>();
	public static final int TYPE_FILE_OR_DIR = 1;
	public static final int TYPE_FILE = 2;
	public static final int TYPE_DIR = 3;
	public static HashMap<Object, List<String>> listData = new HashMap();

	public static void init() {
		// 初期化
		minecraftDir = Modchu_AS.getFile(Modchu_AS.minecraftMcDataDir);

		// mincraft.jarを取得
		// 開発中用のJar内に含まれていることの対策
		Class c = Modchu_Main.isForge ? Modchu_Reflect.loadClass(Modchu_Main.getMinecraftVersion() > 179 ? "net.minecraftforge.fml.common.FMLModContainer" : "cpw.mods.fml.common.FMLModContainer") : Modchu_Reflect.loadClass("net.minecraft.src.BaseMod");
		int i = 0;
		try {
			ProtectionDomain ls1 = c.getProtectionDomain();
			CodeSource ls2 = ls1.getCodeSource();
			URL ls3 = ls2.getLocation();
			URI ls4 = ls3.toURI();
			minecraftJar = new File(ls4);
//			minecraftJar = new File(BaseMod.class.getProtectionDomain().getCodeSource().getLocation().toURI());
//			Modchu_Debug.tDebug(String.format("getMincraftFile-file:%s", minecraftJar.getName()));
			i = 1;
		} catch (Exception exception) {
			Modchu_Debug.tDebug("getMinecraftFile-Exception.");
		}
		if (minecraftJar == null) {
			try {
				ClassLoader lcl1 = c.getClassLoader();
				String lcls1 = c.getName().concat(".class");
				URL lclu1 = lcl1.getResource(lcls1);
				JarURLConnection lclc1 = (JarURLConnection)lclu1.openConnection();
				JarFile lclj1 = lclc1.getJarFile();
				minecraftJar = new File(lclj1.getName());
				i = 2;
			} catch (Exception exception) {
				Modchu_Debug.tDebug("getMinecraftFile-Exception.");
			}
		}
		if (minecraftJar == null) {
			String ls = System.getProperty("java.class.path");
			int li = ls.indexOf(';');
			if (li > -1) {
				ls = ls.substring(0, li);
			}
			li = ls.indexOf(':');
			if (li > -1) {
				ls = ls.substring(0, li);
			}
			minecraftJar = new File(ls);
			i = 3;
		}
		Modchu_Debug.systemLogDebug("Modchu_FileManager minecraftJar="+minecraftJar.getAbsolutePath()+" i="+i);
		if (!Modchu_Main.isServer) {
			assetsDir = new File(minecraftDir, "assets");
			Modchu_Debug.systemLogDebug("Modchu_FileManager assetsDir="+assetsDir.getAbsolutePath());
		} else {
			// サーバー側では使われないはず。
		}

	}

	public static List<File> getModFile(String pname, String pprefix) {
		// 検索済みかどうかの判定
		List<File> llist;
		if (fileList.containsKey(pname)) {
			llist = fileList.get(pname);
		} else {
			llist = new ArrayList<File>();
			fileList.put(pname, llist);
		}

		Modchu_Debug.tDebug("getModFile:[%s]:%s", pname, Modchu_Main.modsDir.getAbsolutePath());
		// ファイル・ディレクトリを検索
		try {
			if (Modchu_Main.modsDir.isDirectory()) {
				Modchu_Debug.tDebug("getModFile-get:%d.", Modchu_Main.modsDir.list().length);
				for (File t : Modchu_Main.modsDir.listFiles()) {
					if (t.getName().indexOf(pprefix) != -1) {
						if (t.getName().endsWith(".zip")) {
							llist.add(t);
							Modchu_Debug.tDebug("getModFile-file:%s", t.getName());
						} else if (t.isDirectory()) {
							llist.add(t);
							Modchu_Debug.tDebug("getModFile-file:%s", t.getName());
						}
					}
				}
				Modchu_Debug.tDebug("getModFile-files:%d", llist.size());
			} else {
				// まずありえない
				Modchu_Debug.tDebug("getModFile-fail.");
			}
			return llist;
		}
		catch (Exception exception) {
			Modchu_Debug.tDebug("getModFile-Exception.");
			return null;
		}
	}

	public static List<File> getFileList(String pname) {
		return fileList.get(pname);
	}

	public static List<File> getModFile(File dir, List<File> list, ConcurrentHashMap<String, Class> map, String search) {
		if (list != null); else list = new ArrayList();
		try {
			if (dir.isDirectory()) {
				Modchu_Debug.Debug("getModFile-get:"+dir.list().length);
				for (File t : dir.listFiles()) {
					String name = t.getName();
					if (t.isDirectory()) {
						list = getModFile(t, list, map, search);
						Modchu_Debug.Debug("getModFile-isDirectory:"+name);
					} else if (name.endsWith(".zip")
							| name.endsWith(".jar")) {
						list.add(t);
						if (addTexturesZip(t, map, search)) {
							Modchu_Debug.Debug("getModFile-file:"+name);
						} else {
							Modchu_Debug.Debug("getModFile-fail.");
						}
					}
				}
				Modchu_Debug.Debug("getModFile-files:%d", list.size());
			} else {
				Modchu_Debug.Debug("getModFile-fail.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static boolean addTexturesZip(File file, ConcurrentHashMap<String, Class> map, String search) {
		if (file != null
				&& file.isFile()); else return false;
		FileInputStream fileinputstream = null;
		ZipInputStream zipinputstream = null;
		try {
			fileinputstream = new FileInputStream(file);
			zipinputstream = new ZipInputStream(fileinputstream);
			ZipEntry zipentry;
			do {
				zipentry = zipinputstream.getNextEntry();
				if(zipentry == null) break;

				if (!zipentry.isDirectory()) {
					if (zipentry.getName().endsWith(".class")) map = addModClass(map, zipentry.getName(), search);
				}
			} while(true);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (zipinputstream != null) zipinputstream.close();
				if (fileinputstream != null) fileinputstream.close();
			} catch (Exception e) {
			}
		}
	}

	public static void addTexturesJar(File file, ConcurrentHashMap<String, Class> map, String search) {
		if (file != null); else {
			Modchu_Debug.Debug("addTextureJar file == null !!");
			return;
		}
		if (file.isFile()) {
			Modchu_Debug.Debug("addTextureJar-zip.");
			if (addTexturesZip(file, map, search)) {
				Modchu_Debug.Debug("getTexture-append-jar-done.");
			} else {
				Modchu_Debug.Debug("getTexture-append-jar-fail.");
			}
		}
		if (file.isDirectory()) {
			Modchu_Debug.Debug("addTextureJar-file.");
			boolean lflag = false;
			for (File t : file.listFiles()) {
				if (t.isDirectory()) {
					lflag |= addTexturesDir(t, map, search);
				}
			}
			if (lflag) {
				Modchu_Debug.Debug("getTexture-append-jar-done.");
			} else {
				Modchu_Debug.Debug("getTexture-append-jar-fail.");
			}
			if (addTexturesDir(file, map, search)) {
				Modchu_Debug.Debug("getTexture-append-jar-done.");
			} else {
				Modchu_Debug.Debug("getTexture-append-jar-fail.");
			}
		}
	}

	public static boolean addTexturesDir(File file, ConcurrentHashMap<String, Class> map, String search) {
		if (file != null); else return false;
		try {
			for (File t : file.listFiles()) {
				if (t.isDirectory()) {
					addTexturesDir(t, map, search);
				} else if (t.getName().endsWith(".class")) map = addModClass(map, t.getAbsolutePath(), search);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean addResourcesMod(Class c, ConcurrentHashMap<String, Class> map, String search) {
		if (c != null); else return false;
		try {
			for (ResourceInfo i : ClassPath.from(c.getClassLoader()).getResources()) {
				String resourceName = i.getResourceName();
				File file = new File(resourceName);
				if (file != null) {
					if (file.isDirectory()) {
						addTexturesDir(file, map, search);
					} else if (file.getName().endsWith(".class")) map = addModClass(map, file.getAbsolutePath(), search);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static ConcurrentHashMap addModClass(ConcurrentHashMap map, String fname, String search) {
		int i1 = fname.indexOf(search);
		if (i1 > -1
				&& fname.endsWith(".class")) {
			String cn = classNameProcessing(fname);
			if (map.containsKey(cn)) return map;
			Class c = Modchu_Reflect.loadClass(cn);
			if (c != null) {
				if (Modifier.isAbstract(c.getModifiers())) {
					Modchu_Debug.Debug("addModClass-skip."+cn);
					return map;
				}
				if (!map.containsKey(cn)) {
					map.put(cn, c);
					Modchu_Debug.Debug("addModClass-:"+cn);
				}
			} else {
				Modchu_Debug.Debug("addModClass-class == null !!: %s", cn);
			}
		}
		return map;
	}

	public static String classNameProcessing(String fname) {
		String mcDataDirAbsolutePath = Modchu_AS.getFile(Modchu_AS.minecraftMcDataDir).getAbsolutePath();
		int i1 = mcDataDirAbsolutePath.lastIndexOf("\\.");
		if (i1 > -1) mcDataDirAbsolutePath = mcDataDirAbsolutePath.substring(0, i1 + 1);
		String minecraftJarPath = minecraftJar.getAbsolutePath();
		//Modchu_Debug.Debug("classNameProcessing-mcDataDirAbsolutePath="+mcDataDirAbsolutePath);
		//Modchu_Debug.Debug("classNameProcessing-minecraftJarPath="+minecraftJarPath);
		String cn = fname.replace(".class", "");
		//Modchu_Debug.Debug("classNameProcessing 1 cn="+cn);
		if (cn.indexOf(mcDataDirAbsolutePath) > -1) cn = cn.substring(mcDataDirAbsolutePath.length());
		if (cn.indexOf(minecraftJarPath) > -1) cn = cn.substring(minecraftJarPath.length());
		//Modchu_Debug.Debug("classNameProcessing 2 cn="+cn);
		cn = cn.replace("\\", ".").replace("/", ".");
		if (cn.startsWith(".minecraft.")) cn = cn.substring(11);
		if (cn.startsWith(".")) cn = cn.substring(1);
		//Modchu_Debug.Debug("classNameProcessing end. cn="+cn);
		return cn;
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
		FileOutputStream fos = null;
		InputStream is = null;
		if (zipFile != null) {
			Modchu_Debug.lDebug("Modchu_FileManager s="+s);
			ZipEntry ze = zipFile.getEntry(s);
			Modchu_Debug.lDebug("Modchu_FileManager 1 ze="+ze);
			if (ze != null); else {
				for (Enumeration<? extends ZipEntry> e = zipFile.entries(); e.hasMoreElements();) {
					ze = e.nextElement();
					//Modchu_Debug.lDebug("Modchu_FileManager ze.getName()="+ze.getName());
					if (ze.getName().equals(s)) break;
				}
			}
			if (ze != null 
					&& !ze.getName().equals(s)) {
				Modchu_Debug.lDebug("Modchu_FileManager !ze.getName().equals(s) ze="+ze);
				return;
			}
			Modchu_Debug.lDebug("Modchu_FileManager 2 ze="+ze);
			if (ze != null) {
				file = new File(copydir, ze.getName());
				//Modchu_Debug.lDebug("Modchu_FileManager file="+file);
				flag = true;
				try {
					fos = new FileOutputStream(file);
					is = zipFile.getInputStream(ze);
					byte[] buf = new byte[1024];
					int size = 0;
					while ((size = is.read(buf)) != -1) {
						fos.write(buf, 0, size);
					}
					fos.flush();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (fos != null) {
						try {
							fos.close();
						} catch (IOException e1) {
						}
					}
					if (is != null) {
						try {
							is.close();
						} catch (IOException e1) {
						}
					}
				}
			} else {
				Modchu_Debug.lDebug("Modchu_FileManager name="+s+" not found !");
				return;
			}
		}
		Modchu_Debug.lDebug("flag="+flag);
		ZipFile zipFile2 = null;
		if (flag) {
			try {
				Modchu_Debug.lDebug("Modchu_FileManager flag s="+s);
				Modchu_Debug.lDebug("Modchu_FileManager flag file="+file);
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
		Modchu_Debug.lDebug("Modchu_FileManager zipFile2="+zipFile2);
		File file1 = new File(copydir, s);
		int crcFlag = 0;
		if (file1.exists()) {
			Long crc = getCRCValue(file);
			Long crc1 = getCRCValue(file1);
			crcFlag = !crc.equals(crc1) ? 2 : 1;
			if (crcFlag == 2) throw new RuntimeException("Modchu_FileManager name="+s+". CRC32 of files that exist are different. crc="+crc+" crc1="+crc1);
		} else {
			//Modchu_FileManager.copyZipResource(zipFile, copydir, s);
		}
		file1 = null;
		file = new File(copydir, s);
		Modchu_Debug.lDebug("Modchu_FileManager copy zip file="+file);
		try {
			zipFile2 = new ZipFile(file);
			Modchu_Debug.lDebug("Modchu_FileManager last zipFile2.getName()="+zipFile2.getName());
			Modchu_FileManager.copyZipResourceAll(zipFile2, copydir);
			zipFile2.close();
			zipFile2 = null;
			zipFile.close();
			zipFile = null;
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
					Modchu_Debug.lDebug("Modchu_FileManager file.delete="+file);
				} else {
					Modchu_Debug.lDebug("Modchu_FileManager Failed to Delete file="+file+" count="+count);
				}
			} else {
				if (!file.exists()) Modchu_Debug.lDebug("Modchu_FileManager !file.exists() file.delete="+file);
				if (!file.canRead()) Modchu_Debug.lDebug("Modchu_FileManager !file.canRead() file.delete="+file);
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
		InputStream is = null;
		try {
			is = zipFile.getInputStream(ze);
			copyResource(is, ze, outFile);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) is.close();
			} catch (Exception e) {
			}
		}
	}

	public static void copyResource(InputStream is, ZipEntry ze, File outFile) {
		if (ze.isDirectory()) {
			outFile.mkdirs();
		} else {
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			try {
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
				} catch (Exception e) {
				}
				try {
					if (bos != null) bos.close();
				} catch (Exception e) {
				}
				try {
					if (is != null) is.close();
				} catch (Exception e) {
				}
			}
		}
	}

	public static void copyResource(InputStream is, HashMap<ZipEntry, File> map) {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			for (Entry<ZipEntry, File> en : map.entrySet()) {
				ZipEntry ze = en.getKey();
				File outFile = en.getValue();
				if (ze.isDirectory()) {
					outFile.mkdirs();
				} else {
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
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bis != null) bis.close();
			} catch (Exception e) {
			}
			try {
				if (bos != null) bos.close();
			} catch (Exception e) {
			}
			try {
				if (is != null) is.close();
			} catch (Exception e) {
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

	public static void copyResourceText(InputStream is, File outFile) {
		ArrayList<String> list = new ArrayList();
		try {
			writerFile(outFile, inputStreamToList(is, null));
		} catch (Exception e) {
			Modchu_Debug.systemLogDebug("Modchu_FileManager copyResourceText load fail.", 2, e);
		}
	}

	public static File getFile(String directoryPath, String matchingFileName, String indexofFileName) {
		ArrayList<File> list = listFiles(directoryPath, null, matchingFileName, indexofFileName);
		if (list != null
				&& !list.isEmpty()) {
			for (File file : list) {
				//Modchu_Debug.mDebug("Modchu_FileManager getFile file="+file);
				if (file != null) {
					//Modchu_Debug.mDebug("Modchu_FileManager getFile return file="+file);
					return file;
				}
			}
		}
		//Modchu_Debug.mDebug("Modchu_FileManager getFile return return null");
		return null;
	}

	public static ArrayList<File> listFiles(String directoryPath, String fileName) {
		return listFiles(directoryPath, fileName, null, null);
	}

	public static ArrayList<File> listFiles(String directoryPath, String fileName, String matchingFileName, String indexofFileName) {
		if (fileName != null) {
			fileName = fileName.replace(".", "\\.");
			fileName = fileName.replace("*", ".*");
		}
		ArrayList<File> list = new ArrayList<File>();
		return listFiles(directoryPath, fileName, matchingFileName, indexofFileName, list, TYPE_FILE, true, 0);
	}

	public static ArrayList<File> listFiles(String directoryPath, String fileName, String matchingFileName, String indexofFileName, ArrayList list, int type, boolean isRecursive, int period) {
		File dir = new File(directoryPath);
		if (!dir.isDirectory()) {
			String s = "Modchu_FileManager listFiles Exception [" + dir.getAbsolutePath() + "] is not a directory.";
			Modchu_Main.setRuntimeException(s);
			throw new IllegalArgumentException (s);
		}
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			list = addFile(type, fileName, matchingFileName, indexofFileName, list, file, period);
			if (isRecursive && file.isDirectory()) {
				list = listFiles(file.getAbsolutePath(), fileName, matchingFileName, indexofFileName, list, type, isRecursive, period);
			}
		}
		return list;
	}

	private static ArrayList addFile(int type, String fileName, String matchingFileName, String indexofFileName, ArrayList list, File file,int period) {
		switch (type) {
		case TYPE_FILE:
			if (!file.isFile()) return list;
			break;
		case TYPE_DIR:
			if (!file.isDirectory()) return list;
			break;
		}
		//Modchu_Debug.mDebug("Modchu_FileManager addFile file.getName()="+file.getName());
		if (period != 0) {
			Date lastModifiedDate = new Date(file.lastModified());
			String lastModifiedDateStr = new SimpleDateFormat("yyyyMMdd").format(lastModifiedDate);
			long oneDayTime = 24L * 60L * 60L * 1000L;
			long periodTime = oneDayTime * Math.abs(period);
			Date designatedDate = new Date(System.currentTimeMillis() - periodTime);
			String designatedDateStr = new SimpleDateFormat("yyyyMMdd").format(designatedDate);
			if (period > 0) {
				if (lastModifiedDateStr.compareTo(designatedDateStr) < 0) return list;
			} else {
				if (lastModifiedDateStr.compareTo(designatedDateStr) > 0) return list;
			}
		}
		if (fileName != null
				&& file.getName().matches(fileName)
				&& ((indexofFileName == null
				&& matchingFileName == null)
				| (indexofFileName != null
				&& file.getName().indexOf(indexofFileName) > -1)
				| (matchingFileName != null
				&& file.getName().equals(matchingFileName)))) {
			list.add(file);
			//Modchu_Debug.mDebug("Modchu_FileManager addFile list.add file.getName()="+file.getName());
		}
		return list;
	}

	public static void createDir(String s) {
		String s1 = "";
		String as[] = s.split("/");
		for (int i = 0; i < as.length - 1; i++) {
			s1 = (new StringBuilder()).append(s1).append(as[i]).toString();
			boolean flag = (new File((new StringBuilder()).append(Modchu_AS.getFile(Modchu_AS.minecraftMcDataDir)).append(s1).toString())).mkdir();
			s1 = (new StringBuilder()).append(s1).append("/").toString();
		}
	}

	public static BufferedReader getResourceBufferedReader(String s) {
		return getResourceBufferedReader(Modchu_FileManager.class, s);
	}

	public static BufferedReader getResourceBufferedReader(Class c, String s) {
		if (Modchu_Main.isRelease()) {
			try {
				return getJarReader(s);
/*
				ClassLoader classLoader = c.getClassLoader();
				if (classLoader != null); else {
					Modchu_Debug.lDebug1("Modchu_FileManager getResourceBufferedReader classLoader == null !! c="+c);
					return null;
				}
				ClassPath classPath = ClassPath.from(classLoader);
				if (classPath != null); else {
					Modchu_Debug.lDebug1("Modchu_FileManager getResourceBufferedReader classPath == null !! c="+c);
					return null;
				}
				ImmutableSet<ResourceInfo> resources = classPath.getResources();
				if (resources != null); else {
					Modchu_Debug.lDebug1("Modchu_FileManager getResourceBufferedReader resources == null !! c="+c);
					return null;
				}
				for (ResourceInfo resourceInfo : resources) {
					String resourceName = resourceInfo.getResourceName();
					//if (resourceName.indexOf("modchulib") > -1) Modchu_Debug.lDebug1("resourceName="+resourceName);
					if (resourceName.lastIndexOf(s) < 0) continue;
					Modchu_Debug.lDebug1("Modchu_FileManager getResourceBufferedReader ok. s="+s);
					return getJarReader(s);
				}
*/
			} catch (Exception e) {
				Modchu_Debug.lDebug("Modchu_FileManager getResourceBufferedReader Exception !!", 2, e);
			}
		} else {
			//Modchu_Debug.lDebug1("Modchu_FileManager getResourceFile s="+s);
			if (!s.startsWith("/")) s = "/"+s;
			//Modchu_Debug.lDebug1("Modchu_FileManager getResourceFile 1 s="+s);
			URL url = c.getResource(s);
			//Modchu_Debug.lDebug1("Modchu_FileManager getResourceFile 2 url="+url);
			File file = null;
			if (url != null) {
				file = new File(url.getFile());
				//Modchu_Debug.lDebug1("Modchu_FileManager getResourceFile return file="+file);
				try {
					return new BufferedReader(new FileReader(file));
				} catch (Exception e) {
					Modchu_Debug.lDebug("Modchu_FileManager getResourceBufferedReader Exception !!", 2, e);
				}
			}
		}
		Modchu_Debug.lDebug1("Modchu_FileManager getResourceBufferedReader null !! s="+s);
		return null;
	}

	public static BufferedReader getJarReader(String s) {
		BufferedReader bufferedReader = null;
		InputStream inputStream = Modchu_FileManager.class.getClassLoader().getResourceAsStream(s);
		if (inputStream != null) {
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		} else {
			Modchu_Debug.lDebug1("getJarReader inputStream == null !! s="+s);
			File file = new File(s);
			if (file.exists()) Modchu_Debug.lDebug1("getJarReader ok. file="+file);
			else Modchu_Debug.lDebug1("getJarReader !file.exists() !! file="+file);
		}
		return bufferedReader;
	}

	public static ArrayList<String> loadFileToArrayList(File file) {
		// File読み込みArrayListで返す
		if (listData.containsKey(file)) return (ArrayList<String>) listData.get(file);
		return (ArrayList<String>) loadFileToList(file, new ArrayList());
	}

	public static LinkedList<String> loadFileToLinkedList(File file) {
		// File読み込みLinkedListで返す
		if (listData.containsKey(file)) return (LinkedList<String>) listData.get(file);
		return (LinkedList<String>) loadFileToList(file, new LinkedList());
	}

	public static List<String> loadFileToList(File file, List list) {
		// File読み込みListで返す
		if (listData.containsKey(file)) return listData.get(file);
		try {
			list = bufferedReaderToList(new BufferedReader(new FileReader(file)), list);
			listData.put(file, list);
			return list;
		} catch (Exception e) {
			Modchu_Debug.systemLogDebug("Modchu_FileManager loadFileToList "+ file.toString() +" load fail.", 2, e);
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<String> bufferedReaderToArrayList(BufferedReader breader) {
		// BufferedReader読み込みArrayListで返す
		return (ArrayList<String>) bufferedReaderToList(breader, new ArrayList());
	}

	public static LinkedList<String> bufferedReaderToLinkedList(BufferedReader breader) {
		// BufferedReader読み込みLinkedListで返す
		return (LinkedList<String>) bufferedReaderToList(breader, new LinkedList());
	}

	public static List<String> bufferedReaderToList(BufferedReader breader, List list) {
		// BufferedReader読み込みListで返す
		try {
			String rl;
			while ((rl = breader.readLine()) != null) {
				//Modchu_Debug.lDebug("bufferedReaderToList list.add rl="+rl);
				list.add(rl);
			}
		} catch (Exception e) {
			Modchu_Debug.systemLogDebug("Modchu_FileManager bufferedReaderToList " + breader + " load fail.", 2, e);
			e.printStackTrace();
		} finally {
			try {
				if (breader != null) breader.close();
			} catch (Exception e) {
			}
		}
		Modchu_Debug.lDebug("bufferedReaderToList list.add list.size()="+list.size());
		return list;
	}

	public static ArrayList<String> inputStreamToArrayList(InputStream is) {
		// InputStream読み込みArrayListで返す
		return (ArrayList<String>) inputStreamToList(is, new ArrayList());
	}

	public static LinkedList<String> inputStreamToLinkedList(InputStream is) {
		// InputStream読み込みLinkedListで返す
		return (LinkedList<String>) inputStreamToList(is, new LinkedList());
	}

	public static List<String> inputStreamToList(InputStream is, List list) {
		if (list != null); else list = new LinkedList();
		BufferedReader breader = null;
		try {
			breader = new BufferedReader(new InputStreamReader(is));
			String rl;
			while ((rl = breader.readLine()) != null) {
				list.add(rl);
			}
			return list;
		} catch (Exception e) {
			Modchu_Debug.systemLogDebug("Modchu_FileManager inputStreamToList " + breader + " load fail.", 2, e);
			//e.printStackTrace();
		} finally {
			try {
				if (breader != null) breader.close();
			} catch (Exception e) {
			}
		}
		return null;
	}

	public static void writerFile(File file, String[] s) {
		//ファイル書き込み
		try {
			BufferedWriter bwriter = new BufferedWriter(new FileWriter(file));
			List list = new ArrayList();
			for (String s0 : s) {
				if (s0 != null); else continue;
				list.add(s0);
				bwriter.write(s0);
				bwriter.newLine();
			}
			listData.put(file, list);
			bwriter.close();
			Modchu_Debug.lDebug("Modchu_FileManager String[] "+ file.toString() +" new file create.");
		} catch (Exception e) {
			Modchu_Debug.systemLogDebug("Modchu_FileManager writerFile String[] file="+ file.toString() +" file writer fail.", 2, e);
			e.printStackTrace();
		}
	}

	public static void writerFile(File file, List<String> list1) {
		//ファイル書き込み
		if (file != null
				&& list1 != null
				&& !list1.isEmpty()); else {
			//if (file == null) Modchu_Debug.Debug("Modchu_FileManager List writerFile error ! file == null !!");
			if (list1.isEmpty()) Modchu_Debug.lDebug("Modchu_FileManager List "+ file.toString() +" writerFile error ! list1.isEmpty()");
			return;
		}
		BufferedWriter bwriter = null;
		try {
			if (!list1.isEmpty()
					&& (file.exists()
							| file.createNewFile())
					&& file.canWrite()) {
				bwriter = new BufferedWriter(new FileWriter(file));
				List list = new ArrayList();
				for (String s1 : list1) {
					if (s1 != null); else continue;
					list.add(s1);
					bwriter.write(s1);
					bwriter.newLine();
				}
				listData.put(file, list);
				//Modchu_Debug.mDebug("Modchu_FileManager List "+ file.toString() +" writerFile.");
			} else {
				if (file.exists()
						| file.createNewFile()); else Modchu_Debug.lDebug("Modchu_FileManager List "+ file.toString() +" writerFile error ! !(file.exists() | file.createNewFile())");
				if (!file.canWrite()) Modchu_Debug.lDebug("Modchu_FileManager List "+ file.toString() +" writerFile error ! !file.canWrite()");
			}
		} catch (ConcurrentModificationException e) {
		} catch (Exception e) {
			Modchu_Debug.systemLogDebug("Modchu_FileManager writerFile List file="+ file.toString() +" file writer fail.", 2, e);
			e.printStackTrace();
		 } finally {
			 try {
				 if (bwriter != null) bwriter.close();
			 } catch (Exception e) {
			 }
		 }
	}

	public static void writerFile(File file, Map map) {
		//ファイル書き込み
		BufferedWriter bwriter = null;
		try {
			if (!map.isEmpty()
					&& (file.exists()
							| file.createNewFile())
					&& file.canWrite()) {
				bwriter = new BufferedWriter(new FileWriter(file));
				List list = new ArrayList();
				for (Entry<Object, Object> en : ((Map<Object, Object>) map).entrySet()) {
					Object key = en.getKey();
					Object value = en.getValue();
					String s1 = key.toString() + "=" + value.toString();
					list.add(s1);
					bwriter.write(s1);
					bwriter.newLine();
				}
				listData.put(file, list);
				Modchu_Debug.lDebug("Modchu_FileManager Map "+ file.toString() +" writerFile.");
			} else {
				Modchu_Debug.lDebug("Modchu_FileManager Map "+ file.toString() +" writerFile. error map="+map+" file="+file);
			}
		} catch (Exception e) {
			Modchu_Debug.systemLogDebug("Modchu_FileManager writerFile Map file="+ file.toString() +" file writer fail.", 2, e);
			e.printStackTrace();
		 } finally {
			 try {
				 if (bwriter != null) bwriter.close();
			 } catch (Exception e) {
			 }
		 }
	}
}