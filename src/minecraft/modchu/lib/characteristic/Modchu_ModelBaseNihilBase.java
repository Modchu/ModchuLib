package modchu.lib.characteristic;

import modchu.model.ModchuModel_ModelDataBase;
import modchu.model.ModchuModel_ModelDataMaster;
import net.minecraft.src.Entity;
import net.minecraft.src.ModelBase;

public class Modchu_ModelBaseNihilBase extends ModelBase {

	public boolean isAlphablend;
	public boolean isModelAlphablend;
	public Modchu_IEntityCapsBase capsLink;
	public int lighting;
	protected Modchu_IEntityCapsBase tempEntityCaps;
	protected boolean isRendering;
	/**
	 * レンダリングが実行された回数。
	 * ダメージ時などの対策。
	 */
	public int renderCount;

	public void showAllParts() {
		showAllParts(tempEntityCaps);
	}

	public void showAllParts(Modchu_IEntityCapsBase entityCaps) {
	}

	@Override
	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		renderCount++;
	}

	public Modchu_IEntityCapsBase getModchu_IEntityCapsBase(Object entityLivingBase) {
		tempEntityCaps = (Modchu_IEntityCapsBase) (entityLivingBase instanceof ModchuModel_ModelDataBase ? entityLivingBase : ModchuModel_ModelDataMaster.instance.getPlayerData(entityLivingBase));
		return tempEntityCaps;
	}
}
