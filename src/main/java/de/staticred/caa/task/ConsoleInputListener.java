package de.staticred.caa.task;

import de.staticred.caa.CAA;
import de.staticred.caa.commandapi.util.Command;
import de.staticred.caa.commandapi.util.ConsoleSender;
import de.staticred.caa.eventapi.EventHandler;
import de.staticred.caa.eventapi.events.CommandProcessEvent;
import de.staticred.caa.eventapi.events.ConsoleInputEvent;
import de.staticred.caa.eventapi.util.Event;
import de.staticred.caa.util.ConsoleColors;

import java.util.Scanner;
import java.util.TimerTask;

/*
    CAA ConsoleInputListener
    Version: 1.0.0
    Author: Devin
    Alias: StaticRed
 */


public class ConsoleInputListener extends TimerTask {

    //task which will listen constantly and async to the console.
    public void run() {
        //scanner defined in the CAA class
        Scanner scanner = CAA.getAPI().getScanner();
        if(scanner.hasNext()) {
            String input = scanner.next();
            String[] args = input.split(" ");

            //firing event
            EventHandler.fireEvent(new ConsoleInputEvent(input));

            //command handling
            if(CAA.getAPI().processCommands()) {

                CommandProcessEvent event = new CommandProcessEvent(input);
                if(event.isCanceled()) return;


                for(Command registeredCommand : CAA.getAPI().commandHandler.getRegisteredCommands()) {
                    String prefix = registeredCommand.getPrefix();
                    if(input.startsWith(input.substring(0,prefix.length()))) {
                        String inputCommand = input.substring(prefix.length());
                        if(registeredCommand.getCommand().equalsIgnoreCase(inputCommand)) {
                            registeredCommand.execute(prefix,inputCommand,new ConsoleSender("*"),args);
                            System.out.print(CAA.getAPI().getPrefix());
                            return;
                        }
                    }
                    if(input.startsWith("?")) {
                        String inputCommand = input.substring(1);
                        if(inputCommand.equalsIgnoreCase(registeredCommand.getCommand())) {
                            System.out.println(ConsoleColors.GREEN + "Description for command " + registeredCommand.getCommand() + ": " + registeredCommand.getDescription());
                            System.out.print(CAA.getAPI().getPrefix());
                            return;
                        }
                    }
                }

                System.out.println(ConsoleColors.RED + "Command not found!");
                System.out.print(CAA.getAPI().getPrefix());

            }


        }
    }
}
