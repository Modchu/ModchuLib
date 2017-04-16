package modchu.lib;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Modchu_DataWatcherMasterBasis implements Modchu_IDataWatcherMaster {
	public Modchu_IDataWatcher base;

	public Modchu_DataWatcherMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IDataWatcher) map.get("base");
	}

	@Override
	public void addObject(int id, Object t) {
		base.superAddObject(id, t);
	}

	@Override
	public void addObjectByDataType(int id, int type) {
		base.superAddObjectByDataType(id, type);
	}

	@Override
	public byte getWatchableObjectByte(int id) {
		return base.superGetWatchableObjectByte(id);
	}

	@Override
	public short getWatchableObjectShort(int id) {
		return base.superGetWatchableObjectShort(id);
	}

	@Override
	public int getWatchableObjectInt(int id) {
		return base.superGetWatchableObjectInt(id);
	}

	@Override
	public float getWatchableObjectFloat(int id) {
		return base.superGetWatchableObjectFloat(id);
	}

	@Override
	public String getWatchableObjectString(int id) {
		return base.superGetWatchableObjectString(id);
	}

	@Override
	public Object getWatchableObjectItemStack(int id) {
		return base.superGetWatchableObjectItemStack(id);
	}

	@Override
	public Object getWatchableObjectRotations(int id) {
		return base.superGetWatchableObjectRotations(id);
	}

	@Override
	public void updateObject(int id, Object t) {
		base.superUpdateObject(id, t);
	}

	@Override
	public void setObjectWatched(int id) {
		base.superSetObjectWatched(id);
	}

	@Override
	public boolean hasObjectChanged() {
		return base.superHasObjectChanged();
	}

	@Override
	public List getChanged() {
		return base.superGetChanged();
	}

	@Override
	public void writeTo(Object packetBuffer) throws IOException {
		base.superWriteTo(packetBuffer);
	}

	@Override
	public List getAllWatched() {
		return base.superGetAllWatched();
	}

	@Override
	public void updateWatchedObjectsFromList(List p_75687_1_) {
		base.superUpdateWatchedObjectsFromList(p_75687_1_);
	}

	@Override
	public boolean getIsBlank() {
		return base.superGetIsBlank();
	}

	@Override
	public void func_111144_e() {
		base.superFunc_111144_e();
	}

	@Override
	public boolean hasChanges() {
		return base.superHasChanges();
	}

	@Override
	public void func_151509_a(Object packetBuffer) throws IOException {
		base.superFunc_151509_a(packetBuffer);
	}

	@Override
	public List unwatchAndReturnAllWatched() {
		return base.superUnwatchAndReturnAllWatched();
	}

	@Override
	public void writeWatchableObjects(Object dataOutput) throws IOException {
		base.superWriteWatchableObjects(dataOutput);
	}

}