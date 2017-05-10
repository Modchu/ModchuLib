package modchu.lib;

import java.util.HashMap;

public class Modchu_EntityAIPanicAllDamage extends Modchu_EntityAIPanicMasterBasis {
	private Modchu_IEntityLiving modchu_IEntityLiving;

	public Modchu_EntityAIPanicAllDamage(HashMap<String, Object> map) {
		super(map);
		modchu_IEntityLiving = (Modchu_IEntityLiving) Modchu_AS.get("EntityAIPanic", "theEntityCreature", base);
	}

	@Override
	public boolean shouldExecute() {
		boolean debug = false;
		boolean debug1 = debug
				&& !Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, modchu_IEntityLiving);
		boolean b = super.shouldExecute();
		if (!b) {
			if (modchu_IEntityLiving.isDamageInvincible()) {
				if (debug1) Modchu_Debug.mdDebug("AIPanicAll");
/*
				// 水に移動
				Object blockpos = Modchu_AS.get("EntityAIPanic", "getRandPos", new Class[]{ Modchu_Reflect.loadClass("World"), Modchu_Reflect.loadClass("Entity"), int.class, int.class }, base, new Object[]{ Modchu_AS.get(Modchu_AS.entityWorldObj, entityCreature), entityCreature, 5, 4 });
				Modchu_Debug.mDebug("Modchu_EntityAIPanicAllDamage shouldExecute blockpos="+blockpos);
				if (blockpos != null) {
					Modchu_AS.set("EntityAIPanic", "randPosX", base, Modchu_AS.getDouble(Modchu_AS.blockPosGetX, blockpos));
					Modchu_AS.set("EntityAIPanic", "randPosY", base, Modchu_AS.getDouble(Modchu_AS.blockPosGetY, blockpos));
					Modchu_AS.set("EntityAIPanic", "randPosZ", base, Modchu_AS.getDouble(Modchu_AS.blockPosGetZ, blockpos));
					return true;
				}
*/
				int version = Modchu_Main.getMinecraftVersion();
				return version < 220 ? findRandomPosition() : Modchu_AS.set("EntityAIPanic", version > 220 ? "findRandomPosition" : "func_190863_f", base);
			} else {
				if (debug1) Modchu_Debug.mdDebug(null);
			}
		} else {
			if (debug1) Modchu_Debug.mdDebug(null);
		}
		return b;
	}

	private boolean findRandomPosition() {
		Object vec3d = Modchu_AS.get("RandomPositionGenerator", "findRandomTarget", new Class[]{ Modchu_Reflect.loadClass("EntityCreature"), int.class, int.class }, new Object[]{ modchu_IEntityLiving, 5, 4 });
		//Modchu_Debug.mDebug("Modchu_EntityAIPanicAllDamage findRandomPosition() vec3d="+vec3d);
		if (vec3d != null) {
			Modchu_AS.set("EntityAIPanic", "randPosX", base, Modchu_AS.getDouble(Modchu_AS.vec3XCoord, vec3d));
			Modchu_AS.set("EntityAIPanic", "randPosY", base, Modchu_AS.getDouble(Modchu_AS.vec3YCoord, vec3d));
			Modchu_AS.set("EntityAIPanic", "randPosZ", base, Modchu_AS.getDouble(Modchu_AS.vec3ZCoord, vec3d));
			return true;
		}
		return false;
	}
/*
	@Override
	public void startExecuting() {
		//Modchu_Debug.mDebug("Modchu_EntityAIPanicAllDamage startExecuting()");
		super.startExecuting();
	}
*/
}
