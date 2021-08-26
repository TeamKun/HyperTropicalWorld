package net.kunmc.lab.hypertropicalworld;

import dev.kotx.flylib.FlyLib;
import dev.kotx.flylib.command.Permission;
import net.kunmc.lab.hypertropicalworld.command.MainCommand;
import net.kunmc.lab.hypertropicalworld.task.DamageTask;
import net.kunmc.lab.hypertropicalworld.task.IncrementHeatstrokeLevelTask;
import org.bukkit.plugin.java.JavaPlugin;

public final class HyperTropicalWorld extends JavaPlugin {
    public static HyperTropicalWorld instance;
    public static boolean isEnabled = false;

    @Override
    public void onEnable() {
        instance = this;

        new IncrementHeatstrokeLevelTask().runTaskTimer(this, 0, 20);
        new DamageTask().runTaskTimer(this, 0, 20);

        FlyLib.create(this, builder -> {
            builder.command(new MainCommand("tropical"))
                    .defaultPermission(Permission.getOP());
        });
    }

    @Override
    public void onDisable() {
    }
}
