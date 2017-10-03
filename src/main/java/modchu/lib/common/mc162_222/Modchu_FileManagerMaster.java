package modchu.lib.common.mc162_222;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;

import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ResourceInfo;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_FileManagerBase;

public class Modchu_FileManagerMaster extends Modchu_FileManagerBase {

	public Modchu_FileManagerMaster(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public boolean addResourcesMod(Class c, String classFileSearchName, String addModResourcePackSearchName) {
		if (c != null); else return false;
		boolean debug = false;
		boolean b = false;
		try {
			for (ResourceInfo i : ClassPath.from(c.getClassLoader()).getResources()) {
				String resourceName = i.getResourceName();
				if (debug) Modchu_Debug.mDebug("Modchu_FileManagerBase addResourcesMod resourceName="+resourceName);
				File file = new File(resourceName);
				if (file != null) {
					if (file.isDirectory()) {
						addTexturesDir(file, classFileSearchName, addModResourcePackSearchName);
					} else if (file.getName().endsWith(".class")) {
						b = addModClass(null, file.getAbsolutePath(), classFileSearchName, addModResourcePackSearchName);
						if (debug) Modchu_Debug.mDebug("Modchu_FileManagerBase addResourcesMod class b="+b);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public LinkedList<String> getClassLoaderResourcesList(Class c) {
		LinkedList<String> list = new LinkedList();
		if (c != null); else return null;
		try {
			for (ResourceInfo i : ClassPath.from(c.getClassLoader()).getResources()) {
				list.add(i.getResourceName());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
}