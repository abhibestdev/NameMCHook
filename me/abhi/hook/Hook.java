package me.abhi.hook;

import java.util.List;

import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.abhi.hook.commands.CheckVoteCommand;
import me.abhi.hook.commands.VoteCommand;
import me.abhi.hook.listener.HookHandler;
import me.abhi.hook.listener.HookListener;
import me.abhi.hook.util.API;
import me.abhi.hook.util.Messages;

public class Hook extends JavaPlugin implements Listener {

	private static Hook instance;
	private API api;
	private List<String> commands;
	private List<String> knownVoters;

	@Override
	public void onEnable() {
		createConfig();
		createInstances();
		loadData();
		registerCommands();
		registerHooks();
	}

	@Override
	public void onDisable() {
		saveData();
	}

	private void createInstances() {
		instance = this;
		api = new API();
	}

	private void createConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

	private void loadData() {
		commands = getConfig().getStringList("perform-commands");
		knownVoters = getConfig().getStringList("known-voters");
		new Messages();
	}

	private void registerCommands() {
		((CraftServer) getServer()).getCommandMap().register("checkvote", new CheckVoteCommand());
		((CraftServer) getServer()).getCommandMap().register("vote", new VoteCommand());
	}

	private void registerHooks() {
		getServer().getPluginManager().registerEvents(new HookHandler(), this);
		new HookListener().runTaskTimer(this, 0L, 60L);
	}

	private void saveData() {
		getConfig().set("known-voters", knownVoters);
		saveConfig();
	}

	public static Hook getInstance() {
		return instance;
	}

	public API getApi() {
		return api;
	}

	public List<String> getCommands() {
		return commands;
	}

	public List<String> getKnownVoters() {
		return knownVoters;
	}
}
