package modchu.lib.forge.mc172_179;

import java.util.HashMap;
import modchu.lib.Modchu_ITileEntity;
import modchu.lib.Modchu_ITileEntityMaster;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import net.minecraft.block.Block;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class Modchu_TileEntity extends TileEntity implements Modchu_ITileEntity {
	public Modchu_ITileEntityMaster master;
	private String masterClassName;

	public Modchu_TileEntity() {
	}

	public Modchu_TileEntity(HashMap<String, Object> map) {
		init(map);
		//Modchu_Debug.mDebug("Modchu_TileEntity init master="+master);
	}

	private void init(String s) {
		Class c = s != null && !s.isEmpty() ? Modchu_Reflect.loadClass(s) : null;
		if (c != null); else return;
		HashMap<String, Object> map = Modchu_Main.getNewModchuCharacteristicMap(c);
		init(map);
	}

	private void init(HashMap<String, Object> map) {
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		master = instance instanceof Modchu_ITileEntityMaster ? (Modchu_ITileEntityMaster) instance : null;
		masterClassName = ((Class) map.get("Class")).getName();
	}

	@Override
	public World getWorldObj() {
		return (World) (master != null ? master.getWorld() : super.getWorldObj());
	}

	@Override
	public World superGetWorld() {
		return super.getWorldObj();
	}

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

	@Override
	public void readFromNBT(NBTTagCompound nBTTagCompound) {
		String s = nBTTagCompound.getString("masterClassName");
		init(s);
		if (master != null) master.readFromNBT(nBTTagCompound);
		else super.readFromNBT(nBTTagCompound);
	}

	@Override
	public void superReadFromNBT(Object nBTTagCompound) {
		super.readFromNBT((NBTTagCompound) nBTTagCompound);
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

	@Override
	public void updateEntity() {
		if (master != null) master.updateEntity();
		else super.updateEntity();
	}

	@Override
	public void superUpdateEntity() {
		super.updateEntity();
	}

	@Override
	public int getBlockMetadata() {
		return master != null ? master.getBlockMetadata() : super.getBlockMetadata();
	}

	@Override
	public int superGetBlockMetadata() {
		return super.getBlockMetadata();
	}

	@Override
	public double getDistanceFrom(double par1, double par3, double par5) {
		return master != null ? master.getDistanceSq(par1, par3, par5) : super.getDistanceFrom(par1, par3, par5);
	}

	@Override
	public double superGetDistanceSq(double par1, double par3, double par5) {
		return super.getDistanceFrom(par1, par3, par5);
	}

	@Override
	public double getMaxRenderDistanceSquared() {
		return master != null ? master.getMaxRenderDistanceSquared() : super.getMaxRenderDistanceSquared();
	}

	@Override
	public double superGetMaxRenderDistanceSquared() {
		return super.getMaxRenderDistanceSquared();
	}

	@Override
	public Block getBlockType() {
		return (Block) (master != null ? master.getBlockType() : super.getBlockType());
	}

	@Override
	public Block superGetBlockType() {
		return super.getBlockType();
	}

	@Override
	public boolean isInvalid() {
		return master != null ? master.isInvalid() : super.isInvalid();
	}

	@Override
	public boolean superIsInvalid() {
		return super.isInvalid();
	}

	@Override
	public void invalidate() {
		if (master != null) master.invalidate();
		else super.invalidate();
	}

	@Override
	public void superInvalidate() {
		super.invalidate();
	}

	@Override
	public void validate() {
		if (master != null) master.validate();
		else super.validate();
	}

	@Override
	public void superValidate() {
		super.validate();
	}

	@Override
	public boolean receiveClientEvent(int par1, int par2) {
		return master != null ? master.receiveClientEvent(par1, par2) : super.receiveClientEvent(par1, par2);
	}

	@Override
	public boolean superReceiveClientEvent(int par1, int par2) {
		return super.receiveClientEvent(par1, par2);
	}

	@Override
	public void updateContainingBlockInfo() {
		if (master != null) master.updateContainingBlockInfo();
		else super.updateContainingBlockInfo();
	}

	@Override
	public void superUpdateContainingBlockInfo() {
		super.updateContainingBlockInfo();
	}

	@Override
	public boolean canUpdate() {
		return master != null ? master.canUpdate() : super.canUpdate();
	}

	@Override
	public boolean superCanUpdate() {
		return super.canUpdate();
	}

	@Override
	public void onChunkUnload() {
		if (master != null) master.onChunkUnload();
		else super.onChunkUnload();
	}

	@Override
	public void superOnChunkUnload() {
		super.onChunkUnload();
	}

	@Override
	public boolean shouldRenderInPass(int pass) {
		return master != null ? master.shouldRenderInPass(pass) : super.shouldRenderInPass(pass);
	}

	@Override
	public boolean superShouldRenderInPass(int pass) {
		return super.shouldRenderInPass(pass);
	}

	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return (AxisAlignedBB) (master != null ? master.getRenderBoundingBox() : super.getRenderBoundingBox());
	}

	@Override
	public AxisAlignedBB superGetRenderBoundingBox() {
		return super.getRenderBoundingBox();
	}

	@Override
	public void markDirty() {
		if (master != null) master.markDirty();
		else super.markDirty();
	}

	@Override
	public void superMarkDirty() {
		super.markDirty();
	}

	@Override
	public Packet getDescriptionPacket() {
		return (Packet) (master != null ? master.getDescriptionPacket() : super.getDescriptionPacket());
	}

	@Override
	public Packet superGetDescriptionPacket() {
		return super.getDescriptionPacket();
	}

	@Override
	public void func_145828_a(CrashReportCategory crashReportCategory) {
		if (master != null) master.addInfoToCrashReport(crashReportCategory);
		else super.func_145828_a(crashReportCategory);
	}

	@Override
	public void superAddInfoToCrashReport(Object crashReportCategory) {
		super.func_145828_a((CrashReportCategory) crashReportCategory);
	}

	@Override
	public void onDataPacket(NetworkManager networkManager, S35PacketUpdateTileEntity s35PacketUpdateTileEntity) {
		if (master != null) master.onDataPacket(networkManager, s35PacketUpdateTileEntity);
		else super.onDataPacket(networkManager, s35PacketUpdateTileEntity);
	}

	@Override
	public void superOnDataPacket(Object networkManager, Object s35PacketUpdateTileEntity) {
		super.onDataPacket((NetworkManager) networkManager, (S35PacketUpdateTileEntity) s35PacketUpdateTileEntity);
	}

	@Override
	public boolean shouldRefresh(Block block, Block block1, int oldMeta, int newMeta, World world, int x, int y, int z) {
		return master != null ? master.shouldRefresh(block, block1, oldMeta, newMeta, world, x, y, z) : super.shouldRefresh(block, block1, oldMeta, newMeta, world, x, y, z);
	}
	// ~164
	@Override
	public boolean superShouldRefresh(Object block, Object block1, int oldMeta, int newMeta, Object world, int x, int y, int z) {
		return super.shouldRefresh((Block) block, (Block) block1, oldMeta, newMeta, (World) world, x, y, z);
	}

	@Override
	public void superOnInventoryChanged() {
	}

	@Override
	public void superFunc_85027_a(Object crashReportCategory) {
	}

	@Override
	public boolean superShouldRefresh(int oldID, int newID, int oldMeta, int newMeta, Object world, int x, int y, int z) {
		return false;
	}

	@Override
	public Object superGetPos() {
		return null;
	}

	@Override
	public void superSetPos(Object blockPos) {
	}

	@Override
	public boolean superShouldRefresh(Object world, Object blockPos, Object iBlockState, Object iBlockState1) {
		return false;
	}

	@Override
	public boolean superCanRenderBreaking() {
		return false;
	}

	@Override
	public Object superGetTileData() {
		return null;
	}

	@Override
	public boolean superRestrictNBTCopy() {
		return false;
	}
	// 190~
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
	public Object superSerializeNBT() {
		return null;
	}

	@Override
	public boolean superOnlyOpsCanSetNbt() {
		return false;
	}

	@Override
	public Object superGetUpdatePacket() {
		return null;
	}

	@Override
	public Object superGetUpdateTag() {
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
