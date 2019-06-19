package me.abhi.hook.util;

import me.abhi.hook.Hook;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerVoteEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private Player player;

    public PlayerVoteEvent(Player player) {
        this.player = player;
        if (Hook.getInstance().getKnownVoters().contains(player.getUniqueId().toString())) {
            return;
        }
            Hook.getInstance().getKnownVoters().add(player.getUniqueId().toString()); // ADD PLAYER TO LIST SO THEY CANT SPAM VOTE OR VOTE MORE THAN ONCE
        }

    public Player getPlayer() {
        return player;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
