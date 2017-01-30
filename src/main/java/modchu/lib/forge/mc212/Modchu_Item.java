package modchu.lib.forge.mc212;

import java.util.HashMap;

import net.minecraft.item.ItemStack;

public class Modchu_Item extends modchu.lib.forge.mc210_212.Modchu_Item {

	public Modchu_Item(HashMap<String, Object> map) {
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
