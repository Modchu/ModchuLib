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
	public int clearInventory(int par1, int par2) {
		return base.superClearInventory(par1, par2);
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
	public Object getStackInSlotOnClosing(int par1) {
		return base.superGetStackInSlotOnClosing(par1);
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
	public boolean isUseableByPlayer(Object entityPlayer) {
		return base.superIsUseableByPlayer(entityPlayer);
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

}
