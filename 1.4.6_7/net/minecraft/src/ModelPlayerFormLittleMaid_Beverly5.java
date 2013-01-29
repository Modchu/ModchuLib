package net.minecraft.src;

import org.lwjgl.opengl.GL11;

/**
 * 多関節モデル
 * 身長2.25ブロック級
 */
public class ModelPlayerFormLittleMaid_Beverly5 extends ModelPlayerFormLittleMaid_SR2 {

	//added fields
	public Modchu_ModelRenderer Ponytail;
	public Modchu_ModelRenderer BunchR;
	public Modchu_ModelRenderer BunchL;
	public Modchu_ModelRenderer upperRightArm;
	public Modchu_ModelRenderer upperLeftArm;
	public Modchu_ModelRenderer upperRightLeg;
	public Modchu_ModelRenderer upperLeftLeg;
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

	/**
	 * コンストラクタは全て継承させること
	 */
	public ModelPlayerFormLittleMaid_Beverly5()
	{
		super();
	}
	/**
	 * コンストラクタは全て継承させること
	 */
	public ModelPlayerFormLittleMaid_Beverly5(float f)
	{
		super(f);
	}
	/**
	 * コンストラクタは全て継承させること
	 */
	public ModelPlayerFormLittleMaid_Beverly5(float f, float f1)
	{
    	// 132deletesuper(f, f1);
//-@-132
    	this(f, f1 , 64, 64);
    }

    public ModelPlayerFormLittleMaid_Beverly5(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
//@-@132
/*
    	((Modchu_ModelRenderer) bipedRightArm).removeChild(Arms[0]);
    	((Modchu_ModelRenderer) bipedRightArm).removeChild(Arms[2]);
    	((Modchu_ModelRenderer) bipedLeftArm).removeChild(Arms[1]);
    	((Modchu_ModelRenderer) bipedLeftArm).removeChild(Arms[3]);
    	rightArm2.addChild(Arms[0]);
    	rightArm2.addChild(Arms[2]);
    	leftArm2.addChild(Arms[1]);
    	leftArm2.addChild(Arms[3]);
*/
    }

