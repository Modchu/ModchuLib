package modchu.lib.replace;

import modchu.lib.replacepoint.Modchu_TextureDataReplacePoint;
import modchu.model.replacepoint.ModchuModel_TextureBoxReplacePoint;
import net.minecraft.util.ResourceLocation;

/**
 * Modchu_Texture仕様のテクスチャパック設定に対応しているEntityへ継承させる。
 */
public interface Modchu_ITextureEntityBase {

	/**
	 * Server用。
	 * TextureManagerがサーバー側のEntityへテクスチャ変更の通知を行う。
	 * @param pIndex
	 * 設定されるテクスチャパックのインデックス（TextureBoxServer）
	 */
	public void setTexturePackIndex(int pColor, int[] pIndex);

	/**
	 * Client用。
	 * TextureManagerがクライアント側のEntityへテクスチャ変更の通知を行う。
	 * @param pPackName
	 * 設定されるテクスチャパックの名称（TextureBoxClient）
	 */
	public void setTexturePackName(ModchuModel_TextureBoxReplacePoint[] pTextureBox);

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

	/**
	 * 仕様変更により、これ以外は必要無くなる予定。
	 * @return
	 */
	public Modchu_TextureDataReplacePoint getTextureData();


}
