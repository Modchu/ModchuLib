package modchu.lib.forge.mc210;import java.util.HashMap;import java.util.List;import java.util.Map;import net.minecraft.entity.Entity;import net.minecraft.entity.MoverType;import net.minecraft.entity.player.EntityPlayer;import net.minecraft.stats.Achievement;import net.minecraft.util.EnumActionResult;import net.minecraft.util.EnumHand;import net.minecraft.util.SoundEvent;import net.minecraft.util.text.ITextComponent;public class Modchu_EntityPlayerSP extends modchu.lib.forge.mc210_212.Modchu_EntityPlayerSP {	public Modchu_EntityPlayerSP(HashMap<String, Object> map) {		super(map);	}	// 212~????	@Override	public void addChatComponentMessage(ITextComponent ITextComponent, boolean p_146105_2_) {		if (master != null) master.sendStatusMessage(ITextComponent, p_146105_2_);		else super.addChatComponentMessage(ITextComponent, p_146105_2_);	}	@Override	public void supersendStatusMessage(Object ITextComponent, boolean p_146105_2_) {		super.addChatComponentMessage((ITextComponent) ITextComponent, p_146105_2_);	}	@Override	public EnumActionResult func_190775_a(Entity entity, EnumHand enumHand) {		return (EnumActionResult) (master != null ? master.interact(entity, null, enumHand) : super.func_190775_a(entity, enumHand));	}	@Override	public Object superinteract(Object entity, Object itemStack, Object enumHand) {		return super.func_190775_a((Entity) entity, (EnumHand) enumHand);	}	@Override	public void moveEntity(MoverType moverType, double x, double y, double z) {		if (master != null) master.move(moverType, x, y, z);		else super.moveEntity(moverType, x, y, z);	}	@Override	public void supermove(Object moverType, double x, double y, double z) {		super.moveEntity((MoverType) moverType, x, y, z);	}	@Override	public void addChatMessage(ITextComponent ITextComponent) {		if (master != null) master.sendMessage(ITextComponent);		else super.addChatMessage(ITextComponent);	}	@Override	public void supersendMessage(Object ITextComponent) {		super.addChatMessage((ITextComponent) ITextComponent);	}	@Override	public boolean canCommandSenderUseCommand(int permLevel, String commandName) {		return master != null ? master.canUseCommand(permLevel, commandName) : super.canCommandSenderUseCommand(permLevel, commandName);	}	@Override	public void setAngles(float yaw, float pitch) {		if (master != null) master.turn(yaw, pitch);		else super.setAngles(yaw, pitch);	}	@Override	public void superturn(float yaw, float pitch) {		super.setAngles(yaw, pitch);	}	@Override	public Object getDataWatcherWatchableObject(int i) {		return null;	}	@Override	public void setDataWatcherWatchableObject(int i, Object o) {	}	@Override	public void moveEntityWithHeading(float f, float f1) {		if (master != null) master.travel(f, f1, 0.0F);		super.moveEntityWithHeading(f, f1);	}	@Override	public SoundEvent getHurtSound() {		if (master != null) return (SoundEvent) master.getHurtSound(null);		return super.getHurtSound();	}	@Override	public void supertravel(float f, float f1, float f2) {		super.moveEntityWithHeading(f, f1);	}	@Override	public Object supergetHurtSound(Object damageSource) {		return super.getHurtSound();	}	@Override	public void onUpdateWalkingPlayer() {		if (master != null) master.onUpdateWalkingPlayer();		else super.onUpdateWalkingPlayer();	}	@Override	public void superonUpdateWalkingPlayer() {		super.onUpdateWalkingPlayer();	}	@Override	public void addToPlayerScore(Entity entity, int amount) {		if (master != null) master.awardKillScore(entity, amount, null);		else super.addToPlayerScore(entity, amount);	}	@Override	public void superawardKillScore(Object entity, int amount, Object damageSource) {		super.addToPlayerScore((Entity) entity, amount);	}	@Override	public void clonePlayer(EntityPlayer entityPlayer, boolean respawnFromEnd) {		if (master != null) master.clonePlayer(entityPlayer, respawnFromEnd);		else super.clonePlayer(entityPlayer, respawnFromEnd);	}	@Override	public void superclonePlayer(Object entityPlayer, boolean respawnFromEnd) {		super.clonePlayer((EntityPlayer) entityPlayer, respawnFromEnd);	}	@Override	public void removeExperienceLevel(int levels) {		if (master != null) master.onEnchant(null, levels);		else super.removeExperienceLevel(levels);	}	@Override	public void superonEnchant(Object itemStack, int levels) {		super.removeExperienceLevel(levels);	}	@Override	public void moveRelative(float strafe, float forward, float friction) {		if (master != null) master.moveRelative(strafe, forward, friction, 0.0F);		else super.moveRelative(strafe, forward, friction);	}	@Override	public void supermoveRelative(float strafe, float forward, float friction, float f3) {		super.moveRelative(strafe, forward, friction);	}	@Override	public int getBrightnessForRender(float p_70070_1_) {		return master != null ? master.getBrightnessForRender(p_70070_1_) : super.getBrightnessForRender(p_70070_1_);	}	@Override	public int supergetBrightnessForRender(float p_70070_1_) {		return super.getBrightnessForRender(p_70070_1_);	}	@Override	public float getBrightness(float p_70013_1_) {		return master != null ? master.getBrightness(p_70013_1_) : super.getBrightness(p_70013_1_);	}	@Override	public float supergetBrightness(float p_70013_1_) {		return super.getBrightness(p_70013_1_);	}	@Override	public boolean hasAchievement(Achievement achievement) {		return master != null ? master.hasAchievement(achievement) : super.hasAchievement(achievement);	}	@Override	public boolean superhasAchievement(Object achievement) {		return super.hasAchievement((Achievement) achievement);	}	@Override	public int supergetBrightnessForRender() {		return -1;	}	@Override	public float supergetBrightness() {		return 0.0F;	}	@Override	public void supersetAngles(float yaw, float pitch) {		super.setAngles(yaw, pitch);	}	@Override	public void superaddChatMessage(Object iTextComponent) {		super.addChatMessage((ITextComponent) iTextComponent);	}	@Override	public boolean supercanCommandSenderUseCommand(int permLevel, String commandName) {		return super.canCommandSenderUseCommand(permLevel, commandName);	}	@Override	public Object supergetTeleportDirection() {		return super.getTeleportDirection();	}	@Override	public Object superfunc_181012_aH() {		return supergetTeleportDirection();	}	@Override	public void superfunc_181013_g(float p_181013_1_) {		supersetRenderYawOffset(p_181013_1_);	}	@Override	public void superonInsideBlock(Object iBlockState) {	}	@Override	public float superfunc_191954_d(float p_191954_1_) {		return 0.0F;	}	@Override	public boolean superfunc_191957_ae() {		return false;	}	@Override	public boolean superhasNoGravity() {		return false;	}	@Override	public void supersetNoGravity(boolean noGravity) {	}	@Override	public boolean superfunc_191953_am() {		return false;	}	@Override	public Object supergetPitchYaw() {		return null;	}	@Override	public Object supergetForward() {		return null;	}	@Override	public boolean supergetIsInvulnerable() {		return false;	}	@Override	public boolean supercanTrample(Object world, Object block, Object blockPos, float fallDistance) {		return false;	}	@Override	public int supergetFireImmuneTicks() {		return -1;	}	@Override	public Map supergetActivePotionMap() {		return null;	}	@Override	public void superblockUsingShield(Object entityLivingBase) {	}	@Override	public Object supergetLastDamageSource() {		return null;	}	@Override	public boolean superhasItemInSlot(Object entityEquipmentSlot) {		return false;	}	@Override	public float supergetWaterSlowDown() {		return 0.0F;	}	@Override	public boolean superattackable() {		return false;	}	@Override	public void supersetPartying(Object blockPos, boolean p_191987_2_) {	}	@Override	public boolean superprocessInitialInteract(Object entityPlayer, Object enumHand) {		return false;	}	@Override	public Object superapplyPlayerInteraction(Object entityPlayer, Object vec3d, Object enumHand) {		return null;	}	@Override	public Object supergetRecipeBook() {		return null;	}	@Override	public void superfunc_193103_a(Object iRecipe) {	}	@Override	public void superopenEditStructure(Object tileEntityStructure) {	}	@Override	public boolean superisAutoJumpEnabled() {		return false;	}	@Override	public void superupdateAutoJump(float p_189810_1_, float p_189810_2_) {	}	@Override	public void superdestroyVanishingCursedItems() {	}	@Override	public void superdisableShield(boolean p_190777_1_) {	}	@Override	public void superunlockRecipes(List p_192021_1_) {	}	@Override	public void superunlockRecipes(Object[] resourceLocation) {	}	@Override	public void superfunc_192022_b(List p_192022_1_) {	}	@Override	public boolean superaddItemStackToInventory(Object itemStack) {		return false;	}	@Override	public boolean superaddShoulderEntity(Object nBTTagCompound) {		return false;	}	@Override	public void superspawnShoulderEntities() {	}	@Override	public Object supergetLeftShoulderEntity() {		return null;	}	@Override	public void supersetLeftShoulderEntity(Object nBTTagCompound) {	}	@Override	public Object supergetRightShoulderEntity() {		return null;	}	@Override	public void supersetRightShoulderEntity(Object nBTTagCompound) {	}	@Override	public boolean supercanUseCommandBlock() {		return false;	}	@Override	public boolean superhasSpawnDimension() {		return false;	}	@Override	public int supergetSpawnDimension() {		return -1;	}	@Override	public void supersetSpawnDimension(Object integer) {	}}