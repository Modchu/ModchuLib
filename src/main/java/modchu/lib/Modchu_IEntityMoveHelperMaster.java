package modchu.lib;

public interface Modchu_IEntityMoveHelperMaster {
	public boolean isUpdating();
	public double getSpeed();
	public void setMoveTo(double x, double y, double z, double speedIn);
	public void strafe(float forward, float strafe);
	public void read(Object entityMoveHelper);
	public void onUpdateMoveHelper();
	public float limitAngle(float sourceAngle, float targetAngle, float maximumChange);
	public double getX();
	public double getY();
	public double getZ();

}
