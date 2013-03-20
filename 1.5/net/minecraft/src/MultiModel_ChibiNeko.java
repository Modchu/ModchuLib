package net.minecraft.src;

import java.util.Map;

import org.lwjgl.opengl.GL11;

public class MultiModel_ChibiNeko extends MultiModel_SR2 {

	public Modchu_ModelRenderer Prim;
	public Modchu_ModelRenderer Tail2;
	public Modchu_ModelRenderer Tail3;
	public Modchu_ModelRenderer Tail4;
	public Modchu_ModelRenderer Tail5;
	public Modchu_ModelRenderer Tail6;
	public Modchu_ModelRenderer Ahoge;
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
	public Modchu_ModelRenderer Band1;
	public Modchu_ModelRenderer EarL1;
	public Modchu_ModelRenderer EarL2;
	public Modchu_ModelRenderer EarR1;
	public Modchu_ModelRenderer EarR2;
	public Modchu_ModelRenderer EarLi1;
	public Modchu_ModelRenderer EarLi2;
	public Modchu_ModelRenderer EarRi1;
	public Modchu_ModelRenderer EarRi2;
	public Modchu_ModelRenderer Shippo1;
	public Modchu_ModelRenderer Shippo2;
	public Modchu_ModelRenderer Shippo3;
	public Modchu_ModelRenderer Shippo4;
	public Modchu_ModelRenderer Shippo5;
	public Modchu_ModelRenderer Shippo6;
	public Modchu_ModelRenderer Glass;
	public Modchu_ModelRenderer DrowaR1;
	public Modchu_ModelRenderer DrowaL1;
	public Modchu_ModelRenderer DrowaR2;
	public Modchu_ModelRenderer DrowaL2;
	public Modchu_ModelRenderer pink;
	private Map sizeMap;

	private static final float Scale=0.4F;

	public MultiModel_ChibiNeko()
	{
		this(0.0F);
	}

	public MultiModel_ChibiNeko(float f)
	{
		this(f, 0.0F);
	}

	public MultiModel_ChibiNeko(float f, float f1)
	{
		this(f, f1 , 64, 64);
	}

	public MultiModel_ChibiNeko(float f, float f1, int i, int j) {
		super(f, f1, i, j);
	}

