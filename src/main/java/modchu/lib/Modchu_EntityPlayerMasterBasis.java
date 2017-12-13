package modchu.lib;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Modchu_EntityPlayerMasterBasis implements Modchu_IEntityPlayerMaster {
	public Modchu_IEntityPlayer base;

	public Modchu_EntityPlayerMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IEntityPlayer) map.get("base");
		Modchu_EntityHelper.getInstance().setData(base, "checkUUIDCount", 2);
	}

	@Override
	public void setRidingEntityId(int i) {
		base.setDataWatcherWatchableObject(16, i);
	}

	@Override
	public boolean attackEntityFrom(Object par1DamageSource, float par2) {
		return Modchu_EntityHelper.getInstance().attackEntityFrom(base, par1DamageSource, par2);
	}

	@Override
	public boolean isRiding() {
		return Modchu_EntityHelper.getInstance().isRiding(base);
	}

	@Override
	public void onLivingUpdate() {
		Modchu_EntityHelper.getInstance().onLivingUpdate(base);
	}

	@Override
	public void onUpdate() {
		Modchu_EntityHelper.getInstance().onUpdate(base);
	}

	@Override
	public boolean isDamageInvincible() {
		return Modchu_EntityHelper.getInstance().isDamageInvincible(base);
	}

	@Override
	public boolean startRiding(Object entity, boolean force) {
		return Modchu_EntityHelper.getInstance().startRiding(base, entity, force);
	}

	@Override
	public boolean canBeRidden(Object entity) {
		return Modchu_EntityHelper.getInstance().canBeRidden(base, entity);
	}

	@Override
	public Object getRidingEntity2() {
		return Modchu_EntityHelper.getInstance().getRidingEntity2(base);
	}

	@Override
	public boolean isRiding2() {
		return Modchu_EntityHelper.getInstance().isRiding2(base);
	}

	@Override
	public void updateRidden2() {
		Modchu_EntityHelper.getInstance().updateRidden2(base);
	}

	@Override
	public int getRidingEntityID() {
		return Modchu_EntityHelper.getInstance().getRidingEntityID(base);
	}

	@Override
	public int getTempIsRiding() {
		return Modchu_EntityHelper.getInstance().getTempIsRiding(base);
	}

	@Override
	public void setTempIsRiding(int i) {
		Modchu_EntityHelper.getInstance().setTempIsRiding(base, i);
	}

	@Override
	public int getDamageInvincibleCount() {
		return Modchu_CastHelper.Int(Modchu_EntityHelper.getInstance().getData(base, "damageInvincibleCount"), 0);
	}

	@Override
	public void setDamageInvincibleCount(int i) {
		Modchu_EntityHelper.getInstance().setData(base, "damageInvincibleCount", i);
	}

	@Override
	public Object getFreeVariable(String s) {
		return Modchu_EntityHelper.getInstance().getData(base, s);
	}

	@Override
	public void setFreeVariable(String s, Object o) {
		Modchu_EntityHelper.getInstance().setData(base, s, o);
	}

	@Override
	public int getEntityId() {
		return base.supergetEntityId();
	}

	@Override
	public void setEntityId(int p_145769_1_) {
		base.supersetEntityId(p_145769_1_);
	}

	@Override
	public void sendChatToPlayer(Object chatMessageComponent) {
		base.supersendChatToPlayer(chatMessageComponent);
	}

	@Override
	public boolean canCommandSenderUseCommand(int i, String s) {
		return base.supercanUseCommand(i, s);
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
	public boolean isHandActive() {
		return base.superisHandActive();
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
	public boolean startRiding(Object entity) {
		//Modchu_Debug.mDebug("Modchu_EntityPlayerMasterBasis superstartRiding old entity="+entity);
		return base.superstartRiding(entity);
	}

	@Override
	public void dismountRidingEntity2() {
		base.superdismountRidingEntity();
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
	public void awardKillScore(Object entity, int par2) {
		base.superawardKillScore(entity, par2);
	}

	@Override
	public Object dropItem(boolean par1) {
		return base.superdropItem(par1);
	}

	@Override
	public Object dropPlayerItem(Object itemStack) {
		return base.superdropPlayerItem(itemStack);
	}

	@Override
	public Object dropItem(Object itemStack, boolean par2) {
		return base.superdropItem(itemStack, par2);
	}

	@Override
	public void dropItemAndGetStack(Object entityItem) {
		base.superdropItemAndGetStack(entityItem);
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
	public void openGuiHorseInventory(Object entityHorse, Object iInventory) {
		base.superopenGuiHorseInventory(entityHorse, iInventory);
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
	public void openBook(Object itemStack) {
		base.superopenBook(itemStack);
	}

	@Override
	public boolean interactWith(Object entity) {
		return base.superinteractWith(entity);
	}

	@Override
	public Object getHeldItemMainhand() {
		return base.supergetHeldItemMainhand();
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
	public void sendMessage(String par1Str) {
		base.supersendMessage(par1Str);
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
	public void addStat(Object statBase) {
		base.superaddStat(statBase);
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
	public Object getRevengeTarget() {
		return base.supergetRevengeTarget();
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
	public Object getLastAttackedEntity() {
		return base.supergetLastAttackedEntity();
	}

	@Override
	public int getLastAttackedEntityTime() {
		return base.supergetLastAttackedEntityTime();
	}

	@Override
	public void setLastAttackedEntity(Object entity) {
		base.supersetLastAttackedEntity(entity);
	}

	@Override
	public int getIdleTime() {
		return base.supergetIdleTime();
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
	public Object applyArmorCalculations(Object damageSource, float par2) {
		return base.superapplyArmorCalculations(damageSource, par2);
	}

	@Override
	public Object applyPotionDamageCalculations(Object damageSource, float par2) {
		return base.superapplyPotionDamageCalculations(damageSource, par2);
	}

	@Override
	public Object func_110142_aN() {
		return base.superfunc_110142_aN();
	}

	@Override
	public Object getAttackingEntity() {
		return base.supergetAttackingEntity();
	}

	@Override
	public void swingArm() {
		base.superswingArm();
	}

	@Override
	public void outOfWorld() {
		base.superoutOfWorld();
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
	public float updateDistance(float par1, float par2) {
		return base.superupdateDistance(par1, par2);
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
	public void setPositionAndRotationDirect(double par1, double par3, double par5, float par7, float par8, int par9) {
		base.supersetPositionAndRotationDirect(par1, par3, par5, par7, par8, par9);
	}

	@Override
	public void handleJumpWater() {
		base.superhandleJumpWater();
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
	public Object getDataManager() {
		return base.supergetDataManager();
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
		base.superturn(par1, par2);
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
	public void moveEntity(Object moverType, double par1, double par3, double par5) {
		base.supermove(moverType, par1, par3, par5);
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
	public void moveRelative(float par1, float par2, float par3) {
		base.supermoveRelative(par1, par2, par3);
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
	public boolean writeToNBTAtomically(Object nBTTagCompound) {
		return base.superwriteToNBTAtomically(nBTTagCompound);
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
	public boolean processInitialInteract(Object entityPlayer) {
		return base.superprocessInitialInteract(entityPlayer);
	}

	@Override
	public Object getCollisionBox(Object entity) {
		return base.supergetCollisionBox(entity);
	}

	@Override
	public void updatePassenger() {
		base.superupdatePassenger();
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
	public boolean canBeAttackedWithItem() {
		return base.supercanBeAttackedWithItem();
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
	public void changeDimension(int par1) {
		base.superchangeDimension(par1);
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
	public Object getLastPortalVec() {
		return (Integer) base.supergetLastPortalVec();
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

	@Override
	public boolean func_71066_bF() {
		return base.superfunc_71066_bF();
	}

	@Override
	public void updateCloak() {
		base.superupdateCloak();
	}

	@Override
	public void copyPlayer(Object entityplayer) {
		base.supercopyPlayer(entityplayer);
	}

	@Override
	public void copyInventory(Object inventoryplayer) {
		base.supercopyInventory(inventoryplayer);
	}

	@Override
	public Float getHealth() {
		return base.supergetHealth();
	}

	@Override
	public boolean canPickUpLoot() {
		return base.supercanPickUpLoot();
	}

	@Override
	public Object getTranslator() {
		return base.supergetTranslator();
	}

	@Override
	public String translateString(String par1Str, Object... par2ArrayOfObj) {
		return base.supertranslateString(par1Str, par2ArrayOfObj);
	}

	@Override
	public int func_96121_ay() {
		return base.superfunc_96121_ay();
	}

	@Override
	public Object getLookHelper() {
		return base.supergetLookHelper();
	}

	@Override
	public Object getMoveHelper() {
		return base.supergetMoveHelper();
	}

	@Override
	public Object getJumpHelper() {
		return base.supergetJumpHelper();
	}

	@Override
	public Object getNavigator() {
		return base.supergetNavigator();
	}

	@Override
	public Object getEntitySenses() {
		return base.supergetEntitySenses();
	}

	@Override
	public Object getLastAttackingEntity() {
		return base.supergetLastAttackingEntity();
	}

	@Override
	public void setLastAttackingEntity(Object entity) {
		base.supersetLastAttackingEntity(entity);
	}

	@Override
	public Object getAttackTarget() {
		return base.supergetAttackTarget();
	}

	@Override
	public void setAttackTarget(Object entityLiving) {
		base.supersetAttackTarget(entityLiving);
	}

	@Override
	public void dropLoot() {
		base.superdropLoot();
	}

	@Override
	public void func_82162_bC() {
		base.superfunc_82162_bC();
	}

	@Override
	public boolean canCurrentToolHarvestBlock(int par1, int par2, int par3) {
		return base.supercanCurrentToolHarvestBlock(par1, par2, par3);
	}

	@Override
	public boolean func_94062_bN() {
		return base.superfunc_94062_bN();
	}

	@Override
	public void alertWolves(Object entityLiving, boolean par2) {
		base.superalertWolves(entityLiving, par2);
	}

	@Override
	public boolean canAttackClass(Class par1Class) {
		return base.supercanAttackClass(par1Class);
	}

	@Override
	public void eatGrassBonus() {
		base.supereatGrassBonus();
	}

	@Override
	public boolean isWithinHomeDistanceCurrentPosition() {
		return base.superisWithinHomeDistanceCurrentPosition();
	}

	@Override
	public boolean isWithinHomeDistance(int par1, int par2, int par3) {
		return base.superisWithinHomeDistance(par1, par2, par3);
	}

	@Override
	public void setHomeArea(int par1, int par2, int par3, int par4) {
		base.supersetHomeArea(par1, par2, par3, par4);
	}

	@Override
	public Object getHomePosition() {
		return base.supergetHomePosition();
	}

	@Override
	public float getMaximumHomeDistance() {
		return base.supergetMaximumHomeDistance();
	}

	@Override
	public void detachHome() {
		base.superdetachHome();
	}

	@Override
	public boolean hasHome() {
		return base.superhasHome();
	}

	@Override
	public String getTexture() {
		return base.supergetTexture();
	}

	@Override
	public int getTalkInterval() {
		return base.supergetTalkInterval();
	}

	@Override
	public void playLivingSound() {
		base.superplayLivingSound();
	}

	@Override
	public void spawnExplosionParticle() {
		base.superspawnExplosionParticle();
	}

	@Override
	public void setEntityHealth(int par1) {
		base.supersetEntityHealth(par1);
	}

	@Override
	public String getAmbientSound() {
		return base.supergetAmbientSound();
	}

	@Override
	public int getDropItemId() {
		return base.supergetDropItemId();
	}

	@Override
	public void setMoveForward(float par1) {
		base.supersetMoveForward(par1);
	}

	@Override
	public boolean canDespawn() {
		return base.supercanDespawn();
	}

	@Override
	public void despawnEntity() {
		base.superdespawnEntity();
	}

	@Override
	public int getVerticalFaceSpeed() {
		return base.supergetVerticalFaceSpeed();
	}

	@Override
	public void faceEntity(Object entity, float par2, float par3) {
		base.superfaceEntity(entity, par2, par3);
	}

	@Override
	public boolean getCanSpawnHere() {
		return base.supergetCanSpawnHere();
	}

	@Override
	public float getRenderSizeModifier() {
		return base.supergetRenderSizeModifier();
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return base.supergetMaxSpawnedInChunk();
	}

	@Override
	public float getSpeedModifier() {
		return base.supergetSpeedModifier();
	}

	@Override
	public int getMaxFallHeight() {
		return base.supergetMaxFallHeight();
	}

	@Override
	public void onInitialSpawn(Object object, Object object2) {
		base.superonInitialSpawn(object, object2);
	}

	@Override
	public boolean canBeSteered() {
		return base.supercanBeSteered();
	}

	@Override
	public void func_94058_c(String par1Str) {
		base.superfunc_94058_c(par1Str);
	}

	@Override
	public String func_94057_bL() {
		return base.superfunc_94057_bL();
	}

	@Override
	public boolean func_94056_bM() {
		return base.superfunc_94056_bM();
	}

	@Override
	public void setNoAI(boolean par1) {
		base.supersetNoAI(par1);
	}

	@Override
	public void func_96120_a(int par1, float par2) {
		base.superfunc_96120_a(par1, par2);
	}

	@Override
	public void setCanPickUpLoot(boolean par1) {
		base.supersetCanPickUpLoot(par1);
	}

	@Override
	public boolean isNoDespawnRequired() {
		return base.superisNoDespawnRequired();
	}

	@Override
	public boolean addNotRiddenEntityID(Object nBTTagCompound) {
		return base.superaddNotRiddenEntityID(nBTTagCompound);
	}

	@Override
	public boolean addEntityID(Object nBTTagCompound) {
		return base.superaddEntityID(nBTTagCompound);
	}

	@Override
	public boolean interact(Object entityPlayer) {
		return base.superinteract(entityPlayer);
	}

	@Override
	public void unmountEntity(Object entity) {
		base.superunmountEntity(entity);
	}

	@Override
	public float func_82146_a(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return base.superfunc_82146_a(explosion, world, par3, par4, par5, block);
	}

	@Override
	public boolean func_96091_a(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7) {
		return base.superfunc_96091_a(explosion, world, par3, par4, par5, par6, par7);
	}

}
