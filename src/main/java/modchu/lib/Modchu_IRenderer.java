package modchu.lib;

public interface Modchu_IRenderer {
	public void superDoRender(Object entity, double d0, double d1, double d2, float f, float f1);
	public Object superGetEntityTexture(Object entity);
	public void superBindEntityTexture(Object entity);
	public void superBindTexture(Object resourceLocation);
	public void superSetRenderManager(Object renderManager);
	public void superDoRenderShadowAndFire(Object entity, double par2, double par4, double par6, float par8, float par9);
	public Object superGetFontRendererFromRenderManager();
	public void superUpdateIcons(Object iconRegister);

}
