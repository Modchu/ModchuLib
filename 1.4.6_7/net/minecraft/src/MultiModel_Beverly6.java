package net.minecraft.src;

/**
 * 多関節モデル
 * 身長2.25ブロック級
 */
public class MultiModel_Beverly6 extends MultiModel_SR2 {

	//added fields
	public Modchu_ModelRenderer Ponytail;
	public Modchu_ModelRenderer BunchR;
	public Modchu_ModelRenderer BunchL;
	public Modchu_ModelRenderer hemSkirtR1;
	public Modchu_ModelRenderer hemSkirtL1;
	public Modchu_ModelRenderer hemSkirtR2;
	public Modchu_ModelRenderer hemSkirtL2;
	public Modchu_ModelRenderer breastR;
	public Modchu_ModelRenderer breastL;
	public Modchu_ModelRenderer hipBody;
	protected byte offsetY;
	protected byte headPosY;
	protected byte bodyPosY;
	protected byte legPosY;
	protected boolean isRidingMaster = false;
	private boolean isMatingFlag = false;

	/**
	 * コンストラクタは全て継承させること
	 */
	public MultiModel_Beverly6()
	{
		super();
	}
	/**
	 * コンストラクタは全て継承させること
	 */
	public MultiModel_Beverly6(float f)
	{
		super(f);
	}
	/**
	 * コンストラクタは全て継承させること
	 */
	public MultiModel_Beverly6(float f, float f1)
	{
    	this(f, f1 , 64, 64);
    }

    public MultiModel_Beverly6(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
    	if (getMethod(EntityVillager.class, "isMating") != null) isMatingFlag = true;
    }

