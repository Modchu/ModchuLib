package modchu.lib.forge.mc202;

import java.util.HashMap;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityTameable;
import modchu.lib.Modchu_Main;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.pathfinding.Path;
import net.minecraft.world.World;

public class Modchu_EntityTameable extends modchu.lib.forge.mc190_202.Modchu_EntityTameable implements Modchu_IEntityTameable {

	public Modchu_EntityTameable(World world) {
		super(world);
	}

	public Modchu_EntityTameable(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public void entityDataManagerRegister(Class c, Class[] c1, int i, Object o) {
		//Modchu_Debug.mDebug("Modchu_EntityTameable entityDataManagerRegister 1 c="+c+" c1="+c1+" i="+i+" o="+o);
		DataParameter dataParameter = (DataParameter) Modchu_AS.get(Modchu_AS.newDataParameter, getClass(), c1, i);
		//Modchu_Debug.mDebug("Modchu_EntityTameable entityDataManagerRegister 2 dataParameter="+dataParameter);
		if (dataParameter != null) {
			dataManager.register(dataParameter, o);
			String key= c.getName() + i;
			dataParameterMap.put(key, dataParameter);
			//Modchu_Debug.mDebug("Modchu_EntityTameable entityDataManagerRegister register ok. key="+key);
		} else {
			String ss = "Modchu_EntityTameable entityDataManagerRegister dataParameter == null error !! c="+c+" c1="+c1+" i="+i+" o="+o;
			Modchu_Debug.mDebug(ss);
			Modchu_Main.setRuntimeException(ss);
		}
	}

	@Override
	public Object getDataWatcherGetWatchableObject(int i) {
		String key= master.getClass().getName() + i;
		DataParameter dataParameter = dataParameterMap.get(key);
		//Modchu_Debug.mDebug("Modchu_EntityTameable getDataWatcherGetWatchableObject key="+key);
		return dataManager.get(dataParameter);
	}

	@Override
	public void setDataWatcherGetWatchableObject(int i, Object o) {
		String key= master.getClass().getName() + i;
		DataParameter dataParameter = dataParameterMap.get(key);
		//Modchu_Debug.mDebug("Modchu_EntityTameable setDataWatcherGetWatchableObject key="+key);
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
