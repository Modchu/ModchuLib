package modchu.lib.forge.mc180;

import java.util.Collection;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import com.mojang.authlib.GameProfile;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityOtherPlayerMPMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.CommandResultStats.Type;
import net.minecraft.command.server.CommandBlockLogic;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.event.HoverEvent;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.Team;
import net.minecraft.stats.StatBase;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.CombatTracker;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.FoodStats;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.LockCode;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings.GameType;
import net.minecraftforge.common.IExtendedEntityProperties;

public class Modchu_EntityOtherPlayerMPB extends EntityOtherPlayerMP {
	public Modchu_IEntityOtherPlayerMPMaster master;

	public Modchu_EntityOtherPlayerMPB(HashMap<String, Object> map) {
		super((World) map.get("Object"), (GameProfile) map.get("Object1"));
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.lDebug("Modchu_EntityOtherPlayerMP init instance="+instance);
		master = instance != null && instance instanceof Modchu_IEntityOtherPlayerMPMaster ? (Modchu_IEntityOtherPlayerMPMaster) instance : null;
		if (master != null) ;
		else Modchu_Debug.lDebug("Modchu_EntityOtherPlayerMP init master == null !!");
	}

	@Override
	public boolean attackEntityFrom(DamageSource damageSource, float amount) {
		return master != null ? master.attackEntityFrom(damageSource, amount) : super.attackEntityFrom(damageSource, amount);
	}

	public boolean superAttackEntityFrom(Object damageSource, float amount) {
		return super.attackEntityFrom((DamageSource) damageSource, amount);
	}

	@Override
	public void func_180426_a(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
		if (master != null) master.setPositionAndRotation2(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_, p_180426_10_);
		else super.func_180426_a(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_, p_180426_10_);
	}

	public void superSetPositionAndRotation2(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
		super.func_180426_a(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_, p_180426_10_);
	}

	@Override
	public void onUpdate() {
		if (master != null) master.onUpdate();
		else super.onUpdate();
	}

	public void superOnUpdate() {
		super.onUpdate();
	}

	@Override
	public void onLivingUpdate() {
		if (master != null) master.onLivingUpdate();
		else super.onLivingUpdate();
	}

	public void superOnLivingUpdate() {
		super.onLivingUpdate();
	}

	@Override
	public void setCurrentItemOrArmor(int slotIn, ItemStack itemStack) {
		if (master != null) master.setCurrentItemOrArmor(slotIn, itemStack);
		else super.setCurrentItemOrArmor(slotIn, itemStack);
	}

	public void superSetCurrentItemOrArmor(int slotIn, Object itemStack) {
		super.setCurrentItemOrArmor(slotIn, (ItemStack) itemStack);
	}

	@Override
	public void addChatMessage(IChatComponent iChatComponent) {
		if (master != null) master.addChatMessage(iChatComponent);
		else super.addChatMessage(iChatComponent);
	}

	public void superAddChatMessage(Object iChatComponent) {
		super.addChatMessage((IChatComponent) iChatComponent);
	}

	@Override
	public boolean canUseCommand(int permLevel, String commandName) {
		return master != null ? master.canCommandSenderUseCommand(permLevel, commandName) : super.canUseCommand(permLevel, commandName);
	}

	public boolean superCanCommandSenderUseCommand(int permLevel, String commandName) {
		return super.canUseCommand(permLevel, commandName);
	}

	@Override
	public BlockPos getPosition() {
		return (BlockPos) (master != null ? master.getPosition() : super.getPosition());
	}

	public BlockPos superGetPosition() {
		return super.getPosition();
	}

	@Override
	public boolean isSpectator() {
		return master != null ? master.isSpectator() : super.isSpectator();
	}

	public boolean superIsSpectator() {
		return super.isSpectator();
	}

	@Override
	public boolean hasPlayerInfo() {
		return master != null ? master.hasPlayerInfo() : super.hasPlayerInfo();
	}

	public boolean superHasPlayerInfo() {
		return super.hasPlayerInfo();
	}

	@Override
	protected NetworkPlayerInfo getPlayerInfo() {
		return (NetworkPlayerInfo) (master != null ? master.getPlayerInfo() : super.getPlayerInfo());
	}

	public NetworkPlayerInfo superGetPlayerInfo() {
		return super.getPlayerInfo();
	}

	@Override
	public boolean hasSkin() {
		return master != null ? master.hasSkin() : super.hasSkin();
	}

	public boolean superHasSkin() {
		return super.hasSkin();
	}

	@Override
	public ResourceLocation getLocationSkin() {
		return (ResourceLocation) (master != null ? master.getLocationSkin() : super.getLocationSkin());
	}

	public ResourceLocation superGetLocationSkin() {
		return super.getLocationSkin();
	}

	@Override
	public ResourceLocation getLocationCape() {
		return (ResourceLocation) (master != null ? master.getLocationCape() : super.getLocationCape());
	}

	public ResourceLocation superGetLocationCape() {
		return super.getLocationCape();
	}

	@Override
	public String getSkinType() {
		return master != null ? master.getSkinType() : super.getSkinType();
	}

	public String superGetSkinType() {
		return super.getSkinType();
	}

	@Override
	public float getFovModifier() {
		return master != null ? master.getFovModifier() : super.getFovModifier();
	}

	public float superGetFovModifier() {
		return super.getFovModifier();
	}

	@Override
	protected void applyEntityAttributes() {
		if (master != null) master.applyEntityAttributes();
		else super.applyEntityAttributes();
	}

	public void superApplyEntityAttributes() {
		super.applyEntityAttributes();
	}

	@Override
	protected void entityInit() {
		if (master != null) master.entityInit();
		else super.entityInit();
	}

	public void superEntityInit() {
		super.entityInit();
	}

	@Override
	public ItemStack getItemInUse() {
		return (ItemStack) (master != null ? master.getItemInUse() : super.getItemInUse());
	}

	public ItemStack superGetItemInUse() {
		return super.getItemInUse();
	}

	@Override
	public int getItemInUseCount() {
		return master != null ? master.getItemInUseCount() : super.getItemInUseCount();
	}

	public int superGetItemInUseCount() {
		return super.getItemInUseCount();
	}

	@Override
	public boolean isUsingItem() {
		return master != null ? master.isUsingItem() : super.isUsingItem();
	}

	public boolean superIsUsingItem() {
		return super.isUsingItem();
	}

	@Override
	public int getItemInUseDuration() {
		return master != null ? master.getItemInUseDuration() : super.getItemInUseDuration();
	}

	public int superGetItemInUseDuration() {
		return super.getItemInUseDuration();
	}

	@Override
	public void stopUsingItem() {
		if (master != null) master.stopUsingItem();
		else super.stopUsingItem();
	}

	public void superStopUsingItem() {
		super.stopUsingItem();
	}

	@Override
	public void clearItemInUse() {
		if (master != null) master.clearItemInUse();
		else super.clearItemInUse();
	}

	public void superClearItemInUse() {
		super.clearItemInUse();
	}

	@Override
	public boolean isBlocking() {
		return master != null ? master.isBlocking() : super.isBlocking();
	}

	public boolean superIsBlocking() {
		return super.isBlocking();
	}

	@Override
	public int getMaxInPortalTime() {
		return master != null ? master.getMaxInPortalTime() : super.getMaxInPortalTime();
	}

	public int superGetMaxInPortalTime() {
		return super.getMaxInPortalTime();
	}

	@Override
	protected String getSwimSound() {
		return master != null ? master.getSwimSound() : super.getSwimSound();
	}

	public String superGetSwimSound() {
		return super.getSwimSound();
	}

	@Override
	protected String getSplashSound() {
		return master != null ? master.getSplashSound() : super.getSplashSound();
	}

	public String superGetSplashSound() {
		return super.getSplashSound();
	}

	@Override
	public int getPortalCooldown() {
		return master != null ? master.getPortalCooldown() : super.getPortalCooldown();
	}

	public int superGetPortalCooldown() {
		return super.getPortalCooldown();
	}

	@Override
	public void playSound(String name, float volume, float pitch) {
		if (master != null) master.playSound(name, volume, pitch);
		else super.playSound(name, volume, pitch);
	}

	public void superPlaySound(String name, float volume, float pitch) {
		super.playSound(name, volume, pitch);
	}

	@Override
	protected void updateItemUse(ItemStack itemStack, int p_71010_2_) {
		if (master != null) master.updateItemUse(itemStack, p_71010_2_);
		else super.updateItemUse(itemStack, p_71010_2_);
	}

	public void superUpdateItemUse(Object itemStack, int p_71010_2_) {
		super.updateItemUse((ItemStack) itemStack, p_71010_2_);
	}

	@Override
	protected void onItemUseFinish() {
		if (master != null) master.onItemUseFinish();
		else super.onItemUseFinish();
	}

	public void superOnItemUseFinish() {
		super.onItemUseFinish();
	}

	@Override
	public void handleHealthUpdate(byte p_70103_1_) {
		if (master != null) master.handleStatusUpdate(p_70103_1_);
		else super.handleHealthUpdate(p_70103_1_);
	}

	public void superHandleStatusUpdate(byte p_70103_1_) {
		super.handleHealthUpdate(p_70103_1_);
	}

	@Override
	protected boolean isMovementBlocked() {
		return master != null ? master.isMovementBlocked() : super.isMovementBlocked();
	}

	public boolean superIsMovementBlocked() {
		return super.isMovementBlocked();
	}

	@Override
	public void closeScreen() {
		if (master != null) master.closeScreen();
		else super.closeScreen();
	}

	public void superCloseScreen() {
		super.closeScreen();
	}

	@Override
	public void updateRidden() {
		if (master != null) master.updateRidden();
		else super.updateRidden();
	}

	public void superUpdateRidden() {
		super.updateRidden();
	}

	@Override
	public void preparePlayerToSpawn() {
		if (master != null) master.preparePlayerToSpawn();
		else super.preparePlayerToSpawn();
	}

	public void superPreparePlayerToSpawn() {
		super.preparePlayerToSpawn();
	}

	@Override
	protected void updateEntityActionState() {
		if (master != null) master.updateEntityActionState();
		else super.updateEntityActionState();
	}

	public void superUpdateEntityActionState() {
		super.updateEntityActionState();
	}

	@Override
	public int getScore() {
		return master != null ? master.getScore() : super.getScore();
	}

	public int superGetScore() {
		return super.getScore();
	}

	@Override
	public void setScore(int p_85040_1_) {
		if (master != null) master.setScore(p_85040_1_);
		else super.setScore(p_85040_1_);
	}

	public void superSetScore(int p_85040_1_) {
		super.setScore(p_85040_1_);
	}

	@Override
	public void addScore(int p_85039_1_) {
		if (master != null) master.addScore(p_85039_1_);
		else super.addScore(p_85039_1_);
	}

	public void superAddScore(int p_85039_1_) {
		super.addScore(p_85039_1_);
	}

	@Override
	public void onDeath(DamageSource damageSource) {
		if (master != null) master.onDeath(damageSource);
		else super.onDeath(damageSource);
	}

	public void superOnDeath(Object damageSource) {
		super.onDeath((DamageSource) damageSource);
	}

	@Override
	protected String getHurtSound() {
		return master != null ? master.getHurtSound() : super.getHurtSound();
	}

	public String superGetHurtSound() {
		return super.getHurtSound();
	}

	@Override
	protected String getDeathSound() {
		return master != null ? master.getDeathSound() : super.getDeathSound();
	}

	public String superGetDeathSound() {
		return super.getDeathSound();
	}

	@Override
	public void addToPlayerScore(Entity entity, int amount) {
		if (master != null) master.addToPlayerScore(entity, amount);
		else super.addToPlayerScore(entity, amount);
	}

	public void superAddToPlayerScore(Object entity, int amount) {
		super.addToPlayerScore((Entity) entity, amount);
	}

	@Override
	public EntityItem dropOneItem(boolean p_71040_1_) {
		return (EntityItem) (master != null ? master.dropOneItem(p_71040_1_) : super.dropOneItem(p_71040_1_));
	}

	public EntityItem superDropOneItem(boolean p_71040_1_) {
		return super.dropOneItem(p_71040_1_);
	}

	@Override
	public EntityItem dropPlayerItemWithRandomChoice(ItemStack itemStack, boolean unused) {
		return (EntityItem) (master != null ? master.dropPlayerItemWithRandomChoice(itemStack, unused) : super.dropPlayerItemWithRandomChoice(itemStack, unused));
	}

	public EntityItem superDropPlayerItemWithRandomChoice(Object itemStack, boolean unused) {
		return super.dropPlayerItemWithRandomChoice((ItemStack) itemStack, unused);
	}

	@Override
	public EntityItem dropItem(ItemStack itemStack, boolean dropAround, boolean traceItem) {
		return (EntityItem) (master != null ? master.dropItem(itemStack, dropAround, traceItem) : super.dropItem(itemStack, dropAround, traceItem));
	}

	public EntityItem superDropItem(Object itemStack, boolean dropAround, boolean traceItem) {
		return super.dropItem((ItemStack) itemStack, dropAround, traceItem);
	}

	@Override
	public void joinEntityItemWithWorld(EntityItem entityItem) {
		if (master != null) master.joinEntityItemWithWorld(entityItem);
		else super.joinEntityItemWithWorld(entityItem);
	}

	public void superJoinEntityItemWithWorld(Object entityItem) {
		super.joinEntityItemWithWorld((EntityItem) entityItem);
	}

