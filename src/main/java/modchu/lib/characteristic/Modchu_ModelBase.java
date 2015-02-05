package modchu.lib.characteristic;

import java.util.Random;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IModelBaseMaster;
import modchu.lib.Modchu_Reflect;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.TextureOffset;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class Modchu_ModelBase extends ModelBase {
	public Modchu_IModelBaseMaster master;

	public Modchu_ModelBase(Class masterClass) {
		Object instance = masterClass != null ? Modchu_Reflect.newInstance(masterClass, new Class[]{ Modchu_ModelBase.class, Object[].class }, new Object[]{ this, (Object[]) null }) : null;
		//Modchu_Debug.mDebug("Modchu_ModelBase instance="+instance);
		master = instance instanceof Modchu_IModelBaseMaster ? (Modchu_IModelBaseMaster) instance : null;
	}

	@Override
	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		if (master != null) master.render(entity, par2, par3, par4, par5, par6, par7);
		else super.render(entity, par2, par3, par4, par5, par6, par7);
	}

	public void superRender(Object entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render((Entity) entity, par2, par3, par4, par5, par6, par7);
	}

	@Override
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity entity) {
		if (master != null) master.setRotationAngles(par1, par2, par3, par4, par5, par6, entity);
		else super.setRotationAngles(par1, par2, par3, par4, par5, par6, entity);
	}

	public void superSetRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Object entity) {
		super.setRotationAngles(par1, par2, par3, par4, par5, par6, (Entity) entity);
	}

	@Override
	public void setLivingAnimations(EntityLivingBase entityLivingBase, float par2, float par3, float par4) {
		if (master != null) master.setLivingAnimations(entityLivingBase, par2, par3, par4);
		else super.setLivingAnimations(entityLivingBase, par2, par3, par4);
	}

	public void superSetLivingAnimations(Object entityLivingBase, float par2, float par3, float par4) {
		super.setLivingAnimations((EntityLivingBase) entityLivingBase, par2, par3, par4);
	}

	@Override
	public ModelRenderer getRandomModelBox(Random random) {
		return (ModelRenderer) (master != null ? master.getRandomModelBox(random) : super.getRandomModelBox(random));
	}

	public ModelRenderer superGetRandomModelBox(Object random) {
		return super.getRandomModelBox((Random) random);
	}

	@Override
	protected void setTextureOffset(String par1Str, int par2, int par3) {
		//if (master != null) master.setTextureOffset(par1Str, par2, par3);
		super.setTextureOffset(par1Str, par2, par3);
	}

	public void superSetTextureOffset(String par1Str, int par2, int par3) {
		super.setTextureOffset(par1Str, par2, par3);
	}

	@Override
	public TextureOffset getTextureOffset(String par1Str) {
		//return (TextureOffset) (master != null ? master.getTextureOffset(par1Str) : super.getTextureOffset(par1Str));
		return super.getTextureOffset(par1Str);
	}

	public TextureOffset superGetTextureOffset(String par1Str) {
		return super.getTextureOffset(par1Str);
	}

	public ModelRenderer getRightArm(Modchu_IEntityCapsBase entityCaps) {
		return (ModelRenderer) master.getRightArm(entityCaps);
	}

	public ModelRenderer superGetRandomModelBox(Random random) {
		return super.getRandomModelBox(random);
	}

	public void setModelAttributes(ModelBase modelBase) {
		if (master != null) master.setModelAttributes(modelBase);
	}

	public void superSetModelAttributes(Object modelBase) {
	}

}
