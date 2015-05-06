package modchu.lib;

import java.util.HashMap;
import java.util.List;

public class Modchu_ContainerPlayerMasterBasis implements Modchu_IContainerPlayerMaster {
	public Modchu_IContainerPlayer base;

	public Modchu_ContainerPlayerMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IContainerPlayer) map.get("base");
	}

	@Override
	public void onCraftMatrixChanged(Object iInventory) {
		base.superOnCraftMatrixChanged(iInventory);
	}

	@Override
	public void onContainerClosed(Object entityPlayer) {
		base.superOnContainerClosed(entityPlayer);
	}

	@Override
	public boolean canInteractWith(Object entityPlayer) {
		return base.superCanInteractWith(entityPlayer);
	}

	@Override
	public Object transferStackInSlot(Object entityPlayer, int par2) {
		return base.superTransferStackInSlot(entityPlayer, par2);
	}

	@Override
	public boolean func_94530_a(Object itemStack, Object slot) {
		return base.superFunc_94530_a(itemStack, slot);
	}

	@Override
	public Object addSlotToContainer(Object slot) {
		return base.superAddSlotToContainer(slot);
	}

	@Override
	public void addCraftingToCrafters(Object iCrafting) {
		base.superAddCraftingToCrafters(iCrafting);
	}

	@Override
	public List getInventory() {
		return base.superGetInventory();
	}

	@Override
	public void removeCraftingFromCrafters(Object iCrafting) {
		base.superRemoveCraftingFromCrafters(iCrafting);
	}

	@Override
	public void detectAndSendChanges() {
		base.superDetectAndSendChanges();
	}

	@Override
	public boolean enchantItem(Object entityPlayer, int par2) {
		return base.superEnchantItem(entityPlayer, par2);
	}

	@Override
	public Object getSlotFromInventory(Object iInventory, int par2) {
		return base.superGetSlotFromInventory(iInventory, par2);
	}

	@Override
	public Object getSlot(int par1) {
		return base.superGetSlot(par1);
	}

	@Override
	public Object slotClick(int par1, int par2, int par3, Object entityPlayer) {
		return base.superSlotClick(par1, par2, par3, entityPlayer);
	}

	@Override
	public void retrySlotClick(int par1, int par2, boolean par3, Object entityPlayer) {
		base.superRetrySlotClick(par1, par2, par3, entityPlayer);
	}

	@Override
	public void putStackInSlot(int par1, Object itemStack) {
		base.superPutStackInSlot(par1, itemStack);
	}

	@Override
	public void putStacksInSlots(Object[] itemStack) {
		base.superPutStacksInSlots(itemStack);
	}

	@Override
	public void updateProgressBar(int par1, int par2) {
		base.superUpdateProgressBar(par1, par2);
	}

	@Override
	public short getNextTransactionID(Object inventoryPlayer) {
		return base.superGetNextTransactionID(inventoryPlayer);
	}

	@Override
	public boolean isPlayerNotUsingContainer(Object entityPlayer) {
		return base.superIsPlayerNotUsingContainer(entityPlayer);
	}

	@Override
	public void setPlayerIsPresent(Object entityPlayer, boolean par2) {
		base.superSetPlayerIsPresent(entityPlayer, par2);
	}

	@Override
	public boolean mergeItemStack(Object itemStack, int par2, int par3, boolean par4) {
		return base.superMergeItemStack(itemStack, par2, par3, par4);
	}

	@Override
	public void func_94533_d() {
		base.superFunc_94533_d();
	}

	@Override
	public boolean canDragIntoSlot(Object slot) {
		return base.superCanDragIntoSlot(slot);
	}

}
