package modchu.lib.forge.mc172;

import java.util.HashMap;

public class Modchu_ItemFood extends modchu.lib.forge.mc172_179.Modchu_ItemFood {

	public Modchu_ItemFood(HashMap<String, Object> map) {
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
