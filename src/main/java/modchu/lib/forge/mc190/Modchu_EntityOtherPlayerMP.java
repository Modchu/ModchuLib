package modchu.lib.forge.mc190;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modchu.lib.Modchu_IEntityDataManager;
import modchu.lib.Modchu_IEntityOtherPlayerMP;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.Achievement;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings.GameType;

public class Modchu_EntityOtherPlayerMP extends modchu.lib.forge.mc190_220.Modchu_EntityOtherPlayerMP implements Modchu_IEntityOtherPlayerMP {

	public Modchu_EntityOtherPlayerMP(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void entityDataManagerRegister(Class[] c1, int i, Object o) {
		((Modchu_IEntityDataManager) dataWatcher).entityDataManagerRegister(c1, i, o);
	}

	@Override
	public Object getDataWatcherWatchableObject(int i) {
		return ((Modchu_IEntityDataManager) dataWatcher).getDataWatcherWatchableObject(i);
	}

	@Override
	public void setDataWatcherWatchableObject(int i, Object o) {
		((Modchu_IEntityDataManager) dataWatcher).setDataWatcherWatchableObject(i, o);
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
		if (master != null) master.moveRelative(strafe, forward, friction, 0.0F);
		else super.moveFlying(strafe, forward, friction);
	}

	@Override
	public void superMoveRelative(float strafe, float forward, float friction, float f3) {
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

	@Override
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
	@Override
	public void addToPlayerScore(Entity entity, int amount) {
		if (master != null) master.addToPlayerScore(entity, amount, null);
		else super.addToPlayerScore(entity, amount);
	}

	@Override
	public void superAddToPlayerScore(Object entity, int amount) {
		super.addToPlayerScore((Entity) entity, amount);
	}

	@Override
	protected SoundEvent getHurtSound() {
		return (SoundEvent) (master != null ? master.getHurtSound(null) : super.getHurtSound());
	}

	@Override
	public Object superGetHurtSound(Object damageSource) {
		return super.getHurtSound();
	}

	@Override
	public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_) {
		if (master != null) master.moveEntityWithHeading(p_70612_1_, p_70612_2_, 0.0F);
		else super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
	}

	@Override
	public void superMoveEntityWithHeading(float p_70612_1_, float p_70612_2_, float f2) {
		super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
	}

	@Override
	public void removeExperienceLevel(int levels) {
		if (master != null) master.onEnchant(null, levels);
		else super.removeExperienceLevel(levels);
	}

	@Override
	public void superOnEnchant(Object itemStack, int levels) {
		super.removeExperienceLevel(levels);
	}

	@Override
	public void clonePlayer(EntityPlayer entityPlayer, boolean respawnFromEnd) {
		if (master != null) master.clonePlayer(entityPlayer, respawnFromEnd);
		else super.clonePlayer(entityPlayer, respawnFromEnd);
	}

	@Override
	public void superClonePlayer(Object entityPlayer, boolean respawnFromEnd) {
		super.clonePlayer((EntityPlayer) entityPlayer, respawnFromEnd);
	}

	@Override
	public int getBrightnessForRender(float p_70070_1_) {
		return master != null ? master.getBrightnessForRender(p_70070_1_) : super.getBrightnessForRender(p_70070_1_);
	}

	@Override
	public int superGetBrightnessForRender(float p_70070_1_) {
		return super.getBrightnessForRender(p_70070_1_);
	}

	@Override
	public float getBrightness(float p_70013_1_) {
		return master != null ? master.getBrightness(p_70013_1_) : super.getBrightness(p_70013_1_);
	}

	@Override
	public float superGetBrightness(float p_70013_1_) {
		return super.getBrightness(p_70013_1_);
	}

	@Override
	public boolean hasAchievement(Achievement achievement) {
		return master != null ? master.hasAchievement(achievement) : super.hasAchievement(achievement);
	}

	@Override
	public boolean superHasAchievement(Object achievement) {
		return super.hasAchievement((Achievement) achievement);
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
		superAddToPlayerScore(entity, p_70084_2_);
	}

	@Override
	public String superGetCachedUniqueIdString() {
		return null;
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
	public String superFunc_146067_o(int p_146067_1_) {
		return null;
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
	public void superAddChatMessage(Object iTextComponent) {
		super.addChatMessage((ITextComponent) iTextComponent);
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
	public boolean superCanCommandSenderUseCommand(int permLevel, String commandName) {
		return super.canCommandSenderUseCommand(permLevel, commandName);
	}

	@Override
	public void superSetAngles(float yaw, float pitch) {
		super.setAngles(yaw, pitch);
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
	public void superFunc_191955_a(Object iBlockState) {
	}

	@Override
	public float superFunc_191954_d(float p_191954_1_) {
		return 0.0F;
	}

	@Override
	public boolean superFunc_191957_ae() {
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
	public boolean superFunc_191953_am() {
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
