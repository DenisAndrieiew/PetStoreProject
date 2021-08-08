package com.goit.petStoreProject.controller.get.user;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.CommanderUtils;
import com.goit.petStoreProject.model.Data.ApiResponse;
import com.goit.petStoreProject.model.Utils;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.http.HttpClient;

public class Logout implements Command {
    private CommanderUtils utils = new CommanderUtils();
    private final String LOGOUT="logout";

    @Override
    public boolean execute() {
        utils.getView().write(commandName() + " " + commandDescription());
        Type type = new TypeToken<ApiResponse>(){}.getType();
        Utils.get(String.format
                ("%s%s%s", Utils.URL, Utils.USER_SUFFIX, LOGOUT), type, utils.getView());
        HttpClient client = HttpClient.newHttpClient();
        return utils.isContinue();
    }

    @Override
    public String commandName() {
        return "logout";
    }

    @Override
    public String commandDescription() {
        return "logout user";
    }
}
