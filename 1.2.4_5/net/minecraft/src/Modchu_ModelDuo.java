package net.minecraft.src;

import java.util.Map;
import java.util.Random;

import org.lwjgl.opengl.GL11;

/**
 * アーマーの二重描画用クラス。
 */
public class Modchu_ModelDuo extends ModelBase implements Modchu_IModelCaps {

	public RenderLiving renderLiving;
	public ModelBiped modelArmorOuter;
	public ModelBiped modelArmorInner;
	/**
	 * 部位毎のアーマーテクスチャの指定。
	 * 外側。
	 */
	public String[] textureOuter;
	/**
	 * 部位毎のアーマーテクスチャの指定。
	 * 内側。
	 */
	public String[] textureInner;
	/**
	 * 描画されるアーマーの部位。
	 * shouldRenderPassとかで指定する。
	 */
	public int renderParts;
	public boolean isAlphablend;
	public boolean isModelAlphablend;
	public Modchu_ModelDuo capsLink;


	public Modchu_ModelDuo(RenderLiving pRender) {
		renderLiving = pRender;
		renderParts = 0;
	}

	@Override
	public void setLivingAnimations(EntityLiving par1EntityLiving, float par2, float par3, float par4) {
		if (modelArmorOuter != null) {
			modelArmorOuter.setLivingAnimations(par1EntityLiving, par2, par3, par4);
		}
		if (modelArmorInner != null) {
			modelArmorInner.setLivingAnimations(par1EntityLiving, par2, par3, par4);
		}
		isAlphablend = true;
	}

	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		if (isAlphablend) {
			if (isModelAlphablend) {
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			} else {
				GL11.glDisable(GL11.GL_BLEND);
			}
		}
		// このへんは出来ればスッキリさせたい、処理速度的な意味で。
		// 可能な限りテクスチャ設定時におかしな値が入らないようにする。
		while (modelArmorOuter != null) {
			if (textureOuter != null) {
				if (textureOuter[renderParts] == null) {
					break;
				}
				renderLiving.loadTexture(textureOuter[renderParts]);
			}
			modelArmorOuter.render(par1Entity, par2, par3, par4, par5, par6, par7);
			break;
		}
		while (modelArmorInner != null) {
			if (textureInner != null) {
				if (textureInner[renderParts] == null) {
					break;
				}
				renderLiving.loadTexture(textureInner[renderParts]);
			}
			modelArmorInner.render(par1Entity, par2, par3, par4, par5, par6, par7);
			break;
		}
		isAlphablend = false;
	}

	public void renderItems(EntityLiving pEntity, Render pRender) {
		if (modelArmorInner != null) {
			((MultiModelBaseBiped) modelArmorInner).renderItems(pEntity, pRender);
		}
	}

	public ModelRenderer func_85181_a(Random par1Random) {
		return (ModelRenderer)this.boxList.get(par1Random.nextInt(this.boxList.size()));
	}

	@Override
	public TextureOffset getTextureOffset(String par1Str) {
		return modelArmorInner.getTextureOffset(par1Str);
	}

	@Override
	public void setRotationAngles(float par1, float par2, float par3,
			float par4, float par5, float par6) {
		if (modelArmorOuter != null) {
			modelArmorOuter.setRotationAngles(par1, par2, par3, par4, par5, par6);
		}
		if (modelArmorInner != null) {
			modelArmorInner.setRotationAngles(par1, par2, par3, par4, par5, par6);
		}
	}

	public void showArmorParts(int pIndex) {
		if (modelArmorOuter != null) {
			((MultiModelBaseBiped) modelArmorOuter).showArmorParts(pIndex);
		}
		if (modelArmorInner != null) {
			((MultiModelBaseBiped) modelArmorInner).showArmorParts(pIndex);
		}
	}

	/**
	 * Renderer辺でこの変数を設定する。
	 * 設定値はModchu_IModelCapsを継承したEntitiyとかを想定。
	 */
	public void setModelCaps(Modchu_IModelCaps pModelCaps) {
		if (modelArmorInner != null) {
			((MultiModelBaseBiped) modelArmorInner).setModelCaps(pModelCaps);
		}
		if (modelArmorOuter != null) {
			((MultiModelBaseBiped) modelArmorOuter).setModelCaps(pModelCaps);
		}
		if (capsLink != null) {
			capsLink.setModelCaps(pModelCaps);
		}
	}

	@Override
	public Map<String, Integer> getModelCaps() {
		return modelArmorInner == null ? null : ((Modchu_IModelCaps) modelArmorInner).getModelCaps();
	}

	@Override
	public Object getCapsValue(int pIndex, Object ... pArg) {
		return modelArmorInner == null ? null : ((Modchu_IModelCaps) modelArmorInner).getCapsValue(pIndex, pArg);
	}
	@Override
	public Object getCapsValue(String pCapsName, Object ... pArg) {
		return modelArmorInner == null ? null : ((Modchu_IModelCaps) modelArmorInner).getCapsValue(pCapsName, pArg);
	}
	@Override
	public int getCapsValueInt(int pIndex, Object ... pArg) {
		return modelArmorInner == null ? 0 : ((Modchu_IModelCaps) modelArmorInner).getCapsValueInt(pIndex, pArg);
	}
	@Override
	public float getCapsValueFloat(int pIndex, Object ... pArg) {
		return modelArmorInner == null ? 0F : ((Modchu_IModelCaps) modelArmorInner).getCapsValueFloat(pIndex, pArg);
	}
	@Override
	public double getCapsValueDouble(int pIndex, Object ... pArg) {
		return modelArmorInner == null ? 0D : ((Modchu_IModelCaps) modelArmorInner).getCapsValueDouble(pIndex, pArg);
	}
	@Override
	public boolean getCapsValueBoolean(int pIndex, Object ... pArg) {
		return modelArmorInner == null ? false : ((Modchu_IModelCaps) modelArmorInner).getCapsValueBoolean(pIndex, pArg);
	}

	@Override
	public boolean setCapsValue(int pIndex, Object... pArg) {
		if (capsLink != null) {
			capsLink.setCapsValue(pIndex, pArg);
		}
		if (modelArmorOuter != null) {
			((Modchu_IModelCaps) modelArmorOuter).setCapsValue(pIndex, pArg);
		}
		if (modelArmorInner != null) {
			return ((Modchu_IModelCaps) modelArmorInner).setCapsValue(pIndex, pArg);
		}
		return false;
	}
	@Override
	public boolean setCapsValue(String pCapsName, Object... pArg) {
		return setCapsValue(pCapsName, pArg);
	}

	public void setRender(Render pRender) {
		if (modelArmorInner != null) {
			((MultiModelBaseBiped) modelArmorInner).render = pRender;
		}
		if (modelArmorOuter != null) {
			((MultiModelBaseBiped) modelArmorOuter).render = pRender;
		}
	}

	public void setArmorRendering(boolean pFlag) {
		if (modelArmorInner != null) {
			((MultiModelBaseBiped) modelArmorInner).isRendering = pFlag;
		}
	}

}
