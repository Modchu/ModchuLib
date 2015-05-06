package modchu.lib.forge.mc152;

import java.util.HashMap;
import java.util.UUID;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityTameable;
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
	public void curePotionEffects(ItemStack itemStack) {
	}

	public void superCurePotionEffects(Object itemStack) {
	}

	public boolean shouldRiderFaceForward(EntityPlayer entityPlayer) {
		return false;
	}

	public boolean superShouldRiderFaceForward(Object entityPlayer) {
		return false;
	}

	public NBTTagCompound getEntityData() {
		return null;
	}

	public NBTTagCompound superGetEntityData() {
		return null;
	}

	public boolean shouldRiderSit() {
		return false;
	}

	public boolean superShouldRiderSit() {
		return false;
	}

	public ItemStack getPickedResult(MovingObjectPosition movingObjectPosition) {
		return null;
	}

	public ItemStack superGetPickedResult(Object movingObjectPosition) {
		return null;
	}

	public UUID getPersistentID() {
		return null;
	}

	public UUID superGetPersistentID() {
		return null;
	}

	public boolean shouldRenderInPass(int pass) {
		return true;
	}

	public boolean superShouldRenderInPass(int pass) {
		return true;
	}

	public boolean isCreatureType(EnumCreatureType enumCreatureType, boolean forSpawnCount) {
		return false;
	}

	public boolean superIsCreatureType(Object enumCreatureType, boolean forSpawnCount) {
		return false;
	}

	public String registerExtendedProperties(String identifier, Object iExtendedEntityProperties) {
		return null;
	}

	public String superRegisterExtendedProperties(String identifier, Object iExtendedEntityProperties) {
		return null;
	}

	public IExtendedEntityProperties getExtendedProperties(String identifier) {
		return null;
	}

	public Object superGetExtendedProperties(String identifier) {
		return null;
	}

	public boolean canRiderInteract() {
		return false;
	}

	public boolean superCanRiderInteract() {
		return false;
	}

	public boolean shouldDismountInWater(Entity entity) {
		return false;
	}

	public boolean superShouldDismountInWater(Object entity) {
		return false;
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

	protected String func_146067_o(int p_146067_1_) {
		return null;
	}

	public String superGetFallSoundString(int p_146067_1_) {
		return null;
	}

	public int getEntityId() {
		return entityId;
	}

	public int superGetEntityId() {
		return entityId;
	}

	public void setEntityId(int p_145769_1_) {
		entityId = p_145769_1_;
	}

	public void superSetEntityId(int p_145769_1_) {
		entityId = p_145769_1_;
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

	// 180~
	public boolean superIsWithinHomeDistance(Object blockPos) {
		return false;
	}

	@Override
	public Object superOnSpawnWithEgg(Object difficultyInstance, Object iEntityLivingData) {
		return null;
	}

	public String superGetName() {
		return null;
	}

	@Override
	public void superCopyDataFrom(Object entity) {
	}

	public boolean superFunc_174816_a(Object explosion, Object world, Object blockPos, Object iBlockState, float f) {
		return false;
	}

	public float superGetBlockPathWeight(Object blockPos) {
		return 0;
	}

	public float superGetExplosionResistance(Object explosion, Object world, Object blockPos, Object iBlockState) {
		return 0;
	}

	public Object superDropItemWithOffset(Object item, int p_145778_2_, float p_145778_3_) {
		return superFunc_145778_a(item, p_145778_2_, p_145778_3_);
	}

	public Object superGetDisplayName() {
		return superFunc_145748_c_();
	}

	public String superFunc_152113_b() {
		return null;
	}

	public void superFunc_152115_b(String par1Str) {
	}

	public String superFunc_146067_o(int p_146067_1_) {
		return null;
	}

	public float superFunc_180484_a(Object blockPos) {
		return 0.0F;
	}

	public boolean superFunc_180485_d(Object blockPos) {
		return false;
	}

	@Override
	public float superGetExplosionResistance(Object explosion, Object world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Object block) {
		return 0.0F;
	}

}
