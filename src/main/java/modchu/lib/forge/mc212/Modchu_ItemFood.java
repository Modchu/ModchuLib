package modchu.lib.forge.mc212;

import java.util.HashMap;

import net.minecraft.item.ItemStack;

public class Modchu_ItemFood extends modchu.lib.forge.mc210_212.Modchu_ItemFood {

	public Modchu_ItemFood(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public boolean isEnchantable(ItemStack itemStack) {
		return master != null ? master.isEnchantable(itemStack) : super.isEnchantable(itemStack);
	}

	@Override
	public boolean superIsEnchantable(Object itemStack) {
		return super.isEnchantable((ItemStack) itemStack);
	}

}
