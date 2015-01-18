package modchu.lib.characteristic;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_ILayerArmorBaseMaster;
import modchu.lib.Modchu_ILayerHeldItemMaster;
import modchu.lib.Modchu_Reflect;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.EntityLivingBase;

public class Modchu_LayerHeldItem extends LayerHeldItem {
	public static Modchu_ILayerHeldItemMaster master;

	public Modchu_LayerHeldItem(Class masterClass, Object rendererLivingEntity) {
		super(rendererLivingEntity != null
				&& rendererLivingEntity instanceof RendererLivingEntity ? (RendererLivingEntity) rendererLivingEntity : null);
		Modchu_Debug.lDebug("Modchu_LayerHeldItem init");
		Object instance = Modchu_Reflect.newInstance(masterClass, new Class[]{ Object.class }, new Object[]{ this });
		Modchu_Debug.mDebug("Modchu_LayerHeldItem init instance="+instance);
		master = instance instanceof Modchu_ILayerHeldItemMaster ? (Modchu_ILayerHeldItemMaster) instance : null;
	}

	@Override
	public void doRenderLayer(EntityLivingBase entityLivingBase, float p_177141_2_, float p_177141_3_, float p_177141_4_, float p_177141_5_, float p_177141_6_, float p_177141_7_, float p_177141_8_) {
		if (master != null) master.doRenderLayer(entityLivingBase, p_177141_2_, p_177141_3_, p_177141_4_, p_177141_5_, p_177141_6_, p_177141_7_, p_177141_8_);
		else super.doRenderLayer(entityLivingBase, p_177141_2_, p_177141_3_, p_177141_4_, p_177141_5_, p_177141_6_, p_177141_7_, p_177141_8_);
	}

	public void superDoRenderLayer(Object entityLivingBase, float p_177141_2_, float p_177141_3_, float p_177141_4_, float p_177141_5_, float p_177141_6_, float p_177141_7_, float p_177141_8_) {
		super.doRenderLayer((EntityLivingBase) entityLivingBase, p_177141_2_, p_177141_3_, p_177141_4_, p_177141_5_, p_177141_6_, p_177141_7_, p_177141_8_);
	}

	@Override
	public boolean shouldCombineTextures() {
		return master != null ? master.shouldCombineTextures() : super.shouldCombineTextures();
	}

	public boolean superShouldCombineTextures() {
		return super.shouldCombineTextures();
	}

}
