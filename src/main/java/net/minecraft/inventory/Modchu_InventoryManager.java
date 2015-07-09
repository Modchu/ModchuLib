package net.minecraft.inventory;

import modchu.lib.Modchu_Reflect;

public class Modchu_InventoryManager {

	public static Object newSlotArmor(Object containerPlayer, Object iInventory, int i, int i1, int i2, int i3) {
		return Modchu_Reflect.newInstance("SlotArmor", new Class[]{ Modchu_Reflect.loadClass("ContainerPlayer"), Modchu_Reflect.loadClass("IInventory"), int.class, int.class, int.class, int.class }, new Object[]{ containerPlayer, iInventory, i, i1, i2, i3 });
	}

}
