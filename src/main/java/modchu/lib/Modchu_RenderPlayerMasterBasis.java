package modchu.lib;

import java.util.HashMap;

public class Modchu_RenderPlayerMasterBasis implements Modchu_IRenderPlayerMaster {
	public Modchu_IRenderPlayer base;

	public Modchu_RenderPlayerMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IRenderPlayer) map.get("base");
	}

	@Override
	public int setArmorModel(Object entity, int i, float f) {
		return base.superSetArmorModel(null, entity, i, f, 0);
	}

	@Override
	public int setArmorModel(Object model, Object entityplayer, int i, float f, int i2) {
		return base.superSetArmorModel(model, entityplayer, i, f, i2);
	}

	@Override
	public void preRenderCallback(Object entityliving, float f) {
		base.superPreRenderCallback(entityliving, f);
	}

	@Override
	public void renderEquippedItems(Object entityliving, float f) {
		base.superRenderEquippedItems(entityliving, f);
	}

	@Override
	public void renderScale(Object entity, float f) {
	}

	@Override
	public int shouldRenderPass(Object entityliving, int i, float f) {
		return base.superShouldRenderPass(entityliving, i, f);
	}

	@Override
	public void passSpecialRender(Object entityLiving, double d, double d1, double d2) {
		base.superPassSpecialRender(entityLiving, d, d1, d2);
	}

	@Override
	public int inheritRenderPass(Object entity, int par2, float par3) {
		return base.superInheritRenderPass(entity, par2, par3);
	}

	@Override
	public void renderModel(Object entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		base.superRenderModel(entity, par2, par3, par4, par5, par6, par7);
	}

	@Override
	public int getColorMultiplier(Object entity, float par2, float par3) {
		return base.superGetColorMultiplier(entity, par2, par3);
	}

	@Override
	public void renderSpecials(Object entityPlayer, float f) {
	}

	@Override
	public void renderLivingLabel(Object entityplayer, String par2Str, double d, double d1, double d2, int i) {
		base.superRenderLivingLabel(entityplayer, par2Str, d, d1, d2, i);
	}

	@Override
	public Object getMainModel() {
		return base.superGetMainModel();
	}

	@Override
	public boolean addLayer(Object layerRenderer) {
		return base.superAddLayer(layerRenderer);
	}

	@Override
	public boolean removeLayer(Object layerRenderer) {
		return base.superRemoveLayer(layerRenderer);
	}

	@Override
	public float interpolateRotation(float p_77034_1_, float p_77034_2_, float p_77034_3_) {
		return base.superInterpolateRotation(p_77034_1_, p_77034_2_, p_77034_3_);
	}

	@Override
	public boolean setScoreTeamColor(Object entityLivingBase) {
		return base.superSetScoreTeamColor(entityLivingBase);
	}

	@Override
	public void unsetScoreTeamColor() {
		base.superUnsetScoreTeamColor();
	}

	@Override
	public boolean setDoRenderBrightness(Object entityLivingBase, float p_177090_2_) {
		return base.superSetDoRenderBrightness(entityLivingBase, p_177090_2_);
	}

	@Override
	public boolean setBrightness(Object entityLivingBase, float p_177092_2_, boolean p_177092_3_) {
		return base.superSetBrightness(entityLivingBase, p_177092_2_, p_177092_3_);
	}

	@Override
	public void unsetBrightness() {
		base.superUnsetBrightness();
	}

	@Override
	public float getSwingProgress(Object entityLivingBase, float p_77040_2_) {
		return base.superGetSwingProgress(entityLivingBase, p_77040_2_);
	}

	@Override
	public float handleRotationFloat(Object entityLivingBase, float p_77044_2_) {
		return base.superHandleRotationFloat(entityLivingBase, p_77044_2_);
	}

	@Override
	public void renderLayers(Object entityLivingBase, float p_177093_2_, float p_177093_3_, float p_177093_4_, float p_177093_5_, float p_177093_6_, float p_177093_7_, float p_177093_8_) {
		base.superRenderLayers(entityLivingBase, p_177093_2_, p_177093_3_, p_177093_4_, p_177093_5_, p_177093_6_, p_177093_7_, p_177093_8_);
	}

	@Override
	public float getDeathMaxRotation(Object entityLivingBase) {
		return base.superGetDeathMaxRotation(entityLivingBase);
	}

	@Override
	public boolean canRenderName(Object entityLivingBase) {
		return base.superCanRenderName(entityLivingBase);
	}

	@Override
	public void setRenderOutlines(boolean p_177086_1_) {
		base.superSetRenderOutlines(p_177086_1_);
	}

	@Override
	public void renderName(Object entity, double x, double y, double z) {
		base.superRenderName(entity, x, y, z);
	}

	@Override
	public boolean shouldRender(Object entity, Object iCamera, double camX, double camY, double camZ) {
		return base.superShouldRender(entity, iCamera, camX, camY, camZ);
	}

	@Override
	public void doRender(Object entity, double d, double d1, double d2, float d3, float d4) {
		base.superDoRenderLiving(entity, d, d1, d2, d3, d4);
	}

	@Override
	public Object getEntityTexture(Object entity) {
		return base.superGetEntityTexture(entity);
	}

	@Override
	public Object getEntityTexture(Object entity, int i) {
		return base.superGetEntityTexture(entity, i);
	}

	@Override
	public boolean bindEntityTexture(Object entity) {
		return base.superBindEntityTexture(entity);
	}

	@Override
	public void bindTexture(Object resourceLocation) {
		base.superBindTexture(resourceLocation);
	}

	@Override
	public void doRenderShadowAndFire(Object entity, double p_76979_2_, double p_76979_4_, double p_76979_6_, float p_76979_8_, float p_76979_9_) {
		base.superDoRenderShadowAndFire(entity, p_76979_2_, p_76979_4_, p_76979_6_, p_76979_8_, p_76979_9_);
	}

	@Override
	public Object getFontRendererFromRenderManager() {
		return base.superGetFontRendererFromRenderManager();
	}

	@Override
	public Object getRenderManager() {
		return base.superGetRenderManager();
	}

	@Override
	public void renderFirstPersonArm(Object entityplayer, int i) {
		base.superRenderFirstPersonArm(entityplayer, i);
	}

	@Override
	public boolean isActivatedForPlayer(Object entityPlayer) {
		return base.superIsActivatedForPlayer(entityPlayer);
	}

	@Override
	public void renderPlayerSleep(Object entityPlayer, double var2, double var4, double var6) {
		base.superRenderPlayerSleep(entityPlayer, var2, var4, var6);
	}

	@Override
	public void rotatePlayer(Object entityPlayer, float var2, float var3, float var4) {
		base.superRotatePlayer(entityPlayer, var2, var3, var4);
	}

	@Override
	public void renderPlayerAt(Object entityPlayer, double var2, double var4, double var6) {
		base.superRenderPlayerAt(entityPlayer, var2, var4, var6);
	}

	@Override
	public void renderGuiIngame(Object var0) {
		base.superRenderGuiIngame(var0);
	}

	@Override
	public Object func_180594_a(Object abstractClientPlayer) {
		return base.superFunc_180594_a(abstractClientPlayer);
	}

	@Override
	public void transformHeldFull3DItemLayer() {
		base.superTransformHeldFull3DItemLayer();
	}

	@Override
	public void renderOffsetLivingLabel(Object abstractClientPlayer, double p_96449_2_, double p_96449_4_, double p_96449_6_, String p_96449_8_, float p_96449_9_, double p_96449_10_) {
		base.superRenderOffsetLivingLabel(abstractClientPlayer, p_96449_2_, p_96449_4_, p_96449_6_, p_96449_8_, p_96449_9_, p_96449_10_);
	}

	@Override
	public void func_177139_c(Object abstractClientPlayer) {
		base.superFunc_177139_c(abstractClientPlayer);
	}

	@Override
	public void rotateCorpse(Object entityLivingBase, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
		base.superRotateCorpse(entityLivingBase, p_77043_2_, p_77043_3_, p_77043_4_);
	}

	@Override
	public void renderLivingAt(Object entityLivingBase, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
		base.superRenderLivingAt(entityLivingBase, p_77039_2_, p_77039_4_, p_77039_6_);
	}

	@Override
	public void setRenderPassModel(Object modelBase) {
		base.superSetRenderPassModel(modelBase);
	}

	@Override
	public float renderSwingProgress(Object entityLivingBase, float par2) {
		return base.superRenderSwingProgress(entityLivingBase, par2);
	}

	@Override
	public void renderArrowsStuckInEntity(Object entityLivingBase, float par2) {
		base.superRenderArrowsStuckInEntity(entityLivingBase, par2);
	}

	@Override
	public void func_82408_c(Object entityLivingBase, int par2, float par3) {
		base.superFunc_82408_c(entityLivingBase, par2, par3);
	}

	@Override
	public void func_96449_a(Object entityLivingBase, double par2, double par4, double par6, String par8Str, float par9, double par10) {
		base.superFunc_96449_a(entityLivingBase, par2, par4, par6, par8Str, par9, par10);
	}

	@Override
	public boolean isStaticEntity() {
		return base.superIsStaticEntity();
	}

	@Override
	public void setRenderManager(Object renderManager) {
		base.superSetRenderManager(renderManager);
	}

	@Override
	public void updateIcons(Object iIconRegister) {
		base.superUpdateIcons(iIconRegister);
	}

	@Override
	public void func_147906_a(Object entity, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_) {
		base.superFunc_147906_a(entity, p_147906_2_, p_147906_3_, p_147906_5_, p_147906_7_, p_147906_9_);
	}

	@Override
	public void renderFirstPersonLeftArm(Object entityplayer, int i) {
		base.superFunc_177139_c(entityplayer);
	}
	// ~152
	@Override
	public void loadTexture(String par1Str) {
		base.superLoadTexture(par1Str);
	}

	@Override
	public boolean loadDownloadableImageTexture(String par1Str, String par2Str) {
		return base.superLoadDownloadableImageTexture(par1Str, par2Str);
	}

	@Override
	public void renderEntityName(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, double p_177069_10_) {
		base.superRenderEntityName(entity, p_177069_2_, p_177069_4_, p_177069_6_, p_177069_8_, p_177069_10_);
	}

}
