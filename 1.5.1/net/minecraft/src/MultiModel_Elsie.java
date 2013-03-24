package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class MultiModel_Elsie extends MultiModel {

    public Modchu_ModelRenderer RightSkirt;
    public Modchu_ModelRenderer LeftSkirt;
    public Modchu_ModelRenderer bipedHeadwearB;
	public Modchu_ModelRenderer SkirtTopL;
	public Modchu_ModelRenderer SkirtFrontL;
	public Modchu_ModelRenderer SkirtLeftL;
	public Modchu_ModelRenderer SkirtBackL;
	public Modchu_ModelRenderer SkirtRightL;

    public MultiModel_Elsie()
    {
        this(0.0F);
    }

    public MultiModel_Elsie(float f)
    {
        this(f, 0.0F);
    }

    public MultiModel_Elsie(float f, float f1)
    {
		this(f, f1 , 64, 32);
	}

	public MultiModel_Elsie(float f, float f1, int i, int j) {
		super(f, f1, i, j);
	}

    @Override
    public void initModel(float f, float f1) {
    	bipedHead = new Modchu_ModelRenderer(this, 0, 0);
    	bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, f);
    	bipedHead.setRotationPoint(0.0F, 4.0F, 0.0F);
    	bipedHeadwearB = new Modchu_ModelRenderer(this, 42, 0);
    	bipedHeadwearB.addBox(-4F, -1.5F, 1.0F, 8, 6, 3, f);
    	bipedHeadwearB.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(bipedHeadwearB);
    	bipedBody = new Modchu_ModelRenderer(this, 36, 20);
    	bipedBody.addBox(-3.0F, 0.0F, -2.0F, 6, 8, 4, f);
    	bipedBody.setRotationPoint(0.0F, 4.0F, 0.0F);
    	bipedRightArm = new Modchu_ModelRenderer(this, 56, 20);
    	bipedRightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 10, 2, f);
    	bipedRightArm.setRotationPoint(-3.0F, 0.0F, 0.0F);
    	bipedBody.addChild(bipedRightArm);
    	bipedLeftArm = new Modchu_ModelRenderer(this, 56, 20);
    	bipedLeftArm.mirror = true;
    	bipedLeftArm.addBox(-1.0F, 0.0F, -1F, 2, 10, 2, f);
    	bipedLeftArm.setRotationPoint(3.0F, 0.0F, 0.0F);
    	bipedBody.addChild(bipedLeftArm);
    	bipedRightLeg = new Modchu_ModelRenderer(this, 0, 16);
    	bipedRightLeg.addBox(-1.5F, 0.0F, -2F, 3, 12, 4, f);
    	bipedRightLeg.setRotationPoint(-1.5F, 8F, 0.0F);
    	bipedBody.addChild(bipedRightLeg);
    	bipedLeftLeg = new Modchu_ModelRenderer(this, 0, 16);
    	bipedLeftLeg.mirror = true;
    	bipedLeftLeg.addBox(-1.5F, 0.0F, -2F, 3, 12, 4, f);
    	bipedLeftLeg.setRotationPoint(1.5F, 8F, 0.0F);
    	bipedBody.addChild(bipedLeftLeg);
    	Skirt = new Modchu_ModelRenderer(this, 36, 10);
    	Skirt.addBox(-4F, 0.0F, -3F, 8, 4, 6, f);
    	Skirt.setRotationPoint(0.0F, 6.0F, 0.0F);
    	bipedBody.addChild(Skirt);
    	RightSkirt = new Modchu_ModelRenderer(this, 14, 16);
    	RightSkirt.addBox(-2.5F, 0.0F, -3F, 5, 10, 6, f);
    	RightSkirt.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedRightLeg.addChild(RightSkirt);
    	LeftSkirt = new Modchu_ModelRenderer(this, 14, 16);
    	LeftSkirt.mirror = true;
    	LeftSkirt.addBox(-2.5F, 0.0F, -3F, 5, 10, 6, f);
    	LeftSkirt.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedLeftLeg.addChild(LeftSkirt);
    	ChignonR = new Modchu_ModelRenderer(this, 24, 2);
    	ChignonR.addBox(-5F, -7F, 0.2F, 1, 3, 3, f);
    	ChignonR.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(ChignonR);
    	ChignonL = new Modchu_ModelRenderer(this, 24, 2);
    	ChignonL.mirror = true;
    	ChignonL.addBox(4F, -7F, 0.2F, 1, 3, 3, f);
    	ChignonL.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(ChignonL);
    	SideTailR = new Modchu_ModelRenderer(this, 32, 0);
    	SideTailR.addBox(-6.5F, -6.8F, 0.9F, 2, 13, 3, f);
    	SideTailR.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(SideTailR);
    	SideTailL = new Modchu_ModelRenderer(this, 32, 0);
    	SideTailL.mirror = true;
    	SideTailL.addBox(4.5F, -6.8F, 0.9F, 2, 13, 3, f);
    	SideTailL.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(SideTailL);
    	mainFrame = new Modchu_ModelRenderer(this, 0, 0);
    	mainFrame.setRotationPoint(0F, 0F + f1, 0F);
    	mainFrame.addChild(bipedHead);
    	mainFrame.addChild(bipedBody);
    	((Modchu_ModelRenderer) bipedHead).removeChild(bipedHeadwear);
    	((Modchu_ModelRenderer) bipedHead).removeChild(ChignonB);
    	((Modchu_ModelRenderer) bipedHead).removeChild(Tail);
    	actionPartsInit(f, f1);
    }

    @Override
    public void skirtFloatsInit(float f, float f1) {
    }

    @Override
    public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    }

    @Override
    public void actionPartsInit(float f, float f1) {
    	rightArm = new Modchu_ModelRenderer(this, 56, 20);
    	rightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, f);
    	rightArm.setRotationPoint(-3.0F, 9.5F, 0.0F);
    	bipedBody.addChild(rightArm);

    	rightArmPlus = new Modchu_ModelRenderer(this);

    	rightArm2 = new Modchu_ModelRenderer(this, 56, 25);
    	rightArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, f);
    	rightArm2.setRotationPoint(0.0F, 2.0F, 0.0F);
    	rightArm.addChild(rightArm2);

    	rightArmPlus2 = new Modchu_ModelRenderer(this);

    	rightHand = new Modchu_ModelRenderer(this, 56, 28);
    	rightHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
    	rightHand.setRotationPoint(0.0F, 3.0F, 0.0F);
    	rightArm2.addChild(rightHand);

    	leftArm = new Modchu_ModelRenderer(this, 56, 20);
    	((Modchu_ModelRenderer) leftArm).setMirror(true);
    	leftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, f);
    	leftArm.setRotationPoint(3.0F, 9.5F, 0.0F);
    	bipedBody.addChild(leftArm);

    	leftArmPlus = new Modchu_ModelRenderer(this);

    	leftArm2 = new Modchu_ModelRenderer(this, 56, 25);
    	((Modchu_ModelRenderer) leftArm2).setMirror(true);
    	leftArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, f);
    	leftArm2.setRotationPoint(0.0F, 2.0F, 0.0F);
    	leftArm.addChild(leftArm2);

    	leftArmPlus2 = new Modchu_ModelRenderer(this);

    	leftHand = new Modchu_ModelRenderer(this, 56, 28);
    	((Modchu_ModelRenderer) leftHand).setMirror(true);
    	leftHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
    	leftHand.setRotationPoint(0.0F, 3.0F, 0.0F);
    	leftArm2.addChild(leftHand);

    	rightLeg = new Modchu_ModelRenderer(this, 0, 16);
    	rightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, f);
    	rightLeg.setRotationPoint(0.0F, 8.0F, 0.0F);
    	bipedBody.addChild(rightLeg);

    	rightLegPlus = new Modchu_ModelRenderer(this);

    	rightLeg2 = new Modchu_ModelRenderer(this, 0, 22);
    	rightLeg2.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, f);
    	rightLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);
    	rightLeg.addChild(rightLeg2);

    	rightLegPlus2 = new Modchu_ModelRenderer(this);

    	leftLeg = new Modchu_ModelRenderer(this, 0, 16);
    	((Modchu_ModelRenderer) leftLeg).setMirror(true);
    	leftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 6, 4, f);
    	leftLeg.setRotationPoint(0.0F, 8.0F, 0.0F);
    	bipedBody.addChild(leftLeg);

    	leftLegPlus = new Modchu_ModelRenderer(this);

    	leftLeg2 = new Modchu_ModelRenderer(this, 0, 22);
    	((Modchu_ModelRenderer) leftLeg2).setMirror(true);
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
    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);
    	Arms[0].setRotationPoint(0.5F, 9.0F, 0F);
    	Arms[1].setRotationPoint(-0.5F, 9.0F, 0F);
    	RightSkirt.rotationPointZ = 0.0F;
    	LeftSkirt.rotationPointZ = 0.0F;
    	RightSkirt.rotateAngleX = -0.01F;
    	LeftSkirt.rotateAngleX = 0.01F;
    	RightSkirt.rotateAngleY = 0.0F;
    	LeftSkirt.rotateAngleY = 0.0F;
    	RightSkirt.rotateAngleZ = 0.0F;
    	LeftSkirt.rotateAngleZ = 0.0F;

    	bipedHead.rotationPointY = 4.0F;
    	bipedBody.rotationPointY = 4.0F;
    	bipedRightLeg.rotationPointY = 8.0F;
    	bipedLeftLeg.rotationPointY = 8.0F;
    	bipedRightArm.rotationPointY += 3.0F;
    	bipedLeftArm.rotationPointY += 3.0F;
    	bipedBody.rotationPointZ = 0.0F;
    	if(getCapsValueBoolean(caps_getIsSneak)) {
    		bipedHead.rotationPointY += 1.0F;
    		bipedBody.rotationPointY += 1.0F;
    		bipedBody.rotationPointZ -= 0.1F;
    		bipedRightLeg.rotationPointZ += 0.3F;
    		bipedLeftLeg.rotationPointZ += 0.3F;
    		bipedRightLeg.rotationPointY -= 1.0F;
    		bipedLeftLeg.rotationPointY -= 1.0F;
        	Skirt.rotationPointZ = 2.0F;
    	}
    	if(getCapsValueBoolean(caps_getIsWait) && !getCapsValueBoolean(caps_aimedBow)) {
    		bipedRightArm.rotateAngleX = MathHelper.sin(f2 * 0.067F) * 0.05F - 0.7F;
    		bipedRightArm.rotateAngleY = 0.0F;
    		bipedRightArm.rotateAngleZ = -0.4F;
    		bipedLeftArm.rotateAngleX = MathHelper.sin(f2 * 0.067F) * 0.05F - 0.7F;
    		bipedLeftArm.rotateAngleY = 0.0F;
    		bipedLeftArm.rotateAngleZ = 0.4F;
    	}
    	//スカートと髪ゆらゆら
    	RightSkirt.rotateAngleZ += mh_cos(f2 * 0.06F) * 0.03F + 0.03F;
    	LeftSkirt.rotateAngleZ -= mh_cos(f2 * 0.06F) * 0.03F + 0.03F;
    	RightSkirt.rotateAngleX += mh_sin(f2 * 0.04F) * 0.03F;
    	LeftSkirt.rotateAngleX -= mh_sin(f2 * 0.04F) * 0.03F;

    	SideTailR.rotateAngleZ =   mh_sin(f2 * 0.08F) * 0.03F + 0.03F;
    	SideTailL.rotateAngleZ = -(mh_sin(f2 * 0.08F) * 0.03F + 0.03F);
    	SideTailR.rotateAngleX =   mh_cos(f2 * 0.05F) * 0.03F;
    	SideTailL.rotateAngleX =   mh_cos(f2 * 0.05F) * 0.03F;
    	bipedHeadwear.rotateAngleX = -(mh_sin(f2 * 0.09F) * 0.03F + 0.03F);
    }

    @Override
    public void defaultPartsSettingBefore() {
    	super.defaultPartsSettingBefore();
    	String[] s = {
    			"bipedHeadwear", "ChignonB", "Tail", "d"
    	};
    	showPartsHideListadd(s);
    }

    @Override
    public void showModelSettingReflects() {
    	super.showModelSettingReflects();
    	if (getCapsValueBoolean(caps_skirtFloats)) {
    		setCapsValue(caps_visible, Skirt, getGuiParts().get("Skirt"));
    	}
    }

    @Override
    public void actionInit1() {
    	super.actionInit1();
    	((Modchu_ModelRenderer) bipedRightLeg).removeChild(RightSkirt);
    	((Modchu_ModelRenderer) bipedLeftLeg).removeChild(LeftSkirt);
    	rightLeg.addChild(RightSkirt);
    	leftLeg.addChild(LeftSkirt);
    }

    @Override
    public void actionRelease1() {
    	super.actionRelease1();
    	((Modchu_ModelRenderer) rightLeg).removeChild(RightSkirt);
    	((Modchu_ModelRenderer) leftLeg).removeChild(LeftSkirt);
    	bipedRightLeg.addChild(RightSkirt);
    	bipedLeftLeg.addChild(LeftSkirt);
    }

	@Override
    public void action1(Entity entity) {
    	super.action1(entity);
    	float f1 = bipedBody.rotateAngleZ;
    	if (f1 > 0.0F) {
    		bipedHead.rotationPointY = bipedBody.rotationPointY - 0.5F + (f1 * 1.30889264F);
    	} else {
    		bipedHead.rotationPointY = bipedBody.rotationPointY - 0.5F - (f1 * 1.30889264F);
    	}
    	rightArm2.rotationPointY += 1.0F;
    	leftArm2.rotationPointY += 1.0F;
    	bipedHead.rotationPointX = 0.0F;
    	rightLeg.rotationPointX -= 0.5F;
    	leftLeg.rotationPointX += 0.5F;
    	rightLeg2.rotationPointY -= 2.5F;
    	leftLeg2.rotationPointY -= 2.5F;
    }

    @Override
    public float getHeight()
    {
    	return 1.58F;
    }

    @Override
    public float getWidth()
    {
    	return 0.55F;
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
