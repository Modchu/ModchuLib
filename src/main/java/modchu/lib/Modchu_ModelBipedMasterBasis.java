package modchu.lib;

import java.util.HashMap;
import java.util.Random;

public class Modchu_ModelBipedMasterBasis implements Modchu_IModelBipedMaster {
	public Modchu_IModelBiped base;

	public Modchu_ModelBipedMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IModelBiped) map.get("base");
	}

	@Override
	public void render(Object entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		base.superRender(entity, par2, par3, par4, par5, par6, par7);
	}

	@Override
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Object entity) {
		base.superSetRotationAngles(par1, par2, par3, par4, par5, par6, entity);
	}

	@Override
	public void setLivingAnimations(Object entityLivingBase, float par2, float par3, float par4) {
		base.superSetLivingAnimations(entityLivingBase, par2, par3, par4);
	}

	@Override
	public Object getRandomModelBox(Random random) {
		return base.superGetRandomModelBox(random);
	}

	@Override
	public Object getRightArm(Modchu_IEntityCapsBase modchu_IEntityCapsBase) {
		return base.superGetRightArm(modchu_IEntityCapsBase);
	}

	@Override
	public void setModelAttributes(Object modelBase) {
		base.superSetModelAttributes(modelBase);
	}

	@Override
	public void renderEars(float par1) {
		base.superRenderEars(par1);
	}

	@Override
	public void renderCloak(float par1) {
		base.superRenderCloak(par1);
	}

}
