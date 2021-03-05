package de.staticred.caa.commandapi.util;

public abstract class CommandSender {

    String permission;

    public CommandSender(String permission) {
        this.permission = permission;
    }

}
