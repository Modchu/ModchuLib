package modchu.lib.characteristic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.nio.IntBuffer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import modchu.lib.Modchu_ASAlmighty;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.*;

import org.lwjgl.opengl.GL11;

import com.google.common.collect.Multimap;

public class Modchu_AS extends Modchu_ASAlmighty {

	public static void instanceCheck() {
		if (instance != null
				&& instance instanceof Modchu_AS) ;else instance = new Modchu_AS();
	}

	public Modchu_AS() {
		super();
		instance = this;
	}

	@Override
	protected Object abstractClientPlayerGetTextureCape(Object entity) {
		return ((AbstractClientPlayer) entity).getTextureCape();
	}

	@Override
	protected Object abstractClientPlayerGetTextureSkin(Object entity) {
		return ((AbstractClientPlayer) entity).getTextureSkin();
	}

	@Override
	protected Object axisAlignedBBExpand(Object axisAlignedBB, double d, double d1, double d2) {
		return ((AxisAlignedBB) axisAlignedBB).expand(d, d1, d2);
	}

	@Override
	protected Object axisAlignedBBGetBoundingBox(double d, double d1, double d2, double d3, double d4, double d5) {
		return AxisAlignedBB.getBoundingBox(d, d1, d2, d3, d4, d5);
	}

	@Override
	protected Object biomeGenBaseBeach() {
		return BiomeGenBase.beach;
	}

	@Override
	protected Object biomeGenBaseBirchForest() {
		return BiomeGenBase.forest;
	}

	@Override
	protected Object biomeGenBaseBirchForestHills() {
		return BiomeGenBase.forestHills;
	}

	@Override
	protected Object biomeGenBaseColdTaiga() {
		return BiomeGenBase.taiga;
	}

	@Override
	protected Object biomeGenBaseColdTaigaHills() {
		return BiomeGenBase.taigaHills;
	}

	@Override
	protected Object biomeGenBaseDeepOcean() {
		return BiomeGenBase.ocean;
	}

	@Override
	protected Object biomeGenBaseDesert() {
		return BiomeGenBase.desert;
	}

	@Override
	protected Object biomeGenBaseDesertHills() {
		return BiomeGenBase.desertHills;
	}

	@Override
	protected Object biomeGenBaseExtremeHills() {
		return BiomeGenBase.extremeHills;
	}

	@Override
	protected Object biomeGenBaseExtremeHillsEdge() {
		return BiomeGenBase.extremeHillsEdge;
	}

	@Override
	protected Object biomeGenBaseExtremeHillsPlus() {
		return BiomeGenBase.extremeHills;
	}

	@Override
	protected Object biomeGenBaseForest() {
		return BiomeGenBase.forest;
	}

	@Override
	protected Object biomeGenBaseForestHills() {
		return BiomeGenBase.forestHills;
	}

	@Override
	protected Object biomeGenBaseFrozenOcean() {
		return BiomeGenBase.frozenOcean;
	}

	@Override
	protected Object biomeGenBaseFrozenRiver() {
		return BiomeGenBase.frozenRiver;
	}

	@Override
	protected Object biomeGenBaseHell() {
		return BiomeGenBase.hell;
	}

	@Override
	protected Object biomeGenBaseIceMountains() {
		return BiomeGenBase.iceMountains;
	}

	@Override
	protected Object biomeGenBaseIcePlains() {
		return BiomeGenBase.icePlains;
	}

	@Override
	protected Object biomeGenBaseJungle() {
		return BiomeGenBase.jungle;
	}

	@Override
	protected Object biomeGenBaseJungleEdge() {
		return BiomeGenBase.jungle;
	}

	@Override
	protected Object biomeGenBaseJungleHills() {
		return BiomeGenBase.jungleHills;
	}

	@Override
	protected Object biomeGenBaseMegaTaiga() {
		return BiomeGenBase.taiga;
	}

	@Override
	protected Object biomeGenBaseMegaTaigaHills() {
		return BiomeGenBase.taigaHills;
	}

	@Override
	protected Object biomeGenBaseMesa() {
		return null;
	}

	@Override
	protected Object biomeGenBaseMesaPlateau() {
		return null;
	}

	@Override
	protected Object biomeGenBaseMesaPlateau_F() {
		return null;
	}

	@Override
	protected Object biomeGenBaseMushroomIsland() {
		return BiomeGenBase.mushroomIsland;
	}

	@Override
	protected Object biomeGenBaseMushroomIslandShore() {
		return BiomeGenBase.mushroomIslandShore;
	}

	@Override
	protected Object biomeGenBaseOcean() {
		return BiomeGenBase.ocean;
	}

	@Override
	protected Object biomeGenBasePlains() {
		return BiomeGenBase.plains;
	}

	@Override
	protected Object biomeGenBaseRiver() {
		return BiomeGenBase.river;
	}

	@Override
	protected Object biomeGenBaseRoofedForest() {
		return BiomeGenBase.forest;
	}

	@Override
	protected Object biomeGenBaseSavanna() {
		return null;
	}

	@Override
	protected Object biomeGenBaseSavannaPlateau() {
		return null;
	}

	@Override
	protected Object biomeGenBaseSky() {
		return BiomeGenBase.sky;
	}

	@Override
	protected Object biomeGenBaseStoneBeach() {
		return BiomeGenBase.beach;
	}

	@Override
	protected Object biomeGenBaseStoneColdBeach() {
		return BiomeGenBase.beach;
	}

	@Override
	protected Object biomeGenBaseSwampland() {
		return BiomeGenBase.swampland;
	}

	@Override
	protected Object biomeGenBaseTaiga() {
		return BiomeGenBase.taiga;
	}

	@Override
	protected Object biomeGenBaseTaigaHills() {
		return BiomeGenBase.taigaHills;
	}

	@Override
	protected Object[] blockBlockList() {
		return Block.blocksList;
	}

	@Override
	protected Object blockGetBlockFromItem(Object item) {
		if (item != null) ;else return null;
		int itemID = ((Item) item).itemID;
		return itemID < Block.blocksList.length ? Block.blocksList[itemID] : null;
	}

	@Override
	protected int blockGetRenderType(Object block) {
		return ((Block) block).getRenderType();
	}

	@Override
	protected Object creativeTabsTabAllSearch() {
		return CreativeTabs.tabAllSearch;
	}

	@Override
	protected Object creativeTabsTabBlock() {
		return CreativeTabs.tabBlock;
	}

	@Override
	protected Object creativeTabsTabBrewing() {
		return CreativeTabs.tabBrewing;
	}

	@Override
	protected Object creativeTabsTabCombat() {
		return CreativeTabs.tabCombat;
	}

	@Override
	protected Object creativeTabsTabDecorations() {
		return CreativeTabs.tabDecorations;
	}

	@Override
	protected Object creativeTabsTabFood() {
		return CreativeTabs.tabFood;
	}

	@Override
	protected Object creativeTabsTabInventory() {
		return CreativeTabs.tabInventory;
	}

	@Override
	protected Object creativeTabsTabMaterials() {
		return CreativeTabs.tabMaterials;
	}

	@Override
	protected Object creativeTabsTabMisc() {
		return CreativeTabs.tabMisc;
	}

	@Override
	protected Object creativeTabsTabRedstone() {
		return CreativeTabs.tabRedstone;
	}

	@Override
	protected Object creativeTabsTabTools() {
		return CreativeTabs.tabTools;
	}

	@Override
	protected Object creativeTabsTabTransport() {
		return CreativeTabs.tabTransport;
	}

	@Override
	protected Object damageSourceAnvil() {
		return DamageSource.anvil;
	}

	@Override
	protected Object damageSourceCactus() {
		return DamageSource.cactus;
	}

	@Override
	protected Object damageSourceCauseMobDamage(Object entityLivingBase) {
		return DamageSource.causeMobDamage((EntityLivingBase) entityLivingBase);
	}

	@Override
	protected Object damageSourceDrown() {
		return DamageSource.drown;
	}

	@Override
	protected Object damageSourceFall() {
		return DamageSource.fall;
	}

	@Override
	protected Object damageSourceFallingBlock() {
		return DamageSource.fallingBlock;
	}

	@Override
	protected Object damageSourceGeneric() {
		return DamageSource.generic;
	}

	@Override
	protected Object damageSourceGetEntity(Object damageSource) {
		return ((DamageSource) damageSource).getEntity();
	}

	@Override
	protected Object damageSourceInFire() {
		return DamageSource.inFire;
	}

	@Override
	protected Object damageSourceInWall() {
		return DamageSource.inWall;
	}

	@Override
	protected boolean damageSourceIsFireDamage(Object damageSource) {
		return ((DamageSource) damageSource).isFireDamage();
	}

	@Override
	protected Object damageSourceLava() {
		return DamageSource.lava;
	}

	@Override
	protected Object damageSourceMagic() {
		return DamageSource.magic;
	}

	@Override
	protected Object damageSourceOnFire() {
		return DamageSource.onFire;
	}

	@Override
	protected Object damageSourceOutOfWorld() {
		return DamageSource.outOfWorld;
	}

	@Override
	protected Object damageSourceStarve() {
		return DamageSource.starve;
	}

	@Override
	protected Object damageSourceWither() {
		return DamageSource.wither;
	}

	@Override
	protected void dataWatcherAddObject(Object dataWatcherOrEntity, int i, Object o) {
		((DataWatcher) entityGetDataWatcher(dataWatcherOrEntity)).addObject(i, o);
	}

	@Override
	protected byte dataWatcherGetWatchableObjectByte(Object dataWatcherOrEntity, int i) {
		return ((DataWatcher) entityGetDataWatcher(dataWatcherOrEntity)).getWatchableObjectByte(i);
	}

	@Override
	protected Object dataWatcherGetWatchableObjectItemStack(Object dataWatcherOrEntity, int i) {
		return ((DataWatcher) entityGetDataWatcher(dataWatcherOrEntity)).getWatchableObjectItemStack(i);
	}

	@Override
	protected void dataWatcherUpdateObject(Object dataWatcherOrEntity, int i, Object o) {
		DataWatcher dataWatcher = ((DataWatcher) entityGetDataWatcher(dataWatcherOrEntity));
		if (dataWatcherGetWatchedObject(dataWatcherOrEntity, i) != null) dataWatcher.updateObject(i, o);
		else dataWatcher.addObject(i, o);
	}

	@Override
	protected int entityAgeableGetGrowingAge(Object entityAgeable) {
		return ((EntityAgeable) entityAgeable).getGrowingAge();
	}

	@Override
	protected Object entityArrowShootingEntity(Object entityArrow) {
		return ((EntityArrow) entityArrow).shootingEntity;
	}

	@Override
	protected void entityAttackEntityFrom(Object entity, Object damageSource, float f) {
		((Entity) entity).attackEntityFrom((DamageSource) damageSource, f);
	}

	@Override
	protected Object entityBoundingBox(Object entity) {
		return ((Entity) entity).boundingBox;
	}

	@Override
	protected double entityBoundingBoxMaxX(Object entityOrBoundingBox) {
		AxisAlignedBB boundingBox = entityOrBoundingBox instanceof Entity ? ((Entity) entityOrBoundingBox).boundingBox : (AxisAlignedBB) entityOrBoundingBox;
		return boundingBox.maxX;
	}

	@Override
	protected double entityBoundingBoxMaxY(Object entityOrBoundingBox) {
		AxisAlignedBB boundingBox = entityOrBoundingBox instanceof Entity ? ((Entity) entityOrBoundingBox).boundingBox : (AxisAlignedBB) entityOrBoundingBox;
		return boundingBox.maxY;
	}

	@Override
	protected double entityBoundingBoxMaxZ(Object entityOrBoundingBox) {
		AxisAlignedBB boundingBox = entityOrBoundingBox instanceof Entity ? ((Entity) entityOrBoundingBox).boundingBox : (AxisAlignedBB) entityOrBoundingBox;
		return boundingBox.maxZ;
	}

	@Override
	protected double entityBoundingBoxMinX(Object entity) {
		return ((Entity) entity).boundingBox.minX;
	}

	@Override
	protected double entityBoundingBoxMinY(Object entity) {
		return ((Entity) entity).boundingBox.minY;
	}

	@Override
	protected double entityBoundingBoxMinZ(Object entity) {
		return ((Entity) entity).boundingBox.minZ;
	}

	@Override
	protected String entityCloakUrl(Object entity) {
		return null;
	}

	@Override
	protected Object entityCreatureGetEntityToAttack(Object entityCreature) {
		return ((EntityCreature) entityCreature).getEntityToAttack();
	}

	@Override
	protected void entityCreatureSetPathToEntity(Object entityCreature, Object entityPath) {
		((EntityCreature) entityCreature).setPathToEntity((PathEntity) entityPath);
	}

	@Override
	protected int entityDimension(Object entity) {
		return ((Entity) entity).dimension;
	}

	@Override
	protected float entityDistanceWalkedModified(Object entity) {
		return ((Entity) entity).distanceWalkedModified;
	}

	@Override
	protected int entityEntityID(Object entity) {
		return ((Entity) entity).entityId;
	}

	@Override
	protected float entityGetBrightness(Object entity, float f) {
		return ((Entity) entity).getBrightness(f);
	}

	@Override
	protected int entityGetBrightnessForRender(Object entity, float f) {
		return ((Entity) entity).getBrightnessForRender(f);
	}

	@Override
	protected float entityGetEyeHeight(Object entityplayer) {
		return ((EntityPlayer) entityplayer).getEyeHeight();
	}

	@Override
	protected float entityHeight(Object entity) {
		return ((Entity) entity).height;
	}

	@Override
	protected int entityHurtResistantTime(Object entity) {
		return ((Entity) entity).hurtResistantTime;
	}

	@Override
	protected boolean entityIsInvisible(Object entity) {
		return ((Entity) entity).isInvisible();
	}

	@Override
	protected boolean entityIsInWater(Object entity) {
		return ((Entity) entity).isInWater();
	}

	@Override
	protected boolean entityIsRiding(Object entity) {
		return ((Entity) entity).isRiding();
	}

	@Override
	protected boolean entityIsSneaking(Object entity) {
		return ((Entity) entity).isSneaking();
	}

	@Override
	protected boolean entityIsWet(Object entity) {
		return ((Entity) entity).isWet();
	}

