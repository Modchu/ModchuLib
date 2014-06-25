package modchu.lib.replace;

import modchu.lib.characteristic.recompileonly.Modchu_TexturedQuad;
import modchu.lib.replacepoint.Modchu_ModelBoxReplacePoint;
import modchu.lib.replacepoint.Modchu_ModelRendererReplacePoint;
import net.minecraft.client.model.PositionTextureVertex;

public class Modchu_ModelBoxBase extends Modchu_ModelBoxReplacePoint {

	/**
	 * @param pMRenderer
	 * @param pArg
	 * textureX, textureY, posX, posY, posZ, width, height, depth, sizeAdjust
	 */
	public Modchu_ModelBoxBase(Modchu_ModelRendererReplacePoint pMRenderer, Object... pArg) {
		this(pMRenderer, pArg, false);
	}

	public Modchu_ModelBoxBase(Modchu_ModelRendererReplacePoint pMRenderer, Object[] pArg, boolean b) {
		super(pMRenderer, pArg);
		init(pMRenderer, (Integer)pArg[0], (Integer)pArg[1],
				(Float)pArg[2], (Float)pArg[3], (Float)pArg[4],
				(Integer)pArg[5], (Integer)pArg[6], (Integer)pArg[7],
				pArg.length < 9 ? 0.0F : (Float)pArg[8], b);
	}

	private void init(Modchu_ModelRendererReplacePoint pMRenderer, int pTexX, int pTexY,
			float pX, float pY, float pZ,
			int pW, int pH, int pD, float pSize, boolean b) {
		posX1 = pX;
		posY1 = pY;
		posZ1 = pZ;
		posX2 = pX + (float)pW;
		posY2 = pY + (float)pH;
		posZ2 = pZ + (float)pD;
		vertexPositions = new PositionTextureVertex[8];
		quadList = new Modchu_TexturedQuad[6];
		float lx = pX + (float)pW;
		float ly = pY + (float)pH;
		float lz = pZ + (float)pD;
		pX -= pSize;
		pY -= pSize;
		pZ -= pSize;
		lx += pSize;
		ly += pSize;
		lz += pSize;

		if (pMRenderer.mirror) {
			float var14 = lx;
			lx = pX;
			pX = var14;
		}

		PositionTextureVertex lxyz = new PositionTextureVertex(pX, pY, pZ, 0.0F, 0.0F);
		PositionTextureVertex lwyz = new PositionTextureVertex(lx, pY, pZ, 0.0F, 8.0F);
		PositionTextureVertex lwhz = new PositionTextureVertex(lx, ly, pZ, 8.0F, 8.0F);
		PositionTextureVertex lxhz = new PositionTextureVertex(pX, ly, pZ, 8.0F, 0.0F);
		PositionTextureVertex lxyd = new PositionTextureVertex(pX, pY, lz, 0.0F, 0.0F);
		PositionTextureVertex lwyd = new PositionTextureVertex(lx, pY, lz, 0.0F, 8.0F);
		PositionTextureVertex lwhd = new PositionTextureVertex(lx, ly, lz, 8.0F, 8.0F);
		PositionTextureVertex lxhd = new PositionTextureVertex(pX, ly, lz, 8.0F, 0.0F);
		vertexPositions[0] = lxyz;
		vertexPositions[1] = lwyz;
		vertexPositions[2] = lwhz;
		vertexPositions[3] = lxhz;
		vertexPositions[4] = lxyd;
		vertexPositions[5] = lwyd;
		vertexPositions[6] = lwhd;
		vertexPositions[7] = lxhd;
		quadList[0] = new Modchu_TexturedQuad(new PositionTextureVertex[] {lwyd, lwyz, lwhz, lwhd}, pTexX + pD + pW, pTexY + pD, pTexX + pD + pW + pD, pTexY + pD + pH, pMRenderer.textureWidth, pMRenderer.textureHeight);
		quadList[1] = new Modchu_TexturedQuad(new PositionTextureVertex[] {lxyz, lxyd, lxhd, lxhz}, pTexX, pTexY + pD, pTexX + pD, pTexY + pD + pH, pMRenderer.textureWidth, pMRenderer.textureHeight);
		quadList[2] = new Modchu_TexturedQuad(new PositionTextureVertex[] {lwyd, lxyd, lxyz, lwyz}, pTexX + pD, pTexY, pTexX + pD + pW, pTexY + pD, pMRenderer.textureWidth, pMRenderer.textureHeight);
		quadList[3] = new Modchu_TexturedQuad(new PositionTextureVertex[] {lwhz, lxhz, lxhd, lwhd}, pTexX + pD + pW, pTexY + pD, pTexX + pD + pW + pW, pTexY, pMRenderer.textureWidth, pMRenderer.textureHeight);
		quadList[4] = new Modchu_TexturedQuad(new PositionTextureVertex[] {lwyz, lxyz, lxhz, lwhz}, pTexX + pD, pTexY + pD, pTexX + pD + pW, pTexY + pD + pH, pMRenderer.textureWidth, pMRenderer.textureHeight);
		quadList[5] = new Modchu_TexturedQuad(new PositionTextureVertex[] {lxyd, lwyd, lwhd, lxhd}, pTexX + pD + pW + pD, pTexY + pD, pTexX + pD + pW + pD + pW, pTexY + pD + pH, pMRenderer.textureWidth, pMRenderer.textureHeight);

		if (pMRenderer.mirror) {
			for (int li = 0; li < this.quadList.length; ++li) {
				quadList[li].flipFace();
			}
		}
		if (b) {
			for (int li = 0; li < this.quadList.length; ++li) {
				((Modchu_TexturedQuad)quadList[li]).setInvertNormal(b);
			}
		}
	}

}
