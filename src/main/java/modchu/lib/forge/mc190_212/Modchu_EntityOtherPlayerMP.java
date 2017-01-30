package modchu.lib.forge.mc190_212;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.mojang.authlib.GameProfile;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityOtherPlayerMP;
import modchu.lib.Modchu_IEntityOtherPlayerMPMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.CommandResultStats.Type;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.Team;
import net.minecraft.server.MinecraftServer;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.StatBase;
import net.minecraft.tileentity.CommandBlockBaseLogic;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.CombatTracker;
import net.minecraft.util.CooldownTracker;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.FoodStats;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.Explosion;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.LockCode;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;

public abstract class Modchu_EntityOtherPlayerMP extends EntityOtherPlayerMP implements Modchu_IEntityOtherPlayerMP {
	public Modchu_IEntityOtherPlayerMPMaster master;
	protected ConcurrentHashMap<String, DataParameter> dataParameterMap = new ConcurrentHashMap();

	public Modchu_EntityOtherPlayerMP(HashMap<String, Object> map) {
		super((World)map.get("Object"), (GameProfile)map.get("Object1"));
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.lDebug("Modchu_EntityOtherPlayerMP init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IEntityOtherPlayerMPMaster ? (Modchu_IEntityOtherPlayerMPMaster) instance : null;
		if (master != null); else Modchu_Debug.lDebug("Modchu_EntityOtherPlayerMP init master == null !!");
	}

	@Override
	public ConcurrentHashMap getDataParameterMap() {
		return dataParameterMap;
	}

	@Override
	public boolean attackEntityFrom(DamageSource damageSource, float amount) {
		return master != null ? master.attackEntityFrom(damageSource, amount) : super.attackEntityFrom(damageSource, amount);
	}

	@Override
	public boolean superAttackEntityFrom(Object damageSource, float amount) {
		return super.attackEntityFrom((DamageSource) damageSource, amount);
	}

	@Override
	public void onUpdate() {
		if (master != null) master.onUpdate();
		else super.onUpdate();
	}

	@Override
	public void superOnUpdate() {
		super.onUpdate();
	}

	@Override
	public void onLivingUpdate() {
		if (master != null) master.onLivingUpdate();
		else super.onLivingUpdate();
	}

	@Override
	public void superOnLivingUpdate() {
		super.onLivingUpdate();
	}

	@Override
	public BlockPos getPosition() {
		return (BlockPos) (master != null ? master.getPosition() : super.getPosition());
	}

	@Override
	public BlockPos superGetPosition() {
		return super.getPosition();
	}

	@Override
	public boolean isSpectator() {
		return master != null ? master.isSpectator() : super.isSpectator();
	}

	@Override
	public boolean superIsSpectator() {
		return super.isSpectator();
	}

	@Override
	public boolean hasPlayerInfo() {
		return master != null ? master.hasPlayerInfo() : super.hasPlayerInfo();
	}

	@Override
	public boolean superHasPlayerInfo() {
		return super.hasPlayerInfo();
	}

	@Override
	protected NetworkPlayerInfo getPlayerInfo() {
		return (NetworkPlayerInfo) (master != null ? master.getPlayerInfo() : super.getPlayerInfo());
	}

	@Override
	public NetworkPlayerInfo superGetPlayerInfo() {
		return super.getPlayerInfo();
	}

	@Override
	public boolean hasSkin() {
		return master != null ? master.hasSkin() : super.hasSkin();
	}

	@Override
	public boolean superHasSkin() {
		return super.hasSkin();
	}

	@Override
	public ResourceLocation getLocationSkin() {
		return (ResourceLocation) (master != null ? master.getLocationSkin() : super.getLocationSkin());
	}

	@Override
	public ResourceLocation superGetLocationSkin() {
		return super.getLocationSkin();
	}

	@Override
	public ResourceLocation getLocationCape() {
		return (ResourceLocation) (master != null ? master.getLocationCape() : super.getLocationCape());
	}

	@Override
	public ResourceLocation superGetLocationCape() {
		return super.getLocationCape();
	}

	@Override
	public String getSkinType() {
		return master != null ? master.getSkinType() : super.getSkinType();
	}

	@Override
	public String superGetSkinType() {
		return super.getSkinType();
	}

	@Override
	public float getFovModifier() {
		return master != null ? master.getFovModifier() : super.getFovModifier();
	}

	@Override
	public float superGetFovModifier() {
		return super.getFovModifier();
	}

	@Override
	protected void applyEntityAttributes() {
		if (master != null) master.applyEntityAttributes();
		else super.applyEntityAttributes();
	}

	@Override
	public void superApplyEntityAttributes() {
		super.applyEntityAttributes();
	}

	@Override
	protected void entityInit() {
		if (master != null) master.entityInit();
		else super.entityInit();
	}

	@Override
	public void superEntityInit() {
		super.entityInit();
	}

	@Override
	public int getItemInUseCount() {
		return master != null ? master.getItemInUseCount() : super.getItemInUseCount();
	}

	@Override
	public int superGetItemInUseCount() {
		return super.getItemInUseCount();
	}

	@Override
	public int getMaxInPortalTime() {
		return master != null ? master.getMaxInPortalTime() : super.getMaxInPortalTime();
	}

	@Override
	public int superGetMaxInPortalTime() {
		return super.getMaxInPortalTime();
	}

	@Override
	protected SoundEvent getSwimSound() {
		return (SoundEvent) (master != null ? master.getSwimSound() : super.getSwimSound());
	}

	@Override
	public Object superGetSwimSound() {
		return super.getSwimSound();
	}

	@Override
	protected SoundEvent getSplashSound() {
		return (SoundEvent) (master != null ? master.getSplashSound() : super.getSplashSound());
	}

	@Override
	public Object superGetSplashSound() {
		return super.getSplashSound();
	}

	@Override
	public int getPortalCooldown() {
		return master != null ? master.getPortalCooldown() : super.getPortalCooldown();
	}

	@Override
	public int superGetPortalCooldown() {
		return super.getPortalCooldown();
	}

	@Override
	public void playSound(SoundEvent name, float volume, float pitch) {
		if (master != null) master.playSound(name, volume, pitch);
		else super.playSound(name, volume, pitch);
	}

	@Override
	public void superPlaySound(Object name, float volume, float pitch) {
		super.playSound((SoundEvent) name, volume, pitch);
	}

	@Override
	protected void updateItemUse(ItemStack itemStack, int p_71010_2_) {
		if (master != null) master.updateItemUse(itemStack, p_71010_2_);
		else super.updateItemUse(itemStack, p_71010_2_);
	}

	@Override
	public void superUpdateItemUse(Object itemStack, int p_71010_2_) {
		super.updateItemUse((ItemStack) itemStack, p_71010_2_);
	}

	@Override
	protected void onItemUseFinish() {
		if (master != null) master.onItemUseFinish();
		else super.onItemUseFinish();
	}

	@Override
	public void superOnItemUseFinish() {
		super.onItemUseFinish();
	}

	@Override
	public void handleStatusUpdate(byte p_70103_1_) {
		if (master != null) master.handleStatusUpdate(p_70103_1_);
		else super.handleStatusUpdate(p_70103_1_);
	}

	@Override
	public void superHandleStatusUpdate(byte p_70103_1_) {
		super.handleStatusUpdate(p_70103_1_);
	}

	@Override
	protected boolean isMovementBlocked() {
		return master != null ? master.isMovementBlocked() : super.isMovementBlocked();
	}

	@Override
	public boolean superIsMovementBlocked() {
		return super.isMovementBlocked();
	}

	@Override
	public void closeScreen() {
		if (master != null) master.closeScreen();
		else super.closeScreen();
	}

	@Override
	public void superCloseScreen() {
		super.closeScreen();
	}

	@Override
	public void updateRidden() {
		if (master != null) master.updateRidden();
		else super.updateRidden();
	}

	@Override
	public void superUpdateRidden() {
		super.updateRidden();
	}

	@Override
	public void preparePlayerToSpawn() {
		if (master != null) master.preparePlayerToSpawn();
		else super.preparePlayerToSpawn();
	}

	@Override
	public void superPreparePlayerToSpawn() {
		super.preparePlayerToSpawn();
	}

	@Override
	protected void updateEntityActionState() {
		if (master != null) master.updateEntityActionState();
		else super.updateEntityActionState();
	}

	@Override
	public void superUpdateEntityActionState() {
		super.updateEntityActionState();
	}

	@Override
	public int getScore() {
		return master != null ? master.getScore() : super.getScore();
	}

	@Override
	public int superGetScore() {
		return super.getScore();
	}

	@Override
	public void setScore(int p_85040_1_) {
		if (master != null) master.setScore(p_85040_1_);
		else super.setScore(p_85040_1_);
	}

	@Override
	public void superSetScore(int p_85040_1_) {
		super.setScore(p_85040_1_);
	}

	@Override
	public void addScore(int p_85039_1_) {
		if (master != null) master.addScore(p_85039_1_);
		else super.addScore(p_85039_1_);
	}

	@Override
	public void superAddScore(int p_85039_1_) {
		super.addScore(p_85039_1_);
	}

	@Override
	public void onDeath(DamageSource damageSource) {
		if (master != null) master.onDeath(damageSource);
		else super.onDeath(damageSource);
	}

	@Override
	public void superOnDeath(Object damageSource) {
		super.onDeath((DamageSource) damageSource);
	}

	@Override
	protected SoundEvent getHurtSound() {
		return (SoundEvent) (master != null ? master.getHurtSound() : super.getHurtSound());
	}

	@Override
	public Object superGetHurtSound() {
		return super.getHurtSound();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return (SoundEvent) (master != null ? master.getDeathSound() : super.getDeathSound());
	}

	@Override
	public Object superGetDeathSound() {
		return super.getDeathSound();
	}

	@Override
	public void addToPlayerScore(Entity entity, int amount) {
		if (master != null) master.addToPlayerScore(entity, amount);
		else super.addToPlayerScore(entity, amount);
	}

	@Override
	public void superAddToPlayerScore(Object entity, int amount) {
		super.addToPlayerScore((Entity) entity, amount);
	}

	@Override
	public EntityItem dropItem(ItemStack itemStack, boolean dropAround, boolean traceItem) {
		return (EntityItem) (master != null ? master.dropItem(itemStack, dropAround, traceItem) : super.dropItem(itemStack, dropAround, traceItem));
	}

	@Override
	public EntityItem superDropItem(Object itemStack, boolean dropAround, boolean traceItem) {
		return super.dropItem((ItemStack) itemStack, dropAround, traceItem);
	}

	@Override
	public ItemStack dropItemAndGetStack(EntityItem entityItem) {
		return (ItemStack) (master != null ? master.dropItemAndGetStack(entityItem) : super.dropItemAndGetStack(entityItem));
	}

	@Override
	public Object superDropItemAndGetStack(Object entityItem) {
		return super.dropItemAndGetStack((EntityItem) entityItem);
	}

	@Override
	public float getDigSpeed(IBlockState iBlockState) {
		return master != null ? master.getDigSpeed(iBlockState) : super.getDigSpeed(iBlockState);
	}

	@Override
	public float superGetDigSpeed(Object iBlockState) {
		return super.getDigSpeed((IBlockState) iBlockState);
	}

	@Override
	public float superGetDigSpeed(Object iBlockState, Object blockPos) {
		return 0.0F;
	}

	@Override
	public boolean canHarvestBlock(IBlockState iBlockState) {
		return master != null ? master.canHarvestBlock(iBlockState) : super.canHarvestBlock(iBlockState);
	}

	@Override
	public boolean superCanHarvestBlock(Object iBlockState) {
		return super.canHarvestBlock((IBlockState) iBlockState);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.readEntityFromNBT(nBTTagCompound);
		else super.readEntityFromNBT(nBTTagCompound);
	}

	@Override
	public void superReadEntityFromNBT(Object nBTTagCompound) {
		super.readEntityFromNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.writeEntityToNBT(nBTTagCompound);
		else super.writeEntityToNBT(nBTTagCompound);
	}

	@Override
	public void superWriteEntityToNBT(Object nBTTagCompound) {
		super.writeEntityToNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public boolean canAttackPlayer(EntityPlayer entityPlayer) {
		return master != null ? master.canAttackPlayer(entityPlayer) : super.canAttackPlayer(entityPlayer);
	}

	@Override
	public boolean superCanAttackPlayer(Object entityPlayer) {
		return super.canAttackPlayer((EntityPlayer) entityPlayer);
	}

	@Override
	protected void damageArmor(float p_70675_1_) {
		if (master != null) master.damageArmor(p_70675_1_);
		else super.damageArmor(p_70675_1_);
	}

	@Override
	public void superDamageArmor(float p_70675_1_) {
		super.damageArmor(p_70675_1_);
	}

	@Override
	public int getTotalArmorValue() {
		return master != null ? master.getTotalArmorValue() : super.getTotalArmorValue();
	}

	@Override
	public int superGetTotalArmorValue() {
		return super.getTotalArmorValue();
	}

	@Override
	public float getArmorVisibility() {
		return master != null ? master.getArmorVisibility() : super.getArmorVisibility();
	}

	@Override
	public float superGetArmorVisibility() {
		return super.getArmorVisibility();
	}

	@Override
	protected void damageEntity(DamageSource damageSource, float damageAmount) {
		if (master != null) master.damageEntity(damageSource, damageAmount);
		else super.damageEntity(damageSource, damageAmount);
	}

	@Override
	public void superDamageEntity(Object damageSource, float damageAmount) {
		super.damageEntity((DamageSource) damageSource, damageAmount);
	}

	@Override
	public void openEditSign(TileEntitySign tileEntitySign) {
		if (master != null) master.openEditSign(tileEntitySign);
		else super.openEditSign(tileEntitySign);
	}

	@Override
	public void superOpenEditSign(Object tileEntitySign) {
		super.openEditSign((TileEntitySign) tileEntitySign);
	}

	@Override
	public void displayGuiEditCommandCart(CommandBlockBaseLogic commandBlockBaseLogic) {
		if (master != null) master.displayGuiEditCommandCart(commandBlockBaseLogic);
		else super.displayGuiEditCommandCart(commandBlockBaseLogic);
	}

	@Override
	public void superDisplayGuiEditCommandCart(Object commandBlockBaseLogic) {
		super.displayGuiEditCommandCart((CommandBlockBaseLogic) commandBlockBaseLogic);
	}

	@Override
	public void displayVillagerTradeGui(IMerchant iMerchant) {
		if (master != null) master.displayVillagerTradeGui(iMerchant);
		else super.displayVillagerTradeGui(iMerchant);
	}

	@Override
	public void superDisplayVillagerTradeGui(Object iMerchant) {
		super.displayVillagerTradeGui((IMerchant) iMerchant);
	}

	@Override
	public void displayGUIChest(IInventory iInventory) {
		if (master != null) master.displayGUIChest(iInventory);
		else super.displayGUIChest(iInventory);
	}

	@Override
	public void superDisplayGUIChest(Object iInventory) {
		super.displayGUIChest((IInventory) iInventory);
	}

	@Override
	public void superOpenGuiHorseInventory(Object entityHorse, Object iInventory) {
		super.openGuiHorseInventory((EntityHorse) entityHorse, (IInventory) iInventory);
	}

	@Override
	public void displayGui(IInteractionObject iInteractionObject) {
		if (master != null) master.displayGui(iInteractionObject);
		else super.displayGui(iInteractionObject);
	}

	@Override
	public void superDisplayGui(Object iInteractionObject) {
		super.displayGui((IInteractionObject) iInteractionObject);
	}

	@Override
	public void openBook(ItemStack itemStack, EnumHand enumHand) {
		if (master != null) master.openBook(itemStack, enumHand);
		else super.openBook(itemStack, enumHand);
	}

	@Override
	public void superOpenBook(Object itemStack, Object enumHand) {
		super.openBook((ItemStack) itemStack, (EnumHand) enumHand);
	}

	@Override
	public ItemStack getHeldItemMainhand() {
		return (ItemStack) (master != null ? master.getHeldItemMainhand() : super.getHeldItemMainhand());
	}

	@Override
	public Object superGetHeldItemMainhand() {
		return super.getHeldItemMainhand();
	}

	@Override
	public double getYOffset() {
		return master != null ? master.getYOffset() : super.getYOffset();
	}

	@Override
	public double superGetYOffset() {
		return super.getYOffset();
	}

	@Override
	public void attackTargetEntityWithCurrentItem(Entity entity) {
		if (master != null) master.attackTargetEntityWithCurrentItem(entity);
		else super.attackTargetEntityWithCurrentItem(entity);
	}

	@Override
	public void superAttackTargetEntityWithCurrentItem(Object entity) {
		super.attackTargetEntityWithCurrentItem((Entity) entity);
	}

	@Override
	public void onCriticalHit(Entity entity) {
		if (master != null) master.onCriticalHit(entity);
		else super.onCriticalHit(entity);
	}

	@Override
	public void superOnCriticalHit(Object entity) {
		super.onCriticalHit((Entity) entity);
	}

	@Override
	public void onEnchantmentCritical(Entity entity) {
		if (master != null) master.onEnchantmentCritical(entity);
		else super.onEnchantmentCritical(entity);
	}

	@Override
	public void superOnEnchantmentCritical(Object entity) {
		super.onEnchantmentCritical((Entity) entity);
	}

	@Override
	public void respawnPlayer() {
		if (master != null) master.respawnPlayer();
		else super.respawnPlayer();
	}

	@Override
	public void superRespawnPlayer() {
		super.respawnPlayer();
	}

	@Override
	public void setDead() {
		if (master != null) master.setDead();
		else super.setDead();
	}

	@Override
	public void superSetDead() {
		super.setDead();
	}

	@Override
	public boolean isEntityInsideOpaqueBlock() {
		return master != null ? master.isEntityInsideOpaqueBlock() : super.isEntityInsideOpaqueBlock();
	}

	@Override
	public boolean superIsEntityInsideOpaqueBlock() {
		return super.isEntityInsideOpaqueBlock();
	}

	@Override
	public boolean isUser() {
		return master != null ? master.isUser() : super.isUser();
	}

	@Override
	public boolean superIsUser() {
		return super.isUser();
	}

	@Override
	public GameProfile getGameProfile() {
		return (GameProfile) (master != null ? master.getGameProfile() : super.getGameProfile());
	}

	@Override
	public GameProfile superGetGameProfile() {
		return super.getGameProfile();
	}

	@Override
	public void wakeUpPlayer(boolean p_70999_1_, boolean updateWorldFlag, boolean setSpawn) {
		if (master != null) master.wakeUpPlayer(p_70999_1_, updateWorldFlag, setSpawn);
		else super.wakeUpPlayer(p_70999_1_, updateWorldFlag, setSpawn);
	}

	@Override
	public void superWakeUpPlayer(boolean p_70999_1_, boolean updateWorldFlag, boolean setSpawn) {
		super.wakeUpPlayer(p_70999_1_, updateWorldFlag, setSpawn);
	}

	@Override
	public float getBedOrientationInDegrees() {
		return master != null ? master.getBedOrientationInDegrees() : super.getBedOrientationInDegrees();
	}

	@Override
	public float superGetBedOrientationInDegrees() {
		return super.getBedOrientationInDegrees();
	}

	@Override
	public boolean isPlayerSleeping() {
		return master != null ? master.isPlayerSleeping() : super.isPlayerSleeping();
	}

	@Override
	public boolean superIsPlayerSleeping() {
		return super.isPlayerSleeping();
	}

	@Override
	public boolean isPlayerFullyAsleep() {
		return master != null ? master.isPlayerFullyAsleep() : super.isPlayerFullyAsleep();
	}

	@Override
	public boolean superIsPlayerFullyAsleep() {
		return super.isPlayerFullyAsleep();
	}

	@Override
	public int getSleepTimer() {
		return master != null ? master.getSleepTimer() : super.getSleepTimer();
	}

	@Override
	public int superGetSleepTimer() {
		return super.getSleepTimer();
	}

	@Override
	public BlockPos getBedLocation() {
		return (BlockPos) (master != null ? master.getBedLocation() : super.getBedLocation());
	}

	@Override
	public BlockPos superGetBedLocation() {
		return super.getBedLocation();
	}

	@Override
	public boolean isSpawnForced() {
		return master != null ? master.isSpawnForced() : super.isSpawnForced();
	}

	@Override
	public boolean superIsSpawnForced() {
		return super.isSpawnForced();
	}

	@Override
	public void setSpawnPoint(BlockPos blockPos, boolean forced) {
		if (master != null) master.setSpawnPoint(blockPos, forced);
		else super.setSpawnPoint(blockPos, forced);
	}

	@Override
	public void superSetSpawnPoint(Object blockPos, boolean forced) {
		super.setSpawnPoint((BlockPos) blockPos, forced);
	}

	@Override
	public void addStat(StatBase statBase) {
		if (master != null) master.addStat(statBase);
		else super.addStat(statBase);
	}

	@Override
	public void superAddStat(Object statBase) {
		super.addStat((StatBase) statBase);
	}

	@Override
	public void addStat(StatBase statBase, int amount) {
		if (master != null) master.addStat(statBase, amount);
		else super.addStat(statBase, amount);
	}

	@Override
	public void superAddStat(Object statBase, int amount) {
		super.addStat((StatBase) statBase, amount);
	}

	@Override
	public void takeStat(StatBase statBase) {
		if (master != null) master.takeStat(statBase);
		else super.takeStat(statBase);
	}

	@Override
	public void superTakeStat(Object statBase) {
		super.takeStat((StatBase) statBase);
	}

	@Override
	public void jump() {
		if (master != null) master.jump();
		else super.jump();
	}

	@Override
	public void superJump() {
		super.jump();
	}

	@Override
	public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_) {
		if (master != null) master.moveEntityWithHeading(p_70612_1_, p_70612_2_);
		else super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
	}

	@Override
	public void superMoveEntityWithHeading(float p_70612_1_, float p_70612_2_) {
		super.moveEntityWithHeading(p_70612_1_, p_70612_2_);
	}

	@Override
	public float getAIMoveSpeed() {
		return master != null ? master.getAIMoveSpeed() : super.getAIMoveSpeed();
	}

	@Override
	public float superGetAIMoveSpeed() {
		return super.getAIMoveSpeed();
	}

	@Override
	public void addMovementStat(double p_71000_1_, double p_71000_3_, double p_71000_5_) {
		if (master != null) master.addMovementStat(p_71000_1_, p_71000_3_, p_71000_5_);
		else super.addMovementStat(p_71000_1_, p_71000_3_, p_71000_5_);
	}

	@Override
	public void superAddMovementStat(double p_71000_1_, double p_71000_3_, double p_71000_5_) {
		super.addMovementStat(p_71000_1_, p_71000_3_, p_71000_5_);
	}

	@Override
	public void fall(float distance, float damageMultiplier) {
		if (master != null) master.fall(distance, damageMultiplier);
		else super.fall(distance, damageMultiplier);
	}

	@Override
	public void superFall(float distance, float damageMultiplier) {
		super.fall(distance, damageMultiplier);
	}

	@Override
	protected void resetHeight() {
		if (master != null) master.resetHeight();
		else super.resetHeight();
	}

	@Override
	public void superResetHeight() {
		super.resetHeight();
	}

	@Override
	protected SoundEvent getFallSound(int damageValue) {
		return (SoundEvent) (master != null ? master.getFallSound(damageValue) : super.getFallSound(damageValue));
	}

	@Override
	public Object superGetFallSound(int damageValue) {
		return super.getFallSound(damageValue);
	}

	@Override
	public void onKillEntity(EntityLivingBase entityLivingBase) {
		if (master != null) master.onKillEntity(entityLivingBase);
		else super.onKillEntity(entityLivingBase);
	}

	@Override
	public void superOnKillEntity(Object entityLivingBase) {
		super.onKillEntity((EntityLivingBase) entityLivingBase);
	}

	@Override
	public void setInWeb() {
		if (master != null) master.setInWeb();
		else super.setInWeb();
	}

	@Override
	public void superSetInWeb() {
		super.setInWeb();
	}

	@Override
	public void addExperience(int amount) {
		if (master != null) master.addExperience(amount);
		else super.addExperience(amount);
	}

	@Override
	public void superAddExperience(int amount) {
		super.addExperience(amount);
	}

	@Override
	public int getXPSeed() {
		return master != null ? master.getXPSeed() : super.getXPSeed();
	}

	@Override
	public int superGetXPSeed() {
		return super.getXPSeed();
	}

	@Override
	public void removeExperienceLevel(int levels) {
		if (master != null) master.removeExperienceLevel(levels);
		else super.removeExperienceLevel(levels);
	}

	@Override
	public void superRemoveExperienceLevel(int levels) {
		super.removeExperienceLevel(levels);
	}

	@Override
	public void addExperienceLevel(int levels) {
		if (master != null) master.addExperienceLevel(levels);
		else super.addExperienceLevel(levels);
	}

	@Override
	public void superAddExperienceLevel(int levels) {
		super.addExperienceLevel(levels);
	}

	@Override
	public int xpBarCap() {
		return master != null ? master.xpBarCap() : super.xpBarCap();
	}

	@Override
	public int superXpBarCap() {
		return super.xpBarCap();
	}

	@Override
	public void addExhaustion(float p_71020_1_) {
		if (master != null) master.addExhaustion(p_71020_1_);
		else super.addExhaustion(p_71020_1_);
	}

	@Override
	public void superAddExhaustion(float p_71020_1_) {
		super.addExhaustion(p_71020_1_);
	}

	@Override
	public FoodStats getFoodStats() {
		return (FoodStats) (master != null ? master.getFoodStats() : super.getFoodStats());
	}

	@Override
	public FoodStats superGetFoodStats() {
		return super.getFoodStats();
	}

	@Override
	public boolean canEat(boolean ignoreHunger) {
		return master != null ? master.canEat(ignoreHunger) : super.canEat(ignoreHunger);
	}

	@Override
	public boolean superCanEat(boolean ignoreHunger) {
		return super.canEat(ignoreHunger);
	}

	@Override
	public boolean shouldHeal() {
		return master != null ? master.shouldHeal() : super.shouldHeal();
	}

	@Override
	public boolean superShouldHeal() {
		return super.shouldHeal();
	}

	@Override
	public boolean isAllowEdit() {
		return master != null ? master.isAllowEdit() : super.isAllowEdit();
	}

	@Override
	public boolean superIsAllowEdit() {
		return super.isAllowEdit();
	}

	@Override
	public boolean canPlayerEdit(BlockPos blockPos, EnumFacing enumFacing, ItemStack itemStack) {
		return master != null ? master.canPlayerEdit(blockPos, enumFacing, itemStack) : super.canPlayerEdit(blockPos, enumFacing, itemStack);
	}

	@Override
	public boolean superCanPlayerEdit(Object blockPos, Object enumFacing, Object itemStack) {
		return super.canPlayerEdit((BlockPos) blockPos, (EnumFacing) enumFacing, (ItemStack) itemStack);
	}

	@Override
	protected int getExperiencePoints(EntityPlayer entityPlayer) {
		return master != null ? master.getExperiencePoints(entityPlayer) : super.getExperiencePoints(entityPlayer);
	}

	@Override
	public int superGetExperiencePoints(Object entityPlayer) {
		return super.getExperiencePoints((EntityPlayer) entityPlayer);
	}

	@Override
	protected boolean isPlayer() {
		return master != null ? master.isPlayer() : super.isPlayer();
	}

	@Override
	public boolean superIsPlayer() {
		return super.isPlayer();
	}

	@Override
	public boolean getAlwaysRenderNameTagForRender() {
		return master != null ? master.getAlwaysRenderNameTagForRender() : super.getAlwaysRenderNameTagForRender();
	}

	@Override
	public boolean superGetAlwaysRenderNameTagForRender() {
		return super.getAlwaysRenderNameTagForRender();
	}

	@Override
	public void clonePlayer(EntityPlayer entityPlayer, boolean respawnFromEnd) {
		if (master != null) master.clonePlayer(entityPlayer, respawnFromEnd);
		else super.clonePlayer(entityPlayer, respawnFromEnd);
	}

	@Override
	public void superClonePlayer(Object entityPlayer, boolean respawnFromEnd) {
		super.clonePlayer((EntityPlayer) entityPlayer, respawnFromEnd);
	}

	@Override
	protected boolean canTriggerWalking() {
		return master != null ? master.canTriggerWalking() : super.canTriggerWalking();
	}

	@Override
	public boolean superCanTriggerWalking() {
		return super.canTriggerWalking();
	}

	@Override
	public void sendPlayerAbilities() {
		if (master != null) master.sendPlayerAbilities();
		else super.sendPlayerAbilities();
	}

	@Override
	public void superSendPlayerAbilities() {
		super.sendPlayerAbilities();
	}

	@Override
	public String getName() {
		return master != null ? master.getName() : super.getName();
	}

	public String supergetName() {
		return super.getName();
	}

	@Override
	public InventoryEnderChest getInventoryEnderChest() {
		return (InventoryEnderChest) (master != null ? master.getInventoryEnderChest() : super.getInventoryEnderChest());
	}

	@Override
	public InventoryEnderChest superGetInventoryEnderChest() {
		return super.getInventoryEnderChest();
	}

	@Override
	public ItemStack getItemStackFromSlot(EntityEquipmentSlot entityEquipmentSlot) {
		return (ItemStack) (master != null ? master.getItemStackFromSlot(entityEquipmentSlot) : super.getItemStackFromSlot(entityEquipmentSlot));
	}

	@Override
	public Object superGetItemStackFromSlot(Object entityEquipmentSlot) {
		return super.getItemStackFromSlot((EntityEquipmentSlot) entityEquipmentSlot);
	}

	@Override
	public ItemStack superGetHeldItem() {
		return super.getHeldItemMainhand();
	}

	@Override
	public boolean isInvisibleToPlayer(EntityPlayer entityPlayer) {
		return master != null ? master.isInvisibleToPlayer(entityPlayer) : super.isInvisibleToPlayer(entityPlayer);
	}

	@Override
	public boolean superIsInvisibleToPlayer(Object entityPlayer) {
		return super.isInvisibleToPlayer((EntityPlayer) entityPlayer);
	}

	@Override
	public boolean isPushedByWater() {
		return master != null ? master.isPushedByWater() : super.isPushedByWater();
	}

	@Override
	public boolean superIsPushedByWater() {
		return super.isPushedByWater();
	}

	@Override
	public Scoreboard getWorldScoreboard() {
		return (Scoreboard) (master != null ? master.getWorldScoreboard() : super.getWorldScoreboard());
	}

	@Override
	public Scoreboard superGetWorldScoreboard() {
		return super.getWorldScoreboard();
	}

	@Override
	public Team getTeam() {
		return (Team) (master != null ? master.getTeam() : super.getTeam());
	}

	@Override
	public Team superGetTeam() {
		return super.getTeam();
	}

	@Override
	public ITextComponent getDisplayName() {
		return (ITextComponent) (master != null ? master.getDisplayName() : super.getDisplayName());
	}

	@Override
	public ITextComponent superGetDisplayName() {
		return super.getDisplayName();
	}

	@Override
	public float getEyeHeight() {
		return master != null ? master.getEyeHeight() : super.getEyeHeight();
	}

	@Override
	public float superGetEyeHeight() {
		return super.getEyeHeight();
	}

	@Override
	public void setAbsorptionAmount(float amount) {
		if (master != null) master.setAbsorptionAmount(amount);
		else super.setAbsorptionAmount(amount);
	}

	@Override
	public void superSetAbsorptionAmount(float amount) {
		super.setAbsorptionAmount(amount);
	}

	@Override
	public float getAbsorptionAmount() {
		return master != null ? master.getAbsorptionAmount() : super.getAbsorptionAmount();
	}

	@Override
	public float superGetAbsorptionAmount() {
		return super.getAbsorptionAmount();
	}

	@Override
	public boolean canOpen(LockCode lockCode) {
		return master != null ? master.canOpen(lockCode) : super.canOpen(lockCode);
	}

	@Override
	public boolean superCanOpen(Object lockCode) {
		return super.canOpen((LockCode) lockCode);
	}

	@Override
	public boolean isWearing(EnumPlayerModelParts enumPlayerModelParts) {
		return master != null ? master.isWearing(enumPlayerModelParts) : super.isWearing(enumPlayerModelParts);
	}

	@Override
	public boolean superIsWearing(Object enumPlayerModelParts) {
		return super.isWearing((EnumPlayerModelParts) enumPlayerModelParts);
	}

	@Override
	public boolean sendCommandFeedback() {
		return master != null ? master.sendCommandFeedback() : super.sendCommandFeedback();
	}

	@Override
	public boolean superSendCommandFeedback() {
		return super.sendCommandFeedback();
	}

	@Override
	public boolean replaceItemInInventory(int p_174820_1_, ItemStack itemStack) {
		return master != null ? master.replaceItemInInventory(p_174820_1_, itemStack) : super.replaceItemInInventory(p_174820_1_, itemStack);
	}

	@Override
	public boolean superReplaceItemInInventory(int p_174820_1_, Object itemStack) {
		return super.replaceItemInInventory(p_174820_1_, (ItemStack) itemStack);
	}

	@Override
	public boolean hasReducedDebug() {
		return master != null ? master.hasReducedDebug() : super.hasReducedDebug();
	}

	@Override
	public boolean superHasReducedDebug() {
		return super.hasReducedDebug();
	}

	@Override
	public void setReducedDebug(boolean reducedDebug) {
		if (master != null) master.setReducedDebug(reducedDebug);
		else super.setReducedDebug(reducedDebug);
	}

	@Override
	public void superSetReducedDebug(boolean reducedDebug) {
		super.setReducedDebug(reducedDebug);
	}

	@Override
	public void openGui(Object mod, int modGuiId, World world, int x, int y, int z) {
		if (master != null) master.openGui(mod, modGuiId, world, x, y, z);
		else super.openGui(mod, modGuiId, world, x, y, z);
	}

	@Override
	public void superOpenGui(Object mod, int modGuiId, Object world, int x, int y, int z) {
		super.openGui(mod, modGuiId, (World) world, x, y, z);
	}

	@Override
	public BlockPos getBedLocation(int dimension) {
		return (BlockPos) (master != null ? master.getBedLocation(dimension) : super.getBedLocation(dimension));
	}

	@Override
	public BlockPos superGetBedLocation(int dimension) {
		return super.getBedLocation(dimension);
	}

	@Override
	public boolean isSpawnForced(int dimension) {
		return master != null ? master.isSpawnForced(dimension) : super.isSpawnForced(dimension);
	}

	@Override
	public boolean superIsSpawnForced(int dimension) {
		return super.isSpawnForced(dimension);
	}

	@Override
	public void setSpawnChunk(BlockPos blockPos, boolean forced, int dimension) {
		if (master != null) master.setSpawnChunk(blockPos, forced, dimension);
		else super.setSpawnChunk(blockPos, forced, dimension);
	}

	@Override
	public void superSetSpawnChunk(Object blockPos, boolean forced, int dimension) {
		super.setSpawnChunk((BlockPos) blockPos, forced, dimension);
	}

	@Override
	public float getDefaultEyeHeight() {
		return master != null ? master.getDefaultEyeHeight() : super.getDefaultEyeHeight();
	}

	@Override
	public float superGetDefaultEyeHeight() {
		return super.getDefaultEyeHeight();
	}

	@Override
	public String getDisplayNameString() {
		return master != null ? master.getDisplayNameString() : super.getDisplayNameString();
	}

	@Override
	public String superGetDisplayNameString() {
		return super.getDisplayNameString();
	}

	@Override
	public void refreshDisplayName() {
		if (master != null) master.refreshDisplayName();
		else super.refreshDisplayName();
	}

	@Override
	public void superRefreshDisplayName() {
		super.refreshDisplayName();
	}

	@Override
	public void onKillCommand() {
		if (master != null) master.onKillCommand();
		else super.onKillCommand();
	}

	@Override
	public void superOnKillCommand() {
		super.onKillCommand();
	}

	@Override
	protected void updateFallState(double p_180433_1_, boolean p_180433_3_, IBlockState iBlockState, BlockPos blockPos) {
		if (master != null) master.updateFallState(p_180433_1_, p_180433_3_, iBlockState, blockPos);
		else super.updateFallState(p_180433_1_, p_180433_3_, iBlockState, blockPos);
	}

	@Override
	public void superUpdateFallState(double p_180433_1_, boolean p_180433_3_, Object iBlockState, Object blockPos) {
		super.updateFallState(p_180433_1_, p_180433_3_, (IBlockState) iBlockState, (BlockPos) blockPos);
	}

	@Override
	public boolean canBreatheUnderwater() {
		return master != null ? master.canBreatheUnderwater() : super.canBreatheUnderwater();
	}

	@Override
	public boolean superCanBreatheUnderwater() {
		return super.canBreatheUnderwater();
	}

	@Override
	public void onEntityUpdate() {
		if (master != null) master.onEntityUpdate();
		else super.onEntityUpdate();
	}

	@Override
	public void superOnEntityUpdate() {
		super.onEntityUpdate();
	}

	@Override
	public boolean isChild() {
		return master != null ? master.isChild() : super.isChild();
	}

	@Override
	public boolean superIsChild() {
		return super.isChild();
	}

	@Override
	protected void onDeathUpdate() {
		if (master != null) master.onDeathUpdate();
		else super.onDeathUpdate();
	}

	@Override
	public void superOnDeathUpdate() {
		super.onDeathUpdate();
	}

	@Override
	protected boolean canDropLoot() {
		return master != null ? master.canDropLoot() : super.canDropLoot();
	}

	@Override
	public boolean superCanDropLoot() {
		return super.canDropLoot();
	}

	@Override
	protected int decreaseAirSupply(int p_70682_1_) {
		return master != null ? master.decreaseAirSupply(p_70682_1_) : super.decreaseAirSupply(p_70682_1_);
	}

	@Override
	public int superDecreaseAirSupply(int p_70682_1_) {
		return super.decreaseAirSupply(p_70682_1_);
	}

	@Override
	public Random getRNG() {
		return master != null ? master.getRNG() : super.getRNG();
	}

	@Override
	public Random superGetRNG() {
		return super.getRNG();
	}

	@Override
	public EntityLivingBase getAITarget() {
		return (EntityLivingBase) (master != null ? master.getAITarget() : super.getAITarget());
	}

	@Override
	public EntityLivingBase superGetAITarget() {
		return super.getAITarget();
	}

	@Override
	public int getRevengeTimer() {
		return master != null ? master.getRevengeTimer() : super.getRevengeTimer();
	}

	@Override
	public int superGetRevengeTimer() {
		return super.getRevengeTimer();
	}

	@Override
	public void setRevengeTarget(EntityLivingBase entityLivingBase) {
		if (master != null) master.setRevengeTarget(entityLivingBase);
		else super.setRevengeTarget(entityLivingBase);
	}

	@Override
	public void superSetRevengeTarget(Object entityLivingBase) {
		super.setRevengeTarget((EntityLivingBase) entityLivingBase);
	}

	@Override
	public EntityLivingBase getLastAttacker() {
		return (EntityLivingBase) (master != null ? master.getLastAttacker() : super.getLastAttacker());
	}

	@Override
	public EntityLivingBase superGetLastAttacker() {
		return super.getLastAttacker();
	}

	@Override
	public int getLastAttackerTime() {
		return master != null ? master.getLastAttackerTime() : super.getLastAttackerTime();
	}

	@Override
	public int superGetLastAttackerTime() {
		return super.getLastAttackerTime();
	}

	@Override
	public void setLastAttacker(Entity entity) {
		if (master != null) master.setLastAttacker(entity);
		else super.setLastAttacker(entity);
	}

	@Override
	public void superSetLastAttacker(Object entity) {
		super.setLastAttacker((Entity) entity);
	}

	@Override
	public int getAge() {
		return master != null ? master.getAge() : super.getAge();
	}

	@Override
	public int superGetAge() {
		return super.getAge();
	}

	@Override
	protected void updatePotionEffects() {
		if (master != null) master.updatePotionEffects();
		else super.updatePotionEffects();
	}

	@Override
	public void superUpdatePotionEffects() {
		super.updatePotionEffects();
	}

	@Override
	protected void updatePotionMetadata() {
		if (master != null) master.updatePotionMetadata();
		else super.updatePotionMetadata();
	}

	@Override
	public void superUpdatePotionMetadata() {
		super.updatePotionMetadata();
	}

	@Override
	protected void resetPotionEffectMetadata() {
		if (master != null) master.resetPotionEffectMetadata();
		else super.resetPotionEffectMetadata();
	}

	@Override
	public void superResetPotionEffectMetadata() {
		super.resetPotionEffectMetadata();
	}

	@Override
	public void clearActivePotions() {
		if (master != null) master.clearActivePotions();
		else super.clearActivePotions();
	}

	@Override
	public void superClearActivePotions() {
		super.clearActivePotions();
	}

	@Override
	public Collection getActivePotionEffects() {
		return (Collection) (master != null ? master.getActivePotionEffects() : super.getActivePotionEffects());
	}

	@Override
	public Collection superGetActivePotionEffects() {
		return super.getActivePotionEffects();
	}

	@Override
	public boolean isPotionActive(Potion potion) {
		return master != null ? master.isPotionActive(potion) : super.isPotionActive(potion);
	}

	@Override
	public boolean superIsPotionActive(Object potion) {
		return super.isPotionActive((Potion) potion);
	}

	@Override
	public PotionEffect getActivePotionEffect(Potion potion) {
		return (PotionEffect) (master != null ? master.getActivePotionEffect(potion) : super.getActivePotionEffect(potion));
	}

	@Override
	public PotionEffect superGetActivePotionEffect(Object potion) {
		return super.getActivePotionEffect((Potion) potion);
	}

	@Override
	public void addPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.addPotionEffect(potionEffect);
		else super.addPotionEffect(potionEffect);
	}

