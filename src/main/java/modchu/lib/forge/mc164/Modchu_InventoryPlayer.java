package modchu.lib.forge.mc164;

import java.util.HashMap;

import modchu.lib.Modchu_IContainerPlayerMaster;
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

	public ItemStack superGetCurrentItem() {
		return super.getCurrentItem();
	}

	@Override
	public int getFirstEmptyStack() {
		return master != null ? master.getFirstEmptyStack() : super.getFirstEmptyStack();
	}

	public int superGetFirstEmptyStack() {
		return super.getFirstEmptyStack();
	}

	@Override
	public void setCurrentItem(int par1, int par2, boolean par3, boolean par4) {
		if (master != null) master.setCurrentItem(par1, par2, par3, par4);
		else super.setCurrentItem(par1, par2, par3, par4);
	}

	public void superSetCurrentItem(int par1, int par2, boolean par3, boolean par4) {
		super.setCurrentItem(par1, par2, par3, par4);
	}

	@Override
	public void changeCurrentItem(int par1) {
		if (master != null) master.changeCurrentItem(par1);
		else super.changeCurrentItem(par1);
	}

	public void superChangeCurrentItem(int par1) {
		super.changeCurrentItem(par1);
	}

	@Override
	public int clearInventory(int par1, int par2) {
		return master != null ? master.clearInventory(par1, par2) : super.clearInventory(par1, par2);
	}

	public int superClearInventory(int par1, int par2) {
		return super.clearInventory(par1, par2);
	}

	@Override
	public void func_70439_a(Item item, int par2) {
		if (master != null) master.func_70439_a(item, par2);
		else super.func_70439_a(item, par2);
	}

	public void superFunc_70439_a(Object item, int par2) {
		super.func_70439_a((Item) item, par2);
	}

	@Override
	public void decrementAnimations() {
		if (master != null) master.decrementAnimations();
		else super.decrementAnimations();
	}

	public void superDecrementAnimations() {
		super.decrementAnimations();
	}

	@Override
	public boolean consumeInventoryItem(int par1) {
		return master != null ? master.consumeInventoryItem(par1) : super.consumeInventoryItem(par1);
	}

	public boolean superConsumeInventoryItem(int par1) {
		return super.consumeInventoryItem(par1);
	}

	@Override
	public boolean hasItem(int par1) {
		return master != null ? master.hasItem(par1) : super.hasItem(par1);
	}

	public boolean superHasItem(int par1) {
		return super.hasItem(par1);
	}

	@Override
	public boolean addItemStackToInventory(ItemStack itemStack) {
		return master != null ? master.addItemStackToInventory(itemStack) : super.addItemStackToInventory(itemStack);
	}

	public boolean superAddItemStackToInventory(Object itemStack) {
		return super.addItemStackToInventory((ItemStack) itemStack);
	}

	@Override
	public ItemStack decrStackSize(int par1, int par2) {
		return (ItemStack) (master != null ? master.decrStackSize(par1, par2) : super.decrStackSize(par1, par2));
	}

	public ItemStack superDecrStackSize(int par1, int par2) {
		return super.decrStackSize(par1, par2);
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int par1) {
		return (ItemStack) (master != null ? master.getStackInSlotOnClosing(par1) : super.getStackInSlotOnClosing(par1));
	}

	public ItemStack superGetStackInSlotOnClosing(int par1) {
		return super.getStackInSlotOnClosing(par1);
	}

	@Override
	public void setInventorySlotContents(int par1, ItemStack itemStack) {
		if (master != null) master.setInventorySlotContents(par1, itemStack);
		else super.setInventorySlotContents(par1, itemStack);
	}

	public void superSetInventorySlotContents(int par1, Object itemStack) {
		super.setInventorySlotContents(par1, (ItemStack) itemStack);
	}

	@Override
	public float getStrVsBlock(Block block) {
		return master != null ? master.getStrVsBlock(block) : super.getStrVsBlock(block);
	}

	public float superGetStrVsBlock(Object block) {
		return super.getStrVsBlock((Block) block);
	}

	@Override
	public NBTTagList writeToNBT(NBTTagList nBTTagList) {
		return (NBTTagList) (master != null ? master.writeToNBT(nBTTagList) : super.writeToNBT(nBTTagList));
	}

	public NBTTagList superWriteToNBT(Object nBTTagList) {
		return super.writeToNBT((NBTTagList) nBTTagList);
	}

	@Override
	public void readFromNBT(NBTTagList nBTTagList) {
		if (master != null) master.readFromNBT(nBTTagList);
		else super.readFromNBT(nBTTagList);
	}

	public void superReadFromNBT(Object nBTTagList) {
		super.readFromNBT((NBTTagList) nBTTagList);
	}

	@Override
	public int getSizeInventory() {
		return master != null ? master.getSizeInventory() : super.getSizeInventory();
	}

	public int superGetSizeInventory() {
		return super.getSizeInventory();
	}

	@Override
	public ItemStack getStackInSlot(int par1) {
		return (ItemStack) (master != null ? master.getStackInSlot(par1) : super.getStackInSlot(par1));
	}

	public ItemStack superGetStackInSlot(int par1) {
		return super.getStackInSlot(par1);
	}

	@Override
	public String getInvName() {
		return master != null ? master.getInvName() : super.getInvName();
	}

	public String superGetInvName() {
		return super.getInvName();
	}

	@Override
	public boolean isInvNameLocalized() {
		return master != null ? master.isInvNameLocalized() : super.isInvNameLocalized();
	}

	public boolean superIsInvNameLocalized() {
		return super.isInvNameLocalized();
	}

	@Override
	public int getInventoryStackLimit() {
		return master != null ? master.getInventoryStackLimit() : super.getInventoryStackLimit();
	}

	public int superGetInventoryStackLimit() {
		return super.getInventoryStackLimit();
	}

	@Override
	public boolean canHarvestBlock(Block block) {
		return master != null ? master.canHarvestBlock(block) : super.canHarvestBlock(block);
	}

	public boolean superCanHarvestBlock(Object block) {
		return super.canHarvestBlock((Block) block);
	}

	@Override
	public ItemStack armorItemInSlot(int par1) {
		return (ItemStack) (master != null ? master.armorItemInSlot(par1) : super.armorItemInSlot(par1));
	}

	public ItemStack superArmorItemInSlot(int par1) {
		return super.armorItemInSlot(par1);
	}

	@Override
	public int getTotalArmorValue() {
		return master != null ? master.getTotalArmorValue() : super.getTotalArmorValue();
	}

	public int superGetTotalArmorValue() {
		return super.getTotalArmorValue();
	}

	@Override
	public void damageArmor(float par1) {
		if (master != null) master.damageArmor(par1);
		else super.damageArmor(par1);
	}

	public void superDamageArmor(float par1) {
		super.damageArmor(par1);
	}

	@Override
	public void dropAllItems() {
		if (master != null) master.dropAllItems();
		else super.dropAllItems();
	}

	public void superDropAllItems() {
		super.dropAllItems();
	}

	@Override
	public void onInventoryChanged() {
		if (master != null) master.onInventoryChanged();
		else super.onInventoryChanged();
	}

	public void superOnInventoryChanged() {
		super.onInventoryChanged();
	}

	@Override
	public void setItemStack(ItemStack itemStack) {
		if (master != null) master.setItemStack(itemStack);
		else super.setItemStack(itemStack);
	}

	public void superSetItemStack(Object itemStack) {
		super.setItemStack((ItemStack) itemStack);
	}

	@Override
	public ItemStack getItemStack() {
		return (ItemStack) (master != null ? master.getItemStack() : super.getItemStack());
	}

	public ItemStack superGetItemStack() {
		return super.getItemStack();
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
		return master != null ? master.isUseableByPlayer(entityPlayer) : super.isUseableByPlayer(entityPlayer);
	}

	public boolean superIsUseableByPlayer(Object entityPlayer) {
		return super.isUseableByPlayer((EntityPlayer) entityPlayer);
	}

	@Override
	public boolean hasItemStack(ItemStack itemStack) {
		return master != null ? master.hasItemStack(itemStack) : super.hasItemStack(itemStack);
	}

	public boolean superHasItemStack(Object itemStack) {
		return super.hasItemStack((ItemStack) itemStack);
	}

	@Override
	public void openChest() {
		if (master != null) master.openChest();
		else super.openChest();
	}

	public void superOpenChest() {
		super.openChest();
	}

	@Override
	public void closeChest() {
		if (master != null) master.closeChest();
		else super.closeChest();
	}

	public void superCloseChest() {
		super.closeChest();
	}

	@Override
	public boolean isItemValidForSlot(int par1, ItemStack itemStack) {
		return master != null ? master.isItemValidForSlot(par1, itemStack) : super.isItemValidForSlot(par1, itemStack);
	}

	public boolean superIsItemValidForSlot(int par1, Object itemStack) {
		return super.isItemValidForSlot(par1, (ItemStack) itemStack);
	}

	@Override
	public void copyInventory(InventoryPlayer inventoryPlayer) {
		if (master != null) master.copyInventory(inventoryPlayer);
		else super.copyInventory(inventoryPlayer);
	}

	public void superCopyInventory(Object inventoryPlayer) {
		super.copyInventory((InventoryPlayer) inventoryPlayer);
	}

}
