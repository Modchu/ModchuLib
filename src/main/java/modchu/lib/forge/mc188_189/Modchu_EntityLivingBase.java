package modchu.lib.forge.mc188_189;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.CommandResultStats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.event.HoverEvent;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public abstract class Modchu_EntityLivingBase extends modchu.lib.forge.mc180_189.Modchu_EntityLivingBase {

	public Modchu_EntityLivingBase(World world) {
		super(world);
	}

	public Modchu_EntityLivingBase(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox() {
		return (AxisAlignedBB) (master != null ? master.getCollisionBoundingBox() : super.getCollisionBoundingBox());
	}

	@Override
	public AxisAlignedBB superGetCollisionBoundingBox() {
		return super.getCollisionBoundingBox();
	}

	@Override
	public void setPortal(BlockPos blockPos) {
		if (master != null) master.setPortal(blockPos);
		else super.setPortal(blockPos);
	}

	@Override
	public void superSetPortal(Object blockPos) {
		super.setPortal((BlockPos) blockPos);
	}

	@Override
	public void handleStatusUpdate(byte p_70103_1_) {
		if (master != null) master.handleStatusUpdate(p_70103_1_);
		else super.handleStatusUpdate(p_70103_1_);
	}

	@Override
	public void superHandleStatusUpdate(byte p_70103_1_) {
		super.handleStatusUpdate(p_70103_1_);
	}

	@Override
	protected void updateFallState(double p_180433_1_, boolean p_180433_3_, Block block, BlockPos blockPos) {
		if (master != null) master.updateFallState(p_180433_1_, p_180433_3_, block, blockPos);
		else super.updateFallState(p_180433_1_, p_180433_3_, block, blockPos);
	}

	@Override
	public void superUpdateFallState(double p_180433_1_, boolean p_180433_3_, Object block, Object blockPos) {
		super.updateFallState(p_180433_1_, p_180433_3_, (Block) block, (BlockPos) blockPos);
	}

	@Override
	public Object superApplyPlayerInteraction(Object entityPlayer, Object vec3d, Object itemStack, Object enumHand) {
		return super.interactAt((EntityPlayer) entityPlayer, (Vec3) vec3d);
	}

	@Override
	protected boolean canDropLoot() {
		return master != null ? master.canDropLoot() : super.canDropLoot();
	}

	@Override
	public boolean superCanDropLoot() {
		return super.canDropLoot();
	}

	@Override
	protected void updatePotionMetadata() {
		if (master != null) master.updatePotionMetadata();
		else super.updatePotionMetadata();
	}

	@Override
	public void superUpdatePotionMetadata() {
		super.updatePotionMetadata();
	}

	@Override
	protected void resetPotionEffectMetadata() {
		if (master != null) master.resetPotionEffectMetadata();
		else super.resetPotionEffectMetadata();
	}

	@Override
	public void superResetPotionEffectMetadata() {
		super.resetPotionEffectMetadata();
	}

	@Override
	protected void addRandomDrop() {
		if (master != null) master.dropLoot();
		else super.addRandomDrop();
	}

	@Override
	public void superDropLoot() {
		super.addRandomDrop();
	}

	@Override
	protected float getJumpUpwardsMotion() {
		return master != null ? master.getJumpUpwardsMotion() : super.getJumpUpwardsMotion();
	}

	@Override
	public float superGetJumpUpwardsMotion() {
		return super.getJumpUpwardsMotion();
	}

	@Override
	protected void handleJumpLava() {
		if (master != null) master.handleJumpLava();
		else super.handleJumpLava();
	}

	@Override
	public void superHandleJumpLava() {
		super.handleJumpLava();
	}

	@Override
	public void setPositionAndRotation2(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean p_180426_10_) {
		if (master != null) master.setPositionAndRotationDirect(x, y, z, yaw, pitch, posRotationIncrements, p_180426_10_);
		else super.setPositionAndRotation2(x, y, z, yaw, pitch, posRotationIncrements, p_180426_10_);
	}

	@Override
	public void superSetPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean p_180426_10_) {
		super.setPositionAndRotation2(x, y, z, yaw, pitch, posRotationIncrements, p_180426_10_);
	}

	@Override
	public void func_181013_g(float p_181013_1_) {
		if (master != null) master.setRenderYawOffset(p_181013_1_);
		else super.func_181013_g(p_181013_1_);
	}

	@Override
	public void superSetRenderYawOffset(float p_181013_1_) {
		super.func_181013_g(p_181013_1_);
	}

	@Override
	public void sendEnterCombat() {
		if (master != null) master.sendEnterCombat();
		else super.sendEnterCombat();
	}

	@Override
	public void superSendEnterCombat() {
		super.sendEnterCombat();
	}

	@Override
	public void sendEndCombat() {
		if (master != null) master.sendEndCombat();
		else super.sendEndCombat();
	}

	@Override
	public void superSendEndCombat() {
		super.sendEndCombat();
	}

	@Override
	protected void markPotionsDirty() {
		if (master != null) master.markPotionsDirty();
		else super.markPotionsDirty();
	}

	@Override
	public void superMarkPotionsDirty() {
		super.markPotionsDirty();
	}

	@Override
	public boolean verifyExplosion(Explosion explosion, World world, BlockPos blockPos, IBlockState iBlockState, float p_174816_5_) {
		return master != null ? master.canExplosionDestroyBlock(explosion, world, blockPos, iBlockState, p_174816_5_) : super.verifyExplosion(explosion, world, blockPos, iBlockState, p_174816_5_);
	}

	@Override
	public boolean superVerifyExplosion(Object explosion, Object world, Object blockPos, Object iBlockState, float p_174816_5_) {
		return super.verifyExplosion((Explosion) explosion, (World) world, (BlockPos) blockPos, (IBlockState) iBlockState, p_174816_5_);
	}

	@Override
	public EnumFacing func_181012_aH() {
		return (EnumFacing) (master != null ? master.getLastPortalVec() : super.func_181012_aH());
	}

	@Override
	public EnumFacing superGetLastPortalVec() {
		return super.func_181012_aH();
	}

	@Override
	public void onDataWatcherUpdate(int dataID) {
		if (master != null) master.onDataWatcherUpdate(dataID);
		else super.onDataWatcherUpdate(dataID);
	}

	@Override
	public void superOnDataWatcherUpdate(int dataID) {
		super.onDataWatcherUpdate(dataID);
	}

	@Override
	protected HoverEvent getHoverEvent() {
		return (HoverEvent) (master != null ? master.getHoverEvent() : super.getHoverEvent());
	}

	@Override
	public HoverEvent superGetHoverEvent() {
		return super.getHoverEvent();
	}

	@Override
	public boolean isSpectatedByPlayer(EntityPlayerMP entityPlayerMP) {
		return master != null ? master.isSpectatedByPlayer(entityPlayerMP) : super.isSpectatedByPlayer(entityPlayerMP);
	}

	@Override
	public boolean superIsSpectatedByPlayer(Object entityPlayerMP) {
		return super.isSpectatedByPlayer((EntityPlayerMP) entityPlayerMP);
	}

	@Override
	public boolean canCommandSenderUseCommand(int permLevel, String commandName) {
		return master != null ? master.canUseCommand(permLevel, commandName) : super.canCommandSenderUseCommand(permLevel, commandName);
	}

	@Override
	public boolean superCanUseCommand(int permLevel, String commandName) {
		return super.canCommandSenderUseCommand(permLevel, commandName);
	}

	@Override
	public CommandResultStats getCommandStats() {
		return (CommandResultStats) (master != null ? master.getCommandStats() : super.getCommandStats());
	}

	@Override
	public CommandResultStats superGetCommandStats() {
		return super.getCommandStats();
	}

	@Override
	public NBTTagCompound getNBTTagCompound() {
		return (NBTTagCompound) (master != null ? master.getNBTTagCompound() : super.getNBTTagCompound());
	}

	@Override
	public NBTTagCompound superGetNBTTagCompound() {
		return super.getNBTTagCompound();
	}

	@Override
	public void clientUpdateEntityNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.clientUpdateEntityNBT(nBTTagCompound);
		else super.clientUpdateEntityNBT(nBTTagCompound);
	}

	@Override
	public void superClientUpdateEntityNBT(Object nBTTagCompound) {
		super.clientUpdateEntityNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public boolean interactAt(EntityPlayer entityPlayer, Vec3 vec3) {
		return master != null ? master.interactAt(entityPlayer, vec3) : super.interactAt(entityPlayer, vec3);
	}

	@Override
	public boolean superInteractAt(Object entityPlayer, Object vec3) {
		return super.interactAt((EntityPlayer) entityPlayer, (Vec3) vec3);
	}

	@Override
	public boolean isImmuneToExplosions() {
		return master != null ? master.isImmuneToExplosions() : super.isImmuneToExplosions();
	}

	@Override
	public boolean superIsImmuneToExplosions() {
		return super.isImmuneToExplosions();
	}

	@Override
	protected void applyEnchantments(EntityLivingBase entityLivingBase, Entity entity) {
		if (master != null) master.applyEnchantments(entityLivingBase, entity);
		else super.applyEnchantments(entityLivingBase, entity);
	}

	@Override
	public void superApplyEnchantments(Object entityLivingBase, Object entity) {
		super.applyEnchantments((EntityLivingBase) entityLivingBase, (Entity) entity);
	}

}