    @Override
    public void initModel(float f, float f1) {
		textureHeight = 64;
		textureWidth = 64;

		offsetY = (byte)(f1 + 5); //Global to Local

		bodyPosY = 0; //Local waist height = always 0 (ORIGIN)
		headPosY = -9; //Local neck height = 0 - upper bodyLength
		legPosY = 4; //Lcal hip joint height = 0 + lower bodyLength

		/* HEAD */
		eyeR = new Modchu_ModelRenderer(this, 17, 0);
		eyeR.addPlate(-3.0F, -4F, -4.01F, 2, 3, 0, f);

		eyeL = new Modchu_ModelRenderer(this, 21, 0);
		eyeL.addPlate(1.0F, -4F, -4.01F, 2, 3, 0, f);

		Ponytail = new Modchu_ModelRenderer(this, 32, 13);
		Ponytail.addBox(-1.5F, -1.5F, -1F, 3, 9, 3, f);

		BunchR = new Modchu_ModelRenderer(this, 20, 16);
		BunchR.addBox(-1F, -1.3F, -0.8F, 1, 9, 2, f);

		BunchL = new Modchu_ModelRenderer(this, 26, 16);
		 BunchL.mirror = true;
		BunchL.addBox(0F, -1.3F, -0.8F, 1, 9, 2, f);

		bipedHead = new Modchu_ModelRenderer(this, 0, 0);
		bipedHead.setTextureOffset(0, 0).addBox(-4F, -8F, -4F, 8, 8, 8, f);			// Head
		bipedHead.setTextureOffset(32, 0).addBox(-4F, -0.7F, -4F, 8, 5, 8, f+0.3F);		// Hire
		bipedHead.setTextureOffset(31, 25).addBox(-2F, -7.2F, 4F, 4, 4, 2, f);		// ChignonB
		bipedHead.setTextureOffset(28, 39).addBox(-5F, -7F, 0.2F, 1, 3, 3, f);		// ChignonR
		((Modchu_ModelRenderer) bipedHead).setMirror(true);
		bipedHead.setTextureOffset(28, 45).addBox(4F, -7F, 0.2F, 1, 3, 3, f);		// ChignonL
		 bipedHead.addChild(HeadMount);
		 bipedHead.addChild(eyeR);
		 bipedHead.addChild(eyeL);
		 bipedHead.addChild(Ponytail);
		 bipedHead.addChild(BunchR);
		 bipedHead.addChild(BunchL);

		/* ARMS */
		Arms = new Modchu_ModelRenderer[18]; //Hand
		// 手持ち
		Arms[0] = new Modchu_ModelRenderer(this, 0, 0);
		Arms[0].setRotationPointLM(-0.5F, 7F, 0F);
		Arms[1] = new Modchu_ModelRenderer(this, 0, 0);
		Arms[1].setRotationPoint(0.5F, 7F, 0F);
		Arms[1].isInvertX = true;
		// バイプロダクトエフェクター
		Arms[2] = new Modchu_ModelRenderer(this, 0, 0);
		Arms[2].setRotationPoint(-3.5F, 11F, 6F);
		Arms[2].setRotateAngle(0.78539816339744830961566084581988F, 0F, 0F);
		Arms[3] = new Modchu_ModelRenderer(this, 0, 0);
		Arms[3].setRotationPoint(3.5F, 11F, 6F);
		Arms[3].setRotateAngle(0.78539816339744830961566084581988F, 0F, 0F);
		Arms[3].isInvertX = true;
		// テールソード
		Arms[4] = new Modchu_ModelRenderer(this, 0, 0);
		Arms[4].setRotationPoint(-2F, 0F, 0F);
		Arms[4].setRotateAngle(3.1415926535897932384626433832795F, 0F, 0F);
		Arms[5] = new Modchu_ModelRenderer(this, 0, 0);
		Arms[5].setRotationPoint(2F, 0F, 0F);
		Arms[5].setRotateAngle(3.1415926535897932384626433832795F, 0F, 0F);

		bipedRightArm = new Modchu_ModelRenderer(this, 0, 25); //ForeArm
		bipedRightArm.addBox(-1F, -0F, -1.5F, 2, 8, 3, f);
		 bipedRightArm.addChild(Arms[0]);
		 bipedRightArm.addChild(Arms[2]);

		bipedLeftArm = new Modchu_ModelRenderer(this, 10, 25);
		 bipedLeftArm.mirror = true;
		bipedLeftArm.addBox(-1F, -0F, -1.5F, 2, 8, 3, f);
		 bipedLeftArm.addChild(Arms[1]);
		 bipedLeftArm.addChild(Arms[3]);

		upperRightArm = new Modchu_ModelRenderer(this, 0, 16); //UpperArm
		upperRightArm.addBox(-1F, -1F, -1F, 2, 6, 3, f);
		 upperRightArm.addChild(bipedRightArm);

		upperLeftArm = new Modchu_ModelRenderer(this, 10, 16);
		 upperLeftArm.mirror = true;
		upperLeftArm.addBox(-1F, -1F, -1F, 2, 6, 3, f);
		 upperLeftArm.addChild(bipedLeftArm);

		/* LEGS */
		bipedRightLeg = new Modchu_ModelRenderer(this, 0, 50); //Below Knee
		bipedRightLeg.addBox(-1.6F, -1F, -2F, 3, 10, 4, f);

		bipedLeftLeg = new Modchu_ModelRenderer(this, 14, 50);
		 bipedLeftLeg.mirror = true;
		bipedLeftLeg.addBox(-1.4F, -1F, -2F, 3, 10, 4, f);

		upperRightLeg = new Modchu_ModelRenderer(this, 0, 39); //Above Knee
		upperRightLeg.addBox(-1.5F, -1F, -1.7F, 3, 7, 4, f+0.2F);
		 upperRightLeg.addChild(bipedRightLeg);

		upperLeftLeg = new Modchu_ModelRenderer(this, 14, 39);
		 upperLeftLeg.mirror = true;
		upperLeftLeg.addBox(-1.5F, -1F, -1.7F, 3, 7, 4, f+0.2F);
		 upperLeftLeg.addChild(bipedLeftLeg);

		/* SKIRT */
		hemSkirtR2 = new Modchu_ModelRenderer(this, 36, 50);
		hemSkirtR2.addBox(-3.5F, -2F, -4F, 7, 7, 7, f+0.2F);

		hemSkirtL2 = new Modchu_ModelRenderer(this, 36, 50);
		 hemSkirtL2.mirror = true;
		hemSkirtL2.addBox(-3.5F, -2F, -4F, 7, 7, 7, f+0.2F);

		hemSkirtR1 = new Modchu_ModelRenderer(this, 36, 36);
		hemSkirtR1.addBox(-3F, -1F, -5F, 6, 7, 7, f);
		 hemSkirtR1.addChild(hemSkirtR2);

		hemSkirtL1 = new Modchu_ModelRenderer(this, 36, 36);
		 hemSkirtL1.mirror = true;
		hemSkirtL1.addBox(-3F, -1F, -5F, 6, 7, 7, f);
		 hemSkirtL1.addChild(hemSkirtL2);

		Skirt = new Modchu_ModelRenderer(this, 15, 31);
		Skirt.addBox(-4F, 0F, -2F, 8, 3, 5, f+0.7F);
		 Skirt.addChild(hemSkirtR1);
		 Skirt.addChild(hemSkirtL1);

		/* BODY */
		breastR = new Modchu_ModelRenderer(this, 28, 2);
		breastR.addBox(-3F, 0F, -3F, 3, 3, 3, f+0.1F);

		breastL = new Modchu_ModelRenderer(this, 28, 51);
		 breastL.mirror = true;
		breastL.addBox(0F, 0F, -3F, 3, 3, 3, f+0.1F);

		hipBody = new Modchu_ModelRenderer(this, 38, 26);
		hipBody.addBox(-4F, 0F, -2.2F, 8, 4, 5, f-0.2F);

		bipedBody = new Modchu_ModelRenderer(this, 44, 13);
		bipedBody.addBox(-3F, -8.5F, -2.1F, 6, 9, 4, f);
		 bipedBody.addChild(upperRightArm);
		 bipedBody.addChild(upperLeftArm);
		 bipedBody.addChild(Arms[4]);
		 bipedBody.addChild(Arms[5]);
		 bipedBody.addChild(breastR);
		 bipedBody.addChild(breastL);
		 bipedBody.addChild(hipBody);

		/* LOCAL SPACE */
		mainFrame = new Modchu_ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, offsetY, 0F);
		 mainFrame.addChild(bipedHead);
		 mainFrame.addChild(bipedBody);
		 mainFrame.addChild(upperRightLeg);
		 mainFrame.addChild(upperLeftLeg);
		 mainFrame.addChild(Skirt);
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
/*
		if (entityliving instanceof EntityVillager) { //村人モデルとしての使用時
			if ((EntityVillager)entityliving.isMating()) { //"KIMASHITAWA-!"
				bipedHead.rotateAngleX += 0.15F;
				bipedHead.rotateAngleZ += 0.25F;
				upperRightArm.rotateAngleX -= 0.3F;
				upperLeftArm.rotateAngleX -= 0.3F;
				bipedRightArm.rotateAngleX -= 2.1F;
				bipedLeftArm.rotateAngleX -= 2.1F;
				upperRightArm.rotateAngleZ -= 0.3F;
				upperLeftArm.rotateAngleZ += 0.3F;
				upperRightArm.rotateAngleY -= 0.3F;
				upperLeftArm.rotateAngleY += 0.3F;
				bipedRightArm.rotateAngleY -= 0.3F;
				bipedLeftArm.rotateAngleY += 0.3F;
			}
		}
*/
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

