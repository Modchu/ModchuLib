package net.minecraft.src;

public class MultiModel_Elsa extends MultiModel_Elsa2 {

    public MultiModel_Elsa()
    {
        this(0.0F);
    }

    public MultiModel_Elsa(float f)
    {
        this(f, 0.0F);
    }

    public MultiModel_Elsa(float f, float f1)
    {
    	this(f, f1 , 64, 32);
    }

    public MultiModel_Elsa(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
    }

    @Override
    public void initModel(float f, float f1) {
    	super.initModel(f, f1);
    	((Modchu_ModelRenderer) bipedHead).removeChild(bipedHeadwear);
    	((Modchu_ModelRenderer) bipedBody).removeChild(bipedRightArm);
    	((Modchu_ModelRenderer) bipedBody).removeChild(bipedLeftArm);
    	((Modchu_ModelRenderer) bipedHead).removeChild(Tail);
    	((Modchu_ModelRenderer) bipedHead).removeChild(eyeR);
    	((Modchu_ModelRenderer) bipedHead).removeChild(eyeL);

    	bipedHeadwear.cubeList.clear();
    	bipedHeadwear.setTextureOffset(42, -3);
    	bipedHeadwear.addBox(-4F, 0F, 1F, 8, 4, 3, f);
    	bipedHeadwear.setRotationPoint(0F, 0F, 0F);
    	bipedHead.addChild(bipedHeadwear);

    	bipedRightArm.cubeList.clear();
    	bipedRightArm.setTextureOffset(52, 8);
    	bipedRightArm.addBox(-2F, -1F, -1F, 2, 10, 2, f);
    	bipedRightArm.setRotationPoint(-3F, 1.0F, 0F);
    	bipedBody.addChild(bipedRightArm);

    	bipedLeftArm.cubeList.clear();
    	bipedLeftArm.setTextureOffset(52, 8);
    	bipedLeftArm.mirror = true;
    	bipedLeftArm.addBox(0F, -1F, -1F, 2, 10, 2, f);
    	bipedLeftArm.setRotationPoint(3F, 1.0F, 0F);
    	bipedBody.addChild(bipedLeftArm);

    	Tail.cubeList.clear();
    	Tail.setTextureOffset(43, 17);
    	Tail.addBox(-1.5F, -6.8F, 4F, 3, 9, 3, f);
    	Tail.setRotationPoint(0F, 0F, 0F);
    	bipedHead.addChild(Tail);

    	eyeR.cubeList.clear();
    	eyeL.cubeList.clear();
    }

    @Override
    public void actionPartsInit(float f, float f1) {
    	super.actionPartsInit(f, f1);
    	((Modchu_ModelRenderer) bipedBody).removeChild(rightArm);
    	rightArm = new Modchu_ModelRenderer(this, 52, 8);
    	rightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, f);
    	rightArm.setRotationPoint(-3.0F, 9.5F, 0.0F);
    	bipedBody.addChild(rightArm);

    	((Modchu_ModelRenderer) bipedBody).removeChild(rightArm2);
    	rightArm2 = new Modchu_ModelRenderer(this, 52, 13);
    	rightArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, f);
    	rightArm2.setRotationPoint(0.0F, 5.0F, 0.0F);
    	rightArm.addChild(rightArm2);

    	((Modchu_ModelRenderer) bipedBody).removeChild(rightHand);
    	rightHand = new Modchu_ModelRenderer(this, 52, 16);
    	rightHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
    	rightHand.setRotationPoint(0.0F, 3.0F, 0.0F);
    	rightArm2.addChild(rightHand);

    	((Modchu_ModelRenderer) bipedBody).removeChild(leftArm);
    	leftArm = new Modchu_ModelRenderer(this, 52, 8);
    	leftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, f);
    	leftArm.setRotationPoint(3.0F, 9.5F, 0.0F);
    	bipedBody.addChild(leftArm);

    	((Modchu_ModelRenderer) bipedBody).removeChild(leftArm2);
    	leftArm2 = new Modchu_ModelRenderer(this, 52, 13);
    	leftArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, f);
    	leftArm2.setRotationPoint(0.0F, 2.0F, 0.0F);
    	leftArm.addChild(leftArm2);

    	((Modchu_ModelRenderer) bipedBody).removeChild(leftHand);
    	leftHand = new Modchu_ModelRenderer(this, 52, 16);
    	leftHand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, f);
    	leftHand.setRotationPoint(0.0F, 3.0F, 0.0F);
    	leftArm2.addChild(leftHand);

    	rightHand.showModel = leftHand.showModel =
    		rightArm.showModel = leftArm.showModel =
    		rightArm2.showModel = leftArm2.showModel = false;
    }
}
