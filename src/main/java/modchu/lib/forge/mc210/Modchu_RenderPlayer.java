package modchu.lib.forge.mc210;

import java.util.HashMap;

import modchu.lib.Modchu_CastHelper;
import modchu.lib.Modchu_Main;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;

public class Modchu_RenderPlayer extends modchu.lib.forge.mc190_222.Modchu_RenderPlayer {

	public Modchu_RenderPlayer(HashMap<String, Object> map) {
		super(map);
	}

	// 210~分離
	@Override
	public boolean superRemoveLayer(Object layerRenderer) {
		return layerRenderers.remove((LayerRenderer) layerRenderer);
	}
	// 212~分離
	@Override
	public void rotateCorpse(AbstractClientPlayer var1, float var2, float var3, float var4) {
		String modchuLibEventName = "modchu_RenderPlayerRotatePlayer";
		boolean isCanceled = false;
		if (Modchu_Main.modchuLibEvent(modchuLibEventName)) {
			boolean flag = true;
			Object[] o = Modchu_Main.modchuLibEvent(modchuLibEventName, new Object[]{ var1, var2, var3, var4 });
			isCanceled = o != null
					&& o.length > 0 ? Modchu_CastHelper.Boolean(o[0]) : false;
			if (o != null
					&& o.length > 1) {
				var1 = (AbstractClientPlayer) o[1];
				if (o.length > 2) var2 = Modchu_CastHelper.Float(o[2]);
				if (o.length > 3) var3 = Modchu_CastHelper.Float(o[3]);
				if (o.length > 4) var4 = Modchu_CastHelper.Float(o[4]);
			}
		}
		if (!isCanceled) {
			if (master != null) master.applyRotations(var1, var2, var3, var4);
		}
	}

	@Override
	public void superApplyRotations(Object par1EntityLivingBase, float par2, float par3, float par4) {
		super.rotateCorpse((AbstractClientPlayer) par1EntityLivingBase, par2, par3, par4);
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
		superBindEntityTexture(entity);
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
	public void superFunc_96449_a(Object entityLivingBase, double par2, double par4, double par6, String par8Str, float par9, double par10) {
	}

	@Override
	public void superRotateCorpse(Object entityLivingBase, float par2, float par3, float par4) {
	}

	@Override
	public boolean superIsVisible(Object abstractClientPlayer) {
		return false;
	}

}
