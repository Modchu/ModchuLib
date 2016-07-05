package modchu.lib.lmm.common.mc190_202;

import java.util.HashMap;

import modchu.lib.Modchu_GlStateManager;
import net.blacklab.lmr.entity.maidmodel.ModelBase;
import net.blacklab.lmr.entity.maidmodel.ModelRenderer;

public class Modchu_LmrDummyModelRenderer extends ModelRenderer {

	public Modchu_LmrDummyModelRenderer(HashMap map) {
		super((ModelBase) map.get("Object"));
	}

	public void postRender(float par1) {
		float f = 0.0000000001F;
		Modchu_GlStateManager.scale(f, f, f);
		float f1 = 10000F;
		Modchu_GlStateManager.translate(f1, f1, f1);
	}
}
