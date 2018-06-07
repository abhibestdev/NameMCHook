package me.abhi.hook.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;

import me.abhi.hook.util.Messages;

public class VoteCommand extends BukkitCommand {

	public VoteCommand() {
		super("vote");
		setPermission("hook.command.vote");
		setPermissionMessage(Messages.NO_PERMISSION);
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args) {
		if (!sender.hasPermission(this.getPermission())) {
			sender.sendMessage(getPermissionMessage());
			return true;
		}
		sender.sendMessage(Messages.VOTE_MESSAGE);
		return true;
	}
}
