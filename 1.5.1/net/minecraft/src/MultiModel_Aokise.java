package net.minecraft.src;


public class MultiModel_Aokise extends MultiModel_SR2
{
    public Modchu_ModelRenderer sideR;
    public Modchu_ModelRenderer sideL;
    public Modchu_ModelRenderer mune;
    public Modchu_ModelRenderer long1;
    public Modchu_ModelRenderer long2;
    public Modchu_ModelRenderer longSL1;
    public Modchu_ModelRenderer longSL2;
    public Modchu_ModelRenderer longSL3;
    public Modchu_ModelRenderer longSR1;
    public Modchu_ModelRenderer longSR2;
    public Modchu_ModelRenderer longSR3;
    public Modchu_ModelRenderer kamidome1;
    public Modchu_ModelRenderer ribon1;
    public Modchu_ModelRenderer ribon2;
    public Modchu_ModelRenderer ribon3;
    public Modchu_ModelRenderer ribon4;
    //public Modchu_ModelRenderer akuse1;
    //public Modchu_ModelRenderer akuse2;
    public Modchu_ModelRenderer kataR;
    public Modchu_ModelRenderer kataL;

    public MultiModel_Aokise()
    {
        this(0.0F);
    }

    public MultiModel_Aokise(float f)
    {
        this(f, 0.0F);
    }

    public MultiModel_Aokise(float f, float f1)
    {
		this(f, f1 , 64, 64);
	}

	public MultiModel_Aokise(float f, float f1, int i, int j) {
		super(f, f1, i, j);
	}

