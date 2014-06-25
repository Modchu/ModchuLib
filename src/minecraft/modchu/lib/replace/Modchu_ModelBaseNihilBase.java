package modchu.lib.replace;

import modchu.lib.characteristic.recompileonly.Modchu_IModelBaseModchuModel;
import modchu.model.ModchuModel_IModelCaps;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.Entity;

public class Modchu_ModelBaseNihilBase extends ModelBase {

	public RendererLivingEntity rendererLivingEntity;

	public boolean isAlphablend;
	public boolean isModelAlphablend;
	public Modchu_IModelBaseModchuModel capsLink;
	public int lighting;
	protected ModchuModel_IModelCaps entityCaps;
	protected boolean isRendering;
	/**
	 * レンダリングが実行された回数。
	 * ダメージ時などの対策。
	 */
	public int renderCount;


//	@Override
//	public ModelRenderer getRandomModelBox(Random par1Random) {
//		return modelArmorInner.getRandomModelBox(par1Random);
//	}

	public void showAllParts() {
	}

	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4,
			float par5, float par6, float par7) {
		renderCount++;
	}

}
