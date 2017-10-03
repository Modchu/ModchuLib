package modchu.lib.forge.mc220_222;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntityStructure;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class Modchu_EntityOtherPlayerMP extends modchu.lib.forge.mc212_222.Modchu_EntityOtherPlayerMP {

	public Modchu_EntityOtherPlayerMP(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void onEnchant(ItemStack itemStack, int levels) {
		if (master != null) master.onEnchant(itemStack, levels);
		else super.onEnchant(itemStack, levels);
	}

	@Override
	public void superOnEnchant(Object itemStack, int levels) {
		super.onEnchant((ItemStack) itemStack, levels);
	}

	@Override
	public void superClonePlayer(Object entityPlayer, boolean respawnFromEnd) {
	}

	@Override
	public boolean superHasAchievement(Object achievement) {
		return false;
	}

	@Override
	public void awardKillScore(Entity entity, int p_191956_2_, DamageSource damageSource) {
		if (master != null) master.awardKillScore(entity, p_191956_2_, damageSource);
		else super.awardKillScore(entity, p_191956_2_, damageSource);
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
	public void superFunc_110302_j() {

	}

	@Override
	public Object superFunc_110309_l() {
		return null;
	}

	@Override
	public Object superFunc_110310_o() {
		return null;
	}

	@Override
	public Object superFunc_110148_a(Object attribute) {
		return null;
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
		return false;
	}

	@Override
	public boolean superFunc_152122_n() {
		return false;
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

	@Override
	public void destroyVanishingCursedItems() {
		if (master != null) master.destroyVanishingCursedItems();
		else super.destroyVanishingCursedItems();
	}

	@Override
	public void superDestroyVanishingCursedItems() {
		super.destroyVanishingCursedItems();
	}

	public void openEditStructure(TileEntityStructure tileEntityStructure) {
		if (master != null) master.openEditStructure(tileEntityStructure);
		else super.openEditStructure(tileEntityStructure);
	}

	@Override
	public void superOpenEditStructure(Object tileEntityStructure) {
		super.openEditStructure((TileEntityStructure) tileEntityStructure);
	}

	public void disableShield(boolean p_190777_1_) {
		if (master != null) master.disableShield(p_190777_1_);
		else super.disableShield(p_190777_1_);
	}

	@Override
	public void superDisableShield(boolean p_190777_1_) {
		super.disableShield(p_190777_1_);
	}

	public void unlockRecipes(List<IRecipe> p_192021_1_) {
		if (master != null) master.unlockRecipes(p_192021_1_);
		else super.unlockRecipes(p_192021_1_);
	}

	@Override
	public void superUnlockRecipes(List p_192021_1_) {
		super.unlockRecipes((List) p_192021_1_);
	}

	public void unlockRecipes(ResourceLocation[] resourceLocation) {
		if (master != null) master.unlockRecipes(resourceLocation);
		else super.unlockRecipes(resourceLocation);
	}

	@Override
	public void superUnlockRecipes(Object[] resourceLocation) {
		super.unlockRecipes((ResourceLocation[]) resourceLocation);
	}

	public void func_192022_b(List<IRecipe> p_192022_1_) {
		if (master != null) master.func_192022_b(p_192022_1_);
		else super.resetRecipes(p_192022_1_);
	}

	@Override
	public void superFunc_192022_b(List p_192022_1_) {
		super.resetRecipes((List) p_192022_1_);
	}

	public boolean addItemStackToInventory(ItemStack itemStack) {
		return master != null ? master.addItemStackToInventory(itemStack) : super.addItemStackToInventory(itemStack);
	}

	@Override
	public boolean superAddItemStackToInventory(Object itemStack) {
		return super.addItemStackToInventory((ItemStack) itemStack);
	}

	public boolean addShoulderEntity(NBTTagCompound nBTTagCompound) {
		return master != null ? master.addShoulderEntity(nBTTagCompound) : super.addShoulderEntity(nBTTagCompound);
	}

	@Override
	public boolean superAddShoulderEntity(Object nBTTagCompound) {
		return super.addShoulderEntity((NBTTagCompound) nBTTagCompound);
	}

	public void spawnShoulderEntities() {
		if (master != null) master.spawnShoulderEntities();
		else super.spawnShoulderEntities();
	}

	@Override
	public void superSpawnShoulderEntities() {
		super.spawnShoulderEntities();
	}

	public NBTTagCompound getLeftShoulderEntity() {
		return (NBTTagCompound) (master != null ? master.getLeftShoulderEntity() : super.getLeftShoulderEntity());
	}

	@Override
	public NBTTagCompound superGetLeftShoulderEntity() {
		return super.getLeftShoulderEntity();
	}

	public void setLeftShoulderEntity(NBTTagCompound nBTTagCompound) {
		if (master != null) master.setLeftShoulderEntity(nBTTagCompound);
		else super.setLeftShoulderEntity(nBTTagCompound);
	}

	@Override
	public void superSetLeftShoulderEntity(Object nBTTagCompound) {
		super.setLeftShoulderEntity((NBTTagCompound) nBTTagCompound);
	}

	public NBTTagCompound getRightShoulderEntity() {
		return (NBTTagCompound) (master != null ? master.getRightShoulderEntity() : super.getRightShoulderEntity());
	}

	@Override
	public NBTTagCompound superGetRightShoulderEntity() {
		return super.getRightShoulderEntity();
	}

	public void setRightShoulderEntity(NBTTagCompound nBTTagCompound) {
		if (master != null) master.setRightShoulderEntity(nBTTagCompound);
		else super.setRightShoulderEntity(nBTTagCompound);
	}

	@Override
	public void superSetRightShoulderEntity(Object nBTTagCompound) {
		super.setRightShoulderEntity((NBTTagCompound) nBTTagCompound);
	}

	public boolean canUseCommandBlock() {
		return master != null ? master.canUseCommandBlock() : super.canUseCommandBlock();
	}

	@Override
	public boolean superCanUseCommandBlock() {
		return super.canUseCommandBlock();
	}

	public boolean hasSpawnDimension() {
		return master != null ? master.hasSpawnDimension() : super.hasSpawnDimension();
	}

	@Override
	public boolean superHasSpawnDimension() {
		return super.hasSpawnDimension();
	}

	public int getSpawnDimension() {
		return master != null ? master.getSpawnDimension() : super.getSpawnDimension();
	}

	@Override
	public int superGetSpawnDimension() {
		return super.getSpawnDimension();
	}

	public void setSpawnDimension(Integer integer) {
		if (master != null) master.setSpawnDimension(integer);
		else super.setSpawnDimension(integer);
	}

	@Override
	public void superSetSpawnDimension(Object integer) {
		super.setSpawnDimension((Integer) integer);
	}

}
