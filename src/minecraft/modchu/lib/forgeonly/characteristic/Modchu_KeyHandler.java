package modchu.lib.forgeonly.characteristic;

import java.util.EnumSet;

import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import net.minecraft.client.settings.KeyBinding;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class Modchu_KeyHandler extends KeyHandler {

	public Modchu_KeyHandler(Object[] arg0, boolean[] repeatings) {
		super((KeyBinding[]) arg0, repeatings);
	}

	@Override
	public String getLabel() {
		return (String) Modchu_Reflect.invokeMethod(Modchu_Main.baseModInstance.getClass(), "getLabel", Modchu_Main.baseModInstance);
	}

	@Override
	public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
		//Modchu_Debug.mDebug("Modchu_KeyHandler keyDown");
		Modchu_Reflect.invokeMethod(Modchu_Main.baseModInstance.getClass(), "keyboardEvent", new Class[]{ Object.class }, Modchu_Main.baseModInstance, new Object[]{ kb });
	}

	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {

	}

	@Override
	public EnumSet<TickType> ticks() {
		return (EnumSet<TickType>) Modchu_Reflect.invokeMethod(Modchu_Main.baseModInstance.getClass(), "ticks", Modchu_Main.baseModInstance);
	}

}