	@Override
	protected float entityLivingBaseAttackedAtYaw(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).attackedAtYaw;
	}

	@Override
	protected int entityLivingBaseDeathTime(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).deathTime;
	}

	@Override
	protected Object entityLivingBaseGetAITarget(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).getAITarget();
	}

	@Override
	protected Object entityLivingBaseGetEquipmentInSlot(Object entityLivingBase, int i) {
		return ((EntityLivingBase) entityLivingBase).getCurrentItemOrArmor(i);
	}

	@Override
	protected float entityLivingBaseGetHealth(Object entity) {
		return ((EntityLivingBase) entity).getHealth();
	}

	@Override
	protected Object entityLivingBaseGetHeldItem(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).getHeldItem();
	}

	@Override
	protected float entityLivingBaseGetMaxHealth(Object entity) {
		return ((EntityLivingBase) entity).getMaxHealth();
	}

	@Override
	protected float entityLivingBaseGetSwingProgress(Object entity, float f) {
		return ((EntityLivingBase) entity).getSwingProgress(f);
	}

	@Override
	protected int entityLivingBaseHurtTime(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).hurtTime;
	}

	@Override
	protected boolean entityLivingBaseIsChild(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).isChild();
	}

	@Override
	protected boolean entityLivingBaseIsPotionActive(Object entityLivingBase, Object potionOrPotionId) {
		if (potionOrPotionId instanceof Potion) return ((EntityLivingBase) entityLivingBase).isPotionActive((Potion) potionOrPotionId);
		return ((EntityLivingBase) entityLivingBase).isPotionActive((Integer) potionOrPotionId);
	}

	@Override
	protected void entityLivingBaseKnockBack(Object entityLivingBase, Object entityLivingBase2, float f, double d, double d1) {
		((EntityLivingBase) entityLivingBase).knockBack((Entity) entityLivingBase2, f, d, d1);
	}

	@Override
	protected float entityLivingBaseLimbSwing(Object entity) {
		return ((EntityLivingBase) entity).limbSwing;
	}

	@Override
	protected float entityLivingBaseLimbSwingAmount(Object entity) {
		return ((EntityLivingBase) entity).limbSwingAmount;
	}

	@Override
	protected int entityLivingBaseMaxHurtResistantTime(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).maxHurtResistantTime;
	}

	@Override
	protected int entityLivingBaseMaxHurtTime(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).maxHurtTime;
	}

	@Override
	protected float entityLivingBaseMoveForward(Object entityplayer) {
		return ((EntityLivingBase) entityplayer).moveForward;
	}

	@Override
	protected float entityLivingBaseMoveStrafing(Object entityplayer) {
		return ((EntityLivingBase) entityplayer).moveStrafing;
	}

	@Override
	protected void entityLivingBaseOnDeath(Object entityLivingBase, Object damageSource) {
		((EntityLivingBase) entityLivingBase).onDeath((DamageSource) damageSource);
	}

	@Override
	protected float entityLivingBasePrevHealth(Object entityLivingBase) {
		return ((EntityLivingBase) entityLivingBase).prevHealth;
	}

	@Override
	protected float entityLivingBasePrevLimbSwingAmount(Object entity) {
		return ((EntityLivingBase) entity).prevLimbSwingAmount;
	}

	@Override
	protected float entityLivingBasePrevRenderYawOffset(Object entity) {
		return ((EntityLivingBase) entity).prevRenderYawOffset;
	}

	@Override
	protected float entityLivingBasePrevRotationYawHead(Object entity) {
		return ((EntityLivingBase) entity).prevRotationYawHead;
	}

	@Override
	protected float entityLivingBaseRenderYawOffset(Object entity) {
		return ((EntityLivingBase) entity).renderYawOffset;
	}

	@Override
	protected float entityLivingBaseRotationYawHead(Object entity) {
		return ((EntityLivingBase) entity).rotationYawHead;
	}

	@Override
	protected void entityLivingBaseSetHealth(Object entity, float f) {
		((EntityLivingBase) entity).setHealth(f);
	}

	@Override
	protected void entityLivingBaseSetRevengeTarget(Object entityLivingBase, Object entityLivingBase2) {
		((EntityLivingBase) entityLivingBase).setRevengeTarget((EntityLivingBase) entityLivingBase2);
	}

	@Override
	protected Object entityLivingGetNavigator(Object entityLivingOrPathNavigate) {
		return entityLivingOrPathNavigate instanceof Entity ? ((EntityLiving) entityLivingOrPathNavigate).getNavigator() : entityLivingOrPathNavigate;
	}

	@Override
	protected void entityLivingNavigatorClearPathEntity(Object entityLivingOrPathNavigate) {
		Object navigator = entityLivingGetNavigator(entityLivingOrPathNavigate);
		if (navigator != null) ((PathNavigate) navigator).clearPathEntity();
	}

	@Override
	protected double entityMotionX(Object entity) {
		return ((Entity) entity).motionX;
	}

	@Override
	protected double entityMotionY(Object entity) {
		return ((Entity) entity).motionY;
	}

	@Override
	protected double entityMotionZ(Object entity) {
		return ((Entity) entity).motionZ;
	}

	@Override
	protected void entityMountEntity(Object entity, Object entity2) {
		((Entity) entity).mountEntity((Entity) entity2);
	}

	@Override
	protected boolean entityOnGround(Object entity) {
		return ((Entity) entity).onGround;
	}

	@Override
	protected Object[] entityPlayerArmorInventory(Object entityplayerORInventory) {
		if (entityplayerORInventory instanceof InventoryPlayer) ;else {
			entityplayerORInventory = entityPlayerArmorInventory(entityplayerORInventory);
		}
		return ((InventoryPlayer) entityplayerORInventory).armorInventory;
	}

	@Override
	protected float entityPlayerCameraYaw(Object entityplayer) {
		return ((EntityPlayer) entityplayer).cameraYaw;
	}

	@Override
	protected float entityPlayerCurrentXP(Object entityplayer) {
		return ((EntityPlayer) entityplayer).experience;
	}

	@Override
	protected void entityPlayerSetItemInUse(Object entityplayer, Object itemstack, int i) {
		((EntityPlayer) entityplayer).setItemInUse((ItemStack) itemstack, i);
	}

	@Override
	protected void entityLivingBaseHeal(Object entityLivingBase, float f) {
		((EntityLivingBase) entityLivingBase).heal(f);
	}

	@Override
	protected double entityPlayerField_71085_bR(Object entityplayer) {
		return ((EntityPlayer) entityplayer).field_71085_bR;
	}

	@Override
	protected double entityPlayerField_71091_bM(Object entityplayer) {
		return ((EntityPlayer) entityplayer).field_71091_bM;
	}

	@Override
	protected double entityPlayerField_71094_bP(Object entityplayer) {
		return ((EntityPlayer) entityplayer).field_71094_bP;
	}

	@Override
	protected double entityPlayerField_71095_bQ(Object entityplayer) {
		return ((EntityPlayer) entityplayer).field_71095_bQ;
	}

	@Override
	protected double entityPlayerField_71096_bN(Object entityplayer) {
		return ((EntityPlayer) entityplayer).field_71096_bN;
	}

	@Override
	protected double entityPlayerField_71097_bO(Object entityplayer) {
		return ((EntityPlayer) entityplayer).field_71097_bO;
	}

	@Override
	protected Object entityplayerGetCurrentEquippedItem(Object entityplayer) {
		return ((EntityPlayer) entityplayer).getCurrentEquippedItem();
	}

	@Override
	protected Object entityPlayerGetFoodStats(Object entityplayer) {
		return ((EntityPlayer) entityplayer).getFoodStats();
	}

	@Override
	protected boolean entityPlayerGetHideCape(Object entityplayer) {
		return ((EntityPlayer) entityplayer).getHideCape();
	}

	@Override
	protected int entityPlayerGetItemInUseCount(Object entityplayer) {
		return ((EntityPlayer) entityplayer).getItemInUseCount();
	}

	@Override
	protected Object entityPlayerInventory(Object entityplayer) {
		return ((EntityPlayer) entityplayer).inventory;
	}

	@Override
	protected int entityPlayerInventoryCurrentItem(Object entityplayer) {
		return ((InventoryPlayer) entityPlayerInventory(entityplayer)).currentItem;
	}

	@Override
	protected Object entityPlayerInventoryGetCurrentItem(Object entityplayer) {
		return ((EntityPlayer) entityplayer).inventory.getCurrentItem();
	}

	@Override
	protected Object entityPlayerInventoryGetStackInSlot(Object entityplayer, int i) {
		return ((EntityPlayer) entityplayer).inventory.getStackInSlot(i);
	}

	@Override
	protected Object entityPlayerInventoryPlayerArmorItemInSlot(Object entityplayerORInventory, int i) {
		if (entityplayerORInventory instanceof InventoryPlayer) ;else {
			entityplayerORInventory = entityPlayerInventory(entityplayerORInventory);
		}
		return ((InventoryPlayer) entityplayerORInventory).armorItemInSlot(i);
	}

	@Override
	protected void entityPlayerInventorySetInventorySlotContents(Object entityplayer, int i, Object itemstack) {
		((InventoryPlayer) entityPlayerInventory(entityplayer)).setInventorySlotContents(i, (ItemStack) itemstack);
	}

	@Override
	protected boolean entityPlayerIsPlayerSleeping(Object entityplayer) {
		return ((EntityPlayer) entityplayer).isPlayerSleeping();
	}

	@Override
	protected Object[] entityPlayerMainInventory(Object entityplayerORInventory) {
		if (entityplayerORInventory instanceof InventoryPlayer) ;else {
			entityplayerORInventory = entityPlayerInventory(entityplayerORInventory);
		}
		return ((InventoryPlayer) entityplayerORInventory).mainInventory;
	}

	@Override
	protected int entityPlayerPlayerLevel(Object entityplayer) {
		return ((EntityPlayer) entityplayer).experienceLevel;
	}

	@Override
	protected float entityPlayerPrevCameraYaw(Object entityplayer) {
		return ((EntityPlayer) entityplayer).prevCameraYaw;
	}

	@Override
	protected int entityPlayerScore(Object entityplayer) {
		return ((EntityPlayer) entityplayer).getScore();
	}

	@Override
	protected void entityPlayerSPFunc_6420_o(Object entityplayer) {
	}

	@Override
	protected int entityPlayerTotalXP(Object entityplayer) {
		return ((EntityPlayer) entityplayer).experienceTotal;
	}

	@Override
	protected void entityPlaySound(Object entity, String s, float f1, float f2) {
		((Entity) entity).playSound(s, f1, f2);
	}

	@Override
	protected double entityPosX(Object entity) {
		return ((Entity) entity).posX;
	}

	@Override
	protected double entityPosY(Object entity) {
		return ((Entity) entity).posY;
	}

	@Override
	protected double entityPosZ(Object entity) {
		return ((Entity) entity).posZ;
	}

	@Override
	protected float entityPrevDistanceWalkedModified(Object entity) {
		return ((Entity) entity).prevDistanceWalkedModified;
	}

	@Override
	protected double entityPrevPosX(Object entity) {
		return ((Entity) entity).prevPosX;
	}

	@Override
	protected double entityPrevPosY(Object entity) {
		return ((Entity) entity).prevPosY;
	}

	@Override
	protected double entityPrevPosZ(Object entity) {
		return ((Entity) entity).prevPosZ;
	}

	@Override
	protected float entityPrevRotationPitch(Object entity) {
		return ((EntityLivingBase) entity).prevRotationPitch;
	}

	@Override
	protected float entityPrevRotationYaw(Object entity) {
		return ((EntityLivingBase) entity).prevRotationYaw;
	}

	@Override
	protected Object entityRiddenByEntity(Object entity) {
		return ((Entity) entity).riddenByEntity;
	}

	@Override
	protected Object entityRidingEntity(Object entity) {
		return ((Entity) entity).ridingEntity;
	}

	@Override
	protected float entityRotationPitch(Object entity) {
		return ((Entity) entity).rotationPitch;
	}

	@Override
	protected float entityRotationYaw(Object entity) {
		return ((Entity) entity).rotationYaw;
	}

	@Override
	protected void entitySetDead(Object entity) {
		((Entity) entity).setDead();
	}

	@Override
	protected void entitySetFire(Object entity, int i) {
		((Entity) entity).setFire(i);
	}

	@Override
	protected void entitySetPosition(Object entity, double x, double y, double z) {
		((Entity) entity).setPosition(x, y, z);
	}

	@Override
	protected String entityTameableGetOwnerName(Object entityTameable) {
		return ((EntityTameable) entityTameable).getOwnerName();
	}

	@Override
	protected int entityTicksExisted(Object entity) {
		return ((Entity) entity).ticksExisted;
	}

	@Override
	protected float entityWidth(Object entity) {
		return ((Entity) entity).width;
	}

	@Override
	protected Object entityWorldObj(Object worldOrEntity) {
		return worldOrEntity instanceof World ? worldOrEntity : worldOrEntity instanceof Entity ? ((Entity) worldOrEntity).worldObj : null;
	}

	@Override
	protected float entityYOffset(Object entity) {
		return ((Entity) entity).yOffset;
	}

	@Override
	protected Enum enumActionBlock() {
		return EnumAction.block;
	}

	@Override
	protected Enum enumActionBow() {
		return EnumAction.bow;
	}

	@Override
	protected Enum enumActionDrink() {
		return EnumAction.drink;
	}

	@Override
	protected Enum enumActionEat() {
		return EnumAction.eat;
	}

	@Override
	protected Enum enumActionNone() {
		return EnumAction.none;
	}

	@Override
	protected Enum enumCreatureAttributeARTHROPOD() {
		return EnumCreatureAttribute.ARTHROPOD;
	}

	@Override
	protected Enum enumCreatureAttributeUNDEAD() {
		return EnumCreatureAttribute.UNDEAD;
	}

	@Override
	protected Enum enumCreatureAttributeUNDEFINED() {
		return EnumCreatureAttribute.UNDEFINED;
	}

	@Override
	protected Enum enumCreatureTypeAmbient() {
		return EnumCreatureType.ambient;
	}

	@Override
	protected Enum enumCreatureTypeCreature() {
		return EnumCreatureType.creature;
	}

	@Override
	protected Enum enumCreatureTypeMonster() {
		return EnumCreatureType.monster;
	}

	@Override
	protected Enum enumCreatureTypeWaterCreature() {
		return EnumCreatureType.waterCreature;
	}

	@Override
	protected void fontRendererDrawString(Object fontRenderer, String s, int i, int j, int k) {
		((FontRenderer) fontRenderer).drawString(s, i, j, k);
	}

	@Override
	protected String gameSettingsGetKeyDisplayString(int i) {
		return GameSettings.getKeyDisplayString(i);
	}

	@Override
	protected Object gameSettingsKeyBindBack() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().gameSettings.keyBindBack;
	}

	@Override
	protected Object gameSettingsKeyBindForward() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().gameSettings.keyBindForward;
	}

	@Override
	protected Object gameSettingsKeyBindLeft() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().gameSettings.keyBindLeft;
	}

	@Override
	protected Object gameSettingsKeyBindRight() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().gameSettings.keyBindRight;
	}

	@Override
	protected Object getBlockItemStack(Object itemstack) {
		if (itemstack != null) ;else return null;
		return blockGetBlockFromItem(itemStackGetItem(itemstack));
	}

	@Override
	protected Object getItem(String s) {
		if (s != null) ;else return null;
		if (!initOldVersionItemMap) {
			oldVersionItemMap = new ConcurrentHashMap();
			String[] s1 = new String[]{
					"iron_shovel",
					"iron_pickaxe",
					"iron_axe",
					"flint_and_steel",
					"apple",
					"bow",
					"arrow",
					"coal",
					"diamond",
					"iron_ingot",
					"gold_ingot",
					"iron_sword",
					"wooden_sword",
					"wooden_shovel",
					"wooden_pickaxe",
					"wooden_axe",
					"stone_sword",
					"stone_shovel",
					"stone_pickaxe",
					"stone_axe",
					"diamond_sword",
					"diamond_shovel",
					"diamond_pickaxe",
					"diamond_axe",
					"stick",
					"bowl",
					"mushroom_stew",
					"golden_sword",
					"golden_shovel",
					"golden_pickaxe",
					"golden_axe",
					"string",
					"feather",
					"gunpowder",
					"wooden_hoe",
					"stone_hoe",
					"iron_hoe",
					"diamond_hoe",
					"golden_hoe",
					"wheat_seeds",
					"wheat",
					"bread",
					"leather_helmet",
					"leather_chestplate",
					"leather_leggings",
					"leather_boots",
					"chainmail_helmet",
					"chainmail_chestplate",
					"chainmail_leggings",
					"chainmail_boots",
					"iron_helmet",
					"iron_chestplate",
					"iron_leggings",
					"iron_boots",
					"diamond_helmet",
					"diamond_chestplate",
					"diamond_leggings",
					"diamond_boots",
					"golden_helmet",
					"golden_chestplate",
					"golden_leggings",
					"golden_boots",
					"flint",
					"porkchop",
					"cooked_porkchop",
					"painting",
					"golden_apple",
					"sign",
					"wooden_door",
					"bucket",
					"water_bucket",
					"lava_bucket",
					"minecart",
					"saddle",
					"iron_door",
					"redstone",
					"snowball",
					"boat",
					"leather",
					"milk_bucket",
					"brick",
					"clay_ball",
					"reeds",
					"paper",
					"book",
					"slime_ball",
					"chest_minecart",
					"furnace_minecart",
					"egg",
					"compass",
					"fishing_rod",
					"clock",
					"glowstone_dust",
					"fish",
					"cooked_fished",
					"dye",
					"bone",
					"sugar",
					"cake",
					"bed",
					"repeater",
					"cookie",
					"filled_map",
					"shears",
					"melon",
					"pumpkin_seeds",
					"melon_seeds",
					"beef",
					"cooked_beef",
					"chicken",
					"cooked_chicken",
					"rotten_flesh",
					"ender_pearl",
					"blaze_rod",
					"ghast_tear",
					"gold_nugget",
					"nether_wart",
					"potionitem",
					"glass_bottle",
					"spider_eye",
					"fermented_spider_eye",
					"blaze_powder",
					"magma_cream",
					"brewing_stand",
					"cauldron",
					"ender_eye",
					"speckled_melon",
					"spawn_egg",
					"experience_bottle",
					"fire_charge",
					"writable_book",
					"written_book",
					"emerald",
					"item_frame",
					"flower_pot",
					"carrot",
					"potato",
					"baked_potato",
					"poisonous_potato",
					"map",
					"golden_carrot",
					"skull",
					"carrot_on_a_stick",
					"nether_star",
					"pumpkin_pie",
					"fireworks",
					"firework_charge",
					"enchanted_book",
					"comparator",
					"netherbrick",
					"quartz",
					"tnt_minecart",
					"hopper_minecart",
					"iron_horse_armor",
					"golden_horse_armor",
					"diamond_horse_armor",
					"lead",
					"name_tag",
					"record_13",
					"record_cat",
					"record_blocks",
					"record_chirp",
					"record_far",
					"record_mall",
					"record_mellohi",
					"record_stal",
					"record_strad",
					"record_ward",
					"record_11",
					"record_wait",
			};
			Object[] s2 = new Object[]{
					Item.shovelIron,
					Item.pickaxeIron,
					Item.axeIron,
					Item.flintAndSteel,
					Item.appleRed,
					Item.bow,
					Item.arrow,
					Item.coal,
					Item.diamond,
					Item.ingotIron,
					Item.ingotGold,
					Item.swordIron,
					Item.swordWood,
					Item.shovelWood,
					Item.pickaxeWood,
					Item.axeWood,
					Item.swordStone,
					Item.shovelStone,
					Item.pickaxeStone,
					Item.axeStone,
					Item.swordDiamond,
					Item.shovelDiamond,
					Item.pickaxeDiamond,
					Item.axeDiamond,
					Item.stick,
					Item.bowlEmpty,
					Item.bowlSoup,
					Item.swordGold,
					Item.shovelGold,
					Item.pickaxeGold,
					Item.axeGold,
					Item.silk,
					Item.feather,
					Item.gunpowder,
					Item.hoeWood,
					Item.hoeStone,
					Item.hoeIron,
					Item.hoeDiamond,
					Item.hoeGold,
					Item.seeds,
					Item.wheat,
					Item.bread,
					Item.helmetLeather,
					Item.plateLeather,
					Item.legsLeather,
					Item.bootsLeather,
					Item.helmetChain,
					Item.plateChain,
					Item.legsChain,
					Item.bootsChain,
					Item.helmetIron,
					Item.plateIron,
					Item.legsIron,
					Item.bootsIron,
					Item.helmetDiamond,
					Item.plateDiamond,
					Item.legsDiamond,
					Item.bootsDiamond,
					Item.helmetGold,
					Item.plateGold,
					Item.legsGold,
					Item.bootsGold,
					Item.flint,
					Item.porkRaw,
					Item.porkCooked,
					Item.painting,
					Item.appleGold,
					Item.sign,
					Item.doorWood,
					Item.bucketEmpty,
					Item.bucketWater,
					Item.bucketLava,
					Item.minecartEmpty,
					Item.saddle,
					Item.doorIron,
					Item.redstone,
					Item.snowball,
					Item.boat,
					Item.leather,
					Item.bucketMilk,
					Item.brick,
					Item.clay,
					Item.reed,
					Item.paper,
					Item.book,
					Item.slimeBall,
					Item.minecartCrate,
					Item.minecartPowered,
					Item.egg,
					Item.compass,
					Item.fishingRod,
					Item.pocketSundial,
					Item.glowstone,
					Item.fishRaw,
					Item.fishCooked,
					Item.dyePowder,
					Item.bone,
					Item.sugar,
					Item.cake,
					Item.bed,
					Item.redstoneRepeater,
					Item.cookie,
					Item.map,
					Item.shears,
					Item.melon,
					Item.pumpkinSeeds,
					Item.melonSeeds,
					Item.beefRaw,
					Item.beefCooked,
					Item.chickenRaw,
					Item.chickenCooked,
					Item.rottenFlesh,
					Item.enderPearl,
					Item.blazeRod,
					Item.ghastTear,
					Item.goldNugget,
					Item.netherStalkSeeds,
					Item.potion,
					Item.glassBottle,
					Item.spiderEye,
					Item.fermentedSpiderEye,
					Item.blazePowder,
					Item.magmaCream,
					Item.brewingStand,
					Item.cauldron,
					Item.eyeOfEnder,
					Item.speckledMelon,
					Item.monsterPlacer,
					Item.expBottle,
					Item.fireballCharge,
					Item.writableBook,
					Item.writtenBook,
					Item.emerald,
					Item.itemFrame,
					Item.flowerPot,
					Item.carrot,
					Item.potato,
					Item.bakedPotato,
					Item.poisonousPotato,
					Item.map,
					Item.goldenCarrot,
					Item.skull,
					Item.carrotOnAStick,
					Item.netherStar,
					Item.pumpkinPie,
					Item.firework,
					Item.fireworkCharge,
					Item.enchantedBook,
					Item.comparator,
					Item.netherrackBrick,
					Item.netherQuartz,
					Item.minecartTnt,
					Item.minecartHopper,
					Item.horseArmorIron,
					Item.horseArmorGold,
					Item.horseArmorDiamond,
					Item.leash,
					Item.nameTag,
					Item.record13,
					Item.recordCat,
					Item.recordBlocks,
					Item.recordChirp,
					Item.recordFar,
					Item.recordMall,
					Item.recordMellohi,
					Item.recordStal,
					Item.recordStrad,
					Item.recordWard,
					Item.record11,
					Item.recordWait,
			};
			for(int i = 0; i < s1.length
					&& i < s2.length; i++) {
				if (s1[i] != null
						&& s2[i] != null) oldVersionItemMap.put(s1[i], s2[i]);
			}
			initOldVersionItemMap = true;
		}
		if (!oldVersionItemMap.containsKey(s)) {
			Modchu_Main.setRuntimeException("oldVersionItemMap s="+s+" is null !!");
			return null;
		}
		return oldVersionItemMap.get(s);
	}

	@Override
	protected Object getBlock(String s) {
		if (s != null) ;else return null;
		if (!initOldVersionBlockMap) {
			oldVersionBlockMap = new ConcurrentHashMap();
			String[] s1 = new String[]{
					"air",
					"stone",
					"grass",
					"dirt",
					"cobblestone",
					"planks",
					"sapling",
					"bedrock",
					"flowing_water",
					"water",
					"flowing_lava",
					"lava",
					"sand",
					"gravel",
					"gold_ore",
					"iron_ore",
					"coal_ore",
					"log",
					"log2",
					"leaves",
					"leaves2",
					"sponge",
					"glass",
					"lapis_ore",
					"lapis_block",
					"dispenser",
					"sandstone",
					"noteblock",
					"bed",
					"golden_rail",
					"detector_rail",
					"sticky_piston",
					"web",
					"tallgrass",
					"deadbush",
					"piston",
					"piston_head",
					"wool",
					"piston_extension",
					"yellow_flower",
					"red_flower",
					"brown_mushroom",
					"red_mushroom",
					"gold_block",
					"iron_block",
					"double_stone_slab",
					"stone_slab",
					"brick_block",
					"tnt",
					"bookshelf",
					"mossy_cobblestone",
					"obsidian",
					"torch",
					"fire",
					"mob_spawner",
					"oak_stairs",
					"chest",
					"redstone_wire",
					"diamond_ore",
					"diamond_block",
					"crafting_table",
					"wheat",
					"farmland",
					"furnace",
					"lit_furnace",
					"standing_sign",
					"wooden_door",
					"ladder",
					"rail",
					"stone_stairs",
					"wall_sign",
					"lever",
					"stone_pressure_plate",
					"iron_door",
					"wooden_pressure_plate",
					"redstone_ore",
					"lit_redstone_ore",
					"unlit_redstone_torch",
					"redstone_torch",
					"stone_button",
					"snow_layer",
					"ice",
					"snow",
					"cactus",
					"clay",
					"reeds",
					"jukebox",
					"fence",
					"pumpkin",
					"netherrack",
					"soul_sand",
					"glowstone",
					"portal",
					"lit_pumpkin",
					"cake",
					"unpowered_repeater",
					"powered_repeater",
					"trapdoor",
					"monster_egg",
					"stonebrick",
					"brown_mushroom_block",
					"red_mushroom_block",
					"iron_bars",
					"glass_pane",
					"melon_block",
					"pumpkin_stem",
					"melon_stem",
					"vine",
					"fence_gate",
					"brick_stairs",
					"stone_brick_stairs",
					"mycelium",
					"waterlily",
					"nether_brick",
					"nether_brick_fence",
					"nether_brick_stairs",
					"nether_wart",
					"enchanting_table",
					"brewing_stand",
					"cauldron",
					"end_portal",
					"end_portal_frame",
					"end_stone",
					"dragon_egg",
					"redstone_lamp",
					"lit_redstone_lamp",
					"double_wooden_slab",
					"wooden_slab",
					"cocoa",
					"sandstone_stairs",
					"emerald_ore",
					"ender_chest",
					"tripwire_hook",
					"tripwire",
					"emerald_block",
					"spruce_stairs",
					"birch_stairs",
					"jungle_stairs",
					"command_block",
					"beacon",
					"cobblestone_wall",
					"flower_pot",
					"carrots",
					"potatoes",
					"wooden_button",
					"skull",
					"anvil",
					"trapped_chest",
					"light_weighted_pressure_plate",
					"heavy_weighted_pressure_plate",
					"unpowered_comparator",
					"powered_comparator",
					"daylight_detector",
					"redstone_block",
					"quartz_ore",
					"hopper",
					"quartz_block",
					"quartz_stairs",
					"activator_rail",
					"dropper",
					"stained_hardened_clay",
					"hay_block",
					"carpet",
					"hardened_clay",
					"coal_block",
					"packed_ice",
					"acacia_stairs",
					"dark_oak_stairs",
					"double_plant",
					"stained_glass",
					"stained_glass_pane"
			};
			Object[] s2 = new Object[]{
					Block.blocksList[0],
					Block.stone,
					Block.grass,
					Block.dirt,
					Block.cobblestone,
					Block.planks,
					Block.sapling,
					Block.bedrock,
					Block.waterMoving,
					Block.waterStill,
					Block.lavaMoving,
					Block.lavaStill,
					Block.sand,
					Block.gravel,
					Block.oreGold,
					Block.oreIron,
					Block.oreCoal,
					Block.wood,
					null,//Block.log2,
					Block.leaves,
					null,//Block.leaves2,
					Block.sponge,
					Block.glass,
					Block.oreLapis,
					Block.blockLapis,
					Block.dispenser,
					Block.sandStone,
					Block.music,
					Block.bed,
					Block.railPowered,
					Block.railDetector,
					Block.pistonStickyBase,
					Block.web,
					Block.tallGrass,
					Block.deadBush,
					Block.pistonBase,
					Block.pistonExtension,
					Block.cloth,
					Block.pistonMoving,
					Block.plantYellow,
					Block.plantRed,
					Block.mushroomBrown,
					Block.mushroomRed,
					Block.blockGold,
					Block.blockIron,
					Block.stoneDoubleSlab,
					Block.stoneSingleSlab,
					Block.brick,
					Block.tnt,
					Block.bookShelf,
					Block.cobblestoneMossy,
					Block.obsidian,
					Block.torchWood,
					Block.fire,
					Block.mobSpawner,
					Block.stairsWoodOak,
					Block.chest,
					Block.redstoneWire,
					Block.oreDiamond,
					Block.blockDiamond,
					Block.workbench,
					Block.crops,
					Block.tilledField,
					Block.furnaceIdle,
					Block.furnaceBurning,
					Block.signPost,
					Block.doorWood,
					Block.ladder,
					Block.rail,
					Block.stairsCobblestone,
					Block.signWall,
					Block.lever,
					Block.pressurePlateStone,
					Block.doorIron,
					Block.pressurePlatePlanks,
					Block.oreRedstone,
					Block.oreRedstoneGlowing,
					Block.torchRedstoneIdle,
					Block.torchRedstoneActive,
					Block.stoneButton,
					Block.blockSnow,
					Block.ice,
					Block.snow,
					Block.cactus,
					Block.blockClay,
					Block.reed,
					Block.jukebox,
					Block.fence,
					Block.pumpkin,
					Block.netherrack,
					Block.slowSand,
					Block.glowStone,
					Block.portal,
					Block.pumpkinLantern,
					Block.cake,
					Block.redstoneRepeaterIdle,
					Block.redstoneRepeaterActive,
					Block.trapdoor,
					null,//Block.monster_egg,
					Block.stoneBrick,
					Block.mushroomCapBrown,
					Block.mushroomCapRed,
					Block.fenceIron,
					Block.thinGlass,
					Block.melon,
					Block.pumpkinStem,
					Block.melonStem,
					Block.vine,
					Block.fenceGate,
					Block.stairsBrick,
					Block.stairsStoneBrick,
					Block.mycelium,
					Block.waterlily,
					Block.netherBrick,
					Block.netherFence,
					Block.stairsNetherBrick,
					Block.netherStalk,
					Block.enchantmentTable,
					Block.brewingStand,
					Block.cauldron,
					Block.endPortal,
					Block.endPortalFrame,
					Block.whiteStone,
					Block.dragonEgg,
					Block.redstoneLampIdle,
					Block.redstoneLampActive,
					Block.woodDoubleSlab,
					Block.woodSingleSlab,
					Block.cocoaPlant,
					Block.stairsSandStone,
					Block.oreEmerald,
					Block.enderChest,
					Block.tripWireSource,
					Block.tripWire,
					Block.blockEmerald,
					Block.stairsWoodSpruce,
					Block.stairsWoodBirch,
					Block.stairsWoodJungle,
					Block.commandBlock,
					Block.beacon,
					Block.cobblestoneWall,
					Block.flowerPot,
					Block.carrot,
					Block.potato,
					Block.woodenButton,
					Block.skull,
					Block.anvil,
					Block.chestTrapped,
					Block.pressurePlateGold,
					Block.redstoneComparatorIdle,
					Block.redstoneComparatorIdle,
					Block.redstoneComparatorActive,
					Block.daylightSensor,
					Block.blockRedstone,
					Block.oreNetherQuartz,
					Block.hopperBlock,
					Block.blockNetherQuartz,
					Block.stairsNetherQuartz,
					Block.railActivator,
					Block.dropper,
					Block.stainedClay,
					Block.hay,
					Block.carpet,
					Block.hardenedClay,
					Block.coalBlock,
					null,//Block.packed_ice,
					null,//Block.acacia_stairs,
					null,//Block.dark_oak_stairs,
					null,//Block.double_plant,
					null,//Block.stained_glass,
					null//Block.stained_glass_pane,
			};
			for(int i = 0; i < s1.length
					&& i < s2.length; i++) {
				if (s1[i] != null
						&& s2[i] != null) oldVersionBlockMap.put(s1[i], s2[i]);
			}
			initOldVersionBlockMap = true;
		}
		if (!oldVersionBlockMap.containsKey(s)) {
			Modchu_Main.setRuntimeException("oldVersionBlockMap s="+s+" is null !!");
			return null;
		}
		return oldVersionBlockMap.get(s);
	}

	@Override
	protected Object getResource(String s) {
		return getResource(Minecraft.class, s);
	}

	@Override
	protected String getUserName(Object entityplayer) {
		return entityplayer instanceof EntityPlayer ? ((EntityPlayer) entityplayer).getCommandSenderName() : null;
	}

	@Override
	protected IntBuffer gLAllocationCreateDirectIntBuffer(int i) {
		return GLAllocation.createDirectIntBuffer(i);
	}

	@Override
	protected int gLAllocationGenerateDisplayLists(int i) {
		return GLAllocation.generateDisplayLists(i);
	}

	@Override
	protected boolean guiButtonEnabled(Object guiButton) {
		return ((GuiButton) guiButton).enabled;
	}

	@Override
	protected int guiButtonID(Object guiButton) {
		return ((GuiButton) guiButton).id;
	}

	@Override
	protected boolean guiButtonVisible(Object guiButton) {
		return ((GuiButton) guiButton).drawButton;
	}

	@Override
	protected int guiButtonXPosition(Object guiButton) {
		return ((GuiButton) guiButton).xPosition;
	}

	@Override
	protected int guiButtonYPosition(Object guiButton) {
		return ((GuiButton) guiButton).yPosition;
	}

	@Override
	protected void guiDrawCenteredString(Object gui, Object fontRenderer, String s, int i, int i2, int i3) {
		((Gui) gui).drawCenteredString((FontRenderer) fontRenderer, s, i, i2, i3);
	}

	@Override
	protected void guiIngameDrawString(String s, int i, int j, int k) {
		if (Modchu_Main.isServer) return;
		Minecraft mc = Minecraft.getMinecraft();
		mc.ingameGUI.drawString(mc.fontRenderer, s, i, j, k);
	}

	@Override
	protected Object guiOptionsBackground() {
		return Gui.optionsBackground;
	}

	@Override
	protected void guiScreenDrawScreen(Object guiScreen, int i, int i2, float f) {
		((GuiScreen) guiScreen).drawScreen(i, i2, f);
	}

	@Override
	protected int guiScreenHeight(Object guiScreen) {
		return ((GuiScreen) guiScreen).height;
	}

	@Override
	protected int guiScreenWidth(Object guiScreen) {
		return ((GuiScreen) guiScreen).width;
	}

	@Override
	protected void guiSlotActionPerformed(Object guiSlot, Object guiButton) {
		((GuiSlot) guiSlot).actionPerformed((GuiButton) guiButton);
	}

	@Override
	protected void guiSlotDrawScreen(Object guiSlot, int i, int i2, float f) {
		((GuiSlot) guiSlot).drawScreen(i, i2, f);
	}

	@Override
	protected void guiSlotRegisterScrollButtons(Object guiSlot, List list, int i, int i2) {
		((GuiSlot) guiSlot).registerScrollButtons(i, i2);
	}

	@Override
	protected Object inventoryPlayerArmorItemInSlot(Object inventory, int i) {
		return ((InventoryPlayer) inventory).armorItemInSlot(i);
	}

	@Override
	protected Object inventoryPlayerGetStackInSlot(Object inventory, int i) {
		return ((InventoryPlayer) inventory).getStackInSlot(i);
	}

	@Override
	protected boolean isCamouflageCheck(Object block) {
		return block instanceof BlockLeaves;
	}

	@Override
	protected boolean isIntegratedServerRunning() {
		return !Modchu_Main.isServer ? Minecraft.getMinecraft().isIntegratedServerRunning() : false;
	}

	@Override
	protected boolean isLANWorld() {
		if (Modchu_Main.isServer) return false;
		if (!isMuiti()) {
			Object theIntegratedServer = Modchu_Reflect.getFieldObject("Minecraft", "field_71437_Z", "theIntegratedServer", minecraftGetMinecraft());
			if (theIntegratedServer != null
					&& (Boolean) Modchu_Reflect.invokeMethod(theIntegratedServer.getClass(), "func_71344_c", "getPublic", theIntegratedServer)) {
				return true;
			}
		}
		return false;
	}

	@Override
	protected boolean isMac() {
		return Minecraft.isRunningOnMac;
	}

	@Override
	protected boolean isMuiti() {
		if (Modchu_Main.isServer) return true;
		return !Modchu_Main.isServer ? Minecraft.getMinecraft().getNetHandler() != null
				&& !Minecraft.getMinecraft().isSingleplayer() : true;
	}

	@Override
	protected boolean isPlanterCheck(Object itemStackOrBlockOrItem) {
		itemStackOrBlockOrItem = itemStackOrBlockOrItem instanceof ItemStack ? getBlock(itemStackOrBlockOrItem) : itemStackOrBlockOrItem;
		return itemStackOrBlockOrItem instanceof BlockFlower
				| itemStackOrBlockOrItem instanceof BlockMushroom
				| itemStackOrBlockOrItem instanceof BlockSapling
				| itemStackOrBlockOrItem instanceof BlockTallGrass;
	}

	@Override
	protected boolean isSkull(Object itemStackOrItem) {
		int version = Modchu_Main.getMinecraftVersion();
		Object item = itemStackOrItem;
		if (Modchu_Reflect.loadClass("ItemStack").isInstance(itemStackOrItem)) {
			item = itemStackGetItem(itemStackOrItem);
		}
		return getItem("skull").getClass().isInstance(item);
	}

	@Override
	protected int itemArmorRenderIndex(Object itemArmor) {
		return ((ItemArmor) itemArmor).renderIndex;
	}

	@Override
	protected boolean itemIsFull3D(Object item) {
		return ((Item) item).isFull3D();
	}

	@Override
	protected int itemItemID(Object item) {
		return -1;
	}

	@Override
	protected boolean itemItemInteractionForEntity(Object item, Object itemstack, Object entityplayer, Object entityLivingBase) {
		return ((Item) item).itemInteractionForEntity((ItemStack) itemstack, (EntityPlayer) entityplayer, (EntityLivingBase) entityLivingBase);
	}

	@Override
	protected Object[] itemItemsList() {
		return Item.itemsList;
	}

	@Override
	protected Object itemSetCreativeTab(Object item, Object creativeTabs) {
		return ((Item) item).setCreativeTab((CreativeTabs) creativeTabs);
	}

	@Override
	protected Object itemSetUnlocalizedName(Object item, String s) {
		return ((Item) item).setUnlocalizedName(s);
	}

	@Override
	protected Object itemStackCopyItemStack(Object itemstack) {
		return ItemStack.copyItemStack((ItemStack) itemstack);
	}

	@Override
	protected void itemStackDamageItem(Object itemstack, int i, Object entityLivingBase) {
		((ItemStack) itemstack).damageItem(i, (EntityLivingBase) entityLivingBase);
	}

	@Override
	protected Object itemStackGetItem(Object itemstack) {
		return ((ItemStack) itemstack).getItem();
	}

	@Override
	protected int itemStackGetItemDamage(Object itemstack) {
		return ((ItemStack) itemstack).getItemDamage();
	}

	@Override
	protected Object itemStackGetItemUseAction(Object itemstack) {
		return ((ItemStack) itemstack).getItemUseAction();
	}

	@Override
	protected boolean itemStackIsItemEnchanted(Object itemstack) {
		return ((ItemStack) itemstack).isItemEnchanted();
	}

	@Override
	protected int itemStackItemID(Object itemstack) {
		return -1;
	}

	@Override
	protected int itemStackStackSize(Object itemstack) {
		return ((ItemStack) itemstack).stackSize;
	}

	@Override
	protected boolean keyBindingGetIsKeyPressed(Object keyBinding) {
		return keyBinding != null ? ((KeyBinding) keyBinding).pressed : null;
	}

	@Override
	protected boolean keyBindingIsPressed(Object keyBinding) {
		return keyBinding != null ? ((KeyBinding) keyBinding).isPressed() : null;
	}

	@Override
	protected String keyBindingKeyCategory(Object keyBinding) {
		return null;
	}

	@Override
	protected int keyBindingKeyCode(Object keyBinding) {
		return keyBinding != null ? ((KeyBinding) keyBinding).keyCode : -1;
	}

	@Override
	protected String keyBindingKeyDescription(Object keyBinding) {
		return keyBinding != null ? ((KeyBinding) keyBinding).keyDescription : null;
	}

	@Override
	protected float mathHelperCos(float f) {
		return MathHelper.cos(f);
	}

	@Override
	protected double mathHelperFloor_double(double d) {
		return MathHelper.floor_double(d);
	}

	@Override
	protected float mathHelperSin(float f) {
		return MathHelper.sin(f);
	}

	@Override
	protected float mathHelperSqrt_float(float f) {
		return MathHelper.sqrt_float(f);
	}

	@Override
	protected Object minecraftCurrentScreen() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().currentScreen;
	}

	@Override
	protected int minecraftDisplayHeight() {
		if (Modchu_Main.isServer) return -1;
		return Minecraft.getMinecraft().displayHeight;
	}

	@Override
	protected int minecraftDisplayWidth() {
		if (Modchu_Main.isServer) return -1;
		return Minecraft.getMinecraft().displayWidth;
	}

	@Override
	protected Object minecraftEntityRenderer() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().entityRenderer;
	}

	@Override
	protected Object minecraftEntityRendererItemRenderer() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().entityRenderer.itemRenderer;
	}

	@Override
	protected Object minecraftFontRenderer() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().fontRenderer;
	}

	@Override
	protected void minecraftFontRenderer(Object fontRenderer) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().fontRenderer = (FontRenderer) fontRenderer;
	}

	@Override
	protected Object minecraftGameSettings() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().gameSettings;
	}

	@Override
	protected void minecraftGameSettingsSetThirdPersonView(int i) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().gameSettings.thirdPersonView = i;
	}

	@Override
	protected int minecraftGameSettingsThirdPersonView() {
		if (Modchu_Main.isServer) return -1;
		return Minecraft.getMinecraft().gameSettings.thirdPersonView;
	}

	@Override
	protected boolean minecraftGameSettingsTouchscreen(Object gameSettings) {
		if (Modchu_Main.isServer) return false;
		return Minecraft.getMinecraft().gameSettings.touchscreen;
	}

	@Override
	protected Object minecraftGatSession() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().getSession();
	}

	@Override
	protected Object minecraftGetMinecraft() {
		if (Modchu_Main.isServer) return MinecraftServer.getServer();
		return Minecraft.getMinecraft();
	}

	@Override
	protected long minecraftGetSystemTime() {
		if (Modchu_Main.isServer) return MinecraftServer.getServer().getSystemTimeMillis();
		return Minecraft.getMinecraft().getSystemTime();
	}

	@Override
	protected Object minecraftGetTextureManager() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().getTextureManager();
	}

	@Override
	protected boolean minecraftInGameHasFocus() {
		if (Modchu_Main.isServer) return false;
		return Minecraft.getMinecraft().inGameHasFocus;
	}

	@Override
	protected File minecraftMcDataDir() {
		if (Modchu_Main.isServer) return new File(".");
		return Minecraft.getMinecraft().mcDataDir;
	}

	@Override
	protected Object minecraftPlayerController() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().playerController;
	}

	@Override
	protected void minecraftSetDimensionAndSpawnPlayer() {
		Object thePlayer = minecraftThePlayer();
		minecraftSetDimensionAndSpawnPlayer(((Entity) thePlayer).dimension);
	}

	@Override
	protected void minecraftSetDimensionAndSpawnPlayer(int i) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().setDimensionAndSpawnPlayer(i);
	}

	@Override
	protected Object minecraftThePlayer() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().thePlayer;
	}

	@Override
	protected Object minecraftTheWorld() {
		if (Modchu_Main.isServer) return MinecraftServer.getServer().worldServers[0];
		return Minecraft.getMinecraft().theWorld;
	}

	@Override
	protected void modelBaseSetLivingAnimations(Object model, Object entity, float f, float f1, float f2) {
		((ModelBase) model).setLivingAnimations((EntityLivingBase) entity, f, f1, f2);
	}

	@Override
	protected void modelBaseSetRotationAngles(Object model, float f, float f1, float f2, float f3, float f4, float f5, Object entity) {
		((ModelBase) model).setRotationAngles(f, f1, f2, f3, f4, f5, (EntityLivingBase) entity);
	}

	@Override
	protected float modelRendererRotateAngleX(Object modelRenderer) {
		return ((ModelRenderer) modelRenderer).rotateAngleX;
	}

	@Override
	protected float modelRendererRotateAngleY(Object modelRenderer) {
		return ((ModelRenderer) modelRenderer).rotateAngleY;
	}

	@Override
	protected float modelRendererRotateAngleZ(Object modelRenderer) {
		return ((ModelRenderer) modelRenderer).rotateAngleZ;
	}

	@Override
	protected float modelRendererRotationPointX(Object modelRenderer) {
		return ((ModelRenderer) modelRenderer).rotationPointX;
	}

	@Override
	protected float modelRendererRotationPointY(Object modelRenderer) {
		return ((ModelRenderer) modelRenderer).rotationPointY;
	}

	@Override
	protected float modelRendererRotationPointZ(Object modelRenderer) {
		return ((ModelRenderer) modelRenderer).rotationPointZ;
	}

	@Override
	protected void modelRendererSetRotationPoint(Object modelRenderer, float f, float f1, float f2 ) {
		((ModelRenderer) modelRenderer).setRotationPoint(f, f1, f2);
	}

	@Override
	protected boolean modelRendererShowModel(Object modelRenderer) {
		return ((ModelRenderer) modelRenderer).showModel;
	}

	@Override
	protected boolean nbttagcompoundGetBoolean(Object nbttagcompound, String s) {
		return ((NBTTagCompound) nbttagcompound).getBoolean(s);
	}

	@Override
	protected byte nbttagcompoundGetByte(Object nbttagcompound, String s) {
		return ((NBTTagCompound) nbttagcompound).getByte(s);
	}

	@Override
	protected byte[] nbttagcompoundGetByteArray(Object nbttagcompound, String s) {
		return ((NBTTagCompound) nbttagcompound).getByteArray(s);
	}

	@Override
	protected double nbttagcompoundGetDouble(Object nbttagcompound, String s) {
		return ((NBTTagCompound) nbttagcompound).getDouble(s);
	}

	@Override
	protected float nbttagcompoundGetFloat(Object nbttagcompound, String s) {
		return ((NBTTagCompound) nbttagcompound).getFloat(s);
	}

	@Override
	protected int[] nbttagcompoundGetIntArray(Object nbttagcompound, String s) {
		return ((NBTTagCompound) nbttagcompound).getIntArray(s);
	}

	@Override
	protected int nbttagcompoundGetInteger(Object nbttagcompound, String s) {
		return ((NBTTagCompound) nbttagcompound).getInteger(s);
	}

	@Override
	protected long nbttagcompoundGetLong(Object nbttagcompound, String s) {
		return ((NBTTagCompound) nbttagcompound).getLong(s);
	}

	@Override
	protected short nbttagcompoundGetShort(Object nbttagcompound, String s) {
		return ((NBTTagCompound) nbttagcompound).getShort(s);
	}

	@Override
	protected String nbttagcompoundGetString(Object nbttagcompound, String s) {
		return ((NBTTagCompound) nbttagcompound).getString(s);
	}

	@Override
	protected void nbttagcompoundSetBoolean(Object nbttagcompound, String s, boolean b) {
		((NBTTagCompound) nbttagcompound).setBoolean(s, b);
	}

	@Override
	protected void nbttagcompoundSetByte(Object nbttagcompound, String s, byte by) {
		((NBTTagCompound) nbttagcompound).setByte(s, by);
	}

	@Override
	protected void nbttagcompoundSetByteArray(Object nbttagcompound, String s, byte[] by) {
		((NBTTagCompound) nbttagcompound).setByteArray(s, by);
	}

	@Override
	protected void nbttagcompoundSetDouble(Object nbttagcompound, String s, double d) {
		((NBTTagCompound) nbttagcompound).setDouble(s, d);
	}

	@Override
	protected void nbttagcompoundSetFloat(Object nbttagcompound, String s, float f) {
		((NBTTagCompound) nbttagcompound).setFloat(s, f);
	}

	@Override
	protected void nbttagcompoundSetIntArray(Object nbttagcompound, String s, int[] in) {
		((NBTTagCompound) nbttagcompound).setIntArray(s, in);
	}

	@Override
	protected void nbttagcompoundSetInteger(Object nbttagcompound, String s, int i) {
		((NBTTagCompound) nbttagcompound).setInteger(s, i);
	}

	@Override
	protected void nbttagcompoundSetLong(Object nbttagcompound, String s, long l) {
		((NBTTagCompound) nbttagcompound).setLong(s, l);
	}

	@Override
	protected void nbttagcompoundSetShort(Object nbttagcompound, String s, short sh) {
		((NBTTagCompound) nbttagcompound).setShort(s, sh);
	}

	@Override
	protected void nbttagcompoundSetString(Object nbttagcompound, String s, String s1) {
		((NBTTagCompound) nbttagcompound).setString(s, s1);
	}

	@Override
	protected Object newInstanceKeyBinding(String s, int i, String s2) {
		return new KeyBinding(s, i);
	}

	@Override
	protected int openGlHelperDefaultTexUnit() {
		return OpenGlHelper.defaultTexUnit;
	}

	@Override
	protected int openGlHelperLightmapTexUnit() {
		return OpenGlHelper.lightmapTexUnit;
	}

	@Override
	protected void openGlHelperSetActiveTexture(int i) {
		OpenGlHelper.setActiveTexture(i);
	}

	@Override
	protected void playerControllerMPSetPlayerCapabilities(Object playerController, Object entityplayer) {
		((PlayerControllerMP) playerController).setPlayerCapabilities((EntityPlayer) entityplayer);
	}

	@Override
	protected void playerControllerFunc_6473_b(Object playerController, Object entityplayer) {
	}

	@Override
	protected Object playerControllerMPCreatePlayer(Object playerController) {
		return ((PlayerControllerMP) playerController).func_78754_a((World) minecraftTheWorld());
	}

	@Override
	protected void playerControllerMPFlipPlayer(Object playerController, Object entityplayer) {
		((PlayerControllerMP) playerController).flipPlayer((EntityPlayer) entityplayer);
	}

	@Override
	protected void playerControllerSetGameType(Object enumGameType) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().playerController.setGameType((EnumGameType) enumGameType);
	}

	@Override
	protected Object positionTextureVertexSetTexturePosition(Object positionTextureVertex, float f, float f1) {
		return ((PositionTextureVertex) positionTextureVertex).setTexturePosition(f, f1);
	}

	@Override
	protected float positionTextureVertexTexturePositionX(Object positionTextureVertex) {
		return ((PositionTextureVertex) positionTextureVertex).texturePositionX;
	}

	@Override
	protected float positionTextureVertexTexturePositionY(Object positionTextureVertex) {
		return ((PositionTextureVertex) positionTextureVertex).texturePositionY;
	}

	@Override
	protected Object positionTextureVertexVector3D(Object positionTextureVertex) {
		return ((PositionTextureVertex) positionTextureVertex).vector3D;
	}

	@Override
	protected Object potionAbsorption() {
		return Potion.field_76444_x;
	}

	@Override
	protected Object potionBlindness() {
		return Potion.blindness;
	}

	@Override
	protected Object potionConfusion() {
		return Potion.confusion;
	}

	@Override
	protected Object potionDamageBoost() {
		return Potion.damageBoost;
	}

	@Override
	protected Object potionDigSlowdown() {
		return Potion.digSlowdown;
	}

	@Override
	protected Object potionDigSpeed() {
		return Potion.digSpeed;
	}

	@Override
	protected Object potionFireResistance() {
		return Potion.fireResistance;
	}

	@Override
	protected Object potionHarm() {
		return Potion.harm;
	}

	@Override
	protected Object potionHeal() {
		return Potion.heal;
	}

	@Override
	protected Object potionHealthBoost() {
		return Potion.field_76434_w;
	}

	@Override
	protected Object potionHunger() {
		return Potion.hunger;
	}

	@Override
	protected Object potionInvisibility() {
		return Potion.invisibility;
	}

	@Override
	protected Object potionJump() {
		return Potion.jump;
	}

	@Override
	protected Object potionMoveSlowdown() {
		return Potion.moveSlowdown;
	}

	@Override
	protected Object potionMoveSpeed() {
		return Potion.moveSpeed;
	}

	@Override
	protected Object potionNightVision() {
		return Potion.nightVision;
	}

	@Override
	protected Object potionPoison() {
		return Potion.poison;
	}

	@Override
	protected Object potionRegeneration() {
		return Potion.regeneration;
	}

	@Override
	protected Object potionResistance() {
		return Potion.resistance;
	}

	@Override
	protected Object potionSaturation() {
		return Potion.field_76443_y;
	}

	@Override
	protected Object potionWaterBreathing() {
		return Potion.waterBreathing;
	}

	@Override
	protected Object potionWeakness() {
		return Potion.weakness;
	}

	@Override
	protected Object potionWither() {
		return Potion.wither;
	}

	@Override
	protected void printChatMessage(String s) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(s);
	}

	@Override
	protected void renderBindTexture(Object render, Object resourceLocation) {
		Modchu_Reflect.invokeMethod("Render", "func_110776_a", "bindTexture", new Class[]{ Modchu_Reflect.loadClass("ResourceLocation") }, render, new Object[]{ resourceLocation });
	}

	@Override
	protected void renderBlocksRenderBlockAllFaces(Object renderBlocks, Object block, int i, int i2, int i3) {
		((RenderBlocks) renderBlocks).renderBlockAllFaces((Block) block, i, i2, i3);
	}

	@Override
	protected void renderBlocksRenderBlockAsItem(Object renderBlocks, Object block, int i, float f) {
		((RenderBlocks) renderBlocks).renderBlockAsItem((Block) block, i, f);
	}

	@Override
	protected boolean renderBlocksRenderItemIn3d(Object renderBlocks, int i) {
		return ((RenderBlocks) renderBlocks).renderItemIn3d(i);
	}

	@Override
	protected void renderFirstPersonArm(Object renderplayer, Object entityplayer) {
		((RenderPlayer) renderplayer).renderFirstPersonArm((EntityPlayer) entityplayer);
	}

	@Override
	protected void renderHelperDisableStandardItemLighting() {
		RenderHelper.disableStandardItemLighting();
	}

	@Override
	protected void renderHelperEnableStandardItemLighting() {
		RenderHelper.enableStandardItemLighting();
	}

	@Override
	protected Object renderLoadDownloadableImageTexture(Object render, String s, String s1) {
		return null;
	}

	@Override
	protected Object renderManagerGetEntityClassRenderObject(Class c) {
		return RenderManager.instance.getEntityClassRenderObject(c);
	}

	@Override
	protected Object renderManagerGetEntityRenderObject(Object entity) {
		return RenderManager.instance.getEntityRenderObject((Entity) entity);
	}

	@Override
	protected Object renderManagerInstance() {
		return RenderManager.instance;
	}

	@Override
	protected Object renderManagerItemRenderer() {
		return RenderManager.instance.itemRenderer;
	}

	@Override
	protected void renderManagerItemRendererRenderItem(Object itemRenderer, Object entity, Object itemstack, Object o) {
		RenderManager.instance.itemRenderer.renderItem((EntityLivingBase) entity, (ItemStack) itemstack, (Integer) o);
	}

	@Override
	protected boolean renderManagerRenderEntityWithPosYaw(Object entity, double d, double d2, double d3, float f, float f2) {
		RenderManager.instance.renderEntityWithPosYaw((Entity) entity, d, d2, d3, f, f2);
		return true;
	}

	@Override
	protected Object renderRenderManagerRenderEngine(Object render) {
		return ((RenderManager) renderRenderManager(render)).renderEngine;
	}

	@Override
	protected InputStream resourceManagerInputStream(Object o) {
		if (Modchu_Main.isServer) return null;
		try {
			return Minecraft.getMinecraft().getResourceManager().getResource((ResourceLocation) o).getInputStream();
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	protected void setEntityEntityID(Object entity, int i) {
		((Entity) entity).entityId = i;
	}

	@Override
	protected void setEntityHurtResistantTime(Object entity, int i) {
		((Entity) entity).hurtResistantTime = i;
	}

	@Override
	protected void setEntityLivingBaseAttackedAtYaw(Object entityLivingBase, float f) {
		((EntityLivingBase) entityLivingBase).attackedAtYaw = f;
	}

	@Override
	protected void setEntityLivingBaseDeathTime(Object entityLivingBase, int i) {
		((EntityLivingBase) entityLivingBase).deathTime = i;
	}

	@Override
	protected void setEntityLivingBaseHealth(Object entity, float f) {
		((EntityLivingBase) entity).getDataWatcher().updateObject(6, Modchu_CastHelper.Float(MathHelper.clamp_float(f, 0.0F, entityLivingGetMaxHealth(entity))));
	}

	@Override
	protected void setEntityLivingBaseHurtTime(Object entityLivingBase, int i) {
		((EntityLivingBase) entityLivingBase).hurtTime = i;
	}

	@Override
	protected void setEntityLivingBaseMaxHurtResistantTime(Object entityLivingBase, int i) {
		((EntityLivingBase) entityLivingBase).maxHurtResistantTime = i;
	}

	@Override
	protected void setEntityLivingBaseMaxHurtTime(Object entityLivingBase, int i) {
		((EntityLivingBase) entityLivingBase).maxHurtTime = i;
	}

	@Override
	protected void setEntityLivingBasePrevHealth(Object entityLivingBase, float f) {
		((EntityLivingBase) entityLivingBase).prevHealth = f;
	}

	@Override
	protected void setEntityMotionX(Object entity, double d) {
		((Entity) entity).motionX = d;
	}

	@Override
	protected void setEntityMotionY(Object entity, double d) {
		((Entity) entity).motionY = d;
	}

	@Override
	protected void setEntityMotionZ(Object entity, double d) {
		((Entity) entity).motionZ = d;
	}

	@Override
	protected void setEntityPlayerArmorInventory(Object entityplayer, Object armorInventory) {
		((EntityPlayer) entityplayer).inventory.armorInventory = (ItemStack[]) armorInventory;
	}

	@Override
	protected void setEntityPlayerCurrentXP(Object entityplayer, float f) {
		((EntityPlayer) entityplayer).experience = f;
	}

	@Override
	protected void setEntityPlayerInventory(Object entityplayer, Object inventory) {
		((EntityPlayer) entityplayer).inventory = (InventoryPlayer) inventory;
	}

	@Override
	protected void setEntityPlayerMainInventory(Object entityplayer, Object mainInventory) {
		((EntityPlayer) entityplayer).inventory.mainInventory = (ItemStack[]) mainInventory;
	}

	@Override
	protected void setEntityPlayerPlayerLevel(Object entityplayer, int i) {
		((EntityPlayer) entityplayer).experienceLevel = i;
	}

	@Override
	protected void setEntityPlayerScore(Object entityplayer, int i) {
		((EntityPlayer) entityplayer).setScore(i);
	}

	@Override
	protected void setEntityPlayerSPMovementInput() {
		Object thePlayer = minecraftThePlayer();
		Object gameSettings = minecraftGameSettings();
		setEntityPlayerSPMovementInput(thePlayer, new MovementInputFromOptions((GameSettings) gameSettings));
	}

	@Override
	protected void setEntityPlayerSPMovementInput(Object entityplayer, Object movementInput) {
		((EntityPlayerSP) entityplayer).movementInput = (MovementInput) movementInput;
	}

	@Override
	protected void setEntityPlayerTotalXP(Object entityplayer, int i) {
		((EntityPlayer) entityplayer).experienceTotal = i;
	}

	@Override
	protected void setEntityPosX(Object entity, double d) {
		((Entity) entity).posX = d;
	}

	@Override
	protected void setEntityPosY(Object entity, double d) {
		((Entity) entity).posY = d;
	}

	@Override
	protected void setEntityPosZ(Object entity, double d) {
		((Entity) entity).posZ = d;
	}

	@Override
	protected void setEntityRendererItemRenderer(Object itemRenderer) {
		//final orz
		Modchu_Reflect.setFieldObject("EntityRenderer", "field_78516_c", "itemRenderer", minecraftEntityRenderer(), itemRenderer);
	}

	@Override
	protected void setEntityRiddenByEntity(Object entity, Object entity2) {
		((Entity) entity).riddenByEntity = (Entity) entity2;
	}

	@Override
	protected void setEntityYOffset(Object entity, float f) {
		((Entity) entity).yOffset = f;
	}

	@Override
	protected void setGameSettingsKeyBindBack(Object keyBinding) {
		Minecraft.getMinecraft().gameSettings.keyBindBack = (KeyBinding) keyBinding;
	}

	@Override
	protected void setGameSettingsKeyBindForward(Object keyBinding) {
		Minecraft.getMinecraft().gameSettings.keyBindForward = (KeyBinding) keyBinding;
	}

	@Override
	protected void setGameSettingsKeyBindLeft(Object keyBinding) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().gameSettings.keyBindLeft = (KeyBinding) keyBinding;
	}

	@Override
	protected void setGameSettingsKeyBindRight(Object keyBinding) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().gameSettings.keyBindRight = (KeyBinding) keyBinding;
	}

	@Override
	protected void setGuiButtonEnabled(Object guiButton, boolean b) {
		((GuiButton) guiButton).enabled = b;
	}

	@Override
	protected void setGuiButtonID(Object guiButton, int i) {
		((GuiButton) guiButton).id = i;
	}

	@Override
	protected void setGuiButtonVisible(Object guiButton, boolean b) {
		((GuiButton) guiButton).drawButton = b;
	}

	@Override
	protected void setGuiButtonXPosition(Object guiButton, int i) {
		((GuiButton) guiButton).xPosition = i;
	}

	@Override
	protected void setGuiButtonYPosition(Object guiButton, int i) {
		((GuiButton) guiButton).yPosition = i;
	}

	@Override
	protected void setGuiScreenFontRenderer(Object guiScreen, Object fontRenderer) {
		Modchu_Reflect.setFieldObject("GuiScreen", "fontRendererObj", guiScreen, fontRenderer);
	}

	@Override
	protected void setGuiScreenHeight(Object guiScreen, int i) {
		((GuiScreen) guiScreen).height = i;
	}

	@Override
	protected void setGuiScreenWidth(Object guiScreen, int i) {
		((GuiScreen) guiScreen).width = i;
	}

	@Override
	protected void setMinecraftDisplayGuiScreen(Object guiScreen) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().displayGuiScreen((GuiScreen) guiScreen);
	}

	@Override
	protected void setMinecraftPlayerController(Object playerController) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().playerController = (PlayerControllerMP) playerController;
	}

	@Override
	protected void setMinecraftRenderViewEntity(Object entity) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().renderViewEntity = (EntityLivingBase) entity;
	}

	@Override
	protected void setMinecraftThePlayer(Object entityPlayer) {
		if (Modchu_Main.isServer) return;
		Minecraft.getMinecraft().thePlayer = (EntityClientPlayerMP) entityPlayer;
	}

	@Override
	protected void setModelRendererRotateAngleX(Object modelRenderer, float f) {
		((ModelRenderer) modelRenderer).rotateAngleX = f;
	}

	@Override
	protected void setModelRendererRotateAngleY(Object modelRenderer, float f) {
		((ModelRenderer) modelRenderer).rotateAngleY = f;
	}

	@Override
	protected void setModelRendererRotateAngleZ(Object modelRenderer, float f) {
		((ModelRenderer) modelRenderer).rotateAngleZ = f;
	}

	@Override
	protected void setModelRendererRotationPointX(Object modelRenderer, float f) {
		((ModelRenderer) modelRenderer).rotationPointX = f;
	}

	@Override
	protected void setModelRendererRotationPointY(Object modelRenderer, float f) {
		((ModelRenderer) modelRenderer).rotationPointY = f;
	}

	@Override
	protected void setModelRendererRotationPointZ(Object modelRenderer, float f) {
		((ModelRenderer) modelRenderer).rotationPointZ = f;
	}

	@Override
	protected void setModelRendererShowModel(Object modelRenderer, boolean b) {
		((ModelRenderer) modelRenderer).showModel = b;
	}

	@Override
	protected void setRenderManagerItemRenderer(Object itemRenderer) {
		RenderManager.instance.itemRenderer = (ItemRenderer) itemRenderer;
	}

	@Override
	protected void tessellatorAddVertexWithUV(Object tessellator, double d, double d2, double d3, double d4, double d5) {
		((Tessellator) tessellator).addVertexWithUV(d, d2, d3, d4, d5);
	}

	@Override
	protected void tessellatorDraw(Object tessellator) {
		((Tessellator) tessellator).draw();
	}

	@Override
	protected Object tessellatorInstance() {
		return Tessellator.instance;
	}

	@Override
	protected void tessellatorSetColorOpaque_I(Object tessellator, int i) {
		((Tessellator) tessellator).setColorOpaque_I(i);
	}

	@Override
	protected void tessellatorSetColorRGBA_I(Object tessellator, int i, int i2) {
		((Tessellator) tessellator).setColorRGBA_I(i, i2);
	}

	@Override
	protected void tessellatorSetNormal(Object tessellator, float f, float f2, float f3) {
		((Tessellator) tessellator).setNormal(f, f2, f3);
	}

	@Override
	protected void tessellatorStartDrawing(Object tessellator, byte by) {
		((Tessellator) tessellator).startDrawing(by);
	}

	@Override
	protected void tessellatorStartDrawingQuads(Object tessellator) {
		((Tessellator) tessellator).startDrawingQuads();
	}

	@Override
	protected void texturedQuadDraw(Object texturedQuad, Object tessellator, float f) {
		((TexturedQuad) texturedQuad).draw((Tessellator) tessellator, f);
	}

	@Override
	protected void textureManagerBindTexture(Object textureManager, Object o) {
		if (o != null) ((TextureManager) textureManager).bindTexture((ResourceLocation) o);
	}

	@Override
	protected Object textureManagerGetTexture(Object textureManager, Object o) {
		return o != null ? ((TextureManager) textureManager).getTexture((ResourceLocation) o) : null;
	}

	@Override
	protected Object textureManagerGetResourceLocation(Object textureManager, int i) {
		return ((TextureManager) textureManager).getResourceLocation(i);
	}

	@Override
	protected int textureOffsetTextureOffsetX(Object textureOffset) {
		return ((TextureOffset) textureOffset).textureOffsetX;
	}

	@Override
	protected int textureOffsetTextureOffsetY(Object textureOffset) {
		return ((TextureOffset) textureOffset).textureOffsetY;
	}

	@Override
	protected int textureUtilUploadTextureImage(int i, Object bufferedimage) {
		return TextureUtil.uploadTextureImage(i, (BufferedImage) bufferedimage);
	}

	@Override
	protected boolean threadDownloadImageDataIsTextureUploaded(Object threadDownloadImageData) {
		return ((ThreadDownloadImageData) threadDownloadImageData).isTextureUploaded();
	}

	@Override
	protected Object vec3CrossProduct(Object vec3, Object vec3_2) {
		return ((Vec3) vec3).crossProduct((Vec3) vec3_2);
	}

	@Override
	protected Object vec3Normalize(Object vec3) {
		return ((Vec3) vec3).normalize();
	}

	@Override
	protected Object vec3Subtract(Object vec3, Object vec3_2) {
		return ((Vec3) vec3).subtract((Vec3) vec3_2);
	}

	@Override
	protected double vec3XCoord(Object vec3) {
		return ((Vec3) vec3).xCoord;
	}

	@Override
	protected double vec3YCoord(Object vec3) {
		return ((Vec3) vec3).yCoord;
	}

	@Override
	protected double vec3ZCoord(Object vec3) {
		return ((Vec3) vec3).zCoord;
	}

	@Override
	protected boolean worldCanBlockSeeTheSky(Object worldOrEntity, double d, double d2, double d3) {
		return ((World) entityWorldObj(worldOrEntity)).canBlockSeeTheSky((int) d, (int) d2, (int) d3);
	}

	@Override
	protected boolean worldCanBlockSeeTheSky(Object worldOrEntity, int i, int i2, int i3) {
		return ((World) entityWorldObj(worldOrEntity)).canBlockSeeTheSky(i, i2, i3);
	}

	@Override
	protected Object worldGetPathEntityToEntity(Object worldOrEntity, Object entity, Object entity2, float f, boolean b, boolean b1, boolean b2, boolean b3) {
		return ((World) entityWorldObj(worldOrEntity)).getPathEntityToEntity((Entity) entity, (Entity) entity2, f, b, b1, b2, b3);
	}

	@Override
	protected Object worldGetPlayerEntityByName(Object worldOrEntity, String s) {
		return ((World) entityWorldObj(worldOrEntity)).getPlayerEntityByName(s);
	}

	@Override
	protected Object worldGetWorldInfo() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().theWorld.getWorldInfo();
	}

	@Override
	protected Enum worldGetWorldInfoGetGameType() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().theWorld.getWorldInfo().getGameType();
	}

	@Override
	protected boolean worldIsAirBlock(Object worldOrEntity, int i, int j, int k) {
		return ((World) entityWorldObj(worldOrEntity)).isAirBlock(i, j, k);
	}

	@Override
	protected boolean worldIsBlockNormalCubeDefault(Object worldOrEntity, int i, int j, int k, boolean b) {
		return ((World) entityWorldObj(worldOrEntity)).isBlockNormalCubeDefault(i, j, k, b);
	}

	@Override
	protected boolean worldIsDaytime(Object worldOrEntity) {
		return ((World) entityWorldObj(worldOrEntity)).isDaytime();
	}

	@Override
	protected boolean worldIsRemote(Object worldOrEntity) {
		World world = ((World) entityWorldObj(worldOrEntity));
		return world != null ? world.isRemote : false;
	}

	@Override
	protected List worldLoadedEntityList(Object worldOrEntity) {
		World world = ((World) entityWorldObj(worldOrEntity));
		return world != null ? world.loadedEntityList : null;
	}

	@Override
	protected List worldPlayerEntities(Object worldOrEntity) {
		World world = ((World) entityWorldObj(worldOrEntity));
		return world != null ? world.playerEntities : null;
	}

	@Override
	protected List worldWeatherEffects(Object worldOrEntity) {
		World world = ((World) entityWorldObj(worldOrEntity));
		return world != null ? world.weatherEffects : null;
	}

	@Override
	protected void worldPlaySoundAtEntity(Object worldOrEntity, Object entity, String s, float f, float f1) {
		World world = ((World) entityWorldObj(worldOrEntity));
		if (world != null) world.playSoundAtEntity((Entity) entity, s, f, f1);
	}

	@Override
	protected void worldSetEntityDead(Object entity) {
	}

	@Override
	protected void worldSetEntityState(Object worldOrEntity, Object entity, byte by) {
		World world = ((World) entityWorldObj(worldOrEntity));
		if (world != null) world.setEntityState((Entity) entity, by);
	}

	@Override
	protected Enum worldSettingsGameTypeADVENTURE() {
		return EnumGameType.ADVENTURE;
	}

	@Override
	protected Enum worldSettingsGameTypeCREATIVE() {
		return EnumGameType.CREATIVE;
	}

	@Override
	protected Enum worldSettingsGameTypeNOT_SET() {
		return EnumGameType.NOT_SET;
	}

	@Override
	protected Enum worldSettingsGameTypeSURVIVAL() {
		return EnumGameType.SURVIVAL;
	}

	@Override
	protected void worldSpawnParticle(Object worldOrEntity, Object stingOrEnumParticleTypes, double d, double d1, double d2, double d3, double d4, double d5) {
		World world = ((World) entityWorldObj(worldOrEntity));
		if (world != null) world.spawnParticle((String)stingOrEnumParticleTypes, d, d1, d2, d3, d4, d5);
	}

	@Override
	protected void worldSpawnPlayerWithLoadedChunks(Object entityplayer) {
	}

	@Override
	protected boolean entityIsDead(Object entity) {
		return ((Entity) entity).isDead;
	}

	@Override
	protected void setEntityIsDead(Object entity, boolean b) {
		((Entity) entity).isDead = b;
	}

	@Override
	protected Object iIconRegisterRegisterIcon(Object iIconRegister, String s) {
		return ((IconRegister) iIconRegister).registerIcon(s);
	}

	@Override
	protected void entityLivingBaseSwingItem(Object entityLivingBase) {
		((EntityLivingBase) entityLivingBase).swingItem();
	}

	@Override
	protected boolean entityTameableIsTamed(Object entityTameable) {
		return entityTameable instanceof EntityTameable ? ((EntityTameable) entityTameable).isTamed() : false;
	}

	@Override
	protected boolean entityHorseIsTame(Object entityHorse) {
		return entityHorse instanceof EntityHorse ? ((EntityHorse) entityHorse).isTame() : false;
	}

	@Override
	protected Object getIntegratedServer() {
		return Minecraft.getMinecraft().getIntegratedServer();
	}

	@Override
	protected boolean itemShouldRotateAroundWhenRendering(Object item) {
		return ((Item) item).shouldRotateAroundWhenRendering();
	}

	@Override
	protected boolean itemStackHasTagCompound(Object itemStack) {
		return ((ItemStack) itemStack).hasTagCompound();
	}

	@Override
	protected Object itemStackGetTagCompound(Object itemStack) {
		return ((ItemStack) itemStack).getTagCompound();
	}

	@Override
	protected boolean nbtTagCompoundHasKey(Object nBTTagCompoundOrItemStack, String s) {
		return ((NBTTagCompound) nBTTagCompoundOrItemStack).hasKey(s);
	}

	@Override
	protected String nbtTagCompoundGetString(Object nBTTagCompoundOrItemStack, String s) {
		return ((NBTTagCompound) nBTTagCompoundOrItemStack).getString(s);
	}

	@Override
	protected Object tileEntitySkullRendererSkullRenderer() {
		return TileEntitySkullRenderer.skullRenderer;
	}

	@Override
	protected boolean itemRequiresMultipleRenderPasses(Object item) {
		return ((Item) item).requiresMultipleRenderPasses();
	}

	@Override
	protected int itemGetColorFromItemStack(Object item, Object itemstack, int i) {
		return ((Item) item).getColorFromItemStack((ItemStack) itemstack, i);
	}

	@Override
	protected int blockDoublePlantGetMixedBrightnessForBlock(Object blockDoublePlant, int x, int y, int z) {
		return -1;
	}

	@Override
	protected int blockDoublePlantGetMixedBrightnessForBlock(Object blockDoublePlant, Object world, int x, int y, int z) {
		return -1;
	}

	@Override
	protected void tessellatorSetBrightness(Object tessellator, int i) {
		((Tessellator) tessellator).setBrightness(i);
	}

	@Override
	protected int biomeGenBaseGetBiomeGrassColor(Object biomeGenBase, int x, int y, int z) {
		return ((BiomeGenBase) biomeGenBase).getBiomeGrassColor();
	}

	@Override
	protected boolean entityRendererAnaglyphEnable() {
		return EntityRenderer.anaglyphEnable;
	}

	@Override
	protected void tessellatorSetColorOpaque_F(Object tessellator, float f, float f1, float f2) {
		((Tessellator) tessellator).setColorOpaque_F(f, f1, f2);
	}

	@Override
	protected boolean blockDoublePlantFunc_149887_c(int i) {
		return false;
	}

	@Override
	protected int blockDoublePlantFunc_149890_d(int i) {
		return -1;
	}

	@Override
	protected Object blockDoublePlantFunc_149888_a(Object blockDoublePlant, boolean b, int i) {
		return null;
	}

	@Override
	protected Object[] blockDoublePlantSunflowerIcons(Object blockDoublePlant) {
		return null;
	}

	@Override
	protected double iIconGetMinU(Object iIcon) {
		return 0.0D;
	}

	@Override
	protected double iIconGetMinV(Object iIcon) {
		return 0.0D;
	}

	@Override
	protected double iIconGetMaxU(Object iIcon) {
		return 0.0D;
	}

	@Override
	protected double iIconGetMaxV(Object iIcon) {
		return 0.0D;
	}

	@Override
	protected Object itemItemRegistry() {
		return null;
	}

	@Override
	protected Map registrySimpleRegistryObjects(Object itemRegistry) {
		return null;
	}

	@Override
	protected String potionHelperSugarEffect() {
		return PotionHelper.sugarEffect;
	}

	@Override
	protected String potionHelperGhastTearEffect() {
		return PotionHelper.ghastTearEffect;
	}

	@Override
	protected String potionHelperSpiderEyeEffect() {
		return PotionHelper.spiderEyeEffect;
	}

	@Override
	protected String potionHelperFermentedSpiderEyeEffect() {
		return PotionHelper.fermentedSpiderEyeEffect;
	}

	@Override
	protected String potionHelperSpeckledMelonEffect() {
		return PotionHelper.speckledMelonEffect;
	}

	@Override
	protected String potionHelperBlazePowderEffect() {
		return PotionHelper.blazePowderEffect;
	}

	@Override
	protected String potionHelperMagmaCreamEffect() {
		return PotionHelper.magmaCreamEffect;
	}

	@Override
	protected String potionHelperRedstoneEffect() {
		return PotionHelper.redstoneEffect;
	}

	@Override
	protected String potionHelperGlowstoneEffect() {
		return PotionHelper.glowstoneEffect;
	}

	@Override
	protected String potionHelperGunpowderEffect() {
		return PotionHelper.gunpowderEffect;
	}

	@Override
	protected String potionHelperGoldenCarrotEffect() {
		return PotionHelper.goldenCarrotEffect;
	}

	@Override
	protected int itemArmorGetColor(Object itemArmor, Object itemstack) {
		return itemArmor instanceof ItemArmor ? ((ItemArmor) itemArmor).getColor((ItemStack) itemstack) : -1;
	}

	@Override
	protected void setEntityRotationPitch(Object entity, float f) {
		((Entity) entity).rotationPitch = f;
	}

	@Override
	protected void setEntityRotationYaw(Object entity, float f) {
		((Entity) entity).rotationYaw = f;
	}

	@Override
	protected void setEntityPrevRotationPitch(Object entity, float f) {
		((Entity) entity).prevRotationPitch = f;
	}

	@Override
	protected void setEntityPrevRotationYaw(Object entity, float f) {
		((Entity) entity).prevRotationYaw = f;
	}

	@Override
	protected void setEntityLivingBaseLimbSwing(Object entity, float f) {
		((EntityLivingBase) entity).limbSwing = f;
	}

	@Override
	protected void setEntityLivingBasePrevRenderYawOffset(Object entity, float f) {
		((EntityLivingBase) entity).prevRenderYawOffset = f;
	}

	@Override
	protected void setEntityLivingBasePrevRotationYawHead(Object entity, float f) {
		((EntityLivingBase) entity).prevRotationYawHead = f;
	}

	@Override
	protected void setEntityLivingBaseRenderYawOffset(Object entity, float f) {
		((EntityLivingBase) entity).renderYawOffset = f;
	}

	@Override
	protected void setEntityLivingBaseRotationYawHead(Object entity, float f) {
		((EntityLivingBase) entity).rotationYawHead = f;
	}

	@Override
	protected void setEntityLivingBasePrevLimbSwingAmount(Object entity, float f) {
		((EntityLivingBase) entity).prevLimbSwingAmount = f;
	}

	@Override
	protected void setEntityLivingBaseMoveStrafing(Object entityplayer, float f) {
		((EntityLivingBase) entityplayer).moveStrafing = f;
	}

	@Override
	protected void setEntityLivingBaseMoveForward(Object entityplayer, float f) {
		((EntityLivingBase) entityplayer).moveForward = f;
	}

	@Override
	protected void setEntityLivingBaseLimbSwingAmount(Object entity, float f) {
		((EntityLivingBase) entity).limbSwingAmount = f;
	}

	@Override
	protected void itemOnItemRightClick(Object item, Object itemStack, Object world, Object entityplayer) {
		((Item) item).onItemRightClick((ItemStack) itemStack, (World) world, (EntityPlayer) entityplayer);
	}

	@Override
	protected void setItemStackStackSize(Object itemstack, int i) {
		((ItemStack) itemstack).stackSize = i;
	}

	@Override
	protected Object minecraftServerGetServer() {
		return MinecraftServer.getServer();
	}

	@Override
	protected Object[] minecraftServerGetServerWorldServers() {
		return MinecraftServer.getServer().worldServers;
	}

	@Override
	protected void entityPlayerDestroyCurrentEquippedItem(Object entityplayer) {
		((EntityPlayer) entityplayer).destroyCurrentEquippedItem();
	}

	@Override
	protected boolean entityPlayerCapabilitiesIsCreativeMode(Object entityplayer) {
		return ((EntityPlayer) entityplayer).capabilities.isCreativeMode;
	}

	@Override
	protected boolean modelBaseIsChild(Object modelBase) {
		return ((ModelBase) modelBase).isChild;
	}

	@Override
	protected void setModelBaseIsChild(Object modelBase, boolean b) {
		((ModelBase) modelBase).isChild = b;
	}

	@Override
	protected void entityBatSetIsBatHanging(Object entityBat, boolean b) {
		((EntityBat) entityBat).setIsBatHanging(b);
	}

	@Override
	protected void entitySetEating(Object entity, boolean b) {
		((Entity) entity).setEating(b);
	}

	@Override
	protected void entityLivingBaseSetPositionAndUpdate(Object entity, double x, double y, double z) {
		((EntityLivingBase) entity).setPositionAndUpdate(x, y, z);
	}

	@Override
	protected void entitySetPositionAndRotation(Object entity, double x, double y, double z, float f, float f1) {
		((Entity) entity).setPositionAndRotation(x, y, z, f, f1);
	}

	@Override
	protected int threadDownloadImageDataGetGlTextureId(Object threadDownloadImageData) {
		return ((ThreadDownloadImageData) threadDownloadImageData).getGlTextureId();
	}

	@Override
	protected Object netClientHandlerGetNetManager(Object netClientHandler) {
		return ((NetClientHandler) netClientHandler).getNetManager();
	}

	@Override
	protected int itemStackGetMaxDamage(Object itemstack) {
		return ((ItemStack) itemstack).getMaxDamage();
	}

	@Override
	protected List modelBaseBoxList(Object modelBase) {
		if (!(modelBase instanceof ModelBase)) {
			return Modchu_CastHelper.List(Modchu_Reflect.getFieldObject(modelBase.getClass(), "boxList", modelBase));
		}
		return ((ModelBase) modelBase).boxList;
	}

	@Override
	protected void setModelBaseBoxList(Object modelBase, List list) {
		if (!(modelBase instanceof ModelBase)) {
			Modchu_Reflect.setFieldObject(modelBase.getClass(), "boxList", modelBase, list);
			return;
		}
		((ModelBase) modelBase).boxList = list;
	}

	@Override
	protected int modelBaseTextureWidth(Object modelBase) {
		if (!(modelBase instanceof ModelBase)) {
			return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject(modelBase.getClass(), "textureWidth", modelBase));
		}
		return ((ModelBase) modelBase).textureWidth;
	}

	@Override
	protected void setModelBaseTextureWidth(Object modelBase, int i) {
		if (!(modelBase instanceof ModelBase)) {
			Modchu_Reflect.setFieldObject(modelBase.getClass(), "textureWidth", modelBase, i);
			return;
		}
		((ModelBase) modelBase).textureWidth = i;
	}

	@Override
	protected int modelBaseTextureHeight(Object modelBase) {
		if (!(modelBase instanceof ModelBase)) {
			return Modchu_CastHelper.Int(Modchu_Reflect.getFieldObject(modelBase.getClass(), "textureHeight", modelBase));
		}
		return ((ModelBase) modelBase).textureHeight;
	}

	@Override
	protected void setModelBaseTextureHeight(Object modelBase, int i) {
		if (!(modelBase instanceof ModelBase)) {
			Modchu_Reflect.setFieldObject(modelBase.getClass(), "textureHeight", modelBase, i);
			return;
		}
		((ModelBase) modelBase).textureHeight = i;
	}

	@Override
	protected Object modelRightArm(Object model) {
		if (model instanceof ModelBase) {
			if (model instanceof ModelBiped) return modelBipedBipedRightArm(model);
			if (model instanceof ModelQuadruped) return modelQuadrupedLeg1(model);
			if (model instanceof ModelBat) return modelBatBatRightWing(model);
			if (model instanceof ModelChicken) return modelChickenRightWing(model);
			if (model instanceof ModelCreeper) return modelCreeperLeg1(model);
			if (model instanceof ModelHorse) return modelHorseFrontRightLeg(model);
			if (model instanceof ModelIronGolem) return modelIronGolemIronGolemRightArm(model);
			if (model instanceof ModelOcelot) return modelOcelotOcelotFrontRightLeg(model);
			if (model instanceof ModelSnowMan) return modelSnowManRightHand(model);
			if (model instanceof ModelSpider) return modelSpiderSpiderLeg1(model);
			if (model instanceof ModelWolf) return modelWolfWolfLeg1(model);
			if (model instanceof ModelSquid) {
				Object[] o = modelSquidSquidTentacles(model);
				return o != null
						&& o.length > 0 ? o[0] : null;
			}
			if (model instanceof ModelBlaze) {
				Object[] o = modelBlazeBlazeSticks(model);
				return o != null
						&& o.length > 0 ? o[0] : null;
			}
			if (model instanceof ModelGhast) {
				Object[] o = modelGhastTentacles(model);
				return o != null
						&& o.length > 0 ? o[0] : null;
			}
		}
		return Modchu_Reflect.getFieldObject(model.getClass(), "bipedRightArm", model);
	}

	@Override
	protected Object modelBipedBipedRightArm(Object modelBiped) {
		return ((ModelBiped) modelBiped).bipedRightArm;
	}

	@Override
	protected void setModelBipedBipedRightArm(Object modelBiped, Object modelRenderer) {
		((ModelBiped) modelBiped).bipedRightArm = (ModelRenderer) modelRenderer;
	}

	@Override
	protected Object modelWolfWolfLeg1(Object modelWolf) {
		return ((ModelWolf) modelWolf).wolfLeg1;
	}

	@Override
	protected void setModelWolfWolfLeg1(Object modelWolf, Object modelRenderer) {
		((ModelWolf) modelWolf).wolfLeg1 = (ModelRenderer) modelRenderer;
	}

	@Override
	protected Object modelSnowManRightHand(Object modelSnowMan) {
		return ((ModelSnowMan) modelSnowMan).rightHand;
	}

	@Override
	protected void setModelSnowManRightHand(Object modelSnowMan, Object modelRenderer) {
		((ModelSnowMan) modelSnowMan).rightHand = (ModelRenderer) modelRenderer;
	}

	@Override
	protected Object modelSpiderSpiderLeg1(Object modelSpider) {
		return ((ModelSpider) modelSpider).spiderLeg1;
	}

	@Override
	protected void setModelSpiderSpiderLeg1(Object modelSpider, Object modelRenderer) {
		((ModelSpider) modelSpider).spiderLeg1 = (ModelRenderer) modelRenderer;
	}

	@Override
	protected Object modelIronGolemIronGolemRightArm(Object modelIronGolem) {
		return ((ModelIronGolem) modelIronGolem).ironGolemRightArm;
	}

	@Override
	protected void setModelIronGolemIronGolemRightArm(Object modelIronGolem, Object modelRenderer) {
		((ModelIronGolem) modelIronGolem).ironGolemRightArm = (ModelRenderer) modelRenderer;
	}

	@Override
	protected Object modelQuadrupedLeg1(Object modelQuadruped) {
		return ((ModelQuadruped) modelQuadruped).leg1;
	}

	@Override
	protected void setModelQuadrupedLeg1(Object modelQuadruped, Object modelRenderer) {
		((ModelQuadruped) modelQuadruped).leg1 = (ModelRenderer) modelRenderer;
	}

	@Override
	protected Object modelCreeperLeg1(Object modelCreeper) {
		return ((ModelCreeper) modelCreeper).leg1;
	}

	@Override
	protected void setModelCreeperLeg1(Object modelCreeper, Object modelRenderer) {
		((ModelCreeper) modelCreeper).leg1 = (ModelRenderer) modelRenderer;
	}

	@Override
	protected Object modelChickenRightWing(Object modelChicken) {
		return ((ModelChicken) modelChicken).rightWing;
	}

	@Override
	protected void setModelChickenRightWing(Object modelChicken, Object modelRenderer) {
		((ModelChicken) modelChicken).rightWing = (ModelRenderer) modelRenderer;
	}

	@Override
	protected void renderEngineDeleteTexture(Object renderEngine, Object resourceLocation) {
		TextureObject textureObject = ((TextureManager) renderEngine).getTexture((ResourceLocation) resourceLocation);
		if (textureObject != null) GL11.glDeleteTextures(textureObject.getGlTextureId());
	}

	@Override
	protected String resourceLocationGetResourceDomain(Object resourceLocation) {
		return ((ResourceLocation) resourceLocation).getResourceDomain();
	}

	@Override
	protected String resourceLocationGetResourcePath(Object resourceLocation) {
		return ((ResourceLocation) resourceLocation).getResourcePath();
	}

	@Override
	protected int scaledresolutionGetScaleFactor(Object scaledresolution) {
		return ((ScaledResolution) scaledresolution).getScaleFactor();
	}

	@Override
	protected int scaledresolutionGetScaledWidth(Object scaledresolution) {
		return ((ScaledResolution) scaledresolution).getScaledWidth();
	}

	@Override
	protected int scaledresolutionGetScaledHeight(Object scaledresolution) {
		return ((ScaledResolution) scaledresolution).getScaledHeight();
	}

	@Override
	protected void framebufferBindFramebuffer(Object framebuffer, boolean b) {
	}

	@Override
	protected void framebufferUnbindFramebuffer(Object framebuffer) {
	}

	@Override
	protected void framebufferFramebufferRender(Object framebuffer, int i, int i1) {
	}

	@Override
	protected boolean gameSettingsAnaglyph(Object gameSettings) {
		return ((GameSettings) gameSettings).anaglyph;
	}

	@Override
	protected void tessellatorAddVertex(Object tessellator, double d, double d2, double d3) {
		((Tessellator) tessellator).addVertex(d, d2, d3);
	}

	@Override
	protected float mathHelperFloor_float(float f) {
		return MathHelper.floor_float(f);
	}

	@Override
	protected long mathHelperFloor_double_long(double d) {
		return MathHelper.floor_double_long(d);
	}

	@Override
	protected float mathHelperAbs(float f) {
		return MathHelper.abs(f);
	}

	@Override
	protected double mathHelperAbs_max(double d, double d1) {
		return MathHelper.abs_max(d, d1);
	}

	@Override
	protected int mathHelperBucketInt(int i, int j) {
		return MathHelper.bucketInt(i, j);
	}

	@Override
	protected boolean mathHelperStringNullOrLengthZero(String s) {
		return MathHelper.stringNullOrLengthZero(s);
	}

	@Override
	protected double mathHelperSqrt_double(double d) {
		return MathHelper.sqrt_double(d);
	}

	@Override
	protected void tileEntitySkullRendererRenderSkull(Object skullRenderer, float f, float f1, float f2, Enum en, float f3, int i, Object gameProfile, int i2) {
		((TileEntitySkullRenderer) skullRenderer).func_82393_a(f, f1, f2, i, f3, i2, Modchu_CastHelper.String(gameProfile));
	}

	@Override
	protected Object getBipedArmor(Object entityPlayer, Object itemStack, int i, int i2, String s) {
		if (Modchu_Main.isServer) return null;
		Item item = (Item) itemStackGetItem(itemStack);
		if (item instanceof ItemArmor) {
			int renderIndex = itemArmorRenderIndex(item);
			String[] armorFilename = renderBipedBipedArmorFilenamePrefix();
			String a1 = renderIndex < armorFilename.length ? armorFilename[renderIndex] : armorFilename[armorFilename.length - 1];
			return RenderBiped.func_110858_a((ItemArmor)item, i, s);
		}
		return null;
	}

	@Override
	protected int[] facingOffsetsXForSide() {
		return Facing.offsetsXForSide;
	}

	@Override
	protected int[] facingOffsetsYForSide() {
		return Facing.offsetsYForSide;
	}

	@Override
	protected int[] facingOffsetsZForSide() {
		return Facing.offsetsZForSide;
	}

	@Override
	protected boolean itemStackHasDisplayName(Object itemstack) {
		return ((ItemStack) itemstack).hasDisplayName();
	}

	@Override
	protected void entitySetCustomNameTag(Object entity, String s) {
		((EntityLiving) entity).setCustomNameTag(s);
	}

	@Override
	protected String itemStackGetDisplayName(Object itemstack) {
		return ((ItemStack) itemstack).getDisplayName();
	}

	@Override
	protected Enum movingObjectPositionTypeOfHit(Object movingObjectPosition) {
		return ((MovingObjectPosition) movingObjectPosition).typeOfHit;
	}

	@Override
	protected Enum movingObjectPositionMovingObjectTypeMISS(Object movingObjectPosition) {
		return null;
	}

	@Override
	protected Enum movingObjectPositionMovingObjectTypeBLOCK(Object movingObjectPosition) {
		return null;
	}

	@Override
	protected Enum movingObjectPositionMovingObjectTypeENTITY(Object movingObjectPosition) {
		return ((MovingObjectPosition) movingObjectPosition).typeOfHit.ENTITY;
	}

	@Override
	protected boolean worldIsBlockModifiable(Object worldOrEntity, Object entityPlayer, int x, int y, int z) {
		return ((World) worldOrEntity).canMineBlock((EntityPlayer)entityPlayer, x, y, z);
	}

	@Override
	protected int movingObjectPositionSideHit(Object movingObjectPosition) {
		return ((MovingObjectPosition) movingObjectPosition).sideHit;
	}

	@Override
	protected boolean entityPlayerCanPlayerEdit(Object entityplayer, int x, int y, int z, int i, Object itemStack) {
		return ((EntityPlayer) entityplayer).canPlayerEdit(x, y, z, i, (ItemStack) itemStack);
	}

	@Override
	protected Object entityPlayerMPPlayerNetServerHandler(Object entityplayerMP) {
		return ((EntityPlayerMP) entityplayerMP).playerNetServerHandler;
	}

	@Override
	protected void setEntityPlayerMPPlayerNetServerHandler(Object entityplayerMP, Object netHandlerPlayServer) {
		((EntityPlayerMP) entityplayerMP).playerNetServerHandler = (NetServerHandler) netHandlerPlayServer;
	}

	@Override
	protected void entitySetLocationAndAngles(Object entity, double x, double y, double z, float f, float f1) {
		((Entity) entity).setLocationAndAngles(x, y, z, f, f1);
	}

	@Override
	protected float mathHelperWrapAngleTo180_float(float f) {
		return MathHelper.wrapAngleTo180_float(f);
	}

	@Override
	protected float blockPosGetX(Object blockPos) {
		return 0.0F;
	}

	@Override
	protected float blockPosGetY(Object blockPos) {
		return 0.0F;
	}

	@Override
	protected float blockPosGetZ(Object blockPos) {
		return 0.0F;
	}

	@Override
	protected Object iBlockStateGetBlock(Object iBlockState) {
		return iBlockState;
	}

	@Override
	protected int worldGetBlockStateGetBlockMetadata(Object worldOrEntity, int x, int y, int z) {
		return ((World) entityWorldObj(worldOrEntity)).getBlockMetadata(x, y, z);
	}

	@Override
	protected int tileEntityXCoord(Object tileEntity) {
		return ((TileEntity) tileEntity).xCoord;
	}

	@Override
	protected int tileEntityYCoord(Object tileEntity) {
		return ((TileEntity) tileEntity).yCoord;
	}

	@Override
	protected int tileEntityZCoord(Object tileEntity) {
		return ((TileEntity) tileEntity).zCoord;
	}

	@Override
	protected Object newBlockPos(Object x, Object y, Object z) {
		return null;
	}

	@Override
	protected Object worldGetBlockState(Object worldOrEntity, Object blockPos) {
		return null;
	}

	@Override
	protected int worldGetStrongPower(Object worldOrEntity, int x, int y, int z) {
		return ((World) entityWorldObj(worldOrEntity)).getBlockPowerInput(x, y, z);
	}

	@Override
	protected Object containerGetSlot(Object container, int i) {
		return ((Container) container).getSlot(i);
	}

	@Override
	protected Object slotGetStack(Object slot) {
		return ((Slot) slot).getStack();
	}

	@Override
	protected Object containerInventoryItemStacks(Object container) {
		return ((Container) container).inventoryItemStacks;
	}

	@Override
	protected Object pathNavigateTryMoveToXYZ(Object pathNavigate, int x, int y, int z, float f) {
		return ((PathNavigate) pathNavigate).tryMoveToXYZ(x, y, z, f);
	}

	@Override
	protected Object worldGetEntityByID(Object worldOrEntity, int i) {
		return ((World) entityWorldObj(worldOrEntity)).getEntityByID(i);
	}

	@Override
	protected Object entityLivingBaseGetLook(Object entityLivingBase, float f) {
		return ((EntityLivingBase) entityLivingBase).getLook(f);
	}

	@Override
	protected Object vec3AddVector(Object vec3, double d, double d2, double d3) {
		return ((Vec3) vec3).addVector(d, d2, d3);
	}

	@Override
	protected List worldGetEntitiesWithinAABBExcludingEntity(Object worldOrEntity, Object entity, Object axisAlignedBB) {
		return ((World) entityWorldObj(worldOrEntity)).getEntitiesWithinAABBExcludingEntity((Entity) entity, (AxisAlignedBB) axisAlignedBB);
	}

	@Override
	protected Object entityGetBoundingBox(Object entity) {
		return ((Entity) entity).getBoundingBox();
	}

	@Override
	protected boolean entityCanBeCollidedWith(Object entity) {
		return ((Entity) entity).canBeCollidedWith();
	}

	@Override
	protected float entityGetCollisionBorderSize(Object entity) {
		return ((Entity) entity).getCollisionBorderSize();
	}

	@Override
	protected Object axisAlignedBBCalculateIntercept(Object axisAlignedBB, Object vec3, Object vec3_2) {
		return ((AxisAlignedBB) axisAlignedBB).calculateIntercept((Vec3) vec3, (Vec3) vec3_2);
	}

	@Override
	protected boolean axisAlignedBBIsVecInside(Object axisAlignedBB, Object vec3) {
		return ((AxisAlignedBB) axisAlignedBB).isVecInside((Vec3) vec3);
	}

	@Override
	protected Object movingObjectPositionHitVec(Object movingObjectPosition) {
		return ((MovingObjectPosition) movingObjectPosition).hitVec;
	}

	@Override
	protected double vec3SquareDistanceTo(Object vec3, Object vec3_2) {
		return ((Vec3) vec3).squareDistanceTo((Vec3) vec3_2);
	}

	@Override
	protected List itemPotionGetEffects(Object itemPotion, Object itemStack) {
		return ((ItemPotion) itemPotion).getEffects((ItemStack) itemStack);
	}

	@Override
	protected Multimap itemStackGetAttributeModifiers(Object itemStack) {
		return ((ItemStack) itemStack).getAttributeModifiers();
	}

	@Override
	protected Object sharedMonsterAttributesAttackDamage() {
		return SharedMonsterAttributes.attackDamage;
	}

	@Override
	protected String iAttributeGetAttributeUnlocalizedName(Object iAttribute) {
		return null;
	}

	@Override
	protected double attributeModifierGetAmount(Object attributeModifier) {
		return ((AttributeModifier) attributeModifier).getAmount();
	}

	@Override
	protected Object itemArmorGetArmorMaterial(Object itemArmor) {
		return ((ItemArmor) itemArmor).getArmorMaterial();
	}

	@Override
	protected String itemArmorArmorMaterialGetName(Object armorMaterial) {
		return null;
	}

	@Override
	protected void loadingScreenDisplayLoadingString(Object loadingScreenRenderer, String s) {
		((LoadingScreenRenderer) loadingScreenRenderer).resetProgresAndWorkingMessage(s);
	}

	@Override
	protected void loadingScreenResetProgressAndMessage(Object loadingScreenRenderer, String s) {
		((LoadingScreenRenderer) loadingScreenRenderer).resetProgressAndMessage(s);
	}

	@Override
	protected void loadingScreenSetLoadingProgress(Object loadingScreenRenderer, int i) {
		((LoadingScreenRenderer) loadingScreenRenderer).setLoadingProgress(i);
	}

	@Override
	protected void openGlHelperGlBlendFunc(int i, int i1, int i2, int i3) {
	}

	@Override
	protected Object vec3CreateVectorHelper(double d, double d2, double d3) {
		return Vec3.createVectorHelper(d, d2, d3);
	}

	@Override
	protected void guiScreenFunc_175273_b(Object guiScreen, Object minecraft, int i, int i2) {
	}

	@Override
	protected Enum itemCameraTransformsTransformTypeNONE() {
		return null;
	}

	@Override
	protected Enum itemCameraTransformsTransformTypeTHIRD_PERSON() {
		return null;
	}

	@Override
	protected Enum itemCameraTransformsTransformTypeFIRST_PERSON() {
		return null;
	}

	@Override
	protected Enum itemCameraTransformsTransformTypeHEAD() {
		return null;
	}

	@Override
	protected Enum itemCameraTransformsTransformTypeGUI() {
		return null;
	}

	@Override
	protected Object entityPlayerFishEntity(Object entityplayer) {
		return ((EntityPlayer) entityplayer).fishEntity;
	}

	@Override
	protected void setEntityPlayerFishEntity(Object entityplayer, Object entityFishHook) {
		((EntityPlayer) entityplayer).fishEntity = (EntityFishHook) entityFishHook;
	}

	@Override
	protected boolean entityZombieIsVillager(Object entityZombie) {
		return ((EntityZombie) entityZombie).isVillager();
	}

	@Override
	protected void entityZombieSetVillager(Object entityZombie, boolean b) {
		((EntityZombie) entityZombie).setVillager(b);
	}

	@Override
	protected Object tileEntitySkullUpdateGameprofile(Object gameprofile) {
		return null;
	}

	@Override
	protected Object nBTUtilWriteGameProfile(Object nBTTagCompound, Object gameprofile) {
		return nBTTagCompound;
	}

	@Override
	protected void nbtTagCompoundSetTag(Object nBTTagCompound, String s, Object nbtBase) {
		((NBTTagCompound) nBTTagCompound).setTag(s, (NBTBase) nbtBase);
	}

	@Override
	protected Enum enumFacingUP() {
		return EnumFacing.UP;
	}

	@Override
	protected Enum enumFacingDOWN() {
		return EnumFacing.DOWN;
	}

	@Override
	protected Enum enumFacingEAST() {
		return EnumFacing.EAST;
	}

	@Override
	protected Enum enumFacingNORTH() {
		return EnumFacing.NORTH;
	}

	@Override
	protected Enum enumFacingSOUTH() {
		return EnumFacing.SOUTH;
	}

	@Override
	protected Enum enumFacingWEST() {
		return EnumFacing.WEST;
	}

	@Override
	protected int itemStackGetMetadata(Object itemstack) {
		return -1;
	}

	@Override
	protected Object minecraftGetBlockRendererDispatcher() {
		return null;
	}

	@Override
	protected Object textureMapLocationBlocksTexture() {
		return null;
	}

	@Override
	protected Object blockGetDefaultState(Object blockOrIBlockState) {
		return null;
	}

	@Override
	protected void blockRendererDispatcherRenderBlockBrightness(Object blockRendererDispatcher, Object iBlockState, float f) {
	}

	@Override
	protected Object iBlockStateWithProperty(Object blockOrIBlockState, Object iProperty, Comparable comparable) {
		return null;
	}

	@Override
	protected Object blockDoublePlantVARIANT() {
		return null;
	}

	@Override
	protected Object blockDoublePlantHALF() {
		return null;
	}

	@Override
	protected int blockGetMetaFromState(Object block, Object iBlockState) {
		return -1;
	}

	@Override
	protected Object abstractClientPlayerLocationSkin(Object entity) {
		return ((AbstractClientPlayer) entity).getLocationSkin();
	}

	@Override
	protected int itemGetMetadata(Object item, int i) {
		return ((Item) item).getMetadata(i);
	}

	@Override
	protected int blockColorMultiplier(Object block, Object iBlockAccess, Object blockPos, int i) {
		return -1;
	}

	@Override
	protected int textureUtilAnaglyphColor(int i) {
		return -1;
	}

	@Override
	protected Object blockGetStateFromMeta(Object block, int i) {
		return null;
	}

	@Override
	protected Object blockRendererDispatcherGetBlockModelRenderer(Object blockRendererDispatcher) {
		return null;
	}

	@Override
	protected void blockModelRendererRenderModelBrightness(Object blockModelRenderer, Object iBakedModel, Object iBlockState, float f, boolean b) {
	}

	@Override
	protected String abstractClientPlayerGetSkinType(Object abstractClientPlayer) {
		return null;
	}

	@Override
	protected void setEntityTicksExisted(Object entity, int i) {
		((Entity) entity).ticksExisted = i;
	}

	@Override
	protected Object worldGetBiomeGenForCoords(Object worldOrEntity, int i, int i1) {
		return ((World) entityWorldObj(worldOrEntity)).getBiomeGenForCoords(i, i1);
	}

	@Override
	protected List worldGetEntitiesWithinAABB(Object worldOrEntity, Class c, Object axisAlignedBB) {
		return ((World) entityWorldObj(worldOrEntity)).getEntitiesWithinAABB(c, (AxisAlignedBB) axisAlignedBB);
	}

	@Override
	protected void entityTameableSetOwner(Object entityTameable, String s) {
		((EntityTameable) entityTameable).setOwner(s);
	}

	@Override
	protected boolean worldSpawnEntityInWorld(Object worldOrEntity, Object entity) {
		return ((World) entityWorldObj(worldOrEntity)).spawnEntityInWorld((Entity) entity);
	}

	@Override
	protected Object worldGetClosestPlayerToEntity(Object worldOrEntity, Object entity, double d) {
		return ((World) entityWorldObj(worldOrEntity)).getClosestPlayerToEntity((Entity) entity, d);
	}

	@Override
	protected Object minecraftGetRenderItem() {
		return null;
	}

	@Override
	protected Object renderItemGetItemModelMesher(Object renderItem) {
		return null;
	}

	@Override
	protected Object newModelResourceLocation(String s, String s1) {
		return null;
	}

	@Override
	protected void itemModelMesherRegister(Object itemModelMesher, Object item, int i, Object modelResourceLocation) {
	}

	@Override
	protected void pathNavigateGroundFunc_179690_a(Object pathNavigateGround, boolean b) {
		((PathNavigate) pathNavigateGround).setAvoidsWater(b);
	}

	@Override
	protected void entityAITasksAddTask(Object entityAITasks, int i, Object entityAIBase) {
		((EntityAITasks) entityAITasks).addTask(i, (EntityAIBase) entityAIBase);
	}

	@Override
	protected void entityOnUpdate(Object entity) {
		((Entity) entity).onUpdate();
	}

	@Override
	protected void entityPlayerPreparePlayerToSpawn(Object entityplayer) {
		((EntityPlayer) entityplayer).preparePlayerToSpawn();
	}

	@Override
	protected Object entityClientPlayerMPSendQueue(Object entityClientPlayerMP) {
		return ((EntityClientPlayerMP) entityClientPlayerMP).sendQueue;
	}

	@Override
	protected void netClientHandlerHandleClientCommand(Object netClientHandler, Object packet205ClientCommand) {
		((NetClientHandler) netClientHandler).handleClientCommand((Packet205ClientCommand) packet205ClientCommand);
	}

	@Override
	protected void worldRemoveEntity(Object world, Object entity) {
		((World) world).removeEntity((Entity) entity);
	}

	@Override
	protected String entityClientPlayerMPFunc_142021_k(Object entityClientPlayerMP) {
		return ((EntityClientPlayerMP) entityClientPlayerMP).func_142021_k();
	}

	@Override
	protected void entityClientPlayerMPFunc_142020_c(Object entityClientPlayerMP, String s) {
		((EntityClientPlayerMP) entityClientPlayerMP).func_142020_c(s);
	}

	@Override
	protected Object minecraftServerGetConfigurationManager(Object minecraftServer) {
		return ((MinecraftServer) minecraftServer).getConfigurationManager();
	}

	@Override
	protected Object serverConfigurationManagerRespawnPlayer(Object serverConfigurationManager, Object entityPlayerMP, int i, boolean b) {
		return ((ServerConfigurationManager) serverConfigurationManager).respawnPlayer((EntityPlayerMP) entityPlayerMP, i, b);
	}

	@Override
	protected void setEntityDimension(Object entity, int i) {
		((Entity) entity).dimension = i;
	}

	@Override
	protected Object minecraftGetIntegratedServer() {
		if (Modchu_Main.isServer) return null;
		return Minecraft.getMinecraft().getIntegratedServer();
	}

}
