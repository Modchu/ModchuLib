package modchu.lib.forge.mc194;

import java.util.HashMap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityDataManager;
import modchu.lib.Modchu_IEntityOtherPlayerMP;
import modchu.lib.Modchu_Main;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.WorldSettings.GameType;

public class Modchu_EntityOtherPlayerMP extends modchu.lib.forge.mc190_212.Modchu_EntityOtherPlayerMP implements Modchu_IEntityOtherPlayerMP {

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
	// 210~分離
	@Override
	public void openGuiHorseInventory(EntityHorse entityHorse, IInventory iInventory) {
		if (master != null) master.openGuiHorseInventory(entityHorse, iInventory);
		else super.openGuiHorseInventory(entityHorse, iInventory);
	}

	@Override
	public EnumActionResult interact(Entity entity, ItemStack itemStack, EnumHand enumHand) {
		return (EnumActionResult) (master != null ? master.interactOn(entity, itemStack, enumHand) : super.interact(entity, itemStack, enumHand));
	}

	@Override
	public Object superInteractOn(Object entity, Object itemStack, Object enumHand) {
		return super.interact((Entity) entity, (ItemStack) itemStack, (EnumHand) enumHand);
	}

	@Override
	public void addChatComponentMessage(ITextComponent iTextComponent) {
		if (master != null) master.sendStatusMessage(iTextComponent, false);
		else super.addChatComponentMessage(iTextComponent);
	}

	@Override
	public void superSendStatusMessage(Object iTextComponent, boolean p_146105_2_) {
		super.addChatComponentMessage((ITextComponent) iTextComponent);
	}

	@Override
	public void moveEntity(double x, double y, double z) {
		if (master != null) master.move(null, x, y, z);
		else super.moveEntity(x, y, z);
	}

	@Override
	public void superMove(Object moverType, double x, double y, double z) {
		super.moveEntity(x, y, z);
	}

	@Override
	public boolean processInitialInteract(EntityPlayer entityPlayer, ItemStack itemStack, EnumHand enumHand) {
		return master != null ? master.processInitialInteract(entityPlayer, itemStack, enumHand) : super.processInitialInteract(entityPlayer, itemStack, enumHand);
	}

	@Override
	public boolean superProcessInitialInteract(Object entityPlayer, Object itemStack, Object enumHand) {
		return super.processInitialInteract((EntityPlayer) entityPlayer, (ItemStack) itemStack, (EnumHand) enumHand);
	}

	@Override
	public EnumActionResult applyPlayerInteraction(EntityPlayer entityPlayer, Vec3d vec3d, ItemStack itemStack, EnumHand enumHand) {
		return (EnumActionResult) (master != null ? master.applyPlayerInteraction(entityPlayer, vec3d, itemStack, enumHand) : super.applyPlayerInteraction(entityPlayer, vec3d, itemStack, enumHand));
	}

	@Override
	public EnumActionResult superApplyPlayerInteraction(Object entityPlayer, Object vec3d, Object itemStack, Object enumHand) {
		return super.applyPlayerInteraction((EntityPlayer) entityPlayer, (Vec3d) vec3d, (ItemStack) itemStack, (EnumHand) enumHand);
	}
	// 190~210共通コピペ　↓
	@Override
	public void addChatMessage(ITextComponent iTextComponent) {
		if (master != null) master.sendMessage(iTextComponent);
		else super.addChatMessage(iTextComponent);
	}

	@Override
	public void superSendMessage(Object iTextComponent) {
		super.addChatMessage((ITextComponent) iTextComponent);
	}

	@Override
	public boolean canCommandSenderUseCommand(int permLevel, String commandName) {
		return master != null ? master.canUseCommand(permLevel, commandName) : super.canCommandSenderUseCommand(permLevel, commandName);
	}

	public boolean superCanUseCommand(int permLevel, String commandName) {
		return super.canCommandSenderUseCommand(permLevel, commandName);
	}

	@Override
	public void setAngles(float yaw, float pitch) {
		if (master != null) master.turn(yaw, pitch);
		else super.setAngles(yaw, pitch);
	}

	@Override
	public void superTurn(float yaw, float pitch) {
		super.setAngles(yaw, pitch);
	}
	// 190~210共通コピペ　↑

}
