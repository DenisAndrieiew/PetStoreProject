package com.goit.petStoreProject.controller.get;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.Help;
import com.goit.petStoreProject.view.Console;
import com.goit.petStoreProject.view.View;

import java.util.Arrays;

public enum GetCommands {
    HELP(new Help() {
        @Override
        public boolean execute() {
            View view = new Console();
            Arrays.stream(values()).forEach(command -> {
                view.write(command.getCommand().commandName() + " - " + command.getCommand().commandDescription());
            });
            view.write("exit - to exit to upper level");
            return true;
        }
    }),
    GET_PET(new GetPet()),
    GET_STORE(new GetStore()),
    GET_USER(new GetUser());
    private Command command;

    private GetCommands(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
