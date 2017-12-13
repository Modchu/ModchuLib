package modchu.lib;

import java.util.List;

public interface Modchu_ICommandMaster {
	public int compareTo(Object arg0);
	public String getCommandName();
	public String getCommandUsage(Object iCommandSender);
	public List getCommandAliases();
	public void execute(Object minecraftServer, Object iCommandSender, String[] astring);
	public boolean checkPermission(Object minecraftServer, Object iCommandSender);
	public List getTabCompletionOptions(Object minecraftServer, Object iCommandSender, String[] astring, Object blockPos);
	public boolean isUsernameIndex(String[] astring, int i);

}
