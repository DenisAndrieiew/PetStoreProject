package com.goit.petStoreProject.controller.get.pet;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.Help;
import com.goit.petStoreProject.view.Console;
import com.goit.petStoreProject.view.View;

import java.util.Arrays;

public enum GetPetCommands {
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
    PET_BY_ID(new PetById()),
    PET_BY_STATUS(new PetByStatus());
    private Command command;

    private GetPetCommands(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}

