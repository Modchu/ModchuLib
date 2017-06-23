package modchu.lib;

import java.util.HashMap;

public class Modchu_EntityAISitMasterBasis implements Modchu_IEntityAISitMaster {
	public Modchu_IEntityAISit base;

	public Modchu_EntityAISitMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IEntityAISit) map.get("base");
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
	public void setSitting(boolean par1) {
		base.superSetSitting(par1);
	}

}
