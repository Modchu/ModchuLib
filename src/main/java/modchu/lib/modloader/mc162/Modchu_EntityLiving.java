package modchu.lib.modloader.mc162;

import java.util.Collection;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityLiving;
import modchu.lib.Modchu_IEntityLivingMaster;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import net.minecraft.src.Attribute;
import net.minecraft.src.AttributeInstance;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.BaseAttributeMap;
import net.minecraft.src.Block;
import net.minecraft.src.CombatTracker;
import net.minecraft.src.CrashReportCategory;
import net.minecraft.src.DamageSource;
import net.minecraft.src.DataWatcher;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityJumpHelper;
import net.minecraft.src.EntityLightningBolt;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityLivingBase;
import net.minecraft.src.EntityLivingData;
import net.minecraft.src.EntityLookHelper;
import net.minecraft.src.EntityMoveHelper;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntitySenses;
import net.minecraft.src.EnumCreatureAttribute;
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
import net.minecraft.src.SharedMonsterAttributes;
import net.minecraft.src.Team;
import net.minecraft.src.Vec3;
import net.minecraft.src.World;

public class Modchu_EntityLiving extends EntityLiving implements Modchu_IEntityLiving {
	public Modchu_IEntityLivingMaster master;
	public String entityName;
	public static ConcurrentHashMap<String, UUID> entityUniqueIDMap = new ConcurrentHashMap();
	protected UUID entityUniqueID;
	protected int maxHealth;
	private boolean initFlag;

	public Modchu_EntityLiving(World world) {
		super(world);
		entityUniqueID = UUID.randomUUID();
		ignoreFrustumCheck = true;
		initFlag = false;
		init((HashMap)null);
	}

	public Modchu_EntityLiving(HashMap<String, Object> map) {
		this((World) map.get("Object"));
		initFlag = false;
		init(map);
	}

	@Override
	public void entityDataManagerRegister(Class c, Class[] c1, int i, Object o) {
		dataWatcher.addObject(i, o);
	}

	@Override
	public Object getDataWatcherGetWatchableObject(int i) {
		Object watchedObject = Modchu_AS.get("DataWatcher", "getWatchedObject", new Class[]{ int.class }, dataWatcher, new Object[]{ i });
		return watchedObject != null ? Modchu_AS.get("net.minecraft.entity.DataWatcher$WatchableObject", "getObject", watchedObject) : null;
	}

	@Override
	public void setDataWatcherGetWatchableObject(int i, Object o) {
		dataWatcher.updateObject(i, o);
	}

