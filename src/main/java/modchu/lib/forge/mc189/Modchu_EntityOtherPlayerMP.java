package modchu.lib.forge.mc189;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modchu.lib.Modchu_IEntityOtherPlayerMP;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.CommandResultStats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.event.HoverEvent;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;

public class Modchu_EntityOtherPlayerMP extends modchu.lib.forge.mc180_189.Modchu_EntityOtherPlayerMP implements Modchu_IEntityOtherPlayerMP {

	public Modchu_EntityOtherPlayerMP(HashMap<String, Object> map) {
		super(map);
	}

	public boolean supercanCommandSenderUseCommand(int permLevel, String commandName) {
		return super.canCommandSenderUseCommand(permLevel, commandName);
	}

	@Override
	public boolean isWearing(EnumPlayerModelParts enumPlayerModelParts) {
		return master != null ? master.isWearing(enumPlayerModelParts) : super.isWearing(enumPlayerModelParts);
	}

	@Override
	public boolean superIsWearing(Object enumPlayerModelParts) {
		return super.isWearing((EnumPlayerModelParts) enumPlayerModelParts);
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
		if (master != null) master.addRandomDrop();
		else super.addRandomDrop();
	}

	@Override
	public void superAddRandomDrop() {
		super.addRandomDrop();
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
	protected float getJumpUpwardsMotion() {
		return master != null ? master.getJumpUpwardsMotion() : super.getJumpUpwardsMotion();
	}

	@Override
	public float superGetJumpUpwardsMotion() {
		return super.getJumpUpwardsMotion();
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
	public Vec3 func_181014_aG() {
		return (Vec3) (master != null ? master.getLastPortalVec() : super.func_181014_aG());
	}

	@Override
	public Object superGetLastPortalVec() {
		return super.func_181014_aG();
	}

	@Override
	public void onDataWatcherUpdate(int p_145781_1_) {
		if (master != null) master.onDataWatcherUpdate(p_145781_1_);
		else super.onDataWatcherUpdate(p_145781_1_);
	}

	@Override
	public void superOnDataWatcherUpdate(int p_145781_1_) {
		super.onDataWatcherUpdate(p_145781_1_);
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
	public void setPositionAndRotation2(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
		if (master != null) master.setPositionAndRotationDirect(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_, p_180426_10_);
		else super.setPositionAndRotation2(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_, p_180426_10_);
	}

	@Override
	public void superSetPositionAndRotationDirect(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
		super.setPositionAndRotation2(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_, p_180426_10_);
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

	@Override
	public Object superApplyPlayerInteraction(Object entityPlayer, Object vec3d, Object itemStack, Object enumHand) {
		return super.interactAt((EntityPlayer) entityPlayer, (Vec3) vec3d);
	}

	@Override
	public void superSetRenderYawOffset(float offset) {
		super.func_181013_g(offset);
	}

	@Override
	public Object superGetTeleportDirection() {
		return super.func_181012_aH();
	}

	@Override
	public void func_181013_g(float p_181013_1_) {
		if (master != null) master.setRenderYawOffset(p_181013_1_);
		else super.func_181013_g(p_181013_1_);
	}

	@Override
	public void superFunc_181013_g(float p_181013_1_) {
		super.func_181013_g(p_181013_1_);
	}

	@Override
	public boolean superFunc_146066_aG() {
		return super.canDropLoot();
	}

	@Override
	public void superFunc_152111_bt() {
		superSendEnterCombat();
	}

	@Override
	public void superFunc_152112_bu() {
		superSendEndCombat();
	}

	@Override
	public void superFunc_110302_j() {
		superSetupCustomSkin();
	}

	@Override
	public Object superFunc_110309_l() {
		return superGetTextureSkin();
	}

	@Override
	public Object superFunc_110310_o() {
		return superGetTextureCape();
	}

	@Override
	public Object superFunc_110148_a(Object attribute) {
		return superGetEntityAttribute(attribute);
	}

	@Override
	public void superPlayStepSound(int par1, int par2, int par3, int par4) {
	}

	@Override
	public Object superDropItem(int par1, int par2) {
		return null;
	}

	@Override
	public Object superDropItemWithOffset(int par1, int par2, float par3) {
		return null;
	}

	@Override
	public boolean superFunc_152123_o() {
		return superHasSkin();
	}

	@Override
	public boolean superFunc_152122_n() {
		return superHasPlayerInfo();
	}

	@Override
	public Object superFunc_181014_aG() {
		return superGetLastPortalVec();
	}

	@Override
	public Collection<IChatComponent> getPrefixes() {
		return master != null ? master.getPrefixes() : super.getPrefixes();
	}

	@Override
	public Collection<IChatComponent> superGetPrefixes() {
		return super.getPrefixes();
	}

	@Override
	public Collection<IChatComponent> getSuffixes() {
		return master != null ? master.getSuffixes() : super.getSuffixes();
	}

	@Override
	public Collection<IChatComponent> superGetSuffixes() {
		return super.getSuffixes();
	}

	@Override
	public EnumFacing func_181012_aH() {
		return (EnumFacing) (master != null ? master.getTeleportDirection() : super.func_181012_aH());
	}

	@Override
	public Object superFunc_181012_aH() {
		return superGetTeleportDirection();
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
	public void superSetAngles(float yaw, float pitch) {
		super.setAngles(yaw, pitch);
	}

	@Override
	public void superAddChatMessage(Object iTextComponent) {
		super.addChatMessage((IChatComponent) iTextComponent);
	}

	@Override
	public boolean superCanCommandSenderUseCommand(int permLevel, String commandName) {
		return super.canCommandSenderUseCommand(permLevel, commandName);
	}

	@Override
	public String superGetCachedUniqueIdString() {
		return null;
	}

	@Override
	public Map superGetActivePotionMap() {
		return null;
	}

	@Override
	public void superBlockUsingShield(Object entityLivingBase) {
	}

	@Override
	public Object superGetLastDamageSource() {
		return null;
	}

	@Override
	public boolean superHasItemInSlot(Object entityEquipmentSlot) {
		return false;
	}

	@Override
	public float superGetWaterSlowDown() {
		return 0.0F;
	}

	@Override
	public boolean superAttackable() {
		return false;
	}

	@Override
	public void superSetPartying(Object blockPos, boolean p_191987_2_) {
	}

	@Override
	public boolean superProcessInitialInteract(Object entityPlayer, Object enumHand) {
		return false;
	}

	@Override
	public Object superApplyPlayerInteraction(Object entityPlayer, Object vec3d, Object enumHand) {
		return null;
	}

	@Override
	public void superOnInsideBlock(Object iBlockState) {
	}

	@Override
	public float superPlayFlySound(float p_191954_1_) {
		return 0.0F;
	}

	@Override
	public boolean superMakeFlySound() {
		return false;
	}

	@Override
	public boolean superHasNoGravity() {
		return false;
	}

	@Override
	public void superSetNoGravity(boolean noGravity) {
	}

	@Override
	public boolean superIsOverWater() {
		return false;
	}

	@Override
	public Object superGetPitchYaw() {
		return null;
	}

	@Override
	public Object superGetForward() {
		return null;
	}

	@Override
	public boolean superGetIsInvulnerable() {
		return false;
	}

	@Override
	public boolean superCanTrample(Object world, Object block, Object blockPos, float fallDistance) {
		return false;
	}

	@Override
	public int superGetFireImmuneTicks() {
		return -1;
	}

	@Override
	public void superDestroyVanishingCursedItems() {
	}

	@Override
	public void superOpenEditStructure(Object tileEntityStructure) {
	}

	@Override
	public void superDisableShield(boolean p_190777_1_) {
	}

	@Override
	public void superUnlockRecipes(List p_192021_1_) {
	}

	@Override
	public void superUnlockRecipes(Object[] resourceLocation) {
	}

	@Override
	public void superFunc_192022_b(List p_192022_1_) {
	}

	@Override
	public boolean superAddItemStackToInventory(Object itemStack) {
		return false;
	}

	@Override
	public boolean superAddShoulderEntity(Object nBTTagCompound) {
		return false;
	}

	@Override
	public void superSpawnShoulderEntities() {
	}

	@Override
	public Object superGetLeftShoulderEntity() {
		return null;
	}

	@Override
	public void superSetLeftShoulderEntity(Object nBTTagCompound) {
	}

	@Override
	public Object superGetRightShoulderEntity() {
		return null;
	}

	@Override
	public void superSetRightShoulderEntity(Object nBTTagCompound) {
	}

	@Override
	public boolean superCanUseCommandBlock() {
		return false;
	}

	@Override
	public boolean superHasSpawnDimension() {
		return false;
	}

	@Override
	public int superGetSpawnDimension() {
		return -1;
	}

	@Override
	public void superSetSpawnDimension(Object integer) {
	}

}
