package de.staticred.caa.eventapi.events;

import de.staticred.caa.commandapi.annotations.Cancelable;
import de.staticred.caa.eventapi.util.Event;

/**
 * CommandProcessEvent event is fired whenever a command is proceeded inside of the CommandHandler
 *
 * @see de.staticred.caa.commandapi.CommandHandler
 * @author Devin
 * @version 1.0.0
 */
@Cancelable
public class CommandProcessEvent extends Event {

    boolean canceled;
    String command;

    public CommandProcessEvent(String command) {
        this.command = command;
    }

    @Cancelable
    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public String getCommand() {
        return command;
    }

    @Override
    public Class<?> getEventSubClass() {
        return null;
    }
}
