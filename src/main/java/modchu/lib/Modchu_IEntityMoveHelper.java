package modchu.lib;

public interface Modchu_IEntityMoveHelper {
	public boolean superIsUpdating();
	public double superGetSpeed();
	public void superSetMoveTo(double x, double y, double z, double speedIn);
	public void superStrafe(float forward, float strafe);
	public void superRead(Object entityMoveHelper);
	public void superOnUpdateMoveHelper();
	public float superLimitAngle(float sourceAngle, float targetAngle, float maximumChange);
	public double superGetX();
	public double superGetY();
	public double superGetZ();

}
