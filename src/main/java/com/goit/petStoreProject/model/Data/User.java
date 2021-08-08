package com.goit.petStoreProject.model.Data;

import com.goit.petStoreProject.view.View;

public class User {
    long id;
    String userName;
    String firstName;
    String lastName;
    String email;
    String password;
    String phone;
    int userStatus;

    public User(long id, String userName, String firstName, String lastName, String email, String password, String phone, int userStatus) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userStatus = userStatus;
    }

    public User() {
    }

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        return "{\n\tid=" + id +
                ",\n userName='" + userName + '\'' +
                ",\n firstName='" + firstName + '\'' +
                ",\n lastName='" + lastName + '\'' +
                ",\n email='" + email + '\'' +
                ",\t phone='" + phone + '\'' +
                ",\n password='" + password + '\'' +
                ",\n userStatus=" + userStatus +
                "\n\t}";
    }
}
