package net.kunmc.lab.hypertropicalworld.listener;

import dev.kotx.flylib.ListenerAction;
import net.kunmc.lab.hypertropicalworld.util.Utils;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;
import org.jetbrains.annotations.NotNull;

public class WaterBottleConsumeListener implements ListenerAction<PlayerItemConsumeEvent> {
    @Override
    public void execute(@NotNull PlayerItemConsumeEvent e) {
        if (!e.getItem().getType().equals(Material.POTION)) {
            return;
        }

        PotionData data = ((PotionMeta) e.getItem().getItemMeta()).getBasePotionData();
        if (data.getType().equals(PotionType.WATER)) {
            Utils.setHeatstrokeLevel(e.getPlayer(), 0);
        }
    }
}
