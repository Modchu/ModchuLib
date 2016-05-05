package modchu.lib.forge.mc190;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_CastHelper;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityLivingBase;
import modchu.lib.Modchu_IEntityLivingBaseMaster;
import modchu.lib.Modchu_IEntityTameableMaster;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import net.minecraft.block.Block;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.CommandResultStats.Type;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
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
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.scoreboard.Team;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.CombatTracker;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
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

public class Modchu_EntityLivingBase extends EntityLivingBase implements Modchu_IEntityLivingBase {
	public Modchu_IEntityLivingBaseMaster master;
	public String entityName;
	public static ConcurrentHashMap<String, UUID> entityUniqueIDMap = new ConcurrentHashMap();
	private ConcurrentHashMap<String, DataParameter> dataParameterMap = new ConcurrentHashMap();
	protected UUID entityUniqueID;
	protected int maxHealth;
	private boolean initFlag;

	public Modchu_EntityLivingBase(World world) {
		super(world);
		entityUniqueID = UUID.randomUUID();
		ignoreFrustumCheck = true;
		initFlag = false;
		init((HashMap)null);
	}

	public Modchu_EntityLivingBase(HashMap<String, Object> map) {
		this((World) map.get("Object"));
		initFlag = false;
		init(map);
	}

	@Override
	public void entityDataManagerRegister(Class c, Class[] c1, int i, Object o) {
		DataParameter dataParameter = (DataParameter) Modchu_AS.get(Modchu_AS.newDataParameter, getClass(), c1, i);
		if (dataParameter != null) {
			dataWatcher.register(dataParameter, o);
			String key= c.getName() + i;
			dataParameterMap.put(key, dataParameter);
		} else {
			String ss = "Modchu_EntityLivingBase entityDataManagerRegister dataParameter == null error !! c="+c+" c1="+c1+" i="+i+" o="+o;
			Modchu_Debug.mDebug(ss);
			Modchu_Main.setRuntimeException(ss);
		}
	}

	@Override
	public Object getDataWatcherGetWatchableObject(int i) {
		String key= master.getClass().getName() + i;
		DataParameter dataParameter = dataParameterMap.get(key);
		return dataWatcher.get(dataParameter);
	}

	@Override
	public void setDataWatcherGetWatchableObject(int i, Object o) {
		String key= master.getClass().getName() + i;
		DataParameter dataParameter = dataParameterMap.get(key);
		dataWatcher.set(dataParameter, o);
	}

	@Override
	public ConcurrentHashMap getDataParameterMap() {
		return dataParameterMap;
	}

