package modchu.lib;

public interface Modchu_IInventoryPlayerMaster {
	public Object getCurrentItem();
	public int getFirstEmptyStack();
	public void setCurrentItem(int par1, int par2, boolean par3, boolean par4);
	public void changeCurrentItem(int par1);
	public int clearInventory(int par1, int par2);
	public void func_70439_a(Object item, int par2);
	public void decrementAnimations();
	public boolean consumeInventoryItem(int par1);
	public boolean hasItem(int par1);
	public boolean addItemStackToInventory(Object itemStack);
	public Object decrStackSize(int par1, int par2);
	public Object removeStackFromSlot(int par1);
	public void setInventorySlotContents(int par1, Object itemStack);
	public float getStrVsBlock(Object block);
	public Object writeToNBT(Object nBTTagList);
	public void readFromNBT(Object nBTTagList);
	public int getSizeInventory();
	public Object getStackInSlot(int par1);
	public String getInvName();
	public boolean isInvNameLocalized();
	public int getInventoryStackLimit();
	public boolean canHarvestBlock(Object block);
	public Object armorItemInSlot(int par1);
	public int getTotalArmorValue();
	public void damageArmor(float par1);
	public void dropAllItems();
	public void onInventoryChanged();
	public void setItemStack(Object itemStack);
	public Object getItemStack();
	public boolean isUseableByPlayer(Object entityPlayer);
	public boolean hasItemStack(Object itemStack);
	public void openChest();
	public void closeChest();
	public boolean isItemValidForSlot(int par1, Object itemStack);
	public void copyInventory(Object inventoryPlayer);

}
