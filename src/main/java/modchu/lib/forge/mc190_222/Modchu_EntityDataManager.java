package modchu.lib.forge.mc190_222;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.lang3.ObjectUtils;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntity;
import modchu.lib.Modchu_IEntityDataManager;
import modchu.lib.Modchu_IEntityDataManagerMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.IntIdentityHashBiMap;
import net.minecraft.world.World;

public class Modchu_EntityDataManager extends EntityDataManager implements Modchu_IEntityDataManager {
	public Modchu_IEntityDataManagerMaster master;
	protected Entity baseEntity;
	private static HashMap<Class, HashMap> entityDataParameterMap;
	private HashMap<Integer, Object> dataParameterMap;
	private HashMap<Integer, Integer> idMap;

	public Modchu_EntityDataManager(HashMap<String, Object> map) {
		super((Entity) map.get("Object"));
		baseEntity = (Entity) map.get("Object");
		map.put("base", this);
		if (entityDataParameterMap != null); else entityDataParameterMap = new HashMap();
		if (entityDataParameterMap.containsKey(baseEntity.getClass())) {
			dataParameterMap = entityDataParameterMap.get(baseEntity.getClass());
			Modchu_Debug.mDebug("Modchu_EntityDataManager init 0");
		} else {
			dataParameterMap = new HashMap();
			if (baseEntity instanceof Modchu_IEntity) {
				((Modchu_IEntity) baseEntity).dataParameterMapSetting(dataParameterMap);
			}
			entityDataParameterMap.put(baseEntity.getClass(), dataParameterMap);
		}
		idMap = new HashMap();
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		master = instance instanceof Modchu_IEntityDataManagerMaster ? (Modchu_IEntityDataManagerMaster) instance : null;
		//Modchu_Debug.mDebug("Modchu_EntityDataManager init master="+master);
	}

	@Override
	public void entityDataManagerRegister(Class[] c1, int i, Object o) {
		boolean debug = false;
		if (debug) Modchu_Debug.mDebug("Modchu_EntityDataManager entityDataManagerRegister 1 c1="+c1+" i="+i+" o="+o);
		DataParameter dataParameter = dataParameterMap.containsKey(i) ? (DataParameter) dataParameterMap.get(i) : null;
		if (dataParameter != null); else dataParameter = (DataParameter) Modchu_AS.get(Modchu_AS.newDataParameter, baseEntity.getClass(), c1, i);
		if (debug) Modchu_Debug.mDebug("Modchu_EntityDataManager entityDataManagerRegister 2 dataParameter="+dataParameter);
		if (dataParameter != null) {
			if (debug) Modchu_Debug.mDebug("Modchu_EntityDataManager entityDataManagerRegister 3 baseEntity="+baseEntity);
			register(dataParameter, o, i);
			if (debug) {
				Modchu_Debug.mDebug("Modchu_EntityDataManager entityDataManagerRegister 4 dataParameterMap="+dataParameterMap);
				DataParameter dataParameter1 = (DataParameter) getDataParameterMap(i);
				Modchu_Debug.mDebug("Modchu_EntityDataManager entityDataManagerRegister 5 register ok. dataParameter1="+dataParameter1);
				int id = dataParameter1 != null ? dataParameter1.getId() : -1;
				Modchu_Debug.mDebug("Modchu_EntityDataManager entityDataManagerRegister 6 register ok. id="+id);
				EntityDataManager.DataEntry dataentry = dataParameter1 != null ? getEntry(dataParameter1) : null;
				Modchu_Debug.mDebug("Modchu_EntityDataManager entityDataManagerRegister 7 register ok. dataentry="+dataentry);
				Object o1 = dataentry != null ? dataentry.getValue() : null;
				Modchu_Debug.mDebug("Modchu_EntityDataManager entityDataManagerRegister 8 register ok. o1="+o1);
			}
		} else {
			String ss = "Modchu_EntityDataManager entityDataManagerRegister dataParameter == null error !! c1="+c1+" i="+i+" o="+o;
			Modchu_Debug.mDebug(ss);
			Modchu_Main.setRuntimeException(ss);
		}
	}

