package modchu.lib.forge.mc190;

import java.util.HashMap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityOtherPlayerMP;
import modchu.lib.Modchu_Main;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldSettings.GameType;

public class Modchu_EntityOtherPlayerMP extends modchu.lib.forge.mc190_202.Modchu_EntityOtherPlayerMP implements Modchu_IEntityOtherPlayerMP {

	public Modchu_EntityOtherPlayerMP(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void entityDataManagerRegister(Class c, Class[] c1, int i, Object o) {
		DataParameter dataParameter = (DataParameter) Modchu_AS.get(Modchu_AS.newDataParameter, getClass(), c1, i);
		if (dataParameter != null) {
			dataWatcher.register(dataParameter, o);
			String key= c.getName() + i;
			dataParameterMap.put(key, dataParameter);
		} else {
			String ss = "Modchu_EntityOtherPlayerMP entityDataManagerRegister dataParameter == null error !! c="+c+" c1="+c1+" i="+i+" o="+o;
			Modchu_Debug.mDebug(ss);
			Modchu_Main.setRuntimeException(ss);
		}
	}

	@Override
	public Object getDataWatcherGetWatchableObject(int i) {
		String key= master.getClass().getName() + i;
		DataParameter dataParameter = dataParameterMap.get(key);
		return dataWatcher.get(dataParameter);
	}

	@Override
	public void setDataWatcherGetWatchableObject(int i, Object o) {
		String key= master.getClass().getName() + i;
		DataParameter dataParameter = dataParameterMap.get(key);
		dataWatcher.set(dataParameter, o);
	}

	@Override
	public void setPositionAndRotation2(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
		if (master != null) master.setPositionAndRotationDirect(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_, p_180426_10_);
		else super.setPositionAndRotation2(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_, p_180426_10_);
	}

	@Override
	public void superSetPositionAndRotationDirect(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
		super.setPositionAndRotation2(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_, p_180426_10_);
	}

	@Override
	public float getDigSpeed(IBlockState iBlockState) {
		return master != null ? master.getDigSpeed(iBlockState) : super.getDigSpeed(iBlockState);
	}

	@Override
	public float superGetDigSpeed(Object iBlockState) {
		return super.getDigSpeed((IBlockState) iBlockState);
	}

	@Override
	public EntityItem dropOneItem(boolean p_71040_1_) {
		return (EntityItem) (master != null ? master.dropItem(p_71040_1_) : super.dropOneItem(p_71040_1_));
	}

	@Override
	public Object superDropItem(boolean p_71040_1_) {
		return super.dropOneItem(p_71040_1_);
	}

	@Override
	public EntityItem dropPlayerItemWithRandomChoice(ItemStack itemStack, boolean unused) {
		return (EntityItem) (master != null ? master.dropItem(itemStack, unused) : super.dropPlayerItemWithRandomChoice(itemStack, unused));
	}

	@Override
	public EntityItem superDropItem(Object itemStack, boolean unused) {
		return super.dropPlayerItemWithRandomChoice((ItemStack) itemStack, unused);
	}

	@Override
	public ItemStack dropItemAndGetStack(EntityItem entityItem) {
		return (ItemStack) (master != null ? master.dropItemAndGetStack(entityItem) : super.dropItemAndGetStack(entityItem));
	}

	@Override
	public Object superDropItemAndGetStack(Object entityItem) {
		return super.dropItemAndGetStack((EntityItem) entityItem);
	}

	@Override
	public EnumStatus trySleep(BlockPos blockPos) {
		return (EnumStatus) (master != null ? master.trySleep(blockPos) : super.trySleep(blockPos));
	}

	@Override
	public EnumStatus superTrySleep(Object blockPos) {
		return super.trySleep((BlockPos) blockPos);
	}

	@Override
	protected void updateAITick() {
		if (master != null) master.handleJumpWater();
		else super.updateAITick();
	}

	@Override
	public void superHandleJumpWater() {
		super.updateAITick();
	}

	@Override
	public void moveFlying(float strafe, float forward, float friction) {
		if (master != null) master.moveRelative(strafe, forward, friction);
		else super.moveFlying(strafe, forward, friction);
	}

	@Override
	public void superMoveRelative(float strafe, float forward, float friction) {
		super.moveFlying(strafe, forward, friction);
	}

	@Override
	public void writeToNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.writeToNBT(nBTTagCompound);
		else super.writeToNBT(nBTTagCompound);
	}

	@Override
	public Object superWriteToNBT(Object nBTTagCompound) {
		super.writeToNBT((NBTTagCompound) nBTTagCompound);
		return nBTTagCompound;
	}

	@Override
	public boolean canAttackWithItem() {
		return master != null ? master.canBeAttackedWithItem() : super.canAttackWithItem();
	}

	@Override
	public boolean superCanBeAttackedWithItem() {
		return super.canAttackWithItem();
	}

	@Override
	public boolean teleportTo_(double x, double y, double z) {
		return master != null ? master.attemptTeleport(x, y, z) : super.teleportTo_(x, y, z);
	}

	@Override
	public boolean superAttemptTeleport(double x, double y, double z) {
		return super.teleportTo_(x, y, z);
	}

	@Override
	public void setBossVisibleTo(EntityPlayerMP entityPlayerMP) {
		if (master != null) master.addTrackingPlayer(entityPlayerMP);
		else super.setBossVisibleTo(entityPlayerMP);
	}

	@Override
	public void superAddTrackingPlayer(Object entityPlayerMP) {
		super.setBossVisibleTo((EntityPlayerMP) entityPlayerMP);
	}

	@Override
	public void setBossNonVisibleTo(EntityPlayerMP entityPlayerMP) {
		if (master != null) master.removeTrackingPlayer(entityPlayerMP);
		else super.setBossNonVisibleTo(entityPlayerMP);
	}

	@Override
	public void superRemoveTrackingPlayer(Object entityPlayerMP) {
		super.setBossNonVisibleTo((EntityPlayerMP) entityPlayerMP);
	}

	@Override
	public boolean func_184213_bq() {
		return master != null ? master.ignoreItemEntityData() : super.func_184213_bq();
	}

	@Override
	public boolean superIgnoreItemEntityData() {
		return super.func_184213_bq();
	}
	// 200~分離
	@Override
	public void onChunkLoad() {
		if (master != null) master.onChunkLoad();
		else super.onChunkLoad();
	}

	@Override
	public void superOnChunkLoad() {
		super.onChunkLoad();
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
