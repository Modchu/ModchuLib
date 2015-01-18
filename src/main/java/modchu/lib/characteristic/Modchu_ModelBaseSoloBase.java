package modchu.lib.characteristic;

import modchu.lib.Modchu_IModelCapsLink;
import modchu.model.ModchuModel_Client;
import modchu.model.ModchuModel_IEntityCaps;
import modchu.model.multimodel.base.MultiModelBaseBiped;
import net.minecraft.client.model.TextureOffset;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class Modchu_ModelBaseSoloBase extends Modchu_ModelBaseNihilBase implements Modchu_IModelCapsLink {

	public MultiModelBaseBiped model;
	public ResourceLocation[] textures;

	public Modchu_ModelBaseSoloBase() {
	}

	@Override
	public void setLivingAnimations(EntityLivingBase entityLivingBase, float par2, float par3, float par4) {
		ModchuModel_IEntityCaps entityCaps = getModchuModel_IEntityCaps(entityLivingBase);
		if (model != null) {
			model.setLivingAnimations(entityCaps, par2, par3, par4);
		}
		isAlphablend = true;
	}

	@Override
	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		if (model == null) {
			isAlphablend = false;
			return;
		}
		ModchuModel_IEntityCaps entityCaps = getModchuModel_IEntityCaps(entity);
		if (isAlphablend) {
			if (isModelAlphablend) {
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			} else {
				GL11.glDisable(GL11.GL_BLEND);
			}
		}
		if (textures.length > 2 && textures[2] != null) {
			// Actors用
			model.setRotationAngles(par2, par3, par4, par5, par6, par7, entityCaps);
			// Face
			ModchuModel_Client.setTexture(textures[2]);
			model.setCapsValue(entityCaps, caps_renderFace, entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
			// Body
			ModchuModel_Client.setTexture(textures[0]);
			model.setCapsValue(entityCaps, caps_renderBody, entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
		} else {
			// 通常
			if (textures.length > 0 && textures[0] != null) {
				ModchuModel_Client.setTexture(textures[0]);
			}
			model.render(entityCaps, par2, par3, par4, par5, par6, par7, isRendering);
		}
		isAlphablend = false;
		if (textures.length > 1 && textures[1] != null && renderCount == 0) {
			// 発光パーツ
			ModchuModel_Client.setTexture(textures[1]);
			float var4 = 1.0F;
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glEnable(GL11.GL_ALPHA_TEST);
			GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
			GL11.glDepthFunc(GL11.GL_LEQUAL);

			ModchuModel_Client.setLightmapTextureCoords(0x00f000f0);//61680
			GL11.glColor4f(1.0F, 1.0F, 1.0F, var4);
			model.render(entityCaps, par2, par3, par4, par5, par6, par7, true);

			ModchuModel_Client.setLightmapTextureCoords(lighting);

//			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glEnable(GL11.GL_ALPHA_TEST);
			GL11.glDepthMask(true);
		}
		renderCount++;
	}

	@Override
	public TextureOffset getTextureOffset(String par1Str) {
		return null;
	}

	@Override
	public void setRotationAngles(float par1, float par2, float par3,
			float par4, float par5, float par6, Entity entity) {
		if (model != null) {
			ModchuModel_IEntityCaps entityCaps = getModchuModel_IEntityCaps(entity);
			model.setRotationAngles(par1, par2, par3, par4, par5, par6, entityCaps);
		}
	}


	// IModelModchuModel追加分

	@Override
	public void renderItems(Object entity, Object render) {
		if (model != null) {
			ModchuModel_IEntityCaps entityCaps = getModchuModel_IEntityCaps(entity);
			model.renderItems(entityCaps);
		}
	}

	@Override
	public void showArmorParts(int pParts) {
		if (model != null) {
			model.showArmorParts(tempEntityCaps, pParts, 0);
		}
	}

	/**
	 * Renderer辺でこの変数を設定する。
	 * 設定値はModchu_IModelCapsBaseを継承したEntitiyとかを想定。
	 */
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
	public void showAllParts() {
		if (model != null) {
			model.showAllParts(tempEntityCaps);
		}
	}

	public void showAllParts(Modchu_IEntityCapsBase entityCaps) {
		if (model != null) {
			model.showAllParts(entityCaps);
		}
	}

	@Override
	public Object getCapsValue(Modchu_IEntityCapsBase entityCaps, int pIndex, Object... pArg) {
		if (capsLink != null) {
			capsLink.getCapsValue(entityCaps, pIndex, pArg);
		}
		return model == null ? null : model.getCapsValue(entityCaps, pIndex, pArg);
	}

	@Override
	public boolean setCapsValue(Modchu_IEntityCapsBase entityCaps, int pIndex, Object... pArg) {
		if (capsLink != null) {
			capsLink.setCapsValue(entityCaps, pIndex, pArg);
		}
		if (model != null) {
			return model.setCapsValue(entityCaps, pIndex, pArg);
		}
		return false;
	}

	public ModchuModel_IEntityCaps getModchuModel_IEntityCaps(Object entityLivingBase) {
		return (ModchuModel_IEntityCaps) getModchu_IEntityCapsBase(entityLivingBase);
	}

}
