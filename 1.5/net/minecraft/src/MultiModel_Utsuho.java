package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class MultiModel_Utsuho extends MultiModel_SR2 {

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
	public Modchu_ModelRenderer SideTailL2;
	public Modchu_ModelRenderer SideTailR2;
	public Modchu_ModelRenderer Tail2;
	public Modchu_ModelRenderer Bust1;
	public Modchu_ModelRenderer Bust2;
	public Modchu_ModelRenderer Bust3;
	public Modchu_ModelRenderer Bust4;
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
	public Modchu_ModelRenderer Circle1;
	public Modchu_ModelRenderer Circle2;
	public Modchu_ModelRenderer Ribon0;
	public Modchu_ModelRenderer RibonLU1;
	public Modchu_ModelRenderer RibonLU2;
	public Modchu_ModelRenderer RibonLU3;
	public Modchu_ModelRenderer RibonLU4;
	public Modchu_ModelRenderer RibonRU1;
	public Modchu_ModelRenderer RibonRU2;
	public Modchu_ModelRenderer RibonRU3;
	public Modchu_ModelRenderer RibonRU4;
	public Modchu_ModelRenderer RibonLD1;
	public Modchu_ModelRenderer RibonLD2;
	public Modchu_ModelRenderer RibonLD3;
	public Modchu_ModelRenderer RibonRD1;
	public Modchu_ModelRenderer RibonRD2;
	public Modchu_ModelRenderer RibonRD3;
	public Modchu_ModelRenderer CS1;
	public Modchu_ModelRenderer CS2;
	public Modchu_ModelRenderer CS3;
	public Modchu_ModelRenderer CS4;
	public Modchu_ModelRenderer CS5;
	public Modchu_ModelRenderer CS6;
	public Modchu_ModelRenderer CS7;
	public Modchu_ModelRenderer CS8;
	public Modchu_ModelRenderer CS9;
	public Modchu_ModelRenderer RightShoo;
	public Modchu_ModelRenderer HipR;
	public Modchu_ModelRenderer HipL;

	private float x1;
	private float y1;
	private float z1;
	private float IdOffset;


	public MultiModel_Utsuho()
	{
		this(0.0F);
	}

	public MultiModel_Utsuho(float f)
	{
		this(f, 0.0F);
	}

	public MultiModel_Utsuho(float f, float f1)
	{
		this(f, f1 , 64, 64);
	}

	public MultiModel_Utsuho(float f, float f1, int i, int j) {
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
		bipedHeadwear = new Modchu_ModelRenderer(this, 24, 0);
		bipedHeadwear.addBox(-4F, 0.0F, 0.0F, 8, 4, 4, f);
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
		Skirt.setRotationPoint(0.0F, 4.0F, 0.0F);
		bipedBody.addChild(Skirt);

		CS1 = new Modchu_ModelRenderer(this, 0, 20);
		CS1.addBox(-1.0F, 0F, -0.3F, 2, 7, 2, f);
		CS1.setRotationPointLM(0.0F, 4.0F, 0.0F);
		CS1.setRotateAngleDeg(0F,30F,0F);
		bipedLeftArm.addChild(CS1);

		CS2 = new Modchu_ModelRenderer(this, 0, 20);
		CS2.addBox(-1.0F, 0F, -0.3F, 2, 7, 2, f);
		CS2.setRotationPointLM(0.0F, 4.0F, 0.0F);
		CS2.setRotateAngleDeg(0F,90F,0F);
		bipedLeftArm.addChild(CS2);

		CS3 = new Modchu_ModelRenderer(this, 0, 20);
		CS3.addBox(-1.0F, 0F, -0.3F, 2, 7, 2, f);
		CS3.setRotationPointLM(0.0F, 4.0F, 0.0F);
		CS3.setRotateAngleDeg(0F,150F,0F);
		bipedLeftArm.addChild(CS3);

		CS4 = new Modchu_ModelRenderer(this, 0, 20);
		CS4.addBox(-1.0F, 0F, -0.3F, 2, 7, 2, f);
		CS4.setRotationPointLM(0.0F, 4.0F, 0.0F);
		CS4.setRotateAngleDeg(0F,-30F,0F);
		bipedLeftArm.addChild(CS4);

		CS5 = new Modchu_ModelRenderer(this, 0, 20);
		CS5.addBox(-1.0F, 0F, -0.3F, 2, 7, 2, f);
		CS5.setRotationPointLM(0.0F, 4.0F, 0.0F);
		CS5.setRotateAngleDeg(0F,-90F,0F);
		bipedLeftArm.addChild(CS5);

		CS6 = new Modchu_ModelRenderer(this, 0, 20);
		CS6.addBox(-1.0F, 0F, -0.3F, 2, 7, 2, f);
		CS6.setRotationPointLM(0.0F, 4.0F, 0.0F);
		CS6.setRotateAngleDeg(0.0F,-150F,0F);
		bipedLeftArm.addChild(CS6);

		CS7 = new Modchu_ModelRenderer(this, 8, 20);
		CS7.addBox(-0.5F, -4F, -0.5F, 1, 8, 1, f);
		CS7.setRotationPointLM(0.0F, 10.0F, 0.0F);
		CS7.setRotateAngleDeg(0F,-60F,90F);
		bipedLeftArm.addChild(CS7);

		CS8 = new Modchu_ModelRenderer(this, 8, 20);
		CS8.addBox(-0.5F, -4F, -0.5F, 1, 8, 1, f);
		CS8.setRotationPointLM(0.0F, 10.0F, 0.0F);
		CS8.setRotateAngleDeg(0F,0F,90F);
		bipedLeftArm.addChild(CS8);

		CS9 = new Modchu_ModelRenderer(this, 8, 20);
		CS9.addBox(-0.5F, -4F, -0.5F, 1, 8, 1, f);
		CS9.setRotationPointLM(0.0F, 10.0F, 0F);
		CS9.setRotateAngleDeg(0F,60F,90F);
		bipedLeftArm.addChild(CS9);

		RightShoo = new Modchu_ModelRenderer(this, 0, 42);
		RightShoo.mirror=true;
		RightShoo.addBox(-3.5F, 0.2F, -2.5F, 4, 6, 5, f);
		RightShoo.setRotationPointLM(1.5F, 3.0F, 0.0F);
		bipedRightLeg.addChild(RightShoo);

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

		eyeR = new Modchu_ModelRenderer(this, 32, 19);
		eyeR.addPlate(-4.0F, -5.0F, -4.001F, 4, 4, 0, f);
		eyeR.setRotationPointLM(0.0F, 0.0F, 0.0F);
		eyeL = new Modchu_ModelRenderer(this, 42, 19);
		eyeL.addPlate(0.0F, -5.0F, -4.001F, 4, 4, 0, f);
		eyeL.setRotationPointLM(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(eyeR);
		bipedHead.addChild(eyeL);

		Prim = new Modchu_ModelRenderer(this, 24, 16);
		Prim.addBoxLM(-2F, -7.7F, -3.5F, 4, 1, 0, f);
		Prim.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(Prim);

		Circle1 = new Modchu_ModelRenderer(this, 25, 0);
		Circle1.addBall(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		Circle1.setRotationPointLM(0F,0F,0F);
		Circle1.setRotateAngleDeg(45F,45F,0F);
		bipedLeftLeg.addChild(Circle1);
		x1=1F;
		y1=6F;
		z1=0F;

		Circle2 = new Modchu_ModelRenderer(this, 25, 0);
		Circle2.addBall(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		Circle2.setRotationPointLM(0F,0F,0F);
		Circle2.setRotateAngleDeg(45F,45F,0F);
		bipedLeftLeg.addChild(Circle2);

		WingLroot = new Modchu_ModelRenderer(this, 0, 0);
		WingLroot.mirror=true;
		WingLroot.addBoxLM(-0.5F, 0F, -0.5F, 1, 3, 1,f);
		WingLroot.setRotationPointLM(0.4F, -1.0F, 1.2F);
		bipedBody.addChild(WingLroot);

		WingL2 = new Modchu_ModelRenderer(this, 0, 0);
		WingL2.mirror=true;
		WingL2.addBoxLM(-2.4F, 2F, -0.4F, 1, 4, 1,f);
		WingLroot.addChild(WingL2);

		WingL3 = new Modchu_ModelRenderer(this, 0, 0);
		WingL3.mirror=true;
		WingL3.addBoxLM(4.5F, 2.5F, 1.3F, 1, 3, 1,f);
		WingLroot.addChild(WingL3);

		WingL4 = new Modchu_ModelRenderer(this, 0, 0);
		WingL4.mirror=true;
		WingL4.addBoxLM(3.5F, 2F, 1.3F, 1, 3, 1,f);
		WingLroot.addChild(WingL4);

		WingL5 = new Modchu_ModelRenderer(this, 0, 0);
		WingL5.mirror=true;
		WingL5.addBoxLM(2.5F, 2F, 1.3F, 1, 2, 1,f);
		WingLroot.addChild(WingL5);

		WingL6 = new Modchu_ModelRenderer(this, 0, 0);
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

		WingR3 = new Modchu_ModelRenderer(this, 0, 0);
		WingR3.addBoxLM(-5.5F, 2.5F, 1.3F, 1, 3, 1,f);
		WingRroot.addChild(WingR3);

		WingR4 = new Modchu_ModelRenderer(this, 0, 0);
		WingR4.addBoxLM(-4.5F, 2F, 1.3F, 1, 3, 1,f);
		WingRroot.addChild(WingR4);

		WingR5 = new Modchu_ModelRenderer(this, 0, 0);
		WingR5.addBoxLM(-3.5F, 2F, 1.3F, 1, 2, 1,f);
		WingRroot.addChild(WingR5);

		WingR6 = new Modchu_ModelRenderer(this, 0, 0);
		WingR6.addBoxLM(-2.8F, 1.5F, 1.3F, 1, 1, 1,f);
		WingRroot.addChild(WingR6);

		Tail = new Modchu_ModelRenderer(this, 46, 19);
		Tail.addBox(-1F, -8.5F, 5.9F, 2, 2, 2,f+0.1F);
		Tail.setRotationPoint(0.0F, 0.8F, 0.0F);
		bipedHead.addChild(Tail);

		Tail2 = new Modchu_ModelRenderer(this, 46, 19);
		Tail2.addBoxLM(-1F, -6.4F, 5.9F, 2, 5, 2,f);
		Tail2.setRotationPoint(0.0F, 0.8F, 0.0F);
		bipedHead.addChild(Tail2);

		Bust1 = new Modchu_ModelRenderer(this, 54, 17);
		Bust1.addBoxLM(-1.5F, -1.5F, 0F, 3, 3, 1,f);
		Bust1.setRotationPointLM(0F, -1.5F, -2.5F);
		bipedBody.addChild(Bust1);

		Bust2 = new Modchu_ModelRenderer(this, 0, 0);
		Bust2.addBoxLM(-1F, 0F, 0F, 1, 1, 1,f);
		Bust2.setRotationPointLM(0F, -2.0F, -2.7F);
		Bust2.setRotateAngleDeg(-45F, 90F, 79F);
		bipedBody.addChild(Bust2);

		Bust3 = new Modchu_ModelRenderer(this, 0, 0);
		Bust3.addBoxLM(0F, 0F, 0F, 1, 1, 1,f);
		Bust3.setRotationPointLM(0F, -2.0F, -2.7F);
		Bust3.setRotateAngleDeg(-45F, 90F, 90F);
		bipedBody.addChild(Bust3);

		Bust4 = new Modchu_ModelRenderer(this, 0, 0);
		Bust4.addBoxLM(0F, 0F, 0F, 1, 1, 1,f);
		Bust4.setRotationPointLM(0F, -1.0F, -2.7F);
		Bust4.setRotateAngleDeg(-45F, 90F, 101F);
		bipedBody.addChild(Bust4);

		Ahoge = new Modchu_ModelRenderer(this, 0, 1);
		Ahoge.addBoxLM(0F, 0F, 0F, 0, 3, 4,f);
		Ahoge.setRotationPoint(0F, -7F, -4F);
		bipedHead.addChild(Ahoge);

		Skirt1 = new Modchu_ModelRenderer(this, -2, 32, Skirt);
		Skirt1.addBoxLM(0F, 0F, 0F, 12, 4, 4,f);
		Skirt1.setRotationPointLM(2.4F,-3F,-0.6F);

		Skirt2 = new Modchu_ModelRenderer(this, -2, 32, Skirt);
		Skirt2.addBoxLM(0F, 0F, 0F, 12, 4, 4,f);
		Skirt2.setRotationPointLM(2F,-3F,-1.2F);

		Skirt3 = new Modchu_ModelRenderer(this, -6, 32, Skirt);
		Skirt3.addBoxLM(0F, 0F, 0F, 16, 4, 4,f);
		Skirt3.setRotationPointLM(0F,-4F,0F);

		Skirt4 = new Modchu_ModelRenderer(this, -6, 32, Skirt);
		Skirt4.addBoxLM(0F, 0F, 0F, 16, 4, 4,f);
		Skirt4.setRotationPointLM(0F,-4F,0F);

		Skirt5 = new Modchu_ModelRenderer(this, -2, 32, Skirt);
		Skirt5.addBoxLM(0F, 0F, 0F, 12, 4, 4,f);
		Skirt5.setRotationPointLM(-2F,-3F,-1.2F);

		Skirt6 = new Modchu_ModelRenderer(this, -2, 32, Skirt);
		Skirt6.addBoxLM(0F, 0F, 0F, 12, 4, 4,f);
		Skirt6.setRotationPointLM(-2.4F, -3F, -0.6F);

		Skirt7 = new Modchu_ModelRenderer(this, -2, 32, Skirt);
		Skirt7.addBoxLM(0F, 0F, 0F, 12, 4, 4,f);
		Skirt7.setRotationPointLM(-2.4F,-3F,0.6F);

		Skirt8 = new Modchu_ModelRenderer(this, -2, 32, Skirt);
		Skirt8.addBoxLM(0F, 0F, 0F, 12, 4, 4,f);
		Skirt8.setRotationPointLM(-2F,-3F,1.2F);

		Skirt9 = new Modchu_ModelRenderer(this, -6, 32, Skirt);
		Skirt9.addBoxLM(0F, 0F, 0F, 16, 4, 4,f);
		Skirt9.setRotationPointLM(0F,-4F,0F);

		Skirt10 = new Modchu_ModelRenderer(this, -6, 32, Skirt);
		Skirt10.addBoxLM(0F, 0F, 0F, 16, 4, 4,f);
		Skirt10.setRotationPointLM(0F,-4F,0F);

		Skirt11 = new Modchu_ModelRenderer(this, -2, 32, Skirt);
		Skirt11.addBoxLM(0F, 0F, 0F, 12, 4, 4,f);
		Skirt11.setRotationPointLM(2F,-3F,1.2F);

		Skirt12 = new Modchu_ModelRenderer(this, -2, 32, Skirt);
		Skirt12.addBoxLM(0F, 0F, 0F, 12, 4, 4,f);
		Skirt12.setRotationPointLM(2.4F,-3F,0.6F);

		Ribon0 = new Modchu_ModelRenderer(this, 0, 16);
		Ribon0.addBox(-1F, -1F, 0F, 2, 2, 2);
		Ribon0.setRotationPoint(0F, -7.2F, 4F);
		Ribon0.setRotateAngleDeg(10F, 0F, 0F);
		bipedHead.addChild(Ribon0);

		RibonLU1 = new Modchu_ModelRenderer(this, 1, 40);
		RibonLU1.addBox(0F, -0.5F, -0.5F, 5, 1, 1);
		RibonLU1.setRotationPointLM(0.5F,0.2F,1F);
		RibonLU1.setRotateAngle(0.7853982F, 0F, -0.4886922F);
		Ribon0.addChild(RibonLU1);

		RibonLU2 = new Modchu_ModelRenderer(this, 1, 40);
		RibonLU2.addBox(-0.5F, -0.5F, -0.5F, 5, 1, 1);
		RibonLU2.setRotationPoint(0.5F, -7F, 5F);
		RibonLU2.setRotateAngle(0.7853982F, 0F, -0.1745329F);
		bipedHead.addChild(RibonLU2);

		RibonLU3 = new Modchu_ModelRenderer(this, 2, 40);
		RibonLU3.addBox(0F, -0.5F, -0.5F, 4, 1, 1);
		RibonLU3.setRotationPoint(0.5F, -7F, 5F);
		RibonLU3.setRotateAngle(0.7853982F, 0F, 0.1745329F);
		bipedHead.addChild(RibonLU3);

		RibonLU4 = new Modchu_ModelRenderer(this, 2, 40);
		RibonLU4.addBox(-0.5F, -0.5F, -0.5F, 4, 1, 1);
		RibonLU4.setRotationPoint(0.0F, -7.5F, 4.5F);
		RibonLU4.setRotateAngle(0.7853982F, 0F, 0.5759587F);
		bipedHead.addChild(RibonLU4);

		RibonRU1 = new Modchu_ModelRenderer(this, 1, 40);
		RibonRU1.addBox(0F, -0.5F, -0.5F, 5, 1, 1);
		RibonRU1.setRotationPointLM(-0.5F, 0.2F, 1F);
		RibonRU1.setRotateAngle(-2.356194F, 3.141593F, -0.4886922F);
		Ribon0.addChild(RibonRU1);

		RibonRU2 = new Modchu_ModelRenderer(this, 1, 40);
		RibonRU2.addBox(-0.5F, -0.5F, -0.5F, 5, 1, 1);
		RibonRU2.setRotationPointLM(-0.5F, 0.2F, 1F);
		RibonRU2.setRotateAngle(-2.356194F, 3.141593F, -0.1745329F);
		Ribon0.addChild(RibonRU2);

		RibonRU3 = new Modchu_ModelRenderer(this, 2, 40);
		RibonRU3.addBox(0F, -0.5F, -0.5F, 4, 1, 1);
		RibonRU3.setRotationPointLM(-0.5F, 0.2F, 1F);
		RibonRU3.setRotateAngle(-2.356194F, 3.141593F, 0.1745329F);
		Ribon0.addChild(RibonRU3);

		RibonRU4 = new Modchu_ModelRenderer(this, 2, 40);
		RibonRU4.addBox(-0.5F, -0.5F, -0.5F, 4, 1, 1);
		RibonRU4.setRotationPointLM(-0.5F, 0.2F, 1F);
		RibonRU4.setRotateAngle(-2.356194F, 3.141593F, 0.5759587F);
		Ribon0.addChild(RibonRU4);

		RibonLD1 = new Modchu_ModelRenderer(this, 1, 40);
		RibonLD1.addBox(0F, -0.5F, -0.5F, 5, 1, 1);
		RibonLD1.setRotationPointLM(-0.5F, -0.3F, 1F);
		RibonLD1.setRotateAngleDeg(-110F, -5F, 27F);
		bipedHead.addChild(RibonLD1);

		RibonLD2 = new Modchu_ModelRenderer(this, 0, 40);
		RibonLD2.addBox(0F, -0.5F, -0.5F, 6, 1, 1);
		RibonLD2.setRotationPointLM(-0.5F, -0.3F, 1F);
		RibonLD2.setRotateAngleDeg(-110F, -13F, 42F);
		Ribon0.addChild(RibonLD2);

		RibonLD3 = new Modchu_ModelRenderer(this, -1, 40);
		RibonLD3.addBox(0F, -0.5F, -0.5F, 7, 1, 1);
		RibonLD3.setRotationPointLM(-0.5F,-0.3F, 1F);
		RibonLD3.setRotateAngleDeg(-110F, -21F, 54F);
		Ribon0.addChild(RibonLD3);

		RibonRD1 = new Modchu_ModelRenderer(this, 3, 40);
		RibonRD1.addBox(0F, -0.5F, -0.5F, 5, 1, 1);
		RibonRD1.setRotationPointLM(0.5F, -0.3F, 1F);
		RibonRD1.setRotateAngleDeg(20F, -175F, 27F);
		Ribon0.addChild(RibonRD1);

		RibonRD2 = new Modchu_ModelRenderer(this, 0, 40);
		RibonRD2.addBox(0F, -0.5F, -0.5F, 6, 1, 1);
		RibonRD2.setRotationPointLM(0.5F, -0.3F, 1F);
		RibonRD2.setRotateAngleDeg(20F, -167F, 42F);
		Ribon0.addChild(RibonRD2);

		RibonRD3 = new Modchu_ModelRenderer(this, -1, 40);
		RibonRD3.addBox(0F, -0.5F, -0.5F, 7, 1, 1);
		RibonRD3.setRotationPointLM(0.5F, -0.3F, 1F);
		RibonRD3.setRotateAngleDeg(20F, -159F, 54F);
		Ribon0.addChild(RibonRD3);

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

		Skirt1.setRotateAngle(-0.7853982F, 0.2268928F, 0.8203047F);
		Skirt2.setRotateAngle(-0.7853982F, 0.9075712F, 0.8203047F);
		Skirt3.setRotateAngle(-0.7853982F, 1.308997F, 0.715585F);
		Skirt4.setRotateAngle(-0.7853982F, 1.832596F, 0.715585F);
		Skirt5.setRotateAngle(-0.7853982F, 2.181662F, 0.8203047F);
		Skirt6.setRotateAngle(-0.7853982F, 2.844887F, 0.8203047F);
		Skirt7.setRotateAngle(-0.7853982F, -2.941752F, 0.8203047F);
		Skirt8.setRotateAngle(-0.7853982F, -2.275037F, 0.8203047F);
		Skirt9.setRotateAngle(-0.7853982F, -1.885828F, 0.715585F);
		Skirt10.setRotateAngle(-0.7853982F, -1.33954F, 0.715585F);
		Skirt11.setRotateAngle(-0.7853982F, -0.9677851F, 0.8203047F);
		Skirt12.setRotateAngle(-0.7853982F, -0.299324F, 0.8203047F);

		int i = Modchu_ModelRenderer.ZYX;
		Circle1.setRotatePriority(i);
		Circle2.setRotatePriority(i);
		Prim.setRotatePriority(i);
		Tail2.setRotatePriority(i);
		Bust1.setRotatePriority(i);
		WingLroot.setRotatePriority(i);
		WingL2.setRotatePriority(i);
		WingRroot.setRotatePriority(i);
		WingR2.setRotatePriority(i);
		RightShoo.setRotatePriority(i);
		CS1.setRotatePriority(i);
		CS2.setRotatePriority(i);
		CS3.setRotatePriority(i);
		CS4.setRotatePriority(i);
		CS5.setRotatePriority(i);
		CS6.setRotatePriority(i);
		i = Modchu_ModelRenderer.YZX;
		CS7.setRotatePriority(i);
		CS8.setRotatePriority(i);
		CS9.setRotatePriority(i);
		WingL3.setRotatePriority(i);
		WingL4.setRotatePriority(i);
		WingL5.setRotatePriority(i);
		WingL6.setRotatePriority(i);
		WingR3.setRotatePriority(i);
		WingR4.setRotatePriority(i);
		WingR5.setRotatePriority(i);
		WingR6.setRotatePriority(i);
		Bust2.setRotatePriority(i);
		Bust3.setRotatePriority(i);
		Bust4.setRotatePriority(i);
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
		Skirt12.setRotatePriority(i);
		RibonLU1.setRotatePriority(i);
		RibonLU2.setRotatePriority(i);
		RibonLU3.setRotatePriority(i);
		RibonLU4.setRotatePriority(i);
		RibonLD1.setRotatePriority(i);
		RibonLD2.setRotatePriority(i);
		RibonLD3.setRotatePriority(i);
		RibonRU1.setRotatePriority(i);
		RibonRU2.setRotatePriority(i);
		RibonRU3.setRotatePriority(i);
		RibonRU4.setRotatePriority(i);
		RibonRD1.setRotatePriority(i);
		RibonRD2.setRotatePriority(i);
		RibonRD3.setRotatePriority(i);
		HipR.setRotatePriority(i);
		HipL.setRotatePriority(i);

		Skirt1.setScale(0.5F, 0.5F, 0.5F);
		Skirt2.setScale(0.5F, 0.5F, 0.5F);
		Skirt3.setScale(0.5F, 0.5F, 0.5F);
		Skirt4.setScale(0.5F, 0.5F, 0.5F);
		Skirt5.setScale(0.5F, 0.5F, 0.5F);
		Skirt6.setScale(0.5F, 0.5F, 0.5F);
		Skirt7.setScale(0.5F, 0.5F, 0.5F);
		Skirt8.setScale(0.5F, 0.5F, 0.5F);
		Skirt9.setScale(0.5F, 0.5F, 0.5F);
		Skirt10.setScale(0.5F, 0.5F, 0.5F);
		Skirt11.setScale(0.5F, 0.5F, 0.5F);
		Skirt12.setScale(0.5F, 0.5F, 0.5F);
		CS7.setScale(0.5F, 0.5F, 0.5F);
		CS8.setScale(0.5F, 0.5F, 0.5F);
		CS9.setScale(0.5F, 0.5F, 0.5F);
		actionPartsInit(f, f1);
	}

    @Override
    public void skirtFloatsInit(float f, float f1) {
    }

	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);

		WingLroot.rotateAngleX=1.570796313F;
		WingRroot.rotateAngleX=1.570796313F;
		WingLroot.rotateAngleY=MathHelper.cos(f2 * 0.5F) * 0.22F + 0.35F;
		WingRroot.rotateAngleY=-WingLroot.rotateAngleY;
		Ahoge.rotateAngleY = MathHelper.cos(f2 * 0.2F + MathHelper.cos(f2 * 0.05F + IdOffset) * 1.0F) * 0.2F;
		Ahoge.rotateAngleX = 2.9F;
		Circle1.rotationPointX = x1 + MathHelper.cos(f2 * 0.3F + IdOffset) * 3F;
		Circle1.rotationPointZ = z1 + MathHelper.cos(f2 * 0.3F + ((float)Math.PI / 2F) + IdOffset) * 3F;
		Circle1.rotationPointY = y1 + MathHelper.cos(f2 * 0.37F + IdOffset) * 1.5F;
		Circle2.rotationPointX = x1 + MathHelper.cos(f2 * 0.3F + 2.5F + IdOffset) * 3F;
		Circle2.rotationPointZ = z1 + MathHelper.cos(f2 * 0.3F + 2.5F + ((float)Math.PI / 2F) + IdOffset) * 3F;
		Circle2.rotationPointY = y1 - MathHelper.cos(f2 * 0.37F + 2.5F + IdOffset) * 1.5F;

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
		Skirt.rotationPointY = 3.0F;
		Skirt.rotateAngleX = 0.0F;
		skirtFloats(f, f1, f2, f3, f4, f5, entity);
	}

	@Override
	public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		if (!getCapsValueBoolean(caps_skirtFloats)) return;
    	float motionY = getCapsValueFloat(caps_motionY);
		Skirt1.setRotateAngle(-0.7853982F, 0.2268928F, 0.8203047F);
		Skirt2.setRotateAngle(-0.7853982F, 0.9075712F, 0.8203047F);
		Skirt3.setRotateAngle(-0.7853982F, 1.308997F, 0.715585F);
		Skirt4.setRotateAngle(-0.7853982F, 1.832596F, 0.715585F);
		Skirt5.setRotateAngle(-0.7853982F, 2.181662F, 0.8203047F);
		Skirt6.setRotateAngle(-0.7853982F, 2.844887F, 0.8203047F);
		Skirt7.setRotateAngle(-0.7853982F, -2.941752F, 0.8203047F);
		Skirt8.setRotateAngle(-0.7853982F, -2.275037F, 0.8203047F);
		Skirt9.setRotateAngle(-0.7853982F, -1.885828F, 0.715585F);
		Skirt10.setRotateAngle(-0.7853982F, -1.33954F, 0.715585F);
		Skirt11.setRotateAngle(-0.7853982F, -0.9677851F, 0.8203047F);
		Skirt12.setRotateAngle(-0.7853982F, -0.299324F, 0.8203047F);

      	float f6 = -motionY;
		Skirt1.rotationPointY = -3F + f6;
		Skirt2.rotationPointY = -3F + f6;
		Skirt3.rotationPointY = -4F + f6;
		Skirt4.rotationPointY = -4F + f6;
		Skirt5.rotationPointY = -3F + f6;
		Skirt6.rotationPointY = -3F + f6;
		Skirt7.rotationPointY = -3F + f6;
		Skirt8.rotationPointY = -3F + f6;
		Skirt9.rotationPointY = -4F + f6;
		Skirt10.rotationPointY = -4F + f6;
		Skirt11.rotationPointY = -3F + f6;
		Skirt12.rotationPointY = -3F + f6;

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
	}

	@Override
	public void actionInit1() {
		super.actionInit1();
		((Modchu_ModelRenderer) bipedLeftArm).removeChild(CS1);
		((Modchu_ModelRenderer) bipedLeftArm).removeChild(CS2);
		((Modchu_ModelRenderer) bipedLeftArm).removeChild(CS3);
		((Modchu_ModelRenderer) bipedLeftArm).removeChild(CS4);
		((Modchu_ModelRenderer) bipedLeftArm).removeChild(CS5);
		((Modchu_ModelRenderer) bipedLeftArm).removeChild(CS6);
		((Modchu_ModelRenderer) bipedLeftArm).removeChild(CS7);
		((Modchu_ModelRenderer) bipedLeftArm).removeChild(CS8);
		((Modchu_ModelRenderer) bipedLeftArm).removeChild(CS9);
		((Modchu_ModelRenderer) bipedRightLeg).removeChild(RightShoo);
		((Modchu_ModelRenderer) bipedRightLeg).removeChild(HipR);
		((Modchu_ModelRenderer) bipedLeftLeg).removeChild(HipL);
		((Modchu_ModelRenderer) bipedLeftLeg).removeChild(Circle1);
		((Modchu_ModelRenderer) bipedLeftLeg).removeChild(Circle2);
		rightLeg2.addChild(RightShoo);
		//rightLeg.addChild(HipR);
		//rightLeg.addChild(HipL);
		leftLeg2.addChild(Circle1);
		leftLeg2.addChild(Circle2);
		leftArm2.addChild(CS1);
		leftArm2.addChild(CS2);
		leftArm2.addChild(CS3);
		leftArm2.addChild(CS4);
		leftArm2.addChild(CS5);
		leftArm2.addChild(CS6);
		leftArm2.addChild(CS7);
		leftArm2.addChild(CS8);
		leftArm2.addChild(CS9);
		CS1.rotationPointY = CS2.rotationPointY = CS3.rotationPointY =
				CS4.rotationPointY = CS5.rotationPointY = CS6.rotationPointY = 0.5F;
		CS7.rotationPointY = CS8.rotationPointY = CS9.rotationPointY = 6.0F;
		Circle1.rotationPointY = -3.0F;
		Circle2.rotationPointY = -3.0F;
		RightShoo.rotationPointY = 0.0F;
	}

    @Override
    public void actionRelease1() {
    	super.actionRelease1();
    	((Modchu_ModelRenderer) rightLeg2).removeChild(RightShoo);
    	((Modchu_ModelRenderer) leftLeg2).removeChild(Circle1);
    	((Modchu_ModelRenderer) leftLeg2).removeChild(Circle2);
    	((Modchu_ModelRenderer) leftArm2).removeChild(CS1);
    	((Modchu_ModelRenderer) leftArm2).removeChild(CS2);
    	((Modchu_ModelRenderer) leftArm2).removeChild(CS3);
    	((Modchu_ModelRenderer) leftArm2).removeChild(CS4);
    	((Modchu_ModelRenderer) leftArm2).removeChild(CS5);
    	((Modchu_ModelRenderer) leftArm2).removeChild(CS6);
    	((Modchu_ModelRenderer) leftArm2).removeChild(CS7);
    	((Modchu_ModelRenderer) leftArm2).removeChild(CS8);
    	((Modchu_ModelRenderer) leftArm2).removeChild(CS9);
    	bipedLeftArm.addChild(CS1);
    	bipedLeftArm.addChild(CS2);
    	bipedLeftArm.addChild(CS3);
    	bipedLeftArm.addChild(CS4);
    	bipedLeftArm.addChild(CS5);
    	bipedLeftArm.addChild(CS6);
    	bipedLeftArm.addChild(CS7);
    	bipedLeftArm.addChild(CS8);
    	bipedLeftArm.addChild(CS9);
    	bipedRightLeg.addChild(RightShoo);
    	bipedRightLeg.addChild(HipR);
    	bipedLeftLeg.addChild(HipL);
    	bipedLeftLeg.addChild(Circle1);
    	bipedLeftLeg.addChild(Circle2);
    	CS1.rotationPointY = CS2.rotationPointY = CS3.rotationPointY =
    			CS4.rotationPointY = CS5.rotationPointY = CS6.rotationPointY = 4.0F;
    	CS7.rotationPointY = CS8.rotationPointY = CS9.rotationPointY = 10.0F;
    	Circle1.rotationPointY = 0.0F;
    	Circle2.rotationPointY = 0.0F;
    	RightShoo.rotationPointY = 3.0F;
    }

    @Override
    public void defaultPartsSettingBefore() {
    	super.defaultPartsSettingBefore();
    	String[] s = {
    			"Skirt1", "Skirt2", "Skirt3", "Skirt4", "Skirt5",
    			"Skirt6", "Skirt7", "Skirt8", "Skirt9", "Skirt10",
    			"Skirt11", "Skirt12"
    	};
    	showPartsHideListadd(s);
    }
}