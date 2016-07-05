package modchu.lib.forge.mc180;

import java.util.HashMap;

import modchu.lib.Modchu_IInventoryPlayer;
import net.minecraft.item.ItemStack;

public class Modchu_InventoryPlayer extends modchu.lib.forge.mc180_189.Modchu_InventoryPlayer implements Modchu_IInventoryPlayer {

	public Modchu_InventoryPlayer(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int par1) {
		return (ItemStack) (master != null ? master.removeStackFromSlot(par1) : super.getStackInSlotOnClosing(par1));
	}

	@Override
	public ItemStack superRemoveStackFromSlot(int par1) {
		return super.getStackInSlotOnClosing(par1);
	}

	@Override
	public boolean superCanHarvestBlock(Object block) {
		return false;
	}
	// 190~
	public int superClearMatchingItems(Object item, int metadataIn, int removeCount, Object nBTTagCompound) {
		return -1;
	}

}
