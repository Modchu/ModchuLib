package modchu.lib.forge.mc194_202;
	public Modchu_IEntityPlayerSPMaster master;
	public boolean initFlag;
		super((Minecraft)map.get("Object"), (World)map.get("Object1"), (NetHandlerPlayClient)map.get("Object2"), (StatisticsManager)map.get("Object3"));
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
	public void preparePlayerToSpawn() {
		super.preparePlayerToSpawn();
		if (master != null) master.preparePlayerToSpawn();
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
	public SoundEvent getHurtSound() {
		if (master != null) return (SoundEvent) master.getHurtSound();
		return super.getHurtSound();
	}
	public EnumCreatureAttribute getCreatureAttribute() {
		if (master != null) return (EnumCreatureAttribute) master.getCreatureAttribute();
		return super.getCreatureAttribute();
	}
		return super.getCreatureAttribute();
	}
	protected void setSize(float f, float f1) {
		if (master != null) master.setSize(f, f1);
	}
		super.setSize(f, f1);
	}
	public double getMountedYOffset() {
		if (master != null) return master.getMountedYOffset();
		return super.getMountedYOffset();
	}
	protected void resetHeight() {
		if (master != null) master.resetHeight();
	}
	public double getYOffset() {
		if (master != null) return master.getYOffset();
		return super.getYOffset();
	}
	public boolean pushOutOfBlocks(double d, double d1, double d2) {
		if (master != null) return master.pushOutOfBlocks(d, d1, d2);
		return super.pushOutOfBlocks(d, d1, d2);
	}
		return super.pushOutOfBlocks(d, d1, d2);
	}
	public boolean isEntityInsideOpaqueBlock() {
		if (master != null) return master.isEntityInsideOpaqueBlock();
		return super.isEntityInsideOpaqueBlock();
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
	public void updateRidden() {
		if (master != null) master.updateRidden();
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
/*
	@Override
	public void sendMotionUpdates() {
		if (master != null) master.sendMotionUpdates();
	}
		super.sendMotionUpdates();
	}
*/
/*
	public float getMaxHealth() {
		return master != null ? master.getMaxHealth() : super.getMaxHealth();
	}
*/
	public float getEntityHealth() {
		return (Float) (master != null ? master.getHealth() : super.getHealth());
	}
		if (master != null) master.setHealth(f);
	}
	public Object supercopyPlayer(Object entityplayer) {
		return null;
	}
	public boolean superattackEntityFrom(Object damageSource, int par2) {
		return super.attackEntityFrom((DamageSource) damageSource, par2);
	}
	public void superwakeUpPlayer(boolean flag, boolean flag1, boolean flag2) {
		super.wakeUpPlayer(flag, flag1, flag2);
	}
	public void superpreparePlayerToSpawn() {
		super.preparePlayerToSpawn();
	}
	public void supersetPositionCorrection(double par1, double par3, double par5) {
	}
	public void superonLivingUpdate() {
		super.onLivingUpdate();
	}
	public void supermoveEntityWithHeading(float f, float f1) {
		super.moveEntityWithHeading(f, f1);
	}
	public Object supergetHurtSound() {
		return super.getHurtSound();
	}
	public double supergetMountedYOffset() {
		return super.getMountedYOffset();
	}
	public void superresetHeight() {
		super.resetHeight();
	}
	public double supergetYOffset() {
		return super.getYOffset();
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
	public boolean attackEntityFrom(DamageSource damageSource, float amount) {
		return master != null ? master.attackEntityFrom(damageSource, amount) : super.attackEntityFrom(damageSource, amount);
	}
		return super.attackEntityFrom((DamageSource) damageSource, amount);
	}
	public void heal(float healAmount) {
		if (master != null) master.heal(healAmount);
		else super.heal(healAmount);
	}
		super.heal(healAmount);
	}
	public boolean startRiding(Entity entity) {
		return master != null ? master.startRiding(entity) : super.startRiding(entity);
		return super.startRiding((Entity) entity);
	}
	public void onUpdate() {
		if (master != null) master.onUpdate();
		else super.onUpdate();
	}
		super.onUpdate();
	}
	public void onUpdateWalkingPlayer() {
		if (master != null) master.onUpdateWalkingPlayer();
		else super.onUpdateWalkingPlayer();
	}
		super.onUpdateWalkingPlayer();
	}
	public EntityItem dropItem(boolean p_71040_1_) {
		return (EntityItem) (master != null ? master.dropItem(p_71040_1_) : super.dropItem(p_71040_1_));
	}
		return super.dropItem(p_71040_1_);
	}
	public ItemStack dropItemAndGetStack(EntityItem entityItem) {
		return (ItemStack) (master != null ? master.dropItemAndGetStack(entityItem) : super.dropItemAndGetStack(entityItem));
	}
		return super.dropItemAndGetStack((EntityItem) entityItem);
	}
	public void sendChatMessage(String p_71165_1_) {
		if (master != null) master.sendChatMessage(p_71165_1_);
		else super.sendChatMessage(p_71165_1_);
	}
		super.sendChatMessage(p_71165_1_);
	}
	public void swingArm(EnumHand enumHand) {
		if (master != null) master.swingArm(enumHand);
		else super.swingArm(enumHand);
	}
		super.swingArm((EnumHand) enumHand);
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
	public void closeScreenAndDropStack() {
		if (master != null) master.closeScreenAndDropStack();
		else super.closeScreenAndDropStack();
	}
		super.closeScreenAndDropStack();
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
	public StatisticsManager getStatFileWriter() {
		return (StatisticsManager) (master != null ? master.getStatFileWriter() : super.getStatFileWriter());
	}
		return super.getStatFileWriter();
	}
	public void addChatComponentMessage(ITextComponent ITextComponent) {
		if (master != null) master.addChatComponentMessage(ITextComponent);
		else super.addChatComponentMessage(ITextComponent);
	}
		super.addChatComponentMessage((ITextComponent) ITextComponent);
	}
	public void setSprinting(boolean sprinting) {
		if (master != null) master.setSprinting(sprinting);
		else super.setSprinting(sprinting);
	}
		super.setSprinting(sprinting);
	}
	public void setXPStats(float currentXP, int maxXP, int level) {
		if (master != null) master.setXPStats(currentXP, maxXP, level);
		else super.setXPStats(currentXP, maxXP, level);
	}
		super.setXPStats(currentXP, maxXP, level);
	}
	public void addChatMessage(ITextComponent ITextComponent) {
		if (master != null) master.addChatMessage(ITextComponent);
		else super.addChatMessage(ITextComponent);
	}
		super.addChatMessage((ITextComponent) ITextComponent);
	}
	public boolean canCommandSenderUseCommand(int permLevel, String commandName) {
		return master != null ? master.canCommandSenderUseCommand(permLevel, commandName) : super.canCommandSenderUseCommand(permLevel, commandName);
	}
	public BlockPos getPosition() {
		return (BlockPos) (master != null ? master.getPosition() : super.getPosition());
	}
		return super.getPosition();
	}
	public void playSound(SoundEvent soundEvent, float volume, float pitch) {
		if (master != null) master.playSound(soundEvent, volume, pitch);
		else super.playSound(soundEvent, volume, pitch);
	}
		super.playSound((SoundEvent) name, volume, pitch);
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
	public void displayGuiEditCommandCart(CommandBlockBaseLogic commandBlockBaseLogic) {
		if (master != null) master.displayGuiEditCommandCart(commandBlockBaseLogic);
		else super.displayGuiEditCommandCart(commandBlockBaseLogic);
	}
		super.displayGuiEditCommandCart((CommandBlockBaseLogic) commandBlockBaseLogic);
	}
	public void openBook(ItemStack itemStack, EnumHand enumHand) {
		if (master != null) master.openBook(itemStack, enumHand);
		else super.openBook(itemStack, enumHand);
	}
		super.openBook((ItemStack) itemStack, (EnumHand) enumHand);
	}
	public void displayGUIChest(IInventory iInventory) {
		if (master != null) master.displayGUIChest(iInventory);
		else super.displayGUIChest(iInventory);
	}
		super.displayGUIChest((IInventory) iInventory);
	}
	public void openGuiHorseInventory(EntityHorse entityHorse, IInventory iInventory) {
		if (master != null) master.openGuiHorseInventory(entityHorse, iInventory);
		else super.openGuiHorseInventory(entityHorse, iInventory);
	}
		super.openGuiHorseInventory((EntityHorse) entityHorse, (IInventory) iInventory);
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
	public boolean isSneaking() {
		return master != null ? master.isSneaking() : super.isSneaking();
	}
		return super.isSneaking();
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
	protected void entityInit() {
		if (master != null) master.entityInit();
		else super.entityInit();
	}
		super.entityInit();
	}
	public int getItemInUseCount() {
		return master != null ? master.getItemInUseCount() : super.getItemInUseCount();
	}
		return super.getItemInUseCount();
	}
	public boolean isHandActive() {
		return master != null ? master.isHandActive() : super.isHandActive();
	}
		return super.isHandActive();
	}
	public int getMaxInPortalTime() {
		return master != null ? master.getMaxInPortalTime() : super.getMaxInPortalTime();
	}
		return super.getMaxInPortalTime();
	}
	protected SoundEvent getSwimSound() {
		return (SoundEvent) (master != null ? master.getSwimSound() : super.getSwimSound());
	}
		return super.getSwimSound();
	}
	protected SoundEvent getSplashSound() {
		return (SoundEvent) (master != null ? master.getSplashSound() : super.getSplashSound());
	}
		return super.getSplashSound();
	}
	public int getPortalCooldown() {
		return master != null ? master.getPortalCooldown() : super.getPortalCooldown();
	}
		return super.getPortalCooldown();
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
	public void handleStatusUpdate(byte p_70103_1_) {
		if (master != null) master.handleStatusUpdate(p_70103_1_);
		else super.handleStatusUpdate(p_70103_1_);
	}
		super.handleStatusUpdate(p_70103_1_);
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
	protected SoundEvent getDeathSound() {
		return (SoundEvent) (master != null ? master.getDeathSound() : super.getDeathSound());
	}
		return super.getDeathSound();
	}
	public void addToPlayerScore(Entity entity, int amount) {
		if (master != null) master.addToPlayerScore(entity, amount);
		else super.addToPlayerScore(entity, amount);
	}
		super.addToPlayerScore((Entity) entity, amount);
	}
	public EntityItem dropItem(ItemStack itemStack, boolean unused) {
		return (EntityItem) (master != null ? master.dropItem(itemStack, unused) : super.dropItem(itemStack, unused));
	}
		return super.dropItem((ItemStack) itemStack, unused);
	}
	public EntityItem dropItem(ItemStack itemStack, boolean dropAround, boolean traceItem) {
		return (EntityItem) (master != null ? master.dropItem(itemStack, dropAround, traceItem) : super.dropItem(itemStack, dropAround, traceItem));
	}
		return super.dropItem((ItemStack) itemStack, dropAround, traceItem);
	}
	public float getDigSpeed(IBlockState iBlockState) {
		return master != null ? master.getDigSpeed(iBlockState) : super.getDigSpeed(iBlockState);
	}
		return super.getDigSpeed((IBlockState) iBlockState);
	}
	public float getDigSpeed(IBlockState iBlockState, BlockPos blockPos) {
		return master != null ? master.getDigSpeed(iBlockState, blockPos) : super.getDigSpeed(iBlockState, blockPos);
	}
		return super.getDigSpeed((IBlockState) iBlockState, (BlockPos) blockPos);
	}
	public boolean canHarvestBlock(IBlockState iBlockState) {
		return master != null ? master.canHarvestBlock(iBlockState) : super.canHarvestBlock(iBlockState);
	}
		return super.canHarvestBlock((IBlockState) block);
	}
	public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.readEntityFromNBT(nBTTagCompound);
		else super.readEntityFromNBT(nBTTagCompound);
	}
		super.readEntityFromNBT((NBTTagCompound) nBTTagCompound);
	}
	public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.writeEntityToNBT(nBTTagCompound);
		else super.writeEntityToNBT(nBTTagCompound);
	}
		super.writeEntityToNBT((NBTTagCompound) nBTTagCompound);
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
	public EnumActionResult interact(Entity entity, ItemStack itemStack, EnumHand enumHand) {
		return (EnumActionResult) (master != null ? master.interact(entity, itemStack, enumHand) : super.interact(entity, itemStack, enumHand));
	}
		return super.interact((Entity) entity, (ItemStack) itemStack, (EnumHand) enumHand);
	}
	public ItemStack getHeldItemMainhand() {
		return (ItemStack) (master != null ? master.getHeldItemMainhand() : super.getHeldItemMainhand());
	}
		return super.getHeldItemMainhand();
	}
	public void attackTargetEntityWithCurrentItem(Entity entity) {
		if (master != null) master.attackTargetEntityWithCurrentItem(entity);
		else super.attackTargetEntityWithCurrentItem(entity);
	}
		super.attackTargetEntityWithCurrentItem((Entity) entity);
	}
	public void setDead() {
		if (master != null) master.setDead();
		else super.setDead();
	}
		super.setDead();
	}
	public GameProfile getGameProfile() {
		return (GameProfile) (master != null ? master.getGameProfile() : super.getGameProfile());
	}
		return super.getGameProfile();
	}
	public SleepResult trySleep(BlockPos blockPos) {
		return (SleepResult) (master != null ? master.trySleep(blockPos) : super.trySleep(blockPos));
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
	public void addStat(StatBase statBase) {
		if (master != null) master.addStat(statBase);
		else super.addStat(statBase);
	}
		super.addStat((StatBase) statBase);
	}
	public void takeStat(StatBase statBase) {
		if (master != null) master.takeStat(statBase);
		else super.takeStat(statBase);
	}
		super.takeStat((StatBase) statBase);
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
	public void fall(float distance, float damageMultiplier) {
		if (master != null) master.fall(distance, damageMultiplier);
		else super.fall(distance, damageMultiplier);
	}
		super.fall(distance, damageMultiplier);
	}
	protected SoundEvent getFallSound(int damageValue) {
		return (SoundEvent) (master != null ? master.getFallSound(damageValue) : super.getFallSound(damageValue));
	}
		return super.getFallSound(damageValue);
	}
	public void onKillEntity(EntityLivingBase entityLivingBase) {
		if (master != null) master.onKillEntity(entityLivingBase);
		else super.onKillEntity(entityLivingBase);
	}
		super.onKillEntity((EntityLivingBase) entityLivingBase);
	}
	public void setInWeb() {
		if (master != null) master.setInWeb();
		else super.setInWeb();
	}
		super.setInWeb();
	}
	public ItemStack getItemStackFromSlot(EntityEquipmentSlot entityEquipmentSlot) {
		return (ItemStack) (master != null ? master.getItemStackFromSlot(entityEquipmentSlot) : super.getItemStackFromSlot(entityEquipmentSlot));
	}
		return super.getItemStackFromSlot((EntityEquipmentSlot) entityEquipmentSlot);
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
	public boolean getAlwaysRenderNameTagForRender() {
		return master != null ? master.getAlwaysRenderNameTagForRender() : super.getAlwaysRenderNameTagForRender();
	}
		return super.getAlwaysRenderNameTagForRender();
	}
	public void clonePlayer(EntityPlayer entityPlayer, boolean respawnFromEnd) {
		if (master != null) master.clonePlayer(entityPlayer, respawnFromEnd);
		else super.clonePlayer(entityPlayer, respawnFromEnd);
	}
		super.clonePlayer((EntityPlayer) entityPlayer, respawnFromEnd);
	}
	protected boolean canTriggerWalking() {
		return master != null ? master.canTriggerWalking() : super.canTriggerWalking();
	}
		return super.canTriggerWalking();
	}
	public String getName() {
		return master != null ? master.getName() : super.getName();
	}
	public InventoryEnderChest getInventoryEnderChest() {
		return (InventoryEnderChest) (master != null ? master.getInventoryEnderChest() : super.getInventoryEnderChest());
	}
		return super.getInventoryEnderChest();
	}
	public void setItemStackToSlot(EntityEquipmentSlot entityEquipmentSlot, ItemStack itemStack) {
		if (master != null) master.setItemStackToSlot(entityEquipmentSlot, itemStack);
		else super.setItemStackToSlot(entityEquipmentSlot, itemStack);
	}
		super.setItemStackToSlot((EntityEquipmentSlot) entityEquipmentSlot, (ItemStack) itemStack);
	}
	public boolean isInvisibleToPlayer(EntityPlayer entityPlayer) {
		return master != null ? master.isInvisibleToPlayer(entityPlayer) : super.isInvisibleToPlayer(entityPlayer);
	}
		return super.isInvisibleToPlayer((EntityPlayer) entityPlayer);
	}
	public boolean isPushedByWater() {
		return master != null ? master.isPushedByWater() : super.isPushedByWater();
	}
		return super.isPushedByWater();
	}
	public Scoreboard getWorldScoreboard() {
		return (Scoreboard) (master != null ? master.getWorldScoreboard() : super.getWorldScoreboard());
	}
		return super.getWorldScoreboard();
	}
	public Team getTeam() {
		return (Team) (master != null ? master.getTeam() : super.getTeam());
	}
		return super.getTeam();
	}
	public ITextComponent getDisplayName() {
		return (ITextComponent) (master != null ? master.getDisplayName() : super.getDisplayName());
	}
		return super.getDisplayName();
	}
	public float getEyeHeight() {
		return master != null ? master.getEyeHeight() : super.getEyeHeight();
	}
		return super.getEyeHeight();
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
	public boolean isWearing(EnumPlayerModelParts enumPlayerModelParts) {
		return master != null ? master.isWearing(enumPlayerModelParts) : super.isWearing(enumPlayerModelParts);
	}
		return super.isWearing((EnumPlayerModelParts) enumPlayerModelParts);
	}
	public boolean sendCommandFeedback() {
		return master != null ? master.sendCommandFeedback() : super.sendCommandFeedback();
	}
		return super.sendCommandFeedback();
	}
	public boolean replaceItemInInventory(int p_174820_1_, ItemStack itemStack) {
		return master != null ? master.replaceItemInInventory(p_174820_1_, itemStack) : super.replaceItemInInventory(p_174820_1_, itemStack);
	}
		return super.replaceItemInInventory(p_174820_1_, (ItemStack) itemStack);
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
	public void onKillCommand() {
		if (master != null) master.onKillCommand();
		else super.onKillCommand();
	}
		super.onKillCommand();
	}
	protected void updateFallState(double p_180433_1_, boolean p_180433_3_, IBlockState iBlockState, BlockPos blockPos) {
		if (master != null) master.updateFallState(p_180433_1_, p_180433_3_, iBlockState, blockPos);
		else super.updateFallState(p_180433_1_, p_180433_3_, iBlockState, blockPos);
	}
		super.updateFallState(p_180433_1_, p_180433_3_, (IBlockState) iBlockState, (BlockPos) blockPos);
	}
	public boolean canBreatheUnderwater() {
		return master != null ? master.canBreatheUnderwater() : super.canBreatheUnderwater();
	}
		return super.canBreatheUnderwater();
	}
	public void onEntityUpdate() {
		if (master != null) master.onEntityUpdate();
		else super.onEntityUpdate();
	}
		super.onEntityUpdate();
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
	protected boolean canDropLoot() {
		return master != null ? master.canDropLoot() : super.canDropLoot();
	}
		return super.canDropLoot();
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
	protected void updatePotionMetadata() {
		if (master != null) master.updatePotionMetadata();
		else super.updatePotionMetadata();
	}
		super.updatePotionMetadata();
	}
	protected void resetPotionEffectMetadata() {
		if (master != null) master.resetPotionEffectMetadata();
		else super.resetPotionEffectMetadata();
	}
		super.resetPotionEffectMetadata();
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
	public boolean isEntityAlive() {
		return master != null ? master.isEntityAlive() : super.isEntityAlive();
	}
		return super.isEntityAlive();
	}
	public void performHurtAnimation() {
		if (master != null) master.performHurtAnimation();
		else super.performHurtAnimation();
	}
		super.performHurtAnimation();
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
	public EntityLivingBase getAttackingEntity() {
		return (EntityLivingBase) (master != null ? master.getAttackingEntity() : super.getAttackingEntity());
	}
		return super.getAttackingEntity();
	}
	protected void kill() {
		if (master != null) master.kill();
		else super.kill();
	}
		super.kill();
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
	public AbstractAttributeMap getAttributeMap() {
		return (AbstractAttributeMap) (master != null ? master.getAttributeMap() : super.getAttributeMap());
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
	protected float getJumpUpwardsMotion() {
		return master != null ? master.getJumpUpwardsMotion() : super.getJumpUpwardsMotion();
	}
		return super.getJumpUpwardsMotion();
	}
	protected void handleJumpWater() {
		if (master != null) master.handleJumpWater();
		else super.handleJumpWater();
	}
		super.handleJumpWater();
	}
	protected void handleJumpLava() {
		if (master != null) master.handleJumpLava();
		else super.handleJumpLava();
	}
		super.handleJumpLava();
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
	protected float updateDistance(float p_110146_1_, float p_110146_2_) {
		return master != null ? master.updateDistance(p_110146_1_, p_110146_2_) : super.updateDistance(p_110146_1_, p_110146_2_);
	}
		return super.updateDistance(p_110146_1_, p_110146_2_);
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
	public void setPositionAndRotationDirect(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
		if (master != null) master.setPositionAndRotationDirect(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_, p_180426_10_);
		else super.setPositionAndRotationDirect(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_, p_180426_10_);
	}
		super.setPositionAndRotationDirect(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_, p_180426_10_);
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
	public Vec3d getLookVec() {
		return (Vec3d) (master != null ? master.getLookVec() : super.getLookVec());
	}
		return super.getLookVec();
	}
	public Vec3d getLook(float p_70676_1_) {
		return (Vec3d) (master != null ? master.getLook(p_70676_1_) : super.getLook(p_70676_1_));
	}
		return super.getLook(p_70676_1_);
	}
	public float getSwingProgress(float p_70678_1_) {
		return master != null ? master.getSwingProgress(p_70678_1_) : super.getSwingProgress(p_70678_1_);
	}
		return super.getSwingProgress(p_70678_1_);
	}
	public boolean canBeCollidedWith() {
		return master != null ? master.canBeCollidedWith() : super.canBeCollidedWith();
	}
		return super.canBeCollidedWith();
	}
	public boolean canBePushed() {
		return master != null ? master.canBePushed() : super.canBePushed();
	}
		return super.canBePushed();
	}
	protected void setBeenAttacked() {
		if (master != null) master.setBeenAttacked();
		else super.setBeenAttacked();
	}
		super.setBeenAttacked();
	}
	public float getRotationYawHead() {
		return master != null ? master.getRotationYawHead() : super.getRotationYawHead();
	}
		return super.getRotationYawHead();
	}
	public void setRotationYawHead(float rotation) {
		if (master != null) master.setRotationYawHead(rotation);
		else super.setRotationYawHead(rotation);
	}
		super.setRotationYawHead(rotation);
	}
	public void sendEnterCombat() {
		if (master != null) master.sendEnterCombat();
		else super.sendEnterCombat();
	}
		super.sendEnterCombat();
	}
	public void sendEndCombat() {
		if (master != null) master.sendEndCombat();
		else super.sendEndCombat();
	}
		super.sendEndCombat();
	}
	protected void markPotionsDirty() {
		if (master != null) master.markPotionsDirty();
		else super.markPotionsDirty();
	}
		super.markPotionsDirty();
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
	public int getEntityId() {
		return master != null ? master.getEntityId() : super.getEntityId();
	}
		return super.getEntityId();
	}
	public void setEntityId(int id) {
		if (master != null) master.setEntityId(id);
		else super.setEntityId(id);
	}
		super.setEntityId(id);
	}
	public EntityDataManager getDataManager() {
		return (EntityDataManager) (master != null ? master.getDataManager() : super.getDataManager());
	}
		return super.getDataManager();
	}
	public boolean equals(Object p_equals_1_) {
		return master != null ? master.equals(p_equals_1_) : super.equals(p_equals_1_);
	}
		return super.equals(p_equals_1_);
	}
	public int hashCode() {
		return master != null ? master.hashCode() : super.hashCode();
	}
		return super.hashCode();
	}
	protected void setRotation(float yaw, float pitch) {
		if (master != null) master.setRotation(yaw, pitch);
		else super.setRotation(yaw, pitch);
	}
		super.setRotation(yaw, pitch);
	}
	public void setPosition(double x, double y, double z) {
		if (master != null) master.setPosition(x, y, z);
		else super.setPosition(x, y, z);
	}
		super.setPosition(x, y, z);
	}
	public void setAngles(float yaw, float pitch) {
		if (master != null) master.setAngles(yaw, pitch);
		else super.setAngles(yaw, pitch);
	}
		super.setAngles(yaw, pitch);
	}
	protected void setOnFireFromLava() {
		if (master != null) master.setOnFireFromLava();
		else super.setOnFireFromLava();
	}
		super.setOnFireFromLava();
	}
	public void setFire(int seconds) {
		if (master != null) master.setFire(seconds);
		else super.setFire(seconds);
	}
		super.setFire(seconds);
	}
	public void extinguish() {
		if (master != null) master.extinguish();
		else super.extinguish();
	}
		super.extinguish();
	}
	public boolean isOffsetPositionInLiquid(double x, double y, double z) {
		return master != null ? master.isOffsetPositionInLiquid(x, y, z) : super.isOffsetPositionInLiquid(x, y, z);
	}
		return super.isOffsetPositionInLiquid(x, y, z);
	}
	public void moveEntity(double x, double y, double z) {
		if (master != null) master.moveEntity(x, y, z);
		else super.moveEntity(x, y, z);
	}
		super.moveEntity(x, y, z);
	}
	protected void doBlockCollisions() {
		if (master != null) master.doBlockCollisions();
		else super.doBlockCollisions();
	}
		super.doBlockCollisions();
	}
	protected void playStepSound(BlockPos blockPos, Block block) {
		if (master != null) master.playStepSound(blockPos, block);
		else super.playStepSound(blockPos, block);
	}
		super.playStepSound((BlockPos) blockPos, (Block) block);
	}
	public boolean isSilent() {
		return master != null ? master.isSilent() : super.isSilent();
	}
		return super.isSilent();
	}
	public void setSilent(boolean isSilent) {
		if (master != null) master.setSilent(isSilent);
		else super.setSilent(isSilent);
	}
		super.setSilent(isSilent);
	}
	public AxisAlignedBB getCollisionBoundingBox() {
		return (AxisAlignedBB) (master != null ? master.getCollisionBoundingBox() : super.getCollisionBoundingBox());
	}
		return super.getCollisionBoundingBox();
	}
	protected void dealFireDamage(int amount) {
		if (master != null) master.dealFireDamage(amount);
		else super.dealFireDamage(amount);
	}
		super.dealFireDamage(amount);
	}
	public boolean isWet() {
		return master != null ? master.isWet() : super.isWet();
	}
		return super.isWet();
	}
	public boolean isInWater() {
		return master != null ? master.isInWater() : super.isInWater();
	}
		return super.isInWater();
	}
	public boolean handleWaterMovement() {
		return master != null ? master.handleWaterMovement() : super.handleWaterMovement();
	}
		return super.handleWaterMovement();
	}
	public void spawnRunningParticles() {
		if (master != null) master.spawnRunningParticles();
		else super.spawnRunningParticles();
	}
		super.spawnRunningParticles();
	}
	protected void createRunningParticles() {
		if (master != null) master.createRunningParticles();
		else super.createRunningParticles();
	}
		super.createRunningParticles();
	}
	public boolean isInsideOfMaterial(Material material) {
		return master != null ? master.isInsideOfMaterial(material) : super.isInsideOfMaterial(material);
	}
		return super.isInsideOfMaterial((Material) material);
	}
	public boolean isInLava() {
		return master != null ? master.isInLava() : super.isInLava();
	}
		return super.isInLava();
	}
	public void moveRelative(float strafe, float forward, float friction) {
		if (master != null) master.moveRelative(strafe, forward, friction);
		else super.moveRelative(strafe, forward, friction);
	}
		super.moveRelative(strafe, forward, friction);
	}
	public int getBrightnessForRender(float p_70070_1_) {
		return master != null ? master.getBrightnessForRender(p_70070_1_) : super.getBrightnessForRender(p_70070_1_);
	}
		return super.getBrightnessForRender(p_70070_1_);
	}
	public float getBrightness(float p_70013_1_) {
		return master != null ? master.getBrightness(p_70013_1_) : super.getBrightness(p_70013_1_);
	}
		return super.getBrightness(p_70013_1_);
	}
	public void setWorld(World world) {
		if (master != null) master.setWorld(world);
		else super.setWorld(world);
	}
		super.setWorld((World) world);
	}
	public void setPositionAndRotation(double x, double y, double z, float yaw, float pitch) {
		if (master != null) master.setPositionAndRotation(x, y, z, yaw, pitch);
		else super.setPositionAndRotation(x, y, z, yaw, pitch);
	}
		super.setPositionAndRotation(x, y, z, yaw, pitch);
	}
	public void moveToBlockPosAndAngles(BlockPos blockPos, float p_174828_2_, float p_174828_3_) {
		if (master != null) master.moveToBlockPosAndAngles(blockPos, p_174828_2_, p_174828_3_);
		else super.moveToBlockPosAndAngles(blockPos, p_174828_2_, p_174828_3_);
	}
		super.moveToBlockPosAndAngles((BlockPos) blockPos, p_174828_2_, p_174828_3_);
	}
	public void setLocationAndAngles(double x, double y, double z, float yaw, float pitch) {
		if (master != null) master.setLocationAndAngles(x, y, z, yaw, pitch);
		else super.setLocationAndAngles(x, y, z, yaw, pitch);
	}
		super.setLocationAndAngles(x, y, z, yaw, pitch);
	}
	public float getDistanceToEntity(Entity entity) {
		return master != null ? master.getDistanceToEntity(entity) : super.getDistanceToEntity(entity);
	}
		return super.getDistanceToEntity((Entity) entity);
	}
	public double getDistanceSq(double x, double y, double z) {
		return master != null ? master.getDistanceSq(x, y, z) : super.getDistanceSq(x, y, z);
	}
		return super.getDistanceSq(x, y, z);
	}
	public double getDistanceSq(BlockPos blockPos) {
		return master != null ? master.getDistanceSq(blockPos) : super.getDistanceSq(blockPos);
	}
		return super.getDistanceSq((BlockPos) blockPos);
	}
	public double getDistanceSqToCenter(BlockPos blockPos) {
		return master != null ? master.getDistanceSqToCenter(blockPos) : super.getDistanceSqToCenter(blockPos);
	}
		return super.getDistanceSqToCenter((BlockPos) blockPos);
	}
	public double getDistance(double x, double y, double z) {
		return master != null ? master.getDistance(x, y, z) : super.getDistance(x, y, z);
	}
		return super.getDistance(x, y, z);
	}
	public double getDistanceSqToEntity(Entity entity) {
		return master != null ? master.getDistanceSqToEntity(entity) : super.getDistanceSqToEntity(entity);
	}
		return super.getDistanceSqToEntity((Entity) entity);
	}
	public void onCollideWithPlayer(EntityPlayer entityPlayer) {
		if (master != null) master.onCollideWithPlayer(entityPlayer);
		else super.onCollideWithPlayer(entityPlayer);
	}
		super.onCollideWithPlayer((EntityPlayer) entityPlayer);
	}
	public void applyEntityCollision(Entity entity) {
		if (master != null) master.applyEntityCollision(entity);
		else super.applyEntityCollision(entity);
	}
		super.applyEntityCollision((Entity) entity);
	}
	public void addVelocity(double x, double y, double z) {
		if (master != null) master.addVelocity(x, y, z);
		else super.addVelocity(x, y, z);
	}
		super.addVelocity(x, y, z);
	}
	public Vec3d getPositionEyes(float p_174824_1_) {
		return (Vec3d) (master != null ? master.getPositionEyes(p_174824_1_) : super.getPositionEyes(p_174824_1_));
	}
		return super.getPositionEyes(p_174824_1_);
	}
	public RayTraceResult rayTrace(double p_174822_1_, float p_174822_3_) {
		return (RayTraceResult) (master != null ? master.rayTrace(p_174822_1_, p_174822_3_) : super.rayTrace(p_174822_1_, p_174822_3_));
	}
		return super.rayTrace(p_174822_1_, p_174822_3_);
	}
	public boolean isInRangeToRender3d(double x, double y, double z) {
		return master != null ? master.isInRangeToRender3d(x, y, z) : super.isInRangeToRender3d(x, y, z);
	}
		return super.isInRangeToRender3d(x, y, z);
	}
	public boolean isInRangeToRenderDist(double distance) {
		return master != null ? master.isInRangeToRenderDist(distance) : super.isInRangeToRenderDist(distance);
	}
		return super.isInRangeToRenderDist(distance);
	}
	public boolean writeToNBTAtomically(NBTTagCompound nBTTagCompound) {
		return master != null ? master.writeToNBTAtomically(nBTTagCompound) : super.writeToNBTAtomically(nBTTagCompound);
	}
		return super.writeToNBTAtomically((NBTTagCompound) nBTTagCompound);
	}
	public boolean writeToNBTOptional(NBTTagCompound nBTTagCompound) {
		return master != null ? master.writeToNBTOptional(nBTTagCompound) : super.writeToNBTOptional(nBTTagCompound);
	}
		return super.writeToNBTOptional((NBTTagCompound) nBTTagCompound);
	}
		return super.writeToNBT((NBTTagCompound) nBTTagCompound);
	}
	public void readFromNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.readFromNBT(nBTTagCompound);
		else super.readFromNBT(nBTTagCompound);
	}
		super.readFromNBT((NBTTagCompound) nBTTagCompound);
	}
	protected boolean shouldSetPosAfterLoading() {
		return master != null ? master.shouldSetPosAfterLoading() : super.shouldSetPosAfterLoading();
	}
		return super.shouldSetPosAfterLoading();
	}
	protected NBTTagList newDoubleNBTList(double... numbers) {
		return (NBTTagList) (master != null ? master.newDoubleNBTList(numbers) : super.newDoubleNBTList(numbers));
	}
		return super.newDoubleNBTList(numbers);
	}
	protected NBTTagList newFloatNBTList(float... numbers) {
		return (NBTTagList) (master != null ? master.newFloatNBTList(numbers) : super.newFloatNBTList(numbers));
	}
		return super.newFloatNBTList(numbers);
	}
	public EntityItem dropItem(Item item, int size) {
		return (EntityItem) (master != null ? master.dropItem(item, size) : super.dropItem(item, size));
	}
		return super.dropItem((Item) item, size);
	}
	public EntityItem dropItemWithOffset(Item item, int size, float p_145778_3_) {
		return (EntityItem) (master != null ? master.dropItemWithOffset(item, size, p_145778_3_) : super.dropItemWithOffset(item, size, p_145778_3_));
	}
		return super.dropItemWithOffset((Item) item, size, p_145778_3_);
	}
	public EntityItem entityDropItem(ItemStack itemStack, float offsetY) {
		return (EntityItem) (master != null ? master.entityDropItem(itemStack, offsetY) : super.entityDropItem(itemStack, offsetY));
	}
		return super.entityDropItem((ItemStack) itemStack, offsetY);
	}
	public AxisAlignedBB getCollisionBox(Entity entity) {
		return (AxisAlignedBB) (master != null ? master.getCollisionBox(entity) : super.getCollisionBox(entity));
	}
		return super.getCollisionBox((Entity) entity);
	}
	public float getCollisionBorderSize() {
		return master != null ? master.getCollisionBorderSize() : super.getCollisionBorderSize();
	}
		return super.getCollisionBorderSize();
	}
	public void setPortal(BlockPos blockPos) {
		if (master != null) master.setPortal(blockPos);
		else super.setPortal(blockPos);
	}
	public void setVelocity(double x, double y, double z) {
		if (master != null) master.setVelocity(x, y, z);
		else super.setVelocity(x, y, z);
	}
		super.setVelocity(x, y, z);
	}
	public boolean isBurning() {
		return master != null ? master.isBurning() : super.isBurning();
	}
		return super.isBurning();
	}
	public boolean isRiding() {
		return master != null ? master.isRiding() : super.isRiding();
	}
		return super.isRiding();
	}
	public void setSneaking(boolean sneaking) {
		if (master != null) master.setSneaking(sneaking);
		else super.setSneaking(sneaking);
	}
		super.setSneaking(sneaking);
	}
	public boolean isSprinting() {
		return master != null ? master.isSprinting() : super.isSprinting();
	}
		return super.isSprinting();
	}
	public boolean isInvisible() {
		return master != null ? master.isInvisible() : super.isInvisible();
	}
		return super.isInvisible();
	}
	public void setInvisible(boolean invisible) {
		if (master != null) master.setInvisible(invisible);
		else super.setInvisible(invisible);
	}
		super.setInvisible(invisible);
	}
	protected boolean getFlag(int flag) {
		return master != null ? master.getFlag(flag) : super.getFlag(flag);
	}
		return super.getFlag(flag);
	}
	protected void setFlag(int flag, boolean set) {
		if (master != null) master.setFlag(flag, set);
		else super.setFlag(flag, set);
	}
		super.setFlag(flag, set);
	}
	public int getAir() {
		return master != null ? master.getAir() : super.getAir();
	}
		return super.getAir();
	}
	public void setAir(int air) {
		if (master != null) master.setAir(air);
		else super.setAir(air);
	}
		super.setAir(air);
	}
	public void onStruckByLightning(EntityLightningBolt entityLightningBolt) {
		if (master != null) master.onStruckByLightning(entityLightningBolt);
		else super.onStruckByLightning(entityLightningBolt);
	}
		super.onStruckByLightning((EntityLightningBolt) entityLightningBolt);
	}
	public Entity[] getParts() {
		return (Entity[]) (master != null ? master.getParts() : super.getParts());
	}
		return super.getParts();
	}
	public boolean isEntityEqual(Entity entity) {
		return master != null ? master.isEntityEqual(entity) : super.isEntityEqual(entity);
	}
		return super.isEntityEqual((Entity) entity);
	}
	public boolean canBeAttackedWithItem() {
		return master != null ? master.canBeAttackedWithItem() : super.canBeAttackedWithItem();
	}
		return super.canBeAttackedWithItem();
	}
	public boolean hitByEntity(Entity entity) {
		return master != null ? master.hitByEntity(entity) : super.hitByEntity(entity);
	}
		return super.hitByEntity((Entity) entity);
	}
	public String toString() {
		return master != null ? master.toString() : super.toString();
	}
		return super.toString();
	}
	public boolean isEntityInvulnerable(DamageSource damageSource) {
		return master != null ? master.isEntityInvulnerable(damageSource) : super.isEntityInvulnerable(damageSource);
	}
		return super.isEntityInvulnerable((DamageSource) damageSource);
	}
	public void copyLocationAndAnglesFrom(Entity entity) {
		if (master != null) master.copyLocationAndAnglesFrom(entity);
		else super.copyLocationAndAnglesFrom(entity);
	}
		super.copyLocationAndAnglesFrom((Entity) entity);
	}
	public Entity changeDimension(int dimensionId) {
		return (Entity) (master != null ? master.changeDimension(dimensionId) : super.changeDimension(dimensionId));
	}
		return super.changeDimension(dimensionId);
	}
	public float getExplosionResistance(Explosion explosion, World world, BlockPos blockPos, IBlockState iBlockState) {
		return master != null ? master.getExplosionResistance(explosion, world, blockPos, iBlockState) : super.getExplosionResistance(explosion, world, blockPos, iBlockState);
	}
		return super.getExplosionResistance((Explosion) explosion, (World) world, (BlockPos) blockPos, (IBlockState) iBlockState);
	}
	public boolean verifyExplosion(Explosion explosion, World world, BlockPos blockPos, IBlockState iBlockState, float p_174816_5_) {
		return master != null ? master.verifyExplosion(explosion, world, blockPos, iBlockState, p_174816_5_) : super.verifyExplosion(explosion, world, blockPos, iBlockState, p_174816_5_);
	}
		return super.verifyExplosion((Explosion) explosion, (World) world, (BlockPos) blockPos, (IBlockState) iBlockState, p_174816_5_);
	}
	public int getMaxFallHeight() {
		return master != null ? master.getMaxFallHeight() : super.getMaxFallHeight();
	}
		return super.getMaxFallHeight();
	}
	public Vec3d getLastPortalVec() {
		return (Vec3d) (master != null ? master.getLastPortalVec() : super.getLastPortalVec());
	}
	public boolean doesEntityNotTriggerPressurePlate() {
		return master != null ? master.doesEntityNotTriggerPressurePlate() : super.doesEntityNotTriggerPressurePlate();
	}
		return super.doesEntityNotTriggerPressurePlate();
	}
	public void addEntityCrashInfo(CrashReportCategory crashReportCategory) {
		if (master != null) master.addEntityCrashInfo(crashReportCategory);
		else super.addEntityCrashInfo(crashReportCategory);
	}
		super.addEntityCrashInfo((CrashReportCategory) crashReportCategory);
	}
	public boolean canRenderOnFire() {
		return master != null ? master.canRenderOnFire() : super.canRenderOnFire();
	}
		return super.canRenderOnFire();
	}
	public UUID getUniqueID() {
		return master != null ? master.getUniqueID() : super.getUniqueID();
	}
		return super.getUniqueID();
	}
	public void setCustomNameTag(String p_96094_1_) {
		if (master != null) master.setCustomNameTag(p_96094_1_);
		else super.setCustomNameTag(p_96094_1_);
	}
		super.setCustomNameTag(p_96094_1_);
	}
	public String getCustomNameTag() {
		return master != null ? master.getCustomNameTag() : super.getCustomNameTag();
	}
		return super.getCustomNameTag();
	}
	public boolean hasCustomName() {
		return master != null ? master.hasCustomName() : super.hasCustomName();
	}
		return super.hasCustomName();
	}
	public void setAlwaysRenderNameTag(boolean p_174805_1_) {
		if (master != null) master.setAlwaysRenderNameTag(p_174805_1_);
		else super.setAlwaysRenderNameTag(p_174805_1_);
	}
		super.setAlwaysRenderNameTag(p_174805_1_);
	}
	public boolean getAlwaysRenderNameTag() {
		return master != null ? master.getAlwaysRenderNameTag() : super.getAlwaysRenderNameTag();
	}
		return super.getAlwaysRenderNameTag();
	}
	public void setPositionAndUpdate(double x, double y, double z) {
		if (master != null) master.setPositionAndUpdate(x, y, z);
		else super.setPositionAndUpdate(x, y, z);
	}
		super.setPositionAndUpdate(x, y, z);
	}
	public EnumFacing getHorizontalFacing() {
		return (EnumFacing) (master != null ? master.getHorizontalFacing() : super.getHorizontalFacing());
	}
		return super.getHorizontalFacing();
	}
	protected HoverEvent getHoverEvent() {
		return (HoverEvent) (master != null ? master.getHoverEvent() : super.getHoverEvent());
	}
		return super.getHoverEvent();
	}
	public boolean isSpectatedByPlayer(EntityPlayerMP entityPlayerMP) {
		return master != null ? master.isSpectatedByPlayer(entityPlayerMP) : super.isSpectatedByPlayer(entityPlayerMP);
	}
		return super.isSpectatedByPlayer((EntityPlayerMP) entityPlayerMP);
	}
	public AxisAlignedBB getEntityBoundingBox() {
		return (AxisAlignedBB) (master != null ? master.getEntityBoundingBox() : super.getEntityBoundingBox());
	}
		return super.getEntityBoundingBox();
	}
	public void setEntityBoundingBox(AxisAlignedBB axisAlignedBB) {
		if (master != null) master.setEntityBoundingBox(axisAlignedBB);
		else super.setEntityBoundingBox(axisAlignedBB);
	}
		super.setEntityBoundingBox((AxisAlignedBB) axisAlignedBB);
	}
	public boolean isOutsideBorder() {
		return master != null ? master.isOutsideBorder() : super.isOutsideBorder();
	}
		return super.isOutsideBorder();
	}
	public void setOutsideBorder(boolean p_174821_1_) {
		if (master != null) master.setOutsideBorder(p_174821_1_);
		else super.setOutsideBorder(p_174821_1_);
	}
		super.setOutsideBorder(p_174821_1_);
	}
	public Vec3d getPositionVector() {
		return (Vec3d) (master != null ? master.getPositionVector() : super.getPositionVector());
	}
		return super.getPositionVector();
	}
	public World getEntityWorld() {
		return (World) (master != null ? master.getEntityWorld() : super.getEntityWorld());
	}
		return super.getEntityWorld();
	}
	public Entity getCommandSenderEntity() {
		return (Entity) (master != null ? master.getCommandSenderEntity() : super.getCommandSenderEntity());
	}
		return super.getCommandSenderEntity();
	}
	public void setCommandStat(Type type, int amount) {
		if (master != null) master.setCommandStat(type, amount);
		else super.setCommandStat(type, amount);
	}
		super.setCommandStat((Type) type, amount);
	}
	public CommandResultStats getCommandStats() {
		return (CommandResultStats) (master != null ? master.getCommandStats() : super.getCommandStats());
	}
		return super.getCommandStats();
	}
	public void setCommandStats(Entity entity) {
		if (master != null) master.setCommandStats(entity);
		else super.setCommandStats(entity);
	}
		super.setCommandStats((Entity) entity);
	}
	public boolean isImmuneToExplosions() {
		return master != null ? master.isImmuneToExplosions() : super.isImmuneToExplosions();
	}
		return super.isImmuneToExplosions();
	}
	protected void applyEnchantments(EntityLivingBase entityLivingBase, Entity entity) {
		if (master != null) master.applyEnchantments(entityLivingBase, entity);
		else super.applyEnchantments(entityLivingBase, entity);
	}
		super.applyEnchantments((EntityLivingBase) entityLivingBase, (Entity) entity);
	}
	public NBTTagCompound getEntityData() {
		return (NBTTagCompound) (master != null ? master.getEntityData() : super.getEntityData());
	}
		return super.getEntityData();
	}
	public boolean shouldRiderSit() {
		return master != null ? master.shouldRiderSit() : super.shouldRiderSit();
	}
		return super.shouldRiderSit();
	}
	public ItemStack getPickedResult(RayTraceResult movingObjectPosition) {
		return (ItemStack) (master != null ? master.getPickedResult(movingObjectPosition) : super.getPickedResult(movingObjectPosition));
	}
		return super.getPickedResult((RayTraceResult) movingObjectPosition);
	}
	public UUID getPersistentID() {
		return master != null ? master.getPersistentID() : super.getPersistentID();
	}
		return super.getPersistentID();
	}
	public boolean shouldRenderInPass(int pass) {
		return master != null ? master.shouldRenderInPass(pass) : super.shouldRenderInPass(pass);
	}
		return super.shouldRenderInPass(pass);
	}
	public boolean isCreatureType(EnumCreatureType enumCreatureType, boolean forSpawnCount) {
		return master != null ? master.isCreatureType(enumCreatureType, forSpawnCount) : super.isCreatureType(enumCreatureType, forSpawnCount);
	}
		return super.isCreatureType((EnumCreatureType) enumCreatureType, forSpawnCount);
	}
	public boolean canRiderInteract() {
		return master != null ? master.canRiderInteract() : super.canRiderInteract();
	}
		return super.canRiderInteract();
	}
	public boolean shouldDismountInWater(Entity entity) {
		return master != null ? master.shouldDismountInWater(entity) : super.shouldDismountInWater(entity);
	}
		return super.shouldDismountInWater((Entity) entity);
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
	public String superGetClientBrand() {
		return null;
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
	public boolean superCanCommandSenderUseCommand(int par1, String par2Str) {
		return false;
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
	public void superFall(float par1) {
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
	public Object[] superGetLastActiveItems() {
		return null;
	}
	public boolean superGetHideCape() {
		return false;
	}
	public String superGetTranslatedEntityName() {
		return null;
	}
	public void superUpdateFallState(double par1, boolean par3) {
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
	public void superSetPositionAndRotationDirect(double par1, double par3, double par5, float par7, float par8, int par9) {
	}
	public Object superGetPosition(float par1) {
		return null;
	}
	public void superPlayStepSound(int par1, int par2, int par3, int par4) {
	}
	public boolean superHandleLavaMovement() {
		return false;
	}
	public boolean superIsInRangeToRenderVec3D(Object vec3) {
		return false;
	}
	public float superGetShadowSize() {
		return 0.0F;
	}
	public Object superDropItem(int par1, int par2) {
		return null;
	}
	public Object superDropItemWithOffset(int par1, int par2, float par3) {
		return null;
	}
	public boolean superIsEntityInvulnerable() {
		return false;
	}
	public void superCopyDataFrom(Object entity, boolean par2) {
	}
	public float superGetBlockExplosionResistance(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return 0.0F;
	}
	public boolean superShouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7) {
		return false;
	}
	public int superGetMaxSafePointTries() {
		return -1;
	}
	public void superCloseScreenNoPacket() {
	}
	public void superFunc_146100_a(Object tileEntity) {
	}
	public void superFunc_146095_a(Object commandBlockBaseLogic) {
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
	public void superFunc_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Object block) {
	}
	public Object superFropItemWithOffset(Object item, int p_145778_2_, float p_145778_3_) {
		return null;
	}
	public float superFunc_145772_a(Object explosion, Object world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Object block) {
		return 0.0F;
	}
	public boolean superFunc_145774_a(Object explosion, Object world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Object block, float p_145774_7_) {
		return false;
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
	public void superUpdateCloak() {
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
	public String superGetTexture() {
		return null;
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
	public void superSetNoAI(boolean par1) {
	}
	public void superFunc_96120_a(int par1, float par2) {
	}
	public void superSetCanPickUpLoot(boolean par1) {
	}
	public boolean superIsNoDespawnRequired() {
		return false;
	}
	public boolean superAddNotRiddenEntityID(Object nBTTagCompound) {
		return false;
	}
	public boolean superAddEntityID(Object nBTTagCompound) {
		return false;
	}
	public boolean superInteract(Object entityPlayer) {
		return false;
	}
	public void superUnmountEntity(Object entity) {
	}
	public float superFunc_82146_a(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return 0;
	}
	public boolean superFunc_96091_a(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7) {
		return false;
	}