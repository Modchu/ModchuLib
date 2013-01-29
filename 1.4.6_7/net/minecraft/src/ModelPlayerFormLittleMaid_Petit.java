package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class ModelPlayerFormLittleMaid_Petit extends ModelPlayerFormLittleMaid
{
    public Modchu_ModelRenderer Prim;
    public Modchu_ModelRenderer eyeR;
    public Modchu_ModelRenderer eyeL;
    public Modchu_ModelRenderer FaceR;
    public Modchu_ModelRenderer FaceL;
    public Modchu_ModelRenderer rightHandPlus;
    public Modchu_ModelRenderer leftHandPlus;

    public ModelPlayerFormLittleMaid_Petit()
    {
    	this(0.0F);
    }

    public ModelPlayerFormLittleMaid_Petit(float f)
    {
    	this(f, 0.0F);
    }

    public ModelPlayerFormLittleMaid_Petit(float f, float f1)
    {
    	// 132deletesuper(f, f1);
//-@-132
    	this(f, f1 , 64, 32);
    }

    public ModelPlayerFormLittleMaid_Petit(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
//@-@132
    	Arms[0].setRotationPointLM(0.5F, 2.2F, 0F);
    	Arms[1].setRotationPointLM(-0.5F, 2.2F, 0F);
    }

    @Override
    public void initModel(float f, float f1) {
    	f1 += 0.4F;
    	bipedHead = new Modchu_ModelRenderer(this, 0, 0);
    	bipedHead.addBox(-4.0F, -6.0F, -4.0F, 8, 8, 8, f - 2F);
    	bipedHeadwear = new Modchu_ModelRenderer(this, 24, 0);
    	bipedHeadwear.addBox(-2.0F, 0.0F, -1.0F, 4, 5, 3, f);
    	bipedHead.addChild(bipedHeadwear);
    	bipedBody = new Modchu_ModelRenderer(this, 32, 8);
    	bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 7, 4, f - 1.25F);
    	bipedRightArm = new Modchu_ModelRenderer(this, 48, 0);
    	bipedRightArm.addBox(-1.0F, -1.0F, -1.0F, 2, 5, 2, f - 0.5F);
    	bipedBody.addChild(bipedRightArm);
    	bipedLeftArm = new Modchu_ModelRenderer(this, 56, 0);
    	bipedLeftArm.addBox(-1.0F, -1.0F, -1.0F, 2, 5, 2, f - 0.5F);
    	bipedBody.addChild(bipedLeftArm);
    	bipedRightLeg = new Modchu_ModelRenderer(this, 33, 20);
    	bipedRightLeg.addBox(-2.0F, 0.0F, -1.5F, 3, 6, 3, f - 0.5F);
    	bipedBody.addChild(bipedRightLeg);
    	bipedLeftLeg = new Modchu_ModelRenderer(this, 33, 20);
    	bipedLeftLeg.mirror = true;
    	bipedLeftLeg.addBox(-1.0F, 0.0F, -1.5F, 3, 6, 3, f - 0.5F);
    	bipedBody.addChild(bipedLeftLeg);
    	Skirt = new Modchu_ModelRenderer(this, 0, 16);
    	Skirt.addBox(-4.0F, -2.0F, -4.0F, 8, 8, 8, f - 1.9F);
    	bipedBody.addChild(Skirt);
    	ChignonR = new Modchu_ModelRenderer(this, 25, 19);
    	ChignonR.addBox(-2.55F, -3.8F, -0.5F, 1, 2, 2, f - 0.3F);
    	bipedHead.addChild(ChignonR);
    	ChignonL = new Modchu_ModelRenderer(this, 25, 19);
    	ChignonL.addBox(1.6F, -3.8F, -0.5F, 1, 2, 2, f - 0.3F);
    	bipedHead.addChild(ChignonL);
    	ChignonB = new Modchu_ModelRenderer(this, 52, 10);
    	ChignonB.addBox(-1.5F, -4.2F, 0.9F, 3, 3, 2, f - 0.4F);
    	bipedHead.addChild(ChignonB);
    	Tail = new Modchu_ModelRenderer(this, 46, 20);
    	Tail.addBox(-1.5F, -3.9F, 1F, 3, 9, 3, f - 0.8F);
    	bipedHead.addChild(Tail);
    	SideTailR = new Modchu_ModelRenderer(this, 59, 22);
    	SideTailR.addBox(-2.8F, -3.3F, 0.2F, 1, 4, 1, f - 0.1F);
    	bipedHead.addChild(SideTailR);
    	SideTailL = new Modchu_ModelRenderer(this, 59, 22);
    	SideTailL.mirror = true;
    	SideTailL.addBox(1.7F, -3.3F, 0.2F, 1, 4, 1, f - 0.1F);
    	bipedHead.addChild(SideTailL);

    	Prim = new Modchu_ModelRenderer(this, 24, 17);
    	Prim.addPlate(-1.5F, -4.7F, -2.1F, 3, 1, 0, f - 0.3F);
    	bipedHead.addChild(Prim);

    	FaceR = new Modchu_ModelRenderer(this, 29, 16);
    	FaceR.addBox(-2.99F, -3.5F, -3.001F, 4, 4, 3, f - 1F);
    	bipedHead.addChild(FaceR);
    	FaceL = new Modchu_ModelRenderer(this, 39, 16);
    	FaceL.addBox(-0.99F, -3.5F, -3.001F, 4, 4, 3, f - 1F);
    	bipedHead.addChild(FaceL);

    	eyeL = new Modchu_ModelRenderer(this, 0, 16);
    	eyeL.addBox(-1F, 0F, -2.602F, 2, 2, 2, f - 0.6F);
    	bipedHead.addChild(eyeL);

    	eyeR = new Modchu_ModelRenderer(this, 0, 20);
    	eyeR.addBox(-1F, 0F, -2.602F, 2, 2, 2, f - 0.6F);
    	bipedHead.addChild(eyeR);

    	mainFrame = new Modchu_ModelRenderer(this, 0, 0);
    	mainFrame.setRotationPoint(0F, 0F + f1, 0F);
    	mainFrame.addChild(bipedHead);
    	mainFrame.addChild(bipedBody);

    	actionPartsInit(f, f1);
    }

    public void actionPartsInit(float f, float f1) {
    	rightArm = new Modchu_ModelRenderer(this, 48, 0);
    	rightArm.addBox(-1.0F, -1.0F, -1.0F, 2, 3, 2, f - 0.5F);
    	rightArm.setRotationPoint(-1.0F, -0.5F, 0.0F);
    	bipedBody.addChild(rightArm);

    	rightArm2 = new Modchu_ModelRenderer(this, 48, 1);
    	rightArm2.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f - 0.5F);
    	rightArm2.setRotationPoint(0.0F, 3.0F, 0.0F);
    	rightArm.addChild(rightArm2);

    	rightHand = new Modchu_ModelRenderer(this, 48, 3);
    	rightHand.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, f - 0.5F);
    	rightHand.setRotationPoint(0.0F, 3.0F, 0.0F);
    	rightArm2.addChild(rightHand);

    	rightHandPlus = new Modchu_ModelRenderer(this);
    	rightHandPlus.setTextureOffset(52, 5).addPlate(-1.0F, -1.0F, -1.01F, 2, 2, 4, f - 0.5F);
    	rightHandPlus.setRotationPoint(0.0F, 0.0F, 0.0F);
    	rightHandPlus.rotateAngleX = 1.570796313F;
    	rightHand.addChild(rightHandPlus);

    	leftArm = new Modchu_ModelRenderer(this, 56, 0);
    	leftArm.addBox(-1.0F, -1.0F, -1.0F, 2, 3, 2, f - 0.5F);
    	leftArm.setRotationPoint(-1.0F, -0.5F, 0.0F);
    	bipedBody.addChild(leftArm);

    	leftArm2 = new Modchu_ModelRenderer(this, 56, 1);
    	leftArm2.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f - 0.5F);
    	leftArm2.setRotationPoint(0.0F, 3.0F, 0.0F);
    	leftArm.addChild(leftArm2);

    	leftHand = new Modchu_ModelRenderer(this, 56, 3);
    	leftHand.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, f - 0.5F);
    	leftHand.setRotationPoint(0.0F, 3.0F, 0.0F);
    	leftArm2.addChild(leftHand);

    	leftHandPlus = new Modchu_ModelRenderer(this);
    	leftHandPlus.setTextureOffset(60, 5).addPlate(-1.0F, -1.0F, -1.01F, 2, 2, 4, f - 0.5F);
    	leftHandPlus.setRotationPoint(0.0F, 0.0F, 0.0F);
    	leftHandPlus.rotateAngleX = 1.570796313F;
    	leftHand.addChild(leftHandPlus);

    	rightLeg = new Modchu_ModelRenderer(this, 32, 19);
    	rightLeg.addBox(-2.0F, 0.0F, -1.5F, 3, 3, 3, f - 0.5F);
    	rightLeg.setRotationPoint(0.0F, 8.0F, 0.0F);
    	bipedBody.addChild(rightLeg);

    	rightLeg2 = new Modchu_ModelRenderer(this, 32, 23);
    	rightLeg2.addBox(-2.0F, 0.0F, -1.5F, 3, 3, 3, f - 0.5F);
    	rightLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);
    	rightLeg.addChild(rightLeg2);

    	leftLeg = new Modchu_ModelRenderer(this, 32, 19);
    	leftLeg.mirror = true;
    	leftLeg.addBox(-1.0F, 0.0F, -1.5F, 3, 3, 3, f - 0.5F);
    	leftLeg.setRotationPoint(0.0F, 8.0F, 0.0F);
    	bipedBody.addChild(leftLeg);

    	leftLeg2 = new Modchu_ModelRenderer(this, 32, 23);
    	leftLeg2.mirror = true;
    	leftLeg2.addBox(-1.0F, 0.0F, -1.5F, 3, 3, 3, f - 0.5F);
    	leftLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);
    	leftLeg.addChild(leftLeg2);

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
    			leftLeg.showModel = leftLeg2.showModel =
    			rightHandPlus.showModel = leftHandPlus.showModel = false;
    	aimedBowBan = false;
    	sneakBan = false;
    	waitBan = false;
    	sittingBan = false;
    	sleepingBan = false;
    }

    @Override
    public void skirtFloatsInit(float f, float f1) {
    	if(!getSkirtFloats()) return;
    	//ã
    	SkirtTop = new Modchu_ModelRenderer(this, 8, 16);
    	SkirtTop.addPlate(0.0F, 0.0F, 0.0F, 8, 8, 0, f - 1.9F);
    	SkirtTop.setRotationPoint(0.0F, 8.0F, 0.0F);
    	SkirtTop.setRotationPointLM(-4.0F, 5.0F, 4.0F);
    	Skirt.addChild(SkirtTop);

    	//‘O
    	SkirtFront = new Modchu_ModelRenderer(this, 8, 24);
    	SkirtFront.addPlate(0.0F, 0.0F, 0.0F, 8, 8, 0, f - 1.9F);
    	SkirtFront.setRotationPoint(0.0F, 8.0F, 0.0F);
    	SkirtFront.setRotationPointLM(-4.0F, 0.0F, -4.0F);
    	SkirtTop.addChild(SkirtFront);

    	//‰E
    	SkirtRight = new Modchu_ModelRenderer(this, 0, 24);
    	SkirtRight.addPlate(0.0F, 0.0F, 0.0F, 8, 8, 1, f - 1.9F);
    	SkirtRight.setRotationPoint(0.0F, 8.0F, 0.0F);
    	SkirtRight.setRotationPointLM(-4.0F, 0.0F, 4.0F);
    	SkirtTop.addChild(SkirtRight);

    	//¶
    	SkirtLeft = new Modchu_ModelRenderer(this, 16, 24);
    	SkirtLeft.addPlate(0.0F, 0.0F, 0.0F, 8, 8, 1, f - 1.9F);
    	SkirtLeft.setRotationPoint(0.0F, 8.0F, 0.0F);
    	SkirtLeft.setRotationPointLM(4.0F, 0.0F, -4.0F);
    	SkirtTop.addChild(SkirtLeft);

    	//Œã‚ë
    	SkirtBack = new Modchu_ModelRenderer(this, 24, 24);
    	SkirtBack.addPlate(0.0F, 0.0F, 0.0F, 8, 8, 0, f - 1.9F);
    	SkirtBack.setRotationPoint(0.0F, 8.0F, 0.0F);
    	SkirtBack.setRotationPointLM(-4.0F, 0.0F, 4.0F);
    	SkirtTop.addChild(SkirtBack);
    	Skirt.setVisible(false);
    }

    @Override
    public void reset(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	bipedHead.setRotationPoint(0.0F, 15.6F, 0.0F);
    	bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedBody.setRotationPoint(0.0F, 14.6F, 0.0F);
    	bipedRightArm.setRotationPoint(-1.7F, 2.0F, 0.0F);
    	bipedLeftArm.setRotationPoint(1.7F, 2.0F, 0.0F);
    	bipedRightLeg.setRotationPoint(-0.2F, 5.0F, 0.0F);
    	bipedLeftLeg.setRotationPoint(0.2F, 5.0F, 0.0F);
    	Skirt.setRotationPoint(0.0F, 4.0F, 0.0F);
    	ChignonR.setRotationPoint(0.0F, 0.4F, 0.0F);
    	ChignonL.setRotationPoint(0.0F, 0.4F, 0.0F);
    	ChignonB.setRotationPoint(0.0F, 0.4F, 0.0F);
    	Tail.setRotationPoint(0.0F, 0.4F, 0.0F);
    	SideTailR.setRotationPoint(0.0F, 0.4F, 0.0F);
    	SideTailL.setRotationPoint(0.0F, 0.4F, 0.0F);
    	Prim.setRotationPoint(0.0F, 0.4F, 0.0F);
    	FaceR.setRotationPoint(0.0F, 0.0F, 0.0F);
    	FaceL.setRotationPoint(0.0F, 0.0F, 0.0F);
    	eyeL.setRotationPoint(-0.9F, -2.65F, 0.0F);
    	eyeR.setRotationPoint(0.9F, -2.65F, 0.0F);
    }

    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);
    	Arms[0].setRotationPointLM(0.5F, 2.5F, 0F);
    	Arms[1].setRotationPointLM(-0.5F, 2.5F, 0F);
    	bipedHead.rotationPointY = 15.6F;
    	bipedBody.rotationPointY = 14.6F;
    	bipedRightArm.rotationPointX = -1.7F;
    	bipedLeftArm.rotationPointX = 1.7F;
    	bipedRightArm.rotationPointY = bipedLeftArm.rotationPointY = 2.0F;
    	bipedRightLeg.rotationPointY = bipedLeftLeg.rotationPointY = 5.0F;
    	Skirt.rotationPointY = 4.0F;
    	bipedHead.rotationPointZ = 0.0F;
    	if(getIsRiding()) {
    		bipedHead.rotationPointY -= 2.5F;
    		bipedBody.rotationPointY -= 2.5F;
    	}

    	if(getIsSneak()) {
    		bipedHead.rotationPointY += 0.5F;
    		bipedHead.rotationPointZ = 2.0F;
    		Skirt.rotationPointZ = 0.0F;
    	}

    	if(getaimedBow()) {
    		eyeR.setVisible(false);
    		FaceR.setVisible(false);
    	}

    	if( 0 > mh_sin(f2 * 0.1F) * 0.3F + (Math.random() * 0.1F) + 0.18F) {
    		eyeL.setVisible(false);
    		eyeR.setVisible(false);
    		FaceL.setVisible(false);
    		FaceR.setVisible(false);
    	} else {
    		eyeL.setVisible(true);
    		eyeR.setVisible(true);
    		FaceL.setVisible(true);
    		FaceR.setVisible(true);
    	}
    	skirtFloats(f, f1, f2, f3, f4, f5, entity);
    }

    @Override
    public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	SkirtTop.setRotationPointLM(-4.0F, -2.0F, 4.0F);
    	SkirtFront.setRotationPointLM(0.0F, 8.0F, 0.0F);
    	SkirtRight.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	SkirtLeft.setRotationPointLM(8.0F, 8.0F, 0.0F);
    	SkirtBack.setRotationPointLM(0.0F, 3.8F, 0.0F);

    	SkirtFront.rotationPointX += getMotionY() * 4.0F;
    	SkirtFront.rotationPointY += getMotionY() * 2.0F;
    	SkirtFront.rotationPointZ += getMotionY() * 2.0F;
    	SkirtBack.rotationPointX += getMotionY() * 4.0F;
    	SkirtBack.rotationPointY -= getMotionY() * 2.0F;
    	SkirtBack.rotationPointZ -= getMotionY() * 2.0F;
    	SkirtRight.rotationPointX -= getMotionY() * 2.0F;
    	SkirtRight.rotationPointY += getMotionY() * 5.0F;
    	SkirtRight.rotationPointZ += getMotionY() * 3.0F;
    	SkirtLeft.rotationPointX += getMotionY() * 3.0F;
    	SkirtLeft.rotationPointY -= getMotionY() * 2.0F;
    	SkirtLeft.rotationPointZ += getMotionY() * 2.0F;

    	SkirtTop.rotateAngleX = -1.570796313F;
    	SkirtBack.rotateAngleX = 1.570796313F;
    	SkirtFront.rotateAngleX = 1.570796313F;
    	SkirtRight.rotateAngleX = -1.570796313F;
    	SkirtRight.rotateAngleY = 3.141592653F;
    	SkirtLeft.rotateAngleX = 1.570796313F;
    	SkirtFront.rotateAngleX += getMotionY();
    	SkirtRight.rotateAngleX += getMotionY() / 8.0F;
    	SkirtRight.rotateAngleZ = getMotionY() / 8.0F;
    	SkirtRight.rotateAngleY += getMotionY();
    	SkirtLeft.rotateAngleY = -getMotionY();
    	SkirtBack.rotateAngleX -= getMotionY();

    	SkirtFront.scaleX = SkirtBack.scaleX = 1.0F - (getMotionY() * 1.0F);
    	SkirtRight.scaleZ = SkirtLeft.scaleZ = 1.0F - (getMotionY() * 1.0F);
    }

    @Override
    public void actionInit1() {
    	super.actionInit1();
    	rightArmPlus.showModel = rightArmPlus2.showModel =
    			leftArmPlus.showModel = leftArmPlus2.showModel =
    			rightLegPlus.showModel = rightLegPlus2.showModel =
    			leftLegPlus.showModel = leftLegPlus2.showModel = false;
    	rightHandPlus.showModel = leftHandPlus.showModel = true;
    }

    @Override
    public void actionRelease1() {
    	super.actionRelease1();
    	rightArmPlus.showModel = rightArmPlus2.showModel =
    			leftArmPlus.showModel = leftArmPlus2.showModel =
    			rightLegPlus.showModel = rightLegPlus2.showModel =
    			leftLegPlus.showModel = leftLegPlus2.showModel =
    			rightHandPlus.showModel = leftHandPlus.showModel = false;
    	Arms[0].setRotationPointLM(0.5F, 2.2F, 0F);
    	Arms[1].setRotationPointLM(-0.5F, 2.2F, 0F);
    }

    @Override
    public void action1(Entity entity) {
    	super.action1(entity);
    	float f1 = bipedBody.rotateAngleZ;
    	if (f1 > 0.0F) {
    		bipedHead.rotationPointY = bipedBody.rotationPointY + 1.75F + (f1 * 0.52355705F);
    	} else {
    		bipedHead.rotationPointY = bipedBody.rotationPointY + 1.75F + (f1 * 0.52355705F);
    	}
    	bipedHead.rotationPointX = -f1 * 1.30597063F;
    	rightLeg.rotationPointY -= -0.2F + f1 * 0.93283616F;
    	leftLeg.rotationPointY -= -0.5F + f1 * 0.93283616F;
    	rightLeg2.rotationPointY -= 3.0F;
    	leftLeg2.rotationPointY -= 3.5F - f1 * 0.93283616F;
    	rightArm2.rotationPointX = -0.5F;
    	leftArm2.rotationPointX = 0.5F;
    	rightArm2.rotationPointY =
    			leftArm2.rotationPointY = 1.5F;
    	rightHand.rotationPointY =
    			leftHand.rotationPointY = 0.0F;
    }

    @Override
    public float getHeight()
    {
    	return 0.9F;
    }

    @Override
    public float getWidth()
    {
    	return 0.5F;
    }

    @Override
    public float getyOffset() {
    	return 0.7F;
    }

    @Override
    public float getRidingyOffset() {
    	return getyOffset() + 0.4F;
    }

    @Override
    public double getMountedYOffset() {
    	return 1.6D;
    }

    @Override
    public void equippedItemPositionFlower()
    {
    	GL11.glTranslatef(0.0F, -0.25F, 0.0F);
    }

    @Override
    public float Physical_Hammer() {
    	return super.Physical_Hammer() == 1.0F ? 1.3F : super.Physical_Hammer();
    }

}
