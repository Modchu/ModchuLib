package net.minecraft.src;

public class MultiModel_tareusa extends MultiModel {

	public Modchu_ModelRenderer ChignonR;
	public Modchu_ModelRenderer ChignonL;
	public Modchu_ModelRenderer ChignonB;
	public Modchu_ModelRenderer SideTailR;
	public Modchu_ModelRenderer SideTailL;
	public Modchu_ModelRenderer Prim;
	public Modchu_ModelRenderer UsaEL;
	public Modchu_ModelRenderer UsaER;
	public Modchu_ModelRenderer UsaEL1;
	public Modchu_ModelRenderer UsaER1;
	public Modchu_ModelRenderer Usasippo;

	public Modchu_ModelRenderer eyeL;
	public Modchu_ModelRenderer eyeR;

	public MultiModel_tareusa() {
		this(0.0F);
	}

	public MultiModel_tareusa(float f) {
		this(f, 0.0F);
	}

	public MultiModel_tareusa(float f, float f1) {
		this(f, f1 , 64, 32);
	}

	public MultiModel_tareusa(float f, float f1, int i, int j) {
		super(f, f1, i, j);
	}

	@Override
	public void initModel(float f, float f1) {
		super.initModel(f, f1);
		Prim = new Modchu_ModelRenderer(this, 24, 16);
		Prim.addBoxLM(-2F, -8.7F, -3.5F, 4, 1, 0, f);
		Prim.setRotationPointLM(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(Prim);
		UsaEL = new Modchu_ModelRenderer(this, 0, 0);
		UsaEL.setMirror(true);
		UsaEL.addBoxLM(-1.5F, 0F, 2F, 3, 6, 1, f + 0.1F);
		UsaEL.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(UsaEL);
		UsaER = new Modchu_ModelRenderer(this, 0, 0);
		UsaER.addBoxLM(-1.5F, 0F, 2F, 3, 6, 1, f + 0.1F);
		UsaER.setRotationPointLM(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(UsaER);
		UsaEL1 = new Modchu_ModelRenderer(this, 0, 0);
		UsaEL1.setMirror(true);
		UsaEL1.addBoxLM(-1.5F, 0F, -1F, 3, 3, 1, f + 0.1F);
		UsaEL1.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(UsaEL1);
		UsaER1 = new Modchu_ModelRenderer(this, 0, 0);
		UsaER1.addBoxLM(-1.5F, 0F, -1F, 3, 3, 1, f + 0.1F);
		UsaER1.setRotationPointLM(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(UsaER1);

		Usasippo = new Modchu_ModelRenderer(this, 24, 0);
		Usasippo.addBox(-1.5F, -0.1F, 0.0F, 3, 3, 3, f);
		Usasippo.setRotationPoint(0.0F, 1.5F, 0.0F);
		bipedBody.addChild(Usasippo);
		eyeL = new Modchu_ModelRenderer(this, 32, 19);
		eyeL.addBox(-1F, -1F, -4.001F, 2, 2, 1, f + 0.1F);
		eyeL.setRotationPoint(-2.0F, -3.0F, 0.0F);
		bipedHead.addChild(eyeL);
		eyeR = new Modchu_ModelRenderer(this, 42, 19);
		eyeR.addBox(-1F, -1F, -4.001F, 2, 2, 1, f + 0.1F);
		eyeR.setRotationPoint(2.0F, -3.0F, 0.0F);
		bipedHead.addChild(eyeR);

		Usasippo.setRotationPointZ(2.0F);
		setCapsValue(caps_visible, bipedHeadwear, false);
	}

	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);

		Usasippo.setRotateAngleY(mh_sin(f * 0.6662F) * 0.3F);
		UsaER.rotateAngleX = UsaEL.rotateAngleX = mh_sin(f2 * 0.2F) * 0.1F + 0.2F;
		if (getCapsValueBoolean(caps_getIsRiding)) {
			Usasippo.setRotateAngleY(mh_sin(f * 0.6662F) * 0.5F);
		}
		if (getCapsValueFloat(caps_onGround) > -9990F && !getCapsValueBoolean(caps_aimedBow)) {
			Usasippo.rotateAngleY = mh_sin(f2 * 0.2F) * 0.2F;
			Usasippo.setRotateAngleX(0.0F);
		}
		if (getCapsValueBoolean(caps_getIsSneak)) {
			Usasippo.setRotateAngleY(0.0F);
		}
		if(getCapsValueBoolean(caps_getIsWait) && !getCapsValueBoolean(caps_aimedBow)) {
			Usasippo.setRotateAngleY(0.0F);
			Usasippo.setRotateAngleX(mh_sin(f2 * 0.3F) * 0.1F);
			UsaER.rotateAngleX = UsaEL.rotateAngleX = mh_sin(f2 * 0.1F) * 0.06F + 0.2F;
		}
		if (getCapsValueBoolean(caps_aimedBow)) {
			setCapsValue(caps_visible, eyeL, true);
			setCapsValue(caps_visible, eyeR, false);
			Usasippo.setRotateAngleY(0.0F);
		} else {
			if (0.0D > (double) (mh_sin(f2 * 0.1F) * 0.3F) + Math.random()
					* 0.10000000149011612D + 0.18000000715255737D) {
				setCapsValue(caps_visible, eyeL, false);
				setCapsValue(caps_visible, eyeR, false);
			} else {
				setCapsValue(caps_visible, eyeL, true);
				setCapsValue(caps_visible, eyeR, true);
			}
		}

		UsaEL.rotationPointX = UsaEL1.rotationPointX = 2.5F;
		UsaER.rotationPointX = UsaER1.rotationPointX = -2.5F;
		UsaEL.rotationPointY = UsaER.rotationPointY = UsaEL1.rotationPointY = UsaER1.rotationPointY = -8F;
		UsaEL.rotationPointZ = UsaER.rotationPointZ = UsaEL1.rotationPointZ = UsaER1.rotationPointZ = -0.5F;

		UsaEL1.rotateAngleX = UsaEL.rotateAngleX + 1.5708F;
		UsaER1.rotateAngleX = UsaER.rotateAngleX + 1.5708F;

		UsaER.rotateAngleY = UsaER1.rotateAngleY = mh_sin(f2 * 0.1F) * 0.06F - 1.920F;
		UsaEL.rotateAngleY = UsaEL1.rotateAngleY = mh_sin(f2 * 0.1F)
				* -0.06F + 1.920F;

	}

    @Override
    public void defaultPartsSettingBefore() {
    	super.defaultPartsSettingBefore();
    	String[] s = {
    			"bipedHeadwear", "d"
    	};
    	showPartsHideListadd(s);
    }

    @Override
    public void showModelSettingReflects() {
    	super.showModelSettingReflects();
    	setCapsValue(caps_visible, bipedHeadwear, false);
    }
}