package modchu.lib.forge.mc162_164;

import java.io.File;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import java.util.Set;

import modchu.lib.Modchu_Version;
import modchu.lib.forge.mc152_179.Modchu_ModMetadata;

import com.google.common.eventbus.EventBus;

import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.MetadataCollection;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.versioning.ArtifactVersion;
import cpw.mods.fml.common.versioning.VersionRange;

public class Modchu_ModContainer implements ModContainer {
	public static Modchu_ModContainer instance;

	public Modchu_ModContainer() {
		if (instance != null); else instance = this;
	}

	@Override
	public String getName() {
		return Modchu_Version.modSimpleName+"-ModContainer";
	}

	@Override
	public String getVersion() {
		return Modchu_Version.modchulibForForgeVersionString+"-ModContainer";
	}

	@Override
	public String getModId() {
		return "modchupacket";
	}

	@Override
	public File getSource() {
		return null;
	}

	@Override
	public ModMetadata getMetadata() {
		return Modchu_ModMetadata.instance;
	}

	@Override
	public void bindMetadata(MetadataCollection mc) {
	}

	@Override
	public void setEnabledState(boolean enabled) {
	}

	@Override
	public Set<ArtifactVersion> getRequirements() {
		return null;
	}

	@Override
	public List<ArtifactVersion> getDependencies() {
		return null;
	}

	@Override
	public List<ArtifactVersion> getDependants() {
		return null;
	}

	@Override
	public String getSortingRules() {
		return null;
	}

	@Override
	public boolean registerBus(EventBus bus, LoadController controller) {
		return false;
	}

	@Override
	public boolean matches(Object mod) {
		return false;
	}

	@Override
	public Object getMod() {
		return instance;
	}

	@Override
	public ArtifactVersion getProcessedVersion() {
		return null;
	}

	@Override
	public boolean isImmutable() {
		return false;
	}

	@Override
	public boolean isNetworkMod() {
		return true;
	}

	@Override
	public String getDisplayVersion() {
		return getVersion();
	}

	@Override
	public VersionRange acceptableMinecraftVersionRange() {
		return null;
	}

	@Override
	public Certificate getSigningCertificate() {
		return null;
	}

	@Override
	public Map<String, String> getCustomModProperties() {
		return null;
	}

	@Override
	public Class<?> getCustomResourcePackClass() {
		return null;
	}

	public Map<String, String> getSharedModDescriptor() {
		return null;
	}
/*
	public Disableable canBeDisabled() {
		return null;
	}
*/
	public String getGuiClassName() {
		return null;
	}

	public List<String> getOwnedPackages() {
		return null;
	}

}
