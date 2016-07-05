package modchu.lib;

import java.util.HashMap;
import java.util.Map;

public class Modchu_EntitySpawnCallbackMaster extends Modchu_EntitySpawnCallbackMasterBasis {
	private Class spawnClass;
	private HashMap<String, Object> spawnMap;

	public Modchu_EntitySpawnCallbackMaster(HashMap<String, Object> map) {
		super(map);
		Modchu_Debug.mDebug("Modchu_EntitySpawnCallbackMaster init map="+map);
		spawnClass = map.containsKey("Class1") ? (Class) map.get("Class1") : null;
		if (spawnClass != null); else {
			String ss = "Modchu_EntitySpawnCallbackMaster spawnClass == null error !!";
			Modchu_Main.setRuntimeException(ss);
			return;
		}
		Modchu_Debug.mDebug("Modchu_EntitySpawnCallbackMaster init spawnClass="+spawnClass);
		spawnMap = map.containsKey("HashMap") ? (HashMap<String, Object>) map.get("HashMap") : map.containsKey("Map") ? (HashMap<String, Object>) map.get("Map") : null;
		if (spawnMap != null); else {
			spawnMap = new HashMap();
			if (map.containsKey("Class2")) {
				Class c = (Class) map.get("Class2");
				Modchu_Debug.mDebug("Modchu_EntitySpawnCallbackMaster init c="+c);
				spawnMap.put("Class", c);
			}
		}
	}

	@Override
	public Object apply(Object entitySpawnPacket) {
		Modchu_Debug.mDebug("Modchu_EntitySpawnCallbackMaster apply entitySpawnPacket="+entitySpawnPacket);
		Object entity = Modchu_Main.newModchuCharacteristicObject(spawnClass.getName(), spawnMap);
		int entityId = Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject(entitySpawnPacket.getClass(), "entityId", entitySpawnPacket));
		int entityId1 = Modchu_AS.getInt(Modchu_AS.entityEntityID, entity);
		int offset = entityId - entityId1;
		Modchu_AS.set(Modchu_AS.entityEntityID, entity, entityId);
		double scaledX = Modchu_CastHelper.Double(Modchu_Reflect.getFieldObject(entitySpawnPacket.getClass(), "scaledX", entitySpawnPacket));
		double scaledY = Modchu_CastHelper.Double(Modchu_Reflect.getFieldObject(entitySpawnPacket.getClass(), "scaledY", entitySpawnPacket));
		double scaledZ = Modchu_CastHelper.Double(Modchu_Reflect.getFieldObject(entitySpawnPacket.getClass(), "scaledZ", entitySpawnPacket));
		float scaledYaw = Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject(entitySpawnPacket.getClass(), "scaledYaw", entitySpawnPacket));
		float scaledPitch = Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject(entitySpawnPacket.getClass(), "scaledPitch", entitySpawnPacket));
		Modchu_AS.set(Modchu_AS.entitySetLocationAndAngles, entity, scaledX, scaledY, scaledZ, scaledYaw, scaledPitch);
		if (Modchu_Reflect.loadClass("EntityLivingBase").isInstance(entity)) {
			float scaledHeadYaw = Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject(entitySpawnPacket.getClass(), "scaledHeadYaw", entitySpawnPacket));
			Modchu_AS.set(Modchu_AS.entityLivingBaseRotationYawHead, entity, scaledHeadYaw);
		}

		Object[] parts = Modchu_AS.getObjectArray("Entity", "getParts", entity);
		if (parts != null) {
			for (Object entity1 : parts) {
				int entityId2 = Modchu_AS.getInt(Modchu_AS.entityEntityID, entity1);
				entityId2 += offset;
				Modchu_AS.set(Modchu_AS.entityEntityID, entity1, entityId2);
			}
		}
		Modchu_Debug.mDebug("Modchu_EntitySpawnCallbackMaster apply end. entity="+entity);
		return entity;
	}

}