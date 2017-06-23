package modchu.lib.forge.mc210;

import java.util.HashMap;
import java.util.List;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IRenderLiving;
import modchu.lib.Modchu_IRenderLivingMaster;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
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

public class Modchu_RenderLiving extends modchu.lib.forge.mc190_220.Modchu_RenderLiving {

	public Modchu_RenderLiving(HashMap<String, Object> map) {
		super(map);
	}

	// 210~分離
	@Override
	public boolean superRemoveLayer(Object layerRenderer) {
		return layerRenderers.remove((LayerRenderer) layerRenderer);
	}
	// 212~分離
	@Override
	public void rotateCorpse(EntityLivingBase entityLivingBase, float p_77043_2_, float p_77043_3_, float partialTicks) {
		if (master != null) master.applyRotations(entityLivingBase, p_77043_2_, p_77043_3_, partialTicks);
		else super.rotateCorpse(entityLivingBase, p_77043_2_, p_77043_3_, partialTicks);
	}

	@Override
	public void superApplyRotations(Object entityLivingBase, float p_77043_2_, float p_77043_3_, float partialTicks) {
		super.rotateCorpse((EntityLivingBase) entityLivingBase, p_77043_2_, p_77043_3_, partialTicks);
	}

	@Override
	public void superRotateCorpse(Object entityLivingBase, float p_77043_2_, float p_77043_3_, float partialTicks) {
		super.rotateCorpse((EntityLivingBase) entityLivingBase, p_77043_2_, p_77043_3_, partialTicks);
	}

	@Override
	public void superFunc_96449_a(Object entityLivingBase, double par2, double par4, double par6, String par8Str, float par9, double par10) {
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
	public void superSetLightmap(Object entityLiving) {
	}

	@Override
	public boolean superIsVisible(Object entityLivingBase) {
		return false;
	}

}
