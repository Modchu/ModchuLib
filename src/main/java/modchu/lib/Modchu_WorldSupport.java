package modchu.lib;

public class Modchu_WorldSupport {

	public static boolean checkMaterial(double x, double y, double z, Object entity, Object material) {
		int version = Modchu_Main.getMinecraftVersion();
		Object world = Modchu_AS.get(Modchu_AS.entityWorldObj, entity);
		Object blockPos = Modchu_AS.get(Modchu_AS.newBlockPos, x, y, z);
		Object iBlockState = Modchu_AS.get(Modchu_AS.worldGetBlockState, world, blockPos);
		boolean b = (version > 189
				&& Modchu_AS.get("IBlockProperties", "getMaterial", iBlockState) != material)
				| (version < 190
						&& version > 179
						&& Modchu_AS.get("Block", "getMaterial", Modchu_AS.get("IBlockState", "getBlock", iBlockState)) != material)
				| (version < 180
						&& Modchu_AS.get("Block", version > 169 ? "getMaterial" : "blockMaterial", Modchu_AS.get(Modchu_AS.worldGetBlock, world,
								Modchu_CastHelper.Int(x, 0, false), Modchu_CastHelper.Int(y, 0, false), Modchu_CastHelper.Int(z, 0, false))) != material);
		return b;
	}

}
