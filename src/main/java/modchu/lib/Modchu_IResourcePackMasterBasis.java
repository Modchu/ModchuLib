package modchu.lib;

import java.io.InputStream;
import java.util.HashMap;

public class Modchu_IResourcePackMasterBasis implements Modchu_IResourcePackMaster {
	public Modchu_IResourcePack base;

	public Modchu_IResourcePackMasterBasis(HashMap<String, Object> map) {
		base = (Modchu_IResourcePack) map.get("base");
	}

	@Override
	public InputStream getInputStream(Object resourceLocation) {
		return base.superGetInputStream(resourceLocation);
	}

	@Override
	public boolean resourceExists(Object resourceLocation) {
		return base.superResourceExists(resourceLocation);
	}

	@Override
	public Object getResourceDomains() {
		return base.superGetResourceDomains();
	}

	@Override
	public Object getPackMetadata(Object metadataSerializer, String s) {
		return base.superGetPackMetadata(metadataSerializer, s);
	}

	@Override
	public Object getPackImage() {
		return base.superGetPackImage();
	}

	@Override
	public String getPackName() {
		return base.superGetPackName();
	}

}
