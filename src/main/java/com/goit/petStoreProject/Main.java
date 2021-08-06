package com.goit.petStoreProject;

import com.goit.petStoreProject.controller.MainController;
import com.goit.petStoreProject.view.Console;
import com.goit.petStoreProject.view.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        View view = new Console();
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder(URI.create(Utils.URL + "pet/" + "11"))
//                .GET().build();
//        Gson gson = new Gson();
//
//        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        int httpCode = response.statusCode();
//        if (httpCode==200){
//        Pet pet = gson.fromJson(String.valueOf(response.body()), Pet.class);
//        view.write(pet.toString());}
//        else {
//            view.write("Oops, something gone wrong. Http code " + httpCode);
//        }
        MainController controller = new MainController();
        controller.run();

    }
}
