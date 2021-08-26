package net.kunmc.lab.hypertropicalworld;

import dev.kotx.flylib.FlyLib;
import dev.kotx.flylib.command.Permission;
import net.kunmc.lab.hypertropicalworld.command.MainCommand;
import net.kunmc.lab.hypertropicalworld.listener.WaterBottleConsumeListener;
import net.kunmc.lab.hypertropicalworld.task.DamageTask;
import net.kunmc.lab.hypertropicalworld.task.IncrementHeatstrokeLevelTask;
import net.kunmc.lab.hypertropicalworld.task.ShowHeatstrokeLevelTask;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class HyperTropicalWorld extends JavaPlugin {
    public static HyperTropicalWorld instance;

    @Override
    public void onEnable() {
        instance = this;

        new IncrementHeatstrokeLevelTask().runTaskTimer(this, 0, 20);
        new DamageTask().runTaskTimer(this, 0, 20);
        new ShowHeatstrokeLevelTask().runTaskTimer(this, 0, 4);

        FlyLib.create(this, builder -> {
            builder.command(new MainCommand("tropical"))
                    .defaultPermission(Permission.getOP());

            builder.listen(PlayerItemConsumeEvent.class, new WaterBottleConsumeListener());
        });
    }

    @Override
    public void onDisable() {
    }
}
