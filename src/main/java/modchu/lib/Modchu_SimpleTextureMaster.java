package modchu.lib;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Modchu_SimpleTextureMaster extends Modchu_SimpleTextureMasterBasis {
    private final Object resourceLocation;

	public Modchu_SimpleTextureMaster(HashMap<String, Object> map) {
		super(map);
		resourceLocation = map.get("Object");
	}

	@Override
	public void loadTexture(Object resourceManager) {
		//Modchu_Debug.mDebug("Modchu_SimpleTexture loadTexture resourceManager="+resourceManager);
		try {
			BufferedImage bufferedimage = getBufferedImage();
			int i = Modchu_AS.getInt(Modchu_AS.textureUtilUploadTextureImage, getGlTextureId(), bufferedimage);
			//Modchu_Debug.mDebug("Modchu_SimpleTexture loadTexture TextureUtil uploadTextureImageAllocate return i="+i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private BufferedImage getBufferedImage() {
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(new File(Modchu_AS.getString(Modchu_AS.resourceLocationGetResourcePath, resourceLocation)));
			//Modchu_Debug.mDebug("Modchu_SimpleTexture getBufferedImage bufferedImage="+bufferedImage);
		} catch (Exception e) {
			Modchu_Debug.mDebug("Modchu_SimpleTexture getBufferedImage Exception !! getResourcePath="+Modchu_AS.getString(Modchu_AS.resourceLocationGetResourcePath, resourceLocation));
			//e.printStackTrace();
		}
		return bufferedImage;
	}

}
