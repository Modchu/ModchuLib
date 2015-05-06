package modchu.lib;

public interface Modchu_IEntityAINearestAttackableTarget extends Modchu_IEntityAIBase {
	public double superGetTargetDistance();
	public boolean superIsSuitableTarget(Object entityLivingBase, boolean par2);

}
