package de.staticred.caa.eventapi.util;

/**
 * Abstract use to identify an class as an event
 *
 * @author Devin
 * @version 1.0.0
 */
public abstract class Event {

    public abstract Class<?> getEventSubClass();

}
