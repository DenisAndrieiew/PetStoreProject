package com.goit.petStoreProject.controller;


import com.goit.petStoreProject.controller.delete.DeleteCommands;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Delete implements Command {
    CommanderUtils utils = new CommanderUtils();

    @Override
    public boolean execute() {
        utils.run(commandDescription(),
                Arrays.stream(DeleteCommands.values()).map(DeleteCommands::getCommand).collect(Collectors.toList()));
        return true;
    }

    @Override
    public String commandName() {
        return "delete";
    }

    @Override
    public String commandDescription() {
        return "delete record";
    }
}
