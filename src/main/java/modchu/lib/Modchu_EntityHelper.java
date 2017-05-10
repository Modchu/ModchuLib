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

	public Object init(Modchu_IEntity modchu_IEntity, HashMap<String, Object> map) {
		boolean debug = true;
		Object worldObj = Modchu_AS.get(Modchu_AS.entityWorldObj, modchu_IEntity);
		boolean initFlag = modchu_IEntity.isInitFlag();
		int version = Modchu_Main.getMinecraftVersion();
		if (map != null
				&& !map.isEmpty()); else {
			map = (HashMap<String, Object>) getData(modchu_IEntity, "tempInitMap");
		}
		if (map != null
				&& !map.isEmpty()); else {
			boolean isRemote = Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, modchu_IEntity);
			Modchu_Debug.mDebug("Modchu_InitEntityHelper init map == null isRemote="+isRemote);
			String entityName = getMasterClassName(modchu_IEntity);
			Modchu_Debug.mDebug("Modchu_InitEntityHelper init map == null entityName="+entityName);
			int debugCount = Modchu_CastHelper.Int(Modchu_Debug.getFreeVariable("Modchu_EntityTameable_debugCount"));
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
					if (debugCount == 30) {
						Modchu_Debug.mDebug("Modchu_InitEntityHelper init debugCount == 30 entries initFlag="+initFlag);
						Object dataManager = Modchu_AS.get("Entity", version > 190
								| (version == 190
								&& Modchu_Main.isRelease()) ? "dataManager" : "dataWatcher", modchu_IEntity);
						Map<Integer, Object> entries = Modchu_AS.getMap("EntityDataManager", "entries", dataManager);
						for (Entry<Integer, Object> en : entries.entrySet()) {
							Object dataentry1 = en.getValue();
							Object dataParameter1 = Modchu_AS.get("EntityDataManager$DataEntry", "getKey", dataentry1);
							int id1 = Modchu_AS.getInt("DataParameter", "getId", dataParameter1);
							Object o1 = Modchu_AS.get("DataParameter", "getValue", dataentry1);
							Modchu_Debug.mDebug("Modchu_InitEntityHelper init debugCount == 30 entries id1="+id1+" o1="+o1);
						}
						Object master = Modchu_Main.getModchuCharacteristicObjectMaster(dataManager);
						TreeMap<Integer, Object> tempDataEntryMap = (TreeMap<Integer, Object>) Modchu_Reflect.getFieldObject(master.getClass(), "tempDataEntryMap", master);
						if (!tempDataEntryMap.isEmpty()) {
							for (Entry<Integer, Object> en : tempDataEntryMap.entrySet()) {
								Object dataentry1 = en.getValue();
								Object dataParameter1 = Modchu_AS.get("EntityDataManager$DataEntry", "getKey", dataentry1);
								int id2 = Modchu_AS.getInt("DataParameter", "getId", dataParameter1);
								Object o2 = Modchu_AS.get("EntityDataManager$DataEntry", "getValue", dataentry1);
								Modchu_Debug.mDebug("Modchu_InitEntityHelper init debugCount == 30 tempDataEntryMap id2="+id2+" o2="+o2);
							}
						}
						HashMap<Integer, Integer> idMap = (HashMap<Integer, Integer>) Modchu_Reflect.getFieldObject(dataManager.getClass(), "idMap", dataManager);
						if (!idMap.isEmpty()) {
							for (Entry<Integer, Integer> en : idMap.entrySet()) {
								int i = en.getKey();
								int i1 = en.getValue();
								Modchu_Debug.mDebug("Modchu_InitEntityHelper init debugCount == 30 idMap i="+i+" i1="+i1);
							}
						}
						//debugDead = true;
					}
					return null;
				} else {
					double posX = Modchu_AS.getDouble(Modchu_AS.entityPosX, modchu_IEntity);
					double posY = Modchu_AS.getDouble(Modchu_AS.entityPosY, modchu_IEntity);
					double posZ = Modchu_AS.getDouble(Modchu_AS.entityPosZ, modchu_IEntity);
					if (posX != 0
							&& posY != 0
							&& posZ != 0) {
						c = Modchu_Main.getSpownEntityClass(worldObj, posX, posY, posZ);
						if (c != null) {
							if (debug) Modchu_Debug.mDebug("Modchu_InitEntityHelper init SpownEntity c="+c);
						} else {
							int ticksExisted = Modchu_AS.getInt(Modchu_AS.entityTicksExisted, modchu_IEntity);
							if (ticksExisted > 29) Modchu_AS.set("Entity", "setDead", modchu_IEntity);
							return null;
						}
					} else {
						return null;
					}
				}
			}
			if (debug) Modchu_Debug.mDebug("Modchu_InitEntityHelper init worldObj.isRemote initFlag entityName="+entityName);
			//Modchu_Debug.mDebug("Modchu_InitEntityHelper init isRemote="+worldObj.isRemote);
			if (c != null); else c = getMasterClass(modchu_IEntity);
			if (c != null); else {
				if (debug) {
					Modchu_Debug.mDebug("Modchu_InitEntityHelper init c == null debug1 return entityName="+entityName);
					//setDead();
					Modchu_Main.setRuntimeException("init debug");
				}
				return null;
			}
			map = new HashMap();
			map.put("Class", c);
			map.put("Object", worldObj);
		}
		if (map != null
				&& !map.isEmpty()
				&& map.containsKey("Class")); else {
					return null;
		}
		if (!initFlag) {
			if (getData(modchu_IEntity, "tempInitMap") != null); else setData(modchu_IEntity, "tempInitMap", map);
			return null;
		}
		Class c = map.containsKey("Class") ? ((Class) map.get("Class")) : null;
		if (c != null); else return null;
		map.put("base", modchu_IEntity);
		Modchu_IEntityMaster instance = (Modchu_IEntityMaster) Modchu_Main.newModchuCharacteristicInstance(map);
		Modchu_Reflect.setFieldObject(modchu_IEntity.getClass(), "master", modchu_IEntity, instance);
		setMasterClassName(modchu_IEntity, c.getName());
		if (instance != null); else {
			if (debug) Modchu_Debug.mDebug("Modchu_InitEntityHelper init 4 instance == null !!");
			return null;
		}
		instance.entityInit();
		if (instance instanceof Modchu_IEntityLivingBaseMaster) ((Modchu_IEntityLivingBaseMaster) instance).applyEntityAttributes();
		Modchu_Debug.mDebug("initNBTAfter instance="+instance);
		Object tempNBTTagCompound = getData(modchu_IEntity, "tempNBTTagCompound");
		if (tempNBTTagCompound != null) {
			instance.readEntityFromNBT(tempNBTTagCompound);
			setData(modchu_IEntity, "tempNBTTagCompound", null);
		}
		Modchu_AS.get(Modchu_AS.entityLivingOnInitialSpawn, modchu_IEntity, null, null);
		if (debug) {
			int maxSpwanCount = Modchu_CastHelper.Int(getData(modchu_IEntity, "maxSpwanCount"));
			int spwanCount = Modchu_CastHelper.Int(getData(modchu_IEntity, "spwanCount"));
			if (maxSpwanCount > -1
				&& Modchu_CastHelper.Int(getData(modchu_IEntity, "spwanCount")) > maxSpwanCount) {
				Modchu_Debug.mDebug("Modchu_EntityTameable init spwanCount > maxSpwanCount setDead !!");
				Modchu_AS.set("Entity", "setDead", modchu_IEntity);
			}
			setData(modchu_IEntity, "spwanCount", spwanCount++);
		}
		return instance;
	}

	public void initDataWatcherWatchableObject(Modchu_IEntity modchu_IEntity) {
		int version = Modchu_Main.getMinecraftVersion();
		modchu_IEntity.setDataWatcherWatchableObjectIdFirst(version > 194 ? 15 : version > 189 ? 14 : 18);
		int i = modchu_IEntity.getDataWatcherWatchableObjectIdFirst();
		modchu_IEntity.entityDataManagerRegister(new Class[]{ String.class }, i, "");
		i++;
		modchu_IEntity.entityDataManagerRegister(new Class[]{ Integer.class }, i, 0);
		i++;
		modchu_IEntity.setDataWatcherWatchableObjectIdCount(i);
		modchu_IEntity.setInitFlag(true);
		prepare(modchu_IEntity);
	}

	protected void prepare(Modchu_IEntity modchu_IEntity) {
		int version = Modchu_Main.getMinecraftVersion();
		if (version > 159) return;
		Object worldObj = Modchu_AS.get(Modchu_AS.entityWorldObj, modchu_IEntity);
		int worldEventLoadCount = Modchu_Main.worldEventLoadCountMap.containsKey(worldObj) ? Modchu_Main.worldEventLoadCountMap.get(worldObj) : 0;
		if (!Modchu_CastHelper.Boolean(getData(modchu_IEntity, "prepareFlag"))) {
			//if (worldEventLoadCount < 2) {
				//prepareFlag = true;
				//modchu_IEntity.preparePlayerToSpawn();
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
			int prepareCount = Modchu_CastHelper.Int(getData(modchu_IEntity, "prepareCount"));
			if (prepareCount < 19) {
				double posX = Modchu_AS.getDouble(Modchu_AS.entityPosX, modchu_IEntity);
				double posY = Modchu_AS.getDouble(Modchu_AS.entityPosY, modchu_IEntity);
				double posZ = Modchu_AS.getDouble(Modchu_AS.entityPosZ, modchu_IEntity);
				if (Modchu_AS.getBoolean("World", "isBlockNormalCube", new Class[]{ int.class, int.class, int.class }, worldObj, new Object[]{ (int) posX, ((int) posY) - 1, (int) posZ })) {
					Modchu_AS.set(Modchu_AS.entitySetPosition, modchu_IEntity, posX, posY + 0.1D, posZ);
				} else if (Modchu_AS.getBoolean("World", "isBlockNormalCube", new Class[]{ int.class, int.class, int.class }, worldObj, new Object[]{ (int) posX, ((int) posY) + 1, (int) posZ })
							| Modchu_AS.getBoolean("World", "isBlockNormalCube", new Class[]{ int.class, int.class, int.class }, worldObj, new Object[]{ (int) posX, ((int) posY), (int) posZ })) {
					Modchu_AS.set(Modchu_AS.entitySetPosition, modchu_IEntity, posX, posY + -0.1D, posZ);
				}
			} else {
				setData(modchu_IEntity, "prepareFlag", true);
			}
			setData(modchu_IEntity, "prepareCount", prepareCount++);
			//}
		}
	}

	public void entityInit(Modchu_IEntity modchu_IEntity) {
		boolean debug = false;
		boolean isRemote = Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, modchu_IEntity);
		if (debug) Modchu_Debug.mDebug("Modchu_InitEntityHelper entityInit isRemote="+isRemote);
		int version = Modchu_Main.getMinecraftVersion();
		Object dataManager = Modchu_AS.get("Entity", version > 190
				| (version == 190
				&& Modchu_Main.isRelease()) ? "dataManager" : "dataWatcher", modchu_IEntity);
		Object entityDataManager = version > 189 ? Modchu_Main.newModchuCharacteristicObject("Modchu_EntityDataManager", Modchu_EntityDataManagerMaster2.class, modchu_IEntity, dataManager) :
					Modchu_Main.newModchuCharacteristicObject("Modchu_DataWatcher", Modchu_DataWatcherMaster2.class, modchu_IEntity, dataManager);
		if (debug) Modchu_Debug.mDebug("Modchu_InitEntityHelper entityInit entityDataManager="+entityDataManager);
		boolean b = Modchu_AS.set("Entity", version > 190
				| (version == 190
				&& Modchu_Main.isRelease()) ? "dataManager" : "dataWatcher", modchu_IEntity, entityDataManager);
		if (debug) Modchu_Debug.mDebug("Modchu_InitEntityHelper entityInit b="+b);
		modchu_IEntity.superEntityInit();
		initDataWatcherWatchableObject(modchu_IEntity);
		Object master = Modchu_Main.getModchuCharacteristicObjectMaster(modchu_IEntity, false);
		if (master != null
				&& master instanceof Modchu_IEntityMaster) ((Modchu_IEntityMaster) master).entityInit();
	}

	public String getMasterClassName(Modchu_IEntity modchu_IEntity) {
		String s = Modchu_CastHelper.String(modchu_IEntity.getDataWatcherWatchableObject(modchu_IEntity.getDataWatcherWatchableObjectIdFirst()));
		//Modchu_Debug.mDebug("Modchu_InitEntityHelper getMasterClassName s="+s);
		return s;
	}

	public void setMasterClassName(Modchu_IEntity modchu_IEntity, String s) {
		Modchu_Debug.mDebug("Modchu_InitEntityHelper setMasterClassName s="+s);
		modchu_IEntity.setDataWatcherWatchableObject(modchu_IEntity.getDataWatcherWatchableObjectIdFirst(), s);
	}

	public Class getMasterClass(Modchu_IEntity modchu_IEntity) {
		String s = getMasterClassName(modchu_IEntity);
		Modchu_Debug.mDebug("Modchu_InitEntityHelper getMasterClass() s="+s);
		return s != null
				&& !s.isEmpty() ? Modchu_Reflect.loadClass(s, -1) : null;
	}

	public Object getDataWatcherWatchableObject(Modchu_IEntity modchu_IEntity, int i) {
		int version = Modchu_Main.getMinecraftVersion();
		Object dataManager = Modchu_AS.get("Entity", version > 190
				| (version == 190
				&& Modchu_Main.isRelease()) ? "dataManager" : "dataWatcher", modchu_IEntity);
		Object o = null;
		if (version > 189) {
			o = Modchu_AS.get(dataManager.getClass(), "getDataWatcherWatchableObject", new Class[]{ int.class }, dataManager, new Object[]{ i });
			boolean debug = false;
			boolean isRemote = Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, modchu_IEntity);
			boolean initFlag = modchu_IEntity.isInitFlag();
			if (debug
					&& initFlag
					&& isRemote) {
				Object master = Modchu_Main.getModchuCharacteristicObjectMaster(modchu_IEntity);
				Map debugDataWatcherMap = Modchu_AS.getMap(master.getClass(), "debugDataWatcherMap", master);
				if (debugDataWatcherMap != null); else {
					Map<Integer, Object> debugDataWatcherEntityMap = Modchu_AS.getMap(master.getClass(), "debugDataWatcherEntityMap", master);
					Modchu_AS.set(master.getClass(), "debugDataWatcherMap", debugDataWatcherEntityMap.get(Modchu_AS.getInt(Modchu_AS.entityEntityID, modchu_IEntity)));
				}
				if (debugDataWatcherMap != null) {
					Object o1 = debugDataWatcherMap.get(i);
					if (!o.equals(o1)) {
						Modchu_Debug.mDebug("Modchu_InitEntityHelper getDataWatcherWatchableObject !o.equals(o1) error !! i="+i+" o="+o+" o1="+o1);
					}
				}
			}
		} else {
			Object watchedObject = Modchu_AS.get("DataWatcher", "getWatchedObject", new Class[]{ int.class }, dataManager, new Object[]{ i });
			if (watchedObject != null); else return null;
			o = Modchu_AS.get(version > 169 ? "net.minecraft.entity.DataWatcher$WatchableObject" : "WatchableObject", "getObject", watchedObject);
			List entityDataManagerBooleanToByteList = Modchu_CastHelper.List(getData(modchu_IEntity, "entityDataManagerBooleanToByteList", true));
			if (entityDataManagerBooleanToByteList != null
					&& entityDataManagerBooleanToByteList.contains(i)) {
				o = o != null
						&& (Byte) o == (byte) 1 ? true : false;
			}
		}
		return o;
	}

	public void entityDataManagerRegister(Modchu_IEntity modchu_IEntity, Class[] c1, int i, Object o) {
		int version = Modchu_Main.getMinecraftVersion();
		Object dataManager = Modchu_AS.get("Entity", version > 190
				| (version == 190
				&& Modchu_Main.isRelease()) ? "dataManager" : "dataWatcher", modchu_IEntity);
		if (version > 189) {
			((Modchu_IEntityDataManager) dataManager).entityDataManagerRegister(c1, i, o);
		} else {
			if (o instanceof Boolean) {
				o = (Boolean) o ? (byte) 1 : (byte) 0;
				if (getData(modchu_IEntity, "entityDataManagerBooleanToByteList", true) != null); else setData(modchu_IEntity, "entityDataManagerBooleanToByteList", new ArrayList(), true);
				Modchu_CastHelper.List(getData(modchu_IEntity, "entityDataManagerBooleanToByteList", true)).add(i);
			}
			Modchu_AS.set("DataWatcher", "addObject", new Class[]{ int.class, Object.class }, dataManager, new Object[]{ i, o });
		}
	}

	public void setDataWatcherWatchableObject(Modchu_IEntity modchu_IEntity, int i, Object o) {
		int version = Modchu_Main.getMinecraftVersion();
		Object dataManager = Modchu_AS.get("Entity", version > 190
				| (version == 190
				&& Modchu_Main.isRelease()) ? "dataManager" : "dataWatcher", modchu_IEntity);
		if (version > 189) {
			((Modchu_IEntityDataManager) dataManager).setDataWatcherWatchableObject(i, o);
			boolean isRemote = Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, modchu_IEntity);
			if (!isRemote) {
				Object master = Modchu_Main.getModchuCharacteristicObjectMaster(modchu_IEntity, false);
				//Modchu_Debug.mDebug("Modchu_EntityHelper setDataWatcherWatchableObject master="+master);
				if (master != null) {
					//Modchu_Debug.mDebug("Modchu_EntityHelper setDataWatcherWatchableObject master.getClass()="+master.getClass());
					Map debugDataWatcherMap = Modchu_AS.getMap(master.getClass(), "debugDataWatcherMap", master);
					if (debugDataWatcherMap != null) debugDataWatcherMap.put(i, o);
					else {
						String ss = "Modchu_EntityHelper setDataWatcherWatchableObject debugDataWatcherMap == null error !! master="+master;
						Modchu_Debug.lDebug(ss);
						Modchu_Main.setRuntimeException(ss);
					}
				} else {
					String ss = "Modchu_EntityHelper setDataWatcherWatchableObject master == null error !! modchu_IEntity="+modchu_IEntity;
					Modchu_Debug.lDebug(ss);
					Modchu_Main.setRuntimeException(ss);
				}
			}
		} else {
			List entityDataManagerBooleanToByteList = Modchu_CastHelper.List(getData(modchu_IEntity, "entityDataManagerBooleanToByteList", true));
			if (entityDataManagerBooleanToByteList != null
					&& entityDataManagerBooleanToByteList.contains(i)) {
				o = o != null
						&& (Boolean) o ? (byte) 1 : (byte) 0;
			}
			Modchu_AS.set("DataWatcher", "updateObject", new Class[]{ int.class, Object.class }, dataManager, new Object[]{ i, o });
		}
	}

	public Object getData(Modchu_IEntity modchu_IEntity, String s) {
		return getData(modchu_IEntity, s, false);
	}

	public Object getData(Modchu_IEntity modchu_IEntity, String s, boolean isStatic) {
		int i = isStatic ? 2 : Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, modchu_IEntity) ? 1 : 0;
		if (!dataMap.containsKey(i)) return null;
		HashMap<Object, HashMap<String, Object>> map = dataMap.get(i);
		Object o = null;
		HashMap<String, Object> map1 = null;
		if (isStatic) {
			Class c = modchu_IEntity.getClass();
			if (!map.containsKey(c)) return null;
			map1 = map.get(c);
		} else {
			if (!map.containsKey(modchu_IEntity)) return null;
			map1 = map.get(modchu_IEntity);
		}
		if (!map1.containsKey(s)) return null;
		o = map1.containsKey(s) ? map1.get(s) : null;
		return o;
	}

	public void setData(Modchu_IEntity modchu_IEntity, String s, Object o) {
		setData(modchu_IEntity, s, o, false);
	}

	public void setData(Modchu_IEntity modchu_IEntity, String s, Object o, boolean isStatic) {
		int i1 = isStatic ? 2 : Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, modchu_IEntity) ? 1 : 0;
		if (!dataMap.containsKey(i1)) dataMap.put(i1, new HashMap());
		HashMap<Object, HashMap<String, Object>> map = dataMap.get(i1);
		HashMap<String, Object> map1 = null;
		if (isStatic) {
			Class c = modchu_IEntity.getClass();
			if (!map.containsKey(c)) {
				map1 = new HashMap();
				map.put(c, map1);
			} else {
				map1 = map.get(c);
			}
		} else {
			if (!map.containsKey(modchu_IEntity)) {
				map1 = new HashMap();
				map.put(modchu_IEntity, map1);
			} else {
				map1 = map.get(modchu_IEntity);
			}
		}
		map1.put(s, o);
	}

	public void readEntityFromNBT(Modchu_IEntity modchu_IEntity, Object nBTTagCompound) {
		Modchu_IEntityMaster master = (Modchu_IEntityMaster) Modchu_Main.getModchuCharacteristicObjectMaster(modchu_IEntity, false);
		if (master != null) master.readEntityFromNBT(nBTTagCompound);
		else {
			modchu_IEntity.superReadEntityFromNBT(nBTTagCompound);
			setData(modchu_IEntity, "tempNBTTagCompound", nBTTagCompound);
		}
	}

}
