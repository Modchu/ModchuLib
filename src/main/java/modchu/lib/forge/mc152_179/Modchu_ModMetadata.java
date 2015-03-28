package modchu.lib.forge.mc152_179;

import java.util.Map.Entry;

import modchu.lib.Modchu_Main;
import cpw.mods.fml.common.ModMetadata;

public class Modchu_ModMetadata extends ModMetadata {
	public static final ModMetadata instance = new Modchu_ModMetadata();

	@Override
	public String getChildModCountString() {
        return String.format("%d child mod%s", Modchu_Main.modEnabledMap.size(), Modchu_Main.modEnabledMap.size() != 1 ? "s" : "");
	}

	@Override
	public String getAuthorList() {
		return super.getAuthorList();
	}

	@Override
	public String getChildModList() {
		StringBuilder sd = new StringBuilder();
		for (Entry<String, Boolean> en : Modchu_Main.modEnabledMap.entrySet()) {
			sd = sd.append(en.getKey()).append(", ");
		}
		String s = sd != null
				&& sd.length() > 0 ? sd.toString() : null;
		int i1 = s.indexOf(", ");
		if (i1 > -1) s = s.substring(0, sd.length() - 2);
		return s;
	}

	@Override
	public String printableSortingRules() {
		return super.printableSortingRules();
	}

}