package net.minecraft.src;

public class MultiModel_dm extends MultiModel_SR2
{
    public Modchu_ModelRenderer HornR1;
    public Modchu_ModelRenderer HornR2;
    public Modchu_ModelRenderer HornR3;
    public Modchu_ModelRenderer HornR4;
    public Modchu_ModelRenderer HornR5;
    public Modchu_ModelRenderer HornR6;
    public Modchu_ModelRenderer HornR7;
    public Modchu_ModelRenderer HornR8;
    public Modchu_ModelRenderer HornR9;
    public Modchu_ModelRenderer HornR10;
    public Modchu_ModelRenderer HornL1;
    public Modchu_ModelRenderer HornL2;
    public Modchu_ModelRenderer HornL3;
    public Modchu_ModelRenderer HornL4;
    public Modchu_ModelRenderer HornL5;
    public Modchu_ModelRenderer HornL6;
    public Modchu_ModelRenderer HornL7;
    public Modchu_ModelRenderer HornL8;
    public Modchu_ModelRenderer HornL9;
    public Modchu_ModelRenderer HornL10;
    public Modchu_ModelRenderer HairR1;
    public Modchu_ModelRenderer HairR2;
    public Modchu_ModelRenderer HairR3;
    public Modchu_ModelRenderer HairL1;
    public Modchu_ModelRenderer HairL2;
    public Modchu_ModelRenderer HairL3;
    public Modchu_ModelRenderer WingR1;
    public Modchu_ModelRenderer WingR2;
    public Modchu_ModelRenderer WingR3;
    public Modchu_ModelRenderer WingL1;
    public Modchu_ModelRenderer WingL2;
    public Modchu_ModelRenderer WingL3;
    public Modchu_ModelRenderer Cachusya;
    public Modchu_ModelRenderer Bribonc;
    public Modchu_ModelRenderer BribonR;
    public Modchu_ModelRenderer BribonL;
    public Modchu_ModelRenderer Breast1;
    public Modchu_ModelRenderer Cheek_R;
    public Modchu_ModelRenderer Cheek_L;

    public MultiModel_dm()
    {
        this(0.0F);
    }

    public MultiModel_dm(float f)
    {
        this(f, 0.0F);
    }

    public MultiModel_dm(float f, float f1)
    {
    	this(f, f1 , 64, 64);
    }

