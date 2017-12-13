package modchu.lib;

import java.util.HashMap;

import modchu.lib.Modchu_ITexturedQuad;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_ModelBoxMasterBasis;
import modchu.lib.Modchu_Reflect;
import modchu.lib.Modchu_TexturedQuad;

public class Modchu_ModelPlateFreeShape extends Modchu_ModelBoxMasterBasis {
	private Object[] positionTextureVertex;
	private Modchu_ITexturedQuad[] triList;
	public final float posX1;
	public final float posY1;
	public final float posZ1;
	public final float posX2;
	public final float posY2;
	public final float posZ2;
	public final float posX3;
	public final float posY3;
	public final float posZ3;
	public final float[][] vn;

	public Modchu_ModelPlateFreeShape(HashMap<String, Object> map) {
		this(map, map.get("Object"), (Integer)map.get("Integer"), (Integer)map.get("Integer1"),
				(float[][])map.get("float[][]"), (float[][])map.get("float[][]1"), (float[][])map.get("float[][]2"),
				(float[])map.get("float[]"), (Float)map.get("Float"));
	}

	private Modchu_ModelPlateFreeShape(HashMap<String, Object> map, Object var1, int var2, int var3,
			float[][] var4, float[][] var5, float[][] var6, float[] var7, float var8) {
		super(map);
		Modchu_ModelRenderer modelRenderer = (Modchu_ModelRenderer) Modchu_Main.getModchuCharacteristicObjectMaster(var1);
		int var21 = var4.length;
		posX1 = var4[0][0];
		posY1 = var4[0][1];
		posZ1 = var4[0][2];
		posX2 = var4[1][0];
		posY2 = var4[1][1];
		posZ2 = var4[1][2];
		posX3 = var4[2][0];
		posY3 = var4[2][1];
		posZ3 = var4[2][2];
		vn = var6;
		float var22 = 8.0F;
		float var23 = 8.0F;
		positionTextureVertex = Modchu_Reflect.newInstanceArray("PositionTextureVertex", var21);
		//Modchu_Debug.mDebug("Modchu_ModelPlateFreeShape positionTextureVertex="+positionTextureVertex);
		triList = new Modchu_TexturedQuad[1];

		for (int var24 = 0; var24 < var21; ++var24) {
			positionTextureVertex[var24] = Modchu_Reflect.newInstance("PositionTextureVertex", new Class[]{ float.class, float.class, float.class, float.class, float.class }, new Object[]{ var4[var24][0], var4[var24][1], var4[var24][2], 0.0F, 0.0F });
			//Modchu_Debug.mDebug("Modchu_ModelPlateFreeShape positionTextureVertex["+var24+"]="+positionTextureVertex[var24]);
		}

		float[][] var27 = new float[3][2];
		var27[0][0] = var2 + var22;
		var27[0][1] = var3;
		var27[1][0] = var2;
		var27[1][1] = var3;
		var27[2][0] = var2;
		var27[2][1] = var3 + var23;
		triList[0] = new Modchu_TexturedQuad(Modchu_Main.getNewModchuCharacteristicMap(Modchu_TexturedTriangleMaster.class, positionTextureVertex, var5, vn, var7, 0.0F, 0.0F));
		//Modchu_Debug.mDebug("Modchu_ModelPlateFreeShape triList[0]="+triList[0]);

		if (modelRenderer.mirror) {
			for (var2 = 0; var2 < triList.length; ++var2) {
				flipFace(triList[var2]);
				//Modchu_Debug.mDebug("Modchu_ModelPlateFreeShape triList["+var2+"]="+triList[var2]);
			}
		}
		//Modchu_AS.set(Modchu_AS.modelBoxVertexPositions, base, positionTextureVertex);
		//Modchu_AS.set(Modchu_AS.modelBoxQuadList, base, triList);
	}

	@Override
	public void render(float f) {
		for (int var3 = 0; var3 < triList.length; ++var3) {
			//Modchu_AS.set(Modchu_AS.texturedQuadDraw, triList[var3], o, f);
			Modchu_Reflect.invokeMethod(triList[var3].getClass(), "draw", new Class[]{ float.class }, triList[var3], new Object[]{ f });
		}
	}

	public void flipFace(Object texturedQuad) {
		((Modchu_ITexturedQuad) texturedQuad).flipFace();
	}

}