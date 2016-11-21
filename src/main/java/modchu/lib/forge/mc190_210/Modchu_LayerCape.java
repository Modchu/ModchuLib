package modchu.lib.forge.mc190_210;

import java.util.HashMap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_ILayerCape;
import modchu.lib.Modchu_ILayerCapeMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerCape;
import net.minecraft.entity.EntityLivingBase;

public class Modchu_LayerCape extends LayerCape implements Modchu_ILayerCape {
	public Modchu_ILayerCapeMaster master;

	public Modchu_LayerCape(HashMap<String, Object> map) {
		super((RenderPlayer) map.get("Object"));
		Modchu_Debug.lDebug("Modchu_LayerCape init");
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		Modchu_Debug.mDebug("Modchu_LayerCape init instance="+instance);
		master = instance instanceof Modchu_ILayerCapeMaster ? (Modchu_ILayerCapeMaster) instance : null;
	}

	@Override
	public void doRenderLayer(AbstractClientPlayer abstractClientPlayer, float f, float f1, float f2, float f3, float f4, float f5, float f6) {
		if (master != null) master.doRenderLayer(abstractClientPlayer, f, f1, f2, f3, f4, f5, f6);
		else super.doRenderLayer(abstractClientPlayer, f, f1, f2, f3, f4, f5, f6);
	}

	@Override
	public void superDoRenderLayer(Object abstractClientPlayer, float f, float f1, float f2, float f3, float f4, float f5, float f6) {
		super.doRenderLayer((AbstractClientPlayer) abstractClientPlayer, f, f1, f2, f3, f4, f5, f6);
	}

	@Override
	public boolean shouldCombineTextures() {
		return master != null ? master.shouldCombineTextures() : super.shouldCombineTextures();
	}

	@Override
	public boolean superShouldCombineTextures() {
		return super.shouldCombineTextures();
	}


}
