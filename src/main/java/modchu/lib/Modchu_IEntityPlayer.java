package modchu.lib;

import java.util.Random;
import java.util.UUID;

public interface Modchu_IEntityPlayer {
	public void supersendChatToPlayer(Object chatMessageComponent);
	public boolean supercanCommandSenderUseCommand(int i, String s);
	public Object supergetPlayerCoordinates();
	public void superapplyEntityAttributes();
	public void superentityInit();
	public Object supergetItemInUse();
	public int supergetItemInUseCount();
	public boolean superisHandActive();
	public int supergetItemInUseDuration();
	public void superstopUsingItem();
	public void superclearItemInUse();
	public boolean superisBlocking();
	public void superonUpdate();
	public int supergetMaxInPortalTime();
	public int supergetPortalCooldown();
	public void superplaySound(String par1Str, float par2, float par3);
	public void superupdateItemUse(Object itemStack, int par2);
	public void superonItemUseFinish();
	public void superhandleStatusUpdate(byte par1);
	public boolean superisMovementBlocked();
	public void supercloseScreen();
	public boolean superstartRiding(Object entity);
	public void superupdateEntityActionState();
	public int supergetScore();
	public void supersetScore(int par1);
	public void superaddScore(int par1);
	public void superaddToPlayerScore(Object entity, int par2);
	public Object superdropItem(boolean par1);
	public Object superdropPlayerItem(Object itemStack);
	public Object superdropItem(Object itemStack, boolean par2);
	public void superdropItemAndGetStack(Object entityItem);
	public float supergetCurrentPlayerStrVsBlock(Object block, boolean par2);
	public float supergetCurrentPlayerStrVsBlock(Object block, boolean par2, int meta);
	public boolean supercanHarvestBlock(Object block);
	public void superreadEntityFromNBT(Object nBTTagCompound);
	public void superwriteEntityToNBT(Object nBTTagCompound);
	public void superdisplayGUIChest(Object iInventory);
	public void superdisplayGUIHopper(Object tileEntityHopper);
	public void superdisplayGUIHopperMinecart(Object entityMinecartHopper);
	public void superopenGuiHorseInventory(Object entityHorse, Object iInventory);
	public void superdisplayGUIEnchantment(int par1, int par2, int par3, String par4Str);
	public void superdisplayGUIAnvil(int par1, int par2, int par3);
	public void superdisplayGUIWorkbench(int par1, int par2, int par3);
	public float supergetEyeHeight();
	public boolean superattackEntityFrom(Object damageSource, float par2);
	public boolean supercanAttackPlayer(Object entityPlayer);
	public void superdamageArmor(float par1);
	public int supergetTotalArmorValue();
	public float supergetArmorVisibility();
	public void superdamageEntity(Object damageSource, float par2);
	public void superdisplayGUIFurnace(Object tileEntityFurnace);
	public void superdisplayGUIDispenser(Object tileEntityDispenser);
	public void superdisplayGUIEditSign(Object tileEntity);
	public void superdisplayGUIBrewingStand(Object tileEntityBrewingStand);
	public void superdisplayGUIBeacon(Object tileEntityBeacon);
	public void superdisplayGUIMerchant(Object iMerchant, String par2Str);
	public void superopenBook(Object itemStack);
	public boolean superinteractWith(Object entity);
	public Object supergetHeldItemMainhand();
	public void superdestroyCurrentEquippedItem();
	public void superattackTargetEntityWithCurrentItem(Object entity);
	public void superonCriticalHit(Object entity);
	public void superonEnchantmentCritical(Object entity);
	public void superrespawnPlayer();
	public void supersetDead();
	public Object supersleepInBedAt(int par1, int par2, int par3);
	public float supergetBedOrientationInDegrees();
	public boolean superisPlayerSleeping();
	public boolean superisPlayerFullyAsleep();
	public int supergetSleepTimer();
	public boolean supergetHideCape(int par1);
	public void supersetHideCape(int par1, boolean par2);
	public void superaddChatMessage(String par1Str);
	public Object supergetBedLocation();
	public boolean superisSpawnForced();
	public Object supergetBedLocation(int dimension);
	public boolean superisSpawnForced(int dimension);
	public void supersetSpawnChunk(Object chunkCoordinates, boolean par2);
	public void supersetSpawnChunk(Object chunkCoordinates, boolean forced, int dimension);
	public void superaddStat(Object statBase);
	public void superaddStat(Object statBase, int par2);
	public void superjump();
	public float supergetAIMoveSpeed();
	public void superaddMovementStat(double par1, double par3, double par5);
	public void superfall(float par1);
	public void superonKillEntity(Object entityLivingBase);
	public void supersetInWeb();
	public Object supergetItemIcon(Object itemStack, int par2);
	public Object supergetCurrentArmor(int par1);
	public void superaddExperience(int par1);
	public void superaddExperienceLevel(int par1);
	public int superxpBarCap();
	public void superaddExhaustion(float par1);
	public Object supergetFoodStats();
	public boolean supercanEat(boolean par1);
	public boolean supershouldHeal();
	public void supersetItemInUse(Object itemStack, int par2);
	public boolean superisCurrentToolAdventureModeExempt(int par1, int par2, int par3);
	public boolean supercanPlayerEdit(int par1, int par2, int par3, int par4, Object itemStack);
	public int supergetExperiencePoints(Object entityPlayer);
	public boolean superisPlayer();
	public String supergetEntityName();
	public boolean supergetAlwaysRenderNameTagForRender();
	public void superclonePlayer(Object entityPlayer, boolean par2);
	public boolean supercanTriggerWalking();
	public void supersendPlayerAbilities();
	public void supersetGameType(Object enumGameType);
	public String supergetName();
	public Object supergetEntityWorld();
	public Object supergetInventoryEnderChest();
	public Object supergetCurrentItemOrArmor(int par1);
	public Object supergetHeldItem();
	public void supersetCurrentItemOrArmor(int par1, Object itemStack);
	public boolean superisInvisibleToPlayer(Object entityPlayer);
	public Object[] supergetLastActiveItems();
	public boolean supergetHideCape();
	public boolean superisPushedByWater();
	public Object supergetWorldScoreboard();
	public Object supergetTeam();
	public String supergetTranslatedEntityName();
	public void supersetAbsorptionAmount(float par1);
	public float supergetAbsorptionAmount();
	public void superopenGui(Object mod, int modGuiId, Object world, int x, int y, int z);
	public float supergetDefaultEyeHeight();
	public String supergetDisplayName();
	public void superrefreshDisplayName();
	public void superupdateFallState(double par1, boolean par3);
	public boolean supercanBreatheUnderwater();
	public void superonEntityUpdate();
	public boolean superisChild();
	public void superonDeathUpdate();
	public int superdecreaseAirSupply(int par1);
	public Random supergetRNG();
	public Object supergetAITarget();
	public int superfunc_142015_aE();
	public void supersetRevengeTarget(Object entityLivingBase);
	public Object supergetLastAttacker();
	public int supergetLastAttackerTime();
	public void supersetLastAttacker(Object entity);
	public int supergetAge();
	public void superupdatePotionEffects();
	public void superclearActivePotions();
	public Object supergetActivePotionEffects();
	public boolean superisPotionActive(int par1);
	public boolean superisPotionActive(Object potion);
	public Object supergetActivePotionEffect(Object potion);
	public void superaddPotionEffect(Object potionEffect);
	public boolean superisPotionApplicable(Object potionEffect);
	public boolean superisEntityUndead();
	public void superremovePotionEffectClient(int par1);
	public void superremovePotionEffect(int par1);
	public void superonNewPotionEffect(Object potionEffect);
	public void superonChangedPotionEffect(Object potionEffect, boolean par2);
	public void superonFinishedPotionEffect(Object potionEffect);
	public void superheal(float par1);
	public void superrenderBrokenItemStack(Object itemStack);
	public void superdropEquipment(boolean par1, int par2);
	public void superknockBack(Object entity, float par2, double par3, double par5);
	public String supergetDeathSound();
	public void superdropRareDrop(int par1);
	public void superdropFewItems(boolean par1, int par2);
	public boolean superisOnLadder();
	public boolean superisEntityAlive();
	public void superperformHurtAnimation();
	public Object superapplyArmorCalculations(Object damageSource, float par2);
	public Object superapplyPotionDamageCalculations(Object damageSource, float par2);
	public Object superfunc_110142_aN();
	public Object supergetAttackingEntity();
	public void superswingArm();
	public void superkill();
	public void superupdateArmSwingProgress();
	public Object supergetEntityAttribute(Object attribute);
	public Object supergetAttributeMap();
	public void supersetSprinting(boolean par1);
	public float supergetSoundVolume();
	public float supergetSoundPitch();
	public void supersetPositionAndUpdate(double par1, double par3, double par5);
	public void superdismountEntity(Object entity);
	public boolean superisAIEnabled();
	public void supersetAIMoveSpeed(float par1);
	public boolean superattackEntityAsMob(Object entity);
	public float superupdateDistance(float par1, float par2);
	public void superupdateAITasks();
	public void supercollideWithNearbyEntities();
	public void supercollideWithEntity(Object entity);
	public void supersetPositionAndRotationDirect(double par1, double par3, double par5, float par7, float par8, int par9);
	public void superhandleJumpWater();
	public void supersetJumping(boolean par1);
	public void superonItemPickup(Object entity, int par2);
	public boolean supercanEntityBeSeen(Object entity);
	public Object supergetLookVec();
	public Object supergetLook(float par1);
	public float supergetSwingProgress(float par1);
	public Object supergetPosition(float par1);
	public Object superrayTrace(double par1, float par3);
	public boolean superisClientWorld();
	public boolean supercanBeCollidedWith();
	public boolean supercanBePushed();
	public void supersetBeenAttacked();
	public float supergetRotationYawHead();
	public void supersetRotationYawHead(float par1);
	public boolean superisOnSameTeam(Object entityLivingBase);
	public boolean superisOnTeam(Object team);
	public void supercurePotionEffects(Object itemStack);
	public boolean supershouldRiderFaceForward(Object entityPlayer);
	public Object supergetDataManager();
	//public boolean superequals(Object par1Obj);
	//public int superhashCode();
	public void supersetRotation(float par1, float par2);
	public void supersetPosition(double par1, double par3, double par5);
	public void supersetAngles(float par1, float par2);
	public void supersetOnFireFromLava();
	public void supersetFire(int par1);
	public void superextinguish();
	public boolean superisOffsetPositionInLiquid(double par1, double par3, double par5);
	public void supermoveEntity(double par1, double par3, double par5);
	public void superdoBlockCollisions();
	public void superplayStepSound(int par1, int par2, int par3, int par4);
	public Object supergetCollisionBoundingBox();
	public void superdealFireDamage(int par1);
	public boolean superisWet();
	public boolean superisInWater();
	public boolean superhandleWaterMovement();
	public boolean superisInsideOfMaterial(Object material);
	public boolean superhandleLavaMovement();
	public void supermoveRelative(float par1, float par2, float par3);
	public int supergetBrightnessForRender(float par1);
	public float supergetBrightness(float par1);
	public void supersetWorld(Object world);
	public void supersetPositionAndRotation(double par1, double par3, double par5, float par7, float par8);
	public void supersetLocationAndAngles(double par1, double par3, double par5, float par7, float par8);
	public float supergetDistanceToEntity(Object entity);
	public double supergetDistanceSq(double par1, double par3, double par5);
	public double supergetDistance(double par1, double par3, double par5);
	public double supergetDistanceSqToEntity(Object entity);
	public void superonCollideWithPlayer(Object entityPlayer);
	public void superapplyEntityCollision(Object entity);
	public void superaddVelocity(double par1, double par3, double par5);
	public boolean superisInRangeToRenderVec3D(Object vec3);
	public boolean superisInRangeToRenderDist(double par1);
	public boolean superwriteToNBTAtomically(Object nBTTagCompound);
	public boolean superwriteToNBTOptional(Object nBTTagCompound);
	public void superwriteToNBT(Object nBTTagCompound);
	public void superreadFromNBT(Object nBTTagCompound);
	public boolean supershouldSetPosAfterLoading();
	public void superonChunkLoad();
	public Object supernewDoubleNBTList(double... par1ArrayOfDouble);
	public Object supernewFloatNBTList(float... par1ArrayOfFloat);
	public float supergetShadowSize();
	public Object superdropItem(int par1, int par2);
	public Object superdropItemWithOffset(int par1, int par2, float par3);
	public Object superentityDropItem(Object itemStack, float par2);
	public boolean superprocessInitialInteract(Object entityPlayer);
	public Object supergetCollisionBox(Object entity);
	public void superupdatePassenger();
	public float supergetCollisionBorderSize();
	public void supersetPortal(Object bockPos);
	public void supersetVelocity(double par1, double par3, double par5);
	public boolean superisBurning();
	public boolean superisRiding();
	public boolean superisSneaking();
	public void supersetSneaking(boolean par1);
	public boolean superisSprinting();
	public boolean superisInvisible();
	public void supersetInvisible(boolean par1);
	public boolean superisEating();
	public void supersetEating(boolean par1);
	public boolean supergetFlag(int par1);
	public void supersetFlag(int par1, boolean par2);
	public int supergetAir();
	public void supersetAir(int par1);
	public void superonStruckByLightning(Object entityLightningBolt);
	public Object[] supergetParts();
	public boolean superisEntityEqual(Object entity);
	public boolean supercanBeAttackedWithItem();
	public boolean superhitByEntity(Object entity);
	//public String supertoString();
	public boolean superisEntityInvulnerable();
	public void supercopyLocationAndAnglesFrom(Object entity);
	public void supercopyDataFrom(Object entity, boolean par2);
	public void superchangeDimension(int par1);
	public float supergetBlockExplosionResistance(Object explosion, Object world, int par3, int par4, int par5, Object block);
	public boolean supershouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7);
	public int supergetMaxSafePointTries();
	public Object supergetLastPortalVec();
	public boolean superdoesEntityNotTriggerPressurePlate();
	public void superaddEntityCrashInfo(Object crashReportCategory);
	public boolean supercanRenderOnFire();
	public UUID supergetUniqueID();
	public Object supergetEntityData();
	public boolean supershouldRiderSit();
	public Object supergetPickedResult(Object movingObjectPosition);
	public UUID supergetPersistentID();
	public boolean supershouldRenderInPass(int pass);
	public boolean superisCreatureType(Object enumCreatureType, boolean forSpawnCount);
	public String superregisterExtendedProperties(String identifier, Object iExtendedEntityProperties);
	public Object supergetExtendedProperties(String identifier);
	public boolean supercanRiderInteract();
	public boolean supershouldDismountInWater(Object entity);
	public boolean superpushOutOfBlocks(double d, double d1, double d2);
	public Object supercopyPlayer(Object entityplayer);
	public boolean superattackEntityFrom(Object damageSource, int par2);
	public void superwakeUpPlayer(boolean flag, boolean flag1, boolean flag2);
	public void superpreparePlayerToSpawn();
	public void supersetPositionCorrection(double par1, double par3, double par5);
	public void superonLivingUpdate();
	public void supermoveEntityWithHeading(float f, float f1);
	public String supergetHurtSound();
	public double supergetMountedYOffset();
	public void superresetHeight();
	public double supergetYOffset();
	public boolean superisEntityInsideOpaqueBlock();
	public Object supercopyInventory(Object inventoryplayer);
	public boolean superattackEntityFrom(Object entity, Object damageSource, int i);
	public int supergetMaxHealthInt();
	public int supergetHealthInt();
	public void supersetHealth(float f);
	public void supersetHealthInt(int i);
	public void supercloseScreenNoPacket();
	public Object supergetStatFileWriter();
	public void superfunc_146100_a(Object tileEntity);
	public void superfunc_146095_a(Object commandBlockLogic);
	public void superfunc_146093_a(Object tileEntityHopper);
	public void superfunc_146104_a(Object tileEntityBeacon);
	public void superfunc_146102_a(Object tileEntityDispenser);
	public void superfunc_146098_a(Object tileEntityBrewingStand);
	public void superfunc_146101_a(Object tileEntityFurnace);
	public void superaddChatMessage(Object iChatComponent);
	public void superaddChatComponentMessage(Object iChatComponent);
	public String supergetSplashSound();
	public String supergetSwimSound();
	public float supergetBreakSpeed(Object block, boolean p_146096_2_, int meta);
	public float supergetBreakSpeed(Object block, boolean p_146096_2_, int meta, int x, int y, int z);
	public Object superfunc_146097_a(Object itemStack, boolean p_146097_2_, boolean p_146097_3_);
	public Object supergetGameProfile();
	public String superfunc_146067_o(int p_146067_1_);
	public Object supergetEquipmentInSlot(int par1);
	public Object superfunc_145748_c_();
	public boolean superfunc_146066_aG();
	public int supergetEntityId();
	public void supersetEntityId(int p_145769_1_);
	public void superfunc_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Object block);
	public void superfunc_145775_I();
	public boolean superisInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_);
	public Object superfunc_145778_a(Object item, int p_145778_2_, float p_145778_3_);
	public Object superdropItem(Object item, int p_145779_2_);
	public float superfunc_145772_a(Object explosion, Object world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Object block);
	public boolean superfunc_145774_a(Object explosion, Object world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Object block, float p_145774_7_);
	public void superfunc_145781_i(int p_145781_1_);
	public boolean superfunc_152122_n();
	public boolean superfunc_152123_o();
	public void superfunc_152121_a(Object type, Object resourceLocation);
	public void superfunc_152111_bt();
	public void superfunc_152112_bu();
	public void superonUpdateWalkingPlayer();
	public void superfunc_175159_q();
	public boolean superisUser();
	public void supersendHorseJump();
	public void supersendHorseInventory();
	public void supersetClientBrand(String brand);
	public String supergetClientBrand();
	public boolean supercanUseCommand(int permLevel, String commandName);
	public Object supergetPosition();
	public boolean superisServerWorld();
	public void superopenEditSign(Object tileEntitySign);
	public void superopenEditCommandBlock(Object commandBlockLogic);
	public void superdisplayGui(Object iInteractionObject);
	public void superdisplayVillagerTradeGui(Object iMerchant);
	public boolean superisCurrentViewEntity();
	public boolean superisSpectator();
	public boolean superhasPlayerInfo();
	public Object supergetPlayerInfo();
	public boolean superhasSkin();
	public String supergetSkinType();
	public float supergetFovModifier();
	public Object superdropItem(Object itemStack, boolean dropAround, boolean traceItem);
	public float supergetToolDigEfficiency(Object block);
	public float supergetBreakSpeed(Object iBlockState, Object blockPos);
	public Object supertrySleep(Object blockPos);
	public void supersetSpawnPoint(Object blockPos, boolean forced);
	public void superfunc_175145_a(Object statBase);
	public void superfall(float distance, float damageMultiplier);
	public String supergetFallSoundString(int damageValue);
	public int supergetXPSeed();
	public void superremoveExperienceLevel(int levels);
	public boolean superisAllowEdit();
	public boolean supercanPlayerEdit(Object blockPos, Object enumFacing, Object itemStack);
	public Object[] supergetInventory();
	public boolean supercanOpen(Object lockCode);
	public boolean superfunc_175148_a(Object enumPlayerModelParts);
	public boolean supersendCommandFeedback();
	public boolean superreplaceItemInInventory(int p_174820_1_, Object itemStack);
	public boolean superhasReducedDebug();
	public void supersetReducedDebug(boolean reducedDebug);
	public String supergetDisplayNameString();
	public void superonKillCommand();
	public void superfunc_180433_a(double p_180433_1_, boolean p_180433_3_, Object block, Object blockPos);
	public int supergetRevengeTimer();
	public void superfunc_175135_B();
	public void superfunc_175133_bi();
	public void superaddRandomDrop();
	public Object supergetCombatTracker();
	public float superfunc_175134_bD();
	public void superfunc_180466_bG();
	public void superfunc_180426_a(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_);
	public void superfunc_175136_bO();
	public void superplayStepSound(Object blockPos, Object block);
	public boolean superisSilent();
	public void supersetSilent(boolean isSilent);
	public void superspawnRunningParticles();
	public void supercreateRunningParticles();
	public boolean superisInLava();
	public void supermoveToBlockPosAndAngles(Object blockPos, float p_174828_2_, float p_174828_3_);
	public double supergetDistanceSq(Object blockPos);
	public double supergetDistanceSqToCenter(Object blockPos);
	public Object supergetPositionEyes(float p_174824_1_);
	public Object superdropItemWithOffset(Object item, int size, float p_145778_3_);
	public boolean superisEntityInvulnerable(Object damageSource);
	public void supercopyDataFromOld(Object entity);
	public float supergetExplosionResistance(Object explosion, Object world, Object blockPos, Object iBlockState);
	public boolean superfunc_174816_a(Object explosion, Object world, Object blockPos, Object iBlockState, float p_174816_5_);
	public int supergetMaxFallHeight();
	public void supersetCustomNameTag(String p_96094_1_);
	public String supergetCustomNameTag();
	public boolean superhasCustomName();
	public void supersetAlwaysRenderNameTag(boolean p_174805_1_);
	public boolean supergetAlwaysRenderNameTag();
	public Object supergetHorizontalFacing();
	public Object superfunc_174823_aP();
	public boolean superfunc_174827_a(Object entityPlayerMP);
	public Object supergetEntityBoundingBox();
	public void supersetEntityBoundingBox(Object axisAlignedBB);
	public boolean superisOutsideBorder();
	public void supersetOutsideBorder(boolean p_174821_1_);
	public Object supergetPositionVector();
	public Object supergetCommandSenderEntity();
	public void supersetCommandStat(Object type, int amount);
	public Object superfunc_174807_aT();
	public void superfunc_174817_o(Object entity);
	public Object superfunc_174819_aU();
	public void superfunc_174834_g(Object nBTTagCompound);
	public boolean superfunc_174825_a(Object entityPlayer, Object vec3);
	public boolean superfunc_180427_aV();
	public void superfunc_174815_a(Object entityLivingBase, Object entity);
	public void superheal(int par1);
	public void superdamageEntity(Object damageSource, int par2);
	public boolean superfunc_71066_bF();
	public void superupdateCloak();
	public void supersendChatToPlayer(String par1Str);
	public float supergetMaxHealthFloat();
	public boolean superfunc_96122_a(Object entityPlayer);
	public void superalertWolves(Object entityLiving, boolean par2);
	public void superdamageArmor(int par1);
	public float superfunc_82243_bO();
	public void superfunc_82162_bC();
	public boolean supercanCurrentToolHarvestBlock(int par1, int par2, int par3);
	public boolean superfunc_94062_bN();
	public boolean superfunc_94059_bO();
	public boolean supercanPickUpLoot();
	public Object supergetTranslator();
	public String supertranslateString(String par1Str, Object[] par2ArrayOfObj);
	public boolean superfunc_98034_c(Object entityPlayer);
	public boolean superfunc_96092_aw();
	public int superfunc_96121_ay();
	public Object supergetLookHelper();
	public Object supergetMoveHelper();
	public Object supergetJumpHelper();
	public Object supergetNavigator();
	public Object supergetEntitySenses();
	public Object supergetLastAttackingEntity();
	public void supersetLastAttackingEntity(Object entity);
	public Object supergetAttackTarget();
	public void supersetAttackTarget(Object entityLiving);
	public boolean supercanAttackClass(Class par1Class);
	public void supereatGrassBonus();
	public boolean superisWithinHomeDistanceCurrentPosition();
	public boolean superisWithinHomeDistance(int par1, int par2, int par3);
	public void supersetHomeArea(int par1, int par2, int par3, int par4);
	public Object supergetHomePosition();
	public float supergetMaximumHomeDistance();
	public void superdetachHome();
	public boolean superhasHome();
	public String supergetTexture();
	public int supergetTalkInterval();
	public void superplayLivingSound();
	public void superspawnExplosionParticle();
	public int supergetHealth();
	public void supersetEntityHealth(int par1);
	public int superapplyArmorCalculations(Object damageSource, int par2);
	public int superapplyPotionDamageCalculations(Object damageSource, int par2);
	public String supergetLivingSound();
	public void superknockBack(Object entity, int par2, double par3, double par5);
	public int supergetDropItemId();
	public void supersetMoveForward(float par1);
	public void superfunc_85033_bc();
	public boolean supercanDespawn();
	public void superdespawnEntity();
	public int supergetVerticalFaceSpeed();
	public void superfaceEntity(Object entity, float par2, float par3);
	public boolean supergetCanSpawnHere();
	public float supergetRenderSizeModifier();
	public int supergetMaxSpawnedInChunk();
	public void superonChangedPotionEffect(Object potionEffect);
	public float supergetSpeedModifier();
	public int superfunc_82143_as();
	public void superinitCreature();
	public boolean supercanBeSteered();
	public void superfunc_94058_c(String par1Str);
	public String superfunc_94057_bL();
	public boolean superfunc_94056_bM();
	public void superfunc_94061_f(boolean par1);
	public void superfunc_96120_a(int par1, float par2);
	public void supersetCanPickUpLoot(boolean par1);
	public boolean superfunc_104002_bU();
	public boolean superaddNotRiddenEntityID(Object nBTTagCompound);
	public boolean superaddEntityID(Object nBTTagCompound);
	public boolean superinteract(Object entityPlayer);
	public void superunmountEntity(Object entity);
	public boolean superfunc_85031_j(Object entity);
	public void superfunc_82149_j(Object entity);
	public float superfunc_82146_a(Object explosion, Object world, int par3, int par4, int par5, Object block);
	public boolean superfunc_96091_a(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7);
	public void superfunc_85029_a(Object crashReportCategory);
	public void supersetSize(float f, float f1);
	public Object supergetCreatureAttribute();
	public void setPositionCorrection(double par1, double par3, double par5);
	public void superonDeath(Object par1DamageSource);
	public void supersendMotionUpdates();
	public void publicSetSize(float f, float f1);
	public void publicResetHeight();
	public void superupdateRidden();
	public void superfunc_110318_g();
	public void superfunc_110322_i();
	public void superfunc_142020_c(String par1Str);
	public String superfunc_142021_k();
	public boolean superisRidingHorse();
	public float supergetHorseJumpPower();
	public void supersetupCustomSkin();
	public Object supergetTextureSkin();
	public Object supergetTextureCape();
	public Object supergetLocationSkin();
	public Object supergetLocationCape();
	public float supergetHealthFloat();

}