    @Override
    public void initModel(float f, float f1) {
    	textureWidth = 128;
    	textureHeight = 64;

    	offsetY = (byte)(f1 + 5); //Global to Local

    	bodyPosY = 0; //Local waist height = always 0 (ORIGIN)
    	headPosY = -9; //Local neck height = 0 - upper bodyLength
    	legPosY = 4; //Lcal hip joint height = 0 + lower bodyLength

    	/* HEAD */
    	eyeR = new Modchu_ModelRenderer(this, 17, 0);
    	eyeR.addPlate(-3.0F, -4F, -4.01F, 2, 3, 0, f);

    	eyeL = new Modchu_ModelRenderer(this, 21, 0);
    	eyeL.addPlate(1.0F, -4F, -4.01F, 2, 3, 0, f);

    	Ponytail = new Modchu_ModelRenderer(this, 76, 6);
    	Ponytail.addBox(-1.5F, -1.5F, -1F, 3, 9, 3, f);

    	BunchR = new Modchu_ModelRenderer(this, 64, 6);
    	BunchR.addBox(-1F, -1.3F, -0.8F, 1, 9, 2, f);

    	BunchL = new Modchu_ModelRenderer(this, 70, 6);
    	BunchL.mirror = true;
    	BunchL.addBox(0F, -1.3F, -0.8F, 1, 9, 2, f);

    	bipedHead = new Modchu_ModelRenderer(this, 0, 0);
    	bipedHead.setTextureOffset(0, 0).addBox(-4F, -8F, -4F, 8, 8, 8, f);			// Head
    	bipedHead.setTextureOffset(32, 0).addBox(-4F, -8F, -4F, 8, 12, 8, f+0.3F);		// Hire
    	bipedHead.setTextureOffset(72, 0).addBox(-2F, -7.2F, 4F, 4, 4, 2, f);		// ChignonB
    	bipedHead.setTextureOffset(56, 0).addBox(-5F, -7F, 0.2F, 1, 3, 3, f);		// ChignonR
    	((Modchu_ModelRenderer) bipedHead).setMirror(true);
    	bipedHead.setTextureOffset(64, 0).addBox(4F, -7F, 0.2F, 1, 3, 3, f);		// ChignonL
    	bipedHead.addChild(HeadMount);
    	bipedHead.addChild(eyeR);
    	bipedHead.addChild(eyeL);
    	bipedHead.addChild(Ponytail);
    	bipedHead.addChild(BunchR);
    	bipedHead.addChild(BunchL);

    	rightArm2 = new Modchu_ModelRenderer(this, 0, 25); //ForeArm
    	rightArm2.addBox(-1.001F, -0F, -1.5F, 2, 8, 3, f);

    	leftArm2 = new Modchu_ModelRenderer(this, 10, 25);
    	leftArm2.mirror = true;
    	leftArm2.addBox(-0.999F, -0F, -1.5F, 2, 8, 3, f);

    	rightArm = new Modchu_ModelRenderer(this, 0, 16); //UpperArm
    	rightArm.addBox(-1F, -1F, -1F, 2, 6, 3, f);
    	rightArm.addChild(rightArm2);

    	leftArm = new Modchu_ModelRenderer(this, 10, 16);
    	leftArm.mirror = true;
    	leftArm.addBox(-1F, -1F, -1F, 2, 6, 3, f);
    	leftArm.addChild(leftArm2);

    	/* LEGS */
    	rightLeg2 = new Modchu_ModelRenderer(this, 0, 47); //Below Knee
    	rightLeg2.addBox(-1.6F, -1F, -2F, 3, 10, 4, f);

    	leftLeg2 = new Modchu_ModelRenderer(this, 0, 47);
    	leftLeg2.mirror = true;
    	leftLeg2.addBox(-1.4F, -1F, -2F, 3, 10, 4, f);

    	rightLeg = new Modchu_ModelRenderer(this, 0, 36); //Above Knee
    	rightLeg.addBox(-1.5F, -1F, -1.7F, 3, 7, 4, f+0.2F);
    	rightLeg.addChild(rightLeg2);

    	leftLeg = new Modchu_ModelRenderer(this, 0, 36);
    	leftLeg.mirror = true;
    	leftLeg.addBox(-1.5F, -1F, -1.7F, 3, 7, 4, f+0.2F);
    	leftLeg.addChild(leftLeg2);

    	/* SKIRT */
    	hemSkirtR2 = new Modchu_ModelRenderer(this, 68, 48);
		hemSkirtR2.addBox(-3.5F, -2F, -4.5F, 7, 8, 8, f+0.2F);

    	hemSkirtL2 = new Modchu_ModelRenderer(this, 98, 48);
    	hemSkirtL2.mirror = true;
		hemSkirtL2.addBox(-3.5F, -2F, -4.5F, 7, 8, 8, f+0.2F);

    	hemSkirtR1 = new Modchu_ModelRenderer(this, 69, 34);
    	hemSkirtR1.addBox(-3F, -1F, -5F, 6, 7, 7, f);
    	rightLeg2.addChild(hemSkirtR2);

    	hemSkirtL1 = new Modchu_ModelRenderer(this, 99, 34);
    	hemSkirtL1.mirror = true;
    	hemSkirtL1.addBox(-3F, -1F, -5F, 6, 7, 7, f);
    	leftLeg2.addChild(hemSkirtL2);

    	Skirt = new Modchu_ModelRenderer(this, 18, 48);
		Skirt.addBox(-4F, 0F, -2F, 8, 3, 5, f+0.6F);
    	rightLeg.addChild(hemSkirtR1);
    	leftLeg.addChild(hemSkirtL1);

    	/* BODY */
		breastR = new Modchu_ModelRenderer(this, 20, 20);
    	breastR.addBox(-3F, 0F, -3F, 3, 3, 3, f+0.1F);

    	breastL = new Modchu_ModelRenderer(this, 32, 20);
    	breastL.mirror = true;
    	breastL.addBox(0F, 0F, -3F, 3, 3, 3, f+0.1F);

    	hipBody = new Modchu_ModelRenderer(this, 18, 39);
		hipBody.addBox(-4F, 0F, -2.4F, 8, 4, 5, f-0.2F);

		bipedBody = new Modchu_ModelRenderer(this, 0, 0);
		bipedBody.setTextureOffset(20, 26).addBox(-3F, -8.5F, -2.1F, 6, 9, 4, f); //body
		bipedBody.setTextureOffset(24, 16).addBox(-1F, -9.8F, -1F, 2, 2, 2, f+0.5F); //neck
    	bipedBody.addChild(rightArm);
    	bipedBody.addChild(leftArm);
    	bipedBody.addChild(breastR);
    	bipedBody.addChild(breastL);
    	bipedBody.addChild(hipBody);
    	bipedBody.addChild(rightLeg);
    	bipedBody.addChild(leftLeg);
    	bipedBody.addChild(Skirt);

    	/* LOCAL SPACE */
    	mainFrame = new Modchu_ModelRenderer(this, 0, 0);
    	mainFrame.setRotationPoint(0F, offsetY, 0F);
    	mainFrame.addChild(bipedHead);
    	mainFrame.addChild(bipedBody);

    	bipedRightArm = new Modchu_ModelRenderer(this);
    	bipedLeftArm = new Modchu_ModelRenderer(this);
    	bipedRightLeg = new Modchu_ModelRenderer(this);
    	bipedLeftLeg = new Modchu_ModelRenderer(this);

    	actionPartsInit(f, f1);
    }

