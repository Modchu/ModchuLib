package modchu.lib.modloader.mc162;

import java.util.HashMap;

import modchu.lib.Modchu_ISimpleTexture;
import modchu.lib.Modchu_ISimpleTextureMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.src.ResourceLocation;
import net.minecraft.src.ResourceManager;
import net.minecraft.src.SimpleTexture;

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
	public void func_110551_a(ResourceManager resourceManager) {
		if (master != null) master.loadTexture(resourceManager);
		else
		try {
			super.func_110551_a(resourceManager);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void superLoadTexture(Object resourceManager) {
		try {
			super.func_110551_a((ResourceManager) resourceManager);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int func_110552_b() {
		return master != null ? master.getGlTextureId() : super.func_110552_b();
	}

	@Override
	public int superGetGlTextureId() {
		return super.func_110552_b();
	}

}
