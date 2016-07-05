package modchu.lib.forge.mc190;

import java.util.HashMap;

import modchu.lib.Modchu_IItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class Modchu_Item extends modchu.lib.forge.mc190_202.Modchu_Item implements Modchu_IItem {

	public Modchu_Item(HashMap<String, Object> map) {
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
