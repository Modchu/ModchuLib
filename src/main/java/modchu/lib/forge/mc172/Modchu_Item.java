package modchu.lib.forge.mc172;

import java.util.HashMap;

import net.minecraft.item.ItemStack;

public class Modchu_Item extends modchu.lib.forge.mc172_179.Modchu_Item {

	public Modchu_Item(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public int superGetItemEnchantability(Object itemStack) {
		return -1;
	}

	@Override
	public boolean superIsBeaconPayment(Object itemStack) {
		return false;
	}

}
