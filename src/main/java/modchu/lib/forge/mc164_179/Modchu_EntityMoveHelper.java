package modchu.lib.forge.mc164_179;

import java.util.HashMap;

import modchu.lib.Modchu_AS;

public class Modchu_EntityMoveHelper extends modchu.lib.forge.mc164_222.Modchu_EntityMoveHelper {

	public Modchu_EntityMoveHelper(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public float superLimitAngle(float sourceAngle, float targetAngle, float maximumChange) {
		return 0.0F;
	}

	@Override
	public double superGetX() {
		return Modchu_AS.getDouble("EntityMoveHelper", "posX", this);
	}

	@Override
	public double superGetY() {
		return Modchu_AS.getDouble("EntityMoveHelper", "posY", this);
	}

	@Override
	public double superGetZ() {
		return Modchu_AS.getDouble("EntityMoveHelper", "posZ", this);
	}

	@Override
	public void superStrafe(float forward, float strafe) {
	}

	@Override
	public void superRead(Object entityMoveHelper) {
	}

}