	@Override
	public float getToolDigEfficiency(Block block) {
		return master != null ? master.getToolDigEfficiency(block) : super.getToolDigEfficiency(block);
	}

	public float superGetToolDigEfficiency(Object block) {
		return super.getToolDigEfficiency((Block) block);
	}

	@Override
	public float getBreakSpeed(IBlockState iBlockState, BlockPos blockPos) {
		return master != null ? master.getBreakSpeed(iBlockState, blockPos) : super.getBreakSpeed(iBlockState, blockPos);
	}

	public float superGetBreakSpeed(Object iBlockState, Object blockPos) {
		return super.getBreakSpeed((IBlockState) iBlockState, (BlockPos) blockPos);
	}

	@Override
	public boolean canHarvestBlock(Block block) {
		return master != null ? master.canHarvestBlock(block) : super.canHarvestBlock(block);
	}

	public boolean superCanHarvestBlock(Object block) {
		return super.canHarvestBlock((Block) block);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.readEntityFromNBT(nBTTagCompound);
		else super.readEntityFromNBT(nBTTagCompound);
	}

	public void superReadEntityFromNBT(Object nBTTagCompound) {
		super.readEntityFromNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.writeEntityToNBT(nBTTagCompound);
		else super.writeEntityToNBT(nBTTagCompound);
	}

	public void superWriteEntityToNBT(Object nBTTagCompound) {
		super.writeEntityToNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public boolean canAttackPlayer(EntityPlayer entityPlayer) {
		return master != null ? master.canAttackPlayer(entityPlayer) : super.canAttackPlayer(entityPlayer);
	}

	public boolean superCanAttackPlayer(Object entityPlayer) {
		return super.canAttackPlayer((EntityPlayer) entityPlayer);
	}

	@Override
	protected void damageArmor(float p_70675_1_) {
		if (master != null) master.damageArmor(p_70675_1_);
		else super.damageArmor(p_70675_1_);
	}

	public void superDamageArmor(float p_70675_1_) {
		super.damageArmor(p_70675_1_);
	}

	@Override
	public int getTotalArmorValue() {
		return master != null ? master.getTotalArmorValue() : super.getTotalArmorValue();
	}

	public int superGetTotalArmorValue() {
		return super.getTotalArmorValue();
	}

	@Override
	public float getArmorVisibility() {
		return master != null ? master.getArmorVisibility() : super.getArmorVisibility();
	}

	public float superGetArmorVisibility() {
		return super.getArmorVisibility();
	}

	@Override
	protected void damageEntity(DamageSource damageSource, float damageAmount) {
		if (master != null) master.damageEntity(damageSource, damageAmount);
		else super.damageEntity(damageSource, damageAmount);
	}

	public void superDamageEntity(Object damageSource, float damageAmount) {
		super.damageEntity((DamageSource) damageSource, damageAmount);
	}

	@Override
	public void openEditSign(TileEntitySign tileEntitySign) {
		if (master != null) master.openEditSign(tileEntitySign);
		else super.openEditSign(tileEntitySign);
	}

	public void superOpenEditSign(Object tileEntitySign) {
		super.openEditSign((TileEntitySign) tileEntitySign);
	}

	@Override
	public void openEditCommandBlock(CommandBlockLogic commandBlockLogic) {
		if (master != null) master.openEditCommandBlock(commandBlockLogic);
		else super.openEditCommandBlock(commandBlockLogic);
	}

	public void superOpenEditCommandBlock(Object commandBlockLogic) {
		super.openEditCommandBlock((CommandBlockLogic) commandBlockLogic);
	}

	@Override
	public void displayVillagerTradeGui(IMerchant iMerchant) {
		if (master != null) master.displayVillagerTradeGui(iMerchant);
		else super.displayVillagerTradeGui(iMerchant);
	}

	public void superDisplayVillagerTradeGui(Object iMerchant) {
		super.displayVillagerTradeGui((IMerchant) iMerchant);
	}

	@Override
	public void displayGUIChest(IInventory iInventory) {
		if (master != null) master.displayGUIChest(iInventory);
		else super.displayGUIChest(iInventory);
	}

	public void superDisplayGUIChest(Object iInventory) {
		super.displayGUIChest((IInventory) iInventory);
	}

	@Override
	public void displayGUIHorse(EntityHorse entityHorse, IInventory iInventory) {
		if (master != null) master.displayGUIHorse(entityHorse, iInventory);
		else super.displayGUIHorse(entityHorse, iInventory);
	}

	public void superDisplayGUIHorse(Object entityHorse, Object iInventory) {
		super.displayGUIHorse((EntityHorse) entityHorse, (IInventory) iInventory);
	}

	@Override
	public void displayGui(IInteractionObject iInteractionObject) {
		if (master != null) master.displayGui(iInteractionObject);
		else super.displayGui(iInteractionObject);
	}

	public void superDisplayGui(Object iInteractionObject) {
		super.displayGui((IInteractionObject) iInteractionObject);
	}

	@Override
	public void displayGUIBook(ItemStack itemStack) {
		if (master != null) master.displayGUIBook(itemStack);
		else super.displayGUIBook(itemStack);
	}

	public void superDisplayGUIBook(Object itemStack) {
		super.displayGUIBook((ItemStack) itemStack);
	}

	@Override
	public boolean interactWith(Entity entity) {
		return master != null ? master.interactWith(entity) : super.interactWith(entity);
	}

	public boolean superInteractWith(Object entity) {
		return super.interactWith((Entity) entity);
	}

	@Override
	public ItemStack getCurrentEquippedItem() {
		return (ItemStack) (master != null ? master.getCurrentEquippedItem() : super.getCurrentEquippedItem());
	}

	public ItemStack superGetCurrentEquippedItem() {
		return super.getCurrentEquippedItem();
	}

	@Override
	public void destroyCurrentEquippedItem() {
		if (master != null) master.destroyCurrentEquippedItem();
		else super.destroyCurrentEquippedItem();
	}

	public void superDestroyCurrentEquippedItem() {
		super.destroyCurrentEquippedItem();
	}

	@Override
	public double getYOffset() {
		return master != null ? master.getYOffset() : super.getYOffset();
	}

	public double superGetYOffset() {
		return super.getYOffset();
	}

	@Override
	public void attackTargetEntityWithCurrentItem(Entity entity) {
		if (master != null) master.attackTargetEntityWithCurrentItem(entity);
		else super.attackTargetEntityWithCurrentItem(entity);
	}

	public void superAttackTargetEntityWithCurrentItem(Object entity) {
		super.attackTargetEntityWithCurrentItem((Entity) entity);
	}

	@Override
	public void onCriticalHit(Entity entity) {
		if (master != null) master.onCriticalHit(entity);
		else super.onCriticalHit(entity);
	}

	public void superOnCriticalHit(Object entity) {
		super.onCriticalHit((Entity) entity);
	}

	@Override
	public void onEnchantmentCritical(Entity entity) {
		if (master != null) master.onEnchantmentCritical(entity);
		else super.onEnchantmentCritical(entity);
	}

	public void superOnEnchantmentCritical(Object entity) {
		super.onEnchantmentCritical((Entity) entity);
	}

	@Override
	public void respawnPlayer() {
		if (master != null) master.respawnPlayer();
		else super.respawnPlayer();
	}

	public void superRespawnPlayer() {
		super.respawnPlayer();
	}

	@Override
	public void setDead() {
		if (master != null) master.setDead();
		else super.setDead();
	}

	public void superSetDead() {
		super.setDead();
	}

	@Override
	public boolean isEntityInsideOpaqueBlock() {
		return master != null ? master.isEntityInsideOpaqueBlock() : super.isEntityInsideOpaqueBlock();
	}

	public boolean superIsEntityInsideOpaqueBlock() {
		return super.isEntityInsideOpaqueBlock();
	}

	@Override
	public boolean isUser() {
		return master != null ? master.isUser() : super.isUser();
	}

	public boolean superIsUser() {
		return super.isUser();
	}

	@Override
	public GameProfile getGameProfile() {
		return (GameProfile) (master != null ? master.getGameProfile() : super.getGameProfile());
	}

	public GameProfile superGetGameProfile() {
		return super.getGameProfile();
	}

	@Override
	public EnumStatus trySleep(BlockPos blockPos) {
		return (EnumStatus) (master != null ? master.trySleep(blockPos) : super.trySleep(blockPos));
	}

	public EnumStatus superTrySleep(Object blockPos) {
		return super.trySleep((BlockPos) blockPos);
	}

	@Override
	public void wakeUpPlayer(boolean p_70999_1_, boolean updateWorldFlag, boolean setSpawn) {
		if (master != null) master.wakeUpPlayer(p_70999_1_, updateWorldFlag, setSpawn);
		else super.wakeUpPlayer(p_70999_1_, updateWorldFlag, setSpawn);
	}

	public void superWakeUpPlayer(boolean p_70999_1_, boolean updateWorldFlag, boolean setSpawn) {
		super.wakeUpPlayer(p_70999_1_, updateWorldFlag, setSpawn);
	}

	@Override
	public float getBedOrientationInDegrees() {
		return master != null ? master.getBedOrientationInDegrees() : super.getBedOrientationInDegrees();
	}

	public float superGetBedOrientationInDegrees() {
		return super.getBedOrientationInDegrees();
	}

	@Override
	public boolean isPlayerSleeping() {
		return master != null ? master.isPlayerSleeping() : super.isPlayerSleeping();
	}

	public boolean superIsPlayerSleeping() {
		return super.isPlayerSleeping();
	}

	@Override
	public boolean isPlayerFullyAsleep() {
		return master != null ? master.isPlayerFullyAsleep() : super.isPlayerFullyAsleep();
	}

	public boolean superIsPlayerFullyAsleep() {
		return super.isPlayerFullyAsleep();
	}

	@Override
	public int getSleepTimer() {
		return master != null ? master.getSleepTimer() : super.getSleepTimer();
	}

	public int superGetSleepTimer() {
		return super.getSleepTimer();
	}

	@Override
	public void addChatComponentMessage(IChatComponent iChatComponent) {
		if (master != null) master.addChatComponentMessage(iChatComponent);
		else super.addChatComponentMessage(iChatComponent);
	}

	public void superAddChatComponentMessage(Object iChatComponent) {
		super.addChatComponentMessage((IChatComponent) iChatComponent);
	}

	@Override
	public BlockPos getBedLocation() {
		return (BlockPos) (master != null ? master.getBedLocation() : super.getBedLocation());
	}

	public BlockPos superGetBedLocation() {
		return super.getBedLocation();
	}

	@Override
	public boolean isSpawnForced() {
		return master != null ? master.isSpawnForced() : super.isSpawnForced();
	}

	public boolean superIsSpawnForced() {
		return super.isSpawnForced();
	}

	@Override
	public void setSpawnPoint(BlockPos blockPos, boolean forced) {
		if (master != null) master.setSpawnPoint(blockPos, forced);
		else super.setSpawnPoint(blockPos, forced);
	}

	public void superSetSpawnPoint(Object blockPos, boolean forced) {
		super.setSpawnPoint((BlockPos) blockPos, forced);
	}

	@Override
	public void triggerAchievement(StatBase statBase) {
		if (master != null) master.triggerAchievement(statBase);
		else super.triggerAchievement(statBase);
	}

	public void superTriggerAchievement(Object statBase) {
		super.triggerAchievement((StatBase) statBase);
	}

	@Override
	public void addStat(StatBase statBase, int amount) {
		if (master != null) master.addStat(statBase, amount);
		else super.addStat(statBase, amount);
	}

	public void superAddStat(Object statBase, int amount) {
		super.addStat((StatBase) statBase, amount);
	}

	@Override
	public void func_175145_a(StatBase statBase) {
		if (master != null) master.func_175145_a(statBase);
		else super.func_175145_a(statBase);
	}

	public void superFunc_175145_a(Object statBase) {
		super.func_175145_a((StatBase) statBase);
	}

	@Override
	public void jump() {
		if (master != null) master.jump();
		else super.jump();
	}

	public void superJump() {
		super.jump();
	}

	@Override
	public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_) {
		if (master != null) master.moveEntityWithHeading(p_70612_1_, p_70612_2_);
		else super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
	}

	public void superMoveEntityWithHeading(float p_70612_1_, float p_70612_2_) {
		super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
	}

	@Override
	public float getAIMoveSpeed() {
		return master != null ? master.getAIMoveSpeed() : super.getAIMoveSpeed();
	}

	public float superGetAIMoveSpeed() {
		return super.getAIMoveSpeed();
	}

	@Override
	public void addMovementStat(double p_71000_1_, double p_71000_3_, double p_71000_5_) {
		if (master != null) master.addMovementStat(p_71000_1_, p_71000_3_, p_71000_5_);
		else super.addMovementStat(p_71000_1_, p_71000_3_, p_71000_5_);
	}

	public void superAddMovementStat(double p_71000_1_, double p_71000_3_, double p_71000_5_) {
		super.addMovementStat(p_71000_1_, p_71000_3_, p_71000_5_);
	}

	@Override
	public void fall(float distance, float damageMultiplier) {
		if (master != null) master.fall(distance, damageMultiplier);
		else super.fall(distance, damageMultiplier);
	}

	public void superFall(float distance, float damageMultiplier) {
		super.fall(distance, damageMultiplier);
	}

	@Override
	protected void resetHeight() {
		if (master != null) master.resetHeight();
		else super.resetHeight();
	}

