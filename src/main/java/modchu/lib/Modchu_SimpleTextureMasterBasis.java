package modchu.lib;

import java.util.HashMap;

public class Modchu_SimpleTextureMasterBasis implements Modchu_ISimpleTextureMaster {
	public Modchu_ISimpleTexture base;

	public Modchu_SimpleTextureMasterBasis(HashMap<String, Object> map) {
		base = map.containsKey("base") ? (Modchu_ISimpleTexture) map.get("base") : null;
	}

	@Override
	public void loadTexture(Object resourceManager) {
		base.superLoadTexture(resourceManager);
	}

	@Override
	public int getGlTextureId() {
		return base.superGetGlTextureId();
	}

}
