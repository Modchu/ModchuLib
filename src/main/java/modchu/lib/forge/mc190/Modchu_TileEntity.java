package modchu.lib.forge.mc190;

import modchu.lib.Modchu_ITileEntity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class Modchu_TileEntity extends modchu.lib.forge.mc190_220.Modchu_TileEntity implements Modchu_ITileEntity {

	public Modchu_TileEntity() {
	}

	@Override
	public void writeToNBT(NBTTagCompound nBTTagCompound) {
		if (masterClassName != null
				&& !masterClassName.isEmpty()) {
			try {
				nBTTagCompound.setString("masterClassName", masterClassName);
				if (master != null) master.writeToNBT(nBTTagCompound);
				else super.writeToNBT(nBTTagCompound);
			} catch (Throwable throwable) {
			}
		}
		//Modchu_Debug.mDebug("writeToNBT masterClassName="+masterClassName);
	}

	@Override
	public Object superWriteToNBT(Object nBTTagCompound) {
		super.writeToNBT((NBTTagCompound) nBTTagCompound);
		return nBTTagCompound;
	}
	// 194~
	@Override
	public Object superGetUpdatePacket() {
		return null;
	}

	@Override
	public Object superGetUpdateTag() {
		return null;
	}
	// 190~
	@Override
	public boolean func_183000_F() {
		return master != null ? master.onlyOpsCanSetNbt() : super.func_183000_F();
	}

	@Override
	public boolean superOnlyOpsCanSetNbt() {
		return super.func_183000_F();
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
	public boolean superFunc_183000_F() {
		return super.func_183000_F();
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
