package com.goit.petStoreProject.controller.get.store;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.CommanderUtils;
import com.goit.petStoreProject.controller.get.pet.GetPetCommands;
import com.goit.petStoreProject.model.Data.Order;
import com.goit.petStoreProject.model.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GetOrder implements Command {
    private CommanderUtils utils = new CommanderUtils();
    private final String APPENDIX = "order/";


    @Override
    public boolean execute() {
        utils.getView().write(commandDescription());
        utils.getView().write("input order id");
        long id = Long.parseLong(utils.getView().read());
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(String.format
                ("%s%s%s%d", Utils.URL, Utils.STORE_SUFFIX, APPENDIX, id)))
                .GET().build();
        Gson gson = new Gson();
        HttpResponse response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int httpCode = response.statusCode();
            if (httpCode == 200) {
Order order = gson.fromJson(String.valueOf(response.body()), Order.class);
utils.getView().write(order.toString());
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
        return "order";
    }

    @Override
    public String commandDescription() {
        return "get order info";
    }


}
