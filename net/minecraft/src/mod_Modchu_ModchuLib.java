package net.minecraft.src;

//import net.minecraft.client.Minecraft;

public class mod_Modchu_ModchuLib extends BaseMod {

	public static mod_Modchu_ModchuLib mod_modchu_modchulib;
	public static Modchu_Main modchu_Main;

	public mod_Modchu_ModchuLib()
	{
		modchu_Main = new Modchu_Main();
	}

	@Override
	public String getName() {
		return modchu_Main.getName();
	}

	@Override
	public String getVersion() {
		return modchu_Main.getVersion();
	}

	@Override
	public void load() {
		mod_modchu_modchulib = this;
		modchu_Main.load();
	}

	@Override
	public void modsLoaded() {
		modchu_Main.modsLoaded();
	}

	public boolean onTickInGame(float f, Minecraft minecraft)
	{
		return modchu_Main.onTickInGame(f, minecraft);
	}
}
