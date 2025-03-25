package org.randomlima.lotraces.Managers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.randomlima.lotraces.LOTRaces;

import java.io.File;
import java.io.IOException;

public class ODSManager {
    private final LOTRaces plugin;
    private File originsFile;
    private FileConfiguration originsConfig;

    public ODSManager(LOTRaces plugin) {
        this.plugin = plugin;
        loadOriginsFile();
    }

    private void loadOriginsFile() {
        originsFile = new File(plugin.getDataFolder(), "origins.yml");
        if (!originsFile.exists()) {
            plugin.saveResource("origins.yml", false);
        }
        originsConfig = YamlConfiguration.loadConfiguration(originsFile);
    }

    private void saveOriginsFile() {
        try {
            originsConfig.save(originsFile);
        } catch (IOException e) {
            plugin.getLogger().severe("Could not save origins.yml! Error: " + e.getMessage());
            plugin.getLogger().severe("Stack trace:");
            for (StackTraceElement element : e.getStackTrace()) {
                plugin.getLogger().severe("  at " + element.toString());
            }
        }
    }

    public String getName(String originKey) {
        return originsConfig.getString("origins." + originKey + ".name", "Default Name");
    }

    public double getDouble(String originKey, String attribute) {
        return originsConfig.getDouble("origins." + originKey + "." + attribute, 0.0);
    }
}
