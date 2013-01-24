
package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class ModelPlayerFormLittleMaid_long extends ModelPlayerFormLittleMaid_SR2
{
    public Modchu_ModelRenderer longhear;
	public Modchu_ModelRenderer kamidome;

    public ModelPlayerFormLittleMaid_long()
    {
        this(0.0F);
    }

    public ModelPlayerFormLittleMaid_long(float f)
    {
        this(f, 0.0F);
    }

    public ModelPlayerFormLittleMaid_long(float f, float f1)
    {
		// 132deletesuper(f, f1);
//-@-132
		this(f, f1 , 64, 32);
	}

	public ModelPlayerFormLittleMaid_long(float f, float f1, int i, int j) {
		super(f, f1, i, j);
//@-@132
	}

	@Override
	public void initModel(float f, float f1) {
		super.initModel(f, f1);
		longhear = new Modchu_ModelRenderer(this, 52, 12);
		longhear.addBox(-1.5F, -9F, 7F, 3, 17, 3);
		longhear.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(longhear);
		kamidome = new Modchu_ModelRenderer(this, 46, 19);
		kamidome.addBox(-1F, -7F, 6F, 2, 2, 1);
		kamidome.setRotationPointLM(0F, 0F, 0F);
		bipedHead.addChild(kamidome);

		kamidome.rotateAngleX=0.2974289F;
		longhear.rotateAngleX=0.2974289F;
		Tail.setVisible(false);
		SideTailL.setVisible(false);
		SideTailR.setVisible(false);
		ChignonB.setVisible(false);
    }

    @Override
    public void settingShowParts() {
    	super.settingShowParts();
    	//GUI パーツ表示・非表示初期設定
    	//前回の項目最後から6個上書きして設定
    	overridePartsNumber = 6;
    	int k = getPartsNumber() - overridePartsNumber;
    	if(k < 0) k = 0;
    	if(getPartsSetFlag() == 2) {
    		String s[] = {
    				"eyeR", "eyeL", "longhear", "kamidome"
    		};
    		setParts(s, k);
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
    		longhear.setVisible(b);
    		k++;
    		b = getGuiShowModel(k);
    		kamidome.setVisible(b);
    		Tail.setVisible(false);
    		SideTailL.setVisible(false);
    		SideTailR.setVisible(false);
    		ChignonB.setVisible(false);
    		setShowModelFlag(2);
    	}
    }

}