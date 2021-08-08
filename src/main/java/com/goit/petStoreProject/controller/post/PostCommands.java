package com.goit.petStoreProject.controller.post;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.Help;
import com.goit.petStoreProject.view.Console;
import com.goit.petStoreProject.view.View;

import java.util.Arrays;

public enum PostCommands {
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
    POST_USER(new PostUser()),
    POST_PET(new PostPet()),
    POST_ORDER(new PostOrder())

    ;
    private Command command;

    private PostCommands(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