		if (isRiding)
		{
			// 背負われている
			if(isRidingMaster)
			{
				bipedRightArm.rotateAngleX -= 1.3F;
				bipedLeftArm.rotateAngleX -= 1.3F;
				upperRightLeg.rotateAngleX -= 1.1F;
				upperLeftLeg.rotateAngleX -= 1.1F;
				bipedRightLeg.rotateAngleX += 0.9F;
				bipedLeftLeg.rotateAngleX += 0.9F;
				upperRightLeg.rotateAngleY += 0.3F;
				upperLeftLeg.rotateAngleY -= 0.3F;
				mainFrame.rotationPointY += 12F;
				mainFrame.rotationPointZ += 1F;
			}
			// 乗り物に乗っている
			else
			{
				upperRightArm.rotateAngleX -= 0.1F;
				upperLeftArm.rotateAngleX -= 0.1F;
				upperRightLeg.rotateAngleX -= 1.3F;
				upperLeftLeg.rotateAngleX -= 1.3F;
				bipedRightLeg.rotateAngleX += 2.5F;
				bipedLeftLeg.rotateAngleX += 2.5F;
				mainFrame.rotationPointY += 4F;
				mainFrame.rotationPointZ += 1F;
				if(!isWait)
				{
					mainFrame.rotateAngleY += 0.7F;
					bipedHead.rotateAngleY -= 0.7F;
					if (bipedHead.rotateAngleY < -1.5F) {
						bipedHead.rotateAngleY = -1.5F;
					}
					bipedRightLeg.rotateAngleX -= 0.5F;
					bipedLeftLeg.rotateAngleX -= 0.5F;
					upperRightLeg.rotateAngleY += 0.3F;
					upperLeftLeg.rotateAngleY += 0.3F;
					bipedRightLeg.rotateAngleY += 0.2F;
					bipedLeftLeg.rotateAngleY += 0.2F;
					bipedBody.rotateAngleY += 0.3F;
					hipBody.rotateAngleY += 0.3F;
					hemSkirtR1.rotationPointX += 2F;
					hemSkirtL1.rotationPointX += 2F;
					hemSkirtR2.rotationPointZ -= 1F;
					hemSkirtL2.rotationPointZ -= 1F;
				}
			}
		}
		else
		{
			if (isSneak) //しゃがみ
			{
				if (isWait)
				{//膝立ち
					upperRightLeg.rotateAngleX -= 0.1F;
					upperLeftLeg.rotateAngleX -= 0.2F;
					bipedRightLeg.rotateAngleX += 1.7F;
					bipedLeftLeg.rotateAngleX += 1.8F;
					mainFrame.rotationPointY += 6F;
				}
				else
				{//中腰
					bipedBody.rotateAngleX += 0.7F;
					hipBody.rotateAngleX -= 0.1F + MathHelper.sin(f2 * 0.057F) * 0.03F;
					upperRightArm.rotateAngleX += isWait ? -0.3F : 0.1F;
					upperLeftArm.rotateAngleX += isWait ? -0.3F : 0.1F;
					upperRightLeg.rotateAngleY -= 0.07F;
					upperLeftLeg.rotateAngleY += 0.07F;
					upperRightLeg.rotateAngleX -= 0.37F;
					upperLeftLeg.rotateAngleX -= 0.32F;
					bipedRightLeg.rotateAngleX += 0.32F;
					bipedLeftLeg.rotateAngleX += 0.22F;
					mainFrame.rotationPointY += 0.4F;
				}
				//しゃがみ歩行
				float f15 = MathHelper.sin(f * 0.6565F); //wave1
				float f16 = MathHelper.cos(f * 0.6565F); //wave2
				float f22 = f15 > f16 ? f15 : f16; //upper wave
				float f35 = f15 < f16 ? f15 : f16; //lower wave

				upperRightArm.rotateAngleX -= f15 * 0.2F * f1;
				upperLeftArm.rotateAngleX += f15 * 0.2F * f1;
				bipedRightArm.rotateAngleX -= f22 * 0.7F * f1;
				bipedLeftArm.rotateAngleX += f35 * 0.7F * f1;

				upperRightLeg.rotateAngleX += f15 * 0.2F * f1;
				upperLeftLeg.rotateAngleX -= f15 * 0.2F * f1;
				bipedRightLeg.rotateAngleX += f22 * 0.7F * f1;
				bipedLeftLeg.rotateAngleX -= f35 * 0.7F * f1;

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

				upperRightArm.rotateAngleX -= f15 * 0.7F * f1;
				upperLeftArm.rotateAngleX += f15 * 0.7F * f1;
				bipedRightArm.rotateAngleX -= f22 * 0.7F * f1;
				bipedLeftArm.rotateAngleX += f35 * 0.7F * f1;

				upperRightLeg.rotateAngleX += f15 * 0.9F * f1;
				upperLeftLeg.rotateAngleX -= f15 * 0.9F * f1;
				bipedRightLeg.rotateAngleX += f22 * 0.9F * f1;
				bipedLeftLeg.rotateAngleX -= f35 * 0.9F * f1;

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
			upperLeftArm.rotateAngleX
				= upperLeftArm.rotateAngleX * 0.5F - (float)Math.PI * 0.1F * heldItemLeft;
		}
		if (heldItemRight != 0)
		{
			upperRightArm.rotateAngleX
				= upperRightArm.rotateAngleX * 0.5F - (float)Math.PI * 0.1F * heldItemRight;
		}

		float onGroundR = getOnGround(getSwingStatus(entity, 0), entity);
		float onGroundL = getOnGround(getSwingStatus(entity, 1), entity);
		if ((onGroundR > -9990F || onGroundL > -9990F) && !getaimedBow() && !getOldwalking()) {
			// 腕振り
			float f6, f7, f8;
			f6 = MathHelper.sin(MathHelper.sqrt_float(onGroundR) * (float)Math.PI * 2.0F);
			f7 = MathHelper.sin(MathHelper.sqrt_float(onGroundL) * (float)Math.PI * 2.0F);
			bipedBody.rotateAngleY += (f6 - f7) * 0.2F;
			upperRightArm.rotateAngleY += bipedBody.rotateAngleY;
			upperLeftArm.rotateAngleY += bipedBody.rotateAngleY;
			// R
			if (onGroundR > 0F)
			{
				f6 = 1.0F - onGroundR;
				f7 = MathHelper.sin((1.0F - f6 * f6 * f6 * f6) * (float)Math.PI);
				f8 = MathHelper.sin(onGroundR * (float)Math.PI) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
				upperRightArm.rotateAngleX -= (double)f7 * 1.2D + (double)f8;
				upperRightArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
				upperRightArm.rotateAngleZ += MathHelper.sin(onGroundR * 3.141593F) * -0.4F;
			}
			else
			{
				upperRightArm.rotateAngleX += bipedBody.rotateAngleY;
			}
			// L
			if (onGroundL > 0F)
			{
				f6 = 1.0F - onGroundR;
				f7 = MathHelper.sin((1.0F - f6 * f6 * f6 * f6) * (float)Math.PI);
				f8 = MathHelper.sin(onGroundL * (float)Math.PI) * -(bipedHead.rotateAngleX - 0.7F) * 0.75F;
				upperLeftArm.rotateAngleX -= (double)f7 * 1.2D + (double)f8;
				upperLeftArm.rotateAngleY += bipedBody.rotateAngleY * 2.0F;
				upperLeftArm.rotateAngleZ += MathHelper.sin(onGroundL * 3.141593F) * 0.4F;
			}
			else
			{
				upperLeftArm.rotateAngleX += bipedBody.rotateAngleY;
			}
		}

		if (isWait)
		{// 待機状態 腕
			upperRightArm.rotateAngleX += MathHelper.sin(f2 * 0.057F) * 0.05F - 0.5F;
			upperRightArm.rotateAngleZ -= 0.3F;
			Arms[0].rotateAngleZ -= 1.5F;
			Arms[0].rotateAngleX -= 0.5F;
			Arms[0].rotateAngleY += 1.5F;
			upperLeftArm.rotateAngleX += MathHelper.sin(f2 * 0.057F) * 0.05F - 0.5F;
			upperLeftArm.rotateAngleZ += 0.3F;
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
				upperRightArm.rotateAngleZ = 0.0F;
				upperLeftArm.rotateAngleZ = 0.0F;
				upperRightArm.rotateAngleY = -(0.1F - f6 * 0.6F);
				upperLeftArm.rotateAngleY = 0.1F - f6 * 0.6F;
				upperRightArm.rotateAngleX = -1.470796F;
				upperLeftArm.rotateAngleX = -1.470796F;
				upperRightArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
				upperLeftArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
				upperRightArm.rotateAngleZ += MathHelper.cos(f2 * 0.08F) * 0.03F + 0.05F;
				upperLeftArm.rotateAngleZ -= MathHelper.cos(f2 * 0.08F) * 0.03F + 0.05F;
				upperRightArm.rotateAngleX += MathHelper.sin(f2 * 0.057F) * 0.05F;
				upperLeftArm.rotateAngleX -= MathHelper.sin(f2 * 0.057F) * 0.05F;
				upperRightArm.rotateAngleX += bipedHead.rotateAngleX;
				upperLeftArm.rotateAngleX += bipedHead.rotateAngleX;
				upperRightArm.rotateAngleY += bipedHead.rotateAngleY;
				upperLeftArm.rotateAngleY += bipedHead.rotateAngleY;
			}
			else
			{// 通常
				upperRightArm.rotateAngleZ += 0.2F;
				upperLeftArm.rotateAngleZ -= 0.2F;
				bipedRightArm.rotateAngleZ += 0.05F;
				bipedLeftArm.rotateAngleZ -= 0.05F;
				upperRightArm.rotateAngleZ += MathHelper.cos(f2 * 0.08F) * 0.03F + 0.05F;
				upperLeftArm.rotateAngleZ -= MathHelper.cos(f2 * 0.08F) * 0.03F + 0.05F;
				upperRightArm.rotateAngleX += MathHelper.sin(f2 * 0.057F) * 0.05F;
				upperLeftArm.rotateAngleX -= MathHelper.sin(f2 * 0.057F) * 0.05F;
			}
		}

