package de.staticred.caa.commandapi.util;

/**
 * Implementation of the CommandSender class
 *
 * when send via. console, the sender will always have any permission
 *
 * @author Devin
 * @version 1.0.0
 */
public class ConsoleSender extends CommandSender {
    public ConsoleSender(String permission) {
        super(permission);
    }
}
