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

}