	@Override
	public void superAddPotionEffect(Object potionEffect) {
		super.addPotionEffect((PotionEffect) potionEffect);
	}

	@Override
	public boolean isPotionApplicable(PotionEffect potionEffect) {
		return master != null ? master.isPotionApplicable(potionEffect) : super.isPotionApplicable(potionEffect);
	}

	@Override
	public boolean superIsPotionApplicable(Object potionEffect) {
		return super.isPotionApplicable((PotionEffect) potionEffect);
	}

	@Override
	public boolean isEntityUndead() {
		return master != null ? master.isEntityUndead() : super.isEntityUndead();
	}

	@Override
	public boolean superIsEntityUndead() {
		return super.isEntityUndead();
	}

	@Override
	public PotionEffect removeActivePotionEffect(Potion potion) {
		return (PotionEffect) (master != null ? master.removeActivePotionEffect(potion) : super.removeActivePotionEffect(potion));
	}

	@Override
	public Object superRemoveActivePotionEffect(Object potion) {
		return super.removeActivePotionEffect((Potion) potion);
	}

	@Override
	public void removePotionEffect(Potion potion) {
		if (master != null) master.removePotionEffect(potion);
		else super.removePotionEffect(potion);
	}

	@Override
	public void superRemovePotionEffect(Object potion) {
		super.removePotionEffect((Potion) potion);
	}

