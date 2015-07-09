package modchu.lib;

import java.io.InputStream;

public interface Modchu_IResourcePackMaster {
	public InputStream getInputStream(Object resourceLocation);
	public boolean resourceExists(Object resourceLocation);
	public Object getResourceDomains();
	public Object getPackMetadata(Object metadataSerializer, String s);
	public Object getPackImage();
	public String getPackName();

}
