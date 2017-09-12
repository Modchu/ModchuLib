package modchu.lib.forge.mc164_212;

import java.util.HashMap;

public class Modchu_EntityAIBase extends modchu.lib.forge.mc164_221.Modchu_EntityAIBase {

	public Modchu_EntityAIBase(HashMap<String, Object> map) {
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
