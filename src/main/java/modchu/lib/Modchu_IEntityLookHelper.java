package modchu.lib;

public interface Modchu_IEntityLookHelper {
	public void superSetLookPositionWithEntity(Object entity, float deltaYaw, float deltaPitch);
	public void superSetLookPosition(double x, double y, double z, float deltaYaw, float deltaPitch);
	public void superOnUpdateLook();
	public boolean superGetIsLooking();
	public double superGetLookPosX();
	public double superGetLookPosY();
	public double superGetLookPosZ();

}
