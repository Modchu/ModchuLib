package modchu.lib.characteristic;

import net.minecraft.src.ResourceLocation;

public interface Modchu_ITextureEntityBase {

	public void setTexturePackIndex(int pColor, int[] pIndex);
	public void setTexturePackName(Modchu_TextureBoxBase[] pTextureBox);

	/**
	 * 現在のEntityに色を設定する。
	 * @param pColor
	 */
	public void setColor(int pColor);

	/**
	 * 現在のEntityに設定されている色を返す。
	 * @return
	 */
	public int getColor();

	public void setContract(boolean pContract);
	public boolean isContract();

	public void setTextureBox(Modchu_TextureBoxBase[] pTextureBox);
	public Modchu_TextureBoxBase[] getTextureBox();

	public void setTextureIndex(int[] pTextureIndex);
	public int[] getTextureIndex();

	public void setTextures(int pIndex, ResourceLocation[] pNames);
	public ResourceLocation[] getTextures(int pIndex);

	public Modchu_TextureDataBase getTextureData();


}
