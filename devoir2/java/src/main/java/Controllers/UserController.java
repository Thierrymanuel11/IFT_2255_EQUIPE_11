package main.java.Controllers;

import main.java.Entity.Account;
import main.java.Entity.Interest;
import main.java.Entity.Professor;
import main.java.Entity.User;
import main.java.enums.AccountRole;
import main.java.enums.AccountStatus;
import main.java.enums.UserTitle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserController {

    List<User> users;
    List<Account> accounts;

    public UserController(List<User> users, List<Account> accounts) {

        this.users = users;
        this.accounts = accounts;

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

    public List<User> getUsersByInterest(Interest interest) {

        List<User> result = new ArrayList<>();

        for (User user: this.users) {
            for (Interest userInterest: user.getInterest()) {
                if (userInterest.equals(interest)) {
                    result.add(user);
                }
            }
        }

        return result;
    }

    public User login(String email, String passord) {

        for (Account account: this.accounts) {
            if (account.getEmail().equals(email)) {
                if (account.getPassword().equals(passord)) {
                    return account.getUser();
                }
            }
        }

        return null;

    }

    public boolean createAccount(String fname, String lname, String email, String tel, String password,
                                 User professor) {
        User newUser = new User(users.size(), fname, lname, null, null, null,
                UserTitle.Master, email);

        this.users.add(newUser);
        this.accounts.add(new Account(email, password, AccountStatus.PENDING, newUser, AccountRole.Member));
        return true;
    }

}
