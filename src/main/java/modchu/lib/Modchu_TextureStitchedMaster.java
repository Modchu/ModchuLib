package modchu.lib;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.imageio.ImageIO;

public class Modchu_TextureStitchedMaster extends Modchu_TextureStitchedMasterBasis {

	public Modchu_TextureStitchedMaster(HashMap<String, Object> map) {
		super(map);
	}

	@Override
	public boolean loadTexture(Object textureManager, Object iTexturePack, String name, String fileName, Object bufferedImage, ArrayList textures) {
		boolean debug = false;
		if (debug) Modchu_Debug.lDebug("Modchu_TextureStitchedMaster loadTexture");
		List<Class> modTextureStitchedClassList = Modchu_FileManager.getModTextureStitchedClassList();
		if (modTextureStitchedClassList != null
				&& !modTextureStitchedClassList.isEmpty()); else {
			Modchu_Debug.lDebug("Modchu_TextureStitchedMaster loadTexture list == null return.");
			return false;
		}
		if (Modchu_Main.modFileList != null
				&& !Modchu_Main.modFileList.isEmpty()); else {
			Modchu_Debug.lDebug("Modchu_TextureStitchedMaster loadTexture Modchu_Main.modFileList == null return.");
			return false;
		}
		List<ZipFile> modZipFileList = Modchu_FileManager.getModZipFileList();
		//String s = Modchu_AS.getFile(Modchu_AS.minecraftMcDataDir).getPath();
		String s1 = "mods/";
		String s2 = ".png";
		for (ZipFile zipFile : modZipFileList) {
			try {
				Enumeration enumeration = zipFile.entries();
				LinkedList<String> nameList = new LinkedList();
				do {
					if (!enumeration.hasMoreElements()) {
						//Modchu_Debug.lDebug("oldHamsterColorInitialize hasMoreElements() break");
						break;
					}
					ZipEntry zipentry = zipFile.getEntry(enumeration.nextElement().toString());
					String name1 = zipentry.getName();
					nameList.add(name1);
					if (debug) Modchu_Debug.lDebug("Modchu_TextureStitchedMaster loadTexture nameList.add name1="+name1);
				} while (true);
				if (nameList != null
						&& !nameList.isEmpty()); else {
					if (debug) Modchu_Debug.lDebug("Modchu_TextureStitchedMaster loadTexture nameList == null continue.");
					continue;
				}
				for (Class c : modTextureStitchedClassList) {
					//if (debug) Modchu_Debug.mDebug("Modchu_TextureStitchedMaster loadTexture c="+c);
					String s6 = c.getName().replaceAll("\\.", "/");
					if (debug) Modchu_Debug.lDebug("Modchu_TextureStitchedMaster loadTexture s6="+s6);
					for (String s7 : nameList) {
						if (s7.indexOf(s6) > -1) {
							for (String s8 : nameList) {
								if (s8.lastIndexOf(s2) > -1) {
									if (debug) Modchu_Debug.lDebug("Modchu_TextureStitchedMaster loadTexture s8="+s8);
									if (s8.indexOf(s1) > -1) {
										String s9 = getPathToDomainFileName(s8);
										if (s9 != null); else continue;
										if (debug) Modchu_Debug.lDebug("Modchu_TextureStitchedMaster loadTexture getPathToDomainFileName s9="+s9);
										if (s9.toLowerCase().equalsIgnoreCase(name.toLowerCase())) {
											InputStream inputStream = zipFile.getInputStream(zipFile.getEntry(s8));
											if (debug) Modchu_Debug.lDebug("Modchu_TextureStitchedMaster loadTexture inputStream="+inputStream);
											if (inputStream != null) {
												BufferedImage bufferedimage = ImageIO.read(inputStream);
												if (debug) Modchu_Debug.lDebug("Modchu_TextureStitchedMaster loadTexture bufferedimage="+bufferedimage);
												if (bufferedimage != null) {
													int i = bufferedimage.getHeight();
													int j = bufferedimage.getWidth();
													if (j == i) {
														Object texture = Modchu_AS.get("TextureManager", "makeTexture", new Class[]{ String.class, int.class, int.class, int.class, int.class, int.class, int.class, int.class, boolean.class, BufferedImage.class }, textureManager, new Object[]{ name, 2, j, i, 10496, 6408, 9728, 9728, false, bufferedimage });
														if (texture != null) {
															textures.add(texture);
															if (debug) Modchu_Debug.lDebug("Modchu_TextureStitchedMaster loadTexture textures.add texture="+texture);
															return true;
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//Object texture = 
		//textures.add(texture);
		return false;
	}

	private String getPathToDomainFileName(String s) {
		boolean debug = false;
		if (debug) Modchu_Debug.lDebug("Modchu_TextureStitchedMaster getPathToDomainFileName s="+s);
		if (s.startsWith("/")) s = s.substring(1);
		int i1 = s.indexOf("mods/");
		if (i1 > -1) s = s.substring(5);
		String domain = "minecraft";
		i1 = s.indexOf("textures/");
		if (i1 > -1) domain = s.substring(0, i1 - 1);
		i1 = s.lastIndexOf(".png");
		if (i1 > -1) s = s.substring(0, i1);
		i1 = s.indexOf("items/");
		if (i1 > 0) {
			s = new StringBuilder().append(domain).append(":").append(s.substring(i1 + 6)).toString();
		}
		i1 = s.indexOf("blocks/");
		if (i1 > 0) {
			s = new StringBuilder().append(domain).append(":").append(s.substring(i1 + 7)).toString();
		}
		return s;
	}

}