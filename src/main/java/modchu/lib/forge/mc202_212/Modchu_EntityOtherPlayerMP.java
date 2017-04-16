package modchu.lib.forge.mc202_212;

import java.util.HashMap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityDataManager;
import modchu.lib.Modchu_IEntityOtherPlayerMP;
import modchu.lib.Modchu_Main;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameType;

public abstract class Modchu_EntityOtherPlayerMP extends modchu.lib.forge.mc190_212.Modchu_EntityOtherPlayerMP {

	public Modchu_EntityOtherPlayerMP(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void entityDataManagerRegister(Class[] c1, int i, Object o) {
		((Modchu_IEntityDataManager) dataManager).entityDataManagerRegister(c1, i, o);
	}

	@Override
	public Object getDataWatcherWatchableObject(int i) {
		return ((Modchu_IEntityDataManager) dataManager).getDataWatcherWatchableObject(i);
	}

	@Override
	public void setDataWatcherWatchableObject(int i, Object o) {
		((Modchu_IEntityDataManager) dataManager).setDataWatcherWatchableObject(i, o);
	}

	@Override
	public void setPositionAndRotationDirect(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
		if (master != null) master.setPositionAndRotationDirect(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_, p_180426_10_);
		else super.setPositionAndRotationDirect(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_, p_180426_10_);
	}

	@Override
	public void superSetPositionAndRotationDirect(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
		super.setPositionAndRotationDirect(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_, p_180426_10_);
	}

	@Override
	public float getDigSpeed(IBlockState iBlockState, BlockPos blockPos) {
		return master != null ? master.getDigSpeed(iBlockState, blockPos) : super.getDigSpeed(iBlockState, blockPos);
	}

	@Override
	public float superGetDigSpeed(Object iBlockState, Object blockPos) {
		return super.getDigSpeed((IBlockState) iBlockState, (BlockPos) blockPos);
	}

	@Override
	public EntityItem dropItem(boolean p_71040_1_) {
		return (EntityItem) (master != null ? master.dropItem(p_71040_1_) : super.dropItem(p_71040_1_));
	}

	@Override
	public EntityItem superDropItem(boolean p_71040_1_) {
		return super.dropItem(p_71040_1_);
	}

	@Override
	public EntityItem dropItem(ItemStack itemStack, boolean unused) {
		return (EntityItem) (master != null ? master.dropItem(itemStack, unused) : super.dropItem(itemStack, unused));
	}

	@Override
	public EntityItem superDropItem(Object itemStack, boolean unused) {
		return super.dropItem((ItemStack) itemStack, unused);
	}

	@Override
	public SleepResult trySleep(BlockPos blockPos) {
		return (SleepResult) (master != null ? master.trySleep(blockPos) : super.trySleep(blockPos));
	}

	@Override
	public SleepResult superTrySleep(Object blockPos) {
		return super.trySleep((BlockPos) blockPos);
	}

	@Override
	protected void handleJumpWater() {
		if (master != null) master.handleJumpWater();
		else super.handleJumpWater();
	}

	@Override
	public void superHandleJumpWater() {
		super.handleJumpWater();
	}

	@Override
	public void moveRelative(float strafe, float forward, float friction) {
		if (master != null) master.moveRelative(strafe, forward, friction);
		else super.moveRelative(strafe, forward, friction);
	}

	@Override
	public void superMoveRelative(float strafe, float forward, float friction) {
		super.moveRelative(strafe, forward, friction);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nBTTagCompound) {
		return (NBTTagCompound) (master != null ? master.writeToNBT(nBTTagCompound) : super.writeToNBT(nBTTagCompound));
	}

	@Override
	public Object superWriteToNBT(Object nBTTagCompound) {
		return super.writeToNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public boolean canBeAttackedWithItem() {
		return master != null ? master.canBeAttackedWithItem() : super.canBeAttackedWithItem();
	}

	@Override
	public boolean superCanBeAttackedWithItem() {
		return super.canBeAttackedWithItem();
	}

	@Override
	public boolean attemptTeleport(double x, double y, double z) {
		return master != null ? master.attemptTeleport(x, y, z) : super.attemptTeleport(x, y, z);
	}

	@Override
	public boolean superAttemptTeleport(double x, double y, double z) {
		return super.attemptTeleport(x, y, z);
	}

	@Override
	public void addTrackingPlayer(EntityPlayerMP entityPlayerMP) {
		if (master != null) master.addTrackingPlayer(entityPlayerMP);
		else super.addTrackingPlayer(entityPlayerMP);
	}

	@Override
	public void superAddTrackingPlayer(Object entityPlayerMP) {
		super.addTrackingPlayer((EntityPlayerMP) entityPlayerMP);
	}

	@Override
	public void removeTrackingPlayer(EntityPlayerMP entityPlayerMP) {
		if (master != null) master.removeTrackingPlayer(entityPlayerMP);
		else super.removeTrackingPlayer(entityPlayerMP);
	}

	@Override
	public void superRemoveTrackingPlayer(Object entityPlayerMP) {
		super.removeTrackingPlayer((EntityPlayerMP) entityPlayerMP);
	}

	@Override
	public boolean ignoreItemEntityData() {
		return master != null ? master.ignoreItemEntityData() : super.ignoreItemEntityData();
	}

	@Override
	public boolean superIgnoreItemEntityData() {
		return super.ignoreItemEntityData();
	}
	// 200~分離
	@Override
	public void superOnChunkLoad() {
	}

	@Override
	public void setGameType(GameType gameType) {
		if (master != null) master.setGameType(gameType);
		else super.setGameType(gameType);
	}

	@Override
	public void superSetGameType(Object gameType) {
		super.setGameType((GameType) gameType);
	}

}
