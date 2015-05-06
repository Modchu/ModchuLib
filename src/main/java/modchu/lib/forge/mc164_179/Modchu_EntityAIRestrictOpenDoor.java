package modchu.lib.forge.mc164_179;

import java.util.HashMap;

import modchu.lib.Modchu_IEntityAIRestrictOpenDoor;
import modchu.lib.Modchu_IEntityAIRestrictOpenDoorMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;

public class Modchu_EntityAIRestrictOpenDoor extends EntityAIRestrictOpenDoor implements Modchu_IEntityAIRestrictOpenDoor {
	public Modchu_IEntityAIRestrictOpenDoorMaster master;

	public Modchu_EntityAIRestrictOpenDoor(HashMap<String, Object> map) {
		super((EntityCreature)map.get("Object"));
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.lDebug("Modchu_EntityAIRestrictOpenDoor init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IEntityAIRestrictOpenDoorMaster ? (Modchu_IEntityAIRestrictOpenDoorMaster) instance : null;
	}

	@Override
	public boolean shouldExecute() {
		return master != null ? master.shouldExecute() : false;
	}

	public boolean superShouldExecute() {
		return false;
	}

	@Override
	public boolean continueExecuting() {
		return master != null ? master.continueExecuting() : super.continueExecuting();
	}

	public boolean superContinueExecuting() {
		return super.continueExecuting();
	}

	@Override
	public boolean isInterruptible() {
		return master != null ? master.isInterruptible() : super.isInterruptible();
	}

	public boolean superIsInterruptible() {
		return super.isInterruptible();
	}

	@Override
	public void startExecuting() {
		if (master != null) master.startExecuting();
		else super.startExecuting();
	}

	public void superStartExecuting() {
		super.startExecuting();
	}

	@Override
	public void resetTask() {
		if (master != null) master.resetTask();
		else super.resetTask();
	}

	public void superResetTask() {
		super.resetTask();
	}

	@Override
	public void updateTask() {
		if (master != null) master.updateTask();
		else super.updateTask();
	}

	public void superUpdateTask() {
		super.updateTask();
	}

	@Override
	public void setMutexBits(int par1) {
		if (master != null) master.setMutexBits(par1);
		else super.setMutexBits(par1);
	}

	public void superSetMutexBits(int par1) {
		super.setMutexBits(par1);
	}

	@Override
	public int getMutexBits() {
		return master != null ? master.getMutexBits() : super.getMutexBits();
	}

	public int superGetMutexBits() {
		return super.getMutexBits();
	}

}
