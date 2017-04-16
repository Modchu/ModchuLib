package modchu.lib;

import java.io.IOException;
import java.util.List;

public interface Modchu_IEntityDataManagerMaster {
	public Object getEntry(Object dataParameter);

	public <T> void register(Object dataParameter, Object t);
	public <T> void register(Object dataParameter, Object t, int i);
	public Object get(Object dataParameter);
	public <T> void set(Object dataParameter, Object t);
	public <T> void setDirty(Object dataParameter);
	public boolean isDirty();
	public List getDirty();
	public void writeEntries(Object packetBuffer) throws IOException;
	public List getAll();
	public void setEntryValues(List entriesIn);
	public <T> void setEntryValue(Object dataEntry, Object dataEntry1);
	public boolean isEmpty();
	public void setClean();

}
