package me.abhi.hook.commands;

import me.abhi.hook.Hook;
import me.abhi.hook.util.HookAPI;
import me.abhi.hook.util.Messages;

import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;

public class CheckVoteCommand implements CommandExecutor {

    public  boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (!sender.hasPermission("hook.command.checkvote")) {
            sender.sendMessage(Messages.NO_PERMISSION);
            return true;
        }
        if (args.length != 1) {
            sender.sendMessage(ChatColor.RED + "Usage: /" + commandLabel + " <player>");
            return true;
        }
        OfflinePlayer offlinePlayer = Hook.getInstance().getServer().getOfflinePlayer(args[0]);
        if (HookAPI.playerVoted(offlinePlayer.getUniqueId())) {
            sender.sendMessage(Messages.PLAYER_VOTED.replace("%player%", offlinePlayer.getName()));
            return true;
        }
        sender.sendMessage(Messages.PLAYER_DIDNT_VOTE.replace("%player%", offlinePlayer.getName()));
        return true;
    }
}
