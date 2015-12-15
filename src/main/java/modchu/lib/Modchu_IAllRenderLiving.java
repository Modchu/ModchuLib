package modchu.lib;

public interface Modchu_IAllRenderLiving {
	public void superRenderLeashedToEntityRope(Object entityLiving, double par2, double par4, double par6, float par8, float par9);
	public void superDoRenderLiving(Object entityLiving, double d, double d1, double d2, float d3, float d4);
	public void superDoRender(Object entity, double par2, double par4, double par6, float par8, float par9);
	public void superRenderModel(Object entityLivingBase, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float p_77036_7_);
	public void superRenderLivingAt(Object entityLivingBase, double p_77039_2_, double p_77039_4_, double p_77039_6_);
	public void superRotateCorpse(Object entityLivingBase, float p_77043_2_, float p_77043_3_, float p_77043_4_);
	public float superHandleRotationFloat(Object entityLivingBase, float p_77044_2_);
	public float superGetDeathMaxRotation(Object entityLivingBase);
	public int superGetColorMultiplier(Object entityLivingBase, float p_77030_2_, float p_77030_3_);
	public void superPassSpecialRender(Object entityLivingBase, double p_77033_2_, double p_77033_4_, double p_77033_6_);
	public boolean superCanRenderName(Object entityLiving);
	public boolean superAddLayer(Object layerRenderer);
	public boolean superRemoveLayer(Object layerRenderer);
	public float superInterpolateRotation(float p_77034_1_, float p_77034_2_, float p_77034_3_);
	public void superTransformHeldFull3DItemLayer();
	public boolean superSetScoreTeamColor(Object entityLivingBase);
	public void superUnsetScoreTeamColor();
	public boolean superSetDoRenderBrightness(Object entityLivingBase, float p_177090_2_);
	public boolean superSetBrightness(Object entityLivingBase, float p_177092_2_, boolean p_177092_3_);
	public void superUnsetBrightness();
	public float superGetSwingProgress(Object entityLivingBase, float p_77040_2_);
	public void superRenderLayers(Object entityLivingBase, float p_177093_2_, float p_177093_3_, float p_177093_4_, float p_177093_5_, float p_177093_6_, float p_177093_7_, float p_177093_8_);
	public void superSetRenderOutlines(boolean p_177086_1_);
	public void superRenderName(Object entity, double x, double y, double z);

}
