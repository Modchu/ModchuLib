package modchu.lib.forge.mc164_220;

import java.util.HashMap;

import modchu.lib.Modchu_IEntityAIHurtByTarget;
import modchu.lib.Modchu_IEntityAIHurtByTargetMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;

public abstract class Modchu_EntityAIHurtByTarget extends EntityAIHurtByTarget implements Modchu_IEntityAIHurtByTarget {
	public Modchu_IEntityAIHurtByTargetMaster master;
	private boolean enabled;

	public Modchu_EntityAIHurtByTarget(HashMap<String, Object> map) {
		super((EntityCreature) map.get("Object"), (Boolean)map.get("Boolean"));
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.lDebug("Modchu_EntityAIHurtByTarget init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IEntityAIHurtByTargetMaster ? (Modchu_IEntityAIHurtByTargetMaster) instance : null;
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

	@Override
	protected double getTargetDistance() {
		return master != null ? master.getTargetDistance() : super.getTargetDistance();
	}

	public double superGetTargetDistance() {
		return super.getTargetDistance();
	}

	@Override
	protected boolean isSuitableTarget(EntityLivingBase entityLivingBase, boolean par2) {
		return master != null ? master.isSuitableTarget(entityLivingBase, par2) : super.isSuitableTarget(entityLivingBase, par2);
	}

	public boolean superIsSuitableTarget(Object entityLivingBase, boolean par2) {
		return super.isSuitableTarget((EntityLivingBase) entityLivingBase, par2);
	}

}
