package modchu.lib.forge.mc212;

import java.util.HashMap;

import net.minecraft.world.World;

public class Modchu_TileEntity extends modchu.lib.forge.mc194_212.Modchu_TileEntity {

	public Modchu_TileEntity() {
		super();
	}

	public Modchu_TileEntity(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void setWorld(World world) {
		if (master != null) master.setWorld(world);
		else super.setWorld(world);
	}

	@Override
	public void superSetWorld(Object world) {
		super.setWorld((World) world);
	}

	@Override
	public boolean hasWorld() {
		return master != null ? master.hasWorld() : super.hasWorld();
	}

	@Override
	public boolean superHasWorld() {
		return super.hasWorld();
	}

}
