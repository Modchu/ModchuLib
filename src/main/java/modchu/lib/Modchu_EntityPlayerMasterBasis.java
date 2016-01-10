package modchu.lib;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class Modchu_EntityPlayerMasterBasis implements Modchu_IEntityPlayerMaster {
	public Modchu_IEntityPlayer base;

	public Modchu_EntityPlayerMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IEntityPlayer) map.get("base");
	}

	@Override
	public void sendChatToPlayer(Object chatMessageComponent) {
		base.supersendChatToPlayer(chatMessageComponent);
	}

	@Override
	public boolean canCommandSenderUseCommand(int i, String s) {
		return base.supercanCommandSenderUseCommand(i, s);
	}

	@Override
	public Object getPlayerCoordinates() {
		return base.supergetPlayerCoordinates();
	}

	@Override
	public void applyEntityAttributes() {
		base.superapplyEntityAttributes();
	}

	@Override
	public void entityInit() {
		base.superentityInit();
	}

	@Override
	public Object getItemInUse() {
		return base.supergetItemInUse();
	}

	@Override
	public int getItemInUseCount() {
		return base.supergetItemInUseCount();
	}

	@Override
	public boolean isUsingItem() {
		return base.superisUsingItem();
	}

	@Override
	public int getItemInUseDuration() {
		return base.supergetItemInUseDuration();
	}

	@Override
	public void stopUsingItem() {
		base.superstopUsingItem();
	}

	@Override
	public void clearItemInUse() {
		base.superclearItemInUse();
	}

	@Override
	public boolean isBlocking() {
		return base.superisBlocking();
	}

	@Override
	public void onUpdate() {
		base.superonUpdate();
	}

	@Override
	public int getMaxInPortalTime() {
		return base.supergetMaxInPortalTime();
	}

	@Override
	public int getPortalCooldown() {
		return base.supergetPortalCooldown();
	}

	@Override
	public void playSound(String par1Str, float par2, float par3) {
		base.superplaySound(par1Str, par2, par3);
	}

	@Override
	public void updateItemUse(Object itemStack, int par2) {
		base.superupdateItemUse(itemStack, par2);
	}

	@Override
	public void onItemUseFinish() {
		base.superonItemUseFinish();
	}

	@Override
	public void handleStatusUpdate(byte par1) {
		base.superhandleStatusUpdate(par1);
	}

	@Override
	public boolean isMovementBlocked() {
		return base.superisMovementBlocked();
	}

	@Override
	public void closeScreen() {
		base.supercloseScreen();
	}

	@Override
	public void mountEntity(Object entity) {
		base.supermountEntity(entity);
	}

	@Override
	public void updateRidden() {
		base.superupdateRidden();
	}

	@Override
	public void preparePlayerToSpawn() {
		base.superpreparePlayerToSpawn();
	}

	@Override
	public void updateEntityActionState() {
		base.superupdateEntityActionState();
	}

	@Override
	public void onLivingUpdate() {
		base.superonLivingUpdate();
	}

	@Override
	public int getScore() {
		return base.supergetScore();
	}

	@Override
	public void setScore(int par1) {
		base.supersetScore(par1);
	}

	@Override
	public void addScore(int par1) {
		base.superaddScore(par1);
	}

	@Override
	public void onDeath(Object damageSource) {
		base.superonDeath(damageSource);
	}

	@Override
	public void addToPlayerScore(Object entity, int par2) {
		base.superaddToPlayerScore(entity, par2);
	}

	@Override
	public Object dropOneItem(boolean par1) {
		return base.superdropOneItem(par1);
	}

	@Override
	public Object dropPlayerItem(Object itemStack) {
		return base.superdropPlayerItem(itemStack);
	}

	@Override
	public Object dropPlayerItemWithRandomChoice(Object itemStack, boolean par2) {
		return base.superdropPlayerItemWithRandomChoice(itemStack, par2);
	}

	@Override
	public void joinEntityItemWithWorld(Object entityItem) {
		base.superjoinEntityItemWithWorld(entityItem);
	}

	@Override
	public float getCurrentPlayerStrVsBlock(Object block, boolean par2) {
		return base.supergetCurrentPlayerStrVsBlock(block, par2);
	}

	@Override
	public float getCurrentPlayerStrVsBlock(Object block, boolean par2, int meta) {
		return base.supergetCurrentPlayerStrVsBlock(block, par2, meta);
	}

	@Override
	public boolean canHarvestBlock(Object block) {
		return base.supercanHarvestBlock(block);
	}

	@Override
	public void readEntityFromNBT(Object nBTTagCompound) {
		base.superreadEntityFromNBT(nBTTagCompound);
	}

	@Override
	public void writeEntityToNBT(Object nBTTagCompound) {
		base.superwriteEntityToNBT(nBTTagCompound);
	}

	@Override
	public void displayGUIChest(Object iInventory) {
		base.superdisplayGUIChest(iInventory);
	}

	@Override
	public void displayGUIHopper(Object tileEntityHopper) {
		base.superdisplayGUIHopper(tileEntityHopper);
	}

	@Override
	public void displayGUIHopperMinecart(Object entityMinecartHopper) {
		base.superdisplayGUIHopperMinecart(entityMinecartHopper);
	}

	@Override
	public void displayGUIHorse(Object entityHorse, Object iInventory) {
		base.superdisplayGUIHorse(entityHorse, iInventory);
	}

	@Override
	public void displayGUIEnchantment(int par1, int par2, int par3, String par4Str) {
		base.superdisplayGUIEnchantment(par1, par2, par3, par4Str);
	}

	@Override
	public void displayGUIAnvil(int par1, int par2, int par3) {
		base.superdisplayGUIAnvil(par1, par2, par3);
	}

	@Override
	public void displayGUIWorkbench(int par1, int par2, int par3) {
		base.superdisplayGUIWorkbench(par1, par2, par3);
	}

	@Override
	public float getEyeHeight() {
		return base.supergetEyeHeight();
	}

	@Override
	public void resetHeight() {
		base.superresetHeight();
	}

	@Override
	public boolean attackEntityFrom(Object damageSource, float par2) {
		return base.superattackEntityFrom(damageSource, par2);
	}

	@Override
	public boolean canAttackPlayer(Object entityPlayer) {
		return base.supercanAttackPlayer(entityPlayer);
	}

	@Override
	public void damageArmor(float par1) {
		base.superdamageArmor(par1);
	}

	@Override
	public int getTotalArmorValue() {
		return base.supergetTotalArmorValue();
	}

	@Override
	public float getArmorVisibility() {
		return base.supergetArmorVisibility();
	}

	@Override
	public void damageEntity(Object damageSource, float par2) {
		base.superdamageEntity(damageSource, par2);
	}

	@Override
	public void displayGUIFurnace(Object tileEntityFurnace) {
		base.superdisplayGUIFurnace(tileEntityFurnace);
	}

	@Override
	public void displayGUIDispenser(Object tileEntityDispenser) {
		base.superdisplayGUIDispenser(tileEntityDispenser);
	}

	@Override
	public void displayGUIEditSign(Object tileEntity) {
		base.superdisplayGUIEditSign(tileEntity);
	}

	@Override
	public void displayGUIBrewingStand(Object tileEntityBrewingStand) {
		base.superdisplayGUIBrewingStand(tileEntityBrewingStand);
	}

	@Override
	public void displayGUIBeacon(Object tileEntityBeacon) {
		base.superdisplayGUIBeacon(tileEntityBeacon);
	}

	@Override
	public void displayGUIMerchant(Object iMerchant, String par2Str) {
		base.superdisplayGUIMerchant(iMerchant, par2Str);
	}

	@Override
	public void displayGUIBook(Object itemStack) {
		base.superdisplayGUIBook(itemStack);
	}

	@Override
	public boolean interactWith(Object entity) {
		return base.superinteractWith(entity);
	}

	@Override
	public Object getCurrentEquippedItem() {
		return base.supergetCurrentEquippedItem();
	}

	@Override
	public void destroyCurrentEquippedItem() {
		base.superdestroyCurrentEquippedItem();
	}

	@Override
	public double getYOffset() {
		return base.supergetYOffset();
	}

	@Override
	public void attackTargetEntityWithCurrentItem(Object entity) {
		base.superattackTargetEntityWithCurrentItem(entity);
	}

	@Override
	public void onCriticalHit(Object entity) {
		base.superonCriticalHit(entity);
	}

	@Override
	public void onEnchantmentCritical(Object entity) {
		base.superonEnchantmentCritical(entity);
	}

	@Override
	public void respawnPlayer() {
		base.superrespawnPlayer();
	}

	@Override
	public void setDead() {
		base.supersetDead();
	}

	@Override
	public boolean isEntityInsideOpaqueBlock() {
		return base.superisEntityInsideOpaqueBlock();
	}

	@Override
	public Object sleepInBedAt(int par1, int par2, int par3) {
		return base.supersleepInBedAt(par1, par2, par3);
	}

	@Override
	public void wakeUpPlayer(boolean par1, boolean par2, boolean par3) {
		base.superwakeUpPlayer(par1, par2, par3);
	}

	@Override
	public float getBedOrientationInDegrees() {
		return base.supergetBedOrientationInDegrees();
	}

	@Override
	public boolean isPlayerSleeping() {
		return base.superisPlayerSleeping();
	}

	@Override
	public boolean isPlayerFullyAsleep() {
		return base.superisPlayerFullyAsleep();
	}

	@Override
	public int getSleepTimer() {
		return base.supergetSleepTimer();
	}

	@Override
	public boolean getHideCape(int par1) {
		return base.supergetHideCape(par1);
	}

	@Override
	public void setHideCape(int par1, boolean par2) {
		base.supersetHideCape(par1, par2);
	}

	@Override
	public void addChatMessage(String par1Str) {
		base.superaddChatMessage(par1Str);
	}

	@Override
	public Object getBedLocation() {
		return base.supergetBedLocation();
	}

	@Override
	public boolean isSpawnForced() {
		return base.superisSpawnForced();
	}

	@Override
	public Object getBedLocation(int dimension) {
		return base.supergetBedLocation(dimension);
	}

	@Override
	public boolean isSpawnForced(int dimension) {
		return base.superisSpawnForced(dimension);
	}

	@Override
	public void setSpawnChunk(Object chunkCoordinates, boolean par2) {
		base.supersetSpawnChunk(chunkCoordinates, par2);
	}

	@Override
	public void setSpawnChunk(Object chunkCoordinates, boolean forced, int dimension) {
		base.supersetSpawnChunk(chunkCoordinates, forced, dimension);
	}

	@Override
	public void triggerAchievement(Object statBase) {
		base.supertriggerAchievement(statBase);
	}

	@Override
	public void addStat(Object statBase, int par2) {
		base.superaddStat(statBase, par2);
	}

	@Override
	public void jump() {
		base.superjump();
	}

	@Override
	public void moveEntityWithHeading(float par1, float par2) {
		base.supermoveEntityWithHeading(par1, par2);
	}

	@Override
	public float getAIMoveSpeed() {
		return base.supergetAIMoveSpeed();
	}

	@Override
	public void addMovementStat(double par1, double par3, double par5) {
		base.superaddMovementStat(par1, par3, par5);
	}

	@Override
	public void fall(float par1) {
		base.superfall(par1);
	}

	@Override
	public void onKillEntity(Object entityLivingBase) {
		base.superonKillEntity(entityLivingBase);
	}

	@Override
	public void setInWeb() {
		base.supersetInWeb();
	}

	@Override
	public Object getItemIcon(Object itemStack, int par2) {
		return base.supergetItemIcon(itemStack, par2);
	}

	@Override
	public Object getCurrentArmor(int par1) {
		return base.supergetCurrentArmor(par1);
	}

	@Override
	public void addExperience(int par1) {
		base.superaddExperience(par1);
	}

	@Override
	public void addExperienceLevel(int par1) {
		base.superaddExperienceLevel(par1);
	}

	@Override
	public int xpBarCap() {
		return base.superxpBarCap();
	}

	@Override
	public void addExhaustion(float par1) {
		base.superaddExhaustion(par1);
	}

	@Override
	public Object getFoodStats() {
		return base.supergetFoodStats();
	}

	@Override
	public boolean canEat(boolean par1) {
		return base.supercanEat(par1);
	}

	@Override
	public boolean shouldHeal() {
		return base.supershouldHeal();
	}

	@Override
	public void setItemInUse(Object itemStack, int par2) {
		base.supersetItemInUse(itemStack, par2);
	}

	@Override
	public boolean isCurrentToolAdventureModeExempt(int par1, int par2, int par3) {
		return base.superisCurrentToolAdventureModeExempt(par1, par2, par3);
	}

	@Override
	public boolean canPlayerEdit(int par1, int par2, int par3, int par4, Object itemStack) {
		return base.supercanPlayerEdit(par1, par2, par3, par4, itemStack);
	}

	@Override
	public int getExperiencePoints(Object entityPlayer) {
		return base.supergetExperiencePoints(entityPlayer);
	}

	@Override
	public boolean isPlayer() {
		return base.superisPlayer();
	}

	@Override
	public String getEntityName() {
		return base.supergetEntityName();
	}

	@Override
	public boolean getAlwaysRenderNameTagForRender() {
		return base.supergetAlwaysRenderNameTagForRender();
	}

	@Override
	public void clonePlayer(Object entityPlayer, boolean par2) {
		base.superclonePlayer(entityPlayer, par2);
	}

	@Override
	public boolean canTriggerWalking() {
		return base.supercanTriggerWalking();
	}

	@Override
	public void sendPlayerAbilities() {
		base.supersendPlayerAbilities();
	}

	@Override
	public void setGameType(Object enumGameType) {
		base.supersetGameType(enumGameType);
	}

	@Override
	public String getCommandSenderName() {
		return base.supergetName();
	}

	@Override
	public Object getEntityWorld() {
		return base.supergetEntityWorld();
	}

	@Override
	public Object getInventoryEnderChest() {
		return base.supergetInventoryEnderChest();
	}

	@Override
	public Object getCurrentItemOrArmor(int par1) {
		return base.supergetCurrentItemOrArmor(par1);
	}

	@Override
	public Object getHeldItem() {
		return base.supergetHeldItem();
	}

	@Override
	public void setCurrentItemOrArmor(int par1, Object itemStack) {
		base.supersetCurrentItemOrArmor(par1, itemStack);
	}

	@Override
	public boolean isInvisibleToPlayer(Object entityPlayer) {
		return base.superisInvisibleToPlayer(entityPlayer);
	}

	@Override
	public Object[] getLastActiveItems() {
		return base.supergetLastActiveItems();
	}

	@Override
	public boolean getHideCape() {
		return base.supergetHideCape();
	}

	@Override
	public boolean isPushedByWater() {
		return base.superisPushedByWater();
	}

	@Override
	public Object getWorldScoreboard() {
		return base.supergetWorldScoreboard();
	}

	@Override
	public Object getTeam() {
		return base.supergetTeam();
	}

	@Override
	public String getTranslatedEntityName() {
		return base.supergetTranslatedEntityName();
	}

	@Override
	public void setAbsorptionAmount(float par1) {
		base.supersetAbsorptionAmount(par1);
	}

	@Override
	public float getAbsorptionAmount() {
		return base.supergetAbsorptionAmount();
	}

	@Override
	public void openGui(Object mod, int modGuiId, Object world, int x, int y, int z) {
		base.superopenGui(mod, modGuiId, world, x, y, z);
	}

	@Override
	public float getDefaultEyeHeight() {
		return base.supergetDefaultEyeHeight();
	}

	@Override
	public String getDisplayName() {
		return base.supergetDisplayName();
	}

	@Override
	public void refreshDisplayName() {
		base.superrefreshDisplayName();
	}

	@Override
	public void updateFallState(double par1, boolean par3) {
		base.superupdateFallState(par1, par3);
	}

	@Override
	public boolean canBreatheUnderwater() {
		return base.supercanBreatheUnderwater();
	}

	@Override
	public void onEntityUpdate() {
		base.superonEntityUpdate();
	}

	@Override
	public boolean isChild() {
		return base.superisChild();
	}

	@Override
	public void onDeathUpdate() {
		base.superonDeathUpdate();
	}

	@Override
	public int decreaseAirSupply(int par1) {
		return base.superdecreaseAirSupply(par1);
	}

	@Override
	public Random getRNG() {
		return base.supergetRNG();
	}

	@Override
	public Object getAITarget() {
		return base.supergetAITarget();
	}

	@Override
	public int func_142015_aE() {
		return base.superfunc_142015_aE();
	}

	@Override
	public void setRevengeTarget(Object entityLivingBase) {
		base.supersetRevengeTarget(entityLivingBase);
	}

	@Override
	public Object getLastAttacker() {
		return base.supergetLastAttacker();
	}

	@Override
	public int getLastAttackerTime() {
		return base.supergetLastAttackerTime();
	}

	@Override
	public void setLastAttacker(Object entity) {
		base.supersetLastAttacker(entity);
	}

	@Override
	public int getAge() {
		return base.supergetAge();
	}

	@Override
	public void updatePotionEffects() {
		base.superupdatePotionEffects();
	}

	@Override
	public void clearActivePotions() {
		base.superclearActivePotions();
	}

	@Override
	public Object getActivePotionEffects() {
		return base.supergetActivePotionEffects();
	}

	@Override
	public boolean isPotionActive(int par1) {
		return base.superisPotionActive(par1);
	}

	@Override
	public boolean isPotionActive(Object potion) {
		return base.superisPotionActive(potion);
	}

	@Override
	public Object getActivePotionEffect(Object potion) {
		return base.supergetActivePotionEffect(potion);
	}

	@Override
	public void addPotionEffect(Object potionEffect) {
		base.superaddPotionEffect(potionEffect);
	}

	@Override
	public boolean isPotionApplicable(Object potionEffect) {
		return base.superisPotionApplicable(potionEffect);
	}

	@Override
	public boolean isEntityUndead() {
		return base.superisEntityUndead();
	}

	@Override
	public void removePotionEffectClient(int par1) {
		base.superremovePotionEffectClient(par1);
	}

	@Override
	public void removePotionEffect(int par1) {
		base.superremovePotionEffect(par1);
	}

	@Override
	public void onNewPotionEffect(Object potionEffect) {
		base.superonNewPotionEffect(potionEffect);
	}

	@Override
	public void onChangedPotionEffect(Object potionEffect, boolean par2) {
		base.superonChangedPotionEffect(potionEffect, par2);
	}

	@Override
	public void onFinishedPotionEffect(Object potionEffect) {
		base.superonFinishedPotionEffect(potionEffect);
	}

	@Override
	public void heal(float par1) {
		base.superheal(par1);
	}

	@Override
	public void setHealth(float par1) {
		base.supersetHealth(par1);
	}

	@Override
	public void renderBrokenItemStack(Object itemStack) {
		base.superrenderBrokenItemStack(itemStack);
	}

	@Override
	public void dropEquipment(boolean par1, int par2) {
		base.superdropEquipment(par1, par2);
	}

	@Override
	public void knockBack(Object entity, float par2, double par3, double par5) {
		base.superknockBack(entity, par2, par3, par5);
	}

	@Override
	public String getHurtSound() {
		return base.supergetHurtSound();
	}

	@Override
	public String getDeathSound() {
		return base.supergetDeathSound();
	}

	@Override
	public void dropRareDrop(int par1) {
		base.superdropRareDrop(par1);
	}

	@Override
	public void dropFewItems(boolean par1, int par2) {
		base.superdropFewItems(par1, par2);
	}

	@Override
	public boolean isOnLadder() {
		return base.superisOnLadder();
	}

	@Override
	public boolean isEntityAlive() {
		return base.superisEntityAlive();
	}

	@Override
	public void performHurtAnimation() {
		base.superperformHurtAnimation();
	}

	@Override
	public float applyArmorCalculations(Object damageSource, float par2) {
		return base.superapplyArmorCalculations(damageSource, par2);
	}

	@Override
	public float applyPotionDamageCalculations(Object damageSource, float par2) {
		return base.superapplyPotionDamageCalculations(damageSource, par2);
	}

	@Override
	public Object func_110142_aN() {
		return base.superfunc_110142_aN();
	}

	@Override
	public Object func_94060_bK() {
		return base.superfunc_94060_bK();
	}

	@Override
	public void swingItem() {
		base.superswingItem();
	}

	@Override
	public void kill() {
		base.superkill();
	}

	@Override
	public void updateArmSwingProgress() {
		base.superupdateArmSwingProgress();
	}

	@Override
	public Object getEntityAttribute(Object attribute) {
		return base.supergetEntityAttribute(attribute);
	}

	@Override
	public Object getAttributeMap() {
		return base.supergetAttributeMap();
	}

	@Override
	public Object getCreatureAttribute() {
		return base.supergetCreatureAttribute();
	}

	@Override
	public void setSprinting(boolean par1) {
		base.supersetSprinting(par1);
	}

	@Override
	public float getSoundVolume() {
		return base.supergetSoundVolume();
	}

	@Override
	public float getSoundPitch() {
		return base.supergetSoundPitch();
	}

	@Override
	public void setPositionAndUpdate(double par1, double par3, double par5) {
		base.supersetPositionAndUpdate(par1, par3, par5);
	}

	@Override
	public void dismountEntity(Object entity) {
		base.superdismountEntity(entity);
	}

	@Override
	public boolean isAIEnabled() {
		return base.superisAIEnabled();
	}

	@Override
	public void setAIMoveSpeed(float par1) {
		base.supersetAIMoveSpeed(par1);
	}

	@Override
	public boolean attackEntityAsMob(Object entity) {
		return base.superattackEntityAsMob(entity);
	}

	@Override
	public float func_110146_f(float par1, float par2) {
		return base.superfunc_110146_f(par1, par2);
	}

	@Override
	public void updateAITasks() {
		base.superupdateAITasks();
	}

	@Override
	public void collideWithNearbyEntities() {
		base.supercollideWithNearbyEntities();
	}

	@Override
	public void collideWithEntity(Object entity) {
		base.supercollideWithEntity(entity);
	}

	@Override
	public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
		base.supersetPositionAndRotation2(par1, par3, par5, par7, par8, par9);
	}

	@Override
	public void updateAITick() {
		base.superupdateAITick();
	}

	@Override
	public void setJumping(boolean par1) {
		base.supersetJumping(par1);
	}

	@Override
	public void onItemPickup(Object entity, int par2) {
		base.superonItemPickup(entity, par2);
	}

	@Override
	public boolean canEntityBeSeen(Object entity) {
		return base.supercanEntityBeSeen(entity);
	}

	@Override
	public Object getLookVec() {
		return base.supergetLookVec();
	}

	@Override
	public Object getLook(float par1) {
		return base.supergetLook(par1);
	}

	@Override
	public float getSwingProgress(float par1) {
		return base.supergetSwingProgress(par1);
	}

	@Override
	public Object getPosition(float par1) {
		return base.supergetPosition(par1);
	}

	@Override
	public Object rayTrace(double par1, float par3) {
		return base.superrayTrace(par1, par3);
	}

	@Override
	public boolean isClientWorld() {
		return base.superisClientWorld();
	}

	@Override
	public boolean canBeCollidedWith() {
		return base.supercanBeCollidedWith();
	}

	@Override
	public boolean canBePushed() {
		return base.supercanBePushed();
	}

	@Override
	public void setBeenAttacked() {
		base.supersetBeenAttacked();
	}

	@Override
	public float getRotationYawHead() {
		return base.supergetRotationYawHead();
	}

	@Override
	public void setRotationYawHead(float par1) {
		base.supersetRotationYawHead(par1);
	}

	@Override
	public boolean isOnSameTeam(Object entityLivingBase) {
		return base.superisOnSameTeam(entityLivingBase);
	}

	@Override
	public boolean isOnTeam(Object team) {
		return base.superisOnTeam(team);
	}

	@Override
	public void curePotionEffects(Object itemStack) {
		base.supercurePotionEffects(itemStack);
	}

	@Override
	public boolean shouldRiderFaceForward(Object entityPlayer) {
		return base.supershouldRiderFaceForward(entityPlayer);
	}

	@Override
	public Object getDataWatcher() {
		return base.supergetDataWatcher();
	}

	@Override
	public void setSize(float par1, float par2) {
		base.supersetSize(par1, par2);
	}

	@Override
	public void setRotation(float par1, float par2) {
		base.supersetRotation(par1, par2);
	}

	@Override
	public void setPosition(double par1, double par3, double par5) {
		base.supersetPosition(par1, par3, par5);
	}

	@Override
	public void setAngles(float par1, float par2) {
		base.supersetAngles(par1, par2);
	}

	@Override
	public void setOnFireFromLava() {
		base.supersetOnFireFromLava();
	}

	@Override
	public void setFire(int par1) {
		base.supersetFire(par1);
	}

	@Override
	public void extinguish() {
		base.superextinguish();
	}

	@Override
	public boolean isOffsetPositionInLiquid(double par1, double par3, double par5) {
		return base.superisOffsetPositionInLiquid(par1, par3, par5);
	}

	@Override
	public void moveEntity(double par1, double par3, double par5) {
		base.supermoveEntity(par1, par3, par5);
	}

	@Override
	public void doBlockCollisions() {
		base.superdoBlockCollisions();
	}

	@Override
	public void playStepSound(int par1, int par2, int par3, int par4) {
		base.superplayStepSound(par1, par2, par3, par4);
	}

	@Override
	public Object getCollisionBoundingBox() {
		return base.supergetCollisionBoundingBox();
	}

	@Override
	public void dealFireDamage(int par1) {
		base.superdealFireDamage(par1);
	}

	@Override
	public boolean isWet() {
		return base.superisWet();
	}

	@Override
	public boolean isInWater() {
		return base.superisInWater();
	}

	@Override
	public boolean handleWaterMovement() {
		return base.superhandleWaterMovement();
	}

	@Override
	public boolean isInsideOfMaterial(Object material) {
		return base.superisInsideOfMaterial(material);
	}

	@Override
	public boolean handleLavaMovement() {
		return base.superhandleLavaMovement();
	}

	@Override
	public void moveFlying(float par1, float par2, float par3) {
		base.supermoveFlying(par1, par2, par3);
	}

	@Override
	public int getBrightnessForRender(float par1) {
		return base.supergetBrightnessForRender(par1);
	}

	@Override
	public float getBrightness(float par1) {
		return base.supergetBrightness(par1);
	}

	@Override
	public void setWorld(Object world) {
		base.supersetWorld(world);
	}

	@Override
	public void setPositionAndRotation(double par1, double par3, double par5, float par7, float par8) {
		base.supersetPositionAndRotation(par1, par3, par5, par7, par8);
	}

	@Override
	public void setLocationAndAngles(double par1, double par3, double par5, float par7, float par8) {
		base.supersetLocationAndAngles(par1, par3, par5, par7, par8);
	}

	@Override
	public float getDistanceToEntity(Object entity) {
		return base.supergetDistanceToEntity(entity);
	}

	@Override
	public double getDistanceSq(double par1, double par3, double par5) {
		return base.supergetDistanceSq(par1, par3, par5);
	}

	@Override
	public double getDistance(double par1, double par3, double par5) {
		return base.supergetDistance(par1, par3, par5);
	}

	@Override
	public double getDistanceSqToEntity(Object entity) {
		return base.supergetDistanceSqToEntity(entity);
	}

	@Override
	public void onCollideWithPlayer(Object entityPlayer) {
		base.superonCollideWithPlayer(entityPlayer);
	}

	@Override
	public void applyEntityCollision(Object entity) {
		base.superapplyEntityCollision(entity);
	}

	@Override
	public void addVelocity(double par1, double par3, double par5) {
		base.superaddVelocity(par1, par3, par5);
	}

	@Override
	public boolean isInRangeToRenderVec3D(Object vec3) {
		return base.superisInRangeToRenderVec3D(vec3);
	}

	@Override
	public boolean isInRangeToRenderDist(double par1) {
		return base.superisInRangeToRenderDist(par1);
	}

	@Override
	public boolean writeMountToNBT(Object nBTTagCompound) {
		return base.superwriteMountToNBT(nBTTagCompound);
	}

	@Override
	public boolean writeToNBTOptional(Object nBTTagCompound) {
		return base.superwriteToNBTOptional(nBTTagCompound);
	}

	@Override
	public void writeToNBT(Object nBTTagCompound) {
		base.superwriteToNBT(nBTTagCompound);
	}

	@Override
	public void readFromNBT(Object nBTTagCompound) {
		base.superreadFromNBT(nBTTagCompound);
	}

	@Override
	public boolean shouldSetPosAfterLoading() {
		return base.supershouldSetPosAfterLoading();
	}

	@Override
	public void onChunkLoad() {
		base.superonChunkLoad();
	}

	@Override
	public Object newDoubleNBTList(double... par1ArrayOfDouble) {
		return base.supernewDoubleNBTList(par1ArrayOfDouble);
	}

	@Override
	public Object newFloatNBTList(float... par1ArrayOfFloat) {
		return base.supernewFloatNBTList(par1ArrayOfFloat);
	}

	@Override
	public float getShadowSize() {
		return base.supergetShadowSize();
	}

	@Override
	public Object dropItem(int par1, int par2) {
		return base.superdropItem(par1, par2);
	}

	@Override
	public Object dropItemWithOffset(int par1, int par2, float par3) {
		return base.superdropItemWithOffset(par1, par2, par3);
	}

	@Override
	public Object entityDropItem(Object itemStack, float par2) {
		return base.superentityDropItem(itemStack, par2);
	}

	@Override
	public boolean interactFirst(Object entityPlayer) {
		return base.superinteractFirst(entityPlayer);
	}

	@Override
	public Object getCollisionBox(Object entity) {
		return base.supergetCollisionBox(entity);
	}

	@Override
	public void updateRiderPosition() {
		base.superupdateRiderPosition();
	}

	@Override
	public double getMountedYOffset() {
		return base.supergetMountedYOffset();
	}

	@Override
	public float getCollisionBorderSize() {
		return base.supergetCollisionBorderSize();
	}

	@Override
	public void setPortal(Object bockPos) {
		base.supersetPortal(null);
	}

	@Override
	public void setVelocity(double par1, double par3, double par5) {
		base.supersetVelocity(par1, par3, par5);
	}

	@Override
	public boolean isBurning() {
		return base.superisBurning();
	}

	@Override
	public boolean isRiding() {
		return base.superisRiding();
	}

	@Override
	public boolean isSneaking() {
		return base.superisSneaking();
	}

	@Override
	public void setSneaking(boolean par1) {
		base.supersetSneaking(par1);
	}

	@Override
	public boolean isSprinting() {
		return base.superisSprinting();
	}

	@Override
	public boolean isInvisible() {
		return base.superisInvisible();
	}

	@Override
	public void setInvisible(boolean par1) {
		base.supersetInvisible(par1);
	}

	@Override
	public boolean isEating() {
		return base.superisEating();
	}

	@Override
	public void setEating(boolean par1) {
		base.supersetEating(par1);
	}

	@Override
	public boolean getFlag(int par1) {
		return base.supergetFlag(par1);
	}

	@Override
	public void setFlag(int par1, boolean par2) {
		base.supersetFlag(par1, par2);
	}

	@Override
	public int getAir() {
		return base.supergetAir();
	}

	@Override
	public void setAir(int par1) {
		base.supersetAir(par1);
	}

	@Override
	public void onStruckByLightning(Object entityLightningBolt) {
		base.superonStruckByLightning(entityLightningBolt);
	}

	@Override
	public boolean pushOutOfBlocks(double par1, double par3, double par5) {
		return base.superpushOutOfBlocks(par1, par3, par5);
	}

	@Override
	public Object[] getParts() {
		return base.supergetParts();
	}

	@Override
	public boolean isEntityEqual(Object entity) {
		return base.superisEntityEqual(entity);
	}

	@Override
	public boolean canAttackWithItem() {
		return base.supercanAttackWithItem();
	}

	@Override
	public boolean hitByEntity(Object entity) {
		return base.superhitByEntity(entity);
	}

	@Override
	public boolean isEntityInvulnerable() {
		return base.superisEntityInvulnerable();
	}

	@Override
	public void copyLocationAndAnglesFrom(Object entity) {
		base.supercopyLocationAndAnglesFrom(entity);
	}

	@Override
	public void copyDataFrom(Object entity, boolean par2) {
		base.supercopyDataFrom(entity, par2);
	}

	@Override
	public void travelToDimension(int par1) {
		base.supertravelToDimension(par1);
	}

	@Override
	public float getBlockExplosionResistance(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return base.supergetBlockExplosionResistance(explosion, world, par3, par4, par5, block);
	}

	@Override
	public boolean shouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7) {
		return base.supershouldExplodeBlock(explosion, world, par3, par4, par5, par6, par7);
	}

	@Override
	public int getMaxSafePointTries() {
		return base.supergetMaxSafePointTries();
	}

	@Override
	public Object getTeleportDirection() {
		return (Integer) base.supergetTeleportDirection();
	}

	@Override
	public boolean doesEntityNotTriggerPressurePlate() {
		return base.superdoesEntityNotTriggerPressurePlate();
	}

	@Override
	public void addEntityCrashInfo(Object crashReportCategory) {
		base.superaddEntityCrashInfo(crashReportCategory);
	}

	@Override
	public boolean canRenderOnFire() {
		return base.supercanRenderOnFire();
	}

	@Override
	public UUID getUniqueID() {
		return base.supergetUniqueID();
	}

	@Override
	public Object getEntityData() {
		return base.supergetEntityData();
	}

	@Override
	public boolean shouldRiderSit() {
		return base.supershouldRiderSit();
	}

	@Override
	public Object getPickedResult(Object movingObjectPosition) {
		return base.supergetPickedResult(movingObjectPosition);
	}

	@Override
	public UUID getPersistentID() {
		return base.supergetPersistentID();
	}

	@Override
	public boolean shouldRenderInPass(int pass) {
		return base.supershouldRenderInPass(pass);
	}

	@Override
	public boolean isCreatureType(Object enumCreatureType, boolean forSpawnCount) {
		return base.superisCreatureType(enumCreatureType, forSpawnCount);
	}

	@Override
	public String registerExtendedProperties(String identifier, Object iExtendedEntityProperties) {
		return base.superregisterExtendedProperties(identifier, iExtendedEntityProperties);
	}

	@Override
	public Object getExtendedProperties(String identifier) {
		return base.supergetExtendedProperties(identifier);
	}

	@Override
	public boolean canRiderInteract() {
		return base.supercanRiderInteract();
	}

	@Override
	public boolean shouldDismountInWater(Object entity) {
		return base.supershouldDismountInWater(entity);
	}

	@Override
	public void setPositionCorrection(double par1, double par3, double par5) {
		base.supersetPositionCorrection(par1, par3, par5);
	}

}
