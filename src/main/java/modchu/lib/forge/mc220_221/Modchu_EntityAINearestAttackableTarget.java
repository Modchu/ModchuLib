package modchu.lib.forge.mc220_221;

import java.util.HashMap;

public class Modchu_EntityAINearestAttackableTarget extends modchu.lib.forge.mc180_221.Modchu_EntityAINearestAttackableTarget {

	public Modchu_EntityAINearestAttackableTarget(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public boolean shouldContinueExecuting() {
		return master != null ? master.shouldContinueExecuting() : super.shouldContinueExecuting();
	}

	@Override
	public boolean superShouldContinueExecuting() {
		return super.shouldContinueExecuting();
	}

}
