package com.goit.petStoreProject.model;

import com.goit.petStoreProject.model.Data.ApiResponse;
import com.goit.petStoreProject.view.View;
import com.google.gson.Gson;
import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class Utils {
    public static final String URL = "https://petstore.swagger.io/v2/";
    public static final String USER_SUFFIX = "user/";
    public static final String PET_SUFFIX = "pet/";
    public static final String STORE_SUFFIX = "store/";
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");


    private static final OkHttpClient client = new OkHttpClient();
    private static final Gson gson = new Gson();

    public static void delete(String uri, View view) {
        Request request = new Request.Builder()
                .url(HttpUrl.get(uri))
                .delete()
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            if (response.code() == 200) {
                ApiResponse apiResponse = gson.fromJson(response.body().string(), ApiResponse.class);
                view.write(apiResponse.toString());
            } else {
                view.write("Oops, something gone wrong. Http code " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void get(String uri, Type type, View view) {

        Request request = new Request.Builder()
                .url(HttpUrl.get(uri))
                .get()
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            if (response.code() == 200) {
                Object object = gson.fromJson(response.body().string(), type);
                view.write(object.toString());
            } else {
                view.write(String.valueOf(response.code()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getList(String uri, Type type, View view) {
        Request request = new Request.Builder()
                .url(HttpUrl.get(uri))
                .get()
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            if (response.code() == 200) {
                List<Object> list;
                list = gson.fromJson(response.body().string(), type);
                list.forEach((object) -> view.write(object.toString()));
            } else {
                view.write(String.valueOf(response.code()));
            }
        } catch (IOException e) {
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

    public static void postFormData(String uri, String name, String status, View view) {
        RequestBody requestBody = new FormBody.Builder()
                .add("name", name)
                .add("status", status)
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

    public static void post(String uri, Object object, View view) {
        RequestBody body = RequestBody.create(gson.toJson(object), JSON);
        Request request = new Request.Builder()
                .url(HttpUrl.get(uri))
                .post(body)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            view.write(String.valueOf(response.code()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void put(String uri, Object object, View view) {
        RequestBody body = RequestBody.create(gson.toJson(object), JSON);
        Request request = new Request.Builder()
                .url(HttpUrl.get(uri))
                .put(body)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            view.write(String.valueOf(response.code()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

