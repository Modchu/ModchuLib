package net.minecraft.src;

public class MultiModel_Shion extends MultiModel {

    public Modchu_ModelRenderer longtail;
    public Modchu_ModelRenderer Headwear;
    public Modchu_ModelRenderer HeadwearR;
    public Modchu_ModelRenderer HeadwearL;
    public Modchu_ModelRenderer SkirtR;
    public Modchu_ModelRenderer SkirtL;
    public Modchu_ModelRenderer obi;
    public Modchu_ModelRenderer sodeR;
    public Modchu_ModelRenderer sodeL;
    public Modchu_ModelRenderer WsodeR;
    public Modchu_ModelRenderer WsodeL;
    public Modchu_ModelRenderer kanzasi;
    public Modchu_ModelRenderer osageL1;
    public Modchu_ModelRenderer osageL2;
    public Modchu_ModelRenderer osageL3;
    public Modchu_ModelRenderer osageL4;
    public Modchu_ModelRenderer osageR1;
    public Modchu_ModelRenderer osageR2;
    public Modchu_ModelRenderer osageR3;
    public Modchu_ModelRenderer osageR4;
    public Modchu_ModelRenderer osageLRib;
    public Modchu_ModelRenderer eyeL;
    public Modchu_ModelRenderer eyeR;
	private boolean sneakSkirt;

    public MultiModel_Shion()
    {
        this(0.0F);
    }

    public MultiModel_Shion(float f)
    {
        this(f, 0.0F);
    }

    public MultiModel_Shion(float f, float f1)
    {
    	this(f, f1 , 64, 32);
    }

    public MultiModel_Shion(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
    }

	@Override
	public void initModel(float f, float f1) {
		super.initModel(f, f1);
		longtail = new Modchu_ModelRenderer(this, 46, 19);
		longtail.addBox(-1F, 0.0F, 2.0F, 2, 12, 1, f + 0.2F);
		longtail.setRotationPoint(0.0F, -6.5F, 5F);
		bipedHead.addChild(longtail);
		((Modchu_ModelRenderer) bipedHead).removeChild(SideTailR);
		((Modchu_ModelRenderer) bipedHead).removeChild(SideTailL);
		SideTailR = new Modchu_ModelRenderer(this, 24, 0);
		SideTailR.addBox(-4.2F, -5.5F, -4.1F, 1, 6, 2, f);
		SideTailR.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(SideTailR);
		SideTailL = new Modchu_ModelRenderer(this, 24, 0);
		SideTailL.mirror = true;
		SideTailL.addBox(3.2F, -5.5F, -4.1F, 1, 6, 2, f);
		SideTailL.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(SideTailL);
		Headwear = new Modchu_ModelRenderer(this, 52, 16);
		Headwear.addBox(-1.5F, 0.0F, -3F, 3, 8, 3, f);
		Headwear.setRotationPoint(0.0F, -1F, 4F);
		bipedHead.addChild(Headwear);
		HeadwearR = new Modchu_ModelRenderer(this, 52, 16);
		HeadwearR.addBox(-4F, 0.0F, -3F, 3, 6, 3, f);
		HeadwearR.setRotationPoint(0.0F, -1F, 4F);
		bipedHead.addChild(HeadwearR);
		HeadwearL = new Modchu_ModelRenderer(this, 52, 16);
		HeadwearL.addBox(1.0F, 0.0F, -3F, 3, 6, 3, f);
		HeadwearL.setRotationPoint(0.0F, -1F, 4F);
		bipedHead.addChild(HeadwearL);
		SkirtR = new Modchu_ModelRenderer(this, 0, 18);
		SkirtR.addBox(-3F, -1F, -3F, 4, 8, 6, f + 0.01F);
		SkirtR.setRotationPoint(0.5F, 0.0F, 0.0F);
		bipedRightLeg.addChild(SkirtR);
		SkirtL = new Modchu_ModelRenderer(this, 12, 18);
		SkirtL.addBox(-1F, -1F, -3F, 4, 8, 6, f + 0.01F);
		SkirtL.setRotationPoint(-0.5F, 0.0F, 0.0F);
		bipedLeftLeg.addChild(SkirtL);
		obi = new Modchu_ModelRenderer(this, 52, 27);
		obi.addBox(-2.5F, 2.0F, 1.5F, 5, 4, 1, f);
		obi.setRotationPoint(0.0F, -3.5F, 0.0F);
		bipedBody.addChild(obi);
		sodeR = new Modchu_ModelRenderer(this, 36, 0);
		sodeR.addBox(-2F, -1F, -1F, 4, 6, 2, f + 0.1F);
		sodeR.setRotationPoint(1.0F, 1.5F, 0.0F);
		bipedRightArm.addChild(sodeR);
		sodeL = new Modchu_ModelRenderer(this, 36, 0);
		sodeL.addBox(-2F, -1F, -1F, 4, 6, 2, f + 0.1F);
		sodeL.setRotationPoint(-1.0F, 1.5F, 0.0F);
		bipedLeftArm.addChild(sodeL);
		WsodeR = new Modchu_ModelRenderer(this, 36, 0);
		WsodeR.addBox(-2F, -1F, 1.0F, 2, 6, 2, f);
		WsodeR.setRotationPoint(1.0F, 1.5F, 0.0F);
		bipedRightArm.addChild(WsodeR);
		WsodeL = new Modchu_ModelRenderer(this, 36, 0);
		WsodeL.addBox(0.0F, -1F, 1.0F, 2, 6, 2, f);
		WsodeL.setRotationPoint(-1.0F, 1.5F, 0.0F);
		bipedLeftArm.addChild(WsodeL);
		kanzasi = new Modchu_ModelRenderer(this, 0, 16);
		kanzasi.addBox(-7F, -8F, 5F, 1, 7, 1, f);
		kanzasi.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(kanzasi);
		eyeR = new Modchu_ModelRenderer(this, 32, 19);
		eyeR.addPlate(-4F, -4.9F, -4.001F, 4, 4, 0);
		eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(eyeR);
		eyeL = new Modchu_ModelRenderer(this, 42, 19);
		eyeL.addPlate(0.0F, -4.9F, -4.001F, 4, 4, 0);
		eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(eyeL);
		((Modchu_ModelRenderer) bipedHead).removeChild(bipedHeadwear);
		((Modchu_ModelRenderer) bipedHead).removeChild(Tail);
		((Modchu_ModelRenderer) bipedHead).removeChild(ChignonR);
		((Modchu_ModelRenderer) bipedHead).removeChild(ChignonL);
		setCapsValue(caps_visible, Skirt, false);
   }

