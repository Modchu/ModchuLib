
package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class MultiModel_long extends MultiModel_SR2
{
    public Modchu_ModelRenderer longhear;
	public Modchu_ModelRenderer kamidome;

    public MultiModel_long()
    {
        this(0.0F);
    }

    public MultiModel_long(float f)
    {
        this(f, 0.0F);
    }

    public MultiModel_long(float f, float f1)
    {
		// 132deletesuper(f, f1);
//-@-132
		this(f, f1 , 64, 32);
	}

	public MultiModel_long(float f, float f1, int i, int j) {
		super(f, f1, i, j);
//@-@132
	}

	@Override
	public void initModel(float f, float f1) {
		super.initModel(f, f1);
		longhear = new Modchu_ModelRenderer(this, 52, 12);
		longhear.addBox(-1.5F, -9F, 7F, 3, 17, 3);
		longhear.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(longhear);
		kamidome = new Modchu_ModelRenderer(this, 46, 19);
		kamidome.addBox(-1F, -7F, 6F, 2, 2, 1);
		kamidome.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(kamidome);

		kamidome.rotateAngleX=0.2974289F;
		longhear.rotateAngleX=0.2974289F;
		Tail.setVisible(false);
		SideTailL.setVisible(false);
		SideTailR.setVisible(false);
		ChignonB.setVisible(false);
    }
}