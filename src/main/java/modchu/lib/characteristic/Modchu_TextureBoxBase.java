package modchu.lib.characteristic;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import modchu.lib.Modchu_EntityCapsHelper;
import modchu.lib.Modchu_Main;
import modchu.lib.Modchu_Reflect;
import modchu.lib.Modchu_TextureManagerBase;
import modchu.model.multimodel.base.MultiModelBaseBiped;

public class Modchu_TextureBoxBase extends Modchu_TextureBoxBaseBase {

	/**
	 * テクスチャパックの名称、モデル指定詞の前までの文字列。
	 */
	public String packegeName;
	/**
	 * テクスチャファイルのファイル名リスト。
	 */
	public Map<Integer, Object> textures;
	/**
	 * アーマーファイルのファイル名リスト。
	 */
	public Map<String, Map<Integer, Object>> armors;
	/**
	 * モデル指定詞
	 */
	public String modelName;
	/**
	 * マルチモデルクラス
	 */
	public MultiModelBaseBiped[] models;
	/**
	 * pName, pTextureDir, pClassPrefix
	 */
	public String[] textureDir;
	/**
	 * テクスチャの格納されているパックの名前（モデルに関係なし）
	 */
	public String fileName;



	public Modchu_TextureBoxBase() {
		textures = new HashMap<Integer, Object>();
		armors = new TreeMap<String, Map<Integer, Object>>();
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

	public void setModels(String pModelName, MultiModelBaseBiped[] pModels, MultiModelBaseBiped[] pDefModels) {
		modelName = pModelName;
		models = pModels != null ? pModels : pDefModels;
		textureName = (new StringBuilder()).append(packegeName).append("_").append(modelName).toString();
		isUpdateSize = (models != null
				&& models.length > 0
				&& models[0] != null) ? Modchu_EntityCapsHelper.getCapsValueBoolean(models[0], Modchu_IEntityCapsBase.caps_isUpdateSize) : false;
		//Modchu_Debug.mDebug("setModels models[0].getClass()="+models[0].getClass());
	}

	/**
	 * テクスチャのフルパスを返す。
	 * 登録インデックスが無い場合はNULLを返す。
	 */
	public Object getTextureName(int pIndex) {
		if (textures.containsKey(pIndex)) {
			return textures.get(pIndex);
		} else if (pIndex >= Modchu_TextureManagerBase.tx_eyecontract && pIndex < (16 + Modchu_TextureManagerBase.tx_eyecontract)) {
			return getTextureName(Modchu_TextureManagerBase.tx_oldeye);
		} else if (pIndex >= Modchu_TextureManagerBase.tx_eyewild && pIndex < (16 + Modchu_TextureManagerBase.tx_eyewild)) {
			return getTextureName(Modchu_TextureManagerBase.tx_oldeye);
		}
		return null;
	}

	public Object getArmorTextureName(int pIndex, Object itemStack) {
		// indexは0x40,0x50番台
		// lightも追加
		if (armors.isEmpty() || itemStack == null) return null;
		Object item = Modchu_AS.get(Modchu_AS.itemStackGetItem, itemStack);
		if (!Modchu_Reflect.loadClass("ItemArmor").isInstance(item)) return null;

		int l = 0;
		int maxDamage = Modchu_AS.getInt(Modchu_AS.itemStackGetMaxDamage, itemStack);
		if (maxDamage > 0) {
			l = (10 * Modchu_AS.getInt(Modchu_AS.itemStackGetItemDamage, itemStack) / maxDamage);
		}
		String s = Modchu_Main.getMinecraftVersion() > 179 ? Modchu_AS.getString(Modchu_AS.itemArmorArmorMaterialGetName, Modchu_AS.get(Modchu_AS.itemArmorGetArmorMaterial, item)) : Modchu_TextureManagerBase.armorFilenamePrefix[Modchu_AS.getInt(Modchu_AS.itemArmorRenderIndex, item)];
		return getArmorTextureName(pIndex, s, l);
	}

	public Object getArmorTextureName(int pIndex, String pArmorPrefix, int pDamage) {
		// indexは0x40,0x50番台
		if (armors.isEmpty() || pArmorPrefix == null) return null;

		Map<Integer, Object> m = armors.get(pArmorPrefix);
		if (m == null) {
			m = armors.get("default");
			if (m == null) {
//				return null;
				m = (Map)armors.values().toArray()[0];
			}
		}
		Object ls = null;
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
				if (i >= Modchu_TextureManagerBase.tx_wild && i <= (Modchu_TextureManagerBase.tx_wild + 0x0f)) {
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
		return textures.containsKey(pIndex + (pContract ? 0 : Modchu_TextureManagerBase.tx_wild));
	}

	public boolean hasArmor() {
		return !armors.isEmpty();
	}

	@Override
	public float getHeight(Modchu_IEntityCapsBase entityCaps) {
		return models != null ? models[0].getHeight(entityCaps) : modelHeight;
	}

	@Override
	public float getWidth(Modchu_IEntityCapsBase entityCaps) {
		return models != null ? models[0].getWidth(entityCaps) : modelWidth;
	}

	@Override
	public float getYOffset(Modchu_IEntityCapsBase entityCaps) {
		return models != null ? models[0].getYOffset(entityCaps) : modelYOffset;
	}

	@Override
	public float getMountedYOffset(Modchu_IEntityCapsBase entityCaps) {
		return models != null ? models[0].getMountedYOffset(entityCaps) : modelMountedYOffset;
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
		lbox.isUpdateSize = isUpdateSize;

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
		case Modchu_TextureManagerBase.tx_armor1:
		case Modchu_TextureManagerBase.tx_armor2:
		case Modchu_TextureManagerBase.tx_armor1light:
		case Modchu_TextureManagerBase.tx_armor2light:
		case Modchu_TextureManagerBase.tx_oldarmor1:
		case Modchu_TextureManagerBase.tx_oldarmor2:
			//Modchu_Debug.mDebug("Modchu_TextureBoxBase addTexture pLocation="+pLocation);
			ls = pLocation.substring(pLocation.lastIndexOf("/") + 1, pLocation.lastIndexOf("_"));
			//Modchu_Debug.mDebug("Modchu_TextureBoxBase addTexture ls="+ls);
			Map<Integer, Object> lmap;
			if (armors.containsKey(ls)) {
				lmap = armors.get(ls);
			} else {
				lmap = new HashMap<Integer, Object>();
				armors.put(ls, lmap);
			}
			lmap.put(pIndex, Modchu_Main.newResourceLocation(pLocation));
			break;

		default:
			textures.put(pIndex, Modchu_Main.newResourceLocation(pLocation));
			return true;
		}
		return lflag;
	}

}
