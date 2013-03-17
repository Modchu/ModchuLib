package net.minecraft.src;

import java.util.Random;
import org.lwjgl.opengl.GL11;

public class MultiModel_Elsa2 extends MultiModel_SR2 {

    public MultiModel_Elsa2()
    {
    	this(0.0F);
    }

    public MultiModel_Elsa2(float f)
    {
    	this(f, 0.0F);
    }

    public MultiModel_Elsa2(float f, float f1)
    {
    	this(f, f1 , 64, 32);
    }

    public MultiModel_Elsa2(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
    }

    @Override
    public void initModel(float f, float f1) {
    	bipedHead = new Modchu_ModelRenderer(this, 0, 0);
    	bipedHead.addBox(-4F, -8F, -4F, 8, 8, 8, f);
    	bipedHead.setRotationPoint(0F, 4F, 0F);

    	bipedHeadwear = new Modchu_ModelRenderer(this, 34, -3);
    	bipedHeadwear.addBox(-4F, 0F, 1F, 8, 4, 3, f);
    	bipedHeadwear.setRotationPoint(0F, 0F, 0F);
    	bipedHead.addChild(bipedHeadwear);

    	bipedBody = new Modchu_ModelRenderer(this, 32, 4);
    	bipedBody.addBox(-3F, 0F, -2F, 6, 9, 4, f);
    	bipedBody.setRotationPoint(0F, 4.5F, 0F);

    	bipedRightArm = new Modchu_ModelRenderer(this, 42, 17);
    	bipedRightArm.addBox(-2F, -1F, -1F, 2, 10, 2, f);
    	bipedRightArm.setRotationPoint(-3F, 1.0F, 0F);
    	bipedBody.addChild(bipedRightArm);

    	bipedLeftArm = new Modchu_ModelRenderer(this, 50, 17);
    	bipedLeftArm.mirror = true;
    	bipedLeftArm.addBox(0F, -1F, -1F, 2, 10, 2, f);
    	bipedLeftArm.setRotationPoint(3F, 1.0F, 0F);
    	bipedBody.addChild(bipedLeftArm);

    	bipedRightLeg = new Modchu_ModelRenderer(this, 28, 17);
    	bipedRightLeg.addBox(-2F, 0F, -2F, 3, 11, 4, f);
    	bipedRightLeg.setRotationPoint(-1F, 6F, 0F);
    	bipedBody.addChild(bipedRightLeg);

    	bipedLeftLeg = new Modchu_ModelRenderer(this, 28, 17);
    	bipedLeftLeg.mirror = true;
    	bipedLeftLeg.addBox(-1F, 0F, -2F, 3, 11, 4, f);
    	bipedLeftLeg.setRotationPoint(1F, 6F, 0F);
    	bipedBody.addChild(bipedLeftLeg);

    	Skirt = new Modchu_ModelRenderer(this, 0, 16);
    	Skirt.addBox(-4F, -3F, -3F, 8, 10, 6, f);
    	Skirt.setRotationPoint(0F, 13F, 0F);
    	bipedBody.addChild(Skirt);

    	ChignonR = new Modchu_ModelRenderer(this, 0, 2);
    	ChignonR.addBox(-5F, -7F, 0.2F, 1, 3, 3, f);
    	ChignonR.setRotationPoint(0F, 0F, 0F);
    	bipedHead.addChild(ChignonR);

    	ChignonL = new Modchu_ModelRenderer(this, 0, 2);
    	ChignonL.mirror = true;
    	ChignonL.addBox(4F, -7F, 0.2F, 1, 3, 3, f);
    	ChignonL.setRotationPoint(0F, 0F, 0F);
    	bipedHead.addChild(ChignonL);

    	ChignonB = new Modchu_ModelRenderer(this, 24, 2);
    	ChignonB.addBox(-2F, -7.2F, 4F, 4, 4, 2, f);
    	ChignonB.setRotationPoint(0F, 0F, 0F);
    	bipedHead.addChild(ChignonB);

    	Tail = new Modchu_ModelRenderer(this, 52, 5);
    	Tail.addBox(-1.5F, -1.5F, -1F, 3, 9, 3, f);
    	Tail.setRotationPoint(0F, -5.2F, 5F);
    	bipedHead.addChild(Tail);

    	SideTailR = new Modchu_ModelRenderer(this, 58, 18);
    	SideTailR.addBox(-1F, -1.3F, -0.8F, 1, 9, 2, f);
    	SideTailR.setRotationPoint(-4.5F, -5.5F, 1.7F);
    	bipedHead.addChild(SideTailR);

    	SideTailL = new Modchu_ModelRenderer(this, 58, 18);
    	SideTailL.mirror = true;
    	SideTailL.addBox(0F, -1.3F, -0.8F, 1, 9, 2, f);
    	SideTailL.setRotationPoint(4.5F, -5.5F, 1.7F);
    	bipedHead.addChild(SideTailL);

    	// ’Ç‰Áƒp[ƒc
    	eyeR = new Modchu_ModelRenderer(this, 17, 0);
    	eyeR.addPlate(-3.0F, -4F, -4.01F, 2, 3, 0, f);
    	eyeR.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	eyeL = new Modchu_ModelRenderer(this, 21, 0);
    	eyeL.addPlate(1.0F, -4F, -4.01F, 2, 3, 0, f);
    	eyeL.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(eyeR);
    	bipedHead.addChild(eyeL);
    	mainFrame = new Modchu_ModelRenderer(this, 0, 0);
    	mainFrame.setRotationPoint(0F, 0F + f1, 0F);
    	mainFrame.addChild(bipedHead);
    	mainFrame.addChild(bipedBody);
    	actionPartsInit(f, f1);
    }

