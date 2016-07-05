package modchu.lib;

import java.util.HashMap;

public class Modchu_EntitySpawnCallbackMasterBasis implements Modchu_IEntitySpawnCallbackMaster {
	public Modchu_IEntitySpawnCallback base;

	public Modchu_EntitySpawnCallbackMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IEntitySpawnCallback) map.get("base");
	}

	@Override
	public Object apply(Object entitySpawnPacket) {
		return base.superApply(entitySpawnPacket);
	}

}