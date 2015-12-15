package modchu.lib.forge.mc164;

import java.util.HashMap;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityTameable;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
	// 172~
	public void func_146082_f(EntityPlayer entityPlayer) {
	}

	public EntityPlayer func_146083_cb() {
		return null;
	}

	public boolean isWithinHomeDistanceCurrentPosition() {
		return false;
	}

	public boolean isWithinHomeDistance(int par1, int par2, int par3) {
		return false;
	}

	protected void updateLeashedState() {
	}

	protected Item getDropItem() {
		return null;
	}

	public ItemStack getEquipmentInSlot(int par1) {
		return null;
	}

	public String getCommandSenderName() {
		return null;
	}

	protected boolean func_146066_aG() {
		return false;
	}

	public int getEntityId() {
		return entityId;
	}

	@Override
	public int superGetEntityId() {
		return entityId;
	}

	public void setEntityId(int p_145769_1_) {
		entityId = p_145769_1_;
	}

	@Override
	public void superSetEntityId(int p_145769_1_) {
		entityId = p_145769_1_;
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

	protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block block) {
	}
/*
	protected String getSplashSound() {
		return null;
	}
*/
	public boolean isInRangeToRender3d(double p_145770_1_, double p_145770_3_, double p_145770_5_) {
		return false;
	}

	public EntityItem dropItem(Item item, int p_145779_2_) {
		return null;
	}

	public EntityItem func_145778_a(Item item, int p_145778_2_, float p_145778_3_) {
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

	public Object func_145748_c_() {
		return null;
	}

	public void func_145781_i(int p_145781_1_) {
	}
/*
	public Object getItemIcon(ItemStack itemStack, int par2) {
		return null;
	}
*/
	public boolean func_145774_a(Explosion explosion, World world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Block block, float p_145774_7_) {
		return false;
	}

	@Override
	public Object superGetPlayerInLove() {
		return null;
	}

	@Override
	public boolean superIsWithinHomeDistanceCurrentPosition() {
		return false;
	}

	@Override
	public void superUpdateLeashedState() {
	}

	@Override
	public Object superGetDropItem() {
		return null;
	}

	@Override
	public Object superGetEquipmentInSlot(int par1) {
		return null;
	}

	@Override
	public boolean superCanDropLoot() {
		return false;
	}

	@Override
	public String superGetFallSoundString(int p_146067_1_) {
		return null;
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
	public Object superDropItem(Object item, int p_145779_2_) {
		return null;
	}

	@Override
	public Object superDropItemWithOffset(Object item, int p_145778_2_, float p_145778_3_) {
		return null;
	}

	@Override
	public float superGetExplosionResistance(Object explosion, Object world, Object blockPos, Object iBlockState) {
		return 0;
	}

	@Override
	public boolean superVerifyExplosion(Object explosion, Object world, Object blockPos, Object iBlockState, float f) {
		return false;
	}

	@Override
	public Object superGetDisplayName() {
		return null;
	}

	@Override
	public void superOnDataWatcherUpdate(int p_145781_1_) {
	}

	@Override
	public void superFunc_146082_f(Object entityPlayer) {
	}

	@Override
	public boolean superIsWithinHomeDistance(int par1, int par2, int par3) {
		return false;
	}

	@Override
	public String superGetCommandSenderName() {
		return null;
	}

	@Override
	public void superFunc_145775_I() {
	}

	@Override
	public void superFunc_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Object block) {
	}

	@Override
	public float superGetExplosionResistance(Object explosion, Object world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Object block) {
		return 0;
	}

	@Override
	public boolean superFunc_145774_a(Object explosion, Object world, int p_145774_3_, int p_145774_4_, int p_145774_5_, Object block, float p_145774_7_) {
		return false;
	}

	@Override
	public float superFunc_145772_a(Object explosion, Object world, int p_145772_3_, int p_145772_4_, int p_145772_5_, Object block) {
		return 0;
	}

	@Override
	public float superGetBlockPathWeight(Object blockPos) {
		return 0;
	}

	@Override
	public boolean superIsWithinHomeDistanceFromPosition(Object blockPos) {
		return false;
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

	@Override
	public Object superFunc_145778_a(Object item, int p_145778_2_, float p_145778_3_) {
		return null;
	}

}
