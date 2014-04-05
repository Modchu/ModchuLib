package modchu.lib.characteristic;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_Main;
import net.minecraftforge.event.world.WorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ClientConnectedToServerEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ServerConnectionFromClientEvent;

public class Modchu_TickHandler {

	@SubscribeEvent
	public void clientConnectedToServer(ClientConnectedToServerEvent event) {
		Modchu_Debug.mDebug("clientConnectedToServer");
	}

	@SubscribeEvent
	public void worldTick(TickEvent.ClientTickEvent event) {
		Modchu_Main.onTickInGame(0.0F, null, (byte)1, event);
	}

	@SubscribeEvent
	public void worldTick(TickEvent.RenderTickEvent event) {
		Modchu_Main.onTickInGame(0.0F, null, (byte)2, event);
	}

	@SubscribeEvent
	public void keyInput(InputEvent.KeyInputEvent event) {
		Modchu_Main.keyboardEvent(event);
	}

	@SubscribeEvent
	public void ServerConnectionFromClientEvent(ServerConnectionFromClientEvent event) {
		Modchu_Main.clientConnect(event);
	}

	@SubscribeEvent
	public void onWorldLoad(WorldEvent.Load event) {
		Modchu_Main.onWorldLoad(event);
	}

}
