package modchu.lib.lmm.characteristic;

import java.util.Map;

import modchu.model.ModchuModel_ModelDataBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.src.MMM_EntityCaps;

public class Modchu_LMMEntityCaps extends MMM_EntityCaps {

	public ModchuModel_ModelDataBase base;

	public Modchu_LMMEntityCaps(EntityLivingBase pOwner) {
		super(pOwner);
	}

	public Modchu_LMMEntityCaps(ModchuModel_ModelDataBase modelDataBase, EntityLivingBase pOwner) {
		super(pOwner);
		base = modelDataBase;
	}

	@Override
	public Map<String, Integer> getModelCaps() {
		return base.getModelCaps();
	}

	public Map<String, Integer> superGetModelCaps() {
		return super.getModelCaps();
	}

	@Override
	public Object getCapsValue(int pIndex, Object... pArg) {
		return base.getCapsValue(pIndex, pArg);
	}

	public Object superGetCapsValue(int pIndex, Object... pArg) {
		return super.getCapsValue(pIndex, pArg);
	}

	@Override
	public boolean setCapsValue(int pIndex, Object... pArg) {
		return base.setCapsValue(pIndex, pArg);
	}

	public boolean superSetCapsValue(int pIndex, Object... pArg) {
		return super.setCapsValue(pIndex, pArg);
	}
}