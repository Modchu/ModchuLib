package modchu.lib.replace;

import modchu.model.ModchuModel_IModelCaps;
import modchu.model.ModchuModel_ModelCapsHelper;
import modchu.model.replacepoint.ModchuModel_HelperReplacePoint;
import modchu.model.replacepoint.ModchuModel_TextureBoxReplacePoint;

public class Modchu_TextureBoxServer extends Modchu_TextureBoxBase {

	// ローカルでモデルを保持している時にリンク
	public ModchuModel_TextureBoxReplacePoint localBox;


	public Modchu_TextureBoxServer() {
	}

	public Modchu_TextureBoxServer(ModchuModel_TextureBoxReplacePoint pBox) {
		localBox		= pBox;
		contractColor	= pBox.getContractColorBits();
		wildColor		= pBox.getWildColorBits();
		textureName		= pBox.textureName;
		isUpdateSize = (pBox.models != null && pBox.models[0] != null) ?
				ModchuModel_ModelCapsHelper.getCapsValueBoolean(pBox.models[0], ModchuModel_IModelCaps.caps_isUpdateSize) : false;
/*
		if (pBox.models != null) {
			modelHeight			= pBox.models[0].getHeight(null);
			modelWidth			= pBox.models[0].getWidth(null);
			modelYOffset		= pBox.models[0].getyOffset(null);
			modelMountedYOffset	= pBox.models[0].getMountedYOffset(null);
		}
*/
	}

	/*
	 * ModchuModel_Statics.Server_GetTextureIndex
	 */
	public void setValue(byte[] pData) {
		contractColor		= ModchuModel_HelperReplacePoint.getShort(pData, 2);
		wildColor			= ModchuModel_HelperReplacePoint.getShort(pData, 4);
		modelHeight			= ModchuModel_HelperReplacePoint.getFloat(pData, 6);
		modelWidth			= ModchuModel_HelperReplacePoint.getFloat(pData, 10);
		modelYOffset		= ModchuModel_HelperReplacePoint.getFloat(pData, 14);
		modelMountedYOffset	= ModchuModel_HelperReplacePoint.getFloat(pData, 18);
		textureName			= ModchuModel_HelperReplacePoint.getStr(pData, 22);
	}

	@Override
	public float getHeight(ModchuModel_IModelCaps pEntityCaps) {
		return localBox != null ? localBox.models[0].getHeight(pEntityCaps) : modelHeight;
	}

	@Override
	public float getWidth(ModchuModel_IModelCaps pEntityCaps) {
		return localBox != null ? localBox.models[0].getWidth(pEntityCaps) : modelWidth;
	}

	@Override
	public float getYOffset(ModchuModel_IModelCaps pEntityCaps) {
		return localBox != null ? localBox.models[0].getyOffset(pEntityCaps) : modelYOffset;
	}

	@Override
	public float getMountedYOffset(ModchuModel_IModelCaps pEntityCaps) {
		return localBox != null ? localBox.models[0].getMountedYOffset(pEntityCaps) : modelMountedYOffset;
	}

}
