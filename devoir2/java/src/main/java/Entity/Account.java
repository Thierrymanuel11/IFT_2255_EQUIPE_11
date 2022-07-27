package main.java.Entity;

import main.java.enums.AccountRole;
import main.java.enums.AccountStatus;

public class Account {

    String email;
    String password;
    AccountStatus status;
    User user;
    AccountRole role;

    public Account(String email, String password, AccountStatus status, User user, AccountRole role){

        this.email = email;
        this.password = password;
        this.status = status;
        this.user = user;
        this.role = role;

    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User getUser() {
        return user;
    }

    public AccountStatus getStatus() {
        return status;
    }
}
