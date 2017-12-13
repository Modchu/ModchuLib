package modchu.lib;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class Modchu_EntityPlayerSPMasterBasis implements Modchu_IEntityPlayerSPMaster {
	public Modchu_IEntityPlayerSP base;

	public Modchu_EntityPlayerSPMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IEntityPlayerSP) map.get("base");
		Modchu_EntityHelper.getInstance().setData(base, "checkUUIDCount", 2);
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
	public void init() {
	}

	@Override
	public void wakeUpPlayer(boolean flag, boolean flag1, boolean flag2) {
		base.superwakeUpPlayer(flag, flag1, flag2);
	}

	@Override
	public void preparePlayerToSpawn() {
		base.superpreparePlayerToSpawn();
	}

	@Override
	public void setPositionCorrection(double par1, double par3, double par5) {
		base.supersetPositionCorrection(par1, par3, par5);
	}

	@Override
	public void onLivingUpdate() {
		base.superonLivingUpdate();
	}

	@Override
	public void travel(float f, float f1, float f2) {
		base.supertravel(f, f1, f2);
	}

	@Override
	public Object getHurtSound(Object damageSource) {
		return base.supergetHurtSound(damageSource);
	}

	@Override
	public Object getCreatureAttribute() {
		return base.supergetCreatureAttribute();
	}

	@Override
	public double getMountedYOffset() {
		return base.supergetMountedYOffset();
	}

	@Override
	public void doWaterSplashEffect() {
		base.superdoWaterSplashEffect();
	}

	@Override
	public double getYOffset() {
		return base.supergetYOffset();
	}

	@Override
	public boolean pushOutOfBlocks(double d, double d1, double d2) {
		return base.superpushOutOfBlocks(d, d1, d2);
	}

	@Override
	public boolean isEntityInsideOpaqueBlock() {
		return base.superisEntityInsideOpaqueBlock();
	}

	@Override
	public Object copyPlayer(Object entityplayer) {
		return base.supercopyPlayer(entityplayer);
	}

	@Override
	public Object copyInventory(Object inventoryplayer) {
		return base.supercopyInventory(inventoryplayer);
	}

	@Override
	public void setSize(float f, float f1) {
		base.supersetSize(f, f1);
	}

	@Override
	public void updateRidden() {
		base.superupdateRidden();
	}

	@Override
	public boolean attackEntityFrom(Object var1, Object damageSource, int i) {
		return base.superattackEntityFrom(var1, damageSource, i);
	}

	@Override
	public boolean attackEntityFrom(Object damageSource, int i) {
		return base.superattackEntityFrom(damageSource, i);
	}

	@Override
	public void onDeath(Object damageSource) {
		base.superonDeath(damageSource);
	}

	@Override
	public void sendMotionUpdates() {
		base.supersendMotionUpdates();
	}

	@Override
	public float getMaxHealth() {
		return base.supergetMaxHealth();
	}

	@Override
	public int getMaxHealthInt() {
		return base.supergetMaxHealthInt();
	}

	@Override
	public Object getHealth() {
		return base.supergetHealth();
	}

	@Override
	public int getHealthInt() {
		return base.supergetHealthInt();
	}

	@Override
	public void setHealth(float f) {
		base.supersetHealth(f);
	}

	@Override
	public void setHealthInt(int i) {
		base.supersetHealthInt(i);
	}

	@Override
	public boolean attackEntityFrom(Object damageSource, float par2) {
		return base.superattackEntityFrom(damageSource, par2);
	}

	@Override
	public void heal(float par1) {
		base.superheal(par1);
	}

	@Override
	public void onUpdate() {
		base.superonUpdate();
	}

	@Override
	public Object dropItem(boolean par1) {
		return base.superdropItem(par1);
	}

	@Override
	public Object dropItemAndGetStack(Object entityItem) {
		return base.superdropItemAndGetStack(entityItem);
	}

	@Override
	public void sendChatMessage(String par1Str) {
		base.supersendChatMessage(par1Str);
	}

	@Override
	public void swingArm() {
		base.superswingArm();
	}

	@Override
	public void respawnPlayer() {
		base.superrespawnPlayer();
	}

	@Override
	public void damageEntity(Object damageSource, float par2) {
		base.superdamageEntity(damageSource, par2);
	}

	@Override
	public void closeScreen() {
		base.supercloseScreen();
	}

	@Override
	public void func_92015_f() {
		base.superfunc_92015_f();
	}

	@Override
	public void setPlayerSPHealth(float par1) {
		base.supersetPlayerSPHealth(par1);
	}

	@Override
	public void addStat(Object statBase, int par2) {
		base.superaddStat(statBase, par2);
	}

	@Override
	public void incrementStat(Object statBase, int par2) {
		base.superincrementStat(statBase, par2);
	}

	@Override
	public void sendPlayerAbilities() {
		base.supersendPlayerAbilities();
	}

	@Override
	public void func_110318_g() {
		base.supersendHorseJump();
	}

	@Override
	public void func_110322_i() {
		base.superfunc_110322_i();
	}

	@Override
	public void func_142020_c(String par1Str) {
		base.superfunc_142020_c(par1Str);
	}

	@Override
	public String func_142021_k() {
		return base.supergetClientBrand();
	}

	@Override
	public void updateEntityActionState() {
		base.superupdateEntityActionState();
	}

	@Override
	public float getFOVMultiplier() {
		return base.supergetFOVMultiplier();
	}

	@Override
	public void displayGUIEditSign(Object tileEntity) {
		base.superdisplayGUIEditSign(tileEntity);
	}

	@Override
	public void openBook(Object itemStack) {
		base.superopenBook(itemStack);
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
	public void displayGUIWorkbench(int par1, int par2, int par3) {
		base.superdisplayGUIWorkbench(par1, par2, par3);
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
	public void displayGUIFurnace(Object tileEntityFurnace) {
		base.superdisplayGUIFurnace(tileEntityFurnace);
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
	public void displayGUIDispenser(Object tileEntityDispenser) {
		base.superdisplayGUIDispenser(tileEntityDispenser);
	}

	@Override
	public void displayGUIMerchant(Object iMerchant, String par2Str) {
		base.superdisplayGUIMerchant(iMerchant, par2Str);
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
	public void onItemPickup(Object entity, int par2) {
		base.superonItemPickup(entity, par2);
	}

	@Override
	public boolean isSneaking() {
		return base.superisSneaking();
	}

	@Override
	public void sendMessage(String par1Str) {
		base.supersendMessage(par1Str);
	}

	@Override
	public void setSprinting(boolean par1) {
		base.supersetSprinting(par1);
	}

	@Override
	public void setXPStats(float par1, int par2, int par3) {
		base.supersetXPStats(par1, par2, par3);
	}

	@Override
	public void sendChatToPlayer(Object chatMessageComponent) {
		base.supersendChatToPlayer(chatMessageComponent);
	}

	@Override
	public boolean canUseCommand(int par1, String par2Str) {
		return base.supercanUseCommand(par1, par2Str);
	}

	@Override
	public Object getPlayerCoordinates() {
		return base.supergetPlayerCoordinates();
	}

	@Override
	public Object getHeldItem() {
		return base.supergetHeldItem();
	}

	@Override
	public void playSound(String par1Str, float par2, float par3) {
		base.superplaySound(par1Str, par2, par3);
	}

	@Override
	public boolean isClientWorld() {
		return base.superisClientWorld();
	}

	@Override
	public boolean isRidingHorse() {
		return base.superisRidingHorse();
	}

	@Override
	public float getHorseJumpPower() {
		return base.supergetHorseJumpPower();
	}

	@Override
	public void setupCustomSkin() {
		base.supersetupCustomSkin();
	}

	@Override
	public Object getTextureSkin() {
		return base.supergetTextureSkin();
	}

	@Override
	public Object getTextureCape() {
		return base.supergetTextureCape();
	}

	@Override
	public Object getLocationSkin() {
		return base.supergetLocationSkin();
	}

	@Override
	public Object getLocationCape() {
		return base.supergetLocationCape();
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
	public boolean startRiding(Object entity) {
		return base.superstartRiding(entity);
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
	public void awardKillScore(Object entity, int par2, Object damageSource) {
		base.superawardKillScore(entity, par2, damageSource);
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
	public float getEyeHeight() {
		return base.supergetEyeHeight();
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
	public void attackTargetEntityWithCurrentItem(Object entity) {
		base.superattackTargetEntityWithCurrentItem(entity);
	}

	@Override
	public void setDead() {
		base.supersetDead();
	}

	@Override
	public Object sleepInBedAt(int par1, int par2, int par3) {
		return base.supersleepInBedAt(par1, par2, par3);
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
	public void jump() {
		base.superjump();
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
	public Object getItemStackFromSlot(Object par1) {
		return base.supergetItemStackFromSlot(par1);
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
	public void setGameType(Object enumGameType) {
		base.supersetGameType(enumGameType);
	}

	@Override
	public String getName() {
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
	public void setItemStackToSlot(int par1, Object itemStack) {
		base.supersetItemStackToSlot(par1, itemStack);
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
	public Object getDisplayName() {
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
	public Object getDeathSound() {
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
	public void setRotation(float par1, float par2) {
		base.supersetRotation(par1, par2);
	}

	@Override
	public void setPosition(double par1, double par3, double par5) {
		base.supersetPosition(par1, par3, par5);
	}

	@Override
	public void turn(float par1, float par2) {
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
	public void move(Object moverType, double par1, double par3, double par5) {
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
	public void moveRelative(float par1, float par2, float par3, float par4) {
		base.supermoveRelative(par1, par2, par3, par4);
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
	public Object writeToNBT(Object nBTTagCompound) {
		return base.superwriteToNBT(nBTTagCompound);
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
	public float getCollisionBorderSize() {
		return base.supergetCollisionBorderSize();
	}

	@Override
	public void setPortal(Object bockPos) {
		base.supersetPortal(bockPos);
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
	public Object changeDimension(int par1) {
		return base.superchangeDimension(par1);
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
		return base.supergetLastPortalVec();
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
	public void closeScreenNoPacket() {
		base.supercloseScreenNoPacket();
	}

	@Override
	public Object getStatFileWriter() {
		return base.supergetStatFileWriter();
	}

	@Override
	public void func_146100_a(Object tileEntity) {
		base.superfunc_146100_a(tileEntity);
	}

	@Override
	public void func_146095_a(Object commandBlockLogic) {
		base.superfunc_146095_a(commandBlockLogic);
	}

	@Override
	public void func_146093_a(Object tileEntityHopper) {
		base.superfunc_146093_a(tileEntityHopper);
	}

	@Override
	public void func_146104_a(Object tileEntityBeacon) {
		base.superfunc_146104_a(tileEntityBeacon);
	}

	@Override
	public void func_146102_a(Object tileEntityDispenser) {
		base.superfunc_146102_a(tileEntityDispenser);
	}

	@Override
	public void func_146098_a(Object tileEntityBrewingStand) {
		base.superfunc_146098_a(tileEntityBrewingStand);
	}

	@Override
	public void func_146101_a(Object tileEntityFurnace) {
		base.superfunc_146101_a(tileEntityFurnace);
	}

	@Override
	public void sendMessage(Object iChatComponent) {
		base.supersendMessage(iChatComponent);
	}

	@Override
	public void sendStatusMessage(Object iChatComponent, boolean p_146105_2_) {
		base.supersendStatusMessage(iChatComponent, p_146105_2_);
	}

	@Override
	public Object getSplashSound() {
		return base.supergetSplashSound();
	}

	@Override
	public Object getSwimSound() {
		return base.supergetSwimSound();
	}

	@Override
	public float getBreakSpeed(Object block, boolean p_146096_2_, int meta) {
		return base.supergetBreakSpeed(block, p_146096_2_, meta);
	}

	@Override
	public float getBreakSpeed(Object block, boolean p_146096_2_, int meta, int x, int y, int z) {
		return base.supergetBreakSpeed(block, p_146096_2_, meta, x, y, z);
	}

	@Override
	public Object func_146097_a(Object itemStack, boolean p_146097_2_, boolean p_146097_3_) {
		return base.superdropItem(itemStack, p_146097_2_, p_146097_3_);
	}

	@Override
	public Object getGameProfile() {
		return base.supergetGameProfile();
	}

	@Override
	public String func_146067_o(int p_146067_1_) {
		return base.superfunc_146067_o(p_146067_1_);
	}

	@Override
	public boolean canDropLoot() {
		return base.supercanDropLoot();
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
	public void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Object block) {
		base.superfunc_145780_a(p_145780_1_, p_145780_2_, p_145780_3_, block);
	}

	@Override
	public boolean isInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
		return base.superisInRangeToRender3d(p_145770_1_, p_145770_3_, p_145770_5_);
	}

	@Override
	public Object dropItem(Object item, int p_145779_2_) {
		return base.superdropItem(item, p_145779_2_);
	}

	@Override
	public float func_145772_a(Object explosion, Object world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Object block) {
		return base.superfunc_145772_a(explosion, world, p_145772_3_, p_145772_4_, p_145772_5_, block);
	}

	@Override
	public boolean func_145774_a(Object explosion, Object world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Object block, float p_145774_7_) {
		return base.superfunc_145774_a(explosion, world, p_145774_3_, p_145774_4_, p_145774_5_, block, p_145774_7_);
	}

	@Override
	public void onDataWatcherUpdate(int p_145781_1_) {
		base.superonDataWatcherUpdate(p_145781_1_);
	}
	// 179~
	@Override
	public boolean func_152122_n() {
		return base.superhasPlayerInfo();
	}

	@Override
	public boolean func_152123_o() {
		return base.superhasSkin();
	}

	@Override
	public void func_152121_a(Object type, Object resourceLocation) {
		base.superfunc_152121_a(type, resourceLocation);
	}

	@Override
	public void sendEnterCombat() {
		base.supersendEnterCombat();
	}

	@Override
	public void sendEndCombat() {
		base.supersendEndCombat();
	}

	@Override
	public void onUpdateWalkingPlayer() {
		base.superonUpdateWalkingPlayer();
	}

	@Override
	public void closeScreenAndDropStack() {
		base.supercloseScreenAndDropStack();
	}

	@Override
	public boolean isUser() {
		return base.superisUser();
	}

	@Override
	public void sendHorseJump() {
		base.supersendHorseJump();
	}

	@Override
	public void sendHorseInventory() {
		base.supersendHorseInventory();
	}

	@Override
	public void setClientBrand(String brand) {
		base.supersetClientBrand(brand);
	}

	@Override
	public String getClientBrand() {
		return base.supergetClientBrand();
	}

	@Override
	public Object getPosition() {
		return base.supergetPosition();
	}

	@Override
	public boolean isServerWorld() {
		return base.superisServerWorld();
	}

	@Override
	public void openEditSign(Object tileEntitySign) {
		base.superopenEditSign(tileEntitySign);
	}

	@Override
	public void displayGuiEditCommandCart(Object commandBlockLogic) {
		base.superdisplayGuiEditCommandCart(commandBlockLogic);
	}

	@Override
	public void displayGui(Object iInteractionObject) {
		base.superdisplayGui(iInteractionObject);
	}

	@Override
	public void displayVillagerTradeGui(Object iMerchant) {
		base.superdisplayVillagerTradeGui(iMerchant);
	}

	@Override
	public boolean isCurrentViewEntity() {
		return base.superisCurrentViewEntity();
	}

	@Override
	public boolean isSpectator() {
		return base.superisSpectator();
	}

	@Override
	public boolean hasPlayerInfo() {
		return base.superhasPlayerInfo();
	}

	@Override
	public Object getPlayerInfo() {
		return base.supergetPlayerInfo();
	}

	@Override
	public boolean hasSkin() {
		return base.superhasSkin();
	}

	@Override
	public String getSkinType() {
		return base.supergetSkinType();
	}

	@Override
	public float getFovModifier() {
		return base.supergetFovModifier();
	}

	@Override
	public Object dropItem(Object itemStack, boolean dropAround, boolean traceItem) {
		return base.superdropItem(itemStack, dropAround, traceItem);
	}

	@Override
	public float getDigSpeed(Object block) {
		return base.supergetToolDigEfficiency(block);
	}

	@Override
	public float getDigSpeed(Object iBlockState, Object blockPos) {
		return base.supergetDigSpeed(iBlockState, blockPos);
	}

	@Override
	public Object trySleep(Object blockPos) {
		return base.supertrySleep(blockPos);
	}

	@Override
	public void setSpawnPoint(Object blockPos, boolean forced) {
		base.supersetSpawnPoint(blockPos, forced);
	}

	@Override
	public void takeStat(Object statBase) {
		base.supertakeStat(statBase);
	}

	@Override
	public void fall(float distance, float damageMultiplier) {
		base.superfall(distance, damageMultiplier);
	}

	@Override
	public Object getFallSound(int damageValue) {
		return base.supergetFallSound(damageValue);
	}

	@Override
	public int getXPSeed() {
		return base.supergetXPSeed();
	}

	@Override
	public void onEnchant(Object itemStack, int levels) {
		base.superonEnchant(itemStack, levels);
	}

	@Override
	public boolean isAllowEdit() {
		return base.superisAllowEdit();
	}

	@Override
	public boolean canPlayerEdit(Object blockPos, Object enumFacing, Object itemStack) {
		return base.supercanPlayerEdit(blockPos, enumFacing, itemStack);
	}

	@Override
	public Object[] getInventory() {
		return base.supergetInventory();
	}

	@Override
	public boolean canOpen(Object lockCode) {
		return base.supercanOpen(lockCode);
	}

	@Override
	public boolean isWearing(Object enumPlayerModelParts) {
		return base.superisWearing(enumPlayerModelParts);
	}

	@Override
	public boolean sendCommandFeedback() {
		return base.supersendCommandFeedback();
	}

	@Override
	public boolean replaceItemInInventory(int p_174820_1_, Object itemStack) {
		return base.superreplaceItemInInventory(p_174820_1_, itemStack);
	}

	@Override
	public boolean hasReducedDebug() {
		return base.superhasReducedDebug();
	}

	@Override
	public void setReducedDebug(boolean reducedDebug) {
		base.supersetReducedDebug(reducedDebug);
	}

	@Override
	public String getDisplayNameString() {
		return base.supergetDisplayNameString();
	}

	@Override
	public void onKillCommand() {
		base.superonKillCommand();
	}

	@Override
	public void updateFallState(double p_180433_1_, boolean p_180433_3_, Object block, Object blockPos) {
		base.superupdateFallState(p_180433_1_, p_180433_3_, block, blockPos);
	}

	@Override
	public int getRevengeTimer() {
		return base.supergetRevengeTimer();
	}

	@Override
	public void updatePotionMetadata() {
		base.superupdatePotionMetadata();
	}

	@Override
	public void resetPotionEffectMetadata() {
		base.superresetPotionEffectMetadata();
	}

	@Override
	public void dropLoot() {
		base.superdropLoot();
	}

	@Override
	public Object getCombatTracker() {
		return base.supergetCombatTracker();
	}

	@Override
	public float getJumpUpwardsMotion() {
		return base.supergetJumpUpwardsMotion();
	}

	@Override
	public void handleJumpLava() {
		base.superhandleJumpLava();
	}

	@Override
	public void setPositionAndRotationDirect(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
		base.supersetPositionAndRotationDirect(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_, p_180426_10_);
	}

	@Override
	public void markPotionsDirty() {
		base.supermarkPotionsDirty();
	}

	@Override
	public void playStepSound(Object blockPos, Object block) {
		base.superplayStepSound(blockPos, block);
	}

	@Override
	public boolean isSilent() {
		return base.superisSilent();
	}

	@Override
	public void setSilent(boolean isSilent) {
		base.supersetSilent(isSilent);
	}

	@Override
	public void spawnRunningParticles() {
		base.superspawnRunningParticles();
	}

	@Override
	public void createRunningParticles() {
		base.supercreateRunningParticles();
	}

	@Override
	public boolean isInLava() {
		return base.superisInLava();
	}

	@Override
	public void moveToBlockPosAndAngles(Object blockPos, float p_174828_2_, float p_174828_3_) {
		base.supermoveToBlockPosAndAngles(blockPos, p_174828_2_, p_174828_3_);
	}

	@Override
	public double getDistanceSq(Object blockPos) {
		return base.supergetDistanceSq(blockPos);
	}

	@Override
	public double getDistanceSqToCenter(Object blockPos) {
		return base.supergetDistanceSqToCenter(blockPos);
	}

	@Override
	public Object getPositionEyes(float p_174824_1_) {
		return base.supergetPositionEyes(p_174824_1_);
	}

	@Override
	public Object dropItemWithOffset(Object item, int size, float p_145778_3_) {
		return base.superdropItemWithOffset(item, size, p_145778_3_);
	}

	@Override
	public boolean isEntityInvulnerable(Object damageSource) {
		return base.superisEntityInvulnerable(damageSource);
	}

	@Override
	public void copyDataFromOld(Object entity) {
		base.supercopyDataFromOld(entity);
	}

	@Override
	public float getExplosionResistance(Object explosion, Object world, Object blockPos, Object iBlockState) {
		return base.supergetExplosionResistance(explosion, world, blockPos, iBlockState);
	}

	@Override
	public boolean canExplosionDestroyBlock(Object explosion, Object world, Object blockPos, Object iBlockState, float p_174816_5_) {
		return base.supercanExplosionDestroyBlock(explosion, world, blockPos, iBlockState, p_174816_5_);
	}

	@Override
	public int getMaxFallHeight() {
		return base.supergetMaxFallHeight();
	}

	@Override
	public boolean hasCustomName() {
		return base.superhasCustomName();
	}

	@Override
	public Object getHorizontalFacing() {
		return base.supergetHorizontalFacing();
	}

	@Override
	public Object getHoverEvent() {
		return base.supergetHoverEvent();
	}

	@Override
	public boolean isSpectatedByPlayer(Object entityPlayerMP) {
		return base.superisSpectatedByPlayer(entityPlayerMP);
	}

	@Override
	public Object getEntityBoundingBox() {
		return base.supergetEntityBoundingBox();
	}

	@Override
	public void setEntityBoundingBox(Object axisAlignedBB) {
		base.supersetEntityBoundingBox(axisAlignedBB);
	}

	@Override
	public boolean isOutsideBorder() {
		return base.superisOutsideBorder();
	}

	@Override
	public void setOutsideBorder(boolean p_174821_1_) {
		base.supersetOutsideBorder(p_174821_1_);
	}

	@Override
	public Object getPositionVector() {
		return base.supergetPositionVector();
	}

	@Override
	public Object getCommandSenderEntity() {
		return base.supergetCommandSenderEntity();
	}

	@Override
	public void setCommandStat(Object type, int amount) {
		base.supersetCommandStat(type, amount);
	}

	@Override
	public Object getCommandStats() {
		return base.supergetCommandStats();
	}

	@Override
	public void setCommandStats(Object entity) {
		base.supersetCommandStats(entity);
	}

	@Override
	public Object getNBTTagCompound() {
		return base.supergetNBTTagCompound();
	}

	@Override
	public void clientUpdateEntityNBT(Object nBTTagCompound) {
		base.superclientUpdateEntityNBT(nBTTagCompound);
	}

	@Override
	public boolean interactAt(Object entityPlayer, Object vec3) {
		return base.superinteractAt(entityPlayer, vec3);
	}

	@Override
	public boolean isImmuneToExplosions() {
		return base.superisImmuneToExplosions();
	}

	@Override
	public void applyEnchantments(Object entityLivingBase, Object entity) {
		base.superapplyEnchantments(entityLivingBase, entity);
	}

	@Override
	public void heal(int par1) {
		base.superheal(par1);
	}

	@Override
	public void damageEntity(Object damageSource, int par2) {
		base.superdamageEntity(damageSource, par2);
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
	public void sendChatToPlayer(String par1Str) {
		base.supersendChatToPlayer(par1Str);
	}

	@Override
	public boolean canAttackPlayer(Object entityPlayer) {
		return base.supercanAttackPlayer(entityPlayer);
	}

	@Override
	public void alertWolves(Object entityLiving, boolean par2) {
		base.superalertWolves(entityLiving, par2);
	}

	@Override
	public void damageArmor(int par1) {
		base.superdamageArmor(par1);
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
	public Object getLastAttackingEntity() {
		return base.supergetLastAttackingEntity();
	}

	@Override
	public void setLastAttackingEntity(Object entity) {
		base.supersetLastAttackingEntity(entity);
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
	public void setEntityHealth(int par1) {
		base.supersetEntityHealth(par1);
	}

	@Override
	public Object applyArmorCalculations(Object damageSource, int par2) {
		return base.superapplyArmorCalculations(damageSource, par2);
	}

	@Override
	public Object applyPotionDamageCalculations(Object damageSource, int par2) {
		return base.superapplyPotionDamageCalculations(damageSource, par2);
	}

	@Override
	public String getAmbientSound() {
		return base.supergetLivingSound();
	}

	@Override
	public void knockBack(Object entity, int par2, double par3, double par5) {
		base.superknockBack(entity, par2, par3, par5);
	}

	@Override
	public void onChangedPotionEffect(Object potionEffect) {
		base.superonChangedPotionEffect(potionEffect);
	}

	@Override
	public float getSpeedModifier() {
		return base.supergetSpeedModifier();
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
	public void func_96120_a(int par1, float par2) {
		base.superfunc_96120_a(par1, par2);
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

	@Override
	public Object getItemStackFromSlot(int par1) {
		return base.supergetItemStackFromSlot(par1);
	}

	@Override
	public void setInPortal() {
		base.supersetInPortal();
	}

	@Override
	public void setRenderYawOffset(float p_181013_1_) {
		base.supersetRenderYawOffset(p_181013_1_);
	}

	@Override
	public void swingArm(Object enumHand) {
		base.superswingArm(enumHand);
	}

	@Override
	public void updatePassenger(Object entity) {
		base.superupdatePassenger(entity);
	}

	@Override
	public void dropLoot(boolean p_184610_1_, int p_184610_2_, Object damageSource) {
		base.superdropLoot(p_184610_1_, p_184610_2_, damageSource);
	}

	@Override
	public void frostWalk(Object blockPos) {
		base.superfrostWalk(blockPos);
	}

	@Override
	public void playEquipSound(Object itemStack) {
		base.superplayEquipSound(itemStack);
	}

	@Override
	public Object removeActivePotionEffect(Object potion) {
		return base.superremoveActivePotionEffect(potion);
	}

	@Override
	public void removePotionEffect(Object potion) {
		base.superremovePotionEffect(potion);
	}

	@Override
	public void playHurtSound(Object damageSource) {
		base.superplayHurtSound(damageSource);
	}

	@Override
	public void damageShield(float p_184590_1_) {
		base.superdamageShield(p_184590_1_);
	}

	@Override
	public Object getHeldItemOffhand() {
		return base.supergetHeldItemOffhand();
	}

	@Override
	public Object getHeldItem(Object enumHand) {
		return base.supergetHeldItem(enumHand);
	}

	@Override
	public void setHeldItem(Object enumHand, Object itemStack) {
		base.supersetHeldItem(enumHand, itemStack);
	}

	@Override
	public Object getActiveHand() {
		return base.supergetActiveHand();
	}

	@Override
	public void updateActiveHand() {
		base.superupdateActiveHand();
	}

	@Override
	public void setActiveHand(Object enumHand) {
		base.supersetActiveHand(enumHand);
	}

	@Override
	public Object getActiveItemStack() {
		return base.supergetActiveItemStack();
	}

	@Override
	public int getItemInUseMaxCount() {
		return base.supergetItemInUseMaxCount();
	}

	@Override
	public void stopActiveHand() {
		base.superstopActiveHand();
	}

	@Override
	public void resetActiveHand() {
		base.superresetActiveHand();
	}

	@Override
	public boolean isActiveItemStackBlocking() {
		return base.superisActiveItemStackBlocking();
	}

	@Override
	public boolean isElytraFlying() {
		return base.superisElytraFlying();
	}

	@Override
	public int getTicksElytraFlying() {
		return base.supergetTicksElytraFlying();
	}

	@Override
	public boolean attemptTeleport(double x, double y, double z) {
		return base.superattemptTeleport(x, y, z);
	}

	@Override
	public boolean canBeHitWithPotion() {
		return base.supercanBeHitWithPotion();
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
	public void playSound(Object soundEvent, float p_85030_2_, float p_85030_3_) {
		base.superplaySound(soundEvent, p_85030_2_, p_85030_3_);
	}

	@Override
	public void playStepSound(int par1, int par2, int par3, Object par4) {
		base.superplayStepSound(par1, par2, par3, par4);
	}

	@Override
	public boolean isInRangeToRender3d(Object vec3) {
		return base.superisInRangeToRender3d(vec3);
	}

	@Override
	public boolean shouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, Object par6, float par7) {
		return base.supershouldExplodeBlock(explosion, world, par3, par4, par5, par6, par7);
	}

	@Override
	public boolean processInitialInteract(Object entityPlayer, Object itemStack, Object enumHand) {
		return base.superprocessInitialInteract(entityPlayer, itemStack, enumHand);
	}

	@Override
	public Object getTags() {
		return base.supergetTags();
	}

	@Override
	public boolean addTag(String tag) {
		return base.superaddTag(tag);
	}

	@Override
	public boolean removeTag(String tag) {
		return base.superremoveTag(tag);
	}

	@Override
	public void setDropItemsWhenDead(boolean p_184174_1_) {
		base.supersetDropItemsWhenDead(p_184174_1_);
	}

	@Override
	public void decrementTimeUntilPortal() {
		base.superdecrementTimeUntilPortal();
	}

	@Override
	public void resetPositionToBB() {
		base.superresetPositionToBB();
	}

	@Override
	public void applyOrientationToEntity(Object entity) {
		base.superapplyOrientationToEntity(entity);
	}

	@Override
	public boolean startRiding(Object entity, boolean force) {
		return base.superstartRiding(entity, force);
	}

	@Override
	public boolean canBeRidden(Object entity) {
		return base.supercanBeRidden(entity);
	}

	@Override
	public void removePassengers() {
		base.superremovePassengers();
	}

	@Override
	public void dismountRidingEntity() {
		base.superdismountRidingEntity();
	}

	@Override
	public void addPassenger(Object entity) {
		base.superaddPassenger(entity);
	}

	@Override
	public void removePassenger(Object entity) {
		base.superremovePassenger(entity);
	}

	@Override
	public boolean canFitPassenger(Object entity) {
		return base.supercanFitPassenger(entity);
	}

	@Override
	public Object getHeldEquipment() {
		return base.supergetHeldEquipment();
	}

	@Override
	public Object getArmorInventoryList() {
		return base.supergetArmorInventoryList();
	}

	@Override
	public Object getEquipmentAndArmor() {
		return base.supergetEquipmentAndArmor();
	}

	@Override
	public void setItemStackToSlot(Object entityEquipmentSlot, Object itemStack) {
		base.supersetItemStackToSlot(entityEquipmentSlot, itemStack);
	}

	@Override
	public boolean isBeingRidden() {
		return base.superisBeingRidden();
	}

	@Override
	public boolean isGlowing() {
		return base.superisGlowing();
	}

	@Override
	public void setGlowing(boolean p_184195_1_) {
		base.supersetGlowing(p_184195_1_);
	}

	@Override
	public boolean isOnScoreboardTeam(Object team) {
		return base.superisOnScoreboardTeam(team);
	}

	@Override
	public void setEntityInvulnerable(boolean isInvulnerable) {
		base.supersetEntityInvulnerable(isInvulnerable);
	}

	@Override
	public boolean isNonBoss() {
		return base.superisNonBoss();
	}

	@Override
	public void setUniqueId(UUID uniqueIdIn) {
		base.supersetUniqueId(uniqueIdIn);
	}

	@Override
	public void notifyDataManagerChange(Object dataParameter) {
		base.supernotifyDataManagerChange(dataParameter);
	}

	@Override
	public Object getAdjustedHorizontalFacing() {
		return base.supergetAdjustedHorizontalFacing();
	}

	@Override
	public Object getRenderBoundingBox() {
		return base.supergetRenderBoundingBox();
	}

	@Override
	public Object getServer() {
		return base.supergetServer();
	}

	@Override
	public Object applyPlayerInteraction(Object entityPlayer, Object vec3d, Object itemStack, Object enumHand) {
		return base.superapplyPlayerInteraction(entityPlayer, vec3d, itemStack, enumHand);
	}

	@Override
	public boolean hasCapability(Object capability, Object enumFacing) {
		return base.superhasCapability(capability, enumFacing);
	}

	@Override
	public void deserializeNBT(Object nBTTagCompound) {
		base.superdeserializeNBT(nBTTagCompound);
	}

	@Override
	public Object serializeNBT() {
		return base.superserializeNBT();
	}

	@Override
	public void addTrackingPlayer(Object entityPlayerMP) {
		base.superaddTrackingPlayer(entityPlayerMP);
	}

	@Override
	public void removeTrackingPlayer(Object entityPlayerMP) {
		base.superremoveTrackingPlayer(entityPlayerMP);
	}

	@Override
	public float getRotatedYaw(Object rotation) {
		return base.supergetRotatedYaw(rotation);
	}

	@Override
	public float getMirroredYaw(Object mirror) {
		return base.supergetMirroredYaw(mirror);
	}

	@Override
	public boolean setPositionNonDirty() {
		return base.supersetPositionNonDirty();
	}

	@Override
	public Object getControllingPassenger() {
		return base.supergetControllingPassenger();
	}

	@Override
	public Object getPassengers() {
		return base.supergetPassengers();
	}

	@Override
	public boolean isPassenger(Object entity) {
		return base.superisPassenger(entity);
	}

	@Override
	public Object getRecursivePassengers() {
		return base.supergetRecursivePassengers();
	}

	@Override
	public Object getLowestRidingEntity() {
		return base.supergetLowestRidingEntity();
	}

	@Override
	public boolean isRidingSameEntity(Object entity) {
		return base.superisRidingSameEntity(entity);
	}

	@Override
	public boolean isRidingOrBeingRiddenBy(Object entity) {
		return base.superisRidingOrBeingRiddenBy(entity);
	}

	@Override
	public boolean canPassengerSteer() {
		return base.supercanPassengerSteer();
	}

	@Override
	public Object getRidingEntity() {
		return base.supergetRidingEntity();
	}

	@Override
	public Object getPushReaction() {
		return base.supergetPushReaction();
	}

	@Override
	public Object getSoundCategory() {
		return base.supergetSoundCategory();
	}

	@Override
	public Object getCapability(Object capability, Object enumFacing) {
		return base.supergetCapability(capability, enumFacing);
	}

	@Override
	public Object getRecursivePassengersByType(Class entityClass) {
		return base.supergetRecursivePassengersByType(entityClass);
	}

	@Override
	public void openBook(Object itemStack, Object enumHand) {
		base.superopenBook(itemStack, enumHand);
	}

	@Override
	public Object interact(Object entity, Object itemStack, Object enumHand) {
		return base.superinteract(entity, itemStack, enumHand);
	}

	@Override
	public void setServerBrand(String brand) {
		base.supersetServerBrand(brand);
	}

	@Override
	public String getServerBrand() {
		return base.supergetServerBrand();
	}

	@Override
	public int getPermissionLevel() {
		return base.supergetPermissionLevel();
	}

	@Override
	public void setPermissionLevel(int p_184839_1_) {
		base.supersetPermissionLevel(p_184839_1_);
	}

	@Override
	public void displayGuiCommandBlock(Object tileEntityCommandBlock) {
		base.superdisplayGuiCommandBlock(tileEntityCommandBlock);
	}

	@Override
	public boolean isRowingBoat() {
		return base.superisRowingBoat();
	}

	@Override
	public boolean isCreative() {
		return base.superisCreative();
	}

	@Override
	public boolean isPlayerInfoSet() {
		return base.superisPlayerInfoSet();
	}

	@Override
	public Object getLocationElytra() {
		return base.supergetLocationElytra();
	}

	@Override
	public Object createCooldownTracker() {
		return base.supercreateCooldownTracker();
	}

	@Override
	public void updateSize() {
		base.superupdateSize();
	}

	@Override
	public void spawnSweepParticles() {
		base.superspawnSweepParticles();
	}

	@Override
	public boolean hasAchievement(Object achievement) {
		return base.superhasAchievement(achievement);
	}

	@Override
	public Object getPrimaryHand() {
		return base.supergetPrimaryHand();
	}

	@Override
	public void setPrimaryHand(Object enumHandSide) {
		base.supersetPrimaryHand(enumHandSide);
	}

	@Override
	public float getCooldownPeriod() {
		return base.supergetCooldownPeriod();
	}

	@Override
	public float getCooledAttackStrength(float adjustTicks) {
		return base.supergetCooledAttackStrength(adjustTicks);
	}

	@Override
	public void resetCooldown() {
		base.superresetCooldown();
	}

	@Override
	public Object getCooldownTracker() {
		return base.supergetCooldownTracker();
	}

	@Override
	public float getLuck() {
		return base.supergetLuck();
	}

	@Override
	public void addPrefix(Object iTextComponent) {
		base.superaddPrefix(iTextComponent);
	}

	@Override
	public void addSuffix(Object iTextComponent) {
		base.superaddSuffix(iTextComponent);
	}

	@Override
	public Collection getPrefixes() {
		return (Collection) (base.supergetPrefixes());
	}

	@Override
	public Collection getSuffixes() {
		return (Collection) (base.supergetSuffixes());
	}

	@Override
	public boolean ignoreItemEntityData() {
		return base.superignoreItemEntityData();
	}

	@Override
	public void setNoAI(boolean par1) {
		base.supersetNoAI(par1);
	}

	@Override
	public Object getCurrentArmor(int slotIn) {
		return base.supergetCurrentArmor(slotIn);
	}

	@Override
	public void setCurrentItemOrArmor(int p_70062_1_, Object itemStack) {
		base.supersetCurrentItemOrArmor(p_70062_1_, itemStack);
	}

	@Override
	public void setMaxHealth(Object floatOrInt) {
		base.supersetMaxHealth(floatOrInt);
	}

	@Override
	public boolean getAlwaysRenderNameTag() {
		return base.supergetAlwaysRenderNameTag();
	}

	@Override
	public void setAlwaysRenderNameTag(boolean p_174805_1_) {
		base.supersetAlwaysRenderNameTag(p_174805_1_);
	}

	@Override
	public String getCustomNameTag() {
		return base.supergetCustomNameTag();
	}

	@Override
	public void setCustomNameTag(String p_96094_1_) {
		base.supersetCustomNameTag(p_96094_1_);
	}

	@Override
	public boolean canPickUpLoot() {
		return base.supercanPickUpLoot();
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
	public Object getNavigator() {
		return base.supergetNavigator();
	}

	@Override
	public Object getEntitySenses() {
		return base.supergetEntitySenses();
	}

	@Override
	public Object getJumpHelper() {
		return base.supergetJumpHelper();
	}

	@Override
	public void eatGrassBonus() {
		base.supereatGrassBonus();
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
	public boolean canAttackClass(Class par1Class) {
		return base.supercanAttackClass(par1Class);
	}

	@Override
	public boolean isWithinHomeDistanceCurrentPosition() {
		return base.superisWithinHomeDistanceCurrentPosition();
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
	public void setMoveForward(float par1) {
		base.supersetMoveForward(par1);
	}

	@Override
	public int getDropItemId() {
		return base.supergetDropItemId();
	}

	@Override
	public void despawnEntity() {
		base.superdespawnEntity();
	}

	@Override
	public boolean canDespawn() {
		return base.supercanDespawn();
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
	public boolean canBeSteered() {
		return base.supercanBeSteered();
	}

	@Override
	public boolean isNoDespawnRequired() {
		return base.superisNoDespawnRequired();
	}

	@Override
	public void setCanPickUpLoot(boolean par1) {
		base.supersetCanPickUpLoot(par1);
	}

	@Override
	public boolean interact(Object entityPlayer) {
		return base.superinteract(entityPlayer);
	}

	@Override
	public String getCachedUniqueIdString() {
		return base.supergetCachedUniqueIdString();
	}

	@Override
	public String thisToString() {
		return getClass().getName() + "@" + Integer.toHexString(super.hashCode());
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
	public void dismountRidingEntity2() {
		base.superdismountRidingEntity();
	}

	@Override
	public void sendDeathMessage(Object damageSource) {
	}

	@Override
	public boolean canSendDeathMessage() {
		return false;
	}

	@Override
	public int getRidingEntityID() {
		// TODO
		Object o = base.getDataWatcherWatchableObject(16);
		return o instanceof Integer ? (Integer) o : 0;
	}

	@Override
	public void setRidingEntityID(int i) {
		base.setDataWatcherWatchableObject(16, i);
	}

	@Override
	public void updateRidden2() {
		boolean debug = false;
		Object entity = getRidingEntity2();
		if (debug) {
			Modchu_Debug.mDebug("Modchu_EntityPlayerSPMasterBasis updateRidden2 entity="+entity);
			Modchu_Debug.mDebug("Modchu_EntityPlayerSPMasterBasis updateRidden2 isRiding2()="+isRiding2());
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
					Modchu_Debug.mDebug("Modchu_EntityPlayerSPMasterBasis updateRidden2 isRiding2");
					Modchu_Debug.mdDebug("posX="+posX+" posY="+posY+" posZ="+posZ);
					Modchu_Debug.mdDebug("entityPosX="+entityPosX+" entityPosY="+entityPosY+" entityPosZ="+entityPosZ, 1);
				}
			}
		}
	}

	@Override
	public void onInitialSpawn(Object difficultyInstance, Object entityLivingData) {
	}

	@Override
	public boolean isDamageInvincible() {
		return false;
	}

	@Override
	public int getBrightnessForRender() {
		return base.supergetBrightnessForRender();
	}

	@Override
	public float getBrightness() {
		return base.supergetBrightness();
	}

	@Override
	public Object getTeleportDirection() {
		return base.supergetTeleportDirection();
	}

	@Override
	public void setAngles(float yaw, float pitch) {
		base.supersetAngles(yaw, pitch);
	}

	@Override
	public void addChatMessage(Object iTextComponent) {
		base.superaddChatMessage(iTextComponent);
	}

	@Override
	public boolean canCommandSenderUseCommand(int permLevel, String commandName) {
		return base.supercanCommandSenderUseCommand(permLevel, commandName);
	}

	@Override
	public void onInsideBlock(Object iBlockState) {
		base.superonInsideBlock(iBlockState);
	}

	@Override
	public float playFlySound(float p_191954_1_) {
		return base.superfunc_191954_d(p_191954_1_);
	}

	@Override
	public boolean makeFlySound() {
		return base.superfunc_191957_ae();
	}

	@Override
	public boolean hasNoGravity() {
		return base.superhasNoGravity();
	}

	@Override
	public void setNoGravity(boolean noGravity) {
		base.supersetNoGravity(noGravity);
	}

	@Override
	public boolean isOverWater() {
		return base.superfunc_191953_am();
	}

	@Override
	public Object getPitchYaw() {
		return base.supergetPitchYaw();
	}

	@Override
	public Object getForward() {
		return base.supergetForward();
	}

	@Override
	public boolean getIsInvulnerable() {
		return base.supergetIsInvulnerable();
	}

	@Override
	public boolean canTrample(Object world, Object block, Object blockPos, float fallDistance) {
		return base.supercanTrample(world, block, blockPos, fallDistance);
	}

	@Override
	public int getFireImmuneTicks() {
		return base.supergetFireImmuneTicks();
	}

	@Override
	public Map getActivePotionMap() {
		return base.supergetActivePotionMap();
	}

	@Override
	public void blockUsingShield(Object entityLivingBase) {
		base.superblockUsingShield(entityLivingBase);
	}

	@Override
	public Object getLastDamageSource() {
		return base.supergetLastDamageSource();
	}

	@Override
	public boolean hasItemInSlot(Object entityEquipmentSlot) {
		return base.superhasItemInSlot(entityEquipmentSlot);
	}

	@Override
	public float getWaterSlowDown() {
		return base.supergetWaterSlowDown();
	}

	@Override
	public boolean attackable() {
		return base.superattackable();
	}

	@Override
	public void setPartying(Object blockPos, boolean p_191987_2_) {
		base.supersetPartying(blockPos, p_191987_2_);
	}

	@Override
	public boolean processInitialInteract(Object entityPlayer, Object enumHand) {
		return base.superprocessInitialInteract(entityPlayer, enumHand);
	}

	@Override
	public Object applyPlayerInteraction(Object entityPlayer, Object vec3d, Object enumHand) {
		return base.superapplyPlayerInteraction(entityPlayer, vec3d, enumHand);
	}

	@Override
	public Object getRecipeBook() {
		return base.supergetRecipeBook();
	}

	@Override
	public void removeRecipeHighlight(Object iRecipe) {
		base.superfunc_193103_a(iRecipe);
	}

	@Override
	public void openEditStructure(Object tileEntityStructure) {
		base.superopenEditStructure(tileEntityStructure);
	}

	@Override
	public boolean isAutoJumpEnabled() {
		return base.superisAutoJumpEnabled();
	}

	@Override
	public void updateAutoJump(float p_189810_1_, float p_189810_2_) {
		base.superupdateAutoJump(p_189810_1_, p_189810_2_);
	}

	@Override
	public void destroyVanishingCursedItems() {
		base.superdestroyVanishingCursedItems();
	}

	@Override
	public void disableShield(boolean p_190777_1_) {
		base.superdisableShield(p_190777_1_);
	}

	@Override
	public void unlockRecipes(List p_192021_1_) {
		base.superunlockRecipes(p_192021_1_);
	}

	@Override
	public void unlockRecipes(Object[] resourceLocation) {
		base.superunlockRecipes(resourceLocation);
	}

	@Override
	public void resetRecipes(List p_192022_1_) {
		base.superfunc_192022_b(p_192022_1_);
	}

	@Override
	public boolean addItemStackToInventory(Object itemStack) {
		return base.superaddItemStackToInventory(itemStack);
	}

	@Override
	public boolean addShoulderEntity(Object nBTTagCompound) {
		return base.superaddShoulderEntity(nBTTagCompound);
	}

	@Override
	public void spawnShoulderEntities() {
		base.superspawnShoulderEntities();
	}

	@Override
	public Object getLeftShoulderEntity() {
		return base.supergetLeftShoulderEntity();
	}

	@Override
	public void setLeftShoulderEntity(Object nBTTagCompound) {
		base.supersetLeftShoulderEntity(nBTTagCompound);
	}

	@Override
	public Object getRightShoulderEntity() {
		return base.supergetRightShoulderEntity();
	}

	@Override
	public void setRightShoulderEntity(Object nBTTagCompound) {
		base.supersetRightShoulderEntity(nBTTagCompound);
	}

	@Override
	public boolean canUseCommandBlock() {
		return base.supercanUseCommandBlock();
	}

	@Override
	public boolean hasSpawnDimension() {
		return base.superhasSpawnDimension();
	}

	@Override
	public int getSpawnDimension() {
		return base.supergetSpawnDimension();
	}

	@Override
	public void setSpawnDimension(Object integer) {
		base.supersetSpawnDimension(integer);
	}

}