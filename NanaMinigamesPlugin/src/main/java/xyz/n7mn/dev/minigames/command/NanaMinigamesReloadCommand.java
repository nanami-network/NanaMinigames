package xyz.n7mn.dev.minigames.command;

import com.google.common.base.Charsets;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_12_R1.command.CraftBlockCommandSender;
import xyz.n7mn.dev.minigames.NanaMinigamesApi;
import xyz.n7mn.dev.minigames.api.Reference;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NanaMinigamesReloadCommand extends Command {

    public NanaMinigamesReloadCommand() {
        super("/nanaminigamesreload");
        this.setAliases(Arrays.asList("/nmreload"));
        this.setDescription("ななミニゲームの設定を再読み込みします");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if(!sender.isOp()) {
            sender.sendMessage(Reference.CHAT_PREFIX + " " + Reference.CHAT_ERROR_PERMISSION_COMMAND);
            return true;
        }
        reload();
        sender.sendMessage(Reference.CHAT_PREFIX + " " + Reference.CHAT_CONFIG_RELOAD);
        return true;
    }

    private void reload() {
        FileConfiguration newConfig = YamlConfiguration.loadConfiguration(NanaMinigamesApi.getConfig().getConfigFile());

        final InputStream defConfigStream = NanaMinigamesApi.getPlugin().getResource("config.yml");
        if (defConfigStream == null) {
            return;
        }

        newConfig.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream, Charsets.UTF_8)));
        try {
            NanaMinigamesApi.getConfig().getConfig().load(NanaMinigamesApi.getConfig().getConfigFile());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String alias, String[] args) throws IllegalArgumentException {
        return new ArrayList<>();
    }
}
