package com.goit.petStoreProject.controller.post;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.CommanderUtils;
import com.goit.petStoreProject.model.Data.Order;
import com.goit.petStoreProject.model.Utils;

public class PostOrder implements Command {
    private final String APPENDIX = "order";
    private CommanderUtils utils = new CommanderUtils();

    @Override
    public boolean execute() {
        Order order = Order.create(utils.getView());
        Utils.post(String.format("%s%s%s", Utils.URL, Utils.STORE_SUFFIX, APPENDIX), order, utils.getView());
        return utils.isContinue();
    }

    @Override
    public String commandName() {
        return "order";
    }

    @Override
    public String commandDescription() {
        return "add new order";
    }
}