    @Override
    public void actionPartsInit(float f, float f1) {
    	rightArm = new Modchu_ModelRenderer(this, 42, 17);
    	rightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, f);
    	rightArm.setRotationPoint(-3.0F, 9.5F, 0.0F);
    	bipedBody.addChild(rightArm);

    	rightArmPlus = new Modchu_ModelRenderer(this);

    	rightArm2 = new Modchu_ModelRenderer(this, 42, 22);
    	rightArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, f);
    	rightArm2.setRotationPoint(0.0F, 5.0F, 0.0F);
    	rightArm.addChild(rightArm2);

    	rightArmPlus2 = new Modchu_ModelRenderer(this);

    	rightHand = new Modchu_ModelRenderer(this, 42, 25);
    	rightHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
    	rightHand.setRotationPoint(0.0F, 3.0F, 0.0F);
    	rightArm2.addChild(rightHand);

    	leftArm = new Modchu_ModelRenderer(this, 50, 17);
    	leftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, f);
    	leftArm.setRotationPoint(3.0F, 9.5F, 0.0F);
    	bipedBody.addChild(leftArm);

    	leftArmPlus = new Modchu_ModelRenderer(this);

    	leftArm2 = new Modchu_ModelRenderer(this, 50, 22);
    	leftArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, f);
    	leftArm2.setRotationPoint(0.0F, 2.0F, 0.0F);
    	leftArm.addChild(leftArm2);

    	leftArmPlus2 = new Modchu_ModelRenderer(this);

    	leftHand = new Modchu_ModelRenderer(this, 50, 25);
    	leftHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
    	leftHand.setRotationPoint(0.0F, 3.0F, 0.0F);
    	leftArm2.addChild(leftHand);

    	rightLeg = new Modchu_ModelRenderer(this, 28, 17);
    	rightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 4, f);
    	rightLeg.setRotationPoint(0.0F, 8.0F, 0.0F);
    	bipedBody.addChild(rightLeg);

    	rightLegPlus = new Modchu_ModelRenderer(this);

    	rightLeg2 = new Modchu_ModelRenderer(this, 28, 22);
    	rightLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, f);
    	rightLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);
    	rightLeg.addChild(rightLeg2);

    	rightLegPlus2 = new Modchu_ModelRenderer(this);

    	leftLeg = new Modchu_ModelRenderer(this, 28, 17);
    	leftLeg.mirror = true;
    	leftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 4, f);
    	leftLeg.setRotationPoint(0.0F, 8.0F, 0.0F);
    	bipedBody.addChild(leftLeg);

    	leftLegPlus = new Modchu_ModelRenderer(this);
    	leftLegPlus.mirror = true;
    	((Modchu_ModelRenderer) leftLegPlus.setTextureOffset(36, 19)).addPlate(-1.5F, -2.0F, -4.01F, 3, 4, 4, f);
    	leftLegPlus.rotateAngleX = 1.570796313F;
    	leftLeg.addChild(leftLegPlus);

    	leftLeg2 = new Modchu_ModelRenderer(this, 28, 22);
    	leftLeg2.mirror = true;
    	leftLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, f);
    	leftLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);
    	leftLeg.addChild(leftLeg2);

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
    }

    @Override
    public void skirtFloatsInit(float f, float f1) {
    	if(!getCapsValueBoolean(caps_skirtFloats)) return;
    	//ã
    	SkirtTop = new Modchu_ModelRenderer(this, 6, 16);
    	((Modchu_ModelRenderer) SkirtTop).addPlate(0.0F, 0.0F, 0.0F, 8, 6, 0);
    	SkirtTop.setRotationPoint(0.0F, 8.0F, 0.0F);
    	Skirt.addChild(SkirtTop);

    	//‘O
    	SkirtFront = new Modchu_ModelRenderer(this, 6, 22);
    	((Modchu_ModelRenderer) SkirtFront).addPlate(0.0F, 0.0F, 0.0F, 8, 10, 0);
    	SkirtFront.setRotationPoint(0.0F, 8.0F, 0.0F);
    	Skirt.addChild(SkirtFront);

    	//‰E
    	SkirtRight = new Modchu_ModelRenderer(this, 0, 22);
    	((Modchu_ModelRenderer) SkirtRight).addPlate(-4.0F, 0.0F, -6.0F, 6, 10, 1);
    	SkirtRight.setRotationPoint(0.0F, 8.0F, 0.0F);
    	Skirt.addChild(SkirtRight);

    	//¶
    	SkirtLeft = new Modchu_ModelRenderer(this, 14, 22);
    	((Modchu_ModelRenderer) SkirtLeft).addPlate(4.0F, 0.0F, -6.0F, 6, 10, 1);
    	SkirtLeft.setRotationPoint(0.0F, 8.0F, 0.0F);
    	Skirt.addChild(SkirtLeft);

    	//Œã‚ë
    	SkirtBack = new Modchu_ModelRenderer(this, 20, 22);
    	((Modchu_ModelRenderer) SkirtBack).addPlate(0.0F, 0.0F, 0.0F, 8, 10, 0);
    	SkirtBack.setRotationPoint(0.0F, 8.0F, 0.0F);
    	Skirt.addChild(SkirtBack);
    	setCapsValue(caps_visible, Skirt, false);
    }

    @Override
    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);
    	Arms[0].setRotationPoint(-0.7F, 8.5F, 0F);
    	Arms[1].setRotationPoint(0.7F, 8.5F, 0F);
    	bipedHead.rotationPointY += 4.0F;
    	bipedBody.rotationPointY += 1.0F;
    	bipedRightArm.rotationPointX += 1.0F;
    	bipedLeftArm.rotationPointX -= 1.0F;
    	bipedRightArm.rotationPointY += 4.5F;
    	bipedLeftArm.rotationPointY += 4.5F;
    	bipedRightLeg.rotationPointX = -1.0F;
    	bipedLeftLeg.rotationPointX = 1.0F;
    	bipedRightLeg.rotationPointY += 5.0F;
    	bipedLeftLeg.rotationPointY += 5.0F;
    	Skirt.rotationPointY += 3.5F;
    	bipedRightArm.rotateAngleX = MathHelper.cos(f * 0.5656F + 3.141593F) * 1.6F * f1 * 0.5F;
    	bipedLeftArm.rotateAngleX = MathHelper.cos(f * 0.5656F) * 1.6F * f1 * 0.5F;
    	bipedRightLeg.rotateAngleX = MathHelper.cos(f * 0.5656F) * 1.0F * f1;
    	bipedLeftLeg.rotateAngleX = MathHelper.cos(f * 0.5656F + 3.141593F) * 1.0F * f1;

    	if(getCapsValueBoolean(caps_getIsRiding))
    	{
    		// æ‚è•¨‚Éæ‚Á‚Ä‚¢‚é
    		bipedRightArm.rotateAngleX += -0.6283185F;
    		bipedLeftArm.rotateAngleX += -0.6283185F;
    		bipedRightLeg.rotateAngleX = -1.256637F;
    		bipedLeftLeg.rotateAngleX = -1.256637F;
    	}
    	// ƒAƒCƒeƒ€Ž‚Á‚Ä‚é‚Æ‚«‚Ì˜rU‚è‚ð—}‚¦‚é
    	if(heldItemLeft != 0) {
    		bipedLeftArm.rotateAngleX = bipedLeftArm.rotateAngleX * 0.5F - 0.3141593F * (float)heldItemLeft;
    	}
    	if(heldItemRight != 0) {
    		bipedRightArm.rotateAngleX = bipedRightArm.rotateAngleX * 0.5F - 0.3141593F * (float)heldItemRight;
    	}

    	float onGroundR = getCapsValueFloat(caps_onGround, 0, entity);
    	float onGroundL = getCapsValueFloat(caps_onGround, 1, entity);
    	if ((onGroundR > -9990F || onGroundL > -9990F) && !getCapsValueBoolean(caps_aimedBow) && !getCapsValueBoolean(caps_oldwalking)) {
    		// ˜rU‚è
    		float f6, f7, f8;
    		f6 = MathHelper.sin(MathHelper.sqrt_float(onGroundR) * (float)Math.PI * 2.0F);
    		f7 = MathHelper.sin(MathHelper.sqrt_float(onGroundL) * (float)Math.PI * 2.0F);
    		// R
    		if (onGroundR > 0F) {
    			f6 = 1.0F - onGroundR;
    			f6 *= f6;
    			f6 *= f6;
    			f6 = 1.0F - f6;
    			f7 = MathHelper.sin(f6 * (float)Math.PI);
    			f8 = MathHelper.sin(onGroundR * (float)Math.PI) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
    			bipedRightArm.rotateAngleX -= (double)f7 * 1.2D + (double)f8;
    		} else {
    			bipedRightArm.rotateAngleX += bipedBody.rotateAngleY;
    		}
    		// L
    		if (onGroundL > 0F) {
    			f6 = 1.0F - onGroundL;
    			f6 *= f6;
    			f6 *= f6;
    			f6 = 1.0F - f6;
    			f7 = MathHelper.sin(f6 * (float)Math.PI);
    			f8 = MathHelper.sin(onGroundL * (float)Math.PI) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
    			bipedLeftArm.rotateAngleX -= (double)f7 * 1.2D + (double)f8;
    		} else {
    			bipedLeftArm.rotateAngleX += bipedBody.rotateAngleY;
    		}
    	}
    	if(getCapsValueBoolean(caps_getIsSneak))
    	{
    		// ‚µ‚á‚ª‚Ý
    		bipedRightLeg.rotateAngleX -= 0.5F;
    		bipedLeftLeg.rotateAngleX -= 0.5F;
        	bipedHead.rotationPointY += 1.0F;
        	bipedBody.rotationPointY += 1.0F;
    	}
    	if (getCapsValueBoolean(caps_getIsWait) && !getCapsValueBoolean(caps_aimedBow)) {
    		//‘Ò‹@ó‘Ô‚Ì“Á•Ê•\Ž¦
    		bipedRightArm.rotateAngleX = MathHelper.sin(f2 * 0.067F) * 0.05F -0.7F;
    		bipedLeftArm.rotateAngleX = MathHelper.sin(f2 * 0.067F) * 0.05F -0.7F;
    	}
    	if (getCapsValueBoolean(caps_aimedBow))
    	{
    		// ‹|\‚¦
    		float f6 = MathHelper.sin(getCapsValueFloat(caps_onGround) * 3.141593F);
    		float f7 = MathHelper.sin((1.0F - (1.0F - getCapsValueFloat(caps_onGround)) * (1.0F - getCapsValueFloat(caps_onGround))) * 3.141593F);
    		bipedRightArm.rotateAngleX = -1.470796F;
    		bipedRightArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
    		bipedRightArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
    		bipedRightArm.rotateAngleX += bipedHead.rotateAngleX;
    		bipedLeftArm.rotateAngleX = bipedRightArm.rotateAngleX + 0.4F;
    	} else {
    		if (!getCapsValueBoolean(caps_getIsWait)) {
    			// ŒÄ‹z ˜r“™
    			bipedRightArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
    			bipedLeftArm.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;
    		}
    	}
    	skirtFloats(f, f1, f2, f3, f4, f5, entity);
    }

    @Override
    public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	if (!getCapsValueBoolean(caps_skirtFloats)) return;
    	float motionY = getCapsValueFloat(caps_motionY);
    	SkirtBack.rotateAngleX = SkirtRight.rotateAngleX = SkirtLeft.rotateAngleX = SkirtFront.rotateAngleX = 0.0F;
    	SkirtBack.rotateAngleY = SkirtRight.rotateAngleY = SkirtLeft.rotateAngleY = SkirtFront.rotateAngleY = 0.0F;
    	SkirtBack.rotateAngleZ = SkirtRight.rotateAngleZ = SkirtLeft.rotateAngleZ = SkirtFront.rotateAngleZ = 0.0F;

    	SkirtTop.setRotationPoint(-4.0F, -3.0F, 3.0F);
    	SkirtFront.setRotationPoint(-4.0F, -3.0F, -2.5F);
    	SkirtRight.setRotationPoint(-8.0F, -3.0F, -2.5F);
    	SkirtLeft.setRotationPoint(0.0F, -3.0F, 3.0F);
    	SkirtBack.setRotationPoint(-4.0F, -3.0F, 3.0F);
    	SkirtFront.rotationPointX += motionY * 4.0F;
    	SkirtBack.rotationPointX += motionY * 4.0F;
    	SkirtRight.rotationPointY += motionY * 2.0F;
    	SkirtRight.rotationPointZ += motionY * 4.0F;
    	SkirtLeft.rotationPointY -= motionY * 2.0F;
    	SkirtLeft.rotationPointZ -= motionY * 4.0F;

    	SkirtRight.rotateAngleY = 3.141592653F;
    	SkirtTop.rotateAngleX = -1.570796313F;
    	SkirtFront.rotateAngleX += motionY;
    	SkirtRight.rotateAngleZ += -motionY / 2.0F;
    	SkirtLeft.rotateAngleZ += motionY / 2.0F;
    	SkirtBack.rotateAngleX += -motionY;

    	((Modchu_ModelRenderer) SkirtFront).scaleX = ((Modchu_ModelRenderer) SkirtBack).scaleX = 1.0F - (motionY * 1.0F);
    	((Modchu_ModelRenderer) SkirtRight).scaleZ = ((Modchu_ModelRenderer) SkirtLeft).scaleZ = 1.0F - (motionY * 1.0F);
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
    	rightArm2.rotationPointY += 1.0F;
    	leftArm2.rotationPointY += 1.0F;
    	bipedHead.rotationPointX = 0.0F;
    	rightLeg.rotationPointX -= 0.5F;
    	leftLeg.rotationPointX += 0.5F;
    	rightLeg2.rotationPointY -= 4.5F;
    	leftLeg2.rotationPointY -= 4.5F;
    	Arms[0].setRotationPoint(-0.7F, 0.0F, 0F);
    	Arms[1].setRotationPoint(0.7F, 0.0F, 0F);
    }

    @Override
    public float getHeight() {
    	return 1.58F;
    }

    @Override
    public float getWidth()
    {
    	return 0.5F;
    }

    @Override
    public float getyOffset() {
    	return 1.4F;
    }

    @Override
    public double getMountedYOffset() {
    	return 0.85D;
    }
}
