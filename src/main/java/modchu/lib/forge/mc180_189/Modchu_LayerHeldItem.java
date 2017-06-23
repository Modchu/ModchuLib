package modchu.lib.forge.mc180_189;

import java.util.HashMap;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_ILayerHeldItem;
import modchu.lib.Modchu_ILayerHeldItemMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.EntityLivingBase;

public class Modchu_LayerHeldItem extends LayerHeldItem implements Modchu_ILayerHeldItem {
	public Modchu_ILayerHeldItemMaster master;

	public Modchu_LayerHeldItem(HashMap<String, Object> map) {
		super((RendererLivingEntity) map.get("Object"));
		Modchu_Debug.lDebug("Modchu_LayerHeldItem init");
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		Modchu_Debug.mDebug("Modchu_LayerHeldItem init instance="+instance);
		master = instance instanceof Modchu_ILayerHeldItemMaster ? (Modchu_ILayerHeldItemMaster) instance : null;
	}

	@Override
	public void doRenderLayer(EntityLivingBase entityLivingBase, float p_177141_2_, float p_177141_3_, float p_177141_4_, float p_177141_5_, float p_177141_6_, float p_177141_7_, float p_177141_8_) {
		if (master != null) master.doRenderLayer(entityLivingBase, p_177141_2_, p_177141_3_, p_177141_4_, p_177141_5_, p_177141_6_, p_177141_7_, p_177141_8_);
		else super.doRenderLayer(entityLivingBase, p_177141_2_, p_177141_3_, p_177141_4_, p_177141_5_, p_177141_6_, p_177141_7_, p_177141_8_);
	}

	@Override
	public void superDoRenderLayer(Object entityLivingBase, float p_177141_2_, float p_177141_3_, float p_177141_4_, float p_177141_5_, float p_177141_6_, float p_177141_7_, float p_177141_8_) {
		super.doRenderLayer((EntityLivingBase) entityLivingBase, p_177141_2_, p_177141_3_, p_177141_4_, p_177141_5_, p_177141_6_, p_177141_7_, p_177141_8_);
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
