package modchu.lib;

import java.util.UUID;

public interface Modchu_IEntityTameable {

	public void applyEntityAttributes();
	public void attackEntity(Object entity, float f);
	public boolean attackEntityFrom(Object par1DamageSource, float par2);
	public boolean canBeCollidedWith();
	public boolean canDespawn();
	public Object createChild(Object entityanimal);
	public void entityInit();
	public Object findPlayerToAttack();
	public String getDeathSound();
	public float getEyeHeight();
	public Object getHeldItem();
	public String getHurtSound();
	public String getLivingSound();
	public double getMountedYOffset();
	public Object getOwner();
	public String getOwnerName();
	public Object getResourceLocation();
	public int getTextureColor();
	public double getYOffset();
	public void handleHealthUpdate(byte par1);
	public void heal(float f);
	public boolean interact(Object entityplayer);
	public boolean isAngry();
	public boolean isBreedingItem(Object par1ItemStack);
	public boolean isEntityInsideOpaqueBlock();
	public boolean isInLove();
	public boolean isMovementCeased();
	public boolean isRiding();
	public boolean isSitting();
	public boolean isStanding();
	public boolean isTamed();
	public void jump();
	public void onLivingUpdate();
	public void onUpdate();
	public void playTameEffect(boolean par1);
	public void readEntityFromNBT(Object nbttagcompound);
	public void resetInLove();
	public void setAngry(boolean flag);
	public void setAttackTarget(Object par1EntityLiving);
	public void setOwner(String s);
	public void setSitting(boolean flag);
	public void setStanding(boolean flag);
	public void setTamed(boolean flag);
	public void setTextureColor(int i);
	public void updateEntityActionState();
	public void writeEntityToNBT(Object nbttagcompound);
	public void setResourceLocation(Object resourceLocation);
	public void onDeathUpdate();
	public boolean func_142018_a(Object entityLivingBase, Object entityLivingBase2);
	public Object getTeam();
	public boolean isOnSameTeam(Object entityLivingBase);
	public void updateAITick();
	public float getBlockPathWeight(int par1, int par2, int par3);
	public boolean getCanSpawnHere();
	public int getTalkInterval();
	public int getExperiencePoints(Object entityPlayer);
	public void func_146082_f(Object entityPlayer);
	public Object func_146083_cb();
	public boolean canMateWith(Object entityAnimal);
	public int getGrowingAge();
	public void addGrowth(int par1);
	public void setGrowingAge(int par1);
	public boolean isChild();
	public void setScaleForAge(boolean par1);
	public void updateWanderPath();
	public boolean hasPath();
	public void setPathToEntity(Object pathEntity);
	public Object getEntityToAttack();
	public void setTarget(Object entity);
	public boolean isWithinHomeDistanceCurrentPosition();
	public boolean isWithinHomeDistance(int par1, int par2, int par3);
	public void setHomeArea(int par1, int par2, int par3, int par4);
	public Object getHomePosition();
	public float func_110174_bM();
	public void detachHome();
	public boolean hasHome();
	public void updateLeashedState();
	public void func_142017_o(float par1);
	public Object getLookHelper();
	public Object getMoveHelper();
	public Object getJumpHelper();
	public Object getNavigator();
	public Object getEntitySenses();
	public Object getAttackTarget();
	public boolean canAttackClass(Class c);
	public void eatGrassBonus();
	public void playLivingSound();
	public void onEntityUpdate();
	public void spawnExplosionParticle();
	public float func_110146_f(float par1, float par2);
	public Object getDropItem();
	public void dropFewItems(boolean par1, int par2);
	public void setMoveForward(float par1);
	public void setAIMoveSpeed(float par1);
	public boolean isAIEnabled();
	public void despawnEntity();
	public void updateAITasks();
	public int getVerticalFaceSpeed();
	public void faceEntity(Object entity, float par2, float par3);
	public float getRenderSizeModifier();
	public int getMaxSpawnedInChunk();
	public int getMaxSafePointTries();
	public Object getEquipmentInSlot(int par1);
	public Object func_130225_q(int par1);
	public void setCurrentItemOrArmor(int par1, Object itemStack);
	public Object getLastActiveItems();
	public void dropEquipment(boolean par1, int par2);
	public void addRandomArmor();
	public void enchantEquipment();
	public Object onSpawnWithEgg(Object iEntityLivingData);
	public boolean canBeSteered();
	public String getCommandSenderName();
	public void func_110163_bv();
	public void setCustomNameTag(String par1Str);
	public String getCustomNameTag();
	public boolean hasCustomNameTag();
	public void setAlwaysRenderNameTag(boolean par1);
	public boolean getAlwaysRenderNameTag();
	public boolean getAlwaysRenderNameTagForRender();
	public void setEquipmentDropChance(int par1, float par2);
	public boolean canPickUpLoot();
	public void setCanPickUpLoot(boolean par1);
	public boolean isNoDespawnRequired();
	public void clearLeashed(boolean par1, boolean par2);
	public boolean allowLeashing();
	public boolean getLeashed();
	public Object getLeashedToEntity();
	public void setLeashedToEntity(Object entity, boolean par2);
	public void updateFallState(double par1, boolean par3);
	public boolean canBreatheUnderwater();
	public boolean func_146066_aG();
	public int decreaseAirSupply(int par1);
	public boolean isPlayer();
	public Object getRNG();
	public Object getAITarget();
	public int func_142015_aE();
	public void setRevengeTarget(Object entityLivingBase);
	public Object getLastAttacker();
	public int getLastAttackerTime();
	public void setLastAttacker(Object entity);
	public int getAge();
	public void updatePotionEffects();
	public void clearActivePotions();
	public Object getActivePotionEffects();
	public boolean isPotionActive(int par1);
	public boolean isPotionActive(Object potion);
	public Object getActivePotionEffect(Object potion);
	public void addPotionEffect(Object potionEffect);
	public boolean isPotionApplicable(Object potionEffect);
	public boolean isEntityUndead();
	public void removePotionEffectClient(int par1);
	public void removePotionEffect(int par1);
	public void onNewPotionEffect(Object potionEffect);
	public void onChangedPotionEffect(Object potionEffect, boolean par2);
	public void onFinishedPotionEffect(Object potionEffect);
	public void setHealth(float par1);
	public void renderBrokenItemStack(Object itemStack);
	public void onDeath(Object damageSource);
	public void knockBack(Object entity, float par2, double par3, double par5);
	public void dropRareDrop(int par1);
	public boolean isOnLadder();
	public boolean isEntityAlive();
	public void fall(float par1);
	public String func_146067_o(int p_146067_1_);
	public void performHurtAnimation();
	public int getTotalArmorValue();
	public void damageArmor(float par1);
	public float applyArmorCalculations(Object damageSource, float par2);
	public float applyPotionDamageCalculations(Object damageSource, float par2);
	public void damageEntity(Object damageSource, float par2);
	public Object func_110142_aN();
	public Object func_94060_bK();
	public void swingItem();
	public void kill();
	public void updateArmSwingProgress();
	public Object getEntityAttribute(Object iAttribute);
	public Object getAttributeMap();
	public Object getCreatureAttribute();
	public void setSprinting(boolean par1);
	public float getSoundVolume();
	public float getSoundPitch();
	public boolean isMovementBlocked();
	public void setPositionAndUpdate(double par1, double par3, double par5);
	public void dismountEntity(Object entity);
	public Object getItemIcon(Object itemStack, int par2);
	public void moveEntityWithHeading(float par1, float par2);
	public float getAIMoveSpeed();
	public boolean attackEntityAsMob(Object entity);
	public boolean isPlayerSleeping();
	public void collideWithNearbyEntities();
	public void collideWithEntity(Object entity);
	public void updateRidden();
	public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9);
	public void setJumping(boolean par1);
	public void onItemPickup(Object entity, int par2);
	public boolean canEntityBeSeen(Object entity);
	public Object getLookVec();
	public Object getLook(float par1);
	public float getSwingProgress(float par1);
	public Object getPosition(float par1);
	public Object rayTrace(double par1, float par3);
	public boolean isClientWorld();
	public boolean canBePushed();
	public void setBeenAttacked();
	public float getRotationYawHead();
	public void setRotationYawHead(float par1);
	public float getAbsorptionAmount();
	public void setAbsorptionAmount(float par1);
	public boolean isOnTeam(Object team);
	public void curePotionEffects(Object itemStack);
	public boolean shouldRiderFaceForward(Object entityPlayer);
	public int getEntityId();
	public void setEntityId(int p_145769_1_);
	public Object getDataWatcher();
	public void preparePlayerToSpawn();
	public void setDead();
	public void setRotation(float par1, float par2);
	public void setPosition(double par1, double par3, double par5);
	public void setAngles(float par1, float par2);
	public int getMaxInPortalTime();
	public void setOnFireFromLava();
	public void setFire(int par1);
	public void extinguish();
	public boolean isOffsetPositionInLiquid(double par1, double par3, double par5);
	public void moveEntity(double par1, double par3, double par5);
	public String getSwimSound();
	public void func_145775_I();
	public void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Object p_145780_4_);
	public void playSound(String par1Str, float par2, float par3);
	public boolean canTriggerWalking();
	public Object getBoundingBox();
	public void dealFireDamage(int par1);
	public boolean isWet();
	public boolean isInWater();
	public boolean handleWaterMovement();
	public String getSplashSound();
	public boolean isInsideOfMaterial(Object material);
	public boolean handleLavaMovement();
	public void moveFlying(float par1, float par2, float par3);
	public int getBrightnessForRender(float par1);
	public float getBrightness(float par1);
	public void setWorld(Object world);
	public void setPositionAndRotation(double par1, double par3, double par5, float par7, float par8);
	public void setLocationAndAngles(double par1, double par3, double par5, float par7, float par8);
	public float getDistanceToEntity(Object entity);
	public double getDistanceSq(double par1, double par3, double par5);
	public double getDistance(double par1, double par3, double par5);
	public double getDistanceSqToEntity(Object entity);
	public void onCollideWithPlayer(Object entityPlayer);
	public void applyEntityCollision(Object entity);
	public void addVelocity(double par1, double par3, double par5);
	public void addToPlayerScore(Object entity, int par2);
	public boolean isInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_);
	public boolean isInRangeToRenderDist(double par1);
	public boolean writeMountToNBT(Object nbtTagCompound);
	public boolean writeToNBTOptional(Object nbtTagCompound);
	public void writeToNBT(Object nbtTagCompound);
	public void readFromNBT(Object nbtTagCompound);
	public boolean shouldSetPosAfterLoading();
	public void onChunkLoad();
	public Object newDoubleNBTList(double... par1ArrayOfDouble);
	public Object newFloatNBTList(float... par1ArrayOfFloat);
	public Object dropItem(Object item, int p_145779_2_);
	public Object func_145778_a(Object item, int p_145778_2_, float p_145778_3_);
	public Object entityDropItem(Object itemStack, float par2);
	public float getShadowSize();
	public Object getCollisionBox(Object entity);
	public void updateRiderPosition();
	public void mountEntity(Object entity);
	public float getCollisionBorderSize();
	public void setInPortal();
	public int getPortalCooldown();
	public void setVelocity(double par1, double par3, double par5);
	public boolean isBurning();
	public boolean isSneaking();
	public void setSneaking(boolean par1);
	public boolean isSprinting();
	public boolean isInvisible();
	public boolean isInvisibleToPlayer(Object entityPlayer);
	public void setInvisible(boolean par1);
	public boolean isEating();
	public void setEating(boolean par1);
	public boolean getFlag(int par1);
	public void setFlag(int par1, boolean par2);
	public int getAir();
	public void setAir(int par1);
	public void onStruckByLightning(Object entityLightningBolt);
	public void onKillEntity(Object entityLivingBase);
	public boolean func_145771_j(double p_145771_1_, double p_145771_3_, double p_145771_5_);
	public void setInWeb();
	public Object getParts();
	public boolean isEntityEqual(Object entity);
	public boolean canAttackWithItem();
	public boolean hitByEntity(Object entity);
	public boolean isEntityInvulnerable();
	public void copyLocationAndAnglesFrom(Object entity);
	public void copyDataFrom(Object entity, boolean par2);
	public void travelToDimension(int par1);
	public float func_145772_a(Object explosion, Object world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Object block);
	public boolean func_145774_a(Object explosion, Object world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Object block, float p_145774_7_);
	public int getTeleportDirection();
	public boolean doesEntityNotTriggerPressurePlate();
	public void addEntityCrashInfo(Object crashReportCategory);
	public boolean canRenderOnFire();
	public UUID getUniqueID();
	public boolean isPushedByWater();
	public Object func_145748_c_();
	public void func_145781_i(int p_145781_1_);
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
	public Object func_70907_r();
	public Object getFreeVariable(String s);
	public void setFreeVariable(String s, Object o);

}