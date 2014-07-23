package modchu.lib;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import modchu.lib.characteristic.Modchu_AS;

import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ResourceInfo;

public class Modchu_FileManager {
	protected static ArrayList<String> failureShowModelList = new ArrayList<String>();
	public static final int TYPE_FILE_OR_DIR = 1;
	public static final int TYPE_FILE = 2;
	public static final int TYPE_DIR = 3;

	public static List<File> getModFile(File dir, List<File> list, ConcurrentHashMap<String, Class> map, String search) {
		if (list != null) ;else list = new ArrayList();
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
				&& file.isFile()) ;else return false;
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
		if (file != null) ;else {
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
		if (file != null) ;else return false;
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
		if (c != null) ;else return false;
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
		String minecraftJarPath = Modchu_FileManagerBase.minecraftJar.getAbsolutePath();
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
			if (ze != null) ;else {
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

	public static File getFile(String directoryPath, String matchingFileName, String indexofFileName) {
		ArrayList<File> list = listFiles(directoryPath, null, matchingFileName, indexofFileName);
		return list != null
				&& !list.isEmpty() ? list.get(0) : null;
	}

	public static ArrayList<File> listFiles(String directoryPath, String fileName) {
		return listFiles(directoryPath, fileName, null, null);
	}

	public static ArrayList<File> listFiles(String directoryPath, String fileName, String matchingFileName, String indexofFileName) {
		if (fileName != null) {
			fileName = fileName.replace(".", "\\.");
			fileName = fileName.replace("*", ".*");
		}
		return listFiles(directoryPath, fileName, matchingFileName, indexofFileName, TYPE_FILE, true, 0);
	}

	public static ArrayList<File> listFiles(String directoryPath, String fileName, String matchingFileName, String indexofFileName, int type, boolean isRecursive, int period) {
		File dir = new File(directoryPath);
		if (!dir.isDirectory()) throw new IllegalArgumentException ("Modchu_FileManager listFiles Exception [" + dir.getAbsolutePath() + "] is not a directory.");
		File[] files = dir.listFiles();
		ArrayList<File> list = new ArrayList<File>();
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			list = addFile(type, fileName, matchingFileName, indexofFileName, list, file, period);
			if (isRecursive && file.isDirectory()) {
				list = listFiles(file.getAbsolutePath(), fileName, matchingFileName, indexofFileName, type, isRecursive, period);
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
		Modchu_Debug.mDebug("Modchu_FileManager addFile file.getName()="+file.getName());
		if (fileName != null && !file.getName().matches(fileName)) return list;
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
		if ((indexofFileName == null
				&& matchingFileName == null)
				| (indexofFileName != null
				&& file.getName().indexOf(indexofFileName) > -1)
				| (matchingFileName != null
				&& file.getName().equals(matchingFileName))) {
			list.add(file);
			Modchu_Debug.mDebug("Modchu_FileManager addFile list.add file.getName()="+file.getName());
		}
		return list;
	}
}