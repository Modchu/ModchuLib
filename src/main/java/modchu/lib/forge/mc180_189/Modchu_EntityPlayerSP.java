package modchu.lib.forge.mc180_189;
	public Modchu_IEntityPlayerSPMaster master;
	public boolean initFlag;
		super((Minecraft)map.get("Object"), (World)map.get("Object1"), (NetHandlerPlayClient)map.get("Object2"), (StatFileWriter)map.get("Object3"));
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.lDebug("Modchu_EntityPlayerSP init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IEntityPlayerSPMaster ? (Modchu_IEntityPlayerSPMaster) instance : null;
		if (master != null); else Modchu_Debug.lDebug("Modchu_EntityPlayerSP init master == null !!");
	}
		if (master != null) master.init();
	}
	public void wakeUpPlayer(boolean flag, boolean flag1, boolean flag2) {
		super.wakeUpPlayer(flag, flag1, flag2);
		if (master != null) master.wakeUpPlayer(flag, flag1, flag2);
	}
		if (master != null) master.setPositionCorrection(par1, par3, par5);
	}
	public void onLivingUpdate() {
		if (master != null) master.onLivingUpdate();
		super.onLivingUpdate();
	}
	public void moveEntityWithHeading(float f, float f1) {
		if (master != null) master.moveEntityWithHeading(f, f1);
		super.moveEntityWithHeading(f, f1);
	}
	public String getHurtSound() {
		if (master != null) return (String) master.getHurtSound();
		return super.getHurtSound();
	}
	public EnumCreatureAttribute getCreatureAttribute() {
		if (master != null) return (EnumCreatureAttribute) master.getCreatureAttribute();
		return super.getCreatureAttribute();
	}
		return super.getCreatureAttribute();
	}
		if (master != null) master.copyPlayer(entityplayer);
	}
		//super.copyPlayer(entityplayer);
	}
		if (master != null) master.copyInventory(inventoryplayer);
	}
		if (master != null) master.resetHeight();
	}
		if (master != null) master.setSize(f, f1);
	}
		super.updateRidden();
	}
		return master != null ? master.attackEntityFrom(var1, par1DamageSource, par2) : false;
	}
		return master != null ? master.attackEntityFrom(par1DamageSource, par2) : false;
	}
		return super.attackEntityFrom(par1DamageSource, par2);
	}
	public void onDeath(DamageSource par1DamageSource) {
		if (master != null) master.onDeath(par1DamageSource);
	}
		super.onDeath(par1DamageSource);
	}
	public void setHealth(float f) {
		if (master != null) master.setHealth((int) f);
	}

	public float getEntityHealth() {
		return (Float) (master != null ? master.getHealth() : super.getHealth());
	}
		if (master != null) master.setHealth(f);
	}
	public Object supercopyPlayer(Object entityplayer) {
		return null;
	}
	public void superwakeUpPlayer(boolean flag, boolean flag1, boolean flag2) {
		super.wakeUpPlayer(flag, flag1, flag2);
	}
	public void supersetPositionCorrection(double par1, double par3, double par5) {
	}
	public void superonLivingUpdate() {
		super.onLivingUpdate();
	}
	public void supermoveEntityWithHeading(float f, float f1) {
		super.moveEntityWithHeading(f, f1);
	}
	public String supergetHurtSound() {
		return super.getHurtSound();
	}
	public boolean superisEntityInsideOpaqueBlock() {
		return super.isEntityInsideOpaqueBlock();
	}
	public Object supercopyInventory(Object inventoryplayer) {
		return null;
	}
	public boolean superattackEntityFrom(Object entity, Object damageSource, int i) {
		return super.attackEntityFrom((DamageSource) damageSource, i);
	}
	public float supergetMaxHealth() {
		return super.getMaxHealth();
	}
	public int supergetMaxHealthInt() {
		return (int) super.getMaxHealth();
	}
	public float supergetHealth() {
		return super.getHealth();
	}
	public int supergetHealthInt() {
		return (int) super.getHealth();
	}
	public void supersetHealth(float f) {
		super.setHealth(f);
	}
	public void supersetHealthInt(int i) {
		super.setHealth(i);
	}
	public void superonDeath(Object damageSource) {
		super.onDeath((DamageSource) damageSource);
	}
	public void supersendMotionUpdates() {
	}
	// 180~
	@Override
		return super.attackEntityFrom((DamageSource) damageSource, amount);
	}
	public void heal(float healAmount) {
		if (master != null) master.heal(healAmount);
		else super.heal(healAmount);
	}
		super.heal(healAmount);
	}
	public void onUpdateWalkingPlayer() {
		if (master != null) master.onUpdateWalkingPlayer();
		else super.onUpdateWalkingPlayer();
	}
		super.onUpdateWalkingPlayer();
	}
	public EntityItem dropOneItem(boolean p_71040_1_) {
		return (EntityItem) (master != null ? master.dropItem(p_71040_1_) : super.dropOneItem(p_71040_1_));
	}
		return super.dropOneItem(p_71040_1_);
	}
	public void joinEntityItemWithWorld(EntityItem entityItem) {
		if (master != null) master.dropItemAndGetStack(entityItem);
		else super.joinEntityItemWithWorld(entityItem);
	}
		super.joinEntityItemWithWorld((EntityItem) entityItem);
	}
	public void sendChatMessage(String p_71165_1_) {
		if (master != null) master.sendChatMessage(p_71165_1_);
		else super.sendChatMessage(p_71165_1_);
	}
		super.sendChatMessage(p_71165_1_);
	}
	public void swingItem() {
		if (master != null) master.swingArm();
		else super.swingItem();
	}
		super.swingItem();
	}
	public void respawnPlayer() {
		if (master != null) master.respawnPlayer();
		else super.respawnPlayer();
	}
		super.respawnPlayer();
	}
	protected void damageEntity(DamageSource damageSource, float damageAmount) {
		if (master != null) master.damageEntity(damageSource, damageAmount);
		else super.damageEntity(damageSource, damageAmount);
	}
		super.damageEntity((DamageSource) damageSource, damageAmount);
	}
	public void closeScreen() {
		if (master != null) master.closeScreen();
		else super.closeScreen();
	}
		super.closeScreen();
	}
	public void setPlayerSPHealth(float p_71150_1_) {
		if (master != null) master.setPlayerSPHealth(p_71150_1_);
		else super.setPlayerSPHealth(p_71150_1_);
	}
		super.setPlayerSPHealth(p_71150_1_);
	}
	public void addStat(StatBase statBase, int amount) {
		if (master != null) master.addStat(statBase, amount);
		else super.addStat(statBase, amount);
	}
		super.addStat((StatBase) statBase, amount);
	}
	public void sendPlayerAbilities() {
		if (master != null) master.sendPlayerAbilities();
		else super.sendPlayerAbilities();
	}
		super.sendPlayerAbilities();
	}
	public boolean isUser() {
		return master != null ? master.isUser() : super.isUser();
	}
		return super.isUser();
	}
	protected void sendHorseJump() {
		if (master != null) master.sendHorseJump();
		else super.sendHorseJump();
	}
		super.sendHorseJump();
	}
	public void sendHorseInventory() {
		if (master != null) master.sendHorseInventory();
		else super.sendHorseInventory();
	}
		super.sendHorseInventory();
	}
	public void setClientBrand(String brand) {
		if (master != null) master.setClientBrand(brand);
		else super.setClientBrand(brand);
	}
		super.setClientBrand(brand);
	}
	public String getClientBrand() {
		return master != null ? master.getClientBrand() : super.getClientBrand();
	}
		return super.getClientBrand();
	}
	public StatFileWriter getStatFileWriter() {
		return (StatFileWriter) (master != null ? master.getStatFileWriter() : super.getStatFileWriter());
	}
		return super.getStatFileWriter();
	}
	public void addChatComponentMessage(IChatComponent iChatComponent) {
		if (master != null) master.addChatComponentMessage(iChatComponent);
		else super.addChatComponentMessage(iChatComponent);
	}
		super.addChatComponentMessage((IChatComponent) iChatComponent);
	}
	public void setXPStats(float currentXP, int maxXP, int level) {
		if (master != null) master.setXPStats(currentXP, maxXP, level);
		else super.setXPStats(currentXP, maxXP, level);
	}
		super.setXPStats(currentXP, maxXP, level);
	}
	public boolean isServerWorld() {
		return master != null ? master.isServerWorld() : super.isServerWorld();
	}
		return super.isServerWorld();
	}
	public boolean isRidingHorse() {
		return master != null ? master.isRidingHorse() : super.isRidingHorse();
	}
		return super.isRidingHorse();
	}
	public float getHorseJumpPower() {
		return master != null ? master.getHorseJumpPower() : super.getHorseJumpPower();
	}
		return super.getHorseJumpPower();
	}
	public void openEditSign(TileEntitySign tileEntitySign) {
		if (master != null) master.openEditSign(tileEntitySign);
		else super.openEditSign(tileEntitySign);
	}
		super.openEditSign((TileEntitySign) tileEntitySign);
	}
	public void openEditCommandBlock(CommandBlockLogic commandBlockLogic) {
		if (master != null) master.displayGuiEditCommandCart(commandBlockLogic);
		else super.openEditCommandBlock(commandBlockLogic);
	}
		super.openEditCommandBlock((CommandBlockLogic) commandBlockLogic);
	}
	public void displayGUIBook(ItemStack itemStack) {
		if (master != null) master.openBook(itemStack);
		else super.displayGUIBook(itemStack);
	}
		super.displayGUIBook((ItemStack) itemStack);
	}
	public void displayGUIChest(IInventory iInventory) {
		if (master != null) master.displayGUIChest(iInventory);
		else super.displayGUIChest(iInventory);
	}
		super.displayGUIChest((IInventory) iInventory);
	}
	public void displayGUIHorse(EntityHorse entityHorse, IInventory iInventory) {
		if (master != null) master.openGuiHorseInventory(entityHorse, iInventory);
		else super.displayGUIHorse(entityHorse, iInventory);
	}
		super.displayGUIHorse((EntityHorse) entityHorse, (IInventory) iInventory);
	}
	public void displayGui(IInteractionObject iInteractionObject) {
		if (master != null) master.displayGui(iInteractionObject);
		else super.displayGui(iInteractionObject);
	}
		super.displayGui((IInteractionObject) iInteractionObject);
	}
	public void displayVillagerTradeGui(IMerchant iMerchant) {
		if (master != null) master.displayVillagerTradeGui(iMerchant);
		else super.displayVillagerTradeGui(iMerchant);
	}
		super.displayVillagerTradeGui((IMerchant) iMerchant);
	}
	public void onCriticalHit(Entity entity) {
		if (master != null) master.onCriticalHit(entity);
		else super.onCriticalHit(entity);
	}
		super.onCriticalHit((Entity) entity);
	}
	public void onEnchantmentCritical(Entity entity) {
		if (master != null) master.onEnchantmentCritical(entity);
		else super.onEnchantmentCritical(entity);
	}
		super.onEnchantmentCritical((Entity) entity);
	}
	public void updateEntityActionState() {
		if (master != null) master.updateEntityActionState();
		else super.updateEntityActionState();
	}
		super.updateEntityActionState();
	}
	protected boolean isCurrentViewEntity() {
		return master != null ? master.isCurrentViewEntity() : super.isCurrentViewEntity();
	}
		return super.isCurrentViewEntity();
	}
	public boolean isSpectator() {
		return master != null ? master.isSpectator() : super.isSpectator();
	}
		return super.isSpectator();
	}
	public boolean hasPlayerInfo() {
		return master != null ? master.hasPlayerInfo() : super.hasPlayerInfo();
	}
		return super.hasPlayerInfo();
	}
	protected NetworkPlayerInfo getPlayerInfo() {
		return (NetworkPlayerInfo) (master != null ? master.getPlayerInfo() : super.getPlayerInfo());
	}
		return super.getPlayerInfo();
	}
	public boolean hasSkin() {
		return master != null ? master.hasSkin() : super.hasSkin();
	}
		return super.hasSkin();
	}
	public ResourceLocation getLocationSkin() {
		return (ResourceLocation) (master != null ? master.getLocationSkin() : super.getLocationSkin());
	}
		return super.getLocationSkin();
	}
	public ResourceLocation getLocationCape() {
		return (ResourceLocation) (master != null ? master.getLocationCape() : super.getLocationCape());
	}
		return super.getLocationCape();
	}
	public String getSkinType() {
		return master != null ? master.getSkinType() : super.getSkinType();
	}
		return super.getSkinType();
	}
	public float getFovModifier() {
		return master != null ? master.getFovModifier() : super.getFovModifier();
	}
		return super.getFovModifier();
	}
	protected void applyEntityAttributes() {
		if (master != null) master.applyEntityAttributes();
		else super.applyEntityAttributes();
	}
		super.applyEntityAttributes();
	}
	public ItemStack getItemInUse() {
		return (ItemStack) (master != null ? master.getItemInUse() : super.getItemInUse());
	}
		return super.getItemInUse();
	}
	public int getItemInUseCount() {
		return master != null ? master.getItemInUseCount() : super.getItemInUseCount();
	}
		return super.getItemInUseCount();
	}
	public boolean isUsingItem() {
		return master != null ? master.isHandActive() : super.isUsingItem();
	}
		return super.isUsingItem();
	}
	public int getItemInUseDuration() {
		return master != null ? master.getItemInUseDuration() : super.getItemInUseDuration();
	}
		return super.getItemInUseDuration();
	}
	public void stopUsingItem() {
		if (master != null) master.stopUsingItem();
		else super.stopUsingItem();
	}
		super.stopUsingItem();
	}
	public void clearItemInUse() {
		if (master != null) master.clearItemInUse();
		else super.clearItemInUse();
	}
		super.clearItemInUse();
	}
	public boolean isBlocking() {
		return master != null ? master.isBlocking() : super.isBlocking();
	}
		return super.isBlocking();
	}
	protected void updateItemUse(ItemStack itemStack, int p_71010_2_) {
		if (master != null) master.updateItemUse(itemStack, p_71010_2_);
		else super.updateItemUse(itemStack, p_71010_2_);
	}
		super.updateItemUse((ItemStack) itemStack, p_71010_2_);
	}
	protected void onItemUseFinish() {
		if (master != null) master.onItemUseFinish();
		else super.onItemUseFinish();
	}
		super.onItemUseFinish();
	}
	protected boolean isMovementBlocked() {
		return master != null ? master.isMovementBlocked() : super.isMovementBlocked();
	}
		return super.isMovementBlocked();
	}
	public int getScore() {
		return master != null ? master.getScore() : super.getScore();
	}
		return super.getScore();
	}
	public void setScore(int p_85040_1_) {
		if (master != null) master.setScore(p_85040_1_);
		else super.setScore(p_85040_1_);
	}
		super.setScore(p_85040_1_);
	}
	public void addScore(int p_85039_1_) {
		if (master != null) master.addScore(p_85039_1_);
		else super.addScore(p_85039_1_);
	}
		super.addScore(p_85039_1_);
	}
	protected String getDeathSound() {
		return (String) (master != null ? master.getDeathSound() : super.getDeathSound());
	}
		return super.getDeathSound();
	}
	public EntityItem dropPlayerItemWithRandomChoice(ItemStack itemStack, boolean unused) {
		return (EntityItem) (master != null ? master.dropItem(itemStack, unused) : super.dropPlayerItemWithRandomChoice(itemStack, unused));
	}
		return super.dropPlayerItemWithRandomChoice((ItemStack) itemStack, unused);
	}
	public EntityItem dropItem(ItemStack itemStack, boolean dropAround, boolean traceItem) {
		return (EntityItem) (master != null ? master.dropItem(itemStack, dropAround, traceItem) : super.dropItem(itemStack, dropAround, traceItem));
	}
		return super.dropItem((ItemStack) itemStack, dropAround, traceItem);
	}
	public float getToolDigEfficiency(Block block) {
		return master != null ? master.getDigSpeed(block) : super.getToolDigEfficiency(block);
	}
		return super.getToolDigEfficiency((Block) block);
	}
	public float getBreakSpeed(IBlockState iBlockState, BlockPos blockPos) {
		return master != null ? master.getDigSpeed(iBlockState, blockPos) : super.getBreakSpeed(iBlockState, blockPos);
	}
		return super.getBreakSpeed((IBlockState) iBlockState, (BlockPos) blockPos);
	}
	public boolean canHarvestBlock(Block block) {
		return master != null ? master.canHarvestBlock(block) : super.canHarvestBlock(block);
	}
		return super.canHarvestBlock((Block) block);
	}
	public boolean canAttackPlayer(EntityPlayer entityPlayer) {
		return master != null ? master.canAttackPlayer(entityPlayer) : super.canAttackPlayer(entityPlayer);
	}
		return super.canAttackPlayer((EntityPlayer) entityPlayer);
	}
	protected void damageArmor(float p_70675_1_) {
		if (master != null) master.damageArmor(p_70675_1_);
		else super.damageArmor(p_70675_1_);
	}
		super.damageArmor(p_70675_1_);
	}
	public int getTotalArmorValue() {
		return master != null ? master.getTotalArmorValue() : super.getTotalArmorValue();
	}
		return super.getTotalArmorValue();
	}
	public float getArmorVisibility() {
		return master != null ? master.getArmorVisibility() : super.getArmorVisibility();
	}
		return super.getArmorVisibility();
	}
	public boolean interactWith(Entity entity) {
		return master != null ? master.interactWith(entity) : super.interactWith(entity);
	}
		return super.interactWith((Entity) entity);
	}
	public ItemStack getCurrentEquippedItem() {
		return (ItemStack) (master != null ? master.getHeldItemMainhand() : super.getCurrentEquippedItem());
	}
		return super.getCurrentEquippedItem();
	}
	public void destroyCurrentEquippedItem() {
		if (master != null) master.destroyCurrentEquippedItem();
		else super.destroyCurrentEquippedItem();
	}
		super.destroyCurrentEquippedItem();
	}
	public void attackTargetEntityWithCurrentItem(Entity entity) {
		if (master != null) master.attackTargetEntityWithCurrentItem(entity);
		else super.attackTargetEntityWithCurrentItem(entity);
	}
		super.attackTargetEntityWithCurrentItem((Entity) entity);
	}
	public GameProfile getGameProfile() {
		return (GameProfile) (master != null ? master.getGameProfile() : super.getGameProfile());
	}
		return super.getGameProfile();
	}
	public EnumStatus trySleep(BlockPos blockPos) {
		return (EnumStatus) (master != null ? master.trySleep(blockPos) : super.trySleep(blockPos));
	}
		return super.trySleep((BlockPos) blockPos);
	}
	public float getBedOrientationInDegrees() {
		return master != null ? master.getBedOrientationInDegrees() : super.getBedOrientationInDegrees();
	}
		return super.getBedOrientationInDegrees();
	}
	public boolean isPlayerSleeping() {
		return master != null ? master.isPlayerSleeping() : super.isPlayerSleeping();
	}
		return super.isPlayerSleeping();
	}
	public boolean isPlayerFullyAsleep() {
		return master != null ? master.isPlayerFullyAsleep() : super.isPlayerFullyAsleep();
	}
		return super.isPlayerFullyAsleep();
	}
	public int getSleepTimer() {
		return master != null ? master.getSleepTimer() : super.getSleepTimer();
	}
		return super.getSleepTimer();
	}
	public BlockPos getBedLocation() {
		return (BlockPos) (master != null ? master.getBedLocation() : super.getBedLocation());
	}
		return super.getBedLocation();
	}
	public boolean isSpawnForced() {
		return master != null ? master.isSpawnForced() : super.isSpawnForced();
	}
		return super.isSpawnForced();
	}
	public void setSpawnPoint(BlockPos blockPos, boolean forced) {
		if (master != null) master.setSpawnPoint(blockPos, forced);
		else super.setSpawnPoint(blockPos, forced);
	}
		super.setSpawnPoint((BlockPos) blockPos, forced);
	}
	public void triggerAchievement(StatBase statBase) {
		if (master != null) master.addStat(statBase);
		else super.triggerAchievement(statBase);
	}
		super.triggerAchievement((StatBase) statBase);
	}
	public void func_175145_a(StatBase statBase) {
		if (master != null) master.takeStat(statBase);
		else super.func_175145_a(statBase);
	}
		super.func_175145_a((StatBase) statBase);
	}
	public void jump() {
		if (master != null) master.jump();
		else super.jump();
	}
		super.jump();
	}
	public float getAIMoveSpeed() {
		return master != null ? master.getAIMoveSpeed() : super.getAIMoveSpeed();
	}
		return super.getAIMoveSpeed();
	}
	public void addMovementStat(double p_71000_1_, double p_71000_3_, double p_71000_5_) {
		if (master != null) master.addMovementStat(p_71000_1_, p_71000_3_, p_71000_5_);
		else super.addMovementStat(p_71000_1_, p_71000_3_, p_71000_5_);
	}
		super.addMovementStat(p_71000_1_, p_71000_3_, p_71000_5_);
	}
	protected String getFallSoundString(int damageValue) {
		return (String) (master != null ? master.getFallSound(damageValue) : super.getFallSoundString(damageValue));
	}
		return super.getFallSoundString(damageValue);
	}
	public ItemStack getCurrentArmor(int slotIn) {
		return (ItemStack) (master != null ? master.getCurrentArmor(slotIn) : super.getCurrentArmor(slotIn));
	}
		return super.getCurrentArmor(slotIn);
	}
	public void addExperience(int amount) {
		if (master != null) master.addExperience(amount);
		else super.addExperience(amount);
	}
		super.addExperience(amount);
	}
	public int getXPSeed() {
		return master != null ? master.getXPSeed() : super.getXPSeed();
	}
		return super.getXPSeed();
	}
	public void removeExperienceLevel(int levels) {
		if (master != null) master.removeExperienceLevel(levels);
		else super.removeExperienceLevel(levels);
	}
		super.removeExperienceLevel(levels);
	}
	public void addExperienceLevel(int levels) {
		if (master != null) master.addExperienceLevel(levels);
		else super.addExperienceLevel(levels);
	}
		super.addExperienceLevel(levels);
	}
	public int xpBarCap() {
		return master != null ? master.xpBarCap() : super.xpBarCap();
	}
		return super.xpBarCap();
	}
	public void addExhaustion(float p_71020_1_) {
		if (master != null) master.addExhaustion(p_71020_1_);
		else super.addExhaustion(p_71020_1_);
	}
		super.addExhaustion(p_71020_1_);
	}
	public FoodStats getFoodStats() {
		return (FoodStats) (master != null ? master.getFoodStats() : super.getFoodStats());
	}
		return super.getFoodStats();
	}
	public boolean canEat(boolean ignoreHunger) {
		return master != null ? master.canEat(ignoreHunger) : super.canEat(ignoreHunger);
	}
		return super.canEat(ignoreHunger);
	}
	public boolean shouldHeal() {
		return master != null ? master.shouldHeal() : super.shouldHeal();
	}
		return super.shouldHeal();
	}
	public void setItemInUse(ItemStack itemStack, int duration) {
		if (master != null) master.setItemInUse(itemStack, duration);
		else super.setItemInUse(itemStack, duration);
	}
		super.setItemInUse((ItemStack) itemStack, duration);
	}
	public boolean isAllowEdit() {
		return master != null ? master.isAllowEdit() : super.isAllowEdit();
	}
		return super.isAllowEdit();
	}
	public boolean canPlayerEdit(BlockPos blockPos, EnumFacing enumFacing, ItemStack itemStack) {
		return master != null ? master.canPlayerEdit(blockPos, enumFacing, itemStack) : super.canPlayerEdit(blockPos, enumFacing, itemStack);
	}
		return super.canPlayerEdit((BlockPos) blockPos, (EnumFacing) enumFacing, (ItemStack) itemStack);
	}
	protected int getExperiencePoints(EntityPlayer entityPlayer) {
		return master != null ? master.getExperiencePoints(entityPlayer) : super.getExperiencePoints(entityPlayer);
	}
		return super.getExperiencePoints((EntityPlayer) entityPlayer);
	}
	protected boolean isPlayer() {
		return master != null ? master.isPlayer() : super.isPlayer();
	}
		return super.isPlayer();
	}
	public void clonePlayer(EntityPlayer entityPlayer, boolean respawnFromEnd) {
		if (master != null) master.clonePlayer(entityPlayer, respawnFromEnd);
		else super.clonePlayer(entityPlayer, respawnFromEnd);
	}
		super.clonePlayer((EntityPlayer) entityPlayer, respawnFromEnd);
	}
	public void setGameType(GameType gameType) {
		if (master != null) master.setGameType(gameType);
		else super.setGameType(gameType);
	}
		super.setGameType((GameType) gameType);
	}
	public InventoryEnderChest getInventoryEnderChest() {
		return (InventoryEnderChest) (master != null ? master.getInventoryEnderChest() : super.getInventoryEnderChest());
	}
		return super.getInventoryEnderChest();
	}
	public ItemStack getEquipmentInSlot(int slotIn) {
		return (ItemStack) (master != null ? master.getItemStackFromSlot(slotIn) : super.getEquipmentInSlot(slotIn));
	}
		return super.getEquipmentInSlot(slotIn);
	}
	public ItemStack getHeldItem() {
		return (ItemStack) (master != null ? master.getHeldItem() : super.getHeldItem());
	}
		return super.getHeldItem();
	}
		super.setCurrentItemOrArmor(slotIn, (ItemStack) itemStack);
	}
	public Scoreboard getWorldScoreboard() {
		return (Scoreboard) (master != null ? master.getWorldScoreboard() : super.getWorldScoreboard());
	}
		return super.getWorldScoreboard();
	}
	public Team getTeam() {
		return (Team) (master != null ? master.getTeam() : super.getTeam());
	}
	public void setAbsorptionAmount(float amount) {
		if (master != null) master.setAbsorptionAmount(amount);
		else super.setAbsorptionAmount(amount);
	}
		super.setAbsorptionAmount(amount);
	}
	public float getAbsorptionAmount() {
		return master != null ? master.getAbsorptionAmount() : super.getAbsorptionAmount();
	}
		return super.getAbsorptionAmount();
	}
	public boolean canOpen(LockCode lockCode) {
		return master != null ? master.canOpen(lockCode) : super.canOpen(lockCode);
	}
		return super.canOpen((LockCode) lockCode);
	}
	public boolean hasReducedDebug() {
		return master != null ? master.hasReducedDebug() : super.hasReducedDebug();
	}
		return super.hasReducedDebug();
	}
	public void setReducedDebug(boolean reducedDebug) {
		if (master != null) master.setReducedDebug(reducedDebug);
		else super.setReducedDebug(reducedDebug);
	}
		super.setReducedDebug(reducedDebug);
	}
	public void openGui(Object mod, int modGuiId, World world, int x, int y, int z) {
		if (master != null) master.openGui(mod, modGuiId, world, x, y, z);
		else super.openGui(mod, modGuiId, world, x, y, z);
	}
		super.openGui(mod, modGuiId, (World) world, x, y, z);
	}
	public BlockPos getBedLocation(int dimension) {
		return (BlockPos) (master != null ? master.getBedLocation(dimension) : super.getBedLocation(dimension));
	}
		return super.getBedLocation(dimension);
	}
	public boolean isSpawnForced(int dimension) {
		return master != null ? master.isSpawnForced(dimension) : super.isSpawnForced(dimension);
	}
		return super.isSpawnForced(dimension);
	}
	public void setSpawnChunk(BlockPos blockPos, boolean forced, int dimension) {
		if (master != null) master.setSpawnChunk(blockPos, forced, dimension);
		else super.setSpawnChunk(blockPos, forced, dimension);
	}
		super.setSpawnChunk((BlockPos) blockPos, forced, dimension);
	}
	public float getDefaultEyeHeight() {
		return master != null ? master.getDefaultEyeHeight() : super.getDefaultEyeHeight();
	}
		return super.getDefaultEyeHeight();
	}
	public String getDisplayNameString() {
		return master != null ? master.getDisplayNameString() : super.getDisplayNameString();
	}
		return super.getDisplayNameString();
	}
	public void refreshDisplayName() {
		if (master != null) master.refreshDisplayName();
		else super.refreshDisplayName();
	}
		super.refreshDisplayName();
	}
	public boolean canBreatheUnderwater() {
		return master != null ? master.canBreatheUnderwater() : super.canBreatheUnderwater();
	}
		return super.canBreatheUnderwater();
	}
	public boolean isChild() {
		return master != null ? master.isChild() : super.isChild();
	}
		return super.isChild();
	}
	protected void onDeathUpdate() {
		if (master != null) master.onDeathUpdate();
		else super.onDeathUpdate();
	}
		super.onDeathUpdate();
	}
	protected int decreaseAirSupply(int p_70682_1_) {
		return master != null ? master.decreaseAirSupply(p_70682_1_) : super.decreaseAirSupply(p_70682_1_);
	}
		return super.decreaseAirSupply(p_70682_1_);
	}
	public Random getRNG() {
		return master != null ? master.getRNG() : super.getRNG();
	}
		return super.getRNG();
	}
	public EntityLivingBase getAITarget() {
		return (EntityLivingBase) (master != null ? master.getAITarget() : super.getAITarget());
	}
		return super.getAITarget();
	}
	public int getRevengeTimer() {
		return master != null ? master.getRevengeTimer() : super.getRevengeTimer();
	}
		return super.getRevengeTimer();
	}
	public void setRevengeTarget(EntityLivingBase entityLivingBase) {
		if (master != null) master.setRevengeTarget(entityLivingBase);
		else super.setRevengeTarget(entityLivingBase);
	}
		super.setRevengeTarget((EntityLivingBase) entityLivingBase);
	}
	public EntityLivingBase getLastAttacker() {
		return (EntityLivingBase) (master != null ? master.getLastAttacker() : super.getLastAttacker());
	}
		return super.getLastAttacker();
	}
	public int getLastAttackerTime() {
		return master != null ? master.getLastAttackerTime() : super.getLastAttackerTime();
	}
		return super.getLastAttackerTime();
	}
	public void setLastAttacker(Entity entity) {
		if (master != null) master.setLastAttacker(entity);
		else super.setLastAttacker(entity);
	}
		super.setLastAttacker((Entity) entity);
	}
	public int getAge() {
		return master != null ? master.getAge() : super.getAge();
	}
		return super.getAge();
	}
	protected void updatePotionEffects() {
		if (master != null) master.updatePotionEffects();
		else super.updatePotionEffects();
	}
		super.updatePotionEffects();
	}
	public void clearActivePotions() {
		if (master != null) master.clearActivePotions();
		else super.clearActivePotions();
	}
		super.clearActivePotions();
	}
	public Collection getActivePotionEffects() {
		return (Collection) (master != null ? master.getActivePotionEffects() : super.getActivePotionEffects());
	}
		return super.getActivePotionEffects();
	}
	public boolean isPotionActive(int p_82165_1_) {
		return master != null ? master.isPotionActive(p_82165_1_) : super.isPotionActive(p_82165_1_);
	}
		return super.isPotionActive(p_82165_1_);
	}
	public boolean isPotionActive(Potion potion) {
		return master != null ? master.isPotionActive(potion) : super.isPotionActive(potion);
	}
		return super.isPotionActive((Potion) potion);
	}
	public PotionEffect getActivePotionEffect(Potion potion) {
		return (PotionEffect) (master != null ? master.getActivePotionEffect(potion) : super.getActivePotionEffect(potion));
	}
		return super.getActivePotionEffect((Potion) potion);
	}
	public void addPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.addPotionEffect(potionEffect);
		else super.addPotionEffect(potionEffect);
	}
		super.addPotionEffect((PotionEffect) potionEffect);
	}
	public boolean isPotionApplicable(PotionEffect potionEffect) {
		return master != null ? master.isPotionApplicable(potionEffect) : super.isPotionApplicable(potionEffect);
	}
		return super.isPotionApplicable((PotionEffect) potionEffect);
	}
	public boolean isEntityUndead() {
		return master != null ? master.isEntityUndead() : super.isEntityUndead();
	}
		return super.isEntityUndead();
	}
	public void removePotionEffectClient(int p_70618_1_) {
		if (master != null) master.removePotionEffectClient(p_70618_1_);
		else super.removePotionEffectClient(p_70618_1_);
	}
		super.removePotionEffectClient(p_70618_1_);
	}
	public void removePotionEffect(int p_82170_1_) {
		if (master != null) master.removePotionEffect(p_82170_1_);
		else super.removePotionEffect(p_82170_1_);
	}
		super.removePotionEffect(p_82170_1_);
	}
	protected void onNewPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.onNewPotionEffect(potionEffect);
		else super.onNewPotionEffect(potionEffect);
	}
		super.onNewPotionEffect((PotionEffect) potionEffect);
	}
	protected void onChangedPotionEffect(PotionEffect potionEffect, boolean p_70695_2_) {
		if (master != null) master.onChangedPotionEffect(potionEffect, p_70695_2_);
		else super.onChangedPotionEffect(potionEffect, p_70695_2_);
	}
		super.onChangedPotionEffect((PotionEffect) potionEffect, p_70695_2_);
	}
	protected void onFinishedPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.onFinishedPotionEffect(potionEffect);
		else super.onFinishedPotionEffect(potionEffect);
	}
		super.onFinishedPotionEffect((PotionEffect) potionEffect);
	}
	public void renderBrokenItemStack(ItemStack itemStack) {
		if (master != null) master.renderBrokenItemStack(itemStack);
		else super.renderBrokenItemStack(itemStack);
	}
		super.renderBrokenItemStack((ItemStack) itemStack);
	}
	protected void dropEquipment(boolean p_82160_1_, int p_82160_2_) {
		if (master != null) master.dropEquipment(p_82160_1_, p_82160_2_);
		else super.dropEquipment(p_82160_1_, p_82160_2_);
	}
		super.dropEquipment(p_82160_1_, p_82160_2_);
	}
	public void knockBack(Entity entity, float p_70653_2_, double p_70653_3_, double p_70653_5_) {
		if (master != null) master.knockBack(entity, p_70653_2_, p_70653_3_, p_70653_5_);
		else super.knockBack(entity, p_70653_2_, p_70653_3_, p_70653_5_);
	}
		super.knockBack((Entity) entity, p_70653_2_, p_70653_3_, p_70653_5_);
	}
	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		if (master != null) master.dropFewItems(p_70628_1_, p_70628_2_);
		else super.dropFewItems(p_70628_1_, p_70628_2_);
	}
		super.dropFewItems(p_70628_1_, p_70628_2_);
	}
	public boolean isOnLadder() {
		return master != null ? master.isOnLadder() : super.isOnLadder();
	}
		return super.isOnLadder();
	}
	protected float applyArmorCalculations(DamageSource damageSource, float p_70655_2_) {
		return (Float) (master != null ? master.applyArmorCalculations(damageSource, p_70655_2_) : super.applyArmorCalculations(damageSource, p_70655_2_));
	}
		return super.applyArmorCalculations((DamageSource) damageSource, p_70655_2_);
	}
	protected float applyPotionDamageCalculations(DamageSource damageSource, float p_70672_2_) {
		return (Float) (master != null ? master.applyPotionDamageCalculations(damageSource, p_70672_2_) : super.applyPotionDamageCalculations(damageSource, p_70672_2_));
	}
		return super.applyPotionDamageCalculations((DamageSource) damageSource, p_70672_2_);
	}
	public CombatTracker getCombatTracker() {
		return (CombatTracker) (master != null ? master.getCombatTracker() : super.getCombatTracker());
	}
		return super.getCombatTracker();
	}
	public EntityLivingBase func_94060_bK() {
		return (EntityLivingBase) (master != null ? master.getAttackingEntity() : super.func_94060_bK());
	}
		return super.func_94060_bK();
	}
	protected void updateArmSwingProgress() {
		if (master != null) master.updateArmSwingProgress();
		else super.updateArmSwingProgress();
	}
		super.updateArmSwingProgress();
	}
	public IAttributeInstance getEntityAttribute(IAttribute iAttribute) {
		return (IAttributeInstance) (master != null ? master.getEntityAttribute(iAttribute) : super.getEntityAttribute(iAttribute));
	}
		return super.getEntityAttribute((IAttribute) iAttribute);
	}
	public BaseAttributeMap getAttributeMap() {
		return (BaseAttributeMap) (master != null ? master.getAttributeMap() : super.getAttributeMap());
	}
		return super.getAttributeMap();
	}
	protected float getSoundVolume() {
		return master != null ? master.getSoundVolume() : super.getSoundVolume();
	}
		return super.getSoundVolume();
	}
	protected float getSoundPitch() {
		return master != null ? master.getSoundPitch() : super.getSoundPitch();
	}
		return super.getSoundPitch();
	}
	public void dismountEntity(Entity entity) {
		if (master != null) master.dismountEntity(entity);
		else super.dismountEntity(entity);
	}
		super.dismountEntity((Entity) entity);
	}
	protected void updateAITick() {
		if (master != null) master.handleJumpWater();
		else super.updateAITick();
	}
		super.updateAITick();
	}
	public void setAIMoveSpeed(float p_70659_1_) {
		if (master != null) master.setAIMoveSpeed(p_70659_1_);
		else super.setAIMoveSpeed(p_70659_1_);
	}
		super.setAIMoveSpeed(p_70659_1_);
	}
	public boolean attackEntityAsMob(Entity entity) {
		return master != null ? master.attackEntityAsMob(entity) : super.attackEntityAsMob(entity);
	}
		return super.attackEntityAsMob((Entity) entity);
	}
	protected float func_110146_f(float p_110146_1_, float p_110146_2_) {
		return master != null ? master.updateDistance(p_110146_1_, p_110146_2_) : super.func_110146_f(p_110146_1_, p_110146_2_);
	}
		return super.func_110146_f(p_110146_1_, p_110146_2_);
	}
	protected void collideWithNearbyEntities() {
		if (master != null) master.collideWithNearbyEntities();
		else super.collideWithNearbyEntities();
	}
		super.collideWithNearbyEntities();
	}
	protected void collideWithEntity(Entity entity) {
		if (master != null) master.collideWithEntity(entity);
		else super.collideWithEntity(entity);
	}
		super.collideWithEntity((Entity) entity);
	}
	public void setJumping(boolean p_70637_1_) {
		if (master != null) master.setJumping(p_70637_1_);
		else super.setJumping(p_70637_1_);
	}
		super.setJumping(p_70637_1_);
	}
	public void onItemPickup(Entity entity, int p_71001_2_) {
		if (master != null) master.onItemPickup(entity, p_71001_2_);
		else super.onItemPickup(entity, p_71001_2_);
	}
		super.onItemPickup((Entity) entity, p_71001_2_);
	}
	public boolean canEntityBeSeen(Entity entity) {
		return master != null ? master.canEntityBeSeen(entity) : super.canEntityBeSeen(entity);
	}
		return super.canEntityBeSeen((Entity) entity);
	}
	public float getSwingProgress(float p_70678_1_) {
		return master != null ? master.getSwingProgress(p_70678_1_) : super.getSwingProgress(p_70678_1_);
	}
		return super.getSwingProgress(p_70678_1_);
	}
	public boolean isOnSameTeam(EntityLivingBase entityLivingBase) {
		return master != null ? master.isOnSameTeam(entityLivingBase) : super.isOnSameTeam(entityLivingBase);
	}
	public boolean isOnTeam(Team team) {
		return master != null ? master.isOnTeam(team) : super.isOnTeam(team);
	}
		return super.isOnTeam((Team) team);
	}
	public void curePotionEffects(ItemStack itemStack) {
		if (master != null) master.curePotionEffects(itemStack);
		else super.curePotionEffects(itemStack);
	}
		super.curePotionEffects((ItemStack) itemStack);
	}
	public boolean shouldRiderFaceForward(EntityPlayer entityPlayer) {
		return master != null ? master.shouldRiderFaceForward(entityPlayer) : super.shouldRiderFaceForward(entityPlayer);
	}
		return super.shouldRiderFaceForward((EntityPlayer) entityPlayer);
	}
	@Override
	public void superFunc_92015_f() {
	}
	public void superIncrementStat(Object statBase, int par2) {
	}
	public void superFunc_110322_i() {
	}
	public void superFunc_142020_c(String par1Str) {
	}
	public float superGetFOVMultiplier() {
		return 0.0F;
	}
	public void superDisplayGUIEditSign(Object tileEntity) {
	}
	public void superDisplayGUIHopper(Object tileEntityHopper) {
	}
	public void superDisplayGUIHopperMinecart(Object entityMinecartHopper) {
	}
	public void superDisplayGUIWorkbench(int par1, int par2, int par3) {
	}
	public void superDisplayGUIEnchantment(int par1, int par2, int par3, String par4Str) {
	}
	public void superDisplayGUIAnvil(int par1, int par2, int par3) {
	}
	public void superDisplayGUIFurnace(Object tileEntityFurnace) {
	}
	public void superDisplayGUIBrewingStand(Object tileEntityBrewingStand) {
	}
	public void superDisplayGUIBeacon(Object tileEntityBeacon) {
	}
	public void superDisplayGUIDispenser(Object tileEntityDispenser) {
	}
	public void superDisplayGUIMerchant(Object iMerchant, String par2Str) {
	}
	public void superAddChatMessage(String par1Str) {
	}
	public void superSendChatToPlayer(Object chatMessageComponent) {
	}
	public Object superGetPlayerCoordinates() {
		return null;
	}
	public boolean superIsClientWorld() {
		return false;
	}
	public void superSetupCustomSkin() {
	}
	public Object superGetTextureSkin() {
		return null;
	}
	public Object superGetTextureCape() {
		return null;
	}
	public Object superDropPlayerItem(Object itemStack) {
		return null;
	}
	public float superGetCurrentPlayerStrVsBlock(Object block, boolean par2) {
		return 0.0F;
	}
	public float superGetCurrentPlayerStrVsBlock(Object block, boolean par2, int meta) {
		return 0.0F;
	}
	public Object superSleepInBedAt(int par1, int par2, int par3) {
		return null;
	}
	public boolean superGetHideCape(int par1) {
		return false;
	}
	public void superSetHideCape(int par1, boolean par2) {
	}
	public void superSetSpawnChunk(Object chunkCoordinates, boolean par2) {
	}
	public Object superGetItemIcon(Object itemStack, int par2) {
		return null;
	}
	public boolean superIsCurrentToolAdventureModeExempt(int par1, int par2, int par3) {
		return false;
	}
	public boolean superCanPlayerEdit(int par1, int par2, int par3, int par4, Object itemStack) {
		return false;
	}
	public String superGetEntityName() {
		return null;
	}
	public Object superGetCurrentItemOrArmor(int par1) {
		return null;
	}
	public boolean superGetHideCape() {
		return false;
	}
	public int superFunc_142015_aE() {
		return -1;
	}
	public void superDropRareDrop(int par1) {
	}
	public Object superFunc_110142_aN() {
		return null;
	}
	public boolean superIsAIEnabled() {
		return false;
	}
	public void superUpdateAITasks() {
	}
	public Object superGetPosition(float par1) {
		return null;
	}
	public boolean superHandleLavaMovement() {
		return false;
	}
	public boolean superIsInRangeToRenderVec3D(Object vec3) {
		return false;
	}
	public boolean superShouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7) {
		return false;
	}
	public void superCloseScreenNoPacket() {
	}
	public void superFunc_146100_a(Object tileEntity) {
	}
	public void superFunc_146095_a(Object commandBlockLogic) {
	}
	public void superFunc_146093_a(Object tileEntityHopper) {
	}
	public void superFunc_146104_a(Object tileEntityBeacon) {
	}
	public void superFunc_146102_a(Object tileEntityDispenser) {
	}
	public void superFunc_146098_a(Object tileEntityBrewingStand) {
	}
	public void superFunc_146101_a(Object tileEntityFurnace) {
	}
	public float superGetBreakSpeed(Object block, boolean p_146096_2_, int meta) {
		return 0.0F;
	}
	public float superGetBreakSpeed(Object block, boolean p_146096_2_, int meta, int x, int y, int z) {
		return 0.0F;
	}
	public String superFunc_146067_o(int p_146067_1_) {
		return null;
	}
	public void superFunc_152121_a(Object type, Object resourceLocation) {
	}
	public void superHeal(int par1) {
	}
	public void superDamageEntity(Object damageSource, int par2) {
	}
	public boolean superFunc_71066_bF() {
		return false;
	}
	public void superSendChatToPlayer(String par1Str) {
	}
	public int superGetMaxHealth() {
		return 0;
	}
	public void superAlertWolves(Object entityLiving, boolean par2) {
	}
	public void superDamageArmor(int par1) {
	}
	public void superFunc_82162_bC() {
	}
	public boolean superCanCurrentToolHarvestBlock(int par1, int par2, int par3) {
		return false;
	}
	public boolean superFunc_94062_bN() {
		return false;
	}
	public boolean superCanPickUpLoot() {
		return false;
	}
	public Object superGetTranslator() {
		return null;
	}
	public String superTranslateString(String par1Str, Object... par2ArrayOfObj) {
		return null;
	}
	public int superFunc_96121_ay() {
		return 0;
	}
	public Object superGetLookHelper() {
		return null;
	}
	public Object superGetMoveHelper() {
		return null;
	}
	public Object superGetJumpHelper() {
		return null;
	}
	public Object superGetNavigator() {
		return null;
	}
	public Object superGetEntitySenses() {
		return null;
	}
	public Object superGetLastAttackingEntity() {
		return null;
	}
	public void superSetLastAttackingEntity(Object entity) {
	}
	public Object superGetAttackTarget() {
		return null;
	}
	public void superSetAttackTarget(Object entityLiving) {
	}
	public boolean superCanAttackClass(Class par1Class) {
		return false;
	}
	public void superEatGrassBonus() {
	}
	public boolean superIsWithinHomeDistanceCurrentPosition() {
		return false;
	}
	public boolean superIsWithinHomeDistance(int par1, int par2, int par3) {
		return false;
	}
	public void superSetHomeArea(int par1, int par2, int par3, int par4) {
	}
	public Object superGetHomePosition() {
		return null;
	}
	public float superGetMaximumHomeDistance() {
		return 0;
	}
	public void superDetachHome() {
	}
	public boolean superHasHome() {
		return false;
	}
	public int superGetTalkInterval() {
		return 0;
	}
	public void superPlayLivingSound() {
	}
	public void superSpawnExplosionParticle() {
	}
	public int superGetHealth() {
		return 0;
	}
	public void superSetEntityHealth(int par1) {
	}
	public Object superApplyArmorCalculations(Object damageSource, int par2) {
		return 0;
	}
	public Object superApplyPotionDamageCalculations(Object damageSource, int par2) {
		return 0;
	}
	public String superGetLivingSound() {
		return null;
	}
	public void superKnockBack(Object entity, int par2, double par3, double par5) {
	}
	public int superGetDropItemId() {
		return 0;
	}
	public void superSetMoveForward(float par1) {
	}
	public boolean superCanDespawn() {
		return false;
	}
	public void superDespawnEntity() {
	}
	public int superGetVerticalFaceSpeed() {
		return 0;
	}
	public void superFaceEntity(Object entity, float par2, float par3) {
	}
	public boolean superGetCanSpawnHere() {
		return false;
	}
	public float superGetRenderSizeModifier() {
		return 0;
	}
	public int superGetMaxSpawnedInChunk() {
		return 0;
	}
	public void superOnChangedPotionEffect(Object potionEffect) {
	}
	public float superGetSpeedModifier() {
		return 0;
	}
	public void superInitCreature() {
	}
	public boolean superCanBeSteered() {
		return false;
	}
	public void superFunc_94058_c(String par1Str) {
	}
	public String superFunc_94057_bL() {
		return null;
	}
	public boolean superFunc_94056_bM() {
		return false;
	}
	public void superFunc_96120_a(int par1, float par2) {
	}
	public void superSetCanPickUpLoot(boolean par1) {
	}