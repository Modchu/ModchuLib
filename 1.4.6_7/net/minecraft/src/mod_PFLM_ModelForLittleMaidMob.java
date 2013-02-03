package net.minecraft.src;

public class mod_PFLM_ModelForLittleMaidMob extends BaseMod
{
	public String getVersion()
	{
		return "1.4.6~7-1b";
	}

	public void load()
	{
		if (!ModLoader.isModLoaded("PFLM_PlayerFormLittleMaid")) {
			//System.out.println("mod_PlayerFormLittleMaidModelForLittleMaidMob-!PFLM_PlayerFormLittleMaid");
			MMM_FileManager.getModFile("MultiModel", "MultiModel");
			MMM_TextureManager.addSearch("MultiModel", "/mob/littleMaid/", "MultiModel_");
			MMM_FileManager.getModFile("playerformlittlemaid", "playerformlittlemaid");
			MMM_TextureManager.addSearch("playerformlittlemaid", "/mob/littleMaid/", "MultiModel_");
		} else {
			//System.out.println("mod_PlayerFormLittleMaidModelForLittleMaidMob-load PFLM_PlayerFormLittleMaid");
		}
	}

	public void modsLoaded()
	{
	}
}
