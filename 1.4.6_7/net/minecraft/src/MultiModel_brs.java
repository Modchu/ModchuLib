package net.minecraft.src;

public class MultiModel_brs extends MultiModel_SR2
{
    public Modchu_ModelRenderer TailR1;
    public Modchu_ModelRenderer TailR2;
    public Modchu_ModelRenderer TailR3;
    public Modchu_ModelRenderer TailL1;
    public Modchu_ModelRenderer TailL2;
    public Modchu_ModelRenderer TailL3;
    public Modchu_ModelRenderer TailL4;
    public Modchu_ModelRenderer Parkar;
    public Modchu_ModelRenderer Breast1;
    public Modchu_ModelRenderer Cheek_R;
    public Modchu_ModelRenderer Cheek_L;

    public MultiModel_brs()
    {
        this(0.0F);
    }

    public MultiModel_brs(float f)
    {
        this(f, 0.0F);
    }

    public MultiModel_brs(float f, float f1)
    {
    	this(f, f1 , 64, 64);
    }

    public MultiModel_brs(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
    }

	@Override
	public void initModel(float f, float f1) {
		textureWidth = 64;
		textureHeight = 64;
		f1 += 8F;
		bipedHead = new Modchu_ModelRenderer(this, 0, 0);
		bipedHead.addBox(-4F, -8F, -4F, 8, 8, 8, f);
		bipedHead.setRotationPoint(0.0F, 0.5F, 0.0F);
		bipedHeadwear = new Modchu_ModelRenderer(this, 24, 0);
		bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
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
		TailR1 = new Modchu_ModelRenderer(this, 58, 10);
		TailR1.addBoxLM(-6F, -7F, 1.9F, 1, 6, 2, f);
		TailR1.setRotationPointLM(0.0F, 0.0F, 0.0F);
		TailR1.setRotateAngleZ(0.2443461F);
		TailR2 = new Modchu_ModelRenderer(this, 46, 19);
		TailR2.addBoxLM(-9.3F, -4.7F, 1.7F, 2, 8, 2, f);
		TailR2.setRotationPointLM(0.0F, 0.0F, 0.0F);
		TailR2.setRotateAngleX(0.0698132F);
		TailR2.setRotateAngleY(0.1047198F);
		TailR2.setRotateAngleZ(0.6457718F);
		TailR3 = new Modchu_ModelRenderer(this, 46, 32);
		TailR3.addBoxLM(-5.3F, -9.5F, 1.1F, 4, 1, 3, f);
		TailR3.setRotationPointLM(0.0F, 0.0F, 0.0F);
		TailR3.setRotateAngleY(0.0349066F);
		TailR3.setRotateAngleZ(-0.2268928F);
		TailL1 = new Modchu_ModelRenderer(this, 52, 10);
		TailL1.addBoxLM(5F, -6F, 1.9F, 1, 5, 2, f);
		TailL1.setRotationPointLM(0.0F, 0.0F, 0.0F);
		TailL1.setRotateAngleZ(-0.2443461F);
		TailL2 = new Modchu_ModelRenderer(this, 54, 19);
		TailL2.addBoxLM(7.3F, -4.7F, 1.7F, 2, 11, 2, f);
		TailL2.setRotationPointLM(0.0F, 0.0F, 0.0F);
		TailL2.setRotateAngleX(0.0698132F);
		TailL2.setRotateAngleY(-0.1047198F);
		TailL2.setRotateAngleZ(-0.6457718F);
		TailL3 = new Modchu_ModelRenderer(this, 46, 32);
		TailL3.addBoxLM(2.7F, -9F, 1.1F, 4, 1, 3, f);
		TailL3.setRotationPointLM(0.0F, 0.0F, 0.0F);
		TailL3.setRotateAngleY(-0.0349066F);
		TailL3.setRotateAngleZ(0.0523599F);
		TailL4 = new Modchu_ModelRenderer(this, 28, 32);
		TailL4.addBoxLM(5F, -7F, 1.2F, 6, 1, 3, f);
		TailL4.setRotationPointLM(0.0F, 0.0F, 0.0F);
		TailL4.setRotateAngleZ(-0.4363323F);
		Parkar = new Modchu_ModelRenderer(this, 28, 37);
		Parkar.addBoxLM(-4F, -1F, -2.1F, 8, 2, 6, f);
		Parkar.setRotationPointLM(0.0F, 0.0F, 0.0F);
		Breast1 = new Modchu_ModelRenderer(this, 0, 32);
		Breast1.addBoxLM(0.0F, -2.5F, 0.0F, 2, 5, 1, f);
		Breast1.setRotationPointLM(0.0F, -7F + f1, -2F);
		Breast1.setRotateAngleZ(((float)Math.PI / 2F));
		Breast1.setRotateAngleY(0.4363323F);
		eyeR = new Modchu_ModelRenderer(this, 0, 16);
		eyeR.addPlate(-4F, -4.9F, -4.001F, 4, 4, 0, f);
		eyeR.setRotationPointLM(0.0F, -8F + f1, 0.0F);
		eyeL = new Modchu_ModelRenderer(this, 4, 16);
		eyeL.addPlate(0.0F, -4.9F, -4.001F, 4, 4, 0, f);
		eyeL.setRotationPointLM(0.0F, -8F + f1, 0.0F);
		Cheek_R = new Modchu_ModelRenderer(this, 32, 8);
		Cheek_R.addPlate(-4.5F, -4.5F, -4.002F, 4, 4, 0, f);
		Cheek_R.setRotationPointLM(0.0F, -7F + f1, 0.0F);
		Cheek_L = new Modchu_ModelRenderer(this, 32, 19);
		Cheek_L.addPlate(0.5F, -4.5F, -4.002F, 4, 4, 0, f);
		Cheek_L.setRotationPointLM(0.0F, -7F + f1, 0.0F);
		mainFrame = new Modchu_ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, 0F + f1, 0F);
		mainFrame.addChild(bipedHead);
		mainFrame.addChild(bipedBody);
		bipedHead.addChild(TailR1);
		bipedHead.addChild(TailR2);
		bipedHead.addChild(TailR3);
		bipedHead.addChild(TailL1);
		bipedHead.addChild(TailL2);
		bipedHead.addChild(TailL3);
		bipedHead.addChild(TailL4);
		bipedBody.addChild(Parkar);
		bipedBody.addChild(Breast1);
		bipedHead.addChild(eyeR);
		bipedHead.addChild(eyeL);
		bipedHead.addChild(Cheek_R);
		bipedHead.addChild(Cheek_L);
		actionPartsInit(f, f1);
    }

    public void setLivingAnimationsLM(EntityLiving entityliving, float f, float f1, float f2)
    {
    	super.setLivingAnimationsLM(entityliving, f, f1, f2);
    	if (getIsLookSuger(entityliving)) {
    		Cheek_R.setVisible(true);
    		Cheek_L.setVisible(true);
    	} else {
    		Cheek_R.setVisible(false);
    		Cheek_L.setVisible(false);
    	}
    }

    @Override
    public void defaultPartsSettingAfter() {
    	//Cheek Default off
    	setGuiParts("Cheek", false);
    }
}
