package modchu.lib.modloader.mc152;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_IDataWatcher;
import modchu.lib.Modchu_IDataWatcherMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.src.DataWatcher;
import net.minecraft.src.ItemStack;
import net.minecraft.src.WatchableObject;

public class Modchu_DataWatcher extends DataWatcher implements Modchu_IDataWatcher {
	public Modchu_IDataWatcherMaster master;

	public Modchu_DataWatcher() {
		super();
	}

	public Modchu_DataWatcher(HashMap<String, Object> map) {
		super();
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		master = instance instanceof Modchu_IDataWatcherMaster ? (Modchu_IDataWatcherMaster) instance : null;
		//Modchu_Debug.mDebug("Modchu_DataWatcher init master="+master);
	}

	@Override
	public int getEntityDataManagerEntriesCount() {
		Map<Integer, Object> watchedObjects = Modchu_AS.getMap("DataWatcher", "watchedObjects", this);
		int dataWatcherWatchableObjectIdCount = 0;
		for (Entry<Integer, Object> en : watchedObjects.entrySet()) {
			int key = en.getKey();
			Object o = en.getValue();
			if (dataWatcherWatchableObjectIdCount < key) dataWatcherWatchableObjectIdCount = key;
		}
		dataWatcherWatchableObjectIdCount++;
		return dataWatcherWatchableObjectIdCount;
	}

	@Override
	public void addObject(int id, Object o) {
		if (master != null) master.addObject(id, o);
		else super.addObject(id, o);
	}

	@Override
	public void superAddObject(int id, Object o) {
		super.addObject(id, o);
	}

	@Override
	public void addObjectByDataType(int id, int type) {
		if (master != null) master.addObjectByDataType(id, type);
		else super.addObjectByDataType(id, type);
	}

	@Override
	public void superAddObjectByDataType(int id, int type) {
		super.addObjectByDataType(id, type);
	}

	@Override
	public byte getWatchableObjectByte(int id) {
		return master != null ? master.getWatchableObjectByte(id) : super.getWatchableObjectByte(id);
	}

	@Override
	public byte superGetWatchableObjectByte(int id) {
		return super.getWatchableObjectByte(id);
	}

	@Override
	public short getWatchableObjectShort(int id) {
		return master != null ? master.getWatchableObjectShort(id) : super.getWatchableObjectShort(id);
	}

	@Override
	public short superGetWatchableObjectShort(int id) {
		return super.getWatchableObjectShort(id);
	}

	@Override
	public int getWatchableObjectInt(int id) {
		return master != null ? master.getWatchableObjectInt(id) : super.getWatchableObjectInt(id);
	}

	@Override
	public int superGetWatchableObjectInt(int id) {
		return super.getWatchableObjectInt(id);
	}

	@Override
	public String getWatchableObjectString(int id) {
		return master != null ? master.getWatchableObjectString(id) : super.getWatchableObjectString(id);
	}

	@Override
	public String superGetWatchableObjectString(int id) {
		return super.getWatchableObjectString(id);
	}

	@Override
	public ItemStack getWatchableObjectItemStack(int id) {
		return (ItemStack) (master != null ? master.getWatchableObjectItemStack(id) : super.getWatchableObjectItemStack(id));
	}

	@Override
	public ItemStack superGetWatchableObjectItemStack(int id) {
		return super.getWatchableObjectItemStack(id);
	}

	@Override
	public void updateObject(int id, Object o) {
		if (master != null) master.updateObject(id, o);
		else super.updateObject(id, o);
	}

	@Override
	public void superUpdateObject(int id, Object t) {
		super.updateObject(id, t);
	}

	@Override
	public void setObjectWatched(int id) {
		if (master != null) master.setObjectWatched(id);
		else super.setObjectWatched(id);
	}

	@Override
	public void superSetObjectWatched(int id) {
		super.setObjectWatched(id);
	}

	@Override
	public List<WatchableObject> getAllWatched() {
		return (List<WatchableObject>) (master != null ? master.getAllWatched() : super.getAllWatched());
	}

	@Override
	public List<WatchableObject> superGetAllWatched() {
		return super.getAllWatched();
	}

	@Override
	public void updateWatchedObjectsFromList(List p_75687_1_) {
		if (master != null) master.updateWatchedObjectsFromList(p_75687_1_);
		else super.updateWatchedObjectsFromList(p_75687_1_);
	}

	@Override
	public void superUpdateWatchedObjectsFromList(List p_75687_1_) {
		super.updateWatchedObjectsFromList(p_75687_1_);
	}

	@Override
	public boolean getIsBlank() {
		return master != null ? master.getIsBlank() : super.getIsBlank();
	}

	@Override
	public boolean superGetIsBlank() {
		return super.getIsBlank();
	}
	// 164~
	@Override
	public float superGetWatchableObjectFloat(int id) {
		return 0.0F;
	}

	@Override
	public void superFunc_111144_e() {
	}
	// ~164
	@Override
	public List unwatchAndReturnAllWatched() {
		return master != null ? master.unwatchAndReturnAllWatched() : super.unwatchAndReturnAllWatched();
	}

	@Override
	public List superUnwatchAndReturnAllWatched() {
		return super.unwatchAndReturnAllWatched();
	}

	public void writeWatchableObjects(DataOutputStream dataOutput) throws IOException {
		if (master != null) master.writeWatchableObjects(dataOutput);
		else super.writeWatchableObjects(dataOutput);
	}

	@Override
	public void superWriteWatchableObjects(Object dataOutput) throws IOException {
		super.writeWatchableObjects((DataOutputStream) dataOutput);
	}
	// ~179
	@Override
	public boolean hasChanges() {
		return master != null ? master.hasChanges() : super.hasChanges();
	}

	@Override
	public boolean superHasChanges() {
		return super.hasChanges();
	}
	// 172~179
	@Override
	public List superGetChanged() {
		return null;
	}

	@Override
	public void superFunc_151509_a(Object packetBuffer) throws IOException {
	}
	// 180~
	@Override
	public Object superGetWatchableObjectRotations(int id) {
		return null;
	}

	@Override
	public boolean superHasObjectChanged() {
		return false;
	}

	@Override
	public void superWriteTo(Object packetBuffer) throws IOException {
	}

}
