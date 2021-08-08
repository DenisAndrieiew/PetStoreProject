package com.goit.petStoreProject.controller.get.store;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.CommanderUtils;
import com.goit.petStoreProject.model.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class Inventory implements Command {
    private CommanderUtils utils = new CommanderUtils();
    private final String APPENDIX = "inventory";


    @Override
    public boolean execute() {
        utils.getView().write(commandDescription());
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(String.format
                ("%s%s%s", Utils.URL, Utils.STORE_SUFFIX, APPENDIX)))
                .GET().build();
        Gson gson = new Gson();
        Map<String, Long> inventory = new HashMap<String, Long>();
        Type mapType = new TypeToken<Map<String, Long>>() {
        }.getType();
        HttpResponse response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int httpCode = response.statusCode();
            if (httpCode == 200) {
                inventory = gson.fromJson(String.valueOf(response.body()), mapType);
                inventory.forEach((key, value) -> utils.getView().write(key + ": " + value.toString()));
            } else {
                utils.getView().write("Oops, something gone wrong. Http code " + httpCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return utils.isContinue();
    }


    @Override
    public String commandName() {
        return "inventory";
    }

    @Override
    public String commandDescription() {
        return "get store info";
    }
}
