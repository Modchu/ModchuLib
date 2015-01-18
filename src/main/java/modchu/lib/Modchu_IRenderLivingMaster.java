package modchu.lib;

public interface Modchu_IRenderLivingMaster extends Modchu_IRendererLivingEntityMaster {
	public void renderLeashedToEntityRope(Object entityliving, double d, double d1, double d2, float d3, float d4);
	public boolean canRenderName(Object entityLiving);
	public boolean shouldRender(Object entityLiving, Object iCamera, double p_177104_3_, double p_177104_5_, double p_177104_7_);
	public void func_177105_a(Object entityLiving, float p_177105_2_);
	public boolean usePassSpecialRender(Object entityLivingBase);
	public boolean func_130007_b(Object entityLiving);

}
