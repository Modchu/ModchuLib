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

public interface Modchu_IFileManagerMaster {

	public List<File> getModFile(String pname, String pprefix);
	public List<File> getFileList(String pname);
	public List<File> getModFile(File dir, List<File> list, ConcurrentHashMap<String, Class> map, String search, boolean subDirCheck);
	public boolean addTexturesZip(File file, ConcurrentHashMap<String, Class> map, String search);
	public void addTexturesJar(File file, ConcurrentHashMap<String, Class> map, String search);
	public boolean addTexturesDir(File file, ConcurrentHashMap<String, Class> map, String search);
	public boolean addResourcesMod(Class c, ConcurrentHashMap<String, Class> map, String search);
	public ConcurrentHashMap addModClass(ConcurrentHashMap map, String fname, String search);
	public String classNameProcessing(String fname);
	public ZipFile getZipFile(Class c);
	public void copyZipResource(Class c, ZipFile zipFile, String s, File copydir);
	public void copyZipResource(ZipFile zipFile, File baseDir, String s);
	public void copyZipResourceAll(ZipFile zipFile, File baseDir);
	public void copyResource(ZipFile zipFile, ZipEntry ze, File outFile);
	public void copyResource(InputStream is, ZipEntry ze, File outFile);
	public void copyResource(InputStream is, HashMap<ZipEntry, File> map);
	public void copyResource(Class c, String s, File file);
	public void copyResourceText(InputStream is, File outFile);
	public File getFile(String directoryPath, String matchingFileName, String indexofFileName);
	public ArrayList<File> listFiles(String directoryPath, String fileName);
	public ArrayList<File> listFiles(String directoryPath, String fileName, String matchingFileName, String indexofFileName);
	public ArrayList<File> listFiles(String directoryPath, String fileName, String matchingFileName, String indexofFileName, ArrayList list, int type, boolean isRecursive, int period);
	public void createDir(String s);
	public BufferedReader getResourceBufferedReader(String s);
	public BufferedReader getResourceBufferedReader(Class c, String s);
	public BufferedReader getJarReader(String s);
	public ArrayList<String> loadFileToArrayList(File file);
	public LinkedList<String> loadFileToLinkedList(File file);
	public List<String> loadFileToList(File file, List list);
	public ArrayList<String> bufferedReaderToArrayList(BufferedReader breader);
	public LinkedList<String> bufferedReaderToLinkedList(BufferedReader breader);
	public List<String> bufferedReaderToList(BufferedReader breader, List list);
	public ArrayList<String> inputStreamToArrayList(InputStream is);
	public LinkedList<String> inputStreamToLinkedList(InputStream is);
	public List<String> inputStreamToList(InputStream is, List list);
	public void writerFile(File file, String[] s);
	public void writerFile(File file, List<String> list1);
	public void writerFile(File file, Map map);
	public LinkedList<String> getClassLoaderResourcesList(Class c);

}
