package modchu.lib;

public interface Modchu_IRenderLivingMaster extends Modchu_IRenderLivingBaseMaster {
	public void renderLeashedToEntityRope(Object entityliving, double d, double d1, double d2, float d3, float d4);
	public boolean canRenderName(Object entityLiving);
	public boolean shouldRender(Object entityLiving, Object iCamera, double p_177104_3_, double p_177104_5_, double p_177104_7_);
	public void setLightmap(Object entityLiving, float p_177105_2_);
	public boolean func_130007_b(Object entityLiving);
	// 190~
	public void renderEntityName(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, double p_177069_10_);

}
