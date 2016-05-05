package modchu.lib;

import java.util.HashMap;

public class Modchu_SimpleBlockRenderingHandlerMasterBasis implements Modchu_ISimpleBlockRenderingHandlerMaster {
	public Modchu_ISimpleBlockRenderingHandler base;

	public Modchu_SimpleBlockRenderingHandlerMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_ISimpleBlockRenderingHandler) map.get("base");
	}

	@Override
	public void renderInventoryBlock(Object block, int metadata, int modelID, Object renderBlocks) {
		base.superRenderInventoryBlock(block, metadata, modelID, renderBlocks);
	}

	@Override
	public boolean renderWorldBlock(Object iBlockAccess, int x, int y, int z, Object block, int modelId, Object renderBlocks) {
		return base.superRenderWorldBlock(iBlockAccess, x, y, z, block, modelId, renderBlocks);
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return base.superShouldRender3DInInventory();
	}

	@Override
	public int getRenderId() {
		return base.superGetRenderId();
	}

}