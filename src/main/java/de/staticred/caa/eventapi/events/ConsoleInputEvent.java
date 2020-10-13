package de.staticred.caa.eventapi.events;

import de.staticred.caa.eventapi.util.Event;

public class ConsoleInputEvent extends Event {

    private String input;

    public ConsoleInputEvent(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    @Override
    public Class<?> getEventSubClass() {
        return null;
    }
}
