package modchu.lib.forge.mc189;

import java.util.HashMap;

import modchu.lib.Modchu_IInventoryPlayer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class Modchu_InventoryPlayer extends modchu.lib.forge.mc180_189.Modchu_InventoryPlayer implements Modchu_IInventoryPlayer {

	public Modchu_InventoryPlayer(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public ItemStack removeStackFromSlot(int par1) {
		return (ItemStack) (master != null ? master.removeStackFromSlot(par1) : super.removeStackFromSlot(par1));
	}

	@Override
	public ItemStack superRemoveStackFromSlot(int par1) {
		return super.removeStackFromSlot(par1);
	}

	@Override
	public boolean canHeldItemHarvest(Block block) {
		return master != null ? master.canHarvestBlock(block) : super.canHeldItemHarvest(block);
	}

	public boolean superCanHarvestBlock(Object block) {
		return super.canHeldItemHarvest((Block) block);
	}
	// 190~
	@Override
	public int clearMatchingItems(Item item, int metadataIn, int removeCount, NBTTagCompound nBTTagCompound) {
		return master != null ? master.clearMatchingItems(item, metadataIn, removeCount, nBTTagCompound) : super.clearMatchingItems(item, metadataIn, removeCount, nBTTagCompound);
	}

	public int superClearMatchingItems(Object item, int metadataIn, int removeCount, Object nBTTagCompound) {
		return super.clearMatchingItems((Item) item, metadataIn, removeCount, (NBTTagCompound) nBTTagCompound);
	}

}
