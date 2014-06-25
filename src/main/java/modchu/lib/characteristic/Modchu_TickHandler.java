package modchu.lib.characteristic;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_Main;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ClientConnectedToServerEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ServerConnectionFromClientEvent;

public class Modchu_TickHandler {

	@SubscribeEvent
	public void clientConnectedToServer(ClientConnectedToServerEvent event) {
		Modchu_Debug.mDebug("Modchu_TickHandler clientConnectedToServer");
		Modchu_Main.event("clientConnectedToServer", event);
	}

	@SubscribeEvent
	public void worldTick(TickEvent.ClientTickEvent event) {
		//Modchu_Debug.mDebug("Modchu_TickHandler worldTick 1");
		Modchu_Main.onTickInGame(0.0F, null, (byte)1, event);
	}

	@SubscribeEvent
	public void worldTick(TickEvent.RenderTickEvent event) {
		//Modchu_Debug.mDebug("Modchu_TickHandler worldTick 2");
		Modchu_Main.onTickInGame(0.0F, null, (byte)2, event);
	}

	@SubscribeEvent
	public void keyInputEvent(InputEvent.KeyInputEvent event) {
		Modchu_Main.keyboardEvent(event);
	}

	@SubscribeEvent
	public void ServerConnectionFromClientEvent(ServerConnectionFromClientEvent event) {
		Modchu_Main.event("clientConnect", event);
	}

}
