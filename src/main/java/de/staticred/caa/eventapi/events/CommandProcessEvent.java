package de.staticred.caa.eventapi.events;

import de.staticred.caa.eventapi.util.Event;

public class CommandProcessEvent extends Event {

    boolean canceled;
    String command;

    public CommandProcessEvent(String command) {
        this.command = command;
    }

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
