package modchu.lib.characteristic;

import modchu.lib.Modchu_IModelCapsLink;
import modchu.model.ModchuModel_Client;
import modchu.model.ModchuModel_IEntityCaps;
import modchu.model.ModchuModel_ModelDataBase;
import modchu.model.ModchuModel_ModelDataMaster;
import modchu.model.multimodel.base.MultiModelBaseBiped;
import net.minecraft.client.model.TextureOffset;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

import org.lwjgl.opengl.GL11;

/**
 * アーマーの二重描画用クラス。
 * 必ずInner側にはモデルを設定すること。
 * 通常のRendererで描画するためのクラスなので、Renderをちゃんと記述するならいらないクラスです。
 */
public class Modchu_ModelBaseDuoBase extends Modchu_ModelBaseNihilBase implements Modchu_IModelCapsLink {

	public MultiModelBaseBiped modelOuter;
	public MultiModelBaseBiped modelInner;
	/**
	 * 部位毎のアーマーテクスチャの指定。
	 * 外側。
	 */
	public Object[] textureOuter;
	/**
	 * 部位毎のアーマーテクスチャの指定。
	 * 内側。
	 */
	public Object[] textureInner;
	/**
	 * 部位毎のアーマーテクスチャの指定。
	 * 外側・発光。
	 */
	public Object[] textureOuterLight;
	/**
	 * 部位毎のアーマーテクスチャの指定。
	 * 内側・発光。
	 */
	public Object[] textureInnerLight;
	/**
	 * 描画されるアーマーの部位。
	 * shouldRenderPassとかで指定する。
	 */
	public int renderParts;

	public float[] textureLightColor;

	public Modchu_ModelBaseDuoBase(Object render) {
		renderParts = 0;
	}

	@Override
	public void setLivingAnimations(EntityLivingBase entityLivingBase, float par2, float par3, float par4) {
		ModchuModel_IEntityCaps entityCaps = getModchuModel_IEntityCaps(entityLivingBase);
		if (modelInner != null) {
			modelInner.setLivingAnimations(entityCaps, par2, par3, par4);
		}
		if (modelOuter != null) {
			modelOuter.setLivingAnimations(entityCaps, par2, par3, par4);
		}
		isAlphablend = true;
	}

