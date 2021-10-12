package org.example;

import org.example.DAO.UserDAO;
import org.example.models.User;
import org.example.services.UserService;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        User user = new User("Valod","val",2);
//        userService.saveUser(user);
        userService.findUser(1);
//        System.out.println(userDAO.findById(1).toString());
    }
}
