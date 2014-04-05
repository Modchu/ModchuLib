package modchu.lib.replace;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import modchu.lib.replacepoint.Modchu_ModelMultiReplacePoint;
import modchu.model.ModchuModel_IModelCaps;
import modchu.model.ModchuModel_ModelCapsHelper;
import modchu.model.replacepoint.ModchuModel_TextureManagerReplacePoint;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class Modchu_TextureBoxBase extends Modchu_TextureBoxBaseBase {

	/**
	 * テクスチャパックの名称、モデル指定詞の前までの文字列。
	 */
	public String packegeName;
	/**
	 * テクスチャファイルのファイル名リスト。
	 */
	public Map<Integer, ResourceLocation> textures;
	/**
	 * アーマーファイルのファイル名リスト。
	 */
	public Map<String, Map<Integer, ResourceLocation>> armors;
	/**
	 * モデル指定詞
	 */
	public String modelName;
	/**
	 * マルチモデルクラス
	 */
	public Modchu_ModelMultiReplacePoint[] models;
	/**
	 * pName, pTextureDir, pClassPrefix
	 */
	public String[] textureDir;
	/**
	 * テクスチャの格納されているパックの名前（モデルに関係なし）
	 */
	public String fileName;



	public Modchu_TextureBoxBase() {
		textures = new HashMap<Integer, ResourceLocation>();
		armors = new TreeMap<String, Map<Integer, ResourceLocation>>();
		modelHeight = modelWidth = modelYOffset = modelMountedYOffset = 0.0F;
		contractColor = -1;
		wildColor = -1;
	}

	public Modchu_TextureBoxBase(String pTextureName, String[] pSearch) {
		this();
		textureName = pTextureName;
		fileName = pTextureName;
		int li = pTextureName.lastIndexOf("_");
		if (li > -1) {
			packegeName = pTextureName.substring(0, li);
			modelName = pTextureName.substring(li + 1);
		} else {
			packegeName = pTextureName;
			modelName = "";
		}
		textureDir = pSearch;
	}

	public void setModels(String pModelName, Modchu_ModelMultiReplacePoint[] pModels, Modchu_ModelMultiReplacePoint[] pDefModels) {
		modelName = pModelName;
		models = pModels == null ? pDefModels : pModels;
		textureName = (new StringBuilder()).append(packegeName).append("_").append(modelName).toString();
		isUpdateSize = (models != null && models[0] != null) ? ModchuModel_ModelCapsHelper.getCapsValueBoolean(models[0], ModchuModel_IModelCaps.caps_isUpdateSize) : false;
	}

	/**
	 * テクスチャのフルパスを返す。
	 * 登録インデックスが無い場合はNULLを返す。
	 */
	public ResourceLocation getTextureName(int pIndex) {
		if (textures.containsKey(pIndex)) {
			return textures.get(pIndex);
		} else if (pIndex >= ModchuModel_TextureManagerReplacePoint.tx_eyecontract && pIndex < (16 + ModchuModel_TextureManagerReplacePoint.tx_eyecontract)) {
			return getTextureName(ModchuModel_TextureManagerReplacePoint.tx_oldeye);
		} else if (pIndex >= ModchuModel_TextureManagerReplacePoint.tx_eyewild && pIndex < (16 + ModchuModel_TextureManagerReplacePoint.tx_eyewild)) {
			return getTextureName(ModchuModel_TextureManagerReplacePoint.tx_oldeye);
		}
		return null;
	}

	public ResourceLocation getArmorTextureName(int pIndex, ItemStack itemstack) {
		// indexは0x40,0x50番台
		// lightも追加
		if (armors.isEmpty() || itemstack == null) return null;
		if (!(itemstack.getItem() instanceof ItemArmor)) return null;

		int l = 0;
		if (itemstack.getMaxDamage() > 0) {
			l = (10 * itemstack.getItemDamage() / itemstack.getMaxDamage());
		}
		return getArmorTextureName(pIndex, ModchuModel_TextureManagerReplacePoint.armorFilenamePrefix[((ItemArmor)itemstack.getItem()).renderIndex], l);
	}
	public ResourceLocation getArmorTextureName(int pIndex, String pArmorPrefix, int pDamage) {
		// indexは0x40,0x50番台
		if (armors.isEmpty() || pArmorPrefix == null) return null;

		Map<Integer, ResourceLocation> m = armors.get(pArmorPrefix);
		if (m == null) {
			m = armors.get("default");
			if (m == null) {
//				return null;
				m = (Map)armors.values().toArray()[0];
			}
		}
		ResourceLocation ls = null;
//		int lindex = pInner ? ModchuModel_TextureManager.tx_armor1 : ModchuModel_TextureManager.tx_armor2;
		for (int i = pIndex + pDamage; i >= pIndex; i--) {
			ls = m.get(i);
			if (ls != null) break;
		}
		return ls;
	}

	/**
	 * 契約色の有無をビット配列にして返す
	 */
	@Override
	public int getContractColorBits() {
		if (contractColor == -1) {
			int li = 0;
			for (Integer i : textures.keySet()) {
				if (i >= 0x00 && i <= 0x0f) {
					li |= 1 << (i & 0x0f);
				}
			}
			contractColor = li;
		}
		return contractColor;
	}
	/**
	 * 野生色の有無をビット配列にして返す
	 */
	@Override
	public int getWildColorBits() {
		if (wildColor == -1) {
			int li = 0;
			for (Integer i : textures.keySet()) {
				if (i >= ModchuModel_TextureManagerReplacePoint.tx_wild && i <= (ModchuModel_TextureManagerReplacePoint.tx_wild + 0x0f)) {
					li |= 1 << (i & 0x0f);
				}
			}
			wildColor = li;
		}
		return wildColor;
	}

	public boolean hasColor(int pIndex) {
		return textures.containsKey(pIndex);
	}

	public boolean hasColor(int pIndex, boolean pContract) {
		return textures.containsKey(pIndex + (pContract ? 0 : ModchuModel_TextureManagerReplacePoint.tx_wild));
	}

	public boolean hasArmor() {
		return !armors.isEmpty();
	}

	@Override
	public float getHeight(ModchuModel_IModelCaps pEntityCaps) {
		return models != null ? models[0].getHeight(pEntityCaps) : modelHeight;
	}

	@Override
	public float getWidth(ModchuModel_IModelCaps pEntityCaps) {
		return models != null ? models[0].getWidth(pEntityCaps) : modelWidth;
	}

	@Override
	public float getYOffset(ModchuModel_IModelCaps pEntityCaps) {
		return models != null ? models[0].getyOffset(pEntityCaps) : modelYOffset;
	}

	@Override
	public float getMountedYOffset(ModchuModel_IModelCaps pEntityCaps) {
		return models != null ? models[0].getMountedYOffset(pEntityCaps) : modelMountedYOffset;
	}

	public Modchu_TextureBoxBase duplicate() {
		Modchu_TextureBoxBase lbox = new Modchu_TextureBoxBase();
		lbox.textureName = textureName;
		lbox.packegeName = packegeName;
		lbox.fileName = fileName;
		lbox.modelName = modelName;
		lbox.textureDir = textureDir;
		lbox.textures = textures;
		lbox.armors = armors;
		lbox.models = models;
		lbox.isUpdateSize = lbox.isUpdateSize;

		return lbox;
	}

	public boolean addTexture(int pIndex, String pLocation) {
		String ls;
		ls = "/assets/minecraft/";
		if (pLocation.startsWith(ls)) {
			pLocation = pLocation.substring(ls.length());
		} else {
//			pLocation = "../.." + pLocation;
		}
		boolean lflag = false;
		switch ((pIndex & 0xfff0)) {
		case ModchuModel_TextureManagerReplacePoint.tx_armor1:
		case ModchuModel_TextureManagerReplacePoint.tx_armor2:
		case ModchuModel_TextureManagerReplacePoint.tx_armor1light:
		case ModchuModel_TextureManagerReplacePoint.tx_armor2light:
		case ModchuModel_TextureManagerReplacePoint.tx_oldarmor1:
		case ModchuModel_TextureManagerReplacePoint.tx_oldarmor2:
			ls = pLocation.substring(pLocation.lastIndexOf("/") + 1, pLocation.lastIndexOf("_"));
			Map<Integer, ResourceLocation> lmap;
			if (armors.containsKey(ls)) {
				lmap = armors.get(ls);
			} else {
				lmap = new HashMap<Integer, ResourceLocation>();
				armors.put(ls, lmap);
			}
			lmap.put(pIndex, new ResourceLocation(pLocation));
			break;

		default:
			textures.put(pIndex, new ResourceLocation(pLocation));
			return true;
		}
		return lflag;
	}

}
