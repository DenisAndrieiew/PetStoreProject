package com.goit.petStoreProject.controller.get;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.CommanderUtils;
import com.goit.petStoreProject.controller.get.store.GetStoreCommands;

import java.util.Arrays;
import java.util.stream.Collectors;

public class GetStore implements Command {
    private CommanderUtils utils = new CommanderUtils();

    @Override
    public boolean execute() {
        utils.run(commandDescription(),
                Arrays.stream(GetStoreCommands.values()).map(GetStoreCommands::getCommand)
                        .collect(Collectors.toList()));
        return false;
    }

    @Override
    public String commandName() {
        return "store";
    }

    @Override
    public String commandDescription() {
        return "to control inventory & orders";
    }
}
