package modchu.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Modchu_TextureStitchedMasterBasis implements Modchu_ITextureStitchedMaster {
	public Modchu_ITextureStitched base;

	public Modchu_TextureStitchedMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_ITextureStitched) map.get("base");
	}

	@Override
	public void init(Object texture, List par2List, int par3, int par4, int par5, int par6, boolean par7) {
		base.superInit(texture, par2List, par3, par4, par5, par6, par7);
	}

	@Override
	public void copyFrom(Object textureStitched) {
		base.superCopyFrom(textureStitched);
	}

	@Override
	public int getOriginX() {
		return base.superGetOriginX();
	}

	@Override
	public int getOriginY() {
		return base.superGetOriginY();
	}

	@Override
	public float getMinU() {
		return base.superGetMinU();
	}

	@Override
	public float getMaxU() {
		return base.superGetMaxU();
	}

	@Override
	public float getInterpolatedU(double par1) {
		return base.superGetInterpolatedU(par1);
	}

	@Override
	public float getMinV() {
		return base.superGetMinV();
	}

	@Override
	public float getMaxV() {
		return base.superGetMaxV();
	}

	@Override
	public float getInterpolatedV(double par1) {
		return base.superGetInterpolatedV(par1);
	}

	@Override
	public String getIconName() {
		return base.superGetIconName();
	}

	@Override
	public int getSheetWidth() {
		return base.superGetSheetWidth();
	}

	@Override
	public int getSheetHeight() {
		return base.superGetSheetHeight();
	}

	@Override
	public void updateAnimation() {
		base.superUpdateAnimation();
	}

	@Override
	public void readAnimationInfo(Object bufferedReader) {
		base.superReadAnimationInfo(bufferedReader);
	}

	@Override
	public void createAndUploadTextures() {
		base.superCreateAndUploadTextures();
	}

	@Override
	public boolean loadTexture(Object textureManager, Object iTexturePack, String name, String fileName, Object bufferedImage, ArrayList textures) {
		return base.superLoadTexture(textureManager, iTexturePack, name, fileName, bufferedImage, textures);
	}

}