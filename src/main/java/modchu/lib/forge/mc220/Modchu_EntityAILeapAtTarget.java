package modchu.lib.forge.mc220;

import java.util.HashMap;

public class Modchu_EntityAILeapAtTarget extends modchu.lib.forge.mc164_220.Modchu_EntityAILeapAtTarget {

	public Modchu_EntityAILeapAtTarget(HashMap<String, Object> map) {
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
