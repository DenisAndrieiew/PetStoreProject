package com.goit.petStoreProject.controller;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MainController extends CommanderUtils {
    CommanderUtils utils = new CommanderUtils();


    public void run() {
        utils.run("Welcome to PetStore",
                Arrays.stream(MainCommands.values()).map(MainCommands::getCommand).collect(Collectors.toList()));
    }
}
