package de.staticred.caa.eventapi.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * CAAEvent to mark a method as an event
 *
 * @author Devin
 * @version 1.0.0
 */
public @interface CAAEvent {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface BotEvent {}

}
