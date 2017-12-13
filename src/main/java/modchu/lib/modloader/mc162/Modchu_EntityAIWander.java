package modchu.lib.modloader.mc162;

import java.util.HashMap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_EntityAISupport;
import modchu.lib.Modchu_IEntityAIWander;
import modchu.lib.Modchu_IEntityAIWanderMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.src.EntityAIWander;
import net.minecraft.src.EntityCreature;

public class Modchu_EntityAIWander extends EntityAIWander implements Modchu_IEntityAIWander {
	public Modchu_IEntityAIWanderMaster master;
	public EntityCreature entity;
	private boolean enabled;
	private Object water;

	public Modchu_EntityAIWander(HashMap<String, Object> map) {
		super((EntityCreature)map.get("Object"), (Double)map.get("Double"));
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.lDebug("Modchu_EntityAIWander init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IEntityAIWanderMaster ? (Modchu_IEntityAIWanderMaster) instance : null;
		setEnabled(true);
		entity = (EntityCreature) map.get("Object");
		int version = Modchu_Main.getMinecraftVersion();
		water = Modchu_AS.get("Material", version > 189 ? "WATER" : "water");
	}

	@Override
	public boolean setMoveLandPotision() {
		return Modchu_EntityAISupport.setMoveLandPotision(this, entity, water);
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
		return master != null ? master.shouldExecute() : super.shouldExecute();
	}

	@Override
	public boolean superShouldExecute() {
		return super.shouldExecute();
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
