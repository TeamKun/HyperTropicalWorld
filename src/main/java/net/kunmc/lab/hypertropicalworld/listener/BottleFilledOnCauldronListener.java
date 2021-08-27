package net.kunmc.lab.hypertropicalworld.listener;

import dev.kotx.flylib.ListenerAction;
import org.bukkit.event.block.CauldronLevelChangeEvent;
import org.jetbrains.annotations.NotNull;

public class BottleFilledOnCauldronListener implements ListenerAction<CauldronLevelChangeEvent> {
    @Override
    public void execute(@NotNull CauldronLevelChangeEvent e) {
        if (e.getReason().equals(CauldronLevelChangeEvent.ChangeReason.BOTTLE_FILL)) {
            e.setNewLevel(0);
        }
    }
}