    @Override
    public void skirtFloatsInit(float f, float f1) {
    }

    @Override
    public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    }

    @Override
    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);

    	bipedRightLeg.rotateAngleX = (MathHelper.cos(f * 0.6662F) * 1.4F * f1) / 1.5F;
    	bipedLeftLeg.rotateAngleX = (MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1) / 1.5F;
    	setCapsValue(caps_visible, sodeL, true);
    	setCapsValue(caps_visible, sodeR, true);
    	setCapsValue(caps_visible, WsodeL, false);
    	setCapsValue(caps_visible, WsodeR, false);
    	if(getCapsValueBoolean(caps_getIsRiding)) {
    		bipedRightLeg.rotateAngleY = 0.0F;
    		bipedLeftLeg.rotateAngleY = 0.0F;
    	}
    	boolean modchuRemodelingModel = getCapsValueBoolean(caps_modchuRemodelingModel);
    	if(getCapsValueBoolean(caps_getIsSneak)) {
    		if (!modchuRemodelingModel) {
    			bipedRightLeg.rotateAngleX -= 0.5F;
    			bipedLeftLeg.rotateAngleX -= 0.5F;
    		}
    		if (modchuRemodelingModel
    				&& !sneakSkirt) {
    			sneakSkirt = true;
    			((Modchu_ModelRenderer) bipedRightLeg).removeChild(SkirtR);
    			((Modchu_ModelRenderer) bipedLeftLeg).removeChild(SkirtL);
    			bipedBody.addChild(SkirtR);
    			bipedBody.addChild(SkirtL);
    			SkirtR.setRotationPoint(-1.0F, 3.3F, 0.0F);
    			SkirtL.setRotationPoint(1.0F, 3.3F, 0.0F);
    		}
    	} else {
    		if (modchuRemodelingModel
    				&& sneakSkirt) {
    			sneakSkirt = false;
    			((Modchu_ModelRenderer) bipedBody).removeChild(SkirtR);
    			((Modchu_ModelRenderer) bipedBody).removeChild(SkirtL);
    			bipedRightLeg.addChild(SkirtR);
    			bipedLeftLeg.addChild(SkirtL);
    			SkirtR.setRotationPoint(0.5F, 0.0F, 0.0F);
    			SkirtL.setRotationPoint(-0.5F, 0.0F, 0.0F);
    		}
    	}
    	if(getCapsValueBoolean(caps_getIsWait) && !getCapsValueBoolean(caps_aimedBow)) {
    		setCapsValue(caps_visible, sodeL, false);
    		setCapsValue(caps_visible, sodeR, false);
    		setCapsValue(caps_visible, WsodeL, true);
    		setCapsValue(caps_visible, WsodeR, true);
    	}
    	if(getCapsValueBoolean(caps_aimedBow)) {
    		setCapsValue(caps_visible, eyeR, false);
    		setCapsValue(caps_visible, eyeL, true);
    	}
    	ChignonB.rotateAngleX = 0.0873F;
    	Headwear.rotationPointY = -1F;
    	Headwear.rotationPointZ = 4F;
    	HeadwearR.rotationPointY = HeadwearL.rotationPointY = -2F;
    	HeadwearR.rotationPointZ = HeadwearL.rotationPointZ = 4F;
    	longtail.rotationPointY = -6F;
    	longtail.rotationPointZ = 3.5F;
    	Headwear.rotateAngleX = HeadwearR.rotateAngleX = longtail.rotateAngleX = HeadwearL.rotateAngleX = bipedHead.rotateAngleX <= 0.0F ? -bipedHead.rotateAngleX : -bipedHead.rotateAngleX / 2.0F;
    	longtail.rotateAngleY = mh_sin(f2 * 0.05F) * 0.06F;
    	kanzasi.rotateAngleX = -0.175F;
    	kanzasi.rotateAngleY = -0.175F;
    	kanzasi.rotateAngleZ = 1.396F;
    	obi.rotateAngleX = 0.0873F;
    	if (getCapsValueBoolean(caps_modchuRemodelingModel)) {
    		if (getCapsValueBoolean(caps_getIsSneak)) {
    			bipedBody.rotateAngleX = 0.0F;
    			bipedHead.rotationPointZ = 0.0F;
    			bipedBody.rotationPointZ = 0.0F;
    			bipedRightLeg.rotationPointZ = 0.0F;
    			bipedLeftLeg.rotationPointZ = 0.0F;
    			if (!getCapsValueBoolean(caps_aimedBow)) {
    				bipedRightArm.rotateAngleX = MathHelper.sin(f2 * 0.067F) * 0.05F - 0.7F;
    				bipedRightArm.rotateAngleY = 0.0F;
    				bipedRightArm.rotateAngleZ = -0.4F;
    				bipedLeftArm.rotateAngleX = MathHelper.sin(f2 * 0.067F) * 0.05F - 0.7F;
    				bipedLeftArm.rotateAngleY = 0.0F;
    				bipedLeftArm.rotateAngleZ = 0.4F;
    				bipedRightArm.rotationPointZ = 0.0F;
    				bipedLeftArm.rotationPointZ = 0.0F;
    				setCapsValue(caps_visible, sodeL, false);
    				setCapsValue(caps_visible, sodeR, false);
    				setCapsValue(caps_visible, WsodeL, true);
    				setCapsValue(caps_visible, WsodeR, true);
    			}
    		} else {
    			bipedHead.rotationPointZ = 0.0F;
    			bipedBody.rotationPointZ = 0.0F;
    			bipedRightArm.rotationPointZ = 0.0F;
    			bipedLeftArm.rotationPointZ = 0.0F;
    		}
    		if (getCapsValueBoolean(caps_getIsRiding)) {
    			if (entity.ridingEntity != null) {
    				bipedRightArm.rotateAngleX += -0.6283185F;
    				bipedLeftArm.rotateAngleX += -0.6283185F;
    				bipedRightLeg.rotateAngleX = -1.256637F;
    				bipedLeftLeg.rotateAngleX = -1.256637F;
    				bipedRightLeg.rotateAngleY = 0.3141593F;
    				bipedLeftLeg.rotateAngleY = -0.3141593F;
    			} else {
    				bipedRightLeg.rotateAngleX = bipedLeftLeg.rotateAngleX = 1.570796313F;
    				bipedRightLeg.rotationPointY = bipedLeftLeg.rotationPointY = 6.0F;
    				bipedRightLeg.rotationPointZ = bipedLeftLeg.rotationPointZ = -2.0F;
    			}
    		}
    	}
    	if (0.0D > (double) (mh_sin(f2 * 0.1F) * 0.3F)
    			+ Math.random() * 0.10000000149011612D
    			+ 0.18000000715255737D) {
    		setCapsValue(caps_visible, eyeL, true);
    		setCapsValue(caps_visible, eyeR, false);
    	} else {
    		setCapsValue(caps_visible, eyeL, true);
    		setCapsValue(caps_visible, eyeR, true);
    	}
    }

    @Override
    public void actionInit1() {
    	super.actionInit1();
    	((Modchu_ModelRenderer) bipedRightArm).removeChild(sodeR);
    	((Modchu_ModelRenderer) bipedLeftArm).removeChild(sodeL);
    	((Modchu_ModelRenderer) bipedRightArm).removeChild(WsodeR);
    	((Modchu_ModelRenderer) bipedLeftArm).removeChild(WsodeL);
    	rightArm.addChild(sodeR);
    	leftArm.addChild(sodeL);
    	rightArm.addChild(WsodeR);
    	leftArm.addChild(WsodeL);
    }

    @Override
    public void actionRelease1() {
    	super.actionRelease1();
    	((Modchu_ModelRenderer) rightArm).removeChild(sodeR);
    	((Modchu_ModelRenderer) leftArm).removeChild(sodeL);
    	((Modchu_ModelRenderer) rightArm).removeChild(WsodeR);
    	((Modchu_ModelRenderer) leftArm).removeChild(WsodeL);
    	bipedRightArm.addChild(sodeR);
    	bipedLeftArm.addChild(sodeL);
    	bipedRightArm.addChild(WsodeR);
    	bipedLeftArm.addChild(WsodeL);
    }

    @Override
    public void showModelSettingReflects() {
    	super.showModelSettingReflects();
		setCapsValue(caps_visible, Skirt, getGuiParts().get("Skirt"));
    }
}
