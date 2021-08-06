package com.goit.petStoreProject.controller;

import com.goit.petStoreProject.view.Console;
import com.goit.petStoreProject.view.View;

public class Put implements Command {
    private View view = new Console();

    @Override
    public boolean execute() {
        view.write(commandName() + " " + commandDescription());
        return true;
    }

    @Override
    public String commandName() {
        return "put";
    }

    @Override
    public String commandDescription() {
        return "update some record";
    }
}
