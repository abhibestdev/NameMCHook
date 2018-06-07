package me.abhi.hook.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;

import me.abhi.hook.util.Messages;

public class VoteCommand extends BukkitCommand {

    public VoteCommand() {
        super("vote");
    }

    @Override
    public  boolean execute(CommandSender sender, String commandLabel, String[] args) {
        sender.sendMessage(Messages.VOTE_MESSAGE);
        return true;
    }
}
