package net.minecraft.src;

public class MultiModel_SA extends MultiModel_Aug {
	public Modchu_ModelRenderer ChignonAug_R;
	public Modchu_ModelRenderer ChignonAug_L;
	public Modchu_ModelRenderer Chignon_RB;
	public Modchu_ModelRenderer Chignon_LB;
	public Modchu_ModelRenderer Chignon_U;
	public Modchu_ModelRenderer SideTailAug_RU;
	public Modchu_ModelRenderer SideTailAug_RB;
	public Modchu_ModelRenderer SideTailAug_LU;
	public Modchu_ModelRenderer SideTailAug_LB;
	public Modchu_ModelRenderer SideTail_RBU;
	public Modchu_ModelRenderer SideTail_RBB;
	public Modchu_ModelRenderer SideTail_LBU;
	public Modchu_ModelRenderer SideTail_LBB;
	public Modchu_ModelRenderer SideTailUpper_LB;
	public Modchu_ModelRenderer SideTailUpper_RB;
	public Modchu_ModelRenderer Tail_T;
	public Modchu_ModelRenderer Tail_U;
	public Modchu_ModelRenderer Tail_B;
	public Modchu_ModelRenderer Headwear_F;
	public Modchu_ModelRenderer Headwear_B;
	public Modchu_ModelRenderer Headwear_R;
	public Modchu_ModelRenderer Headwear_L;
	public Modchu_ModelRenderer Shaggy_F;
	public Modchu_ModelRenderer LongHair_F;
	public Modchu_ModelRenderer LongHair_B;
	public Modchu_ModelRenderer LongHair_R;
	public Modchu_ModelRenderer LongHair_L;
	public Modchu_ModelRenderer Cheek_R;
	public Modchu_ModelRenderer Cheek_L;
	public Modchu_ModelRenderer Breast1;
	public Modchu_ModelRenderer Breast2;

	public MultiModel_SA() {
		this(0.0F);
	}

	public MultiModel_SA(float f) {
		this(f, 0.0F);
	}

	public MultiModel_SA(float f, float f1) {
		this(f, f1, 64, 64);
	}

	public MultiModel_SA(float f, float f1, int i, int j) {
		super(f, f1, i, j);
	}

