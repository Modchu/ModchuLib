package modchu.lib.forge.mc220_221;

import java.util.HashMap;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;

public class Modchu_RenderLiving extends modchu.lib.forge.mc212_221.Modchu_RenderLiving {

	public Modchu_RenderLiving(HashMap<String, Object> map) {
		super(map);
	}

	public void setLightmap(EntityLiving entityLiving, float partialTicks) {
		if (master != null) master.setLightmap(entityLiving, partialTicks);
		else super.setLightmap(entityLiving);
	}

	@Override
	public void superFunc_96449_a(Object entityLivingBase, double par2, double par4, double par6, String par8Str, float par9, double par10) {
	}

	@Override
	public void superRotateCorpse(Object entityLivingBase, float par2, float par3, float par4) {
	}

	@Override
	public float superRenderSwingProgress(Object entityLivingBase, float par2) {
		return 0.0F;
	}

	@Override
	public boolean superFunc_110813_b(Object entityLivingBase) {
		return false;
	}

	@Override
	public void superFunc_110777_b(Object entity) {
		superBindEntityTexture(entity);
	}

	@Override
	public void setLightmap(EntityLiving entityLiving) {
		if (master != null) master.setLightmap(entityLiving);
		else super.setLightmap(entityLiving);
	}

	@Override
	public void superSetLightmap(Object entityLiving) {
		super.setLightmap((EntityLiving) entityLiving);
	}

	public boolean isVisible(EntityLivingBase entityLivingBase) {
		return master != null ? master.isVisible(entityLivingBase) : super.isVisible(entityLivingBase);
	}

	@Override
	public boolean superIsVisible(Object entityLivingBase) {
		return super.isVisible((EntityLivingBase) entityLivingBase);
	}

	public void applyRotations(EntityLivingBase entityLivingBase, float p_77043_2_, float rotationYaw, float partialTicks) {
		if (master != null) master.applyRotations(entityLivingBase, p_77043_2_, rotationYaw, partialTicks);
		else super.applyRotations(entityLivingBase, p_77043_2_, rotationYaw, partialTicks);
	}

	@Override
	public void superApplyRotations(Object entityLivingBase, float p_77043_2_, float rotationYaw, float partialTicks) {
		super.applyRotations((EntityLivingBase) entityLivingBase, p_77043_2_, rotationYaw, partialTicks);
	}

}
