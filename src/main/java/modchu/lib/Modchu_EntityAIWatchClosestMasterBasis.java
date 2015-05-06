package modchu.lib;

import java.util.HashMap;

public class Modchu_EntityAIWatchClosestMasterBasis implements Modchu_IEntityAIWatchClosestMaster {
	public Modchu_IEntityAIWatchClosest base;

	public Modchu_EntityAIWatchClosestMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IEntityAIWatchClosest) map.get("base");
	}

	@Override
	public boolean shouldExecute() {
		return base.superShouldExecute();
	}

	@Override
	public boolean continueExecuting() {
		return base.superContinueExecuting();
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

}
