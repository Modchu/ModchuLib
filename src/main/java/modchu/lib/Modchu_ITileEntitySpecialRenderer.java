package modchu.lib;

public interface Modchu_ITileEntitySpecialRenderer {
	public void superRenderTileEntityAt(Object tileEntity, double d0, double d1, double d2, float f);
	public void superBindTextureByName(String par1Str);
	public void superOnWorldChange(Object world);
	public Object superGetFontRenderer();
	// ~152
	public void superBindTextureByURL(String par1Str, String par2Str);
	public void superSetRendererDispatcher(Object tileEntityRenderer);
	// 162~
	public void superBindTexture(Object resourceLocation);
	// 180~
	void superRenderTileEntityAt(Object tileEntity, double d0, double d1, double d2, float f, int p_180535_9_);
	// 220~
	public void superRender(Object tileEntity, double x, double y, double z, float partialTicks, int destroyStage, float alpha);
	public void superSetLightmapDisabled(boolean disabled);
	public Object superGetWorld();
	public boolean superIsGlobalRenderer(Object tileEntity);
	public void superRenderTileEntityFast(Object tileEntity, double x, double y, double z, float partialTicks, int destroyStage, float partial, Object bufferBuilder);
	public void superDrawNameplate(Object tileEntity, String str, double x, double y, double z, int maxDistance);

}
