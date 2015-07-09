package modchu.lib;

import java.io.InputStream;
import java.util.HashMap;

public class Modchu_IResourcePackMasterBasis implements Modchu_IResourcePackMaster {
	public Object base;

	public Modchu_IResourcePackMasterBasis(HashMap<String, Object> map) {
		base = map.get("base");
	}

	@Override
	public InputStream getInputStream(Object resourceLocation) {
		return null;
	}

	@Override
	public boolean resourceExists(Object resourceLocation) {
		return false;
	}

	@Override
	public Object getResourceDomains() {
		return null;
	}

	@Override
	public Object getPackMetadata(Object metadataSerializer, String s) {
		return null;
	}

	@Override
	public Object getPackImage() {
		return null;
	}

	@Override
	public String getPackName() {
		return null;
	}

}
