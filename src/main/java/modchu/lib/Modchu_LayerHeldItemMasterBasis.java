package modchu.lib;

import java.util.HashMap;

public class Modchu_LayerHeldItemMasterBasis implements Modchu_ILayerHeldItemMaster  {
	public Modchu_ILayerHeldItem base;

	public Modchu_LayerHeldItemMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_ILayerHeldItem) map.get("base");
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
