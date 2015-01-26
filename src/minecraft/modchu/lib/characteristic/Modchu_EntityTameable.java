package modchu.lib.characteristic;

import java.util.UUID;

import modchu.lib.Modchu_Debug;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class Modchu_EntityTameable extends Modchu_EntityTameableB {

	public Modchu_EntityTameable(World world) {
		this(null, world);
	}

	public Modchu_EntityTameable(Object world) {
		this((World) world);
	}

	public Modchu_EntityTameable(Class masterClass, Object world) {
		super(masterClass, world);
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

	public String superGetFallSoundString(int p_146067_1_) {
		return null;
	}

	public String superFunc_146067_o(int p_146067_1_) {
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

	public EntityItem superDropItemWithOffset(Object item, int p_145778_2_, float p_145778_3_) {
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

	public Object func_145748_c_() {
		return null;
	}

	public Object superGetDisplayName() {
		return null;
	}

	public void func_145781_i(int p_145781_1_) {
	}

	public void superFunc_145781_i(int p_145781_1_) {
	}
/*
	public Object getItemIcon(ItemStack itemStack, int par2) {
		return null;
	}
*/
	public Object superGetItemIcon(Object itemStack, int par2) {
		return null;
	}

	public boolean func_145774_a(Explosion explosion, World world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Block block, float p_145774_7_) {
		return false;
	}

	public boolean superFunc_145774_a(Object explosion, Object world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Object block, float p_145774_7_) {
		return false;
	}

	// 180~
	public boolean superFunc_174816_a(Object explosion, Object world, Object blockPos, Object iBlockState, float f) {
		return false;
	}

	public float superGetBlockPathWeight(Object blockPos) {
		return 0.0F;
	}

	public float superGetExplosionResistance(Object explosion, Object world, Object blockPos, Object iBlockState) {
		return 0.0F;
	}

	public boolean superIsWithinHomeDistance(Object blockPos) {
		return false;
	}

	public Object superOnSpawnWithEgg(Object difficultyInstance, Object iEntityLivingData) {
		return superOnSpawnWithEgg(iEntityLivingData);
	}

	public String superGetName() {
		return superGetCommandSenderName();
	}

	public String superFunc_152113_b() {
		return null;
	}

	public void superFunc_152115_b(String par1Str) {
	}

	public Object superFunc_145778_a(Object item, int p_145778_2_, float p_145778_3_) {
		return null;
	}

	public float superFunc_180484_a(Object blockPos) {
		return 0.0F;
	}

	public boolean superFunc_180485_d(Object blockPos) {
		return false;
	}

}
