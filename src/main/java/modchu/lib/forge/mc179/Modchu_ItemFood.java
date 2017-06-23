package modchu.lib.forge.mc179;

import java.util.HashMap;

import net.minecraft.item.ItemStack;

public class Modchu_ItemFood extends modchu.lib.forge.mc172_179.Modchu_ItemFood {

	public Modchu_ItemFood(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public int getItemEnchantability(ItemStack itemStack) {
		return master != null ? master.getItemEnchantability(itemStack) : super.getItemEnchantability(itemStack);
	}

	@Override
	public int superGetItemEnchantability(Object itemStack) {
		return super.getItemEnchantability((ItemStack) itemStack);
	}

	@Override
	public boolean isBeaconPayment(ItemStack itemStack) {
		return master != null ? master.isBeaconPayment(itemStack) : super.isBeaconPayment(itemStack);
	}

	@Override
	public boolean superIsBeaconPayment(Object itemStack) {
		return super.isBeaconPayment((ItemStack) itemStack);
	}

}
