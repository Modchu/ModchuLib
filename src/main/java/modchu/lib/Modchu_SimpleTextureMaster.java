package modchu.lib;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.imageio.ImageIO;

public class Modchu_SimpleTextureMaster extends Modchu_SimpleTextureMasterBasis {
	private final Object resourceLocation;
	private BufferedImage bufferedImage;

	public Modchu_SimpleTextureMaster(HashMap<String, Object> map) {
		super(map);
		resourceLocation = map.get("Object");
	}

	@Override
	public void loadTexture(Object resourceManager) {
		//Modchu_Debug.mDebug("Modchu_SimpleTextureMaster loadTexture resourceManager="+resourceManager);
		try {
			getBufferedImage();
			if (bufferedImage != null) {
				int i = Modchu_AS.getInt(Modchu_AS.textureUtilUploadTextureImage, getGlTextureId(), bufferedImage);
			} else {
				super.loadTexture(resourceManager);
			}
			//Modchu_Debug.mDebug("Modchu_SimpleTextureMaster loadTexture TextureUtil uploadTextureImageAllocate return i="+i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private BufferedImage getBufferedImage() {
		if (bufferedImage != null) return bufferedImage;
		String s = decodeResourcePath(resourceLocation);
		boolean debug = false;
		//boolean debug = s.indexOf("assets/minecraft/textures/entity/littlemaid/") > -1;
		try {
			if (debug) Modchu_Debug.mDebug("Modchu_SimpleTextureMaster getBufferedImage s="+s);
			URL url = Modchu_SimpleTextureMaster.class.getResource(s);
			String s1 = url.toString();
			if (debug) Modchu_Debug.mDebug("Modchu_SimpleTextureMaster s1="+s1);
			InputStream inputStream = Modchu_SimpleTextureMaster.class.getResourceAsStream(s);
			bufferedImage = ImageIO.read(inputStream);
			inputStream.close();
			if (debug) Modchu_Debug.mDebug("Modchu_SimpleTextureMaster getBufferedImage bufferedImage="+bufferedImage);
		} catch (Exception e) {
			List<ZipFile> list = Modchu_FileManager.getModsZipFileList();
			BufferedImage bufferedImage1 = null;
			String s1 = s.startsWith("/") ? s.substring(1) : s;
			for (ZipFile zipFile : list) {
				//ZipEntry ze = zipFile.getEntry(s1);
				ZipEntry ze = null;
				//if (ze != null); else {
					for (Enumeration<? extends ZipEntry> e1 = zipFile.entries(); e1.hasMoreElements();) {
						ze = e1.nextElement();
						if (debug) Modchu_Debug.mDebug1("Modchu_SimpleTextureMaster getBufferedImage ze.getName()="+ze.getName());
						if (ze.getName().equalsIgnoreCase(s1)) {
							if (debug) Modchu_Debug.mDebug("Modchu_SimpleTextureMaster getBufferedImage ze.getName().equalsIgnoreCase s1="+s1);
							break;
						} else {
							ze = null;
						}
					}
				//}
				if (debug) Modchu_Debug.mDebug("Modchu_SimpleTextureMaster ze="+ze);
				if (ze != null); else continue;
				try {
					bufferedImage1 = ImageIO.read(zipFile.getInputStream(ze));
					if (bufferedImage1 != null) bufferedImage = bufferedImage1;
					return bufferedImage1;
				} catch (Exception e1) {
					e.printStackTrace();
				}
			}
			if (debug) Modchu_Debug.mDebug("Modchu_SimpleTextureMaster getBufferedImage Exception !! s1="+s1);
			//e.printStackTrace();
		}
		return bufferedImage;
	}

	private String decodeResourcePath(Object resourceLocation1) {
		String path = Modchu_AS.getString(Modchu_AS.resourceLocationGetResourcePath, resourceLocation1);
		String domain = Modchu_AS.getString(Modchu_AS.resourceLocationGetResourceDomain, resourceLocation1);
		if (domain != null
				&& domain.isEmpty()) domain = "minecraft";
		String s = new StringBuilder().append("/assets/").append(domain).append("/").append(path).toString();
		return s;
	}

}
