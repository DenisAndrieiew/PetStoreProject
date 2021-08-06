package com.goit.petStoreProject.controller;

import com.goit.petStoreProject.view.Console;
import com.goit.petStoreProject.view.View;

import java.util.Arrays;

public enum MainCommands {
    HELP(new Help() {
        @Override
        public boolean execute() {
            View view = new Console();
            Arrays.stream(values()).forEach(command -> {
                view.write(command.getCommand().commandName() + " - " + command.getCommand().commandDescription());
            });
            view.write("exit - to exit application");
            return true;
        }
    }),
    GET(new Get()),
    PUT(new Put()),
    POST(new Post()),
    DELETE(new Delete());
    private Command command;

    private MainCommands(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
