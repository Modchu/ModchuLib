package modchu.lib.forge.mc180;

import java.util.HashMap;
import java.util.UUID;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityTameable;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.CombatTracker;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class Modchu_EntityTameable extends Modchu_EntityTameableB implements Modchu_IEntityTameable {

	public Modchu_EntityTameable(World world) {
		super(world);
	}

	public Modchu_EntityTameable(Object world) {
		this((World) world);
	}

	public Modchu_EntityTameable(HashMap<String, Object> map) {
		super(map);
		Modchu_Debug.lDebug("Modchu_EntityTameable init end.");
	}
	// 164~
	@Override
	public void curePotionEffects(ItemStack itemStack) {
		if (master != null) master.curePotionEffects(itemStack);
		else super.curePotionEffects(itemStack);
	}

	public void superCurePotionEffects(Object itemStack) {
		super.curePotionEffects((ItemStack) itemStack);
	}

	@Override
	public boolean shouldRiderFaceForward(EntityPlayer entityPlayer) {
		return master != null ? master.shouldRiderFaceForward(entityPlayer) : super.shouldRiderFaceForward(entityPlayer);
	}

	public boolean superShouldRiderFaceForward(Object entityPlayer) {
		return super.shouldRiderFaceForward((EntityPlayer) entityPlayer);
	}

	@Override
	public NBTTagCompound getEntityData() {
		return (NBTTagCompound) (master != null ? master.getEntityData() : super.getEntityData());
	}

	public NBTTagCompound superGetEntityData() {
		return super.getEntityData();
	}

	@Override
	public boolean shouldRiderSit() {
		return master != null ? master.shouldRiderSit() : super.shouldRiderSit();
	}

	public boolean superShouldRiderSit() {
		return super.shouldRiderSit();
	}

	@Override
	public ItemStack getPickedResult(MovingObjectPosition movingObjectPosition) {
		return (ItemStack) (master != null ? master.getPickedResult(movingObjectPosition) : super.getPickedResult(movingObjectPosition));
	}

	public ItemStack superGetPickedResult(Object movingObjectPosition) {
		return super.getPickedResult((MovingObjectPosition) movingObjectPosition);
	}

	@Override
	public UUID getPersistentID() {
		return master != null ? master.getPersistentID() : super.getPersistentID();
	}

	public UUID superGetPersistentID() {
		return super.getPersistentID();
	}

	@Override
	public boolean shouldRenderInPass(int pass) {
		return master != null ? master.shouldRenderInPass(pass) : super.shouldRenderInPass(pass);
	}

	public boolean superShouldRenderInPass(int pass) {
		return super.shouldRenderInPass(pass);
	}

	@Override
	public boolean isCreatureType(EnumCreatureType enumCreatureType, boolean forSpawnCount) {
		return master != null ? master.isCreatureType(enumCreatureType, forSpawnCount) : super.isCreatureType(enumCreatureType, forSpawnCount);
	}

	public boolean superIsCreatureType(Object enumCreatureType, boolean forSpawnCount) {
		return super.isCreatureType((EnumCreatureType) enumCreatureType, forSpawnCount);
	}

	@Override
	public String registerExtendedProperties(String identifier, IExtendedEntityProperties iExtendedEntityProperties) {
		return master != null ? master.registerExtendedProperties(identifier, iExtendedEntityProperties) : super.registerExtendedProperties(identifier, iExtendedEntityProperties);
	}

	public String superRegisterExtendedProperties(String identifier, Object iExtendedEntityProperties) {
		return super.registerExtendedProperties(identifier, (IExtendedEntityProperties) iExtendedEntityProperties);
	}

	@Override
	public IExtendedEntityProperties getExtendedProperties(String identifier) {
		return (IExtendedEntityProperties) (master != null ? master.getExtendedProperties(identifier) : super.getExtendedProperties(identifier));
	}

	public IExtendedEntityProperties superGetExtendedProperties(String identifier) {
		return super.getExtendedProperties(identifier);
	}

	@Override
	public boolean canRiderInteract() {
		return master != null ? master.canRiderInteract() : super.canRiderInteract();
	}

	public boolean superCanRiderInteract() {
		return super.canRiderInteract();
	}

	@Override
	public boolean shouldDismountInWater(Entity entity) {
		return master != null ? master.shouldDismountInWater(entity) : super.shouldDismountInWater(entity);
	}

	public boolean superShouldDismountInWater(Object entity) {
		return super.shouldDismountInWater((Entity) entity);
	}
	// 172~
	@Override
	public Entity getOwner() {
		return (EntityLivingBase) (master != null ? master.getOwner() : super.getOwner());
	}

	public Entity superGetOwner() {
		return super.getOwner();
	}

	@Override
	public EntityPlayer func_146083_cb() {
		return (EntityPlayer) (master != null ? master.func_146083_cb() : super.func_146083_cb());
	}

	public EntityPlayer superFunc_146083_cb() {
		return super.func_146083_cb();
	}

	@Override
	public boolean isWithinHomeDistanceCurrentPosition() {
		return master != null ? master.isWithinHomeDistanceCurrentPosition() : super.isWithinHomeDistanceCurrentPosition();
	}

	public boolean superIsWithinHomeDistanceCurrentPosition() {
		return super.isWithinHomeDistanceCurrentPosition();
	}

	@Override
	protected void updateLeashedState() {
		if (master != null) master.updateLeashedState();
		else super.updateLeashedState();
	}

	public void superUpdateLeashedState() {
		super.updateLeashedState();
	}

	@Override
	protected Item getDropItem() {
		return (Item) (master != null ? master.getDropItem() : super.getDropItem());
	}

	public Item superGetDropItem() {
		return super.getDropItem();
	}

	@Override
	public ItemStack getEquipmentInSlot(int par1) {
		return (ItemStack) (master != null ? master.getEquipmentInSlot(par1) : super.getEquipmentInSlot(par1));
	}

	public ItemStack superGetEquipmentInSlot(int par1) {
		return super.getEquipmentInSlot(par1);
	}

	@Override
	public String getName() {
		return master != null ? master.getName() : super.getName();
	}

	public String superGetName() {
		return super.getName();
	}

	@Override
	protected boolean func_146066_aG() {
		return master != null ? master.func_146066_aG() : super.func_146066_aG();
	}

	public boolean superFunc_146066_aG() {
		return super.func_146066_aG();
	}

	@Override
	protected String getFallSoundString(int p_146067_1_) {
		return master != null ? master.getFallSoundString(p_146067_1_) : super.getFallSoundString(p_146067_1_);
	}

	public String superGetFallSoundString(int p_146067_1_) {
		return super.getFallSoundString(p_146067_1_);
	}

	@Override
	public IAttributeInstance getEntityAttribute(IAttribute iAttribute) {
		return (IAttributeInstance) (master != null ? master.getEntityAttribute(iAttribute) : super.getEntityAttribute(iAttribute));
	}

	public IAttributeInstance superGetEntityAttribute(Object iAttribute) {
		return super.getEntityAttribute((IAttribute) iAttribute);
	}

	@Override
	public int getEntityId() {
		return master != null ? master.getEntityId() : super.getEntityId();
	}

	public int superGetEntityId() {
		return super.getEntityId();
	}

	@Override
	public void setEntityId(int p_145769_1_) {
		if (master != null) master.setEntityId(p_145769_1_);
		else super.setEntityId(p_145769_1_);
	}

	public void superSetEntityId(int p_145769_1_) {
		super.setEntityId(p_145769_1_);
	}

	@Override
	protected String getSwimSound() {
		return master != null ? master.getSwimSound() : super.getSwimSound();
	}

	public String superGetSwimSound() {
		return super.getSwimSound();
	}

	@Override
	protected String getSplashSound() {
		return master != null ? master.getSplashSound() : super.getSplashSound();
	}

	public String superGetSplashSound() {
		return super.getSplashSound();
	}

	@Override
	public boolean isInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
		return master != null ? master.isInRangeToRender3d(p_145770_1_, p_145770_3_, p_145770_5_) : super.isInRangeToRender3d(p_145770_1_, p_145770_3_, p_145770_5_);
	}

	public boolean superIsInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
		return super.isInRangeToRender3d(p_145770_1_, p_145770_3_, p_145770_5_);
	}

	@Override
	public EntityItem dropItem(Item item, int p_145779_2_) {
		return (EntityItem) (master != null ? master.dropItem(item, p_145779_2_) : super.dropItem(item, p_145779_2_));
	}

	public EntityItem superDropItem(Object item, int p_145779_2_) {
		return super.dropItem((Item) item, p_145779_2_);
	}

	@Override
	public EntityItem dropItemWithOffset(Item item, int p_145778_2_, float p_145778_3_) {
		return (EntityItem) (master != null ? master.dropItemWithOffset(item, p_145778_2_, p_145778_3_) : super.dropItemWithOffset(item, p_145778_2_, p_145778_3_));
	}

	public EntityItem superDropItemWithOffset(Object item, int p_145778_2_, float p_145778_3_) {
		return super.dropItemWithOffset((Item) item, p_145778_2_, p_145778_3_);
	}

	@Override
	protected boolean pushOutOfBlocks(double p_145771_1_, double p_145771_3_, double p_145771_5_) {
		return master != null ? master.pushOutOfBlocks(p_145771_1_, p_145771_3_, p_145771_5_) : super.pushOutOfBlocks(p_145771_1_, p_145771_3_, p_145771_5_);
	}

	public boolean superPushOutOfBlocks(double p_145771_1_, double p_145771_3_, double p_145771_5_) {
		return super.pushOutOfBlocks(p_145771_1_, p_145771_3_, p_145771_5_);
	}

	@Override
	public float getExplosionResistance(Explosion explosion, World world, BlockPos blockPos, IBlockState iBlockState) {
		return master != null ? master.getExplosionResistance(explosion, world, blockPos, iBlockState) : super.getExplosionResistance(explosion, world, blockPos, iBlockState);
	}

	public float superGetExplosionResistance(Object explosion, Object world, Object blockPos, Object iBlockState) {
		return super.getExplosionResistance((Explosion) explosion, (World) world, (BlockPos) blockPos, (IBlockState) iBlockState);
	}

	@Override
	public boolean func_174816_a(Explosion explosion, World world, BlockPos blockPos, IBlockState iBlockState, float f) {
		return master != null ? master.func_174816_a(explosion, world, blockPos, iBlockState, f) : super.func_174816_a(explosion, world, blockPos, iBlockState, f);
	}

	public boolean superFunc_174816_a(Object explosion, Object world, Object blockPos, Object iBlockState, float f) {
		return super.func_174816_a((Explosion) explosion, (World) world, (BlockPos) blockPos, (IBlockState) iBlockState, f);
	}

	@Override
	public IChatComponent getDisplayName() {
		return (IChatComponent) (master != null ? master.getDisplayName() : super.getDisplayName());
	}

	public IChatComponent superGetDisplayName() {
		return super.getDisplayName();
	}

	@Override
	public void func_145781_i(int p_145781_1_) {
		if (master != null) master.func_145781_i(p_145781_1_);
		else super.func_145781_i(p_145781_1_);
	}

	public void superFunc_145781_i(int p_145781_1_) {
		super.func_145781_i(p_145781_1_);
	}
	// ~179
	protected void attackEntity(Entity entity, float par2) {
	}

	public void superAttackEntity(Object entity, float par2) {
	}

	public float getBlockPathWeight(int par1, int par2, int par3) {
		return 0.0F;
	}

	public float superGetBlockPathWeight(int par1, int par2, int par3) {
		return 0.0F;
	}

	protected Entity findPlayerToAttack() {
		return null;
	}

	public Entity superFindPlayerToAttack() {
		return null;
	}

	protected boolean isMovementCeased() {
		return false;
	}

	public boolean superIsMovementCeased() {
		return false;
	}

	protected void updateWanderPath() {
	}

	public void superUpdateWanderPath() {
	}

	public void setPathToEntity(PathEntity pathEntity) {
	}

	public void superSetPathToEntity(Object pathEntity) {
	}

	public Entity getEntityToAttack() {
		return null;
	}

	public Entity superGetEntityToAttack() {
		return null;
	}

	public void setTarget(Entity entity) {
	}

	public void superSetTarget(Object entity) {
	}

	public void setHomeArea(int par1, int par2, int par3, int par4) {
	}

	public void superSetHomeArea(int par1, int par2, int par3, int par4) {
	}

	public Object getHomePosition() {
		return null;
	}

	public Object superGetHomePosition() {
		return null;
	}

	public float func_110174_bM() {
		return 0.0F;
	}

	public float superFunc_110174_bM() {
		return 0.0F;
	}

	protected boolean isAIEnabled() {
		return true;
	}

	public boolean superIsAIEnabled() {
		return true;
	}

	public int getMaxSafePointTries() {
		return -1;
	}

	public int superGetMaxSafePointTries() {
		return -1;
	}

	public ItemStack func_130225_q(int par1) {
		return null;
	}

	public ItemStack superFunc_130225_q(int par1) {
		return null;
	}

	public ItemStack[] getLastActiveItems() {
		return null;
	}

	public ItemStack[] superGetLastActiveItems() {
		return null;
	}

	public void func_110163_bv() {
	}

	public void superFunc_110163_bv() {
	}

	protected void enchantEquipment() {
	}

	public void superEnchantEquipment() {
	}

	public boolean hasCustomNameTag() {
		return hasCustomName();
	}

	public boolean superHasCustomNameTag() {
		return superHasCustomName();
	}

	protected void updateFallState(double par1, boolean par3) {
	}

	public void superUpdateFallState(double par1, boolean par3) {
	}

	public int func_142015_aE() {
		return -1;
	}

	public int superFunc_142015_aE() {
		return -1;
	}

	protected void fall(float par1) {
	}

	public void superFall(float par1) {
	}

	protected void dropRareDrop(int par1) {
	}

	public void superDropRareDrop(int par1) {
	}

	public CombatTracker func_110142_aN() {
		return null;
	}

	public CombatTracker superFunc_110142_aN() {
		return null;
	}

	public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
	}

	public void superSetPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
	}

	public Vec3 getPosition(float par1) {
		return getPositionVector();
	}

	public Vec3 superGetPosition(float par1) {
		return super.getPositionVector();
	}

	@Override
	public MovingObjectPosition rayTrace(double par1, float par3) {
		return null;
	}

	public MovingObjectPosition superRayTrace(double par1, float par3) {
		return null;
	}

	public boolean isClientWorld() {
		return false;
	}

	public boolean superIsClientWorld() {
		return false;
	}

	public float getShadowSize() {
		return 0.0F;
	}

	public float superGetShadowSize() {
		return 0.0F;
	}

	public boolean isEntityInvulnerable() {
		return false;
	}

	public boolean superIsEntityInvulnerable() {
		return false;
	}

	public void copyDataFrom(Entity entity, boolean par2) {
		copyDataFromOld(entity);
	}

	public void superCopyDataFrom(Object entity, boolean par2) {
		superCopyDataFrom(entity);
	}

	public IEntityLivingData onSpawnWithEgg(IEntityLivingData iEntityLivingData) {
		return func_180482_a(null, iEntityLivingData);
	}

	public IEntityLivingData superOnSpawnWithEgg(Object iEntityLivingData) {
		return superOnSpawnWithEgg(null, iEntityLivingData);
	}

	public void func_146082_f(EntityPlayer entityPlayer) {
	}

	public void superFunc_146082_f(Object entityPlayer) {
	}

	public boolean isWithinHomeDistance(int par1, int par2, int par3) {
		return func_180485_d(new BlockPos(par1, par2, par3));
	}

	public boolean superIsWithinHomeDistance(int par1, int par2, int par3) {
		return super.func_180485_d(new BlockPos(par1, par2, par3));
	}

	public String getCommandSenderName() {
		return getName();
	}

	public String superGetCommandSenderName() {
		return super.getName();
	}

	public Object getItemIcon(ItemStack itemStack, int par2) {
		return null;
	}

	public Object superGetItemIcon(Object itemStack, int par2) {
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

	public float getExplosionResistance(Explosion explosion, World world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Block block) {
		return 0.0F;
	}

	public float superGetExplosionResistance(Object explosion, Object world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Object block) {
		return 0.0F;
	}

	public boolean func_145774_a(Explosion explosion, World world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Block block, float p_145774_7_) {
		return false;
	}

	public boolean superFunc_145774_a(Object explosion, Object world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Object block, float p_145774_7_) {
		return false;
	}

	public void superUpdateEntityActionState() {
	}

	public float superFunc_145772_a(Object explosion, Object world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Object block) {
		return 0.0F;
	}
	// 180~
	@Override
	public float func_180484_a(BlockPos blockPos) {
		return master != null ? master.func_180484_a(blockPos) : super.func_180484_a(blockPos);
	}

	public float superGetBlockPathWeight(Object blockPos) {
		return super.func_180484_a((BlockPos) blockPos);
	}

	@Override
	public boolean func_180485_d(BlockPos blockPos) {
		return master != null ? master.func_180485_d(blockPos) : super.func_180485_d(blockPos);
	}

	public boolean superIsWithinHomeDistance(Object blockPos) {
		return super.func_180485_d((BlockPos) blockPos);
	}

	public String superFunc_152113_b() {
		return null;
	}

	public void superFunc_152115_b(String par1Str) {
	}

	public String superFunc_146067_o(int p_146067_1_) {
		return null;
	}

	public Object superFunc_145778_a(Object item, int p_145778_2_, float p_145778_3_) {
		return null;
	}

	public float superFunc_180484_a(Object blockPos) {
		return super.func_180484_a((BlockPos) blockPos);
	}

	public boolean superFunc_180485_d(Object blockPos) {
		return super.func_180485_d((BlockPos) blockPos);
	}

}
