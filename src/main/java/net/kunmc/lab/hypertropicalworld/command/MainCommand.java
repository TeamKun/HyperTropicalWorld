package net.kunmc.lab.hypertropicalworld.command;

import dev.kotx.flylib.command.Command;

public class MainCommand extends Command {
    public MainCommand(@org.jetbrains.annotations.NotNull String name) {
        super(name);

        children(new StartCommand(), new StopCommand(), new ConfigCommand());
    }
}
