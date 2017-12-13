package modchu.lib.forge.mc164;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_CastHelper;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_EntityHelper;
import modchu.lib.Modchu_IEntityPlayer;
import modchu.lib.Modchu_IEntityPlayerMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeInstance;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecartHopper;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
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
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.CombatTracker;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.FoodStats;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import paulscode.sound.Vector3D;

public class Modchu_EntityPlayer extends EntityPlayer implements Modchu_IEntityPlayer {
	public Modchu_IEntityPlayerMaster master;

	public Modchu_EntityPlayer(HashMap<String, Object> map) {
		super((World)map.get("Object"), (String)map.get("String"));
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.lDebug("Modchu_EntityPlayer init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IEntityPlayerMaster ? (Modchu_IEntityPlayerMaster) instance : null;
		if (master != null); else Modchu_Debug.lDebug("Modchu_EntityPlayerSP init master == null !!");
	}

	@Override
	public void supersetMaxHealth(Object floatOrInt) {
		//maxHealth = Modchu_CastHelper.Float(floatOrInt, 0.0F, false);
	}

	@Override
	public void entityDataManagerRegister(Class[] c1, int i, Object o) {
		Modchu_EntityHelper.getInstance().entityDataManagerRegister(this, c1, i, o);
	}

	@Override
	public int getEntityDataManagerEntriesCount() {
		return Modchu_EntityHelper.getInstance().getEntityDataManagerEntriesCount(this);
	}

	@Override
	public Object getDataWatcherWatchableObject(int i) {
		return Modchu_EntityHelper.getInstance().getDataWatcherWatchableObject(this, i);
	}

	@Override
	public void setDataWatcherWatchableObject(int i, Object o) {
		Modchu_EntityHelper.getInstance().setDataWatcherWatchableObject(this, i, o);
	}

	@Override
	public boolean isInitFlag() {
		return master != null;
	}

	@Override
	public int getDataWatcherWatchableObjectIdFirst() {
		return 19;
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
	public Object getRidingEntity2() {
		return supergetRidingEntity();
	}

	@Override
	public boolean isRiding2() {
		return isRiding();
	}

	@Override
	public void dismountRidingEntity2() {
		superdismountRidingEntity();
	}

	@Override
	public boolean superstartRiding(Object entity, boolean force) {
		return superstartRiding(entity);
	}

	@Override
	public Object supergetRidingEntity() {
		return ridingEntity;
	}

	@Override
	public void superdismountRidingEntity() {
		super.mountEntity(null);
	}

	@Override
	public int getTempIsRiding() {
		return master != null ? master.getTempIsRiding() : 0;
	}

	@Override
	public void setTempIsRiding(int i) {
		if (master != null) master.setTempIsRiding(i);
	}

	@Override
	public void dataParameterMapSetting(HashMap<Integer, Object> map) {
	}

	@Override
	public void sendChatToPlayer(ChatMessageComponent chatMessageComponent) {
		if (master != null) master.sendChatToPlayer(chatMessageComponent);
	}

	@Override
	public void supersendChatToPlayer(Object chatMessageComponent) {
	}

	@Override
	public boolean canCommandSenderUseCommand(int i, String s) {
		return master != null ? master.canCommandSenderUseCommand(i, s) : false;
	}

	@Override
	public boolean supercanUseCommand(int i, String s) {
		return false;
	}

	@Override
	public ChunkCoordinates getPlayerCoordinates() {
		return (ChunkCoordinates) (master != null ? master.getPlayerCoordinates() : null);
	}

	@Override
	public ChunkCoordinates supergetPlayerCoordinates() {
		return null;
	}

	@Override
	protected void applyEntityAttributes() {
		if (master != null) master.applyEntityAttributes();
		else superapplyEntityAttributes();
	}

	@Override
	public void superapplyEntityAttributes() {
		Map attributesByName = Modchu_AS.getMap("BaseAttributeMap", "attributesByName", getAttributeMap());
		if (!attributesByName.containsKey(SharedMonsterAttributes.maxHealth.getAttributeUnlocalizedName())
				&& !attributesByName.containsKey(SharedMonsterAttributes.knockbackResistance.getAttributeUnlocalizedName())
				&& !attributesByName.containsKey(SharedMonsterAttributes.movementSpeed.getAttributeUnlocalizedName())) super.applyEntityAttributes();
	}

	@Override
	protected void entityInit() {
		Modchu_EntityHelper.getInstance().entityInit(this);
	}

	@Override
	public void superentityInit() {
		super.entityInit();
	}

	@Override
	public ItemStack getItemInUse() {
		return (ItemStack) (master != null ? master.getItemInUse() : super.getItemInUse());
	}

	@Override
	public ItemStack supergetItemInUse() {
		return super.getItemInUse();
	}

	@Override
	public int getItemInUseCount() {
		return master != null ? master.getItemInUseCount() : super.getItemInUseCount();
	}

	@Override
	public int supergetItemInUseCount() {
		return super.getItemInUseCount();
	}

	@Override
	public boolean isUsingItem() {
		return master != null ? master.isHandActive() : super.isUsingItem();
	}

	@Override
	public boolean superisHandActive() {
		return super.isUsingItem();
	}

	@Override
	public int getItemInUseDuration() {
		return master != null ? master.getItemInUseDuration() : super.getItemInUseDuration();
	}

	@Override
	public int supergetItemInUseDuration() {
		return super.getItemInUseDuration();
	}

	@Override
	public void stopUsingItem() {
		if (master != null) master.stopUsingItem();
		else super.stopUsingItem();
	}

	@Override
	public void superstopUsingItem() {
		super.stopUsingItem();
	}

	@Override
	public void clearItemInUse() {
		if (master != null) master.clearItemInUse();
		else super.clearItemInUse();
	}

	@Override
	public void superclearItemInUse() {
		super.clearItemInUse();
	}

	@Override
	public boolean isBlocking() {
		return master != null ? master.isBlocking() : super.isBlocking();
	}

	@Override
	public boolean superisBlocking() {
		return super.isBlocking();
	}

	@Override
	public void onUpdate() {
		if (master != null) master.onUpdate();
	}

	@Override
	public void superonUpdate() {
		super.onUpdate();
	}

	@Override
	public int getMaxInPortalTime() {
		return master != null ? master.getMaxInPortalTime() : super.getMaxInPortalTime();
	}

	@Override
	public int supergetMaxInPortalTime() {
		return super.getMaxInPortalTime();
	}

	@Override
	public int getPortalCooldown() {
		return master != null ? master.getPortalCooldown() : super.getPortalCooldown();
	}

	@Override
	public int supergetPortalCooldown() {
		return super.getPortalCooldown();
	}

	@Override
	public void playSound(String par1Str, float par2, float par3) {
		if (master != null) master.playSound(par1Str, par2, par3);
		else super.playSound(par1Str, par2, par3);
	}

	@Override
	public void superplaySound(String par1Str, float par2, float par3) {
		super.playSound(par1Str, par2, par3);
	}

	@Override
	protected void updateItemUse(ItemStack itemStack, int par2) {
		if (master != null) master.updateItemUse(itemStack, par2);
		else super.updateItemUse(itemStack, par2);
	}

	@Override
	public void superupdateItemUse(Object itemStack, int par2) {
		super.updateItemUse((ItemStack) itemStack, par2);
	}

	@Override
	protected void onItemUseFinish() {
		if (master != null) master.onItemUseFinish();
		else super.onItemUseFinish();
	}

	@Override
	public void superonItemUseFinish() {
		super.onItemUseFinish();
	}

	@Override
	public void handleHealthUpdate(byte par1) {
		if (master != null) master.handleStatusUpdate(par1);
		else super.handleHealthUpdate(par1);
	}

	@Override
	public void superhandleStatusUpdate(byte par1) {
		super.handleHealthUpdate(par1);
	}

	@Override
	protected boolean isMovementBlocked() {
		return master != null ? master.isMovementBlocked() : super.isMovementBlocked();
	}

	@Override
	public boolean superisMovementBlocked() {
		return super.isMovementBlocked();
	}

	@Override
	public void closeScreen() {
		if (master != null) master.closeScreen();
		else super.closeScreen();
	}

	@Override
	public void supercloseScreen() {
		super.closeScreen();
	}

	@Override
	public void mountEntity(Entity entity) {
		if (master != null) master.startRiding(entity);
		else super.mountEntity(entity);
	}

	@Override
	public boolean superstartRiding(Object entity) {
		super.mountEntity((Entity) entity);
		return true;
	}

	@Override
	public void updateRidden() {
		if (master != null) master.updateRidden();
		else super.updateRidden();
	}

	@Override
	public void superupdateRidden() {
		super.updateRidden();
	}

	@Override
	public void preparePlayerToSpawn() {
		if (master != null) master.preparePlayerToSpawn();
		else super.preparePlayerToSpawn();
	}

	@Override
	public void superpreparePlayerToSpawn() {
		super.preparePlayerToSpawn();
	}

	@Override
	protected void updateEntityActionState() {
		if (master != null) master.updateEntityActionState();
		else super.updateEntityActionState();
	}

	@Override
	public void superupdateEntityActionState() {
		super.updateEntityActionState();
	}

	@Override
	public void onLivingUpdate() {
		if (master != null) master.onLivingUpdate();
		else super.onLivingUpdate();
	}

	@Override
	public void superonLivingUpdate() {
		super.onLivingUpdate();
	}

	@Override
	public int getScore() {
		return master != null ? master.getScore() : super.getScore();
	}

	@Override
	public int supergetScore() {
		return super.getScore();
	}

	@Override
	public void setScore(int par1) {
		if (master != null) master.setScore(par1);
		else super.setScore(par1);
	}

	@Override
	public void supersetScore(int par1) {
		super.setScore(par1);
	}

	@Override
	public void addScore(int par1) {
		if (master != null) master.addScore(par1);
		else super.addScore(par1);
	}

	@Override
	public void superaddScore(int par1) {
		super.addScore(par1);
	}

	@Override
	public void onDeath(DamageSource damageSource) {
		if (master != null) master.onDeath(damageSource);
		else super.onDeath(damageSource);
	}

	@Override
	public void superonDeath(Object damageSource) {
		super.onDeath((DamageSource) damageSource);
	}

	@Override
	public void addToPlayerScore(Entity entity, int par2) {
		if (master != null) master.awardKillScore(entity, par2);
		else super.addToPlayerScore(entity, par2);
	}

	@Override
	public void superawardKillScore(Object entity, int par2) {
		super.addToPlayerScore((Entity) entity, par2);
	}

	@Override
	public EntityItem dropOneItem(boolean par1) {
		return (EntityItem) (master != null ? master.dropItem(par1) : super.dropOneItem(par1));
	}

	@Override
	public EntityItem superdropItem(boolean par1) {
		return super.dropOneItem(par1);
	}

	@Override
	public EntityItem dropPlayerItem(ItemStack itemStack) {
		return (EntityItem) (master != null ? master.dropPlayerItem(itemStack) : super.dropPlayerItem(itemStack));
	}

	@Override
	public EntityItem superdropPlayerItem(Object itemStack) {
		return super.dropPlayerItem((ItemStack) itemStack);
	}

	@Override
	public EntityItem dropPlayerItemWithRandomChoice(ItemStack itemStack, boolean par2) {
		return (EntityItem) (master != null ? master.dropItem(itemStack, par2) : super.dropPlayerItemWithRandomChoice(itemStack, par2));
	}

	@Override
	public EntityItem superdropItem(Object itemStack, boolean par2) {
		return super.dropPlayerItemWithRandomChoice((ItemStack) itemStack, par2);
	}

	@Override
	public void joinEntityItemWithWorld(EntityItem entityItem) {
		if (master != null) master.dropItemAndGetStack(entityItem);
		else super.joinEntityItemWithWorld(entityItem);
	}

	@Override
	public void superdropItemAndGetStack(Object entityItem) {
		super.joinEntityItemWithWorld((EntityItem) entityItem);
	}

	@Override
	public float getCurrentPlayerStrVsBlock(Block block, boolean par2) {
		return master != null ? master.getCurrentPlayerStrVsBlock(block, par2) : super.getCurrentPlayerStrVsBlock(block, par2);
	}

	@Override
	public float supergetCurrentPlayerStrVsBlock(Object block, boolean par2) {
		return super.getCurrentPlayerStrVsBlock((Block) block, par2);
	}

	@Override
	public float getCurrentPlayerStrVsBlock(Block block, boolean par2, int meta) {
		return master != null ? master.getCurrentPlayerStrVsBlock(block, par2, meta) : super.getCurrentPlayerStrVsBlock(block, par2, meta);
	}

	@Override
	public float supergetCurrentPlayerStrVsBlock(Object block, boolean par2, int meta) {
		return super.getCurrentPlayerStrVsBlock((Block) block, par2, meta);
	}

	@Override
	public boolean canHarvestBlock(Block block) {
		return master != null ? master.canHarvestBlock(block) : super.canHarvestBlock(block);
	}

	@Override
	public boolean supercanHarvestBlock(Object block) {
		return super.canHarvestBlock((Block) block);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.readEntityFromNBT(nBTTagCompound);
		else super.readEntityFromNBT(nBTTagCompound);
	}

	@Override
	public void superreadEntityFromNBT(Object nBTTagCompound) {
		super.readEntityFromNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.writeEntityToNBT(nBTTagCompound);
		else super.writeEntityToNBT(nBTTagCompound);
	}

	@Override
	public void superwriteEntityToNBT(Object nBTTagCompound) {
		super.writeEntityToNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public void displayGUIChest(IInventory iInventory) {
		if (master != null) master.displayGUIChest(iInventory);
		else super.displayGUIChest(iInventory);
	}

	@Override
	public void superdisplayGUIChest(Object iInventory) {
		super.displayGUIChest((IInventory) iInventory);
	}

	@Override
	public void displayGUIHopper(TileEntityHopper tileEntityHopper) {
		if (master != null) master.displayGUIHopper(tileEntityHopper);
		else super.displayGUIHopper(tileEntityHopper);
	}

	@Override
	public void superdisplayGUIHopper(Object tileEntityHopper) {
		super.displayGUIHopper((TileEntityHopper) tileEntityHopper);
	}

	@Override
	public void displayGUIHopperMinecart(EntityMinecartHopper entityMinecartHopper) {
		if (master != null) master.displayGUIHopperMinecart(entityMinecartHopper);
		else super.displayGUIHopperMinecart(entityMinecartHopper);
	}

	@Override
	public void superdisplayGUIHopperMinecart(Object entityMinecartHopper) {
		super.displayGUIHopperMinecart((EntityMinecartHopper) entityMinecartHopper);
	}

	@Override
	public void displayGUIHorse(EntityHorse entityHorse, IInventory iInventory) {
		if (master != null) master.openGuiHorseInventory(entityHorse, iInventory);
		else super.displayGUIHorse(entityHorse, iInventory);
	}

	@Override
	public void superopenGuiHorseInventory(Object entityHorse, Object iInventory) {
		super.displayGUIHorse((EntityHorse) entityHorse, (IInventory) iInventory);
	}

	@Override
	public void displayGUIEnchantment(int par1, int par2, int par3, String par4Str) {
		if (master != null) master.displayGUIEnchantment(par1, par2, par3, par4Str);
		else super.displayGUIEnchantment(par1, par2, par3, par4Str);
	}

	@Override
	public void superdisplayGUIEnchantment(int par1, int par2, int par3, String par4Str) {
		super.displayGUIEnchantment(par1, par2, par3, par4Str);
	}

	@Override
	public void displayGUIAnvil(int par1, int par2, int par3) {
		if (master != null) master.displayGUIAnvil(par1, par2, par3);
		else super.displayGUIAnvil(par1, par2, par3);
	}

	@Override
	public void superdisplayGUIAnvil(int par1, int par2, int par3) {
		super.displayGUIAnvil(par1, par2, par3);
	}

	@Override
	public void displayGUIWorkbench(int par1, int par2, int par3) {
		if (master != null) master.displayGUIWorkbench(par1, par2, par3);
		else super.displayGUIWorkbench(par1, par2, par3);
	}

	@Override
	public void superdisplayGUIWorkbench(int par1, int par2, int par3) {
		super.displayGUIWorkbench(par1, par2, par3);
	}

	@Override
	public float getEyeHeight() {
		return master != null ? master.getEyeHeight() : super.getEyeHeight();
	}

	@Override
	public float supergetEyeHeight() {
		return super.getEyeHeight();
	}

	@Override
	protected void resetHeight() {
		if (master != null) master.resetHeight();
		else super.resetHeight();
	}

	@Override
	public void superresetHeight() {
		super.resetHeight();
	}

	@Override
	public boolean attackEntityFrom(DamageSource damageSource, float par2) {
		return master != null ? master.attackEntityFrom(damageSource, par2) : super.attackEntityFrom(damageSource, par2);
	}

	@Override
	public boolean superattackEntityFrom(Object damageSource, float par2) {
		return super.attackEntityFrom((DamageSource) damageSource, par2);
	}

	@Override
	public boolean canAttackPlayer(EntityPlayer entityPlayer) {
		return master != null ? master.canAttackPlayer(entityPlayer) : super.canAttackPlayer(entityPlayer);
	}

	@Override
	public boolean supercanAttackPlayer(Object entityPlayer) {
		return super.canAttackPlayer((EntityPlayer) entityPlayer);
	}

	@Override
	public void damageArmor(float par1) {
		if (master != null) master.damageArmor(par1);
		else super.damageArmor(par1);
	}

	@Override
	public void superdamageArmor(float par1) {
		super.damageArmor(par1);
	}

	@Override
	public int getTotalArmorValue() {
		return master != null ? master.getTotalArmorValue() : super.getTotalArmorValue();
	}

	@Override
	public int supergetTotalArmorValue() {
		return super.getTotalArmorValue();
	}

	@Override
	public float getArmorVisibility() {
		return master != null ? master.getArmorVisibility() : super.getArmorVisibility();
	}

	@Override
	public float supergetArmorVisibility() {
		return super.getArmorVisibility();
	}

	@Override
	public void damageEntity(DamageSource damageSource, float par2) {
		if (master != null) master.damageEntity(damageSource, par2);
		else super.damageEntity(damageSource, par2);
	}

	@Override
	public void superdamageEntity(Object damageSource, float par2) {
		super.damageEntity((DamageSource) damageSource, par2);
	}

	@Override
	public void displayGUIFurnace(TileEntityFurnace tileEntityFurnace) {
		if (master != null) master.displayGUIFurnace(tileEntityFurnace);
		else super.displayGUIFurnace(tileEntityFurnace);
	}

	@Override
	public void superdisplayGUIFurnace(Object tileEntityFurnace) {
		super.displayGUIFurnace((TileEntityFurnace) tileEntityFurnace);
	}

	@Override
	public void displayGUIDispenser(TileEntityDispenser tileEntityDispenser) {
		if (master != null) master.displayGUIDispenser(tileEntityDispenser);
		else super.displayGUIDispenser(tileEntityDispenser);
	}

	@Override
	public void superdisplayGUIDispenser(Object tileEntityDispenser) {
		super.displayGUIDispenser((TileEntityDispenser) tileEntityDispenser);
	}

	@Override
	public void displayGUIEditSign(TileEntity tileEntity) {
		if (master != null) master.displayGUIEditSign(tileEntity);
		else super.displayGUIEditSign(tileEntity);
	}

	@Override
	public void superdisplayGUIEditSign(Object tileEntity) {
		super.displayGUIEditSign((TileEntity) tileEntity);
	}

	@Override
	public void displayGUIBrewingStand(TileEntityBrewingStand tileEntityBrewingStand) {
		if (master != null) master.displayGUIBrewingStand(tileEntityBrewingStand);
		else super.displayGUIBrewingStand(tileEntityBrewingStand);
	}

	@Override
	public void superdisplayGUIBrewingStand(Object tileEntityBrewingStand) {
		super.displayGUIBrewingStand((TileEntityBrewingStand) tileEntityBrewingStand);
	}

	@Override
	public void displayGUIBeacon(TileEntityBeacon tileEntityBeacon) {
		if (master != null) master.displayGUIBeacon(tileEntityBeacon);
		else super.displayGUIBeacon(tileEntityBeacon);
	}

	@Override
	public void superdisplayGUIBeacon(Object tileEntityBeacon) {
		super.displayGUIBeacon((TileEntityBeacon) tileEntityBeacon);
	}

	@Override
	public void displayGUIMerchant(IMerchant iMerchant, String par2Str) {
		if (master != null) master.displayGUIMerchant(iMerchant, par2Str);
		else super.displayGUIMerchant(iMerchant, par2Str);
	}

	@Override
	public void superdisplayGUIMerchant(Object iMerchant, String par2Str) {
		super.displayGUIMerchant((IMerchant) iMerchant, par2Str);
	}

	@Override
	public void displayGUIBook(ItemStack itemStack) {
		if (master != null) master.openBook(itemStack);
		else super.displayGUIBook(itemStack);
	}

	@Override
	public void superopenBook(Object itemStack) {
		super.displayGUIBook((ItemStack) itemStack);
	}

	@Override
	public boolean interactWith(Entity entity) {
		return master != null ? master.interactWith(entity) : super.interactWith(entity);
	}

	@Override
	public boolean superinteractWith(Object entity) {
		return super.interactWith((Entity) entity);
	}

	@Override
	public ItemStack getCurrentEquippedItem() {
		return (ItemStack) (master != null ? master.getHeldItemMainhand() : super.getCurrentEquippedItem());
	}

	@Override
	public ItemStack supergetHeldItemMainhand() {
		return super.getCurrentEquippedItem();
	}

	@Override
	public void destroyCurrentEquippedItem() {
		if (master != null) master.destroyCurrentEquippedItem();
		else super.destroyCurrentEquippedItem();
	}

	@Override
	public void superdestroyCurrentEquippedItem() {
		super.destroyCurrentEquippedItem();
	}

	@Override
	public double getYOffset() {
		return master != null ? master.getYOffset() : super.getYOffset();
	}

	@Override
	public double supergetYOffset() {
		return super.getYOffset();
	}

	@Override
	public void attackTargetEntityWithCurrentItem(Entity entity) {
		if (master != null) master.attackTargetEntityWithCurrentItem(entity);
		else super.attackTargetEntityWithCurrentItem(entity);
	}

	@Override
	public void superattackTargetEntityWithCurrentItem(Object entity) {
		super.attackTargetEntityWithCurrentItem((Entity) entity);
	}

	@Override
	public void onCriticalHit(Entity entity) {
		if (master != null) master.onCriticalHit(entity);
		else super.onCriticalHit(entity);
	}

	@Override
	public void superonCriticalHit(Object entity) {
		super.onCriticalHit((Entity) entity);
	}

	@Override
	public void onEnchantmentCritical(Entity entity) {
		if (master != null) master.onEnchantmentCritical(entity);
		else super.onEnchantmentCritical(entity);
	}

	@Override
	public void superonEnchantmentCritical(Object entity) {
		super.onEnchantmentCritical((Entity) entity);
	}

	@Override
	public void respawnPlayer() {
		if (master != null) master.respawnPlayer();
		else super.respawnPlayer();
	}

	@Override
	public void superrespawnPlayer() {
		super.respawnPlayer();
	}

	@Override
	public void setDead() {
		if (master != null) master.setDead();
		else super.setDead();
	}

	@Override
	public void supersetDead() {
		super.setDead();
	}

	@Override
	public boolean isEntityInsideOpaqueBlock() {
		return master != null ? master.isEntityInsideOpaqueBlock() : super.isEntityInsideOpaqueBlock();
	}

	@Override
	public boolean superisEntityInsideOpaqueBlock() {
		return super.isEntityInsideOpaqueBlock();
	}

	@Override
	public EnumStatus sleepInBedAt(int par1, int par2, int par3) {
		return (EnumStatus) (master != null ? master.sleepInBedAt(par1, par2, par3) : super.sleepInBedAt(par1, par2, par3));
	}

	@Override
	public EnumStatus supersleepInBedAt(int par1, int par2, int par3) {
		return super.sleepInBedAt(par1, par2, par3);
	}

	@Override
	public void wakeUpPlayer(boolean par1, boolean par2, boolean par3) {
		if (master != null) master.wakeUpPlayer(par1, par2, par3);
		else super.wakeUpPlayer(par1, par2, par3);
	}

	@Override
	public void superwakeUpPlayer(boolean par1, boolean par2, boolean par3) {
		super.wakeUpPlayer(par1, par2, par3);
	}

	@Override
	public float getBedOrientationInDegrees() {
		return master != null ? master.getBedOrientationInDegrees() : super.getBedOrientationInDegrees();
	}

	@Override
	public float supergetBedOrientationInDegrees() {
		return super.getBedOrientationInDegrees();
	}

	@Override
	public boolean isPlayerSleeping() {
		return master != null ? master.isPlayerSleeping() : super.isPlayerSleeping();
	}

	@Override
	public boolean superisPlayerSleeping() {
		return super.isPlayerSleeping();
	}

	@Override
	public boolean isPlayerFullyAsleep() {
		return master != null ? master.isPlayerFullyAsleep() : super.isPlayerFullyAsleep();
	}

	@Override
	public boolean superisPlayerFullyAsleep() {
		return super.isPlayerFullyAsleep();
	}

	@Override
	public int getSleepTimer() {
		return master != null ? master.getSleepTimer() : super.getSleepTimer();
	}

	@Override
	public int supergetSleepTimer() {
		return super.getSleepTimer();
	}

	@Override
	protected boolean getHideCape(int par1) {
		return master != null ? master.getHideCape(par1) : super.getHideCape(par1);
	}

	@Override
	public boolean supergetHideCape(int par1) {
		return super.getHideCape(par1);
	}

	@Override
	protected void setHideCape(int par1, boolean par2) {
		if (master != null) master.setHideCape(par1, par2);
		else super.setHideCape(par1, par2);
	}

	@Override
	public void supersetHideCape(int par1, boolean par2) {
		super.setHideCape(par1, par2);
	}

	@Override
	public void addChatMessage(String par1Str) {
		if (master != null) master.sendMessage(par1Str);
		else super.addChatMessage(par1Str);
	}

	@Override
	public void supersendMessage(Object par1Str) {
		super.addChatMessage((String) par1Str);
	}

	@Override
	public ChunkCoordinates getBedLocation() {
		return (ChunkCoordinates) (master != null ? master.getBedLocation() : super.getBedLocation());
	}

	@Override
	public ChunkCoordinates supergetBedLocation() {
		return super.getBedLocation();
	}

	@Override
	public boolean isSpawnForced() {
		return master != null ? master.isSpawnForced() : super.isSpawnForced();
	}

	@Override
	public boolean superisSpawnForced() {
		return super.isSpawnForced();
	}

	@Override
	public ChunkCoordinates getBedLocation(int dimension) {
		return (ChunkCoordinates) (master != null ? master.getBedLocation(dimension) : super.getBedLocation(dimension));
	}

	@Override
	public ChunkCoordinates supergetBedLocation(int dimension) {
		return super.getBedLocation(dimension);
	}

	@Override
	public boolean isSpawnForced(int dimension) {
		return master != null ? master.isSpawnForced(dimension) : super.isSpawnForced(dimension);
	}

	@Override
	public boolean superisSpawnForced(int dimension) {
		return super.isSpawnForced(dimension);
	}

	@Override
	public void setSpawnChunk(ChunkCoordinates chunkCoordinates, boolean par2) {
		if (master != null) master.setSpawnChunk(chunkCoordinates, par2);
		else super.setSpawnChunk(chunkCoordinates, par2);
	}

	@Override
	public void supersetSpawnChunk(Object chunkCoordinates, boolean par2) {
		super.setSpawnChunk((ChunkCoordinates) chunkCoordinates, par2);
	}

	@Override
	public void setSpawnChunk(ChunkCoordinates chunkCoordinates, boolean forced, int dimension) {
		if (master != null) master.setSpawnChunk(chunkCoordinates, forced, dimension);
		else super.setSpawnChunk(chunkCoordinates, forced, dimension);
	}

	@Override
	public void supersetSpawnChunk(Object chunkCoordinates, boolean forced, int dimension) {
		super.setSpawnChunk((ChunkCoordinates) chunkCoordinates, forced, dimension);
	}

	@Override
	public void triggerAchievement(StatBase statBase) {
		if (master != null) master.addStat(statBase);
		else super.triggerAchievement(statBase);
	}

	@Override
	public void superaddStat(Object statBase) {
		super.triggerAchievement((StatBase) statBase);
	}

	@Override
	public void addStat(StatBase statBase, int par2) {
		if (master != null) master.addStat(statBase, par2);
		else super.addStat(statBase, par2);
	}

	@Override
	public void superaddStat(Object statBase, int par2) {
		super.addStat((StatBase) statBase, par2);
	}

	@Override
	protected void jump() {
		if (master != null) master.jump();
		else super.jump();
	}

	@Override
	public void superjump() {
		super.jump();
	}

	@Override
	public void moveEntityWithHeading(float par1, float par2) {
		if (master != null) master.moveEntityWithHeading(par1, par2);
		else super.moveEntityWithHeading(par1, par2);
	}

	@Override
	public void supermoveEntityWithHeading(float par1, float par2) {
		super.moveEntityWithHeading(par1, par2);
	}

	@Override
	public float getAIMoveSpeed() {
		return master != null ? master.getAIMoveSpeed() : super.getAIMoveSpeed();
	}

	@Override
	public float supergetAIMoveSpeed() {
		return super.getAIMoveSpeed();
	}

	@Override
	public void addMovementStat(double par1, double par3, double par5) {
		if (master != null) master.addMovementStat(par1, par3, par5);
		else super.addMovementStat(par1, par3, par5);
	}

	@Override
	public void superaddMovementStat(double par1, double par3, double par5) {
		super.addMovementStat(par1, par3, par5);
	}

	@Override
	protected void fall(float par1) {
		if (master != null) master.fall(par1);
		else super.fall(par1);
	}

	@Override
	public void superfall(float par1) {
		super.fall(par1);
	}

	@Override
	public void onKillEntity(EntityLivingBase entityLivingBase) {
		if (master != null) master.onKillEntity(entityLivingBase);
		else super.onKillEntity(entityLivingBase);
	}

	@Override
	public void superonKillEntity(Object entityLivingBase) {
		super.onKillEntity((EntityLivingBase) entityLivingBase);
	}

	@Override
	public void setInWeb() {
		if (master != null) master.setInWeb();
		else super.setInWeb();
	}

	@Override
	public void supersetInWeb() {
		super.setInWeb();
	}

	@Override
	public Icon getItemIcon(ItemStack itemStack, int par2) {
		return (Icon) (master != null ? master.getItemIcon(itemStack, par2) : super.getItemIcon(itemStack, par2));
	}

	@Override
	public Icon supergetItemIcon(Object itemStack, int par2) {
		return super.getItemIcon((ItemStack) itemStack, par2);
	}

	@Override
	public ItemStack getCurrentArmor(int par1) {
		return (ItemStack) (master != null ? master.getCurrentArmor(par1) : super.getCurrentArmor(par1));
	}

	@Override
	public ItemStack supergetCurrentArmor(int par1) {
		return super.getCurrentArmor(par1);
	}

	@Override
	public void addExperience(int par1) {
		if (master != null) master.addExperience(par1);
		else super.addExperience(par1);
	}

	@Override
	public void superaddExperience(int par1) {
		super.addExperience(par1);
	}

	@Override
	public void addExperienceLevel(int par1) {
		if (master != null) master.addExperienceLevel(par1);
		else super.addExperienceLevel(par1);
	}

	@Override
	public void superaddExperienceLevel(int par1) {
		super.addExperienceLevel(par1);
	}

	@Override
	public int xpBarCap() {
		return master != null ? master.xpBarCap() : super.xpBarCap();
	}

	@Override
	public int superxpBarCap() {
		return super.xpBarCap();
	}

	@Override
	public void addExhaustion(float par1) {
		if (master != null) master.addExhaustion(par1);
		else super.addExhaustion(par1);
	}

	@Override
	public void superaddExhaustion(float par1) {
		super.addExhaustion(par1);
	}

	@Override
	public FoodStats getFoodStats() {
		return (FoodStats) (master != null ? master.getFoodStats() : super.getFoodStats());
	}

	@Override
	public FoodStats supergetFoodStats() {
		return super.getFoodStats();
	}

	@Override
	public boolean canEat(boolean par1) {
		return master != null ? master.canEat(par1) : super.canEat(par1);
	}

	@Override
	public boolean supercanEat(boolean par1) {
		return super.canEat(par1);
	}

	@Override
	public boolean shouldHeal() {
		return master != null ? master.shouldHeal() : super.shouldHeal();
	}

	@Override
	public boolean supershouldHeal() {
		return super.shouldHeal();
	}

	@Override
	public void setItemInUse(ItemStack itemStack, int par2) {
		if (master != null) master.setItemInUse(itemStack, par2);
		else super.setItemInUse(itemStack, par2);
	}

	@Override
	public void supersetItemInUse(Object itemStack, int par2) {
		super.setItemInUse((ItemStack) itemStack, par2);
	}

	@Override
	public boolean isCurrentToolAdventureModeExempt(int par1, int par2, int par3) {
		return master != null ? master.isCurrentToolAdventureModeExempt(par1, par2, par3) : super.isCurrentToolAdventureModeExempt(par1, par2, par3);
	}

	@Override
	public boolean superisCurrentToolAdventureModeExempt(int par1, int par2, int par3) {
		return super.isCurrentToolAdventureModeExempt(par1, par2, par3);
	}

	@Override
	public boolean canPlayerEdit(int par1, int par2, int par3, int par4, ItemStack itemStack) {
		return master != null ? master.canPlayerEdit(par1, par2, par3, par4, itemStack) : super.canPlayerEdit(par1, par2, par3, par4, itemStack);
	}

	@Override
	public boolean supercanPlayerEdit(int par1, int par2, int par3, int par4, Object itemStack) {
		return super.canPlayerEdit(par1, par2, par3, par4, (ItemStack) itemStack);
	}

	@Override
	protected int getExperiencePoints(EntityPlayer entityPlayer) {
		return master != null ? master.getExperiencePoints(entityPlayer) : super.getExperiencePoints(entityPlayer);
	}

	@Override
	public int supergetExperiencePoints(Object entityPlayer) {
		return super.getExperiencePoints((EntityPlayer) entityPlayer);
	}

	@Override
	protected boolean isPlayer() {
		return master != null ? master.isPlayer() : super.isPlayer();
	}

	@Override
	public boolean superisPlayer() {
		return super.isPlayer();
	}

	@Override
	public String getEntityName() {
		return master != null ? master.getEntityName() : super.getEntityName();
	}

	@Override
	public String supergetEntityName() {
		return super.getEntityName();
	}

	@Override
	public boolean getAlwaysRenderNameTagForRender() {
		return master != null ? master.getAlwaysRenderNameTagForRender() : super.getAlwaysRenderNameTagForRender();
	}

	@Override
	public boolean supergetAlwaysRenderNameTagForRender() {
		return super.getAlwaysRenderNameTagForRender();
	}

	@Override
	public void clonePlayer(EntityPlayer entityPlayer, boolean par2) {
		if (master != null) master.clonePlayer(entityPlayer, par2);
		else super.clonePlayer(entityPlayer, par2);
	}

	@Override
	public void superclonePlayer(Object entityPlayer, boolean par2) {
		super.clonePlayer((EntityPlayer) entityPlayer, par2);
	}

	@Override
	protected boolean canTriggerWalking() {
		return master != null ? master.canTriggerWalking() : super.canTriggerWalking();
	}

	@Override
	public boolean supercanTriggerWalking() {
		return super.canTriggerWalking();
	}

	@Override
	public void sendPlayerAbilities() {
		if (master != null) master.sendPlayerAbilities();
		else super.sendPlayerAbilities();
	}

	@Override
	public void supersendPlayerAbilities() {
		super.sendPlayerAbilities();
	}

	@Override
	public void setGameType(EnumGameType enumGameType) {
		if (master != null) master.setGameType(enumGameType);
		else super.setGameType(enumGameType);
	}

	@Override
	public void supersetGameType(Object enumGameType) {
		super.setGameType((EnumGameType) enumGameType);
	}

	@Override
	public String getCommandSenderName() {
		return master != null ? master.getCommandSenderName() : super.getCommandSenderName();
	}

	public String supergetCommandSenderName() {
		return super.getCommandSenderName();
	}

	@Override
	public World getEntityWorld() {
		return (World) (master != null ? master.getEntityWorld() : super.getEntityWorld());
	}

	@Override
	public World supergetEntityWorld() {
		return super.getEntityWorld();
	}

	@Override
	public InventoryEnderChest getInventoryEnderChest() {
		return (InventoryEnderChest) (master != null ? master.getInventoryEnderChest() : super.getInventoryEnderChest());
	}

	@Override
	public InventoryEnderChest supergetInventoryEnderChest() {
		return super.getInventoryEnderChest();
	}

	@Override
	public ItemStack getCurrentItemOrArmor(int par1) {
		return (ItemStack) (master != null ? master.getCurrentItemOrArmor(par1) : super.getCurrentItemOrArmor(par1));
	}

	@Override
	public ItemStack supergetCurrentItemOrArmor(int par1) {
		return super.getCurrentItemOrArmor(par1);
	}

	@Override
	public ItemStack getHeldItem() {
		return (ItemStack) (master != null ? master.getHeldItem() : super.getHeldItem());
	}

	@Override
	public ItemStack supergetHeldItem() {
		return super.getHeldItem();
	}

	@Override
	public void setCurrentItemOrArmor(int par1, ItemStack itemStack) {
		if (master != null) master.setCurrentItemOrArmor(par1, itemStack);
		else super.setCurrentItemOrArmor(par1, itemStack);
	}

	@Override
	public void supersetCurrentItemOrArmor(int par1, Object itemStack) {
		super.setCurrentItemOrArmor(par1, (ItemStack) itemStack);
	}

	@Override
	public boolean isInvisibleToPlayer(EntityPlayer entityPlayer) {
		return master != null ? master.isInvisibleToPlayer(entityPlayer) : super.isInvisibleToPlayer(entityPlayer);
	}

	@Override
	public boolean superisInvisibleToPlayer(Object entityPlayer) {
		return super.isInvisibleToPlayer((EntityPlayer) entityPlayer);
	}

	@Override
	public ItemStack[] getLastActiveItems() {
		return (ItemStack[]) (master != null ? master.getLastActiveItems() : super.getLastActiveItems());
	}

	@Override
	public ItemStack[] supergetLastActiveItems() {
		return super.getLastActiveItems();
	}

	@Override
	public boolean getHideCape() {
		return master != null ? master.getHideCape() : super.getHideCape();
	}

	@Override
	public boolean supergetHideCape() {
		return super.getHideCape();
	}

	@Override
	public boolean isPushedByWater() {
		return master != null ? master.isPushedByWater() : super.isPushedByWater();
	}

	@Override
	public boolean superisPushedByWater() {
		return super.isPushedByWater();
	}

	@Override
	public Scoreboard getWorldScoreboard() {
		return (Scoreboard) (master != null ? master.getWorldScoreboard() : super.getWorldScoreboard());
	}

	@Override
	public Scoreboard supergetWorldScoreboard() {
		return super.getWorldScoreboard();
	}

	@Override
	public Team getTeam() {
		return (Team) (master != null ? master.getTeam() : super.getTeam());
	}

	@Override
	public Team supergetTeam() {
		return super.getTeam();
	}

	@Override
	public String getTranslatedEntityName() {
		return master != null ? master.getTranslatedEntityName() : super.getTranslatedEntityName();
	}

	@Override
	public String supergetTranslatedEntityName() {
		return super.getTranslatedEntityName();
	}

	@Override
	public void setAbsorptionAmount(float par1) {
		if (master != null) master.setAbsorptionAmount(par1);
		else super.setAbsorptionAmount(par1);
	}

	@Override
	public void supersetAbsorptionAmount(float par1) {
		super.setAbsorptionAmount(par1);
	}

	@Override
	public float getAbsorptionAmount() {
		return master != null ? master.getAbsorptionAmount() : super.getAbsorptionAmount();
	}

	@Override
	public float supergetAbsorptionAmount() {
		return super.getAbsorptionAmount();
	}

	@Override
	public void openGui(Object mod, int modGuiId, World world, int x, int y, int z) {
		if (master != null) master.openGui(mod, modGuiId, world, x, y, z);
		else super.openGui(mod, modGuiId, world, x, y, z);
	}

	@Override
	public void superopenGui(Object mod, int modGuiId, Object world, int x, int y, int z) {
		super.openGui(mod, modGuiId, (World) world, x, y, z);
	}

	@Override
	public float getDefaultEyeHeight() {
		return master != null ? master.getDefaultEyeHeight() : super.getDefaultEyeHeight();
	}

	@Override
	public float supergetDefaultEyeHeight() {
		return super.getDefaultEyeHeight();
	}

	@Override
	public String getDisplayName() {
		return master != null ? master.getDisplayName() : super.getDisplayName();
	}

	@Override
	public String supergetDisplayName() {
		return super.getDisplayName();
	}

	@Override
	public void refreshDisplayName() {
		if (master != null) master.refreshDisplayName();
		else super.refreshDisplayName();
	}

	@Override
	public void superrefreshDisplayName() {
		super.refreshDisplayName();
	}

	@Override
	protected void updateFallState(double par1, boolean par3) {
		if (master != null) master.updateFallState(par1, par3);
		else super.updateFallState(par1, par3);
	}

	@Override
	public void superupdateFallState(double par1, boolean par3) {
		super.updateFallState(par1, par3);
	}

	@Override
	public boolean canBreatheUnderwater() {
		return master != null ? master.canBreatheUnderwater() : super.canBreatheUnderwater();
	}

	@Override
	public boolean supercanBreatheUnderwater() {
		return super.canBreatheUnderwater();
	}

	@Override
	public void onEntityUpdate() {
		if (master != null) master.onEntityUpdate();
		else super.onEntityUpdate();
	}

	@Override
	public void superonEntityUpdate() {
		super.onEntityUpdate();
	}

	@Override
	public boolean isChild() {
		return master != null ? master.isChild() : super.isChild();
	}

	@Override
	public boolean superisChild() {
		return super.isChild();
	}

	@Override
	protected void onDeathUpdate() {
		if (master != null) master.onDeathUpdate();
		else super.onDeathUpdate();
	}

	@Override
	public void superonDeathUpdate() {
		super.onDeathUpdate();
	}

	@Override
	protected int decreaseAirSupply(int par1) {
		return master != null ? master.decreaseAirSupply(par1) : super.decreaseAirSupply(par1);
	}

	@Override
	public int superdecreaseAirSupply(int par1) {
		return super.decreaseAirSupply(par1);
	}

	@Override
	public Random getRNG() {
		return master != null ? master.getRNG() : super.getRNG();
	}

	@Override
	public Random supergetRNG() {
		return super.getRNG();
	}

	@Override
	public EntityLivingBase getAITarget() {
		return (EntityLivingBase) (master != null ? master.getRevengeTarget() : super.getAITarget());
	}

	@Override
	public EntityLivingBase supergetRevengeTarget() {
		return super.getAITarget();
	}

	@Override
	public int func_142015_aE() {
		return master != null ? master.func_142015_aE() : super.func_142015_aE();
	}

	@Override
	public int superfunc_142015_aE() {
		return super.func_142015_aE();
	}

	@Override
	public void setRevengeTarget(EntityLivingBase entityLivingBase) {
		if (master != null) master.setRevengeTarget(entityLivingBase);
		else super.setRevengeTarget(entityLivingBase);
	}

	@Override
	public void supersetRevengeTarget(Object entityLivingBase) {
		super.setRevengeTarget((EntityLivingBase) entityLivingBase);
	}

	@Override
	public EntityLivingBase getLastAttacker() {
		return (EntityLivingBase) (master != null ? master.getLastAttackedEntity() : super.getLastAttacker());
	}

	@Override
	public EntityLivingBase supergetLastAttackedEntity() {
		return super.getLastAttacker();
	}

	@Override
	public int getLastAttackerTime() {
		return master != null ? master.getLastAttackedEntityTime() : super.getLastAttackerTime();
	}

	@Override
	public int supergetLastAttackedEntityTime() {
		return super.getLastAttackerTime();
	}

	@Override
	public void setLastAttacker(Entity entity) {
		if (master != null) master.setLastAttackedEntity(entity);
		else super.setLastAttacker(entity);
	}

	@Override
	public void supersetLastAttackedEntity(Object entity) {
		super.setLastAttacker((Entity) entity);
	}

	@Override
	public int getAge() {
		return master != null ? master.getIdleTime() : super.getAge();
	}

	@Override
	public int supergetIdleTime() {
		return super.getAge();
	}

	@Override
	protected void updatePotionEffects() {
		if (master != null) master.updatePotionEffects();
		else super.updatePotionEffects();
	}

	@Override
	public void superupdatePotionEffects() {
		super.updatePotionEffects();
	}

	@Override
	public void clearActivePotions() {
		if (master != null) master.clearActivePotions();
		else super.clearActivePotions();
	}

	@Override
	public void superclearActivePotions() {
		super.clearActivePotions();
	}

	@Override
	public Collection getActivePotionEffects() {
		return (Collection) (master != null ? master.getActivePotionEffects() : super.getActivePotionEffects());
	}

	@Override
	public Collection supergetActivePotionEffects() {
		return super.getActivePotionEffects();
	}

	@Override
	public boolean isPotionActive(int par1) {
		return master != null ? master.isPotionActive(par1) : super.isPotionActive(par1);
	}

	@Override
	public boolean superisPotionActive(int par1) {
		return super.isPotionActive(par1);
	}

	@Override
	public boolean isPotionActive(Potion potion) {
		return master != null ? master.isPotionActive(potion) : super.isPotionActive(potion);
	}

	@Override
	public boolean superisPotionActive(Object potion) {
		return super.isPotionActive((Potion) potion);
	}

	@Override
	public PotionEffect getActivePotionEffect(Potion potion) {
		return (PotionEffect) (master != null ? master.getActivePotionEffect(potion) : super.getActivePotionEffect(potion));
	}

	@Override
	public PotionEffect supergetActivePotionEffect(Object potion) {
		return super.getActivePotionEffect((Potion) potion);
	}

	@Override
	public void addPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.addPotionEffect(potionEffect);
		else super.addPotionEffect(potionEffect);
	}

	@Override
	public void superaddPotionEffect(Object potionEffect) {
		super.addPotionEffect((PotionEffect) potionEffect);
	}

	@Override
	public boolean isPotionApplicable(PotionEffect potionEffect) {
		return master != null ? master.isPotionApplicable(potionEffect) : super.isPotionApplicable(potionEffect);
	}

	@Override
	public boolean superisPotionApplicable(Object potionEffect) {
		return super.isPotionApplicable((PotionEffect) potionEffect);
	}

	@Override
	public boolean isEntityUndead() {
		return master != null ? master.isEntityUndead() : super.isEntityUndead();
	}

	@Override
	public boolean superisEntityUndead() {
		return super.isEntityUndead();
	}

	@Override
	public void removePotionEffectClient(int par1) {
		if (master != null) master.removePotionEffectClient(par1);
		else super.removePotionEffectClient(par1);
	}

	@Override
	public void superremovePotionEffectClient(int par1) {
		super.removePotionEffectClient(par1);
	}

	@Override
	public void removePotionEffect(int par1) {
		if (master != null) master.removePotionEffect(par1);
		else super.removePotionEffect(par1);
	}

	@Override
	public void superremovePotionEffect(int par1) {
		super.removePotionEffect(par1);
	}

	@Override
	protected void onNewPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.onNewPotionEffect(potionEffect);
		else super.onNewPotionEffect(potionEffect);
	}

	@Override
	public void superonNewPotionEffect(Object potionEffect) {
		super.onNewPotionEffect((PotionEffect) potionEffect);
	}

	@Override
	protected void onChangedPotionEffect(PotionEffect potionEffect, boolean par2) {
		if (master != null) master.onChangedPotionEffect(potionEffect, par2);
		else super.onChangedPotionEffect(potionEffect, par2);
	}

	@Override
	public void superonChangedPotionEffect(Object potionEffect, boolean par2) {
		super.onChangedPotionEffect((PotionEffect) potionEffect, par2);
	}

	@Override
	protected void onFinishedPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.onFinishedPotionEffect(potionEffect);
		else super.onFinishedPotionEffect(potionEffect);
	}

