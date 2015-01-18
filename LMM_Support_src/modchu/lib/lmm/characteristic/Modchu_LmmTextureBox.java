package modchu.lib.lmm.characteristic;

import java.util.Random;

import modchu.lib.characteristic.Modchu_TextureBoxBase;
import modchu.model.ModchuModel_IEntityCaps;
import modchu.model.ModchuModel_ModelDataMaster;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MMM_IModelCaps;
import net.minecraft.src.MMM_ModelMultiBase;
import net.minecraft.src.MMM_TextureBox;
import net.minecraft.src.ResourceLocation;

public class Modchu_LmmTextureBox extends MMM_TextureBox {

	public Modchu_TextureBoxBase master;

	public Modchu_LmmTextureBox(Modchu_TextureBoxBase textureBox) {
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
	}

	public Modchu_LmmTextureBox(Modchu_TextureBoxBase textureBox, String pTextureName, String[] pSearch) {
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

	public void init(Modchu_TextureBoxBase textureBox, Object... o) {
		if (textureBox != null) ;else throw new RuntimeException("ModchuModel_LmmTextureBox init textureBox null !!");
		//Modchu_Debug.mDebug("ModchuModel_LmmTextureBox textureBox="+textureBox);
		master = textureBox;
	}

	private ModchuModel_IEntityCaps getModchu_IModelCaps(Object iModelCaps) {
		return ModchuModel_ModelDataMaster.instance.getPlayerData(iModelCaps);
	}

	@Override
	public void setModels(String pModelName, MMM_ModelMultiBase[] mMM_ModelMultiBase, MMM_ModelMultiBase[] mMM_ModelMultiBase1) {
		//if (master != null) master.setModels(pModelName, mMM_ModelMultiBase, mMM_ModelMultiBase1);
		//else
			super.setModels(pModelName, mMM_ModelMultiBase, mMM_ModelMultiBase1);
	}

	public void superSetModels(String pModelName, Object[] mMM_ModelMultiBase, Object[] mMM_ModelMultiBase1) {
		super.setModels(pModelName, (MMM_ModelMultiBase[]) mMM_ModelMultiBase, (MMM_ModelMultiBase[]) mMM_ModelMultiBase1);
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
	public float getHeight(MMM_IModelCaps iModelCaps) {
		return master != null ? master.getHeight(getModchu_IModelCaps(iModelCaps)) : super.getHeight(iModelCaps);
	}

	public float superGetHeight(Object iModelCaps) {
		return super.getHeight((MMM_IModelCaps) iModelCaps);
	}

	@Override
	public float getWidth(MMM_IModelCaps iModelCaps) {
		return master != null ? master.getWidth(getModchu_IModelCaps(iModelCaps)) : super.getWidth(iModelCaps);
	}

	public float superGetWidth(Object iModelCaps) {
		return super.getWidth((MMM_IModelCaps) iModelCaps);
	}

	@Override
	public float getYOffset(MMM_IModelCaps iModelCaps) {
		return master != null ? master.getYOffset(getModchu_IModelCaps(iModelCaps)) : super.getYOffset(iModelCaps);
	}

	public float superGetYOffset(Object iModelCaps) {
		return super.getYOffset((MMM_IModelCaps) iModelCaps);
	}

	@Override
	public float getMountedYOffset(MMM_IModelCaps iModelCaps) {
		return master != null ? master.getMountedYOffset(getModchu_IModelCaps(iModelCaps)) : super.getMountedYOffset(iModelCaps);
	}

	public float superGetMountedYOffset(Object iModelCaps) {
		return super.getMountedYOffset((MMM_IModelCaps) iModelCaps);
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
	public void setModelSize(float pHeight, float pWidth, float pYOffset, float pMountedYOffset) {
		if (master != null) master.setModelSize(pHeight, pWidth, pYOffset, pMountedYOffset);
		else super.setModelSize(pHeight, pWidth, pYOffset, pMountedYOffset);
	}

	public void superSetModelSize(float pHeight, float pWidth, float pYOffset, float pMountedYOffset) {
		super.setModelSize(pHeight, pWidth, pYOffset, pMountedYOffset);
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
		return master != null ? master.getHeight() : super.getHeight();
	}

	public float superGetHeight() {
		return super.getHeight();
	}

	@Override
	public float getWidth() {
		return master != null ? master.getWidth() : super.getWidth();
	}

	public float superGetWidth() {
		return super.getWidth();
	}

	@Override
	public float getYOffset() {
		return master != null ? master.getYOffset() : super.getYOffset();
	}

	public float superGetYOffset() {
		return super.getYOffset();
	}

	@Override
	public float getMountedYOffset() {
		return master != null ? master.getMountedYOffset() : super.getMountedYOffset();
	}

	public float superGetMountedYOffset() {
		return super.getMountedYOffset();
	}
}