package modchu.lib.forge.mc190_221;

import java.util.HashMap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_ILayerCustomHead;
import modchu.lib.Modchu_ILayerCustomHeadMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.layers.LayerCustomHead;
import net.minecraft.entity.EntityLivingBase;

public class Modchu_LayerCustomHead extends LayerCustomHead implements Modchu_ILayerCustomHead {
	public Modchu_ILayerCustomHeadMaster master;

	public Modchu_LayerCustomHead(HashMap<String, Object> map) {
		super((ModelRenderer) map.get("Object"));
		Modchu_Debug.lDebug("Modchu_LayerCustomHead init");
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		Modchu_Debug.mDebug("Modchu_LayerCustomHead init instance="+instance);
		master = instance instanceof Modchu_ILayerCustomHeadMaster ? (Modchu_ILayerCustomHeadMaster) instance : null;
	}

	@Override
	public void doRenderLayer(EntityLivingBase entityLivingBase, float f, float f1, float f2, float f3, float f4, float f5, float f6) {
		if (master != null) master.doRenderLayer(entityLivingBase, f, f1, f2, f3, f4, f5, f6);
		else super.doRenderLayer(entityLivingBase, f, f1, f2, f3, f4, f5, f6);
	}

	public void superDoRenderLayer(Object entityLivingBase, float f, float f1, float f2, float f3, float f4, float f5, float f6) {
		super.doRenderLayer((EntityLivingBase) entityLivingBase, f, f1, f2, f3, f4, f5, f6);
	}

	@Override
	public boolean shouldCombineTextures() {
		return master != null ? master.shouldCombineTextures() : super.shouldCombineTextures();
	}

	public boolean superShouldCombineTextures() {
		return super.shouldCombineTextures();
	}

}
