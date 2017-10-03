package modchu.lib.forge.mc220_222;

import java.util.HashMap;

public class Modchu_EntityAIWatchClosest2 extends modchu.lib.forge.mc164_222.Modchu_EntityAIWatchClosest2 {

	public Modchu_EntityAIWatchClosest2(HashMap<String, Object> map) {
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
