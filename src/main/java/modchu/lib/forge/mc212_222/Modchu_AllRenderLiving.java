package modchu.lib.forge.mc212_222;

import java.util.HashMap;

import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;

public abstract class Modchu_AllRenderLiving extends modchu.lib.forge.mc190_222.Modchu_AllRenderLiving {

	public Modchu_AllRenderLiving(HashMap<String, Object> map) {
		super(map);
	}
	// 210~分離
	@Override
	public boolean superRemoveLayer(Object layerRenderer) {
		return layerRenderers.remove((LayerRenderer) layerRenderer);
	}
	// 212~分離
	@Override
	public void superApplyRotations(Object entityLivingBase, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
		super.applyRotations((EntityLivingBase) entityLivingBase, p_77043_2_, p_77043_3_, p_77043_4_);
	}

}
