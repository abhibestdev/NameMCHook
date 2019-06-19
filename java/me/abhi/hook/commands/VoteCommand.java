package me.abhi.hook.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;

import me.abhi.hook.util.Messages;

public class VoteCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd , String commandLabel, String[] args) {
		if (!sender.hasPermission("hook.command.vote")) {
			sender.sendMessage(Messages.NO_PERMISSION);
			return true;
		}
		sender.sendMessage(Messages.VOTE_MESSAGE);
		return true;
	}
}
