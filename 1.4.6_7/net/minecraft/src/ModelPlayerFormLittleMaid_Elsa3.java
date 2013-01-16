package net.minecraft.src;

import org.lwjgl.opengl.GL11;

/**
 * 標準意匠
 * 身長1.75ブロック級
 */
public class ModelPlayerFormLittleMaid_Elsa3 extends ModelPlayerFormLittleMaid_SR2 {

    public Modchu_ModelRenderer Ponytail;
    public Modchu_ModelRenderer BunchR;
    public Modchu_ModelRenderer BunchL;
    public Modchu_ModelRenderer SkirtTop2;
    protected float neckPosY;
    protected float bodyPosY;
    protected float legPosY;

    public ModelPlayerFormLittleMaid_Elsa3()
    {
    	this(0.0F);
    }

    public ModelPlayerFormLittleMaid_Elsa3(float f)
    {
    	this(f, 0.0F);
    }

    public ModelPlayerFormLittleMaid_Elsa3(float f, float f1)
    {
    	// 132deletesuper(f, f1);
//-@-132
    	this(f, f1 , 64, 32);
    }

    public ModelPlayerFormLittleMaid_Elsa3(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
//@-@132
    }

    @Override
    public void initModel(float f, float f1) {
    	f1 = 10.0F; //Global to Local
    	bodyPosY = -6.0F; //Local bodyPos = always 0 (ORIGIN)
    	neckPosY = -6F; //Local neckPos = 0 - upper bodyLength
    	legPosY = 9.0F; //Lcal legPos = 0 + lower bodyLength

    	bipedHead = new Modchu_ModelRenderer(this, 0, 0);
    	bipedHead.addBox(-4F, -8F, -4F, 8, 8, 8, f);

    	bipedHeadwear = new Modchu_ModelRenderer(this, 34, -3);
    	bipedHeadwear.addBox(-4F, 0F, 1F, 8, 4, 3, f);
    	bipedHead.addChild(bipedHeadwear);

    	bipedBody = new Modchu_ModelRenderer(this, 32, 4);
    	bipedBody.addBox(-3F, 0F, -2F, 6, 9, 4, f);

    	bipedRightArm = new Modchu_ModelRenderer(this, 42, 17);
    	bipedRightArm.addBox(-2F, -1F, -1F, 2, 10, 2, f);
    	bipedBody.addChild(bipedRightArm);

    	bipedLeftArm = new Modchu_ModelRenderer(this, 50, 17);
    	bipedLeftArm.mirror = true;
    	bipedLeftArm.addBox(0F, -1F, -1F, 2, 10, 2, f);
    	bipedBody.addChild(bipedLeftArm);

    	bipedRightLeg = new Modchu_ModelRenderer(this, 28, 17);
    	bipedRightLeg.addBox(-2F, 0F, -2F, 3, 11, 4, f);
    	bipedBody.addChild(bipedRightLeg);

    	bipedLeftLeg = new Modchu_ModelRenderer(this, 28, 17);
    	bipedLeftLeg.mirror = true;
    	bipedLeftLeg.addBox(-1F, 0F, -2F, 3, 11, 4, f);
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

    	eyeR = new Modchu_ModelRenderer(this, 17, 0);
    	eyeR.addPlate(-3.0F, -4F, -4.01F, 2, 3, 0, f);
    	eyeR.setRotationPointLM(0F, 0F, 0F);
    	bipedHead.addChild(eyeR);

    	eyeL = new Modchu_ModelRenderer(this, 21, 0);
    	eyeL.addPlate(1.0F, -4F, -4.01F, 2, 3, 0, f);
    	eyeL.setRotationPointLM(0F, 0F, 0F);
    	bipedHead.addChild(eyeL);

    	Ponytail = new Modchu_ModelRenderer(this, 52, 5);
    	Ponytail.addBox(-1.5F, -1.5F, -1F, 3, 9, 3, f);
    	Ponytail.setRotationPoint(0F, -5.2F, 5F);

    	BunchR = new Modchu_ModelRenderer(this, 58, 18);
    	BunchR.addBox(-1F, -1.3F, -0.8F, 1, 9, 2, f);
    	BunchR.setRotationPoint(-4.5F, -5.5F, 1.7F);

    	BunchL = new Modchu_ModelRenderer(this, 58, 18);
    	BunchL.mirror = true;
    	BunchL.addBox(0F, -1.3F, -0.8F, 1, 9, 2, f);
    	BunchL.setRotationPoint(4.5F, -5.5F, 1.7F);

    	mainFrame = new Modchu_ModelRenderer(this, 0, 0);
    	mainFrame.setRotationPoint(0F, 0F + f1, 0F);
    	mainFrame.addChild(bipedHead);
    	mainFrame.addChild(bipedBody);
    	skirtFloatsInit(f, f1);
    	actionPartsInit(f, f1);
    }

