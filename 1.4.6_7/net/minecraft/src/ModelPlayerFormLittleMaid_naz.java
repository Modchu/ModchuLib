package net.minecraft.src;

public class ModelPlayerFormLittleMaid_naz extends ModelPlayerFormLittleMaid
{

    public Modchu_ModelRenderer CatEL;
    public Modchu_ModelRenderer CatER;
    public Modchu_ModelRenderer CatTail;
    public Modchu_ModelRenderer Prim;
    public Modchu_ModelRenderer eyeL;
    public Modchu_ModelRenderer eyeR;

    public ModelPlayerFormLittleMaid_naz()
    {
        this(0.0F);
    }

    public ModelPlayerFormLittleMaid_naz(float f)
    {
        this(f, 0.0F);
    }

    public ModelPlayerFormLittleMaid_naz(float f, float f1)
    {
		// 132deletesuper(f, f1);
//-@-132
		this(f, f1 , 64, 32);
	}

	public ModelPlayerFormLittleMaid_naz(float f, float f1, int i, int j) {
		super(f, f1, i, j);
//@-@132
	}

	@Override
	public void initModel(float f, float f1) {
		super.initModel(f, f1);
		CatEL = new Modchu_ModelRenderer(this, 0, 4);
		CatEL.addBox(2.0F, -11F, -2F, 3, 3, 1, f);
		CatEL.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(CatEL);
		CatER = new Modchu_ModelRenderer(this, 0, 0);
		CatER.addBox(-5F, -11F, -2F, 3, 3, 1, f);
		CatER.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(CatER);
		CatTail = new Modchu_ModelRenderer(this, 0, 16);
		CatTail.addBox(-0.5F, 0.0F, 0.0F, 1, 7, 1, f);
		CatTail.setRotationPoint(0.0F, 4.0F, 2.0F);
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
		CatTail.setRotateAngleX(-4.363323F);
    }

    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
    	super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);
    	CatTail.setRotateAngleX(mh_sin(f * 0.6662F) * 0.5F - 4.363323F);

    	if(getIsWait() && !getaimedBow())
    	{
    		CatTail.setRotateAngleX(mh_sin(f2 * 0.6662F) * 0.1F - 4.363323F);
    	}
    	if(getaimedBow())
    	{
    		eyeL.setVisible(true);
    		eyeR.setVisible(false);
    	} else
    	{
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
    				"eyeR", "eyeL", "CatEL", "CatER", "CatTail",
    				"Prim"
    		};
    		setParts(s, k);
    		setPartsSetFlag(2);
    	}

    	//GUI パーツ表示・非表示反映
    	if(getShowModelFlag() == 0) {
    		boolean b = getGuiShowModel(k);
    		eyeR.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		eyeL.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		CatEL.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		CatER.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		CatTail.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		Prim.setVisible(b);
    		setShowModelFlag(1);
    	}
    }
}
