package com.goit.petStoreProject.model;

import com.goit.petStoreProject.model.Data.ApiResponse;
import com.goit.petStoreProject.view.View;
import com.google.gson.Gson;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static final String URL = "https://petstore.swagger.io/v2/";
    public static final String USER_SUFFIX = "user/";
    public static final String PET_SUFFIX = "pet/";
    public static final String STORE_SUFFIX = "store/";

    public static void delete(String uri, View view) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(uri))
                .DELETE().build();
        Gson gson = new Gson();
        ApiResponse response = null;
        try {
            response = gson.fromJson(String.valueOf(client.send(request, HttpResponse.BodyHandlers.ofString())
                    .body()), ApiResponse.class);

            if (response.getCode() == 200) {
                view.write("successfully deleted");
            } else {
                view.write("Oops, something gone wrong. Http code " + response.getCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void get(String uri, Type type, View view) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(uri))
                .GET().build();
        Gson gson = new Gson();
        try {
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int httpCode = response.statusCode();
            if (httpCode == 200) {
                Object object = gson.fromJson(String.valueOf(response.body()), type);
                view.write(object.toString());

            } else {
                view.write("Oops, something gone wrong. Http code " + httpCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
    public static void getList(String uri, Type type, View view) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(uri))
                .GET().build();
        Gson gson = new Gson();

        try {
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int httpCode = response.statusCode();
            if (httpCode == 200) {
                List<Object> list;
                list = gson.fromJson(String.valueOf(response.body()), type);
                list.forEach((object)->view.write(object.toString()));
            } else {
                view.write("Oops, something gone wrong. Http code " + httpCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}

