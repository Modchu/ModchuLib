package modchu.lib.forge.mc210;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Modchu_InventoryPlayer extends modchu.lib.forge.mc190_220.Modchu_InventoryPlayer {

	public Modchu_InventoryPlayer(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
		return master != null ? master.isUsableByPlayer(entityPlayer) : super.isUseableByPlayer(entityPlayer);
	}

	@Override
	public boolean superIsUsableByPlayer(Object entityPlayer) {
		return super.isUseableByPlayer((EntityPlayer) entityPlayer);
	}

	@Override
	public boolean superIsUseableByPlayer(Object entityPlayer) {
		return super.isUseableByPlayer((EntityPlayer) entityPlayer);
	}

	@Override
	public void superFunc_146030_a(Object item, int p_146030_2_, boolean p_146030_3_, boolean p_146030_4_) {
	}

	@Override
	public float superFunc_146023_a(Object block) {
		return 0.0F;
	}

	@Override
	public String superGetInventoryName() {
		return super.superGetInvName();
	}

	@Override
	public boolean superHasCustomInventoryName() {
		return super.hasCustomName();
	}

	@Override
	public boolean superFunc_146025_b(Object block) {
		return false;
	}

	@Override
	public void superOpenInventory() {
	}

	@Override
	public void superCloseInventory() {
	}

	@Override
	public void superSetPickedItemStack(Object itemStack) {
		super.setPickedItemStack((ItemStack) itemStack);
	}

	@Override
	public int superGetBestHotbarSlot() {
		return super.getBestHotbarSlot();
	}

}
