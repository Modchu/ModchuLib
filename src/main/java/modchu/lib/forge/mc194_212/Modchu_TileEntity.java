package modchu.lib.forge.mc194_212;

import java.util.HashMap;

import modchu.lib.Modchu_ITileEntity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;

public abstract class Modchu_TileEntity extends modchu.lib.forge.mc190_212.Modchu_TileEntity implements Modchu_ITileEntity {

	public Modchu_TileEntity() {
		super();
	}

	public Modchu_TileEntity(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nBTTagCompound) {
		if (masterClassName != null
				&& !masterClassName.isEmpty()) {
			try {
				nBTTagCompound.setString("masterClassName", masterClassName);
				return (NBTTagCompound) (master != null ? master.writeToNBT(nBTTagCompound) : super.writeToNBT(nBTTagCompound));
			} catch (Throwable throwable) {
			}
		}
		//Modchu_Debug.mDebug("writeToNBT masterClassName="+masterClassName);
		return null;
	}

	@Override
	public Object superWriteToNBT(Object nBTTagCompound) {
		return super.writeToNBT((NBTTagCompound) nBTTagCompound);
	}
	// 194~
	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		return (SPacketUpdateTileEntity) (master != null ? master.getUpdatePacket() : super.getUpdatePacket());
	}

	@Override
	public SPacketUpdateTileEntity superGetUpdatePacket() {
		return super.getUpdatePacket();
	}

	public NBTTagCompound getUpdateTag() {
		return (NBTTagCompound) (master != null ? master.getUpdateTag() : super.getUpdateTag());
	}

	@Override
	public NBTTagCompound superGetUpdateTag() {
		return super.getUpdateTag();
	}
	// 190~
	@Override
	public boolean onlyOpsCanSetNbt() {
		return master != null ? master.onlyOpsCanSetNbt() : super.onlyOpsCanSetNbt();
	}

	public boolean superOnlyOpsCanSetNbt() {
		return super.onlyOpsCanSetNbt();
	}

}
