package modchu.lib.forge.mc164_179;

import java.util.HashMap;

import modchu.lib.Modchu_AS;

public class Modchu_EntityLookHelper extends modchu.lib.forge.mc164_222.Modchu_EntityLookHelper {

	public Modchu_EntityLookHelper(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public boolean superGetIsLooking() {
		return Modchu_AS.getBoolean("EntityLookHelper", "isLooking", this);
	}

	@Override
	public double superGetLookPosX() {
		return Modchu_AS.getDouble("EntityLookHelper", "posX", this);
	}

	@Override
	public double superGetLookPosY() {
		return Modchu_AS.getDouble("EntityLookHelper", "posY", this);
	}

	@Override
	public double superGetLookPosZ() {
		return Modchu_AS.getDouble("EntityLookHelper", "posZ", this);
	}

}
