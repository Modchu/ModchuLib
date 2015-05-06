package modchu.lib.forge.mc162;

import java.util.EnumSet;
import java.util.HashMap;

import modchu.lib.forge.mc162_179.Modchu_ModchuLib;
import net.minecraft.client.settings.KeyBinding;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

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
		Modchu_ModchuLib.instance.keyboardEvent(kb);
	}

	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.RENDER, TickType.PLAYER, TickType.CLIENT);
	}

}
