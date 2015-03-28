package modchu.lib.common.mc162_180;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

import modchu.lib.Modchu_FileManagerBase;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;

import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ResourceInfo;

public class Modchu_FileManagerMaster extends Modchu_FileManagerBase {

	public Modchu_FileManagerMaster(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public boolean addResourcesMod(Class c, ConcurrentHashMap<String, Class> map, String search) {
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