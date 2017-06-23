package modchu.lib.forge.mc220;

import java.util.HashMap;

public class Modchu_EntityAIWatchClosest extends modchu.lib.forge.mc164_220.Modchu_EntityAIWatchClosest {

	public Modchu_EntityAIWatchClosest(HashMap<String, Object> map) {
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
