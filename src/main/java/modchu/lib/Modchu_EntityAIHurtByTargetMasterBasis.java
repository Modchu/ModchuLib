package modchu.lib;

import java.util.HashMap;

public class Modchu_EntityAIHurtByTargetMasterBasis implements Modchu_IEntityAIHurtByTargetMaster {
	public Modchu_IEntityAIHurtByTarget base;

	public Modchu_EntityAIHurtByTargetMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IEntityAIHurtByTarget) map.get("base");
	}

	@Override
	public boolean shouldExecute() {
		return base.superShouldExecute();
	}

	@Override
	public boolean shouldContinueExecuting() {
		return base.superShouldContinueExecuting();
	}

	@Override
	public boolean isInterruptible() {
		return base.superIsInterruptible();
	}

	@Override
	public void startExecuting() {
		base.superStartExecuting();
	}

	@Override
	public void resetTask() {
		base.superResetTask();
	}

	@Override
	public void updateTask() {
		base.superUpdateTask();
	}

	@Override
	public void setMutexBits(int par1) {
		base.superSetMutexBits(par1);
	}

	@Override
	public int getMutexBits() {
		return base.superGetMutexBits();
	}

	@Override
	public double getTargetDistance() {
		return base.superGetTargetDistance();
	}

	@Override
	public boolean isSuitableTarget(Object entityLivingBase, boolean par2) {
		return base.superIsSuitableTarget(entityLivingBase, par2);
	}

}
