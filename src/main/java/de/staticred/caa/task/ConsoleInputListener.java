package de.staticred.caa.task;

import de.staticred.caa.CAA;
import de.staticred.caa.commandapi.util.Command;
import de.staticred.caa.commandapi.util.ConsoleSender;
import de.staticred.caa.eventapi.EventHandler;
import de.staticred.caa.eventapi.events.CommandProcessEvent;
import de.staticred.caa.eventapi.events.ConsoleInputEvent;
import de.staticred.caa.util.ConsoleColors;

import java.util.Scanner;
import java.util.TimerTask;


/**
 *
 * Console input listener watching out for commands and processing them
 *
 * @author Devin
 * @version 1.0.0
 */
public class ConsoleInputListener extends TimerTask {

    //task which will listen constantly and async to the console.
    public void run() {
        //scanner defined in the CAA class
        Scanner scanner = CAA.getAPI().getScanner();
        if(scanner.hasNext()) {
            String input = scanner.nextLine();
            String[] args = input.split(" ");
            String command = args[0];
            System.arraycopy(args, 1, args, 0, args.length - 1);

            //firing event
            EventHandler.fireEvent(new ConsoleInputEvent(input));

            //command handling
            if(CAA.getAPI().processCommands()) {

                CommandProcessEvent event = new CommandProcessEvent(input);
                EventHandler.fireEvent(event);
                if(event.isCanceled()) return;


                for(Command registeredCommand : CAA.getAPI().getCommandHandler().getRegisteredCommands()) {
                    String prefix = registeredCommand.getPrefix();
                    if(input.startsWith(input.substring(0, prefix.length()))) {
                        if(registeredCommand.getCommand().equalsIgnoreCase(command)) {
                            registeredCommand.execute(prefix, input, new ConsoleSender("*"), args);
                            System.out.print(ConsoleColors.RESET + CAA.getAPI().getPrefix());
                            return;
                        }
                    }
                    if(input.startsWith("?")) {
                        if(command.equalsIgnoreCase(registeredCommand.getCommand())) {
                            System.out.println(ConsoleColors.GREEN + "Description for command " + registeredCommand.getCommand() + ": " + registeredCommand.getDescription());
                            System.out.print(ConsoleColors.RESET + CAA.getAPI().getPrefix());
                            return;
                        }
                    }
                }

                System.out.println(ConsoleColors.RED + "Command not found!");
                System.out.print(ConsoleColors.RESET + CAA.getAPI().getPrefix());

            }
        }
    }
}
