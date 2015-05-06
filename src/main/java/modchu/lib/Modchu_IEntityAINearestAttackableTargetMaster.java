package modchu.lib;

public interface Modchu_IEntityAINearestAttackableTargetMaster extends Modchu_IEntityAIBaseMaster {
	public double getTargetDistance();
	public boolean isSuitableTarget(Object entityLivingBase, boolean par2);

}
