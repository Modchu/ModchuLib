package modchu.lib.lmm.common.mc190_202;

import modchu.lib.Modchu_EntityCapsBase;
import net.blacklab.lmr.util.EntityCapsLiving;
import net.minecraft.entity.EntityLivingBase;

public class Modchu_LmrModelCaps extends EntityCapsLiving {
	protected Modchu_EntityCapsBase master;

	public Modchu_LmrModelCaps(EntityLivingBase pOwner) {
		super(pOwner);
	}

	public Modchu_LmrModelCaps(Modchu_EntityCapsBase entityCapsBase) {
		super((EntityLivingBase) entityCapsBase.getCapsValue(caps_Entity));
		master = entityCapsBase;
	}

	@Override
	public Object getCapsValue(int pIndex, Object... pArg) {
		Object o = master != null ? master.getCapsValue(pIndex, pArg) : null;
		if (o != null) return o;
		return super.getCapsValue(pIndex, pArg);
	}

	@Override
	public boolean setCapsValue(int pIndex, Object... pArg) {
		return master != null
				&& master.setCapsValue(pIndex, pArg) ? true : super.setCapsValue(pIndex, pArg);
	}

	public Modchu_EntityCapsBase getMaster() {
		return master;
	}

	public void setMaster(Modchu_EntityCapsBase entityCapsBase) {
		master = entityCapsBase;
	}
}