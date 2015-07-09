package modchu.lib.lmm.common.mc172_180;

import java.util.HashMap;

import mmmlibx.lib.multiModel.model.mc162.ModelBase;
import mmmlibx.lib.multiModel.model.mc162.ModelRenderer;
import modchu.lib.Modchu_GlStateManager;

public class Modchu_LMMXNDummyModelRenderer extends ModelRenderer {

	public Modchu_LMMXNDummyModelRenderer(HashMap map) {
		super((ModelBase) map.get("Object"));
	}

	public void postRender(float par1) {
		float f = 0.0000000001F;
		Modchu_GlStateManager.scale(f, f, f);
		float f1 = 10000F;
		Modchu_GlStateManager.translate(f1, f1, f1);
	}
}
