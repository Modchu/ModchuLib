package modchu.lib;import java.awt.image.BufferedImage;import java.io.File;import java.io.FileInputStream;import java.io.IOException;import java.io.InputStream;import java.util.Enumeration;import java.util.HashMap;import java.util.LinkedList;import java.util.List;import java.util.Set;import java.util.concurrent.ConcurrentHashMap;import java.util.zip.ZipEntry;import java.util.zip.ZipFile;import javax.imageio.ImageIO;public class Modchu_ModResourcePackMaster extends Modchu_IResourcePackMasterBasis {	protected final Class resourceClass;	protected final Object resourceFile;	protected List<String> resourceList;	private ZipFile zipFile;	public Modchu_ModResourcePackMaster(HashMap<String, Object> map) {		super(map);		resourceClass = map.containsKey("Class1") ? (Class) map.get("Class1") : null;		resourceFile = map.containsKey("File") ? (File) map.get("File") : map.containsKey("Object") ? map.get("Object") : null;		boolean debug = false;		if (debug) {			Modchu_Debug.lDebug("Modchu_ModResourcePackMaster init resourceFile="+resourceFile);			Modchu_Debug.lDebug("Modchu_ModResourcePackMaster init getResourceDomains()="+getResourceDomains());		}		if (resourceFile != null); else return;		resourceList = new LinkedList();		try {			if (resourceFile instanceof File					&& ((File) resourceFile).isDirectory()) {				addResourceListDir((File) resourceFile);			} else {				zipFile = resourceFile instanceof ZipFile ? (ZipFile) resourceFile : new ZipFile((File) resourceFile);				ZipEntry entry = null;				if (zipFile != null)				for (Enumeration<? extends ZipEntry> e = zipFile.entries(); e.hasMoreElements();) {					entry = e.nextElement();					if (entry.isDirectory()) continue;					String entryName = decodeEntryName(entry.getName());					resourceList.add(entryName);					if (debug) Modchu_Debug.lDebug("Modchu_ModResourcePackMaster init resourceList.add entryName="+entryName);				}			}		} catch (Exception e) {			e.printStackTrace();		}	}	private boolean addResourceListDir(File file) {		if (file != null); else return false;		boolean debug = false;		if (debug) Modchu_Debug.mDebug("Modchu_ModResourcePackMaster addResourceListDir file.getName()="+file.getName());		boolean b = false;		try {			for (File t : file.listFiles()) {				String path = t.getAbsolutePath();				if (t.isDirectory()) {					b = addResourceListDir(t);				} else {					if (debug) Modchu_Debug.mDebug("Modchu_ModResourcePackMaster addResourceListDir 1 path="+path);					String currentPath = ((File) resourceFile).getAbsolutePath();					if (path.startsWith(currentPath)) {						path = path.substring(currentPath.length());						if (path.startsWith("\\")								| path.startsWith("/")								| path.startsWith(".")) {							path = path.substring(1);						}					}					if (debug) Modchu_Debug.mDebug("Modchu_ModResourcePackMaster addResourceListDir 2 path="+path);					resourceList.add(path);					b = true;				}			}		} catch (Exception e) {			e.printStackTrace();		}		return b;	}	@Override	public InputStream getInputStream(Object resourceLocation) {		boolean debug = false;		//boolean debug = Modchu_Main.isRelease();		String path = getPath(resourceLocation);/*		debug = !Modchu_Main.isRelease()				&& resourceLocation != null				&& (path.indexOf("littleMaid") > -1						| path.indexOf("littlemaid") > -1);*/		if (debug) {			Modchu_Debug.lDebug1("Modchu_ModResourcePackMaster getInputStream resourceLocation="+resourceLocation);			Modchu_Debug.lDebug1("Modchu_ModResourcePackMaster getInputStream path="+path);		}		if (resourceClass != null) {			if (debug) Modchu_Debug.lDebug1("Modchu_ModResourcePackMaster getInputStream resourceClass != null resourceClass="+resourceClass);			InputStream inputStream = resourceClass.getResourceAsStream(path);			if (inputStream != null) return inputStream;			if (path.startsWith("/")) {				path = path.substring(1);				inputStream = resourceClass.getResourceAsStream(path);			} else {				path = "/"+path;				inputStream = resourceClass.getResourceAsStream(path);			}			return inputStream;		}		if (!resourceListContains(path)) {			if (debug) Modchu_Debug.lDebug1("Modchu_ModResourcePackMaster getInputStream !resourceListContains path="+path);			return null;		}		if (debug) Modchu_Debug.lDebug1("Modchu_ModResourcePackMaster getInputStream resourceList.contains path="+path);		InputStream is = null;		try {			if (resourceFile instanceof File					&& ((File) resourceFile).isDirectory()) {				String path1 = ((File) resourceFile).getAbsolutePath();				File file = new File(path1, path);				is = new FileInputStream(file);			} else {				ZipEntry entry = null;				for (Enumeration<? extends ZipEntry> e = zipFile.entries(); e.hasMoreElements();) {					entry = e.nextElement();					if (entry.isDirectory()) continue;					String entryName = decodeEntryName(entry.getName());					if (debug) Modchu_Debug.lDebug1("Modchu_ModResourcePackMaster getInputStream entryName="+entryName);					if (entryName.equalsIgnoreCase(path)) {						is = zipFile.getInputStream(entry);						if (debug) Modchu_Debug.lDebug1("Modchu_ModResourcePackMaster getInputStream is="+is);						//BufferedImage bufferedImage = readBufferedImage(is);						//Modchu_Debug.mDebug("Modchu_ModResourcePackMaster getInputStream BufferedImage="+bufferedImage);						if (debug) Modchu_Debug.lDebug1("Modchu_ModResourcePackMaster getInputStream return is="+is);					}				}			}		} catch (Exception e) {			e.printStackTrace();		}		if (debug) Modchu_Debug.lDebug1("Modchu_ModResourcePackMaster getInputStream return null !! path="+path);		return is;	}/*	public static BufferedImage readBufferedImage(InputStream imageStream) throws IOException {		BufferedImage bufferedimage;		try {			bufferedimage = ImageIO.read(imageStream);		} finally {			IOUtils.closeQuietly(imageStream);		}		return bufferedimage;	}*/	@Override	public boolean resourceExists(Object resourceLocation) {		String path = getPath(resourceLocation);		boolean debug = false;/*		debug = !Modchu_Main.isRelease()				//&& resourceFile != null				&& resourceLocation != null				&& (path.indexOf("littleMaid") > -1						| path.indexOf("littlemaid") > -1);*/		if (debug) {			Modchu_Debug.lDebug("Modchu_ModResourcePackMaster resourceExists path="+path);			Modchu_Debug.lDebug("Modchu_ModResourcePackMaster resourceExists resourceClass="+resourceClass);			Modchu_Debug.lDebug("Modchu_ModResourcePackMaster resourceExists resourceFile ="+(resourceFile instanceof File ? ((File) resourceFile).getAbsolutePath() :				resourceFile instanceof ZipFile ? ((ZipFile) resourceFile).getName() : resourceFile));			Modchu_Debug.lDebug("Modchu_ModResourcePackMaster resourceExists resourceLocation="+resourceLocation);		} else {/*			if (resourceFile != null); else {				List list = Modchu_AS.getList("Minecraft", "defaultResourcePacks", Modchu_AS.get(Modchu_AS.minecraftGetMinecraft));				for (Object o : list) {					if (o instanceof Modchu_IResourcePack) {						Modchu_IResourcePack iResourcePack = (Modchu_IResourcePack) o;						Object master = Modchu_Main.getModchuCharacteristicObjectMaster(iResourcePack);						Modchu_ModResourcePackMaster ModResourcePackMaster = (Modchu_ModResourcePackMaster) master;						Modchu_Debug.lDebug("Modchu_ModResourcePackMaster resourceExists ModResourcePackMaster.resourceFile="+ModResourcePackMaster.resourceFile);					}				}				String ss = "Modchu_ModResourcePackMaster resourceExists ModResourcePackMaster debug";				Modchu_Debug.mDebug(ss);				Modchu_Main.setRuntimeException(ss);			}*/		}		int i1 = path.indexOf(".mcmeta");		if (i1 > -1) {			String s1 = path.substring(0, i1);			if (debug) Modchu_Debug.lDebug("Modchu_ModResourcePackMaster resourceExists mcmeta check s1="+s1);			if (resourceListContains(s1)) {				if (debug) Modchu_Debug.lDebug("Modchu_ModResourcePackMaster resourceExists mcmeta return true.");				return true;			}		}		boolean b = false;		if (resourceClass != null) {			b = getInputStream(resourceLocation) != null;		}		if (!b) {			b = resourceListContains(path);			if (!b					&& path.indexOf(":") < 0					&& !path.startsWith("/")) {				String s2 = "/" + path;				b = resourceListContains(s2);			}		}		if (debug) {			if (!b) {				Modchu_Debug.lDebug("Modchu_ModResourcePackMaster resourceExists false resourceList="+resourceList);			}			Modchu_Debug.lDebug("Modchu_ModResourcePackMaster resourceExists return b="+b);		}		return b;	}	private boolean resourceListContains(String s) {		if (resourceList != null				&& !resourceList.isEmpty()); else return false;		for (String s1 : resourceList) {			if (s1.equalsIgnoreCase(s)) return true;		}		return false;	}	@Override	public Set getResourceDomains() {		return (Set) Modchu_Reflect.invokeMethod("com.google.common.collect.ImmutableSet", "of", new Class[]{ Object.class, Object.class, Object.class }, new Object[]{ "minecraft", "realms", Modchu_Version.modName });	}	@Override	public Object getPackMetadata(Object metadataSerializer, String s) {		int version = Modchu_Main.getMinecraftVersion();		return Modchu_AS.get(version > 169				&& version < 194 ? "IMetadataSerializer" : "MetadataSerializer", "parseMetadataSection", new Class[]{ String.class, Modchu_Reflect.loadClass("com.google.gson.JsonObject") }, metadataSerializer, new Object[]{ s, Modchu_Reflect.newInstance("com.google.gson.JsonObject") });	}	@Override	public BufferedImage getPackImage() {		try {			String name =					"/" + (Modchu_AS.get(Modchu_AS.resourceLocationGetResourcePath, Modchu_Main.newResourceLocation("pack.png")));			InputStream inputStream = null;			if (resourceClass != null) {				inputStream = resourceClass.getResourceAsStream(name);			} else {				Object resourceLocation = Modchu_AS.get(Modchu_AS.newResourceLocation, "pack.png");				inputStream = getInputStream(resourceLocation);			}			if (inputStream != null) return ImageIO.read(inputStream);		} catch (IOException e) {			e.printStackTrace();		}		return null;	}	@Override	public String getPackName() {		return resourceClass != null ? resourceClass.getSimpleName() : resourceFile instanceof File				? ((File) resourceFile).getName() : resourceFile instanceof ZipFile ? ((ZipFile) resourceFile).getName() : null;	}	private String getPath(Object resourceLocation) {		boolean debug = false;		boolean flag = resourceFile != null				&& resourceFile instanceof File				&& ((File) resourceFile).isDirectory();		//debug = flag;		String resourceDomain = Modchu_AS.getString(Modchu_AS.resourceLocationGetResourceDomain, resourceLocation);		String resourcePath = Modchu_AS.getString(Modchu_AS.resourceLocationGetResourcePath, resourceLocation);		if (resourcePath.startsWith("assets")) {			resourcePath = resourcePath.substring(7);			int i1 = resourcePath.indexOf("\\");			if (i1 > -1) resourcePath = resourcePath.substring(i1 + 1);			i1 = resourcePath.indexOf("/");			if (i1 > -1) resourcePath = resourcePath.substring(i1 + 1);		}		String path = null;		if (flag) {			resourcePath = resourcePath.replace("/", "\\");		} else {			resourcePath = resourcePath.replace("/", ".");		}		String s1 = flag ? "\\" : ".";		path = new StringBuilder().append("assets").append(s1).append(resourceDomain).append(s1).append(resourcePath).toString();		if (debug) Modchu_Debug.lDebug1("Modchu_ModResourcePackMaster getPath path="+path);		return path;	}	private String encodeEntryName(String s) {		String s1 = "assets/";		int i1 = s.indexOf(s1);		if (i1 > -1) {			s = s.substring(i1 + s1.length());			i1 = s.indexOf("/");			if (i1 > -1) {				s = s.substring(i1 + 1);			}		}		return s;	}	private String decodeEntryName(String s) {		String s1 = ":";		int i1 = s.indexOf(s1);		if (i1 > -1) {			s = new StringBuilder().append("assets/").append(s.substring(0, i1)).append("/").append(s.substring(i1 + 1)).toString();		}		return s;	}}