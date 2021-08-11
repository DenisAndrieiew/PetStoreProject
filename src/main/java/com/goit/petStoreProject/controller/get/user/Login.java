package com.goit.petStoreProject.controller.get.user;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.CommanderUtils;
import com.goit.petStoreProject.model.Data.ApiResponse;
import com.goit.petStoreProject.model.Utils;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class Login implements Command {
    private CommanderUtils utils = new CommanderUtils();

    @Override
    public boolean execute() {
        utils.getView().write(commandName() + " " + commandDescription());
        utils.getView().write("Please, input username");
        String username = utils.getView().read();
        utils.getView().write("enter password");
        String password = utils.getView().read();
        String appendix = String.format("login?username=%s&password=%s", username, password);
        Type type = new TypeToken<ApiResponse>() {
        }.getType();
        Utils.get(String.format
                ("%s%s%s", Utils.URL, Utils.USER_SUFFIX, appendix), type, utils.getView());
        return utils.isContinue();
    }

    @Override
    public String commandName() {
        return "login";
    }

    @Override
    public String commandDescription() {
        return "log in user";
    }
}
