package modchu.lib.forge.mc172_179;

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
	public void renderTileEntityAt(TileEntity tileEntity, double d0, double d1, double d2, float f) {
		if (master != null) master.renderTileEntityAt(tileEntity, d0, d1, d2, f);
	}

	@Override
	public void superRenderTileEntityAt(Object tileEntity, double d0, double d1, double d2, float f) {
	}

	@Override
	public void func_147497_a(TileEntityRendererDispatcher tileEntityRendererDispatcher) {
		if (master != null) master.setRendererDispatcher(tileEntityRendererDispatcher);
		else super.func_147497_a(tileEntityRendererDispatcher);
	}

	@Override
	public void superSetRendererDispatcher(Object tileEntityRendererDispatcher) {
		super.func_147497_a((TileEntityRendererDispatcher) tileEntityRendererDispatcher);
	}

	@Override
	public void func_147496_a(World world) {
		if (master != null) master.onWorldChange(world);
		else super.func_147496_a(world);
	}

	@Override
	public void superOnWorldChange(Object world) {
		super.func_147496_a((World) world);
	}

	@Override
	public FontRenderer func_147498_b() {
		return (FontRenderer) (master != null ? master.getFontRenderer() : super.func_147498_b());
	}

	@Override
	public FontRenderer superGetFontRenderer() {
		return super.func_147498_b();
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