	@Override
	public void superonFinishedPotionEffect(Object potionEffect) {
		super.onFinishedPotionEffect((PotionEffect) potionEffect);
	}

	@Override
	public void heal(float par1) {
		if (master != null) master.heal(par1);
		else super.heal(par1);
	}

	@Override
	public void superheal(float par1) {
		super.heal(par1);
	}

	@Override
	public void setHealth(float par1) {
		if (master != null) master.setHealth(par1);
		else super.setHealth(par1);
	}

	@Override
	public void supersetHealth(float par1) {
		super.setHealth(par1);
	}

	@Override
	public void renderBrokenItemStack(ItemStack itemStack) {
		if (master != null) master.renderBrokenItemStack(itemStack);
		else super.renderBrokenItemStack(itemStack);
	}

	@Override
	public void superrenderBrokenItemStack(Object itemStack) {
		super.renderBrokenItemStack((ItemStack) itemStack);
	}

	@Override
	protected void dropEquipment(boolean par1, int par2) {
		if (master != null) master.dropEquipment(par1, par2);
		else super.dropEquipment(par1, par2);
	}

	@Override
	public void superdropEquipment(boolean par1, int par2) {
		super.dropEquipment(par1, par2);
	}

	@Override
	public void knockBack(Entity entity, float par2, double par3, double par5) {
		if (master != null) master.knockBack(entity, par2, par3, par5);
		else super.knockBack(entity, par2, par3, par5);
	}

