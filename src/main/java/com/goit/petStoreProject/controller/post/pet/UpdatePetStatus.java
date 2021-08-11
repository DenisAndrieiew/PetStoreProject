package com.goit.petStoreProject.controller.post.pet;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.CommanderUtils;
import com.goit.petStoreProject.model.Data.PetStatus;
import com.goit.petStoreProject.model.Utils;

public class UpdatePetStatus implements Command {
    private CommanderUtils utils = new CommanderUtils();

    @Override
    public boolean execute() {
        utils.getView().write("input pet id");
        long id = Long.parseLong(utils.getView().read());
        utils.getView().write("input new pet name");
        String name = utils.getView().read();
        String status = PetStatus.getStatus(utils.getView());
        String body = String.format("name=%s&status=%s", name, status);
        Utils.postFormData(String.format("%s%s%d", Utils.URL, Utils.PET_SUFFIX, id), body, utils.getView());
        return utils.isContinue();
    }

    @Override
    public String commandName() {
        return "update";
    }

    @Override
    public String commandDescription() {
        return "update name & status of pet by id";
    }
}
