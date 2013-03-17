package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class MultiModel_bgs extends MultiModel_SR2
{
    public Modchu_ModelRenderer Headwear;
    public Modchu_ModelRenderer HornR1;
    public Modchu_ModelRenderer HornR2;
    public Modchu_ModelRenderer HornR3;
    public Modchu_ModelRenderer HornR4;
    public Modchu_ModelRenderer HeadwearR;
    public Modchu_ModelRenderer HornL1;
    public Modchu_ModelRenderer HornL2;
    public Modchu_ModelRenderer HornL3;
    public Modchu_ModelRenderer HornL4;
    public Modchu_ModelRenderer HeadwearL;
    public Modchu_ModelRenderer ArmR1;
    public Modchu_ModelRenderer ArmL1;
    public Modchu_ModelRenderer HandR1;
    public Modchu_ModelRenderer HandR2;
    public Modchu_ModelRenderer HandL1;
    public Modchu_ModelRenderer HandL2;
    public Modchu_ModelRenderer LegR1;
    public Modchu_ModelRenderer LegR2;
    public Modchu_ModelRenderer LegR3;
    public Modchu_ModelRenderer LegR4;
    public Modchu_ModelRenderer LegR5;
    public Modchu_ModelRenderer LegL1;
    public Modchu_ModelRenderer LegL2;
    public Modchu_ModelRenderer LegL3;
    public Modchu_ModelRenderer LegL4;
    public Modchu_ModelRenderer LegL5;
    public Modchu_ModelRenderer bootR1;
    public Modchu_ModelRenderer bootR2;
    public Modchu_ModelRenderer bootL1;
    public Modchu_ModelRenderer bootL2;
    public Modchu_ModelRenderer Breast;

    public MultiModel_bgs()
    {
    	this(0.0F);
    }

    public MultiModel_bgs(float f)
    {
    	this(f, 0.0F);
    }

    public MultiModel_bgs(float f, float f1)
    {
    	this(f, f1 , 64, 64);
    }

    public MultiModel_bgs(float f, float f1, int i, int j) {
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
    	Headwear = new Modchu_ModelRenderer(this, 0, 28);
    	Headwear.addBox(-4F, 0.0F, 1.0F, 8, 12, 3, f);
    	Headwear.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Headwear.setRotateAngleX(0.2094395F);
    	bipedBody = new Modchu_ModelRenderer(this, 32, 0);
    	bipedBody.addBox(-3F, 0.0F, -2F, 6, 9, 4, f);
    	bipedBody.setRotationPoint(0.0F, -4.0F, 0.0F);
    	bipedRightArm = new Modchu_ModelRenderer(this, 0, 16);
    	bipedRightArm.addBox(-2F, -1F, -1F, 2, 10, 2, f);
    	bipedRightArm.setRotationPoint(-3F, 1.5F, 0.0F);
    	bipedLeftArm = new Modchu_ModelRenderer(this, 8, 16);
    	bipedLeftArm.mirror = true;
    	bipedLeftArm.addBox(0.0F, -1F, -1F, 2, 10, 2, f);
    	bipedLeftArm.setRotationPoint(3F, 1.5F, 0.0F);
    	bipedRightLeg = new Modchu_ModelRenderer(this, 32, 13);
    	bipedRightLeg.addBox(-2F, 0.0F, -2F, 3, 11, 4, f);
    	bipedRightLeg.setRotationPoint(-1F, 9.0F, 0.0F);
    	bipedLeftLeg = new Modchu_ModelRenderer(this, 32, 13);
    	bipedLeftLeg.mirror = true;
    	bipedLeftLeg.addBox(-1F, 0.0F, -2F, 3, 11, 4, f);
    	bipedLeftLeg.setRotationPoint(1.0F, 9.0F, 0.0F);
    	Skirt = new Modchu_ModelRenderer(this, 0, 16);
    	Skirt.setRotationPoint(0.0F, 13F, 0.0F);
    	HornR1 = new Modchu_ModelRenderer(this, 52, 28);
    	HornR1.addBox(-1F, -10F, 0.0F, 2, 2, 1, f);
    	HornR1.setRotationPoint(0.0F, 0.0F, 0.0F);
    	HornR1.setRotateAngleZ(-0.3839724F);
    	HornR2 = new Modchu_ModelRenderer(this, 58, 18);
    	HornR2.addBox(-6.9F, -11.3F, 0.0F, 1, 4, 1, f);
    	HornR2.setRotationPoint(0.0F, 0.0F, 0.0F);
    	HornR2.setRotateAngleZ(0.2792527F);
    	HornR3 = new Modchu_ModelRenderer(this, 52, 22);
    	HornR3.addBox(-4.2F, -13F, 0.0F, 1, 4, 1, f);
    	HornR3.setRotationPoint(0.0F, 0.0F, 0.0F);
    	HornR3.setRotateAngleZ(0.0523599F);
    	HornR4 = new Modchu_ModelRenderer(this, 53, 18);
    	HornR4.addBox(-2.4F, -15.2F, 0.0F, 1, 2, 1, f);
    	HornR4.setRotationPoint(0.0F, 0.0F, 0.0F);
    	HornR4.setRotateAngleZ(-0.0872665F);
    	HeadwearR = new Modchu_ModelRenderer(this, 0, 0);
    	HeadwearR.addBox(-4F, 0.0F, -4F, 1, 4, 2, f);
    	HeadwearR.setRotationPoint(0.0F, 0.0F, 0.0F);
    	ArmR1 = new Modchu_ModelRenderer(this, 28, 29);
    	ArmR1.addBox(-1F, 4F, -1.5F, 2, 5, 3, f);
    	ArmR1.setRotationPoint(0.0F, 0.0F, 0.0F);
    	ArmR1.setRotateAngleZ(0.2617994F);
    	HandR1 = new Modchu_ModelRenderer(this, 18, 24);
    	HandR1.addBox(-1F, 7.5F, -1.5F, 1, 2, 1, f);
    	HandR1.setRotationPoint(0.0F, 0.0F, 0.0F);
    	HandR2 = new Modchu_ModelRenderer(this, 17, 20);
    	HandR2.addBox(-2F, 8.5F, -1F, 1, 1, 2, f);
    	HandR2.setRotationPoint(0.0F, 0.0F, 0.0F);
    	LegR1 = new Modchu_ModelRenderer(this, 0, 47);
    	LegR1.addBox(-2.5F, 2.0F, -2F, 1, 2, 4, f);
    	LegR1.setRotationPoint(0.0F, 0.0F, 0.0F);
    	LegR2 = new Modchu_ModelRenderer(this, 0, 43);
    	LegR2.addBox(-2F, 2.4F, -3F, 3, 2, 1, f);
    	LegR2.setRotationPoint(0.0F, 0.0F, 0.0F);
    	LegR3 = new Modchu_ModelRenderer(this, 11, 44);
    	LegR3.addBox(-2F, 5F, 0.0F, 3, 1, 3, f);
    	LegR3.setRotationPoint(0.0F, 0.0F, 0.0F);
    	LegR4 = new Modchu_ModelRenderer(this, 5, 53);
    	LegR4.addBox(-1F, 2.7F, -5F, 1, 1, 2, f);
    	LegR4.setRotationPoint(0.0F, 0.0F, 0.0F);
    	LegR5 = new Modchu_ModelRenderer(this, 0, 53);
    	LegR5.addBox(-1F, 2.7F, -3.5F, 1, 2, 1, f);
    	LegR5.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bootR1 = new Modchu_ModelRenderer(this, 0, 57);
    	bootR1.addBox(-1.5F, 10F, -3F, 2, 1, 1, f);
    	bootR1.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bootR2 = new Modchu_ModelRenderer(this, 0, 53);
    	bootR2.addBox(-1F, 8F, -6F, 1, 2, 1, f);
    	bootR2.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bootR2.setRotateAngleX(0.2792527F);
    	HornL1 = new Modchu_ModelRenderer(this, 52, 28);
    	HornL1.addBox(-1F, -10F, 0.0F, 2, 2, 1, f);
    	HornL1.setRotationPoint(0.0F, 0.0F, 0.0F);
    	HornL1.setRotateAngleZ(0.3839724F);
    	HornL2 = new Modchu_ModelRenderer(this, 58, 18);
    	HornL2.addBox(5.9F, -11.3F, 0.0F, 1, 4, 1, f);
    	HornL2.setRotationPoint(0.0F, 0.0F, 0.0F);
    	HornL2.setRotateAngleZ(-0.2792527F);
    	HornL3 = new Modchu_ModelRenderer(this, 52, 22);
    	HornL3.addBox(3.2F, -13F, 0.0F, 1, 4, 1, f);
    	HornL3.setRotationPoint(0.0F, 0.0F, 0.0F);
    	HornL3.setRotateAngleZ(-0.0523599F);
    	HornL4 = new Modchu_ModelRenderer(this, 53, 18);
    	HornL4.addBox(1.4F, -15.2F, 0.0F, 1, 2, 1, f);
    	HornL4.setRotationPoint(0.0F, 0.0F, 0.0F);
    	HornL4.setRotateAngleZ(0.0872665F);
    	HeadwearL = new Modchu_ModelRenderer(this, 24, 0);
    	HeadwearL.addBox(3F, 0.0F, -4F, 1, 4, 2, f);
    	HeadwearL.setRotationPoint(0.0F, 0.0F, 0.0F);
    	ArmL1 = new Modchu_ModelRenderer(this, 41, 29);
    	ArmL1.addBox(-1F, 4F, -1.5F, 2, 5, 3, f);
    	ArmL1.setRotationPoint(0.0F, 0.0F, 0.0F);
    	ArmL1.setRotateAngleZ(-0.2617994F);
    	HandL1 = new Modchu_ModelRenderer(this, 18, 24);
    	HandL1.addBox(0.0F, 7.5F, -1.5F, 1, 2, 1, f);
    	HandL1.setRotationPoint(0.0F, 0.0F, 0.0F);
    	HandL2 = new Modchu_ModelRenderer(this, 17, 20);
    	HandL2.addBox(1.0F, 8.5F, -1F, 1, 1, 2, f);
    	HandL2.setRotationPoint(0.0F, 0.0F, 0.0F);
    	LegL1 = new Modchu_ModelRenderer(this, 0, 47);
    	LegL1.addBox(1.5F, 2.0F, -2F, 1, 2, 4, f);
    	LegL1.setRotationPoint(0.0F, 0.0F, 0.0F);
    	LegL2 = new Modchu_ModelRenderer(this, 0, 43);
    	LegL2.addBox(-1F, 2.4F, -3F, 3, 2, 1, f);
    	LegL2.setRotationPoint(0.0F, 0.0F, 0.0F);
    	LegL3 = new Modchu_ModelRenderer(this, 11, 44);
    	LegL3.addBox(-1F, 5F, 0.0F, 3, 1, 3, f);
    	LegL3.setRotationPoint(0.0F, 0.0F, 0.0F);
    	LegL4 = new Modchu_ModelRenderer(this, 5, 53);
    	LegL4.addBox(0.0F, 2.7F, -5F, 1, 1, 2, f);
    	LegL4.setRotationPoint(0.0F, 0.0F, 0.0F);
    	LegL5 = new Modchu_ModelRenderer(this, 0, 53);
    	LegL5.addBox(0.0F, 2.7F, -3.5F, 1, 2, 1, f);
    	LegL5.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bootL1 = new Modchu_ModelRenderer(this, 0, 57);
    	bootL1.addBox(-0.5F, 10F, -3F, 2, 1, 1, f);
    	bootL1.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bootL2 = new Modchu_ModelRenderer(this, 0, 53);
    	bootL2.addBox(0.0F, 8F, -6F, 1, 2, 1, f);
    	bootL2.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bootL2.setRotateAngleX(0.2792527F);
    	Breast = new Modchu_ModelRenderer(this, 53, 0);
    	Breast.addBoxLM(0.0F, -2.5F, 0.0F, 3, 5, 2, f);
    	Breast.setRotationPointLM(0.0F, 1.0F, -2F);
    	Breast.setRotateAngleZ(((float)Math.PI / 2F));
    	Breast.setRotateAngleY(((float)Math.PI * 2F / 9F));
    	eyeR = new Modchu_ModelRenderer(this, 32, 0);
    	eyeR.addPlate(-4F, -5F, -4.001F, 4, 4, 0, f);
    	eyeR.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	eyeL = new Modchu_ModelRenderer(this, 47, 0);
    	eyeL.addPlate(0.0F, -5F, -4.001F, 4, 4, 0, f);
    	eyeL.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	mainFrame = new Modchu_ModelRenderer(this, 0, 0);
    	mainFrame.setRotationPoint(0F, 0F + f1, 0F);
    	mainFrame.addChild(bipedHead);
    	mainFrame.addChild(bipedBody);
    	bipedHead.addChild(eyeR);
    	bipedHead.addChild(eyeL);
    	bipedHead.addChild(Headwear);
    	bipedHead.addChild(HornR1);
    	bipedHead.addChild(HornR2);
    	bipedHead.addChild(HornR3);
    	bipedHead.addChild(HornR4);
    	bipedHead.addChild(HeadwearR);
    	bipedHead.addChild(HornL1);
    	bipedHead.addChild(HornL2);
    	bipedHead.addChild(HornL3);
    	bipedHead.addChild(HornL4);
    	bipedHead.addChild(HornL4);
    	bipedHead.addChild(HeadwearL);
    	bipedBody.addChild(Breast);
    	bipedBody.addChild(bipedRightArm);
    	bipedBody.addChild(bipedLeftArm);
    	bipedBody.addChild(bipedRightLeg);
    	bipedBody.addChild(bipedLeftLeg);
    	bipedRightArm.addChild(ArmR1);
    	bipedRightArm.addChild(HandR1);
    	bipedRightArm.addChild(HandR2);
    	bipedLeftArm.addChild(ArmL1);
    	bipedLeftArm.addChild(HandL1);
    	bipedLeftArm.addChild(HandL2);
    	bipedRightLeg.addChild(LegR1);
    	bipedRightLeg.addChild(LegR2);
    	bipedRightLeg.addChild(LegR3);
    	bipedRightLeg.addChild(LegR4);
    	bipedRightLeg.addChild(LegR5);
    	bipedRightLeg.addChild(bootR1);
    	bipedRightLeg.addChild(bootR2);
    	bipedLeftLeg.addChild(LegL1);
    	bipedLeftLeg.addChild(LegL2);
    	bipedLeftLeg.addChild(LegL3);
    	bipedLeftLeg.addChild(LegL4);
    	bipedLeftLeg.addChild(LegL5);
    	bipedLeftLeg.addChild(bootL1);
    	bipedLeftLeg.addChild(bootL2);
    	actionPartsInit(f, f1);
    }

    @Override
    public void actionPartsInit(float f, float f1) {
    	rightArm = new Modchu_ModelRenderer(this, 0, 16);
    	rightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, f);
    	rightArm.setRotationPoint(-3.0F, 1.5F, 0.0F);
    	bipedBody.addChild(rightArm);

    	rightArm2 = new Modchu_ModelRenderer(this, 0, 21);
    	rightArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f);
    	rightArm2.setRotationPoint(0.0F, -5.0F, 0.0F);
    	rightArm.addChild(rightArm2);

    	rightHand = new Modchu_ModelRenderer(this, 0, 25);
    	rightHand.addBox(-1.0F, -1.0F, -1.0F, 2, 1, 2, f);
    	rightHand.setRotationPoint(0.0F, 4.0F, 0.0F);
    	rightArm2.addChild(rightHand);

    	leftArm = new Modchu_ModelRenderer(this, 8, 16);
    	leftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, f);
    	leftArm.setRotationPoint(3.0F, 1.5F, 0.0F);
    	bipedBody.addChild(leftArm);

    	leftArm2 = new Modchu_ModelRenderer(this, 8, 21);
    	leftArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f);
    	leftArm2.setRotationPoint(0.0F, -5.0F, 0.0F);
    	leftArm.addChild(leftArm2);

    	leftHand = new Modchu_ModelRenderer(this, 8, 25);
    	leftHand.addBox(-1.0F, -1.0F, -1.0F, 2, 1, 2, f);
    	leftHand.setRotationPoint(0.0F, 4.0F, 0.0F);
    	leftArm2.addChild(leftHand);

    	rightLeg = new Modchu_ModelRenderer(this, 32, 13);
    	rightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 4, f);
    	rightLeg.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
    	bipedBody.addChild(rightLeg);

    	rightLeg2 = new Modchu_ModelRenderer(this, 32, 18);
    	rightLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, f);
    	rightLeg2.setRotationPoint(0.0F, 0.0F, 0.0F);
    	rightLeg.addChild(rightLeg2);

    	leftLeg = new Modchu_ModelRenderer(this, 32, 13);
    	leftLeg.mirror = true;
    	leftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 4, f);
    	leftLeg.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
    	bipedBody.addChild(leftLeg);

    	leftLeg2 = new Modchu_ModelRenderer(this, 32, 18);
    	leftLeg2.mirror = true;
    	leftLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, f);
    	leftLeg2.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
    	leftLeg.addChild(leftLeg2);

    	rightArm2.addChild(ArmR1);
    	rightHand.addChild(HandR1);
    	rightHand.addChild(HandR2);
    	leftArm2.addChild(ArmL1);
    	leftHand.addChild(HandL1);
    	leftHand.addChild(HandL2);
    	rightLeg.addChild(LegR1);
    	rightLeg.addChild(LegR2);
    	rightLeg.addChild(LegR3);
    	rightLeg.addChild(LegR4);
    	rightLeg.addChild(LegR5);
    	rightLeg2.addChild(bootR1);
    	rightLeg2.addChild(bootR2);

    	leftLeg.addChild(LegL1);
    	leftLeg.addChild(LegL2);
    	leftLeg.addChild(LegL3);
    	leftLeg.addChild(LegL4);
    	leftLeg.addChild(LegL5);
    	leftLeg2.addChild(bootL1);
    	leftLeg2.addChild(bootL2);

    	rightArmPlus = new Modchu_ModelRenderer(this);
    	rightArmPlus2 = new Modchu_ModelRenderer(this);
    	leftArmPlus = new Modchu_ModelRenderer(this);
    	leftArmPlus2 = new Modchu_ModelRenderer(this);
    	rightLegPlus = new Modchu_ModelRenderer(this);
    	rightLegPlus2 = new Modchu_ModelRenderer(this);
    	leftLegPlus = new Modchu_ModelRenderer(this);
    	leftLegPlus2 = new Modchu_ModelRenderer(this);
    	rightHand.showModel = leftHand.showModel =
    			rightArm.showModel = leftArm.showModel =
    				rightArmPlus.showModel = rightArmPlus2.showModel =
    					leftArmPlus.showModel = leftArmPlus2.showModel =
    						rightLegPlus.showModel = rightLegPlus2.showModel =
    							leftLegPlus.showModel = leftLegPlus2.showModel =
    								rightArm2.showModel = leftArm2.showModel =
    									rightLeg.showModel = rightLeg2.showModel =
    										leftLeg.showModel = leftLeg2.showModel = false;
    	setCapsValue(caps_aimedBowBan, false);
    	setCapsValue(caps_sneakBan, false);
    	setCapsValue(caps_waitBan, false);
    	setCapsValue(caps_sittingBan, false);
    	setCapsValue(caps_sleepingBan, false);
    	actionRelease1();
    }

    @Override
    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
    	super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);
    	bipedHead.rotationPointY -= 4.0F;
    	bipedBody.rotationPointY -= 7.0F;
    	bipedRightArm.rotationPointY += 4.0F;
    	bipedLeftArm.rotationPointY += 4.0F;
    	bipedRightLeg.rotationPointY += 5.5F;
    	bipedLeftLeg.rotationPointY += 5.5F;
    }

    @Override
    public void actionInit1() {
    	super.actionInit1();
    	bipedLeftArm.isHidden = true;
    	bipedRightArm.isHidden = true;
    	bipedLeftLeg.isHidden = true;
    	bipedRightLeg.isHidden = true;
    	rightHand.isHidden = leftHand.isHidden =
    			rightArm.isHidden = leftArm.isHidden =
    			rightArm2.isHidden = leftArm2.isHidden =
    			rightLeg.isHidden = rightLeg2.isHidden =
    			leftLeg.isHidden = leftLeg2.isHidden = false;
    }

    @Override
    public void actionRelease1() {
    	super.actionRelease1();
    	bipedLeftArm.isHidden = false;
    	bipedRightArm.isHidden = false;
    	bipedLeftLeg.isHidden = false;
    	bipedRightLeg.isHidden = false;
    	rightHand.isHidden = leftHand.isHidden =
    			rightArm.isHidden = leftArm.isHidden =
    			rightArm2.isHidden = leftArm2.isHidden =
    			rightLeg.isHidden = rightLeg2.isHidden =
    			leftLeg.isHidden = leftLeg2.isHidden = true;
    	bootR1.rotationPointY =
    			bootR2.rotationPointY =
    			bootL1.rotationPointY =
    			bootL2.rotationPointY =
    			ArmR1.rotationPointY =
    			ArmL1.rotationPointY =
    			HandR1.rotationPointX =
    			HandR2.rotationPointX =
    			HandR1.rotationPointY =
    			HandR2.rotationPointY =
    			HandL1.rotationPointX =
    			HandL2.rotationPointX =
    			HandL1.rotationPointY =
    			HandL2.rotationPointY = 0.0F;
    }

    @Override
    public void action1(Entity entity) {
    	super.action1(entity);
    	//Modchu_Debug.mDebug("action1");
    	float f1 = bipedBody.rotateAngleZ;
    	if (f1 > 0.0F) {
    		bipedHead.rotationPointY = bipedBody.rotationPointY + 0.5F + (f1 * 1.30889264F);
    	} else {
    		bipedHead.rotationPointY = bipedBody.rotationPointY + 0.5F - (f1 * 1.30889264F);
    	}
    	bipedHead.rotationPointX = 0.0F;
    	rightArm2.rotationPointY = 4.5F;
    	rightLeg.rotationPointX -= 0.5F;
    	rightLeg2.rotationPointY -= 5.0F;
    	rightHand.rotationPointY = 4.0F;
    	ArmR1.rotationPointY = -4.0F;
    	HandR1.rotationPointX =
    			HandR2.rotationPointX = 1.0F;
    	HandR1.rotationPointY =
    			HandR2.rotationPointY = -8.0F;
    	bootR1.rotationPointY = -5.0F;
    	bootR2.rotationPointY = -5.0F;

    	leftArm2.rotationPointY = 4.5F;
    	leftLeg.rotationPointX += 0.5F;
    	leftLeg2.rotationPointY -= 5.0F;
    	leftHand.rotationPointY = 4.0F;
    	HandL1.rotationPointX =
    			HandL2.rotationPointX = 1.0F;
    	HandL1.rotationPointY =
    			HandL2.rotationPointY = -8.0F;
    	ArmL1.rotationPointY = -4.0F;
    	bootL1.rotationPointY = -5.0F;
    	bootL2.rotationPointY = -5.0F;
    }
}
