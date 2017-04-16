package modchu.lib;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Modchu_EntityDataManagerMasterBasis implements Modchu_IEntityDataManagerMaster {
	public Modchu_IEntityDataManager base;

	public Modchu_EntityDataManagerMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IEntityDataManager) map.get("base");
	}

	@Override
	public void register(Object dataParameter, Object t) {
		base.superRegister(dataParameter, t);
	}

	@Override
	public void register(Object dataParameter, Object t, int i) {
		base.superRegister(dataParameter, t, i);
	}

	@Override
	public Object get(Object dataParameter) {
		return base.superGet(dataParameter);
	}

	@Override
	public void set(Object dataParameter, Object t) {
		base.superSet(dataParameter, t);
	}

	@Override
	public void setDirty(Object dataParameter) {
		base.superSetDirty(dataParameter);
	}

	@Override
	public boolean isDirty() {
		return base.superIsDirty();
	}

	@Override
	public List getDirty() {
		return base.superGetDirty();
	}

	@Override
	public void writeEntries(Object packetBuffer) throws IOException {
		base.superWriteEntries(packetBuffer);
	}

	@Override
	public List getAll() {
		return base.superGetAll();
	}

	@Override
	public void setEntryValues(List entriesIn) {
		base.superSetEntryValues(entriesIn);

	}

	@Override
	public void setEntryValue(Object dataEntry, Object dataEntry1) {
		base.superSetEntryValue(dataEntry, dataEntry1);
	}

	@Override
	public boolean isEmpty() {
		return base.superIsEmpty();
	}

	@Override
	public void setClean() {
		base.superSetClean();
	}

	@Override
	public Object getEntry(Object dataParameter) {
		return base.superGetEntry(dataParameter);
	}

}