	public void superResetHeight() {
		super.resetHeight();
	}

	@Override
	protected String getFallSoundString(int damageValue) {
		return master != null ? master.getFallSoundString(damageValue) : super.getFallSoundString(damageValue);
	}

	public String superGetFallSoundString(int damageValue) {
		return super.getFallSoundString(damageValue);
	}

	@Override
	public void onKillEntity(EntityLivingBase entityLivingBase) {
		if (master != null) master.onKillEntity(entityLivingBase);
		else super.onKillEntity(entityLivingBase);
	}

	public void superOnKillEntity(Object entityLivingBase) {
		super.onKillEntity((EntityLivingBase) entityLivingBase);
	}

	@Override
	public void setInWeb() {
		if (master != null) master.setInWeb();
		else super.setInWeb();
	}

	public void superSetInWeb() {
		super.setInWeb();
	}

	@Override
	public ItemStack getCurrentArmor(int slotIn) {
		return (ItemStack) (master != null ? master.getCurrentArmor(slotIn) : super.getCurrentArmor(slotIn));
	}

	public ItemStack superGetCurrentArmor(int slotIn) {
		return super.getCurrentArmor(slotIn);
	}

	@Override
	public void addExperience(int amount) {
		if (master != null) master.addExperience(amount);
		else super.addExperience(amount);
	}

	public void superAddExperience(int amount) {
		super.addExperience(amount);
	}

	@Override
	public int getXPSeed() {
		return master != null ? master.getXPSeed() : super.getXPSeed();
	}

	public int superGetXPSeed() {
		return super.getXPSeed();
	}

	@Override
	public void removeExperienceLevel(int levels) {
		if (master != null) master.removeExperienceLevel(levels);
		else super.removeExperienceLevel(levels);
	}

	public void superRemoveExperienceLevel(int levels) {
		super.removeExperienceLevel(levels);
	}

	@Override
	public void addExperienceLevel(int levels) {
		if (master != null) master.addExperienceLevel(levels);
		else super.addExperienceLevel(levels);
	}

	public void superAddExperienceLevel(int levels) {
		super.addExperienceLevel(levels);
	}

	@Override
	public int xpBarCap() {
		return master != null ? master.xpBarCap() : super.xpBarCap();
	}

	public int superXpBarCap() {
		return super.xpBarCap();
	}

	@Override
	public void addExhaustion(float p_71020_1_) {
		if (master != null) master.addExhaustion(p_71020_1_);
		else super.addExhaustion(p_71020_1_);
	}

	public void superAddExhaustion(float p_71020_1_) {
		super.addExhaustion(p_71020_1_);
	}

	@Override
	public FoodStats getFoodStats() {
		return (FoodStats) (master != null ? master.getFoodStats() : super.getFoodStats());
	}

	public FoodStats superGetFoodStats() {
		return super.getFoodStats();
	}

	@Override
	public boolean canEat(boolean ignoreHunger) {
		return master != null ? master.canEat(ignoreHunger) : super.canEat(ignoreHunger);
	}

	public boolean superCanEat(boolean ignoreHunger) {
		return super.canEat(ignoreHunger);
	}

	@Override
	public boolean shouldHeal() {
		return master != null ? master.shouldHeal() : super.shouldHeal();
	}

	public boolean superShouldHeal() {
		return super.shouldHeal();
	}

	@Override
	public void setItemInUse(ItemStack itemStack, int duration) {
		if (master != null) master.setItemInUse(itemStack, duration);
		else super.setItemInUse(itemStack, duration);
	}

	public void superSetItemInUse(Object itemStack, int duration) {
		super.setItemInUse((ItemStack) itemStack, duration);
	}

	@Override
	public boolean isAllowEdit() {
		return master != null ? master.isAllowEdit() : super.isAllowEdit();
	}

	public boolean superIsAllowEdit() {
		return super.isAllowEdit();
	}

	@Override
	public boolean canPlayerEdit(BlockPos blockPos, EnumFacing enumFacing, ItemStack itemStack) {
		return master != null ? master.canPlayerEdit(blockPos, enumFacing, itemStack) : super.canPlayerEdit(blockPos, enumFacing, itemStack);
	}

	public boolean superCanPlayerEdit(Object blockPos, Object enumFacing, Object itemStack) {
		return super.canPlayerEdit((BlockPos) blockPos, (EnumFacing) enumFacing, (ItemStack) itemStack);
	}

	@Override
	protected int getExperiencePoints(EntityPlayer entityPlayer) {
		return master != null ? master.getExperiencePoints(entityPlayer) : super.getExperiencePoints(entityPlayer);
	}

	public int superGetExperiencePoints(Object entityPlayer) {
		return super.getExperiencePoints((EntityPlayer) entityPlayer);
	}

	@Override
	protected boolean isPlayer() {
		return master != null ? master.isPlayer() : super.isPlayer();
	}

	public boolean superIsPlayer() {
		return super.isPlayer();
	}

	@Override
	public boolean getAlwaysRenderNameTagForRender() {
		return master != null ? master.getAlwaysRenderNameTagForRender() : super.getAlwaysRenderNameTagForRender();
	}

	public boolean superGetAlwaysRenderNameTagForRender() {
		return super.getAlwaysRenderNameTagForRender();
	}

	@Override
	public void clonePlayer(EntityPlayer entityPlayer, boolean respawnFromEnd) {
		if (master != null) master.clonePlayer(entityPlayer, respawnFromEnd);
		else super.clonePlayer(entityPlayer, respawnFromEnd);
	}

	public void superClonePlayer(Object entityPlayer, boolean respawnFromEnd) {
		super.clonePlayer((EntityPlayer) entityPlayer, respawnFromEnd);
	}

	@Override
	protected boolean canTriggerWalking() {
		return master != null ? master.canTriggerWalking() : super.canTriggerWalking();
	}

	public boolean superCanTriggerWalking() {
		return super.canTriggerWalking();
	}

	@Override
	public void sendPlayerAbilities() {
		if (master != null) master.sendPlayerAbilities();
		else super.sendPlayerAbilities();
	}

	public void superSendPlayerAbilities() {
		super.sendPlayerAbilities();
	}

	@Override
	public void setGameType(GameType gameType) {
		if (master != null) master.setGameType(gameType);
		else super.setGameType(gameType);
	}

	public void superSetGameType(Object gameType) {
		super.setGameType((GameType) gameType);
	}

	@Override
	public String getName() {
		return master != null ? master.getName() : super.getName();
	}

	public String superGetName() {
		return super.getName();
	}

	@Override
	public InventoryEnderChest getInventoryEnderChest() {
		return (InventoryEnderChest) (master != null ? master.getInventoryEnderChest() : super.getInventoryEnderChest());
	}

	public InventoryEnderChest superGetInventoryEnderChest() {
		return super.getInventoryEnderChest();
	}

	@Override
	public ItemStack getEquipmentInSlot(int slotIn) {
		return (ItemStack) (master != null ? master.getEquipmentInSlot(slotIn) : super.getEquipmentInSlot(slotIn));
	}

	public ItemStack superGetEquipmentInSlot(int slotIn) {
		return super.getEquipmentInSlot(slotIn);
	}

	@Override
	public ItemStack getHeldItem() {
		return (ItemStack) (master != null ? master.getHeldItem() : super.getHeldItem());
	}

	public ItemStack superGetHeldItem() {
		return super.getHeldItem();
	}

	@Override
	public boolean isInvisibleToPlayer(EntityPlayer entityPlayer) {
		return master != null ? master.isInvisibleToPlayer(entityPlayer) : super.isInvisibleToPlayer(entityPlayer);
	}

	public boolean superIsInvisibleToPlayer(Object entityPlayer) {
		return super.isInvisibleToPlayer((EntityPlayer) entityPlayer);
	}

	@Override
	public ItemStack[] getInventory() {
		return (ItemStack[]) (master != null ? master.getInventory() : super.getInventory());
	}

	public ItemStack[] superGetInventory() {
		return super.getInventory();
	}

	@Override
	public boolean isPushedByWater() {
		return master != null ? master.isPushedByWater() : super.isPushedByWater();
	}

	public boolean superIsPushedByWater() {
		return super.isPushedByWater();
	}

	@Override
	public Scoreboard getWorldScoreboard() {
		return (Scoreboard) (master != null ? master.getWorldScoreboard() : super.getWorldScoreboard());
	}

	public Scoreboard superGetWorldScoreboard() {
		return super.getWorldScoreboard();
	}

	@Override
	public Team getTeam() {
		return (Team) (master != null ? master.getTeam() : super.getTeam());
	}

	public Team superGetTeam() {
		return super.getTeam();
	}

	@Override
	public IChatComponent getDisplayName() {
		return (IChatComponent) (master != null ? master.getDisplayName() : super.getDisplayName());
	}

	public IChatComponent superGetDisplayName() {
		return super.getDisplayName();
	}

	@Override
	public float getEyeHeight() {
		return master != null ? master.getEyeHeight() : super.getEyeHeight();
	}

	public float superGetEyeHeight() {
		return super.getEyeHeight();
	}

	@Override
	public void setAbsorptionAmount(float amount) {
		if (master != null) master.setAbsorptionAmount(amount);
		else super.setAbsorptionAmount(amount);
	}

	public void superSetAbsorptionAmount(float amount) {
		super.setAbsorptionAmount(amount);
	}

	@Override
	public float getAbsorptionAmount() {
		return master != null ? master.getAbsorptionAmount() : super.getAbsorptionAmount();
	}

	public float superGetAbsorptionAmount() {
		return super.getAbsorptionAmount();
	}

	@Override
	public boolean canOpen(LockCode lockCode) {
		return master != null ? master.canOpen(lockCode) : super.canOpen(lockCode);
	}

	public boolean superCanOpen(Object lockCode) {
		return super.canOpen((LockCode) lockCode);
	}

	@Override
	public boolean func_175148_a(EnumPlayerModelParts enumPlayerModelParts) {
		return master != null ? master.isWearing(enumPlayerModelParts) : super.func_175148_a(enumPlayerModelParts);
	}

	public boolean superIsWearing(Object enumPlayerModelParts) {
		return super.func_175148_a((EnumPlayerModelParts) enumPlayerModelParts);
	}

	@Override
	public boolean sendCommandFeedback() {
		return master != null ? master.sendCommandFeedback() : super.sendCommandFeedback();
	}

	public boolean superSendCommandFeedback() {
		return super.sendCommandFeedback();
	}

	@Override
	public boolean replaceItemInInventory(int p_174820_1_, ItemStack itemStack) {
		return master != null ? master.replaceItemInInventory(p_174820_1_, itemStack) : super.replaceItemInInventory(p_174820_1_, itemStack);
	}

	public boolean superReplaceItemInInventory(int p_174820_1_, Object itemStack) {
		return super.replaceItemInInventory(p_174820_1_, (ItemStack) itemStack);
	}

	@Override
	public boolean hasReducedDebug() {
		return master != null ? master.hasReducedDebug() : super.hasReducedDebug();
	}

	public boolean superHasReducedDebug() {
		return super.hasReducedDebug();
	}

	@Override
	public void setReducedDebug(boolean reducedDebug) {
		if (master != null) master.setReducedDebug(reducedDebug);
		else super.setReducedDebug(reducedDebug);
	}

	public void superSetReducedDebug(boolean reducedDebug) {
		super.setReducedDebug(reducedDebug);
	}

	@Override
	public void openGui(Object mod, int modGuiId, World world, int x, int y, int z) {
		if (master != null) master.openGui(mod, modGuiId, world, x, y, z);
		else super.openGui(mod, modGuiId, world, x, y, z);
	}

	public void superOpenGui(Object mod, int modGuiId, Object world, int x, int y, int z) {
		super.openGui(mod, modGuiId, (World) world, x, y, z);
	}

	@Override
	public BlockPos getBedLocation(int dimension) {
		return (BlockPos) (master != null ? master.getBedLocation(dimension) : super.getBedLocation(dimension));
	}

	public BlockPos superGetBedLocation(int dimension) {
		return super.getBedLocation(dimension);
	}

	@Override
	public boolean isSpawnForced(int dimension) {
		return master != null ? master.isSpawnForced(dimension) : super.isSpawnForced(dimension);
	}

	public boolean superIsSpawnForced(int dimension) {
		return super.isSpawnForced(dimension);
	}

	@Override
	public void setSpawnChunk(BlockPos blockPos, boolean forced, int dimension) {
		if (master != null) master.setSpawnChunk(blockPos, forced, dimension);
		else super.setSpawnChunk(blockPos, forced, dimension);
	}

	public void superSetSpawnChunk(Object blockPos, boolean forced, int dimension) {
		super.setSpawnChunk((BlockPos) blockPos, forced, dimension);
	}

	@Override
	public float getDefaultEyeHeight() {
		return master != null ? master.getDefaultEyeHeight() : super.getDefaultEyeHeight();
	}

	public float superGetDefaultEyeHeight() {
		return super.getDefaultEyeHeight();
	}

	@Override
	public String getDisplayNameString() {
		return master != null ? master.getDisplayNameString() : super.getDisplayNameString();
	}

	public String superGetDisplayNameString() {
		return super.getDisplayNameString();
	}

	@Override
	public void refreshDisplayName() {
		if (master != null) master.refreshDisplayName();
		else super.refreshDisplayName();
	}

	public void superRefreshDisplayName() {
		super.refreshDisplayName();
	}

