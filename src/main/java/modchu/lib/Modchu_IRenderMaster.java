package modchu.lib;

public interface Modchu_IRenderMaster {
	public void doRender(Object entity, double d, double d1, double d2, float d3, float d4);
	public Object getEntityTexture(Object entity);
	public Object getEntityTexture(Object entity, int i);
	public boolean bindEntityTexture(Object entity);
	public void bindTexture(Object resourceLocation);
	public void doRenderShadowAndFire(Object entity, double p_76979_2_, double p_76979_4_, double p_76979_6_, float p_76979_8_, float p_76979_9_);
	public Object getFontRendererFromRenderManager();
	public Object func_177068_d();

}
