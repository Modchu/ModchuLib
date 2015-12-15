package modchu.lib.lmm.common.mc172_188;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Random;

import mmmlibx.lib.MMM_TextureBox;
import mmmlibx.lib.multiModel.model.mc162.IModelCaps;
import mmmlibx.lib.multiModel.model.mc162.ModelMultiBase;
import modchu.lib.Modchu_Debug;
import modchu.model.ModchuModel_IEntityCaps;
import modchu.model.ModchuModel_ModelDataMaster;
import modchu.model.ModchuModel_TextureBoxBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class Modchu_LmmXTextureBox extends MMM_TextureBox {

	public ModchuModel_TextureBoxBase master;

	public Modchu_LmmXTextureBox(ModchuModel_TextureBoxBase textureBox) {
		super();
		init(textureBox, (Object[]) null);
		textureName = textureBox.textureName;
		fileName = textureName;
		int li = textureName.lastIndexOf("_");
		if (li > -1) {
			packegeName = textureName.substring(0, li);
			modelName = textureName.substring(li + 1);
		} else {
			packegeName = textureName;
			modelName = "";
		}
		textureDir = textureBox.textureDir;
		//Modchu_Debug.lDebug("Modchu_LmmXTextureBox textureBox.textures="+textureBox.textures);
		if (textureBox.textures != null
				&& !textureBox.textures.isEmpty()) {
			Map<Integer, ResourceLocation> map = new HashMap();
			for (Entry<Integer, Object> en : ((Map<Integer, Object>) textureBox.textures).entrySet()) {
				//Modchu_Debug.lDebug("Modchu_LmmXTextureBox en.getValue()="+en.getValue());
				map.put(en.getKey(), (ResourceLocation) en.getValue());
			}
			textures = map;
			//Modchu_Debug.lDebug("Modchu_LmmXTextureBox end. textures="+textures);
		}
		if (textureBox.armors != null
				&& !textureBox.armors.isEmpty()) {
			Map<String, Map<Integer, ResourceLocation>> map2 = new TreeMap();
			for (Entry<String, Map<Integer, Object>> en : ((Map<String, Map<Integer, Object>>) textureBox.armors).entrySet()) {
				String key = en.getKey();
				Map<Integer, Object> mapValue = en.getValue();
				Map<Integer, ResourceLocation> map3 = new HashMap();
				for (Entry<Integer, Object> en2 : ((Map<Integer, Object>) mapValue).entrySet()) {
					//Modchu_Debug.lDebug("Modchu_LmmXTextureBox armors en2.getValue()="+en2.getValue());
					map3.put(en2.getKey(), (ResourceLocation) en2.getValue());
				}
				map2.put(key, map3);
			}
			armors = map2;
			//Modchu_Debug.lDebug("Modchu_LmmXTextureBox end. armors="+armors);
		}
	}

	public Modchu_LmmXTextureBox(ModchuModel_TextureBoxBase textureBox, String pTextureName, String[] pSearch) {
		super(pTextureName, pSearch);
		init(textureBox, pTextureName, pSearch);
		textureName = pTextureName;
		fileName = textureName;
		int li = textureName.lastIndexOf("_");
		if (li > -1) {
			packegeName = textureName.substring(0, li);
			modelName = textureName.substring(li + 1);
		} else {
			packegeName = textureName;
			modelName = "";
		}
		textureDir = pSearch;
	}

	public void init(ModchuModel_TextureBoxBase textureBox, Object... o) {
		if (textureBox != null) ;else throw new RuntimeException("ModchuModel_LmmTextureBox init textureBox null !!");
		//Modchu_Debug.mDebug("ModchuModel_LmmTextureBox textureBox="+textureBox);
		master = textureBox;
	}

	private ModchuModel_IEntityCaps getModchu_IModelCaps(Object iModelCaps) {
		return ModchuModel_ModelDataMaster.instance.getPlayerData(iModelCaps);
	}

	@Override
	public void setModels(String pModelName, ModelMultiBase[] MultiModelBaseBiped, ModelMultiBase[] MultiModelBaseBiped1) {
		//if (master != null) master.setModels(pModelName, MultiModelBaseBiped, MultiModelBaseBiped1);
		//else
			super.setModels(pModelName, MultiModelBaseBiped, MultiModelBaseBiped1);
	}

	public void superSetModels(String pModelName, Object[] MultiModelBaseBiped, Object[] MultiModelBaseBiped1) {
		super.setModels(pModelName, (ModelMultiBase[]) MultiModelBaseBiped, (ModelMultiBase[]) MultiModelBaseBiped1);
	}

	@Override
	public ResourceLocation getTextureName(int pIndex) {
		return (ResourceLocation) (master != null ? master.getTextureName(pIndex) : super.getTextureName(pIndex));
	}

	public ResourceLocation superGetTextureName(int pIndex) {
		return super.getTextureName(pIndex);
	}

	@Override
	public ResourceLocation getArmorTextureName(int pIndex, ItemStack itemStack) {
		return (ResourceLocation) (master != null ? master.getArmorTextureName(pIndex, itemStack) : super.getArmorTextureName(pIndex, itemStack));
	}

	public ResourceLocation superGetArmorTextureName(int pIndex, Object itemStack) {
		return super.getArmorTextureName(pIndex, (ItemStack) itemStack);
	}

	@Override
	public ResourceLocation getArmorTextureName(int pIndex, String pArmorPrefix, int pDamage) {
		return (ResourceLocation) (master != null ? master.getArmorTextureName(pIndex, pArmorPrefix, pDamage) : super.getArmorTextureName(pIndex, pArmorPrefix, pDamage));
	}

	public ResourceLocation superGetArmorTextureName(int pIndex, String pArmorPrefix, int pDamage) {
		return super.getArmorTextureName(pIndex, pArmorPrefix, pDamage);
	}

	@Override
	public int getContractColorBits() {
		return master != null ? master.getContractColorBits() : super.getContractColorBits();
	}

	public int superGetContractColorBits() {
		return super.getContractColorBits();
	}

	@Override
	public int getWildColorBits() {
		return master != null ? master.getWildColorBits() : super.getWildColorBits();
	}

	public int superGetWildColorBits() {
		return super.getWildColorBits();
	}

	@Override
	public boolean hasColor(int pIndex) {
		return master != null ? master.hasColor(pIndex) : super.hasColor(pIndex);
	}

	public boolean superHasColor(int pIndex) {
		return super.hasColor(pIndex);
	}

	@Override
	public boolean hasColor(int pIndex, boolean pContract) {
		return master != null ? master.hasColor(pIndex, pContract) : super.hasColor(pIndex, pContract);
	}

	public boolean superHasColor(int pIndex, boolean pContract) {
		return super.hasColor(pIndex, pContract);
	}

	@Override
	public boolean hasArmor() {
		return master != null ? master.hasArmor() : super.hasArmor();
	}

	public boolean superHasArmor() {
		return super.hasArmor();
	}

	@Override
	public float getHeight(IModelCaps iModelCaps) {
		return super.getHeight(iModelCaps);
	}

	public float superGetHeight(Object iModelCaps) {
		return super.getHeight((IModelCaps) iModelCaps);
	}

	@Override
	public float getWidth(IModelCaps iModelCaps) {
		return super.getWidth(iModelCaps);
	}

	public float superGetWidth(Object iModelCaps) {
		return super.getWidth((IModelCaps) iModelCaps);
	}

	@Override
	public float getYOffset(IModelCaps iModelCaps) {
		return super.getYOffset(iModelCaps);
	}

	public float superGetyOffset(Object iModelCaps) {
		return super.getYOffset((IModelCaps) iModelCaps);
	}

	@Override
	public float getMountedYOffset(IModelCaps iModelCaps) {
		return super.getMountedYOffset(iModelCaps);
	}

	public float superGetMountedyOffset(Object iModelCaps) {
		return super.getMountedYOffset((IModelCaps) iModelCaps);
	}

	@Override
	public MMM_TextureBox duplicate() {
		return (MMM_TextureBox) (master != null ? master.duplicate() : super.duplicate());
	}

	public MMM_TextureBox superDuplicate() {
		return super.duplicate();
	}

	@Override
	public boolean addTexture(int pIndex, String pLocation) {
		return master != null ? master.addTexture(pIndex, pLocation) : super.addTexture(pIndex, pLocation);
	}

	public boolean superAddTexture(int pIndex, String pLocation) {
		return super.addTexture(pIndex, pLocation);
	}

	@Override
	public void setModelSize(float pHeight, float pWidth, float pyOffset, float pMountedyOffset) {
		super.setModelSize(pHeight, pWidth, pyOffset, pMountedyOffset);
	}

	public void superSetModelSize(float pHeight, float pWidth, float pyOffset, float pMountedyOffset) {
		super.setModelSize(pHeight, pWidth, pyOffset, pMountedyOffset);
	}
/*
	@Override
	protected int getRandomColor(int pColor, Random random) {
		return master != null ? master.getRandomColor(pColor, random) : super.getRandomColor(pColor, random);
	}
*/
	public int superGetRandomColor(int pColor, Object random) {
		return super.getRandomColor(pColor, (Random) random);
	}

	@Override
	public int getRandomWildColor(Random random) {
		return master != null ? master.getRandomWildColor(random) : super.getRandomWildColor(random);
	}

	public int superGetRandomWildColor(Object random) {
		return super.getRandomWildColor((Random) random);
	}

	@Override
	public int getRandomContractColor(Random random) {
		return master != null ? master.getRandomContractColor(random) : super.getRandomContractColor(random);
	}

	public int superGetRandomContractColor(Object random) {
		return super.getRandomContractColor((Random) random);
	}

	@Override
	public float getHeight() {
		return super.getHeight();
	}

	public float superGetHeight() {
		return super.getHeight();
	}

	@Override
	public float getWidth() {
		return super.getWidth();
	}

	public float superGetWidth() {
		return super.getWidth();
	}

	@Override
	public float getYOffset() {
		return super.getYOffset();
	}

	public float superGetYOffset() {
		return super.getYOffset();
	}

	@Override
	public float getMountedYOffset() {
		return super.getMountedYOffset();
	}

	public float superGetMountedYOffset() {
		return super.getMountedYOffset();
	}
}