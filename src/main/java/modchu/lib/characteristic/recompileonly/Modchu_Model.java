package modchu.lib.characteristic.recompileonly;

import java.util.Random;

import modchu.lib.Modchu_IModelBase;
import modchu.lib.Modchu_Reflect;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.TextureOffset;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class Modchu_Model extends ModelBase {
	public Modchu_IModelBase master;

	public Modchu_Model(Class masterClass) {
		Object instance = (Modchu_IModelBase) Modchu_Reflect.newInstance(masterClass, new Class[]{ Modchu_Model.class, Object[].class }, new Object[]{ this, (Object[]) null });
		//Modchu_Debug.mDebug("Modchu_ModelBase instance="+instance);
		master = instance instanceof Modchu_IModelBase ? (Modchu_IModelBase) instance : null;
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
	protected void setTextureOffset(String s, int i, int j) {
		master.setTextureOffset(s, i, j);
	}

	@Override
	public TextureOffset getTextureOffset(String s) {
		return (TextureOffset) master.getTextureOffset(s);
	}

	public ModelRenderer getRightArm() {
		return (ModelRenderer) master.getRightArm();
	}

	public ModelRenderer superGetRandomModelBox(Random random) {
		return super.getRandomModelBox(random);
	}

	public TextureOffset superGetTextureOffset(String par1Str) {
		return super.getTextureOffset(par1Str);
	}

	public void superSetTextureOffset(String par1Str, int par2, int par3) {
		super.setTextureOffset(par1Str, par2, par3);
	}

}
