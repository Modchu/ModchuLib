package modchu.lib.forge.mc180_202;

import java.util.HashMap;

import modchu.lib.Modchu_ITileEntitySpecialRenderer;
import modchu.lib.Modchu_ITileEntitySpecialRendererMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class Modchu_TileEntitySpecialRenderer extends TileEntitySpecialRenderer implements Modchu_ITileEntitySpecialRenderer {
	public Modchu_ITileEntitySpecialRendererMaster master;

	public Modchu_TileEntitySpecialRenderer(HashMap<String, Object> map) {
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		master = instance instanceof Modchu_ITileEntitySpecialRendererMaster ? (Modchu_ITileEntitySpecialRendererMaster) instance : null;
		//Modchu_Debug.mDebug("Modchu_ITileEntitySpecialRendererMaster init master="+master);
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double d0, double d1, double d2, float f, int p_180535_9_) {
		if (master != null) master.renderTileEntityAt(tileEntity, d0, d1, d2, f, p_180535_9_);
	}

	@Override
	public void superRenderTileEntityAt(Object tileEntity, double d0, double d1, double d2, float f, int p_180535_9_) {
	}

	@Override
	public void setRendererDispatcher(TileEntityRendererDispatcher tileEntityRendererDispatcher) {
		if (master != null) master.setRendererDispatcher(tileEntityRendererDispatcher);
		else super.setRendererDispatcher(tileEntityRendererDispatcher);
	}

	@Override
	public void superSetRendererDispatcher(Object tileEntityRendererDispatcher) {
		super.setRendererDispatcher((TileEntityRendererDispatcher) tileEntityRendererDispatcher);
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
	protected void bindTexture(ResourceLocation resourceLocation) {
		if (master != null) master.bindTexture(resourceLocation);
		else super.bindTexture(resourceLocation);
	}

	@Override
	public void superBindTexture(Object resourceLocation) {
		super.bindTexture((ResourceLocation) resourceLocation);
	}

	protected void bindTextureByName(String par1Str) {
	}

	@Override
	public void superBindTextureByName(String par1Str) {
	}

	protected void bindTextureByURL(String par1Str, String par2Str) {
	}

	@Override
	public void superBindTextureByURL(String par1Str, String par2Str) {
	}
	// ~179
	public void renderTileEntityAt(TileEntity tileEntity, double d0, double d1, double d2, float f) {
		if (master != null) master.renderTileEntityAt(tileEntity, d0, d1, d2, f);
	}

	@Override
	public void superRenderTileEntityAt(Object tileEntity, double d0, double d1, double d2, float f) {
	}

	public void func_147496_a(World world) {
	}

	@Override
	public void superOnWorldChange(Object world) {
	}

}
