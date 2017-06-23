package modchu.lib;

public interface Modchu_ITileEntitySpecialRendererMaster {
	public void renderTileEntityAt(Object tileEntity, double d0, double d1, double d2, float f);
	public void setRendererDispatcher(Object tileEntityRenderer);
	public void onWorldChange(Object world);
	public Object getFontRenderer();
	// ~152
	public void bindTextureByName(String par1Str);
	public void bindTextureByURL(String par1Str, String par2Str);
	// 162~
	public void bindTexture(Object resourceLocation);
	// 180~
	public void renderTileEntityAt(Object tileEntity, double d0, double d1, double d2, float f, int p_180535_9_);
	// 220~
	public void render(Object tileEntity, double x, double y, double z, float partialTicks, int destroyStage, float alpha);
	public void setLightmapDisabled(boolean disabled);
	public Object getWorld();
	public boolean isGlobalRenderer(Object tileEntity);
	public void renderTileEntityFast(Object tileEntity, double x, double y, double z, float partialTicks, int destroyStage, float partial, Object bufferBuilder);
	public void drawNameplate(Object tileEntity, String str, double x, double y, double z, int maxDistance);

}
