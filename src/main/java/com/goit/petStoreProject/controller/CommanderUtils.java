package com.goit.petStoreProject.controller;

import com.goit.petStoreProject.view.Console;
import com.goit.petStoreProject.view.View;

import java.util.List;

public class CommanderUtils {
    private View view;
    private List<Command> commandList;

    public CommanderUtils() {
        view = new Console();
    }

    public void run(String text, List<Command> commandList) {
        this.commandList = commandList;
        view.write(text);
        doCommand();

    }


    private void doCommand() {
        boolean isNotExit = true;
        while (isNotExit) {
            view.write("Please enter a command or help to retrieve command list");
            String inputCommand = view.read().toLowerCase();
            if (inputCommand.equals("exit")) {
                break;
            }
            for (Command command : commandList) {
                if (command.canProcess(inputCommand)) {

                    isNotExit = command.execute();
                    break;
                }

            }
        }
    }

    ;

    public View getView() {
        return view;
    }


    public List<Command> getCommandList() {
        return commandList;
    }

    public void setCommandList(List<Command> commandList) {
        this.commandList = commandList;
    }
    public boolean isContinue(){
        view.write("Are you want to continue? [y/n]");
        while (true){
            String answer = view.read().toLowerCase();
            switch (answer){
                case "y":return true;
                case "n":return false;
            }
        }
    }
}
