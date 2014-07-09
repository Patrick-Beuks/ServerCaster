package me.patrick.servercaster.extension;

import me.patrick.servercaster.core.ServerCaster;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Patrick Beuks
 */
public class ServerExtension extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        ServerCaster.addMessageListener(new Variables(this));
    }
}
