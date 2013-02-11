
package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class MultiModel_twinD extends MultiModel_SR2
{
    public Modchu_ModelRenderer longhearR;
    public Modchu_ModelRenderer longhearL;
    public Modchu_ModelRenderer kamidomeR;
    public Modchu_ModelRenderer kamidomeL;

    public MultiModel_twinD()
    {
        this(0.0F);
    }

    public MultiModel_twinD(float f)
    {
        this(f, 0.0F);
    }

    public MultiModel_twinD(float f, float f1)
    {
    	this(f, f1 , 64, 32);
    }

    public MultiModel_twinD(float f, float f1, int i, int j) {
    	super(f, f1, i, j);
    }

	@Override
	public void initModel(float f, float f1) {
		super.initModel(f, f1);
		longhearR = new Modchu_ModelRenderer(this, 52, 13);
		longhearR.addBox(2.5F, -8F, 7.4F, 2, 18, 1);
		longhearR.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(longhearR);

		longhearL = new Modchu_ModelRenderer(this, 58, 13);
		longhearL.addBox(-4.5F, -8F, 7.4F, 2, 18, 1);
		longhearL.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(longhearL);

		kamidomeR = new Modchu_ModelRenderer(this, 46, 19);
		kamidomeR.addBox(1F, -7F, 6.5F, 2, 2, 1);
		kamidomeR.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(kamidomeR);

		kamidomeL = new Modchu_ModelRenderer(this, 46, 22);
		kamidomeL.addBox(-3F, -7F, 6.5F, 2, 2, 1);
		kamidomeL.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(kamidomeL);

		longhearR.rotateAngleX=longhearL.rotateAngleX=kamidomeR.rotateAngleX=kamidomeL.rotateAngleX=0.296706F;
		longhearR.rotateAngleY=kamidomeR.rotateAngleY=0.296706F;
		longhearL.rotateAngleY=kamidomeL.rotateAngleY=-0.296706F;
		longhearR.rotateAngleZ=-0.1745329F;
		longhearL.rotateAngleZ=0.1745329F;
		setVisible(Tail, false);
		setVisible(SideTailL, false);
		setVisible(SideTailR, false);
		setVisible(ChignonB, false);
    }

    @Override
    public void defaultPartsSettingBefore() {
    	super.defaultPartsSettingBefore();
    	String[] s = {
    			"Tail", "SideTailL", "SideTailR", "ChignonB"
    	};
    	showPartsHideListadd(s);
    }

    @Override
    public void showModelSettingReflects() {
    	super.showModelSettingReflects();
    	setVisible(Tail, false);
    	setVisible(SideTailL, false);
    	setVisible(SideTailR, false);
    	setVisible(ChignonB, false);
    }
}