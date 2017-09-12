package modchu.lib.forge.mc164_212;

import java.util.HashMap;

public class Modchu_EntityAILookIdle extends modchu.lib.forge.mc164_221.Modchu_EntityAILookIdle {

	public Modchu_EntityAILookIdle(HashMap<String, Object> map) {
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
