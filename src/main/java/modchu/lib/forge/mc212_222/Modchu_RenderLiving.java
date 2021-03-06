package modchu.lib.forge.mc212_222;

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

public abstract class Modchu_RenderLiving extends modchu.lib.forge.mc190_222.Modchu_RenderLiving {

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
	public void superApplyRotations(Object entityLivingBase, float p_77043_2_, float p_77043_3_, float partialTicks) {
	}

}
