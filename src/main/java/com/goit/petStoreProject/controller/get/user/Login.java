package com.goit.petStoreProject.controller.get.user;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.CommanderUtils;

public class Login implements Command {
    private CommanderUtils utils = new CommanderUtils();

    @Override
    public boolean execute() {
        return false;
    }

    @Override
    public String commandName() {
        return "login";
    }

    @Override
    public String commandDescription() {
        return "log in user";
    }
}
