package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class Modchu_TexturedTriangle extends TexturedQuad
{
    public PositionTextureVertex[] vertexPositions;
    public int nVertices;
    public float[][] vn;
    private boolean invertNormal;
    public int red;
    public int green;
    public int blue;
    public int alpha;
    private boolean setColor;

    public Modchu_TexturedTriangle(PositionTextureVertex[] var1)
    {
        super(var1);
        this.nVertices = 0;
        this.invertNormal = false;
        this.vertexPositions = var1;
        this.nVertices = var1.length;
    }

    public Modchu_TexturedTriangle(PositionTextureVertex[] var1, float[][] var2, float[][] var3, float[] var4, float var5, float var6)
    {
        this(var1);

        if (var4 != null)
        {
            this.red = (int)(255.0F * var4[0]);
            this.green = (int)(255.0F * var4[1]);
            this.blue = (int)(255.0F * var4[2]);
            this.alpha = (int)(255.0F * var4[3] * 0.5F);
            this.setColor = true;
        }
        else
        {
            this.red = 255;
            this.green = 255;
            this.blue = 255;
            this.alpha = 255;
            this.setColor = false;
        }

        if (var5 == 0.0F && var6 == 0.0F)
        {
            var6 = 1.0F;
            var5 = 1.0F;
        }

        this.nVertices = var1.length;

        for (int var7 = 0; var7 < this.nVertices; ++var7)
        {
            var1[var7] = var1[var7].setTexturePosition(var2[var7][0] / var5, var2[var7][1] / var6);
        }

        this.vn = var3;
    }

    public void flipFace()
    {
        PositionTextureVertex[] var1 = new PositionTextureVertex[this.vertexPositions.length];

        for (int var2 = 0; var2 < this.vertexPositions.length; ++var2)
        {
            var1[var2] = this.vertexPositions[this.vertexPositions.length - var2 - 1];
        }

        this.vertexPositions = var1;
    }

    public void draw(Tessellator var1, float var2)
    {
        Vec3D[] var5 = new Vec3D[this.nVertices];
        int var6;

        if (this.vn == null)
        {
            Vec3D var3 = this.vertexPositions[1].vector3D.subtract(this.vertexPositions[0].vector3D);
            Vec3D var4 = this.vertexPositions[1].vector3D.subtract(this.vertexPositions[2].vector3D);

            for (var6 = 0; var6 < this.nVertices; ++var6)
            {
                var5[var6] = var4.crossProduct(var3).normalize();
            }
        }
        else
        {
            for (var6 = 0; var6 < this.nVertices; ++var6)
            {
                var5[var6] = Vec3D.createVectorHelper((double)this.vn[var6][0], (double)this.vn[var6][1], (double)this.vn[var6][2]);
            }
        }

        var6 = GL11.glGetInteger(GL11.GL_CURRENT_COLOR);
        boolean var7;

        if ((var6 & 255) == 102)
        {
            var7 = false;
        }
        else
        {
            var7 = true;
        }

        GL11.glShadeModel(GL11.GL_SMOOTH);
        byte var8 = 6;

        if (this.nVertices % 4 == 0)
        {
            var8 = 7;
        }

        var1.startDrawing(var8);

        for (int var9 = 0; var9 < this.nVertices; ++var9)
        {
            if (this.invertNormal)
            {
                var1.setNormal(-((float)var5[var9].xCoord), -((float)var5[var9].yCoord), -((float)var5[var9].zCoord));
            }
            else
            {
                var1.setNormal((float)var5[var9].xCoord, (float)var5[var9].yCoord, (float)var5[var9].zCoord);
            }

            PositionTextureVertex var10 = this.vertexPositions[var9];
            var1.addVertexWithUV((double)((float)var10.vector3D.xCoord * var2), (double)((float)var10.vector3D.yCoord * var2), (double)((float)var10.vector3D.zCoord * var2), (double)var10.texturePositionX, (double)var10.texturePositionY);
        }

        var1.draw();
    }
}
