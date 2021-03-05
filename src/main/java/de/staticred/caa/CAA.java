package de.staticred.caa;

import de.staticred.caa.commandapi.CommandHandler;
import de.staticred.caa.task.ConsoleInputListener;
import org.jetbrains.annotations.Nullable;

import java.io.InputStream;
import java.util.Scanner;
import java.util.Timer;

/**
*     CAA Console Application API
*
*     Is a async fast api which can process console inputs async or if wished synced to your main program.
*     Instead of having one command processed by a time, this api can process multiply commands at once.
*     One large operation can be processed in the background, while the console is still accessible.
*
*     It supports a command support for easy command access. All other inputs can be accessed via the ConsoleInputEvent class
*     To use events head over to de.staticred.caa.events.eventapi
 *
 * @author Devin
 * @version 1.6.3
 */
public class CAA {

    /**
     * indicates the scheduler service caa will use to listen to the scanner
     */
    private final Timer service;

    /**
     * indicates if caa will process incoming commands
     */
    private boolean processCommands;

    /**
     * indicates the scanner caa will use to listen
     */
    private Scanner scanner;

    /**
     * prefix of commands, leave empty for none
     */
    private String prefix = "";

    @Nullable
    private CommandHandler commandHandler = null;
    
    private static CAA apiInstance;

    /**
     * @return single instance of caa
     */
    public static CAA getAPI() {
        return apiInstance;
    }

    /**
     * Constructor
     * @param processCommands boolean
     */
    public CAA(boolean processCommands) {
        apiInstance = this;

        this.processCommands = processCommands;

        service = new Timer(true);

        startCAA();
    }

    /**
     * Constructor.
     * @param service timer scheduler
     * @param processCommands boolean
     */
    public CAA(Timer service, boolean processCommands) {
        apiInstance = this;

        //main start method of CAA

        //if true caa will automatically process registered commands
        this.processCommands = processCommands;

        //already given service will be used
        this.service = service;

        startCAA();
    }

    /**
     * Constructor.
     * @param in inputStream to listen
     * @param service timer scheduler
     * @param processCommands boolean
     */
    public CAA(String prefix, InputStream in, Timer service, boolean processCommands) {
        apiInstance = this;
        this.prefix = prefix;
        this.processCommands = processCommands;
        this.service = service;
        this.scanner = new Scanner(in);

        System.out.print(prefix);
        startCAA();
    }

    /**
     * Constructor.
     * @param in inputstream
     * @param processCommands boolean
     */
    public CAA(InputStream in, boolean processCommands) {
        apiInstance = this;
        this.processCommands = processCommands;
        service = new Timer(true);
        this.scanner = new Scanner(in);

        startCAA();
    }


    /**
     * Gets scanner.
     *
     * @return the scanner
     */
    public Scanner getScanner() {
        return scanner;
    }

    /**
     * Process commands boolean.
     *
     * @return the boolean
     */
    public boolean processCommands() {
        return processCommands;
    }

    private void startCAA() {
        if(processCommands) commandHandler = new CommandHandler();
        service.scheduleAtFixedRate(new ConsoleInputListener(),1,1);
    }


    /**
     * Gets prefix.
     *
     * @return the prefix
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Sets prefix.
     *
     * @param prefix the prefix
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }


    /**
     * Gets command handler.
     *
     * @return the command handler
     */
    public @Nullable CommandHandler getCommandHandler() {
        return commandHandler;
    }
}
