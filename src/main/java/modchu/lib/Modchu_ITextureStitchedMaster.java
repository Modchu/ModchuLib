package modchu.lib;

import java.util.ArrayList;
import java.util.List;

public interface Modchu_ITextureStitchedMaster {
	public void init(Object texture, List par2List, int par3, int par4, int par5, int par6, boolean par7);
	public void copyFrom(Object textureStitched);
	public int getOriginX();
	public int getOriginY();
	public float getMinU();
	public float getMaxU();
	public float getInterpolatedU(double par1);
	public float getMinV();
	public float getMaxV();
	public float getInterpolatedV(double par1);
	public String getIconName();
	public int getSheetWidth();
	public int getSheetHeight();
	public void updateAnimation();
	public void readAnimationInfo(Object bufferedReader);
	public void createAndUploadTextures();
	public boolean loadTexture(Object textureManager, Object iTexturePack, String name, String fileName, Object bufferedImage, ArrayList textures);

}
