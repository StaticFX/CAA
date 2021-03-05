package de.staticred.caa.commandapi;

import de.staticred.caa.commandapi.util.Command;
import java.util.ArrayList;
import java.util.Collection;

/**
 * CommandHandler will handle inputs send to it, and try to reroute the input to a certain command
 *
 * @author Devin
 * @version 1.0.0
 */
public class CommandHandler {

    //this list cant for security reason be edited by every class
    private final Collection<Command> registeredCommands;

    //if the handler should ignoreCommands
    private boolean ignoreCommands;

    //main creation method with default values.
    public CommandHandler() {
        registeredCommands = new ArrayList<Command>();
    }

    //can be used if there are already registered commands
    public CommandHandler(Collection<Command> registeredCommands) {
        this.registeredCommands = registeredCommands;
    }

    public void registerCommand(Command command) {
        registeredCommands.add(command);
    }

    public void setIgnoreCommands(boolean ignoreCommands) {
        this.ignoreCommands = ignoreCommands;
    }

    public Collection<Command> getRegisteredCommands() {
        return registeredCommands;
    }
}
