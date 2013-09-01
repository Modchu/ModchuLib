package net.minecraft.src;

//import net.minecraft.client.Minecraft;

public class mod_Modchu_ModchuLib extends BaseMod {

	public static mod_Modchu_ModchuLib mod_modchu_modchulib;
	public static Modchu_Main modchu_Main;
	public static boolean isServer = false;

	static {
		//boolean b = cpw.mods.fml.common.FMLCommonHandler.instance().getSide().isServer();
		//Modchu_Debug.Debug("static b="+b);
		Object o = Modchu_Reflect.invokeMethod("cpw.mods.fml.common.FMLCommonHandler", "instance");
		if (o != null) {
			o = Modchu_Reflect.invokeMethod(o.getClass(), "getSide", o);
			if (o != null) {
				if ((Boolean) Modchu_Reflect.invokeMethod(o.getClass(), "isServer", o)) isServer = true;
			} else {
				//Modchu_Debug.Debug("static 2 o == null !!");
			}
		} else {
			//Modchu_Debug.Debug("static o == null !!");
		}
		//Modchu_Debug.Debug("static isServer="+isServer);
	}

	public mod_Modchu_ModchuLib()
	{
		if (isServer) return;
		modchu_Main = new Modchu_Main();
	}

	public String getName() {
		return Modchu_Main.modName;
	}

	public String getVersion() {
		return Modchu_Main.versionString;
	}

	public void load() {
		if (isServer) return;
		mod_modchu_modchulib = this;
		modchu_Main.load();
	}

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
