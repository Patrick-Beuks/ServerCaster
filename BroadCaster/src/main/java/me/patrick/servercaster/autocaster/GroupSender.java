package me.patrick.servercaster.autocaster;

import java.util.ArrayList;
import me.patrick.servercaster.core.ServerCaster;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Patrick Beuks
 */
public class GroupSender {

    private int lineIndex = 0;
    private final JavaPlugin instance = AutoCaster.getInstance();
    private final String path;
    private final int totalMessages;
    private final ArrayList<Player> players = new ArrayList<>();

    public GroupSender(String path) {
        totalMessages = instance.getConfig().getStringList(path).size();
        this.path = path;
    }

    public boolean addPlayer(Player player) {
        return players.add(player);
    }

    public void run() {
        if (totalMessages <= lineIndex) {
            lineIndex = 0;
        }
        ArrayList<String> storedMessages = new ArrayList<>(instance.getConfig().getStringList(path));
        ServerCaster.castMessage(instance, storedMessages.get(lineIndex), players);
        lineIndex++;
    }

    public String getGroup() {
        return path;
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public void setLineIndex(int line) {
        lineIndex = line;
    }
}
