package modchu.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Modchu_TileEntitySpecialRendererMasterBasis implements Modchu_ITileEntitySpecialRendererMaster {
	public Modchu_ITileEntitySpecialRenderer base;

	public Modchu_TileEntitySpecialRendererMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_ITileEntitySpecialRenderer) map.get("base");
	}

	@Override
	public void renderTileEntityAt(Object tileEntity, double d0, double d1, double d2, float f) {
		base.superRenderTileEntityAt(tileEntity, d0, d1, d2, f);
	}

	@Override
	public void bindTextureByName(String par1Str) {
		base.superBindTextureByName(par1Str);
	}

	@Override
	public void bindTextureByURL(String par1Str, String par2Str) {
		base.superBindTextureByURL(par1Str, par2Str);
	}

	@Override
	public void setRendererDispatcher(Object tileEntityRenderer) {
		base.superSetRendererDispatcher(tileEntityRenderer);
	}

	@Override
	public void onWorldChange(Object world) {
		base.superOnWorldChange(world);
	}

	@Override
	public Object getFontRenderer() {
		return base.superGetFontRenderer();
	}

	@Override
	public void bindTexture(Object resourceLocation) {
		base.superBindTexture(resourceLocation);
	}

	@Override
	public void renderTileEntityAt(Object tileEntity, double d0, double d1, double d2, float f, int p_180535_9_) {
		base.superRenderTileEntityAt(tileEntity, d0, d1, d2, f, p_180535_9_);
	}

}
