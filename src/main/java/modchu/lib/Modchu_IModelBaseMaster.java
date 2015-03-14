package modchu.lib;

import java.util.Random;

public interface Modchu_IModelBaseMaster {
	public void render(Object entity, float par2, float par3, float par4, float par5, float par6, float par7);
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Object entity);
	public void setLivingAnimations(Object entityLivingBase, float par2, float par3, float par4);
	public Object getRandomModelBox(Random random);
	public Object getRightArm(Modchu_IEntityCapsBase entityCaps);
	public void setModelAttributes(Object modelBase);

}
