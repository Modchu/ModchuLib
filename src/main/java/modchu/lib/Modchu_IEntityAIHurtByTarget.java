package modchu.lib;

public interface Modchu_IEntityAIHurtByTarget extends Modchu_IEntityAIBase {
	public double superGetTargetDistance();
	public boolean superIsSuitableTarget(Object entityLivingBase, boolean par2);

}
