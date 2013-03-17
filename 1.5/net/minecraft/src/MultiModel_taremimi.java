package net.minecraft.src;

public class MultiModel_taremimi extends MultiModel {

    public Modchu_ModelRenderer ChignonR;
    public Modchu_ModelRenderer ChignonL;
    public Modchu_ModelRenderer ChignonB;
    public Modchu_ModelRenderer WTail;
    public Modchu_ModelRenderer SideTailR;
    public Modchu_ModelRenderer SideTailL;
    public Modchu_ModelRenderer Prim;
    public Modchu_ModelRenderer DogEL;
    public Modchu_ModelRenderer DogER;
    public Modchu_ModelRenderer Wansippo1;
    public Modchu_ModelRenderer Wansippo2;
    public Modchu_ModelRenderer Wansippo3;
    public Modchu_ModelRenderer Wansippo4;
    public Modchu_ModelRenderer eyeL;
    public Modchu_ModelRenderer eyeR;

    public MultiModel_taremimi()
    {
        this(0.0F);
    }

    public MultiModel_taremimi(float f)
    {
        this(f, 0.0F);
    }

    public MultiModel_taremimi(float f, float f1)
    {
    	this(f, f1 , 64, 32);
    }

    public MultiModel_taremimi(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
    }

	@Override
	public void initModel(float f, float f1) {
		super.initModel(f, f1);
		WTail = new Modchu_ModelRenderer(this, 46, 19);
		WTail.addBox(-2F, -7.1F, 3F, 4, 11, 2, f);
		WTail.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(WTail);
		Prim = new Modchu_ModelRenderer(this, 24, 16);
		Prim.addBox(-2F, -8.7F, -3.5F, 4, 1, 0, f);
		Prim.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(Prim);
		DogEL = new Modchu_ModelRenderer(this, 0, 0);
		DogEL.setMirror(true);
		DogEL.addBox(0.0F, -7F, 5F, 3, 6, 1, f + 0.1F);
		DogEL.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(DogEL);
		DogER = new Modchu_ModelRenderer(this, 0, 0);
		DogER.addBox(-3F, -7F, 5F, 3, 6, 1, f + 0.1F);
		DogER.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(DogER);
		Wansippo1 = new Modchu_ModelRenderer(this, 0, 16);
		Wansippo1.addBox(-0.5F, 0.0F, 0.0F, 1, 2, 3, f + 0.2F);
		Wansippo1.setRotationPoint(0.0F, 2.5F, 2.0F);
		bipedBody.addChild(Wansippo1);
		Wansippo2 = new Modchu_ModelRenderer(this, 0, 16);
		Wansippo2.addBox(-0.5F, -1F, 2.0F, 1, 2, 3, f + 0.3F);
		Wansippo2.setRotationPoint(0.0F, 2.5F, 2.0F);
		bipedBody.addChild(Wansippo2);
		Wansippo3 = new Modchu_ModelRenderer(this, 0, 16);
		Wansippo3.addBox(-0.5F, -4F, 4F, 1, 4, 3, f + 0.3F);
		Wansippo3.setRotationPoint(0.0F, 2.5F, 2.0F);
		bipedBody.addChild(Wansippo3);
		Wansippo4 = new Modchu_ModelRenderer(this, 1, 17);
		Wansippo4.addBox(-0.5F, -4.5F, 3F, 1, 1, 2, f + 0.3F);
		Wansippo4.setRotationPoint(0.0F, 2.5F, 2.0F);
		bipedBody.addChild(Wansippo4);
		eyeL = new Modchu_ModelRenderer(this, 58, 16);
		eyeL.addBox(-1F, -1F, -4.001F, 2, 2, 1, f + 0.1F);
		eyeL.setRotationPoint(-2.0F, -2.5F, 0.0F);
		bipedHead.addChild(eyeL);
		eyeR = new Modchu_ModelRenderer(this, 60, 16);
		eyeR.addBox(-1F, -1F, -4.001F, 2, 2, 1, f + 0.1F);
		eyeR.setRotationPoint(2.0F, -2.5F, 0.0F);
		bipedHead.addChild(eyeR);
		DogER.rotateAngleY = -1.5708F;
		DogEL.rotateAngleY = 1.5708F;
    }

    @Override
    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);
    	Wansippo1.setRotationPointZ(Wansippo2.setRotationPointZ(Wansippo3.setRotationPointZ(Wansippo4.setRotationPointZ(2F))));
    	Wansippo1.setRotateAngleX(Wansippo2.setRotateAngleX(Wansippo3.setRotateAngleX(Wansippo4.setRotateAngleX(-0.275F))));
    	Wansippo1.setRotateAngleY(Wansippo2.setRotateAngleY(Wansippo3.setRotateAngleY(Wansippo4.setRotateAngleY(mh_cos(f2 * 0.2F) * 0.05F))));
    	Wansippo1.setRotateAngleZ(Wansippo2.setRotateAngleZ(Wansippo3.setRotateAngleZ(Wansippo4.setRotateAngleZ(mh_sin(f2 * 0.2F) * 0.5F))));
    	if(getCapsValueBoolean(caps_getIsRiding)) {
    		Wansippo1.setRotateAngleX(Wansippo2.setRotateAngleX(Wansippo3.setRotateAngleX(Wansippo4.setRotateAngleX(-0.1F))));
    	}
    	if(getCapsValueBoolean(caps_getIsWait) && !getCapsValueBoolean(caps_aimedBow)) {
    		Wansippo1.setRotateAngleZ(Wansippo2.setRotateAngleZ(Wansippo3.setRotateAngleZ(Wansippo4.setRotateAngleZ(mh_sin(f2 * 0.5F) * 1.0F))));
    		Wansippo1.setRotateAngleY(Wansippo2.setRotateAngleY(Wansippo3.setRotateAngleY(Wansippo4.setRotateAngleY(mh_cos(f2 * 0.5F) * 1.0F))));
    	}
    	if (getCapsValueBoolean(caps_aimedBow)) {
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
    	DogER.rotateAngleX = DogEL.rotateAngleX = mh_sin(f2 * 0.05F) * 0.06F + 0.2F;
    }
}
