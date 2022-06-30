package Controllers;

import Entity.Account;
import Entity.User;

import java.util.List;
import java.util.Scanner;

public class UserController {

    List<User> users;
    List<Account> accounts;

    public UserController(List<User> users) {

        this.users = users;
//        this.accounts = accounts;

    }

    public List<User> getAllUsers(){
        return users;
    }

    public boolean addUser(User user){
        users.add(user);
        return true;
    }

    public User getUserByName(String name) {
        for (User x : users) {
            if (name.equals(x.getFname())) return x;
        }
        return null;
    }

}
