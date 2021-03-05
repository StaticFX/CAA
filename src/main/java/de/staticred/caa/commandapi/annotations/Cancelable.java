package de.staticred.caa.commandapi.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Shows that an event is cancelable
 *
 * @author Devin Fritz
 * @version 1.0.0
 */
public @interface Cancelable {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface BotEvent {}
}
