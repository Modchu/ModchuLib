package modchu.lib.forge.mc189_222;

import java.util.HashMap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityMoveHelper;
import modchu.lib.Modchu_IEntityMoveHelperMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityMoveHelper;

public abstract class Modchu_EntityMoveHelper extends modchu.lib.forge.mc164_222.Modchu_EntityMoveHelper {

	public Modchu_EntityMoveHelper(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public float limitAngle(float sourceAngle, float targetAngle, float maximumChange) {
		return master != null ? master.limitAngle(sourceAngle, targetAngle, maximumChange) : super.limitAngle(sourceAngle, targetAngle, maximumChange);
	}

	@Override
	public float superLimitAngle(float sourceAngle, float targetAngle, float maximumChange) {
		return super.limitAngle(sourceAngle, targetAngle, maximumChange);
	}

	@Override
	public double getX() {
		return master != null ? master.getX() : super.getX();
	}

	@Override
	public double superGetX() {
		return super.getX();
	}

	@Override
	public double getY() {
		return master != null ? master.getY() : super.getY();
	}

	@Override
	public double superGetY() {
		return super.getY();
	}

	@Override
	public double getZ() {
		return master != null ? master.getZ() : super.getZ();
	}

	@Override
	public double superGetZ() {
		return super.getZ();
	}

}
