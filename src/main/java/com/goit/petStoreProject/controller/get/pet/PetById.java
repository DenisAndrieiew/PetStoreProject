package com.goit.petStoreProject.controller.get.pet;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.CommanderUtils;
import com.goit.petStoreProject.model.Data.Pet;
import com.goit.petStoreProject.model.Utils;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PetById implements Command {
    private CommanderUtils utils = new CommanderUtils();

    @Override
    public boolean execute() {
        utils.getView().write(commandName() + " " + commandDescription());
        utils.getView().write("Please, input integer id for pet");
        int id = Integer.valueOf(utils.getView().read());
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(String.format("%s%s%d", Utils.URL, "pet/", id)))
                .GET().build();
        Gson gson = new Gson();

        HttpResponse response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int httpCode = response.statusCode();
            if (httpCode == 200) {
                Pet pet = gson.fromJson(String.valueOf(response.body()), Pet.class);
                utils.getView().write(pet.toString());

            } else {
                utils.getView().write("Oops, something gone wrong. Http code " + httpCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
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
