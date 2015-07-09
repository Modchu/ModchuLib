package modchu.lib;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class Modchu_EntityOtherPlayerMPMasterBasis implements Modchu_IEntityOtherPlayerMPMaster {
	public Modchu_IEntityOtherPlayerMP base;

	public Modchu_EntityOtherPlayerMPMasterBasis(HashMap<String, Object> map) {
		base = map.containsKey("base") ? (Modchu_IEntityOtherPlayerMP) map.get("base") : null;
	}

	@Override
	public boolean attackEntityFrom(Object damageSource, float amount) {
		return base.superAttackEntityFrom(damageSource, amount);
	}

	@Override
	public void func_180426_a(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
		base.superFunc_180426_a(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_, p_180426_10_);
	}

	@Override
	public void onUpdate() {
		base.superOnUpdate();
	}

	@Override
	public void onLivingUpdate() {
		base.superOnLivingUpdate();
	}

	@Override
	public void setCurrentItemOrArmor(int slotIn, Object itemStack) {
		base.superSetCurrentItemOrArmor(slotIn, itemStack);
	}

	@Override
	public void addChatMessage(Object iChatComponent) {
		base.superAddChatMessage(iChatComponent);
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
	public boolean isSpectator() {
		return base.superIsSpectator();
	}

	@Override
	public boolean hasPlayerInfo() {
		return base.superHasPlayerInfo();
	}

	@Override
	public Object getPlayerInfo() {
		return base.superGetPlayerInfo();
	}

	@Override
	public boolean hasSkin() {
		return base.superHasSkin();
	}

	@Override
	public Object getLocationSkin() {
		return base.superGetLocationSkin();
	}

	@Override
	public Object getLocationCape() {
		return base.superGetLocationCape();
	}

	@Override
	public String getSkinType() {
		return base.superGetSkinType();
	}

	@Override
	public float getFovModifier() {
		return base.superGetFovModifier();
	}

	@Override
	public void applyEntityAttributes() {
		base.superApplyEntityAttributes();
	}

	@Override
	public void entityInit() {
		base.superEntityInit();
	}

	@Override
	public Object getItemInUse() {
		return base.superGetItemInUse();
	}

	@Override
	public int getItemInUseCount() {
		return base.superGetItemInUseCount();
	}

	@Override
	public boolean isUsingItem() {
		return base.superIsUsingItem();
	}

	@Override
	public int getItemInUseDuration() {
		return base.superGetItemInUseDuration();
	}

	@Override
	public void stopUsingItem() {
		base.superStopUsingItem();
	}

	@Override
	public void clearItemInUse() {
		base.superClearItemInUse();
	}

	@Override
	public boolean isBlocking() {
		return base.superIsBlocking();
	}

	@Override
	public int getMaxInPortalTime() {
		return base.superGetMaxInPortalTime();
	}

	@Override
	public String getSwimSound() {
		return base.superGetSwimSound();
	}

	@Override
	public String getSplashSound() {
		return base.superGetSplashSound();
	}

	@Override
	public int getPortalCooldown() {
		return base.superGetPortalCooldown();
	}

	@Override
	public void playSound(String name, float volume, float pitch) {
		base.superPlaySound(name, volume, pitch);
	}

	@Override
	public void updateItemUse(Object itemStack, int p_71010_2_) {
		base.superUpdateItemUse(itemStack, p_71010_2_);
	}

	@Override
	public void onItemUseFinish() {
		base.superOnItemUseFinish();
	}

	@Override
	public void handleHealthUpdate(byte p_70103_1_) {
		base.superHandleHealthUpdate(p_70103_1_);
	}

	@Override
	public boolean isMovementBlocked() {
		return base.superIsMovementBlocked();
	}

	@Override
	public void closeScreen() {
		base.superCloseScreen();
	}

	@Override
	public void updateRidden() {
		base.superUpdateRidden();
	}

	@Override
	public void preparePlayerToSpawn() {
		base.superPreparePlayerToSpawn();
	}

	@Override
	public void updateEntityActionState() {
		base.superUpdateEntityActionState();
	}

	@Override
	public int getScore() {
		return base.superGetScore();
	}

	@Override
	public void setScore(int p_85040_1_) {
		base.superSetScore(p_85040_1_);
	}

	@Override
	public void addScore(int p_85039_1_) {
		base.superAddScore(p_85039_1_);
	}

	@Override
	public void onDeath(Object damageSource) {
		base.superOnDeath(damageSource);
	}

	@Override
	public String getHurtSound() {
		return base.superGetHurtSound();
	}

	@Override
	public String getDeathSound() {
		return base.superGetDeathSound();
	}

	@Override
	public void addToPlayerScore(Object entity, int amount) {
		base.superAddToPlayerScore(entity, amount);
	}

	@Override
	public Object dropOneItem(boolean p_71040_1_) {
		return base.superDropOneItem(p_71040_1_);
	}

	@Override
	public Object dropPlayerItemWithRandomChoice(Object itemStack, boolean unused) {
		return base.superDropPlayerItemWithRandomChoice(itemStack, unused);
	}

	@Override
	public Object dropItem(Object itemStack, boolean dropAround, boolean traceItem) {
		return base.superDropItem(itemStack, dropAround, traceItem);
	}

	@Override
	public void joinEntityItemWithWorld(Object entityItem) {
		base.superJoinEntityItemWithWorld(entityItem);
	}

	@Override
	public float getToolDigEfficiency(Object block) {
		return base.superGetToolDigEfficiency(block);
	}

	@Override
	public float getBreakSpeed(Object iBlockState, Object blockPos) {
		return base.superGetBreakSpeed(iBlockState, blockPos);
	}

	@Override
	public boolean canHarvestBlock(Object block) {
		return base.superCanHarvestBlock(block);
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
	public boolean canAttackPlayer(Object entityPlayer) {
		return base.superCanAttackPlayer(entityPlayer);
	}

	@Override
	public void damageArmor(float p_70675_1_) {
		base.superDamageArmor(p_70675_1_);
	}

	@Override
	public int getTotalArmorValue() {
		return base.superGetTotalArmorValue();
	}

	@Override
	public float getArmorVisibility() {
		return base.superGetArmorVisibility();
	}

	@Override
	public void damageEntity(Object damageSource, float damageAmount) {
		base.superDamageEntity(damageSource, damageAmount);
	}

	@Override
	public void openEditSign(Object tileEntitySign) {
		base.superOpenEditSign(tileEntitySign);
	}

	@Override
	public void openEditCommandBlock(Object commandBlockLogic) {
		base.superOpenEditCommandBlock(commandBlockLogic);
	}

	@Override
	public void displayVillagerTradeGui(Object iMerchant) {
		base.superDisplayVillagerTradeGui(iMerchant);
	}

	@Override
	public void displayGUIChest(Object iInventory) {
		base.superDisplayGUIChest(iInventory);
	}

	@Override
	public void displayGUIHorse(Object entityHorse, Object iInventory) {
		base.superDisplayGUIHorse(entityHorse, iInventory);
	}

	@Override
	public void displayGui(Object iInteractionObject) {
		base.superDisplayGui(iInteractionObject);
	}

	@Override
	public void displayGUIBook(Object itemStack) {
		base.superDisplayGUIBook(itemStack);
	}

	@Override
	public boolean interactWith(Object entity) {
		return base.superInteractWith(entity);
	}

	@Override
	public Object getCurrentEquippedItem() {
		return base.superGetCurrentEquippedItem();
	}

	@Override
	public void destroyCurrentEquippedItem() {
		base.superDestroyCurrentEquippedItem();
	}

	@Override
	public double getYOffset() {
		return base.superGetYOffset();
	}

	@Override
	public void attackTargetEntityWithCurrentItem(Object entity) {
		base.superAttackTargetEntityWithCurrentItem(entity);
	}

	@Override
	public void onCriticalHit(Object entity) {
		base.superOnCriticalHit(entity);
	}

	@Override
	public void onEnchantmentCritical(Object entity) {
		base.superOnEnchantmentCritical(entity);
	}

	@Override
	public void respawnPlayer() {
		base.superRespawnPlayer();
	}

	@Override
	public void setDead() {
		base.superSetDead();
	}

	@Override
	public boolean isEntityInsideOpaqueBlock() {
		return base.superIsEntityInsideOpaqueBlock();
	}

	@Override
	public boolean isUser() {
		return base.superIsUser();
	}

	@Override
	public Object getGameProfile() {
		return base.superGetGameProfile();
	}

	@Override
	public Object trySleep(Object blockPos) {
		return base.superTrySleep(blockPos);
	}

	@Override
	public void wakeUpPlayer(boolean p_70999_1_, boolean updateWorldFlag, boolean setSpawn) {
		base.superWakeUpPlayer(p_70999_1_, updateWorldFlag, setSpawn);
	}

	@Override
	public float getBedOrientationInDegrees() {
		return base.superGetBedOrientationInDegrees();
	}

	@Override
	public boolean isPlayerSleeping() {
		return base.superIsPlayerSleeping();
	}

	@Override
	public boolean isPlayerFullyAsleep() {
		return base.superIsPlayerFullyAsleep();
	}

	@Override
	public int getSleepTimer() {
		return base.superGetSleepTimer();
	}

	@Override
	public void addChatComponentMessage(Object iChatComponent) {
		base.superAddChatComponentMessage(iChatComponent);
	}

	@Override
	public Object getBedLocation() {
		return base.superGetBedLocation();
	}

	@Override
	public boolean isSpawnForced() {
		return base.superIsSpawnForced();
	}

	@Override
	public void setSpawnPoint(Object blockPos, boolean forced) {
		base.superSetSpawnPoint(blockPos, forced);
	}

	@Override
	public void triggerAchievement(Object statBase) {
		base.superTriggerAchievement(statBase);
	}

	@Override
	public void addStat(Object statBase, int amount) {
		base.superAddStat(statBase, amount);
	}

	@Override
	public void func_175145_a(Object statBase) {
		base.superFunc_175145_a(statBase);
	}

	@Override
	public void jump() {
		base.superJump();
	}

	@Override
	public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_) {
		base.superMoveEntityWithHeading(p_70612_1_, p_70612_2_);
	}

	@Override
	public float getAIMoveSpeed() {
		return base.superGetAIMoveSpeed();
	}

	@Override
	public void addMovementStat(double p_71000_1_, double p_71000_3_, double p_71000_5_) {
		base.superAddMovementStat(p_71000_1_, p_71000_3_, p_71000_5_);
	}

	@Override
	public void fall(float distance, float damageMultiplier) {
		base.superFall(distance, damageMultiplier);
	}

	@Override
	public void resetHeight() {
		base.superResetHeight();
	}

	@Override
	public String getFallSoundString(int damageValue) {
		return base.superGetFallSoundString(damageValue);
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
	public Object getCurrentArmor(int slotIn) {
		return base.superGetCurrentArmor(slotIn);
	}

	@Override
	public void addExperience(int amount) {
		base.superAddExperience(amount);
	}

	@Override
	public int getXPSeed() {
		return base.superGetXPSeed();
	}

	@Override
	public void removeExperienceLevel(int levels) {
		base.superRemoveExperienceLevel(levels);
	}

	@Override
	public void addExperienceLevel(int levels) {
		base.superAddExperienceLevel(levels);
	}

	@Override
	public int xpBarCap() {
		return base.superXpBarCap();
	}

	@Override
	public void addExhaustion(float p_71020_1_) {
		base.superAddExhaustion(p_71020_1_);
	}

	@Override
	public Object getFoodStats() {
		return base.superGetFoodStats();
	}

	@Override
	public boolean canEat(boolean ignoreHunger) {
		return base.superCanEat(ignoreHunger);
	}

	@Override
	public boolean shouldHeal() {
		return base.superShouldHeal();
	}

	@Override
	public void setItemInUse(Object itemStack, int duration) {
		base.superSetItemInUse(itemStack, duration);
	}

	@Override
	public boolean isAllowEdit() {
		return base.superIsAllowEdit();
	}

	@Override
	public boolean canPlayerEdit(Object blockPos, Object enumFacing, Object itemStack) {
		return base.superCanPlayerEdit(blockPos, enumFacing, itemStack);
	}

	@Override
	public int getExperiencePoints(Object entityPlayer) {
		return base.superGetExperiencePoints(entityPlayer);
	}

	@Override
	public boolean isPlayer() {
		return base.superIsPlayer();
	}

	@Override
	public boolean getAlwaysRenderNameTagForRender() {
		return base.superGetAlwaysRenderNameTagForRender();
	}

	@Override
	public void clonePlayer(Object entityPlayer, boolean respawnFromEnd) {
		base.superClonePlayer(entityPlayer, respawnFromEnd);
	}

	@Override
	public boolean canTriggerWalking() {
		return base.superCanTriggerWalking();
	}

	@Override
	public void sendPlayerAbilities() {
		base.superSendPlayerAbilities();
	}

	@Override
	public void setGameType(Object gameType) {
		base.superSetGameType(gameType);
	}

	@Override
	public String getName() {
		return base.superGetName();
	}

	@Override
	public Object getInventoryEnderChest() {
		return base.superGetInventoryEnderChest();
	}

	@Override
	public Object getEquipmentInSlot(int slotIn) {
		return base.superGetEquipmentInSlot(slotIn);
	}

	@Override
	public Object getHeldItem() {
		return base.superGetHeldItem();
	}

	@Override
	public boolean isInvisibleToPlayer(Object entityPlayer) {
		return base.superIsInvisibleToPlayer(entityPlayer);
	}

	@Override
	public Object[] getInventory() {
		return base.superGetInventory();
	}

	@Override
	public boolean isPushedByWater() {
		return base.superIsPushedByWater();
	}

	@Override
	public Object getWorldScoreboard() {
		return base.superGetWorldScoreboard();
	}

	@Override
	public Object getTeam() {
		return base.superGetTeam();
	}

	@Override
	public Object getDisplayName() {
		return base.superGetDisplayName();
	}

	@Override
	public float getEyeHeight() {
		return base.superGetEyeHeight();
	}

	@Override
	public void setAbsorptionAmount(float amount) {
		base.superSetAbsorptionAmount(amount);
	}

	@Override
	public float getAbsorptionAmount() {
		return base.superGetAbsorptionAmount();
	}

	@Override
	public boolean canOpen(Object lockCode) {
		return base.superCanOpen(lockCode);
	}

	@Override
	public boolean func_175148_a(Object enumPlayerModelParts) {
		return base.superFunc_175148_a(enumPlayerModelParts);
	}

	@Override
	public boolean sendCommandFeedback() {
		return base.superSendCommandFeedback();
	}

	@Override
	public boolean replaceItemInInventory(int p_174820_1_, Object itemStack) {
		return base.superReplaceItemInInventory(p_174820_1_, itemStack);
	}

	@Override
	public boolean hasReducedDebug() {
		return base.superHasReducedDebug();
	}

	@Override
	public void setReducedDebug(boolean reducedDebug) {
		base.superSetReducedDebug(reducedDebug);
	}

	@Override
	public void openGui(Object mod, int modGuiId, Object world, int x, int y, int z) {
		base.superOpenGui(mod, modGuiId, world, x, y, z);
	}

	@Override
	public Object getBedLocation(int dimension) {
		return base.superGetBedLocation(dimension);
	}

	@Override
	public boolean isSpawnForced(int dimension) {
		return base.superIsSpawnForced(dimension);
	}

	@Override
	public void setSpawnChunk(Object blockPos, boolean forced, int dimension) {
		base.superSetSpawnChunk(blockPos, forced, dimension);
	}

	@Override
	public float getDefaultEyeHeight() {
		return base.superGetDefaultEyeHeight();
	}

	@Override
	public String getDisplayNameString() {
		return base.superGetDisplayNameString();
	}

	@Override
	public void refreshDisplayName() {
		base.superRefreshDisplayName();
	}

	@Override
	public void onKillCommand() {
		base.superOnKillCommand();
	}

	@Override
	public void func_180433_a(double p_180433_1_, boolean p_180433_3_, Object block, Object blockPos) {
		base.superFunc_180433_a(p_180433_1_, p_180433_3_, block, blockPos);
	}

	@Override
	public boolean canBreatheUnderwater() {
		return base.superCanBreatheUnderwater();
	}

	@Override
	public void onEntityUpdate() {
		base.superOnEntityUpdate();
	}

	@Override
	public boolean isChild() {
		return base.superIsChild();
	}

	@Override
	public void onDeathUpdate() {
		base.superOnDeathUpdate();
	}

	@Override
	public boolean func_146066_aG() {
		return base.superFunc_146066_aG();
	}

	@Override
	public int decreaseAirSupply(int p_70682_1_) {
		return base.superDecreaseAirSupply(p_70682_1_);
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
	public int getRevengeTimer() {
		return base.superGetRevengeTimer();
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
	public void func_175135_B() {
		base.superFunc_175135_B();
	}

	@Override
	public void func_175133_bi() {
		base.superFunc_175133_bi();
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
	public boolean isPotionActive(int p_82165_1_) {
		return base.superIsPotionActive(p_82165_1_);
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
	public void removePotionEffectClient(int p_70618_1_) {
		base.superRemovePotionEffectClient(p_70618_1_);
	}

	@Override
	public void removePotionEffect(int p_82170_1_) {
		base.superRemovePotionEffect(p_82170_1_);
	}

	@Override
	public void onNewPotionEffect(Object potionEffect) {
		base.superOnNewPotionEffect(potionEffect);
	}

	@Override
	public void onChangedPotionEffect(Object potionEffect, boolean p_70695_2_) {
		base.superOnChangedPotionEffect(potionEffect, p_70695_2_);
	}

	@Override
	public void onFinishedPotionEffect(Object potionEffect) {
		base.superOnFinishedPotionEffect(potionEffect);
	}

	@Override
	public void heal(float healAmount) {
		base.superHeal(healAmount);
	}

	@Override
	public void setHealth(float p_70606_1_) {
		base.superSetHealth(p_70606_1_);
	}

	@Override
	public void renderBrokenItemStack(Object itemStack) {
		base.superRenderBrokenItemStack(itemStack);
	}

	@Override
	public void dropEquipment(boolean p_82160_1_, int p_82160_2_) {
		base.superDropEquipment(p_82160_1_, p_82160_2_);
	}

	@Override
	public void knockBack(Object entity, float p_70653_2_, double p_70653_3_, double p_70653_5_) {
		base.superKnockBack(entity, p_70653_2_, p_70653_3_, p_70653_5_);
	}

	@Override
	public void addRandomArmor() {
		base.superAddRandomArmor();
	}

	@Override
	public void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		base.superDropFewItems(p_70628_1_, p_70628_2_);
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
	public void performHurtAnimation() {
		base.superPerformHurtAnimation();
	}

	@Override
	public float applyArmorCalculations(Object damageSource, float p_70655_2_) {
		return base.superApplyArmorCalculations(damageSource, p_70655_2_);
	}

	@Override
	public float applyPotionDamageCalculations(Object damageSource, float p_70672_2_) {
		return base.superApplyPotionDamageCalculations(damageSource, p_70672_2_);
	}

	@Override
	public Object getCombatTracker() {
		return base.superGetCombatTracker();
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
	public void setSprinting(boolean sprinting) {
		base.superSetSprinting(sprinting);
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
	public void dismountEntity(Object entity) {
		base.superDismountEntity(entity);
	}

	@Override
	public float func_175134_bD() {
		return base.superFunc_175134_bD();
	}

	@Override
	public void updateAITick() {
		base.superUpdateAITick();
	}

	@Override
	public void func_180466_bG() {
		base.superFunc_180466_bG();
	}

	@Override
	public void setAIMoveSpeed(float p_70659_1_) {
		base.superSetAIMoveSpeed(p_70659_1_);
	}

	@Override
	public boolean attackEntityAsMob(Object entity) {
		return base.superAttackEntityAsMob(entity);
	}

	@Override
	public float func_110146_f(float p_110146_1_, float p_110146_2_) {
		return base.superFunc_110146_f(p_110146_1_, p_110146_2_);
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
	public void mountEntity(Object entity) {
		base.superMountEntity(entity);
	}

	@Override
	public void setJumping(boolean p_70637_1_) {
		base.superSetJumping(p_70637_1_);
	}

	@Override
	public void onItemPickup(Object entity, int p_71001_2_) {
		base.superOnItemPickup(entity, p_71001_2_);
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
	public Object getLook(float p_70676_1_) {
		return base.superGetLook(p_70676_1_);
	}

	@Override
	public float getSwingProgress(float p_70678_1_) {
		return base.superGetSwingProgress(p_70678_1_);
	}

	@Override
	public boolean isServerWorld() {
		return base.superIsServerWorld();
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
	public void setBeenAttacked() {
		base.superSetBeenAttacked();
	}

	@Override
	public float getRotationYawHead() {
		return base.superGetRotationYawHead();
	}

	@Override
	public void setRotationYawHead(float rotation) {
		base.superSetRotationYawHead(rotation);
	}

	@Override
	public boolean isOnSameTeam(Object entityLivingBase) {
		return base.superIsOnSameTeam(entityLivingBase);
	}

	@Override
	public boolean isOnTeam(Object team) {
		return base.superIsOnTeam(team);
	}

	@Override
	public void func_152111_bt() {
		base.superFunc_152111_bt();
	}

	@Override
	public void func_152112_bu() {
		base.superFunc_152112_bu();
	}

	@Override
	public void func_175136_bO() {
		base.superFunc_175136_bO();
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
	public void setEntityId(int id) {
		base.superSetEntityId(id);
	}

	@Override
	public Object getDataWatcher() {
		return base.superGetDataWatcher();
	}

	@Override
	public void setSize(float width, float height) {
		base.superSetSize(width, height);
	}

	@Override
	public void setRotation(float yaw, float pitch) {
		base.superSetRotation(yaw, pitch);
	}

	@Override
	public void setPosition(double x, double y, double z) {
		base.superSetPosition(x, y, z);
	}

	@Override
	public void setAngles(float yaw, float pitch) {
		base.superSetAngles(yaw, pitch);
	}

	@Override
	public void setOnFireFromLava() {
		base.superSetOnFireFromLava();
	}

	@Override
	public void setFire(int seconds) {
		base.superSetFire(seconds);
	}

	@Override
	public void extinguish() {
		base.superExtinguish();
	}

	@Override
	public boolean isOffsetPositionInLiquid(double x, double y, double z) {
		return base.superIsOffsetPositionInLiquid(x, y, z);
	}

	@Override
	public void moveEntity(double x, double y, double z) {
		base.superMoveEntity(x, y, z);
	}

	@Override
	public void doBlockCollisions() {
		base.superDoBlockCollisions();
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
	public Object getBoundingBox() {
		return base.superGetBoundingBox();
	}

	@Override
	public void dealFireDamage(int amount) {
		base.superDealFireDamage(amount);
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
	public void spawnRunningParticles() {
		base.superSpawnRunningParticles();
	}

	@Override
	public void createRunningParticles() {
		base.superCreateRunningParticles();
	}

	@Override
	public boolean isInsideOfMaterial(Object material) {
		return base.superIsInsideOfMaterial(material);
	}

	@Override
	public boolean isInLava() {
		return base.superIsInLava();
	}

	@Override
	public void moveFlying(float strafe, float forward, float friction) {
		base.superMoveFlying(strafe, forward, friction);
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
	public void setPositionAndRotation(double x, double y, double z, float yaw, float pitch) {
		base.superSetPositionAndRotation(x, y, z, yaw, pitch);
	}

	@Override
	public void moveToBlockPosAndAngles(Object blockPos, float p_174828_2_, float p_174828_3_) {
		base.superMoveToBlockPosAndAngles(blockPos, p_174828_2_, p_174828_3_);
	}

	@Override
	public void setLocationAndAngles(double x, double y, double z, float yaw, float pitch) {
		base.superSetLocationAndAngles(x, y, z, yaw, pitch);
	}

	@Override
	public float getDistanceToEntity(Object entity) {
		return base.superGetDistanceToEntity(entity);
	}

	@Override
	public double getDistanceSq(double x, double y, double z) {
		return base.superGetDistanceSq(x, y, z);
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
	public double getDistance(double x, double y, double z) {
		return base.superGetDistance(x, y, z);
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
	public void addVelocity(double x, double y, double z) {
		base.superAddVelocity(x, y, z);
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
	public boolean isInRangeToRender3d(double x, double y, double z) {
		return base.superIsInRangeToRender3d(x, y, z);
	}

	@Override
	public boolean isInRangeToRenderDist(double distance) {
		return base.superIsInRangeToRenderDist(distance);
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
	public Object newDoubleNBTList(double... numbers) {
		return base.superNewDoubleNBTList(numbers);
	}

	@Override
	public Object newFloatNBTList(float... numbers) {
		return base.superNewFloatNBTList(numbers);
	}

	@Override
	public Object dropItem(Object item, int size) {
		return base.superDropItem(item, size);
	}

	@Override
	public Object dropItemWithOffset(Object item, int size, float p_145778_3_) {
		return base.superDropItemWithOffset(item, size, p_145778_3_);
	}

	@Override
	public Object entityDropItem(Object itemStack, float offsetY) {
		return base.superEntityDropItem(itemStack, offsetY);
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
	public void updateRiderPosition() {
		base.superUpdateRiderPosition();
	}

	@Override
	public double getMountedYOffset() {
		return base.superGetMountedYOffset();
	}

	@Override
	public float getCollisionBorderSize() {
		return base.superGetCollisionBorderSize();
	}

	@Override
	public void setInPortal() {
		base.superSetInPortal();
	}

	@Override
	public void setVelocity(double x, double y, double z) {
		base.superSetVelocity(x, y, z);
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
	public void setSneaking(boolean sneaking) {
		base.superSetSneaking(sneaking);
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
	public void setInvisible(boolean invisible) {
		base.superSetInvisible(invisible);
	}

	@Override
	public boolean isEating() {
		return base.superIsEating();
	}

	@Override
	public void setEating(boolean eating) {
		base.superSetEating(eating);
	}

	@Override
	public boolean getFlag(int flag) {
		return base.superGetFlag(flag);
	}

	@Override
	public void setFlag(int flag, boolean set) {
		base.superSetFlag(flag, set);
	}

	@Override
	public int getAir() {
		return base.superGetAir();
	}

	@Override
	public void setAir(int air) {
		base.superSetAir(air);
	}

	@Override
	public void onStruckByLightning(Object entityLightningBolt) {
		base.superOnStruckByLightning(entityLightningBolt);
	}

	@Override
	public boolean pushOutOfBlocks(double x, double y, double z) {
		return base.superPushOutOfBlocks(x, y, z);
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
	public boolean canAttackWithItem() {
		return base.superCanAttackWithItem();
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
	public void copyDataFromOld(Object entity) {
		base.superCopyDataFromOld(entity);
	}

	@Override
	public void travelToDimension(int dimensionId) {
		base.superTravelToDimension(dimensionId);
	}

	@Override
	public float getExplosionResistance(Object explosion, Object world, Object blockPos, Object iBlockState) {
		return base.superGetExplosionResistance(explosion, world, blockPos, iBlockState);
	}

	@Override
	public boolean func_174816_a(Object explosion, Object world, Object blockPos, Object iBlockState, float p_174816_5_) {
		return base.superFunc_174816_a(explosion, world, blockPos, iBlockState, p_174816_5_);
	}

	@Override
	public int getMaxFallHeight() {
		return base.superGetMaxFallHeight();
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
	public void setCustomNameTag(String p_96094_1_) {
		base.superSetCustomNameTag(p_96094_1_);
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
	public void setAlwaysRenderNameTag(boolean p_174805_1_) {
		base.superSetAlwaysRenderNameTag(p_174805_1_);
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
	public void func_145781_i(int p_145781_1_) {
		base.superFunc_145781_i(p_145781_1_);
	}

	@Override
	public Object getHorizontalFacing() {
		return base.superGetHorizontalFacing();
	}

	@Override
	public Object func_174823_aP() {
		return base.superFunc_174823_aP();
	}

	@Override
	public boolean func_174827_a(Object entityPlayerMP) {
		return base.superFunc_174827_a(entityPlayerMP);
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
	public void setCommandStat(Object type, int amount) {
		base.superSetCommandStat(type, amount);
	}

	@Override
	public Object func_174807_aT() {
		return base.superFunc_174807_aT();
	}

	@Override
	public void func_174817_o(Object entity) {
		base.superFunc_174817_o(entity);
	}

	@Override
	public Object func_174819_aU() {
		return base.superFunc_174819_aU();
	}

	@Override
	public void func_174834_g(Object nBTTagCompound) {
		base.superFunc_174834_g(nBTTagCompound);
	}

	@Override
	public boolean func_174825_a(Object entityPlayer, Object vec3) {
		return base.superFunc_174825_a(entityPlayer, vec3);
	}

	@Override
	public boolean func_180427_aV() {
		return base.superFunc_180427_aV();
	}

	@Override
	public void func_174815_a(Object entityLivingBase, Object entity) {
		base.superFunc_174815_a(entityLivingBase, entity);
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
	public void setPositionAndRotation2(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {
		base.superSetPositionAndRotation2(p_70056_1_, p_70056_3_, p_70056_5_, p_70056_7_, p_70056_8_, p_70056_9_);

	}

	@Override
	public float getShadowSize() {
		return base.superGetShadowSize();
	}

	@Override
	public boolean canCommandSenderUseCommand(int p_70003_1_, String p_70003_2_) {
		return base.superCanCommandSenderUseCommand(p_70003_1_, p_70003_2_);
	}

	@Override
	public Object getPlayerCoordinates() {
		return base.superGetPlayerCoordinates();
	}

	@Override
	public boolean func_152122_n() {
		return base.superFunc_152122_n();
	}

	@Override
	public boolean func_152123_o() {
		return base.superFunc_152123_o();
	}

	@Override
	public void func_152121_a(Object type, Object resourceLocation) {
		base.superFunc_152121_a(type, resourceLocation);

	}

	@Override
	public Object func_146097_a(Object itemStack, boolean p_146097_2_, boolean p_146097_3_) {
		return base.superFunc_146097_a(itemStack, p_146097_2_, p_146097_3_);
	}

	@Override
	public float getCurrentPlayerStrVsBlock(Object block, boolean p_146096_2_) {
		return base.superGetCurrentPlayerStrVsBlock(block, p_146096_2_);
	}

	@Override
	public float getBreakSpeed(Object block, boolean p_146096_2_, int meta) {
		return base.superGetBreakSpeed(block, p_146096_2_, meta);
	}

	@Override
	public float getBreakSpeed(Object block, boolean p_146096_2_, int meta, int x, int y, int z) {
		return base.superGetBreakSpeed(block, p_146096_2_, meta, x, y, z);
	}

	@Override
	public void func_146093_a(Object tileEntityHopper) {
		base.superFunc_146093_a(tileEntityHopper);

	}

	@Override
	public void displayGUIHopperMinecart(Object entityMinecartHopper) {
		base.superDisplayGUIHopperMinecart(entityMinecartHopper);

	}

	@Override
	public void displayGUIEnchantment(int p_71002_1_, int p_71002_2_, int p_71002_3_, String p_71002_4_) {
		base.superDisplayGUIEnchantment(p_71002_1_, p_71002_2_, p_71002_3_, p_71002_4_);

	}

	@Override
	public void displayGUIAnvil(int p_82244_1_, int p_82244_2_, int p_82244_3_) {
		base.superDisplayGUIAnvil(p_82244_1_, p_82244_2_, p_82244_3_);

	}

	@Override
	public void displayGUIWorkbench(int p_71058_1_, int p_71058_2_, int p_71058_3_) {
		base.superDisplayGUIWorkbench(p_71058_1_, p_71058_2_, p_71058_3_);

	}

	@Override
	public void func_146101_a(Object tileEntityFurnace) {
		base.superFunc_146101_a(tileEntityFurnace);

	}

	@Override
	public void func_146102_a(Object tileEntityDispenser) {
		base.superFunc_146102_a(tileEntityDispenser);

	}

	@Override
	public void func_146100_a(Object tileEntity) {
		base.superFunc_146100_a(tileEntity);

	}

	@Override
	public void func_146095_a(Object commandBlockLogic) {
		base.superFunc_146095_a(commandBlockLogic);

	}

	@Override
	public void func_146098_a(Object tileEntityBrewingStand) {
		base.superFunc_146098_a(tileEntityBrewingStand);

	}

	@Override
	public void func_146104_a(Object tileEntityBeacon) {
		base.superFunc_146104_a(tileEntityBeacon);

	}

	@Override
	public void displayGUIMerchant(Object iMerchant, String p_71030_2_) {
		base.superDisplayGUIMerchant(iMerchant, p_71030_2_);

	}

	@Override
	public Object sleepInBedAt(int p_71018_1_, int p_71018_2_, int p_71018_3_) {
		return base.superSleepInBedAt(p_71018_1_, p_71018_2_, p_71018_3_);
	}

	@Override
	public boolean getHideCape(int p_82241_1_) {
		return base.superGetHideCape(p_82241_1_);
	}

	@Override
	public void setHideCape(int p_82239_1_, boolean p_82239_2_) {
		base.superSetHideCape(p_82239_1_, p_82239_2_);

	}

	@Override
	public void setSpawnChunk(Object chunkCoordinates, boolean p_71063_2_) {
		base.superSetSpawnChunk(chunkCoordinates, p_71063_2_);

	}

	@Override
	public void fall(float p_70069_1_) {
		base.superFall(p_70069_1_);

	}

	@Override
	public String func_146067_o(int p_146067_1_) {
		return base.superFunc_146067_o(p_146067_1_);
	}

	@Override
	public Object getItemIcon(Object itemStack, int p_70620_2_) {
		return base.superGetItemIcon(itemStack, p_70620_2_);
	}

	@Override
	public boolean isCurrentToolAdventureModeExempt(int p_82246_1_, int p_82246_2_, int p_82246_3_) {
		return base.superIsCurrentToolAdventureModeExempt(p_82246_1_, p_82246_2_, p_82246_3_);
	}

	@Override
	public boolean canPlayerEdit(int p_82247_1_, int p_82247_2_, int p_82247_3_, int p_82247_4_, Object itemStack) {
		return base.superCanPlayerEdit(p_82247_1_, p_82247_2_, p_82247_3_, p_82247_4_, itemStack);
	}

	@Override
	public String getCommandSenderName() {
		return base.superGetCommandSenderName();
	}

	@Override
	public Object[] getLastActiveItems() {
		return base.superGetLastActiveItems();
	}

	@Override
	public boolean getHideCape() {
		return base.superGetHideCape();
	}

	@Override
	public Object func_145748_c_() {
		return base.superFunc_145748_c_();
	}

	@Override
	public Object getPosition(float par1) {
		return base.superGetPosition(par1);
	}

	@Override
	public void updateFallState(double p_70064_1_, boolean p_70064_3_) {
		base.superUpdateFallState(p_70064_1_, p_70064_3_);

	}

	@Override
	public int func_142015_aE() {
		return base.superFunc_142015_aE();
	}

	@Override
	public void dropRareDrop(int p_70600_1_) {
		base.superDropRareDrop(p_70600_1_);

	}

	@Override
	public Object func_110142_aN() {
		return base.superFunc_110142_aN();
	}

	@Override
	public boolean isAIEnabled() {
		return base.superIsAIEnabled();
	}

	@Override
	public void updateAITasks() {
		base.superUpdateAITasks();

	}

	@Override
	public boolean isClientWorld() {
		return base.superIsClientWorld();
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
	public boolean handleLavaMovement() {
		return base.superHandleLavaMovement();
	}

	@Override
	public Object func_145778_a(Object item, int p_145778_2_, float p_145778_3_) {
		return base.superFunc_145778_a(item, p_145778_2_, p_145778_3_);
	}

	@Override
	public boolean func_145771_j(double p_145771_1_, double p_145771_3_, double p_145771_5_) {
		return base.superFunc_145771_j(p_145771_1_, p_145771_3_, p_145771_5_);
	}

	@Override
	public boolean isEntityInvulnerable() {
		return base.superIsEntityInvulnerable();
	}

	@Override
	public void copyDataFrom(Object entity, boolean p_82141_2_) {
		base.superCopyDataFrom(entity, p_82141_2_);

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
	public void sendChatToPlayer(Object chatMessageComponent) {
		base.superSendChatToPlayer(chatMessageComponent);

	}

	@Override
	public void setupCustomSkin() {
		base.superSetupCustomSkin();

	}

	@Override
	public Object getTextureSkin() {
		return base.superGetTextureSkin();
	}

	@Override
	public Object getTextureCape() {
		return base.superGetTextureCape();
	}

	@Override
	public Object dropPlayerItem(Object itemStack) {
		return base.superDropPlayerItem(itemStack);
	}

	@Override
	public float getCurrentPlayerStrVsBlock(Object block, boolean par2, int meta) {
		return base.superGetCurrentPlayerStrVsBlock(block, par2, meta);
	}

	@Override
	public void displayGUIHopper(Object tileEntityHopper) {
		base.superDisplayGUIHopper(tileEntityHopper);

	}

	@Override
	public void displayGUIFurnace(Object tileEntityFurnace) {
		base.superDisplayGUIFurnace(tileEntityFurnace);

	}

	@Override
	public void displayGUIDispenser(Object tileEntityDispenser) {
		base.superDisplayGUIDispenser(tileEntityDispenser);

	}

	@Override
	public void displayGUIEditSign(Object tileEntity) {
		base.superDisplayGUIEditSign(tileEntity);

	}

	@Override
	public void displayGUIBrewingStand(Object tileEntityBrewingStand) {
		base.superDisplayGUIBrewingStand(tileEntityBrewingStand);

	}

	@Override
	public void displayGUIBeacon(Object tileEntityBeacon) {
		base.superDisplayGUIBeacon(tileEntityBeacon);

	}

	@Override
	public void addChatMessage(String par1Str) {
		base.superAddChatMessage(par1Str);

	}

	@Override
	public String getEntityName() {
		return base.superGetEntityName();
	}

	@Override
	public Object getCurrentItemOrArmor(int par1) {
		return base.superGetCurrentItemOrArmor(par1);
	}

	@Override
	public String getTranslatedEntityName() {
		return base.superGetTranslatedEntityName();
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
	public Object dropItem(int par1, int par2) {
		return base.superDropItem(par1, par2);
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
	public void updateCloak() {
		base.superUpdateCloak();

	}

	@Override
	public void sendChatToPlayer(String par1Str) {
		base.superSendChatToPlayer(par1Str);

	}

	@Override
	public int getMaxHealth() {
		return base.superGetMaxHealth();
	}

	@Override
	public boolean func_96122_a(Object entityPlayer) {
		return base.superFunc_96122_a(entityPlayer);
	}

	@Override
	public void alertWolves(Object entityLiving, boolean par2) {
		base.superAlertWolves(entityLiving, par2);

	}

	@Override
	public void damageArmor(int par1) {
		base.superDamageArmor(par1);

	}

	@Override
	public float func_82243_bO() {
		return base.superFunc_82243_bO();
	}

	@Override
	public boolean func_71066_bF() {
		return base.superFunc_71066_bF();
	}

	@Override
	public void func_82162_bC() {
		base.superFunc_82162_bC();

	}

	@Override
	public boolean canCurrentToolHarvestBlock(int par1, int par2, int par3) {
		return base.superCanCurrentToolHarvestBlock(par1, par2, par3);
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
	public boolean canPickUpLoot() {
		return base.superCanPickUpLoot();
	}

	@Override
	public Object getTranslator() {
		return base.superGetTranslator();
	}

	@Override
	public String translateString(String par1Str, Object... par2ArrayOfObj) {
		return base.superTranslateString(par1Str, par2ArrayOfObj);
	}

	@Override
	public boolean func_98034_c(Object entityPlayer) {
		return base.superFunc_98034_c(entityPlayer);
	}

	@Override
	public boolean func_96092_aw() {
		return base.superFunc_96092_aw();
	}

	@Override
	public int func_96121_ay() {
		return base.superFunc_96121_ay();
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
	public void setAttackTarget(Object entityLiving) {
		base.superSetAttackTarget(entityLiving);

	}

	@Override
	public boolean canAttackClass(Class par1Class) {
		return base.superCanAttackClass(par1Class);
	}

	@Override
	public void eatGrassBonus() {
		base.superEatGrassBonus();

	}

	@Override
	public boolean isWithinHomeDistanceCurrentPosition() {
		return base.superIsWithinHomeDistanceCurrentPosition();
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
	public String getTexture() {
		return base.superGetTexture();
	}

	@Override
	public int getTalkInterval() {
		return base.superGetTalkInterval();
	}

	@Override
	public void playLivingSound() {
		base.superPlayLivingSound();

	}

	@Override
	public void spawnExplosionParticle() {
		base.superSpawnExplosionParticle();

	}

	@Override
	public int getHealthInt() {
		return base.superGetHealthInt();
	}

	@Override
	public String getLivingSound() {
		return base.superGetLivingSound();
	}

	@Override
	public int getDropItemId() {
		return base.superGetDropItemId();
	}

	@Override
	public void setMoveForward(float par1) {
		base.superSetMoveForward(par1);

	}

	@Override
	public void func_85033_bc() {
		base.superFunc_85033_bc();

	}

	@Override
	public boolean canDespawn() {
		return base.superCanDespawn();
	}

	@Override
	public void despawnEntity() {
		base.superDespawnEntity();

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
	public boolean getCanSpawnHere() {
		return base.superGetCanSpawnHere();
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
	public float getSpeedModifier() {
		return base.superGetSpeedModifier();
	}

	@Override
	public int func_82143_as() {
		return base.superFunc_82143_as();
	}

	@Override
	public void initCreature() {
		base.superInitCreature();

	}

	@Override
	public boolean canBeSteered() {
		return base.superCanBeSteered();
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
	public void func_96120_a(int par1, float par2) {
		base.superFunc_96120_a(par1, par2);

	}

	@Override
	public void setCanPickUpLoot(boolean par1) {
		base.superSetCanPickUpLoot(par1);

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
	public boolean interact(Object entityPlayer) {
		return base.superInteract(entityPlayer);
	}

	@Override
	public void unmountEntity(Object entity) {
		base.superUnmountEntity(entity);

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

}
