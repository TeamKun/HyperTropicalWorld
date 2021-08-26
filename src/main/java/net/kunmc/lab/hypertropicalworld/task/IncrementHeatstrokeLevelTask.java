package net.kunmc.lab.hypertropicalworld.task;

import net.kunmc.lab.hypertropicalworld.HyperTropicalWorld;
import net.kunmc.lab.hypertropicalworld.util.Utils;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class IncrementHeatstrokeLevelTask extends BukkitRunnable {
    @Override
    public void run() {
        if (HyperTropicalWorld.isEnabled) {
            Bukkit.getOnlinePlayers().forEach(Utils::incrementHeatstrokeLevel);
        }
    }
}
