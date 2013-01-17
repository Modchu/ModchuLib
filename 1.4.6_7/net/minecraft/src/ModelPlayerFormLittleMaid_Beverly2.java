package net.minecraft.src;

public class ModelPlayerFormLittleMaid_Beverly2 extends ModelPlayerFormLittleMaid_Beverly3
{

    public ModelPlayerFormLittleMaid_Beverly2()
    {
    	this(0.0F);
    }

    public ModelPlayerFormLittleMaid_Beverly2(float f)
    {
    	this(f, 0.0F);
    }

    public ModelPlayerFormLittleMaid_Beverly2(float f, float f1)
    {
    	// 132deletesuper(f, f1);
//-@-132
    	this(f, f1 , 64, 64);
    }

    public ModelPlayerFormLittleMaid_Beverly2(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
//@-@132
    }

    @Override
    public void initModel(float f, float f1) {
    	super.initModel(f, f1);
    	//((Modchu_ModelRenderer) bipedBody).removeChild(leftArm2);
    	leftArm2.removeChild(shield);
    	((Modchu_ModelRenderer) bipedHead).clearChildModels();
    	mainFrame.clearChildModels();
    	eyeR = new Modchu_ModelRenderer(this);
    	eyeL = new Modchu_ModelRenderer(this);
    	shield = new Modchu_ModelRenderer(this);

    	//bipedBody.addChild(leftArm2);
    	bipedHead.addChild(Headwear);
    	mainFrame.addChild(bipedHead);
    	mainFrame.addChild(bipedBody);
    }
}
