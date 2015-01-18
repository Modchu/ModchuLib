package modchu.lib.characteristic;

import modchu.lib.Modchu_CastHelperBase;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Minecraft;
import net.minecraft.src.World;

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
