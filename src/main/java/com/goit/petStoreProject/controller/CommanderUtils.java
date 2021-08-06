package com.goit.petStoreProject.controller;

import com.goit.petStoreProject.view.Console;
import com.goit.petStoreProject.view.View;

import java.util.List;

public class CommanderUtils {
    private View view;
    private List<Command> commandList;
    private int level = 0;

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
}
