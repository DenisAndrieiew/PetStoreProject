package com.goit.petStoreProject.model;

import com.goit.petStoreProject.model.Data.User;
import com.goit.petStoreProject.view.View;

public class UserService {


    public static User create(View view) {
        User user = new User();
        view.write("input id");
        long id = Integer.valueOf(view.read());
        view.write("input username");
        String username = view.read();
        view.write("Input firstname");
        String firstname = view.read();
        view.write("Input lastname");
        String lastname = view.read();
        view.write("Input phone number");
        String phone = view.read();
        view.write("Input email");
        String email = view.read();
        view.write(("input password for user"));
        String password = view.read();
        int userStatus = 0;
        user.setId(id);
        user.setUserName(username);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setEmail(email);
        user.setPhone(phone);
        user.setUserStatus(userStatus);
        user.setPassword(password);
        return user;
    }
}
