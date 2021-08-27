package net.kunmc.lab.hypertropicalworld.listener;

import dev.kotx.flylib.ListenerAction;
import org.bukkit.Material;
import org.bukkit.block.data.Levelled;
import org.bukkit.event.block.BlockFromToEvent;
import org.jetbrains.annotations.NotNull;

public class WaterSpreadListener implements ListenerAction<BlockFromToEvent> {
    @Override
    public void execute(@NotNull BlockFromToEvent e) {
        if (!e.getBlock().getType().equals(Material.WATER)) {
            return;
        }

        Levelled blockData = ((Levelled) e.getBlock().getBlockData());
        if (blockData.getLevel() == 0) {
            blockData.setLevel(1);
            e.getToBlock().setType(Material.WATER);
            e.getToBlock().setBlockData(blockData);
            e.setCancelled(true);
        }
    }
}
