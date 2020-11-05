package de.staticred.caa;
/*
    CAA
    Version: 1.0.0
    Author: Devin
    Alias: StaticRed
 */

/*
    CAA Console Application API

    Is a async fast api which can process console inputs async or if wished synced to your main program.
    Instead of having one command processed by a time, this api can process multiply commands at once.
    One large operation can be processed in the background, while the console is still accessible.

    It supports a command support for easy command access. All other inputs can be accessed via the ConsoleInputEvent class
    To use events head over to de.staticred.caa.events.eventapi

 */

import de.staticred.caa.commandapi.CommandHandler;
import de.staticred.caa.task.ConsoleInputListener;
import org.jetbrains.annotations.Nullable;

import java.io.InputStream;
import java.util.Scanner;
import java.util.Timer;

public class CAA {

    //service used to run the console listener
    private Timer service;

    //if caa should process commands via. the command api
    private boolean processCommands;

    //scanner used to listen to any kind of inputstream
    private Scanner scanner;

    private String prefix = "";

    @Nullable
    public CommandHandler commandHandler = null;
    
    private static CAA apiInstance;

    //returning the instance of CAA
    public static CAA getAPI() {
        return apiInstance;
    }

    //init CAA, this needs to be called to make this API work
    public CAA(boolean processCommands) {
        apiInstance = this;
        //main start method of CAA

        //prefix used in the console before the cursor


        //if true caa will automatically process registered commands
        this.processCommands = processCommands;

        //if there is no timer specified by the user there will be one created by the caa.
        service = new Timer(true);

        startCAA();
    }

    //can be used to use an already used scheduler as consoleListener, otherwise one will be created.
    public CAA(Timer service, boolean processCommands) {
        apiInstance = this;

        //main start method of CAA

        //if true caa will automatically process registered commands
        this.processCommands = processCommands;

        //already given service will be used
        this.service = service;

        startCAA();
    }

    public CAA(InputStream in, Timer service, boolean processCommands) {
        apiInstance = this;
        //main start method of CAA

        //if true caa will automatically process registered commands
        this.processCommands = processCommands;

        //already given service will be used
        this.service = service;

        //scanner used to listen to the inputs
        this.scanner = new Scanner(in);

        startCAA();
    }

    public CAA(InputStream in, boolean processCommands) {
        apiInstance = this;
        //main start method of CAA

        //if true caa will automatically process registered commands
        this.processCommands = processCommands;

        //already given service will be used
        service = new Timer(true);

        //scanner used to listen to the inputs
        this.scanner = new Scanner(in);

        startCAA();
    }

    public Scanner getScanner() {
        return scanner;
    }

    public boolean processCommands() {
        return processCommands;
    }

    private void startCAA() {
        if(processCommands) commandHandler = new CommandHandler();
        service.scheduleAtFixedRate(new ConsoleInputListener(),1,1);
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
