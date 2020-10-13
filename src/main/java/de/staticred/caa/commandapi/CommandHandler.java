package de.staticred.caa.commandapi;


/*
    CAA CommandHandler
    Version: 1.0.0
    Author: Devin
    Alias: StaticRed


 */

/*
    The commandHandler class is used if CAA should process commands. In this case this class will automatically process commands with a algorithm.
    The commandHandler will only manage registered commands. Every kind of input handling will be left over by the CommandInputHandler class


 */

import de.staticred.caa.commandapi.util.Command;

import java.util.ArrayList;
import java.util.Collection;

public class CommandHandler {

    //this list cant for security reason be edited by every class
    private Collection<Command> registeredCommands;

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
