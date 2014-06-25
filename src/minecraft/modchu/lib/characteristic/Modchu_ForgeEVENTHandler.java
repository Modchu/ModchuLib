package modchu.lib.characteristic;

import modchu.lib.Modchu_Main;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.world.WorldEvent;

public class Modchu_ForgeEVENTHandler {

	@ForgeSubscribe
	public void chat(ServerChatEvent event) {
	}

	@ForgeSubscribe
	public void livingUpdate(LivingUpdateEvent event) {
		Modchu_Main.event("livingUpdate", event);
	}

	@ForgeSubscribe
	public void livingDeath(LivingDeathEvent event) {
		Modchu_Main.event("livingDeath", event);
	}

	@ForgeSubscribe
	public void worldLoad(WorldEvent.Load event) {
		Modchu_Main.event("worldLoad", event);
	}

	@ForgeSubscribe
	public void worldUnload(WorldEvent.Unload event) {
		Modchu_Main.event("worldUnload", event);
	}

	@ForgeSubscribe
	public void playSoundAtEntity(PlaySoundAtEntityEvent event) {
		Modchu_Main.event("playSoundAtEntity", event);
	}
}