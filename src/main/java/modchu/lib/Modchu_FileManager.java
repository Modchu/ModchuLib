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

public class Modchu_FileManager {

	public static Modchu_IFileManagerMaster master;
	public static Modchu_FileManagerBase base = new Modchu_FileManagerBase(new HashMap());
	public static File minecraftJar;
	public static File minecraftDir;
	public static File assetsDir;

	public static void init() {
		System.out.println("Modchu_FileManager init()");
		Object o = Modchu_Main.newModchuCharacteristicObject("Modchu_FileManagerMaster");
		System.out.println("Modchu_FileManager init() o="+o);
		master = (Modchu_IFileManagerMaster) o;
		System.out.println("Modchu_FileManager init() master="+master);
	}

	public static List<File> getModFile(String pname, String pprefix) {
		return master != null ? master.getModFile(pname, pprefix) : base.getModFile(pname, pprefix);
	}

	public static List<File> getFileList(String pname) {
		return master != null ? master.getFileList(pname) : base.getFileList(pname);
	}

	public static List<File> getModFile(File dir, List<File> list, ConcurrentHashMap<String, Class> map, String search) {
		return master != null ? master.getModFile(dir, list, map, search) : base.getModFile(dir, list, map, search);
	}

	public static boolean addTexturesZip(File file, ConcurrentHashMap<String, Class> map, String search) {
		return master != null ? master.addTexturesZip(file, map, search) : base.addTexturesZip(file, map, search);
	}

	public static void addTexturesJar(File file, ConcurrentHashMap<String, Class> map, String search) {
		if (master != null) master.addTexturesJar(file, map, search);
		else base.addTexturesJar(file, map, search);
	}

	public static boolean addTexturesDir(File file, ConcurrentHashMap<String, Class> map, String search) {
		return master != null ? master.addTexturesDir(file, map, search) : base.addTexturesDir(file, map, search);
	}

	public static boolean addResourcesMod(Class c, ConcurrentHashMap<String, Class> map, String search) {
		return master != null ? master.addResourcesMod(c, map, search) : base.addResourcesMod(c, map, search);
	}

	public static ConcurrentHashMap addModClass(ConcurrentHashMap map, String fname, String search) {
		return master != null ? master.addModClass(map, fname, search) : base.addModClass(map, fname, search);
	}

	public static String classNameProcessing(String fname) {
		return master != null ? master.classNameProcessing(fname) : base.classNameProcessing(fname);
	}

	public static ZipFile getZipFile(Class c) {
		return master != null ? master.getZipFile(c) : base.getZipFile(c);
	}

	public static void copyZipResource(Class c, ZipFile zipFile, String s, File copydir) {
		if (master != null) master.copyZipResource(c, zipFile, s, copydir);
		else base.copyZipResource(c, zipFile, s, copydir);
	}

	public static void copyZipResource(ZipFile zipFile, File baseDir, String s) {
		if (master != null) master.copyZipResource(zipFile, baseDir, s);
		else base.copyZipResource(zipFile, baseDir, s);
	}

	public static void copyZipResourceAll(ZipFile zipFile, File baseDir) {
		if (master != null) master.copyZipResourceAll(zipFile, baseDir);
		else base.copyZipResourceAll(zipFile, baseDir);
	}

	public static void copyResource(ZipFile zipFile, ZipEntry ze, File outFile) {
		if (master != null) master.copyResource(zipFile, ze, outFile);
		else base.copyResource(zipFile, ze, outFile);
	}

	public static void copyResource(InputStream is, ZipEntry ze, File outFile) {
		if (master != null) master.copyResource(is, ze, outFile);
		else base.copyResource(is, ze, outFile);
	}

	public static void copyResource(InputStream is, HashMap<ZipEntry, File> map) {
		if (master != null) master.copyResource(is, map);
		else base.copyResource(is, map);
	}

	public static void copyResource(Class c, String s, File file) {
		if (master != null) master.copyResource(c, s, file);
		else base.copyResource(c, s, file);
	}

	public static void copyResourceText(InputStream is, File outFile) {
		if (master != null) master.copyResourceText(is, outFile);
		else base.copyResourceText(is, outFile);
	}

	public static File getFile(String directoryPath, String matchingFileName, String indexofFileName) {
		return master != null ? master.getFile(directoryPath, matchingFileName, indexofFileName) : base.getFile(directoryPath, matchingFileName, indexofFileName);
	}

