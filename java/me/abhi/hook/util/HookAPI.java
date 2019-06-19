package me.abhi.hook.util;

import me.abhi.hook.Hook;

import java.util.List;
import java.util.UUID;

public class HookAPI {

	private static Hook hook = Hook.getInstance();

	// CHECK IF PLAYER VOTED FOR THE SERVER
	public static boolean playerVoted(UUID uuid) {
		return hook.getKnownVoters().contains(uuid.toString());
	}

	// GET ALL KNOWN VOTERS FROM THE CONFIG FILE
	public static List<String> getKnownVoters() {
		return hook.getKnownVoters();
	}

	// GET COMMANDS PERFORMED ONCE VOTED
	public static List<String> getCommands() {
		return hook.getCommands();
	}
}
