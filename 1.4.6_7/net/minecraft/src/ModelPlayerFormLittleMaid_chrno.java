package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class ModelPlayerFormLittleMaid_chrno extends ModelPlayerFormLittleMaid
{

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

    public ModelPlayerFormLittleMaid_chrno()
    {
    	this(0.0F);
    }

    public ModelPlayerFormLittleMaid_chrno(float f)
    {
    	this(f, 0.0F);
    }

    public ModelPlayerFormLittleMaid_chrno(float f, float f1)
    {
    	// 132deletesuper(f, f1);
//-@-132
    	this(f, f1 , 64, 32);
    }

    public ModelPlayerFormLittleMaid_chrno(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
//@-@132
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

    	Rightarm1.setVisible(false);
    	Rightarm2.setVisible(false);
    	Leftarm1.setVisible(false);
    	Leftarm2.setVisible(false);
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
    	Rightarm1.setVisible(false);
    	Rightarm2.setVisible(false);
    	Leftarm1.setVisible(false);
    	Leftarm2.setVisible(false);
    }

    @Override
    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
    	super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);
    	if(31.41593F >= mh_abs(f2))
    	{
    		f2 %= 31.41593F;
    	}
    	Icewing1.setRotateAngleX(Icewing2.setRotateAngleX(Icewing3.setRotateAngleX(mh_sin(f * f * 0.6662F) * 0.15F)));
    	Icewing4.setRotateAngleX(Icewing5.setRotateAngleX(Icewing6.setRotateAngleX(mh_sin(f * f * 0.6662F) * 0.15F)));
    	if(getOnGround() > -9990F && !getaimedBow())
    	{
    		Icewing1.setRotateAngleY(Icewing2.setRotateAngleY(Icewing3.setRotateAngleY(((Modchu_ModelRenderer) bipedBody).getRotateAngleY())));
    		Icewing4.setRotateAngleY(Icewing5.setRotateAngleY(Icewing6.setRotateAngleY(((Modchu_ModelRenderer) bipedBody).getRotateAngleY())));
    	}
    	if(getIsWait() && !getaimedBow())
    	{
    		if (!initWait) {
    			initWait = true;
    			Rightarm1.isHidden = false;
    			Rightarm2.isHidden = false;
    			Leftarm1.isHidden = false;
    			Leftarm2.isHidden = false;
    			Leftarm1.setVisible(true);
    			Leftarm2.setVisible(true);
    			Rightarm1.setVisible(true);
    			Rightarm2.setVisible(true);
    			setVisible(bipedRightArm, false);
    			setVisible(bipedLeftArm, false);
    			((Modchu_ModelRenderer) bipedRightArm).removeChild(Arms[0]);
    			((Modchu_ModelRenderer) bipedRightArm).removeChild(Arms[2]);
    			((Modchu_ModelRenderer) bipedLeftArm).removeChild(Arms[1]);
    			((Modchu_ModelRenderer) bipedLeftArm).removeChild(Arms[3]);
    			Rightarm2.addChild(Arms[0]);
    			Rightarm2.addChild(Arms[2]);
    			Leftarm2.addChild(Arms[1]);
    			Leftarm2.addChild(Arms[3]);
    			Arms[0].setRotationPointLM(-5.0F, 0.0F, 0F);
    		}
    		Icewing3.setRotateAngleX(Icewing6.setRotateAngleX(mh_sin(f2 * f2 * 0.6662F) * 0.2F));
    		((Modchu_ModelRenderer) bipedRightArm).setRotateAngleX(0.0F);
    		((Modchu_ModelRenderer) bipedRightArm).setRotateAngleY(0.0F);
    		((Modchu_ModelRenderer) bipedRightArm).setRotateAngleZ(0.0F);
    		Rightarm1.rotationPointY = Rightarm2.rotationPointY =
    				Leftarm1.rotationPointY = Leftarm2.rotationPointY = mh_sin(f2 * 0.05F) * 0.2F - 4.0F;
    	} else {
    		if (initWait) {
    			initWait = false;
    			Leftarm1.setVisible(false);
    			Leftarm2.setVisible(false);
    			Rightarm1.setVisible(false);
    			Rightarm2.setVisible(false);
    			setVisible(bipedRightArm, true);
    			setVisible(bipedLeftArm, true);
    			Rightarm2.removeChild(Arms[0]);
    			Rightarm2.removeChild(Arms[2]);
    			Leftarm2.removeChild(Arms[1]);
    			Leftarm2.removeChild(Arms[3]);
    			bipedRightArm.addChild(Arms[0]);
    			bipedRightArm.addChild(Arms[2]);
    			bipedLeftArm.addChild(Arms[1]);
    			bipedLeftArm.addChild(Arms[3]);
    			Arms[0].setRotationPointLM(0.5F, 6.5F, 0F);
    		}
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
    	//前回の項目最後から7つ上書き設定
    	overridePartsNumber = 7;
    	int k = getPartsNumber() - overridePartsNumber;
    	if(k < 0) k = 0;
    	if(getPartsSetFlag() == 1) {
    		String s[] = {
    				"eyeR", "eyeL", "RibonL", "RibonR", "CatEL",
    				"CatER", "Prim2", "Icewing1", "Icewing2", "Icewing3",
    				"Icewing4", "Icewing5", "Icewing6"
    		};
    		setParts(s, k);
    		setPartsSetFlag(2);
    	}

    	//GUI パーツ表示・非表示反映
    	if(getShowModelFlag() == 0) {
    		boolean b = getGuiShowModel(2);
    		Rightarm1.setVisible(b);
    		Rightarm2.setVisible(b);
    		b = getGuiShowModel(3);
    		Leftarm1.setVisible(b);
    		Leftarm2.setVisible(b);
    		b = getGuiShowModel(k);
    		eyeR.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		eyeL.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		RibonL.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		RibonR.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		CatEL.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		CatER.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		Prim.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		Icewing1.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		Icewing2.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		Icewing3.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		Icewing4.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		Icewing5.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		Icewing6.setVisible(b);
    		setShowModelFlag(1);
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
		Leftarm1.setVisible(true);
		Leftarm2.setVisible(true);
		Rightarm1.setVisible(true);
		Rightarm2.setVisible(true);
		setVisible(bipedRightArm, false);
		setVisible(bipedLeftArm, false);
		((Modchu_ModelRenderer) bipedRightArm).removeChild(Arms[0]);
		((Modchu_ModelRenderer) bipedRightArm).removeChild(Arms[2]);
		((Modchu_ModelRenderer) bipedLeftArm).removeChild(Arms[1]);
		((Modchu_ModelRenderer) bipedLeftArm).removeChild(Arms[3]);
		Rightarm2.removeChild(Arms[0]);
		Rightarm2.removeChild(Arms[2]);
		Leftarm2.removeChild(Arms[1]);
		Leftarm2.removeChild(Arms[3]);
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
		Leftarm1.setVisible(false);
		Leftarm2.setVisible(false);
		Rightarm1.setVisible(false);
		Rightarm2.setVisible(false);
		setVisible(bipedRightArm, true);
		setVisible(bipedLeftArm, true);
	}

    public float getWidth()
    {
    	return 0.8F;
    }

    public ModelRenderer getBipedRightArm() {
    	if (getShortcutKeysAction()
    			&& getRunActionNumber() == 0
    			| getRunActionNumber() == 1) {
    		if (getHandedness() == 0) return rightArm;
    		return leftArm;
    	}
    	else {
    		if(getIsWait() && !getaimedBow())
    		{
    			if (getHandedness() == 0) return Rightarm1;
    			return Leftarm1;
    		} else {
    			if (getHandedness() == 0) return bipedRightArm;
    			return bipedLeftArm;
    		}
    	}
    }
}
