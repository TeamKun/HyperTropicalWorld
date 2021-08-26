package net.kunmc.lab.hypertropicalworld.task;

import net.kunmc.lab.hypertropicalworld.HyperTropicalWorld;
import net.kunmc.lab.hypertropicalworld.util.Utils;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class DamageTask extends BukkitRunnable {
    public static int heatstrokeLevelBorder = 30;
    public static double damage = 1.0;

    @Override
    public void run() {
        if (HyperTropicalWorld.isEnabled) {
            Bukkit.getOnlinePlayers().forEach(p -> {
                if (Utils.getHeatstrokeLevel(p) >= heatstrokeLevelBorder) {
                    p.damage(damage);
                }
            });
        }
    }
}
