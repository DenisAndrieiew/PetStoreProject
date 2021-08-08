package com.goit.petStoreProject.controller.get.user;

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

public class ByUsername implements Command {
    private CommanderUtils utils = new CommanderUtils();

    @Override
    public boolean execute() {
                utils.getView().write(commandName() + " " + commandDescription());
        utils.getView().write("Please, input username");
        String username = utils.getView().read();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(String.format
                ("%s%s%s", Utils.URL, Utils.USER_SUFFIX, username)))
                .GET().build();
        Gson gson = new Gson();

        HttpResponse response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int httpCode = response.statusCode();
            if (httpCode == 200) {
                User user = gson.fromJson(String.valueOf(response.body()), User.class);
                utils.getView().write(user.toString());

            } else {
                utils.getView().write("Oops, something gone wrong. Http code " + httpCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
