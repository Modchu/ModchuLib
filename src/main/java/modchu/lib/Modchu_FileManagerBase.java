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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.JarURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
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

import org.lwjgl.opengl.Display;

public class Modchu_FileManagerBase implements Modchu_IFileManagerMaster {
	public Map<String, List<File>> fileList = new TreeMap<String, List<File>>();
	protected Map<String, Class> classMap = new HashMap();
	protected List<String> failureShowModelList = new ArrayList();
	protected List<Class> modTextureStitchedClassList;
	protected List<ZipFile> modZipFileList;
	protected List<ZipFile> modsZipFileList;
	protected boolean getResourceBufferedReaderJarReaderFlag = false;
	protected List<String> loadModList = new ArrayList();
	protected List<String> searchResourcesList = new ArrayList();
	protected List<File> loadModFileList = new LinkedList();
	private List<Modchu_IResourcePack> modResourcePackList;
	private List<String> oldResourceDirList;
	private HashMap<Object, Modchu_IResourcePack> addResourcePackMap;
	//protected Map<ZipInputStream, Map<String, ZipEntry>> zipZipEntryMapData;
	protected static boolean initFlag;
	public static HashMap<Object, List<String>> listData = new HashMap();
	public static final int TYPE_FILE_OR_DIR = 1;
	public static final int TYPE_FILE = 2;
	public static final int TYPE_DIR = 3;

	public Modchu_FileManagerBase(HashMap<String, Object> map) {
		boolean debug = false;
		if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase init");
		if (initFlag) {
			Modchu_Debug.lDebug("Modchu_FileManagerBase init initFlag return.");
			return;
		}
		initFlag = true;
		// 初期化
		Modchu_FileManager.setMinecraftDir(Modchu_AS.getFile(Modchu_AS.minecraftMcDataDir));
		Modchu_SearchFileManager.init();

		Class c = Modchu_Main.isForge ? Modchu_Reflect.loadClass(Modchu_Main.getMinecraftVersion() > 179 ? "net.minecraftforge.fml.common.FMLModContainer" : "cpw.mods.fml.common.FMLModContainer") : Modchu_Reflect.loadClass("net.minecraft.src.BaseMod");
		int i = 0;
		int version = Modchu_Main.getMinecraftVersion();
		if (version < 164) {
			// mincraft.jarを取得
			// 開発中用のJar内に含まれていることの対策
			try {
				ProtectionDomain ls1 = c.getProtectionDomain();
				//if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase init ls1="+ls1);
				CodeSource ls2 = ls1.getCodeSource();
				//if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase init ls2="+ls2);
				URL ls3 = ls2.getLocation();
				//if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase init ls3="+ls3);
				URI ls4 = ls3.toURI();
				//if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase init ls4="+ls4);
				String s = ls4.toString();
				int i1 = s.lastIndexOf(".class");
				if (i1 > -1) {
					//Class c1 = Modchu_Reflect.loadClass(ls4.toString());
					//if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase init c.getName()="+c.getName());
					String s1 = c.getName();
					if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase init s1="+s1);
					i1 = s.lastIndexOf(s1);
					if (i1 > -1) {
						s = s.substring(0, i1);
					} else {
						while (s1.indexOf(".") > -1) {
							s1 = s1.replace(".", "/");
						}
						i1 = s.lastIndexOf(s1);
						if (i1 > -1) {
							s = s.substring(0, i1);
							if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase init 0 s="+s);
						} else {
							if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase init 1 s="+s);
							while (s.indexOf("/") > -1) {
								s = s.replace("/", "\\");
							}
							if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase init 2 s="+s);
							i1 = s.indexOf(s1);
							if (i1 > -1) {
								s = s.substring(0, i1);
/*
							while (s.indexOf(".") > -1) {
								s = s.replace(".", "\\");
							}
*/
							} else {
								//if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase init 4 else s="+s+" "+s1.replaceAll(".", "/").replaceAll("//", ""));
							}
						}
					}
					s = s.replace("file:/", "");
					s = s.replace("file:\\", "");
					while (s.indexOf("!") > -1) {
						s = s.replace("!", "");
					}
					if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase init 5 s="+s);
					File file = new File(s);
					if (debug) {
						Modchu_Debug.lDebug("Modchu_FileManagerBase init 6 file="+file);
						Modchu_Debug.lDebug("Modchu_FileManagerBase init 6-1 file.exists()="+file.exists());
					}
					String path = file.getPath();
					if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase init 6-2 path="+path);
					Modchu_FileManager.addMinecraftJar(file);
					if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase init 7");
				} else {
					Modchu_FileManager.addMinecraftJar(new File(ls4));
					if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase init 1 ls4="+ls4);
				}
				i = 1;
			} catch (Exception e) {
				e.printStackTrace();
				if (debug) Modchu_Debug.tDebug("Modchu_FileManagerBase init getMinecraftFile-Exception1.");
			}

			if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase init 8 getMinecraftJarList ="+Modchu_FileManager.getMinecraftJarList());
			if (Modchu_FileManager.getMinecraftJarList().isEmpty()) {
				if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase init 9-1 list.isEmpty()");
				try {
					ClassLoader lcl1 = c.getClassLoader();
					if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase init 9-2");
					String lcls1 = c.getName().concat(".class");
					URL lclu1 = lcl1.getResource(lcls1);
					JarURLConnection lclc1 = (JarURLConnection)lclu1.openConnection();
					JarFile lclj1 = lclc1.getJarFile();
					Modchu_FileManager.addMinecraftJar(new File(lclj1.getName()));
					i = 2;
				} catch (Exception exception) {
					if (debug) Modchu_Debug.tDebug("Modchu_FileManagerBase init getMinecraftFile-Exception2.");
				}
				if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase init 9-end");
			}
			if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase init 10");
			if (Modchu_FileManager.getMinecraftJarList().isEmpty()) {
				String ls = System.getProperty("java.class.path");
				int li = ls.indexOf(';');
				if (li > -1) {
					ls = ls.substring(0, li);
				}
				li = ls.indexOf(':');
				if (li > -1) {
					ls = ls.substring(0, li);
				}
				if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase init 11 ls="+ls);
				Modchu_FileManager.addMinecraftJar(new File(ls));
				i = 3;
			}
			if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase init 12 getMinecraftJarList ="+Modchu_FileManager.getMinecraftJarList());
		}
		//File file = Modchu_FileManager.getMinecraftJarList().get(0);
		//if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase init 13 file="+file);
		//if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase init 14 minecraftJar="+file.getAbsolutePath()+" i="+i);
		if (!Modchu_Main.isServer) {
			Modchu_FileManager.setAssetsDir(new File(Modchu_FileManager.getMinecraftDir(), "assets"));
			if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase init assetsDir="+Modchu_FileManager.getAssetsDir().getAbsolutePath());
		}

		if (!Modchu_Main.isRelease()
				&& version < 164) {
			Modchu_FileManager.addMinecraftJar(new File(Modchu_AS.getFile(Modchu_AS.minecraftMcDataDir), "/bin/minecraft.jar"));
			if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase minecraft.jar file.exists()="+Modchu_FileManager.getMinecraftJarList().get(1).exists());
		}
		//if (debug) Modchu_Debug.Debug("Modchu_FileManagerBase init oldGetMinecraftJar="+oldGetMinecraftJar());
		if (debug) Modchu_Debug.Debug("Modchu_FileManagerBase init end.");
	}

	public static File oldGetMinecraftJar() {
		File minecraftDir = Modchu_AS.getFile(Modchu_AS.minecraftMcDataDir);
		File minecraftJar = null;
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
			Modchu_Debug.tDebug("oldGetMinecraftJar getMinecraftFile-Exception.");
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
				Modchu_Debug.tDebug("oldGetMinecraftJar getMinecraftFile-Exception.");
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
		Modchu_Debug.systemLogDebug("Modchu_FileManagerBase oldGetMinecraftJar minecraftJar="+minecraftJar.getAbsolutePath()+" i="+i);
		return minecraftJar;
	}

