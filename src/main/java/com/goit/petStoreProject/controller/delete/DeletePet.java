package com.goit.petStoreProject.controller.delete;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.CommanderUtils;
import com.goit.petStoreProject.model.Utils;

public class DeletePet implements Command {
    private CommanderUtils utils = new CommanderUtils();

    @Override
    public boolean execute() {
        utils.getView().write(commandDescription());
        utils.getView().write("Please, input integer id for pet");
        int id = Integer.parseInt(utils.getView().read());
        Utils.delete(String.format("%s%s%d", Utils.URL, Utils.PET_SUFFIX, id), utils.getView());
        return utils.isContinue();
    }

    @Override
    public String commandName() {
        return "pet";
    }

    @Override
    public String commandDescription() {
        return "delete pet by id";
    }
}
