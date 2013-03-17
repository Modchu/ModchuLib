package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class MultiModel_Pawapro extends MultiModel {

    public Modchu_ModelRenderer tuba1;
    public Modchu_ModelRenderer tuba2;
    public Modchu_ModelRenderer HandR;
    public Modchu_ModelRenderer HandL;
    public Modchu_ModelRenderer RLeg2;
    public Modchu_ModelRenderer LLeg2;
    public Modchu_ModelRenderer eyeR;
    public Modchu_ModelRenderer eyeL;
    public Modchu_ModelRenderer eyeRniko;
    public Modchu_ModelRenderer eyeLniko;
    public Modchu_ModelRenderer eyeRFire;
    public Modchu_ModelRenderer eyeLFire;
    public Modchu_ModelRenderer Logo1;
    public Modchu_ModelRenderer Logo2;

    public MultiModel_Pawapro()
    {
        this(0.0F);
    }

    public MultiModel_Pawapro(float f)
    {
        this(f, 0.0F);
    }

    public MultiModel_Pawapro(float f, float f1)
    {
    	this(f, f1 , 64, 32);
    }

    public MultiModel_Pawapro(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
    }

    @Override
    public void initModel(float f, float f1) {
    	f1 += 8F;
    	bipedHead = new Modchu_ModelRenderer(this, 0, 0);
    	bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, f);
    	bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
    	tuba1 = new Modchu_ModelRenderer(this, 0, 29);
    	tuba1.addBox(-4F, -5F, -6F, 8, 1, 2, f);
    	tuba1.setRotationPoint(0F, 0F, 0F);
    	bipedHead.addChild(tuba1);
    	tuba2 = new Modchu_ModelRenderer(this, 0, 29);
    	tuba2.addBox(-3F, -4.9F, -7F, 6, 1, 2, f - 0.1F);
    	tuba2.setRotationPoint(0F, 0F, 0F);
    	bipedHead.addChild(tuba2);
    	ChignonL = new Modchu_ModelRenderer(this, 0, 2);
    	ChignonL.addBox(3.5F, -4.5F, -1.8F, 1, 3, 3, f);
    	ChignonL.setRotationPoint(0F, 0F, 0F);
    	bipedHead.addChild(ChignonL);
    	Logo1 = new Modchu_ModelRenderer(this, 24, 0);
    	Logo1.addPlate(-4F, -10.5F, -7.2F, 8, 8, 0, f - 3F);
    	Logo1.setRotationPoint(0F, 0F, 0F);
    	bipedHead.addChild(Logo1);

    	bipedBody = new Modchu_ModelRenderer(this, 0, 16);
    	bipedBody.addBox(-3F, 0.5F, -2F, 6, 8, 4, f);
    	bipedBody.setRotationPoint(0.0F, 8F, 0.0F);
    	Skirt = new Modchu_ModelRenderer(this, 28, 18);
    	Skirt.addBox(-3F, 7.5F, -2F, 6, 2, 4, f-0.5F);
    	Skirt.setRotationPoint(0F, 0F, 0F);
    	bipedBody.addChild(Skirt);
    	Logo2 = new Modchu_ModelRenderer(this, 40, 0);
    	Logo2.mirror = true;
    	Logo2.addPlate(-4F, -1.5F, 0.5F, 8, 8, 0, f - 1.8F);
    	Logo2.setRotationPoint(0F, 0F, 0F);
    	bipedBody.addChild(Logo2);

    	bipedRightArm = new Modchu_ModelRenderer(this, 20, 22);
    	bipedRightArm.addBox(-2F, -1F, -1F, 2, 8, 2, f);
    	bipedRightArm.setRotationPoint(-3F, 9.5F, 0.0F);
    	bipedBody.addChild(bipedRightArm);
    	HandR = new Modchu_ModelRenderer(this, 20, 16);
    	HandR.addBox(-2.5F, 4.5F, -1.5F, 3, 3, 3, f);
    	HandR.setRotationPoint(0.0F, 0.0F, 0F);
    	bipedRightArm.addChild(HandR);

    	bipedLeftArm = new Modchu_ModelRenderer(this, 20, 22);
    	bipedLeftArm.mirror = true;
    	bipedLeftArm.addBox(0.0F, -1F, -1F, 2, 8, 2, f);
    	bipedLeftArm.setRotationPoint(3F, 9.5F, 0.0F);
    	bipedBody.addChild(bipedLeftArm);
    	HandL = new Modchu_ModelRenderer(this, 20, 16);
    	HandL.mirror = true;
    	HandL.addBox(-0.5F, 4.5F, -1.5F, 3, 3, 3, f);
    	HandL.setRotationPoint(0.0F, 0.0F, 0F);
    	bipedLeftArm.addChild(HandL);

    	bipedRightLeg = new Modchu_ModelRenderer(this, 28, 24);
    	bipedRightLeg.addBox(-2F, 5F, -6F, 4, 2, 6, f);
    	bipedRightLeg.setRotationPoint(-2F, 7F, 0.0F);
    	bipedBody.addChild(bipedRightLeg);
    	RLeg2 = new Modchu_ModelRenderer(this, 28, 24);
    	RLeg2.addBox(-2F, 4F, -6F, 4, 2, 6, f - 0.5F);
    	RLeg2.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedRightLeg.addChild(RLeg2);

    	bipedLeftLeg = new Modchu_ModelRenderer(this, 28, 24);
    	bipedLeftLeg.mirror = true;
    	bipedLeftLeg.addBox(-2F, 5F, -6F, 4, 2, 6, f);
    	bipedLeftLeg.setRotationPoint(1.0F, 7F, 0.0F);
    	bipedBody.addChild(bipedLeftLeg);
    	LLeg2 = new Modchu_ModelRenderer(this, 28, 24);
    	LLeg2.mirror = true;
    	LLeg2.addBox(-2F, 4F, -6F, 4, 2, 6, f - 0.5F);
    	LLeg2.setRotationPoint(0.0F, 0.0F, 0.0F);
    	bipedLeftLeg.addChild(LLeg2);

    	eyeR = new Modchu_ModelRenderer(this, 32, 0);
    	eyeR.addPlate(-3.999999F, -4.9F, -4.001F, 4, 4, 0, f);
    	eyeR.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(eyeR);
    	eyeL = new Modchu_ModelRenderer(this, 36, 0);
    	eyeL.addPlate(-0.000001F, -4.9F, -4.001F, 4, 4, 0, f);
    	eyeL.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(eyeL);
    	eyeRniko = new Modchu_ModelRenderer(this, 32, 12);
    	eyeRniko.addPlate(-3.999999F, -4.9F, -4.001F, 4, 4, 0, f);
    	eyeRniko.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(eyeRniko);
    	eyeLniko = new Modchu_ModelRenderer(this, 36, 12);
    	eyeLniko.addPlate(-0.000001F, -4.9F, -4.001F, 4, 4, 0, f);
    	eyeLniko.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(eyeLniko);
    	eyeRFire = new Modchu_ModelRenderer(this, 32, 4);
    	eyeRFire.addPlate(-3.999999F, -4.9F, -4.001F, 4, 4, 0, f);
    	eyeRFire.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(eyeRFire);
    	eyeLFire = new Modchu_ModelRenderer(this, 36, 4);
    	eyeLFire.addPlate(-0.000001F, -4.9F, -4.001F, 4, 4, 0, f);
    	eyeLFire.setRotationPointLM(0.0F, 0.0F, 0.0F);
    	bipedHead.addChild(eyeLFire);
    	mainFrame = new Modchu_ModelRenderer(this, 0, 0);
    	mainFrame.setRotationPoint(0F, 0F + f1, 0F);
    	mainFrame.addChild(bipedHead);
    	mainFrame.addChild(bipedBody);
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
    	rightArm = new Modchu_ModelRenderer(this, 20, 22);
    	rightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f);
    	rightArm.setRotationPoint(-3.0F, 9.5F, 0.0F);
    	bipedBody.addChild(rightArm);

    	rightArmPlus = new Modchu_ModelRenderer(this);
    	//rightArmPlus.setTextureOffset(52, 0).addPlate(-1.0F, -1.0F, -3.01F, 2, 2, 4, f);
    	//rightArmPlus.rotateAngleX = 1.570796313F;
    	//rightArm.addChild(rightArmPlus);

    	rightArm2 = new Modchu_ModelRenderer(this, 20, 26);
    	rightArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, f);
    	rightArm2.setRotationPoint(0.0F, 2.0F, 0.0F);
    	rightArm.addChild(rightArm2);

    	rightArmPlus2 = new Modchu_ModelRenderer(this);

    	rightHand = new Modchu_ModelRenderer(this);
    	rightArm2.addChild(rightHand);

    	leftArm = new Modchu_ModelRenderer(this, 20, 22);
    	leftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, f);
    	leftArm.setRotationPoint(3.0F, 9.5F, 0.0F);
    	bipedBody.addChild(leftArm);

    	leftArmPlus = new Modchu_ModelRenderer(this);
    	//leftArmPlus.setTextureOffset(60, 0).addPlate(-1.0F, -1.0F, -3.01F, 2, 2, 4, f);
    	//leftArmPlus.rotateAngleX = 1.570796313F;
    	//leftArm.addChild(leftArmPlus);

    	leftArm2 = new Modchu_ModelRenderer(this, 20, 26);
    	leftArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, f);
    	leftArm2.setRotationPoint(0.0F, 2.0F, 0.0F);
    	leftArm.addChild(leftArm2);

    	leftArmPlus2 = new Modchu_ModelRenderer(this);

    	leftHand = new Modchu_ModelRenderer(this);
    	leftArm2.addChild(leftHand);

    	rightLeg = new Modchu_ModelRenderer(this);
    	bipedBody.addChild(rightLeg);

    	rightLegPlus = new Modchu_ModelRenderer(this);

    	rightLeg2 = new Modchu_ModelRenderer(this);
    	rightLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);
    	rightLeg.addChild(rightLeg2);

    	rightLegPlus2 = new Modchu_ModelRenderer(this);

    	leftLeg = new Modchu_ModelRenderer(this);
    	bipedBody.addChild(leftLeg);

    	leftLegPlus = new Modchu_ModelRenderer(this);

    	leftLeg2 = new Modchu_ModelRenderer(this, 32, 23);
    	leftLeg2.setRotationPoint(0.0F, 8.0F, 0.0F);
    	leftLeg.addChild(leftLeg2);

    	leftLegPlus2 = new Modchu_ModelRenderer(this);

    	rightHand.showModel = leftHand.showModel =
    		rightArm.showModel = leftArm.showModel =
    			rightArmPlus.showModel = rightArmPlus2.showModel =
    				leftArmPlus.showModel = leftArmPlus2.showModel =
    					rightLegPlus.showModel = rightLegPlus2.showModel =
    						leftLegPlus.showModel = leftLegPlus2.showModel =
    							rightArm2.showModel = leftArm2.showModel = false;
    	rightLeg.isHidden = rightLeg2.isHidden =
    			leftLeg.isHidden = leftLeg2.isHidden = true;
    	setCapsValue(caps_aimedBowBan, false);
    	setCapsValue(caps_sneakBan, false);
    	setCapsValue(caps_waitBan, false);
    	setCapsValue(caps_sittingBan, false);
    	setCapsValue(caps_sleepingBan, false);
    }

    @Override
    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);
    	bipedHead.rotationPointY += 1.0F;
    	bipedBody.rotationPointY -= 3.0F;
    	bipedRightArm.rotationPointY += 5.0F;
    	bipedLeftArm.rotationPointY += 5.0F;
    	Skirt.rotationPointY -= 5.5F;
    	bipedRightLeg.rotationPointY += 3.0F;
    	bipedLeftLeg.rotationPointY += 3.0F;
    	setCapsValue(caps_visible, eyeLniko, false);
    	setCapsValue(caps_visible, eyeRniko, false);
    	setCapsValue(caps_visible, eyeLFire, false);
    	setCapsValue(caps_visible, eyeRFire, false);

    	if (getCapsValueBoolean(caps_getIsWait) && !getCapsValueBoolean(caps_aimedBow)) {
    		setCapsValue(caps_visible, eyeLniko, true);
    		setCapsValue(caps_visible, eyeRniko, true);
    	}
    	if (getCapsValueBoolean(caps_aimedBow)){
    		setCapsValue(caps_visible, eyeLFire, true);
    		setCapsValue(caps_visible, eyeRFire, true);
    	}
    	if (getCapsValueBoolean(caps_getIsSneak)){
    		Skirt.rotationPointY = 0.0F;
    		Skirt.rotationPointZ = 0.0F;
    		Skirt.rotateAngleX = 0.0F;
    	}

    	double Eye =(double)(mh_sin(f2 * 0.1F) * 0.3F) + Math.random() * 0.10000000149011612D + 0.18000000715255737D;

    	if(0.0D > Eye) {
    		setCapsValue(caps_visible, eyeL, false);
    		setCapsValue(caps_visible, eyeR, false);
    	} else {
    		setCapsValue(caps_visible, eyeL, true);
    		setCapsValue(caps_visible, eyeR, true);
    	}
    	bipedRightLeg.rotateAngleY = 0.5235988F;
    	bipedLeftLeg.rotateAngleY = -0.5235988F;
    }

    @Override
    public void actionInit1() {
    	setCapsValue(caps_shortcutKeysAction, true);
    	boolean b = false;
    	setCapsValue(caps_visible, bipedLeftArm, b);
    	setCapsValue(caps_visible, bipedRightArm, b);
    	b = true;
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
    	rightLeg.isHidden = !b;
    	rightLeg2.isHidden = !b;
    	setCapsValue(caps_visible, rightLegPlus, b);
    	setCapsValue(caps_visible, rightLegPlus2, b);
    	leftLeg.isHidden = !b;
    	leftLeg2.isHidden = !b;
    	setCapsValue(caps_visible, leftLegPlus, b);
    	setCapsValue(caps_visible, leftLegPlus2, b);
    	((Modchu_ModelRenderer) bipedRightArm).removeChild(Arms[0]);
    	((Modchu_ModelRenderer) bipedRightArm).removeChild(Arms[2]);
    	((Modchu_ModelRenderer) bipedLeftArm).removeChild(Arms[1]);
    	((Modchu_ModelRenderer) bipedLeftArm).removeChild(Arms[3]);
    	((Modchu_ModelRenderer) bipedBody).removeChild(bipedRightLeg);
    	((Modchu_ModelRenderer) bipedBody).removeChild(bipedLeftLeg);
    	((Modchu_ModelRenderer) bipedRightArm).removeChild(HandR);
    	((Modchu_ModelRenderer) bipedLeftArm).removeChild(HandL);
    	rightHand.addChild(Arms[0]);
    	rightHand.addChild(Arms[2]);
    	leftHand.addChild(Arms[1]);
    	leftHand.addChild(Arms[3]);
    	rightHand.addChild(HandR);
    	leftHand.addChild(HandL);
    	rightLeg2.addChild(bipedRightLeg);
    	leftLeg2.addChild(bipedLeftLeg);
    	Arms[0].setRotationPoint(0.0F, 3.0F, 0.0F);
    	Arms[1].setRotationPoint(0.0F, 3.0F, 0.0F);
    	setCapsValue(caps_sneakBan, true);
    	setCapsValue(caps_waitBan, true);
    	setCapsValue(caps_sittingBan, true);
    }

    @Override
    public void actionRelease1() {
    	setCapsValue(caps_shortcutKeysAction, false);
    	setCapsValue(caps_sneakBan, false);
    	setCapsValue(caps_waitBan, false);
    	setCapsValue(caps_sittingBan, false);

    	boolean b = true;
    	setCapsValue(caps_visible, bipedLeftArm, b);
    	setCapsValue(caps_visible, bipedRightArm, b);
    	b = false;
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
    	rightLeg.isHidden = !b;
    	rightLeg2.isHidden = !b;
    	setCapsValue(caps_visible, rightLegPlus, b);
    	setCapsValue(caps_visible, rightLegPlus2, b);
    	leftLeg.isHidden = !b;
    	leftLeg2.isHidden = !b;
    	setCapsValue(caps_visible, leftLegPlus, b);
    	setCapsValue(caps_visible, leftLegPlus2, b);

    	bipedRightArm.addChild(Arms[0]);
    	bipedRightArm.addChild(Arms[2]);
    	bipedLeftArm.addChild(Arms[1]);
    	bipedLeftArm.addChild(Arms[3]);
    	((Modchu_ModelRenderer) rightHand).removeChild(Arms[0]);
    	((Modchu_ModelRenderer) rightHand).removeChild(Arms[2]);
    	((Modchu_ModelRenderer) leftHand).removeChild(Arms[1]);
    	((Modchu_ModelRenderer) leftHand).removeChild(Arms[3]);
    	Arms[0].setRotationPoint(0.5F, 6.5F, 0F);
    	Arms[1].setRotationPoint(-0.5F, 6.5F, 0F);

    	((Modchu_ModelRenderer) rightLeg2).removeChild(bipedRightLeg);
    	((Modchu_ModelRenderer) leftLeg2).removeChild(bipedLeftLeg);
    	((Modchu_ModelRenderer) rightHand).removeChild(HandR);
    	((Modchu_ModelRenderer) leftHand).removeChild(HandL);
    	bipedBody.addChild(bipedRightLeg);
    	bipedBody.addChild(bipedLeftLeg);
    	bipedRightArm.addChild(HandR);
    	bipedLeftArm.addChild(HandL);

    	bipedBody.rotateAngleX = 0.0F;
    	bipedBody.rotateAngleY = 0.0F;
    	bipedBody.rotateAngleZ = 0.0F;
    	bipedHead.rotateAngleX = 0.0F;
    	bipedHead.rotateAngleY = 0.0F;
    	bipedHead.rotateAngleZ = 0.0F;
    	bipedHead.rotationPointX = 0.0F;
    	bipedHead.rotationPointZ = 0.0F;
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
    	rightHand.rotationPointY = -3.0F;
    	leftHand.rotationPointY = -3.0F;
    	rightLeg2.rotationPointY = -6.0F;
    	leftLeg2.rotationPointY = -6.0F;
    }

    @Override
    public void setArmorBipedHeadShowModel(boolean b) {
    	bipedHead.isHidden = !b;
    	super.setArmorBipedHeadShowModel(b);
    }

    @Override
    public void setArmorBipedBodyShowModel(boolean b) {
    	super.setArmorBipedBodyShowModel(b);
    	setCapsValue(caps_visible, Logo2, b);
    }
}
