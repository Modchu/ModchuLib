package net.minecraft.src;

import java.util.Random;
import org.lwjgl.opengl.GL11;

public class MultiModel_Evelyn3 extends MultiModel_SR2 {

    //fields
    public Modchu_ModelRenderer bipedHeadwear2;
    public Modchu_ModelRenderer BodyC;
    public Modchu_ModelRenderer BodyR;
    public Modchu_ModelRenderer BodyL;
    public Modchu_ModelRenderer Skirt1;
    public Modchu_ModelRenderer Skirt2;
    public Modchu_ModelRenderer Skirt3;
    public Modchu_ModelRenderer Skirt4;
    public Modchu_ModelRenderer backRightLeg;
    public Modchu_ModelRenderer backLeftLeg;
    protected boolean isRidingMaster = false;
    public Modchu_ModelRenderer SkirtTopBack;
    public Modchu_ModelRenderer SkirtTopL;
    public Modchu_ModelRenderer SkirtTopBackL;
    public Modchu_ModelRenderer SkirtFrontL;
    public Modchu_ModelRenderer SkirtLeftFront;
    public Modchu_ModelRenderer SkirtBackL;
    public Modchu_ModelRenderer SkirtLeftBack;
    public Modchu_ModelRenderer SkirtRightBack;
    public Modchu_ModelRenderer SkirtRightFront;

    public MultiModel_Evelyn3()
    {
    	this(0.0F);
    }

    public MultiModel_Evelyn3(float f)
    {
    	this(f, 0.0F);
    }

    public MultiModel_Evelyn3(float f, float f1)
    {
    	this(f, f1 , 64, 64);
    }

    public MultiModel_Evelyn3(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
    	HeadMount.setRotationPoint(0F, 1.5F, 0F);
    	Arms[0].setRotationPoint(0.5F, 11.0F, 0F);
    	Arms[1].setRotationPoint(-0.5F, 11.0F, 0F);
    }

    @Override
    public void initModel(float f, float f1) {
    	textureWidth = 64;
    	textureHeight = 64;
    	f1 = 0.0F;
    	/** HEAD : bipedHead **/
    	bipedHead = new Modchu_ModelRenderer(this, 0, 0);
    	bipedHead.setTextureOffset(0, 0).addBox(-4F, -7.5F, -4F, 8, 8, 8, f-0.9F); // head
    	bipedHead.setTextureOffset(36, 14).addBox(-3F, -7.5F, -2F, 6, 2, 6, f+0.2F); // cap
    	bipedHead.setRotationPoint(0F, 0F, 0F);

    	bipedHeadwear = new Modchu_ModelRenderer(this, 0, 16);
    	bipedHeadwear.addBox(-3F, 0.5F, -1F, 6, 5, 2, f);
    	bipedHeadwear.setRotationPoint(0F, -1F, 2F);
    	bipedHead.addChild(bipedHeadwear);

    	bipedHeadwear2 = new Modchu_ModelRenderer(this, 0, 23);
    	bipedHeadwear2.addBox(-3F, 0.5F, -1F, 6, 6, 2, f);
    	bipedHeadwear2.setRotationPoint(0F, 5F, 0F);
    	bipedHeadwear.addChild(bipedHeadwear2);

    	eyeR = new Modchu_ModelRenderer(this, 17, 1);
    	eyeR.addPlate(-1.9F, -4F, -3.11F, 1, 2, 0, f);
    	eyeR.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(eyeR);

    	eyeL = new Modchu_ModelRenderer(this, 22, 1);
    	eyeL.addPlate(0.9F, -4F, -3.11F, 1, 2, 0, f);
    	eyeL.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(eyeL);

    	ChignonB = new Modchu_ModelRenderer(this, 40, 0);
    	ChignonB.addBox(0F, 0F, 0F, 3, 3, 1, f);
    	ChignonB.setRotationPoint(-1.5F, -5.5F, 3F);
    	bipedHead.addChild(ChignonB);

    	ChignonR = new Modchu_ModelRenderer(this, 0, 2);
    	ChignonR.addBox(0F, 0F, 0F, 1, 3, 3, f);
    	ChignonR.setRotationPoint(-4F, -6F, -0.5F);
    	bipedHead.addChild(ChignonR);

    	ChignonL = new Modchu_ModelRenderer(this, 54, 14);
    	ChignonL.mirror = true;
    	ChignonL.addBox(0F, 0F, 0F, 1, 3, 3, f);
    	ChignonL.setRotationPoint(3F, -6F, -0.5F);
    	bipedHead.addChild(ChignonL);

    	Tail = new Modchu_ModelRenderer(this, 28, 16);
    	Tail.addBox(-1F, -1F, -0.5F, 2, 8, 2, f);
    	Tail.setRotationPoint(0F, -4F, 4F);
    	bipedHead.addChild(Tail);

    	SideTailR = new Modchu_ModelRenderer(this, 16, 16);
    	SideTailR.addBox(-1F, -1F, -1F, 1, 8, 2, f);
    	SideTailR.setRotationPoint(-3.5F, -4.5F, 1F);
    	bipedHead.addChild(SideTailR);

    	SideTailL = new Modchu_ModelRenderer(this, 22, 16);
    	SideTailL.mirror = true;
    	SideTailL.addBox(0F, -1F, -1F, 1, 8, 2, f);
    	SideTailL.setRotationPoint(3.5F, -4.5F, 1F);
    	bipedHead.addChild(SideTailL);

    	/** BODY & ARMS : bipedBody, bipedRightArm, bipedLeftArm **/
    	bipedBody = new Modchu_ModelRenderer(this, 24, 0);
    	bipedBody.addBox(-3F, 0F, -1.5F, 6, 3, 4, f);//hip
    	bipedBody.setRotationPoint(0F, 6F, 0F);

    	BodyC = new Modchu_ModelRenderer(this, 0, 0);
    	BodyC.setTextureOffset(16, 5).addBox(-1F, -7F, -1F, 2, 1, 2, f);//neck
    	BodyC.setTextureOffset(20,31).addBox(-3F, -6F, -1.5F, 6, 2, 3, f+0.1F);//body upper
    	BodyC.setTextureOffset(32, 7).addBox(-2.5F, -4F, -1.5F, 5, 4, 3, f);//body waist
    	BodyC.setRotationPoint(0F, 0F, 0F);
    	BodyC.rotateAngleX = -0.05F;
    	bipedBody.addChild(BodyC);

    	BodyR = new Modchu_ModelRenderer(this, 16, 26);
    	BodyR.addBox(-1.5F, -3F, 0F, 3, 3, 2, f);
    	BodyR.setRotationPoint(-1F, -1.5F, -1.6F);
    	BodyR.rotateAngleX = 0.4F;
    	BodyR.rotateAngleZ = -0.2F;
    	BodyC.addChild(BodyR);

    	BodyL = new Modchu_ModelRenderer(this, 26, 26);
    	BodyL.mirror = true;
    	BodyL.addBox(-1.5F, -3F, 0F, 3, 3, 2, f);
    	BodyL.setRotationPoint(1F, -1.5F, -1.6F);
    	BodyL.rotateAngleX = 0.4F;
    	BodyL.rotateAngleZ = 0.2F;
    	BodyC.addChild(BodyL);

    	bipedRightArm = new Modchu_ModelRenderer(this, 48, 0);
    	bipedRightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2, f);
    	bipedRightArm.setRotationPoint(-3F, 1.5F, 0F);
    	bipedBody.addChild(bipedRightArm);

