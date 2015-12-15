package modchu.lib;

import java.util.HashMap;

public class Modchu_ModelBoxMaster extends Modchu_ModelBoxMasterBasis {
	protected Object[] vertexPositions;
	protected Modchu_ITexturedQuad[] quadList;
	public float posX1;
	public float posY1;
	public float posZ1;
	public float posX2;
	public float posY2;
	public float posZ2;

	public Modchu_ModelBoxMaster(HashMap<String, Object> map) {
		super(map);
		if (map != null
				&& !map.isEmpty()); else return;
		init(map.get("Object"), (Integer)map.get("Integer"), (Integer)map.get("Integer1"),
				(Float)map.get("Float"), (Float)map.get("Float1"), (Float)map.get("Float2"),
				(Integer)map.get("Integer2"), (Integer)map.get("Integer3"), (Integer)map.get("Integer4"),
				(Float)map.get("Float3"), map.containsKey("boolean") ? (Boolean)map.get("boolean") : false);
	}

	private void init(Object renderer, int pTexX, int pTexY,
			float pX, float pY, float pZ,
			int pW, int pH, int pD, float pSize, boolean b) {
		//Modchu_Debug.mDebug("Modchu_ModelBoxMaster pTexX="+pTexX+" pTexY="+pTexY);
		//Modchu_Debug.mDebug("Modchu_ModelBoxMaster pX="+pX+" pY="+pY+" pZ="+pZ);
		//Modchu_Debug.mDebug("Modchu_ModelBoxMaster pW="+pW+" pH="+pH+" pD="+pD);
		//Modchu_Debug.mDebug("Modchu_ModelBoxMaster pSize="+pSize);
		//Modchu_Debug.mDebug("Modchu_ModelBoxMaster renderer="+renderer);
		//Modchu_Debug.mDebug("Modchu_ModelBoxMaster this="+this);
		//try {
		//Modchu_Debug.mDebug("Modchu_ModelBoxMaster test="+test);
		renderer = Modchu_Main.getModchuCharacteristicObjectMaster(renderer);
		posX1 = pX;
		posY1 = pY;
		posZ1 = pZ;
		posX2 = pX + pW;
		posY2 = pY + pH;
		posZ2 = pZ + pD;
		vertexPositions = Modchu_Reflect.newInstanceArray("PositionTextureVertex", 8);
		quadList = new Modchu_TexturedQuad[6];
		float lx = pX + pW;
		float ly = pY + pH;
		float lz = pZ + pD;
		pX -= pSize;
		pY -= pSize;
		pZ -= pSize;
		lx += pSize;
		ly += pSize;
		lz += pSize;
		boolean mirror = Modchu_CastHelper.Boolean(Modchu_Reflect.getFieldObject(renderer.getClass(), "mirror", renderer));
		//Modchu_Debug.mDebug("Modchu_ModelBoxMaster mirror="+mirror);
		if (mirror) {
			float var14 = lx;
			lx = pX;
			pX = var14;
			//Modchu_Debug.mDebug("Modchu_ModelBoxMaster mirror lx="+lx+" pX="+pX);
		}

		Object lxyz = newPositionTextureVertex(pX, pY, pZ, 0.0F, 0.0F);
		Object lwyz = newPositionTextureVertex(lx, pY, pZ, 0.0F, 8.0F);
		Object lwhz = newPositionTextureVertex(lx, ly, pZ, 8.0F, 8.0F);
		Object lxhz = newPositionTextureVertex(pX, ly, pZ, 8.0F, 0.0F);
		Object lxyd = newPositionTextureVertex(pX, pY, lz, 0.0F, 0.0F);
		Object lwyd = newPositionTextureVertex(lx, pY, lz, 0.0F, 8.0F);
		Object lwhd = newPositionTextureVertex(lx, ly, lz, 8.0F, 8.0F);
		Object lxhd = newPositionTextureVertex(pX, ly, lz, 8.0F, 0.0F);
		vertexPositions[0] = lxyz;
		vertexPositions[1] = lwyz;
		vertexPositions[2] = lwhz;
		vertexPositions[3] = lxhz;
		vertexPositions[4] = lxyd;
		vertexPositions[5] = lwyd;
		vertexPositions[6] = lwhd;
		vertexPositions[7] = lxhd;
		float textureWidth = Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject(renderer.getClass(), "textureWidth", renderer));
		float textureHeight = Modchu_CastHelper.Float(Modchu_Reflect.getFieldObject(renderer.getClass(), "textureHeight", renderer));
		//Modchu_Debug.mDebug("Modchu_ModelBoxMaster textureWidth="+textureWidth+" textureHeight="+textureHeight);
		Object[] o = Modchu_Reflect.newInstanceArray("PositionTextureVertex", 4);
		o[0] = lwyd;
		o[1] = lwyz;
		o[2] = lwhz;
		o[3] = lwhd;
		quadList[0] = newModchu_TexturedQuad(Modchu_TexturedQuadMaster.class, o, pTexX + pD + pW, pTexY + pD, pTexX + pD + pW + pD, pTexY + pD + pH, textureWidth, textureHeight);
		Object[] o1 = Modchu_Reflect.newInstanceArray("PositionTextureVertex", 4);
		o1[0] = lxyz;
		o1[1] = lxyd;
		o1[2] = lxhd;
		o1[3] = lxhz;
		quadList[1] = newModchu_TexturedQuad(Modchu_TexturedQuadMaster.class, o1, pTexX, pTexY + pD, pTexX + pD, pTexY + pD + pH, textureWidth, textureHeight);
		Object[] o2 = Modchu_Reflect.newInstanceArray("PositionTextureVertex", 4);
		o2[0] = lwyd;
		o2[1] = lxyd;
		o2[2] = lxyz;
		o2[3] = lwyz;
		quadList[2] = newModchu_TexturedQuad(Modchu_TexturedQuadMaster.class, o2, pTexX + pD, pTexY, pTexX + pD + pW, pTexY + pD, textureWidth, textureHeight);
		Object[] o3 = Modchu_Reflect.newInstanceArray("PositionTextureVertex", 4);
		o3[0] = lwhz;
		o3[1] = lxhz;
		o3[2] = lxhd;
		o3[3] = lwhd;
		quadList[3] = newModchu_TexturedQuad(Modchu_TexturedQuadMaster.class, o3, pTexX + pD + pW, pTexY + pD, pTexX + pD + pW + pW, pTexY, textureWidth, textureHeight);
		Object[] o4 = Modchu_Reflect.newInstanceArray("PositionTextureVertex", 4);
		o4[0] = lwyz;
		o4[1] = lxyz;
		o4[2] = lxhz;
		o4[3] = lwhz;
		quadList[4] = newModchu_TexturedQuad(Modchu_TexturedQuadMaster.class, o4, pTexX + pD, pTexY + pD, pTexX + pD + pW, pTexY + pD + pH, textureWidth, textureHeight);
		Object[] o5 = Modchu_Reflect.newInstanceArray("PositionTextureVertex", 4);
		o5[0] = lxyd;
		o5[1] = lwyd;
		o5[2] = lwhd;
		o5[3] = lxhd;
		quadList[5] = newModchu_TexturedQuad(Modchu_TexturedQuadMaster.class, o5, pTexX + pD + pW + pD, pTexY + pD, pTexX + pD + pW + pD + pW, pTexY + pD + pH, textureWidth, textureHeight);

