package modchu.lib.forge.mc190;

import java.util.HashMap;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class Modchu_InventoryPlayer extends modchu.lib.forge.mc190_210.Modchu_InventoryPlayer {

	public Modchu_InventoryPlayer(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public int func_184433_k() {
		return master != null ? master.getBestHotbarSlot() : super.func_184433_k();
	}

	@Override
	public int superGetBestHotbarSlot() {
		return super.func_184433_k();
	}

	@Override
	public void func_184434_a(ItemStack itemStack) {
		if (master != null) master.setPickedItemStack(itemStack);
		else super.func_184434_a(itemStack);
	}

	@Override
	public void superSetPickedItemStack(Object itemStack) {
		super.func_184434_a((ItemStack) itemStack);
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
