package modchu.lib.forge.mc152;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modchu.lib.Modchu_ITextureStitched;
import modchu.lib.Modchu_ITextureStitchedMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.client.renderer.texture.Texture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureStitched;
import net.minecraft.client.texturepacks.ITexturePack;

public class Modchu_TextureStitched extends TextureStitched implements Modchu_ITextureStitched {
	public Modchu_ITextureStitchedMaster master;

	public Modchu_TextureStitched(HashMap<String, Object> map) {
		super((String) map.get("String"));
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		master = instance instanceof Modchu_ITextureStitchedMaster ? (Modchu_ITextureStitchedMaster) instance : null;
	}

	@Override
	public void init(Texture texture, List par2List, int par3, int par4, int par5, int par6, boolean par7) {
		if (master != null) master.init(texture, par2List, par3, par4, par5, par6, par7);
		else super.init(texture, par2List, par3, par4, par5, par6, par7);
	}

	@Override
	public void superInit(Object texture, List par2List, int par3, int par4, int par5, int par6, boolean par7) {
		super.init((Texture) texture, par2List, par3, par4, par5, par6, par7);
	}

	public void copyFrom(TextureStitched textureStitched) {
		if (master != null) master.copyFrom(textureStitched);
		else super.copyFrom(textureStitched);
	}

	@Override
	public void superCopyFrom(Object textureStitched) {
		super.copyFrom((TextureStitched) textureStitched);
	}

	public int getOriginX() {
		return master != null ? master.getOriginX() : super.getOriginX();
	}

	@Override
	public int superGetOriginX() {
		return super.getOriginX();
	}

	public int getOriginY() {
		return master != null ? master.getOriginY() : super.getOriginY();
	}

	@Override
	public int superGetOriginY() {
		return super.getOriginY();
	}

	public float getMinU() {
		return master != null ? master.getMinU() : super.getMinU();
	}

	@Override
	public float superGetMinU() {
		return super.getMinU();
	}

	public float getMaxU() {
		return master != null ? master.getMaxU() : super.getMaxU();
	}

	@Override
	public float superGetMaxU() {
		return super.getMaxU();
	}

	public float getInterpolatedU(double par1) {
		return master != null ? master.getInterpolatedU(par1) : super.getInterpolatedU(par1);
	}

	@Override
	public float superGetInterpolatedU(double par1) {
		return super.getInterpolatedU(par1);
	}

	public float getMinV() {
		return master != null ? master.getMinV() : super.getMinV();
	}

	@Override
	public float superGetMinV() {
		return super.getMinV();
	}

	public float getMaxV() {
		return master != null ? master.getMaxV() : super.getMaxV();
	}

	@Override
	public float superGetMaxV() {
		return super.getMaxV();
	}

	public float getInterpolatedV(double par1) {
		return master != null ? master.getInterpolatedV(par1) : super.getInterpolatedV(par1);
	}

	@Override
	public float superGetInterpolatedV(double par1) {
		return super.getInterpolatedV(par1);
	}

	public String getIconName() {
		return master != null ? master.getIconName() : super.getIconName();
	}

	@Override
	public String superGetIconName() {
		return super.getIconName();
	}

	public int getSheetWidth() {
		return master != null ? master.getSheetWidth() : super.getSheetWidth();
	}

	@Override
	public int superGetSheetWidth() {
		return super.getSheetWidth();
	}

	public int getSheetHeight() {
		return master != null ? master.getSheetHeight() : super.getSheetHeight();
	}

	@Override
	public int superGetSheetHeight() {
		return super.getSheetHeight();
	}

	public void updateAnimation() {
		if (master != null) master.updateAnimation();
		else super.updateAnimation();
	}

	@Override
	public void superUpdateAnimation() {
		super.updateAnimation();
	}

	public void readAnimationInfo(BufferedReader bufferedReader) {
		if (master != null) master.readAnimationInfo(bufferedReader);
		else super.readAnimationInfo(bufferedReader);
	}

	@Override
	public void superReadAnimationInfo(Object bufferedReader) {
		super.readAnimationInfo((BufferedReader) bufferedReader);
	}

	public void createAndUploadTextures() {
		if (master != null) master.createAndUploadTextures();
		else super.createAndUploadTextures();
	}

	@Override
	public void superCreateAndUploadTextures() {
		super.createAndUploadTextures();
	}

	public boolean loadTexture(TextureManager textureManager, ITexturePack iTexturePack, String name, String fileName, BufferedImage bufferedImage, ArrayList textures) {
		return master != null ? master.loadTexture(textureManager, iTexturePack, name, fileName, bufferedImage, textures) : super.loadTexture(textureManager, iTexturePack, name, fileName, bufferedImage, textures);
	}

	@Override
	public boolean superLoadTexture(Object textureManager, Object iTexturePack, String name, String fileName, Object bufferedImage, ArrayList textures) {
		return super.loadTexture((TextureManager) textureManager, (ITexturePack) iTexturePack, name, fileName, (BufferedImage) bufferedImage, textures);
	}

}
