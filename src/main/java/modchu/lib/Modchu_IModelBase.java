package modchu.lib;

import java.util.Random;

public interface Modchu_IModelBase {
	public void superRender(Object entity, float par2, float par3, float par4, float par5, float par6, float par7);
	public void superSetRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Object entity);
	public void superSetLivingAnimations(Object entityLivingBase, float par2, float par3, float par4);
	public Object superGetRandomModelBox(Random random);
	public Object superGetRightArm(Modchu_IEntityCapsBase modchu_IEntityCapsBase);
	public void superSetModelAttributes(Object modelBase);

}
