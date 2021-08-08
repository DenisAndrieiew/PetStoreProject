package com.goit.petStoreProject.controller.post;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.CommanderUtils;
import com.goit.petStoreProject.controller.post.user.PostUserCommands;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PostUser implements Command {
    private CommanderUtils utils = new CommanderUtils();

    @Override
    public boolean execute() {
        utils.run(commandDescription(),
                Arrays.stream(PostUserCommands.values()).map(PostUserCommands::getCommand)
                        .collect(Collectors.toList()));
        return true;
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
