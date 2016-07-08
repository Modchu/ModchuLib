package modchu.lib;

import java.util.HashMap;
import java.util.Random;

public class Modchu_SpawnManager {
	public static Modchu_SpawnManager instance = new Modchu_SpawnManager();
	protected HashMap<String, Object[]> spawnClassNameMap = new HashMap();

	public void spawnRegister(String s, String spawModchuClassName, HashMap<String, Object> spawnableMap) {
		spawnClassNameMap.put(s, new Object[]{ spawModchuClassName, spawnableMap });
	}

	public Object spawnCreature(String s, Object world, double par2, double par4, double par6) {
		if (s != null
				& !s.isEmpty()); else return null;
		if (!spawnClassNameMap.containsKey(s)) return null;
		Object[] o = spawnClassNameMap.get(s);
		String spawModchuClassName = (String) o[0];
		HashMap<String, Object> spawnableMap = (HashMap<String, Object>) o[1];
		return spawnCreature(spawModchuClassName, spawnableMap, world, par2, par4, par6);
	}

	public Object spawnCreature(String spawModchuClassName, HashMap<String, Object> spawnableMap, Object world, double par2, double par4, double par6) {
		boolean debug = true;
		Object entity = null;
		try {
			boolean isRemote = Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, world);
			spawnableMap.put("Object", world);
			if (debug) Modchu_Debug.mDebug("Modchu_SpawnManager spawnCreature 1 isRemote="+isRemote);
			spawnableMap.put("spawnX", par2);
			spawnableMap.put("spawnY", par4);
			spawnableMap.put("spawnZ", par6);
			entity = Modchu_Main.newModchuCharacteristicObject(spawModchuClassName, spawnableMap);
			if (entity !=null); else {
				Modchu_Main.setRuntimeException("Modchu_SpawnManager spawnCreature entity == null error !! spawModchuClassName="+spawModchuClassName+" spawnableMap="+spawnableMap);
				return null;
			}
			if (debug) Modchu_Debug.mDebug("Modchu_SpawnManager spawnCreature 2 entity="+entity);
			int version = Modchu_Main.getMinecraftVersion();
			String s1 = version > 190 ? "Particle" : "EntityFX";
			Class Particle = !Modchu_Main.isServer ? Modchu_Reflect.loadClass(s1) : null;
			if (Particle != null
					&& Particle.isInstance(entity)) {
				if (debug) {
					Modchu_Debug.mDebug("Modchu_SpawnManager spawnCreature 3 "+s1+".isInstance");
					Modchu_Debug.mDebug("Modchu_SpawnManager spawnCreature entity.master="+Modchu_Main.getModchuCharacteristicObjectMaster(entity));
				}
				Object effectRenderer = Modchu_AS.get("Minecraft", "effectRenderer", Modchu_AS.get(Modchu_AS.minecraftGetMinecraft));
				if (debug) Modchu_Debug.mDebug("Modchu_SpawnManager spawnCreature effectRenderer="+effectRenderer);
				if (effectRenderer != null) Modchu_AS.set("EffectRenderer", "addEffect", new Class[]{ Particle }, effectRenderer, new Object[]{ entity });
			} else {
				Modchu_AS.set(Modchu_AS.entitySetLocationAndAngles, entity, par2 + 0.5D, par4 + 1.0D, par6 + 0.5D, Modchu_AS.getFloat(Modchu_AS.mathHelperWrapAngleTo180_float, ((Random) Modchu_AS.get(Modchu_AS.worldRand, world)).nextFloat() * 360.0F), 0.0F);
				if (Modchu_Reflect.loadClass("EntityLivingBase").isInstance(entity)) {
					float rotationYaw = Modchu_AS.getFloat(Modchu_AS.entityRotationYaw, entity);
					Modchu_AS.set(Modchu_AS.entityLivingBaseRotationYawHead, entity, rotationYaw);
					Modchu_AS.set(Modchu_AS.entityLivingBaseRenderYawOffset, entity, rotationYaw);
				}
				boolean flag = Modchu_Reflect.loadClass("EntityLiving").isInstance(entity);
				if (flag) {
					if (version > 179) {
						Object blockPos = Modchu_AS.get(Modchu_AS.newBlockPos, Modchu_AS.getDouble(Modchu_AS.entityPosX, entity), Modchu_AS.getDouble(Modchu_AS.entityPosY, entity), Modchu_AS.getDouble(Modchu_AS.entityPosZ, entity));
						//Modchu_Debug.mDebug("Modchu_SpawnManager spawnCreature blockPos="+blockPos);
						Object difficultyForLocation = Modchu_AS.get("World", "getDifficultyForLocation", new Class[]{ Modchu_Reflect.loadClass("BlockPos") }, world, new Object[]{ blockPos });
						//Modchu_Debug.mDebug("Modchu_SpawnManager spawnCreature difficultyForLocation="+difficultyForLocation);
						//Method method = Modchu_Reflect.getMethod("EntityLiving", "func_180482_a", version > 180 ? "onInitialSpawn" : "func_180482_a", new Class[]{ Modchu_Reflect.loadClass("DifficultyInstance"), Modchu_Reflect.loadClass("IEntityLivingData") });
						//Modchu_Debug.mDebug("Modchu_SpawnManager spawnCreature method="+method);
						//Modchu_Reflect.invoke(method, entity, new Object[]{ difficultyForLocation, null });
						if (flag) Modchu_AS.get("EntityLiving", version > 180 ? "onInitialSpawn" : "func_180482_a", new Class[]{ Modchu_Reflect.loadClass("DifficultyInstance"), Modchu_Reflect.loadClass("IEntityLivingData") }, entity, new Object[]{ difficultyForLocation, null });
					} else if (version > 159) {
						Modchu_AS.set("EntityLiving", "onSpawnWithEgg", new Class[]{ Modchu_Reflect.loadClass(version > 169 ? "IEntityLivingData" : "EntityLivingData") }, entity, new Object[]{ null });
					}
				}
				Modchu_AS.getBoolean(Modchu_AS.worldSpawnEntityInWorld, world, entity);
				if (flag) Modchu_AS.set("EntityLiving", "playLivingSound", entity);
			}
		} catch (Exception e) {
			String ss = "Modchu_SpawnManager spawnCreature Exception !!";
			Modchu_Debug.lDebug(ss, 2, e);
			Modchu_Main.setRuntimeException(ss);
		}

		return entity;
	}

}
