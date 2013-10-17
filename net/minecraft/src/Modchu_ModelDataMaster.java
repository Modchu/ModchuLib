package net.minecraft.src;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

public class Modchu_ModelDataMaster {

	public static Modchu_ModelDataMaster instance = new Modchu_ModelDataMaster();
	protected ConcurrentHashMap<Object, Modchu_ModelDataBase> dataMap = new ConcurrentHashMap();
	public boolean resetFlag = false;
	public Date timeDate;

	public Modchu_ModelDataMaster() {
	}

	public Modchu_ModelDataBase getPlayerData(Object o) {
		if (o != null) ;else return null;
		Entity entity = null;
		Modchu_ModelDataBase data = null;
		if (mod_Modchu_ModchuLib.modchu_Main.MMM_IModelCaps.isInstance(o)) {
			entity = (Entity) Modchu_Reflect.invokeMethod(mod_Modchu_ModchuLib.modchu_Main.MMM_IModelCaps, "getCapsValue", new Class[]{ int.class, Object[].class }, o, new Object[]{ Modchu_IModelCaps.caps_Entity, null });
			if (entity != null) data = dataMap.get(entity);
		} else data = dataMap.get(o);
		boolean b = false;
		if (data != null) {
			if (data.getCapsValueInt(data.caps_initFlag) != 2) {
				Modchu_Debug.mDebug("initFlag="+data.getCapsValueInt(data.caps_initFlag));
				b = true;
			}
		} else b = true;
		if (b
				| resetFlag) {
			if (resetFlag) {
				resetFlag = false;
				clearDataMap();
				data = null;
			}
			data = loadPlayerData(o, data);
			if (data != null) {
				Modchu_Debug.mDebug("Modchu_ModelDataMaster getPlayerData dataMap.put");
				data.setCapsValue(data.caps_initFlag, 2);
				if (mod_Modchu_ModchuLib.modchu_Main.MMM_IModelCaps.isInstance(o)) {
					if (entity != null) dataMap.put(entity, data);
					else Modchu_Debug.mDebug("Modchu_ModelDataMaster getPlayerData dataMap.put entity == null !!");
				} else dataMap.put(o, data);
			}
		}
		return data;
	}

	public Modchu_ModelDataBase loadPlayerData(Object o) {
		return loadPlayerData(o, null);
	}

	public Modchu_ModelDataBase loadPlayerData(Object o, Modchu_ModelDataBase data) {
		//Modchu_Debug.mDebug("Modchu_ModelDataMaster loadPlayerData");
		if (o != null) ;else return null;
		if (data != null) ;else data = new Modchu_ModelDataBase();
		if (mod_Modchu_ModchuLib.modchu_Main.MMM_IModelCaps.isInstance(o)) {
			data.setCapsValue(data.caps_subEntityCaps, o);
			//Modchu_Debug.mDebug("Modchu_ModelDataMaster loadPlayerData set o");
		}
		//Modchu_Debug.mDebug("Modchu_ModelDataMaster loadPlayerData end");
		return data;
	}

    public float getActionSpeed(Modchu_ModelDataBase modelData) {
/*
    	World theWorld = mod_Modchu_ModchuLib.modchu_Main.getTheWorld();
    	float f = (float)(theWorld.getWorldTime() - modelData.getCapsValueInt(modelData.caps_actionTime));
    	modelData.setCapsValue(modelData.caps_actionTime, (int) theWorld.getWorldTime());
*/
    	timeDate = new Date();
    	float f = (float)((int) timeDate.getTime() - modelData.getCapsValueInt(modelData.caps_actionTime)) / 40;
    	//Modchu_Debug.mDebug("getActionSpeed f="+f);
    	modelData.setCapsValue(modelData.caps_actionTime, (int) timeDate.getTime());
    	//Modchu_Debug.mDebug("getActionSpeed (int) timeDate.getTime()="+(int) timeDate.getTime()+" f="+f);
    	return f;
    }

	public void clearDataMap() {
		dataMap.clear();
	}

	public void removeDataMap(Object o) {
		dataMap.remove(o);
	}
}
