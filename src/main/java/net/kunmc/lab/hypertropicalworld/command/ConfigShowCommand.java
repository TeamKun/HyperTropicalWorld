package net.kunmc.lab.hypertropicalworld.command;

import dev.kotx.flylib.command.Command;
import dev.kotx.flylib.command.CommandContext;
import net.kunmc.lab.hypertropicalworld.Config;

import java.lang.reflect.Field;

public class ConfigShowCommand extends Command {
    public ConfigShowCommand() {
        super("show");
    }

    @Override
    public void execute(CommandContext ctx) {
        try {
            for (Field field : Config.class.getDeclaredFields()) {
                ctx.success(field.getName() + ": " + field.get(null));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
