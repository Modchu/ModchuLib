package modchu.lib;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Modchu_FileManager {

	public static Modchu_IFileManagerMaster master;
	public static Modchu_FileManagerBase base;
	public static List<File> minecraftJarList;
	public static File minecraftDir;
	public static File assetsDir;

	public static void init() {
		System.out.println("Modchu_FileManager init()");
		if (base != null) {
			System.out.println("Modchu_FileManager init() base != null return.");
			return;
		}
		base = new Modchu_FileManagerBase(new HashMap());
		Object o = Modchu_Main.newModchuCharacteristicObject("Modchu_FileManagerMaster");
		System.out.println("Modchu_FileManager init() o="+o);
		if (o != null); else {
			String ss = "Modchu_FileManager init() o == null error !!";
			System.out.println(ss);
			Modchu_Debug.calledFrom(1);
			Modchu_Main.setRuntimeException(ss);
			return;
		}
		master = (Modchu_IFileManagerMaster) o;
		System.out.println("Modchu_FileManager init() master="+master);
	}

	public static List<File> getModFile(String pname, String pprefix) {
		return master != null ? master.getModFile(pname, pprefix) : base.getModFile(pname, pprefix);
	}

	public static List<File> getFileList(String pname) {
		return master != null ? master.getFileList(pname) : base.getFileList(pname);
	}

	public static List<File> getModFile(List<File> list, ConcurrentHashMap<String, Class> map, String search) {
		return master != null ? master.getModFile(list, map, search) : base.getModFile(list, map, search);
	}

	public static List<File> getModFile(File dir, List<File> list, ConcurrentHashMap<String, Class> map, String search, boolean subDirCheck) {
		return master != null ? master.getModFile(dir, list, map, search, subDirCheck) : base.getModFile(dir, list, map, search, subDirCheck);
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

	public static boolean addModClass(ConcurrentHashMap map, String fname, String search) {
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

	public static File getFile(String directoryPath, String matchingFileName, String indexofFileName, boolean subDirCheck) {
		return master != null ? master.getFile(directoryPath, matchingFileName, indexofFileName, subDirCheck) : base.getFile(directoryPath, matchingFileName, indexofFileName, subDirCheck);
	}

	public static ArrayList<File> listFiles(String directoryPath, String fileName) {
		return master != null ? master.listFiles(directoryPath, fileName) : base.listFiles(directoryPath, fileName);
	}

	public static ArrayList<File> listFiles(String directoryPath, String fileName, String matchingFileName, String indexofFileName, boolean subDirCheck) {
		return master != null ? master.listFiles(directoryPath, fileName, matchingFileName, indexofFileName, subDirCheck) : base.listFiles(directoryPath, fileName, matchingFileName, indexofFileName, subDirCheck);
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

	public static List<File> getMinecraftJarList() {
		if (minecraftJarList != null); else minecraftJarList = new LinkedList();
		return minecraftJarList;
	}

	public static void addMinecraftJar(File file) {
		if (minecraftJarList != null); else minecraftJarList = new LinkedList();
		minecraftJarList.add(file);
	}

	public static LinkedList<String> getClassLoaderResourcesList(Class c) {
		return master != null ? master.getClassLoaderResourcesList(c) : base.getClassLoaderResourcesList(c);
	}

	public static String[] getSystemClassPaths() {
		return master != null ? master.getSystemClassPaths() : base.getSystemClassPaths();
	}

	public static List<File> getClassPathFileList(String s) {
		return master != null ? master.getClassPathFileList(s) : base.getClassPathFileList(s);
	}

	public static List<Class> getModTextureStitchedClassList() {
		return master != null ? master.getModTextureStitchedClassList() : base.getModTextureStitchedClassList();
	}

	public static List<ZipFile> getModZipFileList() {
		return master != null ? master.getModZipFileList() : base.getModZipFileList();
	}

	public static List<ZipFile> getModZipFileList(List<File> list) {
		return master != null ? master.getModZipFileList(list) : base.getModZipFileList(list);
	}

	public void setModZipFileList(List<ZipFile> list) {
		if (master != null) master.setModZipFileList(list);
		else base.setModZipFileList(list);
	}

	public static List<ZipFile> getModsZipFileList() {
		return master != null ? master.getModsZipFileList() : base.getModsZipFileList();
	}

	public void setModsZipFileList(List<ZipFile> list) {
		if (master != null) master.setModsZipFileList(list);
		else base.setModsZipFileList(list);
	}

	public static Map<String, ZipEntry> loadZipFileToZipEntryMap(File file, Map<String, ZipEntry> map) {
		return master != null ? master.loadZipFileToZipEntryMap(file, map) : base.loadZipFileToZipEntryMap(file, map);
	}

	public static HashMap<String, ZipEntry> loadZipFileToZipEntryHashMap(File file) {
		return master != null ? master.loadZipFileToZipEntryHashMap(file) : base.loadZipFileToZipEntryHashMap(file);
	}

	public static Map<String, InputStream> loadZipFileToInputStreamMap(ZipFile zipFile, Map<String, InputStream> map) {
		return master != null ? master.loadZipFileToInputStreamMap(zipFile, map) : base.loadZipFileToInputStreamMap(zipFile, map);
	}

	public static HashMap<String, InputStream> loadZipFileToInputStreamHashMap(ZipFile zipFile) {
		return master != null ? master.loadZipFileToInputStreamHashMap(zipFile) : base.loadZipFileToInputStreamHashMap(zipFile);
	}

	public static List<File> getDirFileList(List<File> list) {
		return master != null ? master.getDirFileList(list) : base.getDirFileList(list);
	}

	public static List<File> getDirFileList(File dir, List<File> list) {
		return master != null ? master.getDirFileList(dir, list) : base.getDirFileList(dir, list);
	}

	public static String getCurrentDir(String s) {
		return master != null ? master.getCurrentDir(s) : base.getCurrentDir(s);
	}

	public static String getRelativePath(String s) {
		return master != null ? master.getRelativePath(s) : base.getRelativePath(s);
	}

}