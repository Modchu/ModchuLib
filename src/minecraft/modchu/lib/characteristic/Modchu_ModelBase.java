package modchu.lib.characteristic;

import java.util.Random;

import modchu.lib.Modchu_IModelBaseMaster;
import modchu.lib.Modchu_Reflect;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLivingBase;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;
import net.minecraft.src.TextureOffset;

public class Modchu_ModelBase extends ModelBase {
	public Modchu_IModelBaseMaster master;

	public Modchu_ModelBase(Class masterClass) {
		Object instance = masterClass != null ? Modchu_Reflect.newInstance(masterClass, new Class[]{ Modchu_ModelBase.class, Object[].class }, new Object[]{ this, (Object[]) null }) : null;
		//Modchu_Debug.mDebug("Modchu_ModelBase instance="+instance);
		master = instance instanceof Modchu_IModelBaseMaster ? (Modchu_IModelBaseMaster) instance : null;
	}

	@Override
	public void setLivingAnimations(EntityLivingBase entityliving, float f, float f1, float f2) {
		master.setLivingAnimations(entityliving, f, f1, f2);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		master.render(entity, f, f1, f2, f3, f4, f5);
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		master.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

	@Override
	public ModelRenderer getRandomModelBox(Random random) {
		return (ModelRenderer) master.getRandomModelBox(random);
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

	public void superSetModelAttributes(Object modelBase) {
	}

}
