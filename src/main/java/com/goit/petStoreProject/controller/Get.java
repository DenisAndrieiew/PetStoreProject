package com.goit.petStoreProject.controller;

import com.goit.petStoreProject.controller.get.GetCommands;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Get implements Command {
    CommanderUtils utils = new CommanderUtils();

    public Get() {
    }

    @Override
    public boolean execute() {
        utils.run(commandName() + " " + commandDescription(),
                Arrays.stream(GetCommands.values()).map(GetCommands::getCommand).collect(Collectors.toList()));
        return true;
    }


    @Override
    public String commandName() {
        return "get";
    }

    @Override
    public String commandDescription() {
        return "get some record(s)";
    }
}
