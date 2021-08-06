package com.goit.petStoreProject.model;

import com.google.gson.Gson;

import java.net.http.HttpClient;

public class Utils {
    public static final String URL = "https://petstore.swagger.io/v2/";

    protected static HttpClient httpClient = HttpClient.newBuilder().build();
    protected static Gson gson = new Gson();


}