	@Override
	public void onKillCommand() {
		if (master != null) master.onKillCommand();
		else super.onKillCommand();
	}

	public void superOnKillCommand() {
		super.onKillCommand();
	}

	@Override
	protected void func_180433_a(double p_180433_1_, boolean p_180433_3_, Block block, BlockPos blockPos) {
		if (master != null) master.updateFallState(p_180433_1_, p_180433_3_, block, blockPos);
		else super.func_180433_a(p_180433_1_, p_180433_3_, block, blockPos);
	}

	public void superUpdateFallState(double p_180433_1_, boolean p_180433_3_, Object block, Object blockPos) {
		super.func_180433_a(p_180433_1_, p_180433_3_, (Block) block, (BlockPos) blockPos);
	}

	@Override
	public boolean canBreatheUnderwater() {
		return master != null ? master.canBreatheUnderwater() : super.canBreatheUnderwater();
	}

	public boolean superCanBreatheUnderwater() {
		return super.canBreatheUnderwater();
	}

	@Override
	public void onEntityUpdate() {
		if (master != null) master.onEntityUpdate();
		else super.onEntityUpdate();
	}

	public void superOnEntityUpdate() {
		super.onEntityUpdate();
	}

	@Override
	public boolean isChild() {
		return master != null ? master.isChild() : super.isChild();
	}

	public boolean superIsChild() {
		return super.isChild();
	}

	@Override
	protected void onDeathUpdate() {
		if (master != null) master.onDeathUpdate();
		else super.onDeathUpdate();
	}

	public void superOnDeathUpdate() {
		super.onDeathUpdate();
	}

	@Override
	protected boolean func_146066_aG() {
		return master != null ? master.canDropLoot() : super.func_146066_aG();
	}

	public boolean superCanDropLoot() {
		return super.func_146066_aG();
	}

	@Override
	protected int decreaseAirSupply(int p_70682_1_) {
		return master != null ? master.decreaseAirSupply(p_70682_1_) : super.decreaseAirSupply(p_70682_1_);
	}

	public int superDecreaseAirSupply(int p_70682_1_) {
		return super.decreaseAirSupply(p_70682_1_);
	}

	@Override
	public Random getRNG() {
		return master != null ? master.getRNG() : super.getRNG();
	}

	public Random superGetRNG() {
		return super.getRNG();
	}

	@Override
	public EntityLivingBase getAITarget() {
		return (EntityLivingBase) (master != null ? master.getAITarget() : super.getAITarget());
	}

	public EntityLivingBase superGetAITarget() {
		return super.getAITarget();
	}

	@Override
	public int getRevengeTimer() {
		return master != null ? master.getRevengeTimer() : super.getRevengeTimer();
	}

	public int superGetRevengeTimer() {
		return super.getRevengeTimer();
	}

	@Override
	public void setRevengeTarget(EntityLivingBase entityLivingBase) {
		if (master != null) master.setRevengeTarget(entityLivingBase);
		else super.setRevengeTarget(entityLivingBase);
	}

	public void superSetRevengeTarget(Object entityLivingBase) {
		super.setRevengeTarget((EntityLivingBase) entityLivingBase);
	}

	@Override
	public EntityLivingBase getLastAttacker() {
		return (EntityLivingBase) (master != null ? master.getLastAttacker() : super.getLastAttacker());
	}

	public EntityLivingBase superGetLastAttacker() {
		return super.getLastAttacker();
	}

	@Override
	public int getLastAttackerTime() {
		return master != null ? master.getLastAttackerTime() : super.getLastAttackerTime();
	}

	public int superGetLastAttackerTime() {
		return super.getLastAttackerTime();
	}

	@Override
	public void setLastAttacker(Entity entity) {
		if (master != null) master.setLastAttacker(entity);
		else super.setLastAttacker(entity);
	}

	public void superSetLastAttacker(Object entity) {
		super.setLastAttacker((Entity) entity);
	}

	@Override
	public int getAge() {
		return master != null ? master.getAge() : super.getAge();
	}

	public int superGetAge() {
		return super.getAge();
	}

	@Override
	protected void updatePotionEffects() {
		if (master != null) master.updatePotionEffects();
		else super.updatePotionEffects();
	}

	public void superUpdatePotionEffects() {
		super.updatePotionEffects();
	}

	@Override
	protected void func_175135_B() {
		if (master != null) master.updatePotionMetadata();
		else super.func_175135_B();
	}

	public void superUpdatePotionMetadata() {
		super.func_175135_B();
	}

	@Override
	protected void func_175133_bi() {
		if (master != null) master.resetPotionEffectMetadata();
		else super.func_175133_bi();
	}

	public void superResetPotionEffectMetadata() {
		super.func_175133_bi();
	}

	@Override
	public void clearActivePotions() {
		if (master != null) master.clearActivePotions();
		else super.clearActivePotions();
	}

	public void superClearActivePotions() {
		super.clearActivePotions();
	}

	@Override
	public Collection getActivePotionEffects() {
		return (Collection) (master != null ? master.getActivePotionEffects() : super.getActivePotionEffects());
	}

	public Collection superGetActivePotionEffects() {
		return super.getActivePotionEffects();
	}

	@Override
	public boolean isPotionActive(int p_82165_1_) {
		return master != null ? master.isPotionActive(p_82165_1_) : super.isPotionActive(p_82165_1_);
	}

	public boolean superIsPotionActive(int p_82165_1_) {
		return super.isPotionActive(p_82165_1_);
	}

	@Override
	public boolean isPotionActive(Potion potion) {
		return master != null ? master.isPotionActive(potion) : super.isPotionActive(potion);
	}

	public boolean superIsPotionActive(Object potion) {
		return super.isPotionActive((Potion) potion);
	}

	@Override
	public PotionEffect getActivePotionEffect(Potion potion) {
		return (PotionEffect) (master != null ? master.getActivePotionEffect(potion) : super.getActivePotionEffect(potion));
	}

	public PotionEffect superGetActivePotionEffect(Object potion) {
		return super.getActivePotionEffect((Potion) potion);
	}

