package net.kunmc.lab.hypertropicalworld.listener;

import com.destroystokyo.paper.block.TargetBlockInfo;
import dev.kotx.flylib.ListenerAction;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Levelled;
import org.bukkit.block.data.Waterlogged;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class BottleFilledListener implements ListenerAction<PlayerInteractEvent> {
    @Override
    public void execute(@NotNull PlayerInteractEvent e) {
        if (!(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK))) {
            return;
        }

        ItemStack item = e.getItem();
        if (item == null || !item.getType().equals(Material.GLASS_BOTTLE)) {
            return;
        }

        Block block = e.getPlayer().getTargetBlock(5, TargetBlockInfo.FluidMode.SOURCE_ONLY);
        if (block == null) {
            return;
        }
        BlockData data = block.getBlockData();

        if (data instanceof Levelled) {
            Levelled levelled = ((Levelled) data);
            if (block.getType().equals(Material.WATER) && levelled.getLevel() == 0) {
                block.setType(Material.AIR);
            }
        }

        if (block.getType().equals(Material.KELP)) {
            block.setBlockData(Material.WATER.createBlockData(x -> {
                ((Levelled) x).setLevel(1);
            }));
        }

        if (data instanceof Waterlogged) {
            Waterlogged waterlogged = (Waterlogged) data;
            if (waterlogged.isWaterlogged()) {
                waterlogged.setWaterlogged(false);
                block.setBlockData(waterlogged);
            }
        }
    }
}
