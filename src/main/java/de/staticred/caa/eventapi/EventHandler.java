package de.staticred.caa.eventapi;

import de.staticred.caa.eventapi.util.CAAEvent;
import de.staticred.caa.eventapi.util.Event;
import de.staticred.caa.eventapi.util.Listener;
import de.staticred.caa.util.Debugger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

public class EventHandler {
    List<Listener> eventList = new ArrayList<>();

    public static EventHandler instance = new EventHandler();

    public void registerEvent(Listener event) {
        eventList.add(event);
    }

    public void removeEvent(Listener event) {
        eventList.remove(event);
    }

    public List<Listener> getEvents() {
        return eventList;
    }


    public static void fireEvent(Event event) {
        for(Listener listener : EventHandler.instance.eventList) {
            for(final Method method : listener.getClass().getMethods()) {
                if(method.isAnnotationPresent(CAAEvent.class)) {
                    if(method.getParameters().length != 1) {
                        Debugger.debugMessage("Illegal Event structure. Only use 1 argument per Event Method.");
                        return;
                    }
                    for(final Parameter parameter : method.getParameters()) {
                        if(Event.class.isAssignableFrom(parameter.getType())) {
                            if(parameter.getType().getName().equalsIgnoreCase(event.getClass().getName())) {
                                try {
                                    method.invoke(listener,event);
                                    Debugger.debugMessage("Method " + method.getName() + " fired!");
                                } catch (IllegalAccessException e) {
                                    Debugger.debugMessage("Method is inaccessible, please check the following lines.");
                                    e.printStackTrace();
                                } catch (InvocationTargetException e) {
                                    Debugger.debugMessage("Invalid method structure, please check the following lines.");
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }
    }


}
