package com.goit.petStoreProject.controller.post.user;

import com.goit.petStoreProject.controller.Command;
import com.goit.petStoreProject.controller.CommanderUtils;
import com.goit.petStoreProject.model.Data.User;
import com.goit.petStoreProject.model.Utils;

import java.util.LinkedList;
import java.util.List;

public class CreateWithList implements Command {
    private static final String APPENDIX = "createWithList";
    private CommanderUtils utils = new CommanderUtils();

    @Override
    public boolean execute() {
        List<User> users = new LinkedList<>();
        while (true) {
            User user = User.create(utils.getView());
            users.add(user);
            utils.getView().write("add another user& [y/n]");
            if (utils.getView().read().equals("y")) {
                break;
            }
        }
        Utils.post(String.format("%s%s%s", Utils.URL, Utils.USER_SUFFIX, APPENDIX), users, utils.getView());
        return utils.isContinue();
    }

    @Override
    public String commandName() {
        return "list";
    }

    @Override
    public String commandDescription() {
        return "create Users with list";
    }
}