package modchu.lib;

import java.io.IOException;
import java.util.List;

public interface Modchu_IDataWatcherMaster {
	public void addObject(int id, Object t);
	public void addObjectByDataType(int id, int type);
	public byte getWatchableObjectByte(int id);
	public short getWatchableObjectShort(int id);
	public int getWatchableObjectInt(int id);
	public float getWatchableObjectFloat(int id);
	public String getWatchableObjectString(int id);
	public Object getWatchableObjectItemStack(int id);
	public Object getWatchableObjectRotations(int id);
	public void updateObject(int id, Object t);
	public void setObjectWatched(int id);
	public boolean hasObjectChanged();
	public List getChanged();
	public void writeTo(Object packetBuffer) throws IOException;
	public List getAllWatched();
	public void updateWatchedObjectsFromList (List p_75687_1_);
	public boolean getIsBlank();
	public void func_111144_e();
	// ~164
	public List unwatchAndReturnAllWatched();
	public void writeWatchableObjects(Object dataOutput) throws IOException;
	// ~179
	public boolean hasChanges();
	public void func_151509_a(Object packetBuffer) throws IOException;

}
