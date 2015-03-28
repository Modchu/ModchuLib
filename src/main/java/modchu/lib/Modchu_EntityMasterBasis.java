package modchu.lib;

import java.util.HashMap;
import java.util.UUID;

public class Modchu_EntityMasterBasis implements Modchu_IEntityMaster {
	public Modchu_IEntity base;

	public Modchu_EntityMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IEntity) map.get("base");
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
	public Object getDataWatcher() {
		return base.superGetDataWatcher();
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
	public void setAngles(float p_70082_1_, float p_70082_2_) {
		base.superSetAngles(p_70082_1_, p_70082_2_);
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
	public void kill() {
		base.superKill();
	}

	@Override
	public boolean isOffsetPositionInLiquid(double p_70038_1_, double p_70038_3_, double p_70038_5_) {
		return base.superIsOffsetPositionInLiquid(p_70038_1_, p_70038_3_, p_70038_5_);
	}

	@Override
	public void moveEntity(double p_70091_1_, double p_70091_3_, double p_70091_5_) {
		base.superMoveEntity(p_70091_1_, p_70091_3_, p_70091_5_);
	}

	@Override
	public String getSwimSound() {
		return base.superGetSwimSound();
	}

	@Override
	public void func_145775_I() {
		base.superFunc_145775_I();
	}

	@Override
	public void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Object block) {
		base.superFunc_145780_a(p_145780_1_, p_145780_2_, p_145780_3_, block);
	}

	@Override
	public void playSound(String p_85030_1_, float p_85030_2_, float p_85030_3_) {
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
	public Object getBoundingBox() {
		return base.superGetBoundingBox();
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
	public String getSplashSound() {
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
		return base.superHandleLavaMovement();
	}

	@Override
	public void moveFlying(float p_70060_1_, float p_70060_2_, float p_70060_3_) {
		base.superMoveFlying(p_70060_1_, p_70060_2_, p_70060_3_);
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
	public void addToPlayerScore(Object entity, int p_70084_2_) {
		base.superAddToPlayerScore(entity, p_70084_2_);
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
	public boolean writeMountToNBT(Object nBTTagCompound) {
		return base.superWriteMountToNBT(nBTTagCompound);
	}

	@Override
	public boolean writeToNBTOptional(Object nBTTagCompound) {
		return base.superWriteToNBTOptional(nBTTagCompound);
	}

	@Override
	public void writeToNBT(Object nBTTagCompound) {
		base.superWriteToNBT(nBTTagCompound);
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
	public Object func_145778_a(Object item, int p_145778_2_, float p_145778_3_) {
		return base.superFunc_145778_a(item, p_145778_2_, p_145778_3_);
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
	public boolean interactFirst(Object entityPlayer) {
		return base.superInteractFirst(entityPlayer);
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
	public void updateRiderPosition() {
		base.superUpdateRiderPosition();
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
	public void mountEntity(Object entity) {
		base.superMountEntity(entity);
	}

	@Override
	public void setPositionAndRotation2(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {
		base.superSetPositionAndRotation2(p_70056_1_, p_70056_3_, p_70056_5_, p_70056_7_, p_70056_8_, p_70056_9_);
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
	public void setInPortal() {
		base.superSetInPortal();
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
	public void handleHealthUpdate(byte p_70103_1_) {
		base.superHandleHealthUpdate(p_70103_1_);
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
	public void setCurrentItemOrArmor(int p_70062_1_, Object itemStack) {
		base.superSetCurrentItemOrArmor(p_70062_1_, itemStack);
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
	public boolean func_145771_j(double p_145771_1_, double p_145771_3_, double p_145771_5_) {
		return base.superFunc_145771_j(p_145771_1_, p_145771_3_, p_145771_5_);
	}

	@Override
	public void setInWeb() {
		base.superSetInWeb();
	}

	@Override
	public String getCommandSenderName() {
		return base.superGetCommandSenderName();
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
	public boolean canAttackWithItem() {
		return base.superCanAttackWithItem();
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
	public void travelToDimension(int p_71027_1_) {
		base.superTravelToDimension(p_71027_1_);
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
	public int getTeleportDirection() {
		return base.superGetTeleportDirection();
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
	public Object func_145748_c_() {
		return base.superFunc_145748_c_();
	}

	@Override
	public void func_145781_i(int p_145781_1_) {
		base.superFunc_145781_i(p_145781_1_);
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

}
