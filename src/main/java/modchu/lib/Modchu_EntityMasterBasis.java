package modchu.lib;

import java.util.HashMap;
import java.util.UUID;

public class Modchu_EntityMasterBasis implements Modchu_IEntityMaster {
	public Modchu_IEntity base;
	public static HashMap<Integer, HashMap> debugDataWatcherEntityMap = new HashMap();
	public HashMap<Integer, Object> debugDataWatcherMap;
	public int tempIsRiding;
	public int checkUUIDCount = 2;

	public Modchu_EntityMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IEntity) map.get("base");
	}

	@Override
	public void init() {
	}

	@Override
	public Object getFreeVariable(String s) {
		return Modchu_EntityHelper.getInstance().getData(base, s);
	}

	@Override
	public void setFreeVariable(String s, Object o) {
		Modchu_EntityHelper.getInstance().setData(base, s, o);
	}

	@Override
	public String thisToString() {
		return getClass().getName() + "@" + Integer.toHexString(super.hashCode());
	}

	@Override
	public int getRidingEntityID() {
		// TODO
		Object o = base.getDataWatcherWatchableObject(16);
		return o instanceof Integer ? (Integer) o : 0;
	}

	@Override
	public int getTempIsRiding() {
		return tempIsRiding;
	}

	@Override
	public void setTempIsRiding(int i) {
		tempIsRiding = i;
	}

	@Override
	public void entityInit() {
		base.superEntityInit();
	}

	@Override
	public void readEntityFromNBT(Object nBTTagCompound) {
		base.superReadEntityFromNBT(nBTTagCompound);
	}

	@Override
	public void writeEntityToNBT(Object nBTTagCompound) {
		base.superWriteEntityToNBT(nBTTagCompound);
	}

	@Override
	public int getEntityId() {
		return base.superGetEntityId();
	}

	@Override
	public void setEntityId(int p_145769_1_) {
		base.superSetEntityId(p_145769_1_);
	}

	@Override
	public Object getDataManager() {
		return base.superGetDataManager();
	}

	@Override
	public void preparePlayerToSpawn() {
		base.superPreparePlayerToSpawn();
	}

	@Override
	public void setDead() {
		base.superSetDead();
	}

	@Override
	public void setSize(float p_70105_1_, float p_70105_2_) {
		base.superSetSize(p_70105_1_, p_70105_2_);
	}

	@Override
	public void setRotation(float p_70101_1_, float p_70101_2_) {
		base.superSetRotation(p_70101_1_, p_70101_2_);
	}

	@Override
	public void setPosition(double p_70107_1_, double p_70107_3_, double p_70107_5_) {
		base.superSetPosition(p_70107_1_, p_70107_3_, p_70107_5_);
	}

	@Override
	public void turn(float p_70082_1_, float p_70082_2_) {
		base.superTurn(p_70082_1_, p_70082_2_);
	}

	@Override
	public void onUpdate() {
		base.superOnUpdate();
	}

	@Override
	public void onEntityUpdate() {
		base.superOnEntityUpdate();
	}

	@Override
	public int getMaxInPortalTime() {
		return base.superGetMaxInPortalTime();
	}

	@Override
	public void setOnFireFromLava() {
		base.superSetOnFireFromLava();
	}

	@Override
	public void setFire(int p_70015_1_) {
		base.superSetFire(p_70015_1_);
	}

	@Override
	public void extinguish() {
		base.superExtinguish();
	}

	@Override
	public void outOfWorld() {
		base.superOutOfWorld();
	}

	@Override
	public boolean isOffsetPositionInLiquid(double p_70038_1_, double p_70038_3_, double p_70038_5_) {
		return base.superIsOffsetPositionInLiquid(p_70038_1_, p_70038_3_, p_70038_5_);
	}

	@Override
	public void move(Object moverType, double p_70091_1_, double p_70091_3_, double p_70091_5_) {
		base.superMove(moverType, p_70091_1_, p_70091_3_, p_70091_5_);
	}

	@Override
	public Object getSwimSound() {
		return base.superGetSwimSound();
	}

	@Override
	public void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Object block) {
		base.superFunc_145780_a(p_145780_1_, p_145780_2_, p_145780_3_, block);
	}

	@Override
	public void playSound(Object p_85030_1_, float p_85030_2_, float p_85030_3_) {
		base.superPlaySound(p_85030_1_, p_85030_2_, p_85030_3_);
	}

	@Override
	public boolean canTriggerWalking() {
		return base.superCanTriggerWalking();
	}

	@Override
	public void updateFallState(double p_70064_1_, boolean p_70064_3_) {
		base.superUpdateFallState(p_70064_1_, p_70064_3_);
	}

	@Override
	public Object getCollisionBoundingBox() {
		return base.superGetCollisionBoundingBox();
	}

	@Override
	public void dealFireDamage(int p_70081_1_) {
		base.superDealFireDamage(p_70081_1_);
	}

	@Override
	public void fall(float p_70069_1_) {
		base.superFall(p_70069_1_);
	}

	@Override
	public boolean isWet() {
		return base.superIsWet();
	}

	@Override
	public boolean isInWater() {
		return base.superIsInWater();
	}

	@Override
	public boolean handleWaterMovement() {
		return base.superHandleWaterMovement();
	}

	@Override
	public Object getSplashSound() {
		return base.superGetSplashSound();
	}

	@Override
	public boolean isInsideOfMaterial(Object material) {
		return base.superIsInsideOfMaterial(material);
	}

	@Override
	public float getEyeHeight() {
		return base.superGetEyeHeight();
	}

	@Override
	public boolean handleLavaMovement() {
		return base.superIsNotColliding();
	}

	@Override
	public void moveRelative(float p_70060_1_, float p_70060_2_, float p_70060_3_, float p_70060_4_) {
		base.superMoveRelative(p_70060_1_, p_70060_2_, p_70060_3_, p_70060_4_);
	}

	@Override
	public int getBrightnessForRender(float p_70070_1_) {
		return base.superGetBrightnessForRender(p_70070_1_);
	}

	@Override
	public float getBrightness(float p_70013_1_) {
		return base.superGetBrightness(p_70013_1_);
	}

	@Override
	public void setWorld(Object world) {
		base.superSetWorld(world);
	}

	@Override
	public void setPositionAndRotation(double p_70080_1_, double p_70080_3_, double p_70080_5_, float p_70080_7_, float p_70080_8_) {
		base.superSetPositionAndRotation(p_70080_1_, p_70080_3_, p_70080_5_, p_70080_7_, p_70080_8_);
	}

	@Override
	public void setLocationAndAngles(double p_70012_1_, double p_70012_3_, double p_70012_5_, float p_70012_7_, float p_70012_8_) {
		base.superSetLocationAndAngles(p_70012_1_, p_70012_3_, p_70012_5_, p_70012_7_, p_70012_8_);
	}

	@Override
	public float getDistanceToEntity(Object entity) {
		return base.superGetDistanceToEntity(entity);
	}

	@Override
	public double getDistanceSq(double p_70092_1_, double p_70092_3_, double p_70092_5_) {
		return base.superGetDistanceSq(p_70092_1_, p_70092_3_, p_70092_5_);
	}

	@Override
	public double getDistance(double p_70011_1_, double p_70011_3_, double p_70011_5_) {
		return base.superGetDistance(p_70011_1_, p_70011_3_, p_70011_5_);
	}

	@Override
	public double getDistanceSqToEntity(Object entity) {
		return base.superGetDistanceSqToEntity(entity);
	}

	@Override
	public void onCollideWithPlayer(Object entityPlayer) {
		base.superOnCollideWithPlayer(entityPlayer);
	}

	@Override
	public void applyEntityCollision(Object entity) {
		base.superApplyEntityCollision(entity);
	}

	@Override
	public void addVelocity(double p_70024_1_, double p_70024_3_, double p_70024_5_) {
		base.superAddVelocity(p_70024_1_, p_70024_3_, p_70024_5_);
	}

	@Override
	public void setBeenAttacked() {
		base.superSetBeenAttacked();
	}

	@Override
	public boolean attackEntityFrom(Object damageSource, float p_70097_2_) {
		return base.superAttackEntityFrom(damageSource, p_70097_2_);
	}

	@Override
	public boolean canBeCollidedWith() {
		return base.superCanBeCollidedWith();
	}

	@Override
	public boolean canBePushed() {
		return base.superCanBePushed();
	}

	@Override
	public boolean isInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
		return base.superIsInRangeToRender3d(p_145770_1_, p_145770_3_, p_145770_5_);
	}

	@Override
	public boolean isInRangeToRenderDist(double p_70112_1_) {
		return base.superIsInRangeToRenderDist(p_70112_1_);
	}

	@Override
	public boolean writeToNBTAtomically(Object nBTTagCompound) {
		return base.superWriteToNBTAtomically(nBTTagCompound);
	}

	@Override
	public boolean writeToNBTOptional(Object nBTTagCompound) {
		return base.superWriteToNBTOptional(nBTTagCompound);
	}

	@Override
	public Object writeToNBT(Object nBTTagCompound) {
		return base.superWriteToNBT(nBTTagCompound);
	}

	@Override
	public void readFromNBT(Object nBTTagCompound) {
		base.superReadFromNBT(nBTTagCompound);
	}

	@Override
	public boolean shouldSetPosAfterLoading() {
		return base.superShouldSetPosAfterLoading();
	}

	@Override
	public void onChunkLoad() {
		base.superOnChunkLoad();
	}

	@Override
	public Object newDoubleNBTList(double... p_70087_1_) {
		return base.superNewDoubleNBTList(p_70087_1_);
	}

	@Override
	public Object newFloatNBTList(float... p_70049_1_) {
		return base.superNewFloatNBTList(p_70049_1_);
	}

	@Override
	public Object dropItem(Object item, int p_145779_2_) {
		return base.superDropItem(item, p_145779_2_);
	}

	@Override
	public Object entityDropItem(Object itemStack, float p_70099_2_) {
		return base.superEntityDropItem(itemStack, p_70099_2_);
	}

	@Override
	public float getShadowSize() {
		return base.superGetShadowSize();
	}

	@Override
	public boolean isEntityAlive() {
		return base.superIsEntityAlive();
	}

	@Override
	public boolean isEntityInsideOpaqueBlock() {
		return base.superIsEntityInsideOpaqueBlock();
	}

	@Override
	public boolean processInitialInteract(Object entityPlayer) {
		return base.superProcessInitialInteract(entityPlayer);
	}

	@Override
	public Object getCollisionBox(Object entity) {
		return base.superGetCollisionBox(entity);
	}

	@Override
	public void updateRidden() {
		base.superUpdateRidden();
	}

	@Override
	public void updatePassenger() {
		base.superUpdatePassenger();
	}

	@Override
	public double getYOffset() {
		return base.superGetYOffset();
	}

	@Override
	public double getMountedYOffset() {
		return base.superGetMountedYOffset();
	}

	@Override
	public boolean startRiding(Object entity) {
		return base.superStartRiding(entity);
	}

	@Override
	public void setPositionAndRotationDirect(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {
		base.superSetPositionAndRotationDirect(p_70056_1_, p_70056_3_, p_70056_5_, p_70056_7_, p_70056_8_, p_70056_9_);
	}

	@Override
	public float getCollisionBorderSize() {
		return base.superGetCollisionBorderSize();
	}

	@Override
	public Object getLookVec() {
		return base.superGetLookVec();
	}

	@Override
	public void setPortal(Object bockPos) {
		base.superSetPortal(bockPos);
	}

	@Override
	public int getPortalCooldown() {
		return base.superGetPortalCooldown();
	}

	@Override
	public void setVelocity(double p_70016_1_, double p_70016_3_, double p_70016_5_) {
		base.superSetVelocity(p_70016_1_, p_70016_3_, p_70016_5_);
	}

	@Override
	public void handleStatusUpdate(byte p_70103_1_) {
		base.superHandleStatusUpdate(p_70103_1_);
	}

	@Override
	public void performHurtAnimation() {
		base.superPerformHurtAnimation();
	}

	@Override
	public Object[] getLastActiveItems() {
		return base.superGetLastActiveItems();
	}

	@Override
	public void setItemStackToSlot(int p_70062_1_, Object itemStack) {
		base.superSetItemStackToSlot(p_70062_1_, itemStack);
	}

	@Override
	public boolean isBurning() {
		return base.superIsBurning();
	}

	@Override
	public boolean isRiding() {
		return base.superIsRiding();
	}

	@Override
	public boolean isSneaking() {
		return base.superIsSneaking();
	}

	@Override
	public void setSneaking(boolean p_70095_1_) {
		base.superSetSneaking(p_70095_1_);
	}

	@Override
	public boolean isSprinting() {
		return base.superIsSprinting();
	}

	@Override
	public void setSprinting(boolean p_70031_1_) {
		base.superSetSprinting(p_70031_1_);
	}

	@Override
	public boolean isInvisible() {
		return base.superIsInvisible();
	}

	@Override
	public boolean isInvisibleToPlayer(Object entityPlayer) {
		return base.superIsInvisibleToPlayer(entityPlayer);
	}

	@Override
	public void setInvisible(boolean p_82142_1_) {
		base.superSetInvisible(p_82142_1_);
	}

	@Override
	public boolean isEating() {
		return base.superIsEating();
	}

	@Override
	public void setEating(boolean p_70019_1_) {
		base.superSetEating(p_70019_1_);
	}

	@Override
	public boolean getFlag(int p_70083_1_) {
		return base.superGetFlag(p_70083_1_);
	}

	@Override
	public void setFlag(int p_70052_1_, boolean p_70052_2_) {
		base.superSetFlag(p_70052_1_, p_70052_2_);
	}

	@Override
	public int getAir() {
		return base.superGetAir();
	}

	@Override
	public void setAir(int p_70050_1_) {
		base.superSetAir(p_70050_1_);
	}

	@Override
	public void onStruckByLightning(Object entityLightningBolt) {
		base.superOnStruckByLightning(entityLightningBolt);
	}

	@Override
	public void onKillEntity(Object entityLivingBase) {
		base.superOnKillEntity(entityLivingBase);
	}

	@Override
	public void setInWeb() {
		base.superSetInWeb();
	}

	@Override
	public String getName() {
		return base.superGetName();
	}

	@Override
	public Object[] getParts() {
		return base.superGetParts();
	}

	@Override
	public boolean isEntityEqual(Object entity) {
		return base.superIsEntityEqual(entity);
	}

	@Override
	public float getRotationYawHead() {
		return base.superGetRotationYawHead();
	}

	@Override
	public void setRotationYawHead(float p_70034_1_) {
		base.superSetRotationYawHead(p_70034_1_);
	}

	@Override
	public boolean canBeAttackedWithItem() {
		return base.superCanBeAttackedWithItem();
	}

	@Override
	public boolean hitByEntity(Object entity) {
		return base.superHitByEntity(entity);
	}

	@Override
	public boolean isEntityInvulnerable() {
		return base.superIsEntityInvulnerable();
	}

	@Override
	public void copyLocationAndAnglesFrom(Object entity) {
		base.superCopyLocationAndAnglesFrom(entity);
	}

	@Override
	public void copyDataFrom(Object entity, boolean p_82141_2_) {
		base.superCopyDataFrom(entity, p_82141_2_);
	}

	@Override
	public Object changeDimension(int p_71027_1_) {
		return base.superChangeDimension(p_71027_1_);
	}

	@Override
	public float func_145772_a(Object explosion, Object world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Object block) {
		return base.superFunc_145772_a(explosion, world, p_145772_3_, p_145772_4_, p_145772_5_, block);
	}

	@Override
	public boolean func_145774_a(Object explosion, Object world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Object block, float p_145774_7_) {
		return base.superFunc_145774_a(explosion, world, p_145774_3_, p_145774_4_, p_145774_5_, block, p_145774_7_);
	}

	@Override
	public int getMaxSafePointTries() {
		return base.superGetMaxSafePointTries();
	}

	@Override
	public Object getLastPortalVec() {
		return base.superGetLastPortalVec();
	}

	@Override
	public boolean doesEntityNotTriggerPressurePlate() {
		return base.superDoesEntityNotTriggerPressurePlate();
	}

	@Override
	public void addEntityCrashInfo(Object crashReportCategory) {
		base.superAddEntityCrashInfo(crashReportCategory);
	}

	@Override
	public boolean canRenderOnFire() {
		return base.superCanRenderOnFire();
	}

	@Override
	public UUID getUniqueID() {
		return base.superGetUniqueID();
	}

	@Override
	public boolean isPushedByWater() {
		return base.superIsPushedByWater();
	}

	@Override
	public void onDataWatcherUpdate(int p_145781_1_) {
		base.superOnDataWatcherUpdate(p_145781_1_);
	}

	@Override
	public Object getEntityData() {
		return base.superGetEntityData();
	}

	@Override
	public boolean shouldRiderSit() {
		return base.superShouldRiderSit();
	}

	@Override
	public Object getPickedResult(Object movingObjectPosition) {
		return base.superGetPickedResult(movingObjectPosition);
	}

	@Override
	public UUID getPersistentID() {
		return base.superGetPersistentID();
	}

	@Override
	public boolean shouldRenderInPass(int pass) {
		return base.superShouldRenderInPass(pass);
	}

	@Override
	public boolean isCreatureType(Object enumCreatureType, boolean forSpawnCount) {
		return base.superIsCreatureType(enumCreatureType, forSpawnCount);
	}

	@Override
	public String registerExtendedProperties(String identifier, Object iExtendedEntityProperties) {
		return base.superRegisterExtendedProperties(identifier, iExtendedEntityProperties);
	}

	@Override
	public Object getExtendedProperties(String identifier) {
		return base.superGetExtendedProperties(identifier);
	}

	@Override
	public boolean canRiderInteract() {
		return base.superCanRiderInteract();
	}

	@Override
	public boolean shouldDismountInWater(Object entity) {
		return base.superShouldDismountInWater(entity);
	}

	@Override
	public void doBlockCollisions() {
		base.superDoBlockCollisions();
	}

	@Override
	public void playStepSound(int par1, int par2, int par3, Object par4) {
		base.superPlayStepSound(par1, par2, par3, (Integer) par4);
	}

	@Override
	public boolean isInRangeToRender3d(Object vec3) {
		return base.superIsInRangeToRender3d(vec3);
	}

	@Override
	public Object dropItem(int par1, int par2) {
		return base.superDropItem(par1, par2);
	}

	@Override
	public Object dropItemWithOffset(int par1, int par2, float par3) {
		return base.superDropItemWithOffset(par1, par2, par3);
	}

	@Override
	public boolean pushOutOfBlocks(double par1, double par3, double par5) {
		return base.superPushOutOfBlocks(par1, par3, par5);
	}

	@Override
	public float getBlockExplosionResistance(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return base.superGetBlockExplosionResistance(explosion, world, par3, par4, par5, block);
	}

	@Override
	public boolean shouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, Object par6, float par7) {
		return base.superShouldExplodeBlock(explosion, world, par3, par4, par5, par6, par7);
	}

	@Override
	public String getTranslatedEntityName() {
		return base.superGetTranslatedEntityName();
	}
	// ~152
	@Override
	public boolean attackEntityFrom(Object damageSource, int par2) {
		return base.superAttackEntityFrom(damageSource, par2);
	}

	@Override
	public String getTexture() {
		return base.superGetTexture();
	}

	@Override
	public boolean addNotRiddenEntityID(Object nBTTagCompound) {
		return base.superAddNotRiddenEntityID(nBTTagCompound);
	}

	@Override
	public boolean addEntityID(Object nBTTagCompound) {
		return base.superAddEntityID(nBTTagCompound);
	}

	@Override
	public void unmountEntity(Object entity) {
		base.superUnmountEntity(entity);
	}

	@Override
	public void updateCloak() {
		base.superUpdateCloak();
	}

	@Override
	public float func_82146_a(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return base.superFunc_82146_a(explosion, world, par3, par4, par5, block);
	}

	@Override
	public boolean func_96091_a(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7) {
		return base.superFunc_96091_a(explosion, world, par3, par4, par5, par6, par7);
	}
	// 180~
	@Override
	public void onKillCommand() {
		base.superOnKillCommand();
	}

	@Override
	public void playStepSound(Object blockPos, Object block) {
		base.superPlayStepSound(blockPos, block);
	}

	@Override
	public boolean isSilent() {
		return base.superIsSilent();
	}

	@Override
	public void setSilent(boolean isSilent) {
		base.superSetSilent(isSilent);
	}

	@Override
	public void updateFallState(double p_180433_1_, boolean p_180433_3_, Object block, Object blockPos) {
		base.superUpdateFallState(p_180433_1_, p_180433_3_, block, blockPos);
	}

	@Override
	public void fall(float distance, float damageMultiplier) {
		base.superFall(distance, damageMultiplier);
	}

	@Override
	public void doWaterSplashEffect() {
		base.superDoWaterSplashEffect();
	}

	@Override
	public void spawnRunningParticles() {
		base.superSpawnRunningParticles();
	}

	@Override
	public void createRunningParticles() {
		base.superCreateRunningParticles();
	}

	@Override
	public boolean isInLava() {
		return base.superIsInLava();
	}

	@Override
	public void moveToBlockPosAndAngles(Object blockPos, float p_174828_2_, float p_174828_3_) {
		base.superMoveToBlockPosAndAngles(blockPos, p_174828_2_, p_174828_3_);
	}

	@Override
	public double getDistanceSq(Object blockPos) {
		return base.superGetDistanceSq(blockPos);
	}

	@Override
	public double getDistanceSqToCenter(Object blockPos) {
		return base.superGetDistanceSqToCenter(blockPos);
	}

	@Override
	public Object getLook(float p_70676_1_) {
		return base.superGetLook(p_70676_1_);
	}

	@Override
	public Object getPositionEyes(float p_174824_1_) {
		return base.superGetPositionEyes(p_174824_1_);
	}

	@Override
	public Object rayTrace(double p_174822_1_, float p_174822_3_) {
		return base.superRayTrace(p_174822_1_, p_174822_3_);
	}

	@Override
	public Object dropItemWithOffset(Object item, int size, float p_145778_3_) {
		return base.superDropItemWithOffset(item, size, p_145778_3_);
	}

	@Override
	public void setPositionAndRotationDirect(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
		base.superSetPositionAndRotationDirect(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_, p_180426_10_);
	}

	@Override
	public Object[] getInventory() {
		return base.superGetInventory();
	}

	@Override
	public boolean isEntityInvulnerable(Object damageSource) {
		return base.superIsEntityInvulnerable(damageSource);
	}

	@Override
	public void copyDataFromOld(Object entity) {
		base.superCopyDataFromOld(entity);
	}

	@Override
	public float getExplosionResistance(Object explosion, Object world, Object blockPos, Object iBlockState) {
		return base.superGetExplosionResistance(explosion, world, blockPos, iBlockState);
	}

	@Override
	public boolean canExplosionDestroyBlock(Object explosion, Object world, Object blockPos, Object iBlockState, float p_174816_5_) {
		return base.superVerifyExplosion(explosion, world, blockPos, iBlockState, p_174816_5_);
	}

	@Override
	public int getMaxFallHeight() {
		return base.superGetMaxFallHeight();
	}

	@Override
	public Object getDisplayName() {
		return base.superGetDisplayName();
	}

	@Override
	public boolean hasCustomName() {
		return base.superHasCustomName();
	}

	@Override
	public void setPositionAndUpdate(double x, double y, double z) {
		base.superSetPositionAndUpdate(x, y, z);
	}

	@Override
	public boolean getAlwaysRenderNameTagForRender() {
		return base.superGetAlwaysRenderNameTagForRender();
	}

	@Override
	public Object getHorizontalFacing() {
		return base.superGetHorizontalFacing();
	}

	@Override
	public Object getHoverEvent() {
		return base.superGetHoverEvent();
	}

	@Override
	public boolean isSpectatedByPlayer(Object entityPlayerMP) {
		return base.superIsSpectatedByPlayer(entityPlayerMP);
	}

	@Override
	public Object getEntityBoundingBox() {
		return base.superGetEntityBoundingBox();
	}

	@Override
	public void setEntityBoundingBox(Object axisAlignedBB) {
		base.superSetEntityBoundingBox(axisAlignedBB);
	}

	@Override
	public boolean isOutsideBorder() {
		return base.superIsOutsideBorder();
	}

	@Override
	public void setOutsideBorder(boolean p_174821_1_) {
		base.superSetOutsideBorder(p_174821_1_);
	}

	@Override
	public boolean replaceItemInInventory(int p_174820_1_, Object itemStack) {
		return base.superReplaceItemInInventory(p_174820_1_, itemStack);
	}

	@Override
	public void sendMessage(Object iChatComponent) {
		base.superSendMessage(iChatComponent);
	}

	@Override
	public boolean canUseCommand(int permLevel, String commandName) {
		return base.superCanUseCommand(permLevel, commandName);
	}

	@Override
	public Object getPosition() {
		return base.superGetPosition();
	}

	@Override
	public Object getPositionVector() {
		return base.superGetPositionVector();
	}

	@Override
	public Object getEntityWorld() {
		return base.superGetEntityWorld();
	}

	@Override
	public Object getCommandSenderEntity() {
		return base.superGetCommandSenderEntity();
	}

	@Override
	public boolean sendCommandFeedback() {
		return base.superSendCommandFeedback();
	}

	@Override
	public void setCommandStat(Object type, int amount) {
		base.superSetCommandStat(type, amount);
	}

	@Override
	public Object getCommandStats() {
		return base.superGetCommandStats();
	}

	@Override
	public void setCommandStats(Object entity) {
		base.superSetCommandStats(entity);
	}

	@Override
	public Object getNBTTagCompound() {
		return base.superGetNBTTagCompound();
	}

	@Override
	public void clientUpdateEntityNBT(Object nBTTagCompound) {
		base.superClientUpdateEntityNBT(nBTTagCompound);
	}

	@Override
	public boolean interactAt(Object entityPlayer, Object vec3) {
		return base.superInteractAt(entityPlayer, vec3);
	}

	@Override
	public boolean isImmuneToExplosions() {
		return base.superIsImmuneToExplosions();
	}

	@Override
	public void applyEnchantments(Object entityLivingBase, Object entity) {
		base.superApplyEnchantments(entityLivingBase, entity);
	}

	@Override
	public boolean processInitialInteract(Object entityPlayer, Object itemStack, Object enumHand) {
		return base.superProcessInitialInteract(entityPlayer, itemStack, enumHand);
	}

	@Override
	public Object getTags() {
		return base.superGetTags();
	}

	@Override
	public boolean addTag(String tag) {
		return base.superAddTag(tag);
	}

	@Override
	public boolean removeTag(String tag) {
		return base.superRemoveTag(tag);
	}

	@Override
	public void setDropItemsWhenDead(boolean p_184174_1_) {
		base.superSetDropItemsWhenDead(p_184174_1_);
	}

	@Override
	public void decrementTimeUntilPortal() {
		base.superDecrementTimeUntilPortal();
	}

	@Override
	public void resetPositionToBB() {
		base.superResetPositionToBB();
	}

	@Override
	public void updatePassenger(Object entity) {
		base.superUpdatePassenger(entity);
	}

	@Override
	public void applyOrientationToEntity(Object entity) {
		base.superApplyOrientationToEntity(entity);
	}

	@Override
	public boolean startRiding(Object entity, boolean force) {
		return base.superStartRiding(entity, force);
	}

	@Override
	public boolean canBeRidden(Object entity) {
		return base.superCanBeRidden(entity);
	}

	@Override
	public void removePassengers() {
		base.superRemovePassengers();
	}

	@Override
	public void dismountRidingEntity() {
		base.superDismountRidingEntity();
	}

	@Override
	public void addPassenger(Object entity) {
		base.superAddPassenger(entity);
	}

	@Override
	public void removePassenger(Object entity) {
		base.superRemovePassenger(entity);
	}

	@Override
	public boolean canFitPassenger(Object entity) {
		return base.superCanFitPassenger(entity);
	}

	@Override
	public Object getHeldEquipment() {
		return base.superGetHeldEquipment();
	}

	@Override
	public Object getArmorInventoryList() {
		return base.superGetArmorInventoryList();
	}

	@Override
	public Object getEquipmentAndArmor() {
		return base.superGetEquipmentAndArmor();
	}

	@Override
	public void setItemStackToSlot(Object entityEquipmentSlot, Object itemStack) {
		base.superSetItemStackToSlot(entityEquipmentSlot, itemStack);
	}

	@Override
	public boolean isBeingRidden() {
		return base.superIsBeingRidden();
	}

	@Override
	public boolean isGlowing() {
		return base.superIsGlowing();
	}

	@Override
	public void setGlowing(boolean p_184195_1_) {
		base.superSetGlowing(p_184195_1_);
	}

	@Override
	public Object getTeam() {
		return base.superGetTeam();
	}

	@Override
	public boolean isOnSameTeam(Object entity) {
		return base.superIsOnSameTeam(entity);
	}

	@Override
	public boolean isOnScoreboardTeam(Object team) {
		return base.superIsOnScoreboardTeam(team);
	}

	@Override
	public void setRenderYawOffset(float offset) {
		base.superSetRenderYawOffset(offset);
	}

	@Override
	public void setEntityInvulnerable(boolean isInvulnerable) {
		base.superSetEntityInvulnerable(isInvulnerable);
	}

	@Override
	public boolean isNonBoss() {
		return base.superIsNonBoss();
	}

	@Override
	public void setUniqueId(UUID uniqueIdIn) {
		base.superSetUniqueId(uniqueIdIn);
	}

	@Override
	public void notifyDataManagerChange(Object dataParameter) {
		base.superNotifyDataManagerChange(dataParameter);
	}

	@Override
	public Object getAdjustedHorizontalFacing() {
		return base.superGetAdjustedHorizontalFacing();
	}

	@Override
	public Object getRenderBoundingBox() {
		return base.superGetRenderBoundingBox();
	}

	@Override
	public Object getServer() {
		return base.superGetServer();
	}

	@Override
	public Object applyPlayerInteraction(Object entityPlayer, Object vec3d, Object itemStack, Object enumHand) {
		return base.superApplyPlayerInteraction(entityPlayer, vec3d, itemStack, enumHand);
	}

	@Override
	public boolean hasCapability(Object capability, Object enumFacing) {
		return base.superHasCapability(capability, enumFacing);
	}

	@Override
	public void deserializeNBT(Object nBTTagCompound) {
		base.superDeserializeNBT(nBTTagCompound);
	}

	@Override
	public Object serializeNBT() {
		return base.superSerializeNBT();
	}

	@Override
	public void addTrackingPlayer(Object entityPlayerMP) {
		base.superAddTrackingPlayer(entityPlayerMP);
	}

	@Override
	public void removeTrackingPlayer(Object entityPlayerMP) {
		base.superRemoveTrackingPlayer(entityPlayerMP);
	}

	@Override
	public float getRotatedYaw(Object rotation) {
		return base.superGetRotatedYaw(rotation);
	}

	@Override
	public float getMirroredYaw(Object mirror) {
		return base.superGetMirroredYaw(mirror);
	}

	@Override
	public boolean ignoreItemEntityData() {
		return base.superIgnoreItemEntityData();
	}

	@Override
	public boolean setPositionNonDirty() {
		return base.superSetPositionNonDirty();
	}

	@Override
	public Object getControllingPassenger() {
		return base.superGetControllingPassenger();
	}

	@Override
	public Object getPassengers() {
		return base.superGetPassengers();
	}

	@Override
	public boolean isPassenger(Object entity) {
		return base.superIsPassenger(entity);
	}

	@Override
	public Object getRecursivePassengers() {
		return base.superGetRecursivePassengers();
	}

	@Override
	public Object getLowestRidingEntity() {
		return base.superGetLowestRidingEntity();
	}

	@Override
	public boolean isRidingSameEntity(Object entity) {
		return base.superIsRidingSameEntity(entity);
	}

	@Override
	public boolean isRidingOrBeingRiddenBy(Object entity) {
		return base.superIsRidingOrBeingRiddenBy(entity);
	}

	@Override
	public boolean canPassengerSteer() {
		return base.superCanPassengerSteer();
	}

	@Override
	public Object getRidingEntity() {
		return base.superGetRidingEntity();
	}

	@Override
	public Object getPushReaction() {
		return base.superGetPushReaction();
	}

	@Override
	public Object getSoundCategory() {
		return base.superGetSoundCategory();
	}

	@Override
	public Object getCapability(Object capability, Object enumFacing) {
		return base.superGetCapability(capability, enumFacing);
	}

	@Override
	public Object getRecursivePassengersByType(Class entityClass) {
		return base.superGetRecursivePassengersByType(entityClass);
	}

	@Override
	public void setCurrentItemOrArmor(int p_70062_1_, Object itemStack) {
		base.superSetCurrentItemOrArmor(p_70062_1_, itemStack);
	}

	@Override
	public void setMaxHealth(Object floatOrInt) {
		base.supersetMaxHealth(floatOrInt);
	}

	@Override
	public void setCustomNameTag(String p_96094_1_) {
		base.superSetCustomNameTag(p_96094_1_);
	}

	@Override
	public String getCustomNameTag() {
		return base.superGetCustomNameTag();
	}

	@Override
	public void setAlwaysRenderNameTag(boolean p_174805_1_) {
		base.superSetAlwaysRenderNameTag(p_174805_1_);
	}

	@Override
	public boolean getAlwaysRenderNameTag() {
		return base.superGetAlwaysRenderNameTag();
	}

	@Override
	public Object getRidingEntity2() {
		return base.superGetRidingEntity();
	}

	@Override
	public boolean isRiding2() {
		return base.superIsRiding();
	}

	@Override
	public void dismountRidingEntity2() {
		base.superDismountRidingEntity();
	}

	@Override
	public void setRidingEntityID(int i) {
		base.setDataWatcherWatchableObject(16, i);
	}

	@Override
	public int getBrightnessForRender() {
		return base.superGetBrightnessForRender();
	}

	@Override
	public float getBrightness() {
		return base.superGetBrightness();
	}

	@Override
	public void awardKillScore(Object entity, int p_191956_2_, Object damageSource) {
		base.superAddToPlayerScore(entity, p_191956_2_, damageSource);
	}

	@Override
	public Object getTeleportDirection() {
		return base.superGetTeleportDirection();
	}

	@Override
	public String getCachedUniqueIdString() {
		return base.superGetCachedUniqueIdString();
	}

	@Override
	public void onInsideBlock(Object iBlockState) {
		base.superOnInsideBlock(iBlockState);
	}

	@Override
	public float playFlySound(float p_191954_1_) {
		return base.superPlayFlySound(p_191954_1_);
	}

	@Override
	public boolean makeFlySound() {
		return base.superMakeFlySound();
	}

	@Override
	public boolean hasNoGravity() {
		return base.superHasNoGravity();
	}

	@Override
	public void setNoGravity(boolean noGravity) {
		base.superSetNoGravity(noGravity);
	}

	@Override
	public boolean isOverWater() {
		return base.superIsOverWater();
	}

	@Override
	public Object getPitchYaw() {
		return base.superGetPitchYaw();
	}

	@Override
	public Object getForward() {
		return base.superGetForward();
	}

	@Override
	public boolean getIsInvulnerable() {
		return base.superGetIsInvulnerable();
	}

	@Override
	public boolean canTrample(Object world, Object block, Object blockPos, float fallDistance) {
		return base.superCanTrample(world, block, blockPos, fallDistance);
	}

	@Override
	public int getFireImmuneTicks() {
		return base.superGetFireImmuneTicks();
	}

}
