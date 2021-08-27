package net.kunmc.lab.hypertropicalworld.listener;

import dev.kotx.flylib.ListenerAction;
import net.kunmc.lab.hypertropicalworld.Config;
import net.minecraft.server.v1_16_R3.IBlockDataHolder;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.block.data.CraftBlockData;
import org.bukkit.event.block.FluidLevelChangeEvent;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

public class WaterLevelChangeListener implements ListenerAction<FluidLevelChangeEvent> {
    @Override
    public void execute(@NotNull FluidLevelChangeEvent e) {
        if (Config.prohibitInfiniteWaterSource) {
            return;
        }

        if (!e.getBlock().getType().equals(Material.WATER)) {
            return;
        }

        CraftBlockData newData = ((CraftBlockData) e.getNewData());

        List<String> stateList = newData
                .getState()
                .getStateMap()
                .entrySet()
                .stream()
                .map(IBlockDataHolder.STATE_TO_VALUE)
                .collect(Collectors.toList());
        if (stateList.isEmpty()) {
            return;
        }

        if (stateList.get(0).equals("level=0")) {
            CraftBlockData t = CraftBlockData.newData(Material.WATER, "[level=1]");

            try {
                Field f = e.getClass().getDeclaredField("newData");
                f.setAccessible(true);
                f.set(e, t);
            } catch (NoSuchFieldException | IllegalAccessException noSuchFieldException) {
                noSuchFieldException.printStackTrace();
            }
        }
    }
}
