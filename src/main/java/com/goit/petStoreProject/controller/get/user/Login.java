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

public class Login implements Command {
    private CommanderUtils utils = new CommanderUtils();

    @Override
    public boolean execute() {
        utils.getView().write(commandName() + " " + commandDescription());
        utils.getView().write("Please, input username");
        String username = utils.getView().read();
        utils.getView().write("enter password");
        String password = utils.getView().read();
        String appendix = String.format("login?username=%s&password=%s",username,password);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(String.format
                ("%s%s%s", Utils.URL, Utils.USER_SUFFIX, appendix)))
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
        return "login";
    }

    @Override
    public String commandDescription() {
        return "log in user";
    }
}
