package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class MultiModel_Angel extends MultiModel_SR2 {

	public Modchu_ModelRenderer Prim;
	public Modchu_ModelRenderer WingLroot;
	public Modchu_ModelRenderer WingL2;
	public Modchu_ModelRenderer WingL3;
	public Modchu_ModelRenderer WingL4;
	public Modchu_ModelRenderer WingL5;
	public Modchu_ModelRenderer WingL6;
	public Modchu_ModelRenderer WingRroot;
	public Modchu_ModelRenderer WingR2;
	public Modchu_ModelRenderer WingR3;
	public Modchu_ModelRenderer WingR4;
	public Modchu_ModelRenderer WingR5;
	public Modchu_ModelRenderer WingR6;
	public Modchu_ModelRenderer Tail3;
	public Modchu_ModelRenderer Tail4;
	public Modchu_ModelRenderer Tail5;
	public Modchu_ModelRenderer Tail6;
	public Modchu_ModelRenderer Ahoge;
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
	public Modchu_ModelRenderer Ribon0;
	public Modchu_ModelRenderer RibonLU2;
	public Modchu_ModelRenderer RibonLU3;
	public Modchu_ModelRenderer RibonLU4;
	public Modchu_ModelRenderer RibonRU2;
	public Modchu_ModelRenderer RibonRU3;
	public Modchu_ModelRenderer RibonRU4;
	public Modchu_ModelRenderer RibonLD1;
	public Modchu_ModelRenderer RibonLD2;
	public Modchu_ModelRenderer RibonLD3;
	public Modchu_ModelRenderer RibonRD1;
	public Modchu_ModelRenderer RibonRD2;
	public Modchu_ModelRenderer RibonRD3;
	public Modchu_ModelRenderer Circle;
	public Modchu_ModelRenderer Glass;

	private int IdOffset;

	public MultiModel_Angel()
	{
		this(0.0F);
	}

	public MultiModel_Angel(float f)
	{
		this(f, 0.0F);
	}

	public MultiModel_Angel(float f, float f1)
	{
		this(f, f1 , 64, 64);
	}

	public MultiModel_Angel(float f, float f1, int i, int j) {
		super(f, f1, i, j);
		HeadMount.setRotationPoint(0.0F, 1.0F, 0.0F);
	}

	@Override
	public void initModel(float f, float f1) {
		textureWidth = 64;
		textureHeight = 64;
		f1 += 8F;
		bipedCloak = new ModelRenderer(this, 0, 0);
		bipedCloak.showModel = false;
		bipedEars = new ModelRenderer(this, 0, 16);
		bipedEars.showModel = false;
		bipedHead = new Modchu_ModelRenderer(this, 0, 1);
		bipedHead.addBox(-4F, -7F, -4F, 8, 7, 8, f);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
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

		eyeR = new Modchu_ModelRenderer(this, 32, 19);
		eyeR.addPlate(-4.0F, -5.0F, -4.001F, 4, 4, 0, f);
		eyeR.setRotationPointLM(0.0F, 0.0F, 0.0F);
		eyeL = new Modchu_ModelRenderer(this, 42, 19);
		eyeL.addPlate(0.0F, -5.0F, -4.001F, 4, 4, 0, f);
		eyeL.setRotationPointLM(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(eyeR);
		bipedHead.addChild(eyeL);

		Glass = new Modchu_ModelRenderer(this, 24, 0);
		Glass.addPlate(-8.0F, -4.0F, 0F, 16, 8, 0, f);
		Glass.setRotationPointLM(0.0F, -4.0F, -4.0F);
		bipedHead.addChild(Glass);

		Prim = new Modchu_ModelRenderer(this, 4, 0);
		Prim.addPlate(-2F, -7.7F, -3.5F, 4, 1, 0, f);
		Prim.setRotationPointLM(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(Prim);

		ChignonB = new Modchu_ModelRenderer(this, 52, 10);
		ChignonB.addBox(-2F, -8F, 3.3F, 4, 4, 2, f - 0.5F);
		ChignonB.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(ChignonB);

		WingLroot = new Modchu_ModelRenderer(this, 0, 0);
		WingLroot.mirror=true;
		WingLroot.addBoxLM(-0.5F, 0F, -0.5F, 1, 3, 1,f);
		WingLroot.setRotationPointLM(0.4F, -1.0F, 1.2F);
		bipedBody.addChild(WingLroot);

		WingL2 = new Modchu_ModelRenderer(this, 0, 0);
		WingL2.mirror=true;
		WingL2.addBoxLM(-2.4F, 2F, -0.4F, 1, 4, 1,f);
		WingLroot.addChild(WingL2);

		WingL3 = new Modchu_ModelRenderer(this, 4, 1);
		WingL3.mirror=true;
		WingL3.addBoxLM(4.5F, 2.5F, 1.3F, 1, 3, 1,f);
		WingLroot.addChild(WingL3);

		WingL4 = new Modchu_ModelRenderer(this, 4, 1);
		WingL4.mirror=true;
		WingL4.addBoxLM(3.5F, 2F, 1.3F, 1, 3, 1,f);
		WingLroot.addChild(WingL4);

		WingL5 = new Modchu_ModelRenderer(this, 4, 1);
		WingL5.mirror=true;
		WingL5.addBoxLM(2.5F, 2F, 1.3F, 1, 2, 1,f);
		WingLroot.addChild(WingL5);

		WingL6 = new Modchu_ModelRenderer(this, 4, 1);
		WingL6.mirror=true;
		WingL6.addBoxLM(1.8F, 1.5F, 1.3F, 1, 1, 1,f);
		WingLroot.addChild(WingL6);

		WingRroot = new Modchu_ModelRenderer(this, 0, 0);
		WingRroot.addBoxLM(-0.5F, 0F, -0.5F, 1, 3, 1,f);
		WingRroot.setRotationPointLM(-0.5F, -1.0F, 1.2F);
		bipedBody.addChild(WingRroot);

		WingR2 = new Modchu_ModelRenderer(this, 0, 0);
		WingR2.addBoxLM(1.4F, 2F, -0.4F, 1, 4, 1,f);
		WingRroot.addChild(WingR2);

		WingR3 = new Modchu_ModelRenderer(this, 4, 1);
		WingR3.addBoxLM(-5.5F, 2.5F, 1.3F, 1, 3, 1,f);
		WingRroot.addChild(WingR3);

		WingR4 = new Modchu_ModelRenderer(this, 4, 1);
		WingR4.addBoxLM(-4.5F, 2F, 1.3F, 1, 3, 1,f);
		WingRroot.addChild(WingR4);

		WingR5 = new Modchu_ModelRenderer(this, 4, 1);
		WingR5.addBoxLM(-3.5F, 2F, 1.3F, 1, 2, 1,f);
		WingRroot.addChild(WingR5);

		WingR6 = new Modchu_ModelRenderer(this, 4, 1);
		WingR6.addBoxLM(-2.8F, 1.5F, 1.3F, 1, 1, 1,f);
		WingRroot.addChild(WingR6);

		Tail3 = new Modchu_ModelRenderer(this, 54, 19);
		Tail3.addBoxLM(0F, 1F, 0F, 0, 8, 2,f);
		Tail3.setRotationPointLM(-0.5F, -6.5F, 4.7F);
		bipedHead.addChild(Tail3);

		Tail4 = new Modchu_ModelRenderer(this, 54, 21);
		Tail4.addBoxLM(0F, 1F, 0F, 2, 8, 0,f);
		Tail4.setRotationPointLM(-1.0F, -6.5F, 5.2F);
		bipedHead.addChild(Tail4);

		Tail5 = new Modchu_ModelRenderer(this, 54, 19);
		Tail5.addBoxLM(0F, 1F, 0F, 0, 8, 2,f);
		Tail5.setRotationPointLM(0.5F, -6.5F, 4.7F);
		bipedHead.addChild(Tail5);

		Tail6 = new Modchu_ModelRenderer(this, 54, 21);
		Tail6.addBoxLM(0F, 1F, 0F, 2, 8, 0,f);
		Tail6.setRotationPointLM(-1.0F, -6.5F, 6.2F);
		bipedHead.addChild(Tail6);

		Ahoge = new Modchu_ModelRenderer(this, 0, 1);
		Ahoge.addBoxLM(0F, 0F, 0F, 0, 3, 4,f);
		Ahoge.setRotationPointLM(0F, -7F, -4F);
		bipedHead.addChild(Ahoge);

		Skirt1 = new Modchu_ModelRenderer(this, 0, 37, Skirt);
		Skirt1.addPlate(-1.6F, -9F, 0F, 22, 9, 0,f);
		Skirt1.setRotationPointLM(0.0F, 2.0F, 0.0F);

		Skirt2 = new Modchu_ModelRenderer(this, 0, 16, Skirt);
		Skirt2.addPlate(-1.6F, 0F, 0F, 22, 9, 0,f);
		Skirt2.setRotationPointLM(0.0F, 2.0F, 0.0F);

		Skirt3 = new Modchu_ModelRenderer(this, 0, 37, Skirt);
		Skirt3.addPlate(0F, -9F, 0F, 22, 9, 0,f);
		Skirt3.setRotationPointLM(0.0F, 1.5F, 0.0F);

		Skirt4 = new Modchu_ModelRenderer(this, 0, 16, Skirt);
		Skirt4.addPlate(0F, 0F, 0F, 22, 9, 0,f);
		Skirt4.setRotationPointLM(0.0F, 1.5F, 0.0F);

		Skirt5 = new Modchu_ModelRenderer(this, 0, 37, Skirt);
		Skirt5.addPlate(0F, -9F, 0F, 22, 9, 0,f);
		Skirt5.setRotationPointLM(0.0F, 1.5F, 0.0F);

		Skirt6 = new Modchu_ModelRenderer(this, 0, 16, Skirt);
		Skirt6.addPlate(0F, 0F, 0F, 22, 9, 0,f);
		Skirt6.setRotationPointLM(0.0F, 1.5F, 0.0F);

		Skirt7 = new Modchu_ModelRenderer(this, 0, 37, Skirt);
		Skirt7.addPlate(-1.6F, -9F, 0F, 22, 9, 0,f);
		Skirt7.setRotationPointLM(0.0F, 2.0F, 0.0F);

		Skirt8 = new Modchu_ModelRenderer(this, 0, 16, Skirt);
		Skirt8.addPlate(-1.6F, 0F, 0F, 22, 9, 0,f);
		Skirt8.setRotationPointLM(0.0F, 2.0F, 0.0F);

		Skirt9 = new Modchu_ModelRenderer(this, 0, 37, Skirt);
		Skirt9.addPlate(-1.6F, -9F, 0F, 22, 9, 0,f);
		Skirt9.setRotationPointLM(0.0F, 2.0F, 0.0F);

		Skirt10 = new Modchu_ModelRenderer(this, 0, 16, Skirt);
		Skirt10.addPlate(-1.6F, 0F, 0F, 22, 9, 0,f);
		Skirt10.setRotationPointLM(0.0F, 2.0F, 0.0F);

		Skirt11 = new Modchu_ModelRenderer(this, 0, 34, Skirt);
		Skirt11.addPlate(0F, -9F, 0F, 22, 9, 0,f);
		Skirt11.setRotationPointLM(0.0F, 1.5F, 0.0F);

		Skirt12 = new Modchu_ModelRenderer(this, 0, 16, Skirt);
		Skirt12.addPlate(0F, 0F, 0F, 22, 9, 0,f);
		Skirt12.setRotationPointLM(0.0F, 1.5F, 0.0F);

		Skirt13 = new Modchu_ModelRenderer(this, 0, 34, Skirt);
		Skirt13.addPlate(0F, -9F, 0F, 22, 9, 0,f);
		Skirt13.setRotationPointLM(0.0F, 1.5F, 0.0F);

		Skirt14 = new Modchu_ModelRenderer(this, 0, 16, Skirt);
		Skirt14.addPlate(0F, 0F, 0F, 22, 9, 0,f);
		Skirt14.setRotationPointLM(0.0F, 1.5F, 0.0F);

		Skirt15 = new Modchu_ModelRenderer(this, 0, 37, Skirt);
		Skirt15.addPlate(-1.6F, -9F, 0F, 22, 9, 0,f);
		Skirt15.setRotationPointLM(0.0F, 2.0F, 0.0F);

		Skirt16 = new Modchu_ModelRenderer(this, 0, 16, Skirt);
		Skirt16.addPlate(-1.6F, 0F, 0F, 22, 9, 0,f);
		Skirt16.setRotationPointLM(0.0F, 2.0F, 0.0F);

		Skirt21 = new Modchu_ModelRenderer(this, 0, 46, Skirt);
		Skirt21.addPlate(-1.6F+22F, -12F, 0F, 22, 12, 0,f);
		Skirt21.setRotationPointLM(0.0F, 2.0F, 0.0F);

		Skirt22 = new Modchu_ModelRenderer(this, 0, 25, Skirt);
		Skirt22.addPlate(-1.6F+22F, 0F, 0F, 22, 12, 0,f);
		Skirt22.setRotationPointLM(0.0F, 2.0F, 0.0F);

		Skirt23 = new Modchu_ModelRenderer(this, 0, 46, Skirt);
		Skirt23.addPlate(0F+22F, -12F, 0F, 22, 12, 0,f);
		Skirt23.setRotationPointLM(0.0F, 1.5F, 0.0F);

		Skirt24 = new Modchu_ModelRenderer(this, 0, 25, Skirt);
		Skirt24.addPlate(0F+22F, 0F, 0F, 22, 12, 0,f);
		Skirt24.setRotationPointLM(0.0F, 1.5F, 0.0F);

		Skirt25 = new Modchu_ModelRenderer(this, 0, 46, Skirt);
		Skirt25.addPlate(0F+22F, -12F, 0F, 22, 12, 0,f);
		Skirt25.setRotationPointLM(0.0F, 1.5F, 0.0F);

		Skirt26 = new Modchu_ModelRenderer(this, 0, 25, Skirt);
		Skirt26.addPlate(0F+22F, 0F, 0F, 22, 12, 0,f);
		Skirt26.setRotationPointLM(0.0F, 1.5F, 0.0F);

		Skirt27 = new Modchu_ModelRenderer(this, 0, 46, Skirt);
		Skirt27.addPlate(-1.6F+22F, -12F, 0F, 22, 12, 0,f);
		Skirt27.setRotationPointLM(0.0F, 2.0F, 0.0F);

		Skirt28 = new Modchu_ModelRenderer(this, 0, 25, Skirt);
		Skirt28.addPlate(-1.6F+22F, 0F, 0F, 22, 12, 0,f);
		Skirt28.setRotationPointLM(0.0F, 2.0F, 0.0F);

		Skirt29 = new Modchu_ModelRenderer(this, 0, 46, Skirt);
		Skirt29.addPlate(-1.6F+22F, -12F, 0F, 22, 12, 0,f);
		Skirt29.setRotationPointLM(0.0F, 2.0F, 0.0F);

		Skirt210 = new Modchu_ModelRenderer(this, 0, 25, Skirt);
		Skirt210.addPlate(-1.6F+22F, 0F, 0F, 22, 12, 0,f);
		Skirt210.setRotationPointLM(0.0F, 2.0F, 0.0F);

		Skirt211 = new Modchu_ModelRenderer(this, 0, 46, Skirt);
		Skirt211.addPlate(0F+22F, -12F, 0F, 22, 12, 0,f);
		Skirt211.setRotationPointLM(0.0F, 1.5F, 0.0F);

		Skirt212 = new Modchu_ModelRenderer(this, 0, 25, Skirt);
		Skirt212.addPlate(0F+22F, 0F, 0F, 22, 12, 0,f);
		Skirt212.setRotationPointLM(0.0F, 1.5F, 0.0F);

		Skirt213 = new Modchu_ModelRenderer(this, 0, 46, Skirt);
		Skirt213.addPlate(0F+22F, -12F, 0F, 22, 12, 0,f);
		Skirt213.setRotationPointLM(0.0F, 1.5F, 0.0F);

		Skirt214 = new Modchu_ModelRenderer(this, 0, 25, Skirt);
		Skirt214.addPlate(0F+22F, 0F, 0F, 22, 12, 0,f);
		Skirt214.setRotationPointLM(0.0F, 1.5F, 0.0F);

		Skirt215 = new Modchu_ModelRenderer(this, 0, 46, Skirt);
		Skirt215.addPlate(-1.6F+22F, -12F, 0F, 22, 12, 0,f);
		Skirt215.setRotationPointLM(0.0F, 2.0F, 0.0F);

		Skirt216 = new Modchu_ModelRenderer(this, 0, 25, Skirt);
		Skirt216.addPlate(-1.6F+22F, 0F, 0F, 22, 12, 0,f);
		Skirt216.setRotationPointLM(0.0F, 2.0F, 0.0F);

		Ribon0 = new Modchu_ModelRenderer(this, 24, 16);
		Ribon0.addBox(-1F, -1F, 0F, 2, 2, 2,f-0.3F);
		Ribon0.setRotationPointLM(0F, 1.8F, 2.5F);
		Ribon0.setRotateAngleDeg(25F, 0F, 0F);
		bipedBody.addChild(Ribon0);

		RibonLU2 = new Modchu_ModelRenderer(this, 1, 58);
		RibonLU2.addBox(-0.5F, -0.5F, -0.5F, 5, 1, 1);
		RibonLU2.setRotationPointLM(0.5F, 0.2F, 1.0F);
		RibonLU2.setRotateAngle(0.7853982F, 0F, -0.1745329F);
		Ribon0.addChild(RibonLU2);

		RibonLU3 = new Modchu_ModelRenderer(this, 2, 58);
		RibonLU3.addBox(0F, -0.5F, -0.5F, 4, 1, 1);
		RibonLU3.setRotationPointLM(0.5F, 0.2F, 1.0F);
		RibonLU3.setRotateAngle(0.7853982F, 0F, 0.1745329F);
		Ribon0.addChild(RibonLU3);

		RibonLU4 = new Modchu_ModelRenderer(this, 2, 58);
		RibonLU4.addBox(-0.5F, -0.5F, -0.5F, 4, 1, 1);
		RibonLU4.setRotationPointLM(0.5F, 0.2F, 1.0F);
		RibonLU4.setRotateAngle(0.7853982F, 0F, 0.5759587F);
		Ribon0.addChild(RibonLU4);

		RibonRU2 = new Modchu_ModelRenderer(this, 1, 58);
		RibonRU2.addBox(-0.5F, -0.5F, -0.5F, 5, 1, 1);
		RibonRU2.setRotationPointLM(-0.5F, 0.2F, 1F);
		RibonRU2.setRotateAngle(-2.356194F, 3.141593F, -0.1745329F);
		Ribon0.addChild(RibonRU2);

		RibonRU3 = new Modchu_ModelRenderer(this, 2, 58);
		RibonRU3.addBox(0F, -0.5F, -0.5F, 4, 1, 1);
		RibonRU3.setRotationPointLM(-0.5F, 0.2F, 1F);
		RibonRU3.setRotateAngle(-2.356194F, 3.141593F, 0.1745329F);
		Ribon0.addChild(RibonRU3);

		RibonRU4 = new Modchu_ModelRenderer(this, 2, 58);
		RibonRU4.addBox(-0.5F, -0.5F, -0.5F, 4, 1, 1);
		RibonRU4.setRotationPointLM(-0.5F, 0.2F, 1F);
		RibonRU4.setRotateAngle(-2.356194F, 3.141593F, 0.5759587F);
		Ribon0.addChild(RibonRU4);

		RibonLD1 = new Modchu_ModelRenderer(this, 1, 58);
		RibonLD1.addBox(0F, -0.5F, -0.5F, 5, 1, 1);
		RibonLD1.setRotationPointLM(-0.5F, -0.3F, 1F);
		RibonLD1.setRotateAngleDeg(-110F, -5F, 27F);
		Ribon0.addChild(RibonLD1);

		RibonLD2 = new Modchu_ModelRenderer(this, 0, 58);
		RibonLD2.addBox(0F, -0.5F, -0.5F, 6, 1, 1);
		RibonLD2.setRotationPointLM(-0.5F, -0.3F, 1F);
		RibonLD2.setRotateAngleDeg(-110F, -13F, 42F);
		Ribon0.addChild(RibonLD2);

		RibonLD3 = new Modchu_ModelRenderer(this, -1, 58);
		RibonLD3.addBox(0F, -0.5F, -0.5F, 7, 1, 1);
		RibonLD3.setRotationPointLM(-0.5F,-0.3F, 1F);
		RibonLD3.setRotateAngleDeg(-110F, -21F, 54F);
		Ribon0.addChild(RibonLD3);

		RibonRD1 = new Modchu_ModelRenderer(this, 3, 58);
		RibonRD1.addBox(0F, -0.5F, -0.5F, 5, 1, 1);
		RibonRD1.setRotationPointLM(0.5F, -0.3F, 1F);
		RibonRD1.setRotateAngleDeg(20F, -175F, 27F);
		Ribon0.addChild(RibonRD1);

		RibonRD2 = new Modchu_ModelRenderer(this, 0, 58);
		RibonRD2.addBox(0F, -0.5F, -0.5F, 6, 1, 1);
		RibonRD2.setRotationPointLM(0.5F, -0.3F, 1F);
		RibonRD2.setRotateAngleDeg(20F, -167F, 42F);
		Ribon0.addChild(RibonRD2);

		RibonRD3 = new Modchu_ModelRenderer(this, -1, 58);
		RibonRD3.addBox(0F, -0.5F, -0.5F, 7, 1, 1);
		RibonRD3.setRotationPointLM(0.5F, -0.3F, 1F);
		RibonRD3.setRotateAngleDeg(20F, -159F, 54F);
		Ribon0.addChild(RibonRD3);

		Circle = new Modchu_ModelRenderer(this, 22, 32);
		Circle.addPlate(-8F, -8F, 0F, 16, 16, 0);
		Circle.setRotationPointLM(0F, -12F, 0F);
		Circle.setRotateAngleDeg(-90F, 1F, 1F);
		bipedHead.addChild(Circle);

		mainFrame = new Modchu_ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, 0F + f1, 0F);
		mainFrame.addChild(bipedHead);
		mainFrame.addChild(bipedBody);

		WingLroot.setRotateAngle(1.5707963F, 0.6108652F, 0F);
		WingL4.setRotateAngle(0F, -0.2792527F, -0.4886922F);
		WingL5.setRotateAngle(0F, -0.2792527F, -0.4886922F);
		WingRroot.setRotateAngle(1.5707963F, -0.6108652F, 0F);
		WingR4.setRotateAngle(0F, 0.2792527F, 0.4886922F);
		WingR5.setRotateAngle(0F, 0.2792527F, 0.4886922F);

		float x = -0.125F;
		float y = 0.0F;
		float z = -0.05F;
		WingR3.setRotationPointLM(x, y, z);
		WingR4.setRotationPointLM(x, y, z);
		WingR5.setRotationPointLM(x, y, z);
		WingR6.setRotationPointLM(x, y, z);

		x = 0.09F;
		y = 0.05F;
		z = -0.09F;
		WingL3.setRotationPointLM(x, y, z);
		WingL4.setRotationPointLM(x, y, z);
		WingL5.setRotationPointLM(x, y, z);
		WingL6.setRotationPointLM(x, y, z);

		WingR2.setRotationPointLM(2.85F, 2.205F, 0.1F);
		WingL2.setRotationPointLM(0.2F, 0.0F, -0.1F);

		WingL2.rotateAngleX = 0.0F;
		WingL2.rotateAngleY = 0.0F;
		WingL2.rotateAngleZ = -0.645F;
		WingL3.rotateAngleX = 5.3F;
		WingL3.rotateAngleY = -0.759F;
		WingL3.rotateAngleZ = -WingL3.rotateAngleY;
		WingL6.rotateAngleX = WingL5.rotateAngleX = WingL4.rotateAngleX = WingL3.rotateAngleX;
		WingL6.rotateAngleY = WingL5.rotateAngleY = WingL4.rotateAngleY = WingL3.rotateAngleY;
		WingL6.rotateAngleZ = WingL5.rotateAngleZ = WingL4.rotateAngleZ = WingL3.rotateAngleZ;

		WingR2.rotateAngleX = 3.141593F;
		WingR2.rotateAngleY = 0.0F;
		WingR2.rotateAngleZ = -2.5F;
		WingR3.rotateAngleX = 5.3F;
		WingR3.rotateAngleY = 0.77F;
		WingR3.rotateAngleZ = -WingR3.rotateAngleY;
		WingR6.rotateAngleX = WingR5.rotateAngleX = WingR4.rotateAngleX = WingR3.rotateAngleX;
		WingR6.rotateAngleY = WingR5.rotateAngleY = WingR4.rotateAngleY = WingR3.rotateAngleY;
		WingR6.rotateAngleZ = WingR5.rotateAngleZ = WingR4.rotateAngleZ = WingR3.rotateAngleZ;

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
		Skirt21.setRotateAngleDeg(-118F, 113F, 47F);
		Skirt22.setRotateAngleDeg(-65F, 113F, 47F);
		Skirt23.setRotateAngleDeg(-122F, 158F, 47F);
		Skirt24.setRotateAngleDeg(-67F, 158F, 47F);
		Skirt25.setRotateAngleDeg(-113F, -159F, 47F);
		Skirt26.setRotateAngleDeg(-58F, -159F, 47F);
		Skirt27.setRotateAngleDeg(-114F, -114F, 47F);
		Skirt28.setRotateAngleDeg(-65F, -114F, 47F);
		Skirt29.setRotateAngleDeg(-115F, -68F, 47F);
		Skirt210.setRotateAngleDeg(-65F, -68F, 47F);
		Skirt211.setRotateAngleDeg(-122F, -23F, 47F);
		Skirt212.setRotateAngleDeg(-66F, -23F, 47F);
		Skirt213.setRotateAngleDeg(-114F, 22F, 47F);
		Skirt214.setRotateAngleDeg(-58F, 22F, 47F);
		Skirt215.setRotateAngleDeg(-115F, 67F, 47F);
		Skirt216.setRotateAngleDeg(-62F, 67F, 47F);

		int i = Modchu_ModelRenderer.ZYX;
		Prim.setRotatePriority(i);
		WingLroot.setRotatePriority(i);
		WingL2.setRotatePriority(i);
		WingRroot.setRotatePriority(i);
		WingR2.setRotatePriority(i);
		i = Modchu_ModelRenderer.YZX;
		WingL3.setRotatePriority(i);
		WingL4.setRotatePriority(i);
		WingL5.setRotatePriority(i);
		WingL6.setRotatePriority(i);
		WingR3.setRotatePriority(i);
		WingR4.setRotatePriority(i);
		WingR5.setRotatePriority(i);
		WingR6.setRotatePriority(i);
		Circle.setRotatePriority(i);
		Glass.setRotatePriority(i);
		RibonRU2.setRotatePriority(i);
		RibonRU3.setRotatePriority(i);
		RibonRU4.setRotatePriority(i);
		RibonRD1.setRotatePriority(i);
		RibonRD2.setRotatePriority(i);
		RibonRD3.setRotatePriority(i);
		RibonLD1.setRotatePriority(i);
		RibonLD2.setRotatePriority(i);
		RibonLD3.setRotatePriority(i);
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

		Circle.setScale(0.35F, 0.35F, 0.35F);
		Glass.setScale(0.5F, 0.5F, 1.0F);
		RibonRU2.setScale(0.8F, 0.8F, 0.8F);
		RibonRU3.setScale(0.8F, 0.8F, 0.8F);
		RibonRU4.setScale(0.8F, 0.8F, 0.8F);
		RibonRD1.setScale(0.8F, 0.8F, 0.8F);
		RibonRD2.setScale(0.8F, 0.8F, 0.8F);
		RibonRD3.setScale(0.8F, 0.8F, 0.8F);
		RibonLD1.setScale(0.8F, 0.8F, 0.8F);
		RibonLD2.setScale(0.8F, 0.8F, 0.8F);
		RibonLD3.setScale(0.8F, 0.8F, 0.8F);

		Skirt1.setScale(0.25F, 0.33F, 1.0F);
		Skirt2.setScale(0.25F, 0.33F, 1.0F);
		Skirt3.setScale(0.25F, 0.33F, 1.0F);
		Skirt4.setScale(0.25F, 0.33F, 1.0F);
		Skirt5.setScale(0.25F, 0.33F, 1.0F);
		Skirt6.setScale(0.25F, 0.33F, 1.0F);
		Skirt7.setScale(0.25F, 0.33F, 1.0F);
		Skirt8.setScale(0.25F, 0.33F, 1.0F);
		Skirt9.setScale(0.25F, 0.33F, 1.0F);
		Skirt10.setScale(0.25F, 0.33F, 1.0F);
		Skirt11.setScale(0.25F, 0.33F, 1.0F);
		Skirt12.setScale(0.25F, 0.33F, 1.0F);
		Skirt13.setScale(0.25F, 0.33F, 1.0F);
		Skirt14.setScale(0.25F, 0.33F, 1.0F);
		Skirt15.setScale(0.25F, 0.33F, 1.0F);
		Skirt16.setScale(0.25F, 0.33F, 1.0F);
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

		actionPartsInit(f, f1);
	}

    @Override
    public void skirtFloatsInit(float f, float f1) {
    }

	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);
		Ribon0.setRotationPointLM(0F, 0.8F, 1.5F);

		WingLroot.rotateAngleX=1.570796313F;
		WingRroot.rotateAngleX=1.570796313F;
		WingLroot.rotateAngleY=MathHelper.cos(f2 * 0.5F) * 0.22F + 0.35F;
		WingRroot.rotateAngleY=-WingLroot.rotateAngleY;

		Ahoge.rotateAngleY = MathHelper.cos(f2 * 0.2F + MathHelper.cos(f2 * 0.05F + (float)IdOffset) * 1.0F) * 0.2F;
		Ahoge.rotateAngleX=2.9F;

		Tail3.rotateAngleX=-bipedHead.rotateAngleX;
		Tail4.rotateAngleX=-bipedHead.rotateAngleX;
		Tail5.rotateAngleX=-bipedHead.rotateAngleX;
		Tail6.rotateAngleX=-bipedHead.rotateAngleX;

		if (getCapsValueBoolean(caps_aimedBow)) {
			WingLroot.rotateAngleX+= 0.5F;
			WingRroot.rotateAngleX+= 0.5F;
			WingLroot.rotateAngleY= -0.3F;
			WingRroot.rotateAngleY= 0.3F;
		}

		if(getCapsValueBoolean(caps_getIsSneak)){
			Skirt.rotationPointZ = -0.5F;
		} else {
			Skirt.rotationPointZ = 0.0F;
		}
		Skirt.rotationPointY = -4.5F;
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
		Skirt21.setRotateAngleDeg(-118F, 113F, 47F);
		Skirt22.setRotateAngleDeg(-65F, 113F, 47F);
		Skirt23.setRotateAngleDeg(-122F, 158F, 47F);
		Skirt24.setRotateAngleDeg(-67F, 158F, 47F);
		Skirt25.setRotateAngleDeg(-113F, -159F, 47F);
		Skirt26.setRotateAngleDeg(-58F, -159F, 47F);
		Skirt27.setRotateAngleDeg(-114F, -114F, 47F);
		Skirt28.setRotateAngleDeg(-65F, -114F, 47F);
		Skirt29.setRotateAngleDeg(-115F, -68F, 47F);
		Skirt210.setRotateAngleDeg(-65F, -68F, 47F);
		Skirt211.setRotateAngleDeg(-122F, -23F, 47F);
		Skirt212.setRotateAngleDeg(-66F, -23F, 47F);
		Skirt213.setRotateAngleDeg(-114F, 22F, 47F);
		Skirt214.setRotateAngleDeg(-58F, 22F, 47F);
		Skirt215.setRotateAngleDeg(-115F, 67F, 47F);
		Skirt216.setRotateAngleDeg(-62F, 67F, 47F);

		float f6 = -motionY * 2.0F;
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
    public void setArmorBipedHeadShowModel(boolean b) {
    	bipedHead.isHidden = !b;
    	super.setArmorBipedHeadShowModel(b);
    }

    @Override
    public void setArmorSkirtShowModel(boolean b) {
    	super.setArmorSkirtShowModel(b);
    	Skirt.isHidden = !b;
    }
}
