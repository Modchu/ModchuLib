package modchu.lib;

import java.util.List;

public interface Modchu_IContainerPlayer {
	public void superOnCraftMatrixChanged(Object iInventory);
	public void superOnContainerClosed(Object entityPlayer);
	public boolean superCanInteractWith(Object entityPlayer);
	public Object superTransferStackInSlot(Object entityPlayer, int par2);
	public boolean superFunc_94530_a(Object itemStack, Object slot);
	public Object superAddSlotToContainer(Object slot);
	public void superAddCraftingToCrafters(Object iCrafting);
	public List superGetInventory();
	public void superRemoveCraftingFromCrafters(Object iCrafting);
	public void superDetectAndSendChanges();
	public boolean superEnchantItem(Object entityPlayer, int par2);
	public Object superGetSlotFromInventory(Object iInventory, int par2);
	public Object superGetSlot(int par1);
	public Object superSlotClick(int par1, int par2, int par3, Object entityPlayer);
	public void superRetrySlotClick(int par1, int par2, boolean par3, Object entityPlayer);
	public void superPutStackInSlot(int par1, Object itemStack);
	public void superPutStacksInSlots(Object[] itemStack);
	public void superUpdateProgressBar(int par1, int par2);
	public short superGetNextTransactionID(Object inventoryPlayer);
	public boolean superIsPlayerNotUsingContainer(Object entityPlayer);
	public void superSetPlayerIsPresent(Object entityPlayer, boolean par2);
	public boolean superMergeItemStack(Object itemStack, int par2, int par3, boolean par4);
	public void superFunc_94533_d();
	public boolean superCanDragIntoSlot(Object slot);

}
