package modchu.lib.forge.mc180_220;

import java.util.HashMap;
import java.util.Random;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IEntityCapsBase;
import modchu.lib.Modchu_IModelBiped;
import modchu.lib.Modchu_IModelBipedMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.TextureOffset;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class Modchu_ModelBiped extends ModelBiped implements Modchu_IModelBiped {
	public Modchu_IModelBipedMaster master;

	public Modchu_ModelBiped(HashMap<String, Object> map) {
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		Modchu_Debug.mDebug("Modchu_ModelBiped instance="+instance);
		master = instance instanceof Modchu_IModelBipedMaster ? (Modchu_IModelBipedMaster) instance : null;
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

	public void renderEars(float par1) {
		if (master != null) master.renderEars(par1);
	}

	public void superRenderEars(float par1) {
	}

	public void renderCloak(float par1) {
		if (master != null) master.renderCloak(par1);
	}

	public void superRenderCloak(float par1) {
	}

	@Override
	public Object superGetRightArm(Modchu_IEntityCapsBase modchu_IEntityCapsBase) {
		return bipedRightArm;
	}

	@Override
	public void superSetModelAttributes(Object modelBase) {
		super.setModelAttributes((ModelBase) modelBase);
	}

}
