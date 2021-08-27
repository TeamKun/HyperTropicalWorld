package net.kunmc.lab.hypertropicalworld.command;

import dev.kotx.flylib.command.Command;
import dev.kotx.flylib.command.CommandContext;
import net.kunmc.lab.hypertropicalworld.Config;
import net.kunmc.lab.hypertropicalworld.util.Utils;
import org.bukkit.Bukkit;
import org.bukkit.potion.PotionEffectType;

public class StopCommand extends Command {
    public StopCommand() {
        super("stop");
    }

    @Override
    public void execute(CommandContext ctx) {
        if (!Config.isEnabled) {
            ctx.fail("HyperTropicalWorldは既に無効です.");
            return;
        }

        Config.isEnabled = false;

        Bukkit.getOnlinePlayers().forEach(p -> {
            Utils.setHeatstrokeLevel(p, 0);
            p.removePotionEffect(PotionEffectType.SLOW);
            p.removePotionEffect(PotionEffectType.CONFUSION);
        });

        ctx.success("HyperTropicalWorldを無効化しました.");
    }
}
