package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class MultiModel_Kelo extends MultiModel {

	public Modchu_ModelRenderer tailL1;
	public Modchu_ModelRenderer tailL2;
	public Modchu_ModelRenderer tailR1;
	public Modchu_ModelRenderer tailR2;
    public Modchu_ModelRenderer BreastPocket;
    public Modchu_ModelRenderer LsidePocket;
    public Modchu_ModelRenderer RsidePocket;
    public Modchu_ModelRenderer Backpack;
    public Modchu_ModelRenderer BackpackPocket;
    public Modchu_ModelRenderer Zipper;
    public Modchu_ModelRenderer SleeveR;
    public Modchu_ModelRenderer SleeveL;
    public Modchu_ModelRenderer ShoesL;
    public Modchu_ModelRenderer ShoesR;
    public Modchu_ModelRenderer KeloeyeL1;
    public Modchu_ModelRenderer KeloeyeR1;
    public Modchu_ModelRenderer KeloeyeL2;
    public Modchu_ModelRenderer KeloeyeR2;

    public Modchu_ModelRenderer eyeL;
    public Modchu_ModelRenderer eyeR;
    public Modchu_ModelRenderer headwear;
    public Modchu_ModelRenderer rightHandPlus;
    public Modchu_ModelRenderer leftHandPlus;

    public MultiModel_Kelo()
    {
        this(0.0F);
    }

    public MultiModel_Kelo(float f)
    {
        this(f, 0.0F);
    }

    public MultiModel_Kelo(float f, float f1)
    {
    	this(f, f1 , 64, 32);
    }

    public MultiModel_Kelo(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
    }

	@Override
	public void initModel(float f, float f1) {
		super.initModel(f, f1);
		((Modchu_ModelRenderer) mainFrame).removeChild(bipedHead);
		((Modchu_ModelRenderer) mainFrame).removeChild(bipedBody);
		((Modchu_ModelRenderer) bipedHead).removeChild(ChignonR);
		((Modchu_ModelRenderer) bipedHead).removeChild(ChignonL);
		((Modchu_ModelRenderer) bipedHead).removeChild(ChignonB);
		((Modchu_ModelRenderer) bipedHead).removeChild(SideTailR);
		((Modchu_ModelRenderer) bipedHead).removeChild(SideTailL);
		tailL1 = new Modchu_ModelRenderer(this, 0, 0);
		tailL1.addBox(1.5F, -2.5F, 3.5F, 2, 2, 2, f);
		tailL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(tailL1);
		tailL2 = new Modchu_ModelRenderer(this, 27, 16);
		tailL2.addBox(2F, -1F, 4.5F, 3, 3, 3, f);
		tailL2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(tailL2);
		tailR1 = new Modchu_ModelRenderer(this, 0, 4);
		tailR1.addBox(-3.5F, -2.5F, 3.5F, 2, 2, 2, f);
		tailR1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(tailR1);
		tailR2 = new Modchu_ModelRenderer(this, 48, 19);
		tailR2.addBox(-5F, -1F, 4.5F, 3, 3, 3, f);
		tailR2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(tailR2);
		SideTailL = new Modchu_ModelRenderer(this, 56, 3);
		SideTailL.mirror = true;
		SideTailL.addBox(3.1F, -4.1F, -3.5F, 1, 4, 1, f);
		SideTailL.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(SideTailL);
		SideTailR = new Modchu_ModelRenderer(this, 60, 3);
		SideTailR.addBox(-4.1F, -4.1F, -3.5F, 1, 4, 1, f);
		SideTailR.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(SideTailR);
		headwear = new Modchu_ModelRenderer(this, 32, 0);
		headwear.addBox(-4F, -8F, -4.5F, 8, 4, 8, f + 0.5F);
		headwear.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(headwear);
		ChignonR = new Modchu_ModelRenderer(this, 24, 2);
		ChignonR.addBox(-5F, -11F, -2.5F, 4, 3, 3, f);
		ChignonR.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(ChignonR);
		ChignonL = new Modchu_ModelRenderer(this, 24, 2);
		ChignonL.addBox(1F, -11F, -2.5F, 4, 3, 3, f);
		ChignonL.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(ChignonL);
		KeloeyeL1 = new Modchu_ModelRenderer(this, 28, 0);
		KeloeyeL1.addBox(2F, -10F, -2.5F, 2, 2, 0, f - 0.2F);
		KeloeyeL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(KeloeyeL1);
		KeloeyeR1 = new Modchu_ModelRenderer(this, 24, 0);
		KeloeyeR1.addBox(-4F, -10F, -2.5F, 2, 2, 0, f -0.2F);
		KeloeyeR1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(KeloeyeR1);
		KeloeyeL2 = new Modchu_ModelRenderer(this, 36, 0);
		KeloeyeL2.addBox(2F, -9.5F, -2.5F, 2, 1, 0, f - 0.2F);
		KeloeyeL2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(KeloeyeL2);
		KeloeyeR2 = new Modchu_ModelRenderer(this, 32, 0);
		KeloeyeR2.addBox(-4F, -9.5F, -2.5F, 2, 1, 0, f - 0.2F);
		KeloeyeR2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(KeloeyeR2);
		bipedBody = new Modchu_ModelRenderer(this, 12, 19);
		bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 10, 3, f + 0.3F);
		bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		Backpack = new Modchu_ModelRenderer(this, 48, 25);
		Backpack.addBox(-2F, 1F, 1F, 4, 5, 2, f + 0.3F);
		Backpack.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody.addChild(Backpack);
		BackpackPocket = new Modchu_ModelRenderer(this, 48, 27);
		BackpackPocket.addBox(-2F, 3.2F, 0.5F, 4, 2, 2, f + 0.6F);
		BackpackPocket.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody.addChild(BackpackPocket);
		BreastPocket = new Modchu_ModelRenderer(this, 24, 16);
		BreastPocket.addBox(1F, 2F, -2.5F, 2, 2, 1, f);
		BreastPocket.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody.addChild(BreastPocket);
		LsidePocket = new Modchu_ModelRenderer(this, 32, 12);
		LsidePocket.addBox(2.5F, 6F, -2.5F, 1, 2, 2, f);
		LsidePocket.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody.addChild(LsidePocket);
		RsidePocket = new Modchu_ModelRenderer(this, 32, 12);
		RsidePocket.addBox(-3.5F, 6F, -2.5F, 1, 2, 2, f);
		RsidePocket.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody.addChild(RsidePocket);
		Zipper = new Modchu_ModelRenderer(this, 30, 22);
		Zipper.addBox(-1.5F, -1F, -1.5F, 3, 10, 0, f - 1F);
		Zipper.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody.addChild(Zipper);
		Skirt = new Modchu_ModelRenderer(this, 46, 12);
		Skirt.addBox(-3F, -2F, -2F, 6, 2, 3, f + 0.8F);
		Skirt.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody.addChild(Skirt);
		bipedRightArm = new Modchu_ModelRenderer(this, 36, 19);
		bipedRightArm.addBox(-1.5F, 0.0F, -1.5F, 3, 10, 3, f - 0.3F);
		bipedRightArm.setRotationPoint(-3.0F, 4.5F, 0.5F);
		bipedBody.addChild(bipedRightArm);
		SleeveR = new Modchu_ModelRenderer(this, 36, 14);
		SleeveR.addBox(-3F, 3.5F, -2F, 3, 2, 3, f + 0.1F);
		SleeveR.setRotationPoint(1.5F, 2.0F, 0.5F);
		bipedRightArm.addChild(SleeveR);
		bipedLeftArm = new Modchu_ModelRenderer(this, 36, 19);
		bipedLeftArm.mirror = true;
		bipedLeftArm.addBox(-1.5F, 0.0F, -1.5F, 3, 10, 3, f - 0.3F);
		bipedLeftArm.setRotationPoint(3.5F, 0.0F, 0.5F);
		bipedBody.addChild(bipedLeftArm);
		SleeveL = new Modchu_ModelRenderer(this, 36, 14);
		SleeveL.mirror = true;
		SleeveL.addBox(0F, 3.5F, -2F, 3, 2, 3, f + 0.1F);
		SleeveL.setRotationPoint(-1.5F, 2.0F, 0.5F);
		bipedLeftArm.addChild(SleeveL);
		bipedRightLeg = new Modchu_ModelRenderer(this, 0, 19);
		bipedRightLeg.addBox(-1.5F, 0.0F, -1.5F, 3, 10, 3, f);
		bipedRightLeg.setRotationPoint(-1.5F, 0.0F, 0.0F);
		bipedBody.addChild(bipedRightLeg);
		bipedLeftLeg = new Modchu_ModelRenderer(this, 0, 19);
		bipedLeftLeg.mirror = true;
		bipedLeftLeg.addBox(-1.5F, 0.0F, -1.5F, 3, 10, 3, f);
		bipedLeftLeg.setRotationPoint(1.5F, 0.0F, 0.0F);
		bipedBody.addChild(bipedLeftLeg);
		ShoesR = new Modchu_ModelRenderer(this, 0, 16);
		ShoesR.addBox(-2F, 8F, -3F, 3, 2, 1, f);
		ShoesR.setRotationPoint(0.5F, 0.0F, 0.5F);
		bipedRightLeg.addChild(ShoesR);
		ShoesL = new Modchu_ModelRenderer(this, 0, 16);
		ShoesL.mirror = true;
		ShoesL.addBox(-2F, 8F, -3F, 3, 2, 1, f);
		ShoesL.setRotationPoint(0.5F, 0.0F, 0.5F);
		bipedLeftLeg.addChild(ShoesL);
		eyeL = new Modchu_ModelRenderer(this, 16, 16);
		eyeL.addBoxLM(0F, -4F, -4.001F, 4, 3, 0, f + 0.001F);
		eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(eyeL);
		eyeR = new Modchu_ModelRenderer(this, 8, 16);
		eyeR.addBoxLM(-4F, -4F, -4.001F, 4, 3, 0, f + 0.001F);
		eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(eyeR);

		mainFrame.addChild(bipedHead);
		mainFrame.addChild(bipedBody);
		mainFrame.setRotationPoint(0.0F, 0.0F, 0.0F);
		setCapsValue(caps_visible, bipedHeadwear, false);
		setCapsValue(caps_visible, ChignonB, false);
		setCapsValue(caps_visible, Tail, false);
		actionPartsInit(f, f1);
    }

	public void actionPartsInit(float f, float f1) {
		rightArm = new Modchu_ModelRenderer(this, 36, 19);
		rightArm.addBox(-1.0F, 0.0F, -1.0F, 3, 4, 3, f - 0.3F);
		rightArm.setRotationPoint(-3.0F, 1.5F + f1, 0.0F);
		bipedBody.addChild(rightArm);

		rightArmPlus = new Modchu_ModelRenderer(this);
		((Modchu_ModelRenderer) rightArmPlus.setTextureOffset(39, 19)).addPlate(-1.5F + 0.5F, -1.5F + 0.5F, -3.01F - 0.4F, 3, 3, 4, f - 0.3F);
		rightArmPlus.rotateAngleX = 1.570796313F;
		rightArm.addChild(rightArmPlus);

		rightArm2 = new Modchu_ModelRenderer(this, 36, 23);
		rightArm2.addBox(-1.0F, 0.0F, -1.0F, 3, 4, 3, f - 0.3F);
		rightArm2.setRotationPoint(0.0F, -5.0F + f1, 0.0F);
		rightArm.addChild(rightArm2);

		rightArmPlus2 = new Modchu_ModelRenderer(this);
		((Modchu_ModelRenderer) rightArmPlus2.setTextureOffset(39, 19)).addPlate(-1.5F + 0.5F, -1.5F + 0.5F, 0.01F, 3, 3, 4, f - 0.3F);
		((Modchu_ModelRenderer) rightArmPlus2.setTextureOffset(42, 19)).addPlate(-1.5F + 0.5F, -1.5F + 0.5F, -3.01F - 0.4F, 3, 3, 4, f - 0.3F);
		rightArmPlus2.rotateAngleX = 1.570796313F;
		rightArm2.addChild(rightArmPlus2);

		rightHand = new Modchu_ModelRenderer(this, 36, 26);
		rightHand.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, f - 0.3F);
		rightHand.setRotationPoint(0.0F, 4.0F, 0.0F);
		rightArm2.addChild(rightHand);

		rightHandPlus = new Modchu_ModelRenderer(this);
		rightHandPlus.setTextureOffset(39, 29).addPlate(-1.5F, -1.5F, 0.01F + 1.5F, 3, 3, 4, f - 0.3F);
		rightHandPlus.setTextureOffset(39, 29).addPlate(-1.5F, -1.5F, -3.01F + 2.1F, 3, 3, 4, f - 0.3F);
		rightHandPlus.rotateAngleX = 1.570796313F;
		rightHand.addChild(rightHandPlus);

		leftArm = new Modchu_ModelRenderer(this, 36, 19);
		leftArm.addBox(-1.0F, 0.0F, -1.0F, 3, 4, 3, f - 0.3F);
		leftArm.setRotationPoint(3.0F, 1.5F + f1, 0.0F);
		bipedBody.addChild(leftArm);

		leftArmPlus = new Modchu_ModelRenderer(this);
		((Modchu_ModelRenderer) leftArmPlus.setTextureOffset(39, 19)).addPlate(-1.5F + 0.5F, -1.5F + 0.5F, -3.01F - 0.4F, 3, 3, 4, f - 0.3F);
		leftArmPlus.rotateAngleX = 1.570796313F;
		leftArm.addChild(leftArmPlus);

		leftArm2 = new Modchu_ModelRenderer(this, 36, 23);
		leftArm2.addBox(-1.0F, 0.0F, -1.0F, 3, 4, 3, f - 0.3F);
		leftArm2.setRotationPoint(0.0F, -5.0F + f1, 0.0F);
		leftArm.addChild(leftArm2);

		leftArmPlus2 = new Modchu_ModelRenderer(this);
		((Modchu_ModelRenderer) leftArmPlus2.setTextureOffset(39, 19)).addPlate(-1.5F + 0.5F, -1.5F + 0.5F, 0.01F, 3, 3, 4, f - 0.3F);
		((Modchu_ModelRenderer) leftArmPlus2.setTextureOffset(42, 19)).addPlate(-1.5F + 0.5F, -1.5F + 0.5F, -3.01F - 0.4F, 3, 3, 4, f - 0.3F);
		leftArmPlus2.rotateAngleX = 1.570796313F;
		leftArm2.addChild(leftArmPlus2);

		leftHand = new Modchu_ModelRenderer(this, 36, 26);
		leftHand.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, f - 0.3F);
		leftHand.setRotationPoint(0.0F, 4.0F, 0.0F);
		leftArm2.addChild(leftHand);

		leftHandPlus = new Modchu_ModelRenderer(this);
		leftHandPlus.setTextureOffset(39, 29).addPlate(-1.5F, -1.5F, 0.01F + 1.5F, 3, 3, 4, f - 0.3F);
		leftHandPlus.setTextureOffset(39, 29).addPlate(-1.5F, -1.5F, -3.01F + 2.1F, 3, 3, 4, f - 0.3F);
		leftHandPlus.rotateAngleX = 1.570796313F;
		leftHand.addChild(leftHandPlus);

		rightLeg = new Modchu_ModelRenderer(this, 0, 19);
		rightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 3, f);
		rightLeg.setRotationPoint(0.0F, 8.0F, 0.0F);
		bipedBody.addChild(rightLeg);

		rightLegPlus = new Modchu_ModelRenderer(this);
		((Modchu_ModelRenderer) rightLegPlus.setTextureOffset(3, 24)).addPlate(-1.5F, -1.5F - 0.5F, -5.01F, 3, 3, 4, f);
		rightLegPlus.rotateAngleX = 1.570796313F;
		rightLeg.addChild(rightLegPlus);

		rightLeg2 = new Modchu_ModelRenderer(this, 0, 24);
		rightLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 3, f);
		rightLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);
		rightLeg.addChild(rightLeg2);

		rightLegPlus2 = new Modchu_ModelRenderer(this);
		//rightLegPlus2.setTextureOffset(3, 24).addPlate(-1.5F, -1.5F - 0.5F, 0.01F, 3, 3, 4, f);
		((Modchu_ModelRenderer) rightLegPlus2.setTextureOffset(6, 19)).addPlate(-1.5F, -1.5F - 0.5F, -5.01F, 3, 3, 4, f);
		rightLegPlus2.rotateAngleX = 1.570796313F;
		rightLeg2.addChild(rightLegPlus2);

		leftLeg = new Modchu_ModelRenderer(this, 0, 19);
		leftLeg.mirror = true;
		leftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 3, f);
		leftLeg.setRotationPoint(0.0F, 8.0F, 0.0F);
		bipedBody.addChild(leftLeg);

		leftLegPlus = new Modchu_ModelRenderer(this);
		leftLegPlus.mirror = true;
		((Modchu_ModelRenderer) leftLegPlus.setTextureOffset(3, 24)).addPlate(-1.5F, -1.5F - 0.5F, -5.01F, 3, 3, 4, f);
		leftLegPlus.rotateAngleX = 1.570796313F;
		leftLeg.addChild(leftLegPlus);

		leftLeg2 = new Modchu_ModelRenderer(this, 0, 24);
		leftLeg2.mirror = true;
		leftLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 3, f);
		leftLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);
		leftLeg.addChild(leftLeg2);

		leftLegPlus2 = new Modchu_ModelRenderer(this);
		leftLegPlus2.mirror = true;
		//leftLegPlus2.setTextureOffset(3, 24).addPlate(-1.5F, -1.5F, 0.01F, 3, 3, 4, f);
		((Modchu_ModelRenderer) leftLegPlus2.setTextureOffset(6, 19)).addPlate(-1.5F, -1.5F - 0.5F, -5.01F, 3, 3, 4, f);
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
																		leftLeg.showModel = leftLeg2.showModel =
																				rightHandPlus.showModel = leftHandPlus.showModel = false;
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
    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
    	super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);

    	bipedRightLeg.rotateAngleX = (MathHelper.cos(f * 0.6662F) * 1.4F * f1) / 1.5F;
    	bipedLeftLeg.rotateAngleX = (MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1) / 1.5F;
    	setCapsValue(caps_visible, KeloeyeL1, true);
    	setCapsValue(caps_visible, KeloeyeR1, true);
    	setCapsValue(caps_visible, KeloeyeL2, false);
    	setCapsValue(caps_visible, KeloeyeR2, false);

    	if(getCapsValueBoolean(caps_getIsRiding))
    	{
    		bipedRightLeg.rotateAngleX = -1.256637F;
    		bipedLeftLeg.rotateAngleX = -1.256637F;
    		bipedRightLeg.rotateAngleY = 0.3141593F;
    		bipedLeftLeg.rotateAngleY = -0.3141593F;
    	}
    	if(getCapsValueFloat(caps_onGround) > -9990F && !getCapsValueBoolean(caps_aimedBow))
    	{
    		bipedRightArm.rotationPointZ = MathHelper.sin(bipedBody.rotateAngleY) * 4F;
    		bipedRightArm.rotationPointX = -MathHelper.cos(bipedBody.rotateAngleY) * 3.5F + 1.0F;
    		bipedLeftArm.rotationPointZ = -MathHelper.sin(bipedBody.rotateAngleY) * 4F;
    		bipedLeftArm.rotationPointX = MathHelper.cos(bipedBody.rotateAngleY) * 3.5F - 1.0F;
    	}
    	Skirt.rotationPointY = 10.0F;
    	Skirt.rotationPointZ = 0.0F;
    	if(getCapsValueBoolean(caps_getIsSneak))
    	{
    		bipedHead.rotationPointY = 5.5F;
    		bipedBody.rotationPointY = 5.0F;
    		bipedRightArm.rotationPointY = 0F;
    		bipedLeftArm.rotationPointY = 0F;
    		bipedRightLeg.rotationPointY = 9F;
    		bipedLeftLeg.rotationPointY = 9F;
    		bipedRightLeg.rotateAngleX -= 0.5F;
    		bipedLeftLeg.rotateAngleX -= 0.5F;
    		Skirt.rotationPointZ = -0.3F;
    		Skirt.rotateAngleX += 0.3F;
    	} else
    	{
    		bipedHead.rotationPointY = 4.5F;
    		bipedBody.rotationPointY = 5.0F;
    		bipedRightArm.rotationPointY = 0F;
    		bipedLeftArm.rotationPointY = 0F;
    		bipedRightLeg.rotationPointY = 9F;
    		bipedLeftLeg.rotationPointY = 9F;
    	}

    	if(getCapsValueBoolean(caps_getIsWait) && !getCapsValueBoolean(caps_aimedBow))
    	{
    		setCapsValue(caps_visible, KeloeyeL1, false);
    		setCapsValue(caps_visible, KeloeyeR1, false);
    		setCapsValue(caps_visible, KeloeyeL2, true);
    		setCapsValue(caps_visible, KeloeyeR2, true);
    	}
    	if (getCapsValueBoolean(caps_aimedBow)) {
    		setCapsValue(caps_visible, eyeL, true);
    		setCapsValue(caps_visible, eyeR, false);
    	} else {
    		if (0.0D > (double) (mh_sin(f2 * 0.1F) * 0.3F)
    			+ Math.random() * 0.10000000149011612D
    			+ 0.18000000715255737D) {
    			setCapsValue(caps_visible, eyeL, true);
    			setCapsValue(caps_visible, eyeR, true);
    		} else {
    			setCapsValue(caps_visible, eyeL, false);
    			setCapsValue(caps_visible, eyeR, false);
    		}
    	}
        headwear.rotateAngleX = -0.087F;
    }

    @Override
    public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    }

    @Override
    public void defaultPartsSettingBefore() {
    	super.defaultPartsSettingBefore();
    	String[] s = {
    			"bipedHeadwear", "ChignonB", "Tail", "d"
    	};
    	showPartsHideListadd(s);
    	String[] s1 = {
    			"BreastPocket", "LsidePocket", "RsidePocket", "BackpackPocket"
    	};
    	String[] s2 = {
    			"B_Pocket", "L_Pocket", "R_Pocket", "B_packPocket"
    	};
    	addShowPartsReneme(s1, s2);
    }

    @Override
    public void showModelSettingReflects() {
    	super.showModelSettingReflects();
    	setCapsValue(caps_visible, bipedHeadwear, false);
    	setCapsValue(caps_visible, ChignonB, false);
    	setCapsValue(caps_visible, Tail, false);
    }

    @Override
    public void actionInit1() {
    	super.actionInit1();
    	setCapsValue(caps_visible, rightHandPlus, true);
    	setCapsValue(caps_visible, leftHandPlus, true);
    	((Modchu_ModelRenderer) bipedRightArm).removeChild(SleeveR);
    	((Modchu_ModelRenderer) bipedLeftArm).removeChild(SleeveL);
    	((Modchu_ModelRenderer) bipedRightLeg).removeChild(ShoesR);
    	((Modchu_ModelRenderer) bipedLeftLeg).removeChild(ShoesL);
    	rightArm2.addChild(SleeveR);
    	leftArm2.addChild(SleeveL);
    	rightLeg2.addChild(ShoesR);
    	leftLeg2.addChild(ShoesL);
    }

    @Override
    public void actionRelease1() {
    	super.actionRelease1();
    	rightHandPlus.showModel = leftHandPlus.showModel = false;
    	bipedRightArm.addChild(SleeveR);
    	bipedLeftArm.addChild(SleeveL);
    	bipedRightLeg.addChild(ShoesR);
    	bipedLeftLeg.addChild(ShoesL);
    	((Modchu_ModelRenderer) rightArm2).removeChild(SleeveR);
    	((Modchu_ModelRenderer) leftArm2).removeChild(SleeveL);
    	((Modchu_ModelRenderer) rightLeg2).removeChild(ShoesR);
    	((Modchu_ModelRenderer) leftLeg2).removeChild(ShoesL);
    	SleeveR.setRotationPoint(1.5F, 2.0F, 0.5F);
    	SleeveL.setRotationPoint(-1.5F, 2.0F, 0.5F);
    	ShoesR.setRotationPoint(0.5F, 0.0F, 0.5F);
    	ShoesL.setRotationPoint(0.5F, 0.0F, 0.5F);
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
		rightArm.rotationPointY = 1.0F;
		rightArm2.rotationPointX = 0.5F;
		rightArm2.rotationPointY = 3.5F;
		rightLeg.rotationPointX -= 0.5F;
		rightLeg2.rotationPointY -= 5.0F;
		rightHand.rotationPointX = rightArm2.rotationPointX;
		rightHand.rotationPointY = rightArm2.rotationPointY;
		rightHand.rotationPointZ = rightArm2.rotationPointZ + 0.5F;

		leftArm.rotationPointY = 1.0F;
		leftArm2.rotationPointX = 0.0F;
		leftArm2.rotationPointY = 4.5F;
		leftLeg.rotationPointX += 0.5F;
		leftLeg2.rotationPointY -= 5.0F;
		leftHand.rotationPointX = leftArm2.rotationPointX + 0.5F;
		leftHand.rotationPointY = leftArm2.rotationPointY;
		leftHand.rotationPointZ = leftArm2.rotationPointZ + 0.5F;

		SleeveR.setRotationPoint(2.0F, -2.0F, 1.0F);
		SleeveL.setRotationPoint(-1.0F, -2.0F, 1.0F);
		ShoesR.setRotationPoint(0.5F, -5.0F, 0.5F);
		ShoesL.setRotationPoint(0.5F, -5.0F, 0.5F);
    }

    @Override
    public float getHeight()
    {
    	return 1.6F;
    }

    @Override
    public float getWidth()
    {
    	return 0.7F;
    }

    @Override
    public float getyOffset() {
    	return 1.2F;
    }

    @Override
    public double getMountedYOffset() {
    	double d = 0.85D;
    	return d;
    }

    @Override
    public double getSittingyOffset() {
    	return -0.5D;
    }

    @Override
    public double getSleepingyOffset() {
    	return -0.95D;
    }

    @Override
    public float ridingViewCorrection() {
    	return -0.75F;
    }
}
