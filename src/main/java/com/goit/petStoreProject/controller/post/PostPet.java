package com.goit.petStoreProject.controller.post;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.CommanderUtils;
import com.goit.petStoreProject.controller.post.pet.PostPetCommands;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PostPet implements Command {
    private CommanderUtils utils = new CommanderUtils();

    @Override
    public boolean execute() {
        utils.run(commandDescription(),
                Arrays.stream(PostPetCommands.values()).map(PostPetCommands::getCommand)
                        .collect(Collectors.toList()));
        return true;
    }

    @Override
    public String commandName() {
        return "pet";
    }

    @Override
    public String commandDescription() {
        return "add pet";
    }
}
