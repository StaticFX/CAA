package de.staticred.caa.commandapi.util;

/**
 * Command class which can be implemented by the user in any certain way.
 *
 * When the commandHandler found the class,
 * it will invoke the execute method
 *
 * @see de.staticred.caa.commandapi.CommandHandler@
 * @see Command#execute(String, String, CommandSender, String[])
 *
 * @author Devin
 * @version 1.0.0
 */
public abstract class Command {


    private final String prefix;
    private final String command;
    private final String description;

    /**
     * Instantiates a new Command.
     *
     * @param prefix      the prefix
     * @param command     the command
     * @param description the description
     */
    public Command(String prefix, String command, String description) {
        this.command = command;
        this.description = description;
        this.prefix = prefix;
    }

    /**
     * Execute method of the command.
     *
     * @param prefix  the prefix
     * @param command the command
     * @param sender  the sender
     * @param args    the args
     */
    public abstract void execute(String prefix, String command, CommandSender sender, String[] args);

    /**
     * Gets prefix.
     *
     * @return the prefix
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Gets command.
     *
     * @return the command
     */
    public String getCommand() {
        return command;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }
}
