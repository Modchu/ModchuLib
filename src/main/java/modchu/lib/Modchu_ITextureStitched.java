package modchu.lib;

import java.util.ArrayList;
import java.util.List;

public interface Modchu_ITextureStitched {
	public void superInit(Object texture, List par2List, int par3, int par4, int par5, int par6, boolean par7);
	public void superCopyFrom(Object textureStitched);
	public int superGetOriginX();
	public int superGetOriginY();
	public float superGetMinU();
	public float superGetMaxU();
	public float superGetInterpolatedU(double par1);
	public float superGetMinV();
	public float superGetMaxV();
	public float superGetInterpolatedV(double par1);
	public String superGetIconName();
	public int superGetSheetWidth();
	public int superGetSheetHeight();
	public void superUpdateAnimation();
	public void superReadAnimationInfo(Object bufferedReader);
	public void superCreateAndUploadTextures();
	public boolean superLoadTexture(Object textureManager, Object iTexturePack, String name, String fileName, Object bufferedImage, ArrayList textures);

}
