package com.goit.petStoreProject.controller;

import com.goit.petStoreProject.controller.put.PutCommands;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Put implements Command {
    private CommanderUtils utils = new CommanderUtils();

    @Override
    public boolean execute() {
        utils.run(commandDescription(),
                Arrays.stream(PutCommands.values()).map(PutCommands::getCommand).collect(Collectors.toList()));
        return true;
    }

    @Override
    public String commandName() {
        return "put";
    }

    @Override
    public String commandDescription() {
        return "update some record";
    }
}
