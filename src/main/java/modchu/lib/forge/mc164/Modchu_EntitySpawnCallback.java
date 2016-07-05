package modchu.lib.forge.mc164;

import java.util.HashMap;

import com.google.common.base.Function;

import cpw.mods.fml.common.network.EntitySpawnPacket;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntitySpawnCallback;
import modchu.lib.Modchu_IEntitySpawnCallbackMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.entity.Entity;

public class Modchu_EntitySpawnCallback implements Function<EntitySpawnPacket, Entity>, Modchu_IEntitySpawnCallback {
	public Modchu_IEntitySpawnCallbackMaster master;

	public Modchu_EntitySpawnCallback(HashMap<String, Object> map) {
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		master = instance instanceof Modchu_IEntitySpawnCallbackMaster ? (Modchu_IEntitySpawnCallbackMaster) instance : null;
		Modchu_Debug.mDebug("Modchu_EntitySpawnCallback init master="+master);
	}

	@Override
	public Entity apply(EntitySpawnPacket entitySpawnPacket) {
		return (Entity) (master != null ? master.apply(entitySpawnPacket) : null);
	}

	@Override
	public Entity superApply(Object entitySpawnPacket) {
		return null;
	}

}
