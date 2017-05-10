package modchu.lib.modloader.mc162;

import java.util.HashMap;

import modchu.lib.Modchu_IEntityAILookIdle;
import modchu.lib.Modchu_IEntityAILookIdleMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.src.EntityAILookIdle;
import net.minecraft.src.EntityLiving;

public class Modchu_EntityAILookIdle extends EntityAILookIdle implements Modchu_IEntityAILookIdle {
	public Modchu_IEntityAILookIdleMaster master;
	private boolean enabled;

	public Modchu_EntityAILookIdle(HashMap<String, Object> map) {
		super((EntityLiving)map.get("Object"));
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.lDebug("Modchu_EntityAILookIdle2 init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IEntityAILookIdleMaster ? (Modchu_IEntityAILookIdleMaster) instance : null;
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
