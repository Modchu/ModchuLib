package modchu.lib.forge.mc220_221;

import java.util.HashMap;

public class Modchu_EntityAISwimming extends modchu.lib.forge.mc164_221.Modchu_EntityAISwimming {

	public Modchu_EntityAISwimming(HashMap<String, Object> map) {
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
