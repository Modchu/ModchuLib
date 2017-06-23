package modchu.lib.forge.mc212_220;

import java.util.HashMap;

import modchu.lib.Modchu_CastHelper;
import modchu.lib.Modchu_Main;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

public abstract class Modchu_RenderPlayer extends modchu.lib.forge.mc190_220.Modchu_RenderPlayer {

	public Modchu_RenderPlayer(HashMap<String, Object> map) {
		super(map);
	}

	// 210~分離
	@Override
	public boolean superRemoveLayer(Object layerRenderer) {
		return layerRenderers.remove((LayerRenderer) layerRenderer);
	}

	@Override
	public ResourceLocation getEntityTexture(AbstractClientPlayer abstractClientPlayer) {
		return (ResourceLocation) (master != null ? master.getEntityTexture(abstractClientPlayer) : super.getEntityTexture(abstractClientPlayer));
	}
	// 212~分離
	@Override
	public void applyRotations(AbstractClientPlayer var1, float var2, float var3, float var4) {
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
		super.applyRotations((AbstractClientPlayer) par1EntityLivingBase, par2, par3, par4);
	}

}