	@Override
	public void superknockBack(Object entity, float par2, double par3, double par5) {
		super.knockBack((Entity) entity, par2, par3, par5);
	}

	@Override
	protected String getHurtSound() {
		return master != null ? master.getHurtSound() : super.getHurtSound();
	}

	@Override
	public String supergetHurtSound() {
		return super.getHurtSound();
	}

	@Override
	protected String getDeathSound() {
		return master != null ? master.getDeathSound() : super.getDeathSound();
	}

	@Override
	public String supergetDeathSound() {
		return super.getDeathSound();
	}

	@Override
	protected void dropRareDrop(int par1) {
		if (master != null) master.dropRareDrop(par1);
		else super.dropRareDrop(par1);
	}

	@Override
	public void superdropRareDrop(int par1) {
		super.dropRareDrop(par1);
	}

	@Override
	protected void dropFewItems(boolean par1, int par2) {
		if (master != null) master.dropFewItems(par1, par2);
		else super.dropFewItems(par1, par2);
	}

	@Override
	public void superdropFewItems(boolean par1, int par2) {
		super.dropFewItems(par1, par2);
	}

	@Override
	public boolean isOnLadder() {
		return master != null ? master.isOnLadder() : super.isOnLadder();
	}

	@Override
	public boolean superisOnLadder() {
		return super.isOnLadder();
	}

