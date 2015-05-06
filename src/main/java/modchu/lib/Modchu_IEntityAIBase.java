package modchu.lib;

public interface Modchu_IEntityAIBase {
	public boolean superShouldExecute();
	public boolean superContinueExecuting();
	public boolean superIsInterruptible();
	public void superStartExecuting();
	public void superResetTask();
	public void superUpdateTask();
	public void superSetMutexBits(int par1);
	public int superGetMutexBits();

}
