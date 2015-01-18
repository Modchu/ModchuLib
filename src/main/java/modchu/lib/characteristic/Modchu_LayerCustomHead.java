package modchu.lib.characteristic;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_ILayerCustomHeadMaster;
import modchu.lib.Modchu_Reflect;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.layers.LayerCustomHead;
import net.minecraft.entity.EntityLivingBase;

public class Modchu_LayerCustomHead extends LayerCustomHead {
	public static Modchu_ILayerCustomHeadMaster master;

	public Modchu_LayerCustomHead(Class masterClass, Object modelRenderer) {
		super(modelRenderer != null ? (ModelRenderer) modelRenderer : null);
		Modchu_Debug.lDebug("Modchu_LayerCustomHead init");
		Object instance = Modchu_Reflect.newInstance(masterClass, new Class[]{ Object.class }, new Object[]{ this });
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
