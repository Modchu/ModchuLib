package modchu.lib;

import java.util.HashMap;

public class Modchu_EntityMoveHelperMasterBasis implements Modchu_IEntityMoveHelperMaster {
	public Modchu_IEntityMoveHelper base;

	public Modchu_EntityMoveHelperMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IEntityMoveHelper) map.get("base");
	}

	@Override
	public boolean isUpdating() {
		return base.superIsUpdating();
	}

	@Override
	public double getSpeed() {
		return base.superGetSpeed();
	}

	@Override
	public void setMoveTo(double x, double y, double z, double speedIn) {
		base.superSetMoveTo(x, y, z, speedIn);
	}

	@Override
	public void strafe(float forward, float strafe) {
		base.superStrafe(forward, strafe);
	}

	@Override
	public void read(Object entityMoveHelper) {
		base.superRead(entityMoveHelper);
	}

	@Override
	public void onUpdateMoveHelper() {
		base.superOnUpdateMoveHelper();
	}

	@Override
	public float limitAngle(float sourceAngle, float targetAngle, float maximumChange) {
		return base.superLimitAngle(sourceAngle, targetAngle, maximumChange);
	}

	@Override
	public double getX() {
		return base.superGetX();
	}

	@Override
	public double getY() {
		return base.superGetY();
	}

	@Override
	public double getZ() {
		return base.superGetZ();
	}

}