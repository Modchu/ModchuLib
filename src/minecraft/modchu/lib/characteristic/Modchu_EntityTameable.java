package modchu.lib.characteristic;

import java.util.Collection;
import java.util.Random;
import java.util.UUID;

import modchu.lib.Modchu_Debug;
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
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.entity.ai.EntityJumpHelper;
import net.minecraft.entity.ai.EntityLookHelper;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.ai.EntitySenses;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
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
import net.minecraft.util.CombatTracker;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class Modchu_EntityTameable extends EntityTameable {

	public Modchu_EntityTameableBase masterEntity;
	public String entityName;
/*
	private HashMap<String, Field> allsyncMap = new HashMap();
	private HashMap<String, Field> masterEntityAllSyncMap = new HashMap();
	private HashMap<Integer, String> allSyncNameMap = new HashMap();
	private HashMap<Integer, String> masterEntityAllSyncNameMap = new HashMap();
*/
	public Modchu_EntityTameable(World world) {
		super(world);
		Modchu_Debug.mDebug("Modchu_EntityTameable init");
	}

	public Modchu_EntityTameable(Class masterClass, Object world) {
		super((World) world);
		if (masterClass != null) ;else {
			Modchu_Debug.Debug("Modchu_EntityTameable init error masterClass == null !!");
			return;
		}
		init(masterClass.getName());
	}

	public void setMovementSpeed(double d) {
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(d);
	}

	public void setMaxHealth(double d) {
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(d);
	}

	public Object getMaster() {
		//Modchu_Debug.mDebug("getmasterEntity masterEntity="+masterEntity);
		if (masterEntity != null) ;else {
			init(entityName);
		}
		return masterEntity;
	}

	public Object getFreeVariable(String s) {
		return masterEntity.getFreeVariable(s);
	}

	public void setFreeVariable(String s, Object o) {
		masterEntity.setFreeVariable(s, o);
	}

	private void init(String s) {
		if (s != null
				&& !s.isEmpty()) {
			masterEntity = (Modchu_EntityTameableBase) Modchu_Reflect.newInstance(s, new Class[]{ Modchu_EntityTameable.class, Object.class }, new Object[]{ this, worldObj });
			entityName = s;
		} else {
			Class c = Modchu_Main.getSpownEntityClass(worldObj, posX, posY, posZ);
			if (c != null) {
				masterEntity = (Modchu_EntityTameableBase) Modchu_Reflect.newInstance(c, new Class[]{ Modchu_EntityTameable.class, Object.class }, new Object[]{ this, worldObj });
			}
			entityName = c != null ? c.getName() : null;
		}
		Modchu_Debug.mDebug("initNBTAfter masterEntity="+masterEntity);
		Modchu_Debug.mDebug("initNBTAfter entityName="+(entityName != null ? entityName : "null !!"));
	}
/*
	private void allFieldSync(boolean reverse) {
		if (allsyncMap.isEmpty()) fieldAllSyncInit(false);
		if (masterEntityAllSyncNameMap.isEmpty()) fieldAllSyncInit(true);
		HashMap<String, Field> map = reverse ? masterEntityAllSyncMap : allsyncMap;
		HashMap<String, Field> map2 = reverse ? allsyncMap : masterEntityAllSyncMap;
		HashMap<Integer, String> nameMap = reverse ? masterEntityAllSyncNameMap : allSyncNameMap;
		HashMap<Integer, String> nameMap2 = reverse ? allSyncNameMap : masterEntityAllSyncNameMap;
		fieldSync(reverse, map, map2, nameMap, nameMap2);
	}

	private void fieldAllSyncInit(boolean reverse) {
		Field[] fields = reverse ? masterEntity.getClass().getFields() : getClass().getFields();
		Field[] mainFields = reverse ? getClass().getFields() : masterEntity.getClass().getFields() ;
		String fieldsName;
		String mainFieldsName;
		int mod;
		int mapCount = 0;
		Object o;
		for (int i = 0; i < fields.length; i++) {
			//Modchu_Debug.mDebug("fields["+i+"].getName()="+fields[i].getName()+" fields["+i+"].getType() = "+fields[i].getType());
			try {
				mod = fields[i].getModifiers();
				if (!Modifier.isFinal(mod)
						&& Modifier.isPrivate(mod)) {
					o = Modchu_Reflect.getPrivateValue(reverse ? masterEntity.getClass() : getClass(), reverse ? masterEntity : this, fields[i].getName());
				} else {
					o = fields[i].get(reverse ? masterEntity : this);
				}
				fieldsName = fields[i].getName();
				if (o != null) {
					for (int i1 = 0; i1 < mainFields.length; i1++) {
						mainFieldsName = mainFields[i1].getName();
						//if (fieldsName.equalsIgnoreCase("posX")) Modchu_Debug.mDebug("fieldsName = "+fieldsName+" mainFieldsName="+mainFieldsName);
						if (mainFieldsName.equalsIgnoreCase(fieldsName)) {
							//if (fieldsName.equalsIgnoreCase("posX")) Modchu_Debug.mDebug("isAccessible() = "+mainFields[i1].isAccessible());
							mod = mainFields[i1].getModifiers();
							if (!Modifier.isFinal(mod)) {
								Modchu_Debug.mDebug("put fieldsName="+fieldsName);
								if (reverse) {
									allSyncNameMap.put(mapCount, fieldsName);
									allsyncMap.put(fieldsName, fields[i]);
								} else {
									masterEntityAllSyncNameMap.put(mapCount, fieldsName);
									masterEntityAllSyncMap.put(fieldsName, fields[i]);
								}
								mapCount++;
								break;
							} else {
								//Modchu_Debug.mDebug("No put fieldsName="+fieldsName);
							}
						}
					}
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	private void fieldSync(boolean reverse, HashMap<String, Field> map, HashMap<String, Field> map2, HashMap<Integer, String> nameMap, HashMap<Integer, String> nameMap2) {
		String s;
		String s2;
		Field field;
		Field field2;
		Object o;
		int mod;
		for (int i = 0; i < nameMap.size(); i++) {
			s = nameMap.get(i);
			field = map.get(s);
			if (field != null) ;else {
				Modchu_Debug.mDebug("fieldSync 1 s="+s+" null!!");
				continue;
			}
			field2 = map2.get(s);
			if (field2 != null) ;else {
				Modchu_Debug.mDebug("fieldSync 2 s="+s+" null!!");
				continue;
			}
			mod = field.getModifiers();
			try {
				if (Modifier.isPrivate(mod)) {
					o = Modchu_Reflect.getPrivateValue(reverse ? masterEntity.getClass() : getClass(), reverse ? masterEntity : this, field.getName());
					Modchu_Reflect.setPrivateValue(reverse ? getClass() : masterEntity.getClass(), reverse ? this : masterEntity, field2.getName(), o);
				} else {
					o = field.get(reverse ? masterEntity : this);
					field2.set(reverse ? this : masterEntity, o);
				}
				//Modchu_Debug.mDebug("fieldSync s="+s);
				//if (s.equalsIgnoreCase("posX")) Modchu_Debug.mDebug("o = "+o);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
*/
	public boolean isAngry() {
		return masterEntity != null ? masterEntity.isAngry() : false;
	}

	public void setAngry(boolean flag) {
		if (masterEntity != null) masterEntity.setAngry(flag);
	}

	public int getTextureColor() {
		return masterEntity != null ? masterEntity.getTextureColor() : 0;
	}

	public void setTextureColor(int i) {
		if (masterEntity != null) masterEntity.setTextureColor(i);
	}

	public ResourceLocation getResourceLocation() {
		return masterEntity != null ? (ResourceLocation) masterEntity.getResourceLocation() : null;
	}

	public void setResourceLocation(ResourceLocation resourceLocation) {
		if (masterEntity != null) masterEntity.setResourceLocation(resourceLocation);
	}

	@Override
	protected void entityInit() {
		if (masterEntity != null) masterEntity.entityInit();
		else super.entityInit();
	}

	public void superEntityInit() {
		super.entityInit();
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
		if (entityName != null
				&& !entityName.isEmpty()) {
			nBTTagCompound.setString("entityName", entityName);
			if (masterEntity != null) masterEntity.writeEntityToNBT(nBTTagCompound);
			else super.writeEntityToNBT(nBTTagCompound);
		}
		//Modchu_Debug.mDebug("writeEntityToNBT entityName="+entityName);
	}

	public void superWriteEntityToNBT(Object nBTTagCompound) {
		super.writeEntityToNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
		//Modchu_Debug.mDebug("readEntityFromNBT entityName="+entityName);
		String s = nBTTagCompound.getString("entityName");
		//Modchu_Debug.mDebug("readEntityFromNBT s="+s);
		init(s);
		if (masterEntity != null) masterEntity.readEntityFromNBT(nBTTagCompound);
		else super.readEntityFromNBT(nBTTagCompound);
	}

	public void superReadEntityFromNBT(Object nBTTagCompound) {
		super.readEntityFromNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	protected void playTameEffect(boolean par1) {
		if (masterEntity != null) masterEntity.playTameEffect(par1);
		else super.playTameEffect(par1);
	}

	public void superPlayTameEffect(boolean par1) {
		super.playTameEffect(par1);
	}

	@Override
	public void handleHealthUpdate(byte par1) {
		if (masterEntity != null) masterEntity.handleHealthUpdate(par1);
		else super.handleHealthUpdate(par1);
	}

	public void superHandleHealthUpdate(byte par1) {
		super.handleHealthUpdate(par1);
	}

	@Override
	public boolean isTamed() {
		return masterEntity != null ? masterEntity.isTamed() : super.isTamed();
	}

	public boolean superIsTamed() {
		return super.isTamed();
	}

	@Override
	public void setTamed(boolean par1) {
		if (masterEntity != null) masterEntity.setTamed(par1);
		else super.setTamed(par1);
	}

	public void superSetTamed(boolean par1) {
		super.setTamed(par1);
	}

	@Override
	public boolean isSitting() {
		return masterEntity != null ? masterEntity.isSitting() : super.isSitting();
	}

	public boolean superIsSitting() {
		return super.isSitting();
	}

	@Override
	public void setSitting(boolean par1) {
		if (masterEntity != null) masterEntity.setSitting(par1);
		else super.setSitting(par1);
	}

	public void superSetSitting(boolean par1) {
		super.setSitting(par1);
	}

	@Override
	public String getOwnerName() {
		return masterEntity != null ? masterEntity.getOwnerName() : super.getOwnerName();
	}

	public String superGetOwnerName() {
		return super.getOwnerName();
	}

	@Override
	public void setOwner(String par1Str) {
		if (masterEntity != null) masterEntity.setOwner(par1Str);
		else super.setOwner(par1Str);
	}

	public void superSetOwner(String par1Str) {
		super.setOwner(par1Str);
	}

	@Override
	public EntityAISit func_70907_r() {
		return (EntityAISit) (masterEntity != null ? masterEntity.func_70907_r() : super.func_70907_r());
	}

	public EntityAISit superFunc_70907_r() {
		return super.func_70907_r();
	}

	@Override
	public boolean func_142018_a(EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase1) {
		return masterEntity != null ? masterEntity.func_142018_a(entityLivingBase, entityLivingBase1) : super.func_142018_a(entityLivingBase, entityLivingBase1);
	}

	public boolean superFunc_142018_a(Object entityLivingBase, Object entityLivingBase1) {
		return super.func_142018_a((EntityLivingBase) entityLivingBase, (EntityLivingBase) entityLivingBase1);
	}

	@Override
	public Team getTeam() {
		return (Team) (masterEntity != null ? masterEntity.getTeam() : super.getTeam());
	}

	public Team superGetTeam() {
		return super.getTeam();
	}

	@Override
	public boolean isOnSameTeam(EntityLivingBase entityLivingBase) {
		return masterEntity != null ? masterEntity.isOnSameTeam(entityLivingBase) : super.isOnSameTeam(entityLivingBase);
	}

	public boolean superIsOnSameTeam(Object entityLivingBase) {
		return super.isOnSameTeam((EntityLivingBase) entityLivingBase);
	}

	@Override
	protected void updateAITick() {
		if (masterEntity != null) masterEntity.updateAITick();
		else super.updateAITick();
	}

	public void superUpdateAITick() {
		super.updateAITick();
	}

	@Override
	public void onLivingUpdate() {
		//Modchu_Debug.mDebug("onLivingUpdate masterEntity="+masterEntity);
		//Modchu_Debug.mDebug("onLivingUpdate entityName="+entityName);
		//Modchu_Debug.mDebug("onLivingUpdate posX="+posX+" posY="+posY+" posZ="+posZ);
		if (masterEntity != null
				&& entityName != null) ;else {
			init(null);
			if (masterEntity != null) ;else {
				setDead();
			}
		}
		if (masterEntity != null) masterEntity.onLivingUpdate();
		else super.onLivingUpdate();
	}

	public void superOnLivingUpdate() {
		super.onLivingUpdate();
	}

	@Override
	protected void attackEntity(Entity entity, float par2) {
		if (masterEntity != null) masterEntity.attackEntity(entity, par2);
		else super.attackEntity(entity, par2);
	}

	public void superAttackEntity(Object entity, float par2) {
		super.attackEntity((Entity) entity, par2);
	}

	@Override
	public boolean attackEntityFrom(DamageSource damageSource, float par2) {
		return masterEntity != null ? masterEntity.attackEntityFrom(damageSource, par2) : super.attackEntityFrom(damageSource, par2);
	}

	public boolean superAttackEntityFrom(Object damageSource, float par2) {
		return super.attackEntityFrom((DamageSource) damageSource, par2);
	}

	@Override
	public float getBlockPathWeight(int par1, int par2, int par3) {
		return masterEntity != null ? masterEntity.getBlockPathWeight(par1, par2, par3) : super.getBlockPathWeight(par1, par2, par3);
	}

	public float superGetBlockPathWeight(int par1, int par2, int par3) {
		return super.getBlockPathWeight(par1, par2, par3);
	}

	@Override
	protected Entity findPlayerToAttack() {
		return (Entity) (masterEntity != null ? masterEntity.findPlayerToAttack() : super.findPlayerToAttack());
	}

	public Entity superFindPlayerToAttack() {
		return super.findPlayerToAttack();
	}

	@Override
	public boolean getCanSpawnHere() {
		return masterEntity != null ? masterEntity.getCanSpawnHere() : super.getCanSpawnHere();
	}

	public boolean superGetCanSpawnHere() {
		return super.getCanSpawnHere();
	}

	@Override
	public int getTalkInterval() {
		return masterEntity != null ? masterEntity.getTalkInterval() : super.getTalkInterval();
	}

	public int superGetTalkInterval() {
		return super.getTalkInterval();
	}

	@Override
	protected boolean canDespawn() {
		return masterEntity != null ? masterEntity.canDespawn() : super.canDespawn();
	}

	public boolean superCanDespawn() {
		return super.canDespawn();
	}

	@Override
	protected int getExperiencePoints(EntityPlayer entityPlayer) {
		return masterEntity != null ? masterEntity.getExperiencePoints(entityPlayer) : super.getExperiencePoints(entityPlayer);
	}

	public int superGetExperiencePoints(Object entityPlayer) {
		return super.getExperiencePoints((EntityPlayer) entityPlayer);
	}

	@Override
	public boolean isBreedingItem(ItemStack itemStack) {
		return masterEntity != null ? masterEntity.isBreedingItem(itemStack) : super.isBreedingItem(itemStack);
	}

	public boolean superIsBreedingItem(Object itemStack) {
		return super.isBreedingItem((ItemStack) itemStack);
	}

	@Override
	public boolean interact(EntityPlayer entityPlayer) {
		return masterEntity != null ? masterEntity.interact(entityPlayer) : super.interact(entityPlayer);
	}

	public boolean superInteract(Object entityPlayer) {
		return super.interact((EntityPlayer) entityPlayer);
	}

	@Override
	public boolean isInLove() {
		return masterEntity != null ? masterEntity.isInLove() : super.isInLove();
	}

	public boolean superIsInLove() {
		return super.isInLove();
	}

	@Override
	public void resetInLove() {
		if (masterEntity != null) masterEntity.resetInLove();
		else super.resetInLove();
	}

	public void superResetInLove() {
		super.resetInLove();
	}

	@Override
	public boolean canMateWith(EntityAnimal entityAnimal) {
		return masterEntity != null ? masterEntity.canMateWith(entityAnimal) : super.canMateWith(entityAnimal);
	}

	public boolean superCanMateWith(Object entityAnimal) {
		return super.canMateWith((EntityAnimal) entityAnimal);
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entityAgeable) {
		return (EntityAgeable) (masterEntity != null ? masterEntity.createChild(entityAgeable) : null);
	}

	@Override
	public int getGrowingAge() {
		return masterEntity != null ? masterEntity.getGrowingAge() : super.getGrowingAge();
	}

	public int superGetGrowingAge() {
		return super.getGrowingAge();
	}

	@Override
	public void addGrowth(int par1) {
		if (masterEntity != null) masterEntity.addGrowth(par1);
		else super.addGrowth(par1);
	}

	public void superAddGrowth(int par1) {
		super.addGrowth(par1);
	}

	@Override
	public void setGrowingAge(int par1) {
		if (masterEntity != null) masterEntity.setGrowingAge(par1);
		else super.setGrowingAge(par1);
	}

	public void superSetGrowingAge(int par1) {
		super.setGrowingAge(par1);
	}

	@Override
	public boolean isChild() {
		return masterEntity != null ? masterEntity.isChild() : super.isChild();
	}

	public boolean superIsChild() {
		return super.isChild();
	}

	@Override
	public void setScaleForAge(boolean par1) {
		if (masterEntity != null) masterEntity.setScaleForAge(par1);
		else super.setScaleForAge(par1);
	}

	public void superSetScaleForAge(boolean par1) {
		super.setScaleForAge(par1);
	}

	@Override
	protected boolean isMovementCeased() {
		return masterEntity != null ? masterEntity.isMovementCeased() : super.isMovementCeased();
	}

	public boolean superIsMovementCeased() {
		return super.isMovementCeased();
	}

	@Override
	protected void updateEntityActionState() {
		if (masterEntity != null) masterEntity.updateEntityActionState();
		else super.updateEntityActionState();
	}

	public void superUpdateEntityActionState() {
		super.updateEntityActionState();
	}

	@Override
	protected void updateWanderPath() {
		if (masterEntity != null) masterEntity.updateWanderPath();
		else super.updateWanderPath();
	}

	public void superUpdateWanderPath() {
		super.updateWanderPath();
	}

	@Override
	public boolean hasPath() {
		return masterEntity != null ? masterEntity.hasPath() : super.hasPath();
	}

	public boolean superHasPath() {
		return super.hasPath();
	}

	@Override
	public void setPathToEntity(PathEntity pathEntity) {
		if (masterEntity != null) masterEntity.setPathToEntity(pathEntity);
		else super.setPathToEntity(pathEntity);
	}

	public void superSetPathToEntity(Object pathEntity) {
		super.setPathToEntity((PathEntity) pathEntity);
	}

	@Override
	public Entity getEntityToAttack() {
		return (Entity) (masterEntity != null ? masterEntity.getEntityToAttack() : super.getEntityToAttack());
	}

	public Entity superGetEntityToAttack() {
		return super.getEntityToAttack();
	}

	@Override
	public void setTarget(Entity entity) {
		if (masterEntity != null) masterEntity.setTarget(entity);
		else super.setTarget(entity);
	}

	public void superSetTarget(Object entity) {
		super.setTarget((Entity) entity);
	}

	@Override
	public void setHomeArea(int par1, int par2, int par3, int par4) {
		if (masterEntity != null) masterEntity.setHomeArea(par1, par2, par3, par4);
		else super.setHomeArea(par1, par2, par3, par4);
	}

	public void superSetHomeArea(int par1, int par2, int par3, int par4) {
		super.setHomeArea(par1, par2, par3, par4);
	}

	@Override
	public ChunkCoordinates getHomePosition() {
		return (ChunkCoordinates) (masterEntity != null ? masterEntity.getHomePosition() : super.getHomePosition());
	}

	public ChunkCoordinates superGetHomePosition() {
		return super.getHomePosition();
	}

	@Override
	public float func_110174_bM() {
		return masterEntity != null ? masterEntity.func_110174_bM() : super.func_110174_bM();
	}

	public float superFunc_110174_bM() {
		return super.func_110174_bM();
	}

	@Override
	public void detachHome() {
		if (masterEntity != null) masterEntity.detachHome();
		else super.detachHome();
	}

	public void superDetachHome() {
		super.detachHome();
	}

	@Override
	public boolean hasHome() {
		return masterEntity != null ? masterEntity.hasHome() : super.hasHome();
	}

	public boolean superHasHome() {
		return super.hasHome();
	}

	@Override
	protected void func_142017_o(float par1) {
		if (masterEntity != null) masterEntity.func_142017_o(par1);
		else super.func_142017_o(par1);
	}

	public void superFunc_142017_o(float par1) {
		super.func_142017_o(par1);
	}

	@Override
	protected void applyEntityAttributes() {
		if (masterEntity != null) masterEntity.applyEntityAttributes();
		else super.applyEntityAttributes();
	}

	public void superApplyEntityAttributes() {
		super.applyEntityAttributes();
	}

	@Override
	public EntityLookHelper getLookHelper() {
		return (EntityLookHelper) (masterEntity != null ? masterEntity.getLookHelper() : super.getLookHelper());
	}

	public EntityLookHelper superGetLookHelper() {
		return super.getLookHelper();
	}

	@Override
	public EntityMoveHelper getMoveHelper() {
		return (EntityMoveHelper) (masterEntity != null ? masterEntity.getMoveHelper() : super.getMoveHelper());
	}

	public EntityMoveHelper superGetMoveHelper() {
		return super.getMoveHelper();
	}

	@Override
	public EntityJumpHelper getJumpHelper() {
		return (EntityJumpHelper) (masterEntity != null ? masterEntity.getJumpHelper() : super.getJumpHelper());
	}

	public EntityJumpHelper superGetJumpHelper() {
		return super.getJumpHelper();
	}

	@Override
	public PathNavigate getNavigator() {
		return (PathNavigate) (masterEntity != null ? masterEntity.getNavigator() : super.getNavigator());
	}

	public PathNavigate superGetNavigator() {
		return super.getNavigator();
	}

	@Override
	public EntitySenses getEntitySenses() {
		return (EntitySenses) (masterEntity != null ? masterEntity.getEntitySenses() : super.getEntitySenses());
	}

	public EntitySenses superGetEntitySenses() {
		return super.getEntitySenses();
	}

	@Override
	public EntityLivingBase getAttackTarget() {
		return (EntityLivingBase) (masterEntity != null ? masterEntity.getAttackTarget() : super.getAttackTarget());
	}

	public EntityLivingBase superGetAttackTarget() {
		return super.getAttackTarget();
	}

	@Override
	public void setAttackTarget(EntityLivingBase entityLivingBase) {
		if (masterEntity != null) masterEntity.setAttackTarget(entityLivingBase);
		else super.setAttackTarget(entityLivingBase);
	}

	public void superSetAttackTarget(Object entityLivingBase) {
		super.setAttackTarget((EntityLivingBase) entityLivingBase);
	}

	@Override
	public boolean canAttackClass(Class c) {
		return masterEntity != null ? masterEntity.canAttackClass(c) : super.canAttackClass(c);
	}

	public boolean superCanAttackClass(Object c) {
		return super.canAttackClass((Class) c);
	}

	@Override
	public void eatGrassBonus() {
		if (masterEntity != null) masterEntity.eatGrassBonus();
		else super.eatGrassBonus();
	}

	public void superEatGrassBonus() {
		super.eatGrassBonus();
	}

	@Override
	public void playLivingSound() {
		if (masterEntity != null) masterEntity.playLivingSound();
		else super.playLivingSound();
	}

	public void superPlayLivingSound() {
		super.playLivingSound();
	}

	@Override
	public void onEntityUpdate() {
		if (masterEntity != null) masterEntity.onEntityUpdate();
		else super.onEntityUpdate();
	}

	public void superOnEntityUpdate() {
		super.onEntityUpdate();
	}

	@Override
	public void spawnExplosionParticle() {
		if (masterEntity != null) masterEntity.spawnExplosionParticle();
		else super.spawnExplosionParticle();
	}

	public void superSpawnExplosionParticle() {
		super.spawnExplosionParticle();
	}

	@Override
	public void onUpdate() {
		if (masterEntity != null) masterEntity.onUpdate();
		else super.onUpdate();
	}

	public void superOnUpdate() {
		super.onUpdate();
	}

	@Override
	protected float func_110146_f(float par1, float par2) {
		return masterEntity != null ? masterEntity.func_110146_f(par1, par2) : super.func_110146_f(par1, par2);
	}

	public float superFunc_110146_f(float par1, float par2) {
		return super.func_110146_f(par1, par2);
	}

	@Override
	protected String getLivingSound() {
		return masterEntity != null ? masterEntity.getLivingSound() : super.getLivingSound();
	}

	public String superGetLivingSound() {
		return super.getLivingSound();
	}

	@Override
	protected void dropFewItems(boolean par1, int par2) {
		if (masterEntity != null) masterEntity.dropFewItems(par1, par2);
		else super.dropFewItems(par1, par2);
	}

	public void superDropFewItems(boolean par1, int par2) {
		super.dropFewItems(par1, par2);
	}

	@Override
	public void setMoveForward(float par1) {
		if (masterEntity != null) masterEntity.setMoveForward(par1);
		else super.setMoveForward(par1);
	}

	public void superSetMoveForward(float par1) {
		super.setMoveForward(par1);
	}

	@Override
	public void setAIMoveSpeed(float par1) {
		if (masterEntity != null) masterEntity.setAIMoveSpeed(par1);
		else super.setAIMoveSpeed(par1);
	}

	public void superSetAIMoveSpeed(float par1) {
		super.setAIMoveSpeed(par1);
	}

	@Override
	protected boolean isAIEnabled() {
		return masterEntity != null ? masterEntity.isAIEnabled() : super.isAIEnabled();
	}

	public boolean superIsAIEnabled() {
		return super.isAIEnabled();
	}

	@Override
	protected void despawnEntity() {
		if (masterEntity != null) masterEntity.despawnEntity();
		else super.despawnEntity();
	}

	public void superDespawnEntity() {
		super.despawnEntity();
	}

	@Override
	protected void updateAITasks() {
		if (masterEntity != null) masterEntity.updateAITasks();
		else super.updateAITasks();
	}

	public void superUpdateAITasks() {
		super.updateAITasks();
	}

	@Override
	public int getVerticalFaceSpeed() {
		return masterEntity != null ? masterEntity.getVerticalFaceSpeed() : super.getVerticalFaceSpeed();
	}

	public int superGetVerticalFaceSpeed() {
		return super.getVerticalFaceSpeed();
	}

	@Override
	public void faceEntity(Entity entity, float par2, float par3) {
		if (masterEntity != null) masterEntity.faceEntity(entity, par2, par3);
		else super.faceEntity(entity, par2, par3);
	}

	public void superFaceEntity(Object entity, float par2, float par3) {
		super.faceEntity((Entity) entity, par2, par3);
	}

	@Override
	public float getRenderSizeModifier() {
		return masterEntity != null ? masterEntity.getRenderSizeModifier() : super.getRenderSizeModifier();
	}

	public float superGetRenderSizeModifier() {
		return super.getRenderSizeModifier();
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return masterEntity != null ? masterEntity.getMaxSpawnedInChunk() : super.getMaxSpawnedInChunk();
	}

	public int superGetMaxSpawnedInChunk() {
		return super.getMaxSpawnedInChunk();
	}

	@Override
	public int getMaxSafePointTries() {
		return masterEntity != null ? masterEntity.getMaxSafePointTries() : super.getMaxSafePointTries();
	}

	public int superGetMaxSafePointTries() {
		return super.getMaxSafePointTries();
	}

	@Override
	public ItemStack getHeldItem() {
		return (ItemStack) (masterEntity != null ? masterEntity.getHeldItem() : super.getHeldItem());
	}

	public ItemStack superGetHeldItem() {
		return super.getHeldItem();
	}

	@Override
	public ItemStack func_130225_q(int par1) {
		return (ItemStack) (masterEntity != null ? masterEntity.func_130225_q(par1) : super.func_130225_q(par1));
	}

	public ItemStack superFunc_130225_q(int par1) {
		return super.func_130225_q(par1);
	}

	@Override
	public void setCurrentItemOrArmor(int par1, ItemStack itemStack) {
		if (masterEntity != null) masterEntity.setCurrentItemOrArmor(par1, itemStack);
		else super.setCurrentItemOrArmor(par1, itemStack);
	}

	public void superSetCurrentItemOrArmor(int par1, Object itemStack) {
		super.setCurrentItemOrArmor(par1, (ItemStack) itemStack);
	}

	@Override
	public ItemStack[] getLastActiveItems() {
		return (ItemStack[]) (masterEntity != null ? masterEntity.getLastActiveItems() : super.getLastActiveItems());
	}

	public ItemStack[] superGetLastActiveItems() {
		return super.getLastActiveItems();
	}

	@Override
	protected void dropEquipment(boolean par1, int par2) {
		if (masterEntity != null) masterEntity.dropEquipment(par1, par2);
		else super.dropEquipment(par1, par2);
	}

	public void superDropEquipment(boolean par1, int par2) {
		super.dropEquipment(par1, par2);
	}

	@Override
	protected void addRandomArmor() {
		if (masterEntity != null) masterEntity.addRandomArmor();
		else super.addRandomArmor();
	}

	public void superAddRandomArmor() {
		super.addRandomArmor();
	}

	@Override
	protected void enchantEquipment() {
		if (masterEntity != null) masterEntity.enchantEquipment();
		else super.enchantEquipment();
	}

	public void superEnchantEquipment() {
		super.enchantEquipment();
	}

	@Override
	public boolean canBeSteered() {
		return masterEntity != null ? masterEntity.canBeSteered() : super.canBeSteered();
	}

	public boolean superCanBeSteered() {
		return super.canBeSteered();
	}

	@Override
	public void func_110163_bv() {
		if (masterEntity != null) masterEntity.func_110163_bv();
		else super.func_110163_bv();
	}

	public void superFunc_110163_bv() {
		super.func_110163_bv();
	}

	@Override
	public void setCustomNameTag(String par1Str) {
		if (masterEntity != null) masterEntity.setCustomNameTag(par1Str);
		else super.setCustomNameTag(par1Str);
	}

	public void superSetCustomNameTag(String par1Str) {
		super.setCustomNameTag(par1Str);
	}

	@Override
	public String getCustomNameTag() {
		return masterEntity != null ? masterEntity.getCustomNameTag() : super.getCustomNameTag();
	}

	public String superGetCustomNameTag() {
		return super.getCustomNameTag();
	}

	@Override
	public boolean hasCustomNameTag() {
		return masterEntity != null ? masterEntity.hasCustomNameTag() : super.hasCustomNameTag();
	}

	public boolean superHasCustomNameTag() {
		return super.hasCustomNameTag();
	}

	@Override
	public void setAlwaysRenderNameTag(boolean par1) {
		if (masterEntity != null) masterEntity.setAlwaysRenderNameTag(par1);
		else super.setAlwaysRenderNameTag(par1);
	}

	public void superSetAlwaysRenderNameTag(boolean par1) {
		super.setAlwaysRenderNameTag(par1);
	}

	@Override
	public boolean getAlwaysRenderNameTag() {
		return masterEntity != null ? masterEntity.getAlwaysRenderNameTag() : super.getAlwaysRenderNameTag();
	}

	public boolean superGetAlwaysRenderNameTag() {
		return super.getAlwaysRenderNameTag();
	}

	@Override
	public boolean getAlwaysRenderNameTagForRender() {
		return masterEntity != null ? masterEntity.getAlwaysRenderNameTagForRender() : super.getAlwaysRenderNameTagForRender();
	}

	public boolean superGetAlwaysRenderNameTagForRender() {
		return super.getAlwaysRenderNameTagForRender();
	}

	@Override
	public void setEquipmentDropChance(int par1, float par2) {
		if (masterEntity != null) masterEntity.setEquipmentDropChance(par1, par2);
		else super.setEquipmentDropChance(par1, par2);
	}

	public void superSetEquipmentDropChance(int par1, float par2) {
		super.setEquipmentDropChance(par1, par2);
	}

	@Override
	public boolean canPickUpLoot() {
		return masterEntity != null ? masterEntity.canPickUpLoot() : super.canPickUpLoot();
	}

	public boolean superCanPickUpLoot() {
		return super.canPickUpLoot();
	}

	@Override
	public void setCanPickUpLoot(boolean par1) {
		if (masterEntity != null) masterEntity.setCanPickUpLoot(par1);
		else super.setCanPickUpLoot(par1);
	}

	public void superSetCanPickUpLoot(boolean par1) {
		super.setCanPickUpLoot(par1);
	}

	@Override
	public boolean isNoDespawnRequired() {
		return masterEntity != null ? masterEntity.isNoDespawnRequired() : super.isNoDespawnRequired();
	}

	public boolean superIsNoDespawnRequired() {
		return super.isNoDespawnRequired();
	}

	@Override
	public void clearLeashed(boolean par1, boolean par2) {
		if (masterEntity != null) masterEntity.clearLeashed(par1, par2);
		else super.clearLeashed(par1, par2);
	}

	public void superClearLeashed(boolean par1, boolean par2) {
		super.clearLeashed(par1, par2);
	}

	@Override
	public boolean allowLeashing() {
		return masterEntity != null ? masterEntity.allowLeashing() : super.allowLeashing();
	}

	public boolean superAllowLeashing() {
		return super.allowLeashing();
	}

	@Override
	public boolean getLeashed() {
		return masterEntity != null ? masterEntity.getLeashed() : super.getLeashed();
	}

	public boolean superGetLeashed() {
		return super.getLeashed();
	}

	@Override
	public Entity getLeashedToEntity() {
		return (Entity) (masterEntity != null ? masterEntity.getLeashedToEntity() : super.getLeashedToEntity());
	}

	public Entity superGetLeashedToEntity() {
		return super.getLeashedToEntity();
	}

	@Override
	public void setLeashedToEntity(Entity entity, boolean par2) {
		if (masterEntity != null) masterEntity.setLeashedToEntity(entity, par2);
		else super.setLeashedToEntity(entity, par2);
	}

	public void superSetLeashedToEntity(Object entity, boolean par2) {
		super.setLeashedToEntity((Entity) entity, par2);
	}

	@Override
	protected void updateFallState(double par1, boolean par3) {
		if (masterEntity != null) masterEntity.updateFallState(par1, par3);
		else super.updateFallState(par1, par3);
	}

	public void superUpdateFallState(double par1, boolean par3) {
		super.updateFallState(par1, par3);
	}

	@Override
	public boolean canBreatheUnderwater() {
		return masterEntity != null ? masterEntity.canBreatheUnderwater() : super.canBreatheUnderwater();
	}

	public boolean superCanBreatheUnderwater() {
		return super.canBreatheUnderwater();
	}

	@Override
	protected void onDeathUpdate() {
		if (masterEntity != null) masterEntity.onDeathUpdate();
		else super.onDeathUpdate();
	}

	public void superOnDeathUpdate() {
		super.onDeathUpdate();
	}

	@Override
	protected int decreaseAirSupply(int par1) {
		return masterEntity != null ? masterEntity.decreaseAirSupply(par1) : super.decreaseAirSupply(par1);
	}

	public int superDecreaseAirSupply(int par1) {
		return super.decreaseAirSupply(par1);
	}

	@Override
	protected boolean isPlayer() {
		return masterEntity != null ? masterEntity.isPlayer() : super.isPlayer();
	}

	public boolean superIsPlayer() {
		return super.isPlayer();
	}

	@Override
	public Random getRNG() {
		return (Random) (masterEntity != null ? masterEntity.getRNG() : super.getRNG());
	}

	public Random superGetRNG() {
		return super.getRNG();
	}

	@Override
	public EntityLivingBase getAITarget() {
		return (EntityLivingBase) (masterEntity != null ? masterEntity.getAITarget() : super.getAITarget());
	}

	public EntityLivingBase superGetAITarget() {
		return super.getAITarget();
	}

	@Override
	public int func_142015_aE() {
		return masterEntity != null ? masterEntity.func_142015_aE() : super.func_142015_aE();
	}

	public int superFunc_142015_aE() {
		return super.func_142015_aE();
	}

	@Override
	public void setRevengeTarget(EntityLivingBase entityLivingBase) {
		if (masterEntity != null) masterEntity.setRevengeTarget(entityLivingBase);
		else super.setRevengeTarget(entityLivingBase);
	}

	public void superSetRevengeTarget(Object entityLivingBase) {
		super.setRevengeTarget((EntityLivingBase) entityLivingBase);
	}

	@Override
	public EntityLivingBase getLastAttacker() {
		return (EntityLivingBase) (masterEntity != null ? masterEntity.getLastAttacker() : super.getLastAttacker());
	}

	public EntityLivingBase superGetLastAttacker() {
		return super.getLastAttacker();
	}

	@Override
	public int getLastAttackerTime() {
		return masterEntity != null ? masterEntity.getLastAttackerTime() : super.getLastAttackerTime();
	}

	public int superGetLastAttackerTime() {
		return super.getLastAttackerTime();
	}

	@Override
	public void setLastAttacker(Entity entity) {
		if (masterEntity != null) masterEntity.setLastAttacker(entity);
		else super.setLastAttacker(entity);
	}

	public void superSetLastAttacker(Object entity) {
		super.setLastAttacker((Entity) entity);
	}

	@Override
	public int getAge() {
		return masterEntity != null ? masterEntity.getAge() : super.getAge();
	}

	public int superGetAge() {
		return super.getAge();
	}

	@Override
	protected void updatePotionEffects() {
		if (masterEntity != null) masterEntity.updatePotionEffects();
		else super.updatePotionEffects();
	}

	public void superUpdatePotionEffects() {
		super.updatePotionEffects();
	}

	@Override
	public void clearActivePotions() {
		if (masterEntity != null) masterEntity.clearActivePotions();
		else super.clearActivePotions();
	}

	public void superClearActivePotions() {
		super.clearActivePotions();
	}

	@Override
	public Collection getActivePotionEffects() {
		return (Collection) (masterEntity != null ? masterEntity.getActivePotionEffects() : super.getActivePotionEffects());
	}

	public Collection superGetActivePotionEffects() {
		return super.getActivePotionEffects();
	}

	@Override
	public boolean isPotionActive(int par1) {
		return masterEntity != null ? masterEntity.isPotionActive(par1) : super.isPotionActive(par1);
	}

	public boolean superIsPotionActive(int par1) {
		return super.isPotionActive(par1);
	}

	@Override
	public boolean isPotionActive(Potion potion) {
		return masterEntity != null ? masterEntity.isPotionActive(potion) : super.isPotionActive(potion);
	}

	public boolean superIsPotionActive(Object potion) {
		return super.isPotionActive((Potion) potion);
	}

	@Override
	public PotionEffect getActivePotionEffect(Potion potion) {
		return (PotionEffect) (masterEntity != null ? masterEntity.getActivePotionEffect(potion) : super.getActivePotionEffect(potion));
	}

	public PotionEffect superGetActivePotionEffect(Object potion) {
		return super.getActivePotionEffect((Potion) potion);
	}

	@Override
	public void addPotionEffect(PotionEffect potionEffect) {
		if (masterEntity != null) masterEntity.addPotionEffect(potionEffect);
		else super.addPotionEffect(potionEffect);
	}

	public void superAddPotionEffect(Object potionEffect) {
		super.addPotionEffect((PotionEffect) potionEffect);
	}

	@Override
	public boolean isPotionApplicable(PotionEffect potionEffect) {
		return masterEntity != null ? masterEntity.isPotionApplicable(potionEffect) : super.isPotionApplicable(potionEffect);
	}

	public boolean superIsPotionApplicable(Object potionEffect) {
		return super.isPotionApplicable((PotionEffect) potionEffect);
	}

	@Override
	public boolean isEntityUndead() {
		return masterEntity != null ? masterEntity.isEntityUndead() : super.isEntityUndead();
	}

	public boolean superIsEntityUndead() {
		return super.isEntityUndead();
	}

	@Override
	public void removePotionEffectClient(int par1) {
		if (masterEntity != null) masterEntity.removePotionEffectClient(par1);
		else super.removePotionEffectClient(par1);
	}

	public void superRemovePotionEffectClient(int par1) {
		super.removePotionEffectClient(par1);
	}

	@Override
	public void removePotionEffect(int par1) {
		if (masterEntity != null) masterEntity.removePotionEffect(par1);
		else super.removePotionEffect(par1);
	}

	public void superRemovePotionEffect(int par1) {
		super.removePotionEffect(par1);
	}

	@Override
	protected void onNewPotionEffect(PotionEffect potionEffect) {
		if (masterEntity != null) masterEntity.onNewPotionEffect(potionEffect);
		else super.onNewPotionEffect(potionEffect);
	}

	public void superOnNewPotionEffect(Object potionEffect) {
		super.onNewPotionEffect((PotionEffect) potionEffect);
	}

	@Override
	protected void onChangedPotionEffect(PotionEffect potionEffect, boolean par2) {
		if (masterEntity != null) masterEntity.onChangedPotionEffect(potionEffect, par2);
		else super.onChangedPotionEffect(potionEffect, par2);
	}

	public void superOnChangedPotionEffect(Object potionEffect, boolean par2) {
		super.onChangedPotionEffect((PotionEffect) potionEffect, par2);
	}

	@Override
	protected void onFinishedPotionEffect(PotionEffect potionEffect) {
		if (masterEntity != null) masterEntity.onFinishedPotionEffect(potionEffect);
		else super.onFinishedPotionEffect(potionEffect);
	}

	public void superOnFinishedPotionEffect(Object potionEffect) {
		super.onFinishedPotionEffect((PotionEffect) potionEffect);
	}

	@Override
	public void heal(float par1) {
		if (masterEntity != null) masterEntity.heal(par1);
		else super.heal(par1);
	}

	public void superHeal(float par1) {
		super.heal(par1);
	}

	@Override
	public void setHealth(float par1) {
		if (masterEntity != null) masterEntity.setHealth(par1);
		else super.setHealth(par1);
	}

	public void superSetHealth(float par1) {
		super.setHealth(par1);
	}

	@Override
	public void renderBrokenItemStack(ItemStack itemStack) {
		if (masterEntity != null) masterEntity.renderBrokenItemStack(itemStack);
		else super.renderBrokenItemStack(itemStack);
	}

	public void superRenderBrokenItemStack(Object itemStack) {
		super.renderBrokenItemStack((ItemStack) itemStack);
	}

	@Override
	public void onDeath(DamageSource damageSource) {
		if (masterEntity != null) masterEntity.onDeath(damageSource);
		else super.onDeath(damageSource);
	}

	public void superOnDeath(Object damageSource) {
		super.onDeath((DamageSource) damageSource);
	}

	@Override
	public void knockBack(Entity entity, float par2, double par3, double par5) {
		if (masterEntity != null) masterEntity.knockBack(entity, par2, par3, par5);
		else super.knockBack(entity, par2, par3, par5);
	}

	public void superKnockBack(Object entity, float par2, double par3, double par5) {
		super.knockBack((Entity) entity, par2, par3, par5);
	}

	@Override
	protected String getHurtSound() {
		return masterEntity != null ? masterEntity.getHurtSound() : super.getHurtSound();
	}

	public String superGetHurtSound() {
		return super.getHurtSound();
	}

	@Override
	protected String getDeathSound() {
		return masterEntity != null ? masterEntity.getDeathSound() : super.getDeathSound();
	}

	public String superGetDeathSound() {
		return super.getDeathSound();
	}

	@Override
	protected void dropRareDrop(int par1) {
		if (masterEntity != null) masterEntity.dropRareDrop(par1);
		else super.dropRareDrop(par1);
	}

	public void superDropRareDrop(int par1) {
		super.dropRareDrop(par1);
	}

	@Override
	public boolean isOnLadder() {
		return masterEntity != null ? masterEntity.isOnLadder() : super.isOnLadder();
	}

	public boolean superIsOnLadder() {
		return super.isOnLadder();
	}

	@Override
	public boolean isEntityAlive() {
		return masterEntity != null ? masterEntity.isEntityAlive() : super.isEntityAlive();
	}

	public boolean superIsEntityAlive() {
		return super.isEntityAlive();
	}

	@Override
	protected void fall(float par1) {
		if (masterEntity != null) masterEntity.fall(par1);
		else super.fall(par1);
	}

	public void superFall(float par1) {
		super.fall(par1);
	}

	@Override
	public void performHurtAnimation() {
		if (masterEntity != null) masterEntity.performHurtAnimation();
		else super.performHurtAnimation();
	}

	public void superPerformHurtAnimation() {
		super.performHurtAnimation();
	}

	@Override
	public int getTotalArmorValue() {
		return masterEntity != null ? masterEntity.getTotalArmorValue() : super.getTotalArmorValue();
	}

	public int superGetTotalArmorValue() {
		return super.getTotalArmorValue();
	}

	@Override
	protected void damageArmor(float par1) {
		if (masterEntity != null) masterEntity.damageArmor(par1);
		else super.damageArmor(par1);
	}

	public void superDamageArmor(float par1) {
		super.damageArmor(par1);
	}

	@Override
	protected float applyArmorCalculations(DamageSource damageSource, float par2) {
		return masterEntity != null ? masterEntity.applyArmorCalculations(damageSource, par2) : super.applyArmorCalculations(damageSource, par2);
	}

	public float superApplyArmorCalculations(Object damageSource, float par2) {
		return super.applyArmorCalculations((DamageSource) damageSource, par2);
	}

	@Override
	protected float applyPotionDamageCalculations(DamageSource damageSource, float par2) {
		return masterEntity != null ? masterEntity.applyPotionDamageCalculations(damageSource, par2) : super.applyPotionDamageCalculations(damageSource, par2);
	}

	public float superApplyPotionDamageCalculations(Object damageSource, float par2) {
		return super.applyPotionDamageCalculations((DamageSource) damageSource, par2);
	}

	@Override
	protected void damageEntity(DamageSource damageSource, float par2) {
		if (masterEntity != null) masterEntity.damageEntity(damageSource, par2);
		else super.damageEntity(damageSource, par2);
	}

	public void superDamageEntity(Object damageSource, float par2) {
		super.damageEntity((DamageSource) damageSource, par2);
	}

	@Override
	public CombatTracker func_110142_aN() {
		return (CombatTracker) (masterEntity != null ? masterEntity.func_110142_aN() : super.func_110142_aN());
	}

	public CombatTracker superFunc_110142_aN() {
		return super.func_110142_aN();
	}

	@Override
	public EntityLivingBase func_94060_bK() {
		return (EntityLivingBase) (masterEntity != null ? masterEntity.func_94060_bK() : super.func_94060_bK());
	}

	public EntityLivingBase superFunc_94060_bK() {
		return super.func_94060_bK();
	}

	@Override
	public void swingItem() {
		if (masterEntity != null) masterEntity.swingItem();
		else super.swingItem();
	}

	public void superSwingItem() {
		super.swingItem();
	}

	@Override
	protected void kill() {
		if (masterEntity != null) masterEntity.kill();
		else super.kill();
	}

	public void superKill() {
		super.kill();
	}

	@Override
	protected void updateArmSwingProgress() {
		if (masterEntity != null) masterEntity.updateArmSwingProgress();
		else super.updateArmSwingProgress();
	}

	public void superUpdateArmSwingProgress() {
		super.updateArmSwingProgress();
	}

	@Override
	public BaseAttributeMap getAttributeMap() {
		return (BaseAttributeMap) (masterEntity != null ? masterEntity.getAttributeMap() : super.getAttributeMap());
	}

	public BaseAttributeMap superGetAttributeMap() {
		return super.getAttributeMap();
	}

	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return (EnumCreatureAttribute) (masterEntity != null ? masterEntity.getCreatureAttribute() : super.getCreatureAttribute());
	}

	public EnumCreatureAttribute superGetCreatureAttribute() {
		return super.getCreatureAttribute();
	}

	@Override
	public void setSprinting(boolean par1) {
		if (masterEntity != null) masterEntity.setSprinting(par1);
		else super.setSprinting(par1);
	}

	public void superSetSprinting(boolean par1) {
		super.setSprinting(par1);
	}

	@Override
	protected float getSoundVolume() {
		return masterEntity != null ? masterEntity.getSoundVolume() : super.getSoundVolume();
	}

	public float superGetSoundVolume() {
		return super.getSoundVolume();
	}

	@Override
	protected float getSoundPitch() {
		return masterEntity != null ? masterEntity.getSoundPitch() : super.getSoundPitch();
	}

	public float superGetSoundPitch() {
		return super.getSoundPitch();
	}

	@Override
	protected boolean isMovementBlocked() {
		return masterEntity != null ? masterEntity.isMovementBlocked() : super.isMovementBlocked();
	}

	public boolean superIsMovementBlocked() {
		return super.isMovementBlocked();
	}

	@Override
	public void setPositionAndUpdate(double par1, double par3, double par5) {
		if (masterEntity != null) masterEntity.setPositionAndUpdate(par1, par3, par5);
		else super.setPositionAndUpdate(par1, par3, par5);
	}

	public void superSetPositionAndUpdate(double par1, double par3, double par5) {
		super.setPositionAndUpdate(par1, par3, par5);
	}

	@Override
	public void dismountEntity(Entity entity) {
		if (masterEntity != null) masterEntity.dismountEntity(entity);
		else super.dismountEntity(entity);
	}

	public void superDismountEntity(Object entity) {
		super.dismountEntity((Entity) entity);
	}

	@Override
	protected void jump() {
		if (masterEntity != null) masterEntity.jump();
		else super.jump();
	}

	public void superJump() {
		super.jump();
	}

	@Override
	public void moveEntityWithHeading(float par1, float par2) {
		if (masterEntity != null) masterEntity.moveEntityWithHeading(par1, par2);
		else super.moveEntityWithHeading(par1, par2);
	}

	public void superMoveEntityWithHeading(float par1, float par2) {
		super.moveEntityWithHeading(par1, par2);
	}

	@Override
	public float getAIMoveSpeed() {
		return masterEntity != null ? masterEntity.getAIMoveSpeed() : super.getAIMoveSpeed();
	}

	public float superGetAIMoveSpeed() {
		return super.getAIMoveSpeed();
	}

	@Override
	public boolean attackEntityAsMob(Entity entity) {
		return masterEntity != null ? masterEntity.attackEntityAsMob(entity) : super.attackEntityAsMob(entity);
	}

	public boolean superAttackEntityAsMob(Object entity) {
		return super.attackEntityAsMob((Entity) entity);
	}

	@Override
	public boolean isPlayerSleeping() {
		return masterEntity != null ? masterEntity.isPlayerSleeping() : super.isPlayerSleeping();
	}

	public boolean superIsPlayerSleeping() {
		return super.isPlayerSleeping();
	}

	@Override
	protected void collideWithNearbyEntities() {
		if (masterEntity != null) masterEntity.collideWithNearbyEntities();
		else super.collideWithNearbyEntities();
	}

	public void superCollideWithNearbyEntities() {
		super.collideWithNearbyEntities();
	}

	@Override
	protected void collideWithEntity(Entity entity) {
		if (masterEntity != null) masterEntity.collideWithEntity(entity);
		else super.collideWithEntity(entity);
	}

	public void superCollideWithEntity(Object entity) {
		super.collideWithEntity((Entity) entity);
	}

	@Override
	public void updateRidden() {
		if (masterEntity != null) masterEntity.updateRidden();
		else super.updateRidden();
	}

	public void superUpdateRidden() {
		super.updateRidden();
	}

	@Override
	public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
		if (masterEntity != null) masterEntity.setPositionAndRotation2(par1, par3, par5, par7, par8, par9);
		else super.setPositionAndRotation2(par1, par3, par5, par7, par8, par9);
	}

	public void superSetPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
		super.setPositionAndRotation2(par1, par3, par5, par7, par8, par9);
	}

	@Override
	public void setJumping(boolean par1) {
		if (masterEntity != null) masterEntity.setJumping(par1);
		else super.setJumping(par1);
	}

	public void superSetJumping(boolean par1) {
		super.setJumping(par1);
	}

	@Override
	public void onItemPickup(Entity entity, int par2) {
		if (masterEntity != null) masterEntity.onItemPickup(entity, par2);
		else super.onItemPickup(entity, par2);
	}

	public void superOnItemPickup(Object entity, int par2) {
		super.onItemPickup((Entity) entity, par2);
	}

	@Override
	public boolean canEntityBeSeen(Entity entity) {
		return masterEntity != null ? masterEntity.canEntityBeSeen(entity) : super.canEntityBeSeen(entity);
	}

	public boolean superCanEntityBeSeen(Object entity) {
		return super.canEntityBeSeen((Entity) entity);
	}

	@Override
	public Vec3 getLookVec() {
		return (Vec3) (masterEntity != null ? masterEntity.getLookVec() : super.getLookVec());
	}

	public Vec3 superGetLookVec() {
		return super.getLookVec();
	}

	@Override
	public Vec3 getLook(float par1) {
		return (Vec3) (masterEntity != null ? masterEntity.getLook(par1) : super.getLook(par1));
	}

	public Vec3 superGetLook(float par1) {
		return super.getLook(par1);
	}

	@Override
	public float getSwingProgress(float par1) {
		return masterEntity != null ? masterEntity.getSwingProgress(par1) : super.getSwingProgress(par1);
	}

	public float superGetSwingProgress(float par1) {
		return super.getSwingProgress(par1);
	}

	@Override
	public Vec3 getPosition(float par1) {
		return (Vec3) (masterEntity != null ? masterEntity.getPosition(par1) : super.getPosition(par1));
	}

	public Vec3 superGetPosition(float par1) {
		return super.getPosition(par1);
	}

	@Override
	public MovingObjectPosition rayTrace(double par1, float par3) {
		return (MovingObjectPosition) (masterEntity != null ? masterEntity.rayTrace(par1, par3) : super.rayTrace(par1, par3));
	}

	public MovingObjectPosition superRayTrace(double par1, float par3) {
		return super.rayTrace(par1, par3);
	}

	@Override
	public boolean isClientWorld() {
		return masterEntity != null ? masterEntity.isClientWorld() : super.isClientWorld();
	}

	public boolean superIsClientWorld() {
		return super.isClientWorld();
	}

	@Override
	public boolean canBeCollidedWith() {
		return masterEntity != null ? masterEntity.canBeCollidedWith() : super.canBeCollidedWith();
	}

	public boolean superCanBeCollidedWith() {
		return super.canBeCollidedWith();
	}

	@Override
	public boolean canBePushed() {
		return masterEntity != null ? masterEntity.canBePushed() : super.canBePushed();
	}

	public boolean superCanBePushed() {
		return super.canBePushed();
	}

	@Override
	public float getEyeHeight() {
		return masterEntity != null ? masterEntity.getEyeHeight() : super.getEyeHeight();
	}

	public float superGetEyeHeight() {
		return super.getEyeHeight();
	}

	@Override
	protected void setBeenAttacked() {
		if (masterEntity != null) masterEntity.setBeenAttacked();
		else super.setBeenAttacked();
	}

	public void superSetBeenAttacked() {
		super.setBeenAttacked();
	}

	@Override
	public float getRotationYawHead() {
		return masterEntity != null ? masterEntity.getRotationYawHead() : super.getRotationYawHead();
	}

	public float superGetRotationYawHead() {
		return super.getRotationYawHead();
	}

	@Override
	public void setRotationYawHead(float par1) {
		if (masterEntity != null) masterEntity.setRotationYawHead(par1);
		else super.setRotationYawHead(par1);
	}

	public void superSetRotationYawHead(float par1) {
		super.setRotationYawHead(par1);
	}

	@Override
	public float getAbsorptionAmount() {
		return masterEntity != null ? masterEntity.getAbsorptionAmount() : super.getAbsorptionAmount();
	}

	public float superGetAbsorptionAmount() {
		return super.getAbsorptionAmount();
	}

	@Override
	public void setAbsorptionAmount(float par1) {
		if (masterEntity != null) masterEntity.setAbsorptionAmount(par1);
		else super.setAbsorptionAmount(par1);
	}

	public void superSetAbsorptionAmount(float par1) {
		super.setAbsorptionAmount(par1);
	}

	@Override
	public boolean isOnTeam(Team team) {
		return masterEntity != null ? masterEntity.isOnTeam(team) : super.isOnTeam(team);
	}

	public boolean superIsOnTeam(Object team) {
		return super.isOnTeam((Team) team);
	}

	@Override
	public void curePotionEffects(ItemStack itemStack) {
		if (masterEntity != null) masterEntity.curePotionEffects(itemStack);
		else super.curePotionEffects(itemStack);
	}

	public void superCurePotionEffects(Object itemStack) {
		super.curePotionEffects((ItemStack) itemStack);
	}

	@Override
	public boolean shouldRiderFaceForward(EntityPlayer entityPlayer) {
		return masterEntity != null ? masterEntity.shouldRiderFaceForward(entityPlayer) : super.shouldRiderFaceForward(entityPlayer);
	}

	public boolean superShouldRiderFaceForward(Object entityPlayer) {
		return super.shouldRiderFaceForward((EntityPlayer) entityPlayer);
	}

	@Override
	public DataWatcher getDataWatcher() {
		return (DataWatcher) (masterEntity != null ? masterEntity.getDataWatcher() : super.getDataWatcher());
	}

	public DataWatcher superGetDataWatcher() {
		return super.getDataWatcher();
	}

	@Override
	public boolean equals(Object par1Obj) {
		return masterEntity != null ? masterEntity.equals(par1Obj) : super.equals(par1Obj);
	}

	public boolean superEquals(Object par1Obj) {
		return super.equals(par1Obj);
	}

	@Override
	public int hashCode() {
		return masterEntity != null ? masterEntity.hashCode() : super.hashCode();
	}

	public int superHashCode() {
		return super.hashCode();
	}

	@Override
	protected void preparePlayerToSpawn() {
		if (masterEntity != null) masterEntity.preparePlayerToSpawn();
		else super.preparePlayerToSpawn();
	}

	public void superPreparePlayerToSpawn() {
		super.preparePlayerToSpawn();
	}

	@Override
	public void setDead() {
		if (masterEntity != null) masterEntity.setDead();
		else super.setDead();
	}

	public void superSetDead() {
		super.setDead();
	}

	@Override
	protected void setRotation(float par1, float par2) {
		if (masterEntity != null) masterEntity.setRotation(par1, par2);
		else super.setRotation(par1, par2);
	}

	public void superSetRotation(float par1, float par2) {
		super.setRotation(par1, par2);
	}

	@Override
	public void setPosition(double par1, double par3, double par5) {
		if (masterEntity != null) masterEntity.setPosition(par1, par3, par5);
		else super.setPosition(par1, par3, par5);
	}

	public void superSetPosition(double par1, double par3, double par5) {
		super.setPosition(par1, par3, par5);
	}

	@Override
	public void setAngles(float par1, float par2) {
		if (masterEntity != null) masterEntity.setAngles(par1, par2);
		else super.setAngles(par1, par2);
	}

	public void superSetAngles(float par1, float par2) {
		super.setAngles(par1, par2);
	}

	@Override
	public int getMaxInPortalTime() {
		return masterEntity != null ? masterEntity.getMaxInPortalTime() : super.getMaxInPortalTime();
	}

	public int superGetMaxInPortalTime() {
		return super.getMaxInPortalTime();
	}

	@Override
	protected void setOnFireFromLava() {
		if (masterEntity != null) masterEntity.setOnFireFromLava();
		else super.setOnFireFromLava();
	}

	public void superSetOnFireFromLava() {
		super.setOnFireFromLava();
	}

	@Override
	public void setFire(int par1) {
		if (masterEntity != null) masterEntity.setFire(par1);
		else super.setFire(par1);
	}

	public void superSetFire(int par1) {
		super.setFire(par1);
	}

	@Override
	public void extinguish() {
		if (masterEntity != null) masterEntity.extinguish();
		else super.extinguish();
	}

	public void superExtinguish() {
		super.extinguish();
	}

	@Override
	public boolean isOffsetPositionInLiquid(double par1, double par3, double par5) {
		return masterEntity != null ? masterEntity.isOffsetPositionInLiquid(par1, par3, par5) : super.isOffsetPositionInLiquid(par1, par3, par5);
	}

	public boolean superIsOffsetPositionInLiquid(double par1, double par3, double par5) {
		return super.isOffsetPositionInLiquid(par1, par3, par5);
	}

	@Override
	public void moveEntity(double par1, double par3, double par5) {
		if (masterEntity != null) masterEntity.moveEntity(par1, par3, par5);
		else super.moveEntity(par1, par3, par5);
	}

	public void superMoveEntity(double par1, double par3, double par5) {
		super.moveEntity(par1, par3, par5);
	}

	@Override
	public void playSound(String par1Str, float par2, float par3) {
		if (masterEntity != null) masterEntity.playSound(par1Str, par2, par3);
		else super.playSound(par1Str, par2, par3);
	}

	public void superPlaySound(String par1Str, float par2, float par3) {
		super.playSound(par1Str, par2, par3);
	}

	@Override
	protected boolean canTriggerWalking() {
		return masterEntity != null ? masterEntity.canTriggerWalking() : super.canTriggerWalking();
	}

	public boolean superCanTriggerWalking() {
		return super.canTriggerWalking();
	}

	@Override
	public AxisAlignedBB getBoundingBox() {
		return (AxisAlignedBB) (masterEntity != null ? masterEntity.getBoundingBox() : super.getBoundingBox());
	}

	public AxisAlignedBB superGetBoundingBox() {
		return super.getBoundingBox();
	}

	@Override
	protected void dealFireDamage(int par1) {
		if (masterEntity != null) masterEntity.dealFireDamage(par1);
		else super.dealFireDamage(par1);
	}

	public void superDealFireDamage(int par1) {
		super.dealFireDamage(par1);
	}

	@Override
	public boolean isWet() {
		return masterEntity != null ? masterEntity.isWet() : super.isWet();
	}

	public boolean superIsWet() {
		return super.isWet();
	}

	@Override
	public boolean isInWater() {
		return masterEntity != null ? masterEntity.isInWater() : super.isInWater();
	}

	public boolean superIsInWater() {
		return super.isInWater();
	}

	@Override
	public boolean handleWaterMovement() {
		return masterEntity != null ? masterEntity.handleWaterMovement() : super.handleWaterMovement();
	}

	public boolean superHandleWaterMovement() {
		return super.handleWaterMovement();
	}

	@Override
	public boolean isInsideOfMaterial(Material material) {
		return masterEntity != null ? masterEntity.isInsideOfMaterial(material) : super.isInsideOfMaterial(material);
	}

	public boolean superIsInsideOfMaterial(Object material) {
		return super.isInsideOfMaterial((Material) material);
	}

	@Override
	public boolean handleLavaMovement() {
		return masterEntity != null ? masterEntity.handleLavaMovement() : super.handleLavaMovement();
	}

	public boolean superHandleLavaMovement() {
		return super.handleLavaMovement();
	}

	@Override
	public void moveFlying(float par1, float par2, float par3) {
		if (masterEntity != null) masterEntity.moveFlying(par1, par2, par3);
		else super.moveFlying(par1, par2, par3);
	}

	public void superMoveFlying(float par1, float par2, float par3) {
		super.moveFlying(par1, par2, par3);
	}

	@Override
	public int getBrightnessForRender(float par1) {
		return masterEntity != null ? masterEntity.getBrightnessForRender(par1) : super.getBrightnessForRender(par1);
	}

	public int superGetBrightnessForRender(float par1) {
		return super.getBrightnessForRender(par1);
	}

	@Override
	public float getBrightness(float par1) {
		return masterEntity != null ? masterEntity.getBrightness(par1) : super.getBrightness(par1);
	}

	public float superGetBrightness(float par1) {
		return super.getBrightness(par1);
	}

	@Override
	public void setWorld(World world) {
		if (masterEntity != null) masterEntity.setWorld(world);
		else super.setWorld(world);
	}

	public void superSetWorld(Object world) {
		super.setWorld((World) world);
	}

	@Override
	public void setPositionAndRotation(double par1, double par3, double par5, float par7, float par8) {
		if (masterEntity != null) masterEntity.setPositionAndRotation(par1, par3, par5, par7, par8);
		else super.setPositionAndRotation(par1, par3, par5, par7, par8);
	}

	public void superSetPositionAndRotation(double par1, double par3, double par5, float par7, float par8) {
		super.setPositionAndRotation(par1, par3, par5, par7, par8);
	}

	@Override
	public void setLocationAndAngles(double par1, double par3, double par5, float par7, float par8) {
		if (masterEntity != null) masterEntity.setLocationAndAngles(par1, par3, par5, par7, par8);
		else super.setLocationAndAngles(par1, par3, par5, par7, par8);
	}

	public void superSetLocationAndAngles(double par1, double par3, double par5, float par7, float par8) {
		super.setLocationAndAngles(par1, par3, par5, par7, par8);
	}

	@Override
	public float getDistanceToEntity(Entity entity) {
		return masterEntity != null ? masterEntity.getDistanceToEntity(entity) : super.getDistanceToEntity(entity);
	}

	public float superGetDistanceToEntity(Object entity) {
		return super.getDistanceToEntity((Entity) entity);
	}

	@Override
	public double getDistanceSq(double par1, double par3, double par5) {
		return masterEntity != null ? masterEntity.getDistanceSq(par1, par3, par5) : super.getDistanceSq(par1, par3, par5);
	}

	public double superGetDistanceSq(double par1, double par3, double par5) {
		return super.getDistanceSq(par1, par3, par5);
	}

	@Override
	public double getDistance(double par1, double par3, double par5) {
		return masterEntity != null ? masterEntity.getDistance(par1, par3, par5) : super.getDistance(par1, par3, par5);
	}

	public double superGetDistance(double par1, double par3, double par5) {
		return super.getDistance(par1, par3, par5);
	}

	@Override
	public double getDistanceSqToEntity(Entity entity) {
		return masterEntity != null ? masterEntity.getDistanceSqToEntity(entity) : super.getDistanceSqToEntity(entity);
	}

	public double superGetDistanceSqToEntity(Object entity) {
		return super.getDistanceSqToEntity((Entity) entity);
	}

	@Override
	public void onCollideWithPlayer(EntityPlayer entityPlayer) {
		if (masterEntity != null) masterEntity.onCollideWithPlayer(entityPlayer);
		else super.onCollideWithPlayer(entityPlayer);
	}

	public void superOnCollideWithPlayer(Object entityPlayer) {
		super.onCollideWithPlayer((EntityPlayer) entityPlayer);
	}

	@Override
	public void applyEntityCollision(Entity entity) {
		if (masterEntity != null) masterEntity.applyEntityCollision(entity);
		else super.applyEntityCollision(entity);
	}

	public void superApplyEntityCollision(Object entity) {
		super.applyEntityCollision((Entity) entity);
	}

	@Override
	public void addVelocity(double par1, double par3, double par5) {
		if (masterEntity != null) masterEntity.addVelocity(par1, par3, par5);
		else super.addVelocity(par1, par3, par5);
	}

	public void superAddVelocity(double par1, double par3, double par5) {
		super.addVelocity(par1, par3, par5);
	}

	@Override
	public void addToPlayerScore(Entity entity, int par2) {
		if (masterEntity != null) masterEntity.addToPlayerScore(entity, par2);
		else super.addToPlayerScore(entity, par2);
	}

	public void superAddToPlayerScore(Object entity, int par2) {
		super.addToPlayerScore((Entity) entity, par2);
	}

	@Override
	public boolean isInRangeToRenderDist(double par1) {
		return masterEntity != null ? masterEntity.isInRangeToRenderDist(par1) : super.isInRangeToRenderDist(par1);
	}

	public boolean superIsInRangeToRenderDist(double par1) {
		return super.isInRangeToRenderDist(par1);
	}

	@Override
	public boolean writeMountToNBT(NBTTagCompound nBTTagCompound) {
		return masterEntity != null ? masterEntity.writeMountToNBT(nBTTagCompound) : super.writeMountToNBT(nBTTagCompound);
	}

	public boolean superWriteMountToNBT(Object nBTTagCompound) {
		return super.writeMountToNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public boolean writeToNBTOptional(NBTTagCompound nBTTagCompound) {
		return masterEntity != null ? masterEntity.writeToNBTOptional(nBTTagCompound) : super.writeToNBTOptional(nBTTagCompound);
	}

	public boolean superWriteToNBTOptional(Object nBTTagCompound) {
		return super.writeToNBTOptional((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public void writeToNBT(NBTTagCompound nBTTagCompound) {
		if (masterEntity != null) masterEntity.writeToNBT(nBTTagCompound);
		else super.writeToNBT(nBTTagCompound);
	}

	public void superWriteToNBT(Object nBTTagCompound) {
		super.writeToNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public void readFromNBT(NBTTagCompound nBTTagCompound) {
		if (masterEntity != null) masterEntity.readFromNBT(nBTTagCompound);
		else super.readFromNBT(nBTTagCompound);
	}

	public void superReadFromNBT(Object nBTTagCompound) {
		super.readFromNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	protected boolean shouldSetPosAfterLoading() {
		return masterEntity != null ? masterEntity.shouldSetPosAfterLoading() : super.shouldSetPosAfterLoading();
	}

	public boolean superShouldSetPosAfterLoading() {
		return super.shouldSetPosAfterLoading();
	}

	@Override
	public void onChunkLoad() {
		if (masterEntity != null) masterEntity.onChunkLoad();
		else super.onChunkLoad();
	}

	public void superOnChunkLoad() {
		super.onChunkLoad();
	}

	@Override
	protected NBTTagList newDoubleNBTList(double... par1ArrayOfDouble) {
		return (NBTTagList) (masterEntity != null ? masterEntity.newDoubleNBTList(par1ArrayOfDouble) : super.newDoubleNBTList(par1ArrayOfDouble));
	}

	public NBTTagList superNewDoubleNBTList(double... par1ArrayOfDouble) {
		return super.newDoubleNBTList(par1ArrayOfDouble);
	}

	@Override
	protected NBTTagList newFloatNBTList(float... par1ArrayOfFloat) {
		return (NBTTagList) (masterEntity != null ? masterEntity.newFloatNBTList(par1ArrayOfFloat) : super.newFloatNBTList(par1ArrayOfFloat));
	}

	public NBTTagList superNewFloatNBTList(float... par1ArrayOfFloat) {
		return super.newFloatNBTList(par1ArrayOfFloat);
	}

	@Override
	public EntityItem entityDropItem(ItemStack itemStack, float par2) {
		return (EntityItem) (masterEntity != null ? masterEntity.entityDropItem(itemStack, par2) : super.entityDropItem(itemStack, par2));
	}

	public EntityItem superEntityDropItem(Object itemStack, float par2) {
		return super.entityDropItem((ItemStack) itemStack, par2);
	}

	@Override
	public float getShadowSize() {
		return masterEntity != null ? masterEntity.getShadowSize() : super.getShadowSize();
	}

	public float superGetShadowSize() {
		return super.getShadowSize();
	}

	@Override
	public boolean isEntityInsideOpaqueBlock() {
		return masterEntity != null ? masterEntity.isEntityInsideOpaqueBlock() : super.isEntityInsideOpaqueBlock();
	}

	public boolean superIsEntityInsideOpaqueBlock() {
		return super.isEntityInsideOpaqueBlock();
	}

	@Override
	public AxisAlignedBB getCollisionBox(Entity entity) {
		return (AxisAlignedBB) (masterEntity != null ? masterEntity.getCollisionBox(entity) : super.getCollisionBox(entity));
	}

	public AxisAlignedBB superGetCollisionBox(Object entity) {
		return super.getCollisionBox((Entity) entity);
	}

	@Override
	public void updateRiderPosition() {
		if (masterEntity != null) masterEntity.updateRiderPosition();
		else super.updateRiderPosition();
	}

	public void superUpdateRiderPosition() {
		super.updateRiderPosition();
	}

	@Override
	public double getYOffset() {
		return masterEntity != null ? masterEntity.getYOffset() : super.getYOffset();
	}

	public double superGetYOffset() {
		return super.getYOffset();
	}

	@Override
	public double getMountedYOffset() {
		return masterEntity != null ? masterEntity.getMountedYOffset() : super.getMountedYOffset();
	}

	public double superGetMountedYOffset() {
		return super.getMountedYOffset();
	}

	@Override
	public void mountEntity(Entity entity) {
		if (masterEntity != null) masterEntity.mountEntity(entity);
		else super.mountEntity(entity);
	}

	public void superMountEntity(Object entity) {
		super.mountEntity((Entity) entity);
	}

	@Override
	public float getCollisionBorderSize() {
		return masterEntity != null ? masterEntity.getCollisionBorderSize() : super.getCollisionBorderSize();
	}

	public float superGetCollisionBorderSize() {
		return super.getCollisionBorderSize();
	}

	@Override
	public void setInPortal() {
		if (masterEntity != null) masterEntity.setInPortal();
		else super.setInPortal();
	}

	public void superSetInPortal() {
		super.setInPortal();
	}

	@Override
	public int getPortalCooldown() {
		return masterEntity != null ? masterEntity.getPortalCooldown() : super.getPortalCooldown();
	}

	public int superGetPortalCooldown() {
		return super.getPortalCooldown();
	}

	@Override
	public void setVelocity(double par1, double par3, double par5) {
		if (masterEntity != null) masterEntity.setVelocity(par1, par3, par5);
		else super.setVelocity(par1, par3, par5);
	}

	public void superSetVelocity(double par1, double par3, double par5) {
		super.setVelocity(par1, par3, par5);
	}

	@Override
	public boolean isBurning() {
		return masterEntity != null ? masterEntity.isBurning() : super.isBurning();
	}

	public boolean superIsBurning() {
		return super.isBurning();
	}

	@Override
	public boolean isRiding() {
		return masterEntity != null ? masterEntity.isRiding() : super.isRiding();
	}

	public boolean superIsRiding() {
		return super.isRiding();
	}

	@Override
	public boolean isSneaking() {
		return masterEntity != null ? masterEntity.isSneaking() : super.isSneaking();
	}

	public boolean superIsSneaking() {
		return super.isSneaking();
	}

	@Override
	public void setSneaking(boolean par1) {
		if (masterEntity != null) masterEntity.setSneaking(par1);
		else super.setSneaking(par1);
	}

	public void superSetSneaking(boolean par1) {
		super.setSneaking(par1);
	}

	@Override
	public boolean isSprinting() {
		return masterEntity != null ? masterEntity.isSprinting() : super.isSprinting();
	}

	public boolean superIsSprinting() {
		return super.isSprinting();
	}

	@Override
	public boolean isInvisible() {
		return masterEntity != null ? masterEntity.isInvisible() : super.isInvisible();
	}

	public boolean superIsInvisible() {
		return super.isInvisible();
	}

	@Override
	public boolean isInvisibleToPlayer(EntityPlayer entityPlayer) {
		return masterEntity != null ? masterEntity.isInvisibleToPlayer(entityPlayer) : super.isInvisibleToPlayer(entityPlayer);
	}

	public boolean superIsInvisibleToPlayer(Object entityPlayer) {
		return super.isInvisibleToPlayer((EntityPlayer) entityPlayer);
	}

	@Override
	public void setInvisible(boolean par1) {
		if (masterEntity != null) masterEntity.setInvisible(par1);
		else super.setInvisible(par1);
	}

	public void superSetInvisible(boolean par1) {
		super.setInvisible(par1);
	}

	@Override
	public boolean isEating() {
		return masterEntity != null ? masterEntity.isEating() : super.isEating();
	}

	public boolean superIsEating() {
		return super.isEating();
	}

	@Override
	public void setEating(boolean par1) {
		if (masterEntity != null) masterEntity.setEating(par1);
		else super.setEating(par1);
	}

	public void superSetEating(boolean par1) {
		super.setEating(par1);
	}

	@Override
	protected boolean getFlag(int par1) {
		return masterEntity != null ? masterEntity.getFlag(par1) : super.getFlag(par1);
	}

	public boolean superGetFlag(int par1) {
		return super.getFlag(par1);
	}

	@Override
	protected void setFlag(int par1, boolean par2) {
		if (masterEntity != null) masterEntity.setFlag(par1, par2);
		else super.setFlag(par1, par2);
	}

	public void superSetFlag(int par1, boolean par2) {
		super.setFlag(par1, par2);
	}

	@Override
	public int getAir() {
		return masterEntity != null ? masterEntity.getAir() : super.getAir();
	}

	public int superGetAir() {
		return super.getAir();
	}

	@Override
	public void setAir(int par1) {
		if (masterEntity != null) masterEntity.setAir(par1);
		else super.setAir(par1);
	}

	public void superSetAir(int par1) {
		super.setAir(par1);
	}

	@Override
	public void onStruckByLightning(EntityLightningBolt entityLightningBolt) {
		if (masterEntity != null) masterEntity.onStruckByLightning(entityLightningBolt);
		else super.onStruckByLightning(entityLightningBolt);
	}

	public void superOnStruckByLightning(Object entityLightningBolt) {
		super.onStruckByLightning((EntityLightningBolt) entityLightningBolt);
	}

	@Override
	public void onKillEntity(EntityLivingBase entityLivingBase) {
		if (masterEntity != null) masterEntity.onKillEntity(entityLivingBase);
		else super.onKillEntity(entityLivingBase);
	}

	public void superOnKillEntity(Object entityLivingBase) {
		super.onKillEntity((EntityLivingBase) entityLivingBase);
	}

	@Override
	public void setInWeb() {
		if (masterEntity != null) masterEntity.setInWeb();
		else super.setInWeb();
	}

	public void superSetInWeb() {
		super.setInWeb();
	}

	@Override
	public Entity[] getParts() {
		return (Entity[]) (masterEntity != null ? masterEntity.getParts() : super.getParts());
	}

	public Entity[] superGetParts() {
		return super.getParts();
	}

	@Override
	public boolean isEntityEqual(Entity entity) {
		return masterEntity != null ? masterEntity.isEntityEqual(entity) : super.isEntityEqual(entity);
	}

	public boolean superIsEntityEqual(Object entity) {
		return super.isEntityEqual((Entity) entity);
	}

	@Override
	public boolean canAttackWithItem() {
		return masterEntity != null ? masterEntity.canAttackWithItem() : super.canAttackWithItem();
	}

	public boolean superCanAttackWithItem() {
		return super.canAttackWithItem();
	}

	@Override
	public boolean hitByEntity(Entity entity) {
		return masterEntity != null ? masterEntity.hitByEntity(entity) : super.hitByEntity(entity);
	}

	public boolean superHitByEntity(Object entity) {
		return super.hitByEntity((Entity) entity);
	}

	@Override
	public String toString() {
		return masterEntity != null ? masterEntity.toString() : super.toString();
	}

	public String superToString() {
		return super.toString();
	}

	@Override
	public boolean isEntityInvulnerable() {
		return masterEntity != null ? masterEntity.isEntityInvulnerable() : super.isEntityInvulnerable();
	}

	public boolean superIsEntityInvulnerable() {
		return super.isEntityInvulnerable();
	}

	@Override
	public void copyLocationAndAnglesFrom(Entity entity) {
		if (masterEntity != null) masterEntity.copyLocationAndAnglesFrom(entity);
		else super.copyLocationAndAnglesFrom(entity);
	}

	public void superCopyLocationAndAnglesFrom(Object entity) {
		super.copyLocationAndAnglesFrom((Entity) entity);
	}

	@Override
	public void copyDataFrom(Entity entity, boolean par2) {
		if (masterEntity != null) masterEntity.copyDataFrom(entity, par2);
		else super.copyDataFrom(entity, par2);
	}

	public void superCopyDataFrom(Object entity, boolean par2) {
		super.copyDataFrom((Entity) entity, par2);
	}

	@Override
	public void travelToDimension(int par1) {
		if (masterEntity != null) masterEntity.travelToDimension(par1);
		else super.travelToDimension(par1);
	}

	public void superTravelToDimension(int par1) {
		super.travelToDimension(par1);
	}

	@Override
	public int getTeleportDirection() {
		return masterEntity != null ? masterEntity.getTeleportDirection() : super.getTeleportDirection();
	}

	public int superGetTeleportDirection() {
		return super.getTeleportDirection();
	}

	@Override
	public boolean doesEntityNotTriggerPressurePlate() {
		return masterEntity != null ? masterEntity.doesEntityNotTriggerPressurePlate() : super.doesEntityNotTriggerPressurePlate();
	}

	public boolean superDoesEntityNotTriggerPressurePlate() {
		return super.doesEntityNotTriggerPressurePlate();
	}

	@Override
	public void addEntityCrashInfo(CrashReportCategory crashReportCategory) {
		if (masterEntity != null) masterEntity.addEntityCrashInfo(crashReportCategory);
		else super.addEntityCrashInfo(crashReportCategory);
	}

	public void superAddEntityCrashInfo(Object crashReportCategory) {
		super.addEntityCrashInfo((CrashReportCategory) crashReportCategory);
	}

	@Override
	public boolean canRenderOnFire() {
		return masterEntity != null ? masterEntity.canRenderOnFire() : super.canRenderOnFire();
	}

	public boolean superCanRenderOnFire() {
		return super.canRenderOnFire();
	}

	@Override
	public UUID getUniqueID() {
		return masterEntity != null ? masterEntity.getUniqueID() : super.getUniqueID();
	}

	public UUID superGetUniqueID() {
		return super.getUniqueID();
	}

	@Override
	public boolean isPushedByWater() {
		return masterEntity != null ? masterEntity.isPushedByWater() : super.isPushedByWater();
	}

	public boolean superIsPushedByWater() {
		return super.isPushedByWater();
	}

	@Override
	public NBTTagCompound getEntityData() {
		return (NBTTagCompound) (masterEntity != null ? masterEntity.getEntityData() : super.getEntityData());
	}

	public NBTTagCompound superGetEntityData() {
		return super.getEntityData();
	}

	@Override
	public boolean shouldRiderSit() {
		return masterEntity != null ? masterEntity.shouldRiderSit() : super.shouldRiderSit();
	}

	public boolean superShouldRiderSit() {
		return super.shouldRiderSit();
	}

	@Override
	public ItemStack getPickedResult(MovingObjectPosition movingObjectPosition) {
		return (ItemStack) (masterEntity != null ? masterEntity.getPickedResult(movingObjectPosition) : super.getPickedResult(movingObjectPosition));
	}

	public ItemStack superGetPickedResult(Object movingObjectPosition) {
		return super.getPickedResult((MovingObjectPosition) movingObjectPosition);
	}

	@Override
	public UUID getPersistentID() {
		return (UUID) (masterEntity != null ? masterEntity.getPersistentID() : super.getPersistentID());
	}

	public UUID superGetPersistentID() {
		return super.getPersistentID();
	}

	@Override
	public boolean shouldRenderInPass(int pass) {
		return masterEntity != null ? masterEntity.shouldRenderInPass(pass) : super.shouldRenderInPass(pass);
	}

	public boolean superShouldRenderInPass(int pass) {
		return super.shouldRenderInPass(pass);
	}

	@Override
	public boolean isCreatureType(EnumCreatureType enumCreatureType, boolean forSpawnCount) {
		return masterEntity != null ? masterEntity.isCreatureType(enumCreatureType, forSpawnCount) : super.isCreatureType(enumCreatureType, forSpawnCount);
	}

	public boolean superIsCreatureType(Object enumCreatureType, boolean forSpawnCount) {
		return super.isCreatureType((EnumCreatureType) enumCreatureType, forSpawnCount);
	}

	@Override
	public String registerExtendedProperties(String identifier, IExtendedEntityProperties iExtendedEntityProperties) {
		return masterEntity != null ? masterEntity.registerExtendedProperties(identifier, iExtendedEntityProperties) : super.registerExtendedProperties(identifier, iExtendedEntityProperties);
	}

	public String superRegisterExtendedProperties(String identifier, Object iExtendedEntityProperties) {
		return super.registerExtendedProperties(identifier, (IExtendedEntityProperties) iExtendedEntityProperties);
	}

	@Override
	public IExtendedEntityProperties getExtendedProperties(String identifier) {
		return (IExtendedEntityProperties) (masterEntity != null ? masterEntity.getExtendedProperties(identifier) : super.getExtendedProperties(identifier));
	}

	public IExtendedEntityProperties superGetExtendedProperties(String identifier) {
		return super.getExtendedProperties(identifier);
	}

	@Override
	public boolean canRiderInteract() {
		return masterEntity != null ? masterEntity.canRiderInteract() : super.canRiderInteract();
	}

	public boolean superCanRiderInteract() {
		return super.canRiderInteract();
	}

	@Override
	public boolean shouldDismountInWater(Entity entity) {
		return masterEntity != null ? masterEntity.shouldDismountInWater(entity) : super.shouldDismountInWater(entity);
	}

	public boolean superShouldDismountInWater(Object entity) {
		return super.shouldDismountInWater((Entity) entity);
	}

	// 172~
	public EntityLivingBase getOwner() {
		return null;
	}

	public EntityLivingBase superGetOwner() {
		return null;
	}

	public void func_146082_f(EntityPlayer entityPlayer) {
	}

	public void superFunc_146082_f(Object entityPlayer) {
	}

	public EntityPlayer func_146083_cb() {
		return null;
	}

	public EntityPlayer superFunc_146083_cb() {
		return null;
	}

	public boolean isWithinHomeDistanceCurrentPosition() {
		return false;
	}

	public boolean superIsWithinHomeDistanceCurrentPosition() {
		return false;
	}

	public boolean isWithinHomeDistance(int par1, int par2, int par3) {
		return false;
	}

	public boolean superIsWithinHomeDistance(int par1, int par2, int par3) {
		return false;
	}

	protected void updateLeashedState() {
	}

	public void superUpdateLeashedState() {
	}

	protected Item getDropItem() {
		return null;
	}

	public Item superGetDropItem() {
		return null;
	}

	public ItemStack getEquipmentInSlot(int par1) {
		return null;
	}

	public ItemStack superGetEquipmentInSlot(int par1) {
		return null;
	}

	public Object onSpawnWithEgg(Object iEntityLivingData) {
		return null;
	}

	public Object superOnSpawnWithEgg(Object iEntityLivingData) {
		return null;
	}

	public String getCommandSenderName() {
		return null;
	}

	public String superGetCommandSenderName() {
		return null;
	}

	protected boolean func_146066_aG() {
		return false;
	}

	public boolean superFunc_146066_aG() {
		return false;
	}

	protected String func_146067_o(int p_146067_1_) {
		return null;
	}

	public String superFunc_146067_o(int p_146067_1_) {
		return null;
	}

	public Object getEntityAttribute(Object iAttribute) {
		return null;
	}

	public Object superGetEntityAttribute(Object iAttribute) {
		return null;
	}
/*
	public Object getItemIcon(ItemStack itemStack, int par2) {
		return null;
	}
*/
	public Object superGetItemIcon(Object itemStack, int par2) {
		return null;
	}

	public int getEntityId() {
		return -1;
	}

	public int superGetEntityId() {
		return -1;
	}

	public void setEntityId(int p_145769_1_) {
	}

	public void superSetEntityId(int p_145769_1_) {
	}

	protected String getSwimSound() {
		return null;
	}

	public String superGetSwimSound() {
		return null;
	}

	protected void func_145775_I() {
	}

	public void superFunc_145775_I() {
	}

	protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block block) {
	}

	public void superFunc_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Object block) {
	}
/*
	protected String getSplashSound() {
		return null;
	}
*/
	public String superGetSplashSound() {
		return null;
	}

	public boolean isInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
		return false;
	}

	public boolean superIsInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
		return false;
	}

	public EntityItem dropItem(Item item, int p_145779_2_) {
		return null;
	}

	public EntityItem superDropItem(Object item, int p_145779_2_) {
		return null;
	}

	public EntityItem func_145778_a(Item item, int p_145778_2_, float p_145778_3_) {
		return null;
	}

	public EntityItem superFunc_145778_a(Object item, int p_145778_2_, float p_145778_3_) {
		return null;
	}

	protected boolean func_145771_j(double p_145771_1_, double p_145771_3_, double p_145771_5_) {
		return false;
	}

	public boolean superFunc_145771_j(double p_145771_1_, double p_145771_3_, double p_145771_5_) {
		return false;
	}

	public float func_145772_a(Explosion explosion, World world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Block block) {
		return 0.0F;
	}

	public float superFunc_145772_a(Object explosion, Object world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Object block) {
		return 0.0F;
	}

	public boolean func_145774_a(Explosion explosion, World world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Block block, float p_145774_7_) {
		return false;
	}

	public boolean superFunc_145774_a(Object explosion, Object world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Object block, float p_145774_7_) {
		return false;
	}

	public Object func_145748_c_() {
		return null;
	}

	public Object superFunc_145748_c_() {
		return null;
	}

	public void func_145781_i(int p_145781_1_) {
	}

	public void superFunc_145781_i(int p_145781_1_) {
	}

}
