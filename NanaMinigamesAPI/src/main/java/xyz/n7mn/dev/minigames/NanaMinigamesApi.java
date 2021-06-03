package xyz.n7mn.dev.minigames;

import org.bukkit.plugin.Plugin;
import xyz.n7mn.dev.minigames.api.INanamiConfiguration;
import xyz.n7mn.dev.minigames.api.Utilities;

public final class NanaMinigamesApi {

    static Plugin plugin;
    static Utilities utilities;
    static INanamiConfiguration config;

    public static Plugin getPlugin() {
        return plugin;
    }

    public static Utilities getUtilities() {
        return utilities;
    }

    public static INanamiConfiguration getConfig() {
        return config;
    }

}