	@Override
	protected void onNewPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.onNewPotionEffect(potionEffect);
		else super.onNewPotionEffect(potionEffect);
	}

	@Override
	public void superOnNewPotionEffect(Object potionEffect) {
		super.onNewPotionEffect((PotionEffect) potionEffect);
	}

	@Override
	protected void onChangedPotionEffect(PotionEffect potionEffect, boolean p_70695_2_) {
		if (master != null) master.onChangedPotionEffect(potionEffect, p_70695_2_);
		else super.onChangedPotionEffect(potionEffect, p_70695_2_);
	}

	@Override
	public void superOnChangedPotionEffect(Object potionEffect, boolean p_70695_2_) {
		super.onChangedPotionEffect((PotionEffect) potionEffect, p_70695_2_);
	}

	@Override
	protected void onFinishedPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.onFinishedPotionEffect(potionEffect);
		else super.onFinishedPotionEffect(potionEffect);
	}

	@Override
	public void superOnFinishedPotionEffect(Object potionEffect) {
		super.onFinishedPotionEffect((PotionEffect) potionEffect);
	}

	@Override
	public void heal(float healAmount) {
		if (master != null) master.heal(healAmount);
		else super.heal(healAmount);
	}

	@Override
	public void superHeal(float healAmount) {
		super.heal(healAmount);
	}

	@Override
	public void setHealth(float p_70606_1_) {
		if (master != null) master.setHealth(p_70606_1_);
		else super.setHealth(p_70606_1_);
	}

	@Override
	public void superSetHealth(float p_70606_1_) {
		super.setHealth(p_70606_1_);
	}

	@Override
	public void renderBrokenItemStack(ItemStack itemStack) {
		if (master != null) master.renderBrokenItemStack(itemStack);
		else super.renderBrokenItemStack(itemStack);
	}

	@Override
	public void superRenderBrokenItemStack(Object itemStack) {
		super.renderBrokenItemStack((ItemStack) itemStack);
	}

	@Override
	protected void dropEquipment(boolean p_82160_1_, int p_82160_2_) {
		if (master != null) master.dropEquipment(p_82160_1_, p_82160_2_);
		else super.dropEquipment(p_82160_1_, p_82160_2_);
	}

	@Override
	public void superDropEquipment(boolean p_82160_1_, int p_82160_2_) {
		super.dropEquipment(p_82160_1_, p_82160_2_);
	}

	@Override
	public void knockBack(Entity entity, float p_70653_2_, double p_70653_3_, double p_70653_5_) {
		if (master != null) master.knockBack(entity, p_70653_2_, p_70653_3_, p_70653_5_);
		else super.knockBack(entity, p_70653_2_, p_70653_3_, p_70653_5_);
	}

	@Override
	public void superKnockBack(Object entity, float p_70653_2_, double p_70653_3_, double p_70653_5_) {
		super.knockBack((Entity) entity, p_70653_2_, p_70653_3_, p_70653_5_);
	}

	@Override
	protected void dropLoot(boolean p_184610_1_, int p_184610_2_, DamageSource damageSource) {
		if (master != null) master.dropLoot(p_184610_1_, p_184610_2_, damageSource);
		else super.dropLoot(p_184610_1_, p_184610_2_, damageSource);
	}

	@Override
	public void superDropLoot(boolean p_184610_1_, int p_184610_2_, Object damageSource) {
		super.dropLoot(p_184610_1_, p_184610_2_, (DamageSource) damageSource);
	}

	@Override
	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		if (master != null) master.dropFewItems(p_70628_1_, p_70628_2_);
		else super.dropFewItems(p_70628_1_, p_70628_2_);
	}

	@Override
	public void superDropFewItems(boolean p_70628_1_, int p_70628_2_) {
		super.dropFewItems(p_70628_1_, p_70628_2_);
	}

	@Override
	public boolean isOnLadder() {
		return master != null ? master.isOnLadder() : super.isOnLadder();
	}

	@Override
	public boolean superIsOnLadder() {
		return super.isOnLadder();
	}

	@Override
	public boolean isEntityAlive() {
		return master != null ? master.isEntityAlive() : super.isEntityAlive();
	}

	@Override
	public boolean superIsEntityAlive() {
		return super.isEntityAlive();
	}

	@Override
	public void performHurtAnimation() {
		if (master != null) master.performHurtAnimation();
		else super.performHurtAnimation();
	}

	@Override
	public void superPerformHurtAnimation() {
		super.performHurtAnimation();
	}

	@Override
	protected float applyArmorCalculations(DamageSource damageSource, float p_70655_2_) {
		return (Float) (master != null ? master.applyArmorCalculations(damageSource, p_70655_2_) : super.applyArmorCalculations(damageSource, p_70655_2_));
	}

	@Override
	public Object superApplyArmorCalculations(Object damageSource, float p_70655_2_) {
		return super.applyArmorCalculations((DamageSource) damageSource, p_70655_2_);
	}

	@Override
	protected float applyPotionDamageCalculations(DamageSource damageSource, float p_70672_2_) {
		return (Float) (master != null ? master.applyPotionDamageCalculations(damageSource, p_70672_2_) : super.applyPotionDamageCalculations(damageSource, p_70672_2_));
	}

	@Override
	public Object superApplyPotionDamageCalculations(Object damageSource, float p_70672_2_) {
		return super.applyPotionDamageCalculations((DamageSource) damageSource, p_70672_2_);
	}

	@Override
	public CombatTracker getCombatTracker() {
		return (CombatTracker) (master != null ? master.getCombatTracker() : super.getCombatTracker());
	}

	@Override
	public CombatTracker superGetCombatTracker() {
		return super.getCombatTracker();
	}

	@Override
	public EntityLivingBase getAttackingEntity() {
		return (EntityLivingBase) (master != null ? master.getAttackingEntity() : super.getAttackingEntity());
	}

	@Override
	public EntityLivingBase superGetAttackingEntity() {
		return super.getAttackingEntity();
	}

	@Override
	public void swingArm(EnumHand enumHand) {
		if (master != null) master.swingArm(enumHand);
		else super.swingArm(enumHand);
	}

	@Override
	public void superSwingArm(Object enumHand) {
		super.swingArm((EnumHand) enumHand);
	}

	@Override
	protected void kill() {
		if (master != null) master.kill();
		else super.kill();
	}

	@Override
	public void superKill() {
		super.kill();
	}

	@Override
	protected void updateArmSwingProgress() {
		if (master != null) master.updateArmSwingProgress();
		else super.updateArmSwingProgress();
	}

	@Override
	public void superUpdateArmSwingProgress() {
		super.updateArmSwingProgress();
	}

	@Override
	public IAttributeInstance getEntityAttribute(IAttribute iAttribute) {
		return (IAttributeInstance) (master != null ? master.getEntityAttribute(iAttribute) : super.getEntityAttribute(iAttribute));
	}

	@Override
	public IAttributeInstance superGetEntityAttribute(Object iAttribute) {
		return super.getEntityAttribute((IAttribute) iAttribute);
	}

	@Override
	public AbstractAttributeMap getAttributeMap() {
		return (AbstractAttributeMap) (master != null ? master.getAttributeMap() : super.getAttributeMap());
	}

	@Override
	public Object superGetAttributeMap() {
		return super.getAttributeMap();
	}

	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return (EnumCreatureAttribute) (master != null ? master.getCreatureAttribute() : super.getCreatureAttribute());
	}

	@Override
	public EnumCreatureAttribute superGetCreatureAttribute() {
		return super.getCreatureAttribute();
	}

	@Override
	public void setSprinting(boolean sprinting) {
		if (master != null) master.setSprinting(sprinting);
		else super.setSprinting(sprinting);
	}

	@Override
	public void superSetSprinting(boolean sprinting) {
		super.setSprinting(sprinting);
	}

	@Override
	protected float getSoundVolume() {
		return master != null ? master.getSoundVolume() : super.getSoundVolume();
	}

	@Override
	public float superGetSoundVolume() {
		return super.getSoundVolume();
	}

	@Override
	protected float getSoundPitch() {
		return master != null ? master.getSoundPitch() : super.getSoundPitch();
	}

	@Override
	public float superGetSoundPitch() {
		return super.getSoundPitch();
	}

	@Override
	public void dismountEntity(Entity entity) {
		if (master != null) master.dismountEntity(entity);
		else super.dismountEntity(entity);
	}

	@Override
	public void superDismountEntity(Object entity) {
		super.dismountEntity((Entity) entity);
	}

	@Override
	protected float getJumpUpwardsMotion() {
		return master != null ? master.getJumpUpwardsMotion() : super.getJumpUpwardsMotion();
	}

	@Override
	public float superGetJumpUpwardsMotion() {
		return super.getJumpUpwardsMotion();
	}

	@Override
	protected void handleJumpLava() {
		if (master != null) master.handleJumpLava();
		else super.handleJumpLava();
	}

	@Override
	public void superHandleJumpLava() {
		super.handleJumpLava();
	}

	@Override
	public void setAIMoveSpeed(float p_70659_1_) {
		if (master != null) master.setAIMoveSpeed(p_70659_1_);
		else super.setAIMoveSpeed(p_70659_1_);
	}

	@Override
	public void superSetAIMoveSpeed(float p_70659_1_) {
		super.setAIMoveSpeed(p_70659_1_);
	}

	@Override
	public boolean attackEntityAsMob(Entity entity) {
		return master != null ? master.attackEntityAsMob(entity) : super.attackEntityAsMob(entity);
	}

	@Override
	public boolean superAttackEntityAsMob(Object entity) {
		return super.attackEntityAsMob((Entity) entity);
	}

	@Override
	protected float updateDistance(float p_110146_1_, float p_110146_2_) {
		return master != null ? master.updateDistance(p_110146_1_, p_110146_2_) : super.updateDistance(p_110146_1_, p_110146_2_);
	}

	@Override
	public float superUpdateDistance(float p_110146_1_, float p_110146_2_) {
		return super.updateDistance(p_110146_1_, p_110146_2_);
	}

	@Override
	protected void collideWithNearbyEntities() {
		if (master != null) master.collideWithNearbyEntities();
		else super.collideWithNearbyEntities();
	}

	@Override
	public void superCollideWithNearbyEntities() {
		super.collideWithNearbyEntities();
	}

	@Override
	protected void collideWithEntity(Entity entity) {
		if (master != null) master.collideWithEntity(entity);
		else super.collideWithEntity(entity);
	}

	@Override
	public void superCollideWithEntity(Object entity) {
		super.collideWithEntity((Entity) entity);
	}

	@Override
	public boolean startRiding(Entity entity) {
		return master != null ? master.startRiding(entity) : super.startRiding(entity);
	}

	@Override
	public boolean superStartRiding(Object entity) {
		return super.startRiding((Entity) entity);
	}

	@Override
	public void setJumping(boolean p_70637_1_) {
		if (master != null) master.setJumping(p_70637_1_);
		else super.setJumping(p_70637_1_);
	}

	@Override
	public void superSetJumping(boolean p_70637_1_) {
		super.setJumping(p_70637_1_);
	}

	@Override
	public void onItemPickup(Entity entity, int p_71001_2_) {
		if (master != null) master.onItemPickup(entity, p_71001_2_);
		else super.onItemPickup(entity, p_71001_2_);
	}

	@Override
	public void superOnItemPickup(Object entity, int p_71001_2_) {
		super.onItemPickup((Entity) entity, p_71001_2_);
	}

	@Override
	public boolean canEntityBeSeen(Entity entity) {
		return master != null ? master.canEntityBeSeen(entity) : super.canEntityBeSeen(entity);
	}

	@Override
	public boolean superCanEntityBeSeen(Object entity) {
		return super.canEntityBeSeen((Entity) entity);
	}

	@Override
	public Vec3d getLookVec() {
		return (Vec3d) (master != null ? master.getLookVec() : super.getLookVec());
	}

	@Override
	public Object superGetLookVec() {
		return super.getLookVec();
	}

	@Override
	public Vec3d getLook(float p_70676_1_) {
		return (Vec3d) (master != null ? master.getLook(p_70676_1_) : super.getLook(p_70676_1_));
	}

	@Override
	public Object superGetLook(float p_70676_1_) {
		return super.getLook(p_70676_1_);
	}

	@Override
	public float getSwingProgress(float p_70678_1_) {
		return master != null ? master.getSwingProgress(p_70678_1_) : super.getSwingProgress(p_70678_1_);
	}

	@Override
	public float superGetSwingProgress(float p_70678_1_) {
		return super.getSwingProgress(p_70678_1_);
	}

	@Override
	public boolean isServerWorld() {
		return master != null ? master.isServerWorld() : super.isServerWorld();
	}

	@Override
	public boolean superIsServerWorld() {
		return super.isServerWorld();
	}

	@Override
	public boolean canBeCollidedWith() {
		return master != null ? master.canBeCollidedWith() : super.canBeCollidedWith();
	}

	@Override
	public boolean superCanBeCollidedWith() {
		return super.canBeCollidedWith();
	}

	@Override
	public boolean canBePushed() {
		return master != null ? master.canBePushed() : super.canBePushed();
	}

	@Override
	public boolean superCanBePushed() {
		return super.canBePushed();
	}

	@Override
	protected void setBeenAttacked() {
		if (master != null) master.setBeenAttacked();
		else super.setBeenAttacked();
	}

	@Override
	public void superSetBeenAttacked() {
		super.setBeenAttacked();
	}

	@Override
	public float getRotationYawHead() {
		return master != null ? master.getRotationYawHead() : super.getRotationYawHead();
	}

	@Override
	public float superGetRotationYawHead() {
		return super.getRotationYawHead();
	}

	@Override
	public void setRotationYawHead(float rotation) {
		if (master != null) master.setRotationYawHead(rotation);
		else super.setRotationYawHead(rotation);
	}

	@Override
	public void superSetRotationYawHead(float rotation) {
		super.setRotationYawHead(rotation);
	}

	@Override
	public boolean isOnSameTeam(Entity entity) {
		return master != null ? master.isOnSameTeam(entity) : super.isOnSameTeam(entity);
	}

	@Override
	public boolean superIsOnSameTeam(Object entity) {
		return super.isOnSameTeam((Entity) entity);
	}

	@Override
	public void sendEnterCombat() {
		if (master != null) master.sendEnterCombat();
		else super.sendEnterCombat();
	}

	@Override
	public void superSendEnterCombat() {
		super.sendEnterCombat();
	}

	@Override
	public void sendEndCombat() {
		if (master != null) master.sendEndCombat();
		else super.sendEndCombat();
	}

	@Override
	public void superSendEndCombat() {
		super.sendEndCombat();
	}

	@Override
	protected void markPotionsDirty() {
		if (master != null) master.markPotionsDirty();
		else super.markPotionsDirty();
	}

	@Override
	public void superMarkPotionsDirty() {
		super.markPotionsDirty();
	}

	@Override
	public void curePotionEffects(ItemStack itemStack) {
		if (master != null) master.curePotionEffects(itemStack);
		else super.curePotionEffects(itemStack);
	}

	@Override
	public void superCurePotionEffects(Object itemStack) {
		super.curePotionEffects((ItemStack) itemStack);
	}

	@Override
	public boolean shouldRiderFaceForward(EntityPlayer entityPlayer) {
		return master != null ? master.shouldRiderFaceForward(entityPlayer) : super.shouldRiderFaceForward(entityPlayer);
	}

	@Override
	public boolean superShouldRiderFaceForward(Object entityPlayer) {
		return super.shouldRiderFaceForward((EntityPlayer) entityPlayer);
	}

	@Override
	public int getEntityId() {
		return master != null ? master.getEntityId() : super.getEntityId();
	}

	@Override
	public int superGetEntityId() {
		return super.getEntityId();
	}

	@Override
	public void setEntityId(int id) {
		if (master != null) master.setEntityId(id);
		else super.setEntityId(id);
	}

	@Override
	public void superSetEntityId(int id) {
		super.setEntityId(id);
	}

	@Override
	public EntityDataManager getDataManager() {
		return (EntityDataManager) (master != null ? master.getDataManager() : super.getDataManager());
	}

	@Override
	public Object superGetDataManager() {
		return super.getDataManager();
	}
