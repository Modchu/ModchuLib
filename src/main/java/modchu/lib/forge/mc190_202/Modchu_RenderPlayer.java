package modchu.lib.forge.mc190_202;

import java.util.HashMap;
import java.util.List;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IRenderLiving;
import modchu.lib.Modchu_IRenderLivingMaster;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.client.renderer.entity.layers.LayerCustomHead;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class Modchu_RenderPlayer extends modchu.lib.forge.mc190_212.Modchu_RenderPlayer {

	public Modchu_RenderPlayer(HashMap<String, Object> map) {
		super(map);
	}
	// 210~分離
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

}
