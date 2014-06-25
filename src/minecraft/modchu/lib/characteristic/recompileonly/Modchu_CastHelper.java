package modchu.lib.characteristic.recompileonly;

import modchu.lib.Modchu_CastHelperBase;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class Modchu_CastHelper extends Modchu_CastHelperBase {

	public static EntityPlayer entityPlayer(Object o) {
		return o != null 
				&& o instanceof EntityPlayer ? (EntityPlayer) o : null;
	}

	public static World world(Object o) {
		return o != null 
				&& o instanceof World ? (World) o : null;
	}

	public static Block block(Object o) {
		return o != null 
				&& o instanceof Block ? (Block) o : null;
	}

	public static Block[] blockArray(Object o) {
		return o != null 
				&& o instanceof Block[] ? (Block[]) o : null;
	}

	public static Minecraft minecraft(Object o) {
		return o != null 
				&& o instanceof Minecraft ? (Minecraft) o : null;
	}

}
