package modchu.lib;

public class Modchu_EntityAISupport {

	public static boolean setMoveLandPotision(Modchu_IEntityAIWander modchu_IEntityAIWander, Object entity, Object water) {
		int version = Modchu_Main.getMinecraftVersion();
		Object world = Modchu_AS.get(Modchu_AS.entityWorldObj, entity);
		Object vec3d = null;
		for (int i = 0; i < 10; i++) {
			vec3d = version > 189 ? Modchu_AS.get("EntityAIWander", "getPosition", modchu_IEntityAIWander) : Modchu_AS.get("RandomPositionGenerator", "findRandomTarget", new Class[]{ Modchu_Reflect.loadClass("EntityCreature"), int.class, int.class }, new Object[]{ entity, 5, 4 });
			if (vec3d != null) {
				double x = Modchu_AS.getDouble(Modchu_AS.vec3XCoord, vec3d);
				double y = Modchu_AS.getDouble(Modchu_AS.vec3YCoord, vec3d);
				double z = Modchu_AS.getDouble(Modchu_AS.vec3ZCoord, vec3d);
				if (Modchu_WorldSupport.checkMaterial(x, y, z, entity, water)
						&& Modchu_WorldSupport.checkMaterial(x, y - 1, z, entity, water)) {
					Modchu_AS.set("EntityAIWander", version > 189 ? "x" : "xPosition", modchu_IEntityAIWander, x);
					Modchu_AS.set("EntityAIWander", version > 189 ? "y" : "yPosition", modchu_IEntityAIWander, y);
					Modchu_AS.set("EntityAIWander", version > 189 ? "z" : "zPosition", modchu_IEntityAIWander, z);
					//modc_Hamster.mdDebug("x="+x+" y="+y+" z="+z+" i="+i, 3);
					return true;
				}
			}
		}
		return false;
	}

}
