package modchu.lib;

import modchu.lib.characteristic.Modchu_LayerCustomHead;

public class Modchu_LayerCustomHeadMasterBasis implements Modchu_ILayerCustomHeadMaster  {
	public Modchu_LayerCustomHead base;

	public Modchu_LayerCustomHeadMasterBasis(Object modchu_LayerCustomHead) {
		base = (Modchu_LayerCustomHead) modchu_LayerCustomHead;
	}

	@Override
	public void doRenderLayer(Object entityLivingBase, float f, float f1, float f2, float f3, float f4, float f5, float f6) {
		base.superDoRenderLayer(entityLivingBase, f, f1, f2, f3, f4, f5, f6);
	}

	@Override
	public boolean shouldCombineTextures() {
		return base.superShouldCombineTextures();
	}

}
