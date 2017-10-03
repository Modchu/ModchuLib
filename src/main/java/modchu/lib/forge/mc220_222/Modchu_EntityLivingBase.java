package modchu.lib.forge.mc220_222;

import java.util.HashMap;
import java.util.Map;

import modchu.lib.Modchu_IEntityLivingBase;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class Modchu_EntityLivingBase extends modchu.lib.forge.mc212_222.Modchu_EntityLivingBase implements Modchu_IEntityLivingBase {

	public Modchu_EntityLivingBase(World world) {
		super(world);
	}

	public Modchu_EntityLivingBase(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSource) {
		return (SoundEvent) (master != null ? master.getHurtSound(damageSource) : super.getHurtSound(damageSource));
	}

	@Override
	public Object superGetHurtSound(Object damageSource) {
		return super.getHurtSound((DamageSource) damageSource);
	}

	@Override
	public void travel(float par1, float par2, float par3) {
		if (master != null) master.travel(par1, par2, par3);
		else super.travel(par1, par2, par3);
	}

	@Override
	public void superTravel(float par1, float par2, float par3) {
		super.travel(par1, par2, par3);
	}

	@Override
	public int superGetBrightnessForRender(float par1) {
		return super.getBrightnessForRender();
	}

	@Override
	public int getBrightnessForRender() {
		return master != null ? master.getBrightnessForRender() : super.getBrightnessForRender();
	}

	@Override
	public int superGetBrightnessForRender() {
		return super.getBrightnessForRender();
	}

	@Override
	public float getBrightness() {
		return master != null ? master.getBrightness() : super.getBrightness();
	}

	@Override
	public float superGetBrightness() {
		return super.getBrightness();
	}

	@Override
	public float superGetBrightness(float p_70013_1_) {
		return super.getBrightness();
	}

	@Override
	public void awardKillScore(Entity entity, int p_191956_2_, DamageSource damageSource) {
		if (master != null) master.awardKillScore(entity, p_191956_2_, damageSource);
		else super.awardKillScore(entity, p_191956_2_, damageSource);
	}

	@Override
	public void superAddToPlayerScore(Object entity, int p_70084_2_, Object damageSource) {
		super.awardKillScore((Entity) entity, p_70084_2_, (DamageSource) damageSource);
	}

	@Override
	public void superAwardKillScore(Object entity, int p_70084_2_) {
		super.awardKillScore((Entity) entity, p_70084_2_, null);
	}

	@Override
	public void moveRelative(float p_70060_1_, float p_70060_2_, float p_70060_3_, float p_191958_4_) {
		if (master != null) master.moveRelative(p_70060_1_, p_70060_2_, p_70060_3_, p_191958_4_);
		else super.moveRelative(p_70060_1_, p_70060_2_, p_70060_3_, p_191958_4_);
	}

	@Override
	public void superMoveRelative(float p_70060_1_, float p_70060_2_, float p_70060_3_, float p_191958_4_) {
		super.moveRelative(p_70060_1_, p_70060_2_, p_70060_3_, p_191958_4_);
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
		super.sendEndCombat();
	}

	@Override
	public Object superFunc_181014_aG() {
		return superGetLastPortalVec();
	}

	@Override
	public void superSetAngles(float yaw, float pitch) {
		super.turn(yaw, pitch);
	}

	@Override
	public void superAddChatMessage(Object iTextComponent) {
		super.sendMessage((ITextComponent) iTextComponent);
	}

	@Override
	public boolean superCanCommandSenderUseCommand(int permLevel, String commandName) {
		return super.canUseCommand(permLevel, commandName);
	}

	@Override
	public EntityLivingBase getLastAttackedEntity() {
		return (EntityLivingBase) (master != null ? master.getLastAttackedEntity() : super.getLastAttackedEntity());
	}

	@Override
	public EntityLivingBase superGetLastAttackedEntity() {
		return super.getLastAttackedEntity();
	}

	@Override
	public int getLastAttackedEntityTime() {
		return master != null ? master.getLastAttackedEntityTime() : super.getLastAttackedEntityTime();
	}

	@Override
	public int superGetLastAttackedEntityTime() {
		return super.getLastAttackedEntityTime();
	}

	@Override
	public void setLastAttackedEntity(Entity entity) {
		if (master != null) master.setLastAttackedEntity(entity);
		else super.setLastAttackedEntity(entity);
	}

	@Override
	public void superSetLastAttackedEntity(Object entity) {
		super.setLastAttackedEntity((Entity) entity);
	}

	@Override
	public int getIdleTime() {
		return master != null ? master.getIdleTime() : super.getIdleTime();
	}

	@Override
	public int superGetIdleTime() {
		return super.getIdleTime();
	}

	@Override
	public EntityLivingBase getRevengeTarget() {
		return (EntityLivingBase) (master != null ? master.getRevengeTarget() : super.getRevengeTarget());
	}

	@Override
	public EntityLivingBase superGetRevengeTarget() {
		return super.getRevengeTarget();
	}

	@Override
	protected void outOfWorld() {
		if (master != null) master.outOfWorld();
		else super.outOfWorld();
	}

	@Override
	public void superOutOfWorld() {
		super.outOfWorld();
	}

	@Override
	protected void doWaterSplashEffect() {
		if (master != null) master.doWaterSplashEffect();
		else super.doWaterSplashEffect();
	}

	@Override
	public void superDoWaterSplashEffect() {
		super.doWaterSplashEffect();
	}

	@Override
	public boolean canExplosionDestroyBlock(Explosion explosion, World world, BlockPos blockPos, IBlockState iBlockState, float p_174816_5_) {
		return master != null ? master.canExplosionDestroyBlock(explosion, world, blockPos, iBlockState, p_174816_5_) : super.canExplosionDestroyBlock(explosion, world, blockPos, iBlockState, p_174816_5_);
	}

	@Override
	public boolean superVerifyExplosion(Object explosion, Object world, Object blockPos, Object iBlockState, float p_174816_5_) {
		return super.canExplosionDestroyBlock((Explosion) explosion, (World) world, (BlockPos) blockPos, (IBlockState) iBlockState, p_174816_5_);
	}

	@Override
	public void onInsideBlock(IBlockState iBlockState) {
		if (master != null) master.onInsideBlock(iBlockState);
		else super.onInsideBlock(iBlockState);
	}

	@Override
	public void superOnInsideBlock(Object iBlockState) {
		super.onInsideBlock((IBlockState) iBlockState);
	}

	public float func_191954_d(float p_191954_1_) {
		return master != null ? master.playFlySound(p_191954_1_) : super.playFlySound(p_191954_1_);
	}

	@Override
	public float superPlayFlySound(float p_191954_1_) {
		return super.playFlySound(p_191954_1_);
	}

	public boolean func_191957_ae() {
		return master != null ? master.makeFlySound() : super.makeFlySound();
	}

	@Override
	public boolean superMakeFlySound() {
		return super.makeFlySound();
	}

	public boolean hasNoGravity() {
		return master != null ? master.hasNoGravity() : super.hasNoGravity();
	}

	@Override
	public boolean superHasNoGravity() {
		return super.hasNoGravity();
	}

	public void setNoGravity(boolean noGravity) {
		if (master != null) master.setNoGravity(noGravity);
		else super.setNoGravity(noGravity);
	}

	@Override
	public void superSetNoGravity(boolean noGravity) {
		super.setNoGravity(noGravity);
	}

	public boolean func_191953_am() {
		return master != null ? master.isOverWater() : super.isOverWater();
	}

	@Override
	public boolean superIsOverWater() {
		return super.isOverWater();
	}

	public Vec2f getPitchYaw() {
		return (Vec2f) (master != null ? master.getPitchYaw() : super.getPitchYaw());
	}

	@Override
	public Vec2f superGetPitchYaw() {
		return super.getPitchYaw();
	}

	public Vec3d getForward() {
		return (Vec3d) (master != null ? master.getForward() : super.getForward());
	}

	@Override
	public Vec3d superGetForward() {
		return super.getForward();
	}

	public boolean getIsInvulnerable() {
		return master != null ? master.getIsInvulnerable() : super.getIsInvulnerable();
	}

	@Override
	public boolean superGetIsInvulnerable() {
		return super.getIsInvulnerable();
	}

	public String getCachedUniqueIdString() {
		return master != null ? master.getCachedUniqueIdString() : super.getCachedUniqueIdString();
	}

	@Override
	public String superGetCachedUniqueIdString() {
		return super.getCachedUniqueIdString();
	}

	public boolean canTrample(World world, Block block, BlockPos blockPos, float fallDistance) {
		return master != null ? master.canTrample(world, block, blockPos, fallDistance) : super.canTrample(world, block, blockPos, fallDistance);
	}

	@Override
	public boolean superCanTrample(Object world, Object block, Object blockPos, float fallDistance) {
		return super.canTrample((World) world, (Block) block, (BlockPos) blockPos, fallDistance);
	}

	public int getFireImmuneTicks() {
		return master != null ? master.getFireImmuneTicks() : super.getFireImmuneTicks();
	}

	@Override
	public int superGetFireImmuneTicks() {
		return super.getFireImmuneTicks();
	}

	@Override
	public Map<Potion, PotionEffect> getActivePotionMap() {
		return master != null ? master.getActivePotionMap() : super.getActivePotionMap();
	}

	@Override
	public Map<Potion, PotionEffect> superGetActivePotionMap() {
		return super.getActivePotionMap();
	}

	public void blockUsingShield(EntityLivingBase entityLivingBase) {
		if (master != null) master.blockUsingShield(entityLivingBase);
		else super.blockUsingShield(entityLivingBase);
	}

	@Override
	public void superBlockUsingShield(Object entityLivingBase) {
		super.blockUsingShield((EntityLivingBase) entityLivingBase);
	}

	public DamageSource getLastDamageSource() {
		return (DamageSource) (master != null ? master.getLastDamageSource() : super.getLastDamageSource());
	}

	@Override
	public DamageSource superGetLastDamageSource() {
		return super.getLastDamageSource();
	}

	public boolean hasItemInSlot(EntityEquipmentSlot entityEquipmentSlot) {
		return master != null ? master.hasItemInSlot(entityEquipmentSlot) : super.hasItemInSlot(entityEquipmentSlot);
	}

	@Override
	public boolean superHasItemInSlot(Object entityEquipmentSlot) {
		return super.hasItemInSlot((EntityEquipmentSlot) entityEquipmentSlot);
	}

	public float getWaterSlowDown() {
		return master != null ? master.getWaterSlowDown() : super.getWaterSlowDown();
	}

	@Override
	public float superGetWaterSlowDown() {
		return super.getWaterSlowDown();
	}

	public boolean attackable() {
		return master != null ? master.attackable() : super.attackable();
	}

	@Override
	public boolean superAttackable() {
		return super.attackable();
	}

	public void setPartying(BlockPos blockPos, boolean p_191987_2_) {
		if (master != null) master.setPartying(blockPos, p_191987_2_);
		else super.setPartying(blockPos, p_191987_2_);
	}

	@Override
	public void superSetPartying(Object blockPos, boolean p_191987_2_) {
		super.setPartying((BlockPos) blockPos, p_191987_2_);
	}

	public boolean processInitialInteract(EntityPlayer entityPlayer, EnumHand enumHand) {
		return master != null ? master.processInitialInteract(entityPlayer, enumHand) : super.processInitialInteract(entityPlayer, enumHand);
	}

	@Override
	public boolean superProcessInitialInteract(Object entityPlayer, Object enumHand) {
		return super.processInitialInteract((EntityPlayer) entityPlayer, (EnumHand) enumHand);
	}

	public EnumActionResult applyPlayerInteraction(EntityPlayer entityPlayer, Vec3d vec3d, EnumHand enumHand) {
		return (EnumActionResult) (master != null ? master.applyPlayerInteraction(entityPlayer, vec3d, enumHand) : super.applyPlayerInteraction(entityPlayer, vec3d, enumHand));
	}

	@Override
	public EnumActionResult superApplyPlayerInteraction(Object entityPlayer, Object vec3d, Object enumHand) {
		return super.applyPlayerInteraction((EntityPlayer) entityPlayer, (Vec3d) vec3d, (EnumHand) enumHand);
	}

}