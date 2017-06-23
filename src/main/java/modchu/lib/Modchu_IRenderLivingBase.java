package modchu.lib;

import java.util.List;

public interface Modchu_IRenderLivingBase extends Modchu_IRender {
	public void superFunc_96449_a(Object entityLivingBase, double par2, double par4, double par6, String par8Str, float par9, double par10);
	public void superRotateCorpse(Object entityLivingBase, float par2, float par3, float par4);
	public float superRenderSwingProgress(Object entityLivingBase, float par2);
	public boolean superFunc_110813_b(Object entityLivingBase);
	public int setArmorModel(Object entity, int i, float f);
	public int setArmorModel(Object model, Object entityplayer, int i, float f, int i2);
	public int superSetArmorModel(Object entity, int i, float f);
	public int superSetArmorModel(Object model, Object entity, int i, float f, int j);

	public void superFunc_110777_b(Object entity);
	public void setLayer(Class c, Object layer);
	public void superPreRenderCallback(Object entityLivingBase, float par2);
	public void superDoRenderLiving(Object entity, double d, double d1, double d2, float f, float f1);
	public void superPassSpecialRender(Object entityLiving, double d, double d1, double d2);
	public Object getRenderPassModel(int i);
	public void setRenderPassModel(Object model, Object model2);
	public Object getLayerArmorBase();
	public Object getLayerHeldItem();
	public Object getLayerCustomHead();
	public List getLayerList();
	public void superBindTexture(Object resourceLocation);
	public void superDoRenderShadowAndFire(Object entity, double p_76979_2_, double p_76979_4_, double p_76979_6_, float p_76979_8_, float p_76979_9_);
	public Object superGetFontRendererFromRenderManager();
	public Object superGetRenderManager();
	public void superRenderEquippedItems(Object entityliving, float f);
	public int superShouldRenderPass(Object entityliving, int i, float f);
	public int superInheritRenderPass(Object entity, int par2, float par3);
	public void superRenderModel(Object entity, float par2, float par3, float par4, float par5, float par6, float par7);
	public int superGetColorMultiplier(Object entity, float par2, float par3);
	public void superRenderLivingLabel(Object entityplayer, String par2Str, double d, double d1, double d2, int i);
	public Object superGetMainModel();
	public boolean superAddLayer(Object layerRenderer);
	public boolean superRemoveLayer(Object layerRenderer);
	public float superInterpolateRotation(float p_77034_1_, float p_77034_2_, float p_77034_3_);
	public boolean superSetScoreTeamColor(Object entityLivingBase);
	public void superUnsetScoreTeamColor();
	public boolean superSetDoRenderBrightness(Object entityLivingBase, float p_177090_2_);
	public boolean superSetBrightness(Object entityLivingBase, float p_177092_2_, boolean p_177092_3_);
	public void superUnsetBrightness();
	public float superGetSwingProgress(Object entityLivingBase, float p_77040_2_);
	//public float superRenderSwingProgress(Object entityLivingBase, float par2);
	public float superHandleRotationFloat(Object entityLivingBase, float p_77044_2_);
	public void superRenderLayers(Object entityLivingBase, float p_177093_2_, float p_177093_3_, float p_177093_4_, float p_177093_5_, float p_177093_6_, float p_177093_7_, float p_177093_8_);
	public float superGetDeathMaxRotation(Object entityLivingBase);
	public boolean superCanRenderName(Object entityLivingBase);
	public void superSetRenderOutlines(boolean p_177086_1_);
	public void superRenderName(Object entity, double x, double y, double z);
	public boolean superShouldRender(Object entity, Object iCamera, double camX, double camY, double camZ);
	public void superTransformHeldFull3DItemLayer();
	public void superRenderLivingAt(Object entityLivingBase, double p_77039_2_, double p_77039_4_, double p_77039_6_);
	public void superApplyRotations(Object entityLivingBase, float p_77043_2_, float p_77043_3_, float p_77043_4_);
	public void superRenderOffsetLivingLabel(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, float p_177069_9_, double p_177069_10_);
	public void superSetRenderPassModel(Object modelBase);
	public void superRenderArrowsStuckInEntity(Object entityLivingBase, float par2);
	public void superFunc_82408_c(Object entityLivingBase, int par2, float par3);
	public float superPrepareScale(Object entityLivingBase, float partialTicks);

}
