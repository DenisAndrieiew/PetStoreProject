package com.goit.petStoreProject.controller.get.store;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.CommanderUtils;
import com.goit.petStoreProject.model.Data.Order;
import com.goit.petStoreProject.model.Utils;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class GetOrder implements Command {
    private final String APPENDIX = "order/";
    private CommanderUtils utils = new CommanderUtils();

    @Override
    public boolean execute() {
        utils.getView().write(commandDescription());
        utils.getView().write("input order id");
        long id = Long.parseLong(utils.getView().read());
        Type type = new TypeToken<Order>() {}.getType();
        Utils.get(String.format("%s%s%s%d", Utils.URL, Utils.STORE_SUFFIX, APPENDIX, id), type, utils.getView());
        return utils.isContinue();
    }


    @Override
    public String commandName() {
        return "order";
    }

    @Override
    public String commandDescription() {
        return "get order info";
    }


}
