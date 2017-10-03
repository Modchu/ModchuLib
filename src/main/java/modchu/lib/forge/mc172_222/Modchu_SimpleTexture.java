package modchu.lib.forge.mc172_222;

import java.io.IOException;
import java.util.HashMap;

import modchu.lib.Modchu_ISimpleTexture;
import modchu.lib.Modchu_ISimpleTextureMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;

public class Modchu_SimpleTexture extends SimpleTexture implements Modchu_ISimpleTexture {
	public Modchu_ISimpleTextureMaster master;

	public Modchu_SimpleTexture(HashMap<String, Object> map) {
		super((ResourceLocation) map.get("Object"));
		map.put("base", this);
		Object instance = Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.lDebug("Modchu_SimpleTexture init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_ISimpleTextureMaster ? (Modchu_ISimpleTextureMaster) instance : null;
	}

	@Override
	public void loadTexture(IResourceManager resourceManager) {
		if (master != null) master.loadTexture(resourceManager);
		else
		try {
			super.loadTexture(resourceManager);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void superLoadTexture(Object resourceManager) {
		try {
			super.loadTexture((IResourceManager) resourceManager);
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}

	@Override
	public int getGlTextureId() {
		return master != null ? master.getGlTextureId() : super.getGlTextureId();
	}

	public int superGetGlTextureId() {
		return super.getGlTextureId();
	}

}
