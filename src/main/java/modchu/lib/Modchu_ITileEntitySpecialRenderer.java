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

}
