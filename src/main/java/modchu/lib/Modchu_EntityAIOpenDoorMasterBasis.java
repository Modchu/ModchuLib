package modchu.lib;

import java.util.HashMap;

public class Modchu_EntityAIOpenDoorMasterBasis implements Modchu_IEntityAIOpenDoorMaster {
	public Modchu_IEntityAIOpenDoor base;

	public Modchu_EntityAIOpenDoorMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IEntityAIOpenDoor) map.get("base");
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

}
