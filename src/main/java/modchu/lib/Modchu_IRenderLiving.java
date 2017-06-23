package modchu.lib;

public interface Modchu_IRenderLiving extends Modchu_IRenderLivingBase {
	//public void superRenderLeashedToEntityRope(Object entityliving, double d, double d1, double d2, float d3, float d4);
	public void superSetLightmap(Object entityLiving, float p_177105_2_);
	public boolean superFunc_130007_b(Object entityLiving);
	// ~152
	public void superFunc_98190_a(Object entityLiving);
	// 190~
	public void superRenderEntityName(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, double p_177069_10_);

	public boolean superCanRenderName(Object entityLiving);
	public boolean superShouldRender(Object entityLiving, Object iCamera, double camX, double camY, double camZ);
	public void superRenderLeash(Object entityLiving, double x, double y, double z, float entityYaw, float partialTicks);

	// 220~
	public void superSetLightmap(Object entityLiving);
	public boolean superIsVisible(Object entityLivingBase);
	public void superApplyRotations(Object entityLivingBase, float p_77043_2_, float rotationYaw, float partialTicks);

}