/*
	@Override
	public boolean equals(Object p_equals_1_) {
		return master != null ? master.equals(p_equals_1_) : super.equals(p_equals_1_);
	}

	public boolean superEquals(Object p_equals_1_) {
		return super.equals(p_equals_1_);
	}

	@Override
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

	@Override
	public void superSetSize(float width, float height) {
		super.setSize(width, height);
	}

	@Override
	protected void setRotation(float yaw, float pitch) {
		if (master != null) master.setRotation(yaw, pitch);
		else super.setRotation(yaw, pitch);
	}

	@Override
	public void superSetRotation(float yaw, float pitch) {
		super.setRotation(yaw, pitch);
	}

	@Override
	public void setPosition(double x, double y, double z) {
		if (master != null) master.setPosition(x, y, z);
		else super.setPosition(x, y, z);
	}

	@Override
	public void superSetPosition(double x, double y, double z) {
		super.setPosition(x, y, z);
	}

	@Override
	protected void setOnFireFromLava() {
		if (master != null) master.setOnFireFromLava();
		else super.setOnFireFromLava();
	}

	@Override
	public void superSetOnFireFromLava() {
		super.setOnFireFromLava();
	}

	@Override
	public void setFire(int seconds) {
		if (master != null) master.setFire(seconds);
		else super.setFire(seconds);
	}

	@Override
	public void superSetFire(int seconds) {
		super.setFire(seconds);
	}

	@Override
	public void extinguish() {
		if (master != null) master.extinguish();
		else super.extinguish();
	}

	@Override
	public void superExtinguish() {
		super.extinguish();
	}

	@Override
	public boolean isOffsetPositionInLiquid(double x, double y, double z) {
		return master != null ? master.isOffsetPositionInLiquid(x, y, z) : super.isOffsetPositionInLiquid(x, y, z);
	}

	@Override
	public boolean superIsOffsetPositionInLiquid(double x, double y, double z) {
		return super.isOffsetPositionInLiquid(x, y, z);
	}

	@Override
	protected void doBlockCollisions() {
		if (master != null) master.doBlockCollisions();
		else super.doBlockCollisions();
	}

	@Override
	public void superDoBlockCollisions() {
		super.doBlockCollisions();
	}

	@Override
	protected void playStepSound(BlockPos blockPos, Block block) {
		if (master != null) master.playStepSound(blockPos, block);
		else super.playStepSound(blockPos, block);
	}

	@Override
	public void superPlayStepSound(Object blockPos, Object block) {
		super.playStepSound((BlockPos) blockPos, (Block) block);
	}

	@Override
	public boolean isSilent() {
		return master != null ? master.isSilent() : super.isSilent();
	}

	@Override
	public boolean superIsSilent() {
		return super.isSilent();
	}

	@Override
	public void setSilent(boolean isSilent) {
		if (master != null) master.setSilent(isSilent);
		else super.setSilent(isSilent);
	}

	@Override
	public void superSetSilent(boolean isSilent) {
		super.setSilent(isSilent);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox() {
		return (AxisAlignedBB) (master != null ? master.getCollisionBoundingBox() : super.getCollisionBoundingBox());
	}

	@Override
	public AxisAlignedBB superGetCollisionBoundingBox() {
		return super.getCollisionBoundingBox();
	}

	@Override
	protected void dealFireDamage(int amount) {
		if (master != null) master.dealFireDamage(amount);
		else super.dealFireDamage(amount);
	}

	@Override
	public void superDealFireDamage(int amount) {
		super.dealFireDamage(amount);
	}

	@Override
	public boolean isWet() {
		return master != null ? master.isWet() : super.isWet();
	}

	@Override
	public boolean superIsWet() {
		return super.isWet();
	}

	@Override
	public boolean isInWater() {
		return master != null ? master.isInWater() : super.isInWater();
	}

	@Override
	public boolean superIsInWater() {
		return super.isInWater();
	}

	@Override
	public boolean handleWaterMovement() {
		return master != null ? master.handleWaterMovement() : super.handleWaterMovement();
	}

	@Override
	public boolean superHandleWaterMovement() {
		return super.handleWaterMovement();
	}

	@Override
	public void spawnRunningParticles() {
		if (master != null) master.spawnRunningParticles();
		else super.spawnRunningParticles();
	}

	@Override
	public void superSpawnRunningParticles() {
		super.spawnRunningParticles();
	}

	@Override
	protected void createRunningParticles() {
		if (master != null) master.createRunningParticles();
		else super.createRunningParticles();
	}

	@Override
	public void superCreateRunningParticles() {
		super.createRunningParticles();
	}

	@Override
	public boolean isInsideOfMaterial(Material material) {
		return master != null ? master.isInsideOfMaterial(material) : super.isInsideOfMaterial(material);
	}

	@Override
	public boolean superIsInsideOfMaterial(Object material) {
		return super.isInsideOfMaterial((Material) material);
	}

	@Override
	public boolean isInLava() {
		return master != null ? master.isInLava() : super.isInLava();
	}

	@Override
	public boolean superIsInLava() {
		return super.isInLava();
	}

	@Override
	public int getBrightnessForRender(float p_70070_1_) {
		return master != null ? master.getBrightnessForRender(p_70070_1_) : super.getBrightnessForRender(p_70070_1_);
	}

	@Override
	public int superGetBrightnessForRender(float p_70070_1_) {
		return super.getBrightnessForRender(p_70070_1_);
	}

	@Override
	public float getBrightness(float p_70013_1_) {
		return master != null ? master.getBrightness(p_70013_1_) : super.getBrightness(p_70013_1_);
	}

	@Override
	public float superGetBrightness(float p_70013_1_) {
		return super.getBrightness(p_70013_1_);
	}

	@Override
	public void setWorld(World world) {
		if (master != null) master.setWorld(world);
		else super.setWorld(world);
	}

	@Override
	public void superSetWorld(Object world) {
		super.setWorld((World) world);
	}

	@Override
	public void setPositionAndRotation(double x, double y, double z, float yaw, float pitch) {
		if (master != null) master.setPositionAndRotation(x, y, z, yaw, pitch);
		else super.setPositionAndRotation(x, y, z, yaw, pitch);
	}

	@Override
	public void superSetPositionAndRotation(double x, double y, double z, float yaw, float pitch) {
		super.setPositionAndRotation(x, y, z, yaw, pitch);
	}

	@Override
	public void moveToBlockPosAndAngles(BlockPos blockPos, float p_174828_2_, float p_174828_3_) {
		if (master != null) master.moveToBlockPosAndAngles(blockPos, p_174828_2_, p_174828_3_);
		else super.moveToBlockPosAndAngles(blockPos, p_174828_2_, p_174828_3_);
	}

	@Override
	public void superMoveToBlockPosAndAngles(Object blockPos, float p_174828_2_, float p_174828_3_) {
		super.moveToBlockPosAndAngles((BlockPos) blockPos, p_174828_2_, p_174828_3_);
	}

	@Override
	public void setLocationAndAngles(double x, double y, double z, float yaw, float pitch) {
		if (master != null) master.setLocationAndAngles(x, y, z, yaw, pitch);
		else super.setLocationAndAngles(x, y, z, yaw, pitch);
	}

	@Override
	public void superSetLocationAndAngles(double x, double y, double z, float yaw, float pitch) {
		super.setLocationAndAngles(x, y, z, yaw, pitch);
	}

	@Override
	public float getDistanceToEntity(Entity entity) {
		return master != null ? master.getDistanceToEntity(entity) : super.getDistanceToEntity(entity);
	}

	@Override
	public float superGetDistanceToEntity(Object entity) {
		return super.getDistanceToEntity((Entity) entity);
	}

	@Override
	public double getDistanceSq(double x, double y, double z) {
		return master != null ? master.getDistanceSq(x, y, z) : super.getDistanceSq(x, y, z);
	}

	@Override
	public double superGetDistanceSq(double x, double y, double z) {
		return super.getDistanceSq(x, y, z);
	}

	@Override
	public double getDistanceSq(BlockPos blockPos) {
		return master != null ? master.getDistanceSq(blockPos) : super.getDistanceSq(blockPos);
	}

	@Override
	public double superGetDistanceSq(Object blockPos) {
		return super.getDistanceSq((BlockPos) blockPos);
	}

	@Override
	public double getDistanceSqToCenter(BlockPos blockPos) {
		return master != null ? master.getDistanceSqToCenter(blockPos) : super.getDistanceSqToCenter(blockPos);
	}

	@Override
	public double superGetDistanceSqToCenter(Object blockPos) {
		return super.getDistanceSqToCenter((BlockPos) blockPos);
	}

	@Override
	public double getDistance(double x, double y, double z) {
		return master != null ? master.getDistance(x, y, z) : super.getDistance(x, y, z);
	}

	@Override
	public double superGetDistance(double x, double y, double z) {
		return super.getDistance(x, y, z);
	}

	@Override
	public double getDistanceSqToEntity(Entity entity) {
		return master != null ? master.getDistanceSqToEntity(entity) : super.getDistanceSqToEntity(entity);
	}

	@Override
	public double superGetDistanceSqToEntity(Object entity) {
		return super.getDistanceSqToEntity((Entity) entity);
	}

	@Override
	public void onCollideWithPlayer(EntityPlayer entityPlayer) {
		if (master != null) master.onCollideWithPlayer(entityPlayer);
		else super.onCollideWithPlayer(entityPlayer);
	}

	@Override
	public void superOnCollideWithPlayer(Object entityPlayer) {
		super.onCollideWithPlayer((EntityPlayer) entityPlayer);
	}

	@Override
	public void applyEntityCollision(Entity entity) {
		if (master != null) master.applyEntityCollision(entity);
		else super.applyEntityCollision(entity);
	}

	@Override
	public void superApplyEntityCollision(Object entity) {
		super.applyEntityCollision((Entity) entity);
	}

	@Override
	public void addVelocity(double x, double y, double z) {
		if (master != null) master.addVelocity(x, y, z);
		else super.addVelocity(x, y, z);
	}

	@Override
	public void superAddVelocity(double x, double y, double z) {
		super.addVelocity(x, y, z);
	}

	@Override
	public Vec3d getPositionEyes(float p_174824_1_) {
		return (Vec3d) (master != null ? master.getPositionEyes(p_174824_1_) : super.getPositionEyes(p_174824_1_));
	}

	@Override
	public Object superGetPositionEyes(float p_174824_1_) {
		return super.getPositionEyes(p_174824_1_);
	}

	@Override
	public RayTraceResult rayTrace(double p_174822_1_, float p_174822_3_) {
		return (RayTraceResult) (master != null ? master.rayTrace(p_174822_1_, p_174822_3_) : super.rayTrace(p_174822_1_, p_174822_3_));
	}

	@Override
	public Object superRayTrace(double p_174822_1_, float p_174822_3_) {
		return super.rayTrace(p_174822_1_, p_174822_3_);
	}

	@Override
	public boolean isInRangeToRender3d(double x, double y, double z) {
		return master != null ? master.isInRangeToRender3d(x, y, z) : super.isInRangeToRender3d(x, y, z);
	}

	@Override
	public boolean superIsInRangeToRender3d(double x, double y, double z) {
		return super.isInRangeToRender3d(x, y, z);
	}

	@Override
	public boolean isInRangeToRenderDist(double distance) {
		return master != null ? master.isInRangeToRenderDist(distance) : super.isInRangeToRenderDist(distance);
	}

	@Override
	public boolean superIsInRangeToRenderDist(double distance) {
		return super.isInRangeToRenderDist(distance);
	}

	@Override
	public boolean writeToNBTAtomically(NBTTagCompound nBTTagCompound) {
		return master != null ? master.writeToNBTAtomically(nBTTagCompound) : super.writeToNBTAtomically(nBTTagCompound);
	}

	@Override
	public boolean superWriteToNBTAtomically(Object nBTTagCompound) {
		return super.writeToNBTAtomically((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public boolean writeToNBTOptional(NBTTagCompound nBTTagCompound) {
		return master != null ? master.writeToNBTOptional(nBTTagCompound) : super.writeToNBTOptional(nBTTagCompound);
	}

	@Override
	public boolean superWriteToNBTOptional(Object nBTTagCompound) {
		return super.writeToNBTOptional((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public void readFromNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.readFromNBT(nBTTagCompound);
		else super.readFromNBT(nBTTagCompound);
	}

	@Override
	public void superReadFromNBT(Object nBTTagCompound) {
		super.readFromNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	protected boolean shouldSetPosAfterLoading() {
		return master != null ? master.shouldSetPosAfterLoading() : super.shouldSetPosAfterLoading();
	}

	@Override
	public boolean superShouldSetPosAfterLoading() {
		return super.shouldSetPosAfterLoading();
	}

	@Override
	protected NBTTagList newDoubleNBTList(double... numbers) {
		return (NBTTagList) (master != null ? master.newDoubleNBTList(numbers) : super.newDoubleNBTList(numbers));
	}

	@Override
	public NBTTagList superNewDoubleNBTList(double... numbers) {
		return super.newDoubleNBTList(numbers);
	}

	@Override
	protected NBTTagList newFloatNBTList(float... numbers) {
		return (NBTTagList) (master != null ? master.newFloatNBTList(numbers) : super.newFloatNBTList(numbers));
	}

	@Override
	public NBTTagList superNewFloatNBTList(float... numbers) {
		return super.newFloatNBTList(numbers);
	}

	@Override
	public EntityItem dropItem(Item item, int size) {
		return (EntityItem) (master != null ? master.dropItem(item, size) : super.dropItem(item, size));
	}

	@Override
	public EntityItem superDropItem(Object item, int size) {
		return super.dropItem((Item) item, size);
	}

	@Override
	public EntityItem dropItemWithOffset(Item item, int size, float p_145778_3_) {
		return (EntityItem) (master != null ? master.dropItemWithOffset(item, size, p_145778_3_) : super.dropItemWithOffset(item, size, p_145778_3_));
	}

	@Override
	public EntityItem superDropItemWithOffset(Object item, int size, float p_145778_3_) {
		return super.dropItemWithOffset((Item) item, size, p_145778_3_);
	}

	@Override
	public EntityItem entityDropItem(ItemStack itemStack, float offsetY) {
		return (EntityItem) (master != null ? master.entityDropItem(itemStack, offsetY) : super.entityDropItem(itemStack, offsetY));
	}

	@Override
	public EntityItem superEntityDropItem(Object itemStack, float offsetY) {
		return super.entityDropItem((ItemStack) itemStack, offsetY);
	}

	@Override
	public AxisAlignedBB getCollisionBox(Entity entity) {
		return (AxisAlignedBB) (master != null ? master.getCollisionBox(entity) : super.getCollisionBox(entity));
	}

	@Override
	public AxisAlignedBB superGetCollisionBox(Object entity) {
		return super.getCollisionBox((Entity) entity);
	}

	@Override
	public void updatePassenger(Entity entity) {
		if (master != null) master.updatePassenger(entity);
		else super.updatePassenger(entity);
	}

	@Override
	public void superUpdatePassenger(Object entity) {
		super.updatePassenger((Entity) entity);
	}

	@Override
	public double getMountedYOffset() {
		return master != null ? master.getMountedYOffset() : super.getMountedYOffset();
	}

	@Override
	public double superGetMountedYOffset() {
		return super.getMountedYOffset();
	}

	@Override
	public float getCollisionBorderSize() {
		return master != null ? master.getCollisionBorderSize() : super.getCollisionBorderSize();
	}

	@Override
	public float superGetCollisionBorderSize() {
		return super.getCollisionBorderSize();
	}

	@Override
	public void setPortal(BlockPos bockPos) {
		if (master != null) master.setPortal(bockPos);
		else super.setPortal(bockPos);
	}

	@Override
	public void superSetPortal(Object bockPos) {
		super.setPortal((BlockPos) bockPos);
	}

	@Override
	public void setVelocity(double x, double y, double z) {
		if (master != null) master.setVelocity(x, y, z);
		else super.setVelocity(x, y, z);
	}

	@Override
	public void superSetVelocity(double x, double y, double z) {
		super.setVelocity(x, y, z);
	}

	@Override
	public boolean isBurning() {
		return master != null ? master.isBurning() : super.isBurning();
	}

	@Override
	public boolean superIsBurning() {
		return super.isBurning();
	}

	@Override
	public boolean isRiding() {
		return master != null ? master.isRiding() : super.isRiding();
	}

	@Override
	public boolean superIsRiding() {
		return super.isRiding();
	}

	@Override
	public boolean isSneaking() {
		return master != null ? master.isSneaking() : super.isSneaking();
	}

	@Override
	public boolean superIsSneaking() {
		return super.isSneaking();
	}

	@Override
	public void setSneaking(boolean sneaking) {
		if (master != null) master.setSneaking(sneaking);
		else super.setSneaking(sneaking);
	}

	@Override
	public void superSetSneaking(boolean sneaking) {
		super.setSneaking(sneaking);
	}

	@Override
	public boolean isSprinting() {
		return master != null ? master.isSprinting() : super.isSprinting();
	}

	@Override
	public boolean superIsSprinting() {
		return super.isSprinting();
	}

	@Override
	public boolean isInvisible() {
		return master != null ? master.isInvisible() : super.isInvisible();
	}

	@Override
	public boolean superIsInvisible() {
		return super.isInvisible();
	}

	@Override
	public void setInvisible(boolean invisible) {
		if (master != null) master.setInvisible(invisible);
		else super.setInvisible(invisible);
	}

	@Override
	public void superSetInvisible(boolean invisible) {
		super.setInvisible(invisible);
	}

	@Override
	protected boolean getFlag(int flag) {
		return master != null ? master.getFlag(flag) : super.getFlag(flag);
	}

	@Override
	public boolean superGetFlag(int flag) {
		return super.getFlag(flag);
	}

	@Override
	protected void setFlag(int flag, boolean set) {
		if (master != null) master.setFlag(flag, set);
		else super.setFlag(flag, set);
	}

	@Override
	public void superSetFlag(int flag, boolean set) {
		super.setFlag(flag, set);
	}

	@Override
	public int getAir() {
		return master != null ? master.getAir() : super.getAir();
	}

	@Override
	public int superGetAir() {
		return super.getAir();
	}

	@Override
	public void setAir(int air) {
		if (master != null) master.setAir(air);
		else super.setAir(air);
	}

	@Override
	public void superSetAir(int air) {
		super.setAir(air);
	}

	@Override
	public void onStruckByLightning(EntityLightningBolt entityLightningBolt) {
		if (master != null) master.onStruckByLightning(entityLightningBolt);
		else super.onStruckByLightning(entityLightningBolt);
	}

	@Override
	public void superOnStruckByLightning(Object entityLightningBolt) {
		super.onStruckByLightning((EntityLightningBolt) entityLightningBolt);
	}

	@Override
	protected boolean pushOutOfBlocks(double x, double y, double z) {
		return master != null ? master.pushOutOfBlocks(x, y, z) : super.pushOutOfBlocks(x, y, z);
	}

	@Override
	public boolean superPushOutOfBlocks(double x, double y, double z) {
		return super.pushOutOfBlocks(x, y, z);
	}

	@Override
	public Entity[] getParts() {
		return (Entity[]) (master != null ? master.getParts() : super.getParts());
	}

	@Override
	public Entity[] superGetParts() {
		return super.getParts();
	}

	@Override
	public boolean isEntityEqual(Entity entity) {
		return master != null ? master.isEntityEqual(entity) : super.isEntityEqual(entity);
	}

	@Override
	public boolean superIsEntityEqual(Object entity) {
		return super.isEntityEqual((Entity) entity);
	}

	@Override
	public boolean hitByEntity(Entity entity) {
		return master != null ? master.hitByEntity(entity) : super.hitByEntity(entity);
	}

	@Override
	public boolean superHitByEntity(Object entity) {
		return super.hitByEntity((Entity) entity);
	}

	@Override
	public String toString() {
		return master != null ? master.toString() : super.toString();
	}

	@Override
	public String superToString() {
		return super.toString();
	}

	@Override
	public boolean isEntityInvulnerable(DamageSource damageSource) {
		return master != null ? master.isEntityInvulnerable(damageSource) : super.isEntityInvulnerable(damageSource);
	}

	@Override
	public boolean superIsEntityInvulnerable(Object damageSource) {
		return super.isEntityInvulnerable((DamageSource) damageSource);
	}

	@Override
	public void copyLocationAndAnglesFrom(Entity entity) {
		if (master != null) master.copyLocationAndAnglesFrom(entity);
		else super.copyLocationAndAnglesFrom(entity);
	}

	@Override
	public void superCopyLocationAndAnglesFrom(Object entity) {
		super.copyLocationAndAnglesFrom((Entity) entity);
	}

	@Override
	public Entity changeDimension(int p_71027_1_) {
		return (Entity) (master != null ? master.changeDimension(p_71027_1_) : super.changeDimension(p_71027_1_));
	}

	@Override
	public Object superChangeDimension(int p_71027_1_) {
		return super.changeDimension(p_71027_1_);
	}

	@Override
	public float getExplosionResistance(Explosion explosion, World world, BlockPos blockPos, IBlockState iBlockState) {
		return master != null ? master.getExplosionResistance(explosion, world, blockPos, iBlockState) : super.getExplosionResistance(explosion, world, blockPos, iBlockState);
	}

	@Override
	public float superGetExplosionResistance(Object explosion, Object world, Object blockPos, Object iBlockState) {
		return super.getExplosionResistance((Explosion) explosion, (World) world, (BlockPos) blockPos, (IBlockState) iBlockState);
	}

	@Override
	public boolean verifyExplosion(Explosion explosion, World world, BlockPos blockPos, IBlockState iBlockState, float p_174816_5_) {
		return master != null ? master.verifyExplosion(explosion, world, blockPos, iBlockState, p_174816_5_) : super.verifyExplosion(explosion, world, blockPos, iBlockState, p_174816_5_);
	}

	@Override
	public boolean superVerifyExplosion(Object explosion, Object world, Object blockPos, Object iBlockState, float p_174816_5_) {
		return super.verifyExplosion((Explosion) explosion, (World) world, (BlockPos) blockPos, (IBlockState) iBlockState, p_174816_5_);
	}

	@Override
	public int getMaxFallHeight() {
		return master != null ? master.getMaxFallHeight() : super.getMaxFallHeight();
	}

	@Override
	public int superGetMaxFallHeight() {
		return super.getMaxFallHeight();
	}

	@Override
	public boolean doesEntityNotTriggerPressurePlate() {
		return master != null ? master.doesEntityNotTriggerPressurePlate() : super.doesEntityNotTriggerPressurePlate();
	}

	@Override
	public boolean superDoesEntityNotTriggerPressurePlate() {
		return super.doesEntityNotTriggerPressurePlate();
	}

	@Override
	public void addEntityCrashInfo(CrashReportCategory crashReportCategory) {
		if (master != null) master.addEntityCrashInfo(crashReportCategory);
		else super.addEntityCrashInfo(crashReportCategory);
	}

	@Override
	public void superAddEntityCrashInfo(Object crashReportCategory) {
		super.addEntityCrashInfo((CrashReportCategory) crashReportCategory);
	}

	@Override
	public boolean canRenderOnFire() {
		return master != null ? master.canRenderOnFire() : super.canRenderOnFire();
	}

	@Override
	public boolean superCanRenderOnFire() {
		return super.canRenderOnFire();
	}

	@Override
	public UUID getUniqueID() {
		return master != null ? master.getUniqueID() : super.getUniqueID();
	}

	@Override
	public UUID superGetUniqueID() {
		return super.getUniqueID();
	}

	@Override
	public void setCustomNameTag(String p_96094_1_) {
		if (master != null) master.setCustomNameTag(p_96094_1_);
		else super.setCustomNameTag(p_96094_1_);
	}

	@Override
	public void superSetCustomNameTag(String p_96094_1_) {
		super.setCustomNameTag(p_96094_1_);
	}

	@Override
	public String getCustomNameTag() {
		return master != null ? master.getCustomNameTag() : super.getCustomNameTag();
	}

	@Override
	public String superGetCustomNameTag() {
		return super.getCustomNameTag();
	}

	@Override
	public boolean hasCustomName() {
		return master != null ? master.hasCustomName() : super.hasCustomName();
	}

	@Override
	public boolean superHasCustomName() {
		return super.hasCustomName();
	}

	@Override
	public void setAlwaysRenderNameTag(boolean p_174805_1_) {
		if (master != null) master.setAlwaysRenderNameTag(p_174805_1_);
		else super.setAlwaysRenderNameTag(p_174805_1_);
	}

	@Override
	public void superSetAlwaysRenderNameTag(boolean p_174805_1_) {
		super.setAlwaysRenderNameTag(p_174805_1_);
	}

	@Override
	public boolean getAlwaysRenderNameTag() {
		return master != null ? master.getAlwaysRenderNameTag() : super.getAlwaysRenderNameTag();
	}

	@Override
	public boolean superGetAlwaysRenderNameTag() {
		return super.getAlwaysRenderNameTag();
	}

	@Override
	public void setPositionAndUpdate(double x, double y, double z) {
		if (master != null) master.setPositionAndUpdate(x, y, z);
		else super.setPositionAndUpdate(x, y, z);
	}

	@Override
	public void superSetPositionAndUpdate(double x, double y, double z) {
		super.setPositionAndUpdate(x, y, z);
	}

	@Override
	public EnumFacing getHorizontalFacing() {
		return (EnumFacing) (master != null ? master.getHorizontalFacing() : super.getHorizontalFacing());
	}

	@Override
	public EnumFacing superGetHorizontalFacing() {
		return super.getHorizontalFacing();
	}

	@Override
	protected HoverEvent getHoverEvent() {
		return (HoverEvent) (master != null ? master.getHoverEvent() : super.getHoverEvent());
	}

	@Override
	public HoverEvent superGetHoverEvent() {
		return super.getHoverEvent();
	}

	@Override
	public boolean isSpectatedByPlayer(EntityPlayerMP entityPlayerMP) {
		return master != null ? master.isSpectatedByPlayer(entityPlayerMP) : super.isSpectatedByPlayer(entityPlayerMP);
	}

	@Override
	public boolean superIsSpectatedByPlayer(Object entityPlayerMP) {
		return super.isSpectatedByPlayer((EntityPlayerMP) entityPlayerMP);
	}

	@Override
	public AxisAlignedBB getEntityBoundingBox() {
		return (AxisAlignedBB) (master != null ? master.getEntityBoundingBox() : super.getEntityBoundingBox());
	}

	@Override
	public AxisAlignedBB superGetEntityBoundingBox() {
		return super.getEntityBoundingBox();
	}

	@Override
	public void setEntityBoundingBox(AxisAlignedBB axisAlignedBB) {
		if (master != null) master.setEntityBoundingBox(axisAlignedBB);
		else super.setEntityBoundingBox(axisAlignedBB);
	}

	@Override
	public void superSetEntityBoundingBox(Object axisAlignedBB) {
		super.setEntityBoundingBox((AxisAlignedBB) axisAlignedBB);
	}

	@Override
	public boolean isOutsideBorder() {
		return master != null ? master.isOutsideBorder() : super.isOutsideBorder();
	}

	@Override
	public boolean superIsOutsideBorder() {
		return super.isOutsideBorder();
	}

	@Override
	public void setOutsideBorder(boolean p_174821_1_) {
		if (master != null) master.setOutsideBorder(p_174821_1_);
		else super.setOutsideBorder(p_174821_1_);
	}

	@Override
	public void superSetOutsideBorder(boolean p_174821_1_) {
		super.setOutsideBorder(p_174821_1_);
	}

	@Override
	public Vec3d getPositionVector() {
		return (Vec3d) (master != null ? master.getPositionVector() : super.getPositionVector());
	}

	@Override
	public Object superGetPositionVector() {
		return super.getPositionVector();
	}

	@Override
	public World getEntityWorld() {
		return (World) (master != null ? master.getEntityWorld() : super.getEntityWorld());
	}

	@Override
	public World superGetEntityWorld() {
		return super.getEntityWorld();
	}

	@Override
	public Entity getCommandSenderEntity() {
		return (Entity) (master != null ? master.getCommandSenderEntity() : super.getCommandSenderEntity());
	}

	@Override
	public Entity superGetCommandSenderEntity() {
		return super.getCommandSenderEntity();
	}

	@Override
	public void setCommandStat(Type type, int amount) {
		if (master != null) master.setCommandStat(type, amount);
		else super.setCommandStat(type, amount);
	}

	@Override
	public void superSetCommandStat(Object type, int amount) {
		super.setCommandStat((Type) type, amount);
	}

	@Override
	public CommandResultStats getCommandStats() {
		return (CommandResultStats) (master != null ? master.getCommandStats() : super.getCommandStats());
	}

	@Override
	public CommandResultStats superGetCommandStats() {
		return super.getCommandStats();
	}

	@Override
	public void setCommandStats(Entity entity) {
		if (master != null) master.setCommandStats(entity);
		else super.setCommandStats(entity);
	}

	@Override
	public void superSetCommandStats(Object entity) {
		super.setCommandStats((Entity) entity);
	}

	@Override
	public boolean isImmuneToExplosions() {
		return master != null ? master.isImmuneToExplosions() : super.isImmuneToExplosions();
	}

	@Override
	public boolean superIsImmuneToExplosions() {
		return super.isImmuneToExplosions();
	}

	@Override
	protected void applyEnchantments(EntityLivingBase entityLivingBase, Entity entity) {
		if (master != null) master.applyEnchantments(entityLivingBase, entity);
		else super.applyEnchantments(entityLivingBase, entity);
	}

	@Override
	public void superApplyEnchantments(Object entityLivingBase, Object entity) {
		super.applyEnchantments((EntityLivingBase) entityLivingBase, (Entity) entity);
	}

	@Override
	public NBTTagCompound getEntityData() {
		return (NBTTagCompound) (master != null ? master.getEntityData() : super.getEntityData());
	}

	@Override
	public NBTTagCompound superGetEntityData() {
		return super.getEntityData();
	}

	@Override
	public boolean shouldRiderSit() {
		return master != null ? master.shouldRiderSit() : super.shouldRiderSit();
	}

	@Override
	public boolean superShouldRiderSit() {
		return super.shouldRiderSit();
	}

	@Override
	public UUID getPersistentID() {
		return master != null ? master.getPersistentID() : super.getPersistentID();
	}

	@Override
	public UUID superGetPersistentID() {
		return super.getPersistentID();
	}

	@Override
	public boolean shouldRenderInPass(int pass) {
		return master != null ? master.shouldRenderInPass(pass) : super.shouldRenderInPass(pass);
	}

	@Override
	public boolean superShouldRenderInPass(int pass) {
		return super.shouldRenderInPass(pass);
	}

	@Override
	public boolean isCreatureType(EnumCreatureType enumCreatureType, boolean forSpawnCount) {
		return master != null ? master.isCreatureType(enumCreatureType, forSpawnCount) : super.isCreatureType(enumCreatureType, forSpawnCount);
	}

	@Override
	public boolean superIsCreatureType(Object enumCreatureType, boolean forSpawnCount) {
		return super.isCreatureType((EnumCreatureType) enumCreatureType, forSpawnCount);
	}

	@Override
	public boolean canRiderInteract() {
		return master != null ? master.canRiderInteract() : super.canRiderInteract();
	}

	@Override
	public boolean superCanRiderInteract() {
		return super.canRiderInteract();
	}

	@Override
	public boolean shouldDismountInWater(Entity entity) {
		return master != null ? master.shouldDismountInWater(entity) : super.shouldDismountInWater(entity);
	}

	@Override
	public boolean superShouldDismountInWater(Object entity) {
		return super.shouldDismountInWater((Entity) entity);
	}

	@Override
	public void superSetPositionAndRotationDirect(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {
	}

	@Override
	public float superGetShadowSize() {
		return 0.0F;
	}

	@Override
	public Object superGetPlayerCoordinates() {
		return null;
	}

	@Override
	public void superFunc_152121_a(Object type, Object resourceLocation) {
	}

	@Override
	public float superGetCurrentPlayerStrVsBlock(Object block, boolean p_146096_2_) {
		return 0F;
	}

	@Override
	public float superGetBreakSpeed(Object block, boolean p_146096_2_, int meta) {
		return 0F;
	}

	@Override
	public float superGetBreakSpeed(Object block, boolean p_146096_2_, int meta, int x, int y, int z) {
		return 0F;
	}

	@Override
	public void superFunc_146093_a(Object tileEntityHopper) {
	}

	@Override
	public void superDisplayGUIHopperMinecart(Object entityMinecartHopper) {
	}

	@Override
	public void superDisplayGUIEnchantment(int p_71002_1_, int p_71002_2_, int p_71002_3_, String p_71002_4_) {
	}

	@Override
	public void superDisplayGUIAnvil(int p_82244_1_, int p_82244_2_, int p_82244_3_) {
	}

	@Override
	public void superDisplayGUIWorkbench(int p_71058_1_, int p_71058_2_, int p_71058_3_) {
	}

	@Override
	public void superFunc_146101_a(Object tileEntityFurnace) {
	}

	@Override
	public void superFunc_146102_a(Object tileEntityDispenser) {
	}

	@Override
	public void superFunc_146100_a(Object tileEntity) {
	}

	@Override
	public void superFunc_146095_a(Object commandBlockBaseLogic) {
	}

	@Override
	public void superFunc_146098_a(Object tileEntityBrewingStand) {
	}

	@Override
	public void superFunc_146104_a(Object tileEntityBeacon) {
	}

	@Override
	public void superDisplayGUIMerchant(Object iMerchant, String p_71030_2_) {
	}

	@Override
	public Object superSleepInBedAt(int p_71018_1_, int p_71018_2_, int p_71018_3_) {
		return null;
	}

	@Override
	public boolean superGetHideCape(int p_82241_1_) {
		return false;
	}

	@Override
	public void superSetHideCape(int p_82239_1_, boolean p_82239_2_) {
	}

	@Override
	public void superSetSpawnChunk(Object chunkCoordinates, boolean p_71063_2_) {
	}

	@Override
	public void superFall(float p_70069_1_) {
	}

	@Override
	public String superFunc_146067_o(int p_146067_1_) {
		return null;
	}

	@Override
	public Object superGetItemIcon(Object itemStack, int p_70620_2_) {
		return null;
	}

	@Override
	public boolean superIsCurrentToolAdventureModeExempt(int p_82246_1_, int p_82246_2_, int p_82246_3_) {
		return false;
	}

	@Override
	public boolean superCanPlayerEdit(int p_82247_1_, int p_82247_2_, int p_82247_3_, int p_82247_4_, Object itemStack) {
		return false;
	}

	@Override
	public String superGetName() {
		return null;
	}

	@Override
	public Object[] superGetLastActiveItems() {
		return null;
	}

	@Override
	public boolean superGetHideCape() {
		return false;
	}

	@Override
	public Object superGetPosition(float par1) {
		return null;
	}

	@Override
	public void superUpdateFallState(double p_70064_1_, boolean p_70064_3_) {
	}

	@Override
	public void superDropRareDrop(int p_70600_1_) {
	}

	@Override
	public boolean superIsAIEnabled() {
		return false;
	}

	@Override
	public void superUpdateAITasks() {
	}

	@Override
	public boolean superIsClientWorld() {
		return !isServerWorld();
	}

	@Override
	public void superFunc_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Object block) {
	}

	@Override
	public boolean superHandleLavaMovement() {
		return false;
	}

	@Override
	public boolean superIsEntityInvulnerable() {
		return isInvisible();
	}

	@Override
	public void superCopyDataFrom(Object entity, boolean p_82141_2_) {
	}

	@Override
	public float superFunc_145772_a(Object explosion, Object world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Object block) {
		return 0;
	}

	@Override
	public boolean superFunc_145774_a(Object explosion, Object world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Object block, float p_145774_7_) {
		return false;
	}

	@Override
	public int superGetMaxSafePointTries() {
		return 0;
	}
	// 190~
	@Override
	public boolean isCreative() {
		return master != null ? master.isCreative() : super.isCreative();
	}

	@Override
	public boolean superIsCreative() {
		return super.isCreative();
	}

	@Override
	public boolean isPlayerInfoSet() {
		return master != null ? master.isPlayerInfoSet() : super.isPlayerInfoSet();
	}

	@Override
	public boolean superIsPlayerInfoSet() {
		return super.isPlayerInfoSet();
	}

	@Override
	public ResourceLocation getLocationElytra() {
		return (ResourceLocation) (master != null ? master.getLocationElytra() : super.getLocationElytra());
	}

	@Override
	public Object superGetLocationElytra() {
		return super.getLocationElytra();
	}

	@Override
	protected CooldownTracker createCooldownTracker() {
		return (CooldownTracker) (master != null ? master.createCooldownTracker() : super.createCooldownTracker());
	}

	@Override
	public Object superCreateCooldownTracker() {
		return super.createCooldownTracker();
	}

	@Override
	protected void updateSize() {
		if (master != null) master.updateSize();
		else super.updateSize();
	}

	@Override
	public void superUpdateSize() {
		super.updateSize();
	}

	@Override
	public SoundCategory getSoundCategory() {
		return (SoundCategory) (master != null ? master.getSoundCategory() : super.getSoundCategory());
	}

	@Override
	public SoundCategory superGetSoundCategory() {
		return super.getSoundCategory();
	}

	@Override
	protected void damageShield(float p_184590_1_) {
		if (master != null) master.damageShield(p_184590_1_);
		else super.damageShield(p_184590_1_);
	}

	@Override
	public void superDamageShield(float p_184590_1_) {
		super.damageShield(p_184590_1_);
	}

	@Override
	public void displayGuiCommandBlock(TileEntityCommandBlock tileEntityCommandBlock) {
		if (master != null) master.displayGuiCommandBlock(tileEntityCommandBlock);
		else super.displayGuiCommandBlock(tileEntityCommandBlock);
	}

	@Override
	public void superDisplayGuiCommandBlock(Object tileEntityCommandBlock) {
		super.displayGuiCommandBlock((TileEntityCommandBlock) tileEntityCommandBlock);
	}

	@Override
	public void dismountRidingEntity() {
		if (master != null) master.dismountRidingEntity();
		else super.dismountRidingEntity();
	}

	@Override
	public void superDismountRidingEntity() {
		super.dismountRidingEntity();
	}

	@Override
	public void spawnSweepParticles() {
		if (master != null) master.spawnSweepParticles();
		else super.spawnSweepParticles();
	}

	@Override
	public void superSpawnSweepParticles() {
		super.spawnSweepParticles();
	}

	@Override
	public boolean hasAchievement(Achievement achievement) {
		return master != null ? master.hasAchievement(achievement) : super.hasAchievement(achievement);
	}

	@Override
	public boolean superHasAchievement(Object achievement) {
		return super.hasAchievement((Achievement) achievement);
	}

	@Override
	public void setItemStackToSlot(EntityEquipmentSlot entityEquipmentSlot, ItemStack itemStack) {
		if (master != null) master.setItemStackToSlot(entityEquipmentSlot, itemStack);
		else super.setItemStackToSlot(entityEquipmentSlot, itemStack);
	}

	@Override
	public void superSetItemStackToSlot(Object entityEquipmentSlot, Object itemStack) {
		super.setItemStackToSlot((EntityEquipmentSlot) entityEquipmentSlot, (ItemStack) itemStack);
	}

	@Override
	public Iterable<ItemStack> getHeldEquipment() {
		return (Iterable<ItemStack>) (master != null ? master.getHeldEquipment() : super.getHeldEquipment());
	}

	@Override
	public Object superGetHeldEquipment() {
		return super.getHeldEquipment();
	}

	@Override
	public Iterable<ItemStack> getArmorInventoryList() {
		return (Iterable<ItemStack>) (master != null ? master.getArmorInventoryList() : super.getArmorInventoryList());
	}

	@Override
	public Object superGetArmorInventoryList() {
		return super.getArmorInventoryList();
	}

	@Override
	public EnumHandSide getPrimaryHand() {
		return (EnumHandSide) (master != null ? master.getPrimaryHand() : super.getPrimaryHand());
	}

	@Override
	public Object superGetPrimaryHand() {
		return super.getPrimaryHand();
	}

	@Override
	public void setPrimaryHand(EnumHandSide enumHandSide) {
		if (master != null) master.setPrimaryHand(enumHandSide);
		else super.setPrimaryHand(enumHandSide);
	}

	@Override
	public void superSetPrimaryHand(Object enumHandSide) {
		super.setPrimaryHand((EnumHandSide) enumHandSide);
	}

	@Override
	public float getCooldownPeriod() {
		return master != null ? master.getCooldownPeriod() : super.getCooldownPeriod();
	}

	@Override
	public float superGetCooldownPeriod() {
		return super.getCooldownPeriod();
	}

	@Override
	public float getCooledAttackStrength(float adjustTicks) {
		return master != null ? master.getCooledAttackStrength(adjustTicks) : super.getCooledAttackStrength(adjustTicks);
	}

	@Override
	public float superGetCooledAttackStrength(float adjustTicks) {
		return super.getCooledAttackStrength(adjustTicks);
	}

	@Override
	public void resetCooldown() {
		if (master != null) master.resetCooldown();
		else super.resetCooldown();
	}

	@Override
	public void superResetCooldown() {
		super.resetCooldown();
	}

	@Override
	public CooldownTracker getCooldownTracker() {
		return (CooldownTracker) (master != null ? master.getCooldownTracker() : super.getCooldownTracker());
	}

	@Override
	public CooldownTracker superGetCooldownTracker() {
		return super.getCooldownTracker();
	}

	@Override
	public float getLuck() {
		return master != null ? master.getLuck() : super.getLuck();
	}

	@Override
	public float superGetLuck() {
		return super.getLuck();
	}

	@Override
	public void addPrefix(ITextComponent iTextComponent) {
		if (master != null) master.addPrefix(iTextComponent);
		else super.addPrefix(iTextComponent);
	}

	@Override
	public void superAddPrefix(Object iTextComponent) {
		super.addPrefix((ITextComponent) iTextComponent);
	}

	@Override
	public void addSuffix(ITextComponent iTextComponent) {
		if (master != null) master.addSuffix(iTextComponent);
		else super.addSuffix(iTextComponent);
	}

	@Override
	public void superAddSuffix(Object iTextComponent) {
		super.addSuffix((ITextComponent) iTextComponent);
	}

	@Override
	public Collection<ITextComponent> getPrefixes() {
		return master != null ? master.getPrefixes() : super.getPrefixes();
	}

	@Override
	public Collection superGetPrefixes() {
		return super.getPrefixes();
	}

	@Override
	public Collection<ITextComponent> getSuffixes() {
		return master != null ? master.getSuffixes() : super.getSuffixes();
	}

	@Override
	public Collection superGetSuffixes() {
		return super.getSuffixes();
	}

	@Override
	protected void frostWalk(BlockPos blockPos) {
		if (master != null) master.frostWalk(blockPos);
		else super.frostWalk(blockPos);
	}

	@Override
	public void superFrostWalk(Object blockPos) {
		super.frostWalk((BlockPos) blockPos);
	}

	@Override
	protected void playEquipSound(ItemStack itemStack) {
		if (master != null) master.playEquipSound(itemStack);
		else super.playEquipSound(itemStack);
	}

	@Override
	public void superPlayEquipSound(Object itemStack) {
		super.playEquipSound((ItemStack) itemStack);
	}

	@Override
	protected void playHurtSound(DamageSource damageSource) {
		if (master != null) master.playHurtSound(damageSource);
		else super.playHurtSound(damageSource);
	}

	@Override
	public void superPlayHurtSound(Object damageSource) {
		super.playHurtSound((DamageSource) damageSource);
	}

	@Override
	public ItemStack getHeldItemOffhand() {
		return (ItemStack) (master != null ? master.getHeldItemOffhand() : super.getHeldItemOffhand());
	}

	@Override
	public ItemStack superGetHeldItemOffhand() {
		return super.getHeldItemOffhand();
	}

	@Override
	public ItemStack getHeldItem(EnumHand enumHand) {
		return (ItemStack) (master != null ? master.getHeldItem(enumHand) : super.getHeldItem(enumHand));
	}

	@Override
	public ItemStack superGetHeldItem(Object enumHand) {
		return super.getHeldItem((EnumHand) enumHand);
	}

	@Override
	public void setHeldItem(EnumHand enumHand, ItemStack itemStack) {
		if (master != null) master.setHeldItem(enumHand, itemStack);
		else super.setHeldItem(enumHand, itemStack);
	}

	@Override
	public void superSetHeldItem(Object enumHand, Object itemStack) {
		super.setHeldItem((EnumHand) enumHand, (ItemStack) itemStack);
	}

	@Override
	public void setRenderYawOffset(float offset) {
		if (master != null) master.setRenderYawOffset(offset);
		else super.setRenderYawOffset(offset);
	}

	@Override
	public void superSetRenderYawOffset(float offset) {
		super.setRenderYawOffset(offset);
	}

	@Override
	public boolean isHandActive() {
		return master != null ? master.isHandActive() : super.isHandActive();
	}

	@Override
	public boolean superIsHandActive() {
		return super.isHandActive();
	}

	@Override
	public EnumHand getActiveHand() {
		return (EnumHand) (master != null ? master.getActiveHand() : super.getActiveHand());
	}

	@Override
	public EnumHand superGetActiveHand() {
		return super.getActiveHand();
	}

	@Override
	protected void updateActiveHand() {
		if (master != null) master.updateActiveHand();
		else super.updateActiveHand();
	}

	@Override
	public void superUpdateActiveHand() {
		super.updateActiveHand();
	}

	@Override
	public void setActiveHand(EnumHand enumHand) {
		if (master != null) master.setActiveHand(enumHand);
		else super.setActiveHand(enumHand);
	}

	@Override
	public void superSetActiveHand(Object enumHand) {
		super.setActiveHand((EnumHand) enumHand);
	}

	@Override
	public void notifyDataManagerChange(DataParameter<?> dataParameter) {
		if (master != null) master.notifyDataManagerChange(dataParameter);
		else super.notifyDataManagerChange(dataParameter);
	}

	@Override
	public void superNotifyDataManagerChange(Object dataParameter) {
		super.notifyDataManagerChange((DataParameter) dataParameter);
	}

	@Override
	public ItemStack getActiveItemStack() {
		return (ItemStack) (master != null ? master.getActiveItemStack() : super.getActiveItemStack());
	}

	@Override
	public ItemStack superGetActiveItemStack() {
		return super.getActiveItemStack();
	}

	@Override
	public int getItemInUseMaxCount() {
		return master != null ? master.getItemInUseMaxCount() : super.getItemInUseMaxCount();
	}

	@Override
	public int superGetItemInUseMaxCount() {
		return super.getItemInUseMaxCount();
	}

	@Override
	public void stopActiveHand() {
		if (master != null) master.stopActiveHand();
		else super.stopActiveHand();
	}

	@Override
	public void superStopActiveHand() {
		super.stopActiveHand();
	}

	@Override
	public void resetActiveHand() {
		if (master != null) master.resetActiveHand();
		else super.resetActiveHand();
	}

	@Override
	public void superResetActiveHand() {
		super.resetActiveHand();
	}

	@Override
	public boolean isActiveItemStackBlocking() {
		return master != null ? master.isActiveItemStackBlocking() : super.isActiveItemStackBlocking();
	}

	@Override
	public boolean superIsActiveItemStackBlocking() {
		return super.isActiveItemStackBlocking();
	}

	@Override
	public boolean isElytraFlying() {
		return master != null ? master.isElytraFlying() : super.isElytraFlying();
	}

	@Override
	public boolean superIsElytraFlying() {
		return super.isElytraFlying();
	}

	@Override
	public int getTicksElytraFlying() {
		return master != null ? master.getTicksElytraFlying() : super.getTicksElytraFlying();
	}

	@Override
	public int superGetTicksElytraFlying() {
		return super.getTicksElytraFlying();
	}

	@Override
	public boolean canBeHitWithPotion() {
		return master != null ? master.canBeHitWithPotion() : super.canBeHitWithPotion();
	}

	@Override
	public boolean superCanBeHitWithPotion() {
		return super.canBeHitWithPotion();
	}

	@Override
	public Set<String> getTags() {
		return (Set<String>) (master != null ? master.getTags() : super.getTags());
	}

	@Override
	public Set<String> superGetTags() {
		return super.getTags();
	}

	@Override
	public boolean addTag(String tag) {
		return master != null ? master.addTag(tag) : super.addTag(tag);
	}

	@Override
	public boolean superAddTag(String tag) {
		return super.addTag(tag);
	}

	@Override
	public boolean removeTag(String tag) {
		return master != null ? master.removeTag(tag) : super.removeTag(tag);
	}

	@Override
	public boolean superRemoveTag(String tag) {
		return super.removeTag(tag);
	}

	@Override
	public boolean equals(Object p_equals_1_) {
		return master != null ? master.equals(p_equals_1_) : super.equals(p_equals_1_);
	}

	@Override
	public boolean superEquals(Object p_equals_1_) {
		return super.equals(p_equals_1_);
	}

	@Override
	public int hashCode() {
		return master != null ? master.hashCode() : super.hashCode();
	}

	@Override
	public int superHashCode() {
		return super.hashCode();
	}

	@Override
	public void setDropItemsWhenDead(boolean p_184174_1_) {
		if (master != null) master.setDropItemsWhenDead(p_184174_1_);
		else super.setDropItemsWhenDead(p_184174_1_);
	}

	@Override
	public void superSetDropItemsWhenDead(boolean p_184174_1_) {
		super.setDropItemsWhenDead(p_184174_1_);
	}

	@Override
	protected void decrementTimeUntilPortal() {
		if (master != null) master.decrementTimeUntilPortal();
		else super.decrementTimeUntilPortal();
	}

	@Override
	public void superDecrementTimeUntilPortal() {
		super.decrementTimeUntilPortal();
	}

	@Override
	public void resetPositionToBB() {
		if (master != null) master.resetPositionToBB();
		else super.resetPositionToBB();
	}

	@Override
	public void superResetPositionToBB() {
		super.resetPositionToBB();
	}

	@Override
	public void applyOrientationToEntity(Entity entity) {
		if (master != null) master.applyOrientationToEntity(entity);
		else super.applyOrientationToEntity(entity);
	}

	@Override
	public void superApplyOrientationToEntity(Object entity) {
		super.applyOrientationToEntity((Entity) entity);
	}

	@Override
	public boolean startRiding(Entity entity, boolean force) {
		return master != null ? master.startRiding(entity, force) : super.startRiding(entity, force);
	}

	@Override
	public boolean superStartRiding(Object entity, boolean force) {
		return super.startRiding((Entity) entity, force);
	}

	@Override
	protected boolean canBeRidden(Entity entity) {
		return master != null ? master.canBeRidden(entity) : super.canBeRidden(entity);
	}

	@Override
	public boolean superCanBeRidden(Object entity) {
		return super.canBeRidden((Entity) entity);
	}

	@Override
	public void removePassengers() {
		if (master != null) master.removePassengers();
		else super.removePassengers();
	}

	@Override
	public void superRemovePassengers() {
		super.removePassengers();
	}

	@Override
	protected void addPassenger(Entity entity) {
		if (master != null) master.addPassenger(entity);
		else super.addPassenger(entity);
	}

	@Override
	public void superAddPassenger(Object entity) {
		super.addPassenger((Entity) entity);
	}

	@Override
	protected void removePassenger(Entity entity) {
		if (master != null) master.removePassenger(entity);
		else super.removePassenger(entity);
	}

	@Override
	public void superRemovePassenger(Object entity) {
		super.removePassenger((Entity) entity);
	}

	@Override
	protected boolean canFitPassenger(Entity entity) {
		return master != null ? master.canFitPassenger(entity) : super.canFitPassenger(entity);
	}

	@Override
	public boolean superCanFitPassenger(Object entity) {
		return super.canFitPassenger((Entity) entity);
	}

	@Override
	public Iterable<ItemStack> getEquipmentAndArmor() {
		return (Iterable<ItemStack>) (master != null ? master.getEquipmentAndArmor() : super.getEquipmentAndArmor());
	}

	@Override
	public Iterable<ItemStack> superGetEquipmentAndArmor() {
		return super.getEquipmentAndArmor();
	}

	@Override
	public boolean isBeingRidden() {
		return master != null ? master.isBeingRidden() : super.isBeingRidden();
	}

	@Override
	public boolean superIsBeingRidden() {
		return super.isBeingRidden();
	}

	@Override
	public boolean isGlowing() {
		return master != null ? master.isGlowing() : super.isGlowing();
	}

	@Override
	public boolean superIsGlowing() {
		return super.isGlowing();
	}

	@Override
	public void setGlowing(boolean p_184195_1_) {
		if (master != null) master.setGlowing(p_184195_1_);
		else super.setGlowing(p_184195_1_);
	}

	@Override
	public void superSetGlowing(boolean p_184195_1_) {
		super.setGlowing(p_184195_1_);
	}

	@Override
	public boolean isOnScoreboardTeam(Team team) {
		return master != null ? master.isOnScoreboardTeam(team) : super.isOnScoreboardTeam(team);
	}

	@Override
	public boolean superIsOnScoreboardTeam(Object team) {
		return super.isOnScoreboardTeam((Team) team);
	}

	@Override
	public void setEntityInvulnerable(boolean isInvulnerable) {
		if (master != null) master.setEntityInvulnerable(isInvulnerable);
		else super.setEntityInvulnerable(isInvulnerable);
	}

	@Override
	public void superSetEntityInvulnerable(boolean isInvulnerable) {
		super.setEntityInvulnerable(isInvulnerable);
	}

	@Override
	public boolean isNonBoss() {
		return master != null ? master.isNonBoss() : super.isNonBoss();
	}

	@Override
	public boolean superIsNonBoss() {
		return super.isNonBoss();
	}

	@Override
	public Vec3d getLastPortalVec() {
		return (Vec3d) (master != null ? master.getLastPortalVec() : super.getLastPortalVec());
	}

	@Override
	public Vec3d superGetLastPortalVec() {
		return super.getLastPortalVec();
	}

	@Override
	public EnumFacing getTeleportDirection() {
		return (EnumFacing) (master != null ? master.getLastPortalVec() : super.getTeleportDirection());
	}

	@Override
	public EnumFacing superGetTeleportDirection() {
		return super.getTeleportDirection();
	}

	@Override
	public void setUniqueId(UUID uniqueIdIn) {
		if (master != null) master.setUniqueId(uniqueIdIn);
		else super.setUniqueId(uniqueIdIn);
	}

	@Override
	public void superSetUniqueId(UUID uniqueIdIn) {
		super.setUniqueId(uniqueIdIn);
	}

	@Override
	public EnumFacing getAdjustedHorizontalFacing() {
		return (EnumFacing) (master != null ? master.getAdjustedHorizontalFacing() : super.getAdjustedHorizontalFacing());
	}

	@Override
	public EnumFacing superGetAdjustedHorizontalFacing() {
		return super.getAdjustedHorizontalFacing();
	}

	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return (AxisAlignedBB) (master != null ? master.getRenderBoundingBox() : super.getRenderBoundingBox());
	}

	@Override
	public AxisAlignedBB superGetRenderBoundingBox() {
		return super.getRenderBoundingBox();
	}

	@Override
	public MinecraftServer getServer() {
		return (MinecraftServer) (master != null ? master.getServer() : super.getServer());
	}

	@Override
	public MinecraftServer superGetServer() {
		return super.getServer();
	}

	@Override
	public ItemStack getPickedResult(RayTraceResult rayTraceResult) {
		return (ItemStack) (master != null ? master.getPickedResult(rayTraceResult) : super.getPickedResult(rayTraceResult));
	}

	@Override
	public ItemStack superGetPickedResult(Object rayTraceResult) {
		return super.getPickedResult((RayTraceResult) rayTraceResult);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing enumFacing) {
		return master != null ? master.hasCapability(capability, enumFacing) : super.hasCapability(capability, enumFacing);
	}

	@Override
	public boolean superHasCapability(Object capability, Object enumFacing) {
		return super.hasCapability((Capability) capability, (EnumFacing) enumFacing);
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing enumFacing) {
		return (T) (master != null ? master.getCapability(capability, enumFacing) : super.getCapability(capability, enumFacing));
	}

	@Override
	public Object superGetCapability(Object capability, Object enumFacing) {
		return super.getCapability((Capability) capability, (EnumFacing) enumFacing);
	}

	@Override
	public void deserializeNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.deserializeNBT(nBTTagCompound);
		else super.deserializeNBT(nBTTagCompound);
	}

	@Override
	public void superDeserializeNBT(Object nBTTagCompound) {
		super.deserializeNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public NBTTagCompound serializeNBT() {
		return (NBTTagCompound) (master != null ? master.serializeNBT() : super.serializeNBT());
	}

	@Override
	public NBTTagCompound superSerializeNBT() {
		return super.serializeNBT();
	}

	@Override
	public float getRotatedYaw(Rotation rotation) {
		return master != null ? master.getRotatedYaw(rotation) : super.getRotatedYaw(rotation);
	}

	@Override
	public float superGetRotatedYaw(Object rotation) {
		return super.getRotatedYaw((Rotation) rotation);
	}

	@Override
	public float getMirroredYaw(Mirror mirror) {
		return master != null ? master.getMirroredYaw(mirror) : super.getMirroredYaw(mirror);
	}

	@Override
	public float superGetMirroredYaw(Object mirror) {
		return super.getMirroredYaw((Mirror) mirror);
	}

	@Override
	public boolean setPositionNonDirty() {
		return master != null ? master.setPositionNonDirty() : super.setPositionNonDirty();
	}

	@Override
	public boolean superSetPositionNonDirty() {
		return super.setPositionNonDirty();
	}

	@Override
	public Entity getControllingPassenger() {
		return (Entity) (master != null ? master.getControllingPassenger() : super.getControllingPassenger());
	}

	@Override
	public Entity superGetControllingPassenger() {
		return super.getControllingPassenger();
	}

	@Override
	public List<Entity> getPassengers() {
		return (List<Entity>) (master != null ? master.getPassengers() : super.getPassengers());
	}

	@Override
	public List<Entity> superGetPassengers() {
		return super.getPassengers();
	}

	@Override
	public boolean isPassenger(Entity entity) {
		return master != null ? master.isPassenger(entity) : super.isPassenger(entity);
	}

	@Override
	public boolean superIsPassenger(Object entity) {
		return super.isPassenger((Entity) entity);
	}

	@Override
	public Collection<Entity> getRecursivePassengers() {
		return (Collection<Entity>) (master != null ? master.getRecursivePassengers() : super.getRecursivePassengers());
	}

	@Override
	public Collection<Entity> superGetRecursivePassengers() {
		return super.getRecursivePassengers();
	}

	@Override
	public <T extends Entity> Collection<T> getRecursivePassengersByType(Class<T> entityClass) {
		return (Collection) (master != null ? master.getRecursivePassengersByType(entityClass) : super.getRecursivePassengersByType(entityClass));
	}

	@Override
	public Object superGetRecursivePassengersByType(Class entityClass) {
		return super.getRecursivePassengersByType(entityClass);
	}

	@Override
	public Entity getLowestRidingEntity() {
		return (Entity) (master != null ? master.getLowestRidingEntity() : super.getLowestRidingEntity());
	}

	@Override
	public Entity superGetLowestRidingEntity() {
		return super.getLowestRidingEntity();
	}

	@Override
	public boolean isRidingSameEntity(Entity entity) {
		return master != null ? master.isRidingSameEntity(entity) : super.isRidingSameEntity(entity);
	}

	@Override
	public boolean superIsRidingSameEntity(Object entity) {
		return super.isRidingSameEntity((Entity) entity);
	}

	@Override
	public boolean isRidingOrBeingRiddenBy(Entity entity) {
		return master != null ? master.isRidingOrBeingRiddenBy(entity) : super.isRidingOrBeingRiddenBy(entity);
	}

	@Override
	public boolean superIsRidingOrBeingRiddenBy(Object entity) {
		return super.isRidingOrBeingRiddenBy((Entity) entity);
	}

	@Override
	public boolean canPassengerSteer() {
		return master != null ? master.canPassengerSteer() : super.canPassengerSteer();
	}

	@Override
	public boolean superCanPassengerSteer() {
		return super.canPassengerSteer();
	}

	@Override
	public Entity getRidingEntity() {
		return (Entity) (master != null ? master.getRidingEntity() : super.getRidingEntity());
	}

	@Override
	public Entity superGetRidingEntity() {
		return super.getRidingEntity();
	}

	@Override
	public EnumPushReaction getPushReaction() {
		return (EnumPushReaction) (master != null ? master.getPushReaction() : super.getPushReaction());
	}

	@Override
	public EnumPushReaction superGetPushReaction() {
		return super.getPushReaction();
	}
	// ~152
	@Override
	public void superUpdateCloak() {
	}

	@Override
	public void superSendChatToPlayer(String par1Str) {
	}

	@Override
	public int superGetMaxHealth() {
		return (int) getMaxHealth();
	}

	@Override
	public void superAlertWolves(Object entityLiving, boolean par2) {
	}

	@Override
	public void superDamageArmor(int par1) {
		super.damageArmor(par1);
	}

	@Override
	public boolean superFunc_71066_bF() {
		return false;
	}

	@Override
	public void superFunc_82162_bC() {
	}

	@Override
	public boolean superCanCurrentToolHarvestBlock(int par1, int par2, int par3) {
		return false;
	}

	@Override
	public boolean superFunc_94062_bN() {
		return false;
	}

	@Override
	public boolean superCanPickUpLoot() {
		return false;
	}

	@Override
	public Object superGetTranslator() {
		return null;
	}

	@Override
	public String superTranslateString(String par1Str, Object... par2ArrayOfObj) {
		return null;
	}

	@Override
	public int superFunc_96121_ay() {
		return -1;
	}

	@Override
	public Object superGetLookHelper() {
		return null;
	}

	@Override
	public Object superGetMoveHelper() {
		return null;
	}

	@Override
	public Object superGetJumpHelper() {
		return null;
	}

	@Override
	public Object superGetNavigator() {
		return null;
	}

	@Override
	public Object superGetEntitySenses() {
		return null;
	}

	@Override
	public Object superGetAttackTarget() {
		return null;
	}

	@Override
	public void superSetAttackTarget(Object entityLiving) {
	}

	@Override
	public boolean superCanAttackClass(Class par1Class) {
		return false;
	}

	@Override
	public void superEatGrassBonus() {
	}

	@Override
	public boolean superIsWithinHomeDistanceCurrentPosition() {
		return false;
	}

	@Override
	public boolean superIsWithinHomeDistance(int par1, int par2, int par3) {
		return false;
	}

	@Override
	public void superSetHomeArea(int par1, int par2, int par3, int par4) {
	}

	@Override
	public Object superGetHomePosition() {
		return null;
	}

	@Override
	public float superGetMaximumHomeDistance() {
		return 0;
	}

	@Override
	public void superDetachHome() {
	}

	@Override
	public boolean superHasHome() {
		return false;
	}

	@Override
	public String superGetTexture() {
		return null;
	}

	@Override
	public int superGetTalkInterval() {
		return -1;
	}

	@Override
	public void superPlayLivingSound() {
	}

	@Override
	public void superSpawnExplosionParticle() {
	}

	@Override
	public int superGetHealthInt() {
		return (int) super.getHealth();
	}

	@Override
	public String superGetLivingSound() {
		return null;
	}

	@Override
	public int superGetDropItemId() {
		return 0;
	}

	@Override
	public void superSetMoveForward(float par1) {
	}

	@Override
	public boolean superCanDespawn() {
		return false;
	}

	@Override
	public void superDespawnEntity() {
	}

	@Override
	public int superGetVerticalFaceSpeed() {
		return 0;
	}

	@Override
	public void superFaceEntity(Object entity, float par2, float par3) {
	}

	@Override
	public boolean superGetCanSpawnHere() {
		return false;
	}

	@Override
	public float superGetRenderSizeModifier() {
		return 0;
	}

	@Override
	public int superGetMaxSpawnedInChunk() {
		return 0;
	}

	@Override
	public float superGetSpeedModifier() {
		return 0;
	}

	@Override
	public void superInitCreature() {
	}

	@Override
	public boolean superCanBeSteered() {
		return false;
	}

	@Override
	public void superFunc_94058_c(String par1Str) {
	}

	@Override
	public String superFunc_94057_bL() {
		return null;
	}

	@Override
	public boolean superFunc_94056_bM() {
		return false;
	}

	@Override
	public void superSetNoAI(boolean par1) {
	}

	@Override
	public void superFunc_96120_a(int par1, float par2) {
	}

	@Override
	public void superSetCanPickUpLoot(boolean par1) {
	}

	@Override
	public boolean superIsNoDespawnRequired() {
		return false;
	}

	@Override
	public boolean superAddNotRiddenEntityID(Object nBTTagCompound) {
		return false;
	}

	@Override
	public boolean superAddEntityID(Object nBTTagCompound) {
		return false;
	}

	@Override
	public boolean superInteract(Object entityPlayer) {
		return false;
	}

	@Override
	public void superUnmountEntity(Object entity) {
		superStartRiding(entity);
	}

	@Override
	public float superFunc_82146_a(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return 0.0F;
	}

	@Override
	public boolean superFunc_96091_a(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7) {
		return false;
	}
	// ~164
	@Override
	public void superSendChatToPlayer(Object chatMessageComponent) {
	}

	@Override
	public void superSetupCustomSkin() {
	}

	@Override
	public Object superGetTextureSkin() {
		return null;
	}

	@Override
	public Object superGetTextureCape() {
		return null;
	}

	@Override
	public Object superDropPlayerItem(Object itemStack) {
		return null;
	}

	@Override
	public float superGetCurrentPlayerStrVsBlock(Object block, boolean par2, int meta) {
		return 0.0F;
	}

	@Override
	public void superDisplayGUIHopper(Object tileEntityHopper) {
	}

	@Override
	public void superDisplayGUIFurnace(Object tileEntityFurnace) {
	}

	@Override
	public void superDisplayGUIDispenser(Object tileEntityDispenser) {
	}

	@Override
	public void superDisplayGUIEditSign(Object tileEntity) {
	}

	@Override
	public void superDisplayGUIBrewingStand(Object tileEntityBrewingStand) {
	}

	@Override
	public void superDisplayGUIBeacon(Object tileEntityBeacon) {
	}

	@Override
	public void superAddChatMessage(String par1Str) {

	}

	@Override
	public String superGetEntityName() {
		return null;
	}

	@Override
	public Object superGetCurrentItemOrArmor(int par1) {
		return null;
	}

	@Override
	public String superGetTranslatedEntityName() {
		return null;
	}

	@Override
	public boolean superIsInRangeToRenderVec3D(Object vec3) {
		return false;
	}

	@Override
	public float superGetBlockExplosionResistance(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return 0.0F;
	}

	@Override
	public boolean superShouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7) {
		return false;
	}
	// ~189
	public ItemStack getItemInUse() {
		return null;
	}

	@Override
	public Object superGetItemInUse() {
		return null;
	}

	public boolean isUsingItem() {
		return false;
	}

	@Override
	public boolean superIsUsingItem() {
		return false;
	}

	public void destroyCurrentEquippedItem() {
	}

	@Override
	public void superDestroyCurrentEquippedItem() {
	}

	public void setItemInUse(ItemStack itemStack, int duration) {
	}

	@Override
	public void superSetItemInUse(Object itemStack, int duration) {
	}

	public ItemStack[] getInventory() {
		return null;
	}

	@Override
	public ItemStack[] superGetInventory() {
		return null;
	}

	public boolean isOnTeam(Team team) {
		return false;
	}

	@Override
	public boolean superIsOnTeam(Object team) {
		return false;
	}

	public boolean isEating() {
		return false;
	}

	@Override
	public boolean superIsEating() {
		return false;
	}

	public void setEating(boolean p_70019_1_) {
	}

	@Override
	public void superSetEating(boolean p_70019_1_) {
	}

	public void copyDataFromOld(Entity entity) {
	}

	@Override
	public void superCopyDataFromOld(Object entity) {
	}

	public void onDataWatcherUpdate(int p_145781_1_) {
	}

	@Override
	public void superOnDataWatcherUpdate(int p_145781_1_) {
	}

	public int getItemInUseDuration() {
		return -1;
	}

	@Override
	public int superGetItemInUseDuration() {
		return -1;
	}

	public NBTTagCompound getNBTTagCompound() {
		return null;
	}

	@Override
	public NBTTagCompound superGetNBTTagCompound() {
		return null;
	}

	public void clientUpdateEntityNBT(NBTTagCompound nBTTagCompound) {
	}

	@Override
	public void superClientUpdateEntityNBT(Object nBTTagCompound) {
	}

	public boolean interactAt(EntityPlayer entityPlayer, Vec3d vec3) {
		return false;
	}

	@Override
	public boolean superInteractAt(Object entityPlayer, Object vec3) {
		return false;
	}

	public String registerExtendedProperties(String identifier, Object iExtendedEntityProperties) {
		return null;
	}

	@Override
	public String superRegisterExtendedProperties(String identifier, Object iExtendedEntityProperties) {
		return null;
	}

	public Object getExtendedProperties(String identifier) {
		return null;
	}

	@Override
	public Object superGetExtendedProperties(String identifier) {
		return null;
	}

	public void stopUsingItem() {
	}

	@Override
	public void superStopUsingItem() {
	}

	public void clearItemInUse() {
	}

	@Override
	public void superClearItemInUse() {
	}

	public boolean isBlocking() {
		return false;
	}

	@Override
	public boolean superIsBlocking() {
		return false;
	}

	@Override
	public void setMovementSpeed(double d) {
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(d);
	}

	@Override
	public void setMaxHealth(double d) {
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(d);
	}

	@Override
	public void setFollowRange(double d) {
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(d);
	}

	@Override
	public void setKnockbackResistance(double d) {
		getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(d);
	}

	@Override
	public void setAttackDamage(double d) {
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(d);
	}

	@Override
	public Object getFreeVariable(String s) {
		return master.getFreeVariable(s);
	}

	@Override
	public void setFreeVariable(String s, Object o) {
		master.setFreeVariable(s, o);
	}

	@Override
	public Object superGetFreeVariable(String s) {
		return null;
	}

	@Override
	public void superSetFreeVariable(String s, Object o) {
	}

	@Override
	public Object superGetLastAttackingEntity() {
		return null;
	}

	@Override
	public void superSetLastAttackingEntity(Object entity) {
	}

	@Override
	public void superHeal(int par1) {
		super.heal(par1);
	}

	@Override
	public Object superGetHealth() {
		return super.getHealth();
	}

	@Override
	public boolean superAttackEntityFrom(Object damageSource, int par2) {
		return super.attackEntityFrom((DamageSource) damageSource, (float) par2);
	}

	@Override
	public Object superApplyArmorCalculations(Object damageSource, int par2) {
		return super.applyArmorCalculations((DamageSource) damageSource, par2);
	}

	@Override
	public Object superApplyPotionDamageCalculations(Object damageSource, int par2) {
		return super.applyPotionDamageCalculations((DamageSource) damageSource, par2);
	}

	@Override
	public void superDamageEntity(Object damageSource, int par2) {
		super.damageEntity((DamageSource) damageSource, (float) par2);
	}

	@Override
	public void superKnockBack(Object entity, int par2, double par3, double par5) {
		super.knockBack((Entity) entity, par2, par3, par5);
	}

	@Override
	public boolean superIsPotionActive(int par1) {
		return false;
	}

	@Override
	public void superRemovePotionEffectClient(int par1) {
	}

	@Override
	public void superRemovePotionEffect(int par1) {
	}

	@Override
	public void superOnChangedPotionEffect(Object potionEffect) {
	}

	@Override
	public Object superGetItemStackFromSlot(int par1) {
		return null;
	}

	@Override
	public void superDropLoot() {
	}

	@Override
	public void superSwingArm() {
		swingArm(EnumHand.MAIN_HAND);
	}

	@Override
	public void superPlayStepSound(int par1, int par2, int par3, Object par4) {
		superPlayStepSound(new BlockPos(par1, par2, par3), par4);
	}

	@Override
	public boolean superIsNotColliding() {
		return false;
	}

	@Override
	public boolean superIsInRangeToRender3d(Object vec3) {
		return true;
	}

	@Override
	public void superSetPortal() {
	}

	@Override
	public void superHeal(Object par1) {
		super.heal((Float) par1);
	}

	@Override
	public void superSetHealth(Object par1) {
		super.setHealth((Float) par1);
	}

	@Override
	public void superDamageEntity(Object damageSource, Object par2) {
		super.damageEntity((DamageSource) damageSource, (Float) par2);
	}

	@Override
	public void superFunc_180433_a(double p_180433_1_, boolean p_180433_3_, Object block, Object blockPos) {
	}

	@Override
	public void superFunc_145781_i(int p_145781_1_) {
	}

	@Override
	public boolean superCanUseCommand(int permLevel, String commandName) {
		return false;
	}

	@Override
	public Object superFunc_174819_aU() {
		return null;
	}

	@Override
	public void superFunc_174834_g(Object nBTTagCompound) {
	}

	@Override
	public boolean superFunc_174825_a(Object entityPlayer, Object vec3) {
		return false;
	}

	@Override
	public boolean superAttackEntityFrom(Object damageSource, Object p_70097_2_) {
		return super.attackEntityFrom((DamageSource) damageSource, (Float) p_70097_2_);
	}

	@Override
	public boolean superProcessInitialInteract(Object entityPlayer) {
		return false;
	}

	@Override
	public boolean superShouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, Object par6, float par7) {
		return false;
	}

	@Override
	public void superSetItemStackToSlot(int slotIn, Object itemStack) {
	}

	@Override
	public boolean superInteractWith(Object entity) {
		return false;
	}

	@Override
	public void superAddRandomDrop() {
	}

	@Override
	public boolean superInteractFirst(Object entityPlayer) {
		return false;
	}

	@Override
	public Object superGetAmbientSound() {
		return null;
	}

	@Override
	public void superInit() {
	}

	@Override
	public void superSetMaxHealth(Object floatOrInt) {
	}

	@Override
	public void superUpdatePassenger() {
	}

	@Override
	public void superSetCurrentItemOrArmor(int p_70062_1_, Object itemStack) {
	}

	@Override
	public void superOpenBook(Object itemStack) {
	}

	@Override
	public Object superGetCurrentArmor(int slotIn) {
		return null;
	}

	@Override
	public boolean superProcessInteract(Object entityPlayer) {
		return false;
	}

}
