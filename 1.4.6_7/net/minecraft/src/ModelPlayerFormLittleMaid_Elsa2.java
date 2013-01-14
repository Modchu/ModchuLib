package net.minecraft.src;

import java.util.Random;
import org.lwjgl.opengl.GL11;

public class ModelPlayerFormLittleMaid_Elsa2 extends ModelPlayerFormLittleMaid_SR2 {

    public Modchu_ModelRenderer SkirtTop2;

    public ModelPlayerFormLittleMaid_Elsa2()
    {
    	this(0.0F);
    }

    public ModelPlayerFormLittleMaid_Elsa2(float f)
    {
    	this(f, 0.0F);
    }

    public ModelPlayerFormLittleMaid_Elsa2(float f, float f1)
    {
    	// 132deletesuper(f, f1);
//-@-132
    	this(f, f1 , 64, 32);
    }

    public ModelPlayerFormLittleMaid_Elsa2(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
//@-@132
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

    	// í«â¡ÉpÅ[Éc
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
    	skirtFloatsInit(f, f1);
    	actionPartsInit(f, f1);
    }

    public void skirtFloatsInit(float f, float f1) {
    	if(!skirtFloats) return;
    	//è„
    	SkirtTop2 = new Modchu_ModelRenderer(this, 6, 16);
    	SkirtTop2.addPlate(0.0F, 0.0F, 0.0F, 8, 6, 0);
    	SkirtTop2.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
    	Skirt.addChild(SkirtTop2);

    	//ëO
    	SkirtFront = new Modchu_ModelRenderer(this, 6, 22);
    	SkirtFront.addPlate(0.0F, 0.0F, 0.0F, 8, 10, 0);
    	SkirtFront.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
    	Skirt.addChild(SkirtFront);

    	//âE
    	SkirtRight = new Modchu_ModelRenderer(this, 0, 22);
    	SkirtRight.addPlate(-4.0F, 0.0F, -6.0F, 6, 10, 1);
    	SkirtRight.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
    	Skirt.addChild(SkirtRight);

    	//ç∂
    	SkirtLeft = new Modchu_ModelRenderer(this, 14, 22);
    	SkirtLeft.addPlate(4.0F, 0.0F, -6.0F, 6, 10, 1);
    	SkirtLeft.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
    	Skirt.addChild(SkirtLeft);

    	//å„ÇÎ
    	SkirtBack = new Modchu_ModelRenderer(this, 20, 22);
    	SkirtBack.addPlate(0.0F, 0.0F, 0.0F, 8, 10, 0);
    	SkirtBack.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
    	Skirt.addChild(SkirtBack);
    	Skirt.showModel = false;
    }

    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
    	bipedHead.rotateAngleY = f3 / 57.29578F;
    	bipedHead.rotateAngleX = f4 / 57.29578F;
    	bipedRightArm.rotateAngleX = MathHelper.cos(f * 0.5656F + 3.141593F) * 1.6F * f1 * 0.5F;
    	bipedLeftArm.rotateAngleX = MathHelper.cos(f * 0.5656F) * 1.6F * f1 * 0.5F;
    	bipedRightArm.rotateAngleZ = 0.0F;
    	bipedLeftArm.rotateAngleZ = 0.0F;
    	bipedRightLeg.rotateAngleX = MathHelper.cos(f * 0.5656F) * 1.0F * f1;
    	bipedLeftLeg.rotateAngleX = MathHelper.cos(f * 0.5656F + 3.141593F) * 1.0F * f1;
    	bipedRightLeg.rotateAngleY = 0.0F;
    	bipedLeftLeg.rotateAngleY = 0.0F;

    	if(getIsRiding())
    	{
    		// èÊÇËï®Ç…èÊÇ¡ÇƒÇ¢ÇÈ
    		bipedRightArm.rotateAngleX += -0.6283185F;
    		bipedLeftArm.rotateAngleX += -0.6283185F;
    		bipedRightLeg.rotateAngleX = -1.256637F;
    		bipedLeftLeg.rotateAngleX = -1.256637F;
    		bipedRightLeg.rotateAngleY = 0.3141593F;
    		bipedLeftLeg.rotateAngleY = -0.3141593F;
    	}
    	// ÉAÉCÉeÉÄéùÇ¡ÇƒÇÈÇ∆Ç´ÇÃòrêUÇËÇó}Ç¶ÇÈ
    	if(heldItemLeft != 0) {
    		bipedLeftArm.rotateAngleX = bipedLeftArm.rotateAngleX * 0.5F - 0.3141593F * (float)heldItemLeft;
    	}
    	if(heldItemRight != 0) {
    		bipedRightArm.rotateAngleX = bipedRightArm.rotateAngleX * 0.5F - 0.3141593F * (float)heldItemRight;
    	}

