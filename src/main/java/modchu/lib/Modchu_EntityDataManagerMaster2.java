package modchu.lib;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.locks.ReadWriteLock;

public class Modchu_EntityDataManagerMaster2 extends Modchu_EntityDataManagerMasterBasis {
	private Object entity;
	private TreeMap<Integer, Object> tempDataEntryMap = new TreeMap();
	private static int debugEntityId = -1;

	public Modchu_EntityDataManagerMaster2(HashMap<String, Object> map) {
		super(map);
		entity = map.get("Object");
		//Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 init map.get(\"Object1\")="+map.get("Object1"));
		Map map1 = Modchu_AS.getMap("EntityDataManager", "entries", base);
		//Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 init map1="+map1);
		Map map2 = Modchu_AS.getMap("EntityDataManager", "entries", map.get("Object1"));
		//Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 init map2="+map2);
		Modchu_Main.mapAddAll(map1, map2);
		Map NEXT_ID_MAP1 = Modchu_AS.getMap("EntityDataManager", "NEXT_ID_MAP", base);
		Map NEXT_ID_MAP2 = Modchu_AS.getMap("EntityDataManager", "NEXT_ID_MAP", map.get("Object1"));
		Modchu_Main.mapAddAll(NEXT_ID_MAP1, NEXT_ID_MAP2);
		Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 init NEXT_ID_MAP1="+NEXT_ID_MAP1);
		//Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 init NEXT_ID_MAP2="+NEXT_ID_MAP2);
	}

	@Override
	public Object get(Object dataParameter) {
		boolean debug = false;
		Map entries = Modchu_AS.getMap("EntityDataManager", "entries", base);
		int id = Modchu_AS.getInt("DataParameter", "getId", dataParameter);
		Object dataentry = entries.get(id);
		if (debug
				&& id > 14) {
			Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 get id="+id);
			Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 get dataentry="+dataentry);
			Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 get dataentry.getValue="+Modchu_AS.get("EntityDataManager$DataEntry", "getValue", dataentry));
			//Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 get tempWatchedObjectsList="+tempWatchedObjectsList);
		}

		return super.get(dataParameter);
	}

	@Override
	public Object getEntry(Object dataParameter) {
		boolean debug = false;
		if (debug) Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 	getEntry --------------------------- start.");
		Object dataentry = super.getEntry(dataParameter);
		int id = Modchu_AS.getInt("DataParameter", "getId", dataParameter);

		boolean flag = tempDataEntryMap.containsKey(id);
		if (flag) {
			dataentry = tempDataEntryMap.get(id);
			Map entries = Modchu_AS.getMap("EntityDataManager", "entries", base);
			entries.put(id, dataentry);
			if (debug) Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 	getEntry tempDataEntryMap.containsKey id="+id);
			tempDataEntryMap.remove(id);
			if (debug) {
				Object o = Modchu_AS.get("EntityDataManager$DataEntry", "getValue", dataentry);
				Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 	getEntry tempDataEntryMap.containsKey o="+o);
			}
		} else {
			if (debug) {
				Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 	getEntry !tempDataEntryMap.containsKey id="+id);
				Object o = Modchu_AS.get("EntityDataManager$DataEntry", "getValue", dataentry);
				Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 	getEntry !tempDataEntryMap.containsKey o="+o);
			}
		}
		if (debug) Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 	getEntry --------------------------- end.");
		return dataentry;
	}

