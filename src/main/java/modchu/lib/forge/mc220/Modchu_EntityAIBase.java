package modchu.lib.forge.mc220;

import java.util.HashMap;

public class Modchu_EntityAIBase extends modchu.lib.forge.mc164_220.Modchu_EntityAIBase {

	public Modchu_EntityAIBase(HashMap<String, Object> map) {
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
