package modchu.lib.forge.mc172_179;

import modchu.lib.Modchu_Main;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class Modchu_ForgeEVENTHandler {

	@SubscribeEvent
	public void event(Event event) {
		Object o = Modchu_Main.event(event);
	}
}