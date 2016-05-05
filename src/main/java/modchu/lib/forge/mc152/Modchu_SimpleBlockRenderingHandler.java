package modchu.lib.forge.mc152;

import java.util.HashMap;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_ISimpleBlockRenderingHandler;
import modchu.lib.Modchu_ISimpleBlockRenderingHandlerMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

public class Modchu_SimpleBlockRenderingHandler implements ISimpleBlockRenderingHandler, Modchu_ISimpleBlockRenderingHandler {
	public Modchu_ISimpleBlockRenderingHandlerMaster master;

	public Modchu_SimpleBlockRenderingHandler(HashMap<String, Object> map) {
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		master = instance instanceof Modchu_ISimpleBlockRenderingHandlerMaster ? (Modchu_ISimpleBlockRenderingHandlerMaster) instance : null;
		Modchu_Debug.mDebug("Modchu_SimpleBlockRenderingHandler init master="+master);
	}

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderBlocks) {
		if (master != null) master.renderInventoryBlock(block, metadata, modelID, renderBlocks);
	}

	public void superRenderInventoryBlock(Object block, int metadata, int modelID, Object renderBlocks) {
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess iBlockAccess, int x, int y, int z, Block block, int modelId, RenderBlocks renderBlocks) {
		return master != null ? master.renderWorldBlock(iBlockAccess, x, y, z, block, modelId, renderBlocks) : false;
	}

	public boolean superRenderWorldBlock(Object iBlockAccess, int x, int y, int z, Object block, int modelId, Object renderBlocks) {
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return master != null ? master.shouldRender3DInInventory() : false;
	}

	public boolean superShouldRender3DInInventory() {
		return false;
	}

	@Override
	public int getRenderId() {
		return master != null ? master.getRenderId() : -1;
	}

	public int superGetRenderId() {
		return -1;
	}

}