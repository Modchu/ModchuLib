package modchu.lib;

public interface Modchu_IEntityAIHurtByTargetMaster extends Modchu_IEntityAIBaseMaster {
	public double getTargetDistance();
	public boolean isSuitableTarget(Object entityLivingBase, boolean par2);

}