		if (mirror) {
			for (int li = 0; li < quadList.length; ++li) {
				flipFace(quadList[li]);
			}
		}
		if (b) {
			for (int li = 0; li < quadList.length; ++li) {
				//Modchu_AS.set("TexturedQuad", "setInvertNormal", quadList[li], b);
				quadList[li].setInvertNormal(b);
			}
		}
/*
		} catch (Error e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
*/
	}

	@Override
	public void render(float par2) {
		//Modchu_Debug.mDebug("Modchu_ModelBoxBase render this.getClass()="+this.getClass());
		for (int var3 = 0; var3 < quadList.length; ++var3) {
			//boolean b =
			//Modchu_AS.set(Modchu_AS.texturedQuadDraw, quadList[var3], tessellator, par2);
			quadList[var3].draw(par2);
			//Modchu_Debug.mDebug("Modchu_ModelBoxBase render b="+b);
		}
		//Modchu_Debug.mDebug("Modchu_ModelBoxBase render end.");
	}

	@Override
	public Modchu_IModelBox setBoxName(String pName) {
		boxName = pName;
		return base;
	}

	protected void flipFace(Object texturedQuad) {
		//Modchu_AS.set("TexturedQuad", "flipFace", texturedQuad);
		((Modchu_ITexturedQuad) texturedQuad).flipFace();
	}

	protected Modchu_ITexturedQuad newModchu_TexturedQuad(Object... o) {
		return new Modchu_TexturedQuad(Modchu_Main.getNewModchuCharacteristicMap(o));
	}

	protected Object newPositionTextureVertex(Object... o) {
		return Modchu_Reflect.newInstance("PositionTextureVertex", new Class[]{ float.class, float.class, float.class, float.class, float.class }, o);
	}

}