	@Override
	public void setMovementSpeed(double d) {
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(d);
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
	public void setMaxHealth(double d) {
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(d);
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
	public IAttributeInstance getEntityAttribute(IAttribute attribute) {
		return (IAttributeInstance) (master != null ? master.getEntityAttribute(attribute) : super.getEntityAttribute(attribute));
	}

	@Override
	public IAttributeInstance superGetEntityAttribute(Object attribute) {
		return super.getEntityAttribute((IAttribute) attribute);
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
	public void setItemStackToSlot(EntityEquipmentSlot entityEquipmentSlot, ItemStack itemStack) {
		if (master != null) master.setItemStackToSlot(entityEquipmentSlot, itemStack);
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
	public void onUpdate() {
		if (master != null) master.onUpdate();
		else super.onUpdate();
	}

	@Override
	public void superOnUpdate() {
		super.onUpdate();
	}

	@Override
	protected float updateDistance(float par1, float par2) {
		return master != null ? master.updateDistance(par1, par2) : super.updateDistance(par1, par2);
	}

	@Override
	public float superUpdateDistance(float par1, float par2) {
		return super.updateDistance(par1, par2);
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
	protected void updateAITick() {
		if (master != null) master.updateAITick();
		else super.updateAITick();
	}

	@Override
	public void superUpdateAITick() {
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
	public Vec3d getLookVec() {
		return (Vec3d) (master != null ? master.getLookVec() : super.getLookVec());
	}

	@Override
	public Object superGetLookVec() {
		return super.getLookVec();
	}

	@Override
	public Vec3d getLook(float par1) {
		return (Vec3d) (master != null ? master.getLook(par1) : super.getLook(par1));
	}

	@Override
	public Vec3d superGetLook(float par1) {
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
	public RayTraceResult rayTrace(double par1, float par3) {
		return (RayTraceResult) (master != null ? master.rayTrace(par1, par3) : super.rayTrace(par1, par3));
	}

	@Override
	public RayTraceResult superRayTrace(double par1, float par3) {
		return super.rayTrace(par1, par3);
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
	public EntityDataManager getDataManager() {
		return (EntityDataManager) (master != null ? master.getDataManager() : super.getDataManager());
	}

	@Override
	public Object superGetDataManager() {
		return super.getDataManager();
	}

	@Override
	public boolean equals(Object par1Obj) {
		return master != null ? master.equals(par1Obj) : super.equals(par1Obj);
	}

	public boolean superEquals(Object par1Obj) {
		return super.equals(par1Obj);
	}

	@Override
	public int hashCode() {
		return master != null ? master.hashCode() : super.hashCode();
	}

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
	public void playSound(SoundEvent soundEvent, float par2, float par3) {
		if (master != null) master.playSound(soundEvent, par2, par3);
		else super.playSound(soundEvent, par2, par3);
	}

	@Override
	public void superPlaySound(Object soundEvent, float par2, float par3) {
		super.playSound((SoundEvent) soundEvent, par2, par3);
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
	public void moveFlying(float par1, float par2, float par3) {
		if (master != null) master.moveFlying(par1, par2, par3);
		else super.moveFlying(par1, par2, par3);
	}

	@Override
	public void superMoveFlying(float par1, float par2, float par3) {
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
	public boolean isInRangeToRender3d(double d, double d1, double d2) {
		return master != null ? master.isInRangeToRender3d(d, d1, d2) : super.isInRangeToRender3d(d, d1, d2);
	}

	@Override
	public boolean superIsInRangeToRender3d(double d, double d1, double d2) {
		return super.isInRangeToRender3d(d, d1, d2);
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
	public void writeToNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.writeToNBT(nBTTagCompound);
		else super.writeToNBT(nBTTagCompound);
	}

	@Override
	public void superWriteToNBT(Object nBTTagCompound) {
		super.writeToNBT((NBTTagCompound) nBTTagCompound);
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
	public EntityItem dropItem(Item par1, int par2) {
		return (EntityItem) (master != null ? master.dropItem(par1, par2) : super.dropItem(par1, par2));
	}

	@Override
	public Object superDropItem(Object par1, int par2) {
		return super.dropItem((Item) par1, par2);
	}

	@Override
	public EntityItem dropItemWithOffset(Item par1, int par2, float par3) {
		return (EntityItem) (master != null ? master.dropItemWithOffset(par1, par2, par3) : super.dropItemWithOffset(par1, par2, par3));
	}

	@Override
	public EntityItem superDropItemWithOffset(Object par1, int par2, float par3) {
		return super.dropItemWithOffset((Item) par1, par2, par3);
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
	public boolean processInitialInteract(EntityPlayer entityPlayer, ItemStack itemStack, EnumHand enumHand) {
		return master != null ? master.processInitialInteract(entityPlayer, itemStack, enumHand) : super.processInitialInteract(entityPlayer, itemStack, enumHand);
	}

	@Override
	public boolean superProcessInitialInteract(Object entityPlayer, Object itemStack, Object enumHand) {
		return super.processInitialInteract((EntityPlayer) entityPlayer, (ItemStack) itemStack, (EnumHand) enumHand);
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
		return master != null ? master.canAttackWithItem() : super.canAttackWithItem();
	}

	@Override
	public boolean superCanAttackWithItem() {
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

	@Override
	public void superFunc_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Object block) {
	}

	@Override
	public boolean superAttackEntityFrom(Object damageSource, Object p_70097_2_) {
		return super.attackEntityFrom((DamageSource) damageSource, (Float) p_70097_2_);
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
	public void onKillCommand() {
		if (master != null) master.onKillCommand();
		else super.onKillCommand();
	}

	public void superOnKillCommand() {
		super.onKillCommand();
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
	public ItemStack getItemStackFromSlot(EntityEquipmentSlot entityEquipmentSlot) {
		return (ItemStack) (master != null ? master.getItemStackFromSlot(entityEquipmentSlot) : null);
	}

	@Override
	public Object superGetItemStackFromSlot(Object entityEquipmentSlot) {
		return null;
	}

	@Override
	public boolean isServerWorld() {
		return master != null ? master.isServerWorld() : super.isServerWorld();
	}

	public boolean superIsServerWorld() {
		return super.isServerWorld();
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
	protected SoundEvent getSwimSound() {
		return (SoundEvent) (master != null ? master.getSwimSound() : super.getSwimSound());
	}

	public Object superGetSwimSound() {
		return super.getSwimSound();
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
	protected void resetHeight() {
		if (master != null) master.resetHeight();
		else super.resetHeight();
	}

	public void superResetHeight() {
		super.resetHeight();
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
	protected SoundEvent getSplashSound() {
		return (SoundEvent) (master != null ? master.getSplashSound() : super.getSplashSound());
	}

	public Object superGetSplashSound() {
		return super.getSplashSound();
	}

	@Override
	public boolean isInLava() {
		return master != null ? master.isInLava() : super.isInLava();
	}

	public boolean superIsInLava() {
		return super.isInLava();
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
	public Vec3d getPositionEyes(float p_174824_1_) {
		return (Vec3d) (master != null ? master.getPositionEyes(p_174824_1_) : super.getPositionEyes(p_174824_1_));
	}

	public Object superGetPositionEyes(float p_174824_1_) {
		return super.getPositionEyes(p_174824_1_);
	}

	@Override
	public boolean isEntityInvulnerable(DamageSource damageSource) {
		return master != null ? master.isEntityInvulnerable(damageSource) : super.isEntityInvulnerable(damageSource);
	}

	public boolean superIsEntityInvulnerable(Object damageSource) {
		return super.isEntityInvulnerable((DamageSource) damageSource);
	}

	@Override
	public float getExplosionResistance(Explosion explosion, World world, BlockPos blockPos, IBlockState iBlockState) {
		return master != null ? master.getExplosionResistance(explosion, world, blockPos, iBlockState) : super.getExplosionResistance(explosion, world, blockPos, iBlockState);
	}

	public float superGetExplosionResistance(Object explosion, Object world, Object blockPos, Object iBlockState) {
		return super.getExplosionResistance((Explosion) explosion, (World) world, (BlockPos) blockPos, (IBlockState) iBlockState);
	}

	@Override
	public int getMaxFallHeight() {
		return master != null ? master.getMaxFallHeight() : super.getMaxFallHeight();
	}

	public int superGetMaxFallHeight() {
		return super.getMaxFallHeight();
	}

	@Override
	public ITextComponent getDisplayName() {
		return (ITextComponent) (master != null ? master.getDisplayName() : super.getDisplayName());
	}

	public Object superGetDisplayName() {
		return super.getDisplayName();
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
	public EnumFacing getHorizontalFacing() {
		return (EnumFacing) (master != null ? master.getHorizontalFacing() : super.getHorizontalFacing());
	}

	public EnumFacing superGetHorizontalFacing() {
		return super.getHorizontalFacing();
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
	public boolean replaceItemInInventory(int p_174820_1_, ItemStack itemStack) {
		return master != null ? master.replaceItemInInventory(p_174820_1_, itemStack) : super.replaceItemInInventory(p_174820_1_, itemStack);
	}

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
	public BlockPos getPosition() {
		return (BlockPos) (master != null ? master.getPosition() : super.getPosition());
	}

	public BlockPos superGetPosition() {
		return super.getPosition();
	}

	@Override
	public Vec3d getPositionVector() {
		return (Vec3d) (master != null ? master.getPositionVector() : super.getPositionVector());
	}

	public Object superGetPositionVector() {
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
	public boolean sendCommandFeedback() {
		return master != null ? master.sendCommandFeedback() : super.sendCommandFeedback();
	}

	public boolean superSendCommandFeedback() {
		return super.sendCommandFeedback();
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
	public void setCommandStats(Entity entity) {
		if (master != null) master.setCommandStats(entity);
		else super.setCommandStats(entity);
	}

	@Override
	public void superSetCommandStats(Object entity) {
		super.setCommandStats((Entity) entity);
	}
	// 190~
	@Override
	protected void frostWalk(BlockPos blockPos) {
		if (master != null) master.frostWalk(blockPos);
		else super.frostWalk(blockPos);
	}

	public void superFrostWalk(Object blockPos) {
		super.frostWalk((BlockPos) blockPos);
	}

	@Override
	protected void playEquipSound(ItemStack itemStack) {
		if (master != null) master.playEquipSound(itemStack);
		else super.playEquipSound(itemStack);
	}

	public void superPlayEquipSound(Object itemStack) {
		super.playEquipSound((ItemStack) itemStack);
	}

	@Override
	public PotionEffect removeActivePotionEffect(Potion potion) {
		return (PotionEffect) (master != null ? master.removeActivePotionEffect(potion) : super.removeActivePotionEffect(potion));
	}

	public Object superRemoveActivePotionEffect(Object potion) {
		return super.removeActivePotionEffect((Potion) potion);
	}

	@Override
	public void removePotionEffect(Potion potion) {
		if (master != null) master.removePotionEffect(potion);
		else super.removePotionEffect(potion);
	}

	public void superRemovePotionEffect(Object potion) {
		super.removePotionEffect((Potion) potion);
	}

	@Override
	protected void playHurtSound(DamageSource damageSource) {
		if (master != null) master.playHurtSound(damageSource);
		else super.playHurtSound(damageSource);
	}

	public void superPlayHurtSound(Object damageSource) {
		super.playHurtSound((DamageSource) damageSource);
	}

	@Override
	protected SoundEvent getFallSound(int heightIn) {
		return (SoundEvent) (master != null ? master.getFallSound(heightIn) : super.getFallSound(heightIn));
	}

	public Object superGetFallSound(int heightIn) {
		return super.getFallSound(heightIn);
	}

	@Override
	protected void damageShield(float p_184590_1_) {
		if (master != null) master.damageShield(p_184590_1_);
		else super.damageShield(p_184590_1_);
	}

	public void superDamageShield(float p_184590_1_) {
		super.damageShield(p_184590_1_);
	}

	@Override
	public ItemStack getHeldItemMainhand() {
		return (ItemStack) (master != null ? master.getHeldItemMainhand() : super.getHeldItemMainhand());
	}

	public Object superGetHeldItemMainhand() {
		return super.getHeldItemMainhand();
	}

	@Override
	public ItemStack getHeldItemOffhand() {
		return (ItemStack) (master != null ? master.getHeldItemOffhand() : super.getHeldItemOffhand());
	}

	public Object superGetHeldItemOffhand() {
		return super.getHeldItemOffhand();
	}

	@Override
	public ItemStack getHeldItem(EnumHand enumHand) {
		return (ItemStack) (master != null ? master.getHeldItem(enumHand) : super.getHeldItem(enumHand));
	}

	public Object superGetHeldItem(Object enumHand) {
		return super.getHeldItem((EnumHand) enumHand);
	}

	@Override
	public void setHeldItem(EnumHand enumHand, ItemStack itemStack) {
		if (master != null) master.setHeldItem(enumHand, itemStack);
		else super.setHeldItem(enumHand, itemStack);
	}

	public void superSetHeldItem(Object enumHand, Object itemStack) {
		super.setHeldItem((EnumHand) enumHand, (ItemStack) itemStack);
	}

	@Override
	public void dismountRidingEntity() {
		if (master != null) master.dismountRidingEntity();
		else super.dismountRidingEntity();
	}

	public void superDismountRidingEntity() {
		super.dismountRidingEntity();
	}

	@Override
	public boolean isHandActive() {
		return master != null ? master.isHandActive() : super.isHandActive();
	}

	public boolean superIsHandActive() {
		return super.isHandActive();
	}

	@Override
	public EnumHand getActiveHand() {
		return (EnumHand) (master != null ? master.getActiveHand() : super.getActiveHand());
	}

	public Object superGetActiveHand() {
		return super.getActiveHand();
	}

	@Override
	protected void updateActiveHand() {
		if (master != null) master.updateActiveHand();
		else super.updateActiveHand();
	}

	public void superUpdateActiveHand() {
		super.updateActiveHand();
	}

	@Override
	public void setActiveHand(EnumHand enumHand) {
		if (master != null) master.setActiveHand(enumHand);
		else super.setActiveHand(enumHand);
	}

	public void superSetActiveHand(Object enumHand) {
		super.setActiveHand((EnumHand) enumHand);
	}

	@Override
	public void notifyDataManagerChange(DataParameter<?> dataParameter) {
		if (master != null) master.notifyDataManagerChange(dataParameter);
		else super.notifyDataManagerChange(dataParameter);
	}

	public void superNotifyDataManagerChange(Object dataParameter) {
		super.notifyDataManagerChange((DataParameter) dataParameter);
	}

	@Override
	protected void updateItemUse(ItemStack itemStack, int p_184584_2_) {
		if (master != null) master.updateItemUse(itemStack, p_184584_2_);
		else super.updateItemUse(itemStack, p_184584_2_);
	}

	public void superUpdateItemUse(Object itemStack, int p_184584_2_) {
		super.updateItemUse((ItemStack) itemStack, p_184584_2_);
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
	public ItemStack getActiveItemStack() {
		return (ItemStack) (master != null ? master.getActiveItemStack() : super.getActiveItemStack());
	}

	public ItemStack superGetActiveItemStack() {
		return super.getActiveItemStack();
	}

	@Override
	public int getItemInUseCount() {
		return master != null ? master.getItemInUseCount() : super.getItemInUseCount();
	}

	public int superGetItemInUseCount() {
		return super.getItemInUseCount();
	}

	@Override
	public int getItemInUseMaxCount() {
		return master != null ? master.getItemInUseMaxCount() : super.getItemInUseMaxCount();
	}

	public int superGetItemInUseMaxCount() {
		return super.getItemInUseMaxCount();
	}

	@Override
	public void stopActiveHand() {
		if (master != null) master.stopActiveHand();
		else super.stopActiveHand();
	}

	public void superStopActiveHand() {
		super.stopActiveHand();
	}

	@Override
	public void resetActiveHand() {
		if (master != null) master.resetActiveHand();
		else super.resetActiveHand();
	}

	public void superResetActiveHand() {
		super.resetActiveHand();
	}

	@Override
	public boolean isActiveItemStackBlocking() {
		return master != null ? master.isActiveItemStackBlocking() : super.isActiveItemStackBlocking();
	}

	public boolean superIsActiveItemStackBlocking() {
		return super.isActiveItemStackBlocking();
	}

	@Override
	public boolean isElytraFlying() {
		return master != null ? master.isElytraFlying() : super.isElytraFlying();
	}

	public boolean superIsElytraFlying() {
		return super.isElytraFlying();
	}

	@Override
	public int getTicksElytraFlying() {
		return master != null ? master.getTicksElytraFlying() : super.getTicksElytraFlying();
	}

	public int superGetTicksElytraFlying() {
		return super.getTicksElytraFlying();
	}

	@Override
	public boolean teleportTo_(double x, double y, double z) {
		return master != null ? master.teleportTo_(x, y, z) : super.teleportTo_(x, y, z);
	}

	public boolean superTeleportTo_(double x, double y, double z) {
		return super.teleportTo_(x, y, z);
	}

	@Override
	public boolean canBeHitWithPotion() {
		return master != null ? master.canBeHitWithPotion() : super.canBeHitWithPotion();
	}

	public boolean superCanBeHitWithPotion() {
		return super.canBeHitWithPotion();
	}

	@Override
	public Set<String> getTags() {
		return (Set<String>) (master != null ? master.getTags() : super.getTags());
	}

	public Set<String> superGetTags() {
		return super.getTags();
	}

	@Override
	public boolean addTag(String tag) {
		return master != null ? master.addTag(tag) : super.addTag(tag);
	}

	public boolean superAddTag(String tag) {
		return super.addTag(tag);
	}

	@Override
	public boolean removeTag(String tag) {
		return master != null ? master.removeTag(tag) : super.removeTag(tag);
	}

	public boolean superRemoveTag(String tag) {
		return super.removeTag(tag);
	}

	@Override
	public void setDropItemsWhenDead(boolean p_184174_1_) {
		if (master != null) master.setDropItemsWhenDead(p_184174_1_);
		else super.setDropItemsWhenDead(p_184174_1_);
	}

	public void superSetDropItemsWhenDead(boolean p_184174_1_) {
		super.setDropItemsWhenDead(p_184174_1_);
	}

	@Override
	protected void decrementTimeUntilPortal() {
		if (master != null) master.decrementTimeUntilPortal();
		else super.decrementTimeUntilPortal();
	}

	public void superDecrementTimeUntilPortal() {
		super.decrementTimeUntilPortal();
	}

	@Override
	public void resetPositionToBB() {
		if (master != null) master.resetPositionToBB();
		else super.resetPositionToBB();
	}

	public void superResetPositionToBB() {
		super.resetPositionToBB();
	}

	@Override
	public void applyOrientationToEntity(Entity entity) {
		if (master != null) master.applyOrientationToEntity(entity);
		else super.applyOrientationToEntity(entity);
	}

	public void superApplyOrientationToEntity(Object entity) {
		super.applyOrientationToEntity((Entity) entity);
	}

	@Override
	public boolean startRiding(Entity entity, boolean force) {
		return master != null ? master.startRiding(entity, force) : super.startRiding(entity, force);
	}

	public boolean superStartRiding(Object entity, boolean force) {
		return super.startRiding((Entity) entity, force);
	}

	@Override
	protected boolean canBeRidden(Entity entity) {
		return master != null ? master.canBeRidden(entity) : super.canBeRidden(entity);
	}

	public boolean superCanBeRidden(Object entity) {
		return super.canBeRidden((Entity) entity);
	}

	@Override
	public void removePassengers() {
		if (master != null) master.removePassengers();
		else super.removePassengers();
	}

	public void superRemovePassengers() {
		super.removePassengers();
	}

	@Override
	protected void addPassenger(Entity entity) {
		if (master != null) master.addPassenger(entity);
		else super.addPassenger(entity);
	}

	public void superAddPassenger(Object entity) {
		super.addPassenger((Entity) entity);
	}

	@Override
	protected void removePassenger(Entity entity) {
		if (master != null) master.removePassenger(entity);
		else super.removePassenger(entity);
	}

	public void superRemovePassenger(Object entity) {
		super.removePassenger((Entity) entity);
	}

	@Override
	protected boolean canFitPassenger(Entity entity) {
		return master != null ? master.canFitPassenger(entity) : super.canFitPassenger(entity);
	}

	public boolean superCanFitPassenger(Object entity) {
		return super.canFitPassenger((Entity) entity);
	}

	@Override
	public Iterable<ItemStack> getHeldEquipment() {
		return (Iterable<ItemStack>) (master != null ? master.getHeldEquipment() : super.getHeldEquipment());
	}

	public Object superGetHeldEquipment() {
		return super.getHeldEquipment();
	}

	@Override
	public Iterable<ItemStack> getEquipmentAndArmor() {
		return (Iterable<ItemStack>) (master != null ? master.getEquipmentAndArmor() : super.getEquipmentAndArmor());
	}

	public Object superGetEquipmentAndArmor() {
		return super.getEquipmentAndArmor();
	}

	@Override
	public boolean isBeingRidden() {
		return master != null ? master.isBeingRidden() : super.isBeingRidden();
	}

	public boolean superIsBeingRidden() {
		return super.isBeingRidden();
	}

	@Override
	public boolean isGlowing() {
		return master != null ? master.isGlowing() : super.isGlowing();
	}

	public boolean superIsGlowing() {
		return super.isGlowing();
	}

	@Override
	public void setGlowing(boolean p_184195_1_) {
		if (master != null) master.setGlowing(p_184195_1_);
		else super.setGlowing(p_184195_1_);
	}

	public void superSetGlowing(boolean p_184195_1_) {
		super.setGlowing(p_184195_1_);
	}

	@Override
	public boolean isOnSameTeam(Entity entity) {
		return master != null ? master.isOnSameTeam(entity) : super.isOnSameTeam(entity);
	}

	public boolean superIsOnSameTeam(Object entity) {
		return super.isOnSameTeam((Entity) entity);
	}

	@Override
	public boolean isOnScoreboardTeam(Team team) {
		return master != null ? master.isOnScoreboardTeam(team) : super.isOnScoreboardTeam(team);
	}

	public boolean superIsOnScoreboardTeam(Object team) {
		return super.isOnScoreboardTeam((Team) team);
	}

	@Override
	public String getName() {
		return master != null ? master.getName() : super.getName();
	}

	public String superGetName() {
		return super.getName();
	}

	@Override
	public void setEntityInvulnerable(boolean isInvulnerable) {
		if (master != null) master.setEntityInvulnerable(isInvulnerable);
		else super.setEntityInvulnerable(isInvulnerable);
	}

	public void superSetEntityInvulnerable(boolean isInvulnerable) {
		super.setEntityInvulnerable(isInvulnerable);
	}

	@Override
	public boolean isNonBoss() {
		return master != null ? master.isNonBoss() : super.isNonBoss();
	}

	public boolean superIsNonBoss() {
		return super.isNonBoss();
	}

	@Override
	public void setUniqueId(UUID uniqueIdIn) {
		if (master != null) master.setUniqueId(uniqueIdIn);
		else super.setUniqueId(uniqueIdIn);
	}

	public void superSetUniqueId(UUID uniqueIdIn) {
		super.setUniqueId(uniqueIdIn);
	}

	@Override
	public EnumFacing getAdjustedHorizontalFacing() {
		return (EnumFacing) (master != null ? master.getAdjustedHorizontalFacing() : super.getAdjustedHorizontalFacing());
	}

	public Object superGetAdjustedHorizontalFacing() {
		return super.getAdjustedHorizontalFacing();
	}

	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return (AxisAlignedBB) (master != null ? master.getRenderBoundingBox() : super.getRenderBoundingBox());
	}

	public Object superGetRenderBoundingBox() {
		return super.getRenderBoundingBox();
	}

	@Override
	public MinecraftServer getServer() {
		return (MinecraftServer) (master != null ? master.getServer() : super.getServer());
	}

	public Object superGetServer() {
		return super.getServer();
	}

	@Override
	public EnumActionResult applyPlayerInteraction(EntityPlayer entityPlayer, Vec3d vec3d, ItemStack itemStack, EnumHand enumHand) {
		return (EnumActionResult) (master != null ? master.applyPlayerInteraction(entityPlayer, vec3d, itemStack, enumHand) : super.applyPlayerInteraction(entityPlayer, vec3d, itemStack, enumHand));
	}

	public Object superApplyPlayerInteraction(Object entityPlayer, Object vec3d, Object itemStack, Object enumHand) {
		return super.applyPlayerInteraction((EntityPlayer) entityPlayer, (Vec3d) vec3d, (ItemStack) itemStack, (EnumHand) enumHand);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing enumFacing) {
		return master != null ? master.hasCapability(capability, enumFacing) : super.hasCapability(capability, enumFacing);
	}

	public boolean superHasCapability(Object capability, Object enumFacing) {
		return super.hasCapability((Capability) capability, (EnumFacing) enumFacing);
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing enumFacing) {
		return (T) (master != null ? master.getCapability(capability, enumFacing) : super.getCapability(capability, enumFacing));
	}

	public Object superGetCapability(Object capability, Object enumFacing) {
		return super.getCapability((Capability) capability, (EnumFacing) enumFacing);
	}

	@Override
	public void deserializeNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.deserializeNBT(nBTTagCompound);
		else super.deserializeNBT(nBTTagCompound);
	}

	public void superDeserializeNBT(Object nBTTagCompound) {
		super.deserializeNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public NBTTagCompound serializeNBT() {
		return (NBTTagCompound) (master != null ? master.serializeNBT() : super.serializeNBT());
	}

	public Object superSerializeNBT() {
		return super.serializeNBT();
	}

	@Override
	public void setBossVisibleTo(EntityPlayerMP entityPlayerMP) {
		if (master != null) master.setBossVisibleTo(entityPlayerMP);
		else super.setBossVisibleTo(entityPlayerMP);
	}

	public void superSetBossVisibleTo(Object entityPlayerMP) {
		super.setBossVisibleTo((EntityPlayerMP) entityPlayerMP);
	}

	@Override
	public void setBossNonVisibleTo(EntityPlayerMP entityPlayerMP) {
		if (master != null) master.setBossNonVisibleTo(entityPlayerMP);
		else super.setBossNonVisibleTo(entityPlayerMP);
	}

	public void superSetBossNonVisibleTo(Object entityPlayerMP) {
		super.setBossNonVisibleTo((EntityPlayerMP) entityPlayerMP);
	}

	@Override
	public float getRotatedYaw(Rotation rotation) {
		return master != null ? master.getRotatedYaw(rotation) : super.getRotatedYaw(rotation);
	}

	public float superGetRotatedYaw(Object rotation) {
		return super.getRotatedYaw((Rotation) rotation);
	}

	@Override
	public float getMirroredYaw(Mirror mirror) {
		return master != null ? master.getMirroredYaw(mirror) : super.getMirroredYaw(mirror);
	}

	public float superGetMirroredYaw(Object mirror) {
		return super.getMirroredYaw((Mirror) mirror);
	}

	@Override
	public boolean func_184213_bq() {
		return master != null ? master.func_184213_bq() : super.func_184213_bq();
	}

	public boolean superFunc_184213_bq() {
		return super.func_184213_bq();
	}

	@Override
	public boolean setPositionNonDirty() {
		return master != null ? master.setPositionNonDirty() : super.setPositionNonDirty();
	}

	public boolean superSetPositionNonDirty() {
		return super.setPositionNonDirty();
	}

	@Override
	public Entity getControllingPassenger() {
		return (Entity) (master != null ? master.getControllingPassenger() : super.getControllingPassenger());
	}

	public Object superGetControllingPassenger() {
		return super.getControllingPassenger();
	}

	@Override
	public List<Entity> getPassengers() {
		return (List<Entity>) (master != null ? master.getPassengers() : super.getPassengers());
	}

	public List superGetPassengers() {
		return super.getPassengers();
	}

	@Override
	public boolean isPassenger(Entity entity) {
		return master != null ? master.isPassenger(entity) : super.isPassenger(entity);
	}

	public boolean superIsPassenger(Object entity) {
		return super.isPassenger((Entity) entity);
	}

	@Override
	public Collection<Entity> getRecursivePassengers() {
		return (Collection<Entity>) (master != null ? master.getRecursivePassengers() : super.getRecursivePassengers());
	}

	public Object superGetRecursivePassengers() {
		return super.getRecursivePassengers();
	}

	@Override
	public <T extends Entity> Collection<T> getRecursivePassengersByType(Class<T> entityClass) {
		return (Collection) (master != null ? master.getRecursivePassengersByType(entityClass) : super.getRecursivePassengersByType(entityClass));
	}

	public Object superGetRecursivePassengersByType(Class entityClass) {
		return super.getRecursivePassengersByType(entityClass);
	}

	@Override
	public Entity getLowestRidingEntity() {
		return (Entity) (master != null ? master.getLowestRidingEntity() : super.getLowestRidingEntity());
	}

	public Object superGetLowestRidingEntity() {
		return super.getLowestRidingEntity();
	}

	@Override
	public boolean isRidingSameEntity(Entity entity) {
		return master != null ? master.isRidingSameEntity(entity) : super.isRidingSameEntity(entity);
	}

	public boolean superIsRidingSameEntity(Object entity) {
		return super.isRidingSameEntity((Entity) entity);
	}

	@Override
	public boolean isRidingOrBeingRiddenBy(Entity entity) {
		return master != null ? master.isRidingOrBeingRiddenBy(entity) : super.isRidingOrBeingRiddenBy(entity);
	}

	public boolean superIsRidingOrBeingRiddenBy(Object entity) {
		return super.isRidingOrBeingRiddenBy((Entity) entity);
	}

	@Override
	public boolean canPassengerSteer() {
		return master != null ? master.canPassengerSteer() : super.canPassengerSteer();
	}

	public boolean superCanPassengerSteer() {
		return super.canPassengerSteer();
	}

	@Override
	public Entity getRidingEntity() {
		return (Entity) (master != null ? master.getRidingEntity() : super.getRidingEntity());
	}

	public Object superGetRidingEntity() {
		return super.getRidingEntity();
	}

	@Override
	public EnumPushReaction getPushReaction() {
		return (EnumPushReaction) (master != null ? master.getPushReaction() : super.getPushReaction());
	}

	public Object superGetPushReaction() {
		return super.getPushReaction();
	}

	@Override
	public SoundCategory getSoundCategory() {
		return (SoundCategory) (master != null ? master.getSoundCategory() : super.getSoundCategory());
	}

	public Object superGetSoundCategory() {
		return super.getSoundCategory();
	}
	// 188~
	public void superFunc_180433_a(double p_180433_1_, boolean p_180433_3_, Object block, Object blockPos) {
	}

	public void superFunc_145781_i(int p_145781_1_) {
	}

	public boolean superCanUseCommand(int permLevel, String commandName) {
		return false;
	}

	public Object superFunc_174819_aU() {
		return null;
	}

	public void superFunc_174834_g(Object nBTTagCompound) {
	}

	public boolean superFunc_174825_a(Object entityPlayer, Object vec3) {
		return false;
	}

	@Override
	public boolean superIsInRangeToRender3d(Object vec3) {
		return false;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox() {
		return (AxisAlignedBB) (master != null ? master.getCollisionBoundingBox() : super.getCollisionBoundingBox());
	}

	public AxisAlignedBB superGetCollisionBoundingBox() {
		return super.getCollisionBoundingBox();
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
	protected void updateFallState(double p_180433_1_, boolean p_180433_3_, IBlockState iBlockState, BlockPos blockPos) {
		if (master != null) master.updateFallState(p_180433_1_, p_180433_3_, iBlockState, blockPos);
		else super.updateFallState(p_180433_1_, p_180433_3_, iBlockState, blockPos);
	}

	@Override
	public void superUpdateFallState(double p_180433_1_, boolean p_180433_3_, Object iBlockState, Object blockPos) {
		super.updateFallState(p_180433_1_, p_180433_3_, (IBlockState) iBlockState, (BlockPos) blockPos);
	}

	@Override
	protected boolean canDropLoot() {
		return master != null ? master.canDropLoot() : super.canDropLoot();
	}

	public boolean superCanDropLoot() {
		return super.canDropLoot();
	}

	@Override
	protected void updatePotionMetadata() {
		if (master != null) master.updatePotionMetadata();
		else super.updatePotionMetadata();
	}

	public void superUpdatePotionMetadata() {
		super.updatePotionMetadata();
	}

	@Override
	protected void resetPotionEffectMetadata() {
		if (master != null) master.resetPotionEffectMetadata();
		else super.resetPotionEffectMetadata();
	}

	public void superResetPotionEffectMetadata() {
		super.resetPotionEffectMetadata();
	}

	@Override
	protected void dropLoot(boolean p_184610_1_, int p_184610_2_, DamageSource damageSource) {
		if (master != null) master.dropLoot(p_184610_1_, p_184610_2_, damageSource);
		else super.dropLoot(p_184610_1_, p_184610_2_, damageSource);
	}

	public void superDropLoot(boolean p_184610_1_, int p_184610_2_, Object damageSource) {
		super.dropLoot(p_184610_1_, p_184610_2_, (DamageSource) damageSource);
	}

	@Override
	protected float getJumpUpwardsMotion() {
		return master != null ? master.getJumpUpwardsMotion() : super.getJumpUpwardsMotion();
	}

	public float superGetJumpUpwardsMotion() {
		return super.getJumpUpwardsMotion();
	}

	@Override
	protected void handleJumpLava() {
		if (master != null) master.handleJumpLava();
		else super.handleJumpLava();
	}

	public void superHandleJumpLava() {
		super.handleJumpLava();
	}

	@Override
	public void setPositionAndRotation2(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean p_180426_10_) {
		if (master != null) master.setPositionAndRotation2(x, y, z, yaw, pitch, posRotationIncrements, p_180426_10_);
		else super.setPositionAndRotation2(x, y, z, yaw, pitch, posRotationIncrements, p_180426_10_);
	}

	public void superSetPositionAndRotation2(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean p_180426_10_) {
		super.setPositionAndRotation2(x, y, z, yaw, pitch, posRotationIncrements, p_180426_10_);
	}

	@Override
	public void setRenderYawOffset(float p_181013_1_) {
		if (master != null) master.setRenderYawOffset(p_181013_1_);
		else super.setRenderYawOffset(p_181013_1_);
	}

	public void superSetRenderYawOffset(float p_181013_1_) {
		super.setRenderYawOffset(p_181013_1_);
	}

	@Override
	public void sendEnterCombat() {
		if (master != null) master.sendEnterCombat();
		else super.sendEnterCombat();
	}

	public void superSendEnterCombat() {
		super.sendEnterCombat();
	}

	@Override
	public void sendEndCombat() {
		if (master != null) master.sendEndCombat();
		else super.sendEndCombat();
	}

	public void superSendEndCombat() {
		super.sendEndCombat();
	}

	@Override
	protected void markPotionsDirty() {
		if (master != null) master.markPotionsDirty();
		else super.markPotionsDirty();
	}

	public void superMarkPotionsDirty() {
		super.markPotionsDirty();
	}

	@Override
	public boolean verifyExplosion(Explosion explosion, World world, BlockPos blockPos, IBlockState iBlockState, float p_174816_5_) {
		return master != null ? master.verifyExplosion(explosion, world, blockPos, iBlockState, p_174816_5_) : super.verifyExplosion(explosion, world, blockPos, iBlockState, p_174816_5_);
	}

	public boolean superVerifyExplosion(Object explosion, Object world, Object blockPos, Object iBlockState, float p_174816_5_) {
		return super.verifyExplosion((Explosion) explosion, (World) world, (BlockPos) blockPos, (IBlockState) iBlockState, p_174816_5_);
	}

	@Override
	public EnumFacing getTeleportDirection() {
		return (EnumFacing) (master != null ? master.getLastPortalVec() : super.getTeleportDirection());
	}

	public EnumFacing superGetTeleportDirection() {
		return super.getTeleportDirection();
	}

	@Override
	protected HoverEvent getHoverEvent() {
		return (HoverEvent) (master != null ? master.getHoverEvent() : super.getHoverEvent());
	}

	public HoverEvent superGetHoverEvent() {
		return super.getHoverEvent();
	}

	@Override
	public boolean isSpectatedByPlayer(EntityPlayerMP entityPlayerMP) {
		return master != null ? master.isSpectatedByPlayer(entityPlayerMP) : super.isSpectatedByPlayer(entityPlayerMP);
	}

	public boolean superIsSpectatedByPlayer(Object entityPlayerMP) {
		return super.isSpectatedByPlayer((EntityPlayerMP) entityPlayerMP);
	}

	@Override
	public boolean canCommandSenderUseCommand(int permLevel, String commandName) {
		return master != null ? master.canCommandSenderUseCommand(permLevel, commandName) : super.canCommandSenderUseCommand(permLevel, commandName);
	}

	public boolean superCanCommandSenderUseCommand(int permLevel, String commandName) {
		return super.canCommandSenderUseCommand(permLevel, commandName);
	}

	@Override
	public CommandResultStats getCommandStats() {
		return (CommandResultStats) (master != null ? master.getCommandStats() : super.getCommandStats());
	}

	public CommandResultStats superGetCommandStats() {
		return super.getCommandStats();
	}

	@Override
	public boolean isImmuneToExplosions() {
		return master != null ? master.isImmuneToExplosions() : super.isImmuneToExplosions();
	}

	public boolean superIsImmuneToExplosions() {
		return super.isImmuneToExplosions();
	}

	@Override
	protected void applyEnchantments(EntityLivingBase entityLivingBase, Entity entity) {
		if (master != null) master.applyEnchantments(entityLivingBase, entity);
		else super.applyEnchantments(entityLivingBase, entity);
	}

	public void superApplyEnchantments(Object entityLivingBase, Object entity) {
		super.applyEnchantments((EntityLivingBase) entityLivingBase, (Entity) entity);
	}

	@Override
	public void setPortal(BlockPos bockPos) {
		if (master != null) master.setPortal(bockPos);
		else super.setPortal(bockPos);
	}

	public void superSetInPortal(Object bockPos) {
		super.setPortal((BlockPos) bockPos);
	}

	@Override
	public void handleStatusUpdate(byte par1) {
		if (master != null) master.handleStatusUpdate(par1);
		else super.handleStatusUpdate(par1);
	}

	public void superHandleStatusUpdate(byte par1) {
		super.handleStatusUpdate(par1);
	}
	// ~189
	public boolean isPotionActive(int par1) {
		return false;
	}

	@Override
	public boolean superIsPotionActive(int par1) {
		return false;
	}

	public void removePotionEffectClient(int par1) {
	}

	@Override
	public void superRemovePotionEffectClient(int par1) {
	}

	public void removePotionEffect(int par1) {
	}

	@Override
	public void superRemovePotionEffect(int par1) {
	}

	public ItemStack getHeldItem() {
		return (ItemStack) (master != null ? master.getHeldItemMainhand() : super.getHeldItemMainhand());
	}

	public ItemStack getEquipmentInSlot(int i) {
		return (ItemStack) (master != null ? master.getItemStackFromSlot(i) : null);
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

	protected String getFallSoundString(int damageValue) {
		return null;
	}

	public ItemStack[] getInventory() {
		return null;
	}

	public ItemStack[] superGetInventory() {
		return null;
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

	public boolean superProcessInitialInteract(Object entityPlayer) {
		return false;
	}

	public void superSetItemStackToSlot(int p_70062_1_, Object itemStack) {
	}

	public Object superGetArmorInventoryList() {
		return null;
	}

	public void superSetItemStackToSlot(Object entityEquipmentSlot, Object itemStack) {
	}

	public Object superGetItemStackFromSlot(int par1) {
		return null;
	}

	public void superAddRandomDrop() {
	}

	public void superSwingArm() {
	}

	public void superPlaySound(String par1Str, float par2, float par3) {
	}

	public void superUpdateRiderPosition() {
	}

	public Iterable<ItemStack> getArmorInventoryList() {
		return null;
	}

	public EnumHandSide getPrimaryHand() {
		return null;
	}

	@Override
	public void superDropLoot() {
	}

	@Override
	public int superGetMaxSafePointTries() {
		return 0;
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
	public void superUpdateFallState(double par1, boolean par3) {
	}

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
	public void superSetPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
	}

	@Override
	public void superHeal(int par1) {
		superHeal((float) par1);
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
	public void superDamageArmor(int par1) {
		superDamageArmor((float) par1);
	}

	@Override
	public Object superApplyArmorCalculations(Object damageSource, int par2) {
		return super.applyArmorCalculations((DamageSource) damageSource, (float) par2);
	}

	@Override
	public Object superApplyPotionDamageCalculations(Object damageSource, int par2) {
		return super.applyPotionDamageCalculations((DamageSource) damageSource, (float) par2);
	}

	@Override
	public void superDamageEntity(Object damageSource, int par2) {
		super.damageEntity((DamageSource) damageSource, (float) par2);
	}

	@Override
	public void superKnockBack(Object entity, int par2, double par3, double par5) {
		super.knockBack((Entity) entity, (float) par2, par3, par5);
	}

	@Override
	public void superDropRareDrop(int par1) {
	}

	@Override
	public void superFall(float par1) {
	}

	@Override
	public boolean superIsAIEnabled() {
		return true;
	}

	@Override
	public boolean superIsClientWorld() {
		return !super.isServerWorld();
	}

	@Override
	public boolean superIsBlocking() {
		return false;
	}

	@Override
	public void superUpdateAITasks() {
	}

	@Override
	public Object superGetPosition(float par1) {
		return null;
	}

	@Override
	public Object superGetItemIcon(Object itemStack, int par2) {
		return null;
	}

	@Override
	public void superOnChangedPotionEffect(Object potionEffect) {
	}

	@Override
	public float superGetSpeedModifier() {
		return 0;
	}

	@Override
	public Object[] superGetLastActiveItems() {
		return null;
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
	public void superSetNoAI(boolean par1) {
	}

	@Override
	public boolean superFunc_94062_bN() {
		return false;
	}

	@Override
	public void superFunc_96120_a(int par1, float par2) {
	}

	@Override
	public void superPlayStepSound(int par1, int par2, int par3, Object par4) {
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
	public float superGetShadowSize() {
		return 0;
	}

	@Override
	public boolean superInteract(Object entityPlayer) {
		return false;
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
	public boolean superIsEntityInvulnerable() {
		return false;
	}

	@Override
	public void superCopyDataFrom(Object entity, boolean par2) {
	}

	@Override
	public float superFunc_82146_a(Object explosion, Object world, int par3, int par4, int par5, Object block) {
		return 0;
	}

	@Override
	public boolean superFunc_96091_a(Object explosion, Object world, int par3, int par4, int par5, int par6, float par7) {
		return false;
	}

	@Override
	public String superGetTranslatedEntityName() {
		return null;
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
	public void superInit() {
	}

	@Override
	public void superSetMaxHealth(Object floatOrInt) {
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(Modchu_CastHelper.Double(floatOrInt, 0.0D, false));
	}

	@Override
	public void superUpdatePassenger() {
	}

	@Override
	public boolean superInteractFirst(Object entityPlayer) {
		return false;
	}

	@Override
	public void superSetCurrentItemOrArmor(int p_70062_1_, Object itemStack) {
	}

	@Override
	public Object superGetAmbientSound() {
		return null;
	}

	@Override
	public Object superGetCurrentItemOrArmor(int par1) {
		return null;
	}

	@Override
	public Object superGetCurrentArmor(int par1) {
		return null;
	}

}