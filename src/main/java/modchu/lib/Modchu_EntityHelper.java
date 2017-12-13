package modchu.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.UUID;

public class Modchu_EntityHelper {
	public static Modchu_EntityHelper instance;
	private static HashMap<Integer, HashMap<Object, HashMap<String, Object>>> dataMap;
	private boolean debugDataWatcher = false;

	public Modchu_EntityHelper() {
		if (instance != null); else instance = this;
		if (dataMap != null); else dataMap = new HashMap();
	}

	public static Modchu_EntityHelper getInstance() {
		return instance;
	}

	public static void setInstance(Modchu_EntityHelper o) {
		instance = o;
	}

	public Object init(Modchu_IEntityHelper modchu_IEntityHelper, HashMap<String, Object> map) {
		boolean debug = false;
		if (modchu_IEntityHelper.isInitFlag()) return Modchu_Main.getModchuCharacteristicObjectMaster(modchu_IEntityHelper);
		Object worldObj = Modchu_AS.get(Modchu_AS.entityWorldObj, modchu_IEntityHelper);
		int version = Modchu_Main.getMinecraftVersion();
		if (map != null
				&& !map.isEmpty()); else {
			Object o = getData(modchu_IEntityHelper, "tempInitMap");
			map = o != null ? (HashMap<String, Object>) o : null;
		}
		if (map != null
				&& !map.isEmpty()
				&& map.containsKey("Class")); else {
			boolean isRemote = Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, modchu_IEntityHelper);
			Modchu_Debug.mDebug("Modchu_EntityHelper init map == null or !containsKey map="+map);
			Modchu_Debug.mDebug("Modchu_EntityHelper init map == null or !containsKey  isRemote="+isRemote);
			String entityName = getMasterClassName(modchu_IEntityHelper);
			Modchu_Debug.mDebug("Modchu_EntityHelper init map == null or !containsKey  entityName="+entityName);
			int debugCount = Modchu_CastHelper.Int(Modchu_Debug.getFreeVariable("Modchu_EntityHelper_debugCount"));
/*
			if (worldObj.isRemote) {
				Modchu_Debug.mdDebug("debugCount="+debugCount, 9);
				Modchu_Debug.mdDebug("entityName="+entityName, 10);
			}
*/
			Class c = null;
			if (entityName == null
					| (entityName != null
					&& entityName.isEmpty())) {
				if (isRemote) {
					// TODO
					Modchu_Debug.mDebug("Modchu_EntityHelper init map == null or !containsKey  debugCount="+debugCount);
					if (debugCount == 30) {
						Modchu_Debug.mDebug("Modchu_EntityHelper init map == null or !containsKey  debugCount == 30 entries");
						Object dataManager = Modchu_AS.get("Entity", version > 190
								| (version == 190
								&& Modchu_Main.isRelease()) ? "dataManager" : "dataWatcher", modchu_IEntityHelper);
						Map<Integer, Object> entries = Modchu_AS.getMap("EntityDataManager", "entries", dataManager);
						for (Entry<Integer, Object> en : entries.entrySet()) {
							Object dataentry1 = en.getValue();
							Object dataParameter1 = Modchu_AS.get("EntityDataManager$DataEntry", "getKey", dataentry1);
							int id1 = Modchu_AS.getInt("DataParameter", "getId", dataParameter1);
							Object o1 = Modchu_AS.get("DataParameter", "getValue", dataentry1);
							Modchu_Debug.mDebug("Modchu_EntityHelper init map == null or !containsKey debugCount == 30 entries id1="+id1+" o1="+o1);
						}
						Object master = Modchu_Main.getModchuCharacteristicObjectMaster(dataManager);
						TreeMap<Integer, Object> tempDataEntryMap = (TreeMap<Integer, Object>) Modchu_Reflect.getFieldObject(master.getClass(), "tempDataEntryMap", master);
						if (!tempDataEntryMap.isEmpty()) {
							for (Entry<Integer, Object> en : tempDataEntryMap.entrySet()) {
								Object dataentry1 = en.getValue();
								Object dataParameter1 = Modchu_AS.get("EntityDataManager$DataEntry", "getKey", dataentry1);
								int id2 = Modchu_AS.getInt("DataParameter", "getId", dataParameter1);
								Object o2 = Modchu_AS.get("EntityDataManager$DataEntry", "getValue", dataentry1);
								Modchu_Debug.mDebug("Modchu_EntityHelper init map == null or !containsKey debugCount == 30 tempDataEntryMap id2="+id2+" o2="+o2);
							}
						}
						HashMap<Integer, Integer> idMap = (HashMap<Integer, Integer>) Modchu_Reflect.getFieldObject(dataManager.getClass(), "idMap", dataManager);
						if (!idMap.isEmpty()) {
							for (Entry<Integer, Integer> en : idMap.entrySet()) {
								int i = en.getKey();
								int i1 = en.getValue();
								Modchu_Debug.mDebug("Modchu_EntityHelper init map == null or !containsKey debugCount == 30 idMap i="+i+" i1="+i1);
							}
						}
						//debugDead = true;
					}
					return null;
				} else {
					double posX = Modchu_AS.getDouble(Modchu_AS.entityPosX, modchu_IEntityHelper);
					double posY = Modchu_AS.getDouble(Modchu_AS.entityPosY, modchu_IEntityHelper);
					double posZ = Modchu_AS.getDouble(Modchu_AS.entityPosZ, modchu_IEntityHelper);
					if (posX != 0
							&& posY != 0
							&& posZ != 0) {
						c = Modchu_Main.getSpownEntityClass(worldObj, posX, posY, posZ);
						if (c != null) {
							if (debug) Modchu_Debug.mDebug("Modchu_EntityHelper init map == null or !containsKey SpownEntity c="+c);
						} else {
							int ticksExisted = Modchu_AS.getInt(Modchu_AS.entityTicksExisted, modchu_IEntityHelper);
							if (ticksExisted > 29) Modchu_AS.set(Modchu_AS.entitySetDead, modchu_IEntityHelper);
							return null;
						}
					} else {
						return null;
					}
				}
			}
			if (debug) Modchu_Debug.mDebug("Modchu_EntityHelper init map == null or !containsKey entityName="+entityName);
			//Modchu_Debug.mDebug("Modchu_EntityHelper init isRemote="+worldObj.isRemote);
			if (c != null); else c = getMasterClass(modchu_IEntityHelper);
			if (c != null); else {
				if (debug) {
					Modchu_Debug.mDebug("Modchu_EntityHelper init map == null or !containsKey c == null debug1 return entityName="+entityName);
					//setDead();
					Modchu_Main.setRuntimeException("init debug");
				}
				return null;
			}
			map = new HashMap();
			map.put("Class", c);
		}
		if (map != null
				&& !map.isEmpty()
				&& map.containsKey("Class")); else {
			if (getData(modchu_IEntityHelper, "tempInitMap") != null); else setData(modchu_IEntityHelper, "tempInitMap", map);
			return null;
		}
		Class c = map.containsKey("Class") ? ((Class) map.get("Class")) : null;
		if (c != null); else return null;
		map.put("Object", worldObj);
		map.put("base", modchu_IEntityHelper);
		if (debug) Modchu_Debug.mDebug("Modchu_EntityHelper init c.getName()="+c.getName());
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		if (instance != null); else {
			Modchu_Debug.lDebug("Modchu_EntityHelper init 4 instance == null !! c.getName()="+c.getName());
			Modchu_AS.set(modchu_IEntityHelper.getClass(), "setDead", modchu_IEntityHelper);
			return null;
		}
		if (debug) Modchu_Debug.mDebug("Modchu_EntityHelper init instance="+instance);
		Modchu_Reflect.setFieldObject(modchu_IEntityHelper.getClass(), "master", modchu_IEntityHelper, instance);
		boolean isRemote = Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, modchu_IEntityHelper);
		if (!isRemote) setMasterClassName(modchu_IEntityHelper, c.getName());

		Object entityDataManager = Modchu_AS.get("Entity", version > 189 ? "getDataManager" : "getDataWatcher", modchu_IEntityHelper);
		int entityDataManagerEntriesCount = Modchu_AS.getInt(entityDataManager.getClass(), "getEntityDataManagerEntriesCount", entityDataManager);
		if (debug) Modchu_Debug.mDebug("Modchu_EntityHelper init entityDataManagerEntriesCount="+entityDataManagerEntriesCount);
		if (entityDataManagerEntriesCount < 3) {
			String ss = "Modchu_EntityHelper init entityDataManagerEntriesCount error !! i=";
			Modchu_Main.setRuntimeException(ss);
			return null;
		}

		Modchu_AS.set(instance.getClass(), "entityInit", instance);
		if (instance instanceof Modchu_IEntityLivingBaseMaster) ((Modchu_IEntityLivingBaseMaster) instance).applyEntityAttributes();
		Object tempNBTTagCompound = getData(modchu_IEntityHelper, "tempNBTTagCompound");
		if (tempNBTTagCompound != null) {
			Modchu_AS.set(instance.getClass(), "readEntityFromNBT", new Class[]{ Object.class }, instance, new Object[]{ tempNBTTagCompound });
			setData(modchu_IEntityHelper, "tempNBTTagCompound", null);
		}
		if (debug) {
			int maxSpwanCount = Modchu_CastHelper.Int(getData(modchu_IEntityHelper, "maxSpwanCount"));
			int spwanCount = Modchu_CastHelper.Int(getData(modchu_IEntityHelper, "spwanCount"));
			if (maxSpwanCount > -1
				&& Modchu_CastHelper.Int(getData(modchu_IEntityHelper, "spwanCount")) > maxSpwanCount) {
				Modchu_Debug.mDebug("Modchu_EntityHelper init spwanCount > maxSpwanCount setDead !!");
				Modchu_AS.set(Modchu_AS.entitySetDead, modchu_IEntityHelper);
			}
			Modchu_Debug.mDebug("Modchu_EntityHelper init spwanCount="+spwanCount);
			setData(modchu_IEntityHelper, "spwanCount", spwanCount++);
			Modchu_Debug.mDebug("Modchu_EntityHelper init end.");
		}
		return instance;
	}

	public void initDataWatcherWatchableObject(Modchu_IEntityHelper modchu_IEntityHelper) {
		boolean debug = false;
		boolean isRemote = Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, modchu_IEntityHelper);
		if (debug) Modchu_Debug.mDebug("Modchu_EntityHelper initDataWatcherWatchableObject isRemote="+isRemote);
		//int version = Modchu_Main.getMinecraftVersion();
		//modchu_IEntityHelper.setDataWatcherWatchableObjectIdFirst(version > 194 ? 15 : version > 189 ? 14 : 18);
		int i = modchu_IEntityHelper.getDataWatcherWatchableObjectIdFirst();
		modchu_IEntityHelper.entityDataManagerRegister(new Class[]{ String.class }, i, "");
		i++;
		modchu_IEntityHelper.entityDataManagerRegister(new Class[]{ Integer.class }, i, 0);
		i++;
		modchu_IEntityHelper.entityDataManagerRegister(new Class[]{ Integer.class }, i, -1);
		setData(modchu_IEntityHelper, "ridingEntityID", i);
		if (debug) Modchu_Debug.mDebug("Modchu_EntityHelper initDataWatcherWatchableObject ridingEntityID="+i);
		settingTempDataWatcherWatchableObject(modchu_IEntityHelper);
		prepare(modchu_IEntityHelper);
		if (debug) Modchu_Debug.mDebug("Modchu_EntityHelper initDataWatcherWatchableObject end.");
	}

	protected void prepare(Modchu_IEntityHelper modchu_IEntityHelper) {
		int version = Modchu_Main.getMinecraftVersion();
		if (version > 159) return;
		Object worldObj = Modchu_AS.get(Modchu_AS.entityWorldObj, modchu_IEntityHelper);
		int worldEventLoadCount = Modchu_Main.worldEventLoadCountMap.containsKey(worldObj) ? Modchu_Main.worldEventLoadCountMap.get(worldObj) : 0;
		if (!Modchu_CastHelper.Boolean(getData(modchu_IEntityHelper, "prepareFlag"))) {
			//if (worldEventLoadCount < 2) {
				//prepareFlag = true;
				//modchu_IEntityHelper.preparePlayerToSpawn();
			//} else {
/*
				if (debug) {
					Modchu_Debug.mDebug("Modchu_EntityTameable onUpdate Modchu_EntityTameable_debugPrepareFlag worldObj.isRemote="+worldObj.isRemote);
					Modchu_Debug.lDebug("Modchu_EntityTameable onUpdate Modchu_EntityTameable_debugPrepareFlag posX="+(int) posX+" posY="+(int) posY+" posZ="+(int) posZ);
					if (!Modchu_CastHelper.Boolean(Modchu_Debug.getFreeVariable("Modchu_EntityTameable_debugPrepareFlag"+worldObj.isRemote))) {
						for (int i = 0; i < 5; i++) {
							Modchu_Debug.lDebug("Modchu_EntityTameable onUpdate Modchu_EntityTameable_debugPrepareFlag i="+i+" isBlockNormalCube="+worldObj.isBlockNormalCube((int) posX, ((int) posY) + i - 2, (int) posZ));
							Modchu_Debug.lDebug("Modchu_EntityTameable onUpdate Modchu_EntityTameable_debugPrepareFlag i="+i+" isBlockOpaqueCube="+worldObj.isBlockOpaqueCube((int) posX, ((int) posY) + i - 2, (int) posZ));
						}
						Modchu_Debug.setFreeVariable("Modchu_EntityTameable_debugPrepareFlag"+worldObj.isRemote, true);
					}
				}
*/
			int prepareCount = Modchu_CastHelper.Int(getData(modchu_IEntityHelper, "prepareCount"));
			if (prepareCount < 19) {
				double posX = Modchu_AS.getDouble(Modchu_AS.entityPosX, modchu_IEntityHelper);
				double posY = Modchu_AS.getDouble(Modchu_AS.entityPosY, modchu_IEntityHelper);
				double posZ = Modchu_AS.getDouble(Modchu_AS.entityPosZ, modchu_IEntityHelper);
				if (Modchu_AS.getBoolean("World", "isBlockNormalCube", new Class[]{ int.class, int.class, int.class }, worldObj, new Object[]{ (int) posX, ((int) posY) - 1, (int) posZ })) {
					Modchu_AS.set(Modchu_AS.entitySetPosition, modchu_IEntityHelper, posX, posY + 0.1D, posZ);
				} else if (Modchu_AS.getBoolean("World", "isBlockNormalCube", new Class[]{ int.class, int.class, int.class }, worldObj, new Object[]{ (int) posX, ((int) posY) + 1, (int) posZ })
							| Modchu_AS.getBoolean("World", "isBlockNormalCube", new Class[]{ int.class, int.class, int.class }, worldObj, new Object[]{ (int) posX, ((int) posY), (int) posZ })) {
					Modchu_AS.set(Modchu_AS.entitySetPosition, modchu_IEntityHelper, posX, posY + -0.1D, posZ);
				}
			} else {
				setData(modchu_IEntityHelper, "prepareFlag", true);
			}
			setData(modchu_IEntityHelper, "prepareCount", prepareCount++);
			//}
		}
	}

	public void entityInit(Modchu_IEntityHelper modchu_IEntityHelper) {
		boolean debug = false;
		boolean isRemote = Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, modchu_IEntityHelper);
		if (debug) Modchu_Debug.mDebug("Modchu_EntityHelper entityInit isRemote="+isRemote);
		int version = Modchu_Main.getMinecraftVersion();
		Object dataManager = Modchu_AS.get("Entity", version > 190
				| (version == 190
				&& Modchu_Main.isRelease()) ? "dataManager" : "dataWatcher", modchu_IEntityHelper);
		Object entityDataManager = version > 189 ? Modchu_Main.newModchuCharacteristicObject("Modchu_EntityDataManager", Modchu_EntityDataManagerMaster2.class, modchu_IEntityHelper, dataManager) :
					Modchu_Main.newModchuCharacteristicObject("Modchu_DataWatcher", Modchu_DataWatcherMaster2.class, modchu_IEntityHelper, dataManager);
		if (debug) Modchu_Debug.mDebug("Modchu_EntityHelper entityInit entityDataManager="+entityDataManager);
		boolean b = Modchu_AS.set("Entity", version > 190
				| (version == 190
				&& Modchu_Main.isRelease()) ? "dataManager" : "dataWatcher", modchu_IEntityHelper, entityDataManager);
		if (debug) Modchu_Debug.mDebug("Modchu_EntityHelper entityInit b="+b);
		if (modchu_IEntityHelper instanceof Modchu_IEntity) {
			((Modchu_IEntity) modchu_IEntityHelper).superEntityInit();
		} else if (modchu_IEntityHelper instanceof Modchu_IEntityPlayer) {
			((Modchu_IEntityPlayer) modchu_IEntityHelper).superentityInit();
		} else if (modchu_IEntityHelper instanceof Modchu_IEntityPlayerSP) {
			((Modchu_IEntityPlayerSP) modchu_IEntityHelper).superentityInit();
		}
		initDataWatcherWatchableObject(modchu_IEntityHelper);
		int entityDataManagerEntriesCount = Modchu_AS.getInt(entityDataManager.getClass(), "getEntityDataManagerEntriesCount", entityDataManager);
		if (debug) Modchu_Debug.mDebug("Modchu_EntityHelper entityInit entityDataManagerEntriesCount="+entityDataManagerEntriesCount);
		if (entityDataManagerEntriesCount < 3) {
			String ss = "Modchu_EntityHelper entityInit entityDataManagerEntriesCount error !! i=";
			Modchu_Main.setRuntimeException(ss);
			return;
		}
		//if (debug) Modchu_Debug.mDebug("Modchu_EntityHelper entityInit modchu_IEntityHelper.getDataWatcherWatchableObjectIdFirst()="+modchu_IEntityHelper.getDataWatcherWatchableObjectIdFirst());
	}

	public String getMasterClassName(Modchu_IEntityHelper modchu_IEntityHelper) {
		String s = Modchu_CastHelper.String(modchu_IEntityHelper.getDataWatcherWatchableObject(modchu_IEntityHelper.getDataWatcherWatchableObjectIdFirst()));
		//Modchu_Debug.mDebug("Modchu_EntityHelper getMasterClassName s="+s);
		if (s != null
				&& s.equalsIgnoreCase("0")) {
			//String ss = "Modchu_EntityHelper getMasterClassName 0 error !!";
			//Modchu_Main.setRuntimeException(ss);
			return null;
		}
		return s;
	}

	public void setMasterClassName(Modchu_IEntityHelper modchu_IEntityHelper, String s) {
		Modchu_Debug.mDebug("Modchu_EntityHelper setMasterClassName s="+s);
		modchu_IEntityHelper.setDataWatcherWatchableObject(modchu_IEntityHelper.getDataWatcherWatchableObjectIdFirst(), s);
	}

	public Class getMasterClass(Modchu_IEntityHelper modchu_IEntityHelper) {
		String s = getMasterClassName(modchu_IEntityHelper);
		Modchu_Debug.mDebug("Modchu_EntityHelper getMasterClass() s="+s);
		return s != null
				&& !s.isEmpty() ? Modchu_Reflect.loadClass(s, -1) : null;
	}

	public Object getDataWatcherWatchableObject(Modchu_IEntityHelper modchu_IEntityHelper, int i) {
		boolean debug = false;
		int version = Modchu_Main.getMinecraftVersion();
		Object dataManager = Modchu_AS.get("Entity", version > 190
				| (version == 190
				&& Modchu_Main.isRelease()) ? "dataManager" : "dataWatcher", modchu_IEntityHelper);
		Object o = null;
		Object o2 = null;
		if (version > 189) {
			o = Modchu_AS.get(dataManager.getClass(), "getDataWatcherWatchableObject", new Class[]{ int.class }, dataManager, new Object[]{ i });
			o2 = o;
		} else {
			Object watchedObject = Modchu_AS.get("DataWatcher", "getWatchedObject", new Class[]{ int.class }, dataManager, new Object[]{ i });
			if (watchedObject != null); else return null;
			o = Modchu_AS.get(version > 169 ? "net.minecraft.entity.DataWatcher$WatchableObject" : "WatchableObject", "getObject", watchedObject);
			o2 = o;
			o = getBooleanToByteObject(modchu_IEntityHelper, i, o);
		}
		boolean isRemote = Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, modchu_IEntityHelper);
		boolean initFlag = modchu_IEntityHelper.isInitFlag();
		//if (debug) Modchu_Debug.mDebug("Modchu_EntityHelper getDataWatcherWatchableObject i="+i+" o2="+o2);
		if (debugDataWatcher
				&& initFlag
				&& isRemote) {
			if (debug) {
				Modchu_Debug.mDebug("Modchu_EntityHelper getDataWatcherWatchableObject modchu_IEntityHelper="+modchu_IEntityHelper);
				Modchu_Debug.mDebug("Modchu_EntityHelper getDataWatcherWatchableObject i="+i+" o2="+o2);
			}
			HashMap<Integer, Object> debugDataWatcherMap = getDebugDataWatcherEntityMap(modchu_IEntityHelper);
			if (debugDataWatcherMap != null) {
				Object o3 = debugDataWatcherMap.containsKey(i) ? debugDataWatcherMap.get(i) : null;
				if (debug) {
					Modchu_Debug.mDebug("Modchu_EntityHelper getDataWatcherWatchableObject o3="+o3);
					if (o3 != null) {
						if (!o2.equals(o3)) {
							Modchu_Debug.mDebug("Modchu_EntityHelper getDataWatcherWatchableObject !o2.equals(o3) error !! i="+i+" o2="+o2+" o3="+o3);
						}
					}
				}
			} else {
				if (debug) Modchu_Debug.mDebug("Modchu_EntityHelper getDataWatcherWatchableObject debugDataWatcherMap == null !! i="+i+" o2="+o2);
			}
		}
		return o;
	}

	private Object getBooleanToByteObject(Object modchu_IEntityHelper, int i, Object o) {
		boolean debug = false;
		Object master = Modchu_Main.getModchuCharacteristicObjectMaster(modchu_IEntityHelper, false);
		if (master != null) {
			String s = "entityDataManagerBooleanToByteList";
			List entityDataManagerBooleanToByteList = Modchu_CastHelper.List(getData(master, s, true));
			if (entityDataManagerBooleanToByteList != null) {
				if (entityDataManagerBooleanToByteList.contains(i)) {
					if (o instanceof Byte) {
						if (debug) Modchu_Debug.mDebug("Modchu_EntityHelper getBooleanToByteObject entityDataManagerBooleanToByteList.contains i="+i+" o="+o);
						o = o != null
								&& (Byte) o == (byte) 1 ? true : false;
					} else {
						String ss = "Modchu_EntityHelper getBooleanToByteObject !(o instanceof Byte) error !! i="+i+" o="+o;
						Modchu_Debug.lDebug(ss);
						Modchu_Main.setRuntimeException(ss);
					}
				} else {
					if (debug) Modchu_Debug.mDebug("Modchu_EntityHelper getBooleanToByteObject !entityDataManagerBooleanToByteList.contains i="+i+" o="+o);
				}
			}
		} else {
			String ss = "Modchu_EntityHelper getBooleanToByteObject master == null. modchu_IEntityHelper="+modchu_IEntityHelper+" o="+o;
			Modchu_Debug.mDebug(ss);
		}
		return o;
	}

	private HashMap<Integer, Object> getDebugDataWatcherEntityMap(Modchu_IEntityHelper modchu_IEntityHelper) {
		Object master = Modchu_Main.getModchuCharacteristicObjectMaster(modchu_IEntityHelper, false);
		if (master != null); else return null;
		String s = "debugDataWatcherMap";
		Object o = getData(master, s, true);
		HashMap<Integer, HashMap> debugDataWatcherMap = o != null ? (HashMap<Integer, HashMap>) o : null;
		if (o != null); else {
			debugDataWatcherMap = new HashMap();
			setData(master, s, debugDataWatcherMap, true);
		}
		int entityID = Modchu_AS.getInt(Modchu_AS.entityEntityID, modchu_IEntityHelper);
		HashMap<Integer, Object> debugDataWatcherEntityMap = debugDataWatcherMap.containsKey(entityID) ? debugDataWatcherMap.get(entityID) : null;
		if (debugDataWatcherEntityMap != null); else {
			debugDataWatcherEntityMap = new HashMap();
			debugDataWatcherMap.put(entityID, debugDataWatcherEntityMap);
		}
		return debugDataWatcherEntityMap;
	}

	public void entityDataManagerRegister(Modchu_IEntityHelper modchu_IEntityHelper, Class[] c1, int i, Object o) {
		boolean debug = false;
		int version = Modchu_Main.getMinecraftVersion();
		Object dataManager = Modchu_AS.get("Entity", version > 190
				| (version == 190
				&& Modchu_Main.isRelease()) ? "dataManager" : "dataWatcher", modchu_IEntityHelper);
		if (version > 189) {
			((Modchu_IEntityDataManager) dataManager).entityDataManagerRegister(c1, i, o);
		} else {
			boolean isRemote = Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, modchu_IEntityHelper);
			if (debug) {
				Modchu_Debug.mDebug("Modchu_EntityHelper entityDataManagerRegister 1 isRemote="+isRemote);
				Modchu_Debug.mDebug("Modchu_EntityHelper entityDataManagerRegister 2 i="+i+" o="+o);
			}
			if (o instanceof Boolean) {
				o = (Boolean) o ? (byte) 1 : (byte) 0;
				Object master = Modchu_Main.getModchuCharacteristicObjectMaster(modchu_IEntityHelper, false);
				if (master != null) {
					String s = "entityDataManagerBooleanToByteList";
					if (getData(master, s, true) != null);
					else setData(master, s, new ArrayList(), true);
					Modchu_CastHelper.List(getData(master, s, true)).add(i);
					if (debug) Modchu_Debug.mDebug("Modchu_EntityHelper entityDataManagerRegister o instanceof Boolean entityDataManagerBooleanToByteList.add i="+i+" o="+o);
				} else {
					String ss = "Modchu_EntityHelper entityDataManagerRegister o instanceof Boolean master == null error !! i="+i+" o="+o;
					Modchu_Main.setRuntimeException(ss);
				}
			}
			Modchu_AS.set("DataWatcher", "addObject", new Class[]{ int.class, Object.class }, dataManager, new Object[]{ i, o });
		}
	}

	public void setDataWatcherWatchableObject(Modchu_IEntityHelper modchu_IEntityHelper, int i, Object o) {
		boolean debug = false;
		boolean isRemote = Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, modchu_IEntityHelper);
		if (isRemote) return;
		int version = Modchu_Main.getMinecraftVersion();
		Object dataManager = Modchu_AS.get("Entity", version > 190
				| (version == 190
				&& Modchu_Main.isRelease()) ? "dataManager" : "dataWatcher", modchu_IEntityHelper);
		if (version < 190) {
			if (o instanceof Boolean) {
				o = o != null
						&& (Boolean) o ? (byte) 1 : (byte) 0;
			}
		}
		if (modchu_IEntityHelper.isInitFlag()) {
			if (version > 189) {
				((Modchu_IEntityDataManager) dataManager).setDataWatcherWatchableObject(i, o);
			} else {
				Modchu_AS.set("DataWatcher", "updateObject", new Class[]{ int.class, Object.class }, dataManager, new Object[]{ i, o });
				if (debug) Modchu_Debug.mDebug("Modchu_EntityHelper setDataWatcherWatchableObject updateObject i="+i+" o="+o);
			}
		} else {
			Object o1 = getData(modchu_IEntityHelper, "tempDataWatcherWatchableMap", true);
			HashMap<Object, HashMap> map = o1 != null ? (HashMap<Object, HashMap>) o1 : null;
			if (o1 != null); else {
				map = new HashMap();
				setData(modchu_IEntityHelper, "tempDataWatcherWatchableMap", map, true);
			}
			HashMap<Integer, Object> map1 = map.containsKey(modchu_IEntityHelper) ? map.get(modchu_IEntityHelper) : new HashMap();
			map1.put(i, o);
			map.put(modchu_IEntityHelper, map1);
		}
		if (debugDataWatcher) {
			if (!isRemote) {
				Object master = Modchu_Main.getModchuCharacteristicObjectMaster(modchu_IEntityHelper, false);
				//Modchu_Debug.mDebug("Modchu_EntityHelper setDataWatcherWatchableObject master="+master);
				if (master != null) {
					//if (debug) Modchu_Debug.mDebug("Modchu_EntityHelper setDataWatcherWatchableObject master.getClass()="+master.getClass());
					HashMap<Integer, Object> debugDataWatcherMap = getDebugDataWatcherEntityMap(modchu_IEntityHelper);
					if (debugDataWatcherMap != null) debugDataWatcherMap.put(i, o);
					else {
						String ss = "Modchu_EntityHelper setDataWatcherWatchableObject debugDataWatcherMap == null error !! master="+master;
						Modchu_Debug.lDebug(ss);
						//Modchu_Main.setRuntimeException(ss);
					}
				} else {
					String ss = "Modchu_EntityHelper setDataWatcherWatchableObject master == null error !! 2 modchu_IEntityHelper="+modchu_IEntityHelper;
					Modchu_Debug.lDebug(ss);
					//Modchu_Main.setRuntimeException(ss);
				}
			}
		}
	}

	public void settingTempDataWatcherWatchableObject(Modchu_IEntityHelper modchu_IEntityHelper) {
		Object o1 = getData(modchu_IEntityHelper, "tempDataWatcherWatchableMap", true);
		HashMap<Object, HashMap> map = o1 != null ? (HashMap<Object, HashMap>) o1 : null;
		if (o1 != null); else return;
		HashMap<Integer, Object> map1 = map.containsKey(modchu_IEntityHelper) ? map.get(modchu_IEntityHelper) : null;
		if (map1 != null); else return;
		for (Entry<Integer, Object> en : map1.entrySet()) {
			int i = en.getKey();
			Object o2 = en.getValue();
			setDataWatcherWatchableObject(modchu_IEntityHelper, i, o2);
		}
		map.remove(modchu_IEntityHelper);
	}

	public Object getData(Modchu_IEntityHelper modchu_IEntityHelper, String s) {
		return getData(modchu_IEntityHelper, s, false);
	}

	public Object getData(Object entity, String s, boolean isStatic) {
		int i = isStatic ? 2 : Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, entity) ? 1 : 0;
		boolean debug = false;
		//debug = i == 1 && s.equalsIgnoreCase("dataWatcherWatchableObjectIdCount");
		if (!dataMap.containsKey(i)) return null;
		HashMap<Object, HashMap<String, Object>> map = dataMap.get(i);
		HashMap<String, Object> map1 = null;
		if (isStatic) {
			Class c = entity.getClass();
			if (!map.containsKey(c)) return null;
			map1 = map.get(c);
		} else {
			if (!map.containsKey(entity)) {
				if (debug) Modchu_Debug.mDebug("Modchu_EntityHelper getData !map.containsKey entity="+entity);
				return null;
			}
			map1 = map.get(entity);
		}
		Object o = map1.containsKey(s) ? map1.get(s) : null;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_EntityHelper getData return. s="+s+" o="+o);
			Modchu_Debug.mDebug("Modchu_EntityHelper getData return. entity="+entity);
		}
		return o;
	}

	public void setData(Object entity, String s, Object o) {
		setData(entity, s, o, false);
	}

	public void setData(Object entity, String s, Object o, boolean isStatic) {
		int i = isStatic ? 2 : Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, entity) ? 1 : 0;
		boolean debug = false;
		//debug = i == 1 && s.equalsIgnoreCase("dataWatcherWatchableObjectIdCount");
		if (!dataMap.containsKey(i)) dataMap.put(i, new HashMap());
		HashMap<Object, HashMap<String, Object>> map = dataMap.get(i);
		HashMap<String, Object> map1 = null;
		if (isStatic) {
			Class c = entity.getClass();
			if (!map.containsKey(c)) {
				map1 = new HashMap();
				map.put(c, map1);
			} else {
				map1 = map.get(c);
			}
		} else {
			if (!map.containsKey(entity)) {
				map1 = new HashMap();
				map.put(entity, map1);
			} else {
				map1 = map.get(entity);
			}
		}
		map1.put(s, o);
		if (debug) {
			Modchu_Debug.mDebug("Modchu_EntityHelper setData map1.put s="+s+" o="+o);
			Modchu_Debug.mDebug("Modchu_EntityHelper setData map1.put entity="+entity);
		}
	}

	public void readEntityFromNBT(Modchu_IEntityHelper modchu_IEntityHelper, Object nBTTagCompound) {
		Object master = Modchu_Main.getModchuCharacteristicObjectMaster(modchu_IEntityHelper, false);
		if (master != null) Modchu_AS.set(master.getClass(), "readEntityFromNBT", new Class[]{ Object.class }, master, new Object[]{ nBTTagCompound });
		else {
			Modchu_AS.set(modchu_IEntityHelper.getClass(), "superReadEntityFromNBT", new Class[]{ Object.class }, modchu_IEntityHelper, new Object[]{ nBTTagCompound });
			setData(modchu_IEntityHelper, "tempNBTTagCompound", nBTTagCompound);
		}
	}

	public boolean attackEntityFrom(Modchu_IEntityHelper modchu_IEntityHelper, Object damageSource, float f) {
		boolean isRemote = Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, modchu_IEntityHelper);
		int ticksExisted = Modchu_AS.getInt(Modchu_AS.entityTicksExisted, modchu_IEntityHelper);
		if (!isRemote
				| ticksExisted < 300) return false;
		return Modchu_AS.getBoolean(modchu_IEntityHelper.getClass(), "superAttackEntityFrom", new Class[]{ Object.class, Object.class }, modchu_IEntityHelper, new Object[]{ damageSource, f });
	}

	public boolean isRiding(Modchu_IEntityHelper modchu_IEntityHelper) {
		int tempIsRiding = getTempIsRiding(modchu_IEntityHelper);
		//Modchu_Debug.mdDebug("isRiding tempIsRiding="+tempIsRiding);
		boolean b = isRiding2(modchu_IEntityHelper)
				&& tempIsRiding > 0;
		if (tempIsRiding > 0) {
			tempIsRiding--;
			setTempIsRiding(modchu_IEntityHelper, tempIsRiding);
		}
		return b;
	}

	public void onLivingUpdate(Modchu_IEntityHelper modchu_IEntityHelper) {
		int i = Modchu_AS.getInt(modchu_IEntityHelper.getClass(), "getDamageInvincibleCount", modchu_IEntityHelper);
		if (i > 0) {
			i--;
			Modchu_AS.set(modchu_IEntityHelper.getClass(), "setDamageInvincibleCount", new Class[]{ int.class }, modchu_IEntityHelper, new Object[]{ i });
			//Modchu_Debug.mdDebug("onLivingUpdate damageInvincibleCount i="+i, 1);
		}
		if (modchu_IEntityHelper instanceof Modchu_IEntityLivingBase) ((Modchu_IEntityLivingBase) modchu_IEntityHelper).superOnLivingUpdate();
		else if (modchu_IEntityHelper instanceof Modchu_IEntityPlayer) ((Modchu_IEntityPlayer) modchu_IEntityHelper).superonLivingUpdate();
		else if (modchu_IEntityHelper instanceof Modchu_IEntityPlayerSP) ((Modchu_IEntityPlayerSP) modchu_IEntityHelper).superonLivingUpdate();
	}

	public void onUpdate(Modchu_IEntityHelper modchu_IEntityHelper) {
		boolean debug = false;
		boolean debugDead = Modchu_AS.getBoolean(modchu_IEntityHelper.getClass(), "debugDead", modchu_IEntityHelper);
		if (debug) Modchu_Debug.mDebug("Modchu_EntityHelper onUpdate");
		if (debugDead) Modchu_AS.set(Modchu_AS.entitySetDead, modchu_IEntityHelper);
		checkUUID(modchu_IEntityHelper);
		if (debug) {
			boolean isRemote = Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, modchu_IEntityHelper);
			if (isRemote) {
				// TODO debug用
				int i1 = Modchu_CastHelper.Int(Modchu_Debug.getFreeVariable("Modchu_EntityHelper_debugCount"));
				i1++;
				//Modchu_Debug.mDebug("Modchu_EntityHelper onUpdate i1="+i1);
				Modchu_Debug.setFreeVariable("Modchu_EntityHelper_debugCount", i1);
			}
		}
		if (modchu_IEntityHelper instanceof Modchu_IEntity) ((Modchu_IEntity) modchu_IEntityHelper).superOnUpdate();
		else if (modchu_IEntityHelper instanceof Modchu_IEntityPlayer) ((Modchu_IEntityPlayer) modchu_IEntityHelper).superonUpdate();
		else if (modchu_IEntityHelper instanceof Modchu_IEntityPlayerSP) ((Modchu_IEntityPlayerSP) modchu_IEntityHelper).superonUpdate();
		//Modchu_Debug.mDebug("Modchu_EntityHelper onUpdate end. modchu_IEntityHelper="+modchu_IEntityHelper);
	}

	protected void checkUUID(Modchu_IEntityHelper modchu_IEntityHelper) {
		UUID entityUniqueID = Modchu_AS.getUUID(Modchu_AS.entityGetUniqueID, modchu_IEntityHelper);
		if (entityUniqueID != null); else return;
		int checkUUIDCount = getCheckUUIDCount(modchu_IEntityHelper);
		if (checkUUIDCount < 1) return;
		if (checkUUIDCount > 0) {
			checkUUIDCount--;
			setCheckUUIDCount(modchu_IEntityHelper, checkUUIDCount);
			return;
		}
		Object worldObj = Modchu_AS.get(Modchu_AS.entityWorldObj, modchu_IEntityHelper);
		List loadedEntityList = Modchu_AS.getList(Modchu_AS.worldLoadedEntityList, worldObj);
		boolean flag = false;
		if (loadedEntityList != null
				&& !loadedEntityList.isEmpty())
		for (Object entity : loadedEntityList) {
			if (entity instanceof Modchu_IEntityTameable) {
				UUID uuid = Modchu_AS.getUUID(Modchu_AS.entityGetUniqueID, entity);
				if (entityUniqueID.equals(uuid)) {
					if (flag) {
						Modchu_Debug.mDebug("Modchu_EntityHelper checkUUID isDead modchu_IEntityHelper="+modchu_IEntityHelper);
						Modchu_Debug.mDebug("Modchu_EntityHelper checkUUID isDead entityUniqueID="+entityUniqueID);
						Modchu_AS.set(Modchu_AS.entityLivingBaseSetHealth, modchu_IEntityHelper, 0.0F);
						Modchu_AS.set(Modchu_AS.entityLivingBaseDeathTime, modchu_IEntityHelper, 20);
						Modchu_AS.set(Modchu_AS.entitySetDead, modchu_IEntityHelper);
						return;
					} else {
						flag = true;
					}
				}
			}
		}
		checkUUIDCount = -1;
	}

	private int getCheckUUIDCount(Modchu_IEntityHelper modchu_IEntityHelper) {
		return Modchu_CastHelper.Int(Modchu_EntityHelper.getInstance().getData(modchu_IEntityHelper, "checkUUIDCount"), 0);
	}

	private void setCheckUUIDCount(Modchu_IEntityHelper modchu_IEntityHelper, int i) {
		Modchu_EntityHelper.getInstance().setData(modchu_IEntityHelper, "checkUUIDCount", i);
	}

	public boolean isDamageInvincible(Modchu_IEntityHelper modchu_IEntityHelper) {
		return Modchu_AS.getInt(modchu_IEntityHelper.getClass(), "getDamageInvincibleCount", modchu_IEntityHelper) > 0;
	}

	public boolean startRiding(Modchu_IEntityHelper modchu_IEntityHelper, Object entity, boolean force) {
		int version = Modchu_Main.getMinecraftVersion();
		//Modchu_Debug.mDebug("Modchu_EntityHelper superStartRiding entity="+entity);
		if (version < 190) return Modchu_AS.getBoolean(modchu_IEntityHelper.getClass(), "superStartRiding", new Class[]{ Object.class, boolean.class }, modchu_IEntityHelper, new Object[]{ entity, force });
/*
		if (ridingEntity2 != null) {
			ridingEntity2.dismountRidingEntity();
		}
*/
		// TODO Riding2
		setTempIsRiding(modchu_IEntityHelper, entity != null ? Integer.MAX_VALUE : 0);
/*
		if (entity != null) {
			Object master = Modchu_Main.getModchuCharacteristicObjectMaster(modchu_IEntityHelper);
			Modchu_AS.set(master.getClass(), "setRidingEntityID", new Class[]{ int.class }, master, new Object[]{ Modchu_AS.getInt(Modchu_AS.entityEntityID, entity) });
			Modchu_AS.set("Entity", "addPassenger", new Class[]{ Modchu_Reflect.loadClass("Entity") }, entity, new Object[]{ modchu_IEntityHelper });
			setTempIsRiding(modchu_IEntityHelper, Integer.MAX_VALUE);
		} else {
*/
			Modchu_AS.set(modchu_IEntityHelper.getClass(), "superStartRiding", new Class[] { Object.class, boolean.class }, modchu_IEntityHelper, new Object[] { null, true });
		//}
		//Modchu_Debug.mDebug("Modchu_EntityHelper superStartRiding entity="+entity);
		//Modchu_Debug.mDebug("Modchu_EntityHelper superStartRiding getRidingEntity2="+getRidingEntityID());
		return true;
	}

	public void dismountRidingEntity2(Modchu_IEntityHelper modchu_IEntityHelper) {
		boolean isRemote = Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, modchu_IEntityHelper);
		if (isRemote) return;
		Object master = Modchu_Main.getModchuCharacteristicObjectMaster(modchu_IEntityHelper);
		Modchu_AS.set(master.getClass(), "setRidingEntityID", new Class[]{ int.class }, master, new Object[]{ -1 });
	}

	public boolean canBeRidden(Modchu_IEntityHelper modchu_IEntityHelper, Object entity) {
		// TODO Riding2
		return false;
		//return modchu_IEntityHelper.superCanBeRidden(entity);
	}

	public Object getRidingEntity2(Modchu_IEntityHelper modchu_IEntityHelper) {
		// TODO Riding2
		boolean debug = false;
		int version = Modchu_Main.getMinecraftVersion();
		if (version < 190) return Modchu_AS.get(modchu_IEntityHelper.getClass(), "superGetRidingEntity", modchu_IEntityHelper);
		Object master = Modchu_Main.getModchuCharacteristicObjectMaster(modchu_IEntityHelper);
		int ridingEntity2 = Modchu_AS.getInt(master.getClass(), "getRidingEntityID", master);
		if (debug) {
			boolean isRemote = Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, modchu_IEntityHelper);
			Modchu_Debug.mDebug("Modchu_EntityHelper superGetRidingEntity2 isRemote="+isRemote);
			Modchu_Debug.mDebug("Modchu_EntityHelper superGetRidingEntity2 ridingEntity2="+ridingEntity2);
		}
		if (ridingEntity2 > 0) {
			Object worldObj = Modchu_AS.get(Modchu_AS.entityWorldObj, modchu_IEntityHelper);
			Object entity = Modchu_AS.get("World", "getEntityByID", new Class[]{ int.class }, worldObj, new Object[]{ ridingEntity2 });
			if (debug) Modchu_Debug.mDebug("Modchu_EntityHelper superGetRidingEntity2 entity="+entity);
			return entity;
		}
		if (debug) Modchu_Debug.mDebug("Modchu_EntityHelper superGetRidingEntity2 return null.");
		return null;
	}

	public boolean isRiding2(Modchu_IEntityHelper modchu_IEntityHelper) {
		return Modchu_AS.get(modchu_IEntityHelper.getClass(), "getRidingEntity2", modchu_IEntityHelper) != null;
	}

	public void sendDeathMessage(Modchu_IEntityHelper modchu_IEntityHelper, Object damageSource) {
		//Modchu_Debug.mDebug("Modchu_EntityHelper superSendDeathMessage canSendDeathMessage()="+canSendDeathMessage());
		if (Modchu_AS.getBoolean(modchu_IEntityHelper.getClass(), "canSendDeathMessage", modchu_IEntityHelper)) {
			Object combatTracker = Modchu_AS.get(modchu_IEntityHelper.getClass(), "getCombatTracker2", modchu_IEntityHelper);
			Object iTextComponent = Modchu_AS.get("CombatTracker", "getDeathMessage", combatTracker);
			String s = Modchu_AS.getString("ITextComponent", "getUnformattedText", iTextComponent);
			//Modchu_Debug.mDebug("Modchu_EntityHelper superSendDeathMessage s="+s);
			if (s != null
					&& !s.isEmpty()); else return;
			String s1 = Modchu_AS.getString(modchu_IEntityHelper.getClass(), "getFreeVariable", new Class[]{ String.class }, modchu_IEntityHelper, new Object[]{ "tempSendDeathMessage" });
			if (s1 == null
					| (s1 != null
					&& !s.equalsIgnoreCase(s1))) {
				int version = Modchu_Main.getMinecraftVersion();
				Object owner = Modchu_AS.get(modchu_IEntityHelper.getClass(), "getOwner", modchu_IEntityHelper);
				Modchu_AS.set("EntityPlayerMP", version > 190 ? "sendMessage" : "addChatMessage", owner, iTextComponent);
				Modchu_AS.set(modchu_IEntityHelper.getClass(), "setFreeVariable", new Class[]{ String.class, String.class }, modchu_IEntityHelper, new Object[]{ "tempSendDeathMessage", s });
				//Modchu_Debug.mDebug("Modchu_EntityHelper superSendDeathMessage sendMessage");
			}
		}
	}

	public boolean canSendDeathMessage(Modchu_IEntityHelper modchu_IEntityHelper) {
		Object worldObj = Modchu_AS.get(Modchu_AS.entityWorldObj, modchu_IEntityHelper);
		//Modchu_Debug.mDebug("Modchu_EntityHelper superCanSendDeathMessage hasCustomName()="+hasCustomName());
		//Modchu_Debug.mDebug("Modchu_EntityHelper superCanSendDeathMessage worldObj.getGameRules().getBoolean(\"showDeathMessages\")="+Modchu_AS.getBoolean("GameRules", "getBoolean", new Class[]{ String.class }, Modchu_AS.get("World", "getGameRules", worldObj), new Object[]{ "showDeathMessages" }));
		//Modchu_Debug.mDebug("Modchu_EntityHelper superCanSendDeathMessage getOwner() instanceof EntityPlayerMP="+Modchu_Reflect.loadClass("EntityPlayerMP").isInstance(getOwner()));
		boolean isRemote = Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, modchu_IEntityHelper);
		Object owner = Modchu_AS.get(modchu_IEntityHelper.getClass(), "getOwner", modchu_IEntityHelper);
		return !isRemote
				&& Modchu_AS.getBoolean("GameRules", "getBoolean", new Class[]{ String.class }, Modchu_AS.get("World", "getGameRules", worldObj), new Object[]{ "showDeathMessages" })
				&& Modchu_AS.getBoolean(modchu_IEntityHelper.getClass(), "hasCustomName", modchu_IEntityHelper)
				&& (owner != null
				&& Modchu_Reflect.loadClass("EntityPlayerMP").isInstance(owner));
	}

	public void updateRidden2(Modchu_IEntityHelper modchu_IEntityHelper) {
		boolean debug = false;
		Object entity = Modchu_AS.get(modchu_IEntityHelper.getClass(), "getRidingEntity2", modchu_IEntityHelper);
		boolean isRiding2 = Modchu_AS.getBoolean(modchu_IEntityHelper.getClass(), "isRiding2", modchu_IEntityHelper);
		if (debug) {
			Modchu_Debug.mDebug("Modchu_EntityHelper updateRidden2 entity="+entity);
			Modchu_Debug.mDebug("Modchu_EntityHelper updateRidden2 isRiding2="+isRiding2);
		}
		boolean isRemote = Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, modchu_IEntityHelper);
		if (!isRiding2) return;
		if (Modchu_AS.getBoolean(Modchu_AS.entityIsDead, entity)) {
			Modchu_AS.set(modchu_IEntityHelper.getClass(), "superStartRiding", new Class[] { Object.class, boolean.class }, modchu_IEntityHelper, new Object[] { null, true });
		} else {
/*
			if (debug) {
				double posX = Modchu_AS.getDouble(Modchu_AS.entityPosX, modchu_IEntityHelper);
				double posY = Modchu_AS.getDouble(Modchu_AS.entityPosY, modchu_IEntityHelper);
				double posZ = Modchu_AS.getDouble(Modchu_AS.entityPosZ, modchu_IEntityHelper);
				float rotationYaw = Modchu_AS.getFloat(Modchu_AS.entityRotationYaw, modchu_IEntityHelper);
				float rotationPitch = Modchu_AS.getFloat(Modchu_AS.entityRotationPitch, modchu_IEntityHelper);
				//Modchu_Debug.mDebug("Modchu_EntityHelper updateRidden2 isRiding2");
				//Modchu_Debug.mdDebug("posX="+posX+" posY="+posY+" posZ="+posZ);
				//Modchu_Debug.mdDebug("entityPosX="+entityPosX+" entityPosY="+entityPosY+" entityPosZ="+entityPosZ, 1);
				Modchu_Debug.mdDebug("rotationYaw="+rotationYaw+" rotationPitch="+rotationPitch, isRemote ? 0 : 1);
			}
*/
			double entityPosX = Modchu_AS.getDouble(Modchu_AS.entityPosX, entity);
			double entityPosY = Modchu_AS.getDouble(Modchu_AS.entityPosY, entity);
			double entityPosZ = Modchu_AS.getDouble(Modchu_AS.entityPosZ, entity);
			//float entityRotationYaw = Modchu_AS.getFloat(Modchu_AS.entityRotationYaw, entity);
			//float entityRotationPitch = Modchu_AS.getFloat(Modchu_AS.entityRotationPitch, entity);
			//float rotationPitch = Modchu_AS.getFloat(Modchu_AS.entityRotationPitch, modchu_IEntityHelper);
			float entityRotationYawHead = Modchu_AS.getFloat(Modchu_AS.entityLivingBaseRotationYawHead, entity);

			//if (isRemote) {
				//Modchu_AS.set("Entity", "setPositionAndUpdate", new Class[] { double.class, double.class, double.class }, modchu_IEntityHelper, new Object[]{ entityPosX, entityPosY + Modchu_AS.getDouble("Entity", "getMountedYOffset", entity) + Modchu_AS.getDouble(modchu_IEntityHelper.getClass(), "getYOffset", modchu_IEntityHelper), entityPosZ });
				//Modchu_AS.set("Entity", "setRotation", new Class[] { float.class, float.class }, modchu_IEntityHelper, new Object[]{ entityRotationYaw, rotationPitch });
/*
				Modchu_AS.set("EntityLivingBase", "setPositionAndRotationDirect", new Class[] { double.class, double.class, double.class, float.class, float.class, int.class, boolean.class }, modchu_IEntityHelper, new Object[]{ entityPosX, entityPosY + Modchu_AS.getDouble("Entity", "getMountedYOffset", entity) + Modchu_AS.getDouble(modchu_IEntityHelper.getClass(), "getYOffset", modchu_IEntityHelper), entityPosZ, entityRotationYaw, rotationPitch, 1, true });
*/
			//} else {
			//Modchu_AS.set(Modchu_AS.entitySetPositionAndRotation, modchu_IEntityHelper, entityPosX, entityPosY + Modchu_AS.getDouble("Entity", "getMountedYOffset", entity) + Modchu_AS.getDouble(modchu_IEntityHelper.getClass(), "getYOffset", modchu_IEntityHelper), entityPosZ, entityRotationYaw, rotationPitch);
			Modchu_AS.set(Modchu_AS.entitySetPosition, modchu_IEntityHelper, entityPosX, entityPosY + Modchu_AS.getDouble("Entity", "getMountedYOffset", entity) + Modchu_AS.getDouble(modchu_IEntityHelper.getClass(), "getYOffset", modchu_IEntityHelper), entityPosZ);
			//}
			//Modchu_AS.set(Modchu_AS.entityPrevRotationYaw, modchu_IEntityHelper, entityRotationYaw);
			Modchu_AS.set(Modchu_AS.entityLivingBaseRotationYawHead, modchu_IEntityHelper, entityRotationYawHead);
			if (debug) {
				double posX = Modchu_AS.getDouble(Modchu_AS.entityPosX, modchu_IEntityHelper);
				double posY = Modchu_AS.getDouble(Modchu_AS.entityPosY, modchu_IEntityHelper);
				double posZ = Modchu_AS.getDouble(Modchu_AS.entityPosZ, modchu_IEntityHelper);
				float rotationYaw = Modchu_AS.getFloat(Modchu_AS.entityRotationYaw, modchu_IEntityHelper);
				//Modchu_Debug.mDebug("Modchu_EntityHelper updateRidden2 isRiding2");
				//Modchu_Debug.mdDebug("posX="+posX+" posY="+posY+" posZ="+posZ);
				//Modchu_Debug.mdDebug("entityPosX="+entityPosX+" entityPosY="+entityPosY+" entityPosZ="+entityPosZ, 1);
				//Modchu_Debug.mdDebug("rotationYaw="+rotationYaw+" rotationPitch="+rotationPitch, isRemote ? 2 : 3);
			}
		}
	}

	public int getRidingEntityID(Modchu_IEntityHelper modchu_IEntityHelper) {
		int id = Modchu_CastHelper.Int(getData(modchu_IEntityHelper, "ridingEntityID"));
		int i = Modchu_CastHelper.Int(modchu_IEntityHelper.getDataWatcherWatchableObject(id), -1);
		//Modchu_Debug.mDebug("Modchu_EntityHelper getRidingEntityID id="+id+" i="+i);
		return i;
	}

	public void setRidingEntityID(Modchu_IEntityHelper modchu_IEntityHelper, int i) {
		int id = Modchu_CastHelper.Int(getData(modchu_IEntityHelper, "ridingEntityID"));
		//Modchu_Debug.mDebug("Modchu_EntityHelper setRidingEntityID id="+id+" i="+i);
		modchu_IEntityHelper.setDataWatcherWatchableObject(id, i);
	}

	public int getTempIsRiding(Modchu_IEntityHelper modchu_IEntityHelper) {
		return Modchu_CastHelper.Int(getData(modchu_IEntityHelper, "tempIsRiding"), 0);
	}

	public void setTempIsRiding(Modchu_IEntityHelper modchu_IEntityHelper, int i) {
		setData(modchu_IEntityHelper, "tempIsRiding", i);
	}

	public void unRegisterEntityDeadSetting(Modchu_IEntityHelper modchu_IEntityHelper) {
		int tempDeadTime = Modchu_CastHelper.Int(getData(modchu_IEntityHelper, "Modchu_AllRenderLiving_tempDeadTime"));
		if (tempDeadTime > 600) {
			Modchu_AS.set(Modchu_AS.entitySetDead, modchu_IEntityHelper);
		} else {
			tempDeadTime++;
			setData(modchu_IEntityHelper, "Modchu_AllRenderLiving_tempDeadTime", tempDeadTime);
		}
	}

	public int getEntityDataManagerEntriesCount(Modchu_IEntityHelper modchu_IEntityHelper) {
		int version = Modchu_Main.getMinecraftVersion();
		int dataWatcherWatchableObjectIdCount = 0;
		Object o = Modchu_AS.get(modchu_IEntityHelper.getClass(), version > 189 ? "getDataManager" : "getDataWatcher", modchu_IEntityHelper);
		if (version > 189) {
			Modchu_IEntityDataManager dataWatcher1 = o instanceof Modchu_IEntityDataManager ? (Modchu_IEntityDataManager) o : null;
			if (dataWatcher1 != null); else return -1;
			dataWatcherWatchableObjectIdCount = dataWatcher1.getEntityDataManagerEntriesCount();
		} else {
			Modchu_IDataWatcher dataWatcher1 = o instanceof Modchu_IDataWatcher ? (Modchu_IDataWatcher) o : null;
			if (dataWatcher1 != null); else return -1;
			dataWatcherWatchableObjectIdCount = dataWatcher1.getEntityDataManagerEntriesCount();
		}
		return dataWatcherWatchableObjectIdCount;
	}

}
