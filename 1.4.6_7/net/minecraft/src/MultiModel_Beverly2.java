package net.minecraft.src;

public class MultiModel_Beverly2 extends MultiModel_Beverly3
{

    public MultiModel_Beverly2()
    {
    	this(0.0F);
    }

    public MultiModel_Beverly2(float f)
    {
    	this(f, 0.0F);
    }

    public MultiModel_Beverly2(float f, float f1)
    {
    	// 132deletesuper(f, f1);
//-@-132
    	this(f, f1 , 64, 64);
    }

    public MultiModel_Beverly2(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
//@-@132
    }

    @Override
    public void initModel(float f, float f1) {
    	super.initModel(f, f1);
    	leftArm2.removeChild(shield);
    	((Modchu_ModelRenderer) bipedHead).clearChildModels();
    	mainFrame.clearChildModels();
    	eyeR = new Modchu_ModelRenderer(this);
    	eyeL = new Modchu_ModelRenderer(this);
    	shield = new Modchu_ModelRenderer(this);

    	bipedHead.addChild(Headwear);
    	mainFrame.addChild(bipedHead);
    	mainFrame.addChild(bipedBody);
    }
}
