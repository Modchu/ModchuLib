package modchu.lib.forge.mc210;import java.util.HashMap;import java.util.List;import java.util.Map;import net.minecraft.entity.Entity;import net.minecraft.entity.MoverType;import net.minecraft.entity.player.EntityPlayer;import net.minecraft.stats.Achievement;import net.minecraft.util.EnumActionResult;import net.minecraft.util.EnumHand;import net.minecraft.util.SoundEvent;import net.minecraft.util.text.ITextComponent;public class Modchu_EntityPlayerSP extends modchu.lib.forge.mc210_212.Modchu_EntityPlayerSP {
	public Modchu_EntityPlayerSP(HashMap<String, Object> map) {
		super(map);
	}	// 212~分離	@Override	public void addChatComponentMessage(ITextComponent ITextComponent, boolean p_146105_2_) {		if (master != null) master.sendStatusMessage(ITextComponent, p_146105_2_);		else super.addChatComponentMessage(ITextComponent, p_146105_2_);	}	@Override	public void superSendStatusMessage(Object ITextComponent, boolean p_146105_2_) {		super.addChatComponentMessage((ITextComponent) ITextComponent, p_146105_2_);	}	@Override	public EnumActionResult func_190775_a(Entity entity, EnumHand enumHand) {		return (EnumActionResult) (master != null ? master.interact(entity, null, enumHand) : super.func_190775_a(entity, enumHand));	}	@Override	public Object superInteract(Object entity, Object itemStack, Object enumHand) {		return super.func_190775_a((Entity) entity, (EnumHand) enumHand);	}	@Override	public void moveEntity(MoverType moverType, double x, double y, double z) {		if (master != null) master.move(moverType, x, y, z);		else super.moveEntity(moverType, x, y, z);	}	@Override	public void superMove(Object moverType, double x, double y, double z) {		super.moveEntity((MoverType) moverType, x, y, z);	}	@Override	public void addChatMessage(ITextComponent ITextComponent) {		if (master != null) master.sendMessage(ITextComponent);		else super.addChatMessage(ITextComponent);	}	@Override	public void superSendMessage(Object ITextComponent) {		super.addChatMessage((ITextComponent) ITextComponent);	}	@Override	public boolean canCommandSenderUseCommand(int permLevel, String commandName) {		return master != null ? master.canUseCommand(permLevel, commandName) : super.canCommandSenderUseCommand(permLevel, commandName);	}	@Override	public void setAngles(float yaw, float pitch) {		if (master != null) master.turn(yaw, pitch);		else super.setAngles(yaw, pitch);	}	@Override	public void superTurn(float yaw, float pitch) {		super.setAngles(yaw, pitch);	}	@Override	public Object getDataWatcherWatchableObject(int i) {		return null;	}	@Override	public void setDataWatcherWatchableObject(int i, Object o) {	}	@Override	public void setDataWatcherWatchableObject(int i, int i2) {	}	@Override	public void moveEntityWithHeading(float f, float f1) {		if (master != null) master.travel(f, f1, 0.0F);		super.moveEntityWithHeading(f, f1);	}	@Override	public SoundEvent getHurtSound() {		if (master != null) return (SoundEvent) master.getHurtSound(null);		return super.getHurtSound();	}	@Override	public void supertravel(float f, float f1, float f2) {		super.moveEntityWithHeading(f, f1);	}	@Override	public Object supergetHurtSound(Object damageSource) {		return super.getHurtSound();	}	@Override	public void onUpdateWalkingPlayer() {		if (master != null) master.onUpdateWalkingPlayer();		else super.onUpdateWalkingPlayer();	}	@Override	public void superOnUpdateWalkingPlayer() {		super.onUpdateWalkingPlayer();	}	@Override	public void addToPlayerScore(Entity entity, int amount) {		if (master != null) master.awardKillScore(entity, amount, null);		else super.addToPlayerScore(entity, amount);	}	@Override	public void superAwardKillScore(Object entity, int amount, Object damageSource) {		super.addToPlayerScore((Entity) entity, amount);	}	@Override	public void clonePlayer(EntityPlayer entityPlayer, boolean respawnFromEnd) {		if (master != null) master.clonePlayer(entityPlayer, respawnFromEnd);		else super.clonePlayer(entityPlayer, respawnFromEnd);	}	@Override	public void superClonePlayer(Object entityPlayer, boolean respawnFromEnd) {		super.clonePlayer((EntityPlayer) entityPlayer, respawnFromEnd);	}	@Override	public void removeExperienceLevel(int levels) {		if (master != null) master.onEnchant(null, levels);		else super.removeExperienceLevel(levels);	}	@Override	public void superonEnchant(Object itemStack, int levels) {		super.removeExperienceLevel(levels);	}	@Override	public void moveRelative(float strafe, float forward, float friction) {		if (master != null) master.moveRelative(strafe, forward, friction, 0.0F);		else super.moveRelative(strafe, forward, friction);	}	@Override	public void supermoveRelative(float strafe, float forward, float friction, float f3) {		super.moveRelative(strafe, forward, friction);	}	@Override	public int getBrightnessForRender(float p_70070_1_) {		return master != null ? master.getBrightnessForRender(p_70070_1_) : super.getBrightnessForRender(p_70070_1_);	}	@Override	public int supergetBrightnessForRender(float p_70070_1_) {		return super.getBrightnessForRender(p_70070_1_);	}	@Override	public float getBrightness(float p_70013_1_) {		return master != null ? master.getBrightness(p_70013_1_) : super.getBrightness(p_70013_1_);	}	@Override	public float superGetBrightness(float p_70013_1_) {		return super.getBrightness(p_70013_1_);	}	@Override	public boolean hasAchievement(Achievement achievement) {		return master != null ? master.hasAchievement(achievement) : super.hasAchievement(achievement);	}	@Override	public boolean superHasAchievement(Object achievement) {		return super.hasAchievement((Achievement) achievement);	}	@Override	public int supergetBrightnessForRender() {		return -1;	}	@Override	public float supergetBrightness() {		return 0.0F;	}	@Override	public void supersetAngles(float yaw, float pitch) {		super.setAngles(yaw, pitch);	}	@Override	public void superaddChatMessage(Object iTextComponent) {		super.addChatMessage((ITextComponent) iTextComponent);	}	@Override	public boolean supercanCommandSenderUseCommand(int permLevel, String commandName) {		return super.canCommandSenderUseCommand(permLevel, commandName);	}	@Override	public Object superGetTeleportDirection() {		return super.getTeleportDirection();	}	@Override	public Object superFunc_181012_aH() {		return superGetTeleportDirection();	}	@Override	public void superFunc_181013_g(float p_181013_1_) {		superSetRenderYawOffset(p_181013_1_);	}	@Override	public void superOnInsideBlock(Object iBlockState) {	}	@Override	public float superFunc_191954_d(float p_191954_1_) {		return 0.0F;	}	@Override	public boolean superFunc_191957_ae() {		return false;	}	@Override	public boolean superHasNoGravity() {		return false;	}	@Override	public void superSetNoGravity(boolean noGravity) {	}	@Override	public boolean superFunc_191953_am() {		return false;	}	@Override	public Object superGetPitchYaw() {		return null;	}	@Override	public Object superGetForward() {		return null;	}	@Override	public boolean superGetIsInvulnerable() {		return false;	}	@Override	public boolean superCanTrample(Object world, Object block, Object blockPos, float fallDistance) {		return false;	}	@Override	public int superGetFireImmuneTicks() {		return -1;	}	@Override	public Map superGetActivePotionMap() {		return null;	}	@Override	public void superBlockUsingShield(Object entityLivingBase) {	}	@Override	public Object superGetLastDamageSource() {		return null;	}	@Override	public boolean superHasItemInSlot(Object entityEquipmentSlot) {		return false;	}	@Override	public float superGetWaterSlowDown() {		return 0.0F;	}	@Override	public boolean superAttackable() {		return false;	}	@Override	public void superSetPartying(Object blockPos, boolean p_191987_2_) {	}	@Override	public boolean superProcessInitialInteract(Object entityPlayer, Object enumHand) {		return false;	}	@Override	public Object superApplyPlayerInteraction(Object entityPlayer, Object vec3d, Object enumHand) {		return null;	}	@Override	public Object superGetRecipeBook() {		return null;	}	@Override	public void superFunc_193103_a(Object iRecipe) {	}	@Override	public void superOpenEditStructure(Object tileEntityStructure) {	}	@Override	public boolean superIsAutoJumpEnabled() {		return false;	}	@Override	public void superUpdateAutoJump(float p_189810_1_, float p_189810_2_) {	}	@Override	public void superDestroyVanishingCursedItems() {	}	@Override	public void superDisableShield(boolean p_190777_1_) {	}	@Override	public void superUnlockRecipes(List p_192021_1_) {	}	@Override	public void superUnlockRecipes(Object[] resourceLocation) {	}	@Override	public void superFunc_192022_b(List p_192022_1_) {	}	@Override	public boolean superAddItemStackToInventory(Object itemStack) {		return false;	}	@Override	public boolean superAddShoulderEntity(Object nBTTagCompound) {		return false;	}	@Override	public void superSpawnShoulderEntities() {	}	@Override	public Object superGetLeftShoulderEntity() {		return null;	}	@Override	public void superSetLeftShoulderEntity(Object nBTTagCompound) {	}	@Override	public Object superGetRightShoulderEntity() {		return null;	}	@Override	public void superSetRightShoulderEntity(Object nBTTagCompound) {	}	@Override	public boolean superCanUseCommandBlock() {		return false;	}	@Override	public boolean superHasSpawnDimension() {		return false;	}	@Override	public int superGetSpawnDimension() {		return -1;	}	@Override	public void superSetSpawnDimension(Object integer) {	}}