package modchu.lib;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface Modchu_IEntityDataManager {
	public int getEntityDataManagerEntriesCount();

	public void entityDataManagerRegister(Class[] c1, int i, Object o);
	public Object getDataWatcherWatchableObject(int i);
	public void setDataWatcherWatchableObject(int i, Object o);
	public Object getDataParameterMap(int i);
	public void putDataParameterMap(int i, Object o);
	public int getIdMap(int i);
	public void putIdMap(int i, int i1);
	public boolean getDataParameterMapContainsKey(int i, boolean b);
	public Object getEntry(Object dataParameter);
	public Object superGetEntry(Object dataParameter);

	public <T> void superRegister(Object dataParameter, Object t);
	public <T> void superRegister(Object dataParameter, Object t, int i);
	public Object superGet(Object dataParameter);
	public <T> void superSet(Object dataParameter, Object t);
	public <T> void superSetDirty(Object dataParameter);
	public boolean superIsDirty();
	public List superGetDirty();
	public void superWriteEntries(Object packetBuffer) throws IOException;
	public List superGetAll();
	public void superSetEntryValues(List entriesIn);
	public <T> void superSetEntryValue(Object dataEntry, Object dataEntry1);
	public boolean superIsEmpty();
	public void superSetClean();
	public <T> void register(Object dataParameter, T t, int i);

}
