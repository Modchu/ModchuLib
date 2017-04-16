package modchu.lib;

import java.io.IOException;
import java.util.List;

public interface Modchu_IDataWatcher {
	public <T> void superAddObject(int id, T object);
	public void superAddObjectByDataType(int id, int type);
	public byte superGetWatchableObjectByte(int id);
	public short superGetWatchableObjectShort(int id);
	public int superGetWatchableObjectInt(int id);
	public float superGetWatchableObjectFloat(int id);
	public String superGetWatchableObjectString(int id);
	public Object superGetWatchableObjectItemStack(int id);
	public Object superGetWatchableObjectRotations(int id);
	public <T> void superUpdateObject(int id, T t);
	public void superSetObjectWatched(int id);
	public boolean superHasObjectChanged();
	public List superGetChanged();
	public void superWriteTo(Object packetBuffer) throws IOException;
	public List superGetAllWatched();
	public void superUpdateWatchedObjectsFromList (List p_75687_1_);
	public boolean superGetIsBlank();
	public void superFunc_111144_e();
	// ~164
	public List superUnwatchAndReturnAllWatched();
	public void superWriteWatchableObjects(Object dataOutput) throws IOException;
	// ~179
	public boolean superHasChanges();
	public void superFunc_151509_a(Object packetBuffer) throws IOException;

}
