package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class MultiModel_Beverly4 extends MultiModel_SR2
{

    public Modchu_ModelRenderer Headwear;
    public Modchu_ModelRenderer Body2;
    public Modchu_ModelRenderer Bodywear;
    public Modchu_ModelRenderer Body3;
    public Modchu_ModelRenderer SkirtR;
    public Modchu_ModelRenderer SkirtL;
    public Modchu_ModelRenderer shield;
    public Modchu_ModelRenderer SkirtTopL;
    public Modchu_ModelRenderer SkirtFrontL;
    public Modchu_ModelRenderer SkirtLeftL;
    public Modchu_ModelRenderer SkirtBackL;

    public MultiModel_Beverly4()
    {
    	this(0.0F);
    }

    public MultiModel_Beverly4(float f)
    {
    	this(f, 0.0F);
    }

    public MultiModel_Beverly4(float f, float f1)
    {
    	this(f, f1 , 64, 64);
    }

    public MultiModel_Beverly4(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
    	((Modchu_ModelRenderer) bipedRightArm).removeChild(Arms[0]);
    	((Modchu_ModelRenderer) bipedRightArm).removeChild(Arms[2]);
    	((Modchu_ModelRenderer) bipedLeftArm).removeChild(Arms[1]);
    	((Modchu_ModelRenderer) bipedLeftArm).removeChild(Arms[3]);
    	rightArm2.addChild(Arms[0]);
    	rightArm2.addChild(Arms[2]);
    	leftArm2.addChild(Arms[1]);
    	leftArm2.addChild(Arms[3]);
    }

    @Override
    public void initModel(float f, float f1) {
    	textureWidth = 64;
    	textureHeight = 64;
    	f = f > 0.0F ? 0.3F : 0.2F;
    	bipedHead = new Modchu_ModelRenderer(this, 0, 0);
    	bipedHead.addBox(-4.0F, -8.5F, -4.0F, 8, 8, 8, f - 0.5F);
    	bipedHead.setTextureOffset(35, 39).addBox(-1.5F, -1.0F, -1.2F, 3, 1, 3, f-0.5F);//neck
    	Headwear = new Modchu_ModelRenderer(this, 32, 0);
    	Headwear.addBox(-4.0F, -9.5F, -4.0F, 8, 12, 8, f);
    	bipedHead.addChild(Headwear);
    	bipedBody = new Modchu_ModelRenderer(this, 20, 28);
    	bipedBody.addBox(-2.5F, 0.0F, -1.5F, 5, 8, 3, f);
    	Body2 = new Modchu_ModelRenderer(this, 28, 20);
    	Body2.addBox(-3.0F, 1.5F, -0.6F, 6, 3, 3, f);
    	Body2.rotateAngleX = -0.7854F;
    	bipedBody.addChild(Body2);
    	Bodywear = new Modchu_ModelRenderer(this, 16, 47);
    	Bodywear.addBox(-3.0F, 0.0F, -2.5F, 6, 8, 5, f + 0.1F);
    	bipedBody.addChild(Bodywear);
    	Body3 = new Modchu_ModelRenderer(this, 16, 39);
    	Body3.addBox(-3.5F, 8.0F, -2.4F, 7, 3, 5, f);
    	bipedBody.addChild(Body3);
    	rightArm = new Modchu_ModelRenderer(this, 0, 41);
    	rightArm.addBox(-2.0F, -1.0F, -1.0F, 2, 7, 2, f + 0.1F);
    	rightArm.rotateAngleZ = 0.08727F;
    	bipedBody.addChild(rightArm);
    	rightArm2 = new Modchu_ModelRenderer(this, 0, 50);
    	rightArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, f);
    	rightArm2.rotateAngleZ = 0.17453F;
    	rightArm.addChild(rightArm2);
    	leftArm = new Modchu_ModelRenderer(this, 8, 41);
    	leftArm.mirror = true;
    	leftArm.addBox(0.0F, -1.0F, -1.0F, 2, 7, 2, f + 0.1F);
    	leftArm.rotateAngleZ = -0.08727F;
    	bipedBody.addChild(leftArm);
    	leftArm2 = new Modchu_ModelRenderer(this, 8, 50);
    	leftArm2.mirror = true;
    	leftArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, f);
    	leftArm2.rotateAngleZ = -0.17453F;
    	leftArm.addChild(leftArm2);
    	rightLeg = new Modchu_ModelRenderer(this, 0, 16);
    	rightLeg.addBox(-2.5F, 0.0F, -2F, 3, 8, 4, f);
    	bipedBody.addChild(rightLeg);
    	rightLeg2 = new Modchu_ModelRenderer(this, 0, 28);
    	rightLeg2.addBox(-1.1F, 0.0F, -1.5F, 2, 10, 3, f + 0.3F);
    	rightLeg.addChild(rightLeg2);
    	leftLeg = new Modchu_ModelRenderer(this, 14, 16);
    	leftLeg.mirror = true;
    	leftLeg.addBox(-0.5F, 0.0F, -2F, 3, 8, 4, f);
    	bipedBody.addChild(leftLeg);
    	leftLeg2 = new Modchu_ModelRenderer(this, 10, 28);
    	leftLeg2.mirror = true;
    	leftLeg2.addBox(-0.9F, 0.0F, -1.5F, 2, 10, 3, f + 0.3F);
    	leftLeg.addChild(leftLeg2);
    	SkirtR = new Modchu_ModelRenderer(this, 40, 20);
    	SkirtR.addBox(-3F, -3F, -3.3F, 5, 12, 7, f);
    	SkirtR.rotateAngleZ = 0.02F;
    	rightLeg.addChild(SkirtR);
    	SkirtL = new Modchu_ModelRenderer(this, 40, 39);
    	SkirtL.mirror = true;
    	SkirtL.addBox(-2F, -3F, -3.3F, 5, 12, 7, f);
    	SkirtL.rotateAngleZ = -0.02F;
    	leftLeg.addChild(SkirtL);

    	// ’Ç‰Áƒp[ƒc
    	eyeR = new Modchu_ModelRenderer(this, 17, 0);
    	eyeR.addPlate(-2.6F, -4.3F, -3.51F, 2, 2, 0, f);
    	eyeR.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	eyeL = new Modchu_ModelRenderer(this, 21, 0);
    	eyeL.addPlate(0.6F, -4.3F, -3.51F, 2, 2, 0, f);
    	eyeL.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(eyeR);
    	bipedHead.addChild(eyeL);

    	shield = new Modchu_ModelRenderer(this, 24, 0);
    	shield.addBox(-3.5F, -7F, -1F, 7, 7, 1, f);
    	shield.setRotationPoint(2.0F, 5F, 0F);
    	shield.rotateAngleX = 0.15F;
    	shield.rotateAngleY = -1.5F;
    	shield.rotateAngleZ = 0.0F;
    	leftArm2.addChild(shield);

    	mainFrame = new Modchu_ModelRenderer(this, 0, 0);
    	mainFrame.setRotationPoint(0F, 0F + f1, 0F);
    	mainFrame.addChild(bipedHead);
    	mainFrame.addChild(bipedBody);

    	bipedRightArm = new Modchu_ModelRenderer(this);
    	bipedLeftArm = new Modchu_ModelRenderer(this);
    	bipedRightLeg = new Modchu_ModelRenderer(this);
    	bipedLeftLeg = new Modchu_ModelRenderer(this);

    	actionPartsInit(f, f1);
    }

    @Override
    public void actionPartsInit(float f, float f1) {
    	rightHand = new Modchu_ModelRenderer(this, 0, 55);
    	rightHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
    	rightArm2.addChild(rightHand);

    	leftHand = new Modchu_ModelRenderer(this, 8, 55);
    	leftHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
    	leftArm2.addChild(leftHand);

    	rightArmPlus = new Modchu_ModelRenderer(this);
    	rightArmPlus2 = new Modchu_ModelRenderer(this);
    	leftArmPlus = new Modchu_ModelRenderer(this);
    	leftArmPlus2 = new Modchu_ModelRenderer(this);
    	rightLegPlus = new Modchu_ModelRenderer(this);
    	rightLegPlus2 = new Modchu_ModelRenderer(this);
    	leftLegPlus = new Modchu_ModelRenderer(this);
    	leftLegPlus2 = new Modchu_ModelRenderer(this);

    	setCapsValue(caps_visible, rightHand, false);
    	setCapsValue(caps_visible, leftHand, false);
    	setCapsValue(caps_aimedBowBan, false);
    	setCapsValue(caps_sneakBan, false);
    	setCapsValue(caps_waitBan, false);
    	setCapsValue(caps_sittingBan, false);
    	setCapsValue(caps_sleepingBan, false);
    }

    public void skirtFloatsInit(float f, float f1) {
    	if(!getCapsValueBoolean(caps_skirtFloats)) return;
    	//SkirtR ã
    	SkirtTop = new Modchu_ModelRenderer(this, 47, 20);
    	((Modchu_ModelRenderer) SkirtTop).addPlate(-2.5F, 0.0F, -3.5F, 5, 7, 0);
    	SkirtTop.setRotationPoint(0.0F, 8.0F, 0.0F);
    	rightLeg.addChild(SkirtTop);

    	//SkirtR ‘O
    	SkirtFront = new Modchu_ModelRenderer(this, 47, 27);
    	((Modchu_ModelRenderer) SkirtFront).addPlate(0.0F, 0.0F, 0.0F, 5, 12, 0);
    	SkirtFront.setRotationPoint(0.0F, 8.0F, 0.0F);
    	SkirtTop.addChild(SkirtFront);

    	//SkirtR ‰E
    	SkirtRight = new Modchu_ModelRenderer(this, 40, 27);
    	((Modchu_ModelRenderer) SkirtRight).addPlate(-3.5F, 0.0F, -6.0F, 7, 12, 1);
    	SkirtRight.setRotationPoint(0.0F, 8.0F, 0.0F);
    	SkirtTop.addChild(SkirtRight);

    	//SkirtR Œã‚ë
    	SkirtBack = new Modchu_ModelRenderer(this, 58, 27);
    	((Modchu_ModelRenderer) SkirtBack).addPlate(0.0F, 0.0F, 0.0F, 5, 12, 0);
    	SkirtBack.setRotationPoint(0.0F, 8.0F, 0.0F);
    	SkirtTop.addChild(SkirtBack);

    	//SkirtL ã
    	SkirtTopL = new Modchu_ModelRenderer(this, 47, 39);
    	SkirtTopL.addPlate(-2.5F, 0.0F, -3.5F, 5, 7, 0);
    	SkirtTopL.setRotationPoint(0.0F, 8.0F, 0.0F);
    	leftLeg.addChild(SkirtTopL);

    	//SkirtL ‘O
    	SkirtFrontL = new Modchu_ModelRenderer(this, 47, 46);
    	SkirtFrontL.addPlate(0.0F, 0.0F, 0.0F, 5, 12, 0);
    	SkirtFrontL.setRotationPoint(0.0F, 8.0F, 0.0F);
    	SkirtTopL.addChild(SkirtFrontL);

    	//SkirtL ¶
    	SkirtLeftL = new Modchu_ModelRenderer(this, 53, 46);
    	SkirtLeftL.addPlate(-3.5F, 0.0F, -6.0F, 7, 12, 1);
    	SkirtLeftL.setRotationPoint(0.0F, 8.0F, 0.0F);
    	SkirtTopL.addChild(SkirtLeftL);

    	//SkirtL Œã‚ë
    	SkirtBackL = new Modchu_ModelRenderer(this, 58, 46);
    	SkirtBackL.addPlate(0.0F, 0.0F, 0.0F, 5, 12, 0);
    	SkirtBackL.setRotationPoint(0.0F, 8.0F, 0.0F);
    	SkirtTopL.addChild(SkirtBackL);

    	SkirtLeft = new Modchu_ModelRenderer(this);
    	((Modchu_ModelRenderer) rightLeg).removeChild(SkirtR);
    	((Modchu_ModelRenderer) leftLeg).removeChild(SkirtL);
    	setCapsValue(caps_visible, SkirtR, false);
    	setCapsValue(caps_visible, SkirtL, false);
    }

    public void setLivingAnimationsLM(EntityLiving entityliving, float f, float f1, float f2)
    {
    	super.setLivingAnimationsLM(entityliving, f, f1, f2);
    	int i = MathHelper.floor_double(entityliving.posX);
    	int j = MathHelper.floor_double(entityliving.boundingBox.maxY + 1.0D);
    	int k = MathHelper.floor_double(entityliving.posZ);

    	if (!entityliving.isSneaking())
    	{
    		isSneak = !entityliving.worldObj.isAirBlock(i, j, k);
    	}

    	//”w•‰‚í‚ê
    	if (entityliving.ridingEntity instanceof EntityPlayer)
    	{
    		rightLeg.rotateAngleY = 0.5F;
    		leftLeg.rotateAngleY = -0.5F;
    	}
    	else
    	{
    		rightLeg.rotateAngleY = 0F;
    		leftLeg.rotateAngleY = 0F;
    	}

    }

    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
    	reset(f, f1, f2, f3, f4, f5, entity);
    	bipedHead.rotateAngleX = f4 / (180F / (float)Math.PI);
    	bipedHead.rotateAngleY = f3 / (180F / (float)Math.PI);
    	bipedBody.rotateAngleX = 0.0F;
    	float f6 = (float)Math.cos(f2 * 0.09F) * 0.05F;
    	rightArm.rotateAngleZ = 0.2F + f6;
    	leftArm.rotateAngleZ = -0.2F - f6;
    	if (getCapsValueBoolean(caps_getIsRiding))
    	{
    		bipedHead.rotationPointY = 1.0F;
    		bipedBody.rotationPointY = 1.0F;
    		rightArm.rotateAngleX = -0.7F;
    		leftArm.rotateAngleX = -0.7F;
    		SkirtL.rotationPointY = -1.0F;
    		SkirtR.rotationPointY = SkirtL.rotationPointY;
    		SkirtL.rotateAngleZ = 0.0F;
    		SkirtR.rotateAngleZ = -SkirtL.rotateAngleZ;
    		if (getCapsValueBoolean(caps_getIsWait))
    		{
    			rightArm2.rotateAngleZ = 0.0F;
    			leftArm2.rotateAngleZ = 0.0F;
    			rightArm2.rotateAngleX = 0.0F;
    			leftArm2.rotateAngleX = 0.0F;
    			rightLeg.rotateAngleX = -0.72F;
    			rightLeg2.rotateAngleX = 2.15F;
    			leftLeg.rotateAngleX = -0.72F;
    			leftLeg2.rotateAngleX = 2.27F;
    		} else {
    			rightArm2.rotateAngleX = -0.1F;
    			leftArm2.rotateAngleX = -0.8F;
    			rightLeg.rotateAngleX = -2.15F;
    			rightLeg2.rotateAngleX = 1.6F;
    			leftLeg.rotateAngleX = -2.1F;
    			leftLeg2.rotateAngleX = 1.5F;
    		}
    	}
    	else if (getCapsValueBoolean(caps_getIsSneak))
    	{
    		bipedBody.rotateAngleX = 0.35F;
    		rightArm.rotateAngleX = 0.3F;
    		rightArm2.rotateAngleX = -0.2F;
    		leftArm.rotateAngleX = 0.3F;
    		leftArm2.rotateAngleX = -0.2F;
    		float f7 = (float)Math.cos(f * 0.8F);
    		float f9 = (float)Math.cos(f * 0.8F - 1.57F);
    		float f11 = f9 >= f7 ? f9 : f7;
    		float f13 = f9 <= f7 ? f9 : f7;
    		rightLeg.rotateAngleX = f7 * 0.4F * f1 - 0.7F;
    		rightLeg2.rotateAngleX = f11 * 0.4F * f1 + 0.7F;
    		leftLeg.rotateAngleX = -f7 * 0.4F * f1 - 0.8F;
    		leftLeg2.rotateAngleX = -f13 * 0.4F * f1 + 0.5F;
    	}
    	else
    	{
    		bipedHead.rotationPointY = -3.2F;
    		float f8 = (float)Math.cos(f * 0.4F);
    		float f10 = (float)Math.cos(f * 0.4F - 1.57F);
    		float f12 = f10 >= f8 ? f10 : f8;
    		float f14 = f10 <= f8 ? f10 : f8;

    		rightArm.rotateAngleX = -f8 * 0.9F * f1;
    		float f15 = rightArm.rotateAngleX > 0.0F ? rightArm.rotateAngleX : -rightArm.rotateAngleX;
    		rightArm2.rotateAngleX = -0.5F * f15;
    		leftArm.rotateAngleX = f8 * 0.9F * f1;
    		f15 = leftArm.rotateAngleX > 0.0F ? leftArm.rotateAngleX : -leftArm.rotateAngleX;
    		leftArm2.rotateAngleX = -0.5F * f15;
    		rightLeg.rotateAngleX = f8 * 1.2F * f1 + 0.06F;
    		rightLeg2.rotateAngleX = f12 * 1.2F * f1 + 0.06F - rightLeg.rotateAngleX;
    		leftLeg.rotateAngleX = -f8 * 1.2F * f1 - 0.06F;
    		leftLeg2.rotateAngleX = -f14 * 1.2F * f1 + 0.06F - leftLeg.rotateAngleX;
    	}

    	//‹|\‚¦ ˜r
    	if(getCapsValueBoolean(caps_aimedBow)){
    		float f15 = (float)Math.sin(getCapsValueFloat(caps_onGround) * 3.141593F);
    		float f16 = (float)Math.sin((1.0F - (1.0F - getCapsValueFloat(caps_onGround)) * (1.0F - getCapsValueFloat(caps_onGround))) * 3.141593F);
    		rightArm2.rotateAngleZ = 0.0F;
    		leftArm2.rotateAngleZ = 0.0F;
    		rightArm2.rotateAngleY = -(0.1F - f15 * 0.6F);
    		leftArm2.rotateAngleY = 0.1F - f15 * 0.6F;
    		rightArm2.rotateAngleX = -1.470796F;
    		leftArm2.rotateAngleX = -1.470796F;
    		rightArm2.rotateAngleX -= f15 * 1.2F - f16 * 0.4F;
    		leftArm2.rotateAngleX -= f15 * 1.2F - f16 * 0.4F;
    		rightArm2.rotateAngleZ += (float)Math.cos(f2 * 0.09F) * 0.05F + 0.05F;
    		leftArm2.rotateAngleZ -= (float)Math.cos(f2 * 0.09F) * 0.05F + 0.05F;
    		rightArm2.rotateAngleX += (float)Math.sin(f2 * 0.067F) * 0.05F;
    		leftArm2.rotateAngleX -= (float)Math.sin(f2 * 0.067F) * 0.05F;
    		rightArm2.rotateAngleX += bipedHead.rotateAngleX;
    		leftArm2.rotateAngleX -= bipedHead.rotateAngleX;
    	}

    	float[] lgrounds = null;
    	float onGroundR = 0;
    	float onGroundL = 0;
    	if (modelCaps != null) {
    		lgrounds = (float[])getCapsValue(caps_Grounds);
    		if (lgrounds != null) {
    			onGroundR = lgrounds[0];
    			onGroundL = lgrounds[1];
    		}
    	}
    	if (lgrounds == null) {
    		onGroundR = onGround;
    	}
    	if ((onGroundR > -9990F || onGroundL > -9990F) && !getCapsValueBoolean(caps_aimedBow) && !getCapsValueBoolean(caps_oldwalking)) {
    		// ˜rU‚è
    		float f15;
    		float f16, f17;
    		f16 = MathHelper.sin(MathHelper.sqrt_float(onGroundR) * (float)Math.PI * 2.0F);
    		f17 = MathHelper.sin(MathHelper.sqrt_float(onGroundL) * (float)Math.PI * 2.0F);
    		bipedBody.rotateAngleY = (f16 - f17) * 0.2F;
    		rightArm.rotateAngleY = bipedBody.rotateAngleY;
    		leftArm.rotateAngleY = bipedBody.rotateAngleY;

    		// R
    		if (onGroundR > 0F) {
    			f15 = 1.0F - onGroundR;
    			f15 *= f15;
    			f15 *= f15;
    			f15 = 1.0F - f15;
    			float f18 = (float)Math.sin(f15 * 3.141593F) * 1.2F;
    			float f8 = (float)Math.sin(getCapsValueFloat(caps_onGround) * 3.141593F) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
    			rightArm.rotateAngleX -= (double)f18 + (double)f8;
    			rightArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
    			rightArm.rotateAngleZ = (float)Math.sin(getCapsValueFloat(caps_onGround) * 3.141593F) * -0.4F;
    		}

    		// L
    		if (onGroundL > 0F) {
    			f15 = 1.0F - onGroundL;
    			f15 *= f15;
    			f15 *= f15;
    			f15 = 1.0F - f15;
    			float f18 = (float)Math.sin(f15 * 3.141593F) * 1.2F;
    			float f8 = (float)Math.sin(getCapsValueFloat(caps_onGround) * 3.141593F) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
    			leftArm.rotateAngleX -= (double)f18 + (double)f8;
    			leftArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
    			leftArm.rotateAngleZ = (float)Math.sin(getCapsValueFloat(caps_onGround) * 3.141593F) * -0.4F;
    		}
    	}

    	//ŒÄ‹z ˜r
    	float fb = (float)Math.cos(f2 * 0.07F) * 0.06F;
    	rightArm.rotateAngleZ = 0.2F + fb;
    	leftArm.rotateAngleZ = -rightArm.rotateAngleZ;

    	if (getCapsValueBoolean(caps_getIsWait) && !getCapsValueBoolean(caps_aimedBow))
    	{
			rightArm.rotateAngleX = (float)Math.sin(f2 * 0.067F) * 0.05F - 0.45F;
    		rightArm.rotateAngleY = 0.0F;
    		rightArm.rotateAngleZ = -0.2F;
    		leftArm.rotateAngleX = rightArm.rotateAngleX;
    		leftArm.rotateAngleY = rightArm.rotateAngleY;
    		leftArm.rotateAngleZ = -rightArm.rotateAngleZ;
    		rightArm2.rotateAngleZ = 0.0F;
    		leftArm2.rotateAngleZ = 0.0F;
    		rightArm2.rotateAngleX = 0.0F;
    		leftArm2.rotateAngleX = 0.0F;
    		if (getCapsValueBoolean(caps_getIsRiding)) {
    			Arms[0].rotationPointX -= 1.0F;
    			Arms[0].rotationPointY -= 2.0F;
    			Arms[0].rotateAngleZ -= 2.0F;
    			Arms[0].rotateAngleX -= 1.5F;
    			Arms[0].rotateAngleY += 1.5F;
    			Arms[1].rotationPointX -= 1.0F;
    			Arms[1].rotationPointY += 2.0F;
    			Arms[1].rotateAngleZ += 2.0F;
    			Arms[1].rotateAngleX -= 1.5F;
    			Arms[1].rotateAngleY += 1.5F;
    		} else {
    			Arms[0].rotationPointX -= 2.0F;
    			Arms[0].rotateAngleZ -= 1.5F;
    			Arms[0].rotateAngleX -= 0.5F;
    			Arms[0].rotateAngleY += 1.5F;
    			Arms[1].rotationPointX += 2.0F;
    			Arms[1].rotateAngleZ += 1.5F;
    			Arms[1].rotateAngleX -= 0.5F;
    			Arms[1].rotateAngleY -= 1.5F;
    		}
    	}
    	skirtFloats(f, f1, f2, f3, f4, f5, entity);
    }

    @Override
    public void setRotationAnglesfirstPerson(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	if (((EntityPlayer) entity).inventory.getCurrentItem() != null) {
    		//’n}‚ðŽ‚Á‚Ä‚¢‚éŽž
    		rightArm.rotationPointX = 0.0F;
    		rightArm.rotationPointY = 1.5F;
    		rightArm.rotationPointZ = 0.0F;
    		leftArm.rotationPointX = -9.5F;
    		leftArm.rotationPointY = 2.0F;
    		leftArm.rotationPointZ = 0.0F;
    	} else {
    		//‘fŽèŽž
    		rightArm.rotateAngleX = 0.0F;
    		rightArm.rotateAngleY = 0.0F;
    		rightArm.rotateAngleZ = 0.5F;
    		leftArm.rotateAngleX = 0.0F;
    		leftArm.rotateAngleY = 0.0F;
    		leftArm.rotateAngleZ = 0.0F;

    		rightArm.rotationPointY = 4.0F;
    		leftArm.rotationPointX = 4.0F;
    		leftArm.rotationPointY = 8.0F;
    		leftArm.rotationPointZ = -2.0F;
    	}
    }

    @Override
    public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	if (!getCapsValueBoolean(caps_skirtFloats)) return;
    	float motionY = getCapsValueFloat(caps_motionY);
    	SkirtTop.rotateAngleX =
    			SkirtTopL.rotateAngleX =
    			SkirtRight.rotateAngleX = -1.570796313F;
    	SkirtTop.rotateAngleZ = 0.1F;
    	SkirtTopL.rotateAngleZ = -0.1F;
    	SkirtRight.rotateAngleY = 3.141592653F;
    	SkirtBack.rotateAngleX =
    			SkirtBackL.rotateAngleX =
    			SkirtFront.rotateAngleX =
    			SkirtFrontL.rotateAngleX =
    			SkirtLeftL.rotateAngleX = 1.570796313F;

    	SkirtFront.rotationPointX =
    			SkirtBack.rotationPointX = -2.5F + motionY * 5.0F;
    	SkirtFrontL.rotationPointX =
    			SkirtBackL.rotationPointX = -2.5F - motionY * 2.0F;
    	SkirtRight.rotationPointY = 6.0F - motionY * 2.0F;
    	SkirtLeftL.rotationPointY = 1.0F + motionY * 2.0F;
    	SkirtRight.rotationPointZ =
    			SkirtLeftL.rotationPointZ = -3.5F + motionY * 2.0F;

    	SkirtFront.rotateAngleX += motionY;
    	SkirtRight.rotateAngleY -= -motionY / 2.0F;
    	SkirtBack.rotateAngleX += -motionY;
    	SkirtFrontL.rotateAngleX += motionY;
    	SkirtLeftL.rotateAngleY -= motionY / 2.0F;
    	SkirtBackL.rotateAngleX += -motionY;

    	((Modchu_ModelRenderer) SkirtFront).scaleX = ((Modchu_ModelRenderer) SkirtBack).scaleX =
    			SkirtFrontL.scaleX = SkirtBackL.scaleX = 1.0F - (motionY * 1.2F);
    	((Modchu_ModelRenderer) SkirtRight).scaleZ =
    			SkirtLeftL.scaleZ = 1.0F - (motionY * 1.2F);
    }

    @Override
    public void reset(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	bipedHead.setRotationPoint(0.0F, -2.0F, 0.0F);
    	bipedBody.setRotationPoint(0.0F, -3.5F, 0.0F);
    	Headwear.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Body2.setRotationPoint(0.0F, 0.0F, 0.0F);
    	Bodywear.setRotationPoint(0.0F, -0.5F, 0.0F);
    	Body3.setRotationPoint(0.0F, 0.0F, 0.0F);
    	rightArm.setRotationPoint(-2.0F, 1.0F, 0.0F);
    	rightArm2.setRotationPoint(-1.0F, 6.0F, 0.0F);
    	rightHand.setRotationPoint(0.0F, 6.4F, 0.0F);
    	leftArm.setRotationPoint(2.0F, 1.0F, 0.0F);
    	leftArm2.setRotationPoint(1.0F, 6.0F, 0.0F);
    	leftHand.setRotationPoint(0.0F, 6.4F, 0.0F);
    	rightLeg.setRotationPoint(-1.0F, 10.0F, 0.0F);
    	rightLeg2.setRotationPoint(-0.5F, 7.0F, 0.0F);
    	leftLeg.setRotationPoint(1.0F, 10.0F, 0.0F);
    	leftLeg2.setRotationPoint(0.5F, 7.0F, 0.0F);
    	SkirtR.setRotationPoint(-0.5F, 1.5F, 0.0F);
    	SkirtL.setRotationPoint(0.0F, 1.5F, 0.0F);
    	if (getCapsValueBoolean(caps_skirtFloats)) {
    		SkirtTop.setRotationPoint(-1.0F, 0.5F, 3.5F);
    		SkirtTopL.setRotationPoint(1.0F, 0.5F, 3.5F);
    		SkirtFront.setRotationPoint(-2.5F, 7.0F, -3.5F);
    		SkirtRight.setRotationPoint(-6.0F, 6.0F, -3.5F);
    		SkirtBack.setRotationPoint(-2.5F, 0.0F, -3.5F);
    		SkirtFrontL.setRotationPoint(-2.5F, 7.0F, -3.5F);
    		SkirtLeftL.setRotationPoint(6.0F, 1.0F, -3.5F);
    		SkirtBackL.setRotationPoint(-2.5F, 0.0F, -3.5F);
    		SkirtBack.rotateAngleX = SkirtRight.rotateAngleX = SkirtFront.rotateAngleX = 0.0F;
    		SkirtBack.rotateAngleY = SkirtRight.rotateAngleY = SkirtFront.rotateAngleY = 0.0F;
    		SkirtBack.rotateAngleZ = SkirtRight.rotateAngleZ = SkirtFront.rotateAngleZ = 0.0F;
    		SkirtBackL.rotateAngleX = SkirtLeftL.rotateAngleX = SkirtFrontL.rotateAngleX = 0.0F;
    		SkirtBackL.rotateAngleY = SkirtLeftL.rotateAngleY = SkirtFrontL.rotateAngleY = 0.0F;
    		SkirtBackL.rotateAngleZ = SkirtLeftL.rotateAngleZ = SkirtFrontL.rotateAngleZ = 0.0F;
    	}
    	SkirtR.rotateAngleZ = 0.14F;
    	SkirtL.rotateAngleZ = -SkirtR.rotateAngleZ;
    	rightArm2.rotateAngleZ = 0.2F;
    	leftArm2.rotateAngleZ = -0.2F;
    	rightLeg.rotateAngleZ = -0.07F;
    	leftLeg.rotateAngleZ = 0.07F;
    	rightLeg2.rotateAngleZ = 0.07F;
    	leftLeg2.rotateAngleZ = -0.07F;
    	shield.setRotationPoint(1.5F, 5F, 0F);
    	Arms[0].setRotationPoint(0.5F, 4.5F, 0F);
    	Arms[1].setRotationPoint(-0.5F, 4.5F, 0F);
    	Arms[0].rotateAngleX = 0F;
    	Arms[0].rotateAngleY = 0F;
    	Arms[0].rotateAngleZ = 0F;
    	Arms[1].rotateAngleX = 0F;
    	Arms[1].rotateAngleY = 0F;
    	Arms[1].rotateAngleZ = 0F;
    }

    @Override
    public void defaultPartsSettingBefore() {
    	super.defaultPartsSettingBefore();
    	String[] s = {
    			"bipedHeadwear", "SkirtR", "SkirtL", "SkirtTopL", "SkirtFrontL",
    			"SkirtLeftL", "SkirtBackL", "d"
    	};
    	showPartsHideListadd(s);
    }

    @Override
    public void showModelSettingReflects() {
    	super.showModelSettingReflects();
    	setCapsValue(caps_indexOfAllVisible, "ightArm", bipedRightArm.showModel);
    	setCapsValue(caps_indexOfAllVisible, "eftArm", bipedLeftArm.showModel);
    	setCapsValue(caps_indexOfAllVisible, "ightLeg", bipedRightLeg.showModel);
    	setCapsValue(caps_indexOfAllVisible, "eftLeg", bipedLeftLeg.showModel);
    	if (getCapsValueBoolean(caps_skirtFloats)) {
    		setCapsValue(caps_visible, SkirtR, false);
    		setCapsValue(caps_visible, SkirtL, false);
    	}
    }

    @Override
    public void actionInit1() {
    	setCapsValue(caps_shortcutKeysAction, true);
    	boolean b = true;
    	setCapsValue(caps_visible, rightArm, b);
    	setCapsValue(caps_visible, rightArm2, b);
    	setCapsValue(caps_visible, rightArmPlus, b);
    	setCapsValue(caps_visible, rightArmPlus2, b);
    	setCapsValue(caps_visible, rightHand, b);
    	setCapsValue(caps_visible, leftArm, b);
    	setCapsValue(caps_visible, leftArm2, b);
    	setCapsValue(caps_visible, leftArmPlus, b);
    	setCapsValue(caps_visible, leftArmPlus2, b);
    	setCapsValue(caps_visible, leftHand, b);
    	setCapsValue(caps_visible, rightLeg, b);
    	setCapsValue(caps_visible, rightLeg2, b);
    	setCapsValue(caps_visible, rightLegPlus, b);
    	setCapsValue(caps_visible, rightLegPlus2, b);
    	setCapsValue(caps_visible, leftLeg, b);
    	setCapsValue(caps_visible, leftLeg2, b);
    	setCapsValue(caps_visible, leftLegPlus, b);
    	setCapsValue(caps_visible, leftLegPlus2, b);
    	setCapsValue(caps_sneakBan, true);
    	setCapsValue(caps_waitBan, true);
    	setCapsValue(caps_sittingBan, true);
    }

	@Override
	public void actionRelease1() {
		setCapsValue(caps_shortcutKeysAction, false);
		boolean b = true;
		setCapsValue(caps_visible, rightArm, b);
		setCapsValue(caps_visible, rightArm2, b);
		setCapsValue(caps_visible, leftArm, b);
  	 	setCapsValue(caps_visible, leftArm2, b);
		b = false;
		setCapsValue(caps_visible, rightArmPlus, b);
		setCapsValue(caps_visible, rightArmPlus2, b);
		setCapsValue(caps_visible, rightHand, b);
		setCapsValue(caps_visible, leftArmPlus, b);
		setCapsValue(caps_visible, leftArmPlus2, b);
		setCapsValue(caps_visible, leftHand, b);

		bipedHead.rotateAngleX = 0.0F;
		bipedHead.rotateAngleY = 0.0F;
		bipedHead.rotateAngleZ = 0.0F;
		bipedBody.rotateAngleX = 0.0F;
		bipedBody.rotateAngleY = 0.0F;
		bipedBody.rotateAngleZ = 0.0F;
		rightHand.rotateAngleX = 0.0F;
		rightHand.rotateAngleY = 0.0F;
		rightHand.rotateAngleZ = 0.0F;
		leftHand.rotateAngleX = 0.0F;
		leftHand.rotateAngleY = 0.0F;
		leftHand.rotateAngleZ = 0.0F;

		setCapsValue(caps_sneakBan, false);
		setCapsValue(caps_waitBan, false);
		setCapsValue(caps_sittingBan, false);
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

		rightArm.rotationPointX = -4.0F;
		rightArm.rotationPointY = 2.0F;
		rightArm2.rotationPointX -= 1.0F;
		rightArm2.rotationPointY += 2.5F;
		rightHand.rotationPointY -= 0.5F;

		leftArm.rotationPointX = 4.0F;
		leftArm.rotationPointY = 3.0F;
		leftArm.rotationPointZ = 0.0F;
		leftArm2.rotationPointX += 1.0F;
		leftArm2.rotationPointY += 2.5F;
		leftHand.rotationPointY -= 0.5F;

		rightLeg.rotationPointX -= 1.0F;
		rightLeg.rotationPointY = 10.0F;
		rightLeg2.rotationPointX -= 0.5F;
		rightLeg2.rotationPointY += 8.5F;
		leftLeg.rotationPointX += 1.0F;
		leftLeg.rotationPointY = 10.0F;
		leftLeg2.rotationPointX += 0.5F;
		leftLeg2.rotationPointY += 8.5F;
	}

    @Override
    public void action4(Entity entity) {
    	// —¼Žè‚ð‘O‚Éo‚·ƒ‚[ƒVƒ‡ƒ“
    	if (getCapsValueFloat(caps_onGround, getCapsValueInt(caps_dominantArm), entity) > 0.0F) {
    		rightArm.rotateAngleX += leftArm.rotateAngleX += -1.57F;
    		rightArm.rotateAngleY = leftArm.rotateAngleY = 0.0F;
    		rightArm.rotateAngleZ = leftArm.rotateAngleZ = 0.0F;
    	} else {
    		rightArm.rotateAngleX = leftArm.rotateAngleX = -1.57F;
    		rightArm.rotateAngleY = leftArm.rotateAngleY = 0.0F;
    		rightArm.rotateAngleZ = leftArm.rotateAngleZ = 0.0F;
    	}
    }

    public float getHeight()
    {
    	return 1.99F;
    }

    public float getWidth()
    {
    	return 0.6F;
    }

    public float getRidingHeight()
    {
    	return 0.99F;
    }

	public float getyOffset() {
	    return 1.81F;
	}

	public float getRidingyOffset() {
	    return 1.61F;
	}

	public double getMountedYOffset() {
		return 0.7D;
	}

	public double getSittingyOffset() {
		return -0.5D;
	}

	@Override
	public void renderFirstPersonHand(float f) {
		bipedBody.postRender(f);
		getBipedRightArm().render(f);
	}

    @Override
    public ModelRenderer getBipedRightArm() {
    	if (getCapsValueInt(caps_dominantArm) == 0) return rightArm;
    	return leftArm;
    }

    @Override
    public void setArmorBipedHeadShowModel(boolean b) {
    	bipedHead.isHidden = !b;
    	super.setArmorBipedHeadShowModel(b);
    }

    @Override
    public void setArmorBipedBodyShowModel(boolean b) {
    	super.setArmorBipedBodyShowModel(b);
    	Body2.isHidden = !b;
    }

    @Override
    public void setArmorBipedRightArmShowModel(boolean b) {
    	super.setArmorBipedRightArmShowModel(b);
    	rightArm.isHidden = !b;
    }

    @Override
    public void setArmorBipedLeftArmShowModel(boolean b) {
    	super.setArmorBipedLeftArmShowModel(b);
    	leftArm.isHidden = !b;
    }

    @Override
    public void setArmorBipedRightLegShowModel(boolean b) {
    	super.setArmorBipedRightLegShowModel(b);
    	rightLeg.isHidden = !b;
    }

    @Override
    public void setArmorBipedLeftLegShowModel(boolean b) {
    	super.setArmorBipedLeftLegShowModel(b);
    	leftLeg.isHidden = !b;
    }
}