	@Override
	public boolean isEntityAlive() {
		return master != null ? master.isEntityAlive() : super.isEntityAlive();
	}

	@Override
	public boolean superisEntityAlive() {
		return super.isEntityAlive();
	}

	@Override
	public void performHurtAnimation() {
		if (master != null) master.performHurtAnimation();
		else super.performHurtAnimation();
	}

	@Override
	public void superperformHurtAnimation() {
		super.performHurtAnimation();
	}

	@Override
	protected float applyArmorCalculations(DamageSource damageSource, float par2) {
		return (Float) (master != null ? master.applyArmorCalculations(damageSource, par2) : super.applyArmorCalculations(damageSource, par2));
	}

	@Override
	public Object superapplyArmorCalculations(Object damageSource, float par2) {
		return super.applyArmorCalculations((DamageSource) damageSource, par2);
	}

	@Override
	protected float applyPotionDamageCalculations(DamageSource damageSource, float par2) {
		return (Float) (master != null ? master.applyPotionDamageCalculations(damageSource, par2) : super.applyPotionDamageCalculations(damageSource, par2));
	}

	@Override
	public Object superapplyPotionDamageCalculations(Object damageSource, float par2) {
		return super.applyPotionDamageCalculations((DamageSource) damageSource, par2);
	}

	@Override
	public CombatTracker func_110142_aN() {
		return (CombatTracker) (master != null ? master.func_110142_aN() : super.func_110142_aN());
	}

	@Override
	public CombatTracker superfunc_110142_aN() {
		return super.func_110142_aN();
	}

	@Override
	public EntityLivingBase func_94060_bK() {
		return (EntityLivingBase) (master != null ? master.getAttackingEntity() : super.func_94060_bK());
	}

	@Override
	public EntityLivingBase supergetAttackingEntity() {
		return super.func_94060_bK();
	}

	@Override
	public void swingItem() {
		if (master != null) master.swingArm();
		else super.swingItem();
	}

	@Override
	public void superswingArm() {
		super.swingItem();
	}

	@Override
	protected void kill() {
		if (master != null) master.outOfWorld();
		else super.kill();
	}

	@Override
	public void superoutOfWorld() {
		super.kill();
	}

	@Override
	protected void updateArmSwingProgress() {
		if (master != null) master.updateArmSwingProgress();
		else super.updateArmSwingProgress();
	}

	@Override
	public void superupdateArmSwingProgress() {
		super.updateArmSwingProgress();
	}

	@Override
	public AttributeInstance getEntityAttribute(Attribute attribute) {
		return (AttributeInstance) (master != null ? master.getEntityAttribute(attribute) : super.getEntityAttribute(attribute));
	}

	@Override
	public AttributeInstance supergetEntityAttribute(Object attribute) {
		return super.getEntityAttribute((Attribute) attribute);
	}

	@Override
	public BaseAttributeMap getAttributeMap() {
		return (BaseAttributeMap) (master != null ? master.getAttributeMap() : super.getAttributeMap());
	}

	@Override
	public BaseAttributeMap supergetAttributeMap() {
		return super.getAttributeMap();
	}

	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return (EnumCreatureAttribute) (master != null ? master.getCreatureAttribute() : super.getCreatureAttribute());
	}

	@Override
	public EnumCreatureAttribute supergetCreatureAttribute() {
		return super.getCreatureAttribute();
	}

	@Override
	public void setSprinting(boolean par1) {
		if (master != null) master.setSprinting(par1);
		else super.setSprinting(par1);
	}

	@Override
	public void supersetSprinting(boolean par1) {
		super.setSprinting(par1);
	}

	@Override
	protected float getSoundVolume() {
		return master != null ? master.getSoundVolume() : super.getSoundVolume();
	}

	@Override
	public float supergetSoundVolume() {
		return super.getSoundVolume();
	}

	@Override
	protected float getSoundPitch() {
		return master != null ? master.getSoundPitch() : super.getSoundPitch();
	}

	@Override
	public float supergetSoundPitch() {
		return super.getSoundPitch();
	}

	@Override
	public void setPositionAndUpdate(double par1, double par3, double par5) {
		if (master != null) master.setPositionAndUpdate(par1, par3, par5);
		else super.setPositionAndUpdate(par1, par3, par5);
	}

	@Override
	public void supersetPositionAndUpdate(double par1, double par3, double par5) {
		super.setPositionAndUpdate(par1, par3, par5);
	}

	@Override
	public void dismountEntity(Entity entity) {
		if (master != null) master.dismountEntity(entity);
		else super.dismountEntity(entity);
	}

	@Override
	public void superdismountEntity(Object entity) {
		super.dismountEntity((Entity) entity);
	}

	@Override
	protected boolean isAIEnabled() {
		return master != null ? master.isAIEnabled() : super.isAIEnabled();
	}

	@Override
	public boolean superisAIEnabled() {
		return super.isAIEnabled();
	}

	@Override
	public void setAIMoveSpeed(float par1) {
		if (master != null) master.setAIMoveSpeed(par1);
		else super.setAIMoveSpeed(par1);
	}

	@Override
	public void supersetAIMoveSpeed(float par1) {
		super.setAIMoveSpeed(par1);
	}

	@Override
	public boolean attackEntityAsMob(Entity entity) {
		return master != null ? master.attackEntityAsMob(entity) : super.attackEntityAsMob(entity);
	}

	@Override
	public boolean superattackEntityAsMob(Object entity) {
		return super.attackEntityAsMob((Entity) entity);
	}

	@Override
	protected float func_110146_f(float par1, float par2) {
		return master != null ? master.updateDistance(par1, par2) : super.func_110146_f(par1, par2);
	}

	@Override
	public float superupdateDistance(float par1, float par2) {
		return super.func_110146_f(par1, par2);
	}

	@Override
	protected void updateAITasks() {
		if (master != null) master.updateAITasks();
		else super.updateAITasks();
	}

	@Override
	public void superupdateAITasks() {
		super.updateAITasks();
	}

	@Override
	protected void collideWithNearbyEntities() {
		if (master != null) master.collideWithNearbyEntities();
		else super.collideWithNearbyEntities();
	}

	@Override
	public void supercollideWithNearbyEntities() {
		super.collideWithNearbyEntities();
	}

	@Override
	protected void collideWithEntity(Entity entity) {
		if (master != null) master.collideWithEntity(entity);
		else super.collideWithEntity(entity);
	}

	@Override
	public void supercollideWithEntity(Object entity) {
		super.collideWithEntity((Entity) entity);
	}

	@Override
	public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
		if (master != null) master.setPositionAndRotationDirect(par1, par3, par5, par7, par8, par9);
		else super.setPositionAndRotation2(par1, par3, par5, par7, par8, par9);
	}

	@Override
	public void supersetPositionAndRotationDirect(double par1, double par3, double par5, float par7, float par8, int par9) {
		super.setPositionAndRotation2(par1, par3, par5, par7, par8, par9);
	}

	@Override
	protected void updateAITick() {
		if (master != null) master.handleJumpWater();
		else super.updateAITick();
	}

	@Override
	public void superhandleJumpWater() {
		super.updateAITick();
	}

	@Override
	public void setJumping(boolean par1) {
		if (master != null) master.setJumping(par1);
		else super.setJumping(par1);
	}

	@Override
	public void supersetJumping(boolean par1) {
		super.setJumping(par1);
	}

	@Override
	public void onItemPickup(Entity entity, int par2) {
		if (master != null) master.onItemPickup(entity, par2);
		else super.onItemPickup(entity, par2);
	}

	@Override
	public void superonItemPickup(Object entity, int par2) {
		super.onItemPickup((Entity) entity, par2);
	}

	@Override
	public boolean canEntityBeSeen(Entity entity) {
		return master != null ? master.canEntityBeSeen(entity) : super.canEntityBeSeen(entity);
	}

	@Override
	public boolean supercanEntityBeSeen(Object entity) {
		return super.canEntityBeSeen((Entity) entity);
	}

	@Override
	public Vec3 getLookVec() {
		return (Vec3) (master != null ? master.getLookVec() : super.getLookVec());
	}

	@Override
	public Vec3 supergetLookVec() {
		return super.getLookVec();
	}

	@Override
	public Vec3 getLook(float par1) {
		return (Vec3) (master != null ? master.getLook(par1) : super.getLook(par1));
	}

	@Override
	public Vec3 supergetLook(float par1) {
		return super.getLook(par1);
	}

	@Override
	public float getSwingProgress(float par1) {
		return master != null ? master.getSwingProgress(par1) : super.getSwingProgress(par1);
	}

	@Override
	public float supergetSwingProgress(float par1) {
		return super.getSwingProgress(par1);
	}

	@Override
	public Vec3 getPosition(float par1) {
		return (Vec3) (master != null ? master.getPosition(par1) : super.getPosition(par1));
	}

	@Override
	public Vec3 supergetPosition(float par1) {
		return super.getPosition(par1);
	}

	@Override
	public MovingObjectPosition rayTrace(double par1, float par3) {
		return (MovingObjectPosition) (master != null ? master.rayTrace(par1, par3) : super.rayTrace(par1, par3));
	}

	@Override
	public MovingObjectPosition superrayTrace(double par1, float par3) {
		return super.rayTrace(par1, par3);
	}

	@Override
	public boolean isClientWorld() {
		return master != null ? master.isClientWorld() : super.isClientWorld();
	}

	@Override
	public boolean superisClientWorld() {
		return super.isClientWorld();
	}

	@Override
	public boolean canBeCollidedWith() {
		return master != null ? master.canBeCollidedWith() : super.canBeCollidedWith();
	}

	@Override
	public boolean supercanBeCollidedWith() {
		return super.canBeCollidedWith();
	}

	@Override
	public boolean canBePushed() {
		return master != null ? master.canBePushed() : super.canBePushed();
	}

	@Override
	public boolean supercanBePushed() {
		return super.canBePushed();
	}

	@Override
	protected void setBeenAttacked() {
		if (master != null) master.setBeenAttacked();
		else super.setBeenAttacked();
	}

	@Override
	public void supersetBeenAttacked() {
		super.setBeenAttacked();
	}

	@Override
	public float getRotationYawHead() {
		return master != null ? master.getRotationYawHead() : super.getRotationYawHead();
	}

	@Override
	public float supergetRotationYawHead() {
		return super.getRotationYawHead();
	}

	@Override
	public void setRotationYawHead(float par1) {
		if (master != null) master.setRotationYawHead(par1);
		else super.setRotationYawHead(par1);
	}

	@Override
	public void supersetRotationYawHead(float par1) {
		super.setRotationYawHead(par1);
	}

	@Override
	public boolean isOnSameTeam(EntityLivingBase entityLivingBase) {
		return master != null ? master.isOnSameTeam(entityLivingBase) : super.isOnSameTeam(entityLivingBase);
	}

	@Override
	public boolean superisOnSameTeam(Object entityLivingBase) {
		return super.isOnSameTeam((EntityLivingBase) entityLivingBase);
	}

	@Override
	public boolean isOnTeam(Team team) {
		return master != null ? master.isOnTeam(team) : super.isOnTeam(team);
	}

	@Override
	public boolean superisOnTeam(Object team) {
		return super.isOnTeam((Team) team);
	}

	@Override
	public void curePotionEffects(ItemStack itemStack) {
		if (master != null) master.curePotionEffects(itemStack);
		else super.curePotionEffects(itemStack);
	}

	@Override
	public void supercurePotionEffects(Object itemStack) {
		super.curePotionEffects((ItemStack) itemStack);
	}

	@Override
	public boolean shouldRiderFaceForward(EntityPlayer entityPlayer) {
		return master != null ? master.shouldRiderFaceForward(entityPlayer) : super.shouldRiderFaceForward(entityPlayer);
	}

	@Override
	public boolean supershouldRiderFaceForward(Object entityPlayer) {
		return super.shouldRiderFaceForward((EntityPlayer) entityPlayer);
	}

	@Override
	public DataWatcher getDataWatcher() {
		return (DataWatcher) (master != null ? master.getDataManager() : super.getDataWatcher());
	}

	@Override
	public DataWatcher supergetDataManager() {
		return super.getDataWatcher();
	}
