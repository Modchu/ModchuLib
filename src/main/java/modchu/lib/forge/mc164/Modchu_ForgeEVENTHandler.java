package modchu.lib.forge.mc164;

import modchu.lib.Modchu_Main;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ForgeSubscribe;

public class Modchu_ForgeEVENTHandler {

	@ForgeSubscribe
	public void event(Event event) {
		Modchu_Main.event(event);
	}
}