	@Override
	public void initModel(float f, float f1) {
		textureWidth = 64;
		textureHeight = 64;
		f1 += 8F;
		bipedCloak = new ModelRenderer(this, 0, 0);
		bipedCloak.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 1, f);
		bipedCloak.showModel = false;
		bipedEars = new ModelRenderer(this, 0, 16);
		bipedEars.addBox(-3.0F, -6.0F, -1.0F, 6, 6, 1, f);
		bipedEars.showModel = false;
		bipedHead = new Modchu_ModelRenderer(this, 0, 0);
		bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, f);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHeadwear = new Modchu_ModelRenderer(this, 24, 0);
		bipedHeadwear.addBox(-4.0F, 0.0F, 1.0F, 8, 4, 3, f);
		bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(bipedHeadwear);
		bipedBody = new Modchu_ModelRenderer(this, 32, 8);
		bipedBody.addBox(-3.0F, -3.5F, -2.0F, 6, 7, 4, f);
		bipedBody.setRotationPoint(0.0F, -3.0F, 0.0F);
		bipedRightArm = new Modchu_ModelRenderer(this, 48, 0);
		bipedRightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
		bipedRightArm.setRotationPoint(-3.0F, -3.5F + f1, 0.0F);
		bipedBody.addChild(bipedRightArm);
		bipedLeftArm = new Modchu_ModelRenderer(this, 56, 0);
		bipedLeftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
		bipedLeftArm.setRotationPoint(3.0F, -3.5F + f1, 0.0F);
		bipedBody.addChild(bipedLeftArm);
		bipedRightLeg = new Modchu_ModelRenderer(this, 32, 19);
		bipedRightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);
		bipedRightLeg.setRotationPoint(-1.5F, 7F + f1, 0.0F);
		bipedBody.addChild(bipedRightLeg);
		bipedLeftLeg = new Modchu_ModelRenderer(this, 32, 19);
		bipedLeftLeg.mirror = true;
		bipedLeftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);
		bipedLeftLeg.setRotationPoint(1.5F, 7F + f1, 0.0F);
		bipedBody.addChild(bipedLeftLeg);
		Skirt = new Modchu_ModelRenderer(this, 0, 16);
		Skirt.addBox(-4F, -4F, -4F, 8, 8, 8, f);
		Skirt.setRotationPoint(0.0F, -4F + f1, 0.0F);
		bipedBody.addChild(Skirt);
		ChignonR = new Modchu_ModelRenderer(this, 24, 18);
		ChignonR.addBox(-5F, -7F, 0.2F, 1, 3, 3, f);
		ChignonR.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(ChignonR);
		ChignonL = new Modchu_ModelRenderer(this, 24, 18);
		ChignonL.addBox(4F, -7F, 0.2F, 1, 3, 3, f);
		ChignonL.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(ChignonL);
		ChignonB = new Modchu_ModelRenderer(this, 52, 10);
		ChignonB.addBox(-2F, -7.2F, 4F, 4, 4, 2, f);
		ChignonB.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(ChignonB);
		Tail = new Modchu_ModelRenderer(this, 46, 20);
		Tail.addBox(-1.5F, -6.8F, 4F, 3, 9, 3, f);
		Tail.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(Tail);
		SideTailR = new Modchu_ModelRenderer(this, 58, 21);
		SideTailR.addBox(-5.5F, -6.8F, 0.9F, 1, 8, 2, f);
		SideTailR.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(SideTailR);
		SideTailL = new Modchu_ModelRenderer(this, 58, 21);
		SideTailL.mirror = true;
		SideTailL.addBox(4.5F, -6.8F, 0.9F, 1, 8, 2, f);
		SideTailL.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(SideTailL);

		eyeR = new Modchu_ModelRenderer(this, 32, 19);
		eyeR.addPlate(-4.0F, -5.0F, -4.001F, 4, 4, 0, f);
		eyeR.setRotationPointLM(0.0F, 0.0F, 0.0F);
		eyeL = new Modchu_ModelRenderer(this, 42, 19);
		eyeL.addPlate(0.0F, -5.0F, -4.001F, 4, 4, 0, f);
		eyeL.setRotationPointLM(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(eyeR);
		bipedHead.addChild(eyeL);

		sideR = new Modchu_ModelRenderer(this, 0, 35);
		sideR.addBox(-3.2F, -0.8F, -1.5F, 1, 6, 3, f);
		sideR.setRotationPointLM(0F, 3.5F, 0F);
		bipedBody.addChild(sideR);

		sideL = new Modchu_ModelRenderer(this, 0, 35);
		sideL.mirror = true;
		sideL.addBox(2.2F, -0.8F, -1.5F, 1, 6, 3, f);
		sideL.setRotationPointLM(0F, 3.5F, 0F);
		bipedBody.addChild(sideL);

		mune = new Modchu_ModelRenderer(this, 0, 33);
		mune.addBox(-2F, -0.4F, -2.8F, 4, 1, 1);
		mune.setRotationPointLM(0F, -3F, 0F);
		bipedBody.addChild(mune);

		long1 = new Modchu_ModelRenderer(this, 0, 44);
		long1.addBox(-3F, -6F, 4.2F, 6, 11, 1);
		long1.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(long1);

		long2 = new Modchu_ModelRenderer(this, 0, 56);
		long2.addBox(-3F, 4F, 5F, 6, 7, 1);
		long2.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(long2);

		longSL1 = new Modchu_ModelRenderer(this, 14, 35);
		longSL1.addBox(-2F, -5F, 4.5F, 2, 11, 1);
		longSL1.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(longSL1);

		longSL2 = new Modchu_ModelRenderer(this, 8, 37);
		longSL2.addBox(-2.9F, 3.5F, 5.5F, 2, 6, 1);
		longSL2.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(longSL2);

		longSL3 = new Modchu_ModelRenderer(this, 14, 45);
		longSL3.addBox(3.5F, 0F, 1.6F, 1, 10, 2);
		longSL3.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(longSL3);

		longSR1 = new Modchu_ModelRenderer(this, 14, 35);
		longSR1.mirror = true;
		longSR1.addBox(0F, -5F, 4.5F, 2, 11, 1);
		longSR1.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(longSR1);

		longSR2 = new Modchu_ModelRenderer(this, 8, 37);
		longSR2.mirror = true;
		longSR2.addBox(1F, 3.5F, 5.5F, 2, 6, 1);
		longSR2.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(longSR2);

		longSR3 = new Modchu_ModelRenderer(this, 14, 45);
		longSR3.mirror = true;
		longSR3.addBox(-4.5F, 0F, 1.6F, 1, 10, 2);
		longSR3.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(longSR3);

		kamidome1 = new Modchu_ModelRenderer(this, 8, 35);
		kamidome1.addBox(-0.5F, -5F, 5F, 1, 1, 1);
		kamidome1.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(kamidome1);

		ribon1 = new Modchu_ModelRenderer(this, 10, 33);
		ribon1.addBox(-2.5F, -4.7F, 4.8F, 2, 1, 1);
		ribon1.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(ribon1);

		ribon2 = new Modchu_ModelRenderer(this, 10, 33);
		ribon2.addBox(0.5F, -4.7F, 4.8F, 2, 1, 1);
		ribon2.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(ribon2);

		ribon3 = new Modchu_ModelRenderer(this, 0, 16);
		ribon3.addBox(2F, -3.5F, 4.8F, 2, 7, 1);
		ribon3.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(ribon3);

		ribon4 = new Modchu_ModelRenderer(this, 0, 16);
		ribon4.mirror = true;
		ribon4.addBox(-4F, -3.5F, 4.8F, 2, 7, 1);
		ribon4.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(ribon4);

		mainFrame = new Modchu_ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, 0F + f1, 0F);
		mainFrame.addChild(bipedHead);
		mainFrame.addChild(bipedBody);

		sideR.rotateAngleZ = 0.2094395F;
		sideL.rotateAngleZ = longSL3.rotateAngleY = -0.1745329F;
		long1.rotateAngleX =ribon1.rotateAngleX=ribon2.rotateAngleX=ribon3.rotateAngleX=ribon4.rotateAngleX=kamidome1.rotateAngleX= 0.2443461F;
		long2.rotateAngleX = 0.0872665F;
		longSL1.rotateAngleX = longSL1.rotateAngleZ = longSL3.rotateAngleX = longSR1.rotateAngleX = longSR3.rotateAngleX = longSR3.rotateAngleY = 0.1745329F;
		longSL1.rotateAngleY = longSL2.rotateAngleY = ((float)Math.PI / 4F);
		longSL3.rotateAngleZ = -0.1570796F;
		longSR1.rotateAngleY = longSR2.rotateAngleY = -((float)Math.PI / 4F);
		longSR1.rotateAngleZ = -0.185895F;
		longSR3.rotateAngleZ = 0.1570796F;
		mune.rotateAngleX=ribon1.rotateAngleZ=0.5235988F;
		ribon2.rotateAngleZ=-0.5235988F;
		ribon3.rotateAngleZ=-0.4363323F;
		ribon4.rotateAngleZ=0.4363323F;

		actionPartsInit(f, f1);
    }
}