/*
	@Override
	public boolean equals(Object par1Obj) {
		return master != null ? master.equals(par1Obj) : super.equals(par1Obj);
	}

	public boolean superequals(Object par1Obj) {
		return super.equals(par1Obj);
	}

	@Override
	public int hashCode() {
		return master != null ? master.hashCode() : super.hashCode();
	}

	public int superhashCode() {
		return super.hashCode();
	}
*/
	@Override
	protected void setSize(float par1, float par2) {
		if (master != null) master.setSize(par1, par2);
		else super.setSize(par1, par2);
	}

	@Override
	public void supersetSize(float par1, float par2) {
		super.setSize(par1, par2);
	}

	@Override
	protected void setRotation(float par1, float par2) {
		if (master != null) master.setRotation(par1, par2);
		else super.setRotation(par1, par2);
	}

	@Override
	public void supersetRotation(float par1, float par2) {
		super.setRotation(par1, par2);
	}

	@Override
	public void setPosition(double par1, double par3, double par5) {
		if (master != null) master.setPosition(par1, par3, par5);
		else super.setPosition(par1, par3, par5);
	}

	@Override
	public void supersetPosition(double par1, double par3, double par5) {
		super.setPosition(par1, par3, par5);
	}

	@Override
	public void setAngles(float par1, float par2) {
		if (master != null) master.setAngles(par1, par2);
		else super.setAngles(par1, par2);
	}

	@Override
	public void superturn(float par1, float par2) {
		super.setAngles(par1, par2);
	}

	@Override
	protected void setOnFireFromLava() {
		if (master != null) master.setOnFireFromLava();
		else super.setOnFireFromLava();
	}

	@Override
	public void supersetOnFireFromLava() {
		super.setOnFireFromLava();
	}

	@Override
	public void setFire(int par1) {
		if (master != null) master.setFire(par1);
		else super.setFire(par1);
	}

	@Override
	public void supersetFire(int par1) {
		super.setFire(par1);
	}

	@Override
	public void extinguish() {
		if (master != null) master.extinguish();
		else super.extinguish();
	}

	@Override
	public void superextinguish() {
		super.extinguish();
	}

	@Override
	public boolean isOffsetPositionInLiquid(double par1, double par3, double par5) {
		return master != null ? master.isOffsetPositionInLiquid(par1, par3, par5) : super.isOffsetPositionInLiquid(par1, par3, par5);
	}

	@Override
	public boolean superisOffsetPositionInLiquid(double par1, double par3, double par5) {
		return super.isOffsetPositionInLiquid(par1, par3, par5);
	}

	@Override
	public void moveEntity(double par1, double par3, double par5) {
		if (master != null) master.moveEntity(null, par1, par3, par5);
		else super.moveEntity(par1, par3, par5);
	}

	@Override
	public void supermove(Object moverType, double par1, double par3, double par5) {
		super.moveEntity(par1, par3, par5);
	}

	@Override
	protected void doBlockCollisions() {
		if (master != null) master.doBlockCollisions();
		else super.doBlockCollisions();
	}

	@Override
	public void superdoBlockCollisions() {
		super.doBlockCollisions();
	}

	@Override
	protected void playStepSound(int par1, int par2, int par3, int par4) {
		if (master != null) master.playStepSound(par1, par2, par3, par4);
		else super.playStepSound(par1, par2, par3, par4);
	}

	@Override
	public void superplayStepSound(int par1, int par2, int par3, int par4) {
		super.playStepSound(par1, par2, par3, par4);
	}

	@Override
	public AxisAlignedBB getBoundingBox() {
		return (AxisAlignedBB) (master != null ? master.getCollisionBoundingBox() : super.getBoundingBox());
	}

	@Override
	public AxisAlignedBB supergetCollisionBoundingBox() {
		return super.getBoundingBox();
	}

	@Override
	protected void dealFireDamage(int par1) {
		if (master != null) master.dealFireDamage(par1);
		else super.dealFireDamage(par1);
	}

	@Override
	public void superdealFireDamage(int par1) {
		super.dealFireDamage(par1);
	}

	@Override
	public boolean isWet() {
		return master != null ? master.isWet() : super.isWet();
	}

	@Override
	public boolean superisWet() {
		return super.isWet();
	}

	@Override
	public boolean isInWater() {
		return master != null ? master.isInWater() : super.isInWater();
	}

	@Override
	public boolean superisInWater() {
		return super.isInWater();
	}

	@Override
	public boolean handleWaterMovement() {
		return master != null ? master.handleWaterMovement() : super.handleWaterMovement();
	}

	@Override
	public boolean superhandleWaterMovement() {
		return super.handleWaterMovement();
	}

	@Override
	public boolean isInsideOfMaterial(Material material) {
		return master != null ? master.isInsideOfMaterial(material) : super.isInsideOfMaterial(material);
	}

	@Override
	public boolean superisInsideOfMaterial(Object material) {
		return super.isInsideOfMaterial((Material) material);
	}

	@Override
	public boolean handleLavaMovement() {
		return master != null ? master.handleLavaMovement() : super.handleLavaMovement();
	}

	@Override
	public boolean superhandleLavaMovement() {
		return super.handleLavaMovement();
	}

	@Override
	public void moveFlying(float par1, float par2, float par3) {
		if (master != null) master.moveRelative(par1, par2, par3);
		else super.moveFlying(par1, par2, par3);
	}

	@Override
	public void supermoveRelative(float par1, float par2, float par3) {
		super.moveFlying(par1, par2, par3);
	}

	@Override
	public int getBrightnessForRender(float par1) {
		return master != null ? master.getBrightnessForRender(par1) : super.getBrightnessForRender(par1);
	}

	@Override
	public int supergetBrightnessForRender(float par1) {
		return super.getBrightnessForRender(par1);
	}

	@Override
	public float getBrightness(float par1) {
		return master != null ? master.getBrightness(par1) : super.getBrightness(par1);
	}

	@Override
	public float supergetBrightness(float par1) {
		return super.getBrightness(par1);
	}

	@Override
	public void setWorld(World world) {
		if (master != null) master.setWorld(world);
		else super.setWorld(world);
	}

	@Override
	public void supersetWorld(Object world) {
		super.setWorld((World) world);
	}

	@Override
	public void setPositionAndRotation(double par1, double par3, double par5, float par7, float par8) {
		if (master != null) master.setPositionAndRotation(par1, par3, par5, par7, par8);
		else super.setPositionAndRotation(par1, par3, par5, par7, par8);
	}

	@Override
	public void supersetPositionAndRotation(double par1, double par3, double par5, float par7, float par8) {
		super.setPositionAndRotation(par1, par3, par5, par7, par8);
	}

	@Override
	public void setLocationAndAngles(double par1, double par3, double par5, float par7, float par8) {
		if (master != null) master.setLocationAndAngles(par1, par3, par5, par7, par8);
		else super.setLocationAndAngles(par1, par3, par5, par7, par8);
	}

	@Override
	public void supersetLocationAndAngles(double par1, double par3, double par5, float par7, float par8) {
		super.setLocationAndAngles(par1, par3, par5, par7, par8);
	}

	@Override
	public float getDistanceToEntity(Entity entity) {
		return master != null ? master.getDistanceToEntity(entity) : super.getDistanceToEntity(entity);
	}

	@Override
	public float supergetDistanceToEntity(Object entity) {
		return super.getDistanceToEntity((Entity) entity);
	}

	@Override
	public double getDistanceSq(double par1, double par3, double par5) {
		return master != null ? master.getDistanceSq(par1, par3, par5) : super.getDistanceSq(par1, par3, par5);
	}

	@Override
	public double supergetDistanceSq(double par1, double par3, double par5) {
		return super.getDistanceSq(par1, par3, par5);
	}

	@Override
	public double getDistance(double par1, double par3, double par5) {
		return master != null ? master.getDistance(par1, par3, par5) : super.getDistance(par1, par3, par5);
	}

	@Override
	public double supergetDistance(double par1, double par3, double par5) {
		return super.getDistance(par1, par3, par5);
	}

	@Override
	public double getDistanceSqToEntity(Entity entity) {
		return master != null ? master.getDistanceSqToEntity(entity) : super.getDistanceSqToEntity(entity);
	}

	@Override
	public double supergetDistanceSqToEntity(Object entity) {
		return super.getDistanceSqToEntity((Entity) entity);
	}

	@Override
	public void onCollideWithPlayer(EntityPlayer entityPlayer) {
		if (master != null) master.onCollideWithPlayer(entityPlayer);
		else super.onCollideWithPlayer(entityPlayer);
	}

	@Override
	public void superonCollideWithPlayer(Object entityPlayer) {
		super.onCollideWithPlayer((EntityPlayer) entityPlayer);
	}

	@Override
	public void applyEntityCollision(Entity entity) {
		if (master != null) master.applyEntityCollision(entity);
		else super.applyEntityCollision(entity);
	}

	@Override
	public void superapplyEntityCollision(Object entity) {
		super.applyEntityCollision((Entity) entity);
	}

	@Override
	public void addVelocity(double par1, double par3, double par5) {
		if (master != null) master.addVelocity(par1, par3, par5);
		else super.addVelocity(par1, par3, par5);
	}

	@Override
	public void superaddVelocity(double par1, double par3, double par5) {
		super.addVelocity(par1, par3, par5);
	}

	@Override
	public boolean isInRangeToRenderVec3D(Vec3 vec3) {
		return master != null ? master.isInRangeToRenderVec3D(vec3) : super.isInRangeToRenderVec3D(vec3);
	}

	@Override
	public boolean superisInRangeToRenderVec3D(Object vec3) {
		return super.isInRangeToRenderVec3D((Vec3) vec3);
	}

	@Override
	public boolean isInRangeToRenderDist(double par1) {
		return master != null ? master.isInRangeToRenderDist(par1) : super.isInRangeToRenderDist(par1);
	}

	@Override
	public boolean superisInRangeToRenderDist(double par1) {
		return super.isInRangeToRenderDist(par1);
	}

	@Override
	public boolean writeMountToNBT(NBTTagCompound nBTTagCompound) {
		return master != null ? master.writeToNBTAtomically(nBTTagCompound) : super.writeMountToNBT(nBTTagCompound);
	}

	@Override
	public boolean superwriteToNBTAtomically(Object nBTTagCompound) {
		return super.writeMountToNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public boolean writeToNBTOptional(NBTTagCompound nBTTagCompound) {
		return master != null ? master.writeToNBTOptional(nBTTagCompound) : super.writeToNBTOptional(nBTTagCompound);
	}

	@Override
	public boolean superwriteToNBTOptional(Object nBTTagCompound) {
		return super.writeToNBTOptional((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public void writeToNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.writeToNBT(nBTTagCompound);
		else super.writeToNBT(nBTTagCompound);
	}

	@Override
	public void superwriteToNBT(Object nBTTagCompound) {
		super.writeToNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public void readFromNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.readFromNBT(nBTTagCompound);
		else super.readFromNBT(nBTTagCompound);
	}

	@Override
	public void superreadFromNBT(Object nBTTagCompound) {
		super.readFromNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	protected boolean shouldSetPosAfterLoading() {
		return master != null ? master.shouldSetPosAfterLoading() : super.shouldSetPosAfterLoading();
	}

	@Override
	public boolean supershouldSetPosAfterLoading() {
		return super.shouldSetPosAfterLoading();
	}

	@Override
	public void onChunkLoad() {
		if (master != null) master.onChunkLoad();
		else super.onChunkLoad();
	}

	@Override
	public void superonChunkLoad() {
		super.onChunkLoad();
	}

	@Override
	protected NBTTagList newDoubleNBTList(double... par1ArrayOfDouble) {
		return (NBTTagList) (master != null ? master.newDoubleNBTList(par1ArrayOfDouble) : super.newDoubleNBTList(par1ArrayOfDouble));
	}

	@Override
	public NBTTagList supernewDoubleNBTList(double... par1ArrayOfDouble) {
		return super.newDoubleNBTList(par1ArrayOfDouble);
	}

	@Override
	protected NBTTagList newFloatNBTList(float... par1ArrayOfFloat) {
		return (NBTTagList) (master != null ? master.newFloatNBTList(par1ArrayOfFloat) : super.newFloatNBTList(par1ArrayOfFloat));
	}

	@Override
	public NBTTagList supernewFloatNBTList(float... par1ArrayOfFloat) {
		return super.newFloatNBTList(par1ArrayOfFloat);
	}

	@Override
	public float getShadowSize() {
		return master != null ? master.getShadowSize() : super.getShadowSize();
	}

	@Override
	public float supergetShadowSize() {
		return super.getShadowSize();
	}

	@Override
	public EntityItem dropItem(int par1, int par2) {
		return (EntityItem) (master != null ? master.dropItem(par1, par2) : super.dropItem(par1, par2));
	}

	@Override
	public EntityItem superdropItem(int par1, int par2) {
		return super.dropItem(par1, par2);
	}

	@Override
	public EntityItem dropItemWithOffset(int par1, int par2, float par3) {
		return (EntityItem) (master != null ? master.dropItemWithOffset(par1, par2, par3) : super.dropItemWithOffset(par1, par2, par3));
	}

	@Override
	public EntityItem superdropItemWithOffset(int par1, int par2, float par3) {
		return super.dropItemWithOffset(par1, par2, par3);
	}

	@Override
	public EntityItem entityDropItem(ItemStack itemStack, float par2) {
		return (EntityItem) (master != null ? master.entityDropItem(itemStack, par2) : super.entityDropItem(itemStack, par2));
	}

	@Override
	public EntityItem superentityDropItem(Object itemStack, float par2) {
		return super.entityDropItem((ItemStack) itemStack, par2);
	}

	@Override
	public boolean interactFirst(EntityPlayer entityPlayer) {
		return master != null ? master.processInitialInteract(entityPlayer) : super.interactFirst(entityPlayer);
	}

	@Override
	public boolean superprocessInitialInteract(Object entityPlayer) {
		return super.interactFirst((EntityPlayer) entityPlayer);
	}

	@Override
	public AxisAlignedBB getCollisionBox(Entity entity) {
		return (AxisAlignedBB) (master != null ? master.getCollisionBox(entity) : super.getCollisionBox(entity));
	}

	@Override
	public AxisAlignedBB supergetCollisionBox(Object entity) {
		return super.getCollisionBox((Entity) entity);
	}

	@Override
	public void updateRiderPosition() {
		if (master != null) master.updatePassenger();
		else super.updateRiderPosition();
	}

	@Override
	public void superupdatePassenger() {
		super.updateRiderPosition();
	}

	@Override
	public double getMountedYOffset() {
		return master != null ? master.getMountedYOffset() : super.getMountedYOffset();
	}

	@Override
	public double supergetMountedYOffset() {
		return super.getMountedYOffset();
	}

	@Override
	public float getCollisionBorderSize() {
		return master != null ? master.getCollisionBorderSize() : super.getCollisionBorderSize();
	}

	@Override
	public float supergetCollisionBorderSize() {
		return super.getCollisionBorderSize();
	}

	@Override
	public void setInPortal() {
		if (master != null) master.setPortal(null);
		else super.setInPortal();
	}

	@Override
	public void supersetPortal(Object bockPos) {
		super.setInPortal();
	}

	@Override
	public void setVelocity(double par1, double par3, double par5) {
		if (master != null) master.setVelocity(par1, par3, par5);
		else super.setVelocity(par1, par3, par5);
	}

	@Override
	public void supersetVelocity(double par1, double par3, double par5) {
		super.setVelocity(par1, par3, par5);
	}

	@Override
	public boolean isBurning() {
		return master != null ? master.isBurning() : super.isBurning();
	}

	@Override
	public boolean superisBurning() {
		return super.isBurning();
	}

	@Override
	public boolean isRiding() {
		return master != null ? master.isRiding() : super.isRiding();
	}

	@Override
	public boolean superisRiding() {
		return super.isRiding();
	}

	@Override
	public boolean isSneaking() {
		return master != null ? master.isSneaking() : super.isSneaking();
	}

	@Override
	public boolean superisSneaking() {
		return super.isSneaking();
	}

	@Override
	public void setSneaking(boolean par1) {
		if (master != null) master.setSneaking(par1);
		else super.setSneaking(par1);
	}

	@Override
	public void supersetSneaking(boolean par1) {
		super.setSneaking(par1);
	}

	@Override
	public boolean isSprinting() {
		return master != null ? master.isSprinting() : super.isSprinting();
	}

	@Override
	public boolean superisSprinting() {
		return super.isSprinting();
	}

	@Override
	public boolean isInvisible() {
		return master != null ? master.isInvisible() : super.isInvisible();
	}

	@Override
	public boolean superisInvisible() {
		return super.isInvisible();
	}

	@Override
	public void setInvisible(boolean par1) {
		if (master != null) master.setInvisible(par1);
		else super.setInvisible(par1);
	}

	@Override
	public void supersetInvisible(boolean par1) {
		super.setInvisible(par1);
	}

	@Override
	public boolean isEating() {
		return master != null ? master.isEating() : super.isEating();
	}

	@Override
	public boolean superisEating() {
		return super.isEating();
	}

	@Override
	public void setEating(boolean par1) {
		if (master != null) master.setEating(par1);
		else super.setEating(par1);
	}

	@Override
	public void supersetEating(boolean par1) {
		super.setEating(par1);
	}

	@Override
	protected boolean getFlag(int par1) {
		return master != null ? master.getFlag(par1) : super.getFlag(par1);
	}

	@Override
	public boolean supergetFlag(int par1) {
		return super.getFlag(par1);
	}

	@Override
	protected void setFlag(int par1, boolean par2) {
		if (master != null) master.setFlag(par1, par2);
		else super.setFlag(par1, par2);
	}

	@Override
	public void supersetFlag(int par1, boolean par2) {
		super.setFlag(par1, par2);
	}

	@Override
	public int getAir() {
		return master != null ? master.getAir() : super.getAir();
	}

	@Override
	public int supergetAir() {
		return super.getAir();
	}

	@Override
	public void setAir(int par1) {
		if (master != null) master.setAir(par1);
		else super.setAir(par1);
	}

	@Override
	public void supersetAir(int par1) {
		super.setAir(par1);
	}

	@Override
	public void onStruckByLightning(EntityLightningBolt entityLightningBolt) {
		if (master != null) master.onStruckByLightning(entityLightningBolt);
		else super.onStruckByLightning(entityLightningBolt);
	}

	@Override
	public void superonStruckByLightning(Object entityLightningBolt) {
		super.onStruckByLightning((EntityLightningBolt) entityLightningBolt);
	}

	@Override
	protected boolean pushOutOfBlocks(double par1, double par3, double par5) {
		return master != null ? master.pushOutOfBlocks(par1, par3, par5) : super.pushOutOfBlocks(par1, par3, par5);
	}

	@Override
	public boolean superpushOutOfBlocks(double par1, double par3, double par5) {
		return super.pushOutOfBlocks(par1, par3, par5);
	}

	@Override
	public Entity[] getParts() {
		return (Entity[]) (master != null ? master.getParts() : super.getParts());
	}

	@Override
	public Entity[] supergetParts() {
		return super.getParts();
	}

	@Override
	public boolean isEntityEqual(Entity entity) {
		return master != null ? master.isEntityEqual(entity) : super.isEntityEqual(entity);
	}

	@Override
	public boolean superisEntityEqual(Object entity) {
		return super.isEntityEqual((Entity) entity);
	}

	@Override
	public boolean canAttackWithItem() {
		return master != null ? master.canBeAttackedWithItem() : super.canAttackWithItem();
	}

	@Override
	public boolean supercanBeAttackedWithItem() {
		return super.canAttackWithItem();
	}

	@Override
	public boolean hitByEntity(Entity entity) {
		return master != null ? master.hitByEntity(entity) : super.hitByEntity(entity);
	}

	@Override
	public boolean superhitByEntity(Object entity) {
		return super.hitByEntity((Entity) entity);
	}
/*
	@Override
	public String toString() {
		return master != null ? master.toString() : super.toString();
	}

	public String supertoString() {
		return super.toString();
	}
*/
	@Override
	public boolean isEntityInvulnerable() {
		return master != null ? master.isEntityInvulnerable() : super.isEntityInvulnerable();
	}

	@Override
	public boolean superisEntityInvulnerable() {
		return super.isEntityInvulnerable();
	}

	@Override
	public void copyLocationAndAnglesFrom(Entity entity) {
		if (master != null) master.copyLocationAndAnglesFrom(entity);
		else super.copyLocationAndAnglesFrom(entity);
	}

	@Override
	public void supercopyLocationAndAnglesFrom(Object entity) {
		super.copyLocationAndAnglesFrom((Entity) entity);
	}

	@Override
	public void copyDataFrom(Entity entity, boolean par2) {
		if (master != null) master.copyDataFrom(entity, par2);
		else super.copyDataFrom(entity, par2);
	}

	@Override
	public void supercopyDataFrom(Object entity, boolean par2) {
		super.copyDataFrom((Entity) entity, par2);
	}

	@Override
	public void travelToDimension(int par1) {
		if (master != null) master.changeDimension(par1);
		else super.travelToDimension(par1);
	}

	@Override
	public void superchangeDimension(int par1) {
		super.travelToDimension(par1);
	}

	@Override
	public float getBlockExplosionResistance(Explosion explosion, World world, int par3, int par4, int par5, Block block) {
		return master != null ? master.getBlockExplosionResistance(explosion, world, par3, par4, par5, block) : super.getBlockExplosionResistance(explosion, world, par3, par4, par5, block);
	}

	@Override
	public float supergetBlockExplosionResistance(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return super.getBlockExplosionResistance((Explosion) explosion, (World) world, par3, par4, par5, (Block) block);
	}

	@Override
	public boolean shouldExplodeBlock(Explosion explosion, World world, int par3, int par4, int par5, int par6, float par7) {
		return master != null ? master.shouldExplodeBlock(explosion, world, par3, par4, par5, par6, par7) : super.shouldExplodeBlock(explosion, world, par3, par4, par5, par6, par7);
	}

	@Override
	public boolean supershouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7) {
		return super.shouldExplodeBlock((Explosion) explosion, (World) world, par3, par4, par5, par6, par7);
	}

	@Override
	public int getMaxSafePointTries() {
		return master != null ? master.getMaxSafePointTries() : super.getMaxSafePointTries();
	}

	@Override
	public int supergetMaxSafePointTries() {
		return super.getMaxSafePointTries();
	}

	@Override
	public int getTeleportDirection() {
		return (Integer) (master != null ? master.getLastPortalVec() : super.getTeleportDirection());
	}

	@Override
	public Object supergetLastPortalVec() {
		return super.getTeleportDirection();
	}

	@Override
	public boolean doesEntityNotTriggerPressurePlate() {
		return master != null ? master.doesEntityNotTriggerPressurePlate() : super.doesEntityNotTriggerPressurePlate();
	}

	@Override
	public boolean superdoesEntityNotTriggerPressurePlate() {
		return super.doesEntityNotTriggerPressurePlate();
	}

	@Override
	public void addEntityCrashInfo(CrashReportCategory crashReportCategory) {
		if (master != null) master.addEntityCrashInfo(crashReportCategory);
		else super.addEntityCrashInfo(crashReportCategory);
	}

	@Override
	public void superaddEntityCrashInfo(Object crashReportCategory) {
		super.addEntityCrashInfo((CrashReportCategory) crashReportCategory);
	}

	@Override
	public boolean canRenderOnFire() {
		return master != null ? master.canRenderOnFire() : super.canRenderOnFire();
	}

	@Override
	public boolean supercanRenderOnFire() {
		return super.canRenderOnFire();
	}

	@Override
	public UUID getUniqueID() {
		return master != null ? master.getUniqueID() : super.getUniqueID();
	}

	@Override
	public UUID supergetUniqueID() {
		return super.getUniqueID();
	}

	@Override
	public NBTTagCompound getEntityData() {
		return (NBTTagCompound) (master != null ? master.getEntityData() : super.getEntityData());
	}

	@Override
	public NBTTagCompound supergetEntityData() {
		return super.getEntityData();
	}

	@Override
	public boolean shouldRiderSit() {
		return master != null ? master.shouldRiderSit() : super.shouldRiderSit();
	}

	@Override
	public boolean supershouldRiderSit() {
		return super.shouldRiderSit();
	}

	@Override
	public ItemStack getPickedResult(MovingObjectPosition movingObjectPosition) {
		return (ItemStack) (master != null ? master.getPickedResult(movingObjectPosition) : super.getPickedResult(movingObjectPosition));
	}

	@Override
	public ItemStack supergetPickedResult(Object movingObjectPosition) {
		return super.getPickedResult((MovingObjectPosition) movingObjectPosition);
	}

	@Override
	public UUID getPersistentID() {
		return master != null ? master.getPersistentID() : super.getPersistentID();
	}

	@Override
	public UUID supergetPersistentID() {
		return super.getPersistentID();
	}

	@Override
	public boolean shouldRenderInPass(int pass) {
		return master != null ? master.shouldRenderInPass(pass) : super.shouldRenderInPass(pass);
	}

	@Override
	public boolean supershouldRenderInPass(int pass) {
		return super.shouldRenderInPass(pass);
	}

	@Override
	public boolean isCreatureType(EnumCreatureType enumCreatureType, boolean forSpawnCount) {
		return master != null ? master.isCreatureType(enumCreatureType, forSpawnCount) : super.isCreatureType(enumCreatureType, forSpawnCount);
	}

	@Override
	public boolean superisCreatureType(Object enumCreatureType, boolean forSpawnCount) {
		return super.isCreatureType((EnumCreatureType) enumCreatureType, forSpawnCount);
	}

	@Override
	public String registerExtendedProperties(String identifier, IExtendedEntityProperties iExtendedEntityProperties) {
		return master != null ? master.registerExtendedProperties(identifier, iExtendedEntityProperties) : super.registerExtendedProperties(identifier, iExtendedEntityProperties);
	}

	@Override
	public String superregisterExtendedProperties(String identifier, Object iExtendedEntityProperties) {
		return super.registerExtendedProperties(identifier, (IExtendedEntityProperties) iExtendedEntityProperties);
	}

	@Override
	public IExtendedEntityProperties getExtendedProperties(String identifier) {
		return (IExtendedEntityProperties) (master != null ? master.getExtendedProperties(identifier) : super.getExtendedProperties(identifier));
	}

	@Override
	public IExtendedEntityProperties supergetExtendedProperties(String identifier) {
		return super.getExtendedProperties(identifier);
	}

	@Override
	public boolean canRiderInteract() {
		return master != null ? master.canRiderInteract() : super.canRiderInteract();
	}

	@Override
	public boolean supercanRiderInteract() {
		return super.canRiderInteract();
	}

	@Override
	public boolean shouldDismountInWater(Entity entity) {
		return master != null ? master.shouldDismountInWater(entity) : super.shouldDismountInWater(entity);
	}

	@Override
	public boolean supershouldDismountInWater(Object entity) {
		return super.shouldDismountInWater((Entity) entity);
	}

	@Override
	public Object supercopyPlayer(Object entityplayer) {
		return null;
	}

	@Override
	public boolean superattackEntityFrom(Object damageSource, int par2) {
		return super.attackEntityFrom((DamageSource) damageSource, par2);
	}

	@Override
	public void supersetPositionCorrection(double par1, double par3, double par5) {
		super.setPosition(posX + par1, posY + par3, posZ + par5);
	}

	@Override
	public Object supercopyInventory(Object inventoryplayer) {
		return null;
	}

	@Override
	public boolean superattackEntityFrom(Object entity, Object damageSource, int i) {
		return super.attackEntityFrom((DamageSource) damageSource, i);
	}

	@Override
	public int supergetMaxHealthInt() {
		return (int) super.getMaxHealth();
	}

	@Override
	public int supergetHealthInt() {
		return (int) super.getHealth();
	}

	@Override
	public void supersetHealthInt(int i) {
		super.setHealth(i);
	}

	@Override
	public void supercloseScreenNoPacket() {
	}

	@Override
	public Object supergetStatFileWriter() {
		return null;
	}

	@Override
	public void superfunc_146100_a(Object tileEntity) {
	}

	@Override
	public void superfunc_146095_a(Object commandBlockLogic) {
	}

	@Override
	public void superfunc_146093_a(Object tileEntityHopper) {
	}

	@Override
	public void superfunc_146104_a(Object tileEntityBeacon) {
	}

	@Override
	public void superfunc_146102_a(Object tileEntityDispenser) {
	}

	@Override
	public void superfunc_146098_a(Object tileEntityBrewingStand) {
	}

	@Override
	public void superfunc_146101_a(Object tileEntityFurnace) {
	}

	@Override
	public void superaddChatMessage(Object iChatComponent) {
		super.addChatMessage((String) iChatComponent);
	}

	@Override
	public void superaddChatComponentMessage(Object iChatComponent, boolean p_146105_2_) {
	}

	@Override
	public String supergetSplashSound() {
		return null;
	}

	@Override
	public String supergetSwimSound() {
		return null;
	}

	@Override
	public float supergetBreakSpeed(Object block, boolean p_146096_2_, int meta) {
		return 0F;
	}

	@Override
	public float supergetBreakSpeed(Object block, boolean p_146096_2_, int meta, int x, int y, int z) {
		return 0F;
	}

	@Override
	public Object superfunc_146097_a(Object itemStack, boolean p_146097_2_, boolean p_146097_3_) {
		return null;
	}

	@Override
	public Object supergetGameProfile() {
		return null;
	}

	@Override
	public String superfunc_146067_o(int p_146067_1_) {
		return null;
	}

	@Override
	public Object supergetEquipmentInSlot(int par1) {
		return null;
	}

	@Override
	public Object superfunc_145748_c_() {
		return null;
	}

	@Override
	public boolean superfunc_146066_aG() {
		return false;
	}

	@Override
	public int supergetEntityId() {
		return entityId;
	}

	@Override
	public void supersetEntityId(int p_145769_1_) {
		entityId = p_145769_1_;
	}

	@Override
	public void superfunc_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Object block) {
	}

	@Override
	public void superfunc_145775_I() {
	}

	@Override
	public boolean superisInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
		return false;
	}

	@Override
	public Object superfunc_145778_a(Object item, int p_145778_2_, float p_145778_3_) {
		return null;
	}

	@Override
	public Object superdropItem(Object item, int p_145779_2_) {
		return null;
	}

	@Override
	public float superfunc_145772_a(Object explosion, Object world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Object block) {
		return 0F;
	}

	@Override
	public boolean superfunc_145774_a(Object explosion, Object world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Object block, float p_145774_7_) {
		return false;
	}

	@Override
	public void superfunc_145781_i(int p_145781_1_) {
	}

	@Override
	public boolean superfunc_152122_n() {
		return false;
	}

	@Override
	public boolean superfunc_152123_o() {
		return false;
	}

	@Override
	public void superfunc_152121_a(Object type, Object resourceLocation) {
	}

	@Override
	public void superfunc_152111_bt() {
	}

	@Override
	public void superfunc_152112_bu() {
	}

	@Override
	public void superonUpdateWalkingPlayer() {
	}

	@Override
	public void superfunc_175159_q() {
	}

	@Override
	public boolean superisUser() {
		return super.isPlayer();
	}

	@Override
	public void supersendHorseJump() {
	}

	@Override
	public void supersendHorseInventory() {
	}

	@Override
	public void supersetClientBrand(String brand) {
	}

	@Override
	public String supergetClientBrand() {
		return null;
	}

	@Override
	public Object supergetPosition() {
		return super.getPosition(1.0F);
	}

	@Override
	public boolean superisServerWorld() {
		return !super.isClientWorld();
	}

	@Override
	public void superopenEditSign(Object tileEntitySign) {
	}

	@Override
	public void superopenEditCommandBlock(Object commandBlockLogic) {
	}

	@Override
	public void superdisplayGui(Object iInteractionObject) {
	}

	@Override
	public void superdisplayVillagerTradeGui(Object iMerchant) {
	}

	@Override
	public boolean superisCurrentViewEntity() {
		return false;
	}

	@Override
	public boolean superisSpectator() {
		return false;
	}

	@Override
	public boolean superhasPlayerInfo() {
		return false;
	}

	@Override
	public Object supergetPlayerInfo() {
		return false;
	}

	@Override
	public boolean superhasSkin() {
		return false;
	}

	@Override
	public String supergetSkinType() {
		return null;
	}

	@Override
	public float supergetFovModifier() {
		return 0F;
	}

	@Override
	public Object superdropItem(Object itemStack, boolean dropAround, boolean traceItem) {
		return null;
	}

	@Override
	public float supergetToolDigEfficiency(Object block) {
		return 0F;
	}

	@Override
	public float supergetBreakSpeed(Object iBlockState, Object blockPos) {
		return 0F;
	}

	@Override
	public Object supertrySleep(Object blockPos) {
		return null;
	}

	@Override
	public void supersetSpawnPoint(Object blockPos, boolean forced) {
	}

	@Override
	public void superfunc_175145_a(Object statBase) {
	}

	@Override
	public void superfall(float distance, float damageMultiplier) {
		super.fall(distance);
	}

	@Override
	public String supergetFallSoundString(int damageValue) {
		return null;
	}

	@Override
	public int supergetXPSeed() {
		return -1;
	}

	@Override
	public void superremoveExperienceLevel(int levels) {
	}

	@Override
	public boolean superisAllowEdit() {
		return false;
	}

	@Override
	public boolean supercanPlayerEdit(Object blockPos, Object enumFacing, Object itemStack) {
		return false;
	}

	@Override
	public String supergetName() {
		return super.getEntityName();
	}

	@Override
	public Object[] supergetInventory() {
		return null;
	}

	@Override
	public boolean supercanOpen(Object lockCode) {
		return false;
	}

	@Override
	public boolean superfunc_175148_a(Object enumPlayerModelParts) {
		return false;
	}

	@Override
	public boolean supersendCommandFeedback() {
		return false;
	}

	@Override
	public boolean superreplaceItemInInventory(int p_174820_1_, Object itemStack) {
		return false;
	}

	@Override
	public boolean superhasReducedDebug() {
		return false;
	}

	@Override
	public void supersetReducedDebug(boolean reducedDebug) {
	}

	@Override
	public String supergetDisplayNameString() {
		return super.getDisplayName();
	}

	@Override
	public void superonKillCommand() {
		super.kill();
	}

	@Override
	public void superfunc_180433_a(double p_180433_1_, boolean p_180433_3_, Object block, Object blockPos) {
	}

	@Override
	public int supergetRevengeTimer() {
		return -1;
	}

	@Override
	public void superfunc_175135_B() {
	}

	@Override
	public void superfunc_175133_bi() {
	}

	@Override
	public void superaddRandomDrop() {
	}

	@Override
	public Object supergetCombatTracker() {
		return null;
	}

	@Override
	public float superfunc_175134_bD() {
		return 0F;
	}

	@Override
	public void superfunc_180466_bG() {
	}

	@Override
	public void superfunc_180426_a(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
	}

	@Override
	public void superfunc_175136_bO() {
	}

	@Override
	public void superplayStepSound(Object blockPos, Object block) {
	}

	@Override
	public boolean superisSilent() {
		return false;
	}

	@Override
	public void supersetSilent(boolean isSilent) {
	}

	@Override
	public void superspawnRunningParticles() {
	}

	@Override
	public void supercreateRunningParticles() {
	}

	@Override
	public boolean superisInLava() {
		return false;
	}

	@Override
	public void supermoveToBlockPosAndAngles(Object blockPos, float p_174828_2_, float p_174828_3_) {
	}

	@Override
	public double supergetDistanceSq(Object blockPos) {
		return 0D;
	}

	@Override
	public double supergetDistanceSqToCenter(Object blockPos) {
		return 0D;
	}

	@Override
	public Object supergetPositionEyes(float p_174824_1_) {
		return null;
	}

	@Override
	public boolean superisEntityInvulnerable(Object damageSource) {
		return false;
	}

	@Override
	public void supercopyDataFromOld(Object entity) {
	}

	@Override
	public float supergetExplosionResistance(Object explosion, Object world, Object blockPos, Object iBlockState) {
		return 0F;
	}

	@Override
	public boolean superfunc_174816_a(Object explosion, Object world, Object blockPos, Object iBlockState, float p_174816_5_) {
		return false;
	}

	@Override
	public int supergetMaxFallHeight() {
		return -1;
	}

	@Override
	public void supersetCustomNameTag(String p_96094_1_) {
	}

	@Override
	public String supergetCustomNameTag() {
		return null;
	}

	@Override
	public boolean superhasCustomName() {
		return false;
	}

	@Override
	public void supersetAlwaysRenderNameTag(boolean p_174805_1_) {
	}

	@Override
	public boolean supergetAlwaysRenderNameTag() {
		return super.getAlwaysRenderNameTagForRender();
	}

	@Override
	public Object supergetHorizontalFacing() {
		return null;
	}

	@Override
	public Object superfunc_174823_aP() {
		return null;
	}

	@Override
	public boolean superfunc_174827_a(Object entityPlayerMP) {
		return false;
	}

	@Override
	public Object supergetEntityBoundingBox() {
		return super.getBoundingBox();
	}

	@Override
	public void supersetEntityBoundingBox(Object axisAlignedBB) {
	}

	@Override
	public boolean superisOutsideBorder() {
		return false;
	}

	@Override
	public void supersetOutsideBorder(boolean p_174821_1_) {
	}

	@Override
	public Object supergetPositionVector() {
		return null;
	}

	@Override
	public Object supergetCommandSenderEntity() {
		return null;
	}

	@Override
	public void supersetCommandStat(Object type, int amount) {
	}

	@Override
	public Object superfunc_174807_aT() {
		return null;
	}

	@Override
	public void superfunc_174817_o(Object entity) {
	}

	@Override
	public Object superfunc_174819_aU() {
		return null;
	}

	@Override
	public void superfunc_174834_g(Object nBTTagCompound) {
	}

	@Override
	public boolean superfunc_174825_a(Object entityPlayer, Object vec3) {
		return false;
	}

	@Override
	public boolean superfunc_180427_aV() {
		return false;
	}

	@Override
	public void superfunc_174815_a(Object entityLivingBase, Object entity) {
	}

	@Override
	public void superheal(int par1) {
		super.heal(par1);
	}

	@Override
	public void superdamageEntity(Object damageSource, int par2) {
		super.damageEntity((DamageSource) damageSource, par2);
	}

	@Override
	public boolean superfunc_71066_bF() {
		return false;
	}

	@Override
	public void superupdateCloak() {
	}

	@Override
	public void supersendChatToPlayer(String par1Str) {
	}

	@Override
	public float supergetMaxHealthFloat() {
		return super.getMaxHealth();
	}

	@Override
	public boolean superfunc_96122_a(Object entityPlayer) {
		return false;
	}

	@Override
	public void superalertWolves(Object entityLiving, boolean par2) {
	}

	@Override
	public void superdamageArmor(int par1) {
		super.damageArmor(par1);
	}

	@Override
	public float superfunc_82243_bO() {
		return 0F;
	}

	@Override
	public void superfunc_82162_bC() {
	}

	@Override
	public boolean supercanCurrentToolHarvestBlock(int par1, int par2, int par3) {
		return false;
	}

	@Override
	public boolean superfunc_94062_bN() {
		return false;
	}

	@Override
	public boolean superfunc_94059_bO() {
		return false;
	}

	@Override
	public boolean supercanPickUpLoot() {
		return false;
	}

	@Override
	public Object supergetTranslator() {
		return null;
	}

	@Override
	public String supertranslateString(String par1Str, Object[] par2ArrayOfObj) {
		return null;
	}

	@Override
	public boolean superfunc_98034_c(Object entityPlayer) {
		return false;
	}

	@Override
	public boolean superfunc_96092_aw() {
		return false;
	}

	@Override
	public int superfunc_96121_ay() {
		return -1;
	}

	@Override
	public Object supergetLookHelper() {
		return null;
	}

	@Override
	public Object supergetMoveHelper() {
		return null;
	}

	@Override
	public Object supergetJumpHelper() {
		return null;
	}

	@Override
	public Object supergetNavigator() {
		return null;
	}

	@Override
	public Object supergetEntitySenses() {
		return null;
	}

	@Override
	public Object supergetLastAttackingEntity() {
		return super.getLastAttacker();
	}

	@Override
	public void supersetLastAttackingEntity(Object entity) {
		super.setLastAttacker((Entity) entity);
	}

	@Override
	public Object supergetAttackTarget() {
		return super.getAITarget();
	}

	@Override
	public void supersetAttackTarget(Object entityLiving) {
		super.setRevengeTarget((EntityLivingBase) entityLiving);
	}

	@Override
	public boolean supercanAttackClass(Class par1Class) {
		return false;
	}

	@Override
	public void supereatGrassBonus() {
	}

	@Override
	public boolean superisWithinHomeDistanceCurrentPosition() {
		return false;
	}

	@Override
	public boolean superisWithinHomeDistance(int par1, int par2, int par3) {
		return false;
	}

	@Override
	public void supersetHomeArea(int par1, int par2, int par3, int par4) {
	}

	@Override
	public Object supergetHomePosition() {
		return null;
	}

	@Override
	public float supergetMaximumHomeDistance() {
		return 0F;
	}

	@Override
	public void superdetachHome() {
	}

	@Override
	public boolean superhasHome() {
		return false;
	}

	@Override
	public String supergetTexture() {
		return null;
	}

	@Override
	public int supergetTalkInterval() {
		return -1;
	}

	@Override
	public void superplayLivingSound() {
	}

	@Override
	public void superspawnExplosionParticle() {
	}

	@Override
	public float supergetHealth() {
		return super.getHealth();
	}

	@Override
	public void supersetEntityHealth(int par1) {
		super.setHealth(par1);
	}

	@Override
	public int superapplyArmorCalculations(Object damageSource, int par2) {
		return (int) super.applyArmorCalculations((DamageSource) damageSource, par2);
	}

	@Override
	public int superapplyPotionDamageCalculations(Object damageSource, int par2) {
		return (int) super.applyPotionDamageCalculations((DamageSource) damageSource, par2);
	}

	@Override
	public void superknockBack(Object entity, int par2, double par3, double par5) {
		super.knockBack((Entity) entity, par2, par3, par5);
	}

	@Override
	public int supergetDropItemId() {
		return -1;
	}

	@Override
	public void supersetMoveForward(float par1) {
	}

	@Override
	public void superfunc_85033_bc() {
	}

	@Override
	public boolean supercanDespawn() {
		return false;
	}

	@Override
	public void superdespawnEntity() {
	}

	@Override
	public int supergetVerticalFaceSpeed() {
		return -1;
	}

	@Override
	public void superfaceEntity(Object entity, float par2, float par3) {
	}

	@Override
	public boolean supergetCanSpawnHere() {
		return false;
	}

	@Override
	public float supergetRenderSizeModifier() {
		return 0F;
	}

	@Override
	public int supergetMaxSpawnedInChunk() {
		return -1;
	}

	@Override
	public void superonChangedPotionEffect(Object potionEffect) {
	}

	@Override
	public float supergetSpeedModifier() {
		return 0F;
	}

	@Override
	public int superfunc_82143_as() {
		return -1;
	}

	@Override
	public void superinitCreature() {
	}

	@Override
	public boolean supercanBeSteered() {
		return false;
	}

	@Override
	public void superfunc_94058_c(String par1Str) {
	}

	@Override
	public String superfunc_94057_bL() {
		return null;
	}

	@Override
	public boolean superfunc_94056_bM() {
		return false;
	}

	@Override
	public void superfunc_94061_f(boolean par1) {
	}

	@Override
	public void superfunc_96120_a(int par1, float par2) {
	}

	@Override
	public void supersetCanPickUpLoot(boolean par1) {
	}

	@Override
	public boolean superfunc_104002_bU() {
		return false;
	}

	@Override
	public boolean superaddNotRiddenEntityID(Object nBTTagCompound) {
		return false;
	}

	@Override
	public boolean superaddEntityID(Object nBTTagCompound) {
		return false;
	}

	@Override
	public boolean superinteract(Object entityPlayer) {
		return super.interactWith((Entity) entityPlayer);
	}

	@Override
	public void superunmountEntity(Object entity) {
		super.dismountEntity((Entity) entity);
	}

	@Override
	public boolean superfunc_85031_j(Object entity) {
		return false;
	}

	@Override
	public void superfunc_82149_j(Object entity) {
	}

	@Override
	public float superfunc_82146_a(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return 0F;
	}

	@Override
	public boolean superfunc_96091_a(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7) {
		return false;
	}

	@Override
	public void superfunc_85029_a(Object crashReportCategory) {
	}

	@Override
	public void setPositionCorrection(double par1, double par3, double par5) {
		if (master != null) master.setPositionCorrection(par1, par3, par5);
	}

	@Override
	public void supersendMotionUpdates() {
	}

	@Override
	public void publicSetSize(float f, float f1) {
		if (master != null) master.setSize(f, f1);
	}

	@Override
	public void publicResetHeight() {
		if (master != null) master.resetHeight();
	}

	@Override
	public void superfunc_110318_g() {
	}

	@Override
	public void superfunc_110322_i() {
	}

	@Override
	public void superfunc_142020_c(String par1Str) {
	}

	@Override
	public String superfunc_142021_k() {
		return null;
	}

	@Override
	public boolean superisRidingHorse() {
		return false;
	}

	@Override
	public float supergetHorseJumpPower() {
		return 0F;
	}

	@Override
	public void supersetupCustomSkin() {
	}

	@Override
	public Object supergetTextureSkin() {
		return null;
	}

	@Override
	public Object supergetTextureCape() {
		return null;
	}

	@Override
	public Object supergetLocationSkin() {
		return null;
	}

	@Override
	public Object supergetLocationCape() {
		return null;
	}

	@Override
	public String supergetAmbientSound() {
		return null;
	}

	@Override
	public float supergetFOVMultiplier() {
		return 0.0F;
	}

	@Override
	public void supertravel(float f, float f1, float f2) {
		super.moveEntityWithHeading(f, f1);
	}

	@Override
	public String supergetHurtSound(Object damageSource) {
		return super.getHurtSound();
	}

	@Override
	public float supergetMaxHealth() {
		return super.getMaxHealth();
	}

	@Override
	public void superplaySound(Object par1Str, float par2, float par3) {
		super.playSound((String) par1Str, par2, par3);
	}

	@Override
	public void superdropLoot() {
	}

	@Override
	public void supersetNoAI(boolean par1) {
	}

	@Override
	public boolean superisNoDespawnRequired() {
		return false;
	}

	@Override
	public void supersendStatusMessage(Object iChatComponent, boolean p_146105_2_) {
		super.addChatMessage((String) iChatComponent);
	}

	@Override
	public boolean supercanDropLoot() {
		return false;
	}

	@Override
	public void superonDataWatcherUpdate(int p_145781_1_) {
	}

	@Override
	public void supersendEnterCombat() {
	}

	@Override
	public void supersendEndCombat() {
	}

	@Override
	public void supercloseScreenAndDropStack() {
	}

	@Override
	public float supergetDigSpeed(Object iBlockState, Object blockPos) {
		return 0.0F;
	}

	@Override
	public void superonEnchant(Object itemStack, int levels) {
	}

	@Override
	public boolean superisWearing(Object enumPlayerModelParts) {
		return false;
	}

	@Override
	public void superupdatePotionMetadata() {
	}

	@Override
	public void superresetPotionEffectMetadata() {
	}

	@Override
	public float supergetJumpUpwardsMotion() {
		return 0.0F;
	}

	@Override
	public void superhandleJumpLava() {
	}

	@Override
	public void supersetPositionAndRotationDirect(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
		super.setPositionAndRotation2(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_);
	}

	@Override
	public void supermarkPotionsDirty() {
	}

	@Override
	public boolean supercanExplosionDestroyBlock(Object explosion, Object world, Object blockPos, Object iBlockState, float p_174816_5_) {
		return false;
	}

	@Override
	public Object supergetHoverEvent() {
		return null;
	}

	@Override
	public boolean superisSpectatedByPlayer(Object entityPlayerMP) {
		return false;
	}

	@Override
	public Object supergetCommandStats() {
		return null;
	}

	@Override
	public Object supergetNBTTagCompound() {
		return null;
	}

	@Override
	public void superclientUpdateEntityNBT(Object nBTTagCompound) {
	}

	@Override
	public boolean superinteractAt(Object entityPlayer, Object vec3) {
		return false;
	}

	@Override
	public boolean superisImmuneToExplosions() {
		return false;
	}

	@Override
	public void superapplyEnchantments(Object entityLivingBase, Object entity) {
	}

	@Override
	public void supersetInPortal() {
		super.setInPortal();
	}

	@Override
	public boolean superequals(Object p_equals_1_) {
		return super.equals(p_equals_1_);
	}

	@Override
	public int superhashCode() {
		return super.hashCode();
	}

	@Override
	public boolean superattackEntityFrom(Object damageSource, Object p_70097_2_) {
		return super.attackEntityFrom((DamageSource) damageSource, (Float) p_70097_2_);
	}

	@Override
	public Object supergetItemStackFromSlot(Object par1) {
		return null;
	}

	@Override
	public void supersetItemStackToSlot(Object entityEquipmentSlot, Object itemStack) {
	}

	@Override
	public Object supergetItemStackFromSlot(int par1) {
		return null;
	}

	@Override
	public Object superdropItemWithOffset(Object item, int p_145778_2_, float p_145778_3_) {
		return super.dropItemWithOffset((Integer) item, p_145778_2_, p_145778_3_);
	}

	@Override
	public void superdisplayGuiEditCommandCart(Object commandBlockLogic) {
	}

	@Override
	public void supertakeStat(Object statBase) {
	}

	@Override
	public Object supergetFallSound(int damageValue) {
		return null;
	}

	@Override
	public void supersetCommandStats(Object entity) {
	}

	@Override
	public void superswingArm(Object enumHand) {
		super.swingItem();
	}

	@Override
	public void superopenBook(Object itemStack, Object enumHand) {
	}

	@Override
	public Object superinteract(Object entity, Object itemStack, Object enumHand) {
		return null;
	}

	@Override
	public void superupdatePassenger(Object entity) {
	}

	@Override
	public boolean superprocessInitialInteract(Object entityPlayer, Object itemStack, Object enumHand) {
		return false;
	}

	@Override
	public void supersetRenderYawOffset(float p_181013_1_) {
	}

	@Override
	public void superdropLoot(boolean p_184610_1_, int p_184610_2_, Object damageSource) {
	}

	@Override
	public void superfrostWalk(Object blockPos) {
	}

	@Override
	public void superplayEquipSound(Object itemStack) {
	}

	@Override
	public Object superremoveActivePotionEffect(Object potion) {
		return null;
	}

	@Override
	public void superremovePotionEffect(Object potion) {
	}

	@Override
	public void superplayHurtSound(Object damageSource) {
	}

	@Override
	public void superdamageShield(float p_184590_1_) {
	}

	@Override
	public Object supergetHeldItemOffhand() {
		return super.getHeldItem();
	}

	@Override
	public Object supergetHeldItem(Object enumHand) {
		return super.getHeldItem();
	}

	@Override
	public void supersetHeldItem(Object enumHand, Object itemStack) {
	}

	@Override
	public Object supergetActiveHand() {
		return null;
	}

	@Override
	public void superupdateActiveHand() {
	}

	@Override
	public void supersetActiveHand(Object enumHand) {
	}

	@Override
	public Object supergetActiveItemStack() {
		return null;
	}

	@Override
	public int supergetItemInUseMaxCount() {
		return -1;
	}

	@Override
	public void superstopActiveHand() {
	}

	@Override
	public void superresetActiveHand() {
	}

	@Override
	public boolean superisActiveItemStackBlocking() {
		return false;
	}

	@Override
	public boolean superisElytraFlying() {
		return false;
	}

	@Override
	public int supergetTicksElytraFlying() {
		return -1;
	}

	@Override
	public boolean superattemptTeleport(double x, double y, double z) {
		return false;
	}

	@Override
	public boolean supercanBeHitWithPotion() {
		return false;
	}

	@Override
	public void superplayStepSound(int par1, int par2, int par3, Object par4) {
		super.playStepSound(par1, par2, par3, (Integer) par4);
	}

	@Override
	public boolean superisInRangeToRender3d(Object vec3) {
		return super.isInRangeToRenderVec3D((Vec3) vec3);
	}

	@Override
	public boolean supershouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, Object par6, float par7) {
		return super.shouldExplodeBlock((Explosion) explosion, (World) world, par3, par4, par5, (Integer) par6, par7);
	}

	@Override
	public Object supergetTags() {
		return null;
	}

	@Override
	public boolean superaddTag(String tag) {
		return false;
	}

	@Override
	public boolean superremoveTag(String tag) {
		return false;
	}

	@Override
	public void supersetDropItemsWhenDead(boolean p_184174_1_) {
	}

	@Override
	public void superdecrementTimeUntilPortal() {
	}

	@Override
	public void superresetPositionToBB() {
	}

	@Override
	public void superapplyOrientationToEntity(Object entity) {
	}

	@Override
	public boolean supercanBeRidden(Object entity) {
		return false;
	}

	@Override
	public void superremovePassengers() {
	}

	@Override
	public void superaddPassenger(Object entity) {
		super.mountEntity((Entity) entity);
	}

	@Override
	public void superremovePassenger(Object entity) {
		super.mountEntity(null);
	}

	@Override
	public boolean supercanFitPassenger(Object entity) {
		return false;
	}

	@Override
	public Object supergetHeldEquipment() {
		return null;
	}

	@Override
	public Object supergetArmorInventoryList() {
		return null;
	}

	@Override
	public Object supergetEquipmentAndArmor() {
		return null;
	}

	@Override
	public boolean superisBeingRidden() {
		return false;
	}

	@Override
	public boolean superisGlowing() {
		return false;
	}

	@Override
	public void supersetGlowing(boolean p_184195_1_) {
	}

	@Override
	public boolean superisOnScoreboardTeam(Object team) {
		return false;
	}

	@Override
	public void supersetEntityInvulnerable(boolean isInvulnerable) {
	}

	@Override
	public boolean superisNonBoss() {
		return false;
	}

	@Override
	public void supersetUniqueId(UUID uniqueIdIn) {
	}

	@Override
	public void supernotifyDataManagerChange(Object dataParameter) {
	}

	@Override
	public Object supergetAdjustedHorizontalFacing() {
		return null;
	}

	@Override
	public Object supergetRenderBoundingBox() {
		return null;
	}

	@Override
	public Object supergetServer() {
		return null;
	}

	@Override
	public Object superapplyPlayerInteraction(Object entityPlayer, Object vec3d, Object itemStack, Object enumHand) {
		return null;
	}

	@Override
	public boolean superhasCapability(Object capability, Object enumFacing) {
		return false;
	}

	@Override
	public void superdeserializeNBT(Object nBTTagCompound) {
	}

	@Override
	public Object superserializeNBT() {
		return null;
	}

	@Override
	public void superaddTrackingPlayer(Object entityPlayerMP) {
	}

	@Override
	public void superremoveTrackingPlayer(Object entityPlayerMP) {
	}

	@Override
	public float supergetRotatedYaw(Object rotation) {
		return 0.0F;
	}

	@Override
	public float supergetMirroredYaw(Object mirror) {
		return 0.0F;
	}

	@Override
	public boolean supersetPositionNonDirty() {
		return false;
	}

	@Override
	public Object supergetControllingPassenger() {
		return null;
	}

	@Override
	public Object supergetPassengers() {
		return null;
	}

	@Override
	public boolean superisPassenger(Object entity) {
		return false;
	}

	@Override
	public Object supergetRecursivePassengers() {
		return null;
	}

	@Override
	public Object supergetLowestRidingEntity() {
		return ridingEntity;
	}

	@Override
	public boolean superisRidingSameEntity(Object entity) {
		return false;
	}

	@Override
	public boolean superisRidingOrBeingRiddenBy(Object entity) {
		return false;
	}

	@Override
	public boolean supercanPassengerSteer() {
		return false;
	}

	@Override
	public Object supergetPushReaction() {
		return null;
	}

	@Override
	public Object supergetSoundCategory() {
		return null;
	}

	@Override
	public Object supergetCapability(Object capability, Object enumFacing) {
		return null;
	}

	@Override
	public Object supergetRecursivePassengersByType(Class entityClass) {
		return null;
	}

	@Override
	public void supersetServerBrand(String brand) {
	}

	@Override
	public String supergetServerBrand() {
		return null;
	}

	@Override
	public int supergetPermissionLevel() {
		return -1;
	}

	@Override
	public void supersetPermissionLevel(int p_184839_1_) {
	}

	@Override
	public void superdisplayGuiCommandBlock(Object tileEntityCommandBlock) {
	}

	@Override
	public boolean superisRowingBoat() {
		return false;
	}

	@Override
	public boolean superisCreative() {
		return false;
	}

	@Override
	public boolean superisPlayerInfoSet() {
		return false;
	}

	@Override
	public Object supergetLocationElytra() {
		return null;
	}

	@Override
	public Object supercreateCooldownTracker() {
		return null;
	}

	@Override
	public void superupdateSize() {
	}

	@Override
	public void superspawnSweepParticles() {
	}

	@Override
	public boolean superhasAchievement(Object achievement) {
		return false;
	}

	@Override
	public Object supergetPrimaryHand() {
		return null;
	}

	@Override
	public void supersetPrimaryHand(Object enumHandSide) {
	}

	@Override
	public float supergetCooldownPeriod() {
		return 0.0F;
	}

	@Override
	public float supergetCooledAttackStrength(float adjustTicks) {
		return 0.0F;
	}

	@Override
	public void superresetCooldown() {
	}

	@Override
	public Object supergetCooldownTracker() {
		return null;
	}

	@Override
	public float supergetLuck() {
		return 0.0F;
	}

	@Override
	public void superaddPrefix(Object iTextComponent) {
	}

	@Override
	public void superaddSuffix(Object iTextComponent) {
	}

	@Override
	public Object supergetPrefixes() {
		return null;
	}

	@Override
	public Object supergetSuffixes() {
		return null;
	}

	@Override
	public boolean superignoreItemEntityData() {
		return false;
	}

	@Override
	public void supersetItemStackToSlot(int p_70062_1_, Object itemStack) {
	}

	@Override
	public boolean superisNotColliding() {
		return false;
	}

	@Override
	public String supergetCachedUniqueIdString() {
		return null;
	}

	@Override
	public int supergetBrightnessForRender() {
		return -1;
	}

	@Override
	public float supergetBrightness() {
		return 0.0F;
	}

	@Override
	public Object supergetTeleportDirection() {
		return super.getTeleportDirection();
	}

	@Override
	public Object superfunc_181012_aH() {
		return null;
	}

	@Override
	public void superfunc_181013_g(float p_181013_1_) {
	}

	@Override
	public void supersetAngles(float yaw, float pitch) {
		super.setAngles(yaw, pitch);
	}

	@Override
	public boolean supercanCommandSenderUseCommand(int permLevel, String commandName) {
		return false;
	}

	@Override
	public void superOnInsideBlock(Object iBlockState) {
	}

	@Override
	public float superfunc_191954_d(float p_191954_1_) {
		return 0.0F;
	}

	@Override
	public boolean superfunc_191957_ae() {
		return false;
	}

	@Override
	public boolean superhasNoGravity() {
		return false;
	}

	@Override
	public void supersetNoGravity(boolean noGravity) {
	}

	@Override
	public boolean superfunc_191953_am() {
		return false;
	}

	@Override
	public Object supergetPitchYaw() {
		return null;
	}

	@Override
	public Object supergetForward() {
		return null;
	}

	@Override
	public boolean supergetIsInvulnerable() {
		return false;
	}

	@Override
	public boolean supercanTrample(Object world, Object block, Object blockPos, float fallDistance) {
		return false;
	}

	@Override
	public int supergetFireImmuneTicks() {
		return -1;
	}

	@Override
	public Map supergetActivePotionMap() {
		return null;
	}

	@Override
	public void superBlockUsingShield(Object entityLivingBase) {
	}

	@Override
	public Object supergetLastDamageSource() {
		return null;
	}

	@Override
	public boolean superhasItemInSlot(Object entityEquipmentSlot) {
		return false;
	}

	@Override
	public float supergetWaterSlowDown() {
		return 0.0F;
	}

	@Override
	public boolean superattackable() {
		return false;
	}

	@Override
	public void supersetPartying(Object blockPos, boolean p_191987_2_) {
	}

	@Override
	public boolean superprocessInitialInteract(Object entityPlayer, Object enumHand) {
		return false;
	}

	@Override
	public Object superapplyPlayerInteraction(Object entityPlayer, Object vec3d, Object enumHand) {
		return null;
	}

	@Override
	public Object supergetRecipeBook() {
		return null;
	}

	@Override
	public void superfunc_193103_a(Object iRecipe) {
	}

	@Override
	public void superOpenEditStructure(Object tileEntityStructure) {
	}

	@Override
	public boolean superisAutoJumpEnabled() {
		return false;
	}

	@Override
	public void superupdateAutoJump(float p_189810_1_, float p_189810_2_) {
	}

	@Override
	public void superdestroyVanishingCursedItems() {
	}

	@Override
	public void superdisableShield(boolean p_190777_1_) {
	}

	@Override
	public void superunlockRecipes(List p_192021_1_) {
	}

	@Override
	public void superunlockRecipes(Object[] resourceLocation) {
	}

	@Override
	public void superfunc_192022_b(List p_192022_1_) {
	}

	@Override
	public boolean superaddItemStackToInventory(Object itemStack) {
		return false;
	}

	@Override
	public boolean superaddShoulderEntity(Object nBTTagCompound) {
		return false;
	}

	@Override
	public void superspawnShoulderEntities() {
	}

	@Override
	public Object supergetLeftShoulderEntity() {
		return null;
	}

	@Override
	public void supersetLeftShoulderEntity(Object nBTTagCompound) {
	}

	@Override
	public Object supergetRightShoulderEntity() {
		return null;
	}

	@Override
	public void supersetRightShoulderEntity(Object nBTTagCompound) {
	}

	@Override
	public boolean supercanUseCommandBlock() {
		return false;
	}

	@Override
	public boolean superhasSpawnDimension() {
		return false;
	}

	@Override
	public int supergetSpawnDimension() {
		return -1;
	}

	@Override
	public void supersetSpawnDimension(Object integer) {
	}

	@Override
	public void superonInitialSpawn(Object object, Object object2) {
	}

}
