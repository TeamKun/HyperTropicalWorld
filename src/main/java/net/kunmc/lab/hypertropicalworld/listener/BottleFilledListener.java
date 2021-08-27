package net.kunmc.lab.hypertropicalworld.listener;

import com.destroystokyo.paper.block.TargetBlockInfo;
import dev.kotx.flylib.ListenerAction;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Levelled;
import org.bukkit.block.data.Waterlogged;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;
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

        Player p = e.getPlayer();
        Block block = p.getTargetBlock(5, TargetBlockInfo.FluidMode.SOURCE_ONLY);
        if (block == null || !block.getType().equals(Material.WATER)) {
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

        item.setAmount(item.getAmount() - 1);

        ItemStack bottle = new ItemStack(Material.POTION);
        bottle.setAmount(1);
        PotionMeta meta = ((PotionMeta) bottle.getItemMeta());
        meta.setBasePotionData(new PotionData(PotionType.WATER));
        bottle.setItemMeta(meta);
        p.getInventory().addItem(bottle).forEach((k, v) -> {
            p.getWorld().spawnEntity(p.getEyeLocation(), EntityType.DROPPED_ITEM, CreatureSpawnEvent.SpawnReason.CUSTOM, x -> {
                ((Item) x).setItemStack(v);
            });
        });


        e.setCancelled(true);
    }
}
