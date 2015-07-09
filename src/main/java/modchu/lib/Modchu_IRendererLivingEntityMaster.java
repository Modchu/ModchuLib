package modchu.lib;

public interface Modchu_IRendererLivingEntityMaster extends Modchu_IRenderMaster {
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
	public boolean func_177088_c(Object entityLivingBase);
	public void func_180565_e();
	public boolean func_177090_c(Object entityLivingBase, float p_177090_2_);
	public boolean func_177092_a(Object entityLivingBase, float p_177092_2_, boolean p_177092_3_);
	public void func_177091_f();
	public float getSwingProgress(Object entityLivingBase, float p_77040_2_);
	public float handleRotationFloat(Object entityLivingBase, float p_77044_2_);
	public void func_177093_a(Object entityLivingBase, float p_177093_2_, float p_177093_3_, float p_177093_4_, float p_177093_5_, float p_177093_6_, float p_177093_7_, float p_177093_8_);
	public float getDeathMaxRotation(Object entityLivingBase);
	public boolean canRenderName(Object entityLivingBase);
	public void setRenderOutlines(boolean p_177086_1_);
	public void renderName(Object entity, double x, double y, double z);
	public boolean shouldRender(Object entity, Object iCamera, double camX, double camY, double camZ);
	public void func_82422_c();
	public void renderLivingAt(Object entityLivingBase, double p_77039_2_, double p_77039_4_, double p_77039_6_);
	public void rotateCorpse(Object entityLivingBase, float p_77043_2_, float p_77043_3_, float p_77043_4_);
	public void func_177069_a(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, float p_177069_9_, double p_177069_10_);
	public void setRenderPassModel(Object modelBase);
	public float renderSwingProgress(Object entityLivingBase, float par2);
	public void renderArrowsStuckInEntity(Object entityLivingBase, float par2);
	public void func_82408_c(Object entityLivingBase, int par2, float par3);
	public boolean func_110813_b(Object entityLivingBase);
	public void func_96449_a(Object entityLivingBase, double par2, double par4, double par6, String par8Str, float par9, double par10);
	public boolean isStaticEntity();
	public void setRenderManager(Object renderManager);
	public void updateIcons(Object iIconRegister);
	public void func_147906_a(Object entity, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_);

}
