package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class MultiModel_Tenshi extends MultiModel_SR2 {

	public Modchu_ModelRenderer Skirt1;
	public Modchu_ModelRenderer Skirt2;
	public Modchu_ModelRenderer Skirt3;
	public Modchu_ModelRenderer Skirt4;
	public Modchu_ModelRenderer Skirt5;
	public Modchu_ModelRenderer Skirt6;
	public Modchu_ModelRenderer Skirt7;
	public Modchu_ModelRenderer Skirt8;
	public Modchu_ModelRenderer Skirt9;
	public Modchu_ModelRenderer Skirt10;
	public Modchu_ModelRenderer Skirt11;
	public Modchu_ModelRenderer Skirt12;
	public Modchu_ModelRenderer Skirt13;
	public Modchu_ModelRenderer Skirt14;
	public Modchu_ModelRenderer Skirt15;
	public Modchu_ModelRenderer Skirt16;
	public Modchu_ModelRenderer Skirt21;
	public Modchu_ModelRenderer Skirt22;
	public Modchu_ModelRenderer Skirt23;
	public Modchu_ModelRenderer Skirt24;
	public Modchu_ModelRenderer Skirt25;
	public Modchu_ModelRenderer Skirt26;
	public Modchu_ModelRenderer Skirt27;
	public Modchu_ModelRenderer Skirt28;
	public Modchu_ModelRenderer Skirt29;
	public Modchu_ModelRenderer Skirt210;
	public Modchu_ModelRenderer Skirt211;
	public Modchu_ModelRenderer Skirt212;
	public Modchu_ModelRenderer Skirt213;
	public Modchu_ModelRenderer Skirt214;
	public Modchu_ModelRenderer Skirt215;
	public Modchu_ModelRenderer Skirt216;
	public Modchu_ModelRenderer HipR;
	public Modchu_ModelRenderer HipL;
	public Modchu_ModelRenderer Neck;
	public Modchu_ModelRenderer Ribon4;
	public Modchu_ModelRenderer Ribon5;
	public Modchu_ModelRenderer Ribon6;
	public Modchu_ModelRenderer ColorPlate1;
	public Modchu_ModelRenderer ColorPlate2;
	public Modchu_ModelRenderer ColorPlate3;
	public Modchu_ModelRenderer ColorPlate4;
	public Modchu_ModelRenderer ColorPlate5;
	public Modchu_ModelRenderer ColorPlate6;
	public Modchu_ModelRenderer ColorPlate7;
	public Modchu_ModelRenderer ColorPlate8;
	public Modchu_ModelRenderer ColorPlate9;
	public Modchu_ModelRenderer ColorPlate10;
	public Modchu_ModelRenderer ColorPlate11;
	public Modchu_ModelRenderer ColorPlate12;
	public Modchu_ModelRenderer ColorPlate13;
	public Modchu_ModelRenderer ColorPlate14;
	public Modchu_ModelRenderer ColorPlate15;
	public Modchu_ModelRenderer ColorPlate16;
	public Modchu_ModelRenderer Hat1;
	public Modchu_ModelRenderer Hat2;
	public Modchu_ModelRenderer Hat3;
	public Modchu_ModelRenderer Hat4;
	public Modchu_ModelRenderer Hat5;
	public Modchu_ModelRenderer Hat6;
	public Modchu_ModelRenderer Hat7;
	public Modchu_ModelRenderer Hat8;
	public Modchu_ModelRenderer Hat9;
	public Modchu_ModelRenderer Hat10;
	public Modchu_ModelRenderer Hat11;
	public Modchu_ModelRenderer Hat12;
	public Modchu_ModelRenderer Hat13;
	public Modchu_ModelRenderer Hat14;
	public Modchu_ModelRenderer Peach1;
	public Modchu_ModelRenderer Leaf1;
	public Modchu_ModelRenderer Leaf2;
	public Modchu_ModelRenderer Patch1;
	public Modchu_ModelRenderer Patch2;
	public Modchu_ModelRenderer Patch3;
	public Modchu_ModelRenderer Calar1;
	public Modchu_ModelRenderer Calar2;
	public Modchu_ModelRenderer Line1;
	public Modchu_ModelRenderer Line2;
	public Modchu_ModelRenderer Line3;
	public Modchu_ModelRenderer Line4;

	// armor only
	public Modchu_ModelRenderer PlateR1;
	public Modchu_ModelRenderer PlateR2;
	public Modchu_ModelRenderer PlateR3;
	public Modchu_ModelRenderer PlateR4;
	public Modchu_ModelRenderer PlateR5;
	public Modchu_ModelRenderer PlateR6;
	public Modchu_ModelRenderer PlateL1;
	public Modchu_ModelRenderer PlateL2;
	public Modchu_ModelRenderer PlateL3;
	public Modchu_ModelRenderer PlateL4;
	public Modchu_ModelRenderer PlateL5;
	public Modchu_ModelRenderer PlateL6;

	private float x1;
	private float y1;
	private float z1;

	public MultiModel_Tenshi()
	{
		this(0.0F);
	}

	public MultiModel_Tenshi(float f)
	{
		this(f, 0.0F);
	}

	public MultiModel_Tenshi(float f, float f1)
	{
		this(f, f1 , 64, 64);
	}

	public MultiModel_Tenshi(float f, float f1, int i, int j) {
		super(f, f1, i, j);
    	HeadMount.setRotationPoint(0.0F, 1.0F, 0.0F);
	}

	@Override
	public void initModel(float f, float f1) {
		textureHeight=64;
		textureWidth=64;
		f1 += 8F;
		bipedHead = new Modchu_ModelRenderer(this, 0, 1);
		bipedHead.addBox(-4F, -7F, -4F, 8, 7, 8, f);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHeadwear = new Modchu_ModelRenderer(this, 24, -1);
		bipedHeadwear.addBox(-4F, 0.0F, 0.0F, 8, 5, 4, f);
		bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(bipedHeadwear);
		bipedBody = new Modchu_ModelRenderer(this, 32, 8);
		bipedBody.addBox(-3.0F, -3.5F, -2.0F, 6, 7, 4, f);
		bipedBody.setRotationPoint(0.0F, -3.0F, 0.0F);
		bipedRightArm = new Modchu_ModelRenderer(this, 48, 0);
		bipedRightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
		bipedRightArm.setRotationPoint(-3.0F, 4.5F, 0.0F);
		bipedBody.addChild(bipedRightArm);
		bipedLeftArm = new Modchu_ModelRenderer(this, 56, 0);
		bipedLeftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f);
		bipedLeftArm.setRotationPoint(3.0F, 4.5F, 0.0F);
		bipedBody.addChild(bipedLeftArm);
		bipedRightLeg = new Modchu_ModelRenderer(this, 32, 19);
		bipedRightLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);
		bipedRightLeg.setRotationPoint(-1.5F, 15F, 0.0F);
		bipedBody.addChild(bipedRightLeg);
		bipedLeftLeg = new Modchu_ModelRenderer(this, 32, 19);
		bipedLeftLeg.mirror = true;
		bipedLeftLeg.addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, f);
		bipedLeftLeg.setRotationPoint(1.5F, 15F, 0.0F);
		bipedBody.addChild(bipedLeftLeg);
		Skirt = new Modchu_ModelRenderer(this, 0, 16);
		Skirt.setRotationPoint(0.0F, 2.0F, 0.0F);
		bipedBody.addChild(Skirt);

		Patch3 = new Modchu_ModelRenderer(this, 31, 16);
		Patch3.addPlate(-0.0F, 0F, 0F, 1, 5, 0,f);
		Patch3.setRotationPointLM(-0.5F,-3.0F,-2.002F);
		bipedBody.addChild(Patch3);

		Calar1 = new Modchu_ModelRenderer(this, 32, 8);
		Calar1.addPlate(-0.0F, -1.2F, 0F, 1, 2, 0,f);
		Calar1.setRotationPointLM(0F,0.5F,-2.001F);
		Calar1.setRotateAngleDeg(0F,0F,64F);
		bipedBody.addChild(Calar1);

		Calar2 = new Modchu_ModelRenderer(this, 32, 8);
		Calar2.addPlate(-0.0F, -0.8F, 0F, 1, 2, 0,f);
		Calar2.setRotationPointLM(0F,0.5F,-2.001F);
		Calar2.setRotateAngleDeg(0F,0F,116F);
		bipedBody.addChild(Calar2);

		HipR = new Modchu_ModelRenderer(this, 57, 28);
		HipR.addBox(-1.5F, -0F, -0F, 3, 2, 2, f);
		HipR.setRotationPointLM(0.6F,-0.1F, 2.0F);
		HipR.setRotateAngleDeg(-150F,0F,0F);
		bipedRightLeg.addChild(HipR);

		HipL = new Modchu_ModelRenderer(this, 57, 24);
		HipL.mirror=true;
		HipL.addBox(-1.5F, -0F, -0F, 3, 2, 2, f);
		HipL.setRotationPointLM(-0.6F, -0.1F, 2.0F);
		HipL.setRotateAngleDeg(-150F,0F,0F);
		bipedLeftLeg.addChild(HipL);

		Patch1 = new Modchu_ModelRenderer(this,22 ,18);
		Patch1.addBox(-1.999F, 2.0F, -0.999F, 2, 3, 2, f);
		Patch1.setRotationPointLM(1F,1F,0.0F);
		bipedRightArm.addChild(Patch1);

		Patch2 = new Modchu_ModelRenderer(this,22 ,18);
		Patch2.addBox(-0.001F, 2.0F, -0.999F, 2, 3, 2, f);
		Patch2.setRotationPointLM(-1F,1F,0.0F);
		bipedLeftArm.addChild(Patch2);

		eyeR = new Modchu_ModelRenderer(this, 32, 19);
		eyeR.addPlate(-4.0F, -5.0F, -4.001F, 4, 4, 0, f);
		eyeR.setRotationPointLM(0.0F, 0.0F, 0.0F);
		eyeL = new Modchu_ModelRenderer(this, 42, 19);
		eyeL.addPlate(0.0F, -5.0F, -4.001F, 4, 4, 0, f);
		eyeL.setRotationPointLM(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(eyeR);
		bipedHead.addChild(eyeL);

		Skirt1 = new Modchu_ModelRenderer(this, 0, 34, Skirt);
		Skirt1.addPlate(-0.8F, -6F, 0F, 22, 6, 0,f);
		Skirt1.setRotationPointLM(0F,-5.5F,0F);

		Skirt2 = new Modchu_ModelRenderer(this, 0, 28, Skirt);
		Skirt2.addPlate(-0.8F, 0F, 0F, 22, 6, 0,f);
		Skirt2.setRotationPointLM(0F,-5.5F,0F);

		Skirt3 = new Modchu_ModelRenderer(this, 0, 34, Skirt);
		Skirt3.addPlate(0F, -6F, 0F, 22, 6, 0,f);
		Skirt3.setRotationPointLM(0F,-6F,0F);

		Skirt4 = new Modchu_ModelRenderer(this, 0, 28, Skirt);
		Skirt4.addPlate(0F, 0F, 0F, 22, 6, 0,f);
		Skirt4.setRotationPointLM(0F,-6F,0F);

		Skirt5 = new Modchu_ModelRenderer(this, 0, 34, Skirt);
		Skirt5.addPlate(0F, -6F, 0F, 22, 6, 0,f);
		Skirt5.setRotationPointLM(0F,-6F,0F);

		Skirt6 = new Modchu_ModelRenderer(this, 0, 28, Skirt);
		Skirt6.addPlate(0F, 0F, 0F, 22, 6, 0,f);
		Skirt6.setRotationPointLM(0F,-6F,0F);

		Skirt7 = new Modchu_ModelRenderer(this, 0, 34, Skirt);
		Skirt7.addPlate(-0.8F, -6F, 0F, 22, 6, 0,f);
		Skirt7.setRotationPointLM(0F,-5.5F,0F);

		Skirt8 = new Modchu_ModelRenderer(this, 0, 28, Skirt);
		Skirt8.addPlate(-0.8F, 0F, 0F, 22, 6, 0,f);
		Skirt8.setRotationPointLM(0F,-5.5F,0F);

		Skirt9 = new Modchu_ModelRenderer(this, 0, 34, Skirt);
		Skirt9.addPlate(-0.8F, -6F, 0F, 22, 6, 0,f);
		Skirt9.setRotationPointLM(0F,-5.5F,0F);

		Skirt10 = new Modchu_ModelRenderer(this, 0, 28, Skirt);
		Skirt10.addPlate(-0.8F, 0F, 0F, 22, 6, 0,f);
		Skirt10.setRotationPointLM(0F,-5.5F,0F);

		Skirt11 = new Modchu_ModelRenderer(this, 0, 34, Skirt);
		Skirt11.addPlate(0F, -6F, 0F, 22, 6, 0,f);
		Skirt11.setRotationPointLM(0F,-6F,0F);

		Skirt12 = new Modchu_ModelRenderer(this, 0, 28, Skirt);
		Skirt12.addPlate(0F, 0F, 0F, 22, 6, 0,f);
		Skirt12.setRotationPointLM(0F,-6F,0F);

		Skirt13 = new Modchu_ModelRenderer(this, 0, 34, Skirt);
		Skirt13.addPlate(0F, -6F, 0F, 22, 6, 0,f);
		Skirt13.setRotationPointLM(0F,-6F,0F);

		Skirt14 = new Modchu_ModelRenderer(this, 0, 28, Skirt);
		Skirt14.addPlate(0F, 0F, 0F, 22, 6, 0,f);
		Skirt14.setRotationPointLM(0F,-6F,0F);

		Skirt15 = new Modchu_ModelRenderer(this, 0, 34, Skirt);
		Skirt15.addPlate(-0.8F, -6F, 0F, 22, 6, 0,f);
		Skirt15.setRotationPointLM(0F,-5.5F,0F);

		Skirt16 = new Modchu_ModelRenderer(this, 0, 28, Skirt);
		Skirt16.addPlate(-0.8F, 0F, 0F, 22, 6, 0,f);
		Skirt16.setRotationPointLM(0F,-5.5F,0F);

		Skirt21 = new Modchu_ModelRenderer(this, 0, 48, Skirt);
		Skirt21.addPlate(-1.6F, -8F, 0F, 28, 8, 0,f);
		Skirt21.setRotationPointLM(0F,-5.5F,0F);

		Skirt22 = new Modchu_ModelRenderer(this, 0, 40, Skirt);
		Skirt22.addPlate(-1.6F, 0F, 0F,28, 8, 0,f);
		Skirt22.setRotationPointLM(0F,-5.5F,0F);

		Skirt23 = new Modchu_ModelRenderer(this, 0, 48, Skirt);
		Skirt23.addPlate(0F, -8F, 0F,28, 8, 0,f);
		Skirt23.setRotationPointLM(0F,-6F,0F);

		Skirt24 = new Modchu_ModelRenderer(this, 0, 40, Skirt);
		Skirt24.addPlate(0F, 0F, 0F, 28, 8, 0,f);
		Skirt24.setRotationPointLM(0F,-6F,0F);

		Skirt25 = new Modchu_ModelRenderer(this, 0, 48, Skirt);
		Skirt25.addPlate(0F, -8F, 0F, 28, 8, 0,f);
		Skirt25.setRotationPointLM(0F,-6F,0F);

		Skirt26 = new Modchu_ModelRenderer(this, 0, 40, Skirt);
		Skirt26.addPlate(0F, 0F, 0F, 28, 8, 0,f);
		Skirt26.setRotationPointLM(0F,-6F,0F);

		Skirt27 = new Modchu_ModelRenderer(this, 0, 48, Skirt);
		Skirt27.addPlate(-1.6F, -8F, 0F, 28, 8, 0,f);
		Skirt27.setRotationPointLM(0F,-5.5F,0F);

		Skirt28 = new Modchu_ModelRenderer(this, 0, 40, Skirt);
		Skirt28.addPlate(-1.6F, 0F, 0F,28, 8, 0,f);
		Skirt28.setRotationPointLM(0F,-5.5F,0F);

		Skirt29 = new Modchu_ModelRenderer(this, 0, 48, Skirt);
		Skirt29.addPlate(-1.6F, -8F, 0F, 28, 8, 0,f);
		Skirt29.setRotationPointLM(0F,-5.5F,0F);

		Skirt210 = new Modchu_ModelRenderer(this, 0, 40, Skirt);
		Skirt210.addPlate(-1.6F, 0F, 0F, 28, 8, 0,f);
		Skirt210.setRotationPointLM(0F,-5.5F,0F);

		Skirt211 = new Modchu_ModelRenderer(this, 0, 48, Skirt);
		Skirt211.addPlate(0F, -8F, 0F, 28, 8, 0,f);
		Skirt211.setRotationPointLM(0F,-6F,0F);

		Skirt212 = new Modchu_ModelRenderer(this, 0, 40, Skirt);
		Skirt212.addPlate(0F, 0F, 0F, 28, 8, 0,f);
		Skirt212.setRotationPointLM(0F,-6F,0F);

		Skirt213 = new Modchu_ModelRenderer(this, 0, 48, Skirt);
		Skirt213.addPlate(0F, -8F, 0F, 28, 8, 0,f);
		Skirt213.setRotationPointLM(0F,-6F,0F);

		Skirt214 = new Modchu_ModelRenderer(this, 0, 40, Skirt);
		Skirt214.addPlate(0F, 0F, 0F, 28, 8, 0,f);
		Skirt214.setRotationPointLM(0F,-6F,0F);

		Skirt215 = new Modchu_ModelRenderer(this, 0, 48, Skirt);
		Skirt215.addPlate(-1.6F, -8F, 0F, 28, 8, 0,f);
		Skirt215.setRotationPointLM(0F,-5.5F,0F);

		Skirt216 = new Modchu_ModelRenderer(this, 0, 40, Skirt);
		Skirt216.addPlate(-1.6F, 0F, 0F, 28, 8, 0,f);
		Skirt216.setRotationPointLM(0F,-5.5F,0F);

		ColorPlate1 = new Modchu_ModelRenderer(this, 0, 4, Skirt);
		ColorPlate1.addPlate(6.3F, 2F, 0F, 1, 2, 0,f);
		ColorPlate1.setRotationPointLM(0F,-5.5F,0F);

		ColorPlate2 = new Modchu_ModelRenderer(this, 2, 4, Skirt);
		ColorPlate2.addPlate(6.3F, 2F, 0F, 1, 2, 0,f);
		ColorPlate2.setRotationPointLM(0F,-5.5F,0F);

		ColorPlate3 = new Modchu_ModelRenderer(this, 4, 4, Skirt);
		ColorPlate3.addPlate(6.3F, 2F, 0F, 1, 2, 0,f);
		ColorPlate3.setRotationPointLM(0F,-5.5F,0F);

		ColorPlate4 = new Modchu_ModelRenderer(this, 0, 6, Skirt);
		ColorPlate4.addPlate(6.3F, 2F, 0F, 1, 2, 0,f);
		ColorPlate4.setRotationPointLM(0F,-5.5F,0F);

		ColorPlate5 = new Modchu_ModelRenderer(this, 2, 6, Skirt);
		ColorPlate5.addPlate(6.3F, 2F, 0F, 1, 2, 0,f);
		ColorPlate5.setRotationPointLM(0F,-5.5F,0F);

		ColorPlate6 = new Modchu_ModelRenderer(this, 4, 6, Skirt);
		ColorPlate6.addPlate(6.3F, 2F, 0F, 1, 2, 0,f);
		ColorPlate6.setRotationPointLM(0F,-5.5F,0F);

		ColorPlate7 = new Modchu_ModelRenderer(this, 6, 6, Skirt);
		ColorPlate7.addPlate(6.3F, 2F, 0F, 1, 2, 0,f);
		ColorPlate7.setRotationPointLM(0F,-5.5F,0F);

		ColorPlate8 = new Modchu_ModelRenderer(this, 6, 4, Skirt);
		ColorPlate8.addPlate(6.3F, 2F, 0F, 1, 2, 0,f);
		ColorPlate8.setRotationPointLM(0F,-5.5F,0F);

		ColorPlate9 = new Modchu_ModelRenderer(this, 0, 4, Skirt);
		ColorPlate9.addPlate(6.3F, 2F, 0F, 1, 2, 0,f);
		ColorPlate9.setRotationPointLM(0F,-5.5F,0F);

		ColorPlate10 = new Modchu_ModelRenderer(this, 2, 4, Skirt);
		ColorPlate10.addPlate(6.3F, 2F, 0F, 1, 2, 0,f);
		ColorPlate10.setRotationPointLM(0F,-5.5F,0F);

		ColorPlate11 = new Modchu_ModelRenderer(this, 4, 4, Skirt);
		ColorPlate11.addPlate(6.3F, 2F, 0F, 1, 2, 0,f);
		ColorPlate11.setRotationPointLM(0F,-5.5F,0F);

		ColorPlate12 = new Modchu_ModelRenderer(this, 0, 6, Skirt);
		ColorPlate12.addPlate(6.3F, 2F, 0F, 1, 2, 0,f);
		ColorPlate12.setRotationPointLM(0F,-5.5F,0F);

		ColorPlate13 = new Modchu_ModelRenderer(this, 2, 6, Skirt);
		ColorPlate13.addPlate(6.3F, 2F, 0F, 1, 2, 0,f);
		ColorPlate13.setRotationPointLM(0F,-5.5F,0F);

		ColorPlate14 = new Modchu_ModelRenderer(this, 4, 6, Skirt);
		ColorPlate14.addPlate(6.3F, 2F, 0F, 1, 2, 0,f);
		ColorPlate14.setRotationPointLM(0F,-5.5F,0F);

		ColorPlate15 = new Modchu_ModelRenderer(this, 6, 6, Skirt);
		ColorPlate15.addPlate(6.3F, 2F, 0F, 1, 2, 0,f);
		ColorPlate15.setRotationPointLM(0F,-5.5F,0F);

		ColorPlate16 = new Modchu_ModelRenderer(this, 6, 4, Skirt);
		ColorPlate16.addPlate(6.3F, 2F, 0F, 1, 2, 0,f);
		ColorPlate16.setRotationPointLM(0F,-5.5F,0F);

		Hat1 = new Modchu_ModelRenderer(this, 0, 16);
		Hat1.addBoxLM(-4.0F, -4.0F, 0F, 8, 8, 2,f);
		Hat1.setRotationPointLM(0F,-6F,0F);
		Hat1.setRotateAngleDeg(90F,180F,0F);
		bipedHead.addChild(Hat1);

		Hat2 = new Modchu_ModelRenderer(this, 0, 16);
		Hat2.addBoxLM(-4.0F, -4.0F, 1F, 8, 8, 2,f);
		Hat2.setRotationPointLM(0F,-6F,0F);
		Hat2.setRotateAngleDeg(90F,180F,0F);
		bipedHead.addChild(Hat2);

		Hat3 = new Modchu_ModelRenderer(this, 0, 18);
		Hat3.addPlate(-4.0F, 4.0F, 0F, 8, 3, 0,f);
		Hat3.setRotationPointLM(0F,-6F,0F);
		Hat3.setRotateAngleDeg(90F,180F,0F);
		bipedHead.addChild(Hat3);

		Hat4 = new Modchu_ModelRenderer(this, 0, 18);
		Hat4.addPlate(-4.0F, 4.0F, 0F, 8, 3, 0,f);
		Hat4.setRotationPointLM(0F,-6F,0F);
		Hat4.setRotateAngleDeg(90F,90F,0F);
		bipedHead.addChild(Hat4);

		Hat5 = new Modchu_ModelRenderer(this, 0, 18);
		Hat5.addPlate(-4.0F, 4.0F, 0F, 8, 3, 0,f);
		Hat5.setRotationPointLM(0F,-6F,0F);
		Hat5.setRotateAngleDeg(90F,0F,0F);
		bipedHead.addChild(Hat5);

		Hat6 = new Modchu_ModelRenderer(this, 0, 18);
		Hat6.addPlate(-4.0F, 4.0F, 0F, 8, 3, 0,f);
		Hat6.setRotationPointLM(0F,-6F,0F);
		Hat6.setRotateAngleDeg(90F,-90F,0F);
		bipedHead.addChild(Hat6);

		Hat7 = new Modchu_ModelRenderer(this, 0, 18);
		Hat7.addPlate(-2.1F, 4.8F, 0F, 3, 3, 0,f);
		Hat7.setRotationPointLM(0F,-6F,0F);
		Hat7.setRotateAngleDeg(90F,135F,0F);
		bipedHead.addChild(Hat7);

		Hat8 = new Modchu_ModelRenderer(this, 0, 18);
		Hat8.addPlate(-2.1F, 4.8F, 0F, 3, 3, 0,f);
		Hat8.setRotationPointLM(0F,-6F,0F);
		Hat8.setRotateAngleDeg(90F,45F,0F);
		bipedHead.addChild(Hat8);

		Hat9 = new Modchu_ModelRenderer(this, 0, 18);
		Hat9.addPlate(-2.1F, 4.8F, 0F, 3, 3, 0,f);
		Hat9.setRotationPointLM(0F,-6F,0F);
		Hat9.setRotateAngleDeg(90F,-135F,0F);
		bipedHead.addChild(Hat9);

		Hat10 = new Modchu_ModelRenderer(this, 0, 18);
		Hat10.addPlate(-2.1F, 4.8F, 0F, 3, 3, 0,f);
		Hat10.setRotationPointLM(0F,-6F,0F);
		Hat10.setRotateAngleDeg(90F,-45F,0F);
		bipedHead.addChild(Hat10);

		Hat11 = new Modchu_ModelRenderer(this, 0, 18);
		Hat11.addPlate(0.1F, 4.8F, 0F, 2, 3, 0,f);
		Hat11.setRotationPointLM(0F,-6F,0F);
		Hat11.setRotateAngleDeg(90F,135F,0F);
		bipedHead.addChild(Hat11);

		Hat12 = new Modchu_ModelRenderer(this, 0, 18);
		Hat12.addPlate(0.1F, 4.8F, 0F, 2, 3, 0,f);
		Hat12.setRotationPointLM(0F,-6F,0F);
		Hat12.setRotateAngleDeg(90F,45F,0F);
		bipedHead.addChild(Hat12);

		Hat13 = new Modchu_ModelRenderer(this, 0, 18);
		Hat13.addPlate(0.1F, 4.8F, 0F, 2, 3, 0,f);
		Hat13.setRotationPointLM(0F,-6F,0F);
		Hat13.setRotateAngleDeg(90F,-135F,0F);
		bipedHead.addChild(Hat13);

		Hat14 = new Modchu_ModelRenderer(this, 0, 18);
		Hat14.addPlate(0.1F, 4.8F, 0F, 2, 3, 0,f);
		Hat14.setRotationPointLM(0F,-6F,0F);
		Hat14.setRotateAngleDeg(90F,-45F,0F);
		bipedHead.addChild(Hat14);

		Line1 = new Modchu_ModelRenderer(this, 52, 10);
		Line1.addBoxLM(-1F, -4F, -4F, 1, 8, 1,f);
		Line1.setRotationPointLM(0F,-6.001F,0F);
		Line1.setRotateAngleDeg(0F,0F,90F);
		bipedHead.addChild(Line1);

		Line2 = new Modchu_ModelRenderer(this, 52, 10);
		Line2.addBoxLM(-1F, -4F, -4F, 1, 8, 1,f);
		Line2.setRotationPointLM(0F,-6.001F,0F);
		Line2.setRotateAngleDeg(0F,90F,90F);
		bipedHead.addChild(Line2);

		Line3 = new Modchu_ModelRenderer(this, 52, 10);
		Line3.addBoxLM(-1F, -4F, -4F, 1, 8, 1,f);
		Line3.setRotationPointLM(0F,-6.001F,0F);
		Line3.setRotateAngleDeg(0F,180F,90F);
		bipedHead.addChild(Line3);

		Line4 = new Modchu_ModelRenderer(this, 52, 10);
		Line4.addBoxLM(-1F, -4F, -4F, 1, 8, 1,f);
		Line4.setRotationPointLM(0F,-6.001F,0F);
		Line4.setRotateAngleDeg(0F,-90F,90F);
		bipedHead.addChild(Line4);

		Peach1 = new Modchu_ModelRenderer(this, 0, 0);
		Peach1.addBoxLM(4.0F, 1.0F, 0F, 2, 2, 2,f);
		Peach1.setRotationPointLM(0F,-6.001F,0F);
		Peach1.setRotateAngleDeg(90F,180F,0F);
		bipedHead.addChild(Peach1);

		Leaf1 = new Modchu_ModelRenderer(this, 1, 6);
		Leaf1.addPlate(0.0F, 0.0F, 0F, 1, 3, 0,f);
		Leaf1.setRotationPointLM(-5F,-6.5F,-1F);
		Leaf1.setRotateAngleDeg(-15F,-123F,-170F);
		bipedHead.addChild(Leaf1);

		Leaf2 = new Modchu_ModelRenderer(this, 1, 6);
		Leaf2.addPlate(0.0F, 0.0F, 0F, 1, 3, 0,f);
		Leaf2.setRotationPointLM(-5F,-6.0F,-1F);
		Leaf2.setRotateAngleDeg(-25F,-146F,-130F);
		bipedHead.addChild(Leaf2);

		Neck = new Modchu_ModelRenderer(this,16 ,5);
		Neck.addBox(-1.0F, -1.0F, 1.0F, 2, 1, 2, f);
		Neck.setRotationPointLM(0.0F,0.0F,-2.0F);
		bipedBody.addChild(Neck);

		Ribon4 = new Modchu_ModelRenderer(this,22 ,16);
		Ribon4.addBox(-1.0F, -0.5F, -0.2F, 2, 1, 1, f);
		Ribon4.setRotationPointLM(0.0F,-2.7F,-2.2F);
		bipedBody.addChild(Ribon4);

		Ribon5 = new Modchu_ModelRenderer(this,22 ,16);
		Ribon5.addBox(0.0F, -0.5F, 0.0F, 1, 1, 1, f);
		Ribon5.setRotationPointLM(0.3F,-2.7F,-2.2F);
		Ribon5.setRotateAngleDeg(0F,0F,15F);
		bipedBody.addChild(Ribon5);

		Ribon6 = new Modchu_ModelRenderer(this,22 ,16);
		Ribon6.addBox(-1.0F, -0.5F, 0.0F, 1, 1, 1, f);
		Ribon6.setRotationPointLM(-0.3F,-2.7F,-2.2F);
		Ribon6.setRotateAngleDeg(0F,0F,-15F);
		bipedBody.addChild(Ribon6);

		PlateR1 = new Modchu_ModelRenderer(this, 45, 52, Skirt);
		PlateR1.addPlate(-8.0F, 0.0F, 0.0F, 16, 8, 0, f);
		PlateR1.setRotationPointLM(-3.0F,-3.4F+1.0F,0.0F);
		PlateR1.setRotateAngleDeg(-50F,90F,0F);

		PlateR2 = new Modchu_ModelRenderer(this,44 ,60, Skirt);
		PlateR2.addPlate(-8.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateR2.setRotationPointLM(-3.0F,-3.4F-f1+1.0F,2.0F);
		PlateR2.setRotateAngleDeg(60F,0F,-40F);

		PlateR3 = new Modchu_ModelRenderer(this,44 ,60, Skirt);
		PlateR3.addPlate(-8.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateR3.setRotationPointLM(-3.0F,-3.4F+1.0F,-2.0F);
		PlateR3.setRotateAngleDeg(-60F,0F,-40F);

		PlateR4 = new Modchu_ModelRenderer(this,44 ,52, Skirt);
		PlateR4.addPlate(-10F, 0.0F, 0.0F, 20, 8, 0, f);
		PlateR4.setRotationPointLM(-4.5F,-1.7F+1.0F,0.0F);
		PlateR4.setRotateAngleDeg(-50F,90F,0F);

		PlateR5 = new Modchu_ModelRenderer(this,44 ,60, Skirt);
		PlateR5.addPlate(-8.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateR5.setRotationPointLM(-4.5F,-1.7F+1.0F,2.5F);
		PlateR5.setRotateAngleDeg(60F,0F,-40F);

		PlateR6 = new Modchu_ModelRenderer(this,44 ,60, Skirt);
		PlateR6.addPlate(-8.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateR6.setRotationPointLM(-4.5F,-1.7F+1.0F,-2.5F);
		PlateR6.setRotateAngleDeg(-60F,0F,-40F);

		PlateL1 = new Modchu_ModelRenderer(this,45 ,52, Skirt);
		PlateL1.addPlate(-8.0F, 0.0F, 0.0F, 16, 8, 0, f);
		PlateL1.setRotationPointLM(3.0F,-3.4F+1.0F,0.0F);
		PlateL1.setRotateAngleDeg(50F,90F,0F);

		PlateL2 = new Modchu_ModelRenderer(this,44 ,60, Skirt);
		PlateL2.addPlate(0.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateL2.setRotationPointLM(3.0F,-3.4F+1.0F,2.0F);
		PlateL2.setRotateAngleDeg(60F,0F,40F);

		PlateL3 = new Modchu_ModelRenderer(this,44 ,60, Skirt);
		PlateL3.addPlate(0.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateL3.setRotationPointLM(3.0F,-3.4F+1.0F,-2.0F);
		PlateL3.setRotateAngleDeg(-60F,0F,40F);

		PlateL4 = new Modchu_ModelRenderer(this,44 ,52, Skirt);
		PlateL4.addPlate(-10F, 0.0F, 0.0F, 20, 8, 0, f);
		PlateL4.setRotationPointLM(4.5F,-1.7F+1.0F,0.0F);
		PlateL4.setRotateAngleDeg(50F,90F,0F);

		PlateL5 = new Modchu_ModelRenderer(this,44 ,60, Skirt);
		PlateL5.addPlate(0.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateL5.setRotationPointLM(4.5F,-1.7F+1.0F,2.5F);
		PlateL5.setRotateAngleDeg(60F,0F,40F);

		PlateL6 = new Modchu_ModelRenderer(this,44 ,60, Skirt);
		PlateL6.addPlate(0.0F, 0.0F, 0.0F, 8, 4, 0, f);
		PlateL6.setRotationPointLM(4.5F,-1.7F+1.0F,-2.5F);
		PlateL6.setRotateAngleDeg(-60F,0F,40F);

		mainFrame = new Modchu_ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, 0F + f1, 0F);
		mainFrame.addChild(bipedHead);
		mainFrame.addChild(bipedBody);

		Skirt1.setRotateAngleDeg(-118F, 113F, 47F);
		Skirt2.setRotateAngleDeg(-65F, 113F, 47F);
		Skirt3.setRotateAngleDeg(-122F, 158F, 47F);
		Skirt4.setRotateAngleDeg(-67F, 158F, 47F);
		Skirt5.setRotateAngleDeg(-113F, -159F, 47F);
		Skirt6.setRotateAngleDeg(-58F, -159F, 47F);
		Skirt7.setRotateAngleDeg(-114F, -114F, 47F);
		Skirt8.setRotateAngleDeg(-65F, -114F, 47F);
		Skirt9.setRotateAngleDeg(-115F, -68F, 47F);
		Skirt10.setRotateAngleDeg(-65F, -68F, 47F);
		Skirt11.setRotateAngleDeg(-122F, -23F, 47F);
		Skirt12.setRotateAngleDeg(-66F, -23F, 47F);
		Skirt13.setRotateAngleDeg(-114F, 22F, 47F);
		Skirt14.setRotateAngleDeg(-58F, 22F, 47F);
		Skirt15.setRotateAngleDeg(-115F, 67F, 47F);
		Skirt16.setRotateAngleDeg(-62F, 67F, 47F);
		Skirt21.setRotateAngleDeg(-118F, 113F, 43F);
		Skirt22.setRotateAngleDeg(-65F, 113F, 43F);
		Skirt23.setRotateAngleDeg(-122F, 158F, 44F);
		Skirt24.setRotateAngleDeg(-67F, 158F, 44F);
		Skirt25.setRotateAngleDeg(-113F, -159F, 44F);
		Skirt26.setRotateAngleDeg(-58F, -159F, 44F);
		Skirt27.setRotateAngleDeg(-114F, -114F, 43F);
		Skirt28.setRotateAngleDeg(-65F, -114F, 43F);
		Skirt29.setRotateAngleDeg(-115F, -68F, 43F);
		Skirt210.setRotateAngleDeg(-65F, -68F, 43F);
		Skirt211.setRotateAngleDeg(-122F, -23F, 44F);
		Skirt212.setRotateAngleDeg(-66F, -23F, 44F);
		Skirt213.setRotateAngleDeg(-114F, 22F, 44F);
		Skirt214.setRotateAngleDeg(-58F, 22F, 44F);
		Skirt215.setRotateAngleDeg(-115F, 67F, 43F);
		Skirt216.setRotateAngleDeg(-62F, 67F, 43F);
		ColorPlate1.setRotateAngleDeg(-70F, 67F, 40F);
		ColorPlate2.setRotateAngleDeg(-72F,91F, 40F);
		ColorPlate3.setRotateAngleDeg(-74F, 114F, 40F);
		ColorPlate4.setRotateAngleDeg(-73F, 137F, 38F);
		ColorPlate5.setRotateAngleDeg(-72F, 159F, 37F);
		ColorPlate6.setRotateAngleDeg(-65F, -180F, 35F);
		ColorPlate7.setRotateAngleDeg(-68F, -159F, 38F);
		ColorPlate8.setRotateAngleDeg(-67F, -136F, 38F);
		ColorPlate9.setRotateAngleDeg(-72F, -114F, 40F);
		ColorPlate10.setRotateAngleDeg(-67F, -90F, 38F);
		ColorPlate11.setRotateAngleDeg(-77F, -69F, 42F);
		ColorPlate12.setRotateAngleDeg(-67F, -44F, 36F);
		ColorPlate13.setRotateAngleDeg(-74F, -23F, 39F);
		ColorPlate14.setRotateAngleDeg(-67F, 1F, 36F);
		ColorPlate15.setRotateAngleDeg(-68F, 22F, 38F);
		ColorPlate16.setRotateAngleDeg(-67F, 45F, 38F);

		int i = Modchu_ModelRenderer.YZX;
		Skirt1.setRotatePriority(i);
		Skirt2.setRotatePriority(i);
		Skirt3.setRotatePriority(i);
		Skirt4.setRotatePriority(i);
		Skirt5.setRotatePriority(i);
		Skirt6.setRotatePriority(i);
		Skirt7.setRotatePriority(i);
		Skirt8.setRotatePriority(i);
		Skirt9.setRotatePriority(i);
		Skirt10.setRotatePriority(i);
		Skirt11.setRotatePriority(i);
		Skirt12.setRotatePriority(i);
		Skirt13.setRotatePriority(i);
		Skirt14.setRotatePriority(i);
		Skirt15.setRotatePriority(i);
		Skirt16.setRotatePriority(i);
		Skirt21.setRotatePriority(i);
		Skirt22.setRotatePriority(i);
		Skirt23.setRotatePriority(i);
		Skirt24.setRotatePriority(i);
		Skirt25.setRotatePriority(i);
		Skirt26.setRotatePriority(i);
		Skirt27.setRotatePriority(i);
		Skirt28.setRotatePriority(i);
		Skirt29.setRotatePriority(i);
		Skirt210.setRotatePriority(i);
		Skirt211.setRotatePriority(i);
		Skirt212.setRotatePriority(i);
		Skirt213.setRotatePriority(i);
		Skirt214.setRotatePriority(i);
		Skirt215.setRotatePriority(i);
		Skirt216.setRotatePriority(i);
		Patch3.setRotatePriority(i);
		ColorPlate1.setRotatePriority(i);
		ColorPlate2.setRotatePriority(i);
		ColorPlate3.setRotatePriority(i);
		ColorPlate4.setRotatePriority(i);
		ColorPlate5.setRotatePriority(i);
		ColorPlate6.setRotatePriority(i);
		ColorPlate7.setRotatePriority(i);
		ColorPlate8.setRotatePriority(i);
		ColorPlate9.setRotatePriority(i);
		ColorPlate10.setRotatePriority(i);
		ColorPlate11.setRotatePriority(i);
		ColorPlate12.setRotatePriority(i);
		ColorPlate13.setRotatePriority(i);
		ColorPlate14.setRotatePriority(i);
		ColorPlate15.setRotatePriority(i);
		ColorPlate16.setRotatePriority(i);
		Patch1.setRotatePriority(i);
		Patch2.setRotatePriority(i);
		Neck.setRotatePriority(i);
		Hat1.setRotatePriority(i);
		Hat2.setRotatePriority(i);
		Hat3.setRotatePriority(i);
		Hat4.setRotatePriority(i);
		Hat5.setRotatePriority(i);
		Hat6.setRotatePriority(i);
		Hat7.setRotatePriority(i);
		Hat8.setRotatePriority(i);
		Hat9.setRotatePriority(i);
		Hat10.setRotatePriority(i);
		Hat11.setRotatePriority(i);
		Hat12.setRotatePriority(i);
		Hat13.setRotatePriority(i);
		Hat14.setRotatePriority(i);
		Line1.setRotatePriority(i);
		Line2.setRotatePriority(i);
		Line3.setRotatePriority(i);
		Line4.setRotatePriority(i);
		Peach1.setRotatePriority(i);
		Leaf1.setRotatePriority(i);
		Leaf2.setRotatePriority(i);
		Calar1.setRotatePriority(i);
		Calar2.setRotatePriority(i);
		Ribon4.setRotatePriority(i);
		Ribon5.setRotatePriority(i);
		Ribon6.setRotatePriority(i);
		PlateR1.setRotatePriority(i);
		PlateR2.setRotatePriority(i);
		PlateR3.setRotatePriority(i);
		PlateR4.setRotatePriority(i);
		PlateR5.setRotatePriority(i);
		PlateR6.setRotatePriority(i);
		PlateL1.setRotatePriority(i);
		PlateL2.setRotatePriority(i);
		PlateL3.setRotatePriority(i);
		PlateL4.setRotatePriority(i);
		PlateL5.setRotatePriority(i);
		PlateL6.setRotatePriority(i);
		HipR.setRotatePriority(i);
		HipL.setRotatePriority(i);

		Skirt1.setScale(0.5F, 0.5F, 1.0F);
		Skirt2.setScale(0.5F, 0.5F, 1.0F);
		Skirt3.setScale(0.5F, 0.5F, 1.0F);
		Skirt4.setScale(0.5F, 0.5F, 1.0F);
		Skirt5.setScale(0.5F, 0.5F, 1.0F);
		Skirt6.setScale(0.5F, 0.5F, 1.0F);
		Skirt7.setScale(0.5F, 0.5F, 1.0F);
		Skirt8.setScale(0.5F, 0.5F, 1.0F);
		Skirt9.setScale(0.5F, 0.5F, 1.0F);
		Skirt10.setScale(0.5F, 0.5F, 1.0F);
		Skirt11.setScale(0.5F, 0.5F, 1.0F);
		Skirt12.setScale(0.5F, 0.5F, 1.0F);
		Skirt13.setScale(0.5F, 0.5F, 1.0F);
		Skirt14.setScale(0.5F, 0.5F, 1.0F);
		Skirt15.setScale(0.5F, 0.5F, 1.0F);
		Skirt16.setScale(0.5F, 0.5F, 1.0F);
		Skirt21.setScale(0.25F, 0.25F, 1.0F);
		Skirt22.setScale(0.25F, 0.25F, 1.0F);
		Skirt23.setScale(0.25F, 0.25F, 1.0F);
		Skirt24.setScale(0.25F, 0.25F, 1.0F);
		Skirt25.setScale(0.25F, 0.25F, 1.0F);
		Skirt26.setScale(0.25F, 0.25F, 1.0F);
		Skirt27.setScale(0.25F, 0.25F, 1.0F);
		Skirt28.setScale(0.25F, 0.25F, 1.0F);
		Skirt29.setScale(0.25F, 0.25F, 1.0F);
		Skirt210.setScale(0.25F, 0.25F, 1.0F);
		Skirt211.setScale(0.25F, 0.25F, 1.0F);
		Skirt212.setScale(0.25F, 0.25F, 1.0F);
		Skirt213.setScale(0.25F, 0.25F, 1.0F);
		Skirt214.setScale(0.25F, 0.25F, 1.0F);
		Skirt215.setScale(0.25F, 0.25F, 1.0F);
		Skirt216.setScale(0.25F, 0.25F, 1.0F);
		Patch1.setScale(1.01F, 0.333F, 1.01F);
		Patch2.setScale(1.01F, 0.333F, 1.01F);
		Hat1.setScale(1.1F, 1.1F, 1.1F);
		Line1.setScale(0.6F, 1.101F, 1.101F);
		Line2.setScale(0.6F, 1.101F, 1.101F);
		Line3.setScale(0.6F, 1.101F, 1.101F);
		Line4.setScale(0.6F, 1.101F, 1.101F);
		Ribon4.setScale(0.5F, 0.5F, 0.7F);
		Ribon5.setScale(0.9F, 0.9F, 0.9F);
		Ribon6.setScale(0.9F, 0.9F, 0.9F);
		PlateR1.setScale(0.25F, 0.25F, 0.25F);
		PlateR2.setScale(0.25F, 0.25F, 0.25F);
		PlateR3.setScale(0.25F, 0.25F, 0.25F);
		PlateR4.setScale(0.25F, 0.25F, 0.25F);
		PlateR5.setScale(0.25F, 0.25F, 0.25F);
		PlateR6.setScale(0.25F, 0.25F, 0.25F);
		PlateL1.setScale(0.25F, 0.25F, 0.25F);
		PlateL2.setScale(0.25F, 0.25F, 0.25F);
		PlateL3.setScale(0.25F, 0.25F, 0.25F);
		PlateL4.setScale(0.25F, 0.25F, 0.25F);
		PlateL5.setScale(0.25F, 0.25F, 0.25F);
		PlateL6.setScale(0.25F, 0.25F, 0.25F);

		actionPartsInit(f, f1);
	}

    @Override
    public void skirtFloatsInit(float f, float f1) {
    }

	public void setLivingAnimationsLM(EntityLiving entityliving, float f, float f1, float f2) {
		super.setLivingAnimationsLM(entityliving, f, f1, f2);

		ItemStack is;
		boolean isHelmet = false;
/*
		if (entityliving instanceof EntityPlayer) {
			is = ((EntityPlayer) entityliving).inventory.armorItemInSlot(3);
			if (is != null && is.stackSize > 0) {
				Item item = is.getItem();
				if(item instanceof ItemArmor) isHelmet = true;
			}
		} else if (mod_Modchu_ModchuLib.LMM_EntityLittleMaid != null
					&& mod_Modchu_ModchuLib.LMM_EntityLittleMaid.isInstance(entityliving)) {
*/
			//isHelmet = ((LMM_EntityLittleMaid) entityliving).maidInventory.armorInventory[3] != null;
			Object inventory = getCapsValue(caps_Inventory);
			if (inventory != null) {
				Object[] o = (Object[]) getFieldObject(InventoryPlayer.class, "b", "armorInventory", inventory);
				if (o != null
						&& o[3] != null) isHelmet = true;
			}
		//}
		if(isHelmet){
			Hat1.isHidden = Hat2.isHidden = Hat3.isHidden =
					Hat4.isHidden = Hat5.isHidden = Hat6.isHidden =
					Hat7.isHidden = Hat8.isHidden = Hat9.isHidden =
					Hat10.isHidden = Hat11.isHidden = Hat12.isHidden =
					Hat13.isHidden = Hat14.isHidden = Peach1.isHidden =
					Line1.isHidden = Line2.isHidden = Line3.isHidden =
					Line4.isHidden = Leaf1.isHidden = Leaf2.isHidden = false;
		} else {
			Hat1.isHidden = Hat2.isHidden = Hat3.isHidden =
					Hat4.isHidden = Hat5.isHidden = Hat6.isHidden =
					Hat7.isHidden = Hat8.isHidden = Hat9.isHidden =
					Hat10.isHidden = Hat11.isHidden = Hat12.isHidden =
					Hat13.isHidden = Hat14.isHidden = Peach1.isHidden =
					Line1.isHidden = Line2.isHidden = Line3.isHidden =
					Line4.isHidden = Leaf1.isHidden = Leaf2.isHidden = true;
		}
	}

	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);
		if(getCapsValueBoolean(caps_getIsSneak)){
			Skirt.rotationPointZ = -0.5F;
		} else {
			Skirt.rotationPointZ = 0.0F;
		}
		Skirt.rotationPointY = 3.5F;
		Skirt.rotateAngleX = 0.0F;
		skirtFloats(f, f1, f2, f3, f4, f5, entity);
	}

	@Override
	public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		if (!getCapsValueBoolean(caps_skirtFloats)) return;
		float motionY = getCapsValueFloat(caps_motionY);
		Skirt1.setRotateAngleDeg(-118F, 113F, 47F);
		Skirt2.setRotateAngleDeg(-65F, 113F, 47F);
		Skirt3.setRotateAngleDeg(-122F, 158F, 47F);
		Skirt4.setRotateAngleDeg(-67F, 158F, 47F);
		Skirt5.setRotateAngleDeg(-113F, -159F, 47F);
		Skirt6.setRotateAngleDeg(-58F, -159F, 47F);
		Skirt7.setRotateAngleDeg(-114F, -114F, 47F);
		Skirt8.setRotateAngleDeg(-65F, -114F, 47F);
		Skirt9.setRotateAngleDeg(-115F, -68F, 47F);
		Skirt10.setRotateAngleDeg(-65F, -68F, 47F);
		Skirt11.setRotateAngleDeg(-122F, -23F, 47F);
		Skirt12.setRotateAngleDeg(-66F, -23F, 47F);
		Skirt13.setRotateAngleDeg(-114F, 22F, 47F);
		Skirt14.setRotateAngleDeg(-58F, 22F, 47F);
		Skirt15.setRotateAngleDeg(-115F, 67F, 47F);
		Skirt16.setRotateAngleDeg(-62F, 67F, 47F);
		Skirt21.setRotateAngleDeg(-118F, 113F, 43F);
		Skirt22.setRotateAngleDeg(-65F, 113F, 43F);
		Skirt23.setRotateAngleDeg(-122F, 158F, 44F);
		Skirt24.setRotateAngleDeg(-67F, 158F, 44F);
		Skirt25.setRotateAngleDeg(-113F, -159F, 44F);
		Skirt26.setRotateAngleDeg(-58F, -159F, 44F);
		Skirt27.setRotateAngleDeg(-114F, -114F, 43F);
		Skirt28.setRotateAngleDeg(-65F, -114F, 43F);
		Skirt29.setRotateAngleDeg(-115F, -68F, 43F);
		Skirt210.setRotateAngleDeg(-65F, -68F, 43F);
		Skirt211.setRotateAngleDeg(-122F, -23F, 44F);
		Skirt212.setRotateAngleDeg(-66F, -23F, 44F);
		Skirt213.setRotateAngleDeg(-114F, 22F, 44F);
		Skirt214.setRotateAngleDeg(-58F, 22F, 44F);
		Skirt215.setRotateAngleDeg(-115F, 67F, 43F);
		Skirt216.setRotateAngleDeg(-62F, 67F, 43F);

		float f6 = -motionY * 2.0F - 7F;
		Skirt1.rotationPointY = 2.5F + f6;
		Skirt2.rotationPointY = 2.5F + f6;
		Skirt3.rotationPointY = 2F + f6;
		Skirt4.rotationPointY = 2F + f6;
		Skirt5.rotationPointY = 2F + f6;
		Skirt6.rotationPointY = 2F + f6;
		Skirt7.rotationPointY = 2.5F + f6;
		Skirt8.rotationPointY = 2.5F + f6;
		Skirt9.rotationPointY = 2.5F + f6;
		Skirt10.rotationPointY = 2.5F + f6;
		Skirt11.rotationPointY = 2F + f6;
		Skirt12.rotationPointY = 2F + f6;
		Skirt13.rotationPointY = 2F + f6;
		Skirt14.rotationPointY = 2F + f6;
		Skirt15.rotationPointY = 2.5F + f6;
		Skirt16.rotationPointY = 2.5F + f6;
		Skirt21.rotationPointY = 2.5F + f6;
		Skirt22.rotationPointY = 2.5F + f6;
		Skirt23.rotationPointY = 2F + f6;
		Skirt24.rotationPointY = 2F + f6;
		Skirt25.rotationPointY = 2F + f6;
		Skirt26.rotationPointY = 2F + f6;
		Skirt27.rotationPointY = 2.5F + f6;
		Skirt28.rotationPointY = 2.5F + f6;
		Skirt29.rotationPointY = 2.5F + f6;
		Skirt210.rotationPointY = 2.5F + f6;
		Skirt211.rotationPointY = 2F + f6;
		Skirt212.rotationPointY = 2F + f6;
		Skirt213.rotationPointY = 2F + f6;
		Skirt214.rotationPointY = 2F + f6;
		Skirt215.rotationPointY = 2.5F + f6;
		Skirt216.rotationPointY = 2.5F + f6;

		Skirt1.rotateAngleX += motionY;
		Skirt1.rotateAngleZ += motionY;
		Skirt2.rotateAngleX += motionY;
		Skirt2.rotateAngleZ += motionY;
		Skirt3.rotateAngleX += motionY;
		Skirt3.rotateAngleZ += motionY;
		Skirt4.rotateAngleX += motionY;
		Skirt4.rotateAngleZ += motionY;
		Skirt5.rotateAngleX += motionY;
		Skirt5.rotateAngleZ += motionY;
		Skirt6.rotateAngleX += motionY;
		Skirt6.rotateAngleZ += motionY;
		Skirt7.rotateAngleZ += motionY;
		Skirt8.rotateAngleZ += motionY;
		Skirt9.rotateAngleX += motionY;
		Skirt9.rotateAngleZ += motionY;
		Skirt10.rotateAngleX += motionY;
		Skirt10.rotateAngleZ += motionY;
		Skirt11.rotateAngleX += motionY;
		Skirt11.rotateAngleZ += motionY;
		Skirt12.rotateAngleX += motionY;
		Skirt12.rotateAngleZ += motionY;
		Skirt13.rotateAngleX += motionY;
		Skirt13.rotateAngleZ += motionY;
		Skirt14.rotateAngleX += motionY;
		Skirt14.rotateAngleZ += motionY;
		Skirt15.rotateAngleX += motionY;
		Skirt15.rotateAngleZ += motionY;
		Skirt16.rotateAngleX += motionY;
		Skirt16.rotateAngleZ += motionY;
		Skirt21.rotateAngleZ += motionY;
		Skirt22.rotateAngleX += motionY;
		Skirt22.rotateAngleZ += motionY;
		Skirt23.rotateAngleX += motionY;
		Skirt23.rotateAngleZ += motionY;
		Skirt24.rotateAngleX += motionY;
		Skirt24.rotateAngleZ += motionY;
		Skirt25.rotateAngleX += motionY;
		Skirt25.rotateAngleZ += motionY;
		Skirt26.rotateAngleX += motionY;
		Skirt26.rotateAngleZ += motionY;
		Skirt27.rotateAngleZ += motionY;
		Skirt28.rotateAngleZ += motionY;
		Skirt29.rotateAngleZ += motionY;
		Skirt210.rotateAngleY += motionY;
		Skirt210.rotateAngleZ += motionY;
		Skirt211.rotateAngleY += motionY;
		Skirt211.rotateAngleZ += motionY;
		Skirt212.rotateAngleY += motionY;
		Skirt212.rotateAngleZ += motionY;
		Skirt213.rotateAngleY += motionY;
		Skirt213.rotateAngleZ += motionY;
		Skirt214.rotateAngleY += motionY;
		Skirt214.rotateAngleZ += motionY;
		Skirt215.rotateAngleY += motionY;
		Skirt215.rotateAngleZ += motionY;
		Skirt216.rotateAngleZ += motionY;
	}

    @Override
    public void defaultPartsSettingBefore() {
    	super.defaultPartsSettingBefore();
    	String[] s = {
    			"Skirt1", "Skirt2", "Skirt3", "Skirt4", "Skirt5",
    			"Skirt6", "Skirt7", "Skirt8", "Skirt9", "Skirt10",
    			"Skirt11", "Skirt12", "Skirt13", "Skirt14", "Skirt15",
    			"Skirt16", "Skirt21", "Skirt22", "Skirt23", "Skirt24",
    			"Skirt25", "Skirt26", "Skirt27", "Skirt27", "Skirt28",
    			"Skirt29", "Skirt210", "Skirt211", "Skirt212", "Skirt213",
    			"Skirt214", "Skirt215", "Skirt216"
    	};
    	showPartsHideListadd(s);
    }

    @Override
    public void actionInit1() {
    	super.actionInit1();
    	((Modchu_ModelRenderer) bipedRightArm).removeChild(Patch1);
    	((Modchu_ModelRenderer) bipedLeftArm).removeChild(Patch2);
    	rightArm.addChild(Patch1);
    	leftArm.addChild(Patch2);
    }

    @Override
    public void actionRelease1() {
    	super.actionRelease1();
    	bipedRightArm.addChild(Patch1);
    	bipedLeftArm.addChild(Patch2);
    	((Modchu_ModelRenderer) rightArm).removeChild(Patch1);
    	((Modchu_ModelRenderer) leftArm).removeChild(Patch2);
    }

    public void setArmorBipedHeadShowModel(boolean b) {
    	super.setArmorBipedHeadShowModel(b);
    	Hat1.isHidden = Hat2.isHidden = Hat3.isHidden =
    			Hat4.isHidden = Hat5.isHidden = Hat6.isHidden =
    			Hat7.isHidden = Hat8.isHidden = Hat9.isHidden =
    			Hat10.isHidden = Hat11.isHidden = Hat12.isHidden =
    			Hat13.isHidden = Hat14.isHidden = Peach1.isHidden =
    			Line1.isHidden = Line2.isHidden = Line3.isHidden =
    			Line4.isHidden = Leaf1.isHidden = Leaf2.isHidden = !b;
    }
}