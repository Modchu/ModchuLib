package modchu.lib.forge.mc194_210;

import java.util.HashMap;

import net.minecraft.world.World;

public class Modchu_TileEntity extends modchu.lib.forge.mc194_222.Modchu_TileEntity {

	public Modchu_TileEntity() {
		super();
	}

	public Modchu_TileEntity(HashMap<String, Object> map) {
		super(map);
	}

	// 190~210共通コピペ　↓
	@Override
	public void setWorldObj(World world) {
		if (master != null) master.setWorld(world);
		else super.setWorldObj(world);
	}

	@Override
	public void superSetWorld(Object world) {
		super.setWorldObj((World) world);
	}

	@Override
	public boolean hasWorldObj() {
		return master != null ? master.hasWorld() : super.hasWorldObj();
	}

	@Override
	public boolean superHasWorld() {
		return super.hasWorldObj();
	}
	// 190~210共通コピペ　↑

	@Override
	public void superSetWorldCreate(Object world) {
	}

	@Override
	public Object superGetDisplayName() {
		return null;
	}

	@Override
	public void superRotate(Object rotation) {
	}

	@Override
	public void superMirror(Object mirror) {
	}

	@Override
	public void superHandleUpdateTag(Object nBTTagCompound) {
	}

}