	@Override
	public void setEntryValues(List entriesIn) {
		boolean debug = false;
		ReadWriteLock lock = (ReadWriteLock) Modchu_AS.get("EntityDataManager", "lock", base);
		Map entries = Modchu_AS.getMap("EntityDataManager", "entries", base);
		lock.writeLock().lock();

		if (debug) {
			Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 setEntryValues --------------------------- start.");
			Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 setEntryValues this="+this);
			Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 setEntryValues entity="+entity);
			Object worldObj = Modchu_AS.get(Modchu_AS.entityWorldObj, entity);
			Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 setEntryValues worldObj.isRemote="+Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, worldObj));
			Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 setEntryValues entries="+entries);
		}
		for (Object dataentry : entriesIn) {

			Object dataParameter = Modchu_AS.get("EntityDataManager$DataEntry", "getKey", dataentry);
			int id = Modchu_AS.getInt("DataParameter", "getId", dataParameter);
			Object dataentry1 = entries.get(id);
			Object o = Modchu_AS.get("EntityDataManager$DataEntry", "getValue", dataentry);
			if (debug) {
				Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 setEntryValues ---------- id="+id);
				Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 setEntryValues dataentry="+dataentry);
				Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 setEntryValues o="+o);
			}
			if (dataentry1 != null) {
				if (debug) Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 setEntryValues dataentry1 != null !!");
				setEntryValue(dataentry1, dataentry);
			} else {
				//base.initIdCountSetting();
				if (debug) Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 setEntryValues dataentry1 == null !!");
				tempDataEntryMap.put(id, dataentry);
				//tempWatchedObjectsList.add(o);
				//if (debug) Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 setEntryValues dataentry1 == null !! tempWatchedObjectsList.size()="+tempWatchedObjectsList.size());
			}
			Modchu_AS.set("Entity", "notifyDataManagerChange", new Class[]{ Modchu_Reflect.loadClass("DataParameter") }, entity, new Object[]{ dataParameter });
		}

		lock.writeLock().unlock();
		Modchu_AS.set("EntityDataManager", "dirty", base, true);
		if (debug) {
			if (!tempDataEntryMap.isEmpty()) {
				//if (debugEntityId < 0) debugEntityId = Modchu_AS.getInt(Modchu_AS.entityEntityID, entity);
				if (debugEntityId < 0) debugEntityId = entity.hashCode();
				if (debugEntityId == entity.hashCode()) {
					Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 setEntryValues tempWatchedObjectsList debug ---------------------- start.");
					for (Entry<Integer, Object> en : tempDataEntryMap.entrySet()) {
						int i1 = en.getKey();
						Object dataentry1 = en.getValue();
						Object dataParameter1 = Modchu_AS.get("EntityDataManager$DataEntry", "getKey", dataentry1);
						int id1 = Modchu_AS.getInt("DataParameter", "getId", dataParameter1);
						Object o1 = Modchu_AS.get("EntityDataManager$DataEntry", "getValue", dataentry1);
						Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 setEntryValues id1="+id1+" o1="+o1);
						Modchu_Debug.mdDebug("tempWatchedObjectsList id1="+id1+" o1="+o1, 7 + id1 - 15);
					}
					Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 setEntryValues tempWatchedObjectsList debug ---------------------- end.");
				}
			}
			Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 setEntryValues --------------------------- end.");
		}
	}

	@Override
	public void register(Object dataParameter, Object o, int i) {
		boolean debug = false;
		Map entries = Modchu_AS.getMap("EntityDataManager", "entries", base);
		int id = Modchu_AS.getInt("DataParameter", "getId", dataParameter);
		if (debug) {
			if (entries.containsKey(id)) {
				Object dataentry2 = entries.get(id);
				Object o1 = Modchu_AS.get("EntityDataManager$DataEntry", "getValue", dataentry2);
				Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 register 1 i="+i+" id="+id+" o1="+o1);
			} else {
				Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 register 2 !entries.containsKey. new i="+i+" id="+id+" o="+o);
			}
		}

		Object dataentry = null;
		boolean flag = tempDataEntryMap.containsKey(id);
		if (flag) {
			dataentry = tempDataEntryMap.get(id);
		}

		if (debug) {
			Object worldObj = Modchu_AS.get(Modchu_AS.entityWorldObj, entity);
			Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 register 3 worldObj.isRemote="+Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, worldObj));
		}
		if (entries.containsKey(id)) {
			if (dataentry != null); else dataentry = entries.get(id);
			entries.put(id, dataentry);
			base.putIdMap(i, id);
			base.putDataParameterMap(i, dataParameter);
			if (debug) {
				Object o4 = Modchu_AS.get("EntityDataManager$DataEntry", "getValue", dataentry);
				Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 register 4 entries.containsKey new o4="+o4);
			}
		} else {
			if (debug) Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 register 5 !entries.containsKey o="+o);
			super.register(dataParameter, o);
			if (flag) {
				entries.put(id, dataentry);
			}
			base.putIdMap(i, id);
			base.putDataParameterMap(id, dataParameter);
		}
		Modchu_AS.set("EntityDataManager", "empty", base, false);
		if (flag) tempDataEntryMap.remove(id);
		if (debug) {
			Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 register 6 i="+i);
			Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 register 7 id="+id);
			Modchu_Debug.mDebug("Modchu_EntityDataManagerMaster2 register end.");
		}
	}

}
