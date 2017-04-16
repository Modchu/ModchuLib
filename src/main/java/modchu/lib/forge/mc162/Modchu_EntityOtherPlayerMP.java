package modchu.lib.forge.mc162;

import java.util.Collection;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_DataWatcherMaster2;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityOtherPlayerMP;
import modchu.lib.Modchu_IEntityOtherPlayerMPMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecartHopper;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumStatus;
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
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.CombatTracker;
import net.minecraft.util.DamageSource;
import net.minecraft.util.FoodStats;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class Modchu_EntityOtherPlayerMP extends EntityOtherPlayerMP implements Modchu_IEntityOtherPlayerMP {
	public Modchu_IEntityOtherPlayerMPMaster master;

	public Modchu_EntityOtherPlayerMP(HashMap<String, Object> map) {
		super((World)map.get("Object"), (String)map.get("String"));
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.lDebug("Modchu_EntityOtherPlayerMP init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IEntityOtherPlayerMPMaster ? (Modchu_IEntityOtherPlayerMPMaster) instance : null;
		if (master != null); else Modchu_Debug.lDebug("Modchu_EntityOtherPlayerMP init master == null !!");
		dataWatcher = (DataWatcher) Modchu_Main.newModchuCharacteristicObject("Modchu_DataWatcher", Modchu_DataWatcherMaster2.class, this, dataWatcher);
	}

	@Override
	public Object getRidingEntity2() {
		return superGetRidingEntity();
	}

	@Override
	public Object superGetRidingEntity2() {
		return superGetRidingEntity();
	}

	@Override
	public boolean isRiding2() {
		return isRiding();
	}

	@Override
	public boolean superIsRiding2() {
		return superIsRiding();
	}

	@Override
	public void dismountRidingEntity2() {
		superDismountRidingEntity();
	}

	@Override
	public void superDismountRidingEntity2() {
		superDismountRidingEntity();
	}

	@Override
	public int getDataWatcherWatchableObjectIdCount() {
		return 13;
	}

	@Override
	public void setDataWatcherWatchableObjectIdCount(int i) {
	}

	@Override
	public void entityDataManagerRegister(Class[] c1, int i, Object o) {
		dataWatcher.addObject(i, o);
	}

	@Override
	public Object getDataWatcherWatchableObject(int i) {
		Object watchedObject = Modchu_AS.get("DataWatcher", "getWatchedObject", new Class[]{ int.class }, dataWatcher, new Object[]{ i });
		return watchedObject != null ? Modchu_AS.get("net.minecraft.entity.DataWatcher$WatchableObject", "getObject", watchedObject) : null;
	}

	@Override
	public void setDataWatcherWatchableObject(int i, Object o) {
		dataWatcher.updateObject(i, o);
	}

	@Override
	public void setMovementSpeed(double d) {
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(d);
	}

	@Override
	public void setFollowRange(double d) {
		getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(d);
	}

	@Override
	public void setKnockbackResistance(double d) {
		getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setAttribute(d);
	}

	@Override
	public void setAttackDamage(double d) {
		getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(d);
	}

	@Override
	public void setMaxHealth(double d) {
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(d);
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
	public boolean attackEntityFrom(DamageSource damageSource, float p_70097_2_) {
		return master != null ? master.attackEntityFrom(damageSource, p_70097_2_) : super.attackEntityFrom(damageSource, p_70097_2_);
	}

	@Override
	public boolean superAttackEntityFrom(Object damageSource, float p_70097_2_) {
		return super.attackEntityFrom((DamageSource) damageSource, p_70097_2_);
	}

	@Override
	public void setPositionAndRotation2(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {
		if (master != null) master.setPositionAndRotationDirect(p_70056_1_, p_70056_3_, p_70056_5_, p_70056_7_, p_70056_8_, p_70056_9_);
		else super.setPositionAndRotation2(p_70056_1_, p_70056_3_, p_70056_5_, p_70056_7_, p_70056_8_, p_70056_9_);
	}

	@Override
	public void superSetPositionAndRotationDirect(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {
		super.setPositionAndRotation2(p_70056_1_, p_70056_3_, p_70056_5_, p_70056_7_, p_70056_8_, p_70056_9_);
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
	public float getShadowSize() {
		return master != null ? master.getShadowSize() : super.getShadowSize();
	}

	@Override
	public float superGetShadowSize() {
		return super.getShadowSize();
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
	public void setCurrentItemOrArmor(int p_70062_1_, ItemStack itemStack) {
		if (master != null) master.setCurrentItemOrArmor(p_70062_1_, itemStack);
		else super.setCurrentItemOrArmor(p_70062_1_, itemStack);
	}

	@Override
	public void superSetCurrentItemOrArmor(int p_70062_1_, Object itemStack) {
		super.setCurrentItemOrArmor(p_70062_1_, (ItemStack) itemStack);
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
	public void addChatMessage(String iChatComponent) {
		if (master != null) master.addChatMessage(iChatComponent);
		else super.addChatMessage(iChatComponent);
	}

	@Override
	public void superSendMessage(Object iChatComponent) {
		super.addChatMessage((String) iChatComponent);
	}

	@Override
	public boolean canCommandSenderUseCommand(int p_70003_1_, String p_70003_2_) {
		return master != null ? master.canUseCommand(p_70003_1_, p_70003_2_) : super.canCommandSenderUseCommand(p_70003_1_, p_70003_2_);
	}

	@Override
	public boolean superCanUseCommand(int p_70003_1_, String p_70003_2_) {
		return super.canCommandSenderUseCommand(p_70003_1_, p_70003_2_);
	}

	@Override
	public ChunkCoordinates getPlayerCoordinates() {
		return (ChunkCoordinates) (master != null ? master.getPlayerCoordinates() : super.getPlayerCoordinates());
	}

	@Override
	public ChunkCoordinates superGetPlayerCoordinates() {
		return super.getPlayerCoordinates();
	}

	public boolean func_152122_n() {
		return master != null ? master.hasPlayerInfo() : false;
	}

	@Override
	public boolean superHasPlayerInfo() {
		return false;
	}

	public boolean func_152123_o() {
		return master != null ? master.hasSkin() : false;
	}

	@Override
	public boolean superHasSkin() {
		return false;
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

	public void func_152121_a(Object type, ResourceLocation resourceLocation) {
	}

	@Override
	public void superFunc_152121_a(Object type, Object resourceLocation) {
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
	public ItemStack getItemInUse() {
		return (ItemStack) (master != null ? master.getItemInUse() : super.getItemInUse());
	}

	@Override
	public ItemStack superGetItemInUse() {
		return super.getItemInUse();
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
	public boolean isUsingItem() {
		return master != null ? master.isUsingItem() : super.isUsingItem();
	}

	@Override
	public boolean superIsUsingItem() {
		return super.isUsingItem();
	}

	@Override
	public int getItemInUseDuration() {
		return master != null ? master.getItemInUseDuration() : super.getItemInUseDuration();
	}

	@Override
	public int superGetItemInUseDuration() {
		return super.getItemInUseDuration();
	}

	@Override
	public void stopUsingItem() {
		if (master != null) master.stopUsingItem();
		else super.stopUsingItem();
	}

	@Override
	public void superStopUsingItem() {
		super.stopUsingItem();
	}

	@Override
	public void clearItemInUse() {
		if (master != null) master.clearItemInUse();
		else super.clearItemInUse();
	}

	@Override
	public void superClearItemInUse() {
		super.clearItemInUse();
	}

	@Override
	public boolean isBlocking() {
		return master != null ? master.isBlocking() : super.isBlocking();
	}

	@Override
	public boolean superIsBlocking() {
		return super.isBlocking();
	}

	@Override
	public int getMaxInPortalTime() {
		return master != null ? master.getMaxInPortalTime() : super.getMaxInPortalTime();
	}

	@Override
	public int superGetMaxInPortalTime() {
		return super.getMaxInPortalTime();
	}

	protected String getSwimSound() {
		return null;
	}

	@Override
	public String superGetSwimSound() {
		return null;
	}

	protected String getSplashSound() {
		return null;
	}

	@Override
	public String superGetSplashSound() {
		return null;
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
	public void playSound(String p_85030_1_, float p_85030_2_, float p_85030_3_) {
		if (master != null) master.playSound(p_85030_1_, p_85030_2_, p_85030_3_);
		else super.playSound(p_85030_1_, p_85030_2_, p_85030_3_);
	}

	@Override
	public void superPlaySound(Object p_85030_1_, float p_85030_2_, float p_85030_3_) {
		super.playSound((String) p_85030_1_, p_85030_2_, p_85030_3_);
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
	public void handleHealthUpdate(byte p_70103_1_) {
		if (master != null) master.handleStatusUpdate(p_70103_1_);
		else super.handleHealthUpdate(p_70103_1_);
	}

	@Override
	public void superHandleStatusUpdate(byte p_70103_1_) {
		super.handleHealthUpdate(p_70103_1_);
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
	public void mountEntity(Entity entity) {
		if (master != null) master.startRiding(entity);
		else super.mountEntity(entity);
	}

	@Override
	public boolean superStartRiding(Object entity) {
		super.mountEntity((Entity) entity);
		return true;
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
	protected String getHurtSound() {
		return (String) (master != null ? master.getHurtSound() : super.getHurtSound());
	}

	@Override
	public String superGetHurtSound() {
		return super.getHurtSound();
	}

	@Override
	protected String getDeathSound() {
		return (String) (master != null ? master.getDeathSound() : super.getDeathSound());
	}

	@Override
	public String superGetDeathSound() {
		return super.getDeathSound();
	}

	@Override
	public void addToPlayerScore(Entity entity, int p_70084_2_) {
		if (master != null) master.addToPlayerScore(entity, p_70084_2_);
		else super.addToPlayerScore(entity, p_70084_2_);
	}

	@Override
	public void superAddToPlayerScore(Object entity, int p_70084_2_) {
		super.addToPlayerScore((Entity) entity, p_70084_2_);
	}

	@Override
	public EntityItem dropOneItem(boolean p_71040_1_) {
		return (EntityItem) (master != null ? master.dropItem(p_71040_1_) : super.dropOneItem(p_71040_1_));
	}

	@Override
	public EntityItem superDropItem(boolean p_71040_1_) {
		return super.dropOneItem(p_71040_1_);
	}

	@Override
	public EntityItem dropPlayerItemWithRandomChoice(ItemStack itemStack, boolean p_71019_2_) {
		return (EntityItem) (master != null ? master.dropItem(itemStack, p_71019_2_) : super.dropPlayerItemWithRandomChoice(itemStack, p_71019_2_));
	}

	@Override
	public EntityItem superDropItem(Object itemStack, boolean p_71019_2_) {
		return super.dropPlayerItemWithRandomChoice((ItemStack) itemStack, p_71019_2_);
	}

	public EntityItem func_146097_a(ItemStack itemStack, boolean p_146097_2_, boolean p_146097_3_) {
		return null;
	}

	@Override
	public EntityItem superDropItem(Object itemStack, boolean p_146097_2_, boolean p_146097_3_) {
		return null;
	}

	@Override
	public void joinEntityItemWithWorld(EntityItem entityItem) {
		if (master != null) master.dropItemAndGetStack(entityItem);
		else super.joinEntityItemWithWorld(entityItem);
	}

	@Override
	public Object superDropItemAndGetStack(Object entityItem) {
		super.joinEntityItemWithWorld((EntityItem) entityItem);
		return ((EntityItem) entityItem).getEntityItem();
	}

	@Override
	public float getCurrentPlayerStrVsBlock(Block block, boolean p_146096_2_) {
		return master != null ? master.getCurrentPlayerStrVsBlock(block, p_146096_2_) : super.getCurrentPlayerStrVsBlock(block, p_146096_2_);
	}

	@Override
	public float superGetCurrentPlayerStrVsBlock(Object block, boolean p_146096_2_) {
		return super.getCurrentPlayerStrVsBlock((Block) block, p_146096_2_);
	}

	public float getBreakSpeed(Block block, boolean p_146096_2_, int meta) {
		return 0.0F;
	}

	@Override
	public float superGetBreakSpeed(Object block, boolean p_146096_2_, int meta) {
		return 0.0F;
	}

	public float getBreakSpeed(Block block, boolean p_146096_2_, int meta, int x, int y, int z) {
		return 0.0F;
	}

	@Override
	public float superGetBreakSpeed(Object block, boolean p_146096_2_, int meta, int x, int y, int z) {
		return 0.0F;
	}

	@Override
	public boolean canHarvestBlock(Block block) {
		return master != null ? master.canHarvestBlock(block) : super.canHarvestBlock(block);
	}

	@Override
	public boolean superCanHarvestBlock(Object block) {
		return super.canHarvestBlock((Block) block);
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
	public void displayGUIChest(IInventory iInventory) {
		if (master != null) master.displayGUIChest(iInventory);
		else super.displayGUIChest(iInventory);
	}

	@Override
	public void superDisplayGUIChest(Object iInventory) {
		super.displayGUIChest((IInventory) iInventory);
	}

	public void func_146093_a(TileEntityHopper tileEntityHopper) {
	}

	@Override
	public void superFunc_146093_a(Object tileEntityHopper) {
	}

	@Override
	public void displayGUIHopperMinecart(EntityMinecartHopper entityMinecartHopper) {
		if (master != null) master.displayGUIHopperMinecart(entityMinecartHopper);
		else super.displayGUIHopperMinecart(entityMinecartHopper);
	}

	@Override
	public void superDisplayGUIHopperMinecart(Object entityMinecartHopper) {
		super.displayGUIHopperMinecart((EntityMinecartHopper) entityMinecartHopper);
	}

	@Override
	public void displayGUIHorse(EntityHorse entityHorse, IInventory iInventory) {
		if (master != null) master.openGuiHorseInventory(entityHorse, iInventory);
		else super.displayGUIHorse(entityHorse, iInventory);
	}

	@Override
	public void superOpenGuiHorseInventory(Object entityHorse, Object iInventory) {
		super.displayGUIHorse((EntityHorse) entityHorse, (IInventory) iInventory);
	}

	@Override
	public void displayGUIEnchantment(int p_71002_1_, int p_71002_2_, int p_71002_3_, String p_71002_4_) {
		if (master != null) master.displayGUIEnchantment(p_71002_1_, p_71002_2_, p_71002_3_, p_71002_4_);
		else super.displayGUIEnchantment(p_71002_1_, p_71002_2_, p_71002_3_, p_71002_4_);
	}

	@Override
	public void superDisplayGUIEnchantment(int p_71002_1_, int p_71002_2_, int p_71002_3_, String p_71002_4_) {
		super.displayGUIEnchantment(p_71002_1_, p_71002_2_, p_71002_3_, p_71002_4_);
	}

	@Override
	public void displayGUIAnvil(int p_82244_1_, int p_82244_2_, int p_82244_3_) {
		if (master != null) master.displayGUIAnvil(p_82244_1_, p_82244_2_, p_82244_3_);
		else super.displayGUIAnvil(p_82244_1_, p_82244_2_, p_82244_3_);
	}

	@Override
	public void superDisplayGUIAnvil(int p_82244_1_, int p_82244_2_, int p_82244_3_) {
		super.displayGUIAnvil(p_82244_1_, p_82244_2_, p_82244_3_);
	}

	@Override
	public void displayGUIWorkbench(int p_71058_1_, int p_71058_2_, int p_71058_3_) {
		if (master != null) master.displayGUIWorkbench(p_71058_1_, p_71058_2_, p_71058_3_);
		else super.displayGUIWorkbench(p_71058_1_, p_71058_2_, p_71058_3_);
	}

	@Override
	public void superDisplayGUIWorkbench(int p_71058_1_, int p_71058_2_, int p_71058_3_) {
		super.displayGUIWorkbench(p_71058_1_, p_71058_2_, p_71058_3_);
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
	protected void damageEntity(DamageSource damageSource, float p_70665_2_) {
		if (master != null) master.damageEntity(damageSource, p_70665_2_);
		else super.damageEntity(damageSource, p_70665_2_);
	}

	@Override
	public void superDamageEntity(Object damageSource, float p_70665_2_) {
		super.damageEntity((DamageSource) damageSource, p_70665_2_);
	}

	public void func_146101_a(TileEntityFurnace tileEntityFurnace) {
	}

	@Override
	public void superFunc_146101_a(Object tileEntityFurnace) {
	}

	public void func_146102_a(TileEntityDispenser tileEntityDispenser) {
	}

	@Override
	public void superFunc_146102_a(Object tileEntityDispenser) {
	}

	public void func_146100_a(TileEntity tileEntity) {
	}

	@Override
	public void superFunc_146100_a(Object tileEntity) {
	}

	public void func_146095_a(Object commandBlockLogic) {
	}

	@Override
	public void superFunc_146095_a(Object commandBlockLogic) {
	}

	public void func_146098_a(TileEntityBrewingStand tileEntityBrewingStand) {
	}

	@Override
	public void superFunc_146098_a(Object tileEntityBrewingStand) {
	}

	public void func_146104_a(TileEntityBeacon tileEntityBeacon) {
	}

	@Override
	public void superFunc_146104_a(Object tileEntityBeacon) {
	}

	@Override
	public void displayGUIMerchant(IMerchant iMerchant, String p_71030_2_) {
		if (master != null) master.displayGUIMerchant(iMerchant, p_71030_2_);
		else super.displayGUIMerchant(iMerchant, p_71030_2_);
	}

	@Override
	public void superDisplayGUIMerchant(Object iMerchant, String p_71030_2_) {
		super.displayGUIMerchant((IMerchant) iMerchant, p_71030_2_);
	}

	@Override
	public void displayGUIBook(ItemStack itemStack) {
		if (master != null) master.openBook(itemStack);
		else super.displayGUIBook(itemStack);
	}

	@Override
	public void superOpenBook(Object itemStack) {
		super.displayGUIBook((ItemStack) itemStack);
	}

	@Override
	public boolean interactWith(Entity entity) {
		return master != null ? master.interactWith(entity) : super.interactWith(entity);
	}

	@Override
	public boolean superInteractWith(Object entity) {
		return super.interactWith((Entity) entity);
	}

	@Override
	public ItemStack getCurrentEquippedItem() {
		return (ItemStack) (master != null ? master.getHeldItemMainhand() : super.getCurrentEquippedItem());
	}

	@Override
	public ItemStack superGetHeldItemMainhand() {
		return super.getCurrentEquippedItem();
	}

	@Override
	public void destroyCurrentEquippedItem() {
		if (master != null) master.destroyCurrentEquippedItem();
		else super.destroyCurrentEquippedItem();
	}

	@Override
	public void superDestroyCurrentEquippedItem() {
		super.destroyCurrentEquippedItem();
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

	public Object getGameProfile() {
		return null;
	}

	@Override
	public Object superGetGameProfile() {
		return null;
	}

	@Override
	public EnumStatus sleepInBedAt(int p_71018_1_, int p_71018_2_, int p_71018_3_) {
		return (EnumStatus) (master != null ? master.sleepInBedAt(p_71018_1_, p_71018_2_, p_71018_3_) : super.sleepInBedAt(p_71018_1_, p_71018_2_, p_71018_3_));
	}

	@Override
	public EnumStatus superSleepInBedAt(int p_71018_1_, int p_71018_2_, int p_71018_3_) {
		return super.sleepInBedAt(p_71018_1_, p_71018_2_, p_71018_3_);
	}

	@Override
	public void wakeUpPlayer(boolean p_70999_1_, boolean p_70999_2_, boolean p_70999_3_) {
		if (master != null) master.wakeUpPlayer(p_70999_1_, p_70999_2_, p_70999_3_);
		else super.wakeUpPlayer(p_70999_1_, p_70999_2_, p_70999_3_);
	}

	@Override
	public void superWakeUpPlayer(boolean p_70999_1_, boolean p_70999_2_, boolean p_70999_3_) {
		super.wakeUpPlayer(p_70999_1_, p_70999_2_, p_70999_3_);
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
	protected boolean getHideCape(int p_82241_1_) {
		return master != null ? master.getHideCape(p_82241_1_) : super.getHideCape(p_82241_1_);
	}

	@Override
	public boolean superGetHideCape(int p_82241_1_) {
		return super.getHideCape(p_82241_1_);
	}

	@Override
	protected void setHideCape(int p_82239_1_, boolean p_82239_2_) {
		if (master != null) master.setHideCape(p_82239_1_, p_82239_2_);
		else super.setHideCape(p_82239_1_, p_82239_2_);
	}

	@Override
	public void superSetHideCape(int p_82239_1_, boolean p_82239_2_) {
		super.setHideCape(p_82239_1_, p_82239_2_);
	}

	public void sendStatusMessage(Object iChatComponent) {
	}

	@Override
	public void superSendStatusMessage(Object iChatComponent, boolean p_146105_2_) {
	}

	@Override
	public ChunkCoordinates getBedLocation() {
		return (ChunkCoordinates) (master != null ? master.getBedLocation() : super.getBedLocation());
	}

	@Override
	public ChunkCoordinates superGetBedLocation() {
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
	public void setSpawnChunk(ChunkCoordinates chunkCoordinates, boolean p_71063_2_) {
		if (master != null) master.setSpawnChunk(chunkCoordinates, p_71063_2_);
		else super.setSpawnChunk(chunkCoordinates, p_71063_2_);
	}

	@Override
	public void superSetSpawnChunk(Object chunkCoordinates, boolean p_71063_2_) {
		super.setSpawnChunk((ChunkCoordinates) chunkCoordinates, p_71063_2_);
	}

	@Override
	public void triggerAchievement(StatBase statBase) {
		if (master != null) master.addStat(statBase);
		else super.triggerAchievement(statBase);
	}

	@Override
	public void superAddStat(Object statBase) {
		super.triggerAchievement((StatBase) statBase);
	}

	@Override
	public void addStat(StatBase statBase, int p_71064_2_) {
		if (master != null) master.addStat(statBase, p_71064_2_);
		else super.addStat(statBase, p_71064_2_);
	}

	@Override
	public void superAddStat(Object statBase, int p_71064_2_) {
		super.addStat((StatBase) statBase, p_71064_2_);
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
	protected void fall(float p_70069_1_) {
		if (master != null) master.fall(p_70069_1_);
		else super.fall(p_70069_1_);
	}

	@Override
	public void superFall(float p_70069_1_) {
		super.fall(p_70069_1_);
	}

	protected String func_146067_o(int p_146067_1_) {
		return null;
	}

	@Override
	public String superFunc_146067_o(int p_146067_1_) {
		return null;
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
	public Icon getItemIcon(ItemStack itemStack, int p_70620_2_) {
		return (Icon) (master != null ? master.getItemIcon(itemStack, p_70620_2_) : super.getItemIcon(itemStack, p_70620_2_));
	}

	@Override
	public Icon superGetItemIcon(Object itemStack, int p_70620_2_) {
		return super.getItemIcon((ItemStack) itemStack, p_70620_2_);
	}

	@Override
	public ItemStack getCurrentArmor(int p_82169_1_) {
		return (ItemStack) (master != null ? master.getCurrentArmor(p_82169_1_) : super.getCurrentArmor(p_82169_1_));
	}

	@Override
	public ItemStack superGetCurrentArmor(int p_82169_1_) {
		return super.getCurrentArmor(p_82169_1_);
	}

	@Override
	public void addExperience(int p_71023_1_) {
		if (master != null) master.addExperience(p_71023_1_);
		else super.addExperience(p_71023_1_);
	}

	@Override
	public void superAddExperience(int p_71023_1_) {
		super.addExperience(p_71023_1_);
	}

	@Override
	public void addExperienceLevel(int p_82242_1_) {
		if (master != null) master.addExperienceLevel(p_82242_1_);
		else super.addExperienceLevel(p_82242_1_);
	}

	@Override
	public void superAddExperienceLevel(int p_82242_1_) {
		super.addExperienceLevel(p_82242_1_);
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
	public boolean canEat(boolean p_71043_1_) {
		return master != null ? master.canEat(p_71043_1_) : super.canEat(p_71043_1_);
	}

	@Override
	public boolean superCanEat(boolean p_71043_1_) {
		return super.canEat(p_71043_1_);
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
	public void setItemInUse(ItemStack itemStack, int p_71008_2_) {
		if (master != null) master.setItemInUse(itemStack, p_71008_2_);
		else super.setItemInUse(itemStack, p_71008_2_);
	}

	@Override
	public void superSetItemInUse(Object itemStack, int p_71008_2_) {
		super.setItemInUse((ItemStack) itemStack, p_71008_2_);
	}

	@Override
	public boolean isCurrentToolAdventureModeExempt(int p_82246_1_, int p_82246_2_, int p_82246_3_) {
		return master != null ? master.isCurrentToolAdventureModeExempt(p_82246_1_, p_82246_2_, p_82246_3_) : super.isCurrentToolAdventureModeExempt(p_82246_1_, p_82246_2_, p_82246_3_);
	}

	@Override
	public boolean superIsCurrentToolAdventureModeExempt(int p_82246_1_, int p_82246_2_, int p_82246_3_) {
		return super.isCurrentToolAdventureModeExempt(p_82246_1_, p_82246_2_, p_82246_3_);
	}

	@Override
	public boolean canPlayerEdit(int p_82247_1_, int p_82247_2_, int p_82247_3_, int p_82247_4_, ItemStack itemStack) {
		return master != null ? master.canPlayerEdit(p_82247_1_, p_82247_2_, p_82247_3_, p_82247_4_, itemStack) : super.canPlayerEdit(p_82247_1_, p_82247_2_, p_82247_3_, p_82247_4_, itemStack);
	}

	@Override
	public boolean superCanPlayerEdit(int p_82247_1_, int p_82247_2_, int p_82247_3_, int p_82247_4_, Object itemStack) {
		return super.canPlayerEdit(p_82247_1_, p_82247_2_, p_82247_3_, p_82247_4_, (ItemStack) itemStack);
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
	public void clonePlayer(EntityPlayer entityPlayer, boolean p_71049_2_) {
		if (master != null) master.clonePlayer(entityPlayer, p_71049_2_);
		else super.clonePlayer(entityPlayer, p_71049_2_);
	}

	@Override
	public void superClonePlayer(Object entityPlayer, boolean p_71049_2_) {
		super.clonePlayer((EntityPlayer) entityPlayer, p_71049_2_);
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

	public void setGameType(Object gameType) {
	}

	@Override
	public void superSetGameType(Object gameType) {
	}

	@Override
	public String getCommandSenderName() {
		return master != null ? master.getName() : super.getCommandSenderName();
	}

	@Override
	public String superGetName() {
		return super.getCommandSenderName();
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
	public InventoryEnderChest getInventoryEnderChest() {
		return (InventoryEnderChest) (master != null ? master.getInventoryEnderChest() : super.getInventoryEnderChest());
	}

	@Override
	public InventoryEnderChest superGetInventoryEnderChest() {
		return super.getInventoryEnderChest();
	}

	public ItemStack getEquipmentInSlot(int p_71124_1_) {
		return null;
	}

	@Override
	public ItemStack superGetItemStackFromSlot(int p_71124_1_) {
		return null;
	}

	@Override
	public ItemStack getHeldItem() {
		return (ItemStack) (master != null ? master.getHeldItem() : super.getHeldItem());
	}

	@Override
	public ItemStack superGetHeldItem() {
		return super.getHeldItem();
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
	public ItemStack[] getLastActiveItems() {
		return (ItemStack[]) (master != null ? master.getLastActiveItems() : super.getLastActiveItems());
	}

	@Override
	public ItemStack[] superGetLastActiveItems() {
		return super.getLastActiveItems();
	}

	@Override
	public boolean getHideCape() {
		return master != null ? master.getHideCape() : super.getHideCape();
	}

	@Override
	public boolean superGetHideCape() {
		return super.getHideCape();
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

	public Object func_145748_c_() {
		return null;
	}

	@Override
	public Object superGetDisplayName() {
		return null;
	}

	@Override
	public void setAbsorptionAmount(float p_110149_1_) {
		if (master != null) master.setAbsorptionAmount(p_110149_1_);
		else super.setAbsorptionAmount(p_110149_1_);
	}

	@Override
	public void superSetAbsorptionAmount(float p_110149_1_) {
		super.setAbsorptionAmount(p_110149_1_);
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
	public void openGui(Object mod, int modGuiId, World world, int x, int y, int z) {
		if (master != null) master.openGui(mod, modGuiId, world, x, y, z);
		else super.openGui(mod, modGuiId, world, x, y, z);
	}

	@Override
	public void superOpenGui(Object mod, int modGuiId, Object world, int x, int y, int z) {
		super.openGui(mod, modGuiId, (World) world, x, y, z);
	}

	@Override
	public Vec3 getPosition(float par1) {
		return (Vec3) (master != null ? master.getPosition(par1) : super.getPosition(par1));
	}

	@Override
	public Vec3 superGetPosition(float par1) {
		return super.getPosition(par1);
	}

	@Override
	public ChunkCoordinates getBedLocation(int dimension) {
		return (ChunkCoordinates) (master != null ? master.getBedLocation(dimension) : super.getBedLocation(dimension));
	}

	@Override
	public ChunkCoordinates superGetBedLocation(int dimension) {
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
	public void setSpawnChunk(ChunkCoordinates chunkCoordinates, boolean forced, int dimension) {
		if (master != null) master.setSpawnChunk(chunkCoordinates, forced, dimension);
		else super.setSpawnChunk(chunkCoordinates, forced, dimension);
	}

	@Override
	public void superSetSpawnChunk(Object chunkCoordinates, boolean forced, int dimension) {
		super.setSpawnChunk((ChunkCoordinates) chunkCoordinates, forced, dimension);
	}

	@Override
	public String getDisplayName() {
		return master != null ? master.getDisplayNameString() : super.getDisplayName();
	}

	@Override
	public String superGetDisplayNameString() {
		return super.getDisplayName();
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
	protected void updateFallState(double p_70064_1_, boolean p_70064_3_) {
		if (master != null) master.updateFallState(p_70064_1_, p_70064_3_);
		else super.updateFallState(p_70064_1_, p_70064_3_);
	}

	@Override
	public void superUpdateFallState(double p_70064_1_, boolean p_70064_3_) {
		super.updateFallState(p_70064_1_, p_70064_3_);
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

	protected boolean func_146066_aG() {
		return false;
	}

	@Override
	public boolean superCanDropLoot() {
		return false;
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
	public int func_142015_aE() {
		return master != null ? master.getRevengeTimer() : super.func_142015_aE();
	}

	@Override
	public int superGetRevengeTimer() {
		return super.func_142015_aE();
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
	public boolean isPotionActive(int p_82165_1_) {
		return master != null ? master.isPotionActive(p_82165_1_) : super.isPotionActive(p_82165_1_);
	}

	@Override
	public boolean superIsPotionActive(int p_82165_1_) {
		return super.isPotionActive(p_82165_1_);
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
	public void removePotionEffectClient(int p_70618_1_) {
		if (master != null) master.removePotionEffectClient(p_70618_1_);
		else super.removePotionEffectClient(p_70618_1_);
	}

	@Override
	public void superRemovePotionEffectClient(int p_70618_1_) {
		super.removePotionEffectClient(p_70618_1_);
	}

	@Override
	public void removePotionEffect(int p_82170_1_) {
		if (master != null) master.removePotionEffect(p_82170_1_);
		else super.removePotionEffect(p_82170_1_);
	}

	@Override
	public void superRemovePotionEffect(int p_82170_1_) {
		super.removePotionEffect(p_82170_1_);
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
	public void heal(float p_70691_1_) {
		if (master != null) master.heal(p_70691_1_);
		else super.heal(p_70691_1_);
	}

	@Override
	public void superHeal(float p_70691_1_) {
		super.heal(p_70691_1_);
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
	protected void dropRareDrop(int p_70600_1_) {
		if (master != null) master.dropRareDrop(p_70600_1_);
		else super.dropRareDrop(p_70600_1_);
	}

	@Override
	public void superDropRareDrop(int p_70600_1_) {
		super.dropRareDrop(p_70600_1_);
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
	public CombatTracker func_110142_aN() {
		return (CombatTracker) (master != null ? master.getCombatTracker() : super.func_110142_aN());
	}

	@Override
	public CombatTracker superGetCombatTracker() {
		return super.func_110142_aN();
	}

	@Override
	public EntityLivingBase func_94060_bK() {
		return (EntityLivingBase) (master != null ? master.getAttackingEntity() : super.func_94060_bK());
	}

	@Override
	public EntityLivingBase superGetAttackingEntity() {
		return super.func_94060_bK();
	}

	@Override
	public void swingItem() {
		if (master != null) master.swingArm();
		else super.swingItem();
	}

	@Override
	public void superSwingArm() {
		super.swingItem();
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

	public Object getEntityAttribute(Object iAttribute) {
		return null;
	}

	@Override
	public Object superGetEntityAttribute(Object iAttribute) {
		return null;
	}

	@Override
	public BaseAttributeMap getAttributeMap() {
		return (BaseAttributeMap) (master != null ? master.getAttributeMap() : super.getAttributeMap());
	}

	@Override
	public BaseAttributeMap superGetAttributeMap() {
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
	public void setSprinting(boolean p_70031_1_) {
		if (master != null) master.setSprinting(p_70031_1_);
		else super.setSprinting(p_70031_1_);
	}

	@Override
	public void superSetSprinting(boolean p_70031_1_) {
		super.setSprinting(p_70031_1_);
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
	public void setPositionAndUpdate(double p_70634_1_, double p_70634_3_, double p_70634_5_) {
		if (master != null) master.setPositionAndUpdate(p_70634_1_, p_70634_3_, p_70634_5_);
		else super.setPositionAndUpdate(p_70634_1_, p_70634_3_, p_70634_5_);
	}

	@Override
	public void superSetPositionAndUpdate(double p_70634_1_, double p_70634_3_, double p_70634_5_) {
		super.setPositionAndUpdate(p_70634_1_, p_70634_3_, p_70634_5_);
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
	protected boolean isAIEnabled() {
		return master != null ? master.isAIEnabled() : super.isAIEnabled();
	}

	@Override
	public boolean superIsAIEnabled() {
		return super.isAIEnabled();
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
	protected float func_110146_f(float p_110146_1_, float p_110146_2_) {
		return master != null ? master.updateDistance(p_110146_1_, p_110146_2_) : super.func_110146_f(p_110146_1_, p_110146_2_);
	}

	@Override
	public float superUpdateDistance(float p_110146_1_, float p_110146_2_) {
		return super.func_110146_f(p_110146_1_, p_110146_2_);
	}

	@Override
	protected void updateAITasks() {
		if (master != null) master.updateAITasks();
		else super.updateAITasks();
	}

	@Override
	public void superUpdateAITasks() {
		super.updateAITasks();
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
	protected void updateAITick() {
		if (master != null) master.handleJumpWater();
		else super.updateAITick();
	}

	@Override
	public void superHandleJumpWater() {
		super.updateAITick();
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
	public Vec3 getLookVec() {
		return (Vec3) (master != null ? master.getLookVec() : super.getLookVec());
	}

	@Override
	public Vec3 superGetLookVec() {
		return super.getLookVec();
	}

	@Override
	public Vec3 getLook(float p_70676_1_) {
		return (Vec3) (master != null ? master.getLook(p_70676_1_) : super.getLook(p_70676_1_));
	}

	@Override
	public Vec3 superGetLook(float p_70676_1_) {
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
	public MovingObjectPosition rayTrace(double p_70614_1_, float p_70614_3_) {
		return (MovingObjectPosition) (master != null ? master.rayTrace(p_70614_1_, p_70614_3_) : super.rayTrace(p_70614_1_, p_70614_3_));
	}

	@Override
	public MovingObjectPosition superRayTrace(double p_70614_1_, float p_70614_3_) {
		return super.rayTrace(p_70614_1_, p_70614_3_);
	}

	@Override
	public boolean isClientWorld() {
		return master != null ? master.isClientWorld() : super.isClientWorld();
	}

	@Override
	public boolean superIsClientWorld() {
		return super.isClientWorld();
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
	public void setRotationYawHead(float p_70034_1_) {
		if (master != null) master.setRotationYawHead(p_70034_1_);
		else super.setRotationYawHead(p_70034_1_);
	}

	@Override
	public void superSetRotationYawHead(float p_70034_1_) {
		super.setRotationYawHead(p_70034_1_);
	}

	@Override
	public boolean isOnSameTeam(EntityLivingBase entityLivingBase) {
		return master != null ? master.isOnSameTeam(entityLivingBase) : super.isOnSameTeam(entityLivingBase);
	}

	@Override
	public boolean superIsOnSameTeam(Object entityLivingBase) {
		return super.isOnSameTeam((EntityLivingBase) entityLivingBase);
	}

	@Override
	public boolean isOnTeam(Team team) {
		return master != null ? master.isOnTeam(team) : super.isOnTeam(team);
	}

	@Override
	public boolean superIsOnTeam(Object team) {
		return super.isOnTeam((Team) team);
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

	public void func_152111_bt() {
	}

	@Override
	public void superSendEnterCombat() {
	}

	public void func_152112_bu() {
	}

	@Override
	public void superSendEndCombat() {
	}

	public int getEntityId() {
		return master != null ? master.getEntityId() : entityId;
	}

	@Override
	public int superGetEntityId() {
		return entityId;
	}

	public void setEntityId(int p_145769_1_) {
		if (master != null) master.setEntityId(p_145769_1_);
		else entityId = p_145769_1_;
	}

	@Override
	public void superSetEntityId(int p_145769_1_) {
		entityId = p_145769_1_;
	}

	@Override
	public DataWatcher getDataWatcher() {
		return (DataWatcher) (master != null ? master.getDataManager() : super.getDataWatcher());
	}

	@Override
	public DataWatcher superGetDataManager() {
		return super.getDataWatcher();
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
	protected void setSize(float p_70105_1_, float p_70105_2_) {
		if (master != null) master.setSize(p_70105_1_, p_70105_2_);
		else super.setSize(p_70105_1_, p_70105_2_);
	}

	@Override
	public void superSetSize(float p_70105_1_, float p_70105_2_) {
		super.setSize(p_70105_1_, p_70105_2_);
	}

	@Override
	protected void setRotation(float p_70101_1_, float p_70101_2_) {
		if (master != null) master.setRotation(p_70101_1_, p_70101_2_);
		else super.setRotation(p_70101_1_, p_70101_2_);
	}

	@Override
	public void superSetRotation(float p_70101_1_, float p_70101_2_) {
		super.setRotation(p_70101_1_, p_70101_2_);
	}

	@Override
	public void setPosition(double p_70107_1_, double p_70107_3_, double p_70107_5_) {
		if (master != null) master.setPosition(p_70107_1_, p_70107_3_, p_70107_5_);
		else super.setPosition(p_70107_1_, p_70107_3_, p_70107_5_);
	}

	@Override
	public void superSetPosition(double p_70107_1_, double p_70107_3_, double p_70107_5_) {
		super.setPosition(p_70107_1_, p_70107_3_, p_70107_5_);
	}

	@Override
	public void setAngles(float p_70082_1_, float p_70082_2_) {
		if (master != null) master.turn(p_70082_1_, p_70082_2_);
		else super.setAngles(p_70082_1_, p_70082_2_);
	}

	@Override
	public void superTurn(float p_70082_1_, float p_70082_2_) {
		super.setAngles(p_70082_1_, p_70082_2_);
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
	public void setFire(int p_70015_1_) {
		if (master != null) master.setFire(p_70015_1_);
		else super.setFire(p_70015_1_);
	}

	@Override
	public void superSetFire(int p_70015_1_) {
		super.setFire(p_70015_1_);
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
	public boolean isOffsetPositionInLiquid(double p_70038_1_, double p_70038_3_, double p_70038_5_) {
		return master != null ? master.isOffsetPositionInLiquid(p_70038_1_, p_70038_3_, p_70038_5_) : super.isOffsetPositionInLiquid(p_70038_1_, p_70038_3_, p_70038_5_);
	}

	@Override
	public boolean superIsOffsetPositionInLiquid(double p_70038_1_, double p_70038_3_, double p_70038_5_) {
		return super.isOffsetPositionInLiquid(p_70038_1_, p_70038_3_, p_70038_5_);
	}

	@Override
	public void moveEntity(double p_70091_1_, double p_70091_3_, double p_70091_5_) {
		if (master != null) master.move(null, p_70091_1_, p_70091_3_, p_70091_5_);
		else super.moveEntity(p_70091_1_, p_70091_3_, p_70091_5_);
	}

	@Override
	public void superMove(Object moverType, double p_70091_1_, double p_70091_3_, double p_70091_5_) {
		super.moveEntity(p_70091_1_, p_70091_3_, p_70091_5_);
	}

	protected void func_145775_I() {
	}

	@Override
	public void superDoBlockCollisions() {
	}

	protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block block) {
	}

	@Override
	public void superFunc_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Object block) {
	}

	@Override
	public AxisAlignedBB getBoundingBox() {
		return (AxisAlignedBB) (master != null ? master.getCollisionBoundingBox() : super.getBoundingBox());
	}

	@Override
	public AxisAlignedBB superGetCollisionBoundingBox() {
		return super.getBoundingBox();
	}

	@Override
	protected void dealFireDamage(int p_70081_1_) {
		if (master != null) master.dealFireDamage(p_70081_1_);
		else super.dealFireDamage(p_70081_1_);
	}

	@Override
	public void superDealFireDamage(int p_70081_1_) {
		super.dealFireDamage(p_70081_1_);
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
	public boolean isInsideOfMaterial(Material material) {
		return master != null ? master.isInsideOfMaterial(material) : super.isInsideOfMaterial(material);
	}

	@Override
	public boolean superIsInsideOfMaterial(Object material) {
		return super.isInsideOfMaterial((Material) material);
	}

	@Override
	public boolean handleLavaMovement() {
		return master != null ? master.handleLavaMovement() : super.handleLavaMovement();
	}

	@Override
	public boolean superHandleLavaMovement() {
		return super.handleLavaMovement();
	}

	@Override
	public void moveFlying(float p_70060_1_, float p_70060_2_, float p_70060_3_) {
		if (master != null) master.moveRelative(p_70060_1_, p_70060_2_, p_70060_3_);
		else super.moveFlying(p_70060_1_, p_70060_2_, p_70060_3_);
	}

	@Override
	public void superMoveRelative(float p_70060_1_, float p_70060_2_, float p_70060_3_) {
		super.moveFlying(p_70060_1_, p_70060_2_, p_70060_3_);
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
	public void setPositionAndRotation(double p_70080_1_, double p_70080_3_, double p_70080_5_, float p_70080_7_, float p_70080_8_) {
		if (master != null) master.setPositionAndRotation(p_70080_1_, p_70080_3_, p_70080_5_, p_70080_7_, p_70080_8_);
		else super.setPositionAndRotation(p_70080_1_, p_70080_3_, p_70080_5_, p_70080_7_, p_70080_8_);
	}

	@Override
	public void superSetPositionAndRotation(double p_70080_1_, double p_70080_3_, double p_70080_5_, float p_70080_7_, float p_70080_8_) {
		super.setPositionAndRotation(p_70080_1_, p_70080_3_, p_70080_5_, p_70080_7_, p_70080_8_);
	}

	@Override
	public void setLocationAndAngles(double p_70012_1_, double p_70012_3_, double p_70012_5_, float p_70012_7_, float p_70012_8_) {
		if (master != null) master.setLocationAndAngles(p_70012_1_, p_70012_3_, p_70012_5_, p_70012_7_, p_70012_8_);
		else super.setLocationAndAngles(p_70012_1_, p_70012_3_, p_70012_5_, p_70012_7_, p_70012_8_);
	}

	@Override
	public void superSetLocationAndAngles(double p_70012_1_, double p_70012_3_, double p_70012_5_, float p_70012_7_, float p_70012_8_) {
		super.setLocationAndAngles(p_70012_1_, p_70012_3_, p_70012_5_, p_70012_7_, p_70012_8_);
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
	public double getDistanceSq(double p_70092_1_, double p_70092_3_, double p_70092_5_) {
		return master != null ? master.getDistanceSq(p_70092_1_, p_70092_3_, p_70092_5_) : super.getDistanceSq(p_70092_1_, p_70092_3_, p_70092_5_);
	}

	@Override
	public double superGetDistanceSq(double p_70092_1_, double p_70092_3_, double p_70092_5_) {
		return super.getDistanceSq(p_70092_1_, p_70092_3_, p_70092_5_);
	}

	@Override
	public double getDistance(double p_70011_1_, double p_70011_3_, double p_70011_5_) {
		return master != null ? master.getDistance(p_70011_1_, p_70011_3_, p_70011_5_) : super.getDistance(p_70011_1_, p_70011_3_, p_70011_5_);
	}

	@Override
	public double superGetDistance(double p_70011_1_, double p_70011_3_, double p_70011_5_) {
		return super.getDistance(p_70011_1_, p_70011_3_, p_70011_5_);
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
	public void addVelocity(double p_70024_1_, double p_70024_3_, double p_70024_5_) {
		if (master != null) master.addVelocity(p_70024_1_, p_70024_3_, p_70024_5_);
		else super.addVelocity(p_70024_1_, p_70024_3_, p_70024_5_);
	}

	@Override
	public void superAddVelocity(double p_70024_1_, double p_70024_3_, double p_70024_5_) {
		super.addVelocity(p_70024_1_, p_70024_3_, p_70024_5_);
	}

	public boolean isInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
		return false;
	}

	@Override
	public boolean superIsInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
		return false;
	}

	@Override
	public boolean isInRangeToRenderDist(double p_70112_1_) {
		return master != null ? master.isInRangeToRenderDist(p_70112_1_) : super.isInRangeToRenderDist(p_70112_1_);
	}

	@Override
	public boolean superIsInRangeToRenderDist(double p_70112_1_) {
		return super.isInRangeToRenderDist(p_70112_1_);
	}

	@Override
	public boolean writeMountToNBT(NBTTagCompound nBTTagCompound) {
		return master != null ? master.writeToNBTAtomically(nBTTagCompound) : super.writeMountToNBT(nBTTagCompound);
	}

	@Override
	public boolean superWriteToNBTAtomically(Object nBTTagCompound) {
		return super.writeMountToNBT((NBTTagCompound) nBTTagCompound);
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
	public void writeToNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.writeToNBT(nBTTagCompound);
		else super.writeToNBT(nBTTagCompound);
	}

	@Override
	public Object superWriteToNBT(Object nBTTagCompound) {
		super.writeToNBT((NBTTagCompound) nBTTagCompound);
		return nBTTagCompound;
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
	public void onChunkLoad() {
		if (master != null) master.onChunkLoad();
		else super.onChunkLoad();
	}

	@Override
	public void superOnChunkLoad() {
		super.onChunkLoad();
	}

	@Override
	protected NBTTagList newDoubleNBTList(double... p_70087_1_) {
		return (NBTTagList) (master != null ? master.newDoubleNBTList(p_70087_1_) : super.newDoubleNBTList(p_70087_1_));
	}

	@Override
	public NBTTagList superNewDoubleNBTList(double... p_70087_1_) {
		return super.newDoubleNBTList(p_70087_1_);
	}

	@Override
	protected NBTTagList newFloatNBTList(float... p_70049_1_) {
		return (NBTTagList) (master != null ? master.newFloatNBTList(p_70049_1_) : super.newFloatNBTList(p_70049_1_));
	}

	@Override
	public NBTTagList superNewFloatNBTList(float... p_70049_1_) {
		return super.newFloatNBTList(p_70049_1_);
	}

	public EntityItem dropItem(Item item, int p_145779_2_) {
		return null;
	}

	@Override
	public EntityItem superDropItem(Object item, int p_145779_2_) {
		return null;
	}

	public EntityItem func_145778_a(Item item, int p_145778_2_, float p_145778_3_) {
		return null;
	}

	@Override
	public EntityItem superDropItemWithOffset(Object item, int p_145778_2_, float p_145778_3_) {
		return null;
	}

	@Override
	public EntityItem entityDropItem(ItemStack itemStack, float p_70099_2_) {
		return (EntityItem) (master != null ? master.entityDropItem(itemStack, p_70099_2_) : super.entityDropItem(itemStack, p_70099_2_));
	}

	@Override
	public EntityItem superEntityDropItem(Object itemStack, float p_70099_2_) {
		return super.entityDropItem((ItemStack) itemStack, p_70099_2_);
	}

	@Override
	public boolean interactFirst(EntityPlayer entityPlayer) {
		return master != null ? master.processInitialInteract(entityPlayer) : super.interactFirst(entityPlayer);
	}

	@Override
	public boolean superProcessInitialInteract(Object entityPlayer) {
		return super.interactFirst((EntityPlayer) entityPlayer);
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
	public void updateRiderPosition() {
		if (master != null) master.updatePassenger();
		else super.updateRiderPosition();
	}

	@Override
	public void superUpdatePassenger() {
		super.updateRiderPosition();
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
	public void setInPortal() {
		if (master != null) master.setPortal(null);
		else super.setInPortal();
	}

	@Override
	public void superSetPortal(Object bockPos) {
		super.setInPortal();
	}

	@Override
	public void setVelocity(double p_70016_1_, double p_70016_3_, double p_70016_5_) {
		if (master != null) master.setVelocity(p_70016_1_, p_70016_3_, p_70016_5_);
		else super.setVelocity(p_70016_1_, p_70016_3_, p_70016_5_);
	}

	@Override
	public void superSetVelocity(double p_70016_1_, double p_70016_3_, double p_70016_5_) {
		super.setVelocity(p_70016_1_, p_70016_3_, p_70016_5_);
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
	public void setSneaking(boolean p_70095_1_) {
		if (master != null) master.setSneaking(p_70095_1_);
		else super.setSneaking(p_70095_1_);
	}

	@Override
	public void superSetSneaking(boolean p_70095_1_) {
		super.setSneaking(p_70095_1_);
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
	public void setInvisible(boolean p_82142_1_) {
		if (master != null) master.setInvisible(p_82142_1_);
		else super.setInvisible(p_82142_1_);
	}

	@Override
	public void superSetInvisible(boolean p_82142_1_) {
		super.setInvisible(p_82142_1_);
	}

	@Override
	public boolean isEating() {
		return master != null ? master.isEating() : super.isEating();
	}

	@Override
	public boolean superIsEating() {
		return super.isEating();
	}

	@Override
	public void setEating(boolean p_70019_1_) {
		if (master != null) master.setEating(p_70019_1_);
		else super.setEating(p_70019_1_);
	}

	@Override
	public void superSetEating(boolean p_70019_1_) {
		super.setEating(p_70019_1_);
	}

	@Override
	protected boolean getFlag(int p_70083_1_) {
		return master != null ? master.getFlag(p_70083_1_) : super.getFlag(p_70083_1_);
	}

	@Override
	public boolean superGetFlag(int p_70083_1_) {
		return super.getFlag(p_70083_1_);
	}

	@Override
	protected void setFlag(int p_70052_1_, boolean p_70052_2_) {
		if (master != null) master.setFlag(p_70052_1_, p_70052_2_);
		else super.setFlag(p_70052_1_, p_70052_2_);
	}

	@Override
	public void superSetFlag(int p_70052_1_, boolean p_70052_2_) {
		super.setFlag(p_70052_1_, p_70052_2_);
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
	public void setAir(int p_70050_1_) {
		if (master != null) master.setAir(p_70050_1_);
		else super.setAir(p_70050_1_);
	}

	@Override
	public void superSetAir(int p_70050_1_) {
		super.setAir(p_70050_1_);
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
	protected boolean pushOutOfBlocks(double p_145771_1_, double p_145771_3_, double p_145771_5_) {
		return master != null ? master.pushOutOfBlocks(p_145771_1_, p_145771_3_, p_145771_5_) : super.pushOutOfBlocks(p_145771_1_, p_145771_3_, p_145771_5_);
	}

	@Override
	public boolean superPushOutOfBlocks(double p_145771_1_, double p_145771_3_, double p_145771_5_) {
		return super.pushOutOfBlocks(p_145771_1_, p_145771_3_, p_145771_5_);
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
	public boolean canAttackWithItem() {
		return master != null ? master.canBeAttackedWithItem() : super.canAttackWithItem();
	}

	@Override
	public boolean superCanBeAttackedWithItem() {
		return super.canAttackWithItem();
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
	public boolean isEntityInvulnerable() {
		return master != null ? master.isEntityInvulnerable() : super.isEntityInvulnerable();
	}

	@Override
	public boolean superIsEntityInvulnerable() {
		return super.isEntityInvulnerable();
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
	public void copyDataFrom(Entity entity, boolean p_82141_2_) {
		if (master != null) master.copyDataFrom(entity, p_82141_2_);
		else super.copyDataFrom(entity, p_82141_2_);
	}

	@Override
	public void superCopyDataFrom(Object entity, boolean p_82141_2_) {
		super.copyDataFrom((Entity) entity, p_82141_2_);
	}

	@Override
	public void travelToDimension(int p_71027_1_) {
		if (master != null) master.changeDimension(p_71027_1_);
		else super.travelToDimension(p_71027_1_);
	}

	@Override
	public Object superChangeDimension(int p_71027_1_) {
		super.travelToDimension(p_71027_1_);
		return this;
	}

	public float func_145772_a(Explosion explosion, World world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Block block) {
		return 0.0F;
	}

	@Override
	public float superFunc_145772_a(Object explosion, Object world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Object block) {
		return 0.0F;
	}

	public boolean func_145774_a(Explosion explosion, World world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Block block, float p_145774_7_) {
		return false;
	}

	@Override
	public boolean superFunc_145774_a(Object explosion, Object world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Object block, float p_145774_7_) {
		return false;
	}

	@Override
	public int getMaxSafePointTries() {
		return master != null ? master.getMaxSafePointTries() : super.getMaxSafePointTries();
	}

	@Override
	public int superGetMaxSafePointTries() {
		return super.getMaxSafePointTries();
	}

	@Override
	public int getTeleportDirection() {
		return (Integer) (master != null ? master.getLastPortalVec() : super.getTeleportDirection());
	}

	@Override
	public Object superGetLastPortalVec() {
		return super.getTeleportDirection();
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

	public void func_145781_i(int p_145781_1_) {
	}

	@Override
	public void superOnDataWatcherUpdate(int p_145781_1_) {
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
	public ItemStack getPickedResult(MovingObjectPosition movingObjectPosition) {
		return (ItemStack) (master != null ? master.getPickedResult(movingObjectPosition) : super.getPickedResult(movingObjectPosition));
	}

	@Override
	public ItemStack superGetPickedResult(Object movingObjectPosition) {
		return super.getPickedResult((MovingObjectPosition) movingObjectPosition);
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
	public String registerExtendedProperties(String identifier, IExtendedEntityProperties iExtendedEntityProperties) {
		return master != null ? master.registerExtendedProperties(identifier, iExtendedEntityProperties) : super.registerExtendedProperties(identifier, iExtendedEntityProperties);
	}

	@Override
	public String superRegisterExtendedProperties(String identifier, Object iExtendedEntityProperties) {
		return super.registerExtendedProperties(identifier, (IExtendedEntityProperties) iExtendedEntityProperties);
	}

	@Override
	public IExtendedEntityProperties getExtendedProperties(String identifier) {
		return (IExtendedEntityProperties) (master != null ? master.getExtendedProperties(identifier) : super.getExtendedProperties(identifier));
	}

	@Override
	public IExtendedEntityProperties superGetExtendedProperties(String identifier) {
		return super.getExtendedProperties(identifier);
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
	public void superSetPositionAndRotationDirect(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
	}

	@Override
	public Object superGetPosition() {
		return super.getPosition(1.0F);
	}

	@Override
	public boolean superIsSpectator() {
		return false;
	}

	@Override
	public Object superGetPlayerInfo() {
		return null;
	}

	@Override
	public String superGetSkinType() {
		return null;
	}

	@Override
	public float superGetFovModifier() {
		return 0.0F;
	}

	@Override
	public float superGetDigSpeed(Object block) {
		return 0.0F;
	}

	@Override
	public float superGetDigSpeed(Object iBlockState, Object blockPos) {
		return 0.0F;
	}

	@Override
	public void superOpenEditSign(Object tileEntitySign) {
	}

	@Override
	public void superDisplayVillagerTradeGui(Object iMerchant) {
	}

	@Override
	public void superDisplayGui(Object iInteractionObject) {
	}

	@Override
	public boolean superIsUser() {
		return super.isPlayer();
	}

	@Override
	public Object superTrySleep(Object blockPos) {
		return null;
	}

	@Override
	public void superSetSpawnPoint(Object blockPos, boolean forced) {
	}

	@Override
	public void superFall(float distance, float damageMultiplier) {
		super.fall(distance);
	}

	@Override
	public int superGetXPSeed() {
		return -1;
	}

	@Override
	public void superRemoveExperienceLevel(int levels) {
	}

	@Override
	public boolean superIsAllowEdit() {
		return false;
	}

	@Override
	public boolean superCanPlayerEdit(Object blockPos, Object enumFacing, Object itemStack) {
		return false;
	}

	@Override
	public Object[] superGetInventory() {
		return null;
	}

	@Override
	public boolean superCanOpen(Object lockCode) {
		return false;
	}

	@Override
	public boolean superIsWearing(Object enumPlayerModelParts) {
		return false;
	}

	@Override
	public boolean superSendCommandFeedback() {
		return false;
	}

	@Override
	public boolean superReplaceItemInInventory(int p_174820_1_, Object itemStack) {
		return false;
	}

	@Override
	public boolean superHasReducedDebug() {
		return false;
	}

	@Override
	public void superSetReducedDebug(boolean reducedDebug) {
	}

	@Override
	public void superOnKillCommand() {
	}

	@Override
	public void superUpdateFallState(double p_180433_1_, boolean p_180433_3_, Object block, Object blockPos) {
	}

	@Override
	public void superUpdatePotionMetadata() {
	}

	@Override
	public void superResetPotionEffectMetadata() {
	}

	@Override
	public void superAddRandomDrop() {
	}

	@Override
	public float superGetJumpUpwardsMotion() {
		return 0.0F;
	}

	@Override
	public void superHandleJumpLava() {
	}

	@Override
	public boolean superIsServerWorld() {
		return !super.isClientWorld();
	}

	@Override
	public void superMarkPotionsDirty() {
	}

	@Override
	public void superPlayStepSound(Object blockPos, Object block) {
	}

	@Override
	public boolean superIsSilent() {
		return false;
	}

	@Override
	public void superSetSilent(boolean isSilent) {
	}

	@Override
	public void superSpawnRunningParticles() {
	}

	@Override
	public void superCreateRunningParticles() {
	}

	@Override
	public boolean superIsInLava() {
		return false;
	}

	@Override
	public void superMoveToBlockPosAndAngles(Object blockPos, float p_174828_2_, float p_174828_3_) {
	}

	@Override
	public double superGetDistanceSq(Object blockPos) {
		return 0.0D;
	}

	@Override
	public double superGetDistanceSqToCenter(Object blockPos) {
		return 0.0D;
	}

	@Override
	public Object superGetPositionEyes(float p_174824_1_) {
		return null;
	}

	@Override
	public boolean superIsEntityInvulnerable(Object damageSource) {
		return super.isEntityInvulnerable();
	}

	@Override
	public void superCopyDataFromOld(Object entity) {
	}

	@Override
	public float superGetExplosionResistance(Object explosion, Object world, Object blockPos, Object iBlockState) {
		return 0.0F;
	}

	@Override
	public boolean superVerifyExplosion(Object explosion, Object world, Object blockPos, Object iBlockState, float p_174816_5_) {
		return false;
	}

	@Override
	public int superGetMaxFallHeight() {
		return -1;
	}

	@Override
	public void superSetCustomNameTag(String p_96094_1_) {
	}

	@Override
	public String superGetCustomNameTag() {
		return null;
	}

	@Override
	public boolean superHasCustomName() {
		return false;
	}

	@Override
	public void superSetAlwaysRenderNameTag(boolean p_174805_1_) {
	}

	@Override
	public boolean superGetAlwaysRenderNameTag() {
		return false;
	}

	@Override
	public Object superGetHorizontalFacing() {
		return null;
	}

	@Override
	public Object superGetHoverEvent() {
		return null;
	}

	@Override
	public boolean superIsSpectatedByPlayer(Object entityPlayerMP) {
		return false;
	}

	@Override
	public Object superGetEntityBoundingBox() {
		return super.getBoundingBox();
	}

	@Override
	public void superSetEntityBoundingBox(Object axisAlignedBB) {
	}

	@Override
	public boolean superIsOutsideBorder() {
		return false;
	}

	@Override
	public void superSetOutsideBorder(boolean p_174821_1_) {
	}

	@Override
	public Object superGetPositionVector() {
		return null;
	}

	@Override
	public Object superGetCommandSenderEntity() {
		return null;
	}

	@Override
	public void superSetCommandStat(Object type, int amount) {
	}

	@Override
	public Object superGetCommandStats() {
		return null;
	}

	@Override
	public Object superGetNBTTagCompound() {
		return null;
	}

	@Override
	public void superClientUpdateEntityNBT(Object nBTTagCompound) {
	}

	@Override
	public boolean superInteractAt(Object entityPlayer, Object vec3) {
		return false;
	}

	@Override
	public boolean superIsImmuneToExplosions() {
		return false;
	}

	@Override
	public void superApplyEnchantments(Object entityLivingBase, Object entity) {
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
	public int superGetHealthInt() {
		return (int) super.getHealth();
	}

	@Override
	public float superGetSpeedModifier() {
		return 0;
	}

	@Override
	public void superInitCreature() {
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
	public void superFunc_96120_a(int par1, float par2) {
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
		dismountEntity((Entity) entity);
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

	@Override
	public void superHeal(int par1) {
		super.heal(par1);
	}

	@Override
	public Object superGetHealth() {
		return super.getHealth();
	}

	@Override
	public void superDamageEntity(Object damageSource, int par2) {
		super.damageEntity((DamageSource) damageSource, par2);
	}

	@Override
	public void superSetPortal() {
		super.setInPortal();
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
	// 190~
	@Override
	public Object superGetLastAttackingEntity() {
		return null;
	}

	@Override
	public void superSetLastAttackingEntity(Object entity) {
	}

	@Override
	public Object superApplyArmorCalculations(Object damageSource, int par2) {
		return -1;
	}

	@Override
	public Object superApplyPotionDamageCalculations(Object damageSource, int par2) {
		return -1;
	}

	@Override
	public void superKnockBack(Object entity, int par2, double par3, double par5) {
	}

	@Override
	public void superOnChangedPotionEffect(Object potionEffect) {
	}

	@Override
	public void superDropLoot() {
	}

	@Override
	public void superSetNoAI(boolean par1) {
	}

	@Override
	public boolean superIsNoDespawnRequired() {
		return false;
	}

	@Override
	public void superPlayStepSound(int par1, int par2, int par3, Object par4) {
	}

	@Override
	public void superFunc_180433_a(double p_180433_1_, boolean p_180433_3_, Object block, Object blockPos) {
	}

	@Override
	public Object superGetFallSound(int damageValue) {
		return null;
	}

	@Override
	public void superFunc_145781_i(int p_145781_1_) {
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
	public void superSwingArm(Object enumHand) {
	}

	@Override
	public Object superGetItemStackFromSlot(Object entityEquipmentSlot) {
		return null;
	}

	@Override
	public void superFrostWalk(Object blockPos) {
	}

	@Override
	public void superPlayEquipSound(Object itemStack) {
	}

	@Override
	public Object superRemoveActivePotionEffect(Object potion) {
		return null;
	}

	@Override
	public void superRemovePotionEffect(Object potion) {
	}

	@Override
	public void superPlayHurtSound(Object damageSource) {
	}

	@Override
	public void superDamageShield(float p_184590_1_) {
	}

	@Override
	public Object superGetHeldItemOffhand() {
		return null;
	}

	@Override
	public Object superGetHeldItem(Object enumHand) {
		return null;
	}

	@Override
	public void superSetHeldItem(Object enumHand, Object itemStack) {
	}

	@Override
	public boolean superIsHandActive() {
		return false;
	}

	@Override
	public Object superGetActiveHand() {
		return null;
	}

	@Override
	public void superUpdateActiveHand() {
	}

	@Override
	public void superSetActiveHand(Object enumHand) {
	}

	@Override
	public Object superGetActiveItemStack() {
		return null;
	}

	@Override
	public int superGetItemInUseMaxCount() {
		return -1;
	}

	@Override
	public void superStopActiveHand() {
	}

	@Override
	public void superResetActiveHand() {
	}

	@Override
	public boolean superIsActiveItemStackBlocking() {
		return false;
	}

	@Override
	public boolean superIsElytraFlying() {
		return false;
	}

	@Override
	public int superGetTicksElytraFlying() {
		return -1;
	}

	public boolean superTeleportTo_(double x, double y, double z) {
		return false;
	}

	@Override
	public boolean superCanBeHitWithPotion() {
		return false;
	}

	@Override
	public void superDropLoot(boolean p_184610_1_, int p_184610_2_, Object damageSource) {
	}

	@Override
	public Object getFreeVariable(String s) {
		return null;
	}

	@Override
	public void setFreeVariable(String s, Object o) {
	}

	@Override
	public Object superGetFreeVariable(String s) {
		return null;
	}

	@Override
	public void superSetFreeVariable(String s, Object o) {
	}

	@Override
	public boolean superIsNotColliding() {
		return false;
	}

	@Override
	public boolean superAttackEntityFrom(Object damageSource, Object p_70097_2_) {
		return false;
	}

	@Override
	public void superSetItemStackToSlot(int p_70062_1_, Object itemStack) {
	}

	@Override
	public boolean superIsInRangeToRender3d(Object vec3) {
		return false;
	}

	@Override
	public boolean superShouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, Object par6, float par7) {
		return false;
	}

	@Override
	public boolean superAttackEntityFrom(Object damageSource, int par2) {
		return false;
	}

	@Override
	public void superSetCommandStats(Object entity) {
	}

	@Override
	public boolean superProcessInitialInteract(Object entityPlayer, Object itemStack, Object enumHand) {
		return false;
	}

	@Override
	public Object superGetTags() {
		return null;
	}

	@Override
	public boolean superAddTag(String tag) {
		return false;
	}

	@Override
	public boolean superRemoveTag(String tag) {
		return false;
	}

	@Override
	public void superSetDropItemsWhenDead(boolean p_184174_1_) {
	}

	@Override
	public void superDecrementTimeUntilPortal() {
	}

	@Override
	public void superResetPositionToBB() {
	}

	@Override
	public void superUpdatePassenger(Object entity) {
	}

	@Override
	public void superApplyOrientationToEntity(Object entity) {
	}

	@Override
	public boolean superStartRiding(Object entity, boolean force) {
		return false;
	}

	@Override
	public boolean superCanBeRidden(Object entity) {
		return false;
	}

	@Override
	public void superRemovePassengers() {
	}

	@Override
	public void superDismountRidingEntity() {
	}

	@Override
	public void superAddPassenger(Object entity) {
	}

	@Override
	public void superRemovePassenger(Object entity) {
	}

	@Override
	public boolean superCanFitPassenger(Object entity) {
		return false;
	}

	@Override
	public Object superGetHeldEquipment() {
		return null;
	}

	@Override
	public Object superGetArmorInventoryList() {
		return null;
	}

	@Override
	public Object superGetEquipmentAndArmor() {
		return null;
	}

	@Override
	public void superSetItemStackToSlot(Object entityEquipmentSlot, Object itemStack) {
	}

	@Override
	public boolean superIsBeingRidden() {
		return false;
	}

	@Override
	public boolean superIsGlowing() {
		return false;
	}

	@Override
	public void superSetGlowing(boolean p_184195_1_) {
	}

	@Override
	public boolean superIsOnScoreboardTeam(Object team) {
		return false;
	}

	@Override
	public void superSetRenderYawOffset(float offset) {
	}

	@Override
	public void superSetEntityInvulnerable(boolean isInvulnerable) {
	}

	@Override
	public boolean superIsNonBoss() {
		return false;
	}

	@Override
	public void superSetUniqueId(UUID uniqueIdIn) {
	}

	@Override
	public void superNotifyDataManagerChange(Object dataParameter) {
	}

	@Override
	public Object superGetAdjustedHorizontalFacing() {
		return null;
	}

	@Override
	public Object superGetRenderBoundingBox() {
		return null;
	}

	@Override
	public Object superGetServer() {
		return null;
	}

	@Override
	public Object superApplyPlayerInteraction(Object entityPlayer, Object vec3d, Object itemStack, Object enumHand) {
		return null;
	}

	@Override
	public boolean superHasCapability(Object capability, Object enumFacing) {
		return false;
	}

	@Override
	public Object superGetCapability(Object capability, Object enumFacing) {
		return null;
	}

	@Override
	public void superDeserializeNBT(Object nBTTagCompound) {
	}

	@Override
	public Object superSerializeNBT() {
		return null;
	}

	public void superSetBossVisibleTo(Object entityPlayerMP) {
	}

	public void superSetBossNonVisibleTo(Object entityPlayerMP) {
	}

	@Override
	public float superGetRotatedYaw(Object rotation) {
		return 0.0F;
	}

	@Override
	public float superGetMirroredYaw(Object mirror) {
		return 0.0F;
	}

	public boolean superFunc_184213_bq() {
		return false;
	}

	@Override
	public boolean superSetPositionNonDirty() {
		return false;
	}

	@Override
	public Object superGetControllingPassenger() {
		return null;
	}

	@Override
	public Object superGetPassengers() {
		return null;
	}

	@Override
	public boolean superIsPassenger(Object entity) {
		return false;
	}

	@Override
	public Object superGetRecursivePassengers() {
		return null;
	}

	@Override
	public Object superGetLowestRidingEntity() {
		return null;
	}

	@Override
	public boolean superIsRidingSameEntity(Object entity) {
		return false;
	}

	@Override
	public boolean superIsRidingOrBeingRiddenBy(Object entity) {
		return false;
	}

	@Override
	public boolean superCanPassengerSteer() {
		return false;
	}

	@Override
	public Object superGetRidingEntity() {
		return null;
	}

	@Override
	public Object superGetPushReaction() {
		return null;
	}

	@Override
	public Object superGetSoundCategory() {
		return null;
	}

	@Override
	public Object superGetRecursivePassengersByType(Class entityClass) {
		return null;
	}

	@Override
	public void superDisplayGuiEditCommandCart(Object commandBlockLogic) {
	}

	@Override
	public void superTakeStat(Object statBase) {
	}

	@Override
	public boolean superInteractFirst(Object entityPlayer) {
		return false;
	}

	@Override
	public void superOpenBook(Object itemStack, Object enumHand) {
	}

	@Override
	public Object superInteractOn(Object entity, Object itemStack, Object enumHand) {
		return null;
	}

	@Override
	public boolean superIsCreative() {
		return false;
	}

	@Override
	public boolean superIsPlayerInfoSet() {
		return false;
	}

	@Override
	public Object superGetLocationElytra() {
		return null;
	}

	@Override
	public Object superCreateCooldownTracker() {
		return null;
	}

	@Override
	public void superUpdateSize() {
	}

	@Override
	public void superDisplayGuiCommandBlock(Object tileEntityCommandBlock) {
	}

	@Override
	public void superSpawnSweepParticles() {
	}

	@Override
	public boolean superHasAchievement(Object achievement) {
		return false;
	}

	@Override
	public Object superGetPrimaryHand() {
		return null;
	}

	@Override
	public void superSetPrimaryHand(Object enumHandSide) {
	}

	@Override
	public float superGetCooldownPeriod() {
		return 0.0F;
	}

	@Override
	public float superGetCooledAttackStrength(float adjustTicks) {
		return 0.0F;
	}

	@Override
	public void superResetCooldown() {
	}

	@Override
	public Object superGetCooldownTracker() {
		return null;
	}

	@Override
	public float superGetLuck() {
		return 0.0F;
	}

	@Override
	public void superAddPrefix(Object iTextComponent) {
	}

	@Override
	public void superAddSuffix(Object iTextComponent) {
	}

	@Override
	public Collection superGetPrefixes() {
		return null;
	}

	@Override
	public Collection superGetSuffixes() {
		return null;
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
	public Object superGetLivingSound() {
		return null;
	}

	@Override
	public boolean superCanPickUpLoot() {
		return false;
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
	public Object superGetLookHelper() {
		return null;
	}

	@Override
	public void superPlayLivingSound() {
	}

	@Override
	public void superSpawnExplosionParticle() {
	}

	@Override
	public int superGetDropItemId() {
		return -1;
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
		return -1;
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
		return 0.0F;
	}

	@Override
	public int superGetMaxSpawnedInChunk() {
		return -1;
	}

	@Override
	public int superGetTalkInterval() {
		return -1;
	}

	@Override
	public boolean superCanBeSteered() {
		return false;
	}

	@Override
	public void superSetCanPickUpLoot(boolean par1) {
	}

	@Override
	public boolean superProcessInteract(Object entityPlayer) {
		return false;
	}

	@Override
	public Object superGetTeleportDirection() {
		return super.getTeleportDirection();
	}

	@Override
	public boolean superAttemptTeleport(double x, double y, double z) {
		return false;
	}

	@Override
	public void superAddTrackingPlayer(Object entityPlayerMP) {
	}

	@Override
	public void superRemoveTrackingPlayer(Object entityPlayerMP) {
	}

	@Override
	public boolean superIgnoreItemEntityData() {
		return false;
	}

}
