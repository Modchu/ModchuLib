package modchu.lib.forge.mc190_220;

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

public abstract class Modchu_RenderLiving extends RenderLiving implements Modchu_IRenderLiving {
	public Modchu_IRenderLivingMaster master;

	public Modchu_RenderLiving(HashMap<String, Object> map) {
		super((RenderManager) Modchu_AS.get(Modchu_AS.renderManagerInstance), (ModelBase) map.get("Object"), (Float) map.get("Float"));
		Modchu_Debug.mDebug("Modchu_RenderLiving init renderManagerInstance="+Modchu_AS.get(Modchu_AS.renderManagerInstance));
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

	@Override
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

	@Override
	public void doRenderShadowAndFire(Entity entity, double x, double y, double z, float yaw, float partialTicks) {
		if (master != null) master.doRenderShadowAndFire(entity, x, y, z, yaw, partialTicks);
		else super.doRenderShadowAndFire(entity, x, y, z, yaw, partialTicks);
	}

	@Override
	public void superDoRenderShadowAndFire(Object entity, double x, double y, double z, float yaw, float partialTicks) {
		super.doRenderShadowAndFire((Entity) entity, x, y, z, yaw, partialTicks);
	}

	@Override
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

	@Override
	public void renderModel(EntityLivingBase entityLivingBase, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		if (master != null) master.renderModel(entityLivingBase, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
		else super.renderModel(entityLivingBase, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
	}

	@Override
	public void superRenderModel(Object entityLivingBase, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		super.renderModel((EntityLivingBase) entityLivingBase, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
	}

	@Override
	public void renderLivingAt(EntityLivingBase entityLivingBase, double x, double y, double z) {
		if (master != null) master.renderLivingAt(entityLivingBase, x, y, z);
		else super.renderLivingAt(entityLivingBase, x, y, z);
	}

	@Override
	public void superRenderLivingAt(Object entityLivingBase, double x, double y, double z) {
		super.renderLivingAt((EntityLivingBase) entityLivingBase, x, y, z);
	}

	@Override
	public float getSwingProgress(EntityLivingBase entityLivingBase, float partialTickTime) {
		return master != null ? master.getSwingProgress(entityLivingBase, partialTickTime) : super.getSwingProgress(entityLivingBase, partialTickTime);
	}

	@Override
	public float superGetSwingProgress(Object entityLivingBase, float partialTickTime) {
		return super.getSwingProgress((EntityLivingBase) entityLivingBase, partialTickTime);
	}

	@Override
	public float handleRotationFloat(EntityLivingBase entityLivingBase, float partialTicks) {
		return master != null ? master.handleRotationFloat(entityLivingBase, partialTicks) : super.handleRotationFloat(entityLivingBase, partialTicks);
	}

	@Override
	public float superHandleRotationFloat(Object entityLivingBase, float partialTicks) {
		return super.handleRotationFloat((EntityLivingBase) entityLivingBase, partialTicks);
	}

	@Override
	public float getDeathMaxRotation(EntityLivingBase entityLivingBase) {
		return master != null ? master.getDeathMaxRotation(entityLivingBase) : super.getDeathMaxRotation(entityLivingBase);
	}

	@Override
	public float superGetDeathMaxRotation(Object entityLivingBase) {
		return super.getDeathMaxRotation((EntityLivingBase) entityLivingBase);
	}

	@Override
	public int getColorMultiplier(EntityLivingBase entityLivingBase, float lightBrightness, float partialTickTime) {
		return master != null ? master.getColorMultiplier(entityLivingBase, lightBrightness, partialTickTime) : super.getColorMultiplier(entityLivingBase, lightBrightness, partialTickTime);
	}

	@Override
	public int superGetColorMultiplier(Object entityLivingBase, float lightBrightness, float partialTickTime) {
		return super.getColorMultiplier((EntityLivingBase) entityLivingBase, lightBrightness, partialTickTime);
	}

	@Override
	public void preRenderCallback(EntityLivingBase entityLivingBase, float partialTickTime) {
		if (master != null) master.preRenderCallback(entityLivingBase, partialTickTime);
		else super.preRenderCallback(entityLivingBase, partialTickTime);
	}

	@Override
	public void superPreRenderCallback(Object entityLivingBase, float partialTickTime) {
		super.preRenderCallback((EntityLivingBase) entityLivingBase, partialTickTime);
	}

	@Override
	public void doRender(EntityLiving entityLiving, double x, double y, double z, float entityYaw, float partialTicks) {
		if (master != null) master.doRender(entityLiving, x, y, z, entityYaw, partialTicks);
		else super.doRender(entityLiving, x, y, z, entityYaw, partialTicks);
	}
	// 180
	public void func_177069_a(Entity entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, float p_177069_9_, double p_177069_10_) {
	}

	@Override
	public void renderLivingLabel(Entity entity, String str, double x, double y, double z, int maxDistance) {
		if (master != null) master.renderLivingLabel(entity, str, x, y, z, maxDistance);
		else super.renderLivingLabel(entity, str, x, y, z, maxDistance);
	}

	@Override
	public void superRenderLivingLabel(Object entity, String str, double x, double y, double z, int maxDistance) {
		super.renderLivingLabel((Entity) entity, str, x, y, z, maxDistance);
	}
	// 190~
	@Override
	public int getTeamColor(Entity entity) {
		return master != null ? master.getTeamColor(entity) : super.getTeamColor(entity);
	}

	@Override
	public int superGetTeamColor(Object entity) {
		return super.getTeamColor((Entity) entity);
	}

	@Override
	public void renderEntityName(Entity entity, double x, double y, double z, String name, double p_188296_9_) {
		if (master != null) master.renderEntityName(entity, x, y, z, name, p_188296_9_);
		else super.renderEntityName(entity, x, y, z, name, p_188296_9_);
	}

	@Override
	public void superRenderEntityName(Object entity, double x, double y, double z, String name, double p_188296_9_) {
		super.renderEntityName((Entity) entity, x, y, z, name, p_188296_9_);
	}

	@Override
	public boolean isMultipass() {
		return master != null ? master.isMultipass() : super.isMultipass();
	}

	@Override
	public boolean superIsMultipass() {
		return super.isMultipass();
	}

	@Override
	public void renderMultipass(Entity entity, double p_188300_2_, double p_188300_4_, double p_188300_6_, float p_188300_8_, float p_188300_9_) {
		if (master != null) master.renderMultipass(entity, p_188300_2_, p_188300_4_, p_188300_6_, p_188300_8_, p_188300_9_);
		else super.renderMultipass(entity, p_188300_2_, p_188300_4_, p_188300_6_, p_188300_8_, p_188300_9_);
	}

	@Override
	public void superRenderMultipass(Object entity, double p_188300_2_, double p_188300_4_, double p_188300_6_, float p_188300_8_, float p_188300_9_) {
		super.renderMultipass((Entity) entity, p_188300_2_, p_188300_4_, p_188300_6_, p_188300_8_, p_188300_9_);
	}

	@Override
	public float prepareScale(EntityLivingBase entityLivingBase, float partialTicks) {
		return master != null ? master.prepareScale(entityLivingBase, partialTicks) : super.prepareScale(entityLivingBase, partialTicks);
	}

	@Override
	public float superPrepareScale(Object entityLivingBase, float partialTicks) {
		return super.prepareScale((EntityLivingBase) entityLivingBase, partialTicks);
	}
	// 164~
	public boolean canRenderName(Entity entity) {
		return master != null ? master.canRenderName(entity) : super.canRenderName((EntityLiving) entity);
	}

	@Override
	public boolean superCanRenderName(Object entity) {
		return super.canRenderName((EntityLiving) entity);
	}

	@Override
	public void renderLeash(EntityLiving entityLiving, double x, double y, double z, float entityYaw, float partialTicks) {
		if (master != null) master.renderLeash(entityLiving, x, y, z, entityYaw, partialTicks);
		else super.renderLeash(entityLiving, x, y, z, entityYaw, partialTicks);
	}

	@Override
	public void superRenderLeash(Object entityLiving, double x, double y, double z, float entityYaw, float partialTicks) {
		super.renderLeash((EntityLiving) entityLiving, x, y, z, entityYaw, partialTicks);
	}
	// ~189
	public void renderOffsetLivingLabel(Entity entity, double x, double y, double z, String str, float p_177069_9_, double p_177069_10_) {
	}

	@Override
	public void superRenderOffsetLivingLabel(Object entity, double x, double y, double z, String str, float p_177069_9_, double p_177069_10_) {
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

	public void func_96449_a(EntityLivingBase entityLivingBase, double p_96449_2_, double p_96449_4_, double p_96449_6_, String p_96449_8_, float p_96449_9_, double p_96449_10_) {
	}
	// ~164
	public void doRenderLiving(EntityLivingBase entityLivingBase, double par2, double par4, double par6, float par8, float par9) {
	}

	@Override
	public void superDoRenderLiving(Object entityLiving, double par2, double par4, double par6, float par8, float par9) {
		super.doRender((EntityLiving) entityLiving, par2, par4, par6, par8, par9);
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
	public boolean setScoreTeamColor(EntityLivingBase entityLivingBase) {
		return master != null ? master.setScoreTeamColor(entityLivingBase) : super.setScoreTeamColor(entityLivingBase);
	}

	@Override
	public boolean superSetScoreTeamColor(Object entityLivingBase) {
		return super.setScoreTeamColor((EntityLivingBase) entityLivingBase);
	}

	@Override
	public void unsetScoreTeamColor() {
		if (master != null) master.unsetScoreTeamColor();
		else super.unsetScoreTeamColor();
	}

	@Override
	public void superUnsetScoreTeamColor() {
		super.unsetScoreTeamColor();
	}

	@Override
	public boolean setDoRenderBrightness(EntityLivingBase entityLivingBase, float partialTicks) {
		return master != null ? master.setDoRenderBrightness(entityLivingBase, partialTicks) : super.setDoRenderBrightness(entityLivingBase, partialTicks);
	}

	@Override
	public boolean superSetDoRenderBrightness(Object entityLivingBase, float partialTicks) {
		return super.setDoRenderBrightness((EntityLivingBase) entityLivingBase, partialTicks);
	}

	@Override
	public boolean setBrightness(EntityLivingBase entityLivingBase, float partialTicks, boolean combineTextures) {
		return master != null ? master.setBrightness(entityLivingBase, partialTicks, combineTextures) : super.setBrightness(entityLivingBase, partialTicks, combineTextures);
	}

	@Override
	public boolean superSetBrightness(Object entityLivingBase, float partialTicks, boolean combineTextures) {
		return super.setBrightness((EntityLivingBase) entityLivingBase, partialTicks, combineTextures);
	}

	@Override
	public void unsetBrightness() {
		if (master != null) master.unsetBrightness();
		else super.unsetBrightness();
	}

	@Override
	public void superUnsetBrightness() {
		super.unsetBrightness();
	}

	@Override
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

	@Override
	public ModelBase getMainModel() {
		return (ModelBase) (master != null ? master.getMainModel() : super.getMainModel());
	}

	@Override
	public ModelBase superGetMainModel() {
		return super.getMainModel();
	}

	@Override
	public float interpolateRotation(float prevYawOffset, float yawOffset, float partialTicks) {
		return master != null ? master.interpolateRotation(prevYawOffset, yawOffset, partialTicks) : super.interpolateRotation(prevYawOffset, yawOffset, partialTicks);
	}

	@Override
	public float superInterpolateRotation(float prevYawOffset, float yawOffset, float partialTicks) {
		return super.interpolateRotation(prevYawOffset, yawOffset, partialTicks);
	}

	@Override
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

	@Override
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
	// 162~
	@Override
	public boolean bindEntityTexture(Entity entity) {
		return master != null ? master.bindEntityTexture(entity) : super.bindEntityTexture(entity);
	}

	@Override
	public boolean superBindEntityTexture(Object entity) {
		return super.bindEntityTexture((Entity) entity);
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
				layerRenderers.set(i, layer);
				return;
			}
		}
		addLayer((LayerRenderer<EntityLivingBase>) layer);
	}

	@Override
	public List getLayerList() {
		return layerRenderers;
	}

	@Override
	public void superSetLightmap(Object entityLiving, float partialTicks) {
	}

}
