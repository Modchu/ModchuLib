package modchu.lib;

public interface Modchu_ISimpleBlockRenderingHandler {
	public void superRenderInventoryBlock(Object block, int metadata, int modelID, Object renderBlocks);
	public boolean superRenderWorldBlock(Object iBlockAccess, int x, int y, int z, Object block, int modelId, Object renderBlocks);
	public boolean superShouldRender3DInInventory();
	public int superGetRenderId();

}