	@Override
	public void addPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.addPotionEffect(potionEffect);
		else super.addPotionEffect(potionEffect);
	}

	public void superAddPotionEffect(Object potionEffect) {
		super.addPotionEffect((PotionEffect) potionEffect);
	}

	@Override
	public boolean isPotionApplicable(PotionEffect potionEffect) {
		return master != null ? master.isPotionApplicable(potionEffect) : super.isPotionApplicable(potionEffect);
	}

	public boolean superIsPotionApplicable(Object potionEffect) {
		return super.isPotionApplicable((PotionEffect) potionEffect);
	}

	@Override
	public boolean isEntityUndead() {
		return master != null ? master.isEntityUndead() : super.isEntityUndead();
	}

	public boolean superIsEntityUndead() {
		return super.isEntityUndead();
	}

	@Override
	public void removePotionEffectClient(int p_70618_1_) {
		if (master != null) master.removePotionEffectClient(p_70618_1_);
		else super.removePotionEffectClient(p_70618_1_);
	}

	public void superRemovePotionEffectClient(int p_70618_1_) {
		super.removePotionEffectClient(p_70618_1_);
	}

	@Override
	public void removePotionEffect(int p_82170_1_) {
		if (master != null) master.removePotionEffect(p_82170_1_);
		else super.removePotionEffect(p_82170_1_);
	}

	public void superRemovePotionEffect(int p_82170_1_) {
		super.removePotionEffect(p_82170_1_);
	}

	@Override
	protected void onNewPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.onNewPotionEffect(potionEffect);
		else super.onNewPotionEffect(potionEffect);
	}

	public void superOnNewPotionEffect(Object potionEffect) {
		super.onNewPotionEffect((PotionEffect) potionEffect);
	}

	@Override
	protected void onChangedPotionEffect(PotionEffect potionEffect, boolean p_70695_2_) {
		if (master != null) master.onChangedPotionEffect(potionEffect, p_70695_2_);
		else super.onChangedPotionEffect(potionEffect, p_70695_2_);
	}

	public void superOnChangedPotionEffect(Object potionEffect, boolean p_70695_2_) {
		super.onChangedPotionEffect((PotionEffect) potionEffect, p_70695_2_);
	}

	@Override
	protected void onFinishedPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.onFinishedPotionEffect(potionEffect);
		else super.onFinishedPotionEffect(potionEffect);
	}

	public void superOnFinishedPotionEffect(Object potionEffect) {
		super.onFinishedPotionEffect((PotionEffect) potionEffect);
	}

	@Override
	public void heal(float healAmount) {
		if (master != null) master.heal(healAmount);
		else super.heal(healAmount);
	}

	public void superHeal(float healAmount) {
		super.heal(healAmount);
	}

	@Override
	public void setHealth(float p_70606_1_) {
		if (master != null) master.setHealth(p_70606_1_);
		else super.setHealth(p_70606_1_);
	}

	public void superSetHealth(float p_70606_1_) {
		super.setHealth(p_70606_1_);
	}

	@Override
	public void renderBrokenItemStack(ItemStack itemStack) {
		if (master != null) master.renderBrokenItemStack(itemStack);
		else super.renderBrokenItemStack(itemStack);
	}

	public void superRenderBrokenItemStack(Object itemStack) {
		super.renderBrokenItemStack((ItemStack) itemStack);
	}

	@Override
	protected void dropEquipment(boolean p_82160_1_, int p_82160_2_) {
		if (master != null) master.dropEquipment(p_82160_1_, p_82160_2_);
		else super.dropEquipment(p_82160_1_, p_82160_2_);
	}

	public void superDropEquipment(boolean p_82160_1_, int p_82160_2_) {
		super.dropEquipment(p_82160_1_, p_82160_2_);
	}

	@Override
	public void knockBack(Entity entity, float p_70653_2_, double p_70653_3_, double p_70653_5_) {
		if (master != null) master.knockBack(entity, p_70653_2_, p_70653_3_, p_70653_5_);
		else super.knockBack(entity, p_70653_2_, p_70653_3_, p_70653_5_);
	}

	public void superKnockBack(Object entity, float p_70653_2_, double p_70653_3_, double p_70653_5_) {
		super.knockBack((Entity) entity, p_70653_2_, p_70653_3_, p_70653_5_);
	}

	@Override
	protected void addRandomArmor() {
		if (master != null) master.addRandomDrop();
		else super.addRandomArmor();
	}

	public void superAddRandomDrop() {
		super.addRandomArmor();
	}

	@Override
	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		if (master != null) master.dropFewItems(p_70628_1_, p_70628_2_);
		else super.dropFewItems(p_70628_1_, p_70628_2_);
	}

	public void superDropFewItems(boolean p_70628_1_, int p_70628_2_) {
		super.dropFewItems(p_70628_1_, p_70628_2_);
	}

	@Override
	public boolean isOnLadder() {
		return master != null ? master.isOnLadder() : super.isOnLadder();
	}

	public boolean superIsOnLadder() {
		return super.isOnLadder();
	}

	@Override
	public boolean isEntityAlive() {
		return master != null ? master.isEntityAlive() : super.isEntityAlive();
	}

	public boolean superIsEntityAlive() {
		return super.isEntityAlive();
	}

	@Override
	public void performHurtAnimation() {
		if (master != null) master.performHurtAnimation();
		else super.performHurtAnimation();
	}

	public void superPerformHurtAnimation() {
		super.performHurtAnimation();
	}

	@Override
	protected float applyArmorCalculations(DamageSource damageSource, float p_70655_2_) {
		return master != null ? master.applyArmorCalculations(damageSource, p_70655_2_) : super.applyArmorCalculations(damageSource, p_70655_2_);
	}

	public float superApplyArmorCalculations(Object damageSource, float p_70655_2_) {
		return super.applyArmorCalculations((DamageSource) damageSource, p_70655_2_);
	}

	@Override
	protected float applyPotionDamageCalculations(DamageSource damageSource, float p_70672_2_) {
		return master != null ? master.applyPotionDamageCalculations(damageSource, p_70672_2_) : super.applyPotionDamageCalculations(damageSource, p_70672_2_);
	}

	public float superApplyPotionDamageCalculations(Object damageSource, float p_70672_2_) {
		return super.applyPotionDamageCalculations((DamageSource) damageSource, p_70672_2_);
	}

	@Override
	public CombatTracker getCombatTracker() {
		return (CombatTracker) (master != null ? master.getCombatTracker() : super.getCombatTracker());
	}

	public CombatTracker superGetCombatTracker() {
		return super.getCombatTracker();
	}

	@Override
	public EntityLivingBase func_94060_bK() {
		return (EntityLivingBase) (master != null ? master.func_94060_bK() : super.func_94060_bK());
	}

	public EntityLivingBase superFunc_94060_bK() {
		return super.func_94060_bK();
	}

	@Override
	public void swingItem() {
		if (master != null) master.swingItem();
		else super.swingItem();
	}

	public void superSwingItem() {
		super.swingItem();
	}

	@Override
	protected void kill() {
		if (master != null) master.kill();
		else super.kill();
	}

	public void superKill() {
		super.kill();
	}

	@Override
	protected void updateArmSwingProgress() {
		if (master != null) master.updateArmSwingProgress();
		else super.updateArmSwingProgress();
	}

	public void superUpdateArmSwingProgress() {
		super.updateArmSwingProgress();
	}

	@Override
	public IAttributeInstance getEntityAttribute(IAttribute iAttribute) {
		return (IAttributeInstance) (master != null ? master.getEntityAttribute(iAttribute) : super.getEntityAttribute(iAttribute));
	}

	public IAttributeInstance superGetEntityAttribute(Object iAttribute) {
		return super.getEntityAttribute((IAttribute) iAttribute);
	}

	@Override
	public BaseAttributeMap getAttributeMap() {
		return (BaseAttributeMap) (master != null ? master.getAttributeMap() : super.getAttributeMap());
	}

	public BaseAttributeMap superGetAttributeMap() {
		return super.getAttributeMap();
	}

	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return (EnumCreatureAttribute) (master != null ? master.getCreatureAttribute() : super.getCreatureAttribute());
	}

	public EnumCreatureAttribute superGetCreatureAttribute() {
		return super.getCreatureAttribute();
	}

	@Override
	public void setSprinting(boolean sprinting) {
		if (master != null) master.setSprinting(sprinting);
		else super.setSprinting(sprinting);
	}

	public void superSetSprinting(boolean sprinting) {
		super.setSprinting(sprinting);
	}

	@Override
	protected float getSoundVolume() {
		return master != null ? master.getSoundVolume() : super.getSoundVolume();
	}

	public float superGetSoundVolume() {
		return super.getSoundVolume();
	}

	@Override
	protected float getSoundPitch() {
		return master != null ? master.getSoundPitch() : super.getSoundPitch();
	}

	public float superGetSoundPitch() {
		return super.getSoundPitch();
	}

	@Override
	public void dismountEntity(Entity entity) {
		if (master != null) master.dismountEntity(entity);
		else super.dismountEntity(entity);
	}

	public void superDismountEntity(Object entity) {
		super.dismountEntity((Entity) entity);
	}

	@Override
	protected float func_175134_bD() {
		return master != null ? master.getJumpUpwardsMotion() : super.func_175134_bD();
	}

	public float superGetJumpUpwardsMotion() {
		return super.func_175134_bD();
	}

	@Override
	protected void updateAITick() {
		if (master != null) master.updateAITick();
		else super.updateAITick();
	}

	public void superUpdateAITick() {
		super.updateAITick();
	}

	@Override
	protected void func_180466_bG() {
		if (master != null) master.handleJumpLava();
		else super.func_180466_bG();
	}

	public void superHandleJumpLava() {
		super.func_180466_bG();
	}

	@Override
	public void setAIMoveSpeed(float p_70659_1_) {
		if (master != null) master.setAIMoveSpeed(p_70659_1_);
		else super.setAIMoveSpeed(p_70659_1_);
	}

	public void superSetAIMoveSpeed(float p_70659_1_) {
		super.setAIMoveSpeed(p_70659_1_);
	}

	@Override
	public boolean attackEntityAsMob(Entity entity) {
		return master != null ? master.attackEntityAsMob(entity) : super.attackEntityAsMob(entity);
	}

	public boolean superAttackEntityAsMob(Object entity) {
		return super.attackEntityAsMob((Entity) entity);
	}

	@Override
	protected float func_110146_f(float p_110146_1_, float p_110146_2_) {
		return master != null ? master.func_110146_f(p_110146_1_, p_110146_2_) : super.func_110146_f(p_110146_1_, p_110146_2_);
	}

	public float superFunc_110146_f(float p_110146_1_, float p_110146_2_) {
		return super.func_110146_f(p_110146_1_, p_110146_2_);
	}

	@Override
	protected void collideWithNearbyEntities() {
		if (master != null) master.collideWithNearbyEntities();
		else super.collideWithNearbyEntities();
	}

	public void superCollideWithNearbyEntities() {
		super.collideWithNearbyEntities();
	}

	@Override
	protected void collideWithEntity(Entity entity) {
		if (master != null) master.collideWithEntity(entity);
		else super.collideWithEntity(entity);
	}

	public void superCollideWithEntity(Object entity) {
		super.collideWithEntity((Entity) entity);
	}

	@Override
	public void mountEntity(Entity entity) {
		if (master != null) master.mountEntity(entity);
		else super.mountEntity(entity);
	}

	public void superMountEntity(Object entity) {
		super.mountEntity((Entity) entity);
	}

	@Override
	public void setJumping(boolean p_70637_1_) {
		if (master != null) master.setJumping(p_70637_1_);
		else super.setJumping(p_70637_1_);
	}

	public void superSetJumping(boolean p_70637_1_) {
		super.setJumping(p_70637_1_);
	}

	@Override
	public void onItemPickup(Entity entity, int p_71001_2_) {
		if (master != null) master.onItemPickup(entity, p_71001_2_);
		else super.onItemPickup(entity, p_71001_2_);
	}

	public void superOnItemPickup(Object entity, int p_71001_2_) {
		super.onItemPickup((Entity) entity, p_71001_2_);
	}

	@Override
	public boolean canEntityBeSeen(Entity entity) {
		return master != null ? master.canEntityBeSeen(entity) : super.canEntityBeSeen(entity);
	}

	public boolean superCanEntityBeSeen(Object entity) {
		return super.canEntityBeSeen((Entity) entity);
	}

	@Override
	public Vec3 getLookVec() {
		return (Vec3) (master != null ? master.getLookVec() : super.getLookVec());
	}

	public Vec3 superGetLookVec() {
		return super.getLookVec();
	}

	@Override
	public Vec3 getLook(float p_70676_1_) {
		return (Vec3) (master != null ? master.getLook(p_70676_1_) : super.getLook(p_70676_1_));
	}

	public Vec3 superGetLook(float p_70676_1_) {
		return super.getLook(p_70676_1_);
	}

	@Override
	public float getSwingProgress(float p_70678_1_) {
		return master != null ? master.getSwingProgress(p_70678_1_) : super.getSwingProgress(p_70678_1_);
	}

	public float superGetSwingProgress(float p_70678_1_) {
		return super.getSwingProgress(p_70678_1_);
	}

	@Override
	public boolean isServerWorld() {
		return master != null ? master.isServerWorld() : super.isServerWorld();
	}

	public boolean superIsServerWorld() {
		return super.isServerWorld();
	}

	@Override
	public boolean canBeCollidedWith() {
		return master != null ? master.canBeCollidedWith() : super.canBeCollidedWith();
	}

	public boolean superCanBeCollidedWith() {
		return super.canBeCollidedWith();
	}

	@Override
	public boolean canBePushed() {
		return master != null ? master.canBePushed() : super.canBePushed();
	}

	public boolean superCanBePushed() {
		return super.canBePushed();
	}

	@Override
	protected void setBeenAttacked() {
		if (master != null) master.setBeenAttacked();
		else super.setBeenAttacked();
	}

	public void superSetBeenAttacked() {
		super.setBeenAttacked();
	}

	@Override
	public float getRotationYawHead() {
		return master != null ? master.getRotationYawHead() : super.getRotationYawHead();
	}

	public float superGetRotationYawHead() {
		return super.getRotationYawHead();
	}

	@Override
	public void setRotationYawHead(float rotation) {
		if (master != null) master.setRotationYawHead(rotation);
		else super.setRotationYawHead(rotation);
	}

	public void superSetRotationYawHead(float rotation) {
		super.setRotationYawHead(rotation);
	}

	@Override
	public boolean isOnSameTeam(EntityLivingBase entityLivingBase) {
		return master != null ? master.isOnSameTeam(entityLivingBase) : super.isOnSameTeam(entityLivingBase);
	}

	public boolean superIsOnSameTeam(Object entityLivingBase) {
		return super.isOnSameTeam((EntityLivingBase) entityLivingBase);
	}

	@Override
	public boolean isOnTeam(Team team) {
		return master != null ? master.isOnTeam(team) : super.isOnTeam(team);
	}

	public boolean superIsOnTeam(Object team) {
		return super.isOnTeam((Team) team);
	}

	@Override
	public void func_152111_bt() {
		if (master != null) master.sendEnterCombat();
		else super.func_152111_bt();
	}

	public void superSendEnterCombat() {
		super.func_152111_bt();
	}

	@Override
	public void func_152112_bu() {
		if (master != null) master.sendEndCombat();
		else super.func_152112_bu();
	}

	public void superSendEndCombat() {
		super.func_152112_bu();
	}

	@Override
	protected void func_175136_bO() {
		if (master != null) master.markPotionsDirty();
		else super.func_175136_bO();
	}

	public void superMarkPotionsDirty() {
		super.func_175136_bO();
	}

	@Override
	public void curePotionEffects(ItemStack itemStack) {
		if (master != null) master.curePotionEffects(itemStack);
		else super.curePotionEffects(itemStack);
	}

	public void superCurePotionEffects(Object itemStack) {
		super.curePotionEffects((ItemStack) itemStack);
	}

	@Override
	public boolean shouldRiderFaceForward(EntityPlayer entityPlayer) {
		return master != null ? master.shouldRiderFaceForward(entityPlayer) : super.shouldRiderFaceForward(entityPlayer);
	}

	public boolean superShouldRiderFaceForward(Object entityPlayer) {
		return super.shouldRiderFaceForward((EntityPlayer) entityPlayer);
	}

	@Override
	public int getEntityId() {
		return master != null ? master.getEntityId() : super.getEntityId();
	}

	public int superGetEntityId() {
		return super.getEntityId();
	}

	@Override
	public void setEntityId(int id) {
		if (master != null) master.setEntityId(id);
		else super.setEntityId(id);
	}

	public void superSetEntityId(int id) {
		super.setEntityId(id);
	}

	@Override
	public DataWatcher getDataWatcher() {
		return (DataWatcher) (master != null ? master.getDataWatcher() : super.getDataWatcher());
	}

	public DataWatcher superGetDataWatcher() {
		return super.getDataWatcher();
	}
	/*
	
		public boolean equals(Object p_equals_1_) {
			return master != null ? master.equals(p_equals_1_) : super.equals(p_equals_1_);
		}
	
		public boolean superEquals(Object p_equals_1_) {
			return super.equals(p_equals_1_);
		}
	
	
		public int hashCode() {
			return master != null ? master.hashCode() : super.hashCode();
		}
	
		public int superHashCode() {
			return super.hashCode();
		}
	*/

	@Override
	protected void setSize(float width, float height) {
		if (master != null) master.setSize(width, height);
		else super.setSize(width, height);
	}

	public void superSetSize(float width, float height) {
		super.setSize(width, height);
	}

	@Override
	protected void setRotation(float yaw, float pitch) {
		if (master != null) master.setRotation(yaw, pitch);
		else super.setRotation(yaw, pitch);
	}

	public void superSetRotation(float yaw, float pitch) {
		super.setRotation(yaw, pitch);
	}

	@Override
	public void setPosition(double x, double y, double z) {
		if (master != null) master.setPosition(x, y, z);
		else super.setPosition(x, y, z);
	}

	public void superSetPosition(double x, double y, double z) {
		super.setPosition(x, y, z);
	}

	@Override
	public void setAngles(float yaw, float pitch) {
		if (master != null) master.setAngles(yaw, pitch);
		else super.setAngles(yaw, pitch);
	}

	public void superSetAngles(float yaw, float pitch) {
		super.setAngles(yaw, pitch);
	}

	@Override
	protected void setOnFireFromLava() {
		if (master != null) master.setOnFireFromLava();
		else super.setOnFireFromLava();
	}

	public void superSetOnFireFromLava() {
		super.setOnFireFromLava();
	}

	@Override
	public void setFire(int seconds) {
		if (master != null) master.setFire(seconds);
		else super.setFire(seconds);
	}

	public void superSetFire(int seconds) {
		super.setFire(seconds);
	}

	@Override
	public void extinguish() {
		if (master != null) master.extinguish();
		else super.extinguish();
	}

	public void superExtinguish() {
		super.extinguish();
	}

	@Override
	public boolean isOffsetPositionInLiquid(double x, double y, double z) {
		return master != null ? master.isOffsetPositionInLiquid(x, y, z) : super.isOffsetPositionInLiquid(x, y, z);
	}

	public boolean superIsOffsetPositionInLiquid(double x, double y, double z) {
		return super.isOffsetPositionInLiquid(x, y, z);
	}

	@Override
	public void moveEntity(double x, double y, double z) {
		if (master != null) master.moveEntity(x, y, z);
		else super.moveEntity(x, y, z);
	}

	public void superMoveEntity(double x, double y, double z) {
		super.moveEntity(x, y, z);
	}

	@Override
	protected void doBlockCollisions() {
		if (master != null) master.doBlockCollisions();
		else super.doBlockCollisions();
	}

	public void superDoBlockCollisions() {
		super.doBlockCollisions();
	}

	@Override
	protected void playStepSound(BlockPos blockPos, Block block) {
		if (master != null) master.playStepSound(blockPos, block);
		else super.playStepSound(blockPos, block);
	}

	public void superPlayStepSound(Object blockPos, Object block) {
		super.playStepSound((BlockPos) blockPos, (Block) block);
	}

	@Override
	public boolean isSilent() {
		return master != null ? master.isSilent() : super.isSilent();
	}

	public boolean superIsSilent() {
		return super.isSilent();
	}

	@Override
	public void setSilent(boolean isSilent) {
		if (master != null) master.setSilent(isSilent);
		else super.setSilent(isSilent);
	}

	public void superSetSilent(boolean isSilent) {
		super.setSilent(isSilent);
	}

	@Override
	public AxisAlignedBB getBoundingBox() {
		return (AxisAlignedBB) (master != null ? master.getCollisionBoundingBox() : super.getBoundingBox());
	}

	public AxisAlignedBB superGetCollisionBoundingBox() {
		return super.getBoundingBox();
	}

	@Override
	protected void dealFireDamage(int amount) {
		if (master != null) master.dealFireDamage(amount);
		else super.dealFireDamage(amount);
	}

	public void superDealFireDamage(int amount) {
		super.dealFireDamage(amount);
	}

	@Override
	public boolean isWet() {
		return master != null ? master.isWet() : super.isWet();
	}

	public boolean superIsWet() {
		return super.isWet();
	}

	@Override
	public boolean isInWater() {
		return master != null ? master.isInWater() : super.isInWater();
	}

	public boolean superIsInWater() {
		return super.isInWater();
	}

	@Override
	public boolean handleWaterMovement() {
		return master != null ? master.handleWaterMovement() : super.handleWaterMovement();
	}

	public boolean superHandleWaterMovement() {
		return super.handleWaterMovement();
	}

	@Override
	public void spawnRunningParticles() {
		if (master != null) master.spawnRunningParticles();
		else super.spawnRunningParticles();
	}

	public void superSpawnRunningParticles() {
		super.spawnRunningParticles();
	}

	@Override
	protected void createRunningParticles() {
		if (master != null) master.createRunningParticles();
		else super.createRunningParticles();
	}

	public void superCreateRunningParticles() {
		super.createRunningParticles();
	}

	@Override
	public boolean isInsideOfMaterial(Material material) {
		return master != null ? master.isInsideOfMaterial(material) : super.isInsideOfMaterial(material);
	}

	public boolean superIsInsideOfMaterial(Object material) {
		return super.isInsideOfMaterial((Material) material);
	}

	@Override
	public boolean isInLava() {
		return master != null ? master.isInLava() : super.isInLava();
	}

	public boolean superIsInLava() {
		return super.isInLava();
	}

	@Override
	public void moveFlying(float strafe, float forward, float friction) {
		if (master != null) master.moveFlying(strafe, forward, friction);
		else super.moveFlying(strafe, forward, friction);
	}

	public void superMoveFlying(float strafe, float forward, float friction) {
		super.moveFlying(strafe, forward, friction);
	}

	@Override
	public int getBrightnessForRender(float p_70070_1_) {
		return master != null ? master.getBrightnessForRender(p_70070_1_) : super.getBrightnessForRender(p_70070_1_);
	}

	public int superGetBrightnessForRender(float p_70070_1_) {
		return super.getBrightnessForRender(p_70070_1_);
	}

	@Override
	public float getBrightness(float p_70013_1_) {
		return master != null ? master.getBrightness(p_70013_1_) : super.getBrightness(p_70013_1_);
	}

	public float superGetBrightness(float p_70013_1_) {
		return super.getBrightness(p_70013_1_);
	}

	@Override
	public void setWorld(World world) {
		if (master != null) master.setWorld(world);
		else super.setWorld(world);
	}

	public void superSetWorld(Object world) {
		super.setWorld((World) world);
	}

	@Override
	public void setPositionAndRotation(double x, double y, double z, float yaw, float pitch) {
		if (master != null) master.setPositionAndRotation(x, y, z, yaw, pitch);
		else super.setPositionAndRotation(x, y, z, yaw, pitch);
	}

	public void superSetPositionAndRotation(double x, double y, double z, float yaw, float pitch) {
		super.setPositionAndRotation(x, y, z, yaw, pitch);
	}

	@Override
	public void moveToBlockPosAndAngles(BlockPos blockPos, float p_174828_2_, float p_174828_3_) {
		if (master != null) master.moveToBlockPosAndAngles(blockPos, p_174828_2_, p_174828_3_);
		else super.moveToBlockPosAndAngles(blockPos, p_174828_2_, p_174828_3_);
	}

	public void superMoveToBlockPosAndAngles(Object blockPos, float p_174828_2_, float p_174828_3_) {
		super.moveToBlockPosAndAngles((BlockPos) blockPos, p_174828_2_, p_174828_3_);
	}

	@Override
	public void setLocationAndAngles(double x, double y, double z, float yaw, float pitch) {
		if (master != null) master.setLocationAndAngles(x, y, z, yaw, pitch);
		else super.setLocationAndAngles(x, y, z, yaw, pitch);
	}

	public void superSetLocationAndAngles(double x, double y, double z, float yaw, float pitch) {
		super.setLocationAndAngles(x, y, z, yaw, pitch);
	}

	@Override
	public float getDistanceToEntity(Entity entity) {
		return master != null ? master.getDistanceToEntity(entity) : super.getDistanceToEntity(entity);
	}

	public float superGetDistanceToEntity(Object entity) {
		return super.getDistanceToEntity((Entity) entity);
	}

	@Override
	public double getDistanceSq(double x, double y, double z) {
		return master != null ? master.getDistanceSq(x, y, z) : super.getDistanceSq(x, y, z);
	}

	public double superGetDistanceSq(double x, double y, double z) {
		return super.getDistanceSq(x, y, z);
	}

	@Override
	public double getDistanceSq(BlockPos blockPos) {
		return master != null ? master.getDistanceSq(blockPos) : super.getDistanceSq(blockPos);
	}

	public double superGetDistanceSq(Object blockPos) {
		return super.getDistanceSq((BlockPos) blockPos);
	}

	@Override
	public double getDistanceSqToCenter(BlockPos blockPos) {
		return master != null ? master.getDistanceSqToCenter(blockPos) : super.getDistanceSqToCenter(blockPos);
	}

	public double superGetDistanceSqToCenter(Object blockPos) {
		return super.getDistanceSqToCenter((BlockPos) blockPos);
	}

	@Override
	public double getDistance(double x, double y, double z) {
		return master != null ? master.getDistance(x, y, z) : super.getDistance(x, y, z);
	}

	public double superGetDistance(double x, double y, double z) {
		return super.getDistance(x, y, z);
	}

	@Override
	public double getDistanceSqToEntity(Entity entity) {
		return master != null ? master.getDistanceSqToEntity(entity) : super.getDistanceSqToEntity(entity);
	}

	public double superGetDistanceSqToEntity(Object entity) {
		return super.getDistanceSqToEntity((Entity) entity);
	}

	@Override
	public void onCollideWithPlayer(EntityPlayer entityPlayer) {
		if (master != null) master.onCollideWithPlayer(entityPlayer);
		else super.onCollideWithPlayer(entityPlayer);
	}

	public void superOnCollideWithPlayer(Object entityPlayer) {
		super.onCollideWithPlayer((EntityPlayer) entityPlayer);
	}

	@Override
	public void applyEntityCollision(Entity entity) {
		if (master != null) master.applyEntityCollision(entity);
		else super.applyEntityCollision(entity);
	}

	public void superApplyEntityCollision(Object entity) {
		super.applyEntityCollision((Entity) entity);
	}

	@Override
	public void addVelocity(double x, double y, double z) {
		if (master != null) master.addVelocity(x, y, z);
		else super.addVelocity(x, y, z);
	}

	public void superAddVelocity(double x, double y, double z) {
		super.addVelocity(x, y, z);
	}

	@Override
	public Vec3 getPositionEyes(float p_174824_1_) {
		return (Vec3) (master != null ? master.getPositionEyes(p_174824_1_) : super.getPositionEyes(p_174824_1_));
	}

	public Vec3 superGetPositionEyes(float p_174824_1_) {
		return super.getPositionEyes(p_174824_1_);
	}

	@Override
	public MovingObjectPosition rayTrace(double p_174822_1_, float p_174822_3_) {
		return (MovingObjectPosition) (master != null ? master.rayTrace(p_174822_1_, p_174822_3_) : super.rayTrace(p_174822_1_, p_174822_3_));
	}

	public MovingObjectPosition superRayTrace(double p_174822_1_, float p_174822_3_) {
		return super.rayTrace(p_174822_1_, p_174822_3_);
	}

	@Override
	public boolean isInRangeToRender3d(double x, double y, double z) {
		return master != null ? master.isInRangeToRender3d(x, y, z) : super.isInRangeToRender3d(x, y, z);
	}

	public boolean superIsInRangeToRender3d(double x, double y, double z) {
		return super.isInRangeToRender3d(x, y, z);
	}

	@Override
	public boolean isInRangeToRenderDist(double distance) {
		return master != null ? master.isInRangeToRenderDist(distance) : super.isInRangeToRenderDist(distance);
	}

	public boolean superIsInRangeToRenderDist(double distance) {
		return super.isInRangeToRenderDist(distance);
	}

	@Override
	public boolean writeMountToNBT(NBTTagCompound nBTTagCompound) {
		return master != null ? master.writeMountToNBT(nBTTagCompound) : super.writeMountToNBT(nBTTagCompound);
	}

	public boolean superWriteMountToNBT(Object nBTTagCompound) {
		return super.writeMountToNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public boolean writeToNBTOptional(NBTTagCompound nBTTagCompound) {
		return master != null ? master.writeToNBTOptional(nBTTagCompound) : super.writeToNBTOptional(nBTTagCompound);
	}

	public boolean superWriteToNBTOptional(Object nBTTagCompound) {
		return super.writeToNBTOptional((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public void writeToNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.writeToNBT(nBTTagCompound);
		else super.writeToNBT(nBTTagCompound);
	}

	public void superWriteToNBT(Object nBTTagCompound) {
		super.writeToNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public void readFromNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.readFromNBT(nBTTagCompound);
		else super.readFromNBT(nBTTagCompound);
	}

	public void superReadFromNBT(Object nBTTagCompound) {
		super.readFromNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	protected boolean shouldSetPosAfterLoading() {
		return master != null ? master.shouldSetPosAfterLoading() : super.shouldSetPosAfterLoading();
	}

	public boolean superShouldSetPosAfterLoading() {
		return super.shouldSetPosAfterLoading();
	}

	@Override
	public void onChunkLoad() {
		if (master != null) master.onChunkLoad();
		else super.onChunkLoad();
	}

	public void superOnChunkLoad() {
		super.onChunkLoad();
	}

	@Override
	protected NBTTagList newDoubleNBTList(double... numbers) {
		return (NBTTagList) (master != null ? master.newDoubleNBTList(numbers) : super.newDoubleNBTList(numbers));
	}

	public NBTTagList superNewDoubleNBTList(double... numbers) {
		return super.newDoubleNBTList(numbers);
	}

	@Override
	protected NBTTagList newFloatNBTList(float... numbers) {
		return (NBTTagList) (master != null ? master.newFloatNBTList(numbers) : super.newFloatNBTList(numbers));
	}

	public NBTTagList superNewFloatNBTList(float... numbers) {
		return super.newFloatNBTList(numbers);
	}

	@Override
	public EntityItem dropItem(Item item, int size) {
		return (EntityItem) (master != null ? master.dropItem(item, size) : super.dropItem(item, size));
	}

	public EntityItem superDropItem(Object item, int size) {
		return super.dropItem((Item) item, size);
	}

	@Override
	public EntityItem dropItemWithOffset(Item item, int size, float p_145778_3_) {
		return (EntityItem) (master != null ? master.dropItemWithOffset(item, size, p_145778_3_) : super.dropItemWithOffset(item, size, p_145778_3_));
	}

	public EntityItem superDropItemWithOffset(Object item, int size, float p_145778_3_) {
		return super.dropItemWithOffset((Item) item, size, p_145778_3_);
	}

	@Override
	public EntityItem entityDropItem(ItemStack itemStack, float offsetY) {
		return (EntityItem) (master != null ? master.entityDropItem(itemStack, offsetY) : super.entityDropItem(itemStack, offsetY));
	}

	public EntityItem superEntityDropItem(Object itemStack, float offsetY) {
		return super.entityDropItem((ItemStack) itemStack, offsetY);
	}

	@Override
	public boolean interactFirst(EntityPlayer entityPlayer) {
		return master != null ? master.interactFirst(entityPlayer) : super.interactFirst(entityPlayer);
	}

	public boolean superInteractFirst(Object entityPlayer) {
		return super.interactFirst((EntityPlayer) entityPlayer);
	}

	@Override
	public AxisAlignedBB getCollisionBox(Entity entity) {
		return (AxisAlignedBB) (master != null ? master.getCollisionBox(entity) : super.getCollisionBox(entity));
	}

	public AxisAlignedBB superGetCollisionBox(Object entity) {
		return super.getCollisionBox((Entity) entity);
	}

	@Override
	public void updateRiderPosition() {
		if (master != null) master.updateRiderPosition();
		else super.updateRiderPosition();
	}

	public void superUpdateRiderPosition() {
		super.updateRiderPosition();
	}

	@Override
	public double getMountedYOffset() {
		return master != null ? master.getMountedYOffset() : super.getMountedYOffset();
	}

	public double superGetMountedYOffset() {
		return super.getMountedYOffset();
	}

	@Override
	public float getCollisionBorderSize() {
		return master != null ? master.getCollisionBorderSize() : super.getCollisionBorderSize();
	}

	public float superGetCollisionBorderSize() {
		return super.getCollisionBorderSize();
	}

	@Override
	public void setInPortal() {
		if (master != null) master.setPortal(null);
		else super.setInPortal();
	}

	public void superSetPortal(Object bockPos) {
		super.setInPortal();
	}

	@Override
	public void setVelocity(double x, double y, double z) {
		if (master != null) master.setVelocity(x, y, z);
		else super.setVelocity(x, y, z);
	}

	public void superSetVelocity(double x, double y, double z) {
		super.setVelocity(x, y, z);
	}

	@Override
	public boolean isBurning() {
		return master != null ? master.isBurning() : super.isBurning();
	}

	public boolean superIsBurning() {
		return super.isBurning();
	}

	@Override
	public boolean isRiding() {
		return master != null ? master.isRiding() : super.isRiding();
	}

	public boolean superIsRiding() {
		return super.isRiding();
	}

	@Override
	public boolean isSneaking() {
		return master != null ? master.isSneaking() : super.isSneaking();
	}

	public boolean superIsSneaking() {
		return super.isSneaking();
	}

	@Override
	public void setSneaking(boolean sneaking) {
		if (master != null) master.setSneaking(sneaking);
		else super.setSneaking(sneaking);
	}

	public void superSetSneaking(boolean sneaking) {
		super.setSneaking(sneaking);
	}

	@Override
	public boolean isSprinting() {
		return master != null ? master.isSprinting() : super.isSprinting();
	}

	public boolean superIsSprinting() {
		return super.isSprinting();
	}

	@Override
	public boolean isInvisible() {
		return master != null ? master.isInvisible() : super.isInvisible();
	}

	public boolean superIsInvisible() {
		return super.isInvisible();
	}

	@Override
	public void setInvisible(boolean invisible) {
		if (master != null) master.setInvisible(invisible);
		else super.setInvisible(invisible);
	}

	public void superSetInvisible(boolean invisible) {
		super.setInvisible(invisible);
	}

	@Override
	public boolean isEating() {
		return master != null ? master.isEating() : super.isEating();
	}

	public boolean superIsEating() {
		return super.isEating();
	}

	@Override
	public void setEating(boolean eating) {
		if (master != null) master.setEating(eating);
		else super.setEating(eating);
	}

	public void superSetEating(boolean eating) {
		super.setEating(eating);
	}

	@Override
	protected boolean getFlag(int flag) {
		return master != null ? master.getFlag(flag) : super.getFlag(flag);
	}

	public boolean superGetFlag(int flag) {
		return super.getFlag(flag);
	}

	@Override
	protected void setFlag(int flag, boolean set) {
		if (master != null) master.setFlag(flag, set);
		else super.setFlag(flag, set);
	}

	public void superSetFlag(int flag, boolean set) {
		super.setFlag(flag, set);
	}

	@Override
	public int getAir() {
		return master != null ? master.getAir() : super.getAir();
	}

	public int superGetAir() {
		return super.getAir();
	}

	@Override
	public void setAir(int air) {
		if (master != null) master.setAir(air);
		else super.setAir(air);
	}

	public void superSetAir(int air) {
		super.setAir(air);
	}

	@Override
	public void onStruckByLightning(EntityLightningBolt entityLightningBolt) {
		if (master != null) master.onStruckByLightning(entityLightningBolt);
		else super.onStruckByLightning(entityLightningBolt);
	}

	public void superOnStruckByLightning(Object entityLightningBolt) {
		super.onStruckByLightning((EntityLightningBolt) entityLightningBolt);
	}

	@Override
	protected boolean pushOutOfBlocks(double x, double y, double z) {
		return master != null ? master.pushOutOfBlocks(x, y, z) : super.pushOutOfBlocks(x, y, z);
	}

	public boolean superPushOutOfBlocks(double x, double y, double z) {
		return super.pushOutOfBlocks(x, y, z);
	}

	@Override
	public Entity[] getParts() {
		return (Entity[]) (master != null ? master.getParts() : super.getParts());
	}

	public Entity[] superGetParts() {
		return super.getParts();
	}

	@Override
	public boolean isEntityEqual(Entity entity) {
		return master != null ? master.isEntityEqual(entity) : super.isEntityEqual(entity);
	}

	public boolean superIsEntityEqual(Object entity) {
		return super.isEntityEqual((Entity) entity);
	}

	@Override
	public boolean canAttackWithItem() {
		return master != null ? master.canAttackWithItem() : super.canAttackWithItem();
	}

	public boolean superCanAttackWithItem() {
		return super.canAttackWithItem();
	}

	@Override
	public boolean hitByEntity(Entity entity) {
		return master != null ? master.hitByEntity(entity) : super.hitByEntity(entity);
	}

	public boolean superHitByEntity(Object entity) {
		return super.hitByEntity((Entity) entity);
	}

	@Override
	public String toString() {
		return master != null ? master.toString() : super.toString();
	}

	public String superToString() {
		return super.toString();
	}

	@Override
	public boolean isEntityInvulnerable(DamageSource damageSource) {
		return master != null ? master.isEntityInvulnerable(damageSource) : super.isEntityInvulnerable(damageSource);
	}

	public boolean superIsEntityInvulnerable(Object damageSource) {
		return super.isEntityInvulnerable((DamageSource) damageSource);
	}

	@Override
	public void copyLocationAndAnglesFrom(Entity entity) {
		if (master != null) master.copyLocationAndAnglesFrom(entity);
		else super.copyLocationAndAnglesFrom(entity);
	}

	public void superCopyLocationAndAnglesFrom(Object entity) {
		super.copyLocationAndAnglesFrom((Entity) entity);
	}

	@Override
	public void copyDataFromOld(Entity entity) {
		if (master != null) master.copyDataFromOld(entity);
		else super.copyDataFromOld(entity);
	}

	public void superCopyDataFromOld(Object entity) {
		super.copyDataFromOld((Entity) entity);
	}

	@Override
	public void travelToDimension(int dimensionId) {
		if (master != null) master.travelToDimension(dimensionId);
		else super.travelToDimension(dimensionId);
	}

	public void superTravelToDimension(int dimensionId) {
		super.travelToDimension(dimensionId);
	}

	@Override
	public float getExplosionResistance(Explosion explosion, World world, BlockPos blockPos, IBlockState iBlockState) {
		return master != null ? master.getExplosionResistance(explosion, world, blockPos, iBlockState) : super.getExplosionResistance(explosion, world, blockPos, iBlockState);
	}

	public float superGetExplosionResistance(Object explosion, Object world, Object blockPos, Object iBlockState) {
		return super.getExplosionResistance((Explosion) explosion, (World) world, (BlockPos) blockPos, (IBlockState) iBlockState);
	}

	@Override
	public boolean func_174816_a(Explosion explosion, World world, BlockPos blockPos, IBlockState iBlockState, float p_174816_5_) {
		return master != null ? master.verifyExplosion(explosion, world, blockPos, iBlockState, p_174816_5_) : super.func_174816_a(explosion, world, blockPos, iBlockState, p_174816_5_);
	}

	public boolean superVerifyExplosion(Object explosion, Object world, Object blockPos, Object iBlockState, float p_174816_5_) {
		return super.func_174816_a((Explosion) explosion, (World) world, (BlockPos) blockPos, (IBlockState) iBlockState, p_174816_5_);
	}

	@Override
	public int getMaxFallHeight() {
		return master != null ? master.getMaxFallHeight() : super.getMaxFallHeight();
	}

	public int superGetMaxFallHeight() {
		return super.getMaxFallHeight();
	}

	@Override
	public int getTeleportDirection() {
		return (Integer) (master != null ? master.getTeleportDirection() : super.getTeleportDirection());
	}

	public Object superGetTeleportDirection() {
		return super.getTeleportDirection();
	}

	@Override
	public boolean doesEntityNotTriggerPressurePlate() {
		return master != null ? master.doesEntityNotTriggerPressurePlate() : super.doesEntityNotTriggerPressurePlate();
	}

	public boolean superDoesEntityNotTriggerPressurePlate() {
		return super.doesEntityNotTriggerPressurePlate();
	}

	@Override
	public void addEntityCrashInfo(CrashReportCategory crashReportCategory) {
		if (master != null) master.addEntityCrashInfo(crashReportCategory);
		else super.addEntityCrashInfo(crashReportCategory);
	}

	public void superAddEntityCrashInfo(Object crashReportCategory) {
		super.addEntityCrashInfo((CrashReportCategory) crashReportCategory);
	}

	@Override
	public boolean canRenderOnFire() {
		return master != null ? master.canRenderOnFire() : super.canRenderOnFire();
	}

	public boolean superCanRenderOnFire() {
		return super.canRenderOnFire();
	}

	@Override
	public UUID getUniqueID() {
		return master != null ? master.getUniqueID() : super.getUniqueID();
	}

	public UUID superGetUniqueID() {
		return super.getUniqueID();
	}

	@Override
	public void setCustomNameTag(String p_96094_1_) {
		if (master != null) master.setCustomNameTag(p_96094_1_);
		else super.setCustomNameTag(p_96094_1_);
	}

	public void superSetCustomNameTag(String p_96094_1_) {
		super.setCustomNameTag(p_96094_1_);
	}

	@Override
	public String getCustomNameTag() {
		return master != null ? master.getCustomNameTag() : super.getCustomNameTag();
	}

	public String superGetCustomNameTag() {
		return super.getCustomNameTag();
	}

	@Override
	public boolean hasCustomName() {
		return master != null ? master.hasCustomName() : super.hasCustomName();
	}

	public boolean superHasCustomName() {
		return super.hasCustomName();
	}

	@Override
	public void setAlwaysRenderNameTag(boolean p_174805_1_) {
		if (master != null) master.setAlwaysRenderNameTag(p_174805_1_);
		else super.setAlwaysRenderNameTag(p_174805_1_);
	}

	public void superSetAlwaysRenderNameTag(boolean p_174805_1_) {
		super.setAlwaysRenderNameTag(p_174805_1_);
	}

	@Override
	public boolean getAlwaysRenderNameTag() {
		return master != null ? master.getAlwaysRenderNameTag() : super.getAlwaysRenderNameTag();
	}

	public boolean superGetAlwaysRenderNameTag() {
		return super.getAlwaysRenderNameTag();
	}

	@Override
	public void setPositionAndUpdate(double x, double y, double z) {
		if (master != null) master.setPositionAndUpdate(x, y, z);
		else super.setPositionAndUpdate(x, y, z);
	}

	public void superSetPositionAndUpdate(double x, double y, double z) {
		super.setPositionAndUpdate(x, y, z);
	}

	@Override
	public void func_145781_i(int p_145781_1_) {
		if (master != null) master.onDataWatcherUpdate(p_145781_1_);
		else super.func_145781_i(p_145781_1_);
	}

	public void superOnDataWatcherUpdate(int p_145781_1_) {
		super.func_145781_i(p_145781_1_);
	}

	@Override
	public EnumFacing getHorizontalFacing() {
		return (EnumFacing) (master != null ? master.getHorizontalFacing() : super.getHorizontalFacing());
	}

	public EnumFacing superGetHorizontalFacing() {
		return super.getHorizontalFacing();
	}

	@Override
	protected HoverEvent func_174823_aP() {
		return (HoverEvent) (master != null ? master.getHoverEvent() : super.func_174823_aP());
	}

	public HoverEvent superGetHoverEvent() {
		return super.func_174823_aP();
	}

	@Override
	public boolean func_174827_a(EntityPlayerMP entityPlayerMP) {
		return master != null ? master.isSpectatedByPlayer(entityPlayerMP) : super.func_174827_a(entityPlayerMP);
	}

	public boolean superIsSpectatedByPlayer(Object entityPlayerMP) {
		return super.func_174827_a((EntityPlayerMP) entityPlayerMP);
	}

	@Override
	public AxisAlignedBB getEntityBoundingBox() {
		return (AxisAlignedBB) (master != null ? master.getEntityBoundingBox() : super.getEntityBoundingBox());
	}

	public AxisAlignedBB superGetEntityBoundingBox() {
		return super.getEntityBoundingBox();
	}

	@Override
	public void setEntityBoundingBox(AxisAlignedBB axisAlignedBB) {
		if (master != null) master.setEntityBoundingBox(axisAlignedBB);
		else super.setEntityBoundingBox(axisAlignedBB);
	}

	public void superSetEntityBoundingBox(Object axisAlignedBB) {
		super.setEntityBoundingBox((AxisAlignedBB) axisAlignedBB);
	}

	@Override
	public boolean isOutsideBorder() {
		return master != null ? master.isOutsideBorder() : super.isOutsideBorder();
	}

	public boolean superIsOutsideBorder() {
		return super.isOutsideBorder();
	}

	@Override
	public void setOutsideBorder(boolean p_174821_1_) {
		if (master != null) master.setOutsideBorder(p_174821_1_);
		else super.setOutsideBorder(p_174821_1_);
	}

	public void superSetOutsideBorder(boolean p_174821_1_) {
		super.setOutsideBorder(p_174821_1_);
	}

	@Override
	public Vec3 getPositionVector() {
		return (Vec3) (master != null ? master.getPositionVector() : super.getPositionVector());
	}

	public Vec3 superGetPositionVector() {
		return super.getPositionVector();
	}

	@Override
	public World getEntityWorld() {
		return (World) (master != null ? master.getEntityWorld() : super.getEntityWorld());
	}

	public World superGetEntityWorld() {
		return super.getEntityWorld();
	}

	@Override
	public Entity getCommandSenderEntity() {
		return (Entity) (master != null ? master.getCommandSenderEntity() : super.getCommandSenderEntity());
	}

	public Entity superGetCommandSenderEntity() {
		return super.getCommandSenderEntity();
	}

	@Override
	public void setCommandStat(Type type, int amount) {
		if (master != null) master.setCommandStat(type, amount);
		else super.setCommandStat(type, amount);
	}

	public void superSetCommandStat(Object type, int amount) {
		super.setCommandStat((Type) type, amount);
	}

	@Override
	public CommandResultStats func_174807_aT() {
		return (CommandResultStats) (master != null ? master.getCommandStats() : super.func_174807_aT());
	}

	public CommandResultStats superGetCommandStats() {
		return super.func_174807_aT();
	}

	@Override
	public void func_174817_o(Entity entity) {
		if (master != null) master.func_174817_o(entity);
		else super.func_174817_o(entity);
	}

	public void superFunc_174817_o(Object entity) {
		super.func_174817_o((Entity) entity);
	}

	@Override
	public NBTTagCompound func_174819_aU() {
		return (NBTTagCompound) (master != null ? master.getNBTTagCompound() : super.func_174819_aU());
	}

	public NBTTagCompound superGetNBTTagCompound() {
		return super.func_174819_aU();
	}

	@Override
	public void func_174834_g(NBTTagCompound nBTTagCompound) {
		if (master != null) master.clientUpdateEntityNBT(nBTTagCompound);
		else super.func_174834_g(nBTTagCompound);
	}

	public void superClientUpdateEntityNBT(Object nBTTagCompound) {
		super.func_174834_g((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public boolean func_174825_a(EntityPlayer entityPlayer, Vec3 vec3) {
		return master != null ? master.interactAt(entityPlayer, vec3) : super.func_174825_a(entityPlayer, vec3);
	}

	public boolean superInteractAt(Object entityPlayer, Object vec3) {
		return super.func_174825_a((EntityPlayer) entityPlayer, (Vec3) vec3);
	}

	@Override
	public boolean func_180427_aV() {
		return master != null ? master.isImmuneToExplosions() : super.func_180427_aV();
	}

	public boolean superIsImmuneToExplosions() {
		return super.func_180427_aV();
	}

	@Override
	protected void func_174815_a(EntityLivingBase entityLivingBase, Entity entity) {
		if (master != null) master.applyEnchantments(entityLivingBase, entity);
		else super.func_174815_a(entityLivingBase, entity);
	}

	public void superApplyEnchantments(Object entityLivingBase, Object entity) {
		super.func_174815_a((EntityLivingBase) entityLivingBase, (Entity) entity);
	}

	@Override
	public NBTTagCompound getEntityData() {
		return (NBTTagCompound) (master != null ? master.getEntityData() : super.getEntityData());
	}

	public NBTTagCompound superGetEntityData() {
		return super.getEntityData();
	}

	@Override
	public boolean shouldRiderSit() {
		return master != null ? master.shouldRiderSit() : super.shouldRiderSit();
	}

	public boolean superShouldRiderSit() {
		return super.shouldRiderSit();
	}

	@Override
	public ItemStack getPickedResult(MovingObjectPosition movingObjectPosition) {
		return (ItemStack) (master != null ? master.getPickedResult(movingObjectPosition) : super.getPickedResult(movingObjectPosition));
	}

	public ItemStack superGetPickedResult(Object movingObjectPosition) {
		return super.getPickedResult((MovingObjectPosition) movingObjectPosition);
	}

	@Override
	public UUID getPersistentID() {
		return master != null ? master.getPersistentID() : super.getPersistentID();
	}

	public UUID superGetPersistentID() {
		return super.getPersistentID();
	}

	@Override
	public boolean shouldRenderInPass(int pass) {
		return master != null ? master.shouldRenderInPass(pass) : super.shouldRenderInPass(pass);
	}

	public boolean superShouldRenderInPass(int pass) {
		return super.shouldRenderInPass(pass);
	}

	@Override
	public boolean isCreatureType(EnumCreatureType enumCreatureType, boolean forSpawnCount) {
		return master != null ? master.isCreatureType(enumCreatureType, forSpawnCount) : super.isCreatureType(enumCreatureType, forSpawnCount);
	}

	public boolean superIsCreatureType(Object enumCreatureType, boolean forSpawnCount) {
		return super.isCreatureType((EnumCreatureType) enumCreatureType, forSpawnCount);
	}

	@Override
	public String registerExtendedProperties(String identifier, IExtendedEntityProperties iExtendedEntityProperties) {
		return master != null ? master.registerExtendedProperties(identifier, iExtendedEntityProperties) : super.registerExtendedProperties(identifier, iExtendedEntityProperties);
	}

	public String superRegisterExtendedProperties(String identifier, Object iExtendedEntityProperties) {
		return super.registerExtendedProperties(identifier, (IExtendedEntityProperties) iExtendedEntityProperties);
	}

	@Override
	public IExtendedEntityProperties getExtendedProperties(String identifier) {
		return (IExtendedEntityProperties) (master != null ? master.getExtendedProperties(identifier) : super.getExtendedProperties(identifier));
	}

	public IExtendedEntityProperties superGetExtendedProperties(String identifier) {
		return super.getExtendedProperties(identifier);
	}

	@Override
	public boolean canRiderInteract() {
		return master != null ? master.canRiderInteract() : super.canRiderInteract();
	}

	public boolean superCanRiderInteract() {
		return super.canRiderInteract();
	}

	@Override
	public boolean shouldDismountInWater(Entity entity) {
		return master != null ? master.shouldDismountInWater(entity) : super.shouldDismountInWater(entity);
	}

	public boolean superShouldDismountInWater(Object entity) {
		return super.shouldDismountInWater((Entity) entity);
	}

	public void superSetPositionAndRotation2(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {
	}

	public float superGetShadowSize() {
		return 0.0F;
	}

	public Object superGetPlayerCoordinates() {
		return null;
	}

	public boolean superFunc_152122_n() {
		return false;
	}

	public boolean superFunc_152123_o() {
		return false;
	}

	public void superFunc_152121_a(Object type, Object resourceLocation) {
	}

	public Object superFunc_146097_a(Object itemStack, boolean p_146097_2_, boolean p_146097_3_) {
		return null;
	}

	public float superGetCurrentPlayerStrVsBlock(Object block, boolean p_146096_2_) {
		return 0F;
	}

	public float superGetBreakSpeed(Object block, boolean p_146096_2_, int meta) {
		return 0F;
	}

	public float superGetBreakSpeed(Object block, boolean p_146096_2_, int meta, int x, int y, int z) {
		return 0F;
	}

	public void superFunc_146093_a(Object tileEntityHopper) {
	}

	public void superDisplayGUIHopperMinecart(Object entityMinecartHopper) {
	}

	public void superDisplayGUIEnchantment(int p_71002_1_, int p_71002_2_, int p_71002_3_, String p_71002_4_) {
	}

	public void superDisplayGUIAnvil(int p_82244_1_, int p_82244_2_, int p_82244_3_) {
	}

	public void superDisplayGUIWorkbench(int p_71058_1_, int p_71058_2_, int p_71058_3_) {
	}

	public void superFunc_146101_a(Object tileEntityFurnace) {
	}

	public void superFunc_146102_a(Object tileEntityDispenser) {
	}

	public void superFunc_146100_a(Object tileEntity) {
	}

	public void superFunc_146095_a(Object commandBlockLogic) {
	}

	public void superFunc_146098_a(Object tileEntityBrewingStand) {
	}

	public void superFunc_146104_a(Object tileEntityBeacon) {
	}

	public void superDisplayGUIMerchant(Object iMerchant, String p_71030_2_) {
	}

	public Object superSleepInBedAt(int p_71018_1_, int p_71018_2_, int p_71018_3_) {
		return null;
	}

	public boolean superGetHideCape(int p_82241_1_) {
		return false;
	}

	public void superSetHideCape(int p_82239_1_, boolean p_82239_2_) {
	}

	public void superSetSpawnChunk(Object chunkCoordinates, boolean p_71063_2_) {
	}

	public void superFall(float p_70069_1_) {
	}

	public String superFunc_146067_o(int p_146067_1_) {
		return null;
	}

	public Object superGetItemIcon(Object itemStack, int p_70620_2_) {
		return null;
	}

	public boolean superIsCurrentToolAdventureModeExempt(int p_82246_1_, int p_82246_2_, int p_82246_3_) {
		return false;
	}

	public boolean superCanPlayerEdit(int p_82247_1_, int p_82247_2_, int p_82247_3_, int p_82247_4_, Object itemStack) {
		return false;
	}

	public Object[] superGetLastActiveItems() {
		return null;
	}

	public boolean superGetHideCape() {
		return false;
	}

	public Object superFunc_145748_c_() {
		return null;
	}

	public Object superGetPosition(float par1) {
		return null;
	}

	public void superUpdateFallState(double p_70064_1_, boolean p_70064_3_) {
	}

	public int superFunc_142015_aE() {
		return 0;
	}

	public void superDropRareDrop(int p_70600_1_) {
	}

	public Object superFunc_110142_aN() {
		return null;
	}

	public boolean superIsAIEnabled() {
		return false;
	}

	public void superUpdateAITasks() {
	}

	public boolean superIsClientWorld() {
		return !isServerWorld();
	}

	public void superFunc_145775_I() {
	}

	public void superFunc_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Object block) {
	}

	public boolean superHandleLavaMovement() {
		return false;
	}

	public Object superFunc_145778_a(Object item, int p_145778_2_, float p_145778_3_) {
		return null;
	}

	public boolean superFunc_145771_j(double p_145771_1_, double p_145771_3_, double p_145771_5_) {
		return false;
	}

	public boolean superIsEntityInvulnerable() {
		return isInvisible();
	}

	public void superCopyDataFrom(Object entity, boolean p_82141_2_) {
	}

	public float superFunc_145772_a(Object explosion, Object world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Object block) {
		return 0;
	}

	public boolean superFunc_145774_a(Object explosion, Object world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Object block, float p_145774_7_) {
		return false;
	}

	public int superGetMaxSafePointTries() {
		return 0;
	}
	// ~152

	public void superUpdateCloak() {
	}

	public void superSendChatToPlayer(String par1Str) {
	}

	public int superGetMaxHealth() {
		return (int) getMaxHealth();
	}

	public boolean superFunc_96122_a(Object entityPlayer) {
		return false;
	}

	public void superAlertWolves(Object entityLiving, boolean par2) {
	}

	public void superDamageArmor(int par1) {
		super.damageArmor(par1);
	}

	public float superFunc_82243_bO() {
		return 0.0F;
	}

	public boolean superFunc_71066_bF() {
		return false;
	}

	public void superFunc_82162_bC() {
	}

	public boolean superCanCurrentToolHarvestBlock(int par1, int par2, int par3) {
		return false;
	}

	public boolean superFunc_94062_bN() {
		return false;
	}

	public boolean superFunc_94059_bO() {
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

	public boolean superFunc_98034_c(Object entityPlayer) {
		return false;
	}

	public boolean superFunc_96092_aw() {
		return false;
	}

	public int superFunc_96121_ay() {
		return -1;
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
		return -1;
	}

	public void superPlayLivingSound() {
	}

	public void superSpawnExplosionParticle() {
	}

	public int superGetHealthInt() {
		return (int) super.getHealth();
	}

	public String superGetLivingSound() {
		return null;
	}

	public int superGetDropItemId() {
		return 0;
	}

	public void superSetMoveForward(float par1) {
	}

	public void superFunc_85033_bc() {
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

	public float superGetSpeedModifier() {
		return 0;
	}

	public int superFunc_82143_as() {
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

	public void superFunc_94061_f(boolean par1) {
	}

	public void superFunc_96120_a(int par1, float par2) {
	}

	public void superSetCanPickUpLoot(boolean par1) {
	}

	public boolean superFunc_104002_bU() {
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
		superMountEntity(entity);
	}

	public boolean superFunc_85031_j(Object entity) {
		return false;
	}

	public void superFunc_82149_j(Object entity) {
	}

	public float superFunc_82146_a(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return 0.0F;
	}

	public boolean superFunc_96091_a(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7) {
		return false;
	}

	public void superFunc_85029_a(Object crashReportCategory) {
	}
	// ~164

	public void superSendChatToPlayer(Object chatMessageComponent) {
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

	public float superGetCurrentPlayerStrVsBlock(Object block, boolean par2, int meta) {
		return 0.0F;
	}

	public void superDisplayGUIHopper(Object tileEntityHopper) {
	}

	public void superDisplayGUIFurnace(Object tileEntityFurnace) {
	}

	public void superDisplayGUIDispenser(Object tileEntityDispenser) {
	}

	public void superDisplayGUIEditSign(Object tileEntity) {
	}

	public void superDisplayGUIBrewingStand(Object tileEntityBrewingStand) {
	}

	public void superDisplayGUIBeacon(Object tileEntityBeacon) {
	}

	public void superAddChatMessage(String par1Str) {

	}

	public String superGetEntityName() {
		return null;
	}

	public Object superGetCurrentItemOrArmor(int par1) {
		return null;
	}

	public String superGetTranslatedEntityName() {
		return null;
	}

	public void superPlayStepSound(int par1, int par2, int par3, int par4) {
	}

	public boolean superIsInRangeToRenderVec3D(Object vec3) {
		return false;
	}

	public Object superDropItem(int par1, int par2) {
		return null;
	}

	public Object superDropItemWithOffset(int par1, int par2, float par3) {
		return null;
	}

	public float superGetBlockExplosionResistance(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return 0.0F;
	}

	public boolean superShouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7) {
		return false;
	}

}
