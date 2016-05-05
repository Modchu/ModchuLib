package modchu.lib;

import java.util.HashMap;

public class Modchu_LayerCapeMasterBasis implements Modchu_ILayerCapeMaster  {
	public Modchu_ILayerCape base;

	public Modchu_LayerCapeMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_ILayerCape) map.get("base");
	}

	@Override
	public void doRenderLayer(Object abstractClientPlayer, float f, float f1, float f2, float f3, float f4, float f5, float f6) {
		base.superDoRenderLayer(abstractClientPlayer, f, f1, f2, f3, f4, f5, f6);
	}

	@Override
	public boolean shouldCombineTextures() {
		return base.superShouldCombineTextures();
	}

}
