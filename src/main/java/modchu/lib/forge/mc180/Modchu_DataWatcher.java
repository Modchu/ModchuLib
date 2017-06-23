package modchu.lib.forge.mc180;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import modchu.lib.Modchu_IDataWatcher;
import modchu.lib.Modchu_IDataWatcherMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Rotations;

public class Modchu_DataWatcher extends DataWatcher implements Modchu_IDataWatcher {
	public Modchu_IDataWatcherMaster master;

	public Modchu_DataWatcher(Entity entity1) {
		super(entity1);
	}

	public Modchu_DataWatcher(HashMap<String, Object> map) {
		super((Entity) map.get("Object"));
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		master = instance instanceof Modchu_IDataWatcherMaster ? (Modchu_IDataWatcherMaster) instance : null;
		//Modchu_Debug.mDebug("Modchu_DataWatcher init master="+master);
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
	public float getWatchableObjectFloat(int id) {
		return master != null ? master.getWatchableObjectFloat(id) : super.getWatchableObjectFloat(id);
	}

	@Override
	public float superGetWatchableObjectFloat(int id) {
		return super.getWatchableObjectFloat(id);
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
	public Rotations getWatchableObjectRotations(int id) {
		return (Rotations) (master != null ? master.getWatchableObjectRotations(id) : super.getWatchableObjectRotations(id));
	}

	@Override
	public Rotations superGetWatchableObjectRotations(int id) {
		return super.getWatchableObjectRotations(id);
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
	public boolean hasObjectChanged() {
		return master != null ? master.hasObjectChanged() : super.hasObjectChanged();
	}

	@Override
	public boolean superHasObjectChanged() {
		return super.hasObjectChanged();
	}

	@Override
	public List<DataWatcher.WatchableObject> getChanged() {
		return master != null ? master.getChanged() : super.getChanged();
	}

	@Override
	public List<DataWatcher.WatchableObject> superGetChanged() {
		return super.getChanged();
	}

	@Override
	public void writeTo(PacketBuffer packetBuffer) throws IOException {
		if (master != null) master.writeTo(packetBuffer);
		else super.writeTo(packetBuffer);
	}

	@Override
	public void superWriteTo(Object packetBuffer) throws IOException {
		super.writeTo((PacketBuffer) packetBuffer);
	}

	@Override
	public List<DataWatcher.WatchableObject> getAllWatched() {
		return master != null ? master.getAllWatched() : super.getAllWatched();
	}

	@Override
	public List<DataWatcher.WatchableObject> superGetAllWatched() {
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

	@Override
	public void func_111144_e() {
		if (master != null) master.func_111144_e();
		else super.func_111144_e();
	}

	@Override
	public void superFunc_111144_e() {
		super.func_111144_e();
	}

	@Override
	public List superUnwatchAndReturnAllWatched() {
		return null;
	}

	@Override
	public void superWriteWatchableObjects(Object dataOutput) throws IOException {
	}

	@Override
	public boolean superHasChanges() {
		return super.hasObjectChanged();
	}

	@Override
	public void superFunc_151509_a(Object packetBuffer) throws IOException {
	}

}
