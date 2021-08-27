package net.kunmc.lab.hypertropicalworld.util;

import net.kunmc.lab.hypertropicalworld.Const;
import net.kunmc.lab.hypertropicalworld.HyperTropicalWorld;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

public class Utils {
    public static void setHeatstrokeLevel(Player p, int value) {
        if (p.hasMetadata(Const.metadataKey)) {
            p.removeMetadata(Const.metadataKey, HyperTropicalWorld.instance);
        }
        p.setMetadata(Const.metadataKey, new FixedMetadataValue(HyperTropicalWorld.instance, value));
    }

    public static int getHeatstrokeLevel(Player p) {
        if (p.hasMetadata(Const.metadataKey)) {
            return p.getMetadata(Const.metadataKey).get(0).asInt();
        } else {
            return 0;
        }
    }

    public static void incrementHeatstrokeLevel(Player p) {
        setHeatstrokeLevel(p, getHeatstrokeLevel(p) + 1);
    }

    public static boolean isExceptional(Player p) {
        GameMode mode = p.getGameMode();
        return mode.equals(GameMode.CREATIVE) || mode.equals(GameMode.SPECTATOR);
    }
}
