package de.staticred.caa.util;

import java.text.SimpleDateFormat;
import java.util.Date;


/*
    CAA Debugger
    Version: 1.0.0
    Author: Devin
    Alias: StaticRed


 */

public class Debugger {
    public static void debugMessage(Object message) {
        long millis = System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        System.out.println("[CAA] [DEBUG] [" + formatter.format(new Date(millis)) + "] " + message);

    }

}
