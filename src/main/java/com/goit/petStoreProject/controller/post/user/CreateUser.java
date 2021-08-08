package com.goit.petStoreProject.controller.post.user;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.CommanderUtils;
import com.goit.petStoreProject.model.Data.User;
import com.goit.petStoreProject.model.Utils;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CreateUser implements Command {
    private CommanderUtils utils = new CommanderUtils();
    private static final String SUFFIX = "user/";
    private static final String LIST_APPENDIX="";
    private static final String ARRAY_APPENDIX="";

    @Override
    public boolean execute() {
        User user = User.create(utils.getView());
        HttpClient client = HttpClient.newHttpClient();
        Gson gson = new Gson();
        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .uri(URI.create(String.format("%s%s", Utils.URL, SUFFIX)))
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(user)))
                .build();
        HttpResponse response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            utils.getView().write(String.valueOf(response.statusCode()));
        } catch (IOException e) {
            utils.getView().write(String.valueOf(response.statusCode()));
            e.printStackTrace();
        } catch (InterruptedException e) {
            utils.getView().write(String.valueOf(response.statusCode()));
            e.printStackTrace();
        }
        System.out.println(response.body());
        return true;
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
