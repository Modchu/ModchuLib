package modchu.lib.forge.mc189;

import java.util.HashMap;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class Modchu_TileEntity extends modchu.lib.forge.mc180_189.Modchu_TileEntity {

	public Modchu_TileEntity() {
		super();
	}

	public Modchu_TileEntity(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public boolean func_183000_F() {
		return master != null ? master.onlyOpsCanSetNbt() : super.func_183000_F();
	}

	@Override
	public boolean superFunc_183000_F() {
		return super.func_183000_F();
	}

	@Override
	public void onLoad() {
		if (master != null) master.onLoad();
		else super.onLoad();
	}

	@Override
	public void superOnLoad() {
		super.onLoad();
	}

	@Override
	public boolean hasFastRenderer() {
		return master != null ? master.hasFastRenderer() : super.hasFastRenderer();
	}

	@Override
	public boolean superHasFastRenderer() {
		return super.hasFastRenderer();
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing enumFacing) {
		return master != null ? master.hasCapability(capability, enumFacing) : super.hasCapability(capability, enumFacing);
	}

	@Override
	public boolean superHasCapability(Object capability, Object enumFacing) {
		return super.hasCapability((Capability) capability, (EnumFacing) enumFacing);
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing enumFacing) {
		return (T) (master != null ? master.getCapability(capability, enumFacing) : super.getCapability(capability, enumFacing));
	}

	@Override
	public Object superGetCapability(Object capability, Object enumFacing) {
		return super.getCapability((Capability) capability, (EnumFacing) enumFacing);
	}

	@Override
	public void deserializeNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.deserializeNBT(nBTTagCompound);
		else super.deserializeNBT(nBTTagCompound);
	}

	@Override
	public void superDeserializeNBT(Object nBTTagCompound) {
		super.deserializeNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public NBTTagCompound serializeNBT() {
		return (NBTTagCompound) (master != null ? master.serializeNBT() : super.serializeNBT());
	}

	@Override
	public NBTTagCompound superSerializeNBT() {
		return super.serializeNBT();
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
