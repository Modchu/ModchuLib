package modchu.lib;

public interface Modchu_IRendererMaster {
	public void doRender(Object entity, double d0, double d1, double d2, float f, float f1);
	public Object getEntityTexture(Object entity);
	public void bindEntityTexture(Object entity);
	public void bindTexture(Object resourceLocation);
	public void setRenderManager(Object renderManager);
	public void doRenderShadowAndFire(Object entity, double par2, double par4, double par6, float par8, float par9);
	public Object getFontRendererFromRenderManager();
	public void updateIcons(Object iconRegister);

}
