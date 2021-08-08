package com.goit.petStoreProject.controller.get.pet;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.CommanderUtils;
import com.goit.petStoreProject.model.Data.Pet;
import com.goit.petStoreProject.model.Data.PetStatus;
import com.goit.petStoreProject.model.Utils;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class PetByStatus implements Command {
    private static final String SUFFIX = "pet/findByStatus/?status=";
    private CommanderUtils utils = new CommanderUtils();

    @Override
    public boolean execute() {
        utils.getView().write(commandName() + " " + commandDescription());
        boolean isNotExit = true;
        List<PetStatus> statusList = Arrays.asList(PetStatus.values());
        String inputStatus = null;
        while (isNotExit) {
            utils.getView().write("Please, input status for pet, or exit to menu");
            for (PetStatus status : statusList) {
                utils.getView().writeL(status.name().toLowerCase(Locale.ROOT) + "\t");
            }
            utils.getView().write("or exit");

            inputStatus = utils.getView().read().toLowerCase();
            if (inputStatus.equals("exit")) {
                return true;
            } else {
                for (PetStatus status : statusList) {
                    if (inputStatus.equals(status.name().toLowerCase())) {
                        isNotExit = false;
                        break;
                    }
                }
            }
        }
        Type listType = new TypeToken<List<Pet>>() {
        }.getType();
        Utils.getList(String.format("%s%s%s", Utils.URL, SUFFIX, inputStatus), listType, utils.getView());
        return utils.isContinue();
    }

    @Override
    public String commandName() {
        return "status";
    }

    @Override
    public String commandDescription() {
        return "find pets by status";
    }
}
