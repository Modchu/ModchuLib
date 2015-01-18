package modchu.lib.characteristic;

import modchu.lib.Modchu_EntityCapsHelper;
import modchu.model.ModchuModel_IEntityCaps;

public class Modchu_TextureBoxServer extends Modchu_TextureBoxBase {

	// ローカルでモデルを保持している時にリンク
	public Modchu_TextureBoxBase localBox;


	public Modchu_TextureBoxServer() {
	}

	public Modchu_TextureBoxServer(Modchu_TextureBoxBase pBox) {
		localBox		= pBox;
		contractColor	= pBox.getContractColorBits();
		wildColor		= pBox.getWildColorBits();
		textureName		= pBox.textureName;
		isUpdateSize = (pBox.models != null && pBox.models[0] != null) ?
				Modchu_EntityCapsHelper.getCapsValueBoolean(pBox.models[0], ModchuModel_IEntityCaps.caps_isUpdateSize) : false;
/*
		if (pBox.models != null) {
			modelHeight			= pBox.models[0].getHeight(null);
			modelWidth			= pBox.models[0].getWidth(null);
			modelYOffset		= pBox.models[0].getYOffset(null);
			modelMountedYOffset	= pBox.models[0].getMountedYOffset(null);
		}
*/
	}

	/*
	 * ModchuModel_Statics.Server_GetTextureIndex
	 */
	public void setValue(byte[] pData) {
		contractColor		= Modchu_HelperBase.getShort(pData, 2);
		wildColor			= Modchu_HelperBase.getShort(pData, 4);
		modelHeight			= Modchu_HelperBase.getFloat(pData, 6);
		modelWidth			= Modchu_HelperBase.getFloat(pData, 10);
		modelYOffset		= Modchu_HelperBase.getFloat(pData, 14);
		modelMountedYOffset	= Modchu_HelperBase.getFloat(pData, 18);
		textureName			= Modchu_HelperBase.getStr(pData, 22);
	}

	@Override
	public float getHeight(ModchuModel_IEntityCaps pEntityCaps) {
		return localBox != null ? localBox.models[0].getHeight(pEntityCaps) : modelHeight;
	}

	@Override
	public float getWidth(ModchuModel_IEntityCaps pEntityCaps) {
		return localBox != null ? localBox.models[0].getWidth(pEntityCaps) : modelWidth;
	}

	@Override
	public float getYOffset(ModchuModel_IEntityCaps pEntityCaps) {
		return localBox != null ? localBox.models[0].getYOffset(pEntityCaps) : modelYOffset;
	}

	@Override
	public float getMountedYOffset(ModchuModel_IEntityCaps pEntityCaps) {
		return localBox != null ? localBox.models[0].getMountedYOffset(pEntityCaps) : modelMountedYOffset;
	}

}
