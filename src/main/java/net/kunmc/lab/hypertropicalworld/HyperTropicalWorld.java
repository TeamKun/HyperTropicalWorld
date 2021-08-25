package net.kunmc.lab.hypertropicalworld;

import net.kunmc.lab.hypertropicalworld.task.DamageTask;
import net.kunmc.lab.hypertropicalworld.task.IncrementHeatstrokeLevelTask;
import org.bukkit.plugin.java.JavaPlugin;

public final class HyperTropicalWorld extends JavaPlugin {
    public static HyperTropicalWorld instance;

    @Override
    public void onEnable() {
        instance = this;

        new IncrementHeatstrokeLevelTask().runTaskTimer(this, 0, 20);
        new DamageTask().runTaskTimer(this, 0, 20);
    }

    @Override
    public void onDisable() {
    }
}