    @Override
    public void armsinit(float f, float f1) {
    	super.armsinit(f, f1);
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
    public void actionPartsInit(float f, float f1) {
    	rightHand = new Modchu_ModelRenderer(this, 0, 31);
    	rightHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 3, f);
    	rightArm2.addChild(rightHand);

    	leftHand = new Modchu_ModelRenderer(this, 10, 31);
    	leftHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 3, f);
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

    @Override
    public void skirtFloatsInit(float f, float f1) {
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

	/**
	 * 姿勢制御・初期化
	 */
	@Override
	public void setLivingAnimationsLM(EntityLiving entityliving, float f, float f1, float f2) {
		super.setLivingAnimationsLM(entityliving, f, f1, f2);
		// 背負われ
		this.isRidingMaster = entityliving.ridingEntity instanceof EntityPlayer;

		// 頭上注意
		int i = MathHelper.floor_double(entityliving.posX);
		int j = MathHelper.floor_double(entityliving.boundingBox.maxY + 1.0D);
		int k = MathHelper.floor_double(entityliving.posZ);
		if (!entityliving.isSneaking())
		{
			isSneak = !entityliving.worldObj.isAirBlock(i, j, k);
		}

		//ふわりスカート
        float velY = (float)entityliving.motionY + 0.1F;

		float fwBuf10 = velY * 1F;
		fwBuf10 = fwBuf10>0.5F ? 0.5F : fwBuf10;
		fwBuf10 = fwBuf10<-0.5F ? -0.5F : fwBuf10;
		Skirt.rotationPointY  += fwBuf10;

		float fwBuf11 = velY * 3F;
		fwBuf11 = fwBuf11>1F ? 1F : fwBuf11;
		fwBuf11 = fwBuf11<-2F ? -2F : fwBuf11;
		hemSkirtR1.rotationPointY  += fwBuf11;
		hemSkirtL1.rotationPointY  += fwBuf11;

		float fwBuf12 = velY * 6F;
		fwBuf12 = fwBuf12>1F ? 1F : fwBuf12;
		fwBuf12 = fwBuf12<-3F ? -3F : fwBuf12;
		hemSkirtR2.rotationPointY  += fwBuf12;
		hemSkirtL2.rotationPointY  += fwBuf12;

		float fwBuf2 = velY * 2F;
		fwBuf2 = fwBuf2>0.1F ? 0.1F : fwBuf2;
		fwBuf2 = fwBuf2<-0.7F ? -0.7F : fwBuf2;
		Ponytail.rotateAngleX -= fwBuf2;
		BunchR.rotateAngleZ -= fwBuf2;
		BunchL.rotateAngleZ += fwBuf2;

		if (isMatingFlag
				&& entityliving instanceof EntityVillager) { //村人モデルとしての使用時
			//if ((EntityVillager)entityliving.isMating()) { //"KIMASHITAWA-!"
			if ((Boolean) getObjectInvokeMethod(EntityVillager.class, "isMating", entityliving)) {
				bipedHead.rotateAngleX += 0.15F;
				bipedHead.rotateAngleZ += 0.25F;
				rightArm.rotateAngleX -= 0.3F;
				leftArm.rotateAngleX -= 0.3F;
				rightArm2.rotateAngleX -= 2.1F;
				leftArm2.rotateAngleX -= 2.1F;
				rightArm.rotateAngleZ -= 0.3F;
				leftArm.rotateAngleZ += 0.3F;
				rightArm.rotateAngleY -= 0.3F;
				leftArm.rotateAngleY += 0.3F;
				rightArm2.rotateAngleY -= 0.3F;
				leftArm2.rotateAngleY += 0.3F;
			}
		}

	}

	/**
	 * 姿勢制御・更新差分
	 */
	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		reset(f, f1, f2, f3, f4, f5, entity);

		//顔向き
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

		if (getCapsValueBoolean(caps_getIsRiding))
		{
			// 背負われている
			if(isRidingMaster)
			{
				rightArm2.rotateAngleX -= 1.3F;
				leftArm2.rotateAngleX -= 1.3F;
				rightLeg.rotateAngleX -= 1.1F;
				leftLeg.rotateAngleX -= 1.1F;
				rightLeg2.rotateAngleX += 0.9F;
				leftLeg2.rotateAngleX += 0.9F;
				rightLeg.rotateAngleY += 0.3F;
				leftLeg.rotateAngleY -= 0.3F;
				mainFrame.rotationPointY += 12F;
				mainFrame.rotationPointZ += 1F;
			}
			// 乗り物に乗っている
			else
			{
				rightArm.rotateAngleX -= 0.1F;
				leftArm.rotateAngleX -= 0.1F;
				rightLeg.rotateAngleX -= 1.3F;
				leftLeg.rotateAngleX -= 1.3F;
				rightLeg2.rotateAngleX += 2.5F;
				leftLeg2.rotateAngleX += 2.5F;
				mainFrame.rotationPointY += 4F;
				mainFrame.rotationPointZ += 1F;
				if(!getCapsValueBoolean(caps_getIsWait))
				{
					mainFrame.rotateAngleY += 0.7F;
					bipedHead.rotateAngleY -= 0.7F;
					if (bipedHead.rotateAngleY < -1.5F) {
						bipedHead.rotateAngleY = -1.5F;
					}
					rightLeg2.rotateAngleX -= 0.5F;
					leftLeg2.rotateAngleX -= 0.5F;
					rightLeg.rotateAngleY += 0.3F;
					leftLeg.rotateAngleY += 0.3F;
					rightLeg2.rotateAngleY += 0.2F;
					leftLeg2.rotateAngleY += 0.2F;
					bipedBody.rotateAngleY += 0.3F;
					hipBody.rotateAngleY += 0.3F;
					hemSkirtR1.rotationPointX += 2F;
					hemSkirtL1.rotationPointX += 2F;
					// hemSkirtR2.rotationPointZ -= 1F;
					//hemSkirtL2.rotationPointZ -= 1F;
				}
			}
		}
		else
		{
			if (getCapsValueBoolean(caps_getIsSneak)) //しゃがみ
			{
				if (getCapsValueBoolean(caps_getIsWait))
				{//膝立ち
					rightLeg.rotateAngleX -= 0.1F;
					leftLeg.rotateAngleX -= 0.2F;
					rightLeg2.rotateAngleX += 1.7F;
					leftLeg2.rotateAngleX += 1.8F;
					mainFrame.rotationPointY += 6F;
				}
				else
				{//中腰
					bipedHead.rotationPointY += 1.0F;
					bipedBody.rotationPointY += 1.0F;
					rightLeg.rotationPointY -= 1.0F;
					leftLeg.rotationPointY -= 1.0F;
					bipedBody.rotateAngleX += 0.5F;
					hipBody.rotateAngleX -= 0.1F + MathHelper.sin(f2 * 0.057F) * 0.03F;
					rightArm.rotateAngleX += 0.1F;
					leftArm.rotateAngleX += 0.1F;
					rightLeg.rotateAngleY -= 0.07F;
					leftLeg.rotateAngleY += 0.07F;
					rightLeg.rotateAngleX -= 0.7F;
					leftLeg.rotateAngleX -= 0.7F;
					rightLeg2.rotateAngleX += 0.32F;
					leftLeg2.rotateAngleX += 0.22F;
					//mainFrame.rotationPointY += 0.4F;
				}
				//しゃがみ歩行
				float f15 = MathHelper.sin(f * 0.6565F); //wave1
				float f16 = MathHelper.cos(f * 0.6565F); //wave2
				float f22 = f15 > f16 ? f15 : f16; //upper wave
				float f35 = f15 < f16 ? f15 : f16; //lower wave

				rightArm.rotateAngleX -= f15 * 0.2F * f1;
				leftArm.rotateAngleX += f15 * 0.2F * f1;
				rightArm2.rotateAngleX -= f22 * 0.7F * f1;
				leftArm2.rotateAngleX += f35 * 0.7F * f1;

				rightLeg.rotateAngleX += f15 * 0.2F * f1;
				leftLeg.rotateAngleX -= f15 * 0.2F * f1;
				rightLeg2.rotateAngleX += f22 * 0.7F * f1;
				leftLeg2.rotateAngleX -= f35 * 0.7F * f1;

				bipedBody.rotateAngleY -= f15 * 0.1F * f1;
				hipBody.rotateAngleY += f15 * 0.1F * f1 - bipedBody.rotateAngleY;
				breastR.rotateAngleX -= f16 * f16 * 0.18F * f1 - MathHelper.sin(f2 * 0.057F) * 0.05F;
				breastL.rotateAngleX -= f16 * f16 * 0.18F * f1 - MathHelper.sin(f2 * 0.057F) * 0.05F;
				mainFrame.rotationPointY += f16 * f16 * 0.5F;
			}
			else
			{
				//通常歩行
				float f15 = MathHelper.sin(f * 0.4444F); //wave1
				float f16 = MathHelper.cos(f * 0.4444F); //wave2
				float f22 = f15 > f16 ? f15 : f16; //upper wave
				float f35 = f15 < f16 ? f15 : f16; //lower wave

				rightArm.rotateAngleX -= f15 * 0.7F * f1;
				leftArm.rotateAngleX += f15 * 0.7F * f1;
				rightArm2.rotateAngleX -= f22 * 0.7F * f1;
				leftArm2.rotateAngleX += f35 * 0.7F * f1;

				rightLeg.rotateAngleX += f15 * 0.9F * f1;
				leftLeg.rotateAngleX -= f15 * 0.9F * f1;
				rightLeg2.rotateAngleX += f22 * 0.9F * f1;
				leftLeg2.rotateAngleX -= f35 * 0.9F * f1;

				bipedBody.rotateAngleY -= f15 * 0.2F * f1;
				hipBody.rotateAngleY += f15 * 0.3F * f1 - bipedBody.rotateAngleY;
				breastR.rotateAngleX -= f16 * f16 * 0.18F * f1 - MathHelper.sin(f2 * 0.057F) * 0.05F;
				breastL.rotateAngleX -= f16 * f16 * 0.18F * f1 - MathHelper.sin(f2 * 0.057F) * 0.05F;
				mainFrame.rotationPointY += f16 * f16 * 0.1F;
			}
		}

		// アイテム持ってるときの腕振りを抑える+表示角オフセット
		if (heldItemLeft != 0)
		{
			leftArm.rotateAngleX = leftArm.rotateAngleX * 0.5F - (float)Math.PI * 0.1F * heldItemLeft;
		}
		if (heldItemRight != 0)
		{
			rightArm.rotateAngleX = rightArm.rotateAngleX * 0.5F - (float)Math.PI * 0.1F * heldItemRight;
		}
		armSwing(f, f1, f2, f3, f4, f5, entity);

		if (getCapsValueBoolean(caps_getIsWait))
		{// 待機状態 腕
			rightArm.rotateAngleX += MathHelper.sin(f2 * 0.057F) * 0.05F - 0.5F;
			rightArm.rotateAngleZ -= 0.3F;
			Arms[0].rotateAngleZ -= 1.5F;
			Arms[0].rotateAngleX -= 0.5F;
			Arms[0].rotateAngleY += 1.5F;
			leftArm.rotateAngleX += MathHelper.sin(f2 * 0.057F) * 0.05F - 0.5F;
			leftArm.rotateAngleZ += 0.3F;
			Arms[1].rotateAngleZ += 1.5F;
			Arms[1].rotateAngleX -= 0.5F;
			Arms[1].rotateAngleY -= 1.5F;
			breastR.rotationPointX += 0.1F;
			breastL.rotationPointX -= 0.1F;
		}
		else
		{
			if (aimedBow)
			{// 弓構え 腕
				float f6 = MathHelper.sin(onGround * 3.141593F);
				float f7 = MathHelper.sin((1.0F - (1.0F - onGround) * (1.0F - onGround)) * 3.141593F);
				rightArm.rotateAngleZ = 0.0F;
				leftArm.rotateAngleZ = 0.0F;
				rightArm.rotateAngleY = -(0.1F - f6 * 0.6F);
				leftArm.rotateAngleY = 0.1F - f6 * 0.6F;
				rightArm.rotateAngleX = -1.470796F;
				leftArm.rotateAngleX = -1.470796F;
				rightArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
				leftArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
				rightArm.rotateAngleZ += MathHelper.cos(f2 * 0.08F) * 0.03F + 0.05F;
				leftArm.rotateAngleZ -= MathHelper.cos(f2 * 0.08F) * 0.03F + 0.05F;
				rightArm.rotateAngleX += MathHelper.sin(f2 * 0.057F) * 0.05F;
				leftArm.rotateAngleX -= MathHelper.sin(f2 * 0.057F) * 0.05F;
				rightArm.rotateAngleX += bipedHead.rotateAngleX;
				leftArm.rotateAngleX += bipedHead.rotateAngleX;
				rightArm.rotateAngleY += bipedHead.rotateAngleY;
				leftArm.rotateAngleY += bipedHead.rotateAngleY;
			}
			else
			{// 通常
				rightArm.rotateAngleZ += 0.2F;
				leftArm.rotateAngleZ -= 0.2F;
				rightArm2.rotateAngleZ += 0.05F;
				leftArm2.rotateAngleZ -= 0.05F;
				rightArm.rotateAngleZ += MathHelper.cos(f2 * 0.08F) * 0.03F + 0.05F;
				leftArm.rotateAngleZ -= MathHelper.cos(f2 * 0.08F) * 0.03F + 0.05F;
				rightArm.rotateAngleX += MathHelper.sin(f2 * 0.057F) * 0.05F;
				leftArm.rotateAngleX -= MathHelper.sin(f2 * 0.057F) * 0.05F;
			}
		}

		//
		((Modchu_ModelRenderer) Arms[2]).setRotateAngle(-0.78539816339744830961566084581988F - ((Modchu_ModelRenderer) rightArm).getRotateAngleX(), 0F, 0F);
		((Modchu_ModelRenderer) Arms[3]).setRotateAngle(-0.78539816339744830961566084581988F - ((Modchu_ModelRenderer) leftArm).getRotateAngleX(), 0F, 0F);

		//脚部追従
		float sinBody1X = MathHelper.sin(bipedBody.rotateAngleX);
		float cosBody1X = 1F - MathHelper.cos(bipedBody.rotateAngleX);
		float sinBody2X = MathHelper.sin(bipedBody.rotateAngleX + hipBody.rotateAngleX);
		float cosBody2X = 1F - MathHelper.cos(bipedBody.rotateAngleX + hipBody.rotateAngleX);
		float sinBody2Y = MathHelper.sin(bipedBody.rotateAngleY + hipBody.rotateAngleY);
		float cosBody2Y = 1F - MathHelper.cos(bipedBody.rotateAngleY + hipBody.rotateAngleY);

		bipedHead.rotationPointZ -= -headPosY * sinBody1X;
		bipedHead.rotationPointY += -headPosY * cosBody1X;
	}

