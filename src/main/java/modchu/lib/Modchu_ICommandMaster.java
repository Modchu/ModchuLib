package modchu.lib;

import java.util.List;

public interface Modchu_ICommandMaster {
	public int compareTo(Object arg0);
	public String getCommandName();
	public String getCommandUsage(Object iCommandSender);
	public List getCommandAliases();
	public void processCommand(Object iCommandSender, String[] astring);
	public boolean canCommandSenderUseCommand(Object iCommandSender);
	public List addTabCompletionOptions(Object iCommandSender, String[] astring);
	public boolean isUsernameIndex(String[] astring, int i);

}
