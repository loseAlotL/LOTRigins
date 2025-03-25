package org.randomlima.lotraces;

import org.bukkit.plugin.java.JavaPlugin;
import org.randomlima.lotraces.Managers.ODSManager;

public final class LOTRaces extends JavaPlugin {
    private ODSManager odsManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        odsManager = new ODSManager(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