	@Override
	public Object getDataParameterMap(int i) {
		return dataParameterMap.containsKey(i) ? dataParameterMap.get(i) : null;
	}

	@Override
	public void putDataParameterMap(int i, Object o) {
		dataParameterMap.put(i, o);
	}

	@Override
	public boolean getDataParameterMapContainsKey(int i, boolean b) {
		if (b) i = getIdMap(i);
		return dataParameterMap.containsKey(i);
	}

	@Override
	public int getIdMap(int i) {
		return idMap.containsKey(i) ? idMap.get(i) : i;
	}

	@Override
	public void putIdMap(int i, int i1) {
		idMap.put(i, i1);
	}

	@Override
	public Object getDataWatcherWatchableObject(int i) {
		boolean debug = false;
		boolean debug1 = false;
		if (debug) {
			Modchu_Debug.mDebug("Modchu_EntityDataManager getDataWatcherGetWatchableObject i="+i);
		}
		DataParameter dataParameter = (DataParameter) getDataParameterMap(i);
		if (debug) Modchu_Debug.mDebug("Modchu_EntityDataManager getDataWatcherGetWatchableObject dataParameter="+dataParameter);
		if (dataParameter != null); else {
			Modchu_Debug.mDebug("Modchu_EntityDataManager getDataWatcherGetWatchableObject dataParameter == null return. i="+i);
			Modchu_Debug.mDebug("Modchu_EntityDataManager getDataWatcherGetWatchableObject dataParameter == null return. dataParameterMap="+dataParameterMap);
			//Modchu_Main.setRuntimeException("Modchu_EntityDataManager getDataWatcherGetWatchableObject dataParameter == null return. i="+i);
			return null;
		}

		EntityDataManager.DataEntry dataentry = getEntry(dataParameter);

		Object o = dataentry != null ? dataentry.getValue() : null;
		if (debug) Modchu_Debug.mDebug("Modchu_EntityDataManager getDataWatcherGetWatchableObject return. o="+o);
		if (debug1) {
			World worldObj = (World) Modchu_AS.get(Modchu_AS.entityWorldObj, baseEntity);
			Modchu_Debug.mdDebug("i="+i+" o="+o, i - 15 + (3 * (worldObj.isRemote ? 1 : 0)));
		}
		//return dataManager.get(dataParameter);
		return o;
	}

	@Override
	public DataEntry getEntry(Object dataParameter) {
		return (DataEntry) (master != null ? master.getEntry(dataParameter) : superGetEntry(dataParameter));
	}

	@Override
	public DataEntry superGetEntry(Object dataParameter) {
		boolean debug = false;
		Map<Integer, EntityDataManager.DataEntry<?>> entries = Modchu_AS.getMap("EntityDataManager", "entries", this);
		if (debug) Modchu_Debug.mDebug("Modchu_EntityDataManager getDataWatcherGetWatchableObject entries="+entries);
		int id = ((DataParameter) dataParameter).getId();
		if (debug) Modchu_Debug.mDebug("Modchu_EntityDataManager getDataWatcherGetWatchableObject id="+id);
		EntityDataManager.DataEntry dataentry = null;
		dataentry = entries.containsKey(id) ? entries.get(id) : null;
		if (debug) Modchu_Debug.mDebug("Modchu_EntityDataManager getDataWatcherGetWatchableObject dataentry="+dataentry);
		return dataentry;
	}

