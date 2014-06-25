package modchu.lib;

public interface Modchu_IRenderLiving {

	public void preRenderCallback(Object entityLiving, float f);
	public void renderEquippedItems(Object entityLiving, float f);
	public void doRender(Object entity, double d, double d1, double d2, float d3, float d4);
	public Object getEntityTexture(Object entity);
	public void renderLeashedToEntityRope(Object entityLiving, double d, double d1, double d2, float d3, float d4);
	public boolean usePassSpecialRender(Object entityLivingBase);

}
