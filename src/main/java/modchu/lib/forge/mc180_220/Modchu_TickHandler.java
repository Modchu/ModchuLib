package modchu.lib.forge.mc180_220;

import modchu.lib.Modchu_Main;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Modchu_TickHandler {

	@SubscribeEvent
	public void event(Event event) {
		Modchu_Main.event(event);
	}
}
