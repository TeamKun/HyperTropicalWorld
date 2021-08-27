package net.kunmc.lab.hypertropicalworld.command;

import dev.kotx.flylib.command.Command;

public class ConfigCommand extends Command {
    public ConfigCommand() {
        super("config");

        children(new ConfigShowCommand());
    }
}
