package net.minecraft.src;

public class MultiModel_MS1 extends MultiModel_SR2
{
    public Modchu_ModelRenderer Goggles1;
    public Modchu_ModelRenderer Goggles2;
    public Modchu_ModelRenderer Goggles3;
    public Modchu_ModelRenderer GogglesR;
    public Modchu_ModelRenderer GogglesL;
    public Modchu_ModelRenderer Goggles1A;
    public Modchu_ModelRenderer Goggles2A;
    public Modchu_ModelRenderer Goggles3A;
    public Modchu_ModelRenderer GogglesRA;
    public Modchu_ModelRenderer GogglesLA;
    public Modchu_ModelRenderer Cheek_R;
    public Modchu_ModelRenderer Cheek_L;

    public MultiModel_MS1()
    {
        this(0.0F);
    }

    public MultiModel_MS1(float f)
    {
        this(f, 0.0F);
    }

    public MultiModel_MS1(float f, float f1)
    {
    	this(f, f1 , 64, 64);
    }

    public MultiModel_MS1(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
    }

	@Override
	public void initModel(float f, float f1) {
		textureWidth = 64;
		textureHeight = 64;
		super.initModel(f, f1);
		((Modchu_ModelRenderer) bipedBody).removeChild(Skirt);
		Skirt = new Modchu_ModelRenderer(this, 0, 16);
		Skirt.addBox(-3.5F, -2F, -3F, 7, 7, 6, f);
		Skirt.setRotationPoint(0.0F, 7F + f1, 0.0F);
		bipedBody.addChild(Skirt);
		Goggles1A = new Modchu_ModelRenderer(this, 0, 32);
		Goggles1A.addBoxLM(-4F, -5.5F, -5F, 8, 4, 1, f);
		Goggles1A.setRotationPointLM(0.0F, 0.0F, 0.0F);
		Goggles2A = new Modchu_ModelRenderer(this, 0, 37);
		Goggles2A.addBoxLM(-4F, -4F, -6F, 8, 1, 1, f);
		Goggles2A.setRotationPointLM(0.0F, 0.0F, 0.0F);
		Goggles3A = new Modchu_ModelRenderer(this, 0, 39);
		Goggles3A.addBox(-3.5F, -5.5F, -5.5F, 7, 4, 1, f);
		Goggles3A.setRotationPointLM(0.0F, 0.0F, 0.0F);
		GogglesRA = new Modchu_ModelRenderer(this, 0, 44);
		GogglesRA.addBox(-5.1F, -4.5F, -5F, 1, 2, 3, f);
		GogglesRA.setRotationPointLM(0.0F, 0.0F, 0.0F);
		GogglesLA = new Modchu_ModelRenderer(this, 0, 44);
		GogglesLA.mirror = true;
		GogglesLA.addBox(4.1F, -4.5F, -5F, 1, 2, 3, f);
		GogglesLA.setRotationPointLM(0.0F, 0.0F, 0.0F);
		Goggles1 = new Modchu_ModelRenderer(this, 0, 32);
		Goggles1.addBoxLM(-4F, -7F, -7.3F, 8, 4, 1, f + 0.1F);
		Goggles1.setRotationPointLM(0.0F, 0.0F, 0.0F);
		Goggles1.setRotateAngleX(-0.4886921F);
		Goggles2 = new Modchu_ModelRenderer(this, 0, 37);
		Goggles2.addBoxLM(-4F, -5.5F, -8.3F, 8, 1, 1, f);
		Goggles2.setRotationPointLM(0.0F, 0.0F, 0.0F);
		Goggles2.setRotateAngleX(-0.4886921F);
		Goggles3 = new Modchu_ModelRenderer(this, 0, 39);
		Goggles3.addBox(-3.5F, -7F, -7.8F, 7, 4, 1, f + 0.1F);
		Goggles3.setRotationPointLM(0.0F, 0.0F, 0.0F);
		Goggles3.setRotateAngleX(-0.4886921F);
		GogglesR = new Modchu_ModelRenderer(this, 0, 44);
		GogglesR.addBox(-5.1F, -5.5F, -7F, 1, 2, 3, f);
		GogglesR.setRotationPointLM(0.0F, 0.0F, 0.0F);
		GogglesR.setRotateAngleX(-0.4886921F);
		GogglesL = new Modchu_ModelRenderer(this, 0, 44);
		GogglesL.mirror = true;
		GogglesL.addBox(4.1F, -5.5F, -7F, 1, 2, 3, f);
		GogglesL.setRotationPointLM(0.0F, 0.0F, 0.0F);
		GogglesL.setRotateAngleX(-0.4886921F);
		Cheek_R = new Modchu_ModelRenderer(this, 32, 8);
		Cheek_R.addPlate(-4.5F, -4.5F, -4.002F, 4, 4, 0, f);
		Cheek_R.setRotationPointLM(0.0F, 1.0F, 0.0F);
		Cheek_L = new Modchu_ModelRenderer(this, 32, 19);
		Cheek_L.addPlate(0.5F, -4.5F, -4.002F, 4, 4, 0, f);
		Cheek_L.setRotationPointLM(0.0F, 1.0F, 0.0F);
		((Modchu_ModelRenderer) bipedHead).removeChild(eyeR);
		((Modchu_ModelRenderer) bipedHead).removeChild(eyeL);
		eyeR = new Modchu_ModelRenderer(this, 0, 0);
		eyeR.addPlate(-4F, -5.0F, -4.001F, 4, 4, 0, f);
		eyeR.setRotationPointLM(0.0F, 0.0F, 0.0F);
		eyeL = new Modchu_ModelRenderer(this, 4, 0);
		eyeL.addPlate(0.0F, -5.0F, -4.001F, 4, 4, 0, f);
		eyeL.setRotationPointLM(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(eyeR);
		bipedHead.addChild(eyeL);
		bipedHead.addChild(Goggles1A);
		bipedHead.addChild(Goggles2A);
		bipedHead.addChild(Goggles3A);
		bipedHead.addChild(GogglesRA);
		bipedHead.addChild(GogglesLA);
		bipedHead.addChild(Goggles1);
		bipedHead.addChild(Goggles2);
		bipedHead.addChild(Goggles3);
		bipedHead.addChild(GogglesR);
		bipedHead.addChild(GogglesL);
		bipedHead.addChild(Cheek_R);
		bipedHead.addChild(Cheek_L);
		setCapsValue(caps_visible, Tail, false);
		setCapsValue(caps_visible, SideTailR, false);
		setCapsValue(caps_visible, SideTailL, false);
		setCapsValue(caps_visible, ChignonR, false);
		setCapsValue(caps_visible, ChignonL, false);
		setCapsValue(caps_visible, ChignonB, false);
		setCapsValue(caps_visible, Goggles1, true);
		setCapsValue(caps_visible, Goggles2, true);
		setCapsValue(caps_visible, Goggles3, true);
		setCapsValue(caps_visible, GogglesR, true);
		setCapsValue(caps_visible, GogglesL, true);
		setCapsValue(caps_visible, Goggles1A, false);
		setCapsValue(caps_visible, Goggles2A, false);
		setCapsValue(caps_visible, Goggles3A, false);
		setCapsValue(caps_visible, GogglesRA, false);
		setCapsValue(caps_visible, GogglesLA, false);
	}

	public void skirtFloatsInit(float f, float f1) {
    	if(!getCapsValueBoolean(caps_skirtFloats)) return;
    	//ふんわりスカート上
    	SkirtTop = new Modchu_ModelRenderer(this, 6, 16);
    	((Modchu_ModelRenderer) SkirtTop).addPlate(0.0F, 0.0F, 0.0F, 7, 6, 0);
    	SkirtTop.setRotationPoint(-4.0F, -4.0F, 4.0F);
    	Skirt.addChild(SkirtTop);

    	//ふんわりスカート前
    	SkirtFront = new Modchu_ModelRenderer(this, 6, 22);
    	((Modchu_ModelRenderer) SkirtFront).addPlate(0.0F, 0.0F, 0.0F, 7, 7, 0);
    	SkirtFront.setRotationPoint(0.0F, 8.0F, 0.0F);
    	SkirtTop.addChild(SkirtFront);

    	//ふんわりスカート右
    	SkirtRight = new Modchu_ModelRenderer(this, 0, 22);
    	((Modchu_ModelRenderer) SkirtRight).addPlate(0.0F, 0.0F, 0.0F, 6, 7, 1);
    	SkirtRight.setRotationPoint(0.0F, 0.0F, 0.0F);
    	SkirtTop.addChild(SkirtRight);

    	//ふんわりスカート左
    	SkirtLeft = new Modchu_ModelRenderer(this, 13, 22);
    	((Modchu_ModelRenderer) SkirtLeft).setMirror(true);
    	((Modchu_ModelRenderer) SkirtLeft).addPlate(0.0F, 0.0F, 0.0F, 6, 7, 1);
    	SkirtLeft.setRotationPoint(8.0F, 8.0F, 0.0F);
    	SkirtTop.addChild(SkirtLeft);

    	//ふんわりスカート後ろ
    	SkirtBack = new Modchu_ModelRenderer(this, 18, 22);
    	((Modchu_ModelRenderer) SkirtBack).addPlate(0.0F, 0.0F, 0.0F, 7, 7, 0);
    	SkirtBack.setRotationPoint(0.0F, 0.0F, 0.0F);
    	SkirtTop.addChild(SkirtBack);
    	setCapsValue(caps_visible, Skirt, false);
    }

    public void setLivingAnimationsLM(EntityLiving entityliving, float f, float f1, float f2)
    {
        super.setLivingAnimationsLM(entityliving, f, f1, f2);
    	if (getCapsValueBoolean(caps_isLookSuger)) {
    		setCapsValue(caps_visible, Cheek_R, true);
    		setCapsValue(caps_visible, Cheek_L, true);
    	} else {
    		setCapsValue(caps_visible, Cheek_R, false);
    		setCapsValue(caps_visible, Cheek_L, false);
    	}
    }

    @Override
    public void setRotationAnglesLM(float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, Entity entity)
    {
    	super.setRotationAnglesLM(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entity);
    	if (getCapsValueBoolean(caps_aimedBow)) {
    		setCapsValue(caps_visible, eyeR, false);
    		setCapsValue(caps_visible, eyeL, true);
    	}
    	Skirt.rotationPointY -= 2.0F;
    	Skirt.rotationPointZ = 0.0F;
    	if (getCapsValueBoolean(caps_getIsSneak)) {
    		Skirt.rotateAngleX += 0.3F;
    	}
    }

    @Override
    public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	super.skirtFloats(f, f1, f2, f3, f4, f5, entity);
    	if (!getCapsValueBoolean(caps_skirtFloats)) return;
    	float motionY = getCapsValueFloat(caps_motionY);
    	SkirtTop.setRotationPoint(-3.5F, -2.5F, 3.0F);
    	SkirtFront.setRotationPoint(0.0F, 6.0F, 0.0F);
    	SkirtRight.setRotationPoint(0.0F, 0.0F, 0.0F);
    	SkirtLeft.setRotationPoint(7.0F, 6.0F, 0.0F);
    	SkirtBack.setRotationPoint(0.0F, 0.0F, 0.0F);
    	SkirtFront.rotationPointX += motionY * 4.0F;
    	SkirtBack.rotationPointX += motionY * 4.0F;
    	SkirtRight.rotationPointY += motionY * 4.0F;
    	SkirtLeft.rotationPointY -= motionY * 4.0F;
    }

    @Override
    public void defaultPartsSettingAfter() {
    	//GogglesA Default off
    	setGuiParts("GogglesA", false);
    	//Cheek Default off
    	setGuiParts("Cheek", false);
    }

    @Override
    public void showModelSettingReflects() {
    	super.showModelSettingReflects();
    	setCapsValue(caps_visible, Tail, false);
    	setCapsValue(caps_visible, SideTailR, false);
    	setCapsValue(caps_visible, SideTailL, false);
    	setCapsValue(caps_visible, ChignonR, false);
    	setCapsValue(caps_visible, ChignonL, false);
    	setCapsValue(caps_visible, ChignonB, false);
    	setCapsValue(caps_visible, Goggles1, true);
    	setCapsValue(caps_visible, Goggles2, true);
    	setCapsValue(caps_visible, Goggles3, true);
    	setCapsValue(caps_visible, GogglesR, true);
    	setCapsValue(caps_visible, GogglesL, true);
    	setCapsValue(caps_visible, Goggles1A, false);
    	setCapsValue(caps_visible, Goggles2A, false);
    	setCapsValue(caps_visible, Goggles3A, false);
    	setCapsValue(caps_visible, GogglesRA, false);
    	setCapsValue(caps_visible, GogglesLA, false);
    }
}