package com.goit.petStoreProject.controller.get.pet;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.CommanderUtils;
import com.goit.petStoreProject.model.Data.Pet;
import com.goit.petStoreProject.model.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class PetById implements Command {
    private CommanderUtils utils = new CommanderUtils();
    private static final String SUFFIX = "pet/";


    @Override
    public boolean execute() {
        utils.getView().write(commandName() + " " + commandDescription());
        utils.getView().write("Please, input integer id for pet");
        int id = Integer.valueOf(utils.getView().read());
        Type type = new TypeToken<Pet>(){}.getType();
        Utils.get(String.format("%s%s%d", Utils.URL, SUFFIX, id), type, utils.getView());
        return utils.isContinue();
    }

    @Override
    public String commandName() {
        return "id";
    }

    @Override
    public String commandDescription() {
        return "find pet by id";
    }
}
