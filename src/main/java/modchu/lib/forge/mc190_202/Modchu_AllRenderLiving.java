package modchu.lib.forge.mc190_202;

import java.util.HashMap;

import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;

public class Modchu_AllRenderLiving extends modchu.lib.forge.mc190_222.Modchu_AllRenderLiving {

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
		modchu.lib.forge.mc190_222.Modchu_RenderLiving render = renderMapGet(entityLiving);
		return render != null ? render.removeLayer(layerRenderer) : super.removeLayer(layerRenderer);
	}

	@Override
	public void superApplyRotations(Object entityLivingBase, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
		super.rotateCorpse((EntityLivingBase) entityLivingBase, p_77043_2_, p_77043_3_, p_77043_4_);
	}

	// 190~212共通コピペ　↓
	// 180~212
	@Override
	public void setLightmap(EntityLiving entityLiving, float f) {
		modchu.lib.forge.mc190_222.Modchu_RenderLiving render = renderMapGet(entityLiving);
		if (render != null) render.setLightmap(entityLiving, f);
		else super.setLightmap(entityLiving, f);
	}
	// 190~212共通コピペ　↑

}
