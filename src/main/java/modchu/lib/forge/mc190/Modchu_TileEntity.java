package modchu.lib.forge.mc190;

import modchu.lib.Modchu_ITileEntity;
import net.minecraft.nbt.NBTTagCompound;

public class Modchu_TileEntity extends modchu.lib.forge.mc190_210.Modchu_TileEntity implements Modchu_ITileEntity {

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

	public boolean superOnlyOpsCanSetNbt() {
		return super.func_183000_F();
	}

}
