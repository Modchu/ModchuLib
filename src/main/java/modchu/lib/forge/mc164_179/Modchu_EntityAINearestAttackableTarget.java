package modchu.lib.forge.mc164_179;

import java.util.HashMap;

import modchu.lib.Modchu_IContainerPlayerMaster;
import modchu.lib.Modchu_IEntityAIBase;
import modchu.lib.Modchu_IEntityAIBaseMaster;
import modchu.lib.Modchu_IEntityAINearestAttackableTarget;
import modchu.lib.Modchu_IEntityAINearestAttackableTargetMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;

public class Modchu_EntityAINearestAttackableTarget extends EntityAINearestAttackableTarget implements Modchu_IEntityAINearestAttackableTarget {
	public Modchu_IEntityAINearestAttackableTargetMaster master;
	private boolean enabled;

	public Modchu_EntityAINearestAttackableTarget(HashMap<String, Object> map) {
		super((EntityCreature)map.get("Object"), (Class)map.get("Class"), (Integer)map.get("Integer"), (Boolean)map.get("Boolean"), map.containsKey("Boolean1") ? (Boolean)map.get("Boolean1") : false, (IEntitySelector)(map.containsKey("Object1") ? map.get("Object1") : null));
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.lDebug("Modchu_EntityAINearestAttackableTarget init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IEntityAINearestAttackableTargetMaster ? (Modchu_IEntityAINearestAttackableTargetMaster) instance : null;
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
