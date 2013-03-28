
package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class MultiModel_ExtraArms extends MultiModel {

    public Modchu_ModelRenderer Backpack;
    public Modchu_ModelRenderer Antena;
    public Modchu_ModelRenderer Cwave;
    public Modchu_ModelRenderer FirstAidSet;
    public Modchu_ModelRenderer FAstamp;
    public Modchu_ModelRenderer Binoculars;
    public Modchu_ModelRenderer BinocularsL1;
    public Modchu_ModelRenderer BinocularsL2;
    public Modchu_ModelRenderer BinocularsR1;
    public Modchu_ModelRenderer BinocularsR2;
    public Modchu_ModelRenderer Bullet1;
    public Modchu_ModelRenderer Bullet2;
    public Modchu_ModelRenderer Bullet3;
    public Modchu_ModelRenderer eyeL;
    public Modchu_ModelRenderer eyeR;
	private boolean aimedBowBinoculars;

    public MultiModel_ExtraArms()
    {
        this(0.0F);
    }

    public MultiModel_ExtraArms(float f)
    {
        this(f, 0.0F);
    }

    public MultiModel_ExtraArms(float f, float f1)
    {
    	this(f, f1 , 64, 32);
    }

    public MultiModel_ExtraArms(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
    }

	@Override
	public void initModel(float f, float f1) {
		super.initModel(f, f1);
		f1 += 8F;
		Backpack = new Modchu_ModelRenderer(this, 24, 0);
		Backpack.addBox(-2.5F, -3.2F, 2.0F, 5, 5, 3, f);
		Backpack.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBody.addChild(Backpack);
		Antena = new Modchu_ModelRenderer(this, 40, 0);
		Antena.addBox(0.5F, -9.5F, 4.8F, 1, 7, 1, f - 0.2F);
		Antena.setRotationPoint(0.0F, 0.0F, 0.0F);
		Backpack.addChild(Antena);
		Cwave = new Modchu_ModelRenderer(this, 48, 10);
		Cwave.addBox(6.5F, -10.5F, 4.8F, 4, 2, 0, f);
		Cwave.setRotationPoint(0.0F, 0.0F, 0.0F);
		Antena.addChild(Cwave);
		FirstAidSet = new Modchu_ModelRenderer(this, 52, 10);
		FirstAidSet.addBox(2.001F, 4F, 0.0F, 2, 3, 4, f);
		FirstAidSet.setRotationPoint(0.0F, -4.0F, -1F);
		bipedBody.addChild(FirstAidSet);
		FAstamp = new Modchu_ModelRenderer(this, 58, 11);
		FAstamp.addBox(0.5F, 3.5F, -3.002F, 3, 3, 0, f - 1.0F);
		FAstamp.setRotationPoint(0.0F, 0.0F, 0.0F);
		FirstAidSet.addChild(FAstamp);
		Binoculars = new Modchu_ModelRenderer(this, 0, 2);
		Binoculars.addBox(-1.5F, 9F, 2.5F, 3, 2, 1, f);
		Binoculars.setRotationPoint(-0.5F, -2.0F, -4.0F);
		bipedLeftArm.addChild(Binoculars);
		BinocularsL1 = new Modchu_ModelRenderer(this, 0, 16);
		BinocularsL1.addBox(0.0F, 8F, 2.0F, 2, 2, 2, f - 0.5F);
		BinocularsL1.setRotationPoint(-2.0F, 0.0F, 0.5F);
		Binoculars.addChild(BinocularsL1);
		BinocularsL2 = new Modchu_ModelRenderer(this, 0, 0);
		BinocularsL2.addBox(0.0F, 9.5F, 2.0F, 2, 3, 2, f);
		BinocularsL2.setRotationPoint(-2.0F, 0.0F, 0.5F);
		Binoculars.addChild(BinocularsL2);
		BinocularsR1 = new Modchu_ModelRenderer(this, 0, 16);
		BinocularsR1.addBox(1.5F, 8F, 1.0F, 2, 2, 2, f - 0.3F);
		BinocularsR1.setRotationPoint(-2.0F, 0.0F, 0.5F);
		Binoculars.addChild(BinocularsR1);
		BinocularsR2 = new Modchu_ModelRenderer(this, 0, 0);
		BinocularsR2.addBox(1.5F, 9.5F, 1.0F, 2, 3, 2, f);
		BinocularsR2.setRotationPoint(-2.0F, 0.0F, 0.5F);
		Binoculars.addChild(BinocularsR2);
		Bullet1 = new Modchu_ModelRenderer(this, 0, 6);
		Bullet1.addBox(0.0F, -2F, -2F, 3, 1, 1, f);
		Bullet1.setRotationPoint(0.0F, -3.0F, 0.0F);
		bipedBody.addChild(Bullet1);
		Bullet2 = new Modchu_ModelRenderer(this, 0, 6);
		Bullet2.addBox(0.0F, -1F, -3F, 3, 1, 1, f);
		Bullet2.setRotationPoint(0.0F, -3.0F, 0.0F);
		bipedBody.addChild(Bullet2);
		Bullet3 = new Modchu_ModelRenderer(this, 0, 6);
		Bullet3.addBox(0.0F, 0.0F, -4F, 3, 1, 1, f);
		Bullet3.setRotationPoint(0.0F, -3.0F, 0.0F);
		bipedBody.addChild(Bullet3);
		((Modchu_ModelRenderer) bipedHead).removeChild(eyeR);
		((Modchu_ModelRenderer) bipedHead).removeChild(eyeL);
		eyeL = new Modchu_ModelRenderer(this, 32, 19);
		eyeL.addPlate(-4.0F, -5.0F, -4.001F, 4, 4, 0, f);
		eyeL.setRotationPointLM(0.0F, 0.0F, 0.0F);
		eyeR = new Modchu_ModelRenderer(this, 42, 19);
		eyeR.addPlate(0.0F, -5.0F, -4.001F, 4, 4, 0, f);
		eyeR.setRotationPointLM(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(eyeR);
		bipedHead.addChild(eyeL);
		((Modchu_ModelRenderer) bipedHead).removeChild(bipedHeadwear);
		((Modchu_ModelRenderer) bipedHead).removeChild(ChignonB);
    }

    @Override
    public void setLivingAnimationsLM(EntityLiving entityliving, float f, float f1, float f2) {
    	super.setLivingAnimationsLM(entityliving, f, f1, f2);
    	float f3 = (float)entityliving.ticksExisted + f2 + getCapsValueFloat(caps_entityIdFactor);
    	// –Úƒpƒ`
    	if( 0 > MathHelper.sin(f3 * 0.05F) + MathHelper.sin(f3 * 0.13F) + MathHelper.sin(f3 * 0.7F) + 2.55F) {
    		setCapsValue(caps_visible, eyeR, false);
    		setCapsValue(caps_visible, eyeL, false);
    	} else {
    		setCapsValue(caps_visible, eyeR, true);
    		setCapsValue(caps_visible, eyeL, true);
    	}
    }

    @Override
    public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);
    	Cwave.setVisible(false);

    	if(getCapsValueFloat(caps_onGround) > -9990F && !getCapsValueBoolean(caps_aimedBow))
    	{
    		Antena.rotationPointY = 4F;
    	}
    	Skirt.rotationPointZ = 0.0F;
    	if (getCapsValueBoolean(caps_getIsSneak)) {
    		Skirt.rotateAngleX += 0.3F;
    	}
    	if (getCapsValueBoolean(caps_getIsWait))
    	{
    		Antena.rotationPointY = 0.0F;
    		if (0.0D > (double)(mh_sin(f2 * 0.1F) * 0.3F) + Math.random() * 0.15000000596046448D + 0.10000000149011612D)
    		{
    			Cwave.rotationPointX = (float)(int)(Math.random() * 4D) + 0.0F;
    			Cwave.setVisible(true);
    		}else
    		{
    			Cwave.setVisible(false);
    		}
    	}
    	if(getCapsValueBoolean(caps_aimedBow) || getCapsValueBoolean(caps_getIsWait))
    	{
    		if (!aimedBowBinoculars)
    		{
    			aimedBowBinoculars = true;
    			((Modchu_ModelRenderer) bipedLeftArm).removeChild(Binoculars);
    			bipedLeftLeg.addChild(Binoculars);
    			if(getCapsValueBoolean(caps_aimedBow))
    			{
    				Binoculars.setRotationPoint(0.0F, -10.0F, 0.0F);
    			} else {
    				Binoculars.setRotationPoint(0.0F, -10.0F, -2.0F);
    			}
    			float f10 = 2.3F;
    			Binoculars.rotateAngleX = f10;
    			Binoculars.rotateAngleY = f10 - 0.8F;
    			Binoculars.rotateAngleZ = f10;
    		}
    	} else {
    		if (aimedBowBinoculars) {
    			aimedBowBinoculars = false;
    			((Modchu_ModelRenderer) bipedLeftLeg).removeChild(Binoculars);
    			bipedLeftArm.addChild(Binoculars);
    			Binoculars.setRotationPoint(-0.5F, -2.0F, -4.0F);
    			Binoculars.setRotateAngleX(0.0F);
    			Binoculars.setRotateAngleY(0.0F);
    			Binoculars.setRotateAngleZ(0.0F);
    		}
    	}
    	if(getCapsValueBoolean(caps_aimedBow))
    	{
    		setCapsValue(caps_visible, eyeL, true);
    		setCapsValue(caps_visible, eyeR, false);
    		BinocularsL1.setRotateAngleX(BinocularsL2.setRotateAngleX(0.0F));
    		BinocularsR1.setRotateAngleX(BinocularsR2.setRotateAngleX(0.0F));
    		BinocularsL1.setRotateAngleY(BinocularsL2.setRotateAngleY(0.0F));
    		BinocularsR1.setRotateAngleY(BinocularsR2.setRotateAngleY(0.0F));
    		BinocularsL1.setRotateAngleZ(BinocularsL2.setRotateAngleZ(0.0F));
    		BinocularsR1.setRotateAngleZ(BinocularsR2.setRotateAngleZ(0.0F));
    	}
    	FirstAidSet.rotateAngleX = 0.17453F;
    	FAstamp.rotateAngleY = -1.5708F;
    	FAstamp.rotateAngleZ = 0.0F;
    	Cwave.rotateAngleZ = -0.2618F;
    	Bullet1.rotateAngleX = Bullet2.rotateAngleX = Bullet3.rotateAngleX = 0.7854F;
    	Bullet1.rotateAngleY = Bullet2.rotateAngleY = Bullet3.rotateAngleY = 0.0F;
    	Bullet1.rotateAngleZ = Bullet2.rotateAngleZ = Bullet3.rotateAngleZ = 0.5236F;
    }

    @Override
    public void defaultPartsSettingBefore() {
    	super.defaultPartsSettingBefore();
    	String[] s = {
    			"bipedHeadwear", "d"
    	};
    	showPartsHideListadd(s);
    	String[] s1 = {
    			"FirstAidSet" ,"Binoculars", "BinocularsL1", "BinocularsL2", "BinocularsR1",
    			"BinocularsR2", "BinocularsR1", "BinocularsR2"
    	};
    	String[] s2 = {
    			"FA_Set" ,"Bino", "BinoL1", "Bino_L2", "Bino_R1",
    			"Bino_R2", "Bino_R1", "Bino_R2"
    	};
    	addShowPartsReneme(s1, s2);
    }

    @Override
    public float getWidth()
    {
    	return 0.8F;
    }
}
