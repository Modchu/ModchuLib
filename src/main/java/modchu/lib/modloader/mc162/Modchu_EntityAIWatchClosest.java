package modchu.lib.modloader.mc162;

import java.util.HashMap;

import modchu.lib.Modchu_IEntityAIWatchClosest;
import modchu.lib.Modchu_IEntityAIWatchClosestMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.src.EntityAIWatchClosest;
import net.minecraft.src.EntityLiving;

public class Modchu_EntityAIWatchClosest extends EntityAIWatchClosest implements Modchu_IEntityAIWatchClosest {
	public Modchu_IEntityAIWatchClosestMaster master;
	private boolean enabled;

	public Modchu_EntityAIWatchClosest(HashMap<String, Object> map) {
		super((EntityLiving)map.get("Object"), (Class)map.get("Class"), (Float)map.get("Float"), map.containsKey("Float1") ? (Float)map.get("Float1") : 0.02F);
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.lDebug("Modchu_EntityAIWatchClosest2 init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IEntityAIWatchClosestMaster ? (Modchu_IEntityAIWatchClosestMaster) instance : null;
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
		return master != null ? master.shouldExecute() : false;
	}

	@Override
	public boolean superShouldExecute() {
		return false;
	}

	@Override
	public boolean continueExecuting() {
		return master != null ? master.shouldContinueExecuting() : super.continueExecuting();
	}

	@Override
	public boolean superShouldContinueExecuting() {
		return super.continueExecuting();
	}

	@Override
	public boolean isInterruptible() {
		return master != null ? master.isInterruptible() : super.isInterruptible();
	}

	@Override
	public boolean superIsInterruptible() {
		return super.isInterruptible();
	}

	@Override
	public void startExecuting() {
		if (master != null) master.startExecuting();
		else superStartExecuting();
	}

	@Override
	public void superStartExecuting() {
		if (isEnabled()) super.startExecuting();
	}

	@Override
	public void resetTask() {
		if (master != null) master.resetTask();
		else super.resetTask();
	}

	@Override
	public void superResetTask() {
		super.resetTask();
	}

	@Override
	public void updateTask() {
		if (master != null) master.updateTask();
		else super.updateTask();
	}

	@Override
	public void superUpdateTask() {
		super.updateTask();
	}

	@Override
	public void setMutexBits(int par1) {
		if (master != null) master.setMutexBits(par1);
		else super.setMutexBits(par1);
	}

	@Override
	public void superSetMutexBits(int par1) {
		super.setMutexBits(par1);
	}

	@Override
	public int getMutexBits() {
		return master != null ? master.getMutexBits() : super.getMutexBits();
	}

	@Override
	public int superGetMutexBits() {
		return super.getMutexBits();
	}

}
