package com.goit.petStoreProject;

import com.goit.petStoreProject.controller.MainController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        MainController controller = new MainController();
        controller.run();
    }
}
