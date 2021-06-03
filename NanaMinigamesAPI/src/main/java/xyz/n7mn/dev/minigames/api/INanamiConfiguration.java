package xyz.n7mn.dev.minigames.api;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;

public interface INanamiConfiguration {

    public FileConfiguration getConfig();

    public File getConfigFile();

}
