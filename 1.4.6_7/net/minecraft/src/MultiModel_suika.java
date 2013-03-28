package net.minecraft.src;

public class MultiModel_suika extends MultiModel {

    public Modchu_ModelRenderer RibonL;
    public Modchu_ModelRenderer RibonR;
    public Modchu_ModelRenderer CatEL;
    public Modchu_ModelRenderer CatER;
    public Modchu_ModelRenderer Prim;
    public Modchu_ModelRenderer Tuno1;
    public Modchu_ModelRenderer Tuno2;
    public Modchu_ModelRenderer Tuno3;
    public Modchu_ModelRenderer Tuno4;
    public Modchu_ModelRenderer Hyoutan1;
    public Modchu_ModelRenderer Hyoutan2;
    public Modchu_ModelRenderer eyeL;
    public Modchu_ModelRenderer eyeR;
	private boolean initAimedBow;

    public MultiModel_suika()
    {
        this(0.0F);
    }

    public MultiModel_suika(float f)
    {
        this(f, 0.0F);
    }

    public MultiModel_suika(float f, float f1)
    {
    	this(f, f1 , 64, 32);
    }

    public MultiModel_suika(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
    }

	@Override
	public void initModel(float f, float f1) {
		super.initModel(f, f1);
		((Modchu_ModelRenderer) bipedHead).removeChild(ChignonR);
		((Modchu_ModelRenderer) bipedHead).removeChild(ChignonL);
		((Modchu_ModelRenderer) bipedHead).removeChild(ChignonR);
		((Modchu_ModelRenderer) bipedHead).removeChild(Tail);
		((Modchu_ModelRenderer) bipedHead).removeChild(SideTailR);
		((Modchu_ModelRenderer) bipedHead).removeChild(SideTailL);

		ChignonR = new Modchu_ModelRenderer(this, 24, 18);
		ChignonR.addBox(-5F, -7F, 0.2F, 1, 3, 3, f);
		ChignonR.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(ChignonR);
		ChignonL = new Modchu_ModelRenderer(this, 24, 18);
		ChignonL.addBox(4F, -7F, 0.2F, 1, 3, 3, f);
		ChignonL.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(ChignonL);
		ChignonB = new Modchu_ModelRenderer(this, 0, 3);
		ChignonB.addBox(-1F, -7.2F, 3.5F, 2, 3, 2, f);
		ChignonB.setRotationPoint(0.0F, -1.0F, 0.0F);
		bipedHead.addChild(ChignonB);

		Tail = new Modchu_ModelRenderer(this, 46, 19);
		Tail.addBox(-2F, -4.5F, 3F, 4, 11, 2, f);
		Tail.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(Tail);

		SideTailR = new Modchu_ModelRenderer(this, 58, 21);
		SideTailR.addBox(-4.5F, -5F, -3F, 1, 8, 2, f);
		SideTailR.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(SideTailR);
		SideTailL = new Modchu_ModelRenderer(this, 58, 21);
		((Modchu_ModelRenderer) SideTailL).setMirror(true);
		SideTailL.addBox(3.5F, -5F, -3F, 1, 8, 2, f);
		SideTailL.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(SideTailL);

		RibonL = new Modchu_ModelRenderer(this, 52, 10);
		RibonL.setMirror(true);
		RibonL.addBox(-5F, -10F, 3.5F, 4, 4, 2, f);
		RibonL.setRotationPoint(0.0F, -1.0F, 0.0F);
		bipedHead.addChild(RibonL);
		RibonL.rotateAngleX = 6.108653F;
		RibonR = new Modchu_ModelRenderer(this, 52, 10);
		RibonR.setMirror(true);
		RibonR.addBox(1.0F, -10F, 3.5F, 4, 4, 2, f);
		RibonR.setRotationPoint(0.0F, -1.0F, 0.0F);
		bipedHead.addChild(RibonR);
		RibonR.rotateAngleX = 6.108653F;
		CatEL = new Modchu_ModelRenderer(this, 0, 0);
		CatEL.addBox(1.0F, -3F, 6F, 3, 3, 1, f);
		CatEL.setRotationPoint(0.0F, -1.0F, 0.0F);
		bipedHead.addChild(CatEL);
		CatEL.rotateAngleX = -5.934119F;
		CatER = new Modchu_ModelRenderer(this, 0, 4);
		CatER.addBox(-4F, -3F, 6F, 3, 3, 1, f);
		CatER.setRotationPoint(0.0F, -1.0F, 0.0F);
		bipedHead.addChild(CatER);
		CatER.rotateAngleX = -5.934119F;
		Prim = new Modchu_ModelRenderer(this, 24, 16);
		Prim.addBox(-2F, -8.7F, -3.5F, 4, 1, 0, f);
		Prim.setRotationPoint(0.0F, -1.0F, 0.0F);
		bipedHead.addChild(Prim);
		Tuno1 = new Modchu_ModelRenderer(this, 0, 16);
		Tuno1.addBox(-1F, 7F, 1.0F, 2, 4, 2, f);
		Tuno1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(Tuno1);
		Tuno2 = new Modchu_ModelRenderer(this, 60, 16);
		Tuno2.addBox(0.0F, 9F, 6F, 1, 4, 1, f);
		Tuno2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(Tuno2);
		Tuno3 = new Modchu_ModelRenderer(this, 0, 16);
		Tuno3.setMirror(true);
		Tuno3.addBox(-1F, 7F, -3F, 2, 4, 2, f);
		Tuno3.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(Tuno3);
		Tuno4 = new Modchu_ModelRenderer(this, 56, 16);
		Tuno4.addBox(0.0F, 9F, -7F, 1, 4, 1, f);
		Tuno4.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(Tuno4);
		Hyoutan1 = new Modchu_ModelRenderer(this, 0, 23);
		Hyoutan1.addBox(0.0F, 3F, 3F, 3, 3, 3, f);
		Hyoutan1.setRotationPoint(-1.0F, 1.0F, 0.0F);
		bipedLeftArm.addChild(Hyoutan1);
		Hyoutan2 = new Modchu_ModelRenderer(this, 0, 24);
		Hyoutan2.addBox(-1F, 5F, 2.0F, 2, 2, 2, f);
		Hyoutan2.setRotationPoint(-1.0F, 1.0F, 0.0F);
		bipedLeftArm.addChild(Hyoutan2);
		eyeL = new Modchu_ModelRenderer(this, 24, 0);
		eyeL.addBox(-1F, -1F, -4.001F, 2, 2, 1, f + 0.1F);
		eyeL.setRotationPoint(-2.0F, -3.0F, 0.0F);
		bipedHead.addChild(eyeL);
		eyeR = new Modchu_ModelRenderer(this, 26, 0);
		eyeR.addBox(-1F, -1F, -4.001F, 2, 2, 1, f + 0.1F);
		eyeR.setRotationPoint(2.0F, -3.0F, 0.0F);
		bipedHead.addChild(eyeR);
    }

    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);
    	Hyoutan1.rotateAngleX = Hyoutan2.rotateAngleX = Hyoutan1.rotateAngleY = Hyoutan2.rotateAngleY = -0.7853982F;

    	if(getCapsValueBoolean(caps_aimedBow)) {
    		setCapsValue(caps_visible, eyeL, true);
    		setCapsValue(caps_visible, eyeR, false);
    		if (!initAimedBow) {
    			((Modchu_ModelRenderer) bipedLeftArm).removeChild(Hyoutan1);
    			((Modchu_ModelRenderer) bipedLeftArm).removeChild(Hyoutan2);
    			bipedBody.addChild(Hyoutan1);
    			bipedBody.addChild(Hyoutan2);
    			Hyoutan1.setRotationPoint(4.0F, -2.0F, 0.0F);
    			Hyoutan2.setRotationPoint(4.0F, -2.0F, 0.0F);
    			initAimedBow = true;
    		}
    	} else {
    		if (initAimedBow) {
    			initAimedBow = false;
    			((Modchu_ModelRenderer) bipedBody).removeChild(Hyoutan1);
    			((Modchu_ModelRenderer) bipedBody).removeChild(Hyoutan2);
    			bipedLeftArm.addChild(Hyoutan1);
    			bipedLeftArm.addChild(Hyoutan2);
    			Hyoutan1.setRotationPoint(-1.0F, 1.0F, 0.0F);
    			Hyoutan2.setRotationPoint(-1.0F, 1.0F, 0.0F);
    		}
    		if(0.0D > (double)(mh_sin(f2 * 0.1F) * 0.3F) + Math.random() * 0.10000000149011612D + 0.10000000149011612D) {
    			setCapsValue(caps_visible, eyeL, false);
    			setCapsValue(caps_visible, eyeR, false);
    		} else {
    			setCapsValue(caps_visible, eyeL, true);
    			setCapsValue(caps_visible, eyeR, true);
    		}
    	}
    	Prim.setRotateAngleX(((Modchu_ModelRenderer) bipedHead).getRotateAngleX());
    	Tuno1.rotateAngleX = 2.356194F;
    	Tuno2.rotateAngleX = 1.919862F;
    	Tuno3.rotateAngleX = -2.356194F;
    	Tuno4.rotateAngleX = -1.919862F;
    	Tuno1.rotateAngleY = Tuno2.rotateAngleY = Tuno3.rotateAngleY = Tuno4.rotateAngleY = 1.570796F;
    }

    public float getWidth()
    {
    	return 0.8F;
    }

    public void actionInit1() {
    	super.actionInit1();
    	((Modchu_ModelRenderer) bipedLeftArm).removeChild(Hyoutan1);
    	((Modchu_ModelRenderer) bipedLeftArm).removeChild(Hyoutan2);
    	bipedBody.addChild(Hyoutan1);
    	bipedBody.addChild(Hyoutan2);
    	Hyoutan1.setRotationPoint(4.0F, -2.0F, 0.0F);
    	Hyoutan2.setRotationPoint(4.0F, -2.0F, 0.0F);
    }

    public void actionRelease1() {
    	super.actionRelease1();
    	((Modchu_ModelRenderer) bipedBody).removeChild(Hyoutan1);
    	((Modchu_ModelRenderer) bipedBody).removeChild(Hyoutan2);
    	bipedLeftArm.addChild(Hyoutan1);
    	bipedLeftArm.addChild(Hyoutan2);
    	Hyoutan1.setRotationPoint(-1.0F, 1.0F, 0.0F);
    	Hyoutan2.setRotationPoint(-1.0F, 1.0F, 0.0F);
    }
}