    @Override
    public void reset(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	bipedHeadwear.setRotationPoint(0F, 0F, 0F);
    	bipedBody.setRotationPoint(0F, bodyPosY, 0F);

    	//INIT POSITION
    	bipedHead.setRotationPoint (0F, neckPosY, 0F);
    	HeadMount.setRotationPoint (0F, 0F, 0F);
    	eyeR.setRotationPointLM (0F, 0F, 0F);
    	eyeL.setRotationPointLM (0F, 0F, 0F);
    	Ponytail.setRotationPoint (0F, -5.2F, 5F);
    	BunchR.setRotationPoint (-4.5F, -5.5F, 1.7F);
    	BunchL.setRotationPoint ( 4.5F, -5.5F, 1.7F);

    	bipedRightArm.setRotationPoint(-2.0F, 1F, 0F);
    	Arms[0].setRotationPointLM(-0.5F, 8.5F, 0F);
    	bipedLeftArm.setRotationPoint ( 2.0F, 1F, 0F);
    	Arms[1].setRotationPoint(0.5F, 8.5F, 0F);

    	bipedRightLeg.setRotationPoint(-1.2F, legPosY, 0F);
    	bipedLeftLeg.setRotationPoint ( 1.2F, legPosY, 0F);

    	Skirt.setRotationPoint (0F, legPosY, 0F);

    	bipedBody.setRotationPoint (0F, bodyPosY, 0F);

    	//INIT ROTATION
    	bipedHead.rotateAngleX = 0F;
    	bipedHead.rotateAngleY = 0F;
    	bipedHead.rotateAngleZ = 0F;
		 Ponytail.rotateAngleX = 0.05F;
		 Ponytail.rotateAngleY = 0F;
		 Ponytail.rotateAngleZ = 0F;
		 BunchR.rotateAngleX = 0F;
		 BunchR.rotateAngleY = 0F;
		 BunchR.rotateAngleZ = 0.05F;
		 BunchL.rotateAngleX = 0F;
		 BunchL.rotateAngleY = 0F;
		 BunchL.rotateAngleZ = -0.05F;

		//bipedRightArm.rotateAngleX = 0F;
		bipedRightArm.rotateAngleY = 0F;
		bipedRightArm.rotateAngleZ = 0F;
		 Arms[0].rotateAngleX = 0F;
		 Arms[0].rotateAngleY = 0F;
		 Arms[0].rotateAngleZ = 0F;
		//bipedLeftArm.rotateAngleX  = 0F;
		bipedLeftArm.rotateAngleY  = 0F;
		bipedLeftArm.rotateAngleZ  = 0F;
		 Arms[1].rotateAngleX = 0F;
		 Arms[1].rotateAngleY = 0F;
		 Arms[1].rotateAngleZ = 0F;

		bipedRightLeg.rotateAngleX = 0.05F;
		bipedRightLeg.rotateAngleY = 0.1F;
		bipedRightLeg.rotateAngleZ =-0.05F;
		bipedLeftLeg.rotateAngleX  = 0.05F;
		bipedLeftLeg.rotateAngleY  =-0.1F;
		bipedLeftLeg.rotateAngleZ  = 0.05F;

		Skirt.rotateAngleX = 0F;
		Skirt.rotateAngleY = 0F;
		Skirt.rotateAngleZ = 0F;

		bipedBody.rotateAngleX =-0.05F;
		bipedBody.rotateAngleY = 0F;
		bipedBody.rotateAngleZ = 0F;
    }

