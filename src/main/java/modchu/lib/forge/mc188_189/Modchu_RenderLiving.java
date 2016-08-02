package modchu.lib.forge.mc188_189;

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

public class Modchu_RenderLiving extends RenderLiving implements Modchu_IRenderLiving {
	public Modchu_IRenderLivingMaster master;

	public Modchu_RenderLiving(HashMap<String, Object> map) {
		super((RenderManager) Modchu_AS.get(Modchu_AS.renderManagerInstance), (ModelBase) map.get("Object"), (Float) map.get("Float"));
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		Modchu_Debug.mDebug("Modchu_RenderLiving init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IRenderLivingMaster ? (Modchu_IRenderLivingMaster) instance : null;
	}

	@Override
	public int setArmorModel(Object entity, int i, float f) {
		return master != null ? master.setArmorModel(entity, i, f) : -1;
	}

	@Override
	public int superSetArmorModel(Object entity, int i, float f) {
		return -1;
	}

	public int setArmorModel(Object model, Object entityplayer, int i, float f, int i2) {
		return master != null ? master.setArmorModel(model, entityplayer, i, f, i2) : -1;
	}

	@Override
	public int superSetArmorModel(Object model, Object entityplayer, int i, float f, int i2) {
		return -1;
	}

	@Override
	public void superPassSpecialRender(Object entityLiving, double d, double d1, double d2) {
	}

	public void doRender(Entity entity, double x, double y, double z, float entityYaw, float partialTicks) {
		if (master != null) master.doRender(entity, x, y, z, entityYaw, partialTicks);
		else super.doRender((EntityLiving) entity, x, y, z, entityYaw, partialTicks);
	}

	@Override
	public void superDoRender(Object entity, double x, double y, double z, float entityYaw, float partialTicks) {
		super.doRender((EntityLiving) entity, x, y, z, entityYaw, partialTicks);
	}

	public void doRenderShadowAndFire(Entity entity, double x, double y, double z, float yaw, float partialTicks) {
		if (master != null) master.doRenderShadowAndFire(entity, x, y, z, yaw, partialTicks);
		else super.doRenderShadowAndFire(entity, x, y, z, yaw, partialTicks);
	}

	@Override
	public void superDoRenderShadowAndFire(Object entity, double x, double y, double z, float yaw, float partialTicks) {
		super.doRenderShadowAndFire((Entity) entity, x, y, z, yaw, partialTicks);
	}

	public FontRenderer getFontRendererFromRenderManager() {
		return (FontRenderer) (master != null ? master.getFontRendererFromRenderManager() : super.getFontRendererFromRenderManager());
	}

	@Override
	public FontRenderer superGetFontRendererFromRenderManager() {
		return super.getFontRendererFromRenderManager();
	}

	public void doRender(EntityLivingBase entityLivingBase, double x, double y, double z, float entityYaw, float partialTicks) {
		if (master != null) master.doRender(entityLivingBase, x, y, z, entityYaw, partialTicks);
		else super.doRender((EntityLiving) entityLivingBase, x, y, z, entityYaw, partialTicks);
	}

	public void renderModel(EntityLivingBase entityLivingBase, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		if (master != null) master.renderModel(entityLivingBase, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
		else super.renderModel(entityLivingBase, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
	}

	@Override
	public void superRenderModel(Object entityLivingBase, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		super.renderModel((EntityLivingBase) entityLivingBase, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
	}

	public void renderLivingAt(EntityLivingBase entityLivingBase, double x, double y, double z) {
		if (master != null) master.renderLivingAt(entityLivingBase, x, y, z);
		else super.renderLivingAt(entityLivingBase, x, y, z);
	}

	@Override
	public void superRenderLivingAt(Object entityLivingBase, double x, double y, double z) {
		super.renderLivingAt((EntityLivingBase) entityLivingBase, x, y, z);
	}

	public void rotateCorpse(EntityLivingBase entityLivingBase, float p_77043_2_, float p_77043_3_, float partialTicks) {
		if (master != null) master.rotateCorpse(entityLivingBase, p_77043_2_, p_77043_3_, partialTicks);
		else super.rotateCorpse(entityLivingBase, p_77043_2_, p_77043_3_, partialTicks);
	}

	@Override
	public void superRotateCorpse(Object entityLivingBase, float p_77043_2_, float p_77043_3_, float partialTicks) {
		super.rotateCorpse((EntityLivingBase) entityLivingBase, p_77043_2_, p_77043_3_, partialTicks);
	}

	public float getSwingProgress(EntityLivingBase entityLivingBase, float partialTickTime) {
		return master != null ? master.getSwingProgress(entityLivingBase, partialTickTime) : super.getSwingProgress(entityLivingBase, partialTickTime);
	}

	@Override
	public float superGetSwingProgress(Object entityLivingBase, float partialTickTime) {
		return super.getSwingProgress((EntityLivingBase) entityLivingBase, partialTickTime);
	}

	public float handleRotationFloat(EntityLivingBase entityLivingBase, float partialTicks) {
		return master != null ? master.handleRotationFloat(entityLivingBase, partialTicks) : super.handleRotationFloat(entityLivingBase, partialTicks);
	}

	@Override
	public float superHandleRotationFloat(Object entityLivingBase, float partialTicks) {
		return super.handleRotationFloat((EntityLivingBase) entityLivingBase, partialTicks);
	}

	public float getDeathMaxRotation(EntityLivingBase entityLivingBase) {
		return master != null ? master.getDeathMaxRotation(entityLivingBase) : super.getDeathMaxRotation(entityLivingBase);
	}

	@Override
	public float superGetDeathMaxRotation(Object entityLivingBase) {
		return super.getDeathMaxRotation((EntityLivingBase) entityLivingBase);
	}

	public int getColorMultiplier(EntityLivingBase entityLivingBase, float lightBrightness, float partialTickTime) {
		return master != null ? master.getColorMultiplier(entityLivingBase, lightBrightness, partialTickTime) : super.getColorMultiplier(entityLivingBase, lightBrightness, partialTickTime);
	}

	@Override
	public int superGetColorMultiplier(Object entityLivingBase, float lightBrightness, float partialTickTime) {
		return super.getColorMultiplier((EntityLivingBase) entityLivingBase, lightBrightness, partialTickTime);
	}

	public void preRenderCallback(EntityLivingBase entityLivingBase, float partialTickTime) {
		if (master != null) master.preRenderCallback(entityLivingBase, partialTickTime);
		else super.preRenderCallback(entityLivingBase, partialTickTime);
	}

	@Override
	public void superPreRenderCallback(Object entityLivingBase, float partialTickTime) {
		super.preRenderCallback((EntityLivingBase) entityLivingBase, partialTickTime);
	}

	public void doRender(EntityLiving entityLiving, double x, double y, double z, float entityYaw, float partialTicks) {
		if (master != null) master.doRender(entityLiving, x, y, z, entityYaw, partialTicks);
		else super.doRender(entityLiving, x, y, z, entityYaw, partialTicks);
	}
	// 180
	public void renderLivingLabel(Entity entity, String str, double x, double y, double z, int maxDistance) {
		if (master != null) master.renderLivingLabel(entity, str, x, y, z, maxDistance);
		else super.renderLivingLabel(entity, str, x, y, z, maxDistance);
	}

	@Override
	public void superRenderLivingLabel(Object entity, String str, double x, double y, double z, int maxDistance) {
		super.renderLivingLabel((Entity) entity, str, x, y, z, maxDistance);
	}
	// 190~
	public int getTeamColor(Entity entity) {
		return -1;
	}

	@Override
	public int superGetTeamColor(Object entity) {
		return -1;
	}

	public void renderEntityName(Entity entity, double x, double y, double z, String name, double p_188296_9_) {
	}

	@Override
	public void superRenderEntityName(Object entity, double x, double y, double z, String name, double p_188296_9_) {
	}

	public boolean isMultipass() {
		return false;
	}

	@Override
	public boolean superIsMultipass() {
		return false;
	}

	public void renderMultipass(Entity entity, double p_188300_2_, double p_188300_4_, double p_188300_6_, float p_188300_8_, float p_188300_9_) {
	}

	@Override
	public void superRenderMultipass(Object entity, double p_188300_2_, double p_188300_4_, double p_188300_6_, float p_188300_8_, float p_188300_9_) {
	}

	public float prepareScale(EntityLivingBase entityLivingBase, float partialTicks) {
		return 0.0F;
	}

	@Override
	public float superPrepareScale(Object entityLivingBase, float partialTicks) {
		return 0.0F;
	}
	// 164~
	public boolean canRenderName(Entity entity) {
		return master != null ? master.canRenderName(entity) : super.canRenderName((EntityLiving) entity);
	}

	@Override
	public boolean superCanRenderName(Object entity) {
		return super.canRenderName((EntityLiving) entity);
	}

	public void renderLeash(EntityLiving entityLiving, double x, double y, double z, float entityYaw, float partialTicks) {
		if (master != null) master.renderLeash(entityLiving, x, y, z, entityYaw, partialTicks);
		else super.renderLeash(entityLiving, x, y, z, entityYaw, partialTicks);
	}

	@Override
	public void superRenderLeash(Object entityLiving, double x, double y, double z, float entityYaw, float partialTicks) {
		super.renderLeash((EntityLiving) entityLiving, x, y, z, entityYaw, partialTicks);
	}
	// ~189
	@Override
	public void renderOffsetLivingLabel(Entity entity, double x, double y, double z, String str, float p_177069_9_, double p_177069_10_) {
		if (master != null) master.renderOffsetLivingLabel(entity, x, y, z, str, p_177069_9_, p_177069_10_);
		else super.renderOffsetLivingLabel(entity, x, y, z, str, p_177069_9_, p_177069_10_);
	}

	@Override
	public void superRenderOffsetLivingLabel(Object entity, double x, double y, double z, String str, float p_177069_9_, double p_177069_10_) {
		super.renderOffsetLivingLabel((Entity) entity, x, y, z, str, p_177069_9_, p_177069_10_);
	}
	// 180~189
	@Override
	public void func_177105_a(EntityLiving entityLiving, float partialTicks) {
		if (master != null) master.setLightmap(entityLiving, partialTicks);
		else super.func_177105_a(entityLiving, partialTicks);
	}

	@Override
	public void superSetLightmap(Object entityLiving, float partialTicks) {
		super.func_177105_a((EntityLiving) entityLiving, partialTicks);
	}
	// 172~179
	public boolean isStaticEntity() {
		return false;
	}

	@Override
	public boolean superIsStaticEntity() {
		return false;
	}
	// ~172
	public void setRenderManager(RenderManager renderManager) {
	}

	@Override
	public void superSetRenderManager(Object renderManager) {
	}

	public void updateIcons(Object iIconRegister) {
	}

	@Override
	public void superUpdateIcons(Object iIconRegister) {
	}

	public void setRenderPassModel(ModelBase modelBase) {
	}

	@Override
	public void superSetRenderPassModel(Object modelBase) {
	}

	public void renderEquippedItems(EntityLivingBase entityLivingBase, float p_77029_2_) {
	}

	@Override
	public void superRenderEquippedItems(Object entityLivingBase, float p_77029_2_) {
	}

	public void renderArrowsStuckInEntity(EntityLivingBase entityLivingBase, float p_85093_2_) {
	}

	@Override
	public void superRenderArrowsStuckInEntity(Object entityLivingBase, float p_85093_2_) {
	}

	public int inheritRenderPass(EntityLivingBase entityLivingBase, int p_77035_2_, float p_77035_3_) {
		return -1;
	}

	@Override
	public int superInheritRenderPass(Object entityLivingBase, int p_77035_2_, float p_77035_3_) {
		return -1;
	}

	public int shouldRenderPass(EntityLivingBase entityLivingBase, int p_77032_2_, float p_77032_3_) {
		return -1;
	}

	@Override
	public int superShouldRenderPass(Object entityLivingBase, int p_77032_2_, float p_77032_3_) {
		return -1;
	}

	public void func_82408_c(EntityLivingBase entityLivingBase, int p_82408_2_, float p_82408_3_) {
	}

	@Override
	public void superFunc_82408_c(Object entityLivingBase, int p_82408_2_, float p_82408_3_) {
	}

	// ~164
	public void doRenderLiving(EntityLivingBase entityLivingBase, double par2, double par4, double par6, float par8, float par9) {
	}

	@Override
	public void superDoRenderLiving(Object entityLiving, double d, double d1, double d2, float d3, float d4) {
		super.doRender((EntityLiving) entityLiving, d, d1, d2, d3, d4);
	}

	public void doRenderLiving(EntityLiving entityLiving, double par2, double par4, double par6, float par8, float par9) {
	}
	// 162~164
	public boolean func_130007_b(EntityLiving entityLiving) {
		return false;
	}

	@Override
	public boolean superFunc_130007_b(Object entityLiving) {
		return false;
	}
	// 180~
	public void transformHeldFull3DItemLayer() {
		if (master != null) master.transformHeldFull3DItemLayer();
		else super.transformHeldFull3DItemLayer();
	}

	@Override
	public void superTransformHeldFull3DItemLayer() {
		super.transformHeldFull3DItemLayer();
	}

	public boolean setScoreTeamColor(EntityLivingBase entityLivingBase) {
		return master != null ? master.setScoreTeamColor(entityLivingBase) : super.setScoreTeamColor(entityLivingBase);
	}

	@Override
	public boolean superSetScoreTeamColor(Object entityLivingBase) {
		return super.setScoreTeamColor((EntityLivingBase) entityLivingBase);
	}

	public void unsetScoreTeamColor() {
		if (master != null) master.unsetScoreTeamColor();
		else super.unsetScoreTeamColor();
	}

	@Override
	public void superUnsetScoreTeamColor() {
		super.unsetScoreTeamColor();
	}

	public boolean setDoRenderBrightness(EntityLivingBase entityLivingBase, float partialTicks) {
		return master != null ? master.setDoRenderBrightness(entityLivingBase, partialTicks) : super.setDoRenderBrightness(entityLivingBase, partialTicks);
	}

	@Override
	public boolean superSetDoRenderBrightness(Object entityLivingBase, float partialTicks) {
		return super.setDoRenderBrightness((EntityLivingBase) entityLivingBase, partialTicks);
	}

	public boolean setBrightness(EntityLivingBase entityLivingBase, float partialTicks, boolean combineTextures) {
		return master != null ? master.setBrightness(entityLivingBase, partialTicks, combineTextures) : super.setBrightness(entityLivingBase, partialTicks, combineTextures);
	}

	@Override
	public boolean superSetBrightness(Object entityLivingBase, float partialTicks, boolean combineTextures) {
		return super.setBrightness((EntityLivingBase) entityLivingBase, partialTicks, combineTextures);
	}

	public void unsetBrightness() {
		if (master != null) master.unsetBrightness();
		else super.unsetBrightness();
	}

	@Override
	public void superUnsetBrightness() {
		super.unsetBrightness();
	}

	public void renderLayers(EntityLivingBase entityLivingBase, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scaleIn) {
		if (master != null) master.renderLayers(entityLivingBase, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scaleIn);
		else super.renderLayers(entityLivingBase, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scaleIn);
	}

	@Override
	public void superRenderLayers(Object entityLivingBase, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scaleIn) {
		super.renderLayers((EntityLivingBase) entityLivingBase, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scaleIn);
	}

	@Override
	public RenderManager getRenderManager() {
		return (RenderManager) (master != null ? master.getRenderManager() : super.getRenderManager());
	}

	@Override
	public RenderManager superGetRenderManager() {
		return super.getRenderManager();
	}

	@Override
	public void setRenderOutlines(boolean renderOutlinesIn) {
		if (master != null) master.setRenderOutlines(renderOutlinesIn);
		else super.setRenderOutlines(renderOutlinesIn);
	}

	@Override
	public void superSetRenderOutlines(boolean renderOutlinesIn) {
		super.setRenderOutlines(renderOutlinesIn);
	}

	public boolean shouldRender(Entity entity, ICamera iCamera, double camX, double camY, double camZ) {
		return master != null ? master.shouldRender(entity, iCamera, camX, camY, camZ) : super.shouldRender((EntityLiving) entity, iCamera, camX, camY, camZ);
	}

	@Override
	public boolean superShouldRender(Object entity, Object iCamera, double camX, double camY, double camZ) {
		return super.shouldRender((EntityLiving) entity, (ICamera) iCamera, camX, camY, camZ);
	}

	public void renderName(Entity entity, double x, double y, double z) {
		if (master != null) master.renderName(entity, x, y, z);
		else super.renderName((EntityLivingBase) entity, x, y, z);
	}

	@Override
	public void superRenderName(Object entity, double x, double y, double z) {
		super.renderName((EntityLivingBase) entity, x, y, z);
	}

	public ModelBase getMainModel() {
		return (ModelBase) (master != null ? master.getMainModel() : super.getMainModel());
	}

	@Override
	public ModelBase superGetMainModel() {
		return super.getMainModel();
	}

	public float interpolateRotation(float prevYawOffset, float yawOffset, float partialTicks) {
		return master != null ? master.interpolateRotation(prevYawOffset, yawOffset, partialTicks) : super.interpolateRotation(prevYawOffset, yawOffset, partialTicks);
	}

	@Override
	public float superInterpolateRotation(float prevYawOffset, float yawOffset, float partialTicks) {
		return super.interpolateRotation(prevYawOffset, yawOffset, partialTicks);
	}

	public void renderName(EntityLivingBase entityLivingBase, double x, double y, double z) {
		if (master != null) master.renderName(entityLivingBase, x, y, z);
		else super.renderName(entityLivingBase, x, y, z);
	}

	public boolean canRenderName(EntityLivingBase entityLivingBase) {
		return master != null ? master.canRenderName(entityLivingBase) : super.canRenderName((EntityLiving) entityLivingBase);
	}

	@Override
	public boolean canRenderName(EntityLiving entityLiving) {
		return master != null ? master.canRenderName(entityLiving) : super.canRenderName(entityLiving);
	}

	public boolean shouldRender(EntityLiving entityLiving, ICamera iCamera, double camX, double camY, double camZ) {
		return master != null ? master.shouldRender(entityLiving, iCamera, camX, camY, camZ) : super.shouldRender(entityLiving, iCamera, camX, camY, camZ);
	}
	// 188~
	@Override
	public boolean addLayer(LayerRenderer layerRenderer) {
		return master != null ? master.addLayer(layerRenderer) : super.addLayer(layerRenderer);
	}

	@Override
	public boolean superAddLayer(Object layerRenderer) {
		return super.addLayer((LayerRenderer) layerRenderer);
	}

	@Override
	protected boolean removeLayer(LayerRenderer layerRenderer) {
		return master != null ? master.removeLayer(layerRenderer) : super.removeLayer(layerRenderer);
	}

	@Override
	public boolean superRemoveLayer(Object layerRenderer) {
		return super.removeLayer((LayerRenderer) layerRenderer);
	}
	// 162~
	public boolean bindEntityTexture(Entity entity) {
		return master != null ? master.bindEntityTexture(entity) : super.bindEntityTexture(entity);
	}

	@Override
	public boolean superBindEntityTexture(Object entity) {
		return super.bindEntityTexture((Entity) entity);
	}

	public void bindTexture(ResourceLocation resourceLocation) {
		if (master != null) master.bindTexture(resourceLocation);
		else super.bindTexture(resourceLocation);
	}

	@Override
	public void superBindTexture(Object resourceLocation) {
		super.bindTexture((ResourceLocation) resourceLocation);
	}

	public ResourceLocation getEntityTexture(Entity entity) {
		return (ResourceLocation) (master != null ? master.getEntityTexture(entity) : null);
	}

	@Override
	public ResourceLocation superGetEntityTexture(Object entity) {
		return null;
	}
	// ~152
	public void loadTexture(String par1Str) {
	}

	@Override
	public void superLoadTexture(String par1Str) {
	}

	public boolean loadDownloadableImageTexture(String par1Str, String par2Str) {
		return false;
	}

	@Override
	public boolean superLoadDownloadableImageTexture(String par1Str, String par2Str) {
		return false;
	}

	public void func_98190_a(EntityLiving entityLiving) {
	}

	@Override
	public void superFunc_98190_a(Object entityLiving) {
	}
	// 180~
	@Override
	public Object getRenderPassModel(int i) {
		LayerArmorBase layerArmorBase = (LayerArmorBase) getLayerArmorBase();
		return Modchu_Reflect.getFieldObject(layerArmorBase.getClass(), i == 0 ? "field_177189_c" : "field_177186_d", layerArmorBase);
	}

	@Override
	public void setRenderPassModel(Object model, Object model2) {
		LayerArmorBase layerArmorBase = (LayerArmorBase) getLayerArmorBase();
		Modchu_Reflect.setFieldObject(layerArmorBase.getClass(), "field_177189_c", layerArmorBase, model);
		Modchu_Reflect.setFieldObject(layerArmorBase.getClass(), "field_177186_d", layerArmorBase, model2);
	}

	@Override
	public Object getLayerArmorBase() {
		for (Object layerArmorBase : layerRenderers) {
			if (layerArmorBase instanceof LayerArmorBase) {
				return layerArmorBase;
			}
		}
		return null;
	}

	@Override
	public Object getLayerHeldItem() {
		for (Object layerHeldItem : layerRenderers) {
			if (layerHeldItem instanceof LayerHeldItem) {
				return layerHeldItem;
			}
		}
		return null;
	}

	@Override
	public Object getLayerCustomHead() {
		for (Object layerCustomHead : layerRenderers) {
			if (layerCustomHead instanceof LayerCustomHead) {
				return layerCustomHead;
			}
		}
		return null;
	}

	@Override
	public void setLayer(Class c, Object layer) {
		if (layerRenderers != null
				&& c != null
				&& layer != null); else return;
		if (!layerRenderers.isEmpty())
		for (int i = 0; i < layerRenderers.size(); i++) {
			Object o = layerRenderers.get(i);
			if (c.isInstance(o)) {
				layerRenderers.set(i, (LayerRenderer<EntityLivingBase>) layer);
				return;
			}
		}
		addLayer((LayerRenderer<EntityLivingBase>) layer);
	}

	@Override
	public List getLayerList() {
		return layerRenderers;
	}
	// TODO

/*
	@Override
	protected void preRenderCallback(EntityLivingBase entityliving, float f) {
		if (master != null) master.preRenderCallback(entityliving, f);
	}

	@Override
	public void doRender(EntityLiving entity, double d, double d1, double d2, float d3, float d4) {
		//Modchu_Debug.mDebug("Modchu_RenderLiving doRender");
		if (master != null) master.doRender(entity, d, d1, d2, d3, d4);
	}

	@Override
	public void superDoRenderLiving(Object entityLiving, double d, double d1, double d2, float d3, float d4) {
		super.doRender((EntityLiving) entityLiving, d, d1, d2, d3, d4);
	}

	public void superDoRender(Object entity, double d, double d1, double d2, float d3, float d4) {
		super.doRender((EntityLiving) entity, d, d1, d2, d3, d4);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		//if (master != null) Modchu_Debug.mdDebug("Modchu_RenderLiving getEntityTexture "+((ResourceLocation) master.getEntityTexture(entity)));
		return master != null ? (ResourceLocation) master.getEntityTexture(entity) : null;
	}

	public void setShadowSize(float f) {
		shadowSize = f;
	}

	public void setShadowOpaque(float f) {
		shadowOpaque = f;
	}

	public Object getEntityMaster(Object entity) {
		Object entity2 = Modchu_Reflect.invokeMethod(entity.getClass(), "getMaster", entity);
		return entity2 != null ? entity2 : entity;
	}
	// 180
	public boolean shouldRenderLiving(EntityLiving entityLiving, ICamera iCamera, double p_177104_3_, double p_177104_5_, double p_177104_7_) {
		return master != null ? master.shouldRender(entityLiving, iCamera, p_177104_3_, p_177104_5_, p_177104_7_) : super.shouldRender(entityLiving, iCamera, p_177104_3_, p_177104_5_, p_177104_7_);
	}
	// 180~
	@Override
	public void superSetLightmap(Object entityLiving, float p_177105_2_) {
		super.func_177105_a((EntityLiving) entityLiving, p_177105_2_);
	}

	@Override
	public void func_177105_a(EntityLiving entityLiving, float p_177105_2_) {
		if (master != null) master.setLightmap(entityLiving, p_177105_2_);
		else super.func_177105_a(entityLiving, p_177105_2_);
	}

	@Override
	public boolean shouldRender(EntityLiving entity, ICamera iCamera, double p_177071_3_, double p_177071_5_, double p_177071_7_) {
		return master != null ? master.shouldRender(entity, iCamera, p_177071_3_, p_177071_5_, p_177071_7_) : super.shouldRender(entity, iCamera, p_177071_3_, p_177071_5_, p_177071_7_);
	}

	public boolean superShouldRender(Object entityLiving, Object iCamera, double p_177104_3_, double p_177104_5_, double p_177104_7_) {
		return super.shouldRender((EntityLiving) entityLiving, (ICamera) iCamera, p_177104_3_, p_177104_5_, p_177104_7_);
	}
	@Override
	protected void renderLeash(EntityLiving entityliving, double d, double d1, double d2, float d3, float d4) {
		if (master != null) master.renderLeashedToEntityRope(entityliving, d, d1, d2, d3, d4);
	}

	@Override
	public void superRenderLeashedToEntityRope(Object entityLiving, double d, double d1, double d2, float d3, float d4) {
		super.renderLeash((EntityLiving) entityLiving, d, d1, d2, d3, d4);
	}

	@Override
	protected boolean canRenderName(EntityLiving entityLivingBase) {
		if (master != null) return master.canRenderName(entityLivingBase);
		return false;
	}

	@Override
	public boolean superCanRenderName(Object entityLivingBase) {
		return super.canRenderName((EntityLiving) entityLivingBase);
	}

	@Override
	public ModelBase getMainModel() {
		return mainModel;
	}

	public void setMainModel(Object model) {
		mainModel = (ModelBase) model;
	}

	@Override
	public boolean addLayer(LayerRenderer layerRenderer) {
		return master != null ? master.addLayer(layerRenderer) : super.addLayer(layerRenderer);
	}

	@Override
	public boolean superAddLayer(Object layerRenderer) {
		return super.addLayer((LayerRenderer) layerRenderer);
	}

	@Override
	protected boolean removeLayer(LayerRenderer layerRenderer) {
		return master != null ? master.removeLayer(layerRenderer) : super.removeLayer(layerRenderer);
	}

	@Override
	public boolean superRemoveLayer(Object layerRenderer) {
		return super.removeLayer((LayerRenderer) layerRenderer);
	}

	@Override
	protected float interpolateRotation(float p_77034_1_, float p_77034_2_, float p_77034_3_) {
		return master != null ? master.interpolateRotation(p_77034_1_, p_77034_2_, p_77034_3_) : super.interpolateRotation(p_77034_1_, p_77034_2_, p_77034_3_);
	}

	@Override
	public float superInterpolateRotation(float p_77034_1_, float p_77034_2_, float p_77034_3_) {
		return super.interpolateRotation(p_77034_1_, p_77034_2_, p_77034_3_);
	}

	@Override
	public void transformHeldFull3DItemLayer() {
		if (master != null) master.transformHeldFull3DItemLayer();
		else super.transformHeldFull3DItemLayer();
	}

	@Override
	public void superTransformHeldFull3DItemLayer() {
		super.transformHeldFull3DItemLayer();
	}

	@Override
	protected boolean setScoreTeamColor(EntityLivingBase entityLivingBase) {
		return master != null ? master.setScoreTeamColor(entityLivingBase) : super.setScoreTeamColor(entityLivingBase);
	}

	@Override
	public boolean superSetScoreTeamColor(Object entityLivingBase) {
		return super.setScoreTeamColor((EntityLivingBase) entityLivingBase);
	}

	@Override
	protected void unsetScoreTeamColor() {
		if (master != null) master.unsetScoreTeamColor();
		else super.unsetScoreTeamColor();
	}

	@Override
	public void superUnsetScoreTeamColor() {
		super.unsetScoreTeamColor();
	}

	@Override
	protected boolean setDoRenderBrightness(EntityLivingBase entityLivingBase, float p_177090_2_) {
		return master != null ? master.setDoRenderBrightness(entityLivingBase, p_177090_2_) : super.setDoRenderBrightness(entityLivingBase, p_177090_2_);
	}

	@Override
	public boolean superSetDoRenderBrightness(Object entityLivingBase, float p_177090_2_) {
		return super.setDoRenderBrightness((EntityLiving) entityLivingBase, p_177090_2_);
	}

	@Override
	protected boolean setBrightness(EntityLivingBase entityLivingBase, float p_177092_2_, boolean p_177092_3_) {
		return master != null ? master.setBrightness(entityLivingBase, p_177092_2_, p_177092_3_) : super.setBrightness(entityLivingBase, p_177092_2_, p_177092_3_);
	}

	@Override
	public boolean superSetBrightness(Object entityLivingBase, float p_177092_2_, boolean p_177092_3_) {
		return super.setBrightness((EntityLiving) entityLivingBase, p_177092_2_, p_177092_3_);
	}

	@Override
	protected void unsetBrightness() {
		if (master != null) master.unsetBrightness();
		else super.unsetBrightness();
	}

	@Override
	public void superUnsetBrightness() {
		super.unsetBrightness();
	}

	@Override
	protected float getSwingProgress(EntityLivingBase entityLivingBase, float p_77040_2_) {
		return master != null ? master.getSwingProgress(entityLivingBase, p_77040_2_) : super.getSwingProgress(entityLivingBase, p_77040_2_);
	}

	@Override
	public float superGetSwingProgress(Object entityLivingBase, float p_77040_2_) {
		return super.getSwingProgress((EntityLivingBase) entityLivingBase, p_77040_2_);
	}

	@Override
	public void setRenderOutlines(boolean p_177086_1_) {
		if (master != null) master.setRenderOutlines(p_177086_1_);
		else super.setRenderOutlines(p_177086_1_);
	}

	@Override
	public void superSetRenderOutlines(boolean p_177086_1_) {
		super.setRenderOutlines(p_177086_1_);
	}

	@Override
	public void renderName(EntityLivingBase entity, double x, double y, double z) {
		if (master != null) master.renderName(entity, x, y, z);
		else super.renderName(entity, x, y, z);
	}

	@Override
	public void superRenderName(Object entity, double x, double y, double z) {
		super.renderName((EntityLivingBase) entity, x, y, z);
	}

	@Override
	protected void renderOffsetLivingLabel(Entity entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, float p_177069_9_, double p_177069_10_) {
		if (master != null) master.renderOffsetLivingLabel(entity, p_177069_2_, p_177069_4_, p_177069_6_, p_177069_8_, p_177069_9_, p_177069_10_);
		else super.renderOffsetLivingLabel(entity, p_177069_2_, p_177069_4_, p_177069_6_, p_177069_8_, p_177069_9_, p_177069_10_);
	}

	@Override
	public void superRenderOffsetLivingLabel(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, float p_177069_9_, double p_177069_10_) {
		super.renderOffsetLivingLabel((Entity) entity, p_177069_2_, p_177069_4_, p_177069_6_, p_177069_8_, p_177069_9_, p_177069_10_);
	}

	@Override
	protected boolean bindEntityTexture(Entity entity) {
		return master != null ? master.bindEntityTexture(entity) : super.bindEntityTexture(entity);
	}

	@Override
	public boolean superBindEntityTexture(Object entity) {
		return super.bindEntityTexture((Entity) entity);
	}

	@Override
	protected void renderLivingLabel(Entity entity, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_) {
		if (master != null) master.renderLivingLabel(entity, p_147906_2_, p_147906_3_, p_147906_5_, p_147906_7_, p_147906_9_);
		else super.renderLivingLabel(entity, p_147906_2_, p_147906_3_, p_147906_5_, p_147906_7_, p_147906_9_);
	}

	@Override
	public void superRenderLivingLabel(Object entity, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_) {
		super.renderLivingLabel((Entity) entity, p_147906_2_, p_147906_3_, p_147906_5_, p_147906_7_, p_147906_9_);
	}

	@Override
	public RenderManager getRenderManager() {
		return (RenderManager) (master != null ? master.getRenderManager() : super.getRenderManager());
	}

	@Override
	public RenderManager superGetRenderManager() {
		return super.getRenderManager();
	}

	@Override
	public Object getRenderPassModel(int i) {
		LayerArmorBase layerArmorBase = (LayerArmorBase) getLayerArmorBase();
		return Modchu_Reflect.getFieldObject(layerArmorBase.getClass(), i == 0 ? "field_177189_c" : "field_177186_d", layerArmorBase);
	}

	@Override
	public void setRenderPassModel(Object model, Object model2) {
		LayerArmorBase layerArmorBase = (LayerArmorBase) getLayerArmorBase();
		Modchu_Reflect.setFieldObject(layerArmorBase.getClass(), "field_177189_c", layerArmorBase, model);
		Modchu_Reflect.setFieldObject(layerArmorBase.getClass(), "field_177186_d", layerArmorBase, model2);
	}

	@Override
	public Object getLayerArmorBase() {
		for (Object layerArmorBase : layerRenderers) {
			if (layerArmorBase instanceof LayerArmorBase) {
				return layerArmorBase;
			}
		}
		return null;
	}

	@Override
	public Object getLayerHeldItem() {
		for (Object layerHeldItem : layerRenderers) {
			if (layerHeldItem instanceof LayerHeldItem) {
				return layerHeldItem;
			}
		}
		return null;
	}

	@Override
	public Object getLayerCustomHead() {
		for (Object layerCustomHead : layerRenderers) {
			if (layerCustomHead instanceof LayerCustomHead) {
				return layerCustomHead;
			}
		}
		return null;
	}

	@Override
	public void setLayer(Class c, Object layer) {
		if (layerRenderers != null
				&& !layerRenderers.isEmpty()
				&& c != null
				&& layer != null); else return;
		for (int i = 0; i < layerRenderers.size(); i++) {
			Object o = layerRenderers.get(i);
			if (c.isInstance(o)) {
				layerRenderers.set(i, (LayerRenderer<AbstractClientPlayer>) layer);
				return;
			}
		}
		layerRenderers.add((LayerRenderer<AbstractClientPlayer>) layer);
	}

	@Override
	public List getLayerList() {
		return layerRenderers;
	}
	// ~179
	protected void renderEquippedItems(EntityLivingBase entityliving, float f) {
		if (master != null) master.renderEquippedItems(entityliving, f);
	}

	public Object getRenderBlocks() {
		return null;
	}

	@Override
	protected void renderModel(EntityLivingBase entityLivingBase, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float p_77036_7_) {
		if (master != null) master.renderModel(entityLivingBase, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
		else super.renderModel(entityLivingBase, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
	}

	@Override
	public void superRenderModel(Object entityLivingBase, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float p_77036_7_) {
		super.renderModel((EntityLivingBase) entityLivingBase, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
	}

	@Override
	protected void renderLivingAt(EntityLivingBase entityLivingBase, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
		if (master != null) master.renderLivingAt(entityLivingBase, p_77039_2_, p_77039_4_, p_77039_6_);
		else super.renderLivingAt(entityLivingBase, p_77039_2_, p_77039_4_, p_77039_6_);
	}

	@Override
	public void superRenderLivingAt(Object entityLivingBase, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
		super.renderLivingAt((EntityLivingBase) entityLivingBase, p_77039_2_, p_77039_4_, p_77039_6_);
	}

	@Override
	protected void rotateCorpse(EntityLivingBase entityLivingBase, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
		if (master != null) master.rotateCorpse(entityLivingBase, p_77043_2_, p_77043_3_, p_77043_4_);
		else super.rotateCorpse(entityLivingBase, p_77043_2_, p_77043_3_, p_77043_4_);
	}

	@Override
	public void superRotateCorpse(Object entityLivingBase, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
		super.rotateCorpse((EntityLivingBase) entityLivingBase, p_77043_2_, p_77043_3_, p_77043_4_);
	}

	@Override
	protected float handleRotationFloat(EntityLivingBase entityLivingBase, float p_77044_2_) {
		return master != null ? master.handleRotationFloat(entityLivingBase, p_77044_2_) : super.handleRotationFloat(entityLivingBase, p_77044_2_);
	}

	@Override
	public float superHandleRotationFloat(Object entityLivingBase, float p_77044_2_) {
		return super.handleRotationFloat((EntityLivingBase) entityLivingBase, p_77044_2_);
	}

	@Override
	protected void renderLayers(EntityLivingBase entityLivingBase, float p_177093_2_, float p_177093_3_, float p_177093_4_, float p_177093_5_, float p_177093_6_, float p_177093_7_, float p_177093_8_) {
		if (master != null) master.renderLayers(entityLivingBase, p_177093_2_, p_177093_3_, p_177093_4_, p_177093_5_, p_177093_6_, p_177093_7_, p_177093_8_);
		else super.renderLayers(entityLivingBase, p_177093_2_, p_177093_3_, p_177093_4_, p_177093_5_, p_177093_6_, p_177093_7_, p_177093_8_);
	}

	@Override
	public void superRenderLayers(Object entityLivingBase, float p_177093_2_, float p_177093_3_, float p_177093_4_, float p_177093_5_, float p_177093_6_, float p_177093_7_, float p_177093_8_) {
		super.renderLayers((EntityLivingBase) entityLivingBase, p_177093_2_, p_177093_3_, p_177093_4_, p_177093_5_, p_177093_6_, p_177093_7_, p_177093_8_);
	}

	@Override
	protected float getDeathMaxRotation(EntityLivingBase entityLivingBase) {
		return master != null ? master.getDeathMaxRotation(entityLivingBase) : super.getDeathMaxRotation(entityLivingBase);
	}

	@Override
	public float superGetDeathMaxRotation(Object entityLivingBase) {
		return super.getDeathMaxRotation((EntityLivingBase) entityLivingBase);
	}

	@Override
	protected int getColorMultiplier(EntityLivingBase entityLivingBase, float p_77030_2_, float p_77030_3_) {
		return master != null ? master.getColorMultiplier(entityLivingBase, p_77030_2_, p_77030_3_) : super.getColorMultiplier(entityLivingBase, p_77030_2_, p_77030_3_);
	}

	@Override
	public int superGetColorMultiplier(Object entityLivingBase, float p_77030_2_, float p_77030_3_) {
		return super.getColorMultiplier((EntityLivingBase) entityLivingBase, p_77030_2_, p_77030_3_);
	}

	public void passSpecialRender(EntityLivingBase entityLivingBase, double p_77033_2_, double p_77033_4_, double p_77033_6_) {
		if (master != null) master.passSpecialRender(entityLivingBase, p_77033_2_, p_77033_4_, p_77033_6_);
		else super.renderName(entityLivingBase, p_77033_2_, p_77033_4_, p_77033_6_);
	}

	@Override
	public void superPassSpecialRender(Object entityLivingBase, double p_77033_2_, double p_77033_4_, double p_77033_6_) {
		super.renderName((EntityLivingBase) entityLivingBase, p_77033_2_, p_77033_4_, p_77033_6_);
	}

	@Override
	public void bindTexture(ResourceLocation resourceLocation) {
		if (master != null) master.bindTexture(resourceLocation);
		else super.bindTexture(resourceLocation);
	}

	@Override
	public void superBindTexture(Object resourceLocation) {
		super.bindTexture((ResourceLocation) resourceLocation);
	}

	@Override
	public void doRenderShadowAndFire(Entity entity, double p_76979_2_, double p_76979_4_, double p_76979_6_, float p_76979_8_, float p_76979_9_) {
		if (master != null) master.doRenderShadowAndFire(entity, p_76979_2_, p_76979_4_, p_76979_6_, p_76979_8_, p_76979_9_);
		else super.doRenderShadowAndFire(entity, p_76979_2_, p_76979_4_, p_76979_6_, p_76979_8_, p_76979_9_);
	}

	@Override
	public void superDoRenderShadowAndFire(Object entity, double p_76979_2_, double p_76979_4_, double p_76979_6_, float p_76979_8_, float p_76979_9_) {
		super.doRenderShadowAndFire((Entity) entity, p_76979_2_, p_76979_4_, p_76979_6_, p_76979_8_, p_76979_9_);
	}

	@Override
	public FontRenderer getFontRendererFromRenderManager() {
		return (FontRenderer) (master != null ? master.getFontRendererFromRenderManager() : super.getFontRendererFromRenderManager());
	}

	@Override
	public FontRenderer superGetFontRendererFromRenderManager() {
		return super.getFontRendererFromRenderManager();
	}

	@Override
	public void superPreRenderCallback(Object entityLivingBase, float par2) {
	}

	@Override
	public int setArmorModel(Object model, Object entityplayer, int i, float f, int i2) {
		return -1;
	}

	@Override
	public Object superGetEntityTexture(Object entity) {
		return null;
	}

	@Override
	public Object superGetEntityTexture(Object entity, int i) {
		return null;
	}

	@Override
	public int superSetArmorModel(Object object, Object entity, int i, float f, int j) {
		return -1;
	}

	@Override
	public void superRenderEquippedItems(Object entityliving, float f) {
	}

	@Override
	public int superShouldRenderPass(Object entityliving, int i, float f) {
		return -1;
	}

	@Override
	public int superInheritRenderPass(Object entity, int par2, float par3) {
		return -1;
	}

	@Override
	public Object superGetMainModel() {
		return mainModel;
	}

	public Object getRenderPassModel() {
		return null;
	}

	@Override
	public void renderLeashedToEntityRope(Object entityLiving, double d, double d1, double d2, float d3, float d4) {
	}

	@Override
	public void superSetRenderPassModel(Object modelBase) {
	}

	@Override
	public float superRenderSwingProgress(Object entityLivingBase, float par2) {
		return super.getSwingProgress((EntityLivingBase) entityLivingBase, par2);
	}

	@Override
	public void superRenderArrowsStuckInEntity(Object entityLivingBase, float par2) {
	}

	@Override
	public void superFunc_82408_c(Object entityLivingBase, int par2, float par3) {
	}

	@Override
	public void superFunc_96449_a(Object entityLivingBase, double par2, double par4, double par6, String par8Str, float par9, double par10) {
	}

	@Override
	public boolean superIsStaticEntity() {
		return false;
	}

	@Override
	public void superSetRenderManager(Object renderManager) {
	}

	@Override
	public void superUpdateIcons(Object iIconRegister) {
	}

	@Override
	public void superFunc_147906_a(Object entity, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_) {
	}

	@Override
	public boolean superFunc_130007_b(Object entityLiving) {
		return false;
	}
	// ~152
	@Override
	public void superLoadTexture(String par1Str) {
	}

	@Override
	public boolean superLoadDownloadableImageTexture(String par1Str, String par2Str) {
		return false;
	}
	// 190~
	@Override
	public void superRenderEntityName(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, double p_177069_10_) {
		super.renderOffsetLivingLabel((Entity) entity, p_177069_2_, p_177069_4_, p_177069_6_, p_177069_8_, 0.0F, p_177069_10_);
	}
*/
}
