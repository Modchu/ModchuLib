package modchu.lib;

public interface Modchu_IRenderMaster {
	public void doRender(Object entity, double d, double d1, double d2, float d3, float d4);
	public Object getEntityTexture(Object entity);
	public Object getEntityTexture(Object entity, int i);
	public boolean bindEntityTexture(Object entity);
	public void bindTexture(Object resourceLocation);
	public void doRenderShadowAndFire(Object entity, double p_76979_2_, double p_76979_4_, double p_76979_6_, float p_76979_8_, float p_76979_9_);
	public Object getFontRendererFromRenderManager();
	public void setRenderManager(Object renderManager);
	public void updateIcons(Object iconRegister);
	// ~152
	public void loadTexture(String par1Str);
	public boolean loadDownloadableImageTexture(String par1Str, String par2Str);
	// 172~179
	public boolean isStaticEntity();
	public void func_147906_a(Object entity, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_);
	// 180~
	public boolean shouldRender(Object entity, Object iCamera, double camX, double camY, double camZ);
	public void renderName(Object entity, double x, double y, double z);
	public boolean canRenderName(Object entity);
	public void renderOffsetLivingLabel(Object entity, double p_177069_2_, double p_177069_4_, double p_177069_6_, String p_177069_8_, float p_177069_9_, double p_177069_10_);
	public void renderLivingLabel(Object entity, String p_147906_2_, double p_147906_3_, double p_147906_5_, double p_147906_7_, int p_147906_9_);
	public Object getRenderManager();

}
