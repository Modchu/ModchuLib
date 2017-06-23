package modchu.lib.forge.mc194;

import java.util.HashMap;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class Modchu_InventoryPlayer extends modchu.lib.forge.mc190_210.Modchu_InventoryPlayer {

	public Modchu_InventoryPlayer(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public int getBestHotbarSlot() {
		return master != null ? master.getBestHotbarSlot() : super.getBestHotbarSlot();
	}

	@Override
	public int superGetBestHotbarSlot() {
		return super.getBestHotbarSlot();
	}

	@Override
	public void setPickedItemStack(ItemStack itemStack) {
		if (master != null) master.setPickedItemStack(itemStack);
		else super.setPickedItemStack(itemStack);
	}

	@Override
	public void superSetPickedItemStack(Object itemStack) {
		super.setPickedItemStack((ItemStack) itemStack);
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
		return master != null ? master.isUseableByPlayer(entityPlayer) : super.isUseableByPlayer(entityPlayer);
	}

	@Override
	public boolean superIsUseableByPlayer(Object entityPlayer) {
		return super.isUseableByPlayer((EntityPlayer) entityPlayer);
	}

}