	@Override
	public void initModel(float f, float f1) {
		textureHeight=64;
		textureWidth=64;
		f1 += 8F;
		bipedHead = new Modchu_ModelRenderer(this, 0, 1);
		bipedHead.addBox(-4F, -7F, -4F, 8, 7, 8, f-Scale);
		bipedBody = new Modchu_ModelRenderer(this, 32, 8);
		bipedBody.addBox(-3.0F, -3.5F, -2.0F, 6, 7, 4, f-Scale);
		bipedRightLeg = new Modchu_ModelRenderer(this, 32, 19);
		bipedRightLeg.addBox(-2F, 0.0F, -2F, 3, 9, 4, f-Scale);
		bipedBody.addChild(bipedRightLeg);
		bipedLeftLeg = new Modchu_ModelRenderer(this, 32, 19);
		bipedLeftLeg.mirror = true;
		bipedLeftLeg.addBox(-1F, 0.0F, -2F, 3, 9, 4, f-Scale);
		bipedBody.addChild(bipedLeftLeg);

		pink = new Modchu_ModelRenderer(this, 0, 8);
		pink.addPlate(-4f, -2.7f, -3.653f, 2, 1, 0);
		pink.addPlate(2f, -2.7f, -3.653f, 2, 1, 0);
		bipedHead.addChild(pink);

		DrowaR1 = new Modchu_ModelRenderer(this, 46, 25);
		DrowaR1.addBox(-2F, -0.0F, -2F, 3, 2, 4, f-0.1F);
		DrowaR1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedRightLeg.addChild(DrowaR1);

		DrowaL1 = new Modchu_ModelRenderer(this, 46, 25);
		DrowaL1.mirror = true;
		DrowaL1.addBox(-1F, -0.0F, -2F, 3, 2, 4, f-0.1F);
		DrowaL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedLeftLeg.addChild(DrowaL1);

		Skirt = new Modchu_ModelRenderer(this, 0, 16);
		Skirt.setRotationPoint(0.0F, 2.0F, 0.0F);
		bipedBody.addChild(Skirt);

		DrowaR2 = new Modchu_ModelRenderer(this, 46, 25, Skirt);
		DrowaR2.addBox(-1.5F, 0F, -2F, 3, 2, 4, f);
		DrowaR2.setRotationPointLM(-1.5F, -0.5F, 0.0F);

		DrowaL2 = new Modchu_ModelRenderer(this, 46, 25, Skirt);
		DrowaL2.mirror = true;
		DrowaL2.addBox(-1.5F, 0F, -2F, 3, 2, 4, f);
		DrowaL2.setRotationPointLM(1.5F, -0.5F, 0.0F);

		bipedRightArm = new Modchu_ModelRenderer(this, 48, 0);
		bipedRightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f-Scale);
		bipedRightArm.setRotationPoint(-2.1F, 4.5F + 2*Scale, 0F);
		bipedBody.addChild(bipedRightArm);
		bipedLeftArm = new Modchu_ModelRenderer(this, 56, 0);
		bipedLeftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, f-Scale);
		bipedLeftArm.setRotationPoint(2.1F, 4.5F + 2*Scale, 0.0F);
		bipedBody.addChild(bipedLeftArm);

		eyeR = new Modchu_ModelRenderer(this, 32, 19);
		eyeR.addPlate(-4.0F, -4.9F, -4.001F, 4, 4, 0, f-Scale);
		eyeR.setRotationPointLM(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(eyeR);
		eyeL = new Modchu_ModelRenderer(this, 42, 19);
		eyeL.addPlate(0.0F, -4.9F, -4.001F, 4, 4, 0, f-Scale);
		eyeL.setRotationPointLM(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(eyeL);

		Glass = new Modchu_ModelRenderer(this, 24, 0);
		Glass.addPlate(-8.0F, -4.0F, 0F, 16, 8, 0, f-Scale);
		Glass.setRotationPointLM(0.0F, -4.5F + 2.0F*Scale, -4.0F);
		bipedHead.addChild(Glass);

		Prim = new Modchu_ModelRenderer(this, 4, 0);
		Prim.addPlate(-2F, -7.7F, -3.5F, 4, 1, 0, f-Scale/2);
		Prim.setRotationPointLM(0.0F, -0.0F + Scale, 0.0F);
		bipedHead.addChild(Prim);

		ChignonB = new Modchu_ModelRenderer(this, 52, 10);
		ChignonB.addBox(-2F, -7.5F, 3.1F, 4, 4, 2,f-0.5F);
		ChignonB.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(ChignonB);

		Tail = new Modchu_ModelRenderer(this, 46, 19);
		Tail.addBox(-1F, -6.5F, 4.5F, 2, 2, 2,f+0.1F);
		Tail.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.addChild(Tail);

		Tail2 = new Modchu_ModelRenderer(this, 46, 15);
		Tail2.addBoxLM(0F, 1F, 0F, 2, 7, 2,f);
		Tail2.setRotationPointLM(-1F, -6.0F, 4.7F);
		bipedHead.addChild(Tail2);
		Tail2.isHidden=true;

		Tail3 = new Modchu_ModelRenderer(this, 54, 15);
		Tail3.addBoxLM(0F, 1F, 0F, 0, 8, 2,f+0.0001F);
		Tail3.setRotationPointLM(-0.5F, -6.8F, 4.5F);
		bipedHead.addChild(Tail3);

		Tail4 = new Modchu_ModelRenderer(this, 54, 15);
		Tail4.addPlate(0F, 1F, 0F, 2, 8, 0,f);
		Tail4.setRotationPointLM(-1.0F, -6.8F, 5.0F);
		bipedHead.addChild(Tail4);

		Tail5 = new Modchu_ModelRenderer(this, 54, 15);
		Tail5.addBoxLM(0F, 1F, 0F, 0, 8, 2,f+0.0001F);
		Tail5.setRotationPointLM(0.5F, -6.8F, 4.5F);
		bipedHead.addChild(Tail5);

		Tail6 = new Modchu_ModelRenderer(this, 54, 15);
		Tail6.mirror=true;
		Tail6.addPlate(0F, 1F, 0F, 2, 8, 0,f);
		Tail6.setRotationPointLM(-1.0F, -6.8F, 6.0F);
		bipedHead.addChild(Tail6);

		Ahoge = new Modchu_ModelRenderer(this, 0, 1);
		Ahoge.addBoxLM(0F, 0F, 0F, 0, 3, 4,f+0.0001F);
		Ahoge.setRotationPointLM(0F, -6.8F+Scale, -3.8F+Scale);
		bipedHead.addChild(Ahoge);

		Skirt21 = new Modchu_ModelRenderer(this, 0, 32, Skirt);
		Skirt21.addPlate(-1.6F+14F, -12F, 0F, 30, 12, 0,f);
		Skirt21.setRotationPointLM(0F,-5.5F,0F);

		Skirt22 = new Modchu_ModelRenderer(this, 0, 44, Skirt);
		Skirt22.addPlate(-1.6F+14F, 0F, 0F, 30, 12, 0,f);
		Skirt22.setRotationPointLM(0F,-5.5F,0F);

		Skirt23 = new Modchu_ModelRenderer(this, 0, 32, Skirt);
		Skirt23.addPlate(0F+14F, -12F, 0F, 30, 12, 0,f);
		Skirt23.setRotationPointLM(0F,-6F,0F);

		Skirt24 = new Modchu_ModelRenderer(this, 0, 44, Skirt);
		Skirt24.addPlate(0F+14F, 0F, 0F, 30, 12, 0,f);
		Skirt24.setRotationPointLM(0F,-6F,0F);

		Skirt25 = new Modchu_ModelRenderer(this, 0, 32, Skirt);
		Skirt25.addPlate(0F+14F, -12F, 0F, 30, 12, 0,f);
		Skirt25.setRotationPointLM(0F,-6F,0F);

		Skirt26 = new Modchu_ModelRenderer(this, 0, 44, Skirt);
		Skirt26.addPlate(0F+14F, 0F, 0F, 30, 12, 0,f);
		Skirt26.setRotationPointLM(0F,-6F,0F);

		Skirt27 = new Modchu_ModelRenderer(this, 0, 32, Skirt);
		Skirt27.addPlate(-1.6F+14F, -12F, 0F, 30, 12, 0,f);
		Skirt27.setRotationPointLM(0F,-5.5F,0F);

		Skirt28 = new Modchu_ModelRenderer(this, 0, 44, Skirt);
		Skirt28.addPlate(-1.6F+14F, 0F, 0F, 30, 12, 0,f);
		Skirt28.setRotationPointLM(0F,-5.5F,0F);

		Skirt29 = new Modchu_ModelRenderer(this, 0, 32, Skirt);
		Skirt29.addPlate(-1.6F+14F, -12F, 0F, 30, 12, 0,f);
		Skirt29.setRotationPointLM(0F,-5.5F,0F);

		Skirt210 = new Modchu_ModelRenderer(this, 0, 44, Skirt);
		Skirt210.addPlate(-1.6F+14F, 0F, 0F, 30, 12, 0,f);
		Skirt210.setRotationPointLM(0F,-5.5F,0F);

		Skirt211 = new Modchu_ModelRenderer(this, 0, 32, Skirt);
		Skirt211.addPlate(0F+14F, -12F, 0F, 30, 12, 0,f);
		Skirt211.setRotationPointLM(0F,-6F,0F);

		Skirt212 = new Modchu_ModelRenderer(this, 0, 44, Skirt);
		Skirt212.addPlate(0F+14F, 0F, 0F, 30, 12, 0,f);
		Skirt212.setRotationPointLM(0F,-6F,0F);

		Skirt213 = new Modchu_ModelRenderer(this, 0, 32, Skirt);
		Skirt213.addPlate(0F+14F, -12F, 0F, 30, 12, 0,f);
		Skirt213.setRotationPointLM(0F,-6F,0F);

		Skirt214 = new Modchu_ModelRenderer(this, 0, 44, Skirt);
		Skirt214.addPlate(0F+14F, 0F, 0F, 30, 12, 0,f);
		Skirt214.setRotationPointLM(0F,-6F,0F);

		Skirt215 = new Modchu_ModelRenderer(this, 0, 32, Skirt);
		Skirt215.addPlate(-1.6F+14F, -12F, 0F, 30, 12, 0,f);
		Skirt215.setRotationPointLM(0F,-5.5F,0F);

		Skirt216 = new Modchu_ModelRenderer(this, 0, 44, Skirt);
		Skirt216.addPlate(-1.6F+14F, 0F, 0F, 30, 12, 0,f);
		Skirt216.setRotationPointLM(0F,-5.5F,0F);

		Band1 = new Modchu_ModelRenderer(this, 0, 56, Skirt);
		Band1.addBoxLM(-3F, 0F, -2F, 6, 4, 4,f);
		Band1.setRotationPointLM(0F,-3.5F,0F);

		EarL1 = new Modchu_ModelRenderer(this, 0, 16);
		EarL1.addPlate(0F, 0F, 0F, 16, 16, 0,f);
		EarL1.setRotationPointLM(3.0F-Scale,-6.5F,-0.4F);
		EarL1.setRotateAngleDeg(8F,80F,-40F);
		bipedHead.addChild(EarL1);

		EarL2 = new Modchu_ModelRenderer(this, 0, 16);
		EarL2.mirror=true;
		EarL2.addPlate(-16F, 0F, 0F, 16, 16, 0,f);
		EarL2.setRotationPointLM(3.0F-Scale,-6.5F,-0.4F);
		EarL2.setRotateAngleDeg(60F,-100F,40F);
		bipedHead.addChild(EarL2);

		EarR1 = new Modchu_ModelRenderer(this, 0, 16);
		EarR1.addPlate(0F, 0F, 0F, 16, 16, 0,f);
		EarR1.setRotationPointLM(-(3.0F-Scale),-6.5F,-0.4F);
		EarR1.setRotateAngleDeg(60F,100F,-40F);
		bipedHead.addChild(EarR1);

		EarR2 = new Modchu_ModelRenderer(this, 0, 16);
		EarR2.mirror=true;
		EarR2.addPlate(-16F, 0F, 0F, 16, 16, 0,f);
		EarR2.setRotationPointLM(-(3.0F-Scale),-6.5F,-0.4F);
		EarR2.setRotateAngleDeg(8F,-80F,40F);
		bipedHead.addChild(EarR2);

		EarLi1 = new Modchu_ModelRenderer(this, 16, 16);
		EarLi1.addPlate(0F, 0F, 0F, 16, 16, 0,f);
		EarLi1.setRotationPointLM(3.0F-Scale,-6.5F,-0.5F);
		EarLi1.setRotateAngleDeg(8F,80F,-40F);
		bipedHead.addChild(EarLi1);

		EarLi2 = new Modchu_ModelRenderer(this, 16, 16);
		EarLi2.mirror=true;
		EarLi2.addPlate(-16F, 0F, 0F, 16, 16, 0,f);
		EarLi2.setRotationPointLM(3.0F-Scale,-6.5F,-0.5F);
		EarLi2.setRotateAngleDeg(60F,-100F,40F);
		bipedHead.addChild(EarLi2);

		EarRi1 = new Modchu_ModelRenderer(this, 16, 16);
		EarRi1.addPlate(0F, 0F, 0F, 16, 16, 0,f);
		EarRi1.setRotationPointLM(-(3.0F-Scale),-6.5F,-0.5F);
		EarRi1.setRotateAngleDeg(60F,100F,-40F);
		bipedHead.addChild(EarRi1);

		EarRi2 = new Modchu_ModelRenderer(this, 16, 16);
		EarRi2.mirror=true;
		EarRi2.addPlate(-16F, 0F, 0F, 16, 16, 0,f);
		EarRi2.setRotationPointLM(-(3.0F-Scale),-6.5F,-0.5F);
		EarRi2.setRotateAngleDeg(8F,-80F,40F);
		bipedHead.addChild(EarRi2);

		Shippo1 = new Modchu_ModelRenderer(this, 60, 16);
		Shippo1.addBoxLM(-0.5F, 0F, -0.5F, 1, 2, 1);
		Shippo1.setRotationPointLM(0F, 3.6F+Scale, 2F-Scale);
		Shippo1.setRotateAngleDeg(125F, 0F, 0F);
		bipedBody.addChild(Shippo1);

		Shippo2 = new Modchu_ModelRenderer(this, 60, 18);
		Shippo2.addBoxLM(-0.5F, 0F, -0.5F, 1, 2, 1);
		Shippo2.setRotationPointLM(0F, 1.7F, 0F);
		Shippo2.setRotateAngleDeg(20F, 0F, 0F);
		Shippo1.addChild(Shippo2);

		Shippo3 = new Modchu_ModelRenderer(this, 60, 20);
		Shippo3.addBoxLM(-0.5F, 0F, -0.5F, 1, 2, 1);
		Shippo3.setRotationPointLM(0F, 1.7F, 0F);
		Shippo3.setRotateAngleDeg(10F, 0F, 0F);
		Shippo2.addChild(Shippo3);

		Shippo4 = new Modchu_ModelRenderer(this, 60, 22);
		Shippo4.addBoxLM(-0.5F, 0F, -0.5F, 1, 2, 1);
		Shippo4.setRotationPointLM(0F, 1.8F, 0F);
		Shippo4.setRotateAngleDeg(5F, 0F, 0F);
		Shippo3.addChild(Shippo4);

		Shippo5 = new Modchu_ModelRenderer(this, 60, 24);
		Shippo5.addBoxLM(-0.5F, 0F, -0.5F, 1, 2, 1);
		Shippo5.setRotationPointLM(0F, 1.8F, 0F);
		Shippo5.setRotateAngleDeg(-5F, 0F, 0F);
		Shippo4.addChild(Shippo5);

		Shippo6 = new Modchu_ModelRenderer(this, 60, 27);
		Shippo6.addBoxLM(-0.5F, 0F, -0.5F, 1, 1, 1);
		Shippo6.setRotationPointLM(0F, 1.7F, 0F);
		Shippo6.setRotateAngleDeg(-15F, 0F, 0F);
		Shippo5.addChild(Shippo6);

		mainFrame = new Modchu_ModelRenderer(this, 0, 0);
		mainFrame.setRotationPoint(0F, 0F, 0F);
		mainFrame.addChild(bipedHead);
		mainFrame.addChild(bipedBody);

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
		i = Modchu_ModelRenderer.YZX;
		DrowaR2.setRotatePriority(i);
		DrowaL2.setRotatePriority(i);
		Glass.setRotatePriority(i);
		EarL1.setRotatePriority(i);
		EarL2.setRotatePriority(i);
		EarR1.setRotatePriority(i);
		EarR2.setRotatePriority(i);
		EarLi1.setRotatePriority(i);
		EarLi2.setRotatePriority(i);
		EarRi1.setRotatePriority(i);
		EarRi2.setRotatePriority(i);
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

		Band1.setScale(0.9F, 0.35F, 0.9F);
		Glass.setScale(0.47F, 0.47F, 1.0F);
		EarL1.setScale(0.25F, 0.25F, 1.0F);
		EarL2.setScale(0.25F, 0.25F, 1.0F);
		EarR1.setScale(0.25F, 0.25F, 1.0F);
		EarR2.setScale(0.25F, 0.25F, 1.0F);
		EarLi1.setScale(0.2F, 0.2F, 1.0F);
		EarLi2.setScale(0.2F, 0.2F, 1.0F);
		EarRi1.setScale(0.2F, 0.2F, 1.0F);
		EarRi2.setScale(0.2F, 0.2F, 1.0F);

		Skirt21.setScale(0.22F, 0.22F, 1.0F);
		Skirt22.setScale(0.22F, 0.22F, 1.0F);
		Skirt23.setScale(0.22F, 0.22F, 1.0F);
		Skirt24.setScale(0.22F, 0.22F, 1.0F);
		Skirt25.setScale(0.22F, 0.22F, 1.0F);
		Skirt26.setScale(0.22F, 0.22F, 1.0F);
		Skirt27.setScale(0.22F, 0.22F, 1.0F);
		Skirt28.setScale(0.22F, 0.22F, 1.0F);
		Skirt29.setScale(0.22F, 0.22F, 1.0F);
		Skirt210.setScale(0.22F, 0.22F, 1.0F);
		Skirt211.setScale(0.22F, 0.22F, 1.0F);
		Skirt212.setScale(0.22F, 0.22F, 1.0F);
		Skirt213.setScale(0.22F, 0.22F, 1.0F);
		Skirt214.setScale(0.22F, 0.22F, 1.0F);
		Skirt215.setScale(0.22F, 0.22F, 1.0F);
		Skirt216.setScale(0.22F, 0.22F, 1.0F);
		pink.setScale(0.75F, 0.75F, 1F);

		actionPartsInit(f, f1);
	}

	@Override
	public void actionPartsInit(float f, float f1) {
		f = f - Scale;
		super.actionPartsInit(f, f1);
		((Modchu_ModelRenderer) rightArm).removeChild(rightArmPlus);
		rightArmPlus = new Modchu_ModelRenderer(this);
		((Modchu_ModelRenderer) rightArmPlus.setTextureOffset(50, 0)).addPlate(-1.0F, -1.0F, -2.01F, 2, 2, 4, f);
		rightArmPlus.rotateAngleX = 1.570796313F;
		rightArm.addChild(rightArmPlus);

		((Modchu_ModelRenderer) rightArm2).removeChild(rightHand);
		((Modchu_ModelRenderer) rightArm2).removeChild(rightArmPlus2);
		rightArm2 = new Modchu_ModelRenderer(this, 48, 3);
		rightArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, f);
		rightArm2.setRotationPoint(0.0F, 2.0F, 0.0F);
		rightArm.addChild(rightArm2);
		rightArm2.addChild(rightHand);

		rightArmPlus2 = new Modchu_ModelRenderer(this);
		((Modchu_ModelRenderer) rightArmPlus2.setTextureOffset(52, 0)).addPlate(-1.0F, -1.0F, -1.01F, 2, 2, 4, f);
		((Modchu_ModelRenderer) rightArmPlus2.setTextureOffset(52, 0)).addPlate(-1.0F, -1.0F, -2.01F, 2, 2, 4, f);
		rightArmPlus2.rotateAngleX = 1.570796313F;
		rightArm2.addChild(rightArmPlus2);

		((Modchu_ModelRenderer) leftArm).removeChild(leftArmPlus);
		leftArmPlus = new Modchu_ModelRenderer(this);
		((Modchu_ModelRenderer) leftArmPlus.setTextureOffset(60, 0)).addPlate(-1.0F, -1.0F, -2.01F, 2, 2, 4, f);
		leftArmPlus.rotateAngleX = 1.570796313F;
		leftArm.addChild(leftArmPlus);

		((Modchu_ModelRenderer) leftArm2).removeChild(leftHand);
		((Modchu_ModelRenderer) leftArm2).removeChild(leftArmPlus2);
    	leftArm2 = new Modchu_ModelRenderer(this, 56, 3);
    	leftArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, f);
    	leftArm2.setRotationPoint(0.0F, 2.0F, 0.0F);
    	leftArm.addChild(leftArm2);
    	leftArm2.addChild(leftHand);

		leftArmPlus2 = new Modchu_ModelRenderer(this);
		((Modchu_ModelRenderer) leftArmPlus2.setTextureOffset(60, 0)).addPlate(-1.0F, -1.0F, -1.01F, 2, 2, 4, f);
		((Modchu_ModelRenderer) leftArmPlus2.setTextureOffset(60, 0)).addPlate(-1.0F, -1.0F, -2.01F, 2, 2, 4, f);
		leftArmPlus2.rotateAngleX = 1.570796313F;
		leftArm2.addChild(leftArmPlus2);

		((Modchu_ModelRenderer) rightLeg).removeChild(rightLegPlus);
		rightLegPlus = new Modchu_ModelRenderer(this);
		((Modchu_ModelRenderer) rightLegPlus.setTextureOffset(36, 19)).addPlate(-1.5F, -2.0F, -3.01F, 3, 4, 4, f);
		rightLegPlus.rotateAngleX = 1.570796313F;
		rightLeg.addChild(rightLegPlus);

		((Modchu_ModelRenderer) rightLeg2).removeChild(rightLegPlus2);
		rightLegPlus2 = new Modchu_ModelRenderer(this);
		((Modchu_ModelRenderer) rightLegPlus2.setTextureOffset(36, 19)).addPlate(-1.5F, -2.0F, -1.01F, 3, 4, 4, f);
		((Modchu_ModelRenderer) rightLegPlus2.setTextureOffset(39, 19)).addPlate(-1.5F, -2.0F, -4.01F, 3, 4, 4, f);
		rightLegPlus2.rotateAngleX = 1.570796313F;
		rightLeg2.addChild(rightLegPlus2);

		((Modchu_ModelRenderer) leftLeg).removeChild(leftLegPlus);
		leftLegPlus = new Modchu_ModelRenderer(this);
		leftLegPlus.mirror = true;
		((Modchu_ModelRenderer) leftLegPlus.setTextureOffset(36, 19)).addPlate(-1.5F, -2.0F, -3.01F, 3, 4, 4, f);
		leftLegPlus.rotateAngleX = 1.570796313F;
		leftLeg.addChild(leftLegPlus);

		((Modchu_ModelRenderer) leftLeg2).removeChild(leftLegPlus2);
		leftLegPlus2 = new Modchu_ModelRenderer(this);
		leftLegPlus2.mirror = true;
		((Modchu_ModelRenderer) leftLegPlus2.setTextureOffset(36, 19)).addPlate(-1.5F, -2.0F, -1.01F, 3, 4, 4, f);
		((Modchu_ModelRenderer) leftLegPlus2.setTextureOffset(39, 19)).addPlate(-1.5F, -2.0F, -4.01F, 3, 4, 4, f);
		leftLegPlus2.rotateAngleX = 1.570796313F;
		leftLeg2.addChild(leftLegPlus2);
		rightHand.showModel = leftHand.showModel =
				rightArm.showModel = leftArm.showModel =
						rightArmPlus.showModel = rightArmPlus2.showModel =
								leftArmPlus.showModel = leftArmPlus2.showModel =
										rightLegPlus.showModel = rightLegPlus2.showModel =
												leftLegPlus.showModel = leftLegPlus2.showModel =
														rightArm2.showModel = leftArm2.showModel =
																rightLeg.showModel = rightLeg2.showModel =
																		leftLeg.showModel = leftLeg2.showModel = false;
	}

    @Override
    public void skirtFloatsInit(float f, float f1) {
    }

    @Override
    public void reset(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	bipedHead.setRotationPoint(0.0F, 1.0F, 0.0F);
    	bipedBody.setRotationPoint(0.0F, -3.0F*Scale, 0.0F);
    	bipedRightLeg.setRotationPoint(-0.9F, 15.0F + Scale, 0.0F);
    	bipedLeftLeg.setRotationPoint(0.9F, 15.0F + Scale, 0.0F);
    	HeadMount.setRotationPoint(0.0F, -21.0F, 0.0F);
    }

	@Override
	public void setLivingAnimationsLM(EntityLiving entityliving, float f, float f1, float f2)
	{
		super.setLivingAnimationsLM(entityliving, f, f1, f2);

		setCapsValue(caps_visible, pink, (getCapsValueBoolean(caps_isLookSuger)));
		float f3 = (float)entityliving.ticksExisted + f2 + getCapsValueFloat(caps_entityIdFactor);
		if (0.0F > mh_sin(f3 * 0.17F) + mh_sin(f3 * 0.17F + 0.02F) + mh_sin(f3 * 0.11F) + mh_sin(f3 * 0.7F) + 3.1F) {
			EarL1.rotateAngleZ = EarR1.rotateAngleZ = EarLi1.rotateAngleZ = EarRi1.rotateAngleZ = -0.5235988F;
			EarL2.rotateAngleZ = EarR2.rotateAngleZ = EarLi2.rotateAngleZ = EarRi2.rotateAngleZ = 0.5235988F;
			EarL1.rotateAngleY = EarLi1.rotateAngleY = ((float)Math.PI / 2F);
			EarL2.rotateAngleY = EarLi2.rotateAngleY = -((float)Math.PI / 2F);
			EarR1.rotateAngleY = EarRi1.rotateAngleY = ((float)Math.PI / 2F);
			EarR2.rotateAngleY = EarRi2.rotateAngleY = -((float)Math.PI / 2F);
		} else {
			EarL1.rotateAngleZ = EarR1.rotateAngleZ = EarLi1.rotateAngleZ = EarRi1.rotateAngleZ = -((float)Math.PI * 2F / 9F);
			EarL2.rotateAngleZ = EarR2.rotateAngleZ = EarLi2.rotateAngleZ = EarRi2.rotateAngleZ = ((float)Math.PI * 2F / 9F);
			EarL1.rotateAngleY = EarLi1.rotateAngleY = 1.396263F;
			EarL2.rotateAngleY = EarLi2.rotateAngleY = -1.745329F;
			EarR1.rotateAngleY = EarRi1.rotateAngleY = 1.745329F;
			EarR2.rotateAngleY = EarRi2.rotateAngleY = -1.396263F;
		}
	}

	@Override
	public void setRotationAnglesLM(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAnglesLM(f, f1, f2, f3, f4, f5, entity);

		float t = f2;
		float idFactor = getCapsValueFloat(caps_entityIdFactor);
		if(getCapsValueBoolean(caps_isLookSuger)) t *= 2F;
		Ahoge.rotateAngleY = MathHelper.cos(t * 0.2F + MathHelper.cos(t * 0.05F + idFactor) * 1.0F) * 0.2F;
		Ahoge.rotateAngleX = MathHelper.cos(t * 0.02F + MathHelper.cos(t*0.05F + idFactor) * 1.0F) * 0.0015F;
		Ahoge.rotateAngleZ = 0.02F;
		bipedHead.rotationPointZ = 0.0F;
		bipedRightArm.rotationPointY = -4.5F + 4*Scale;
		bipedLeftArm.rotationPointY = -4.5F + 4*Scale;
		DrowaR2.rotationPointY = -2.0F;
		DrowaR2.rotationPointZ = 0.0F;
		DrowaL2.rotationPointY = -2.0F;
		DrowaL2.rotationPointZ = 0.0F;

		if(bipedHead.rotateAngleX>getCapsValueFloat(caps_convertDegtoRad, 10F))
			Tail2.rotateAngleX = Tail3.rotateAngleX = Tail4.rotateAngleX = Tail5.rotateAngleX = Tail6.rotateAngleX = -getCapsValueFloat(caps_convertDegtoRad, 10F);
		else
			Tail2.rotateAngleX = Tail3.rotateAngleX = Tail4.rotateAngleX = Tail5.rotateAngleX = Tail6.rotateAngleX = -bipedHead.rotateAngleX;//+bipedBody.rotateAngleX);
		Shippo1.rotateAngleX = 125F / 180F * (float)Math.PI + 0.025F * MathHelper.sin(-t * 0.6F + idFactor);
		Shippo2.rotateAngleX = 20F / 180F*(float)Math.PI;
		Shippo3.rotateAngleX = 10F / 180F*(float)Math.PI;
		Shippo4.rotateAngleX = 5F / 180F*(float)Math.PI;
		Shippo5.rotateAngleX = -5F / 180F*(float)Math.PI;
		Shippo6.rotateAngleX = -15F / 180F*(float)Math.PI;
		Shippo1.rotateAngleY = 0.2F * MathHelper.sin(t*0.3F+idFactor);
		Shippo2.rotateAngleZ = 0.2F * MathHelper.sin(-t*0.3F+0.000005F+idFactor);
		Shippo3.rotateAngleZ = 0.2F * MathHelper.sin(-t*0.3F+0.00001F+idFactor);
		Shippo4.rotateAngleZ = 0.2F * MathHelper.sin(-t*0.3F+0.000015F+idFactor);
		Shippo5.rotateAngleZ = 0.2F * MathHelper.sin(-t*0.3F+0.00002F+idFactor);
		Shippo6.rotateAngleZ = 0.2F * MathHelper.sin(-t*0.3F+0.000025F+idFactor);

		if (getCapsValueFloat(caps_onGround) > -9990F && !getCapsValueBoolean(caps_aimedBow))
		{
			bipedRightArm.rotationPointZ = MathHelper.sin(bipedBody.rotateAngleY) * 4F;
			bipedRightArm.rotationPointX = -MathHelper.cos(bipedBody.rotateAngleY) * 4F + 1.0F+2.0F*Scale;
			bipedLeftArm.rotationPointZ = -MathHelper.sin(bipedBody.rotateAngleY) * 4F;
			bipedLeftArm.rotationPointX = MathHelper.cos(bipedBody.rotateAngleY) * 4F - 1.0F-2.0F*Scale;
		}

		if(getCapsValueBoolean(caps_getIsRiding))
		{
			Shippo1.rotateAngleX = 125F / 180F * (float)Math.PI + 0.025F * MathHelper.sin(-t * 0.4F + idFactor);
			Shippo1.rotateAngleY = 0.2F * MathHelper.sin(t * 0.2F + idFactor);
			Shippo2.rotateAngleZ = 0.2F * MathHelper.sin(-t * 0.2F + 0.0002F + idFactor);
			Shippo3.rotateAngleZ = 0.2F * MathHelper.sin(-t * 0.2F + 0.0004F + idFactor);
			Shippo4.rotateAngleZ = 0.2F * MathHelper.sin(-t * 0.2F + 0.0006F + idFactor);
			Shippo5.rotateAngleZ = 0.2F * MathHelper.sin(-t * 0.2F + 0.0008F + idFactor);
			Shippo6.rotateAngleZ = 0.2F * MathHelper.sin(-t * 0.2F + 0.001F + idFactor);
		}
		if (getCapsValueBoolean(caps_aimedBow)) {
			Shippo1.rotateAngleX = 145F / 180F * (float)Math.PI;
			Shippo2.rotateAngleX = Shippo3.rotateAngleX = Shippo4.rotateAngleX = Shippo5.rotateAngleX = Shippo6.rotateAngleX = 0F;
			Shippo1.rotateAngleY = Shippo2.rotateAngleZ = Shippo3.rotateAngleZ = Shippo4.rotateAngleZ = Shippo5.rotateAngleZ = Shippo6.rotateAngleZ = 0F;
		}
		bipedHead.rotationPointY = 8.0F + 5.0F * Scale;
		bipedBody.rotationPointY = 12.0F + Scale;
		bipedRightLeg.rotationPointY = 3.0F + Scale;
		bipedLeftLeg.rotationPointY = 3.0F + Scale;
		Skirt.rotationPointY = 3.0F + 2.0F * Scale;
		Skirt.rotationPointZ = 0.0F;
		if(getCapsValueBoolean(caps_getIsSneak)){
			Shippo1.rotateAngleX = 125F / 180F * (float)Math.PI + 0.025F * MathHelper.sin(-t * 0.4F + idFactor);
			Shippo1.rotateAngleY = 0.2F * MathHelper.sin(t * 0.2F + idFactor);
			Shippo2.rotateAngleZ = 0.2F * MathHelper.sin(-t * 0.2F + 0.0002F + idFactor);
			Shippo3.rotateAngleZ = 0.2F * MathHelper.sin(-t * 0.2F + 0.0004F + idFactor);
			Shippo4.rotateAngleZ = 0.2F * MathHelper.sin(-t * 0.2F + 0.0006F + idFactor);
			Shippo5.rotateAngleZ = 0.2F * MathHelper.sin(-t * 0.2F + 0.0008F + idFactor);
			Shippo6.rotateAngleZ = 0.2F * MathHelper.sin(-t * 0.2F + 0.001F + idFactor);
			bipedHead.rotationPointY = 8.5F + 5.0F * Scale;
		}
		if( 0.0F > mh_sin(t * 0.17F) + mh_sin(t * 0.17F + 0.02F) + mh_sin(t * 0.11F) + mh_sin(t * 0.7F) + 3.10F) {
			EarL1.rotateAngleZ = EarR1.rotateAngleZ = EarLi1.rotateAngleZ = EarRi1.rotateAngleZ = -30F / 180F * (float)Math.PI;
			EarL2.rotateAngleZ = EarR2.rotateAngleZ = EarLi2.rotateAngleZ = EarRi2.rotateAngleZ = 30F / 180F * (float)Math.PI;
			EarL1.rotateAngleY = EarLi1.rotateAngleY = 90F / 180F * (float)Math.PI;
			EarL2.rotateAngleY = EarLi2.rotateAngleY = -90F / 180F * (float)Math.PI;
			EarR1.rotateAngleY = EarRi1.rotateAngleY = 90F / 180F * (float)Math.PI;
			EarR2.rotateAngleY = EarRi2.rotateAngleY = -90F / 180F * (float)Math.PI;
		} else {
			EarL1.rotateAngleZ = EarR1.rotateAngleZ = EarLi1.rotateAngleZ = EarRi1.rotateAngleZ = -40F / 180F * (float)Math.PI;
			EarL2.rotateAngleZ = EarR2.rotateAngleZ = EarLi2.rotateAngleZ = EarRi2.rotateAngleZ = 40F / 180F * (float)Math.PI;
			EarL1.rotateAngleY = EarLi1.rotateAngleY = 80F / 180F * (float)Math.PI;
			EarL2.rotateAngleY = EarLi2.rotateAngleY = -100F / 180F * (float)Math.PI;
			EarR1.rotateAngleY = EarRi1.rotateAngleY = 100F / 180F * (float)Math.PI;
			EarR2.rotateAngleY = EarRi2.rotateAngleY = -80F / 180F * (float)Math.PI;
		}
		skirtFloats(f, f1, t, f3, f4, f5, entity);
	}

	@Override
	public void skirtFloats(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		if (!getCapsValueBoolean(caps_skirtFloats)) return;
    	float motionY = getCapsValueFloat(caps_motionY);
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
    			"Skirt21", "Skirt22", "Skirt23", "Skirt24", "Skirt25",
    			"Skirt26", "Skirt27", "Skirt27", "Skirt28", "Skirt29",
    			"Skirt210", "Skirt211", "Skirt212", "Skirt213", "Skirt214",
    			"Skirt215", "Skirt216"
    	};
    	showPartsHideListadd(s);
    }

	@Override
	public void action1(Entity entity) {
		super.action1(entity);
		rightArm2.rotationPointX = 1.0F - (1.0F * Scale);
		leftArm2.rotationPointX = 0.0F - (1.0F * Scale);
		leftArm2.rotationPointY = 4.0F - (1.0F * Scale);
		rightHand.rotationPointY = 3.0F;
		leftHand.rotationPointY = 3.0F;

		rightLeg.rotationPointY += 1.5F - (1.5F * Scale) / 2.0F;
		rightLeg2.rotationPointY -= 1.5F - (1.5F * Scale) / 2.0F;
		leftLeg.rotationPointY += 1.5F - (1.5F * Scale) / 2.0F;
		leftLeg2.rotationPointY -= 1.5F - (1.5F * Scale) / 2.0F;
	}

	@Override
	public float getHeight()
	{
		return 1.25F;
	}

	@Override
	public float getWidth()
	{
		return 0.5F;
	}

	@Override
	public float getyOffset() {
	    return 1.07F;
	}

	@Override
	public void equippedItemPositionFlower() {
		GL11.glTranslatef(0.0F, 0.9F, 0.0F);
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
