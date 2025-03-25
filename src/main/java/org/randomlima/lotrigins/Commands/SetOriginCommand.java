package org.randomlima.lotrigins.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.randomlima.lotrigins.LOTRigins;
import org.randomlima.lotrigins.Managers.ODSManager;
import org.randomlima.lotrigins.Origin;

public class SetOriginCommand implements CommandExecutor {

    private final LOTRigins plugin;

    public SetOriginCommand(LOTRigins plugin) {
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

        ODSManager odsManager = new ODSManager(plugin);
        Origin origin = new Origin(plugin, originKey);

        origin.applyPlayer(targetPlayer);

        sender.sendMessage("You have set the origin for " + playerName + " to " + originKey + ".");
        targetPlayer.sendMessage("Your origin has been set to " + originKey + ".");

        return true;
    }
}