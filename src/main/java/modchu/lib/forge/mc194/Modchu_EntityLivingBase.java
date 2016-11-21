package modchu.lib.forge.mc194;

import java.util.HashMap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityLivingBase;
import modchu.lib.Modchu_Main;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Modchu_EntityLivingBase extends modchu.lib.forge.mc190_210.Modchu_EntityLivingBase implements Modchu_IEntityLivingBase {

	public Modchu_EntityLivingBase(World world) {
		super(world);
	}

	public Modchu_EntityLivingBase(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void entityDataManagerRegister(Class c, Class[] c1, int i, Object o) {
		DataParameter dataParameter = (DataParameter) Modchu_AS.get(Modchu_AS.newDataParameter, getClass(), c1, i);
		if (dataParameter != null) {
			dataManager.register(dataParameter, o);
			String key= c.getName() + i;
			dataParameterMap.put(key, dataParameter);
		} else {
			String ss = "Modchu_EntityLivingBase entityDataManagerRegister dataParameter == null error !! c="+c+" c1="+c1+" i="+i+" o="+o;
			Modchu_Debug.mDebug(ss);
			Modchu_Main.setRuntimeException(ss);
		}
	}

	@Override
	public Object getDataWatcherGetWatchableObject(int i) {
		String key= master.getClass().getName() + i;
		DataParameter dataParameter = dataParameterMap.get(key);
		return dataManager.get(dataParameter);
	}

	@Override
	public void setDataWatcherGetWatchableObject(int i, Object o) {
		String key= master.getClass().getName() + i;
		DataParameter dataParameter = dataParameterMap.get(key);
		dataManager.set(dataParameter, o);
	}

	@Override
	protected void handleJumpWater() {
		if (master != null) master.handleJumpWater();
		else super.handleJumpWater();
	}

	@Override
	public void superHandleJumpWater() {
		super.handleJumpWater();
	}

	@Override
	public void moveRelative(float par1, float par2, float par3) {
		if (master != null) master.moveRelative(par1, par2, par3);
		else super.moveRelative(par1, par2, par3);
	}

	@Override
	public void superMoveRelative(float par1, float par2, float par3) {
		super.moveRelative(par1, par2, par3);
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
	public boolean attemptTeleport(double x, double y, double z) {
		return master != null ? master.attemptTeleport(x, y, z) : super.attemptTeleport(x, y, z);
	}

	@Override
	public boolean superAttemptTeleport(double x, double y, double z) {
		return super.attemptTeleport(x, y, z);
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
	public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean p_180426_10_) {
		if (master != null) master.setPositionAndRotationDirect(x, y, z, yaw, pitch, posRotationIncrements, p_180426_10_);
		else super.setPositionAndRotationDirect(x, y, z, yaw, pitch, posRotationIncrements, p_180426_10_);
	}

	@Override
	public void superSetPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean p_180426_10_) {
		super.setPositionAndRotationDirect(x, y, z, yaw, pitch, posRotationIncrements, p_180426_10_);
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
	public void moveEntity(double par1, double par3, double par5) {
		if (master != null) master.moveEntity(null, par1, par3, par5);
		else super.moveEntity(par1, par3, par5);
	}

	@Override
	public void superMoveEntity(Object moverType, double par1, double par3, double par5) {
		super.moveEntity(par1, par3, par5);
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
	public Object superApplyPlayerInteraction(Object entityPlayer, Object vec3d, Object itemStack, Object enumHand) {
		return super.applyPlayerInteraction((EntityPlayer) entityPlayer, (Vec3d) vec3d, (ItemStack) itemStack, (EnumHand) enumHand);
	}

}