		//
		Arms[2].setRotateAngle(-0.78539816339744830961566084581988F - upperRightArm.getRotateAngleX(), 0F, 0F);
		Arms[3].setRotateAngle(-0.78539816339744830961566084581988F - upperLeftArm.getRotateAngleX(), 0F, 0F);

		//脚部追従
		float sinBody1X = MathHelper.sin(bipedBody.rotateAngleX);
		float cosBody1X = 1F - MathHelper.cos(bipedBody.rotateAngleX);
		float sinBody2X = MathHelper.sin(bipedBody.rotateAngleX + hipBody.rotateAngleX);
		float cosBody2X = 1F - MathHelper.cos(bipedBody.rotateAngleX + hipBody.rotateAngleX);
		float sinBody2Y = MathHelper.sin(bipedBody.rotateAngleY + hipBody.rotateAngleY);
		float cosBody2Y = 1F - MathHelper.cos(bipedBody.rotateAngleY + hipBody.rotateAngleY);

		bipedHead.rotationPointZ -= -headPosY * sinBody1X;
		bipedHead.rotationPointY += -headPosY * cosBody1X;

		upperRightLeg.rotationPointZ += legPosY * sinBody2X + 2F * sinBody2Y;
		upperLeftLeg.rotationPointZ += legPosY * sinBody2X - 2F * sinBody2Y;
		upperRightLeg.rotationPointY -= legPosY * cosBody2X;
		upperLeftLeg.rotationPointY -= legPosY * cosBody2X;
		upperRightLeg.rotationPointX += 2F * cosBody2Y;
		upperLeftLeg.rotationPointX -= 2F * cosBody2Y;
		upperRightLeg.rotateAngleY += bipedBody.rotateAngleY + hipBody.rotateAngleY;
		upperLeftLeg.rotateAngleY += bipedBody.rotateAngleY + hipBody.rotateAngleY;

