package modchu.lib.forge.mc162;

import java.util.HashMap;
import java.util.UUID;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityTameable;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

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
	}

	@Override
	public void superCurePotionEffects(Object itemStack) {
	}

	@Override
	public boolean shouldRiderFaceForward(EntityPlayer entityPlayer) {
		return false;
	}

	@Override
	public boolean superShouldRiderFaceForward(Object entityPlayer) {
		return false;
	}

	@Override
	public NBTTagCompound getEntityData() {
		return null;
	}

	@Override
	public NBTTagCompound superGetEntityData() {
		return null;
	}

	@Override
	public boolean shouldRiderSit() {
		return false;
	}

	@Override
	public boolean superShouldRiderSit() {
		return false;
	}

	@Override
	public ItemStack getPickedResult(MovingObjectPosition movingObjectPosition) {
		return null;
	}

	@Override
	public ItemStack superGetPickedResult(Object movingObjectPosition) {
		return null;
	}

	@Override
	public UUID getPersistentID() {
		return null;
	}

	@Override
	public UUID superGetPersistentID() {
		return null;
	}

	@Override
	public boolean shouldRenderInPass(int pass) {
		return true;
	}

	@Override
	public boolean superShouldRenderInPass(int pass) {
		return true;
	}

	@Override
	public boolean isCreatureType(EnumCreatureType enumCreatureType, boolean forSpawnCount) {
		return false;
	}

	@Override
	public boolean superIsCreatureType(Object enumCreatureType, boolean forSpawnCount) {
		return false;
	}

	public String registerExtendedProperties(String identifier, Object iExtendedEntityProperties) {
		return null;
	}

	@Override
	public String superRegisterExtendedProperties(String identifier, Object iExtendedEntityProperties) {
		return null;
	}
/*
	public Object getExtendedProperties(String identifier) {
		return null;
	}
*/
	@Override
	public Object superGetExtendedProperties(String identifier) {
		return null;
	}

	@Override
	public boolean canRiderInteract() {
		return false;
	}

	@Override
	public boolean superCanRiderInteract() {
		return false;
	}

	@Override
	public boolean shouldDismountInWater(Entity entity) {
		return false;
	}

	@Override
	public boolean superShouldDismountInWater(Object entity) {
		return false;
	}

	// 172~
	@Override
	public EntityLivingBase getOwner() {
		return null;
	}

	@Override
	public EntityLivingBase superGetOwner() {
		return null;
	}

	public void func_146082_f(EntityPlayer entityPlayer) {
	}

	@Override
	public void superFunc_146082_f(Object entityPlayer) {
	}

	public EntityPlayer getPlayerInLove() {
		return null;
	}

	@Override
	public EntityPlayer superGetPlayerInLove() {
		return null;
	}

	public boolean isWithinHomeDistanceCurrentPosition() {
		return false;
	}

	@Override
	public boolean superIsWithinHomeDistanceCurrentPosition() {
		return false;
	}

	public boolean isWithinHomeDistance(int par1, int par2, int par3) {
		return false;
	}

	@Override
	public boolean superIsWithinHomeDistance(int par1, int par2, int par3) {
		return false;
	}

	protected void updateLeashedState() {
	}

	@Override
	public void superUpdateLeashedState() {
	}

	protected Item getDropItem() {
		return null;
	}

	@Override
	public Item superGetDropItem() {
		return null;
	}

	public ItemStack getEquipmentInSlot(int par1) {
		return null;
	}

	@Override
	public ItemStack superGetEquipmentInSlot(int par1) {
		return null;
	}

	public String getCommandSenderName() {
		return null;
	}

	@Override
	public String superGetCommandSenderName() {
		return null;
	}

	protected boolean canDropLoot() {
		return false;
	}

	@Override
	public boolean superCanDropLoot() {
		return false;
	}

	protected String func_146067_o(int p_146067_1_) {
		return null;
	}

	@Override
	public String superGetFallSoundString(int p_146067_1_) {
		return null;
	}

	public int getEntityId() {
		return -1;
	}

	@Override
	public int superGetEntityId() {
		return -1;
	}

	public void setEntityId(int p_145769_1_) {
	}

	@Override
	public void superSetEntityId(int p_145769_1_) {
	}

	protected String getSwimSound() {
		return null;
	}

	@Override
	public String superGetSwimSound() {
		return null;
	}

	protected void func_145775_I() {
	}

	@Override
	public void superFunc_145775_I() {
	}

	protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block block) {
	}

	@Override
	public void superFunc_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Object block) {
	}
/*
	protected String getSplashSound() {
		return null;
	}
*/
	@Override
	public String superGetSplashSound() {
		return null;
	}

	public boolean isInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
		return false;
	}

	@Override
	public boolean superIsInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
		return false;
	}

	public EntityItem dropItem(Item item, int p_145779_2_) {
		return null;
	}

	@Override
	public EntityItem superDropItem(Object item, int p_145779_2_) {
		return null;
	}

	public EntityItem func_145778_a(Item item, int p_145778_2_, float p_145778_3_) {
		return null;
	}

	@Override
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

	@Override
	public float superFunc_145772_a(Object explosion, Object world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Object block) {
		return 0.0F;
	}

	public boolean func_145774_a(Explosion explosion, World world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Block block, float p_145774_7_) {
		return false;
	}

	@Override
	public boolean superFunc_145774_a(Object explosion, Object world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Object block, float p_145774_7_) {
		return false;
	}

	public Object func_145748_c_() {
		return null;
	}

	public Object superFunc_145748_c_() {
		return null;
	}

	public void onDataWatcherUpdate(int p_145781_1_) {
	}

	@Override
	public void superOnDataWatcherUpdate(int p_145781_1_) {
	}

	// 180~
	public boolean superIsWithinHomeDistance(Object blockPos) {
		return false;
	}

	public Object superOnSpawnWithEgg(Object difficultyInstance, Object iEntityLivingData) {
		return null;
	}

	public String superGetName() {
		return null;
	}

	@Override
	public void superCopyDataFrom(Object entity) {
	}

	@Override
	public boolean superVerifyExplosion(Object explosion, Object world, Object blockPos, Object iBlockState, float f) {
		return false;
	}

	@Override
	public float superGetBlockPathWeight(Object blockPos) {
		return 0;
	}

	@Override
	public float superGetExplosionResistance(Object explosion, Object world, Object blockPos, Object iBlockState) {
		return 0;
	}

	@Override
	public Object superDropItemWithOffset(Object item, int p_145778_2_, float p_145778_3_) {
		return superFunc_145778_a(item, p_145778_2_, p_145778_3_);
	}

	@Override
	public Object superGetDisplayName() {
		return superFunc_145748_c_();
	}

	@Override
	public String superFunc_152113_b() {
		return null;
	}

	@Override
	public void superFunc_152115_b(String par1Str) {
	}

	@Override
	public String superFunc_146067_o(int p_146067_1_) {
		return null;
	}

	public float superFunc_180484_a(Object blockPos) {
		return 0.0F;
	}

	@Override
	public boolean superIsWithinHomeDistanceFromPosition(Object blockPos) {
		return false;
	}

	@Override
	public float superGetExplosionResistance(Object explosion, Object world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Object block) {
		return 0.0F;
	}

}
