package com.goit.petStoreProject.model;

import com.goit.petStoreProject.model.Data.ApiResponse;
import com.goit.petStoreProject.view.View;
import com.google.gson.Gson;
import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Utils {
    public static final String URL = "https://petstore.swagger.io/v2/";
    public static final String USER_SUFFIX = "user/";
    public static final String PET_SUFFIX = "pet/";
    public static final String STORE_SUFFIX = "store/";

    private static final OkHttpClient client = new OkHttpClient();

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
                list.forEach((object) -> view.write(object.toString()));
            } else {
                view.write("Oops, something gone wrong. Http code " + httpCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void postFile(String uri, File file, String text, View view) {
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("additionalMetadata", text)
                .addFormDataPart("file", "image",
                        RequestBody.create(file, MediaType.parse("application/octet-stream")))
                .build();
        Request request = new Request.Builder()
                .url(HttpUrl.get(uri))
                .post(requestBody)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            view.write(String.valueOf(response.code()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void postFormData(String uri, String body, View view) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
        try {
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            view.write(String.valueOf(response.statusCode()));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void post(String uri, Object object, View view) {
        HttpClient client = HttpClient.newHttpClient();
        Gson gson = new Gson();
        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .uri(URI.create(uri))
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(object)))
                .build();
        try {
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            view.write(String.valueOf(response.statusCode()));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void put(String uri, Object object, View view) {
        HttpClient client = HttpClient.newHttpClient();
        Gson gson = new Gson();
        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .uri(URI.create(uri))
                .PUT(HttpRequest.BodyPublishers.ofString(gson.toJson(object)))
                .build();
        HttpResponse response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            view.write(String.valueOf(response.statusCode()));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

