package modchu.lib.forge.mc162;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Set;

import modchu.lib.Modchu_IResourcePack;
import modchu.lib.Modchu_AS;
import modchu.lib.Modchu_IGuiHandlerMaster;
import modchu.lib.Modchu_IResourcePackMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.client.resources.ResourcePack;
import net.minecraft.client.resources.data.MetadataSection;
import net.minecraft.client.resources.data.MetadataSerializer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class Modchu_ResourcePack implements ResourcePack, Modchu_IResourcePack {
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
	public InputStream superGetInputStream(Object resourceLocation) {
		return null;
	}

	@Override
	public boolean resourceExists(ResourceLocation resourceLocation) {
		return master != null ? master.resourceExists(resourceLocation) : false;
	}

	@Override
	public boolean superResourceExists(Object resourceLocation) {
		return false;
	}

	@Override
	public Set getResourceDomains() {
		return (Set) (master != null ? master.getResourceDomains() : null);
	}

	@Override
	public Set superGetResourceDomains() {
		return null;
	}

	@Override
	public MetadataSection getPackMetadata(MetadataSerializer metadataSerializer, String s) {
		return (MetadataSection) (master != null ? master.getPackMetadata(metadataSerializer, s) : null);
	}

	@Override
	public Object superGetPackMetadata(Object metadataSerializer, String s) {
		return null;
	}

	@Override
	public BufferedImage getPackImage() {
		return (BufferedImage) (master != null ? master.getPackImage() : null);
	}

	@Override
	public BufferedImage superGetPackImage() {
		return null;
	}

	@Override
	public String getPackName() {
		return master != null ? master.getPackName() : null;
	}

	@Override
	public String superGetPackName() {
		return null;
	}

}
