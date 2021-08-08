package com.goit.petStoreProject.controller.get.user;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.CommanderUtils;

public class ByUsername implements Command {
    private CommanderUtils utils = new CommanderUtils();

    @Override
    public boolean execute() {


        return false;
    }

    @Override
    public String commandName() {
        return "by_username";
    }

    @Override
    public String commandDescription() {
        return "find user by username";
    }
}
