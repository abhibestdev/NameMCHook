package me.abhi.hook.listener;

import me.abhi.hook.Hook;
import me.abhi.hook.util.HookAPI;
import me.abhi.hook.util.Messages;
import me.abhi.hook.util.PlayerVoteEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

public class HookHandler implements Listener {

	@EventHandler
	public void onVote(PlayerVoteEvent event) {
		final Player player = event.getPlayer();
		player.sendMessage(Messages.YOU_VOTED);
		Bukkit.broadcastMessage(Messages.VOTE_BROADCAST.replace("%player%", player.getName()));
		new BukkitRunnable() {
			public void run() {
				for (String commands : HookAPI.getCommands()) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), commands.replace("%player%", player.getName()));
				}
			}
		}.runTask(Hook.getInstance());
	}
}
