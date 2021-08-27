package net.kunmc.lab.hypertropicalworld.task;

import net.kunmc.lab.hypertropicalworld.Config;
import org.bukkit.Bukkit;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class DebuffTask extends BukkitRunnable {
    @Override
    public void run() {
        if (Config.isEnabled) {
            Bukkit.getOnlinePlayers().forEach(p -> {
                double health = p.getHealth();
                if (health <= 6.0) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 0, false, false, false));
                } else if (health <= 10.0) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 0, false, false, false));
                    p.removePotionEffect(PotionEffectType.CONFUSION);
                } else {
                    p.removePotionEffect(PotionEffectType.CONFUSION);
                    p.removePotionEffect(PotionEffectType.SLOW);
                }
            });
        }
    }
}
