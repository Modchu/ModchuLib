package modchu.lib.forge.mc210;

import java.util.HashMap;

import modchu.lib.forge.mc210.Modchu_RenderLiving;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLiving;

public class Modchu_AllRenderLiving extends modchu.lib.forge.mc190_210.Modchu_AllRenderLiving {

	public Modchu_AllRenderLiving(HashMap<String, Object> map) {
		super(map);
	}

	public boolean removeLayer(LayerRenderer layerRenderer) {
		return layerRenderers.remove(layerRenderer);
	}

	@Override
	public boolean superRemoveLayer(Object layerRenderer) {
		return layerRenderers.remove(layerRenderer);
	}

	protected boolean removeLayer(EntityLiving entityLiving, LayerRenderer layerRenderer) {
		Modchu_RenderLiving render = (Modchu_RenderLiving) renderMapGet(entityLiving);
		return render != null ? render.removeLayer(layerRenderer) : superRemoveLayer(layerRenderer);
	}

}