	@Override
	public void loadModFile(String zipJarclassFileSearchName, String classFileSearchName, String addModResourcePackSearchName, Method method) {
		boolean debug = false;
		boolean titleDebug = zipJarclassFileSearchName.equals("modc_");
		boolean flag = !Modchu_Main.isServer
				&& titleDebug;
		int progress = 0;
		if (debug) Modchu_Debug.Debug("Modchu_FileManagerBase loadModFile zipJarclassFileSearchName="+zipJarclassFileSearchName+" classFileSearchName="+classFileSearchName);
		if (zipJarclassFileSearchName != null
				&& !zipJarclassFileSearchName.isEmpty()); else return;
		if (loadModList.contains(zipJarclassFileSearchName)) return;
		loadModList.add(zipJarclassFileSearchName);
		List<File> list = getDirFileList(Modchu_Main.modsDir);
		List<File> list1 = getDevFileList();
		if (list1 != null
				&& !list1.isEmpty()) {
			list.addAll(list1);
		}
		if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase loadModFile list="+list);
		List list2 = new ArrayList();
		if (list != null
				&& !list.isEmpty())
		for (int i = 0; i < list.size(); i++) {
			File file = list.get(i);
			if (flag) {
				String tempTitleName1 = Modchu_Main.tempTitleName+" Loading ModchuLib check file. "+file.getName();
				Display.setTitle(tempTitleName1);
			}
			loadModFile_r(zipJarclassFileSearchName, classFileSearchName, addModResourcePackSearchName, list2, file);
			progress = (int) ((((float) i + 1.0F) / (list.size())) * 100F);
			if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase loadModFile progress="+progress);
			if (method != null) {
				try {
					method.invoke(null, progress);
				} catch (Exception e) {
				}
			}
		}
		if (flag) Display.setTitle(Modchu_Main.tempTitleName);
		fileList.put(zipJarclassFileSearchName, list2);
		addResourcesMod(Modchu_Main.class, classFileSearchName, addModResourcePackSearchName);
	}

	private List<File> getDevFileList() {
		boolean debug = false;
		List<File> list = null;
		if (Modchu_Main.isDev) {
			list = new LinkedList();
			List<String> list1 = new LinkedList();
			String classpath = System.getProperty("java.class.path");
			if (classpath != null) {
				if (debug) Modchu_Debug.mDebug("Modchu_Main getDevFileList classpath="+classpath);
				String[] s0 = classpath.split(";");
				if (debug) Modchu_Debug.mDebug("Modchu_Main getDevFileList s0="+s0);
				for (String s2 : s0) {
					if (debug) Modchu_Debug.mDebug("Modchu_Main getDevFileList s2="+s2);
					if (!list1.contains(s2)) list1.add(s2);
				}
				for (String s3 : list1) {
					list.add(new File(s3));
				}
			}
		}
		return list;
	}

	protected void loadModFile_r(String zipJarclassFileSearchName, String classFileSearchName, String addModResourcePackSearchName, List list, File file) {
		boolean debug = false;
		String fname = file.getName();
		String tempSearchName = fname.toLowerCase();
		String tempSearchPname = zipJarclassFileSearchName.toLowerCase();
		if (file.isDirectory()) {
			if (tempSearchName.indexOf(tempSearchPname) > -1) list.add(file);
			if (versionDirCheck(file))
			for (File file1 : file.listFiles()) {
				loadModFile_r(zipJarclassFileSearchName, classFileSearchName, addModResourcePackSearchName, list, file1);
			}
			return;
		}
		if (debug) Modchu_Debug.Debug("Modchu_FileManagerBase loadModFile_r fname="+fname);
		if (tempSearchName.indexOf(tempSearchPname) > -1) {
			list.add(file);
			if (tempSearchName.endsWith(".zip")
				| tempSearchName.endsWith(".jar")) {
				if (addTexturesZip(file, file, classFileSearchName, addModResourcePackSearchName)) {
					loadModFileList.add(file);
					if (debug) Modchu_Debug.Debug("Modchu_FileManagerBase loadModFile_r loadModFileList.add fname="+fname);
				} else {
					if (debug) Modchu_Debug.Debug("Modchu_FileManagerBase loadModFile_r loadModFileList not list.add.");
				}
			}
		}
		if (debug) Modchu_Debug.Debug("Modchu_FileManagerBase loadModFile_r end.");
	}

	protected boolean versionDirCheck(File file) {
		if (!file.isDirectory()) return false;
		boolean flag1 = false;
		String versionString = Modchu_Version.getMinecraftVersionString();
		String path = file.getAbsolutePath();
		Modchu_Debug.tDebug("Modchu_FileManagerBase getModFile 2 path="+path);
		if (path.indexOf("\\") > -1) path = Modchu_Main.lastIndexProcessing(file.getAbsolutePath(), "\\");
		if (path.indexOf("/") > -1) path = Modchu_Main.lastIndexProcessing(file.getAbsolutePath(), "/");
		Modchu_Debug.tDebug("Modchu_FileManagerBase getModFile 3 path="+path);
		if (path.equals(versionString)) {
			flag1 = true;
		} else {
			if (path.length() > 2) {
				int i1 = path.indexOf(".");
				if (i1 > -1) {
					String s1 = path.substring(0, 1);
					if (Modchu_Main.integerCheck(s1)) {
						String s2 = path.substring(2, 3);
						if (Modchu_Main.integerCheck(s2)) {
							flag1 = true;
							Modchu_Debug.tDebug("Modchu_FileManagerBase versionDirCheck flag1 = true path="+path);
						}
					}
				}
			}
		}
		return flag1;
	}

/*
	protected boolean getModFile(String pname, String pprefix, File dir, List<File> llist, boolean versionDirCheck) {
		boolean b = false;
		String versionString = versionDirCheck ? Modchu_Version.getMinecraftVersionString() : null;
		//Modchu_Debug.mDebug("Modchu_FileManagerBase getModFile versionString="+versionString);
		try {
			Modchu_Debug.tDebug("Modchu_FileManagerBase getModFile dir="+dir);
			if (dir.isDirectory()) {
				Modchu_Debug.tDebug("Modchu_FileManagerBase getModFile-get:%d.", dir.list().length);
				for (File t : dir.listFiles()) {
					if (t.isDirectory()) {
						boolean flag1 = true;
						if (versionDirCheck) {
							String path = t.getAbsolutePath();
							Modchu_Debug.tDebug("Modchu_FileManagerBase getModFile path="+path);
							if (path.indexOf("\\") > -1) path = Modchu_Main.lastIndexProcessing(t.getAbsolutePath(), "\\");
							if (path.indexOf("/") > -1) path = Modchu_Main.lastIndexProcessing(t.getAbsolutePath(), "/");
							if (!path.equals(versionString)) {
								if (path.length() > 2) {
									int i1 = path.indexOf(".");
									if (i1 > -1) {
										String s1 = path.substring(0, 1);
										if (Modchu_Main.integerCheck(s1)) {
											String s2 = path.substring(2, 3);
											if (Modchu_Main.integerCheck(s2)) {
												flag1 = false;
												Modchu_Debug.tDebug("Modchu_FileManagerBase getModFile flag1 = false path="+path);
											}
										}
									}
								}
							}
						}
						if (flag1) {
							llist.add(t);
							Modchu_Debug.tDebug("Modchu_FileManagerBase getModFile-directory:%s", t.getName());
							getModFile(pname, pprefix, t, llist, false);
						}
					}
					String name = t.getName();
					if (name.indexOf(pprefix) != -1) {
						name = name.toLowerCase();
						if (name.endsWith(".zip")
								| name.endsWith(".jar")) {
							llist.add(t);
							b = true;
							Modchu_Debug.tDebug("Modchu_FileManagerBase getModFile zip or jar file:%s", t.getName());
						}
					} else {
						Modchu_Debug.tDebug("Modchu_FileManagerBase getModFile zip prefix else file:%s", t.getName());
					}
				}
				Modchu_Debug.tDebug("Modchu_FileManagerBase getModFile zip files:%d", llist.size());
			} else {
				Modchu_Debug.tDebug("Modchu_FileManagerBase getModFile zip !dir.isDirectory().");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Modchu_Debug.tDebug("Modchu_FileManagerBase getModFile zip Exception.");
		}
		return b;
	}
*/
	@Override
	public List<File> getFileList(String pname) {
		return fileList.containsKey(pname) ? fileList.get(pname) : null;
	}
/*
	@Override
	public List<File> getModFile(List<File> list, ConcurrentHashMap<String, Class> map, String search) {
		boolean debug = false;
		getModFile(Modchu_Main.modsDir, list, map, search, false);
		getModFile(new File(Modchu_Main.modsDir, Modchu_Version.getMinecraftVersionString()), list, map, search, true);
		if (debug) Modchu_Debug.mDebug("Modchu_FileManagerBase getModFile Modchu_Main.isDev="+Modchu_Main.isDev);
		if (Modchu_Main.isDev) {
			String classpath = System.getProperty("java.class.path");
			if (classpath != null) {
				if (debug) Modchu_Debug.mDebug("Modchu_Main checkDev classpath="+classpath);
				String[] s0 = classpath.split(";");
				if (debug) Modchu_Debug.mDebug("Modchu_Main checkDev s0="+s0);
				List<String> list1 = new LinkedList();
				for (String s2 : s0) {
					if (debug) Modchu_Debug.mDebug("Modchu_Main checkDev s2="+s2);
					if (!list1.contains(s2)) list1.add(s2);
				}
				for (String s3 : list1) {
					getModFile(new File(s3), list, map, search, true);
				}
			}
		}
		return list;
	}

	@Override
	public List<File> getModFile(File file, List<File> list, ConcurrentHashMap<String, Class> map, String search, boolean subDirCheck) {
		boolean debug = false;
		if (debug) Modchu_Debug.Debug1("Modchu_FileManagerBase getModFile search="+search);
		if (list != null); else list = new ArrayList();
		try {
			if (file.isDirectory()) {
				//Modchu_Debug.Debug("Modchu_FileManagerBase getModFile-get:"+dir.list().length);
				for (File t : file.listFiles()) {
					String name = t.getName();
					if (t.isDirectory()) {
						if (subDirCheck) {
							if (name.indexOf(search) > -1) {
								if (debug) Modchu_Debug.Debug("Modchu_FileManagerBase getModFile list.add name="+name);
								list.add(t);
							} else {
								if (debug) Modchu_Debug.Debug("Modchu_FileManagerBase getModFile list not add name="+name);
							}
							list = getModFile(t, list, map, search, subDirCheck);
						}
					} else if (name.endsWith(".zip")
							| name.endsWith(".jar")) {
						if (addTexturesZip(t, map, search)) {
							list.add(t);
							if (debug) Modchu_Debug.Debug("Modchu_FileManagerBase getModFile file name="+name);
						} else {
							if (debug) Modchu_Debug.Debug("Modchu_FileManagerBase getModFile addTexturesZip not list.add.");
						}
					}
				}
				if (debug) Modchu_Debug.Debug("Modchu_FileManagerBase getModFile files list.size()="+list.size());
			} else {
				if (debug) Modchu_Debug.Debug("Modchu_FileManagerBase getModFile !dir.isDirectory() file="+file);
				String name = file.getName();
				if (name.endsWith(".zip")
						| name.endsWith(".jar")) {
					if (addTexturesZip(file, map, search)) {
						list.add(file);
						if (debug) Modchu_Debug.Debug("Modchu_FileManagerBase getModFile !dir.isDirectory() name="+name);
					} else {
						if (debug) Modchu_Debug.Debug("Modchu_FileManagerBase getModFile !dir.isDirectory() addTexturesZip not list.add.");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
*/
	@Override
	public boolean addTexturesZip(File file, File file1, String classFileSearchName, String addModResourcePackSearchName) {
		if (file != null
				&& file.isFile()); else return false;
		String tempSearch = addModResourcePackSearchName != null ? addModResourcePackSearchName.toLowerCase() : null;
		boolean b = false;
		boolean classCheck = false;
		boolean check = false;
		FileInputStream fileinputstream = null;
		ZipInputStream zipinputstream = null;
		try {
			fileinputstream = new FileInputStream(file);
			zipinputstream = new ZipInputStream(fileinputstream);
			ZipEntry zipentry;
			do {
				zipentry = zipinputstream.getNextEntry();
				if (zipentry == null) break;
				String name = zipentry.getName();
				String searchName = name.toLowerCase();
				if (!zipentry.isDirectory()) {
					if (searchName.endsWith(".class")) {
						classCheck = true;
						if (addModClass(file, name, classFileSearchName, addModResourcePackSearchName)) b = true;
					}
					if (!check
							&& !b
							&& tempSearch != null
							&& searchName.indexOf(tempSearch) > -1
							&& (searchName.endsWith(".png")
							| searchName.endsWith(".json"))) {
						//Modchu_Debug.lDebug("Modchu_FileManagerBase addTexturesZip check = true searchName="+searchName);
						check = true;
					}
				}
			} while(true);
			int version = Modchu_Main.getMinecraftVersion();
			if (check
					&& version > 179) {
				//String name = file.getName();
				//if (checkDevJar(file))
				addModResourcePack(file);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (zipinputstream != null) zipinputstream.close();
				if (fileinputstream != null) fileinputstream.close();
			} catch (Exception e) {
			}
		}
		return b;
	}

