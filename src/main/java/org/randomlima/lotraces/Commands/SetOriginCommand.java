package org.randomlima.lotraces.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.randomlima.lotraces.LOTRaces;
import org.randomlima.lotraces.Origin;

public class SetOriginCommand implements CommandExecutor {

    private final LOTRaces plugin;

    public SetOriginCommand(LOTRaces plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be run by a player.");
            return false;
        }

        if (args.length != 2) {
            sender.sendMessage("Usage: /setOrigin <player> <origin>");
            return false;
        }

        String playerName = args[0];
        String originKey = args[1];

        Player targetPlayer = Bukkit.getPlayer(playerName);
        if (targetPlayer == null) {
            sender.sendMessage("Player " + playerName + " not found.");
            return false;
        }

        Origin origin = new Origin(plugin, originKey);

        origin.applyPlayer(targetPlayer);

        sender.sendMessage("You have set the origin for " + playerName + " to " + originKey + ".");
        targetPlayer.sendMessage("Your origin has been set to " + originKey + ".");

        return true;
    }
}