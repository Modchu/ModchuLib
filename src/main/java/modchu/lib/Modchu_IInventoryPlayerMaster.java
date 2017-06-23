package modchu.lib;

public interface Modchu_IInventoryPlayerMaster {
	public Object getCurrentItem();
	public int getFirstEmptyStack();
	public void setCurrentItem(int par1, int par2, boolean par3, boolean par4);
	public void changeCurrentItem(int par1);
	public int clearInventory(Object itemORInt, int par2);
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
	public boolean isUsableByPlayer(Object entityPlayer);
	public boolean hasItemStack(Object itemStack);
	public void openChest();
	public void closeChest();
	public boolean isItemValidForSlot(int par1, Object itemStack);
	public void copyInventory(Object inventoryPlayer);
	public void setCurrentItem(Object item, int p_146030_2_, boolean p_146030_3_, boolean p_146030_4_);
	public int clearMatchingItems(Object item, int metadataIn, int removeCount, Object nBTTagCompound);
	public boolean consumeInventoryItem(Object item);
	public boolean hasItem(Object item);
	public String getName();
	public boolean hasCustomName();
	public Object getDisplayName();
	public void markDirty();
	public void openInventory(Object entityPlayer);
	public void closeInventory(Object entityPlayer);
	public int getField(int id);
	public void setField(int id, int value);
	public int getFieldCount();
	public void clear();
	public void func_146030_a(Object item, int p_146030_2_, boolean p_146030_3_, boolean p_146030_4_);
	public float func_146023_a(Object block);
	public String getInventoryName();
	public boolean hasCustomInventoryName();
	public boolean func_146025_b(Object block);
	public void setPickedItemStack(Object itemStack);
	public void pickItem(int index);
	public int getSlotFor(Object itemStack);
	public int getBestHotbarSlot();
	public void deleteStack(Object itemStack);
	public boolean isUseableByPlayer(Object entityPlayer);

}
