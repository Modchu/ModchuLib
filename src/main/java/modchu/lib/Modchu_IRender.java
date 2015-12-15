package modchu.lib;

public interface Modchu_IRender {
	public void superDoRender(Object entity, double d0, double d1, double d2, float f, float f1);
	public Object superGetEntityTexture(Object entity);
	public Object superGetEntityTexture(Object entity, int i);
	public boolean superBindEntityTexture(Object entity);
	public void superBindTexture(Object resourceLocation);
	public void superSetRenderManager(Object renderManager);
	public void superDoRenderShadowAndFire(Object entity, double par2, double par4, double par6, float par8, float par9);
	public Object superGetFontRendererFromRenderManager();
	public void superUpdateIcons(Object iconRegister);
	// ~152
	public void superLoadTexture(String par1Str);
	public boolean superLoadDownloadableImageTexture(String par1Str, String par2Str);
	// 172~179
	public boolean superIsStaticEntity();
	public void superFunc_147906_a(Object entity, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_);
	// 180~
	public boolean superShouldRender(Object entity, Object iCamera, double camX, double camY, double camZ);
	public void superRenderName(Object entity, double x, double y, double z);
	public boolean superCanRenderName(Object entity);
	public void superRenderOffsetLivingLabel(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, float p_177069_9_, double p_177069_10_);
	public void superRenderLivingLabel(Object entity, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_);
	public Object superGetRenderManager();
}