	protected boolean checkDevJar(File file) {
		if (file != null); else return false;
		boolean debug = false;
		String name = file.getName();
		if (debug) Modchu_Debug.mDebug("Modchu_FileManagerBase checkDevJar name="+name);
		if (name.toLowerCase().lastIndexOf(".jar") < 0) return false;
		ZipFile zipFile = null;
		try {
			zipFile = new ZipFile(file);
			HashMap<String, InputStream> map = loadZipFileToInputStreamHashMap(zipFile);
			InputStream inputStream = map.get("META-INF/MANIFEST.MF");
			if (debug) {
				Modchu_Debug.mDebug("Modchu_FileManagerBase checkDevJar MANIFEST.MF map="+map);
				Modchu_Debug.mDebug("Modchu_FileManagerBase checkDevJar MANIFEST.MF inputStream="+inputStream);
			}
			if (inputStream != null); else return false;
			LinkedList<String> list = inputStreamToLinkedList(inputStream);
			if (debug) Modchu_Debug.mDebug("Modchu_FileManagerBase checkDevJar MANIFEST.MF list="+list);
			if (list != null
					&& !list.isEmpty()) {
				for (String s : list) {
					if (s != null
							&& !s.isEmpty()); else continue;
					String[] s0 = s.split(":");
					if (s0 != null
							&& s0.length > 1
							&& s0[0] != null
							&& !s0[0].isEmpty()
							&& s0[1] != null
							&& !s0[1].isEmpty()
							&& s0[0].toLowerCase().startsWith("modchudev")
							&& s0[1].replace(" ", "").replace("	", "").equalsIgnoreCase("true")) {
						return true;
					}
				}
			}
			//return true;
		} catch (Error e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (zipFile != null) zipFile.close();
			} catch (Exception e) {
			}
		}
		return false;
	}

	@Override
	public void addTexturesJar(File file, File file1, String classFileSearchName, String addModResourcePackSearchName) {
		if (file != null); else {
			Modchu_Debug.Debug("Modchu_FileManagerBase addTextureJar file == null !!");
			return;
		}
		if (file.isFile()) {
			Modchu_Debug.Debug("Modchu_FileManagerBase addTextureJar file.isFile()");
			if (addTexturesZip(file, file1, classFileSearchName, addModResourcePackSearchName)) {
				Modchu_Debug.Debug("Modchu_FileManagerBase addTexturesJar addTexturesZip true.");
			} else {
				Modchu_Debug.Debug("Modchu_FileManagerBase addTexturesJar addTexturesZip false.");
			}
		}
		if (file.isDirectory()) {
			Modchu_Debug.Debug("Modchu_FileManagerBase addTextureJar file.isDirectory().");
			if (addTexturesDir(file, classFileSearchName, addModResourcePackSearchName)) {
				Modchu_Debug.Debug("Modchu_FileManagerBase addTextureJar file.isDirectory() true.");
			} else {
				Modchu_Debug.Debug("Modchu_FileManagerBase addTextureJar file.isDirectory() false.");
			}
		}
	}

	@Override
	public boolean addTexturesDir(File file, String classFileSearchName, String addModResourcePackSearchName) {
		if (file != null); else return false;
		boolean debug = false;
		if (debug) Modchu_Debug.mDebug("Modchu_FileManagerBase addTexturesDir file.getName()="+file.getName());
		boolean b = false;
		try {
			for (File t : file.listFiles()) {
				if (debug) Modchu_Debug.mDebug("Modchu_FileManagerBase addTexturesDir r t.getName()="+t.getName());
				if (t.isDirectory()) {
					addTexturesDir(t, classFileSearchName, addModResourcePackSearchName);
				} else if (t.getName().endsWith(".class")) {
					if (addModClass(file, t.getAbsolutePath(), classFileSearchName, addModResourcePackSearchName)) b = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean addResourcesMod(Class c, String classFileSearchName, String addModResourcePackSearchName) {
		if (c != null); else return false;
		boolean debug = false;
		boolean titleDebug = classFileSearchName != null
				&& classFileSearchName.equals("modc_");
		boolean flag = !Modchu_Main.isServer
				&& titleDebug;
		if (searchResourcesList.contains(classFileSearchName)) return false;
		if (flag) {
			String tempTitleName1 = Modchu_Main.tempTitleName+" Loading ModchuLib Resources check file.";
			Display.setTitle(tempTitleName1);
		}
		searchResourcesList.add(classFileSearchName);
		boolean b = false;
		URLClassLoader urlClassLoader = null;
		try {
			ClassLoader classloader = c.getClassLoader();
			if (classloader instanceof URLClassLoader) {
				urlClassLoader = (URLClassLoader) classloader;
				if (debug) Modchu_Debug.mDebug("Modchu_FileManagerBase addResourcesMod urlClassLoader.getURLs().length="+urlClassLoader.getURLs().length);
				for (URL entry : urlClassLoader.getURLs()) {
					String resourceName = entry.getPath();
					if (debug) Modchu_Debug.mDebug("Modchu_FileManagerBase addResourcesMod resourceName="+resourceName);
					if (resourceName.equals("/")
							| resourceName.equals(".")) continue;
					File file = new File(resourceName);
					if (file != null) {
						if (file.isDirectory()) {
							addTexturesDir(file, classFileSearchName, addModResourcePackSearchName);
						} else if (file.getName().endsWith(".class")) {
							if (addModClass(null, file.getAbsolutePath(), classFileSearchName, addModResourcePackSearchName)) b = true;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			int version = Modchu_Main.getMinecraftVersion();
			if (version > 159) {
				try {
					if (urlClassLoader != null) Modchu_Reflect.invokeMethod(URLClassLoader.class, "close", urlClassLoader);
				} catch (Exception e) {
				}
			}
		}
		if (flag) Display.setTitle(Modchu_Main.tempTitleName);
		return b;
	}

	@Override
	public boolean addModClass(File file, String fname, String classFileSearchName, String addModResourcePackSearchName) {
		boolean debug = false;
		if (classFileSearchName != null
				&& !classFileSearchName.isEmpty()); else return false;
		int i1 = fname.indexOf(classFileSearchName);
		if (i1 > -1
				&& fname.endsWith(".class")) {
			String cn = classNameProcessing(fname);
			if (debug) Modchu_Debug.Debug("Modchu_FileManagerBase addModClass cn="+cn);
			boolean b = checkModClassName(cn);
			if (debug) {
				Modchu_Debug.Debug("Modchu_FileManagerBase addModClass classMap.containsKey(cn)="+classMap.containsKey(cn));
				Modchu_Debug.Debug("Modchu_FileManagerBase addModClass b="+b);
			}
			if (classMap.containsKey(cn)
					| !b) return false;
			Class c = Modchu_Reflect.loadClass(cn, -1);
			if (c != null) {
				if (Modifier.isAbstract(c.getModifiers())) {
					if (debug) Modchu_Debug.Debug("Modchu_FileManagerBase addModClass isAbstract skip cn="+cn);
					return false;
				}
				if (!classMap.containsKey(cn)) {
					classMap.put(c.getName(), c);
					if (debug) Modchu_Debug.Debug("Modchu_FileManagerBase addModClass c.getName()="+c.getName());
/*
					if (file != null) {
						addModResourcePack(file);
					} else {
*/
						addModResourcePack(c);
					//}
					return true;
				}
			} else {
				if (debug) Modchu_Debug.Debug("Modchu_FileManagerBase addModClass class == null !! cn="+cn);
			}
		}
		return false;
	}

	private boolean checkModClassName(String cn) {
		boolean debug = false;
		if (Modchu_Main.modEnabledMap != null
				&& Modchu_Main.modEnabledMap.size() > 0); else return true;
		String temp = cn;
		int i1 = temp.indexOf(".");
		if (i1 < 0) {
			i1 = temp.indexOf("\\");
			if (i1 > -1) {
				temp = temp.replace("\\", ".");
			}
		}
		boolean b = false;
		while (true) {
			if (Modchu_Main.modEnabledMap != null
					&& Modchu_Main.modEnabledMap.containsKey(temp)) {
				b = Modchu_Main.modEnabledMap.get(temp);
				if (debug) Modchu_Debug.Debug("Modchu_FileManagerBase checkModClassName temp="+temp+" b="+b);
				break;
			}
			i1 = temp.indexOf(".");
			if (i1 < 0) break;
			temp = temp.substring(i1 + 1);
			if (debug) Modchu_Debug.Debug("Modchu_FileManagerBase checkModClassName temp="+temp);
		}
		return b;
	}

	protected void addModResourcePack(Class c) {
		int version = Modchu_Main.getMinecraftVersion();
		if (Modchu_Main.isServer
				| version > 189) {
			return;
		}
		if (version < 162) {
			addModTextureStitchedClassList(c);
			return;
		}
		boolean debug = false;
		if (debug) Modchu_Debug.mDebug("Modchu_FileManagerBase addModResourcePack 1 c="+c);
		addModchuResourcePack_o(c);
		if (debug) Modchu_Debug.mDebug("Modchu_FileManagerBase addModResourcePack end.");
	}

	public void addModResourcePack(File file) {
		int version = Modchu_Main.getMinecraftVersion();
		if (file == null
				| Modchu_Main.isServer
				| (version < 190
						&& !file.isDirectory())) {
			return;
		}
		boolean debug = false;
		if (debug) Modchu_Debug.mDebug("Modchu_FileManagerBase addModResourcePack 1 file.getAbsolutePath()="+file.getAbsolutePath());
		addModchuResourcePack_o(file);
		if (debug) Modchu_Debug.mDebug("Modchu_FileManagerBase addModResourcePack end.");
	}

	protected void addModchuResourcePack_o(Object o) {
		boolean debug = true;
		int version = Modchu_Main.getMinecraftVersion();
		if (o == null
				| Modchu_Main.isServer) {
			return;
		}
		if (version < 160) {
			String s = null;
			if (o instanceof File) s = ((File) o).getAbsolutePath();
			else if (o instanceof ZipFile) s = ((ZipFile) o).getName();
			else if (o instanceof String) Modchu_CastHelper.String(o);
			if (s != null) {
				if (oldResourceDirList != null); else oldResourceDirList = new LinkedList();
				oldResourceDirList.add(s);
				if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase addModchuResourcePack_o oldResourceDirList.add s="+s);
			}
			return;
		}
		if (addResourcePackMap != null); else addResourcePackMap = new HashMap();
		Object o1 = null;
		if (o instanceof File) {
			o1 = ((File) o).getAbsolutePath();
		}
		else if (o instanceof ZipFile) {
			o1 = ((ZipFile) o).getName();
		} else {
			o1 = o;
		}
		if (addResourcePackMap.containsKey(o1)) return;
		Modchu_IResourcePack modchu_IResourcePack = (Modchu_IResourcePack) Modchu_Main.newModchuCharacteristicObject("Modchu_ResourcePack", Modchu_ModResourcePackMaster.class, o instanceof File ? (File) o : o instanceof ZipFile ? (ZipFile) o : o);
		if (modchu_IResourcePack != null) {
			if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase addModchuResourcePack_o 1 o="+o);
			List list = Modchu_AS.getList("Minecraft", "defaultResourcePacks", Modchu_AS.get(Modchu_AS.minecraftGetMinecraft));
			if (list != null) {
				if (debug) {
					Modchu_Debug.lDebug("Modchu_FileManagerBase addModchuResourcePack_o 2 list="+list);
					Object master = Modchu_Main.getModchuCharacteristicObjectMaster(modchu_IResourcePack);
					Modchu_ModResourcePackMaster ModResourcePackMaster = (Modchu_ModResourcePackMaster) master;
					Modchu_Debug.lDebug("Modchu_FileManagerBase addModchuResourcePack_o 3 ModResourcePackMaster.resourceFile="+ModResourcePackMaster.resourceFile);
				}
				list.add(modchu_IResourcePack);
				Modchu_Main.refreshResourcesFlag = true;
			} else {
				String s = "Modchu_FileManagerBase addModchuResourcePack_o defaultResourcePacks null error !!";
				if (debug) Modchu_Debug.lDebug(s);
				Modchu_Main.setRuntimeException(s);
			}
			addResourcePackMap.put(o1, modchu_IResourcePack);
		} else {
			String s = "Modchu_FileManagerBase addModchuResourcePack_o null error !!";
			if (debug) Modchu_Debug.lDebug(s);
			Modchu_Main.setRuntimeException(s);
		}
	}

	protected void addModTextureStitchedClassList(Class c) {
		if (modTextureStitchedClassList != null); else modTextureStitchedClassList = new ArrayList();
		if (!modTextureStitchedClassList.contains(c)) modTextureStitchedClassList.add(c);
	}

	public InputStream getModInputStream(Object o) {
		InputStream inputStream = null;
		int version = Modchu_Main.getMinecraftVersion();
		if (version < 160
				| !Modchu_Main.isForge) {
			return o instanceof String ? getClass().getResourceAsStream((String) o) : null;
		}
		if (modResourcePackList != null); else {
			modResourcePackList = new LinkedList();
			List<ZipFile> list = getModsZipFileList();
			if (list != null
					&& !list.isEmpty()); else return null;
			for (ZipFile zipfile : list) {
				Modchu_IResourcePack modchu_IResourcePack = (Modchu_IResourcePack) Modchu_Main.newModchuCharacteristicObject("Modchu_ResourcePack", Modchu_ModResourcePackMaster.class, zipfile);
				modResourcePackList.add(modchu_IResourcePack);
			}
		}
		if (modResourcePackList != null
				&& !modResourcePackList.isEmpty()); else return null;
		for (Modchu_IResourcePack modchu_IResourcePack1 : modResourcePackList) {
			if (Modchu_AS.getBoolean(version > 169 ? "IResourcePack" : "ResourcePack", "resourceExists", new Class[]{ Modchu_Reflect.loadClass("ResourceLocation") }, modchu_IResourcePack1, new Object[]{ o })) {
				inputStream = Modchu_AS.getInputStream(version > 169 ? "IResourcePack" : "ResourcePack", "getInputStream", new Class[]{ Modchu_Reflect.loadClass("ResourceLocation") }, modchu_IResourcePack1, new Object[]{ o });
				if (inputStream != null) return inputStream;
			}
		}
		return inputStream;
	}

	@Override
	public List<Class> getModTextureStitchedClassList() {
		return modTextureStitchedClassList;
	}

	@Override
	public String classNameProcessing(String fname) {
		//Modchu_Debug.Debug("Modchu_FileManagerBase classNameProcessing 1 fname="+fname);
		String mcDataDirAbsolutePath = Modchu_AS.getFile(Modchu_AS.minecraftMcDataDir).getAbsolutePath();
		int i1 = mcDataDirAbsolutePath.lastIndexOf("\\.");
		if (i1 == mcDataDirAbsolutePath.length() - 1) mcDataDirAbsolutePath = mcDataDirAbsolutePath.substring(0, i1);
		List<File> list = Modchu_FileManager.getMinecraftJarList();
		fname = fname.replace(".class", "");
		if (list != null
				&& !list.isEmpty()) {
			String minecraftJarPath = list.get(0).getAbsolutePath();
			if (minecraftJarPath.indexOf("file:\\") > -1) minecraftJarPath = minecraftJarPath.substring(6);
			String minecraftJarPath2 = list.get(0).getPath();
			if (minecraftJarPath2.indexOf("file:\\") > -1) minecraftJarPath2 = minecraftJarPath2.substring(6);
			//Modchu_Debug.Debug("Modchu_FileManagerBase classNameProcessing-minecraftJarPath="+minecraftJarPath);
			//Modchu_Debug.Debug("Modchu_FileManagerBase classNameProcessing-minecraftJarPath2="+minecraftJarPath2);
			//Modchu_Debug.Debug("classNameProcessing 2 fname="+fname);
			if (fname.startsWith(minecraftJarPath)) fname = fname.substring(minecraftJarPath.length());
			if (fname.startsWith(minecraftJarPath2)) fname = fname.substring(minecraftJarPath2.length());
		}
		//Modchu_Debug.Debug("Modchu_FileManagerBase classNameProcessing-mcDataDirAbsolutePath="+mcDataDirAbsolutePath);
		if (fname.startsWith(mcDataDirAbsolutePath)) fname = fname.substring(mcDataDirAbsolutePath.length());
		String s0 = "\\bin\\";
		i1 = fname.indexOf(s0);
		if (i1 > -1) fname = fname.substring(i1 + s0.length());
		s0 = ".bin.";
		i1 = fname.indexOf(s0);
		if (i1 > -1) fname = fname.substring(i1 + s0.length());
		//Modchu_Debug.Debug("Modchu_FileManagerBase classNameProcessing 3 fname="+fname);
		if ((Modchu_Main.getMinecraftVersion() > 159
				| !Modchu_Main.isForge)
				&& fname.indexOf(":/") < 0) fname = fname.replace("\\", ".").replace("/", ".");
		if (Modchu_Main.getMinecraftVersion() > 159
				&& (fname.startsWith(".minecraft.")
				| fname.startsWith("/minecraft/"))) fname = fname.substring(11);
		if (fname.startsWith(".")
				| fname.startsWith("/")
				| fname.startsWith("\\")) fname = fname.substring(1);
		//Modchu_Debug.Debug("Modchu_FileManagerBase classNameProcessing 4 end. fname="+fname);
		return fname;
	}

	@Override
	public String textureNameProcessing(String fname) {
		//Modchu_Debug.Debug("Modchu_FileManagerBase classNameProcessing 1 fname="+fname);
		String mcDataDirAbsolutePath = Modchu_AS.getFile(Modchu_AS.minecraftMcDataDir).getAbsolutePath();
		int i1 = mcDataDirAbsolutePath.lastIndexOf("\\.");
		if (i1 == mcDataDirAbsolutePath.length() - 1) mcDataDirAbsolutePath = mcDataDirAbsolutePath.substring(0, i1);
		List<File> list = Modchu_FileManager.getMinecraftJarList();
		fname = fname.replace(".class", "");
		if (list != null
				&& !list.isEmpty()) {
			String minecraftJarPath = list.get(0).getAbsolutePath();
			if (minecraftJarPath.indexOf("file:\\") > -1) minecraftJarPath = minecraftJarPath.substring(6);
			String minecraftJarPath2 = list.get(0).getPath();
			if (minecraftJarPath2.indexOf("file:\\") > -1) minecraftJarPath2 = minecraftJarPath2.substring(6);
			//Modchu_Debug.Debug("Modchu_FileManagerBase classNameProcessing-minecraftJarPath="+minecraftJarPath);
			//Modchu_Debug.Debug("Modchu_FileManagerBase classNameProcessing-minecraftJarPath2="+minecraftJarPath2);
			//Modchu_Debug.Debug("classNameProcessing 2 fname="+fname);
			if (fname.startsWith(minecraftJarPath)) fname = fname.substring(minecraftJarPath.length());
			if (fname.startsWith(minecraftJarPath2)) fname = fname.substring(minecraftJarPath2.length());
		}
		//Modchu_Debug.Debug("Modchu_FileManagerBase classNameProcessing-mcDataDirAbsolutePath="+mcDataDirAbsolutePath);
		if (fname.indexOf(mcDataDirAbsolutePath) > -1) fname = fname.substring(mcDataDirAbsolutePath.length());
		String path = new File(".").getAbsolutePath();
		if (fname.startsWith(path)) fname = fname.substring(path.length());

		return fname;
	}

	protected long getCRCValue(File file) {
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

	@Override
	public ZipFile getZipFile(Class c) {
		ZipFile zipFile = null;
		try
		{
			String s = c.getSimpleName()+".class";
			Modchu_Debug.lDebug("Modchu_FileManagerBase getZipFile s="+s);
			URL url = c.getResource(s);
			Modchu_Debug.lDebug("Modchu_FileManagerBase getZipFile url.toString()="+url.toString());
			File file = new File (url.toString());
			s = file.toString();
			Modchu_Debug.lDebug("Modchu_FileManagerBase getZipFile s="+s);
			int i = s.lastIndexOf("zip");
			if (i > 1) {
				s = s.substring(0, i + 3);
				i = s.indexOf("jar:file:");
				s = s.substring(i + 10);
				Modchu_Debug.lDebug("Modchu_FileManagerBase getZipFile s="+s+" i="+i);
			}
			return new ZipFile(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void copyZipResource(Class c, ZipFile zipFile, String s, File copydir) {
		File file = null;
		boolean flag = false;
		FileOutputStream fos = null;
		InputStream is = null;
		if (zipFile != null) {
			Modchu_Debug.lDebug("Modchu_FileManagerBase copyZipResource  s="+s);
			ZipEntry ze = zipFile.getEntry(s);
			Modchu_Debug.lDebug("Modchu_FileManagerBase copyZipResource 1 ze="+ze);
			if (ze != null); else {
				for (Enumeration<? extends ZipEntry> e = zipFile.entries(); e.hasMoreElements();) {
					ze = e.nextElement();
					//Modchu_Debug.lDebug("Modchu_FileManagerBase copyZipResource ze.getName()="+ze.getName());
					if (ze.getName().equals(s)) break;
				}
			}
			if (ze != null
					&& !ze.getName().equals(s)) {
				Modchu_Debug.lDebug("Modchu_FileManagerBase copyZipResource !ze.getName().equals(s) ze="+ze);
				return;
			}
			Modchu_Debug.lDebug("Modchu_FileManagerBase copyZipResource 2 ze="+ze);
			if (ze != null) {
				file = new File(copydir, ze.getName());
				//Modchu_Debug.lDebug("Modchu_FileManagerBase copyZipResource file="+file);
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
				Modchu_Debug.lDebug("Modchu_FileManagerBase copyZipResource name="+s+" not found !");
				return;
			}
		}
		Modchu_Debug.lDebug("flag="+flag);
		ZipFile zipFile2 = null;
		if (flag) {
			try {
				Modchu_Debug.lDebug("Modchu_FileManagerBase copyZipResource flag s="+s);
				Modchu_Debug.lDebug("Modchu_FileManagerBase copyZipResource flag file="+file);
				zipFile2 = new ZipFile(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				URL url = c.getResource(s);
				Modchu_Debug.lDebug("Modchu_FileManagerBase copyZipResource url.toString()="+url.toString());
				file = new File (url.toString().replaceFirst("file:/", ""));
				zipFile = new ZipFile(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Modchu_Debug.lDebug("Modchu_FileManagerBase copyZipResource zipFile2="+zipFile2);
		File file1 = new File(copydir, s);
		int crcFlag = 0;
		if (file1.exists()) {
			Long crc = getCRCValue(file);
			Long crc1 = getCRCValue(file1);
			crcFlag = !crc.equals(crc1) ? 2 : 1;
			if (crcFlag == 2) throw new RuntimeException("Modchu_FileManagerBase copyZipResource name="+s+". CRC32 of files that exist are different. crc="+crc+" crc1="+crc1);
		} else {
			//Modchu_FileManager.copyZipResource(zipFile, copydir, s);
		}
		file1 = null;
		file = new File(copydir, s);
		Modchu_Debug.lDebug("Modchu_FileManagerBase copyZipResource copy zip file="+file);
		try {
			zipFile2 = new ZipFile(file);
			Modchu_Debug.lDebug("Modchu_FileManagerBase copyZipResource last zipFile2.getName()="+zipFile2.getName());
			copyZipResourceAll(zipFile2, copydir);
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
					Modchu_Debug.lDebug("Modchu_FileManagerBase copyZipResource file.delete="+file);
				} else {
					Modchu_Debug.lDebug("Modchu_FileManagerBase copyZipResource Failed to Delete file="+file+" count="+count);
				}
			} else {
				if (!file.exists()) Modchu_Debug.lDebug("Modchu_FileManagerBase copyZipResource !file.exists() file.delete="+file);
				if (!file.canRead()) Modchu_Debug.lDebug("Modchu_FileManagerBase copyZipResource !file.canRead() file.delete="+file);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void copyZipResource(ZipFile zipFile, File baseDir, String s) {
		Modchu_Debug.lDebug("Modchu_FileManagerBase copyZipResource");
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		ZipEntry ze = null;
		File outFile = null;
		while (entries.hasMoreElements()) {
			ze = entries.nextElement();
			//Modchu_Debug.lDebug("copyZipResource ze="+ze);
			if (ze.getName().equals(s)) {
				outFile = new File(baseDir, ze.getName());
				copyResource(zipFile, ze, outFile);
				Modchu_Debug.lDebug("Modchu_FileManagerBase copyZipResource break ze="+ze);
				break;
			}
		}
		//Modchu_Debug.lDebug("copyZipResource end.");
	}

	@Override
	public void copyZipResourceAll(ZipFile zipFile, File baseDir) {
		Modchu_Debug.lDebug("Modchu_FileManagerBase copyZipResourceAll");
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		ZipEntry ze = null;
		File outFile = null;
		while (entries.hasMoreElements()) {
			ze = entries.nextElement();
			Modchu_Debug.lDebug("Modchu_FileManagerBase copyZipResourceAll ze="+ze);
			outFile = new File(baseDir, ze.getName());
			copyResource(zipFile, ze, outFile);
		}
		//Modchu_Debug.lDebug("Modchu_FileManagerBase copyZipResourceAll end.");
	}

	@Override
	public void copyResource(ZipFile zipFile, ZipEntry ze, File outFile) {
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

	@Override
	public void copyResource(InputStream is, ZipEntry ze, File outFile) {
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

	@Override
	public void copyResource(InputStream is, HashMap<ZipEntry, File> map) {
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

	@Override
	public void copyResource(Class c, String s, File file) {
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

	@Override
	public void copyResourceText(InputStream is, File outFile) {
		ArrayList<String> list = new ArrayList();
		try {
			writerFile(outFile, inputStreamToList(is, null));
		} catch (Exception e) {
			Modchu_Debug.lDebug("Modchu_FileManagerBase copyResourceText load Exception.", 2, e);
		}
	}

	@Override
	public File getFile(String directoryPath, String matchingFileName, String indexofFileName, boolean subDirCheck) {
		ArrayList<File> list = listFiles(directoryPath, null, matchingFileName, indexofFileName, subDirCheck);
		if (list != null
				&& !list.isEmpty()) {
			for (File file : list) {
				//Modchu_Debug.mDebug("Modchu_FileManagerBase getFile file="+file);
				if (file != null) {
					//Modchu_Debug.mDebug("Modchu_FileManagerBase getFile return file="+file);
					return file;
				}
			}
		}
		//Modchu_Debug.mDebug("Modchu_FileManagerBase getFile return return null");
		return null;
	}

	@Override
	public ArrayList<File> listFiles(String directoryPath, String fileName) {
		return listFiles(directoryPath, fileName, null, null, true);
	}

	@Override
	public ArrayList<File> listFiles(String directoryPath, String fileName, String matchingFileName, String indexofFileName, boolean subDirCheck) {
		if (fileName != null) {
			fileName = fileName.replace(".", "\\.");
			fileName = fileName.replace("*", ".*");
		}
		ArrayList<File> list = new ArrayList<File>();
		return listFiles(directoryPath, fileName, matchingFileName, indexofFileName, list, TYPE_FILE, subDirCheck, 0);
	}

	@Override
	public ArrayList<File> listFiles(String directoryPath, String fileName, String matchingFileName, String indexofFileName, ArrayList list, int type, boolean subDirCheck, int period) {
		File dir = new File(directoryPath);
		if (!dir.isDirectory()) {
			String s = "Modchu_FileManagerBase listFiles [" + dir.getAbsolutePath() + "] is not a directory.";
			Modchu_Debug.Debug(s);
			return list;
		}
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			list = addFile(type, fileName, matchingFileName, indexofFileName, list, file, period);
			if (subDirCheck && file.isDirectory()) {
				list = listFiles(file.getAbsolutePath(), fileName, matchingFileName, indexofFileName, list, type, subDirCheck, period);
			}
		}
		return list;
	}

	protected static ArrayList addFile(int type, String fileName, String matchingFileName, String indexofFileName, ArrayList list, File file,int period) {
		switch (type) {
		case TYPE_FILE:
			if (!file.isFile()) return list;
			break;
		case TYPE_DIR:
			if (!file.isDirectory()) return list;
			break;
		}
		//Modchu_Debug.mDebug("Modchu_FileManagerBase addFile file.getName()="+file.getName());
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
			//Modchu_Debug.mDebug("Modchu_FileManagerBase addFile list.add file.getName()="+file.getName());
		}
		return list;
	}

	@Override
	public void createDir(String s) {
		String s1 = "";
		String as[] = s.split("/");
		for (int i = 0; i < as.length - 1; i++) {
			s1 = (new StringBuilder()).append(s1).append(as[i]).toString();
			boolean flag = (new File((new StringBuilder()).append(Modchu_AS.getFile(Modchu_AS.minecraftMcDataDir)).append(s1).toString())).mkdir();
			s1 = (new StringBuilder()).append(s1).append("/").toString();
		}
	}

	@Override
	public BufferedReader getResourceBufferedReader(String s) {
		return getResourceBufferedReader(Modchu_FileManagerBase.class, s);
	}

	@Override
	public BufferedReader getResourceBufferedReader(Class c, String s) {
		if (Modchu_Main.isRelease()
				| getResourceBufferedReaderJarReaderFlag
				| Modchu_Main.isDev) {
			try {
				return getJarReader(s);
/*
				ClassLoader classLoader = c.getClassLoader();
				if (classLoader != null); else {
					Modchu_Debug.lDebug1("Modchu_FileManagerBase getResourceBufferedReader classLoader == null !! c="+c);
					return null;
				}
				ClassPath classPath = ClassPath.from(classLoader);
				if (classPath != null); else {
					Modchu_Debug.lDebug1("Modchu_FileManagerBase getResourceBufferedReader classPath == null !! c="+c);
					return null;
				}
				ImmutableSet<ResourceInfo> resources = classPath.getResources();
				if (resources != null); else {
					Modchu_Debug.lDebug1("Modchu_FileManagerBase getResourceBufferedReader resources == null !! c="+c);
					return null;
				}
				for (ResourceInfo resourceInfo : resources) {
					String resourceName = resourceInfo.getResourceName();
					//if (resourceName.indexOf("modchulib") > -1) Modchu_Debug.lDebug1("resourceName="+resourceName);
					if (resourceName.lastIndexOf(s) < 0) continue;
					Modchu_Debug.lDebug1("Modchu_FileManagerBase getResourceBufferedReader ok. s="+s);
					return getJarReader(s);
				}
*/
			} catch (Exception e) {
				Modchu_Debug.lDebug("Modchu_FileManagerBase getResourceBufferedReader Exception !!", 2, e);
			}
		} else {
			//Modchu_Debug.lDebug1("Modchu_FileManagerBase getResourceBufferedReader s="+s);
			URL url = c.getResource(s);
			if (url != null); else {
				if (!s.startsWith("/")) s = "/"+s;
				url = c.getResource(s);
			}
			File file = null;
			//Modchu_Debug.lDebug1("Modchu_FileManagerBase getResourceBufferedReader url="+url);
			if (url != null) {
				file = new File(url.getFile());
				//Modchu_Debug.lDebug1("Modchu_FileManagerBase getResourceBufferedReader return file="+file);
				if (!file.exists()) {
					if (!s.startsWith("/")) s = "/"+s;
					url = c.getResource(s);
					file = new File(url.getFile());
				}
				if (!file.exists()) {
					//Modchu_Debug.lDebug1("Modchu_FileManagerBase getResourceBufferedReader return !file.exists() !! file="+file+" s="+s);
					try {
						BufferedReader bufferedReader = getJarReader(s);
						if (bufferedReader != null) {
							getResourceBufferedReaderJarReaderFlag = true;
							return bufferedReader;
						}
					} catch (Exception e) {
						Modchu_Debug.lDebug("Modchu_FileManagerBase getResourceBufferedReader 2 Exception !!", 2, e);
						return null;
					}
				}
				try {
					return new BufferedReader(new FileReader(file));
				} catch (Exception e) {
					Modchu_Debug.lDebug("Modchu_FileManagerBase getResourceBufferedReader Exception !!", 2, e);
				}
			} else {
				Modchu_Debug.lDebug1("Modchu_FileManagerBase getResourceBufferedReader return url null !! s="+s);
			}
		}
		Modchu_Debug.lDebug1("Modchu_FileManagerBase getResourceBufferedReader null !! s="+s);
		return null;
	}

	@Override
	public BufferedReader getJarReader(String s) {
		BufferedReader bufferedReader = null;
		InputStream inputStream = Modchu_FileManagerBase.class.getClassLoader().getResourceAsStream(s);
		//Modchu_Debug.lDebug("getJarReader s="+s+" inputStream="+inputStream);
		if (inputStream != null) {
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			//Modchu_Debug.lDebug("getJarReader 1 bufferedReader="+bufferedReader);
		} else {
			if (s.startsWith("/")
					| s.startsWith("\\")) {
				s = s.substring(1);
				inputStream = Modchu_FileManagerBase.class.getClassLoader().getResourceAsStream(s);
			}
			if (inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				//Modchu_Debug.lDebug("getJarReader 2 bufferedReader="+bufferedReader);
			} else {
				Modchu_Debug.lDebug("getJarReader inputStream == null !! s="+s);
				File file = new File(s);
				if (file.exists()) Modchu_Debug.lDebug("getJarReader ok. file="+file);
				else Modchu_Debug.lDebug("getJarReader !file.exists() !! file="+file);
			}
		}
		return bufferedReader;
	}

	@Override
	public ArrayList<String> loadFileToArrayList(File file) {
		// File読み込みArrayListで返す
		if (listData.containsKey(file.getAbsolutePath())) return (ArrayList<String>) listData.get(file.getAbsolutePath());
		return (ArrayList<String>) loadFileToList(file, new ArrayList());
	}

	@Override
	public LinkedList<String> loadFileToLinkedList(File file) {
		// File読み込みLinkedListで返す
		if (listData.containsKey(file.getAbsolutePath())) return (LinkedList<String>) listData.get(file.getAbsolutePath());
		return (LinkedList<String>) loadFileToList(file, new LinkedList());
	}

	@Override
	public List<String> loadFileToList(File file, List list) {
		// File読み込みListで返す
		if (listData.containsKey(file.getAbsolutePath())) return listData.get(file.getAbsolutePath());
		try {
			list = bufferedReaderToList(new BufferedReader(new FileReader(file)), list);
			listData.put(file.getAbsolutePath(), list);
			return list;
		} catch (Exception e) {
			Modchu_Debug.lDebug("Modchu_FileManagerBase loadFileToList "+ file.toString() +" load Exception.", 2, e);
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<String> bufferedReaderToArrayList(BufferedReader breader) {
		// BufferedReader読み込みArrayListで返す
		return (ArrayList<String>) bufferedReaderToList(breader, new ArrayList());
	}

	@Override
	public LinkedList<String> bufferedReaderToLinkedList(BufferedReader breader) {
		// BufferedReader読み込みLinkedListで返す
		return (LinkedList<String>) bufferedReaderToList(breader, new LinkedList());
	}

	@Override
	public List<String> bufferedReaderToList(BufferedReader breader, List list) {
		// BufferedReader読み込みListで返す
		if (list != null); else list = new LinkedList();
		try {
			String rl;
			while ((rl = breader.readLine()) != null) {
				//Modchu_Debug.lDebug("Modchu_FileManagerBase bufferedReaderToList list.add rl="+rl);
				list.add(rl);
			}
		} catch (Exception e) {
			Modchu_Debug.lDebug("Modchu_FileManagerBase bufferedReaderToList " + breader + " load Exception.", 2, e);
			e.printStackTrace();
		} finally {
			try {
				if (breader != null) breader.close();
			} catch (Exception e) {
			}
		}
		Modchu_Debug.lDebug("Modchu_FileManagerBase bufferedReaderToList list.add list.size()="+list.size());
		return list;
	}

	@Override
	public ArrayList<String> inputStreamToArrayList(InputStream is) {
		// InputStream読み込みArrayListで返す
		return (ArrayList<String>) inputStreamToList(is, new ArrayList());
	}

	@Override
	public LinkedList<String> inputStreamToLinkedList(InputStream is) {
		// InputStream読み込みLinkedListで返す
		return (LinkedList<String>) inputStreamToList(is, new LinkedList());
	}

	@Override
	public List<String> inputStreamToList(InputStream is, List list) {
		return bufferedReaderToList(new BufferedReader(new InputStreamReader(is)), list);
	}

	@Override
	public HashMap<String, ZipEntry> loadZipFileToZipEntryHashMap(File file) {
		// file読み込みHashMapで返す
		return (HashMap<String, ZipEntry>) loadZipFileToZipEntryMap(file, new HashMap());
	}

	@Override
	public Map<String, ZipEntry> loadZipFileToZipEntryMap(File file, Map<String, ZipEntry> map) {
		// File読み込みMapで返す
		//if (zipZipEntryMapData.containsKey(file.getAbsolutePath())) return zipZipEntryMapData.get(file.getAbsolutePath());
		FileInputStream fileinputstream = null;
		ZipInputStream zipInputStream = null;
		try {
			fileinputstream = new FileInputStream(file);
			zipInputStream = new ZipInputStream(fileinputstream);
			ZipEntry zipentry;
			do {
				zipentry = zipInputStream.getNextEntry();
				if (zipentry == null) break;
				map.put(zipentry.getName(), zipentry);
			} while(true);
		} catch (Error e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (zipInputStream != null) zipInputStream.close();
				if (fileinputstream != null) fileinputstream.close();
			} catch (Exception e) {
			}
		}
		return map;
	}

	@Override
	public HashMap<String, InputStream> loadZipFileToInputStreamHashMap(ZipFile zipFile) {
		// ZipFile読み込みHashMap<String, InputStream>で返す
		return (HashMap<String, InputStream>) loadZipFileToInputStreamMap(zipFile, new HashMap());
	}

	@Override
	public Map<String, InputStream> loadZipFileToInputStreamMap(ZipFile zipFile, Map<String, InputStream> map) {
		// ZipFile読み込みMap<String, InputStream>で返す
		//if (zipZipEntryInputStreamData.containsKey(file.getAbsolutePath())) return zipZipInputStreamMapData.get(file.getAbsolutePath());
		try {
			for (Enumeration<? extends ZipEntry> e = zipFile.entries(); e.hasMoreElements();) {
				ZipEntry entry = e.nextElement();
				if (entry.isDirectory()) continue;
				InputStream inputStream = zipFile.getInputStream(entry);
				map.put(entry.getName(), inputStream);
			}
		} catch (Error e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public void writerFile(File file, String[] s) {
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
			listData.put(file.getAbsolutePath(), list);
			bwriter.close();
			Modchu_Debug.lDebug("Modchu_FileManagerBase String[] "+ file.toString() +" new file create.");
		} catch (Exception e) {
			Modchu_Debug.lDebug("Modchu_FileManagerBase writerFile String[] file="+ file.toString() +" file writer Exception.", 2, e);
			e.printStackTrace();
		}
	}

	@Override
	public void writerFile(File file, List<String> list1) {
		//ファイル書き込み
		if (file != null
				&& list1 != null
				&& !list1.isEmpty()); else {
			//if (file == null) Modchu_Debug.Debug("Modchu_FileManagerBase List writerFile error ! file == null !!");
			if (list1.isEmpty()) Modchu_Debug.Debug("Modchu_FileManagerBase writerFile List "+ file.toString() +" writerFile error ! list1.isEmpty()");
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
				listData.put(file.getAbsolutePath(), list);
				//Modchu_Debug.mDebug("Modchu_FileManagerBase writerFile List "+ file.toString() +" writerFile.");
			} else {
				if (file.exists()
						| file.createNewFile()); else Modchu_Debug.lDebug("Modchu_FileManagerBase writerFile List "+ file.toString() +" writerFile error ! !(file.exists() | file.createNewFile())");
				if (!file.canWrite()) Modchu_Debug.Debug("Modchu_FileManagerBase writerFile List "+ file.toString() +" writerFile error ! !file.canWrite()");
			}
		} catch (ConcurrentModificationException e) {
		} catch (Exception e) {
			Modchu_Debug.lDebug("Modchu_FileManagerBase writerFile List file="+ file.toString() +" file writer Exception.", 2, e);
		 } finally {
			 try {
				 if (bwriter != null) bwriter.close();
			 } catch (Exception e) {
			 }
		 }
	}

	@Override
	public void writerFile(File file, Map map) {
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
				listData.put(file.getAbsolutePath(), list);
				Modchu_Debug.lDebug("Modchu_FileManagerBase Map "+ file.toString() +" writerFile.");
			} else {
				Modchu_Debug.lDebug("Modchu_FileManagerBase Map "+ file.toString() +" writerFile. error map="+map+" file="+file);
			}
		} catch (Exception e) {
			Modchu_Debug.lDebug("Modchu_FileManagerBase writerFile Map file="+ file.toString() +" file writer Exception.", 2, e);
			e.printStackTrace();
		 } finally {
			 try {
				 if (bwriter != null) bwriter.close();
			 } catch (Exception e) {
			 }
		 }
	}

	@Override
	public LinkedList<File> getClassLoaderResourcesFileList(Class c) {
		if (c != null); else return null;
		HashMap<String, File> map = new HashMap();
		URLClassLoader urlClassLoader = null;
		try {
			ClassLoader classloader = c.getClassLoader();
			if (classloader instanceof URLClassLoader) {
				urlClassLoader = (URLClassLoader) classloader;
				for (URL entry : urlClassLoader.getURLs()) {
					String path = entry.getPath();
					File file = new File(entry.getFile());
					String s1 = file.getPath();
					//Modchu_Debug.mDebug("Modchu_FileManagerBase getClassLoaderResourcesFileList s1="+s1);
					if (!map.containsKey(s1)) {
						map.put(s1, file);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		LinkedList<File> list = new LinkedList();
		for (Entry<String, File> en : map.entrySet()) {
			File file = en.getValue();
			list.add(file);
		}
		return list;
	}

	@Override
	public LinkedList getClassLoaderResourcesList(Class c) {
		LinkedList list = new LinkedList();
		if (c != null); else return null;
		URLClassLoader urlClassLoader = null;
		try {
			ClassLoader classloader = c.getClassLoader();
			if (classloader instanceof URLClassLoader) {
				urlClassLoader = (URLClassLoader) classloader;
				for (URL entry : urlClassLoader.getURLs()) {
					String path = entry.getPath();
					File file = new File(path);
					if (file != null
							&& file.isDirectory()) {
						addFileListFiles(file, list);
					} else {
						list.add(path);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

	public void addFileListFiles(File file, LinkedList list) {
		if (list != null
				&& file != null
				&& file.isDirectory()); else return;
		for (File file1 : file.listFiles()) {
			if (file1 != null
					&& file1.isDirectory()) {
				addFileListFiles(file1, list);
			} else {
				URI uri = file1.toURI();
				String s = uri.getRawPath();
				if (!list.contains(s)) list.add(s);
			}
		}
	}

	@Override
	public String[] getSystemClassPaths() {
		return System.getProperty("java.class.path").split(File.pathSeparator);
	}

	@Override
	public List<File> getClassPathFileList(String s) {
		List<File> list = new LinkedList();
		String[] paths = Modchu_FileManager.getSystemClassPaths();
		for (String s1 : paths) {
			//Modchu_Debug.lDebug("Modchu_FileManagerBase getClassPathFileList s1="+s1);
			if (s1.indexOf(s) > -1
					&& s1.lastIndexOf(".jar") > -1) {
				list.add(new File(s1));
				//Modchu_Debug.lDebug("Modchu_FileManagerBase getClassPathFileList add s1="+s1);
			}
		}
		return list;
	}

	@Override
	public List<ZipFile> getModZipFileList(File dirFile) {
		boolean debug = false;
		if (modZipFileList != null) return modZipFileList;
		modZipFileList = new LinkedList();
		String s = ".zip";
		String s1 = ".jar";
		List<File> list = getDirFileList(dirFile);
		if (list != null
				&& !list.isEmpty())
		for (File file : list) {
			String path = file.getPath();
			if (path.lastIndexOf(s) < 0
					&& path.lastIndexOf(s1) < 0) continue;
			if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase getModZipFileList path="+path);
			try {
				modZipFileList.add(new ZipFile(path));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return modZipFileList;
	}

	@Override
	public void setModZipFileList(List<ZipFile> list) {
		modZipFileList = list;
	}

	@Override
	public List<ZipFile> getModsZipFileList() {
		boolean debug = false;
		if (modsZipFileList != null) return modsZipFileList;
		List<ZipFile> list1 = new ArrayList();
		String s = ".zip";
		String s1 = ".jar";
		File modsDir = Modchu_Main.modsDir;
		for (File file : modsDir.listFiles()) {
			String path = file.getPath();
			if (path.lastIndexOf(s) < 0
					&& path.lastIndexOf(s1) < 0) continue;
			if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase getModsZipFileList path="+path);
			try {
				list1.add(new ZipFile(path));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		setModsZipFileList(list1);
		return list1;
	}

	@Override
	public void setModsZipFileList(List<ZipFile> list) {
		modsZipFileList = list;
	}

	@Override
	public List<File> getDirFileList(File dir) {
		boolean debug = false;
		if (dir != null); else return null;
		String path = dir.getName();
		List<File> fileList1 = getFileList(path);
		if (fileList1 != null
				&& !fileList1.isEmpty()) return fileList1;
		boolean versionNameCheck = path.equalsIgnoreCase(Modchu_Main.modsDir.getAbsolutePath());
		fileList1 = new LinkedList();
		if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase getDirFileList path="+path);
		File[] files = dir.listFiles();
		if (files != null
				&& files.length > 0); else return null;
		for (File file : files) {
			if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase getDirFileList file.getAbsolutePath()="+file.getAbsolutePath());
			boolean flag = false;
			if (file.isDirectory()) {
				if ((versionNameCheck
					&& !Modchu_Main.ngVersionName(file.getName())
					| !versionNameCheck)) {
					flag = true;
					if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase getDirFileList 1 flag = true");
				}
			} else {
				flag = true;
				if (debug) Modchu_Debug.lDebug("Modchu_FileManagerBase getDirFileList 2 flag = true");
			}
			if (flag) {
				fileList1.add(file);
			}
		}
		fileList.put(path, fileList1);
		return fileList1;
	}

	@Override
	public String getCurrentDir(String s) {
		if (s != null
				&& !s.isEmpty()); else return null;
		int i1 = s.indexOf("\\.\\");
		if (i1 > -1) {
			String s1 = s.substring(0, i1 + 1);
			return s1;
		}
		return null;
	}

	@Override
	public String getRelativePath(String s) {
		if (s != null
				&& !s.isEmpty()); else return null;
		int i1 = s.indexOf("\\.\\");
		if (i1 > -1) {
			String s1 = s.substring(i1 + 3);
			return s1;
		}
		return null;
	}

	@Override
	public Map<String, Class> getClassMap() {
		return classMap;
	}

	@Override
	public List<String> getOldResourceDirList() {
		return oldResourceDirList;
	}

}