	@Override
	public ConcurrentHashMap getDataParameterMap() {
		return null;
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
	public EntityLivingBase getAttackTarget() {
		return (EntityLivingBase) (master != null ? master.getAttackTarget() : super.getAttackTarget());
	}

	@Override
	public EntityLivingBase superGetAttackTarget() {
		return super.getAttackTarget();
	}

	@Override
	public void setAttackTarget(EntityLivingBase entityLivingBase) {
		if (master != null) master.setAttackTarget(entityLivingBase);
		else super.setAttackTarget(entityLivingBase);
	}

	@Override
	public void superSetAttackTarget(Object entityLivingBase) {
		super.setAttackTarget((EntityLivingBase) entityLivingBase);
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
	public void spawnExplosionParticle() {
		if (master != null) master.spawnExplosionParticle();
		else super.spawnExplosionParticle();
	}

	@Override
	public void superSpawnExplosionParticle() {
		super.spawnExplosionParticle();
	}

	@Override
	protected String getLivingSound() {
		return (String) (master != null ? master.getAmbientSound() : super.getLivingSound());
	}

	@Override
	public String superGetAmbientSound() {
		return super.getLivingSound();
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
	public void setMoveForward(float par1) {
		if (master != null) master.setMoveForward(par1);
		else super.setMoveForward(par1);
	}

	@Override
	public void superSetMoveForward(float par1) {
		super.setMoveForward(par1);
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
	public float getRenderSizeModifier() {
		return master != null ? master.getRenderSizeModifier() : super.getRenderSizeModifier();
	}

	@Override
	public float superGetRenderSizeModifier() {
		return super.getRenderSizeModifier();
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
	public ItemStack func_130225_q(int var1) {
		return (ItemStack) (master != null ? master.getCurrentArmor(var1) : super.func_130225_q(var1));
	}

	@Override
	public ItemStack superGetCurrentArmor(int var1) {
		return super.func_130225_q(var1);
	}

	@Override
	protected void addRandomArmor() {
		if (master != null) master.addRandomArmor();
		else super.addRandomArmor();
	}

	public void superAddRandomArmor() {
		super.addRandomArmor();
	}

	@Override
	protected void enchantEquipment() {
		if (master != null) master.enchantEquipment();
		else super.enchantEquipment();
	}

	@Override
	public void superEnchantEquipment() {
		super.enchantEquipment();
	}

	@Override
	public EntityLivingData onSpawnWithEgg(EntityLivingData entityLivingData) {
		return (EntityLivingData) (master != null ? master.onSpawnWithEgg(entityLivingData) : super.onSpawnWithEgg(entityLivingData));
	}

	@Override
	public EntityLivingData superOnSpawnWithEgg(Object entityLivingData) {
		return super.onSpawnWithEgg((EntityLivingData) entityLivingData);
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
	public void func_110163_bv() {
		if (master != null) master.enablePersistence();
		else super.func_110163_bv();
	}

	public void superFunc_110163_bv() {
		super.func_110163_bv();
	}

	@Override
	public void setCustomNameTag(String par1Str) {
		if (master != null) master.setCustomNameTag(par1Str);
		else super.setCustomNameTag(par1Str);
	}

	@Override
	public void superSetCustomNameTag(String par1Str) {
		super.setCustomNameTag(par1Str);
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
	public boolean hasCustomNameTag() {
		return master != null ? master.hasCustomNameTag() : super.hasCustomNameTag();
	}

	@Override
	public boolean superHasCustomNameTag() {
		return super.hasCustomNameTag();
	}

	@Override
	public void setAlwaysRenderNameTag(boolean par1) {
		if (master != null) master.setAlwaysRenderNameTag(par1);
		else super.setAlwaysRenderNameTag(par1);
	}

	@Override
	public void superSetAlwaysRenderNameTag(boolean par1) {
		super.setAlwaysRenderNameTag(par1);
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
	public boolean isNoDespawnRequired() {
		return master != null ? master.isNoDespawnRequired() : super.isNoDespawnRequired();
	}

	@Override
	public boolean superIsNoDespawnRequired() {
		return super.isNoDespawnRequired();
	}

	@Override
	protected boolean interact(EntityPlayer entityPlayer) {
		return master != null ? master.interact(entityPlayer) : super.interact(entityPlayer);
	}

	@Override
	public boolean superInteract(Object entityPlayer) {
		return super.interact((EntityPlayer) entityPlayer);
	}

	@Override
	protected void func_110159_bB() {
		if (master != null) master.updateLeashedState();
		else super.func_110159_bB();
	}

	@Override
	public void superUpdateLeashedState() {
		super.func_110159_bB();
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
		return master != null ? master.allowLeashing() : super.allowLeashing();
	}

	@Override
	public boolean superAllowLeashing() {
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
	public void superEnablePersistence() {
	}

	@Override
	public void superInit() {
	}

	@Override
	public void superSetMaxHealth(Object floatOrInt) {
		maxHealth = (Integer) floatOrInt;
	}

	// TODO Modchu_EntityLivingBase のコピー↓（からのエラー対処有り）
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

	public Object getMaster() {
		//Modchu_Debug.mDebug("Modchu_EntityLivingBase getMaster master="+master);
		if (master != null) ;else {
			init(entityName);
		}
		//Modchu_Debug.mDebug("Modchu_EntityLivingBase getMaster return master="+master);
		return master;
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

	protected void init(String s) {
		Class c = Modchu_Reflect.loadClass(s);
		if (c != null); else return;
		HashMap<String, Object> map = Modchu_Main.getNewModchuCharacteristicMap(c);
		init(map);
	}

	protected void init(HashMap<String, Object> map) {
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
		master = instance instanceof Modchu_IEntityLivingMaster ? (Modchu_IEntityLivingMaster) instance : null;
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

	public static void worldEventLoad(Object event) {
		if (entityUniqueIDMap != null) entityUniqueIDMap.clear();
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
	protected void applyEntityAttributes() {
		if (master != null) master.applyEntityAttributes();
		else super.applyEntityAttributes();
	}

	@Override
	public void superApplyEntityAttributes() {
		super.applyEntityAttributes();
	}

	@Override
	protected void updateFallState(double par1, boolean par3) {
		if (master != null) master.updateFallState(par1, par3);
		else super.updateFallState(par1, par3);
	}

	@Override
	public void superUpdateFallState(double par1, boolean par3) {
		super.updateFallState(par1, par3);
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
	public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.writeEntityToNBT(nBTTagCompound);
		else super.writeEntityToNBT(nBTTagCompound);
	}

	@Override
	public void superWriteEntityToNBT(Object nBTTagCompound) {
		super.writeEntityToNBT((NBTTagCompound) nBTTagCompound);
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
		if (master != null) master.setHealth(par1);
		else super.setHealth(par1);
	}

	public void superSetHealth(float par1) {
		super.setHealth(par1);
	}

	@Override
	public boolean attackEntityFrom(DamageSource damageSource, float par2) {
		return master != null ? master.attackEntityFrom(damageSource, par2) : super.attackEntityFrom(damageSource, par2);
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
	public void superOnDeath(Object damageSource) {
		super.onDeath((DamageSource) damageSource);
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
	protected void fall(float par1) {
		if (master != null) master.fall(par1);
		else super.fall(par1);
	}

	@Override
	public void superFall(float par1) {
		super.fall(par1);
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
	public void handleHealthUpdate(byte par1) {
		if (master != null) master.handleStatusUpdate(par1);
		else super.handleHealthUpdate(par1);
	}

	@Override
	public void superHandleStatusUpdate(byte par1) {
		super.handleHealthUpdate(par1);
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
	public AttributeInstance getEntityAttribute(Attribute attribute) {
		return (AttributeInstance) (master != null ? master.getEntityAttribute(attribute) : super.getEntityAttribute(attribute));
	}

	@Override
	public AttributeInstance superGetEntityAttribute(Object attribute) {
		return super.getEntityAttribute((Attribute) attribute);
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
	public ItemStack getCurrentItemOrArmor(int i) {
		return (ItemStack) (master != null ? master.getItemStackFromSlot(i) : null);
	}

	@Override
	public ItemStack superGetItemStackFromSlot(int i) {
		return null;
	}

	@Override
	public void setCurrentItemOrArmor(int i, ItemStack itemStack) {
		if (master != null) master.setCurrentItemOrArmor(i, itemStack);
	}

	@Override
	public void superSetCurrentItemOrArmor(int i, Object itemStack) {
	}

	@Override
	public void setSprinting(boolean par1) {
		if (master != null) master.setSprinting(par1);
		else super.setSprinting(par1);
	}

	@Override
	public void superSetSprinting(boolean par1) {
		super.setSprinting(par1);
	}

	@Override
	public ItemStack[] getLastActiveItems() {
		return (ItemStack[]) (master != null ? master.getLastActiveItems() : null);
	}

	@Override
	public ItemStack[] superGetLastActiveItems() {
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
	public void setPositionAndUpdate(double par1, double par3, double par5) {
		if (master != null) master.setPositionAndUpdate(par1, par3, par5);
		else super.setPositionAndUpdate(par1, par3, par5);
	}

	@Override
	public void superSetPositionAndUpdate(double par1, double par3, double par5) {
		super.setPositionAndUpdate(par1, par3, par5);
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
	public boolean getAlwaysRenderNameTagForRender() {
		return master != null ? master.getAlwaysRenderNameTagForRender() : super.getAlwaysRenderNameTagForRender();
	}

	@Override
	public boolean superGetAlwaysRenderNameTagForRender() {
		return super.getAlwaysRenderNameTagForRender();
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
	protected boolean isAIEnabled() {
		return master != null ? master.isAIEnabled() : super.isAIEnabled();
	}

	@Override
	public boolean superIsAIEnabled() {
		return super.isAIEnabled();
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
	public void onUpdate() {
		if (master != null) master.onUpdate();
		else super.onUpdate();
	}

	@Override
	public void superOnUpdate() {
		super.onUpdate();
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
	public void onLivingUpdate() {
		if (master != null) master.onLivingUpdate();
		else super.onLivingUpdate();
	}

	@Override
	public void superOnLivingUpdate() {
		super.onLivingUpdate();
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
	public void updateRidden() {
		if (master != null) master.updateRidden();
		else super.updateRidden();
	}

	@Override
	public void superUpdateRidden() {
		super.updateRidden();
	}

	@Override
	public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
		if (master != null) master.setPositionAndRotationDirect(par1, par3, par5, par7, par8, par9);
		else super.setPositionAndRotation2(par1, par3, par5, par7, par8, par9);
	}

	@Override
	public void superSetPositionAndRotationDirect(double par1, double par3, double par5, float par7, float par8, int par9) {
		super.setPositionAndRotation2(par1, par3, par5, par7, par8, par9);
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
	public Vec3 getLookVec() {
		return (Vec3) (master != null ? master.getLookVec() : super.getLookVec());
	}

	@Override
	public Vec3 superGetLookVec() {
		return super.getLookVec();
	}

	@Override
	public Vec3 getLook(float par1) {
		return (Vec3) (master != null ? master.getLook(par1) : super.getLook(par1));
	}

	@Override
	public Vec3 superGetLook(float par1) {
		return super.getLook(par1);
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
	public MovingObjectPosition rayTrace(double par1, float par3) {
		return (MovingObjectPosition) (master != null ? master.rayTrace(par1, par3) : super.rayTrace(par1, par3));
	}

	@Override
	public MovingObjectPosition superRayTrace(double par1, float par3) {
		return super.rayTrace(par1, par3);
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
	public float getEyeHeight() {
		return master != null ? master.getEyeHeight() : super.getEyeHeight();
	}

	@Override
	public float superGetEyeHeight() {
		return super.getEyeHeight();
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
	public void setRotationYawHead(float par1) {
		if (master != null) master.setRotationYawHead(par1);
		else super.setRotationYawHead(par1);
	}

	@Override
	public void superSetRotationYawHead(float par1) {
		super.setRotationYawHead(par1);
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
	public Team superGetTeam() {
		return super.getTeam();
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
	public DataWatcher getDataWatcher() {
		return (DataWatcher) (master != null ? master.getDataManager() : super.getDataWatcher());
	}

	@Override
	public DataWatcher superGetDataManager() {
		return super.getDataWatcher();
	}

	@Override
	public boolean equals(Object par1Obj) {
		return master != null ? master.equals(par1Obj) : super.equals(par1Obj);
	}

	@Override
	public boolean superEquals(Object par1Obj) {
		return super.equals(par1Obj);
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
	protected void setSize(float par1, float par2) {
		if (master != null) master.setSize(par1, par2);
		else super.setSize(par1, par2);
	}

	@Override
	public void superSetSize(float par1, float par2) {
		super.setSize(par1, par2);
	}

	@Override
	protected void setRotation(float par1, float par2) {
		if (master != null) master.setRotation(par1, par2);
		else super.setRotation(par1, par2);
	}

	@Override
	public void superSetRotation(float par1, float par2) {
		super.setRotation(par1, par2);
	}

	@Override
	public void setPosition(double par1, double par3, double par5) {
		if (master != null) master.setPosition(par1, par3, par5);
		else super.setPosition(par1, par3, par5);
	}

	@Override
	public void superSetPosition(double par1, double par3, double par5) {
		super.setPosition(par1, par3, par5);
	}

	@Override
	public void setAngles(float par1, float par2) {
		if (master != null) master.setAngles(par1, par2);
		else super.setAngles(par1, par2);
	}

	@Override
	public void superSetAngles(float par1, float par2) {
		super.setAngles(par1, par2);
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
	public void setFire(int par1) {
		if (master != null) master.setFire(par1);
		else super.setFire(par1);
	}

	@Override
	public void superSetFire(int par1) {
		super.setFire(par1);
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
	public boolean isOffsetPositionInLiquid(double par1, double par3, double par5) {
		return master != null ? master.isOffsetPositionInLiquid(par1, par3, par5) : super.isOffsetPositionInLiquid(par1, par3, par5);
	}

	@Override
	public boolean superIsOffsetPositionInLiquid(double par1, double par3, double par5) {
		return super.isOffsetPositionInLiquid(par1, par3, par5);
	}

	@Override
	public void moveEntity(double par1, double par3, double par5) {
		if (master != null) master.moveEntity(par1, par3, par5);
		else super.moveEntity(par1, par3, par5);
	}

	@Override
	public void superMoveEntity(double par1, double par3, double par5) {
		super.moveEntity(par1, par3, par5);
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
	protected void playStepSound(int par1, int par2, int par3, int par4) {
		if (master != null) master.playStepSound(par1, par2, par3, par4);
		else super.playStepSound(par1, par2, par3, par4);
	}

	@Override
	public void playSound(String par1Str, float par2, float par3) {
		if (master != null) master.playSound(par1Str, par2, par3);
		else super.playSound(par1Str, par2, par3);
	}

	@Override
	public void superPlaySound(Object par1Str, float par2, float par3) {
		super.playSound((String) par1Str, par2, par3);
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
	public AxisAlignedBB getBoundingBox() {
		return (AxisAlignedBB) (master != null ? master.getCollisionBoundingBox() : super.getBoundingBox());
	}

	@Override
	public AxisAlignedBB superGetCollisionBoundingBox() {
		return super.getBoundingBox();
	}

	@Override
	protected void dealFireDamage(int par1) {
		if (master != null) master.dealFireDamage(par1);
		else super.dealFireDamage(par1);
	}

	@Override
	public void superDealFireDamage(int par1) {
		super.dealFireDamage(par1);
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

	public boolean superHandleLavaMovement() {
		return super.handleLavaMovement();
	}

	@Override
	public void moveFlying(float par1, float par2, float par3) {
		if (master != null) master.moveRelative(par1, par2, par3);
		else super.moveFlying(par1, par2, par3);
	}

	@Override
	public void superMoveRelative(float par1, float par2, float par3) {
		super.moveFlying(par1, par2, par3);
	}

	@Override
	public int getBrightnessForRender(float par1) {
		return master != null ? master.getBrightnessForRender(par1) : super.getBrightnessForRender(par1);
	}

	@Override
	public int superGetBrightnessForRender(float par1) {
		return super.getBrightnessForRender(par1);
	}

	@Override
	public float getBrightness(float par1) {
		return master != null ? master.getBrightness(par1) : super.getBrightness(par1);
	}

	@Override
	public float superGetBrightness(float par1) {
		return super.getBrightness(par1);
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
	public void setPositionAndRotation(double par1, double par3, double par5, float par7, float par8) {
		if (master != null) master.setPositionAndRotation(par1, par3, par5, par7, par8);
		else super.setPositionAndRotation(par1, par3, par5, par7, par8);
	}

	@Override
	public void superSetPositionAndRotation(double par1, double par3, double par5, float par7, float par8) {
		super.setPositionAndRotation(par1, par3, par5, par7, par8);
	}

	@Override
	public void setLocationAndAngles(double par1, double par3, double par5, float par7, float par8) {
		if (master != null) master.setLocationAndAngles(par1, par3, par5, par7, par8);
		else super.setLocationAndAngles(par1, par3, par5, par7, par8);
	}

	@Override
	public void superSetLocationAndAngles(double par1, double par3, double par5, float par7, float par8) {
		super.setLocationAndAngles(par1, par3, par5, par7, par8);
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
	public double getDistanceSq(double par1, double par3, double par5) {
		return master != null ? master.getDistanceSq(par1, par3, par5) : super.getDistanceSq(par1, par3, par5);
	}

	@Override
	public double superGetDistanceSq(double par1, double par3, double par5) {
		return super.getDistanceSq(par1, par3, par5);
	}

	@Override
	public double getDistance(double par1, double par3, double par5) {
		return master != null ? master.getDistance(par1, par3, par5) : super.getDistance(par1, par3, par5);
	}

	@Override
	public double superGetDistance(double par1, double par3, double par5) {
		return super.getDistance(par1, par3, par5);
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
	public void addVelocity(double par1, double par3, double par5) {
		if (master != null) master.addVelocity(par1, par3, par5);
		else super.addVelocity(par1, par3, par5);
	}

	@Override
	public void superAddVelocity(double par1, double par3, double par5) {
		super.addVelocity(par1, par3, par5);
	}

	@Override
	public void addToPlayerScore(Entity entity, int par2) {
		if (master != null) master.addToPlayerScore(entity, par2);
		else super.addToPlayerScore(entity, par2);
	}

	@Override
	public void superAddToPlayerScore(Object entity, int par2) {
		super.addToPlayerScore((Entity) entity, par2);
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
	public boolean isInRangeToRenderDist(double par1) {
		return master != null ? master.isInRangeToRenderDist(par1) : super.isInRangeToRenderDist(par1);
	}

	@Override
	public boolean superIsInRangeToRenderDist(double par1) {
		return super.isInRangeToRenderDist(par1);
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
	protected NBTTagList newDoubleNBTList(double... par1ArrayOfDouble) {
		return (NBTTagList) (master != null ? master.newDoubleNBTList(par1ArrayOfDouble) : super.newDoubleNBTList(par1ArrayOfDouble));
	}

	@Override
	public NBTTagList superNewDoubleNBTList(double... par1ArrayOfDouble) {
		return super.newDoubleNBTList(par1ArrayOfDouble);
	}

	@Override
	protected NBTTagList newFloatNBTList(float... par1ArrayOfFloat) {
		return (NBTTagList) (master != null ? master.newFloatNBTList(par1ArrayOfFloat) : super.newFloatNBTList(par1ArrayOfFloat));
	}

	@Override
	public NBTTagList superNewFloatNBTList(float... par1ArrayOfFloat) {
		return super.newFloatNBTList(par1ArrayOfFloat);
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
	public EntityItem dropItem(int par1, int par2) {
		return (EntityItem) (master != null ? master.dropItem(par1, par2) : super.dropItem(par1, par2));
	}

	@Override
	public EntityItem dropItemWithOffset(int par1, int par2, float par3) {
		return (EntityItem) (master != null ? master.dropItemWithOffset(par1, par2, par3) : super.dropItemWithOffset(par1, par2, par3));
	}

	@Override
	public EntityItem entityDropItem(ItemStack itemStack, float par2) {
		return (EntityItem) (master != null ? master.entityDropItem(itemStack, par2) : super.entityDropItem(itemStack, par2));
	}

	@Override
	public EntityItem superEntityDropItem(Object itemStack, float par2) {
		return super.entityDropItem((ItemStack) itemStack, par2);
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
	public float getCollisionBorderSize() {
		return master != null ? master.getCollisionBorderSize() : super.getCollisionBorderSize();
	}

	@Override
	public float superGetCollisionBorderSize() {
		return super.getCollisionBorderSize();
	}

	@Override
	public void setInPortal() {
		if (master != null) master.setInPortal();
		else super.setInPortal();
	}

	public void superSetInPortal() {
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
	public void setVelocity(double par1, double par3, double par5) {
		if (master != null) master.setVelocity(par1, par3, par5);
		else super.setVelocity(par1, par3, par5);
	}

	@Override
	public void superSetVelocity(double par1, double par3, double par5) {
		super.setVelocity(par1, par3, par5);
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
	public void setSneaking(boolean par1) {
		if (master != null) master.setSneaking(par1);
		else super.setSneaking(par1);
	}

	@Override
	public void superSetSneaking(boolean par1) {
		super.setSneaking(par1);
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
	public boolean isInvisibleToPlayer(EntityPlayer entityPlayer) {
		return master != null ? master.isInvisibleToPlayer(entityPlayer) : super.isInvisibleToPlayer(entityPlayer);
	}

	@Override
	public boolean superIsInvisibleToPlayer(Object entityPlayer) {
		return super.isInvisibleToPlayer((EntityPlayer) entityPlayer);
	}

	@Override
	public void setInvisible(boolean par1) {
		if (master != null) master.setInvisible(par1);
		else super.setInvisible(par1);
	}

	@Override
	public void superSetInvisible(boolean par1) {
		super.setInvisible(par1);
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
	public void setEating(boolean par1) {
		if (master != null) master.setEating(par1);
		else super.setEating(par1);
	}

	@Override
	public void superSetEating(boolean par1) {
		super.setEating(par1);
	}

	@Override
	protected boolean getFlag(int par1) {
		return master != null ? master.getFlag(par1) : super.getFlag(par1);
	}

	@Override
	public boolean superGetFlag(int par1) {
		return super.getFlag(par1);
	}

	@Override
	protected void setFlag(int par1, boolean par2) {
		if (master != null) master.setFlag(par1, par2);
		else super.setFlag(par1, par2);
	}

	@Override
	public void superSetFlag(int par1, boolean par2) {
		super.setFlag(par1, par2);
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
	public void setAir(int par1) {
		if (master != null) master.setAir(par1);
		else super.setAir(par1);
	}

	@Override
	public void superSetAir(int par1) {
		super.setAir(par1);
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
	protected boolean pushOutOfBlocks(double par1, double par3, double par5) {
		return master != null ? master.pushOutOfBlocks(par1, par3, par5) : super.pushOutOfBlocks(par1, par3, par5);
	}

	@Override
	public boolean superPushOutOfBlocks(double par1, double par3, double par5) {
		return super.pushOutOfBlocks(par1, par3, par5);
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
	public String getEntityName() {
		return master != null ? master.getName() : super.getEntityName();
	}

	@Override
	public String superGetName() {
		return super.getEntityName();
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
	public String toString() {
		return master != null ? master.toString() : super.toString();
	}

	@Override
	public String superToString() {
		return super.toString();
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
	public void copyDataFrom(Entity entity, boolean par2) {
		if (master != null) master.copyDataFrom(entity, par2);
		else super.copyDataFrom(entity, par2);
	}

	@Override
	public void superCopyDataFrom(Object entity, boolean par2) {
		super.copyDataFrom((Entity) entity, par2);
	}

	@Override
	public void travelToDimension(int par1) {
		if (master != null) master.changeDimension(par1);
		else super.travelToDimension(par1);
	}

	@Override
	public Object superChangeDimension(int par1) {
		super.travelToDimension(par1);
		return this;
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
	public String getTranslatedEntityName() {
		return master != null ? master.getTranslatedEntityName() : super.getTranslatedEntityName();
	}

	@Override
	public String superGetTranslatedEntityName() {
		return super.getTranslatedEntityName();
	}

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
	public boolean superAttackEntityFrom(Object damageSource, Object p_70097_2_) {
		return false;
	}

	@Override
	public boolean superIsInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
		return false;
	}

	@Override
	public Object superDropItem(Object item, int p_145779_2_) {
		return null;
	}

	@Override
	public void superSetPortal(Object blockPos) {
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
	public Object superGetPositionEyes(float p_174824_1_) {
		return null;
	}

	@Override
	public Object superDropItemWithOffset(Object item, int size, float p_145778_3_) {
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
	public void superAddChatMessage(Object iChatComponent) {
	}

	@Override
	public boolean superCanCommandSenderUseCommand(int permLevel, String commandName) {
		return false;
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
		return 0.0F;
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
	public void superHeal(int par1) {
	}

	@Override
	public Object superGetHealth() {
		return null;
	}

	@Override
	public void superSetHealth(Object par1) {
	}

	@Override
	public boolean superAttackEntityFrom(Object damageSource, int par2) {
		return false;
	}

	@Override
	public void superDamageArmor(int par1) {
	}

	@Override
	public Object superApplyArmorCalculations(Object damageSource, int par2) {
		return 0.0F;
	}

	@Override
	public Object superApplyPotionDamageCalculations(Object damageSource, int par2) {
		return 0.0F;
	}

	@Override
	public void superDamageEntity(Object damageSource, int par2) {
	}

	@Override
	public void superKnockBack(Object entity, int par2, double par3, double par5) {
	}

	@Override
	public boolean superIsBlocking() {
		return false;
	}

	@Override
	public void superOnChangedPotionEffect(Object potionEffect) {
	}

	@Override
	public float superGetSpeedModifier() {
		return 0.0F;
	}

	@Override
	public void superAddRandomDrop() {
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
	public boolean superIsNotColliding() {
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
	public boolean superInteractFirst(Object entityPlayer) {
		return super.interactFirst((EntityPlayer) entityPlayer);
	}

	@Override
	public void superUnmountEntity(Object entity) {
	}

	@Override
	public void superSetPortal() {
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

	@Override
	public void superHeal(Object par1) {
		super.heal((Float) par1);
	}

	@Override
	public void superDamageEntity(Object damageSource, Object par2) {
		super.damageEntity((DamageSource) damageSource, (Float) par2);
	}

	@Override
	public void superPlayStepSound(int par1, int par2, int par3, Object par4) {
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

	@Override
	public boolean superCanRiderInteract() {
		return false;
	}

	@Override
	public boolean superShouldDismountInWater(Object entity) {
		return false;
	}

	@Override
	public void superCurePotionEffects(Object itemStack) {
	}

	@Override
	public boolean superShouldRiderFaceForward(Object entityPlayer) {
		return false;
	}

	@Override
	public Object superGetEntityData() {
		return null;
	}

	@Override
	public boolean superShouldRiderSit() {
		return false;
	}

	@Override
	public Object superGetPickedResult(Object movingObjectPosition) {
		return null;
	}

	@Override
	public UUID superGetPersistentID() {
		return null;
	}

	@Override
	public boolean superShouldRenderInPass(int pass) {
		return false;
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
	public void superDropLoot() {
	}

	@Override
	public void superSetNoAI(boolean par1) {
	}

	@Override
	public Object superGetCurrentItemOrArmor(int par1) {
		return null;
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

	@Override
	public Object superGetTeleportDirection() {
		return super.getTeleportDirection();
	}
	// Modchu_EntityLivingBase のコピー↑

}