package modchu.lib.forge.mc180;

import java.util.HashMap;

import net.minecraft.nbt.NBTTagCompound;

public class Modchu_TileEntity extends modchu.lib.forge.mc180_189.Modchu_TileEntity {

	public Modchu_TileEntity() {
		super();
	}

	public Modchu_TileEntity(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public boolean superFunc_183000_F() {
		return false;
	}

	@Override
	public void superOnLoad() {
	}

	@Override
	public boolean superHasFastRenderer() {
		return false;
	}

	@Override
	public boolean superHasCapability(Object capability, Object enumFacing) {
		return false;
	}

	@Override
	public Object superGetCapability(Object capability, Object enumFacing) {
		return null;
	}

	@Override
	public void superDeserializeNBT(Object nBTTagCompound) {
	}

	@Override
	public NBTTagCompound superSerializeNBT() {
		return null;
	}

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
