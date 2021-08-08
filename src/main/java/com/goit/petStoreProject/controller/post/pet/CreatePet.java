package com.goit.petStoreProject.controller.post.pet;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.CommanderUtils;
import com.goit.petStoreProject.model.Data.Pet;
import com.goit.petStoreProject.model.PetService;
import com.goit.petStoreProject.model.Utils;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CreatePet implements Command {
    private CommanderUtils utils = new CommanderUtils();

    @Override
    public boolean execute() {
        Pet pet = PetService.create(utils.getView());
        HttpClient client = HttpClient.newHttpClient();
        Gson gson = new Gson();
        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .uri(URI.create(String.format("%s%s", Utils.URL, Utils.PET_SUFFIX)))
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(pet)))
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
        return "create new pet";
    }
}
