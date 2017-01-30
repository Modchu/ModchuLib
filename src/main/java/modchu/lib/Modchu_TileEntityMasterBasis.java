package modchu.lib;

import java.util.HashMap;

public class Modchu_TileEntityMasterBasis implements Modchu_ITileEntityMaster {
	public Modchu_ITileEntity base;

	public Modchu_TileEntityMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_ITileEntity) map.get("base");
	}

	@Override
	public Object getWorld() {
		return base.superGetWorld();
	}

	@Override
	public void setWorld(Object world) {
		base.superSetWorld(world);
	}

	@Override
	public boolean hasWorld() {
		return base.superHasWorld();
	}

	@Override
	public void readFromNBT(Object nBTTagCompound) {
		base.superReadFromNBT(nBTTagCompound);
	}

	@Override
	public Object writeToNBT(Object nBTTagCompound) {
		return base.superWriteToNBT(nBTTagCompound);
	}

	@Override
	public void updateEntity() {
		base.superUpdateEntity();
	}

	@Override
	public int getBlockMetadata() {
		return base.superGetBlockMetadata();
	}

	@Override
	public void onInventoryChanged() {
		base.superOnInventoryChanged();
	}

	@Override
	public double getDistanceSq(double par1, double par3, double par5) {
		return base.superGetDistanceSq(par1, par3, par5);
	}

	@Override
	public double getMaxRenderDistanceSquared() {
		return base.superGetMaxRenderDistanceSquared();
	}

	@Override
	public Object getBlockType() {
		return base.superGetBlockType();
	}

	@Override
	public Object getDescriptionPacket() {
		return base.superGetDescriptionPacket();
	}

	@Override
	public boolean isInvalid() {
		return base.superIsInvalid();
	}

	@Override
	public void invalidate() {
		base.superInvalidate();
	}

	@Override
	public void validate() {
		base.superValidate();
	}

	@Override
	public boolean receiveClientEvent(int par1, int par2) {
		return base.superReceiveClientEvent(par1, par2);
	}

	@Override
	public void updateContainingBlockInfo() {
		base.superUpdateContainingBlockInfo();
	}

	@Override
	public void func_85027_a(Object crashReportCategory) {
		base.superFunc_85027_a(crashReportCategory);
	}

	@Override
	public boolean canUpdate() {
		return base.superCanUpdate();
	}

	@Override
	public void onDataPacket(Object iNetworkManager, Object packet132TileEntityData) {
		base.superOnDataPacket(iNetworkManager, packet132TileEntityData);
	}

	@Override
	public void onChunkUnload() {
		base.superOnChunkUnload();
	}

	@Override
	public boolean shouldRefresh(int oldID, int newID, int oldMeta, int newMeta, Object world, int x, int y, int z) {
		return base.superShouldRefresh(oldID, newID, oldMeta, newMeta, world, x, y, z);
	}

	@Override
	public boolean shouldRenderInPass(int pass) {
		return base.superShouldRenderInPass(pass);
	}

	@Override
	public Object getRenderBoundingBox() {
		return base.superGetRenderBoundingBox();
	}

	@Override
	public void markDirty() {
		base.superMarkDirty();
	}

	@Override
	public void addInfoToCrashReport(Object crashReportCategory) {
		base.superAddInfoToCrashReport(crashReportCategory);
	}

	@Override
	public boolean shouldRefresh(Object block, Object block1, int oldMeta, int newMeta, Object world, int x, int y, int z) {
		return base.superShouldRefresh(block, block1, oldMeta, newMeta, world, x, y, z);
	}

	@Override
	public Object getPos() {
		return base.superGetPos();
	}

	@Override
	public void setPos(Object blockPos) {
		base.superSetPos(blockPos);
	}

	@Override
	public boolean shouldRefresh(Object world, Object blockPos, Object iBlockState, Object iBlockState1) {
		return base.superShouldRefresh(world, blockPos, iBlockState, iBlockState1);
	}

	@Override
	public boolean canRenderBreaking() {
		return base.superCanRenderBreaking();
	}

	@Override
	public Object getTileData() {
		return base.superGetTileData();
	}

	@Override
	public boolean restrictNBTCopy() {
		return base.superRestrictNBTCopy();
	}

	@Override
	public boolean onlyOpsCanSetNbt() {
		return base.superOnlyOpsCanSetNbt();
	}

	@Override
	public void onLoad() {
		base.superOnLoad();
	}

	@Override
	public boolean hasFastRenderer() {
		return base.superHasFastRenderer();
	}

	@Override
	public boolean hasCapability(Object capability, Object enumFacing) {
		return base.superHasCapability(capability, enumFacing);
	}

	@Override
	public Object getCapability(Object capability, Object enumFacing) {
		return base.superGetCapability(capability, enumFacing);
	}

	@Override
	public void deserializeNBT(Object nBTTagCompound) {
		base.superDeserializeNBT(nBTTagCompound);
	}

	@Override
	public Object serializeNBT() {
		return base.superSerializeNBT();
	}

	@Override
	public Object getUpdatePacket() {
		return base.superGetUpdatePacket();
	}

	@Override
	public Object getUpdateTag() {
		return base.superGetUpdateTag();
	}

}