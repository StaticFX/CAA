package de.staticred.caa.commandapi.util;

import de.staticred.caa.CAA;

public abstract class Command {


    private String prefix;
    private String command;
    private CommandSender commandSender;
    private String[] args;
    private String description;

    public Command(String prefix, String command, String description) {
        this.command = command;
        this.description = description;
        this.prefix = prefix;
    }

    public abstract void execute(String prefix, String command, CommandSender sender, String[] args);


    public String getPrefix() {
        return prefix;
    }

    public String getCommand() {
        return command;
    }

    public CommandSender getCommandSender() {
        return commandSender;
    }

    public String[] getArgs() {
        return args;
    }

    public String getDescription() {
        return description;
    }
}
