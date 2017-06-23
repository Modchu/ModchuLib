package modchu.lib.forge.mc194;

import java.util.HashMap;

import modchu.lib.Modchu_IEntityDataManager;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class Modchu_Entity extends modchu.lib.forge.mc190_220.Modchu_Entity {

	public Modchu_Entity(World world) {
		super(world);
	}

	public Modchu_Entity(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void entityDataManagerRegister(Class[] c1, int i, Object o) {
		((Modchu_IEntityDataManager) dataManager).entityDataManagerRegister(c1, i, o);
	}

	@Override
	public Object getDataWatcherWatchableObject(int i) {
		return ((Modchu_IEntityDataManager) dataManager).getDataWatcherWatchableObject(i);
	}

	@Override
	public void setDataWatcherWatchableObject(int i, Object o) {
		((Modchu_IEntityDataManager) dataManager).setDataWatcherWatchableObject(i, o);
	}

	@Override
	public void moveRelative(float p_70060_1_, float p_70060_2_, float p_70060_3_) {
		if (master != null) master.moveRelative(p_70060_1_, p_70060_2_, p_70060_3_, 0.0F);
		else super.moveRelative(p_70060_1_, p_70060_2_, p_70060_3_);
	}

	@Override
	public void superMoveRelative(float p_70060_1_, float p_70060_2_, float p_70060_3_, float f3) {
		super.moveRelative(p_70060_1_, p_70060_2_, p_70060_3_);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nBTTagCompound) {
		return (NBTTagCompound) (master != null ? master.writeToNBT(nBTTagCompound) : super.writeToNBT(nBTTagCompound));
	}

	@Override
	public Object superWriteToNBT(Object nBTTagCompound) {
		return super.writeToNBT((NBTTagCompound) nBTTagCompound);
	}

	@Override
	public boolean canBeAttackedWithItem() {
		return master != null ? master.canBeAttackedWithItem() : super.canBeAttackedWithItem();
	}

	@Override
	public boolean superCanBeAttackedWithItem() {
		return super.canBeAttackedWithItem();
	}

	@Override
	public void addTrackingPlayer(EntityPlayerMP entityPlayerMP) {
		if (master != null) master.addTrackingPlayer(entityPlayerMP);
		else super.addTrackingPlayer(entityPlayerMP);
	}

	@Override
	public void superAddTrackingPlayer(Object entityPlayerMP) {
		super.addTrackingPlayer((EntityPlayerMP) entityPlayerMP);
	}

	@Override
	public void removeTrackingPlayer(EntityPlayerMP entityPlayerMP) {
		if (master != null) master.removeTrackingPlayer(entityPlayerMP);
		else super.removeTrackingPlayer(entityPlayerMP);
	}

	@Override
	public void superRemoveTrackingPlayer(Object entityPlayerMP) {
		super.removeTrackingPlayer((EntityPlayerMP) entityPlayerMP);
	}

	@Override
	public boolean ignoreItemEntityData() {
		return master != null ? master.ignoreItemEntityData() : super.ignoreItemEntityData();
	}

	@Override
	public boolean superIgnoreItemEntityData() {
		return super.ignoreItemEntityData();
	}

	@Override
	public void setPositionAndRotationDirect(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
		if (master != null) master.setPositionAndRotationDirect(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_, p_180426_10_);
		else super.setPositionAndRotationDirect(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_, p_180426_10_);
	}

	@Override
	public void superSetPositionAndRotationDirect(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_, int p_180426_9_, boolean p_180426_10_) {
		super.setPositionAndRotationDirect(p_180426_1_, p_180426_3_, p_180426_5_, p_180426_7_, p_180426_8_, p_180426_9_, p_180426_10_);
	}
	// 200~分離
	@Override
	public void onChunkLoad() {
		if (master != null) master.onChunkLoad();
		else super.onChunkLoad();
	}

	@Override
	public void superOnChunkLoad() {
		super.onChunkLoad();
	}
	// 210~分離
	@Override
	public void moveEntity(double p_70091_1_, double p_70091_3_, double p_70091_5_) {
		if (master != null) master.move(null, p_70091_1_, p_70091_3_, p_70091_5_);
		else super.moveEntity(p_70091_1_, p_70091_3_, p_70091_5_);
	}

	@Override
	public void superMove(Object moverType, double p_70091_1_, double p_70091_3_, double p_70091_5_) {
		super.moveEntity(p_70091_1_, p_70091_3_, p_70091_5_);
	}

	@Override
	public boolean processInitialInteract(EntityPlayer entityPlayer, ItemStack itemStack, EnumHand enumHand) {
		return master != null ? master.processInitialInteract(entityPlayer, itemStack, enumHand) : super.processInitialInteract(entityPlayer, itemStack, enumHand);
	}

	@Override
	public boolean superProcessInitialInteract(Object entityPlayer, Object itemStack, Object enumHand) {
		return super.processInitialInteract((EntityPlayer) entityPlayer, (ItemStack) itemStack, (EnumHand) enumHand);
	}

	@Override
	public EnumActionResult applyPlayerInteraction(EntityPlayer entityPlayer, Vec3d vec3d, ItemStack itemStack, EnumHand enumHand) {
		return (EnumActionResult) (master != null ? master.applyPlayerInteraction(entityPlayer, vec3d, itemStack, enumHand) : super.applyPlayerInteraction(entityPlayer, vec3d, itemStack, enumHand));
	}

	@Override
	public EnumActionResult superApplyPlayerInteraction(Object entityPlayer, Object vec3d, Object itemStack, Object enumHand) {
		return super.applyPlayerInteraction((EntityPlayer) entityPlayer, (Vec3d) vec3d, (ItemStack) itemStack, (EnumHand) enumHand);
	}
	// 190~210共通コピペ　↓
	@Override
	public void setAngles(float p_70082_1_, float p_70082_2_) {
		if (master != null) master.turn(p_70082_1_, p_70082_2_);
		else super.setAngles(p_70082_1_, p_70082_2_);
	}

	@Override
	public void superTurn(float p_70082_1_, float p_70082_2_) {
		super.setAngles(p_70082_1_, p_70082_2_);
	}

	@Override
	public void addChatMessage(ITextComponent iTextComponent) {
		if (master != null) master.sendMessage(iTextComponent);
		else super.addChatMessage(iTextComponent);
	}

	@Override
	public void superSendMessage(Object iChatComponent) {
		super.addChatMessage((ITextComponent) iChatComponent);
	}

	@Override
	public boolean canCommandSenderUseCommand(int permLevel, String commandName) {
		return master != null ? master.canUseCommand(permLevel, commandName) : super.canCommandSenderUseCommand(permLevel, commandName);
	}

	@Override
	public boolean superCanUseCommand(int permLevel, String commandName) {
		return super.canCommandSenderUseCommand(permLevel, commandName);
	}
	// 190~210共通コピペ　↑
	@Override
	public int getBrightnessForRender(float p_70070_1_) {
		return master != null ? master.getBrightnessForRender(p_70070_1_) : super.getBrightnessForRender(p_70070_1_);
	}

	@Override
	public int superGetBrightnessForRender(float p_70070_1_) {
		return super.getBrightnessForRender(p_70070_1_);
	}

	@Override
	public float getBrightness(float p_70013_1_) {
		return master != null ? master.getBrightness(p_70013_1_) : super.getBrightness(p_70013_1_);
	}

	@Override
	public float superGetBrightness(float p_70013_1_) {
		return super.getBrightness(p_70013_1_);
	}

	@Override
	public void addToPlayerScore(Entity entity, int p_70084_2_) {
		if (master != null) master.addToPlayerScore(entity, p_70084_2_, null);
		else super.addToPlayerScore(entity, p_70084_2_);
	}

	@Override
	public void superAddToPlayerScore(Object entity, int p_70084_2_) {
		super.addToPlayerScore((Entity) entity, p_70084_2_);
	}

	@Override
	public String getCachedUniqueIdString() {
		return master != null ? master.getCachedUniqueIdString() : super.getCachedUniqueIdString();
	}

	@Override
	public String superGetCachedUniqueIdString() {
		return super.getCachedUniqueIdString();
	}

	@Override
	protected void kill() {
		if (master != null) master.outOfWorld();
		else super.kill();
	}

	@Override
	public void superOutOfWorld() {
		super.kill();
	}

	@Override
	protected void resetHeight() {
		if (master != null) master.doWaterSplashEffect();
		else super.resetHeight();
	}

	@Override
	public void superDoWaterSplashEffect() {
		super.resetHeight();
	}

	@Override
	public boolean verifyExplosion(Explosion explosion, World world, BlockPos blockPos, IBlockState iBlockState, float p_174816_5_) {
		return master != null ? master.canExplosionDestroyBlock(explosion, world, blockPos, iBlockState, p_174816_5_) : super.verifyExplosion(explosion, world, blockPos, iBlockState, p_174816_5_);
	}

	@Override
	public boolean superVerifyExplosion(Object explosion, Object world, Object blockPos, Object iBlockState, float p_174816_5_) {
		return super.verifyExplosion((Explosion) explosion, (World) world, (BlockPos) blockPos, (IBlockState) iBlockState, p_174816_5_);
	}

	@Override
	public void superFunc_191955_a(Object iBlockState) {
	}

	@Override
	public float superFunc_191954_d(float p_191954_1_) {
		return 0.0F;
	}

	@Override
	public boolean superFunc_191957_ae() {
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
	public boolean superFunc_191953_am() {
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

}
