package modchu.lib.forge.mc190;

import java.util.HashMap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityDataManager;
import modchu.lib.Modchu_IEntityTameable;
import modchu.lib.Modchu_Main;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

public class Modchu_EntityTameable extends modchu.lib.forge.mc190_212.Modchu_EntityTameable implements Modchu_IEntityTameable {

	public Modchu_EntityTameable(World world) {
		super(world);
	}

	public Modchu_EntityTameable(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void entityDataManagerRegister(Class[] c1, int i, Object o) {
		((Modchu_IEntityDataManager) dataWatcher).entityDataManagerRegister(c1, i, o);
	}

	@Override
	public Object getDataWatcherWatchableObject(int i) {
		return ((Modchu_IEntityDataManager) dataWatcher).getDataWatcherWatchableObject(i);
	}

	@Override
	public void setDataWatcherWatchableObject(int i, Object o) {
		((Modchu_IEntityDataManager) dataWatcher).setDataWatcherWatchableObject(i, o);
	}

	@Override
	protected void updateAITick() {
		if (master != null) master.handleJumpWater();
		else super.updateAITick();
	}

	@Override
	public void superHandleJumpWater() {
		super.updateAITick();
	}

	@Override
	protected void func_142017_o(float par1) {
		if (master != null) master.onLeashDistance(par1);
		else super.func_142017_o(par1);
	}

	@Override
	public void superOnLeashDistance(float par1) {
		super.func_142017_o(par1);
	}

	@Override
	public void moveFlying(float par1, float par2, float par3) {
		if (master != null) master.moveRelative(par1, par2, par3);
		else super.moveFlying(par1, par2, par3);
	}

	@Override
	public void superMoveRelative(float par1, float par2, float par3) {
		super.moveFlying(par1, par2, par3);
	}

	@Override
	public void writeToNBT(NBTTagCompound nBTTagCompound) {
		if (master != null) master.writeToNBT(nBTTagCompound);
		else super.writeToNBT(nBTTagCompound);
	}

	@Override
	public Object superWriteToNBT(Object nBTTagCompound) {
		super.writeToNBT((NBTTagCompound) nBTTagCompound);
		return nBTTagCompound;
	}

	@Override
	public boolean canAttackWithItem() {
		return master != null ? master.canBeAttackedWithItem() : super.canAttackWithItem();
	}

	@Override
	public boolean superCanBeAttackedWithItem() {
		return super.canAttackWithItem();
	}

	@Override
	public void func_175501_a(int p_175501_1_, boolean p_175501_2_) {
		if (master != null) master.ageUp(p_175501_1_, p_175501_2_);
		else super.func_175501_a(p_175501_1_, p_175501_2_);
	}

	@Override
	public void superAgeUp(int p_175501_1_, boolean p_175501_2_) {
		super.func_175501_a(p_175501_1_, p_175501_2_);
	}

	@Override
	protected boolean func_175448_a(ItemStack itemStack) {
		return master != null ? master.canEquipItem(itemStack) : super.func_175448_a(itemStack);
	}

	@Override
	public boolean superCanEquipItem(Object itemStack) {
		return super.func_175448_a((ItemStack) itemStack);
	}

	@Override
	public int func_184649_cE() {
		return master != null ? master.getHorizontalFaceSpeed() : super.func_184649_cE();
	}

	@Override
	public int superGetHorizontalFaceSpeed() {
		return super.func_184649_cE();
	}

	@Override
	public void setPositionAndRotation2(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean p_180426_10_) {
		if (master != null) master.setPositionAndRotationDirect(x, y, z, yaw, pitch, posRotationIncrements, p_180426_10_);
		else super.setPositionAndRotation2(x, y, z, yaw, pitch, posRotationIncrements, p_180426_10_);
	}

	@Override
	public void superSetPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean p_180426_10_) {
		super.setPositionAndRotation2(x, y, z, yaw, pitch, posRotationIncrements, p_180426_10_);
	}

	@Override
	public boolean teleportTo_(double x, double y, double z) {
		return master != null ? master.attemptTeleport(x, y, z) : super.teleportTo_(x, y, z);
	}

	@Override
	public boolean superAttemptTeleport(double x, double y, double z) {
		return super.teleportTo_(x, y, z);
	}

	@Override
	public void setBossVisibleTo(EntityPlayerMP entityPlayerMP) {
		if (master != null) master.addTrackingPlayer(entityPlayerMP);
		else super.setBossVisibleTo(entityPlayerMP);
	}

	@Override
	public void superAddTrackingPlayer(Object entityPlayerMP) {
		super.setBossVisibleTo((EntityPlayerMP) entityPlayerMP);
	}

	@Override
	public void setBossNonVisibleTo(EntityPlayerMP entityPlayerMP) {
		if (master != null) master.removeTrackingPlayer(entityPlayerMP);
		else super.setBossNonVisibleTo(entityPlayerMP);
	}

	@Override
	public void superRemoveTrackingPlayer(Object entityPlayerMP) {
		super.setBossNonVisibleTo((EntityPlayerMP) entityPlayerMP);
	}

	@Override
	public boolean func_184213_bq() {
		return master != null ? master.ignoreItemEntityData() : super.func_184213_bq();
	}

	@Override
	public boolean superIgnoreItemEntityData() {
		return super.func_184213_bq();
	}

	@Override
	public void superSetPathToEntity(Object pathEntity) {
		getNavigator().setPath((PathEntity) pathEntity, getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
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
	public boolean processInteract(EntityPlayer entityPlayer, EnumHand enumHand, ItemStack itemStack) {
		return master != null ? master.processInteract(entityPlayer, enumHand, itemStack) : super.processInteract(entityPlayer, enumHand, itemStack);
	}

	@Override
	public boolean superProcessInteract(Object entityPlayer, Object enumHand, Object itemStack) {
		return super.processInteract((EntityPlayer) entityPlayer, (EnumHand) enumHand, (ItemStack) itemStack);
	}

	@Override
	public void moveEntity(double par1, double par3, double par5) {
		if (master != null) master.move(null, par1, par3, par5);
		else super.moveEntity(par1, par3, par5);
	}

	@Override
	public void superMove(Object moverType, double par1, double par3, double par5) {
		super.moveEntity(par1, par3, par5);
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
	public void setAngles(float par1, float par2) {
		if (master != null) master.turn(par1, par2);
		else super.setAngles(par1, par2);
	}

	@Override
	public void superTurn(float par1, float par2) {
		super.setAngles(par1, par2);
	}

	@Override
	protected PathNavigate getNewNavigator(World world) {
		return (PathNavigate) (master != null ? master.createNavigator(world) : super.getNewNavigator(world));
	}

	@Override
	public PathNavigate superCreateNavigator(Object world) {
		return super.getNewNavigator((World) world);
	}

	@Override
	public void addChatMessage(ITextComponent iTextComponent) {
		if (master != null) master.sendMessage(iTextComponent);
		else super.addChatMessage(iTextComponent);
	}

	@Override
	public void superSendMessage(Object iTextComponent) {
		super.addChatMessage((ITextComponent) iTextComponent);
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

}
