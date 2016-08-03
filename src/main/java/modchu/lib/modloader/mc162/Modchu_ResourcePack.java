package modchu.lib.modloader.mc162;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Set;

import modchu.lib.Modchu_IResourcePackMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.src.MetadataSection;
import net.minecraft.src.MetadataSerializer;
import net.minecraft.src.ResourceLocation;
import net.minecraft.src.ResourcePack;

public class Modchu_ResourcePack implements ResourcePack {
	public Modchu_IResourcePackMaster master;

	public Modchu_ResourcePack(HashMap<String, Object> map) {
		map.put("base", this);
		Object instance = map.containsKey("instance") ? map.get("instance") : Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.lDebug("Modchu_ResourcePack init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IResourcePackMaster ? (Modchu_IResourcePackMaster) instance : null;
	}

	@Override
	public InputStream getInputStream(ResourceLocation resourceLocation) {
		return master != null ? master.getInputStream(resourceLocation) : null;
	}

	@Override
	public boolean resourceExists(ResourceLocation resourceLocation) {
		return master != null ? master.resourceExists(resourceLocation) : false;
	}

	@Override
	public Set getResourceDomains() {
		return (Set) (master != null ? master.getResourceDomains() : null);
	}

	@Override
	public MetadataSection getPackMetadata(MetadataSerializer metadataSerializer, String s) {
		return (MetadataSection) (master != null ? master.getPackMetadata(metadataSerializer, s) : null);
	}

	@Override
	public BufferedImage getPackImage() {
		return (BufferedImage) (master != null ? master.getPackImage() : null);
	}

	@Override
	public String getPackName() {
		return master != null ? master.getPackName() : null;
	}


}