    @Override
    public void reset(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		//INIT POSITION
		bipedHead.setRotationPoint (0F, headPosY, 0F);
		 HeadMount.setRotationPoint (0F, 0F, 0F);
		 eyeR.setRotationPointLM (0F, 0F, 0F);
		 eyeL.setRotationPointLM (0F, 0F, 0F);
		 Ponytail.setRotationPoint (0F, -5.2F, 5F);
		 BunchR.setRotationPoint (-4.5F, -5.5F, 1.7F);
		 BunchL.setRotationPoint ( 4.5F, -5.5F, 1.7F);

		rightArm.setRotationPoint(-4F, bodyPosY - 7.5F, 0F);
		 rightArm2.setRotationPoint(0F, 5F, 0.5F);
		  Arms[0].setRotationPoint(-0.5F, 7F, 0F);
		leftArm.setRotationPoint(4F, bodyPosY - 7.5F, 0F);
		 leftArm2.setRotationPoint(0F, 5F, 0.5F);
		  Arms[1].setRotationPoint(0.5F, 7F, 0F);

		rightLeg.setRotationPoint(-2F, legPosY, 0F);
		 rightLeg2.setRotationPoint(0F, 6F, 0F);
		leftLeg.setRotationPoint(2F, legPosY, 0F);
		 leftLeg2.setRotationPoint(0F, 6F, 0F);

		Skirt.setRotationPoint(0F, legPosY - 3F, 0F);
		 hemSkirtR1.setRotationPoint(0F, 0F, 2F);
		 hemSkirtL1.setRotationPoint(0F, 0F, 2F);
		  hemSkirtR2.setRotationPoint(0F, 0F, 1F);
		  hemSkirtL2.setRotationPoint(0F, 0F, 1F);

		bipedBody.setRotationPoint(0F, bodyPosY, 0F);
		 breastR.setRotationPoint(-0.5F, -7.2F, -2.1F);
		 breastL.setRotationPoint(0.5F, -7.2F, -2.1F);
		 hipBody.setRotationPoint(0F, 0F, 0F);

		mainFrame.setRotationPoint(0F, offsetY, 0F);

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

		rightArm.rotateAngleX = 0F;
		rightArm.rotateAngleY = 0F;
		rightArm.rotateAngleZ = 0F;
		 rightArm2.rotateAngleX = 0F;
		 rightArm2.rotateAngleY = 0F;
		 rightArm2.rotateAngleZ = 0F;
		  Arms[0].rotateAngleX = 0F;
		  Arms[0].rotateAngleY = 0F;
		  Arms[0].rotateAngleZ = 0F;
		leftArm.rotateAngleX  = 0F;
		leftArm.rotateAngleY  = 0F;
		leftArm.rotateAngleZ  = 0F;
		 leftArm2.rotateAngleX  = 0F;
		 leftArm2.rotateAngleY  = 0F;
		 leftArm2.rotateAngleZ  = 0F;
		  Arms[1].rotateAngleX = 0F;
		  Arms[1].rotateAngleY = 0F;
		  Arms[1].rotateAngleZ = 0F;

		rightLeg.rotateAngleX =-0.05F;
		rightLeg.rotateAngleY = 0.05F;
		rightLeg.rotateAngleZ =-0.05F;
		 rightLeg2.rotateAngleX = 0.5F;
		 rightLeg2.rotateAngleY =-0.1F;
		 rightLeg2.rotateAngleZ = 0.02F;
		leftLeg.rotateAngleX  =-0.05F;
		leftLeg.rotateAngleY  =-0.05F;
		leftLeg.rotateAngleZ  = 0.05F;
		 leftLeg2.rotateAngleX  = 0.5F;
		 leftLeg2.rotateAngleY  = 0.1F;
		 leftLeg2.rotateAngleZ  =-0.02F;

		Skirt.rotateAngleX = 0F;
		Skirt.rotateAngleY = 0F;
		Skirt.rotateAngleZ = 0F;
		 hemSkirtR1.rotateAngleX = 0F;
		 hemSkirtR1.rotateAngleY = 0F;
		 hemSkirtR1.rotateAngleZ = 0.05F;
		 hemSkirtL1.rotateAngleX = 0F;
		 hemSkirtL1.rotateAngleY = 0F;
		 hemSkirtL1.rotateAngleZ = -0.05F;
		  hemSkirtR2.rotateAngleX = 0F;
		  hemSkirtR2.rotateAngleY = 0F;
		  hemSkirtR2.rotateAngleZ = -0.03F;
		  hemSkirtL2.rotateAngleX = 0F;
		  hemSkirtL2.rotateAngleY = 0F;
		  hemSkirtL2.rotateAngleZ = 0.03F;

		bipedBody.rotateAngleX = -0.1F;
		bipedBody.rotateAngleY = 0F;
		 breastR.rotateAngleX = 0.785F;
		 breastR.rotateAngleY = 0F;
		 breastR.rotateAngleZ = -0.15F;
		 breastL.rotateAngleX = 0.785F;
		 breastL.rotateAngleY = 0F;
		 breastL.rotateAngleZ = 0.15F;
		 hipBody.rotateAngleX = 0.2F;
		 hipBody.rotateAngleY = 0F;
		 hipBody.rotateAngleZ = 0F;

		mainFrame.rotateAngleX = 0F;
		mainFrame.rotateAngleY = 0F;
		mainFrame.rotateAngleZ = 0F;
    }

