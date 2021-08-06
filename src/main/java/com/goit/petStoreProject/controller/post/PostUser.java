package com.goit.petStoreProject.controller.post;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.CommanderUtils;
import com.goit.petStoreProject.controller.get.pet.GetPetCommands;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PostUser implements Command {
    private CommanderUtils utils = new CommanderUtils();

    @Override
    public boolean execute() {
        utils.run(commandDescription(),
                Arrays.stream(GetPetCommands.values()).map(GetPetCommands::getCommand)
                        .collect(Collectors.toList()));
        return false;
    }

    @Override
    public String commandName() {
        return "user";
    }

    @Override
    public String commandDescription() {
        return "add simple user";
    }
}
