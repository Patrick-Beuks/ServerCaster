package me.patrick.servercaster.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.patrick.servercaster.core.event.CastReloadListener;
import me.patrick.servercaster.core.event.ReloadEvent;
import org.bukkit.command.CommandSender;

/**
 *
 * @author Patrick Beuks
 */
class ReloadHandler {

    private final List _listeners = new ArrayList();

    synchronized void addEventListener(CastReloadListener listener) {
        _listeners.add(listener);
    }

    synchronized void removeEventListener(CastReloadListener listener) {
        _listeners.remove(listener);
    }

    void fireEvent(CommandSender commandSender) {
        fireReloadEvent(commandSender);
    }

    private synchronized boolean fireReloadEvent(CommandSender commandSender) {
        ReloadEvent event = new ReloadEvent(commandSender, this);
        Iterator i = _listeners.iterator();
        while (i.hasNext()) {
            ((CastReloadListener) i.next()).castReloadHandler(event);
            if (event.isCancelled()) {
                return false;
            }
        }
        return true;
    }

}
