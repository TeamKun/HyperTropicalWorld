package net.kunmc.lab.hypertropicalworld.task;

import net.kunmc.lab.hypertropicalworld.HyperTropicalWorld;
import net.kunmc.lab.hypertropicalworld.util.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

public class ShowHeatstrokeLevelTask extends BukkitRunnable {
    public static boolean isSilent = false;

    @Override
    public void run() {
        if (HyperTropicalWorld.isEnabled && !isSilent) {
            Bukkit.getOnlinePlayers().forEach(p -> {
                p.sendActionBar(ChatColor.RED + "熱中症度: " + Utils.getHeatstrokeLevel(p));
            });
        }
    }
}
