package modchu.lib;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Modchu_EntityTameableMasterBasis implements Modchu_IEntityTameableMaster {
	public Modchu_IEntityTameable base;
	public ConcurrentHashMap<String, Object> freeVariableMap;
	public static HashMap<Integer, HashMap> debugDataWatcherEntityMap = new HashMap();
	public HashMap<Integer, Object> debugDataWatcherMap;
	public int tempIsRiding;
	public int damageInvincibleCount;
	public int checkUUIDCount = 2;

	public Modchu_EntityTameableMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IEntityTameable) map.get("base");
		boolean isRemote = Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, base);
		if (!isRemote) {
			debugDataWatcherMap = new HashMap();
			debugDataWatcherEntityMap.put(getEntityId(), debugDataWatcherMap);
		}
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
	public int getDamageInvincibleCount() {
		return damageInvincibleCount;
	}

	@Override
	public void setDamageInvincibleCount(int i) {
		damageInvincibleCount = i;
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
		boolean isRemote = Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, base);
		int ticksExisted = Modchu_AS.getInt(Modchu_AS.entityTicksExisted, base);
		if (!isRemote
				&& ticksExisted < 300) return false;
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
	public Object getDeathSound() {
		return base.superGetDeathSound();
	}

	@Override
	public float getEyeHeight() {
		return base.superGetEyeHeight();
	}

	@Override
	public Object getHeldItemMainhand() {
		return base.superGetHeldItemMainhand();
	}

	@Override
	public Object getHurtSound(Object damageSource) {
		return base.superGetHurtSound(damageSource);
	}

	@Override
	public Object getAmbientSound() {
		return base.superGetAmbientSound();
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
	public Object getOwnerName() {
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
	public void handleStatusUpdate(byte par1) {
		base.superHandleStatusUpdate(par1);
	}

	@Override
	public void heal(float f) {
		base.superHeal(f);
	}

	@Override
	public boolean processInteract(Object entityplayer) {
		return base.superProcessInteract(entityplayer);
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
		boolean b = isRiding2()
				&& tempIsRiding > 0;
		if (tempIsRiding > 0) {
			tempIsRiding--;
		}
		return b;
		//return base.superIsRiding();
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
		int i = getDamageInvincibleCount();
		if (i > 0) {
			i--;
			setDamageInvincibleCount(i);
			//Modchu_Debug.mdDebug("onLivingUpdate i="+i, 1);
		}
		base.superOnLivingUpdate();
	}

	@Override
	public void onUpdate() {
		boolean debug = false;
		boolean debugDead = Modchu_AS.getBoolean(base.getClass(), "debugDead", base);
		if (debug) Modchu_Debug.mDebug("Modchu_EntityTameableMasterBasis onUpdate");
		if (debugDead) setDead();
		checkUUID();
		boolean isRemote = Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, base);
		if (!isRemote) {
			int version = Modchu_Main.getMinecraftVersion();
			if (version > 179) {
				Object attributeMap = getAttributeMap();
				int ticksExisted = Modchu_AS.getInt(Modchu_AS.entityTicksExisted, base);
				if (ticksExisted % 20 == 0) {
					Object combatTracker = Modchu_AS.get(base.getClass(), "getCombatTracker2", base);
					//Modchu_Debug.lDebug("Modchu_EntityTameableMasterBasis onUpdate combatTracker="+combatTracker);
					Modchu_AS.set("CombatTracker", "reset", combatTracker);
					ticksExisted++;
					Modchu_AS.set(Modchu_AS.entityTicksExisted, base, ticksExisted);
				}
			}
		} else {
			if (debug) {
				// TODO debug用
				int i1 = Modchu_CastHelper.Int(Modchu_Debug.getFreeVariable("Modchu_EntityTameable_debugCount"));
				i1++;
				//Modchu_Debug.mDebug("Modchu_EntityTameableMasterBasis onUpdate i1="+i1);
				Modchu_Debug.setFreeVariable("Modchu_EntityTameable_debugCount", i1);
			}
		}
		base.superOnUpdate();
	}

	protected void checkUUID() {
		if (checkUUIDCount < 0) return;
		if (checkUUIDCount > 0) {
			checkUUIDCount--;
			return;
		}
		Object worldObj = Modchu_AS.get(Modchu_AS.entityWorldObj, base);
		List loadedEntityList = Modchu_AS.getList(Modchu_AS.worldLoadedEntityList, worldObj);
		boolean flag = false;
		if (loadedEntityList != null
				&& !loadedEntityList.isEmpty())
		for (Object entity : loadedEntityList) {
			if (entity instanceof Modchu_IEntityTameable) {
				UUID entityUniqueID = Modchu_AS.getUUID(Modchu_AS.entityGetUniqueID, base);
				UUID uuid = Modchu_AS.getUUID(Modchu_AS.entityGetUniqueID, entity);
				if (entityUniqueID.equals(uuid)) {
					if (flag) {
						Modchu_Debug.mDebug("Modchu_EntityTameableMasterBasis checkUUID isDead base="+base);
						Modchu_Debug.mDebug("Modchu_EntityTameableMasterBasis checkUUID isDead entityUniqueID="+entityUniqueID);
						Modchu_AS.set(Modchu_AS.entityLivingBaseSetHealth, base, 0.0F);
						Modchu_AS.set(Modchu_AS.entityLivingBaseDeathTime, base, 20);
						setDead();
						return;
					} else {
						flag = true;
					}
				}
			}
		}
		checkUUIDCount = -1;
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
	public void setOwner(Object uUIDOrString) {
		base.superSetOwner(uUIDOrString);
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
	public void handleJumpWater() {
		base.superHandleJumpWater();
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
	public void setInLove(Object entityPlayer) {
		base.superSetInLove(entityPlayer);
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
	public float getMaximumHomeDistance() {
		return base.superGetMaximumHomeDistance();
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
	public void onLeashDistance(float par1) {
		base.superOnLeashDistance(par1);
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
	public float updateDistance(float par1, float par2) {
		return base.superUpdateDistance(par1, par2);
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
	public Object func_130225_q(int par1) {
		return base.superGetCurrentArmor(par1);
	}

	@Override
	public void setItemStackToSlot(int par1, Object itemStack) {
		base.superSetItemStackToSlot(par1, itemStack);
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
	public void enchantEquipment() {
		base.superEnchantEquipment();
	}

	@Override
	public boolean canBeSteered() {
		return base.superCanBeSteered();
	}

	@Override
	public String getName() {
		return base.superGetName();
	}

	@Override
	public void enablePersistence() {
		base.superEnablePersistence();
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
	public void setDropChance(Object entityEquipmentSlotOrInt, float par2) {
		base.superSetDropChance(entityEquipmentSlotOrInt, par2);
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
	public boolean canBeLeashedTo() {
		return base.superCanBeLeashedTo();
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
	public Object getRevengeTarget() {
		return base.superGetRevengeTarget();
	}

	@Override
	public int getRevengeTimer() {
		return base.superGetRevengeTimer();
	}

	@Override
	public void setRevengeTarget(Object entityLivingBase) {
		base.superSetRevengeTarget(entityLivingBase);
	}

	@Override
	public Object getLastAttackedEntity() {
		return base.superGetLastAttackedEntity();
	}

	@Override
	public int getLastAttackedEntityTime() {
		return base.superGetLastAttackedEntityTime();
	}

	@Override
	public void setLastAttackedEntity(Object entity) {
		base.superSetLastAttackedEntity(entity);
	}

	@Override
	public int getIdleTime() {
		return base.superGetIdleTime();
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
	public Object getFallSound(int p_146067_1_) {
		return base.superGetFallSound(p_146067_1_);
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
	public Object applyArmorCalculations(Object damageSource, float par2) {
		return base.superApplyArmorCalculations(damageSource, par2);
	}

	@Override
	public Object applyPotionDamageCalculations(Object damageSource, float par2) {
		return base.superApplyPotionDamageCalculations(damageSource, par2);
	}

	@Override
	public void damageEntity(Object damageSource, float par2) {
		base.superDamageEntity(damageSource, par2);
	}

	@Override
	public Object getCombatTracker() {
		return base.superGetCombatTracker();
	}

	@Override
	public Object getAttackingEntity() {
		return base.superGetAttackingEntity();
	}

	@Override
	public void swingArm() {
		base.superSwingArm();
	}

	@Override
	public void outOfWorld() {
		base.superOutOfWorld();
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
	public void moveEntityWithHeading(float par1, float par2, float par3) {
		base.superMoveEntityWithHeading(par1, par2, par3);
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
	public void setPositionAndRotationDirect(double par1, double par3, double par5, float par7, float par8, int par9) {
		base.superSetPositionAndRotationDirect(par1, par3, par5, par7, par8, par9);
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
	public void setRotation(float par1, float par2) {
		base.superSetRotation(par1, par2);
	}

	@Override
	public void setPosition(double par1, double par3, double par5) {
		base.superSetPosition(par1, par3, par5);
	}

	@Override
	public void turn(float par1, float par2) {
		base.superTurn(par1, par2);
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
	public void move(Object moverType, double par1, double par3, double par5) {
		base.superMove(moverType, par1, par3, par5);
	}

	@Override
	public Object getSwimSound() {
		return base.superGetSwimSound();
	}

	@Override
	public void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Object p_145780_4_) {
		base.superFunc_145780_a(p_145780_1_, p_145780_2_, p_145780_3_, p_145780_4_);
	}

	@Override
	public void playSound(Object soundEventOrString, float par2, float par3) {
		base.superPlaySound(soundEventOrString, par2, par3);
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
	public Object getSplashSound() {
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
	public void moveRelative(float par1, float par2, float par3, float par4) {
		base.superMoveRelative(par1, par2, par3, par4);
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
	public void addToPlayerScore(Object entity, int par2, Object damageSource) {
		base.superAddToPlayerScore(entity, par2, damageSource);
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
	public boolean writeToNBTAtomically(Object nbtTagCompound) {
		return base.superWriteToNBTAtomically(nbtTagCompound);
	}

	@Override
	public boolean writeToNBTOptional(Object nbtTagCompound) {
		return base.superWriteToNBTOptional(nbtTagCompound);
	}

	@Override
	public Object writeToNBT(Object nbtTagCompound) {
		return base.superWriteToNBT(nbtTagCompound);
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
	public void updatePassenger() {
		base.superUpdatePassenger();
	}

	@Override
	public boolean startRiding(Object entity) {
		Modchu_Debug.mDebug("Modchu_EntityTameableMasterBasis superStartRiding old entity="+entity);
		return base.superStartRiding(entity);
	}

	@Override
	public float getCollisionBorderSize() {
		return base.superGetCollisionBorderSize();
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
	public boolean canBeAttackedWithItem() {
		return base.superCanBeAttackedWithItem();
	}

	@Override
	public boolean hitByEntity(Object entity) {
		return base.superHitByEntity(entity);
	}

	@Override
	public boolean isEntityInvulnerable(Object damageSource) {
		return base.superIsEntityInvulnerable(damageSource);
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
	public Object changeDimension(int par1) {
		return base.superChangeDimension(par1);
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
	public boolean func_110176_b(int par1, int par2, int par3) {
		return base.superFunc_110176_b(par1, par2, par3);
	}

	@Override
	public int getDropItemId() {
		return base.superGetDropItemId();
	}

	@Override
	public void doBlockCollisions() {
		base.superDoBlockCollisions();

	}

	@Override
	public void playStepSound(int par1, int par2, int par3, Object par4) {
		base.superPlayStepSound(par1, par2, par3, par4);
	}

	@Override
	public boolean isInRangeToRender3d(Object vec3) {
		return base.superIsInRangeToRender3d(vec3);
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
	public boolean shouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, Object par6, float par7) {
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
	public boolean canExplosionDestroyBlock(Object explosion, Object world, Object blockPos, Object iBlockState, float f) {
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
	public String getTexture() {
		return base.superGetTexture();
	}

	@Override
	public int getHealthInt() {
		return base.superGetHealthInt();
	}

	@Override
	public Object getHealth() {
		return base.superGetHealth();
	}

	@Override
	public boolean isBlocking() {
		return base.superIsBlocking();
	}

	@Override
	public Object getItemStackFromSlot(Object entityEquipmentSlotOrInt) {
		return base.superGetItemStackFromSlot(entityEquipmentSlotOrInt);
	}

	@Override
	public void func_82162_bC() {
		base.superFunc_82162_bC();
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
	public boolean func_94062_bN() {
		return base.superFunc_94062_bN();
	}

	@Override
	public void func_96120_a(int par1, float par2) {
		base.superFunc_96120_a(par1, par2);
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

	@Override
	public boolean isWithinHomeDistanceCurrentPosition() {
		return base.superIsWithinHomeDistanceCurrentPosition();
	}

	@Override
	public void heal(int par1) {
		base.superHeal(par1);
	}

	@Override
	public void setEntityHealth(int par1) {
		base.superSetHealth(par1);
	}

	@Override
	public void damageArmor(int par1) {
		base.superDamageArmor(par1);
	}

	@Override
	public Object applyArmorCalculations(Object damageSource, int par2) {
		return base.superApplyArmorCalculations(damageSource, par2);
	}

	@Override
	public Object applyPotionDamageCalculations(Object damageSource, int par2) {
		return base.superApplyPotionDamageCalculations(damageSource, par2);
	}

	@Override
	public void damageEntity(Object damageSource, int par2) {
		base.superDamageEntity(damageSource, par2);
	}

	@Override
	public void knockBack(Object entity, int par2, double par3, double par5) {
		base.superKnockBack(entity, par2, par3, par5);
	}

	@Override
	public void onChangedPotionEffect(Object potionEffect) {
		base.superOnChangedPotionEffect(potionEffect);
	}

	@Override
	public void setInPortal() {
		base.superSetPortal();
	}

	@Override
	public void setSize(float p_70105_1_, float p_70105_2_) {
		base.superSetSize(p_70105_1_, p_70105_2_);
	}

	@Override
	public boolean handleLavaMovement() {
		return base.superIsNotColliding();
	}

	@Override
	public boolean processInitialInteract(Object entityPlayer) {
		return base.superProcessInitialInteract(entityPlayer);
	}

	@Override
	public boolean isEntityInvulnerable() {
		return base.superIsEntityInvulnerable();
	}

	@Override
	public Object dropItem(int par1, int par2) {
		return base.superDropItem(par1, par2);
	}

	@Override
	public boolean attackEntityFrom(Object damageSource, int par2) {
		return base.superAttackEntityFrom(damageSource, par2);
	}

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
	public Object getPositionEyes(float p_174824_1_) {
		return base.superGetPositionEyes(p_174824_1_);
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
	public void copyDataFromOld(Object entity) {
		base.superCopyDataFromOld(entity);
	}

	@Override
	public int getMaxFallHeight() {
		return base.superGetMaxFallHeight();
	}

	@Override
	public boolean hasCustomName() {
		return base.superHasCustomName();
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
	public boolean isServerWorld() {
		return base.superIsServerWorld();
	}

	@Override
	public void setupTamedAI() {
		base.superSetupTamedAI();
	}

	@Override
	public boolean isOwner(Object entityLivingBase) {
		return base.superIsOwner(entityLivingBase);
	}

	@Override
	public void consumeItemFromStack(Object entityPlayer, Object itemStack) {
		base.superConsumeItemFromStack(entityPlayer, itemStack);
	}

	@Override
	public void ageUp(int p_175501_1_, boolean p_175501_2_) {
		base.superAgeUp(p_175501_1_, p_175501_2_);
	}

	@Override
	public void onGrowingAdult() {
		base.superOnGrowingAdult();
	}

	@Override
	public void setHomePosAndDistance(Object blockPos, int distance) {
		base.superSetHomePosAndDistance(blockPos, distance);
	}

	@Override
	public Object createNavigator(Object world) {
		return base.superCreateNavigator(world);
	}

	@Override
	public void updateEquipmentIfNeeded(Object entityItem) {
		base.superUpdateEquipmentIfNeeded(entityItem);
	}

	@Override
	public boolean canEquipItem(Object itemStack) {
		return base.superCanEquipItem(itemStack);
	}

	@Override
	public void setEquipmentBasedOnDifficulty(Object difficultyInstance) {
		base.superSetEquipmentBasedOnDifficulty(difficultyInstance);
	}

	@Override
	public void setEnchantmentBasedOnDifficulty(Object difficultyInstance) {
		base.superSetEnchantmentBasedOnDifficulty(difficultyInstance);
	}

	@Override
	public void setNoAI(boolean disable) {
		base.superSetNoAI(disable);
	}

	@Override
	public boolean isAIDisabled() {
		return base.superIsAIDisabled();
	}

	@Override
	public void updatePotionMetadata() {
		base.superUpdatePotionMetadata();
	}

	@Override
	public void resetPotionEffectMetadata() {
		base.superResetPotionEffectMetadata();
	}

	@Override
	public float getJumpUpwardsMotion() {
		return base.superGetJumpUpwardsMotion();
	}

	@Override
	public void handleJumpLava() {
		base.superHandleJumpLava();
	}

	@Override
	public void setRenderYawOffset(float p_181013_1_) {
		base.superSetRenderYawOffset(p_181013_1_);
	}

	@Override
	public void sendEnterCombat() {
		base.superSendEnterCombat();
	}

	@Override
	public void sendEndCombat() {
		base.superSendEndCombat();
	}

	@Override
	public void markPotionsDirty() {
		base.superMarkPotionsDirty();
	}

	@Override
	public String getCommandSenderName() {
		return base.superGetCommandSenderName();
	}

	@Override
	public Object getLastPortalVec() {
		return base.superGetLastPortalVec();
	}

	@Override
	public Object getItemStackFromSlot(int par1) {
		return base.superGetItemStackFromSlot(par1);
	}

	@Override
	public void swingArm(Object enumHand) {
		base.superSwingArm(enumHand);
	}

	@Override
	public void updatePassenger(Object entity) {
		base.superUpdatePassenger(entity);
	}

	@Override
	public void dropLoot(boolean p_184610_1_, int p_184610_2_, Object damageSource) {
		base.superDropLoot(p_184610_1_, p_184610_2_, damageSource);
	}

	@Override
	public void frostWalk(Object blockPos) {
		base.superFrostWalk(blockPos);
	}

	@Override
	public void playEquipSound(Object itemStack) {
		base.superPlayEquipSound(itemStack);
	}

	@Override
	public Object removeActivePotionEffect(Object potion) {
		return base.superRemoveActivePotionEffect(potion);
	}

	@Override
	public void removePotionEffect(Object potion) {
		base.superRemovePotionEffect(potion);
	}

	@Override
	public void playHurtSound(Object damageSource) {
		base.superPlayHurtSound(damageSource);
	}

	@Override
	public void damageShield(float p_184590_1_) {
		base.superDamageShield(p_184590_1_);
	}

	@Override
	public Object getHeldItemOffhand() {
		return base.superGetHeldItemOffhand();
	}

	@Override
	public Object getHeldItem(Object enumHand) {
		return base.superGetHeldItem(enumHand);
	}

	@Override
	public void setHeldItem(Object enumHand, Object itemStack) {
		base.superSetHeldItem(enumHand, itemStack);
	}

	@Override
	public boolean isHandActive() {
		return base.superIsHandActive();
	}

	@Override
	public Object getActiveHand() {
		return base.superGetActiveHand();
	}

	@Override
	public void updateActiveHand() {
		base.superUpdateActiveHand();
	}

	@Override
	public void setActiveHand(Object enumHand) {
		base.superSetActiveHand(enumHand);
	}

	@Override
	public void updateItemUse(Object itemStack, int p_184584_2_) {
		base.superUpdateItemUse(itemStack, p_184584_2_);
	}

	@Override
	public void onItemUseFinish() {
		base.superOnItemUseFinish();
	}

	@Override
	public Object getActiveItemStack() {
		return base.superGetActiveItemStack();
	}

	@Override
	public int getItemInUseCount() {
		return base.superGetItemInUseCount();
	}

	@Override
	public int getItemInUseMaxCount() {
		return base.superGetItemInUseMaxCount();
	}

	@Override
	public void stopActiveHand() {
		base.superStopActiveHand();
	}

	@Override
	public void resetActiveHand() {
		base.superResetActiveHand();
	}

	@Override
	public boolean isActiveItemStackBlocking() {
		return base.superIsActiveItemStackBlocking();
	}

	@Override
	public boolean isElytraFlying() {
		return base.superIsElytraFlying();
	}

	@Override
	public int getTicksElytraFlying() {
		return base.superGetTicksElytraFlying();
	}

	@Override
	public boolean attemptTeleport(double x, double y, double z) {
		return base.superAttemptTeleport(x, y, z);
	}

	@Override
	public boolean canBeHitWithPotion() {
		return base.superCanBeHitWithPotion();
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
	public void applyOrientationToEntity(Object entity) {
		base.superApplyOrientationToEntity(entity);
	}

	@Override
	public boolean startRiding(Object entity, boolean force) {
		int version = Modchu_Main.getMinecraftVersion();
		Modchu_Debug.mDebug("Modchu_EntityTameableMasterBasis superStartRiding entity="+entity);
		if (version < 190) return base.superStartRiding(entity, force);
/*
		if (ridingEntity2 != null) {
			ridingEntity2.dismountRidingEntity();
		}
*/
		// TODO Riding2
		if (entity != null) {
			setRidingEntityId(Modchu_AS.getInt(Modchu_AS.entityEntityID, entity));
			Modchu_AS.set("Entity", "addPassenger", new Class[]{ Modchu_Reflect.loadClass("Entity") }, entity, new Object[]{ base });
		} else {
			dismountRidingEntity2();
		}
		//Modchu_Debug.mDebug("Modchu_EntityTameableMasterBasis superStartRiding entity="+entity);
		//Modchu_Debug.mDebug("Modchu_EntityTameableMasterBasis superStartRiding getRidingEntity2="+getRidingEntityID());
		return true;
	}

	@Override
	public boolean canBeRidden(Object entity) {
		// TODO Riding2
		return false;
		//return base.superCanBeRidden(entity);
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
	public boolean isOnScoreboardTeam(Object team) {
		return base.superIsOnScoreboardTeam(team);
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
	public boolean processInteract(Object entityPlayer, Object enumHand, Object itemStack) {
		return base.superProcessInteract(entityPlayer, enumHand, itemStack);
	}

	@Override
	public float getPathPriority(Object pathNodeType) {
		return base.superGetPathPriority(pathNodeType);
	}

	@Override
	public void initEntityAI() {
		base.superInitEntityAI();
	}

	@Override
	public void setPathPriority(Object pathNodeType, float p_184644_2_) {
		base.superSetPathPriority(pathNodeType, p_184644_2_);
	}

	@Override
	public Object createBodyHelper() {
		return base.superCreateBodyHelper();
	}

	@Override
	public Object getLootTable() {
		return base.superGetLootTable();
	}

	@Override
	public void setMoveStrafing(float p_184646_1_) {
		base.superSetMoveStrafing(p_184646_1_);
	}

	@Override
	public int getHorizontalFaceSpeed() {
		return base.superGetHorizontalFaceSpeed();
	}

	@Override
	public Object getPrimaryHand() {
		return base.superGetPrimaryHand();
	}

	@Override
	public void setLeftHanded(boolean p_184641_1_) {
		base.superSetLeftHanded(p_184641_1_);
	}

	@Override
	public boolean isLeftHanded() {
		return base.superIsLeftHanded();
	}

	@Override
	public Object getTeleportDirection() {
		return base.superGetLastPortalVec();
	}

	@Override
	public Object getLivingSound() {
		return base.superGetAmbientSound();
	}

	@Override
	public void setCurrentItemOrArmor(int p_70062_1_, Object itemStack) {
		base.superSetCurrentItemOrArmor(p_70062_1_, itemStack);
	}

	@Override
	public Object getCurrentItemOrArmor(int par1) {
		return base.superGetCurrentItemOrArmor(par1);
	}

	@Override
	public Object getCurrentArmor(int par1) {
		return base.superGetCurrentArmor(par1);
	}

	@Override
	public void addRandomArmor() {
		base.superAddRandomArmor();
	}

	@Override
	public Object onSpawnWithEgg(Object entityLivingData) {
		return base.superOnSpawnWithEgg(entityLivingData);
	}

	@Override
	public void setDropChance(int par1, float par2) {
		base.superSetDropChance(par1, par2);
	}

	@Override
	public boolean interact(Object entityPlayer) {
		return base.superInteract(entityPlayer);
	}

	@Override
	public boolean allowLeashing() {
		return base.superAllowLeashing();
	}

	@Override
	public void init() {
		base.superInit();
	}

	@Override
	public void setMaxHealth(Object floatOrInt) {
		base.superSetMaxHealth(floatOrInt);
	}

	@Override
	public void dropLoot() {
		base.superDropLoot();
	}

	@Override
	public int hashCode() {
		return base.superHashCode();
	}

	@Override
	public boolean equals(Object o) {
		return base.superEquals(o);
	}

	@Override
	public String thisToString() {
		return getClass().getName() + "@" + Integer.toHexString(super.hashCode());
	}

	@Override
	public boolean isOnLivingUpdateCancel() {
		return base.superIsOnLivingUpdateCancel();
	}

	@Override
	public Object getRidingEntity2() {
		// TODO Riding2
		boolean debug = false;
		int version = Modchu_Main.getMinecraftVersion();
		if (version < 190) return base.superGetRidingEntity();
		int ridingEntity2 = getRidingEntityID();
		if (debug) Modchu_Debug.mDebug("Modchu_EntityTameableMasterBasis superGetRidingEntity2 ridingEntity2="+ridingEntity2);
		if (ridingEntity2 != 0) {
			Object worldObj = Modchu_AS.get(Modchu_AS.entityWorldObj, base);
			Object entity = Modchu_AS.get("World", "getEntityByID", new Class[]{ int.class }, worldObj, new Object[]{ ridingEntity2 });
			if (debug) Modchu_Debug.mDebug("Modchu_EntityTameableMasterBasis superGetRidingEntity2 entity="+entity);
			return entity;
		}
		return null;
	}

	@Override
	public boolean isRiding2() {
		return getRidingEntity2() != null;
		//return base.superIsRiding2();
	}

	@Override
	public void dismountRidingEntity2() {
		base.superDismountRidingEntity2();
	}

	@Override
	public void sendDeathMessage(Object damageSource) {
		Modchu_Debug.mDebug("Modchu_EntityTameableMasterBasis superSendDeathMessage canSendDeathMessage()="+canSendDeathMessage());
		if (canSendDeathMessage()) {
			Object combatTracker = Modchu_AS.get(base.getClass(), "getCombatTracker2", base);
			Object iTextComponent = Modchu_AS.get("CombatTracker", "getDeathMessage", combatTracker);
			String s = Modchu_AS.getString("ITextComponent", "getUnformattedText", iTextComponent);
			Modchu_Debug.mDebug("Modchu_EntityTameableMasterBasis superSendDeathMessage s="+s);
			if (s != null
					&& !s.isEmpty()); else return;
			String s1 = Modchu_CastHelper.String(getFreeVariable("tempSendDeathMessage"));
			if (s1 == null
					| (s1 != null
					&& !s.equalsIgnoreCase(s1))) {
				int version = Modchu_Main.getMinecraftVersion();
				Modchu_AS.set("EntityPlayerMP", version > 190 ? "sendMessage" : "addChatMessage", getOwner(), iTextComponent);
				setFreeVariable("tempSendDeathMessage", s);
				Modchu_Debug.mDebug("Modchu_EntityTameableMasterBasis superSendDeathMessage sendMessage");
			}
		}
	}

	@Override
	public boolean canSendDeathMessage() {
		Object worldObj = Modchu_AS.get(Modchu_AS.entityWorldObj, base);
		Modchu_Debug.mDebug("Modchu_EntityTameableMasterBasis superCanSendDeathMessage hasCustomName()="+hasCustomName());
		Modchu_Debug.mDebug("Modchu_EntityTameableMasterBasis superCanSendDeathMessage worldObj.getGameRules().getBoolean(\"showDeathMessages\")="+Modchu_AS.getBoolean("GameRules", "getBoolean", new Class[]{ String.class }, Modchu_AS.get("World", "getGameRules", worldObj), new Object[]{ "showDeathMessages" }));
		Modchu_Debug.mDebug("Modchu_EntityTameableMasterBasis superCanSendDeathMessage getOwner() instanceof EntityPlayerMP="+Modchu_Reflect.loadClass("EntityPlayerMP").isInstance(getOwner()));
		boolean isRemote = Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, base);
		return !isRemote
				&& Modchu_AS.getBoolean("GameRules", "getBoolean", new Class[]{ String.class }, Modchu_AS.get("World", "getGameRules", worldObj), new Object[]{ "showDeathMessages" })
				&& hasCustomName()
				&& Modchu_Reflect.loadClass("EntityPlayerMP").isInstance(getOwner());
	}

	@Override
	public void updateRidden2() {
		boolean debug = false;
		Object entity = getRidingEntity2();
		if (debug) {
			Modchu_Debug.mDebug("Modchu_EntityTameableMasterBasis updateRidden2 entity="+entity);
			Modchu_Debug.mDebug("Modchu_EntityTameableMasterBasis updateRidden2 isRiding2()="+isRiding2());
		}
		if (isRiding2()
				&& Modchu_AS.getBoolean(Modchu_AS.entityIsDead, entity)) {
			dismountRidingEntity2();
		} else {
			if (isRiding2()) {
				double entityPosX = Modchu_AS.getDouble(Modchu_AS.entityPosX, entity);
				double entityPosY = Modchu_AS.getDouble(Modchu_AS.entityPosY, entity);
				double entityPosZ = Modchu_AS.getDouble(Modchu_AS.entityPosZ, entity);
				setPosition(entityPosX, entityPosY + Modchu_AS.getDouble("Entity", "getMountedYOffset", entity) + getYOffset(), entityPosZ);
				if (debug) {
					double posX = Modchu_AS.getDouble(Modchu_AS.entityPosX, base);
					double posY = Modchu_AS.getDouble(Modchu_AS.entityPosY, base);
					double posZ = Modchu_AS.getDouble(Modchu_AS.entityPosZ, base);
					Modchu_Debug.mDebug("Modchu_EntityTameableMasterBasis updateRidden2 isRiding2");
					Modchu_Debug.mdDebug("posX="+posX+" posY="+posY+" posZ="+posZ);
					Modchu_Debug.mdDebug("entityPosX="+entityPosX+" entityPosY="+entityPosY+" entityPosZ="+entityPosZ, 1);
				}
			}
		}
	}

	@Override
	public int getRidingEntityID() {
		// TODO
		Object o = base.getDataWatcherWatchableObject(16);
		return o instanceof Integer ? (Integer) o : 0;
	}

	@Override
	public void setRidingEntityId(int i) {
		base.setDataWatcherWatchableObject(16, i);
	}

	@Override
	public boolean isDamageInvincible() {
		return getDamageInvincibleCount() > 0;
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
	public Object func_110172_bL() {
		return base.superFunc_110172_bL();
	}

	@Override
	public Object getNewNavigator(Object world) {
		return base.superGetNewNavigator(world);
	}

	@Override
	public String getCachedUniqueIdString() {
		return base.superGetCachedUniqueIdString();
	}

	@Override
	public void setAngles(float yaw, float pitch) {
		base.superSetAngles(yaw, pitch);
	}

	@Override
	public void addChatMessage(Object iTextComponent) {
		base.superAddChatMessage(iTextComponent);
	}

	@Override
	public boolean canCommandSenderUseCommand(int permLevel, String commandName) {
		return base.superCanCommandSenderUseCommand(permLevel, commandName);
	}

	@Override
	public void func_191955_a(Object iBlockState) {
		base.superFunc_191955_a(iBlockState);
	}

	@Override
	public float func_191954_d(float p_191954_1_) {
		return base.superFunc_191954_d(p_191954_1_);
	}

	@Override
	public boolean func_191957_ae() {
		return base.superFunc_191957_ae();
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
	public boolean func_191953_am() {
		return base.superFunc_191953_am();
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

	@Override
	public Map getActivePotionMap() {
		return base.superGetActivePotionMap();
	}

	@Override
	public void blockUsingShield(Object entityLivingBase) {
		base.superBlockUsingShield(entityLivingBase);
	}

	@Override
	public Object getLastDamageSource() {
		return base.superGetLastDamageSource();
	}

	@Override
	public boolean hasItemInSlot(Object entityEquipmentSlot) {
		return base.superHasItemInSlot(entityEquipmentSlot);
	}

	@Override
	public float getWaterSlowDown() {
		return base.superGetWaterSlowDown();
	}

	@Override
	public boolean attackable() {
		return base.superAttackable();
	}

	@Override
	public void setPartying(Object blockPos, boolean p_191987_2_) {
		base.superSetPartying(blockPos, p_191987_2_);
	}

	@Override
	public boolean processInitialInteract(Object entityPlayer, Object enumHand) {
		return base.superProcessInitialInteract(entityPlayer, enumHand);
	}

	@Override
	public Object applyPlayerInteraction(Object entityPlayer, Object vec3d, Object enumHand) {
		return base.superApplyPlayerInteraction(entityPlayer, vec3d, enumHand);
	}

	@Override
	public void setTamedBy(Object entityPlayer) {
		base.superSetTamedBy(entityPlayer);
	}

	@Override
	public boolean holdingSpawnEggOfClass(Object itemStack, Class p_190669_2_) {
		return base.superHoldingSpawnEggOfClass(itemStack, p_190669_2_);
	}

	@Override
	public double followLeashSpeed() {
		return base.superFollowLeashSpeed();
	}

	@Override
	public void func_191989_p(float p_191989_1_) {
		base.superFunc_191989_p(p_191989_1_);
	}

	@Override
	public void func_191986_a(float p_191986_1_, float p_191986_2_, float p_191986_3_) {
		base.superFunc_191986_a(p_191986_1_, p_191986_2_, p_191986_3_);
	}

}