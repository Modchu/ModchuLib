package modchu.lib.forge.mc220;

import java.util.HashMap;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Modchu_TileEntitySpecialRenderer extends modchu.lib.forge.mc180_220.Modchu_TileEntitySpecialRenderer {

	public Modchu_TileEntitySpecialRenderer(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void render(TileEntity tileEntity, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		if (master != null) master.render(tileEntity, x, y, z, partialTicks, destroyStage, alpha);
		else super.render(tileEntity, x, y, z, partialTicks, destroyStage, alpha);
	}

	@Override
	public void superRender(Object tileEntity, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		super.render((TileEntity) tileEntity, x, y, z, partialTicks, destroyStage, alpha);
	}

	public void setLightmapDisabled(boolean disabled) {
		if (master != null) master.setLightmapDisabled(disabled);
		else super.setLightmapDisabled(disabled);
	}

	@Override
	public void superSetLightmapDisabled(boolean disabled) {
		super.setLightmapDisabled(disabled);
	}

	public World getWorld() {
		return (World) (master != null ? master.getWorld() : super.getWorld());
	}

	@Override
	public World superGetWorld() {
		return super.getWorld();
	}

	public boolean isGlobalRenderer(TileEntity tileEntity) {
		return master != null ? master.isGlobalRenderer(tileEntity) : super.isGlobalRenderer(tileEntity);
	}

	@Override
	public boolean superIsGlobalRenderer(Object tileEntity) {
		return super.isGlobalRenderer((TileEntity) tileEntity);
	}

	public void renderTileEntityFast(TileEntity tileEntity, double x, double y, double z, float partialTicks, int destroyStage, float partial, BufferBuilder bufferBuilder) {
		if (master != null) master.renderTileEntityFast(tileEntity, x, y, z, partialTicks, destroyStage, partial, bufferBuilder);
		else super.renderTileEntityFast(tileEntity, x, y, z, partialTicks, destroyStage, partial, bufferBuilder);
	}

	@Override
	public void superRenderTileEntityFast(Object tileEntity, double x, double y, double z, float partialTicks, int destroyStage, float partial, Object bufferBuilder) {
		super.renderTileEntityFast((TileEntity) tileEntity, x, y, z, partialTicks, destroyStage, partial, (BufferBuilder) bufferBuilder);
	}

	public void drawNameplate(TileEntity tileEntity, String str, double x, double y, double z, int maxDistance) {
		if (master != null) master.drawNameplate(tileEntity, str, x, y, z, maxDistance);
		else super.drawNameplate(tileEntity, str, x, y, z, maxDistance);
	}

	@Override
	public void superDrawNameplate(Object tileEntity, String str, double x, double y, double z, int maxDistance) {
		super.drawNameplate((TileEntity) tileEntity, str, x, y, z, maxDistance);
	}

}
