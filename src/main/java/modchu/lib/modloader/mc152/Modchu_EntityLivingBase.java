package modchu.lib.modloader.mc152;

import java.util.Collection;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_DataWatcherMaster2;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityLiving;
import modchu.lib.Modchu_IEntityLivingBase;
import modchu.lib.Modchu_IEntityLivingBaseMaster;
import modchu.lib.Modchu_IEntityLivingMaster;
import modchu.lib.Modchu_IEntityTameableMaster;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.CrashReportCategory;
import net.minecraft.src.DamageSource;
import net.minecraft.src.DataWatcher;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityJumpHelper;
import net.minecraft.src.EntityLightningBolt;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityLookHelper;
import net.minecraft.src.EntityMoveHelper;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntitySenses;
import net.minecraft.src.EnumCreatureAttribute;
import net.minecraft.src.EnumCreatureType;
import net.minecraft.src.Explosion;
import net.minecraft.src.Icon;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.PathNavigate;
import net.minecraft.src.Potion;
import net.minecraft.src.PotionEffect;
import net.minecraft.src.Vec3;
import net.minecraft.src.World;

public class Modchu_EntityLivingBase extends EntityLiving implements Modchu_IEntityLiving {
	public Modchu_IEntityLivingMaster master;
	public String entityName;
	public static ConcurrentHashMap<String, UUID> entityUniqueIDMap = new ConcurrentHashMap();
	protected UUID entityUniqueID;
	protected int maxHealth;
	private boolean initFlag;

	public Modchu_EntityLivingBase(World world) {
		super(world);
		entityUniqueID = UUID.randomUUID();
		ignoreFrustumCheck = true;
		initFlag = false;
		setEntityHealth(1);
		init((HashMap)null);
	}

	public Modchu_EntityLivingBase(HashMap<String, Object> map) {
		this((World) map.get("Object"));
		initFlag = false;
		setEntityHealth(1);
		init(map);
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
		return 9;
	}

	@Override
	public void setDataWatcherWatchableObjectIdCount(int i) {
	}

	@Override
	public boolean superIsOnLivingUpdateCancel() {
		return false;
	}

	@Override
	public boolean isOnLivingUpdateCancel() {
		return false;
	}

	@Override
	public void entityDataManagerRegister(Class[] c1, int i, Object o) {
		dataWatcher.addObject(i, o);
	}

	@Override
	public Object getDataWatcherWatchableObject(int i) {
		Object watchedObject = Modchu_AS.get("DataWatcher", "getWatchedObject", new Class[]{ int.class }, dataWatcher, new Object[]{ i });
		return watchedObject != null ? Modchu_AS.get("WatchableObject", "getObject", watchedObject) : null;
	}

	@Override
	public void setDataWatcherWatchableObject(int i, Object o) {
		dataWatcher.updateObject(i, o);
	}

	public Object getMaster() {
		//Modchu_Debug.mDebug("Modchu_EntityLivingBase getMaster master="+master);
		if (master != null) ;else {
			init(entityName);
		}
		//Modchu_Debug.mDebug("Modchu_EntityLivingBase getMaster return master="+master);
		return master;
	}

	protected void init(String s) {
		Class c = Modchu_Reflect.loadClass(s);
		if (c != null); else return;
		HashMap<String, Object> map = Modchu_Main.getNewModchuCharacteristicMap(c);
		init(map);
	}

