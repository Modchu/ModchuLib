package modchu.lib.forge.mc190;

import java.util.HashMap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_ILayerElytra;
import modchu.lib.Modchu_ILayerElytraMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerElytra;
import net.minecraft.entity.EntityLivingBase;

public class Modchu_LayerElytra extends LayerElytra implements Modchu_ILayerElytra {
	public Modchu_ILayerElytraMaster master;

	public Modchu_LayerElytra(HashMap<String, Object> map) {
		super((RenderPlayer) map.get("Object"));
		Modchu_Debug.lDebug("Modchu_LayerElytra init");
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		Modchu_Debug.mDebug("Modchu_LayerElytra init instance="+instance);
		master = instance instanceof Modchu_ILayerElytraMaster ? (Modchu_ILayerElytraMaster) instance : null;
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
