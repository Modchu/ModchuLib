package net.minecraft.src;


public class Modchu_ModelPlateFreeShape extends ModelBox
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

    public Modchu_ModelPlateFreeShape(ModelRenderer var1, int var2, int var3, float[][] var4, float[][] var5, float[][] var6, float[] var7, float var8)
    {
        super(var1, var2, var3, 0.0F, 0.0F, 0.0F, 0, 0, 0, var8);
        int var21 = var4.length;
        this.posX1 = var4[0][0];
        this.posY1 = var4[0][1];
        this.posZ1 = var4[0][2];
        this.posX2 = var4[1][0];
        this.posY2 = var4[1][1];
        this.posZ2 = var4[1][2];
        this.posX3 = var4[2][0];
        this.posY3 = var4[2][1];
        this.posZ3 = var4[2][2];
        this.vn = var6;
        float var22 = 8.0F;
        float var23 = 8.0F;
        this.vertexPositions = new PositionTextureVertex[var21];
        this.triList = new Modchu_TexturedTriangle[1];

        for (int var24 = 0; var24 < var21; ++var24)
        {
            this.vertexPositions[var24] = new PositionTextureVertex(var4[var24][0], var4[var24][1], var4[var24][2], 0.0F, 0.0F);
        }

        float[][] var27 = new float[3][2];
        var27[0][0] = (float)var2 + var22;
        var27[0][1] = (float)var3;
        var27[1][0] = (float)var2;
        var27[1][1] = (float)var3;
        var27[2][0] = (float)var2;
        var27[2][1] = (float)var3 + var23;
        this.triList[0] = new Modchu_TexturedTriangle(this.vertexPositions, var5, this.vn, var7, 0.0F, 0.0F);

        if (var1.mirror)
        {
            for (var2 = 0; var2 < this.triList.length; ++var2)
            {
                this.triList[var2].flipFace();
            }
        }

        try
        {
            ModLoader.setPrivateValue(ModelBox.class, this, 0, this.vertexPositions);
            ModLoader.setPrivateValue(ModelBox.class, this, 1, this.triList);
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
        for (int var3 = 0; var3 < this.triList.length; ++var3)
        {
            this.triList[var3].draw(var1, var2);
        }
    }
}
