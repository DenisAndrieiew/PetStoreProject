package com.goit.petStoreProject.model.Data;

import com.goit.petStoreProject.view.View;

import java.util.Arrays;

public enum PetStatus {
    AVAILABLE,
    PENDING,
    SOLD;

    public static String getStatus(View view) {
        view.write("input status");
        view.writeL("choose from:");

        String inputStatus = null;
        boolean isExit = true;
        while (isExit) {
            Arrays.stream(PetStatus.values()).forEach(status -> {
                view.writeL('\t' + status.name().toLowerCase());
            });
            view.write("");
            inputStatus = view.read().toLowerCase();
            for (PetStatus status : PetStatus.values()) {
                if (inputStatus.equals(status.name().toLowerCase())) {
                    isExit = false;
                    break;
                }

            }
        }
        return inputStatus;
    }
}
