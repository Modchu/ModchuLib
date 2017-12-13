package modchu.lib;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_DataWatcherMasterBasis;
import modchu.lib.Modchu_Debug;

public class Modchu_DataWatcherMaster2 extends Modchu_DataWatcherMasterBasis {
	private Object entity;
	private Map<Integer, Object> tempWatchedObjectsMap = new HashMap();

	public Modchu_DataWatcherMaster2(HashMap<String, Object> map) {
		super(map);
		entity = map.get("Object");
		//Modchu_Debug.mDebug("Modchu_DataWatcherMaster2 init map.get(\"Object1\")="+map.get("Object1"));
		//Modchu_Debug.mDebug("Modchu_DataWatcherMaster2 init watchedObjects="+Modchu_AS.getMap("DataWatcher", "watchedObjects", map.get("Object1")));
		Modchu_AS.set("DataWatcher", "watchedObjects", base, Modchu_AS.getMap("DataWatcher", "watchedObjects", map.get("Object1")));
	}

	@Override
	public void updateWatchedObjectsFromList(List p_75687_1_) {
		boolean debug = false;
		ReadWriteLock lock = (ReadWriteLock) Modchu_Reflect.getFieldObject("DataWatcher", "field_75694_d", "lock", base);
		Map watchedObjects = Modchu_AS.getMap("DataWatcher", "watchedObjects", base);
		lock.writeLock().lock();
		Iterator iterator = p_75687_1_.iterator();
		if (debug) Modchu_Debug.mDebug("Modchu_DataWatcherMaster2 updateWatchedObjectsFromList p_75687_1_="+p_75687_1_);
		int version = Modchu_Main.getMinecraftVersion();
		while (iterator.hasNext()) {
			Object watchableobject = iterator.next();
			int id = Modchu_CastHelper.Int(Modchu_AS.get(version > 169 ? "net.minecraft.entity.DataWatcher$WatchableObject" : "WatchableObject", "getDataValueId", watchableobject));
			Object watchableobject1 = watchedObjects.get(id);
			Object o = Modchu_AS.get(version > 169 ? "net.minecraft.entity.DataWatcher$WatchableObject" : "WatchableObject", "getObject", watchableobject);
			if (debug) Modchu_Debug.mDebug("Modchu_DataWatcherMaster2 updateWatchedObjectsFromList watchableobject.getObject()="+o);
			if (watchableobject1 != null) {
				if (debug) Modchu_Debug.mDebug("Modchu_DataWatcherMaster2 updateWatchedObjectsFromList watchableobject1 != null set watchableobject.getDataValueId()="+id);
				Modchu_AS.set(version > 169 ? "net.minecraft.entity.DataWatcher$WatchableObject" : "WatchableObject", "setObject", new Class[]{ Object.class }, watchableobject1, new Object[]{ o });
				Modchu_AS.set(version > 169 ? "net.minecraft.entity.DataWatcher$WatchableObject" : "WatchableObject", "setWatched", new Class[]{ boolean.class }, watchableobject1, new Object[]{ true });
				if (version > 169) Modchu_AS.set("Entity", version > 179 ? "onDataWatcherUpdate" : "func_145781_i", new Class[]{ int.class }, entity, new Object[]{ id });
			} else {
				if (debug) Modchu_Debug.mDebug("Modchu_DataWatcherMaster2 updateWatchedObjectsFromList watchableobject1 == null !! watchableobject.getDataValueId()="+id);
				tempWatchedObjectsMap.put(id, o);
			}
		}

		lock.writeLock().unlock();
		Modchu_AS.set("DataWatcher", "objectChanged", base, true);
	}

	@Override
	public void addObject(int i, Object o) {
		boolean debug = false;
		super.addObject(i, o);
		if (debug) {
			Modchu_Debug.mDebug("Modchu_DataWatcherMaster2 addObject 1 i="+i+" o="+o);
			Modchu_Debug.mDebug("Modchu_DataWatcherMaster2 addObject 2 tempWatchedObjectsMap="+tempWatchedObjectsMap);
		}
		if (tempWatchedObjectsMap.containsKey(i)) {
			Object o1 = tempWatchedObjectsMap.get(i);
			if (debug) Modchu_Debug.mDebug("Modchu_DataWatcherMaster2 addObject 3 o1="+o1);
			updateObject(i, o1);
			tempWatchedObjectsMap.remove(i);
		} else {
			if (debug) Modchu_Debug.mDebug("Modchu_DataWatcherMaster2 addObject 4 !tempWatchedObjectsMap.containsKey");
		}
	}

}
