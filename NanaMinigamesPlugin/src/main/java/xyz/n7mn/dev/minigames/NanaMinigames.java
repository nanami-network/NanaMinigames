package xyz.n7mn.dev.minigames;

import org.bukkit.Bukkit;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.n7mn.dev.minigames.api.INanamiConfiguration;
import xyz.n7mn.dev.minigames.api.NanamiConfiguration;
import xyz.n7mn.dev.minigames.api.NanamiUtilities;
import xyz.n7mn.dev.minigames.api.Utilities;
import xyz.n7mn.dev.minigames.command.AboutNanaMinigamesCommand;
import xyz.n7mn.dev.minigames.command.NanaMinigamesReloadCommand;

import java.io.IOException;

public final class NanaMinigames extends JavaPlugin {

    private Utilities utilities;
    private NanamiConfiguration config;
    private SimplePluginManager pluginManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        NanaMinigamesApi.plugin = this;
        utilities = new NanamiUtilities(this);
        NanaMinigamesApi.utilities = utilities;
        config = new NanamiConfiguration(this);
        NanaMinigamesApi.config = config;
        try {
            config.init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pluginManager = (SimplePluginManager) Bukkit.getPluginManager();
        utilities.registerCommand(this.getName(), new AboutNanaMinigamesCommand());
        utilities.registerCommand(this.getName(), new NanaMinigamesReloadCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
