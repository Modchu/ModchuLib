package modchu.lib.forge.mc194_222;

import java.util.HashMap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityMoveHelperMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityMoveHelper;

public class Modchu_EntityMoveHelper extends modchu.lib.forge.mc189_222.Modchu_EntityMoveHelper {
	public Modchu_IEntityMoveHelperMaster master;

	public Modchu_EntityMoveHelper(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void strafe(float forward, float strafe) {
		if (master != null) master.strafe(forward, strafe);
		else super.strafe(forward, strafe);
	}

	@Override
	public void superStrafe(float forward, float strafe) {
		super.strafe(forward, strafe);
	}

	@Override
	public void read(EntityMoveHelper entityMoveHelper) {
		if (master != null) master.read(entityMoveHelper);
		else super.read(entityMoveHelper);
	}

	@Override
	public void superRead(Object entityMoveHelper) {
		super.read((EntityMoveHelper) entityMoveHelper);
	}

}
