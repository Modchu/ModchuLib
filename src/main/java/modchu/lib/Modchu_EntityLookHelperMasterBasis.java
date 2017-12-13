package modchu.lib;

import java.util.HashMap;

public class Modchu_EntityLookHelperMasterBasis implements Modchu_IEntityLookHelperMaster {
	public Modchu_IEntityLookHelper base;

	public Modchu_EntityLookHelperMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IEntityLookHelper) map.get("base");
	}

	@Override
	public void setLookPositionWithEntity(Object entity, float deltaYaw, float deltaPitch) {
		base.superSetLookPositionWithEntity(entity, deltaYaw, deltaPitch);
	}

	@Override
	public void setLookPosition(double x, double y, double z, float deltaYaw, float deltaPitch) {
		base.superSetLookPosition(x, y, z, deltaYaw, deltaPitch);
	}

	@Override
	public void onUpdateLook() {
		base.superOnUpdateLook();
	}

	@Override
	public boolean getIsLooking() {
		return base.superGetIsLooking();
	}

	@Override
	public double getLookPosX() {
		return base.superGetLookPosX();
	}

	@Override
	public double getLookPosY() {
		return base.superGetLookPosY();
	}

	@Override
	public double getLookPosZ() {
		return base.superGetLookPosZ();
	}

}