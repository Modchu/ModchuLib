package modchu.lib.forge.mc194;

import java.util.HashMap;
import java.util.Map;

import modchu.lib.Modchu_IEntityDataManager;
import modchu.lib.Modchu_IEntityTameable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class Modchu_EntityTameable extends modchu.lib.forge.mc190_220.Modchu_EntityTameable implements Modchu_IEntityTameable {

	public Modchu_EntityTameable(World world) {
		super(world);
	}

	public Modchu_EntityTameable(HashMap<String, Object> map) {
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
	protected void handleJumpWater() {
		if (master != null) master.handleJumpWater();
		else super.handleJumpWater();
	}

	@Override
	public void superHandleJumpWater() {
		super.handleJumpWater();
	}

	@Override
	protected void onLeashDistance(float par1) {
		if (master != null) master.onLeashDistance(par1);
		else super.onLeashDistance(par1);
	}

	@Override
	public void superOnLeashDistance(float par1) {
		super.onLeashDistance(par1);
	}

	@Override
	public void moveRelative(float par1, float par2, float par3) {
		if (master != null) master.moveRelative(par1, par2, par3, 0.0F);
		else super.moveRelative(par1, par2, par3);
	}

	@Override
	public void superMoveRelative(float par1, float par2, float par3, float par4) {
		super.moveRelative(par1, par2, par3);
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
	public void ageUp(int p_175501_1_, boolean p_175501_2_) {
		if (master != null) master.ageUp(p_175501_1_, p_175501_2_);
		else super.ageUp(p_175501_1_, p_175501_2_);
	}

	@Override
	public void superAgeUp(int p_175501_1_, boolean p_175501_2_) {
		super.ageUp(p_175501_1_, p_175501_2_);
	}

	@Override
	protected boolean canEquipItem(ItemStack itemStack) {
		return master != null ? master.canEquipItem(itemStack) : super.canEquipItem(itemStack);
	}

	@Override
	public boolean superCanEquipItem(Object itemStack) {
		return super.canEquipItem((ItemStack) itemStack);
	}

	@Override
	public int getHorizontalFaceSpeed() {
		return master != null ? master.getHorizontalFaceSpeed() : super.getHorizontalFaceSpeed();
	}

	@Override
	public int superGetHorizontalFaceSpeed() {
		return super.getHorizontalFaceSpeed();
	}

	@Override
	public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean p_180426_10_) {
		if (master != null) master.setPositionAndRotationDirect(x, y, z, yaw, pitch, posRotationIncrements, p_180426_10_);
		else super.setPositionAndRotationDirect(x, y, z, yaw, pitch, posRotationIncrements, p_180426_10_);
	}

	@Override
	public void superSetPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean p_180426_10_) {
		super.setPositionAndRotationDirect(x, y, z, yaw, pitch, posRotationIncrements, p_180426_10_);
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

	@Override
	public void superSetPathToEntity(Object pathEntity) {
		getNavigator().setPath((Path) pathEntity, getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
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
	// 210~分離
	@Override
	public boolean processInteract(EntityPlayer entityPlayer, EnumHand enumHand, ItemStack itemStack) {
		return master != null ? master.processInteract(entityPlayer, enumHand, itemStack) : super.processInteract(entityPlayer, enumHand, itemStack);
	}

	@Override
	public boolean superProcessInteract(Object entityPlayer, Object enumHand, Object itemStack) {
		return super.processInteract((EntityPlayer) entityPlayer, (EnumHand) enumHand, (ItemStack) itemStack);
	}

	@Override
	public void moveEntity(double par1, double par3, double par5) {
		if (master != null) master.move(null, par1, par3, par5);
		else super.moveEntity(par1, par3, par5);
	}

	@Override
	public void superMove(Object moverType, double par1, double par3, double par5) {
		super.moveEntity(par1, par3, par5);
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
	public void setAngles(float par1, float par2) {
		if (master != null) master.turn(par1, par2);
		else super.setAngles(par1, par2);
	}

	@Override
	public void superTurn(float par1, float par2) {
		super.setAngles(par1, par2);
	}

	@Override
	protected PathNavigate getNewNavigator(World world) {
		return (PathNavigate) (master != null ? master.createNavigator(world) : super.getNewNavigator(world));
	}

	@Override
	public PathNavigate superCreateNavigator(Object world) {
		return super.getNewNavigator((World) world);
	}

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

	@Override
	public boolean superCanUseCommand(int permLevel, String commandName) {
		return super.canCommandSenderUseCommand(permLevel, commandName);
	}
	// 190~210共通コピペ　↑
	@Override
	protected SoundEvent getHurtSound() {
		return (SoundEvent) (master != null ? master.getHurtSound(null) : super.getHurtSound());
	}

	@Override
	public Object superGetHurtSound(Object damageSource) {
		return super.getHurtSound();
	}

	@Override
	public void moveEntityWithHeading(float par1, float par2) {
		if (master != null) master.travel(par1, par2, 0.0F);
		else super.moveEntityWithHeading(par1, par2);
	}

	@Override
	public void superTravel(float par1, float par2, float par3) {
		super.moveEntityWithHeading(par1, par2);
	}

	@Override
	public int getBrightnessForRender(float par1) {
		return master != null ? master.getBrightnessForRender(par1) : super.getBrightnessForRender(par1);
	}

	@Override
	public int superGetBrightnessForRender(float par1) {
		return super.getBrightnessForRender(par1);
	}

	@Override
	public float getBrightness(float par1) {
		return master != null ? master.getBrightness(par1) : super.getBrightness(par1);
	}

	@Override
	public float superGetBrightness(float par1) {
		return super.getBrightness(par1);
	}

	@Override
	public void addToPlayerScore(Entity entity, int par2) {
		if (master != null) master.awardKillScore(entity, par2, null);
		else super.addToPlayerScore(entity, par2);
	}

	@Override
	public void superAwardKillScore(Object entity, int par2) {
		super.addToPlayerScore((Entity) entity, par2);
	}

	@Override
	public EntityPlayer getPlayerInLove() {
		return (EntityPlayer) (master != null ? master.getLoveCause() : super.getPlayerInLove());
	}

	@Override
	public EntityPlayer superGetLoveCause() {
		return super.getPlayerInLove();
	}

	@Override
	public int superGetBrightnessForRender() {
		return -1;
	}

	@Override
	public float superGetBrightness() {
		return 0.0F;
	}

	@Override
	public void superAddToPlayerScore(Object entity, int p_70084_2_, Object damageSource) {
		superAwardKillScore(entity, p_70084_2_);
	}

	@Override
	public void superFunc_181013_g(float p_181013_1_) {
		superSetRenderYawOffset(p_181013_1_);
	}

	@Override
	public Object superFunc_181012_aH() {
		return superGetTeleportDirection();
	}

	@Override
	public boolean superFunc_146066_aG() {
		return superCanDropLoot();
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
	public Object superFunc_181014_aG() {
		return superGetLastPortalVec();
	}

	@Override
	public Object superFunc_110172_bL() {
		return null;
	}

	@Override
	public boolean superFunc_152114_e(Object entityLivingBase) {
		return super.isOwner((EntityLivingBase) entityLivingBase);
	}

	@Override
	public Object superFunc_146083_cb() {
		return superGetLoveCause();
	}

	@Override
	public Object superFunc_110142_aN() {
		return superGetCombatTracker();
	}

	@Override
	public void superFunc_175501_a(int p_175501_1_, boolean p_175501_2_) {
		superAgeUp(p_175501_1_, p_175501_2_);
	}

	@Override
	public Object superGetNewNavigator(Object world) {
		return super.getNewNavigator((World) world);
	}

	@Override
	public boolean superFunc_175448_a(Object itemStack) {
		return superCanEquipItem((ItemStack) itemStack);
	}

	@Override
	public String superGetCachedUniqueIdString() {
		return super.getCachedUniqueIdString();
	}

	@Override
	public String getCachedUniqueIdString() {
		return master != null ? master.getCachedUniqueIdString() : super.getCachedUniqueIdString();
	}

	@Override
	public void superSetAngles(float yaw, float pitch) {
		super.setAngles(yaw, pitch);
	}

	@Override
	public void superAddChatMessage(Object iTextComponent) {
		super.addChatMessage((ITextComponent) iTextComponent);
	}

	@Override
	public boolean superCanCommandSenderUseCommand(int permLevel, String commandName) {
		return super.canCommandSenderUseCommand(permLevel, commandName);
	}

	@Override
	public EntityLivingBase getAITarget() {
		return (EntityLivingBase) (master != null ? master.getRevengeTarget() : super.getAITarget());
	}

	@Override
	public EntityLivingBase superGetRevengeTarget() {
		return super.getAITarget();
	}

	@Override
	public EntityLivingBase getLastAttacker() {
		return (EntityLivingBase) (master != null ? master.getLastAttackedEntity() : super.getLastAttacker());
	}

	@Override
	public EntityLivingBase superGetLastAttackedEntity() {
		return super.getLastAttacker();
	}

	@Override
	public int getLastAttackerTime() {
		return master != null ? master.getLastAttackedEntityTime() : super.getLastAttackerTime();
	}

	@Override
	public int superGetLastAttackedEntityTime() {
		return super.getLastAttackerTime();
	}

	@Override
	public void setLastAttacker(Entity entity) {
		if (master != null) master.setLastAttackedEntity(entity);
		else super.setLastAttacker(entity);
	}

	@Override
	public void superSetLastAttackedEntity(Object entity) {
		super.setLastAttacker((Entity) entity);
	}

	@Override
	public int getAge() {
		return master != null ? master.getIdleTime() : super.getAge();
	}

	@Override
	public int superGetIdleTime() {
		return super.getAge();
	}

	@Override
	protected void kill() {
		if (master != null) master.outOfWorld();
		else super.kill();
	}

	@Override
	public void superOutOfWorld() {
		super.kill();
	}

	@Override
	protected void resetHeight() {
		if (master != null) master.doWaterSplashEffect();
		else super.resetHeight();
	}

	@Override
	public void superDoWaterSplashEffect() {
		super.resetHeight();
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
	public void superSetTamedBy(Object entityPlayer) {
	}

	@Override
	public boolean superHoldingSpawnEggOfClass(Object itemStack, Class p_190669_2_) {
		return false;
	}

	@Override
	public double superFollowLeashSpeed() {
		return 0.0D;
	}

	@Override
	public void superSetMoveForward(float p_191989_1_) {
	}

}
