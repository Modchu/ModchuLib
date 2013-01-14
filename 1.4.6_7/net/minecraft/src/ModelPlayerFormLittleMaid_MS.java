package net.minecraft.src;

public class ModelPlayerFormLittleMaid_MS extends ModelPlayerFormLittleMaid_SR2
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

    public ModelPlayerFormLittleMaid_MS()
    {
        this(0.0F);
    }

    public ModelPlayerFormLittleMaid_MS(float f)
    {
        this(f, 0.0F);
    }

    public ModelPlayerFormLittleMaid_MS(float f, float f1)
    {
		// 132deletesuper(f, f1);
//-@-132
		this(f, f1 , 64, 64);
	}

	public ModelPlayerFormLittleMaid_MS(float f, float f1, int i, int j) {
		super(f, f1, i, j);
//@-@132
	}

	@Override
	public void initModel(float f, float f1) {
		textureWidth = 64;
		textureHeight = 64;
		super.initModel(f, f1);
		((Modchu_ModelRenderer) bipedBody).removeChild(Skirt);
		Skirt = new Modchu_ModelRenderer(this, 0, 16);
		Skirt.addBoxLM(-3.5F, -2F, -3F, 7, 7, 6, f);
		Skirt.setRotationPointLM(0.0F, 7F + f1, 0.0F);
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
		Cheek_R.setRotationPointLM(0.0F, -7F + f1, 0.0F);
		Cheek_L = new Modchu_ModelRenderer(this, 32, 19);
		Cheek_L.addPlate(0.5F, -4.5F, -4.002F, 4, 4, 0, f);
		Cheek_L.setRotationPointLM(0.0F, -7F + f1, 0.0F);
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
		Tail.setVisible(false);
		SideTailR.setVisible(false);
		SideTailL.setVisible(false);
		ChignonR.setVisible(false);
		ChignonL.setVisible(false);
		ChignonB.setVisible(false);
		Goggles1.setVisible(false);
		Goggles2.setVisible(false);
		Goggles3.setVisible(false);
		GogglesR.setVisible(false);
		GogglesL.setVisible(false);
		Goggles1A.setVisible(false);
		Goggles2A.setVisible(false);
		Goggles3A.setVisible(false);
		GogglesRA.setVisible(false);
		GogglesLA.setVisible(false);
	}

    public void setLivingAnimationsLM(EntityLiving entityliving, float f, float f1, float f2)
    {
        super.setLivingAnimationsLM(entityliving, f, f1, f2);

		if ((entityliving instanceof EntityPlayer)
				&& !getaimedBow())
		{
			EntityPlayer entityplayer = (EntityPlayer) entityliving;
			float f3 = (float)entityplayer.ticksExisted + f2 + ((float)entityplayer.entityId * 70);

			ItemStack itemstack2 = entityplayer.inventory.getCurrentItem();
			boolean flag = false;
			if (itemstack2 != null) {
				Item item = itemstack2.getItem();
				if (item == Item.sugar) {
					flag = true;
				}
			}
			if (flag) {
				f3 *= 8F;
				float f6 = -0.2F;
				Cheek_R.setVisible(true);
				Cheek_L.setVisible(true);
			}
			else
			{
				float f7 = (1.0F - (float)entityplayer.health / 20F) * 0.5F;
				Cheek_R.setVisible(false);
				Cheek_L.setVisible(false);
			}
		}

    }

    @Override
    public void setRotationAnglesLM(float f, float f1, float ticksExisted, float pheadYaw, float pheadPitch, float f5, Entity entity)
    {
    	super.setRotationAnglesLM(f, f1, ticksExisted, pheadYaw, pheadPitch, f5, entity);
    	Goggles1A.setVisible(false);
    	Goggles2A.setVisible(false);
    	Goggles3A.setVisible(false);
    	GogglesRA.setVisible(false);
    	GogglesLA.setVisible(false);
    	if (getaimedBow()) {
    		eyeR.setVisible(false);
    		eyeL.setVisible(true);
    		Goggles1.setVisible(false);
    		Goggles2.setVisible(false);
    		Goggles3.setVisible(false);
    		GogglesR.setVisible(false);
    		GogglesL.setVisible(false);
    		Goggles1A.setVisible(true);
    		Goggles2A.setVisible(true);
    		Goggles3A.setVisible(true);
    		GogglesRA.setVisible(true);
    		GogglesLA.setVisible(true);
    	} else {
    		Goggles1.setVisible(true);
    		Goggles2.setVisible(true);
    		Goggles3.setVisible(true);
    		GogglesR.setVisible(true);
    		GogglesL.setVisible(true);
    		Goggles1A.setVisible(false);
    		Goggles2A.setVisible(false);
    		Goggles3A.setVisible(false);
    		GogglesRA.setVisible(false);
    		GogglesLA.setVisible(false);
    	}
    	Skirt.rotationPointY -= 2.0F;
    	Skirt.rotationPointZ = 0.0F;
    	if (getIsSneak()) {
    		Skirt.rotateAngleX += 0.3F;
    	}
    }

    @Override
    public void settingShowParts() {
    	super.settingShowParts();
    	//GUI パーツ表示・非表示初期設定
    	//前回の項目最後から8個上書きして設定
    	overridePartsNumber = 8;
    	int k = getPartsNumber() - overridePartsNumber;
    	if(k < 0) k = 0;
    	if(getPartsSetFlag() == 2) {
    		String s[] = {
    				"eyeR", "eyeL", "Cheek"
    		};
    		setParts(s, k);
    		//Cheek Default off
    		setGuiShowModel(k + 2, false);
    		setPartsSetFlag(3);
    	}

    	//GUI パーツ表示・非表示反映
    	if(getShowModelFlag() == 1) {
    		boolean b = getGuiShowModel(k);
    		eyeR.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		eyeL.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		Cheek_R.setVisible(b);
    		Cheek_L.setVisible(b);
    		Tail.setVisible(false);
    		SideTailR.setVisible(false);
    		SideTailL.setVisible(false);
    		ChignonR.setVisible(false);
    		ChignonL.setVisible(false);
    		ChignonB.setVisible(false);
    		setShowModelFlag(2);
    	}
    }
}
