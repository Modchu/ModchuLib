package modchu.lib.forge.mc180;

import java.util.HashMap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityMoveHelper;
import modchu.lib.Modchu_IEntityMoveHelperMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.entity.EntityLiving;
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
	public double func_179917_d() {
		return master != null ? master.getX() : super.func_179917_d();
	}

	@Override
	public double superGetX() {
		return super.func_179917_d();
	}

	@Override
	public double func_179919_e() {
		return master != null ? master.getY() : super.func_179919_e();
	}

	@Override
	public double superGetY() {
		return super.func_179919_e();
	}

	@Override
	public double func_179918_f() {
		return master != null ? master.getZ() : super.func_179918_f();
	}

	@Override
	public double superGetZ() {
		return super.func_179918_f();
	}

	@Override
	public void superStrafe(float forward, float strafe) {
	}

	@Override
	public void superRead(Object entityMoveHelper) {
	}

}
