package modchu.lib.characteristic;

import modchu.lib.Modchu_ModelRendererBase;
import net.minecraft.src.PositionTextureVertex;
import net.minecraft.src.Tessellator;
import net.minecraft.src.TexturedQuad;

public class Modchu_ModelBoxBase {
	protected PositionTextureVertex[] vertexPositions;
	protected TexturedQuad[] quadList;
	public float posX1;
	public float posY1;
	public float posZ1;
	public float posX2;
	public float posY2;
	public float posZ2;
	public String boxName;

	/**
	 * �������K���������邱�ƁB
	 * @param pMRenderer
	 * @param pArg
	 */
	public Modchu_ModelBoxBase(Modchu_ModelRendererBase pMRenderer, Object ... pArg) {
		this(pMRenderer, pArg, false);
	}

	public Modchu_ModelBoxBase(Modchu_ModelRendererBase pMRenderer, Object[] pArg, boolean b) {
		init(pMRenderer, (Integer)pArg[0], (Integer)pArg[1],
				(Float)pArg[2], (Float)pArg[3], (Float)pArg[4],
				(Integer)pArg[5], (Integer)pArg[6], (Integer)pArg[7],
				pArg.length < 9 ? 0.0F : (Float)pArg[8], b);
	}

	private void init(Modchu_ModelRendererBase pMRenderer, int pTexX, int pTexY,
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

	public void render(Object tessellator, float par2) {
		for (int var3 = 0; var3 < quadList.length; ++var3) {
			quadList[var3].draw((Tessellator) tessellator, par2);
		}
	}

	public Modchu_ModelBoxBase setBoxName(String pName) {
		boxName = pName;
		return this;
	}

}
