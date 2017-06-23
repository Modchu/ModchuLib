package modchu.lib.forge.mc220;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
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

public class Modchu_EntityTameable extends modchu.lib.forge.mc212_220.Modchu_EntityTameable {

	public Modchu_EntityTameable(World world) {
		super(world);
	}

	public Modchu_EntityTameable(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public EntityPlayerMP func_191993_do() {
		return (EntityPlayerMP) (master != null ? master.getPlayerInLove() : super.func_191993_do());
	}

	@Override
	public EntityPlayerMP superGetPlayerInLove() {
		return super.func_191993_do();
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
	public int superGetBrightnessForRender(float p_70070_1_) {
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
	public void func_191956_a(Entity entity, int p_191956_2_, DamageSource damageSource) {
		if (master != null) master.addToPlayerScore(entity, p_191956_2_, damageSource);
		else super.func_191956_a(entity, p_191956_2_, damageSource);
	}

	@Override
	public void superAddToPlayerScore(Object entity, int p_70084_2_, Object damageSource) {
		super.func_191956_a((Entity) entity, p_70084_2_, (DamageSource) damageSource);
	}

	@Override
	public void superAddToPlayerScore(Object entity, int p_70084_2_) {
		super.func_191956_a((Entity) entity, p_70084_2_, null);
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
	public void superMoveEntityWithHeading(float par1, float par2, float par3) {
		super.func_191986_a(par1, par2, par3);
	}

	@Override
	public Object superFunc_110172_bL() {
		return superGetHomePosition();
	}

	@Override
	public boolean superFunc_152114_e(Object entityLivingBase) {
		return superIsOwner((EntityLivingBase) entityLivingBase);
	}

	@Override
	public Object superFunc_146083_cb() {
		return superGetPlayerInLove();
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
		return null;
	}

	@Override
	public boolean superFunc_175448_a(Object itemStack) {
		return superCanEquipItem((ItemStack) itemStack);
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
	public void superFunc_181013_g(float p_181013_1_) {
		superSetRenderYawOffset(p_181013_1_);
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
	public void func_191955_a(IBlockState iBlockState) {
		if (master != null) master.func_191955_a(iBlockState);
		else super.func_191955_a(iBlockState);
	}

	@Override
	public void superFunc_191955_a(Object iBlockState) {
		super.func_191955_a((IBlockState) iBlockState);
	}

	public float func_191954_d(float p_191954_1_) {
		return master != null ? master.func_191954_d(p_191954_1_) : super.func_191954_d(p_191954_1_);
	}

	@Override
	public float superFunc_191954_d(float p_191954_1_) {
		return super.func_191954_d(p_191954_1_);
	}

	public boolean func_191957_ae() {
		return master != null ? master.func_191957_ae() : super.func_191957_ae();
	}

	@Override
	public boolean superFunc_191957_ae() {
		return super.func_191957_ae();
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
		return master != null ? master.func_191953_am() : super.func_191953_am();
	}

	@Override
	public boolean superFunc_191953_am() {
		return super.func_191953_am();
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

	@Override
	public void setTamedBy(EntityPlayer entityPlayer) {
		if (master != null) master.setTamedBy(entityPlayer);
		else super.setTamedBy(entityPlayer);
	}

	@Override
	public void superSetTamedBy(Object entityPlayer) {
		super.setTamedBy((EntityPlayer) entityPlayer);
	}

	public boolean holdingSpawnEggOfClass(ItemStack itemStack, Class <? extends Entity > p_190669_2_) {
		return master != null ? master.holdingSpawnEggOfClass(itemStack, p_190669_2_) : super.holdingSpawnEggOfClass(itemStack, p_190669_2_);
	}

	@Override
	public boolean superHoldingSpawnEggOfClass(Object itemStack, Class p_190669_2_) {
		return super.holdingSpawnEggOfClass((ItemStack) itemStack, p_190669_2_);
	}

	public double followLeashSpeed() {
		return master != null ? master.followLeashSpeed() : super.followLeashSpeed();
	}

	@Override
	public double superFollowLeashSpeed() {
		return super.followLeashSpeed();
	}

	public void func_191989_p(float p_191989_1_) {
		if (master != null) master.func_191989_p(p_191989_1_);
		else super.func_191989_p(p_191989_1_);
	}

	@Override
	public void superFunc_191989_p(float p_191989_1_) {
		super.func_191989_p(p_191989_1_);
	}

	public SoundEvent getHurtSound(DamageSource damageSource) {
		return (SoundEvent) (master != null ? master.getHurtSound(damageSource) : super.getHurtSound(damageSource));
	}

	@Override
	public SoundEvent superGetHurtSound(Object damageSource) {
		return super.getHurtSound((DamageSource) damageSource);
	}

	public void func_191986_a(float p_191986_1_, float p_191986_2_, float p_191986_3_) {
		if (master != null) master.func_191986_a(p_191986_1_, p_191986_2_, p_191986_3_);
		else super.func_191986_a(p_191986_1_, p_191986_2_, p_191986_3_);
	}

	@Override
	public void superFunc_191986_a(float p_191986_1_, float p_191986_2_, float p_191986_3_) {
		super.func_191986_a(p_191986_1_, p_191986_2_, p_191986_3_);
	}

}
