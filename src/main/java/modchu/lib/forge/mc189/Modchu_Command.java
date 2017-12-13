package modchu.lib.forge.mc189;

import java.util.HashMap;
import java.util.List;

import modchu.lib.Modchu_ICommandMaster;
import modchu.lib.Modchu_Main;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.util.BlockPos;

public class Modchu_Command implements ICommand {
	public Modchu_ICommandMaster master;

	public Modchu_Command(HashMap<String, Object> map) {
		map.put("base", this);
		Object instance = map.containsKey("instance") ? map.get("instance") : Modchu_Main.newModchuCharacteristicInstance(map);
		//Modchu_Debug.lDebug("Modchu_Command init instance="+instance);
		master = instance != null
				&& instance instanceof Modchu_ICommandMaster ? (Modchu_ICommandMaster) instance : null;
	}

	public static void throwNewWrongUsageException(String s, Object... o) {
	}

	@Override
	public int compareTo(ICommand o) {
		return master != null ? master.compareTo(o) : -1;
	}

	@Override
	public String getCommandName() {
		return master != null ? master.getCommandName() : null;
	}

	@Override
	public String getCommandUsage(ICommandSender iCommandSender) {
		return master != null ? master.getCommandUsage(iCommandSender) : null;
	}

	@Override
	public List getCommandAliases() {
		return master != null ? master.getCommandAliases() : null;
	}

	@Override
	public void processCommand(ICommandSender iCommandSender, String[] astring) {
		if (master != null) master.execute(null, iCommandSender, astring);
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender iCommandSender) {
		return master != null ? master.checkPermission(null, iCommandSender) : false;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender iCommandSender, String[] astring, BlockPos pos) {
		return master != null ? master.getTabCompletionOptions(null, iCommandSender, astring, pos) : null;
	}

	@Override
	public boolean isUsernameIndex(String[] astring, int i) {
		return master != null ? master.isUsernameIndex(astring, i) : false;
	}

}
