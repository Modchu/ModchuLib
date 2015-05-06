package modchu.lib.forge.mc172_179;

import java.util.HashMap;
import java.util.List;

import modchu.lib.Modchu_IContainerPlayer;
import modchu.lib.Modchu_IContainerPlayerMaster;
import modchu.lib.Modchu_IGuiContainerMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class Modchu_ContainerPlayer extends ContainerPlayer implements Modchu_IContainerPlayer {
	public Modchu_IContainerPlayerMaster master;

	public Modchu_ContainerPlayer(HashMap<String, Object> map) {
		super((InventoryPlayer)map.get("Object"), (Boolean)map.get("Boolean"), (EntityPlayer)map.get("Object1"));
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.lDebug("Modchu_ContainerPlayer init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IContainerPlayerMaster ? (Modchu_IContainerPlayerMaster) instance : null;
	}

	@Override
	public void onCraftMatrixChanged(IInventory iInventory) {
		if (master != null) master.onCraftMatrixChanged(iInventory);
		else super.onCraftMatrixChanged(iInventory);
	}

	public void superOnCraftMatrixChanged(Object iInventory) {
		super.onCraftMatrixChanged((IInventory) iInventory);
	}

	@Override
	public void onContainerClosed(EntityPlayer entityPlayer) {
		if (master != null) master.onContainerClosed(entityPlayer);
		else super.onContainerClosed(entityPlayer);
	}

	public void superOnContainerClosed(Object entityPlayer) {
		super.onContainerClosed((EntityPlayer) entityPlayer);
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityPlayer) {
		return master != null ? master.canInteractWith(entityPlayer) : super.canInteractWith(entityPlayer);
	}

	public boolean superCanInteractWith(Object entityPlayer) {
		return super.canInteractWith((EntityPlayer) entityPlayer);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int par2) {
		return (ItemStack) (master != null ? master.transferStackInSlot(entityPlayer, par2) : super.transferStackInSlot(entityPlayer, par2));
	}

	public ItemStack superTransferStackInSlot(Object entityPlayer, int par2) {
		return super.transferStackInSlot((EntityPlayer) entityPlayer, par2);
	}

	@Override
	public boolean func_94530_a(ItemStack itemStack, Slot slot) {
		return master != null ? master.func_94530_a(itemStack, slot) : super.func_94530_a(itemStack, slot);
	}

	public boolean superFunc_94530_a(Object itemStack, Object slot) {
		return super.func_94530_a((ItemStack) itemStack, (Slot) slot);
	}

	@Override
	protected Slot addSlotToContainer(Slot slot) {
		return (Slot) (master != null ? master.addSlotToContainer(slot) : super.addSlotToContainer(slot));
	}

	public Slot superAddSlotToContainer(Object slot) {
		return super.addSlotToContainer((Slot) slot);
	}

	@Override
	public void addCraftingToCrafters(ICrafting iCrafting) {
		if (master != null) master.addCraftingToCrafters(iCrafting);
		else super.addCraftingToCrafters(iCrafting);
	}

	public void superAddCraftingToCrafters(Object iCrafting) {
		super.addCraftingToCrafters((ICrafting) iCrafting);
	}

	@Override
	public List getInventory() {
		return master != null ? master.getInventory() : super.getInventory();
	}

	public List superGetInventory() {
		return super.getInventory();
	}

	@Override
	public void removeCraftingFromCrafters(ICrafting iCrafting) {
		if (master != null) master.removeCraftingFromCrafters(iCrafting);
		else super.removeCraftingFromCrafters(iCrafting);
	}

	public void superRemoveCraftingFromCrafters(Object iCrafting) {
		super.removeCraftingFromCrafters((ICrafting) iCrafting);
	}

	@Override
	public void detectAndSendChanges() {
		if (master != null) master.detectAndSendChanges();
		else super.detectAndSendChanges();
	}

	public void superDetectAndSendChanges() {
		super.detectAndSendChanges();
	}

	@Override
	public boolean enchantItem(EntityPlayer entityPlayer, int par2) {
		return master != null ? master.enchantItem(entityPlayer, par2) : super.enchantItem(entityPlayer, par2);
	}

	public boolean superEnchantItem(Object entityPlayer, int par2) {
		return super.enchantItem((EntityPlayer) entityPlayer, par2);
	}

	@Override
	public Slot getSlotFromInventory(IInventory iInventory, int par2) {
		return (Slot) (master != null ? master.getSlotFromInventory(iInventory, par2) : super.getSlotFromInventory(iInventory, par2));
	}

	public Slot superGetSlotFromInventory(Object iInventory, int par2) {
		return super.getSlotFromInventory((IInventory) iInventory, par2);
	}

	@Override
	public Slot getSlot(int par1) {
		return (Slot) (master != null ? master.getSlot(par1) : super.getSlot(par1));
	}

	public Slot superGetSlot(int par1) {
		return super.getSlot(par1);
	}

	@Override
	public ItemStack slotClick(int par1, int par2, int par3, EntityPlayer entityPlayer) {
		return (ItemStack) (master != null ? master.slotClick(par1, par2, par3, entityPlayer) : super.slotClick(par1, par2, par3, entityPlayer));
	}

	public ItemStack superSlotClick(int par1, int par2, int par3, Object entityPlayer) {
		return super.slotClick(par1, par2, par3, (EntityPlayer) entityPlayer);
	}

	@Override
	protected void retrySlotClick(int par1, int par2, boolean par3, EntityPlayer entityPlayer) {
		if (master != null) master.retrySlotClick(par1, par2, par3, entityPlayer);
		else super.retrySlotClick(par1, par2, par3, entityPlayer);
	}

	public void superRetrySlotClick(int par1, int par2, boolean par3, Object entityPlayer) {
		super.retrySlotClick(par1, par2, par3, (EntityPlayer) entityPlayer);
	}

	@Override
	public void putStackInSlot(int par1, ItemStack itemStack) {
		if (master != null) master.putStackInSlot(par1, itemStack);
		else super.putStackInSlot(par1, itemStack);
	}

	public void superPutStackInSlot(int par1, Object itemStack) {
		super.putStackInSlot(par1, (ItemStack) itemStack);
	}

	@Override
	public void putStacksInSlots(ItemStack[] itemStack) {
		if (master != null) master.putStacksInSlots(itemStack);
		else super.putStacksInSlots(itemStack);
	}

	public void superPutStacksInSlots(Object[] itemStack) {
		super.putStacksInSlots((ItemStack[]) itemStack);
	}

	@Override
	public void updateProgressBar(int par1, int par2) {
		if (master != null) master.updateProgressBar(par1, par2);
		else super.updateProgressBar(par1, par2);
	}

	public void superUpdateProgressBar(int par1, int par2) {
		super.updateProgressBar(par1, par2);
	}

	@Override
	public short getNextTransactionID(InventoryPlayer inventoryPlayer) {
		return master != null ? master.getNextTransactionID(inventoryPlayer) : super.getNextTransactionID(inventoryPlayer);
	}

	public short superGetNextTransactionID(Object inventoryPlayer) {
		return super.getNextTransactionID((InventoryPlayer) inventoryPlayer);
	}

	@Override
	public boolean isPlayerNotUsingContainer(EntityPlayer entityPlayer) {
		return master != null ? master.isPlayerNotUsingContainer(entityPlayer) : super.isPlayerNotUsingContainer(entityPlayer);
	}

	public boolean superIsPlayerNotUsingContainer(Object entityPlayer) {
		return super.isPlayerNotUsingContainer((EntityPlayer) entityPlayer);
	}

	@Override
	public void setPlayerIsPresent(EntityPlayer entityPlayer, boolean par2) {
		if (master != null) master.setPlayerIsPresent(entityPlayer, par2);
		else super.setPlayerIsPresent(entityPlayer, par2);
	}

	public void superSetPlayerIsPresent(Object entityPlayer, boolean par2) {
		super.setPlayerIsPresent((EntityPlayer) entityPlayer, par2);
	}

	@Override
	protected boolean mergeItemStack(ItemStack itemStack, int par2, int par3, boolean par4) {
		return master != null ? master.mergeItemStack(itemStack, par2, par3, par4) : super.mergeItemStack(itemStack, par2, par3, par4);
	}

	public boolean superMergeItemStack(Object itemStack, int par2, int par3, boolean par4) {
		return super.mergeItemStack((ItemStack) itemStack, par2, par3, par4);
	}

	@Override
	protected void func_94533_d() {
		if (master != null) master.func_94533_d();
		else super.func_94533_d();
	}

	public void superFunc_94533_d() {
		super.func_94533_d();
	}

	@Override
	public boolean canDragIntoSlot(Slot slot) {
		return master != null ? master.canDragIntoSlot(slot) : super.canDragIntoSlot(slot);
	}

	public boolean superCanDragIntoSlot(Object slot) {
		return super.canDragIntoSlot((Slot) slot);
	}

}
