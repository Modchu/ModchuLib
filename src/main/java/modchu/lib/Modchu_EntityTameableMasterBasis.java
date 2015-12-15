package modchu.lib;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Modchu_EntityTameableMasterBasis implements Modchu_IEntityTameableMaster {
	public Modchu_IEntityTameable base;
	public ConcurrentHashMap<String, Object> freeVariableMap;

	public Modchu_EntityTameableMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IEntityTameable) map.get("base");
	}

	@Override
	public Object getFreeVariable(String s) {
		return freeVariableMap != null ? freeVariableMap.get(s) : null;
	}

	@Override
	public void setFreeVariable(String s, Object o) {
		if (freeVariableMap != null); else freeVariableMap = new ConcurrentHashMap();
		freeVariableMap.put(s, o);
	}
/*
	public String toString() {
		return base.superToString();
	}
*/
	@Override
	public void applyEntityAttributes() {
		base.superApplyEntityAttributes();
	}

	@Override
	public void attackEntity(Object entity, float f) {
		base.superAttackEntity(entity, f);
	}

	@Override
	public boolean attackEntityFrom(Object par1DamageSource, float par2) {
		return base.superAttackEntityFrom(par1DamageSource, par2);
	}

	@Override
	public boolean canBeCollidedWith() {
		return base.superCanBeCollidedWith();
	}

	@Override
	public boolean canDespawn() {
		return base.superCanDespawn();
	}

	@Override
	public Object createChild(Object entityanimal) {
		return null;
	}

	@Override
	public void entityInit() {
		base.superEntityInit();
	}

	@Override
	public Object findPlayerToAttack() {
		return base.superFindPlayerToAttack();
	}

	@Override
	public String getDeathSound() {
		return base.superGetDeathSound();
	}

	@Override
	public float getEyeHeight() {
		return base.superGetEyeHeight();
	}

	@Override
	public Object getHeldItem() {
		return base.superGetHeldItem();
	}

	@Override
	public String getHurtSound() {
		return base.superGetHurtSound();
	}

	@Override
	public String getLivingSound() {
		return base.superGetLivingSound();
	}

	@Override
	public double getMountedYOffset() {
		return base.superGetMountedYOffset();
	}

	@Override
	public Object getOwner() {
		return base.superGetOwner();
	}

	@Override
	public String getOwnerName() {
		return base.superGetOwnerName();
	}

	@Override
	public Object getResourceLocation() {
		return null;
	}

	@Override
	public int getTextureColor() {
		return 0;
	}

	@Override
	public double getYOffset() {
		return base.superGetYOffset();
	}

	@Override
	public void handleHealthUpdate(byte par1) {
		base.superHandleHealthUpdate(par1);
	}

	@Override
	public void heal(float f) {
		base.superHeal(f);
	}

	@Override
	public boolean interact(Object entityplayer) {
		return base.superInteract(entityplayer);
	}

	@Override
	public boolean isAngry() {
		return false;
	}

	@Override
	public boolean isBreedingItem(Object par1ItemStack) {
		return base.superIsBreedingItem(par1ItemStack);
	}

	@Override
	public boolean isEntityInsideOpaqueBlock() {
		return base.superIsEntityInsideOpaqueBlock();
	}

	@Override
	public boolean isInLove() {
		return base.superIsInLove();
	}

	@Override
	public boolean isMovementCeased() {
		return base.superIsMovementCeased();
	}

	@Override
	public boolean isRiding() {
		return base.superIsRiding();
	}

	@Override
	public boolean isSitting() {
		return base.superIsSitting();
	}

	@Override
	public boolean isStanding() {
		return false;
	}

	@Override
	public boolean isTamed() {
		return base.superIsTamed();
	}

	@Override
	public void jump() {
		base.superJump();
	}

	@Override
	public void onLivingUpdate() {
		base.superOnLivingUpdate();
	}

	@Override
	public void onUpdate() {
		base.superOnUpdate();
	}

	@Override
	public void playTameEffect(boolean par1) {
		base.superPlayTameEffect(par1);
	}

	@Override
	public void readEntityFromNBT(Object nbttagcompound) {
		base.superReadEntityFromNBT(nbttagcompound);
	}

	@Override
	public void resetInLove() {
		base.superResetInLove();
	}

	@Override
	public void setAngry(boolean flag) {
	}

	@Override
	public void setAttackTarget(Object par1EntityLiving) {
		base.superSetAttackTarget(par1EntityLiving);
	}

	@Override
	public void setOwner(String s) {
		base.superSetOwner(s);
	}

	@Override
	public void setSitting(boolean flag) {
		base.superSetSitting(flag);
	}

	@Override
	public void setStanding(boolean flag) {
	}

	@Override
	public void setTamed(boolean flag) {
		base.superSetTamed(flag);
	}

	@Override
	public void setTextureColor(int i) {
	}

	@Override
	public void updateEntityActionState() {
		base.superUpdateEntityActionState();
	}

	@Override
	public void writeEntityToNBT(Object nbttagcompound) {
		base.superWriteEntityToNBT(nbttagcompound);
	}

	@Override
	public void setResourceLocation(Object resourceLocation) {
	}

	@Override
	public void onDeathUpdate() {
		base.superOnDeathUpdate();
	}

	@Override
	public boolean shouldAttackEntity(Object entityLivingBase, Object entityLivingBase2) {
		return base.superShouldAttackEntity(entityLivingBase, entityLivingBase2);
	}

	@Override
	public Object getTeam() {
		return base.superGetTeam();
	}

	@Override
	public boolean isOnSameTeam(Object entityLivingBase) {
		return base.superIsOnSameTeam(entityLivingBase);
	}

	@Override
	public void updateAITick() {
		base.superUpdateAITick();
	}

	@Override
	public float getBlockPathWeight(int par1, int par2, int par3) {
		return base.superGetBlockPathWeight(par1, par2, par3);
	}

	@Override
	public boolean getCanSpawnHere() {
		return base.superGetCanSpawnHere();
	}

	@Override
	public int getTalkInterval() {
		return base.superGetTalkInterval();
	}

	@Override
	public int getExperiencePoints(Object entityPlayer) {
		return base.superGetExperiencePoints(entityPlayer);
	}

	@Override
	public void func_146082_f(Object entityPlayer) {
		base.superFunc_146082_f(entityPlayer);
	}

	@Override
	public Object getPlayerInLove() {
		return base.superGetPlayerInLove();
	}

	@Override
	public boolean canMateWith(Object entityAnimal) {
		return base.superCanMateWith(entityAnimal);
	}

	@Override
	public int getGrowingAge() {
		return base.superGetGrowingAge();
	}

	@Override
	public void addGrowth(int par1) {
		base.superAddGrowth(par1);
	}

	@Override
	public void setGrowingAge(int par1) {
		base.superSetGrowingAge(par1);
	}

	@Override
	public boolean isChild() {
		return base.superIsChild();
	}

	@Override
	public void setScaleForAge(boolean par1) {
		base.superSetScaleForAge(par1);
	}

	@Override
	public void updateWanderPath() {
		base.superUpdateWanderPath();
	}

	@Override
	public boolean hasPath() {
		return base.superHasPath();
	}

	@Override
	public void setPathToEntity(Object pathEntity) {
		base.superSetPathToEntity(pathEntity);
	}

	@Override
	public Object getEntityToAttack() {
		return base.superGetEntityToAttack();
	}

	@Override
	public void setTarget(Object entity) {
		base.superSetTarget(entity);
	}

	@Override
	public boolean isWithinHomeDistance(int par1, int par2, int par3) {
		return base.superIsWithinHomeDistance(par1, par2, par3);
	}

	@Override
	public void setHomeArea(int par1, int par2, int par3, int par4) {
		base.superSetHomeArea(par1, par2, par3, par4);
	}

	@Override
	public Object getHomePosition() {
		return base.superGetHomePosition();
	}

	@Override
	public float func_110174_bM() {
		return base.superFunc_110174_bM();
	}

	@Override
	public void detachHome() {
		base.superDetachHome();
	}

	@Override
	public boolean hasHome() {
		return base.superHasHome();
	}

	@Override
	public void updateLeashedState() {
		base.superUpdateLeashedState();
	}

	@Override
	public void func_142017_o(float par1) {
		base.superFunc_142017_o(par1);
	}

	@Override
	public Object getLookHelper() {
		return base.superGetLookHelper();
	}

	@Override
	public Object getMoveHelper() {
		return base.superGetMoveHelper();
	}

	@Override
	public Object getJumpHelper() {
		return base.superGetJumpHelper();
	}

	@Override
	public Object getNavigator() {
		return base.superGetNavigator();
	}

	@Override
	public Object getEntitySenses() {
		return base.superGetEntitySenses();
	}

	@Override
	public Object getAttackTarget() {
		return base.superGetAttackTarget();
	}

	@Override
	public boolean canAttackClass(Class c) {
		return base.superCanAttackClass(c);
	}

	@Override
	public void eatGrassBonus() {
		base.superEatGrassBonus();
	}

	@Override
	public void playLivingSound() {
		base.superPlayLivingSound();
	}

	@Override
	public void onEntityUpdate() {
		base.superOnEntityUpdate();
	}

	@Override
	public void spawnExplosionParticle() {
		base.superSpawnExplosionParticle();
	}

	@Override
	public float func_110146_f(float par1, float par2) {
		return base.superFunc_110146_f(par1, par2);
	}

	@Override
	public Object getDropItem() {
		return base.superGetDropItem();
	}

	@Override
	public void dropFewItems(boolean par1, int par2) {
		base.superDropFewItems(par1, par2);
	}

	@Override
	public void setMoveForward(float par1) {
		base.superSetMoveForward(par1);
	}

	@Override
	public void setAIMoveSpeed(float par1) {
		base.superSetAIMoveSpeed(par1);
	}

	@Override
	public boolean isAIEnabled() {
		return base.superIsAIEnabled();
	}

	@Override
	public void despawnEntity() {
		base.superDespawnEntity();
	}

	@Override
	public void updateAITasks() {
		base.superUpdateAITasks();
	}

	@Override
	public int getVerticalFaceSpeed() {
		return base.superGetVerticalFaceSpeed();
	}

	@Override
	public void faceEntity(Object entity, float par2, float par3) {
		base.superFaceEntity(entity, par2, par3);
	}

	@Override
	public float getRenderSizeModifier() {
		return base.superGetRenderSizeModifier();
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return base.superGetMaxSpawnedInChunk();
	}

	@Override
	public int getMaxSafePointTries() {
		return base.superGetMaxSafePointTries();
	}

	@Override
	public Object getEquipmentInSlot(int par1) {
		return base.superGetEquipmentInSlot(par1);
	}

	@Override
	public Object func_130225_q(int par1) {
		return base.superFunc_130225_q(par1);
	}

	@Override
	public void setCurrentItemOrArmor(int par1, Object itemStack) {
		base.superSetCurrentItemOrArmor(par1, itemStack);
	}

	@Override
	public Object getLastActiveItems() {
		return base.superGetLastActiveItems();
	}

	@Override
	public void dropEquipment(boolean par1, int par2) {
		base.superDropEquipment(par1, par2);
	}

	@Override
	public void addRandomDrop() {
		base.superAddRandomDrop();
	}

	@Override
	public void enchantEquipment() {
		base.superEnchantEquipment();
	}

	@Override
	public Object onInitialSpawn(Object iEntityLivingData) {
		return base.superOnInitialSpawn(iEntityLivingData);
	}

	@Override
	public boolean canBeSteered() {
		return base.superCanBeSteered();
	}

	@Override
	public String getCommandSenderName() {
		return base.superGetCommandSenderName();
	}

	@Override
	public void func_110163_bv() {
		base.superFunc_110163_bv();
	}

	@Override
	public void setCustomNameTag(String par1Str) {
		base.superSetCustomNameTag(par1Str);
	}

	@Override
	public String getCustomNameTag() {
		return base.superGetCustomNameTag();
	}

	@Override
	public boolean hasCustomNameTag() {
		return base.superHasCustomNameTag();
	}

	@Override
	public void setAlwaysRenderNameTag(boolean par1) {
		base.superSetAlwaysRenderNameTag(par1);
	}

	@Override
	public boolean getAlwaysRenderNameTag() {
		return base.superGetAlwaysRenderNameTag();
	}

	@Override
	public boolean getAlwaysRenderNameTagForRender() {
		return base.superGetAlwaysRenderNameTagForRender();
	}

	@Override
	public void setEquipmentDropChance(int par1, float par2) {
		base.superSetEquipmentDropChance(par1, par2);
	}

	@Override
	public boolean canPickUpLoot() {
		return base.superCanPickUpLoot();
	}

	@Override
	public void setCanPickUpLoot(boolean par1) {
		base.superSetCanPickUpLoot(par1);
	}

	@Override
	public boolean isNoDespawnRequired() {
		return base.superIsNoDespawnRequired();
	}

	@Override
	public void clearLeashed(boolean par1, boolean par2) {
		base.superClearLeashed(par1, par2);
	}

	@Override
	public boolean allowLeashing() {
		return base.superAllowLeashing();
	}

	@Override
	public boolean getLeashed() {
		return base.superGetLeashed();
	}

	@Override
	public Object getLeashedToEntity() {
		return base.superGetLeashedToEntity();
	}

	@Override
	public void setLeashedToEntity(Object entity, boolean par2) {
		base.superSetLeashedToEntity(entity, par2);
	}

	@Override
	public void updateFallState(double par1, boolean par3) {
		base.superUpdateFallState(par1, par3);
	}

	@Override
	public boolean canBreatheUnderwater() {
		return base.superCanBreatheUnderwater();
	}

	@Override
	public boolean canDropLoot() {
		return base.superCanDropLoot();
	}

	@Override
	public int decreaseAirSupply(int par1) {
		return base.superDecreaseAirSupply(par1);
	}

	@Override
	public boolean isPlayer() {
		return base.superIsPlayer();
	}

	@Override
	public Random getRNG() {
		return base.superGetRNG();
	}

	@Override
	public Object getAITarget() {
		return base.superGetAITarget();
	}

	@Override
	public int func_142015_aE() {
		return base.superFunc_142015_aE();
	}

	@Override
	public void setRevengeTarget(Object entityLivingBase) {
		base.superSetRevengeTarget(entityLivingBase);
	}

	@Override
	public Object getLastAttacker() {
		return base.superGetLastAttacker();
	}

	@Override
	public int getLastAttackerTime() {
		return base.superGetLastAttackerTime();
	}

	@Override
	public void setLastAttacker(Object entity) {
		base.superSetLastAttacker(entity);
	}

	@Override
	public int getAge() {
		return base.superGetAge();
	}

	@Override
	public void updatePotionEffects() {
		base.superUpdatePotionEffects();
	}

	@Override
	public void clearActivePotions() {
		base.superClearActivePotions();
	}

	@Override
	public Object getActivePotionEffects() {
		return base.superGetActivePotionEffects();
	}

	@Override
	public boolean isPotionActive(int par1) {
		return base.superIsPotionActive(par1);
	}

	@Override
	public boolean isPotionActive(Object potion) {
		return base.superIsPotionActive(potion);
	}

	@Override
	public Object getActivePotionEffect(Object potion) {
		return base.superGetActivePotionEffect(potion);
	}

	@Override
	public void addPotionEffect(Object potionEffect) {
		base.superAddPotionEffect(potionEffect);
	}

	@Override
	public boolean isPotionApplicable(Object potionEffect) {
		return base.superIsPotionApplicable(potionEffect);
	}

	@Override
	public boolean isEntityUndead() {
		return base.superIsEntityUndead();
	}

	@Override
	public void removePotionEffectClient(int par1) {
		base.superRemovePotionEffectClient(par1);
	}

	@Override
	public void removePotionEffect(int par1) {
		base.superRemovePotionEffect(par1);
	}

	@Override
	public void onNewPotionEffect(Object potionEffect) {
		base.superOnNewPotionEffect(potionEffect);
	}

	@Override
	public void onChangedPotionEffect(Object potionEffect, boolean par2) {
		base.superOnChangedPotionEffect(potionEffect, par2);
	}

	@Override
	public void onFinishedPotionEffect(Object potionEffect) {
		base.superOnFinishedPotionEffect(potionEffect);
	}

	@Override
	public void setHealth(float par1) {
		base.superSetHealth(par1);
	}

	@Override
	public void renderBrokenItemStack(Object itemStack) {
		base.superRenderBrokenItemStack(itemStack);
	}

	@Override
	public void onDeath(Object damageSource) {
		base.superOnDeath(damageSource);
	}

	@Override
	public void knockBack(Object entity, float par2, double par3, double par5) {
		base.superKnockBack(entity, par2, par3, par5);
	}

	@Override
	public void dropRareDrop(int par1) {
		base.superDropRareDrop(par1);
	}

	@Override
	public boolean isOnLadder() {
		return base.superIsOnLadder();
	}

	@Override
	public boolean isEntityAlive() {
		return base.superIsEntityAlive();
	}

	@Override
	public void fall(float par1) {
		base.superFall(par1);
	}

	@Override
	public String getFallSoundString(int p_146067_1_) {
		return base.superGetFallSoundString(p_146067_1_);
	}

	@Override
	public void performHurtAnimation() {
		base.superPerformHurtAnimation();
	}

	@Override
	public int getTotalArmorValue() {
		return base.superGetTotalArmorValue();
	}

	@Override
	public void damageArmor(float par1) {
		base.superDamageArmor(par1);
	}

	@Override
	public float applyArmorCalculations(Object damageSource, float par2) {
		return base.superApplyArmorCalculations(damageSource, par2);
	}

	@Override
	public float applyPotionDamageCalculations(Object damageSource, float par2) {
		return base.superApplyPotionDamageCalculations(damageSource, par2);
	}

	@Override
	public void damageEntity(Object damageSource, float par2) {
		base.superDamageEntity(damageSource, par2);
	}

	@Override
	public Object func_110142_aN() {
		return base.superFunc_110142_aN();
	}

	@Override
	public Object func_94060_bK() {
		return base.superFunc_94060_bK();
	}

	@Override
	public void swingItem() {
		base.superSwingItem();
	}

	@Override
	public void kill() {
		base.superKill();
	}

	@Override
	public void updateArmSwingProgress() {
		base.superUpdateArmSwingProgress();
	}

	@Override
	public Object getEntityAttribute(Object iAttribute) {
		return base.superGetEntityAttribute(iAttribute);
	}

	@Override
	public Object getAttributeMap() {
		return base.superGetAttributeMap();
	}

	@Override
	public Object getCreatureAttribute() {
		return base.superGetCreatureAttribute();
	}

	@Override
	public void setSprinting(boolean par1) {
		base.superSetSprinting(par1);
	}

	@Override
	public float getSoundVolume() {
		return base.superGetSoundVolume();
	}

	@Override
	public float getSoundPitch() {
		return base.superGetSoundPitch();
	}

	@Override
	public boolean isMovementBlocked() {
		return base.superIsMovementBlocked();
	}

	@Override
	public void setPositionAndUpdate(double par1, double par3, double par5) {
		base.superSetPositionAndUpdate(par1, par3, par5);
	}

	@Override
	public void dismountEntity(Object entity) {
		base.superDismountEntity(entity);
	}

	@Override
	public Object getItemIcon(Object itemStack, int par2) {
		return base.superGetItemIcon(itemStack, par2);
	}

	@Override
	public void moveEntityWithHeading(float par1, float par2) {
		base.superMoveEntityWithHeading(par1, par2);
	}

	@Override
	public float getAIMoveSpeed() {
		return base.superGetAIMoveSpeed();
	}

	@Override
	public boolean attackEntityAsMob(Object entity) {
		return base.superAttackEntityAsMob(entity);
	}

	@Override
	public boolean isPlayerSleeping() {
		return base.superIsPlayerSleeping();
	}

	@Override
	public void collideWithNearbyEntities() {
		base.superCollideWithNearbyEntities();
	}

	@Override
	public void collideWithEntity(Object entity) {
		base.superCollideWithEntity(entity);
	}

	@Override
	public void updateRidden() {
		base.superUpdateRidden();
	}

	@Override
	public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
		base.superSetPositionAndRotation2(par1, par3, par5, par7, par8, par9);
	}

	@Override
	public void setJumping(boolean par1) {
		base.superSetJumping(par1);
	}

	@Override
	public void onItemPickup(Object entity, int par2) {
		base.superOnItemPickup(entity, par2);
	}

	@Override
	public boolean canEntityBeSeen(Object entity) {
		return base.superCanEntityBeSeen(entity);
	}

	@Override
	public Object getLookVec() {
		return base.superGetLookVec();
	}

	@Override
	public Object getLook(float par1) {
		return base.superGetLook(par1);
	}

	@Override
	public float getSwingProgress(float par1) {
		return base.superGetSwingProgress(par1);
	}

	@Override
	public Object getPosition(float par1) {
		return base.superGetPosition(par1);
	}

	@Override
	public Object rayTrace(double par1, float par3) {
		return base.superRayTrace(par1, par3);
	}

	@Override
	public boolean isClientWorld() {
		return base.superIsClientWorld();
	}

	@Override
	public boolean canBePushed() {
		return base.superCanBePushed();
	}

	@Override
	public void setBeenAttacked() {
		base.superSetBeenAttacked();
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
	public float getAbsorptionAmount() {
		return base.superGetAbsorptionAmount();
	}

	@Override
	public void setAbsorptionAmount(float par1) {
		base.superSetAbsorptionAmount(par1);
	}

	@Override
	public boolean isOnTeam(Object team) {
		return base.superIsOnTeam(team);
	}

	@Override
	public void curePotionEffects(Object itemStack) {
		base.superCurePotionEffects(itemStack);
	}

	@Override
	public boolean shouldRiderFaceForward(Object entityPlayer) {
		return base.superShouldRiderFaceForward(entityPlayer);
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
	public boolean isOffsetPositionInLiquid(double par1, double par3, double par5) {
		return base.superIsOffsetPositionInLiquid(par1, par3, par5);
	}

	@Override
	public void moveEntity(double par1, double par3, double par5) {
		base.superMoveEntity(par1, par3, par5);
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
	public void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Object p_145780_4_) {
		base.superFunc_145780_a(p_145780_1_, p_145780_2_, p_145780_3_, p_145780_4_);
	}

	@Override
	public void playSound(String par1Str, float par2, float par3) {
		base.superPlaySound(par1Str, par2, par3);
	}

	@Override
	public boolean canTriggerWalking() {
		return base.superCanTriggerWalking();
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
	public boolean isNotColliding() {
		return base.superIsNotColliding();
	}

	@Override
	public void moveFlying(float par1, float par2, float par3) {
		base.superMoveFlying(par1, par2, par3);
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
	public void addToPlayerScore(Object entity, int par2) {
		base.superAddToPlayerScore(entity, par2);
	}

	@Override
	public boolean isInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
		return base.superIsInRangeToRender3d(p_145770_1_, p_145770_3_, p_145770_5_);
	}

	@Override
	public boolean isInRangeToRenderDist(double par1) {
		return base.superIsInRangeToRenderDist(par1);
	}

	@Override
	public boolean writeMountToNBT(Object nbtTagCompound) {
		return base.superWriteMountToNBT(nbtTagCompound);
	}

	@Override
	public boolean writeToNBTOptional(Object nbtTagCompound) {
		return base.superWriteToNBTOptional(nbtTagCompound);
	}

	@Override
	public void writeToNBT(Object nbtTagCompound) {
		base.superWriteToNBT(nbtTagCompound);
	}

	@Override
	public void readFromNBT(Object nbtTagCompound) {
		base.superReadFromNBT(nbtTagCompound);
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
	public Object dropItem(Object item, int p_145779_2_) {
		return base.superDropItem(item, p_145779_2_);
	}

	@Override
	public Object dropItemWithOffset(Object item, int p_145778_2_, float p_145778_3_) {
		return base.superDropItemWithOffset(item, p_145778_2_, p_145778_3_);
	}

	@Override
	public Object entityDropItem(Object itemStack, float par2) {
		return base.superEntityDropItem(itemStack, par2);
	}

	@Override
	public float getShadowSize() {
		return base.superGetShadowSize();
	}

	@Override
	public Object getCollisionBox(Object entity) {
		return base.superGetCollisionBox(entity);
	}

	@Override
	public void updateRiderPosition() {
		base.superUpdateRiderPosition();
	}

	@Override
	public void mountEntity(Object entity) {
		base.superMountEntity(entity);
	}

	@Override
	public float getCollisionBorderSize() {
		return base.superGetCollisionBorderSize();
	}

	@Override
	public void setInPortal(Object bockPos) {
		base.superSetInPortal(bockPos);
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
	public boolean isBurning() {
		return base.superIsBurning();
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
	public boolean pushOutOfBlocks(double p_145771_1_, double p_145771_3_, double p_145771_5_) {
		return base.superPushOutOfBlocks(p_145771_1_, p_145771_3_, p_145771_5_);
	}

	@Override
	public void setInWeb() {
		base.superSetInWeb();
	}

	@Override
	public Object getParts() {
		return base.superGetParts();
	}

	@Override
	public boolean isEntityEqual(Object entity) {
		return base.superIsEntityEqual(entity);
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
	public boolean isEntityInvulnerable(Object damageSource) {
		return base.superIsEntityInvulnerable();
	}

	@Override
	public void copyLocationAndAnglesFrom(Object entity) {
		base.superCopyLocationAndAnglesFrom(entity);
	}

	@Override
	public void copyDataFrom(Object entity, boolean par2) {
		base.superCopyDataFrom(entity, par2);
	}

	@Override
	public void travelToDimension(int par1) {
		base.superTravelToDimension(par1);
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
	public Object getDisplayName() {
		return base.superGetDisplayName();
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
	public Object getAISit() {
		return base.superGetAISit();
	}

	@Override
	public Object func_130012_q() {
		return base.superFunc_130012_q();
	}

	@Override
	public void func_110196_bT() {
		base.superFunc_110196_bT();
	}

	@Override
	public boolean func_110173_bK() {
		return base.superFunc_110173_bK();
	}

	@Override
	public boolean func_110176_b(int par1, int par2, int par3) {
		return base.superFunc_110176_b(par1, par2, par3);
	}

	@Override
	public void func_110159_bB() {
		base.superFunc_110159_bB();
	}

	@Override
	public int getDropItemId() {
		return base.superGetDropItemId();
	}

	@Override
	public Object getCurrentItemOrArmor(int par1) {
		return base.superGetCurrentItemOrArmor(par1);
	}

	@Override
	public String getEntityName() {
		return base.superGetEntityName();
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
	public boolean isInRangeToRenderVec3D(Object vec3) {
		return base.superIsInRangeToRenderVec3D(vec3);
	}

	@Override
	public Object dropItemWithOffset(int par1, int par2, float par3) {
		return base.superDropItemWithOffset(par1, par2, par3);
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
	public String getTranslatedEntityName() {
		return base.superGetTranslatedEntityName();
	}

	@Override
	public boolean isWithinHomeDistanceFromPosition(Object blockPos) {
		return base.superIsWithinHomeDistanceFromPosition(blockPos);
	}

	@Override
	public Object onInitialSpawn(Object difficultyInstance, Object iEntityLivingData) {
		return base.superOnInitialSpawn(difficultyInstance, iEntityLivingData);
	}

	@Override
	public void copyDataFrom(Object entity) {
		base.superCopyDataFrom(entity, false);
	}

	@Override
	public boolean verifyExplosion(Object explosion, Object world, Object blockPos, Object iBlockState, float f) {
		return base.superVerifyExplosion(explosion, world, blockPos, iBlockState, f);
	}

	@Override
	public float getBlockPathWeight(Object blockPos) {
		return base.superGetBlockPathWeight(blockPos);
	}

	@Override
	public float getExplosionResistance(Object explosion, Object world, Object blockPos, Object iBlockState) {
		return base.superGetExplosionResistance(explosion, world, blockPos, iBlockState);
	}

	public String func_152113_b() {
		return base.superFunc_152113_b();
	}

	@Override
	public void func_152115_b(String par1Str) {
		base.superFunc_152115_b(par1Str);
	}

	@Override
	public String func_146067_o(int p_146067_1_) {
		return base.superFunc_146067_o(p_146067_1_);
	}

	@Override
	public Object func_145778_a(Object item, int p_145778_2_, float p_145778_3_) {
		return base.superFunc_145778_a(item, p_145778_2_, p_145778_3_);
	}

	@Override
	public void func_98054_a(boolean par1) {
		base.superFunc_98054_a(par1);
	}

	@Override
	public float getSpeedModifier() {
		return base.superGetSpeedModifier();
	}

	@Override
	public int func_96121_ay() {
		return base.superFunc_96121_ay();
	}

	@Override
	public Object getLastAttackingEntity() {
		return base.superGetLastAttackingEntity();
	}

	@Override
	public void setLastAttackingEntity(Object entity) {
		base.superSetLastAttackingEntity(entity);
	}

	@Override
	public float getMaximumHomeDistance() {
		return base.superGetMaximumHomeDistance();
	}

	@Override
	public String getTexture() {
		return base.superGetTexture();
	}

	@Override
	public int getHealthInt() {
		return base.superGetHealthInt();
	}

	@Override
	public float getHealth() {
		return base.superGetHealth();
	}

	@Override
	public void func_85033_bc() {
		base.superFunc_85033_bc();
	}

	@Override
	public boolean isBlocking() {
		return base.superIsBlocking();
	}

	@Override
	public int func_82143_as() {
		return base.superFunc_82143_as();
	}

	@Override
	public Object getCurrentArmor(int par1) {
		return base.superGetCurrentArmor(par1);
	}

	@Override
	public void func_82162_bC() {
		base.superFunc_82162_bC();
	}

	@Override
	public void initCreature() {
		base.superInitCreature();
	}

	@Override
	public void func_94058_c(String par1Str) {
		base.superFunc_94058_c(par1Str);
	}

	@Override
	public String func_94057_bL() {
		return base.superFunc_94057_bL();
	}

	@Override
	public boolean func_94056_bM() {
		return base.superFunc_94056_bM();
	}

	@Override
	public void func_94061_f(boolean par1) {
		base.superFunc_94061_f(par1);
	}

	@Override
	public boolean func_94062_bN() {
		return base.superFunc_94062_bN();
	}

	@Override
	public boolean func_94059_bO() {
		return base.superFunc_94059_bO();
	}

	@Override
	public void func_96120_a(int par1, float par2) {
		base.superFunc_96120_a(par1, par2);
	}

	@Override
	public boolean func_104002_bU() {
		return base.superFunc_104002_bU();
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
	public boolean func_98034_c(Object entityPlayer) {
		return base.superFunc_98034_c(entityPlayer);
	}

	@Override
	public boolean func_85031_j(Object entity) {
		return base.superFunc_85031_j(entity);
	}

	@Override
	public void func_82149_j(Object entity) {
		base.superFunc_82149_j(entity);
	}

	@Override
	public float func_82146_a(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return base.superFunc_82146_a(explosion, world, par3, par4, par5, block);
	}

	@Override
	public boolean func_96091_a(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7) {
		return base.superFunc_96091_a(explosion, world, par3, par4, par5, par6, par7);
	}

	@Override
	public void func_85029_a(Object crashReportCategory) {
		base.superFunc_85029_a(crashReportCategory);
	}

	@Override
	public boolean func_96092_aw() {
		return base.superFunc_96092_aw();
	}

	@Override
	public boolean isWithinHomeDistanceCurrentPosition() {
		return base.superIsWithinHomeDistanceCurrentPosition();
	}
}