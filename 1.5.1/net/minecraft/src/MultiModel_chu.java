package net.minecraft.src;

public class MultiModel_chu extends MultiModel {

    public Modchu_ModelRenderer CatEL;
    public Modchu_ModelRenderer CatER;
    public Modchu_ModelRenderer CatTail;
    public Modchu_ModelRenderer Prim;
    public Modchu_ModelRenderer eyeL;
    public Modchu_ModelRenderer eyeR;

    public MultiModel_chu()
    {
        this(0.0F);
    }

    public MultiModel_chu(float f)
    {
        this(f, 0.0F);
    }

    public MultiModel_chu(float f, float f1)
    {
    	this(f, f1 , 64, 32);
    }

    public MultiModel_chu(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
    }

	@Override
	public void initModel(float f, float f1) {
		super.initModel(f, f1);
		CatEL = new Modchu_ModelRenderer(this, 0, 4);
		CatEL.addBox(1.0F, -11F, -2F, 3, 3, 1, f);
		CatEL.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(CatEL);
		CatER = new Modchu_ModelRenderer(this, 0, 0);
		CatER.addBox(-4F, -11F, -2F, 3, 3, 1, f);
		CatER.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(CatER);
		CatTail = new Modchu_ModelRenderer(this, 0, 16);
		CatTail.addBox(-0.5F, 0.0F, 0.0F, 1, 7, 1, f);
		CatTail.setRotationPoint(0.0F, 3F, 0.0F);
		bipedBody.addChild(CatTail);
		Prim = new Modchu_ModelRenderer(this, 24, 16);
		Prim.addBox(-2F, -8.7F, -3.5F, 4, 1, 0, f);
		Prim.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(Prim);
		eyeL = new Modchu_ModelRenderer(this, 58, 16);
		eyeL.addBox(-1F, -1F, -4.001F, 2, 2, 1, f + 0.1F);
		eyeL.setRotationPoint(-2.0F, -3.0F, 0.0F);
		bipedHead.addChild(eyeL);
		eyeR = new Modchu_ModelRenderer(this, 60, 16);
		eyeR.addBox(-1F, -1F, -4.001F, 2, 2, 1, f + 0.1F);
		eyeR.setRotationPoint(2.0F, -3.0F, 0.0F);
		bipedHead.addChild(eyeR);
		CatTail.setRotationPointZ(2.0F);
		CatTail.setRotateAngleX(-4.363323F);
    }

    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);
        CatTail.setRotateAngleX(mh_sin(f * 0.6662F) * 0.5F - 4.363323F);

        if(getCapsValueFloat(caps_onGround) > -9990F && !getCapsValueBoolean(caps_aimedBow)) {
            CatTail.setRotateAngleY(((Modchu_ModelRenderer) bipedBody).getRotateAngleY());
        }

        if(getCapsValueBoolean(caps_getIsSneak)) {
            CatTail.setRotateAngleX(CatTail.getRotateAngleX() + 0.2F);
        }

        if(getCapsValueBoolean(caps_getIsWait) && !getCapsValueBoolean(caps_aimedBow)) {
            CatTail.setRotateAngleX(mh_sin(f2 * 0.6662F) * 0.1F - 4.363323F);
        }

        if(getCapsValueBoolean(caps_aimedBow)) {
            setCapsValue(caps_visible, eyeR, false);
        } else {
            setCapsValue(caps_visible, eyeR, true);
        }

        if(0.0D > (double)(mh_sin(f2 * 0.1F) * 0.3F) + Math.random() * 0.10000000149011612D + 0.18000000715255737D) {
            setCapsValue(caps_visible, eyeL, false);
            setCapsValue(caps_visible, eyeR, false);
        } else {
            setCapsValue(caps_visible, eyeL, true);
            setCapsValue(caps_visible, eyeR, true);
        }
    }
}
