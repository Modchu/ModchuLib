package modchu.lib;

import java.util.HashMap;

public class Modchu_EntityAIRestrictOpenDoorMasterBasis implements Modchu_IEntityAIRestrictOpenDoorMaster {
	public Modchu_IEntityAIRestrictOpenDoor base;

	public Modchu_EntityAIRestrictOpenDoorMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IEntityAIRestrictOpenDoor) map.get("base");
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
