package modchu.lib.forge.mc190_202;

import java.util.HashMap;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class Modchu_RenderPlayer extends modchu.lib.forge.mc190_221.Modchu_RenderPlayer {

	public Modchu_RenderPlayer(HashMap<String, Object> map) {
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
	protected void rotateCorpse(AbstractClientPlayer abstractClientPlayer, float p_77043_2_, float p_77043_3_, float partialTicks) {
		if (master != null) master.applyRotations(abstractClientPlayer, p_77043_2_, p_77043_3_, partialTicks);
		else super.rotateCorpse(abstractClientPlayer, p_77043_2_, p_77043_3_, partialTicks);
	}

	@Override
	public void superApplyRotations(Object entityLivingBase, float par2, float par3, float par4) {
		super.rotateCorpse((AbstractClientPlayer) entityLivingBase, par2, par3, par4);
	}

	@Override
	public void superFunc_96449_a(Object entityLivingBase, double par2, double par4, double par6, String par8Str, float par9, double par10) {
	}

	@Override
	public void superRotateCorpse(Object entityLivingBase, float par2, float par3, float par4) {
		super.rotateCorpse((AbstractClientPlayer) entityLivingBase, par2, par3, par4);
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
	public void superFunc_130220_b(Object abstractClientPlayer, int par2, float par3) {
	}

	@Override
	public void superFunc_130009_a(Object abstractClientPlayer, double par2, double par4, double par6, float par8, float par9) {
	}

	@Override
	public Object superFunc_110817_a(Object abstractClientPlayer) {
		return null;
	}

	@Override
	public void superRenderSpecials(Object abstractClientPlayer, float par2) {
	}

	@Override
	public void superRenderPlayerScale(Object abstractClientPlayer, float par2) {
	}

	@Override
	public void superFunc_96450_a(Object abstractClientPlayer, double par2, double par4, double par6, String par8Str, float par9, double par10) {
	}

	@Override
	public void superFunc_98191_a(Object entityPlayer) {
	}

	@Override
	public void superFunc_82439_b(Object entityPlayer, int par2, float par3) {
	}

	@Override
	public void superRenderPlayer(Object entityPlayer, double par2, double par4, double par6, float par8, float par9) {
	}

	@Override
	public void superFunc_98190_a(Object entityLiving) {
	}

	@Override
	public boolean superIsVisible(Object abstractClientPlayer) {
		return false;
	}

}
