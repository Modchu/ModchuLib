package modchu.lib;

import java.util.UUID;

public interface Modchu_IEntityMaster {
	public Object getFreeVariable(String s);
	public void setFreeVariable(String s, Object o);
	public String thisToString();
	public void init();
	public void entityInit();
	public void readEntityFromNBT(Object nBTTagCompound);
	public void writeEntityToNBT(Object nBTTagCompound);
	public int getEntityId();
	public void setEntityId(int p_145769_1_);
	public Object getDataManager();
	public Object getRidingEntity2();
	public boolean isRiding2();
	public void dismountRidingEntity2();
	public int getRidingEntityID();
	public void setRidingEntityID(int i);
	public int getTempIsRiding();
	public void setTempIsRiding(int i);
	//public boolean equals(Object p_equals_1_);
	//public int hashCode();

	public void preparePlayerToSpawn();
	public void setDead();
	public void setSize(float p_70105_1_, float p_70105_2_);
	public void setRotation(float p_70101_1_, float p_70101_2_);
	public void setPosition(double p_70107_1_, double p_70107_3_, double p_70107_5_);
	public void turn(float p_70082_1_, float p_70082_2_);
	public void onUpdate();
	public void onEntityUpdate();
	public int getMaxInPortalTime();
	public void setOnFireFromLava();
	public void setFire(int p_70015_1_);
	public void extinguish();
	public void outOfWorld();
	public boolean isOffsetPositionInLiquid(double p_70038_1_, double p_70038_3_, double p_70038_5_);
	public void move(Object moverType, double p_70091_1_, double p_70091_3_, double p_70091_5_);
	public Object getSwimSound();
	public void doBlockCollisions();
	public void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Object block);
	public void playSound(Object soundEventOrString, float p_85030_2_, float p_85030_3_);
	public boolean canTriggerWalking();
	public void updateFallState(double p_70064_1_, boolean p_70064_3_);
	public Object getCollisionBoundingBox();
	public void dealFireDamage(int p_70081_1_);
	public void fall(float p_70069_1_);
	public boolean isWet();
	public boolean isInWater();
	public boolean handleWaterMovement();
	public Object getSplashSound();
	public boolean isInsideOfMaterial(Object material);
	public float getEyeHeight();
	public boolean handleLavaMovement();
	public int getBrightnessForRender(float p_70070_1_);
	public float getBrightness(float p_70013_1_);
	public void setWorld(Object world);
	public void setPositionAndRotation(double p_70080_1_, double p_70080_3_, double p_70080_5_, float p_70080_7_, float p_70080_8_);
	public void setLocationAndAngles(double p_70012_1_, double p_70012_3_, double p_70012_5_, float p_70012_7_, float p_70012_8_);
	public float getDistanceToEntity(Object entity);
	public double getDistanceSq(double p_70092_1_, double p_70092_3_, double p_70092_5_);
	public double getDistance(double p_70011_1_, double p_70011_3_, double p_70011_5_);
	public double getDistanceSqToEntity(Object entity);
	public void onCollideWithPlayer(Object entityPlayer);
	public void applyEntityCollision(Object entity);
	public void addVelocity(double p_70024_1_, double p_70024_3_, double p_70024_5_);
	public void setBeenAttacked();
	public boolean attackEntityFrom(Object damageSource, float p_70097_2_);
	public boolean canBeCollidedWith();
	public boolean canBePushed();
	public boolean isInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_);
	public boolean isInRangeToRenderDist(double p_70112_1_);
	public boolean writeToNBTAtomically(Object nBTTagCompound);
	public boolean writeToNBTOptional(Object nBTTagCompound);
	public Object writeToNBT(Object nBTTagCompound);
	public void readFromNBT(Object nBTTagCompound);
	public boolean shouldSetPosAfterLoading();
	public void onChunkLoad();
	public Object newDoubleNBTList(double... p_70087_1_);
	public Object newFloatNBTList(float... p_70049_1_);
	public Object dropItem(Object item, int p_145779_2_);
	public Object dropItemWithOffset(Object item, int p_145778_2_, float p_145778_3_);
	public Object entityDropItem(Object itemStack, float p_70099_2_);
	public float getShadowSize();
	public boolean isEntityAlive();
	public boolean isEntityInsideOpaqueBlock();
	public boolean processInitialInteract(Object entityPlayer);
	public Object getCollisionBox(Object entity);
	public void updateRidden();
	public void updatePassenger();
	public double getYOffset();
	public double getMountedYOffset();
	public boolean startRiding(Object entity);
	public void setPositionAndRotationDirect(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_);
	public float getCollisionBorderSize();
	public Object getLookVec();
	public void setPortal(Object blockPos);
	public int getPortalCooldown();
	public void setVelocity(double p_70016_1_, double p_70016_3_, double p_70016_5_);
	public void handleStatusUpdate(byte p_70103_1_);
	public void performHurtAnimation();
	public Object getLastActiveItems();
	public void setItemStackToSlot(int p_70062_1_, Object itemStack);
	public boolean isBurning();
	public boolean isRiding();
	public boolean isSneaking();
	public void setSneaking(boolean p_70095_1_);
	public boolean isSprinting();
	public void setSprinting(boolean p_70031_1_);
	public boolean isInvisible();
	public boolean isInvisibleToPlayer(Object entityPlayer);
	public void setInvisible(boolean p_82142_1_);
	public boolean isEating();
	public void setEating(boolean p_70019_1_);
	public boolean getFlag(int p_70083_1_);
	public void setFlag(int p_70052_1_, boolean p_70052_2_);
	public int getAir();
	public void setAir(int p_70050_1_);
	public void onStruckByLightning(Object entityLightningBolt);
	public void onKillEntity(Object entityLivingBase);
	public boolean pushOutOfBlocks(double p_145771_1_, double p_145771_3_, double p_145771_5_);
	public void setInWeb();
	public String getName();
	public Object getParts();
	public boolean isEntityEqual(Object entity);
	public float getRotationYawHead();
	public void setRotationYawHead(float p_70034_1_);
	public boolean canBeAttackedWithItem();
	public boolean hitByEntity(Object entity);
	public String toString();
	public boolean isEntityInvulnerable();
	public void copyLocationAndAnglesFrom(Object entity);
	public void copyDataFrom(Object entity, boolean p_82141_2_);
	public Object changeDimension(int p_71027_1_);
	public float func_145772_a(Object explosion, Object world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Object block);
	public boolean func_145774_a(Object explosion, Object world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Object block, float p_145774_7_);
	public int getMaxSafePointTries();
	public Object getLastPortalVec();
	public boolean doesEntityNotTriggerPressurePlate();
	public void addEntityCrashInfo(Object crashReportCategory);
	public boolean canRenderOnFire();
	public UUID getUniqueID();
	public boolean isPushedByWater();
	public Object getDisplayName();
	public void onDataWatcherUpdate(int p_145781_1_);
	public Object getEntityData();
	public boolean shouldRiderSit();
	public Object getPickedResult(Object movingObjectPosition);
	public UUID getPersistentID();
	public boolean shouldRenderInPass(int pass);
	public boolean isCreatureType(Object enumCreatureType, boolean forSpawnCount);
	public String registerExtendedProperties(String identifier, Object iExtendedEntityProperties);
	public Object getExtendedProperties(String identifier);
	public boolean canRiderInteract();
	public boolean shouldDismountInWater(Object entity);
	public void setMaxHealth(Object floatOrInt);
	public void setCustomNameTag(String p_96094_1_);
	public String getCustomNameTag();
	public void setAlwaysRenderNameTag(boolean p_174805_1_);
	public boolean getAlwaysRenderNameTag();
	// ~164
	public void playStepSound(int par1, int par2, int par3, Object par4);
	public boolean isInRangeToRender3d(Object vec3);
	public Object dropItem(int par1, int par2);
	public Object dropItemWithOffset(int par1, int par2, float par3);
	public float getBlockExplosionResistance(Object explosion, Object world, int par3, int par4, int par5, Object block);
	public boolean shouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, Object par6, float par7);
	public String getTranslatedEntityName();
	// ~152
	public boolean attackEntityFrom(Object damageSource, int par2);
	public String getTexture();
	public boolean addNotRiddenEntityID(Object nBTTagCompound);
	public boolean addEntityID(Object nBTTagCompound);
	public void unmountEntity(Object entity);
	public void updateCloak();
	public float func_82146_a(Object explosion, Object world, int par3, int par4, int par5, Object block);
	public boolean func_96091_a(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7);
	public int getMaxFallHeight();
	// 180~
	public void onKillCommand();
	public void playStepSound(Object blockPos, Object block);
	public boolean isSilent();
	public void setSilent(boolean isSilent);
	public void updateFallState(double p_180433_1_, boolean p_180433_3_, Object block, Object blockPos);
	public void fall(float distance, float damageMultiplier);
	public void doWaterSplashEffect();
	public void spawnRunningParticles();
	public void createRunningParticles();
	public boolean isInLava();
	public void moveToBlockPosAndAngles(Object blockPos, float p_174828_2_, float p_174828_3_);
	public double getDistanceSq(Object blockPos);
	public double getDistanceSqToCenter(Object blockPos);
	public Object getLook(float p_70676_1_);
	public Object getPositionEyes(float p_174824_1_);
	public Object rayTrace(double p_174822_1_, float p_174822_3_);
	public void setPositionAndRotationDirect(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_);
	public Object[] getInventory();
	public boolean isEntityInvulnerable(Object damageSource);
	public void copyDataFromOld(Object entity);
	public float getExplosionResistance(Object explosion, Object world, Object blockPos, Object iBlockState);
	public boolean canExplosionDestroyBlock(Object explosion, Object world, Object blockPos, Object iBlockState, float p_174816_5_);
	public boolean hasCustomName();
	public void setPositionAndUpdate(double x, double y, double z);
	public boolean getAlwaysRenderNameTagForRender();
	public Object getHorizontalFacing();
	public Object getHoverEvent();
	public boolean isSpectatedByPlayer(Object entityPlayerMP);
	public Object getEntityBoundingBox();
	public void setEntityBoundingBox(Object axisAlignedBB);
	public boolean isOutsideBorder();
	public void setOutsideBorder(boolean p_174821_1_);
	public boolean replaceItemInInventory(int p_174820_1_, Object itemStack);
	public void sendMessage(Object iTextComponent);
	public boolean canUseCommand(int permLevel, String commandName);
	public Object getPosition();
	public Object getPositionVector();
	public Object getEntityWorld();
	public Object getCommandSenderEntity();
	public boolean sendCommandFeedback();
	public void setCommandStat(Object type, int amount);
	public Object getCommandStats();
	public void setCommandStats(Object entity);
	public Object getNBTTagCompound();
	public void clientUpdateEntityNBT(Object nBTTagCompound);
	public boolean interactAt(Object entityPlayer, Object vec3);
	public boolean isImmuneToExplosions();
	public void applyEnchantments(Object entityLivingBase, Object entity);
	public boolean processInitialInteract(Object entityPlayer, Object itemStack, Object enumHand);
	// 190~
	public Object getTags();
	public boolean addTag(String tag);
	public boolean removeTag(String tag);
	public boolean equals(Object p_equals_1_);
	public int hashCode();
	public void setDropItemsWhenDead(boolean p_184174_1_);
	public void decrementTimeUntilPortal();
	public void resetPositionToBB();
	public void updatePassenger(Object entity);
	public void applyOrientationToEntity(Object entity);
	public boolean startRiding(Object entity, boolean force);
	public boolean canBeRidden(Object entity);
	public void removePassengers();
	public void dismountRidingEntity();
	public void addPassenger(Object entity);
	public void removePassenger(Object entity);
	public boolean canFitPassenger(Object entity);
	public Object getHeldEquipment();
	public Object getArmorInventoryList();
	public Object getEquipmentAndArmor();
	public void setItemStackToSlot(Object entityEquipmentSlot, Object itemStack);
	public boolean isBeingRidden();
	public boolean isGlowing();
	public void setGlowing(boolean p_184195_1_);
	public Object getTeam();
	public boolean isOnSameTeam(Object entity);
	public boolean isOnScoreboardTeam(Object team);
	public void setRenderYawOffset(float offset);
	public void setEntityInvulnerable(boolean isInvulnerable);
	public boolean isNonBoss();
	public void setUniqueId(UUID uniqueIdIn);
	public void notifyDataManagerChange(Object dataParameter);
	public Object getAdjustedHorizontalFacing();
	public Object getRenderBoundingBox();
	public Object getServer();
	public Object applyPlayerInteraction(Object entityPlayer, Object vec3d, Object itemStack, Object enumHand);
	public boolean hasCapability(Object capability, Object enumFacing);
	public void deserializeNBT(Object nBTTagCompound);
	public Object serializeNBT();
	public void addTrackingPlayer(Object entityPlayerMP);
	public void removeTrackingPlayer(Object entityPlayerMP);
	public float getRotatedYaw(Object rotation);
	public float getMirroredYaw(Object mirror);
	public boolean ignoreItemEntityData();
	public boolean setPositionNonDirty();
	public Object getControllingPassenger();
	public Object getPassengers();
	public boolean isPassenger(Object entity);
	public Object getRecursivePassengers();
	public Object getLowestRidingEntity();
	public boolean isRidingSameEntity(Object entity);
	public boolean isRidingOrBeingRiddenBy(Object entity);
	public boolean canPassengerSteer();
	public Object getRidingEntity();
	public Object getPushReaction();
	public Object getSoundCategory();
	public Object getCapability(Object capability, Object enumFacing);
	public Object getRecursivePassengersByType(Class entityClass);
	public void setCurrentItemOrArmor(int p_70062_1_, Object itemStack);
	public int getBrightnessForRender();
	public float getBrightness();
	public void awardKillScore(Object entity, int p_191956_2_, Object damageSource);
	public void moveRelative(float p_70060_1_, float p_70060_2_, float p_70060_3_, float p_191958_4_);
	public Object getTeleportDirection();
	public String getCachedUniqueIdString();
	public void onInsideBlock(Object iBlockState);
	public float playFlySound(float p_191954_1_);
	public boolean makeFlySound();
	public boolean hasNoGravity();
	public void setNoGravity(boolean noGravity);
	public boolean isOverWater();
	public Object getPitchYaw();
	public Object getForward();
	public boolean getIsInvulnerable();
	public boolean canTrample(Object world, Object block, Object blockPos, float fallDistance);
	public int getFireImmuneTicks();

}