    	bipedRightArm.rotateAngleY = 0.0F;
    	bipedLeftArm.rotateAngleY = 0.0F;
    	if(getOnGround() > -9990F && !getaimedBow())
    	{
    		// òrêUÇË
    		float f6 = getOnGround();
    		bipedBody.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f6) * 3.141593F * 2.0F) * 0.2F;
    		//Skirt.rotateAngleY = bipedBody.rotateAngleY;
    		bipedRightArm.rotationPointZ = MathHelper.sin(bipedBody.rotateAngleY) * 4F;
    		bipedRightArm.rotationPointX = -MathHelper.cos(bipedBody.rotateAngleY) * 4F + 1.0F;
    		bipedLeftArm.rotationPointZ = -MathHelper.sin(bipedBody.rotateAngleY) * 4F;
    		bipedLeftArm.rotationPointX = MathHelper.cos(bipedBody.rotateAngleY) * 4F - 1.0F;
    		bipedRightArm.rotateAngleY += bipedBody.rotateAngleY;
    		bipedLeftArm.rotateAngleY += bipedBody.rotateAngleY;
    		bipedLeftArm.rotateAngleX += bipedBody.rotateAngleY;
    		f6 = 1.0F - getOnGround();
    		f6 *= f6;
    		f6 *= f6;
    		f6 = 1.0F - f6;
    		float f7 = MathHelper.sin(f6 * 3.141593F);
    		float f8 = MathHelper.sin(getOnGround() * 3.141593F) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
    		bipedRightArm.rotateAngleX -= (double)f7 * 1.2D + (double)f8;
    		bipedRightArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
    		bipedRightArm.rotateAngleZ = MathHelper.sin(getOnGround() * 3.141593F) * -0.4F;
    	}
    	if(getIsSneak())
    	{
    		// ÇµÇ·Ç™Ç›
    		bipedBody.rotateAngleX = 0.5F;
    		Skirt.rotateAngleX = -0.5F;
    		bipedRightLeg.rotateAngleX -= 0.5F;
    		bipedLeftLeg.rotateAngleX -= 0.5F;
    		bipedHead.rotationPointY = 5.5F;
    		bipedBody.rotationPointY = 5.0F;
    		bipedBody.rotationPointZ = 1.5F;
    		bipedRightLeg.rotationPointY = bipedLeftLeg.rotationPointY = 9.0F - 1.0F;
    		bipedRightLeg.rotationPointZ = bipedLeftLeg.rotationPointZ = 0.25F;
    		Skirt.rotationPointY = 9.0F - 0.5F;
    		Skirt.rotationPointZ = 0.0F;
    	} else
    	{
    		// í èÌóßÇø
    		bipedBody.rotateAngleX = 0.0F;
    		Skirt.rotationPointZ = 0.0F;
    		Skirt.rotateAngleX = 0.0F;
    		Skirt.rotationPointY = 9.0F;
    		bipedHead.rotationPointY = 4.0F;
    		bipedBody.rotationPointY = 4.5F;
    		bipedBody.rotationPointZ = 0.0F;
    		bipedRightLeg.rotationPointY = bipedLeftLeg.rotationPointY = 9.0F;
    	}
    	if (getIsWait() && !getaimedBow()) {
    		//ë“ã@èÛë‘ÇÃì¡ï ï\é¶
    		bipedRightArm.rotateAngleX = MathHelper.sin(f2 * 0.067F) * 0.05F -0.7F;
    		bipedRightArm.rotateAngleY = 0.0F;
    		bipedRightArm.rotateAngleZ = -0.4F;
    		bipedLeftArm.rotateAngleX = MathHelper.sin(f2 * 0.067F) * 0.05F -0.7F;
    		bipedLeftArm.rotateAngleY = 0.0F;
    		bipedLeftArm.rotateAngleZ = 0.4F;
    	}
    	if (getaimedBow())
    	{
    		// ã|ç\Ç¶
    		float f6 = MathHelper.sin(getOnGround() * 3.141593F);
    		float f7 = MathHelper.sin((1.0F - (1.0F - getOnGround()) * (1.0F - getOnGround())) * 3.141593F);
    		bipedRightArm.rotateAngleZ = 0.0F;
    		bipedLeftArm.rotateAngleZ = 0.0F;
    		bipedRightArm.rotateAngleY = -(0.1F - f6 * 0.6F);
    		bipedLeftArm.rotateAngleY = 0.1F - f6 * 0.6F;
    		bipedRightArm.rotateAngleX = -1.470796F;
    		bipedLeftArm.rotateAngleX = -1.470796F;
    		bipedRightArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
    		bipedLeftArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
    		bipedRightArm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
    		bipedLeftArm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
    		bipedRightArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
    		bipedLeftArm.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;
    		bipedRightArm.rotateAngleX += bipedHead.rotateAngleX;
    		bipedLeftArm.rotateAngleX -= bipedHead.rotateAngleX;
    		bipedRightArm.rotateAngleY += bipedHead.rotateAngleY;
    		bipedLeftArm.rotateAngleY += bipedHead.rotateAngleY;
    	} else {
    		if (!getIsWait()) {
    			// åƒãz òrìô
    			bipedRightArm.rotateAngleZ += 0.3F;
    			bipedLeftArm.rotateAngleZ -= 0.3F;
    			bipedRightArm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
    			bipedLeftArm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
    			bipedRightArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
    			bipedLeftArm.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;
    		}
    	}
    	if (skirtFloats) {
    		SkirtBack.rotateAngleX = SkirtRight.rotateAngleX = SkirtLeft.rotateAngleX = SkirtFront.rotateAngleX = 0.0F;
    		SkirtBack.rotateAngleY = SkirtRight.rotateAngleY = SkirtLeft.rotateAngleY = SkirtFront.rotateAngleY = 0.0F;
    		SkirtBack.rotateAngleZ = SkirtRight.rotateAngleZ = SkirtLeft.rotateAngleZ = SkirtFront.rotateAngleZ = 0.0F;

    		SkirtRight.rotateAngleY = 3.141592653F;
    		SkirtTop2.rotateAngleX = -1.570796313F;
    		SkirtTop2.setRotationPoint(-4.0F, -3.0F, 3.0F);
    		SkirtFront.setRotationPoint(-4.0F, -3.0F, -2.5F);
    		SkirtRight.setRotationPoint(-8.0F, -3.0F, -2.5F);
    		SkirtLeft.setRotationPoint(0.0F, -3.0F, 3.0F);
    		SkirtBack.setRotationPoint(-4.0F, -3.0F, 3.0F);
    		SkirtFront.rotationPointX -= motionY;
    		SkirtFront.rotationPointY += motionY * 2.0F;
    		SkirtFront.rotationPointZ -= motionY * 4.0F;
    		SkirtRight.rotationPointX -= motionY * 4.0F;
    		SkirtRight.rotationPointY += motionY * 2.0F;
    		SkirtLeft.rotationPointX += motionY * 4.0F;
    		SkirtLeft.rotationPointY += motionY * 2.0F;
    		SkirtBack.rotationPointX -= motionY;
    		SkirtBack.rotationPointY += motionY * 2.0F;
    		SkirtBack.rotationPointZ += motionY * 4.0F;

    		SkirtFront.rotateAngleX += motionY;
    		SkirtRight.rotateAngleZ += -motionY / 2.0F;
    		SkirtLeft.rotateAngleZ += motionY / 2.0F;
    		SkirtBack.rotateAngleX += -motionY;
    	}
    }

    public float getHeight() {
    	return 1.58F;
    }

    public float getWidth()
    {
    	return 0.5F;
    }

    public float getyOffset() {
    	return 1.4F;
    }

    public double getMountedYOffset() {
    	return 0.85D;
    }

    public float firstPersonY() {
    	return 0.0F;
    }

}