	@Override
	public void setDataWatcherWatchableObject(int i, Object o) {
		boolean debug = false;
		if (debug) Modchu_Debug.mDebug("Modchu_EntityDataManager setDataWatcherGetWatchableObject 1 i="+i);
		DataParameter dataParameter = (DataParameter) getDataParameterMap(i);
		if (debug) {
			Modchu_Debug.mDebug("Modchu_EntityDataManager setDataWatcherGetWatchableObject 2 i="+i);
			Modchu_Debug.mDebug("Modchu_EntityDataManager setDataWatcherGetWatchableObject 3 dataParameter="+dataParameter);
		}
		if (dataParameter != null); else {
			Modchu_Debug.mDebug("Modchu_EntityDataManager setDataWatcherGetWatchableObject 4 dataParameter == null return. baseEntity="+baseEntity+" i="+i);
			Modchu_Debug.mDebug("Modchu_EntityDataManager setDataWatcherGetWatchableObject 5 dataParameter == null return. dataParameterMap="+dataParameterMap);
			String ss = "Modchu_EntityDataManager setDataWatcherGetWatchableObject dataParameter == null return. baseEntity="+baseEntity;
			Modchu_Debug.mDebug(ss);
			Modchu_Main.setRuntimeException(ss);
			return;
		}

		EntityDataManager.DataEntry dataentry = getEntry(dataParameter);

		if (ObjectUtils.notEqual(o, dataentry.getValue())) {
			dataentry.setValue(o);
			baseEntity.notifyDataManagerChange(dataParameter);
			dataentry.setDirty(true);
			Modchu_AS.set("EntityDataManager", "dirty", this, true);
			if (debug) Modchu_Debug.mDebug("Modchu_EntityDataManager 6 setDataWatcherGetWatchableObject ObjectUtils.notEqual setValue o="+o);
		} else {
			if (debug) Modchu_Debug.mDebug("Modchu_EntityDataManager 7 setDataWatcherGetWatchableObject !ObjectUtils.notEqual o="+o);
		}

		//dataManager.set(dataParameter, o);
	}

	@Override
	public <T> void register(DataParameter<T> dataParameter, T t) {
		if (master != null) master.register(dataParameter, t);
		else super.register(dataParameter, t);
	}

	@Override
	public <T> void superRegister(Object dataParameter, Object t) {
		super.register((DataParameter) dataParameter, (T) t);
	}

	@Override
	public <T> void register(Object dataParameter, T t, int i) {
		if (master != null) master.register(dataParameter, t, i);
	}

	@Override
	public <T> void superRegister(Object dataParameter, Object t, int i) {
	}

	@Override
	public <T> T get(DataParameter<T> dataParameter) {
		return (T) (master != null ? master.get(dataParameter) : super.get(dataParameter));
	}

	@Override
	public Object superGet(Object dataParameter) {
		return super.get((DataParameter) dataParameter);
	}

	@Override
	public <T> void set(DataParameter<T> dataParameter, T t) {
		if (master != null) master.set(dataParameter, t);
		else super.set(dataParameter, t);
	}

	@Override
	public <T> void superSet(Object dataParameter, Object t) {
		super.set((DataParameter) dataParameter, (T) t);
	}

	@Override
	public <T> void setDirty(DataParameter<T> dataParameter) {
		if (master != null) master.setDirty(dataParameter);
		else super.setDirty(dataParameter);
	}

	@Override
	public <T> void superSetDirty(Object dataParameter) {
		super.setDirty((DataParameter) dataParameter);
	}

	@Override
	public boolean isDirty() {
		return master != null ? master.isDirty() : super.isDirty();
	}

	@Override
	public boolean superIsDirty() {
		return super.isDirty();
	}

	@Override
	public List<DataEntry<?>> getDirty() {
		List<DataEntry<?>> list = master != null ? master.getDirty() : super.getDirty();

		boolean debug = false;
		if (debug) {
			Map<Integer, EntityDataManager.DataEntry<?>> entries = Modchu_AS.getMap("EntityDataManager", "entries", this);
			for (EntityDataManager.DataEntry<?> dataentry1 : list) {
				DataParameter dataParameter1 = (DataParameter) Modchu_AS.get("EntityDataManager$DataEntry", "getKey", dataentry1);
				int id1 = dataParameter1.getId();
				Object o1 = dataentry1.getValue();
				Modchu_Debug.mDebug("Modchu_EntityDataManager getDirty id1="+id1+" o1="+o1);
			}
		}
		return list;
	}

