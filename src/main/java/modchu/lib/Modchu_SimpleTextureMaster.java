package modchu.lib;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
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
	private int glTextureId;

	public Modchu_SimpleTextureMaster(HashMap<String, Object> map) {
		super(map);
		resourceLocation = map.get("Object");
		glTextureId = -1;
	}

	@Override
	public void loadTexture(Object resourceManager) {
		//Modchu_Debug.mDebug("Modchu_SimpleTextureMaster loadTexture resourceManager="+resourceManager);
		try {
			getBufferedImage();
			if (bufferedImage != null) {
				glTextureId = Modchu_AS.getInt(Modchu_AS.textureUtilUploadTextureImage, getGlTextureId(), bufferedImage);
			} else {
				super.loadTexture(resourceManager);
			}
			//Modchu_Debug.mDebug("Modchu_SimpleTextureMaster loadTexture TextureUtil uploadTextureImageAllocate return i="+i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected BufferedImage getBufferedImage() {
		if (bufferedImage != null) return bufferedImage;
		String s = decodeResourcePath(resourceLocation);
		boolean debug = false;
		//boolean debug = s.indexOf("assets/minecraft/textures/entity/littlemaid/") > -1;
		InputStream inputStream = null;
		try {
			if (debug) Modchu_Debug.mDebug("Modchu_SimpleTextureMaster getBufferedImage s="+s);
			URL url = Modchu_SimpleTextureMaster.class.getResource(s);
			String s1 = url.toString();
			if (debug) Modchu_Debug.mDebug("Modchu_SimpleTextureMaster s1="+s1);
			inputStream = Modchu_SimpleTextureMaster.class.getResourceAsStream(s);
			bufferedImage = ImageIO.read(inputStream);
			if (debug) Modchu_Debug.mDebug("Modchu_SimpleTextureMaster getBufferedImage bufferedImage="+bufferedImage);
		} catch (Exception e) {
			if (debug) Modchu_Debug.mDebug("Modchu_SimpleTextureMaster getBufferedImage Exception !! 1 s="+s);
			//e.printStackTrace();
		} finally {
			try {
				if (inputStream != null) inputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (bufferedImage != null) return bufferedImage;
		String s1 = null;
		try {
			List<ZipFile> list = Modchu_FileManager.getModsZipFileList();
			BufferedImage bufferedImage1 = null;
			s1 = s.startsWith("/") ? s.substring(1) : s;
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
					e1.printStackTrace();
				}
			}
		} catch (Exception e2) {
			if (debug) Modchu_Debug.mDebug("Modchu_SimpleTextureMaster getBufferedImage Exception !! 2 s1="+s1);
			//e2.printStackTrace();
		}
		if (bufferedImage != null) return bufferedImage;
		for (File file : Modchu_Main.modDirList) {
			bufferedImage = getBufferedImage(file, s);
			if (bufferedImage != null) return bufferedImage;
		}
		return null;
	}

	protected BufferedImage getBufferedImage(File file, String s) {
		if (file != null
				&& file.isDirectory()); else return null;
		boolean debug = false;
		if (debug) Modchu_Debug.mDebug("Modchu_SimpleTextureMaster getBufferedImage file.getName()="+file.getName());
		if (s.startsWith("/")) {
			s = s.substring(1);
		}
		s = s.replace("/", "\\");
		BufferedImage bufferedImage = null;
		try {
			for (File t : file.listFiles()) {
				String path = Modchu_FileManager.getRelativePath(t.getAbsolutePath());
				if (debug) Modchu_Debug.mDebug("Modchu_SimpleTextureMaster getBufferedImage r path="+path);
				if (t.isDirectory()) {
					bufferedImage = getBufferedImage(t, s);
					if (bufferedImage != null) return bufferedImage;
				} else if (checkPath(path, s)) {
					bufferedImage = ImageIO.read(new FileInputStream(t));
					if (bufferedImage != null) {
						if (debug) Modchu_Debug.mDebug("Modchu_SimpleTextureMaster getBufferedImage bufferedImage="+bufferedImage+" s="+s);
						return bufferedImage;
					} else {
						if (debug) Modchu_Debug.mDebug("Modchu_SimpleTextureMaster getBufferedImage bufferedImage == null s="+s);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		if (debug) Modchu_Debug.mDebug("Modchu_SimpleTextureMaster getBufferedImage miss read return null. s="+s);
		return null;
	}

	protected boolean checkPath(String s, String s1) {
		boolean debug = false;
		if (s != null
				&& !s.isEmpty()
				&& s1 != null
				&& !s1.isEmpty()); else return false;
		if (debug) Modchu_Debug.mDebug("Modchu_SimpleTextureMaster checkPath s1="+s1);
		while (true) {
			int i1 = s.indexOf("\\");
			if (i1 < 0) break;
			if (debug) Modchu_Debug.mDebug("Modchu_SimpleTextureMaster checkPath r s="+s);
			if (s.equalsIgnoreCase(s1)) {
				if (debug) Modchu_Debug.mDebug("Modchu_SimpleTextureMaster checkPath return true. s="+s);
				return true;
			}
			s = s.substring(i1 + 1);
		}
		if (debug) Modchu_Debug.mDebug("Modchu_SimpleTextureMaster checkPath return false. s="+s+" s1="+s1);
		return false;
	}

	protected String decodeResourcePath(Object resourceLocation1) {
		String path = Modchu_AS.getString(Modchu_AS.resourceLocationGetResourcePath, resourceLocation1);
		String domain = Modchu_AS.getString(Modchu_AS.resourceLocationGetResourceDomain, resourceLocation1);
		if (domain != null
				&& domain.isEmpty()) domain = "minecraft";
		String s = new StringBuilder().append("/assets/").append(domain).append("/").append(path).toString();
		return s;
	}

	@Override
	public int getGlTextureId() {
		return glTextureId == -1 ? super.getGlTextureId() : glTextureId;
	}

}
