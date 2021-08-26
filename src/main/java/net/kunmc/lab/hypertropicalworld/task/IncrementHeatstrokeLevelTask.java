package net.kunmc.lab.hypertropicalworld.task;

import net.kunmc.lab.hypertropicalworld.Config;
import net.kunmc.lab.hypertropicalworld.util.Utils;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class IncrementHeatstrokeLevelTask extends BukkitRunnable {
    @Override
    public void run() {
        if (Config.isEnabled) {
            Bukkit.getOnlinePlayers().forEach(p -> {
                if (Utils.getHeatstrokeLevel(p) < Config.heatstrokeLevelBorder) {
                    Utils.incrementHeatstrokeLevel(p);
                }
            });
        }
    }
}
