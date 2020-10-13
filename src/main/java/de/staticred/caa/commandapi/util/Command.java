package de.staticred.caa.commandapi.util;

public abstract class Command {


    private String prefix;
    private String command;
    private CommandSender commandSender;
    private String[] args;

    public Command(String prefix, String command) {
        this.prefix = prefix;
        this.command = command;
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
}
