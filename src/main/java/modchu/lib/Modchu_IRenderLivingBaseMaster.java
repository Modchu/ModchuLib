package modchu.lib;

public interface Modchu_IRenderLivingBaseMaster extends Modchu_IRenderMaster {
	public int setArmorModel(Object entity, int i, float f);
	public int setArmorModel(Object model, Object entityplayer, int i, float f, int i2);

	public void preRenderCallback(Object entityliving, float f);
	public void renderEquippedItems(Object entityliving, float f);
	public void renderScale(Object entity, float f);
	public int shouldRenderPass(Object entityliving, int i, float f);
	public void passSpecialRender(Object entityLiving, double d, double d1, double d2);
	public int inheritRenderPass(Object entity, int par2, float par3);
	public void renderModel(Object entity, float par2, float par3, float par4, float par5, float par6, float par7);
	public int getColorMultiplier(Object entity, float par2, float par3);
	public void renderSpecials(Object entityPlayer, float f);
	public Object getMainModel();
	public boolean addLayer(Object layerRenderer);
	public boolean removeLayer(Object layerRenderer);
	public float interpolateRotation(float p_77034_1_, float p_77034_2_, float p_77034_3_);
	public boolean setScoreTeamColor(Object entityLivingBase);
	public void unsetScoreTeamColor();
	public boolean setDoRenderBrightness(Object entityLivingBase, float p_177090_2_);
	public boolean setBrightness(Object entityLivingBase, float p_177092_2_, boolean p_177092_3_);
	public void unsetBrightness();
	public float getSwingProgress(Object entityLivingBase, float p_77040_2_);
	//public float renderSwingProgress(Object entityLivingBase, float par2);
	public float handleRotationFloat(Object entityLivingBase, float p_77044_2_);
	public void renderLayers(Object entityLivingBase, float p_177093_2_, float p_177093_3_, float p_177093_4_, float p_177093_5_, float p_177093_6_, float p_177093_7_, float p_177093_8_);
	public float getDeathMaxRotation(Object entityLivingBase);
	public boolean canRenderName(Object entityLivingBase);
	public void setRenderOutlines(boolean p_177086_1_);
	public void renderName(Object entity, double x, double y, double z);
	public boolean shouldRender(Object entity, Object iCamera, double camX, double camY, double camZ);
	public void transformHeldFull3DItemLayer();
	public void renderLivingAt(Object entityLivingBase, double p_77039_2_, double p_77039_4_, double p_77039_6_);
	public void rotateCorpse(Object entityLivingBase, float p_77043_2_, float p_77043_3_, float p_77043_4_);
	public void renderOffsetLivingLabel(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, float p_177069_9_, double p_177069_10_);
	public void setRenderPassModel(Object modelBase);
	public void renderArrowsStuckInEntity(Object entityLivingBase, float par2);
	public void func_82408_c(Object entityLivingBase, int par2, float par3);
	public void func_96449_a(Object entityLivingBase, double par2, double par4, double par6, String par8Str, float par9, double par10);
	public boolean isStaticEntity();
	public void setRenderManager(Object renderManager);
	public void updateIcons(Object iIconRegister);
	public float prepareScale(Object entityLivingBase, float partialTicks);
	public void doRenderLiving(Object entityLivingBase, double par2, double par4, double par6, float par8, float par9);

}
