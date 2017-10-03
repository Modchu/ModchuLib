package modchu.lib.forge.mc164_212;

import java.util.HashMap;

public class Modchu_EntityAILeapAtTarget extends modchu.lib.forge.mc164_222.Modchu_EntityAILeapAtTarget {

	public Modchu_EntityAILeapAtTarget(HashMap<String, Object> map) {
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
