package de.staticred.caa.eventapi.events;

import de.staticred.caa.eventapi.util.Event;

/**
 * Console Input Event, whenever something is send to the console,
 * it will be fired
 *
 * @author Devin
 * @version 1.0.0
 */
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
