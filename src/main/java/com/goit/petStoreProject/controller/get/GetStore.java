package com.goit.petStoreProject.controller.get;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.view.Console;
import com.goit.petStoreProject.view.View;

public class GetStore implements Command {
    View view = new Console();

    @Override
    public boolean execute() {
        view.write(commandName() + " " + commandDescription());
        return false;
    }

    @Override
    public String commandName() {
        return "store";
    }

    @Override
    public String commandDescription() {
        return "get store info";
    }
}
