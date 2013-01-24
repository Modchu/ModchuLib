package net.minecraft.src;

public class ModelPlayerFormLittleMaid_taremimi extends ModelPlayerFormLittleMaid
{

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

    public ModelPlayerFormLittleMaid_taremimi()
    {
        this(0.0F);
    }

    public ModelPlayerFormLittleMaid_taremimi(float f)
    {
        this(f, 0.0F);
    }

    public ModelPlayerFormLittleMaid_taremimi(float f, float f1)
    {
		// 132deletesuper(f, f1);
//-@-132
		this(f, f1 , 64, 32);
	}

	public ModelPlayerFormLittleMaid_taremimi(float f, float f1, int i, int j) {
		super(f, f1, i, j);
//@-@132
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
    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
    	super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);
    	Wansippo1.setRotationPointZ(Wansippo2.setRotationPointZ(Wansippo3.setRotationPointZ(Wansippo4.setRotationPointZ(2F))));
    	Wansippo1.setRotateAngleX(Wansippo2.setRotateAngleX(Wansippo3.setRotateAngleX(Wansippo4.setRotateAngleX(-0.275F))));
    	Wansippo1.setRotateAngleY(Wansippo2.setRotateAngleY(Wansippo3.setRotateAngleY(Wansippo4.setRotateAngleY(mh_cos(f2 * 0.2F) * 0.05F))));
    	Wansippo1.setRotateAngleZ(Wansippo2.setRotateAngleZ(Wansippo3.setRotateAngleZ(Wansippo4.setRotateAngleZ(mh_sin(f2 * 0.2F) * 0.5F))));
    	if(getIsRiding())
    	{
    		Wansippo1.setRotateAngleX(Wansippo2.setRotateAngleX(Wansippo3.setRotateAngleX(Wansippo4.setRotateAngleX(-0.1F))));
    	}
    	if(getIsWait() && !getaimedBow())
    	{
    		Wansippo1.setRotateAngleZ(Wansippo2.setRotateAngleZ(Wansippo3.setRotateAngleZ(Wansippo4.setRotateAngleZ(mh_sin(f2 * 0.5F) * 1.0F))));
    		Wansippo1.setRotateAngleY(Wansippo2.setRotateAngleY(Wansippo3.setRotateAngleY(Wansippo4.setRotateAngleY(mh_cos(f2 * 0.5F) * 1.0F))));
    	}
    	if (getaimedBow())
    	{
    		eyeL.setVisible(true);
    		eyeR.setVisible(false);
    	} else {
    		if(0.0D > (double)(mh_sin(f2 * 0.1F) * 0.3F) + Math.random() * 0.10000000149011612D + 0.18000000715255737D)
    		{
    			eyeL.setVisible(false);
    			eyeR.setVisible(false);
    		} else
    		{
    			eyeL.setVisible(true);
    			eyeR.setVisible(true);
    		}
    	}
    	DogER.rotateAngleX = DogEL.rotateAngleX = mh_sin(f2 * 0.05F) * 0.06F + 0.2F;
    }

    @Override
    public void settingShowParts() {
    	super.settingShowParts();
    	//GUI パーツ表示・非表示初期設定
    	//前回の項目最後[partsNumber]から設定
    	overridePartsNumber = 0;
    	int k = getPartsNumber();
    	if(k < 0) k = 0;
    	if(getPartsSetFlag() == 1) {
    		String s[] = {
    				"WTail", "Prim", "DogEL", "DogER", "Wansippo1",
    				"Wansippo2", "Wansippo3", "Wansippo4"
    		};
    		setParts(s, k);
    		setPartsSetFlag(2);
    	}

    	//GUI パーツ表示・非表示反映
    	if(getShowModelFlag() == 0) {
    		boolean b = getGuiShowModel(k);
    		WTail.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		Prim.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		DogEL.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		DogER.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		Wansippo1.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		Wansippo2.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		Wansippo3.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		Wansippo4.setVisible(b);
    		setShowModelFlag(1);
    	}
    }
}