    public void skirtFloatsInit(float f, float f1) {
    	if(!skirtFloats) return;
    	//上
    	SkirtTop2 = new Modchu_ModelRenderer(this, 6, 16);
    	SkirtTop2.addPlate(0.0F, 0.0F, 0.0F, 8, 6, 0);
    	SkirtTop2.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
    	Skirt.addChild(SkirtTop2);

    	//前
    	SkirtFront = new Modchu_ModelRenderer(this, 6, 22);
    	SkirtFront.addPlate(0.0F, 0.0F, 0.0F, 8, 10, 0);
    	SkirtFront.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
    	Skirt.addChild(SkirtFront);

    	//右
    	SkirtRight = new Modchu_ModelRenderer(this, 0, 22);
    	SkirtRight.addPlate(-4.0F, 0.0F, -6.0F, 6, 10, 1);
    	SkirtRight.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
    	Skirt.addChild(SkirtRight);

    	//左
    	SkirtLeft = new Modchu_ModelRenderer(this, 14, 22);
    	SkirtLeft.addPlate(4.0F, 0.0F, -6.0F, 6, 10, 1);
    	SkirtLeft.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
    	Skirt.addChild(SkirtLeft);

    	//後ろ
    	SkirtBack = new Modchu_ModelRenderer(this, 20, 22);
    	SkirtBack.addPlate(0.0F, 0.0F, 0.0F, 8, 10, 0);
    	SkirtBack.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
    	Skirt.addChild(SkirtBack);
    	Skirt.showModel = false;
    }

    /**
     * 姿勢制御・更新差分
     */
    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
    	reset(f, f1, f2, f3, f4, f5, entity);
		//頭部
		bipedHead.rotateAngleY += f3 / 57.29578F;
		bipedHead.rotateAngleX += f4 / 57.29578F;
		//ポニテツインテ
		Ponytail.rotateAngleX += BunchR.rotateAngleX = BunchL.rotateAngleX = -bipedHead.rotateAngleX;
		Ponytail.rotateAngleZ -= bipedHead.rotateAngleZ;
		if (bipedHead.rotateAngleZ > 0)
		{
			BunchR.rotateAngleZ -= bipedHead.rotateAngleZ * 0.2F;
		}
		else
		{
			BunchL.rotateAngleZ -= bipedHead.rotateAngleZ * 0.2F;
		}

		bipedRightArm.rotateAngleZ = 0F;
		//歩行
		bipedRightArm.rotateAngleX = -MathHelper.cos(f * 0.5656F) * 0.8F * f1;
		bipedLeftArm.rotateAngleX = MathHelper.cos(f * 0.5656F) * 0.8F * f1;
		bipedRightLeg.rotateAngleX += MathHelper.cos(f * 0.6662F) * 1.0F * f1;
		bipedLeftLeg.rotateAngleX -= MathHelper.cos(f * 0.6662F) * 1.0F * f1;

		if (getIsRiding())
		{
			// 乗り物に乗っている
			bipedRightArm.rotateAngleX += -0.7F;
			bipedLeftArm.rotateAngleX += -0.7F;
			bipedRightLeg.rotateAngleX -= 1.3F;
			bipedLeftLeg.rotateAngleX -= 1.3F;
			bipedRightLeg.rotateAngleY += 0.4F;
			bipedLeftLeg.rotateAngleY -= 0.4F;
		}

		// アイテム持ってるときの腕振りを抑える+表示角オフセット
		if (heldItemLeft != 0)
		{
			bipedLeftArm.rotateAngleX
				= bipedLeftArm.rotateAngleX * 0.5F - (float)Math.PI * 0.1F * heldItemLeft;
		}
		if (heldItemRight != 0)
		{
			bipedRightArm.rotateAngleX
				= bipedRightArm.rotateAngleX * 0.5F - (float)Math.PI * 0.1F * heldItemRight;
		}

		float onGroundR = getOnGround(getSwingStatus(entity, 0), entity);
		float onGroundL = getOnGround(getSwingStatus(entity, 1), entity);
		//float onGroundR = ((LMM_EntityLittleMaid) entity).getSwingStatus(0).onGround;
		//float onGroundL = ((LMM_EntityLittleMaid) entity).getSwingStatus(1).onGround;

