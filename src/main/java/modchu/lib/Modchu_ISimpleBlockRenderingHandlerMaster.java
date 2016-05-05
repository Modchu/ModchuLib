package modchu.lib;

public interface Modchu_ISimpleBlockRenderingHandlerMaster {
	public void renderInventoryBlock(Object block, int metadata, int modelID, Object renderBlocks);
	public boolean renderWorldBlock(Object iBlockAccess, int x, int y, int z, Object block, int modelId, Object renderBlocks);
	public boolean shouldRender3DInInventory();
	public int getRenderId();

}
