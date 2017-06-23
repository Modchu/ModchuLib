package modchu.lib.forge.mc164_212;

import java.util.HashMap;

public class Modchu_EntityAIHurtByTarget extends modchu.lib.forge.mc164_220.Modchu_EntityAIHurtByTarget {

	public Modchu_EntityAIHurtByTarget(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public boolean continueExecuting() {
		return master != null ? master.shouldContinueExecuting() : super.continueExecuting();
	}

	public boolean superShouldContinueExecuting() {
		return super.continueExecuting();
	}

}
