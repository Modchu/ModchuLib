package modchu.lib.forge.mc179;

import java.util.HashMap;
import java.util.Map;

import modchu.lib.Modchu_IEntityTameable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class Modchu_EntityTameable extends modchu.lib.forge.mc172_179.Modchu_EntityTameable implements Modchu_IEntityTameable {

	public Modchu_EntityTameable(World world) {
		super(world);
	}

	public Modchu_EntityTameable(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public String func_152113_b() {
		return (String) (master != null ? master.getOwnerName() : super.func_152113_b());
	}

	@Override
	public String superGetOwnerName() {
		return super.func_152113_b();
	}

	@Override
	public void func_152115_b(String par1Str) {
		if (master != null) master.setOwner(par1Str);
		else super.func_152115_b(par1Str);
	}

	@Override
	public void superSetOwner(Object par1Str) {
		super.func_152115_b((String) par1Str);
	}

	@Override
	public boolean superFunc_146066_aG() {
		return superCanDropLoot();
	}

	@Override
	public void superSendEnterCombat() {
		super.func_152111_bt();
	}

	@Override
	public void superSendEndCombat() {
		super.func_152112_bu();
	}

	@Override
	public boolean superIsOwner(Object entityLivingBase) {
		return super.func_152114_e((EntityLivingBase) entityLivingBase);
	}

	@Override
	public boolean func_152114_e(EntityLivingBase entityLivingBase) {
		return master != null ? master.isOwner(entityLivingBase) : super.func_152114_e(entityLivingBase);
	}

	@Override
	public boolean superFunc_152114_e(Object entityLivingBase) {
		return super.func_152114_e((EntityLivingBase) entityLivingBase);
	}

	@Override
	public void func_152111_bt() {
		if (master != null) master.sendEnterCombat();
		else super.func_152111_bt();
	}

	@Override
	public void func_152112_bu() {
		if (master != null) master.sendEndCombat();
		else super.func_152112_bu();
	}

	@Override
	public Object superFunc_181014_aG() {
		return superGetLastPortalVec();
	}

	@Override
	public void superSetAngles(float yaw, float pitch) {
		super.setAngles(yaw, pitch);
	}

	@Override
	public void superAddChatMessage(Object iTextComponent) {
	}

	@Override
	public boolean superCanCommandSenderUseCommand(int permLevel, String commandName) {
		return false;
	}

	@Override
	public String superGetCachedUniqueIdString() {
		return null;
	}

	@Override
	public void superFunc_175501_a(int p_175501_1_, boolean p_175501_2_) {
	}

	@Override
	public Object superGetNewNavigator(Object world) {
		return null;
	}

	@Override
	public boolean superFunc_175448_a(Object itemStack) {
		return superCanEquipItem((ItemStack) itemStack);
	}

	@Override
	public Map superGetActivePotionMap() {
		return null;
	}

	@Override
	public void superBlockUsingShield(Object entityLivingBase) {
	}

	@Override
	public Object superGetLastDamageSource() {
		return null;
	}

	@Override
	public boolean superHasItemInSlot(Object entityEquipmentSlot) {
		return false;
	}

	@Override
	public float superGetWaterSlowDown() {
		return 0.0F;
	}

	@Override
	public boolean superAttackable() {
		return false;
	}

	@Override
	public void superSetPartying(Object blockPos, boolean p_191987_2_) {
	}

	@Override
	public boolean superProcessInitialInteract(Object entityPlayer, Object enumHand) {
		return false;
	}

	@Override
	public Object superApplyPlayerInteraction(Object entityPlayer, Object vec3d, Object enumHand) {
		return null;
	}

	@Override
	public void superOnInsideBlock(Object iBlockState) {
	}

	@Override
	public float superPlayFlySound(float p_191954_1_) {
		return 0.0F;
	}

	@Override
	public boolean superMakeFlySound() {
		return false;
	}

	@Override
	public boolean superHasNoGravity() {
		return false;
	}

	@Override
	public void superSetNoGravity(boolean noGravity) {
	}

	@Override
	public boolean superIsOverWater() {
		return false;
	}

	@Override
	public Object superGetPitchYaw() {
		return null;
	}

	@Override
	public Object superGetForward() {
		return null;
	}

	@Override
	public boolean superGetIsInvulnerable() {
		return false;
	}

	@Override
	public boolean superCanTrample(Object world, Object block, Object blockPos, float fallDistance) {
		return false;
	}

	@Override
	public int superGetFireImmuneTicks() {
		return -1;
	}

	@Override
	public void superSetTamedBy(Object entityPlayer) {
	}

	@Override
	public boolean superHoldingSpawnEggOfClass(Object itemStack, Class p_190669_2_) {
		return false;
	}

	@Override
	public double superFollowLeashSpeed() {
		return 0.0D;
	}

	@Override
	public void superSetMoveForward(float p_191989_1_) {
	}

	@Override
	public void superTravel(float p_191986_1_, float p_191986_2_, float p_191986_3_) {
	}

}
