package net.minecraft.client.gui;

import modchu.lib.Modchu_Reflect;

public class Modchu_GuiManager {
	
	public static Object newGuiButtonNextPage(int i, int i1, int i2, boolean b) {
		return Modchu_Reflect.newInstance("GuiButtonNextPage", new Class[]{ int.class, int.class, int.class, boolean.class }, new Object[]{ i, i1, i2, b });
	}
}
