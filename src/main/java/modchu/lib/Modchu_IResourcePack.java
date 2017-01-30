package modchu.lib;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Set;

public interface Modchu_IResourcePack {

	InputStream superGetInputStream(Object resourceLocation);
	boolean superResourceExists(Object resourceLocation);
	Set superGetResourceDomains();
	Object superGetPackMetadata(Object metadataSerializer, String s);
	BufferedImage superGetPackImage();
	String superGetPackName();

}
