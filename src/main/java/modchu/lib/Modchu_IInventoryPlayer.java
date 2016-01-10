package modchu.lib;

public interface Modchu_IInventoryPlayer {
	public Object superGetCurrentItem();
	public int superGetFirstEmptyStack();
	public void superSetCurrentItem(int par1, int par2, boolean par3, boolean par4);
	public void superChangeCurrentItem(int par1);
	public int superClearInventory(int par1, int par2);
	public void superFunc_70439_a(Object item, int par2);
	public void superDecrementAnimations();
	public boolean superConsumeInventoryItem(int par1);
	public boolean superHasItem(int par1);
	public boolean superAddItemStackToInventory(Object itemStack);
	public Object superDecrStackSize(int par1, int par2);
	public Object superRemoveStackFromSlot(int par1);
	public void superSetInventorySlotContents(int par1, Object itemStack);
	public float superGetStrVsBlock(Object block);
	public Object superWriteToNBT(Object nBTTagList);
	public void superReadFromNBT(Object nBTTagList);
	public int superGetSizeInventory();
	public Object superGetStackInSlot(int par1);
	public String superGetInvName();
	public boolean superIsInvNameLocalized();
	public int superGetInventoryStackLimit();
	public boolean superCanHarvestBlock(Object block);
	public Object superArmorItemInSlot(int par1);
	public int superGetTotalArmorValue();
	public void superDamageArmor(float par1);
	public void superDropAllItems();
	public void superOnInventoryChanged();
	public void superSetItemStack(Object itemStack);
	public Object superGetItemStack();
	public boolean superIsUseableByPlayer(Object entityPlayer);
	public boolean superHasItemStack(Object itemStack);
	public void superOpenChest();
	public void superCloseChest();
	public boolean superIsItemValidForSlot(int par1, Object itemStack);
	public void superCopyInventory(Object inventoryPlayer);

}
