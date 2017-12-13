package modchu.lib.forge.mc190;

import java.util.HashMap;

import net.minecraft.entity.ai.EntityMoveHelper;

public class Modchu_EntityMoveHelper extends modchu.lib.forge.mc164_222.Modchu_EntityMoveHelper {

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

	@Override
	public void func_188488_a(float p_188488_1_, float p_188488_2_) {
		if (master != null) master.strafe(p_188488_1_, p_188488_2_);
		else super.func_188488_a(p_188488_1_, p_188488_2_);
	}

	@Override
	public void superStrafe(float forward, float strafe) {
		super.func_188488_a(forward, strafe);
	}

	@Override
	public void func_188487_a(EntityMoveHelper entityMoveHelper) {
		if (master != null) master.read(entityMoveHelper);
		else super.func_188487_a(entityMoveHelper);
	}

	@Override
	public void superRead(Object entityMoveHelper) {
		super.func_188487_a((EntityMoveHelper) entityMoveHelper);
	}

}
