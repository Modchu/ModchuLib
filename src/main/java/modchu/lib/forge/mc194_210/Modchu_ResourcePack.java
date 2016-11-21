package modchu.lib.forge.mc194_210;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Set;

import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_Debug;
import modchu.lib.Modchu_IResourcePackMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.client.resources.data.MetadataSerializer;
import net.minecraft.util.ResourceLocation;

public class Modchu_ResourcePack implements IResourcePack {
	public Modchu_IResourcePackMaster master;

	public Modchu_ResourcePack(HashMap<String, Object> map) {
		map.put("base", this);
		Object instance = map.containsKey("instance") ? map.get("instance") : Modchu_Main.newModchuCharacteristicInstance(map);
		Modchu_Debug.lDebug("Modchu_ResourcePack init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_IResourcePackMaster ? (Modchu_IResourcePackMaster) instance : null;
		Modchu_Debug.lDebug("Modchu_ResourcePack init master="+master);
		Modchu_Debug.lDebug("Modchu_ResourcePack init end.");
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
		return (Set) (master != null ? master.getResourceDomains() : Modchu_AS.get("DefaultResourcePack", "defaultResourceDomains"));
	}

	@Override
	public IMetadataSection getPackMetadata(MetadataSerializer metadataSerializer, String s) {
		return (IMetadataSection) (master != null ? master.getPackMetadata(metadataSerializer, s) : null);
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
