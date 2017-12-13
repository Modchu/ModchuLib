package modchu.lib;

public interface Modchu_IEntityLookHelperMaster {
	public void setLookPositionWithEntity(Object entity, float deltaYaw, float deltaPitch);
	public void setLookPosition(double x, double y, double z, float deltaYaw, float deltaPitch);
	public void onUpdateLook();
	public boolean getIsLooking();
	public double getLookPosX();
	public double getLookPosY();
	public double getLookPosZ();

}
