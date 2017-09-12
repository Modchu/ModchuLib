package modchu.lib.forge.mc180_212;

import java.util.HashMap;

public class Modchu_EntityAINearestAttackableTarget extends modchu.lib.forge.mc180_221.Modchu_EntityAINearestAttackableTarget {

	public Modchu_EntityAINearestAttackableTarget(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public boolean continueExecuting() {
		return master != null ? master.shouldContinueExecuting() : super.continueExecuting();
	}

	@Override
	public boolean superShouldContinueExecuting() {
		return super.continueExecuting();
	}

}
