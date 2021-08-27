package net.kunmc.lab.hypertropicalworld.command;

import dev.kotx.flylib.command.Command;
import dev.kotx.flylib.command.CommandContext;
import net.kunmc.lab.hypertropicalworld.Config;
import net.kunmc.lab.hypertropicalworld.util.Utils;
import org.bukkit.Bukkit;

public class StopCommand extends Command {
    public StopCommand() {
        super("stop");
    }

    @Override
    public void execute(CommandContext ctx) {
        Config.isEnabled = false;

        Bukkit.getOnlinePlayers().forEach(p -> {
            Utils.setHeatstrokeLevel(p, 0);
        });

        ctx.success("HyperTropicalWorldを無効化しました.");
    }
}
