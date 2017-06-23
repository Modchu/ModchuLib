package modchu.lib.forge.mc164;

import java.util.HashMap;
import java.util.List;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IRenderLiving;
import modchu.lib.Modchu_IRenderLivingMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class Modchu_RenderLiving extends RenderLiving implements Modchu_IRenderLiving {
	public Modchu_IRenderLivingMaster master;

	public Modchu_RenderLiving(HashMap<String, Object> map) {
		super((ModelBase) map.get("Object"), (Float) map.get("Float"));
		renderManager = (RenderManager) Modchu_AS.get(Modchu_AS.renderManagerInstance);
		Modchu_Debug.lDebug("Modchu_RenderLiving init renderManager="+renderManager);
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
	public void doRender(Entity entity, double x, double y, double z, float entityYaw, float partialTicks) {
		if (master != null) master.doRender(entity, x, y, z, entityYaw, partialTicks);
		else super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

	@Override
	public void superDoRender(Object entity, double x, double y, double z, float entityYaw, float partialTicks) {
		super.doRender((EntityLiving) entity, x, y, z, entityYaw, partialTicks);
	}

	@Override
	public ResourceLocation getEntityTexture(Entity entity) {
		return (ResourceLocation) (master != null ? master.getEntityTexture(entity) : null);
	}

	@Override
	public ResourceLocation superGetEntityTexture(Object entity) {
		return null;
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
		else super.doRender(entityLivingBase, x, y, z, entityYaw, partialTicks);
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
	public void rotateCorpse(EntityLivingBase entityLivingBase, float p_77043_2_, float p_77043_3_, float partialTicks) {
		if (master != null) master.applyRotations(entityLivingBase, p_77043_2_, p_77043_3_, partialTicks);
		else super.rotateCorpse(entityLivingBase, p_77043_2_, p_77043_3_, partialTicks);
	}

	@Override
	public void superApplyRotations(Object entityLivingBase, float p_77043_2_, float p_77043_3_, float partialTicks) {
		super.rotateCorpse((EntityLivingBase) entityLivingBase, p_77043_2_, p_77043_3_, partialTicks);
	}

	@Override
	public float renderSwingProgress(EntityLivingBase entityLivingBase, float partialTickTime) {
		return master != null ? master.getSwingProgress(entityLivingBase, partialTickTime) : super.renderSwingProgress(entityLivingBase, partialTickTime);
	}

	@Override
	public float superGetSwingProgress(Object entityLivingBase, float partialTickTime) {
		return super.renderSwingProgress((EntityLivingBase) entityLivingBase, partialTickTime);
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

	public void doRender(EntityLiving entityLiving, double x, double y, double z, float entityYaw, float partialTicks) {
		if (master != null) master.doRender(entityLiving, x, y, z, entityYaw, partialTicks);
		else super.doRender(entityLiving, x, y, z, entityYaw, partialTicks);
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

	public void setLightmap(EntityLiving entityLiving, float partialTicks) {
	}
	// 164~
	@Override
	protected void renderLivingLabel(EntityLivingBase entityLivingBase, String str, double x, double y, double z, int maxDistance) {
		if (master != null) master.renderLivingLabel(entityLivingBase, str, x, y, z, maxDistance);
		else super.renderLivingLabel(entityLivingBase, str, x, y, z, maxDistance);
	}

	@Override
	public void superRenderLivingLabel(Object entity, String str, double x, double y, double z, int maxDistance) {
		super.renderLivingLabel((EntityLivingBase) entity, str, x, y, z, maxDistance);
	}

	@Override
	protected boolean func_110813_b(EntityLivingBase entityLivingBase) {
		return master != null ? master.canRenderName(entityLivingBase) : super.func_110813_b(entityLivingBase);
	}

	@Override
	public boolean superCanRenderName(Object entityLivingBase) {
		return super.func_110813_b((EntityLivingBase) entityLivingBase);
	}

	@Override
	protected void func_110827_b(EntityLiving entityLiving, double x, double y, double z, float entityYaw, float partialTicks) {
		if (master != null) master.renderLeash(entityLiving, x, y, z, entityYaw, partialTicks);
		else super.func_110827_b(entityLiving, x, y, z, entityYaw, partialTicks);
	}

	@Override
	public void superRenderLeash(Object entityLiving, double p_110827_2_, double p_110827_4_, double p_110827_6_, float p_110827_8_, float p_110827_9_) {
		super.func_110827_b((EntityLiving) entityLiving, p_110827_2_, p_110827_4_, p_110827_6_, p_110827_8_, p_110827_9_);
	}
	// ~180
	@Override
	public void passSpecialRender(EntityLivingBase entityLivingBase, double p_77033_2_, double p_77033_4_, double p_77033_6_) {
		if (master != null) master.passSpecialRender(entityLivingBase, p_77033_2_, p_77033_4_, p_77033_6_);
		else super.passSpecialRender(entityLivingBase, p_77033_2_, p_77033_4_, p_77033_6_);
	}

	@Override
	public void superPassSpecialRender(Object entityLivingBase, double p_77033_2_, double p_77033_4_, double p_77033_6_) {
		super.passSpecialRender((EntityLivingBase) entityLivingBase, p_77033_2_, p_77033_4_, p_77033_6_);
	}
	// 180~189
	public void func_177105_a(EntityLiving entityLiving, float partialTicks) {
	}

	@Override
	public void superSetLightmap(Object entityLiving, float partialTicks) {
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
	@Override
	public void setRenderManager(RenderManager renderManager) {
		if (master != null) master.setRenderManager(renderManager);
		else super.setRenderManager(renderManager);
	}

	@Override
	public void superSetRenderManager(Object renderManager) {
		super.setRenderManager((RenderManager) renderManager);
	}

	@Override
	public void updateIcons(IconRegister iIconRegister) {
		if (master != null) master.updateIcons(iIconRegister);
		else super.updateIcons(iIconRegister);
	}

	@Override
	public void superUpdateIcons(Object iIconRegister) {
		super.updateIcons((IconRegister) iIconRegister);
	}

	@Override
	public void setRenderPassModel(ModelBase modelBase) {
		if (master != null) master.setRenderPassModel(modelBase);
		else super.setRenderPassModel(modelBase);
	}

	@Override
	public void superSetRenderPassModel(Object modelBase) {
		super.setRenderPassModel((ModelBase) modelBase);
	}

	@Override
	public void renderEquippedItems(EntityLivingBase entityLivingBase, float p_77029_2_) {
		if (master != null) master.renderEquippedItems(entityLivingBase, p_77029_2_);
		else super.renderEquippedItems(entityLivingBase, p_77029_2_);
	}

	@Override
	public void superRenderEquippedItems(Object entityLivingBase, float p_77029_2_) {
		super.renderEquippedItems((EntityLivingBase) entityLivingBase, p_77029_2_);
	}

	@Override
	public void renderArrowsStuckInEntity(EntityLivingBase entityLivingBase, float p_85093_2_) {
		if (master != null) master.renderArrowsStuckInEntity(entityLivingBase, p_85093_2_);
		else super.renderArrowsStuckInEntity(entityLivingBase, p_85093_2_);
	}

	@Override
	public void superRenderArrowsStuckInEntity(Object entityLivingBase, float p_85093_2_) {
		super.renderArrowsStuckInEntity((EntityLivingBase) entityLivingBase, p_85093_2_);
	}

	@Override
	public int inheritRenderPass(EntityLivingBase entityLivingBase, int p_77035_2_, float p_77035_3_) {
		return master != null ? master.inheritRenderPass(entityLivingBase, p_77035_2_, p_77035_3_) : super.inheritRenderPass(entityLivingBase, p_77035_2_, p_77035_3_);
	}

	@Override
	public int superInheritRenderPass(Object entityLivingBase, int p_77035_2_, float p_77035_3_) {
		return super.inheritRenderPass((EntityLivingBase) entityLivingBase, p_77035_2_, p_77035_3_);
	}

	@Override
	public int shouldRenderPass(EntityLivingBase entityLivingBase, int p_77032_2_, float p_77032_3_) {
		return master != null ? master.shouldRenderPass(entityLivingBase, p_77032_2_, p_77032_3_) : super.shouldRenderPass(entityLivingBase, p_77032_2_, p_77032_3_);
	}

	@Override
	public int superShouldRenderPass(Object entityLivingBase, int p_77032_2_, float p_77032_3_) {
		return super.shouldRenderPass((EntityLivingBase) entityLivingBase, p_77032_2_, p_77032_3_);
	}

	@Override
	public void func_82408_c(EntityLivingBase entityLivingBase, int p_82408_2_, float p_82408_3_) {
		if (master != null) master.func_82408_c(entityLivingBase, p_82408_2_, p_82408_3_);
		else super.func_82408_c(entityLivingBase, p_82408_2_, p_82408_3_);
	}

	@Override
	public void superFunc_82408_c(Object entityLivingBase, int p_82408_2_, float p_82408_3_) {
		super.func_82408_c((EntityLivingBase) entityLivingBase, p_82408_2_, p_82408_3_);
	}

	@Override
	public void func_96449_a(EntityLivingBase entityLivingBase, double p_96449_2_, double p_96449_4_, double p_96449_6_, String p_96449_8_, float p_96449_9_, double p_96449_10_) {
		if (master != null) master.func_96449_a(entityLivingBase, p_96449_2_, p_96449_4_, p_96449_6_, p_96449_8_, p_96449_9_, p_96449_10_);
		else super.func_96449_a(entityLivingBase, p_96449_2_, p_96449_4_, p_96449_6_, p_96449_8_, p_96449_9_, p_96449_10_);
	}

	@Override
	public void superRenderOffsetLivingLabel(Object entityLivingBase, double p_96449_2_, double p_96449_4_, double p_96449_6_, String p_96449_8_, float p_96449_9_, double p_96449_10_) {
		super.func_96449_a((EntityLivingBase) entityLivingBase, p_96449_2_, p_96449_4_, p_96449_6_, p_96449_8_, p_96449_9_, p_96449_10_);
	}
	// ~164
	@Override
	public void doRenderLiving(EntityLivingBase entityLivingBase, double par2, double par4, double par6, float par8, float par9) {
		super.doRenderLiving(entityLivingBase, par2, par4, par6, par8, par9);
	}

	@Override
	public void superDoRenderLiving(Object entityLiving, double par2, double par4, double par6, float par8, float par9) {
		super.doRenderLiving((EntityLiving) entityLiving, par2, par4, par6, par8, par9);
	}

	@Override
	public void doRenderLiving(EntityLiving entityLiving, double par2, double par4, double par6, float par8, float par9) {
		if (master != null) master.doRenderLiving(entityLiving, par2, par4, par6, par8, par9);
		else super.doRenderLiving(entityLiving, par2, par4, par6, par8, par9);
	}

	@Override
	public boolean func_130007_b(EntityLiving entityLiving) {
		return master != null ? master.func_130007_b(entityLiving) : super.func_130007_b(entityLiving);
	}

	@Override
	public boolean superFunc_130007_b(Object entityLiving) {
		return super.func_130007_b((EntityLiving) entityLiving);
	}
	// 180~
	public ModelBase getMainModel() {
		return (ModelBase) (master != null ? master.getMainModel() : mainModel);
	}

	@Override
	public ModelBase superGetMainModel() {
		return mainModel;
	}

	public RenderManager getRenderManager() {
		return renderManager;
	}

	@Override
	public RenderManager superGetRenderManager() {
		return renderManager;
	}

	public boolean addLayer(Object layerRenderer) {
		return false;
	}

	@Override
	public boolean superAddLayer(Object layerRenderer) {
		return false;
	}

	public boolean removeLayer(Object layerRenderer) {
		return false;
	}

	@Override
	public boolean superRemoveLayer(Object layerRenderer) {
		return false;
	}

	public float interpolateRotation(float prevYawOffset, float yawOffset, float partialTicks) {
		return 0.0F;
	}

	@Override
	public float superInterpolateRotation(float prevYawOffset, float yawOffset, float partialTicks) {
		return 0.0F;
	}

	public void setRenderOutlines(boolean renderOutlinesIn) {
	}

	@Override
	public void superSetRenderOutlines(boolean renderOutlinesIn) {
	}

	public boolean shouldRender(Entity entity, ICamera iCamera, double camX, double camY, double camZ) {
		return false;
	}

	@Override
	public boolean superShouldRender(Object entity, Object iCamera, double camX, double camY, double camZ) {
		return false;
	}

	public void renderName(Entity entity, double x, double y, double z) {
	}

	@Override
	public void superRenderName(Object entity, double x, double y, double z) {
	}

	public void renderName(EntityLivingBase entityLivingBase, double x, double y, double z) {
	}

	public boolean canRenderName(EntityLivingBase entityLivingBase) {
		return false;
	}

	public boolean canRenderName(EntityLiving entityLiving) {
		return false;
	}

	public boolean shouldRender(EntityLiving entityLiving, ICamera iCamera, double camX, double camY, double camZ) {
		return false;
	}
	// 188~
	public void transformHeldFull3DItemLayer() {
	}

	@Override
	public void superTransformHeldFull3DItemLayer() {
	}

	public boolean setScoreTeamColor(EntityLivingBase entityLivingBase) {
		return false;
	}

	@Override
	public boolean superSetScoreTeamColor(Object entityLivingBase) {
		return false;
	}

	public void unsetScoreTeamColor() {
	}

	@Override
	public void superUnsetScoreTeamColor() {
	}

	public boolean setDoRenderBrightness(EntityLivingBase entityLivingBase, float partialTicks) {
		return false;
	}

	@Override
	public boolean superSetDoRenderBrightness(Object entityLivingBase, float partialTicks) {
		return false;
	}

	public boolean setBrightness(EntityLivingBase entityLivingBase, float partialTicks, boolean combineTextures) {
		return false;
	}

	@Override
	public boolean superSetBrightness(Object entityLivingBase, float partialTicks, boolean combineTextures) {
		return false;
	}

	public void unsetBrightness() {
	}

	@Override
	public void superUnsetBrightness() {
	}

	public void renderLayers(EntityLivingBase entityLivingBase, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scaleIn) {
	}

	@Override
	public void superRenderLayers(Object entityLivingBase, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scaleIn) {
	}
	// 162~
	@Override
	public void bindEntityTexture(Entity entity) {
		if (master != null) master.bindEntityTexture(entity);
		else super.bindEntityTexture(entity);
	}

	@Override
	public boolean superBindEntityTexture(Object entity) {
		super.bindEntityTexture((Entity) entity);
		return true;
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

	public Object getRenderPassModel() {
		return null;
	}

	@Override
	public Object getRenderPassModel(int i) {
		return getRenderPassModel();
	}

	@Override
	public void setRenderPassModel(Object model, Object model2) {
	}

	@Override
	public Object getLayerArmorBase() {
		return null;
	}

	@Override
	public Object getLayerHeldItem() {
		return null;
	}

	@Override
	public Object getLayerCustomHead() {
		return null;
	}

	@Override
	public void setLayer(Class c, Object layer) {
	}

	@Override
	public List getLayerList() {
		return null;
	}

	@Override
	public void superFunc_110777_b(Object entity) {
		superBindEntityTexture(entity);
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
		return super.renderSwingProgress((EntityLivingBase) entityLivingBase, par2);
	}

	@Override
	public boolean superFunc_110813_b(Object entityLivingBase) {
		return super.func_110813_b((EntityLivingBase) entityLivingBase);
	}

	@Override
	public void superSetLightmap(Object entityLiving) {
	}

	@Override
	public boolean superIsVisible(Object entityLivingBase) {
		return false;
	}

}
