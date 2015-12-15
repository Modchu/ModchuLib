package modchu.lib.forge.mc188;

import java.util.HashMap;

import modchu.lib.Modchu_IInventoryPlayer;
import modchu.lib.Modchu_IInventoryPlayerMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;

public class Modchu_InventoryPlayer extends InventoryPlayer implements Modchu_IInventoryPlayer {
	public Modchu_IInventoryPlayerMaster master;

	public Modchu_InventoryPlayer(HashMap<String, Object> map) {
		super((EntityPlayer)map.get("Object"));
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.lDebug("Modchu_InventoryPlayer init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IInventoryPlayerMaster ? (Modchu_IInventoryPlayerMaster) instance : null;
	}

	@Override
	public ItemStack getCurrentItem() {
		return (ItemStack) (master != null ? master.getCurrentItem() : super.getCurrentItem());
	}

	@Override
	public ItemStack superGetCurrentItem() {
		return super.getCurrentItem();
	}

	@Override
	public int getFirstEmptyStack() {
		return master != null ? master.getFirstEmptyStack() : super.getFirstEmptyStack();
	}

	@Override
	public int superGetFirstEmptyStack() {
		return super.getFirstEmptyStack();
	}

	@Override
	public void changeCurrentItem(int par1) {
		if (master != null) master.changeCurrentItem(par1);
		else super.changeCurrentItem(par1);
	}

	@Override
	public void superChangeCurrentItem(int par1) {
		super.changeCurrentItem(par1);
	}

	@Override
	public void decrementAnimations() {
		if (master != null) master.decrementAnimations();
		else super.decrementAnimations();
	}

	@Override
	public void superDecrementAnimations() {
		super.decrementAnimations();
	}

	@Override
	public boolean addItemStackToInventory(ItemStack itemStack) {
		return master != null ? master.addItemStackToInventory(itemStack) : super.addItemStackToInventory(itemStack);
	}

	@Override
	public boolean superAddItemStackToInventory(Object itemStack) {
		return super.addItemStackToInventory((ItemStack) itemStack);
	}

	@Override
	public ItemStack decrStackSize(int par1, int par2) {
		return (ItemStack) (master != null ? master.decrStackSize(par1, par2) : super.decrStackSize(par1, par2));
	}

	@Override
	public ItemStack superDecrStackSize(int par1, int par2) {
		return super.decrStackSize(par1, par2);
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int par1) {
		return (ItemStack) (master != null ? master.getStackInSlotOnClosing(par1) : super.getStackInSlotOnClosing(par1));
	}

	@Override
	public ItemStack superGetStackInSlotOnClosing(int par1) {
		return super.getStackInSlotOnClosing(par1);
	}

	@Override
	public void setInventorySlotContents(int par1, ItemStack itemStack) {
		if (master != null) master.setInventorySlotContents(par1, itemStack);
		else super.setInventorySlotContents(par1, itemStack);
	}

	@Override
	public void superSetInventorySlotContents(int par1, Object itemStack) {
		super.setInventorySlotContents(par1, (ItemStack) itemStack);
	}

	@Override
	public NBTTagList writeToNBT(NBTTagList nBTTagList) {
		return (NBTTagList) (master != null ? master.writeToNBT(nBTTagList) : super.writeToNBT(nBTTagList));
	}

	@Override
	public NBTTagList superWriteToNBT(Object nBTTagList) {
		return super.writeToNBT((NBTTagList) nBTTagList);
	}

	@Override
	public void readFromNBT(NBTTagList nBTTagList) {
		if (master != null) master.readFromNBT(nBTTagList);
		else super.readFromNBT(nBTTagList);
	}

	@Override
	public void superReadFromNBT(Object nBTTagList) {
		super.readFromNBT((NBTTagList) nBTTagList);
	}

	@Override
	public int getSizeInventory() {
		return master != null ? master.getSizeInventory() : super.getSizeInventory();
	}

	@Override
	public int superGetSizeInventory() {
		return super.getSizeInventory();
	}

	@Override
	public ItemStack getStackInSlot(int par1) {
		return (ItemStack) (master != null ? master.getStackInSlot(par1) : super.getStackInSlot(par1));
	}

	@Override
	public ItemStack superGetStackInSlot(int par1) {
		return super.getStackInSlot(par1);
	}

	@Override
	public int getInventoryStackLimit() {
		return master != null ? master.getInventoryStackLimit() : super.getInventoryStackLimit();
	}

	@Override
	public int superGetInventoryStackLimit() {
		return super.getInventoryStackLimit();
	}

	@Override
	public ItemStack armorItemInSlot(int par1) {
		return (ItemStack) (master != null ? master.armorItemInSlot(par1) : super.armorItemInSlot(par1));
	}

	@Override
	public ItemStack superArmorItemInSlot(int par1) {
		return super.armorItemInSlot(par1);
	}

	@Override
	public int getTotalArmorValue() {
		return master != null ? master.getTotalArmorValue() : super.getTotalArmorValue();
	}

	@Override
	public int superGetTotalArmorValue() {
		return super.getTotalArmorValue();
	}

	@Override
	public void damageArmor(float par1) {
		if (master != null) master.damageArmor(par1);
		else super.damageArmor(par1);
	}

	@Override
	public void superDamageArmor(float par1) {
		super.damageArmor(par1);
	}

	@Override
	public void dropAllItems() {
		if (master != null) master.dropAllItems();
		else super.dropAllItems();
	}

	@Override
	public void superDropAllItems() {
		super.dropAllItems();
	}

	@Override
	public void setItemStack(ItemStack itemStack) {
		if (master != null) master.setItemStack(itemStack);
		else super.setItemStack(itemStack);
	}

	@Override
	public void superSetItemStack(Object itemStack) {
		super.setItemStack((ItemStack) itemStack);
	}

	@Override
	public ItemStack getItemStack() {
		return (ItemStack) (master != null ? master.getItemStack() : super.getItemStack());
	}

	@Override
	public ItemStack superGetItemStack() {
		return super.getItemStack();
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
		return master != null ? master.isUseableByPlayer(entityPlayer) : super.isUseableByPlayer(entityPlayer);
	}

	@Override
	public boolean superIsUseableByPlayer(Object entityPlayer) {
		return super.isUseableByPlayer((EntityPlayer) entityPlayer);
	}

	@Override
	public boolean hasItemStack(ItemStack itemStack) {
		return master != null ? master.hasItemStack(itemStack) : super.hasItemStack(itemStack);
	}

	@Override
	public boolean superHasItemStack(Object itemStack) {
		return super.hasItemStack((ItemStack) itemStack);
	}

	@Override
	public boolean isItemValidForSlot(int par1, ItemStack itemStack) {
		return master != null ? master.isItemValidForSlot(par1, itemStack) : super.isItemValidForSlot(par1, itemStack);
	}

	@Override
	public boolean superIsItemValidForSlot(int par1, Object itemStack) {
		return super.isItemValidForSlot(par1, (ItemStack) itemStack);
	}

	@Override
	public void copyInventory(InventoryPlayer inventoryPlayer) {
		if (master != null) master.copyInventory(inventoryPlayer);
		else super.copyInventory(inventoryPlayer);
	}

	@Override
	public void superCopyInventory(Object inventoryPlayer) {
		super.copyInventory((InventoryPlayer) inventoryPlayer);
	}
	// ~164
	@Override
	public String superGetInvName() {
		return super.getCommandSenderName();
	}

	public void setCurrentItem(int par1, int par2, boolean par3, boolean par4) {
	}

	@Override
	public void superSetCurrentItem(int par1, int par2, boolean par3, boolean par4) {
	}

	public int clearInventory(int par1, int par2) {
		return -1;
	}

	@Override
	public int superClearInventory(int par1, int par2) {
		return -1;
	}

	public boolean consumeInventoryItem(int par1) {
		return false;
	}

	@Override
	public boolean superConsumeInventoryItem(int par1) {
		return false;
	}

	public boolean hasItem(int par1) {
		return false;
	}

	@Override
	public boolean superHasItem(int par1) {
		return false;
	}

	public float getStrVsBlock(Block block) {
		return 0.0F;
	}

	@Override
	public float superGetStrVsBlock(Object block) {
		return 0.0F;
	}

	public boolean canHarvestBlock(Block block) {
		return false;
	}

	@Override
	public boolean superCanHarvestBlock(Object block) {
		return false;
	}

	public void onInventoryChanged() {
	}

	@Override
	public void superOnInventoryChanged() {
	}

	public void openChest() {
	}

	@Override
	public void superOpenChest() {
	}

	public void closeChest() {
	}

	@Override
	public void superCloseChest() {
	}

	@Override
	public boolean superIsInvNameLocalized() {
		return false;
	}
	// ~179
	public void func_70439_a(Item item, int par2) {
	}

	public void superFunc_70439_a(Object item, int par2) {
	}
}
