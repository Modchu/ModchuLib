package modchu.lib.forge.mc220;

import java.util.HashMap;

public class Modchu_EntityAIOpenDoor extends modchu.lib.forge.mc164_220.Modchu_EntityAIOpenDoor {

	public Modchu_EntityAIOpenDoor(HashMap<String, Object> map) {
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
