package com.goit.petStoreProject.controller.delete;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.CommanderUtils;
import com.goit.petStoreProject.model.Utils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DeleteOrder implements Command {
    private CommanderUtils utils = new CommanderUtils();
    private final  String APPENDIX = "order/";


    @Override
    public boolean execute() {
        utils.getView().write(commandName() + " " + commandDescription());
        utils.getView().write("Please, input integer id for order");
        int id = Integer.parseInt(utils.getView().read());
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(String.format
                ("%s%s%s%d", Utils.URL, Utils.STORE_SUFFIX , APPENDIX, id)))
                .DELETE().build();

        HttpResponse response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int httpCode = response.statusCode();
            if (httpCode == 200) {
                utils.getView().write("successfully deleted");

            } else {
                utils.getView().write("Oops, something gone wrong. Http code " + httpCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return utils.isContinue();
    }

    @Override
    public String commandName() {
        return "order";
    }

    @Override
    public String commandDescription() {
        return "delete order by id";
    }
}
