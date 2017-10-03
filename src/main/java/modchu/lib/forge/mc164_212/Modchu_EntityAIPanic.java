package modchu.lib.forge.mc164_212;

import java.util.HashMap;

public class Modchu_EntityAIPanic extends modchu.lib.forge.mc164_222.Modchu_EntityAIPanic {

	public Modchu_EntityAIPanic(HashMap<String, Object> map) {
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
