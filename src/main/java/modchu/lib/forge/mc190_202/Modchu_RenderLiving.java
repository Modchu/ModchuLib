package modchu.lib.forge.mc190_202;

import java.util.HashMap;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;

public class Modchu_RenderLiving extends modchu.lib.forge.mc190_222.Modchu_RenderLiving {

	public Modchu_RenderLiving(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public boolean removeLayer(LayerRenderer layerRenderer) {
		return master != null ? master.removeLayer(layerRenderer) : super.removeLayer(layerRenderer);
	}

	@Override
	public boolean superRemoveLayer(Object layerRenderer) {
		return super.removeLayer((LayerRenderer) layerRenderer);
	}

	@Override
	public void superApplyRotations(Object entityLivingBase, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
		super.rotateCorpse((EntityLivingBase) entityLivingBase, p_77043_2_, p_77043_3_, p_77043_4_);
	}

	@Override
	public void superFunc_96449_a(Object entityLivingBase, double par2, double par4, double par6, String par8Str, float par9, double par10) {
		super.func_96449_a((EntityLivingBase) entityLivingBase, par2, par4, par6, par8Str, par9, par10);
	}

	@Override
	public void superRotateCorpse(Object entityLivingBase, float par2, float par3, float par4) {
		super.rotateCorpse((EntityLivingBase) entityLivingBase, par2, par3, par4);
	}

	@Override
	public float superRenderSwingProgress(Object entityLivingBase, float par2) {
		return 0.0F;
	}

	@Override
	public boolean superFunc_110813_b(Object entityLivingBase) {
		return false;
	}

	@Override
	public void superFunc_110777_b(Object entity) {
	}

	@Override
	public void rotateCorpse(EntityLivingBase entityLivingBase, float p_77043_2_, float p_77043_3_, float partialTicks) {
		if (master != null) master.rotateCorpse(entityLivingBase, p_77043_2_, p_77043_3_, partialTicks);
		else super.rotateCorpse(entityLivingBase, p_77043_2_, p_77043_3_, partialTicks);
	}

	@Override
	public void superSetLightmap(Object entityLiving) {
	}

	@Override
	public boolean superIsVisible(Object entityLivingBase) {
		return false;
	}

}
