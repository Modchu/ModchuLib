package modchu.lib;

import modchu.lib.characteristic.Modchu_IEntityCapsBase;

public interface Modchu_IModelBaseDuo {
	public void superRender(Object entity, float par2, float par3, float par4, float par5, float par6, float par7);
	public boolean getIsAlphablend();
	public boolean getIsModelAlphablend();
	public Object getModelInner();
	public Object getModelOuter();
	public Object[] getTextureInner();
	public Object[] getTextureOuter();
	public Object[] getTextureInnerLight();
	public Object[] getTextureOuterLight();
	public float[] getTextureLightColor();
	public int getRenderParts();
	public int getLighting();

}
