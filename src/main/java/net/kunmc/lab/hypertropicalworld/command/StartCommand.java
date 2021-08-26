package net.kunmc.lab.hypertropicalworld.command;

import dev.kotx.flylib.command.Command;
import dev.kotx.flylib.command.CommandContext;
import net.kunmc.lab.hypertropicalworld.HyperTropicalWorld;
import net.kunmc.lab.hypertropicalworld.util.Utils;
import org.bukkit.Bukkit;

public class StartCommand extends Command {
    public StartCommand() {
        super("start");
    }

    @Override
    public void execute(CommandContext ctx) {
        HyperTropicalWorld.isEnabled = true;

        Bukkit.getOnlinePlayers().forEach(p -> {
            Utils.setHeatstrokeLevel(p, 0);
        });
        
        ctx.success("HyperTropicalWorldを有効化しました.");
    }
}
