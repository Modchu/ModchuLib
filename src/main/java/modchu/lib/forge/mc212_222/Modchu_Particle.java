package modchu.lib.forge.mc212_222;

import java.util.HashMap;

import net.minecraft.util.math.AxisAlignedBB;

public abstract class Modchu_Particle extends modchu.lib.forge.mc194_222.Modchu_Particle {

	public Modchu_Particle(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void move(double par1, double par3, double par5) {
		if (master != null) master.move(par1, par3, par5);
		else super.move(par1, par3, par5);
	}

	@Override
	public void superMove(double par1, double par3, double par5) {
		super.move(par1, par3, par5);
	}

	@Override
	public AxisAlignedBB getBoundingBox() {
		return (AxisAlignedBB) (master != null ? master.getBoundingBox() : super.getBoundingBox());
	}

	public AxisAlignedBB superGetBoundingBox() {
		return super.getBoundingBox();
	}

	@Override
	public void setBoundingBox(AxisAlignedBB axisAlignedBB) {
		if (master != null) master.setBoundingBox(axisAlignedBB);
		else super.setBoundingBox(axisAlignedBB);
	}

	public void superSetBoundingBox(Object axisAlignedBB) {
		super.setBoundingBox((AxisAlignedBB) axisAlignedBB);
	}

	@Override
	public String superGetTexture() {
		return null;
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
	public void superUnmountEntity(Object entity) {

	}

	@Override
	public void superUpdateCloak() {

	}

	@Override
	public float superGetAlpha() {
		return 0.0F;
	}

	@Override
	public void superOnKillCommand() {

	}

	@Override
	public boolean superIsSilent() {
		return false;
	}

	@Override
	public void superSetSilent(boolean isSilent) {

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
	public void superMoveToBlockPosAndAngles(Object blockPos, float rotationYawIn, float rotationPitchIn) {

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
	public Object superGetLook(float partialTicks) {
		return null;
	}

	@Override
	public Object superGetPositionEyes(float partialTicks) {
		return null;
	}

	@Override
	public Object superRayTrace(double blockReachDistance, float partialTicks) {
		return null;
	}

	@Override
	public void superFunc_181013_g(float p_181013_1_) {

	}

	@Override
	public Object superFunc_181012_aH() {
		return null;
	}

	@Override
	public void superSetCustomNameTag(String name) {

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
	public void superSetAlwaysRenderNameTag(boolean alwaysRenderNameTag) {

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
	public void superSetOutsideBorder(boolean outsideBorder) {

	}

	@Override
	public boolean superReplaceItemInInventory(int inventorySlot, Object itemStack) {
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
	public void superFunc_174817_o(Object entity) {

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

}
