package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class mod_Modchu_ModchuLib extends BaseMod {

	public static mod_Modchu_ModchuLib mod_modchu_modchulib;
	public static Modchu_Main modchu_Main;
	public static boolean isServer = false;

	static {
		isServer = ModLoader.getMinecraftInstance() == null;
		//Modchu_Debug.Debug("static isServer="+isServer);
	}

	public mod_Modchu_ModchuLib()
	{
		if (isServer) return;
		modchu_Main = new Modchu_Main();
	}

	@Override
	public String getName() {
		return Modchu_Main.modName;
	}

	@Override
	public String getVersion() {
		return Modchu_Main.versionString;
	}

	@Override
	public void load() {
		if (isServer) return;
		mod_modchu_modchulib = this;
		modchu_Main.load();
		ModLoader.setInGameHook(this, true, true);
	}

	@Override
	public void modsLoaded() {
		if (isServer) return;
		modchu_Main.modsLoaded();
	}

	public boolean onTickInGame(float f, Minecraft minecraft)
	{
		if (isServer) return false;
		return modchu_Main.onTickInGame(f, (Object) minecraft);
	}
}