    	bipedLeftArm = new Modchu_ModelRenderer(this, 56, 0);
    	bipedLeftArm.mirror = true;
    	bipedLeftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2, f);
    	bipedLeftArm.setRotationPoint(3F, 1.5F, 0F);
    	bipedBody.addChild(bipedLeftArm);

    	/** LEGINS : Skirt **/
    	Skirt = new Modchu_ModelRenderer(this, 0, 31);
    	Skirt.addBox(-3.5F, 1F, -3F, 7, 3, 6, f+0.2F);
    	Skirt.setRotationPoint(0F, 6F, 0F);
    	bipedBody.addChild(Skirt);

    	Skirt1 = new Modchu_ModelRenderer(this, 0, 40);
    	Skirt1.addBox(-3.2F, -1F, -3F, 5, 7, 5, f+0.2F);
    	Skirt1.setRotationPoint(-1F, 4F, -1F);
    	Skirt1.rotateAngleX = -0.2F;
    	Skirt1.rotateAngleZ =  0.2F;
    	Skirt.addChild(Skirt1);

    	Skirt2 = new Modchu_ModelRenderer(this, 20, 40);
    	Skirt2.mirror = true;
    	Skirt2.addBox(-1.8F, -1F, -3F, 5, 7, 5, f+0.2F);
    	Skirt2.setRotationPoint(1F, 4F, -1F);
    	Skirt2.rotateAngleX = -0.2F;
    	Skirt2.rotateAngleZ = -0.2F;
    	Skirt.addChild(Skirt2);

    	Skirt3 = new Modchu_ModelRenderer(this, 20, 52);
    	Skirt3.mirror = true;
    	Skirt3.addBox(-1.8F, -1F, -2F, 5, 7, 5, f+0.2F);
    	Skirt3.setRotationPoint(1F, 4F, 1F);
    	Skirt3.rotateAngleX =  0.2F;
    	Skirt3.rotateAngleZ = -0.2F;
    	Skirt.addChild(Skirt3);

    	Skirt4 = new Modchu_ModelRenderer(this, 0, 52);
    	Skirt4.addBox(-3.2F, -1F, -2F, 5, 7, 5, f+0.2F);
    	Skirt4.setRotationPoint(-1F, 4F, 1F);
    	Skirt4.rotateAngleX =  0.2F;
    	Skirt4.rotateAngleZ =  0.2F;
    	Skirt.addChild(Skirt4);

    	/** BOTTOMS : upperRightLeg, upperLeftLeg **/
    	rightLeg = new Modchu_ModelRenderer(this, 44, 33);
    	rightLeg.addBox(-1.2F, -1F, -2F, 2, 7, 3, f+0.1F);
    	bipedBody.addChild(rightLeg);

    	leftLeg = new Modchu_ModelRenderer(this, 54, 33);
    	leftLeg.mirror = true;
    	leftLeg.addBox(-0.8F, -1F, -2F, 2, 7, 3, f+0.1F);
    	bipedBody.addChild(leftLeg);

    	backRightLeg = new Modchu_ModelRenderer(this, 44, 43);
    	backRightLeg.addBox(-1F, -7.5F, -1.5F, 2, 7, 3, f+0.2F);
    	rightLeg.addChild(backRightLeg);

    	backLeftLeg = new Modchu_ModelRenderer(this, 54, 43);
    	backLeftLeg.mirror = true;
    	backLeftLeg.addBox(-1F, -7.5F, -1.5F, 2, 7, 3, f+0.2F);
    	leftLeg.addChild(backLeftLeg);

    	rightLeg2 = new Modchu_ModelRenderer(this, 44, 53);
    	rightLeg2.addBox(-1F, 0.5F, -1.5F, 2, 8, 3, f+0.2F);
    	rightLeg.addChild(rightLeg2);

    	leftLeg2 = new Modchu_ModelRenderer(this, 54, 53);
    	leftLeg2.mirror = true;
    	leftLeg2.addBox(-1F, 0.5F, -1.5F, 2, 8, 3, f+0.2F);
    	leftLeg.addChild(leftLeg2);

		mainFrame = new Modchu_ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, 0F + f1, 0F);
		mainFrame.addChild(bipedHead);
		mainFrame.addChild(bipedBody);

		actionPartsInit(f, f1);
    }

	@Override
	public void actionPartsInit(float f, float f1) {
		rightArm = new Modchu_ModelRenderer(this, 48, 0);
		rightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, f);
		rightArm.setRotationPoint(-3.0F, 9.5F, 0.0F);
		bipedBody.addChild(rightArm);

		rightArmPlus = new Modchu_ModelRenderer(this);
		((Modchu_ModelRenderer) rightArmPlus.setTextureOffset(52, 0)).addPlate(-1.0F, -1.0F, -3.01F, 2, 2, 4, f);
		rightArmPlus.rotateAngleX = 1.570796313F;
		rightArm.addChild(rightArmPlus);

		rightArm2 = new Modchu_ModelRenderer(this, 48, 6);
		rightArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, f);
		rightArm2.setRotationPoint(0.0F, 3.0F, 0.0F);
		rightArm.addChild(rightArm2);

		rightArmPlus2 = new Modchu_ModelRenderer(this);
		((Modchu_ModelRenderer) rightArmPlus2.setTextureOffset(52, 0)).addPlate(-1.0F, -1.0F, 0.01F, 2, 2, 4, f);
		((Modchu_ModelRenderer) rightArmPlus2.setTextureOffset(52, 0)).addPlate(-1.0F, -1.0F, -3.01F, 2, 2, 4, f);
		rightArmPlus2.rotateAngleX = 1.570796313F;
		rightArm2.addChild(rightArmPlus2);

		rightHand = new Modchu_ModelRenderer(this, 48, 10);
		rightHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
		rightHand.setRotationPoint(0.0F, 4.0F, 0.0F);
		rightArm2.addChild(rightHand);

		leftArm = new Modchu_ModelRenderer(this, 56, 0);
		leftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, f);
		leftArm.setRotationPoint(3.0F, 9.5F, 0.0F);
		bipedBody.addChild(leftArm);

		leftArmPlus = new Modchu_ModelRenderer(this);
		((Modchu_ModelRenderer) leftArmPlus.setTextureOffset(60, 0)).addPlate(-1.0F, -1.0F, -3.01F, 2, 2, 4, f);
		leftArmPlus.rotateAngleX = 1.570796313F;
		leftArm.addChild(leftArmPlus);

		leftArm2 = new Modchu_ModelRenderer(this, 56, 6);
		leftArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, f);
		leftArm2.setRotationPoint(0.0F, 3.0F, 0.0F);
		leftArm.addChild(leftArm2);

		leftArmPlus2 = new Modchu_ModelRenderer(this);
		((Modchu_ModelRenderer) leftArmPlus2.setTextureOffset(60, 0)).addPlate(-1.0F, -1.0F, 0.01F, 2, 2, 4, f);
		((Modchu_ModelRenderer) leftArmPlus2.setTextureOffset(60, 0)).addPlate(-1.0F, -1.0F, -3.01F, 2, 2, 4, f);
		leftArmPlus2.rotateAngleX = 1.570796313F;
		leftArm2.addChild(leftArmPlus2);

		leftHand = new Modchu_ModelRenderer(this, 56, 10);
		leftHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
		leftHand.setRotationPoint(0.0F, 4.0F, 0.0F);
		leftArm2.addChild(leftHand);

		rightHand.showModel = leftHand.showModel =
				rightArm.showModel = leftArm.showModel =
						rightArm2.showModel = leftArm2.showModel =
								rightArmPlus.showModel = rightArmPlus2.showModel =
										leftArmPlus.showModel = leftArmPlus2.showModel = false;
		setCapsValue(caps_aimedBowBan, false);
		setCapsValue(caps_sneakBan, false);
		setCapsValue(caps_waitBan, false);
		setCapsValue(caps_sittingBan, false);
		setCapsValue(caps_sleepingBan, false);
	}

	public void skirtFloatsInit(float f, float f1) {
		if(!getCapsValueBoolean(caps_skirtFloats)) return;
		//SkirtR 上
		SkirtTop = new Modchu_ModelRenderer(this, 5, 40);
		((Modchu_ModelRenderer) SkirtTop).addPlate(-2.5F, 0.0F, -2.5F, 5, 5, 0);
		Skirt1.addChild(SkirtTop);

		//SkirtR 上後
		SkirtTopBack = new Modchu_ModelRenderer(this, 5, 52);
		SkirtTopBack.addPlate(-2.5F, 0.0F, -2.5F, 5, 5, 0);
		Skirt3.addChild(SkirtTopBack);

		//SkirtR 前
		SkirtFront = new Modchu_ModelRenderer(this, 5, 45);
		((Modchu_ModelRenderer) SkirtFront).addPlate(0.0F, 0.0F, 0.0F, 5, 7, 0);
		SkirtTop.addChild(SkirtFront);

		//SkirtR 右前
		SkirtRightFront = new Modchu_ModelRenderer(this, 0, 45);
		SkirtRightFront.addPlate(-2.5F, 0.0F, -3.5F, 5, 7, 1);
		SkirtTop.addChild(SkirtRightFront);

		//SkirtR 右後
		SkirtRightBack = new Modchu_ModelRenderer(this, 0, 57);
		SkirtRightBack.addPlate(-2.5F, 0.0F, -3.5F, 5, 7, 1);
		SkirtTopBack.addChild(SkirtRightBack);

		//SkirtR 後ろ
		SkirtBack = new Modchu_ModelRenderer(this, 15, 57);
		((Modchu_ModelRenderer) SkirtBack).addPlate(0.0F, 0.0F, 0.0F, 5, 7, 0);
		SkirtTopBack.addChild(SkirtBack);

		//SkirtL 上前
		SkirtTopL = new Modchu_ModelRenderer(this, 25, 40);
		SkirtTopL.addPlate(-2.5F, 0.0F, -2.5F, 5, 5, 0);
		Skirt2.addChild(SkirtTopL);

		//SkirtL 上後
		SkirtTopBackL = new Modchu_ModelRenderer(this, 25, 52);
		SkirtTopBackL.addPlate(-2.5F, 0.0F, -2.5F, 5, 5, 0);
		Skirt4.addChild(SkirtTopBackL);

		//SkirtL 前
		SkirtFrontL = new Modchu_ModelRenderer(this, 25, 45);
		SkirtFrontL.addPlate(0.0F, 0.0F, 0.0F, 5, 7, 0);
		SkirtTopL.addChild(SkirtFrontL);

		//SkirtL 左前
		SkirtLeftFront = new Modchu_ModelRenderer(this, 20, 45);
		SkirtLeftFront.addPlate(-2.5F, 0.0F, -3.5F, 5, 7, 1);
		SkirtTopL.addChild(SkirtLeftFront);

		//SkirtL 左後
		SkirtLeftBack = new Modchu_ModelRenderer(this, 20, 57);
		SkirtLeftBack.addPlate(-2.5F, 0.0F, -3.5F, 5, 7, 1);
		SkirtTopBackL.addChild(SkirtLeftBack);

		//SkirtL 後ろ
		SkirtBackL = new Modchu_ModelRenderer(this, 35, 57);
		SkirtBackL.addPlate(0.0F, 0.0F, 0.0F, 5, 7, 0);
		SkirtTopBackL.addChild(SkirtBackL);
		setCapsValue(caps_visible, Skirt1, false);
		setCapsValue(caps_visible, Skirt2, false);
		setCapsValue(caps_visible, Skirt3, false);
		setCapsValue(caps_visible, Skirt4, false);
	}

	@Override
    public void setLivingAnimationsLM(EntityLiving entityliving, float f, float f1, float f2)
    {
        super.setLivingAnimationsLM(entityliving, f, f1, f2);

        // 村人繁殖
        if(entityliving instanceof EntityVillager)
        {
             EntityVillager ev = (EntityVillager)entityliving;
             if ((Boolean) getObjectInvokeMethod(ev.getClass(), "getIsMatingFlag", ev))
             //if(ev.getIsMatingFlag())
             {
                 bipedHead.rotateAngleZ = 0.3F;
             }
             else
             {
                 bipedHead.rotateAngleZ = 0.3F;
             }
        }

        // 背負われ
        isRidingMaster = entityliving.ridingEntity instanceof EntityPlayer;

    }

	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
    	reset(f, f1, f2, f3, f4, f5, entity);
		//heading
		bipedHead.rotateAngleY = f3 / 57.29578F;
		bipedHead.rotateAngleX = f4 / 57.29578F;
		bipedHeadwear.rotateAngleX = -bipedHead.rotateAngleX;
		bipedHeadwear2.rotateAngleX = Math.abs(bipedHead.rotateAngleX) * 0.9F + Math.abs(bipedHead.rotateAngleY) * 0.2F + 0.2F;

		//walk
		float wav0 = MathHelper.cos(f * 0.5F); //waving for angles of arms and legs
		float wav1 = MathHelper.sin(f * 0.5F); //delayed waving
		float wav2 = wav0 > wav1 ?  wav0 :  wav1; //+upper
		float wav3 = wav0 < wav1 ? -wav0 : -wav1; //-lower

		bipedRightArm.rotateAngleX = -wav0 * f1;
		bipedLeftArm.rotateAngleX = wav0 * f1;
		bipedRightArm.rotateAngleZ = 0.2F;
		bipedLeftArm.rotateAngleZ = -0.2F;
		bipedRightArm.rotateAngleY = 0.0F;
		bipedLeftArm.rotateAngleY = 0.0F;

		rightLeg.rotateAngleX = wav0 * f1 * 0.8F - 0.1F;
		leftLeg.rotateAngleX = -wav0 * f1 * 0.8F;
		rightLeg2.rotateAngleX = wav2 * f1 * 0.9F + 0.2F;
		leftLeg2.rotateAngleX =  wav3 * f1 * 0.9F;
		rightLeg.rotateAngleY = -0.05F;
		leftLeg.rotateAngleY = 0.05F;

		float shiftY = 0F;
		bipedHead.rotationPointY = -0.5F;
		bipedBody.rotationPointY = 6F;
		bipedRightArm.rotationPointY = -6.5F;
		bipedLeftArm.rotationPointY = -6.5F;
		Skirt.rotationPointY = 0.0F;
		rightLeg.rotationPointY = 4.0F;
		leftLeg.rotationPointY = 4.0F;

		if(getCapsValueBoolean(caps_getIsRiding))  // 乗り物に乗っている
		{
			shiftY = 3.0F;
			if(isRidingMaster)
			{
				rightLeg.rotateAngleY = 0.6F;
				leftLeg.rotateAngleY = -0.6F;
				rightLeg.rotateAngleX = -1.45F;
				leftLeg.rotateAngleX = -1.45F;
				rightLeg2.rotateAngleX = (MathHelper.sin(f2 * 0.3F) + 1F) * 0.2F;
				leftLeg2.rotateAngleX = (-MathHelper.sin(f2 * 0.3F) + 1F) * 0.2F;
			}
			else
			{
				rightLeg.rotateAngleY = -0.05F;
				leftLeg.rotateAngleY = 0.05F;
				rightLeg.rotateAngleX = -0.8F;
				leftLeg.rotateAngleX = -0.8F;
				rightLeg2.rotateAngleX = 2.4F;
				leftLeg2.rotateAngleX = 2.4F;
			}
		}

		// アイテム持ってるときの腕振りを抑える
		if(heldItemLeft != 0) {
			bipedLeftArm.rotateAngleX = bipedLeftArm.rotateAngleX * 0.5F - 0.3141593F * (float)heldItemLeft;
		}
		if(heldItemRight != 0) {
			bipedRightArm.rotateAngleX = bipedRightArm.rotateAngleX * 0.5F - 0.3141593F * (float)heldItemRight;
		}

		BodyR.rotateAngleX = BodyL.rotateAngleX = 0.4F;
		BodyR.rotateAngleZ = -0.25F;
		BodyL.rotateAngleZ = 0.25F;
		armSwing(f, f1, f2, f3, f4, f5, entity);
		Skirt.rotateAngleX = bipedBody.rotateAngleX;
		if(getCapsValueBoolean(caps_getIsSneak))
		{
			// しゃがみ
			bipedBody.rotateAngleX = -0.05F + 0.4F;
			BodyR.rotateAngleX = BodyL.rotateAngleX = 0.55F;
			if(!getCapsValueBoolean(caps_getIsWait))
			{
				bipedRightArm.rotateAngleX += 0.5F;
				bipedLeftArm.rotateAngleX += 0.5F;
			}
			if(!getCapsValueBoolean(caps_getIsRiding)) {
				shiftY = 2F;
				rightLeg2.rotateAngleX += 1F;
				leftLeg2.rotateAngleX += 1F;
			}
			Skirt.rotateAngleX -= 0.2F;
			Skirt.rotationPointY = -1.0F;
			Skirt.rotationPointZ = 0.5F;
			rightLeg.rotateAngleX -= 0.6F + bipedBody.rotateAngleX;
			leftLeg.rotateAngleX -= 0.6F + bipedBody.rotateAngleX;
			rightLeg.rotationPointZ = 0F + 1.5F;
			leftLeg.rotationPointZ = 0F + 1.5F;
			bipedHead.rotationPointZ = 0F - 2.5F;
			bipedHead.rotationPointY += 0.5F;
			bipedHeadwear.rotateAngleX += 0.5F;
		} else
		{
			// 通常立ち
			bipedBody.rotateAngleX = -0.05F;
			rightLeg.rotationPointZ = 0F;
			leftLeg.rotationPointZ = 0F;
			bipedHead.rotationPointZ = 0F;
		}
		if (getCapsValueBoolean(caps_getIsWait) && !getCapsValueBoolean(caps_aimedBow)) {
			//待機状態の特別表示
			bipedRightArm.rotateAngleX -= 0.5F - MathHelper.sin(f2 * 0.067F) * 0.05F;
			bipedRightArm.rotateAngleY = 0.0F;
			bipedRightArm.rotateAngleZ = -0.4F;
			bipedLeftArm.rotateAngleX -= 0.5F - MathHelper.sin(f2 * 0.067F) * 0.05F;
			bipedLeftArm.rotateAngleY = 0.0F;
			bipedLeftArm.rotateAngleZ = 0.4F;
			BodyR.rotateAngleZ = -0.2F;
			BodyL.rotateAngleZ = 0.2F;
			Arms[0].rotationPointX -= 2.0F;
			Arms[0].rotateAngleZ -= 1.5F;
			Arms[0].rotateAngleX -= 0.5F;
			Arms[0].rotateAngleY += 1.5F;
			Arms[1].rotationPointX += 2.0F;
			Arms[1].rotateAngleZ += 1.5F;
			Arms[1].rotateAngleX -= 0.5F;
			Arms[1].rotateAngleY -= 1.5F;
		} else {
			if (getCapsValueBoolean(caps_aimedBow))
			{
				// 弓構え
				float f6 = MathHelper.sin(getCapsValueFloat(caps_onGround) * 3.141593F);
				float f7 = MathHelper.sin((1.0F - (1.0F - getCapsValueFloat(caps_onGround)) * (1.0F - getCapsValueFloat(caps_onGround))) * 3.141593F);
				bipedRightArm.rotateAngleZ = MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
				bipedLeftArm.rotateAngleZ = -MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
				bipedRightArm.rotateAngleY = f6 * 0.6F - 0.1F + bipedHead.rotateAngleY;
				bipedLeftArm.rotateAngleY = -f6 * 0.6F + 0.1F + bipedHead.rotateAngleY;
				bipedRightArm.rotateAngleX = bipedLeftArm.rotateAngleX = bipedHead.rotateAngleX + MathHelper.sin(f2 * 0.067F) * 0.05F - 1.5F - f6 * 1.2F + f7 * 0.4F;
				bipedLeftArm.rotateAngleX = bipedRightArm.rotateAngleX + 0.4F;
			} else {
				// 通常
				bipedRightArm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F;
				bipedLeftArm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F;
				bipedRightArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
				bipedLeftArm.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;
			}
		}

		//全体の上下
		bipedHead.rotationPointY += shiftY;
		bipedBody.rotationPointY += shiftY;

		//スカート follow Legs
		Skirt1.rotateAngleX = rightLeg.rotateAngleX;
		Skirt2.rotateAngleX = leftLeg.rotateAngleX;
		Skirt3.rotateAngleX = leftLeg.rotateAngleX * 0.7F + 0.2F;
		Skirt4.rotateAngleX = rightLeg.rotateAngleX * 0.7F + 0.2F;
		Skirt1.rotateAngleY = rightLeg.rotateAngleY * 0.9F;
		Skirt2.rotateAngleY = leftLeg.rotateAngleY * 0.9F;
		Skirt1.rotateAngleZ = rightLeg.rotateAngleZ * 0.8F + 0.1F;
		Skirt2.rotateAngleZ = leftLeg.rotateAngleZ * 0.8F - 0.1F;
		Skirt3.rotateAngleZ = leftLeg.rotateAngleZ * 0.8F - 0.1F;
		Skirt4.rotateAngleZ = rightLeg.rotateAngleZ * 0.8F + 0.1F;
		Skirt1.rotateAngleX += MathHelper.cos(f2 * 0.101F) * 0.01F;
		Skirt2.rotateAngleX += MathHelper.cos(f2 * 0.102F) * 0.01F;
		Skirt3.rotateAngleX -= MathHelper.cos(f2 * 0.103F) * 0.01F;
		Skirt4.rotateAngleX -= MathHelper.cos(f2 * 0.104F) * 0.01F;
		Skirt1.rotateAngleZ -= MathHelper.cos(f2 * 0.108F) * 0.02F;
		Skirt2.rotateAngleZ += MathHelper.cos(f2 * 0.107F) * 0.02F;
		Skirt3.rotateAngleZ += MathHelper.cos(f2 * 0.106F) * 0.02F;
		Skirt4.rotateAngleZ -= MathHelper.cos(f2 * 0.105F) * 0.02F;

		//モモウラ
		backRightLeg.rotateAngleX = rightLeg.rotateAngleX < 0 ? rightLeg.rotateAngleX * -0.3F - 0.2F : -0.2F;
		backLeftLeg.rotateAngleX = leftLeg.rotateAngleX < 0 ? leftLeg.rotateAngleX * -0.3F - 0.2F : -0.2F;
		backRightLeg.rotateAngleX = backRightLeg.rotateAngleX > -0.05F ? -0.05F : backRightLeg.rotateAngleX;
		backLeftLeg.rotateAngleX = backLeftLeg.rotateAngleX > -0.05F ? -0.05F : backLeftLeg.rotateAngleX;

		//息
		BodyR.rotateAngleX = BodyL.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.03F;

		//ポニテツインテ follow Gravity
		Tail.rotateAngleX = SideTailR.rotateAngleX = SideTailL.rotateAngleX = -bipedHead.rotateAngleX;
		Tail.rotateAngleZ = -bipedHead.rotateAngleZ;
		Tail.rotateAngleX += 0.05F;
		SideTailR.rotateAngleZ = 0.05F;
		SideTailL.rotateAngleZ =-0.05F;
		skirtFloats(f, f1, f2, f3, f4, f5, entity);
   }

	@Override
	public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		if (!getCapsValueBoolean(caps_skirtFloats)) return;
		float motionY = getCapsValueFloat(caps_motionY);
		SkirtTop.setRotationPoint(-1.0F, 1.0F, 2.0F);
		SkirtTopBack.setRotationPoint(-5.5F, -3.5F, 1.5F);
		SkirtFront.setRotationPoint(-2.5F, 4.5F, -2.5F);
		SkirtRightFront.setRotationPoint(0.0F, 1.5F, -3.0F);
		SkirtRightBack.setRotationPoint(-1.0F, 2.5F, -2.5F);
		SkirtBack.setRotationPoint(-2.5F, 0.0F, -2.5F);

		SkirtTopL.setRotationPoint(1.0F, 1.0F, 2.0F);
		SkirtTopBackL.setRotationPoint(5.5F, 1.0F, 1.5F);
		SkirtFrontL.setRotationPoint(-2.5F, 4.8F, -2.5F);
		SkirtLeftFront.setRotationPoint(5.0F, 1.5F, -2.5F);
		SkirtLeftBack.setRotationPoint(1.0F, 2.5F, -2.5F);
		SkirtBackL.setRotationPoint(-2.5F, 0.0F, -2.5F);

		SkirtTop.rotateAngleX = 4.712388966F;
		SkirtTop.rotateAngleY = 0.0F;
		SkirtTop.rotateAngleZ = 0.0F;
		SkirtTopBack.rotateAngleX = 1.570796313F;
		SkirtTopBack.rotateAngleY = 1.570796313F;
		SkirtTopBack.rotateAngleZ = 0.0F;
		SkirtTopL.rotateAngleX = 4.712388966F;
		SkirtTopL.rotateAngleY = 0.0F;
		SkirtTopL.rotateAngleZ = 0.0F;
		SkirtTopBackL.rotateAngleX = -1.570796313F;
		SkirtTopBackL.rotateAngleY = 1.570796313F;
		SkirtTopBackL.rotateAngleZ = 0.0F;
		SkirtRightFront.rotateAngleX = 1.570796313F;
		SkirtRightFront.rotateAngleY = 0.0F;
		SkirtRightFront.rotateAngleZ = 0.0F;
		SkirtRightBack.rotateAngleX = -1.570796313F;
		SkirtRightBack.rotateAngleY = 0.0F;
		SkirtRightBack.rotateAngleZ = 1.570796313F;
		SkirtFront.rotateAngleX = 1.570796313F;
		SkirtFront.rotateAngleY = 0.0F;
		SkirtFront.rotateAngleZ = 0.0F;
		SkirtBack.rotateAngleX = -1.570796313F;
		SkirtBack.rotateAngleY = 0.0F;
		SkirtBack.rotateAngleZ = 1.570796313F;
		SkirtFrontL.rotateAngleX = 1.570796313F;
		SkirtFrontL.rotateAngleY = 0.0F;
		SkirtFrontL.rotateAngleZ = 0.0F;
		SkirtBackL.rotateAngleX = 1.570796313F;
		SkirtBackL.rotateAngleY = 0.0F;
		SkirtBackL.rotateAngleZ = 1.570796313F;
		SkirtLeftFront.rotateAngleX = 1.570796313F;
		SkirtLeftFront.rotateAngleY = 0.0F;
		SkirtLeftFront.rotateAngleZ = 0.0F;
		SkirtLeftBack.rotateAngleX = 1.570796313F;
		SkirtLeftBack.rotateAngleY = 0.0F;
		SkirtLeftBack.rotateAngleZ = 1.570796313F;

		SkirtFront.rotationPointX += motionY * 2.0F;
		//SkirtBack.rotationPointX += motionY * 5.0F;

		SkirtRightFront.rotationPointZ -= motionY * 4.0F;
		SkirtRightBack.rotationPointZ += motionY * 5.0F;

		SkirtFrontL.rotationPointX += motionY * 2.0F;
		//SkirtBackL.rotationPointX += motionY * 5.0F;
		SkirtLeftFront.rotationPointZ += motionY * 4.0F;
		SkirtLeftBack.rotationPointZ -= motionY * 5.0F;

		SkirtFront.rotateAngleX += motionY;

		SkirtRightFront.rotateAngleX -= motionY / 4.0F;
		SkirtRightFront.rotateAngleY += motionY * 1.2F;
		SkirtRightBack.rotateAngleX -= motionY / 4.0F;
		SkirtRightBack.rotateAngleY -= motionY * 1.2F;
		SkirtBack.rotateAngleX -= motionY;
		SkirtFrontL.rotateAngleX += motionY;
		SkirtLeftFront.rotateAngleY -= motionY * 1.2F;
		SkirtLeftBack.rotateAngleY += motionY * 1.2F;
		SkirtBackL.rotateAngleX += motionY;

		((Modchu_ModelRenderer) SkirtFront).scaleX = ((Modchu_ModelRenderer) SkirtBack).scaleX =
				SkirtFrontL.scaleX = SkirtBackL.scaleX = 1.0F - (motionY * 1.2F);
		SkirtLeftFront.scaleZ = SkirtLeftBack.scaleZ =
				SkirtRightFront.scaleZ = SkirtRightBack.scaleZ = 1.0F - (motionY * 1.5F);
	}

	@Override
    public void defaultPartsSettingBefore() {
    	super.defaultPartsSettingBefore();
    	String[] s = {
    			"SkirtTopBack", "SkirtTopL", "SkirtTopBackL", "SkirtFrontL", "SkirtLeftFront",
    			"SkirtBackL", "SkirtLeftBack", "SkirtRightBack", "SkirtRightFront", "Skirt1",
    			"Skirt2", "Skirt3", "Skirt4"
    	};
    	showPartsHideListadd(s);
    	String[] s1 = {
    			"bipedHeadwear2", "backRightLeg", "backLeftLeg"
    	};
    	String[] s2 = {
    			"Headwear2", "b_RightLeg", "b_LeftLeg"
    	};
    	addShowPartsReneme(s1, s2);
    }

    @Override
    public void showModelSettingReflects() {
    	super.showModelSettingReflects();
    	if (getCapsValueBoolean(caps_skirtFloats)) {
    		setCapsValue(caps_visible, Skirt1, false);
    		setCapsValue(caps_visible, Skirt2, false);
    		setCapsValue(caps_visible, Skirt3, false);
    		setCapsValue(caps_visible, Skirt4, false);
    	}
    }

    @Override
    public void reset(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHeadwear.setRotationPoint(0.0F, -1.0F, 2.0F);
    	bipedHeadwear2.setRotationPoint(0.0F, 5.0F, 0.0F);
    	ChignonB.setRotationPoint(-1.5F, -5.5F, 3F);
    	ChignonR.setRotationPoint(-4.0F, -6.0F, -0.5F);
    	ChignonL.setRotationPoint(3.0F, -6.0F, -0.5F);
    	Tail.setRotationPoint(0.0F, -4.0F, 4.0F);
    	SideTailR.setRotationPoint(-3.5F, -4.5F, 1.0F);
    	SideTailL.setRotationPoint(3.5F, -4.5F, 1.0F);
    	bipedBody.setRotationPoint(0.0F, 6.0F, 0.0F);
    	BodyC.setRotationPoint(0.0F, 0.0F, 0.0F);
    	BodyR.setRotationPoint(-0.9F, -1.5F, -1.6F);
    	BodyL.setRotationPoint(0.9F, -1.5F, -1.6F);
    	bipedRightArm.setRotationPoint(-3.0F, 1.5F, 0.0F);
    	bipedLeftArm.setRotationPoint(3.0F, 1.5F, 0.0F);
    	Skirt.setRotationPoint(0.0F, 6.0F, 0.0F);
    	Skirt1.setRotationPoint(-1.0F, 4.0F, -1.0F);
    	Skirt2.setRotationPoint(1.0F, 4.0F, -1.0F);
    	Skirt3.setRotationPoint(1.0F, 4.0F, 1.0F);
    	Skirt4.setRotationPoint(-1.0F, 4.0F, 1.0F);
    	rightLeg.setRotationPoint(-2.0F, 10.0F, 0.0F);
    	leftLeg.setRotationPoint(2.0F, 10.0F, 0.0F);
    	backRightLeg.setRotationPoint(0.0F, 6.0F, 0.0F);
    	backLeftLeg.setRotationPoint(0.0F, 6.0F, 0.0F);
    	rightLeg2.setRotationPoint(0.0F, 5.5F, 0.0F);
    	leftLeg2.setRotationPoint(0.0F, 5.5F, 0.0F);
    	rightLeg.setRotationPoint(-2F, 10F, 0F);
    	Arms[0].setRotationPoint(0.5F, 11.0F, 0F);
    	Arms[1].setRotationPoint(-0.5F, 11.0F, 0F);
    	rightLeg.rotateAngleZ = -0.15F;
    	leftLeg.rotateAngleZ = 0.15F;
    	backRightLeg.rotateAngleX = -0.2F;
    	backRightLeg.rotateAngleZ = 0.1F;
    	backLeftLeg.rotateAngleX = -0.2F;
    	backLeftLeg.rotateAngleZ = -0.1F;
    	rightLeg2.rotateAngleZ = 0.15F;
    	leftLeg2.rotateAngleZ = -0.15F;
    	Arms[0].rotateAngleX = 0F;
    	Arms[0].rotateAngleY = 0F;
    	Arms[0].rotateAngleZ = 0F;
    	Arms[1].rotateAngleX = 0F;
    	Arms[1].rotateAngleY = 0F;
    	Arms[1].rotateAngleZ = 0F;
    }

    @Override
    public void actionRelease1() {
    	super.actionRelease1();
    	boolean b = true;
    	if (rightLeg != null) setCapsValue(caps_visible, rightLeg, b);
    	if (rightLeg2 != null) setCapsValue(caps_visible, rightLeg2, b);
    	if (leftLeg != null) setCapsValue(caps_visible, leftLeg, b);
    	if (leftLeg2 != null) setCapsValue(caps_visible, leftLeg2, b);
    	rightLeg.rotateAngleX = 0.0F;
    	rightLeg.rotateAngleY = 0.0F;
    	rightLeg.rotateAngleZ = 0.0F;
    	rightLeg2.rotateAngleX = 0.0F;
    	rightLeg2.rotateAngleY = 0.0F;
    	rightLeg2.rotateAngleZ = 0.0F;
    	leftLeg.rotateAngleX = 0.0F;
    	leftLeg.rotateAngleY = 0.0F;
    	leftLeg.rotateAngleZ = 0.0F;
    	leftLeg2.rotateAngleX = 0.0F;
    	leftLeg2.rotateAngleY = 0.0F;
    	leftLeg2.rotateAngleZ = 0.0F;
    }

    @Override
    public void action1(Entity entity) {
    	super.action1(entity);
    	float f1 = bipedBody.rotateAngleZ;
    	if (f1 > 0.0F) {
    		bipedHead.rotationPointY = bipedBody.rotationPointY - 6.5F + (f1 * 1.30889264F);
        	bipedHead.rotationPointX = f1 * 4.10447914F;
    	} else {
    		bipedHead.rotationPointY = bipedBody.rotationPointY - 6.5F - (f1 * 1.30889264F);
        	bipedHead.rotationPointX = f1 * 4.10447914F;
    	}
    	rightLeg.rotationPointX = -1.0F;
    	leftLeg.rotationPointX = 1.0F;
    	rightLeg.rotationPointY =
    			leftLeg.rotationPointY = 4.0F;
    	rightLeg2.rotationPointY =
    			leftLeg2.rotationPointY = 4.0F;
    	rightArm2.rotationPointY =
    			leftArm2.rotationPointY = 6.0F;
    	rightHand.rotationPointY =
    			leftHand.rotationPointY = 6.0F;
    	rightArm.rotationPointY =
    			leftArm.rotationPointY = -5.5F;
    	Arms[0].setRotationPoint(0.5F, 0.0F, 0F);
    	Arms[1].setRotationPoint(-0.5F, 0.0F, 0F);
    }

    @Override
    public float getHeight()
    {
    	return 1.99F;
    }

    @Override
    public float getWidth()
    {
    	return 0.5F;
    }

    @Override
    public float getRidingHeight()
    {
    	return 0.99F;
    }

    @Override
    public float getyOffset() {
    	return 1.6F;
    }

    @Override
    public float getRidingyOffset() {
    	return 1.61F;
    }

    @Override
    public double getMountedYOffset() {
    	return 0.7D;
    }

    @Override
    public double getSittingyOffset() {
    	return -0.5D;
    }
}
