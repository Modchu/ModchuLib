package modchu.lib;

import java.util.HashMap;
import java.util.UUID;

public interface Modchu_IEntityHelper {
	public Object getFreeVariable(String s);
	public void setFreeVariable(String s, Object o);
	public void entityDataManagerRegister(Class[] c1, int i, Object o);
	public Object getDataWatcherWatchableObject(int i);
	public void setDataWatcherWatchableObject(int i, Object o);
	public Object getRidingEntity2();
	public boolean isRiding2();
	public void dismountRidingEntity2();
	public int getEntityDataManagerEntriesCount();
	public void dataParameterMapSetting(HashMap<Integer, Object> dataParameterMap);
	public boolean isInitFlag();
	public int getTempIsRiding();
	public void setTempIsRiding(int i);
	public int getDataWatcherWatchableObjectIdFirst();

	public void supersetMaxHealth(Object floatOrInt);

}
