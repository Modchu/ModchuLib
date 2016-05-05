package modchu.lib;

public interface Modchu_IRenderLiving extends Modchu_IRenderLivingBase {
	public void renderLeashedToEntityRope(Object entityLiving, double d, double d1, double d2, float d3, float d4);
	public void superRenderLeashedToEntityRope(Object entityliving, double d, double d1, double d2, float d3, float d4);
	public void superSetLightmap(Object entityLiving, float p_177105_2_);
	public boolean superFunc_130007_b(Object entityLiving);
	// 190~
	public void superRenderEntityName(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, double p_177069_10_);

}
