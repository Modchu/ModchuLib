package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class Modchu_Debug {

	public static boolean debugMessage;
	public static boolean debugMessagetexture;
	public static boolean debugReflect;
	public static boolean isRelease;
	private static Class mod_PFLM_PlayerFormLittleMaid;

	public static void init(String s) {
		if (s != null) s = s.concat(".")+"mod_PFLM_PlayerFormLittleMaid";
		else s = "mod_PFLM_PlayerFormLittleMaid";
		mod_PFLM_PlayerFormLittleMaid = Modchu_Reflect.loadClass(s);
		debugMessage = (Boolean) Modchu_Reflect.getFieldObject(mod_PFLM_PlayerFormLittleMaid, "DebugMessage");
		debugMessagetexture = (Boolean) Modchu_Reflect.getFieldObject(mod_PFLM_PlayerFormLittleMaid, "DebugMessagetexture");
		debugReflect = (Boolean) Modchu_Reflect.getFieldObject(mod_PFLM_PlayerFormLittleMaid, "debugReflect");
		Object o = Modchu_Reflect.getFieldObject(mod_PFLM_PlayerFormLittleMaid, "mod_pflm_playerformlittlemaid");
		isRelease = (Boolean) Modchu_Reflect.invoke(Modchu_Reflect.getMethod(mod_PFLM_PlayerFormLittleMaid, "isRelease"), o);
	}

	public static void Debug(String s)
	{
		if (debugMessage)
		{
			System.out.println((new StringBuilder()).append("playerFormLittleMaid-").append(s).toString());
		}
	}

	public static void mDebug(String s, int i)
	{
		mDebug(s);
	}

	public static void mDebug(String s)
	{
		if (debugMessage
				&& !isRelease)
		{
			System.out.println((new StringBuilder()).append("playerFormLittleMaid_").append(s).toString());
		}
	}

	public static void tDebug(String s)
	{
		if (debugMessagetexture)
		{
			System.out.println((new StringBuilder()).append("playerFormLittleMaid_").append(s).toString());
		}
	}

	public static void dDebug(String s)
	{
		dDebug(s, 0);
	}

	public static void dDebug(String s, int i)
	{
		if (debugMessage
				&& !isRelease)
		{
			String[] s1 = (String[]) Modchu_Reflect.getFieldObject(mod_PFLM_PlayerFormLittleMaid, "debugString");
			s1[i] = s;
		}
	}

	public static void dDebugDrow()
	{
		String[] s1 = (String[]) Modchu_Reflect.getFieldObject(mod_PFLM_PlayerFormLittleMaid, "debugString");
		for(int i = 0 ;i < s1.length ;i++){
			if (s1 != null) Minecraft.getMinecraft().ingameGUI.drawString(Minecraft.getMinecraft().fontRenderer, s1[i], 1, 1 + (10 * i), 0xffffff);
		}
	}

	public static void rDebug(String s)
	{
		if (debugReflect)
		{
			System.out.println(s);
		}
	}

	public String getClassName(String s) {
		if (s == null) return null;
		if (s.indexOf(".") > -1) return s;
		Package pac = getClass().getPackage();
		if (pac != null) s = pac.getName().concat(".").concat(s);
		return s;
	}
}