	public static ArrayList<File> listFiles(String directoryPath, String fileName) {
		return master != null ? master.listFiles(directoryPath, fileName) : base.listFiles(directoryPath, fileName);
	}

	public static ArrayList<File> listFiles(String directoryPath, String fileName, String matchingFileName, String indexofFileName) {
		return master != null ? master.listFiles(directoryPath, fileName, matchingFileName, indexofFileName) : base.listFiles(directoryPath, fileName, matchingFileName, indexofFileName);
	}

	public static ArrayList<File> listFiles(String directoryPath, String fileName, String matchingFileName, String indexofFileName, ArrayList list, int type, boolean isRecursive, int period) {
		return master != null ? master.listFiles(directoryPath, fileName, matchingFileName, indexofFileName, list, type, isRecursive, period) : base.listFiles(directoryPath, fileName, matchingFileName, indexofFileName, list, type, isRecursive, period);
	}

	public static void createDir(String s) {
		if (master != null) master.createDir(s);
		else base.createDir(s);
	}

	public static BufferedReader getResourceBufferedReader(String s) {
		return master != null ? master.getResourceBufferedReader(s) : base.getResourceBufferedReader(s);
	}

	public static BufferedReader getResourceBufferedReader(Class c, String s) {
		return master != null ? master.getResourceBufferedReader(c, s) : base.getResourceBufferedReader(c, s);
	}

	public static BufferedReader getJarReader(String s) {
		return master != null ? master.getJarReader(s) : base.getJarReader(s);
	}

	public static ArrayList<String> loadFileToArrayList(File file) {
		return master != null ? master.loadFileToArrayList(file) : base.loadFileToArrayList(file);
	}

	public static LinkedList<String> loadFileToLinkedList(File file) {
		return master != null ? master.loadFileToLinkedList(file) : base.loadFileToLinkedList(file);
	}

	public static List<String> loadFileToList(File file, List list) {
		return master != null ? master.loadFileToList(file, list) : base.loadFileToList(file, list);
	}

	public static ArrayList<String> bufferedReaderToArrayList(BufferedReader breader) {
		return master != null ? master.bufferedReaderToArrayList(breader) : base.bufferedReaderToArrayList(breader);
	}

	public static LinkedList<String> bufferedReaderToLinkedList(BufferedReader breader) {
		return master != null ? master.bufferedReaderToLinkedList(breader) : base.bufferedReaderToLinkedList(breader);
	}

	public static List<String> bufferedReaderToList(BufferedReader breader, List list) {
		return master != null ? master.bufferedReaderToList(breader, list) : base.bufferedReaderToList(breader, list);
	}

	public static ArrayList<String> inputStreamToArrayList(InputStream is) {
		return master != null ? master.inputStreamToArrayList(is) : base.inputStreamToArrayList(is);
	}

	public static LinkedList<String> inputStreamToLinkedList(InputStream is) {
		return master != null ? master.inputStreamToLinkedList(is) : base.inputStreamToLinkedList(is);
	}

	public static List<String> inputStreamToList(InputStream is, List list) {
		return master != null ? master.inputStreamToList(is, list) : base.inputStreamToList(is, list);
	}

	public static void writerFile(File file, String[] s) {
		if (master != null) master.writerFile(file, s);
		else base.writerFile(file, s);
	}

	public static void writerFile(File file, List<String> list1) {
		if (master != null) master.writerFile(file, list1);
		else base.writerFile(file, list1);
	}

	public static void writerFile(File file, Map map) {
		if (master != null) master.writerFile(file, map);
		else base.writerFile(file, map);
	}

	public static File getMinecraftDir() {
		return minecraftDir;
	}

	public static void setMinecraftDir(File file) {
		minecraftDir = file;
	}

	public static File getAssetsDir() {
		return assetsDir;
	}

	public static void setAssetsDir(File file) {
		assetsDir = file;
	}

	public static File getMinecraftJar() {
		return minecraftJar;
	}

	public static void setMinecraftJar(File file) {
		minecraftJar = file;
	}

	public static LinkedList<String> getClassLoaderResourcesList(Class c) {
		return master != null ? master.getClassLoaderResourcesList(c) : base.getClassLoaderResourcesList(c);
	}
}