package com.goit.petStoreProject.controller.get;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.CommanderUtils;
import com.goit.petStoreProject.controller.get.user.GetUserCommands;

import java.util.Arrays;
import java.util.stream.Collectors;

public class GetUser implements Command {
    private CommanderUtils utils = new CommanderUtils();

    @Override
    public boolean execute() {
        utils.run(commandDescription(),
                Arrays.stream(GetUserCommands.values()).map(GetUserCommands::getCommand)
                        .collect(Collectors.toList()));
        return false;
    }

    @Override
    public String commandName() {
        return "user";
    }

    @Override
    public String commandDescription() {
        return "get user info";
    }
}