    public MultiModel_dm(float f, float f1, int i, int j) {
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
    	bipedRightArm.setRotationPoint(-3.0F, 4.5F, 0.0F);
    	bipedBody.addChild(bipedRightArm);
    	bipedLeftArm = new Modchu_ModelRenderer(this, 56, 0);
    	bipedLeftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
    	bipedLeftArm.setRotationPoint(3.0F, 4.5F, 0.0F);
    	bipedBody.addChild(bipedLeftArm);
    	bipedRightLeg = new Modchu_ModelRenderer(this, 32, 19);
    	bipedRightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);
    	bipedRightLeg.setRotationPoint(-1.5F, 15F, 0.0F);
    	bipedBody.addChild(bipedRightLeg);
    	bipedLeftLeg = new Modchu_ModelRenderer(this, 32, 19);
    	bipedLeftLeg.mirror = true;
    	bipedLeftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);
    	bipedLeftLeg.setRotationPoint(1.5F, 15F, 0.0F);
    	bipedBody.addChild(bipedLeftLeg);
    	Skirt = new Modchu_ModelRenderer(this, 0, 16);
    	Skirt.addBox(-4F, -4F, -4F, 8, 8, 8, f);
    	Skirt.setRotationPoint(0.0F, 4.0F, 0.0F);
    	bipedBody.addChild(Skirt);
    	HornR1 = new Modchu_ModelRenderer(this, 0, 6);
    	HornR1.addBoxLM(-1F, -9F, -1F, 3, 1, 1, f);
    	HornR1.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	HornR1.setRotateAngleZ(-0.6108652F);
    	HornR2 = new Modchu_ModelRenderer(this, 0, 0);
    	HornR2.addBoxLM(-2.7F, -9.5F, -1F, 1, 1, 1, f);
    	HornR2.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	HornR2.setRotateAngleZ(-0.296706F);
    	HornR3 = new Modchu_ModelRenderer(this, 0, 6);
    	HornR3.addBoxLM(-5.2F, -9.8F, -1F, 3, 1, 1, f);
    	HornR3.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	HornR3.setRotateAngleZ(-0.1396263F);
    	HornR4 = new Modchu_ModelRenderer(this, 0, 0);
    	HornR4.addBoxLM(-5F, -10.2F, -1F, 1, 1, 1, f);
    	HornR4.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	HornR4.setRotateAngleZ(-0.0349066F);
    	HornR5 = new Modchu_ModelRenderer(this, 0, 6);
    	HornR5.addBoxLM(-7.5F, -10F, -1F, 3, 1, 1, f);
    	HornR5.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	HornR5.setRotateAngleZ(0.122173F);
    	HornR6 = new Modchu_ModelRenderer(this, 0, 0);
    	HornR6.addBoxLM(-6.5F, -10.7F, -1F, 1, 1, 1, f);
    	HornR6.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	HornR6.setRotateAngleZ(0.1396263F);
    	HornR7 = new Modchu_ModelRenderer(this, 0, 6);
    	HornR7.addBoxLM(-9F, -10.5F, -1F, 3, 1, 1, f);
    	HornR7.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	HornR7.setRotateAngleZ(0.2792527F);
    	HornR8 = new Modchu_ModelRenderer(this, 0, 0);
    	HornR8.addBoxLM(-8F, -11F, -1F, 1, 1, 1, f);
    	HornR8.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	HornR8.setRotateAngleZ(0.296706F);
    	HornR9 = new Modchu_ModelRenderer(this, 0, 3);
    	HornR9.addBoxLM(-9F, -11.5F, -1F, 2, 1, 1, f);
    	HornR9.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	HornR9.setRotateAngleZ(0.3490659F);
    	HornR10 = new Modchu_ModelRenderer(this, 0, 0);
    	HornR10.addBoxLM(-14.4F, -3F, -1F, 1, 1, 1, f);
    	HornR10.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	HornR10.setRotateAngleZ(1.151917F);
    	HornL1 = new Modchu_ModelRenderer(this, 0, 6);
    	HornL1.addBoxLM(-2F, -9F, -1F, 3, 1, 1, f);
    	HornL1.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	HornL1.setRotateAngleZ(0.6108652F);
    	HornL2 = new Modchu_ModelRenderer(this, 0, 0);
    	HornL2.addBoxLM(1.7F, -9.5F, -1F, 1, 1, 1, f);
    	HornL2.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	HornL2.setRotateAngleZ(0.296706F);
    	HornL3 = new Modchu_ModelRenderer(this, 0, 6);
    	HornL3.addBoxLM(2.2F, -9.8F, -1F, 3, 1, 1, f);
    	HornL3.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	HornL3.setRotateAngleZ(0.1396263F);
    	HornL4 = new Modchu_ModelRenderer(this, 0, 0);
    	HornL4.addBoxLM(4F, -10.2F, -1F, 1, 1, 1, f);
    	HornL4.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	HornL4.setRotateAngleZ(0.0349066F);
    	HornL5 = new Modchu_ModelRenderer(this, 0, 6);
    	HornL5.addBoxLM(4.5F, -10F, -1F, 3, 1, 1, f);
    	HornL5.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	HornL5.setRotateAngleZ(-0.122173F);
    	HornL6 = new Modchu_ModelRenderer(this, 0, 0);
    	HornL6.addBoxLM(5.5F, -10.7F, -1F, 1, 1, 1, f);
    	HornL6.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	HornL6.setRotateAngleZ(-0.1396263F);
    	HornL7 = new Modchu_ModelRenderer(this, 0, 6);
    	HornL7.addBoxLM(6F, -10.5F, -1F, 3, 1, 1, f);
    	HornL7.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	HornL7.setRotateAngleZ(-0.2792527F);
    	HornL8 = new Modchu_ModelRenderer(this, 0, 0);
    	HornL8.addBoxLM(7F, -11F, -1F, 1, 1, 1, f);
    	HornL8.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	HornL8.setRotateAngleZ(-0.296706F);
    	HornL9 = new Modchu_ModelRenderer(this, 0, 3);
    	HornL9.addBoxLM(7F, -11.5F, -1F, 2, 1, 1, f);
    	HornL9.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	HornL9.setRotateAngleZ(-0.3490659F);
    	HornL10 = new Modchu_ModelRenderer(this, 0, 0);
    	HornL10.addBoxLM(13.4F, -3F, -1F, 1, 1, 1, f);
    	HornL10.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	HornL10.setRotateAngleZ(-1.151917F);
    	HairR1 = new Modchu_ModelRenderer(this, 52, 10);
    	HairR1.addBoxLM(-5F, -7F, -2F, 1, 5, 5, f);
    	HairR1.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	HairR2 = new Modchu_ModelRenderer(this, 6, 32);
    	HairR2.addBoxLM(-5F, -2F, -4F, 1, 2, 6, f);
    	HairR2.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	HairR3 = new Modchu_ModelRenderer(this, 24, 5);
    	HairR3.addBoxLM(-4F, 0.0F, -4F, 1, 2, 1, f);
    	HairR3.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	HairL1 = new Modchu_ModelRenderer(this, 52, 10);
    	HairL1.addBoxLM(4F, -7F, -2F, 1, 5, 5, f);
    	HairL1.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	HairL2 = new Modchu_ModelRenderer(this, 6, 32);
    	HairL2.addBoxLM(4F, -2F, -4F, 1, 2, 6, f);
    	HairL2.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	HairL3 = new Modchu_ModelRenderer(this, 24, 5);
    	HairL3.addBoxLM(3F, 0.0F, -4F, 1, 2, 1, f);
    	HairL3.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	WingR1 = new Modchu_ModelRenderer(this, 30, 0);
    	WingR1.addBoxLM(-5F, 0.0F, 2.0F, 3, 1, 1, f);
    	WingR1.setRotationPointLM(0.0F, -4.0F, 0.0F);
    	WingR1.setRotateAngleZ(-0.7330383F);
    	WingR2 = new Modchu_ModelRenderer(this, 39, 0);
    	WingR2.addBoxLM(-5F, -2F, 2.0F, 1, 3, 1, f);
    	WingR2.setRotationPointLM(0.0F, -4.0F, 0.0F);
    	WingR2.setRotateAngleZ(-((float)Math.PI * 2F / 9F));
    	WingR3 = new Modchu_ModelRenderer(this, 44, 0);
    	WingR3.addBoxLM(-5F, 1.0F, 2.0F, 1, 5, 1, f);
    	WingR3.setRotationPointLM(0.0F, -4.0F, 0.0F);
    	WingR3.setRotateAngleZ(0.1745329F);
    	WingL1 = new Modchu_ModelRenderer(this, 30, 0);
    	WingL1.addBoxLM(2.0F, 0.0F, 2.0F, 3, 1, 1, f);
    	WingL1.setRotationPointLM(0.0F, -4.0F, 0.0F);
    	WingL1.setRotateAngleZ(0.7330383F);
    	WingL2 = new Modchu_ModelRenderer(this, 39, 0);
    	WingL2.addBoxLM(4F, -2F, 2.0F, 1, 3, 1, f);
    	WingL2.setRotationPointLM(0.0F, -4.0F, 0.0F);
    	WingL2.setRotateAngleZ(((float)Math.PI * 2F / 9F));
    	WingL3 = new Modchu_ModelRenderer(this, 44, 0);
    	WingL3.addBoxLM(4F, 1.0F, 2.0F, 1, 5, 1, f);
    	WingL3.setRotationPointLM(0.0F, -4.0F, 0.0F);
    	WingL3.setRotateAngleZ(-0.1745329F);
    	Cachusya = new Modchu_ModelRenderer(this, 24, 33);
    	Cachusya.addPlate(-2F, -9F, -4F, 4, 1, 0, f);
    	Cachusya.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	Bribonc = new Modchu_ModelRenderer(this, 0, 20);
    	Bribonc.addBoxLM(-0.5F, 4.6F, 3F, 1, 1, 2, f);
    	Bribonc.setRotationPointLM(0.0F, -4.0F, 0.0F);
    	BribonR = new Modchu_ModelRenderer(this, 24, 19);
    	BribonR.addPlate(-3.5F, 4.6F, 4.7F, 3, 3, 0, f);
    	BribonR.setRotationPointLM(0.0F, -4.0F, 0.0F);
    	BribonL = new Modchu_ModelRenderer(this, 24, 16);
    	BribonL.addPlate(0.5F, 4.6F, 4.7F, 3, 3, 0, f);
    	BribonL.setRotationPointLM(0.0F, -4.0F, 0.0F);
    	Breast1 = new Modchu_ModelRenderer(this, 0, 32);
    	Breast1.addBoxLM(0.0F, -2.5F, 0.0F, 2, 5, 1, f);
    	Breast1.setRotationPointLM(0.0F, 1.0F, -2F);
    	Breast1.setRotateAngleZ(((float)Math.PI / 2F));
    	Breast1.setRotateAngleY(0.4363323F);
    	eyeR = new Modchu_ModelRenderer(this, 0, 16);
    	eyeR.addPlate(-4F, -4.9F, -4.001F, 4, 4, 0, f);
    	eyeR.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	eyeL = new Modchu_ModelRenderer(this, 4, 16);
    	eyeL.addPlate(0.0F, -4.9F, -4.001F, 4, 4, 0, f);
    	eyeL.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	Cheek_R = new Modchu_ModelRenderer(this, 32, 8);
    	Cheek_R.addPlate(-4.5F, -4.5F, -4.002F, 4, 4, 0, f);
    	Cheek_R.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	Cheek_L = new Modchu_ModelRenderer(this, 32, 19);
    	Cheek_L.addPlate(0.5F, -4.5F, -4.002F, 4, 4, 0, f);
    	Cheek_L.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	mainFrame = new Modchu_ModelRenderer(this, 0, 0);
    	mainFrame.setRotationPoint(0F, 0F + f1, 0F);
    	mainFrame.addChild(bipedHead);
    	mainFrame.addChild(bipedBody);
    	bipedHead.addChild(HornR1);
    	bipedHead.addChild(HornR2);
    	bipedHead.addChild(HornR3);
    	bipedHead.addChild(HornR4);
    	bipedHead.addChild(HornR5);
    	bipedHead.addChild(HornR6);
    	bipedHead.addChild(HornR7);
    	bipedHead.addChild(HornR8);
    	bipedHead.addChild(HornR9);
    	bipedHead.addChild(HornR10);
    	bipedHead.addChild(HornL1);
    	bipedHead.addChild(HornL2);
    	bipedHead.addChild(HornL3);
    	bipedHead.addChild(HornL4);
    	bipedHead.addChild(HornL5);
    	bipedHead.addChild(HornL6);
    	bipedHead.addChild(HornL7);
    	bipedHead.addChild(HornL8);
    	bipedHead.addChild(HornL9);
    	bipedHead.addChild(HornL10);
    	bipedHead.addChild(Cachusya);
    	bipedHead.addChild(Cachusya);
    	bipedHead.addChild(HairR1);
    	bipedHead.addChild(HairR2);
    	bipedHead.addChild(HairR3);
    	bipedHead.addChild(HairL1);
    	bipedHead.addChild(HairL2);
    	bipedHead.addChild(HairL3);
    	bipedBody.addChild(Bribonc);
    	bipedBody.addChild(BribonR);
    	bipedBody.addChild(BribonL);
    	bipedBody.addChild(WingR1);
    	bipedBody.addChild(WingR2);
    	bipedBody.addChild(WingR3);
    	bipedBody.addChild(WingL1);
    	bipedBody.addChild(WingL2);
    	bipedBody.addChild(WingL3);
    	bipedBody.addChild(Breast1);
    	bipedHead.addChild(eyeR);
    	bipedHead.addChild(eyeL);
    	bipedHead.addChild(Cheek_R);
    	bipedHead.addChild(Cheek_L);
    	actionPartsInit(f, f1);
    }

    public void setLivingAnimations(EntityLiving entityliving, float f, float f1, float f2)
    {
    	super.setLivingAnimations(entityliving, f, f1, f2);
    	if (getCapsValueBoolean(caps_isLookSuger)) {
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
