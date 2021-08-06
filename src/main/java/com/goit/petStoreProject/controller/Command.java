package com.goit.petStoreProject.controller;

public interface Command {
    boolean execute();
    String commandName();
    String commandDescription();
    default boolean canProcess(String command) {
        return commandName().equals(command);
    }
}
