package modchu.lib.forge.mc152_162;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_Main;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ForgeSubscribe;

public class Modchu_ForgeEVENTHandler {

	@ForgeSubscribe
	public void event(TextureStitchEvent.Pre event) {
		Modchu_Main.event(event);
	}

	@ForgeSubscribe
	public void event(TextureStitchEvent.Post event) {
		Modchu_Main.event(event);
	}

	@ForgeSubscribe
	public void event(Event event) {
		Modchu_Main.event(event);
	}
}