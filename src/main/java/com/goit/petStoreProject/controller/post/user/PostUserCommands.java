package com.goit.petStoreProject.controller.post.user;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.Help;
import com.goit.petStoreProject.view.Console;
import com.goit.petStoreProject.view.View;

import java.util.Arrays;

public enum PostUserCommands {
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
    CREATE_USER(new CreateUser()),
    CREATE_WITH_LIST(new CreateWithList()),
    CREATE_WITH_ARRAY(new CreateWithArray());
    private Command command;

    private PostUserCommands(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
