package modchu.lib.forge.mc164_212;

import java.util.HashMap;

public class Modchu_EntityAISit extends modchu.lib.forge.mc164_220.Modchu_EntityAISit {

	public Modchu_EntityAISit(HashMap<String, Object> map) {
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
