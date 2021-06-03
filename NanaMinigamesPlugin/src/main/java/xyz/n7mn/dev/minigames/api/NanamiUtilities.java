package xyz.n7mn.dev.minigames.api;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.Plugin;
import xyz.n7mn.dev.minigames.NanaMinigames;

public class NanamiUtilities implements Utilities {

    private Plugin plugin;

    public NanamiUtilities(Plugin plugin) {
        this.plugin = plugin;
    }

    public void registerCommand(String fallbackPrefix, Command command) {
        try {
            CommandMap map = Bukkit.getServer().getCommandMap();
            map.getKnownCommands().put(command.getName(), command);
            for(String alias : command.getAliases()) {
                map.getKnownCommands().put(alias, command);
            }
            Bukkit.getServer().getCommandMap().register(fallbackPrefix, command);
            plugin.getLogger().info("Succeeded in registering command: /" + command.getName());
        } catch(Exception e) {
            plugin.getLogger().warning("Failed to register command: /" + command.getName());
            e.printStackTrace();
        }
    }

}
