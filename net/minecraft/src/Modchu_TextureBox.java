package net.minecraft.src;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Modchu_TextureBox {

	/**
	 * �e�N�X�`���p�b�N�̖���
	 */
	public String packegeName;
	public Map<Integer, String> textures;
	public Map<String, Map<Integer, String>> armors;
	public String modelName;
	public MultiModelBaseBiped[] models;
	/**
	 * pName, pTextureDir, pClassPrefix
	 */
	public String[] textureDir;



	public Modchu_TextureBox() {
		textures = new HashMap<Integer, String>();
		armors = new TreeMap<String, Map<Integer, String>>();
	}
	public Modchu_TextureBox(String pName, String[] pSearch) {
		this();
		packegeName = pName;
		textureDir = pSearch;
	}


	/**
	 * �e�N�X�`���̃t���p�X��Ԃ��B
	 * �o�^�C���f�b�N�X�������ꍇ��NULL��Ԃ��B
	 */
	public String getTextureName(int pIndex) {
		if (textures.containsKey(pIndex)) {
			if (textureDir != null) {
				return (new StringBuilder()).append(textureDir[1]).append(packegeName.replace('.', '/')).append(textures.get(pIndex)).toString();
			}
		}
		return null;
	}

	public String getArmorTextureName(int index, ItemStack itemstack) {
		// index��0x40,0x50�ԑ�
		if (armors.isEmpty() || itemstack == null) return null;
		if (!(itemstack.getItem() instanceof ItemArmor)) return null;

		Map<Integer, String> m = armors.get(Modchu_TextureManager.armorFilenamePrefix[((ItemArmor)itemstack.getItem()).renderIndex]);
		if (m == null) {
			m = armors.get("default");
			if (m == null) return null;
		}
		int l = 0;
		if (itemstack.getMaxDamage() > 0) {
			l = (10 * itemstack.getItemDamage() / itemstack.getMaxDamage());
		}
		String s = null;
		for (int i = index + l; i >= index; i--) {
			s = m.get(i);
			if (s != null) break;
		}
		if (s == null) {
			return null;
		} else {
			return (new StringBuilder()).append(textureDir[1]).append(packegeName.replace('.', '/')).append(s).toString();
		}
	}

	/**
	 * �쐶�F�̗L�����r�b�g�z��ɂ��ĕԂ�
	 */
	public int getContractColorBits() {
		int li = 0;
		for (Integer i : textures.keySet()) {
			if (i >= 0x00 && i <= 0x0f) {
				li |= 1 << (i & 0x0f);
			}
		}
		return li;
	}
	/**
	 * �쐶�F�̗L�����r�b�g�z��ɂ��ĕԂ�
	 */
	public int getWildColorBits() {
		int li = 0;
		for (Integer i : textures.keySet()) {
			if (i >= 0x30 && i <= 0x3f) {
				li |= 1 << (i & 0x0f);
			}
		}
		return li;
	}

	public boolean hasColor(int pIndex) {
		return textures.containsKey(pIndex);
	}

	public boolean hasArmor() {
		return !armors.isEmpty();
	}

	public void setModels(String pName, MultiModelBaseBiped[] pModels) {
		modelName = pName;
		models = pModels;
	}

}
