package xyz.n7mn.dev.minigames.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.n7mn.dev.minigames.api.Reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AboutNanaMinigamesCommand extends Command {


    public AboutNanaMinigamesCommand() {
        super("aboutnanaminigames");
        this.setAliases(Arrays.asList("aboutnm"));
        this.setDescription("ななミニゲームについての詳細を表示します");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if(!sender.isOp()) {
            sender.sendMessage(Reference.CHAT_PREFIX + " " + Reference.CHAT_ERROR_PERMISSION_COMMAND);
            return true;
        }
        return true;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String alias, String[] args) throws IllegalArgumentException {
        return new ArrayList<>();
    }
}
