package modchu.lib;

import java.util.UUID;

public interface Modchu_IEntityFXMaster {
	public Object multiplyVelocity(float par1);
	public Object multipleParticleScaleBy(float par1);
	public void setRBGColorF(float par1, float par2, float par3);
	public void setAlphaF(float par1);
	public float getRedColorF();
	public float getGreenColorF();
	public float getBlueColorF();
	public boolean canTriggerWalking();
	public void entityInit();
	public void onUpdate();
	public void renderParticle(Object tessellator, float par2, float par3, float par4, float par5, float par6, float par7);
	public int getFXLayer();
	public void writeEntityToNBT(Object nBTTagCompound);
	public void readEntityFromNBT(Object nBTTagCompound);
	public void setParticleIcon(Object icon);
	public void setParticleTextureIndex(int par1);
	public void nextTextureIndexX();
	public boolean canAttackWithItem();
	public String toString();
	public Object getDataWatcher();
	public boolean equals(Object par1Obj);
	public int hashCode();
	public void preparePlayerToSpawn();
	public void setDead();
	public void setSize(float par1, float par2);
	public void setRotation(float par1, float par2);
	public void setPosition(double par1, double par3, double par5);
	public void setAngles(float par1, float par2);
	public void onEntityUpdate();
	public int getMaxInPortalTime();
	public void setOnFireFromLava();
	public void setFire(int par1);
	public void extinguish();
	public void kill();
	public boolean isOffsetPositionInLiquid(double par1, double par3, double par5);
	public void moveEntity(double par1, double par3, double par5);
	public void doBlockCollisions();
	public void playStepSound(int par1, int par2, int par3, int par4);
	public void playSound(String par1Str, float par2, float par3);
	public void updateFallState(double par1, boolean par3);
	public Object getCollisionBoundingBox();
	public void dealFireDamage(int par1);
	public void fall(float par1);
	public boolean isWet();
	public boolean isInWater();
	public boolean handleWaterMovement();
	public boolean isInsideOfMaterial(Object material);
	public float getEyeHeight();
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
	public void setBeenAttacked();
	public boolean attackEntityFrom(Object damageSource, float par2);
	public boolean canBeCollidedWith();
	public boolean canBePushed();
	public void addToPlayerScore(Object entity, int par2);
	public boolean isInRangeToRenderVec3D(Object vec3);
	public boolean isInRangeToRenderDist(double par1);
	public boolean writeMountToNBT(Object nBTTagCompound);
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
	public boolean isEntityAlive();
	public boolean isEntityInsideOpaqueBlock();
	public boolean interactFirst(Object entityPlayer);
	public Object getCollisionBox(Object entity);
	public void updateRidden();
	public void updateRiderPosition();
	public double getYOffset();
	public double getMountedYOffset();
	public void mountEntity(Object entity);
	public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9);
	public float getCollisionBorderSize();
	public Object getLookVec();
	public void setPortal();
	public int getPortalCooldown();
	public void setVelocity(double par1, double par3, double par5);
	public void handleStatusUpdate(byte par1);
	public void performHurtAnimation();
	public Object[] getInventory();
	public void setCurrentItemOrArmor(int par1, Object itemStack);
	public boolean isBurning();
	public boolean isRiding();
	public boolean isSneaking();
	public void setSneaking(boolean par1);
	public boolean isSprinting();
	public void setSprinting(boolean par1);
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
	public boolean pushOutOfBlocks(double par1, double par3, double par5);
	public void setInWeb();
	public String getName();
	public Object[] getParts();
	public boolean isEntityEqual(Object entity);
	public float getRotationYawHead();
	public void setRotationYawHead(float par1);
	public boolean hitByEntity(Object entity);
	public boolean isEntityInvulnerable();
	public void copyLocationAndAnglesFrom(Object entity);
	public void copyDataFromOld(Object entity, boolean par2);
	public void travelToDimension(int par1);
	public float getBlockExplosionResistance(Object explosion, Object world, int par3, int par4, int par5, Object block);
	public boolean shouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7);
	public int getMaxFallHeight();
	public Object getTeleportDirection();
	public boolean doesEntityNotTriggerPressurePlate();
	public void addEntityCrashInfo(Object crashReportCategory);
	public boolean canRenderOnFire();
	public UUID getUniqueID();
	public boolean isPushedByWater();
	public String getTranslatedEntityName();
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
	// ~152
	public void setParticleIcon(Object renderEngine, Object icon);
	// 172~
	public void playStepSound(int par1, int par2, int par3, Object par4);
	public boolean isInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_);
	public Object dropItem(Object par1, int par2);
	public Object dropItem(Object par1, int par2, float par3);
	public boolean shouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, Object par6, float par7);
	public int getEntityId();
	public void setEntityId(int p_145769_1_);
	public Object getSwimSound();
	public Object getSplashSound();
	public Object getDisplayName();
	public void onDataWatcherUpdate(int p_145781_1_);
	// 180~
	public void renderParticle(Object tessellator, Object entity, float par2, float par3, float par4, float par5, float par6, float par7);
	public void updateFallState(double par1, boolean par3, Object block, Object blockPos);
	public void fall(float par1, float damageMultiplier);
	public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9, boolean b);
	public boolean isEntityInvulnerable(Object p_180431_1_);
	public void copyDataFromOld(Object entity);
	public void playStepSound(Object blockPos, Object block);
	public float getBlockExplosionResistance(Object explosion, Object world, Object blockPos, Object iBlockState);
	public boolean shouldExplodeBlock(Object explosion, Object world, Object blockPos, Object iBlockState, float par7);
	public void setPortal(Object blockPos);
	// 190~
	public boolean func_187111_c();
	public void setMaxAge(int p_187114_1_);
	public void setParticleTexture(Object textureAtlasSprite);
	public void setExpired();
	public void resetPositionToBB();
	public boolean isAlive();
	public Object getEntityBoundingBox();
	public void setEntityBoundingBox(Object axisAlignedBB);

}
