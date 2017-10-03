package modchu.lib.forge.mc220_222;

import java.util.HashMap;

public class Modchu_EntityAISwimming extends modchu.lib.forge.mc164_222.Modchu_EntityAISwimming {

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
