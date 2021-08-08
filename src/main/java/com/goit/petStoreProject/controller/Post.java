package com.goit.petStoreProject.controller;

import com.goit.petStoreProject.controller.post.PostCommands;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Post implements Command {
private CommanderUtils utils = new CommanderUtils();
    @Override
    public boolean execute() {
        utils.run(commandDescription(),
                Arrays.stream(PostCommands.values()).map(PostCommands::getCommand).collect(Collectors.toList()));
        return true;
    }

    @Override
    public String commandName() {
        return "post";
    }

    @Override
    public String commandDescription() {
        return "add new record";
    }
}
