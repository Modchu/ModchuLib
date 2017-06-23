package modchu.lib;

public interface Modchu_IEntityAIBaseMaster {
	public boolean shouldExecute();
	public boolean shouldContinueExecuting();
	public boolean isInterruptible();
	public void startExecuting();
	public void resetTask();
	public void updateTask();
	public void setMutexBits(int par1);
	public int getMutexBits();

}
