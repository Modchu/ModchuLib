package modchu.lib.forge.mc190_202;

import java.util.HashMap;

import modchu.lib.forge.mc190_210.Modchu_RenderLiving;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLiving;

public class Modchu_AllRenderLiving extends modchu.lib.forge.mc190_210.Modchu_AllRenderLiving {

	public Modchu_AllRenderLiving(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public boolean removeLayer(LayerRenderer layerRenderer) {
		return super.removeLayer(layerRenderer);
	}

	@Override
	public boolean superRemoveLayer(Object layerRenderer) {
		return super.removeLayer((LayerRenderer) layerRenderer);
	}

	protected boolean removeLayer(EntityLiving entityLiving, LayerRenderer layerRenderer) {
		Modchu_RenderLiving render = renderMapGet(entityLiving);
		return render != null ? render.removeLayer(layerRenderer) : super.removeLayer(layerRenderer);
	}

}
