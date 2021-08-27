package net.kunmc.lab.hypertropicalworld.listener;

import dev.kotx.flylib.ListenerAction;
import net.kunmc.lab.hypertropicalworld.util.Utils;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerRespawnListener implements ListenerAction<PlayerRespawnEvent> {
    @Override
    public void execute(@NotNull PlayerRespawnEvent e) {
        Utils.setHeatstrokeLevel(e.getPlayer(), 0);
    }
}
