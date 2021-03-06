package me.patrick.servercaster.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import me.patrick.servercaster.core.event.CastListener;
import me.patrick.servercaster.core.event.PreCastEvent;
import me.patrick.servercaster.core.event.PreCastPlayerEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 *
 * @author Patrick Beuks
 */
class MessageHandler {

    private final List _listeners = new ArrayList();
    private ArrayList<String> messages;
    private ArrayList<String> old;

    synchronized void addEventListener(CastListener listener) {
        _listeners.add(listener);
    }

    synchronized void removeEventListener(CastListener listener) {
        _listeners.remove(listener);
    }

    void sendMessages(Collection<? extends Player> players, ArrayList<String> messages) {
        this.messages = messages;
        this.old = messages;
        if (firePreServer(players)) {
            for (Player player : players) {
                if (firePrePlayer(player)) {
                    for (String string : this.messages) {
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "tellraw " + player.getName() + " " + string);
                    }
                }
                this.messages = this.old;
            }
        }
    }

    private synchronized boolean firePreServer(Collection<? extends Player> players) {
        PreCastEvent event = new PreCastEvent(messages, players, this);
        Iterator i = _listeners.iterator();
        while (i.hasNext()) {
            ((CastListener) i.next()).castHandler(event);
            if (event.isCancelled()) {
                return false;
            }
        }
        this.messages = event.getMessages();
        this.old = messages;
        return true;
    }

    private synchronized boolean firePrePlayer(Player player) {
        PreCastPlayerEvent event = new PreCastPlayerEvent(messages, player, this);
        Iterator i = _listeners.iterator();
        while (i.hasNext()) {
            ((CastListener) i.next()).castPlayerHandler(event);
            if (event.isCancelled()) {
                return false;
            }
        }
        this.messages = event.getMessages();
        return true;
    }

}
