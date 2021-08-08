package com.goit.petStoreProject.controller.get.user;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.CommanderUtils;
import com.goit.petStoreProject.model.Data.User;
import com.goit.petStoreProject.model.Utils;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class ByUsername implements Command {
    private CommanderUtils utils = new CommanderUtils();

    @Override
    public boolean execute() {
        utils.getView().write(commandName() + " " + commandDescription());
        utils.getView().write("Please, input username");
        String username = utils.getView().read();
        Type type = new TypeToken<User>() {
        }.getType();
        Utils.get(String.format
                ("%s%s%s", Utils.URL, Utils.USER_SUFFIX, username), type, utils.getView());
        return utils.isContinue();
    }


    @Override
    public String commandName() {
        return "by_username";
    }

    @Override
    public String commandDescription() {
        return "find user by username";
    }
}
