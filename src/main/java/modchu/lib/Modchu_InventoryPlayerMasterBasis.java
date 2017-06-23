package modchu.lib;

import java.util.HashMap;

public class Modchu_InventoryPlayerMasterBasis implements Modchu_IInventoryPlayerMaster {
	public Modchu_IInventoryPlayer base;

	public Modchu_InventoryPlayerMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IInventoryPlayer) map.get("base");
	}

	@Override
	public Object getCurrentItem() {
		return base.superGetCurrentItem();
	}

	@Override
	public int getFirstEmptyStack() {
		return base.superGetFirstEmptyStack();
	}

	@Override
	public void setCurrentItem(int par1, int par2, boolean par3, boolean par4) {
		base.superSetCurrentItem(par1, par2, par3, par4);
	}

	@Override
	public void changeCurrentItem(int par1) {
		base.superChangeCurrentItem(par1);
	}

	@Override
	public int clearInventory(Object itemOrInt, int par2) {
		return base.superClearInventory(itemOrInt, par2);
	}

	@Override
	public void func_70439_a(Object item, int par2) {
		base.superFunc_70439_a(item, par2);
	}

	@Override
	public void decrementAnimations() {
		base.superDecrementAnimations();
	}

	@Override
	public boolean consumeInventoryItem(int par1) {
		return base.superConsumeInventoryItem(par1);
	}

	@Override
	public boolean hasItem(int par1) {
		return base.superHasItem(par1);
	}

	@Override
	public boolean addItemStackToInventory(Object itemStack) {
		return base.superAddItemStackToInventory(itemStack);
	}

	@Override
	public Object decrStackSize(int par1, int par2) {
		return base.superDecrStackSize(par1, par2);
	}

	@Override
	public Object removeStackFromSlot(int par1) {
		return base.superRemoveStackFromSlot(par1);
	}

	@Override
	public void setInventorySlotContents(int par1, Object itemStack) {
		base.superSetInventorySlotContents(par1, itemStack);
	}

	@Override
	public float getStrVsBlock(Object block) {
		return base.superGetStrVsBlock(block);
	}

	@Override
	public Object writeToNBT(Object nBTTagList) {
		return base.superWriteToNBT(nBTTagList);
	}

	@Override
	public void readFromNBT(Object nBTTagList) {
		base.superReadFromNBT(nBTTagList);
	}

	@Override
	public int getSizeInventory() {
		return base.superGetSizeInventory();
	}

	@Override
	public Object getStackInSlot(int par1) {
		return base.superGetStackInSlot(par1);
	}

	@Override
	public String getInvName() {
		return base.superGetInvName();
	}

	@Override
	public boolean isInvNameLocalized() {
		return base.superIsInvNameLocalized();
	}

	@Override
	public int getInventoryStackLimit() {
		return base.superGetInventoryStackLimit();
	}

	@Override
	public boolean canHarvestBlock(Object block) {
		return base.superCanHarvestBlock(block);
	}

	@Override
	public Object armorItemInSlot(int par1) {
		return base.superArmorItemInSlot(par1);
	}

	@Override
	public int getTotalArmorValue() {
		return base.superGetTotalArmorValue();
	}

	@Override
	public void damageArmor(float par1) {
		base.superDamageArmor(par1);
	}

	@Override
	public void dropAllItems() {
		base.superDropAllItems();
	}

	@Override
	public void onInventoryChanged() {
		base.superOnInventoryChanged();
	}

	@Override
	public void setItemStack(Object itemStack) {
		base.superSetItemStack(itemStack);
	}

	@Override
	public Object getItemStack() {
		return base.superGetItemStack();
	}

	@Override
	public boolean isUsableByPlayer(Object entityPlayer) {
		return base.superIsUsableByPlayer(entityPlayer);
	}

	@Override
	public boolean hasItemStack(Object itemStack) {
		return base.superHasItemStack(itemStack);
	}

	@Override
	public void openChest() {
		base.superOpenChest();
	}

	@Override
	public void closeChest() {
		base.superCloseChest();
	}

	@Override
	public boolean isItemValidForSlot(int par1, Object itemStack) {
		return base.superIsItemValidForSlot(par1, itemStack);
	}

	@Override
	public void copyInventory(Object inventoryPlayer) {
		base.superCopyInventory(inventoryPlayer);
	}

	@Override
	public void setCurrentItem(Object item, int p_146030_2_, boolean p_146030_3_, boolean p_146030_4_) {
		base.superSetCurrentItem(item, p_146030_2_, p_146030_3_, p_146030_4_);
	}

	@Override
	public int clearMatchingItems(Object item, int metadataIn, int removeCount, Object nBTTagCompound) {
		return base.superClearMatchingItems(item, metadataIn, removeCount, nBTTagCompound);
	}

	@Override
	public boolean consumeInventoryItem(Object item) {
		return base.superConsumeInventoryItem(item);
	}

	@Override
	public boolean hasItem(Object item) {
		return base.superHasItem(item);
	}

	@Override
	public String getName() {
		return base.superGetName();
	}

	@Override
	public boolean hasCustomName() {
		return base.superHasCustomName();
	}

	@Override
	public Object getDisplayName() {
		return base.superGetDisplayName();
	}

	@Override
	public void markDirty() {
		base.superMarkDirty();
	}

	@Override
	public void openInventory(Object entityPlayer) {
		base.superOpenInventory(entityPlayer);
	}

	@Override
	public void closeInventory(Object entityPlayer) {
		base.superCloseInventory(entityPlayer);
	}

	@Override
	public int getField(int id) {
		return base.superGetField(id);
	}

	@Override
	public void setField(int id, int value) {
		base.superSetField(id, value);
	}

	@Override
	public int getFieldCount() {
		return base.superGetFieldCount();
	}

	@Override
	public void clear() {
		base.superClear();
	}

	@Override
	public void func_146030_a(Object item, int p_146030_2_, boolean p_146030_3_, boolean p_146030_4_) {
		base.superFunc_146030_a(item, p_146030_2_, p_146030_3_, p_146030_4_);
	}

	@Override
	public float func_146023_a(Object block) {
		return base.superFunc_146023_a(block);
	}

	@Override
	public String getInventoryName() {
		return base.superGetInventoryName();
	}

	@Override
	public boolean hasCustomInventoryName() {
		return base.superHasCustomInventoryName();
	}

	@Override
	public boolean func_146025_b(Object block) {
		return base.superFunc_146025_b(block);
	}

	@Override
	public void setPickedItemStack(Object itemStack) {
		base.superSetPickedItemStack(itemStack);
	}

	@Override
	public void pickItem(int index) {
		base.superPickItem(index);
	}

	@Override
	public int getSlotFor(Object itemStack) {
		return base.superGetSlotFor(itemStack);
	}

	@Override
	public int getBestHotbarSlot() {
		return base.superGetBestHotbarSlot();
	}

	@Override
	public void deleteStack(Object itemStack) {
		base.superDeleteStack(itemStack);
	}

	@Override
	public boolean isUseableByPlayer(Object entityPlayer) {
		return base.superIsUseableByPlayer(entityPlayer);
	}

}
