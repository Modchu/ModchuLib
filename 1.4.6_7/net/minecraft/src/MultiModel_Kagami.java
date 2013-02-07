package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class MultiModel_Kagami extends MultiModel_SR2
{
    public Modchu_ModelRenderer tailR;
    public Modchu_ModelRenderer tailRFA;
    public Modchu_ModelRenderer tailRBA;
    public Modchu_ModelRenderer tailRBB;
    public Modchu_ModelRenderer kamidomeR;
    public Modchu_ModelRenderer kamidomeRF;
    public Modchu_ModelRenderer kamidomeRB;
    public Modchu_ModelRenderer tailL;
    public Modchu_ModelRenderer kamidomeL;
    public Modchu_ModelRenderer kamidomeLF;
    public Modchu_ModelRenderer kamidomeLB;
    public Modchu_ModelRenderer tailLFA;
    public Modchu_ModelRenderer tailLBA;
    public Modchu_ModelRenderer tailLBB;

    public MultiModel_Kagami()
    {
        this(0.0F);
    }

    public MultiModel_Kagami(float f)
    {
        this(f, 0.0F);
    }

    public MultiModel_Kagami(float f, float f1)
    {
    	this(f, f1 , 64, 64);
    }

    public MultiModel_Kagami(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
    }

	@Override
	public void initModel(float f, float f1) {
		textureWidth = 64;
		textureHeight = 64;
		super.initModel(f, f1);
		tailR = new Modchu_ModelRenderer(this, 8, 40);
		tailR.addBox(3.4F, -6.5F, -0.5F, 1, 2, 2);
		tailR.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(tailR);
		tailRFA = new Modchu_ModelRenderer(this, 0, 40);
		tailRFA.addBox(5F, -4F, -1.2F, 1, 7, 1);
		tailRFA.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(tailRFA);
		tailRBA = new Modchu_ModelRenderer(this, 14, 40);
		tailRBA.addBox(4.8F, -4.2F, -2.266667F, 1, 8, 2);
		tailRBA.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(tailRBA);
		tailRBB = new Modchu_ModelRenderer(this, 14, 50);
		tailRBB.addBox(5.2F, 2.2F, -1.2F, 1, 4, 1);
		tailRBB.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(tailRBB);
		kamidomeR = new Modchu_ModelRenderer(this, 8, 34);
		kamidomeR.addBox(4.4F, -6F, 0F, 1, 1, 1);
		kamidomeR.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(kamidomeR);
		kamidomeRF = new Modchu_ModelRenderer(this, 0, 34);
		kamidomeRF.addBox(5F, -3.1F, -4.7F, 1, 2, 1);
		kamidomeRF.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(kamidomeRF);
		kamidomeRB = new Modchu_ModelRenderer(this, 0, 37);
		kamidomeRB.addBox(5F, -2.5F, 4.5F, 1, 2, 1);
		kamidomeRB.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(kamidomeRB);
		tailL = new Modchu_ModelRenderer(this, 8, 44);
		tailL.addBox(-4.4F, -6.5F, -0.5F, 1, 2, 2);
		tailL.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(tailL);
		kamidomeL = new Modchu_ModelRenderer(this, 8, 36);
		kamidomeL.addBox(-5.4F, -6F, 0F, 1, 1, 1);
		kamidomeL.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(kamidomeL);
		kamidomeLF = new Modchu_ModelRenderer(this, 4, 34);
		kamidomeLF.addBox(-6.1F, -3.1F, -4.7F, 1, 2, 1);
		kamidomeLF.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(kamidomeLF);
		kamidomeLB = new Modchu_ModelRenderer(this, 4, 37);
		kamidomeLB.addBox(-6F, -2.533333F, 4.5F, 1, 2, 1);
		kamidomeLB.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(kamidomeLB);
		tailLFA = new Modchu_ModelRenderer(this, 4, 40);
		tailLFA.addBox(-6F, -4F, -1.25F, 1, 7, 1);
		tailLFA.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(tailLFA);
		tailLBA = new Modchu_ModelRenderer(this, 20, 40);
		tailLBA.addBox(-5.9F, -4.2F, -2.3F, 1, 8, 2);
		tailLBA.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(tailLBA);
		tailLBB = new Modchu_ModelRenderer(this, 20, 50);
		tailLBB.addBox(-6.35F, 2.2F, -1.2F, 1, 4, 1);
		tailLBB.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(tailLBB);

		tailRFA.rotateAngleX = tailLFA.rotateAngleX = -0.296706F;
		tailRFA.rotateAngleZ = kamidomeRF.rotateAngleY = kamidomeLB.rotateAngleY = -0.1745329F;
		tailRBA.rotateAngleX = tailLBA.rotateAngleX = 0.1570796F;
		tailRBA.rotateAngleY = tailRBB.rotateAngleY = -0.6108652F;
		tailRBA.rotateAngleZ = -0.2268928F;
		kamidomeRF.rotateAngleX = kamidomeLF.rotateAngleX = -0.7330383F;
		kamidomeRF.rotateAngleZ = kamidomeRB.rotateAngleZ = -0.122173F;
		kamidomeRB.rotateAngleX = kamidomeLB.rotateAngleX = 0.7330383F;
		kamidomeRB.rotateAngleY = kamidomeLF.rotateAngleY = tailLFA.rotateAngleZ = 0.1745329F;
		kamidomeLF.rotateAngleZ = kamidomeLB.rotateAngleZ = 0.122173F;
		tailLBA.rotateAngleY = tailLBB.rotateAngleY = 0.6108652F;
		tailLBA.rotateAngleZ = 0.2268928F;
		actionPartsInit(f, f1);
	}
}