    @Override
    public void armSwing(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
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
    		// 腕振り
    		float f6, f7, f8;
    		f6 = MathHelper.sin(MathHelper.sqrt_float(onGroundR) * (float)Math.PI * 2.0F);
    		f7 = MathHelper.sin(MathHelper.sqrt_float(onGroundL) * (float)Math.PI * 2.0F);
    		bipedBody.rotateAngleY = (f6 - f7) * 0.2F;
    		// R
    		if (onGroundR > 0F) {
    			f6 = 1.0F - onGroundR;
    			f6 *= f6;
    			f6 *= f6;
    			f6 = 1.0F - f6;
    			f7 = MathHelper.sin(f6 * (float)Math.PI);
    			f8 = MathHelper.sin(onGroundR * (float)Math.PI) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
    			rightArm.rotateAngleX -= (double)f7 * 1.2D + (double)f8;
    			rightArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
    			rightArm.rotateAngleZ = MathHelper.sin(onGroundR * 3.141593F) * -0.4F;
    		}
    		// L
    		if (onGroundL > 0F) {
    			f6 = 1.0F - onGroundL;
    			f6 *= f6;
    			f6 *= f6;
    			f6 = 1.0F - f6;
    			f7 = MathHelper.sin(f6 * (float)Math.PI);
    			f8 = MathHelper.sin(onGroundL * (float)Math.PI) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
    			leftArm.rotateAngleX -= (double)f7 * 1.2D + (double)f8;
    			leftArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
    			leftArm.rotateAngleZ = MathHelper.sin(onGroundL * 3.141593F) * 0.4F;
    		}
    	}
    }

    @Override
    public void setRotationAnglesfirstPerson(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	if (((EntityPlayer) entity).inventory.getCurrentItem() != null) {
    		//地図を持っている時
    		rightArm.rotationPointX = 0.0F;
    		rightArm.rotationPointY = 1.5F;
    		rightArm.rotationPointZ = 0.0F;
    		leftArm.rotationPointX = -9.5F;
    		leftArm.rotationPointY = 2.0F;
    		leftArm.rotationPointZ = 0.0F;
    	} else {
    		//素手時
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
    public void actionInit1() {
    	setCapsValue(caps_shortcutKeysAction, true);
    	boolean b = true;
    	setCapsValue(caps_visible, rightArm, b);
    	setCapsValue(caps_visible, rightArm2, b);
    	setCapsValue(caps_visible, rightHand, b);
    	setCapsValue(caps_visible, leftArm, b);
    	setCapsValue(caps_visible, leftArm2, b);
    	setCapsValue(caps_visible, leftHand, b);
    	setCapsValue(caps_visible, rightLeg, b);
    	setCapsValue(caps_visible, rightLeg2, b);
    	setCapsValue(caps_visible, leftLeg, b);
    	setCapsValue(caps_visible, leftLeg2, b);
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
    	setCapsValue(caps_visible, rightHand, b);
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
    	bipedRightArm.rotationPointX = rightArm.rotationPointX;
    	bipedRightArm.rotationPointY = rightArm.rotationPointY;
    	bipedRightArm.rotationPointZ = rightArm.rotationPointZ;
    	bipedLeftArm.rotationPointX = leftArm.rotationPointX;
    	bipedLeftArm.rotationPointY = leftArm.rotationPointY;
    	bipedLeftArm.rotationPointZ = leftArm.rotationPointZ;

    	bipedRightLeg.rotationPointX = rightLeg.rotationPointX;
    	bipedRightLeg.rotationPointY = rightLeg.rotationPointY;
    	bipedRightLeg.rotationPointZ = rightLeg.rotationPointZ;
    	bipedLeftLeg.rotationPointY = leftLeg.rotationPointY;
    	bipedLeftLeg.rotationPointZ = leftLeg.rotationPointZ;
    	bipedRightLeg.rotationPointY = rightLeg2.rotationPointY;
    	super.action1(entity);

    	float f1 = bipedBody.rotateAngleZ;
    	if (f1 > 0.0F) {
    		bipedHead.rotationPointY = bipedBody.rotationPointY - 9.0F + (f1 * 1.30889264F);
    		rightHand.rotationPointY = leftHand.rotationPointY = 8.0F - f1 * 1.30889264F;
    	} else {
    		bipedHead.rotationPointY = bipedBody.rotationPointY - 9.0F - (f1 * 1.30889264F);
    		rightHand.rotationPointY = leftHand.rotationPointY = 8.0F;
    	}
    	bipedHead.rotationPointX = f1 * 8.10447914F;
    	rightHand.rotationPointX = leftHand.rotationPointX = 0.0F;
    	rightHand.rotationPointZ = -0.5F;
    	leftHand.rotationPointZ = -0.5F;
    	rightLeg.rotationPointY -= 1.0F;
	}

    @Override
    public void action4(Entity entity) {
    	// 両手を前に出すモーション
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
    	Ponytail.isHidden = !b;
    	BunchR.isHidden = !b;
    	BunchL.isHidden = !b;
    }

    @Override
    public void setArmorBipedBodyShowModel(boolean b) {
    	super.setArmorBipedBodyShowModel(b);
    	breastR.isHidden = !b;
    	breastL.isHidden = !b;
    	hipBody.isHidden = !b;
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
    	setCapsValue(caps_visible, hemSkirtR1, b);
    	setCapsValue(caps_visible, hemSkirtR2, b);
    	rightLeg.isHidden = !b;
    	hemSkirtR1.isHidden = !b;
    	hemSkirtR2.isHidden = !b;
    }

    @Override
    public void setArmorBipedLeftLegShowModel(boolean b) {
    	super.setArmorBipedLeftLegShowModel(b);
    	setCapsValue(caps_visible, hemSkirtL1, b);
    	setCapsValue(caps_visible, hemSkirtL2, b);
    	leftLeg.isHidden = !b;
    	hemSkirtL1.isHidden = !b;
    	hemSkirtL2.isHidden = !b;
    }

    @Override
    public void setArmorSkirtShowModel(boolean b) {
    	setCapsValue(caps_visible, Skirt, b);
    	Skirt.isHidden = !b;
    	//Modchu_Debug.mDebug("setArmorSkirtShowModel b="+b);
    }

    @Override
    public void defaultPartsSettingBefore() {
    	super.defaultPartsSettingBefore();
    	String[] s = {
    			"hemSkirtR1", "hemSkirtL1", "hemSkirtR2", "hemSkirtL2"
    	};
    	showPartsHideListadd(s);
    }

    @Override
    public void showModelSettingReflects() {
    	super.showModelSettingReflects();
    	if (getCapsValueBoolean(caps_skirtFloats)) {
    		setCapsValue(caps_visible, Skirt, getGuiParts().get("Skirt"));
    		if (getGuiParts().get("Skirt") != null) setCapsValue(caps_indexOfAllVisible, "Skirt");
    	}
    }
}
