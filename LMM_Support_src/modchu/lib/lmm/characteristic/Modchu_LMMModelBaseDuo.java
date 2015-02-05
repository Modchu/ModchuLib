package modchu.lib.lmm.characteristic;

import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IModelBaseDuo;
import modchu.lib.Modchu_IModelBaseDuoMaster;
import modchu.lib.Modchu_Reflect;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.src.MMM_ModelBaseDuo;

public class Modchu_LMMModelBaseDuo extends MMM_ModelBaseDuo implements Modchu_IModelBaseDuo {
	public Modchu_IModelBaseDuoMaster master;

	public Modchu_LMMModelBaseDuo(Class masterClass, Object pRender) {
		super((RendererLivingEntity) pRender);
		if (masterClass != null); else throw new RuntimeException("Modchu_LMMModelBaseDuo init masterClass null !!");
		Object instance = Modchu_Reflect.newInstance(masterClass, new Class[]{ Modchu_IModelBaseDuo.class, Object.class }, new Object[]{ this, pRender });
		//Modchu_Debug.mDebug("Modchu_LMMModelBaseDuo instance="+instance);
		master = instance instanceof Modchu_IModelBaseDuoMaster ? (Modchu_IModelBaseDuoMaster) instance : null;
		if (master != null); else throw new RuntimeException("Modchu_LMMModelBaseDuo init master null !! masterClass=" + masterClass);
	}

	@Override
	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		master.render(entity, par2, par3, par4, par5, par6, par7, entityCaps, isRendering);
	}

	@Override
	public void superRender(Object entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render((Entity) entity, par2, par3, par4, par5, par6, par7);
	}

	@Override
	public boolean getIsAlphablend() {
		return isAlphablend;
	}

	@Override
	public boolean getIsModelAlphablend() {
		return isModelAlphablend;
	}

	@Override
	public Object getModelInner() {
		return modelInner;
	}

	@Override
	public Object getModelOuter() {
		return modelOuter;
	}

	@Override
	public Object[] getTextureInner() {
		return textureInner;
	}

	@Override
	public Object[] getTextureOuter() {
		return textureOuter;
	}

	@Override
	public Object[] getTextureInnerLight() {
		return textureInnerLight;
	}

	@Override
	public Object[] getTextureOuterLight() {
		return textureOuterLight;
	}

	@Override
	public float[] getTextureLightColor() {
		return textureLightColor;
	}

	@Override
	public int getRenderParts() {
		return renderParts;
	}

	@Override
	public int getLighting() {
		return lighting;
	}

}
