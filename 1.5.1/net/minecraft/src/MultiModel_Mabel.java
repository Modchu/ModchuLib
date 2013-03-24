package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class MultiModel_Mabel extends MultiModel {


    public Modchu_ModelRenderer aboveHeadwear;
    public Modchu_ModelRenderer innerBody;
    public Modchu_ModelRenderer innerRightLeg;
    public Modchu_ModelRenderer innerLeftLeg;
    public Modchu_ModelRenderer innerSkirt;
    public Modchu_ModelRenderer bipedHeadwearB;
    public Modchu_ModelRenderer innerSkirtTop;
    public Modchu_ModelRenderer innerSkirtFront;
    public Modchu_ModelRenderer innerSkirtRight;
    public Modchu_ModelRenderer innerSkirtLeft;
    public Modchu_ModelRenderer innerSkirtBack;

    public MultiModel_Mabel()
    {
        this(0.0F);
    }

    public MultiModel_Mabel(float f)
    {
        this(f, 0.0F);
    }

    public MultiModel_Mabel(float f, float f1)
    {
    	this(f, f1 , 64, 32);
    }

    public MultiModel_Mabel(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
    }

    @Override
    public void initModel(float f, float f1) {
    	f1 += 8F;
    	bipedHead = new Modchu_ModelRenderer(this, 0, 0);
    	bipedHead.addBox(-2F, -6F, -2F, 4, 4, 4, f + 2.0F);
    	bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
    	aboveHeadwear = new Modchu_ModelRenderer(this, 0, 8);
    	aboveHeadwear.addBox(-2F, -7F, -2F, 4, 4, 4, f + 2.2F);
    	aboveHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(aboveHeadwear);
    	bipedHeadwearB = new Modchu_ModelRenderer(this, 0, 16);
    	bipedHeadwearB.addBox(-2F, 2.0F, -2F, 4, 4, 4, f + 2.0F);
    	bipedHeadwearB.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(bipedHeadwearB);
    	bipedBody = new Modchu_ModelRenderer(this, 16, 0);
    	bipedBody.addBox(-3F, 0.0F, -2F, 6, 7, 4, f);
    	bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
    	innerBody = new Modchu_ModelRenderer(this, 16, 11);
    	innerBody.addBox(-3F, 0.0F, -2F, 6, 7, 4, f - 0.3F);
    	innerBody.setRotationPoint(0.0F, 0.0F, -0.2F);
    	bipedBody.addChild(innerBody);
    	bipedRightArm = new Modchu_ModelRenderer(this, 28, 22);
    	bipedRightArm.addBox(-2F, -1F, -1F, 2, 8, 2, f);
    	bipedRightArm.setRotationPoint(-3F, 1.5F, 0.0F);
    	bipedBody.addChild(bipedRightArm);
    	bipedLeftArm = new Modchu_ModelRenderer(this, 36, 22);
    	((Modchu_ModelRenderer) bipedLeftArm).setMirror(true);
    	bipedLeftArm.addBox(0.0F, -1F, -1F, 2, 8, 2, f);
    	bipedLeftArm.setRotationPoint(3F, 1.5F, 0.0F);
    	bipedBody.addChild(bipedLeftArm);
    	bipedRightLeg = new Modchu_ModelRenderer(this, 36, 0);
    	bipedRightLeg.addBox(-2F, 0.0F, -2F, 3, 9, 4, f);
    	bipedRightLeg.setRotationPoint(-1F, 7F, 0.0F);
    	bipedBody.addChild(bipedRightLeg);
    	bipedLeftLeg = new Modchu_ModelRenderer(this, 36, 0);
    	((Modchu_ModelRenderer) bipedLeftLeg).setMirror(true);
    	bipedLeftLeg.addBox(-1F, 0.0F, -2F, 3, 9, 4, f);
    	bipedLeftLeg.setRotationPoint(1.0F, 7F, 0.0F);
    	bipedBody.addChild(bipedLeftLeg);
    	innerRightLeg = new Modchu_ModelRenderer(this, 50, 0);
    	innerRightLeg.addBox(-2F, 0.0F, -2F, 3, 9, 4, f - 0.3F);
    	innerRightLeg.setRotationPoint(0.0F, 0.0F, -0.2F);
    	bipedRightLeg.addChild(innerRightLeg);
    	innerLeftLeg = new Modchu_ModelRenderer(this, 50, 0);
    	innerLeftLeg.setMirror(true);
    	innerLeftLeg.addBox(-1F, 0.0F, -2F, 3, 9, 4, f - 0.3F);
    	innerLeftLeg.setRotationPoint(0.0F, 0.0F, -0.2F);
    	bipedLeftLeg.addChild(innerLeftLeg);
    	Skirt = new Modchu_ModelRenderer(this, 0, 24);
    	if (!getCapsValueBoolean(caps_skirtFloats)) Skirt.addBox(-2F, 0.0F, -2F, 4, 4, 4, f + 2.0F);
    	Skirt.setRotationPoint(0.0F, 7F, 0.0F);
    	bipedBody.addChild(Skirt);
    	innerSkirt = new Modchu_ModelRenderer(this, 16, 26);
    	innerSkirt.addBox(-1.5F, 0.0F, -1.5F, 3, 3, 3, f + 1.6F);
    	innerSkirt.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Skirt.addChild(innerSkirt);
    	ChignonB = new Modchu_ModelRenderer(this, 32, 0);
    	ChignonB.addBox(-1F, -6.2F, 3F, 2, 2, 2, f + 1.0F);
    	ChignonB.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(ChignonB);
    	ChignonR = new Modchu_ModelRenderer(this, 12, 0);
    	ChignonR.addBox(-5F, -6F, 0.2F, 2, 2, 2, f + 1.0F);
    	ChignonR.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(ChignonR);
    	ChignonL = new Modchu_ModelRenderer(this, 12, 0);
    	ChignonL.addBox(3F, -6F, 0.2F, 2, 2, 2, f + 1.0F);
    	ChignonL.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(ChignonL);
    	Tail = new Modchu_ModelRenderer(this, 44, 13);
    	Tail.addBox(-1.5F, -6.8F, 4F, 3, 16, 3, f);
    	Tail.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(Tail);
    	SideTailR = new Modchu_ModelRenderer(this, 56, 13);
    	SideTailR.addBox(-2F, -0.5F, 0.25F, 2, 17, 2, f);
    	SideTailR.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(SideTailR);
    	SideTailL = new Modchu_ModelRenderer(this, 56, 13);
    	((Modchu_ModelRenderer) SideTailL).setMirror(true);
    	SideTailL.addBox(0.0F, -0.5F, 0.25F, 2, 17, 2, f);
    	SideTailL.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(SideTailL);
    	mainFrame = new Modchu_ModelRenderer(this, 0, 0);
    	mainFrame.setRotationPoint(0F, 0F + f1, 0F);
    	mainFrame.addChild(bipedHead);
    	mainFrame.addChild(bipedBody);
    	actionPartsInit(f, f1);
    }

    @Override
	public void actionPartsInit(float f, float f1) {
    	rightArm = new Modchu_ModelRenderer(this, 28, 22);
    	rightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f);
    	rightArm.setRotationPoint(-3.0F, 9.5F, 0.0F);
    	bipedBody.addChild(rightArm);

    	rightArmPlus = new Modchu_ModelRenderer(this);
    	//rightArmPlus.setTextureOffset(52, 0).addPlate(-1.0F, -1.0F, -3.01F, 2, 2, 4, f);
    	rightArmPlus.rotateAngleX = 1.570796313F;
    	rightArm.addChild(rightArmPlus);

    	rightArm2 = new Modchu_ModelRenderer(this, 28, 25);
    	rightArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, f);
    	rightArm2.setRotationPoint(0.0F, 2.0F, 0.0F);
    	rightArm.addChild(rightArm2);

    	rightArmPlus2 = new Modchu_ModelRenderer(this);
    	((Modchu_ModelRenderer) rightArmPlus2.setTextureOffset(32, 22)).addPlate(-1.0F, -1.0F, 0.001F, 2, 2, 4, f);
    	((Modchu_ModelRenderer) rightArmPlus2.setTextureOffset(32, 22)).addPlate(-1.0F, -1.0F, -2.001F, 2, 2, 0, f);
    	rightArmPlus2.rotateAngleX = 1.570796313F;
    	rightArm2.addChild(rightArmPlus2);

    	rightHand = new Modchu_ModelRenderer(this, 28, 28);
    	rightHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
    	rightHand.setRotationPoint(0.0F, 3.0F, 0.0F);
    	rightArm2.addChild(rightHand);

    	leftArm = new Modchu_ModelRenderer(this, 36, 22);
    	leftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f);
    	leftArm.setRotationPoint(3.0F, 9.5F, 0.0F);
    	bipedBody.addChild(leftArm);

    	leftArmPlus = new Modchu_ModelRenderer(this);
    	//leftArmPlus.setTextureOffset(40, 22).addPlate(-1.0F, -1.0F, -3.01F, 2, 2, 4, f);
    	leftArmPlus.rotateAngleX = 1.570796313F;
    	leftArm.addChild(leftArmPlus);

    	leftArm2 = new Modchu_ModelRenderer(this, 36, 25);
    	leftArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, f);
    	leftArm2.setRotationPoint(0.0F, 2.0F, 0.0F);
    	leftArm.addChild(leftArm2);

    	leftArmPlus2 = new Modchu_ModelRenderer(this);
    	((Modchu_ModelRenderer) leftArmPlus2.setTextureOffset(40, 22)).addPlate(-1.0F, -1.0F, 0.001F, 2, 2, 4, f);
    	((Modchu_ModelRenderer) leftArmPlus2.setTextureOffset(40, 22)).addPlate(-1.0F, -1.0F, -2.001F, 2, 2, 0, f);
    	leftArmPlus2.rotateAngleX = 1.570796313F;
    	leftArm2.addChild(leftArmPlus2);

    	leftHand = new Modchu_ModelRenderer(this, 36, 28);
    	leftHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
    	leftHand.setRotationPoint(0.0F, 3.0F, 0.0F);
    	leftArm2.addChild(leftHand);

    	rightLeg = new Modchu_ModelRenderer(this, 32, 0);
    	rightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 4, 4, f);
    	rightLeg.setRotationPoint(0.0F, 8.0F, 0.0F);
    	bipedBody.addChild(rightLeg);

    	rightLegPlus = new Modchu_ModelRenderer(this);
    	((Modchu_ModelRenderer) rightLegPlus.setTextureOffset(36, 6)).addPlate(-1.5F, -2.0F, -4.01F, 3, 4, 4, f);
    	rightLegPlus.rotateAngleX = 1.570796313F;
    	rightLeg.addChild(rightLegPlus);

    	rightLeg2 = new Modchu_ModelRenderer(this, 32, 4);
    	rightLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 4, f);
    	rightLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);
    	rightLeg.addChild(rightLeg2);

    	rightLegPlus2 = new Modchu_ModelRenderer(this);
    	((Modchu_ModelRenderer) rightLegPlus2.setTextureOffset(36, 6)).addPlate(-1.5F, -2.0F, 0.01F, 3, 4, 4, f);
    	((Modchu_ModelRenderer) rightLegPlus2.setTextureOffset(39, 6)).addPlate(-1.5F, -2.0F, -5.01F, 3, 4, 4, f);
    	rightLegPlus2.rotateAngleX = 1.570796313F;
    	rightLeg2.addChild(rightLegPlus2);

    	leftLeg = new Modchu_ModelRenderer(this, 32, 0);
    	leftLeg.mirror = true;
    	leftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 4, 4, f);
    	leftLeg.setRotationPoint(0.0F, 8.0F, 0.0F);
    	bipedBody.addChild(leftLeg);

    	leftLegPlus = new Modchu_ModelRenderer(this);
    	leftLegPlus.mirror = true;
    	((Modchu_ModelRenderer) leftLegPlus.setTextureOffset(36, 6)).addPlate(-1.5F, -2.0F, -4.01F, 3, 4, 4, f);
    	leftLegPlus.rotateAngleX = 1.570796313F;
    	leftLeg.addChild(leftLegPlus);

    	leftLeg2 = new Modchu_ModelRenderer(this, 32, 4);
    	leftLeg2.mirror = true;
    	leftLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 4, f);
    	leftLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);
    	leftLeg.addChild(leftLeg2);

    	leftLegPlus2 = new Modchu_ModelRenderer(this);
    	leftLegPlus2.mirror = true;
    	((Modchu_ModelRenderer) leftLegPlus2.setTextureOffset(36, 6)).addPlate(-1.5F, -2.0F, 0.01F, 3, 4, 4, f);
    	((Modchu_ModelRenderer) leftLegPlus2.setTextureOffset(39, 6)).addPlate(-1.5F, -2.0F, -5.01F, 3, 4, 4, f);
    	leftLegPlus2.rotateAngleX = 1.570796313F;
    	leftLeg2.addChild(leftLegPlus2);

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
    }

    @Override
    public void skirtFloatsInit(float f, float f1) {
    	if(!getCapsValueBoolean(caps_skirtFloats)) return;
    	//スカート上
    	SkirtTop = new Modchu_ModelRenderer(this, 4, 24);
    	((Modchu_ModelRenderer) SkirtTop).addPlate(0.0F, 0.0F, 0.0F, 4, 4, 0, f + 2.0F);
    	SkirtTop.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Skirt.addChild(SkirtTop);

    	//スカート前
    	SkirtFront = new Modchu_ModelRenderer(this, 4, 28);
    	((Modchu_ModelRenderer) SkirtFront).addPlate(0.0F, 0.0F, 0.0F, 4, 4, 0, f + 2.0F);
    	SkirtFront.setRotationPoint(0.0F, 0.0F, 0.0F);
    	SkirtTop.addChild(SkirtFront);

    	//スカート右
    	SkirtRight = new Modchu_ModelRenderer(this, 0, 28);
    	((Modchu_ModelRenderer) SkirtRight).addPlate(0.0F, 0.0F, 0.0F, 4, 4, 1, f + 2.0F);
    	SkirtRight.setRotationPoint(0.0F, 0.0F, 0.0F);
    	SkirtTop.addChild(SkirtRight);

    	//スカート左
    	SkirtLeft = new Modchu_ModelRenderer(this, 8, 28);
    	((Modchu_ModelRenderer) SkirtLeft).addPlate(0.0F, 0.0F, 0.0F, 4, 4, 1, f + 2.0F);
    	SkirtLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
    	SkirtTop.addChild(SkirtLeft);

    	//スカート後ろ
    	SkirtBack = new Modchu_ModelRenderer(this, 12, 28);
    	((Modchu_ModelRenderer) SkirtBack).addPlate(0.0F, 0.0F, 0.0F, 4, 4, 0, f + 2.0F);
    	SkirtBack.setRotationPoint(0.0F, 0.0F, 0.0F);
    	SkirtTop.addChild(SkirtBack);

    	//インナースカート上
    	innerSkirtTop = new Modchu_ModelRenderer(this, 4, 24);
    	innerSkirtTop.addPlate(0.0F, 0.0F, 0.0F, 3, 3, 0, f + 1.6F);
    	innerSkirtTop.setRotationPoint(0.0F, 0.0F, 0.0F);
    	innerSkirt.addChild(innerSkirtTop);

    	//インナースカート前
    	innerSkirtFront = new Modchu_ModelRenderer(this, 19, 29);
    	innerSkirtFront.addPlate(0.0F, 0.0F, 0.0F, 3, 3, 0, f + 1.6F);
    	innerSkirtFront.setRotationPoint(0.0F, 0.0F, 0.0F);
    	innerSkirtTop.addChild(innerSkirtFront);

    	//インナースカート右
    	innerSkirtRight = new Modchu_ModelRenderer(this, 16, 29);
    	innerSkirtRight.addPlate(0.0F, 0.0F, 0.0F, 3, 3, 1, f + 1.6F);
    	innerSkirtRight.setRotationPoint(0.0F, 0.0F, 0.0F);
    	innerSkirtTop.addChild(innerSkirtRight);

    	//インナースカート左
    	innerSkirtLeft = new Modchu_ModelRenderer(this, 22, 29);
    	innerSkirtLeft.addPlate(0.0F, 0.0F, 0.0F, 3, 3, 1, f + 1.6F);
    	innerSkirtLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
    	innerSkirtTop.addChild(innerSkirtLeft);

    	//インナースカート後ろ
    	innerSkirtBack = new Modchu_ModelRenderer(this, 25, 29);
    	innerSkirtBack.addPlate(0.0F, 0.0F, 0.0F, 3, 3, 0, f + 1.6F);
    	innerSkirtBack.setRotationPoint(0.0F, 0.0F, 0.0F);
    	innerSkirtTop.addChild(innerSkirtBack);
    	setCapsValue(caps_visible, Skirt, false);
    	setCapsValue(caps_visible, innerSkirt, false);
    }

    @Override
    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);
    	Arms[0].setRotationPoint(-0.5F, 4.5F, 0F);
    	Arms[1].setRotationPoint(0.5F, 4.5F, 0F);
    	bipedBody.rotationPointY -= 3.5F;
    	bipedRightArm.rotationPointY += 4.5F;
    	bipedLeftArm.rotationPointY += 4.5F;
    	bipedRightLeg.rotationPointX = -1.0F;
    	bipedRightLeg.rotationPointY += 3.5F;
    	bipedLeftLeg.rotationPointX = -bipedRightLeg.rotationPointX;
    	bipedLeftLeg.rotationPointY += 3.5F;
    	SideTailR.rotationPointX = -5F;
    	SideTailR.rotationPointY = -6F;
    	SideTailL.rotationPointX = 5F;
    	SideTailL.rotationPointY = -6F;
    	Skirt.rotationPointY += 1.5F;

     	bipedHeadwearB.rotateAngleX = mh_abs(bipedHead.rotateAngleX * 0.5F);
    	float f6 = mh_sin(f2 * 0.09F) * 0.05F + 0.05F;
    	bipedHeadwearB.rotateAngleX = f6;
    	SideTailR.rotateAngleZ = f6;
    	SideTailL.rotateAngleZ = -f6;
    	Tail.rotateAngleX = f6;
    	SideTailL.rotateAngleX = SideTailR.rotateAngleX = -bipedHead.rotateAngleX / 2.0F;
    	if(getCapsValueBoolean(caps_getIsSneak))
    	{
    		// しゃがみ
    		Skirt.rotateAngleX += 0.4F;
    		Skirt.rotationPointZ = 0.0F;
    	}
    	skirtFloats(f, f1, f2, f3, f4, f5, entity);
    }

    @Override
    public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	super.skirtFloats(f, f1, f2, f3, f4, f5, entity);
    	if (!getCapsValueBoolean(caps_skirtFloats)) return;
    	float motionY = getCapsValueFloat(caps_motionY);
    	SkirtBack.rotateAngleX = SkirtRight.rotateAngleX = SkirtLeft.rotateAngleX = SkirtFront.rotateAngleX = 0.0F;
    	SkirtBack.rotateAngleY = SkirtRight.rotateAngleY = SkirtLeft.rotateAngleY = SkirtFront.rotateAngleY = 0.0F;
    	SkirtBack.rotateAngleZ = SkirtRight.rotateAngleZ = SkirtLeft.rotateAngleZ = SkirtFront.rotateAngleZ = 0.0F;
    	innerSkirtTop.rotateAngleX = innerSkirtBack.rotateAngleX = innerSkirtRight.rotateAngleX = innerSkirtLeft.rotateAngleX = innerSkirtFront.rotateAngleX = 0.0F;
    	innerSkirtTop.rotateAngleY = innerSkirtBack.rotateAngleY = innerSkirtRight.rotateAngleY = innerSkirtLeft.rotateAngleY = innerSkirtFront.rotateAngleY = 0.0F;
    	innerSkirtTop.rotateAngleZ = innerSkirtBack.rotateAngleZ = innerSkirtRight.rotateAngleZ = innerSkirtLeft.rotateAngleZ = innerSkirtFront.rotateAngleZ = 0.0F;

    	SkirtTop.setRotationPoint(-2.0F, 0.0F, 2.0F);
    	SkirtFront.setRotationPoint(0.0F, 4.0F, 0.0F);
    	SkirtRight.setRotationPoint(0.0F, 0.0F, 0.0F);
    	SkirtLeft.setRotationPoint(4.0F, 4.0F, 0.0F);
    	SkirtBack.setRotationPoint(0.0F, -4.0F, 0.0F);

    	innerSkirtTop.setRotationPoint(-1.5F, -3.0F, -1.5F);
    	innerSkirtFront.setRotationPoint(0.0F, -3.2F, -5.2F);
    	innerSkirtRight.setRotationPoint(-3.2F, 3.0F, -5.2F);
    	innerSkirtLeft.setRotationPoint(3.0F, 3.0F, -5.2F);
    	innerSkirtBack.setRotationPoint(0.0F, 3.0F, -5.2F);

    	SkirtFront.rotateAngleX = 1.570796313F;
    	SkirtBack.rotateAngleX = 1.570796313F;
    	SkirtRight.rotateAngleX = -1.570796313F;
    	SkirtRight.rotateAngleY = 3.141592653F;
    	SkirtLeft.rotateAngleX = 1.570796313F;
    	SkirtLeft.rotateAngleY = 0.0F;
    	innerSkirtTop.rotateAngleX = 1.570796313F;
    	innerSkirtFront.rotateAngleX = 1.570796313F;
    	innerSkirtRight.rotateAngleX = 1.570796313F;
    	innerSkirtLeft.rotateAngleX = 1.570796313F;
    	innerSkirtBack.rotateAngleX = 1.570796313F;

    	SkirtFront.rotationPointX += motionY * 2.0F;
    	SkirtFront.rotationPointY -= motionY * 1.5F;
    	SkirtFront.rotationPointZ -= motionY * 2.0F;
    	SkirtBack.rotationPointX += motionY * 2.0F;
    	SkirtBack.rotationPointY -= motionY * 1.5F;
    	SkirtBack.rotationPointZ += motionY * 2.0F;
    	SkirtRight.rotationPointX += motionY * 2.0F;
    	SkirtRight.rotationPointZ -= motionY * 2.0F;
    	SkirtRight.rotationPointY += motionY * 2.0F;
    	SkirtLeft.rotationPointX -= motionY;
    	SkirtLeft.rotationPointZ -= motionY * 2.0F;

    	innerSkirtFront.rotationPointX += motionY * 2.0F;
    	innerSkirtFront.rotationPointY += motionY;
    	innerSkirtFront.rotationPointZ -= motionY;
    	innerSkirtBack.rotationPointX += motionY * 2.0F;
    	innerSkirtBack.rotationPointY -= motionY;
    	innerSkirtBack.rotationPointZ -= motionY;
    	innerSkirtRight.rotationPointX += motionY * 2.0F;
    	innerSkirtRight.rotationPointY -= motionY * 2.0F;
    	innerSkirtRight.rotationPointZ -= motionY * 2.0F;
    	innerSkirtLeft.rotationPointX -= motionY * 2.0F;

    	SkirtFront.rotateAngleX += motionY;
    	SkirtBack.rotateAngleX -= motionY;
    	SkirtRight.rotateAngleY += motionY;
    	SkirtLeft.rotateAngleY -= motionY;

    	innerSkirtFront.rotateAngleX += motionY;
    	innerSkirtBack.rotateAngleX -= motionY;
    	innerSkirtRight.rotateAngleY -= motionY / 2.0F;
    	innerSkirtRight.rotateAngleZ += motionY / 2.0F;
    	innerSkirtLeft.rotateAngleY += motionY / 2.0F;
    	innerSkirtFront.scaleX = innerSkirtBack.scaleX = 1.0F - (motionY * 1.0F);
    	innerSkirtRight.scaleZ = innerSkirtLeft.scaleZ = 1.0F - (motionY * 1.0F);
    }

    @Override
    public void defaultPartsSettingBefore() {
    	super.defaultPartsSettingBefore();
		String[] s = {
				"innerSkirtTop", "innerSkirtFront", "innerSkirtRight", "innerSkirtLeft", "innerSkirtLeft"
		};
		showPartsHideListadd(s);
    	String[] s1 = {
    			"aboveHeadwear" , "innerRightLeg", "innerLeftLeg", "bipedHeadwearB"
    	};
    	String[] s2 = {
    			"a_Headwear" , "innerRLeg", "innerLLeg", "HeadwearB"
    	};
    	addShowPartsReneme(s1, s2);
    }

    @Override
    public void showModelSettingReflects() {
    	super.showModelSettingReflects();
    	if (getCapsValueBoolean(caps_skirtFloats)) {
    		setCapsValue(caps_visible, innerSkirt, false);
    	}
    }

    @Override
    public float getHeight()
    {
    	return 1.35F;
    }

    @Override
    public float getWidth()
    {
    	return 0.6F;
    }

    @Override
    public void actionInit1() {
    	super.actionInit1();
    	((Modchu_ModelRenderer) bipedLeftLeg).removeChild(innerLeftLeg);
    	((Modchu_ModelRenderer) bipedRightLeg).removeChild(innerRightLeg);
    	leftLeg.addChild(innerLeftLeg);
    	rightLeg.addChild(innerRightLeg);
    	bipedLeftLeg.isHidden = true;
    	bipedRightLeg.isHidden = true;
    }

    @Override
    public void actionRelease1() {
    	super.actionRelease1();
    	bipedLeftLeg.addChild(innerLeftLeg);
    	bipedRightLeg.addChild(innerRightLeg);
    	((Modchu_ModelRenderer) leftLeg).removeChild(innerLeftLeg);
    	((Modchu_ModelRenderer) rightLeg).removeChild(innerRightLeg);
    	bipedLeftLeg.isHidden = false;
    	bipedRightLeg.isHidden = false;
    }

    @Override
    public void action1(Entity entity) {
    	super.action1(entity);
    	float f1 = bipedBody.rotateAngleZ;
    	if (f1 > 0.0F) {
    		bipedHead.rotationPointY = bipedBody.rotationPointY + 0.5F + (f1 * 1.30889264F);
    	} else {
    		bipedHead.rotationPointY = bipedBody.rotationPointY + 0.5F - (f1 * 1.30889264F);
    	}
    	bipedHead.rotationPointX = 0.0F;
    	Arms[0].setRotationPoint(0.5F, 0.0F, 0F);
    	Arms[1].setRotationPoint(-0.5F, 0.0F, 0F);
    }
}
