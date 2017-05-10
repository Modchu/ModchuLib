package modchu.lib.forge.mc164;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_DataWatcherMaster2;
import modchu.lib.Modchu_IEntity;
import modchu.lib.Modchu_IEntityMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class Modchu_Entity extends Entity implements Modchu_IEntity {
	public Modchu_IEntityMaster master;
	public float maxHealth;
	public boolean initFlag;
	public int dataWatcherWatchableObjectIdFirst;
	public int dataWatcherWatchableObjectIdCount = 6;

	public Modchu_Entity(World world) {
		super(world);
		init((HashMap)null);
	}

	public Modchu_Entity(HashMap<String, Object> map) {
		this((World) map.get("Object"));
		init(map);
	}

	@Override
	public boolean isInitFlag() {
		return initFlag;
	}

	@Override
	public void setInitFlag(boolean b) {
		initFlag = b;
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
	public int getDataWatcherWatchableObjectIdFirst() {
		return dataWatcherWatchableObjectIdFirst;
	}

	@Override
	public void setDataWatcherWatchableObjectIdFirst(int i) {
		dataWatcherWatchableObjectIdFirst = i;
	}

	@Override
	public void dataParameterMapSetting(HashMap<Integer, Object> map) {
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
		return 5;
	}

	@Override
	public void setDataWatcherWatchableObjectIdCount(int i) {
	}

	protected void init(HashMap<String, Object> map) {
		dataWatcher = (DataWatcher) Modchu_Main.newModchuCharacteristicObject("Modchu_DataWatcher", Modchu_DataWatcherMaster2.class, this, dataWatcher);
		if (map != null
				&& !map.isEmpty()); else {
			return;
		}
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		master = instance instanceof Modchu_IEntityMaster ? (Modchu_IEntityMaster) instance : null;
		//Modchu_Debug.mDebug("Modchu_Entity init master="+master);
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
	public Object getFreeVariable(String s) {
		return master.getFreeVariable(s);
	}

	@Override
	public Object superGetFreeVariable(String s) {
		return null;
	}

	@Override
	public void setFreeVariable(String s, Object o) {
		master.setFreeVariable(s, o);
	}

	@Override
	public void superSetFreeVariable(String s, Object o) {
	}

	@Override
	protected void entityInit() {
		if (master != null) master.entityInit();
	}

	@Override
	public void superEntityInit() {
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.readEntityFromNBT(nBTTagCompound);
	}

	@Override
	public void superReadEntityFromNBT(Object nBTTagCompound) {
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.writeEntityToNBT(nBTTagCompound);
	}

	@Override
	public void superWriteEntityToNBT(Object nBTTagCompound) {
	}

	@Override
	public DataWatcher getDataWatcher() {
		return (DataWatcher) (master != null ? master.getDataManager() : super.getDataWatcher());
	}

	@Override
	public DataWatcher superGetDataManager() {
		return super.getDataWatcher();
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
	protected void preparePlayerToSpawn() {
		if (master != null) master.preparePlayerToSpawn();
		else super.preparePlayerToSpawn();
	}

	@Override
	public void superPreparePlayerToSpawn() {
		super.preparePlayerToSpawn();
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
	public void onUpdate() {
		if (master != null) master.onUpdate();
		else super.onUpdate();
	}

	@Override
	public void superOnUpdate() {
		super.onUpdate();
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
	public int getMaxInPortalTime() {
		return master != null ? master.getMaxInPortalTime() : super.getMaxInPortalTime();
	}

	@Override
	public int superGetMaxInPortalTime() {
		return super.getMaxInPortalTime();
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
	protected void kill() {
		if (master != null) master.kill();
		else super.kill();
	}

	@Override
	public void superKill() {
		super.kill();
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
	protected boolean canTriggerWalking() {
		return master != null ? master.canTriggerWalking() : super.canTriggerWalking();
	}

	@Override
	public boolean superCanTriggerWalking() {
		return super.canTriggerWalking();
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
	protected void fall(float p_70069_1_) {
		if (master != null) master.fall(p_70069_1_);
		else super.fall(p_70069_1_);
	}

	@Override
	public void superFall(float p_70069_1_) {
		super.fall(p_70069_1_);
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
	public float getEyeHeight() {
		return master != null ? master.getEyeHeight() : super.getEyeHeight();
	}

	@Override
	public float superGetEyeHeight() {
		return super.getEyeHeight();
	}

	@Override
	public boolean handleLavaMovement() {
		return master != null ? master.handleLavaMovement() : super.handleLavaMovement();
	}

	@Override
	public boolean superIsNotColliding() {
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
	public boolean attackEntityFrom(DamageSource damageSource, float p_70097_2_) {
		return master != null ? master.attackEntityFrom(damageSource, p_70097_2_) : super.attackEntityFrom(damageSource, p_70097_2_);
	}

	@Override
	public boolean superAttackEntityFrom(Object damageSource, Object p_70097_2_) {
		return super.attackEntityFrom((DamageSource) damageSource, (Float) p_70097_2_);
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
	public void addToPlayerScore(Entity entity, int p_70084_2_) {
		if (master != null) master.addToPlayerScore(entity, p_70084_2_);
		else super.addToPlayerScore(entity, p_70084_2_);
	}

	@Override
	public void superAddToPlayerScore(Object entity, int p_70084_2_) {
		super.addToPlayerScore((Entity) entity, p_70084_2_);
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

	@Override
	public EntityItem entityDropItem(ItemStack itemStack, float p_70099_2_) {
		return (EntityItem) (master != null ? master.entityDropItem(itemStack, p_70099_2_) : super.entityDropItem(itemStack, p_70099_2_));
	}

	@Override
	public EntityItem superEntityDropItem(Object itemStack, float p_70099_2_) {
		return super.entityDropItem((ItemStack) itemStack, p_70099_2_);
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
	public boolean isEntityAlive() {
		return master != null ? master.isEntityAlive() : super.isEntityAlive();
	}

	@Override
	public boolean superIsEntityAlive() {
		return super.isEntityAlive();
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
	public void updateRidden() {
		if (master != null) master.updateRidden();
		else super.updateRidden();
	}

	@Override
	public void superUpdateRidden() {
		super.updateRidden();
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
	public double getYOffset() {
		return master != null ? master.getYOffset() : super.getYOffset();
	}

	@Override
	public double superGetYOffset() {
		return super.getYOffset();
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
	public void setPositionAndRotation2(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {
		if (master != null) master.setPositionAndRotationDirect(p_70056_1_, p_70056_3_, p_70056_5_, p_70056_7_, p_70056_8_, p_70056_9_);
		else super.setPositionAndRotation2(p_70056_1_, p_70056_3_, p_70056_5_, p_70056_7_, p_70056_8_, p_70056_9_);
	}

	@Override
	public void superSetPositionAndRotationDirect(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {
		super.setPositionAndRotation2(p_70056_1_, p_70056_3_, p_70056_5_, p_70056_7_, p_70056_8_, p_70056_9_);
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
	public Vec3 getLookVec() {
		return (Vec3) (master != null ? master.getLookVec() : super.getLookVec());
	}

	@Override
	public Vec3 superGetLookVec() {
		return super.getLookVec();
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
	public int getPortalCooldown() {
		return master != null ? master.getPortalCooldown() : super.getPortalCooldown();
	}

	@Override
	public int superGetPortalCooldown() {
		return super.getPortalCooldown();
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
	public void handleHealthUpdate(byte p_70103_1_) {
		if (master != null) master.handleStatusUpdate(p_70103_1_);
		else super.handleHealthUpdate(p_70103_1_);
	}

	@Override
	public void superHandleStatusUpdate(byte p_70103_1_) {
		super.handleHealthUpdate(p_70103_1_);
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
	public ItemStack[] getLastActiveItems() {
		return (ItemStack[]) (master != null ? master.getLastActiveItems() : super.getLastActiveItems());
	}

	@Override
	public ItemStack[] superGetLastActiveItems() {
		return super.getLastActiveItems();
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
	public void setSprinting(boolean p_70031_1_) {
		if (master != null) master.setSprinting(p_70031_1_);
		else super.setSprinting(p_70031_1_);
	}

	@Override
	public void superSetSprinting(boolean p_70031_1_) {
		super.setSprinting(p_70031_1_);
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
	public boolean isInvisibleToPlayer(EntityPlayer entityPlayer) {
		return master != null ? master.isInvisibleToPlayer(entityPlayer) : super.isInvisibleToPlayer(entityPlayer);
	}

	@Override
	public boolean superIsInvisibleToPlayer(Object entityPlayer) {
		return super.isInvisibleToPlayer((EntityPlayer) entityPlayer);
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

	@Override
	public boolean isPushedByWater() {
		return master != null ? master.isPushedByWater() : super.isPushedByWater();
	}

	@Override
	public boolean superIsPushedByWater() {
		return super.isPushedByWater();
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
	public EntityItem superDropItem(Object item, int p_145779_2_) {
		return super.dropItem((Integer) item, p_145779_2_);
	}

	@Override
	public boolean superAttackEntityFrom(Object damageSource, int par2) {
		return super.attackEntityFrom((DamageSource) damageSource, par2);
	}

	@Override
	public void superPlayStepSound(Object blockPos, Object block) {
	}

	@Override
	public void superUpdateFallState(double p_180433_1_, boolean p_180433_3_, Object block, Object blockPos) {
	}

	@Override
	public void superFall(float distance, float damageMultiplier) {
		super.fall(distance);
	}

	@Override
	public double superGetDistanceSq(Object blockPos) {
		return 0.0F;
	}

	@Override
	public Object superGetLook(float p_70676_1_) {
		return 0.0F;
	}

	@Override
	public Object superRayTrace(double p_174822_1_, float p_174822_3_) {
		return null;
	}

	@Override
	public Object superDropItemWithOffset(Object item, int size, float p_145778_3_) {
		return super.dropItemWithOffset((Integer) item, size, p_145778_3_);
	}

	@Override
	public void superSetPositionAndRotationDirect(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
		super.setPositionAndRotation2(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_);
	}

	@Override
	public boolean superIsEntityInvulnerable(Object damageSource) {
		return super.isEntityInvulnerable();
	}

	@Override
	public void superSetPositionAndUpdate(double x, double y, double z) {
	}

	@Override
	public boolean superGetAlwaysRenderNameTagForRender() {
		return false;
	}

	@Override
	public Object superGetPosition() {
		return null;
	}

	@Override
	public boolean superEquals(Object p_equals_1_) {
		return super.equals(p_equals_1_);
	}

	@Override
	public int superHashCode() {
		return super.hashCode();
	}

	@Override
	public Object superGetTeam() {
		return null;
	}

	@Override
	public boolean superIsOnSameTeam(Object entity) {
		return false;
	}

	@Override
	public void superSetCustomNameTag(String p_96094_1_) {
	}

	@Override
	public String superGetCustomNameTag() {
		return null;
	}

	@Override
	public void superSetAlwaysRenderNameTag(boolean p_174805_1_) {
	}

	@Override
	public boolean superGetAlwaysRenderNameTag() {
		return false;
	}
	// ~164
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
	protected void playStepSound(int par1, int par2, int par3, int par4) {
		if (master != null) master.playStepSound(par1, par2, par3, par4);
		else super.playStepSound(par1, par2, par3, par4);
	}

	@Override
	public boolean isInRangeToRenderVec3D(Vec3 vec3) {
		return master != null ? master.isInRangeToRender3d(vec3) : super.isInRangeToRenderVec3D(vec3);
	}

	@Override
	public boolean superIsInRangeToRender3d(Object vec3) {
		return super.isInRangeToRenderVec3D((Vec3) vec3);
	}

	@Override
	public EntityItem dropItem(int par1, int par2) {
		return (EntityItem) (master != null ? master.dropItem(par1, par2) : super.dropItem(par1, par2));
	}

	@Override
	public EntityItem dropItemWithOffset(int par1, int par2, float par3) {
		return (EntityItem) (master != null ? master.dropItemWithOffset(par1, par2, par3) : super.dropItemWithOffset(par1, par2, par3));
	}

	@Override
	protected boolean pushOutOfBlocks(double par1, double par3, double par5) {
		return master != null ? master.pushOutOfBlocks(par1, par3, par5) : super.pushOutOfBlocks(par1, par3, par5);
	}

	@Override
	public boolean superPushOutOfBlocks(double par1, double par3, double par5) {
		return super.pushOutOfBlocks(par1, par3, par5);
	}

	@Override
	public String getEntityName() {
		return master != null ? master.getName() : super.getEntityName();
	}

	@Override
	public String superGetName() {
		return super.getEntityName();
	}

	@Override
	public float getBlockExplosionResistance(Explosion explosion, World world, int par3, int par4, int par5, Block block) {
		return master != null ? master.getBlockExplosionResistance(explosion, world, par3, par4, par5, block) : super.getBlockExplosionResistance(explosion, world, par3, par4, par5, block);
	}

	@Override
	public float superGetBlockExplosionResistance(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return super.getBlockExplosionResistance((Explosion) explosion, (World) world, par3, par4, par5, (Block) block);
	}

	@Override
	public boolean shouldExplodeBlock(Explosion explosion, World world, int par3, int par4, int par5, int par6, float par7) {
		return master != null ? master.shouldExplodeBlock(explosion, world, par3, par4, par5, par6, par7) : super.shouldExplodeBlock(explosion, world, par3, par4, par5, par6, par7);
	}

	@Override
	public boolean superShouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, Object par6, float par7) {
		return super.shouldExplodeBlock((Explosion) explosion, (World) world, par3, par4, par5, (Integer) par6, par7);
	}

	@Override
	public String getTranslatedEntityName() {
		return master != null ? master.getTranslatedEntityName() : super.getTranslatedEntityName();
	}

	@Override
	public String superGetTranslatedEntityName() {
		return super.getTranslatedEntityName();
	}
	// 172~
	@Override
	public int superGetEntityId() {
		return entityId;
	}

	@Override
	public void superSetEntityId(int p_145769_1_) {
		entityId = p_145769_1_;
	}

	@Override
	public String superGetSwimSound() {
		return null;
	}

	@Override
	public void superFunc_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Object block) {
	}

	@Override
	public String superGetSplashSound() {
		return null;
	}

	@Override
	public boolean superIsInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
		return false;
	}

	@Override
	public float superFunc_145772_a(Object explosion, Object world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Object block) {
		return 0.0F;
	}

	@Override
	public boolean superFunc_145774_a(Object explosion, Object world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Object block, float p_145774_7_) {
		return false;
	}

	@Override
	public void superOnDataWatcherUpdate(int p_145781_1_) {
	}
	// ~152
	@Override
	public String superGetTexture() {
		return null;
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
	public void superUnmountEntity(Object entity) {
	}

	@Override
	public void superUpdateCloak() {
	}

	@Override
	public float superFunc_82146_a(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return 0.0F;
	}

	@Override
	public boolean superFunc_96091_a(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7) {
		return false;
	}
	// 180~
	@Override
	public void superOnKillCommand() {
	}

	@Override
	public boolean superIsSilent() {
		return false;
	}

	@Override
	public void superSetSilent(boolean isSilent) {
	}

	@Override
	public void superResetHeight() {
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
	public double superGetDistanceSqToCenter(Object blockPos) {
		return 0.0D;
	}

	@Override
	public Object superGetPositionEyes(float p_174824_1_) {
		return null;
	}

	@Override
	public Object[] superGetInventory() {
		return null;
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
	public Object superGetDisplayName() {
		return null;
	}

	@Override
	public boolean superHasCustomName() {
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
		return null;
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
	public boolean superReplaceItemInInventory(int p_174820_1_, Object itemStack) {
		return false;
	}

	@Override
	public void superSendMessage(Object iChatComponent) {
	}

	@Override
	public boolean superCanUseCommand(int permLevel, String commandName) {
		return false;
	}

	@Override
	public Object superGetPositionVector() {
		return null;
	}

	@Override
	public Object superGetEntityWorld() {
		return null;
	}

	@Override
	public Object superGetCommandSenderEntity() {
		return null;
	}

	@Override
	public boolean superSendCommandFeedback() {
		return false;
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
	// 190~
	@Override
	public void superSetItemStackToSlot(int p_70062_1_, Object itemStack) {
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
	public void superInit() {
	}

	@Override
	public void superSetMaxHealth(Object floatOrInt) {
		maxHealth = (Float) floatOrInt;
	}

	@Override
	public boolean superInteract(Object entityPlayer) {
		return super.interactFirst((EntityPlayer) entityPlayer);
	}

	@Override
	public void superPlayStepSound(int par1, int par2, int par3, Object par4) {
		super.playStepSound(par1, par2, par3, (Integer) par4);
	}

	@Override
	public boolean superInteractFirst(Object entityPlayer) {
		return super.interactFirst((EntityPlayer) entityPlayer);
	}

	@Override
	public Object superGetTeleportDirection() {
		return super.getTeleportDirection();
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
