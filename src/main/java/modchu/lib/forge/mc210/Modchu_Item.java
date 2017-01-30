package modchu.lib.forge.mc210;

import java.util.HashMap;

import net.minecraft.item.ItemStack;

public class Modchu_Item extends modchu.lib.forge.mc210_212.Modchu_Item {

	public Modchu_Item(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public boolean isItemTool(ItemStack itemStack) {
		return master != null ? master.isEnchantable(itemStack) : super.isItemTool(itemStack);
	}

	@Override
	public boolean superIsEnchantable(Object itemStack) {
		return super.isItemTool((ItemStack) itemStack);
	}

}
