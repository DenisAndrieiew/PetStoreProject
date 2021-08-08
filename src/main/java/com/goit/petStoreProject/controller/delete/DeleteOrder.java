package com.goit.petStoreProject.controller.delete;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.CommanderUtils;
import com.goit.petStoreProject.model.Utils;

public class DeleteOrder implements Command {
    private CommanderUtils utils = new CommanderUtils();
    private final  String APPENDIX = "order/";


    @Override
    public boolean execute() {
        utils.getView().write(commandDescription());
        utils.getView().write("Please, input integer id for order");
        int id = Integer.parseInt(utils.getView().read());
        Utils.delete(String.format
                ("%s%s%s%d", Utils.URL, Utils.STORE_SUFFIX , APPENDIX, id), utils.getView());
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
