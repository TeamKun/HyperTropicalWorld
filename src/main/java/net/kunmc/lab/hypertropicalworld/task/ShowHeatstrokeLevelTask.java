package net.kunmc.lab.hypertropicalworld.task;

import net.kunmc.lab.hypertropicalworld.Config;
import net.kunmc.lab.hypertropicalworld.util.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

public class ShowHeatstrokeLevelTask extends BukkitRunnable {
    @Override
    public void run() {
        if (Config.isEnabled && Config.shouldShowLevel) {
            Bukkit.getOnlinePlayers().forEach(p -> {
                if (Utils.isExceptional(p)) {
                    return;
                }

                int heatStrokeLevel = Utils.getHeatstrokeLevel(p);
                ChatColor color = heatStrokeLevel >= Config.heatstrokeLevelBorder ? ChatColor.DARK_RED : ChatColor.RED;
                p.sendActionBar(color + "熱中症度: " + heatStrokeLevel);
            });
        }
    }
}
