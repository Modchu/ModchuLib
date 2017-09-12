package modchu.lib.forge.mc220_221;

import java.util.HashMap;

public class Modchu_EntityAIPanic extends modchu.lib.forge.mc164_221.Modchu_EntityAIPanic {

	public Modchu_EntityAIPanic(HashMap<String, Object> map) {
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
