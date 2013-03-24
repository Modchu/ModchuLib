package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class MultiModel_chrno extends MultiModel {

    public Modchu_ModelRenderer RibonL;
    public Modchu_ModelRenderer RibonR;
    public Modchu_ModelRenderer CatEL;
    public Modchu_ModelRenderer CatER;
    public Modchu_ModelRenderer Icewing1;
    public Modchu_ModelRenderer Icewing2;
    public Modchu_ModelRenderer Icewing3;
    public Modchu_ModelRenderer Icewing4;
    public Modchu_ModelRenderer Icewing5;
    public Modchu_ModelRenderer Icewing6;
    public Modchu_ModelRenderer Prim;
    public Modchu_ModelRenderer eyeL;
    public Modchu_ModelRenderer eyeR;
    public Modchu_ModelRenderer Rightarm1;
    public Modchu_ModelRenderer Rightarm2;
    public Modchu_ModelRenderer Leftarm1;
    public Modchu_ModelRenderer Leftarm2;
    private boolean initWait = true;

    public MultiModel_chrno()
    {
    	this(0.0F);
    }

    public MultiModel_chrno(float f)
    {
    	this(f, 0.0F);
    }

    public MultiModel_chrno(float f, float f1)
    {
    	this(f, f1 , 64, 32);
    }

    public MultiModel_chrno(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
    }

    @Override
    public void initModel(float f, float f1) {
    	super.initModel(f, f1);
    	((Modchu_ModelRenderer) bipedBody).removeChild(Skirt);
    	Skirt = new Modchu_ModelRenderer(this, 0, 16);
    	Skirt.addBox(-4F, -4F, -4F, 8, 8, 8, f);
    	Skirt.setRotationPoint(0.0F, -4F + f1, 0.0F);
    	bipedBody.addChild(Skirt);

    	RibonL = new Modchu_ModelRenderer(this, 52, 10);
    	RibonL.setMirror(true);
    	RibonL.addBox(-5F, -10F, 3.5F, 4, 4, 2, f);
    	RibonL.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
    	RibonL.rotateAngleX = 6.108653F;
    	bipedHead.addChild(RibonL);
    	RibonR = new Modchu_ModelRenderer(this, 52, 10);
    	RibonR.setMirror(true);
    	RibonR.addBox(1.0F, -10F, 3.5F, 4, 4, 2, f);
    	RibonR.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
    	RibonR.rotateAngleX = 6.108653F;
    	bipedHead.addChild(RibonR);
    	CatEL = new Modchu_ModelRenderer(this, 0, 0);
    	CatEL.addBox(1.0F, -4F, 7F, 3, 3, 1, f);
    	CatEL.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
    	CatEL.rotateAngleX = -5.934119F;
    	bipedHead.addChild(CatEL);
    	CatER = new Modchu_ModelRenderer(this, 0, 4);
    	CatER.addBox(-4F, -4F, 7F, 3, 3, 1, f);
    	CatER.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
    	CatER.rotateAngleX = -5.934119F;
    	bipedHead.addChild(CatER);
    	Prim = new Modchu_ModelRenderer(this, 24, 16);
    	Prim.addBox(-2F, -8.7F, -3.5F, 4, 1, 0, f);
    	Prim.setRotationPoint(0.0F, 0.0F + f1, 0.0F);
    	bipedHead.addChild(Prim);
    	Icewing1 = new Modchu_ModelRenderer(this, 0, 16);
    	Icewing1.setMirror(true);
    	Icewing1.addBox(-1F, 5F, 4F, 2, 5, 1, f);
    	Icewing1.setRotationPoint(0.0F, -2.5F + f1, 0.0F);
    	bipedBody.addChild(Icewing1);
    	Icewing2 = new Modchu_ModelRenderer(this, 0, 16);
    	Icewing2.setMirror(true);
    	Icewing2.addBox(-1F, 5F, 4F, 2, 5, 1, f);
    	Icewing2.setRotationPoint(0.0F, -2.5F + f1, 0.0F);
    	bipedBody.addChild(Icewing2);
    	Icewing3 = new Modchu_ModelRenderer(this, 0, 16);
    	Icewing3.addBox(-1F, 5F, 4F, 2, 5, 1, f);
    	Icewing3.setRotationPoint(0.0F, -2.5F + f1, 0.0F);
    	bipedBody.addChild(Icewing3);
    	Icewing4 = new Modchu_ModelRenderer(this, 0, 16);
    	Icewing4.setMirror(true);
    	Icewing4.addBox(-1F, 5F, 4F, 2, 5, 1, f);
    	Icewing4.setRotationPoint(0.0F, -2.5F + f1, 0.0F);
    	bipedBody.addChild(Icewing4);
    	Icewing5 = new Modchu_ModelRenderer(this, 0, 16);
    	Icewing5.setMirror(true);
    	Icewing5.addBox(-1F, 5F, 4F, 2, 5, 1, f);
    	Icewing5.setRotationPoint(0.0F, -2.5F + f1, 0.0F);
    	bipedBody.addChild(Icewing5);
    	Icewing6 = new Modchu_ModelRenderer(this, 0, 16);
    	Icewing6.addBox(-1F, 5F, 4F, 2, 5, 1, f);
    	Icewing6.setRotationPoint(0.0F, -2.5F + f1, 0.0F);
    	bipedBody.addChild(Icewing6);
    	eyeL = new Modchu_ModelRenderer(this, 58, 16);
    	eyeL.addBox(-1F, -1F, -4.001F, 2, 2, 1, f + 0.1F);
    	eyeL.setRotationPoint(-2.0F, -2.5F, 0.0F);
    	bipedHead.addChild(eyeL);
    	eyeR = new Modchu_ModelRenderer(this, 60, 16);
    	eyeR.addBox(-1F, -1F, -4.001F, 2, 2, 1, f + 0.1F);
    	eyeR.setRotationPoint(2.0F, -2.5F, 0.0F);
    	bipedHead.addChild(eyeR);
    	Rightarm1 = new Modchu_ModelRenderer(this, 48, 0);
    	Rightarm1.addBox(-2F, 2.8F, -1F, 2, 5, 2);
    	Rightarm1.setRotationPoint(0.0F, -4.0F + f1, 0.0F);
    	bipedBody.addChild(Rightarm1);
    	Rightarm2 = new Modchu_ModelRenderer(this, 48, 5);
    	Rightarm2.addBox(-6.8F, -3.8F, -0.98F, 2, 3, 2);
    	Rightarm2.setRotationPoint(0.0F, -4.0F + f1, 0.0F);
    	bipedBody.addChild(Rightarm2);
    	Leftarm1 = new Modchu_ModelRenderer(this, 56, 0);
    	Leftarm1.addBox(0.0F, 2.8F, -1F, 2, 5, 2);
    	Leftarm1.setRotationPoint(0.0F, -4.0F + f1, 0.0F);
    	bipedBody.addChild(Leftarm1);
    	Leftarm2 = new Modchu_ModelRenderer(this, 56, 5);
    	Leftarm2.addBox(4.8F, -3.8F, -0.98F, 2, 3, 2);
    	Leftarm2.setRotationPoint(0.0F, -4.0F + f1, 0.0F);
    	bipedBody.addChild(Leftarm2);

    }

    @Override
    public void reset(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	super.reset(f, f1, f2, f3, f4, f5, entity);
    	Icewing1.setRotateAngleZ(0.8726646F);
    	Icewing2.setRotateAngleZ(1.570796F);
    	Icewing3.setRotateAngleZ(2.094395F);
    	Icewing4.setRotateAngleZ(5.235988F);
    	Icewing5.setRotateAngleZ(4.712389F);
    	Icewing6.setRotateAngleZ(4.18879F);
    	Rightarm1.rotateAngleZ = 1.047F;
    	Rightarm2.rotateAngleZ = -1.047F;
    	Leftarm1.rotateAngleZ = -1.047F;
    	Leftarm2.rotateAngleZ = 1.047F;
    }

    @Override
    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);
    	if(31.41593F >= mh_abs(f2)) {
    		f2 %= 31.41593F;
    	}
    	Icewing1.setRotateAngleX(Icewing2.setRotateAngleX(Icewing3.setRotateAngleX(mh_sin(f * f * 0.6662F) * 0.15F)));
    	Icewing4.setRotateAngleX(Icewing5.setRotateAngleX(Icewing6.setRotateAngleX(mh_sin(f * f * 0.6662F) * 0.15F)));
    	if(getCapsValueFloat(caps_onGround) > -9990F && !getCapsValueBoolean(caps_aimedBow)) {
    		Icewing1.setRotateAngleY(Icewing2.setRotateAngleY(Icewing3.setRotateAngleY(((Modchu_ModelRenderer) bipedBody).getRotateAngleY())));
    		Icewing4.setRotateAngleY(Icewing5.setRotateAngleY(Icewing6.setRotateAngleY(((Modchu_ModelRenderer) bipedBody).getRotateAngleY())));
    	}
    	if(getCapsValueBoolean(caps_getIsWait) && !getCapsValueBoolean(caps_aimedBow)) {
    		if (!initWait) {
    			initWait = true;
    			Rightarm1.isHidden = false;
    			Rightarm2.isHidden = false;
    			Leftarm1.isHidden = false;
    			Leftarm2.isHidden = false;
    			setCapsValue(caps_visible, Leftarm1, true);
    			setCapsValue(caps_visible, Leftarm2, true);
    			setCapsValue(caps_visible, Rightarm1, true);
    			setCapsValue(caps_visible, Rightarm2, true);
    			((Modchu_ModelRenderer) bipedRightArm).removeChild(Arms[0]);
    			((Modchu_ModelRenderer) bipedRightArm).removeChild(Arms[2]);
    			((Modchu_ModelRenderer) bipedLeftArm).removeChild(Arms[1]);
    			((Modchu_ModelRenderer) bipedLeftArm).removeChild(Arms[3]);
    			Rightarm2.addChild(Arms[0]);
    			Rightarm2.addChild(Arms[2]);
    			Leftarm2.addChild(Arms[1]);
    			Leftarm2.addChild(Arms[3]);
    			Arms[0].setRotationPoint(-5.0F, 0.0F, 0F);
    		}
    		setCapsValue(caps_visible, bipedRightArm, false);
    		setCapsValue(caps_visible, bipedLeftArm, false);
    		Icewing3.setRotateAngleX(Icewing6.setRotateAngleX(mh_sin(f2 * f2 * 0.6662F) * 0.2F));
    		((Modchu_ModelRenderer) bipedRightArm).setRotateAngleX(0.0F);
    		((Modchu_ModelRenderer) bipedRightArm).setRotateAngleY(0.0F);
    		((Modchu_ModelRenderer) bipedRightArm).setRotateAngleZ(0.0F);
    		Rightarm1.rotationPointY = Rightarm2.rotationPointY =
    				Leftarm1.rotationPointY = Leftarm2.rotationPointY = mh_sin(f2 * 0.05F) * 0.2F - 4.0F;
    	} else {
    		if (initWait) {
    			initWait = false;
    			Rightarm1.isHidden = true;
    			Rightarm2.isHidden = true;
    			Leftarm1.isHidden = true;
    			Leftarm2.isHidden = true;
    			setCapsValue(caps_visible, Leftarm1, false);
    			setCapsValue(caps_visible, Leftarm2, false);
    			setCapsValue(caps_visible, Rightarm1, false);
    			setCapsValue(caps_visible, Rightarm2, false);
    			setCapsValue(caps_visible, bipedRightArm, true);
    			setCapsValue(caps_visible, bipedLeftArm, true);
    			Rightarm2.removeChild(Arms[0]);
    			Rightarm2.removeChild(Arms[2]);
    			Leftarm2.removeChild(Arms[1]);
    			Leftarm2.removeChild(Arms[3]);
    			bipedRightArm.addChild(Arms[0]);
    			bipedRightArm.addChild(Arms[2]);
    			bipedLeftArm.addChild(Arms[1]);
    			bipedLeftArm.addChild(Arms[3]);
    			Arms[0].setRotationPoint(0.5F, 6.5F, 0F);
    		}
    	}
    	if(getCapsValueBoolean(caps_aimedBow)) {
    		setCapsValue(caps_visible, eyeL, true);
    		setCapsValue(caps_visible, eyeR, false);
    	} else {
    		if(0.0D > (double)(mh_sin(f2 * 0.1F) * 0.3F) + Math.random() * 0.10000000149011612D + 0.18000000715255737D) {
    			setCapsValue(caps_visible, eyeL, false);
    			setCapsValue(caps_visible, eyeR, false);
    		} else {
    			setCapsValue(caps_visible, eyeL, true);
    			setCapsValue(caps_visible, eyeR, true);
    		}
    	}
    }

	@Override
	public void actionInit1() {
		super.actionInit1();
		bipedLeftArm.isHidden = true;
		bipedRightArm.isHidden = true;
		bipedLeftLeg.isHidden = true;
		bipedRightLeg.isHidden = true;
		Rightarm1.isHidden = true;
		Rightarm2.isHidden = true;
		Leftarm1.isHidden = true;
		Leftarm2.isHidden = true;
		setCapsValue(caps_visible, Leftarm1, true);
		setCapsValue(caps_visible, Leftarm2, true);
		setCapsValue(caps_visible, Rightarm1, true);
		setCapsValue(caps_visible, Rightarm2, true);
		setCapsValue(caps_visible, bipedRightArm, false);
		setCapsValue(caps_visible, bipedLeftArm, false);
		((Modchu_ModelRenderer) bipedRightArm).removeChild(Arms[0]);
		((Modchu_ModelRenderer) bipedRightArm).removeChild(Arms[2]);
		((Modchu_ModelRenderer) bipedLeftArm).removeChild(Arms[1]);
		((Modchu_ModelRenderer) bipedLeftArm).removeChild(Arms[3]);
		Rightarm2.removeChild(Arms[0]);
		Rightarm2.removeChild(Arms[2]);
		Leftarm2.removeChild(Arms[1]);
		Leftarm2.removeChild(Arms[3]);
		if (Arms[0] != null) Arms[0].setRotationPoint(0.5F, 0.0F, 0F);
		if (Arms[1] != null) Arms[1].setRotationPoint(-0.5F, 0.0F, 0F);
	}

	@Override
	public void actionRelease1() {
		super.actionRelease1();
		bipedLeftArm.isHidden = false;
		bipedRightArm.isHidden = false;
		bipedLeftLeg.isHidden = false;
		bipedRightLeg.isHidden = false;
		Rightarm1.isHidden = false;
		Rightarm2.isHidden = false;
		Leftarm1.isHidden = false;
		Leftarm2.isHidden = false;
		setCapsValue(caps_visible, Leftarm1, false);
		setCapsValue(caps_visible, Leftarm2, false);
		setCapsValue(caps_visible, Rightarm1, false);
		setCapsValue(caps_visible, Rightarm2, false);
		setCapsValue(caps_visible, bipedRightArm, true);
		setCapsValue(caps_visible, bipedLeftArm, true);
	}

    public float getWidth()
    {
    	return 0.8F;
    }

    public ModelRenderer getBipedRightArm() {
    	if (getCapsValueBoolean(caps_shortcutKeysAction)
    			&& getCapsValueInt(caps_runActionNumber) == 0
    			| getCapsValueInt(caps_runActionNumber) == 1) {
    		if (getCapsValueInt(caps_dominantArm) == 0) return rightArm;
    		return leftArm;
    	}
    	else {
    		if(getCapsValueBoolean(caps_getIsWait) && !getCapsValueBoolean(caps_aimedBow))
    		{
    			if (getCapsValueInt(caps_dominantArm) == 0) return Rightarm1;
    			return Leftarm1;
    		} else {
    			if (getCapsValueInt(caps_dominantArm) == 0) return bipedRightArm;
    			return bipedLeftArm;
    		}
    	}
    }

    @Override
    public void setArmorBipedRightArmShowModel(boolean b) {
    	super.setArmorBipedRightArmShowModel(b);
    	if(getCapsValueBoolean(caps_getIsWait) && !getCapsValueBoolean(caps_aimedBow)) {
    		Rightarm1.isHidden = b;
    		Rightarm2.isHidden = b;
    	} else {
    		Rightarm1.isHidden = !b;
    		Rightarm2.isHidden = !b;
    	}
    }

    @Override
    public void setArmorBipedLeftArmShowModel(boolean b) {
    	super.setArmorBipedLeftArmShowModel(b);
    	if(getCapsValueBoolean(caps_getIsWait) && !getCapsValueBoolean(caps_aimedBow)) {
    		Leftarm1.isHidden = b;
    		Leftarm2.isHidden = b;
    	} else {
    		Leftarm1.isHidden = !b;
    		Leftarm2.isHidden = !b;
    	}
    }
}
