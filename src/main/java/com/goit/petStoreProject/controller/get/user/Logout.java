package com.goit.petStoreProject.controller.get.user;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.CommanderUtils;
import com.goit.petStoreProject.model.Utils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Logout implements Command {
    private CommanderUtils utils = new CommanderUtils();
    private final String LOGOUT="logout";

    @Override
    public boolean execute() {
        utils.getView().write(commandName() + " " + commandDescription());
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(String.format
                ("%s%s%s", Utils.URL, Utils.USER_SUFFIX, LOGOUT)))
                .GET().build();

        HttpResponse response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int httpCode = response.statusCode();
            utils.getView().write(String.valueOf(httpCode));
            utils.getView().write(response.body().toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
