package modchu.lib;

import modchu.lib.characteristic.Modchu_LayerHeldItem;

public class Modchu_LayerHeldItemMasterBasis implements Modchu_ILayerHeldItemMaster  {
	public Modchu_LayerHeldItem base;

	public Modchu_LayerHeldItemMasterBasis(Object modchu_LayerHeldItem) {
		base = (Modchu_LayerHeldItem) modchu_LayerHeldItem;
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
