package org.randomlima.lotrigins;

import org.bukkit.plugin.java.JavaPlugin;
import org.randomlima.lotrigins.Managers.ODSManager;

public final class LOTRigins extends JavaPlugin {
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
