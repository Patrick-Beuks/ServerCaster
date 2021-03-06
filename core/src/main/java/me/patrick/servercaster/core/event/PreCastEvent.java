package me.patrick.servercaster.core.event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EventObject;
import org.bukkit.entity.Player;

/**
 *
 * @author Patrick Beuks
 */
public class PreCastEvent extends EventObject {

    private ArrayList<String> messages;
    private final Collection<? extends Player> players;
    private Boolean cancelled = false;

    /**
     *
     * @param messages The messages that are going to be send
     * @param players the players that will receive the messages
     * @param source source class of the event
     */
    public PreCastEvent(ArrayList<String> messages, Collection<? extends Player> players, Object source) {
        super(source);
        this.messages = messages;
        this.players = players;
    }

    /**
     *
     * @return the messages after they are converted. This event is fired once
     * every broadcast.
     */
    public ArrayList<String> getMessages() {
        return messages;
    }

    /**
     *
     * @return players that these messages are going to receive
     */
    public Collection<? extends Player> getPlayers() {
        return players;
    }

    /**
     * If you have edited the messages send to the players you can set them with
     * this function again
     *
     * @param messages the new messages
     */
    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }

    public Boolean isCancelled() {
        return cancelled;
    }
}