	@Override
	public void initModel(float f, float f1) {
		textureWidth = 64;
		textureHeight = 64;
		f1 += 8F;
		bipedHead = new Modchu_ModelRenderer(this, 0, 0);
		bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, f);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody = new Modchu_ModelRenderer(this, 32, 8);
		bipedBody.addBox(-3.0F, -3.5F, -2.0F, 6, 7, 4, f);
		bipedBody.setRotationPoint(0.0F, -3.0F, 0.0F);
		bipedRightArm = new Modchu_ModelRenderer(this, 48, 0);
		bipedRightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
		bipedRightArm.setRotationPoint(-3.0F, 4.5F, 0.0F);
		bipedBody.addChild(bipedRightArm);
		bipedLeftArm = new Modchu_ModelRenderer(this, 56, 0);
		bipedLeftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
		bipedLeftArm.setRotationPoint(3.0F, 4.5F, 0.0F);
		bipedBody.addChild(bipedLeftArm);
		bipedRightLeg = new Modchu_ModelRenderer(this, 32, 19);
		bipedRightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);
		bipedRightLeg.setRotationPoint(-1.5F, 15F, 0.0F);
		bipedBody.addChild(bipedRightLeg);
		bipedLeftLeg = new Modchu_ModelRenderer(this, 32, 19);
		bipedLeftLeg.mirror = true;
		bipedLeftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);
		bipedLeftLeg.setRotationPoint(1.5F, 15F, 0.0F);
		bipedBody.addChild(bipedLeftLeg);
		Skirt = new Modchu_ModelRenderer(this, 0, 16);
		Skirt.addBox(-4F, -4F, -4F, 8, 8, 8, f);
		Skirt.setRotationPoint(0.0F, 2.0F, 0.0F);
		bipedBody.addChild(Skirt);
		ChignonR = new Modchu_ModelRenderer(this, 8, 48);
		ChignonR.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 1, f);
		ChignonR.setRotationPoint(-4F, -5.5F, 1.7F);
		ChignonR.rotateAngleY = -((float)Math.PI / 2F);
		bipedHead.addChild(ChignonR);
		ChignonL = new Modchu_ModelRenderer(this, 8, 48);
		ChignonL.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 1, f);
		ChignonL.setRotationPoint(4F, -5.5F, 1.7F);
		ChignonL.rotateAngleY = ((float)Math.PI / 2F);
		bipedHead.addChild(ChignonL);
		ChignonB = new Modchu_ModelRenderer(this, 52, 10);
		ChignonB.addBox(-2F, -7.2F, 4F, 4, 4, 2, f);
		ChignonB.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(ChignonB);
		SideTailR = new Modchu_ModelRenderer(this, 26, 40);
		SideTailR.addBox(-5.5F, -6.8F, 0.9F, 1, 8, 2, f);
		SideTailR.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(SideTailR);
		SideTailL = new Modchu_ModelRenderer(this, 26, 40);
		SideTailL.mirror = true;
		SideTailL.addBox(4.5F, -6.8F, 0.9F, 1, 8, 2, f);
		SideTailL.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(SideTailL);
		ChignonAug_R = new Modchu_ModelRenderer(this, 0, 48);
		ChignonAug_R.addBoxLM(-1.5F, -1.5F, 0.0F, 3, 3, 1, f);
		ChignonAug_R.setRotationPointLM(-4F, -7F, 1.7F);
		ChignonAug_R.setRotateAngleY(-((float) Math.PI / 2F));
		ChignonAug_L = new Modchu_ModelRenderer(this, 0, 52);
		ChignonAug_L.addBoxLM(-1.5F, -1.5F, 0.0F, 3, 3, 1, f);
		ChignonAug_L.setRotationPointLM(4F, -7F, 1.7F);
		ChignonAug_L.setRotateAngleY(((float) Math.PI / 2F));
		Chignon_RB = new Modchu_ModelRenderer(this, 0, 56);
		Chignon_RB.addBoxLM(-4.5F, -7F, 4F, 3, 3, 1, f);
		Chignon_RB.setRotationPointLM(0.0F, -1.5F, 0.0F);
		Chignon_LB = new Modchu_ModelRenderer(this, 0, 60);
		Chignon_LB.addBoxLM(1.5F, -7F, 4F, 3, 3, 1, f);
		Chignon_LB.setRotationPointLM(0.0F, -1.5F, 0.0F);
		Chignon_U = new Modchu_ModelRenderer(this, 0, 42);
		Chignon_U.addBoxLM(-2F, -17.2F, 3F, 4, 4, 2, f);
		Chignon_U.setRotationPointLM(0.0F, 8.0F, 0.0F);
		SideTailAug_RU = new Modchu_ModelRenderer(this, 32, 40);
		SideTailAug_RU.addBox(-2F, -0.5F, -1F, 2, 10, 2, f);
		SideTailAug_RU.setRotationPointLM(-4.5F, -7.8F, 1.9F);
		SideTailAug_RB = new Modchu_ModelRenderer(this, 32, 52);
		SideTailAug_RB.addBoxLM(-1F, 0.0F, -2F, 2, 10, 2, f);
		SideTailAug_RB.setRotationPointLM(-1F, 9.5F, 1.0F);
		SideTailAug_LU = new Modchu_ModelRenderer(this, 40, 40);
		SideTailAug_LU.addBox(0.0F, -0.5F, -1F, 2, 10, 2, f);
		SideTailAug_LU.setRotationPointLM(4.5F, -7.8F, 1.9F);
		SideTailAug_LB = new Modchu_ModelRenderer(this, 40, 52);
		SideTailAug_LB.addBoxLM(-1F, 0.0F, -2F, 2, 10, 2, f);
		SideTailAug_LB.setRotationPointLM(1.0F, 9.5F, 1.0F);
		SideTail_RBU = new Modchu_ModelRenderer(this, 48, 40);
		SideTail_RBU.addBox(-1F, -0.5F, -0.5F, 2, 10, 2, f);
		SideTail_RBU.setRotationPointLM(-3F, -7.8F, 5F);
		SideTail_RBB = new Modchu_ModelRenderer(this, 48, 52);
		SideTail_RBB.addBoxLM(-1F, 0.0F, -2F, 2, 10, 2, f);
		SideTail_RBB.setRotationPointLM(0.0F, 9.5F, 1.5F);
		SideTail_LBU = new Modchu_ModelRenderer(this, 56, 40);
		SideTail_LBU.addBox(-1F, -0.5F, -0.5F, 2, 10, 2, f);
		SideTail_LBU.setRotationPointLM(3F, -7.8F, 5F);
		SideTail_LBB = new Modchu_ModelRenderer(this, 56, 52);
		SideTail_LBB.addBoxLM(-1F, 0.0F, -2F, 2, 10, 2, f);
		SideTail_LBB.setRotationPointLM(0.0F, 9.5F, 1.5F);
		sidetailUpperR = new Modchu_ModelRenderer(this, 0, 32);
		sidetailUpperR.addBoxLM(-4F, 0.0F, -1F, 4, 3, 2, f + 0.1F);
		sidetailUpperR.setRotationPointLM(-3.5F, -9.5F, 1.9F);
		sidetailUpperL = new Modchu_ModelRenderer(this, 0, 37);
		sidetailUpperL.addBoxLM(0.0F, 0.0F, -1F, 4, 3, 2, f + 0.1F);
		sidetailUpperL.setRotationPointLM(3.5F, -9.5F, 1.9F);
		SideTailUpper_RB = new Modchu_ModelRenderer(this, 12, 32);
		SideTailUpper_RB.addBoxLM(-4F, 0.0F, -1F, 4, 3, 2, f + 0.1F);
		SideTailUpper_RB.setRotationPointLM(-3F, -9.5F, 3.5F);
		SideTailUpper_RB.setRotateAngleY(((float) Math.PI / 2F));
		SideTailUpper_LB = new Modchu_ModelRenderer(this, 12, 37);
		SideTailUpper_LB.addBoxLM(0.0F, 0.0F, -1F, 4, 3, 2, f + 0.1F);
		SideTailUpper_LB.setRotationPointLM(3F, -9.5F, 3.5F);
		SideTailUpper_LB.setRotateAngleY(-((float) Math.PI / 2F));
		Tail_T = new Modchu_ModelRenderer(this, 12, 42);
		Tail_T.addBoxLM(-1.5F, -1.5F, 0.0F, 3, 3, 3, f);
		Tail_T.setRotationPointLM(0.0F, -8.3F, 4F);
		Tail_U = new Modchu_ModelRenderer(this, 8, 52);
		Tail_U.addBoxLM(-1.5F, 0.0F, 0.0F, 3, 9, 3, f);
		Tail_U.setRotationPointLM(0.0F, -6.8F, 4F);
		Tail_B = new Modchu_ModelRenderer(this, 20, 52);
		Tail_B.addBoxLM(-1.5F, 0.0F, -3F, 3, 9, 3, f);
		Tail_B.setRotationPointLM(0.0F, 9.0F, 3F);
		Headwear_F = new Modchu_ModelRenderer(this, 24, 16);
		Headwear_F.addPlate(-4F, 0.0F, 0.0F, 8, 4, 0, f);
		Headwear_F.setRotationPointLM(0.0F, 0.0F, -4F);
		Headwear_B = new Modchu_ModelRenderer(this, 24, 20);
		Headwear_B.addPlate(-4F, 0.0F, 0.0F, 8, 4, 4, f);
		Headwear_B.setRotationPointLM(0.0F, 0.0F, 4F);
		Headwear_R = new Modchu_ModelRenderer(this, 44, 0);
		Headwear_R.addPlate(0.0F, 0.0F, 0.0F, 4, 4, 5, f);
		Headwear_R.setRotationPointLM(-4F, 0.0F, 0.0F);
		Headwear_L = new Modchu_ModelRenderer(this, 44, 4);
		Headwear_L.addPlate(0.0F, 0.0F, 0.0F, 4, 4, 1, f);
		Headwear_L.setRotationPointLM(4F, 0.0F, 0.0F);
		Shaggy_F = new Modchu_ModelRenderer(this, 34, 0);
		Shaggy_F.addPlate(-5F, 0.0F, 0.0F, 10, 4, 0, f);
		Shaggy_F.setRotationPointLM(0.0F, -1.0F, -4F);
		Shaggy_F.setRotateAngleX(-0.4F);
		shaggyB = new Modchu_ModelRenderer(this, 24, 0);
		shaggyB.addPlate(-5F, 0.0F, 0.0F, 10, 4, 4, f);
		shaggyB.setRotationPointLM(0.0F, -1.0F, 4F);
		shaggyB.setRotateAngleX(0.4F);
		shaggyR = new Modchu_ModelRenderer(this, 24, 4);
		shaggyR.addPlate(0.0F, 0.0F, -5F, 10, 4, 5, f);
		shaggyR.setRotationPointLM(-4F, -1.0F, 0.0F);
		shaggyR.setRotateAngleZ(0.4F);
		shaggyL = new Modchu_ModelRenderer(this, 34, 4);
		shaggyL.addPlate(0.0F, 0.0F, -5F, 10, 4, 1, f);
		shaggyL.setRotationPointLM(4F, -1.0F, 0.0F);
		shaggyL.setRotateAngleZ(-0.4F);
		LongHair_F = new Modchu_ModelRenderer(this, 34, 32);
		LongHair_F.addPlate(-5F, 0.0F, 0.0F, 10, 8, 4, f);
		LongHair_F.setRotationPointLM(0.0F, -1.0F, -4F);
		LongHair_F.setRotateAngleY((float) Math.PI);
		LongHair_F.setRotateAngleX(0.202458F);
		LongHair_B = new Modchu_ModelRenderer(this, 24, 32);
		LongHair_B.addPlate(-5F, 0.0F, 0.0F, 10, 8, 4, f);
		LongHair_B.setRotationPointLM(0.0F, -1.0F, 4F);
		LongHair_B.setRotateAngleX(0.202458F);
		LongHair_R = new Modchu_ModelRenderer(this, 44, 32);
		LongHair_R.addPlate(0.0F, 0.0F, -5F, 10, 8, 5, f);
		LongHair_R.setRotationPointLM(-4F, -1.0F, 0.0F);
		LongHair_R.setRotateAngleZ(0.202458F);
		LongHair_L = new Modchu_ModelRenderer(this, 54, 32);
		LongHair_L.addPlate(0.0F, 0.0F, -5F, 10, 8, 1, f);
		LongHair_L.setRotationPointLM(4F, -1.0F, 0.0F);
		LongHair_L.setRotateAngleZ(-0.202458F);
		sensor1 = new Modchu_ModelRenderer(this, 0, 0);
		sensor1.addPlate(-8F, -4F, -8.0F, 8, 4, 0, f);
		sensor1.setRotationPointLM(-5.0F, -7.0F, 4.0F);
		sensor2 = new Modchu_ModelRenderer(this, 0, 4);
		sensor2.addPlate(0.0F, -4F, 0.0F, 8, 4, 0, f);
		sensor2.setRotationPointLM(0.0F, -8.0F, 0.0F);
		sensor3 = new Modchu_ModelRenderer(this, 0, 20);
		sensor3.addPlate(0.0F, -4F, -0F, 8, 4, 1, f);
		sensor3.setRotationPointLM(0.0F, -8.0F, 0.0F);
		sensor4 = new Modchu_ModelRenderer(this, 0, 16);
		sensor4.addPlate(0.0F, -4F, -8F, 8, 4, 1, f);
		sensor4.setRotationPointLM(0.0F, -8.0F, 0.0F);
		eyeR = new Modchu_ModelRenderer(this, 42, 19);
		eyeR.addPlate(-4F, -4.9F, -4.001F, 4, 4, 0, f);
		eyeR.setRotationPointLM(0.0F, 0.0F, 0.0F);
		eyeL = new Modchu_ModelRenderer(this, 46, 19);
		eyeL.addPlate(0.0F, -4.9F, -4.001F, 4, 4, 0, f);
		eyeL.setRotationPointLM(0.0F, 0.0F, 0.0F);
		Cheek_R = new Modchu_ModelRenderer(this, 32, 8);
		Cheek_R.addPlate(-4.5F, -4.5F, -4.002F, 4, 4, 0, f);
		Cheek_R.setRotationPointLM(0.0F, 1.0F, 0.0F);
		Cheek_L = new Modchu_ModelRenderer(this, 32, 19);
		Cheek_L.addPlate(0.5F, -4.5F, -4.002F, 4, 4, 0, f);
		Cheek_L.setRotationPointLM(0.0F, 1.0F, 0.0F);
		Breast1 = new Modchu_ModelRenderer(this, 17, 49);
		Breast1.addBoxLM(0.0F, -2.5F, 0.0F, 2, 5, 1, f);
		Breast1.setRotationPointLM(0.0F, -2.5F, -2F);
		Breast1.setRotateAngleZ(((float) Math.PI / 2F));
		Breast1.setRotateAngleY(0.4363323F);
		Breast2 = new Modchu_ModelRenderer(this, 56, 16);
		Breast2.addBoxLM(0.0F, -2.5F, 0.0F, 2, 5, 2, f);
		Breast2.setRotationPointLM(0.0F, -2.5F, -2F);
		Breast2.setRotateAngleZ(((float) Math.PI / 2F));
		Breast2.setRotateAngleY(((float) Math.PI * 2F / 9F));
		bipedHead.addChild(ChignonAug_R);
		bipedHead.addChild(ChignonAug_L);
		bipedHead.addChild(Chignon_RB);
		bipedHead.addChild(Chignon_LB);
		bipedHead.addChild(Chignon_U);
		bipedHead.addChild(SideTailAug_RU);
		bipedHead.addChild(SideTailAug_LU);
		SideTailAug_RU.addChild(SideTailAug_RB);
		SideTailAug_LU.addChild(SideTailAug_LB);
		bipedHead.addChild(SideTail_RBU);
		bipedHead.addChild(SideTail_LBU);
		SideTail_RBU.addChild(SideTail_RBB);
		SideTail_LBU.addChild(SideTail_LBB);
		bipedHead.addChild(sidetailUpperR);
		bipedHead.addChild(sidetailUpperL);
		bipedHead.addChild(SideTailUpper_LB);
		bipedHead.addChild(SideTailUpper_RB);
		bipedHead.addChild(Tail_T);
		bipedHead.addChild(Tail_U);
		Tail_U.addChild(Tail_B);
		bipedHead.addChild(Headwear_F);
		bipedHead.addChild(Headwear_B);
		bipedHead.addChild(Headwear_R);
		bipedHead.addChild(Headwear_L);
		bipedHead.addChild(Shaggy_F);
		bipedHead.addChild(shaggyB);
		bipedHead.addChild(shaggyR);
		bipedHead.addChild(shaggyL);
		bipedHead.addChild(LongHair_F);
		bipedHead.addChild(LongHair_B);
		bipedHead.addChild(LongHair_R);
		bipedHead.addChild(LongHair_L);
		bipedHead.addChild(sensor1);
		bipedHead.addChild(sensor2);
		bipedHead.addChild(sensor3);
		bipedHead.addChild(sensor4);
		bipedHead.addChild(eyeR);
		bipedHead.addChild(eyeL);
		bipedHead.addChild(Cheek_R);
		bipedHead.addChild(Cheek_L);
		bipedBody.addChild(Breast1);
		bipedBody.addChild(Breast2);
		mainFrame = new Modchu_ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, 0F + f1, 0F);
		mainFrame.addChild(bipedHead);
		mainFrame.addChild(bipedBody);
		actionPartsInit(f, f1);
	}

	public void setLivingAnimationsLM(EntityLiving entityliving, float f,
			float f1, float f2) {
		super.setLivingAnimationsLM(entityliving, f, f1, f2);
		if (getCapsValueBoolean(caps_isLookSuger)) {
			Cheek_R.setVisible(true);
			Cheek_L.setVisible(true);
		} else {
			Cheek_R.setVisible(false);
			Cheek_L.setVisible(false);
		}
		float f3 = (float) entityliving.ticksExisted + f2
				+ getCapsValueFloat(caps_entityIdFactor);
		float f4 = 0.0F;
		if (getCapsValueBoolean(caps_isLookSuger)) {
			f3 *= 8.0F;
			f4 = -0.2F;
		} else {
			f4 = (1F - (float) entityliving.health / 20F) * 0.5F;
		}
		sensor1.rotateAngleX = 0.0F;
		sensor1.rotateAngleY = -((float) Math.PI * 2F / 9F);
		sensor1.rotateAngleZ = mh_sin(f3 * 0.067F) * 0.05F - f4;
		sensor2.rotateAngleX = sensor2.rotateAngleZ = -(mh_sin(f3 * 0.067F) * 0.05F - f4);
		sensor2.rotateAngleY = ((float) Math.PI * 2F / 9F);
		sensor3.rotateAngleX = (mh_sin(f3 * 0.067F) * 0.05F + 0.370796F) - f4;
		sensor3.rotateAngleY = mh_sin(f3 * 0.09F) * 0.4F;
		sensor3.rotateAngleZ = mh_cos(f3 * 0.09F) * 0.2F;
		sensor4.rotateAngleX = mh_sin(f3 * 0.067F) * 0.05F + f4;
		sensor4.rotateAngleY = mh_cos(f3 * 0.09F) * 0.5F;
		sensor4.rotateAngleZ = mh_sin(f3 * 0.09F) * 0.2F;
	}

	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);
		SideTailR.rotateAngleX = SideTailL.rotateAngleX = 0.0F;
		sensor1.rotationPointY = -8.0F;
		if (((Modchu_ModelRenderer) bipedHead).getRotateAngleX() < 0.0F)
		{
			SideTailAug_RU.setRotateAngleX(-((Modchu_ModelRenderer) bipedHead).getRotateAngleX());
			SideTailAug_LU.setRotateAngleX(-((Modchu_ModelRenderer) bipedHead).getRotateAngleX());
			SideTailAug_RB.setRotateAngleX(0.0F);
			SideTailAug_LB.setRotateAngleX(0.0F);
			SideTail_RBU.setRotateAngleX(-((Modchu_ModelRenderer) bipedHead).getRotateAngleX());
			SideTail_LBU.setRotateAngleX(-((Modchu_ModelRenderer) bipedHead).getRotateAngleX());
			SideTail_RBB.setRotateAngleX(0.0F + ((Modchu_ModelRenderer) Skirt).getRotateAngleX());
			SideTail_LBB.setRotateAngleX(0.0F + ((Modchu_ModelRenderer) Skirt).getRotateAngleX());
			Tail_U.setRotateAngleX(-((Modchu_ModelRenderer) bipedHead).getRotateAngleX());
			Tail_B.setRotateAngleX(0.0F + ((Modchu_ModelRenderer) Skirt).getRotateAngleX());
		}
		else
		{
			SideTailAug_RU.setRotateAngleX(0.0F);
			SideTailAug_LU.setRotateAngleX(0.0F);
			SideTailAug_RB.setRotateAngleX(-((Modchu_ModelRenderer) bipedHead).getRotateAngleX() + ((Modchu_ModelRenderer) Skirt).getRotateAngleX());
			SideTailAug_LB.setRotateAngleX(-((Modchu_ModelRenderer) bipedHead).getRotateAngleX() + ((Modchu_ModelRenderer) Skirt).getRotateAngleX());
			SideTail_RBU.setRotateAngleX(0.0F);
			SideTail_LBU.setRotateAngleX(0.0F);
			SideTail_RBB.setRotateAngleX(-((Modchu_ModelRenderer) bipedHead).getRotateAngleX() + ((Modchu_ModelRenderer) Skirt).getRotateAngleX());
			SideTail_LBB.setRotateAngleX(-((Modchu_ModelRenderer) bipedHead).getRotateAngleX() + ((Modchu_ModelRenderer) Skirt).getRotateAngleX());
			Tail_U.setRotateAngleX(0.0F);
			Tail_B.setRotateAngleX(-((Modchu_ModelRenderer) bipedHead).getRotateAngleX() + ((Modchu_ModelRenderer) Skirt).getRotateAngleX());
		}
    }

	@Override
	public void defaultPartsSettingBefore() {
		super.defaultPartsSettingBefore();
    	String[] s1 = {
    			"ChignonAug_R", "ChignonAug_L", "SideTailAug_RU", "SideTailAug_RB", "SideTailAug_LU",
    			"SideTailAug_LB", "SideTail_RBU", "SideTail_RBB", "SideTail_LBU", "SideTail_LBB",
    			"SideTailUpper_LB","SideTailUpper_RB"
    	};
    	String[] s2 = {
    			"ChignonA_R", "ChignonA_L", "SideTA_RU", "SideTA_RB", "SideTA_LU",
    			"SideTA_LB", "SideT_RBU", "SideT_RBB", "SideT_LBU", "SideT_LBB",
    			"SideTU_LB", "SideTU_RB"
    	};
		addShowPartsReneme(s1, s2);
	}

	@Override
	public void defaultPartsSettingAfter() {
		// Cheek Default off
		setGuiParts("Cheek", false);
	}
}
