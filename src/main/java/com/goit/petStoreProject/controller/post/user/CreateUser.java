package com.goit.petStoreProject.controller.post.user;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.CommanderUtils;
import com.goit.petStoreProject.model.Data.User;
import com.goit.petStoreProject.model.Utils;

public class CreateUser implements Command {
    private CommanderUtils utils = new CommanderUtils();

    @Override
    public boolean execute() {
        User user = User.create(utils.getView());
        Utils.post(String.format("%s%s", Utils.URL, Utils.USER_SUFFIX), user, utils.getView());
        return utils.isContinue();
    }

    @Override
    public String commandName() {
        return "new";
    }

    @Override
    public String commandDescription() {
        return "create new User";
    }
}
