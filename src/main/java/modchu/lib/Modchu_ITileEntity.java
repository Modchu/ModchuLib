package modchu.lib;

public interface Modchu_ITileEntity {
	public Object superGetWorld();
	public void superSetWorldObj(Object world);
	public boolean superHasWorldObj();
	public void superReadFromNBT(Object nBTTagCompound);
	public Object superWriteToNBT(Object nBTTagCompound);
	public void superUpdateEntity();
	public int superGetBlockMetadata();
	public void superOnInventoryChanged();
	public double superGetDistanceSq(double par1, double par3, double par5);
	public double superGetMaxRenderDistanceSquared();
	public Object superGetBlockType();
	public Object superGetDescriptionPacket();
	public boolean superIsInvalid();
	public void superInvalidate();
	public void superValidate();
	public boolean superReceiveClientEvent(int par1, int par2);
	public void superUpdateContainingBlockInfo();
	public void superFunc_85027_a(Object crashReportCategory);
	public boolean superCanUpdate();
	public void superOnDataPacket(Object iNetworkManager, Object packet132TileEntityData);
	public void superOnChunkUnload();
	public boolean superShouldRefresh(int oldID, int newID, int oldMeta, int newMeta, Object world, int x, int y, int z);
	public boolean superShouldRenderInPass(int pass);
	public Object superGetRenderBoundingBox();
	// 172~
	public void superMarkDirty();
	public void superAddInfoToCrashReport(Object crashReportCategory);
	public boolean superShouldRefresh(Object block, Object block1, int oldMeta, int newMeta, Object world, int x, int y, int z);
	// 180~
	public Object superGetPos();
	public void superSetPos(Object blockPos);
	public boolean superShouldRefresh(Object world, Object blockPos, Object iBlockState, Object iBlockState1);
	public boolean superCanRenderBreaking();
	public Object superGetTileData();
	public boolean superRestrictNBTCopy();
	// 190~
	public boolean superOnlyOpsCanSetNbt();
	public void superOnLoad();
	public boolean superHasFastRenderer();
	public boolean superHasCapability(Object capability, Object enumFacing);
	public Object superGetCapability(Object capability, Object enumFacing);
	public void superDeserializeNBT(Object nBTTagCompound);
	public Object superSerializeNBT();
	// 194~
	public Object superGetUpdatePacket();
	public Object superGetUpdateTag();

}