package me.patrick.servercaster.autocaster;

import me.patrick.servercaster.core.ServerCaster;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Patrick Beuks
 */
public class AutoCaster extends JavaPlugin {

    private static JavaPlugin instance;
    private static AutoCastHelper ach;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        ach = new AutoCastHelper();
        getServer().getPluginManager().registerEvents(ach, this);
        getCommand("cast").setExecutor(ach);
        getCommand("startAutoCaster").setExecutor(ach);
        getCommand("stopAutoCaster").setExecutor(ach);
        ServerCaster.addReloadListener(ach);
    }

    public static JavaPlugin getInstance() {
        return instance;
    }

    public static void startAutoCaster(boolean reset) {
        ach.start(reset);
    }

    public static void stopAutoCaster() {
        ach.stop();
    }

}
