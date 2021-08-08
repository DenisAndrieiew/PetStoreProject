package com.goit.petStoreProject.controller.post;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.CommanderUtils;
import com.goit.petStoreProject.model.Data.Order;
import com.goit.petStoreProject.model.Utils;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PostOrder implements Command {
    private CommanderUtils utils = new CommanderUtils();
    private final  String APPENDIX = "order";

    @Override
    public boolean execute() {
        Order order = Order.create(utils.getView());
        HttpClient client = HttpClient.newHttpClient();
        Gson gson = new Gson();
        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .uri(URI.create(String.format("%s%s%s", Utils.URL, Utils.STORE_SUFFIX, APPENDIX)))
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(order)))
                .build();
        HttpResponse response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            utils.getView().write(String.valueOf(response.statusCode()));
        } catch (IOException | InterruptedException e) {
            utils.getView().write(String.valueOf(response.statusCode()));
            e.printStackTrace();
        }
        System.out.println(response.body());



        return utils.isContinue();
    }

    @Override
    public String commandName() {
        return "order";
    }

    @Override
    public String commandDescription() {
        return "add new order";
    }
}
