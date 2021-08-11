package com.goit.petStoreProject.controller.get.user;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.Help;
import com.goit.petStoreProject.view.Console;
import com.goit.petStoreProject.view.View;

import java.util.Arrays;

public enum GetUserCommands {
    HELP(new Help() {
        @Override
        public boolean execute() {
            View view = new Console();
            Arrays.stream(values()).forEach(command -> {
                view.write(command.getCommand().commandName() + " - " + command.getCommand().commandDescription());
            });
            view.write("exit - to exit to upper level");
            return true;
        }
    }),
    BY_USERNAME(new ByUsername()),
    LOGIN(new Login()),
    LOGOUT(new Logout());
    private Command command;

    private GetUserCommands(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
