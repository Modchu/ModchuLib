package modchu.lib.forge.mc189_222;

import java.util.HashMap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityLookHelper;
import modchu.lib.Modchu_IEntityLookHelperMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityLookHelper;

public class Modchu_EntityLookHelper extends modchu.lib.forge.mc164_222.Modchu_EntityLookHelper {

	public Modchu_EntityLookHelper(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public boolean getIsLooking() {
		return master != null ? master.getIsLooking() : super.getIsLooking();
	}

	@Override
	public boolean superGetIsLooking() {
		return super.getIsLooking();
	}

	@Override
	public double getLookPosX() {
		return master != null ? master.getLookPosX() : super.getLookPosX();
	}

	@Override
	public double superGetLookPosX() {
		return super.getLookPosX();
	}

	@Override
	public double getLookPosY() {
		return master != null ? master.getLookPosY() : super.getLookPosY();
	}

	@Override
	public double superGetLookPosY() {
		return super.getLookPosY();
	}

	@Override
	public double getLookPosZ() {
		return master != null ? master.getLookPosZ() : super.getLookPosZ();
	}

	@Override
	public double superGetLookPosZ() {
		return super.getLookPosZ();
	}

}
