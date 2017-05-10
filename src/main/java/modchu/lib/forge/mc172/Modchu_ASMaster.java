package modchu.lib.forge.mc172;

import java.util.HashMap;

import modchu.lib.Modchu_Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.MovingObjectPosition;

public class Modchu_ASMaster extends modchu.lib.forge.mc172_179.Modchu_ASMaster {

	public Modchu_ASMaster(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public String entityTameableGetOwnerName(Object entityTameable) {
		return ((EntityTameable) entityTameable).getOwnerName();
	}

	@Override
	public void entityTameableSetOwner(Object entityTameable, Object s) {
		((EntityTameable) entityTameable).setOwner((String) s);
	}

	@Override
	public Object minecraftGetMinecraft() {
		if (Modchu_Main.isServer) return MinecraftServer.getServer();
		return Minecraft.getMinecraft();
	}

	@Override
	public long minecraftGetSystemTime() {
		if (Modchu_Main.isServer) return MinecraftServer.getServer().getSystemTimeMillis();
		return Minecraft.getMinecraft().getSystemTime();
	}

	@Override
	public boolean threadDownloadImageDataIsTextureUploaded(Object threadDownloadImageData) {
		return ((ThreadDownloadImageData) threadDownloadImageData).isTextureUploaded();
	}

	@Override
	public void worldClientAddEntityToWorld(Object world, int i, Object entity) {
		((WorldClient) world).addEntityToWorld(i, (Entity) entity);
	}

	@Override
	public int movingObjectPositionBlockPosGetX(Object movingObjectPosition) {
		return ((MovingObjectPosition) movingObjectPosition).blockX;
	}

	@Override
	public int movingObjectPositionBlockPosGetY(Object movingObjectPosition) {
		return ((MovingObjectPosition) movingObjectPosition).blockY;
	}

	@Override
	public int movingObjectPositionBlockPosGetZ(Object movingObjectPosition) {
		return ((MovingObjectPosition) movingObjectPosition).blockZ;
	}

	@Override
	public Object entityLivingOnInitialSpawn(Object entityLiving, Object difficultyInstance, Object iEntityLivingData) {
		return ((EntityLiving) entityLiving).onSpawnWithEgg((IEntityLivingData) iEntityLivingData);
	}

}