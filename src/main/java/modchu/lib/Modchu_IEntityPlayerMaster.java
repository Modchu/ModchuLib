package modchu.lib;

import java.util.Random;
import java.util.UUID;

public interface Modchu_IEntityPlayerMaster {
	public void sendChatToPlayer(Object chatMessageComponent);
	public boolean canCommandSenderUseCommand(int i, String s);
	public Object getPlayerCoordinates();
	public void applyEntityAttributes();
	public void entityInit();
	public Object getItemInUse();
	public int getItemInUseCount();
	public boolean isHandActive();
	public int getItemInUseDuration();
	public void stopUsingItem();
	public void clearItemInUse();
	public boolean isBlocking();
	public void onUpdate();
	public int getMaxInPortalTime();
	public int getPortalCooldown();
	public void playSound(String par1Str, float par2, float par3);
	public void updateItemUse(Object itemStack, int par2);
	public void onItemUseFinish();
	public void handleStatusUpdate(byte par1);
	public boolean isMovementBlocked();
	public void closeScreen();
	public boolean startRiding(Object entity);
	public void updateRidden();
	public void preparePlayerToSpawn();
	public void updateEntityActionState();
	public void onLivingUpdate();
	public int getScore();
	public void setScore(int par1);
	public void addScore(int par1);
	public void onDeath(Object damageSource);
	public void addToPlayerScore(Object entity, int par2);
	public Object dropItem(boolean par1);
	public Object dropPlayerItem(Object itemStack);
	public Object dropItem(Object itemStack, boolean par2);
	public void dropItemAndGetStack(Object entityItem);
	public float getCurrentPlayerStrVsBlock(Object block, boolean par2);
	public float getCurrentPlayerStrVsBlock(Object block, boolean par2, int meta);
	public boolean canHarvestBlock(Object block);
	public void readEntityFromNBT(Object nBTTagCompound);
	public void writeEntityToNBT(Object nBTTagCompound);
	public void displayGUIChest(Object iInventory);
	public void displayGUIHopper(Object tileEntityHopper);
	public void displayGUIHopperMinecart(Object entityMinecartHopper);
	public void openGuiHorseInventory(Object entityHorse, Object iInventory);
	public void displayGUIEnchantment(int par1, int par2, int par3, String par4Str);
	public void displayGUIAnvil(int par1, int par2, int par3);
	public void displayGUIWorkbench(int par1, int par2, int par3);
	public float getEyeHeight();
	public void resetHeight();
	public boolean attackEntityFrom(Object damageSource, float par2);
	public boolean canAttackPlayer(Object entityPlayer);
	public void damageArmor(float par1);
	public int getTotalArmorValue();
	public float getArmorVisibility();
	public void damageEntity(Object damageSource, float par2);
	public void displayGUIFurnace(Object tileEntityFurnace);
	public void displayGUIDispenser(Object tileEntityDispenser);
	public void displayGUIEditSign(Object tileEntity);
	public void displayGUIBrewingStand(Object tileEntityBrewingStand);
	public void displayGUIBeacon(Object tileEntityBeacon);
	public void displayGUIMerchant(Object iMerchant, String par2Str);
	public void openBook(Object itemStack);
	public boolean interactWith(Object entity);
	public Object getHeldItemMainhand();
	public void destroyCurrentEquippedItem();
	public double getYOffset();
	public void attackTargetEntityWithCurrentItem(Object entity);
	public void onCriticalHit(Object entity);
	public void onEnchantmentCritical(Object entity);
	public void respawnPlayer();
	public void setDead();
	public boolean isEntityInsideOpaqueBlock();
	public Object sleepInBedAt(int par1, int par2, int par3);
	public void wakeUpPlayer(boolean par1, boolean par2, boolean par3);
	public float getBedOrientationInDegrees();
	public boolean isPlayerSleeping();
	public boolean isPlayerFullyAsleep();
	public int getSleepTimer();
	public boolean getHideCape(int par1);
	public void setHideCape(int par1, boolean par2);
	public void addChatMessage(String par1Str);
	public Object getBedLocation();
	public boolean isSpawnForced();
	public Object getBedLocation(int dimension);
	public boolean isSpawnForced(int dimension);
	public void setSpawnChunk(Object chunkCoordinates, boolean par2);
	public void setSpawnChunk(Object chunkCoordinates, boolean forced, int dimension);
	public void addStat(Object statBase);
	public void addStat(Object statBase, int par2);
	public void jump();
	public void moveEntityWithHeading(float par1, float par2);
	public float getAIMoveSpeed();
	public void addMovementStat(double par1, double par3, double par5);
	public void fall(float par1);
	public void onKillEntity(Object entityLivingBase);
	public void setInWeb();
	public Object getItemIcon(Object itemStack, int par2);
	public Object getCurrentArmor(int par1);
	public void addExperience(int par1);
	public void addExperienceLevel(int par1);
	public int xpBarCap();
	public void addExhaustion(float par1);
	public Object getFoodStats();
	public boolean canEat(boolean par1);
	public boolean shouldHeal();
	public void setItemInUse(Object itemStack, int par2);
	public boolean isCurrentToolAdventureModeExempt(int par1, int par2, int par3);
	public boolean canPlayerEdit(int par1, int par2, int par3, int par4, Object itemStack);
	public int getExperiencePoints(Object entityPlayer);
	public boolean isPlayer();
	public String getEntityName();
	public boolean getAlwaysRenderNameTagForRender();
	public void clonePlayer(Object entityPlayer, boolean par2);
	public boolean canTriggerWalking();
	public void sendPlayerAbilities();
	public void setGameType(Object enumGameType);
	public String getCommandSenderName();
	public Object getEntityWorld();
	public Object getInventoryEnderChest();
	public Object getCurrentItemOrArmor(int par1);
	public Object getHeldItem();
	public void setCurrentItemOrArmor(int par1, Object itemStack);
	public boolean isInvisibleToPlayer(Object entityPlayer);
	public Object[] getLastActiveItems();
	public boolean getHideCape();
	public boolean isPushedByWater();
	public Object getWorldScoreboard();
	public Object getTeam();
	public String getTranslatedEntityName();
	public void setAbsorptionAmount(float par1);
	public float getAbsorptionAmount();
	public void openGui(Object mod, int modGuiId, Object world, int x, int y, int z);
	public float getDefaultEyeHeight();
	public String getDisplayName();
	public void refreshDisplayName();
	public void updateFallState(double par1, boolean par3);
	public boolean canBreatheUnderwater();
	public void onEntityUpdate();
	public boolean isChild();
	public void onDeathUpdate();
	public int decreaseAirSupply(int par1);
	public Random getRNG();
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
	public void heal(float par1);
	public void setHealth(float par1);
	public void renderBrokenItemStack(Object itemStack);
	public void dropEquipment(boolean par1, int par2);
	public void knockBack(Object entity, float par2, double par3, double par5);
	public String getHurtSound();
	public String getDeathSound();
	public void dropRareDrop(int par1);
	public void dropFewItems(boolean par1, int par2);
	public boolean isOnLadder();
	public boolean isEntityAlive();
	public void performHurtAnimation();
	public Object applyArmorCalculations(Object damageSource, float par2);
	public Object applyPotionDamageCalculations(Object damageSource, float par2);
	public Object func_110142_aN();
	public Object getAttackingEntity();
	public void swingArm();
	public void kill();
	public void updateArmSwingProgress();
	public Object getEntityAttribute(Object attribute);
	public Object getAttributeMap();
	public Object getCreatureAttribute();
	public void setSprinting(boolean par1);
	public float getSoundVolume();
	public float getSoundPitch();
	public void setPositionAndUpdate(double par1, double par3, double par5);
	public void dismountEntity(Object entity);
	public boolean isAIEnabled();
	public void setAIMoveSpeed(float par1);
	public boolean attackEntityAsMob(Object entity);
	public float updateDistance(float par1, float par2);
	public void updateAITasks();
	public void collideWithNearbyEntities();
	public void collideWithEntity(Object entity);
	public void setPositionAndRotationDirect(double par1, double par3, double par5, float par7, float par8, int par9);
	public void handleJumpWater();
	public void setJumping(boolean par1);
	public void onItemPickup(Object entity, int par2);
	public boolean canEntityBeSeen(Object entity);
	public Object getLookVec();
	public Object getLook(float par1);
	public float getSwingProgress(float par1);
	public Object getPosition(float par1);
	public Object rayTrace(double par1, float par3);
	public boolean isClientWorld();
	public boolean canBeCollidedWith();
	public boolean canBePushed();
	public void setBeenAttacked();
	public float getRotationYawHead();
	public void setRotationYawHead(float par1);
	public boolean isOnSameTeam(Object entityLivingBase);
	public boolean isOnTeam(Object team);
	public void curePotionEffects(Object itemStack);
	public boolean shouldRiderFaceForward(Object entityPlayer);
	public Object getDataManager();
	//public boolean equals(Object par1Obj);
	//public int hashCode();
	public void setSize(float par1, float par2);
	public void setRotation(float par1, float par2);
	public void setPosition(double par1, double par3, double par5);
	public void setAngles(float par1, float par2);
	public void setOnFireFromLava();
	public void setFire(int par1);
	public void extinguish();
	public boolean isOffsetPositionInLiquid(double par1, double par3, double par5);
	public void moveEntity(double par1, double par3, double par5);
	public void doBlockCollisions();
	public void playStepSound(int par1, int par2, int par3, int par4);
	public Object getCollisionBoundingBox();
	public void dealFireDamage(int par1);
	public boolean isWet();
	public boolean isInWater();
	public boolean handleWaterMovement();
	public boolean isInsideOfMaterial(Object material);
	public boolean handleLavaMovement();
	public void moveRelative(float par1, float par2, float par3);
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
	public boolean isInRangeToRenderVec3D(Object vec3);
	public boolean isInRangeToRenderDist(double par1);
	public boolean writeToNBTAtomically(Object nBTTagCompound);
	public boolean writeToNBTOptional(Object nBTTagCompound);
	public void writeToNBT(Object nBTTagCompound);
	public void readFromNBT(Object nBTTagCompound);
	public boolean shouldSetPosAfterLoading();
	public void onChunkLoad();
	public Object newDoubleNBTList(double... par1ArrayOfDouble);
	public Object newFloatNBTList(float... par1ArrayOfFloat);
	public float getShadowSize();
	public Object dropItem(int par1, int par2);
	public Object dropItemWithOffset(int par1, int par2, float par3);
	public Object entityDropItem(Object itemStack, float par2);
	public boolean processInitialInteract(Object entityPlayer);
	public Object getCollisionBox(Object entity);
	public void updatePassenger();
	public double getMountedYOffset();
	public float getCollisionBorderSize();
	public void setPortal(Object bockPos);
	public void setVelocity(double par1, double par3, double par5);
	public boolean isBurning();
	public boolean isRiding();
	public boolean isSneaking();
	public void setSneaking(boolean par1);
	public boolean isSprinting();
	public boolean isInvisible();
	public void setInvisible(boolean par1);
	public boolean isEating();
	public void setEating(boolean par1);
	public boolean getFlag(int par1);
	public void setFlag(int par1, boolean par2);
	public int getAir();
	public void setAir(int par1);
	public void onStruckByLightning(Object entityLightningBolt);
	public boolean pushOutOfBlocks(double par1, double par3, double par5);
	public Object[] getParts();
	public boolean isEntityEqual(Object entity);
	public boolean canBeAttackedWithItem();
	public boolean hitByEntity(Object entity);
	public String toString();
	public boolean isEntityInvulnerable();
	public void copyLocationAndAnglesFrom(Object entity);
	public void copyDataFrom(Object entity, boolean par2);
	public void changeDimension(int par1);
	public float getBlockExplosionResistance(Object explosion, Object world, int par3, int par4, int par5, Object block);
	public boolean shouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7);
	public int getMaxSafePointTries();
	public Object getLastPortalVec();
	public boolean doesEntityNotTriggerPressurePlate();
	public void addEntityCrashInfo(Object crashReportCategory);
	public boolean canRenderOnFire();
	public UUID getUniqueID();
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
	public void setPositionCorrection(double par1, double par3, double par5);

}