	protected void init(HashMap<String, Object> map) {
		dataWatcher = (DataWatcher) Modchu_Main.newModchuCharacteristicObject("Modchu_DataWatcher", Modchu_DataWatcherMaster2.class, this, dataWatcher);
		boolean isRemote = Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, this);
		Modchu_Debug.mDebug("Modchu_EntityLivingBase init isRemote="+isRemote+" map="+map);
		if (posX == 0
				&& posY== 0
				&& posZ == 0) {
			Modchu_Debug.mDebug("Modchu_EntityLivingBase init isRemote="+isRemote+" initFlag="+initFlag+" pos0 return");
			return;
		}
		Modchu_Debug.mDebug("Modchu_EntityLivingBase init isRemote="+isRemote+" initFlag");
		if (map != null
				&& !map.isEmpty()); else {
			Modchu_Debug.mDebug("Modchu_EntityLivingBase init isRemote="+isRemote+" map == null.");
			Class c = Modchu_Main.getSpownEntityClass(worldObj, posX, posY, posZ);
			map = new HashMap();
			map.put("Class", c);
			map.put("Object", worldObj);
			Modchu_Debug.mDebug("Modchu_EntityLivingBase isRemote="+isRemote+" init c="+c+" worldObj="+worldObj);
		}
		if (map != null
				&& !map.isEmpty()); else {
			Modchu_Debug.mDebug("Modchu_EntityLivingBase init 2 isRemote="+isRemote+" map == null !!");
			return;
		}
		Modchu_Debug.mDebug("Modchu_EntityLivingBase init 3 isRemote="+isRemote);
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		master = instance instanceof Modchu_IEntityTameableMaster ? (Modchu_IEntityTameableMaster) instance : null;
		entityName = ((Class) map.get("Class")).getName();
		Modchu_Debug.mDebug("init isRemote="+isRemote+" entityName="+(entityName != null ? entityName : "null !!"));
		String s0 = new StringBuilder(Modchu_AS.getBoolean(Modchu_AS.worldIsRemote, this) ? "1" : "0").append(entityUniqueID).toString();
		if (s0 != null
				&& entityUniqueIDMap.containsKey(s0)) {
			Modchu_Debug.mDebug("Modchu_EntityLivingBase init isRemote="+isRemote+" entityUniqueIDMap.containsKey isDead s0="+s0);
			Modchu_AS.set(Modchu_AS.entityLivingBaseSetHealth, this, 0.0F);
			deathTime = 20;
			setDead();
			return;
		}
		if (s0 != null) entityUniqueIDMap.put(s0, entityUniqueID);
		initFlag = true;
		Modchu_Debug.mDebug("Modchu_EntityLivingBase init isRemote="+isRemote+" entityUniqueID="+entityUniqueID);
		Modchu_Debug.mDebug("Modchu_EntityLivingBase init masterEntity="+master);
	}

	@Override
	public void setFollowRange(double d) {
	}

	@Override
	public void setKnockbackResistance(double d) {
	}

	@Override
	public void setAttackDamage(double d) {
	}

	@Override
	public void setMovementSpeed(double d) {
		moveSpeed = (float) d;
	}

	@Override
	public int getMaxHealth() {
		return maxHealth;
	}

	@Override
	public void setMaxHealth(double d) {
		maxHealth = (int) d;
	}

	public static void worldEventLoad(Object event) {
		if (entityUniqueIDMap != null) entityUniqueIDMap.clear();
	}

	@Override
	protected int func_96121_ay() {
		return master != null ? master.func_96121_ay() : super.func_96121_ay();
	}

	@Override
	public int superFunc_96121_ay() {
		return super.func_96121_ay();
	}

	@Override
	public EntityLookHelper getLookHelper() {
		return (EntityLookHelper) (master != null ? master.getLookHelper() : super.getLookHelper());
	}

	@Override
	public EntityLookHelper superGetLookHelper() {
		return super.getLookHelper();
	}

	@Override
	public EntityMoveHelper getMoveHelper() {
		return (EntityMoveHelper) (master != null ? master.getMoveHelper() : super.getMoveHelper());
	}

	@Override
	public EntityMoveHelper superGetMoveHelper() {
		return super.getMoveHelper();
	}

	@Override
	public EntityJumpHelper getJumpHelper() {
		return (EntityJumpHelper) (master != null ? master.getJumpHelper() : super.getJumpHelper());
	}

	@Override
	public EntityJumpHelper superGetJumpHelper() {
		return super.getJumpHelper();
	}

	@Override
	public PathNavigate getNavigator() {
		return (PathNavigate) (master != null ? master.getNavigator() : super.getNavigator());
	}

	@Override
	public PathNavigate superGetNavigator() {
		return super.getNavigator();
	}

	@Override
	public EntitySenses getEntitySenses() {
		return (EntitySenses) (master != null ? master.getEntitySenses() : super.getEntitySenses());
	}

	@Override
	public EntitySenses superGetEntitySenses() {
		return super.getEntitySenses();
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
	public EntityLiving getAITarget() {
		return (EntityLiving) (master != null ? master.getAITarget() : super.getAITarget());
	}

	@Override
	public EntityLiving superGetAITarget() {
		return super.getAITarget();
	}

	@Override
	public EntityLiving getLastAttackingEntity() {
		return (EntityLiving) (master != null ? master.getLastAttackingEntity() : super.getLastAttackingEntity());
	}

	@Override
	public EntityLiving superGetLastAttackingEntity() {
		return super.getLastAttackingEntity();
	}

	@Override
	public void setLastAttackingEntity(Entity entity) {
		if (master != null) master.setLastAttackingEntity(entity);
		else super.setLastAttackingEntity(entity);
	}

	@Override
	public void superSetLastAttackingEntity(Object entity) {
		super.setLastAttackingEntity((Entity) entity);
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
	public EntityLiving getAttackTarget() {
		return (EntityLiving) (master != null ? master.getAttackTarget() : super.getAttackTarget());
	}

	@Override
	public EntityLiving superGetAttackTarget() {
		return super.getAttackTarget();
	}

	@Override
	public void setAttackTarget(EntityLiving entityLiving) {
		if (master != null) master.setAttackTarget(entityLiving);
		else super.setAttackTarget(entityLiving);
	}

	@Override
	public void superSetAttackTarget(Object entityLiving) {
		super.setAttackTarget((EntityLiving) entityLiving);
	}

	@Override
	public boolean canAttackClass(Class par1Class) {
		return master != null ? master.canAttackClass(par1Class) : super.canAttackClass(par1Class);
	}

	@Override
	public boolean superCanAttackClass(Class par1Class) {
		return super.canAttackClass(par1Class);
	}

	@Override
	public void eatGrassBonus() {
		if (master != null) master.eatGrassBonus();
		else super.eatGrassBonus();
	}

	@Override
	public void superEatGrassBonus() {
		super.eatGrassBonus();
	}

	@Override
	public boolean isWithinHomeDistanceCurrentPosition() {
		return master != null ? master.isWithinHomeDistanceCurrentPosition() : super.isWithinHomeDistanceCurrentPosition();
	}

	public boolean superIsWithinHomeDistanceCurrentPosition() {
		return super.isWithinHomeDistanceCurrentPosition();
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
	public void setHomeArea(int par1, int par2, int par3, int par4) {
		if (master != null) master.setHomeArea(par1, par2, par3, par4);
		else super.setHomeArea(par1, par2, par3, par4);
	}

	@Override
	public void superSetHomeArea(int par1, int par2, int par3, int par4) {
		super.setHomeArea(par1, par2, par3, par4);
	}

	@Override
	public ChunkCoordinates getHomePosition() {
		return (ChunkCoordinates) (master != null ? master.getHomePosition() : super.getHomePosition());
	}

	@Override
	public ChunkCoordinates superGetHomePosition() {
		return super.getHomePosition();
	}

	@Override
	public float getMaximumHomeDistance() {
		return master != null ? master.getMaximumHomeDistance() : super.getMaximumHomeDistance();
	}

	@Override
	public float superGetMaximumHomeDistance() {
		return super.getMaximumHomeDistance();
	}

	@Override
	public void detachHome() {
		if (master != null) master.detachHome();
		else super.detachHome();
	}

	@Override
	public void superDetachHome() {
		super.detachHome();
	}

	@Override
	public boolean hasHome() {
		return master != null ? master.hasHome() : super.hasHome();
	}

	@Override
	public boolean superHasHome() {
		return super.hasHome();
	}

	@Override
	public void setRevengeTarget(EntityLiving entityLiving) {
		if (master != null) master.setRevengeTarget(entityLiving);
		else super.setRevengeTarget(entityLiving);
	}

	@Override
	public void superSetRevengeTarget(Object entityLiving) {
		super.setRevengeTarget((EntityLiving) entityLiving);
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
	public int getTalkInterval() {
		return master != null ? master.getTalkInterval() : super.getTalkInterval();
	}

	@Override
	public int superGetTalkInterval() {
		return super.getTalkInterval();
	}

	@Override
	public void playLivingSound() {
		if (master != null) master.playLivingSound();
		else super.playLivingSound();
	}

	@Override
	public void superPlayLivingSound() {
		super.playLivingSound();
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
	public void spawnExplosionParticle() {
		if (master != null) master.spawnExplosionParticle();
		else super.spawnExplosionParticle();
	}

	@Override
	public void superSpawnExplosionParticle() {
		super.spawnExplosionParticle();
	}

	@Override
	public void heal(int par1) {
		if (master != null) master.heal(par1);
		else super.heal(par1);
	}

	@Override
	public void superHeal(int par1) {
		super.heal(par1);
	}

	@Override
	public int getHealth() {
		return (Integer) (master != null ? master.getHealth() : super.getHealth());
	}

	@Override
	public Object superGetHealth() {
		return super.getHealth();
	}

	@Override
	public void setEntityHealth(int par1) {
		if (master != null) master.setEntityHealth(par1);
		else super.setEntityHealth(par1);
	}

	public void superSetEntityHealth(int par1) {
		super.setEntityHealth(par1);
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
	public int getTotalArmorValue() {
		return master != null ? master.getTotalArmorValue() : super.getTotalArmorValue();
	}

	@Override
	public int superGetTotalArmorValue() {
		return super.getTotalArmorValue();
	}

	@Override
	protected void damageArmor(int par1) {
		if (master != null) master.damageArmor(par1);
		else super.damageArmor(par1);
	}

	@Override
	public void superDamageArmor(int par1) {
		super.damageArmor(par1);
	}

	@Override
	protected int applyArmorCalculations(DamageSource damageSource, int par2) {
		return (Integer) (master != null ? master.applyArmorCalculations(damageSource, par2) : super.applyArmorCalculations(damageSource, par2));
	}

	@Override
	public Object superApplyArmorCalculations(Object damageSource, int par2) {
		return super.applyArmorCalculations((DamageSource) damageSource, par2);
	}

	@Override
	protected int applyPotionDamageCalculations(DamageSource damageSource, int par2) {
		return (Integer) (master != null ? master.applyPotionDamageCalculations(damageSource, par2) : super.applyPotionDamageCalculations(damageSource, par2));
	}

	@Override
	public Object superApplyPotionDamageCalculations(Object damageSource, int par2) {
		return super.applyPotionDamageCalculations((DamageSource) damageSource, par2);
	}

	@Override
	protected void damageEntity(DamageSource damageSource, int par2) {
		if (master != null) master.damageEntity(damageSource, par2);
		else super.damageEntity(damageSource, par2);
	}

	@Override
	public void superDamageEntity(Object damageSource, int par2) {
		super.damageEntity((DamageSource) damageSource, par2);
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
	protected String getLivingSound() {
		return (String) (master != null ? master.getAmbientSound() : super.getLivingSound());
	}

	public String superGetLivingSound() {
		return super.getLivingSound();
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
	public void knockBack(Entity entity, int par2, double par3, double par5) {
		if (master != null) master.knockBack(entity, par2, par3, par5);
		else super.knockBack(entity, par2, par3, par5);
	}

	@Override
	public void superKnockBack(Object entity, int par2, double par3, double par5) {
		super.knockBack((Entity) entity, par2, par3, par5);
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
	protected void dropRareDrop(int par1) {
		if (master != null) master.dropRareDrop(par1);
		else super.dropRareDrop(par1);
	}

	@Override
	public void superDropRareDrop(int par1) {
		super.dropRareDrop(par1);
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
	protected int getDropItemId() {
		return master != null ? master.getDropItemId() : super.getDropItemId();
	}

	@Override
	public int superGetDropItemId() {
		return super.getDropItemId();
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
	public boolean isOnLadder() {
		return master != null ? master.isOnLadder() : super.isOnLadder();
	}

	@Override
	public boolean superIsOnLadder() {
		return super.isOnLadder();
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
	public void setMoveForward(float par1) {
		if (master != null) master.setMoveForward(par1);
		else super.setMoveForward(par1);
	}

	@Override
	public void superSetMoveForward(float par1) {
		super.setMoveForward(par1);
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
	public void onLivingUpdate() {
		if (master != null) master.onLivingUpdate();
		else super.onLivingUpdate();
	}

	@Override
	public void superOnLivingUpdate() {
		super.onLivingUpdate();
	}

	@Override
	protected void func_85033_bc() {
		if (master != null) master.collideWithNearbyEntities();
		else super.func_85033_bc();
	}

	@Override
	public void superCollideWithNearbyEntities() {
		super.func_85033_bc();
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
	protected boolean isAIEnabled() {
		return master != null ? master.isAIEnabled() : super.isAIEnabled();
	}

	@Override
	public boolean superIsAIEnabled() {
		return super.isAIEnabled();
	}

	@Override
	protected boolean isClientWorld() {
		return master != null ? master.isClientWorld() : super.isClientWorld();
	}

	@Override
	public boolean superIsClientWorld() {
		return super.isClientWorld();
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
	public boolean isBlocking() {
		return master != null ? master.isBlocking() : super.isBlocking();
	}

	@Override
	public boolean superIsBlocking() {
		return super.isBlocking();
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
	protected boolean canDespawn() {
		return master != null ? master.canDespawn() : super.canDespawn();
	}

	@Override
	public boolean superCanDespawn() {
		return super.canDespawn();
	}

	@Override
	protected void despawnEntity() {
		if (master != null) master.despawnEntity();
		else super.despawnEntity();
	}

	@Override
	public void superDespawnEntity() {
		super.despawnEntity();
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
	protected void updateAITick() {
		if (master != null) master.handleJumpWater();
		else super.updateAITick();
	}

	@Override
	public void superHandleJumpWater() {
		super.updateAITick();
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
	protected void updateArmSwingProgress() {
		if (master != null) master.updateArmSwingProgress();
		else super.updateArmSwingProgress();
	}

	@Override
	public void superUpdateArmSwingProgress() {
		super.updateArmSwingProgress();
	}

	@Override
	public int getVerticalFaceSpeed() {
		return master != null ? master.getVerticalFaceSpeed() : super.getVerticalFaceSpeed();
	}

	@Override
	public int superGetVerticalFaceSpeed() {
		return super.getVerticalFaceSpeed();
	}

	@Override
	public void faceEntity(Entity entity, float par2, float par3) {
		if (master != null) master.faceEntity(entity, par2, par3);
		else super.faceEntity(entity, par2, par3);
	}

	@Override
	public void superFaceEntity(Object entity, float par2, float par3) {
		super.faceEntity((Entity) entity, par2, par3);
	}

	@Override
	public boolean getCanSpawnHere() {
		return master != null ? master.getCanSpawnHere() : super.getCanSpawnHere();
	}

	@Override
	public boolean superGetCanSpawnHere() {
		return super.getCanSpawnHere();
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
	public Vec3 getPosition(float par1) {
		return (Vec3) (master != null ? master.getPosition(par1) : super.getPosition(par1));
	}

	@Override
	public Vec3 superGetPosition(float par1) {
		return super.getPosition(par1);
	}

	@Override
	public Vec3 getLook(float par1) {
		return (Vec3) (master != null ? master.getLook(par1) : super.getLook(par1));
	}

	@Override
	public float getRenderSizeModifier() {
		return master != null ? master.getRenderSizeModifier() : super.getRenderSizeModifier();
	}

	@Override
	public float superGetRenderSizeModifier() {
		return super.getRenderSizeModifier();
	}

	@Override
	public MovingObjectPosition rayTrace(double par1, float par3) {
		return (MovingObjectPosition) (master != null ? master.rayTrace(par1, par3) : super.rayTrace(par1, par3));
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return master != null ? master.getMaxSpawnedInChunk() : super.getMaxSpawnedInChunk();
	}

	@Override
	public int superGetMaxSpawnedInChunk() {
		return super.getMaxSpawnedInChunk();
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
	public Icon getItemIcon(ItemStack itemStack, int par2) {
		return (Icon) (master != null ? master.getItemIcon(itemStack, par2) : super.getItemIcon(itemStack, par2));
	}

	@Override
	public Icon superGetItemIcon(Object itemStack, int par2) {
		return super.getItemIcon((ItemStack) itemStack, par2);
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
	protected void onChangedPotionEffect(PotionEffect potionEffect) {
		if (master != null) master.onChangedPotionEffect(potionEffect);
		else super.onChangedPotionEffect(potionEffect);
	}

	@Override
	public void superOnChangedPotionEffect(Object potionEffect) {
		super.onChangedPotionEffect((PotionEffect) potionEffect);
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
	public float getSpeedModifier() {
		return master != null ? master.getSpeedModifier() : super.getSpeedModifier();
	}

	@Override
	public float superGetSpeedModifier() {
		return super.getSpeedModifier();
	}

	@Override
	public void setPositionAndUpdate(double par1, double par3, double par5) {
		if (master != null) master.setPositionAndUpdate(par1, par3, par5);
		else super.setPositionAndUpdate(par1, par3, par5);
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
	public EnumCreatureAttribute getCreatureAttribute() {
		return (EnumCreatureAttribute) (master != null ? master.getCreatureAttribute() : super.getCreatureAttribute());
	}

	@Override
	public EnumCreatureAttribute superGetCreatureAttribute() {
		return super.getCreatureAttribute();
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

	public int superFunc_82143_as() {
		return super.func_82143_as();
	}

	@Override
	public ItemStack getHeldItem() {
		return (ItemStack) (master != null ? master.getHeldItemMainhand() : super.getHeldItem());
	}

	@Override
	public ItemStack superGetHeldItemMainhand() {
		return super.getHeldItem();
	}

	@Override
	public ItemStack getCurrentItemOrArmor(int par1) {
		return (ItemStack) (master != null ? master.getCurrentItemOrArmor(par1) : super.getCurrentItemOrArmor(par1));
	}

	@Override
	public Object superGetCurrentItemOrArmor(int par1) {
		return super.getCurrentItemOrArmor(par1);
	}

	@Override
	public Object superGetItemStackFromSlot(int par1) {
		return super.getCurrentItemOrArmor(par1);
	}

	@Override
	public ItemStack getCurrentArmor(int par1) {
		return (ItemStack) (master != null ? master.getCurrentArmor(par1) : super.getCurrentArmor(par1));
	}

	@Override
	public Object superGetCurrentArmor(int par1) {
		return super.getCurrentArmor(par1);
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
	protected void addRandomArmor() {
		if (master != null) master.dropLoot();
		else super.addRandomArmor();
	}

	@Override
	public void superDropLoot() {
		super.addRandomArmor();
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
	protected void func_82162_bC() {
		if (master != null) master.func_82162_bC();
		else super.func_82162_bC();
	}

	@Override
	public void superFunc_82162_bC() {
		super.func_82162_bC();
	}

	@Override
	public void initCreature() {
		if (master != null) master.initCreature();
		else super.initCreature();
	}

	@Override
	public void superInitCreature() {
		super.initCreature();
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
	public boolean canBeSteered() {
		return master != null ? master.canBeSteered() : super.canBeSteered();
	}

	@Override
	public boolean superCanBeSteered() {
		return super.canBeSteered();
	}

	@Override
	public EntityLiving func_94060_bK() {
		return (EntityLiving) (master != null ? master.getAttackingEntity() : super.func_94060_bK());
	}

	@Override
	public EntityLiving superGetAttackingEntity() {
		return super.func_94060_bK();
	}

	@Override
	public void func_94058_c(String par1Str) {
		if (master != null) master.func_94058_c(par1Str);
		else super.func_94058_c(par1Str);
	}

	@Override
	public void superFunc_94058_c(String par1Str) {
		super.func_94058_c(par1Str);
	}

	@Override
	public String func_94057_bL() {
		return master != null ? master.func_94057_bL() : super.func_94057_bL();
	}

	@Override
	public String superFunc_94057_bL() {
		return super.func_94057_bL();
	}

	@Override
	public boolean func_94056_bM() {
		return master != null ? master.func_94056_bM() : super.func_94056_bM();
	}

	@Override
	public boolean superFunc_94056_bM() {
		return super.func_94056_bM();
	}

	@Override
	public void func_94061_f(boolean par1) {
		if (master != null) master.setNoAI(par1);
		else super.func_94061_f(par1);
	}

	@Override
	public void superSetNoAI(boolean par1) {
		super.func_94061_f(par1);
	}

	@Override
	public boolean func_94062_bN() {
		return master != null ? master.func_94062_bN() : super.func_94062_bN();
	}

	@Override
	public boolean superFunc_94062_bN() {
		return super.func_94062_bN();
	}

	@Override
	public boolean func_94059_bO() {
		return master != null ? master.getAlwaysRenderNameTagForRender() : super.func_94059_bO();
	}

	public boolean superFunc_94059_bO() {
		return super.func_94059_bO();
	}

	@Override
	public void func_96120_a(int par1, float par2) {
		if (master != null) master.func_96120_a(par1, par2);
		else super.func_96120_a(par1, par2);
	}

	@Override
	public void superFunc_96120_a(int par1, float par2) {
		super.func_96120_a(par1, par2);
	}

	@Override
	public boolean canPickUpLoot() {
		return master != null ? master.canPickUpLoot() : super.canPickUpLoot();
	}

	@Override
	public boolean superCanPickUpLoot() {
		return super.canPickUpLoot();
	}

	@Override
	public void setCanPickUpLoot(boolean par1) {
		if (master != null) master.setCanPickUpLoot(par1);
		else super.setCanPickUpLoot(par1);
	}

	@Override
	public void superSetCanPickUpLoot(boolean par1) {
		super.setCanPickUpLoot(par1);
	}

	@Override
	public boolean func_104002_bU() {
		return master != null ? master.isNoDespawnRequired() : super.func_104002_bU();
	}

	@Override
	public boolean superIsNoDespawnRequired() {
		return super.func_104002_bU();
	}

	public void curePotionEffects(ItemStack itemStack) {
	}

	@Override
	public void superCurePotionEffects(Object itemStack) {
	}

	public boolean shouldRiderFaceForward(EntityPlayer entityPlayer) {
		return false;
	}

	@Override
	public boolean superShouldRiderFaceForward(Object entityPlayer) {
		return false;
	}

	@Override
	public boolean equals(Object par1Obj) {
		return master != null ? master.equals(par1Obj) : super.equals(par1Obj);
	}

	@Override
	public int hashCode() {
		return master != null ? master.hashCode() : super.hashCode();
	}

	public void superSetInPortal() {
		super.setInPortal();
	}

	public boolean superFunc_85031_j(Object entity) {
		return super.func_85031_j((Entity) entity);
	}

	public void superFunc_82149_j(Object entity) {
		super.func_82149_j((Entity) entity);
	}

	public NBTTagCompound getEntityData() {
		return null;
	}

	public boolean shouldRiderSit() {
		return false;
	}

	public Object getPickedResult(MovingObjectPosition movingObjectPosition) {
		return null;
	}

	public UUID getPersistentID() {
		return null;
	}

	public boolean shouldRenderInPass(int pass) {
		return false;
	}

	public boolean isCreatureType(EnumCreatureType enumCreatureType, boolean forSpawnCount) {
		return false;
	}

	public String registerExtendedProperties(String identifier, Object iExtendedEntityProperties) {
		return null;
	}

	public Object getExtendedProperties(String identifier) {
		return null;
	}

	public void superFunc_174817_o(Object entity) {
	}

	@Override
	public void superSetHealth(Object par1) {
	}

	@Override
	public void superAddRandomDrop() {
	}

	@Override
	public void superSetPortal() {
	}

	@Override
	public void superApplyEntityAttributes() {
	}

	@Override
	public Object superGetLastAttacker() {
		return null;
	}

	@Override
	public int superGetLastAttackerTime() {
		return -1;
	}

	@Override
	public void superSetLastAttacker(Object entity) {
	}

	@Override
	public void superOnChangedPotionEffect(Object potionEffect, boolean par2) {
	}

	@Override
	public void superHeal(Object par1) {
	}

	@Override
	public void superKnockBack(Object entity, float par2, double par3, double par5) {
	}

	@Override
	public void superDamageArmor(float par1) {
	}

	@Override
	public Object superApplyArmorCalculations(Object damageSource, float par2) {
		return 0.0F;
	}

	@Override
	public Object superApplyPotionDamageCalculations(Object damageSource, float par2) {
		return 0.0F;
	}

	@Override
	public void superDamageEntity(Object damageSource, Object par2) {
	}

	@Override
	public Object superGetAttributeMap() {
		return null;
	}

	@Override
	public void superDismountEntity(Object entity) {
	}

	public float superFunc_110146_f(float par1, float par2) {
		return 0.0F;
	}

	@Override
	public float superGetAbsorptionAmount() {
		return 0.0F;
	}

	@Override
	public void superSetAbsorptionAmount(float par1) {
	}

	@Override
	public boolean superIsOnTeam(Object team) {
		return false;
	}

	@Override
	public int superGetRevengeTimer() {
		return -1;
	}

	@Override
	public Object superGetCombatTracker() {
		return null;
	}

	@Override
	public Object superGetEntityAttribute(Object iAttribute) {
		return null;
	}

	@Override
	public void superFunc_180433_a(double p_180433_1_, boolean p_180433_3_, Object block, Object blockPos) {
	}

	public boolean superFunc_146066_aG() {
		return false;
	}

	public void superFunc_175135_B() {
	}

	public void superFunc_175133_bi() {
	}

	public String superGetFallSoundString(int damageValue) {
		return null;
	}

	public float superFunc_175134_bD() {
		return 0.0F;
	}

	public void superFunc_180466_bG() {
	}

	public void superFunc_180426_a(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
	}

	@Override
	public boolean superIsServerWorld() {
		return false;
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

	@Override
	public void superFunc_145781_i(int p_145781_1_) {
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

	public void superFunc_181013_g(float p_181013_1_) {
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

	public Object superFunc_181012_aH() {
		return null;
	}
	// 190~
	@Override
	public float superUpdateDistance(float par1, float par2) {
		return 0.0F;
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
	public void superInit() {
	}

	@Override
	public void superSetMaxHealth(Object floatOrInt) {
		maxHealth = (Integer) floatOrInt;
	}

	@Override
	public boolean superInteractFirst(Object entityPlayer) {
		return super.interact((EntityPlayer) entityPlayer);
	}

	@Override
	public String superGetAmbientSound() {
		return null;
	}

	@Override
	public void superEnchantEquipment() {
	}

	@Override
	public Object superOnSpawnWithEgg(Object entityLivingData) {
		return null;
	}

	@Override
	public void superEnablePersistence() {
	}

	@Override
	public boolean superHasCustomNameTag() {
		return false;
	}

	@Override
	public void superSetDropChance(Object par1, float par2) {
	}

	@Override
	public void superUpdateLeashedState() {
	}

	@Override
	public void superClearLeashed(boolean par1, boolean par2) {
	}

	@Override
	public boolean superAllowLeashing() {
		return false;
	}

	@Override
	public boolean superGetLeashed() {
		return false;
	}

	@Override
	public Object superGetLeashedToEntity() {
		return null;
	}

	@Override
	public void superSetLeashedToEntity(Object entity, boolean par2) {
	}
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
		if (master != null) master.entityInit();
	}

	@Override
	public void superEntityInit() {
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.readEntityFromNBT(nBTTagCompound);
	}

	@Override
	public void superReadEntityFromNBT(Object nBTTagCompound) {
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
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
	public void onKillEntity(EntityLiving entityLiving) {
		if (master != null) master.onKillEntity(entityLiving);
		else super.onKillEntity(entityLiving);
	}

	@Override
	public void superOnKillEntity(Object entityLiving) {
		super.onKillEntity((EntityLiving) entityLiving);
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
	public boolean isEntityInvulnerable() {
		return master != null ? master.isEntityInvulnerable() : super.isEntityInvulnerable();
	}

	@Override
	public boolean superIsEntityInvulnerable() {
		return super.isEntityInvulnerable();
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
	public boolean canRenderOnFire() {
		return master != null ? master.canRenderOnFire() : super.canRenderOnFire();
	}

	@Override
	public boolean superCanRenderOnFire() {
		return super.canRenderOnFire();
	}
	// ~152
	@Override
	public boolean attackEntityFrom(DamageSource damageSource, int par2) {
		return master != null ? master.attackEntityFrom(damageSource, par2) : super.attackEntityFrom(damageSource, par2);
	}

	@Override
	public boolean superAttackEntityFrom(Object damageSource, int par2) {
		return super.attackEntityFrom((DamageSource) damageSource, par2);
	}

	@Override
	public String getTexture() {
		return master != null ? master.getTexture() : super.getTexture();
	}

	@Override
	public String superGetTexture() {
		return super.getTexture();
	}

	@Override
	public boolean addNotRiddenEntityID(NBTTagCompound nBTTagCompound) {
		return master != null ? master.addNotRiddenEntityID(nBTTagCompound) : super.addNotRiddenEntityID(nBTTagCompound);
	}

	@Override
	public boolean superAddNotRiddenEntityID(Object nBTTagCompound) {
		return super.addNotRiddenEntityID((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public boolean addEntityID(NBTTagCompound nBTTagCompound) {
		return master != null ? master.addEntityID(nBTTagCompound) : super.addEntityID(nBTTagCompound);
	}

	@Override
	public boolean superAddEntityID(Object nBTTagCompound) {
		return super.addEntityID((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public boolean interact(EntityPlayer entityPlayer) {
		return master != null ? master.interact(entityPlayer) : super.interact(entityPlayer);
	}

	@Override
	public boolean superInteract(Object entityPlayer) {
		return super.interact((EntityPlayer) entityPlayer);
	}

	@Override
	public void unmountEntity(Entity entity) {
		if (master != null) master.unmountEntity(entity);
		else super.unmountEntity(entity);
	}

	@Override
	public void superUnmountEntity(Object entity) {
		super.unmountEntity((Entity) entity);
	}

	@Override
	public void updateCloak() {
		if (master != null) master.updateCloak();
		else super.updateCloak();
	}

	@Override
	public void superUpdateCloak() {
		super.updateCloak();
	}

	@Override
	public boolean func_98034_c(EntityPlayer entityPlayer) {
		return master != null ? master.isInvisibleToPlayer(entityPlayer) : super.func_98034_c(entityPlayer);
	}

	@Override
	public boolean superIsInvisibleToPlayer(Object entityPlayer) {
		return super.func_98034_c((EntityPlayer) entityPlayer);
	}

	@Override
	public boolean func_85031_j(Entity entity) {
		return master != null ? master.hitByEntity(entity) : super.func_85031_j(entity);
	}

	@Override
	public boolean superHitByEntity(Object entity) {
		return super.func_85031_j((Entity) entity);
	}

	@Override
	public void func_82149_j(Entity entity) {
		if (master != null) master.copyLocationAndAnglesFrom(entity);
		else super.func_82149_j(entity);
	}

	@Override
	public void superCopyLocationAndAnglesFrom(Object entity) {
		super.func_82149_j((Entity) entity);
	}

	@Override
	public float func_82146_a(Explosion explosion, World world, int par3, int par4, int par5, Block block) {
		return master != null ? master.func_82146_a(explosion, world, par3, par4, par5, block) : super.func_82146_a(explosion, world, par3, par4, par5, block);
	}

	@Override
	public float superFunc_82146_a(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return super.func_82146_a((Explosion) explosion, (World) world, par3, par4, par5, (Block) block);
	}

	@Override
	public boolean func_96091_a(Explosion explosion, World world, int par3, int par4, int par5, int par6, float par7) {
		return master != null ? master.func_96091_a(explosion, world, par3, par4, par5, par6, par7) : super.func_96091_a(explosion, world, par3, par4, par5, par6, par7);
	}

	@Override
	public boolean superFunc_96091_a(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7) {
		return super.func_96091_a((Explosion) explosion, (World) world, par3, par4, par5, par6, par7);
	}

	@Override
	public int func_82143_as() {
		return master != null ? master.getMaxFallHeight() : super.func_82143_as();
	}

	@Override
	public int superGetMaxFallHeight() {
		return super.func_82143_as();
	}

	@Override
	public void func_85029_a(CrashReportCategory crashReportCategory) {
		if (master != null) master.addEntityCrashInfo(crashReportCategory);
		else super.func_85029_a(crashReportCategory);
	}

	@Override
	public void superAddEntityCrashInfo(Object crashReportCategory) {
		super.func_85029_a((CrashReportCategory) crashReportCategory);
	}

	@Override
	public boolean func_96092_aw() {
		return master != null ? master.isPushedByWater() : super.func_96092_aw();
	}

	@Override
	public boolean superIsPushedByWater() {
		return super.func_96092_aw();
	}
	// forge add
	@Override
	public NBTTagCompound superGetEntityData() {
		return null;
	}

	@Override
	public boolean superShouldRiderSit() {
		return false;
	}

	@Override
	public ItemStack superGetPickedResult(Object movingObjectPosition) {
		return null;
	}

	@Override
	public UUID superGetPersistentID() {
		return null;
	}

	@Override
	public boolean superShouldRenderInPass(int pass) {
		return true;
	}

	@Override
	public boolean superIsCreatureType(Object enumCreatureType, boolean forSpawnCount) {
		return false;
	}

	@Override
	public String superRegisterExtendedProperties(String identifier, Object iExtendedEntityProperties) {
		return null;
	}

	@Override
	public Object superGetExtendedProperties(String identifier) {
		return null;
	}

	@Override
	public boolean superCanRiderInteract() {
		return false;
	}

	@Override
	public boolean superShouldDismountInWater(Object entity) {
		return false;
	}

	@Override
	public boolean superAttackEntityFrom(Object damageSource, Object p_70097_2_) {
		return super.attackEntityFrom((DamageSource) damageSource, (Integer) p_70097_2_);
	}
	// 162~
	@Override
	public boolean superWriteToNBTAtomically(Object nBTTagCompound) {
		return false;
	}

	@Override
	public boolean superWriteToNBTOptional(Object nBTTagCompound) {
		return false;
	}

	@Override
	public boolean superShouldSetPosAfterLoading() {
		return false;
	}

	@Override
	public void superOnChunkLoad() {
	}

	@Override
	public int superGetMaxSafePointTries() {
		return -1;
	}

	@Override
	public UUID superGetUniqueID() {
		return null;
	}
	// 162~164
	@Override
	public float superGetBlockExplosionResistance(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return 0.0F;
	}

	@Override
	public boolean superShouldExplodeBlock(Object explosion, Object world, int par3, int par4, int par5, Object par6, float par7) {
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
	public void superPlayStepSound(int par1, int par2, int par3, Object par4) {
		super.playStepSound(par1, par2, par3, (Integer) par4);
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
	public EntityItem superDropItem(Object par1, int par2) {
		return super.dropItem((Integer) par1, par2);
	}

	@Override
	public EntityItem dropItemWithOffset(int par1, int par2, float par3) {
		return (EntityItem) (master != null ? master.dropItemWithOffset(par1, par2, par3) : super.dropItemWithOffset(par1, par2, par3));
	}

	@Override
	public EntityItem superDropItemWithOffset(Object par1, int par2, float par3) {
		return super.dropItemWithOffset((Integer) par1, par2, par3);
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
	public void superUpdateFallState(double p_180433_1_, boolean p_180433_3_, Object block, Object blockPos) {
	}

	@Override
	public void superFall(float distance, float damageMultiplier) {
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
	public double superGetDistanceSq(Object blockPos) {
		return 0.0D;
	}

	@Override
	public double superGetDistanceSqToCenter(Object blockPos) {
		return 0.0D;
	}

	@Override
	public Object superGetLook(float p_70676_1_) {
		return null;
	}

	@Override
	public Object superGetPositionEyes(float p_174824_1_) {
		return null;
	}

	@Override
	public Object superRayTrace(double p_174822_1_, float p_174822_3_) {
		return null;
	}

	@Override
	public void superSetPositionAndRotationDirect(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
	}

	@Override
	public Object[] superGetInventory() {
		return null;
	}

	@Override
	public boolean superIsEntityInvulnerable(Object damageSource) {
		return false;
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
	public Object superGetDisplayName() {
		return null;
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
	public void superSetPositionAndUpdate(double x, double y, double z) {
	}

	@Override
	public boolean superGetAlwaysRenderNameTagForRender() {
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
	public Object superGetPosition() {
		return null;
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

	@Override
	public boolean superEquals(Object p_equals_1_) {
		return super.equals(p_equals_1_);
	}

	@Override
	public int superHashCode() {
		return super.hashCode();
	}
	// 190~
	@Override
	public Object superGetTeam() {
		return null;
	}

	@Override
	public boolean superIsOnSameTeam(Object entity) {
		return false;
	}

	@Override
	public boolean superProcessInitialInteract(Object entityPlayer) {
		return super.interact((EntityPlayer) entityPlayer);
	}

	@Override
	public void superSetItemStackToSlot(int p_70062_1_, Object itemStack) {
		super.setCurrentItemOrArmor(p_70062_1_, (ItemStack) itemStack);
	}

	@Override
	public void superSetCommandStats(Object entity) {
	}

	@Override
	public boolean superProcessInitialInteract(Object entityPlayer, Object itemStack, Object enumHand) {
		return super.interact((EntityPlayer) entityPlayer);
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
		super.updateRiderPosition();
	}

	@Override
	public void superApplyOrientationToEntity(Object entity) {
	}

	@Override
	public boolean superStartRiding(Object entity, boolean force) {
		super.mountEntity((Entity) entity);
		return true;
	}

	@Override
	public boolean superCanBeRidden(Object entity) {
		return true;
	}

	@Override
	public void superRemovePassengers() {
		super.mountEntity(null);
	}

	@Override
	public void superDismountRidingEntity() {
		super.mountEntity(null);
	}

	@Override
	public void superAddPassenger(Object entity) {
		super.mountEntity((Entity) entity);
	}

	@Override
	public void superRemovePassenger(Object entity) {
		super.mountEntity(null);
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
		super.setCurrentItemOrArmor((Integer) entityEquipmentSlot, (ItemStack) itemStack);
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
		return false;
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
		return false;
	}

	@Override
	public Object superGetPassengers() {
		return null;
	}

	@Override
	public boolean superIsPassenger(Object entity) {
		return true;
	}

	@Override
	public Object superGetRecursivePassengers() {
		return null;
	}

	@Override
	public Object superGetLowestRidingEntity() {
		if (ridingEntity != null); else return null;
		for (Object entity1 = this; entity1 != null; entity1 = ((Entity) entity1).ridingEntity) {
			if (((Entity) entity1).ridingEntity != null
					| entity1.equals(this)); else return entity1;
		}
		return null;
	}

	@Override
	public boolean superIsRidingSameEntity(Object entity) {
		if (ridingEntity != null); else return false;
		for (Object entity1 = this; entity1 != null; entity1 = ((Entity) entity1).ridingEntity) {
			if (ridingEntity.equals(entity)) return true;
		}
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

	@Override
	public boolean superAttemptTeleport(double x, double y, double z) {
		return false;
	}
	// Modchu_Entity のコピー↑

}