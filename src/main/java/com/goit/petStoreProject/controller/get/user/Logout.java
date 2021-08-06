package com.goit.petStoreProject.controller.get.user;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.CommanderUtils;

public class Logout implements Command {
    private CommanderUtils utils = new CommanderUtils();

    @Override
    public boolean execute() {
        return false;
    }

    @Override
    public String commandName() {
        return "logout";
    }

    @Override
    public String commandDescription() {
        return "logout user";
    }
}