		mainFrame.rotationPointY += legPosY * cosBody2X;

		//スカート追従
		Skirt.rotationPointZ += legPosY * sinBody2X;
		Skirt.rotationPointY -= legPosY * cosBody2X;

		float jsUp = (upperRightLeg.rotateAngleX + upperLeftLeg.rotateAngleX) / 2F - bipedBody.rotateAngleX - 0.05F;
		Skirt.rotateAngleX += jsUp * 0.2F;
		Skirt.rotateAngleY += bipedBody.rotateAngleY + hipBody.rotateAngleY;

		float jsR1 = upperRightLeg.rotateAngleX - Skirt.rotateAngleX + 0.05F;
		float jsL1 = upperLeftLeg.rotateAngleX - Skirt.rotateAngleX + 0.05F;
		hemSkirtR1.rotateAngleX += jsR1 * (jsR1 * -0.1F + 1F);
		hemSkirtL1.rotateAngleX += jsL1 * (jsL1 * -0.1F + 1F);
		hemSkirtR1.rotateAngleY += upperRightLeg.rotateAngleY * 0.8F;
		hemSkirtL1.rotateAngleY += upperLeftLeg.rotateAngleY * 0.8F;

		float jsR2 = bipedRightLeg.rotateAngleX - upperRightLeg.rotateAngleX;
		float jsL2 = bipedLeftLeg.rotateAngleX - upperLeftLeg.rotateAngleX;
		hemSkirtR2.rotateAngleX += jsR2 * 0.8F + hemSkirtR1.rotateAngleX * 0.2F;
		hemSkirtL2.rotateAngleX += jsL2 * 0.8F + hemSkirtL1.rotateAngleX * 0.2F;
	}

    @Override
    public void reset(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		//INIT POSITION
		bipedHead.setRotationPoint (0F, headPosY, 0F);
		 HeadMount.setRotationPoint (0F, -4F, 0F);
		 eyeR.setRotationPointLM (0F, 0F, 0F);
		 eyeL.setRotationPointLM (0F, 0F, 0F);
		 Ponytail.setRotationPoint (0F, -5.2F, 5F);
		 BunchR.setRotationPoint (-4.5F, -5.5F, 1.7F);
		 BunchL.setRotationPoint ( 4.5F, -5.5F, 1.7F);

		upperRightArm.setRotationPoint(-4F, bodyPosY - 7.5F, 0F);
		 bipedRightArm.setRotationPoint(0F, 5F, 0.5F);
		  Arms[0].setRotationPointLM(-0.5F, 7F, 0F);
		upperLeftArm.setRotationPoint(4F, bodyPosY - 7.5F, 0F);
		 bipedLeftArm.setRotationPoint(0F, 5F, 0.5F);
		  Arms[1].setRotationPoint(0.5F, 7F, 0F);

		upperRightLeg.setRotationPoint(-2F, legPosY, 0F);
		 bipedRightLeg.setRotationPoint(0F, 6F, 0F);
		upperLeftLeg.setRotationPoint(2F, legPosY, 0F);
		 bipedLeftLeg.setRotationPoint(0F, 6F, 0F);

		Skirt.setRotationPoint(0F, legPosY - 3F, 0F);
		 hemSkirtR1.setRotationPoint(-2F, 3F, 2F);
		 hemSkirtL1.setRotationPoint(2F, 3F, 2F);
		  hemSkirtR2.setRotationPoint(0F, 6F, -1F);
		  hemSkirtL2.setRotationPoint(0F, 6F, -1F);

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

		upperRightArm.rotateAngleX = 0F;
		upperRightArm.rotateAngleY = 0F;
		upperRightArm.rotateAngleZ = 0F;
		 bipedRightArm.rotateAngleX = 0F;
		 bipedRightArm.rotateAngleY = 0F;
		 bipedRightArm.rotateAngleZ = 0F;
		  Arms[0].rotateAngleX = 0F;
		  Arms[0].rotateAngleY = 0F;
		  Arms[0].rotateAngleZ = 0F;
		upperLeftArm.rotateAngleX  = 0F;
		upperLeftArm.rotateAngleY  = 0F;
		upperLeftArm.rotateAngleZ  = 0F;
		 bipedLeftArm.rotateAngleX  = 0F;
		 bipedLeftArm.rotateAngleY  = 0F;
		 bipedLeftArm.rotateAngleZ  = 0F;
		  Arms[1].rotateAngleX = 0F;
		  Arms[1].rotateAngleY = 0F;
		  Arms[1].rotateAngleZ = 0F;

		upperRightLeg.rotateAngleX =-0.05F;
		upperRightLeg.rotateAngleY = 0.05F;
		upperRightLeg.rotateAngleZ =-0.05F;
		 bipedRightLeg.rotateAngleX = 0.05F;
		 bipedRightLeg.rotateAngleY =-0.1F;
		 bipedRightLeg.rotateAngleZ = 0.02F;
		upperLeftLeg.rotateAngleX  =-0.05F;
		upperLeftLeg.rotateAngleY  =-0.05F;
		upperLeftLeg.rotateAngleZ  = 0.05F;
		 bipedLeftLeg.rotateAngleX  = 0.05F;
		 bipedLeftLeg.rotateAngleY  = 0.1F;
		 bipedLeftLeg.rotateAngleZ  =-0.02F;

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
		bipedBody.rotateAngleZ = 0F;
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
}
