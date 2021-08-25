package net.kunmc.lab.hypertropicalworld;

import org.bukkit.plugin.java.JavaPlugin;

public final class HyperTropicalWorld extends JavaPlugin {
    public static HyperTropicalWorld instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {
    }
}
