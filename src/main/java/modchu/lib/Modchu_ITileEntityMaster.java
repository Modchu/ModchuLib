package modchu.lib;

public interface Modchu_ITileEntityMaster {
	public Object getWorld();
	public void setWorldObj(Object world);
	public boolean hasWorldObj();
	public void readFromNBT(Object nBTTagCompound);
	public void writeToNBT(Object nBTTagCompound);
	public void updateEntity();
	public int getBlockMetadata();
	public void onInventoryChanged();
	public double getDistanceSq(double par1, double par3, double par5);
	public double getMaxRenderDistanceSquared();
	public Object getBlockType();
	public Object getDescriptionPacket();
	public boolean isInvalid();
	public void invalidate();
	public void validate();
	public boolean receiveClientEvent(int par1, int par2);
	public void updateContainingBlockInfo();
	public void func_85027_a(Object crashReportCategory);
	public boolean canUpdate();
	public void onDataPacket(Object iNetworkManager, Object packet132TileEntityData);
	public void onChunkUnload();
	public boolean shouldRefresh(int oldID, int newID, int oldMeta, int newMeta, Object world, int x, int y, int z);
	public boolean shouldRenderInPass(int pass);
	public Object getRenderBoundingBox();
	// 172~
	public void markDirty();
	public void addInfoToCrashReport(Object crashReportCategory);
	public boolean shouldRefresh(Object block, Object block1, int oldMeta, int newMeta, Object world, int x, int y, int z);
	// 180~
	public Object getPos();
	public void setPos(Object blockPos);
	public boolean shouldRefresh(Object world, Object blockPos, Object iBlockState, Object iBlockState1);
	public boolean canRenderBreaking();
	public Object getTileData();
	public boolean restrictNBTCopy();
	// 190~
	public boolean func_183000_F();
	public void onLoad();
	public boolean hasFastRenderer();
	public boolean hasCapability(Object capability, Object enumFacing);
	public Object getCapability(Object capability, Object enumFacing);
	public void deserializeNBT(Object nBTTagCompound);
	public Object serializeNBT();

}
