package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class ModelPlayerFormLittleMaid_Mabel extends ModelPlayerFormLittleMaid
{

    public Modchu_ModelRenderer aboveHeadwear;
    public Modchu_ModelRenderer innerBody;
    public Modchu_ModelRenderer innerRightLeg;
    public Modchu_ModelRenderer innerLeftLeg;
    public Modchu_ModelRenderer innerSkirt;
    public Modchu_ModelRenderer bipedHeadwearB;
    public Modchu_ModelRenderer SkirtTop2;
    public Modchu_ModelRenderer innerSkirtTop;
    public Modchu_ModelRenderer innerSkirtFront;
    public Modchu_ModelRenderer innerSkirtRight;
    public Modchu_ModelRenderer innerSkirtLeft;
    public Modchu_ModelRenderer innerSkirtBack;

    public ModelPlayerFormLittleMaid_Mabel()
    {
        this(0.0F);
    }

    public ModelPlayerFormLittleMaid_Mabel(float f)
    {
        this(f, 0.0F);
    }

    public ModelPlayerFormLittleMaid_Mabel(float f, float f1)
    {
		// 132deletesuper(f, f1);
//-@-132
		this(f, f1 , 64, 32);
	}

	public ModelPlayerFormLittleMaid_Mabel(float f, float f1, int i, int j) {
		super(f, f1, i, j);
//@-@132
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
    	Skirt.addBox(-2F, 0.0F, -2F, 4, 4, 4, f + 2.0F);
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
    	SideTailL.setMirror(true);
    	SideTailL.addBox(0.0F, -0.5F, 0.25F, 2, 17, 2, f);
    	SideTailL.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(SideTailL);
    	mainFrame = new Modchu_ModelRenderer(this, 0, 0);
    	mainFrame.setRotationPoint(0F, 0F + f1, 0F);
    	mainFrame.addChild(bipedHead);
    	mainFrame.addChild(bipedBody);
    	skirtFloatsInit(f, f1);
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
    	rightArmPlus2.setTextureOffset(32, 22).addPlate(-1.0F, -1.0F, 0.001F, 2, 2, 4, f);
    	rightArmPlus2.setTextureOffset(32, 22).addPlate(-1.0F, -1.0F, -2.001F, 2, 2, 0, f);
    	rightArmPlus2.rotateAngleX = 1.570796313F;
    	rightArm2.addChild(rightArmPlus2);

    	rightHand = new Modchu_ModelRenderer(this, 28, 28);
    	rightHand.addBoxLM(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
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
    	leftArmPlus2.setTextureOffset(40, 22).addPlate(-1.0F, -1.0F, 0.001F, 2, 2, 4, f);
    	leftArmPlus2.setTextureOffset(40, 22).addPlate(-1.0F, -1.0F, -2.001F, 2, 2, 0, f);
    	leftArmPlus2.rotateAngleX = 1.570796313F;
    	leftArm2.addChild(leftArmPlus2);

    	leftHand = new Modchu_ModelRenderer(this, 36, 28);
    	leftHand.addBoxLM(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
    	leftHand.setRotationPoint(0.0F, 3.0F, 0.0F);
    	leftArm2.addChild(leftHand);

    	rightLeg = new Modchu_ModelRenderer(this, 32, 0);
    	rightLeg.addBoxLM(-1.5F, 0.0F, -2.0F, 3, 4, 4, f);
    	rightLeg.setRotationPoint(0.0F, 8.0F, 0.0F);
    	bipedBody.addChild(rightLeg);

    	rightLegPlus = new Modchu_ModelRenderer(this);
    	rightLegPlus.setTextureOffset(36, 6).addPlate(-1.5F, -2.0F, -4.01F, 3, 4, 4, f);
    	rightLegPlus.rotateAngleX = 1.570796313F;
    	rightLeg.addChild(rightLegPlus);

    	rightLeg2 = new Modchu_ModelRenderer(this, 32, 4);
    	rightLeg2.addBoxLM(-1.5F, 0.0F, -2.0F, 3, 5, 4, f);
    	rightLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);
    	rightLeg.addChild(rightLeg2);

    	rightLegPlus2 = new Modchu_ModelRenderer(this);
    	rightLegPlus2.setTextureOffset(36, 6).addPlate(-1.5F, -2.0F, 0.01F, 3, 4, 4, f);
    	rightLegPlus2.setTextureOffset(39, 6).addPlate(-1.5F, -2.0F, -5.01F, 3, 4, 4, f);
    	rightLegPlus2.rotateAngleX = 1.570796313F;
    	rightLeg2.addChild(rightLegPlus2);

    	leftLeg = new Modchu_ModelRenderer(this, 32, 0);
    	leftLeg.mirror = true;
    	leftLeg.addBoxLM(-1.5F, 0.0F, -2.0F, 3, 4, 4, f);
    	leftLeg.setRotationPoint(0.0F, 8.0F, 0.0F);
    	bipedBody.addChild(leftLeg);

    	leftLegPlus = new Modchu_ModelRenderer(this);
    	leftLegPlus.mirror = true;
    	leftLegPlus.setTextureOffset(36, 6).addPlate(-1.5F, -2.0F, -4.01F, 3, 4, 4, f);
    	leftLegPlus.rotateAngleX = 1.570796313F;
    	leftLeg.addChild(leftLegPlus);

    	leftLeg2 = new Modchu_ModelRenderer(this, 32, 4);
    	leftLeg2.mirror = true;
    	leftLeg2.addBoxLM(-1.5F, 0.0F, -2.0F, 3, 5, 4, f);
    	leftLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);
    	leftLeg.addChild(leftLeg2);

    	leftLegPlus2 = new Modchu_ModelRenderer(this);
    	leftLegPlus2.mirror = true;
    	leftLegPlus2.setTextureOffset(36, 6).addPlate(-1.5F, -2.0F, 0.01F, 3, 4, 4, f);
    	leftLegPlus2.setTextureOffset(39, 6).addPlate(-1.5F, -2.0F, -5.01F, 3, 4, 4, f);
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
    	aimedBowBan = false;
    	sneakBan = false;
    	waitBan = false;
    	sittingBan = false;
    	sleepingBan = false;
    }

    @Override
    public void skirtFloatsInit(float f, float f1) {
    	if(!skirtFloats) return;
    	//スカート上
    	SkirtTop2 = new Modchu_ModelRenderer(this, 4, 24);
    	SkirtTop2.addPlate(0.0F, 0.0F, 0.0F, 4, 4, 0, f + 2.0F);
    	SkirtTop2.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Skirt.addChild(SkirtTop2);

    	//スカート前
    	SkirtFront = new Modchu_ModelRenderer(this, 4, 28);
    	SkirtFront.addPlate(0.0F, 0.0F, 0.0F, 4, 4, 0, f + 2.0F);
    	SkirtFront.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Skirt.addChild(SkirtFront);

    	//スカート右
    	SkirtRight = new Modchu_ModelRenderer(this, 0, 28);
    	SkirtRight.addPlate(0.0F, 0.0F, 0.0F, 4, 4, 1, f + 2.0F);
    	SkirtRight.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Skirt.addChild(SkirtRight);

    	//スカート左
    	SkirtLeft = new Modchu_ModelRenderer(this, 8, 28);
    	SkirtLeft.addPlate(0.0F, 0.0F, 0.0F, 4, 4, 1, f + 2.0F);
    	SkirtLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Skirt.addChild(SkirtLeft);

    	//スカート後ろ
    	SkirtBack = new Modchu_ModelRenderer(this, 12, 28);
    	SkirtBack.addPlate(0.0F, 0.0F, 0.0F, 4, 4, 0, f + 2.0F);
    	SkirtBack.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Skirt.addChild(SkirtBack);

    	//インナースカート上
    	innerSkirtTop = new Modchu_ModelRenderer(this, 4, 24);
    	innerSkirtTop.addPlate(0.0F, 0.0F, 0.0F, 3, 3, 0, f + 1.6F);
    	innerSkirtTop.setRotationPoint(0.0F, 0.0F, 0.0F);
    	innerSkirt.addChild(innerSkirtTop);

    	//インナースカート前
    	innerSkirtFront = new Modchu_ModelRenderer(this, 19, 29);
    	innerSkirtFront.addPlate(0.0F, 0.0F, 0.0F, 3, 3, 0, f + 1.6F);
    	innerSkirtFront.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Skirt.addChild(innerSkirtFront);

    	//インナースカート右
    	innerSkirtRight = new Modchu_ModelRenderer(this, 16, 29);
    	innerSkirtRight.addPlate(0.0F, 0.0F, 0.0F, 3, 3, 1, f + 1.6F);
    	innerSkirtRight.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Skirt.addChild(innerSkirtRight);

    	//インナースカート左
    	innerSkirtLeft = new Modchu_ModelRenderer(this, 22, 29);
    	innerSkirtLeft.addPlate(0.0F, 0.0F, 0.0F, 3, 3, 1, f + 1.6F);
    	innerSkirtLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Skirt.addChild(innerSkirtLeft);

    	//インナースカート後ろ
    	innerSkirtBack = new Modchu_ModelRenderer(this, 25, 29);
    	innerSkirtBack.addPlate(0.0F, 0.0F, 0.0F, 3, 3, 0, f + 1.6F);
    	innerSkirtBack.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Skirt.addChild(innerSkirtBack);
    	Skirt.setVisible(false);
    }

    @Override
    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
    	super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);
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
    	if(getIsSneak())
    	{
    		// しゃがみ
    		Skirt.rotateAngleX += 0.4F;
    		Skirt.rotationPointZ = 0.0F;
    	}
    	if (skirtFloats) {
    		Skirt.rotationPointZ = Skirt.rotationPointZ;
    		Skirt.rotateAngleX = Skirt.rotateAngleX;
    		Skirt.rotateAngleY = Skirt.rotateAngleY;
    		Skirt.rotateAngleZ = Skirt.rotateAngleZ;
    		SkirtBack.rotateAngleX = SkirtRight.rotateAngleX = SkirtLeft.rotateAngleX = SkirtFront.rotateAngleX = 0.0F;
    		SkirtBack.rotateAngleY = SkirtRight.rotateAngleY = SkirtLeft.rotateAngleY = SkirtFront.rotateAngleY = 0.0F;
    		SkirtBack.rotateAngleZ = SkirtRight.rotateAngleZ = SkirtLeft.rotateAngleZ = SkirtFront.rotateAngleZ = 0.0F;
    		innerSkirtTop.rotateAngleX = innerSkirtBack.rotateAngleX = innerSkirtRight.rotateAngleX = innerSkirtLeft.rotateAngleX = innerSkirtFront.rotateAngleX = 0.0F;
    		innerSkirtTop.rotateAngleY = innerSkirtBack.rotateAngleY = innerSkirtRight.rotateAngleY = innerSkirtLeft.rotateAngleY = innerSkirtFront.rotateAngleY = 0.0F;
    		innerSkirtTop.rotateAngleZ = innerSkirtBack.rotateAngleZ = innerSkirtRight.rotateAngleZ = innerSkirtLeft.rotateAngleZ = innerSkirtFront.rotateAngleZ = 0.0F;

    		SkirtRight.rotateAngleY = 3.141592653F;
    		innerSkirtRight.rotateAngleY = 3.141592653F;
    		SkirtTop2.rotateAngleX = -1.570796313F;
    		innerSkirtTop.rotateAngleX = -1.570796313F;
    		SkirtTop2.setRotationPoint(-2.0F, 0.0F, 2.0F);
    		SkirtFront.setRotationPoint(-2.0F, 0.0F, -2.0F);
    		SkirtRight.setRotationPoint(-2.0F, 0.0F, 2.0F);
    		SkirtLeft.setRotationPoint(2.0F, 0.0F, -2.0F);
    		SkirtBack.setRotationPoint(-2.0F, 0.0F, 6.0F);
    		innerSkirtTop.setRotationPoint(-1.5F, 1.0F, 1.5F);
    		innerSkirtFront.setRotationPoint(-1.5F, 1.0F, -1.5F);
    		innerSkirtRight.setRotationPoint(-1.5F, 1.0F, 1.5F);
    		innerSkirtLeft.setRotationPoint(1.5F, 1.0F, -1.5F);
    		innerSkirtBack.setRotationPoint(-1.5F, 1.0F, 4.7F);

    		SkirtFront.rotationPointX -= motionY;
    		SkirtFront.rotationPointY += motionY * 2.0F;
    		SkirtFront.rotationPointZ -= motionY * 4.0F;
    		SkirtRight.rotationPointX -= motionY * 6.0F;
    		SkirtRight.rotationPointY += motionY * 2.0F;
    		SkirtLeft.rotationPointX += motionY * 6.0F;
    		SkirtLeft.rotationPointY += motionY * 2.0F;
    		SkirtBack.rotationPointX -= motionY;
    		SkirtBack.rotationPointY += motionY * 2.0F;
    		SkirtBack.rotationPointZ += motionY * 4.0F;

    		innerSkirtFront.rotationPointX -= motionY;
    		innerSkirtFront.rotationPointY += motionY * 2.0F;
    		innerSkirtFront.rotationPointZ -= motionY * 4.0F;
    		innerSkirtRight.rotationPointX -= motionY * 2.0F;
    		innerSkirtRight.rotationPointY += motionY * 6.0F;
    		innerSkirtLeft.rotationPointX += motionY * 2.0F;
    		innerSkirtLeft.rotationPointY += motionY * 6.0F;
    		innerSkirtBack.rotationPointX -= motionY;
    		innerSkirtBack.rotationPointY += motionY * 2.0F;
    		innerSkirtBack.rotationPointZ += motionY * 4.0F;

    		SkirtFront.rotateAngleX += motionY;
    		SkirtRight.rotateAngleZ += -motionY / 2.0F;
    		SkirtLeft.rotateAngleZ += motionY / 2.0F;
    		SkirtBack.rotateAngleX += -motionY;

    		innerSkirtFront.rotateAngleX += motionY;
    		innerSkirtRight.rotateAngleZ += -motionY / 2.0F;
    		innerSkirtLeft.rotateAngleZ += motionY / 2.0F;
    		innerSkirtBack.rotateAngleX += -motionY;
    	}
    }

    @Override
    public void settingShowParts() {
    	super.settingShowParts();
    	//GUI パーツ表示・非表示初期設定
    	//前回の項目から設定
    	overridePartsNumber = 0;
    	int k = getPartsNumber();
    	if(k < 0) k = 0;
    	if(getPartsSetFlag() == 1) {
    		String s[] = {
    				"aboveHeadwear" ,"innerBody", "innerRLeg", "innerLLeg", "innerSkirt",
    				"HeadwearB"
    		};
    		setParts(s, k);
    		setPartsSetFlag(2);
    	}

    	if(getShowModelFlag() == 0) {
    		boolean b = getGuiShowModel(k);
    		aboveHeadwear.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		innerBody.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		innerRightLeg.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		innerLeftLeg.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		innerSkirt.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		bipedHeadwearB.setVisible(b);
    		setShowModelFlag(1);
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
    	leftLeg.removeChild(innerLeftLeg);
    	rightLeg.removeChild(innerRightLeg);
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
    }
}
