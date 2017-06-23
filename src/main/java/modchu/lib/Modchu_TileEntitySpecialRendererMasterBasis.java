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

	@Override
	public void render(Object tileEntity, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		base.superRender(tileEntity, x, y, z, partialTicks, destroyStage, alpha);
	}

	@Override
	public void setLightmapDisabled(boolean disabled) {
		base.superSetLightmapDisabled(disabled);
	}

	@Override
	public Object getWorld() {
		return base.superGetWorld();
	}

	@Override
	public boolean isGlobalRenderer(Object tileEntity) {
		return base.superIsGlobalRenderer(tileEntity);
	}

	@Override
	public void renderTileEntityFast(Object tileEntity, double x, double y, double z, float partialTicks, int destroyStage, float partial, Object bufferBuilder) {
		base.superRenderTileEntityFast(tileEntity, x, y, z, partialTicks, destroyStage, partial, bufferBuilder);
	}

	@Override
	public void drawNameplate(Object tileEntity, String str, double x, double y, double z, int maxDistance) {
		base.superDrawNameplate(tileEntity, str, x, y, z, maxDistance);
	}

}
