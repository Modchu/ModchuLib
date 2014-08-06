package modchu.lib.characteristic;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_Main;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ClientConnectedToServerEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ServerConnectionFromClientEvent;

public class Modchu_TickHandler {

	@SubscribeEvent
	public void event(Event event) {
		Modchu_Main.event(event);
	}
}
