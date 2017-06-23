package modchu.lib.forge.mc189;

import java.util.HashMap;

import modchu.lib.Modchu_IInventoryPlayer;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
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

	@Override
	public boolean superCanHarvestBlock(Object block) {
		return super.canHeldItemHarvest((Block) block);
	}
	// 190~
	@Override
	public int clearMatchingItems(Item item, int metadataIn, int removeCount, NBTTagCompound nBTTagCompound) {
		return master != null ? master.clearMatchingItems(item, metadataIn, removeCount, nBTTagCompound) : super.clearMatchingItems(item, metadataIn, removeCount, nBTTagCompound);
	}

	@Override
	public int superClearMatchingItems(Object item, int metadataIn, int removeCount, Object nBTTagCompound) {
		return super.clearMatchingItems((Item) item, metadataIn, removeCount, (NBTTagCompound) nBTTagCompound);
	}

	@Override
	public void superFunc_146030_a(Object item, int p_146030_2_, boolean p_146030_3_, boolean p_146030_4_) {
	}

	@Override
	public float superFunc_146023_a(Object block) {
		return 0.0F;
	}

	@Override
	public String superGetInventoryName() {
		return superGetInvName();
	}

	@Override
	public boolean superHasCustomInventoryName() {
		return super.hasCustomName();
	}

	@Override
	public boolean superFunc_146025_b(Object block) {
		return false;
	}

	@Override
	public void superOpenInventory() {
	}

	@Override
	public void superCloseInventory() {
	}

	@Override
	public void superSetPickedItemStack(Object itemStack) {
	}

	@Override
	public void superPickItem(int index) {
	}

	@Override
	public int superGetSlotFor(Object itemStack) {
		return -1;
	}

	@Override
	public int superGetBestHotbarSlot() {
		return -1;
	}

	@Override
	public void superDeleteStack(Object itemStack) {
	}

	@Override
	public boolean superIsUseableByPlayer(Object entityPlayer) {
		return super.isUseableByPlayer((EntityPlayer) entityPlayer);
	}

}
