package modchu.lib.forge.mc180_212;

import java.util.HashMap;

import net.minecraft.tileentity.TileEntity;

public class Modchu_TileEntitySpecialRenderer extends modchu.lib.forge.mc180_220.Modchu_TileEntitySpecialRenderer {

	public Modchu_TileEntitySpecialRenderer(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double d0, double d1, double d2, float f, int p_180535_9_) {
		if (master != null) master.renderTileEntityAt(tileEntity, d0, d1, d2, f, p_180535_9_);
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
