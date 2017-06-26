package modchu.lib.forge.mc180;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modchu.lib.Modchu_IEntityOtherPlayerMP;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.CommandResultStats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.event.HoverEvent;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class Modchu_EntityOtherPlayerMP extends modchu.lib.forge.mc180_189.Modchu_EntityOtherPlayerMP implements Modchu_IEntityOtherPlayerMP {

	public Modchu_EntityOtherPlayerMP(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public boolean func_175148_a(EnumPlayerModelParts enumPlayerModelParts) {
		return master != null ? master.isWearing(enumPlayerModelParts) : super.func_175148_a(enumPlayerModelParts);
	}

	@Override
	public boolean superIsWearing(Object enumPlayerModelParts) {
		return super.func_175148_a((EnumPlayerModelParts) enumPlayerModelParts);
	}

	@Override
	protected boolean func_146066_aG() {
		return master != null ? master.canDropLoot() : super.func_146066_aG();
	}

	@Override
	public boolean superCanDropLoot() {
		return super.func_146066_aG();
	}

	@Override
	protected void func_175135_B() {
		if (master != null) master.updatePotionMetadata();
		else super.func_175135_B();
	}

	@Override
	public void superUpdatePotionMetadata() {
		super.func_175135_B();
	}

	@Override
	protected void func_175133_bi() {
		if (master != null) master.resetPotionEffectMetadata();
		else super.func_175133_bi();
	}

	@Override
	public void superResetPotionEffectMetadata() {
		super.func_175133_bi();
	}

	@Override
	protected void addRandomArmor() {
		if (master != null) master.addRandomDrop();
		else super.addRandomArmor();
	}

	@Override
	public void superAddRandomDrop() {
		super.addRandomArmor();
	}

	@Override
	protected void func_180466_bG() {
		if (master != null) master.handleJumpLava();
		else super.func_180466_bG();
	}

	@Override
	public void superHandleJumpLava() {
		super.func_180466_bG();
	}

	@Override
	protected float func_175134_bD() {
		return master != null ? master.getJumpUpwardsMotion() : super.func_175134_bD();
	}

	@Override
	public float superGetJumpUpwardsMotion() {
		return super.func_175134_bD();
	}

	@Override
	public void func_152111_bt() {
		if (master != null) master.sendEnterCombat();
		else super.func_152111_bt();
	}

	@Override
	public void superSendEnterCombat() {
		super.func_152111_bt();
	}

	@Override
	public void func_152112_bu() {
		if (master != null) master.sendEndCombat();
		else super.func_152112_bu();
	}

	@Override
	public void superSendEndCombat() {
		super.func_152112_bu();
	}

	@Override
	protected void func_175136_bO() {
		if (master != null) master.markPotionsDirty();
		else super.func_175136_bO();
	}

	@Override
	public void superMarkPotionsDirty() {
		super.func_175136_bO();
	}

	@Override
	public AxisAlignedBB getBoundingBox() {
		return (AxisAlignedBB) (master != null ? master.getCollisionBoundingBox() : super.getBoundingBox());
	}

	@Override
	public AxisAlignedBB superGetCollisionBoundingBox() {
		return super.getBoundingBox();
	}

	@Override
	public void setInPortal() {
		if (master != null) master.setPortal(null);
		else super.setInPortal();
	}

	@Override
	public void superSetPortal(Object bockPos) {
		super.setInPortal();
	}

	@Override
	public void handleHealthUpdate(byte p_70103_1_) {
		if (master != null) master.handleStatusUpdate(p_70103_1_);
		else super.handleHealthUpdate(p_70103_1_);
	}

	@Override
	public void superHandleStatusUpdate(byte p_70103_1_) {
		super.handleHealthUpdate(p_70103_1_);
	}

	@Override
	public int getTeleportDirection() {
		return (Integer) (master != null ? master.getLastPortalVec() : super.getTeleportDirection());
	}

	@Override
	public Object superGetLastPortalVec() {
		return super.getTeleportDirection();
	}

	@Override
	public void func_145781_i(int p_145781_1_) {
		if (master != null) master.onDataWatcherUpdate(p_145781_1_);
		else super.func_145781_i(p_145781_1_);
	}

	@Override
	public void superOnDataWatcherUpdate(int p_145781_1_) {
		super.func_145781_i(p_145781_1_);
	}

	@Override
	protected void func_180433_a(double p_180433_1_, boolean p_180433_3_, Block block, BlockPos blockPos) {
		if (master != null) master.updateFallState(p_180433_1_, p_180433_3_, block, blockPos);
		else super.func_180433_a(p_180433_1_, p_180433_3_, block, blockPos);
	}

	@Override
	public void superUpdateFallState(double p_180433_1_, boolean p_180433_3_, Object block, Object blockPos) {
		super.func_180433_a(p_180433_1_, p_180433_3_, (Block) block, (BlockPos) blockPos);
	}

	@Override
	public void func_180426_a(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
		if (master != null) master.setPositionAndRotationDirect(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_, p_180426_10_);
		else super.func_180426_a(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_, p_180426_10_);
	}

	@Override
	public void superSetPositionAndRotationDirect(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
		super.func_180426_a(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_, p_180426_10_);
	}

	@Override
	public boolean func_174816_a(Explosion explosion, World world, BlockPos blockPos, IBlockState iBlockState, float p_174816_5_) {
		return master != null ? master.canExplosionDestroyBlock(explosion, world, blockPos, iBlockState, p_174816_5_) : super.func_174816_a(explosion, world, blockPos, iBlockState, p_174816_5_);
	}

	@Override
	public boolean superVerifyExplosion(Object explosion, Object world, Object blockPos, Object iBlockState, float p_174816_5_) {
		return super.func_174816_a((Explosion) explosion, (World) world, (BlockPos) blockPos, (IBlockState) iBlockState, p_174816_5_);
	}

	@Override
	protected HoverEvent func_174823_aP() {
		return (HoverEvent) (master != null ? master.getHoverEvent() : super.func_174823_aP());
	}

	@Override
	public HoverEvent superGetHoverEvent() {
		return super.func_174823_aP();
	}

	@Override
	public boolean func_174827_a(EntityPlayerMP entityPlayerMP) {
		return master != null ? master.isSpectatedByPlayer(entityPlayerMP) : super.func_174827_a(entityPlayerMP);
	}

	@Override
	public boolean superIsSpectatedByPlayer(Object entityPlayerMP) {
		return super.func_174827_a((EntityPlayerMP) entityPlayerMP);
	}

	@Override
	public boolean canUseCommand(int permLevel, String commandName) {
		return master != null ? master.canUseCommand(permLevel, commandName) : super.canUseCommand(permLevel, commandName);
	}

	@Override
	public boolean superCanUseCommand(int permLevel, String commandName) {
		return super.canUseCommand(permLevel, commandName);
	}

	@Override
	public CommandResultStats func_174807_aT() {
		return (CommandResultStats) (master != null ? master.getCommandStats() : super.func_174807_aT());
	}

	@Override
	public CommandResultStats superGetCommandStats() {
		return super.func_174807_aT();
	}

	@Override
	public NBTTagCompound func_174819_aU() {
		return (NBTTagCompound) (master != null ? master.getNBTTagCompound() : super.func_174819_aU());
	}

	@Override
	public NBTTagCompound superGetNBTTagCompound() {
		return super.func_174819_aU();
	}

	@Override
	public void func_174834_g(NBTTagCompound nBTTagCompound) {
		if (master != null) master.clientUpdateEntityNBT(nBTTagCompound);
		else super.func_174834_g(nBTTagCompound);
	}

	@Override
	public void superClientUpdateEntityNBT(Object nBTTagCompound) {
		super.func_174834_g((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public boolean func_174825_a(EntityPlayer entityPlayer, Vec3 vec3) {
		return master != null ? master.interactAt(entityPlayer, vec3) : super.func_174825_a(entityPlayer, vec3);
	}

	@Override
	public boolean superInteractAt(Object entityPlayer, Object vec3) {
		return super.func_174825_a((EntityPlayer) entityPlayer, (Vec3) vec3);
	}

	@Override
	public boolean func_180427_aV() {
		return master != null ? master.isImmuneToExplosions() : super.func_180427_aV();
	}

	@Override
	public boolean superIsImmuneToExplosions() {
		return super.func_180427_aV();
	}

	@Override
	protected void func_174815_a(EntityLivingBase entityLivingBase, Entity entity) {
		if (master != null) master.applyEnchantments(entityLivingBase, entity);
		else super.func_174815_a(entityLivingBase, entity);
	}

	@Override
	public void superApplyEnchantments(Object entityLivingBase, Object entity) {
		super.func_174815_a((EntityLivingBase) entityLivingBase, (Entity) entity);
	}

	@Override
	public Object superApplyPlayerInteraction(Object entityPlayer, Object vec3d, Object itemStack, Object enumHand) {
		return null;
	}

	@Override
	public void superSetRenderYawOffset(float offset) {
	}

	@Override
	public Object superGetTeleportDirection() {
		return super.getTeleportDirection();
	}

	public boolean supercanCommandSenderUseCommand(int permLevel, String commandName) {
		return false;
	}

	@Override
	public void superFunc_181013_g(float p_181013_1_) {
	}

	@Override
	public boolean superFunc_146066_aG() {
		return false;
	}

	@Override
	public void superFunc_152111_bt() {
		superSendEnterCombat();
	}

	@Override
	public void superFunc_152112_bu() {
		superSendEndCombat();
	}

	@Override
	public void superFunc_110302_j() {
		superSetupCustomSkin();
	}

	@Override
	public Object superFunc_110309_l() {
		return superGetTextureSkin();
	}

	@Override
	public Object superFunc_110310_o() {
		return superGetTextureCape();
	}

	@Override
	public Object superFunc_110148_a(Object attribute) {
		return superGetEntityAttribute(attribute);
	}

	@Override
	public void superPlayStepSound(int par1, int par2, int par3, int par4) {
	}

	@Override
	public Object superDropItem(int par1, int par2) {
		return null;
	}

	@Override
	public Object superDropItemWithOffset(int par1, int par2, float par3) {
		return null;
	}

	@Override
	public boolean superFunc_152123_o() {
		return superHasSkin();
	}

	@Override
	public boolean superFunc_152122_n() {
		return superHasPlayerInfo();
	}

	@Override
	public Object superFunc_181014_aG() {
		return superGetLastPortalVec();
	}

	@Override
	public Collection<IChatComponent> getPrefixes() {
		return master != null ? master.getPrefixes() : super.getPrefixes();
	}

	@Override
	public Collection<IChatComponent> superGetPrefixes() {
		return super.getPrefixes();
	}

	@Override
	public Collection<IChatComponent> getSuffixes() {
		return master != null ? master.getSuffixes() : super.getSuffixes();
	}

	@Override
	public Collection<IChatComponent> superGetSuffixes() {
		return super.getSuffixes();
	}

	@Override
	public Object superFunc_181012_aH() {
		return superGetTeleportDirection();
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
	public NBTTagCompound superSerializeNBT() {
		return null;
	}

	@Override
	public void superSetAngles(float yaw, float pitch) {
		super.setAngles(yaw, pitch);
	}

	@Override
	public void superAddChatMessage(Object iTextComponent) {
		super.addChatMessage((IChatComponent) iTextComponent);
	}

	@Override
	public boolean superCanCommandSenderUseCommand(int permLevel, String commandName) {
		return super.canUseCommand(permLevel, commandName);
	}

	@Override
	public String superGetCachedUniqueIdString() {
		return null;
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
	public void superDestroyVanishingCursedItems() {
	}

	@Override
	public void superOpenEditStructure(Object tileEntityStructure) {
	}

	@Override
	public void superDisableShield(boolean p_190777_1_) {
	}

	@Override
	public void superUnlockRecipes(List p_192021_1_) {
	}

	@Override
	public void superUnlockRecipes(Object[] resourceLocation) {
	}

	@Override
	public void superFunc_192022_b(List p_192022_1_) {
	}

	@Override
	public boolean superAddItemStackToInventory(Object itemStack) {
		return false;
	}

	@Override
	public boolean superAddShoulderEntity(Object nBTTagCompound) {
		return false;
	}

	@Override
	public void superSpawnShoulderEntities() {
	}

	@Override
	public Object superGetLeftShoulderEntity() {
		return null;
	}

	@Override
	public void superSetLeftShoulderEntity(Object nBTTagCompound) {
	}

	@Override
	public Object superGetRightShoulderEntity() {
		return null;
	}

	@Override
	public void superSetRightShoulderEntity(Object nBTTagCompound) {
	}

	@Override
	public boolean superCanUseCommandBlock() {
		return false;
	}

	@Override
	public boolean superHasSpawnDimension() {
		return false;
	}

	@Override
	public int superGetSpawnDimension() {
		return -1;
	}

	@Override
	public void superSetSpawnDimension(Object integer) {
	}

}