	@Override
	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		ModchuModel_IEntityCaps entityCaps = getModchuModel_IEntityCaps(entity);
		boolean lri = (renderCount & 0x0f) == 0;
		if (modelInner != null) {
			if (textureInner != null && lri) {
				if (textureInner[renderParts] != null) {
					// 通常パーツ
					ModchuModel_Client.setTexture((String) textureInner[renderParts]);
					modelInner.render(entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
				}
			} else {
				// ほぼエンチャントエフェクト用
				modelInner.render(entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
			}
			if (textureInnerLight != null && renderCount == 0) {
				// 発光テクスチャ表示処理
				if (textureInnerLight[renderParts] != null) {
					ModchuModel_Client.setTexture((String) textureInnerLight[renderParts]);
					GL11.glEnable(GL11.GL_BLEND);
					GL11.glEnable(GL11.GL_ALPHA_TEST);
					GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
					GL11.glDepthFunc(GL11.GL_LEQUAL);

					ModchuModel_Client.setLightmapTextureCoords(0x00f000f0);//61680
					if (textureLightColor == null) {
						GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
					} else {
						//発光色を調整
						GL11.glColor4f(
								textureLightColor[0],
								textureLightColor[1],
								textureLightColor[2],
								textureLightColor[3]);
					}
					modelInner.render(entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
					ModchuModel_Client.setLightmapTextureCoords(lighting);
					GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
					GL11.glDisable(GL11.GL_BLEND);
					GL11.glEnable(GL11.GL_ALPHA_TEST);
				}
			}
		}
		if (modelOuter != null) {
			if (textureOuter != null && lri) {
				// 通常パーツ
				if (textureOuter[renderParts] != null) {
					ModchuModel_Client.setTexture((String) textureOuter[renderParts]);
					modelOuter.render(entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
				}
			} else {
				// ほぼエンチャントエフェクト用
				modelOuter.render(entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
			}
			if (textureOuterLight != null && renderCount == 0) {
				// 発光テクスチャ表示処理
				if (textureOuterLight[renderParts] != null) {
					ModchuModel_Client.setTexture((String) textureOuterLight[renderParts]);
					float var4 = 1.0F;
					GL11.glEnable(GL11.GL_BLEND);
					GL11.glEnable(GL11.GL_ALPHA_TEST);
					GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
					GL11.glDepthFunc(GL11.GL_LEQUAL);

					ModchuModel_Client.setLightmapTextureCoords(0x00f000f0);//61680
					if (textureLightColor == null) {
						GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
					} else {
						//発光色を調整
						GL11.glColor4f(
								textureLightColor[0],
								textureLightColor[1],
								textureLightColor[2],
								textureLightColor[3]);
					}
					modelOuter.render(entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
					ModchuModel_Client.setLightmapTextureCoords(lighting);
					GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
					GL11.glDisable(GL11.GL_BLEND);
					GL11.glEnable(GL11.GL_ALPHA_TEST);
				}
			}
		}
//		isAlphablend = false;
		renderCount++;
	}

	@Override
	public TextureOffset getTextureOffset(String par1Str) {
		return null;
	}

	@Override
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity entity) {
		ModchuModel_IEntityCaps entityCaps = getModchuModel_IEntityCaps(entity);
		if (modelInner != null) {
			modelInner.setRotationAngles(par1, par2, par3, par4, par5, par6, entityCaps);
		}
		if (modelOuter != null) {
			modelOuter.setRotationAngles(par1, par2, par3, par4, par5, par6, entityCaps);
		}
	}


	// IModelModchuModel追加分

	@Override
	public void renderItems(Object entity, Object render) {
		if (modelInner != null) {
			ModchuModel_IEntityCaps entityCaps = getModchuModel_IEntityCaps(entity);
			modelInner.renderItems(entityCaps);
		}
	}

	@Override
	public void showArmorParts(int pParts) {
		if (modelInner != null) {
			modelInner.showArmorParts(tempEntityCaps, pParts, 0);
		}
		if (modelOuter != null) {
			modelOuter.showArmorParts(tempEntityCaps, pParts, 1);
		}
	}

	@Override
	public void setEntityCaps(Modchu_IEntityCapsBase entityCaps) {
		tempEntityCaps = entityCaps;
	}

	@Override
	public void setArmorRendering(boolean pFlag) {
		isRendering = pFlag;
	}

	@Override
	public Object getCapsValue(int pIndex, Object ... pArg) {
		return getCapsValue(tempEntityCaps, pIndex, pArg);
	}

	@Override
	public boolean setCapsValue(int pIndex, Object... pArg) {
		return setCapsValue(tempEntityCaps, pIndex, pArg);
	}

	@Override
	public void showAllParts(Modchu_IEntityCapsBase entityCaps) {
		if (modelInner != null) {
			modelInner.showAllParts(entityCaps);
		}
		if (modelOuter != null) {
			modelOuter.showAllParts(entityCaps);
		}
	}

	@Override
	public Object getCapsValue(Modchu_IEntityCapsBase entityCaps, int pIndex, Object... pArg) {
		return modelInner == null ? null : modelInner.getCapsValue(entityCaps, pIndex, pArg);
	}

	@Override
	public boolean setCapsValue(Modchu_IEntityCapsBase entityCaps, int pIndex, Object... pArg) {
		if (modelOuter != null) {
			modelOuter.setCapsValue(entityCaps, pIndex, pArg);
		}
		if (modelInner != null) {
			return modelInner.setCapsValue(entityCaps, pIndex, pArg);
		}
		return false;
	}

	public ModchuModel_IEntityCaps getModchuModel_IEntityCaps(Object entityLivingBase) {
		return (ModchuModel_IEntityCaps) getModchu_IEntityCapsBase(entityLivingBase);
	}

}
