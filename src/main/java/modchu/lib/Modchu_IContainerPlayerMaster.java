package modchu.lib;

import java.util.List;

public interface Modchu_IContainerPlayerMaster {
	public void onCraftMatrixChanged(Object iInventory);
	public void onContainerClosed(Object entityPlayer);
	public boolean canInteractWith(Object entityPlayer);
	public Object transferStackInSlot(Object entityPlayer, int par2);
	public boolean func_94530_a(Object itemStack, Object slot);
	public Object addSlotToContainer(Object slot);
	public void addCraftingToCrafters(Object iCrafting);
	public List getInventory();
	public void removeCraftingFromCrafters(Object iCrafting);
	public void detectAndSendChanges();
	public boolean enchantItem(Object entityPlayer, int par2);
	public Object getSlotFromInventory(Object iInventory, int par2);
	public Object getSlot(int par1);
	public Object slotClick(int par1, int par2, int par3, Object entityPlayer);
	public void retrySlotClick(int par1, int par2, boolean par3, Object entityPlayer);
	public void putStackInSlot(int par1, Object itemStack);
	public void putStacksInSlots(Object[] itemStack);
	public void updateProgressBar(int par1, int par2);
	public short getNextTransactionID(Object inventoryPlayer);
	public boolean isPlayerNotUsingContainer(Object entityPlayer);
	public void setPlayerIsPresent(Object entityPlayer, boolean par2);
	public boolean mergeItemStack(Object itemStack, int par2, int par3, boolean par4);
	public void func_94533_d();
	public boolean canDragIntoSlot(Object slot);

}
