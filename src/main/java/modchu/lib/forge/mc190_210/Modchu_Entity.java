package modchu.lib.forge.mc190_210;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntity;
import modchu.lib.Modchu_IEntityMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.CommandResultStats.Type;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.scoreboard.Team;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
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
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;

public abstract class Modchu_Entity extends Entity implements Modchu_IEntity {
	public Modchu_IEntityMaster master;
	protected ConcurrentHashMap<String, DataParameter> dataParameterMap = new ConcurrentHashMap();
	public float maxHealth;

	public Modchu_Entity(World world) {
		super(world);
	}

	public Modchu_Entity(HashMap<String, Object> map) {
		this((World) map.get("Object"));
		init(map);
	}

	@Override
	public ConcurrentHashMap getDataParameterMap() {
		return dataParameterMap;
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

	protected void init(HashMap<String, Object> map) {
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
	public int getEntityId() {
		return master != null ? master.getEntityId() : super.getEntityId();
	}

	@Override
	public int superGetEntityId() {
		return super.getEntityId();
	}

	@Override
	public void setEntityId(int p_145769_1_) {
		if (master != null) master.setEntityId(p_145769_1_);
		else super.setEntityId(p_145769_1_);
	}

	@Override
	public void superSetEntityId(int p_145769_1_) {
		super.setEntityId(p_145769_1_);
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
		if (master != null) master.setAngles(p_70082_1_, p_70082_2_);
		else super.setAngles(p_70082_1_, p_70082_2_);
	}

	@Override
	public void superSetAngles(float p_70082_1_, float p_70082_2_) {
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
	protected SoundEvent getSwimSound() {
		return (SoundEvent) (master != null ? master.getSwimSound() : super.getSwimSound());
	}

	@Override
	public Object superGetSwimSound() {
		return super.getSwimSound();
	}

	@Override
	public void playSound(SoundEvent soundEvent, float p_85030_2_, float p_85030_3_) {
		if (master != null) master.playSound(soundEvent, p_85030_2_, p_85030_3_);
		else super.playSound(soundEvent, p_85030_2_, p_85030_3_);
	}

	@Override
	public void superPlaySound(Object soundEvent, float p_85030_2_, float p_85030_3_) {
		super.playSound((SoundEvent) soundEvent, p_85030_2_, p_85030_3_);
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
	public AxisAlignedBB getCollisionBoundingBox() {
		return (AxisAlignedBB) (master != null ? master.getCollisionBoundingBox() : super.getCollisionBoundingBox());
	}

	@Override
	public AxisAlignedBB superGetCollisionBoundingBox() {
		return super.getCollisionBoundingBox();
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
	protected SoundEvent getSplashSound() {
		return (SoundEvent) (master != null ? master.getSplashSound() : super.getSplashSound());
	}

	@Override
	public Object superGetSplashSound() {
		return super.getSplashSound();
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
	public boolean isInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
		return master != null ? master.isInRangeToRender3d(p_145770_1_, p_145770_3_, p_145770_5_) : super.isInRangeToRender3d(p_145770_1_, p_145770_3_, p_145770_5_);
	}

	@Override
	public boolean superIsInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
		return super.isInRangeToRender3d(p_145770_1_, p_145770_3_, p_145770_5_);
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
	public EntityItem dropItem(Item item, int p_145779_2_) {
		return (EntityItem) (master != null ? master.dropItem(item, p_145779_2_) : super.dropItem(item, p_145779_2_));
	}

	@Override
	public EntityItem superDropItem(Object item, int p_145779_2_) {
		return super.dropItem((Item) item, p_145779_2_);
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
	public boolean startRiding(Entity entity) {
		return master != null ? master.startRiding(entity) : super.startRiding(entity);
	}

	@Override
	public boolean superStartRiding(Object entity) {
		return super.startRiding((Entity) entity);
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
	public Vec3d getLookVec() {
		return (Vec3d) (master != null ? master.getLookVec() : super.getLookVec());
	}

	@Override
	public Vec3d superGetLookVec() {
		return super.getLookVec();
	}

	@Override
	public void setPortal(BlockPos blockPos) {
		if (master != null) master.setPortal(blockPos);
		else super.setPortal(blockPos);
	}

	@Override
	public void superSetPortal(Object blockPos) {
		super.setPortal((BlockPos) blockPos);
	}

	public void superSetInPortal() {
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
	public void handleStatusUpdate(byte p_70103_1_) {
		if (master != null) master.handleStatusUpdate(p_70103_1_);
		else super.handleStatusUpdate(p_70103_1_);
	}

	@Override
	public void superHandleStatusUpdate(byte p_70103_1_) {
		super.handleStatusUpdate(p_70103_1_);
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
	public Vec3d getLastPortalVec() {
		return (Vec3d) (master != null ? master.getLastPortalVec() : super.getLastPortalVec());
	}

	@Override
	public Object superGetLastPortalVec() {
		return super.getLastPortalVec();
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
	public ItemStack getPickedResult(RayTraceResult movingObjectPosition) {
		return (ItemStack) (master != null ? master.getPickedResult(movingObjectPosition) : super.getPickedResult(movingObjectPosition));
	}

	@Override
	public ItemStack superGetPickedResult(Object movingObjectPosition) {
		return super.getPickedResult((RayTraceResult) movingObjectPosition);
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
	// 190~
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
	public void updatePassenger(Entity entity) {
		if (master != null) master.updatePassenger(entity);
		else super.updatePassenger(entity);
	}

	@Override
	public void superUpdatePassenger(Object entity) {
		super.updatePassenger((Entity) entity);
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
	public void dismountRidingEntity() {
		if (master != null) master.dismountRidingEntity();
		else super.dismountRidingEntity();
	}

	@Override
	public void superDismountRidingEntity() {
		super.dismountRidingEntity();
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
	public Iterable<ItemStack> getHeldEquipment() {
		return (Iterable<ItemStack>) (master != null ? master.getHeldEquipment() : super.getHeldEquipment());
	}

	@Override
	public Iterable<ItemStack> superGetHeldEquipment() {
		return super.getHeldEquipment();
	}

	@Override
	public Iterable<ItemStack> getArmorInventoryList() {
		return (Iterable<ItemStack>) (master != null ? master.getArmorInventoryList() : super.getArmorInventoryList());
	}

	@Override
	public Iterable<ItemStack> superGetArmorInventoryList() {
		return super.getArmorInventoryList();
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
	public void setItemStackToSlot(EntityEquipmentSlot entityEquipmentSlot, ItemStack itemStack) {
		if (master != null) master.setItemStackToSlot(entityEquipmentSlot, itemStack);
		else super.setItemStackToSlot(entityEquipmentSlot, itemStack);
	}

	@Override
	public void superSetItemStackToSlot(Object entityEquipmentSlot, Object itemStack) {
		super.setItemStackToSlot((EntityEquipmentSlot) entityEquipmentSlot, (ItemStack) itemStack);
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
	public Team getTeam() {
		return (Team) (master != null ? master.getTeam() : super.getTeam());
	}

	@Override
	public Team superGetTeam() {
		return super.getTeam();
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
	public boolean isOnScoreboardTeam(Team team) {
		return master != null ? master.isOnScoreboardTeam(team) : super.isOnScoreboardTeam(team);
	}

	@Override
	public boolean superIsOnScoreboardTeam(Object team) {
		return super.isOnScoreboardTeam((Team) team);
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
	public void setUniqueId(UUID uniqueIdIn) {
		if (master != null) master.setUniqueId(uniqueIdIn);
		else super.setUniqueId(uniqueIdIn);
	}

	@Override
	public void superSetUniqueId(UUID uniqueIdIn) {
		super.setUniqueId(uniqueIdIn);
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

	@Override
	public SoundCategory getSoundCategory() {
		return (SoundCategory) (master != null ? master.getSoundCategory() : super.getSoundCategory());
	}

	@Override
	public SoundCategory superGetSoundCategory() {
		return super.getSoundCategory();
	}
	// 180~
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
	protected void updateFallState(double p_180433_1_, boolean p_180433_3_, IBlockState iBlockState, BlockPos blockPos) {
		if (master != null) master.updateFallState(p_180433_1_, p_180433_3_, iBlockState, blockPos);
		else super.updateFallState(p_180433_1_, p_180433_3_, iBlockState, blockPos);
	}

	@Override
	public void superUpdateFallState(double p_180433_1_, boolean p_180433_3_, Object iBlockState, Object blockPos) {
		super.updateFallState(p_180433_1_, p_180433_3_, (IBlockState) iBlockState, (BlockPos) blockPos);
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
	public boolean isInLava() {
		return master != null ? master.isInLava() : super.isInLava();
	}

	@Override
	public boolean superIsInLava() {
		return super.isInLava();
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
	public Vec3d getLook(float p_70676_1_) {
		return (Vec3d) (master != null ? master.getLook(p_70676_1_) : super.getLook(p_70676_1_));
	}

	@Override
	public Object superGetLook(float p_70676_1_) {
		return super.getLook(p_70676_1_);
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
	public EntityItem dropItemWithOffset(Item item, int size, float p_145778_3_) {
		return (EntityItem) (master != null ? master.dropItemWithOffset(item, size, p_145778_3_) : super.dropItemWithOffset(item, size, p_145778_3_));
	}

	@Override
	public EntityItem superDropItemWithOffset(Object item, int size, float p_145778_3_) {
		return super.dropItemWithOffset((Item) item, size, p_145778_3_);
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
	public String getName() {
		return master != null ? master.getName() : super.getName();
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
	public ITextComponent getDisplayName() {
		return (ITextComponent) (master != null ? master.getDisplayName() : super.getDisplayName());
	}

	@Override
	public Object superGetDisplayName() {
		return super.getDisplayName();
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
	public boolean getAlwaysRenderNameTagForRender() {
		return master != null ? master.getAlwaysRenderNameTagForRender() : super.getAlwaysRenderNameTagForRender();
	}

	@Override
	public boolean superGetAlwaysRenderNameTagForRender() {
		return super.getAlwaysRenderNameTagForRender();
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
	public boolean replaceItemInInventory(int p_174820_1_, ItemStack itemStack) {
		return master != null ? master.replaceItemInInventory(p_174820_1_, itemStack) : super.replaceItemInInventory(p_174820_1_, itemStack);
	}

	@Override
	public boolean superReplaceItemInInventory(int p_174820_1_, Object itemStack) {
		return super.replaceItemInInventory(p_174820_1_, (ItemStack) itemStack);
	}

	@Override
	public void addChatMessage(ITextComponent iTextComponent) {
		if (master != null) master.addChatMessage(iTextComponent);
		else super.addChatMessage(iTextComponent);
	}

	@Override
	public void superAddChatMessage(Object iChatComponent) {
		super.addChatMessage((ITextComponent) iChatComponent);
	}

	@Override
	public boolean canCommandSenderUseCommand(int permLevel, String commandName) {
		return master != null ? master.canCommandSenderUseCommand(permLevel, commandName) : super.canCommandSenderUseCommand(permLevel, commandName);
	}

	@Override
	public boolean superCanCommandSenderUseCommand(int permLevel, String commandName) {
		return super.canCommandSenderUseCommand(permLevel, commandName);
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
	public boolean sendCommandFeedback() {
		return master != null ? master.sendCommandFeedback() : super.sendCommandFeedback();
	}

	@Override
	public boolean superSendCommandFeedback() {
		return super.sendCommandFeedback();
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
	// ~164
	@Override
	public boolean superIsInRangeToRender3d(Object vec3) {
		return false;
	}

	@Override
	public float superGetBlockExplosionResistance(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return 0;
	}

	@Override
	public boolean superShouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, Object par6, float par7) {
		return false;
	}

	@Override
	public String superGetTranslatedEntityName() {
		return null;
	}
	// ~179
	@Override
	public void superFunc_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Object block) {
	}

	@Override
	public void superUpdateFallState(double p_70064_1_, boolean p_70064_3_) {
	}

	@Override
	public void superFall(float p_70069_1_) {
	}

	@Override
	public boolean superIsNotColliding() {
		return false;
	}

	@Override
	public float superGetShadowSize() {
		return 0.0F;
	}

	@Override
	public void superSetPositionAndRotationDirect(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {
	}

	@Override
	public ItemStack[] superGetLastActiveItems() {
		return null;
	}

	@Override
	public String superGetName() {
		return null;
	}

	@Override
	public boolean superIsEntityInvulnerable() {
		return false;
	}

	@Override
	public void superCopyDataFrom(Object entity, boolean p_82141_2_) {
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
	public int superGetMaxSafePointTries() {
		return -1;
	}
	// ~152
	@Override
	public boolean superAttackEntityFrom(Object damageSource, int par2) {
		return false;
	}

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
	public boolean superInteract(Object entityPlayer) {
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
	// ~189
	public void updateRiderPosition() {
	}

	public void setCurrentItemOrArmor(int p_70062_1_, ItemStack itemStack) {
	}

	@Override
	public void superSetItemStackToSlot(int p_70062_1_, Object itemStack) {
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

	public void onDataWatcherUpdate(int p_145781_1_) {
	}

	@Override
	public void superOnDataWatcherUpdate(int p_145781_1_) {
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

	public ItemStack[] getInventory() {
		return null;
	}

	@Override
	public ItemStack[] superGetInventory() {
		return null;
	}

	public void copyDataFromOld(Entity entity) {
	}

	@Override
	public void superCopyDataFromOld(Object entity) {
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
	// ~189
	@Override
	public boolean superProcessInitialInteract(Object entityPlayer) {
		return false;
	}

	@Override
	public void superInit() {
	}

	@Override
	public void superSetMaxHealth(Object floatOrInt) {
		maxHealth = (Float) floatOrInt;
	}

	@Override
	public void superUpdatePassenger() {
	}

	@Override
	public Object superGetTeleportDirection() {
		return super.getTeleportDirection();
	}

	@Override
	public void superPlayStepSound(int par1, int par2, int par3, Object par4) {
		super.playStepSound((BlockPos) Modchu_AS.get(Modchu_AS.newBlockPos, par1, par2, par3), (Block) par4);
	}

	@Override
	public boolean superInteractFirst(Object entityPlayer) {
		return false;
	}

	@Override
	public void superSetCurrentItemOrArmor(int p_70062_1_, Object itemStack) {
	}

}