	@Override
	public List<DataEntry<?>> superGetDirty() {
		return super.getDirty();
	}

	@Override
	public void writeEntries(PacketBuffer packetBuffer) throws IOException {
		boolean debug = false;
		if (debug) {
			String[] s0 = new String[]{
					"Byte",
					"Integer",
					"Float",
					"String",
					"ITextComponent",
					"Optional<ItemStack>",
					"Optional<IBlockState>",
					"Boolean",
					"Rotations",
					"BlockPos",
					"Optional<BlockPos>",
					"EnumFacing",
					"Optional<UUID>"
			};
			Map<Integer, EntityDataManager.DataEntry<?>> entries = Modchu_AS.getMap("EntityDataManager", "entries", this);
			for (Entry<Integer, EntityDataManager.DataEntry<?>> en : entries.entrySet()) {
				int i1 = en.getKey();
				EntityDataManager.DataEntry dataentry1 = en.getValue();
				DataParameter dataParameter1 = (DataParameter) Modchu_AS.get("EntityDataManager$DataEntry", "getKey", dataentry1);
				int id1 = dataParameter1.getId();
				Object o1 = dataentry1.getValue();
				Modchu_Debug.mDebug("Modchu_EntityDataManager writeEntries entries id1="+id1+" o1="+o1);
				DataSerializer dataSerializer = dataParameter1.getSerializer();
				Modchu_Debug.mDebug("Modchu_EntityDataManager writeEntries entries dataSerializer="+dataSerializer);
				IntIdentityHashBiMap <DataSerializer<?>> REGISTRY = (IntIdentityHashBiMap<DataSerializer<?>>) Modchu_AS.get("DataSerializers", "REGISTRY");
				int i = 0;
				for (DataSerializer dataSerializer1 : REGISTRY) {
					if (dataSerializer.equals(dataSerializer1)) {
						break;
					}
					i++;
				}
				Modchu_Debug.mDebug("Modchu_EntityDataManager writeEntries entries s0[i]="+s0[i]);
			}
		}

		if (master != null) master.writeEntries(packetBuffer);
		else super.writeEntries(packetBuffer);
	}

	@Override
	public void superWriteEntries(Object packetBuffer) throws IOException {
		super.writeEntries((PacketBuffer) packetBuffer);
	}

	@Override
	public List<DataEntry<?>> getAll() {
		return master != null ? master.getAll() : super.getAll();
	}

	@Override
	public List<DataEntry<?>> superGetAll() {
		return super.getAll();
	}

	@Override
	public void setEntryValues(List<DataEntry<?>> entriesIn) {
		if (master != null) master.setEntryValues(entriesIn);
		else super.setEntryValues(entriesIn);
	}

	@Override
	public void superSetEntryValues(List entriesIn) {
		super.setEntryValues(entriesIn);
	}

	@Override
	public <T> void setEntryValue(DataEntry<T> dataEntry, DataEntry<?> dataEntry1) {
		if (master != null) master.setEntryValue(dataEntry, dataEntry1);
		else super.setEntryValue(dataEntry, dataEntry1);
	}

	@Override
	public <T> void superSetEntryValue(Object dataEntry, Object dataEntry1) {
		super.setEntryValue((DataEntry) dataEntry, (DataEntry) dataEntry1);
	}

	@Override
	public boolean isEmpty() {
		return master != null ? master.isEmpty() : super.isEmpty();
	}

	@Override
	public boolean superIsEmpty() {
		return super.isEmpty();
	}

	@Override
	public void setClean() {
		if (master != null) master.setClean();
		else super.setClean();
	}

	@Override
	public void superSetClean() {
		super.setClean();
	}

}
