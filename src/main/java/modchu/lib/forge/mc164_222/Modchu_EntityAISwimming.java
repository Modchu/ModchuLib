package modchu.lib.forge.mc164_222;

import java.util.HashMap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityAISwimming;
import modchu.lib.Modchu_IEntityAISwimmingMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.passive.EntityTameable;

public abstract class Modchu_EntityAISwimming extends EntityAISwimming implements Modchu_IEntityAISwimming {
	public Modchu_IEntityAISwimmingMaster master;
	private boolean enabled;

	public Modchu_EntityAISwimming(HashMap<String, Object> map) {
		super((EntityTameable) map.get("Object"));
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.lDebug("Modchu_EntityAISwimming init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IEntityAISwimmingMaster ? (Modchu_IEntityAISwimmingMaster) instance : null;
		setEnabled(true);
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public void setEnabled(boolean b) {
		enabled = b;
	}

	@Override
	public boolean shouldExecute() {
		//Modchu_Debug.mDebug("Modchu_EntityAISwimming shouldExecute master="+master);
		return master != null ? master.shouldExecute() : superShouldExecute();
	}

	public boolean superShouldExecute() {
		return isEnabled() ? super.shouldExecute() : false;
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
		else superStartExecuting();
	}

	public void superStartExecuting() {
		if (isEnabled()) super.startExecuting();
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
