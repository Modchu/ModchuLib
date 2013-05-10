package net.minecraft.src;


public class Modchu_ModelPlateFreeShape extends MMM_ModelBoxBase
{
	private PositionTextureVertex[] vertexPositions;
	private Modchu_TexturedTriangle[] triList;
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

//-@-151
	public Modchu_ModelPlateFreeShape(ModelRenderer pMRenderer, Object... pArg) {
		this(pMRenderer, (Integer)pArg[0], (Integer)pArg[1],
				(float[][])pArg[2], (float[][])pArg[3], (float[][])pArg[4],
				(float[])pArg[5], (Float)pArg[6]);
	}
//@-@151
	private Modchu_ModelPlateFreeShape(ModelRenderer var1, int var2, int var3,
			float[][] var4, float[][] var5, float[][] var6,
			float[] var7, float var8)
	{
		super(var1, var2, var3, 0.0F, 0.0F, 0.0F, 0, 0, 0, var8);
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
		vertexPositions = new PositionTextureVertex[var21];
		triList = new Modchu_TexturedTriangle[1];

		for (int var24 = 0; var24 < var21; ++var24)
		{
			vertexPositions[var24] = new PositionTextureVertex(var4[var24][0], var4[var24][1], var4[var24][2], 0.0F, 0.0F);
		}

		float[][] var27 = new float[3][2];
		var27[0][0] = (float)var2 + var22;
		var27[0][1] = (float)var3;
		var27[1][0] = (float)var2;
		var27[1][1] = (float)var3;
		var27[2][0] = (float)var2;
		var27[2][1] = (float)var3 + var23;
		triList[0] = new Modchu_TexturedTriangle(vertexPositions, var5, vn, var7, 0.0F, 0.0F);

		if (var1.mirror)
		{
			for (var2 = 0; var2 < triList.length; ++var2)
			{
				triList[var2].flipFace();
			}
		}

		try
		{
			Modchu_Reflect.setPrivateValue(ModelBox.class, this, 0, vertexPositions);
			Modchu_Reflect.setPrivateValue(ModelBox.class, this, 1, triList);
		}
		catch (Exception var26)
		{
			;
		}
	}

	/**
	 * Draw the six sided box defined by this ModelBox
	 */
	public void render(Tessellator var1, float var2)
	{
		for (int var3 = 0; var3 < triList.length; ++var3)
		{
			triList[var3].draw(var1, var2);
		}
	}
}
