package modchu.lib.forge.mc180;

import java.util.HashMap;

import modchu.lib.Modchu_IInventoryPlayer;
import net.minecraft.entity.player.EntityPlayer;
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
	@Override
	public int superClearMatchingItems(Object item, int metadataIn, int removeCount, Object nBTTagCompound) {
		return -1;
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
