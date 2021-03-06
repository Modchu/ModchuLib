package modchu.lib.forge.mc152;

import java.util.EnumSet;
import java.util.HashMap;

import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;
import modchu.lib.Modchu_Main;
import net.minecraft.client.settings.KeyBinding;

public class Modchu_KeyHandler extends KeyHandler {

	public Modchu_KeyHandler(HashMap<String, Object> map) {
		super((KeyBinding[])map.get("Object[]"), (boolean[])map.get("boolean[]"));
	}

	@Override
	public String getLabel() {
		return ModchuPacket.instance.getLabel();
	}

	@Override
	public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
		//Modchu_Debug.mDebug("Modchu_KeyHandler keyDown");
		Modchu_Main.keyboardEvent(kb);
	}

	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.RENDER, TickType.PLAYER, TickType.CLIENT);
	}

}
