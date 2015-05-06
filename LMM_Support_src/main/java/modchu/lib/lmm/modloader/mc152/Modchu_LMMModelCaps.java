package modchu.lib.lmm.modloader.mc152;

import modchu.lib.Modchu_EntityCapsBase;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.MMM_EntityCaps;

public class Modchu_LMMModelCaps extends MMM_EntityCaps {
	protected Modchu_EntityCapsBase master;

	public Modchu_LMMModelCaps(EntityLiving pOwner) {
		super(pOwner);
	}

	public Modchu_LMMModelCaps(Modchu_EntityCapsBase entityCapsBase) {
		super((EntityLiving) entityCapsBase.getCapsValue(caps_Entity));
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