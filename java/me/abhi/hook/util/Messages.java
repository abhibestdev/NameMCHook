package me.abhi.hook.util;

import org.bukkit.ChatColor;

import me.abhi.hook.Hook;

public class Messages {
	
	private final Hook hook = Hook.getInstance();
	
	public static String NO_PERMISSION;
	public static String PLAYER_VOTED;
	public static String PLAYER_DIDNT_VOTE;
	public static String YOU_VOTED;
	public static String VOTE_MESSAGE;
	public static String VOTE_BROADCAST;
	
	public Messages() {
		load();
	}
	
	private void load() {
		NO_PERMISSION = ChatColor.translateAlternateColorCodes('&', hook.getConfig().getString("messages.no-permission"));
		PLAYER_VOTED = ChatColor.translateAlternateColorCodes('&', hook.getConfig().getString("messages.player-voted"));
		PLAYER_DIDNT_VOTE = ChatColor.translateAlternateColorCodes('&', hook.getConfig().getString("messages.player-didnt-vote"));
		YOU_VOTED = ChatColor.translateAlternateColorCodes('&', hook.getConfig().getString("messages.you-voted"));
		VOTE_MESSAGE = ChatColor.translateAlternateColorCodes('&', hook.getConfig().getString("messages.vote-message"));
		VOTE_BROADCAST = ChatColor.translateAlternateColorCodes('&', hook.getConfig().getString("messages.player-voted-broadcast"));
	}

}
