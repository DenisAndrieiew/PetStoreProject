package com.goit.petStoreProject.controller.put;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.CommanderUtils;
import com.goit.petStoreProject.model.Data.Pet;
import com.goit.petStoreProject.model.Utils;

public class PutPet implements Command {
    private CommanderUtils utils = new CommanderUtils();

    @Override
    public boolean execute() {
        Pet pet = Pet.create(utils.getView());
        Utils.put(String.format("%s%s", Utils.URL, Utils.PET_SUFFIX), pet, utils.getView());
        return utils.isContinue();
    }

    @Override
    public String commandName() {
        return "pet";
    }

    @Override
    public String commandDescription() {
        return "update existing pet";
    }
}
