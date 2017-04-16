package modchu.lib.forge.mc172_179;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_CastHelper;
import modchu.lib.Modchu_DataWatcherMaster2;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityTameable;
import modchu.lib.Modchu_IEntityTameableMaster;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.entity.ai.EntityJumpHelper;
import net.minecraft.entity.ai.EntityLookHelper;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.ai.EntitySenses;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.scoreboard.Team;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import scala.collection.mutable.StringBuilder;

public abstract class Modchu_EntityTameable extends EntityTameable implements Modchu_IEntityTameable {
	public Modchu_IEntityTameableMaster master;
	protected boolean initFlag;
	protected static boolean debugDead = false;
	public static ConcurrentHashMap<String, UUID> entityUniqueIDMap = new ConcurrentHashMap();
	protected HashMap<String, Object> tempInitMap;
	//protected CombatTracker combatTracker;
	protected int dataWatcherWatchableObjectIdFirst;
	private int dataWatcherWatchableObjectIdCount;
	private List entityDataManagerBooleanToByteList;

	public Modchu_EntityTameable(World world) {
		super(world);
		ignoreFrustumCheck = true;
		//if (world.isRemote) Modchu_Main.setRuntimeException("debug Modchu_EntityTameable");
		init((HashMap)null);
	}

	public Modchu_EntityTameable(HashMap<String, Object> map) {
		this((World) map.get("Object"));
		try {
			init(map);
		} catch(Exception e) {
			e.printStackTrace();
		} catch(Error e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean isOnLivingUpdateCancel() {
		return false;
	}

	@Override
	public boolean superIsOnLivingUpdateCancel() {
		return false;
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
		return dataWatcherWatchableObjectIdCount;
	}

	@Override
	public void setDataWatcherWatchableObjectIdCount(int i) {
		dataWatcherWatchableObjectIdCount = i;
	}

	public String thisToString() {
		return getClass().getName() + "@" + Integer.toHexString(java.lang.System.identityHashCode(this));
	}

	@Override
	public void entityDataManagerRegister(Class[] c1, int i, Object o) {
		if (o instanceof Boolean) {
			o = (Boolean) o ? (byte) 1 : (byte) 0;
			if (entityDataManagerBooleanToByteList != null); else entityDataManagerBooleanToByteList = new ArrayList();
			entityDataManagerBooleanToByteList.add(i);
		}
		dataWatcher.addObject(i, o);
	}

	@Override
	public Object getDataWatcherWatchableObject(int i) {
		Object watchedObject = Modchu_AS.get("DataWatcher", "getWatchedObject", new Class[]{ int.class }, dataWatcher, new Object[]{ i });
		if (watchedObject != null); else return null;
		Object o = Modchu_AS.get("net.minecraft.entity.DataWatcher$WatchableObject", "getObject", watchedObject);
		if (entityDataManagerBooleanToByteList != null
				&& entityDataManagerBooleanToByteList.contains(i)) {
			o = (Byte) o == (byte) 1 ? true : false;
		}
		return o;
	}

	@Override
	public void setDataWatcherWatchableObject(int i, Object o) {
		//Map watchedObjects = Modchu_AS.getMap("DataWatcher", "watchedObjects", dataWatcher);
		//if (watchedObjects.containsKey(i))
		if (entityDataManagerBooleanToByteList != null
				&& entityDataManagerBooleanToByteList.contains(i)) {
			o = (Boolean) o ? (byte) 1 : (byte) 0;
		}
		dataWatcher.updateObject(i, o);
		//else dataWatcher.addObject(i, o);
	}

	@Override
	public void setMovementSpeed(double d) {
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(d);
	}

	@Override
	public void setFollowRange(double d) {
		getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(d);
	}

	@Override
	public void setKnockbackResistance(double d) {
		getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(d);
	}

	@Override
	public void setAttackDamage(double d) {
		getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(d);
	}

	@Override
	public void setMaxHealth(double d) {
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(d);
	}

	public Object getMaster() {
		//Modchu_Debug.mDebug("getmasterEntity masterEntity="+masterEntity);
		if (master != null); else {
			init(getMasterClassName());
		}
		return master;
	}

	protected void init(String s) {
		if (s != null
				&& !s.isEmpty()); else return;
		Class c = Modchu_Reflect.loadClass(s);
		if (c != null); else return;
		HashMap<String, Object> map = Modchu_Main.getNewModchuCharacteristicMap(c);
		init(map);
	}

	protected void init(HashMap<String, Object> map) {
		boolean debug = false;
		if (map != null
				&& !map.isEmpty()); else {
			if (master != null) return;
			//Modchu_Debug.mDebug("Modchu_EntityTameable init isRemote="+worldObj.isRemote);
			//Class c = Modchu_Main.getSpownEntityClass(worldObj, posX, posY, posZ);
			Class c = getMasterClass();
			if (c != null); else {
				// TODO
				if (debug) {
					Modchu_Debug.mDebug1("Modchu_EntityTameable init map == null debug1 return isRemote="+worldObj.isRemote);
					//setDead();
					//Modchu_Main.setRuntimeException("init debug");
				}
				return;
			}
			map = new HashMap();
			map.put("Class", c);
			map.put("Object", worldObj);
		}
		if (map != null
				&& !map.isEmpty()
				&& map.containsKey("Class")); else {
			return;
		}
		if (!initFlag) {
			if (tempInitMap != null); else {
				tempInitMap = map;
			}
			return;
		}
		Class c = map.containsKey("Class") ? ((Class) map.get("Class")) : null;
		if (c != null); else return;
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		master = instance instanceof Modchu_IEntityTameableMaster ? (Modchu_IEntityTameableMaster) instance : null;
		if (master != null); else {
			if (debug) Modchu_Debug.mDebug("Modchu_EntityTameable init 4 master == null !!");
			return;
		}
		setMasterClassName(c.getName());
		master.entityInit();
		String s0 = new StringBuilder(Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, this) ? "1" : "0").append(entityUniqueID).toString();
		if (s0 != null
				&& entityUniqueIDMap.containsKey(s0)) {
			Modchu_Debug.mDebug("Modchu_EntityTameable init entityUniqueIDMap.containsKey isDead entityUniqueID="+entityUniqueID);
			Modchu_AS.set(Modchu_AS.entityLivingBaseSetHealth, this, 0.0F);
			deathTime = 20;
			setDead();
			return;
		}
		if (s0 != null) entityUniqueIDMap.put(s0, entityUniqueID);
		Modchu_Debug.mDebug("initNBTAfter entityUniqueID="+entityUniqueID);
		Modchu_Debug.mDebug("initNBTAfter masterEntity="+master);
	}

	private String getMasterClassName() {
		String s = Modchu_CastHelper.String(getDataWatcherWatchableObject(dataWatcherWatchableObjectIdFirst));
		//Modchu_Debug.mDebug("Modchu_EntityTameable getMasterClassName s="+s);
		return s;
	}

	private void setMasterClassName(String s) {
		Modchu_Debug.mDebug("Modchu_EntityTameable setMasterClassName s="+s);
		setDataWatcherWatchableObject(dataWatcherWatchableObjectIdFirst, s);
	}

	private Class getMasterClass() {
		String s = getMasterClassName();
		Modchu_Debug.mDebug("Modchu_EntityTameable getMasterClass() s="+s);
		return s != null
				&& !s.isEmpty() ? Modchu_Reflect.loadClass(s, -1) : null;
	}

	public static void worldEventLoad(Object event) {
		if (entityUniqueIDMap != null) entityUniqueIDMap.clear();
	}

	public boolean isAngry() {
		return master != null ? master.isAngry() : false;
	}

	public void setAngry(boolean flag) {
		if (master != null) master.setAngry(flag);
	}

	public int getTextureColor() {
		return master != null ? master.getTextureColor() : 0;
	}

	public void setTextureColor(int i) {
		if (master != null) master.setTextureColor(i);
	}

	public ResourceLocation getResourceLocation() {
		return master != null ? (ResourceLocation) master.getResourceLocation() : null;
	}

	public void setResourceLocation(ResourceLocation resourceLocation) {
		if (master != null) master.setResourceLocation(resourceLocation);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
		String entityName = getMasterClassName();
		if (entityName != null
				&& !entityName.isEmpty()) {
			nBTTagCompound.setString("entityName", entityName);
			if (master != null) master.writeEntityToNBT(nBTTagCompound);
			else super.writeEntityToNBT(nBTTagCompound);
		}
		//Modchu_Debug.mDebug("Modchu_EntityTameable writeEntityToNBT entityName="+entityName);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
		//Modchu_Debug.mDebug("Modchu_EntityTameable readEntityFromNBT entityName="+entityName);
		String s = nBTTagCompound.getString("entityName");
		Modchu_Debug.mDebug("Modchu_EntityTameable readEntityFromNBT isRemote="+worldObj.isRemote+" entityName s="+s);
		init(s);
		Modchu_Debug.mDebug("Modchu_EntityTameable readEntityFromNBT master.getClass()="+(master != null ? master.getClass() : null));
		if (master != null) master.readEntityFromNBT(nBTTagCompound);
		else super.readEntityFromNBT(nBTTagCompound);
	}

	@Override
	protected void playTameEffect(boolean par1) {
		if (master != null) master.playTameEffect(par1);
		else super.playTameEffect(par1);
	}

	@Override
	public void superPlayTameEffect(boolean par1) {
		super.playTameEffect(par1);
	}

	@Override
	public boolean isTamed() {
		return master != null ? master.isTamed() : super.isTamed();
	}

	@Override
	public boolean superIsTamed() {
		return super.isTamed();
	}

	@Override
	public void setTamed(boolean par1) {
		if (master != null) master.setTamed(par1);
		else super.setTamed(par1);
	}

	@Override
	public void superSetTamed(boolean par1) {
		super.setTamed(par1);
	}

	@Override
	public boolean isSitting() {
		return master != null ? master.isSitting() : super.isSitting();
	}

	@Override
	public boolean superIsSitting() {
		return super.isSitting();
	}

	@Override
	public void setSitting(boolean par1) {
		if (master != null) master.setSitting(par1);
		else super.setSitting(par1);
	}

	@Override
	public void superSetSitting(boolean par1) {
		super.setSitting(par1);
	}

	@Override
	public EntityAISit func_70907_r() {
		return (EntityAISit) (master != null ? master.getAISit() : super.func_70907_r());
	}

	@Override
	public EntityAISit superGetAISit() {
		return super.func_70907_r();
	}

	@Override
	public boolean func_142018_a(EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase1) {
		return master != null ? master.shouldAttackEntity(entityLivingBase, entityLivingBase1) : super.func_142018_a(entityLivingBase, entityLivingBase1);
	}

	@Override
	public boolean superShouldAttackEntity(Object entityLivingBase, Object entityLivingBase1) {
		return super.func_142018_a((EntityLivingBase) entityLivingBase, (EntityLivingBase) entityLivingBase1);
	}

	@Override
	public void onLivingUpdate() {
		//Modchu_Debug.mDebug("Modchu_EntityTameable onLivingUpdate master="+master);
		//Modchu_Debug.mDebug("Modchu_EntityTameable onLivingUpdate entityName="+entityName);
		//Modchu_Debug.mDebug("Modchu_EntityTameable onLivingUpdate posX="+posX+" posY="+posY+" posZ="+posZ);
		if (master != null); else {
			Modchu_Debug.mDebug("Modchu_EntityTameable onLivingUpdate this="+this);
			Modchu_Debug.mDebug("Modchu_EntityTameable onLivingUpdate master="+master);
			String entityName = getMasterClassName();
			Modchu_Debug.mDebug("Modchu_EntityTameable onLivingUpdate entityName="+entityName);
			init(entityName);
			if (master != null); else {
				setDead();
			}
		}
		if (master != null) master.onLivingUpdate();
		else super.onLivingUpdate();
	}

	@Override
	public boolean getCanSpawnHere() {
		return master != null ? master.getCanSpawnHere() : super.getCanSpawnHere();
	}

	@Override
	public int getTalkInterval() {
		return master != null ? master.getTalkInterval() : super.getTalkInterval();
	}

	@Override
	protected boolean canDespawn() {
		return master != null ? master.canDespawn() : super.canDespawn();
	}

	@Override
	public boolean isBreedingItem(ItemStack itemStack) {
		return master != null ? master.isBreedingItem(itemStack) : super.isBreedingItem(itemStack);
	}

	@Override
	public boolean superIsBreedingItem(Object itemStack) {
		return super.isBreedingItem((ItemStack) itemStack);
	}

	@Override
	public boolean interact(EntityPlayer entityPlayer) {
		return master != null ? master.processInteract(entityPlayer) : super.interact(entityPlayer);
	}

	@Override
	public boolean superInteract(Object entityPlayer) {
		return super.interact((EntityPlayer) entityPlayer);
	}

	@Override
	public boolean isInLove() {
		return master != null ? master.isInLove() : super.isInLove();
	}

	@Override
	public boolean superIsInLove() {
		return super.isInLove();
	}

	@Override
	public void resetInLove() {
		if (master != null) master.resetInLove();
		else super.resetInLove();
	}

	@Override
	public void superResetInLove() {
		super.resetInLove();
	}

	@Override
	public boolean canMateWith(EntityAnimal entityAnimal) {
		return master != null ? master.canMateWith(entityAnimal) : super.canMateWith(entityAnimal);
	}

	@Override
	public boolean superCanMateWith(Object entityAnimal) {
		return super.canMateWith((EntityAnimal) entityAnimal);
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entityAgeable) {
		return (EntityAgeable) (master != null ? master.createChild(entityAgeable) : null);
	}

	@Override
	public int getGrowingAge() {
		return master != null ? master.getGrowingAge() : super.getGrowingAge();
	}

	@Override
	public int superGetGrowingAge() {
		return super.getGrowingAge();
	}

	@Override
	public void addGrowth(int par1) {
		if (master != null) master.addGrowth(par1);
		else super.addGrowth(par1);
	}

	@Override
	public void superAddGrowth(int par1) {
		super.addGrowth(par1);
	}

	@Override
	public void setGrowingAge(int par1) {
		if (master != null) master.setGrowingAge(par1);
		else super.setGrowingAge(par1);
	}

	@Override
	public void superSetGrowingAge(int par1) {
		super.setGrowingAge(par1);
	}

	@Override
	public void setScaleForAge(boolean par1) {
		if (master != null) master.setScaleForAge(par1);
		else super.setScaleForAge(par1);
	}

	@Override
	public void superSetScaleForAge(boolean par1) {
		super.setScaleForAge(par1);
	}

	@Override
	public boolean hasPath() {
		return master != null ? master.hasPath() : super.hasPath();
	}

	@Override
	public boolean superHasPath() {
		return super.hasPath();
	}

	@Override
	public void detachHome() {
		if (master != null) master.detachHome();
		else super.detachHome();
	}

	@Override
	public boolean hasHome() {
		return master != null ? master.hasHome() : super.hasHome();
	}

	@Override
	protected void func_142017_o(float par1) {
		if (master != null) master.onLeashDistance(par1);
		else super.func_142017_o(par1);
	}

	@Override
	public void superOnLeashDistance(float par1) {
		super.func_142017_o(par1);
	}

	@Override
	public EntityLookHelper getLookHelper() {
		return (EntityLookHelper) (master != null ? master.getLookHelper() : super.getLookHelper());
	}

	@Override
	public EntityMoveHelper getMoveHelper() {
		return (EntityMoveHelper) (master != null ? master.getMoveHelper() : super.getMoveHelper());
	}

	@Override
	public EntityJumpHelper getJumpHelper() {
		return (EntityJumpHelper) (master != null ? master.getJumpHelper() : super.getJumpHelper());
	}

	@Override
	public PathNavigate getNavigator() {
		return (PathNavigate) (master != null ? master.getNavigator() : super.getNavigator());
	}

	@Override
	public EntitySenses getEntitySenses() {
		return (EntitySenses) (master != null ? master.getEntitySenses() : super.getEntitySenses());
	}

	@Override
	public EntityLivingBase getAttackTarget() {
		return (EntityLivingBase) (master != null ? master.getAttackTarget() : super.getAttackTarget());
	}

	@Override
	public void setAttackTarget(EntityLivingBase entityLivingBase) {
		if (master != null) master.setAttackTarget(entityLivingBase);
		else super.setAttackTarget(entityLivingBase);
	}

	@Override
	public boolean canAttackClass(Class c) {
		return master != null ? master.canAttackClass(c) : super.canAttackClass(c);
	}

	@Override
	public void eatGrassBonus() {
		if (master != null) master.eatGrassBonus();
		else super.eatGrassBonus();
	}

	@Override
	public void playLivingSound() {
		if (master != null) master.playLivingSound();
		else super.playLivingSound();
	}

	@Override
	public void spawnExplosionParticle() {
		if (master != null) master.spawnExplosionParticle();
		else super.spawnExplosionParticle();
	}

	@Override
	protected String getLivingSound() {
		return (String) (master != null ? master.getLivingSound() : super.getLivingSound());
	}

	@Override
	public void setMoveForward(float par1) {
		if (master != null) master.setMoveForward(par1);
		else super.setMoveForward(par1);
	}

	@Override
	protected void despawnEntity() {
		if (master != null) master.despawnEntity();
		else super.despawnEntity();
	}

	@Override
	protected void updateAITasks() {
		if (master != null) master.updateAITasks();
		else super.updateAITasks();
	}

	@Override
	public int getVerticalFaceSpeed() {
		return master != null ? master.getVerticalFaceSpeed() : super.getVerticalFaceSpeed();
	}

	@Override
	public void faceEntity(Entity entity, float par2, float par3) {
		if (master != null) master.faceEntity(entity, par2, par3);
		else super.faceEntity(entity, par2, par3);
	}

	@Override
	public float getRenderSizeModifier() {
		return master != null ? master.getRenderSizeModifier() : super.getRenderSizeModifier();
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return master != null ? master.getMaxSpawnedInChunk() : super.getMaxSpawnedInChunk();
	}

	@Override
	public boolean canBeSteered() {
		return master != null ? master.canBeSteered() : super.canBeSteered();
	}

	@Override
	public void setEquipmentDropChance(int par1, float par2) {
		if (master != null) master.setDropChance(par1, par2);
		else super.setEquipmentDropChance(par1, par2);
	}

	@Override
	public void superSetDropChance(Object par1, float par2) {
		super.setEquipmentDropChance((Integer) par1, par2);
	}

	@Override
	public boolean canPickUpLoot() {
		return master != null ? master.canPickUpLoot() : super.canPickUpLoot();
	}

	@Override
	public void setCanPickUpLoot(boolean par1) {
		if (master != null) master.setCanPickUpLoot(par1);
		else super.setCanPickUpLoot(par1);
	}

	@Override
	public boolean isNoDespawnRequired() {
		return master != null ? master.isNoDespawnRequired() : super.isNoDespawnRequired();
	}

	@Override
	public void clearLeashed(boolean par1, boolean par2) {
		if (master != null) master.clearLeashed(par1, par2);
		else super.clearLeashed(par1, par2);
	}

	@Override
	public void superClearLeashed(boolean par1, boolean par2) {
		super.clearLeashed(par1, par2);
	}

	@Override
	public boolean allowLeashing() {
		return master != null ? master.canBeLeashedTo() : super.allowLeashing();
	}

	@Override
	public boolean superCanBeLeashedTo() {
		return super.allowLeashing();
	}

	@Override
	public boolean getLeashed() {
		return master != null ? master.getLeashed() : super.getLeashed();
	}

	@Override
	public boolean superGetLeashed() {
		return super.getLeashed();
	}

	@Override
	public Entity getLeashedToEntity() {
		return (Entity) (master != null ? master.getLeashedToEntity() : super.getLeashedToEntity());
	}

	@Override
	public Entity superGetLeashedToEntity() {
		return super.getLeashedToEntity();
	}

	@Override
	public void setLeashedToEntity(Entity entity, boolean par2) {
		if (master != null) master.setLeashedToEntity(entity, par2);
		else super.setLeashedToEntity(entity, par2);
	}

	@Override
	public void superSetLeashedToEntity(Object entity, boolean par2) {
		super.setLeashedToEntity((Entity) entity, par2);
	}

	@Override
	public void superOnDeath(Object damageSource) {
		super.onDeath((DamageSource) damageSource);
	}

	@Override
	public void superDamageEntity(Object damageSource, Object par2) {
		super.damageEntity((DamageSource) damageSource, (Float) par2);
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData iEntityLivingData) {
		return (IEntityLivingData) (master != null ? master.onInitialSpawn(iEntityLivingData) : super.onSpawnWithEgg(iEntityLivingData));
	}

	@Override
	public IEntityLivingData superOnInitialSpawn(Object iEntityLivingData) {
		return super.onSpawnWithEgg((IEntityLivingData) iEntityLivingData);
	}

	@Override
	public String superGetAmbientSound() {
		return null;
	}

	@Override
	public Object superOnSpawnWithEgg(Object entityLivingData) {
		return super.onSpawnWithEgg((IEntityLivingData) entityLivingData);
	}

	@Override
	public boolean superAllowLeashing() {
		return super.allowLeashing();
	}

	@Override
	public Object superGetCurrentItemOrArmor(int par1) {
		return null;
	}

	@Override
	public void superInit() {
	}

	@Override
	public void superSetMaxHealth(Object floatOrInt) {
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(Modchu_CastHelper.Double(floatOrInt, 0.0D, false));
	}

	@Override
	public boolean superProcessInteract(Object entityPlayer) {
		return super.interact((EntityPlayer) entityPlayer);
	}
	@Override
	public ChunkCoordinates getHomePosition() {
		return (ChunkCoordinates) (master != null ? master.getHomePosition() : super.getHomePosition());
	}

	public void superFunc_145775_I() {
		super.func_145775_I();
	}

	@Override
	public boolean superInteractFirst(Object entityPlayer) {
		return super.interactFirst((EntityPlayer) entityPlayer);
	}

	@Override
	public Object superGetOwner() {
		return super.getOwner();
	}

	@Override
	public float superGetBlockPathWeight(Object blockPos) {
		return 0.0F;
	}

	@Override
	public void superUpdateLeashedState() {
		super.updateLeashedState();
	}

	@Override
	public Object superGetDropItem() {
		return super.getDropItem();
	}

	@Override
	public String superGetCommandSenderName() {
		return super.getCommandSenderName();
	}

	@Override
	public boolean superHasCustomNameTag() {
		return super.hasCustomNameTag();
	}

	@Override
	public String superFunc_146067_o(int p_146067_1_) {
		return super.func_146067_o(p_146067_1_);
	}

	@Override
	public void superCopyDataFrom(Object entity) {
		super.copyDataFrom((Entity) entity, true);
	}

	@Override
	public Object superGetLookHelper() {
		return super.getLookHelper();
	}

	@Override
	public Object superGetMoveHelper() {
		return super.getMoveHelper();
	}

	@Override
	public Object superGetJumpHelper() {
		return super.getJumpHelper();
	}

	@Override
	public Object superGetNavigator() {
		return super.getNavigator();
	}

	@Override
	public Object superGetEntitySenses() {
		return super.getEntitySenses();
	}

	@Override
	public Object superGetAttackTarget() {
		return super.getAttackTarget();
	}

	@Override
	public void superSetAttackTarget(Object entityLiving) {
		super.setAttackTarget((EntityLivingBase) entityLiving);
	}

	@Override
	public boolean superCanAttackClass(Class par1Class) {
		return super.canAttackClass(par1Class);
	}

	@Override
	public void superEatGrassBonus() {
		super.eatGrassBonus();
	}

	@Override
	public boolean superIsWithinHomeDistanceCurrentPosition() {
		return super.isWithinHomeDistanceCurrentPosition();
	}

	@Override
	public Object superGetHomePosition() {
		return super.getHomePosition();
	}

	@Override
	public void superDetachHome() {
		super.detachHome();
	}

	@Override
	public boolean superHasHome() {
		return super.hasHome();
	}

	@Override
	public int superGetTalkInterval() {
		return super.getTalkInterval();
	}

	@Override
	public void superPlayLivingSound() {
		super.playLivingSound();
	}

	@Override
	public void superSpawnExplosionParticle() {
		super.spawnExplosionParticle();
	}

	@Override
	public void superDamageArmor(int par1) {
		super.damageArmor(par1);
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
		super.damageEntity((DamageSource) damageSource, par2);
	}

	@Override
	public void superKnockBack(Object entity, int par2, double par3, double par5) {
		super.knockBack((Entity) entity, par2, par3, par5);
	}

	@Override
	public void superSetMoveForward(float par1) {
		super.setMoveForward(par1);
	}

	@Override
	public boolean superCanDespawn() {
		return super.canDespawn();
	}

	@Override
	public void superDespawnEntity() {
		super.despawnEntity();
	}

	@Override
	public int superGetVerticalFaceSpeed() {
		return super.getVerticalFaceSpeed();
	}

	@Override
	public void superFaceEntity(Object entity, float par2, float par3) {
		super.faceEntity((Entity) entity, par2, par3);
	}

	@Override
	public boolean superGetCanSpawnHere() {
		return super.getCanSpawnHere();
	}

	@Override
	public float superGetRenderSizeModifier() {
		return super.getRenderSizeModifier();
	}

	@Override
	public int superGetMaxSpawnedInChunk() {
		return super.getMaxSpawnedInChunk();
	}

	@Override
	public void superOnChangedPotionEffect(Object potionEffect) {
		super.onChangedPotionEffect((PotionEffect) potionEffect, true);
	}

	@Override
	public boolean superCanBeSteered() {
		return super.canBeSteered();
	}

	@Override
	public boolean superCanPickUpLoot() {
		return super.canPickUpLoot();
	}

	@Override
	public void superSetCanPickUpLoot(boolean par1) {
		super.setCanPickUpLoot(par1);
	}

	@Override
	public void superUpdateAITasks() {
		super.updateAITasks();
	}

	@Override
	public void superAddRandomArmor() {
		super.addRandomArmor();
	}

	@Override
	public void superFunc_145781_i(int p_145781_1_) {
		super.func_145781_i(p_145781_1_);
	}

	@Override
	public boolean superIsNoDespawnRequired() {
		return super.isNoDespawnRequired();
	}

	@Override
	public void superRemovePotionEffect(Object potion) {
		super.removePotionEffect(((Potion) potion).getId());
	}

	@Override
	public Object superGetHeldItem(Object enumHand) {
		return super.getHeldItem();
	}

	@Override
	public void superReadEntityFromNBT(Object nBTTagCompound) {
		super.readEntityFromNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public void superWriteEntityToNBT(Object nBTTagCompound) {
		super.writeEntityToNBT((NBTTagCompound) nBTTagCompound);
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
	public boolean superIsInRangeToRender3d(Object vec3) {
		return true;
	}

	@Override
	public boolean superAttackEntityFrom(Object damageSource, int par2) {
		return super.attackEntityFrom((DamageSource) damageSource, par2);
	}

	@Override
	public void superUpdateFallState(double p_180433_1_, boolean p_180433_3_, Object block, Object blockPos) {
		super.updateFallState(p_180433_1_, p_180433_3_);
	}

	@Override
	public void superFall(float distance, float damageMultiplier) {
		super.fall(distance);
	}

	@Override
	public double superGetDistanceSq(Object blockPos) {
		return 0.0D;
	}

	@Override
	public Object superGetLook(float p_70676_1_) {
		return super.getLook(p_70676_1_);
	}

	@Override
	public Object superRayTrace(double p_174822_1_, float p_174822_3_) {
		return super.rayTrace(p_174822_1_, p_174822_3_);
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
	public void superSetCustomNameTag(String p_96094_1_) {
		super.setCustomNameTag(p_96094_1_);
	}

	@Override
	public String superGetCustomNameTag() {
		return super.getCustomNameTag();
	}

	@Override
	public void superSetAlwaysRenderNameTag(boolean p_174805_1_) {
		super.setAlwaysRenderNameTag(p_174805_1_);
	}

	@Override
	public boolean superGetAlwaysRenderNameTag() {
		return super.getAlwaysRenderNameTag();
	}

	@Override
	public void superSetPositionAndUpdate(double x, double y, double z) {
		super.setPositionAndUpdate(x, y, z);
	}

	@Override
	public boolean superGetAlwaysRenderNameTagForRender() {
		return super.getAlwaysRenderNameTagForRender();
	}

	@Override
	public Object superGetPosition() {
		return super.getPosition(1.0F);
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
		return super.getTeam();
	}

	@Override
	public boolean superIsOnSameTeam(Object entity) {
		return super.isOnSameTeam((EntityLivingBase) entity);
	}
	@Override
	public void attackEntity(Entity entity, float par2) {
		if (master != null) master.attackEntity(entity, par2);
		else super.attackEntity(entity, par2);
	}

	@Override
	public void superAttackEntity(Object entity, float par2) {
		super.attackEntity((Entity) entity, par2);
	}

	@Override
	public float getBlockPathWeight(int par1, int par2, int par3) {
		return master != null ? master.getBlockPathWeight(par1, par2, par3) : super.getBlockPathWeight(par1, par2, par3);
	}

	@Override
	public float superGetBlockPathWeight(int par1, int par2, int par3) {
		return super.getBlockPathWeight(par1, par2, par3);
	}

	@Override
	public Entity findPlayerToAttack() {
		return (Entity) (master != null ? master.findPlayerToAttack() : super.findPlayerToAttack());
	}

	@Override
	public Entity superFindPlayerToAttack() {
		return super.findPlayerToAttack();
	}

	@Override
	public boolean isMovementCeased() {
		return master != null ? master.isMovementCeased() : super.isMovementCeased();
	}

	@Override
	public boolean superIsMovementCeased() {
		return super.isMovementCeased();
	}

	@Override
	public void updateWanderPath() {
		if (master != null) master.updateWanderPath();
		else super.updateWanderPath();
	}

	@Override
	public void superUpdateWanderPath() {
		super.updateWanderPath();
	}

	@Override
	public void setPathToEntity(PathEntity pathEntity) {
		if (master != null) master.setPathToEntity(pathEntity);
		else super.setPathToEntity(pathEntity);
	}

	@Override
	public void superSetPathToEntity(Object pathEntity) {
		super.setPathToEntity((PathEntity) pathEntity);
	}

	@Override
	public Entity getEntityToAttack() {
		return (Entity) (master != null ? master.getEntityToAttack() : super.getEntityToAttack());
	}

	@Override
	public Entity superGetEntityToAttack() {
		return super.getEntityToAttack();
	}

	@Override
	public void setTarget(Entity entity) {
		if (master != null) master.setTarget(entity);
		else super.setTarget(entity);
	}

	@Override
	public void superSetTarget(Object entity) {
		super.setTarget((Entity) entity);
	}

	@Override
	public void setHomeArea(int par1, int par2, int par3, int par4) {
		if (master != null) master.setHomeArea(par1, par2, par3, par4);
		else super.setHomeArea(par1, par2, par3, par4);
	}

	@Override
	public void superSetHomeArea(int par1, int par2, int par3, int par4) {
		super.setHomeArea(par1, par2, par3, par4);
	}

	@Override
	public float func_110174_bM() {
		return master != null ? master.getMaximumHomeDistance() : super.func_110174_bM();
	}

	public float superFunc_110174_bM() {
		return super.func_110174_bM();
	}

	@Override
	public boolean isAIEnabled() {
		return master != null ? master.isAIEnabled() : super.isAIEnabled();
	}

	@Override
	public boolean superIsAIEnabled() {
		return super.isAIEnabled();
	}

	@Override
	public ItemStack func_130225_q(int par1) {
		return (ItemStack) (master != null ? master.func_130225_q(par1) : super.func_130225_q(par1));
	}

	@Override
	public void func_110163_bv() {
		if (master != null) master.enablePersistence();
		else super.func_110163_bv();
	}

	@Override
	public void enchantEquipment() {
		if (master != null) master.enchantEquipment();
		else super.enchantEquipment();
	}

	@Override
	public void superEnchantEquipment() {
		super.enchantEquipment();
	}

	@Override
	public int func_142015_aE() {
		return master != null ? master.getRevengeTimer() : super.func_142015_aE();
	}

	@Override
	public void dropRareDrop(int par1) {
		if (master != null) master.dropRareDrop(par1);
		else super.dropRareDrop(par1);
	}

	@Override
	public void superDropRareDrop(int par1) {
		super.dropRareDrop(par1);
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
	public boolean isClientWorld() {
		return master != null ? master.isClientWorld() : super.isClientWorld();
	}

	@Override
	public boolean superIsClientWorld() {
		return super.isClientWorld();
	}

	@Override
	public void func_146082_f(EntityPlayer entityPlayer) {
		if (master != null) master.setInLove(entityPlayer);
		else super.func_146082_f(entityPlayer);
	}

	@Override
	public boolean isWithinHomeDistance(int par1, int par2, int par3) {
		return master != null ? master.isWithinHomeDistance(par1, par2, par3) : super.isWithinHomeDistance(par1, par2, par3);
	}

	@Override
	public boolean superIsWithinHomeDistance(int par1, int par2, int par3) {
		return super.isWithinHomeDistance(par1, par2, par3);
	}

	@Override
	public IIcon getItemIcon(ItemStack itemStack, int par2) {
		return (IIcon) (master != null ? master.getItemIcon(itemStack, par2) : super.getItemIcon(itemStack, par2));
	}

	@Override
	public IIcon superGetItemIcon(Object itemStack, int par2) {
		return super.getItemIcon((ItemStack) itemStack, par2);
	}
	// ~162
	@Override
	public EntityLivingBase superFunc_130012_q() {
		return null;
	}

	@Override
	public void superFunc_110196_bT() {
	}

	@Override
	public boolean superFunc_110176_b(int par1, int par2, int par3) {
		return false;
	}

	@Override
	public int superGetHealthInt() {
		return (Integer) superGetHealth();
	}

	@Override
	public float superGetHealthFloat() {
		return super.getHealth();
	}

	@Override
	public void superSetupTamedAI() {
	}

	@Override
	public boolean superIsOwner(Object entityLivingBase) {
		return false;
	}

	@Override
	public void superConsumeItemFromStack(Object entityPlayer, Object itemStack) {
	}

	@Override
	public void superSetInLove(Object entityPlayer) {
	}

	@Override
	public Object superGetPlayerInLove() {
		return null;
	}

	@Override
	public void superAgeUp(int p_175501_1_, boolean p_175501_2_) {
	}

	@Override
	public void superOnGrowingAdult() {
	}

	@Override
	public boolean superIsWithinHomeDistanceFromPosition(Object blockPos) {
		return false;
	}

	@Override
	public void superSetHomePosAndDistance(Object blockPos, int distance) {
	}

	@Override
	public Object superCreateNavigator(Object world) {
		return null;
	}

	@Override
	public void superUpdateEquipmentIfNeeded(Object entityItem) {
	}

	@Override
	public boolean superCanEquipItem(Object itemStack) {
		return false;
	}

	@Override
	public void superSetEquipmentBasedOnDifficulty(Object difficultyInstance) {
	}

	@Override
	public void superSetEnchantmentBasedOnDifficulty(Object difficultyInstance) {
	}

	@Override
	public void superEnablePersistence() {
	}

	@Override
	public boolean superIsAIDisabled() {
		return false;
	}

	@Override
	public float superGetExplosionResistance(Object explosion, Object world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Object block) {
		return 0.0F;
	}

	@Override
	public String superFunc_152113_b() {
		return null;
	}

	@Override
	public void superFunc_152115_b(String par1Str) {
	}

	@Override
	public boolean superProcessInteract(Object entityPlayer, Object enumHand, Object itemStack) {
		return false;
	}

	@Override
	public boolean superCanBeLeashedTo(Object entityPlayer) {
		return false;
	}

	@Override
	public float superGetPathPriority(Object pathNodeType) {
		return 0.0F;
	}

	@Override
	public void superInitEntityAI() {
	}

	@Override
	public void superSetPathPriority(Object pathNodeType, float p_184644_2_) {
	}

	@Override
	public Object superCreateBodyHelper() {
		return null;
	}

	@Override
	public Object superGetLootTable() {
		return null;
	}

	@Override
	public void superSetMoveStrafing(float p_184646_1_) {
	}

	@Override
	public int superGetHorizontalFaceSpeed() {
		return -1;
	}

	@Override
	public Object superGetPrimaryHand() {
		return null;
	}

	@Override
	public void superSetLeftHanded(boolean p_184641_1_) {
	}

	@Override
	public boolean superIsLeftHanded() {
		return false;
	}

	@Override
	public Object superGetCombatTracker() {
		return super.func_110142_aN();
	}
	// 190~
	@Override
	public int superGetRevengeTimer() {
		return -1;
	}

	@Override
	public boolean superCanDropLoot() {
		return false;
	}

	@Override
	public void superUpdatePotionMetadata() {
	}

	@Override
	public void superResetPotionEffectMetadata() {
	}

	@Override
	public float superGetJumpUpwardsMotion() {
		return 0.0F;
	}

	@Override
	public void superHandleJumpLava() {
	}

	@Override
	public void superSendEnterCombat() {
	}

	@Override
	public void superSendEndCombat() {
	}

	@Override
	public void superMarkPotionsDirty() {
	}

	@Override
	public Object superOnInitialSpawn(Object difficultyInstance, Object iEntityLivingData) {
		return null;
	}

	@Override
	public void superDropLoot() {
	}
	// TODO Modchu_EntityLivingBase のコピー↓（からのエラー対処有り）
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
	public boolean canBreatheUnderwater() {
		return master != null ? master.canBreatheUnderwater() : super.canBreatheUnderwater();
	}

	@Override
	public boolean superCanBreatheUnderwater() {
		return super.canBreatheUnderwater();
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
	protected int decreaseAirSupply(int par1) {
		return master != null ? master.decreaseAirSupply(par1) : super.decreaseAirSupply(par1);
	}

	@Override
	public int superDecreaseAirSupply(int par1) {
		return super.decreaseAirSupply(par1);
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
	public boolean isPotionActive(int par1) {
		return master != null ? master.isPotionActive(par1) : super.isPotionActive(par1);
	}

	@Override
	public boolean superIsPotionActive(int par1) {
		return super.isPotionActive(par1);
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
	public void removePotionEffectClient(int par1) {
		if (master != null) master.removePotionEffectClient(par1);
		else super.removePotionEffectClient(par1);
	}

	@Override
	public void superRemovePotionEffectClient(int par1) {
		super.removePotionEffectClient(par1);
	}

	@Override
	public void removePotionEffect(int par1) {
		if (master != null) master.removePotionEffect(par1);
		else super.removePotionEffect(par1);
	}

	@Override
	public void superRemovePotionEffect(int par1) {
		super.removePotionEffect(par1);
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
	protected void onChangedPotionEffect(PotionEffect potionEffect, boolean par2) {
		if (master != null) master.onChangedPotionEffect(potionEffect, par2);
		else super.onChangedPotionEffect(potionEffect, par2);
	}

	@Override
	public void superOnChangedPotionEffect(Object potionEffect, boolean par2) {
		super.onChangedPotionEffect((PotionEffect) potionEffect, par2);
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
	public void heal(float par1) {
		if (master != null) master.heal(par1);
		else super.heal(par1);
	}

	public void superHeal(float par1) {
		super.heal(par1);
	}

	@Override
	public void setHealth(float par1) {
		if (worldObj != null); else return;
		if (master != null) master.setHealth(par1);
		else super.setHealth(par1);
	}

	public void superSetHealth(float par1) {
		super.setHealth(par1);
	}

	public boolean superAttackEntityFrom(Object damageSource, float par2) {
		return super.attackEntityFrom((DamageSource) damageSource, par2);
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
	public void onDeath(DamageSource damageSource) {
		if (master != null) master.onDeath(damageSource);
		else super.onDeath(damageSource);
	}

	@Override
	protected void dropEquipment(boolean par1, int par2) {
		if (master != null) master.dropEquipment(par1, par2);
		else super.dropEquipment(par1, par2);
	}

	@Override
	public void superDropEquipment(boolean par1, int par2) {
		super.dropEquipment(par1, par2);
	}

	@Override
	public void knockBack(Entity entity, float par2, double par3, double par5) {
		if (master != null) master.knockBack(entity, par2, par3, par5);
		else super.knockBack(entity, par2, par3, par5);
	}

	@Override
	public void superKnockBack(Object entity, float par2, double par3, double par5) {
		super.knockBack((Entity) entity, par2, par3, par5);
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
	protected void dropFewItems(boolean par1, int par2) {
		if (master != null) master.dropFewItems(par1, par2);
		else super.dropFewItems(par1, par2);
	}

	@Override
	public void superDropFewItems(boolean par1, int par2) {
		super.dropFewItems(par1, par2);
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
	public int getTotalArmorValue() {
		return master != null ? master.getTotalArmorValue() : super.getTotalArmorValue();
	}

	@Override
	public int superGetTotalArmorValue() {
		return super.getTotalArmorValue();
	}

	@Override
	protected void damageArmor(float par1) {
		if (master != null) master.damageArmor(par1);
		else super.damageArmor(par1);
	}

	@Override
	public void superDamageArmor(float par1) {
		super.damageArmor(par1);
	}

	@Override
	protected float applyArmorCalculations(DamageSource damageSource, float par2) {
		return (Float) (master != null ? master.applyArmorCalculations(damageSource, par2) : super.applyArmorCalculations(damageSource, par2));
	}

	@Override
	public Object superApplyArmorCalculations(Object damageSource, float par2) {
		return super.applyArmorCalculations((DamageSource) damageSource, par2);
	}

	@Override
	protected float applyPotionDamageCalculations(DamageSource damageSource, float par2) {
		return (Float) (master != null ? master.applyPotionDamageCalculations(damageSource, par2) : super.applyPotionDamageCalculations(damageSource, par2));
	}

	@Override
	public Object superApplyPotionDamageCalculations(Object damageSource, float par2) {
		return super.applyPotionDamageCalculations((DamageSource) damageSource, par2);
	}

	@Override
	protected void damageEntity(DamageSource damageSource, float par2) {
		if (master != null) master.damageEntity(damageSource, par2);
		else super.damageEntity(damageSource, par2);
	}

	public void superDamageEntity(Object damageSource, float par2) {
		super.damageEntity((DamageSource) damageSource, par2);
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
	protected void updateArmSwingProgress() {
		if (master != null) master.updateArmSwingProgress();
		else super.updateArmSwingProgress();
	}

	@Override
	public void superUpdateArmSwingProgress() {
		super.updateArmSwingProgress();
	}

	@Override
	public IAttributeInstance getEntityAttribute(IAttribute attribute) {
		return (IAttributeInstance) (master != null ? master.getEntityAttribute(attribute) : super.getEntityAttribute(attribute));
	}

	@Override
	public IAttributeInstance superGetEntityAttribute(Object attribute) {
		return super.getEntityAttribute((IAttribute) attribute);
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
	public ItemStack getHeldItem() {
		return (ItemStack) (master != null ? master.getHeldItemMainhand() : null);
	}

	@Override
	public ItemStack superGetHeldItemMainhand() {
		return null;
	}

	@Override
	public ItemStack getEquipmentInSlot(int i) {
		return (ItemStack) (master != null ? master.getItemStackFromSlot(i) : null);
	}

	@Override
	public ItemStack superGetItemStackFromSlot(int i) {
		return null;
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
	protected boolean isMovementBlocked() {
		return master != null ? master.isMovementBlocked() : super.isMovementBlocked();
	}

	@Override
	public boolean superIsMovementBlocked() {
		return super.isMovementBlocked();
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
	protected void jump() {
		if (master != null) master.jump();
		else super.jump();
	}

	@Override
	public void superJump() {
		super.jump();
	}

	@Override
	public void moveEntityWithHeading(float par1, float par2) {
		if (master != null) master.moveEntityWithHeading(par1, par2);
		else super.moveEntityWithHeading(par1, par2);
	}

	@Override
	public void superMoveEntityWithHeading(float par1, float par2) {
		super.moveEntityWithHeading(par1, par2);
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
	public void setAIMoveSpeed(float par1) {
		if (master != null) master.setAIMoveSpeed(par1);
		else super.setAIMoveSpeed(par1);
	}

	@Override
	public void superSetAIMoveSpeed(float par1) {
		super.setAIMoveSpeed(par1);
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
	public boolean isPlayerSleeping() {
		return master != null ? master.isPlayerSleeping() : super.isPlayerSleeping();
	}

	@Override
	public boolean superIsPlayerSleeping() {
		return super.isPlayerSleeping();
	}

	@Override
	protected float func_110146_f(float par1, float par2) {
		return master != null ? master.updateDistance(par1, par2) : super.func_110146_f(par1, par2);
	}

	@Override
	public float superUpdateDistance(float par1, float par2) {
		return super.func_110146_f(par1, par2);
	}

	@Override
	public void superOnLivingUpdate() {
		super.onLivingUpdate();
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
	public void superUpdateEntityActionState() {
		super.updateEntityActionState();
	}

	@Override
	public void setJumping(boolean par1) {
		if (master != null) master.setJumping(par1);
		else super.setJumping(par1);
	}

	@Override
	public void superSetJumping(boolean par1) {
		super.setJumping(par1);
	}

	@Override
	public void onItemPickup(Entity entity, int par2) {
		if (master != null) master.onItemPickup(entity, par2);
		else super.onItemPickup(entity, par2);
	}

	@Override
	public void superOnItemPickup(Object entity, int par2) {
		super.onItemPickup((Entity) entity, par2);
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
	public float getSwingProgress(float par1) {
		return master != null ? master.getSwingProgress(par1) : super.getSwingProgress(par1);
	}

	@Override
	public float superGetSwingProgress(float par1) {
		return super.getSwingProgress(par1);
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
	public void setAbsorptionAmount(float par1) {
		if (master != null) master.setAbsorptionAmount(par1);
		else super.setAbsorptionAmount(par1);
	}

	@Override
	public void superSetAbsorptionAmount(float par1) {
		super.setAbsorptionAmount(par1);
	}

	@Override
	public Team getTeam() {
		return (Team) (master != null ? master.getTeam() : super.getTeam());
	}

	@Override
	public boolean isOnSameTeam(EntityLivingBase entityLivingBase) {
		return master != null ? master.isOnSameTeam(entityLivingBase) : super.isOnSameTeam(entityLivingBase);
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

	@Override
	public boolean equals(Object par1Obj) {
		return master != null ? master.equals(par1Obj) : super.equals(par1Obj);
	}

	@Override
	public int hashCode() {
		return master != null ? master.hashCode() : super.hashCode();
	}

	@Override
	public int superFunc_96121_ay() {
		return -1;
	}

	@Override
	public Object superGetLastAttackingEntity() {
		return null;
	}

	@Override
	public void superSetLastAttackingEntity(Object entity) {
	}

	@Override
	public float superGetMaximumHomeDistance() {
		return 0.0F;
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
	public void superSetHealth(Object par1) {
		super.setHealth((Float) par1);
	}

	@Override
	public int superGetDropItemId() {
		return -1;
	}

	@Override
	public boolean superIsBlocking() {
		return false;
	}

	@Override
	public float superGetSpeedModifier() {
		return 0.0F;
	}

	@Override
	public void superFunc_82162_bC() {
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
	public boolean superFunc_94062_bN() {
		return false;
	}

	@Override
	public void superFunc_96120_a(int par1, float par2) {
	}

	@Override
	public void superSetPortal() {
		super.setInPortal();
	}

	@Override
	public void superHeal(Object par1) {
		super.heal((Float) par1);
	}

	public String getTranslatedEntityName() {
		return null;
	}

	public boolean superIsInRangeToRenderVec3D(Object vec3) {
		return false;
	}

	protected String getFallSoundString(int damageValue) {
		return (String) (master != null ? master.getFallSound(damageValue) : null);
	}

	public ItemStack getCurrentArmor(int slotIn) {
		return (ItemStack) (master != null ? master.getItemStackFromSlot(slotIn) : null);
	}

	@Override
	public ItemStack superGetCurrentArmor(int slotIn) {
		return null;
	}

	public boolean isServerWorld() {
		return master != null ? master.isServerWorld() : !super.isClientWorld();
	}

	@Override
	public boolean superIsServerWorld() {
		return !super.isClientWorld();
	}

	public void superFunc_174817_o(Object entity) {
	}

	@Override
	public void superPlayStepSound(int par1, int par2, int par3, Object par4) {
	}
	// 188~
	@Override
	public void superFunc_180433_a(double p_180433_1_, boolean p_180433_3_, Object block, Object blockPos) {
	}

	public void superFunc_175135_B() {
	}

	public void superFunc_175133_bi() {
	}

	public float superFunc_175134_bD() {
		return 0.0F;
	}

	public void superFunc_180466_bG() {
	}

	public void superFunc_180426_a(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
	}

	public void superFunc_152111_bt() {
	}

	public void superFunc_152112_bu() {
	}

	public void superFunc_175136_bO() {
	}

	public boolean superFunc_174816_a(Object explosion, Object world, Object blockPos, Object iBlockState, float p_174816_5_) {
		return false;
	}

	public Object superFunc_174823_aP() {
		return null;
	}

	public boolean superFunc_174827_a(Object entityPlayerMP) {
		return false;
	}

	@Override
	public boolean superCanUseCommand(int permLevel, String commandName) {
		return false;
	}

	public Object superFunc_174807_aT() {
		return null;
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

	public boolean superFunc_180427_aV() {
		return false;
	}

	public void superFunc_174815_a(Object entityLivingBase, Object entity) {
	}

	@Override
	public void superAddRandomDrop() {
	}

	public void superFunc_181013_g(float p_181013_1_) {
	}

	public Object superFunc_181012_aH() {
		return null;
	}
	// 190~
	@Override
	public void superSetNoAI(boolean par1) {
	}

	@Override
	public Object superGetFallSound(int damageValue) {
		return null;
	}

	@Override
	public int superGetItemInUseCount() {
		return -1;
	}

	@Override
	public void superUpdateItemUse(Object itemStack, int p_184584_2_) {
	}

	@Override
	public void superOnItemUseFinish() {
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

	@Override
	public boolean superAttemptTeleport(double x, double y, double z) {
		return false;
	}

	@Override
	public boolean superCanBeHitWithPotion() {
		return false;
	}

	@Override
	public void superDropLoot(boolean p_184610_1_, int p_184610_2_, Object damageSource) {
	}
	// Modchu_EntityLivingBase のコピー↑
	// TODO Modchu_Entity のコピー↓（からのエラー対処有り）
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
		boolean debug = false;
		World worldObj = (World) Modchu_AS.get(Modchu_AS.entityWorldObj, this);
		if (debug) Modchu_Debug.mDebug("Modchu_EntityTameable entityInit isRemote="+worldObj.isRemote);
		int version = Modchu_Main.getMinecraftVersion();
		//Modchu_AS.set("Entity", version > 190 ? "dataManager" : "dataWatcher", this, (EntityDataManager) Modchu_Main.newModchuCharacteristicObject("Modchu_EntityDataManager", Modchu_EntityDataManagerMaster2.class, this, Modchu_AS.get("Entity", version > 190 ? "dataManager" : "dataWatcher", this)));
		dataWatcher = (DataWatcher) Modchu_Main.newModchuCharacteristicObject("Modchu_DataWatcher", Modchu_DataWatcherMaster2.class, this, dataWatcher);
		if (debug) Modchu_Debug.mDebug("Modchu_EntityTameable entityInit dataWatcher="+dataWatcher);
		boolean b = Modchu_AS.set("Entity", "dataWatcher", this, dataWatcher);
		if (debug) Modchu_Debug.mDebug("Modchu_EntityTameable entityInit b="+b);
		super.entityInit();
		dataWatcherWatchableObjectIdFirst = 18;
		int i = dataWatcherWatchableObjectIdFirst;
		entityDataManagerRegister(new Class[]{ String.class }, i, "");
		i++;
		setDataWatcherWatchableObjectIdCount(i);
		initFlag = true;
		if (master != null) master.entityInit();
	}

	@Override
	public void superEntityInit() {
		super.entityInit();
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
	public DataWatcher getDataWatcher() {
		return (DataWatcher) (master != null ? master.getDataManager() : super.getDataWatcher());
	}

	@Override
	public DataWatcher superGetDataManager() {
		return super.getDataWatcher();
	}

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
		if (worldObj != null); else return;
		if (master != null) master.onUpdate();
		else super.onUpdate();
	}

	@Override
	public void superOnUpdate() {
		super.onUpdate();
	}

	@Override
	public void onEntityUpdate() {
		if (worldObj != null); else return;
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
	protected String getSwimSound() {
		return (String) (master != null ? master.getSwimSound() : super.getSwimSound());
	}

	@Override
	public String superGetSwimSound() {
		return super.getSwimSound();
	}

	@Override
	protected void func_145775_I() {
		if (master != null) master.doBlockCollisions();
		else super.func_145775_I();
	}

	@Override
	public void superDoBlockCollisions() {
		super.func_145775_I();
	}

	@Override
	protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block block) {
		if (master != null) master.func_145780_a(p_145780_1_, p_145780_2_, p_145780_3_, block);
		else super.func_145780_a(p_145780_1_, p_145780_2_, p_145780_3_, block);
	}

	@Override
	public void superFunc_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Object block) {
		super.func_145780_a(p_145780_1_, p_145780_2_, p_145780_3_, (Block) block);
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
	protected String getSplashSound() {
		return (String) (master != null ? master.getSplashSound() : super.getSplashSound());
	}

	@Override
	public String superGetSplashSound() {
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
	public EntityItem dropItem(Item item, int p_145779_2_) {
		return (EntityItem) (master != null ? master.dropItem(item, p_145779_2_) : super.dropItem(item, p_145779_2_));
	}

	@Override
	public EntityItem superDropItem(Object item, int p_145779_2_) {
		return super.dropItem((Item) item, p_145779_2_);
	}

	@Override
	public EntityItem func_145778_a(Item item, int p_145778_2_, float p_145778_3_) {
		return (EntityItem) (master != null ? master.dropItemWithOffset(item, p_145778_2_, p_145778_3_) : super.func_145778_a(item, p_145778_2_, p_145778_3_));
	}

	@Override
	public EntityItem superDropItemWithOffset(Object item, int p_145778_2_, float p_145778_3_) {
		return super.func_145778_a((Item) item, p_145778_2_, p_145778_3_);
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
	protected boolean func_145771_j(double p_145771_1_, double p_145771_3_, double p_145771_5_) {
		return master != null ? master.pushOutOfBlocks(p_145771_1_, p_145771_3_, p_145771_5_) : super.func_145771_j(p_145771_1_, p_145771_3_, p_145771_5_);
	}

	@Override
	public boolean superPushOutOfBlocks(double p_145771_1_, double p_145771_3_, double p_145771_5_) {
		return super.func_145771_j(p_145771_1_, p_145771_3_, p_145771_5_);
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
	public String getCommandSenderName() {
		return master != null ? master.getName() : super.getCommandSenderName();
	}

	@Override
	public String superGetName() {
		return super.getCommandSenderName();
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
	public float func_145772_a(Explosion explosion, World world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Block block) {
		return master != null ? master.func_145772_a(explosion, world, p_145772_3_, p_145772_4_, p_145772_5_, block) : super.func_145772_a(explosion, world, p_145772_3_, p_145772_4_, p_145772_5_, block);
	}

	@Override
	public float superFunc_145772_a(Object explosion, Object world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Object block) {
		return super.func_145772_a((Explosion) explosion, (World) world, p_145772_3_, p_145772_4_, p_145772_5_, (Block) block);
	}

	@Override
	public boolean func_145774_a(Explosion explosion, World world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Block block, float p_145774_7_) {
		return master != null ? master.func_145774_a(explosion, world, p_145774_3_, p_145774_4_, p_145774_5_, block, p_145774_7_) : super.func_145774_a(explosion, world, p_145774_3_, p_145774_4_, p_145774_5_, block, p_145774_7_);
	}

	@Override
	public boolean superFunc_145774_a(Object explosion, Object world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Object block, float p_145774_7_) {
		return super.func_145774_a((Explosion) explosion, (World) world, p_145774_3_, p_145774_4_, p_145774_5_, (Block) block, p_145774_7_);
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
	public IChatComponent func_145748_c_() {
		return (IChatComponent) (master != null ? master.getDisplayName() : super.func_145748_c_());
	}

	@Override
	public IChatComponent superGetDisplayName() {
		return super.func_145748_c_();
	}

	@Override
	public void func_145781_i(int p_145781_1_) {
/*
		Modchu_Debug.mDebug("Modchu_EntityTameable func_145781_i worldObj.isRemote="+worldObj.isRemote);
		Modchu_Debug.mDebug("Modchu_EntityTameable func_145781_i this="+this);
		Modchu_Debug.mDebug("Modchu_EntityTameable func_145781_i master="+master);
		Modchu_Debug.mDebug("Modchu_EntityTameable func_145781_i p_145781_1_="+p_145781_1_);
		Modchu_Debug.mDebug("Modchu_EntityTameable func_145781_i getDataWatcherGetWatchableObject="+getDataWatcherGetWatchableObject(p_145781_1_));
*/
		if (master != null) master.onDataWatcherUpdate(p_145781_1_);
		else super.func_145781_i(p_145781_1_);
	}

	@Override
	public void superOnDataWatcherUpdate(int p_145781_1_) {
		super.func_145781_i(p_145781_1_);
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
	// ~164
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
		return superStartRiding(entity);
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
		super.mountEntity(null);
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

	@Override
	public void superAddTrackingPlayer(Object entityPlayerMP) {
	}

	@Override
	public void superRemoveTrackingPlayer(Object entityPlayerMP) {
	}

	@Override
	public float superGetRotatedYaw(Object rotation) {
		return 0.0F;
	}

	@Override
	public float superGetMirroredYaw(Object mirror) {
		return 0.0F;
	}

	@Override
	public boolean superIgnoreItemEntityData() {
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
		return ridingEntity;
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
	public Object superGetTeleportDirection() {
		return super.getTeleportDirection();
	}
	// Modchu_Entity のコピー↑

}
