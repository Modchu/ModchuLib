package modchu.lib.modloader.mc152;

import java.util.HashMap;

import modchu.lib.Modchu_ITileEntitySpecialRenderer;
import modchu.lib.Modchu_ITileEntitySpecialRendererMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityRenderer;
import net.minecraft.src.TileEntitySpecialRenderer;
import net.minecraft.src.World;

public class Modchu_TileEntitySpecialRenderer extends TileEntitySpecialRenderer implements Modchu_ITileEntitySpecialRenderer {
	public Modchu_ITileEntitySpecialRendererMaster master;

	public Modchu_TileEntitySpecialRenderer(HashMap<String, Object> map) {
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		master = instance instanceof Modchu_ITileEntitySpecialRendererMaster ? (Modchu_ITileEntitySpecialRendererMaster) instance : null;
		//Modchu_Debug.mDebug("Modchu_ITileEntitySpecialRendererMaster init master="+master);
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double d0, double d1, double d2, float f) {
		if (master != null) master.renderTileEntityAt(tileEntity, d0, d1, d2, f);
	}

	@Override
	public void superRenderTileEntityAt(Object tileEntity, double d0, double d1, double d2, float f) {
	}

	@Override
	protected void bindTextureByName(String par1Str) {
		if (master != null) master.bindTextureByName(par1Str);
		else super.bindTextureByName(par1Str);
	}

	@Override
	public void superBindTextureByName(String par1Str) {
		super.bindTextureByName(par1Str);
	}

	@Override
	protected void bindTextureByURL(String par1Str, String par2Str) {
		if (master != null) master.bindTextureByURL(par1Str, par2Str);
		else super.bindTextureByURL(par1Str, par2Str);
	}

	@Override
	public void superBindTextureByURL(String par1Str, String par2Str) {
		super.bindTextureByURL(par1Str, par2Str);
	}

	@Override
	public void setTileEntityRenderer(TileEntityRenderer tileEntityRenderer) {
		if (master != null) master.setRendererDispatcher(tileEntityRenderer);
		else super.setTileEntityRenderer(tileEntityRenderer);
	}

	@Override
	public void superSetRendererDispatcher(Object tileEntityRenderer) {
		super.setTileEntityRenderer((TileEntityRenderer) tileEntityRenderer);
	}

	@Override
	public void onWorldChange(World world) {
		if (master != null) master.onWorldChange(world);
		else super.onWorldChange(world);
	}

	@Override
	public void superOnWorldChange(Object world) {
		super.onWorldChange((World) world);
	}

	@Override
	public FontRenderer getFontRenderer() {
		return (FontRenderer) (master != null ? master.getFontRenderer() : super.getFontRenderer());
	}

	@Override
	public FontRenderer superGetFontRenderer() {
		return super.getFontRenderer();
	}

	@Override
	public void superBindTexture(Object resourceLocation) {
	}

	@Override
	public void superRenderTileEntityAt(Object tileEntity, double d0, double d1, double d2, float f, int p_180535_9_) {
	}

	@Override
	public void superRender(Object tileEntity, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
	}

	@Override
	public void superSetLightmapDisabled(boolean disabled) {
	}

	@Override
	public Object superGetWorld() {
		return null;
	}

	@Override
	public boolean superIsGlobalRenderer(Object tileEntity) {
		return false;
	}

	@Override
	public void superRenderTileEntityFast(Object tileEntity, double x, double y, double z, float partialTicks, int destroyStage, float partial, Object bufferBuilder) {
	}

	@Override
	public void superDrawNameplate(Object tileEntity, String str, double x, double y, double z, int maxDistance) {
	}

}
