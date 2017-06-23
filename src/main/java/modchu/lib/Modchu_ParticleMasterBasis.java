package modchu.lib;

import java.util.HashMap;
import java.util.UUID;

public class Modchu_ParticleMasterBasis implements Modchu_IParticleMaster {
	public Modchu_IParticle base;

	public Modchu_ParticleMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IParticle) map.get("base");
	}

	@Override
	public Object multiplyVelocity(float par1) {
		return base.superMultiplyVelocity(par1);
	}

	@Override
	public Object multipleParticleScaleBy(float par1) {
		return base.superMultipleParticleScaleBy(par1);
	}

	@Override
	public void setRBGColorF(float par1, float par2, float par3) {
		base.superSetRBGColorF(par1, par2, par3);
	}

	@Override
	public void setAlphaF(float par1) {
		base.superSetAlphaF(par1);
	}

	@Override
	public float getRedColorF() {
		return base.superGetRedColorF();
	}

	@Override
	public float getGreenColorF() {
		return base.superGetGreenColorF();
	}

	@Override
	public float getBlueColorF() {
		return base.superGetBlueColorF();
	}

	@Override
	public boolean canTriggerWalking() {
		return base.superCanTriggerWalking();
	}

	@Override
	public void entityInit() {
		base.superEntityInit();
	}

	@Override
	public void onUpdate() {
		base.superOnUpdate();
	}

	@Override
	public void renderParticle(Object tessellator, float par2, float par3, float par4, float par5, float par6, float par7) {
		base.superRenderParticle(tessellator, par2, par3, par4, par5, par6, par7);
	}

	@Override
	public int getFXLayer() {
		return base.superGetFXLayer();
	}

	@Override
	public void writeEntityToNBT(Object nBTTagCompound) {
		base.superWriteEntityToNBT(nBTTagCompound);
	}

	@Override
	public void readEntityFromNBT(Object nBTTagCompound) {
		base.superReadEntityFromNBT(nBTTagCompound);
	}

	@Override
	public void setParticleIcon(Object icon) {
		base.superSetParticleIcon(icon);
	}

	@Override
	public void setParticleTextureIndex(int par1) {
		base.superSetParticleTextureIndex(par1);
	}

	@Override
	public void nextTextureIndexX() {
		base.superNextTextureIndexX();
	}

	@Override
	public boolean canBeAttackedWithItem() {
		return base.superCanBeAttackedWithItem();
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
	public void setSize(float par1, float par2) {
		base.superSetSize(par1, par2);
	}

	@Override
	public void setRotation(float par1, float par2) {
		base.superSetRotation(par1, par2);
	}

	@Override
	public void setPosition(double par1, double par3, double par5) {
		base.superSetPosition(par1, par3, par5);
	}

	@Override
	public void setAngles(float par1, float par2) {
		base.superSetAngles(par1, par2);
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
	public void setFire(int par1) {
		base.superSetFire(par1);
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
	public boolean isOffsetPositionInLiquid(double par1, double par3, double par5) {
		return base.superIsOffsetPositionInLiquid(par1, par3, par5);
	}

	@Override
	public void move(double par1, double par3, double par5) {
		base.superMove(par1, par3, par5);
	}

	@Override
	public void doBlockCollisions() {
		base.superDoBlockCollisions();
	}

	@Override
	public void playStepSound(int par1, int par2, int par3, int par4) {
		base.superPlayStepSound(par1, par2, par3, par4);
	}

	@Override
	public void playSound(String par1Str, float par2, float par3) {
		base.superPlaySound(par1Str, par2, par3);
	}

	@Override
	public void updateFallState(double par1, boolean par3) {
		base.superUpdateFallState(par1, par3);
	}

	@Override
	public Object getCollisionBoundingBox() {
		return base.superGetCollisionBoundingBox();
	}

	@Override
	public void dealFireDamage(int par1) {
		base.superDealFireDamage(par1);
	}

	@Override
	public void fall(float par1) {
		base.superFall(par1);
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
	public void moveRelative(float par1, float par2, float par3) {
		base.superMoveRelative(par1, par2, par3);
	}

	@Override
	public int getBrightnessForRender(float par1) {
		return base.superGetBrightnessForRender(par1);
	}

	@Override
	public float getBrightness(float par1) {
		return base.superGetBrightness(par1);
	}

	@Override
	public void setWorld(Object world) {
		base.superSetWorld(world);
	}

	@Override
	public void setPositionAndRotation(double par1, double par3, double par5, float par7, float par8) {
		base.superSetPositionAndRotation(par1, par3, par5, par7, par8);
	}

	@Override
	public void setLocationAndAngles(double par1, double par3, double par5, float par7, float par8) {
		base.superSetLocationAndAngles(par1, par3, par5, par7, par8);
	}

	@Override
	public float getDistanceToEntity(Object entity) {
		return base.superGetDistanceToEntity(entity);
	}

	@Override
	public double getDistanceSq(double par1, double par3, double par5) {
		return base.superGetDistanceSq(par1, par3, par5);
	}

	@Override
	public double getDistance(double par1, double par3, double par5) {
		return base.superGetDistance(par1, par3, par5);
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
	public void addVelocity(double par1, double par3, double par5) {
		base.superAddVelocity(par1, par3, par5);
	}

	@Override
	public void setBeenAttacked() {
		base.superSetBeenAttacked();
	}

	@Override
	public boolean attackEntityFrom(Object damageSource, float par2) {
		return base.superAttackEntityFrom(damageSource, par2);
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
	public void addToPlayerScore(Object entity, int par2) {
		base.superAddToPlayerScore(entity, par2);
	}

	@Override
	public boolean isInRangeToRenderVec3D(Object vec3) {
		return base.superIsInRangeToRenderVec3D(vec3);
	}

	@Override
	public boolean isInRangeToRenderDist(double par1) {
		return base.superIsInRangeToRenderDist(par1);
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
	public Object newDoubleNBTList(double... par1ArrayOfDouble) {
		return base.superNewDoubleNBTList(par1ArrayOfDouble);
	}

	@Override
	public Object newFloatNBTList(float... par1ArrayOfFloat) {
		return base.superNewFloatNBTList(par1ArrayOfFloat);
	}

	@Override
	public float getShadowSize() {
		return base.superGetShadowSize();
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
	public Object entityDropItem(Object itemStack, float par2) {
		return base.superEntityDropItem(itemStack, par2);
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
	public void setPositionAndRotationDirect(double par1, double par3, double par5, float par7, float par8, int par9) {
		base.superSetPositionAndRotationDirect(par1, par3, par5, par7, par8, par9);
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
	public void setPortal() {
		base.superSetPortal();
	}

	@Override
	public int getPortalCooldown() {
		return base.superGetPortalCooldown();
	}

	@Override
	public void setVelocity(double par1, double par3, double par5) {
		base.superSetVelocity(par1, par3, par5);
	}

	@Override
	public void handleStatusUpdate(byte par1) {
		base.superHandleStatusUpdate(par1);
	}

	@Override
	public void performHurtAnimation() {
		base.superPerformHurtAnimation();
	}

	@Override
	public Object[] getInventory() {
		return base.superGetInventory();
	}

	@Override
	public void setCurrentItemOrArmor(int par1, Object itemStack) {
		base.superSetCurrentItemOrArmor(par1, itemStack);
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
	public void setSneaking(boolean par1) {
		base.superSetSneaking(par1);
	}

	@Override
	public boolean isSprinting() {
		return base.superIsSprinting();
	}

	@Override
	public void setSprinting(boolean par1) {
		base.superSetSprinting(par1);
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
	public void setInvisible(boolean par1) {
		base.superSetInvisible(par1);
	}

	@Override
	public boolean isEating() {
		return base.superIsEating();
	}

	@Override
	public void setEating(boolean par1) {
		base.superSetEating(par1);
	}

	@Override
	public boolean getFlag(int par1) {
		return base.superGetFlag(par1);
	}

	@Override
	public void setFlag(int par1, boolean par2) {
		base.superSetFlag(par1, par2);
	}

	@Override
	public int getAir() {
		return base.superGetAir();
	}

	@Override
	public void setAir(int par1) {
		base.superSetAir(par1);
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
	public boolean pushOutOfBlocks(double par1, double par3, double par5) {
		return base.superPushOutOfBlocks(par1, par3, par5);
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
	public void setRotationYawHead(float par1) {
		base.superSetRotationYawHead(par1);
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
	public void copyDataFromOld(Object entity, boolean par2) {
		base.superCopyDataFromOld(entity, par2);
	}

	@Override
	public void travelToDimension(int par1) {
		base.superTravelToDimension(par1);
	}

	@Override
	public float getBlockExplosionResistance(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return base.superGetBlockExplosionResistance(explosion, world, par3, par4, par5, block);
	}

	@Override
	public boolean shouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7) {
		return base.superShouldExplodeBlock(explosion, world, par3, par4, par5, par6, par7);
	}

	@Override
	public int getMaxFallHeight() {
		return base.superGetMaxFallHeight();
	}

	@Override
	public Object getTeleportDirection() {
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
	public String getTranslatedEntityName() {
		return base.superGetTranslatedEntityName();
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
	public void playStepSound(int par1, int par2, int par3, Object par4) {
		base.superPlayStepSound(par1, par2, par3, par4);
	}

	@Override
	public boolean isInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
		return base.superIsInRangeToRender3d(p_145770_1_, p_145770_3_, p_145770_5_);
	}

	@Override
	public Object dropItem(Object par1, int par2) {
		return base.superDropItem(par1, par2);
	}

	@Override
	public Object dropItem(Object par1, int par2, float par3) {
		return base.superDropItemWithOffset(par1, par2, par3);
	}

	@Override
	public boolean shouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, Object par6, float par7) {
		return base.superShouldExplodeBlock(explosion, world, par3, par4, par5, par6, par7);
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
	public Object getSwimSound() {
		return base.superGetSwimSound();
	}

	@Override
	public Object getSplashSound() {
		return base.superGetSplashSound();
	}

	@Override
	public Object getDisplayName() {
		return base.superGetDisplayName();
	}

	@Override
	public void onDataWatcherUpdate(int p_145781_1_) {
		base.superOnDataWatcherUpdate(p_145781_1_);
	}
	// 180~
	@Override
	public void renderParticle(Object tessellator, Object entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		base.superRenderParticle(tessellator, entity, par2, par3, par4, par5, par6, par7);
	}

	@Override
	public void updateFallState(double par1, boolean par3, Object block, Object blockPos) {
		base.superUpdateFallState(par1, par3, block, blockPos);
	}

	@Override
	public void fall(float par1, float damageMultiplier) {
		base.superFall(par1, damageMultiplier);
	}

	@Override
	public void setPositionAndRotationDirect(double par1, double par3, double par5, float par7, float par8, int par9, boolean b) {
		base.superSetPositionAndRotationDirect(par1, par3, par5, par7, par8, par9, b);
	}

	@Override
	public boolean isEntityInvulnerable(Object p_180431_1_) {
		return base.superIsEntityInvulnerable(p_180431_1_);
	}

	@Override
	public void copyDataFromOld(Object entity) {
		base.superCopyDataFromOld(entity);
	}

	@Override
	public void playStepSound(Object blockPos, Object block) {
		base.superPlayStepSound(blockPos, block);
	}

	@Override
	public float getBlockExplosionResistance(Object explosion, Object world, Object blockPos, Object iBlockState) {
		return base.superGetBlockExplosionResistance(explosion, world, blockPos, iBlockState);
	}

	@Override
	public boolean shouldExplodeBlock(Object explosion, Object world, Object blockPos, Object iBlockState, float par7) {
		return base.superShouldExplodeBlock(explosion, world, blockPos, iBlockState, par7);
	}

	@Override
	public void setPortal(Object blockPos) {
		base.superSetPortal(blockPos);
	}

	@Override
	public void setParticleIcon(Object renderEngine, Object icon) {
		base.superSetParticleIcon(renderEngine, icon);
	}

	@Override
	public boolean shouldDisableDepth() {
		return base.superShouldDisableDepth();
	}

	@Override
	public void setMaxAge(int p_187114_1_) {
		base.superSetMaxAge(p_187114_1_);
	}

	@Override
	public void setParticleTexture(Object textureAtlasSprite) {
		base.superSetParticleTexture(textureAtlasSprite);
	}

	@Override
	public void setExpired() {
		base.superSetExpired();
	}

	@Override
	public void resetPositionToBB() {
		base.superResetPositionToBB();
	}

	@Override
	public boolean isAlive() {
		return base.superIsAlive();
	}

	@Override
	public Object getBoundingBox() {
		return base.superGetBoundingBox();
	}

	@Override
	public void setBoundingBox(Object axisAlignedBB) {
		base.superSetBoundingBox(axisAlignedBB);
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
	public float getAlpha() {
		return base.superGetAlpha();
	}

	@Override
	public void onKillCommand() {
		base.superOnKillCommand();

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
	public void resetHeight() {
		base.superResetHeight();

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
	public void moveToBlockPosAndAngles(Object blockPos, float rotationYawIn, float rotationPitchIn) {
		base.superMoveToBlockPosAndAngles(blockPos, rotationYawIn, rotationPitchIn);

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
	public Object getLook(float partialTicks) {
		return base.superGetLook(partialTicks);
	}

	@Override
	public Object getPositionEyes(float partialTicks) {
		return base.superGetPositionEyes(partialTicks);
	}

	@Override
	public Object rayTrace(double blockReachDistance, float partialTicks) {
		return base.superRayTrace(blockReachDistance, partialTicks);
	}

	@Override
	public void func_181013_g(float p_181013_1_) {
		base.superFunc_181013_g(p_181013_1_);

	}

	@Override
	public Object func_181012_aH() {
		return base.superFunc_181012_aH();
	}

	@Override
	public void setCustomNameTag(String name) {
		base.superSetCustomNameTag(name);

	}

	@Override
	public String getCustomNameTag() {
		return base.superGetCustomNameTag();
	}

	@Override
	public boolean hasCustomName() {
		return base.superHasCustomName();
	}

	@Override
	public void setAlwaysRenderNameTag(boolean alwaysRenderNameTag) {
		base.superSetAlwaysRenderNameTag(alwaysRenderNameTag);

	}

	@Override
	public boolean getAlwaysRenderNameTag() {
		return base.superGetAlwaysRenderNameTag();
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
	public void setOutsideBorder(boolean outsideBorder) {
		base.superSetOutsideBorder(outsideBorder);

	}

	@Override
	public boolean replaceItemInInventory(int inventorySlot, Object itemStack) {
		return base.superReplaceItemInInventory(inventorySlot, itemStack);
	}

	@Override
	public void addChatMessage(Object iChatComponent) {
		base.superAddChatMessage(iChatComponent);

	}

	@Override
	public boolean canCommandSenderUseCommand(int permLevel, String commandName) {
		return base.superCanCommandSenderUseCommand(permLevel, commandName);
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
	public void func_174817_o(Object entity) {
		base.superFunc_174817_o(entity);

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
	public boolean hasCapability(Object capability, Object enumFacing) {
		return base.superHasCapability(capability, enumFacing);
	}

	@Override
	public Object getCapability(Object capability, Object enumFacing) {
		return base.superGetCapability(capability, enumFacing);
	}

	@Override
	public void deserializeNBT(Object nBTTagCompound) {
		base.superDeserializeNBT(nBTTagCompound);

	}

	@Override
	public Object serializeNBT() {
		return base.superSerializeNBT();
	}

}
