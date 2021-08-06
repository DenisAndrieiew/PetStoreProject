package com.goit.petStoreProject.view;

import java.util.Scanner;

public class Console implements View {
    private Scanner scanner;

    public Console() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }

    @Override
    public void write(String message) {
        System.out.println(message);
    }

    @Override
    public void writeL(String message) {
        System.out.print(message + "\t");
    }

}
