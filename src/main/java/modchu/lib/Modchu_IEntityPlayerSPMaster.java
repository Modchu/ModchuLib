package modchu.lib;

import java.util.Collection;

public interface Modchu_IEntityPlayerSPMaster extends Modchu_IEntityLivingBaseMaster {
	public void init();
	public void wakeUpPlayer(boolean flag, boolean flag1, boolean flag2);
	public void setPositionCorrection(double par1, double par3, double par5);
	public Object copyPlayer(Object entityplayer);
	public Object copyInventory(Object inventoryplayer);
	public boolean attackEntityFrom(Object var1, Object damageSource, int i);
	public void sendMotionUpdates();
	public float getMaxHealth();
	public int getMaxHealthInt();
	public int getHealthInt();
	public void setHealthInt(int i);
	public Object dropOneItem(boolean par1);
	public Object dropItemAndGetStack(Object entityItem);
	public void sendChatMessage(String par1Str);
	public void swingArm();
	public void respawnPlayer();
	public void closeScreen();
	public void func_92015_f();
	public void setPlayerSPHealth(float par1);
	public void addStat(Object statBase, int par2);
	public void incrementStat(Object statBase, int par2);
	public void sendPlayerAbilities();
	public void func_110318_g();
	public void func_110322_i();
	public void func_142020_c(String par1Str);
	public String func_142021_k();
	public float getFOVMultiplier();
	public void displayGUIEditSign(Object tileEntity);
	public void openBook(Object itemStack);
	public void displayGUIChest(Object iInventory);
	public void displayGUIHopper(Object tileEntityHopper);
	public void displayGUIHopperMinecart(Object entityMinecartHopper);
	public void openGuiHorseInventory(Object entityHorse, Object iInventory);
	public void displayGUIWorkbench(int par1, int par2, int par3);
	public void displayGUIEnchantment(int par1, int par2, int par3, String par4Str);
	public void displayGUIAnvil(int par1, int par2, int par3);
	public void displayGUIFurnace(Object tileEntityFurnace);
	public void displayGUIBrewingStand(Object tileEntityBrewingStand);
	public void displayGUIBeacon(Object tileEntityBeacon);
	public void displayGUIDispenser(Object tileEntityDispenser);
	public void displayGUIMerchant(Object iMerchant, String par2Str);
	public void onCriticalHit(Object entity);
	public void onEnchantmentCritical(Object entity);
	public void addChatMessage(String par1Str);
	public void setXPStats(float par1, int par2, int par3);
	public void sendChatToPlayer(Object chatMessageComponent);
	public Object getPlayerCoordinates();
	public Object getHeldItem();
	public void playSound(String par1Str, float par2, float par3);
	public boolean isRidingHorse();
	public float getHorseJumpPower();
	public void setupCustomSkin();
	public Object getTextureSkin();
	public Object getTextureCape();
	public Object getLocationSkin();
	public Object getLocationCape();
	public Object getItemInUse();
	public boolean isHandActive();
	public int getItemInUseDuration();
	public void stopUsingItem();
	public void clearItemInUse();
	public boolean startRiding(Object entity);
	public int getScore();
	public void setScore(int par1);
	public void addScore(int par1);
	public Object dropPlayerItem(Object itemStack);
	public Object dropPlayerItemWithRandomChoice(Object itemStack, boolean par2);
	public float getCurrentPlayerStrVsBlock(Object block, boolean par2);
	public float getCurrentPlayerStrVsBlock(Object block, boolean par2, int meta);
	public boolean canHarvestBlock(Object block);
	public boolean canAttackPlayer(Object entityPlayer);
	public float getArmorVisibility();
	public boolean interactWith(Object entity);
	public Object getHeldItemMainhand();
	public void destroyCurrentEquippedItem();
	public void attackTargetEntityWithCurrentItem(Object entity);
	public Object sleepInBedAt(int par1, int par2, int par3);
	public float getBedOrientationInDegrees();
	public boolean isPlayerFullyAsleep();
	public int getSleepTimer();
	public boolean getHideCape(int par1);
	public void setHideCape(int par1, boolean par2);
	public Object getBedLocation();
	public boolean isSpawnForced();
	public Object getBedLocation(int dimension);
	public boolean isSpawnForced(int dimension);
	public void setSpawnChunk(Object chunkCoordinates, boolean par2);
	public void setSpawnChunk(Object chunkCoordinates, boolean forced, int dimension);
	public void addStat(Object statBase);
	public void addMovementStat(double par1, double par3, double par5);
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
	public String getEntityName();
	public void clonePlayer(Object entityPlayer, boolean par2);
	public void setGameType(Object enumGameType);
	public Object getInventoryEnderChest();
	public Object getCurrentItemOrArmor(int par1);
	public void setItemStackToSlot(int par1, Object itemStack);
	public boolean getHideCape();
	public Object getWorldScoreboard();
	public void openGui(Object mod, int modGuiId, Object world, int x, int y, int z);
	public float getDefaultEyeHeight();
	public void refreshDisplayName();
	public int func_142015_aE();
	public Object func_110142_aN();
	public Object getAttackingEntity();
	public float updateDistance(float par1, float par2);
	public Object getDataManager();
	public void playStepSound(int par1, int par2, int par3, int par4);
	public boolean isInRangeToRenderVec3D(Object vec3);
	public boolean writeToNBTAtomically(Object nBTTagCompound);
	public boolean processInitialInteract(Object entityPlayer);
	public Object changeDimension(int par1);
	public boolean shouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7);
	public Object getCurrentArmor(int slotIn);
	public boolean getAlwaysRenderNameTag();
	public void setAlwaysRenderNameTag(boolean p_174805_1_);
	public Object getLastPortalVec();
	public String getCustomNameTag();
	public void setCustomNameTag(String p_96094_1_);
	// ~152
	public boolean func_71066_bF();
	public void sendChatToPlayer(String par1Str);
	public void alertWolves(Object entityLiving, boolean par2);
	public boolean canCurrentToolHarvestBlock(int par1, int par2, int par3);
	public Object getTranslator();
	public String translateString(String par1Str, Object... par2ArrayOfObj);
	// 172~
	public void closeScreenNoPacket();
	public Object getStatFileWriter();
	public void func_146100_a(Object tileEntity);
	public void func_146095_a(Object commandBlockLogic);
	public void func_146093_a(Object tileEntityHopper);
	public void func_146104_a(Object tileEntityBeacon);
	public void func_146102_a(Object tileEntityDispenser);
	public void func_146098_a(Object tileEntityBrewingStand);
	public void func_146101_a(Object tileEntityFurnace);
	public void addChatComponentMessage(Object iChatComponent);
	public float getBreakSpeed(Object block, boolean p_146096_2_, int meta);
	public float getBreakSpeed(Object block, boolean p_146096_2_, int meta, int x, int y, int z);
	public Object func_146097_a(Object itemStack, boolean p_146097_2_, boolean p_146097_3_);
	public Object getGameProfile();
	public String func_146067_o(int p_146067_1_);
	// 179~
	public boolean func_152122_n();
	public boolean func_152123_o();
	public void func_152121_a(Object type, Object resourceLocation);
	// 180~
	public void onUpdateWalkingPlayer();
	public void closeScreenAndDropStack();
	public boolean isUser();
	public void sendHorseJump();
	public void sendHorseInventory();
	public void setClientBrand(String brand);
	public String getClientBrand();
	public void openEditSign(Object tileEntitySign);
	public void displayGuiEditCommandCart(Object commandBlockBaseLogic);
	public void displayGui(Object iInteractionObject);
	public void displayVillagerTradeGui(Object iMerchant);
	public boolean isCurrentViewEntity();
	public boolean isSpectator();
	public boolean hasPlayerInfo();
	public Object getPlayerInfo();
	public boolean hasSkin();
	public String getSkinType();
	public float getFovModifier();
	public Object dropItem(Object itemStack, boolean dropAround, boolean traceItem);
	public float getDigSpeed(Object block);
	public float getBreakSpeed(Object iBlockState, Object blockPos);
	public Object trySleep(Object blockPos);
	public void setSpawnPoint(Object blockPos, boolean forced);
	public void takeStat(Object statBase);
	public int getXPSeed();
	public void removeExperienceLevel(int levels);
	public boolean isAllowEdit();
	public boolean canPlayerEdit(Object blockPos, Object enumFacing, Object itemStack);
	public boolean canOpen(Object lockCode);
	public boolean isWearing(Object enumPlayerModelParts);
	public boolean hasReducedDebug();
	public void setReducedDebug(boolean reducedDebug);
	public String getDisplayNameString();
	public void dropLoot();
	public void setCommandStats(Object entity);
	public void openBook(Object itemStack, Object enumHand);
	// 190~
	public Object interact(Object entity, Object itemStack, Object enumHand);
	public void setServerBrand(String brand);
	public String getServerBrand();
	public int getPermissionLevel();
	public void setPermissionLevel(int p_184839_1_);
	public void displayGuiCommandBlock(Object tileEntityCommandBlock);
	public boolean isRowingBoat();
	public boolean isCreative();
	public boolean isPlayerInfoSet();
	public Object getLocationElytra();
	public Object createCooldownTracker();
	public void updateSize();
	public void spawnSweepParticles();
	public boolean hasAchievement(Object achievement);
	public Object getPrimaryHand();
	public void setPrimaryHand(Object enumHandSide);
	public float getCooldownPeriod();
	public float getCooledAttackStrength(float adjustTicks);
	public void resetCooldown();
	public Object getCooldownTracker();
	public float getLuck();
	public void addPrefix(Object iTextComponent);
	public void addSuffix(Object iTextComponent);
	public Collection getPrefixes();
	public Collection getSuffixes();
	public boolean canPickUpLoot();
	public Object getLookHelper();
	public Object getMoveHelper();
	public Object getNavigator();
	public Object getEntitySenses();
	public Object getJumpHelper();
	public void eatGrassBonus();
	public Object getAttackTarget();
	public void setAttackTarget(Object entityLiving);
	public boolean canAttackClass(Class par1Class);
	public boolean isWithinHomeDistanceCurrentPosition();
	public int getTalkInterval();
	public void playLivingSound();
	public void spawnExplosionParticle();
	public void setMoveForward(float par1);
	public int getDropItemId();
	public void despawnEntity();
	public boolean canDespawn();
	public int getVerticalFaceSpeed();
	public void faceEntity(Object entity, float par2, float par3);
	public boolean getCanSpawnHere();
	public float getRenderSizeModifier();
	public int getMaxSpawnedInChunk();
	public boolean canBeSteered();
	public boolean isNoDespawnRequired();
	public void setCanPickUpLoot(boolean par1);
	public boolean interact(Object entityPlayer);

}
