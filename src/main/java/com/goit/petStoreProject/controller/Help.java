package com.goit.petStoreProject.controller;

import com.goit.petStoreProject.view.Console;
import com.goit.petStoreProject.view.View;

public class Help implements Command {
    private final View view;

    public Help() {
        this.view = new Console();
    }

    @Override
    public boolean execute() {
        // Must be overrided in each enum of commands
//        Arrays.stream(values()).forEach(command -> {
//            view.write(command.getCommand().commandName() +" - "+ command.getCommand().commandDescription() );
//        });
//        view.write("exit -  to exit application");
        return true;
    }

    @Override
    public String commandName() {
        return "help";
    }

    @Override
    public String commandDescription() {
        return "show a list of commands";
    }
}
