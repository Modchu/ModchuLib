package modchu.lib.forge.mc202_212;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityDataManager;
import modchu.lib.Modchu_Main;
import modchu.lib.forge.mc190_212.Modchu_EntityDataManager;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.EntityDataManager.DataEntry;
import net.minecraft.pathfinding.Path;
import net.minecraft.world.World;

public abstract class Modchu_EntityTameable extends modchu.lib.forge.mc190_212.Modchu_EntityTameable {

	public Modchu_EntityTameable(World world) {
		super(world);
	}

	public Modchu_EntityTameable(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void entityDataManagerRegister(Class[] c1, int i, Object o) {
		((Modchu_IEntityDataManager) dataManager).entityDataManagerRegister(c1, i, o);
	}

	@Override
	public Object getDataWatcherWatchableObject(int i) {
		Object o = ((Modchu_IEntityDataManager) dataManager).getDataWatcherWatchableObject(i);
		boolean debug = false;
		World worldObj = (World) Modchu_AS.get(Modchu_AS.entityWorldObj, this);
		if (debug
				&& initFlag
				&& worldObj.isRemote) {
			if (debugDataWatcherMap != null); else debugDataWatcherMap = debugDataWatcherEntityMap.get(getEntityId());
			if (debugDataWatcherMap != null) {
				Object o1 = debugDataWatcherMap.get(i);
				if (!o.equals(o1)) {
					Modchu_Debug.mDebug("getDataWatcherWatchableObject !o.equals(o1) error !! i="+i+" o="+o+" o1="+o1);
				}
			}
		}
		return o;
	}

	@Override
	public void setDataWatcherWatchableObject(int i, Object o) {
		((Modchu_IEntityDataManager) dataManager).setDataWatcherWatchableObject(i, o);
		World worldObj = (World) Modchu_AS.get(Modchu_AS.entityWorldObj, this);
		if (!worldObj.isRemote) debugDataWatcherMap.put(i, o);
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
	protected void onLeashDistance(float par1) {
		if (master != null) master.onLeashDistance(par1);
		else super.onLeashDistance(par1);
	}

	@Override
	public void superOnLeashDistance(float par1) {
		super.onLeashDistance(par1);
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
	public void ageUp(int p_175501_1_, boolean p_175501_2_) {
		if (master != null) master.ageUp(p_175501_1_, p_175501_2_);
		else super.ageUp(p_175501_1_, p_175501_2_);
	}

	@Override
	public void superAgeUp(int p_175501_1_, boolean p_175501_2_) {
		super.ageUp(p_175501_1_, p_175501_2_);
	}

	@Override
	protected boolean canEquipItem(ItemStack itemStack) {
		return master != null ? master.canEquipItem(itemStack) : super.canEquipItem(itemStack);
	}

	@Override
	public boolean superCanEquipItem(Object itemStack) {
		return super.canEquipItem((ItemStack) itemStack);
	}

	@Override
	public int getHorizontalFaceSpeed() {
		return master != null ? master.getHorizontalFaceSpeed() : super.getHorizontalFaceSpeed();
	}

	@Override
	public int superGetHorizontalFaceSpeed() {
		return super.getHorizontalFaceSpeed();
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
	public void superSetPathToEntity(Object pathEntity) {
		getNavigator().setPath((Path) pathEntity, getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
	}
	// 200~分離
	@Override
	public void superOnChunkLoad() {
	}

}
