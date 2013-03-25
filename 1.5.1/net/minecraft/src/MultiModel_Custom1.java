package net.minecraft.src;

public class MultiModel_Custom1 extends MultiModelCustom {

	public MultiModel_Custom1()
	{
		this(0.0F);
	}

	public MultiModel_Custom1(float f)
	{
		this(f, 0.0F);
	}

	public MultiModel_Custom1(float f, float f1)
	{
		this(f, f1 , 64, 32);
	}

	public MultiModel_Custom1(float f, float f1, int i, int j) {
		super(f, f1, i, j);
		String s = getClass().getSimpleName();
		s = s.substring(s.lastIndexOf("_Custom") + 7);
		customModel = new Modchu_CustomModel(this, s, f, f1);
	}
}