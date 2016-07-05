package modchu.lib.forge.mc190;

import java.util.HashMap;

import modchu.lib.Modchu_IItemFood;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class Modchu_ItemFood extends modchu.lib.forge.mc190_202.Modchu_ItemFood implements Modchu_IItemFood {

	public Modchu_ItemFood(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	protected RayTraceResult getMovingObjectPositionFromPlayer(World world, EntityPlayer entityPlayer, boolean par3) {
		return (RayTraceResult) (master != null ? master.rayTrace(world, entityPlayer, par3) : super.getMovingObjectPositionFromPlayer(world, entityPlayer, par3));
	}

	@Override
	public Object superRayTrace(Object world, Object entityPlayer, boolean par3) {
		return super.getMovingObjectPositionFromPlayer((World) world, (EntityPlayer) entityPlayer, par3);
	}

}
