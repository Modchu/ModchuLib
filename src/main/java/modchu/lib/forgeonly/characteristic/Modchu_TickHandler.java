package modchu.lib.forgeonly.characteristic;

import modchu.lib.Modchu_Main;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Modchu_TickHandler {

	@SubscribeEvent
	public void event(Event event) {
		Modchu_Main.event(event);
	}
}
