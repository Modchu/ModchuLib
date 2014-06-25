package modchu.lib.characteristic;

import modchu.lib.Modchu_Main;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.world.WorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class Modchu_ForgeEVENTHandler {

	@SubscribeEvent
	public void chat(ServerChatEvent event) {
	}

	@SubscribeEvent
	public void livingUpdate(LivingUpdateEvent event) {
		Modchu_Main.event("livingUpdate", event);
	}

	@SubscribeEvent
	public void livingDeath(LivingDeathEvent event) {
		Modchu_Main.event("livingDeath", event);
	}

	@SubscribeEvent
	public void worldLoad(WorldEvent.Load event) {
		Modchu_Main.event("worldLoad", event);
	}

	@SubscribeEvent
	public void worldUnload(WorldEvent.Unload event) {
		Modchu_Main.event("worldUnload", event);
	}

	@SubscribeEvent
	public void playSoundAtEntity(PlaySoundAtEntityEvent event) {
		Modchu_Main.event("playSoundAtEntity", event);
	}
}