package me.patrick.servercaster.example;

import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Patrick Beuks
 */
public class Example extends JavaPlugin {

    @Override
    public void onEnable() {
        /*
         * example package shows players how to extend this plugin, for that
         * reason the CodeAction and listners are made inside their object.
         */
        new AddWarp();
        new VersionVariable(this);
    }

}