		if ((onGroundR > -9990F || onGroundL > -9990F) && !getaimedBow())
		{
			// 腕振り
			float f6, f7, f8;
			f6 = MathHelper.sin(MathHelper.sqrt_float(onGroundR) * (float)Math.PI * 2.0F);
			f7 = MathHelper.sin(MathHelper.sqrt_float(onGroundL) * (float)Math.PI * 2.0F);
			bipedBody.rotateAngleY = (f6 - f7) * 0.2F;
			Skirt.rotateAngleY = bipedBody.rotateAngleY;
			bipedRightArm.rotateAngleY += bipedBody.rotateAngleY;
			bipedLeftArm.rotateAngleY += bipedBody.rotateAngleY;
			// R
			if (onGroundR > 0F)
			{
				f6 = 1.0F - onGroundR;
				f6 *= f6;
				f6 *= f6;
				f6 = 1.0F - f6;
				f7 = MathHelper.sin(f6 * (float)Math.PI);
				f8 = MathHelper.sin(onGroundR * (float)Math.PI) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
				bipedRightArm.rotateAngleX -= (double)f7 * 1.2D + (double)f8;
				bipedRightArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
				bipedRightArm.rotateAngleZ = MathHelper.sin(onGroundR * 3.141593F) * -0.4F;
			}
			else
			{
				bipedRightArm.rotateAngleX += bipedBody.rotateAngleY;
			}
			// L
			if (onGroundL > 0F)
			{
				f6 = 1.0F - onGroundL;
				f6 *= f6;
				f6 *= f6;
				f6 = 1.0F - f6;
				f7 = MathHelper.sin(f6 * (float)Math.PI);
				f8 = MathHelper.sin(onGroundL * (float)Math.PI) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
				bipedLeftArm.rotateAngleX -= (double)f7 * 1.2D + (double)f8;
				bipedLeftArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
				bipedLeftArm.rotateAngleZ = MathHelper.sin(onGroundL * 3.141593F) * 0.4F;
			}
			else
			{
				bipedLeftArm.rotateAngleX += bipedBody.rotateAngleY;
			}
		}
		if (getIsSneak())
		{
			// しゃがみ
			bipedBody.rotateAngleX += 0.5F;
			bipedRightArm.rotateAngleX += 0.2F;
			bipedLeftArm.rotateAngleX += 0.2F;
			bipedHead.rotationPointY += 1.0F; //upper bodyLength * (1 - cos(0.5rad))

			bipedRightLeg.rotationPointZ += 0.25F; //lower bodyLength * sin(0.5rad)
			bipedLeftLeg.rotationPointZ += 0.25F; //lower bodyLength * sin(0.5rad)
			Skirt.rotationPointZ = 0.0F; //lower bodyLength * sin(0.5rad)
			Skirt.rotateAngleX = -0.5F;
			bipedRightLeg.rotateAngleX -= 0.5F;
			bipedLeftLeg.rotateAngleX -= 0.5F;
		}
		else
		{
			// 通常立ち
		}
		if (getIsWait())
		{
			//待機状態の特別表示
			bipedRightArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F -0.6F;
			bipedRightArm.rotateAngleZ -= 0.4F;
			Arms[0].rotateAngleZ -= 1.5F;
			Arms[0].rotateAngleX -= 0.5F;
			Arms[0].rotateAngleY += 1.5F;
			bipedLeftArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F -0.6F;
			bipedLeftArm.rotateAngleZ += 0.4F;
			Arms[1].rotateAngleZ += 1.5F;
			Arms[1].rotateAngleX -= 0.5F;
			Arms[1].rotateAngleY -= 1.5F;
		}
		else
		{
			if (getaimedBow())
			{
				// 弓構え
				float f6 = MathHelper.sin(onGround * 3.141593F);
				float f7 = MathHelper.sin((1.0F - (1.0F - onGround) * (1.0F - onGround)) * 3.141593F);
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
				bipedLeftArm.rotateAngleX += bipedHead.rotateAngleX;
				bipedRightArm.rotateAngleY += bipedHead.rotateAngleY;
				bipedLeftArm.rotateAngleY += bipedHead.rotateAngleY;
			} else {
				// 通常
				bipedRightArm.rotateAngleZ += 0.3F;
				bipedLeftArm.rotateAngleZ -= 0.3F;
				bipedRightArm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
				bipedLeftArm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
				bipedRightArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
				bipedLeftArm.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;
			}
		}

		//
		Arms[2].setRotateAngle(-0.78539816339744830961566084581988F - ((Modchu_ModelRenderer) bipedRightArm).getRotateAngleX(), 0F, 0F);
		Arms[3].setRotateAngle(-0.78539816339744830961566084581988F - ((Modchu_ModelRenderer) bipedLeftArm).getRotateAngleX(), 0F, 0F);
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
